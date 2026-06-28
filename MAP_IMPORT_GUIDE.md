# Map Import Guide

## Source

- Old map structure: `无双暗影世界/client/data/map/*.map`
- Old movement collision: `无双暗影世界/client/data/map/*.blk`
- Old map tile images: `无双暗影世界/client/pak/mapimg/*.zip`

## Tool

Run from the repo root:

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File .\tools\build-all-map-assets.ps1
```

Useful targeted run:

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File .\tools\build-all-map-assets.ps1 -MapIds 0
```

## Output

- Full map preview: `cocos-remake/assets/resources/maps/map_ID_preview.png`
- Actor occlusion overlay: `cocos-remake/assets/resources/maps/map_ID_occlusion.png`
- Collision grid when source `.blk` exists: `cocos-remake/assets/resources/maps/map_ID_block.json`
- Runtime lookup catalog: `cocos-remake/assets/resources/maps/map_catalog.json`
- Human thumbnails: `MAP_CATALOG/map_XXX.jpg`
- Human browser index: `MAP_CATALOG/index.html`

## Rules

- `.map` is rendered at `0.5` source scale, matching current `map_0` output.
- Cocos map node scale remains `1.5`.
- Occlusion is generated from old object layers on a transparent canvas.
- Only objects with mapped layer `>= 3` go into occlusion. Low ground props such as stones stay in the preview image only, otherwise they render above actors.
- `.blk` value `127` is passable; other values are blocked.
- If a map has no `.blk`, do not fake collision. Keep it preview-only and record it in `MAP_CATALOG.md`.
- Generated `.json` and `.meta` files must be UTF-8 without BOM. Cocos Creator has already failed on BOM/invalid JSON in generated metas.
