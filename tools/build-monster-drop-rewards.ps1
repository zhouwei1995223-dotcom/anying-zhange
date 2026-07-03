param(
  [string]$OldGameRoot = "",
  [string]$CocosRoot = "cocos-remake",
  [string]$OutputPath = "cocos-remake/assets/resources/rewards/monster_drop_rewards.json"
)

$ErrorActionPreference = "Stop"

$gbk = [Text.Encoding]::GetEncoding(936)
$utf8NoBom = New-Object Text.UTF8Encoding($false)

if ([string]::IsNullOrWhiteSpace($OldGameRoot)) {
  $oldRootCandidate = Get-ChildItem -LiteralPath "." -Directory |
    Where-Object { Test-Path -LiteralPath (Join-Path $_.FullName "server/config/data/plunders.txt") } |
    Select-Object -First 1
  if ($null -eq $oldRootCandidate) {
    throw "Cannot locate old game root. Pass -OldGameRoot with a path containing server/config/data/plunders.txt."
  }
  $OldGameRoot = $oldRootCandidate.FullName
}

function Read-GbkLines([string]$Path) {
  [IO.File]::ReadAllLines((Resolve-Path -LiteralPath $Path), $gbk)
}

function To-Int([object]$Value, [int]$Default = 0) {
  if ($null -eq $Value) { return $Default }
  $text = [string]$Value
  if ([string]::IsNullOrWhiteSpace($text)) { return $Default }
  $parsed = 0
  if ([int]::TryParse($text.Trim(), [ref]$parsed)) { return $parsed }
  return $Default
}

function Get-HeaderIndex([string[]]$Lines) {
  for ($i = 0; $i -lt $Lines.Count; $i++) {
    $cols = $Lines[$i] -split "`t"
    if ($cols.Count -gt 1 -and $cols[0] -eq "id") { return $i }
  }
  return -1
}

function Read-OldTable([string]$Path) {
  if (-not (Test-Path -LiteralPath $Path)) { return $null }
  $lines = Read-GbkLines $Path
  $headerIndex = Get-HeaderIndex $lines
  if ($headerIndex -lt 0) { return $null }
  $headers = $lines[$headerIndex] -split "`t"
  $rows = @()
  for ($i = $headerIndex + 1; $i -lt $lines.Count; $i++) {
    $line = $lines[$i]
    if ([string]::IsNullOrWhiteSpace($line) -or $line.TrimStart().StartsWith("#")) { continue }
    $cols = $line -split "`t"
    if ($cols.Count -lt 1) { continue }
    $rows += ,$cols
  }
  [pscustomobject]@{ Headers = $headers; Rows = $rows }
}

function New-JsonMeta([string]$Path) {
  $metaPath = "$Path.meta"
  if (Test-Path -LiteralPath $metaPath) { return }
  $json = [ordered]@{
    ver = "2.0.1"
    importer = "json"
    imported = $true
    uuid = [guid]::NewGuid().ToString()
    files = @(".json")
    subMetas = [ordered]@{}
    userData = [ordered]@{}
  } | ConvertTo-Json -Depth 8
  [IO.File]::WriteAllText($metaPath, $json, $utf8NoBom)
}

function New-DirectoryMeta([string]$Path) {
  $metaPath = "$Path.meta"
  if (Test-Path -LiteralPath $metaPath) { return }
  $json = [ordered]@{
    ver = "1.2.0"
    importer = "directory"
    imported = $true
    uuid = [guid]::NewGuid().ToString()
    files = @()
    subMetas = [ordered]@{}
    userData = [ordered]@{}
  } | ConvertTo-Json -Depth 8
  [IO.File]::WriteAllText($metaPath, $json, $utf8NoBom)
}

function Add-GoodsName([hashtable]$Map, [int]$Id, [string]$Name, [string]$Source) {
  if ($Id -le 0 -or [string]::IsNullOrWhiteSpace($Name)) { return }
  $key = [string]$Id
  if (-not $Map.ContainsKey($key)) {
    $Map[$key] = [ordered]@{ name = $Name; source = $Source }
  }
}

