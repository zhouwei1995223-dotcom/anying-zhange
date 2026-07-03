/*
 * Decompiled with CFR 0.152.
 */
package b.a.b;

import a.b.af;
import a.b.c;
import b.a.b.d;
import b.a.b.j;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class v
extends d {
    public static final af[] aU = new af[100];
    private static final int[][] aT;
    private j aQ;
    private int aR;
    private int aZ = 1;
    private int a0;
    private int aX = 100;
    private int aW = 132;
    private int aP;
    private int a1;
    private int aY = 5;
    private int a2;
    private transient int aV = Integer.MAX_VALUE;
    private transient int aS;
    private transient long a3;

    public void do(c c2) {
    }

    public v(int n2, int n3, int n4, int n5) {
        this.aR = n4;
        this.a0 = aT[n4][0];
        this.aX = aT[n4][1];
        this.aW = aT[n4][2];
        this.aP = aT[n4][3];
        this.new = n2;
        this.for = n3;
        this.a1 = n5;
        this.aZ = 2;
    }

    public v(j j2, int n2, int n3) {
        this.aQ = j2;
        this.aR = n2;
        this.a0 = aT[n2][0];
        this.aX = aT[n2][1];
        this.aW = aT[n2][2];
        this.aP = aT[n2][3];
        this.a1 = n3;
        if (this.aQ != null) {
            this.new = this.aQ.case();
            this.for = this.aQ.a() + 1;
        }
    }

    public int o() {
        return this.aY;
    }

    public int do() {
        return this.aZ;
    }

    public void case(int n2) {
        this.aY = n2;
    }

    public int p() {
        return this.a2;
    }

    public void try(int n2) {
        this.a2 = n2;
    }

    public int char() {
        return this.for - this.aW;
    }

    public void a(long l2) {
        if (this.aQ != null) {
            this.a(this.aQ.case(), this.aQ.a() + 1);
        }
        if (l2 - this.a3 > (long)this.aP && aU[this.aR] != null) {
            this.a3 = l2;
            if (this.aV == Integer.MAX_VALUE && aU[this.aR].new() >= aU[this.aR].try()) {
                this.aV = aU[this.aR].int() / this.a0;
            } else if (++this.aS >= this.aV) {
                this.int = (this.a1 += -1) > 0;
                this.aS = 0;
            }
        }
    }

    static {
        int[][] nArrayArray = new int[16][];
        int[] nArray = new int[4];
        nArray[3] = 120;
        nArrayArray[0] = nArray;
        nArrayArray[1] = new int[]{200, 100, 132, 120};
        nArrayArray[2] = new int[]{200, 98, 134, 120};
        nArrayArray[3] = new int[]{300, 148, 172, 120};
        nArrayArray[4] = new int[]{252, 132, 134, 120};
        nArrayArray[5] = new int[]{244, 132, 148, 120};
        nArrayArray[6] = new int[]{266, 128, 106, 120};
        nArrayArray[7] = new int[]{200, 100, 126, 120};
        nArrayArray[8] = new int[]{200, 98, 126, 120};
        nArrayArray[9] = new int[]{200, 100, 146, 120};
        nArrayArray[10] = new int[]{200, 100, 134, 120};
        nArrayArray[11] = new int[]{116, 58, 255, 120};
        nArrayArray[12] = new int[0];
        nArrayArray[13] = new int[0];
        nArrayArray[14] = new int[0];
        nArrayArray[15] = new int[0];
        aT = nArrayArray;
    }

    public void if(c c2) {
        af af2 = aU[this.aR];
        if (this.int && af2 != null && this.aV != Integer.MAX_VALUE) {
            int n2 = this.aS % this.aV;
            int n3 = this.try();
            int n4 = this.char();
            c2.a(af2, n3, n4, n2 * this.a0, 0, this.a0, af2.try(), this.aY, this.a2);
        }
    }

    public int else() {
        return 0;
    }

    public int q() {
        return this.aV;
    }

    public int r() {
        return this.aP;
    }

    public int try() {
        return this.new - this.aX;
    }

    public void byte(int n2) {
        this.aP = n2;
    }

    public int for() {
        return this.a0;
    }

    public void new(int n2) {
        this.a0 = n2;
    }
}

