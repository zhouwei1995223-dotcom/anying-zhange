/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs;

import app.island.a;
import app.island.data.Goods;
import app.island.data.SpecialProperty;
import app.island.entity.Guild;
import app.island.entity.Hero;
import app.island.entity.Player;
import app.island.entity.User;
import app.island.gs.ServerInfo;
import app.island.gs.b;
import app.island.gs.c;
import app.island.gs.c.i;
import app.island.gs.d;
import app.island.gs.data.HeroRankData;
import app.island.gs.data.SceneConfigData;
import app.island.gs.e;
import app.island.gs.f;
import app.island.gs.h;
import app.island.gs.j;
import app.island.gs.k;
import app.island.gs.p;
import app.island.gs.q;
import app.island.gs.s;
import app.island.gs.t;
import app.island.gs.u;
import app.island.gs.v;
import app.island.gs.w;
import app.island.gs.y;
import daff.a.n;
import java.io.File;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class x {
    private static x goto = null;
    private daff.a.h a = new daff.a.h(100);
    private daff.a.h char = new daff.a.h(200);
    private HeroRankData[] byte;
    private daff.a.h do = new daff.a.h(100);
    private daff.a.q if = new daff.a.q(29999);
    private daff.a.h f = new daff.a.h(1000);
    private daff.a.h int = new daff.a.h(200);
    private daff.a.h new = new daff.a.h(200);
    private e[] void = new e[1000];
    private int for;
    private t c;
    private d long;
    private daff.a.h e = new daff.a.h(100);
    private c case;
    private long d;
    private s b;
    private y try;
    private f else;
    private static /* synthetic */ Class class$app$island$gs$data$SceneConfigData;

    private void if(h h2, String string) {
        Hero hero = h2.r();
        if (hero.level < 60) {
            return;
        }
        int n2 = (hero.level - 60) / 10 + 5;
        if (hero.friendList.studentCount >= n2) {
            h2.try("\u4f60\u5f53\u524d\u53ef\u62db\u6536\u7684\u5f92\u5f1f\u5df2\u8fbe\u5230\u6700\u5927\u6570");
            return;
        }
        h h3 = this.if(string);
        if (h3 == null) {
            h2.try("\u76ee\u6807\u73a9\u5bb6\u4e0d\u5728\u7ebf");
            return;
        }
        if (h3.r().friendList.studentCount > 0) {
            h2.try("\u76ee\u6807\u73a9\u5bb6\u5df2\u7ecf\u662f\u5e08\u7236\u4e86\uff0c\u4e0d\u80fd\u62db\u4e3a\u5f92\u5f1f");
            return;
        }
        if (h3.r().friendList.master != null) {
            h2.try("\u5bf9\u65b9\u5df2\u7ecf\u6709\u5e08\u7236\u4e86");
            return;
        }
        if (h3.r().level >= hero.level) {
            h2.try("\u53ea\u80fd\u62db\u6536\u7b49\u7ea7\u6bd4\u81ea\u5df1\u4f4e\u7684\u73a9\u5bb6\u4e3a\u5f92\u5f1f");
            return;
        }
        string = hero.name + "-studentInvite-" + string;
        i i2 = this.do(string);
        if (i2 != null) {
            h2.try("\u4f60\u5df2\u7ecf\u9080\u8bf7\u8fc7\u5bf9\u65b9\u4e86");
            return;
        }
        app.island.gs.c.c c2 = new app.island.gs.c.c(h2, h3, string);
        this.a(c2);
        String string2 = h2.b() + "\u9080\u8bf7\u4f60\u4f5c\u4e3a\u4ed6\u7684\u5f92\u5f1f\uff0c\u4f60\u540c\u610f\u5417\uff1f";
        app.b.b b2 = p.a(h2.b(), string, string2);
        h3.a(b2);
        h2.do("\u5df2\u5c06\u9080\u8bf7\u53d1\u9001\u7ed9\u300e" + h3.b() + "\u300f");
    }

    public d c() {
        return this.long;
    }

    public void g() {
        int n2 = 0;
        while (n2 < this.for) {
            this.void[n2].e().onlineMemberCount = 0;
            ++n2;
        }
        this.try();
        this.char();
    }

    public static x for() {
        if (goto == null) {
            goto = new x();
        }
        return goto;
    }

    public daff.a.h a() {
        return this.f;
    }

    public void a(app.b.b b2) {
        int n2 = this.char.for();
        int n3 = 0;
        while (n3 < n2) {
            u u2 = (u)this.char.if(n3);
            u2.a(b2);
            ++n3;
        }
    }

    public void a(Hero hero) {
        if (hero.gmGrade == 0 && hero.rank > 0) {
            int n2 = 0;
            while (n2 < this.byte.length) {
                this.byte[n2].rankHero(hero);
                ++n2;
            }
        }
    }

    public i do(String string) {
        int n2 = this.e.for();
        int n3 = 0;
        while (n3 < n2) {
            i i2 = (i)this.e.if(n3);
            if (string.equals(i2.if())) {
                return i2;
            }
            ++n3;
        }
        return null;
    }

    public int if(int n2) {
        u u2 = this.for(n2);
        if (u2 == null) {
            return 0;
        }
        int n3 = 1000000 + ServerInfo.createdDuplicateCount++;
        u u3 = new u();
        u3.a(u2);
        u3.do(n3);
        this.char.if(u3);
        return n3;
    }

    public void a(h h2) {
        Hero hero = h2.r();
        if (h2.n() != null) {
            h2.n().for();
        }
        if (h2.x() != null) {
            h2.x().byte();
        }
        if (h2.int() != null) {
            h2.int().do(h2);
        }
        if (h2.D() != null) {
            h2.D().k();
        }
        if (hero.joinedGuild != null && hero.joinedGuild.attachment != null) {
            h2.J().do(h2);
        }
        if (h2.j() != null) {
            h2.j().do(h2);
        }
        this.if.a(h2.b());
        this.f.do(h2);
        h2.K();
        this.do(h2);
        this.a(h2.r());
        if (hero.race == 0) {
            ServerInfo.elfCount += -1;
        } else if (hero.race == 1) {
            ServerInfo.manCount += -1;
        } else if (hero.race == 2) {
            ServerInfo.orcCount += -1;
        }
        if (h2.for()) {
            ServerInfo.heroUsingAppletCount += -1;
        }
    }

    public v a(int n2) {
        int n3 = this.a.for();
        int n4 = 0;
        while (n4 < n3) {
            v v2 = (v)this.a.if(n4);
            if (v2.try() == n2) {
                return v2;
            }
            ++n4;
        }
        return null;
    }

    private void case() {
        System.out.println("loading shops...");
        File file = new File("config/shop");
        if (!file.exists() || !file.isDirectory()) {
            return;
        }
        String[] stringArray = file.list();
        int n2 = 0;
        while (n2 < stringArray.length) {
            if (stringArray[n2].endsWith(".txt")) {
                File file2 = new File(file, stringArray[n2]);
                byte[] byArray = daff.a.b.a(file2);
                String string = new String(byArray);
                v v2 = new v();
                v2.a(this);
                v2.byte(string);
                this.a.if(v2);
            }
            ++n2;
        }
    }

    private void try() {
        int n2 = 0;
        while (n2 < this.byte.length) {
            if (this.byte[n2].changed) {
                daff.a.i i2 = app.island.a.a().a(this.byte[n2]);
                String string = i2.toString();
                byte[] byArray = string.getBytes();
                daff.a.b.a("data/top/" + this.byte[n2].type + ".txt", byArray);
            }
            ++n2;
        }
    }

    public f new() {
        return this.else;
    }

    public e[] d() {
        return this.void;
    }

    public void a(i i2) {
        i2.a(ServerInfo.currentMilliSecond);
        this.e.if(i2);
    }

    public void a(h h2, int n2) {
        app.b.b b2 = p.a(this.void, this.for, n2);
        h2.a(b2);
    }

    public void b() {
        Object object;
        int n2 = this.char.for();
        int n3 = 0;
        while (n3 < n2) {
            object = (u)this.char.if(n3);
            ((u)object).byte();
            if (!((u)object).L()) {
                ((u)object).I();
                this.char.a(n3--);
                --n2;
            }
            ++n3;
        }
        if (ServerInfo.updatingCounter % 30 == 0) {
            n2 = this.int.for();
            n3 = 0;
            while (n3 < n2) {
                object = (b)this.int.if(n3);
                if (((b)object).case()) {
                    ((k)object).byte();
                } else {
                    ((b)object).char();
                    this.int.a(n3--);
                    --n2;
                }
                ++n3;
            }
            n2 = this.new.for();
            n3 = 0;
            while (n3 < n2) {
                object = (j)this.new.if(n3);
                if (((j)object).a()) {
                    ((j)object).for();
                } else {
                    this.new.a(n3--);
                    --n2;
                }
                ++n3;
            }
        }
        if (ServerInfo.updatingCounter % 100 == 0) {
            n2 = this.e.for();
            n3 = 0;
            while (n3 < n2) {
                object = (i)this.e.if(n3);
                ((i)object).for();
                if (!((i)object).a()) {
                    ((i)object).do();
                    this.e.a(n3--);
                    --n2;
                }
                ++n3;
            }
        }
        if (ServerInfo.updatingCounter % 500 == 0) {
            n2 = this.a.for();
            n3 = 0;
            while (n3 < n2) {
                object = (v)this.a.if(n3);
                ((v)object).byte();
                ++n3;
            }
        }
        if (ServerInfo.updatingCounter % 600 == 0) {
            n3 = 0;
            while (n3 < this.for) {
                object = this.void[n3];
                ((e)object).byte();
                if (((e)object).goto()) {
                    this.for += -1;
                    this.void[n3] = this.void[this.for];
                    this.void[this.for] = null;
                    --n3;
                }
                ++n3;
            }
        }
        if (ServerInfo.updatingCounter % 100 == 0) {
            this.c.if();
        }
        if (ServerInfo.updatingCounter % 100 == 0) {
            this.long.byte();
        }
        n2 = this.f.for();
        n3 = 0;
        while (n3 < n2) {
            object = (h)this.f.if(n3);
            if (((h)object).goto()) {
                ((h)object).M();
                if (ServerInfo.currentMilliSecond - ((h)object).d() > (long)ServerInfo.saveUserDelay) {
                    ((h)object).a(ServerInfo.currentMilliSecond);
                    this.case.saveUser(((h)object).r().user, null);
                }
            } else {
                this.f.a(n3);
                --n3;
                --n2;
            }
            ++n3;
        }
        if (ServerInfo.currentMilliSecond - this.d > 300000L) {
            this.d = ServerInfo.currentMilliSecond;
            ServerInfo.countsOfOnline[ServerInfo.countsArrayPointer++] = this.f.for();
            n3 = 0;
            int n4 = 0;
            while (n4 < ServerInfo.countsArrayPointer) {
                n3 += ServerInfo.countsOfOnline[n4];
                ++n4;
            }
            ServerInfo.averageOnlineCount = n3 / ServerInfo.countsArrayPointer;
            String string = "curOnlineCount=" + this.f.for() + ";averageOnlineCount=" + ServerInfo.averageOnlineCount + ";elfCount=" + ServerInfo.elfCount + ";manCount=" + ServerInfo.manCount + ";orcCount=" + ServerInfo.orcCount + ";payedTreasure=" + ServerInfo.payedTreasure;
            this.case.saveUserLog("system", "system", "serverOnlineLog", string);
        }
        this.do().a();
    }

    public void a(b b2) {
        this.int.if(b2);
    }

    public boolean a(h h2, int n2, int n3, int n4) {
        if (!h2.g() && h2.j() != null || h2.i() || h2.D() != null) {
            return false;
        }
        u u2 = this.do(n2);
        if (u2 != null) {
            Hero hero = h2.r();
            if (hero.gmGrade == 0 && u2.z().minTurn > hero.turns) {
                h2.try("\u65e0\u6cd5\u524d\u5f80\uff0c\u76ee\u6807\u573a\u666f\u9650\u5236\u6700\u4f4e\u8f6c\u751f" + u2.z().minTurn);
            } else if (hero.gmGrade == 0 && u2.z().maxTurn < hero.turns) {
                h2.try("\u65e0\u6cd5\u524d\u5f80\uff0c\u76ee\u6807\u573a\u666f\u9650\u5236\u6700\u9ad8\u8f6c\u751f" + u2.z().maxTurn);
            } else if (hero.gmGrade == 0 && u2.z().minHeroLevel > hero.level) {
                h2.try("\u65e0\u6cd5\u524d\u5f80\uff0c\u76ee\u6807\u573a\u666f\u9650\u5236\u6700\u4f4e\u7b49\u7ea7" + u2.z().minHeroLevel);
            } else if (hero.gmGrade == 0 && u2.z().maxHeroLevel < hero.level) {
                h2.try("\u65e0\u6cd5\u524d\u5f80\uff0c\u76ee\u6807\u573a\u666f\u9650\u5236\u6700\u9ad8\u7b49\u7ea7" + u2.z().maxHeroLevel);
            } else if (u2 == h2.j()) {
                h2.try("\u4f60\u5c31\u5728\u5f53\u524d\u573a\u666f");
            } else if (u2.for(h2)) {
                u u3 = h2.j();
                if (u3 != null) {
                    u3.do(h2);
                }
                h2.if(n3, n4);
                u2.if(h2);
                return true;
            }
        } else {
            h2.try("\u627e\u4e0d\u5230\u76ee\u6807\u573a\u666f\uff1a" + n2);
        }
        return false;
    }

    public void f() {
        this.d = System.currentTimeMillis();
    }

    public daff.a.h h() {
        return this.char;
    }

    public void a(e e2) {
        if (this.for >= this.void.length) {
            e[] eArray = new e[this.for * 2];
            System.arraycopy(this.void, 0, eArray, 0, this.for);
            this.void = eArray;
        }
        this.void[this.for++] = e2;
    }

    public void goto() {
        int n2 = 0;
        while (n2 < this.for) {
            int n3 = n2 + 1;
            while (n3 < this.for) {
                if (this.void[n3].e().reputation > this.void[n2].e().reputation) {
                    e e2 = this.void[n2];
                    this.void[n2] = this.void[n3];
                    this.void[n3] = e2;
                }
                ++n3;
            }
            ++n2;
        }
    }

    private void if() {
        daff.a.h h2 = this.case.loadAllGuilds();
        System.out.println("init guilds,total:" + h2.for());
        this.for = h2.for();
        int n2 = 0;
        while (n2 < this.for) {
            Guild guild = (Guild)h2.if(n2);
            if (guild.getMember(guild.leader) != null) {
                u u2;
                e e2 = new e(guild);
                e2.a(this);
                this.void[n2] = e2;
                if (guild.cityID > 0 && (u2 = this.do(guild.cityID)) != null) {
                    guild.cityName = u2.int();
                    u2.a(e2);
                }
                if (guild.placedSign != null) {
                    u2 = this.do(guild.placedSign.sceneID);
                    if (u2 != null) {
                        u2.a(guild.placedSign);
                    } else {
                        guild.placedSign = null;
                    }
                }
            } else {
                this.case.deleteGuild(guild);
            }
            ++n2;
        }
        n2 = 0;
        while (n2 < this.for) {
            int n3 = this.void[n2].e().challengerID;
            if (n3 > 0) {
                this.void[n2].e().battleGuild = this.new(n3).e();
            }
            ++n2;
        }
    }

    private String a(h h2, Hero hero, String string) {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append(hero.name);
        stringBuffer.append('[');
        if (h2.r().gmGrade > 1) {
            stringBuffer.append("User=");
            stringBuffer.append(hero.user.name);
            stringBuffer.append(";\u5143\u5b9d=");
            stringBuffer.append(hero.user.treasure);
            stringBuffer.append(";\u8d26\u53f7\u5145\u503c=");
            stringBuffer.append(hero.user.payedTreasure);
            stringBuffer.append(";\u8d26\u53f7\u6536\u76ca=");
            stringBuffer.append(hero.user.earnedTreasure);
            stringBuffer.append(";\u8d26\u53f7\u6d88\u8d39=");
            stringBuffer.append(hero.user.consumedTreasure);
            stringBuffer.append(";\u89d2\u8272\u5145\u503c=");
            stringBuffer.append(hero.payedTreasure);
            stringBuffer.append(";\u89d2\u8272\u6536\u76ca=");
            stringBuffer.append(hero.earnedTreasure);
            stringBuffer.append(";\u89d2\u8272\u6d88\u8d39=");
            stringBuffer.append(hero.consumedTreasure);
        }
        if (h2.r().gmGrade > 0) {
            stringBuffer.append(";\u6b7b\u4ea1=");
            stringBuffer.append(hero.deathCount);
            stringBuffer.append(";\u6740\u602a=");
            stringBuffer.append(hero.monsterKills);
            stringBuffer.append(";\u6740\u4eba=");
            stringBuffer.append(hero.playerKills);
            stringBuffer.append(";PK=");
            stringBuffer.append(hero.pkValue);
            stringBuffer.append(";\u5728\u7ebf=");
            int n2 = hero.onlineTime;
            stringBuffer.append(n2 / 3600);
            stringBuffer.append("\u5c0f\u65f6");
            stringBuffer.append(";\u79fb\u52a8=");
            stringBuffer.append(hero.movable);
            stringBuffer.append(";\u6218\u6597=");
            stringBuffer.append(hero.fightable);
            stringBuffer.append(";\u804a\u5929=");
            stringBuffer.append(hero.chatable);
            stringBuffer.append(';');
        }
        stringBuffer.append("\u7b49\u7ea7=");
        stringBuffer.append(hero.level);
        stringBuffer.append(";\u804c\u4e1a=");
        stringBuffer.append(Player.RACE_NAMES[hero.race]);
        stringBuffer.append(";\u6027\u522b=");
        stringBuffer.append(Player.SEX_NAMES[hero.sex]);
        if (hero.joinedGuild != null) {
            stringBuffer.append(";\u516c\u4f1a=");
            stringBuffer.append(hero.joinedGuild.name);
            stringBuffer.append(";\u804c\u4f4d=");
            stringBuffer.append(Guild.POS_NAMES[hero.guildPosition]);
        }
        if (string != null) {
            stringBuffer.append(";\u573a\u666f=");
            stringBuffer.append(string);
        } else {
            stringBuffer.append(";\u4e0a\u7ebf\u540e\u573a\u666f=");
            u u2 = this.do(hero.sceneID);
            if (u2 != null) {
                stringBuffer.append(u2.int());
            } else {
                stringBuffer.append("\u672a\u77e5\u573a\u666f(" + hero.sceneID + ")");
            }
        }
        if (h2.r().gmGrade > 0) {
            if (hero.friendList.master != null) {
                stringBuffer.append(";\u5e08\u7236=");
                stringBuffer.append(hero.friendList.master.name);
            }
            stringBuffer.append(";\u5f92\u5f1f=");
            stringBuffer.append(hero.friendList.studentCount);
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    public void if(Hero hero) {
        int n2 = 0;
        while (n2 < this.byte.length) {
            this.byte[n2].removeHero(hero.id);
            ++n2;
        }
    }

    public void a(Goods goods) {
        if (goods.createdTime <= 0L) {
            goods.createdTime = ServerInfo.currentMilliSecond;
        }
        if (goods.goodsType == 5) {
            SpecialProperty specialProperty = (SpecialProperty)goods;
            if (specialProperty.spType == 19 && specialProperty.parameter1 < 1000) {
                u u2 = this.do(specialProperty.parameter1);
                int n2 = (int)(Math.random() * (double)u2.x());
                int n3 = (int)(Math.random() * (double)u2.M());
                int n4 = u2.for(n2, n3);
                n2 = n4 & 0xFFFF;
                n3 = n4 >> 16;
                specialProperty.parameter1 = specialProperty.parameter1 * 1000000 + n3 * 1000 + n2;
            }
        }
    }

    public boolean a(String string) {
        Hero hero = this.case.new(string);
        if (hero == null) {
            return false;
        }
        return hero.gmGrade > 0;
    }

    public void e() {
        int n2 = 0;
        while (n2 < this.byte.length) {
            this.byte[n2].clearData();
            ++n2;
        }
    }

    private void int() {
        System.out.println("init ranks...");
        int n2 = HeroRankData.getRankTypeAmount();
        this.byte = new HeroRankData[n2];
        int n3 = 0;
        while (n3 < n2) {
            byte[] byArray = daff.a.b.new("data/top/" + (n3 + 1) + ".txt");
            if (byArray == null) {
                this.byte[n3] = new HeroRankData();
                this.byte[n3].type = n3 + 1;
            } else {
                String string = new String(byArray);
                daff.a.i i2 = n.a().a(string);
                this.byte[n3] = (HeroRankData)app.island.a.a().a(i2);
            }
            ++n3;
        }
    }

    public HeroRankData int(int n2) {
        return this.byte[n2 - 1];
    }

    public void a(f f2) {
        this.else = f2;
    }

    public int byte() {
        return this.if.for();
    }

    public void if(h h2) {
        this.if.a((Object)h2.b(), (Object)h2);
        this.f.if(h2);
        Hero hero = h2.r();
        this.long.b(h2);
        if (hero.level < 3) {
            int n2 = this.if(1);
            if (n2 > 0) {
                u u2 = this.do(n2);
                u2.if(h2);
            }
        } else if (hero.sceneLifeTime > 0) {
            int n3 = this.if(hero.sceneID);
            if (n3 > 0) {
                u u3 = this.do(n3);
                u3.long(hero.sceneLifeTime);
                u3.if(h2);
            } else {
                this.a(h2, 3, 0, 0);
            }
        } else {
            u u4 = this.do(hero.sceneID);
            if (u4 == null) {
                h2.if(0, 0);
                u4 = (u)this.char.if(0);
            }
            u4.if(h2);
        }
        h2.E();
        this.a(h2, hero, h2.j());
        this.a(h2.r());
        if (hero.race == 0) {
            ++ServerInfo.elfCount;
        } else if (hero.race == 1) {
            ++ServerInfo.manCount;
        } else if (hero.race == 2) {
            ++ServerInfo.orcCount;
        }
        if (ServerInfo.maxOnlineCount < this.f.for()) {
            ServerInfo.maxOnlineCount = this.f.for();
            ServerInfo.onlinePeakTime = daff.a.b.a();
        }
        if (h2.for()) {
            ++ServerInfo.heroUsingAppletCount;
        }
        hero.dataChanged = true;
    }

    public u for(int n2) {
        int n3 = this.do.for();
        int n4 = 0;
        while (n4 < n3) {
            u u2 = (u)this.do.if(n4);
            if (u2.try() % 100000 == n2) {
                return u2;
            }
            ++n4;
        }
        return null;
    }

    public e new(int n2) {
        int n3 = 0;
        while (n3 < this.for) {
            if (this.void[n3].try() == n2) {
                return this.void[n3];
            }
            ++n3;
        }
        return null;
    }

    public void a(h h2, int n2, daff.a.e e2) {
        if (h2.j() == null) {
            return;
        }
        if (n2 >= 256 && n2 < 512) {
            u u2 = h2.j();
            u2.a(h2, n2, e2);
        } else if (n2 >= 512 && n2 < 612) {
            if (n2 == 566) {
                v v2 = this.a(2);
                int n3 = e2.i();
                h2.a(v2, n3);
                return;
            }
            h2.a(n2, e2);
        } else if (n2 >= 768 && n2 < 868) {
            this.c.a(n2, e2, h2);
        } else if (n2 >= 1024 && n2 < 1124) {
            q q2 = h2.k();
            if (q2 != null && h2.g()) {
                q2.a(n2, e2, h2);
            }
        } else if (n2 >= 1280 && n2 < 1380) {
            v v3 = h2.int();
            if (v3 != null) {
                v3.a(n2, e2, h2);
            }
        } else if (n2 >= 1536 && n2 < 1636) {
            b b2 = h2.x();
            if (b2 != null && h2.g()) {
                b2.a(h2, n2, e2);
            }
        } else if (n2 >= 1792 && n2 < 1892) {
            e e3 = h2.J();
            if (e3 != null) {
                e3.a(h2, n2, e2);
            }
        } else if (n2 >= 2048 && n2 < 2148) {
            j j2 = h2.n();
            if (j2 != null) {
                j2.a(h2, n2, e2);
            }
        } else if (n2 >= 2304 && n2 < 2404) {
            if (h2.g()) {
                this.long.a(h2, n2, e2);
            }
        } else if (n2 == 2561) {
            v v4;
            int n4 = e2.i();
            if (h2.g() && h2.int() == null && n4 < 100 && (v4 = this.a(n4)) != null) {
                v4.j(h2);
            }
        } else if (n2 > 3072 && n2 < 3172) {
            if (n2 == 3073) {
                int n5 = e2.i();
                int n6 = e2.i();
                v v5 = this.a(n5);
                v5.case(h2, n6);
            } else if (n2 == 3074) {
                if (h2.r().level < 30) {
                    h2.a(p.c("\u4f4e\u4e8e30\u7ea7\u4e0d\u5141\u8bb8\u6302\u673a"));
                } else if (h2.r().life <= 0) {
                    h2.a(p.c("\u82f1\u96c4\u5df2\u6b7b\u4ea1\uff01\u6302\u673a\u5c06\u88ab\u5173\u95ed"));
                } else {
                    h2.if(true);
                }
            } else if (n2 == 3075) {
                h2.if(false);
            }
        } else if (n2 < 3331 && n2 > 3327) {
            this.b.a(h2, n2, e2);
        } else if (n2 == 2562) {
            String string = e2.h();
            boolean bl = e2.c();
            if (h2.i()) {
                h2.try("\u6b7b\u4ea1\u72b6\u6001\u4e0d\u5141\u8bb8\u8fdb\u884c\u8be5\u52a8\u4f5c");
            } else {
                i i2 = this.do(string);
                if (i2 != null && i2.a(h2)) {
                    i2.a(bl);
                }
            }
        } else if (n2 == 2563) {
            int n7 = e2.for();
            if (n7 > 0 && n7 <= this.byte.length) {
                HeroRankData heroRankData = this.byte[n7 - 1];
                h2.a(p.a(heroRankData));
            }
        } else if (n2 == 2564) {
            String string = e2.h();
            h h3 = this.if(string);
            if (h3 == null) {
                if (h2.r().gmGrade > 1) {
                    Hero hero = this.case.new(string);
                    if (hero != null) {
                        String string2 = this.a(h2, hero, (String)null);
                        h2.a(p.byte(string2));
                    } else {
                        h2.try("\u5bf9\u65b9\u672a\u66fe\u4e0a\u7ebf\u8fc7");
                    }
                } else {
                    h2.try("\u5bf9\u65b9\u4e0d\u5728\u7ebf");
                }
            } else if (h3 != h2) {
                Hero hero = h3.r();
                String string3 = this.a(h2, hero, h3.j().int());
                h2.a(p.byte(string3));
            }
        } else if (n2 == 2565) {
            Hero hero = h2.r();
            if (hero.joinedGuild == null) {
                String string = e2.h();
                int n8 = e2.for();
                String string4 = e2.h();
                if (string.length() > 7) {
                    h2.try("\u540d\u5b57\u592a\u957f");
                } else if (hero.personalDepot.money < ServerInfo.guildCreationMoneyCost) {
                    h2.try("\u91d1\u94b1\u4e0d\u591f");
                } else if (ServerInfo.guildCreationGoodsCost > 0 && hero.personalDepot.getGoodsPosByID(ServerInfo.guildCreationGoodsCost) < 0) {
                    Goods goods = w.case().getGoods(ServerInfo.guildCreationGoodsCost);
                    if (goods != null) {
                        h2.try("\u7f3a\u5c11" + goods.name);
                    }
                } else if (hero.level < ServerInfo.guildCreationHeroLevel) {
                    h2.try("\u7b49\u7ea7\u4e0d\u591f");
                } else {
                    int n9 = 0;
                    int n10 = 0;
                    while (n10 < this.void.length) {
                        e e4 = this.void[n10];
                        if (e4 != null && e4.try() > n9) {
                            n9 = e4.try();
                        }
                        ++n10;
                    }
                    hero.joinedGuild = new Guild();
                    hero.joinedGuild.icon = n8;
                    hero.joinedGuild.introduction = string4;
                    this.case.createGuild(n9 + 1, string, h2);
                }
            } else {
                h2.try("\u4f60\u5df2\u7ecf\u6709\u516c\u4f1a\u4e86");
            }
        } else if (n2 == 2566) {
            int n11 = e2.for();
            this.a(h2, n11);
        } else if (n2 == 2567) {
            int n12 = e2.i();
            String string = e2.h();
            e e5 = this.new(n12);
            if (e5 != null) {
                e5.a(h2, string);
            }
        } else if (n2 == 2568) {
            String string = e2.h();
            this.do(h2, string);
        } else if (n2 == 2569) {
            String string = e2.h();
            this.a(h2, string);
        } else if (n2 == 2570) {
            String string = e2.h();
            h h4 = this.if(string);
            if (h4 != null) {
                v v6 = h4.D();
                if (v6 != null) {
                    v6.j(h2);
                } else {
                    h2.try("\u5bf9\u65b9\u6ca1\u6709\u6253\u5f00\u4e2a\u4eba\u5546\u5e97");
                }
            } else {
                h2.try("\u5bf9\u65b9\u4e0d\u5728\u7ebf");
            }
        } else if (n2 == 2571) {
            int n13 = e2.i();
            e e6 = this.new(n13);
            if (e6 != null) {
                Guild guild = e6.e();
                StringBuffer stringBuffer = new StringBuffer(256);
                stringBuffer.append("\u516c\u4f1a\u4fe1\u606f[");
                stringBuffer.append("\u540d\u5b57=");
                stringBuffer.append(guild.name);
                stringBuffer.append(";\u7b49\u7ea7=");
                stringBuffer.append(guild.level);
                stringBuffer.append(";\u4f1a\u957f=");
                stringBuffer.append(guild.leader);
                stringBuffer.append(";\u6210\u5458\u6570=");
                stringBuffer.append(guild.memberList.for());
                stringBuffer.append(";\u8d44\u4ea7=");
                stringBuffer.append(guild.money);
                stringBuffer.append(";\u58f0\u671b=");
                stringBuffer.append(guild.reputation);
                stringBuffer.append(";\u4ed3\u5e93\u7269\u54c1\u6570=");
                stringBuffer.append(guild.getGoodsCount());
                stringBuffer.append(";\u9a7b\u5730=");
                if (guild.placedSign != null) {
                    stringBuffer.append(guild.placedSign.sceneName);
                    stringBuffer.append('(');
                    stringBuffer.append(guild.placedSign.x);
                    stringBuffer.append(',');
                    stringBuffer.append(guild.placedSign.y);
                    stringBuffer.append(')');
                } else {
                    stringBuffer.append('\u65e0');
                }
                stringBuffer.append(']');
                h2.for(stringBuffer.toString());
            }
        } else if (n2 == 2572) {
            String string = e2.h();
            this.if(h2, string);
        } else if (n2 == 2574) {
            Hero hero = h2.r();
            if (h2.j().K() == 3) {
                h2.try("\u4f60\u5728\u76d1\u72f1\u4e2d\uff0c\u4e0d\u80fd\u4f20\u9001");
            } else if (hero.friendList.master != null && hero.friendList.master.closeness > 5 && h2.l() != null) {
                boolean bl = false;
                h h5 = (h)h2.l().attachment;
                if (h2.j() == h5.j()) {
                    int n14 = h5.m();
                    int n15 = h5.o();
                    int n16 = h5.j().for(n14, n15);
                    if (n16 > 0) {
                        h5.j().if(h2, n14, n15);
                        bl = true;
                    }
                } else if (h5.j().K() == 1) {
                    h2.try("\u5bf9\u65b9\u5728\u7ade\u6280\u573a\uff0c\u4e0d\u80fd\u4f20\u9001");
                } else if (this.a(h2, h5.j().try(), h5.m(), h5.o())) {
                    bl = true;
                }
                if (bl) {
                    hero.friendList.master.closeness -= 5;
                    h5.r().friendList.addStudentCloseness(hero.name, -5);
                    h2.a(p.int(hero.friendList.master.closeness, h5.r().level, h5.r().turns));
                    h5.a(p.a(hero.name, hero.friendList.master.closeness, hero.level, hero.turns));
                }
            }
        } else if (n2 == 2573) {
            String string = e2.h();
            Hero hero = h2.r();
            h h6 = this.if(string);
            if (h2.j().K() == 3) {
                h2.try("\u4f60\u5728\u76d1\u72f1\u4e2d\uff0c\u4e0d\u80fd\u4f20\u9001");
            } else if (h6 != null && h6.r().friendList.isMaster(hero.name) && h6.r().friendList.master.closeness > 5) {
                boolean bl = false;
                if (h2.j() == h6.j()) {
                    int n17 = h6.m();
                    int n18 = h6.o();
                    int n19 = h6.j().for(n17, n18);
                    if (n19 > 0) {
                        h6.j().if(h2, n17, n18);
                        bl = true;
                    }
                } else if (h6.j().K() == 1) {
                    h2.try("\u5bf9\u65b9\u5728\u7ade\u6280\u573a\uff0c\u4e0d\u80fd\u4f20\u9001");
                } else if (this.a(h2, h6.j().try(), h6.m(), h6.o())) {
                    bl = true;
                }
                if (bl) {
                    h6.r().friendList.master.closeness -= 5;
                    hero.friendList.addStudentCloseness(hero.name, -5);
                    h6.a(p.int(h6.r().friendList.master.closeness, hero.level, hero.turns));
                    h2.a(p.a(string, h6.r().friendList.master.closeness, h6.r().level, h6.r().turns));
                }
            }
        }
    }

    private void char() {
        int n2 = this.a.for();
        int n3 = 0;
        while (n3 < n2) {
            this.a.if(n3);
            ++n3;
        }
    }

    public c long() {
        return this.case;
    }

    public void a(c c2) {
        this.case = c2;
    }

    private void do(h h2) {
        Hero hero = h2.r();
        int n2 = this.f.for();
        int n3 = 0;
        while (n3 < n2) {
            h h3 = (h)this.f.if(n3);
            if (h3.r().friendList.hasFriend(hero.name)) {
                h3.do("\u4f60\u7684\u597d\u53cb\u3010" + hero.name + "\u3011\u4e0b\u7ebf\u4e86");
            } else if (h3.r().friendList.hasEnemy(hero.name)) {
                h3.do("\u4f60\u7684\u4ec7\u4eba\u3010" + hero.name + "\u3011\u4e0b\u7ebf\u4e86");
            }
            if (h3.r().friendList.hasStudent(hero.name)) {
                h3.a(p.if(hero.name));
            }
            if (h3.r().friendList.isMaster(hero.name)) {
                h3.a((Hero)null);
                h3.a(p.byte());
            }
            ++n3;
        }
        if (hero.user.adOwner != null && hero.user.adOwner.length() > 1) {
            User user = this.case.a(hero.user.adOwner);
            int n4 = 0;
            while (user != null && n4 < 3) {
                if (user.heroes[n4] != null && user.heroes[n4].online) {
                    h h4 = (h)user.heroes[n4].attachment;
                    h4.do("\u7531\u4f60\u63a8\u8350\u5728\u672c\u6e38\u620f\u6ce8\u518c\u7684\u73a9\u5bb6\u3010" + hero.name + "\u3011\u4e0b\u7ebf\u4e86");
                    break;
                }
                ++n4;
            }
        }
    }

    private static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError(classNotFoundException.getMessage());
        }
    }

    private void else() {
        System.out.println("load scenes...");
        daff.a.h h2 = new daff.a.h(100);
        w.a("config/scenes.txt", class$app$island$gs$data$SceneConfigData != null ? class$app$island$gs$data$SceneConfigData : (class$app$island$gs$data$SceneConfigData = x.class$("app.island.gs.data.SceneConfigData")), h2);
        int n2 = h2.for();
        int n3 = 0;
        while (n3 < n2) {
            SceneConfigData sceneConfigData = (SceneConfigData)h2.if(n3);
            System.out.println("loading scene:" + sceneConfigData.name);
            u u2 = new u();
            u2.a(this);
            u2.a(sceneConfigData);
            if (sceneConfigData.sceneType != 2 && sceneConfigData.sceneType != 4) {
                this.char.if(u2);
            } else {
                this.do.if(u2);
            }
            ++n3;
        }
    }

    private void do(h h2, String string) {
        if (h2.i()) {
            h2.try("\u4f60\u5df2\u7ecf\u6b7b\u4ea1\uff0c\u4e0d\u80fd\u8fdb\u884c\u8be5\u9879\u64cd\u4f5c");
            return;
        }
        b b2 = h2.x();
        if (b2 != null && b2.else() != h2) {
            h2.try("\u4f60\u4e0d\u662f\u961f\u957f\uff0c\u4e0d\u80fd\u9080\u8bf7\u522b\u4eba");
            return;
        }
        if (b2 != null && b2.new() >= b2.for()) {
            h2.try("\u4f60\u7684\u961f\u4f0d\u4eba\u6570\u5df2\u5230\u4e0a\u9650");
            return;
        }
        h h3 = this.if(string);
        if (h3 == null) {
            h2.try("\u627e\u4e0d\u5230\u76ee\u6807\u73a9\u5bb6");
            return;
        }
        if (h3 == h2) {
            h2.try("\u4e0d\u80fd\u9080\u8bf7\u81ea\u5df1");
            return;
        }
        if (h3.i()) {
            h2.try("\u4f60\u4e0d\u9080\u8bf7\u6b7b\u4eba");
            return;
        }
        b b3 = h3.x();
        if (b3 != null) {
            h2.try("\u5bf9\u65b9\u5df2\u7ecf\u6709\u961f\u4f0d\u4e86");
            return;
        }
        string = h2.b() + "-teamInvite-" + h3.b();
        i i2 = this.do(string);
        if (i2 != null) {
            h2.try("\u4f60\u5df2\u7ecf\u9080\u8bf7\u8fc7\u5bf9\u65b9\u4e86");
            return;
        }
        app.island.gs.c.d d2 = new app.island.gs.c.d(h2, h3, string);
        this.a(d2);
        String string2 = h2.b() + "\u9080\u8bf7\u4f60\u52a0\u5165\u961f\u4f0d\uff0c\u4f60\u540c\u610f\u5417\uff1f";
        app.b.b b4 = p.a(h2.b(), string, string2);
        h3.a(b4);
        h2.do("\u5df2\u5c06\u9080\u8bf7\u53d1\u9001\u7ed9\u300e" + h3.b() + "\u300f");
    }

    public y do() {
        return this.try;
    }

    public u do(int n2) {
        int n3 = this.char.for();
        int n4 = 0;
        while (n4 < n3) {
            u u2 = (u)this.char.if(n4);
            if (u2.try() == n2) {
                return u2;
            }
            ++n4;
        }
        return null;
    }

    public int void() {
        return this.for;
    }

    public void i() {
        this.c = new t(this);
        this.long = new d(this);
        w.case().new();
        this.case();
        this.else();
        this.int();
        this.if();
        this.try = new y(this);
        this.else = new f(this);
        this.b = new s();
    }

    public void a(j j2) {
        this.new.if(j2);
    }

    public h if(String string) {
        return (h)this.if.for(string);
    }

    private void a(h h2, Hero hero, u u2) {
        e e2;
        Object object;
        int n2 = this.f.for();
        int n3 = 0;
        while (n3 < n2) {
            h h3 = (h)this.f.if(n3);
            if (h3.r().friendList.hasFriend(hero.name)) {
                object = p.a(hero.name, hero.level, hero.race, hero.guildName, u2.int());
                h3.a((app.b.b)object);
                h3.do("\u4f60\u7684\u597d\u53cb\u3010" + hero.name + "\u3011\u4e0a\u7ebf\u4e86");
            } else if (h3.r().friendList.hasEnemy(hero.name)) {
                object = p.a(hero.name, hero.level, hero.race, hero.guildName, u2.int());
                h3.a((app.b.b)object);
                h3.do("\u4f60\u7684\u4ec7\u4eba\u3010" + hero.name + "\u3011\u4e0a\u7ebf\u4e86");
            }
            if (h3.r().friendList.hasStudent(hero.name)) {
                if (hero.friendList.isMaster(h3.b())) {
                    h2.a(h3.r());
                    h3.a(p.a(hero.name, hero.level, hero.turns));
                } else {
                    h3.r().friendList.removeStudent(hero.name);
                }
            }
            if (h3.r().friendList.isMaster(hero.name)) {
                if (hero.friendList.hasStudent(h3.b())) {
                    h3.a(h2.r());
                    h3.a(p.void(h3.r().level, h3.r().turns));
                } else {
                    h3.r().friendList.master = null;
                }
            }
            if (hero.friendList.hasFriend(h3.b())) {
                if (h3.r().gmGrade > 0 && hero.gmGrade == 0) {
                    hero.friendList.removeFriend(h3.b());
                } else {
                    object = p.a(h3.b(), h3.r().level, h3.r().race, h3.r().guildName, h3.j().int());
                    h2.a((app.b.b)object);
                }
            } else if (hero.friendList.hasEnemy(h3.b())) {
                if (h3.r().gmGrade > 0 && hero.gmGrade == 0) {
                    hero.friendList.removeEnemy(h3.b());
                } else {
                    object = p.a(h3.b(), h3.r().level, h3.r().race, h3.r().guildName, h3.j().int());
                    h2.a((app.b.b)object);
                }
            }
            ++n3;
        }
        if (hero.joinedGuild != null && (e2 = (e)hero.joinedGuild.attachment) != null) {
            e2.if(h2);
        }
        if (hero.user.adOwner != null && hero.user.adOwner.length() > 1) {
            User user = this.case.a(hero.user.adOwner);
            int n4 = 0;
            while (user != null && n4 < 3) {
                if (user.heroes[n4] != null && user.heroes[n4].online) {
                    object = (h)user.heroes[n4].attachment;
                    ((h)object).do("\u7531\u4f60\u63a8\u8350\u5728\u672c\u6e38\u620f\u6ce8\u518c\u7684\u73a9\u5bb6\u3010" + hero.name + "\u3011\u4e0a\u7ebf\u4e86");
                    break;
                }
                ++n4;
            }
        }
        if (hero.onlineTime < 300) {
            this.a(p.d("\u6b22\u8fce\u65b0\u73a9\u5bb6\u3010" + hero.name + "\u3011\u6765\u5230\u8fd9\u4e2a\u4e16\u754c\uff01"));
        }
    }

    public void a(Hero hero, int n2) {
        if (hero.gmGrade == 0 && hero.rank > 0) {
            this.byte[n2 - 1].rankHero(hero);
        }
    }

    private void a(h h2, String string) {
        if (h2.i()) {
            h2.try("\u4f60\u5df2\u7ecf\u6b7b\u4e86\uff0c\u4e0d\u80fd\u8fdb\u884c\u8be5\u9879\u64cd\u4f5c");
            return;
        }
        Guild guild = h2.r().joinedGuild;
        Hero hero = h2.r();
        if (guild == null) {
            h2.try("\u975e\u6cd5\u64cd\u4f5c\uff0c\u4f60\u6ca1\u6709\u516c\u4f1a");
            return;
        }
        if (hero.guildPosition < 1 || hero.guildPosition > 2) {
            h2.try("\u975e\u6cd5\u64cd\u4f5c\uff0c\u6ca1\u6709\u6743\u9650");
            return;
        }
        h h3 = this.if(string);
        if (h3.i()) {
            h2.try("\u4f60\u4e0d\u9080\u8bf7\u6b7b\u4eba");
            return;
        }
        if (h3 == h2) {
            h2.try("\u4e0d\u80fd\u9080\u8bf7\u81ea\u5df1");
            return;
        }
        if (h3 == null) {
            h2.try("\u76ee\u6807\u73a9\u5bb6\u4e0d\u5728\u7ebf\u4e0a");
            return;
        }
        if (h3.r().joinedGuild != null) {
            h2.try("\u5bf9\u65b9\u5df2\u7ecf\u6709\u516c\u4f1a\u4e86");
            return;
        }
        string = h2.b() + "-guildInvite-" + h3.b();
        i i2 = this.do(string);
        if (i2 != null) {
            h2.try("\u4f60\u5df2\u7ecf\u9080\u8bf7\u8fc7\u5bf9\u65b9\u4e86");
            return;
        }
        app.island.gs.c.f f2 = new app.island.gs.c.f(h2, h3, string);
        this.a(f2);
        String string2 = h2.b() + "\u9080\u8bf7\u4f60\u52a0\u5165\u516c\u4f1a\uff0c\u4f60\u540c\u610f\u5417\uff1f";
        app.b.b b2 = p.a(h2.b(), string, string2);
        h3.a(b2);
        h2.do("\u5df2\u5c06\u9080\u8bf7\u53d1\u9001\u7ed9\u300e" + h3.b() + "\u300f");
    }
}

