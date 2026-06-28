import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class HaloTypePatch {
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
                + "if (__haloId == 1713059900) {"
                    + "for (int __i = 0; __i < this.z; __i++) {"
                        + "if (this.D[__i] != null && this.D[__i].indexOf(\"\\u7c7b\\u578b\") >= 0) {"
                            + "this.D[__i] = \"\\u7c7b\\u578b\\uff1a\\u5149\\u73af\";"
                            + "break;"
                        + "}"
                    + "}"
                + "}"
            + "}"
        );

        tooltip.writeFile(out);
    }
}
