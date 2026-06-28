import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class StackRefreshServerPatch {
    public static void main(String[] args) throws Exception {
        String root = args[0];
        String inZip = root + "/server/server_stack7.zip";
        String outDir = root + "/.codex_stack2_patch/server_stack8_classes";

        ClassPool cp = new ClassPool(false);
        cp.appendSystemPath();
        cp.insertClassPath(inZip);
        cp.insertClassPath(root + "/server/lib/mysql-connector-java-5.0.4-bin.jar");

        CtClass session = cp.get("app.island.gs.h");
        CtMethod giveGoods = session.getDeclaredMethod("a", new CtClass[] {
                cp.get("app.island.data.Goods")
        });

        giveGoods.insertAfter(
                "{ if ($1 != null && this.r() != null && this.r().personalDepot != null) {"
                        + " this.r().personalDepot.compactStacks();"
                        + " this.a(app.island.gs.p.a(this.r().personalDepot));"
                        + " } }");

        session.writeFile(outDir);
    }
}
