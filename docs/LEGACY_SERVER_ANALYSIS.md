# 老游戏服务端分析笔记

> 目标：理解 `无双暗影世界/server` 的服务端结构和底层逻辑，为 Cocos 复刻提供参考。  
> 当前分析对象：`server_bag96.zip`，反编译输出在 `tools/decompiled-focus-server`。

## 结论摘要

- 服务端是 Java 写的，入口类是 `app.island.gs.GameServer`。
- 当前启动脚本会优先选择 `server_bag96.zip`，这是 96 格背包版本。
- 服务端是典型表驱动结构：`config/data/*.txt` 的第二行是字段名，反射写入 Java 对象。
- 主要运行链路是：`GameServer` 启动和登录 -> `x` 世界/场景管理 -> `u` 单场景实例 -> `h` 玩家会话 -> `n` 怪物实例 -> `l` 掉落奖励 -> `m` 物品/背包装备操作。
- 怪物配置是三件套：怪物模板 `monsterID`、奖励编号 `plunderID`、AI 编号 `behaviorID`。
- 老服装备、强化、合成、套装逻辑非常重。复刻时可以参考数据结构和属性计算，但装备生成、品质、随机浮动建议继续按我们新逻辑做。

## 启动方式

启动脚本：`无双暗影世界/server/start_server.bat`

关键逻辑：

```bat
set "SERVER_ZIP=server.zip"
if exist "server_store64.zip" set "SERVER_ZIP=server_store64.zip"
if exist "server_bag64.zip" set "SERVER_ZIP=server_bag64.zip"
if exist "server_bag96.zip" set "SERVER_ZIP=server_bag96.zip"
"%JAVA_EXE%" -Xint -Xmx512M -XX:+ForceTimeHighResolution -cp "%SERVER_ZIP%;lib/mysql-connector-java-5.0.4-bin.jar;." app.island.gs.GameServer
```

说明：

- Java 入口：`app.island.gs.GameServer`
- 网络端口来自 `config/server.cfg`，当前是 `12346`
- 默认 accessor 是 `localFileAccessor`，也就是本地文件存档，不走 MySQL
- MySQL accessor 也保留了：`jdbc:mysql://localhost/anying`，root/123456

## 核心配置

配置文件：`无双暗影世界/server/config/server.cfg`

重点字段：

- `netServerClass=daff.net.NIONetServer`
- `port=12346`
- `accessor=localFileAccessor`
- `pkProtectionLevel=10`
- `heroDeathPunishProtectionLevel=50`
- `expTimes=100`
- `moneyTimes=1`
- `medicineDropTimes=1`
- `weaponDropTimes=1`
- `equipmentDropTimes=1`
- `extraGoodsDropTimes=1`
- `treasureDropTimes=8`
- `worldChatMoneyCost=1000`

这些倍率最终会影响战斗、掉落、经济和 PK。

## 代码模块地图

反编译目录：`tools/decompiled-focus-server`

主要类：

- `app.island.gs.GameServer`：启动、配置、网络连接、登录、注册、创建角色、进入游戏。
- `app.island.gs.x`：全局世界管理器，加载场景，路由消息到不同模块。
- `app.island.gs.u`：单个场景实例，管理地图、怪物、NPC、地面物品、场景广播、拾取。
- `app.island.gs.h`：玩家会话/玩家控制器，持有当前 `Hero`。
- `app.island.gs.n`：怪物控制器，绑定怪物模板、AI、掉落。
- `app.island.gs.a.a`：怪物 AI 实现。
- `app.island.gs.l`：掉落和奖励管理。
- `app.island.gs.m`：背包、装备、道具使用、合成、强化等物品操作。
- `app.island.gs.r`：战斗和技能结算。
- `app.island.gs.w`：全局数据加载器，加载所有配置表。
- `app.island.GameObject`：表驱动和对象序列化基础类。

核心实体：

- `app.island.entity.Hero`
- `app.island.entity.Player`
- `app.island.entity.Sprite`
- `app.island.entity.Monster`
- `app.island.entity.GroundGoods`
- `app.island.entity.Npc`
- `app.island.entity.SceneObject`
- `app.island.entity.User`

物品数据：

- `app.island.data.Goods`
- `app.island.data.Depot`
- `app.island.data.Weapon`
- `app.island.data.Equipment`
- `app.island.data.Decoration`
- `app.island.data.Fashion`
- `app.island.data.Medicine`
- `app.island.data.Book`
- `app.island.data.Material`
- `app.island.data.SpecialProperty`

## 表驱动机制

基础类：`app.island.GameObject`

`GameObject.loadObjects` 的逻辑：

