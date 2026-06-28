const $ = (id) => document.getElementById(id);
const sheet = $("sheet");
const sheetCtx = sheet.getContext("2d");
const anim = $("anim");
const animCtx = anim.getContext("2d");
const src = document.createElement("canvas");
const srcCtx = src.getContext("2d");
let sourceName = "asset";
let frames = [];
let frameIndex = 0;

const cfgKeys = ["fw", "fh", "ox", "oy", "gx", "gy", "cols", "rows", "fps"];
const cfg = () => Object.fromEntries(cfgKeys.map((k) => [k, Number($(k).value) || 0]));

function setInfo(text) { $("info").textContent = text; }

function download(name, url) {
  const a = document.createElement("a");
  a.download = name;
  a.href = url;
  a.click();
}

function sourceToPngUrl() {
  return src.toDataURL("image/png");
}

async function loadImage(blob) {
  const img = new Image();
  img.src = URL.createObjectURL(blob);
  await img.decode();
  src.width = img.naturalWidth;
  src.height = img.naturalHeight;
  srcCtx.drawImage(img, 0, 0);
  URL.revokeObjectURL(img.src);
}

async function loadImgFile(file) {
  const res = await fetch("api/img2png", { method: "POST", body: file });
  if (!res.ok) throw new Error(await res.text());
  await loadImage(await res.blob());
  setInfo(`${file.name}\nJava converter\n${src.width}x${src.height}`);
}

function applyGrid() {
  const c = cfg();
  frames = [];
  sheet.width = Math.max(1, c.cols * c.fw + Math.max(0, c.cols - 1) * c.gx);
  sheet.height = Math.max(1, c.rows * c.fh + Math.max(0, c.rows - 1) * c.gy);
  sheetCtx.clearRect(0, 0, sheet.width, sheet.height);
  sheetCtx.drawImage(src, c.ox, c.oy, sheet.width, sheet.height, 0, 0, sheet.width, sheet.height);
  sheetCtx.strokeStyle = "#62d0ff";
  sheetCtx.lineWidth = 1;
  for (let y = 0; y < c.rows; y++) {
    for (let x = 0; x < c.cols; x++) {
      const fx = c.ox + x * (c.fw + c.gx);
      const fy = c.oy + y * (c.fh + c.gy);
      if (fx + c.fw <= src.width && fy + c.fh <= src.height) {
        frames.push({ x: fx, y: fy, w: c.fw, h: c.fh });
        sheetCtx.strokeRect(x * (c.fw + c.gx) + .5, y * (c.fh + c.gy) + .5, c.fw, c.fh);
      }
    }
  }
  setInfo(`${sourceName}\n${src.width}x${src.height}\nframes: ${frames.length}`);
}

function alphaBounds() {
  const data = srcCtx.getImageData(0, 0, src.width, src.height).data;
  let minX = src.width, minY = src.height, maxX = -1, maxY = -1;
  for (let y = 0; y < src.height; y++) {
    for (let x = 0; x < src.width; x++) {
      if (data[(y * src.width + x) * 4 + 3]) {
        minX = Math.min(minX, x);
        minY = Math.min(minY, y);
        maxX = Math.max(maxX, x);
        maxY = Math.max(maxY, y);
      }
    }
  }
  return maxX < 0 ? null : { minX, minY, maxX, maxY };
}

function autoGrid() {
  const c = cfg();
  const b = alphaBounds();
  if (b) {
    $("ox").value = Math.floor(b.minX / (c.fw + c.gx)) * (c.fw + c.gx);
    $("oy").value = Math.floor(b.minY / (c.fh + c.gy)) * (c.fh + c.gy);
  }
  const next = cfg();
  $("cols").value = Math.max(1, Math.ceil(((b ? b.maxX : src.width - 1) - next.ox + 1) / (next.fw + next.gx)));
  $("rows").value = Math.max(1, Math.ceil(((b ? b.maxY : src.height - 1) - next.oy + 1) / (next.fh + next.gy)));
}

function exportFrames() {
  frames.forEach((f, i) => {
    const c = document.createElement("canvas");
    c.width = f.w;
    c.height = f.h;
    c.getContext("2d").drawImage(src, f.x, f.y, f.w, f.h, 0, 0, f.w, f.h);
    download(`${sourceName}_${String(i).padStart(3, "0")}.png`, c.toDataURL("image/png"));
  });
}

function exportJson() {
  const data = { source: sourceName, image: `${sourceName}.png`, frameRate: cfg().fps, frames };
  download(`${sourceName}.json`, URL.createObjectURL(new Blob([JSON.stringify(data, null, 2)], { type: "application/json" })));
}

function drawAnim() {
  animCtx.clearRect(0, 0, anim.width, anim.height);
  if (frames.length) {
    const f = frames[Math.floor(frameIndex) % frames.length];
    const scale = Math.min(anim.width / f.w, anim.height / f.h, 2);
    const w = f.w * scale;
    const h = f.h * scale;
    animCtx.drawImage(src, f.x, f.y, f.w, f.h, (anim.width - w) / 2, (anim.height - h) / 2, w, h);
    frameIndex += (cfg().fps || 8) / 60;
  }
  requestAnimationFrame(drawAnim);
}

async function loadFile(file) {
  sourceName = file.name.replace(/\.[^.]+$/, "");
  frameIndex = 0;
  try {
    if (file.name.toLowerCase().endsWith(".img")) {
      try {
        await loadImgFile(file);
      } catch {
        const decoded = ImgDecoder.decodeImg(await file.arrayBuffer());
        src.width = decoded.width;
        src.height = decoded.height;
        srcCtx.putImageData(decoded.imageData, 0, 0);
        setInfo(`${file.name}\nJS fallback\n${decoded.width}x${decoded.height}\ntype: ${decoded.type}`);
      }
    } else {
      await loadImage(file);
      setInfo(`${file.name}\nimage loaded\n${src.width}x${src.height}`);
    }
    autoGrid();
    applyGrid();
    const b = alphaBounds();
    if (b) {
      setInfo(`${sourceName}\n${src.width}x${src.height}\ncontent: ${b.minX},${b.minY}-${b.maxX},${b.maxY}\nframes: ${frames.length}`);
    }
  } catch (e) {
    setInfo(`${file.name}\n解析失败：${e.message}`);
  }
}

$("file").addEventListener("change", (e) => e.target.files[0] && loadFile(e.target.files[0]));
$("apply").addEventListener("click", applyGrid);
$("png").addEventListener("click", () => download(`${sourceName}.png`, sourceToPngUrl()));
$("frames").addEventListener("click", exportFrames);
$("json").addEventListener("click", exportJson);
for (const key of cfgKeys) $(key).addEventListener("input", applyGrid);
drawAnim();
