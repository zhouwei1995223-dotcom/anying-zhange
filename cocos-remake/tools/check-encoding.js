const fs = require('fs');
const path = require('path');
const { TextDecoder } = require('util');

const root = path.resolve(__dirname, '..');
const decoder = new TextDecoder('utf-8', { fatal: true });
const extensions = new Set(['.ts', '.js', '.json', '.meta', '.md']);
const skipDirs = new Set(['.git', 'node_modules', 'temp', 'library', 'local', 'build']);
const mojibakeTokens = [
  '\\u00c3.', '\\u00c2.', '\\u00e2.',
  '\\u93c5', '\\u9422', '\\u6fc2', '\\u7441',
  '\\u95b0', '\\u934f', '\\u93ac', '\\u9473',
  '\\u7ec1', '\\u7eee', '\\u5a13', '\\u6d60',
];
const mojibakePattern = new RegExp(`(?:${mojibakeTokens.join('|')})`);
const errors = [];
const warnings = [];

function walk(dir) {
  for (const entry of fs.readdirSync(dir, { withFileTypes: true })) {
    if (entry.isDirectory()) {
      if (!skipDirs.has(entry.name)) walk(path.join(dir, entry.name));
      continue;
    }
    const file = path.join(dir, entry.name);
    if (!extensions.has(path.extname(file))) continue;
    checkFile(file);
  }
}

function checkFile(file) {
  const bytes = fs.readFileSync(file);
  try {
    const text = decoder.decode(bytes);
    if (mojibakePattern.test(text)) warnings.push(path.relative(root, file));
  } catch (err) {
    errors.push(`${path.relative(root, file)}: ${err.message}`);
  }
}

walk(root);

if (warnings.length) {
  console.warn('Possible mojibake text found:');
  for (const file of warnings) console.warn(`  ${file}`);
}

if (errors.length) {
  console.error('Non UTF-8 files found:');
  for (const err of errors) console.error(`  ${err}`);
  process.exit(1);
}

console.log('Encoding check passed.');
