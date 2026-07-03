/*
 * Decompiled with CFR 0.152.
 */
package app.island.data;

import app.island.GameObject;
import app.island.data.Spell;
import app.island.entity.Sprite;
import daff.a.e;

public class DamageSpell
extends Spell {
    public int damageType;
    public int minDamage;
    public int maxDamage;
    public int showTimes;
    public int strengthFactor;
    public int dexterityFactor;
    public int wisdomFactor;
    public int selfPhysicalDamageFactor;
    public int selfMagicDamageFactor;
    public int fightStateID;
    public int stateRate;
    public int enmityFactor;

    public void readFrom(e e2) {
        super.readFrom(e2);
        this.damageType = e2.for();
        this.minDamage = e2.j();
        this.maxDamage = e2.j();
        this.strengthFactor = e2.j();
        this.dexterityFactor = e2.j();
        this.wisdomFactor = e2.j();
        this.selfPhysicalDamageFactor = e2.j();
        this.selfMagicDamageFactor = e2.j();
    }

    public int getMaxDamage(Sprite sprite) {
        int n2 = this.maxDamage;
        if (this.strengthFactor > 0) {
            n2 += sprite.strength * this.strengthFactor / 100;
        }
        if (this.dexterityFactor > 0) {
            n2 += sprite.dexterity * this.dexterityFactor / 100;
        }
        if (this.wisdomFactor > 0) {
            n2 += sprite.wisdom * this.wisdomFactor / 100;
        }
        if (this.selfMagicDamageFactor > 0) {
            n2 += sprite.getMaxMagicDamage() * this.selfMagicDamageFactor / 100;
        }
        if (this.selfPhysicalDamageFactor > 0) {
            n2 += sprite.getMaxPhysicalDamage() * this.selfPhysicalDamageFactor / 100;
        }
        return n2;
    }

    public void writeTo(e e2) {
        super.writeTo(e2);
        e2.a(this.damageType);
        e2.for(this.minDamage);
        e2.for(this.maxDamage);
        e2.for(this.strengthFactor);
        e2.for(this.dexterityFactor);
        e2.for(this.wisdomFactor);
        e2.for(this.selfPhysicalDamageFactor);
        e2.for(this.selfMagicDamageFactor);
    }

    public DamageSpell() {
        this.spellType = 1;
    }

    public void copyFrom(GameObject gameObject) {
        super.copyFrom(gameObject);
        DamageSpell damageSpell = (DamageSpell)gameObject;
        this.damageType = damageSpell.damageType;
        this.minDamage = damageSpell.minDamage;
        this.maxDamage = damageSpell.maxDamage;
        this.showTimes = damageSpell.showTimes;
        this.strengthFactor = damageSpell.strengthFactor;
        this.dexterityFactor = damageSpell.dexterityFactor;
        this.wisdomFactor = damageSpell.wisdomFactor;
        this.selfPhysicalDamageFactor = damageSpell.selfPhysicalDamageFactor;
        this.selfMagicDamageFactor = damageSpell.selfMagicDamageFactor;
        this.fightStateID = damageSpell.fightStateID;
        this.stateRate = damageSpell.stateRate;
        this.enmityFactor = damageSpell.enmityFactor;
    }

    public int getMinDamage(Sprite sprite) {
        int n2 = this.minDamage;
        if (this.strengthFactor > 0) {
            n2 += sprite.strength * this.strengthFactor / 100;
        }
        if (this.dexterityFactor > 0) {
            n2 += sprite.dexterity * this.dexterityFactor / 100;
        }
        if (this.wisdomFactor > 0) {
            n2 += sprite.wisdom * this.wisdomFactor / 100;
        }
        if (this.selfMagicDamageFactor > 0) {
            n2 += sprite.getMinMagicDamage() * this.selfMagicDamageFactor / 100;
        }
        if (this.selfPhysicalDamageFactor > 0) {
            n2 += sprite.getMinPhysicalDamage() * this.selfPhysicalDamageFactor / 100;
        }
        return n2;
    }
}

