const $ = (id) => document.getElementById(id);

const canvas = $('canvas');
const ctx = canvas.getContext('2d');
const imageCache = new Map();

let mapId = 3;
let mapImage = null;
let occlusionImage = null;
let blockMap = null;
let assets = [];
let selectedAsset = null;
let selectedObject = null;
let mode = 'select';
let patch = { version: 1, mapId, objects: [] };
let zoom = 0.25;
let panX = 0;
let panY = 0;
let dragging = null;
let panning = null;
let viewFitted = false;

function setStatus(text) {
  $('status').textContent = text;
  clearTimeout(setStatus.timer);
  setStatus.timer = setTimeout(() => $('status').textContent = '', 3000);
}

function image(url) {
  if (imageCache.has(url)) return imageCache.get(url);
  const img = new Image();
  img.src = `${url}?v=${Date.now()}`;
  imageCache.set(url, img);
  img.onload = draw;
  return img;
}

function screenToMap(x, y) {
  return { x: (x - panX) / zoom, y: (y - panY) / zoom };
}

function resize() {
  const dpr = window.devicePixelRatio || 1;
  const rect = canvas.getBoundingClientRect();
  canvas.width = Math.max(1, Math.floor(rect.width * dpr));
  canvas.height = Math.max(1, Math.floor(rect.height * dpr));
  draw();
}

function fitMapToViewport() {
  if (!mapImage) return;
  const rect = canvas.getBoundingClientRect();
  zoom = Math.min(rect.width / mapImage.naturalWidth, rect.height / mapImage.naturalHeight) * 0.92;
  zoom = Math.max(0.08, Math.min(1, zoom));
  panX = Math.round((rect.width - mapImage.naturalWidth * zoom) / 2);
  panY = Math.round((rect.height - mapImage.naturalHeight * zoom) / 2);
  viewFitted = true;
}

function draw() {
  const dpr = window.devicePixelRatio || 1;
  const rect = canvas.getBoundingClientRect();
  ctx.setTransform(dpr, 0, 0, dpr, 0, 0);
  ctx.clearRect(0, 0, rect.width, rect.height);
  if (!mapImage) {
    ctx.fillStyle = '#8090a0';
    ctx.fillText('map not loaded', 24, 32);
    return;
  }

  ctx.save();
  ctx.translate(panX, panY);
  ctx.scale(zoom, zoom);
  ctx.imageSmoothingEnabled = false;
  ctx.drawImage(mapImage, 0, 0, mapImage.naturalWidth, mapImage.naturalHeight);

  if ($('showOcclusion').checked && occlusionImage) {
    ctx.globalAlpha = 0.45;
    ctx.drawImage(occlusionImage, 0, 0, occlusionImage.naturalWidth, occlusionImage.naturalHeight);
    ctx.globalAlpha = 1;
  }

  for (const obj of patch.objects) drawObject(obj);
  if ($('showCollision').checked) drawCollision();
  ctx.restore();
}

function drawObject(obj) {
  const asset = assets.find((item) => item.id === obj.assetId);
  if (!asset) return;
  const img = image(asset.url);
  const w = asset.width * obj.scale;
  const h = asset.height * obj.scale;
  if (img.complete) ctx.drawImage(img, obj.x, obj.y, w, h);

  if (obj === selectedObject) {
    ctx.strokeStyle = '#55b7e8';
    ctx.lineWidth = 2 / zoom;
    ctx.strokeRect(obj.x, obj.y, w, h);
  }

  if ($('showCollision').checked && obj.collision) {
    ctx.strokeStyle = obj === selectedObject ? '#ffdc5e' : '#ff9b3d';
    ctx.lineWidth = 2 / zoom;
    ctx.strokeRect(obj.x + obj.collision.x, obj.y + obj.collision.y, obj.collision.w, obj.collision.h);
  }
}

function drawCollision() {
  if (!blockMap) return;
  const cw = blockMap.mapImageWidth / blockMap.width;
  const ch = blockMap.mapImageHeight / blockMap.height;
  ctx.fillStyle = 'rgba(255, 50, 40, 0.18)';
  for (let y = 0; y < blockMap.height; y++) {
    for (let x = 0; x < blockMap.width; x++) {
      if (blockMap.data[y * blockMap.width + x] !== '1') ctx.fillRect(x * cw, y * ch, cw, ch);
    }
  }
}

