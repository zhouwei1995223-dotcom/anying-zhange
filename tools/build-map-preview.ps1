param(
  [string]$Root = (Resolve-Path "$PSScriptRoot\..").Path,
  [string]$OldClient = '',
  [string]$ConverterDir = '',
  [int]$MapId = 0,
  [double]$Scale = 0.5
)

if (-not $OldClient) {
  $OldClient = Get-ChildItem -LiteralPath $Root -Directory |
    ForEach-Object { Join-Path $_.FullName 'client' } |
    Where-Object { Test-Path -LiteralPath (Join-Path $_ "data\map\$MapId.map") } |
    Select-Object -First 1
}

if (-not $OldClient) {
  throw "Old client not found under $Root"
}

$oldClient = $OldClient
$mapFile = Join-Path $oldClient "data\map\$MapId.map"
$pakDir = Join-Path $oldClient 'pak\mapimg'
$tileDir = Join-Path $Root "tmp_map_tiles\$MapId"
$pngDir = Join-Path $tileDir 'png'
$imgDir = Join-Path $tileDir 'img'
$outFile = Join-Path $Root "cocos-remake\assets\resources\maps\map_${MapId}_preview.png"
$java = 'C:\Program Files\Android\jdk\jdk-8.0.302.8-hotspot\jdk8u302-b08\bin\java.exe'

if (-not $ConverterDir) {
  $ConverterDir = Get-ChildItem -LiteralPath 'D:\' -Directory |
    ForEach-Object { Join-Path $_.FullName 'img_png_tool' } |
    Where-Object { Test-Path -LiteralPath (Join-Path $_ 'ImgPngTool.class') } |
    Select-Object -First 1
}

if (-not $ConverterDir) {
  throw 'ImgPngTool.class not found under D:\*\img_png_tool'
}

$converterCp = "$ConverterDir;$ConverterDir\client.zip"

New-Item -ItemType Directory -Force -Path $pngDir, $imgDir | Out-Null

Add-Type -AssemblyName System.IO.Compression.FileSystem
Add-Type -AssemblyName System.Drawing

$bytes = [IO.File]::ReadAllBytes($mapFile)
function U16([int]$i) { [int]$bytes[$i] -bor ([int]$bytes[$i + 1] -shl 8) }

$w = U16 0
$h = U16 2
$baseCount = $w * $h
$base = New-Object int[] $baseCount
$needed = New-Object 'System.Collections.Generic.HashSet[int]'

$pos = 4
for ($y = 0; $y -lt $h; $y++) {
  for ($x = 0; $x -lt $w; $x++) {
    $tile = U16 $pos
    $pos += 2
    if ($tile -eq 133 -and $y -gt 0) {
      $tile = $base[(($y - 1) * $w) + $x]
    }
    $base[($y * $w) + $x] = $tile
    if ($tile -gt 0) { [void]$needed.Add($tile - 1) }
  }
}

$objects = @()
$layerMap = @(0, 1, 3)
for ($layer = 0; $layer -lt 3; $layer++) {
  $count = U16 $pos
  $pos += 2
  for ($i = 0; $i -lt $count; $i++) {
    $tile = U16 $pos
    $x = U16 ($pos + 2)
    $y = U16 ($pos + 4)
    $pos += 6
    if ($tile -gt 0) {
      $imgId = $tile - 1
      [void]$needed.Add($imgId)
      $objects += [pscustomobject]@{ ImgId = $imgId; X = $x; Y = $y; Layer = $layerMap[$layer] }
    }
  }
}

$ranges = Get-ChildItem -LiteralPath $pakDir -Filter '*.zip' | ForEach-Object {
  if ($_.BaseName -match '^(\d+)-(\d+)$') {
    [pscustomobject]@{ Start = [int]$matches[1]; End = [int]$matches[2]; Path = $_.FullName }
  }
}

function Get-TilePng([int]$id) {
  $png = Join-Path $pngDir "$id.png"
  if (Test-Path -LiteralPath $png) { return $png }

  $range = $ranges | Where-Object { $_.Start -le $id -and $_.End -ge $id } | Select-Object -First 1
  if (-not $range) { return $null }

  $img = Join-Path $imgDir "$id.img"
  if (-not (Test-Path -LiteralPath $img)) {
    $zip = [IO.Compression.ZipFile]::OpenRead($range.Path)
    try {
      $entry = $zip.GetEntry("image/map/$id.img")
      if (-not $entry) { return $null }
      [IO.Compression.ZipFileExtensions]::ExtractToFile($entry, $img, $true)
    } finally {
      $zip.Dispose()
    }
  }

  & $java -cp $converterCp ImgPngTool img2png $img $png | Out-Null
  if (Test-Path -LiteralPath $png) { return $png }
  return $null
}

foreach ($id in $needed) { [void](Get-TilePng $id) }

$outW = [int]($w * 60 * $Scale)
$outH = [int]($h * 60 * $Scale)
$canvas = New-Object Drawing.Bitmap $outW, $outH
$g = [Drawing.Graphics]::FromImage($canvas)
$g.Clear([Drawing.Color]::Black)
$g.InterpolationMode = [Drawing.Drawing2D.InterpolationMode]::NearestNeighbor
$g.PixelOffsetMode = [Drawing.Drawing2D.PixelOffsetMode]::Half

try {
  for ($y = 0; $y -lt $h; $y++) {
    for ($x = 0; $x -lt $w; $x++) {
      $tile = $base[($y * $w) + $x]
      if ($tile -le 0) { continue }
      $png = Get-TilePng ($tile - 1)
      if (-not $png) { continue }
      $img = [Drawing.Image]::FromFile($png)
      try {
        $g.DrawImage($img, [int]($x * 60 * $Scale), [int]($y * 60 * $Scale), [int](60 * $Scale), [int](60 * $Scale))
      } finally {
        $img.Dispose()
      }
    }
  }

  # ponytail: first frame only; add animated map tiles later if a real scene needs them.
  foreach ($obj in ($objects | Sort-Object Layer, Y, X)) {
    $png = Get-TilePng $obj.ImgId
    if (-not $png) { continue }
    $img = [Drawing.Image]::FromFile($png)
    try {
      $g.DrawImage($img, [int]($obj.X * $Scale), [int]($obj.Y * $Scale), [int]($img.Width * $Scale), [int]($img.Height * $Scale))
    } finally {
      $img.Dispose()
    }
  }
} finally {
  $g.Dispose()
}

$canvas.Save($outFile, [Drawing.Imaging.ImageFormat]::Png)
$canvas.Dispose()

"map=$MapId size=${outW}x${outH} tiles=$($needed.Count) objects=$($objects.Count) out=$outFile"