1. 读取文本表。
2. 第一行通常是说明。
3. 第二行按 tab 拆成字段名。
4. 从第三行开始，每行创建一个对象。
5. 用字段名反射调用 `setAttributeValue`。

这意味着老服配置表和 Java public 字段高度绑定。复刻时可以保留类似结构：

- Cocos 编辑器中可调字段 -> JSON/TS 配置
- TS 配置字段名尽量和老服字段保持可追踪关系
- 特殊数组字段如掉落表、技能表，需要手动解析

## 全局数据加载

入口：`app.island.gs.w.new()`

加载内容包括：

- 技能：`damage_spells.txt`、`effect_spells.txt`、`state_spells.txt`
- 状态：`states.txt`
- 怪物：`monsters.txt`
- 怪物 AI：`monster_ai.txt`
- 掉落奖励：`plunders.txt`
- 装备：`config/data/equipments/*`
- 武器：`config/data/weapons/*`
- 首饰：`config/data/jewels/*`
- 时装：`fashions.txt`
- 材料、书、特殊物品、公式、强化、炼化、箱子奖励、活动等

最后会执行：

- `Goods.setGoodsFetcher(this)`

所以持久化里只要保存物品 id，就可以通过全局表恢复对应物品模板。

## 网络和消息路由

`GameServer` 负责连接级消息：

- `1`：版本检查
- `2`：登录
- `3`：注册
- `4`：创建角色
- `5`：删除角色
- `6`：进入游戏

进入游戏后，消息交给 `x.a(h, opcode, e)` 路由：

- `256-511`：当前场景 `u`
- `512-611`：玩家自身 `h`
- 其他区间分给物品、商店、组队、公会等管理器
- `3074/3075`：老服挂机/自动相关的开始和停止入口

复刻建议：

- Cocos 单机/本地逻辑可以不用照搬网络协议。
- 但 opcode 分区思想有用：场景、角色、背包、战斗、社交等模块边界清楚。

## 存档结构

当前 server 使用本地文件 accessor：`app.island.gs.accessor.LocalFileAccessor`

主要存档路径：

- `data/user/{账号}.txt`
- `data/store/{账号}.txt`
- `data/hero/{角色名}.txt`
- `data/depot/{角色名}.txt`
- `data/shortcut/{角色名}.txt`
- `data/spell/{角色名}.txt`
- `data/task/{角色名}.txt`
- `data/friend/{角色名}.txt`
- `data/guild/{id}.txt`

英雄读取后会：

- 加载背包 `Depot`
- 加载技能、任务、好友、公会
- 重新计算属性 `Hero.calculateProperties()`
- 用全局物品表恢复装备/背包物品

复刻建议：

- 当前 Cocos 先用本地 JSON 存档即可。
- 结构可按 `hero + depot + spells + tasks + settings` 拆文件，方便调试。

## 场景和地图

场景配置类：`app.island.gs.data.SceneConfigData`

关键字段：

- `sceneType`
- `mapid`
- `enterX/enterY`
- `safeRegionCenterX/Y/Width/Height`
- `viewRange`
- `heroCountLimit`
- `minTurn/maxTurn`
- `minHeroLevel/maxHeroLevel`
- `plunderExpRate`
- `plunderMoneyRate`
- `plunderGoodsRate`
- `goodsLifeTime`
- `goodsProtectionTime`
- `medicineUsable`
- `specialUsable`
- `earningLevelWeakening`

`u.a(SceneConfigData)` 会加载：

- 地图阻挡：`data/map/{mapid}.blk`
- 怪物配置：`config/monster/{sceneId}.txt`
- NPC 配置：`config/npc/{sceneId}.txt`
- 传送门：`config/door/{sceneId}.txt`

复刻建议：

- 地图阻挡、遮挡层、低层装饰层、高层遮挡层继续拆开。
- 当前我们已经在 Cocos 里处理“石头/桥不压人物、树冠压人物、阴影不压人物”的规则，后续所有地图应统一走同一套导入/分类流程。

## 怪物系统

怪物模板：`config/data/monsters.txt`

常见字段：

- `id/name/image/color`
- `level/grade`
- `attackRange`
- `maxLife`
- 物理/魔法最小最大攻击
- 物理/魔法防御
- 命中/躲避
- 移动/攻击时间
- 描述

场景怪物配置由 `u` 读入，每行大意是：

```txt
x    y    monsterID    plunderID    behaviorID
```

`n` 怪物控制器会：

1. 从 `monsterID` 克隆怪物模板。
2. 绑定 `MonsterAIData`。
3. 绑定 `PlunderData`。
4. 分配运行时怪物 id。
5. 保存原始模板 id 到 `monster.monsterID`。