function Add-RewardStat([hashtable]$Map, [int]$Key, [int]$RewardId, [string]$MapId, [int]$MonsterDataId) {
  if ($Key -lt 0 -or $RewardId -le 0) { return }
  $keyText = [string]$Key
  $rewardText = [string]$RewardId
  if (-not $Map.ContainsKey($keyText)) {
    $Map[$keyText] = [ordered]@{
      total = 0
      rewards = @{}
    }
  }
  $stat = $Map[$keyText]
  $stat.total++
  if (-not $stat.rewards.ContainsKey($rewardText)) {
    $stat.rewards[$rewardText] = [ordered]@{
      count = 0
      mapIds = @{}
      monsterDataIds = @{}
    }
  }
  $reward = $stat.rewards[$rewardText]
  $reward.count++
  if ($MapId) { $reward.mapIds[[string]$MapId] = $true }
  if ($MonsterDataId -gt 0) { $reward.monsterDataIds[[string]$MonsterDataId] = $true }
}

function Convert-RewardStats([hashtable]$Map, [string]$KeyName) {
  $result = @()
  foreach ($key in ($Map.Keys | Sort-Object {[int]$_})) {
    $stat = $Map[$key]
    $rewardRows = @()
    foreach ($rewardId in ($stat.rewards.Keys | Sort-Object { -$stat.rewards[$_].count }, {[int]$_})) {
      $reward = $stat.rewards[$rewardId]
      $rewardRows += [ordered]@{
        rewardId = [int]$rewardId
        count = [int]$reward.count
        mapIds = @($reward.mapIds.Keys | Sort-Object {[int]$_})
        monsterDataIds = @($reward.monsterDataIds.Keys | Sort-Object {[int]$_})
      }
    }
    $entry = [ordered]@{}
    $entry[$KeyName] = [int]$key
    $entry["rewardId"] = if ($rewardRows.Count -gt 0) { [int]$rewardRows[0].rewardId } else { 0 }
    $entry["totalSpawns"] = [int]$stat.total
    $entry["rewards"] = $rewardRows
    $result += $entry
  }
  $result
}

$oldDataRoot = Join-Path $OldGameRoot "server/config/data"
$oldMonsterDir = Join-Path $OldGameRoot "server/config/monster"
$cocosEquipmentCatalog = Join-Path $CocosRoot "assets/resources/equipment/equipment_catalog.json"

$goodsNames = @{}

if (Test-Path -LiteralPath $cocosEquipmentCatalog) {
  $catalog = Get-Content -LiteralPath $cocosEquipmentCatalog -Raw -Encoding UTF8 | ConvertFrom-Json
  foreach ($item in @($catalog.items)) {
    Add-GoodsName $goodsNames (To-Int $item.id) ([string]$item.name) "cocos equipment_catalog"
  }
}

