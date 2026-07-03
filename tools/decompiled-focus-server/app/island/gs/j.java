/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs;

import app.island.data.Goods;
import app.island.entity.Hero;
import app.island.gs.c;
import app.island.gs.h;
import app.island.gs.p;
import app.island.gs.u;
import daff.a.b;
import daff.a.e;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class j {
    private u if;
    private h a;
    private Goods[] int = new Goods[16];
    private int byte;
    private boolean char;
    private h new;
    private Goods[] for = new Goods[16];
    private int try;
    private boolean case;
    private boolean do;

    private void if(h h2, int n2) {
        Hero hero = h2.r();
        if (n2 < 0 || n2 >= hero.personalDepot.goodsList.length) {
            return;
        }
        Goods goods = hero.personalDepot.goodsList[n2];
        if (goods == null || goods.tradable == 0) {
            return;
        }
        if (h2 == this.a) {
            int n3 = this.a(this.int);
            if (n3 < 0) {
                return;
            }
            this.int[n3] = goods;
            this.a.a(p.j(n2, n3));
            this.new.a(p.if(n3, goods));
        } else if (h2 == this.new) {
            int n4 = this.a(this.for);
            if (n4 < 0) {
                return;
            }
            this.for[n4] = goods;
            this.new.a(p.j(n2, n4));
            this.a.a(p.if(n4, goods));
        }
        this.case = false;
        this.char = false;
        hero.personalDepot.goodsList[n2] = null;
    }

    private void if(h h2) {
        if (h2 == this.a) {
            this.if();
            this.new.a(p.a("\u5bf9\u65b9\u53d6\u6d88\u4e86\u4ea4\u6613"));
        } else if (h2 == this.new) {
            this.if();
            this.a.a(p.a("\u5bf9\u65b9\u53d6\u6d88\u4e86\u4ea4\u6613"));
        }
    }

    public j(h h2, h h3) {
        this.if = h2.j();
        this.a = h2;
        this.new = h3;
        h2.a(this);
        h3.a(this);
        this.do = true;
    }

    private void a(h h2) {
        if (h2 == this.a) {
            this.char = true;
            this.new.a(p.try());
        } else {
            this.case = true;
            this.a.a(p.try());
        }
        if (this.char && this.case) {
            this.do();
        }
    }

    private void do(h h2, int n2) {
        if (n2 <= 0) {
            return;
        }
        this.case = false;
        this.char = false;
        Hero hero = h2.r();
        if (h2 == this.a) {
            int n3 = this.byte + hero.personalDepot.money;
            if (n2 > n3) {
                h2.try("\u4f60\u5e76\u6ca1\u8fd9\u4e48\u591a\u91d1\u5e01");
                return;
            }
            hero.personalDepot.money = n3 - n2;
            this.byte = n2;
            h2.a(p.new(n2, hero.personalDepot.money));
            this.new.a(p.case(n2));
        } else if (h2 == this.new) {
            int n4 = this.try + hero.personalDepot.money;
            if (n2 > n4) {
                h2.try("\u4f60\u5e76\u6ca1\u8fd9\u4e48\u591a\u91d1\u5e01");
                return;
            }
            hero.personalDepot.money = n4 - n2;
            this.try = n2;
            h2.a(p.new(n2, hero.personalDepot.money));
            this.a.a(p.case(n2));
        }
    }

    public void a(h h2, int n2, e e2) {
        if (!this.do || h2 != this.a && h2 != this.new) {
            return;
        }
        switch (n2) {
            case 2049: {
                this.if(h2, e2.for());
                break;
            }
            case 2051: {
                this.a(h2, e2.for());
                break;
            }
            case 2050: {
                this.do(h2, e2.i());
                break;
            }
            case 2052: {
                this.if(h2);
                break;
            }
            case 2053: {
                this.a(h2);
                break;
            }
        }
    }

    public void for() {
        if (!this.do) {
            return;
        }
        if (!this.a.goto()) {
            this.if();
            this.new.a(p.a("\u5bf9\u65b9\u5df2\u7ecf\u4e0b\u7ebf\uff0c\u53d6\u6d88\u4ea4\u6613"));
        } else if (this.a.i()) {
            this.if();
            this.a.a(p.a("\u4f60\u5df2\u7ecf\u6b7b\u4ea1\uff0c\u53d6\u6d88\u4ea4\u6613"));
            this.new.a(p.a("\u5bf9\u65b9\u5df2\u7ecf\u6b7b\u4ea1\uff0c\u53d6\u6d88\u4ea4\u6613"));
        } else if (!this.new.goto()) {
            this.if();
            this.a.a(p.a("\u5bf9\u65b9\u5df2\u7ecf\u4e0b\u7ebf\uff0c\u53d6\u6d88\u4ea4\u6613"));
        } else if (this.new.i()) {
            this.if();
            this.a.a(p.a("\u5bf9\u65b9\u5df2\u7ecf\u6b7b\u4ea1\uff0c\u53d6\u6d88\u4ea4\u6613"));
            this.new.a(p.a("\u4f60\u5df2\u7ecf\u6b7b\u4ea1\uff0c\u53d6\u6d88\u4ea4\u6613"));
        } else if (this.a.j() != this.new.j()) {
            this.if();
            this.a.a(p.a("\u53cc\u65b9\u4e0d\u5728\u540c\u4e00\u573a\u666f\uff0c\u53d6\u6d88\u4ea4\u6613"));
            this.new.a(p.a("\u53cc\u65b9\u4e0d\u5728\u540c\u4e00\u573a\u666f\uff0c\u53d6\u6d88\u4ea4\u6613"));
        } else if (!this.a.j().a(this.a.m(), this.a.o(), this.new.m(), this.new.o())) {
            this.if();
            this.a.a(p.a("\u53cc\u65b9\u8ddd\u79bb\u592a\u8fdc\uff0c\u53d6\u6d88\u4ea4\u6613"));
            this.new.a(p.a("\u53cc\u65b9\u8ddd\u79bb\u592a\u8fdc\uff0c\u53d6\u6d88\u4ea4\u6613"));
        }
    }

    private void a(h h2, int n2) {
        if (n2 < 0 || n2 >= this.int.length) {
            return;
        }
        Hero hero = h2.r();
        h h3 = this.new;
        if (h2 == this.a) {
            Goods goods = this.int[n2];
            if (goods == null) {
                return;
            }
            int n3 = hero.personalDepot.getNextFreePos();
            if (n3 < 0) {
                h2.try("\u80cc\u5305\u7a7a\u95f4\u4e0d\u8db3");
                return;
            }
            this.int[n2] = null;
            hero.personalDepot.goodsList[n3] = goods;
            h2.a(p.o(n2, n3));
        } else if (h2 == this.new) {
            h3 = this.a;
            Goods goods = this.for[n2];
            if (goods == null) {
                return;
            }
            int n4 = hero.personalDepot.getNextFreePos();
            if (n4 < 0) {
                h2.try("\u80cc\u5305\u7a7a\u95f4\u4e0d\u8db3");
                return;
            }
            this.for[n2] = null;
            hero.personalDepot.goodsList[n4] = goods;
            h2.a(p.o(n2, n4));
        }
        h3.a(p.h(n2));
        this.case = false;
        this.char = false;
    }

    public void if() {
        this.do = false;
        int n2 = 0;
        while (n2 < this.int.length) {
            if (this.int[n2] != null) {
                this.a.a(this.int[n2]);
            }
            this.int[n2] = null;
            ++n2;
        }
        if (this.byte > 0) {
            this.a.new(this.byte);
        }
        this.byte = 0;
        n2 = 0;
        while (n2 < this.for.length) {
            if (this.for[n2] != null) {
                this.new.a(this.for[n2]);
            }
            this.for[n2] = null;
            ++n2;
        }
        if (this.try > 0) {
            this.new.new(this.try);
        }
        this.try = 0;
        this.a.a((j)null);
        this.new.a((j)null);
    }

    public void do() {
        this.do = false;
        Hero hero = this.a.r();
        Hero hero2 = this.new.r();
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("other=");
        stringBuffer.append(b.case(hero2.name));
        stringBuffer.append(";money=");
        stringBuffer.append(this.byte);
        stringBuffer.append(";goodsList=");
        StringBuffer stringBuffer2 = new StringBuffer(256);
        stringBuffer2.append("other=");
        stringBuffer2.append(b.case(hero.name));
        stringBuffer2.append(";money=");
        stringBuffer2.append(this.try);
        stringBuffer2.append(";goodsList=");
        int n2 = 0;
        while (n2 < this.int.length) {
            if (this.int[n2] != null) {
                this.new.a(this.int[n2]);
                stringBuffer.append(this.int[n2].id);
                stringBuffer.append(',');
            }
            ++n2;
        }
        if (this.byte > 0) {
            this.new.new(this.byte);
        }
        n2 = 0;
        while (n2 < this.for.length) {
            if (this.for[n2] != null) {
                this.a.a(this.for[n2]);
                stringBuffer2.append(this.for[n2].id);
                stringBuffer2.append(',');
            }
            ++n2;
        }
        if (this.try > 0) {
            this.a.new(this.try);
        }
        this.a.a((j)null);
        this.new.a((j)null);
        this.a.a(p.h());
        this.new.a(p.h());
        c c2 = this.if.do().long();
        c2.saveUserLog(hero.user.name, hero.name, "trade", stringBuffer.toString());
        c2.saveUserLog(hero2.user.name, hero2.name, "trade", stringBuffer2.toString());
    }

    private int a(Goods[] goodsArray) {
        int n2 = 0;
        while (n2 < goodsArray.length) {
            if (goodsArray[n2] == null) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    public boolean a() {
        return this.do;
    }
}

