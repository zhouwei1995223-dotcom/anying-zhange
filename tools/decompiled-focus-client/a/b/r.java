/*
 * Decompiled with CFR 0.152.
 */
package a.b;

import a.b.af;
import a.b.c;
import a.b.w;

public final class r {
    private r() {
    }

    public static final af a(af af2) {
        if (af2 == null) {
            return null;
        }
        int n2 = af2.int();
        int n3 = af2.try();
        w w2 = new w(n2, n3);
        int[] nArray = new int[n2];
        int n4 = 0;
        while (n4 < n3) {
            int n5 = 0;
            while (n5 < n2) {
                nArray[n5] = 0;
                ++n5;
            }
            af2.if(n4, nArray, 0);
            n5 = n2 / 2;
            int n6 = n2 - 1 - n5;
            while (n5 < n2) {
                int n7 = nArray[n5];
                nArray[n5] = nArray[n6];
                nArray[n6] = n7;
                ++n5;
                --n6;
            }
            w2.a(n4, nArray, 0);
            ++n4;
        }
        return w2;
    }

    public static final void a(c c2, String string, int n2, int n3, int n4) {
        c2.a(string, n2 - 1, n3, 0);
        c2.a(string, n2 + 1, n3, 0);
        c2.a(string, n2, n3 - 1, 0);
        c2.a(string, n2, n3 + 1, 0);
        c2.a(string, n2, n3, n4);
    }
}