复刻建议：

- Cocos 里的怪物配置也保持三段式：
  - 怪物编号
  - 奖励编号
  - AI 编号
- 这样普通怪、新地图、新奖励都能复用，不互相污染。

## 怪物 AI

AI 数据类：`app.island.gs.data.MonsterAIData`

关键字段：

- 复活：`initialAliveness`、`minReliveDelay`、`maxReliveDelay`、`reliveRange`、`maxReliveTimes`
- 巡逻：`randomMoveRange`、`randomMoveDelay`、`moveDestX/Y`、`destRange`
- 搜敌：`searchRange`、`searchDelay`
- 目标偏好：`preferredPKValue`、`preferredDistance`、`preferredLevel`、`preferredLife`、`preferredRace`
- 战斗边界：`fightRange`
- 飞行/瞬移：`flyToTarget`、`flyToOrigin`
- 受击反应：`hurtResponseDelay`、`changeTargetOnHurt`
- 技能：`rateOfUsingSpellToAttack`、`attackSpells`、`useAttackSpellRates`
- 逃跑：`escapeMinLife`、`escapeMaxHurt`、`escapeRange`
- 仇恨：`enmityEnabled`、`raceEnmityFactors`、各种伤害仇恨系数

AI 实现：`app.island.gs.a.a`

重要行为：

- 随机闲逛时，在 8 方向中随机选一格。
- 行走前检查场景 passability：`u.a(x, y)`。
- 超出 `randomMoveRange` 或固定目的地范围会拒绝移动。
- 搜敌后追踪目标；目标离开 `fightRange` 后回到原点/目的地。
- 可按生命比例和概率释放技能。
- 可按仇恨系统切换目标。

复刻建议：

- 我们当前怪物绕路逻辑应继续基于地图阻挡和装饰阻挡。
- “不要左右左右摇摆”的核心规则是：如果目标点附近是阻挡物边缘，不要反复选择贴边方向；需要把碰撞边缘当成危险区，随机闲逛时避开。

## 战斗系统

公共战斗实体：`app.island.entity.Sprite`

动作枚举：

- `0`：待机
- `1`：行走
- `2`：攻击
- `3`：打坐
- `4`：死亡

基础属性：

- `life/maxLife`
- `mana/maxMana`
- `level`
- `stepTime`
- `attackTime`
- `attackDelay`
- `attackRange`
- 物理/魔法攻击、防御
- 命中、躲避
- `strength/dexterity/wisdom`

基础公式：

- 最小物攻：`strength + dexterity * 3 / 2 + (dexterity^2 / 1600 + level / 12) * 3`
- 最大物攻：`strength * 3 + dexterity + (strength^2 / 400 + level / 12) * 3`
- 最小魔攻：`wisdom * 3 / 2 + (dexterity^2 / 2500 + level / 12) * 3`
- 最大魔攻：`wisdom * 2 + (wisdom^2 / 400 + level / 12) * 3`
- 移动时间最低 300
- 攻击时间最低 500

战斗结算：`app.island.gs.r`

核心逻辑：

- 英雄打怪：按技能随机伤害 -> 走物理/魔法防御 -> 最小伤害 1 -> 怪物死亡触发掉落。
- 怪物打英雄：类似，但会调用英雄装备防御。
- 玩家打玩家：额外处理 PK 状态。

复刻建议：

- 初期可以沿用基础公式和最小伤害规则。
- 技能、状态、仇恨可以逐步接，不要一次性把老服复杂度全搬过来。

## 职业和角色成长

老服 `Hero` 里职业数组顺序：

- `0`：弓箭手
- `1`：法师
- `2`：战士

性别：

- `0`：男
- `1`：女

成长基础：

- 初始强壮：`{2, 2, 6}`
- 初始敏捷：`{6, 2, 2}`
- 初始智力：`{2, 6, 2}`
- 初始生命：`{450, 400, 500}`
- 初始魔法：`{150, 200, 120}`

每级成长：

- 强壮：`{2, 1, 3}`
- 敏捷：`{3, 2, 2}`
- 智力：`{1, 3, 1}`

注意：

- 客户端加载代码里 `a3[0][0]=00`、`a3[0][1]=01`、`a3[1][0]=10`、`a3[1][1]=11`、`a3[2][0]=20`、`a3[2][1]=21`。
- 结合服务端 `RACE_NAMES = {"弓箭手", "法师", "战士"}` 和 `SEX_NAMES = {"男", "女"}`，资源目录应映射为：`00/01` 游侠，`10/11` 法师，`20/21` 战士。

## 背包和装备

背包类：`app.island.data.Depot`

