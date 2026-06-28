import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class HaloListTooltipPatch {
    public static void main(String[] args) throws Exception {
        String root = args[0];
        String out = args[1];

        ClassPool cp = new ClassPool(false);
        cp.appendSystemPath();
        cp.insertClassPath(root + "/client/client_bag96.zip");

        CtClass tooltip = cp.get("b.a.c.b.at");
        CtMethod method = null;
        for (CtMethod m : tooltip.getDeclaredMethods("if")) {
            if ("(Lb/a/e/j;ZZIIZZ)V".equals(m.getSignature())) {
                method = m;
                break;
            }
        }
        if (method == null) {
            throw new IllegalStateException("Tooltip item method not found");
        }

        method.insertAfter(
            "{"
                + "int __haloId = -1;"
                + "try { __haloId = java.lang.Class.forName(\"b.a.b\").getField(\"if\").getInt($1); } catch (java.lang.Throwable __t) {}"
                + "boolean __isHalo = false;"
                + "java.io.BufferedReader __br = null;"
                + "try {"
                    + "__br = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(\"data/halos.txt\")));"
                    + "java.lang.String __line;"
                    + "while ((__line = __br.readLine()) != null) {"
                        + "__line = __line.trim();"
                        + "if (__line.length() == 0 || __line.startsWith(\"#\")) continue;"
                        + "int __p = 0;"
                        + "while (__p < __line.length() && java.lang.Character.isDigit(__line.charAt(__p))) __p++;"
                        + "if (__p > 0 && java.lang.Integer.parseInt(__line.substring(0, __p)) == __haloId) { __isHalo = true; break; }"
                    + "}"
                + "} catch (java.lang.Throwable __t) {"
                    + "if (__haloId == 1713059900) __isHalo = true;"
                + "} finally { try { if (__br != null) __br.close(); } catch (java.lang.Throwable __t2) {} }"
                + "if (__isHalo) {"
                    + "java.lang.String __typePrefix = new java.lang.String(new char[]{31867,22411});"
                    + "java.lang.String __haloText = new java.lang.String(new char[]{31867,22411,65306,20809,29615});"
                    + "for (int __i = 0; __i < this.z; __i++) {"
                        + "if (this.D[__i] != null && this.D[__i].indexOf(__typePrefix) >= 0) {"
                            + "this.D[__i] = __haloText;"
                            + "break;"
                        + "}"
                    + "}"
                + "}"
            + "}"
        );

        tooltip.writeFile(out);
    }
}
