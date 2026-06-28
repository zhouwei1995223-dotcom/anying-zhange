import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class PatchDisableNamedTitleHaloEffects {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            throw new IllegalArgumentException("usage: PatchDisableNamedTitleHaloEffects <in.zip> <out.zip>");
        }
        ClassPool pool = ClassPool.getDefault();
        pool.insertClassPath(args[0]);

        CtClass playerClass = pool.get("b.a.b.p");
        CtMethod draw = playerClass.getDeclaredMethod("if", new CtClass[]{pool.get("a.b.c")});
        draw.insertBefore("{ try { title = null; auraDragon = null; } catch (Throwable __t) { } }");
        playerClass.writeFile("tools/.patched_disable_named_fx");

        java.util.jar.JarFile in = new java.util.jar.JarFile(args[0]);
        java.util.jar.JarOutputStream out = new java.util.jar.JarOutputStream(new java.io.FileOutputStream(args[1]));
        java.util.Enumeration entries = in.entries();
        boolean replaced = false;
        while (entries.hasMoreElements()) {
            java.util.jar.JarEntry e = (java.util.jar.JarEntry)entries.nextElement();
            String name = e.getName();
            out.putNextEntry(new java.util.jar.JarEntry(name));
            if (name.equals("b/a/b/p.class")) {
                copy(new java.io.FileInputStream("tools/.patched_disable_named_fx/" + name), out);
                replaced = true;
            } else {
                copy(in.getInputStream(e), out);
            }
            out.closeEntry();
        }
        out.close();
        in.close();
        if (!replaced) throw new IllegalStateException("b/a/b/p.class was not replaced");
    }

    private static void copy(java.io.InputStream in, java.io.OutputStream out) throws java.io.IOException {
        try {
            byte[] buf = new byte[8192];
            int n;
            while ((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }
        } finally {
            in.close();
        }
    }
}
