import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class StackPatch3 {
    public static void main(String[] args) throws Exception {
        String root = args[0];
        String inputZip = root + "/server/server_stack.zip";
        String outDir = root + "/.codex_stack2_patch/server_classes3";

        ClassPool cp = new ClassPool(false);
        cp.appendSystemPath();
        cp.insertClassPath(inputZip);

        CtClass goods = cp.get("app.island.data.Goods");
        goods.getDeclaredMethod("isStackable").setBody(
            "{ return (this.canStack == 1 || this.id == 1633060011) && this.goodsType != 1 && this.goodsType != 2 && this.goodsType != 3 && this.goodsType != 6; }"
        );
        goods.writeFile(outDir);

        CtClass depot = cp.get("app.island.data.Depot");
        try {
            depot.getDeclaredMethod("addStackableGoods");
        } catch (javassist.NotFoundException ex) {
            depot.addMethod(CtMethod.make(
                "public int addStackableGoods(app.island.data.Goods g) {"
                    + " if (g == null) return -1;"
                    + " if (!(g.isStackable() || g.canStack == 1 || g.id == 1633060011)) return -1;"
                    + " int add = g.stackCount < 1 ? 1 : g.stackCount;"
                    + " for (int i = 0; i < this.goodsList.length; i++) {"
                    + "   app.island.data.Goods h = this.goodsList[i];"
                    + "   if (h != null && h.id == g.id && (h.isStackable() || h.canStack == 1 || h.id == 1633060011)) {"
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

        CtClass shop = cp.get("app.island.gs.v");
        shop.getDeclaredMethod("else", new CtClass[] { cp.get("app.island.gs.h"), CtClass.intType }).insertBefore(
            "{"
                + " if (!$1.g() && $2 >= 0 && $2 < this.e && this.f == null) {"
                + "   app.island.data.Goods __base = this.g[$2];"
                + "   if (__base != null && (__base.isStackable() || __base.canStack == 1 || __base.id == 1633060011)) {"
                + "     app.island.entity.Hero __hero = $1.r();"
                + "     app.island.data.Depot __depot = __hero.personalDepot;"
                + "     int __money = 0;"
                + "     int __treasure = 0;"
                + "     if (__base.treasureCost > 0) {"
                + "       __treasure = (int)(((long)__base.treasureCost * (long)this.i) / 100L);"
                + "       if (__treasure <= 0) { return; }"
                + "       if (__hero.user.treasure < __treasure) { return; }"
                + "     } else {"
                + "       __money = (int)(((long)__base.moneyCost * (long)this.i) / 100L);"
                + "       if (__money <= 0) { return; }"
                + "       if (__depot.money < __money) { return; }"
                + "     }"
                + "     boolean __hasStack = false;"
                + "     for (int __i = 0; __i < __depot.goodsList.length; __i++) {"
                + "       app.island.data.Goods __old = __depot.goodsList[__i];"
                + "       if (__old != null && __old.id == __base.id && (__old.isStackable() || __old.canStack == 1 || __old.id == 1633060011)) { __hasStack = true; break; }"
                + "     }"
                + "     if (!__hasStack && __depot.getNextFreePos() < 0) { return; }"
                + "     if (__treasure > 0) {"
                + "       __hero.user.treasure -= __treasure;"
                + "       __hero.consumedTreasure += __treasure;"
                + "       __hero.user.consumedTreasure += __treasure;"
                + "       app.island.gs.ServerInfo.consumedTreasure += __treasure;"
                + "     } else {"
                + "       __depot.money -= __money;"
                + "     }"
                + "     app.island.data.Goods __item = (app.island.data.Goods)app.island.GameObject.cloneObject(__base);"
                + "     try {"
                + "       java.lang.reflect.Field __mgrField = this.getClass().getDeclaredField(\"for\");"
                + "       __mgrField.setAccessible(true);"
                + "       Object __mgr = __mgrField.get(this);"
                + "       __mgr.getClass().getMethod(\"a\", new Class[] { app.island.data.Goods.class }).invoke(__mgr, new Object[] { __item });"
                + "     } catch (Exception __ignore) {}"
                + "     $1.a(__item);"
                + "     try {"
                + "       java.lang.reflect.Method __moneyPacket = app.island.gs.p.class.getDeclaredMethod(\"case\", new Class[] { app.island.entity.Hero.class });"
                + "       __moneyPacket.setAccessible(true);"
                + "       $1.a((app.b.b)__moneyPacket.invoke(null, new Object[] { __hero }));"
                + "     } catch (Exception __ignore2) {}"
                + "     this.a($1, __item, __money, __treasure);"
                + "     return;"
                + "   }"
                + " }"
                + "}"
        );
        shop.writeFile(outDir);
    }
}