当前包是 96 格版本：

```java
public Goods[] goodsList = new Goods[64];
...
public Depot() {
    this.goodsList = new Goods[96];
}
```

装备槽：

- `fashion`
- `weapon`
- `armor`
- `helmet`
- `boots`
- `shield`
- `leftEarbob`
- `rightEarbob`
- `necklace`
- `leftRing`
- `rightRing`
- `title`
- `aura`

背包操作类：`app.island.gs.m`

点击使用背包物品时按 `goodsType` 分流：

- `0`：药品
- `1`：武器
- `2`：装备
- `3`：饰品
- `4`：技能书
- `5`：特殊物品
- `6`：时装

装备流程：

1. 检查格子合法。
2. 按职业、等级、转生检查能否穿戴。
3. 穿上新装备。
4. 旧装备返回背包原格或空位。
5. `Hero.calculateProperties()` 重算属性。
6. 给客户端发背包/装备更新包。

检查逻辑：

- `checkWeapon`：职业、等级、转生。
- `checkEquipment`：职业、等级、转生。
- `checkDecoration`：等级、转生，不限制职业。

复刻建议：

- 当前我们已经把装备改成“点击先弹属性面板，再穿戴/出售/锁定”。
- 这一点和老服不同，但更适合现在的 UI。
- 仍然应该保留：
  - 背包物品
  - 装备槽
  - 穿戴检查
  - 穿戴后重算属性
  - 锁定装备不可出售
  - 身上装备不可出售

## 物品类型和字段

基础物品：`app.island.data.Goods`

字段：

- `id`
- `name`
- `quality`
- `goodsType`
- `icon`
- `moneyCost`
- `treasureCost`
- `dropable`
- `soldable`
- `tradable`
- `storable`
- `description`
- `createdTime`
- `lifeTime`

物品类型：

- `0` Medicine
- `1` Weapon
- `2` Equipment
- `3` Decoration
- `4` Book
- `5` Special
- `6` Fashion
- `7` ChatGift
- `8` Material

武器字段：

- 物理/魔法最小最大攻击
- 额外物理/魔法攻击
- 等级/强壮/敏捷/智力系数
- 命中
- 攻击范围
- 攻击时间
- 攻击延迟
- 双倍伤害率
- 附加状态
- 职业/等级/转生需求
- 光环、套装、功能描述

防具字段：

- 部位 `eType`
- 外观 `appearance`
- 物理/魔法防御
- 额外防御
- 生命/魔法提升
- 躲避
- 移动时间
- 抵挡率
- 职业/等级/转生需求
- 光环、套装

饰品字段：

- 类型 `dType`
- 生命/魔法提升
- 物理/魔法防御
- 双倍伤害率
- 生命/魔法恢复
- 命中、躲避
- 掉落/金钱/经验幸运
- 特殊能力
- 等级/转生需求

## 外观和时装

时装类：`app.island.data.Fashion`

关键逻辑：

- `Fashion.resolveSuit(hero)`：
  - 如果穿了时装，用时装 suit。
  - 否则如果穿了衣服，用衣服 `appearance`。
  - 否则用 0。
- `Fashion.resolveHalo(hero)`：
  - 从装备、称号、光环、时装里取显示光效。

复刻建议：

- 背包装备栏中间的人物展示应该读取同一套外观解析：
  - 职业 + 性别
  - 衣服外观等级
  - 时装优先级
  - 称号/光环
- 客户端资源目录：
  - `00` 男游侠
  - `01` 女游侠
  - `10` 男法师
  - `11` 女法师
  - `20` 男战士
  - `21` 女战士
  - 每个目录下 `0/1/2/3...` 是不同衣服外观阶段。

## 掉落和奖励

奖励数据：`app.island.gs.data.PlunderData`

字段：

- `level`
- `minExp/maxExp`
- `minMoney/maxMoney`
- `goodsProtectionTime`
- `dropTopHeroDepot`
- `medicineDropRate/medicineDropCount`
- `equipmentDropCounts/equipmentDropRates`
- `weaponDropCounts/weaponDropRates`
- `bigDropRate/bigDropTimes`
- `extraGoodsIDs/extraGoodsRates`

掉落执行：`app.island.gs.l`

怪物死亡后：

1. 找到击杀者。
2. 找到怪物绑定的 `PlunderData`。
3. 发经验和金币。
4. 按场景倍率和全局倍率修正。
5. 按掉落表随机药品、装备、武器、额外道具。
6. 如果 `dropTopHeroDepot > 0`，直接放入背包。
7. 否则生成地面物品 `GroundGoods`。

老服装备掉落：

