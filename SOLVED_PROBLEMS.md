# Solved Problems

## Cocos Dashboard Shows Missing Editor

### Symptom

Dashboard listed `cocos-remake` as `Creator Unknown` and showed `缺失编辑器`, even though Creator 3.8.8 was installed.

### Cause

The copied Cocos template project had a minimal `package.json` without `uuid` and `creator.version`, so Dashboard could not bind it to the installed editor version.

### Solution

Add project metadata:

```json
{
  "creator": {
    "version": "3.8.8"
  }
}
```

Also update the Dashboard project cache entry to `version: "3.8.8"`.

## Hero `0.img` Only Shows One Row

### Symptom

The browser tool decoded `0.img` as `600x1200`, but visible hero frames appeared in the wrong lower area. The old converter output showed the expected 4 columns by 5 visible rows layout.

### Cause

The browser JavaScript `.img` decoder was only a first-pass approximation and did not exactly match the old client renderer in `client.zip`.

### Solution

Use the verified old Java converter through the tiny local Node bridge:

```ps1
node img-tool\server.js
```

Open:

```text
http://127.0.0.1:5174/img-tool/
```

### Verification

Posting `D:\测试光效\img_png_tool\0.img` to `/img-tool/api/img2png` produced a PNG with the same SHA256 hash as `D:\测试光效\img_png_tool\0.png`.

## `ponytail` Skill Installation

### Symptom

`ponytail` was not in the official curated skill list.

### Solution

Installed it from GitHub:

```ps1
python "C:\Users\55200\.codex\skills\.system\skill-installer\scripts\install-skill-from-github.py" --repo DietrichGebert/ponytail --path skills/ponytail
```

### Note

Restart Codex to pick up new skills automatically. In this run, the installed `SKILL.md` was read directly and its minimal-code rules are being followed.

## PowerShell Blocks `npm.ps1`

### Symptom

`npm -v` fails because `npm.ps1` is not digitally signed.

### Solution

Use `npm.cmd` instead:

```ps1
npm.cmd -v
```

### Rule Next Time

On this machine, prefer `npm.cmd` in PowerShell commands.

## Cocos Creator Not Found

### Symptom

No `cocos` or `CocosCreator` command was found, and no Cocos folder appeared under `C:\Program Files`.

### Solution

Do not block the asset/gameplay prototype. Build a zero-dependency web MVP first, then migrate into Cocos Creator after the editor is installed.

### What User Needs Later

Install Cocos Creator 3.x when we are ready to create the actual Cocos scene project.

## `.img` Format First Pass

### Symptom

Packed client art is not directly usable by browsers or Cocos.

### Evidence

Old client loader `a.b.v` reads `.img`, creates one of `a.b.f`, `a.b.w`, or `a.b.ac`, then calls that object to parse the bytes.

### Solution For Now

Use direct JPG/GIF/PNG assets for the first playable slice. Keep `.img` decoding as the next asset-pipeline task.

## MVP Browser Verification

### Symptom

Playwright was installed but its bundled Chromium was missing.

### Solution

Use the system Edge executable:

```text
C:\Program Files (x86)\Microsoft\Edge\Application\msedge.exe
```

### Result

The MVP page rendered with no page errors and a nonblank canvas.

## Local `.img` Tool First Pass

### Result

Created:

```text
img-tool/index.html
img-tool/src/img-decoder.js
img-tool/src/app.js
```

### Verified

The tool decodes and previews real `.img` files from:

```text
img-tool/samples/hero_00_0_0.img
img-tool/samples/monster_0_0.img
img-tool/samples/effect_100.img
```

### Known Limit

The decoder is a first pass. If a specific asset looks incomplete, compare that asset against the old Java renderer and patch only the missing branch.

## Hero Sheet Looks Black

### Symptom

Uploading `client/pak/hero/00/.../0.img` showed an apparently black preview.

### Cause

The image decoded, but the character frames were far down inside the sheet. The top area was transparent.

