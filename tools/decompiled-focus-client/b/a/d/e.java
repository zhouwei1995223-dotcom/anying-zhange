/*
 * Decompiled with CFR 0.152.
 */
package b.a.d;

import b.a.b;
import b.a.d.d;
import b.a.d.g;
import b.a.d.h;
import b.a.d.i;
import b.a.d.j;
import b.a.d.m;
import b.a.d.n;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class e
extends b {
    public static final int[] do;
    public static final int[] new;
    public static final int else = 0;
    public static final int g = 1;
    public static final int int = 2;
    public static final int e = 3;
    public static final int h = 4;
    public static final int f = 5;
    public static final int goto = 6;
    public static final int char = 7;
    public static final int i = 1;
    public static final int byte = 2;
    public static final int case = 3;
    public static final int b = 4;
    public static final int for = 5;
    public static final int c = 6;
    public static final int try = 7;
    public transient int d;
    public int void;
    public int long;

    public void a(a.a.e e2) {
        super.a(e2);
        this.void = e2.for();
        this.long = e2.for();
    }

    public void if(a.a.e e2) {
        super.if(e2);
        e2.a(this.void);
        e2.a(this.long);
    }

    public static final int if(int n2, int n3, int n4, int n5) {
        int n6 = Math.abs(n2 - n4);
        int n7 = Math.abs(n3 - n5);
        if (n6 > 4 || n7 > 4) {
            return 400;
        }
        if (n6 > 3 || n7 > 3) {
            return 300;
        }
        if (n6 > 2 || n7 > 2) {
            return 200;
        }
        return 100;
    }

    public static final e a(int n2) {
        switch (n2) {
            case 1: {
                return new g();
            }
            case 2: {
                return new j();
            }
            case 3: {
                return new d();
            }
            case 4: {
                return new n();
            }
            case 5: {
                return new i();
            }
            case 6: {
                return new h();
            }
            case 7: {
                return new m();
            }
        }
        return null;
    }

    public void do(b b2) {
        super.do(b2);
        e e2 = (e)b2;
        this.void = e2.void;
        this.long = e2.long;
    }

    static {
        int[] nArray = new int[8];
        nArray[1] = -1;
        nArray[2] = -1;
        nArray[3] = -1;
        nArray[5] = 1;
        nArray[6] = 1;
        nArray[7] = 1;
        do = nArray;
        int[] nArray2 = new int[8];
        nArray2[0] = 1;
        nArray2[1] = 1;
        nArray2[3] = -1;
        nArray2[4] = -1;
        nArray2[5] = -1;
        nArray2[7] = 1;
        new = nArray2;
    }

    public static final int a(int n2, int n3, int n4, int n5) {
        if (n4 == n2 && n5 > n3) {
            return 0;
        }
        if (n4 < n2 && n5 > n3) {
            return 1;
        }
        if (n4 < n2 && n5 == n3) {
            return 2;
        }
        if (n4 < n2 && n5 < n3) {
            return 3;
        }
        if (n4 == n2 && n5 < n3) {
            return 4;
        }
        if (n4 > n2 && n5 < n3) {
            return 5;
        }
        if (n4 > n2 && n5 == n3) {
            return 6;
        }
        if (n4 > n2 && n5 > n3) {
            return 7;
        }
        return 0;
    }
}

