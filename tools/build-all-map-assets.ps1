param(
  [string]$Root = (Resolve-Path "$PSScriptRoot\..").Path,
  [string]$OldClient = '',
  [string]$ConverterDir = '',
  [int[]]$MapIds = @(),
  [double]$Scale = 0.5,
  [double]$MapNodeScale = 1.5,
  [int]$ThumbWidth = 240,
  [int]$OcclusionMinLayer = 3,
  [int[]]$LowPropTileIds = @(
    55, 56, 57, 58, 59, 60, 61, 62, 63, 64,
    252, 253, 254, 255, 256, 257,
    279, 280, 281, 282, 283, 284, 285, 286,
    309, 310, 311, 312, 313, 314
  ),
  [switch]$Force
)

$ErrorActionPreference = 'Stop'

if (-not $OldClient) {
  $OldClient = Get-ChildItem -LiteralPath $Root -Directory |
    ForEach-Object { Join-Path $_.FullName 'client' } |
    Where-Object { Test-Path -LiteralPath (Join-Path $_ 'data\map') } |
    Select-Object -First 1
}
if (-not $OldClient) { throw "Old client not found under $Root" }

if (-not $ConverterDir) {
  $ConverterDir = Get-ChildItem -LiteralPath 'D:\' -Directory |
    ForEach-Object { Join-Path $_.FullName 'img_png_tool' } |
    Where-Object { Test-Path -LiteralPath (Join-Path $_ 'ImgPngTool.class') } |
    Select-Object -First 1
}

$javaCandidates = @(
  'C:\Program Files\Android\jdk\jdk-8.0.302.8-hotspot\jdk8u302-b08\bin\java.exe',
  (Join-Path $Root 'tools\jdk\jdk8u492-b09\bin\java.exe'),
  (Join-Path $Root 'tools\jdk\jdk8u492-b09\jre\bin\java.exe')
)
$java = $javaCandidates | Where-Object { Test-Path -LiteralPath $_ } | Select-Object -First 1

$mapDir = Join-Path $OldClient 'data\map'
$pakDir = Join-Path $OldClient 'pak\mapimg'
$outDir = Join-Path $Root 'cocos-remake\assets\resources\maps'
$thumbDir = Join-Path $Root 'MAP_CATALOG'
$cacheDir = Join-Path $Root 'tmp_map_tiles\shared_png'
$rawDir = Join-Path $Root 'tmp_map_tiles\shared_img'
$converterCp = if ($ConverterDir) { "$ConverterDir;$ConverterDir\client.zip" } else { '' }

New-Item -ItemType Directory -Force -Path $outDir, $thumbDir, $cacheDir, $rawDir | Out-Null

Add-Type -AssemblyName System.IO.Compression.FileSystem
Add-Type -AssemblyName System.Drawing

$utf8NoBom = New-Object System.Text.UTF8Encoding($false)

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

function Write-JsonMeta([string]$Path) {
  $uuid = Get-MetaUuid $Path
  $json = @"
{
  "ver": "2.0.1",
  "importer": "json",
  "imported": true,
  "uuid": "$uuid",
  "files": [".json"],
  "subMetas": {},
  "userData": {}
}
"@
  Write-Utf8NoBom $Path $json
}

function Write-ImageMeta([string]$Path, [string]$Name, [int]$Width, [int]$Height, [bool]$HasAlpha) {
  $uuid = Get-MetaUuid $Path
  $halfW = [int]($Width / 2)
  $halfH = [int]($Height / 2)
  $alphaText = if ($HasAlpha) { 'true' } else { 'false' }
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
  "userData": {"type":"sprite-frame","fixAlphaTransparencyArtifacts":false,"hasAlpha":$alphaText,"redirect":"$uuid@6c48a"}
}
"@
  Write-Utf8NoBom $Path $json
}

function U16([byte[]]$Bytes, [int]$Index) {
  [int]$Bytes[$Index] -bor ([int]$Bytes[$Index + 1] -shl 8)
}

