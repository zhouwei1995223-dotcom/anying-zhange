/*
 * Decompiled with CFR 0.152.
 */
package b.a.b;

import a.b.af;
import a.b.c;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class r {
    protected int try;
    protected int int;
    protected int if;
    protected short[][] byte;
    protected af[] do;
    protected boolean for;
    protected long new;
    protected boolean a;

    public void a(int n2, int n3, int n4) {
        this.byte[n3][n2] = (short)n4;
    }

    public af[] if() {
        return this.do;
    }

    public int new() {
        return this.try;
    }

    public void a(int n2) {
        this.try = n2;
    }

    public void a(af[] afArray) {
        this.do = afArray;
    }

    public r() {
    }

    public r(int n2, int n3, int n4) {
        this.int = n2;
        this.if = n3;
        this.try = n4;
        this.byte = new short[this.if][this.int];
    }

    public void a(long l2) {
        if (l2 - this.new > 300L) {
            this.a = !this.a;
            this.new = l2;
        }
    }

    public void a(boolean bl) {
        this.for = bl;
    }

    public void a(c c2, int n2, int n3, int n4, int n5) {
        int n6 = n2 + n4;
        int n7 = n3 + n5;
        int n8 = n3 / this.try;
        int n9 = n2 / this.try;
        int n10 = n7 / this.try;
        int n11 = n6 / this.try;
        if (n7 % this.try == 0) {
            --n10;
        }
        if (n6 % this.try == 0) {
            --n11;
        }
        int n12 = n8 * this.try;
        int n13 = 0;
        int n14 = 0;
        int n15 = n8;
        while (n15 <= n10) {
            n13 = n9 * this.try;
            int n16 = n9;
            while (n16 <= n11) {
                n14 = this.byte[n15][n16] - 1;
                if (n14 >= 0 && this.do[n14] != null) {
                    if (n14 >= 1 && n14 <= 13 && this.a) {
                        c2.a(this.do[n14 + 232], n13, n12);
                    } else {
                        c2.a(this.do[n14], n13, n12);
                    }
                } else {
                    c2.a(n13, n12, this.try, this.try, -16777216);
                }
                n13 += this.try;
                ++n16;
            }
            n12 += this.try;
            ++n15;
        }
        if (this.for) {
            n12 = n8 * this.try;
            n15 = n8;
            while (n15 < n10) {
                c2.do(0, n12 += this.try, 65535, n12, -16711936);
                ++n15;
            }
            n13 = n9 * this.try;
            n15 = n9;
            while (n15 < n11) {
                c2.do(n13 += this.try, 0, n13, 65535, -256);
                ++n15;
            }
        }
    }

    public int try() {
        return this.if;
    }

    public int for() {
        return this.if * this.try;
    }

    public int int() {
        return this.int;
    }

    public int a() {
        return this.int * this.try;
    }

    public boolean do() {
        return this.for;
    }

    public int a(int n2, int n3) {
        return this.byte[n3][n2];
    }
}

