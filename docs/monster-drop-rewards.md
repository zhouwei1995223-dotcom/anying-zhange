# 老游戏怪物掉落复刻记录

## 老游戏链路

旧服务端怪物出生文件在 `server/config/monster/*.txt`，字段是：

```text
x y monsterID plunderID behaviorID groupID isLeader
```

其中 `plunderID` 就是怪物死亡奖励编号，指向：

```text
server/config/data/plunders.txt
```

旧代码里 `PlunderData` 保存经验、金币、药品、装备、武器和额外物品。怪物死亡时的执行点在旧服务端 `app/island/gs/l.java`：

- 先按 `PlunderData` 掉物。
- 再按 `minExp/maxExp` 发经验。
- 再按 `minMoney/maxMoney` 发金币。
- 概率单位是 `10000`，即 `rate=10000` 约等于 100%。
- `bigDropRate` 触发后，掉落次数乘以 `bigDropTimes`。
- 装备和武器不是固定一个物品编号，而是按奖励等级 `level ~ level + 12`、品质、部位/职业从旧装备表随机挑。

## Cocos 资源

生成脚本：

```text
tools/build-monster-drop-rewards.ps1
```

生成结果：

```text
cocos-remake/assets/resources/rewards/monster_drop_rewards.json
```

当前生成结果：

```text
rewards: 409
defaultsByMonsterDataId: 292
defaultsByMonsterImageId: 56
defaultsByMapId: 198
```

## Cocos 使用方式

`HeroIdlePlayer.ts` 的 `MapMonsterConfig` 增加了 `奖励编号`：

- 手动填 `70000023` 这类旧 `plunderID` 时，优先使用手填奖励。
- 不填时，先按旧怪物 `image` 默认映射。
- 还没有匹配时，再按当前地图默认奖励兜底。

当前运行时已接入：

- 经验奖励。
- 金币奖励。
- 装备掉落使用当前复刻规则：怪物死亡只滚一次装备品质表，总概率控制在 `999 / 10000`。
- 掉落装备按怪物等级选最近装备档位，平手取低档，例如 6 级取 0 级，7 级取 12 级。
- 武器、防具、首饰统一进同一个随机装备池，职业随机，部位随机。
- 装备池只使用基础装备：旧服 `+1/+2/+N` 强化装备已从 Cocos 装备目录中移除，后续强化逻辑由复刻版自己做。

暂未完整接入：

- 药品、材料等通用道具背包格。它们的 `goodsId` 和概率已经保留在 JSON 里，等通用道具目录/UI 接上后可以直接启用。
- 旧 `extraGoods` 里包含大量固定装备编号；为了避免装备掉率突破 10%，当前不会把这些固定装备额外塞进背包。

## 当前装备品质概率

概率单位仍然沿用旧服 `10000 = 100%`。

```text
普通 quality 0: 667
精品 quality 1: 222
极品 quality 2: 74
灵品 quality 3: 25
仙品 quality 4: 8
神品 quality 5: 3
时装 quality 6: 0
```

合计 `999 / 10000`，即单只普通怪总装备掉率约 `9.99%`。

## 当前装备等级规则

```text
武器/衣服/头盔/鞋子/盾牌: 0, 12, 24, 36, 48, 60, 72, 84, 96, 108, 120
首饰: 18, 30, 42, 54, 66, 78, 90, 102, 114
```

如果某个品质在目标等级没有完全对应的旧装备，则在同品质、同部位、同职业池里取最接近目标等级的装备。
