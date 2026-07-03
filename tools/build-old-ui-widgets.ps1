param(
  [string]$OldUiSheet = "",
  [string]$OutputRoot = "cocos-remake/assets/resources/ui/old"
)

$ErrorActionPreference = "Stop"
Add-Type -AssemblyName System.Drawing

$repoRoot = Split-Path -Parent $PSScriptRoot
if ([string]::IsNullOrWhiteSpace($OldUiSheet)) {
  $match = Get-ChildItem -LiteralPath $repoRoot -Recurse -Filter "ui.png" -File |
    Where-Object { $_.FullName -replace "\\", "/" -like "*/client/image/ui/ui.png" } |
    Select-Object -First 1
  if ($match) {
    $OldUiSheet = $match.FullName
  }
}
if (-not [System.IO.Path]::IsPathRooted($OldUiSheet)) {
  $OldUiSheet = Join-Path $repoRoot $OldUiSheet
}
if (-not [System.IO.Path]::IsPathRooted($OutputRoot)) {
  $OutputRoot = Join-Path $repoRoot $OutputRoot
}
if (-not (Test-Path -LiteralPath $OldUiSheet)) {
  throw "Old UI sheet not found: $OldUiSheet"
}

function New-CompactGuid {
  return ([guid]::NewGuid().ToString("N"))
}

function Write-DirectoryMeta([string]$DirPath) {
  $metaPath = "$DirPath.meta"
  if (Test-Path -LiteralPath $metaPath) { return }
  $uuid = New-CompactGuid
  $json = @"
{
  "ver": "1.1.0",
  "importer": "directory",
  "imported": true,
  "uuid": "$uuid",
  "files": [],
  "subMetas": {},
  "userData": {}
}
"@
  Set-Content -LiteralPath $metaPath -Value $json -Encoding UTF8
}

function Write-ImageMeta([string]$PngPath, [int]$Width, [int]$Height) {
  $metaPath = "$PngPath.meta"
  if (Test-Path -LiteralPath $metaPath) { return }
  $name = [System.IO.Path]::GetFileNameWithoutExtension($PngPath)
  $uuid = New-CompactGuid
  $textureUuid = "$uuid@6c48a"
  $frameUuid = "$uuid@f9941"
  $halfW = $Width / 2
  $halfH = $Height / 2
  $json = @"
{
  "ver": "1.0.27",
  "importer": "image",
  "imported": true,
  "uuid": "$uuid",
  "files": [".json", ".png"],
  "subMetas": {
    "6c48a": {"importer":"texture","uuid":"$textureUuid","displayName":"$name","id":"6c48a","name":"texture","userData":{"wrapModeS":"clamp-to-edge","wrapModeT":"clamp-to-edge","imageUuidOrDatabaseUri":"$uuid","isUuid":true,"visible":false,"minfilter":"nearest","magfilter":"nearest","mipfilter":"none","anisotropy":0},"ver":"1.0.22","imported":true,"files":[".json"],"subMetas":{}},
    "f9941": {"importer":"sprite-frame","uuid":"$frameUuid","displayName":"$name","id":"f9941","name":"spriteFrame","userData":{"trimThreshold":1,"rotated":false,"offsetX":0,"offsetY":0,"trimX":0,"trimY":0,"width":$Width,"height":$Height,"rawWidth":$Width,"rawHeight":$Height,"borderTop":0,"borderBottom":0,"borderLeft":0,"borderRight":0,"packable":false,"pixelsToUnit":100,"pivotX":0.5,"pivotY":0.5,"meshType":0,"vertices":{"rawPosition":[-$halfW,-$halfH,0,$halfW,-$halfH,0,-$halfW,$halfH,0,$halfW,$halfH,0],"indexes":[0,1,2,2,1,3],"uv":[0,$Height,$Width,$Height,0,0,$Width,0],"nuv":[0,0,1,0,0,1,1,1],"minPos":[-$halfW,-$halfH,0],"maxPos":[$halfW,$halfH,0]},"isUuid":true,"imageUuidOrDatabaseUri":"$textureUuid","atlasUuid":"","trimType":"custom"},"ver":"1.0.12","imported":true,"files":[".json"],"subMetas":{}}
  },
  "userData": {"type":"sprite-frame","fixAlphaTransparencyArtifacts":false,"hasAlpha":true,"redirect":"$textureUuid"}
}
"@
  Set-Content -LiteralPath $metaPath -Value $json -Encoding UTF8
}

