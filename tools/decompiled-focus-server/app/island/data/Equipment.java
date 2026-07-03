/*
 * Decompiled with CFR 0.152.
 */
package app.island.data;

import app.island.GameObject;
import app.island.data.Goods;
import daff.a.e;

public class Equipment
extends Goods {
    public static final int EQUIPMENT_TYPE_ARMOR = 1;
    public static final int EQUIPMENT_TYPE_HELMET = 2;
    public static final int EQUIPMENT_TYPE_BOOTS = 3;
    public static final int EQUIPMENT_TYPE_SHIELD = 4;
    public int eType;
    public int appearance;
    public int physicalDefense;
    public int magicDefense;
    public int extraPhysicalDefense;
    public int extraMagicDefense;
    public int pdLevelFactor = 1;
    public int pdStrengthFactor = 1;
    public int pdDexterityFactor = 1;
    public int pdWisdomFactor = 1;
    public int mdLevelFactor;
    public int mdStrengthFactor;
    public int mdDexterityFactor;
    public int mdWisdomFactor;
    public int lifeRaised;
    public int manaRaised;
    public int evadingAbility;
    public int stepTime;
    public int withstandingRate;
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
    public int suitSkillID;
    public int suitSkillValue;
    public transient int counter;

    public void readFrom(e e2) {
        super.readFrom(e2);
        this.eType = e2.case();
        this.appearance = e2.case();
        this.physicalDefense = e2.do();
        this.extraPhysicalDefense = e2.do();
        this.magicDefense = e2.do();
        this.extraMagicDefense = e2.do();
        this.pdLevelFactor = e2.for();
        this.pdStrengthFactor = e2.for();
        this.pdDexterityFactor = e2.for();
        this.pdWisdomFactor = e2.for();
        this.mdLevelFactor = e2.for();
        this.mdStrengthFactor = e2.for();
        this.mdDexterityFactor = e2.for();
        this.mdWisdomFactor = e2.for();
        this.lifeRaised = e2.j();
        this.manaRaised = e2.j();
        this.evadingAbility = e2.for();
        this.stepTime = e2.case() * 10;
        this.withstandingRate = e2.case();
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
    }

    public void writeTo(e e2) {
        super.writeTo(e2);
        e2.a(this.eType);
        e2.a(this.appearance);
        e2.for(this.physicalDefense);
        e2.for(this.extraPhysicalDefense);
        e2.for(this.magicDefense);
        e2.for(this.extraMagicDefense);
        e2.a(this.pdLevelFactor);
        e2.a(this.pdStrengthFactor);
        e2.a(this.pdDexterityFactor);
        e2.a(this.pdWisdomFactor);
        e2.a(this.mdLevelFactor);
        e2.a(this.mdStrengthFactor);
        e2.a(this.mdDexterityFactor);
        e2.a(this.mdWisdomFactor);
        e2.for(this.lifeRaised);
        e2.for(this.manaRaised);
        e2.a(this.evadingAbility);
        e2.a(this.stepTime / 10);
        e2.a(this.withstandingRate);
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

    public Equipment() {
        this.goodsType = 2;
    }

    public void copyFrom(GameObject gameObject) {
        super.copyFrom(gameObject);
        Equipment equipment = (Equipment)gameObject;
        this.eType = equipment.eType;
        this.appearance = equipment.appearance;
        this.physicalDefense = equipment.physicalDefense;
        this.extraPhysicalDefense = equipment.extraPhysicalDefense;
        this.magicDefense = equipment.magicDefense;
        this.extraMagicDefense = equipment.extraMagicDefense;
        this.pdLevelFactor = equipment.pdLevelFactor;
        this.pdStrengthFactor = equipment.pdStrengthFactor;
        this.pdDexterityFactor = equipment.pdDexterityFactor;
        this.pdWisdomFactor = equipment.pdWisdomFactor;
        this.mdLevelFactor = equipment.mdLevelFactor;
        this.mdStrengthFactor = equipment.mdStrengthFactor;
        this.mdDexterityFactor = equipment.mdDexterityFactor;
        this.mdWisdomFactor = equipment.mdWisdomFactor;
        this.lifeRaised = equipment.lifeRaised;
        this.manaRaised = equipment.manaRaised;
        this.evadingAbility = equipment.evadingAbility;
        this.stepTime = equipment.stepTime;
        this.withstandingRate = equipment.withstandingRate;
        this.requiredRace = equipment.requiredRace;
        this.requiredLevel = equipment.requiredLevel;
        this.requiredTurn = equipment.requiredTurn;
        this.increaseCost = equipment.increaseCost;
        this.refineCost = equipment.refineCost;
        this.refineRate = equipment.refineRate;
        this.upgradeCost = equipment.upgradeCost;
        this.haloIndex = equipment.haloIndex;
        this.suitID = equipment.suitID;
        System.arraycopy(equipment.suitParamTypes, 0, this.suitParamTypes, 0, this.suitParamTypes.length);
        System.arraycopy(equipment.suitParamValues, 0, this.suitParamValues, 0, this.suitParamValues.length);
        this.suitSkillID = equipment.suitSkillID;
        this.suitSkillValue = equipment.suitSkillValue;
    }
}

