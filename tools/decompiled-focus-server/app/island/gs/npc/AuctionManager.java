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
import app.island.gs.p;
import app.island.gs.q;
import app.island.gs.w;
import daff.a.b;
import daff.a.q;

public class AuctionManager
extends NpcScript {
    private q n = new q();
    private Goods i;
    private long k;
    private long l;
    private int m;
    private int j;
    private Hero h;
    private String g;

    public void update() {
        if (this.i == null) {
            return;
        }
        if (ServerInfo.currentMilliSecond - this.l > 120000L) {
            Object object;
            if (this.h == null) {
                this.g = "[" + this.i.name + "]\u62cd\u5356\u7ed3\u675f\uff0c\u672c\u6b21\u62cd\u5356\u6ca1\u6709\u6210\u4ea4";
            } else {
                this.g = "[" + this.i.name + "]\u62cd\u5356\u7ed3\u675f\uff0c\u606d\u559c\u3010" + this.h.name + "\u3011\u4ee5" + this.j + "\u91d1\u5e01\u4e70\u5230\u4e86[" + this.i.name + "]\uff01";
                this.a.for().do().a(p.char(this.h.id, 4, 5));
                object = w.case().getGoods(this.i.id);
                this.i = (Goods)GameObject.cloneObject((GameObject)object);
                this.a.for().do().a(this.i);
                if (this.h.attachment != null) {
                    ((h)this.h.attachment).a(this.i);
                } else {
                    int n2 = this.h.personalDepot.getNextFreePos();
                    if (n2 >= 0) {
                        this.h.personalDepot.goodsList[n2] = this.i;
                    }
                }
                this.n.a(this.h.name);
            }
            this.a.for().do().a(p.d(this.g));
            object = this.n.a().do();
            while (object.a()) {
                String string = (String)object.if();
                int[] nArray = (int[])this.n.a(string);
                Hero hero = this.a.for().do().long().new(string);
                if (nArray == null || hero == null) continue;
                hero.personalDepot.money += nArray[0];
                if (hero.attachment == null) continue;
                ((h)hero.attachment).a(p.case(hero));
                ((h)hero.attachment).for("\u7cfb\u7edf\u5df2\u9000\u56de\u4f60\u53c2\u4e0e\u62cd\u5356\u7684\u91d1\u5e01,\u8bf7\u67e5\u6536");
            }
            this.j = 0;
            this.h = null;
            this.i = null;
        } else if (this.h == null) {
            if (ServerInfo.currentMilliSecond - this.k > 10000L) {
                this.a.for().do().a(p.d(this.g));
                this.k = ServerInfo.currentMilliSecond;
            }
        } else if (ServerInfo.currentMilliSecond - this.k > 20000L) {
            this.g = "\u7ade\u8d2d[" + this.i.name + "]\u7684\u6700\u9ad8\u4ef7\u662f" + this.j + "\uff0c\u5269\u4f59\u65f6\u95f4\u8fd8\u6709" + (120L - (ServerInfo.currentMilliSecond - this.l) / 1000L) + "\u79d2";
            this.a.for().a(p.void(this.g));
            this.k = ServerInfo.currentMilliSecond;
        }
    }

    public void init() {
    }

    public void processCommand(String string, h h2) {
        int[] nArray;
        Hero hero = h2.r();
        if (string.equals("start") && hero.gmGrade > 1) {
            if (this.i != null) {
                return;
            }
            Goods goods = hero.personalDepot.shopGoods[0];
            if (goods == null) {
                this.a.a("noGoods", h2);
            } else {
                this.i = (Goods)GameObject.cloneObject(goods);
                this.g = "\u73b0\u5728\u62cd\u5356[" + this.i.name + "],\u8d77\u70b9\u4ef7" + this.i.moneyCost + "\u91d1\u5e01,\u8bf7\u5927\u5bb6\u6765" + this.a.for().int() + "(" + this.a.byte() + "," + this.a.if() + ")\u53c2\u52a0\u7ade\u8d2d\u5427\uff01";
                this.a.for().do().a(p.d(this.g));
                this.j = this.i.moneyCost;
                this.m = Math.max(100, this.j / 20);
                this.k = ServerInfo.currentMilliSecond;
                this.l = ServerInfo.currentMilliSecond;
            }
        } else if (string.startsWith("price:")) {
            String[] stringArray = b.a(string, ":");
            int n2 = Integer.parseInt(stringArray[1]);
            if (n2 <= this.j) {
                h2.for("\u4f60\u52a8\u4f5c\u6162\u4e86\u4e00\u6b65\uff0c\u73b0\u5728\u6700\u65b0\u7684\u4ef7\u683c\u662f" + this.j + "\uff0c\u4f60\u5fc5\u987b\u51fa\u66f4\u9ad8\u7684\u4ef7\u683c");
            } else {
                int[] nArray2 = (int[])this.n.for(h2.b());
                int n3 = n2;
                if (nArray2 != null) {
                    n3 = n2 - nArray2[0];
                }
                if (hero.personalDepot.money >= n3) {
                    hero.personalDepot.money -= n3;
                    h2.a(p.case(hero));
                    if (nArray2 != null) {
                        nArray2[0] = n2;
                    } else {
                        this.n.a((Object)hero.name, (Object)new int[]{n2});
                    }
                    this.g = "\u73b0\u5728\u3010" + hero.name + "\u3011\u7ed9\u51fa" + n2 + "\u91d1\u5e01\u6765\u7ade\u8d2d[" + this.i.name + "]\uff0c\u771f\u662f\u5927\u624b\u7b14\u554a\uff01";
                    this.a.for().a(p.void(this.g));
                    this.a.for().a(p.char(hero.id, 5, 1), hero.x, hero.y, null);
                    this.k = this.l = ServerInfo.currentMilliSecond;
                    this.h = hero;
                    this.j = n2;
                } else {
                    h2.for("\u4f60\u7684\u91d1\u5e01\u4e0d\u8db3");
                }
            }
        } else if (string.equals("getMoney") && (nArray = (int[])this.n.a(h2.b())) != null) {
            h2.new(nArray[0]);
        }
    }

    public String getResponseDailogEntry(h h2) {
        if (h2.q() > 1) {
            return "start";
        }
        if (this.i != null) {
            if (this.h == h2.r()) {
                return "lastBuyer";
            }
            q.d d2 = this.a.a("auction");
            d2.int = this.h != null && this.n.do(h2.b()) ? "\u73b0\u5728\u3010" + this.h.name + "\u3011\u7ed9\u51fa\u4e86" + this.j + "\u7684\u4ef7\u683c\uff0c\u4f60\u8981\u7ee7\u7eed\u51fa\u66f4\u9ad8\u7684\u4ef7\u683c\u5417\uff1f" : "\u6211\u73b0\u5728\u6b63\u5728\u62cd\u5356[" + this.i.name + "]\uff0c\u5f53\u524d\u4ef7\u683c\u662f" + this.j + "\u91d1\u5e01\uff0c\u4f60\u6709\u5174\u8da3\u53c2\u4e0e\u7ade\u4ef7\u5417\uff1f";
            int n2 = this.j + this.m;
            int n3 = 0;
            do {
                d2.do[n3] = "\u6211\u51fa" + n2 + "\u91d1\u5e01";
                d2.a[n3] = "price:" + n2;
                n2 += this.m;
            } while (++n3 < 5);
            return "auction";
        }
        if (this.n.do(h2.b())) {
            return "getMoney";
        }
        return "noAuction";
    }
}

