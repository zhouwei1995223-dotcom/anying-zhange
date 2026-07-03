param(
  [string]$Root = (Resolve-Path "$PSScriptRoot\..").Path,
  [string]$SourceDir = 'D:\anyingzhange\xinrenwu',
  [string]$HeroId = 'hero_00',
  [int]$AppearanceId = 8,
  [double]$Scale = 0.38,
  [int]$CanvasSize = 320,
  [int]$FootX = 160,
  [int]$FootY = 240,
  [int]$AnchorX = 160,
  [int]$AnchorY = 180,
  [switch]$UsePlacements = $true,
  [string]$PreviewPath = ''
)

$ErrorActionPreference = 'Stop'

if (-not (Test-Path -LiteralPath $SourceDir)) {
  throw "SourceDir not found: $SourceDir"
}
if (-not $PreviewPath) {
  $PreviewPath = Join-Path $Root "foldered_${HeroId}_appearance_${AppearanceId}_preview.png"
}

$heroRoot = Join-Path $Root "cocos-remake\assets\resources\heroes\$HeroId"
$outRoot = Join-Path $heroRoot "appearance_$AppearanceId"
$resolvedHeroRoot = [IO.Path]::GetFullPath($heroRoot)
$resolvedOutRoot = [IO.Path]::GetFullPath($outRoot)
if (-not $resolvedOutRoot.StartsWith($resolvedHeroRoot, [StringComparison]::OrdinalIgnoreCase)) {
  throw "Unsafe output path: $resolvedOutRoot"
}

$utf8NoBom = New-Object System.Text.UTF8Encoding($false)

Add-Type -AssemblyName System.Drawing

function Write-Utf8NoBom([string]$Path, [string]$Text) {
  [IO.File]::WriteAllText($Path, $Text, $script:utf8NoBom)
}

function New-Uuid() { [guid]::NewGuid().ToString() }

function Get-MetaUuid([string]$Path) {
  if (-not (Test-Path -LiteralPath $Path)) { return New-Uuid }
  try {
    $meta = Get-Content -Raw -LiteralPath $Path | ConvertFrom-Json
    if ($meta.uuid) { return [string]$meta.uuid }
  } catch {
  }
  return New-Uuid
}

function Write-DirectoryMeta([string]$Path) {
  $uuid = Get-MetaUuid $Path
  $json = @"
{
  "ver": "1.2.0",
  "importer": "directory",
  "imported": true,
  "uuid": "$uuid",
  "files": [],
  "subMetas": {},
  "userData": {}
}
"@
  Write-Utf8NoBom $Path $json
}

function Write-ImageMeta([string]$Path, [string]$Name, [int]$Width, [int]$Height) {
  $uuid = Get-MetaUuid $Path
  $halfW = [int]($Width / 2)
  $halfH = [int]($Height / 2)
  $json = @"
{
  "ver": "1.0.27",
  "importer": "image",
  "imported": true,
  "uuid": "$uuid",
  "files": [".json", ".png"],
  "subMetas": {
    "6c48a": {"importer":"texture","uuid":"$uuid@6c48a","displayName":"$Name","id":"6c48a","name":"texture","userData":{"wrapModeS":"clamp-to-edge","wrapModeT":"clamp-to-edge","imageUuidOrDatabaseUri":"$uuid","isUuid":true,"visible":false,"minfilter":"linear","magfilter":"nearest","mipfilter":"none","anisotropy":0},"ver":"1.0.22","imported":true,"files":[".json"],"subMetas":{}},
    "f9941": {"importer":"sprite-frame","uuid":"$uuid@f9941","displayName":"$Name","id":"f9941","name":"spriteFrame","userData":{"trimThreshold":1,"rotated":false,"offsetX":0,"offsetY":0,"trimX":0,"trimY":0,"width":$Width,"height":$Height,"rawWidth":$Width,"rawHeight":$Height,"borderTop":0,"borderBottom":0,"borderLeft":0,"borderRight":0,"packable":false,"pixelsToUnit":100,"pivotX":0.5,"pivotY":0.5,"meshType":0,"vertices":{"rawPosition":[-$halfW,-$halfH,0,$halfW,-$halfH,0,-$halfW,$halfH,0,$halfW,$halfH,0],"indexes":[0,1,2,2,1,3],"uv":[0,$Height,$Width,$Height,0,0,$Width,0],"nuv":[0,0,1,0,0,1,1,1],"minPos":[-$halfW,-$halfH,0],"maxPos":[$halfW,$halfH,0]},"isUuid":true,"imageUuidOrDatabaseUri":"$uuid@6c48a","atlasUuid":"","trimType":"custom"},"ver":"1.0.12","imported":true,"files":[".json"],"subMetas":{}}
  },
  "userData": {"type":"sprite-frame","fixAlphaTransparencyArtifacts":false,"hasAlpha":true,"redirect":"$uuid@6c48a"}
}
"@
  Write-Utf8NoBom $Path $json
}