### Solution

The tool now:

- Detects non-transparent content bounds.
- Sets `起点 Y` automatically.
- Sets rows and columns from the content area.
- Shows the selected cut range instead of the full source sheet.

## Real Map 0 Rendering In Cocos

### Symptom

The Cocos preview used a tiny map image and the earlier generated full map showed wrong black/red tile blocks.

### Cause

`client/image/sm/0.jpg` is only a mini map thumbnail. The real map is `client/data/map/0.map`.

The `.map` tile values are 1-based. The old client stores tile value `N`, then draws `image/map/(N - 1).img`. The first generated map used `N.img` directly, so every tile was shifted by one.

### Solution

Use `tools/build-map-preview.ps1`:

```ps1
powershell -NoProfile -ExecutionPolicy Bypass -File tools\build-map-preview.ps1
```

It scans the old client folder, extracts required map tiles from `client/pak/mapimg/*.zip`, converts them through the verified `ImgPngTool`, applies the `N - 1` rule, draws base tiles and object layers, then writes:

```text
cocos-remake/assets/resources/maps/map_0_preview.png
```

### Verification

The generated map is `3000x3000`, includes 440 tile images and 1249 map objects, and visually matches the old town/island layout.

## Cocos Magenta Hero Block

### Symptom

Preview showed a large magenta block where `HeroIdle` should be, and the character did not appear.

### Cause

The scene and animation clip referenced old hand-written SpriteFrame UUIDs. Cocos Creator had already reimported `idle_00..03.png` with new UUIDs, so the scene pointed at missing SpriteFrames.

### Solution

Update `assets/Main.scene` and `assets/animations/hero_00/idle.anim` to use the current SpriteFrame UUIDs from each `idle_*.png.meta`. Also update the scene animation clip UUID to the current `idle.anim.meta` UUID.

### Verification

`assets/Main.scene` and `idle.anim` parse as JSON, and no old bad UUID remains under `cocos-remake/assets`.

## Hero Too Large In Cocos Preview

### Symptom

The hero looked huge and blurry compared with the map.

### Cause

The scene still used the old `150x150` UITransform and `scale=2`, while Cocos had trimmed the actual imported idle frame to about `22x54`.

### Solution

Set `HeroIdle` scale back to `1`, and set the UITransform content size to `22x54`.

## Idle Animation Cache Not Updating

### Symptom

The hero appeared but did not animate.

### Cause

The animation clip asset had been edited externally while its meta still marked it as already imported. Cocos could keep using the stale imported clip.

### Solution

Set `assets/animations/hero_00/idle.anim.meta` to `imported: false` so Creator reimports it, and add `HeroIdlePlayer.ts` as a tiny runtime fallback frame switcher.

## HeroIdlePlayer Script Was Not Mounted

### Symptom

The hero appeared but still did not animate.

### Cause

`HeroIdlePlayer.ts` existed and was compiled by Cocos, but it was not attached to the `HeroIdle` node in `Main.scene`.

### Solution

Attach the script component with Cocos script id `ab66bk0fghJCoHw+C6ANh2y` to `HeroIdle`, and disable the stale `cc.Animation` component so only the runtime frame switcher controls the sprite.

## Hero Grows When Animation Starts

### Symptom

The hero appears small for one moment, then becomes large once frame playback starts.

### Cause

Changing `spriteFrame` at runtime made the Sprite apply the new frame's automatic size rules.

### Solution

Set Hero Sprite to custom size mode and call `UITransform.setContentSize(22, 54)` after every frame swap in `HeroIdlePlayer`.

## Hero Walk And Attack Sheets Are Not Separate PNG Sequences

### Symptom

The old client stores walk and attack actions as `.img` sheets inside `client/pak/hero/00/0.zip`, not as ready-to-use Cocos sequence frames.

### Cause

Each action sheet uses a fixed `150x150` cell layout. For this first character, `1.img` has 6 columns for walking and `2.img` has 8 columns for attacking.

