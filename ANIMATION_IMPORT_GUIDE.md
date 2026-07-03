# Animation Import Guide

## Old `.img` To Cocos Frames

1. Convert the old `.img` action sheet with the existing Java `ImgPngTool`.
2. Inspect the PNG sheet size and derive the fixed cell size from the old action layout.
3. Crop fixed cells only. Do not resize, stretch, or trim the exported PNG by hand.
4. If the sheet has five valid direction rows, export rows `0..4` directly and mirror rows `3..1` into directions `5..7`.
5. Put frames under `assets/resources/<kind>/<id>/<action>/d<dir>/<action>_NN.png`.
6. In Cocos, load frames with `resources.load(.../spriteFrame)`.
7. Keep animated actors as full fixed-cell SpriteFrames in Cocos meta. Set `trimX=0`, `trimY=0`, `offsetX=0`, `offsetY=0`, and `width/height = rawWidth/rawHeight = cell size`.
8. Use `Sprite.SizeMode.TRIMMED` only after the SpriteFrame rect itself has been fixed to the full old-client cell. Do not let Cocos auto-trim each frame, or it will recenter every frame and the animation will jitter.

## Current Known Layouts

- Downloaded humanoid sprite set `无双暗影世界/人形素材`
  - File naming is grouped by action and direction:
    - idle: `02880..02953`, eight directions, `4` frames per direction.
    - walk: `02960..03035`, eight directions, `6` frames per direction.
    - attack: `03040..03117`, eight directions, `8` frames per direction.
  - Direction order matches runtime `d0..d7`: back, right-up, right, right-down, front, left-down, left, left-up.
  - Source frames have inconsistent canvas sizes and drifting foot centers. Do not import directly.
  - Use `tools/import-humanoid-sprites.ps1` to normalize:
    - output canvas: `150x150`
    - scale: `0.35`
    - fixed foot anchor in image pixels: `x=75`, `y=96`
    - output path: `assets/resources/heroes/humanoid_00`
  - Runtime can switch the active player art with `HERO_RESOURCE` in `HeroIdlePlayer.ts`.
- Foldered external humanoid sprite set, such as `D:\anyingzhange\xinrenwu`
  - Action folders: idle folder has 32 frames, walk has 48 frames, attack has 64 frames, death has one frame.
  - Direction order is already full eight directions: back, right-up, right, right-down, front, left-down, left, left-up.
  - File numbering:
    - idle: base `00000`, `4` frames per direction, direction stride `10`.
    - walk: base `00080`, `6` frames per direction, direction stride `10`.
    - attack: base `00160`, `8` frames per direction, direction stride `10`.
    - death: use the first PNG in the death folder as `death_00`.
  - Source frame canvases may differ, so normalize rather than importing directly. Keep the full source PNG canvas when drawing into the normalized frame; this source canvas carries action offsets.
  - Use `tools/import-foldered-humanoid-sprites.ps1`:
    - output canvas: `320x320`
    - default scale: `0.38`
    - preferred anchor mode: if `Placements/<frameId>.txt` exists, treat the two numbers as the old client top-left placement offset from the actor anchor. Draw the scaled source image at `Anchor + Placement * Scale`.
    - default placement anchor in normalized image pixels: `x=160`, `y=180`.
    - fallback anchor mode: if a placement file is missing, preserve the source PNG canvas, scale the whole image, and align the source canvas bottom-center to the fixed foot point `x=160`, `y=240`.
    - Do not crop to visible bounds and do not compute a new foot anchor per frame; wings, attack effects, and moving feet will pull the body around and cause jitter.
    - default output path: `assets/resources/heroes/hero_00/appearance_8`
  - If `Placements` files are present, do not run `tools/stabilize-humanoid-idle-walk.ps1` after import. The stabilizer is only a fallback for sources without old-client placement offsets.
    - It does not touch attack frames.
    - It groups frames by action and direction, finds the median visible center/foot point, and shifts only idle/walk frames so the actor no longer bobs because of drifting source canvases.
- Hero `client/pak/hero/00/0.zip`
  - `0.img`: idle, `600x1200`, `4 x 8`, cell `150x150`.
  - `1.img`: walk, `900x1200`, `6 x 8`, cell `150x150`.
  - `2.img`: attack, `1200x1200`, `8 x 8`, cell `150x150`.
  - Keep Cocos SpriteFrame rects at full `150x150` with `trimX=0` and `trimY=0`.
