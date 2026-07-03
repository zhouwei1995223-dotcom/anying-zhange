/*
 * Decompiled with CFR 0.152.
 */
package app.island.data;

import app.island.GameObject;
import app.island.data.Goods;
import daff.a.e;
import daff.a.h;
import daff.a.i;

public class Store
extends GameObject {
    public String password = "";
    public int capacity = 64;
    public Goods[] goods = new Goods[200];
    public transient boolean goodsProcessed;
    public transient boolean hasPassword;
    public transient boolean dataLoaded;

    public void readFrom(e e2) {
        this.capacity = e2.for();
        int n2 = 0;
        while (n2 < this.capacity) {
            if (e2.c()) {
                int n3 = e2.case();
                this.goods[n2] = Goods.createGoodsByType(n3);
                this.goods[n2].readFrom(e2);
            }
            ++n2;
        }
        this.dataLoaded = true;
    }

    public void writeTo(e e2) {
        e2.a(this.capacity);
        int n2 = 0;
        while (n2 < this.capacity) {
            e2.a(this.goods[n2] != null);
            if (this.goods[n2] != null) {
                e2.a(this.goods[n2].goodsType);
                this.goods[n2].writeTo(e2);
            }
            ++n2;
        }
    }

    public i getAttributeValue(String string) {
        if (string.equals("goods")) {
            i i2 = new i(string);
            int n2 = 0;
            while (n2 < this.capacity) {
                if (this.goods[n2] != null) {
                    i i3 = new i(String.valueOf(n2));
                    String string2 = String.valueOf(this.goods[n2].id);
                    String string3 = this.goods[n2].getExtraInfo();
                    if (string3.length() > 0) {
                        string2 = string2 + ',' + string3;
                    }
                    i3.do(string2);
                    i2.a(i3);
                }
                ++n2;
            }
            return i2;
        }
        return super.getAttributeValue(string);
    }

    public boolean setAttributeValue(String string, i i2) {
        if (string.equals("goods")) {
            i2.for();
            h h2 = i2.int();
            if (h2 != null) {
                int n2 = h2.for();
                int n3 = 0;
                while (n3 < n2) {
                    i i3 = (i)h2.if(n3);
                    if (i3.for().length() >= 1) {
                        Object object;
                        int n4;
                        int n5 = Integer.parseInt(i3.do());
                        String string2 = i3.for();
                        int n6 = string2.indexOf(44);
                        if (n6 > 0) {
                            n4 = Integer.parseInt(string2.substring(0, n6));
                            object = string2.substring(n6 + 1);
                            Goods goods = Goods.getGlobalGoods(n4);
                            if (goods != null) {
                                this.goods[n5] = (Goods)GameObject.cloneObject(goods);
                                this.goods[n5].parseExtrInfo((String)object);
                            }
                        } else {
                            n4 = Integer.parseInt(i3.for());
                            object = Goods.getGlobalGoods(n4);
                            if (object != null) {
                                this.goods[n5] = (Goods)GameObject.cloneObject((GameObject)object);
                            }
                        }
                    }
                    ++n3;
                }
            }
            return true;
        }
        return super.setAttributeValue(string, i2);
    }

    public int getNextFreePos() {
        int n2 = 0;
        while (n2 < this.capacity) {
            if (this.goods[n2] == null) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }
}

