# 老游戏装备图标切图记录

这份记录用于下次继续接装备、道具、材料图标时复用。

## 来源

- 优先使用旧客户端 `client/image/ui/icon.img`。
- `icon.gif` 只作为兜底：当 `.img` 对应格子几乎没有有效非黑像素时，再从 `.gif` 同位置补图。
- 当前复刻脚本是 `tools/rebuild-equipment-icons.ps1`。

## 格子规则

- 老游戏装备/道具图标是方形格子。
- 每格固定 `24x24` 像素。
- 黑色背景保留，不要抠透明，也不要按内容裁剪。
- 输出 PNG 也保持 `24x24`，整张图不透明，避免 Cocos 背包格里出现半截图标或透明错位。

## 行列编号

旧游戏先按类别/职业分行，再从左到右用 `1, 2, 3...` 编号。坐标公式：

```text
x = (icon - 1) * 24
y = row * 24
```

装备行规则：

```text
weapon:   requiredRace * 30 + 330
armor:    requiredRace * 90 + 60
helmet:   requiredRace * 90 + 30
boots:    requiredRace * 90 + 90
shield:   300
earbob:   510
necklace: 540
ring:     570
title:    600
aura:     630
fashion:  630
```

职业编号沿用旧服务端：

```text
0 = 游侠
1 = 法师
2 = 战士
```

## 验收标准

- 全部图标是 `24x24`。
- 黑底保留，透明像素为 `0`。
- 图标编号来自旧装备配置的 `icon` 字段。
- 装备编号保留旧服务端基础装备 `id`，写入 `cocos-remake/assets/resources/equipment/equipment_catalog.json`。
- 旧服务端 `+1/+2/+N` 强化装备不进入目录；当前目录只保留 `id % 100 == 0` 且名字不以 `+数字` 结尾的基础装备。
- 后续强化逻辑由复刻版自己做，强化等级应挂在背包装备实例上，不再依赖旧服重复装备 ID。
- 编辑器里的“装备配置”可以用同一个 `id` 覆盖旧装备属性，也可以新增装备。
