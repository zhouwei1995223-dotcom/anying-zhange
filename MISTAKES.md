# Mistakes

## 2026-06-29 Do Not Switch Monster Frames To RAW Blindly

### What Happened

To reduce monster animation jitter, actor sprites were changed to `Sprite.SizeMode.RAW` and sized from the original frame.

### Why It Was Wrong

Old monster sheets include large fixed cells. RAW rendered that full cell and made monsters visually much larger, while the damage number fix did not require this change.

### Current Rule

Keep monsters on the current `TRIMMED + applyFrame()` path unless a proper foot-anchor/cell renderer is built deliberately. For now, fix damage text and actor frame sizing separately.

## 2026-06-27 Tuning Retreat Instead Of Pathing

### What Happened

Actors still got stuck near walls, trees, water, and carts, so the fallback logic kept adding retreat, bypass, and local unstuck movement.

### Why It Was Wrong

Those changes only helped the actor leave the current bad spot. They did not make the actor commit to a real route around the obstacle, so it could walk back to the same edge and repeat the problem.

### Current Rule

When an actor repeatedly sticks near map obstacles, fix the shared `.blk` pathing first. Use a cached full A* path as the normal movement route, and keep retreat/bypass only as a last-frame rescue.

## 2026-06-27 Do Not Over-Fix The Current Hero Animation Yet

### What Happened

The current hero animation still has visible imperfections, but the immediate request is to connect walk and attack animations first.

### Why It Matters

Fixing direction mapping, per-frame anchors, and exact original-client scale at the same time would mix several unknowns and make the next visual mismatch harder to isolate.

### Current Rule

For this pass, only wire the available action frames into Cocos. Treat direction rows, anchor offsets, and exact character scale as the next focused task.

## 2026-06-27 Forced Idle Size Was Wrong For Action Frames

### What Happened

The hero was forced to `22x54` after every frame swap to stop the first idle animation from growing.

### Why It Was Wrong

`22x54` is only the trimmed visible size of `idle_00`. The old client uses fixed `150x150` cells, and walk/attack frames have wider or taller visible bounds.

### Current Rule

Do not use one trimmed frame size for all actions. Also do not use Cocos `RAW 150x150` directly, because it visually enlarges trimmed SpriteFrames. Use `TRIMMED` and update the node size from the current frame rect.

## 2026-06-28 Letting Hero Frames Stay Auto-Trimmed Too Long

### What Happened

After fixing the first scale problem, hero frames were left as Cocos auto-trimmed SpriteFrames and runtime code resized the node from each frame rect.

### Why It Was Wrong

That made each frame use a different visual center. It looked acceptable when standing or moving diagonally, but sideways walk exposed the anchor jitter as a forward/backward wobble.

### Current Rule

For old animated actors, preserve the fixed source cell in the SpriteFrame meta first. For hero `00`, that means full `150x150` rects with zero trim and zero offset. Do not use auto-trim unless a deliberate foot-anchor renderer exists.

## Treating `.img` Decode As Simpler Than It Is

### What Happened

The first browser decoder read enough header data to produce a `600x1200` canvas, so it looked close, but it did not reproduce the old client rendering rules.

### Fix

Compare against a known-good output before trusting the browser decoder. For now, route `.img` conversion through the old Java `ImgPngTool.class + client.zip` converter and keep the JS decoder only as a fallback.

## Hardcoding Chinese Paths In Python

### What Happened

Python received `D:\anyingzhange\无双暗影世界\...` as `??????` when the script was passed through PowerShell in this environment.

### Why

The inline script path text was damaged by console encoding before Python opened it.

### Fix

Enumerate from ASCII parent paths instead:

```py
from pathlib import Path
root = next(Path(r"D:\anyingzhange").iterdir())
client = root / "client"
```

### Rule Next Time

For this project, avoid hardcoded Chinese path literals in inline scripts. Discover the folder from `D:\anyingzhange`.

## Assuming `.img` Might Be Renamed PNG

### What Happened

The first guess was that `.img` may be normal image data with a different extension.

### Why

Some old games do that, but this one does not.

### Fix

Inspect headers and old client bytecode. `.img` is a custom resource format loaded through `a.b.v` and concrete image classes.

### Rule Next Time

Treat `.img` as custom packed frame data until the decoder proves otherwise.

## Looking For Cocos CLI Too Late

### What Happened

The first planning pass assumed Cocos Creator would be available.

### Why

Cocos Creator is usually installed as an editor, not as a global CLI.

### Fix

Check for Cocos first. If missing, build a small web proof and keep the assets Cocos-ready.

### Rule Next Time

Before promising a Cocos project build, verify the editor/CLI path.

## Reading `.img` Type As Two Bytes

### What Happened

The first browser decoder read `.img` as `4 byte length + 2 byte type + width + height`.

### Why

The byte dump was misleading until compared with the old Java loader.

### Fix

The correct first-pass header is:

```text
uint32 payloadLength
uint8 type
uint16 width
uint16 height
```

### Rule Next Time

When a bytecode loader exists, trust the loader over visual hex guesses.

## Assuming First Directory Is Old Game Root

### What Happened