### Solution

Convert the `.img` sheets to PNG with `ImgPngTool`, then crop the first row into individual PNG files under `assets/resources/heroes/hero_00/walk` and `assets/resources/heroes/hero_00/attack`. Load those frames at runtime with `resources.load(.../spriteFrame)`.

### Verification

Cocos Creator generated `.meta` files for all new walk and attack PNGs, so the resources folder has been imported and is ready for Preview loading.

## Cocos Script Target Does Not Like String.padStart

### Symptom

Running the Cocos-bundled TypeScript check reported `Property 'padStart' does not exist on type 'string'` for `HeroIdlePlayer.ts`.

### Cause

The project tsconfig extends Cocos' generated config, whose target libraries do not guarantee `String.padStart`.

### Solution

Use a tiny manual zero-prefix expression instead of `padStart`: `i < 10 ? '0' : ''`.

## Click Animation Should Be State-Driven, Not Auto-Cycled

### Symptom

The hero kept looping idle, walk, and attack by itself after entering Preview.

### Cause

The first hookup used auto-cycling only to prove all imported action frames could load.

### Solution

Replace auto-cycling with three runtime states in `HeroIdlePlayer.ts`: idle by default, walk while moving to a clicked ground position, and attack once when clicking the temporary `MonsterTarget`.

## New Monster PNG Did Not Import Immediately

### Symptom

`assets/resources/monsters/monster_00/idle_00.png` was generated, but no `.meta` appeared right away.

### Cause

Cocos Creator had not refreshed the new folder yet.

### Solution

Do not block the interaction prototype on that import. Runtime `MonsterTarget` currently reuses an already imported hero frame with a red tint; replace it with the real monster sprite after Creator imports the new monster asset.

## Eight Directions From Five Valid Rows

### Symptom

The old walk and attack sheets are `8` rows tall, but rows `5..7` contain no visible pixels.

### Cause

The old asset format stores five real facing rows and relies on horizontal mirroring for the remaining three directions.

### Solution

Export `d0..d4` directly from rows `0..4`, then export `d5..d7` as mirrored versions of rows `3..1`. This gives Cocos a full eight-direction folder layout without inventing new art.

## Auto-Battle Prototype Should Not Depend On Mouse Input

### Symptom

The previous prototype used mouse clicks to switch idle, walk, and attack states.

### Cause

That was useful for testing animation hookup, but it does not match the mobile idle/auto-battle direction.

### Solution

Move the state changes into `HeroIdlePlayer.ts`: spawn monsters, choose nearest target, walk to it, attack in range, and return to hunting automatically.

## Hero Action Frames Look Different From The Old Game

### Symptom

Idle, walk, and attack animation looked subtly wrong compared with the old client. Attack frames especially looked compressed.

### Cause

The exported PNG frames were correct `150x150` old-client cells, but `HeroIdlePlayer` forced every sprite frame into the first idle frame's trimmed size, `22x54`. Walk and attack frames have different visible bounds, up to about `40x65`, so forcing `22x54` stretched or squeezed them.

### Solution

First temporary fix: render hero frames at the current SpriteFrame's trimmed size:

- Use `Sprite.SizeMode.TRIMMED`.
- Read the current frame rect with `spriteFrame.getRect()`.
- Set the hero `UITransform` to that frame's `rect.width` and `rect.height` after each frame swap.

Final correction after sideways jitter testing: keep the SpriteFrame meta itself as the full `150x150` old-client cell, with zero trim and zero offset. This preserves a stable animation anchor while avoiding the stretching caused by `RAW` on auto-trimmed SpriteFrames.

### Verification

Frame inspection showed the source action sheets are fixed-grid:

- idle: `600x1200`, `4x8` cells.
- walk: `900x1200`, `6x8` cells.
- attack: `1200x1200`, `8x8` cells.