function I16([byte[]]$Bytes, [int]$Index) {
  $v = U16 $Bytes $Index
  if (($v -band 0x8000) -ne 0) { return ($v - 0x10000) }
  return $v
}

function ColorFromRgb555([int]$Value) {
  $v = $Value -band 0x7fff
  $r = [int]([Math]::Round((($v -shr 10) -band 31) * 255 / 31))
  $g = [int]([Math]::Round((($v -shr 5) -band 31) * 255 / 31))
  $b = [int]([Math]::Round(($v -band 31) * 255 / 31))
  [Drawing.Color]::FromArgb(255, $r, $g, $b)
}

function Convert-ImgToPng([string]$ImgPath, [string]$PngPath) {
  $bytes = [IO.File]::ReadAllBytes($ImgPath)
  if ($bytes.Length -lt 9) { throw "Invalid .img file: $ImgPath" }

  $typeRaw = [int]$bytes[4]
  $type = if ($typeRaw -gt 3) { $typeRaw -shr 4 } else { $typeRaw }
  $width = U16 $bytes 5
  $height = U16 $bytes 7
  if ($width -le 0 -or $height -le 0 -or $width -gt 4096 -or $height -gt 4096) {
    throw "Invalid .img size ${width}x${height}: $ImgPath"
  }

  $bmp = New-Object Drawing.Bitmap $width, $height, ([Drawing.Imaging.PixelFormat]::Format32bppArgb)
  try {
    $pos = 9
    if ($type -eq 1) {
      for ($y = 0; $y -lt $height; $y++) {
        for ($x = 0; $x -lt $width; $x++) {
          if ($pos + 1 -ge $bytes.Length) { break }
          $bmp.SetPixel($x, $y, (ColorFromRgb555 (U16 $bytes $pos)))
          $pos += 2
        }
      }
    } else {
      $y = 0
      while ($y -lt $height -and $pos + 1 -lt $bytes.Length) {
        $count = I16 $bytes $pos
        $pos += 2
        $row = New-Object int[] ([Math]::Max(0, $count))
        for ($i = 0; $i -lt $row.Length -and $pos + 1 -lt $bytes.Length; $i++) {
          $row[$i] = U16 $bytes $pos
          $pos += 2
        }

        $x = 0
        $n = 0
        while ($n -lt $row.Length) {
          $op = $row[$n]
          $n++
          $kind = $op -band 0xf000
          $len = $op -band 0x0fff

          if ($kind -eq 0x3000) {
            $y += $len
            break
          } elseif ($kind -eq 0x2000) {
            $x += $len
          } elseif ($kind -eq 0x1000) {
            for ($i = 0; $i -lt $len -and $x -lt $width -and $n -lt $row.Length; $i++) {
              $bmp.SetPixel($x, $y, (ColorFromRgb555 $row[$n]))
              $x++
              $n++
            }
          } elseif ($kind -eq 0x4000) {
            for ($i = 0; $i -lt $len -and $x -lt $width -and ($n + 1) -lt $row.Length; $i++) {
              $n++
              $bmp.SetPixel($x, $y, (ColorFromRgb555 $row[$n]))
              $x++
              $n++
            }
          }
        }

        $y++
      }
    }

    $bmp.Save($PngPath, [Drawing.Imaging.ImageFormat]::Png)
  } finally {
    $bmp.Dispose()
  }
}

$ranges = Get-ChildItem -LiteralPath $pakDir -Filter '*.zip' | ForEach-Object {
  if ($_.BaseName -match '^(\d+)-(\d+)$') {
    [pscustomobject]@{ Start = [int]$matches[1]; End = [int]$matches[2]; Path = $_.FullName }
  }
}

