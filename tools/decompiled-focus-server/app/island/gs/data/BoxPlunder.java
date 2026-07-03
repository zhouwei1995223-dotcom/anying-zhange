/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.data;

import app.island.GameObject;

public class BoxPlunder
extends GameObject {
    public int minLevel;
    public int maxLevel;
    public int[] weaponRates = new int[5];
    public int[] equipmentRates = new int[5];
    public int[] goodsIDTable = new int[40];
    public int[] extraGoodsRates = new int[40];
    public transient int indexOfWeapons;
    public transient int indexOfEquipments;
    public transient int countOfGoods;

    public boolean setAttributeValue(String string, String string2) {
        if (string.equals("weaponRates")) {
            if (string2.length() > 1) {
                this.weaponRates[this.indexOfWeapons++] = Integer.parseInt(string2);
            }
        } else if (string.equals("equipmentRates")) {
            if (string2.length() > 1) {
                this.equipmentRates[this.indexOfEquipments++] = Integer.parseInt(string2);
            }
        } else if (string.equals("goodsIDTable")) {
            if (string2.length() > 1) {
                this.goodsIDTable[this.countOfGoods] = Integer.parseInt(string2);
            }
        } else if (string.equals("extraGoodsRates")) {
            if (string2.length() > 1) {
                this.extraGoodsRates[this.countOfGoods++] = Integer.parseInt(string2);
            }
        } else {
            return super.setAttributeValue(string, string2);
        }
        return false;
    }
}