function setMode(next) {
  mode = next;
  $('modeSelect').classList.toggle('active', mode === 'select');
  $('modePlace').classList.toggle('active', mode === 'place');
}

function objectAt(mx, my) {
  for (let i = patch.objects.length - 1; i >= 0; i--) {
    const obj = patch.objects[i];
    const asset = assets.find((item) => item.id === obj.assetId);
    if (!asset) continue;
    const w = asset.width * obj.scale;
    const h = asset.height * obj.scale;
    if (mx >= obj.x && my >= obj.y && mx <= obj.x + w && my <= obj.y + h) return obj;
  }
  return null;
}

function placeObject(mx, my) {
  if (!selectedAsset) return;
  const scale = 1;
  const w = selectedAsset.width * scale;
  const h = selectedAsset.height * scale;
  const cw = Math.max(18, Math.round(w * 0.45));
  const ch = Math.max(14, Math.round(h * 0.22));
  const obj = {
    id: `obj_${Date.now().toString(36)}`,
    assetId: selectedAsset.id,
    resource: `map_objects/tile_${selectedAsset.id}`,
    x: Math.round(mx - w / 2),
    y: Math.round(my - h),
    scale,
    width: selectedAsset.width,
    height: selectedAsset.height,
    collision: { x: Math.round((w - cw) / 2), y: Math.round(h - ch), w: cw, h: ch },
    occlusion: true,
  };
  patch.objects.push(obj);
  selectedObject = obj;
  updateInspector();
  draw();
}

function updateInspector() {
  const has = !!selectedObject;
  $('emptyInspector').classList.toggle('hidden', has);
  $('objectForm').classList.toggle('hidden', !has);
  if (!has) return;
  $('objAssetId').value = selectedObject.assetId;
  $('objX').value = Math.round(selectedObject.x);
  $('objY').value = Math.round(selectedObject.y);
  $('objScale').value = selectedObject.scale;
  $('objOcclusion').checked = !!selectedObject.occlusion;
  $('colX').value = Math.round(selectedObject.collision.x);
  $('colY').value = Math.round(selectedObject.collision.y);
  $('colW').value = Math.round(selectedObject.collision.w);
  $('colH').value = Math.round(selectedObject.collision.h);
}

function readInspector() {
  if (!selectedObject) return;
  selectedObject.x = Number($('objX').value) || 0;
  selectedObject.y = Number($('objY').value) || 0;
  selectedObject.scale = Math.max(0.1, Number($('objScale').value) || 1);
  selectedObject.occlusion = $('objOcclusion').checked;
  selectedObject.collision = {
    x: Number($('colX').value) || 0,
    y: Number($('colY').value) || 0,
    w: Math.max(0, Number($('colW').value) || 0),
    h: Math.max(0, Number($('colH').value) || 0),
  };
  draw();
}

function renderAssets() {
  const q = $('assetSearch').value.trim();
  const largeOnly = $('largeOnly').checked;
  const list = assets
    .filter((asset) => !q || String(asset.id).includes(q))
    .filter((asset) => !largeOnly || asset.height >= 80 || asset.width >= 80)
    .slice(0, 220);
  $('assetList').innerHTML = '';
  for (const asset of list) {
    const item = document.createElement('button');
    item.className = `asset${selectedAsset?.id === asset.id ? ' selected' : ''}`;
    item.innerHTML = `<img loading="lazy" src="${asset.url}" alt=""><span>#${asset.id} ${asset.width}x${asset.height}</span>`;
    item.onclick = () => {
      selectedAsset = asset;
      setMode('place');
      renderAssets();
    };
    $('assetList').appendChild(item);
  }
}

async function loadAssets() {
  assets = await fetch('/api/assets').then((res) => res.json());
  renderAssets();
}

