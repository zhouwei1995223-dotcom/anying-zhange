/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.data;

import app.island.GameObject;
import app.island.data.Goods;
import daff.a.b;

public class BetData
extends GameObject {
    public int arenaScoreCost;
    public int moneyCost;
    public int treasureCost;
    public Goods[] goodsList = new Goods[20];
    public int[] rates = new int[20];

    public boolean setAttributeValue(String string, String string2) {
        if (string.equals("goodsList")) {
            String string3 = "config/data/bets/" + string2 + ".txt";
            byte[] byArray = b.new(string3);
            if (byArray == null) {
                return false;
            }
            String string4 = new String(byArray);
            String[] stringArray = b.a(string4, "\r\n");
            int n2 = 1;
            while (n2 < stringArray.length && n2 <= this.goodsList.length) {
                if (stringArray[n2].length() < 10) break;
                String[] stringArray2 = b.a(stringArray[n2], "\t");
                this.goodsList[n2 - 1] = Goods.getGlobalGoods(Integer.parseInt(stringArray2[0]));
                if (this.goodsList[n2 - 1] == null) {
                    System.out.println("goods not found for bet:" + stringArray2[0] + ";" + string3);
                }
                this.rates[n2 - 1] = Integer.parseInt(stringArray2[2]);
                ++n2;
            }
            return true;
        }
        return super.setAttributeValue(string, string2);
    }

    public Goods getResultGoods(int n2) {
        int n3 = 0;
        while (n3 < this.rates.length) {
            if (this.rates[n3] >= n2) {
                return this.goodsList[n3];
            }
            ++n3;
        }
        return this.goodsList[0];
    }
}