The visible bounds vary by frame, but the raw cell is consistently `150x150`.

Follow-up correction: `Sprite.SizeMode.RAW` made Cocos display the trimmed SpriteFrame inside a `150x150` node and visually enlarged the hero. Fix the SpriteFrame meta to the full cell first; then runtime `TRIMMED` rendering uses a stable `150x150` rect without per-frame anchor drift.

## Repeatable Role And Monster Frame Import

### Symptom

Different actions looked stretched or oversized after being sliced into Cocos frames.

### Cause

The old client uses fixed-size cells, but each Cocos SpriteFrame has different trimmed visible bounds. Reusing one fixed display size, or switching to `RAW`, changes the apparent scale.

### Solution

Document and follow the fixed import flow in `ANIMATION_IMPORT_GUIDE.md`: convert with `ImgPngTool`, crop fixed cells without resizing, mirror missing direction rows when needed, then keep the Cocos SpriteFrame meta at the full fixed cell. Runtime can still use `Sprite.SizeMode.TRIMMED`, but the frame rect must already be the full old-client cell.

Follow-up correction for monsters: the `600x480` sheets are `10 x 8`, not `10 x 5`. The correct monster cell is `60x60`. Keep the full fixed cell in the Cocos SpriteFrame meta. Per-frame trimming recenters shadows and weapons, which makes the monster sequence appear wrongly sliced.

## Old Map Collision Already Exists

### Symptom

Manual collision painting sounded too slow because the map contains many buildings, trees, water edges, and walls.

### Cause

The visible `.map` file is only part of the old map data. Each map can also have a `.blk` file.

### Solution

Use the old `.blk` file as the movement grid. For map 0, `0.blk` is `150x200`; value `127` is passable and value `0` is blocked. Export it into a Cocos `JsonAsset` and check the actor foot position before moving.

## Actor Walks In Place Against A Building

### Symptom

After adding `.blk` blocking, the hero or monster could stand at an obstacle and keep playing the walk animation.

### Cause

The first collision pass rejected blocked movement but still kept the actor in its walk/chase state.

### Solution

Move through a shared `moveToward()` helper. It tries the direct movement first, then a few slide directions along the obstacle edge. If no movement succeeds, switch the actor back to idle instead of continuing the walk animation.

## Actor Gets Stuck On Trees Or Building Corners

### Symptom

The hero could reach a tree/building edge and stop there while the target was still reachable around the obstacle.

### Cause

The first collision pass only tried direct movement and short slide directions. The next pass asked A* for only one next grid cell, then forgot the rest of the route on the next frame. That still made actors re-probe wall/tree/water edges instead of committing to a clean route around the obstacle.

### Solution

Use the old `.blk` grid to build a full A* path and cache it on the moving actor. The actor follows that cached path until a waypoint is reached or the target moves far enough to require a replan. Keep direct movement, slide movement, retreat, and unstuck only as fallbacks when no cached path can move this frame.

## First Map Occlusion Test

### Symptom

Characters walked over tree canopies and building roofs because the first map preview was one flat PNG behind all actors.

### Cause

The old map has object layers, but the preview image flattened them together. Cocos had no separate upper layer to draw above actors.

### Solution

Generate `map_0_occlusion.png` from the old object layer and load it as `Map0Occlusion` above actors at runtime.

### Known Limit

This is a whole-layer overlay. It may cover actors even when they should be visually in front of an object. For perfect old-game depth, split objects into individual sprites and sort them by Y/baseline.

## Actors Slip Into Carts Or Wall Corners

### Symptom

The hero or monsters could look stuck inside a cart or against a wall corner even after `.blk` movement blocking was enabled.

### Cause

Movement only checked the actor center point. A center point can still be passable while the actor's feet overlap a blocked neighbor cell. The first A* pass also allowed diagonal movement through blocked corners.

### Solution

Check a small foot radius around the destination before moving. If an actor is already overlapping, only allow movement that improves the stand score. In A*, only use cells where that foot radius fits, and block diagonal corner cutting.

