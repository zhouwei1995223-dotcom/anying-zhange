/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javassist.runtime.DotClass
 */
package app.island.data;

import app.island.GameObject;
import app.island.data.Decoration;
import app.island.data.Equipment;
import app.island.data.Fashion;
import app.island.data.Goods;
import app.island.data.Weapon;
import app.island.entity.Hero;
import daff.a.e;
import daff.a.h;
import daff.a.i;
import javassist.runtime.DotClass;

public class Depot
extends GameObject {
    public int money = 0;
    public Goods[] goodsList = new Goods[64];
    public Fashion fashion;
    public Weapon weapon;
    public Equipment armor;
    public Equipment helmet;
    public Equipment boots;
    public Equipment shield;
    public Decoration leftEarbob;
    public Decoration rightEarbob;
    public Decoration necklace;
    public Decoration leftRing;
    public Decoration rightRing;
    public Goods[] shopGoods = new Goods[80];
    public int shopCapacity = 16;
    public transient boolean goodsProcessed = false;
    public Decoration title;
    public Decoration aura;

    public int getAttackTime() {
        int n2 = 0;
        if (this.weapon != null) {
            n2 = this.weapon.attackTime;
        }
        return n2 += this.getSuitParam(7);
    }

    public Decoration unequipDecoration(int n2, int n3) {
        if (n2 == 5) {
            Decoration decoration = this.aura;
            this.aura = null;
            return decoration;
        }
        if (n2 == 4) {
            Decoration decoration = this.title;
            this.title = null;
            return decoration;
        }
        Decoration decoration = null;
        switch (n2) {
            case 1: {
                if (n3 == 1) {
                    decoration = this.leftEarbob;
                    this.leftEarbob = null;
                    break;
                }
                decoration = this.rightEarbob;
                this.rightEarbob = null;
                break;
            }
            case 2: {
                decoration = this.necklace;
                this.necklace = null;
                break;
            }
            case 3: {
                if (n3 == 1) {
                    decoration = this.leftRing;
                    this.leftRing = null;
                    break;
                }
                decoration = this.rightRing;
                this.rightRing = null;
                break;
            }
        }
        return decoration;
    }

    public void readFrom(e e2) {
        this.money = e2.i();
        this.readEquipments(e2);
        this.readGoods(e2);
        this.shopCapacity = e2.for();
    }

    public int getMaxMagicDamage() {
        int n2 = 0;
        if (this.weapon != null) {
            n2 = this.weapon.maxMagicDamage + this.weapon.extraMaxMagicDamage;
        }
        return n2 += this.getSuitParam(2);
    }

    public int getEvadingAbility() {
        int n2 = 0;
        if (this.armor != null) {
            n2 += this.armor.evadingAbility;
        }
        if (this.helmet != null) {
            n2 += this.helmet.evadingAbility;
        }
        if (this.boots != null) {
            n2 += this.boots.evadingAbility;
        }
        if (this.shield != null) {
            n2 += this.shield.evadingAbility;
        }
        if (this.leftEarbob != null) {
            n2 += this.leftEarbob.evadingAbility;
        }
        if (this.rightEarbob != null) {
            n2 += this.rightEarbob.evadingAbility;
        }
        if (this.necklace != null) {
            n2 += this.necklace.evadingAbility;
        }
        if (this.leftRing != null) {
            n2 += this.leftRing.evadingAbility;
        }
        if (this.rightRing != null) {
            n2 += this.rightRing.evadingAbility;
        }
        int n3 = n2 += this.getSuitParam(9);
        if (this.title != null) {
            n3 += this.title.evadingAbility;
        }
        int n4 = n3;
        if (this.aura != null) {
            n4 += this.aura.evadingAbility;
        }
        return n4;
    }

    public void writeTo(e e2) {
        e2.char(this.money);
        this.writeEquipments(e2);
        this.writeGoods(e2);
        e2.a(this.shopCapacity);
    }

    public int getManaRestoreRate() {
        int n2 = 0;
        if (this.necklace != null) {
            n2 += this.necklace.manaRestoreRate;
        }
        int n3 = n2;
        if (this.title != null) {
            n3 += this.title.manaRestoreRate;
        }
        int n4 = n3;
        if (this.aura != null) {
            n4 += this.aura.manaRestoreRate;
        }
        return n4;
    }

    public int getWithstandingRate() {
        if (this.shield != null) {
            return this.shield.withstandingRate;
        }
        return 0;
    }

    public int getManaRaised() {
        return this.getManaRaised(false);
    }

    public int getManaRaised(boolean bl) {
        int n2 = 0;
        if (this.armor != null) {
            n2 = bl ? (n2 += (int)((float)this.armor.manaRaised * 0.3f * (1.0f + (float)this.armor.quality * 0.15f))) : (n2 += this.armor.manaRaised);
        }
        if (this.helmet != null) {
            n2 = bl ? (n2 += (int)((float)this.helmet.manaRaised * 0.3f * (1.0f + (float)this.helmet.quality * 0.15f))) : (n2 += this.helmet.manaRaised);
        }
        if (this.boots != null) {
            n2 = bl ? (n2 += (int)((float)this.boots.manaRaised * 0.3f * (1.0f + (float)this.boots.quality * 0.15f))) : (n2 += this.boots.manaRaised);
        }
        if (this.shield != null) {
            n2 = bl ? (n2 += (int)((float)this.shield.manaRaised * 0.3f * (1.0f + (float)this.shield.quality * 0.15f))) : (n2 += this.shield.manaRaised);
        }
        if (this.leftEarbob != null) {
            n2 = bl ? (n2 += (int)((float)this.leftEarbob.manaRaised * 0.3f * (1.0f + (float)this.leftEarbob.quality * 0.15f))) : (n2 += this.leftEarbob.manaRaised);
        }
        if (this.rightEarbob != null) {
            n2 = bl ? (n2 += (int)((float)this.rightEarbob.manaRaised * 0.3f * (1.0f + (float)this.rightEarbob.quality * 0.15f))) : (n2 += this.rightEarbob.manaRaised);
        }
        if (this.necklace != null) {
            n2 = bl ? (n2 += (int)((float)this.necklace.manaRaised * 0.3f * (1.0f + (float)this.necklace.quality * 0.15f))) : (n2 += this.necklace.manaRaised);
        }
        if (this.leftRing != null) {
            n2 = bl ? (n2 += (int)((float)this.leftRing.manaRaised * 0.3f * (1.0f + (float)this.leftRing.quality * 0.15f))) : (n2 += this.leftRing.manaRaised);
        }
        if (this.rightRing != null) {
            n2 = bl ? (n2 += (int)((float)this.rightRing.manaRaised * 0.3f * (1.0f + (float)this.rightRing.quality * 0.15f))) : (n2 += this.rightRing.manaRaised);
        }
        n2 = bl ? (n2 += this.getSuitParam(4) / 2) : (n2 += this.getSuitParam(4));
        int n3 = n2;
        if (this.title != null) {
            n3 += bl ? (int)((float)this.title.manaRaised * 0.3f * (1.0f + (float)this.title.quality * 0.15f)) : this.title.manaRaised;
        }
        int n4 = n3;
        if (this.aura != null) {
            n4 += bl ? (int)((float)this.aura.manaRaised * 0.3f * (1.0f + (float)this.aura.quality * 0.15f)) : this.aura.manaRaised;
        }
        return n4;
    }

    public int getNextFreePos() {
        int n2 = 0;
        while (n2 < this.goodsList.length) {
            if (this.goodsList[n2] == null) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    public int getFreeShopPos() {
        int n2 = 0;
        while (n2 < this.shopCapacity) {
            if (this.shopGoods[n2] == null) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    public int getStepTime() {
        if (this.boots != null) {
            return this.boots.stepTime;
        }
        return 0;
    }

    public void readShop(e e2) {
        int n2 = 0;
        while (n2 < this.shopCapacity) {
            if (e2.c()) {
                int n3 = e2.case();
                Goods goods = Goods.createGoodsByType(n3);
                goods.readFrom(e2);
                this.shopGoods[n2] = goods;
            }
            ++n2;
        }
    }

    public void writeShop(e e2) {
        int n2 = 0;
        while (n2 < this.shopCapacity) {
            if (this.shopGoods[n2] == null) {
                e2.a(false);
            } else {
                e2.a(true);
                e2.a(this.shopGoods[n2].goodsType);
                this.shopGoods[n2].writeTo(e2);
            }
            ++n2;
        }
    }

    public Weapon unequipWeapon() {
        Weapon weapon = this.weapon;
        this.weapon = null;
        return weapon;
    }

    public void clearWeapon() {
        this.weapon = null;
    }

    public void readGoods(e e2) {
        int n2 = 0;
        while (n2 < this.goodsList.length) {
            boolean bl = e2.c();
            if (bl) {
                int n3 = e2.case();
                Goods goods = Goods.createGoodsByType(n3);
                goods.readFrom(e2);
                this.goodsList[n2] = goods;
            }
            ++n2;
        }
    }

    public void writeGoods(e e2) {
        int n2 = 0;
        while (n2 < this.goodsList.length) {
            if (this.goodsList[n2] == null) {
                e2.a(false);
            } else {
                e2.a(true);
                e2.a(this.goodsList[n2].goodsType);
                this.goodsList[n2].writeTo(e2);
            }
            ++n2;
        }
    }

    public Equipment unequipEquipment(int n2) {
        Equipment equipment = null;
        switch (n2) {
            case 1: {
                equipment = this.armor;
                this.armor = null;
                break;
            }
            case 3: {
                equipment = this.boots;
                this.boots = null;
                break;
            }
            case 2: {
                equipment = this.helmet;
                this.helmet = null;
                break;
            }
            case 4: {
                equipment = this.shield;
                this.shield = null;
                break;
            }
        }
        return equipment;
    }

    public Weapon equipWeapon(Weapon weapon) {
        Weapon weapon2 = this.unequipWeapon();
        this.weapon = weapon;
        return weapon2;
    }

    public int getMaxPhysicalDamage() {
        int n2 = 0;
        if (this.weapon != null) {
            n2 = this.weapon.maxPhysicalDamage + this.weapon.extraMaxPhysicalDamage;
        }
        return n2 += this.getSuitParam(1);
    }

    public int getMinMagicDamage() {
        int n2 = 0;
        if (this.weapon != null) {
            n2 = this.weapon.minMagicDamage + this.weapon.extraMinMagicDamage;
        }
        return n2 += this.getSuitParam(2);
    }

    public int getMagicDefense(Hero hero) {
        return this.getMagicDefense(hero, false);
    }

    public int getMagicDefense(Hero hero, boolean bl) {
        int n2;
        int n3;
        int n4 = 0;
        if (this.armor != null) {
            n4 = bl ? (n4 += (int)((float)(this.armor.magicDefense + this.armor.extraMagicDefense) * (0.1f * (1.0f + 0.15f * (float)this.armor.quality)))) : (n4 += this.armor.magicDefense + this.armor.extraMagicDefense);
        }
        if (this.helmet != null) {
            n4 = bl ? (n4 += (int)((float)(this.helmet.magicDefense + this.helmet.extraMagicDefense) * (0.1f * (1.0f + 0.15f * (float)this.helmet.quality)))) : (n4 += this.helmet.magicDefense + this.helmet.extraMagicDefense);
        }
        if (this.boots != null) {
            n4 = bl ? (n4 += (int)((float)(this.boots.magicDefense + this.boots.extraMagicDefense) * (0.1f * (1.0f + 0.15f * (float)this.boots.quality)))) : (n4 += this.boots.magicDefense + this.boots.extraMagicDefense);
        }
        if (this.shield != null) {
            n4 = bl ? (n4 += (int)((float)(this.shield.magicDefense + this.shield.extraMagicDefense) * (0.1f * (1.0f + 0.15f * (float)this.shield.quality)))) : (n4 += this.shield.magicDefense + this.shield.extraMagicDefense);
        }
        if (this.leftEarbob != null) {
            n4 = bl ? (n4 += (int)((float)(this.leftEarbob.magicDefense + this.leftEarbob.extraMagicDefense) * (0.1f * (1.0f + 0.15f * (float)this.leftEarbob.quality)))) : (n4 += this.leftEarbob.magicDefense + this.leftEarbob.extraMagicDefense);
        }
        if (this.rightEarbob != null) {
            n4 = bl ? (n4 += (int)((float)(this.rightEarbob.magicDefense + this.rightEarbob.extraMagicDefense) * (0.1f * (1.0f + 0.15f * (float)this.rightEarbob.quality)))) : (n4 += this.rightEarbob.magicDefense + this.rightEarbob.extraMagicDefense);
        }
        if (this.leftRing != null) {
            n4 = bl ? (n4 += (int)((float)(this.leftRing.magicDefense + this.leftRing.extraMagicDefense) * (0.1f * (1.0f + 0.15f * (float)this.leftRing.quality)))) : (n4 += this.leftRing.magicDefense + this.leftRing.extraMagicDefense);
        }
        if (this.rightRing != null) {
            n4 = bl ? (n4 += (int)((float)(this.rightRing.magicDefense + this.rightRing.extraMagicDefense) * (0.1f * (1.0f + 0.15f * (float)this.rightRing.quality)))) : (n4 += this.rightRing.magicDefense + this.rightRing.extraMagicDefense);
        }
        n4 = bl ? (n4 += this.getSuitParam(6) / 10) : (n4 += this.getSuitParam(6));
        if (bl) {
            n3 = n4;
        } else {
            int n5 = 0;
            if (this.armor != null) {
                n5 += this.armor.mdLevelFactor * hero.level / 10;
                n5 += this.armor.mdStrengthFactor * hero.strength / 100;
                n5 += this.armor.mdDexterityFactor * hero.dexterity / 100;
                n5 += this.armor.mdWisdomFactor * hero.wisdom / 100;
            }
            if (this.helmet != null) {
                n5 += this.helmet.mdLevelFactor * hero.level / 10;
                n5 += this.helmet.mdStrengthFactor * hero.strength / 100;
                n5 += this.helmet.mdDexterityFactor * hero.dexterity / 100;
                n5 += this.helmet.mdWisdomFactor * hero.wisdom / 100;
            }
            if (this.boots != null) {
                n5 += this.boots.mdLevelFactor * hero.level / 10;
                n5 += this.boots.mdStrengthFactor * hero.strength / 100;
                n5 += this.boots.mdDexterityFactor * hero.dexterity / 100;
                n5 += this.boots.mdWisdomFactor * hero.wisdom / 100;
            }
            if (this.shield != null) {
                n5 += this.shield.mdLevelFactor * hero.level / 10;
                n5 += this.shield.mdStrengthFactor * hero.strength / 100;
                n5 += this.shield.mdDexterityFactor * hero.dexterity / 100;
                n5 += this.shield.mdWisdomFactor * hero.wisdom / 100;
            }
            n3 = n2 = n4 + n5;
        }
        if (this.title != null) {
            n2 += bl ? (int)((float)(this.title.magicDefense + this.title.extraMagicDefense) * (0.1f * (1.0f + 0.15f * (float)this.title.quality))) : this.title.magicDefense + this.title.extraMagicDefense;
        }
        int n6 = n2;
        if (this.aura != null) {
            n6 += bl ? (int)((float)(this.aura.magicDefense + this.aura.extraMagicDefense) * (0.1f * (1.0f + 0.15f * (float)this.aura.quality))) : this.aura.magicDefense + this.aura.extraMagicDefense;
        }
        return n6;
    }

    public int getSuitSkillID() {
        if (this.weapon == null || this.weapon.suitID == 0) {
            return 0;
        }
        if (this.helmet == null || this.helmet.suitID == 0) {
            return 0;
        }
        if (this.armor == null || this.armor.suitID == 0) {
            return 0;
        }
        if (this.boots == null || this.boots.suitID == 0) {
            return 0;
        }
        if (this.weapon.suitID == this.helmet.suitID && this.helmet.suitID == this.armor.suitID && this.armor.suitID == this.boots.suitID) {
            return this.weapon.suitSkillID;
        }
        return 0;
    }

    public void clearEquipments() {
        this.helmet = null;
        this.armor = null;
        this.boots = null;
        this.shield = null;
    }

    public void clearDecorations() {
        this.rightEarbob = null;
        this.leftEarbob = null;
        this.rightRing = null;
        this.leftRing = null;
        this.necklace = null;
        Object var2_1 = null;
        this.title = null;
        Object var4_2 = null;
        this.aura = null;
    }

    public int getHaloIndex() {
        if (this.title != null) {
            return 18;
        }
        if (this.aura != null) {
            return 1;
        }
        int n2 = 0;
        if (this.weapon != null) {
            n2 = this.weapon.haloIndex;
        }
        if (this.helmet != null && this.helmet.haloIndex > n2) {
            n2 = this.helmet.haloIndex;
        }
        if (this.armor != null && this.armor.haloIndex > n2) {
            n2 = this.armor.haloIndex;
        }
        if (this.boots != null && this.boots.haloIndex > n2) {
            n2 = this.boots.haloIndex;
        }
        if (this.shield != null && this.shield.haloIndex > n2) {
            n2 = this.shield.haloIndex;
        }
        return n2;
    }

    public String checkWeapon(Hero hero, Weapon weapon) {
        if (weapon.requiredRace != hero.race) {
            return "\u804c\u4e1a\u4e0d\u7b26";
        }
        if (weapon.requiredLevel > hero.level) {
            return "\u7b49\u7ea7\u4e0d\u591f";
        }
        if (weapon.requiredTurn > hero.turns) {
            return "\u8f6c\u751f\u4e0d\u591f";
        }
        return "";
    }

    public Decoration equipDecoration(Decoration decoration, int n2) {
        if (decoration != null && decoration.id == 1713059900) {
            Decoration decoration2 = this.aura;
            this.aura = decoration;
            return decoration2;
        }
        if (decoration.dType == 5) {
            Decoration decoration3 = this.aura;
            this.aura = decoration;
            return decoration3;
        }
        if (decoration.dType == 4) {
            Decoration decoration4 = this.title;
            this.title = decoration;
            return decoration4;
        }
        Decoration decoration5 = null;
        switch (decoration.dType) {
            case 1: {
                if (n2 == 1) {
                    decoration5 = this.leftEarbob;
                    this.leftEarbob = decoration;
                    break;
                }
                if (n2 == 2) {
                    decoration5 = this.rightEarbob;
                    this.rightEarbob = decoration;
                    break;
                }
                if (this.leftEarbob == null) {
                    this.leftEarbob = decoration;
                    break;
                }
                if (this.rightEarbob == null) {
                    this.rightEarbob = decoration;
                    break;
                }
                decoration5 = this.leftEarbob;
                this.leftEarbob = decoration;
                break;
            }
            case 2: {
                decoration5 = this.necklace;
                this.necklace = decoration;
                break;
            }
            case 3: {
                if (n2 == 1) {
                    decoration5 = this.leftRing;
                    this.leftRing = decoration;
                    break;
                }
                if (n2 == 2) {
                    decoration5 = this.rightRing;
                    this.rightRing = decoration;
                    break;
                }
                if (this.leftRing == null) {
                    this.leftRing = decoration;
                    break;
                }
                if (this.rightRing == null) {
                    this.rightRing = decoration;
                    break;
                }
                decoration5 = this.leftRing;
                this.leftRing = decoration;
                break;
            }
        }
        return decoration5;
    }

    public i getAttributeValue(String string) {
        if (string.equals("aura")) {
            i i2 = new i(string);
            if (this.aura != null) {
                Class<?> clazz;
                Class[] classArray = new Class[1];
                try {
                    clazz = Class.forName("java.lang.String");
                }
                catch (ClassNotFoundException classNotFoundException) {
                    throw DotClass.fail((ClassNotFoundException)classNotFoundException);
                }
                classArray[0] = clazz;
                i2.getClass().getMethod("do", classArray).invoke(i2, String.valueOf(this.aura.id));
            }
            return i2;
        }
        if (string.equals("title")) {
            i i3 = new i(string);
            if (this.title != null) {
                Class<?> clazz;
                Class[] classArray = new Class[1];
                try {
                    clazz = Class.forName("java.lang.String");
                }
                catch (ClassNotFoundException classNotFoundException) {
                    throw DotClass.fail((ClassNotFoundException)classNotFoundException);
                }
                classArray[0] = clazz;
                i3.getClass().getMethod("do", classArray).invoke(i3, String.valueOf(this.title.id));
            }
            return i3;
        }
        i i4 = new i(string);
        if (string.equals("goodsList")) {
            int n2 = 0;
            while (n2 < this.goodsList.length) {
                if (this.goodsList[n2] != null) {
                    i i5 = new i(String.valueOf(n2));
                    String string2 = String.valueOf(this.goodsList[n2].id);
                    String string3 = this.goodsList[n2].getExtraInfo();
                    if (string3.length() > 0) {
                        string2 = string2 + ',' + string3;
                    }
                    i5.do(string2);
                    i4.a(i5);
                }
                ++n2;
            }
        } else if (string.equals("shopGoods")) {
            int n3 = 0;
            while (n3 < this.shopCapacity) {
                if (this.shopGoods[n3] != null) {
                    i i6 = new i(String.valueOf(n3));
                    String string4 = String.valueOf(this.shopGoods[n3].id);
                    String string5 = this.shopGoods[n3].getExtraInfo();
                    if (string5.length() > 0) {
                        string4 = string4 + ',' + string5;
                    }
                    i6.do(string4);
                    i4.a(i6);
                }
                ++n3;
            }
        } else if (string.equals("fashion")) {
            if (this.fashion != null) {
                i4.do(String.valueOf(this.fashion.id) + ',' + this.fashion.getExtraInfo());
            }
        } else if (string.equals("weapon")) {
            if (this.weapon != null) {
                i4.do(String.valueOf(this.weapon.id));
            }
        } else if (string.equals("helmet")) {
            if (this.helmet != null) {
                i4.do(String.valueOf(this.helmet.id));
            }
        } else if (string.equals("armor")) {
            if (this.armor != null) {
                i4.do(String.valueOf(this.armor.id));
            }
        } else if (string.equals("boots")) {
            if (this.boots != null) {
                i4.do(String.valueOf(this.boots.id));
            }
        } else if (string.equals("shield")) {
            if (this.shield != null) {
                i4.do(String.valueOf(this.shield.id));
            }
        } else if (string.equals("leftEarbob")) {
            if (this.leftEarbob != null) {
                i4.do(String.valueOf(this.leftEarbob.id));
            }
        } else if (string.equals("rightEarbob")) {
            if (this.rightEarbob != null) {
                i4.do(String.valueOf(this.rightEarbob.id));
            }
        } else if (string.equals("necklace")) {
            if (this.necklace != null) {
                i4.do(String.valueOf(this.necklace.id));
            }
        } else if (string.equals("leftRing")) {
            if (this.leftRing != null) {
                i4.do(String.valueOf(this.leftRing.id));
            }
        } else if (string.equals("rightRing")) {
            if (this.rightRing != null) {
                i4.do(String.valueOf(this.rightRing.id));
            }
        } else {
            return super.getAttributeValue(string);
        }
        return i4;
    }

    public boolean setAttributeValue(String string, i i2) {
        if (string.equals("aura")) {
            String string2 = (String)i2.getClass().getMethod("for", new Class[0]).invoke(i2, new Object[0]);
            if (string2.equals("null") || string2.length() < 1) {
                return false;
            }
            int n2 = Integer.parseInt(string2);
            if (n2 > 0) {
                this.aura = (Decoration)GameObject.cloneObject(Goods.getGlobalGoods(n2));
            }
            return true;
        }
        if (string.equals("title")) {
            String string3 = (String)i2.getClass().getMethod("for", new Class[0]).invoke(i2, new Object[0]);
            if (string3.equals("null") || string3.length() < 1) {
                return false;
            }
            int n3 = Integer.parseInt(string3);
            if (n3 > 0) {
                this.title = (Decoration)GameObject.cloneObject(Goods.getGlobalGoods(n3));
            }
            return true;
        }
        String string4 = i2.for();
        if (string.equals("goodsList")) {
            h h2 = i2.int();
            if (h2 != null) {
                int n4 = h2.for();
                int n5 = 0;
                while (n5 < n4) {
                    i i3 = (i)h2.if(n5);
                    if (i3.for().length() >= 1) {
                        Goods goods;
                        int n6;
                        int n7 = Integer.parseInt(i3.do());
                        String string5 = i3.for();
                        int n8 = string5.indexOf(44);
                        if (n8 < 0) {
                            n6 = Integer.parseInt(i3.for());
                            goods = Goods.getGlobalGoods(n6);
                            if (goods != null) {
                                this.goodsList[n7] = (Goods)GameObject.cloneObject(goods);
                            }
                        } else {
                            n6 = Integer.parseInt(string5.substring(0, n8));
                            goods = Goods.getGlobalGoods(n6);
                            if (goods != null) {
                                this.goodsList[n7] = (Goods)GameObject.cloneObject(goods);
                                this.goodsList[n7].parseExtrInfo(string5.substring(n8 + 1));
                            }
                        }
                    }
                    ++n5;
                }
            }
            return true;
        }
        if (string.equals("shopGoods")) {
            h h3 = i2.int();
            if (h3 != null) {
                int n9 = h3.for();
                int n10 = 0;
                while (n10 < n9) {
                    i i4 = (i)h3.if(n10);
                    if (i4.for().length() >= 1) {
                        Goods goods;
                        int n11;
                        int n12 = Integer.parseInt(i4.do());
                        String string6 = i4.for();
                        int n13 = string6.indexOf(44);
                        if (n13 < 0) {
                            n11 = Integer.parseInt(i4.for());
                            goods = Goods.getGlobalGoods(n11);
                            if (goods != null) {
                                this.shopGoods[n12] = (Goods)GameObject.cloneObject(goods);
                            }
                        } else {
                            n11 = Integer.parseInt(string6.substring(0, n13));
                            goods = Goods.getGlobalGoods(n11);
                            if (goods != null) {
                                this.shopGoods[n12] = (Goods)GameObject.cloneObject(goods);
                                this.shopGoods[n12].parseExtrInfo(string6.substring(n13 + 1));
                            }
                        }
                        if (this.shopGoods[n12] != null) {
                            this.shopGoods[n12].treasureCost = 0;
                        }
                    }
                    ++n10;
                }
            }
            return true;
        }
        if (string4.equals("null") || string4.length() < 1) {
            return false;
        }
        if (string.equals("fashion")) {
            int n14 = string4.indexOf(44);
            if (n14 > 0) {
                int n15 = Integer.parseInt(string4.substring(0, n14));
                String string7 = string4.substring(n14 + 1);
                this.fashion = (Fashion)Goods.getGlobalGoods(n15);
                if (this.fashion != null) {
                    this.fashion = (Fashion)GameObject.cloneObject(this.fashion);
                    this.fashion.parseExtrInfo(string7);
                }
            } else {
                int n16 = Integer.parseInt(string4);
                this.fashion = (Fashion)Goods.getGlobalGoods(n16);
                this.fashion = (Fashion)GameObject.cloneObject(this.fashion);
            }
        } else if (string.equals("weapon")) {
            int n17 = Integer.parseInt(string4);
            if (n17 > 0) {
                this.weapon = (Weapon)GameObject.cloneObject(Goods.getGlobalGoods(n17));
            }
        } else if (string.equals("helmet")) {
            int n18 = Integer.parseInt(string4);
            if (n18 > 0) {
                this.helmet = (Equipment)GameObject.cloneObject(Goods.getGlobalGoods(n18));
            }
        } else if (string.equals("armor")) {
            int n19 = Integer.parseInt(string4);
            if (n19 > 0) {
                this.armor = (Equipment)GameObject.cloneObject(Goods.getGlobalGoods(n19));
            }
        } else if (string.equals("boots")) {
            int n20 = Integer.parseInt(string4);
            if (n20 > 0) {
                this.boots = (Equipment)GameObject.cloneObject(Goods.getGlobalGoods(n20));
            }
        } else if (string.equals("shield")) {
            int n21 = Integer.parseInt(string4);
            if (n21 > 0) {
                this.shield = (Equipment)GameObject.cloneObject(Goods.getGlobalGoods(n21));
            }
        } else if (string.equals("leftEarbob")) {
            int n22 = Integer.parseInt(string4);
            if (n22 > 0) {
                this.leftEarbob = (Decoration)GameObject.cloneObject(Goods.getGlobalGoods(n22));
            }
        } else if (string.equals("rightEarbob")) {
            int n23 = Integer.parseInt(string4);
            if (n23 > 0) {
                this.rightEarbob = (Decoration)GameObject.cloneObject(Goods.getGlobalGoods(n23));
            }
        } else if (string.equals("necklace")) {
            int n24 = Integer.parseInt(string4);
            if (n24 > 0) {
                this.necklace = (Decoration)GameObject.cloneObject(Goods.getGlobalGoods(n24));
            }
        } else if (string.equals("leftRing")) {
            int n25 = Integer.parseInt(string4);
            if (n25 > 0) {
                this.leftRing = (Decoration)GameObject.cloneObject(Goods.getGlobalGoods(n25));
            }
        } else if (string.equals("rightRing")) {
            int n26 = Integer.parseInt(string4);
            if (n26 > 0) {
                this.rightRing = (Decoration)GameObject.cloneObject(Goods.getGlobalGoods(n26));
            }
        } else {
            return super.setAttributeValue(string, i2);
        }
        return true;
    }

    public int getSuitParam(int n2) {
        int n3 = 0;
        if (this.leftEarbob != null) {
            n3 += this.getSuitParam(this.leftEarbob, n2);
        }
        if (this.rightEarbob != null) {
            n3 += this.getSuitParam(this.rightEarbob, n2);
        }
        if (this.necklace != null) {
            n3 += this.getSuitParam(this.necklace, n2);
        }
        if (this.leftRing != null) {
            n3 += this.getSuitParam(this.leftRing, n2);
        }
        if (this.rightRing != null) {
            n3 += this.getSuitParam(this.rightRing, n2);
        }
        if (this.weapon != null) {
            n3 += this.getSuitParam(this.weapon, n2);
        }
        if (this.helmet != null) {
            n3 += this.getSuitParam(this.helmet, n2);
        }
        if (this.armor != null) {
            n3 += this.getSuitParam(this.armor, n2);
        }
        if (this.shield != null) {
            n3 += this.getSuitParam(this.shield, n2);
        }
        if (this.boots != null) {
            n3 += this.getSuitParam(this.boots, n2);
        }
        int n4 = n3;
        if (this.title != null) {
            n4 += this.getSuitParam(this.title, n2);
        }
        int n5 = n4;
        if (this.aura != null) {
            n5 += this.getSuitParam(this.aura, n2);
        }
        return n5;
    }

    public int getSuitParam(Decoration decoration, int n2) {
        if (decoration.suitID == 0) {
            return 0;
        }
        int n3 = this.getSuitCount(decoration.suitID);
        if (n3 <= 1) {
            return 0;
        }
        int n4 = 0;
        int n5 = 1;
        while (n5 < n3) {
            if (decoration.suitParamTypes[n5 - 1] == n2) {
                n4 += decoration.suitParamValues[n5 - 1];
            }
            ++n5;
        }
        return n4;
    }

    public int getGoodsCount() {
        int n2 = 0;
        int n3 = 0;
        while (n3 < this.goodsList.length) {
            if (this.goodsList[n3] != null) {
                ++n2;
            }
            ++n3;
        }
        return n2;
    }

    public int getGoodsCount(int n2) {
        int n3 = 0;
        int n4 = 0;
        while (n4 < this.goodsList.length) {
            if (this.goodsList[n4] != null && this.goodsList[n4].id == n2) {
                ++n3;
            }
            ++n4;
        }
        return n3;
    }

    public int getLifeRestoreRate() {
        int n2 = 0;
        if (this.necklace != null) {
            n2 += this.necklace.lifeRestoreRate;
        }
        int n3 = n2;
        if (this.title != null) {
            n3 += this.title.lifeRestoreRate;
        }
        int n4 = n3;
        if (this.aura != null) {
            n4 += this.aura.lifeRestoreRate;
        }
        return n4;
    }

    public int getSuitCount(int n2) {
        int n3 = 0;
        if (this.helmet != null && this.helmet.suitID == n2) {
            ++n3;
        }
        if (this.armor != null && this.armor.suitID == n2) {
            ++n3;
        }
        if (this.shield != null && this.shield.suitID == n2) {
            ++n3;
        }
        if (this.boots != null && this.boots.suitID == n2) {
            ++n3;
        }
        if (this.weapon != null && this.weapon.suitID == n2) {
            ++n3;
        }
        if (this.leftEarbob != null && this.leftEarbob.suitID == n2) {
            ++n3;
        }
        if (this.rightEarbob != null && this.rightEarbob.suitID == n2) {
            ++n3;
        }
        if (this.necklace != null && this.necklace.suitID == n2) {
            ++n3;
        }
        if (this.leftRing != null && this.leftRing.suitID == n2) {
            ++n3;
        }
        if (this.rightRing != null && this.rightRing.suitID == n2) {
            ++n3;
        }
        return n3;
    }

    public int getSuitParam(Equipment equipment, int n2) {
        if (equipment.suitID == 0) {
            return 0;
        }
        int n3 = this.getSuitCount(equipment.suitID);
        if (n3 <= 1) {
            return 0;
        }
        int n4 = 0;
        int n5 = 1;
        while (n5 < n3) {
            if (equipment.suitParamTypes[n5 - 1] == n2) {
                n4 += equipment.suitParamValues[n5 - 1];
            }
            ++n5;
        }
        return n4;
    }

    public int getSuitParam(Weapon weapon, int n2) {
        if (weapon.suitID == 0) {
            return 0;
        }
        int n3 = this.getSuitCount(weapon.suitID);
        if (n3 <= 1) {
            return 0;
        }
        int n4 = 0;
        int n5 = 1;
        while (n5 < n3) {
            if (weapon.suitParamTypes[n5 - 1] == n2) {
                n4 += weapon.suitParamValues[n5 - 1];
            }
            ++n5;
        }
        return n4;
    }

    public String checkEquipment(Hero hero, Equipment equipment) {
        if (equipment.requiredRace != hero.race) {
            return "\u804c\u4e1a\u4e0d\u7b26";
        }
        if (equipment.requiredLevel > hero.level) {
            return "\u7b49\u7ea7\u4e0d\u591f";
        }
        if (equipment.requiredTurn > hero.turns) {
            return "\u8f6c\u751f\u4e0d\u591f";
        }
        return "";
    }

    public Depot() {
        Object var2_1 = null;
        this.goodsList = new Goods[96];
    }

    public int getMinPhysicalDamage() {
        int n2 = 0;
        if (this.weapon != null) {
            n2 += this.weapon.minPhysicalDamage + this.weapon.extraMinPhysicalDamage;
        }
        return n2 += this.getSuitParam(1);
    }

    public int getPhysicalDefense(Hero hero) {
        return this.getPhysicalDefense(hero, false);
    }

    public int getPhysicalDefense(Hero hero, boolean bl) {
        int n2;
        int n3;
        int n4 = 0;
        if (this.armor != null) {
            n4 = bl ? (n4 += (int)((float)(this.armor.physicalDefense + this.armor.extraPhysicalDefense) * (0.1f * (1.0f + (float)this.armor.quality * 0.15f)))) : (n4 += this.armor.physicalDefense + this.armor.extraPhysicalDefense);
        }
        if (this.helmet != null) {
            n4 = bl ? (n4 += (int)((float)(this.helmet.physicalDefense + this.helmet.extraPhysicalDefense) * (0.1f * (1.0f + (float)this.helmet.quality * 0.15f)))) : (n4 += this.helmet.physicalDefense + this.helmet.extraPhysicalDefense);
        }
        if (this.boots != null) {
            n4 = bl ? (n4 += (int)((float)(this.boots.physicalDefense + this.boots.extraPhysicalDefense) * (0.1f * (1.0f + (float)this.boots.quality * 0.15f)))) : (n4 += this.boots.physicalDefense + this.boots.extraPhysicalDefense);
        }
        if (this.shield != null) {
            n4 = bl ? (n4 += (int)((float)(this.shield.physicalDefense + this.shield.extraPhysicalDefense) * (0.1f * (1.0f + (float)this.shield.quality * 0.15f)))) : (n4 += this.shield.physicalDefense + this.shield.extraPhysicalDefense);
        }
        if (this.leftRing != null) {
            n4 = bl ? (n4 += (int)((float)(this.leftRing.physicalDefense + this.leftRing.extraPhysicalDefense) * (0.1f * (1.0f + (float)this.leftRing.quality * 0.15f)))) : (n4 += this.leftRing.physicalDefense + this.leftRing.extraPhysicalDefense);
        }
        if (this.rightRing != null) {
            n4 = bl ? (n4 += (int)((float)(this.rightRing.physicalDefense + this.rightRing.extraPhysicalDefense) * (0.1f * (1.0f + (float)this.rightRing.quality * 0.15f)))) : (n4 += this.rightRing.physicalDefense + this.rightRing.extraPhysicalDefense);
        }
        if (this.leftEarbob != null) {
            n4 = bl ? (n4 += (int)((float)(this.leftEarbob.physicalDefense + this.leftEarbob.extraPhysicalDefense) * (0.1f * (1.0f + (float)this.leftEarbob.quality * 0.15f)))) : (n4 += this.leftEarbob.physicalDefense + this.leftEarbob.extraPhysicalDefense);
        }
        if (this.rightEarbob != null) {
            n4 = bl ? (n4 += (int)((float)(this.rightEarbob.physicalDefense + this.rightEarbob.extraPhysicalDefense) * (0.1f * (1.0f + (float)this.rightEarbob.quality * 0.15f)))) : (n4 += this.rightEarbob.physicalDefense + this.rightEarbob.extraPhysicalDefense);
        }
        n4 = bl ? (n4 += this.getSuitParam(5) / 10) : (n4 += this.getSuitParam(5));
        if (bl) {
            n3 = n4;
        } else {
            int n5 = 0;
            if (this.armor != null) {
                n5 += this.armor.pdLevelFactor * hero.level / 10;
                n5 += this.armor.pdStrengthFactor * hero.strength / 100;
                n5 += this.armor.pdDexterityFactor * hero.dexterity / 100;
                n5 += this.armor.pdWisdomFactor * hero.wisdom / 100;
            }
            if (this.helmet != null) {
                n5 += this.helmet.pdLevelFactor * hero.level / 10;
                n5 += this.helmet.pdStrengthFactor * hero.strength / 100;
                n5 += this.helmet.pdDexterityFactor * hero.dexterity / 100;
                n5 += this.helmet.pdWisdomFactor * hero.wisdom / 100;
            }
            if (this.boots != null) {
                n5 += this.boots.pdLevelFactor * hero.level / 10;
                n5 += this.boots.pdStrengthFactor * hero.strength / 100;
                n5 += this.boots.pdDexterityFactor * hero.dexterity / 100;
                n5 += this.boots.pdWisdomFactor * hero.wisdom / 100;
            }
            if (this.shield != null) {
                n5 += this.shield.pdLevelFactor * hero.level / 10;
                n5 += this.shield.pdStrengthFactor * hero.strength / 100;
                n5 += this.shield.pdDexterityFactor * hero.dexterity / 100;
                n5 += this.shield.pdWisdomFactor * hero.wisdom / 100;
            }
            n3 = n2 = n4 + n5;
        }
        if (this.title != null) {
            n2 += bl ? (int)((float)(this.title.physicalDefense + this.title.extraPhysicalDefense) * (0.1f * (1.0f + (float)this.title.quality * 0.15f))) : this.title.physicalDefense + this.title.extraPhysicalDefense;
        }
        int n6 = n2;
        if (this.aura != null) {
            n6 += bl ? (int)((float)(this.aura.physicalDefense + this.aura.extraPhysicalDefense) * (0.1f * (1.0f + (float)this.aura.quality * 0.15f))) : this.aura.physicalDefense + this.aura.extraPhysicalDefense;
        }
        return n6;
    }

    public int getLifeRaised() {
        return this.getLifeRaised(false);
    }

    public int getLifeRaised(boolean bl) {
        int n2 = 0;
        if (this.armor != null) {
            n2 = bl ? (n2 += (int)((float)this.armor.lifeRaised * 0.3f * (1.0f + (float)this.armor.quality * 0.15f))) : (n2 += this.armor.lifeRaised);
        }
        if (this.helmet != null) {
            n2 = bl ? (n2 += (int)((float)this.helmet.lifeRaised * 0.3f * (1.0f + (float)this.helmet.quality * 0.15f))) : (n2 += this.helmet.lifeRaised);
        }
        if (this.boots != null) {
            n2 = bl ? (n2 += (int)((float)this.boots.lifeRaised * 0.3f * (1.0f + (float)this.boots.quality * 0.15f))) : (n2 += this.boots.lifeRaised);
        }
        if (this.shield != null) {
            n2 = bl ? (n2 += (int)((float)this.shield.lifeRaised * 0.3f * (1.0f + (float)this.shield.quality * 0.15f))) : (n2 += this.shield.lifeRaised);
        }
        if (this.leftEarbob != null) {
            n2 = bl ? (n2 += (int)((float)this.leftEarbob.lifeRaised * 0.3f * (1.0f + (float)this.leftEarbob.quality * 0.15f))) : (n2 += this.leftEarbob.lifeRaised);
        }
        if (this.rightEarbob != null) {
            n2 = bl ? (n2 += (int)((float)this.rightEarbob.lifeRaised * 0.3f * (1.0f + (float)this.rightEarbob.quality * 0.15f))) : (n2 += this.rightEarbob.lifeRaised);
        }
        if (this.necklace != null) {
            n2 = bl ? (n2 += (int)((float)this.necklace.lifeRaised * 0.3f * (1.0f + (float)this.necklace.quality * 0.15f))) : (n2 += this.necklace.lifeRaised);
        }
        if (this.leftRing != null) {
            n2 = bl ? (n2 += (int)((float)this.leftRing.lifeRaised * 0.3f * (1.0f + (float)this.leftRing.quality * 0.15f))) : (n2 += this.leftRing.lifeRaised);
        }
        if (this.rightRing != null) {
            n2 = bl ? (n2 += (int)((float)this.rightRing.lifeRaised * 0.3f * (1.0f + (float)this.rightRing.quality * 0.15f))) : (n2 += this.rightRing.lifeRaised);
        }
        n2 = bl ? (n2 += this.getSuitParam(3) / 2) : (n2 += this.getSuitParam(3));
        int n3 = n2;
        if (this.title != null) {
            n3 += bl ? (int)((float)this.title.lifeRaised * 0.3f * (1.0f + (float)this.title.quality * 0.15f)) : this.title.lifeRaised;
        }
        int n4 = n3;
        if (this.aura != null) {
            n4 += bl ? (int)((float)this.aura.lifeRaised * 0.3f * (1.0f + (float)this.aura.quality * 0.15f)) : this.aura.lifeRaised;
        }
        return n4;
    }

    public void readEquipments(e e2) {
        if (e2.c()) {
            this.fashion = new Fashion();
            this.fashion.readFrom(e2);
        }
        if (e2.c()) {
            this.helmet = new Equipment();
            this.helmet.readFrom(e2);
        }
        if (e2.c()) {
            this.armor = new Equipment();
            this.armor.readFrom(e2);
        }
        if (e2.c()) {
            this.boots = new Equipment();
            this.boots.readFrom(e2);
        }
        if (e2.c()) {
            this.weapon = new Weapon();
            this.weapon.readFrom(e2);
        }
        if (e2.c()) {
            this.shield = new Equipment();
            this.shield.readFrom(e2);
        }
        if (e2.c()) {
            this.leftEarbob = new Decoration();
            this.leftEarbob.readFrom(e2);
        }
        if (e2.c()) {
            this.rightEarbob = new Decoration();
            this.rightEarbob.readFrom(e2);
        }
        if (e2.c()) {
            this.necklace = new Decoration();
            this.necklace.readFrom(e2);
        }
        if (e2.c()) {
            this.leftRing = new Decoration();
            this.leftRing.readFrom(e2);
        }
        if (e2.c()) {
            this.rightRing = new Decoration();
            this.rightRing.readFrom(e2);
        }
        Object var3_2 = null;
        if (e2.c()) {
            this.title = new Decoration();
            this.title.readFrom(e2);
        }
        Object var5_3 = null;
        if (e2.c()) {
            this.aura = new Decoration();
            this.aura.readFrom(e2);
        }
    }

    public int getGoodsPosByID(int n2) {
        int n3 = 0;
        while (n3 < this.goodsList.length) {
            if (this.goodsList[n3] != null && this.goodsList[n3].id == n2) {
                return n3;
            }
            ++n3;
        }
        return -1;
    }

    public int getAttackDelay() {
        int n2 = 0;
        if (this.weapon != null) {
            n2 = this.weapon.attackDelay;
        }
        return n2;
    }

    public int getPhysicalDamageAddition(Hero hero) {
        int n2 = 0;
        if (this.weapon != null) {
            n2 += this.weapon.pdLevelFactor * hero.level / 10;
            n2 += this.weapon.pdStrengthFactor * hero.strength / 100;
            n2 += this.weapon.pdDexterityFactor * hero.dexterity / 100;
            n2 += this.weapon.pdWisdomFactor * hero.wisdom / 100;
        }
        return n2;
    }

    public int getHittingAbility() {
        int n2 = 0;
        if (this.weapon != null) {
            n2 += this.weapon.hittingAbility;
        }
        if (this.leftEarbob != null) {
            n2 += this.leftEarbob.hittingAbility;
        }
        if (this.rightEarbob != null) {
            n2 += this.rightEarbob.hittingAbility;
        }
        if (this.necklace != null) {
            n2 += this.necklace.hittingAbility;
        }
        if (this.leftRing != null) {
            n2 += this.leftRing.hittingAbility;
        }
        if (this.rightRing != null) {
            n2 += this.rightRing.hittingAbility;
        }
        int n3 = n2 += this.getSuitParam(8);
        if (this.title != null) {
            n3 += this.title.hittingAbility;
        }
        int n4 = n3;
        if (this.aura != null) {
            n4 += this.aura.hittingAbility;
        }
        return n4;
    }

    public int getSpecialAbility() {
        int n2 = 0;
        if (this.leftEarbob != null) {
            n2 |= this.leftEarbob.specialAbility;
        }
        if (this.rightEarbob != null) {
            n2 |= this.rightEarbob.specialAbility;
        }
        if (this.necklace != null) {
            n2 |= this.necklace.specialAbility;
        }
        if (this.leftRing != null) {
            n2 |= this.leftRing.specialAbility;
        }
        if (this.rightRing != null) {
            n2 |= this.rightRing.specialAbility;
        }
        int n3 = n2;
        if (this.title != null) {
            n3 |= this.title.specialAbility;
        }
        int n4 = n3;
        if (this.aura != null) {
            n4 |= this.aura.specialAbility;
        }
        return n4;
    }

    public String checkDecoration(Hero hero, Decoration decoration) {
        if (decoration.requiredLevel > hero.level) {
            return "\u7b49\u7ea7\u4e0d\u591f";
        }
        if (decoration.requiredTurn > hero.turns) {
            return "\u8f6c\u751f\u4e0d\u591f";
        }
        return "";
    }

    public int getDoubleDamageRate() {
        int n2 = 0;
        if (this.weapon != null) {
            n2 += this.weapon.doubleDamageRate;
        }
        if (this.necklace != null) {
            n2 += this.necklace.doubleDamageRate;
        }
        int n3 = n2;
        if (this.title != null) {
            n3 += this.title.doubleDamageRate;
        }
        int n4 = n3;
        if (this.aura != null) {
            n4 += this.aura.doubleDamageRate;
        }
        return n4;
    }

    public Equipment equipEquipment(Equipment equipment) {
        Equipment equipment2 = this.unequipEquipment(equipment.eType);
        switch (equipment.eType) {
            case 1: {
                this.armor = equipment;
                break;
            }
            case 3: {
                this.boots = equipment;
                break;
            }
            case 2: {
                this.helmet = equipment;
                break;
            }
            case 4: {
                this.shield = equipment;
                break;
            }
        }
        return equipment2;
    }

    public void writeEquipments(e e2) {
        e2.a(this.fashion != null);
        if (this.fashion != null) {
            this.fashion.writeTo(e2);
        }
        e2.a(this.helmet != null);
        if (this.helmet != null) {
            this.helmet.writeTo(e2);
        }
        e2.a(this.armor != null);
        if (this.armor != null) {
            this.armor.writeTo(e2);
        }
        e2.a(this.boots != null);
        if (this.boots != null) {
            this.boots.writeTo(e2);
        }
        e2.a(this.weapon != null);
        if (this.weapon != null) {
            this.weapon.writeTo(e2);
        }
        e2.a(this.shield != null);
        if (this.shield != null) {
            this.shield.writeTo(e2);
        }
        e2.a(this.leftEarbob != null);
        if (this.leftEarbob != null) {
            this.leftEarbob.writeTo(e2);
        }
        e2.a(this.rightEarbob != null);
        if (this.rightEarbob != null) {
            this.rightEarbob.writeTo(e2);
        }
        e2.a(this.necklace != null);
        if (this.necklace != null) {
            this.necklace.writeTo(e2);
        }
        e2.a(this.leftRing != null);
        if (this.leftRing != null) {
            this.leftRing.writeTo(e2);
        }
        e2.a(this.rightRing != null);
        if (this.rightRing != null) {
            this.rightRing.writeTo(e2);
        }
        Object var3_2 = null;
        e2.a(this.title != null);
        if (this.title != null) {
            this.title.writeTo(e2);
        }
        Object var5_3 = null;
        e2.a(this.aura != null);
        if (this.aura != null) {
            this.aura.writeTo(e2);
        }
    }

    public int getMagicDamageAddition(Hero hero) {
        int n2 = 0;
        if (this.weapon != null) {
            n2 += this.weapon.mdLevelFactor * hero.level / 10;
            n2 += this.weapon.mdStrengthFactor * hero.strength / 100;
            n2 += this.weapon.mdDexterityFactor * hero.dexterity / 100;
            n2 += this.weapon.mdWisdomFactor * hero.wisdom / 100;
        }
        return n2;
    }
}

