param(
  [string]$Root = (Resolve-Path "$PSScriptRoot\..").Path,
  [string]$HeroId = 'hero_00',
  [int]$AppearanceId = 8,
  [string[]]$Actions = @('idle', 'walk'),
  [int]$AlphaThreshold = 64,
  [int]$RgbThreshold = 20
)

$ErrorActionPreference = 'Stop'

Add-Type -AssemblyName System.Drawing

$outRoot = Join-Path $Root "cocos-remake\assets\resources\heroes\$HeroId\appearance_$AppearanceId"
if (-not (Test-Path -LiteralPath $outRoot)) {
  throw "Appearance path not found: $outRoot"
}

function Get-VisualBounds([System.Drawing.Bitmap]$Bitmap) {
  $minX = $Bitmap.Width
  $minY = $Bitmap.Height
  $maxX = -1
  $maxY = -1
  $count = 0

  for ($y = 0; $y -lt $Bitmap.Height; $y++) {
    for ($x = 0; $x -lt $Bitmap.Width; $x++) {
      $p = $Bitmap.GetPixel($x, $y)
      if ($p.A -gt $script:AlphaThreshold -and (($p.R + $p.G + $p.B) -gt $script:RgbThreshold)) {
        if ($x -lt $minX) { $minX = $x }
        if ($y -lt $minY) { $minY = $y }
        if ($x -gt $maxX) { $maxX = $x }
        if ($y -gt $maxY) { $maxY = $y }
        $count++
      }
    }
  }

  if ($count -eq 0) { return $null }

  [pscustomobject]@{
    MinX = $minX
    MinY = $minY
    MaxX = $maxX
    MaxY = $maxY
    Cx = ($minX + $maxX) / 2.0
    FootY = $maxY
    Count = $count
  }
}

function Get-ImageBounds([string]$Path) {
  $bmp = [System.Drawing.Bitmap]::FromFile($Path)
  try {
    return Get-VisualBounds $bmp
  } finally {
    $bmp.Dispose()
  }
}

function Get-Median([double[]]$Values) {
  if (-not $Values -or $Values.Count -eq 0) { return 0 }
  $sorted = @($Values | Sort-Object)
  $middle = [int][Math]::Floor($sorted.Count / 2)
  if (($sorted.Count % 2) -eq 1) { return [double]$sorted[$middle] }
  return ([double]$sorted[$middle - 1] + [double]$sorted[$middle]) / 2.0
}

function Shift-Image([string]$Path, [int]$Dx, [int]$Dy) {
  if ($Dx -eq 0 -and $Dy -eq 0) { return }

  $src = [System.Drawing.Bitmap]::FromFile($Path)
  try {
    $dst = New-Object System.Drawing.Bitmap -ArgumentList $src.Width, $src.Height, ([System.Drawing.Imaging.PixelFormat]::Format32bppArgb)
    try {
      $g = [System.Drawing.Graphics]::FromImage($dst)
      try {
        $g.Clear([System.Drawing.Color]::Transparent)
        $g.CompositingMode = [System.Drawing.Drawing2D.CompositingMode]::SourceOver
        $g.InterpolationMode = [System.Drawing.Drawing2D.InterpolationMode]::NearestNeighbor
        $g.PixelOffsetMode = [System.Drawing.Drawing2D.PixelOffsetMode]::Half
        $g.DrawImageUnscaled($src, $Dx, $Dy)
      } finally {
        $g.Dispose()
      }

      $tmp = "$Path.tmp.png"
      $dst.Save($tmp, [System.Drawing.Imaging.ImageFormat]::Png)
    } finally {
      $dst.Dispose()
    }
  } finally {
    $src.Dispose()
  }

  Move-Item -LiteralPath "$Path.tmp.png" -Destination $Path -Force
}

$summary = @()

foreach ($action in $Actions) {
  $actionRoot = Join-Path $outRoot $action
  if (-not (Test-Path -LiteralPath $actionRoot)) { continue }

  for ($dir = 0; $dir -lt 8; $dir++) {
    $dirRoot = Join-Path $actionRoot "d$dir"
    if (-not (Test-Path -LiteralPath $dirRoot)) { continue }

    $frames = @(Get-ChildItem -LiteralPath $dirRoot -Filter "${action}_*.png" -File | Sort-Object Name)
    if ($frames.Count -eq 0) { continue }

    $bounds = @()
    foreach ($frame in $frames) {
      $b = Get-ImageBounds $frame.FullName
      if ($b) {
        $bounds += [pscustomobject]@{ File = $frame; Bounds = $b }
      }
    }
    if ($bounds.Count -eq 0) { continue }

    $targetCx = Get-Median ([double[]]($bounds | ForEach-Object { $_.Bounds.Cx }))
    $targetFootY = Get-Median ([double[]]($bounds | ForEach-Object { $_.Bounds.FootY }))
    $changed = 0

    foreach ($item in $bounds) {
      $dx = [int][Math]::Round($targetCx - $item.Bounds.Cx)
      $dy = [int][Math]::Round($targetFootY - $item.Bounds.FootY)
      if ($dx -ne 0 -or $dy -ne 0) {
        Shift-Image $item.File.FullName $dx $dy
        $changed++
      }
    }

    $summary += [pscustomobject]@{
      Action = $action
      Dir = $dir
      Frames = $frames.Count
      TargetCx = [Math]::Round($targetCx, 2)
      TargetFootY = [Math]::Round($targetFootY, 2)
      Changed = $changed
    }
  }
}

$idleFront = Join-Path $outRoot 'idle\d4'
$idleRoot = Join-Path $outRoot 'idle'
if (Test-Path -LiteralPath $idleFront) {
  for ($frame = 0; $frame -lt 4; $frame++) {
    $from = Join-Path $idleFront ('idle_{0:D2}.png' -f $frame)
    $to = Join-Path $idleRoot ('idle_{0:D2}.png' -f $frame)
    if (Test-Path -LiteralPath $from) {
      Copy-Item -LiteralPath $from -Destination $to -Force
    }
  }
}

$summary | Format-Table -AutoSize