### Follow-Up

If direct, slide, and A* movement all fail in the same frame, scan 16 nearby directions and move to the best standable point immediately. This prevents the actor from repeating the same failed movement while standing in one place.

Do not treat "not getting closer to target" as stuck. That misfires while correctly walking around buildings or chasing a moving target. Track whether the actor's own position barely changes instead.

When a dead corner really traps the actor, first try a short retreat point away from the target before choosing a general bypass point. This gives the actor room to leave narrow walls, gates, and roof corners without interrupting normal chase movement.

Use a quantized coordinate check for the final stuck signal: while `moveToward()` is running, put the actor position into small coordinate buckets. If the actor stays in the same bucket for about `0.5s`, trigger retreat/bypass. Because attack state does not call movement, this does not interrupt combat.

Keep a bypass target alive until the actor reaches it or the short timer expires. Clearing it as soon as the actor moves a little makes the actor switch back to the original target and hit the same tree/building edge again.

When choosing an escape point, scan several nearby radii and reject points too close to another actor. A single fixed-radius bypass can land inside another blockage and make the actor look stuck even though the stuck detector fired.

## Actors Chase Unreachable Enemies Across Rivers Or Walls

### Symptom

The hero keeps walking into a river/wall edge, retreats a few steps, then returns to the same blocked edge because a monster exists on the other side.

### Cause

Target selection only used straight-line distance. The nearest monster could be on another disconnected `.blk` island, so local unstuck logic kept fighting an impossible route.

### Solution

Before choosing or chasing a nearby target, ask the existing A* fallback whether the target is reachable on the `.blk` grid. If not, skip that target for now. Use a viewport-sized check range (`900px` currently); the first `420px` pass was too small and still allowed wall-side targets visible on screen.

If a target still causes a wall/tree loop, do not keep tuning slide or retreat offsets. Track progress per current target: if the hero spends about `2.2s` on the same monster without reducing the distance by a meaningful amount, put that monster on a short cooldown (`5s` currently). This lets auto-battle switch to another monster instead of oscillating at one impossible edge.

Distance progress alone is not enough for tight obstacle clusters because the actor can move back and forth and occasionally get a little closer. Also track whether the hero remains inside a small area (`80px` currently) while chasing the same target. If that area-loop lasts about `2.2s`, cooldown the current target too.

## Actors Overlap Each Other

### Symptom

Monsters and the hero could stand on the same foot position, or multiple monsters could stack while chasing/wandering.

### Cause

Movement collision only checked the map `.blk` grid. It did not check other runtime actors.

### Solution

Before moving, spawning, or picking a wander point, reject positions too close to another actor. Keep the attack range larger than the separation radius so actors can still fight without overlapping.

## Hero Ignores A Nearer Monster While Walking

### Symptom

The hero could keep chasing an older target while walking past a nearer monster.

### Cause

Target selection only refreshed when the current target was destroyed or invalid.

### Solution

Refresh hero target to the nearest valid monster every frame. This makes the hero attack nearby monsters first while moving across the map.

## Runtime Occlusion Hidden Behind New Monsters

### Symptom

The hero could be covered by the occlusion layer, but newly spawned monsters still appeared above trees or roofs.

### Cause

`Map0Occlusion` was created before later `AutoMonster` nodes. Cocos sibling order draws later nodes above earlier ones.

### Solution

After spawning/updating, move `Map0Occlusion` back to the last sibling so it stays above runtime monster nodes.

## Monsters Draw Above A Lower Player

### Symptom

A monster standing higher on the map could render over the hero standing below it, making the monster look like it was stepping on the hero's head.

### Cause

Runtime monsters were created after the hero, so their sibling order stayed above the hero regardless of map position.

### Solution

Runtime actors also need their own depth order. Sort the hero and monsters by world Y every frame: actors lower on the screen are moved later in sibling order, so they render above actors standing higher on the map.

