/*
 * Decompiled with CFR 0.152.
 */
package app.island.data;

import app.island.GameObject;
import app.island.data.Goods;
import daff.a.e;

public class Decoration
extends Goods {
    public static final int DECORATION_TYPE_EARBOB = 1;
    public static final int DECORATION_TYPE_NECKLACE = 2;
    public static final int DECORATION_TYPE_RING = 3;
    public int dType;
    public int lifeRaised;
    public int manaRaised;
    public int physicalDefense;
    public int magicDefense;
    public int extraPhysicalDefense;
    public int extraMagicDefense;
    public int doubleDamageRate;
    public int lifeRestoreRate;
    public int manaRestoreRate;
    public int hittingAbility;
    public int evadingAbility;
    public int attachedFightState;
    public int fightStateRate;
    public int expLuck;
    public int moneyLuck;
    public int goodsLuck;
    public int specialAbility;
    public int increaseCost;
    public int refineRate;
    public int refineCost;
    public int upgradeCost;
    public int requiredTurn;
    public int requiredLevel;
    public int suitID;
    public int[] suitParamTypes = new int[4];
    public int[] suitParamValues = new int[4];
    public transient int counter;

    public void readFrom(e e2) {
        super.readFrom(e2);
        this.dType = e2.case();
        this.lifeRaised = e2.do();
        this.manaRaised = e2.do();
        this.lifeRestoreRate = e2.case();
        this.manaRestoreRate = e2.case();
        this.physicalDefense = e2.do();
        this.magicDefense = e2.do();
        this.extraPhysicalDefense = e2.do();
        this.extraMagicDefense = e2.do();
        this.doubleDamageRate = e2.case();
        this.hittingAbility = e2.for();
        this.evadingAbility = e2.for();
        this.specialAbility = e2.for();
        this.requiredTurn = e2.for();
        this.requiredLevel = e2.for();
        if (e2.c()) {
            this.suitID = e2.i();
            int n2 = 0;
            while (n2 < this.suitParamTypes.length) {
                this.suitParamTypes[n2] = e2.for();
                this.suitParamValues[n2] = e2.j();
                ++n2;
            }
        }
        this.description = e2.h();
    }

    public void writeTo(e e2) {
        super.writeTo(e2);
        e2.a(this.dType);
        e2.for(this.lifeRaised);
        e2.for(this.manaRaised);
        e2.a(this.lifeRestoreRate);
        e2.a(this.manaRestoreRate);
        e2.for(this.physicalDefense);
        e2.for(this.magicDefense);
        e2.for(this.extraPhysicalDefense);
        e2.for(this.extraMagicDefense);
        e2.a(this.doubleDamageRate);
        e2.a(this.hittingAbility);
        e2.a(this.evadingAbility);
        e2.a(this.specialAbility);
        e2.a(this.requiredTurn);
        e2.a(this.requiredLevel);
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
        e2.a(this.description);
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

    public Decoration() {
        this.goodsType = 3;
    }

    public void copyFrom(GameObject gameObject) {
        super.copyFrom(gameObject);
        Decoration decoration = (Decoration)gameObject;
        this.dType = decoration.dType;
        this.lifeRaised = decoration.lifeRaised;
        this.manaRaised = decoration.manaRaised;
        this.lifeRestoreRate = decoration.lifeRestoreRate;
        this.manaRestoreRate = decoration.manaRestoreRate;
        this.physicalDefense = decoration.physicalDefense;
        this.magicDefense = decoration.magicDefense;
        this.extraPhysicalDefense = decoration.extraPhysicalDefense;
        this.extraMagicDefense = decoration.extraMagicDefense;
        this.doubleDamageRate = decoration.doubleDamageRate;
        this.hittingAbility = decoration.hittingAbility;
        this.evadingAbility = decoration.evadingAbility;
        this.specialAbility = decoration.specialAbility;
        this.attachedFightState = decoration.attachedFightState;
        this.fightStateRate = decoration.fightStateRate;
        this.expLuck = decoration.expLuck;
        this.moneyLuck = decoration.moneyLuck;
        this.goodsLuck = decoration.goodsLuck;
        this.requiredLevel = decoration.requiredLevel;
        this.requiredTurn = decoration.requiredTurn;
        this.increaseCost = decoration.increaseCost;
        this.refineRate = decoration.refineRate;
        this.refineCost = decoration.refineCost;
        this.upgradeCost = decoration.upgradeCost;
        this.suitID = decoration.suitID;
        System.arraycopy(decoration.suitParamTypes, 0, this.suitParamTypes, 0, this.suitParamTypes.length);
        System.arraycopy(decoration.suitParamValues, 0, this.suitParamValues, 0, this.suitParamValues.length);
    }
}

