param(
  [string]$Root = (Resolve-Path "$PSScriptRoot\..").Path,
  [string]$LegacyRoot = '',
  [string]$OutputRoot = '',
  [string]$CatalogOutput = ''
)

$ErrorActionPreference = 'Stop'
$Utf8NoBom = New-Object System.Text.UTF8Encoding($false)

Add-Type -AssemblyName System.Drawing

if (-not $LegacyRoot) {
  $match = Get-ChildItem -LiteralPath $Root -Directory |
    Where-Object { Test-Path -LiteralPath (Join-Path $_.FullName 'client\image\magic') } |
    Select-Object -First 1
  if (-not $match) { throw "Could not locate legacy client\image\magic under $Root." }
  $LegacyRoot = $match.FullName
}
if (-not $OutputRoot) { $OutputRoot = Join-Path $Root 'cocos-remake\assets\resources' }
if (-not $CatalogOutput) { $CatalogOutput = Join-Path $OutputRoot 'skills\skill_catalog.json' }

$magicInput = Join-Path $LegacyRoot 'client\image\magic'
$iconInput = Join-Path $LegacyRoot 'client\image\ui\icon.gif'
$damageInput = Join-Path $LegacyRoot 'server\config\data\damage_spells.txt'
$effectInput = Join-Path $LegacyRoot 'server\config\data\effect_spells.txt'
$stateInput = Join-Path $LegacyRoot 'server\config\data\state_spells.txt'
$effectOutput = Join-Path $OutputRoot 'skill_effects'
$iconOutput = Join-Path $OutputRoot 'skill_icons'
$skillOutput = Split-Path -Parent $CatalogOutput
$skillIconSourceY = 492

if (-not (Test-Path -LiteralPath $magicInput)) { throw "Magic GIF folder not found: $magicInput" }
if (-not (Test-Path -LiteralPath $iconInput)) { throw "Icon sheet not found: $iconInput" }
if (-not (Test-Path -LiteralPath $damageInput)) { throw "Damage spell data not found: $damageInput" }

function New-CompactGuid {
  return ([guid]::NewGuid().ToString('N'))
}

function Write-TextNoBom([string]$Path, [string]$Text) {
  [IO.File]::WriteAllText($Path, $Text, $Utf8NoBom)
}

function Write-DirectoryMeta([string]$DirPath) {
  $metaPath = "$DirPath.meta"
  if (Test-Path -LiteralPath $metaPath) { return }
  $uuid = New-CompactGuid
  Write-TextNoBom $metaPath @"
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
}

function Write-JsonMeta([string]$JsonPath) {
  $metaPath = "$JsonPath.meta"
  if (Test-Path -LiteralPath $metaPath) { return }
  $uuid = [guid]::NewGuid().ToString()
  Write-TextNoBom $metaPath @"
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
}

function Write-ImageMeta([string]$PngPath, [int]$Width, [int]$Height) {
  $metaPath = "$PngPath.meta"
  if (Test-Path -LiteralPath $metaPath) { return }
  $name = [IO.Path]::GetFileNameWithoutExtension($PngPath)
  $uuid = [guid]::NewGuid().ToString()
  $textureUuid = "$uuid@6c48a"
  $frameUuid = "$uuid@f9941"
  $halfW = $Width / 2
  $halfH = $Height / 2
  Write-TextNoBom $metaPath @"
{
  "ver": "1.0.27",
  "importer": "image",
  "imported": true,
  "uuid": "$uuid",
  "files": [".json", ".png"],
  "subMetas": {
    "6c48a": {"importer":"texture","uuid":"$textureUuid","displayName":"$name","id":"6c48a","name":"texture","userData":{"wrapModeS":"clamp-to-edge","wrapModeT":"clamp-to-edge","imageUuidOrDatabaseUri":"$uuid","isUuid":true,"visible":false,"minfilter":"linear","magfilter":"linear","mipfilter":"none","anisotropy":0},"ver":"1.0.22","imported":true,"files":[".json"],"subMetas":{}},
    "f9941": {"importer":"sprite-frame","uuid":"$frameUuid","displayName":"$name","id":"f9941","name":"spriteFrame","userData":{"trimThreshold":1,"rotated":false,"offsetX":0,"offsetY":0,"trimX":0,"trimY":0,"width":$Width,"height":$Height,"rawWidth":$Width,"rawHeight":$Height,"borderTop":0,"borderBottom":0,"borderLeft":0,"borderRight":0,"packable":true,"pixelsToUnit":100,"pivotX":0.5,"pivotY":0.5,"meshType":0,"vertices":{"rawPosition":[-$halfW,-$halfH,0,$halfW,-$halfH,0,-$halfW,$halfH,0,$halfW,$halfH,0],"indexes":[0,1,2,2,1,3],"uv":[0,$Height,$Width,$Height,0,0,$Width,0],"nuv":[0,0,1,0,0,1,1,1],"minPos":[-$halfW,-$halfH,0],"maxPos":[$halfW,$halfH,0]},"isUuid":true,"imageUuidOrDatabaseUri":"$textureUuid","atlasUuid":"","trimType":"auto"},"ver":"1.0.12","imported":true,"files":[".json"],"subMetas":{}}
  },
  "userData": {"type":"sprite-frame","fixAlphaTransparencyArtifacts":false,"hasAlpha":true,"redirect":"$textureUuid"}
}
"@
}

