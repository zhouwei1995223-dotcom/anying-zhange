# Retrospective

## 2026-06-28 Level Exp And Upgrade Effect

- What worked: reuse the old server formula directly. `Hero.EXP_TABLE` gives the threshold and `plunders.txt` gives kill exp, so no custom leveling table is needed.
- What worked: convert the confirmed `.img` effect with the existing Java tool, then slice the fixed horizontal grid into Cocos resource frames.
- Reuse rule: for level-up, keep gameplay logic minimal until stats are implemented: exp label, threshold loop, and level-up effect are enough for validation.

## 2026-06-28 Full Monster Catalog Import

- What worked: classify sheets by height first. `480` means `60x60` monster cells, `1200` means `150x150` monster cells.
- What worked: derive frame count from sheet width instead of hardcoding 10. This covers large monsters with `4/6/8` frames and the special `57` package with `5/4/4`.
- Reuse rule: import all monster assets, but only load the monster ids needed by the current scene. Full startup loading is unnecessary until there is a monster selection/spawn table.

## 2026-06-28 Movement Direction Animation Fix

- What worked: treat `moveToward` as the single source of truth. It already knows which candidate move passed collision/path checks, so returning the actual delta fixed hero and monster walk direction together.
- Root cause: pathing changed the real movement vector, but animation still used the final target vector.
- Reuse rule: attack faces target; walk faces accepted movement delta.

## 2026-06-28 Map Pathing Fix

- What finally worked: stop treating stuck movement as a local collision problem. Use the old `.blk` grid to build a full A* route, cache that route on the actor, and follow it until the target meaningfully changes.
- What wasted time: adding more retreat/bypass offsets. Those helped actors leave one bad edge, but they could immediately walk back to the same obstacle.
- Reuse rule: for old 2D map movement, use `.blk` reachability and cached paths first. Keep slide, retreat, and unstuck as last-frame rescue logic only.

## 2026-06-28 Hero Frame Anchor Fix

- What worked: treat hero frames like monster frames. Keep each old-client cell as a fixed Cocos SpriteFrame rectangle instead of letting Creator auto-trim every frame.
- Root cause: left/right walk frames were sliced from correct `150x150` cells, but auto-trim made each frame use a different width, height, and offset. Runtime frame swaps then moved the visible character center, making the walk look like it stepped forward and backward.
- Reuse rule: for old role/monster/NPC sheets, preserve fixed cells first. Only add trimming after the old-client anchor and foot point are reproduced deliberately.

## 2026-06-27 Animation Import Pass

- Good: using the already verified Java `.img` converter avoided rewriting the old format again.
- Good: cutting only the active facing row gave a fast Cocos preview path for walk and attack.
- Watch next: the old sheets contain more rows/directions than the current preview uses. Movement work should introduce direction-aware clip selection instead of duplicating more one-off scripts.
- Watch next: character anchors and size should be normalized from frame bounds, otherwise attack frames may look like they slide or squash.

## 2026-06-27 `.img` Tool

The fastest reliable fix was to stop expanding the custom JavaScript decoder and reuse the old converter that already matches the game client. The web tool remains useful for slicing, previewing, and exporting, while the fragile format-specific decoding stays in the proven Java path.

Keep the pure-browser decoder as optional later work, not a blocker for asset processing.

## What Worked

- Switching from old-server startup to asset-first scanning kept the work aligned with the remake goal.
- The old bundle already includes direct web-friendly assets, enough for a first interactive prototype.
- `ponytail` is a good fit here: prove the smallest playable loop before owning a big engine setup.

## What Did Not Work

- The packed `.img` art is not browser-ready.
- Cocos Creator is not installed, so a real Cocos scene cannot be generated and verified yet.

## Decisions

- Do not run the old Java server.
- Do not add a backend yet.
- Do not build registration, login, recharge, or multiplayer yet.
- Pause Cocos and gameplay work.
- Build a local `.img` processing tool first.

## Next Review Point

After several common `.img` families decode correctly, add presets and batch export.

## 2026-06-27 Cocos Real Map Pass

The correct old scene source is `client/data/map/*.map` plus `client/pak/mapimg/*.zip`; `client/image/sm/*.jpg` is only a minimap/thumbnail.

