const canvas = document.getElementById("game");
const ctx = canvas.getContext("2d");
const map = new Image();
const ui = new Image();

map.src = "../无双暗影世界/client/image/sm/0.jpg";
ui.src = "../无双暗影世界/client/image/ui/ui.png";

const state = {
  player: { x: 500, y: 330, tx: 500, ty: 330 },
  npcs: [{ x: 390, y: 265, name: "药商" }, { x: 640, y: 360, name: "村长" }],
  monsters: [{ x: 760, y: 260, name: "山贼" }, { x: 815, y: 410, name: "野兽" }],
};

function resize() {
  const dpr = window.devicePixelRatio || 1;
  canvas.width = Math.floor(innerWidth * dpr);
  canvas.height = Math.floor(innerHeight * dpr);
  ctx.setTransform(dpr, 0, 0, dpr, 0, 0);
}

function worldFromEvent(e) {
  const r = canvas.getBoundingClientRect();
  return { x: e.clientX - r.left, y: e.clientY - r.top };
}

function movePlayer() {
  const p = state.player;
  const dx = p.tx - p.x;
  const dy = p.ty - p.y;
  const d = Math.hypot(dx, dy);
  if (d < 2) return;
  p.x += (dx / d) * 3;
  p.y += (dy / d) * 3;
}

function label(text, x, y) {
  ctx.font = "13px sans-serif";
  ctx.textAlign = "center";
  ctx.fillStyle = "#101018";
  ctx.fillText(text, x + 1, y + 1);
  ctx.fillStyle = "#f8f2d8";
  ctx.fillText(text, x, y);
}

function marker(x, y, color, name) {
  ctx.fillStyle = "rgba(0,0,0,.35)";
  ctx.beginPath();
  ctx.ellipse(x, y + 16, 18, 7, 0, 0, Math.PI * 2);
  ctx.fill();
  ctx.fillStyle = color;
  ctx.beginPath();
  ctx.arc(x, y, 13, 0, Math.PI * 2);
  ctx.fill();
  label(name, x, y - 20);
}

function draw() {
  movePlayer();
  ctx.clearRect(0, 0, innerWidth, innerHeight);
  ctx.drawImage(map, 0, 0, innerWidth, innerHeight);
  ctx.fillStyle = "rgba(8, 10, 18, .28)";
  ctx.fillRect(0, 0, innerWidth, innerHeight);

  for (const n of state.npcs) marker(n.x, n.y, "#53d08a", n.name);
  for (const m of state.monsters) marker(m.x, m.y, "#d95757", m.name);
  marker(state.player.x, state.player.y, "#58a6ff", "主角");

  if (ui.complete) ctx.drawImage(ui, 0, 0, 220, 72, 18, 18, 220, 72);
  label("点击地图移动", innerWidth - 96, 32);
  requestAnimationFrame(draw);
}

canvas.addEventListener("click", (e) => Object.assign(state.player, worldFromEvent(e)));
addEventListener("resize", resize);
resize();
draw();
