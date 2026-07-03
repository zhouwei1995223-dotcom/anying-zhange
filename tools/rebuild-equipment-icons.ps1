param(
  [string]$Root = (Resolve-Path "$PSScriptRoot\..").Path,
  [string]$IconSheet = '',
  [string]$CatalogPath = '',
  [string]$OutDir = '',
  [switch]$Sample
)

$ErrorActionPreference = 'Stop'

if (-not $IconSheet) {
  $extractedIconImg = Join-Path $Root 'tmp_ui_extract\icon.img'
  $oldIconGif = Get-ChildItem -LiteralPath $Root -Recurse -File -Filter icon.gif -ErrorAction SilentlyContinue |
    Where-Object { $_.FullName -match '[\\/]client[\\/]image[\\/]ui[\\/]icon\.gif$' } |
    Select-Object -First 1
  if (Test-Path -LiteralPath $extractedIconImg) {
    $IconSheet = $extractedIconImg
  } elseif ($oldIconGif) {
    $IconSheet = $oldIconGif.FullName
  } else {
    $IconSheet = Join-Path $Root 'tmp_ui_extract\icon.png'
  }
}
if (-not $CatalogPath) { $CatalogPath = Join-Path $Root 'cocos-remake\assets\resources\equipment\equipment_catalog.json' }
if (-not $OutDir) { $OutDir = Join-Path $Root 'cocos-remake\assets\resources\equipment\icons' }

Add-Type -AssemblyName System.Drawing
New-Item -ItemType Directory -Force -Path $OutDir | Out-Null

$catalog = Get-Content -Raw -Encoding UTF8 -LiteralPath $CatalogPath | ConvertFrom-Json
$itemsByPath = @{}
foreach ($item in $catalog.items) {
  if (-not $item.iconPath) { continue }
  $key = [string]$item.iconPath
  if (-not $itemsByPath.ContainsKey($key)) { $itemsByPath[$key] = $item }
}

function Read-U8([byte[]]$Bytes, [ref]$Offset) {
  $value = [int]$Bytes[$Offset.Value]
  $Offset.Value++
  return $value
}

function Read-U16([byte[]]$Bytes, [ref]$Offset) {
  $value = [int]$Bytes[$Offset.Value] -bor ([int]$Bytes[$Offset.Value + 1] -shl 8)
  $Offset.Value += 2
  return $value
}

function Read-U32([byte[]]$Bytes, [ref]$Offset) {
  $value = [int64]$Bytes[$Offset.Value] -bor ([int64]$Bytes[$Offset.Value + 1] -shl 8) -bor ([int64]$Bytes[$Offset.Value + 2] -shl 16) -bor ([int64]$Bytes[$Offset.Value + 3] -shl 24)
  $Offset.Value += 4
  return $value
}

function Convert-OldColor([int]$Packed, [int]$Alpha = 255) {
  $r5 = ($Packed -shr 10) -band 0x1f
  $g5 = ($Packed -shr 5) -band 0x1f
  $b5 = $Packed -band 0x1f
  return [Drawing.Color]::FromArgb($Alpha, $r5 -shl 3, $g5 -shl 3, $b5 -shl 3)
}

function Load-OldImgBitmap([string]$Path) {
  [byte[]]$bytes = [IO.File]::ReadAllBytes($Path)
  $offset = [ref]0
  $first = [int]$bytes[0]
  if ($first -lt 1 -or $first -gt 3) {
    [void](Read-U32 $bytes $offset)
  }

  $type = Read-U8 $bytes $offset
  if ($type -gt 3) { $type = $type -shr 4 }
  $width = Read-U16 $bytes $offset
  $height = Read-U16 $bytes $offset
  $bitmap = New-Object Drawing.Bitmap $width, $height, ([Drawing.Imaging.PixelFormat]::Format32bppArgb)

  if ($type -eq 1) {
    for ($y = 0; $y -lt $height; $y++) {
      for ($x = 0; $x -lt $width; $x++) {
        $bitmap.SetPixel($x, $y, (Convert-OldColor (Read-U16 $bytes $offset)))
      }
    }
    return $bitmap
  }

  if ($type -ne 2 -and $type -ne 3) {
    throw "Unsupported old image type: $type"
  }

  for ($y = 0; $y -lt $height; $y++) {
    $rowLength = Read-U16 $bytes $offset
    $row = New-Object 'int[]' $rowLength
    for ($i = 0; $i -lt $rowLength; $i++) {
      $row[$i] = Read-U16 $bytes $offset
    }

    $x = 0
    $index = 0
    while ($index -lt $rowLength -and $x -lt $width) {
      $code = $row[$index]
      $index++
      $tag = $code -band 0xf000
      $count = $code -band 0x0fff
      switch ($tag) {
        0x2000 {
          $x += $count
        }
        0x1000 {
          for ($i = 0; $i -lt $count -and $index -lt $rowLength -and $x -lt $width; $i++) {
            $bitmap.SetPixel($x, $y, (Convert-OldColor $row[$index]))
            $index++
            $x++
          }
        }
        0x4000 {
          for ($i = 0; $i -lt $count -and ($index + 1) -lt $rowLength -and $x -lt $width; $i++) {
            $alpha = [Math]::Min(255, ($row[$index] -band 0x1f) * 8)
            $index++
            $bitmap.SetPixel($x, $y, (Convert-OldColor $row[$index] $alpha))
            $index++
            $x++
          }
        }
        default {
          $index = $rowLength
        }
      }
    }
  }

  if ($type -eq 3 -and $offset.Value + 1 -lt $bytes.Length) {
    [void](Read-U16 $bytes $offset)
  }
  return $bitmap
}

