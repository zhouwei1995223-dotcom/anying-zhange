param(
    [Parameter(Mandatory = $true)]
    [string] $InputPath,

    [Parameter(Mandatory = $true)]
    [string] $OutputDir
)

Add-Type -AssemblyName System.Drawing
Add-Type -AssemblyName System.IO.Compression.FileSystem

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

function Save-Png($Decoded, [string] $OutputPath) {
    $width = $Decoded.Width
    $height = $Decoded.Height
    $bitmap = New-Object System.Drawing.Bitmap $width, $height, ([System.Drawing.Imaging.PixelFormat]::Format32bppArgb)
    $rect = New-Object System.Drawing.Rectangle 0, 0, $width, $height
    $data = $bitmap.LockBits($rect, [System.Drawing.Imaging.ImageLockMode]::WriteOnly, [System.Drawing.Imaging.PixelFormat]::Format32bppArgb)
    try {
        $bytes = New-Object byte[] ($width * $height * 4)
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
    $bitmap.Save($OutputPath, [System.Drawing.Imaging.ImageFormat]::Png)
    $bitmap.Dispose()
}

function Save-CellPreview($Decoded, [string] $OutputPath, [int] $CellWidth, [int] $CellHeight, [int] $Scale) {
    $cols = [Math]::Floor($Decoded.Width / $CellWidth)
    $rows = [Math]::Floor($Decoded.Height / $CellHeight)
    $gap = 4
    $outWidth = $cols * $CellWidth * $Scale + ($cols + 1) * $gap
    $outHeight = $rows * $CellHeight * $Scale + ($rows + 1) * $gap
    $bitmap = New-Object System.Drawing.Bitmap $outWidth, $outHeight, ([System.Drawing.Imaging.PixelFormat]::Format32bppArgb)
    $graphics = [System.Drawing.Graphics]::FromImage($bitmap)
    $graphics.Clear([System.Drawing.Color]::FromArgb(255, 36, 36, 36))
    $graphics.InterpolationMode = [System.Drawing.Drawing2D.InterpolationMode]::NearestNeighbor
    $graphics.PixelOffsetMode = [System.Drawing.Drawing2D.PixelOffsetMode]::Half

    $sheetPath = [System.IO.Path]::GetTempFileName() + ".png"
    Save-Png $Decoded $sheetPath
    $sheet = [System.Drawing.Image]::FromFile($sheetPath)
    try {
        for ($row = 0; $row -lt $rows; $row++) {
            for ($col = 0; $col -lt $cols; $col++) {
                $src = New-Object System.Drawing.Rectangle ($col * $CellWidth), ($row * $CellHeight), $CellWidth, $CellHeight
                $dst = New-Object System.Drawing.Rectangle ($gap + $col * ($CellWidth * $Scale + $gap)), ($gap + $row * ($CellHeight * $Scale + $gap)), ($CellWidth * $Scale), ($CellHeight * $Scale)
                $graphics.DrawImage($sheet, $dst, $src, [System.Drawing.GraphicsUnit]::Pixel)
            }
        }
    }
    finally {
        $sheet.Dispose()
        $graphics.Dispose()
        Remove-Item -LiteralPath $sheetPath -Force -ErrorAction SilentlyContinue
    }
    $bitmap.Save($OutputPath, [System.Drawing.Imaging.ImageFormat]::Png)
    $bitmap.Dispose()
}

New-Item -ItemType Directory -Force -Path $OutputDir | Out-Null
$resolvedInput = (Resolve-Path -LiteralPath $InputPath).Path

if ([System.IO.Path]::GetExtension($resolvedInput).ToLowerInvariant() -eq ".zip") {
    $zip = [System.IO.Compression.ZipFile]::OpenRead($resolvedInput)
    try {
        foreach ($entry in $zip.Entries) {
            if ($entry.FullName.ToLowerInvariant().EndsWith(".img") -eq $false) {
                continue
            }
            $stream = $entry.Open()
            $buffer = New-Object byte[] $entry.Length
            $offset = 0
            while ($offset -lt $buffer.Length) {
                $read = $stream.Read($buffer, $offset, $buffer.Length - $offset)
                if ($read -le 0) { break }
                $offset += $read
            }
            $stream.Dispose()

            $decoded = Decode-OldImg $buffer
            $name = ([System.IO.Path]::GetFileNameWithoutExtension($entry.FullName)).Replace('/', '_').Replace('\', '_')
            $sheetPath = Join-Path $OutputDir "$name.png"
            Save-Png $decoded $sheetPath
            if ($decoded.Width % 150 -eq 0 -and $decoded.Height % 150 -eq 0) {
                Save-CellPreview $decoded (Join-Path $OutputDir "$name`_cells_x2.png") 150 150 2
            }
            Write-Output "$($entry.FullName) -> $sheetPath ($($decoded.Width)x$($decoded.Height), type $($decoded.Type))"
        }
    }
    finally {
        $zip.Dispose()
    }
}
else {
    $buffer = [System.IO.File]::ReadAllBytes($resolvedInput)
    $decoded = Decode-OldImg $buffer
    $name = [System.IO.Path]::GetFileNameWithoutExtension($resolvedInput)
    $sheetPath = Join-Path $OutputDir "$name.png"
    Save-Png $decoded $sheetPath
    if ($decoded.Width % 150 -eq 0 -and $decoded.Height % 150 -eq 0) {
        Save-CellPreview $decoded (Join-Path $OutputDir "$name`_cells_x2.png") 150 150 2
    }
    Write-Output "$resolvedInput -> $sheetPath ($($decoded.Width)x$($decoded.Height), type $($decoded.Type))"
}
