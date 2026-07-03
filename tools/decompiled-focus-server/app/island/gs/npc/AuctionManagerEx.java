/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.npc;

import app.island.data.Goods;
import app.island.entity.Hero;
import app.island.gs.ServerInfo;
import app.island.gs.h;
import app.island.gs.npc.NpcScript;
import app.island.gs.p;
import app.island.gs.q;
import app.island.gs.w;
import daff.a.b;
import daff.a.l;
import daff.a.q;

public class AuctionManagerEx
extends NpcScript {
    private q u = new q();
    private Hero p;
    private Goods s;
    private long w;
    private long v;
    private int r;
    private int t;
    private Hero o;
    private String q;

    public void update() {
        if (this.s == null) {
            return;
        }
        if (ServerInfo.currentMilliSecond - this.v > 120000L) {
            int n2;
            if (this.o == null) {
                this.q = "[" + this.s.name + "]\u62cd\u5356\u7ed3\u675f\uff0c\u672c\u6b21\u62cd\u5356\u6ca1\u6709\u6210\u4ea4";
                int n3 = this.p.personalDepot.getNextFreePos();
                if (n3 >= 0) {
                    Goods goods = app.island.gs.w.case().getGoods(this.s.id);
                    this.s.moneyCost = goods.moneyCost;
                    this.s.treasureCost = goods.treasureCost;
                    this.p.personalDepot.goodsList[n3] = this.s;
                    if (this.p.attachment != null) {
                        ((h)this.p.attachment).a(app.island.gs.p.a(n3, this.s));
                    }
                }
                if ((n2 = this.s.moneyCost / 20) <= 0) {
                    n2 = 100;
                }
                if (n2 > this.p.personalDepot.money) {
                    n2 = this.p.personalDepot.money;
                }
                this.p.personalDepot.money -= n2;
                if (this.p.attachment != null) {
                    ((h)this.p.attachment).a(app.island.gs.p.case(this.p));
                }
            } else {
                this.q = "[" + this.s.name + "]\u62cd\u5356\u7ed3\u675f\uff0c\u606d\u559c\u3010" + this.o.name + "\u3011\u4ee5" + this.t + "\u91d1\u5e01\u4e70\u5230\u4e86[" + this.s.name + "]\uff01";
                this.a.for().a(app.island.gs.p.char(this.o.id, 4, 5));
                Goods goods = app.island.gs.w.case().getGoods(this.s.id);
                this.a.for().do().a(goods);
                if (this.o.attachment != null) {
                    ((h)this.o.attachment).a(goods);
                } else {
                    n2 = this.o.personalDepot.getNextFreePos();
                    if (n2 >= 0) {
                        this.o.personalDepot.goodsList[n2] = goods;
                    }
                }
                this.u.a(this.o.name);
                this.p.personalDepot.money += this.t * 95 / 100;
                if (this.p.attachment != null) {
                    ((h)this.p.attachment).a(app.island.gs.p.case(this.p));
                }
            }
            this.a.for().if(app.island.gs.p.d(this.q));
            l l2 = this.u.a().do();
            while (l2.a()) {
                String string = (String)l2.if();
                int[] nArray = (int[])this.u.a(string);
                Hero hero = this.a.for().do().long().new(string);
                if (nArray == null || hero == null) continue;
                hero.personalDepot.money += nArray[0];
                if (hero.attachment == null) continue;
                ((h)hero.attachment).a(app.island.gs.p.case(hero));
                ((h)hero.attachment).for("\u7cfb\u7edf\u5df2\u9000\u56de\u4f60\u53c2\u4e0e\u62cd\u5356\u7684\u91d1\u5e01,\u8bf7\u67e5\u6536");
            }
            this.t = 0;
            this.p = null;
            this.o = null;
            this.s = null;
        } else if (this.o == null) {
            if (ServerInfo.currentMilliSecond - this.w > 20000L) {
                this.a.for().do().a(app.island.gs.p.d(this.q));
                this.w = ServerInfo.currentMilliSecond;
            }
        } else if (ServerInfo.currentMilliSecond - this.w > 20000L) {
            this.q = "\u7ade\u8d2d[" + this.s.name + "]\u7684\u6700\u9ad8\u4ef7\u662f" + this.t + "\uff0c\u5269\u4f59\u65f6\u95f4\u8fd8\u6709" + (120L - (ServerInfo.currentMilliSecond - this.v) / 1000L) + "\u79d2";
            this.a.for().if(app.island.gs.p.d(this.q));
            this.w = ServerInfo.currentMilliSecond;
        }
    }

    public void init() {
    }

    public void processCommand(String string, h h2) {
        int[] nArray;
        Hero hero = h2.r();
        if (string.equals("start")) {
            if (this.s != null) {
                h2.for("\u4e0d\u597d\u610f\u601d\uff0c\u4f60\u6765\u665a\u4e86\uff0c\u5df2\u7ecf\u6709\u5176\u4ed6\u73a9\u5bb6\u5728\u4f60\u4e4b\u524d\u59d4\u6258\u6211\u62cd\u5356\u7269\u54c1\u4e86");
            } else {
                Goods goods = hero.personalDepot.shopGoods[0];
                int n2 = hero.personalDepot.getNextFreePos();
                if (goods == null || n2 < 0) {
                    this.a.a("noGoods", h2);
                } else {
                    this.p = hero;
                    h2.a(app.island.gs.p.do(0, n2, 0, 0));
                    h2.a(app.island.gs.p.e(n2));
                    hero.personalDepot.shopGoods[0] = null;
                    this.s = goods;
                    this.q = "\u73b0\u5728\u62cd\u5356[" + this.s.name + "],\u8d77\u70b9\u4ef7" + this.s.moneyCost + "\u91d1\u5e01,\u8bf7\u5927\u5bb6\u6765" + this.a.for().int() + "(" + this.a.byte() + "," + this.a.if() + ")\u53c2\u52a0\u7ade\u8d2d\u5427\uff01";
                    this.a.for().do().a(app.island.gs.p.d(this.q));
                    this.t = this.s.moneyCost;
                    this.r = Math.max(100, this.t / 20);
                    this.w = this.v = ServerInfo.currentMilliSecond;
                }
            }
        } else if (string.startsWith("price:")) {
            String[] stringArray = b.a(string, ":");
            int n3 = Integer.parseInt(stringArray[1]);
            if (n3 <= this.t) {
                h2.for("\u4f60\u52a8\u4f5c\u6162\u4e86\u4e00\u6b65\uff0c\u73b0\u5728\u6700\u65b0\u7684\u4ef7\u683c\u662f" + this.t + "\uff0c\u4f60\u5fc5\u987b\u51fa\u66f4\u9ad8\u7684\u4ef7\u683c");
            } else {
                int[] nArray2 = (int[])this.u.for(h2.b());
                int n4 = n3;
                if (nArray2 != null) {
                    n4 = n3 - nArray2[0];
                }
                if (hero.personalDepot.money >= n4) {
                    hero.personalDepot.money -= n4;
                    h2.a(app.island.gs.p.case(hero));
                    if (nArray2 != null) {
                        nArray2[0] = n3;
                    } else {
                        this.u.a((Object)hero.name, (Object)new int[]{n3});
                    }
                    this.q = "\u73b0\u5728\u3010" + hero.name + "\u3011\u7ed9\u51fa" + n3 + "\u91d1\u5e01\u6765\u7ade\u8d2d[" + this.s.name + "]\uff0c\u771f\u662f\u5927\u624b\u7b14\u554a\uff01";
                    this.a.for().do().a(app.island.gs.p.d(this.q));
                    this.a.for().if(app.island.gs.p.char(hero.id, 5, 1));
                    this.w = this.v = ServerInfo.currentMilliSecond;
                    this.o = hero;
                    this.t = n3;
                } else {
                    h2.for("\u4f60\u7684\u91d1\u5e01\u4e0d\u8db3");
                }
            }
        } else if (string.equals("getMoney") && (nArray = (int[])this.u.a(h2.b())) != null) {
            h2.new(nArray[0]);
        }
    }

    public String getResponseDailogEntry(h h2) {
        if (this.s != null) {
            if (this.o == h2.r()) {
                return "lastBuyer";
            }
            q.d d2 = this.a.a("auction");
            d2.int = this.o != null && this.u.do(h2.b()) ? "\u73b0\u5728\u3010" + this.o.name + "\u3011\u7ed9\u51fa\u4e86" + this.t + "\u7684\u4ef7\u683c\uff0c\u4f60\u8981\u7ee7\u7eed\u51fa\u66f4\u9ad8\u7684\u4ef7\u683c\u5417\uff1f" : "\u6211\u73b0\u5728\u6b63\u5728\u62cd\u5356[" + this.s.name + "]\uff0c\u5f53\u524d\u4ef7\u683c\u662f" + this.t + "\u91d1\u5e01\uff0c\u4f60\u6709\u5174\u8da3\u53c2\u4e0e\u7ade\u4ef7\u5417\uff1f";
            int n2 = this.t + this.r;
            int n3 = 0;
            do {
                d2.do[n3] = "\u6211\u51fa" + n2 + "\u91d1\u5e01";
                d2.a[n3] = "price:" + n2;
                n2 += this.r;
            } while (++n3 < 5);
            return "auction";
        }
        if (this.u.do(h2.b())) {
            return "getMoney";
        }
        return "noAuction";
    }
}