function Save-GifFrames([string]$GifPath, [string]$Name, [int]$MagicId, [string]$OutDir) {
  $magicFrameWidths = @{
    1 = 200; 2 = 200; 3 = 300; 4 = 252; 5 = 244; 6 = 266;
    7 = 200; 8 = 200; 9 = 200; 10 = 200; 11 = 116
  }
  New-Item -ItemType Directory -Force -Path $OutDir | Out-Null
  Write-DirectoryMeta $OutDir
  Get-ChildItem -LiteralPath $OutDir -File -Filter "$Name*.png*" -ErrorAction SilentlyContinue | Remove-Item -Force
  $image = [Drawing.Image]::FromFile($GifPath)
  try {
    $frameWidth = if ($magicFrameWidths.ContainsKey($MagicId)) { [int]$magicFrameWidths[$MagicId] } else { [int]$image.Height }
    $count = [Math]::Max(1, [Math]::Floor($image.Width / $frameWidth))
    for ($i = 0; $i -lt $count; $i++) {
      $bmp = New-Object Drawing.Bitmap $frameWidth, $image.Height, ([Drawing.Imaging.PixelFormat]::Format32bppArgb)
      try {
        $g = [Drawing.Graphics]::FromImage($bmp)
        $g.Clear([Drawing.Color]::Transparent)
        $g.DrawImage(
          $image,
          [Drawing.Rectangle]::new(0, 0, $frameWidth, $image.Height),
          [Drawing.Rectangle]::new($i * $frameWidth, 0, $frameWidth, $image.Height),
          [Drawing.GraphicsUnit]::Pixel
        )
        $g.Dispose()
        $path = Join-Path $OutDir ("{0}_{1:00}.png" -f $Name, $i)
        $bmp.Save($path, [Drawing.Imaging.ImageFormat]::Png)
        Write-ImageMeta $path $bmp.Width $bmp.Height
      } finally {
        $bmp.Dispose()
      }
    }
    return $count
  } finally {
    $image.Dispose()
  }
}

function Save-SkillIcon([Drawing.Bitmap]$Sheet, [int]$IconId, [string]$Path) {
  $icon = [Math]::Max(1, $IconId)
  $srcX = ($icon - 1) * 24
  $srcY = $skillIconSourceY
  if ($srcX -lt 0 -or $srcX + 24 -gt $Sheet.Width -or $srcY + 24 -gt $Sheet.Height) { return $false }
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
  Write-ImageMeta $Path 24 24
  return $true
}

function Read-Table([string]$Path) {
  if (-not (Test-Path -LiteralPath $Path)) { return @() }
  $lines = Get-Content -LiteralPath $Path -Encoding Default
  if ($lines.Count -lt 3) { return @() }
  $headers = $lines[1] -split "`t"
  return @($lines | Select-Object -Skip 2 | ConvertFrom-Csv -Delimiter "`t" -Header $headers)
}

function To-Int($Value, [int]$Default = 0) {
  $n = 0
  if ([int]::TryParse([string]$Value, [ref]$n)) { return $n }
  return $Default
}