function Save-Crop([System.Drawing.Bitmap]$Sheet, [string]$Name, [int]$X, [int]$Y, [int]$Width, [int]$Height) {
  $pngPath = Join-Path $OutputRoot "$Name.png"
  $bmp = New-Object System.Drawing.Bitmap($Width, $Height)
  $g = [System.Drawing.Graphics]::FromImage($bmp)
  $g.InterpolationMode = [System.Drawing.Drawing2D.InterpolationMode]::NearestNeighbor
  $g.PixelOffsetMode = [System.Drawing.Drawing2D.PixelOffsetMode]::Half
  $g.DrawImage($Sheet, [System.Drawing.Rectangle]::new(0, 0, $Width, $Height), [System.Drawing.Rectangle]::new($X, $Y, $Width, $Height), [System.Drawing.GraphicsUnit]::Pixel)
  $bmp.Save($pngPath, [System.Drawing.Imaging.ImageFormat]::Png)
  $g.Dispose()
  $bmp.Dispose()
  Write-ImageMeta $pngPath $Width $Height
}

New-Item -ItemType Directory -Force -Path $OutputRoot | Out-Null
Write-DirectoryMeta (Split-Path -Parent $OutputRoot)
Write-DirectoryMeta $OutputRoot

$sheet = [System.Drawing.Bitmap]::FromFile($OldUiSheet)
try {
  # Old client b.a.c.b.al default button: left/mid/right pieces tiled across width.
  Save-Crop $sheet "button_normal_left" 20 57 11 24
  Save-Crop $sheet "button_normal_mid" 35 57 16 24
  Save-Crop $sheet "button_normal_right" 59 57 11 24
  Save-Crop $sheet "button_hover_left" 20 85 11 24
  Save-Crop $sheet "button_hover_mid" 35 85 16 24
  Save-Crop $sheet "button_hover_right" 59 85 11 24
  Save-Crop $sheet "button_pressed_left" 20 162 11 24
  Save-Crop $sheet "button_pressed_mid" 35 162 16 24
  Save-Crop $sheet "button_pressed_right" 59 162 11 24

  # Old client b.a.c.b.e popup frame:
  # e.for(...) draws the top strip, e.a(...) draws the bottom strip, e.if(...) draws thin side/content frame pieces.
  Save-Crop $sheet "popup_top_left" 88 58 17 26
  Save-Crop $sheet "popup_top_mid" 114 58 15 26
  Save-Crop $sheet "popup_top_right" 140 58 13 26
  Save-Crop $sheet "popup_bottom_left" 88 92 17 26
  Save-Crop $sheet "popup_bottom_mid" 114 92 15 26
  Save-Crop $sheet "popup_bottom_right" 140 92 13 26
  Save-Crop $sheet "popup_inner_top_left" 194 98 14 4
  Save-Crop $sheet "popup_inner_top_right" 222 98 16 4
  Save-Crop $sheet "popup_inner_left_top" 194 102 4 10
  Save-Crop $sheet "popup_inner_left_bottom" 194 120 4 14
  Save-Crop $sheet "popup_inner_bottom_left" 198 131 9 3
  Save-Crop $sheet "popup_inner_bottom_right" 222 131 16 3
  Save-Crop $sheet "popup_inner_right_top" 234 102 4 12
  Save-Crop $sheet "popup_inner_right_bottom" 234 120 4 10

  # Old client b.a.c.b.q stat panel point buttons.
  Save-Crop $sheet "stat_point_add" 0 188 8 8
  Save-Crop $sheet "stat_point_reduce" 8 188 8 8
}
finally {
  $sheet.Dispose()
}

Write-Host "Old UI widget assets written to $OutputRoot"
