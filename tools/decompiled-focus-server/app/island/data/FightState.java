/*
 * Decompiled with CFR 0.152.
 */
package app.island.data;

import app.island.GameObject;
import app.island.entity.Sprite;
import daff.a.e;

public class FightState
extends GameObject {
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
    public int icon;
    public int tipIcon;
    public int level;
    public int movable;
    public int fightable;
    public int stepTimeRate;
    public int moveDelayRate;
    public int attackTimeRate;
    public int attackDelayRate;
    public int minPhysicalDamageRate;
    public int maxPhysicalDamageRate;
    public int physicalDefenseRate;
    public int minMagicDamageRate;
    public int maxMagicDamageRate;
    public int magicDefenseRate;
    public int hittingAbilityRate;
    public int evadingAbilityRate;
    public int raisedLifeRate;
    public int delayTime;
    public int frameTime;
    public int totalFrames;
    public int hpPerTime;
    public int mpPerTime;
    public transient long lastWorkTime;
    public transient int remainedTimes;
    public int enmityFactor;
    public String description;
    public transient Object userData;

    public void readFrom(e e2) {
        super.readFrom(e2);
        this.icon = e2.for();
        this.totalFrames = e2.case();
        this.frameTime = e2.case() * 100;
        this.stepTimeRate = e2.case() * 5;
        this.moveDelayRate = e2.case() * 5;
        this.attackTimeRate = e2.case() * 5;
        this.attackDelayRate = e2.case() * 5;
        this.minPhysicalDamageRate = e2.j();
        this.maxPhysicalDamageRate = e2.j();
        this.physicalDefenseRate = e2.j();
        this.minMagicDamageRate = e2.j();
        this.maxMagicDamageRate = e2.j();
        this.magicDefenseRate = e2.j();
        this.hittingAbilityRate = e2.j();
        this.evadingAbilityRate = e2.j();
        this.raisedLifeRate = e2.j();
        this.description = e2.h();
    }

    public void writeTo(e e2) {
        super.writeTo(e2);
        e2.a(this.icon);
        e2.a(this.totalFrames);
        e2.a(this.frameTime / 100);
        e2.a(this.stepTimeRate / 5);
        e2.a(this.moveDelayRate / 5);
        e2.a(this.attackTimeRate / 5);
        e2.a(this.attackDelayRate / 5);
        e2.for(this.minPhysicalDamageRate);
        e2.for(this.maxPhysicalDamageRate);
        e2.for(this.physicalDefenseRate);
        e2.for(this.minMagicDamageRate);
        e2.for(this.maxMagicDamageRate);
        e2.for(this.magicDefenseRate);
        e2.for(this.hittingAbilityRate);
        e2.for(this.evadingAbilityRate);
        e2.for(this.raisedLifeRate);
        e2.a(this.description);
    }

    public void removeFromSprite(Sprite sprite) {
        if (this.hpPerTime == 0) {
            sprite.changedStepTime -= this.changedStepTime;
            sprite.changedMoveDelay -= this.changedMoveDelay;
            sprite.changedAttackTime -= this.changedAttackTime;
            sprite.changedAttackDelay -= this.changedAttackDelay;
            sprite.changedMinPhysicalDamage -= this.changedMinPhysicalDamage;
            sprite.changedMaxPhysicalDamage -= this.changedMaxPhysicalDamage;
            sprite.changedPhysicalDefense -= this.changedPhysicalDefense;
            sprite.changedMinMagicDamage -= this.changedMinMagicDamage;
            sprite.changedMaxMagicDamage -= this.changedMaxMagicDamage;
            sprite.changedMagicDefense -= this.changedMagicDefense;
            sprite.changedHittingAbility -= this.changedHittingAbility;
            sprite.changedEvadingAbility -= this.changedEvadingAbility;
            sprite.maxLife -= this.changedMaxLife;
            sprite.changedMaxLife -= this.changedMaxLife;
            if (sprite.life > sprite.maxLife) {
                sprite.life = sprite.maxLife;
            }
            if (this.movable <= 0) {
                sprite.moveStops += -1;
            }
            if (this.fightable <= 0) {
                sprite.fightStops += -1;
            }
        }
    }

    public void copyFrom(GameObject gameObject) {
        super.copyFrom(gameObject);
        FightState fightState = (FightState)gameObject;
        this.icon = fightState.icon;
        this.tipIcon = fightState.tipIcon;
        this.level = fightState.level;
        this.movable = fightState.movable;
        this.fightable = fightState.fightable;
        this.stepTimeRate = fightState.stepTimeRate;
        this.moveDelayRate = fightState.moveDelayRate;
        this.attackTimeRate = fightState.attackTimeRate;
        this.attackDelayRate = fightState.attackDelayRate;
        this.minPhysicalDamageRate = fightState.minPhysicalDamageRate;
        this.maxPhysicalDamageRate = fightState.maxPhysicalDamageRate;
        this.physicalDefenseRate = fightState.physicalDefenseRate;
        this.minMagicDamageRate = fightState.minMagicDamageRate;
        this.maxMagicDamageRate = fightState.maxMagicDamageRate;
        this.magicDefenseRate = fightState.magicDefenseRate;
        this.hittingAbilityRate = fightState.hittingAbilityRate;
        this.evadingAbilityRate = fightState.evadingAbilityRate;
        this.raisedLifeRate = fightState.raisedLifeRate;
        this.delayTime = fightState.delayTime;
        this.frameTime = fightState.frameTime;
        this.totalFrames = fightState.totalFrames;
        this.hpPerTime = fightState.hpPerTime;
        this.mpPerTime = fightState.mpPerTime;
        this.enmityFactor = fightState.enmityFactor;
        this.description = fightState.description;
    }

    public void addToSprite(Sprite sprite) {
        if (this.hpPerTime == 0) {
            this.changedStepTime = this.stepTimeRate;
            this.changedMoveDelay = this.moveDelayRate;
            this.changedAttackTime = this.attackTimeRate;
            this.changedAttackDelay = this.attackDelayRate;
            this.changedMinPhysicalDamage = sprite.getBaseMinPhysicalDamage() * this.minPhysicalDamageRate / 100;
            this.changedMaxPhysicalDamage = sprite.getBaseMaxPhysicalDamage() * this.maxPhysicalDamageRate / 100;
            this.changedPhysicalDefense = sprite.physicalDefense * this.physicalDefenseRate / 100;
            this.changedMinMagicDamage = sprite.getBaseMinMagicDamage() * this.minMagicDamageRate / 100;
            this.changedMaxMagicDamage = sprite.getBaseMaxMagicDamage() * this.maxMagicDamageRate / 100;
            this.changedMagicDefense = sprite.magicDefense * this.magicDefenseRate / 100;
            this.changedHittingAbility = sprite.hittingAbility * this.hittingAbilityRate / 100;
            this.changedEvadingAbility = sprite.evadingAbility * this.evadingAbilityRate / 100;
            this.changedMaxLife = sprite.maxLife * this.raisedLifeRate / 100;
            sprite.changedStepTime += this.changedStepTime;
            sprite.changedMoveDelay += this.changedMoveDelay;
            sprite.changedAttackTime += this.changedAttackTime;
            sprite.changedAttackDelay += this.changedAttackDelay;
            sprite.changedMinPhysicalDamage += this.changedMinPhysicalDamage;
            sprite.changedMaxPhysicalDamage += this.changedMaxPhysicalDamage;
            sprite.changedPhysicalDefense += this.changedPhysicalDefense;
            sprite.changedMinMagicDamage += this.changedMinMagicDamage;
            sprite.changedMaxMagicDamage += this.changedMaxMagicDamage;
            sprite.changedMagicDefense += this.changedMagicDefense;
            sprite.changedHittingAbility += this.changedHittingAbility;
            sprite.changedEvadingAbility += this.changedEvadingAbility;
            sprite.changedMaxLife += this.changedMaxLife;
            sprite.maxLife += this.changedMaxLife;
            if (sprite.life > sprite.maxLife) {
                sprite.life = sprite.maxLife;
            }
            if (this.movable <= 0) {
                ++sprite.moveStops;
            }
            if (this.fightable <= 0) {
                ++sprite.fightStops;
            }
        }
    }
}

