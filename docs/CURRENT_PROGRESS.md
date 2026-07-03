# Current Progress

更新时间: 2026-07-01

这个文档只记录当前可验收状态。旧流水仍在根目录 `PROGRESS.md`，后续以这里为准。

## 当前主线

- 主项目: `cocos-remake`
- 主运行脚本: `cocos-remake/assets/scripts/HeroIdlePlayer.ts`
- 老游戏参考: `无双暗影世界`
- 反编译参考: `tools/decompiled-focus-client`, `tools/decompiled-focus-server`, `tools/decompiled-old-client`, `tools/decompiled-old-server`
- 重要规则: 可以参考老游戏，但所有最终玩法数据要尽量暴露给编辑器或 JSON 配置，不要只写死在代码里。

## 已完成

- 地图系统
  - 已导入旧游戏地图预览、遮挡层、`.blk` 碰撞网格和地图目录。
  - 石头、桥等低矮素材走底层，不再盖住人物。
  - 房屋、树等高层素材走遮挡层，配合 Y 排序遮挡人物。
  - 保留 `tmp_map_tiles`，地图编辑器和地图重建脚本仍然会用。

- 角色动作系统
  - 已确认老游戏职业资源: `00/01` 游侠，`10/11` 法师，`20/21` 战士。
  - 已接入待机、行走、攻击、死亡动作资源。
  - 五方向旧资源会镜像补齐左侧方向，八方向新资源按完整方向导入。
  - 当前游侠攻击距离是 `180`。
  - 动画速度会跟攻击速度、移动速度挂钩，方便后续装备词条影响表现。
  - `hero_00/appearance_8` 的待机/行走帧已用 `tools/stabilize-humanoid-idle-walk.ps1` 做主体中心和脚底稳定；攻击帧保持原样。

- 背包和装备
  - 背包弹窗使用旧 UI 边框，当前是 `10 x 10` 背包格。
  - 底部按钮顺序为: 上一页、整理、出售、下一页。
  - 装备栏在人物两侧排列，中间显示实时角色待机预览。
  - 点击背包装备不再直接穿戴，会打开装备属性弹窗。
  - 背包装备按钮: 出售、锁定/解锁、穿戴。
  - 身上装备按钮: 锁定/解锁、脱下；身上装备不能出售。
  - 锁定装备不会被出售。
  - 装备名称按品质显示颜色: 普通白、精品绿、极品蓝、灵品紫、仙品粉、神品橙。
  - 装备属性有上下 10% 浮动，并显示品质百分比。

- 掉落系统
  - 已参考老游戏 `plunderID` 做奖励编号。
  - 普通怪物总装备掉率控制在 `999 / 10000`，约 `9.99%`。
  - 掉落装备等级按怪物等级取最近档位。
  - 当前只取基础装备，旧游戏 `+1/+2/+N` 强化装备不进入掉落池，后续强化系统自己做。

- 技能系统
  - 已导入旧游戏 `magic` 技能/弹道素材。
  - 已生成 `cocos-remake/assets/resources/skills/skill_catalog.json`。
  - 新增技能按钮和技能弹窗。
  - 技能显示已学习技能和技能等级。
  - 技能按释放次数获得经验并升级。
  - 游侠攻击已接入弹道动画和命中特效资源。

- 伙伴系统
  - 已新增伙伴按钮和伙伴弹窗。
  - 上方 6 个出战格，下方伙伴背包格约为普通背包一半。
  - 伙伴目前复用怪物序列帧作为预览和战斗形象。
  - 点击伙伴可查看属性，支持出战/收回。
  - 出战伙伴会跟随玩家，不离玩家太远。
  - 伙伴攻击距离为 `160`，优先攻击玩家正在攻击的怪物。

## 当前自检

已通过:

```text
cd cocos-remake
npm.cmd run typecheck
```

已通过:

```text
cocos-remake/assets 下 JSON / meta / anim / scene 解析检查: badCount=0
技能 catalog 对应图标、弹道、特效资源检查: missing=0
核心资源抽样检查: missing=0
```

## 本轮清理

已删除根目录里不再需要的一次性角色解包/预览产物:

```text
tmp_hero_00_0_scan
tmp_hero_action_decode
tmp_hero_img2png
tmp_hero_img2png_correct
damage_text_import_preview.png
foldered_hero_00_appearance_8_preview.png
HERO_CATALOG.png
humanoid_source_preview.png
tools/client_bag96_tmp.jar
tools/server_bag96_tmp.jar
tools/jdk-temurin8.zip
```

保留以下内容，因为后续仍有用:

```text
tmp_map_tiles
tmp_ui_extract
tools/cfr.jar
tools/jdk
tools/decompiled-*
tools/import-*.ps1
tools/build-*.ps1
tools/rebuild-equipment-icons.ps1
```

## 明天优先验收

1. Cocos 里打开 `Main.scene`，先看是否还有 `[Assets] Cannot read properties of undefined (reading 'value')`。
2. 测试自动战斗: 待机、寻怪、八方向移动、攻击弹道、命中特效。
3. 测试技能面板: 技能按钮、技能升级、弹道是否和攻击同步。
4. 测试伙伴面板: 伙伴出战、收回、跟随、协助攻击。
5. 测试背包装备: 点击装备弹窗、锁定/解锁、穿戴/脱下、出售跳过锁定装备。

## 后续整理方向

- `HeroIdlePlayer.ts` 已经承载了太多系统，下一步适合拆成:
  - 地图/遮挡/碰撞
  - 角色动作
  - 战斗与目标选择
  - 背包装备
  - 技能
  - 伙伴
- 把背包、技能、伙伴、掉落、怪物生成逐步迁移到 JSON 配置或 Cocos Inspector 字段，减少硬编码。
- 给技能、伙伴、装备状态加本地存档，避免每次预览都重置。