function Get-Placement([int]$FrameId) {
  if (-not $script:UsePlacements -or $FrameId -lt 0) { return $null }
  $path = Join-Path $script:SourceDir ('Placements\{0:D5}.txt' -f $FrameId)
  if (-not (Test-Path -LiteralPath $path)) { return $null }
  $values = @(Get-Content -LiteralPath $path | ForEach-Object {
    $line = ([string]$_).Trim()
    if ($line.Length) { [int]$line }
  })
  if ($values.Count -lt 2) { return $null }
  [pscustomobject]@{ X = [int]$values[0]; Y = [int]$values[1] }
}

function Convert-Frame([string]$Src, [string]$Dst, [int]$FrameId = -1) {
  $srcBmp = [System.Drawing.Bitmap]::FromFile($Src)
  try {
    $dstBmp = New-Object System.Drawing.Bitmap -ArgumentList $script:CanvasSize, $script:CanvasSize, ([System.Drawing.Imaging.PixelFormat]::Format32bppArgb)
    try {
      $g = [System.Drawing.Graphics]::FromImage($dstBmp)
      try {
        $g.Clear([System.Drawing.Color]::Transparent)
        $g.InterpolationMode = [System.Drawing.Drawing2D.InterpolationMode]::HighQualityBicubic
        $g.PixelOffsetMode = [System.Drawing.Drawing2D.PixelOffsetMode]::Half
        $dw = [Math]::Max(1, [int][Math]::Round($srcBmp.Width * $script:Scale))
        $dh = [Math]::Max(1, [int][Math]::Round($srcBmp.Height * $script:Scale))
        $placement = Get-Placement $FrameId
        if ($placement) {
          $dx = [int][Math]::Round($script:AnchorX + $placement.X * $script:Scale)
          $dy = [int][Math]::Round($script:AnchorY + $placement.Y * $script:Scale)
        } else {
          $dx = [int][Math]::Round($script:FootX - ($dw / 2))
          $dy = [int][Math]::Round($script:FootY - $dh)
        }
        $srcRect = New-Object System.Drawing.Rectangle -ArgumentList 0, 0, $srcBmp.Width, $srcBmp.Height
        $dstRect = New-Object System.Drawing.Rectangle -ArgumentList $dx, $dy, $dw, $dh
        $g.DrawImage($srcBmp, $dstRect, $srcRect, [System.Drawing.GraphicsUnit]::Pixel)
      } finally {
        $g.Dispose()
      }
      $dstBmp.Save($Dst, [System.Drawing.Imaging.ImageFormat]::Png)
    } finally {
      $dstBmp.Dispose()
    }
  } finally {
    $srcBmp.Dispose()
  }
}

function Ensure-Dir([string]$Path) {
  New-Item -ItemType Directory -Force -Path $Path | Out-Null
  Write-DirectoryMeta "$Path.meta"
}

function Find-ActionDir([string]$Name) {
  $dir = Join-Path $SourceDir $Name
  if (-not (Test-Path -LiteralPath $dir)) {
    throw "Missing action folder: $dir"
  }
  return $dir
}

if (Test-Path -LiteralPath $outRoot) {
  Remove-Item -LiteralPath $outRoot -Recurse -Force
}
Ensure-Dir $heroRoot
Ensure-Dir $outRoot

$folderIdle = [string]([char]0x5f85) + [string]([char]0x673a)
$folderWalk = [string]([char]0x884c) + [string]([char]0x8d70)
$folderAttack = [string]([char]0x653b) + [string]([char]0x51fb)
$folderDeath = [string]([char]0x6b7b) + [string]([char]0x4ea1)

$sets = @(
  @{ Action = 'idle'; Folder = $folderIdle; Base = 0; Frames = 4; Prefix = 'idle_' },
  @{ Action = 'walk'; Folder = $folderWalk; Base = 80; Frames = 6; Prefix = 'walk_' },
  @{ Action = 'attack'; Folder = $folderAttack; Base = 160; Frames = 8; Prefix = 'attack_' }
)

