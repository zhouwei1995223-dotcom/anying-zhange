import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class StackPatch4 {
    public static void main(String[] args) throws Exception {
        String root = args[0];
        String inputZip = root + "/server/server_stack.zip";
        String outDir = root + "/.codex_stack2_patch/server_classes4";

        ClassPool cp = new ClassPool(false);
        cp.appendSystemPath();
        cp.insertClassPath(inputZip);

        CtClass goods = cp.get("app.island.data.Goods");
        goods.getDeclaredMethod("isStackable").setBody(
            "{ return (this.canStack == 1 || this.id == 1633060011 || this.id == 1333020200) && this.goodsType != 1 && this.goodsType != 2 && this.goodsType != 3 && this.goodsType != 6; }"
        );
        goods.writeFile(outDir);

        CtClass depot = cp.get("app.island.data.Depot");
        try {
            depot.getDeclaredMethod("addStackableGoods");
        } catch (javassist.NotFoundException ex) {
            depot.addMethod(CtMethod.make(
                "public int addStackableGoods(app.island.data.Goods g) {"
                    + " if (g == null) return -1;"
                    + " if (!(g.isStackable() || g.canStack == 1 || g.id == 1633060011 || g.id == 1333020200)) return -1;"
                    + " int add = g.stackCount < 1 ? 1 : g.stackCount;"
                    + " for (int i = 0; i < this.goodsList.length; i++) {"
                    + "   app.island.data.Goods h = this.goodsList[i];"
                    + "   if (h != null && h.id == g.id && (h.isStackable() || h.canStack == 1 || h.id == 1633060011 || h.id == 1333020200)) {"
                    + "     h.canStack = 1;"
                    + "     if (h.stackCount < 1) h.stackCount = 1;"
                    + "     h.stackCount += add;"
                    + "     return i;"
                    + "   }"
                    + " }"
                    + " return -1;"
                    + "}",
                depot
            ));
        }
        depot.writeFile(outDir);

        CtClass session = cp.get("app.island.gs.h");
        session.getDeclaredMethod("a", new CtClass[] { cp.get("app.island.data.Goods") }).insertBefore(
            "{"
                + " if ($1 != null) {"
                + "   int __stackPos = this.u.personalDepot.addStackableGoods($1);"
                + "   if (__stackPos >= 0) {"
                + "     boolean __online = true;"
                + "     try { __online = ((Boolean)this.getClass().getMethod(\"goto\", new Class[0]).invoke(this, new Object[0])).booleanValue(); } catch (Exception __e) {}"
                + "     if (__online) {"
                + "       this.a(app.island.gs.p.a(__stackPos, this.u.personalDepot.goodsList[__stackPos]));"
                + "       this.a(app.island.gs.p.a(this.u.personalDepot));"
                + "     }"
                + "     this.C();"
                + "     return;"
                + "   }"
                + " }"
                + "}"
        );
        session.writeFile(outDir);
    }
}
