import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class StackCountClientPatch {
    public static void main(String[] args) throws Exception {
        String root = args[0];
        String inZip = root + "/client/client_stack.zip";
        String outDir = root + "/.codex_stack2_patch/client_count_classes";

        ClassPool cp = new ClassPool(false);
        cp.appendSystemPath();
        cp.insertClassPath(inZip);

        CtClass ui = cp.get("b.a.c.b.e");
        CtMethod drawItem = ui.getDeclaredMethod("a", new CtClass[] {
                cp.get("a.b.c"),
                cp.get("b.a.e.j"),
                CtClass.intType,
                CtClass.intType
        });

        drawItem.insertAfter(
                "{ if ($2 != null && $2.stackCount > 1) {"
                        + " String __s = String.valueOf($2.stackCount);"
                        + " int __x = $3 + 22 - __s.length() * 6;"
                        + " if (__x < $3) __x = $3;"
                        + " int __y = $4 + 22;"
                        + " $1.a(__s, __x + 1, __y + 1, 0);"
                        + " $1.a(__s, __x, __y, 16777215);"
                        + " } }");

        ui.writeFile(outDir);
    }
}
