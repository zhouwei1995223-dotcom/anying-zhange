import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class StackCoreServerPatch {
    public static void main(String[] args) throws Exception {
        String root = args[0];
        String inZip = root + "/server/server_stack8.zip";
        String outDir = root + "/.codex_stack2_patch/server_stack9_classes";

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
                        + "   if (a == null) continue;"
                        + "   if (!a.isStackable()) continue;"
                        + "   a.canStack = 1;"
                        + "   if (a.stackCount < 1) a.stackCount = 1;"
                        + "   for (int j = i + 1; j < this.goodsList.length; j++) {"
                        + "     app.island.data.Goods b = this.goodsList[j];"
                        + "     if (b == null) continue;"
                        + "     if (b.id != a.id) continue;"
                        + "     if (!b.isStackable()) continue;"
                        + "     int n = b.stackCount < 1 ? 1 : b.stackCount;"
                        + "     a.stackCount += n;"
                        + "     this.goodsList[j] = null;"
                        + "   }"
                        + " }"
                        + "}");

        CtMethod add = depot.getDeclaredMethod("addStackableGoods", new CtClass[] { cp.get("app.island.data.Goods") });
        add.setBody(
                "{"
                        + " if ($1 == null) return -1;"
                        + " if (!$1.isStackable()) return -1;"
                        + " $1.canStack = 1;"
                        + " int addCount = $1.stackCount < 1 ? 1 : $1.stackCount;"
                        + " for (int i = 0; i < this.goodsList.length; i++) {"
                        + "   app.island.data.Goods g = this.goodsList[i];"
                        + "   if (g == null) continue;"
                        + "   if (g.id != $1.id) continue;"
                        + "   if (!g.isStackable()) continue;"
                        + "   g.canStack = 1;"
                        + "   if (g.stackCount < 1) g.stackCount = 1;"
                        + "   g.stackCount += addCount;"
                        + "   this.compactStacks();"
                        + "   return i;"
                        + " }"
                        + " return -1;"
                        + "}");

        CtClass session = cp.get("app.island.gs.h");
        CtMethod giveGoods = session.getDeclaredMethod("a", new CtClass[] { cp.get("app.island.data.Goods") });
        giveGoods.setBody(
                "{"
                        + " if ($1 == null) return;"
                        + " app.island.entity.Hero hero = this.r();"
                        + " if (hero == null || hero.personalDepot == null) return;"
                        + " app.island.data.Depot depot = hero.personalDepot;"
                        + " int pos = depot.addStackableGoods($1);"
                        + " if (pos < 0) {"
                        + "   pos = depot.getNextFreePos();"
                        + "   if (pos >= 0) depot.goodsList[pos] = $1;"
                        + " }"
                        + " depot.compactStacks();"
                        + " this.a(app.island.gs.p.a(depot));"
                        + " this.C();"
                        + "}");

        depot.writeFile(outDir);
        session.writeFile(outDir);
    }
}
