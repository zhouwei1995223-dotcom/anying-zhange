(function () {
  class Reader {
    constructor(bytes) { this.bytes = bytes; this.i = 0; }
    u8() { return this.bytes[this.i++]; }
    u16() { const v = this.bytes[this.i] | (this.bytes[this.i + 1] << 8); this.i += 2; return v; }
    i16() { const v = this.u16(); return v & 0x8000 ? v - 0x10000 : v; }
    u32() { const v = this.bytes[this.i] | (this.bytes[this.i + 1] << 8) | (this.bytes[this.i + 2] << 16) | (this.bytes[this.i + 3] << 24); this.i += 4; return v >>> 0; }
  }

  function rgb555(v, painted) {
    v &= 0x7fff;
    const r = ((v >> 10) & 31) * 255 / 31;
    const g = ((v >> 5) & 31) * 255 / 31;
    const b = (v & 31) * 255 / 31;
    return [r, g, b, painted ? 255 : 0];
  }

  function readHeader(reader) {
    const payloadBytes = reader.u32();
    const typeRaw = reader.u8();
    return {
      payloadBytes,
      type: typeRaw > 3 ? typeRaw >> 4 : typeRaw,
      width: reader.u16(),
      height: reader.u16(),
    };
  }

  function makeImageData(width, height, pixels, mask) {
    const imageData = new ImageData(width, height);
    for (let i = 0; i < pixels.length; i++) {
      const [r, g, b, a] = rgb555(pixels[i], mask[i]);
      const p = i * 4;
      imageData.data[p] = r;
      imageData.data[p + 1] = g;
      imageData.data[p + 2] = b;
      imageData.data[p + 3] = a;
    }
    return imageData;
  }

  function decodeRaw(reader, width, height) {
    const pixels = new Uint16Array(width * height);
    const mask = new Uint8Array(width * height);
    for (let i = 0; i < pixels.length && reader.i + 1 < reader.bytes.length; i++) pixels[i] = reader.u16();
    mask.fill(1);
    return { pixels, mask };
  }

  function decodeRuns(reader, width, height) {
    const pixels = new Uint16Array(width * height);
    const mask = new Uint8Array(width * height);
    for (let y = 0; y < height && reader.i + 1 < reader.bytes.length; y++) {
      const count = reader.i16();
      const row = [];
      for (let i = 0; i < count && reader.i + 1 < reader.bytes.length; i++) row.push(reader.u16());
      let x = 0;
      for (let n = 0; n < row.length;) {
        const op = row[n++];
        const kind = op & 0xf000;
        const len = op & 0x0fff;
        if (kind === 0x3000) {
          y += len - 1;
          break;
        }
        if (kind === 0x2000) {
          x += len;
          continue;
        }
        if (kind === 0x1000) {
          for (let i = 0; i < len && x < width && n < row.length; i++) {
            const p = y * width + x++;
            pixels[p] = row[n++];
            mask[p] = 1;
          }
          continue;
        }
        if (kind === 0x4000) {
          for (let i = 0; i < len && x < width && n + 1 < row.length; i++) {
            n++;
            const p = y * width + x++;
            pixels[p] = row[n++];
            mask[p] = 1;
          }
        }
      }
    }
    return { pixels, mask };
  }

  function decodeImg(buffer) {
    const bytes = new Uint8Array(buffer);
    const reader = new Reader(bytes);
    const header = readHeader(reader);
    if (!header.width || !header.height || header.width > 4096 || header.height > 4096) throw new Error("无法识别 .img 头部");
    const decoded = header.type === 1 ? decodeRaw(reader, header.width, header.height) : decodeRuns(reader, header.width, header.height);
    return { ...header, imageData: makeImageData(header.width, header.height, decoded.pixels, decoded.mask) };
  }

  window.ImgDecoder = { decodeImg };
})();
