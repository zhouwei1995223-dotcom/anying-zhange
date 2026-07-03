param(
    [string] $Root = (Resolve-Path (Join-Path $PSScriptRoot '..')).Path,
    [string] $SourceRoot = '',
    [string] $OutputRoot = '',
    [string] $PreviewPath = ''
)

Set-StrictMode -Version Latest
$ErrorActionPreference = 'Stop'

Add-Type -AssemblyName System.Drawing
Add-Type -AssemblyName System.IO.Compression.FileSystem

$Utf8NoBom = New-Object System.Text.UTF8Encoding($false)
$CellSize = 150
$RoleNames = @{
    '00' = @{ profession = 0; professionName = 'ranger'; sex = 0; sexName = 'male' }
    '01' = @{ profession = 0; professionName = 'ranger'; sex = 1; sexName = 'female' }
    '10' = @{ profession = 1; professionName = 'mage'; sex = 0; sexName = 'male' }
    '11' = @{ profession = 1; professionName = 'mage'; sex = 1; sexName = 'female' }
    '20' = @{ profession = 2; professionName = 'warrior'; sex = 0; sexName = 'male' }
    '21' = @{ profession = 2; professionName = 'warrior'; sex = 1; sexName = 'female' }
}

if ([string]::IsNullOrWhiteSpace($SourceRoot)) {
    $legacyRoot = Get-ChildItem -LiteralPath $Root -Directory |
        Where-Object { Test-Path -LiteralPath (Join-Path $_.FullName 'client\pak\hero') } |
        Select-Object -First 1
    if (-not $legacyRoot) {
        throw "Could not locate legacy client\pak\hero under $Root. Pass -SourceRoot explicitly."
    }
    $SourceRoot = Join-Path $legacyRoot.FullName 'client\pak\hero'
}
if ([string]::IsNullOrWhiteSpace($OutputRoot)) {
    $OutputRoot = Join-Path $Root 'cocos-remake\assets\resources\heroes'
}
if ([string]::IsNullOrWhiteSpace($PreviewPath)) {
    $PreviewPath = Join-Path $Root 'HERO_CATALOG.png'
}

function Read-U16([byte[]] $Bytes, [ref] $Pos) {
    $value = [BitConverter]::ToUInt16($Bytes, $Pos.Value)
    $Pos.Value += 2
    return $value
}

function Read-U32([byte[]] $Bytes, [ref] $Pos) {
    $value = [BitConverter]::ToUInt32($Bytes, $Pos.Value)
    $Pos.Value += 4
    return $value
}

function Convert-Rgb555ToArgb([int] $Color) {
    $r = (($Color -shr 10) -band 0x1f) -shl 3
    $g = (($Color -shr 5) -band 0x1f) -shl 3
    $b = ($Color -band 0x1f) -shl 3
    return [int](0xff000000 -bor ($r -shl 16) -bor ($g -shl 8) -bor $b)
}

function Convert-Rgb555ToRgb([int] $Color) {
    $r = (($Color -shr 10) -band 0x1f) -shl 3
    $g = (($Color -shr 5) -band 0x1f) -shl 3
    $b = ($Color -band 0x1f) -shl 3
    return [int](($r -shl 16) -bor ($g -shl 8) -bor $b)
}

