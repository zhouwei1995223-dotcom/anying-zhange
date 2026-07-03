/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.data;

import app.island.GameObject;

public class PlunderData
extends GameObject {
    public int level;
    public int minExp;
    public int maxExp;
    public int minMoney;
    public int maxMoney;
    public int goodsProtectionTime;
    public int dropTopHeroDepot;
    public int medicineDropRate;
    public int medicineDropCount;
    public int[] equipmentDropCounts = new int[5];
    public int[] equipmentDropRates = new int[5];
    public int[] weaponDropCounts = new int[5];
    public int[] weaponDropRates = new int[5];
    private int a;
    public int bigDropRate;
    public int bigDropTimes;
    public int[] extraGoodsIDs = new int[100];
    public int[] extraGoodsRates = new int[100];
    public transient int extraDropCount;

    public boolean setAttributeValue(String string, String string2) {
        if (string.equals("extraGoodsID")) {
            if (string2.length() > 1) {
                this.extraGoodsIDs[this.extraDropCount] = Integer.parseInt(string2);
            }
            return true;
        }
        if (string.equals("extraGoodsRate")) {
            if (string2.length() > 0 && string2.charAt(0) != '0') {
                this.extraGoodsRates[this.extraDropCount++] = Integer.parseInt(string2);
            }
            return true;
        }
        if (string.equals("equipmentDropCounts")) {
            this.equipmentDropCounts[this.a] = Integer.parseInt(string2);
            return true;
        }
        if (string.equals("equipmentDropRates")) {
            this.equipmentDropRates[this.a] = Integer.parseInt(string2);
            return true;
        }
        if (string.equals("weaponDropCounts")) {
            this.weaponDropCounts[this.a] = Integer.parseInt(string2);
            return true;
        }
        if (string.equals("weaponDropRates")) {
            this.weaponDropRates[this.a++] = Integer.parseInt(string2);
            return true;
        }
        super.setAttributeValue(string, string2);
        return true;
    }
}