## Hero Left/Right Walk Looks Like It Jumps Forward And Back

### Symptom

When the hero walks left or right, the animation looks uneven: the body appears to shift forward and backward between frames even though movement speed is stable.

### Cause

The PNG frames were correctly cut from old-client `150x150` cells, but Cocos auto-trimmed every SpriteFrame. Each frame then had different `trimX`, `trimY`, width, height, and offset. Runtime playback changed the visible frame center on every swap, so sideways movement looked like anchor jitter.

### Solution

Keep hero frames as full fixed cells, the same way monster frames are handled:

- `trimX=0`
- `trimY=0`
- `offsetX=0`
- `offsetY=0`
- `width=150`
- `height=150`
- `rawWidth=150`
- `rawHeight=150`
- `trimType=custom`

Update the SpriteFrame vertices to the full `150x150` rectangle and let Creator reimport the metas.

### Rule Next Time

For old role, monster, and NPC sheets, preserve fixed cell SpriteFrames first. Do not rely on Cocos auto-trim for animated actors unless a separate anchor/foot-point system has already been implemented.

## Hero Plays The Wrong Walk Direction Or Moonwalks

### Symptom

The hero walks toward right-down but plays the right-facing clip, or the hero visibly moves backward while the animation faces another direction.

### Cause

Walk direction was selected from the final target vector. After cached A* pathing, bypass, and unstuck logic, the actor often moves toward the next path waypoint instead of the final enemy position.

### Solution

Let `moveToward` record the actual per-frame movement delta. Use that delta for walk clips. Keep target-vector direction only for attack clips, because attacks should face the enemy.

### Rule Next Time

When pathfinding exists, animation direction must follow actual movement, not desired destination.

## Level-Up Effect Source Confusion

### Symptom

The first effect candidate looked plausible, but it was not the actual upgrade effect. A later screenshot pointed to `effect/6.img`.

### Cause

Numeric effect files in `effect.zip` are generic visual effects. Filename alone does not describe usage, and several golden/blue effects look plausible in a montage.

### Solution

Use the user-confirmed old asset `client/pak/effect.zip:image/effect/6.img`. It is a `920x128` sheet, split into `10` horizontal frames of `92x128`.

### Rule Next Time

For old-client effects, build a montage for discovery, but only wire the asset after confirming the effect id. Then preserve the sheet grid and check alpha before importing to Cocos.

## Skill Effect Keeps A Black Background

### Symptom

The level-up effect displayed black vertical strips in Cocos.

### Cause

Old effect sheets use black as the transparent key color. Removing only pure or near-pure black pixels is not enough because the glow has dark antialias pixels around it.

### Solution

Regenerate effect PNG alpha from pixel brightness: black and near-black become transparent, brighter glow pixels keep proportional alpha.

### Rule Next Time

For skill/effect imports, always run black-to-alpha processing before Cocos import. Do not use the actor-frame import rule directly for glow effects.

## Batch Map Import Needs One Entry Point

### Symptom

Map 0 was already working, but the process was split across preview rendering, `.blk` export, occlusion generation, and Cocos meta creation. Repeating that manually for every old map would make missed files and bad metas likely.

### Cause

The old client stores one playable map across several sources: `.map` for visual tile/object layout, `.blk` for movement blocking, and `pak/mapimg/*.zip` for image tiles.

### Solution

Use `tools/build-all-map-assets.ps1` as the single entry point. It generates preview PNGs, transparent occlusion PNGs, `.blk` collision JSON where available, Cocos metas, thumbnail previews, and `map_catalog.json`.

### Rule Next Time

Do not synthesize collision for maps without `.blk`. Import the visual layers and record missing collision in `MAP_CATALOG.md`, so runtime code can avoid enabling pathing on those maps until real collision data is found or authored.

## Low Map Props Covered Actors

### Symptom

On map 003, small stones rendered above the hero.

### Cause

