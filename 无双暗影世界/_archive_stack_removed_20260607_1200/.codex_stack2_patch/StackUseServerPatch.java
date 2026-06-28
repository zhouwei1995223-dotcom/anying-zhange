import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class StackUseServerPatch {
    public static void main(String[] args) throws Exception {
        String root = args[0];
        String inZip = root + "/server/server_stack5.zip";
        String outDir = root + "/.codex_stack2_patch/server_stack6_classes";

        ClassPool cp = new ClassPool(false);
        cp.appendSystemPath();
        cp.insertClassPath(inZip);
        cp.insertClassPath(root + "/server/lib/mysql-connector-java-5.0.4-bin.jar");

        CtClass manager = cp.get("app.island.gs.m");
        CtClass session = cp.get("app.island.gs.h");
        CtMethod useGoods = manager.getDeclaredMethod("a", new CtClass[] {
                session,
                CtClass.intType
        });

        useGoods.setBody(
                "{"
                        + " if (!$1.g()) return false;"
                        + " app.island.entity.Hero hero = $1.r();"
                        + " if ($2 < 0 || $2 >= hero.personalDepot.goodsList.length) return false;"
                        + " app.island.data.Goods goods = hero.personalDepot.goodsList[$2];"
                        + " if (goods == null) return false;"
                        + " switch (goods.goodsType) {"
                        + " case 4: return this.a($1, (app.island.data.Book)goods, $2);"
                        + " case 2: return this.a($1, (app.island.data.Equipment)goods, $2);"
                        + " case 1: return this.a($1, (app.island.data.Weapon)goods, $2);"
                        + " case 3: return this.a($1, $2, 0);"
                        + " case 0: return this.a($1, (app.island.data.Medicine)goods, $2);"
                        + " case 5:"
                        + "   app.island.data.SpecialProperty sp = (app.island.data.SpecialProperty)goods;"
                        + "   boolean stackable = goods.isStackable() && goods.stackCount > 1;"
                        + "   if (stackable) {"
                        + "     goods.stackCount--;"
                        + "     boolean ok = this.a($1, sp);"
                        + "     if (ok) { $1.a(app.island.gs.p.a($2, goods)); return true; }"
                        + "     goods.stackCount++;"
                        + "     if (sp.spType == 40) $1.r = $2;"
                        + "     $1.a(app.island.gs.p.a($2, goods));"
                        + "     return false;"
                        + "   }"
                        + "   app.island.data.Goods saved = hero.personalDepot.goodsList[$2];"
                        + "   hero.personalDepot.goodsList[$2] = null;"
                        + "   boolean ok = this.a($1, sp);"
                        + "   if (ok) { if (hero.personalDepot.goodsList[$2] == null) { $1.a(app.island.gs.p.e($2)); $1.C(); } return true; }"
                        + "   app.island.data.SpecialProperty savedSp = (app.island.data.SpecialProperty)saved;"
                        + "   if (savedSp.spType == 40) $1.r = $2;"
                        + "   hero.personalDepot.goodsList[$2] = saved;"
                        + "   return false;"
                        + " case 6: return this.a($1, (app.island.data.Fashion)goods, $2);"
                        + " default: return false;"
                        + " }"
                        + "}");

        manager.writeFile(outDir);
    }
}
