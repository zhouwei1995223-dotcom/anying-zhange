/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs;

import app.b.b;
import app.island.entity.Guild;
import app.island.entity.Hero;
import app.island.entity.Player;
import app.island.entity.Sign;
import app.island.gs.ServerInfo;
import app.island.gs.c.l;
import app.island.gs.h;
import app.island.gs.k;
import app.island.gs.p;
import app.island.gs.u;
import app.island.gs.x;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class e
extends k {
    private Guild b;
    private x for;
    private h void;
    private int goto = -1;
    private int c = -1;
    private int else = 0;
    private long long;

    public void a(int n2, h h2, int n3) {
        int n4 = this.a.for();
        int n5 = 0;
        while (n5 < n4) {
            h h3 = (h)this.a.if(n5);
            if (h3.j() == h2.j() && Math.abs(h3.m() - h2.m()) <= n3 && Math.abs(h3.o() - h2.o()) <= n3) {
                this.for.a(h3, n2, 0, 0);
            }
            ++n5;
        }
    }

    public boolean b() {
        return this.b.memberCapacity <= this.b.memberList.for();
    }

    void a(h h2, String string) {
        if (h2.J() != null) {
            h2.try("\u4f60\u5df2\u7ecf\u6709\u516c\u4f1a\u4e86");
        } else if (this.b()) {
            h2.try("\u8be5\u516c\u4f1a\u5df2\u6ee1\uff0c\u65e0\u6cd5\u63a5\u53d7\u65b0\u6210\u5458");
        } else if (this.b.acceptMethod == 0) {
            h2.try("\u8be5\u516c\u4f1a\u4e0d\u518d\u63a5\u53d7\u65b0\u4f1a\u5458\u4e86");
        } else if (this.b.acceptMethod == 1) {
            this.a(this.for.if(this.b.leader), h2, string);
        } else if (this.b.acceptMethod == 2) {
            h h3 = this.for.if(this.b.leader);
            if (h3 == null) {
                daff.a.h h4 = this.b.memberList;
                int n2 = h4.for();
                int n3 = 0;
                while (n3 < n2) {
                    Guild.GuildMember guildMember = (Guild.GuildMember)h4.if(n3);
                    if (guildMember.position == 1 && (h3 = this.for.if(guildMember.name)) != null) break;
                    ++n3;
                }
            }
            this.a(h3, h2, string);
        }
    }

    private void a(h h2, h h3, String string) {
        if (h2 == null) {
            h3.try("\u516c\u4f1a\u7684\u7ba1\u7406\u5458\u4e0d\u5728\u7ebf\uff0c\u65e0\u6cd5\u53d7\u7406\u4f60\u7684\u7533\u8bf7");
        } else {
            String string2 = h3.b() + "-join-" + this.b.name;
            l l2 = (l)this.for.do(string2);
            if (l2 != null) {
                h3.try("\u4f60\u5df2\u7ecf\u7533\u8bf7\u8fc7\u4e86");
            } else {
                l2 = new l(h2, h3, string2);
                this.for.a(l2);
                String string3 = "\u73a9\u5bb6\u7533\u8bf7\u52a0\u5165\u4f60\u7684\u516c\u4f1a[\u540d\u5b57=" + h3.b() + ";\u804c\u4e1a=" + Player.RACE_NAMES[h3.r().race] + ";\u8f6c\u751f=" + h3.r().turns + ";\u7b49\u7ea7=" + h3.r().level + ";\u7533\u8bf7\u8bed:" + string + "]\u4f60\u540c\u610f\u5417\uff1f";
                b b2 = p.a(h3.b(), string2, string3);
                h2.a(b2);
                h3.do("\u5df2\u5c06\u9080\u8bf7\u53d1\u9001\u7ed9\u516c\u4f1a\u7ba1\u7406\u5458");
            }
        }
    }

    public boolean goto() {
        return this.b.deleted;
    }

    public void g(h h2) {
        Hero hero = h2.r();
        if (this.a.for() > 0) {
            this.a(p.if(h2.b(), hero.race, hero.turns, hero.level));
        }
        this.a.if(h2);
        h2.a(p.a(this.b));
        if (h2.g()) {
            b b2 = p.try(hero);
            h2.j().a(b2, h2.m(), h2.o(), h2);
        }
    }

    public void d() {
        this.a(p.if(this.b));
    }

    public h c() {
        return this.void;
    }

    public e(Guild guild) {
        this.do(guild.id);
        this.a(guild.name);
        this.a = new daff.a.h(50);
        guild.attachment = this;
        this.b = guild;
    }

    public void a(h h2) {
        this.b.onlineMemberCount += -1;
        if (this.a.for() > 0) {
            this.a(p.new(h2.b()));
        }
        Hero hero = h2.r();
        Guild.GuildMember guildMember = this.b.getMember(hero.name);
        guildMember.turns = hero.turns;
        guildMember.level = hero.level;
        guildMember.online = false;
        if (hero.guildPosition == 2) {
            this.void = null;
        }
    }

    public void f(h h2) {
        this.b.reputation += 100;
        Hero hero = h2.r();
        Guild.GuildMember guildMember = this.b.getMember(hero.name);
        guildMember.turns = hero.turns;
    }

    public void try(h h2, int n2) {
        Hero hero = h2.r();
        Guild.GuildMember guildMember = this.b.getMember(hero.name);
        guildMember.contribution = n2;
    }

    public void a(int n2, int n3, int n4) {
        this.b.taxedMoney += n2;
        this.b.taxedTreasure += n3;
        this.b.tmpTreasure += n4;
        while (this.b.tmpTreasure > 50) {
            ++this.b.taxedTreasure;
            this.b.tmpTreasure -= 50;
        }
        if (this.void != null) {
            this.void.a(p.a(this.b.taxedMoney, this.b.taxedTreasure));
        }
    }

    public Guild e() {
        return this.b;
    }

    public void a(x x2) {
        this.for = x2;
    }

    public void h(h h2) {
        this.b.reputation -= 5;
        if (this.b.reputation < 0) {
            this.b.reputation = 0;
        }
        h2.r().joinedGuild = null;
        h2.r().guildID = 0;
        h2.r().guildLevel = 0;
        h2.r().guildIcon = 0;
        h2.r().guildName = "";
        h2.a(p.i());
        this.a.do(h2);
        b b2 = p.int(h2.b());
        this.a(b2);
        if (h2.g()) {
            h2.I();
            b2 = p.try(h2.r());
            h2.j().a(b2, h2.m(), h2.o(), h2);
        }
    }

    public void a(h h2, int n2, Sign sign) {
        if (sign.life <= 0) {
            h2.j().E().a(h2, this);
            b b2 = p.d("\u516c\u4f1a\u3010" + this.b.name + "\u3011\u7684\u6807\u5fd7\u5728" + h2.j().int() + "\u7684(" + sign.x + "," + sign.y + ")\u88ab\u6467\u6bc1\u4e86\uff01");
            this.for.a(b2);
            if (this.b.cityID > 0) {
                u u2 = this.for.do(this.b.cityID);
                u2.a((e)null);
                u2.e(0);
                this.b.cityID = 0;
                this.b.battleGuild = null;
                this.b.battleTime = 0;
                this.b.challengerID = 0;
                this.a(p.do(this.b));
                e e2 = h2.J();
                if (e2 != null) {
                    e2.b.money += 1000000;
                    e2.a(p.if(e2.b));
                    e2.e().cityID = u2.try();
                    e2.e().cityName = u2.int();
                    e2.e().cityTakeTime = ServerInfo.currentTimeCode;
                    e2.e().tmpTreasure = 0;
                    e2.e().taxedTreasure = 0;
                    e2.e().taxedMoney = 0;
                    e2.a(p.do(e2.b));
                    u2.a(e2);
                    String string = "\u606d\u559c\u3016" + e2.int() + "\u3017\u6218\u80dc\u4e86\u3016" + this.b.name + "\u3017\uff0c\u53d6\u5f97" + u2.int() + "\u7edf\u6cbb\u6743\uff01";
                    this.for.a(p.d(string));
                    this.for.a(p.if(0, 0, 5, 5));
                }
            }
        } else if (sign.life + n2 == sign.maxLife) {
            Guild guild = h2.r().joinedGuild;
            String string = "";
            string = guild == null ? "\u4f60\u7684\u516c\u4f1a\u6807\u5fd7\u53d7\u5230\u73a9\u5bb6[" + h2.b() + "]\u7684\u653b\u51fb\uff01" : "\u4f60\u7684\u516c\u4f1a\u6807\u5fd7\u53d7\u5230\u516c\u4f1a[" + guild.name + "]\u7684\u653b\u51fb\uff01";
            b b3 = p.d(string);
            this.a(b3);
            this.else = sign.life;
        } else if (sign.life < sign.maxLife / 100) {
            if (this.a.for() > 0 && Math.random() * 100.0 < 10.0) {
                b b4 = p.try("\u4f60\u7684\u516c\u4f1a\u6807\u5fd7\u5373\u5c06\u88ab\u6467\u6bc1\u4e86\uff01");
                this.a(b4);
            }
        } else if (this.else - sign.life > sign.maxLife / 100) {
            Guild guild = h2.r().joinedGuild;
            String string = "";
            string = guild == null ? "\u4f60\u7684\u516c\u4f1a\u6807\u5fd7\u53d7\u5230\u73a9\u5bb6[" + h2.b() + "]\u7684\u653b\u51fb\uff01" : "\u4f60\u7684\u516c\u4f1a\u6807\u5fd7\u53d7\u5230\u516c\u4f1a[" + guild.name + "]\u7684\u653b\u51fb\uff01";
            b b5 = p.d(string);
            this.a(b5);
            this.else = sign.life;
        }
    }

    public void a(h h2, int n2, daff.a.e e2) {
        Hero hero = h2.r();
        switch (n2) {
            case 1793: {
                if (hero.name.equals(this.b.leader)) {
                    this.for.long().deleteGuild(this.b);
                    this.f();
                    b b2 = p.d("\u516c\u4f1a\u3010" + this.do + "\u3011\u88ab\u4f1a\u957f\u89e3\u6563\u4e86\uff01");
                    this.for.a(b2);
                    break;
                }
                Guild.GuildMember guildMember = this.b.removeMember(hero.name);
                if (guildMember == null) break;
                this.h(h2);
                break;
            }
            case 1794: {
                Guild.GuildMember guildMember;
                String string = e2.h();
                if (this.b.reputation < 10 || !hero.name.equals(this.b.leader) || string.equals(hero.name) || (guildMember = this.b.removeMember(string)) == null) break;
                this.try(string);
                break;
            }
            case 1795: {
                int n3 = e2.i();
                if (this.b.money >= 2000000000) {
                    h2.new("\u516c\u4f1a\u8d44\u4ea7\u5df2\u5230\u4e0a\u9650\u4e86");
                    break;
                }
                if (n3 <= 0 || n3 >= hero.personalDepot.money) break;
                hero.personalDepot.money -= n3;
                this.b.money += n3;
                this.a(p.do(hero.name, n3, 0));
                break;
            }
            case 1796: {
                if (hero.guildPosition != 1 && hero.guildPosition != 2) break;
                this.b.introduction = e2.h();
                this.a(p.goto(this.b.introduction));
                break;
            }
            case 1797: {
                if (hero.guildPosition != 1 && hero.guildPosition != 2) break;
                this.b.notice = e2.h();
                this.a(p.e(this.b.notice));
                break;
            }
            case 1798: {
                if (!hero.name.equals(this.b.leader)) break;
                String string = e2.h();
                int n4 = e2.for();
                Guild.GuildMember guildMember = this.b.getMember(string);
                if (guildMember == null || n4 == 2) break;
                guildMember.position = n4;
                h h3 = this.if(string);
                if (h3 != null) {
                    h3.r().guildPosition = n4;
                    h3.j().a(p.try(h3.r()), h3.m(), h3.o(), h3);
                }
                this.a(p.do(string, n4));
                break;
            }
            case 1799: {
                if (hero.guildPosition != 2 || this.b.reputation < 2) break;
                if (h2.i()) {
                    h2.try("\u6b7b\u4ea1\u72b6\u6001\u65e0\u6cd5\u4f20\u9001\u5bf9\u65b9");
                    break;
                }
                if (!h2.g()) {
                    h2.try("\u4f60\u6b63\u5728\u8fdb\u5165\u573a\u666f\u8fc7\u7a0b\u4e2d\uff0c\u65e0\u6cd5\u4f20\u9001\u5bf9\u65b9");
                    break;
                }
                if (h2.j().K() == 1) {
                    h2.try("\u4f60\u5728\u7ade\u6280\u573a\u4e0d\u80fd\u4f7f\u7528\u62c9\u4eba\u529f\u80fd");
                    break;
                }
                String string = e2.h();
                h h4 = this.if(string);
                if (h4 == null) {
                    h2.try("\u76ee\u6807\u73a9\u5bb6\u4e0d\u5728\u7ebf");
                    break;
                }
                if (h4.i()) {
                    h2.try("\u76ee\u6807\u73a9\u5bb6\u6b7b\u4ea1\u72b6\u6001\uff0c\u65e0\u6cd5\u4f20\u9001");
                    break;
                }
                if (h4.j().K() == 3) {
                    h2.try("\u76ee\u6807\u73a9\u5bb6\u5728\u76d1\u72f1\u4e2d\uff0c\u65e0\u6cd5\u4f20\u9001");
                    break;
                }
                if (!h4.g()) {
                    h2.try("\u76ee\u6807\u73a9\u5bb6\u6b63\u5728\u8fdb\u5165\u573a\u666f\u8fc7\u7a0b\u4e2d\uff0c\u65e0\u6cd5\u4f20\u9001");
                    break;
                }
                if (h4.D() != null) {
                    h2.try("\u76ee\u6807\u73a9\u5bb6\u6446\u644a\u72b6\u6001\uff0c\u65e0\u6cd5\u4f20\u9001");
                    break;
                }
                if (h4.j() == h2.j()) {
                    int n5 = h2.j().for(hero.x, hero.y);
                    int n6 = n5 & 0xFFFF;
                    int n7 = n5 >> 16;
                    h2.j().if(h4, n6, n7);
                    h4.a(p.long(n6, n7));
                    this.b.reputation -= 2;
                    this.a(p.new(this.b.reputation));
                    break;
                }
                if (this.for.a(h4, h2.j().try(), hero.x, hero.y)) {
                    this.b.reputation -= 2;
                    this.a(p.new(this.b.reputation));
                    break;
                }
                h2.try("\u4f20\u9001\u5931\u8d25\uff0c\u76ee\u6807\u73a9\u5bb6\u65e0\u6cd5\u8fdb\u5165\u5f53\u524d\u573a\u666f");
                break;
            }
            case 1819: {
                if (hero.guildPosition != 2 || this.b.reputation < 2) break;
                if (h2.i()) {
                    h2.try("\u6b7b\u4ea1\u72b6\u6001\u65e0\u6cd5\u4f20\u9001");
                    break;
                }
                if (!h2.g()) {
                    h2.try("\u4f60\u6b63\u5728\u8fdb\u5165\u573a\u666f\u8fc7\u7a0b\u4e2d\uff0c\u65e0\u6cd5\u4f20\u9001");
                    break;
                }
                if (h2.j().K() == 3) {
                    h2.try("\u4f60\u5728\u76d1\u72f1\u4e0d\u80fd\u4f7f\u7528\u4f20\u9001\u529f\u80fd");
                    break;
                }
                String string = e2.h();
                h h5 = this.if(string);
                if (h5 == null) {
                    h2.try("\u76ee\u6807\u73a9\u5bb6\u4e0d\u5728\u7ebf");
                    break;
                }
                if (h5.j().K() == 1) {
                    h2.try("\u76ee\u6807\u73a9\u5bb6\u5728\u7ade\u6280\u573a\uff0c\u65e0\u6cd5\u4f20\u9001");
                    break;
                }
                if (!h5.g()) {
                    h2.try("\u76ee\u6807\u73a9\u5bb6\u6b63\u5728\u8fdb\u5165\u573a\u666f\u8fc7\u7a0b\u4e2d\uff0c\u65e0\u6cd5\u4f20\u9001");
                    break;
                }
                if (h5.j() == h2.j()) {
                    int n8 = h2.j().for(h5.m(), h5.o());
                    int n9 = n8 & 0xFFFF;
                    int n10 = n8 >> 16;
                    h2.j().if(h2, n9, n10);
                    h2.a(p.long(n9, n10));
                    this.b.reputation -= 2;
                    this.a(p.new(this.b.reputation));
                    break;
                }
                if (!this.for.a(h2, h5.j().try(), h5.m(), h5.o())) break;
                this.b.reputation -= 2;
                this.a(p.new(this.b.reputation));
                break;
            }
            case 1800: {
                h h6;
                String string;
                Guild.GuildMember guildMember;
                if (!this.b.leader.equals(hero.name) || this.b.reputation < 100 || (guildMember = this.b.getMember(string = e2.h())) == null) break;
                guildMember.position = 2;
                String string2 = this.b.leader;
                this.b.leader = string;
                this.b.reputation -= 100;
                hero.guildPosition = 1;
                this.b.getMember((String)hero.name).position = 1;
                b b3 = p.d("\u3010" + string2 + "\u3011\u5c06\u516c\u4f1a\u3010" + this.b.name + "\u3011\u8f6c\u8ba9\u7ed9\u3010" + this.b.leader + "\u3011\u4e86\uff01");
                this.for.a(b3);
                b3 = p.if(string2, this.b.leader, this.b.reputation);
                this.a(b3);
                if (h2.g()) {
                    h2.j().a(p.try(hero), hero.x, hero.y, h2);
                }
                if ((h6 = this.if(string)) != null && h6.g()) {
                    h6.r().guildPosition = 2;
                    h6.j().a(p.try(h6.r()), h6.m(), h6.o(), h6);
                }
                this.void = h6;
                break;
            }
            case 1801: {
                int n11 = e2.for();
                if (this.b.level <= 1 || n11 < 0 || n11 >= hero.personalDepot.goodsList.length || hero.personalDepot.goodsList[n11] == null || hero.personalDepot.goodsList[n11].storable <= 0) break;
                int n12 = this.b.getNextFreeGoodsPos();
                if (n12 >= 0) {
                    this.b.goodsList[n12] = hero.personalDepot.goodsList[n11];
                    b b4 = p.a(n12, hero.personalDepot.goodsList[n11], h2.b());
                    this.a(b4);
                    h2.long(n11);
                    break;
                }
                h2.new("\u516c\u4f1a\u4ed3\u5e93\u4e2d\u6ca1\u6709\u7a7a\u95f2\u4f4d\u7f6e\u4e86");
                break;
            }
            case 1802: {
                int n13 = e2.for();
                if (this.b.level <= 1 || hero.guildPosition != 1 && hero.guildPosition != 2 || n13 < 0 || n13 >= this.b.storeCapacity || this.b.goodsList[n13] == null) break;
                int n14 = hero.personalDepot.getNextFreePos();
                if (n14 >= 0) {
                    h2.a(this.b.goodsList[n13]);
                    this.b.goodsList[n13] = null;
                    b b5 = p.do(n13);
                    this.a(b5);
                    break;
                }
                h2.new("\u80cc\u5305\u4e2d\u6ca1\u6709\u7a7a\u95f2\u4f4d\u7f6e\u4e86");
                break;
            }
            case 1803: {
                if (hero.guildPosition != 2) break;
                String string = e2.h();
                int n15 = e2.i();
                Guild.GuildMember guildMember = this.b.getMember(string);
                if (guildMember == null) break;
                guildMember.contribution = n15;
                b b6 = p.try(string, n15);
                this.a(b6);
                break;
            }
            case 1804: {
                int n16;
                if (hero.guildPosition != 2 && hero.guildPosition != 1 || (n16 = e2.i()) <= 0 || n16 > this.b.money) break;
                this.b.money -= n16;
                b b7 = p.if(hero.name, n16, 0);
                this.a(b7);
                hero.personalDepot.money += n16;
                h2.a(p.case(hero));
                break;
            }
            case 1805: {
                int n17 = e2.i();
                if (hero.guildPosition != 2) {
                    h2.try("\u4f60\u4e0d\u662f\u4f1a\u957f\uff0c\u4e0d\u80fd\u8bbe\u7f6e\u654c\u5bf9\u516c\u4f1a");
                    break;
                }
                e e3 = this.for.new(n17);
                if (e3 == null) break;
                this.b.addEnemy(n17);
                b b8 = p.d("\u3010" + this.b.name + "\u3011\u7684\u4f1a\u957f\u628a\u3010" + e3.int() + "\u3011\u8bbe\u7f6e\u4e3a\u654c\u5bf9\u516c\u4f1a");
                this.for.a(b8);
                break;
            }
            case 1806: {
                int n18 = e2.i();
                if (hero.guildPosition != 2) {
                    h2.try("\u4f60\u4e0d\u662f\u4f1a\u957f\uff0c\u4e0d\u80fd\u53d6\u6d88\u654c\u5bf9\u516c\u4f1a");
                    break;
                }
                e e4 = this.for.new(n18);
                if (e4 == null) break;
                this.b.removeEnemy(n18);
                b b9 = p.d("\u3010" + this.b.name + "\u3011\u7684\u4f1a\u957f\u53d6\u6d88\u4e86\u5bf9\u3010" + e4.int() + "\u3011\u7684\u654c\u5bf9\u5173\u7cfb");
                this.for.a(b9);
                break;
            }
            case 1807: {
                if (hero.guildPosition != 2 || this.b.placedSign == null) break;
                if (this.b.cityID > 0 && h2.j().F() > 0) {
                    h2.try("\u73b0\u5728\u4e0d\u80fd\u53d6\u6d88\u516c\u4f1a\u6807\u5fd7");
                    break;
                }
                this.b.placedSign.life = 0;
                b b10 = p.d("\u3010" + hero.name + "\u3011\u628a" + h2.j().int() + "\u7684\u516c\u4f1a\u6807\u5fd7\u53d6\u6d88\u4e86\uff01");
                this.for.a(b10);
                if (this.b.reputation > 0) {
                    this.b.reputation = Math.max(0, this.b.reputation - 100);
                    this.a(p.new(this.b.reputation));
                }
                int n19 = this.a.for();
                int n20 = 0;
                while (n20 < n19) {
                    h h7 = (h)this.a.if(n20);
                    h7.I();
                    ++n20;
                }
                break;
            }
            case 1808: {
                if (this.b.placedSign == null || hero.life <= 0 || hero.life >= hero.maxLife || this.b.placedSign.life <= hero.maxLife) break;
                int n21 = hero.maxLife - hero.life;
                h2.for(n21);
                this.b.placedSign.life -= n21;
                h2.j().a(p.try(this.b.placedSign.id, this.b.placedSign.life, 500), hero.x, hero.y, null);
                break;
            }
            case 1809: {
                if (this.b.placedSign == null || hero.life <= 1 || this.b.placedSign.life >= this.b.placedSign.maxLife) break;
                int n22 = Math.min(hero.life - 1, this.b.placedSign.maxLife - this.b.placedSign.life);
                h2.for(-n22);
                this.b.placedSign.life += n22;
                h2.j().a(p.try(this.b.placedSign.id, this.b.placedSign.life, 500), hero.x, hero.y, null);
                break;
            }
            case 1810: {
                if (h2.j().K() == 1) {
                    h2.try("\u4e0d\u80fd\u5728\u7ade\u6280\u573a\u5730\u96c6\u7ed3\u516c\u4f1a\u6210\u5458");
                    break;
                }
                if (hero.guildPosition != 2) break;
                b b11 = p.if();
                int n23 = this.a.for();
                int n24 = 0;
                int n25 = 0;
                while (n25 < n23) {
                    h h8 = (h)this.a.if(n25);
                    if (!(h8 == h2 || h8.j() == h2.j() && h2.j().a(h8.m(), h8.o(), hero.x, hero.y))) {
                        h8.a(b11);
                        ++n24;
                    }
                    ++n25;
                }
                h2.for("\u5df2\u5c06\u96c6\u7ed3\u4fe1\u606f\u53d1\u9001\u7ed9" + n24 + "\u4e2a\u6210\u5458");
                break;
            }
            case 1811: {
                int n26 = 1000;
                if (hero.guildPosition != 1 && hero.guildPosition != 2 && this.b.money < n26) {
                    h2.try("\u516c\u4f1a\u8d44\u91d1\u4e0d\u8db3\uff0c\u4f20\u9001\u5230\u5de5\u4f1a\u6807\u5fd7\u5904\u9700\u8981\u6d88\u8017" + n26);
                    break;
                }
                if (this.b.placedSign == null) {
                    h2.try("\u4f60\u7684\u516c\u4f1a\u8fd8\u8fd8\u6ca1\u6709\u5efa\u7acb\u516c\u4f1a\u9a7b\u5730");
                    break;
                }
                if (h2.j().K() == 3) {
                    h2.try("\u4f60\u5728\u76d1\u72f1\u4e2d\uff0c\u65e0\u6cd5\u524d\u5f80\u516c\u4f1a\u9a7b\u5730");
                    break;
                }
                if (h2.j().try() == this.b.placedSign.sceneID) {
                    int n27 = h2.j().for(this.b.placedSign.x, this.b.placedSign.y);
                    int n28 = n27 & 0xFFFF;
                    int n29 = n27 >> 16;
                    h2.a(p.long(n28, n29));
                    h2.j().if(h2, n28, n29);
                    if (hero.guildPosition == 1 || hero.guildPosition == 2) break;
                    this.b.money -= n26;
                    this.a(p.if(this.b));
                    break;
                }
                if (!this.for.a(h2, this.b.placedSign.sceneID, this.b.placedSign.x, this.b.placedSign.y) || hero.guildPosition == 1 || hero.guildPosition == 2) break;
                this.b.money -= n26;
                this.a(p.if(this.b));
                break;
            }
            case 1812: {
                if (this.b.level < 5 || hero.guildPosition != 2 || h2.j().p() != this) break;
                daff.a.h h9 = h2.j().a;
                int n30 = h9.for();
                b b12 = p.c(1821);
                e2 = b12.for();
                int n31 = 0;
                while (n31 < n30) {
                    h h10 = (h)h9.if(n31);
                    if (h10.g() && h10.r().gmGrade == 0 && h10 != h2) {
                        e2.a(h10.b());
                        e2.a(h10.m());
                        e2.a(h10.o());
                    }
                    ++n31;
                }
                h2.a(b12);
                break;
            }
            case 1813: {
                if (this.b.level < 5 || hero.guildPosition != 2 || h2.j().p() != this) break;
                String string = e2.h();
                h h11 = h2.j().if(string);
                if (h11 == null) {
                    h2.try("\u76ee\u6807\u73a9\u5bb6\u5df2\u79bb\u5f00\u5f53\u524d\u573a\u666f");
                    break;
                }
                if (!h11.g()) {
                    h2.try("\u76ee\u6807\u73a9\u5bb6\u6b63\u5728\u8fdb\u5165\u573a\u666f\u7684\u8fc7\u7a0b\u4e2d");
                    break;
                }
                int n32 = h2.j().for(h11.m(), h11.o());
                if (n32 <= 0) break;
                int n33 = n32 & 0xFFFF;
                int n34 = n32 >> 16;
                h2.j().if(h2, n33, n34);
                h2.a(p.long(n33, n34));
                break;
            }
            case 1814: {
                int n35 = e2.for();
                if (n35 >= 100 || this.b.level < 5 || hero.guildPosition != 2 || h2.j().p() != this) break;
                this.b.cityTaxRate = n35;
                h2.for("\u6446\u644a\u7a0e\u7387\u5df2\u8bbe\u7f6e\u4e3a" + n35);
                String string = "\u3010" + hero.name + "\u3011\u5c06" + h2.j().int() + "\u7684\u73a9\u5bb6\u6446\u644a\u7a0e\u7387\u8bbe\u4e3a" + n35 + "%";
                this.for.a(p.d(string));
                break;
            }
            case 1815: {
                String string = e2.h();
                if (this.b.level < 5 || hero.guildPosition != 2 || h2.j().p() != this) break;
                this.b.cityEnterTip = string;
                h2.for("\u6b22\u8fce\u4fe1\u606f\u5df2\u7ecf\u8bbe\u7f6e");
                break;
            }
            case 1816: {
                if (this.b.level < 5 || hero.guildPosition != 2 || h2.j().p() != this) break;
                h2.j().a(p.else(e2.h()));
                break;
            }
            case 1817: {
                int n36 = e2.i();
                if (this.b.level < 5 || hero.guildPosition != 2 || h2.j().p() != this || n36 <= 0 || n36 > this.b.taxedMoney) break;
                this.b.taxedMoney -= n36;
                hero.personalDepot.money += n36;
                h2.a(p.case(hero));
                h2.a(p.a(this.b.taxedMoney, this.b.taxedTreasure));
                h2.for("\u4f60\u4ece\u57ce\u5e02\u8d44\u4ea7\u4e2d\u63d0\u53d6\u4e86" + n36 + "\u91d1\u5e01");
                break;
            }
            case 1818: {
                int n37 = e2.i();
                if (this.b.level < 5 || hero.guildPosition != 2 || h2.j().p() != this || n37 <= 0 || n37 > this.b.taxedTreasure) break;
                this.b.taxedTreasure -= n37;
                hero.user.treasure += n37;
                h2.a(p.case(hero));
                h2.a(p.a(this.b.taxedMoney, this.b.taxedTreasure));
                h2.for("\u4f60\u4ece\u57ce\u5e02\u8d44\u4ea7\u4e2d\u63d0\u53d6\u4e86" + n37 + "\u5143\u5b9d");
                break;
            }
        }
    }

    public void byte() {
        this.b.dataChanged = true;
        if (this.b.money < 100000 && ServerInfo.currentMilliSecond - this.long > 60000L) {
            if (this.a.for() > 0) {
                this.a(p.d("\u4f60\u7684\u516c\u4f1a\u8d44\u91d1\u4e0d\u8db310\u4e07\uff0c\u6709\u88ab\u7cfb\u7edf\u89e3\u6563\u7684\u98ce\u9669\uff01"));
            }
            this.long = ServerInfo.currentMilliSecond;
        } else if (this.b.reputation <= 10 && ServerInfo.currentMilliSecond - this.long > 60000L) {
            if (this.a.for() > 0) {
                this.a(p.d("\u4f60\u7684\u516c\u4f1a\u58f0\u671b\u592a\u4f4e\uff0c\u6709\u88ab\u7cfb\u7edf\u89e3\u6563\u7684\u98ce\u9669\uff01"));
            }
            this.long = ServerInfo.currentMilliSecond;
        }
        if (ServerInfo.guildDailyMoneyCost > 0 && ServerInfo.currentTimeParts[3] == 0 && ServerInfo.currentTimeParts[4] == 0 && ServerInfo.currentTimeParts[2] != this.goto) {
            this.goto = ServerInfo.currentTimeParts[2];
            this.b.money -= this.b.level * ServerInfo.guildDailyMoneyCost;
            if (this.b.money < 0 || this.b.reputation < 0) {
                this.void();
            } else {
                this.d();
            }
        }
        if (this.b.placedSign != null && this.b.placedSign.life > 0 && ServerInfo.currentMilliSecond - this.b.placedSign.lastAddReputationTime > 3600000L) {
            ++this.b.reputation;
            this.a(p.new(this.b.reputation));
            this.b.placedSign.lastAddReputationTime = ServerInfo.currentMilliSecond;
        }
    }

    public void f() {
        u u2;
        b b2 = p.i();
        int n2 = this.a.for();
        int n3 = 0;
        while (n3 < n2) {
            h h2 = (h)this.a.if(n3);
            h2.a(b2);
            h2.r().guildID = 0;
            h2.r().guildIcon = 0;
            h2.r().guildLevel = 0;
            h2.r().guildName = "";
            h2.r().joinedGuild = null;
            if (h2.g()) {
                h2.I();
                h2.j().a(p.try(h2.r()), h2.m(), h2.o(), h2);
            }
            ++n3;
        }
        this.void = null;
        if (this.b.cityID > 0 && (u2 = this.for.do(this.b.cityID)) != null) {
            u2.a((e)null);
        }
    }

    public void try(String string) {
        b b2;
        h h2;
        this.b.reputation -= 10;
        if (this.b.reputation < 0) {
            this.b.reputation = 0;
        }
        if ((h2 = this.if(string)) != null) {
            h2.r().guildID = 0;
            h2.r().guildLevel = 0;
            h2.r().guildIcon = 0;
            h2.r().guildName = "";
            h2.r().joinedGuild = null;
            h2.try("\u4f1a\u957f\u5c06\u4f60\u4ece\u516c\u4f1a\u4e2d\u5f00\u9664\u4e86");
            h2.a(p.i());
            this.a.do(h2);
            if (h2.g()) {
                h2.I();
                b2 = p.try(h2.r());
                h2.j().a(b2, h2.m(), h2.o(), h2);
            }
        }
        b2 = p.case(string);
        this.a(b2);
    }

    public void for(String string) {
        b b2 = p.int(string);
        this.a(b2);
    }

    public void long() {
        if (this.b.level >= 5) {
            return;
        }
        ++this.b.level;
        this.b.memberCapacity += 20;
        this.b.storeCapacity += 50;
        b b2 = p.d("\u516c\u4f1a\u3010" + this.do + "\u3011\u6210\u529f\u5347\u7ea7\u6210\u4e3a" + this.b.level + "\u7ea7\u516c\u4f1a\uff01");
        this.for.a(b2);
        b2 = p.do();
        int n2 = this.a.for();
        int n3 = 0;
        while (n3 < n2) {
            h h2 = (h)this.a.if(n3);
            h2.a(b2);
            if (h2.g()) {
                h2.j().a(p.try(h2.r()), h2.m(), h2.o(), h2);
            }
            ++n3;
        }
    }

    public void e(h h2) {
        this.b.addMember((Player)h2.r()).online = true;
        Hero hero = h2.r();
        hero.guildID = this.b.id;
        hero.joinedGuild = this.b;
        hero.guildPosition = 0;
        this.g(h2);
    }

    public void int(String string) {
        this.b.name = string;
        this.a(string);
        b b2 = p.do(string);
        int n2 = this.a.for();
        int n3 = 0;
        while (n3 < n2) {
            h h2 = (h)this.a.if(n3);
            h2.a(b2);
            if (h2.g()) {
                h2.j().a(p.try(h2.r()), h2.m(), h2.o(), h2);
            }
            ++n3;
        }
    }

    public boolean new(String string) {
        return this.b.getMember(string) != null;
    }

    public void i(h h2) {
        Hero hero = h2.r();
        this.b.leader = hero.name;
        this.b.money = ServerInfo.guildInitialMoney;
        this.b.addMember((Player)hero, (int)2).online = true;
        hero.guildID = this.b.id;
        hero.joinedGuild = this.b;
        hero.guildPosition = 2;
        h2.a(p.for(this.b));
        this.a.if(h2);
        ++this.b.onlineMemberCount;
        b b2 = p.d("\u3010" + hero.name + "\u3011\u6210\u529f\u521b\u5efa\u516c\u4f1a\u3010" + this.b.name + "\u3011\uff01");
        this.for.a(b2);
        if (h2.g()) {
            b2 = p.try(hero);
            h2.j().a(b2, h2.m(), h2.o(), h2);
        }
        this.c = this.goto = ServerInfo.currentTimeParts[2];
    }

    public void int(h h2) {
        ++this.b.onlineMemberCount;
        Hero hero = h2.r();
        Guild.GuildMember guildMember = this.b.getMember(hero.name);
        hero.guildPosition = guildMember.position;
        guildMember.race = hero.race;
        guildMember.turns = hero.turns;
        guildMember.level = hero.level;
        guildMember.online = true;
        if (this.a.for() > 1) {
            this.a(p.do(hero.name, hero.race, hero.turns, hero.level), h2);
        }
        h2.a(p.int(this.b));
        if (hero.guildPosition == 2) {
            this.void = h2;
        }
    }

    public void d(h h2) {
        ++this.b.reputation;
        Hero hero = h2.r();
        Guild.GuildMember guildMember = this.b.getMember(hero.name);
        guildMember.level = hero.level;
    }

    public void void() {
        if (this.b.level > 1) {
            this.b.level += -1;
            this.b.memberCapacity += 20;
            this.b.storeCapacity += 50;
            b b2 = p.d("\u516c\u4f1a\u3010" + this.do + "\u3011\u7531\u4e8e\u8fd0\u8f6c\u4e0d\u7075\uff0c\u88ab\u964d\u7ea7\u4e3a" + this.b.level + "\u7ea7\u516c\u4f1a\uff01");
            this.for.a(b2);
            b2 = p.for();
            int n2 = this.a.for();
            int n3 = 0;
            while (n3 < n2) {
                h h2 = (h)this.a.if(n3);
                h2.a(b2);
                if (h2.g()) {
                    h2.j().a(p.try(h2.r()), h2.m(), h2.o(), h2);
                }
                ++n3;
            }
        } else {
            this.for.long().deleteGuild(this.b);
            this.f();
            b b3 = p.d("\u516c\u4f1a\u3010" + this.do + "\u3011\u7ecf\u8425\u4e0d\u5584\uff0c\u88ab\u7cfb\u7edf\u89e3\u6563\u4e86\uff01");
            this.for.a(b3);
        }
    }
}