function Map-MagicId([int]$Id) {
  if ($Id -le 0) { return 0 }
  return (($Id - 1) % 11) + 1
}

New-Item -ItemType Directory -Force -Path $effectOutput, $iconOutput, $skillOutput | Out-Null
Write-DirectoryMeta (Split-Path -Parent $effectOutput)
Write-DirectoryMeta $effectOutput
Write-DirectoryMeta $iconOutput
Write-DirectoryMeta $skillOutput

$magicCounts = @{}
foreach ($gif in Get-ChildItem -LiteralPath $magicInput -Filter '*.gif' -File) {
  $magicId = [int][IO.Path]::GetFileNameWithoutExtension($gif.Name)
  $name = "magic_$magicId"
  $outDir = Join-Path $effectOutput $name
  $count = Save-GifFrames $gif.FullName $name $magicId $outDir
  $magicCounts[$magicId] = $count
}

$damageRows = Read-Table $damageInput
$effectRows = Read-Table $effectInput
$stateRows = Read-Table $stateInput
$allRows = @()

foreach ($row in $damageRows) {
  $id = To-Int $row.id
  if ($id -le 0) { continue }
  $flyer = To-Int $row.flyerType
  $animation = To-Int $row.animation
  $allRows += [pscustomobject]@{
    id = $id
    name = $row.name
    type = 'damage'
    race = [Math]::Floor($id / 10000) % 100
    group = [Math]::Floor($id / 100)
    level = To-Int $row.level
    icon = To-Int $row.icon
    flyerType = $flyer
    projectileMagicId = Map-MagicId $flyer
    projectilePath = if ($flyer -gt 0) { "skill_effects/magic_$(Map-MagicId $flyer)/magic_$(Map-MagicId $flyer)_" } else { '' }
    projectileFrameCount = if ($flyer -gt 0 -and $magicCounts.ContainsKey((Map-MagicId $flyer))) { $magicCounts[(Map-MagicId $flyer)] } else { 0 }
    animation = $animation
    effectMagicId = Map-MagicId $animation
    effectPath = if ($animation -gt 0) { "skill_effects/magic_$(Map-MagicId $animation)/magic_$(Map-MagicId $animation)_" } else { '' }
    effectFrameCount = if ($animation -gt 0 -and $magicCounts.ContainsKey((Map-MagicId $animation))) { $magicCounts[(Map-MagicId $animation)] } else { 0 }
    timeLast = To-Int $row.timeLast
    releaseRange = To-Int $row.releaseRange
    maxExperience = To-Int $row.maxExperience
    requiredLevel = To-Int $row.requiredLevel
    nextLevelSkillId = To-Int $row.nextLevelSpellID
    manaCost = To-Int $row.manaCost
    minDamage = To-Int $row.minDamage
    maxDamage = To-Int $row.maxDamage
    selfCoolTime = To-Int $row.selfCoolTime
    globalCoolTime = To-Int $row.globalCoolTime
    damageType = To-Int $row.damageType
    strengthFactor = To-Int $row.strengthFactor
    wisdomFactor = To-Int $row.wisdomFactor
    dexterityFactor = To-Int $row.dexterityFactor
    selfPhysicalDamageFactor = To-Int $row.selfPhysicalDamageFactor
    selfMagicDamageFactor = To-Int $row.selfMagicDamageFactor
    description = $row.description
    iconPath = if ((To-Int $row.icon) -gt 0) { "skill_icons/skill_icon_$(To-Int $row.icon)" } else { '' }
  }
}

