/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs;

import app.island.GameObject;
import app.island.data.DamageSpell;
import app.island.data.FightState;
import app.island.entity.EffectObject;
import app.island.entity.Monster;
import app.island.entity.SceneObject;
import app.island.gs.ServerInfo;
import app.island.gs.a.a;
import app.island.gs.data.MonsterAIData;
import app.island.gs.data.PlunderData;
import app.island.gs.h;
import app.island.gs.p;
import app.island.gs.u;
import app.island.gs.w;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class n {
    private u case;
    private Monster try;
    private a a;
    private PlunderData int;
    private MonsterAIData new;
    private long for;
    private int byte;
    private boolean do;
    private int char;
    private int long;
    private int else;
    private FightState[] goto = new FightState[4];
    private int if;

    public boolean goto() {
        return this.try.life > 0;
    }

    public Monster g() {
        return this.try;
    }

    public void long() {
        this.a.int();
    }

    public void f() {
        int n2 = 0;
        while (n2 < this.goto.length) {
            if (this.goto[n2] != null) {
                this.goto[n2].removeFromSprite(this.try);
                this.goto[n2] = null;
            }
            ++n2;
        }
    }

    public int new() {
        return this.try.id;
    }

    public int i() {
        return this.try.x;
    }

    public int b() {
        if (this.new.moveDestY > 0) {
            return this.new.moveDestY;
        }
        return this.else;
    }

    public int h() {
        return this.if;
    }

    private void if(long l2) {
        if (this.new.initialAliveness == 0) {
            boolean bl = true;
            if (this.new.activationSceneTime > 0) {
                boolean bl2 = bl = l2 - this.case.H() >= (long)this.new.activationSceneTime;
            }
            if (this.new.activationHeroCount > 0) {
                bl &= this.case.B() >= this.new.activationHeroCount;
            }
            if (this.new.activationDeathCount > 0) {
                bl &= this.case.G() >= this.new.activationDeathCount;
            }
            if (bl) {
                this.case.a(this);
                this.a.new();
                if (this.new.wordsOfNotice != null && this.new.wordsOfNotice.length() > 1) {
                    if (this.new.noticeRangeOnRelived == 1) {
                        this.case.a(p.d(this.new.wordsOfNotice));
                    } else if (this.new.noticeRangeOnRelived == 2) {
                        this.case.do().a(p.d(this.new.wordsOfNotice));
                    }
                }
            }
        } else if (this.for > 0L && l2 > this.for && this.if > 0) {
            this.case.a(this);
            this.a.new();
            this.if += -1;
            if (this.new.wordsOfNotice != null && this.new.wordsOfNotice.length() > 1) {
                if (this.new.noticeRangeOnRelived == 1) {
                    this.case.a(p.d(this.new.wordsOfNotice));
                } else if (this.new.noticeRangeOnRelived == 2) {
                    this.case.do().a(p.d(this.new.wordsOfNotice));
                }
            }
        }
    }

    public void a(h h2, int n2, DamageSpell damageSpell) {
        this.a.a(h2, n2, damageSpell);
    }

    public void a(h h2, int n2, EffectObject effectObject) {
        this.a.a(h2, n2, effectObject);
    }

    public void a(int n2) {
        this.try.reliveTimes = this.if = n2;
    }

    public int char() {
        return this.byte;
    }

    public int if() {
        return this.long;
    }

    public void c() {
        if (this.case == null || this.case.do() == null) {
            return;
        }
        long l2 = ServerInfo.currentMilliSecond;
        if (this.try.life <= 0) {
            this.if(l2);
        } else {
            this.a.do();
            this.a(l2);
        }
    }

    public int int() {
        if (this.new.moveDestX > 0) {
            return this.new.moveDestX;
        }
        return this.long;
    }

    public void a(int n2, h h2) {
        if (this.try.life <= 0) {
            return;
        }
        int n3 = 0;
        while (n3 < this.new.countOfStateResistance) {
            if (this.new.statesResistance[n3] == n2 / 100 && Math.random() * 100.0 < (double)this.new.resistanceRates[n3]) {
                return;
            }
            ++n3;
        }
        n3 = n2 % 100;
        int n4 = -1;
        int n5 = 0;
        while (n5 < this.goto.length) {
            if (this.goto[n5] != null) {
                if (this.goto[n5].id == n2) {
                    this.goto[n5].remainedTimes = this.goto[n5].totalFrames;
                    return;
                }
                if (this.goto[n5].level > n3 && this.goto[n5].id / 100 == n2 / 100) {
                    return;
                }
                if (this.goto[n5].level < n3 && this.goto[n5].id / 100 == n2 / 100) {
                    this.goto[n5].removeFromSprite(this.try);
                    this.goto[n5] = null;
                    n4 = n5;
                    break;
                }
            }
            ++n5;
        }
        n5 = 0;
        while (n4 < 0 && n5 < this.goto.length) {
            if (this.goto[n5] == null) {
                n4 = n5;
                break;
            }
            ++n5;
        }
        if (n4 < 0) {
            return;
        }
        FightState fightState = w.case().b(n2);
        if (fightState == null) {
            return;
        }
        fightState = (FightState)GameObject.cloneObject(fightState);
        fightState.remainedTimes = fightState.totalFrames;
        fightState.lastWorkTime = ServerInfo.currentMilliSecond + (long)fightState.delayTime;
        fightState.userData = h2;
        fightState.addToSprite(this.try);
        this.goto[n4] = fightState;
        this.a(h2, fightState);
    }

    public void int(h h2) {
        this.char = 0;
        this.a.for(h2);
        this.f();
        if (this.new.deathCounterValue > 0) {
            this.case.g(this.new.deathCounterValue);
        }
        if (this.if > 0) {
            this.for = ServerInfo.currentMilliSecond + (long)this.new.minReliveDelay + (long)((int)(Math.random() * (double)(this.new.maxReliveDelay - this.new.minReliveDelay)));
        } else {
            this.case.if(this);
        }
    }

    public void for(h h2) {
        ++this.char;
    }

    public boolean for() {
        return this.try.fightStops <= 0;
    }

    public String void() {
        return this.try.name;
    }

    public h e() {
        return this.a.char();
    }

    public MonsterAIData do() {
        return this.new;
    }

    public void a(Monster monster, MonsterAIData monsterAIData, PlunderData plunderData) {
        if (monster.id != this.try.monsterID) {
            monster.monsterID = monster.id;
            monster.x = this.try.x;
            monster.y = this.try.y;
            monster.id = this.try.id;
            this.try = monster;
        }
        if (this.new != monsterAIData) {
            this.new = monsterAIData;
            this.a = new a(this, monsterAIData);
            if (monsterAIData.initialAliveness == 0) {
                monster.life = 0;
                this.for = ServerInfo.currentMilliSecond + (long)monsterAIData.minReliveDelay + (long)((int)(Math.random() * (double)(monsterAIData.maxReliveDelay - monsterAIData.minReliveDelay)));
            } else {
                monster.life = monster.maxLife;
            }
        }
        monster.reliveTimes = this.if = monsterAIData.maxReliveTimes;
        this.int = plunderData;
    }

    public String toString() {
        return "MonsterController[id=" + this.try.id + ";name=" + this.try.name + ";life=" + this.try.life + "]";
    }

    public u case() {
        return this.case;
    }

    public void a(u u2) {
        this.case = u2;
    }

    public void a(h h2, n n2) {
        this.a.a(h2, n2);
    }

    public void a(h h2, FightState fightState) {
        this.a.a(h2, fightState);
    }

    public boolean a() {
        return this.try.moveStops <= 0;
    }

    private void a(long l2) {
        int n2 = 0;
        while (n2 < this.goto.length) {
            if (this.goto[n2] != null && l2 - this.goto[n2].lastWorkTime > (long)this.goto[n2].frameTime) {
                this.goto[n2].lastWorkTime = l2;
                this.goto[n2].remainedTimes += -1;
                if (this.goto[n2].hpPerTime != 0) {
                    int n3 = this.goto[n2].hpPerTime;
                    if (n3 > 0) {
                        n3 = Math.min(n3, this.try.maxLife - this.try.life);
                        this.try.life += n3;
                        this.case.a(p.else(this.try.id, n3), this.try.x, this.try.y, null);
                    } else {
                        n3 = Math.min(this.try.life, Math.abs(n3));
                        this.try.life -= n3;
                        this.a.a((h)this.goto[n2].userData, n3, this.goto[n2]);
                        this.case.a(p.a(this.try, n3, 0, 0), this.try.x, this.try.y, null);
                        if (this.try.life <= 0) {
                            h h2 = (h)this.goto[n2].userData;
                            this.case.E().a(h2, this);
                            h2.a(this);
                            this.int(h2);
                            break;
                        }
                    }
                }
                if (this.goto[n2].remainedTimes <= 0) {
                    this.goto[n2].removeFromSprite(this.try);
                    this.goto[n2] = null;
                }
            }
            ++n2;
        }
    }

    public PlunderData j() {
        return this.int;
    }

    public void a(PlunderData plunderData) {
        this.int = plunderData;
    }

    public int try() {
        return this.try.y;
    }

    public int d() {
        if (this.new.reliveRange <= 0) {
            return this.long | this.else << 16;
        }
        int n2 = Math.max(this.long - this.new.reliveRange, 0);
        int n3 = Math.max(this.else - this.new.reliveRange, 0);
        int n4 = Math.min(this.long + this.new.reliveRange, this.case.x());
        int n5 = Math.min(this.else + this.new.reliveRange, this.case.M());
        int n6 = n2 + (int)(Math.random() * (double)(n4 - n2));
        int n7 = n3 + (int)(Math.random() * (double)(n5 - n3));
        return n6 | n7 << 16;
    }

    public void a(n n2) {
        Monster monster = new Monster();
        monster.copyFrom(n2.try);
        this.a(monster, n2.long, n2.else, n2.new, n2.int);
    }

    public boolean byte() {
        return this.do;
    }

    public void a(int n2, int n3) {
        int n4 = SceneObject.getDirection(this.try.x, this.try.y, n2, n3);
        if (this.case.a(this, n2, n3)) {
            this.try.direction = n4;
        }
    }

    public void a(String[] stringArray, String[] stringArray2) {
        PlunderData plunderData;
        int n2 = Integer.parseInt(stringArray2[0]);
        int n3 = Integer.parseInt(stringArray2[1]);
        int n4 = Integer.parseInt(stringArray2[2]);
        int n5 = Integer.parseInt(stringArray2[3]);
        int n6 = Integer.parseInt(stringArray2[4]);
        Monster monster = w.case().for(n4);
        if (monster == null) {
            System.out.println("monster not found:" + n4);
        }
        monster = (Monster)GameObject.cloneObject(monster);
        MonsterAIData monsterAIData = w.case().goto(n6);
        if (monsterAIData == null) {
            System.out.println("monster ai not found:" + n6);
        }
        if ((plunderData = w.case().char(n5)) == null && n5 > 0) {
            System.out.println("monster plunder not found:" + n5);
        }
        this.a(monster, n2, n3, monsterAIData, plunderData);
    }

    public void a(Monster monster, int n2, int n3, MonsterAIData monsterAIData, PlunderData plunderData) {
        monster.monsterID = monster.id;
        monster.id = ServerInfo.globalMonsterIDCounter++;
        this.try = monster;
        this.long = monster.x = n2;
        this.else = monster.y = n3;
        if (this.new != monsterAIData) {
            monster.behaviorID = monsterAIData.id;
            this.new = monsterAIData;
            this.a = new a(this, monsterAIData);
            if (monsterAIData.initialAliveness == 0) {
                monster.life = 0;
                this.for = ServerInfo.currentMilliSecond + (long)monsterAIData.minReliveDelay + (long)((int)(Math.random() * (double)(monsterAIData.maxReliveDelay - monsterAIData.minReliveDelay)));
            } else {
                monster.life = monster.maxLife;
            }
            monster.reliveTimes = this.if = monsterAIData.maxReliveTimes;
        }
        this.int = plunderData;
        if (plunderData != null) {
            monster.plunderID = plunderData.id;
        }
    }

    public void a(h h2) {
        this.a.a(h2);
    }

    public void do(h h2) {
        this.a.do(h2);
    }

    public void if(h h2) {
        this.a.if(h2);
    }

    public void a(h h2, int n2, boolean bl) {
        this.a.a(h2, n2, bl);
    }

    public int else() {
        return this.else;
    }
}

