/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.a;

import app.b.b;
import app.island.data.DamageSpell;
import app.island.data.FightState;
import app.island.entity.EffectObject;
import app.island.entity.Hero;
import app.island.entity.Monster;
import app.island.entity.SceneObject;
import app.island.gs.ServerInfo;
import app.island.gs.data.MonsterAIData;
import app.island.gs.h;
import app.island.gs.n;
import app.island.gs.p;
import app.island.gs.u;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class a {
    private static final a[] m = new a[0];
    public static final int else = 1;
    public static final int i = 2;
    public static final int e = 3;
    public static final int g = 4;
    public static final int k = 5;
    private n b;
    private Monster for;
    private MonsterAIData h;
    private int int;
    private long goto;
    private long l;
    private long byte;
    private long try;
    private int c;
    private daff.a.h case = new daff.a.h(8);
    private a[] void = m;
    private int a;
    private h char;
    private h do;
    private h f;
    private int long;
    private h d;
    private int if;
    private int new;
    private DamageSpell j;

    public void a(h h2, int n2, EffectObject effectObject) {
        if (h2.i()) {
            return;
        }
        this.a(h2, n2);
        if (this.h.enmityEnabled > 0) {
            Hero hero = h2.r();
            int n3 = n2 * this.h.magicDamageEnmityFactor * effectObject.enmityFactor * this.h.raceEnmityFactors[hero.race] * (hero.level + 1) * this.h.nearDamageEnmityFactor;
            this.a(h2, n2, n3 + 1);
        }
    }

    public void a(h h2, int n2, FightState fightState) {
        if (h2.i()) {
            return;
        }
        this.a(h2, n2);
    }

    public void a(h h2, int n2) {
        if (this.do != h2) {
            this.do = h2;
        }
        if (this.h.escapeMinLife > 0 && this.for.life <= this.h.escapeMinLife) {
            this.if();
        } else if (this.h.escapeMaxHurt > 0 && n2 > this.h.escapeMaxHurt) {
            this.if();
        } else if (this.char == null) {
            if (this.int == 5 && this.h.fightOnReturn > 0) {
                this.if(h2, this.h.hurtResponseDelay);
            } else if (this.int != 3) {
                this.if(h2, this.h.hurtResponseDelay);
            }
        } else if (this.h.changeTargetOnHurt > 0) {
            if (this.h.preferredDistance > 0 && (Math.abs(this.char.m() - this.for.x) > this.for.attackRange || Math.abs(this.char.o() - this.for.y) > this.for.attackRange) && Math.abs(this.do.m() - this.for.x) <= this.for.attackRange && Math.abs(this.do.o() - this.for.y) <= this.for.attackRange) {
                this.if(this.do, this.for.getAttackDelay());
            }
            if (this.char != this.do && this.h.preferredLevel > 0 && this.do.r().level < this.char.r().level) {
                this.if(this.do, this.for.getAttackDelay());
            }
            if (this.char != this.do && this.h.preferredLife > 0 && this.do.r().life < this.char.r().life) {
                this.if(this.do, this.for.getAttackDelay());
            }
            if (this.char != this.do && this.h.preferredRace >= 0 && this.do.r().race == this.h.preferredRace) {
                this.if(this.do, this.for.getAttackDelay());
            }
        }
        if (this.h.enemyPriority == 0) {
            int n3;
            int n4;
            Hero hero = h2.r();
            if (this.f == null) {
                this.f = h2;
                n4 = 0;
                n3 = 0;
                if (hero.race == 1) {
                    n4 = hero.getMaxMagicDamage();
                    n3 = hero.getMinMagicDamage();
                } else {
                    n4 = hero.getMaxPhysicalDamage();
                    n3 = hero.getMinPhysicalDamage();
                }
                this.long = (n4 + n3) / 2 * n2 / (hero.level + 1);
            }
            if (this.for.life <= 0) {
                this.d = h2;
                n4 = 0;
                n3 = 0;
                if (hero.race == 1) {
                    n4 = hero.getMaxMagicDamage();
                    n3 = hero.getMinMagicDamage();
                } else {
                    n4 = hero.getMaxPhysicalDamage();
                    n3 = hero.getMinPhysicalDamage();
                }
                this.if = (n4 + n3) / 2 * n2 / (hero.level + 1);
            }
        }
    }

    public void a() {
        this.char = null;
        this.int = 5;
        this.goto = ServerInfo.currentMilliSecond + (long)this.for.getMoveDelay();
    }

    private boolean a(int n2, int n3, long l2) {
        if (this.b.a()) {
            u u2 = this.b.case();
            int n4 = u2.J().a(this.for.x, this.for.y, n2, n3, u2);
            if (n4 < 0) {
                return false;
            }
            int n5 = SceneObject.X_ADVANCE_AT[n4] + this.for.x;
            int n6 = SceneObject.Y_ADVANCE_AT[n4] + this.for.y;
            this.b.a(n5, n6);
        }
        return true;
    }

    private h a(int n2) {
        h h2 = null;
        switch (this.h.enemyPriority) {
            case 1: {
                h2 = this.case();
                break;
            }
            case 2: {
                int n3 = Math.min(5, this.a);
                int n4 = (int)(Math.random() * (double)n3);
                h2 = this.void[n4].int;
                break;
            }
            case 3: {
                int n5 = Math.min(10, this.a);
                int n6 = (int)(Math.random() * (double)n5);
                h2 = this.void[n6].int;
                break;
            }
            case 4: {
                int n7 = (int)(Math.random() * (double)this.a);
                h2 = this.void[n7].int;
                break;
            }
            case 5: 
            case 6: 
            case 7: {
                h h3 = this.if(this.h.enemyPriority - 5);
                if (h3 == null) break;
                h2 = h3;
                break;
            }
        }
        return h2;
    }

    public void if(h h2, int n2) {
        this.char = h2;
        this.int = 2;
        this.goto = ServerInfo.currentMilliSecond + (long)this.h.hurtResponseDelay;
        this.new = 0;
    }

    private void for() {
        if (this.a > 0 && this.h.enemyPriority > 0) {
            this.char = this.a(this.h.enemyPriority);
        }
        if (this.char == null) {
            this.int();
        } else if (this.char.i() || !this.char.goto() || this.char.j() != this.b.case()) {
            this.case.do(this.char);
            this.int(this.char);
            this.int();
        } else if (this.new > this.h.maxTracingSteps) {
            this.int();
        } else if (Math.abs(this.for.x - this.b.int()) > this.h.fightRange || Math.abs(this.for.y - this.b.b()) > this.h.fightRange) {
            if (this.h.flyToOrigin > 0) {
                int n2 = this.b.case().for(this.b.if(), this.b.else());
                if (n2 >= 0) {
                    int n3 = n2 & 0xFFFF;
                    int n4 = n2 >> 16;
                    this.b.a(n3, n4);
                }
                this.int();
            } else {
                this.a();
            }
        }
    }

    private h for(long l2) {
        int n2;
        h h2;
        this.l = l2 + (long)this.h.searchDelay;
        if (this.do != null) {
            Hero hero = this.do.r();
            Monster monster = this.b.g();
            if (Math.abs(hero.x - monster.x) < this.h.searchRange && Math.abs(hero.y - monster.y) < this.h.searchRange) {
                return this.do;
            }
        }
        if (this.h.preferredPKValue > 0) {
            return this.long();
        }
        int n3 = this.case.for();
        if (n3 > 0 && !(h2 = (h)this.case.if(n2 = (int)(Math.random() * (double)n3))).i() && (this.h.lockTargetRate >= 100 || Math.random() * 100.0 < (double)this.h.lockTargetRate)) {
            Hero hero = h2.r();
            if (Math.abs(hero.x - this.for.x) < this.h.searchRange && Math.abs(hero.y - this.for.y) < this.h.searchRange) {
                if (this.h.enmityEnabled > 0) {
                    this.a(h2, 0, 1);
                }
                return h2;
            }
        }
        return null;
    }

    private h long() {
        int n2 = this.case.for();
        int n3 = 0;
        while (n3 < n2) {
            h h2 = (h)this.case.if(n3);
            if (!h2.i() && h2.r().pkValue >= this.h.preferredPKValue) {
                return h2;
            }
            ++n3;
        }
        return null;
    }

    public int goto() {
        return this.int;
    }

    public void do(int n2) {
        this.int = n2;
    }

    public void for(h h2) {
        this.c = 0;
        this.case.a();
        this.char = null;
        this.do = null;
        this.f = null;
        h2 = null;
        if (this.a > 0) {
            int n2 = 0;
            while (n2 < this.a) {
                this.void[n2].int = null;
                ++n2;
            }
            this.a = 0;
        }
    }

    public void new() {
        if (this.h.moveDestX > 0) {
            this.int = 4;
            this.goto = ServerInfo.currentMilliSecond + (long)this.for.getMoveDelay();
        } else {
            this.int();
        }
        if (this.h.noticeRangeOnRelived == 1) {
            b b2 = p.void(this.h.wordsOfNotice);
            this.b.case().a(b2, null);
        } else if (this.h.noticeRangeOnRelived == 2) {
            b b3 = p.void(this.h.wordsOfNotice);
            this.b.case().do().a(b3);
        }
    }

    private void a(long l2) {
        switch (this.int) {
            case 1: {
                this.do(l2);
                break;
            }
            case 2: {
                this.byte(l2);
                break;
            }
            case 3: {
                this.try(l2);
                break;
            }
            case 4: {
                this.case(l2);
                break;
            }
            case 5: {
                this.new(l2);
                break;
            }
        }
    }

    private void do(long l2) {
        if (this.c <= 0) {
            if (this.for.life < this.for.maxLife && this.h.autoCureDelay > 0 && l2 - this.try > (long)this.h.autoCureDelay) {
                int n2 = this.for.maxLife * this.h.cureRate / 100;
                this.for.life = Math.min(n2 + this.for.life, this.for.maxLife);
            }
        } else if (this.h.searchRange > 0 && l2 > this.l && (this.char = this.for(l2)) != null) {
            this.if(this.char, this.for.getMoveDelay());
        } else if (this.h.randomMoveRange > 0 && l2 > this.byte && this.b.a()) {
            this.int(l2);
        }
    }

    private void try(long l2) {
        int n2;
        int n3;
        if (!this.b.a()) {
            return;
        }
        if (this.do == null) {
            return;
        }
        int n4 = this.do.m();
        int n5 = this.do.o();
        if (this.h.escapeRange > 0 && Math.abs(n4 - this.for.x) >= this.h.escapeRange && Math.abs(n5 - this.for.y) >= this.h.escapeRange) {
            this.int();
            return;
        }
        Monster monster = this.b.g();
        int n6 = SceneObject.getDirection(n4, n5, monster.x, monster.y);
        u u2 = this.b.case();
        if (u2.a(n3 = SceneObject.X_ADVANCE_AT[n6] + monster.x, n2 = SceneObject.Y_ADVANCE_AT[n6] + monster.y)) {
            this.b.a(n3, n2);
            this.goto = l2 + (long)monster.getMoveDelay() + (long)monster.getStepTime();
            return;
        }
        int n7 = 0;
        do {
            int n8;
            if (!u2.a(n3 = SceneObject.X_ADVANCE_AT[n8 = (int)(Math.random() * 8.0)] + monster.x, n2 = SceneObject.Y_ADVANCE_AT[n8] + monster.y)) continue;
            this.b.a(n3, n2);
            this.goto = l2 + (long)monster.getMoveDelay() + (long)monster.getStepTime();
            return;
        } while (++n7 < 2);
    }

    public void else() {
        this.char = null;
        this.int = 4;
    }

    public void do() {
        if (ServerInfo.currentMilliSecond > this.goto) {
            this.a(ServerInfo.currentMilliSecond);
        }
        int n2 = 0;
        while (n2 < this.a) {
            if (ServerInfo.currentMilliSecond - this.void[n2].a > 30000L) {
                this.void[n2].do = this.void[n2].do * 97 / 100;
                if (this.void[n2].do < 1) {
                    this.void[n2].do = 1;
                }
            }
            ++n2;
        }
    }

    public void int() {
        this.char = null;
        this.goto = ServerInfo.currentMilliSecond + (long)this.for.getStepTime() + (long)this.for.getMoveDelay();
        this.int = 1;
    }

    public h char() {
        if (this.a <= 0) {
            return null;
        }
        a a2 = this.void[0];
        int n2 = 1;
        while (n2 < this.a) {
            if (this.void[n2].for > a2.for) {
                a2 = this.void[n2];
            }
            ++n2;
        }
        return a2.int;
    }

    public void if() {
        this.char = null;
        this.int = 3;
        this.goto = ServerInfo.currentMilliSecond + (long)this.for.getMoveDelay();
    }

    private h if(int n2) {
        a a2 = null;
        int n3 = 0;
        while (n3 < this.a) {
            if (this.void[n3].int.r().race == n2) {
                if (a2 == null) {
                    a2 = this.void[n3];
                } else if (this.void[n3].do > a2.do) {
                    a2 = this.void[n3];
                }
            }
            ++n3;
        }
        if (a2 == null) {
            return null;
        }
        return a2.int;
    }

    public a(n n2, MonsterAIData monsterAIData) {
        this.b = n2;
        this.for = n2.g();
        this.h = monsterAIData;
        this.int = 1;
        if (monsterAIData.enmityEnabled > 0) {
            this.void = new a[20];
        }
    }

    public void a(h h2, n n2) {
        if (this.char == h2) {
            if (this.h.preferredPKValue > 0) {
                this.char = this.long();
            }
            if (this.char == null) {
                this.a();
                this.goto = ServerInfo.currentMilliSecond + (long)this.for.getAttackTime() + (long)this.for.getStepTime() + (long)((int)(Math.random() * (double)(this.for.getAttackDelay() + this.for.getMoveDelay())));
            } else if (this.h.moveDestX > 0) {
                this.else();
            } else {
                this.int();
            }
        }
        if (this.do == h2) {
            this.do = null;
        }
    }

    public void a(h h2, FightState fightState) {
        if (this.h.enmityEnabled > 0) {
            this.a(h2, 0, fightState.enmityFactor + 1);
        }
    }

    private void int(long l2) {
        Monster monster = this.b.g();
        int n2 = (int)(Math.random() * 8.0);
        int n3 = SceneObject.X_ADVANCE_AT[n2] + monster.x;
        int n4 = SceneObject.Y_ADVANCE_AT[n2] + monster.y;
        if (n3 < 0 || n4 < 0) {
            return;
        }
        if (this.h.moveDestX <= 0 && (Math.abs(n3 - this.b.if()) > this.h.randomMoveRange || Math.abs(n4 - this.b.else()) > this.h.randomMoveRange)) {
            return;
        }
        if (this.h.moveDestX > 0 && (Math.abs(n3 - this.h.moveDestX) > this.h.randomMoveRange || Math.abs(n4 - this.h.moveDestY) > this.h.randomMoveRange)) {
            return;
        }
        u u2 = this.b.case();
        if (n3 >= u2.x() || n4 >= u2.M()) {
            return;
        }
        if (this.b.case().a(n3, n4)) {
            this.b.a(n3, n4);
        }
        this.goto = l2 + (long)monster.getStepTime() + (long)monster.getMoveDelay();
        this.byte = this.goto + (long)this.h.randomMoveDelay + (long)((int)(Math.random() * (double)this.h.randomMoveDelay));
    }

    public n byte() {
        return this.b;
    }

    private void new(long l2) {
        if (!this.b.a()) {
            return;
        }
        if (this.h.flyToOrigin > 0) {
            int n2 = this.b.case().for(this.b.if(), this.b.else());
            if (n2 >= 0) {
                int n3 = n2 & 0xFFFF;
                int n4 = n2 >> 16;
                this.b.a(n3, n4);
            }
            this.int();
        } else if (this.h.fightOnReturn > 0 && this.do != null) {
            if (Math.abs(this.b.if() - this.do.m()) <= this.h.fightRange && Math.abs(this.b.else() - this.do.o()) < this.h.fightRange) {
                this.if(this.do, this.for.getAttackDelay());
            }
        } else {
            Monster monster = this.b.g();
            if (Math.abs(monster.x - this.b.if()) < 2 && Math.abs(monster.y - this.b.else()) < 2) {
                this.int();
                return;
            }
            int n5 = monster.stepTime;
            this.b.g().stepTime = 600;
            if (this.a(this.b.if(), this.b.else(), l2)) {
                this.goto = l2 + 600L;
            }
            monster.stepTime = n5;
        }
    }

    private void int(h h2) {
        int n2 = 0;
        while (n2 < this.a) {
            if (this.void[n2].int == h2) {
                this.void[n2].int = null;
                this.a += -1;
                a a2 = this.void[n2];
                this.void[n2] = this.void[this.a];
                this.void[this.a] = a2;
                break;
            }
            ++n2;
        }
    }

    public h try() {
        a a2 = this.void[0];
        int n2 = Math.abs(this.for.x - a2.int.m());
        int n3 = Math.abs(this.for.y - a2.int.o());
        int n4 = 1;
        while (n4 < this.a) {
            int n5 = Math.abs(this.for.x - this.void[n4].int.m());
            int n6 = Math.abs(this.for.y - this.void[n4].int.o());
            if (n5 <= n2 && n6 <= n3) {
                n2 = n5;
                n3 = n6;
                a2 = this.void[n4];
            }
            ++n4;
        }
        return a2.int;
    }

    private boolean if(long l2) {
        if (this.a > 0 && this.h.rateOfUsingSpellToAttack > 0 && (double)this.h.rateOfUsingSpellToAttack > Math.random() * 100.0) {
            boolean bl = false;
            h h2 = this.char;
            if (this.h.rateOfRepeatingSpell > 0 && this.j != null && (double)this.h.rateOfRepeatingSpell > Math.random() * 100.0) {
                bl = true;
            } else {
                int n2 = this.for.life * 100 / this.for.maxLife;
                int n3 = (int)(Math.random() * 100.0);
                int n4 = 0;
                while (n4 < this.h.countOfAttackSpells) {
                    if (this.h.useAttackSpellRates[n4] > n3) {
                        if (n2 > this.h.lifeRatesOfUsingSpell[n4]) break;
                        this.j = this.h.attackSpells[n4];
                        h2 = this.a(this.h.spellTargetPriorities[n4]);
                        bl = true;
                        break;
                    }
                    ++n4;
                }
            }
            if (this.j == null) {
                return false;
            }
            if (bl) {
                if (h2 == null || h2.j() != this.b.case() || Math.abs(this.for.x - h2.m()) > this.j.releaseRange || Math.abs(this.for.y - h2.o()) > this.j.releaseRange) {
                    h2 = this.try();
                }
                if (h2 == null) {
                    return false;
                }
                if (Math.abs(this.for.x - h2.m()) <= this.j.releaseRange && Math.abs(this.for.y - h2.o()) <= this.j.releaseRange) {
                    this.b.case().a(this.b, h2, this.j);
                    this.goto = l2 + (long)this.for.getAttackTime() + (long)this.for.getAttackDelay();
                    return true;
                }
            }
        }
        return false;
    }

    public void a(h h2) {
    }

    public void do(h h2) {
        ++this.c;
        this.case.if(h2);
        if (this.h.preferredPKValue > 0 && h2.r().pkValue >= this.h.preferredPKValue && this.char == null) {
            this.char = h2;
        }
    }

    public void if(h h2) {
        this.c += -1;
        this.case.do(h2);
        if (this.char == h2) {
            this.char = null;
            if (this.h.preferredPKValue > 0) {
                this.char = this.long();
            }
            if (this.char == null) {
                this.a();
            } else if (this.h.moveDestX > 0) {
                if (Math.abs(this.for.x - this.h.moveDestX) > this.h.destRange || Math.abs(this.for.y - this.h.moveDestY) > this.h.destRange) {
                    this.else();
                } else {
                    this.int();
                }
            } else {
                this.int();
            }
        }
        if (this.do == h2) {
            this.do = null;
            if (this.int == 3) {
                this.int();
            }
        }
        if (this.h.enmityEnabled > 0) {
            this.int(h2);
        } else if (this.f == h2) {
            this.f = null;
        }
    }

    private void a(h h2, int n2, int n3) {
        int n4 = 0;
        while (n4 < this.a) {
            if (this.void[n4].int == h2) {
                this.void[n4].do += n3;
                this.void[n4].for += n2;
                return;
            }
            ++n4;
        }
        if (this.a < this.void.length) {
            if (this.void[this.a] == null) {
                this.void[this.a] = new a();
            }
            this.void[this.a].int = h2;
            this.void[this.a].do = n3;
            this.void[this.a].if = this.a;
            this.void[this.a].for = n2;
            this.void[this.a].a = ServerInfo.currentMilliSecond;
            ++this.a;
        }
    }

    private void case(long l2) {
        if (this.char != null) {
            this.if(this.char, this.for.getAttackDelay());
        } else if (this.h.searchRange > 0 && l2 > this.l && (this.char = this.for(l2)) != null) {
            this.if(this.char, this.for.getMoveDelay());
        } else if (this.h.moveDestX == this.for.x && this.h.moveDestY == this.for.y) {
            this.int();
        } else if (Math.abs(this.for.x - this.h.moveDestX) < this.h.destRange && Math.abs(this.for.y - this.h.moveDestY) < this.h.destRange) {
            if (this.b.case().a(this.h.moveDestX, this.h.moveDestY)) {
                this.a(this.h.moveDestX, this.h.moveDestY, l2);
                int n2 = this.for.getMoveDelay();
                this.goto = l2 + (long)this.for.getStepTime() + (long)n2 + (long)((int)(Math.random() * (double)n2));
            } else {
                this.int();
            }
        } else if (this.a(this.h.moveDestX, this.h.moveDestY, l2)) {
            int n3 = this.for.getMoveDelay();
            this.goto = l2 + (long)this.for.getStepTime() + (long)n3 + (long)((int)(Math.random() * (double)n3));
        } else {
            this.int();
        }
    }

    private void byte(long l2) {
        if (!this.b.for()) {
            return;
        }
        if (this.if(l2)) {
            return;
        }
        this.for();
        if (this.char == null) {
            return;
        }
        int n2 = Math.abs(this.char.m() - this.for.x);
        int n3 = Math.abs(this.char.o() - this.for.y);
        if (n2 > this.for.attackRange || n3 > this.for.attackRange) {
            h h2 = this.char;
            if (this.h.flyToTarget > 0) {
                int n4 = this.b.case().for(this.char.m(), this.char.o());
                if (n4 >= 0) {
                    int n5 = n4 & 0xFFFF;
                    int n6 = n4 >> 16;
                    this.b.a(n5, n6);
                }
                this.goto = l2 + (long)((int)(Math.random() * (double)this.for.getAttackTime()));
            } else {
                if (this.h.changeTragetOnAway > 0 && this.c > 1 && this.do != null && this.do != this.char) {
                    n2 = Math.abs(this.do.m() - this.for.x);
                    n3 = Math.abs(this.do.o() - this.for.y);
                    if (n2 <= this.for.attackRange && n3 <= this.for.attackRange) {
                        this.if(this.do, this.for.getAttackDelay());
                    }
                }
                if (h2 == this.char) {
                    if (this.h.tracingTargetOnAway > 0 && this.a(this.char.m(), this.char.o(), l2)) {
                        this.goto = l2 + (long)this.for.getStepTime() + (long)this.for.getMoveDelay();
                        ++this.new;
                    } else {
                        this.int();
                    }
                }
            }
        } else {
            this.b.case().a(this.b, this.char);
            this.goto = l2 + (long)this.for.getAttackTime() + (long)this.for.getAttackDelay();
            this.new = 0;
        }
    }

    private h case() {
        a a2 = this.void[0];
        int n2 = 1;
        while (n2 < this.a) {
            if (this.void[n2].do > a2.do) {
                a2 = this.void[n2];
            }
            ++n2;
        }
        return a2.int;
    }

    public void a(h h2, int n2, boolean bl) {
        this.a(h2, n2);
        if (this.h.enmityEnabled > 0) {
            Hero hero = h2.r();
            int n3 = 0;
            n3 = hero.race == 0 ? n2 * this.h.physicalDamageEnmityFactor * this.h.raceEnmityFactors[0] * (hero.level + 1) * this.h.remoteDamageEnmityFactor : n2 * this.h.physicalDamageEnmityFactor * this.h.raceEnmityFactors[hero.race] * (hero.level + 1) * this.h.nearDamageEnmityFactor;
            this.a(h2, n2, n3 + 1);
        }
    }

    public void a(h h2, int n2, DamageSpell damageSpell) {
        this.a(h2, n2);
        if (this.h.enmityEnabled > 0) {
            Hero hero = h2.r();
            int n3 = 0;
            n3 = damageSpell.damageType == 0 ? (damageSpell.releaseRange > 1 ? n2 * this.h.magicDamageEnmityFactor * damageSpell.enmityFactor * this.h.raceEnmityFactors[hero.race] * (hero.level + 1) * this.h.remoteDamageEnmityFactor : n2 * this.h.magicDamageEnmityFactor * damageSpell.enmityFactor * this.h.raceEnmityFactors[hero.race] * (hero.level + 1) * this.h.nearDamageEnmityFactor) : (damageSpell.releaseRange > 1 ? n2 * this.h.physicalDamageEnmityFactor * damageSpell.enmityFactor * this.h.raceEnmityFactors[hero.race] * (hero.level + 1) * this.h.remoteDamageEnmityFactor : n2 * this.h.physicalDamageEnmityFactor * damageSpell.enmityFactor * this.h.raceEnmityFactors[hero.race] * (hero.level + 1) * this.h.nearDamageEnmityFactor);
            this.a(h2, n2, n3 + 1);
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    public static class a {
        public h int;
        public int if;
        public int do;
        public int for;
        public long a;
    }
}

