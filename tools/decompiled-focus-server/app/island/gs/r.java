/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs;

import app.b.b;
import app.island.GameObject;
import app.island.data.DamageSpell;
import app.island.data.SceneEffectSpell;
import app.island.data.Spell;
import app.island.data.TargetStateSpell;
import app.island.data.Weapon;
import app.island.entity.EffectObject;
import app.island.entity.Hero;
import app.island.entity.Monster;
import app.island.entity.SceneObject;
import app.island.entity.Sign;
import app.island.gs.ServerInfo;
import app.island.gs.h;
import app.island.gs.n;
import app.island.gs.p;
import app.island.gs.u;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class r {
    public static final int a = 1;
    public static final int for = 2;
    public static final int try = 1;
    public static final int do = 2;
    public static final int if = 3;
    public static final int new = 4;
    protected u int;

    private void a(h h2, DamageSpell damageSpell, n n2, int n3) {
        Hero hero = h2.r();
        n2.i();
        n2.try();
        int n4 = damageSpell.getMinDamage(hero);
        int n5 = damageSpell.getMaxDamage(hero);
        int n6 = n4 + (int)(Math.random() * (double)(n5 - n4));
        if (hero.race == 1) {
            n6 += n6 / 10;
        }
        Monster monster = n2.g();
        n6 = damageSpell.damageType == 0 ? (n6 -= monster.getMagicDefense()) : (n6 -= monster.getPhysicalDefense());
        if (n6 <= 0) {
            n6 = 1;
        }
        if (n6 > monster.life) {
            n6 = monster.life;
        }
        monster.life -= n6;
        if (monster.life < 0) {
            monster.life = 0;
        }
        int n7 = 0;
        if (damageSpell.flyerType > 0) {
            n7 = SceneObject.getFlyTime(hero.x, hero.y, monster.x, monster.y);
        }
        if (damageSpell.showTimes > 1) {
            int n8 = 0;
            int n9 = n6 / damageSpell.showTimes;
            int n10 = hero.getAttackTime() + n7;
            int n11 = 0;
            while (n11 < damageSpell.showTimes) {
                int n12 = n9;
                if (n11 == damageSpell.showTimes - 1) {
                    n12 = n6 - n8;
                } else if (n12 > 2) {
                    n12 += 2 - (int)(Math.random() * 5.0);
                }
                n8 += n12;
                if (damageSpell.damageType == 0) {
                    this.int.a(p.a(monster, 0, n12, n10), monster.x, monster.y, null);
                } else {
                    this.int.a(p.a(monster, n12, 0, n10), monster.x, monster.y, null);
                }
                n10 += 150;
                ++n11;
            }
        } else if (damageSpell.damageType == 0) {
            this.int.a(p.a(monster, 0, n6, hero.getAttackTime() + n7), monster.x, monster.y, null);
        } else {
            this.int.a(p.a(monster, n6, 0, hero.getAttackTime() + n7), monster.x, monster.y, null);
        }
        n2.a(h2, n6, damageSpell);
        if (monster.life <= 0) {
            this.int.E().a(h2, n2);
            n2.int(h2);
            h2.a(n2);
        } else if (damageSpell.fightStateID > 0 && damageSpell.stateRate > 0 && Math.random() * 100.0 < (double)damageSpell.stateRate) {
            n2.a(damageSpell.fightStateID, h2);
        }
    }

    private int if(int n2, Hero hero) {
        n2 = hero.race == 2 ? (n2 -= (int)((float)n2 * (100.0f - (float)hero.level * 0.17f) / 100.0f * (float)hero.personalDepot.getMagicDefense(hero) / 1500.0f)) : (n2 -= (int)((float)n2 * (100.0f - (float)hero.level * 0.17f) / 100.0f * (float)hero.personalDepot.getMagicDefense(hero) / 1725.0f));
        if ((n2 -= hero.getMagicDefense()) > hero.life) {
            n2 = hero.life;
        }
        if (n2 < 1) {
            n2 = 1;
        }
        return n2;
    }

    public void a(n n2, int n3, int n4, DamageSpell damageSpell) {
        int n5;
        int n6 = Math.max(n3 - damageSpell.xExtHurtRange, 0);
        int n7 = Math.min(n3 + damageSpell.xExtHurtRange, this.int.x() - 1);
        int n8 = Math.max(n4 - damageSpell.yExtHurtRange, 0);
        int n9 = Math.min(n4 + damageSpell.yExtHurtRange, this.int.M() - 1);
        if (damageSpell.extHurtRangeFilled > 0) {
            n5 = n8;
            while (n5 <= n9) {
                int n10 = n6;
                while (n10 <= n7) {
                    h h2 = this.int.do(n10, n5);
                    if (h2 != null) {
                        this.a(n2, damageSpell, h2);
                    }
                    ++n10;
                }
                ++n5;
            }
        } else {
            h h3;
            n5 = n6;
            while (n5 <= n7) {
                h3 = this.int.do(n5, n4);
                if (h3 != null) {
                    this.a(n2, damageSpell, h3);
                }
                ++n5;
            }
            n5 = n8;
            while (n5 <= n9) {
                if (n5 != n4 && (h3 = this.int.do(n3, n5)) != null) {
                    this.a(n2, damageSpell, h3);
                }
                ++n5;
            }
        }
        Monster monster = n2.g();
        this.int.a(p.if(monster.id, n3, n4, monster.getAttackTime(), damageSpell.flyerType), monster.x, monster.y, null);
        if (damageSpell.animation > 0) {
            b b2 = null;
            int n11 = 0;
            if (damageSpell.flyerType > 0) {
                n11 = SceneObject.getFlyTime(monster.x, monster.y, n3, n4);
            }
            b2 = damageSpell.xExtHurtRange == 0 && damageSpell.yExtHurtRange == 0 ? p.do(n3, n4, damageSpell.animation, monster.getAttackTime() + n11, damageSpell.timeLast) : p.a(n3, n4, n6, n7, n8, n9, damageSpell.extHurtRangeFilled > 0, damageSpell.animation, monster.getAttackTime() + n11, damageSpell.timeLast);
            this.int.a(b2, n3, n4, null);
        }
    }

    public void a(h h2, Spell spell, h h3) {
        Hero hero = h2.r();
        if (spell.spellType == 1) {
            this.a(h2, (DamageSpell)spell, h3, 100);
        } else if (spell.spellType == 2) {
            this.a(h2, (TargetStateSpell)spell, h3);
        }
        this.int.a(p.a(hero.id, h3.m(), h3.o(), hero.getAttackTime(), spell.flyerType), hero.x, hero.y, null);
        if (spell.animation > 0) {
            int n2 = 0;
            if (spell.flyerType > 0) {
                n2 = SceneObject.getFlyTime(hero.x, hero.y, h3.m(), h3.o());
            }
            b b2 = p.do(h3.m(), h3.o(), spell.animation, hero.getAttackTime() + n2, spell.timeLast);
            this.int.a(b2, h3.m(), h3.o(), null);
        }
    }

    private void a(h h2, TargetStateSpell targetStateSpell, h h3) {
        h2.r();
        int n2 = 0;
        if (targetStateSpell.successRate >= 100 || Math.random() * 100.0 < (double)targetStateSpell.successRate) {
            n2 = targetStateSpell.stateID;
        }
        if (n2 > 0) {
            h3.a(n2, h2);
        }
    }

    public void a(h h2, EffectObject effectObject) {
        h h3 = (h)effectObject.userData;
        Hero hero = h2.r();
        if (this.int.K() != 1 && h2.z() == 0 && h3.r().pkValue <= 1) {
            h3.void(ServerInfo.pkStateTimeLast / 100);
        }
        int n2 = effectObject.hpPerTime;
        n2 = this.if(n2, hero);
        hero.life -= n2;
        if (hero.life < 0) {
            hero.life = 0;
        }
        this.int.a(p.a(hero, 0, n2, hero.getStepTime()), hero.x, hero.y, null);
        if (hero.life <= 0 && h3 != null) {
            this.int.E().a(h3, h2);
            h3.do(h2);
            h2.if(h3);
        } else {
            h2.a(h3);
        }
    }

    public int a(h h2, n n2) {
        Hero hero = h2.r();
        Monster monster = n2.g();
        int n3 = hero.getHittingAbility() - monster.getEvadingAbility() + 80;
        if (n3 < 0) {
            return 2;
        }
        if (n3 < 100 && Math.random() * 100.0 > (double)n3) {
            return 2;
        }
        int n4 = 0;
        int n5 = hero.getMinPhysicalDamage();
        int n6 = hero.getMaxPhysicalDamage();
        int n7 = n5;
        n7 = n6 > n5 ? (n7 += (int)(Math.random() * (double)(n6 - n5))) : n6;
        int n8 = hero.personalDepot.getDoubleDamageRate();
        if (n8 > 0 && Math.random() * 100.0 < (double)n8) {
            n7 *= 2;
            n4 = 4;
        }
        if ((n7 -= monster.getPhysicalDefense()) < 1) {
            n7 = 1;
        } else if (n7 > monster.life) {
            n7 = monster.life;
        }
        int n9 = n7;
        if (n9 > monster.life) {
            n9 = monster.life;
        }
        monster.life -= n9;
        if (monster.life < 0) {
            monster.life = 0;
        }
        int n10 = hero.getAttackTime();
        if (hero.race == 0) {
            n10 += SceneObject.getFlyTime(hero.x, hero.y, monster.x, monster.y);
        }
        this.int.a(p.a(monster, n7, 0, n10), monster.x, monster.y, h2);
        h2.a(p.a(monster, n7, 0, 0));
        Weapon weapon = hero.personalDepot.weapon;
        if (monster.life > 0 && weapon != null && weapon.attachedFightState > 0 && Math.random() * 100.0 < (double)weapon.fightStateRate) {
            n2.a(weapon.attachedFightState, h2);
        }
        n2.a(h2, n9, n4 == 4);
        if (monster.life <= 0) {
            this.int.E().a(h2, n2);
            n2.int(h2);
            h2.a(n2);
        }
        return n4;
    }

    public int a(h h2, h h3) {
        Hero hero = h2.r();
        Hero hero2 = h3.r();
        if (this.int.K() != 1 && h3.z() == 0 && hero.pkValue <= 1) {
            h2.void(ServerInfo.pkStateTimeLast / 100);
        }
        int n2 = 0;
        n2 = h3.if() ? 30 + (hero.getHittingAbility() - hero2.getEvadingAbility()) * 100 / hero.getHittingAbility() : hero.getHittingAbility() - hero2.getEvadingAbility() + 80;
        if (n2 < 8) {
            n2 = 8;
        }
        if (n2 < 100 && Math.random() * 100.0 > (double)n2) {
            return 2;
        }
        int n3 = hero2.personalDepot.getWithstandingRate();
        if (n3 > 0 && Math.random() * 100.0 < (double)n3) {
            return 3;
        }
        int n4 = 0;
        int n5 = hero.getMinPhysicalDamage();
        int n6 = hero.getMaxPhysicalDamage();
        int n7 = n5;
        n7 = n6 > n5 ? (n7 += (int)(Math.random() * (double)(n6 - n5))) : n6;
        int n8 = hero.personalDepot.getDoubleDamageRate();
        if (n8 > 0 && Math.random() * 100.0 < (double)n8) {
            n7 *= 2;
            n4 = 4;
        }
        n7 = this.a(n7, hero2);
        hero2.life -= n7;
        int n9 = hero.getAttackTime();
        if (hero.race == 0) {
            n9 += SceneObject.getFlyTime(hero.x, hero.y, hero2.x, hero2.y);
        }
        this.int.a(p.a(hero2, n7, 0, n9), hero2.x, hero2.y, h2);
        h2.a(p.a(hero2, n7, 0, 0));
        Weapon weapon = hero.personalDepot.weapon;
        if (hero2.life > 0 && weapon != null && weapon.attachedFightState > 0 && Math.random() * 100.0 < (double)weapon.fightStateRate) {
            h3.a(weapon.attachedFightState, h2);
        }
        if (hero2.life <= 0) {
            this.int.E().a(h2, h3);
            h2.do(h3);
            h3.if(h2);
        } else {
            h3.a(h2);
        }
        return n4;
    }

    public int a(h h2, Sign sign) {
        Hero hero = h2.r();
        int n2 = hero.getMinPhysicalDamage();
        int n3 = hero.getMaxPhysicalDamage();
        int n4 = n2;
        n4 = n3 > n2 ? (n4 += (int)(Math.random() * (double)(n3 - n2))) : n3;
        int n5 = hero.personalDepot.getDoubleDamageRate();
        if (n5 > 0 && Math.random() * 100.0 < (double)n5) {
            n4 *= 2;
        }
        if ((n4 /= 10) < 1) {
            n4 = 1;
        } else if (n4 > sign.life) {
            n4 = sign.life;
        }
        if (n4 > sign.life) {
            n4 = sign.life;
        }
        return n4;
    }

    public int a(n n2, h h2) {
        int n3;
        Monster monster = n2.g();
        Hero hero = h2.r();
        int n4 = monster.getHittingAbility() - hero.getEvadingAbility() + 80;
        if (n4 < 8) {
            n4 = 8;
        }
        if (n4 < 100 && Math.random() * 100.0 > (double)n4) {
            return 2;
        }
        int n5 = hero.personalDepot.getWithstandingRate();
        if (n5 > 0 && Math.random() * 100.0 < (double)n5) {
            return 3;
        }
        int n6 = (int)(Math.random() * (double)(monster.getMaxPhysicalDamage() - monster.getMinPhysicalDamage()) + (double)monster.getMinPhysicalDamage());
        if (n6 > 0) {
            n6 = this.a(n6, hero);
        }
        if ((n3 = (int)(Math.random() * (double)(monster.maxMagicDamage - monster.minMagicDamage) + (double)monster.minMagicDamage)) > 0) {
            n3 = this.if(n3, hero);
        }
        int n7 = n6 + n3;
        hero.life -= n7;
        if (hero.life < 0) {
            hero.life = 0;
        }
        int n8 = monster.getAttackTime();
        if (monster.attackRange > 1) {
            n8 += SceneObject.getFlyTime(monster.x, monster.y, hero.x, hero.y);
        }
        this.int.a(p.a(hero, n6, n3, n8), hero.x, hero.y, null);
        if (hero.life <= 0) {
            h2.if(n2);
            n2.for(h2);
            this.int.E().a(n2, h2);
        } else {
            h2.do(n2);
        }
        return 0;
    }

    public void a(h h2, Spell spell, n n2) {
        Hero hero = h2.r();
        if (spell.spellType == 1) {
            this.a(h2, (DamageSpell)spell, n2, 100);
        } else if (spell.spellType == 2) {
            this.a(h2, (TargetStateSpell)spell, n2);
        }
        this.int.a(p.a(hero.id, n2.i(), n2.try(), hero.getAttackTime(), spell.flyerType), hero.x, hero.y, null);
        if (spell.animation > 0) {
            int n3 = 0;
            if (spell.flyerType > 0) {
                n3 = SceneObject.getFlyTime(hero.x, hero.y, n2.i(), n2.try());
            }
            b b2 = p.do(n2.i(), n2.try(), spell.animation, hero.getAttackTime() + n3, spell.timeLast);
            this.int.a(b2, n2.i(), n2.try(), null);
        }
    }

    private void a(h h2, TargetStateSpell targetStateSpell, n n2) {
        h2.r();
        int n3 = 0;
        if (targetStateSpell.successRate >= 100 || Math.random() * 100.0 < (double)targetStateSpell.successRate) {
            n3 = targetStateSpell.stateID;
        }
        if (n3 > 0) {
            n2.a(n3, h2);
        }
    }

    public void a(n n2, EffectObject effectObject) {
        h h2 = (h)effectObject.userData;
        Monster monster = n2.g();
        int n3 = effectObject.hpPerTime;
        int n4 = monster.getMagicDefense();
        if ((n3 -= n4) < 1) {
            n3 = 1;
        }
        if (n3 > monster.life) {
            n3 = monster.life;
        }
        monster.life -= n3;
        if (monster.life < 0) {
            monster.life = 0;
        }
        n2.a(h2, n3, effectObject);
        this.int.a(p.a(monster, 0, n3, monster.getStepTime()), monster.x, monster.y, null);
        if (monster.life <= 0) {
            this.int.E().a(h2, n2);
            n2.int(h2);
            h2.a(n2);
        }
    }

    public u a() {
        return this.int;
    }

    public void a(u u2) {
        this.int = u2;
    }

    public void a(h h2, Spell spell, int n2, int n3) {
        int n4;
        Object object;
        Hero hero = h2.r();
        int n5 = Math.max(n2 - spell.xExtHurtRange, 0);
        int n6 = Math.min(n2 + spell.xExtHurtRange, this.int.x() - 1);
        int n7 = Math.max(n3 - spell.yExtHurtRange, 0);
        int n8 = Math.min(n3 + spell.yExtHurtRange, this.int.M() - 1);
        if (spell.spellType == 1) {
            object = (DamageSpell)spell;
            if (spell.extHurtRangeFilled > 0) {
                n4 = n7;
                while (n4 <= n8) {
                    int n9 = n5;
                    while (n9 <= n6) {
                        int n10 = 100;
                        if (n4 != n3 || n9 != n2) {
                            n10 = 70;
                        }
                        n n11 = this.int.int(n9, n4);
                        h h3 = this.int.do(n9, n4);
                        if (n11 != null && this.int.if(h2, n11)) {
                            this.a(h2, (DamageSpell)object, n11, n10);
                        } else if (h3 != null && this.int.do(h2, h3)) {
                            this.a(h2, (DamageSpell)object, h3, n10);
                        }
                        ++n9;
                    }
                    ++n4;
                }
            } else {
                h h4;
                n n12;
                int n13;
                n4 = n5;
                while (n4 <= n6) {
                    n13 = 100;
                    if (n4 != n2) {
                        n13 = 70;
                    }
                    n12 = this.int.int(n4, n3);
                    h4 = this.int.do(n4, n3);
                    if (n12 != null && this.int.if(h2, n12)) {
                        this.a(h2, (DamageSpell)object, n12, n13);
                    } else if (h4 != null && this.int.do(h2, h4)) {
                        this.a(h2, (DamageSpell)object, h4, n13);
                    }
                    ++n4;
                }
                n4 = n7;
                while (n4 <= n8) {
                    n13 = 100;
                    if (n4 != n3) {
                        n13 = 70;
                        n12 = this.int.int(n2, n4);
                        h4 = this.int.do(n2, n4);
                        if (n12 != null && this.int.if(h2, n12)) {
                            this.a(h2, (DamageSpell)object, n12, n13);
                        } else if (h4 != null && this.int.do(h2, h4)) {
                            this.a(h2, (DamageSpell)object, h4, n13);
                        }
                    }
                    ++n4;
                }
            }
        } else if (spell.spellType == 3) {
            object = (SceneEffectSpell)spell;
            if (spell.extHurtRangeFilled > 0) {
                n4 = n7;
                while (n4 <= n8) {
                    int n14 = n5;
                    while (n14 <= n6) {
                        EffectObject effectObject = new EffectObject();
                        effectObject.id = ((GameObject)object).id / 100;
                        effectObject.animation = ((SceneEffectSpell)object).effectAnimation;
                        effectObject.lifeTime = effectObject.maxLifeTime = ((SceneEffectSpell)object).effectLifeTime;
                        effectObject.delayTime = ((SceneEffectSpell)object).effectDelayTime;
                        effectObject.hpPerTime = ((SceneEffectSpell)object).lifeChanged + ((SceneEffectSpell)object).wisdomFactor * hero.wisdom / 100;
                        effectObject.enmityFactor = ((SceneEffectSpell)object).enmityFactor;
                        this.int.a(effectObject, h2, n14, n4);
                        ++n14;
                    }
                    ++n4;
                }
            } else {
                EffectObject effectObject;
                n4 = n5;
                while (n4 <= n6) {
                    effectObject = new EffectObject();
                    effectObject.id = ((GameObject)object).id / 100;
                    effectObject.animation = ((SceneEffectSpell)object).effectAnimation;
                    effectObject.lifeTime = effectObject.maxLifeTime = ((SceneEffectSpell)object).effectLifeTime;
                    effectObject.delayTime = ((SceneEffectSpell)object).effectDelayTime;
                    effectObject.hpPerTime = ((SceneEffectSpell)object).lifeChanged + ((SceneEffectSpell)object).wisdomFactor * hero.wisdom / 100;
                    effectObject.enmityFactor = ((SceneEffectSpell)object).enmityFactor;
                    this.int.a(effectObject, h2, n4, n3);
                    ++n4;
                }
                n4 = n7;
                while (n4 <= n8) {
                    if (n4 != n3) {
                        effectObject = new EffectObject();
                        effectObject.id = ((GameObject)object).id / 100;
                        effectObject.animation = ((SceneEffectSpell)object).effectAnimation;
                        effectObject.lifeTime = effectObject.maxLifeTime = ((SceneEffectSpell)object).effectLifeTime;
                        effectObject.delayTime = ((SceneEffectSpell)object).effectDelayTime;
                        effectObject.hpPerTime = ((SceneEffectSpell)object).lifeChanged + ((SceneEffectSpell)object).wisdomFactor * hero.wisdom / 100;
                        effectObject.enmityFactor = ((SceneEffectSpell)object).enmityFactor;
                        this.int.a(effectObject, h2, n2, n4);
                    }
                    ++n4;
                }
            }
        } else if (spell.spellType == 2) {
            object = (TargetStateSpell)spell;
            if (spell.extHurtRangeFilled > 0) {
                n4 = n7;
                while (n4 <= n8) {
                    int n15 = n5;
                    while (n15 <= n6) {
                        n n16 = this.int.int(n15, n4);
                        h h5 = this.int.do(n15, n4);
                        if (n16 != null && this.int.if(h2, n16)) {
                            this.a(h2, (TargetStateSpell)object, n16);
                        } else if (h5 != null && !h5.i()) {
                            this.a(h2, (TargetStateSpell)object, h5);
                        } else if (((TargetStateSpell)object).stateID == 0) {
                            this.a(h2, (TargetStateSpell)object, h2);
                        }
                        ++n15;
                    }
                    ++n4;
                }
            } else {
                h h6;
                n n17;
                n4 = n5;
                while (n4 <= n6) {
                    n17 = this.int.int(n4, n3);
                    h6 = this.int.do(n4, n3);
                    if (n17 != null && this.int.if(h2, n17)) {
                        this.a(h2, (TargetStateSpell)object, n17);
                    } else if (h6 != null && !h6.i()) {
                        this.a(h2, (TargetStateSpell)object, h6);
                    } else if (((TargetStateSpell)object).stateID == 0) {
                        this.a(h2, (TargetStateSpell)object, h2);
                    }
                    ++n4;
                }
                n4 = n7;
                while (n4 <= n8) {
                    if (n4 != n3) {
                        n17 = this.int.int(n2, n4);
                        h6 = this.int.do(n2, n4);
                        if (n17 != null && this.int.if(h2, n17)) {
                            this.a(h2, (TargetStateSpell)object, n17);
                        } else if (h6 != null && !h6.i()) {
                            this.a(h2, (TargetStateSpell)object, h6);
                        } else if (((TargetStateSpell)object).stateID == 0) {
                            this.a(h2, (TargetStateSpell)object, h2);
                        }
                    }
                    ++n4;
                }
            }
        }
        this.int.a(p.a(hero.id, n2, n3, hero.getAttackTime(), spell.flyerType), hero.x, hero.y, null);
        if (spell.animation > 0) {
            object = null;
            n4 = 0;
            if (spell.flyerType > 0) {
                n4 = SceneObject.getFlyTime(hero.x, hero.y, n2, n3);
            }
            object = spell.xExtHurtRange == 0 && spell.yExtHurtRange == 0 ? p.do(n2, n3, spell.animation, hero.getAttackTime() + n4, spell.timeLast) : p.a(n2, n3, n5, n6, n7, n8, spell.extHurtRangeFilled > 0, spell.animation, hero.getAttackTime() + n4, spell.timeLast);
            this.int.a((b)object, n2, n3, null);
        }
    }

    public void a(n n2, DamageSpell damageSpell, h h2) {
        Monster monster = n2.g();
        Hero hero = h2.r();
        int n3 = damageSpell.getMinDamage(monster);
        int n4 = damageSpell.getMaxDamage(monster);
        int n5 = n3 + (int)(Math.random() * (double)(n4 - n3));
        n5 = damageSpell.damageType == 0 ? this.if(n5, hero) : this.a(n5, hero);
        if (n5 > hero.life) {
            n5 = hero.life;
        }
        hero.life -= n5;
        if (hero.life < 0) {
            hero.life = 0;
        }
        int n6 = 0;
        if (damageSpell.flyerType > 0) {
            n6 = SceneObject.getFlyTime(monster.x, monster.y, hero.x, hero.y);
        }
        if (damageSpell.damageType == 0) {
            this.int.a(p.a(hero, 0, n5, monster.getAttackTime() + n6), hero.x, hero.y, null);
        } else {
            this.int.a(p.a(hero, n5, 0, monster.getAttackTime() + n6), hero.x, hero.y, null);
        }
        if (hero.life <= 0) {
            n2.for(h2);
            h2.if(n2);
            this.int.E().a(n2, h2);
        } else {
            h2.do(n2);
            if (damageSpell.fightStateID > 0 && damageSpell.stateRate > 0 && Math.random() * 100.0 < (double)damageSpell.stateRate) {
                h2.a(damageSpell.fightStateID, n2);
            }
        }
    }

    private void a(h h2, DamageSpell damageSpell, h h3, int n2) {
        Hero hero = h2.r();
        Hero hero2 = h3.r();
        if (this.int.K() != 1 && h3.z() == 0 && hero.pkValue <= 1) {
            h2.void(ServerInfo.pkStateTimeLast / 100);
        }
        int n3 = damageSpell.getMinDamage(hero);
        int n4 = damageSpell.getMaxDamage(hero);
        int n5 = n3 + (int)(Math.random() * (double)(n4 - n3));
        if (hero.race == 1) {
            n5 += n5 / 10;
        }
        n5 = n5 * n2 / 100;
        n5 = damageSpell.damageType == 0 ? this.if(n5, hero2) : this.a(n5, hero2);
        hero2.life -= n5;
        if (hero2.life < 0) {
            hero2.life = 0;
        }
        int n6 = 0;
        if (damageSpell.flyerType > 0) {
            n6 = SceneObject.getFlyTime(hero.x, hero.y, hero2.x, hero2.y);
        }
        if (damageSpell.showTimes > 1) {
            int n7 = 0;
            int n8 = n5 / damageSpell.showTimes;
            int n9 = hero.getAttackTime() + n6;
            int n10 = 0;
            while (n10 < damageSpell.showTimes) {
                int n11 = n8;
                if (n10 == damageSpell.showTimes - 1) {
                    n11 = n5 - n7;
                } else if (n11 > 2) {
                    n11 += 2 - (int)(Math.random() * 5.0);
                }
                n7 += n11;
                if (damageSpell.damageType == 0) {
                    this.int.a(p.a(hero2, 0, n11, n9), hero2.x, hero2.y, null);
                } else {
                    this.int.a(p.a(hero2, n11, 0, n9), hero2.x, hero2.y, null);
                }
                n9 += 150;
                ++n10;
            }
        } else if (damageSpell.damageType == 0) {
            this.int.a(p.a(hero2, 0, n5, hero.getAttackTime() + n6), hero2.x, hero2.y, null);
        } else {
            this.int.a(p.a(hero2, n5, 0, hero.getAttackTime() + n6), hero2.x, hero2.y, null);
        }
        if (hero2.life <= 0) {
            this.int.E().a(h2, h3);
            h2.do(h3);
            h3.if(h2);
        } else {
            h3.a(h2);
            if (damageSpell.fightStateID > 0 && damageSpell.stateRate > 0 && Math.random() * 100.0 < (double)damageSpell.stateRate) {
                h3.a(damageSpell.fightStateID, h2);
            }
        }
    }

    private int a(int n2, Hero hero) {
        n2 = hero.race == 2 ? (n2 -= (int)((float)n2 * (100.0f - (float)hero.level * 0.17f) / 100.0f * (float)hero.personalDepot.getPhysicalDefense(hero) / 2300.0f)) : (n2 -= (int)((float)n2 * (100.0f - (float)hero.level * 0.17f) / 100.0f * (float)hero.personalDepot.getPhysicalDefense(hero) / 2000.0f));
        if ((n2 -= hero.getPhysicalDefense()) > hero.life) {
            n2 = hero.life;
        }
        if (n2 < 1) {
            n2 = 1;
        }
        return n2;
    }
}

