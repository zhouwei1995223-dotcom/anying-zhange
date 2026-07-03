/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs;

import app.b.b;
import app.island.data.ChatGift;
import app.island.entity.Hero;
import app.island.gs.ServerInfo;
import app.island.gs.e;
import app.island.gs.h;
import app.island.gs.p;
import app.island.gs.x;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class t {
    private x do;
    private a[] a = new a[200];
    private int for;
    private a if;

    private void a(h h2, String string, String string2) {
        h h3 = this.do.if(string);
        if (h3 == null) {
            h2.new(string + "\u4e0d\u5728\u7ebf\u4e0a");
            return;
        }
        if (string2.length() > 100) {
            return;
        }
        int n2 = 0;
        if (h2.q() > 0) {
            n2 = ServerInfo.gmNameColor;
        }
        h3.a(p.a(h2.b(), string2, n2));
    }

    private void a(h h2, ChatGift chatGift, h h3, int n2, int n3) {
        b b2 = p.a(h2.b(), h3.b(), chatGift.text, chatGift.cType, n2, n3, chatGift.timeLast);
        if (chatGift.coverage == 0) {
            if (h3.goto()) {
                if (h2.goto()) {
                    h2.a(b2);
                }
                h3.a(b2);
            } else {
                h2.new(h3.b() + "\u5df2\u7ecf\u4e0b\u7ebf\uff0c\u4f60\u7684\u793c\u54c1\u804a\u5929\u65e0\u6cd5\u5728\u5bf9\u65b9\u8eab\u4e0a\u65bd\u653e");
            }
        } else if (chatGift.coverage == 1) {
            if (h3.goto()) {
                if (h2.goto() && (h2.j() != h3.j() || !h3.j().a(h2.m(), h2.o(), h3.m(), h3.o()))) {
                    h2.a(b2);
                }
                h3.j().a(b2, h3.m(), h3.o(), h2);
            } else {
                h2.new(h3.b() + "\u5df2\u7ecf\u4e0b\u7ebf\uff0c\u4f60\u7684\u793c\u54c1\u804a\u5929\u65e0\u6cd5\u5728\u5bf9\u65b9\u5c4f\u5e55\u4e0a\u65bd\u653e");
            }
        } else if (chatGift.coverage == 2) {
            if (h3.goto()) {
                if (h2.goto() && h2.j() != h3.j()) {
                    h2.a(b2);
                }
                h3.j().if(b2, h2);
            } else {
                h2.new(h3.b() + "\u5df2\u7ecf\u4e0b\u7ebf\uff0c\u4f60\u7684\u793c\u54c1\u804a\u5929\u65e0\u6cd5\u5728\u5bf9\u65b9\u573a\u666f\u91cc\u65bd\u653e");
            }
        } else if (chatGift.coverage == 3) {
            this.do.a(b2);
        }
    }

    public t(x x2) {
        this.do = x2;
    }

    private void a(h h2, int n2, String string, int n3, int n4) {
        Hero hero = h2.r();
        int n5 = hero.personalDepot.getGoodsPosByID(n2);
        if (n5 < 0) {
            h2.new("\u6ca1\u6709\u8be5\u7269\u54c1");
            return;
        }
        if (hero.personalDepot.goodsList[n5].goodsType != 7) {
            h2.new("\u7269\u54c1\u7c7b\u578b\u4e0d\u7b26");
            return;
        }
        h h3 = this.do.if(string);
        if (h3 == null) {
            h2.new("\u76ee\u6807\u73a9\u5bb6\u4e0d\u5728\u7ebf");
            return;
        }
        a a2 = new a();
        a2.for = h2;
        a2.int = h3;
        a2.if = (ChatGift)hero.personalDepot.goodsList[n5];
        a2.new = n3;
        a2.do = n4;
        if (this.if == null) {
            this.if = a2;
            this.if.a = ServerInfo.currentMilliSecond + (long)(a2.if.timeLast * 1000);
            this.a(h2, a2.if, h3, n3, n4);
        } else {
            this.a[this.for++] = a2;
        }
        h2.long(n5);
    }

    public x a() {
        return this.do;
    }

    public void a(int n2, daff.a.e e2, h h2) {
        if (!h2.r().chatable) {
            return;
        }
        switch (n2) {
            case 769: {
                String string = e2.h();
                String string2 = e2.h();
                this.a(h2, string, string2);
                break;
            }
            case 770: {
                String string = e2.h();
                this.if(h2, string);
                break;
            }
            case 771: {
                String string = e2.h();
                this.for(h2, string);
                break;
            }
            case 772: {
                String string = e2.h();
                this.a(h2, string);
                break;
            }
            case 773: {
                String string = e2.h();
                this.do(h2, string);
                break;
            }
            case 774: {
                int n3 = e2.i();
                String string = e2.h();
                int n4 = e2.for();
                int n5 = e2.for();
                this.a(h2, n3, string, n4, n5);
                break;
            }
        }
    }

    public void if() {
        if (this.if != null && ServerInfo.currentMilliSecond > this.if.a) {
            this.if = null;
            if (this.for > 0) {
                int n2 = 0;
                int n3 = 1;
                while (n3 < this.for) {
                    if (this.a[n3].if.priority > this.a[n2].if.priority) {
                        n2 = n3;
                    }
                    ++n3;
                }
                this.if = this.a[n2];
                this.if.a = ServerInfo.currentMilliSecond + (long)(this.if.if.timeLast * 1000);
                this.a(this.if.for, this.if.if, this.if.int, this.if.new, this.if.do);
                this.for += -1;
                n3 = n2;
                while (n3 < this.for) {
                    this.a[n3] = this.a[n3 + 1];
                    ++n3;
                }
                this.a[this.for] = null;
            }
        }
    }

    private void for(h h2, String string) {
        if (string.length() > 100) {
            return;
        }
        Hero hero = h2.r();
        int n2 = ServerInfo.gmWordsColor;
        if (hero.gmGrade == 0) {
            n2 = 0;
            if (ServerInfo.worldChatSpeekerGoodsID > 0) {
                int n3 = hero.personalDepot.getGoodsPosByID(ServerInfo.worldChatSpeekerGoodsID);
                if (n3 < 0) {
                    h2.new("\u4f60\u6ca1\u6709\u4e16\u754c\u558a\u8bdd\u7684\u9053\u5177");
                    return;
                }
                h2.long(n3);
            } else if (ServerInfo.worldChatMoneyCost > 0) {
                if (hero.personalDepot.money < ServerInfo.worldChatMoneyCost) {
                    h2.new("\u4f60\u91d1\u5e01\u4e0d\u591f");
                    return;
                }
                hero.personalDepot.money -= ServerInfo.worldChatMoneyCost;
                h2.a(p.case(hero));
            }
        }
        b b2 = p.if(h2.b(), string, n2, hero.gmGrade == 0 ? 0 : ServerInfo.gmNameColor);
        this.do.a(b2);
    }

    private void a(h h2, String string) {
        if (string.length() > 100) {
            return;
        }
        int n2 = 0;
        if (h2.q() > 0) {
            n2 = ServerInfo.gmNameColor;
        }
        if (h2.x() != null) {
            h2.x().a(p.for(h2.b(), string, n2));
        } else if (h2.q() > 0) {
            this.do.c().a(p.for(h2.b(), string, n2));
        } else {
            h2.new("\u4f60\u6ca1\u6709\u961f\u4f0d\uff0c\u4e0d\u80fd\u5728\u961f\u4f0d\u9891\u9053\u804a\u5929\uff01");
        }
    }

    public void do() {
    }

    private void if(h h2, String string) {
        if (!h2.g()) {
            h2.new("\u4f60\u5f53\u524d\u7684\u72b6\u6001\u4e0d\u80fd\u804a\u5929\uff01");
            return;
        }
        if (string.length() > 100) {
            return;
        }
        int n2 = 0;
        if (h2.r().gmGrade > 0) {
            n2 = ServerInfo.gmWordsColor;
        }
        b b2 = p.a(h2.b(), string, n2, n2 > 0 ? ServerInfo.gmNameColor : 0);
        h2.j().a(b2);
    }

    private void do(h h2, String string) {
        if (string.length() > 100) {
            return;
        }
        if (h2.r().joinedGuild == null) {
            h2.new("\u4f60\u8fd8\u6ca1\u6709\u516c\u4f1a");
        } else {
            int n2 = 0;
            if (h2.q() > 0) {
                n2 = ServerInfo.gmNameColor;
            }
            e e2 = (e)h2.r().joinedGuild.attachment;
            e2.a(p.do(h2.b(), string, n2));
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    private static class a {
        h for;
        h int;
        ChatGift if;
        int new;
        int do;
        long a;

        a() {
        }
    }
}