function Get-TilePng([int]$Id) {
  $png = Join-Path $cacheDir "$Id.png"
  if (Test-Path -LiteralPath $png) { return $png }

  $range = $ranges | Where-Object { $_.Start -le $Id -and $_.End -ge $Id } | Select-Object -First 1
  if (-not $range) { return $null }

  $img = Join-Path $rawDir "$Id.img"
  if (-not (Test-Path -LiteralPath $img)) {
    $zip = [IO.Compression.ZipFile]::OpenRead($range.Path)
    try {
      $entry = $zip.GetEntry("image/map/$Id.img")
      if (-not $entry) { return $null }
      [IO.Compression.ZipFileExtensions]::ExtractToFile($entry, $img, $true)
    } finally {
      $zip.Dispose()
    }
  }

  if ($ConverterDir -and $java) {
    & $java -cp $converterCp ImgPngTool img2png $img $png | Out-Null
  } else {
    Convert-ImgToPng $img $png
  }
  if (Test-Path -LiteralPath $png) { return $png }
  return $null
}

function Read-Map([string]$MapFile) {
  $bytes = [IO.File]::ReadAllBytes($MapFile)
  $w = U16 $bytes 0
  $h = U16 $bytes 2
  $base = New-Object int[] ($w * $h)
  $needed = New-Object 'System.Collections.Generic.HashSet[int]'
  $pos = 4

  for ($y = 0; $y -lt $h; $y++) {
    for ($x = 0; $x -lt $w; $x++) {
      $tile = U16 $bytes $pos
      $pos += 2
      if ($tile -eq 133 -and $y -gt 0) { $tile = $base[(($y - 1) * $w) + $x] }
      $base[($y * $w) + $x] = $tile
      if ($tile -gt 0) { [void]$needed.Add($tile - 1) }
    }
  }

  $objects = @()
  $layerMap = @(0, 1, 3)
  for ($layer = 0; $layer -lt 3; $layer++) {
    if ($pos + 2 -gt $bytes.Length) { break }
    $count = U16 $bytes $pos
    $pos += 2
    for ($i = 0; $i -lt $count; $i++) {
      $tile = U16 $bytes $pos
      $x = U16 $bytes ($pos + 2)
      $y = U16 $bytes ($pos + 4)
      $pos += 6
      if ($tile -gt 0) {
        $imgId = $tile - 1
        [void]$needed.Add($imgId)
        $objects += [pscustomobject]@{ ImgId = $imgId; X = $x; Y = $y; Layer = $layerMap[$layer] }
      }
    }
  }

  [pscustomobject]@{ Width = $w; Height = $h; Base = $base; Needed = $needed; Objects = $objects }
}

function Clear-OcclusionShadowPixels([Drawing.Bitmap]$Image) {
  $rect = New-Object Drawing.Rectangle 0, 0, $Image.Width, $Image.Height
  $format = [Drawing.Imaging.PixelFormat]::Format32bppArgb
  $data = $Image.LockBits($rect, [Drawing.Imaging.ImageLockMode]::ReadWrite, $format)
  try {
    $stride = $data.Stride
    $absStride = [Math]::Abs($stride)
    $bytes = New-Object byte[] ($absStride * $Image.Height)
    [Runtime.InteropServices.Marshal]::Copy($data.Scan0, $bytes, 0, $bytes.Length)

    for ($y = 0; $y -lt $Image.Height; $y++) {
      $row = if ($stride -gt 0) { $y * $stride } else { ($Image.Height - 1 - $y) * $absStride }
      for ($x = 0; $x -lt $Image.Width; $x++) {
        $i = $row + ($x * 4)
        $a = [int]$bytes[$i + 3]
        if ($a -eq 0) { continue }

        $b = [int]$bytes[$i]
        $g = [int]$bytes[$i + 1]
        $r = [int]$bytes[$i + 2]
        $max = [Math]::Max($r, [Math]::Max($g, $b))
        $min = [Math]::Min($r, [Math]::Min($g, $b))
        if (($max -le 70 -and ($max - $min) -le 28) -or ($max -le 50)) {
          $bytes[$i] = 0
          $bytes[$i + 1] = 0
          $bytes[$i + 2] = 0
          $bytes[$i + 3] = 0
        }
      }
    }

    [Runtime.InteropServices.Marshal]::Copy($bytes, 0, $data.Scan0, $bytes.Length)
  } finally {
    $Image.UnlockBits($data)
  }
}

