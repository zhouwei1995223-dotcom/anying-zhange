/*
 * Decompiled with CFR 0.152.
 */
package app.island.entity;

import app.island.GameObject;
import app.island.entity.SceneObject;
import daff.a.e;

public abstract class Sprite
extends SceneObject {
    public static final int ACTION_IDLING = 0;
    public static final int ACTION_WALKING = 1;
    public static final int ACTION_ATTACKING = 2;
    public static final int ACTION_SITTING = 3;
    public static final int ACTION_DYING = 4;
    public transient int action;
    public transient int direction;
    public int life = 1;
    public transient int maxLife = 100;
    public int mana;
    public transient int maxMana;
    public int level;
    public transient int color;
    public transient int stepTime = 600;
    public transient int moveDelay = 0;
    public transient int attackTime = 800;
    public transient int attackDelay = 400;
    public transient int attackRange = 1;
    public transient int minPhysicalDamage = 1;
    public transient int maxPhysicalDamage = 10;
    public transient int physicalDefense;
    public transient int minMagicDamage;
    public transient int maxMagicDamage;
    public transient int magicDefense;
    public transient int hittingAbility;
    public transient int evadingAbility;
    public transient int changedStepTime;
    public transient int changedMoveDelay;
    public transient int changedAttackTime;
    public transient int changedAttackDelay;
    public transient int changedMinPhysicalDamage;
    public transient int changedMaxPhysicalDamage;
    public transient int changedPhysicalDefense;
    public transient int changedMinMagicDamage;
    public transient int changedMaxMagicDamage;
    public transient int changedMagicDefense;
    public transient int changedHittingAbility;
    public transient int changedEvadingAbility;
    public transient int changedMaxLife;
    public transient int moveStops;
    public transient int fightStops;
    public int strength;
    public int dexterity;
    public int wisdom;

    public void readFrom(e e2) {
        super.readFrom(e2);
        this.direction = e2.case();
        this.level = e2.for();
        this.life = e2.i();
        this.maxLife = e2.i();
    }

    public int getBaseMaxMagicDamage() {
        return this.wisdom * 2 + (this.wisdom * this.wisdom / 400 + this.level / 12) * 3;
    }

    public int getMaxMagicDamage() {
        return this.maxMagicDamage + this.changedMaxMagicDamage;
    }

    public int getEvadingAbility() {
        return this.evadingAbility + this.changedEvadingAbility;
    }

    public void writeTo(e e2) {
        super.writeTo(e2);
        e2.a(this.direction);
        e2.a(this.level);
        e2.char(this.life);
        e2.char(this.maxLife);
    }

    public int getStepTime() {
        int n2 = this.stepTime + this.changedStepTime;
        return Math.max(n2, 300);
    }

    public int getMoveDelay() {
        return this.moveDelay + this.changedMoveDelay;
    }

    public void copyFrom(GameObject gameObject) {
        super.copyFrom(gameObject);
        Sprite sprite = (Sprite)gameObject;
        this.direction = sprite.direction;
        this.life = sprite.life;
        this.maxLife = sprite.maxLife;
        this.mana = sprite.mana;
        this.maxMana = sprite.maxMana;
        this.color = sprite.color;
        this.level = sprite.level;
        this.stepTime = sprite.stepTime;
        this.moveDelay = sprite.moveDelay;
        this.attackTime = sprite.attackTime;
        this.attackDelay = sprite.attackDelay;
        this.attackRange = sprite.attackRange;
        this.minPhysicalDamage = sprite.minPhysicalDamage;
        this.maxPhysicalDamage = sprite.maxPhysicalDamage;
        this.physicalDefense = sprite.physicalDefense;
        this.minMagicDamage = sprite.minMagicDamage;
        this.maxMagicDamage = sprite.maxMagicDamage;
        this.magicDefense = sprite.magicDefense;
        this.hittingAbility = sprite.hittingAbility;
        this.evadingAbility = sprite.evadingAbility;
        this.strength = sprite.strength;
        this.dexterity = sprite.dexterity;
        this.wisdom = sprite.wisdom;
    }

    public int getBaseMinPhysicalDamage() {
        return this.strength + this.dexterity * 3 / 2 + (this.dexterity * this.dexterity / 1600 + this.level / 12) * 3;
    }

    public int getMinPhysicalDamage() {
        return this.minPhysicalDamage + this.changedMinPhysicalDamage;
    }

    public int getPhysicalDefense() {
        return this.physicalDefense + this.changedPhysicalDefense;
    }

    public int getAttackDelay() {
        return Math.max(this.attackDelay + this.changedAttackDelay, 0);
    }

    public int getBaseMaxPhysicalDamage() {
        return this.strength * 3 + this.dexterity + (this.strength * this.strength / 400 + this.level / 12) * 3;
    }

    public int getMaxPhysicalDamage() {
        return this.maxPhysicalDamage + this.changedMaxPhysicalDamage;
    }

    public int getBaseMinMagicDamage() {
        return this.wisdom * 3 / 2 + (this.dexterity * this.dexterity / 2500 + this.level / 12) * 3;
    }

    public int getMinMagicDamage() {
        return this.minMagicDamage + this.changedMinMagicDamage;
    }

    public int getMagicDefense() {
        return this.magicDefense + this.changedMagicDefense;
    }

    public int getHittingAbility() {
        return this.hittingAbility + this.changedHittingAbility;
    }

    public int getAttackTime() {
        return Math.max(this.attackTime + this.changedAttackTime, 500);
    }

    public static class Action {
        public int type;
        public int x;
        public int y;
        public int dx;
        public int dy;
        public int dir;
        public int duration;
        public long beginTime;
        public Action next;

        public Action() {
            this.type = 0;
        }

        public Action(int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
            this.type = n2;
            this.x = n3;
            this.y = n4;
            this.dx = n5;
            this.dy = n6;
            this.dir = n7;
            this.duration = n8;
        }
    }
}