function Decode-OldImg([byte[]] $Bytes) {
    $pos = [ref] 0
    $payloadLength = Read-U32 $Bytes $pos
    if ($payloadLength -ne ($Bytes.Length - 4)) {
        throw "Unexpected payload length $payloadLength for $($Bytes.Length) bytes."
    }

    $type = $Bytes[$pos.Value]
    $pos.Value += 1
    $width = Read-U16 $Bytes $pos
    $height = Read-U16 $Bytes $pos
    $pixels = New-Object int[] ($width * $height)

    if ($type -eq 1) {
        for ($y = 0; $y -lt $height; $y++) {
            for ($x = 0; $x -lt $width; $x++) {
                $pixels[$y * $width + $x] = Convert-Rgb555ToArgb (Read-U16 $Bytes $pos)
            }
        }
    }
    elseif ($type -eq 2 -or $type -eq 3) {
        $rows = New-Object object[] $height
        for ($y = 0; $y -lt $height; $y++) {
            $count = Read-U16 $Bytes $pos
            $row = New-Object int[] $count
            for ($i = 0; $i -lt $count; $i++) {
                $row[$i] = Read-U16 $Bytes $pos
            }
            $rows[$y] = $row
        }

        if ($type -eq 3) {
            [void] (Read-U16 $Bytes $pos)
        }

        $srcY = 0
        $dstY = 0
        while ($srcY -lt $height -and $dstY -lt $height) {
            $row = [int[]] $rows[$srcY]
            $x = 0
            $dstIndex = $dstY * $width
            for ($i = 0; $x -lt $width -and $i -lt $row.Length; $i++) {
                $command = $row[$i]
                $op = $command -band 0xf000
                $length = $command -band 0x0fff

                if ($op -eq 0x3000) {
                    $srcY += $length
                    $dstY += $length
                }
                elseif ($op -eq 0x2000) {
                    $x += $length
                    $dstIndex += $length
                }
                elseif ($op -eq 0x1000) {
                    for ($j = 0; $j -lt $length -and $x -lt $width; $j++) {
                        $i += 1
                        $pixels[$dstIndex] = Convert-Rgb555ToArgb $row[$i]
                        $x += 1
                        $dstIndex += 1
                    }
                }
                elseif ($op -eq 0x4000) {
                    for ($j = 0; $j -lt $length -and $x -lt $width; $j++) {
                        $i += 1
                        $alpha = (($row[$i] -band 0x1f) -shl 3)
                        $i += 1
                        $rgb = Convert-Rgb555ToRgb $row[$i]
                        $pixels[$dstIndex] = [int](($alpha -shl 24) -bor $rgb)
                        $x += 1
                        $dstIndex += 1
                    }
                }
            }

            $srcY += 1
            $dstY += 1
        }
    }
    else {
        throw "Unsupported legacy img type: $type"
    }

    return [pscustomobject]@{
        Type = $type
        Width = $width
        Height = $height
        Pixels = $pixels
    }
}

function Read-ZipEntryBytes($Entry) {
    $stream = $Entry.Open()
    try {
        $buffer = New-Object byte[] $Entry.Length
        $offset = 0
        while ($offset -lt $buffer.Length) {
            $read = $stream.Read($buffer, $offset, $buffer.Length - $offset)
            if ($read -le 0) { break }
            $offset += $read
        }
        return $buffer
    }
    finally {
        $stream.Dispose()
    }
}

function Get-ExistingUuid([string] $MetaPath) {
    if (Test-Path -LiteralPath $MetaPath) {
        try {
            $json = Get-Content -LiteralPath $MetaPath -Raw | ConvertFrom-Json
            if ($json.uuid) { return [string] $json.uuid }
        }
        catch {
        }
    }
    return [guid]::NewGuid().ToString()
}

function Write-JsonText([string] $Path, $Data) {
    $json = $Data | ConvertTo-Json -Depth 64
    [System.IO.File]::WriteAllText($Path, $json, $Utf8NoBom)
}

function Write-DirectoryMeta([string] $DirectoryPath) {
    $metaPath = "$DirectoryPath.meta"
    if (Test-Path -LiteralPath $metaPath) { return }
    $meta = [ordered]@{
        ver = '1.2.0'
        importer = 'directory'
        imported = $true
        uuid = [guid]::NewGuid().ToString()
        files = @()
        subMetas = [ordered]@{}
        userData = [ordered]@{}
    }
    Write-JsonText $metaPath $meta
}

function Ensure-AssetDirectory([string] $DirectoryPath) {
    New-Item -ItemType Directory -Force -Path $DirectoryPath | Out-Null
    Write-DirectoryMeta $DirectoryPath
}

