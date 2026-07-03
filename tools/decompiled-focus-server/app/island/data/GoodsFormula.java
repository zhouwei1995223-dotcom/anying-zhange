/*
 * Decompiled with CFR 0.152.
 */
package app.island.data;

import app.island.GameObject;
import app.island.data.Goods;
import daff.a.e;

public class GoodsFormula
extends GameObject {
    public int[] targetGoods = new int[3];
    public int[] rates = new int[3];
    public int[] materials = new int[5];
    public Goods[] materialInstances = new Goods[5];
    public int poundage;
    public transient int targetGoodsCount;
    public transient int rateCount;
    public transient int materialsCount;

    public void readFrom(e e2) {
        super.readFrom(e2);
        this.poundage = e2.i();
        int n2 = this.materialInstances.length;
        int n3 = 0;
        int n4 = 0;
        while (n4 < n2) {
            this.materials[n4] = e2.i();
            if (this.materials[n4] != 0) {
                ++n3;
            }
            ++n4;
        }
        n4 = 0;
        while (n4 < n2) {
            if (this.materials[n4] != 0) {
                Goods goods = Goods.createGoodsByType(8);
                goods.readFrom(e2);
                this.materialInstances[n4] = goods;
            } else {
                e2.i();
                this.materialInstances[n4] = null;
            }
            ++n4;
        }
    }

    public void writeTo(e e2) {
        super.writeTo(e2);
        e2.char(this.poundage);
        int n2 = this.materialInstances.length;
        int n3 = 0;
        while (n3 < n2) {
            e2.char(this.materials[n3]);
            ++n3;
        }
        n3 = 0;
        while (n3 < n2) {
            if (this.materialInstances[n3] != null) {
                this.materialInstances[n3].writeTo(e2);
            } else {
                e2.char(0);
            }
            ++n3;
        }
    }

    public boolean setAttributeValue(String string, String string2) {
        if (string.equals("targetGoods")) {
            if (string2.length() > 1) {
                this.targetGoods[this.targetGoodsCount++] = Integer.parseInt(string2);
            }
            return true;
        }
        if (string.equals("rates")) {
            if (string2.length() > 1) {
                this.rates[this.rateCount++] = Integer.parseInt(string2);
            }
            return true;
        }
        if (string.equals("materials")) {
            if (string2.length() > 1) {
                this.materials[this.materialsCount++] = Integer.parseInt(string2);
            }
            return true;
        }
        return super.setAttributeValue(string, string2);
    }

    public boolean testMaterials(Goods[] goodsArray) {
        if (this.a(goodsArray) != this.materialsCount) {
            return false;
        }
        boolean bl = true;
        int n2 = 0;
        while (n2 < this.materialsCount) {
            bl &= this.a(goodsArray, this.materials[n2]) >= 1;
            ++n2;
        }
        return bl;
    }

    private int a(Goods[] goodsArray) {
        int n2 = 0;
        int n3 = 0;
        while (n3 < goodsArray.length) {
            if (goodsArray[n3] != null) {
                ++n2;
            }
            ++n3;
        }
        return n2;
    }

    private int a(Goods[] goodsArray, int n2) {
        int n3 = 0;
        int n4 = 0;
        while (n4 < goodsArray.length) {
            if (goodsArray[n4] != null && goodsArray[n4].id == n2) {
                ++n3;
            }
            ++n4;
        }
        return n3;
    }

    public void copyFrom(GameObject gameObject) {
        super.copyFrom(gameObject);
        GoodsFormula goodsFormula = (GoodsFormula)gameObject;
        System.arraycopy(goodsFormula.targetGoods, 0, this.targetGoods, 0, goodsFormula.targetGoods.length);
        System.arraycopy(goodsFormula.materialInstances, 0, this.materialInstances, 0, goodsFormula.materialInstances.length);
        System.arraycopy(goodsFormula.rates, 0, this.rates, 0, goodsFormula.targetGoods.length);
        System.arraycopy(goodsFormula.materials, 0, this.materials, 0, goodsFormula.materials.length);
        this.poundage = goodsFormula.poundage;
    }
}

