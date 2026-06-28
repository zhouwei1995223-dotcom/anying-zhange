import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class StackDepotOnlyPatch {
    public static void main(String[] args) throws Exception {
        String root = args[0];
        String inZip = root + "/server/server_stack8.zip";
        String outDir = root + "/.codex_stack2_patch/server_stack10_classes";

        ClassPool cp = new ClassPool(false);
        cp.appendSystemPath();
        cp.insertClassPath(inZip);
        cp.insertClassPath(root + "/server/lib/mysql-connector-java-5.0.4-bin.jar");

        CtClass depot = cp.get("app.island.data.Depot");
        CtMethod compact = depot.getDeclaredMethod("compactStacks");
        compact.setBody(
                "{"
                        + " if (this.goodsList == null) return;"
                        + " for (int i = 0; i < this.goodsList.length; i++) {"
                        + "   app.island.data.Goods a = this.goodsList[i];"
                        + "   if (a == null || !a.isStackable()) continue;"
                        + "   a.canStack = 1;"
                        + "   if (a.stackCount < 1) a.stackCount = 1;"
                        + "   for (int j = i + 1; j < this.goodsList.length; j++) {"
                        + "     app.island.data.Goods b = this.goodsList[j];"
                        + "     if (b == null || b.id != a.id || !b.isStackable()) continue;"
                        + "     a.stackCount += (b.stackCount < 1 ? 1 : b.stackCount);"
                        + "     this.goodsList[j] = null;"
                        + "   }"
                        + " }"
                        + "}");

        CtMethod add = depot.getDeclaredMethod("addStackableGoods", new CtClass[] { cp.get("app.island.data.Goods") });
        add.setBody(
                "{"
                        + " if ($1 == null || !$1.isStackable()) return -1;"
                        + " $1.canStack = 1;"
                        + " int addCount = $1.stackCount < 1 ? 1 : $1.stackCount;"
                        + " for (int i = 0; i < this.goodsList.length; i++) {"
                        + "   app.island.data.Goods g = this.goodsList[i];"
                        + "   if (g == null || g.id != $1.id || !g.isStackable()) continue;"
                        + "   g.canStack = 1;"
                        + "   if (g.stackCount < 1) g.stackCount = 1;"
                        + "   g.stackCount += addCount;"
                        + "   this.compactStacks();"
                        + "   return i;"
                        + " }"
                        + " return -1;"
                        + "}");

        depot.writeFile(outDir);
    }
}
