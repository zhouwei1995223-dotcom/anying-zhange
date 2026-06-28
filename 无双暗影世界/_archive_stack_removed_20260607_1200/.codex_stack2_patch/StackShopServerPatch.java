import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class StackShopServerPatch {
    public static void main(String[] args) throws Exception {
        String root = args[0];
        String inZip = root + "/server/server_stack6.zip";
        String outDir = root + "/.codex_stack2_patch/server_stack7_classes";

        ClassPool cp = new ClassPool(false);
        cp.appendSystemPath();
        cp.insertClassPath(inZip);
        cp.insertClassPath(root + "/server/lib/mysql-connector-java-5.0.4-bin.jar");

        CtClass shop = cp.get("app.island.gs.v");
        CtMethod buy = shop.getDeclaredMethod("else", new CtClass[] {
                cp.get("app.island.gs.h"),
                CtClass.intType
        });

        buy.setBody(
                "{"
                        + " if (!$1.g() || $2 >= this.e) return;"
                        + " app.island.data.Goods src = this.g[$2];"
                        + " if (src == null) return;"
                        + " app.island.entity.Hero hero = $1.r();"
                        + " app.island.data.Depot depot = hero.personalDepot;"
                        + " boolean stackable = src.isStackable();"
                        + " if (!stackable && depot.getNextFreePos() < 0) return;"
                        + " int treasure = 0;"
                        + " int money = 0;"
                        + " if (src.treasureCost > 0) {"
                        + "   treasure = (int)(((long)src.treasureCost * (long)this.i) / 100L);"
                        + "   if (treasure <= 0) return;"
                        + "   if (hero.user.treasure < treasure) return;"
                        + "   hero.user.treasure -= treasure;"
                        + "   hero.consumedTreasure += treasure;"
                        + "   hero.user.consumedTreasure += treasure;"
                        + "   app.island.gs.ServerInfo.consumedTreasure += treasure;"
                        + " } else {"
                        + "   money = (int)(((long)src.moneyCost * (long)this.i) / 100L);"
                        + "   if (money <= 0) return;"
                        + "   if (depot.money < money) return;"
                        + "   depot.money -= money;"
                        + " }"
                        + " app.island.data.Goods item = (app.island.data.Goods)app.island.GameObject.cloneObject(src);"
                        + " item.canStack = src.canStack;"
                        + " item.stackCount = 1;"
                        + " $1.a(item);"
                        + " $1.a(app.island.gs.p.a(depot));"
                        + " $1.a(app.island.gs.p.a(hero.user.treasure, hero.consumedTreasure));"
                        + " this.a($1, item, money, treasure);"
                        + "}");

        shop.writeFile(outDir);
    }
}