async function loadMap() {
  mapId = Number($('mapId').value) || 0;
  const previewUrl = `/cocos-remake/assets/resources/maps/map_${mapId}_preview.png`;
  const occlusionUrl = `/cocos-remake/assets/resources/maps/map_${mapId}_occlusion.png`;
  const [map, occ, block, savedPatch] = await Promise.all([
    loadImage(previewUrl),
    loadImage(occlusionUrl).catch(() => null),
    fetch(`/cocos-remake/assets/resources/maps/map_${mapId}_block.json`).then((res) => res.ok ? res.json() : null),
    fetch(`/api/patch/${mapId}`).then((res) => res.json()),
  ]);
  mapImage = map;
  occlusionImage = occ;
  blockMap = block;
  patch = savedPatch?.objects ? savedPatch : { version: 1, mapId, objects: [] };
  viewFitted = false;
  fitMapToViewport();
  selectedObject = null;
  updateInspector();
  draw();
  setStatus(`loaded map ${mapId}: ${mapImage.naturalWidth}x${mapImage.naturalHeight}`);
}

function loadImage(url) {
  return new Promise((resolve, reject) => {
    const img = new Image();
    img.onload = () => resolve(img);
    img.onerror = () => reject(new Error(`image load failed: ${url}`));
    img.src = `${url}?v=${Date.now()}`;
  });
}

async function savePatch() {
  const res = await fetch(`/api/patch/${mapId}`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(patch),
  });
  if (!res.ok) throw new Error(await res.text());
  setStatus('saved patch and synced assets');
}

function exportPatch() {
  const blob = new Blob([JSON.stringify(patch, null, 2)], { type: 'application/json' });
  const a = document.createElement('a');
  a.href = URL.createObjectURL(blob);
  a.download = `map_${mapId}_patch.json`;
  a.click();
  URL.revokeObjectURL(a.href);
}

canvas.addEventListener('pointerdown', (event) => {
  const pos = screenToMap(event.offsetX, event.offsetY);
  if (event.button === 1 || event.shiftKey) {
    panning = { x: event.clientX, y: event.clientY, panX, panY };
    return;
  }
  if (mode === 'place') {
    placeObject(pos.x, pos.y);
    return;
  }
  const obj = objectAt(pos.x, pos.y);
  selectedObject = obj;
  updateInspector();
  if (obj) dragging = { obj, dx: pos.x - obj.x, dy: pos.y - obj.y };
  draw();
});

canvas.addEventListener('pointermove', (event) => {
  if (panning) {
    panX = panning.panX + event.clientX - panning.x;
    panY = panning.panY + event.clientY - panning.y;
    draw();
    return;
  }
  if (!dragging) return;
  const pos = screenToMap(event.offsetX, event.offsetY);
  dragging.obj.x = Math.round(pos.x - dragging.dx);
  dragging.obj.y = Math.round(pos.y - dragging.dy);
  updateInspector();
  draw();
});

window.addEventListener('pointerup', () => {
  dragging = null;
  panning = null;
});

canvas.addEventListener('wheel', (event) => {
  event.preventDefault();
  const before = screenToMap(event.offsetX, event.offsetY);
  zoom = Math.max(0.08, Math.min(3, zoom * (event.deltaY < 0 ? 1.12 : 0.88)));
  panX = event.offsetX - before.x * zoom;
  panY = event.offsetY - before.y * zoom;
  draw();
}, { passive: false });

$('modeSelect').onclick = () => setMode('select');
$('modePlace').onclick = () => setMode('place');
$('loadMap').onclick = () => {
  viewFitted = false;
  loadMap();
};
$('resetView').onclick = () => {
  viewFitted = false;
  fitMapToViewport();
  selectedObject = null;
  updateInspector();
  draw();
  if (mapImage) setStatus(`reset view: ${mapImage.naturalWidth}x${mapImage.naturalHeight}`);
};
$('showCollision').onchange = draw;
$('showOcclusion').onchange = draw;
$('assetSearch').oninput = renderAssets;
$('largeOnly').onchange = renderAssets;
$('savePatch').onclick = () => savePatch().catch((err) => setStatus(err.message));
$('exportPatch').onclick = exportPatch;
$('deleteObject').onclick = () => {
  if (!selectedObject) return;
  patch.objects = patch.objects.filter((item) => item !== selectedObject);
  selectedObject = null;
  updateInspector();
  draw();
};

for (const id of ['objX', 'objY', 'objScale', 'objOcclusion', 'colX', 'colY', 'colW', 'colH']) {
  $(id).addEventListener('input', readInspector);
}

window.addEventListener('resize', () => {
  viewFitted = false;
  resize();
  fitMapToViewport();
  draw();
});

resize();
loadAssets().then(loadMap).catch((err) => setStatus(err.message));
