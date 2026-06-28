import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class StackPatch5 {
    public static void main(String[] args) throws Exception {
        String root = args[0];
        String inputZip = root + "/server/server_stack.zip";
        String outDir = root + "/.codex_stack2_patch/server_classes5";

        ClassPool cp = new ClassPool(false);
        cp.appendSystemPath();
        cp.insertClassPath(inputZip);

        CtClass goods = cp.get("app.island.data.Goods");
        goods.getDeclaredMethod("isStackable").setBody(
            "{ return (this.canStack == 1 || this.id == 1633060011 || this.id == 1333020200) && this.goodsType != 1 && this.goodsType != 2 && this.goodsType != 3 && this.goodsType != 6; }"
        );
        goods.writeFile(outDir);

        CtClass depot = cp.get("app.island.data.Depot");
        CtMethod addStack;
        try {
            addStack = depot.getDeclaredMethod("addStackableGoods");
        } catch (javassist.NotFoundException ex) {
            addStack = CtMethod.make(
                "public int addStackableGoods(app.island.data.Goods g) { return -1; }",
                depot
            );
            depot.addMethod(addStack);
        }
        addStack.setBody(
            "{"
                + " if ($1 == null) return -1;"
                + " if (!($1.isStackable() || $1.canStack == 1 || $1.id == 1633060011 || $1.id == 1333020200)) return -1;"
                + " int add = $1.stackCount < 1 ? 1 : $1.stackCount;"
                + " for (int i = 0; i < this.goodsList.length; i++) {"
                + "   app.island.data.Goods h = this.goodsList[i];"
                + "   if (h != null && h.id == $1.id && (h.isStackable() || h.canStack == 1 || h.id == 1633060011 || h.id == 1333020200)) {"
                + "     h.canStack = 1;"
                + "     if (h.stackCount < 1) h.stackCount = 1;"
                + "     h.stackCount += add;"
                + "     return i;"
                + "   }"
                + " }"
                + " return -1;"
                + "}"
        );
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
