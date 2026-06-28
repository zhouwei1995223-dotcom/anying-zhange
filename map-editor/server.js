const fs = require('fs');
const http = require('http');
const path = require('path');
const crypto = require('crypto');

const root = path.resolve(__dirname, '..');
const editorDir = __dirname;
const tileDir = path.join(root, 'tmp_map_tiles', 'shared_png');
const patchDir = path.join(root, 'cocos-remake', 'assets', 'resources', 'maps', 'patches');
const objectDir = path.join(root, 'cocos-remake', 'assets', 'resources', 'map_objects');
const port = Number(process.env.PORT || 5174);

const mime = {
  '.html': 'text/html; charset=utf-8',
  '.js': 'text/javascript; charset=utf-8',
  '.css': 'text/css; charset=utf-8',
  '.json': 'application/json; charset=utf-8',
  '.png': 'image/png',
  '.jpg': 'image/jpeg',
  '.jpeg': 'image/jpeg',
};

function send(res, status, body, type = 'text/plain; charset=utf-8') {
  res.writeHead(status, { 'Content-Type': type, 'Cache-Control': 'no-store' });
  res.end(body);
}

function pngSize(file) {
  const buf = fs.readFileSync(file);
  if (buf.length < 24 || buf.toString('ascii', 1, 4) !== 'PNG') return null;
  return { width: buf.readUInt32BE(16), height: buf.readUInt32BE(20) };
}

function patchPath(mapId) {
  return path.join(patchDir, `map_${mapId}_patch.json`);
}

function jsonMetaPath(file) {
  return `${file}.meta`;
}

function ensureJsonMeta(file) {
  const meta = jsonMetaPath(file);
  if (fs.existsSync(meta)) return;
  const data = {
    ver: '2.0.1',
    importer: 'json',
    imported: true,
    uuid: crypto.randomUUID(),
    files: ['.json'],
    subMetas: {},
    userData: {},
  };
  fs.writeFileSync(meta, JSON.stringify(data, null, 2));
}

function copyUsedObjects(patch) {
  fs.mkdirSync(objectDir, { recursive: true });
  for (const obj of patch.objects || []) {
    if (!Number.isFinite(Number(obj.assetId))) continue;
    const id = Number(obj.assetId);
    const src = path.join(tileDir, `${id}.png`);
    const dst = path.join(objectDir, `tile_${id}.png`);
    if (fs.existsSync(src) && !fs.existsSync(dst)) fs.copyFileSync(src, dst);
  }
}

function readBody(req) {
  return new Promise((resolve, reject) => {
    let body = '';
    req.on('data', (chunk) => {
      body += chunk;
      if (body.length > 5_000_000) reject(new Error('body too large'));
    });
    req.on('end', () => resolve(body));
    req.on('error', reject);
  });
}

function serveFile(res, file) {
  if (!file.startsWith(root) && !file.startsWith(editorDir)) {
    send(res, 403, 'Forbidden');
    return;
  }
  fs.readFile(file, (err, data) => {
    if (err) {
      send(res, err.code === 'ENOENT' ? 404 : 500, err.message);
      return;
    }
    send(res, 200, data, mime[path.extname(file).toLowerCase()] || 'application/octet-stream');
  });
}

const server = http.createServer(async (req, res) => {
  try {
    const url = new URL(req.url, `http://127.0.0.1:${port}`);

    if (url.pathname === '/api/assets') {
      const files = fs.readdirSync(tileDir).filter((name) => name.endsWith('.png'));
      const assets = files.map((name) => {
        const file = path.join(tileDir, name);
        const size = pngSize(file) || { width: 0, height: 0 };
        const id = Number(path.basename(name, '.png'));
        return { id, name, url: `/tmp_map_tiles/shared_png/${name}`, width: size.width, height: size.height };
      }).filter((item) => Number.isFinite(item.id)).sort((a, b) => a.id - b.id);
      send(res, 200, JSON.stringify(assets), mime['.json']);
      return;
    }

    const patchMatch = url.pathname.match(/^\/api\/patch\/(\d+)$/);
    if (patchMatch && req.method === 'GET') {
      const file = patchPath(Number(patchMatch[1]));
      if (!fs.existsSync(file)) {
        send(res, 200, JSON.stringify({ version: 1, mapId: Number(patchMatch[1]), objects: [] }), mime['.json']);
        return;
      }
      serveFile(res, file);
      return;
    }

    if (patchMatch && req.method === 'POST') {
      const mapId = Number(patchMatch[1]);
      const patch = JSON.parse(await readBody(req));
      patch.version = 1;
      patch.mapId = mapId;
      patch.updatedAt = new Date().toISOString();
      fs.mkdirSync(patchDir, { recursive: true });
      copyUsedObjects(patch);
      const file = patchPath(mapId);
      fs.writeFileSync(file, JSON.stringify(patch, null, 2));
      ensureJsonMeta(file);
      send(res, 200, JSON.stringify({ ok: true, file }), mime['.json']);
      return;
    }

    let file;
    if (url.pathname === '/' || url.pathname === '/map-editor') {
      res.writeHead(302, { Location: '/map-editor/' });
      res.end();
      return;
    }
    if (url.pathname.startsWith('/map-editor/')) {
      const rel = decodeURIComponent(url.pathname.slice('/map-editor/'.length)) || 'index.html';
      file = path.join(editorDir, rel);
    } else {
      file = path.join(root, decodeURIComponent(url.pathname));
    }
    serveFile(res, path.normalize(file));
  } catch (err) {
    send(res, 500, err.stack || err.message);
  }
});

server.listen(port, '127.0.0.1', () => {
  console.log(`Map editor: http://127.0.0.1:${port}/map-editor/`);
});