The batch map importer drew every object layer into `map_ID_occlusion.png`. Low ground props should be baked into the base preview only; putting them in the transparent occlusion overlay makes them render above actors.

### Solution

Keep drawing all objects into `map_ID_preview.png`, but only draw mapped object layer `>= 3` into `map_ID_occlusion.png`.

### Rule Next Time

When refreshing maps, use `tools/build-all-map-assets.ps1` with the default occlusion layer rule. Do not put low ground props such as stones into actor occlusion.

## Need To Add Objects Without Rewriting Old Map Files

### Symptom

We need to add new decorations, such as a large tree, without editing the old binary `.map` format directly.

### Cause

The old map data is generated from `.map`, `.blk`, and `mapimg` assets. Editing generated Cocos scene nodes directly would drift from the importer and could be overwritten during batch regeneration.

### Solution

Use a patch layer. The local editor saves placed objects to `cocos-remake/assets/resources/maps/patches/map_ID_patch.json` and copies used object PNGs into `assets/resources/map_objects`. Runtime loads the patch, creates independent Sprite nodes, adds their collision rectangles to movement checks, and includes occluding objects in Y sorting.

### Rule Next Time

Do not modify old `.map` files for custom props. Add new map props through `map_ID_patch.json`, then let runtime merge the patch over the generated base map.

## Downloaded Humanoid Sprites Have Wrong Size And Center

### Symptom

Downloaded humanoid PNG frames looked too large for the current game and did not share a stable center point. Direct import would cause foot sliding, jitter, and inconsistent actor placement.

### Cause

The source PNGs are not old-client fixed cells. They have different canvas sizes per direction/action, and each visible character has a different transparent bounding box and foot center.

### Solution

Use `tools/import-humanoid-sprites.ps1`. It reads the visible alpha bounds, scales the visible body to `0.35`, draws every frame into a fixed `150x150` canvas, and pins the foot anchor to `(75, 96)`. The output becomes a normal Cocos role resource under `assets/resources/heroes/humanoid_00`.

### Rule Next Time

For external humanoid/role art, do not manually resize individual frames and do not rely on Cocos auto-trim. Normalize every frame to a shared canvas with a fixed foot anchor before wiring idle/walk/attack clips.

## Old Combat Numbers Are Bitmap Sprites

### Symptom

Damage numbers and combat words need to match the old game style. Cocos `Label` text would be faster to display, but it would not match the original red digits, heal digits, MP digits, or `击空/丢失/格挡/爆击` art.

### Cause

The old client stores combat feedback in `effect/num.img`, arranged as rows of bitmap glyphs rather than a font.

### Solution

Cut `num.img` into individual transparent sprites under `assets/resources/effects/damage_text`, then compose floating combat text from those sprites at runtime. Use row 1 for normal damage and `text_crit` for prototype critical hits.

### Rule Next Time

For combat text, reuse the imported bitmap glyphs. Do not rebuild old-client combat feedback with plain labels unless it is only temporary debug UI.

## Old Hero Attribute Formulas

### Symptom

The remake needed character attributes and level-up gains, but plain fixed HP/damage values would drift from the old game immediately.

### Cause

The values are not stored in one config file. The saved hero XML stores current values, while the real growth and derived-stat formulas live in the old server bytecode: `app.island.entity.Hero` and `app.island.entity.Sprite`.

### Solution

Use `javap -c -p` on the old server classes. For race 0, base attributes are `strength=2`, `dexterity=6`, `wisdom=2`, and each level adds `+2/+3/+1`. Derived HP, mana, damage, defense, hit, and evade are calculated from the recovered formulas in `HeroIdlePlayer.ts`.

### Rule Next Time

When adding real combat attributes, read the old bytecode or config source first, then implement only the currently used fields. Equipment/depot bonuses should be added to the existing derived-stat function when equipment exists, not scattered through combat code.

## Map And Monster Config Should Be Editable In Cocos

### Symptom

