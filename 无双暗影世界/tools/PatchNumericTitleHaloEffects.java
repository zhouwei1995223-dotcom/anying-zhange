import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class PatchNumericTitleHaloEffects {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            throw new IllegalArgumentException("usage: PatchNumericTitleHaloEffects <in.zip> <out.zip>");
        }

        ClassPool pool = ClassPool.getDefault();
        pool.insertClassPath(args[0]);

        CtClass effectClass = pool.get("b.a.b.i");
        effectClass.getClassInitializer().insertAfter("o = new a.b.af[300];");

        CtClass loaderClass = pool.get("b.a.c.e");
        CtMethod loadEffects = loaderClass.getDeclaredMethod("for");
        loadEffects.insertAfter(
            "{ try { " +
            "  Object __mgr = Class.forName(\"a.b.v\").getField(\"if\").get(null); " +
            "  java.lang.reflect.Method __load = __mgr.getClass().getMethod(\"if\", new Class[]{String.class, Boolean.TYPE}); " +
            "  a.b.af[] __arr = (a.b.af[])Class.forName(\"b.a.b.i\").getField(\"o\").get(null); " +
            "  for (int __i = 100; __i <= 300 && (__i - 1) < __arr.length; __i++) { " +
            "    Object __img = __load.invoke(__mgr, new Object[]{\"image/effect/\" + __i + \".img\", Boolean.FALSE}); " +
            "    if (__img != null) __arr[__i - 1] = (a.b.af)__img; " +
            "  } " +
            "} catch (Throwable __t) { } }"
        );

        CtClass playerClass = pool.get("b.a.b.p");
        playerClass.addMethod(CtMethod.make(
            "private static int __readServerEffect(String __path, int __id) { " +
            "  java.io.BufferedReader __r = null; " +
            "  try { " +
            "    java.io.File __f = new java.io.File(__path); " +
            "    if (!__f.exists()) return 0; " +
            "    __r = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(__f))); " +
            "    String __line; int __lineNo = 0; int __goodsLuck = 31; " +
            "    while ((__line = __r.readLine()) != null) { " +
            "      __lineNo++; if (__lineNo <= 2 || __line.trim().length() == 0 || __line.charAt(0) == '#') continue; " +
            "      String[] __p = __line.split(\"\\\\t\"); " +
            "      if (__p.length > __goodsLuck && Integer.parseInt(__p[0].trim()) == __id) return Integer.parseInt(__p[__goodsLuck].trim()); " +
            "    } " +
            "  } catch (Throwable __t) { " +
            "  } finally { try { if (__r != null) __r.close(); } catch (Throwable __t2) { } } " +
            "  return 0; " +
            "}", playerClass));
        playerClass.addMethod(CtMethod.make(
            "private static int __readClientEffect(String __path, int __id) { " +
            "  java.io.BufferedReader __r = null; " +
            "  try { " +
            "    java.io.File __f = new java.io.File(__path); " +
            "    if (!__f.exists()) return 0; " +
            "    __r = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(__f))); " +
            "    String __line; " +
            "    while ((__line = __r.readLine()) != null) { " +
            "      __line = __line.trim(); if (__line.length() == 0 || __line.charAt(0) == '#') continue; " +
            "      String[] __p = __line.split(\"\\\\s+\"); " +
            "      if (__p.length >= 2 && Integer.parseInt(__p[0]) == __id) return Integer.parseInt(__p[1]); " +
            "    } " +
            "  } catch (Throwable __t) { " +
            "  } finally { try { if (__r != null) __r.close(); } catch (Throwable __t2) { } } " +
            "  return 0; " +
            "}", playerClass));
        playerClass.addMethod(CtMethod.make(
            "private static int __readTitleHaloEffect(String __serverPath, String __clientPath, int __id) { " +
            "  int __v = __readServerEffect(__serverPath, __id); " +
            "  if (__v > 0) return __v; " +
            "  return __readClientEffect(__clientPath, __id); " +
            "}", playerClass));
        CtMethod draw = playerClass.getDeclaredMethod("if", new CtClass[]{pool.get("a.b.c")});
        draw.insertBefore("{ try { title = null; auraDragon = null; } catch (Throwable __t) { } }");
        draw.insertAfter(
            "{ try { " +
            "  if (this.af != null) { " +
            "    Object __depot = this.af.getClass().getField(\"bA\").get(this.af); " +
            "    if (__depot != null) { " +
            "      Object __title = __depot.getClass().getField(\"title\").get(__depot); " +
            "      Object __aura = __depot.getClass().getField(\"aura\").get(__depot); " +
            "      if (__title != null) { " +
            "        int __id = ((Integer)Class.forName(\"b.a.b\").getField(\"if\").get(__title)).intValue(); " +
            "        this.af.titleEffect = __readTitleHaloEffect(\"../server/config/data/jewels/titles.txt\", \"data/titles.txt\", __id); " +
            "      } " +
            "      if (__aura != null) { " +
            "        int __id = ((Integer)Class.forName(\"b.a.b\").getField(\"if\").get(__aura)).intValue(); " +
            "        this.af.auraEffect = __readTitleHaloEffect(\"../server/config/data/jewels/halos.txt\", \"data/halos.txt\", __id); " +
            "      } " +
            "    } " +
            "    int __x = ((Integer)this.getClass().getMethod(\"try\", new Class[0]).invoke(this, new Object[0])).intValue(); " +
            "    int __y = ((Integer)this.getClass().getMethod(\"char\", new Class[0]).invoke(this, new Object[0])).intValue(); " +
            "    a.b.af[] __effects = (a.b.af[])Class.forName(\"b.a.b.i\").getField(\"o\").get(null); " +
            "    int __auraNo = this.af.auraEffect; " +
            "    if (__auraNo > 0 && __auraNo <= __effects.length && __effects[__auraNo - 1] != null) { " +
            "      int __f = (this.Q / 4) % 8; " +
            "      $1.a(__effects[__auraNo - 1], __x, __y, __f * 150, 0, 150, 150, 0, 0); " +
            "    } " +
            "    int __titleNo = this.af.titleEffect; " +
            "    if (__titleNo > 0 && __titleNo <= __effects.length && __effects[__titleNo - 1] != null) { " +
            "      int __f = (this.Q / 4) % 8; " +
            "      $1.a(__effects[__titleNo - 1], __x, __y - 12, __f * 150, 0, 150, 150, 0, 0); " +
            "      if (this.ae < 32) { " +
            "        int __f2 = (this.ae / 4) % 8; " +
            "        $1.a(__effects[__titleNo - 1], __x, __y - 12, __f2 * 150, 150, 150, 150, 0, 0); " +
            "      } " +
            "    } " +
            "  } " +
            "} catch (Throwable __t) { } }"
        );
        effectClass.writeFile("tools/.patched_numeric_fx");
        loaderClass.writeFile("tools/.patched_numeric_fx");
        playerClass.writeFile("tools/.patched_numeric_fx");

        java.util.jar.JarFile in = new java.util.jar.JarFile(args[0]);
        java.util.jar.JarOutputStream out = new java.util.jar.JarOutputStream(new java.io.FileOutputStream(args[1]));
        java.util.Enumeration entries = in.entries();
        java.util.HashSet replaced = new java.util.HashSet();
        while (entries.hasMoreElements()) {
            java.util.jar.JarEntry e = (java.util.jar.JarEntry)entries.nextElement();
            String name = e.getName();
            if (name.equals("b/a/b/i.class") || name.equals("b/a/c/e.class") || name.equals("b/a/b/p.class")) {
                java.io.File patched = new java.io.File("tools/.patched_numeric_fx/" + name);
                out.putNextEntry(new java.util.jar.JarEntry(name));
                copy(new java.io.FileInputStream(patched), out);
                out.closeEntry();
                replaced.add(name);
            } else {
                out.putNextEntry(new java.util.jar.JarEntry(name));
                copy(in.getInputStream(e), out);
                out.closeEntry();
            }
        }
        out.close();
        in.close();
        if (replaced.size() != 3) {
            throw new IllegalStateException("patched classes missing: " + replaced);
        }
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