foreach ($row in $effectRows) {
  $id = To-Int $row.id
  if ($id -le 0) { continue }
  $animation = To-Int $row.effectAnimation
  $allRows += [pscustomobject]@{
    id = $id
    name = $row.name
    type = 'scene'
    race = [Math]::Floor($id / 10000) % 100
    group = [Math]::Floor($id / 100)
    level = To-Int $row.level
    icon = To-Int $row.icon
    flyerType = 0
    projectileMagicId = 0
    projectilePath = ''
    projectileFrameCount = 0
    animation = $animation
    effectMagicId = Map-MagicId $animation
    effectPath = if ($animation -gt 0) { "skill_effects/magic_$(Map-MagicId $animation)/magic_$(Map-MagicId $animation)_" } else { '' }
    effectFrameCount = if ($animation -gt 0 -and $magicCounts.ContainsKey((Map-MagicId $animation))) { $magicCounts[(Map-MagicId $animation)] } else { 0 }
    timeLast = To-Int $row.effectLifeTime
    releaseRange = To-Int $row.releaseRange
    maxExperience = To-Int $row.maxExperience
    requiredLevel = To-Int $row.requiredLevel
    nextLevelSkillId = To-Int $row.nextLevelSpellID
    manaCost = To-Int $row.manaCost
    minDamage = To-Int $row.lifeChanged
    maxDamage = To-Int $row.lifeChanged
    selfCoolTime = To-Int $row.selfCoolTime
    globalCoolTime = To-Int $row.globalCoolTime
    damageType = 0
    strengthFactor = To-Int $row.strengthFactor
    wisdomFactor = To-Int $row.wisdomFactor
    dexterityFactor = To-Int $row.dexterityFactor
    selfPhysicalDamageFactor = 0
    selfMagicDamageFactor = 0
    description = $row.description
    iconPath = if ((To-Int $row.icon) -gt 0) { "skill_icons/skill_icon_$(To-Int $row.icon)" } else { '' }
  }
}

foreach ($row in $stateRows) {
  $id = To-Int $row.id
  if ($id -le 0) { continue }
  $animation = To-Int $row.animation
  $allRows += [pscustomobject]@{
    id = $id
    name = $row.name
    type = 'state'
    race = [Math]::Floor($id / 10000) % 100
    group = [Math]::Floor($id / 100)
    level = To-Int $row.level
    icon = To-Int $row.icon
    flyerType = 0
    projectileMagicId = 0
    projectilePath = ''
    projectileFrameCount = 0
    animation = $animation
    effectMagicId = Map-MagicId $animation
    effectPath = if ($animation -gt 0) { "skill_effects/magic_$(Map-MagicId $animation)/magic_$(Map-MagicId $animation)_" } else { '' }
    effectFrameCount = if ($animation -gt 0 -and $magicCounts.ContainsKey((Map-MagicId $animation))) { $magicCounts[(Map-MagicId $animation)] } else { 0 }
    timeLast = To-Int $row.timeLast
    releaseRange = To-Int $row.releaseRange
    maxExperience = To-Int $row.maxExperience
    requiredLevel = To-Int $row.requiredLevel
    nextLevelSkillId = To-Int $row.nextLevelSpellID
    manaCost = To-Int $row.manaCost
    minDamage = 0
    maxDamage = 0
    selfCoolTime = To-Int $row.selfCoolTime
    globalCoolTime = To-Int $row.globalCoolTime
    damageType = 0
    strengthFactor = 0
    wisdomFactor = 0
    dexterityFactor = 0
    selfPhysicalDamageFactor = 0
    selfMagicDamageFactor = 0
    description = $row.description
    iconPath = if ((To-Int $row.icon) -gt 0) { "skill_icons/skill_icon_$(To-Int $row.icon)" } else { '' }
  }
}

$sheet = [Drawing.Bitmap]::FromFile($iconInput)
try {
  $icons = @($allRows | ForEach-Object { [int]$_.icon } | Where-Object { $_ -gt 0 } | Sort-Object -Unique)
  foreach ($icon in $icons) {
    $path = Join-Path $iconOutput "skill_icon_$icon.png"
    [void](Save-SkillIcon $sheet $icon $path)
  }
} finally {
  $sheet.Dispose()
}

$magicFrameCounts = [ordered]@{}
foreach ($key in ($magicCounts.Keys | Sort-Object)) {
  $magicFrameCounts[[string]$key] = $magicCounts[$key]
}

$catalog = [pscustomobject]@{
  generatedFrom = 'legacy server config/data/*_spells.txt and client image/magic/*.gif'
  magicFrameCounts = $magicFrameCounts
  skills = @($allRows | Sort-Object id)
}
$json = $catalog | ConvertTo-Json -Depth 8
Write-TextNoBom $CatalogOutput $json
Write-JsonMeta $CatalogOutput

Write-Host "Imported $($magicCounts.Count) magic animations, $($allRows.Count) skills, and wrote $CatalogOutput"
