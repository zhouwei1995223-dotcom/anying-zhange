const { createServer } = require("node:http");
const { execFile } = require("node:child_process");
const { createReadStream, promises: fs } = require("node:fs");
const path = require("node:path");
const os = require("node:os");

const root = path.resolve(__dirname, "..");
const oldTool = process.env.IMG_TOOL_DIR || "D:\\测试光效\\img_png_tool";
const java = process.env.JAVA_EXE || "C:\\Program Files\\Android\\jdk\\jdk-8.0.302.8-hotspot\\jdk8u302-b08\\bin\\java.exe";
const port = Number(process.env.PORT || 5174);

const mime = {
  ".html": "text/html; charset=utf-8",
  ".css": "text/css; charset=utf-8",
  ".js": "text/javascript; charset=utf-8",
  ".png": "image/png",
};

function send(res, code, body, type = "text/plain; charset=utf-8") {
  res.writeHead(code, { "content-type": type });
  res.end(body);
}

async function body(req) {
  const chunks = [];
  for await (const chunk of req) chunks.push(chunk);
  return Buffer.concat(chunks);
}

async function imgToPng(req, res) {
  const dir = await fs.mkdtemp(path.join(os.tmpdir(), "img-tool-"));
  const input = path.join(dir, "input.img");
  const output = path.join(dir, "output.png");
  await fs.writeFile(input, await body(req));
  execFile(
    java,
    ["-cp", `${oldTool};${path.join(oldTool, "client.zip")}`, "ImgPngTool", "img2png", input, output],
    { cwd: oldTool },
    async (err) => {
      if (err) return send(res, 500, err.message);
      res.writeHead(200, { "content-type": "image/png" });
      createReadStream(output).pipe(res).on("close", () => fs.rm(dir, { recursive: true, force: true }));
    },
  );
}

async function file(req, res) {
  const url = new URL(req.url, "http://local");
  const pathname = decodeURIComponent(url.pathname === "/" ? "/img-tool/" : url.pathname);
  const target = path.resolve(root, pathname.slice(1), pathname.endsWith("/") ? "index.html" : "");
  if (!target.startsWith(root)) return send(res, 403, "forbidden");
  try {
    res.writeHead(200, { "content-type": mime[path.extname(target)] || "application/octet-stream" });
    createReadStream(target).pipe(res);
  } catch {
    send(res, 404, "not found");
  }
}

createServer((req, res) => {
  if (req.method === "POST" && req.url.includes("/api/img2png")) imgToPng(req, res).catch((e) => send(res, 500, e.message));
  else file(req, res);
}).listen(port, () => console.log(`img-tool: http://127.0.0.1:${port}/img-tool/`));