Map id, monster kinds, monster HP, attack, defense, and EXP were still hardcoded in runtime constants. This made it difficult to inspect which map was active and to tune one map without touching code.

### Cause

The first combat prototype prioritized runtime proof over authoring workflow, so the scene had one fixed map id and one fixed monster stat profile.

### Solution

Expose `地图编号` and `地图怪物配置` on the `HeroIdlePlayer` component. Runtime reloads map preview/collision/occlusion/patch files from the inspector map id, and monster spawn/combat/death EXP read directly from the configured monster entries.

### Rule Next Time

Per-map monster composition and basic monster stats belong in the scene inspector until a real external map config database exists. Do not add new fixed monster constants for map-specific tuning.

## Future Content Settings Must Be Editable

### Symptom

The user will keep adding map, monster, reward, drop, and similar gameplay systems. If every new system is hardcoded, the user cannot author or test content directly in Cocos before pressing Preview.

### Cause

The old game is data-driven: scenes, map ids, monster spawns, monster stats, AI, and drop tables are stored in separate config files. The remake initially started as a runtime prototype, so some values were still implemented as constants.

### Solution

Treat the Cocos editor/Inspector as the first authoring surface. Add serialized fields or serializable config classes for values the user needs to tune, then make runtime read those fields as the source of truth.

Old game reference:

- `server/config/scenes.txt`: scene to map id and scene rules.
- `server/config/monster/<sceneId>.txt`: spawn coordinates plus `monsterID`, `plunderID`, and `behaviorID`.
- `server/config/data/monsters.txt`: monster stats.
- `server/config/data/monster_ai.txt`: behavior settings.
- `server/config/data/plunders.txt`: EXP/money/item drop table.

### Rule Next Time

For every new content system, first ask: "Will the user need to change this in the editor?" If yes, expose it in the Inspector or a project data file referenced by the Inspector. Do not bury map-specific or monster-specific tuning in code constants.

## Avoid Code-Only Tuning For User-Facing Systems

### Symptom

A feature works, but the user cannot adjust it without asking Codex to edit code. This blocks map building, monster balancing, reward setup, and repeated testing.

### Cause

Runtime prototypes naturally start with constants. If those constants remain after the feature is accepted, the remake becomes programmer-only instead of editor-driven.

### Solution

Before marking a gameplay/content feature complete, expose its important values through one of these surfaces:

- Cocos Inspector fields for small per-scene settings.
- Serializable config classes/assets for reusable settings.
- JSON/editor-tool tables for larger datasets.

The runtime should read those values directly. Code constants are only defaults or fallbacks.

### Rule Next Time

For every accepted system, also deliver the user's edit path: where to click, what field to change, when to save, and what should happen in Preview.

## Attack Damage Should Wait For One Full Animation

### Symptom

Monster attack animation had just started, but the player HP already changed.

### Cause

The runtime applied monster damage as soon as the monster entered attack range and the cooldown expired. That tied damage to attack state start, not to the visible strike.

### Solution

Split monster attack into three steps:

- start one attack animation.
- apply damage once when the attack animation finishes.
- enter cooldown after the damage resolves.

### Rule Next Time

For normal monster attacks in this prototype, one full attack animation equals one attack. Do not apply damage at animation start or at a partial hit frame unless a later skill explicitly needs its own hit timing.

## Damage Number Spacing Too Wide

### Symptom

Floating damage like `-17` had a large gap between digits.

### Cause

The `*_1.png` damage glyphs kept an isolated black pixel column far to the right, so Cocos treated the digit as `28px` wide.

### Solution

Crop only the bad glyph files (`damage_1`, `heal_1`, `special_1`, `mp_1`) to the real visible digit width and keep the black outline. Runtime also uses a small negative glyph gap.

### Rule Next Time

For damage fonts, preserve the black outline but remove stray far-away pixels before importing. Check glyph width with `1`, because it is the easiest number to over-space.
