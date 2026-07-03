/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.npc;

import app.island.GameObject;
import app.island.data.Goods;
import app.island.entity.Hero;
import app.island.gs.ServerInfo;
import app.island.gs.h;
import app.island.gs.npc.NpcScript;
import app.island.gs.w;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class GiftProvider
extends NpcScript {
    private daff.a.h char = new daff.a.h(20);
    private daff.a.h case = new daff.a.h(20);
    private daff.a.h goto = new daff.a.h(20);
    private daff.a.h else = new daff.a.h(20);

    public void init() {
    }

    public void processCommand(String string, h h2) {
        Hero hero = h2.r();
        if (string.equals("setupDaily")) {
            this.char.a();
            int n2 = 0;
            while (n2 < hero.personalDepot.shopCapacity) {
                if (hero.personalDepot.shopGoods[n2] != null) {
                    Goods goods = (Goods)GameObject.cloneObject(hero.personalDepot.shopGoods[n2]);
                    Goods goods2 = w.case().getGoods(goods.id);
                    goods.treasureCost = goods2.treasureCost;
                    goods.moneyCost = goods2.treasureCost;
                    this.char.if(goods);
                }
                ++n2;
            }
            h2.for("\u8bbe\u7f6e" + this.char.for() + "\u4e2a\u6bcf\u65e5\u793c\u54c1");
        } else if (string.equals("setup30")) {
            this.case.a();
            int n3 = 0;
            while (n3 < hero.personalDepot.shopCapacity) {
                if (hero.personalDepot.shopGoods[n3] != null) {
                    Goods goods = (Goods)GameObject.cloneObject(hero.personalDepot.shopGoods[n3]);
                    Goods goods3 = w.case().getGoods(goods.id);
                    goods.treasureCost = goods3.treasureCost;
                    goods.moneyCost = goods3.treasureCost;
                    this.case.if(goods);
                }
                ++n3;
            }
            h2.for("\u8bbe\u7f6e" + this.case.for() + "\u4e2a30\u7ea7\u793c\u54c1");
        } else if (string.equals("setup60")) {
            this.goto.a();
            int n4 = 0;
            while (n4 < hero.personalDepot.shopCapacity) {
                if (hero.personalDepot.shopGoods[n4] != null) {
                    Goods goods = (Goods)GameObject.cloneObject(hero.personalDepot.shopGoods[n4]);
                    Goods goods4 = w.case().getGoods(goods.id);
                    goods.treasureCost = goods4.treasureCost;
                    goods.moneyCost = goods4.treasureCost;
                    this.goto.if(goods);
                }
                ++n4;
            }
            h2.for("\u8bbe\u7f6e" + this.goto.for() + "\u4e2a60\u7ea7\u793c\u54c1");
        } else if (string.equals("setup90")) {
            this.else.a();
            int n5 = 0;
            while (n5 < hero.personalDepot.shopCapacity) {
                if (hero.personalDepot.shopGoods[n5] != null) {
                    Goods goods = (Goods)GameObject.cloneObject(hero.personalDepot.shopGoods[n5]);
                    Goods goods5 = w.case().getGoods(goods.id);
                    goods.treasureCost = goods5.treasureCost;
                    goods.moneyCost = goods5.treasureCost;
                    this.else.if(goods);
                }
                ++n5;
            }
            h2.for("\u8bbe\u7f6e" + this.else.for() + "\u4e2a90\u7ea7\u793c\u54c1");
        } else if (string.equals("getDailyGift")) {
            if (hero.level < 80) {
                h2.try("\u5fc5\u987b\u7b49\u7ea7\u8fbe\u523080\u7ea7\u4ee5\u540e\u624d\u53ef\u4ee5\u9886\u53d6\u6bcf\u65e5\u793c\u54c1");
            } else if (hero.user.getDailyGiftDay == ServerInfo.currentTimeParts[2]) {
                h2.try("\u4f60\u5df2\u7ecf\u9886\u53d6\u8fc7\u6bcf\u65e5\u793c\u54c1\u4e86\uff01");
            } else if (this.char.int()) {
                h2.try("\u76ee\u524d\u8fd8\u6ca1\u6709\u8bbe\u7f6e\u6bcf\u65e5\u793c\u54c1\uff0c\u8bf7\u4e0e\u6e38\u620f\u7ba1\u7406\u5458\u8054\u7cfb\u3002");
            } else if (hero.personalDepot.getNextFreePos() < 0) {
                h2.try("\u4f60\u7684\u80cc\u5305\u4e2d\u5df2\u6ee1\uff0c\u8bf7\u5148\u5c06\u80cc\u5305\u4e2d\u817e\u51fa\u7a7a\u95f2\u4f4d\u7f6e\u518d\u6765\u9886\u53d6\u3002");
            } else {
                int n6 = (int)((double)this.char.for() * Math.random());
                Goods goods = (Goods)this.char.if(n6);
                goods = (Goods)GameObject.cloneObject(goods);
                this.a.for().do().a(goods);
                h2.a(goods);
                hero.user.getDailyGiftDay = ServerInfo.currentTimeParts[2];
                h2.for("\u6211\u5df2\u5c06\u6bcf\u65e5\u793c\u54c1\u653e\u8fdb\u4f60\u7684\u80cc\u5305\u4e86\uff0c\u8bf7\u67e5\u6536\uff01");
            }
        } else if (string.equals("getLevel30Gift")) {
            if (hero.l80GiftGot > 0) {
                h2.try("\u4f60\u5df2\u7ecf\u9886\u53d6\u8fc730\u7ea7\u793c\u54c1\u4e86\uff01");
            } else if (hero.level < 80) {
                h2.try("\u4f60\u7684\u7b49\u7ea7\u8fd8\u6ca1\u6709\u8fbe\u523080\u7ea7\uff0c\u8bf7\u5148\u53bb\u5347\u7ea7\u5427\uff01");
            } else if (this.case.int()) {
                h2.try("\u76ee\u524d\u8fd8\u6ca1\u6709\u8bbe\u7f6e80\u7ea7\u793c\u54c1\uff0c\u8bf7\u4e0e\u6e38\u620f\u7ba1\u7406\u5458\u8054\u7cfb\u3002");
            } else if (hero.personalDepot.getNextFreePos() < 0) {
                h2.try("\u4f60\u7684\u80cc\u5305\u4e2d\u5df2\u6ee1\uff0c\u8bf7\u5148\u5c06\u80cc\u5305\u4e2d\u817e\u51fa\u7a7a\u95f2\u4f4d\u7f6e\u518d\u6765\u9886\u53d6\u3002");
            } else {
                int n7 = (int)((double)this.case.for() * Math.random());
                Goods goods = (Goods)this.case.if(n7);
                goods = (Goods)GameObject.cloneObject(goods);
                this.a.for().do().a(goods);
                h2.a(goods);
                hero.l80GiftGot = 1;
                h2.for("\u6211\u5df2\u5c0680\u7ea7\u793c\u54c1\u653e\u8fdb\u4f60\u7684\u80cc\u5305\u4e86\uff0c\u8bf7\u67e5\u6536\uff01");
            }
        } else if (string.equals("getLevel60Gift")) {
            if (hero.l100GiftGot > 0) {
                h2.try("\u4f60\u5df2\u7ecf\u9886\u53d6\u8fc760\u7ea7\u793c\u54c1\u4e86\uff01");
            } else if (hero.level < 100) {
                h2.try("\u4f60\u7684\u7b49\u7ea7\u8fd8\u6ca1\u6709\u8fbe\u5230100\u7ea7\uff0c\u8bf7\u5148\u53bb\u5347\u7ea7\u5427\uff01");
            } else if (this.goto.int()) {
                h2.try("\u76ee\u524d\u8fd8\u6ca1\u6709\u8bbe\u7f6e100\u7ea7\u793c\u54c1\uff0c\u8bf7\u4e0e\u6e38\u620f\u7ba1\u7406\u5458\u8054\u7cfb\u3002");
            } else if (hero.personalDepot.getNextFreePos() < 0) {
                h2.try("\u4f60\u7684\u80cc\u5305\u4e2d\u5df2\u6ee1\uff0c\u8bf7\u5148\u5c06\u80cc\u5305\u4e2d\u817e\u51fa\u7a7a\u95f2\u4f4d\u7f6e\u518d\u6765\u9886\u53d6\u3002");
            } else {
                int n8 = (int)((double)this.goto.for() * Math.random());
                Goods goods = (Goods)this.goto.if(n8);
                goods = (Goods)GameObject.cloneObject(goods);
                this.a.for().do().a(goods);
                h2.a(goods);
                hero.l100GiftGot = 1;
                h2.for("\u6211\u5df2\u5c06100\u7ea7\u793c\u54c1\u653e\u8fdb\u4f60\u7684\u80cc\u5305\u4e86\uff0c\u8bf7\u67e5\u6536\uff01");
            }
        } else if (string.equals("getLevel90Gift")) {
            if (hero.l120GiftGot > 0) {
                h2.try("\u4f60\u5df2\u7ecf\u9886\u53d6\u8fc790\u7ea7\u793c\u54c1\u4e86\uff01");
            } else if (hero.level < 120) {
                h2.try("\u4f60\u7684\u7b49\u7ea7\u8fd8\u6ca1\u6709\u8fbe\u5230120\u7ea7\uff0c\u8bf7\u5148\u53bb\u5347\u7ea7\u5427\uff01");
            } else if (this.goto.int()) {
                h2.try("\u76ee\u524d\u8fd8\u6ca1\u6709\u8bbe\u7f6e120\u7ea7\u793c\u54c1\uff0c\u8bf7\u4e0e\u6e38\u620f\u7ba1\u7406\u5458\u8054\u7cfb\u3002");
            } else if (hero.personalDepot.getNextFreePos() < 0) {
                h2.try("\u4f60\u7684\u80cc\u5305\u4e2d\u5df2\u6ee1\uff0c\u8bf7\u5148\u5c06\u80cc\u5305\u4e2d\u817e\u51fa\u7a7a\u95f2\u4f4d\u7f6e\u518d\u6765\u9886\u53d6\u3002");
            } else {
                int n9 = (int)((double)this.else.for() * Math.random());
                Goods goods = (Goods)this.else.if(n9);
                goods = (Goods)GameObject.cloneObject(goods);
                this.a.for().do().a(goods);
                h2.a(goods);
                hero.l120GiftGot = 1;
                h2.for("\u6211\u5df2\u5c06120\u7ea7\u793c\u54c1\u653e\u8fdb\u4f60\u7684\u80cc\u5305\u4e86\uff0c\u8bf7\u67e5\u6536\uff01");
            }
        }
    }

    public String getResponseDailogEntry(h h2) {
        if (h2.q() > 1) {
            return "setup";
        }
        return "start";
    }
}