function Render-Map([object]$Map, [string]$PreviewPath, [string]$OcclusionPath) {
  $outW = [int]($Map.Width * 60 * $Scale)
  $outH = [int]($Map.Height * 60 * $Scale)
  $preview = New-Object Drawing.Bitmap $outW, $outH, ([Drawing.Imaging.PixelFormat]::Format32bppArgb)
  $occlusion = New-Object Drawing.Bitmap $outW, $outH, ([Drawing.Imaging.PixelFormat]::Format32bppArgb)
  $g = [Drawing.Graphics]::FromImage($preview)
  $og = [Drawing.Graphics]::FromImage($occlusion)
  $g.Clear([Drawing.Color]::Black)
  $og.Clear([Drawing.Color]::Transparent)
  foreach ($ctx in @($g, $og)) {
    $ctx.InterpolationMode = [Drawing.Drawing2D.InterpolationMode]::NearestNeighbor
    $ctx.PixelOffsetMode = [Drawing.Drawing2D.PixelOffsetMode]::Half
    $ctx.CompositingMode = [Drawing.Drawing2D.CompositingMode]::SourceOver
  }

  try {
    for ($y = 0; $y -lt $Map.Height; $y++) {
      for ($x = 0; $x -lt $Map.Width; $x++) {
        $tile = $Map.Base[($y * $Map.Width) + $x]
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

    foreach ($obj in ($Map.Objects | Sort-Object Layer, Y, X)) {
      $png = Get-TilePng $obj.ImgId
      if (-not $png) { continue }
      $img = [Drawing.Image]::FromFile($png)
      try {
        $x = [int]($obj.X * $Scale)
        $y = [int]($obj.Y * $Scale)
        $w = [int]($img.Width * $Scale)
        $h = [int]($img.Height * $Scale)
        $g.DrawImage($img, $x, $y, $w, $h)
        if ($obj.Layer -ge $OcclusionMinLayer -and $LowPropTileIds -notcontains $obj.ImgId) {
          $og.DrawImage($img, $x, $y, $w, $h)
        }
      } finally {
        $img.Dispose()
      }
    }
  } finally {
    $g.Dispose()
    $og.Dispose()
  }

  Clear-OcclusionShadowPixels $occlusion
  $preview.Save($PreviewPath, [Drawing.Imaging.ImageFormat]::Png)
  $occlusion.Save($OcclusionPath, [Drawing.Imaging.ImageFormat]::Png)
  $preview.Dispose()
  $occlusion.Dispose()

  [pscustomobject]@{ Width = $outW; Height = $outH }
}

function Write-BlockJson([string]$BlkFile, [string]$OutPath, [int]$MapImageWidth, [int]$MapImageHeight) {
  $bytes = [IO.File]::ReadAllBytes($BlkFile)
  $w = U16 $bytes 0
  $h = U16 $bytes 2
  $chars = New-Object char[] ($w * $h)
  for ($i = 0; $i -lt $chars.Length; $i++) {
    $v = if (($i + 4) -lt $bytes.Length) { [int]$bytes[$i + 4] } else { 0 }
    $chars[$i] = if (($v -band 1) -ne 0) { '1' } else { '0' }
  }
  $obj = [ordered]@{
    width = $w
    height = $h
    passValue = 127
    blockedValue = 0
    mapImageWidth = $MapImageWidth
    mapImageHeight = $MapImageHeight
    mapNodeScale = $MapNodeScale
    data = -join $chars
  }
  Write-Utf8NoBom $OutPath ($obj | ConvertTo-Json -Compress)
}

function Write-Thumb([string]$Source, [string]$OutPath) {
  $img = [Drawing.Image]::FromFile($Source)
  try {
    $ratio = $ThumbWidth / [double]$img.Width
    $w = [int]$ThumbWidth
    $h = [int]([double]$img.Height * $ratio)
    $bmp = New-Object Drawing.Bitmap $w, $h
    $g = [Drawing.Graphics]::FromImage($bmp)
    try {
      $g.InterpolationMode = [Drawing.Drawing2D.InterpolationMode]::HighQualityBicubic
      $g.DrawImage($img, 0, 0, $w, $h)
    } finally {
      $g.Dispose()
    }
    $bmp.Save($OutPath, [Drawing.Imaging.ImageFormat]::Jpeg)
    $bmp.Dispose()
  } finally {
    $img.Dispose()
  }
}

if ($MapIds.Count -eq 0) {
  $MapIds = Get-ChildItem -LiteralPath $mapDir -Filter '*.map' |
    Where-Object { $_.BaseName -match '^\d+$' } |
    ForEach-Object { [int]$_.BaseName } |
    Sort-Object
}

$catalog = @()
$missingBlock = @()

foreach ($id in $MapIds) {
  $mapFile = Join-Path $mapDir "$id.map"
  if (-not (Test-Path -LiteralPath $mapFile)) { continue }

  $previewPath = Join-Path $outDir "map_${id}_preview.png"
  $occlusionPath = Join-Path $outDir "map_${id}_occlusion.png"
  $blockPath = Join-Path $outDir "map_${id}_block.json"
  $thumbPath = Join-Path $thumbDir ("map_{0:D3}.jpg" -f $id)

  $needsRender = $Force -or -not (Test-Path -LiteralPath $previewPath) -or -not (Test-Path -LiteralPath $occlusionPath)
  $map = Read-Map $mapFile
  if ($needsRender) {
    foreach ($tileId in $map.Needed) { [void](Get-TilePng $tileId) }
    $rendered = Render-Map $map $previewPath $occlusionPath
  } else {
    $img = [Drawing.Image]::FromFile($previewPath)
    try { $rendered = [pscustomobject]@{ Width = $img.Width; Height = $img.Height } } finally { $img.Dispose() }
  }

  Write-ImageMeta "$previewPath.meta" "map_${id}_preview" $rendered.Width $rendered.Height $false
  Write-ImageMeta "$occlusionPath.meta" "map_${id}_occlusion" $rendered.Width $rendered.Height $true

  $blkFile = Join-Path $mapDir "$id.blk"
  $hasBlock = Test-Path -LiteralPath $blkFile
  if ($hasBlock) {
    Write-BlockJson $blkFile $blockPath $rendered.Width $rendered.Height
    Write-JsonMeta "$blockPath.meta"
  } else {
    $missingBlock += $id
  }

  Write-Thumb $previewPath $thumbPath
  $catalog += [pscustomobject]@{
    id = $id
    width = $rendered.Width
    height = $rendered.Height
    tileWidth = $map.Width
    tileHeight = $map.Height
    objectCount = $map.Objects.Count
    hasBlock = $hasBlock
    preview = "maps/map_${id}_preview"
    occlusion = "maps/map_${id}_occlusion"
    block = if ($hasBlock) { "maps/map_${id}_block" } else { $null }
    thumbnail = "MAP_CATALOG/map_{0:D3}.jpg" -f $id
  }
  "map=$id size=$($rendered.Width)x$($rendered.Height) objects=$($map.Objects.Count) block=$hasBlock"
}

$catalogJson = Join-Path $outDir 'map_catalog.json'
Write-Utf8NoBom $catalogJson ($catalog | ConvertTo-Json -Depth 4)
Write-JsonMeta "$catalogJson.meta"

$md = @("# Map Catalog", "", "Generated from old client maps.", "", "| id | size | tiles | objects | block | thumbnail |", "| --- | --- | --- | --- | --- | --- |")
foreach ($item in $catalog) {
  $block = if ($item.hasBlock) { 'yes' } else { 'missing' }
  $md += "| $($item.id) | $($item.width)x$($item.height) | $($item.tileWidth)x$($item.tileHeight) | $($item.objectCount) | $block | $($item.thumbnail) |"
}
if ($missingBlock.Count) {
  $md += ""
  $md += "Maps without .blk collision: " + (($missingBlock | Sort-Object) -join ', ')
}
Write-Utf8NoBom (Join-Path $Root 'MAP_CATALOG.md') ($md -join "`n")

$blockCount = @($catalog | Where-Object hasBlock).Count
"done maps=$($catalog.Count) blocks=$blockCount missingBlocks=$($missingBlock.Count) thumbs=$thumbDir"
