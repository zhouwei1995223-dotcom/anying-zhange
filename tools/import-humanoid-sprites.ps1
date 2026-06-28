param(
  [string]$Root = (Resolve-Path "$PSScriptRoot\..").Path,
  [string]$SourceDir = '',
  [string]$HeroId = 'humanoid_00',
  [double]$Scale = 0.35,
  [int]$CanvasSize = 150,
  [int]$FootX = 75,
  [int]$FootY = 96,
  [string]$PreviewPath = ''
)

$ErrorActionPreference = 'Stop'

if (-not $SourceDir) {
  $SourceDir = Get-ChildItem -LiteralPath $Root -Directory -Recurse |
    Where-Object { $_.Name -eq ([string]([char]0x4eba) + [string]([char]0x5f62) + [string]([char]0x7d20) + [string]([char]0x6750)) } |
    Select-Object -First 1 -ExpandProperty FullName
}
if (-not (Test-Path -LiteralPath $SourceDir)) {
  throw "SourceDir not found: $SourceDir"
}

if (-not $PreviewPath) {
  $PreviewPath = Join-Path $Root "${HeroId}_import_preview.png"
}

$outRoot = Join-Path $Root "cocos-remake\assets\resources\heroes\$HeroId"
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

function Get-Bounds([System.Drawing.Bitmap]$Bitmap) {
  $minX = $Bitmap.Width
  $minY = $Bitmap.Height
  $maxX = -1
  $maxY = -1

  for ($y = 0; $y -lt $Bitmap.Height; $y++) {
    for ($x = 0; $x -lt $Bitmap.Width; $x++) {
      $c = $Bitmap.GetPixel($x, $y)
      if ($c.A -gt 10 -and -not ($c.R -lt 3 -and $c.G -lt 3 -and $c.B -lt 3)) {
        if ($x -lt $minX) { $minX = $x }
        if ($y -lt $minY) { $minY = $y }
        if ($x -gt $maxX) { $maxX = $x }
        if ($y -gt $maxY) { $maxY = $y }
      }
    }
  }

  if ($maxX -lt $minX -or $maxY -lt $minY) {
    return [pscustomobject]@{ X = 0; Y = 0; W = $Bitmap.Width; H = $Bitmap.Height }
  }
  [pscustomobject]@{ X = $minX; Y = $minY; W = $maxX - $minX + 1; H = $maxY - $minY + 1 }
}

function Convert-Frame([string]$Src, [string]$Dst) {
  $srcBmp = [System.Drawing.Bitmap]::FromFile($Src)
  try {
    $bounds = Get-Bounds $srcBmp
    $dstBmp = New-Object System.Drawing.Bitmap -ArgumentList $script:CanvasSize, $script:CanvasSize, ([System.Drawing.Imaging.PixelFormat]::Format32bppArgb)
    try {
      $g = [System.Drawing.Graphics]::FromImage($dstBmp)
      try {
        $g.Clear([System.Drawing.Color]::Transparent)
        $g.InterpolationMode = [System.Drawing.Drawing2D.InterpolationMode]::HighQualityBicubic
        $g.PixelOffsetMode = [System.Drawing.Drawing2D.PixelOffsetMode]::Half
        $dw = [Math]::Max(1, [int][Math]::Round($bounds.W * $script:Scale))
        $dh = [Math]::Max(1, [int][Math]::Round($bounds.H * $script:Scale))
        $dx = [int][Math]::Round($script:FootX - ($dw / 2))
        $dy = [int][Math]::Round($script:FootY - $dh)
        $srcRect = New-Object System.Drawing.Rectangle -ArgumentList $bounds.X, $bounds.Y, $bounds.W, $bounds.H
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

if (Test-Path -LiteralPath $outRoot) {
  Remove-Item -LiteralPath $outRoot -Recurse -Force
}
Ensure-Dir $outRoot

$sets = @(
  @{ Action = 'idle'; Base = 2880; Frames = 4; Prefix = 'idle_' },
  @{ Action = 'walk'; Base = 2960; Frames = 6; Prefix = 'walk_' },
  @{ Action = 'attack'; Base = 3040; Frames = 8; Prefix = 'attack_' }
)

foreach ($set in $sets) {
  $actionDir = Join-Path $outRoot $set.Action
  Ensure-Dir $actionDir
  for ($dir = 0; $dir -lt 8; $dir++) {
    $dirPath = Join-Path $actionDir "d$dir"
    Ensure-Dir $dirPath
    for ($frame = 0; $frame -lt $set.Frames; $frame++) {
      $srcId = $set.Base + ($dir * 10) + $frame
      $src = Join-Path $SourceDir ('{0:D5}.PNG' -f $srcId)
      if (-not (Test-Path -LiteralPath $src)) {
        throw "Missing source frame: $src"
      }
      $name = '{0}{1:D2}' -f $set.Prefix, $frame
      $dst = Join-Path $dirPath "$name.png"
      Convert-Frame $src $dst
      Write-ImageMeta "$dst.meta" $name $CanvasSize $CanvasSize
    }
  }
}

# The runtime uses one idle clip shared by all directions. Keep the d4/front idle row.
for ($frame = 0; $frame -lt 4; $frame++) {
  $src = Join-Path (Join-Path $outRoot 'idle') ('idle_{0:D2}.png' -f $frame)
  $dir4 = Join-Path (Join-Path $outRoot 'idle') 'd4'
  $from = Join-Path $dir4 ('idle_{0:D2}.png' -f $frame)
  Copy-Item -LiteralPath $from -Destination $src -Force
  if (Test-Path -LiteralPath "$src.meta") { Remove-Item -LiteralPath "$src.meta" -Force }
  Write-ImageMeta "$src.meta" ('idle_{0:D2}' -f $frame) $CanvasSize $CanvasSize
}

$previewCell = 150
$previewCols = 8
$previewRows = 3
$preview = New-Object System.Drawing.Bitmap -ArgumentList ($previewCell * $previewCols),($previewCell * $previewRows),([System.Drawing.Imaging.PixelFormat]::Format32bppArgb)
$pg = [System.Drawing.Graphics]::FromImage($preview)
try {
  $pg.Clear([System.Drawing.Color]::FromArgb(18, 22, 28))
  $font = New-Object System.Drawing.Font -ArgumentList 'Consolas', 9
  try {
    $brush = [System.Drawing.Brushes]::White
    $labels = @('idle', 'walk', 'attack')
    for ($row = 0; $row -lt $previewRows; $row++) {
      for ($dir = 0; $dir -lt 8; $dir++) {
        $action = $labels[$row]
        $file = if ($action -eq 'idle') {
          Join-Path (Join-Path $outRoot 'idle') ('d{0}\idle_00.png' -f $dir)
        } else {
          Join-Path (Join-Path (Join-Path $outRoot $action) "d$dir") ("${action}_00.png")
        }
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
  } finally {
    $font.Dispose()
  }
  $preview.Save($PreviewPath, [System.Drawing.Imaging.ImageFormat]::Png)
} finally {
  $pg.Dispose()
  $preview.Dispose()
}

Write-Output "Imported $HeroId to $outRoot"
Write-Output "Preview: $PreviewPath"