- Monster `client/pak/monster/0.zip`
  - The sheet is `600x480`, but it is laid out as `10 x 8` cells.
  - Only the first five rows contain monster directions; the last three rows are blank.
  - `0.img`: idle, cell `60x60`.
  - `1.img`: walk, cell `60x60`.
  - `2.img`: attack, cell `60x60`.
  - Keep Cocos SpriteFrame rects at full `60x60` with `trimX=0`, `trimY=0`.
  - Direction rows:
    - row `0` -> `d0`: back / up.
    - row `1` -> `d1`: right-up.
    - row `2` -> `d2`: right.
    - row `3` -> `d3`: right-down.
    - row `4` -> `d4`: front / down.
    - `d5..d7` are mirrored from rows `3..1`.
- Full monster import `client/pak/monster/0.zip..57.zip`
  - Small monsters: `600x480`, cell `60x60`, frame counts `10/10/10`.
  - Large monsters: height `1200`, cell `150x150`; derive action frame count from `sheetWidth / 150`.
  - Known large frame counts:
    - Most large monsters: idle/walk/attack `4/6/8`.
    - Monster `57`: idle/walk/attack `5/4/4`.
  - Keep using the same direction mapping as normal monsters: rows `0..4` direct, `d5..d7` mirrored from `3..1`.
  - Catalog files:
    - `cocos-remake/assets/resources/monsters/monster_catalog.json`
    - `MONSTER_CATALOG.md`
    - `MONSTER_CATALOG.png`
- Level-up effect `client/pak/effect.zip:image/effect/6.img`
  - Converted sheet size: `920x128`.
  - Layout: `10 x 1`, cell `92x128`.
  - Export path: `assets/resources/effects/level_up/level_up_NN.png`.
  - Runtime load path: `effects/level_up/level_up_NN/spriteFrame`.
  - Treat black as transparent for effect/skill frames. Regenerate alpha from brightness instead of only deleting pure black pixels, because old effects often keep dark antialias pixels around the glow.
- Monster death blood stain
  - Source candidate: `_tmp_effect_preview/11.png`, from `effect/11.img`.
  - Do not import the whole effect as a skill animation for monster death.
  - Use the middle largest red stain only, cropped to `38x24`.
  - Export path: `assets/resources/effects/blood_stain/blood_stain.png`.
  - Runtime load path: `effects/blood_stain/blood_stain/spriteFrame`.
  - Spawn at the dead monster's foot position and destroy after `2` seconds.
- Damage numbers `client/pak/effect.zip:image/effect/num.img`
  - Converted sheet size: `281x102`.
  - Export path: `assets/resources/effects/damage_text`.
  - Runtime load path: `effects/damage_text/<name>/spriteFrame`.
  - Keep the source alpha and preserve black glyph outlines. Do not delete dark pixels by threshold.
  - Row mapping:
    - row 1: `damage_0..9`, `damage_minus`.
    - row 2: `heal_0..9`, `heal_plus`.
    - row 3: `special_0..9`, `special_minus`.
    - row 4: `text_hit_empty`, `text_lost`, `text_block`, `text_crit`.
    - row 5: `mp_0..9`, `mp_plus`.
  - For normal damage, compose digits from row 1. Example: damage `789` uses `damage_7`, `damage_8`, `damage_9`.
  - Prefix normal damage with `damage_minus`. Prefix healing with `heal_plus`.

## Do Not Repeat

- Do not force every frame into the first frame's trimmed size.
- Do not use Cocos auto-trim for animated actors. It changes the center/offset per frame and makes walking look like it moves forward and backward.
- Do not use `Sprite.SizeMode.RAW` as a workaround while the SpriteFrame is still auto-trimmed. Fix the SpriteFrame meta to the full cell first.
- Do not assume all eight rows contain art. Check alpha bounds; blank lower rows usually mean mirror directions are required.
- Do not auto-trim role, monster, or NPC frames unless the old client anchor has already been reproduced another way.
- Do not import downloaded humanoid PNGs directly if their source canvas sizes differ. Normalize each frame to a shared canvas and align by foot position first.
- Do not divide a sheet only by visible rows. `600x480` monster sheets look like five rows, but the real grid is eight rows of `60px` height.
- Do not import skill/effect sheets with opaque black background. For effects, black is usually the transparent key color; convert black/near-black to alpha before Cocos import.
- Do not render combat numbers with Cocos text if the old-client bitmap digits exist. Compose the imported digit sprites so future crit/heal/MP/miss rules share one asset path.
- Do not run black-to-alpha threshold cleanup on `num.img`; it removes the digit outline. Use the source PNG alpha as-is.

## Normal Monster Runtime Defaults

- Move speed: `50`.
- Wander step: about one old monster cell, currently `60` world units.
- Wander behavior: walk one short step, stop briefly, then choose the next short step.
- Chase behavior: only chase when the player enters the monster trigger range.
- Attack behavior: only attack at close range; normal monsters do not actively attack from far away.
