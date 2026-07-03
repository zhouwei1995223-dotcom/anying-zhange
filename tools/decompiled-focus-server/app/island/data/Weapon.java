/*
 * Decompiled with CFR 0.152.
 */
package app.island.data;

import app.island.GameObject;
import app.island.data.Goods;
import daff.a.e;

public class Weapon
extends Goods {
    public int minPhysicalDamage;
    public int maxPhysicalDamage;
    public int extraMinPhysicalDamage;
    public int extraMaxPhysicalDamage;
    public int minMagicDamage;
    public int maxMagicDamage;
    public int extraMinMagicDamage;
    public int extraMaxMagicDamage;
    public int pdLevelFactor = 1;
    public int pdStrengthFactor = 1;
    public int pdDexterityFactor = 1;
    public int pdWisdomFactor = 1;
    public int mdLevelFactor;
    public int mdStrengthFactor;
    public int mdDexterityFactor;
    public int mdWisdomFactor;
    public int hittingAbility;
    public int attackRange;
    public int attackTime;
    public int attackDelay;
    public int doubleDamageRate = 20;
    public int attachedFightState;
    public int fightStateRate;
    public int requiredRace;
    public int requiredLevel;
    public int requiredTurn;
    public int increaseCost;
    public int refineCost;
    public int refineRate;
    public int upgradeCost;
    public int haloIndex;
    public int suitID;
    public int[] suitParamTypes = new int[4];
    public int[] suitParamValues = new int[4];
    public transient int counter;
    public int suitSkillID;
    public int suitSkillValue;
    public String functionDesc = "";

    public void readFrom(e e2) {
        super.readFrom(e2);
        this.minPhysicalDamage = e2.do();
        this.maxPhysicalDamage = e2.do();
        this.extraMinPhysicalDamage = e2.do();
        this.extraMaxPhysicalDamage = e2.do();
        this.minMagicDamage = e2.do();
        this.maxMagicDamage = e2.do();
        this.extraMinMagicDamage = e2.do();
        this.extraMaxMagicDamage = e2.do();
        this.pdLevelFactor = e2.for();
        this.pdStrengthFactor = e2.for();
        this.pdDexterityFactor = e2.for();
        this.pdWisdomFactor = e2.for();
        this.mdLevelFactor = e2.for();
        this.mdStrengthFactor = e2.for();
        this.mdDexterityFactor = e2.for();
        this.mdWisdomFactor = e2.for();
        this.hittingAbility = e2.for();
        this.attackRange = e2.for();
        this.attackTime = e2.case() * 10;
        this.attackDelay = e2.case() * 10;
        this.doubleDamageRate = e2.case();
        int n2 = e2.for();
        this.requiredRace = n2 >> 4;
        this.requiredTurn = n2 & 0xF;
        this.requiredLevel = e2.for();
        this.haloIndex = e2.for();
        if (e2.c()) {
            this.suitID = e2.i();
            int n3 = 0;
            while (n3 < this.suitParamTypes.length) {
                this.suitParamTypes[n3] = e2.for();
                this.suitParamValues[n3] = e2.j();
                ++n3;
            }
        }
        this.functionDesc = e2.h();
    }

    public void writeTo(e e2) {
        super.writeTo(e2);
        e2.for(this.minPhysicalDamage);
        e2.for(this.maxPhysicalDamage);
        e2.for(this.extraMinPhysicalDamage);
        e2.for(this.extraMaxPhysicalDamage);
        e2.for(this.minMagicDamage);
        e2.for(this.maxMagicDamage);
        e2.for(this.extraMinMagicDamage);
        e2.for(this.extraMaxMagicDamage);
        e2.a(this.pdLevelFactor);
        e2.a(this.pdStrengthFactor);
        e2.a(this.pdDexterityFactor);
        e2.a(this.pdWisdomFactor);
        e2.a(this.mdLevelFactor);
        e2.a(this.mdStrengthFactor);
        e2.a(this.mdDexterityFactor);
        e2.a(this.mdWisdomFactor);
        e2.a(this.hittingAbility);
        e2.a(this.attackRange);
        e2.a(this.attackTime / 10);
        e2.a(this.attackDelay / 10);
        e2.a(this.doubleDamageRate);
        e2.a(this.requiredRace << 4 | this.requiredTurn);
        e2.a(this.requiredLevel);
        e2.a(this.haloIndex);
        e2.a(this.suitID > 0);
        if (this.suitID > 0) {
            e2.char(this.suitID);
            int n2 = 0;
            while (n2 < this.suitParamTypes.length) {
                e2.a(this.suitParamTypes[n2]);
                e2.for(this.suitParamValues[n2]);
                ++n2;
            }
        }
        e2.a(this.functionDesc);
    }

    public boolean setAttributeValue(String string, String string2) {
        if (string.equals("suitParamTypes")) {
            this.suitParamTypes[this.counter] = Integer.parseInt(string2);
            return true;
        }
        if (string.equals("suitParamValues")) {
            this.suitParamValues[this.counter++] = Integer.parseInt(string2);
            return true;
        }
        return super.setAttributeValue(string, string2);
    }

    public Weapon() {
        this.goodsType = 1;
    }

    public void copyFrom(GameObject gameObject) {
        super.copyFrom(gameObject);
        Weapon weapon = (Weapon)gameObject;
        this.minPhysicalDamage = weapon.minPhysicalDamage;
        this.maxPhysicalDamage = weapon.maxPhysicalDamage;
        this.extraMinPhysicalDamage = weapon.extraMinPhysicalDamage;
        this.extraMaxPhysicalDamage = weapon.extraMaxPhysicalDamage;
        this.minMagicDamage = weapon.minMagicDamage;
        this.maxMagicDamage = weapon.maxMagicDamage;
        this.extraMinMagicDamage = weapon.extraMinMagicDamage;
        this.extraMaxMagicDamage = weapon.extraMaxMagicDamage;
        this.pdLevelFactor = weapon.pdLevelFactor;
        this.pdStrengthFactor = weapon.pdStrengthFactor;
        this.pdDexterityFactor = weapon.pdDexterityFactor;
        this.pdWisdomFactor = weapon.pdWisdomFactor;
        this.mdLevelFactor = weapon.mdLevelFactor;
        this.mdStrengthFactor = weapon.mdStrengthFactor;
        this.mdDexterityFactor = weapon.mdDexterityFactor;
        this.mdWisdomFactor = weapon.mdWisdomFactor;
        this.hittingAbility = weapon.hittingAbility;
        this.attackRange = weapon.attackRange;
        this.attackTime = weapon.attackTime;
        this.attackDelay = weapon.attackDelay;
        this.doubleDamageRate = weapon.doubleDamageRate;
        this.attachedFightState = weapon.attachedFightState;
        this.fightStateRate = weapon.fightStateRate;
        this.requiredRace = weapon.requiredRace;
        this.requiredLevel = weapon.requiredLevel;
        this.requiredTurn = weapon.requiredTurn;
        this.increaseCost = weapon.increaseCost;
        this.refineCost = weapon.refineCost;
        this.refineRate = weapon.refineRate;
        this.upgradeCost = weapon.upgradeCost;
        this.functionDesc = weapon.functionDesc;
        this.haloIndex = weapon.haloIndex;
        this.suitID = weapon.suitID;
        System.arraycopy(weapon.suitParamTypes, 0, this.suitParamTypes, 0, this.suitParamTypes.length);
        System.arraycopy(weapon.suitParamValues, 0, this.suitParamValues, 0, this.suitParamValues.length);
        this.suitSkillID = weapon.suitSkillID;
        this.suitSkillValue = weapon.suitSkillValue;
    }
}