What worked: decompiling only the small renderer classes (`b.a.b.q`, `b.a.b.r`, `b.a.b.l`) exposed the useful rules quickly: 60px square tiles, 1-based map ids, and object layers after the base grid.

What did not work: generating a giant first pass without checking the old `N - 1` tile offset created a plausible but wrong map.

Decision: use a 3000x3000 precomposed PNG for the first Cocos preview. Runtime tile streaming can wait until movement/camera needs it; for web compatibility this avoids a 6000x6000 texture and keeps the first visible scene simple.

## 2026-06-27 Hero Preview Fix

The magenta block was not a rendering style problem; it was a missing SpriteFrame reference. The smallest fix was to reuse Creator's current imported UUIDs and keep the existing Cocos `cc.Animation` instead of adding runtime loader code.

Camera zoom is now closer by changing orthographic height from 450 to 320.

## 2026-06-28 Full Map Import

- What worked: keep map import as one batch conversion job instead of hand-editing Cocos assets.
- The old map data is split across `.map`, `.blk`, and `pak/mapimg` tiles. Importing preview, occlusion, collision, metas, and thumbnails in one script prevents drift between files.
- Reuse rule: run `tools/build-all-map-assets.ps1` when adding or refreshing maps.
- Occlusion rule: preview gets all map objects, but occlusion only gets upper mapped layers. Low props such as stones must stay behind actors.
- Constraint: maps without `.blk` are visual-only until collision is found or authored. Do not fake passability just to make the map list look complete.

## 2026-06-28 Map Editing Direction

- What worked: treat manual edits as patch data instead of rewriting old binary map files.
- This keeps generated maps reproducible while allowing custom props, collision rectangles, and occlusion behavior.
- Reuse rule: place custom map decorations through `map-editor/`; save creates `map_ID_patch.json`, and Cocos runtime merges it.

## 2026-06-28 Hero Attribute System

- What worked: using the old saved hero `dddd.txt` as a sanity check after decompiling the formulas. Level 62 matching `126/192/64` proved the race 0 growth table.
- What stayed intentionally simple: no equipment, depot, title, buff, or rebirth bonuses in the first runtime formula. Those systems do not exist in the remake yet.
- Reuse rule: keep base combat math inside one derived-stat function. Add future equipment/title/buff bonuses there, then combat and UI both read the same result.

## 2026-06-28 Inspector Config For Maps

- What worked: putting map id and monster stats on the existing `HeroIdlePlayer` component avoided a separate Cocos editor extension.
- The important rule: runtime must have one source of truth. Map loading, monster spawning, combat damage, HP bars, and EXP should all read the same inspector config.
- Reuse rule: keep scene-level tuning in inspector properties for now. Move to JSON/database only when multiple maps need batch editing or runtime hot updates outside Creator.

## 2026-06-28 Editor-First Authoring Direction

- What worked in the old game: content is separated into data tables. `scenes.txt` selects the map, `config/monster/<sceneId>.txt` places monsters, `monsters.txt` defines stats, `monster_ai.txt` defines behavior, and `plunders.txt` defines rewards.
- What we should copy conceptually: use ids and references between tables/settings. Do not directly copy the whole old format until the remake needs that complexity.
- Remake rule: "我的游戏" should expose tunable content in the Cocos editor first. The user should be able to change a map id, monster list, monster stats, and later reward ids before pressing Preview.
- Reuse rule: future features should add editor-facing config first, then runtime logic reads from that config. Hardcoded defaults are allowed only as fallbacks for missing/invalid editor values.

## 2026-06-28 No-Code Content Authoring

- Core requirement: the user should be able to author and tune confirmed gameplay content without reading or editing TypeScript.
- Old game lesson: its `.txt` tables are not just data storage; they are the practical authoring interface. Even complex monster AI is editable as columns and rows.
- Remake rule: after a feature is proven in gameplay, expose its stable settings through the Cocos Inspector or a simple config/editor screen.
- Practical split:
  - Use Inspector fields for small per-scene settings such as current map id and monster list.
  - Use serializable config assets or JSON for larger tables such as reward ids, item drops, skill ids, and many maps.
  - Use a custom editor only when the Inspector becomes too clumsy.
- Quality bar: do not leave important tuning values as hidden code constants unless they are internal fallbacks.