function Write-ImageMeta([string] $PngPath, [string] $DisplayName, [int] $Width, [int] $Height) {
    $metaPath = "$PngPath.meta"
    $uuid = Get-ExistingUuid $metaPath
    $halfW = $Width / 2
    $halfH = $Height / 2
    $meta = [ordered]@{
        ver = '1.0.27'
        importer = 'image'
        imported = $true
        uuid = $uuid
        files = @('.json', '.png')
        subMetas = [ordered]@{
            '6c48a' = [ordered]@{
                importer = 'texture'
                uuid = "$uuid@6c48a"
                displayName = $DisplayName
                id = '6c48a'
                name = 'texture'
                userData = [ordered]@{
                    wrapModeS = 'clamp-to-edge'
                    wrapModeT = 'clamp-to-edge'
                    imageUuidOrDatabaseUri = $uuid
                    isUuid = $true
                    visible = $false
                    minfilter = 'linear'
                    magfilter = 'linear'
                    mipfilter = 'none'
                    anisotropy = 0
                }
                ver = '1.0.22'
                imported = $true
                files = @('.json')
                subMetas = [ordered]@{}
            }
            'f9941' = [ordered]@{
                importer = 'sprite-frame'
                uuid = "$uuid@f9941"
                displayName = $DisplayName
                id = 'f9941'
                name = 'spriteFrame'
                userData = [ordered]@{
                    trimThreshold = 1
                    rotated = $false
                    offsetX = 0
                    offsetY = 0
                    trimX = 0
                    trimY = 0
                    width = $Width
                    height = $Height
                    rawWidth = $Width
                    rawHeight = $Height
                    borderTop = 0
                    borderBottom = 0
                    borderLeft = 0
                    borderRight = 0
                    packable = $true
                    pixelsToUnit = 100
                    pivotX = 0.5
                    pivotY = 0.5
                    meshType = 0
                    vertices = [ordered]@{
                        rawPosition = @(-$halfW, -$halfH, 0, $halfW, -$halfH, 0, -$halfW, $halfH, 0, $halfW, $halfH, 0)
                        indexes = @(0, 1, 2, 2, 1, 3)
                        uv = @(0, $Height, $Width, $Height, 0, 0, $Width, 0)
                        nuv = @(0, 0, 1, 0, 0, 1, 1, 1)
                        minPos = @(-$halfW, -$halfH, 0)
                        maxPos = @($halfW, $halfH, 0)
                    }
                    isUuid = $true
                    imageUuidOrDatabaseUri = "$uuid@6c48a"
                    atlasUuid = ''
                    trimType = 'custom'
                }
                ver = '1.0.12'
                imported = $true
                files = @('.json')
                subMetas = [ordered]@{}
            }
        }
        userData = [ordered]@{
            type = 'sprite-frame'
            fixAlphaTransparencyArtifacts = $false
            hasAlpha = $true
            redirect = "$uuid@6c48a"
        }
    }
    Write-JsonText $metaPath $meta
}

function Write-JsonAssetMeta([string] $JsonPath) {
    $metaPath = "$JsonPath.meta"
    $uuid = Get-ExistingUuid $metaPath
    $meta = [ordered]@{
        ver = '2.0.1'
        importer = 'json'
        imported = $true
        uuid = $uuid
        files = @('.json')
        subMetas = [ordered]@{}
        userData = [ordered]@{}
    }
    Write-JsonText $metaPath $meta
}

function New-BitmapFromDecoded($Decoded) {
    $bitmap = New-Object System.Drawing.Bitmap $Decoded.Width, $Decoded.Height, ([System.Drawing.Imaging.PixelFormat]::Format32bppArgb)
    $rect = New-Object System.Drawing.Rectangle 0, 0, $Decoded.Width, $Decoded.Height
    $data = $bitmap.LockBits($rect, [System.Drawing.Imaging.ImageLockMode]::WriteOnly, [System.Drawing.Imaging.PixelFormat]::Format32bppArgb)
    try {
        $bytes = New-Object byte[] ($Decoded.Width * $Decoded.Height * 4)
        for ($i = 0; $i -lt $Decoded.Pixels.Length; $i++) {
            $color = $Decoded.Pixels[$i]
            $offset = $i * 4
            $bytes[$offset] = [byte]($color -band 0xff)
            $bytes[$offset + 1] = [byte](($color -shr 8) -band 0xff)
            $bytes[$offset + 2] = [byte](($color -shr 16) -band 0xff)
            $bytes[$offset + 3] = [byte](($color -shr 24) -band 0xff)
        }
        [Runtime.InteropServices.Marshal]::Copy($bytes, 0, $data.Scan0, $bytes.Length)
    }
    finally {
        $bitmap.UnlockBits($data)
    }
    return $bitmap
}