A sample extraction script used the first child directory under `D:\anyingzhange`, which became `img-tool` after new files were created.

### Fix

Find the directory that contains `client/pak`.

### Rule Next Time

Discover old game root by marker files, not directory order.

## Treating Whole Sheet Preview As Useful

### What Happened

Hero `.img` files such as `hero/00/0.img` decoded correctly, but the visible sprite lived around `y=862` inside a `600x1200` sheet. The preview showed the top of the sheet, so it looked black.

### Fix

Detect the non-transparent content bounds after decoding, auto-fill grid origin/rows/columns from that region, and show only the selected cut range in the preview.

### Rule Next Time

For old packed sprites, decode success must be checked with content bounds, not by looking at the top-left of the full canvas.

## Using Map Tile Ids Without The Old Client Offset

### What Happened

The first generated real map used the `.map` tile value directly as `image/map/<id>.img`.

### Why

The old client bytecode loads and draws map tiles with a 1-based map value: stored tile `N` points to `image/map/(N - 1).img`.

### Fix

`tools/build-map-preview.ps1` now applies `$tile - 1` for base tiles and object layers.

### Rule Next Time

When reproducing old packed resources, verify the loader's indexing rule before composing images.

## Hardcoding Non-ASCII Paths In PowerShell Scripts

### What Happened

`tools/build-map-preview.ps1` initially hardcoded the old client folder and converter folder with Chinese path segments. Windows PowerShell 5.1 read the script with the wrong encoding and turned those paths into mojibake.

### Fix

The script now discovers:

- the old client by looking for `client/data/map/<id>.map` under `D:\anyingzhange`
- the converter by looking for `D:\*\img_png_tool\ImgPngTool.class`

### Rule Next Time

Keep reusable scripts ASCII-only when they need to run under Windows PowerShell 5.1; discover Chinese-named folders from ASCII parent paths.

## Hand-Written Cocos UUIDs Became Stale

### What Happened

The first hero animation used manually assigned SpriteFrame UUIDs. After Cocos Creator reimported the PNG files, it generated different UUIDs, leaving the scene with broken references.

### Fix

Read the actual UUIDs from the current `.png.meta` files before wiring scene or animation references.

### Rule Next Time

For Cocos assets, let Creator own UUID generation whenever possible. If a manual scene edit is needed, pull UUIDs from the current meta files, not from earlier generated values.

## Changing Sprite Scale To Fix Bad Frame Slicing

### What Happened

When old role animations looked wrong, the tempting fix was to tune node scale, camera distance, or a single fixed UITransform size.

### Fix

Check the source sheet first, slice fixed cells, and let each imported SpriteFrame use its own trimmed rect at runtime.

### Rule Next Time

Animation scale bugs are usually import/display bugs, not camera bugs. Verify cell size, alpha bounds, direction rows, and Cocos `SizeMode` before tuning gameplay scale.

## Auto-Trimming Monster Frames

### What Happened

Monster frames were first inferred from visible rows as `60x96`, which pulled the next row into the same frame. The next attempt used `60x48`, which clipped each monster. Their Cocos SpriteFrame metas were also auto-trimmed per frame.

### Fix

Use the real old-client grid: `600x480` means `10 x 8`, so the monster cell is `60x60`. Keep monster SpriteFrames as the full `60x60` cell with `trimX=0` and `trimY=0`.

### Rule Next Time

For monsters, NPCs, and effects that rely on old-client cell anchors, infer the full grid first, not just visible rows. Preserve the fixed cell first. Only trim after proving the anchor math is correct.

## Picking Monster Wander Direction From The Player

### What Happened

Monster wandering used the direction from monster to player to choose walk frames, even when the monster was walking somewhere else.

### Fix

Use the player direction only for chase and attack. For normal wandering, choose the animation direction from the monster's current wander target.

### Rule Next Time

Animation direction must come from the actual movement vector for that state.

## Picking Walk Direction From The Final Target During Pathing

### What Happened

After A* pathing was added, the hero could move toward a path waypoint while still playing the animation chosen from the final monster position.

### Fix

Record the real movement delta inside `moveToward`, then use that delta for hero and monster walk clips. Use final target direction only for attack facing.

### Rule Next Time

For any state that physically moves an actor, choose the animation from the accepted movement delta after collision/pathing, not before movement.

## Guessing The Level-Up Effect From A Montage

### What Happened

I initially picked a plausible blue lightning effect, then checked `effect/11.img` after a screenshot, but the confirmed upgrade effect was `effect/6.img`.

### Fix

Use `effect/6.img`, a `920x128` sheet sliced into ten `92x128` frames.

### Rule Next Time

Do not wire old effect assets by visual guess alone. Generate the montage, ask/confirm the exact id when uncertain, then import the confirmed fixed grid.

## Treating Effect Black Like Actor Transparency

### What Happened

The first cleanup only removed very dark pixels from the converted level-up frames, but Cocos still showed black strips in the glow.

### Fix

Regenerate the frames from the source sheet and compute alpha from brightness, so black/near-black becomes transparent and golden glow remains visible.

### Rule Next Time

Role/monster frames preserve fixed cells. Skill/effect frames need chroma-key cleanup first: black means transparent.
