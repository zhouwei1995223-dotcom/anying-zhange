const fs = require("fs");
const path = require("path");
const zlib = require("zlib");

const root = process.cwd();
const oldRoot = fs.readdirSync(root).map((n) => path.join(root, n)).find((p) => fs.existsSync(path.join(p, "client", "pak")));
if (!oldRoot) throw new Error("old client folder not found");

function walk(dir, out = []) {
  for (const name of fs.readdirSync(dir)) {
    const p = path.join(dir, name);
    fs.statSync(p).isDirectory() ? walk(p, out) : out.push(p);
  }
  return out;
}

function extCount(files) {
  return files.reduce((m, f) => ((m[path.extname(f) || "(none)"] = (m[path.extname(f) || "(none)"] || 0) + 1), m), {});
}

function imgHeader(file) {
  const b = fs.readFileSync(file);
  return {
    file: path.relative(root, file),
    bytes: b.length,
    payloadBytes: b.readUInt32LE(0),
    widthGuess: b.readUInt16BE(4),
    heightGuess: b.readUInt16BE(6),
    typeGuess: b[8] > 3 ? b[8] >> 4 : b[8],
  };
}

const client = path.join(oldRoot, "client");
const direct = walk(path.join(client, "image")).filter((f) => /\.(png|jpe?g|gif)$/i.test(f));
const maps = walk(path.join(client, "data", "map"));
const packed = walk(path.join(client, "pak")).filter((f) => /\.zip$/i.test(f));

const manifest = {
  oldRoot: path.relative(root, oldRoot),
  directImages: extCount(direct),
  mapData: extCount(maps),
  packedZipCount: packed.length,
  samples: direct.slice(0, 8).map((f) => path.relative(root, f)),
};

fs.mkdirSync(path.join(root, "web-mvp", "public"), { recursive: true });
fs.writeFileSync(path.join(root, "web-mvp", "public", "asset-manifest.json"), JSON.stringify(manifest, null, 2));
console.log(JSON.stringify(manifest, null, 2));

// ponytail: ZIP entry parsing waits until the real decoder is needed.
try {
  const ui = path.join(client, "image", "ui", "ui.img");
  if (fs.existsSync(ui)) console.log(JSON.stringify(imgHeader(ui), null, 2));
} catch {}
