/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs;

import app.island.GameObject;
import app.island.data.Goods;
import app.island.data.SpecialProperty;
import app.island.gs.h;
import app.island.gs.l;
import app.island.gs.w;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class i {
    private static i if;
    private static int[] a;

    private Goods a(h h2, double d2, int n2) {
        double d3 = Math.random() * 100.0;
        if (d3 <= d2) {
            daff.a.h h3 = new daff.a.h();
            int n3 = h2.r().level;
            int n4 = n3 - 8;
            int n5 = n3 + 8;
            Goods goods = w.case().a(h2.r().race, n4, n5, n2);
            if (goods != null) {
                h3.if(goods);
            }
            if ((goods = w.case().if(h2.r().race, n4, n5, n2)) != null) {
                h3.if(goods);
            }
            return (Goods)h3.if((int)(Math.random() * (double)h3.for()));
        }
        return null;
    }

    private double[] a(SpecialProperty specialProperty, SpecialProperty specialProperty2) {
        double[] dArray = new double[6];
        int n2 = specialProperty.quality;
        dArray[0] = 0.0;
        dArray[1] = 100.0;
        switch (n2) {
            case 1: {
                dArray[2] = 20.0;
                dArray[3] = 1.0;
                dArray[4] = 0.1;
                dArray[5] = 0.0;
                break;
            }
            case 2: {
                dArray[2] = 25.0;
                dArray[3] = 3.0;
                dArray[4] = 0.5;
                dArray[5] = 0.0;
                break;
            }
            case 3: {
                dArray[2] = 30.0;
                dArray[3] = 10.0;
                dArray[4] = 2.0;
                dArray[5] = 0.0;
                break;
            }
            case 4: {
                dArray[2] = 35.0;
                dArray[3] = 30.0;
                dArray[4] = 5.0;
                dArray[5] = 0.0;
                break;
            }
        }
        return dArray;
    }

    private double[] a(SpecialProperty specialProperty) {
        double[] dArray = new double[6];
        int n2 = specialProperty.quality;
        switch (n2) {
            case 1: {
                dArray[0] = 25.0;
                dArray[1] = 1.0;
                break;
            }
            case 2: {
                dArray[0] = 26.0;
                dArray[1] = 2.0;
                break;
            }
            case 3: {
                dArray[0] = 27.0;
                dArray[1] = 3.0;
                break;
            }
            case 4: {
                dArray[0] = 28.0;
                dArray[1] = 4.0;
                break;
            }
        }
        return dArray;
    }

    public daff.a.h a(h h2, SpecialProperty specialProperty, SpecialProperty specialProperty2) {
        daff.a.h h3 = new daff.a.h();
        if (specialProperty2 == null) {
            int n2 = (int)Math.random() * a.length;
            h3.if(GameObject.cloneObject(Goods.getGlobalGoods(a[n2])));
        } else {
            l l2 = new l();
            Goods goods = l2.a(specialProperty.parameter2);
            if (goods != null) {
                h3.if(goods);
            }
        }
        return h3;
    }

    private i() {
    }

    private Goods a(Goods goods) {
        if (goods == null) {
            return null;
        }
        double[] dArray = new double[]{50.0, 40.0, 15.0, 5.0, 2.0, 1.0};
        double d2 = Math.random() * 100.0;
        if (d2 <= dArray[goods.quality]) {
            int n2 = this.a(goods.quality);
            return Goods.getGlobalGoods(goods.id + n2);
        }
        return goods;
    }

    public int do(SpecialProperty specialProperty, SpecialProperty specialProperty2) {
        if (specialProperty2 != null) {
            return specialProperty2.parameter3;
        }
        return specialProperty.parameter3;
    }

    private int a(int n2) {
        double d2 = Math.random() * 100.0;
        if (d2 >= 0.0 && d2 < 22.4) {
            return 0;
        }
        if (d2 >= 22.4 && d2 < 40.4) {
            return 1;
        }
        if (d2 >= 40.4 && d2 < 56.4) {
            return 2;
        }
        if (d2 >= 56.4 && d2 < 69.4) {
            return 3;
        }
        if (d2 >= 69.4 && d2 < 79.4) {
            return 4;
        }
        if (d2 >= 79.4 && d2 < 87.4) {
            return 5;
        }
        if (d2 >= 87.4 && d2 < 93.4) {
            return 6;
        }
        if (d2 >= 93.4 && d2 < 97.4) {
            return 7;
        }
        if (d2 >= 97.4 && d2 < 99.4) {
            return 8;
        }
        if (d2 >= 99.4 && d2 < 99.9) {
            return 9;
        }
        if (d2 >= 99.9 && d2 < 100.0) {
            return 10;
        }
        return 0;
    }

    static {
        a = new int[]{1313000100, 1313000200, 1313000300, 1313000400, 1313000500, 1313001100, 1313001200, 1313001300, 1313001400};
    }

    public int if(SpecialProperty specialProperty, SpecialProperty specialProperty2) {
        if (specialProperty2 != null) {
            return specialProperty2.parameter4;
        }
        return specialProperty.parameter4;
    }

    public daff.a.h if(h h2, SpecialProperty specialProperty, SpecialProperty specialProperty2) {
        daff.a.h h3 = new daff.a.h();
        double[] dArray = new double[6];
        dArray = specialProperty2 == null ? this.a(specialProperty) : this.a(specialProperty, specialProperty2);
        int n2 = 0;
        while (n2 < dArray.length) {
            if (!(dArray[n2] <= 0.0)) {
                Goods goods = this.a(h2, dArray[n2], n2);
                if ((goods = this.a(goods)) != null) {
                    h3.if(goods);
                }
            }
            ++n2;
        }
        return h3;
    }

    public static i a() {
        if (if == null) {
            if = new i();
        }
        return if;
    }
}

