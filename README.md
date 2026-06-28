# Anying Web Tools

Local tools for processing assets from the old `无双暗影世界` bundle.

## Run .img Tool

Use the running local server:

```text
http://127.0.0.1:5173/img-tool/
```

Or serve the folder again:

```ps1
cd D:\anyingzhange
python -m http.server 5173
```

The tool can:

- Upload `.img`, PNG, JPG, or GIF.
- Decode old `.img` into a canvas PNG.
- Configure frame width, height, offset, gaps, rows, columns, and FPS.
- Preview the cut grid.
- Preview animation frames.
- Export full PNG, sequence PNG files, and JSON config.

## Run Old MVP

Open:

```text
web-mvp/index.html
```

Or serve the folder:

```ps1
cd D:\anyingzhange
python -m http.server 5173
```

Then visit:

```text
http://127.0.0.1:5173/web-mvp/
```

## Run Map Editor

Double-click:

```text
start-map-editor.bat
```

Then open:

```text
http://127.0.0.1:5174/map-editor/
```

The editor can load map previews, place old map image assets, edit object collision rectangles, and save `map_ID_patch.json` under Cocos `assets/resources/maps/patches`.

## Current Scope

- Local browser asset processing.
- `.img` decoding first pass.
- No old Java server.
- No Cocos, gameplay, login, registration, recharge, or backend yet.

## Tooling Notes

- Use `npm.cmd` instead of `npm` in PowerShell.
- Cocos Creator is not installed yet.
- `ponytail` is installed, but Codex should be restarted before it appears as a normal skill.