function Save-FramePng($SheetBitmap, [int] $SourceX, [int] $SourceY, [string] $OutputPath) {
    if ((Test-Path -LiteralPath $OutputPath) -and (Test-Path -LiteralPath "$OutputPath.meta")) {
        return
    }
    $bitmap = New-Object System.Drawing.Bitmap $CellSize, $CellSize, ([System.Drawing.Imaging.PixelFormat]::Format32bppArgb)
    $graphics = [System.Drawing.Graphics]::FromImage($bitmap)
    try {
        $graphics.Clear([System.Drawing.Color]::FromArgb(0, 0, 0, 0))
        $graphics.InterpolationMode = [System.Drawing.Drawing2D.InterpolationMode]::NearestNeighbor
        $graphics.PixelOffsetMode = [System.Drawing.Drawing2D.PixelOffsetMode]::Half
        $dst = New-Object System.Drawing.Rectangle 0, 0, $CellSize, $CellSize
        $src = New-Object System.Drawing.Rectangle $SourceX, $SourceY, $CellSize, $CellSize
        $graphics.DrawImage($SheetBitmap, $dst, $src, [System.Drawing.GraphicsUnit]::Pixel)
        $bitmap.Save($OutputPath, [System.Drawing.Imaging.ImageFormat]::Png)
    }
    finally {
        $graphics.Dispose()
        $bitmap.Dispose()
    }
    Write-ImageMeta $OutputPath ([System.IO.Path]::GetFileNameWithoutExtension($OutputPath)) $CellSize $CellSize
}

function Save-MirroredFramePng([string] $SourcePath, [string] $OutputPath) {
    $dir = Split-Path -Parent $OutputPath
    Ensure-AssetDirectory $dir
    $source = [System.Drawing.Bitmap]::FromFile($SourcePath)
    $bitmap = $null
    try {
        $bitmap = New-Object System.Drawing.Bitmap $source
        $bitmap.RotateFlip([System.Drawing.RotateFlipType]::RotateNoneFlipX)
        $bitmap.Save($OutputPath, [System.Drawing.Imaging.ImageFormat]::Png)
    }
    finally {
        if ($bitmap) { $bitmap.Dispose() }
        $source.Dispose()
    }
    Write-ImageMeta $OutputPath ([System.IO.Path]::GetFileNameWithoutExtension($OutputPath)) $CellSize $CellSize
}

function Import-DirectionalAction($Decoded, [string] $ActionDir, [string] $ActionName) {
    $cols = [Math]::Floor($Decoded.Width / $CellSize)
    $rows = [Math]::Floor($Decoded.Height / $CellSize)
    if ($cols -lt 1 -or $rows -lt 1) {
        throw "$ActionName sheet has invalid size $($Decoded.Width)x$($Decoded.Height)."
    }
    $dirs = [Math]::Min(8, $rows)
    $sheetBitmap = New-BitmapFromDecoded $Decoded
    try {
        for ($dir = 0; $dir -lt $dirs; $dir++) {
            $dirPath = Join-Path $ActionDir "d$dir"
            Ensure-AssetDirectory $dirPath
            for ($frame = 0; $frame -lt $cols; $frame++) {
                $name = '{0}_{1:00}.png' -f $ActionName, $frame
                Save-FramePng $sheetBitmap ($frame * $CellSize) ($dir * $CellSize) (Join-Path $dirPath $name)
            }
        }
    }
    finally {
        $sheetBitmap.Dispose()
    }
    $mirrorPairs = @(
        @{ source = 3; target = 5 },
        @{ source = 2; target = 6 },
        @{ source = 1; target = 7 }
    )
    foreach ($pair in $mirrorPairs) {
        if ($dirs -le $pair.source) { continue }
        $sourceDir = Join-Path $ActionDir "d$($pair.source)"
        $targetDir = Join-Path $ActionDir "d$($pair.target)"
        Ensure-AssetDirectory $targetDir
        for ($frame = 0; $frame -lt $cols; $frame++) {
            $name = '{0}_{1:00}.png' -f $ActionName, $frame
            Save-MirroredFramePng (Join-Path $sourceDir $name) (Join-Path $targetDir $name)
        }
    }
    return [ordered]@{
        frameCount = $cols
        directionCount = [Math]::Max($dirs, 8)
        sourceWidth = $Decoded.Width
        sourceHeight = $Decoded.Height
    }
}

