/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs;

import app.b.b;
import app.island.GameObject;
import app.island.data.Depot;
import app.island.data.Goods;
import app.island.entity.Hero;
import app.island.entity.Player;
import app.island.gs.ServerInfo;
import app.island.gs.e;
import app.island.gs.h;
import app.island.gs.k;
import app.island.gs.p;
import app.island.gs.w;
import app.island.gs.x;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class v
extends k {
    private h f;
    private int int;
    private String do = "";
    private int i = 100;
    private int d = 40;
    private Goods[] g;
    private int e = 80;
    private boolean h = true;
    private x for;

    public void char(int n2) {
        this.d = n2;
        this.a(p.int(this.i, this.d));
    }

    public h i() {
        return this.f;
    }

    public boolean h() {
        return this.h;
    }

    public int try() {
        return this.int;
    }

    public void do(int n2) {
        this.int = n2;
    }

    public int j() {
        return this.e;
    }

    public x do() {
        return this.for;
    }

    public void a(x x2) {
        this.for = x2;
    }

    public void k() {
        this.h = false;
        int n2 = this.a.for();
        b b2 = p.f();
        int n3 = 0;
        while (n3 < n2) {
            h h2 = (h)this.a.if(n3);
            h2.a((v)null);
            h2.a(b2);
            ++n3;
        }
        this.a.a();
    }

    public void a(Goods goods) {
        int n2 = 0;
        while (n2 < this.g.length) {
            if (this.g[n2] == null) {
                this.g[n2] = goods;
                this.a(p.do(n2, goods));
                break;
            }
            ++n2;
        }
    }

    public void case(h h2, int n2) {
        Depot depot = h2.r().personalDepot;
        int n3 = depot.getGoodsPosByID(n2);
        if (depot.getGoodsCount() == 32 && n3 == -1) {
            return;
        }
        if (n3 == -1) {
            int n4 = 0;
            while (n4 < this.g.length) {
                if (this.g[n4].id == n2) {
                    this.else(h2, n4);
                    break;
                }
                ++n4;
            }
        }
        n3 = depot.getGoodsPosByID(n2);
        h2.j().O().a(h2, n3);
    }

    public void byte() {
    }

    public String int() {
        return this.do;
    }

    public void a(String string) {
        this.do = string;
    }

    public void if(h h2, String string) {
        this.f = h2;
        this.for = h2.j().do();
        this.int = h2.H();
        this.do = string;
        this.if = 8;
        this.a = new daff.a.h(8);
        this.i = 100;
        this.d = 100;
        Hero hero = h2.r();
        this.e = hero.personalDepot.shopCapacity;
        this.g = hero.personalDepot.shopGoods;
    }

    public void byte(int n2) {
        int n3 = 0;
        while (n3 < this.g.length) {
            if (this.g[n3] != null && this.g[n3].id == n2) {
                this.g[n3] = null;
                this.a(p.j(n3));
                break;
            }
            ++n3;
        }
    }

    protected void a(h h2, Goods goods, int n2, int n3) {
        int n4;
        Object object;
        if (n3 > 0 || this.f != null) {
            object = h2.r();
            if (((Player)object).gmGrade <= 0) {
                int n5 = n4 = n3 != 0 ? n3 : n2;
                if (this.f == null) {
                    h2.j().do().long().saveUserLog(((Hero)object).user.name, ((GameObject)object).name, "buy", "goodsID=" + goods.id + ";cost=" + n4);
                } else if (n3 > 0) {
                    h2.j().do().long().saveUserLog(((Hero)object).user.name, ((GameObject)object).name, "personalShopBuy", "goodsID=" + goods.id + ";treasureCost=" + n3);
                    h2.j().do().long().saveUserLog(this.f.r().user.name, this.f.b(), "personalShopSell", "goodsID=" + goods.id + ";treasureCost=" + n3);
                }
                StringBuffer stringBuffer = new StringBuffer(64);
                stringBuffer.append("\u9053\u5177\u9500\u552e[\u5546\u5e97=");
                if (this.f != null) {
                    stringBuffer.append("\u73a9\u5bb6\u5546\u5e97:");
                    stringBuffer.append(this.f.b());
                } else {
                    stringBuffer.append(this.do);
                }
                stringBuffer.append(";\u987e\u5ba2=");
                stringBuffer.append(((GameObject)object).name);
                stringBuffer.append(";\u7269\u54c1=");
                stringBuffer.append(goods.name);
                if (n3 > 0) {
                    stringBuffer.append(";\u5143\u5b9d\u4ef7\u683c=");
                } else {
                    stringBuffer.append(";\u91d1\u5e01\u4ef7\u683c=");
                }
                stringBuffer.append(n4);
                stringBuffer.append(']');
                b b2 = p.void(stringBuffer.toString());
                this.for.c().a(b2);
            }
        }
        if (this.f == null && n3 > 0 && h2.l() != null && (object = (h)h2.l().attachment) != null) {
            n4 = h2.r().friendList.master.closeness * n3 / 10000;
            ((h)object).r().tmpTreasure += n4;
            n4 = ((h)object).r().tmpTreasure / 10;
            ((h)object).try(n4);
            ((h)object).r().tmpTreasure %= 10;
        }
    }

    private void else(h h2, int n2) {
        if (!h2.g() || n2 >= this.e) {
            return;
        }
        Goods goods = this.g[n2];
        if (goods == null) {
            h2.try("\u4f60\u8981\u8d2d\u4e70\u7684\u7269\u54c1\u4e0d\u5b58\u5728\uff0c\u53ef\u80fd\u5df2\u7ecf\u88ab\u5220\u9664\uff0c\u8bf7\u91cd\u65b0\u6253\u5f00\u5546\u5e97");
            return;
        }
        Hero hero = h2.r();
        int n3 = hero.personalDepot.getNextFreePos();
        if (n3 < 0) {
            h2.try("\u80cc\u5305\u4e2d\u6ca1\u6709\u66f4\u591a\u7684\u7a7a\u95f4\u6765\u653e\u7f6e\u7269\u54c1\u4e86");
            return;
        }
        int n4 = 0;
        int n5 = 0;
        if (goods.treasureCost > 0) {
            n4 = (int)((long)goods.treasureCost * 1L * (long)this.i / 100L);
            if (n4 <= 0) {
                h2.new("\u65e0\u6cd5\u8d2d\u4e70\u8be5\u7269\u54c1\uff0c\u5143\u5b9d\u4ef7\u683c\u4e3a0");
                return;
            }
            if (hero.user.treasure < n4) {
                h2.try("\u4f60\u7684\u5143\u5b9d\u4f59\u989d\u4e0d\u8db3\uff0c\u8bf7\u5145\u503c");
                return;
            }
            hero.user.treasure -= n4;
            hero.consumedTreasure += n4;
            hero.user.consumedTreasure += n4;
            ServerInfo.consumedTreasure += n4;
            this.for.a(hero, 15);
        } else {
            n5 = (int)((long)goods.moneyCost * 1L * (long)this.i / 100L);
            if (n5 <= 0) {
                h2.new("\u65e0\u6cd5\u8d2d\u4e70\u8be5\u7269\u54c1\uff0c\u91d1\u5e01\u4ef7\u683c\u4e3a0");
                return;
            }
            if (hero.personalDepot.money < n5) {
                h2.try("\u4f60\u7684\u91d1\u5e01\u4f59\u989d\u4e0d\u8db3");
                return;
            }
            hero.personalDepot.money -= n5;
        }
        if (this.f != null) {
            int n6 = ServerInfo.personalShopTaxRate;
            e e2 = h2.j().p();
            if (e2 != null) {
                n6 = e2.e().cityTaxRate;
            }
            if (n6 > 0 && n6 < 100) {
                int n7;
                long l2 = 100 - n6;
                if (n5 > 100) {
                    n7 = (int)((long)n5 * l2 / 100L);
                    if (e2 != null) {
                        e2.a(n5 - n7, 0, 0);
                    }
                    n5 = n7;
                }
                if (n4 > 5) {
                    n7 = (int)((long)n4 * l2 / 100L);
                    if (e2 != null) {
                        e2.a(0, n4 - n7, 0);
                    }
                    n4 = n7;
                }
            }
            Hero hero2 = this.f.r();
            hero2.personalDepot.money += n5;
            hero2.user.treasure += n4;
            hero2.user.earnedTreasure += n4;
            hero2.earnedTreasure += n4;
            this.f.a(p.a(n2, n5, n4, h2.b()));
            this.g[n2] = null;
            this.a(p.j(n2));
            Goods goods2 = Goods.getGlobalGoods(goods.id);
            goods.moneyCost = goods2.moneyCost;
            goods.treasureCost = goods2.treasureCost;
        } else {
            e e3;
            goods = (Goods)GameObject.cloneObject(goods);
            this.for.a(goods);
            if (h2.r().gmGrade == 0 && (e3 = h2.j().p()) != null) {
                e3.a(n5 / 100, 0, n4);
            }
        }
        h2.a(goods);
        h2.a(p.case(hero));
        this.a(h2, goods, n5, n4);
    }

    public int l() {
        return this.i;
    }

    public void try(int n2) {
        this.i = n2;
        this.a(p.int(this.i, this.d));
    }

    public int byte(h h2, int n2) {
        int n3 = 0;
        while (n3 < this.g.length) {
            if (this.g[n3] != null && this.g[n3].id == n2) {
                this.else(h2, n3);
                break;
            }
            ++n3;
        }
        return h2.r().personalDepot.getGoodsPosByID(n2);
    }

    public void a(boolean bl) {
        this.h = bl;
    }

    public void byte(String string) {
        this.if = 8;
        this.a = new daff.a.h(8);
        String[] stringArray = daff.a.b.a(string, "\r\n");
        this.int = Integer.parseInt(stringArray[0]);
        this.do = stringArray[1];
        this.i = Integer.parseInt(stringArray[2]);
        this.d = Integer.parseInt(stringArray[3]);
        int n2 = 0;
        this.g = new Goods[this.e];
        int n3 = 4;
        while (n3 < stringArray.length) {
            if (stringArray[n3].length() < 8) break;
            int n4 = Integer.parseInt(stringArray[n3]);
            Goods goods = w.case().getGoods(n4);
            if (goods == null) {
                System.out.println("goods not found:" + n4 + ";shop id:" + this.try());
            } else {
                this.g[n2++] = goods;
            }
            ++n3;
        }
    }

    public void a(int n2, daff.a.e e2, h h2) {
        if (!this.h) {
            return;
        }
        if (n2 == 1281) {
            int n3 = e2.for();
            this.else(h2, n3);
        } else if (n2 == 1282) {
            int n4 = e2.case();
            this.char(h2, n4);
        } else if (n2 == 1283) {
            h2.a((v)null);
            this.do(h2);
        }
    }

    public Goods new(int n2) {
        return this.g[n2];
    }

    public String g() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        return stringBuffer.toString();
    }

    public void int(int n2) {
        if (n2 >= 0 && n2 < this.e) {
            this.g[n2] = null;
            this.a(p.j(n2));
        }
    }

    public Goods case(int n2) {
        int n3 = 0;
        while (n3 < this.g.length) {
            if (this.g[n3] != null && this.g[n3].id == n2) {
                return this.g[n3];
            }
            ++n3;
        }
        return null;
    }

    protected void a(h h2, Goods goods) {
    }

    private void char(h h2, int n2) {
        if (!h2.g() || this.f != null) {
            return;
        }
        Depot depot = h2.r().personalDepot;
        if (n2 < 0 || n2 >= depot.goodsList.length) {
            h2.try("\u975e\u6cd5\u7684\u80cc\u5305\u4f4d\u7f6e\uff1a" + n2);
        } else if (depot.goodsList[n2] == null) {
            h2.try("\u80cc\u5305\u4e2d\u8be5\u4f4d\u7f6e\u5e76\u6ca1\u6709\u7269\u54c1\uff1a" + n2);
        } else if (depot.goodsList[n2].soldable == 0) {
            h2.try("\u8be5\u7269\u54c1\u4e0d\u80fd\u88ab\u51fa\u552e");
        } else if (depot.goodsList[n2].moneyCost <= 0) {
            h2.try("\u4f60\u4e0d\u80fd\u51fa\u552e\u8be5\u7269\u54c1\uff0c\u4ef7\u503c\u4e3a0");
        } else {
            Goods goods = depot.goodsList[n2];
            int n3 = this.d * Goods.getGlobalGoods((int)goods.id).moneyCost / 100;
            h2.new(n3);
            h2.long(n2);
            this.a(h2, goods);
        }
    }

    public void j(h h2) {
        if (h2.int() != null) {
            return;
        }
        h2.a(this);
        b b2 = p.a(this);
        h2.a(b2);
        this.if(h2);
    }

    public int m() {
        return this.d;
    }
}

