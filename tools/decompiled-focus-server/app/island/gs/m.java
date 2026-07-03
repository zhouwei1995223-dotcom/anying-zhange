/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs;

import app.island.GameObject;
import app.island.data.Book;
import app.island.data.Decoration;
import app.island.data.Equipment;
import app.island.data.Fashion;
import app.island.data.Goods;
import app.island.data.GoodsFormula;
import app.island.data.Material;
import app.island.data.Medicine;
import app.island.data.SpecialProperty;
import app.island.data.Spell;
import app.island.data.Weapon;
import app.island.entity.Hero;
import app.island.entity.SceneObject;
import app.island.entity.Sign;
import app.island.gs.ServerInfo;
import app.island.gs.b;
import app.island.gs.c.g;
import app.island.gs.data.BetData;
import app.island.gs.data.IncreaseConfig;
import app.island.gs.data.PlunderData;
import app.island.gs.data.RefineConfig;
import app.island.gs.e;
import app.island.gs.h;
import app.island.gs.i;
import app.island.gs.p;
import app.island.gs.u;
import app.island.gs.w;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class m {
    private u a;

    public boolean a(h h2, int n2, int n3) {
        Hero hero = h2.r();
        if (n2 < 0 || n2 >= hero.personalDepot.goodsList.length) {
            return false;
        }
        Goods goods = hero.personalDepot.goodsList[n2];
        if (goods == null || goods.goodsType != 3) {
            return false;
        }
        Decoration decoration = (Decoration)goods;
        String string = hero.personalDepot.checkDecoration(hero, decoration);
        if (string.length() > 0) {
            h2.new("\u88c5\u5907[" + decoration.name + "]\u5931\u8d25\uff1a" + string);
            return false;
        }
        Decoration decoration2 = hero.personalDepot.equipDecoration(decoration, n3);
        hero.calculateProperties();
        hero.personalDepot.goodsList[n2] = decoration2;
        h2.a(p.i(n2, n3));
        h2.a(decoration2, decoration);
        return true;
    }

    public void a(h h2) {
        if (!h2.g()) {
            return;
        }
        Hero hero = h2.r();
        int n2 = hero.personalDepot.getNextFreePos();
        if (n2 < 0) {
            h2.new("\u80cc\u5305\u4e2d\u6ca1\u6709\u7a7a\u95f2\u7684\u4f4d\u7f6e\u4e86\uff01");
            return;
        }
        Weapon weapon = hero.personalDepot.unequipWeapon();
        if (weapon == null) {
            return;
        }
        hero.calculateProperties();
        hero.personalDepot.goodsList[n2] = weapon;
        h2.a(p.g());
        h2.a(weapon, null);
    }

    private boolean a(h h2, Weapon weapon, int n2) {
        Hero hero = h2.r();
        String string = hero.personalDepot.checkWeapon(hero, weapon);
        if (string.length() > 0) {
            h2.new("\u88c5\u5907[" + weapon.name + "]\u5931\u8d25\uff1a" + string);
            return false;
        }
        Weapon weapon2 = hero.personalDepot.equipWeapon(weapon);
        hero.calculateProperties();
        hero.personalDepot.goodsList[n2] = weapon2;
        h2.a(p.b(n2));
        h2.a(weapon2, weapon);
        return true;
    }

    public String a(h h2, int n2, Goods[] goodsArray, Goods[] goodsArray2) {
        if (n2 == 0) {
            return this.try(h2, goodsArray, goodsArray2);
        }
        if (n2 == 1) {
            return this.new(h2, goodsArray, goodsArray2);
        }
        if (n2 == 2) {
            return this.byte(h2, goodsArray, goodsArray2);
        }
        if (n2 == 3) {
            return this.if(h2, goodsArray, goodsArray2);
        }
        if (n2 == 4) {
            return this.a(h2, goodsArray, goodsArray2);
        }
        return "\u672a\u77e5\u7684\u5904\u7406\u7c7b\u578b\uff1a" + n2;
    }

    public String a(h h2, Goods[] goodsArray, Goods[] goodsArray2) {
        GoodsFormula goodsFormula = w.case().a(goodsArray);
        if (goodsFormula == null) {
            return "\u6ca1\u6709\u4e0e\u4e4b\u5339\u914d\u7684\u7269\u54c1\u5408\u6210\u914d\u65b9";
        }
        int n2 = (int)(Math.random() * 100.0);
        int n3 = 0;
        if (n2 < goodsFormula.rates[0]) {
            n3 = goodsFormula.targetGoods[0];
        } else if (n2 < goodsFormula.rates[1]) {
            n3 = goodsFormula.targetGoods[1];
        } else if (n2 < goodsFormula.rates[2]) {
            n3 = goodsFormula.targetGoods[2];
        }
        if (n3 == 0) {
            return "\u65e0\u6cd5\u627e\u5230\u5408\u6210\u7684\u7269\u54c1";
        }
        Hero hero = h2.r();
        if (hero.personalDepot.money < goodsFormula.poundage) {
            return "\u4f60\u8eab\u4e0a\u7684\u91d1\u5e01\u4e0d\u591f\u624b\u7eed\u8d39\uff0c\u9700\u8981" + goodsFormula.poundage;
        }
        Goods goods = w.case().getGoods(n3);
        if (goods == null) {
            return "\u627e\u4e0d\u5230\u5408\u6210\u7684\u7269\u54c1\uff1a" + n3;
        }
        int n4 = 0;
        while (n4 < goodsArray.length) {
            goodsArray[n4] = null;
            ++n4;
        }
        hero.personalDepot.money -= goodsFormula.poundage;
        h2.a(p.case(hero));
        goodsArray2[0] = (Goods)GameObject.cloneObject(goods);
        this.a.do().a(goodsArray2[0]);
        if (goodsArray2[0] != null) {
            h2.for("\u5408\u6210\u88c5\u5907\u6210\u529f\uff0c\u5f97\u5230" + goodsArray2[0].name);
        }
        return "";
    }

    public String int(h h2, Goods[] goodsArray, Goods[] goodsArray2) {
        GoodsFormula goodsFormula = w.case().a(goodsArray);
        if (goodsFormula == null) {
            return "\u6ca1\u6709\u4e0e\u4e4b\u5339\u914d\u7684\u7269\u54c1\u5408\u6210\u914d\u65b9";
        }
        int n2 = (int)(Math.random() * 100.0);
        int n3 = 0;
        if (n2 < goodsFormula.rates[0]) {
            n3 = goodsFormula.targetGoods[0];
        } else if (n2 < goodsFormula.rates[1]) {
            n3 = goodsFormula.targetGoods[1];
        } else if (n2 < goodsFormula.rates[2]) {
            n3 = goodsFormula.targetGoods[2];
        }
        if (n3 == 0) {
            return "\u65e0\u6cd5\u627e\u5230\u5408\u6210\u7684\u7269\u54c1";
        }
        Hero hero = h2.r();
        if (hero.personalDepot.money < goodsFormula.poundage) {
            return "\u4f60\u8eab\u4e0a\u7684\u91d1\u5e01\u4e0d\u591f\u624b\u7eed\u8d39\uff0c\u9700\u8981" + goodsFormula.poundage;
        }
        Goods goods = w.case().getGoods(n3);
        if (goods == null) {
            return "\u627e\u4e0d\u5230\u5408\u6210\u7684\u7269\u54c1\uff1a" + n3;
        }
        if (h2.r >= 0) {
            Goods goods2 = h2.r().personalDepot.goodsList[h2.r];
            if (goods2 != null && goods2 instanceof SpecialProperty && ((SpecialProperty)goods2).spType == 40 && ((SpecialProperty)goods2).parameter1 == goodsFormula.id) {
                h2.long(h2.r);
            } else {
                return "\u7269\u54c1\u975e\u6b63\u786e\u5408\u6210\u5238";
            }
        }
        int n4 = 0;
        while (n4 < goodsArray.length) {
            if (goodsArray[n4] != null) {
                h2.long(h2.z[n4]);
            }
            h2.z[n4] = -1;
            goodsArray[n4] = null;
            ++n4;
        }
        ++hero.refineTimes;
        h2.j().do().a(hero, 13);
        hero.personalDepot.money -= goodsFormula.poundage;
        h2.a(p.case(hero));
        Goods goods3 = (Goods)GameObject.cloneObject(goods);
        h2.a(goods3);
        this.a.do().a(goods3);
        this.a.do().a(p.d("\u606d\u559c\u73a9\u5bb6 " + hero.name + " \u5408\u6210\u51fa\u4e86 " + goods3.name + "!"));
        if (goods3 != null) {
            h2.for("\u5408\u6210\u88c5\u5907\u6210\u529f\uff0c\u5f97\u5230" + goods3.name);
        }
        return "";
    }

    private boolean a(h h2, Equipment equipment, int n2) {
        Hero hero = h2.r();
        String string = hero.personalDepot.checkEquipment(hero, equipment);
        if (string.length() > 0) {
            h2.new("\u88c5\u5907[" + equipment.name + "]\u5931\u8d25\uff1a" + string);
            return false;
        }
        Equipment equipment2 = hero.personalDepot.equipEquipment(equipment);
        hero.calculateProperties();
        hero.personalDepot.goodsList[n2] = equipment2;
        h2.a(p.k(n2));
        h2.a(equipment2, equipment);
        return true;
    }

    public String for(h h2, Goods[] goodsArray, Goods[] goodsArray2) {
        Goods goods;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        while (n6 < goodsArray.length) {
            if (goodsArray[n6] != null) {
                if (goodsArray[n6].goodsType != 8) {
                    return "\u542b\u6709\u975e\u6cd5\u7684\u7269\u54c1\uff1a" + goodsArray[n6].name;
                }
                Material material = (Material)goodsArray[n6];
                if (material.grade > 0) {
                    return "\u542b\u6709\u975e\u6cd5\u7684\u6750\u6599\uff1a" + material.name;
                }
                if (n5 != 0 && material.nextGradeID != n5) {
                    return "\u6750\u6599\u7c7b\u578b\u4e0d\u7edf\u4e00";
                }
                ++n2;
                n3 = material.poundage;
                n4 = material.upgradeRate;
                n5 = material.nextGradeID;
            }
            ++n6;
        }
        if (n2 < 4) {
            return "\u6750\u6599\u6570\u91cf\u4e0d\u8db3";
        }
        if (h2.r().personalDepot.money < n3) {
            return "\u7f3a\u5c11\u624b\u7eed\u8d39";
        }
        Hero hero = h2.r();
        ++hero.refineTimes;
        h2.j().do().a(hero, 13);
        h2.r().personalDepot.money -= n3;
        h2.a(p.case(h2.r()));
        int n7 = 0;
        while (n7 < goodsArray.length) {
            goodsArray[n7] = null;
            ++n7;
        }
        if (Math.random() * 100.0 < (double)n4 && (goods = Goods.getGlobalGoods(n5)) != null) {
            goodsArray2[0] = (Goods)GameObject.cloneObject(goods);
            this.a.do().a(goodsArray2[0]);
        }
        if (goodsArray2[0] != null) {
            h2.for("\u6750\u6599\u5408\u6210\u6210\u529f\uff0c\u5f97\u5230" + goodsArray2[0].name);
        } else {
            h2.for("\u6750\u6599\u5408\u6210\u5931\u8d25\uff01");
        }
        return "";
    }

    private boolean a(h h2, Medicine medicine, int n2) {
        if (h2.i()) {
            h2.new("\u6b7b\u4ea1\u72b6\u6001\u4e0d\u80fd\u5403\u836f");
            return false;
        }
        if (!this.a.y()) {
            h2.new("\u672c\u573a\u666f\u7981\u6b62\u5403\u836f");
            return false;
        }
        if (!h2.g()) {
            h2.new("\u8fdb\u5165\u573a\u666f\u8fc7\u7a0b\u4e2d\u4e0d\u80fd\u5403\u836f");
            return false;
        }
        if (medicine.useCount == 1) {
            h2.for(medicine.lifeCured);
            h2.do(medicine.manaCured);
        } else {
            h2.a(medicine);
        }
        h2.long(n2);
        return true;
    }

    public boolean do(h h2, int n2, int n3) {
        Hero hero = h2.r();
        if (n3 < 0 || n3 >= hero.personalDepot.goodsList.length) {
            return false;
        }
        Goods goods = hero.personalDepot.goodsList[n3];
        if (goods == null) {
            return false;
        }
        if (goods.goodsType != 5) {
            return false;
        }
        SpecialProperty specialProperty = (SpecialProperty)goods;
        if (specialProperty.spType != 16) {
            return false;
        }
        Spell spell = hero.spellList.getSpell(n2);
        if (spell == null) {
            return false;
        }
        spell.experience += specialProperty.parameter1;
        hero.personalDepot.goodsList[n3] = null;
        h2.a(p.try(spell.id, n3));
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private String try(h h2, Goods[] goodsArray, Goods[] goodsArray2) {
        int n2;
        Material material = null;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        boolean bl = true;
        boolean bl2 = false;
        int n7 = 0;
        while (n7 < goodsArray.length) {
            if (goodsArray[n7] != null) {
                if (goodsArray[n7] instanceof Equipment) {
                    n4 = 1;
                    n3 = goodsArray[n7].id;
                    n6 = ((Equipment)goodsArray[n7]).increaseCost;
                    n5 = ((Equipment)goodsArray[n7]).requiredLevel;
                } else if (goodsArray[n7] instanceof Weapon) {
                    n4 = 0;
                    n3 = goodsArray[n7].id;
                    n6 = ((Weapon)goodsArray[n7]).increaseCost;
                    n5 = ((Weapon)goodsArray[n7]).requiredLevel;
                } else if (goodsArray[n7] instanceof Decoration) {
                    n4 = 2;
                    n3 = goodsArray[n7].id;
                    n6 = ((Decoration)goodsArray[n7]).increaseCost;
                    n5 = ((Decoration)goodsArray[n7]).requiredLevel;
                } else if (goodsArray[n7] instanceof Material) {
                    Material material2 = (Material)goodsArray[n7];
                    if (material2.function != 1) return "\u4e0d\u652f\u6301\u5728\u51b2\u7b49\u4e2d\u4f7f\u7528\u6b64\u6750\u6599\uff1a" + goodsArray[n7].name;
                    material = (Material)goodsArray[n7];
                } else if (goodsArray[n7] instanceof SpecialProperty) {
                    SpecialProperty specialProperty = (SpecialProperty)goodsArray[n7];
                    if (specialProperty.spType != 14) return "\u4e0d\u652f\u6301\u5728\u51b2\u7b49\u4e2d\u4f7f\u7528\u6b64\u7269\u54c1\uff1a" + goodsArray[n7].name;
                    bl = false;
                }
            }
            ++n7;
        }
        if (n3 == 0) {
            return "\u8bf7\u653e\u5165\u8981\u51b2\u7b49\u7684\u88c5\u5907";
        }
        if (material == null) {
            return "\u8bf7\u653e\u5165\u51b2\u7b49\u6240\u9700\u7684\u6750\u6599";
        }
        if (material.function != 1) {
            return "\u6ca1\u6709\u5bf9\u5e94\u7684\u51b2\u7b49\u6750\u6599";
        }
        if (material.id % 10 * 24 + 12 < n5) {
            return material.name + "\u53ea\u80fd\u7528\u4e8e" + (material.id % 10 * 24 + 12) + "\u7ea7\u4ee5\u4e0b\u7684\u88c5\u5907\u51b2\u7b49";
        }
        Hero hero = h2.r();
        if (hero.personalDepot.money < n6) {
            return "\u4f60\u8eab\u4e0a\u7684\u91d1\u5e01\u4e0d\u8db3\uff0c\u9700\u8981" + n6;
        }
        int n8 = n3 % 100;
        IncreaseConfig increaseConfig = w.case().for(n4, n5, n8);
        if (increaseConfig == null) {
            return "\u8be5\u88c5\u5907\u5df2\u5230\u8fbe\u51b2\u7b49\u6781\u9650\u4e86";
        }
        ++hero.refineTimes;
        h2.j().do().a(hero, 13);
        hero.personalDepot.money -= n6;
        h2.a(p.case(hero));
        int n9 = 0;
        int n10 = (int)(Math.random() * 100.0);
        if (n10 <= increaseConfig.successRate) {
            n2 = n8 + 1;
            n9 = n3 / 100 * 100 + n2;
            bl2 = true;
        } else if (bl) {
            n10 = (int)(Math.random() * 10000.0);
            if (n10 < increaseConfig.failRate1) {
                n9 = n3 / 100 * 100 + Math.max(n8 - 1, 0);
            } else if (n10 < increaseConfig.failRate2) {
                n9 = n3 / 100 * 100 + Math.max(n8 - 2, 0);
            } else if (n10 < increaseConfig.failRate3) {
                n9 = n3 / 100 * 100 + Math.max(n8 - 3, 0);
            } else if (n10 < increaseConfig.failRate4) {
                n9 = n3 / 100 * 100;
            }
        }
        if (n9 > 0) {
            goodsArray2[0] = Goods.getGlobalGoods(n9);
            goodsArray2[0] = (Goods)GameObject.cloneObject(goodsArray2[0]);
        }
        if (goodsArray2[0] != null) {
            this.a.do().a(goodsArray2[0]);
        }
        n2 = 0;
        while (n2 < goodsArray.length) {
            if (goodsArray[n2] == null || goodsArray[n2].id != n3 || bl || n9 != 0) {
                goodsArray[n2] = null;
            }
            ++n2;
        }
        if (bl2) {
            if (goodsArray2[0] != null) {
                if (goodsArray2[0].id % 100 >= 5) {
                    this.a.do().a(p.for(h2.b() + "\u4eba\u54c1\u679c\u7136\u51fa\u4f17,\u88c5\u5907\u300e" + goodsArray2[0].name + "\u300f\u51b2\u7b49\u6210\u529f!", -1186560));
                }
                h2.for("\u51b2\u7b49\u6210\u529f\uff0c\u5f97\u5230" + goodsArray2[0].name);
                return "";
            } else {
                h2.for("\u51b2\u7b49\u6210\u529f\uff0c\u4f46\u662f\u65e0\u6cd5\u5f97\u5230\u76ee\u6807\u88c5\u5907");
            }
            return "";
        } else if (goodsArray2[0] != null) {
            h2.for("\u51b2\u7b49\u5931\u8d25\uff0c\u539f\u88c5\u5907\u53d8\u4e3a" + goodsArray2[0].name);
            return "";
        } else if (bl) {
            h2.for("\u7cbe\u70bc\u5931\u8d25\uff0c\u539f\u88c5\u5907\u88ab\u9500\u6bc1");
            return "";
        } else {
            h2.for("\u7cbe\u70bc\u5931\u8d25\uff0c\u7531\u4e8e\u7948\u7977\u5b9d\u77f3\u7684\u529f\u6548\uff0c\u539f\u88c5\u5907\u88ab\u4fdd\u7559");
        }
        return "";
    }

    public void if(h h2, int n2) {
        if (!h2.g()) {
            return;
        }
        Hero hero = h2.r();
        int n3 = hero.personalDepot.getNextFreePos();
        if (n3 < 0) {
            h2.new("\u80cc\u5305\u4e2d\u6ca1\u6709\u7a7a\u95f2\u7684\u4f4d\u7f6e\u4e86\uff01");
            return;
        }
        Equipment equipment = hero.personalDepot.unequipEquipment(n2);
        if (equipment != null) {
            hero.calculateProperties();
            hero.personalDepot.goodsList[n3] = equipment;
            h2.a(p.p(n2));
            h2.a(equipment, null);
        }
    }

    public boolean a(h h2, int n2) {
        if (!h2.g()) {
            return false;
        }
        Hero hero = h2.r();
        if (n2 < 0 || n2 >= hero.personalDepot.goodsList.length) {
            return false;
        }
        Goods goods = hero.personalDepot.goodsList[n2];
        if (goods == null) {
            h2.new("\u80cc\u5305\u8be5\u4f4d\u7f6e\u6ca1\u6709\u7269\u54c1\uff1a" + n2);
            return false;
        }
        switch (goods.goodsType) {
            case 4: {
                return this.a(h2, (Book)goods, n2);
            }
            case 2: {
                return this.a(h2, (Equipment)goods, n2);
            }
            case 1: {
                return this.a(h2, (Weapon)goods, n2);
            }
            case 3: {
                return this.a(h2, n2, 0);
            }
            case 0: {
                return this.a(h2, (Medicine)goods, n2);
            }
            case 5: {
                Goods goods2 = hero.personalDepot.goodsList[n2];
                hero.personalDepot.goodsList[n2] = null;
                if (this.a(h2, (SpecialProperty)goods)) {
                    if (hero.personalDepot.goodsList[n2] == null) {
                        h2.long(n2);
                    }
                    return true;
                }
                SpecialProperty specialProperty = (SpecialProperty)goods2;
                if (specialProperty.spType == 40) {
                    h2.r = n2;
                }
                hero.personalDepot.goodsList[n2] = goods2;
                return false;
            }
            case 6: {
                return this.a(h2, (Fashion)goods, n2);
            }
        }
        return false;
    }

    public String a(h h2, BetData betData, int n2) {
        if (betData == null) {
            return "\u6ca1\u6709\u62bd\u5956\u6570\u636e!";
        }
        Hero hero = h2.r();
        int n3 = hero.personalDepot.getNextFreePos();
        if (n3 == -1) {
            return "\u80cc\u5305\u4e2d\u6ca1\u6709\u8db3\u591f\u7684\u7a7a\u95f4,\u65e0\u6cd5\u8fdb\u884c\u62bd\u5956!";
        }
        if (n2 == 0) {
            if (hero.user.treasure < betData.treasureCost) {
                return "\u60a8\u6ca1\u6709\u8db3\u591f\u7684\u5143\u5b9d\u8fdb\u884c\u672c\u6b21\u5e78\u8fd0\u62bd\u5956\uff0c\u8bf7\u5145\u503c\u5143\u5b9d";
            }
            hero.user.treasure -= betData.treasureCost;
            hero.consumedTreasure += betData.treasureCost;
            hero.user.consumedTreasure += betData.treasureCost;
            ServerInfo.consumedTreasure += betData.treasureCost;
            h2.a(p.case(h2.r()));
        } else if (n2 == 1) {
            if (hero.personalDepot.money < betData.moneyCost) {
                return "\u60a8\u6ca1\u6709\u8db3\u591f\u7684\u91d1\u94b1\u8fdb\u884c\u672c\u6b21\u5e78\u8fd0\u62bd\u5956";
            }
            hero.personalDepot.money -= betData.moneyCost;
            h2.a(p.case(h2.r()));
        } else if (n2 == 2) {
            if (hero.arenaScores < betData.arenaScoreCost) {
                return "\u4f60\u6ca1\u6709\u8db3\u591f\u7684\u529f\u52cb\u8fdb\u884c\u672c\u6b21\u5e78\u8fd0\u62bd\u5956";
            }
            hero.arenaScores -= betData.arenaScoreCost;
            h2.a(p.i(hero.arenaScores));
        } else {
            return "\u4f60\u4f5c\u5f0a";
        }
        Goods goods = this.a.E().a(betData);
        goods = (Goods)GameObject.cloneObject(goods);
        h2.a(p.a(goods));
        hero.personalDepot.goodsList[n3] = goods;
        if (goods.treasureCost > 0) {
            // empty if block
        }
        this.a.do().long().saveUserLog(hero.user.name, hero.name, "bet", "type=" + n2 + ";treasure=" + betData.treasureCost + ";money=" + betData.moneyCost + ";arenaScores=" + betData.arenaScoreCost + ";goods=" + goods.id);
        return "";
    }

    public String do(h h2, Goods[] goodsArray, Goods[] goodsArray2) {
        SpecialProperty specialProperty = null;
        SpecialProperty specialProperty2 = null;
        if (!(goodsArray[0] instanceof SpecialProperty)) {
            return "\u6ca1\u6709\u5b9d\u7bb1";
        }
        specialProperty = (SpecialProperty)goodsArray[0];
        if (goodsArray[1] != null) {
            specialProperty2 = (SpecialProperty)goodsArray[1];
        }
        if (specialProperty.spType != 34) {
            return "\u8fd9\u4e0d\u662f\u5b9d\u7bb1";
        }
        if (specialProperty2 != null && specialProperty.parameter1 != specialProperty2.id) {
            return "\u94a5\u5319\u4e0d\u5339\u914d";
        }
        Hero hero = h2.r();
        ++hero.openBoxTimes;
        h2.j().do().a(hero, 12);
        i i2 = i.a();
        int n2 = i2.do(specialProperty, specialProperty2);
        n2 *= ServerInfo.expTimes;
        if (hero.doubleExpLifeTime > 0) {
            n2 *= 2;
        }
        int n3 = i2.if(specialProperty, specialProperty2);
        h2.int(n2);
        h2.new(n3);
        daff.a.h h3 = i2.if(h2, specialProperty, specialProperty2);
        h3.for(i2.a(h2, specialProperty, specialProperty2));
        StringBuffer stringBuffer = new StringBuffer("");
        stringBuffer.append("\u5f00\u5b9d\u7bb1\u83b7\u5f97\u7ecf\u9a8c:");
        stringBuffer.append(n2);
        stringBuffer.append(",\u91d1\u5e01:");
        stringBuffer.append(n3);
        int n4 = 0;
        while (n4 < h3.for()) {
            Goods goods = (Goods)h3.if(n4);
            goods = (Goods)GameObject.cloneObject(goods);
            stringBuffer.append(";");
            stringBuffer.append(goods.name);
            this.a.do().a(goods);
            h2.a(goods);
            int[] nArray = new int[]{-1, -13318080, -15629579, -7864065, -752332, -1186560, -65536, -1, -1};
            if (goods.quality >= 3) {
                this.a.do().a(p.for(h2.b() + "\u4eba\u54c1\u679c\u7136\u51fa\u4f17,\u5f00\u300e" + specialProperty.name + "\u300f\u83b7\u5f97\u7269\u54c1\u300e" + goods.name + "\u300f", nArray[goods.quality]));
            }
            ++n4;
        }
        stringBuffer.append(".");
        n4 = 0;
        while (n4 < goodsArray.length) {
            goodsArray[n4] = null;
            ++n4;
        }
        h2.for(stringBuffer.toString());
        return "";
    }

    public String if(h h2, Goods[] goodsArray, Goods[] goodsArray2) {
        Goods goods;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        while (n7 < goodsArray.length) {
            if (goodsArray[n7] != null) {
                if (goodsArray[n7].goodsType != 8) {
                    return "\u542b\u6709\u975e\u6cd5\u7684\u7269\u54c1\uff1a" + goodsArray[n7].name;
                }
                Material material = (Material)goodsArray[n7];
                if (material.grade == 0) {
                    return "\u542b\u6709\u975e\u6cd5\u7684\u6750\u6599\uff1a" + material.name;
                }
                if (n2 != 0 && material.id != n2) {
                    return "\u6750\u6599\u7c7b\u578b\u4e0d\u7edf\u4e00";
                }
                if (n2 == 0) {
                    n2 = material.id;
                }
                ++n3;
                n4 = material.poundage;
                n5 = material.upgradeRate;
                n6 = material.nextLevelID;
            }
            ++n7;
        }
        if (n3 < 2) {
            return "\u6750\u6599\u6570\u91cf\u4e0d\u8db3";
        }
        if (n5 <= 0 || n4 <= 0) {
            return "\u6750\u6599\u5df2\u5230\u6700\u9ad8\u7b49\u7ea7\uff0c\u65e0\u6cd5\u8fdb\u884c\u5347\u7ea7\u4e86";
        }
        if (h2.r().personalDepot.money < n4) {
            return "\u7f3a\u5c11\u624b\u7eed\u8d39";
        }
        Hero hero = h2.r();
        ++hero.refineTimes;
        h2.j().do().a(hero, 13);
        h2.r().personalDepot.money -= n4;
        h2.a(p.case(h2.r()));
        int n8 = 0;
        while (n8 < goodsArray.length) {
            goodsArray[n8] = null;
            ++n8;
        }
        if (Math.random() * 100.0 < (double)n5 && (goods = Goods.getGlobalGoods(n6)) != null) {
            goodsArray2[0] = (Goods)GameObject.cloneObject(goods);
            this.a.do().a(goodsArray2[0]);
        }
        if (goodsArray2[0] != null) {
            h2.for("\u6750\u6599\u5347\u7ea7\u6210\u529f\uff0c\u5f97\u5230" + goodsArray2[0].name);
        } else {
            h2.for("\u6750\u6599\u5347\u7ea7\u5931\u8d25\uff01");
        }
        return "";
    }

    private boolean a(h h2, Book book, int n2) {
        Hero hero = h2.r();
        if (book.requiredRace >= 0 && hero.race != book.requiredRace) {
            h2.new("\u804c\u4e1a\u4e0d\u7b26");
            return false;
        }
        if (book.requiredTurn > hero.turns) {
            h2.new("\u8f6c\u751f\u4e0d\u591f");
            return false;
        }
        if (hero.level < book.requiredLevel) {
            h2.new("\u7b49\u7ea7\u4e0d\u591f");
            return false;
        }
        if (hero.spellList.isSpellLearned(book.targetSpellID)) {
            h2.new("\u5df2\u7ecf\u62e5\u6709\u8fd9\u4e2a\u6280\u80fd\u4e86");
            return false;
        }
        if (book.sourceSpellID > 0 && hero.spellList.getSpell(book.sourceSpellID) == null && !hero.spellList.isSpellLearned(book.targetSpellID)) {
            h2.new("\u4f60\u7684\u6280\u80fd\u7b49\u7ea7\u4e0d\u591f");
            return false;
        }
        Spell spell = w.case().if(book.targetSpellID);
        if (spell == null) {
            h2.new("\u627e\u4e0d\u5230\u76ee\u6807\u6280\u80fd");
            return false;
        }
        spell = (Spell)GameObject.cloneObject(spell);
        h2.long(n2);
        h2.if(spell);
        return true;
    }

    public void a(h h2, Goods[] goodsArray, int n2) {
        GoodsFormula goodsFormula;
        int n3 = 0;
        int n4 = 0;
        String string = "";
        if (n2 == 0) {
            IncreaseConfig increaseConfig = null;
            if (goodsArray[0] instanceof Equipment) {
                increaseConfig = w.case().for(1, ((Equipment)goodsArray[0]).requiredLevel, goodsArray[0].id % 100);
                n4 = ((Equipment)goodsArray[0]).increaseCost;
            } else if (goodsArray[0] instanceof Weapon) {
                increaseConfig = w.case().for(0, ((Weapon)goodsArray[0]).requiredLevel, goodsArray[0].id % 100);
                n4 = ((Weapon)goodsArray[0]).increaseCost;
            } else if (goodsArray[0] instanceof Decoration) {
                increaseConfig = w.case().for(2, ((Decoration)goodsArray[0]).requiredLevel, goodsArray[0].id % 100);
                n4 = ((Decoration)goodsArray[0]).increaseCost;
            }
            if (increaseConfig != null) {
                n3 = increaseConfig.successRate;
                string = w.case().getGoods((int)(goodsArray[0].id + 1)).name;
            }
        } else if (n2 == 1) {
            if (goodsArray[0] instanceof Equipment) {
                n4 = ((Equipment)goodsArray[0]).refineCost;
                n3 = ((Equipment)goodsArray[0]).refineRate;
            } else if (goodsArray[0] instanceof Weapon) {
                n4 = ((Weapon)goodsArray[0]).refineCost;
                n3 = ((Weapon)goodsArray[0]).refineRate;
            } else if (goodsArray[0] instanceof Decoration) {
                n4 = ((Decoration)goodsArray[0]).refineCost;
                n3 = ((Decoration)goodsArray[0]).refineRate;
            }
        } else if (n2 == 2) {
            n3 = 100;
            int n5 = 0;
            while (n5 < goodsArray.length) {
                int n6;
                int n7;
                Goods goods;
                if ((goodsArray[n5] instanceof Equipment || goodsArray[n5] instanceof Weapon || goodsArray[n5] instanceof Decoration) && (goods = Goods.getGlobalGoods(n7 = ((n6 = goodsArray[n5].id) / 100 + 1) * 100 + n6 % 100)) != null) {
                    n4 = goods.treasureCost - goodsArray[n5].treasureCost;
                    string = goods.name;
                }
                ++n5;
            }
        } else if (n2 == 3) {
            int n8 = 0;
            while (n8 < goodsArray.length) {
                if (goodsArray[n8] instanceof Material) {
                    Material material = (Material)goodsArray[n8];
                    if (material.grade > 0) {
                        n4 = material.poundage;
                        n3 = material.upgradeRate;
                        Goods goods = w.case().getGoods(material.nextLevelID);
                        if (goods != null) {
                            string = goods.name;
                        }
                    }
                }
                ++n8;
            }
        } else if (n2 == 4 && (goodsFormula = w.case().a(goodsArray)) != null) {
            n3 = 100;
            n4 = goodsFormula.poundage;
            string = goodsFormula.name;
        }
        h2.a(p.if(n3, n4, string));
    }

    public u a() {
        return this.a;
    }

    public void a(u u2) {
        this.a = u2;
    }

    public void if(h h2, int n2, int n3) {
        if (!h2.g()) {
            return;
        }
        Hero hero = h2.r();
        int n4 = hero.personalDepot.getNextFreePos();
        if (n4 < 0) {
            h2.new("\u80cc\u5305\u4e2d\u6ca1\u6709\u7a7a\u95f2\u7684\u4f4d\u7f6e\u4e86\uff01");
            return;
        }
        Decoration decoration = hero.personalDepot.unequipDecoration(n2, n3);
        if (decoration == null) {
            return;
        }
        hero.calculateProperties();
        hero.personalDepot.goodsList[n4] = decoration;
        h2.a(p.g(n2, n3));
        h2.a(decoration, null);
    }

    public void if() {
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private String new(h h2, Goods[] goodsArray, Goods[] goodsArray2) {
        int n2;
        void var5_6;
        Material material = null;
        Object var5_5 = null;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        boolean bl = true;
        boolean bl2 = false;
        int n7 = 0;
        while (n7 < goodsArray.length) {
            if (goodsArray[n7] != null) {
                if (goodsArray[n7] instanceof Equipment) {
                    n3 = goodsArray[n7].id;
                    n5 = ((Equipment)goodsArray[n7]).refineCost;
                    n4 = ((Equipment)goodsArray[n7]).requiredLevel;
                    n6 = ((Equipment)goodsArray[n7]).refineRate;
                } else if (goodsArray[n7] instanceof Weapon) {
                    n3 = goodsArray[n7].id;
                    n5 = ((Weapon)goodsArray[n7]).refineCost;
                    n4 = ((Weapon)goodsArray[n7]).requiredLevel;
                    n6 = ((Weapon)goodsArray[n7]).refineRate;
                } else if (goodsArray[n7] instanceof Decoration) {
                    n3 = goodsArray[n7].id;
                    n5 = ((Decoration)goodsArray[n7]).refineCost;
                    n4 = ((Decoration)goodsArray[n7]).requiredLevel;
                    n6 = ((Decoration)goodsArray[n7]).refineRate;
                } else if (goodsArray[n7] instanceof Material) {
                    Material material2 = (Material)goodsArray[n7];
                    if (material2.function == 2) {
                        material = material2;
                    } else {
                        if (material2.function != 3) return "\u4e0d\u652f\u6301\u5728\u7cbe\u70bc\u4e2d\u4f7f\u7528\u6b64\u6750\u6599\uff1a" + material2.name;
                        Material material3 = material2;
                    }
                } else if (goodsArray[n7] instanceof SpecialProperty) {
                    SpecialProperty specialProperty = (SpecialProperty)goodsArray[n7];
                    if (specialProperty.spType != 14) return "\u4e0d\u652f\u6301\u5728\u7cbe\u70bc\u4e2d\u4f7f\u7528\u6b64\u7269\u54c1\uff1a" + specialProperty.name;
                    bl = false;
                }
            }
            ++n7;
        }
        if (n3 == 0) {
            return "\u8bf7\u653e\u5165\u8981\u7cbe\u70bc\u7684\u88c5\u5907";
        }
        if (n6 <= 0 || n5 <= 0) {
            return "\u8be5\u88c5\u5907\u65e0\u6cd5\u7ee7\u7eed\u7cbe\u70bc\u4e86";
        }
        n7 = n3 / 10000 % 10;
        if (n7 >= 4) {
            return "\u4e0d\u80fd\u5bf9\u8be5\u54c1\u8d28\u7684\u88c5\u5907\u8fdb\u884c\u7cbe\u70bc";
        }
        if (material == null) {
            return "\u7cbe\u70bc\u6240\u9700\u7684\u6750\u6599\u4e0d\u8db3";
        }
        if (var5_6 == null) {
            return "\u7cbe\u70bc\u6240\u9700\u7684\u6750\u6599\u4e0d\u8db3";
        }
        if (material.id % 10 * 24 + 12 < n4) {
            return material.name + "\u53ea\u80fd\u7528\u4e8e" + (material.id % 10 * 24 + 12) + "\u7ea7\u4ee5\u4e0b\u7684\u88c5\u5907\u7cbe\u70bc";
        }
        if (var5_6.quality < n7) {
            return var5_6.name + "\u7684\u54c1\u8d28\u4e0d\u591f\uff0c\u4e0d\u80fd\u5bf9\u8be5\u88c5\u5907\u7cbe\u70bc";
        }
        Hero hero = h2.r();
        if (hero.personalDepot.money < n5) {
            return "\u4f60\u8eab\u4e0a\u7684\u91d1\u5e01\u4e0d\u8db3\uff0c\u9700\u8981" + n5;
        }
        int n8 = n3 % 100;
        if (n7 == 0 && n8 < 3) {
            return "\u88c5\u5907\u7684\u51b2\u7b49\u4e0d\u7b26\u5408\u7cbe\u70bc\u8981\u6c42\uff0c\u9700\u8981+3";
        }
        if (n7 == 1 && n8 < 4) {
            return "\u88c5\u5907\u7684\u51b2\u7b49\u4e0d\u7b26\u5408\u7cbe\u70bc\u8981\u6c42\uff0c\u9700\u8981+4";
        }
        if (n7 == 2 && n8 < 5) {
            return "\u88c5\u5907\u7684\u51b2\u7b49\u4e0d\u7b26\u5408\u7cbe\u70bc\u8981\u6c42\uff0c\u9700\u8981+5";
        }
        if (n7 == 3 && n8 < 7) {
            return "\u88c5\u5907\u7684\u51b2\u7b49\u4e0d\u7b26\u5408\u7cbe\u70bc\u8981\u6c42\uff0c\u9700\u8981+7";
        }
        RefineConfig refineConfig = w.case().a(n4, n7);
        if (refineConfig == null) {
            return "\u8be5\u88c5\u5907\u65e0\u6cd5\u7ee7\u7eed\u7cbe\u70bc\u4e86";
        }
        ++hero.refineTimes;
        h2.j().do().a(hero, 13);
        hero.personalDepot.money -= n5;
        h2.a(p.case(hero));
        int n9 = 0;
        int n10 = (int)(Math.random() * 10000.0);
        if (n10 <= n6) {
            n10 = (int)(Math.random() * 10000.0);
            if (n10 < refineConfig.keepLevelRate) {
                n9 = (n3 / 10000 + 1) * 10000 + n3 % 10000;
            } else if (n10 < refineConfig.clearLevelRate1) {
                n9 = (n3 / 10000 + 1) * 10000 + n3 % 10000 / 100 * 100;
            } else if (n10 < refineConfig.randomDropRate1) {
                n2 = n3 % 100;
                n2 = (int)(Math.random() * (double)n2);
                n9 = (n3 / 10000 + 1) * 10000 + n3 % 10000 / 100 * 100 + n2;
            }
            bl2 = true;
        } else if (bl) {
            n10 = (int)(Math.random() * 10000.0);
            if (n10 < refineConfig.randomDropRate2) {
                n9 = n3 / 10000 * 10000 + n3 % 10000;
            } else if (n10 < refineConfig.clearLevelRate2) {
                n9 = n3 / 10000 * 10000 + n3 % 10000 / 100 * 100;
            }
        }
        if (n9 > 0) {
            goodsArray2[0] = Goods.getGlobalGoods(n9);
            goodsArray2[0] = (Goods)GameObject.cloneObject(goodsArray2[0]);
            this.a.do().a(goodsArray2[0]);
        }
        n2 = 0;
        while (n2 < goodsArray.length) {
            if (goodsArray[n2] == null || goodsArray[n2].id != n3 || bl || n9 != 0) {
                goodsArray[n2] = null;
            }
            ++n2;
        }
        if (bl2) {
            h2.for("\u7cbe\u70bc\u6210\u529f\uff0c\u5f97\u5230" + goodsArray2[0].name);
            return "";
        } else if (goodsArray2[0] != null) {
            h2.for("\u7cbe\u70bc\u5931\u8d25\uff0c\u539f\u88c5\u5907\u53d8\u4e3a" + goodsArray2[0].name);
            return "";
        } else if (bl) {
            h2.for("\u7cbe\u70bc\u5931\u8d25\uff0c\u539f\u88c5\u5907\u88ab\u9500\u6bc1");
            return "";
        } else {
            h2.for("\u7cbe\u70bc\u5931\u8d25\uff0c\u7531\u4e8e\u7948\u7977\u5b9d\u77f3\u7684\u529f\u6548\uff0c\u539f\u88c5\u5907\u88ab\u4fdd\u7559");
        }
        return "";
    }

    private String byte(h h2, Goods[] goodsArray, Goods[] goodsArray2) {
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        while (n4 < goodsArray.length) {
            if (goodsArray[n4] != null) {
                if (goodsArray[n4] instanceof Equipment) {
                    n2 = goodsArray[n4].id;
                    n3 = ((Equipment)goodsArray[n4]).upgradeCost;
                } else if (goodsArray[n4] instanceof Weapon) {
                    n2 = goodsArray[n4].id;
                    n3 = ((Weapon)goodsArray[n4]).upgradeCost;
                } else if (goodsArray[n4] instanceof Decoration) {
                    n2 = goodsArray[n4].id;
                    n3 = ((Decoration)goodsArray[n4]).upgradeCost;
                } else {
                    return "\u4e0d\u652f\u6301\u5728\u88c5\u5907\u5347\u7ea7\u4e2d\u4f7f\u7528\u6b64\u7269\u54c1\uff1a" + goodsArray[n4].name;
                }
            }
            ++n4;
        }
        if (n2 == 0) {
            return "\u8bf7\u653e\u5165\u8981\u5347\u7ea7\u7684\u88c5\u5907";
        }
        if (n3 <= 0) {
            return "\u6b64\u88c5\u5907\u4e0d\u80fd\u8fdb\u884c\u5347\u7ea7";
        }
        n4 = (n2 / 100 + 1) * 100 + n2 % 100;
        Goods goods = Goods.getGlobalGoods(n2);
        Goods goods2 = Goods.getGlobalGoods(n4);
        if (goods2 == null) {
            return "\u6b64\u88c5\u5907\u4e0d\u80fd\u8fdb\u884c\u5347\u7ea7";
        }
        n3 = goods2.treasureCost - goods.treasureCost;
        if (n3 <= 0) {
            return "\u6b64\u88c5\u5907\u4e0d\u80fd\u8fdb\u884c\u5347\u7ea7";
        }
        Hero hero = h2.r();
        if (hero.user.treasure < n3) {
            return "\u4f60\u8d26\u53f7\u91cc\u7684\u5143\u5b9d\u4e0d\u8db3\uff0c\u9700\u8981" + n3;
        }
        ++hero.refineTimes;
        h2.j().do().a(hero, 13);
        hero.user.treasure -= n3;
        hero.user.consumedTreasure += n3;
        hero.consumedTreasure += n3;
        ServerInfo.consumedTreasure += n3;
        h2.a(p.case(hero));
        int n5 = 0;
        while (n5 < goodsArray.length) {
            goodsArray[n5] = null;
            ++n5;
        }
        goodsArray2[0] = Goods.getGlobalGoods(n4);
        goodsArray2[0] = (Goods)GameObject.cloneObject(goodsArray2[0]);
        this.a.do().a(goodsArray2[0]);
        if (goodsArray2[0] != null) {
            h2.for("\u5347\u7ea7\u6210\u529f\uff0c\u5f97\u5230" + goodsArray2[0].name);
        } else {
            h2.for("\u5347\u7ea7\u5931\u8d25\uff01");
        }
        this.a.do().long().saveUserLog(hero.user.name, hero.user.name, "upgradeEquipment", "goodsID=" + n2 + ";treasureCost=" + n3);
        return "";
    }

    private boolean a(h h2, SpecialProperty specialProperty) {
        if (!h2.g()) {
            return false;
        }
        Hero hero = h2.r();
        if (specialProperty.spType == 4) {
            if (this.a.K() == 1) {
                h2.try("\u7ade\u6280\u573a\u5185\u7981\u6b62\u4f7f\u7528\u590d\u6d3b\u836f\u6c34");
                return false;
            }
            if (hero.life <= 0) {
                int n2 = specialProperty.parameter1 * hero.maxLife / 100;
                this.a.a(h2, n2, true);
                return true;
            }
            return false;
        }
        if (!this.a.C()) {
            h2.try("\u672c\u573a\u666f\u7981\u6b62\u4f7f\u7528\u7279\u6b8a\u9053\u5177");
            return false;
        }
        if (h2.i()) {
            h2.try("\u6b7b\u4ea1\u72b6\u6001\u4e0d\u80fd\u4f7f\u7528\u9053\u5177");
            return false;
        }
        if (specialProperty.expiredTime > 0 && ServerInfo.currentTimeCode >= specialProperty.expiredTime) {
            h2.try("\u8be5\u7269\u54c1\u5df2\u7ecf\u8fc7\u671f");
            return false;
        }
        if (specialProperty.requiredLevel > hero.level) {
            h2.try("\u4f60\u9700\u8981\u8fbe\u5230" + specialProperty.requiredLevel + "\u7ea7\u4ee5\u540e\u624d\u80fd\u4f7f\u7528\u6b64\u9053\u5177");
            return false;
        }
        switch (specialProperty.spType) {
            case 1: {
                int n3 = specialProperty.parameter1;
                h2.new(n3);
                break;
            }
            case 2: {
                h2.int(specialProperty.parameter1);
                break;
            }
            case 3: {
                if (h2.D() == null) {
                    h2.long();
                    int n4 = this.a.q();
                    if (n4 == this.a.try()) {
                        int n5 = this.a.for(this.a.r(), this.a.t());
                        int n6 = n5 & 0xFFFF;
                        int n7 = n5 >> 16;
                        h2.a(p.long(n6, n7));
                        this.a.if(h2, n6, n7);
                        break;
                    }
                    this.a.do().a(h2, n4, 0, 0);
                    break;
                }
                h2.try("\u5f00\u542f\u4e2a\u4eba\u5546\u5e97\u65f6\u4e0d\u80fd\u79fb\u52a8");
                return false;
            }
            case 5: {
                int n8 = specialProperty.parameter1;
                int n9 = specialProperty.parameter2;
                int n10 = Math.max(0, hero.x - n8 / 2);
                int n11 = Math.min(hero.x + n8 / 2, this.a.x());
                int n12 = Math.max(0, hero.y - n9 / 2);
                int n13 = Math.min(hero.y + n9 / 2, this.a.M());
                int n14 = n10 + (int)(Math.random() * (double)(n11 - n10));
                int n15 = n12 + (int)(Math.random() * (double)(n13 - n12));
                int n16 = this.a.for(n14, n15);
                n14 = n16 & 0xFFFF;
                n15 = n16 >> 16;
                h2.a(p.long(n14, n15));
                this.a.if(h2, n14, n15);
                break;
            }
            case 6: {
                int n17 = specialProperty.parameter1;
                if (n17 != this.a.try()) {
                    if (this.a.do().a(h2, n17, 0, 0)) break;
                    h2.try("\u4f20\u9001\u5931\u8d25\uff0c\u65e0\u6cd5\u524d\u5f80\u76ee\u6807\u573a\u666f");
                    return false;
                }
                int n18 = this.a.for(this.a.r(), this.a.t());
                int n19 = n18 & 0xFFFF;
                int n20 = n18 >> 16;
                h2.a(p.long(n19, n20));
                this.a.if(h2, n19, n20);
                break;
            }
            case 12: {
                int n21 = specialProperty.parameter1;
                if (n21 < hero.level) {
                    hero.restorePropertiesTo(n21);
                    this.a.a(p.new(h2.r()), h2.m(), h2.o(), h2);
                    h2.a(p.m(n21));
                    break;
                }
                h2.new("\u65e0\u6cd5\u5b8c\u6210\u6d17\u70b9\uff0c\u4f60\u7684\u7b49\u7ea7\u5fc5\u987b\u9ad8\u4e8e\u6d17\u70b9\u7684\u7b49\u7ea7");
                return false;
            }
            case 8: {
                int n22 = specialProperty.parameter1 + (int)(Math.random() * (double)(specialProperty.parameter2 - specialProperty.parameter1));
                h2.new(n22);
                break;
            }
            case 9: {
                int n23 = specialProperty.parameter1 + (int)(Math.random() * (double)(specialProperty.parameter2 - specialProperty.parameter1));
                h2.int(n23);
                break;
            }
            case 7: {
                b b2 = h2.x();
                if (specialProperty.parameter2 > 0 && b2 != null && b2.else() != h2) {
                    h2.new("\u4f60\u4e0d\u662f\u961f\u957f\uff0c\u4e0d\u80fd\u521b\u5efa\u526f\u672c");
                    return false;
                }
                int n24 = specialProperty.parameter1;
                int n25 = this.a.do().if(n24);
                if (n25 <= 0) {
                    h2.new("\u65e0\u6cd5\u521b\u5efa\u8be5\u526f\u672c\uff1a" + n24);
                    return false;
                }
                if (specialProperty.parameter2 > 0 && b2 != null) {
                    if (this.a.do().a(h2, n25, 0, 0)) {
                        int n26 = b2.a.for();
                        int n27 = 1;
                        while (n27 < n26) {
                            h h3 = (h)b2.a.if(n27);
                            if (h3.j() == this.a) {
                                this.a.do().a(h3, n25, 0, 0);
                            }
                            ++n27;
                        }
                        break;
                    }
                    return false;
                }
                if (this.a.do().a(h2, n25, 0, 0)) break;
                return false;
            }
            case 10: {
                int n28;
                h2.new(specialProperty.parameter1);
                h2.int(specialProperty.parameter2);
                switch (h2.r().race) {
                    case 0: {
                        h2.a((Goods)GameObject.cloneObject(w.case().getGoods(1110000100)));
                        h2.a((Goods)GameObject.cloneObject(w.case().getGoods(1130000100)));
                        h2.a((Goods)GameObject.cloneObject(w.case().getGoods(1120000100)));
                        h2.a((Goods)GameObject.cloneObject(w.case().getGoods(1210000100)));
                        h2.a((Goods)GameObject.cloneObject(w.case().getGoods(1320000100)));
                        h2.a((Goods)GameObject.cloneObject(w.case().getGoods(1320000200)));
                        break;
                    }
                    case 1: {
                        h2.a((Goods)GameObject.cloneObject(w.case().getGoods(1111000100)));
                        h2.a((Goods)GameObject.cloneObject(w.case().getGoods(1131000100)));
                        h2.a((Goods)GameObject.cloneObject(w.case().getGoods(1121000100)));
                        h2.a((Goods)GameObject.cloneObject(w.case().getGoods(1221000100)));
                        h2.a((Goods)GameObject.cloneObject(w.case().getGoods(1321000100)));
                        h2.a((Goods)GameObject.cloneObject(w.case().getGoods(1321000200)));
                        break;
                    }
                    case 2: {
                        h2.a((Goods)GameObject.cloneObject(w.case().getGoods(1112000100)));
                        h2.a((Goods)GameObject.cloneObject(w.case().getGoods(1132000100)));
                        h2.a((Goods)GameObject.cloneObject(w.case().getGoods(1122000100)));
                        h2.a((Goods)GameObject.cloneObject(w.case().getGoods(1232000100)));
                        h2.a((Goods)GameObject.cloneObject(w.case().getGoods(1322000100)));
                        h2.a((Goods)GameObject.cloneObject(w.case().getGoods(1322000200)));
                        break;
                    }
                }
                Goods goods = w.case().getGoods(1313000100);
                if (goods != null) {
                    n28 = 0;
                    do {
                        goods = (Goods)GameObject.cloneObject(goods);
                        this.a.do().a(goods);
                        h2.a(goods);
                    } while (++n28 < 2);
                }
                if ((goods = w.case().getGoods(1313001100)) == null) break;
                n28 = 0;
                do {
                    goods = (Goods)GameObject.cloneObject(goods);
                    this.a.do().a(goods);
                    h2.a(goods);
                } while (++n28 < 2);
                break;
            }
            case 18: {
                int n29 = specialProperty.parameter1;
                if (hero.user.store.capacity >= hero.user.store.goods.length) {
                    h2.new("\u4f60\u7684\u4ed3\u5e93\u5bb9\u91cf\u4e0d\u80fd\u518d\u6269\u5145\u4e86");
                    return false;
                }
                hero.user.store.capacity = Math.min(hero.user.store.capacity + n29, hero.user.store.goods.length);
                h2.a(p.long(hero.user.store.capacity));
                break;
            }
            case 19: {
                int n30 = specialProperty.parameter1 / 1000000;
                if (n30 != this.a.try()) {
                    h2.new("\u5b9d\u7269\u4e0d\u5728\u5f53\u524d\u573a\u666f");
                    return false;
                }
                int n31 = specialProperty.parameter1 % 1000;
                int n32 = specialProperty.parameter1 / 1000 % 1000;
                if (n31 != h2.m() || n32 != h2.o()) {
                    h2.new("\u5b9d\u7269\u4e0d\u5728\u5f53\u524d\u5750\u6807:" + n31 + ";" + n32);
                    return false;
                }
                PlunderData plunderData = w.case().char(specialProperty.parameter2);
                if (plunderData == null) break;
                int n33 = (int)((double)plunderData.minMoney + Math.random() * (double)(plunderData.maxMoney - plunderData.minMoney));
                h2.new(n33);
                this.a.E().a(h2, plunderData, n31, n32);
                break;
            }
            case 33: {
                PlunderData plunderData = w.case().char(specialProperty.parameter1);
                if (plunderData == null) break;
                int n34 = (int)((double)plunderData.minMoney + Math.random() * (double)(plunderData.maxMoney - plunderData.minMoney));
                h2.new(n34);
                this.a.E().a(h2, plunderData, hero.x, hero.y);
                break;
            }
            case 23: {
                int n35 = specialProperty.parameter1;
                if (hero.personalDepot.goodsList.length - hero.personalDepot.getGoodsCount() < n35) {
                    h2.try("\u4f60\u80cc\u5305\u5269\u4f59\u7a7a\u95f4\u4e0d\u8db3\uff0c\u4e0d\u80fd\u4f7f\u7528\u6b64\u9053\u5177\uff0c\u8bf7\u5148\u6e05\u7406\u80cc\u5305");
                    return false;
                }
                int n36 = 0;
                while (n36 < n35) {
                    Goods goods;
                    int n37 = specialProperty.extraData[n36];
                    if (n37 == 0) {
                        n37 = specialProperty.parameter2;
                    }
                    if ((goods = w.case().getGoods(n37)) != null) {
                        goods = (Goods)GameObject.cloneObject(goods);
                        this.a.do().a(goods);
                        h2.a(goods);
                    }
                    ++n36;
                }
                break;
            }
            case 24: {
                if (hero.pkValue <= 0) {
                    h2.new("\u4f60\u5f53\u524d\u8fd8\u6ca1\u6709PK\u503c");
                    return false;
                }
                int n38 = Math.min(specialProperty.parameter1, hero.pkValue);
                h2.char(hero.pkValue - n38);
                break;
            }
            case 25: {
                int n39 = (hero.sex + 1) % 2;
                if (hero.personalDepot.fashion != null && hero.personalDepot.fashion.sex != n39) {
                    h2.new("\u8bf7\u8131\u4e0b\u5f53\u524d\u65f6\u88c5\u518d\u8fdb\u884c\u53d8\u6027\u624b\u672f");
                    return false;
                }
                hero.sex = n39;
                this.a.a(p.else(hero), hero.x, hero.y, null);
                break;
            }
            case 26: {
                if (hero.onlineExpLifeTime > 0 && hero.onlineExpRate != specialProperty.parameter2) {
                    h2.new("\u65e0\u6cd5\u53e0\u52a0\u8be5\u6548\u679c");
                    return false;
                }
                hero.onlineExpLifeTime += specialProperty.parameter1;
                hero.onlineExpRate = specialProperty.parameter2;
                h2.a(p.char(specialProperty.spType, hero.onlineExpLifeTime));
                break;
            }
            case 27: {
                if (hero.offlineExpLifeTime > 0 && hero.offlineExpRate != specialProperty.parameter2) {
                    h2.new("\u65e0\u6cd5\u53e0\u52a0\u8be5\u6548\u679c");
                    return false;
                }
                hero.offlineExpLifeTime += specialProperty.parameter1;
                hero.offlineExpRate = specialProperty.parameter2;
                h2.a(p.char(specialProperty.spType, hero.offlineExpLifeTime));
                break;
            }
            case 28: {
                if (hero.doubleExpLifeTime > 0 && hero.doubleExpRate != specialProperty.parameter2) {
                    h2.new("\u65e0\u6cd5\u53e0\u52a0\u8be5\u6548\u679c");
                    return false;
                }
                hero.doubleExpLifeTime += specialProperty.parameter1;
                hero.doubleExpRate = specialProperty.parameter2;
                h2.a(p.char(specialProperty.spType, hero.doubleExpLifeTime));
                break;
            }
            case 30: {
                int n40 = specialProperty.parameter1;
                h2.a(n40, (h)null);
                break;
            }
            case 31: {
                h2.c(specialProperty.id);
                hero.shortCuts.idArray[10] = specialProperty.id;
                hero.shortCuts.flagArray[10] = 1;
                h2.a(p.new(10, specialProperty.id, 1));
                return false;
            }
            case 32: {
                h2.byte(specialProperty.id);
                hero.shortCuts.idArray[11] = specialProperty.id;
                hero.shortCuts.flagArray[11] = 1;
                h2.a(p.new(11, specialProperty.id, 1));
                return false;
            }
            case 35: {
                app.b.b b3;
                if (hero.turns >= Hero.MAX_LEVEL_TABLE.length - 1) {
                    h2.new("\u65e0\u6cd5\u8f6c\u751f\uff0c\u4f60\u5df2\u7ecf\u8fbe\u5230\u6700\u5927\u8f6c\u751f\u6b21\u6570");
                    return false;
                }
                if (hero.level < hero.getMaxLevel() - 10) {
                    h2.new("\u4f60\u5c1a\u672a\u8fbe\u5230\u8f6c\u751f\u6240\u9700\u8981\u7684\u7b49\u7ea7");
                    return false;
                }
                int n41 = specialProperty.parameter1;
                u u2 = this.a.do().do(n41);
                if (u2 == null) {
                    h2.new("\u8f6c\u751f\u5931\u8d25\uff0c\u627e\u4e0d\u5230\u76ee\u6807\u573a\u666f\uff1a" + n41);
                    return false;
                }
                hero.upgradeTurn(specialProperty.parameter2);
                h2.a(p.byte(specialProperty.parameter2));
                if (u2 == this.a) {
                    b3 = p.a((SceneObject)hero);
                    this.a.a(b3, hero.x, hero.y, h2);
                    b3 = p.a((SceneObject)hero, null);
                    this.a.a(b3, hero.x, hero.y, h2);
                    h2.w();
                } else {
                    this.a.do(h2);
                    h2.if(0, 0);
                    u2.if(h2);
                }
                b3 = p.d("\u6709\u4e00\u4f4d\u9ad8\u624b\u300e" + hero.name + "\u300f\u5b8c\u6210\u4fee\u70bc\u3001\u6210\u529f\u8f6c\u751f\uff01");
                this.a.do().a(b3);
                this.a.do().a(hero, 2);
                this.a.do().a(hero, 7 + hero.race);
                break;
            }
            case 36: {
                int n42 = specialProperty.parameter1;
                if (hero.personalDepot.shopCapacity >= hero.personalDepot.shopGoods.length) {
                    h2.try("\u4f60\u7684\u4e2a\u4eba\u5546\u5e97\u5bb9\u91cf\u5df2\u8fbe\u5230\u4e0a\u9650\u4e86");
                    return false;
                }
                hero.personalDepot.shopCapacity = Math.min(hero.personalDepot.shopGoods.length, n42 + hero.personalDepot.shopCapacity);
                h2.a(p.int(hero.personalDepot.shopCapacity));
                break;
            }
            case 38: {
                if (hero.joinedGuild == null) {
                    h2.new("\u4f60\u8fd8\u6ca1\u6709\u516c\u4f1a");
                    return false;
                }
                if (hero.joinedGuild.leader.equals(hero.name)) {
                    h2.new("\u4f60\u4e0d\u662f\u4f1a\u957f\uff0c\u4e0d\u80fd\u4f7f\u7528\u6b64\u7269\u54c1");
                    return false;
                }
                int n43 = this.a.do().if(specialProperty.parameter1);
                if (n43 > 0) {
                    e e2 = h2.J();
                    if (e2 == null) break;
                    e2.a(n43, h2, specialProperty.parameter2);
                    break;
                }
                h2.new("\u521b\u5efa\u526f\u672c\u5931\u8d25\uff01");
                break;
            }
            case 39: {
                if (hero.joinedGuild == null) {
                    h2.new("\u4f60\u8fd8\u6ca1\u6709\u516c\u4f1a");
                    return false;
                }
                if (hero.guildPosition != 2) {
                    h2.new("\u4f60\u4e0d\u662f\u516c\u4f1a\u4f1a\u957f\uff0c\u4e0d\u80fd\u4f7f\u7528\u6b64\u9053\u5177");
                    return false;
                }
                if (hero.joinedGuild.level < 3) {
                    h2.new("\u4f60\u7684\u516c\u4f1a\u7b49\u7ea7\u4e0d\u591f\uff0c3\u7ea7\u4ee5\u4e0a\u624d\u53ef\u4ee5\u5efa\u7acb\u6807\u5fd7\u7269");
                    return false;
                }
                if (hero.joinedGuild.placedSign != null) {
                    h2.new("\u4f60\u7684\u516c\u4f1a\u5df2\u7ecf\u653e\u7f6e\u4e86\u516c\u4f1a\u6807\u5fd7\u4e86");
                    return false;
                }
                if (hero.joinedGuild.cityID > 0 && hero.joinedGuild.cityID != hero.sceneID) {
                    h2.try("\u5fc5\u987b\u5c06\u516c\u4f1a\u6807\u5fd7\u653e\u7f6e\u5728\u6240\u5360\u9886\u7684\u57ce\u5e02\u91cc");
                    return false;
                }
                if (this.a.K() != 0) {
                    h2.try("\u4e0d\u80fd\u5728\u6b64\u573a\u666f\u653e\u7f6e\u516c\u4f1a\u6807\u5fd7");
                    return false;
                }
                Sign sign = new Sign();
                sign.image = specialProperty.parameter1;
                sign.targetGuild = hero.joinedGuild;
                sign.stateID = specialProperty.parameter2;
                sign.x = hero.x;
                sign.y = hero.y;
                hero.joinedGuild.placedSign = sign;
                this.a.a(sign);
                app.b.b b4 = p.d(hero.name + "\u5728" + this.a.int() + "\u7684(" + sign.x + "," + sign.y + ")\u5efa\u7acb\u4e86\u516c\u4f1a\u6807\u5fd7\uff01");
                this.a.do().a(b4);
                sign.lastAddReputationTime = ServerInfo.currentMilliSecond;
                break;
            }
            case 40: {
                GoodsFormula goodsFormula = w.case().new(specialProperty.parameter1);
                int n44 = goodsFormula.materials.length;
                int n45 = 0;
                while (n45 < n44) {
                    Goods goods = null;
                    goods = w.case().getGoods(goodsFormula.materials[n45]);
                    goodsFormula.materialInstances[n45] = goods != null ? goods : null;
                    ++n45;
                }
                n45 = 0;
                while (n45 < h2.else.length) {
                    h2.else[n45] = null;
                    h2.z[n45] = -1;
                    ++n45;
                }
                app.b.b b5 = p.a(goodsFormula, specialProperty.name);
                h2.a(b5);
                return false;
            }
            case 41: {
                g.a(h2, specialProperty);
                return true;
            }
            default: {
                h2.new("\u8be5\u9053\u5177\u4e0d\u53ef\u88ab\u4f7f\u7528");
                return false;
            }
        }
        return true;
    }

    private boolean a(h h2, Fashion fashion, int n2) {
        Hero hero = h2.r();
        if (fashion.sex >= 0 && fashion.sex != hero.sex) {
            h2.new("\u6027\u522b\u4e0d\u7b26");
            return false;
        }
        Fashion fashion2 = hero.personalDepot.fashion;
        hero.personalDepot.fashion = fashion;
        hero.personalDepot.goodsList[n2] = fashion2;
        hero.calculateProperties();
        h2.a(p.goto(n2));
        app.b.b b2 = p.case(hero.id, hero.suit);
        this.a.a(b2, hero.x, hero.y, h2);
        return true;
    }
}

