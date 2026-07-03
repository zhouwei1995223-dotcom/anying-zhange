/*
 * Decompiled with CFR 0.152.
 */
package a.b;

import a.b.c;
import a.b.e;

public class x
implements e {
    private int[] a;

    public x() {
        this(-1);
    }

    public x(int n2) {
        this(new int[]{n2});
    }

    public x(int[] nArray) {
        this.a = nArray;
    }

    public void a(c c2, int n2, int n3) {
        int n4 = 0;
        while (n4 < this.a.length) {
            c2.if(n4, n4, n2 - 2 * n4, n3 - 2 * n4, this.a[n4]);
            ++n4;
        }
    }

    public int[] a() {
        return this.a;
    }
}