- 按质量数组循环，质量维度是 5 档。
- 装备掉落时，70% 防具，30% 饰品。
- 武器单独走 `weaponDropCounts/weaponDropRates`。
- 掉落区间大致是 `plunder.level` 到 `plunder.level + 12`。
- 地面物品有保护时间和生命周期。

复刻当前新规则：

- 不再照搬老服大量 `+1/+2/+3` 强化装备。
- 装备等级按：
  - 普通装备：0、12、24、36...120
  - 饰品：18、30、42...114
- 怪物等级离哪个装备等级近，就掉哪个等级段。
- 普通怪总装备掉率控制在 10% 以内。
- 掉落装备职业随机、部位随机，也可能是饰品。
- 时装不从普通掉落出。
- 品质概率按我们后续设定走。
- 装备属性上下浮动 10%，属性品质旁显示 0%-100%。

## 地面物品

场景类：`u`

生成地面物品：

- `u.a(Goods goods, int ownerID, int protectionTime, int x, int y)`
- 会创建 `GroundGoods`
- 赋全局地面物品 id
- 在目标坐标附近找可放置点
- 设置生命周期 `goodsLifeTime * 1000`
- 设置保护时间

拾取：

- 必须离物品 1 格以内。
- 保护时间内只有 owner 可捡。
- 背包需要有空位 `getNextFreePos()`。

复刻建议：

- 当前 Cocos 如果先做单机，可以先实现：
  - 掉落物显示
  - 点击/靠近拾取
  - 背包满提示
  - 锁定归属可暂缓

## 属性计算

`Hero.calculateProperties()` 会统一重算：

- 攻击范围
- 强壮、敏捷、智力
- 物攻、魔攻
- 物防、魔防
- 命中、躲避
- 移动/攻击时间
- 最大生命/魔法
- suit 和 halo
- 经验幸运

装备属性会通过 `Depot` 汇总：

- 武器给攻击、命中、攻击范围、攻速等。
- 防具给防御、生命、魔法、躲避、移动时间。
- 饰品给防御、生命、魔法、命中、躲避、幸运、特殊能力。
- 套装属性通过 `suitID` 和 `suitParamTypes/suitParamValues` 叠加。

复刻建议：

- 继续保留一个统一 `recalculateStats()`。
- 所有加点、穿戴、脱下、强化、时装、称号变化，都只修改状态，然后统一重算。
- 不要在 UI 或战斗代码里临时拼属性，否则后面会很难查错。

## 复刻优先级建议

第一层必须保留：

- 地图阻挡和遮挡分类
- 角色/怪物动作状态
- 怪物模板、AI 编号、奖励编号分离
- 背包和装备槽
- 装备穿戴检查
- 装备属性统一重算
- 怪物死亡奖励
- 掉落物拾取

第二层逐步接：

- 技能表
- 状态效果
- 仇恨系统
- 套装
- 时装/称号/光环
- 任务
- NPC 商店
- 强化和合成

暂时不建议照搬：

- 老服完整强化/炼化/升级公式
- 老服所有 `+1/+2/+3` 装备
- 老服完整网络 opcode
- 老服完整 PK/公会/组队

## 当前需要继续验证的点

- 客户端职业资源目录和服务端 race index 已核对：`00/01` 游侠，`10/11` 法师，`20/21` 战士。
- 所有 hero `.img` 动作文件的帧切割规则。
- 技能表现和服务端技能表的对应关系。
- 老服 UI 按钮、弹窗边框素材已经初步接入 Cocos，但还需要继续形成 UI 组件规范。
- 新装备生成器需要和现有背包 UI、属性弹窗、掉落系统完全打通。

## 对 Cocos 当前项目的落地建议

建议新增或保持这些模块：

- `MapData`：地图编号、预览、阻挡、遮挡、装饰分类。
- `MonsterConfig`：怪物模板。
- `MonsterSpawnConfig`：场景刷怪点，包含怪物编号、AI 编号、奖励编号。
- `MonsterAiConfig`：巡逻、索敌、追击、攻击、绕路规则。
- `RewardConfig`：经验、金币、掉落池、装备掉落概率。
- `EquipmentTemplate`：基础装备模板，不含随机浮动实例属性。
- `EquipmentInstance`：玩家实际拥有的装备，含品质、属性浮动、锁定状态。
- `InventoryModel`：背包格子、分页、整理、出售。
- `EquipmentSlotsModel`：身上装备槽。
- `StatsCalculator`：角色属性唯一计算入口。
- `LegacyAssetMap`：老资源 id 到 Cocos sprite/animation 的映射。

这样既能最大程度还原老游戏，又不会被老服过重的历史系统拖住。