foreach ($set in $sets) {
  $srcDir = Find-ActionDir $set.Folder
  $actionDir = Join-Path $outRoot $set.Action
  Ensure-Dir $actionDir
  for ($dir = 0; $dir -lt 8; $dir++) {
    $dirPath = Join-Path $actionDir "d$dir"
    Ensure-Dir $dirPath
    for ($frame = 0; $frame -lt $set.Frames; $frame++) {
      $srcId = $set.Base + ($dir * 10) + $frame
      $src = Join-Path $srcDir ('{0:D5}.PNG' -f $srcId)
      if (-not (Test-Path -LiteralPath $src)) {
        throw "Missing source frame: $src"
      }
      $name = '{0}{1:D2}' -f $set.Prefix, $frame
      $dst = Join-Path $dirPath "$name.png"
      Convert-Frame $src $dst $srcId
      Write-ImageMeta "$dst.meta" $name $CanvasSize $CanvasSize
    }
  }
}

for ($frame = 0; $frame -lt 4; $frame++) {
  $idleRoot = Join-Path $outRoot 'idle'
  $from = Join-Path (Join-Path $idleRoot 'd4') ('idle_{0:D2}.png' -f $frame)
  $to = Join-Path $idleRoot ('idle_{0:D2}.png' -f $frame)
  Copy-Item -LiteralPath $from -Destination $to -Force
  Write-ImageMeta "$to.meta" ('idle_{0:D2}' -f $frame) $CanvasSize $CanvasSize
}

$deathDir = Find-ActionDir $folderDeath
$deathSource = Get-ChildItem -LiteralPath $deathDir -File -Filter *.PNG | Sort-Object Name | Select-Object -First 1
if (-not $deathSource) {
  throw "Missing death frame in $deathDir"
}
$outDeathDir = Join-Path $outRoot 'death'
Ensure-Dir $outDeathDir
$deathDst = Join-Path $outDeathDir 'death_00.png'
$deathId = 0
if ([int]::TryParse($deathSource.BaseName, [ref]$deathId)) {
  Convert-Frame $deathSource.FullName $deathDst $deathId
} else {
  Convert-Frame $deathSource.FullName $deathDst
}
Write-ImageMeta "$deathDst.meta" 'death_00' $CanvasSize $CanvasSize

$previewCell = $CanvasSize
$previewCols = 8
$previewRows = 4
$preview = New-Object System.Drawing.Bitmap -ArgumentList ($previewCell * $previewCols),($previewCell * $previewRows),([System.Drawing.Imaging.PixelFormat]::Format32bppArgb)
$pg = [System.Drawing.Graphics]::FromImage($preview)
try {
  $pg.Clear([System.Drawing.Color]::FromArgb(18, 22, 28))
  $font = New-Object System.Drawing.Font -ArgumentList 'Consolas', 9
  try {
    $brush = [System.Drawing.Brushes]::White
    $labels = @('idle', 'walk', 'attack')
    for ($row = 0; $row -lt $labels.Length; $row++) {
      for ($dir = 0; $dir -lt 8; $dir++) {
        $action = $labels[$row]
        $file = Join-Path (Join-Path (Join-Path $outRoot $action) "d$dir") ("${action}_00.png")
        $img = [System.Drawing.Bitmap]::FromFile($file)
        try {
          $x = $dir * $previewCell
          $y = $row * $previewCell
          $pg.DrawString("$action d$dir", $font, $brush, $x + 4, $y + 4)
          $pg.DrawImage($img, $x, $y, $previewCell, $previewCell)
        } finally {
          $img.Dispose()
        }
      }
    }
    $deathImg = [System.Drawing.Bitmap]::FromFile($deathDst)
    try {
      $pg.DrawString('death', $font, $brush, 4, ($previewRows - 1) * $previewCell + 4)
      $pg.DrawImage($deathImg, 0, ($previewRows - 1) * $previewCell, $previewCell, $previewCell)
    } finally {
      $deathImg.Dispose()
    }
  } finally {
    $font.Dispose()
  }
  $preview.Save($PreviewPath, [System.Drawing.Imaging.ImageFormat]::Png)
} finally {
  $pg.Dispose()
  $preview.Dispose()
}

Write-Output "Imported $HeroId appearance_$AppearanceId to $outRoot"
Write-Output "Preview: $PreviewPath"