function Import-FlatAction($Decoded, [string] $ActionDir, [string] $ActionName) {
    $cols = [Math]::Floor($Decoded.Width / $CellSize)
    $rows = [Math]::Floor($Decoded.Height / $CellSize)
    if ($cols -lt 1 -or $rows -lt 1) {
        throw "$ActionName sheet has invalid size $($Decoded.Width)x$($Decoded.Height)."
    }
    $index = 0
    $sheetBitmap = New-BitmapFromDecoded $Decoded
    try {
        for ($row = 0; $row -lt $rows; $row++) {
            for ($col = 0; $col -lt $cols; $col++) {
                $name = '{0}_{1:00}.png' -f $ActionName, $index
                Save-FramePng $sheetBitmap ($col * $CellSize) ($row * $CellSize) (Join-Path $ActionDir $name)
                $index += 1
            }
        }
    }
    finally {
        $sheetBitmap.Dispose()
    }
    return [ordered]@{
        frameCount = $index
        directionCount = 1
        sourceWidth = $Decoded.Width
        sourceHeight = $Decoded.Height
    }
}

function Test-FrameSet([string] $BaseDir, [string] $ActionName, [int] $Directions, [int] $FramesPerDirection) {
    for ($dir = 0; $dir -lt $Directions; $dir++) {
        $dirPath = Join-Path $BaseDir "$ActionName\d$dir"
        for ($frame = 0; $frame -lt $FramesPerDirection; $frame++) {
            $path = Join-Path $dirPath ('{0}_{1:00}.png' -f $ActionName, $frame)
            if (-not (Test-Path -LiteralPath $path) -or -not (Test-Path -LiteralPath "$path.meta")) {
                return $false
            }
        }
    }
    return $true
}

function Test-FlatFrameSet([string] $BaseDir, [string] $ActionName, [int] $FrameCount) {
    $actionDir = Join-Path $BaseDir $ActionName
    for ($frame = 0; $frame -lt $FrameCount; $frame++) {
        $path = Join-Path $actionDir ('{0}_{1:00}.png' -f $ActionName, $frame)
        if (-not (Test-Path -LiteralPath $path) -or -not (Test-Path -LiteralPath "$path.meta")) {
            return $false
        }
    }
    return $true
}

function Test-HeroAppearanceImported([string] $AppearanceDir) {
    return (Test-FrameSet $AppearanceDir 'idle' 8 4) -and
        (Test-FrameSet $AppearanceDir 'walk' 8 6) -and
        (Test-FrameSet $AppearanceDir 'attack' 8 8) -and
        (Test-FlatFrameSet $AppearanceDir 'death' 1)
}

function Repair-HeroMirroredDirections([string] $AppearanceDir) {
    $mirrorPairs = @(
        @{ source = 3; target = 5 },
        @{ source = 2; target = 6 },
        @{ source = 1; target = 7 }
    )
    foreach ($actionName in @('idle', 'walk', 'attack')) {
        $actionDir = Join-Path $AppearanceDir $actionName
        if (-not (Test-Path -LiteralPath $actionDir)) { continue }
        foreach ($pair in $mirrorPairs) {
            $sourceDir = Join-Path $actionDir "d$($pair.source)"
            $targetDir = Join-Path $actionDir "d$($pair.target)"
            if (-not (Test-Path -LiteralPath $sourceDir)) { continue }
            Ensure-AssetDirectory $targetDir
            foreach ($sourceFrame in Get-ChildItem -LiteralPath $sourceDir -Filter '*.png' | Sort-Object Name) {
                Save-MirroredFramePng $sourceFrame.FullName (Join-Path $targetDir $sourceFrame.Name)
            }
        }
    }
}