function Load-IconSheetBitmap([string]$Path) {
  if ([IO.Path]::GetExtension($Path).ToLowerInvariant() -eq '.img') {
    return Load-OldImgBitmap $Path
  }
  return [Drawing.Bitmap]::FromFile($Path)
}

function Get-IconRowY([object]$Item) {
  $race = [int]$Item.requiredRace
  if ($race -lt 0) { $race = 0 }

  switch ([string]$Item.slot) {
    'weapon' { return $race * 30 + 330 }
    'armor' { return $race * 90 + 60 }
    'helmet' { return $race * 90 + 30 }
    'boots' { return $race * 90 + 90 }
    'shield' { return 300 }
    'earbob' { return 510 }
    'necklace' { return 540 }
    'ring' { return 570 }
    'title' { return 600 }
    'aura' { return 630 }
    'fashion' { return 630 }
    default { return 0 }
  }
}

function Write-Icon([Drawing.Bitmap]$Sheet, [object]$Item, [string]$Path) {
  $icon = [int]$Item.icon
  if ($icon -le 0) { $icon = 1 }
  $srcX = ($icon - 1) * 24
  $srcY = Get-IconRowY $Item
  if ($srcX -lt 0 -or $srcY -lt 0 -or $srcX + 24 -gt $Sheet.Width -or $srcY + 24 -gt $Sheet.Height) { return $false }

  $out = New-Object Drawing.Bitmap 24, 24, ([Drawing.Imaging.PixelFormat]::Format32bppArgb)
  try {
    for ($y = 0; $y -lt 24; $y++) {
      for ($x = 0; $x -lt 24; $x++) {
        $c = $Sheet.GetPixel($srcX + $x, $srcY + $y)
        if ($c.A -gt 0) { $out.SetPixel($x, $y, $c) } else { $out.SetPixel($x, $y, [Drawing.Color]::Black) }
      }
    }
    $out.Save($Path, [Drawing.Imaging.ImageFormat]::Png)
  } finally {
    $out.Dispose()
  }
  return $true
}

function Get-IconContentScore([Drawing.Bitmap]$Sheet, [object]$Item) {
  $icon = [int]$Item.icon
  if ($icon -le 0) { $icon = 1 }
  $srcX = ($icon - 1) * 24
  $srcY = Get-IconRowY $Item
  if ($srcX -lt 0 -or $srcY -lt 0 -or $srcX + 24 -gt $Sheet.Width -or $srcY + 24 -gt $Sheet.Height) { return 0 }

  $count = 0
  for ($y = 0; $y -lt 24; $y++) {
    for ($x = 0; $x -lt 24; $x++) {
      $c = $Sheet.GetPixel($srcX + $x, $srcY + $y)
      $max = [Math]::Max($c.R, [Math]::Max($c.G, $c.B))
      if ($c.A -gt 0 -and $max -gt 18) { $count++ }
    }
  }
  return $count
}

$sheet = Load-IconSheetBitmap $IconSheet
$fallbackSheet = $null
$fallbackIconGif = Get-ChildItem -LiteralPath $Root -Recurse -File -Filter icon.gif -ErrorAction SilentlyContinue |
  Where-Object { $_.FullName -match '[\\/]client[\\/]image[\\/]ui[\\/]icon\.gif$' -and $_.FullName -ne $IconSheet } |
  Select-Object -First 1
if ($fallbackIconGif) {
  $fallbackSheet = Load-IconSheetBitmap $fallbackIconGif.FullName
}
$written = 0
try {
  foreach ($entry in $itemsByPath.GetEnumerator()) {
    $relative = $entry.Key -replace '^equipment/icons/', ''
    $outPath = Join-Path $OutDir ($relative + '.png')
    if (Write-Icon $sheet $entry.Value $outPath) {
      if ($fallbackSheet -ne $null -and (Get-IconContentScore $sheet $entry.Value) -lt 8) {
        [void](Write-Icon $fallbackSheet $entry.Value $outPath)
      }
      $written++
    }
  }
} finally {
  if ($fallbackSheet -ne $null) { $fallbackSheet.Dispose() }
  $sheet.Dispose()
}

if ($Sample) {
  $files = Get-ChildItem -LiteralPath $OutDir -Filter *.png | Sort-Object Name | Select-Object -First 160
  $cell = 42
  $cols = 10
  $rows = [Math]::Ceiling($files.Count / $cols)
  $samplePath = Join-Path $Root 'tmp_ui_extract\equipment_icons_resliced_sample.png'
  $sampleImage = New-Object Drawing.Bitmap ($cols * $cell), ($rows * $cell), ([Drawing.Imaging.PixelFormat]::Format32bppArgb)
  $g = [Drawing.Graphics]::FromImage($sampleImage)
  $g.Clear([Drawing.Color]::FromArgb(255, 42, 42, 42))
  $g.InterpolationMode = [Drawing.Drawing2D.InterpolationMode]::NearestNeighbor
  try {
    for ($i = 0; $i -lt $files.Count; $i++) {
      $img = [Drawing.Image]::FromFile($files[$i].FullName)
      try {
        $x = ($i % $cols) * $cell + 9
        $y = [Math]::Floor($i / $cols) * $cell + 4
        $g.DrawImage($img, $x, $y, 24, 24)
      } finally {
        $img.Dispose()
      }
    }
    $sampleImage.Save($samplePath, [Drawing.Imaging.ImageFormat]::Png)
  } finally {
    $g.Dispose()
    $sampleImage.Dispose()
  }
  "sample=$samplePath"
}

"written=$written"
