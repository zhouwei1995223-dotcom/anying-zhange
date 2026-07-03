/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs;

import app.island.GameObject;
import app.island.data.Decoration;
import app.island.data.Equipment;
import app.island.data.Fashion;
import app.island.data.FightState;
import app.island.data.Goods;
import app.island.data.Material;
import app.island.data.Medicine;
import app.island.data.SpecialProperty;
import app.island.data.Spell;
import app.island.data.Task;
import app.island.data.Weapon;
import app.island.entity.Guild;
import app.island.entity.Hero;
import app.island.entity.SceneObject;
import app.island.entity.User;
import app.island.gs.GameServer;
import app.island.gs.ServerInfo;
import app.island.gs.a;
import app.island.gs.b;
import app.island.gs.c;
import app.island.gs.data.BetData;
import app.island.gs.data.SceneConfigData;
import app.island.gs.e;
import app.island.gs.g;
import app.island.gs.j;
import app.island.gs.l;
import app.island.gs.n;
import app.island.gs.p;
import app.island.gs.q;
import app.island.gs.u;
import app.island.gs.v;
import app.island.gs.w;
import daff.net.i;
import java.lang.reflect.Field;
import java.util.Date;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class h
implements c.a {
    public static final int x = 1;
    public static final int byte = 2;
    public static final int int = 3;
    public static final int L = 4;
    private Hero u;
    private Hero e;
    private boolean w;
    private Guild i;
    private i B;
    private boolean k;
    private long h;
    private u long;
    private int[] y = new int[4];
    private int for;
    private int q;
    private long if;
    private long M;
    private long E;
    private long p;
    private long case;
    private long K;
    private long a;
    private long m;
    private q D;
    private q.d t;
    private v f;
    private b new;
    private j try;
    private Goods[] l = new Goods[10];
    private Medicine H;
    private Medicine J;
    private FightState[] A;
    private int I;
    private int c;
    private long G;
    private long s;
    private String F = "";
    private boolean N;
    private Guild C;
    private int goto;
    private int o;
    private int b;
    private v char;
    private FightState do;
    private long d;
    private boolean g;
    private boolean void = false;
    private g j;
    public Goods[] else = new Goods[10];
    public int r = -1;
    public int[] z = new int[10];
    private BetData v;
    private long n = 0L;

    public void K() {
        this.char();
        this.try();
        if (this.h > 0L) {
            long l2 = (ServerInfo.currentMilliSecond - this.h) / 1000L;
            this.u.onlineTime = (int)((long)this.u.onlineTime + l2);
        }
        this.u.shopName = "";
        this.u.attachment = null;
    }

    private void if(int n2) {
        if (n2 >= this.u.personalDepot.goodsList.length) {
            return;
        }
        if (this.u.personalDepot.goodsList[n2] == null && !(this.u.personalDepot.goodsList[n2] instanceof Material)) {
            return;
        }
        int n3 = 0;
        while (n3 < this.else.length) {
            if (this.else[n3] == null) {
                this.else[n3] = this.u.personalDepot.goodsList[n2];
                this.z[n3] = n2;
                this.u.personalDepot.goodsList[n2] = null;
                this.a(app.island.gs.p.b(n2, n3));
                return;
            }
            ++n3;
        }
    }

    public void for(int n2) {
        int n3 = this.u.life;
        this.u.life += n2;
        if (this.u.life < 0) {
            this.u.life = 0;
        } else if (this.u.life > this.u.maxLife) {
            this.u.life = this.u.maxLife;
        }
        n2 = this.u.life - n3;
        if (n2 != 0 && this.long != null) {
            if (n2 > 0) {
                this.long.a(app.island.gs.p.do(this.u.id, n2), this.u.x, this.u.y, null);
            } else if (n2 < 0) {
                this.v();
                this.long.a(app.island.gs.p.a(this.u, -n2, 0, 500), this.u.x, this.u.y, null);
            }
            if (this.new != null) {
                this.new.else(this);
            }
        }
    }

    public void w() {
        int n2 = 0;
        while (n2 < this.A.length) {
            if (this.A[n2] != null) {
                this.A[n2].removeFromSprite(this.u);
                if (this.A[n2].hpPerTime == 0) {
                    this.a(app.island.gs.p.if(this.A[n2]));
                }
                if (this.A[n2].changedMaxLife > 0 && this.long != null) {
                    this.long.a(app.island.gs.p.m(this.u.id, this.u.maxLife), this.u.x, this.u.y, null);
                }
                this.A[n2] = null;
            }
            ++n2;
        }
        this.I();
    }

    public int H() {
        return this.u.id;
    }

    public void a(Medicine medicine) {
        if (medicine.lifeCured > 0) {
            this.H = medicine;
            this.H.lastUsedTime = 0L;
        }
        if (medicine.manaCured > 0) {
            this.J = medicine;
            this.J.lastUsedTime = 0L;
        }
    }

    public void try(String string) {
        this.a(app.island.gs.p.try(string));
    }

    public q k() {
        return this.D;
    }

    public void a(q q2) {
        this.D = q2;
    }

    public v D() {
        return this.char;
    }

    public void a(Spell spell) {
        int n2 = 0;
        if (spell.nextLevelSpellID > 0 && spell.experience < spell.maxExperience) {
            n2 = ServerInfo.spellExpTimes;
        }
        spell.experience += n2;
        this.u.mana -= spell.manaCost;
        this.a(app.island.gs.p.a(spell.id, n2, spell.manaCost));
        this.M = ServerInfo.currentMilliSecond + (long)this.u.getAttackTime() - 50L;
        this.if = ServerInfo.currentMilliSecond + (long)this.u.getAttackTime() + (long)this.u.getAttackDelay() - 50L;
        this.E = ServerInfo.currentMilliSecond + (long)this.u.getAttackTime() + (long)spell.globalCoolTime;
        this.case = ServerInfo.currentMilliSecond;
        spell.startCoolTime = ServerInfo.currentMilliSecond;
        spell.coolLastTime = spell.selfCoolTime + this.u.getAttackTime();
        if (this.o != 0) {
            int n3 = this.u.personalDepot.getGoodsPosByID(this.o);
            if (n3 < 0) {
                this.o = 0;
            } else {
                Goods goods = this.u.personalDepot.goodsList[n3];
                if (goods.goodsType == 5 && ((SpecialProperty)goods).spType == 32) {
                    SpecialProperty specialProperty = (SpecialProperty)goods;
                    int n4 = this.u.mana * 100 / this.u.maxMana;
                    if (n4 < specialProperty.parameter2) {
                        int n5 = Math.min(this.u.maxMana - this.u.mana, specialProperty.parameter1);
                        this.do(n5);
                        specialProperty.parameter1 -= n5;
                        if (specialProperty.parameter1 <= 0) {
                            this.long(n3);
                        } else {
                            this.a(app.island.gs.p.do(specialProperty.id, specialProperty.getExtraInfo()));
                        }
                    }
                }
            }
        }
    }

    public v int() {
        return this.f;
    }

    public void a(v v2) {
        this.f = v2;
    }

    public void a(i i2) {
        this.B = i2;
    }

    public i c() {
        return this.B;
    }

    public void t() {
        if (this.B != null && this.B.c()) {
            this.B.new();
        }
    }

    public void a(app.b.b b2) {
        if (this.u.online) {
            this.B.do(b2);
            ++ServerInfo.sendedMessageCount;
        }
    }

    public void a(Task task) {
        this.u.taskList.addTask(task);
        this.a(app.island.gs.p.a(task));
    }

    private void if(int n2, int n3, int n4) {
        int n5 = n2 + n3 + n4;
        if (n5 > this.u.unassignedPoints) {
            this.new("\u5f53\u524d\u6ca1\u6709\u8db3\u591f\u7684\u5c5e\u6027\u70b9\u6570\u7528\u4e8e\u5206\u914d\uff01");
            return;
        }
        this.u.strength += n2;
        this.u.dexterity += n3;
        this.u.wisdom += n4;
        this.u.unassignedPoints -= n5;
        this.u.calculateProperties();
        this.for("\u5206\u914d\u5c5e\u6027\u70b9\u6570\u6210\u529f\uff01");
        app.b.b b2 = app.island.gs.p.new(this.u);
        this.long.a(b2, this.u.x, this.u.y, this);
    }

    public void a(String string) {
        this.u.friendList.addFriend(string);
    }

    public int z() {
        if (this.u.pkValue > 1) {
            return 2;
        }
        if (this.c <= 0) {
            return 0;
        }
        return 1;
    }

    public void if(boolean bl) {
        this.g = bl;
        if (bl) {
            this.do("\u5f00\u59cb\u6302\u673a");
        } else {
            this.do("\u7ed3\u675f\u6302\u673a");
        }
    }

    public boolean h() {
        return this.u.fightStops <= 0 && this.u.fightable && this.char == null;
    }

    public boolean g() {
        return this.k;
    }

    private void B() {
        int n2 = this.u.personalDepot.getSuitSkillID();
        if (n2 != this.b) {
            int n3;
            Spell spell;
            if (this.b != 0 && (spell = this.u.spellList.getSpellByGroup(this.b)) != null) {
                n3 = spell.experience;
                Spell spell2 = Spell.getGlobalSpell(spell.id);
                spell.copyFrom(spell2);
                spell.experience = n3;
                this.a(app.island.gs.p.a(spell.id, spell2, n3));
            }
            this.b = n2;
            if (n2 != 0) {
                spell = this.u.spellList.getSpellByGroup(n2);
                if (spell != null && spell.id >= n2) {
                    n3 = spell.id;
                    int n4 = spell.experience;
                    Spell spell3 = Spell.getGlobalSpell(spell.id + 1);
                    spell.copyFrom(spell3);
                    spell.id = n3;
                    spell.experience = n4;
                    this.a(app.island.gs.p.a(spell.id, spell3, n4));
                    this.b = n2;
                } else {
                    this.b = 0;
                }
            }
        }
    }

    private void G() {
        if (!this.h()) {
            return;
        }
        Spell spell = this.u.spellList.getSpellByGroup(this.y[1]);
        if (spell == null) {
            this.if("\u6ca1\u6709\u53ef\u65bd\u653e\u7684\u6280\u80fd");
        } else if (spell.manaCost > this.u.mana) {
            this.if("\u9b54\u529b\u503c\u4e0d\u8db3");
        } else if (ServerInfo.currentMilliSecond - spell.startCoolTime < (long)spell.coolLastTime) {
            this.if("\u6280\u80fd\u5c1a\u672a\u51b7\u5374");
        } else if (this.y[0] == 0) {
            if (this.long.a(this, spell, this.y[2], this.y[3])) {
                this.a(spell);
            }
        } else if (this.y[0] == 1 && spell.lockAbility > 0) {
            if (this.long.a(this, spell, this.y[2])) {
                this.a(spell);
            }
        } else if (this.y[0] == 2 && spell.lockAbility > 0 && this.long.if(this, spell, this.y[2])) {
            this.a(spell);
        }
    }

    public void f(int n2) {
        if (this.else() && this.u.life > 0) {
            this.for = 1;
            this.y[0] = n2;
        } else {
            this.a(app.island.gs.p.a(false, this.u));
        }
    }

    public void for(String string) {
        this.a(app.island.gs.p.byte(string));
    }

    public void int(int n2) {
        if (n2 <= 0 || this.u.level >= this.u.getMaxLevel() || this.u.life <= 0) {
            return;
        }
        int n3 = this.u.level;
        this.u.addExp(n2);
        this.a(app.island.gs.p.if(n2));
        if (this.u.level > n3 && this.long != null) {
            int n4;
            Object object;
            this.long.do().long().saveUserLog(this.u.user.name, this.u.name, "levelUp", "level=" + this.u.level + ";exp=" + n2);
            this.long.a(app.island.gs.p.goto(this.u), this.u.x, this.u.y, this);
            if (this.new != null) {
                this.new.byte(this);
            }
            if (this.u.joinedGuild != null) {
                this.J().d(this);
            }
            this.long.do().a(this.u, 2);
            this.long.do().a(this.u, 7 + this.u.race);
            if (this.u.level < 20) {
                this.long.if(app.island.gs.p.char(this.u.id, 4, 4));
            }
            if (this.e != null && this.e.attachment != null) {
                object = (h)this.e.attachment;
                if (this.u.level > 60) {
                    n4 = this.u.friendList.master.closeness * 5 / 10000;
                    ((h)object).try(n4);
                }
                ((h)object).do("\u4f60\u7684\u5f92\u5f1f\u3010" + this.u.name + "\u3011\u7b49\u7ea7\u63d0\u5347\u5230" + this.u.level);
                ((h)object).a(app.island.gs.p.a(this.u.name, this.u.friendList.master.closeness, this.u.level, this.u.turns));
            }
            if (this.u.user.adOwner != null && this.u.user.adOwner.length() > 1 && (object = this.long.do().long().a(this.u.user.adOwner)) != null && ((User)object).online) {
                n4 = 0;
                do {
                    if (((User)object).heroes[n4] == null || !((User)object).heroes[n4].online) continue;
                    h h2 = (h)((User)object).heroes[n4].attachment;
                    h2.do("\u7531\u4f60\u63a8\u8350\u5728\u672c\u6e38\u620f\u6ce8\u518c\u7684\u73a9\u5bb6\u3010" + this.u.name + "\u3011\u7b49\u7ea7\u63d0\u5347\u5230" + this.u.level);
                    int n5 = 20 + (this.u.level - 60) / 10;
                    h2.try(n5);
                    break;
                } while (++n4 < 3);
            }
        }
    }

    public void c(int n2) {
        this.goto = n2;
    }

    public void a(Weapon weapon, Weapon weapon2) {
        this.long.a(app.island.gs.p.do(this.u.id, this.u.halo, this.u.maxLife), this.u.x, this.u.y, this);
        this.B();
    }

    private void do(int n2, int n3) {
        if (n2 < 0 || n2 >= this.u.personalDepot.goodsList.length) {
            return;
        }
        if (n3 < 0 || n3 >= this.u.personalDepot.goodsList.length) {
            return;
        }
        Goods goods = this.u.personalDepot.goodsList[n2];
        this.u.personalDepot.goodsList[n2] = this.u.personalDepot.goodsList[n3];
        this.u.personalDepot.goodsList[n3] = goods;
        this.a(app.island.gs.p.goto(n2, n3));
    }

    public String toString() {
        return "HeroController[id=" + this.u.id + ";name=" + this.u.name + ";pos=" + this.u.x + "," + this.u.y + ";visible=" + this.k + ";scene=" + this.long + "]";
    }

    public boolean goto() {
        return this.u.online;
    }

    public j n() {
        return this.try;
    }

    public void a(j j2) {
        this.try = j2;
    }

    public void I() {
        if (this.do != null) {
            this.do.removeFromSprite(this.u);
            if (this.do.hpPerTime == 0) {
                this.a(app.island.gs.p.if(this.do));
            }
            if (this.do.changedMaxLife > 0 && this.long != null) {
                this.long.a(app.island.gs.p.m(this.u.id, this.u.maxLife), this.u.x, this.u.y, null);
            }
        }
        this.do = null;
    }

    public void case() {
        this.J = null;
        this.H = null;
    }

    public void new(int n2, int n3) {
        if (this.h() && this.u.life > 0) {
            this.for = 4;
            this.y[0] = 2;
            this.y[1] = n2;
            this.y[2] = n3;
        }
    }

    public void if(n n2) {
        this.w();
        this.case();
        this.long();
        ++this.u.deathCount;
        if (this.new != null) {
            this.new.else(this);
        }
        this.long.a(this, n2);
        this.long.l(this);
        this.a(app.island.gs.p.else(this.u.id));
        this.F();
    }

    public void if(h h2) {
        this.w();
        this.case();
        this.long();
        ++this.u.deathCount;
        if (this.new != null) {
            this.new.else(this);
        }
        this.long.for(this, h2);
        this.long.l(this);
        this.a(app.island.gs.p.else(this.u.id));
        this.F();
        if (this.long.K() != 1 && this.long.K() != 5 && this.u.joinedGuild != null && this.u.joinedGuild.reputation > 0) {
            this.u.joinedGuild.reputation -= 2;
            this.J().a(app.island.gs.p.new(this.u.joinedGuild.reputation));
            app.b.b b2 = app.island.gs.p.void("\u516c\u4f1a\u6210\u5458[" + this.u.name + "]\u5728[" + this.j().int() + "]\u88ab\u73a9\u5bb6[" + h2.b() + "]\u6740\u6b7b\u4e86\uff01");
            this.J().a(b2);
        }
    }

    public void do(h h2) {
        if (this.long.K() != 1 && this.long.K() != 5) {
            ++this.u.playerKills;
            if (this.u.joinedGuild != null && h2.J() != null) {
                ++this.u.joinedGuild.reputation;
                this.J().a(app.island.gs.p.new(this.u.joinedGuild.reputation));
            }
            if (h2.z() == 0 && this.I != 1) {
                this.char(this.u.pkValue + 1);
            }
        }
    }

    public void a(int n2, daff.a.e e2) {
        block0 : switch (n2) {
            default: {
                break;
            }
            case 582: {
                if (this.void) {
                    this.new("\u670d\u52a1\u5668\u6b63\u5728\u5904\u7406\u6d88\u606f,\u8bf7\u7a0d\u5019!");
                    break;
                }
                this.void = true;
                String string = e2.byte();
                app.island.gs.c.e e3 = new app.island.gs.c.e(string, this);
                GameServer.try().a(e3.if);
                this.void = false;
                break;
            }
            case 579: {
                int n3 = e2.case();
                String string = this.long.O().a(this, this.v, n3);
                if (string.length() <= 0) break;
                this.for(string);
                break;
            }
            case 578: {
                boolean bl = app.island.gs.l.do(this.u.lastGetGiftTime);
                long l2 = 0L;
                long l3 = ServerInfo.currentMilliSecond;
                if (bl) {
                    Date date = new Date(l3);
                    date.setMinutes(5);
                    date.setSeconds(0);
                    l2 = date.getTime() - l3;
                } else {
                    Date date = new Date(l3);
                    date.setHours(date.getHours() + 1);
                    date.setMinutes(0);
                    date.setSeconds(0);
                    l2 = date.getTime() - l3;
                }
                this.a(app.island.gs.p.a(bl, l2));
                break;
            }
            case 577: {
                BetData betData;
                this.v = betData = app.island.gs.w.case().byte();
                this.a(app.island.gs.p.a(betData));
                break;
            }
            case 576: {
                Goods goods;
                if (!app.island.gs.l.do(this.u.lastGetGiftTime) || (goods = app.island.gs.w.case().byte(this.u.level)) == null) break;
                goods = (Goods)GameObject.cloneObject(goods);
                this.a(goods);
                this.u.lastGetGiftTime = daff.a.b.if(ServerInfo.currentMilliSecond);
                break;
            }
            case 564: {
                this.long.do().new().a(this);
                break;
            }
            case 565: {
                int n4 = e2.i();
                this.long.do().new().a(this, n4);
                break;
            }
            case 581: {
                this.long.do().do().a(this);
                break;
            }
            case 571: {
                int n5 = e2.i();
                this.long.do().new().if(this, n5);
                break;
            }
            case 572: {
                app.island.gs.a.a().a(this, e2.case());
                break;
            }
            case 573: {
                app.island.gs.a.a().a(this);
                break;
            }
            case 513: {
                int n6 = e2.j();
                int n7 = e2.j();
                int n8 = e2.j();
                this.if(n6, n7, n8);
                break;
            }
            case 514: {
                int n9 = e2.case();
                if (!this.g()) break;
                this.long.O().a(this, n9);
                break;
            }
            case 523: {
                int n10 = e2.i();
                int n11 = this.u.personalDepot.getGoodsPosByID(n10);
                if (!this.g()) break;
                this.long.O().a(this, n11);
                break;
            }
            case 515: {
                int n12 = e2.case();
                if (!this.g()) break;
                this.long.O().if(this, n12);
                break;
            }
            case 516: {
                if (!this.g()) break;
                this.long.O().a(this);
                break;
            }
            case 517: {
                int n13 = e2.case();
                int n14 = e2.case();
                this.do(n13, n14);
                break;
            }
            case 518: {
                int n15 = e2.case();
                if (!this.g()) break;
                this.else(n15);
                break;
            }
            case 519: {
                this.a(app.island.gs.p.a(this.u));
                break;
            }
            case 521: {
                this.a(app.island.gs.p.char(this.u));
                break;
            }
            case 520: {
                this.a(app.island.gs.p.int(this.u));
                break;
            }
            case 522: {
                int n16 = e2.for() % this.u.shortCuts.idArray.length;
                int n17 = e2.for();
                int n18 = e2.i();
                this.u.shortCuts.flagArray[n16] = n17;
                this.u.shortCuts.idArray[n16] = n18;
                if (n16 == 10) {
                    this.c(n18);
                    break;
                }
                if (n16 != 11) break;
                this.byte(n18);
                break;
            }
            case 524: {
                int n19 = e2.i();
                this.a(n19);
                break;
            }
            case 525: {
                if (!this.i() || !this.g()) break;
                this.long.a(this, this.u.maxLife, false);
                break;
            }
            case 526: {
                this.I = e2.case();
                break;
            }
            case 527: {
                String string = e2.h();
                if (string.equals(this.u.user.store.password)) {
                    this.a(app.island.gs.p.a(this.u.user.store));
                    break;
                }
                this.new("\u4ed3\u5e93\u5bc6\u7801\u9519\u8bef");
                break;
            }
            case 529: {
                int n20 = e2.for();
                int n21 = this.u.user.store.getNextFreePos();
                if (n20 < 0 || n20 >= this.u.personalDepot.goodsList.length || n21 < 0 || this.u.personalDepot.goodsList[n20] == null || this.u.personalDepot.goodsList[n20].storable <= 0) break;
                this.u.user.store.goods[n21] = this.u.personalDepot.goodsList[n20];
                this.u.personalDepot.goodsList[n20] = null;
                this.a(app.island.gs.p.n(n20, n21));
                break;
            }
            case 530: {
                int n22;
                int n23 = e2.for();
                if (n23 < 0 || n23 >= this.u.user.store.capacity || (n22 = this.u.personalDepot.getNextFreePos()) < 0) break;
                this.u.personalDepot.goodsList[n22] = this.u.user.store.goods[n23];
                this.u.user.store.goods[n23] = null;
                this.a(app.island.gs.p.l(n23, n22));
                break;
            }
            case 528: {
                String string = e2.h();
                if (string.length() < 6) {
                    this.new("\u4ed3\u5e93\u5bc6\u7801\u4e0d\u80fd\u5c11\u4e8e6\u4e2a\u5b57\u7b26");
                    break;
                }
                if (string.length() > 12) {
                    this.new("\u4ed3\u5e93\u5bc6\u7801\u4e0d\u80fd\u591a\u4e8e12\u4e2a\u5b57\u7b26");
                    break;
                }
                if (!daff.a.b.a(string)) {
                    this.new("\u975e\u6cd5\u7684\u5bc6\u7801");
                    break;
                }
                this.u.user.store.password = string;
                this.for("\u4ed3\u5e93\u5bc6\u7801\u8bbe\u7f6e\u6210\u529f");
                break;
            }
            case 531: {
                this.a(app.island.gs.p.a(this.u.taskList));
                break;
            }
            case 532: {
                int n24 = e2.i();
                Task task = this.u.taskList.getTask(n24);
                if (task != null && task.stateData >= 0 && task.cancelable > 0 && task.repeatable > 0) {
                    task.stateData = -1;
                    this.a(app.island.gs.p.h(n24, task.stateData));
                    break;
                }
                this.new("\u8be5\u4efb\u52a1\u4e0d\u53ef\u653e\u5f03");
                break;
            }
            case 533: {
                int n25 = e2.i();
                Task task = this.u.taskList.getTask(n25);
                if (task == null || task.stateData >= 0 && task.stateData < task.targetStateData) break;
                this.u.taskList.removeTask(task);
                this.a(app.island.gs.p.try(n25));
                break;
            }
            case 534: {
                int n26 = e2.for();
                int n27 = e2.case();
                this.int(n26, n27);
                break;
            }
            case 535: {
                int n28 = e2.for();
                this.goto(n28);
                break;
            }
            case 536: {
                this.char();
                break;
            }
            case 560: {
                int n29 = e2.for();
                Goods[] goodsArray = new Goods[1];
                String string = this.long.O().a(this, n29, this.l, goodsArray);
                if (string == null) {
                    string = "";
                }
                if (string.length() > 0) {
                    this.new(string);
                    break;
                }
                this.a(app.island.gs.p.a(this.l, goodsArray[0]));
                int n30 = 0;
                while (n30 < this.l.length) {
                    if (this.l[n30] == null) {
                        this.l[n30] = goodsArray[0];
                        break block0;
                    }
                    ++n30;
                }
                break;
            }
            case 539: {
                int n31 = e2.for();
                int n32 = e2.for();
                if (!this.g()) break;
                this.long.O().a(this, n31, n32);
                break;
            }
            case 540: {
                int n33 = e2.case();
                int n34 = e2.case();
                if (!this.g()) break;
                this.long.O().if(this, n33, n34);
                break;
            }
            case 541: {
                int n35 = e2.i();
                int n36 = e2.for();
                this.long.O().do(this, n35, n36);
                break;
            }
            case 542: {
                break;
            }
            case 543: {
                String string = e2.h();
                if (this.u.gmGrade <= 0 && this.long.do().a(string) || this.u.friendList.hasFriend(string) || this.u.friendList.friendCount >= this.u.friendList.friends.length) break;
                this.u.friendList.addFriend(string);
                h h2 = this.long.do().if(string);
                if (h2 == null) break;
                h2.a(app.island.gs.p.for(1, this.u.name));
                app.b.b b2 = app.island.gs.p.a(h2.b(), h2.r().level, h2.r().race, h2.r().guildName, h2.j().int());
                this.a(b2);
                break;
            }
            case 544: {
                String string = e2.h();
                this.u.friendList.removeFriend(string);
                h h3 = this.long.do().if(string);
                if (h3 == null) break;
                h3.a(app.island.gs.p.a(1, this.u.name));
                break;
            }
            case 545: {
                String string = e2.h();
                if (this.u.gmGrade <= 0 && this.long.do().a(string) || this.u.friendList.hasEnemy(string) || this.u.friendList.enemyCount >= this.u.friendList.enemies.length) break;
                this.u.friendList.addEnemy(string);
                h h4 = this.long.do().if(string);
                if (h4 == null) break;
                h4.a(app.island.gs.p.for(2, this.u.name));
                app.b.b b3 = app.island.gs.p.a(h4.b(), h4.r().level, h4.r().race, h4.r().guildName, h4.j().int());
                this.a(b3);
                break;
            }
            case 546: {
                String string = e2.h();
                this.u.friendList.removeEnemy(string);
                h h5 = this.long.do().if(string);
                if (h5 == null) break;
                h5.a(app.island.gs.p.a(2, this.u.name));
                break;
            }
            case 547: {
                String string = e2.h();
                if (this.u.gmGrade <= 0 && this.long.do().a(string) || this.u.friendList.hasBlack(string) || this.u.friendList.blackCount >= this.u.friendList.blacks.length) break;
                this.u.friendList.addBlack(string);
                h h6 = this.long.do().if(string);
                if (h6 == null) break;
                h6.a(app.island.gs.p.for(3, this.u.name));
                app.b.b b4 = app.island.gs.p.a(h6.b(), h6.r().level, h6.r().race, h6.r().guildName, h6.j().int());
                this.a(b4);
                break;
            }
            case 548: {
                String string = e2.h();
                this.u.friendList.removeBlack(string);
                h h7 = this.long.do().if(string);
                if (h7 == null) break;
                h7.a(app.island.gs.p.a(3, this.u.name));
                break;
            }
            case 549: {
                String string = e2.h();
                if (this.u.friendList.hasFriend(string) || this.u.friendList.hasEnemy(string) || this.u.friendList.hasBlack(string)) {
                    h h8 = this.long.do().if(string);
                    if (h8 != null) {
                        app.b.b b5 = app.island.gs.p.a(h8.b(), h8.r().level, h8.r().race, h8.r().guildName, h8.j().int());
                        this.a(b5);
                        break;
                    }
                    this.try(string + "\u4e0d\u5728\u7ebf");
                    break;
                }
                this.new("\u6ca1\u6709\u6743\u9650");
                break;
            }
            case 550: {
                int n37 = e2.case();
                if (!this.g() || this.u.personalDepot.goodsList[n37] == null || this.u.personalDepot.goodsList[n37].goodsType != 6) break;
                Fashion fashion = (Fashion)this.u.personalDepot.goodsList[n37];
                if (fashion.sex < 0 || fashion.sex == this.u.sex) {
                    Fashion fashion2 = this.u.personalDepot.fashion;
                    this.u.personalDepot.fashion = (Fashion)this.u.personalDepot.goodsList[n37];
                    this.u.personalDepot.goodsList[n37] = fashion2;
                    this.u.calculateProperties();
                    this.a(app.island.gs.p.goto(n37));
                    app.b.b b6 = app.island.gs.p.case(this.u.id, this.u.suit);
                    this.long.a(b6, this.u.x, this.u.y, this);
                    break;
                }
                this.new("\u6027\u522b\u4e0d\u7b26");
                break;
            }
            case 551: {
                if (!this.g() || this.u.personalDepot.fashion == null) break;
                int n38 = this.u.personalDepot.getNextFreePos();
                if (n38 >= 0) {
                    this.u.personalDepot.goodsList[n38] = this.u.personalDepot.fashion;
                    this.u.personalDepot.fashion = null;
                    this.u.calculateProperties();
                    this.a(app.island.gs.p.new());
                    app.b.b b7 = app.island.gs.p.case(this.u.id, this.u.suit);
                    this.long.a(b7, this.u.x, this.u.y, this);
                    break;
                }
                this.new("\u80cc\u5305\u4e2d\u6ca1\u6709\u7a7a\u95f2\u7684\u4f4d\u7f6e\u4e86\uff01");
                break;
            }
            case 552: {
                Goods[] goodsArray = new Goods[1];
                String string = this.long.O().do(this, this.l, goodsArray);
                if (string.length() > 0) {
                    this.new(string);
                    break;
                }
                this.a(app.island.gs.p.if(goodsArray[0]));
                break;
            }
            case 553: {
                String string = e2.h();
                String string2 = e2.h();
                if (!string.equals(this.u.password)) {
                    this.new("\u5bc6\u7801\u4e0d\u6b63\u786e");
                    break;
                }
                if (!daff.a.b.a(string2)) {
                    this.new("\u975e\u6cd5\u7684\u65b0\u5bc6\u7801");
                    break;
                }
                this.u.password = string2;
                this.for("\u8bbe\u7f6e\u5bc6\u7801\u6210\u529f\uff0c\u8bf7\u7262\u8bb0\u6b64\u5bc6\u7801\uff01");
                break;
            }
            case 554: {
                int n39 = e2.for();
                int n40 = this.u.personalDepot.getFreeShopPos();
                if (this.u.level <= ServerInfo.pkProtectionLevel || n39 >= this.u.personalDepot.goodsList.length || this.u.personalDepot.goodsList[n39] == null || this.u.personalDepot.goodsList[n39].tradable <= 0 || n40 < 0) break;
                this.u.personalDepot.shopGoods[n40] = this.u.personalDepot.goodsList[n39];
                this.u.personalDepot.shopGoods[n40].treasureCost = 0;
                this.u.personalDepot.goodsList[n39] = null;
                this.a(app.island.gs.p.d(n39, n40));
                break;
            }
            case 555: {
                int n41 = e2.for();
                int n42 = this.u.personalDepot.getNextFreePos();
                if (n41 >= this.u.personalDepot.shopGoods.length || this.u.personalDepot.shopGoods[n41] == null || n42 < 0) break;
                this.u.personalDepot.goodsList[n42] = this.u.personalDepot.shopGoods[n41];
                Goods goods = Goods.getGlobalGoods(this.u.personalDepot.goodsList[n42].id);
                this.u.personalDepot.goodsList[n42].moneyCost = goods.moneyCost;
                this.u.personalDepot.goodsList[n42].treasureCost = goods.treasureCost;
                this.u.personalDepot.shopGoods[n41] = null;
                this.a(app.island.gs.p.do(n41, n42, goods.moneyCost, goods.treasureCost));
                break;
            }
            case 556: {
                int n43 = e2.for();
                int n44 = e2.i();
                int n45 = e2.i();
                if (n43 >= this.u.personalDepot.shopGoods.length || this.u.personalDepot.shopGoods[n43] == null || n44 <= 0 && n45 <= 0) break;
                this.u.personalDepot.shopGoods[n43].moneyCost = n44;
                this.u.personalDepot.shopGoods[n43].treasureCost = n45;
                break;
            }
            case 557: {
                this.a(app.island.gs.p.a(this.u.personalDepot));
                break;
            }
            case 558: {
                if (this.char != null || !this.g()) break;
                String string = e2.h();
                if (string.length() > 12) {
                    string = "\u4e2a\u4eba\u5546\u5e97";
                }
                if (this.long.do(this, string)) {
                    this.u.shopName = string;
                    this.char = new v();
                    this.char.if(this, string);
                    int n46 = ServerInfo.personalShopTaxRate;
                    if (this.long.p() != null) {
                        n46 = this.long.p().e().cityTaxRate;
                    }
                    if (n46 > 0) {
                        this.for("\u73b0\u5728\u672c\u57ce\u5e02\u7684\u6446\u644a\u7a0e\u7387\u662f" + n46 + "%\uff0c\u6bcf\u4e2a\u51fa\u552e\u7269\u54c1\u7269\u54c1\u4ef7\u683c\u5728100\u91d1\u5e01\u6216\u80055\u5143\u5b9d\u4ee5\u4e0a\u5c06\u88ab\u5f81\u7a0e");
                        break;
                    }
                    this.for("\u73b0\u5728\u672c\u57ce\u5e02\u514d\u6536\u6446\u644a\u7a0e\uff0c\u4e2a\u4eba\u6446\u644a\u4ea4\u6613\u6ca1\u6709\u7a0e\u6536");
                    break;
                }
                this.try("\u672c\u573a\u666f\u7684\u4e2a\u4eba\u5546\u5e97\u5df2\u7ecf\u8fbe\u5230\u4e0a\u9650\u4e86");
                break;
            }
            case 559: {
                this.F();
                break;
            }
            case 561: {
                int n47 = e2.for();
                this.long.O().a(this, this.l, n47);
                break;
            }
            case 563: {
                Object object;
                if (this.u.friendList.master == null) break;
                this.a(app.island.gs.p.a());
                if (this.e != null) {
                    object = (h)this.e.attachment;
                    ((h)object).a(app.island.gs.p.long(this.u.name));
                    this.e.friendList.removeStudent(this.u.name);
                    this.e = null;
                }
                object = "\u73a9\u5bb6\u3010" + this.u.name + "\u3011\u4e0d\u5fe0\uff0c\u53db\u79bb\u4e86\u4ed6\u7684\u5e08\u7236\u3010" + this.u.friendList.master.name + "\u3011";
                this.u.friendList.master = null;
                this.long.do().a(app.island.gs.p.d((String)object));
                break;
            }
            case 562: {
                String string = e2.h();
                if (!this.u.friendList.hasStudent(string)) break;
                this.a(app.island.gs.p.long(string));
                h h9 = this.long.do().if(string);
                if (h9 != null) {
                    h9.a((Hero)null);
                    h9.r().friendList.master = null;
                    h9.a(app.island.gs.p.a());
                }
                String string3 = "\u73a9\u5bb6\u3010" + this.u.name + "\u3011\u5c06\u4ed6\u7684\u5f92\u5f1f\u3010" + string + "\u3011\u8e22\u51fa\u4e86\u5e08\u95e8";
                this.long.do().a(app.island.gs.p.d(string3));
                this.u.friendList.removeStudent(string);
                break;
            }
            case 567: {
                int n48 = e2.for();
                this.if(n48);
                break;
            }
            case 568: {
                int n49 = e2.for();
                this.case(n49);
                break;
            }
            case 569: {
                this.try();
                break;
            }
            case 570: {
                String string = this.long.O().int(this, this.else, null);
                if (string == null) {
                    string = "";
                }
                if (string.length() > 0) {
                    this.new(string);
                    break;
                }
                this.a(app.island.gs.p.char());
                break;
            }
            case 580: {
                this.a(app.island.gs.p.a(this.j.if()));
                break;
            }
            case 574: {
                int n50 = e2.i();
                if (this.j == null) break;
                this.j.if(n50);
                break;
            }
            case 575: {
                this.j = null;
                break;
            }
        }
        Object var77_100 = null;
        if ((n2 == 550 || n2 == 551) && this.g()) {
            app.b.b b8 = app.island.gs.p.a(this.u.id, this.u.suit, this.u.halo, this.u.maxLife);
            this.a(b8);
            Field field = this.getClass().getDeclaredField("long");
            field.setAccessible(true);
            Object object = field.get(this);
            if (object != null) {
                object.getClass().getMethod("a", Class.forName("app.b.b"), Integer.TYPE, Integer.TYPE, this.getClass()).invoke(object, b8, new Integer(this.u.x), new Integer(this.u.y), this);
            }
            this.B();
        }
    }

    public void d(int n2) {
        if (this.h() && this.u.life > 0) {
            this.for = 3;
            this.y[0] = n2;
        }
    }

    public boolean i() {
        return this.u.life <= 0;
    }

    public void if(String string) {
        this.a(app.island.gs.p.b(string));
    }

    public int o() {
        return this.u.y;
    }

    public void for(int n2, int n3) {
        if (this.h() && this.u.life > 0) {
            this.for = 4;
            this.y[0] = 1;
            this.y[1] = n2;
            this.y[2] = n3;
        }
    }

    public void if(Spell spell) {
        this.u.spellList.addSpell(spell);
        this.a(app.island.gs.p.a(spell));
    }

    public void a(n n2) {
        ++this.u.monsterKills;
        if (this.u.monsterKills % 5 == 0) {
            this.long.do().a(this.u, 3);
        }
        int n3 = this.u.taskList.tasks.for();
        int n4 = 0;
        while (n4 < n3) {
            Task task = (Task)this.u.taskList.tasks.if(n4);
            if (task.subjectType == 2 && task.stateData >= 0 && task.stateData < task.targetStateData && task.subjectDataString.equals(n2.void())) {
                ++task.stateData;
                this.a(app.island.gs.p.h(task.id, task.stateData));
            }
            ++n4;
        }
    }

    public void if(int n2, int n3) {
        this.u.x = n2;
        this.u.y = n3;
    }

    public void a(Decoration decoration, Decoration decoration2) {
        int n2;
        int n3 = decoration != null ? decoration.lifeRaised : 0;
        int n4 = n2 = decoration2 != null ? decoration2.lifeRaised : 0;
        if (n3 != n2) {
            app.b.b b2 = app.island.gs.p.m(this.u.id, this.u.maxLife);
            this.long.a(b2, this.u.x, this.u.y, this);
            if (this.new != null) {
                this.new.new(this);
            }
        }
        Object var7_6 = null;
        Field field = this.getClass().getDeclaredField("long");
        field.setAccessible(true);
        Object object = field.get(this);
        object.getClass().getMethod("a", Class.forName("app.b.b"), Integer.TYPE, Integer.TYPE, this.getClass()).invoke(object, app.island.gs.p.a(this.u.id, this.u.suit, this.u.halo, this.u.maxLife), new Integer(this.u.x), new Integer(this.u.y), this);
        this.B();
        Object var11_9 = null;
        this.a(app.island.gs.p.a(this.u.id, this.u.suit, this.u.halo, this.u.maxLife));
        this.B();
    }

    private void goto(int n2) {
        if (n2 >= this.l.length || this.l[n2] == null) {
            return;
        }
        int n3 = this.u.personalDepot.getNextFreePos();
        if (n3 >= 0) {
            this.u.personalDepot.goodsList[n3] = this.l[n2];
            this.l[n2] = null;
            this.a(app.island.gs.p.for(n2, n3));
        } else {
            this.new("\u80cc\u5305\u4e2d\u6ca1\u6709\u7a7a\u95f2\u7684\u4f4d\u7f6e");
        }
    }

    private void char() {
        int n2 = 0;
        while (n2 < this.l.length) {
            if (this.l[n2] != null) {
                int n3 = this.u.personalDepot.getNextFreePos();
                if (n3 >= 0) {
                    this.u.personalDepot.goodsList[n3] = this.l[n2];
                } else if (this.long != null) {
                    SceneConfigData sceneConfigData = this.long.z();
                    int n4 = sceneConfigData.goodsProtectionTime;
                    sceneConfigData.goodsProtectionTime = sceneConfigData.goodsLifeTime;
                    this.long.a(this.l[n2], this.u.id, 0, this.u.x, this.u.y);
                    sceneConfigData.goodsProtectionTime = n4;
                }
                this.l[n2] = null;
            }
            ++n2;
        }
    }

    public void a(int n2, int n3) {
        if (this.h() && this.u.life > 0 && n2 >= 0 && n2 < this.long.x() && n3 >= 0 && n3 < this.long.M()) {
            this.for = 2;
            this.y[0] = n2;
            this.y[1] = n3;
        }
    }

    public void a(int n2, int n3, int n4) {
        if (this.h() && this.u.life > 0 && n3 >= 0 && n3 < this.long.x() && n4 >= 0 && n4 < this.long.M()) {
            this.for = 4;
            this.y[0] = 0;
            this.y[1] = n2;
            this.y[2] = n3;
            this.y[3] = n4;
        }
    }

    public void A() {
        this.M = ServerInfo.currentMilliSecond + (long)this.u.getAttackTime() - 50L;
        this.if = ServerInfo.currentMilliSecond + (long)this.u.getAttackTime() + (long)this.u.getAttackDelay() - 50L;
        this.E = ServerInfo.currentMilliSecond + (long)this.u.getAttackTime() + (long)this.u.getAttackDelay();
        this.case = ServerInfo.currentMilliSecond;
    }

    public boolean void() {
        return this.g;
    }

    public void new(String string) {
        this.a(app.island.gs.p.char(string));
    }

    public void N() {
        this.u.chatable = !this.u.chatable;
    }

    private void try() {
        int n2 = 0;
        while (n2 < this.else.length) {
            if (this.else[n2] != null) {
                int n3 = this.u.personalDepot.getNextFreePos();
                if (n3 >= 0) {
                    this.u.personalDepot.goodsList[n3] = this.else[n2];
                } else if (this.long != null) {
                    SceneConfigData sceneConfigData = this.long.z();
                    int n4 = sceneConfigData.goodsProtectionTime;
                    sceneConfigData.goodsProtectionTime = sceneConfigData.goodsLifeTime;
                    this.long.a(this.else[n2], this.u.id, 0, this.u.x, this.u.y);
                    sceneConfigData.goodsProtectionTime = n4;
                }
                this.else[n2] = null;
            }
            this.else[n2] = null;
            this.z[n2] = -1;
            ++n2;
        }
    }

    public void long() {
        if (this.for == 1) {
            this.a(app.island.gs.p.a(false, this.u));
        }
        this.for = 0;
    }

    public void do(String string) {
        this.a(app.island.gs.p.void(string));
    }

    public int m() {
        return this.u.x;
    }

    public void new(int n2) {
        if (n2 > 0) {
            this.u.personalDepot.money += n2;
            if (this.u.online) {
                app.b.b b2 = app.island.gs.p.case(this.u);
                this.a(b2);
            }
            if (this.long != null && ServerInfo.updatingCounter % 15 == 0) {
                this.long.do().a(this.u, 1);
            }
        }
    }

    public boolean f() {
        return this.u.endTrainTime > 0L;
    }

    public b x() {
        return this.new;
    }

    public void a(b b2) {
        this.new = b2;
    }

    public boolean if() {
        return this.q == 1 && ServerInfo.currentMilliSecond < this.M;
    }

    private void s() {
        if (this.h() && (this.for == 2 && this.long.for(this, this.y[0], this.y[1]) || this.for == 3 && this.long.goto(this, this.y[0]))) {
            this.A();
        }
    }

    private void new() {
        int n2;
        int n3;
        int n4;
        boolean bl = false;
        if (this.u.life > 0 && this.else() && (bl = this.long.if(this, n4 = this.u.x + SceneObject.X_ADVANCE_AT[n3 = this.y[0]], n2 = this.u.y + SceneObject.Y_ADVANCE_AT[n3]))) {
            this.u.direction = n3;
        }
        this.a(app.island.gs.p.a(bl, this.u));
    }

    public void a(Goods goods) {
        if (goods != null) {
            int n2 = this.u.personalDepot.getNextFreePos();
            if (n2 >= 0) {
                this.u.personalDepot.goodsList[n2] = goods;
                if (this.goto()) {
                    this.a(app.island.gs.p.a(n2, goods));
                }
            } else if (this.long != null) {
                SceneConfigData sceneConfigData = this.long.z();
                int n3 = sceneConfigData.goodsProtectionTime;
                sceneConfigData.goodsProtectionTime = sceneConfigData.goodsLifeTime;
                this.long.a(goods, this.u.id, 0, this.u.x, this.u.y);
                sceneConfigData.goodsProtectionTime = n3;
            }
            this.C();
        }
    }

    public void M() {
        if (this.B != null) {
            this.B.g();
        }
    }

    public int p() {
        return this.c;
    }

    public void void(int n2) {
        this.c = n2;
        int n3 = this.z();
        if (n3 != this.u.nameColor) {
            this.u.nameColor = n3;
            if (this.long != null) {
                this.long.a(app.island.gs.p.f(this.u.id, n3), this.u.x, this.u.y, null);
            }
            if (this.new != null) {
                this.new.long(this);
            }
        }
    }

    public void char(int n2) {
        if (this.u.pkValue != n2) {
            this.u.pkValue = n2;
            this.a(app.island.gs.p.for(this.u.pkValue));
            int n3 = this.z();
            if (n3 != this.u.nameColor) {
                this.u.nameColor = n3;
                if (this.long != null) {
                    this.long.a(app.island.gs.p.f(this.u.id, n3), this.u.x, this.u.y, null);
                }
                if (this.new != null) {
                    this.new.long(this);
                }
            }
            if (this.long != null) {
                this.long.do().a(this.u, 4);
            }
        }
    }

    public void do(int n2) {
        int n3 = this.u.mana;
        this.u.mana += n2;
        if (this.u.mana < 0) {
            this.u.mana = 0;
        }
        if (this.u.mana > this.u.maxMana) {
            this.u.mana = this.u.maxMana;
        }
        if (this.u.mana != n3) {
            this.a(app.island.gs.p.for(this.u));
        }
    }

    public void a(FightState fightState) {
        if (this.do != null) {
            this.I();
        }
        this.do = (FightState)GameObject.cloneObject(fightState);
        this.do.addToSprite(this.u);
        if (fightState.hpPerTime == 0) {
            this.a(app.island.gs.p.a(this.do));
        }
        if (this.do.changedMaxLife > 0 && this.long != null) {
            this.long.a(app.island.gs.p.m(this.u.id, this.u.maxLife), this.u.x, this.u.y, null);
        }
    }

    public int q() {
        return this.u.gmGrade;
    }

    public void a(int n2, h h2) {
        if (this.u.life <= 0) {
            return;
        }
        FightState fightState = this.e(n2);
        if (fightState != null) {
            fightState.userData = h2;
        }
    }

    public void a(int n2, n n3) {
        if (this.u.life <= 0) {
            return;
        }
        FightState fightState = this.e(n2);
        if (fightState != null) {
            fightState.userData = n3;
        }
    }

    private FightState e(int n2) {
        int n3 = n2 % 100;
        int n4 = -1;
        int n5 = 0;
        while (n5 < this.A.length) {
            if (this.A[n5] != null) {
                if (this.A[n5].id == n2) {
                    this.A[n5].remainedTimes = this.A[n5].totalFrames;
                    return this.A[n5];
                }
                if (this.A[n5].level > n3 && this.A[n5].id / 100 == n2 / 100) {
                    return null;
                }
                if (this.A[n5].level < n3 && this.A[n5].id / 100 == n2 / 100) {
                    this.A[n5].removeFromSprite(this.u);
                    this.a(app.island.gs.p.if(this.A[n5]));
                    if (this.A[n5].changedMaxLife > 0) {
                        this.j().a(app.island.gs.p.m(this.u.id, this.u.maxLife), this.u.x, this.u.y, null);
                    }
                    this.A[n5] = null;
                    n4 = n5;
                    break;
                }
            }
            ++n5;
        }
        n5 = 0;
        while (n4 < 0 && n5 < this.A.length) {
            if (this.A[n5] == null) {
                n4 = n5;
                break;
            }
            ++n5;
        }
        if (n4 < 0) {
            return null;
        }
        FightState fightState = app.island.gs.w.case().b(n2);
        if (fightState == null) {
            return null;
        }
        fightState = (FightState)GameObject.cloneObject(fightState);
        fightState.remainedTimes = fightState.totalFrames;
        fightState.lastWorkTime = ServerInfo.currentMilliSecond + (long)fightState.delayTime;
        fightState.addToSprite(this.u);
        this.A[n4] = fightState;
        if (fightState.hpPerTime == 0 && fightState.mpPerTime == 0) {
            this.a(app.island.gs.p.a(fightState));
        }
        if (fightState.changedMaxLife > 0) {
            this.j().a(app.island.gs.p.m(this.u.id, this.u.maxLife), this.u.x, this.u.y, null);
        }
        return fightState;
    }

    public void y() {
        Object object;
        int n2;
        this.u.dataChanged = true;
        long l2 = ServerInfo.currentMilliSecond;
        if (this.H != null && l2 - this.H.lastUsedTime > (long)this.H.delayTime) {
            this.for(this.H.lifeCured);
            this.H.useCount += -1;
            this.H.lastUsedTime = l2;
            if (this.H.useCount <= 0) {
                this.H = null;
            }
        }
        if (this.J != null && l2 - this.J.lastUsedTime > (long)this.J.delayTime) {
            this.do(this.J.manaCured);
            this.J.useCount += -1;
            this.J.lastUsedTime = l2;
            if (this.J.useCount <= 0) {
                this.J = null;
            }
        }
        if (ServerInfo.updatingCounter % 100 == 0 && this.u.life > 0 && (this.u.life < this.u.maxLife || this.u.mana < this.u.maxMana)) {
            n2 = this.u.personalDepot.getLifeRestoreRate();
            int n3 = this.u.personalDepot.getManaRestoreRate();
            if (n2 > 0 || n3 > 0) {
                if (l2 - this.K > (long)ServerInfo.heroRestoreLifeManaDelay && l2 - this.case > (long)ServerInfo.heroRestoreLifeManaDelay) {
                    this.K = l2;
                    this.for(this.u.maxLife * (n2 + 1) / 100);
                    this.do(this.u.maxMana * n3 / 100);
                }
            } else if (l2 - this.K > (long)ServerInfo.heroRestoreLifeManaDelay && l2 - this.M > (long)ServerInfo.heroRestoreLifeManaDelay && l2 - this.p > (long)ServerInfo.heroRestoreLifeManaDelay) {
                this.K = l2;
                this.for(this.u.maxLife >> 7);
            }
        }
        if (l2 - this.a > 60000L && this.u.onlineExpLifeTime > 0 && this.u.life > 0) {
            n2 = this.u.level * this.u.level / 10 + 20;
            n2 = n2 * this.u.onlineExpRate / 100;
            this.int(n2);
            this.u.onlineExpLifeTime += -1;
            this.a(app.island.gs.p.char(26, this.u.onlineExpLifeTime));
            this.a = l2;
        }
        if (l2 - this.m > 60000L && this.u.doubleExpLifeTime > 0) {
            this.u.doubleExpLifeTime += -1;
            this.a(app.island.gs.p.char(28, this.u.doubleExpLifeTime));
            this.m = l2;
        }
        if (ServerInfo.updatingCounter % 512 == 0) {
            n2 = 0;
            while (n2 < this.u.personalDepot.goodsList.length) {
                if (this.u.personalDepot.goodsList[n2] != null && this.u.personalDepot.goodsList[n2].createdTime > 0L && this.u.personalDepot.goodsList[n2].lifeTime > 0 && (ServerInfo.currentMilliSecond - this.u.personalDepot.goodsList[n2].createdTime) / 1000L > (long)this.u.personalDepot.goodsList[n2].lifeTime) {
                    this.long(n2);
                }
                ++n2;
            }
            if (this.u.personalDepot.fashion != null && (ServerInfo.currentMilliSecond - this.u.personalDepot.fashion.createdTime) / 1000L > (long)this.u.personalDepot.fashion.lifeTime) {
                this.u.personalDepot.fashion = null;
                this.a(app.island.gs.p.long());
                this.u.calculateProperties();
                app.b.b b2 = app.island.gs.p.case(this.u.id, this.u.suit);
                this.long.a(b2, this.u.x, this.u.y, this);
            }
        }
        int n4 = 0;
        while (n4 < this.A.length) {
            if (this.A[n4] != null && l2 - this.A[n4].lastWorkTime >= (long)this.A[n4].frameTime) {
                this.A[n4].lastWorkTime = l2;
                this.A[n4].remainedTimes += -1;
                if (this.A[n4].hpPerTime != 0 || this.A[n4].mpPerTime != 0) {
                    this.for(this.A[n4].hpPerTime);
                    this.do(this.A[n4].mpPerTime);
                    if (this.u.life <= 0) {
                        if (this.A[n4].userData instanceof h) {
                            h h2 = (h)this.A[n4].userData;
                            h2.do(this);
                            this.if(h2);
                            this.long.E().a(h2, this);
                            break;
                        }
                        if (!(this.A[n4].userData instanceof n)) break;
                        n n5 = (n)this.A[n4].userData;
                        n5.for(this);
                        this.if(n5);
                        break;
                    }
                }
                if (this.A[n4].remainedTimes <= 0) {
                    this.A[n4].removeFromSprite(this.u);
                    if (this.A[n4].hpPerTime == 0) {
                        this.a(app.island.gs.p.if(this.A[n4]));
                    }
                    if (this.A[n4].changedMaxLife > 0) {
                        this.j().a(app.island.gs.p.m(this.u.id, this.u.maxLife), this.u.x, this.u.y, null);
                    }
                    this.A[n4] = null;
                }
            }
            ++n4;
        }
        switch (this.for) {
            case 1: {
                if (l2 < this.M) break;
                this.new();
                this.q = this.for;
                this.for = 0;
                break;
            }
            case 2: 
            case 3: {
                if (l2 <= this.if) break;
                this.s();
                this.q = this.for;
                this.for = 0;
                break;
            }
            case 4: {
                if (l2 <= this.E) break;
                this.G();
                this.q = this.for;
                this.for = 0;
                break;
            }
        }
        if (this.c > 0) {
            this.void(this.c - 1);
        }
        if (ServerInfo.updatingCounter % 3000 == 0) {
            n4 = this.u.taskList.tasks.for();
            int n6 = 0;
            while (n6 < n4) {
                object = (Task)this.u.taskList.tasks.if(n6);
                if (((Task)object).stateData >= 0 && ((Task)object).taskDeadline > 0L && ServerInfo.currentMilliSecond >= ((Task)object).taskDeadline) {
                    ((Task)object).stateData = -2;
                    this.a(app.island.gs.p.h(((GameObject)object).id, ((Task)object).stateData));
                }
                ++n6;
            }
        }
        if (this.u.pkValue > 0 && ServerInfo.updatingCounter % 6000 == 0) {
            if (this.G == 0L) {
                this.G = ServerInfo.currentMilliSecond;
            } else if (ServerInfo.currentMilliSecond - this.G > (long)ServerInfo.reducePkValueTime) {
                this.G = ServerInfo.currentMilliSecond;
                this.char(this.u.pkValue - 1);
            }
        }
        if (this.N && this.u.joinedGuild != null) {
            Guild guild = this.C;
            int n7 = this.u.joinedGuild.icon;
            object = this.u.joinedGuild.introduction;
            this.u.joinedGuild = null;
            int n8 = 0;
            if (ServerInfo.guildCreationGoodsCost > 0) {
                n8 = this.u.personalDepot.getGoodsPosByID(ServerInfo.guildCreationGoodsCost);
            }
            if (guild == null || this.F.length() > 0) {
                this.new(this.F);
            } else if (n8 >= 0 && this.u.personalDepot.money >= ServerInfo.guildCreationMoneyCost && this.u.level >= ServerInfo.guildCreationHeroLevel) {
                this.u.personalDepot.money -= ServerInfo.guildCreationMoneyCost;
                this.a(app.island.gs.p.case(this.u));
                if (ServerInfo.guildCreationGoodsCost > 0) {
                    this.long(n8);
                }
                guild.init();
                guild.icon = n7;
                guild.introduction = object;
                guild.createdTime = ServerInfo.currentTimeCode;
                e e2 = new e(guild);
                e2.a(this.long.do());
                e2.i(this);
                this.long.do().a(e2);
            }
            this.N = false;
            this.C = null;
            this.F = "";
        }
        if (this.u.friendList.master != null && this.e != null && this.u.friendList.master.closeness < 10000 && ServerInfo.currentMilliSecond - this.d > (long)ServerInfo.addShiTuClosenessTime) {
            this.d = ServerInfo.currentMilliSecond;
            h h3 = (h)this.e.attachment;
            if (h3.j() == this.long && this.long.a(this.e.x, this.e.y, this.u.x, this.u.y)) {
                ++this.u.friendList.master.closeness;
                this.e.friendList.addStudentCloseness(this.u.name, 1);
                this.a(app.island.gs.p.int(this.u.friendList.master.closeness, this.e.level, this.e.turns));
                h3.a(app.island.gs.p.a(this.u.name, this.u.friendList.master.closeness, this.u.level, this.u.turns));
            }
        }
    }

    public void do(n n2) {
        this.v();
    }

    public void a(h h2) {
        this.v();
    }

    private void v() {
        if (this.goto != 0) {
            int n2 = this.u.personalDepot.getGoodsPosByID(this.goto);
            if (n2 < 0) {
                this.goto = 0;
            } else if (this.u.life > 0) {
                Goods goods = this.u.personalDepot.goodsList[n2];
                if (goods.goodsType == 5 && ((SpecialProperty)goods).spType == 31) {
                    SpecialProperty specialProperty = (SpecialProperty)goods;
                    int n3 = this.u.life * 100 / this.u.maxLife;
                    if (n3 < specialProperty.parameter2) {
                        int n4 = Math.min(this.u.maxLife - this.u.life, specialProperty.parameter1);
                        this.for(n4);
                        specialProperty.parameter1 -= n4;
                        if (specialProperty.parameter1 <= 0) {
                            this.long(n2);
                        } else {
                            this.a(app.island.gs.p.do(specialProperty.id, specialProperty.getExtraInfo()));
                        }
                    }
                }
            }
        }
        if (this.new != null) {
            this.new.else(this);
        }
        this.p = ServerInfo.currentMilliSecond;
    }

    public long d() {
        return this.n;
    }

    public void a(long l2) {
        this.n = l2;
    }

    private void case(int n2) {
        System.out.println("\u8981\u79fb\u9664\u7684\u7269\u54c1\u4f4d\u7f6e\u4e3a" + n2);
        if (n2 >= this.else.length || this.else[n2] == null) {
            System.out.println("" + this.else[n2]);
            return;
        }
        int n3 = this.u.personalDepot.getNextFreePos();
        if (n3 >= 0) {
            this.u.personalDepot.goodsList[n3] = this.else[n2];
            this.else[n2] = null;
            this.a(app.island.gs.p.if(n2, n3));
        } else {
            if (this.long != null) {
                SceneConfigData sceneConfigData = this.long.z();
                int n4 = sceneConfigData.goodsProtectionTime;
                sceneConfigData.goodsProtectionTime = sceneConfigData.goodsLifeTime;
                this.long.a(this.else[n2], this.u.id, 0, this.u.x, this.u.y);
                sceneConfigData.goodsProtectionTime = n4;
            }
            this.else[n2] = null;
            this.a(app.island.gs.p.if(n2, n3));
        }
    }

    public String b() {
        return this.u.name;
    }

    public void byte(int n2) {
        this.o = n2;
    }

    public Hero l() {
        return this.e;
    }

    public void a(Hero hero) {
        this.e = hero;
    }

    public void C() {
        int n2 = this.u.taskList.tasks.for();
        int n3 = 0;
        while (n3 < n2) {
            Task task = (Task)this.u.taskList.tasks.if(n3);
            if (task.subjectType == 1) {
                int n4 = task.stateData;
                task.isCompleted(this.u);
                if (n4 != task.stateData) {
                    this.a(app.island.gs.p.h(task.id, task.stateData));
                }
            }
            ++n3;
        }
    }

    public void int(int n2, int n3) {
        if (n2 >= this.u.personalDepot.goodsList.length) {
            return;
        }
        if (this.u.personalDepot.goodsList[n2] == null) {
            return;
        }
        if (n3 >= 0 && n3 < this.l.length) {
            Goods goods = this.l[n3];
            this.l[n3] = this.u.personalDepot.goodsList[n2];
            this.a(app.island.gs.p.byte(n2, n3));
            this.u.personalDepot.goodsList[n2] = goods;
            if (goods != null) {
                this.a(app.island.gs.p.a(n2, goods));
            }
        } else {
            int n4 = 0;
            while (n4 < this.l.length) {
                if (this.l[n4] == null) {
                    this.l[n4] = this.u.personalDepot.goodsList[n2];
                    this.u.personalDepot.goodsList[n2] = null;
                    this.a(app.island.gs.p.byte(n2, n4));
                    return;
                }
                ++n4;
            }
        }
    }

    public void b(int n2) {
        int n3 = this.u.personalDepot.getGoodsPosByID(n2);
        this.long(n3);
    }

    public void a(v v2, int n2) {
        int n3 = v2.byte(this, n2);
        this.int(n3, -1);
    }

    public void byte() {
        this.u.movable = !this.u.movable;
    }

    private void a(int n2) {
        Spell spell = this.u.spellList.getSpell(n2);
        if (spell == null) {
            this.new("\u6ca1\u6709\u8be5\u6280\u80fd");
            return;
        }
        if (spell.nextLevelSpellID == 0) {
            this.new("\u6ca1\u6709\u4e0b\u4e00\u7ea7\u4e86");
            return;
        }
        if (spell.experience < spell.maxExperience) {
            this.new("\u7ecf\u9a8c\u8fd8\u672a\u8fbe\u5230\u5347\u7ea7\u8981\u6c42");
            return;
        }
        if (spell.requiredLevel > this.u.level) {
            this.new("\u4f60\u7b49\u7ea7\u4e0d\u591f");
            return;
        }
        Spell spell2 = app.island.gs.w.case().if(spell.nextLevelSpellID);
        if (spell2 == null) {
            return;
        }
        spell.copyFrom(spell2);
        this.a(app.island.gs.p.a(n2, spell2));
    }

    private void F() {
        if (this.char != null) {
            this.char.k();
            this.char = null;
            this.u.shopName = "";
            this.long.k(this);
        }
    }

    public void if(Task task) {
        this.u.taskList.removeTask(task);
        this.a(app.island.gs.p.try(task.id));
    }

    public h(Hero hero, boolean bl) {
        this.A = new FightState[6];
        this.u = hero;
        this.w = bl;
        this.u.attachment = this;
        this.goto = this.u.shortCuts.idArray[10];
        this.o = this.u.shortCuts.idArray[11];
    }

    public void a(Guild guild, String string) {
        this.F = string;
        this.C = guild;
        this.N = true;
    }

    public u j() {
        return this.long;
    }

    public void do(u u2) {
        this.long = u2;
    }

    public int e() {
        return this.I;
    }

    public void int(String string) {
        this.u.friendList.removeFriend(string);
    }

    public boolean else() {
        return this.u.moveStops <= 0 && this.u.movable && this.char == null;
    }

    public void a(boolean bl) {
        this.k = bl;
    }

    public g u() {
        return this.j;
    }

    public void a(g g2) {
        this.j = g2;
    }

    public void L() {
        this.u.fightable = !this.u.fightable;
    }

    public e J() {
        if (this.u.joinedGuild == null) {
            return null;
        }
        return (e)this.u.joinedGuild.attachment;
    }

    public void try(int n2) {
        if (n2 > 0) {
            this.u.user.treasure += n2;
            app.b.b b2 = app.island.gs.p.case(this.u);
            this.a(b2);
        }
    }

    public void a(Equipment equipment, Equipment equipment2) {
        if (this.new != null) {
            int n2;
            int n3 = equipment != null ? equipment.lifeRaised : 0;
            int n4 = n2 = equipment2 != null ? equipment2.lifeRaised : 0;
            if (n3 != n2) {
                this.new.new(this);
            }
        }
        app.b.b b2 = app.island.gs.p.a(this.u.id, this.u.suit, this.u.halo, this.u.maxLife);
        this.long.a(b2, this.u.x, this.u.y, this);
        this.B();
    }

    public q.d a() {
        return this.t;
    }

    public void a(q.d d2) {
        this.t = d2;
    }

    public void long(int n2) {
        if (n2 >= 0 && n2 < this.u.personalDepot.goodsList.length) {
            this.u.personalDepot.goodsList[n2] = null;
            this.a(app.island.gs.p.e(n2));
            this.C();
        }
    }

    private void else(int n2) {
        if (!this.g()) {
            return;
        }
        if (n2 < 0 || n2 >= this.u.personalDepot.goodsList.length) {
            return;
        }
        Goods goods = this.u.personalDepot.goodsList[n2];
        this.u.personalDepot.goodsList[n2] = null;
        if (goods != null && goods.dropable > 0) {
            this.long.a(goods, 0, 0, this.u.x, this.u.y);
        }
        this.C();
    }

    public boolean for() {
        return this.w;
    }

    public void do() {
        this.M = ServerInfo.currentMilliSecond + (long)this.u.getStepTime() - 50L;
        this.if = ServerInfo.currentMilliSecond + (long)this.u.getStepTime() + (long)this.u.getAttackDelay() - 50L;
        this.E = ServerInfo.currentMilliSecond + (long)this.u.getStepTime() + (long)this.u.getAttackDelay();
        ++this.u.motionCount;
        if (this.u.motionCount % 20 == 0) {
            this.long.do().a(this.u, 5);
        }
    }

    public void a(u u2) {
        this.K = ServerInfo.currentMilliSecond;
        if (this.m == 0L) {
            this.m = ServerInfo.currentMilliSecond;
        }
        this.a = ServerInfo.currentMilliSecond;
        this.d = ServerInfo.currentMilliSecond;
    }

    public void if(u u2) {
        this.long();
        this.case();
        this.w();
        this.c = 0;
        this.u.nameColor = this.z();
    }

    public Hero r() {
        return this.u;
    }

    public void E() {
        this.a(app.island.gs.p.a(this.u.visible));
        if (this.u.offlineExpLifeTime > 0 && this.u.lastLogoutTime > 0) {
            Date date = daff.a.b.a(this.u.lastLogoutTime);
            long l2 = date.getTime();
            long l3 = ServerInfo.currentMilliSecond - l2;
            int n2 = (int)(l3 / 60000L);
            if ((n2 = Math.min(n2, this.u.offlineExpLifeTime)) > 0) {
                int n3 = this.u.level * this.u.level / 10 + 20;
                n3 = n3 * this.u.offlineExpRate / 100;
                this.int(n3 *= n2);
                this.u.offlineExpLifeTime -= n2;
                this.a(app.island.gs.p.char(27, this.u.offlineExpLifeTime));
            }
        }
        int n4 = this.u.taskList.tasks.for();
        int n5 = 0;
        while (n5 < n4) {
            Task task = (Task)this.u.taskList.tasks.if(n5);
            if (task.expiredTime > 0 && task.taskDeadline == 0L) {
                task.taskDeadline = daff.a.b.a(task.expiredTime).getTime();
                if (task.taskDeadline <= ServerInfo.currentMilliSecond) {
                    task.stateData = -2;
                }
            }
            ++n5;
        }
        this.u.nameColor = this.z();
        this.n = this.h = System.currentTimeMillis();
        this.B();
    }
}