function New-StandardAppearanceCatalog([string] $RoleId, [int] $AppearanceId, [string] $ZipName) {
    return [ordered]@{
        id = $AppearanceId
        suggestedArmorLevel = if ($AppearanceId -eq 0) { 0 } else { $AppearanceId * 36 }
        zip = $ZipName
        path = "heroes/hero_$RoleId/appearance_$AppearanceId"
        actions = [ordered]@{
            idle = [ordered]@{ frameCount = 4; directionCount = 8; sourceWidth = 600; sourceHeight = 1200 }
            walk = [ordered]@{ frameCount = 6; directionCount = 8; sourceWidth = 900; sourceHeight = 1200 }
            attack = [ordered]@{ frameCount = 8; directionCount = 8; sourceWidth = 1200; sourceHeight = 1200 }
            death = [ordered]@{ frameCount = 1; directionCount = 1; sourceWidth = 150; sourceHeight = 150 }
        }
    }
}

function Import-HeroZip([string] $RoleId, [string] $ZipPath) {
    $appearanceId = [int] [System.IO.Path]::GetFileNameWithoutExtension($ZipPath)
    $roleDir = Join-Path $OutputRoot "hero_$RoleId"
    $appearanceDir = Join-Path $roleDir "appearance_$appearanceId"
    Ensure-AssetDirectory $OutputRoot
    Ensure-AssetDirectory $roleDir
    Ensure-AssetDirectory $appearanceDir
    if (Test-HeroAppearanceImported $appearanceDir) {
        Repair-HeroMirroredDirections $appearanceDir
        return New-StandardAppearanceCatalog $RoleId $appearanceId ([System.IO.Path]::GetFileName($ZipPath))
    }

    $zip = [System.IO.Compression.ZipFile]::OpenRead($ZipPath)
    $decodedByAction = @{}
    try {
        foreach ($entry in $zip.Entries) {
            if (-not $entry.FullName.ToLowerInvariant().EndsWith('.img')) { continue }
            $actionId = [System.IO.Path]::GetFileNameWithoutExtension($entry.FullName)
            $decodedByAction[$actionId] = Decode-OldImg (Read-ZipEntryBytes $entry)
        }
    }
    finally {
        $zip.Dispose()
    }

    $actions = [ordered]@{}
    $actionMap = @(
        @{ id = '0'; name = 'idle'; directional = $true },
        @{ id = '1'; name = 'walk'; directional = $true },
        @{ id = '2'; name = 'attack'; directional = $true },
        @{ id = '4'; name = 'death'; directional = $false }
    )
    foreach ($action in $actionMap) {
        if (-not $decodedByAction.ContainsKey($action.id)) { continue }
        $actionDir = Join-Path $appearanceDir $action.name
        Ensure-AssetDirectory $actionDir
        if ($action.directional) {
            $actions[$action.name] = Import-DirectionalAction $decodedByAction[$action.id] $actionDir $action.name
        }
        else {
            $actions[$action.name] = Import-FlatAction $decodedByAction[$action.id] $actionDir $action.name
        }
    }

    return [ordered]@{
        id = $appearanceId
        suggestedArmorLevel = if ($appearanceId -eq 0) { 0 } else { $appearanceId * 36 }
        zip = [System.IO.Path]::GetFileName($ZipPath)
        path = "heroes/hero_$RoleId/appearance_$appearanceId"
        actions = $actions
    }
}