Get-ChildItem -LiteralPath $oldDataRoot -Recurse -File -Filter "*.txt" |
  Where-Object { $_.Name -notmatch "\.bak|vssver" } |
  ForEach-Object {
    $table = Read-OldTable $_.FullName
    if ($null -eq $table) { return }
    $idIndex = [Array]::IndexOf($table.Headers, "id")
    $nameIndex = [Array]::IndexOf($table.Headers, "name")
    if ($idIndex -lt 0 -or $nameIndex -lt 0) { return }
    foreach ($row in $table.Rows) {
      if ($row.Count -le [Math]::Max($idIndex, $nameIndex)) { continue }
      Add-GoodsName $goodsNames (To-Int $row[$idIndex]) ([string]$row[$nameIndex]) $_.FullName.Replace((Get-Location).Path + "\", "")
    }
  }

$monsterDataById = @{}
$monsterTable = Read-OldTable (Join-Path $oldDataRoot "monsters.txt")
if ($monsterTable) {
  $idIndex = [Array]::IndexOf($monsterTable.Headers, "id")
  $nameIndex = [Array]::IndexOf($monsterTable.Headers, "name")
  $imageIndex = [Array]::IndexOf($monsterTable.Headers, "image")
  $levelIndex = [Array]::IndexOf($monsterTable.Headers, "level")
  foreach ($row in $monsterTable.Rows) {
    $id = To-Int $row[$idIndex]
    if ($id -le 0) { continue }
    $monsterDataById[[string]$id] = [ordered]@{
      id = $id
      name = if ($nameIndex -ge 0 -and $row.Count -gt $nameIndex) { [string]$row[$nameIndex] } else { "" }
      imageId = if ($imageIndex -ge 0 -and $row.Count -gt $imageIndex) { To-Int $row[$imageIndex] } else { -1 }
      level = if ($levelIndex -ge 0 -and $row.Count -gt $levelIndex) { To-Int $row[$levelIndex] } else { 0 }
    }
  }
}

$plunderPath = Join-Path $oldDataRoot "plunders.txt"
$plunderLines = Read-GbkLines $plunderPath
$plunderHeaderIndex = Get-HeaderIndex $plunderLines
if ($plunderHeaderIndex -lt 0) { throw "Cannot find id header in $plunderPath" }

$rewards = @()
for ($i = $plunderHeaderIndex + 1; $i -lt $plunderLines.Count; $i++) {
  $line = $plunderLines[$i]
  if ([string]::IsNullOrWhiteSpace($line) -or $line.TrimStart().StartsWith("#")) { continue }
  $cols = $line -split "`t"
  if ($cols.Count -lt 33) { continue }
  $idx = 13
  $equipmentDrops = @()
  $weaponDrops = @()
  for ($quality = 0; $quality -lt 5; $quality++) {
    $equipmentDrops += [ordered]@{
      quality = $quality
      qualityLabel = "quality_$($quality + 1)"
      count = To-Int $cols[$idx]
      rate = To-Int $cols[$idx + 1]
    }
    $weaponDrops += [ordered]@{
      quality = $quality
      qualityLabel = "quality_$($quality + 1)"
      count = To-Int $cols[$idx + 2]
      rate = To-Int $cols[$idx + 3]
    }
    $idx += 4
  }

  $extras = @()
  $entry = 1
  while ($idx + 1 -lt $cols.Count) {
    $goodsId = To-Int $cols[$idx]
    $rate = To-Int $cols[$idx + 1]
    if ($goodsId -gt 0 -and $rate -gt 0) {
      $goodsInfo = $goodsNames[[string]$goodsId]
      $extras += [ordered]@{
        entry = $entry
        goodsId = $goodsId
        rate = $rate
        name = if ($goodsInfo) { [string]$goodsInfo.name } else { "" }
        source = if ($goodsInfo) { [string]$goodsInfo.source } else { "" }
      }
    }
    $idx += 2
    $entry++
  }

  $rewards += [ordered]@{
    id = To-Int $cols[0]
    name = [string]$cols[1]
    level = To-Int $cols[2]
    exp = [ordered]@{ min = To-Int $cols[3]; max = To-Int $cols[4] }
    money = [ordered]@{ min = To-Int $cols[5]; max = To-Int $cols[6] }
    dropTopHeroDepot = To-Int $cols[7]
    goodsProtectionTime = To-Int $cols[8]
    medicine = [ordered]@{ count = To-Int $cols[9]; rate = To-Int $cols[10] }
    bigDrop = [ordered]@{ rate = To-Int $cols[11]; times = To-Int $cols[12] }
    equipmentDrops = $equipmentDrops
    weaponDrops = $weaponDrops
    extraGoods = $extras
  }
}

$monsterDataStats = @{}
$monsterImageStats = @{}
$mapStats = @{}

Get-ChildItem -LiteralPath $oldMonsterDir -File -Filter "*.txt" | ForEach-Object {
  $mapId = [IO.Path]::GetFileNameWithoutExtension($_.Name)
  $lines = Read-GbkLines $_.FullName
  $headerIndex = -1
  for ($i = 0; $i -lt $lines.Count; $i++) {
    $cols = $lines[$i] -split "`t"
    if ([Array]::IndexOf($cols, "monsterID") -ge 0 -and [Array]::IndexOf($cols, "plunderID") -ge 0) {
      $headerIndex = $i
      break
    }
  }
  if ($headerIndex -lt 0) { return }
  $headers = $lines[$headerIndex] -split "`t"
  $rows = @()
  for ($i = $headerIndex + 1; $i -lt $lines.Count; $i++) {
    $line = $lines[$i]
    if ([string]::IsNullOrWhiteSpace($line) -or $line.TrimStart().StartsWith("#")) { continue }
    $rows += ,($line -split "`t")
  }
  $table = [pscustomobject]@{ Headers = $headers; Rows = $rows }
  $monsterIndex = [Array]::IndexOf($table.Headers, "monsterID")
  $rewardIndex = [Array]::IndexOf($table.Headers, "plunderID")
  if ($monsterIndex -lt 0 -or $rewardIndex -lt 0) { return }
  foreach ($row in $table.Rows) {
    if ($row.Count -le [Math]::Max($monsterIndex, $rewardIndex)) { continue }
    $monsterDataId = To-Int $row[$monsterIndex]
    $rewardId = To-Int $row[$rewardIndex]
    if ($monsterDataId -le 0 -or $rewardId -le 0) { continue }
    Add-RewardStat $monsterDataStats $monsterDataId $rewardId $mapId $monsterDataId
    $monsterInfo = $monsterDataById[[string]$monsterDataId]
    if ($monsterInfo -and $monsterInfo.imageId -ge 0) {
      Add-RewardStat $monsterImageStats ([int]$monsterInfo.imageId) $rewardId $mapId $monsterDataId
    }
    Add-RewardStat $mapStats (To-Int $mapId -1) $rewardId $mapId $monsterDataId
  }
}

$payload = [ordered]@{
  generatedFrom = [ordered]@{
    plunders = $plunderPath
    monsters = (Join-Path $oldDataRoot "monsters.txt")
    monsterSpawns = $oldMonsterDir
  }
  rateBase = 10000
  semantics = [ordered]@{
    rewardIdField = "old monster spawn files use plunderID"
    chanceBase = "old server rolls Math.random() * 10000 against each rate"
    bigDrop = "bigDropRate can multiply all drop counts by bigDropTimes"
    equipmentDrops = "equipment counts/rates are indexed by old quality 0-4; old labels call these quality 1-5"
    weaponDrops = "weapon counts/rates are indexed by old quality 0-4"
    extraGoods = "each non-zero goodsId/rate pair is an independent roll"
  }
  rewards = $rewards
  defaultsByMonsterDataId = Convert-RewardStats $monsterDataStats "monsterDataId"
  defaultsByMonsterImageId = Convert-RewardStats $monsterImageStats "monsterImageId"
  defaultsByMapId = Convert-RewardStats $mapStats "mapId"
}

$outFull = Resolve-Path -LiteralPath "." | ForEach-Object { Join-Path $_ $OutputPath }
$outDir = Split-Path -Parent $outFull
New-Item -ItemType Directory -Force -Path $outDir | Out-Null
New-DirectoryMeta $outDir
$json = $payload | ConvertTo-Json -Depth 30
[IO.File]::WriteAllText($outFull, $json, $utf8NoBom)
New-JsonMeta $outFull

Write-Output "Rewards: $($rewards.Count)"
Write-Output "Monster data defaults: $($monsterDataStats.Count)"
Write-Output "Monster image defaults: $($monsterImageStats.Count)"
Write-Output "Output: $outFull"
