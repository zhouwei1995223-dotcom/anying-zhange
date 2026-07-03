/*
 * Decompiled with CFR 0.152.
 */
package app.island.data;

import app.island.GameObject;
import app.island.data.Goods;
import daff.a.e;

public class SpecialProperty
extends Goods {
    public static final int SP_TYPE_MONEY_BOX = 1;
    public static final int SP_TYPE_EXP_SCROLL = 2;
    public static final int SP_TYPE_RETURN_SCROLL = 3;
    public static final int SP_TYPE_RELIVE_DRUG = 4;
    public static final int SP_TYPE_RANDOM_MOVE_SCROLL = 5;
    public static final int SP_TYPE_TRANSPORT_SCROLL = 6;
    public static final int SP_TYPE_DUPLICATE_SCROLL = 7;
    public static final int SP_TYPE_SECRET_MONEY_BOX = 8;
    public static final int SP_TYPE_SECRET_EXP_SCROLL = 9;
    public static final int SP_TYPE_NEWER_GIFT_BOX = 10;
    public static final int SP_TYPE_RESTORE_SCROLL = 12;
    public static final int SP_TYPE_EQUIPMENT_UPDGRADE_STONE = 13;
    public static final int SP_TYPE_PRAYER_STONE = 14;
    public static final int SP_TYPE_SPELL_EXP_STONE = 16;
    public static final int SP_TYPE_STORE_CAPACITY_SCROLL = 18;
    public static final int SP_TYPE_SECRET_TREASURE_MAP = 19;
    public static final int SP_TYPE_COMPOUND_STONE = 20;
    public static final int SP_TYPE_GOODS_BOX = 23;
    public static final int SP_TYPE_PKVALUE_CLEAR_LOTION = 24;
    public static final int SP_TYPE_SEX_LOTION = 25;
    public static final int SP_TYPE_ONLINE_EXP_DRUG = 26;
    public static final int SP_TYPE_OFFLINE_EXP_DRUG = 27;
    public static final int SP_TYPE_DOUBLE_EXP_DRUG = 28;
    public static final int SP_TYPE_DOUBLE_MONEY_DRUG = 29;
    public static final int SP_TYPE_FIGHT_DRUG = 30;
    public static final int SP_TYPE_BLOODBANK = 31;
    public static final int SP_TYPE_MANA_BANK = 32;
    public static final int SP_TYPE_NORMAL_TREASURE_MAP = 33;
    public static final int SP_TYPE_PLUNDER_BOX = 34;
    public static final int SP_TYPE_HERO_TURN_SCROLL = 35;
    public static final int SP_TYPE_PERSONAL_SHOP_SCROLL = 36;
    public static final int SP_TYPE_DEATH_PROTECTOR = 37;
    public static final int SP_TYPE_GUILD_DUPULICATE_SCROLL = 38;
    public static final int SP_TYPE_GUILD_SIGN = 39;
    public static final int SP_TYPE_EQUIPMIX_SCROLL = 40;
    public static final int SP_TYPE_QUESTION_SCROLL = 41;
    public int spType;
    public int usable = 1;
    public int expiredTime;
    public int parameter1;
    public int parameter2;
    public int parameter3;
    public int parameter4;
    public int requiredLevel;
    public int[] extraData = new int[10];
    public transient int dataCount;

    public void readFrom(e e2) {
        super.readFrom(e2);
        this.spType = e2.for();
        this.usable = e2.case();
        this.requiredLevel = e2.for();
        this.parameter1 = e2.i();
        this.parameter2 = e2.i();
        this.parameter3 = e2.i();
        this.parameter4 = e2.i();
        this.description = e2.h();
    }

    public void writeTo(e e2) {
        super.writeTo(e2);
        e2.a(this.spType);
        e2.a(this.usable);
        e2.a(this.requiredLevel);
        e2.char(this.parameter1);
        e2.char(this.parameter2);
        e2.char(this.parameter3);
        e2.char(this.parameter4);
        e2.a(this.description);
    }

    public boolean setAttributeValue(String string, String string2) {
        if (string.equals("extraData")) {
            this.extraData[this.dataCount++] = Integer.parseInt(string2);
            return true;
        }
        if (string.equals("expiredTime")) {
            return true;
        }
        return super.setAttributeValue(string, string2);
    }

    public SpecialProperty() {
        this.goodsType = 5;
    }

    public void copyFrom(GameObject gameObject) {
        super.copyFrom(gameObject);
        SpecialProperty specialProperty = (SpecialProperty)gameObject;
        this.spType = specialProperty.spType;
        this.usable = specialProperty.usable;
        this.requiredLevel = specialProperty.requiredLevel;
        this.parameter1 = specialProperty.parameter1;
        this.parameter2 = specialProperty.parameter2;
        this.parameter3 = specialProperty.parameter3;
        this.parameter4 = specialProperty.parameter4;
        this.extraData = specialProperty.extraData;
        this.dataCount = specialProperty.dataCount;
    }

    public void parseExtrInfo(String string) {
        if (string == null || string.length() == 0) {
            return;
        }
        if (this.spType == 31) {
            this.parameter1 = Integer.parseInt(string);
        } else if (this.spType == 32) {
            this.parameter1 = Integer.parseInt(string);
        } else if (this.spType == 37) {
            this.parameter1 = Integer.parseInt(string);
        }
    }

    public String getExtraInfo() {
        if (this.spType == 31) {
            return String.valueOf(this.parameter1);
        }
        if (this.spType == 32) {
            return String.valueOf(this.parameter1);
        }
        if (this.spType == 37) {
            return String.valueOf(this.parameter1);
        }
        return "";
    }
}