function New-HeroPreview([array] $CatalogRoles, [string] $OutputPath) {
    $maxAppearances = 0
    foreach ($role in $CatalogRoles) {
        $maxAppearances = [Math]::Max($maxAppearances, $role.appearances.Count)
    }
    $labelHeight = 28
    $gap = 8
    $outWidth = $gap + $maxAppearances * ($CellSize + $gap)
    $outHeight = $gap + $CatalogRoles.Count * ($CellSize + $labelHeight + $gap)
    $bitmap = New-Object System.Drawing.Bitmap $outWidth, $outHeight, ([System.Drawing.Imaging.PixelFormat]::Format32bppArgb)
    $graphics = [System.Drawing.Graphics]::FromImage($bitmap)
    $font = New-Object System.Drawing.Font 'Microsoft YaHei UI', 10
    $brush = [System.Drawing.Brushes]::White
    try {
        $graphics.Clear([System.Drawing.Color]::FromArgb(255, 35, 35, 35))
        $graphics.InterpolationMode = [System.Drawing.Drawing2D.InterpolationMode]::NearestNeighbor
        for ($row = 0; $row -lt $CatalogRoles.Count; $row++) {
            $role = $CatalogRoles[$row]
            $y = $gap + $row * ($CellSize + $labelHeight + $gap)
            $graphics.DrawString("$($role.id) $($role.sexName)$($role.professionName)", $font, $brush, 4, $y)
            for ($col = 0; $col -lt $role.appearances.Count; $col++) {
                $appearance = $role.appearances[$col]
                $path = Join-Path $OutputRoot ("hero_{0}\appearance_{1}\idle\d4\idle_00.png" -f $role.id, $appearance.id)
                if (-not (Test-Path -LiteralPath $path)) { continue }
                $image = [System.Drawing.Image]::FromFile($path)
                try {
                    $x = $gap + $col * ($CellSize + $gap)
                    $dst = New-Object System.Drawing.Rectangle $x, ($y + $labelHeight), $CellSize, $CellSize
                    $graphics.DrawImage($image, $dst)
                    $graphics.DrawString("a$($appearance.id)", $font, $brush, $x + 4, $y + $labelHeight + 4)
                }
                finally {
                    $image.Dispose()
                }
            }
        }
        $bitmap.Save($OutputPath, [System.Drawing.Imaging.ImageFormat]::Png)
    }
    finally {
        $font.Dispose()
        $graphics.Dispose()
        $bitmap.Dispose()
    }
}

$resolvedSourceRoot = (Resolve-Path -LiteralPath $SourceRoot).Path
Ensure-AssetDirectory $OutputRoot

$catalogRoles = @()
foreach ($roleDir in Get-ChildItem -LiteralPath $resolvedSourceRoot -Directory | Sort-Object Name) {
    if (-not $RoleNames.ContainsKey($roleDir.Name)) { continue }
    $info = $RoleNames[$roleDir.Name]
    $appearances = @()
    foreach ($zip in Get-ChildItem -LiteralPath $roleDir.FullName -Filter '*.zip' | Sort-Object { [int] [System.IO.Path]::GetFileNameWithoutExtension($_.Name) }) {
        Write-Host ("Importing hero {0} appearance {1}" -f $roleDir.Name, [System.IO.Path]::GetFileNameWithoutExtension($zip.Name))
        $appearances += Import-HeroZip $roleDir.Name $zip.FullName
    }
    $catalogRoles += [ordered]@{
        id = $roleDir.Name
        profession = $info.profession
        professionName = $info.professionName
        sex = $info.sex
        sexName = $info.sexName
        resource = "heroes/hero_$($roleDir.Name)"
        appearances = $appearances
    }
}

$catalog = [ordered]@{
    source = 'legacy-client/client/pak/hero'
    cellSize = $CellSize
    directionOrder = @('back', 'rightUp', 'right', 'rightDown', 'front', 'leftDown', 'left', 'leftUp')
    actionFiles = [ordered]@{
        '0.img' = 'idle'
        '1.img' = 'walk'
        '2.img' = 'attack'
        '4.img' = 'death'
    }
    roles = $catalogRoles
}

$catalogPath = Join-Path $OutputRoot 'hero_catalog.json'
Write-JsonText $catalogPath $catalog
Write-JsonAssetMeta $catalogPath
New-HeroPreview $catalogRoles $PreviewPath

Write-Host "Imported $($catalogRoles.Count) hero roles to $OutputRoot"
Write-Host "Preview: $PreviewPath"
