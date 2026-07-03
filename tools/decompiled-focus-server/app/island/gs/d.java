/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs;

import app.b.b;
import app.island.GameObject;
import app.island.data.Goods;
import app.island.entity.Door;
import app.island.entity.Hero;
import app.island.entity.Monster;
import app.island.entity.User;
import app.island.gs.ServerInfo;
import app.island.gs.e;
import app.island.gs.h;
import app.island.gs.k;
import app.island.gs.n;
import app.island.gs.p;
import app.island.gs.q;
import app.island.gs.u;
import app.island.gs.v;
import app.island.gs.w;
import app.island.gs.x;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class d
extends k {
    public static final int try = 0;
    public static final int case = 1;
    public static final int byte = 2;
    private x for;
    private daff.a.q char = new daff.a.q(100);

    private void a(h h2, h h3) {
        if (h2 == h3) {
            return;
        }
        if (h3 == null || !h3.goto()) {
            h2.new("\u76ee\u6807\u73a9\u5bb6\u5df2\u7ecf\u4e0d\u5728\u7ebf\u4e0a\u4e86");
            return;
        }
        if (!h3.g()) {
            h2.new("\u5bf9\u65b9\u6b63\u5728\u8fdb\u5165\u5730\u56fe\uff0c\u4f60\u6682\u65f6\u65e0\u6cd5\u8fc7\u53bb");
            return;
        }
        h2.r();
        if (h3.j() == h2.j()) {
            int n2 = h3.m();
            int n3 = h3.o();
            int n4 = h2.j().for(n2, n3);
            n2 = n4 & 0xFFFF;
            n3 = n4 >> 16;
            h2.a(p.long(n2, n3));
            h2.j().if(h2, n4 & 0xFFFF, n4 >> 16);
        } else {
            this.for.a(h2, h3.j().try(), h3.m(), h3.o());
        }
    }

    private void int(h h2, int n2) {
        h2.new(n2);
    }

    public d(x x2) {
        this.for = x2;
        this.a = new daff.a.h(50);
    }

    protected void a(h h2) {
        b b2 = p.void("\u6e38\u620f\u7ba1\u7406\u5458\u3010" + h2.b() + "\u3011\u79bb\u5f00\u4e86\u6e38\u620f");
        this.a(b2, h2);
    }

    public x do() {
        return this.for;
    }

    private void if(h h2, h h3) {
        if (!h3.g()) {
            h2.new("\u65e0\u6cd5\u62c9\u4eba\uff0c\u5bf9\u65b9\u6b63\u5728\u8fdb\u5165\u573a\u666f");
        } else if (h3.i()) {
            h2.new("\u65e0\u6cd5\u62c9\u4eba\uff0c\u5bf9\u65b9\u5df2\u6b7b\u4ea1");
        } else if (h2.j() == h3.j()) {
            int n2 = h2.m();
            int n3 = h2.o();
            int n4 = h2.j().for(n2, n3);
            n2 = n4 & 0xFFFF;
            n3 = n4 >> 16;
            h3.a(p.long(n2, n3));
            h2.j().if(h3, n2, n3);
        } else {
            this.for.a(h3, h2.j().try(), h2.m(), h2.o());
        }
    }

    public void b(h h2) {
        int[] nArray;
        if (h2.r().gmGrade > 0) {
            this.if(h2);
        }
        if ((nArray = (int[])this.char.a(h2.b())) != null) {
            h2.r().sceneID = nArray[0];
            h2.r().x = nArray[1];
            h2.r().y = nArray[2];
        }
    }

    private void new(h h2, int n2) {
        b b2 = p.c(2562);
        daff.a.e e2 = b2.for();
        daff.a.h h3 = this.for.a();
        int n3 = h3.for();
        int n4 = n2 * 50;
        int n5 = Math.min(n4 + 50, n3);
        e2.a(n2);
        int n6 = n4;
        while (n6 < n5) {
            h h4 = (h)h3.if(n6);
            if (h4 != h2 && h4.j() != null) {
                e2.a(h4.b());
                e2.a(h4.j().int());
            }
            ++n6;
        }
        h2.a(b2);
    }

    private void for(h h2, int n2) {
        Goods goods = w.case().getGoods(n2);
        if (goods != null) {
            goods = (Goods)GameObject.cloneObject(goods);
            this.for.a(goods);
            h2.a(goods);
            if (goods.treasureCost > 0) {
                this.for.long().saveUserLog(h2.r().user.name, h2.b(), "createGoods", "goodsID=" + n2 + ";cost=" + goods.treasureCost);
            }
        }
    }

    public void a(h h2, int n2, daff.a.e e2) {
        if (h2.i() || !h2.g()) {
            return;
        }
        int n3 = h2.r().gmGrade;
        int n4 = h2.r().personalDepot.getSpecialAbility();
        if (n3 == 0 && n4 == 0) {
            h2.t();
            return;
        }
        switch (n2) {
            case 2305: {
                int n5 = e2.i();
                if (n3 <= 1) break;
                h2.int(n5);
                break;
            }
            case 2306: {
                int n6 = e2.i();
                if (n3 <= 1) break;
                this.int(h2, n6);
                break;
            }
            case 2307: {
                int n7 = e2.i();
                if (n3 <= 1) break;
                this.for(h2, n7);
                break;
            }
            case 2308: {
                if (n3 <= 0) break;
                String string = e2.h();
                this.a(h2, this.for.if(string));
                break;
            }
            case 2310: {
                if (n3 <= 0 && (n4 & 1) <= 0) break;
                int n8 = e2.for();
                int n9 = e2.for();
                this.a(h2, n8, n9);
                break;
            }
            case 2311: {
                String string;
                h h3;
                if (n3 <= 0 || (h3 = this.for.if(string = e2.h())) == null || h3 == null) break;
                h3.t();
                break;
            }
            case 2312: {
                String string;
                h h4;
                if (n3 <= 0 || (h4 = this.for.if(string = e2.h())) == null || h4 == h2) break;
                h4.N();
                if (h4.r().chatable) {
                    h4.do("\u4f60\u88ab\u6e38\u620f\u7ba1\u7406\u5458\u3010" + h2.b() + "\u3011\u5141\u8bb8\u53d1\u8a00");
                    break;
                }
                h4.do("\u4f60\u88ab\u6e38\u620f\u7ba1\u7406\u5458\u3010" + h2.b() + "\u3011\u7981\u6b62\u53d1\u8a00");
                break;
            }
            case 2314: {
                String string;
                h h5;
                if (n3 <= 0 || (h5 = this.for.if(string = e2.h())) == null || h5 == h2) break;
                h5.L();
                if (h5.r().fightable) {
                    h5.do("\u4f60\u88ab\u6e38\u620f\u7ba1\u7406\u5458\u3010" + h2.b() + "\u3011\u5141\u8bb8\u6218\u6597");
                    break;
                }
                h5.do("\u4f60\u88ab\u6e38\u620f\u7ba1\u7406\u5458\u3010" + h2.b() + "\u3011\u5141\u8bb8\u6218\u6597");
                break;
            }
            case 2313: {
                String string;
                h h6;
                if (n3 <= 0 || (h6 = this.for.if(string = e2.h())) == null || h6 == h2) break;
                h6.byte();
                if (h6.r().movable) {
                    h6.do("\u4f60\u88ab\u6e38\u620f\u7ba1\u7406\u5458\u3010" + h2.b() + "\u3011\u5141\u8bb8\u79fb\u52a8");
                    break;
                }
                h6.do("\u4f60\u88ab\u6e38\u620f\u7ba1\u7406\u5458\u3010" + h2.b() + "\u3011\u5141\u8bb8\u79fb\u52a8");
                break;
            }
            case 2315: {
                if (n3 <= 0) break;
                String string = e2.h();
                h h7 = this.for.if(string);
                if (h7 != null) {
                    if (h7 == h2) break;
                    this.if(h2, h7);
                    break;
                }
                h2.new("\u76ee\u6807\u73a9\u5bb6\u4e0d\u5728\u7ebf");
                break;
            }
            case 2316: {
                int n10 = e2.i();
                if (n3 <= 1) break;
                this.if(h2, n10);
                break;
            }
            case 2317: {
                if (n3 <= 0) break;
                String string = e2.h();
                int n11 = e2.i();
                if (n11 == 0) {
                    n11 = ServerInfo.systemNoticeColor;
                }
                b b2 = p.for(string, n11);
                this.for.a(b2);
                break;
            }
            case 2356: {
                if (n3 <= 0) break;
                String string = e2.h();
                int n12 = e2.i();
                if (n12 == 0) {
                    n12 = ServerInfo.systemNoticeColor;
                }
                b b3 = p.try(string);
                this.for.a(b3);
                break;
            }
            case 2357: {
                if (n3 <= 0) break;
                String string = e2.h();
                int n13 = e2.i();
                if (n13 == 0) {
                    n13 = ServerInfo.systemNoticeColor;
                }
                b b4 = p.void(string);
                this.for.a(b4);
                break;
            }
            case 2319: {
                int n14;
                if (n3 <= 1) break;
                ServerInfo.expTimes = n14 = e2.for();
                h2.do("\u5f53\u524d\u7ecf\u9a8c\u500d\u6570\u8bbe\u7f6e\u4e3a" + n14);
                break;
            }
            case 2318: {
                int n15;
                if (n3 <= 1) break;
                ServerInfo.moneyTimes = n15 = e2.for();
                h2.do("\u5f53\u524d\u91d1\u94b1\u500d\u6570\u8bbe\u7f6e\u4e3a" + n15);
                break;
            }
            case 2320: {
                int n16;
                if (n3 <= 1) break;
                ServerInfo.equipmentDropTimes = n16 = e2.for();
                ServerInfo.weaponDropTimes = n16;
                ServerInfo.extraGoodsDropTimes = n16;
                h2.do("\u5f53\u524d\u7269\u54c1\u6389\u843d\u500d\u6570\u8bbe\u7f6e\u4e3a" + n16);
                break;
            }
            case 2321: {
                if (n3 <= 0) break;
                this.void(h2);
                break;
            }
            case 2322: {
                if (n3 <= 0) break;
                int n17 = e2.for();
                this.new(h2, n17);
                break;
            }
            case 2324: {
                if (n3 <= 0) break;
                int n18 = e2.i();
                this.do(h2, n18);
                break;
            }
            case 2323: {
                if (n3 <= 0) break;
                this.c(h2);
                break;
            }
            case 2325: {
                if (n3 <= 0) break;
                h2.j().try(h2.m(), h2.o());
                break;
            }
            case 2326: {
                if (n3 <= 0) break;
                h2.j().case(h2.m(), h2.o());
                break;
            }
            case 2327: {
                h h8;
                if (n3 < 100) break;
                String string = e2.h();
                int n19 = 0;
                if (e2.if() > 0) {
                    n19 = e2.for();
                }
                if ((h8 = this.for.if(string)) == null || h8 == h2 || n19 >= h2.r().gmGrade) break;
                h8.r().gmGrade = n19;
                h8.a(p.char(n19));
                h2.for("\u8bbe\u7f6e\u3010" + string + "\u3011\u7684GM\u7b49\u7ea7\u4e3a" + n19);
                break;
            }
            case 2328: {
                if (n3 <= 1) break;
                h2.for("\u603b\u5171\u5145\u503c\u7684\u5143\u5b9d\u6570\u4e3a" + ServerInfo.payedTreasure);
                break;
            }
            case 2329: {
                if (n3 <= 1) break;
                h2.for("\u603b\u5171\u6d88\u8d39\u7684\u5143\u5b9d\u6570\u4e3a" + ServerInfo.consumedTreasure);
                break;
            }
            case 2331: {
                if (n3 <= 1) break;
                String string = e2.h();
                String string2 = ServerInfo.getFieldValue(string);
                h2.for(string2);
                break;
            }
            case 2332: {
                if (n3 <= 1) break;
                String string = e2.h();
                int n20 = e2.i();
                h h9 = this.for.if(string);
                if (h9 != null) {
                    Hero hero = h9.r();
                    n20 = Math.min(n20, hero.personalDepot.money);
                    hero.personalDepot.money -= n20;
                    h9.a(p.case(hero));
                    h9.try("\u4f60\u88ab\u6e38\u620f\u7ba1\u7406\u5458\u3010" + h2.b() + "\u3011\u6263\u9664\u4e86" + n20 + "\u91d1\u5e01");
                    h2.try("\u6263\u9664\u76ee\u6807\u73a9\u5bb6\u91d1\u5e01" + n20);
                    break;
                }
                h2.try("\u76ee\u6807\u73a9\u5bb6\u4e0d\u5728\u7ebf");
                break;
            }
            case 2333: {
                if (n3 <= 1) break;
                String string = e2.h();
                h h10 = this.for.if(string);
                if (h10 != null) {
                    Hero hero = h10.r();
                    int n21 = 0;
                    while (n21 < hero.personalDepot.goodsList.length) {
                        if (hero.personalDepot.goodsList[n21] != null) {
                            h10.long(n21);
                        }
                        ++n21;
                    }
                    h10.try("\u4f60\u7684\u80cc\u5305\u88ab\u6e38\u620f\u7ba1\u7406\u5458\u3010" + h2.b() + "\u3011\u6e05\u7a7a\u4e86");
                    h2.try("\u76ee\u6807\u73a9\u5bb6\u7684\u80cc\u5305\u5df2\u88ab\u6e05\u7a7a");
                    break;
                }
                h2.try("\u76ee\u6807\u73a9\u5bb6\u4e0d\u5728\u7ebf");
                break;
            }
            case 2334: {
                if (n3 <= 1) break;
                String string = e2.h();
                h h11 = this.for.if(string);
                if (h11 != null) {
                    Hero hero = h11.r();
                    User user = hero.user;
                    int n22 = 0;
                    while (n22 < user.store.capacity) {
                        if (user.store.goods[n22] != null) {
                            user.store.goods[n22] = null;
                            h11.a(p.l(n22, 255));
                        }
                        ++n22;
                    }
                    h11.try("\u4f60\u7684\u4ed3\u5e93\u88ab\u6e38\u620f\u7ba1\u7406\u5458\u3010" + h2.b() + "\u3011\u6e05\u7a7a\u4e86");
                    h2.try("\u76ee\u6807\u73a9\u5bb6\u7684\u4ed3\u5e93\u5df2\u88ab\u6e05\u7a7a");
                    break;
                }
                h2.new("\u76ee\u6807\u73a9\u5bb6\u4e0d\u5728\u7ebf");
                break;
            }
            case 2335: {
                if (n3 <= 1) break;
                String string = e2.h();
                h h12 = this.for.if(string);
                if (h12 != null) {
                    Hero hero = h12.r();
                    if (hero.personalDepot.weapon != null) {
                        h12.a(hero.personalDepot.unequipWeapon(), null);
                        h12.a(p.void());
                    }
                    if (hero.personalDepot.helmet != null) {
                        h12.a(hero.personalDepot.unequipEquipment(2), null);
                        h12.a(p.l(2));
                    }
                    if (hero.personalDepot.armor != null) {
                        h12.a(hero.personalDepot.unequipEquipment(1), null);
                        h12.a(p.l(1));
                    }
                    if (hero.personalDepot.boots != null) {
                        h12.a(hero.personalDepot.unequipEquipment(3), null);
                        h12.a(p.l(3));
                    }
                    if (hero.personalDepot.shield != null) {
                        h12.a(hero.personalDepot.unequipEquipment(4), null);
                        h12.a(p.l(4));
                    }
                    hero.calculateProperties();
                    h12.try("\u4f60\u7684\u88c5\u5907\u88ab\u6e38\u620f\u7ba1\u7406\u5458\u3010" + h2.b() + "\u3011\u6e05\u7a7a\u4e86");
                    h2.try("\u76ee\u6807\u73a9\u5bb6\u7684\u88c5\u5907\u5df2\u88ab\u6e05\u7a7a");
                    break;
                }
                h2.new("\u76ee\u6807\u73a9\u5bb6\u4e0d\u5728\u7ebf");
                break;
            }
            case 2336: {
                if (n3 <= 1) break;
                String string = e2.h();
                Hero hero = this.for.long().new(string);
                if (hero != null) {
                    User user = hero.user;
                    StringBuffer stringBuffer = new StringBuffer(64);
                    stringBuffer.append(hero.name);
                    stringBuffer.append("[\u5e10\u53f7=");
                    stringBuffer.append(user.name);
                    stringBuffer.append(";\u5bc6\u7801=");
                    stringBuffer.append(user.password);
                    stringBuffer.append(";\u4ed3\u5e93\u5bc6\u7801=");
                    stringBuffer.append(user.store.password);
                    stringBuffer.append(";\u89d2\u8272\u5bc6\u7801=");
                    stringBuffer.append(hero.password);
                    stringBuffer.append(']');
                    h2.for(stringBuffer.toString());
                    break;
                }
                h2.new("\u76ee\u6807\u73a9\u5bb6\u672a\u66fe\u4e0a\u7ebf");
                break;
            }
            case 2337: {
                if (n3 <= 1) break;
                String string = e2.h();
                int n23 = e2.i();
                h h13 = this.for.if(string);
                if (h13 != null) {
                    h13.int(n23);
                    break;
                }
                h2.new("\u76ee\u6807\u73a9\u5bb6\u4e0d\u5728\u7ebf");
                break;
            }
            case 2338: {
                if (n3 <= 1) break;
                String string = e2.h();
                User user = this.for.long().a(string);
                if (user != null) {
                    String string3 = null;
                    int n24 = 0;
                    while (n24 < user.heroes.length) {
                        Hero hero = user.heroes[n24];
                        if (hero != null && hero.attachment instanceof h) {
                            h h14 = (h)hero.attachment;
                            string3 = h14.b();
                            h14.t();
                            break;
                        }
                        ++n24;
                    }
                    user.online = false;
                    h2.for("\u8e22\u51fa\u5e10\u53f7[username=" + string + ";onlineHero=" + string3 + "]");
                    break;
                }
                h2.new(string + "\u5e76\u672a\u8fdb\u5165\u8fc7\u6e38\u620f");
                break;
            }
            case 2339: {
                if (n3 < 100) break;
                String string = e2.h();
                int n25 = e2.i();
                h h15 = this.for.if(string);
                if (n25 < 0) {
                    h2.new("\u4f60\u641e\u4ec0\u4e48\u540d\u5802");
                    break;
                }
                if (h15 == null) {
                    h2.new("\u76ee\u6807\u73a9\u5bb6\u4e0d\u5728\u7ebf");
                    break;
                }
                if (n25 <= 0) break;
                Hero hero = h15.r();
                User user = hero.user;
                user.treasure += n25;
                user.payedTreasure += n25;
                hero.payedTreasure += n25;
                ServerInfo.payedTreasure += n25;
                h15.a(p.case(hero));
                this.for.long().saveUserLog(user.name, hero.name, "gmAddTreasure", "gmAccount=" + h2.r().user.name + ";amount=" + n25);
                h2.for("\u6210\u529f\u52a0\u73a9\u5bb6\u5143\u5b9d[name=" + hero.name + ";amount=" + n25 + "]");
                h15.for("\u6e38\u620f\u7ba1\u7406\u5458\u3010" + h2.b() + "\u3011\u7ed9\u4f60\u589e\u52a0" + n25 + "\u5143\u5b9d");
                break;
            }
            case 2340: {
                if (n3 <= 1) break;
                String string = e2.h();
                int n26 = e2.i();
                h h16 = this.for.if(string);
                if (n26 < 0) {
                    h2.new("\u4f60\u641e\u4ec0\u4e48\u540d\u5802");
                    break;
                }
                if (h16 == null) {
                    h2.new("\u76ee\u6807\u73a9\u5bb6\u4e0d\u5728\u7ebf");
                    break;
                }
                if (n26 <= 0) break;
                Hero hero = h16.r();
                User user = hero.user;
                if (n26 > user.treasure) {
                    h2.for("\u76ee\u6807\u73a9\u5bb6\u8eab\u4e0a\u6ca1\u6709\u8fd9\u4e48\u591a\u5143\u5b9d:" + n26);
                    break;
                }
                user.treasure -= n26;
                hero.consumedTreasure += n26;
                user.consumedTreasure += n26;
                ServerInfo.consumedTreasure += n26;
                h16.a(p.case(hero));
                this.for.long().saveUserLog(user.name, hero.name, "gmReduceTreasure", "gmAccount=" + h2.r().user.name + ";amount=" + n26);
                h2.for("\u6210\u529f\u51cf\u73a9\u5bb6\u5143\u5b9d[name=" + hero.name + ";amount=" + n26 + "]");
                h16.for("\u6e38\u620f\u7ba1\u7406\u5458\u3010" + h2.b() + "\u3011\u7ed9\u4f60\u6263\u9664" + n26 + "\u5143\u5b9d");
                break;
            }
            case 2341: 
            case 2379: {
                if (n3 <= 1) break;
                int n27 = e2.for();
                int n28 = e2.for();
                int n29 = e2.i();
                int n30 = e2.i();
                int n31 = e2.i();
                int n32 = 0;
                if (e2.if() > 0) {
                    n32 = e2.i();
                }
                if (h2.j().a(n27, n28, n29, n30, n31, n32)) break;
                h2.new("\u521b\u5efa\u602a\u7269\u5931\u8d25");
                break;
            }
            case 2342: {
                if (n3 <= 1) break;
                String string = e2.h();
                h h17 = this.for.if(string);
                if (h17 != null) {
                    if (h17 == h2) break;
                    this.if(h2, h17);
                    break;
                }
                Hero hero = this.for.long().new(string);
                if (hero != null) {
                    hero.sceneID = h2.j().try();
                    hero.x = h2.m();
                    hero.y = h2.o();
                    h2.for("\u76ee\u6807\u73a9\u5bb6\u5df2\u4e0b\u7ebf\uff0c\u4e0a\u7ebf\u540e\u4f1a\u51fa\u73b0\u5728\u4f60\u6240\u5728\u4f4d\u7f6e\u3002");
                    break;
                }
                this.char.a((Object)string, (Object)new int[]{h2.j().try(), h2.m(), h2.o()});
                h2.for("\u76ee\u6807\u73a9\u5bb6\u672a\u66fe\u4e0a\u7ebf\uff0c\u4f46\u662f\u4e0a\u7ebf\u540e\u5c06\u4f1a\u51fa\u73b0\u5728\u4f60\u73b0\u5728\u7684\u4f4d\u7f6e");
                break;
            }
            case 2343: {
                int n33 = e2.i();
                if (n3 <= 1) break;
                int n34 = this.for.if(n33);
                if (n34 > 0) {
                    this.for.a(h2, n34, 0, 0);
                    break;
                }
                h2.new("\u521b\u5efa\u526f\u672c\u5931\u8d25\uff1a" + n33);
                break;
            }
            case 2344: {
                if (n3 <= 1) break;
                int n35 = e2.i();
                n n36 = h2.j().void(n35);
                if (n36 != null) {
                    Monster monster = n36.g();
                    int n37 = monster.life;
                    if (n37 > 65535) {
                        n37 = 65535;
                    }
                    monster.life -= n37;
                    if (monster.life <= 0) {
                        n36.int(h2);
                    }
                    b b5 = p.a(n36.g(), n37, 0, 100);
                    h2.j().a(b5, n36.i(), n36.try(), null);
                    break;
                }
                h2.new("\u4e0d\u5b58\u5728\u6b64\u602a\u7269\uff1a" + n35);
                break;
            }
            case 2345: {
                if (n3 <= 1) break;
                int n38 = e2.i();
                h2.j().f(n38);
                break;
            }
            case 2391: {
                if (n3 < 100) break;
                int n39 = e2.i();
                int n40 = e2.for();
                int n41 = e2.for();
                Door door = h2.j().goto(n39);
                h2.j().a(door, n40, n41);
                break;
            }
            case 2346: {
                if (n3 < 100) break;
                int n42 = e2.i();
                int n43 = e2.for();
                int n44 = e2.for();
                n n45 = h2.j().void(n42);
                int n46 = h2.j().for(n43, n44);
                if (n45 == null || n46 < 0) break;
                n45.long();
                n45.a(n46 & 0xFFFF, n46 >> 16);
                break;
            }
            case 2392: {
                if (n3 < 100) break;
                int n47 = e2.i();
                int n48 = e2.for();
                int n49 = e2.for();
                q q2 = h2.j().b(n47);
                int n50 = h2.j().for(n48, n49);
                if (n50 <= 0) break;
                h2.j().a(q2, n50 & 0xFFFF, n50 >> 16);
                break;
            }
            case 2347: {
                if (n3 < 100) break;
                h2.for(h2.j().z().toString());
                break;
            }
            case 2348: {
                if (n3 < 100) break;
                String string = e2.h();
                int n51 = e2.i();
                h2.j().z().setAttributeValue(string, String.valueOf(n51));
                h2.for("\u6210\u529f\u8bbe\u7f6e\u573a\u666f\u53c2\u6570[" + string + "=" + n51 + "]");
                break;
            }
            case 2349: {
                if (n3 <= 0) break;
                h2.j().n(h2);
                h2.a(p.a(h2.r().visible));
                break;
            }
            case 2350: {
                if (n3 < 100) break;
                int n52 = e2.i();
                int n53 = e2.i();
                v v2 = this.for.a(n52);
                if (v2 != null) {
                    if (v2.case(n53) != null) {
                        h2.new("\u672c\u5546\u5e97\u5df2\u7ecf\u5b58\u5728\u8be5\u7269\u54c1\uff1a" + n53);
                        break;
                    }
                    Goods goods = Goods.getGlobalGoods(n53);
                    if (goods == null) {
                        h2.new("\u627e\u4e0d\u5230\u8be5\u7269\u54c1\uff1a" + n53);
                        break;
                    }
                    v2.a(goods);
                    h2.for("\u6dfb\u52a0\u7269\u54c1\u5230\u5546\u5e97\uff1a" + goods.name);
                    break;
                }
                h2.new("\u4e0d\u5b58\u5728\u8be5\u5546\u5e97\uff1a" + n52);
                break;
            }
            case 2351: {
                if (n3 < 100) break;
                int n54 = e2.i();
                int n55 = e2.i();
                v v3 = this.for.a(n54);
                if (v3 != null) {
                    v3.byte(n55);
                    h2.for("\u7269\u54c1\u5df2\u4ece\u5546\u5e97\u4e2d\u5220\u9664");
                    break;
                }
                h2.new("\u4e0d\u5b58\u5728\u8be5\u5546\u5e97\uff1a" + n54);
                break;
            }
            case 2352: {
                if (n3 < 100) break;
                int n56 = e2.i();
                int n57 = e2.j();
                v v4 = this.for.a(n56);
                if (n57 <= 0) {
                    h2.new("\u975e\u6cd5\u7684\u4ef7\u683c\u6bd4\u7387\uff1a" + n57);
                    break;
                }
                if (v4 != null) {
                    v4.try(n57);
                    h2.for("\u8bbe\u7f6e\u5546\u5e97\u7684\u51fa\u552e\u4ef7\u683c\u6bd4\u7387\u4e3a\uff1a" + n57);
                    break;
                }
                h2.new("\u4e0d\u5b58\u5728\u8be5\u5546\u5e97\uff1a" + n56);
                break;
            }
            case 2353: {
                if (n3 < 100) break;
                int n58 = e2.i();
                int n59 = e2.j();
                v v5 = this.for.a(n58);
                if (n59 <= 0 || n59 > 100) {
                    h2.new("\u975e\u6cd5\u7684\u4ef7\u683c\u6bd4\u7387\uff1a" + n59);
                    break;
                }
                if (v5 != null) {
                    v5.char(n59);
                    h2.for("\u8bbe\u7f6e\u5546\u5e97\u7684\u56de\u6536\u4ef7\u683c\u6bd4\u7387\u4e3a\uff1a" + n59);
                    break;
                }
                h2.new("\u4e0d\u5b58\u5728\u8be5\u5546\u5e97\uff1a" + n58);
                break;
            }
            case 2354: {
                if (n3 < 100) break;
                int n60 = e2.i();
                int n61 = e2.i();
                Goods goods = Goods.getGlobalGoods(n60);
                if (n61 <= 0 || n61 > 1000000000) {
                    h2.new("\u975e\u6cd5\u7684\u5143\u5b9d\u4ef7\u683c\uff1a" + n61);
                    break;
                }
                if (goods == null) {
                    h2.new("\u627e\u4e0d\u5230\u8be5\u7269\u54c1\uff1a" + n60);
                    break;
                }
                goods.treasureCost = n61;
                h2.for("\u4f60\u6210\u529f\u7684\u8bbe\u7f6e\u4e86\u7269\u54c1\u5143\u5b9d\u4ef7\u683c\uff08\u7269\u54c1=" + goods.name + ";\u4ef7\u683c=" + n61 + "\uff09\u91cd\u65b0\u6253\u5f00\u5546\u5e97\u53ef\u4ee5\u770b\u5230\u65b0\u7684\u4ef7\u683c");
                break;
            }
            case 2355: {
                if (n3 < 100) break;
                int n62 = e2.i();
                int n63 = e2.i();
                Goods goods = Goods.getGlobalGoods(n62);
                if (n63 <= 0 || n63 > 1000000000) {
                    h2.new("\u975e\u6cd5\u7684\u91d1\u5e01\u4ef7\u683c\uff1a" + n63);
                    break;
                }
                if (goods == null) {
                    h2.new("\u627e\u4e0d\u5230\u8be5\u7269\u54c1\uff1a" + n62);
                    break;
                }
                goods.moneyCost = n63;
                h2.for("\u4f60\u6210\u529f\u7684\u8bbe\u7f6e\u4e86\u7269\u54c1\u91d1\u5e01\u4ef7\u683c\uff08\u7269\u54c1=" + goods.name + ";\u4ef7\u683c=" + n63 + "\uff09\u91cd\u65b0\u6253\u5f00\u5546\u5e97\u53ef\u4ee5\u770b\u5230\u65b0\u7684\u4ef7\u683c");
                break;
            }
            case 2358: {
                int n64 = e2.i();
                if (n64 < 0) {
                    n64 = 0;
                }
                b b6 = p.d(n64);
                this.for.a(b6);
                break;
            }
            case 2359: {
                if (n3 < 100) break;
                int n65 = e2.i();
                q q3 = h2.j().b(n65);
                q3.a().visible = !q3.a().visible;
                h2.j().if(p.a(q3.a()));
                break;
            }
            case 2370: {
                if (n3 < 100) break;
                int n66 = e2.i();
                String string = e2.h();
                if (string.length() < 2 || string.length() > 8) {
                    h2.try("\u975e\u6cd5\u7684\u516c\u4f1a\u540d\u5b57\u957f\u5ea6");
                    break;
                }
                if (this.for.long().do(string) != null) {
                    h2.try("\u5df2\u7ecf\u5b58\u5728\u8be5\u540d\u5b57\u7684\u516c\u4f1a\u4e86");
                    break;
                }
                e e3 = this.for.new(n66);
                if (e3 == null) break;
                b b7 = p.try("\u6e38\u620f\u7ba1\u7406\u5458\u4fee\u6539\u4f60\u516c\u4f1a\u7684\u540d\u5b57\u4e3a\uff1a" + string);
                e3.a(b7);
                b7 = p.d("\u6e38\u620f\u7ba1\u7406\u5458\u5c06\u516c\u4f1a\u3010" + e3.int() + "\u3011\u7684\u540d\u5b57\u4fee\u6539\u4e3a\u3010" + string + "\u3011");
                this.for.a(b7);
                e3.int(string);
                h2.for("\u6210\u529f\u4fee\u6539\u516c\u4f1a\u7684\u540d\u5b57\u4e3a\uff1a" + string);
                break;
            }
            case 2371: {
                int n67;
                e e4;
                if (n3 < 100 || (e4 = this.for.new(n67 = e2.i())) == null) break;
                this.for.long().deleteGuild(e4.e());
                e4.f();
                b b8 = p.d("\u6e38\u620f\u7ba1\u7406\u5458\u3010" + h2.b() + "\u3011\u5c06\u516c\u4f1a\u3010" + e4.int() + "\u3011\u5220\u9664\u4e86");
                this.for.a(b8);
                break;
            }
            case 2372: {
                if (n3 < 100) break;
                this.for.goto();
                this.for.a(h2, 0);
                break;
            }
            case 2373: {
                if (n3 < 100) break;
                String string = e2.h();
                Hero hero = this.for.long().new(string);
                if (hero != null) {
                    hero.unassignedPoints = 0;
                    hero.wisdom = 0;
                    hero.dexterity = 0;
                    hero.strength = 0;
                    hero.calculateProperties();
                    hero.dataChanged = true;
                    hero.user.dataChanged = true;
                    h2.for("\u76ee\u6807\u73a9\u5bb6\u5c5e\u6027\u5df2\u88ab\u91cd\u65b0\u8bbe\u7f6e\uff0c\u518d\u6b21\u4e0a\u7ebf\u53ef\u6062\u590d");
                    break;
                }
                h2.try("\u76ee\u6807\u73a9\u5bb6\u4e0d\u5728\u7ebf");
                break;
            }
            case 2374: {
                String string = e2.h();
                String string4 = e2.h();
                User user = this.for.long().a(string);
                if (!daff.a.b.a(string4)) {
                    h2.try("\u975e\u6cd5\u7684\u5bc6\u7801\uff1a" + string4);
                    break;
                }
                if (user == null) {
                    h2.for("\u8be5\u7528\u6237\u672a\u66fe\u4e0a\u8fc7\u7ebf");
                    break;
                }
                user.password = string4;
                user.dataChanged = true;
                h2.for("\u4fee\u6539\u5bc6\u7801\u6210\u529f[user=" + string + ";password=" + string4 + "]");
                break;
            }
            case 2375: {
                String string = e2.h();
                String string5 = e2.h();
                Hero hero = this.for.long().new(string);
                if (!daff.a.b.a(string5)) {
                    h2.try("\u975e\u6cd5\u7684\u5bc6\u7801\uff1a" + string5);
                    break;
                }
                if (hero == null) {
                    h2.for("\u8be5\u89d2\u8272\u672a\u66fe\u4e0a\u8fc7\u7ebf");
                    break;
                }
                hero.password = string5;
                hero.dataChanged = true;
                hero.user.dataChanged = true;
                h2.for("\u4fee\u6539\u5bc6\u7801\u6210\u529f[hero=" + string + ";password=" + string5 + "]");
                break;
            }
            case 2376: {
                String string = e2.h();
                int n68 = e2.for();
                User user = this.for.long().a(string);
                if (user == null) {
                    h2.for("\u8be5\u7528\u6237\u672a\u66fe\u4e0a\u8fc7\u7ebf");
                    break;
                }
                user.lockState = n68;
                user.dataChanged = true;
                h2.for("\u8bbe\u7f6e\u9501\u5b9a\u72b6\u6001\u6210\u529f[user=" + string + ";lock=" + n68 + "]");
                break;
            }
            case 2377: {
                String string = e2.h();
                int n69 = e2.for();
                Hero hero = this.for.long().new(string);
                if (hero == null) {
                    h2.for("\u8be5\u89d2\u8272\u672a\u66fe\u4e0a\u8fc7\u7ebf");
                    break;
                }
                hero.lockState = n69;
                hero.dataChanged = true;
                hero.user.dataChanged = true;
                h2.for("\u8bbe\u7f6e\u9501\u5b9a\u72b6\u6001\u6210\u529f[hero=" + string + ";lock=" + n69 + "]");
                break;
            }
            case 2378: {
                Door door = new Door();
                door.x = e2.for();
                door.y = e2.for();
                door.name = e2.h();
                door.levelRequired = e2.for();
                door.raceRequired = e2.for();
                door.destSceneID = e2.i();
                door.destX = e2.for();
                door.destY = e2.for();
                if (h2.j().a(door)) break;
                h2.try("\u6dfb\u52a0\u4f20\u9001\u95e8\u5931\u8d25");
                break;
            }
            case 2380: {
                int n70 = e2.for();
                int n71 = e2.for();
                String string = e2.h();
                int n72 = e2.for();
                String string6 = e2.h();
                String string7 = e2.h();
                if (h2.j().a(n70, n71, n72, string, string6, string7, 0)) break;
                h2.try("\u6dfb\u52a0NPC\u5931\u8d25");
                break;
            }
            case 2381: {
                int n73 = e2.i();
                String string = e2.h();
                int n74 = e2.for();
                int n75 = e2.for();
                int n76 = e2.i();
                int n77 = e2.for();
                int n78 = e2.for();
                if (h2.j().a(n73, string, n74, n75, n76, n77, n78)) break;
                h2.try("\u4fee\u6539\u4f20\u9001\u95e8\u5931\u8d25");
                break;
            }
            case 2382: {
                int n79 = e2.i();
                int n80 = e2.i();
                int n81 = e2.i();
                int n82 = e2.i();
                int n83 = e2.i();
                if (h2.j().a(n79, n80, n81, n82, n83)) break;
                h2.try("\u4fee\u6539\u602a\u7269\u5931\u8d25");
                break;
            }
            case 2383: {
                int n84 = e2.i();
                String string = e2.h();
                int n85 = e2.for();
                String string8 = e2.h();
                String string9 = e2.h();
                int n86 = e2.i();
                if (h2.j().a(n84, n85, string, string8, string9, n86)) break;
                h2.try("\u4fee\u6539NPC\u5931\u8d25");
                break;
            }
            case 2384: {
                int n87 = e2.i();
                h2.j().c(n87);
                break;
            }
            case 2385: {
                int n88 = e2.i();
                h2.j().else(n88);
                break;
            }
            case 2386: {
                String string = h2.j().D();
                daff.a.b.a("config/door/" + h2.j().z().id + ".txt", string.getBytes());
                h2.for("\u573a\u666f\u7684\u4f20\u9001\u95e8\u914d\u7f6e\u4fe1\u606f\u5df2\u7ecf\u4fdd\u5b58");
                break;
            }
            case 2387: {
                String string = h2.j().P();
                daff.a.b.a("config/monster/" + h2.j().z().id + ".txt", string.getBytes());
                h2.for("\u573a\u666f\u7684\u602a\u7269\u914d\u7f6e\u4fe1\u606f\u5df2\u7ecf\u4fdd\u5b58");
                break;
            }
            case 2388: {
                String string = h2.j().A();
                daff.a.b.a("config/npc/" + h2.j().z().id + ".txt", string.getBytes());
                h2.for("\u573a\u666f\u7684NPC\u914d\u7f6e\u4fe1\u606f\u5df2\u7ecf\u4fdd\u5b58");
                break;
            }
            case 2389: {
                int n89 = e2.i();
                v v6 = this.for.a(n89);
                if (v6 != null) {
                    String string = v6.g();
                    daff.a.b.a("config/shop/" + n89 + ".txt", string.getBytes());
                    break;
                }
                h2.try("\u627e\u4e0d\u5230\u8be5\u5546\u5e97\uff1a" + n89);
                break;
            }
            case 2393: {
                int n90 = e2.for();
                int n91 = e2.for();
                h2.j().a(p.if(h2.m(), h2.o(), n90, n91));
                break;
            }
            case 2394: {
                String string = e2.h();
                int n92 = e2.for();
                int n93 = e2.for();
                h h18 = this.for.if(string);
                if (h18 == null) {
                    h2.try("\u76ee\u6807\u73a9\u5bb6\u4e0d\u5728\u7ebf");
                    break;
                }
                h2.j().a(p.char(h18.H(), n92, n93));
                break;
            }
            case 2390: {
                String string = e2.h();
                User user = this.for.long().a(string);
                if (user != null) {
                    StringBuffer stringBuffer = new StringBuffer(100);
                    stringBuffer.append("UserInfo[name=");
                    stringBuffer.append(string);
                    stringBuffer.append(";\u4e3b\u89d2=");
                    int n94 = 0;
                    do {
                        stringBuffer.append(user.heroNames[n94]);
                        stringBuffer.append(";");
                    } while (++n94 < 3);
                    stringBuffer.append("\u5143\u5b9d=");
                    stringBuffer.append(user.treasure);
                    stringBuffer.append(";\u5145\u503c=");
                    stringBuffer.append(user.treasure);
                    stringBuffer.append("]");
                    h2.for(stringBuffer.toString());
                    break;
                }
                h2.for("user not found:" + string);
                break;
            }
        }
    }

    public void byte() {
        super.byte();
    }

    private void do(h h2, int n2) {
        this.for.a(h2, n2, 0, 0);
    }

    private void void(h h2) {
        u u2 = h2.j();
        b b2 = p.c(278);
        daff.a.e e2 = b2.for();
        daff.a.h h3 = u2.a;
        int n2 = h3.for();
        int n3 = 0;
        while (n3 < n2) {
            h h4 = (h)h3.if(n3);
            if (h4 != h2) {
                e2.a(h4.b());
                e2.a(h4.m());
                e2.a(h4.o());
            }
            ++n3;
        }
        h2.a(b2);
    }

    private void c(h h2) {
        b b2 = p.c(2561);
        daff.a.e e2 = b2.for();
        daff.a.h h3 = this.for.h();
        int n2 = h3.for();
        e2.a(n2);
        int n3 = 0;
        while (n3 < n2) {
            u u2 = (u)h3.if(n3);
            e2.char(u2.try());
            e2.a(u2.int());
            e2.for(u2.new());
            ++n3;
        }
        h2.a(b2);
    }

    private void a(h h2, int n2, int n3) {
        if (h2.m() == n2 && h2.o() == n3) {
            return;
        }
        u u2 = h2.j();
        if (n2 < 0 || n3 < 0 || n2 >= u2.x() || n3 >= u2.M()) {
            return;
        }
        int n4 = u2.for(n2, n3);
        n2 = n4 & 0xFFFF;
        n3 = n4 >> 16;
        h2.a(p.long(n2, n3));
        u2.if(h2, n2, n3);
    }

    private void if(h h2, int n2) {
        Goods goods = w.case().getGoods(n2);
        if (goods != null) {
            goods = (Goods)GameObject.cloneObject(goods);
            this.for.a(goods);
            h2.j().a(goods, 0, 0, h2.m(), h2.o());
            b b2 = p.void("\u6709\u795e\u79d8\u5b9d\u7269\u51fa\u73b0\u5728" + h2.j().int() + "\u7684\u67d0\u4e2a\u89d2\u843d\uff01");
            this.for.a(b2);
        }
    }

    protected void int(h h2) {
        if (this.a.for() > 1) {
            b b2 = p.void("\u6e38\u620f\u7ba1\u7406\u5458\u3010" + h2.b() + "\u3011\u8fdb\u5165\u4e86\u6e38\u620f");
            this.a(b2, h2);
        }
    }
}

