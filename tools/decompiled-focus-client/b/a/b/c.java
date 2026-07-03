/*
 * Decompiled with CFR 0.152.
 */
package b.a.b;

import b.a.b.j;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
class c {
    public static final int long = 0;
    public static final int a = 1;
    public static final int new = 2;
    public static final int goto = 3;
    int byte;
    int try;
    int if = 255;
    int[] int;
    int else;
    int case;
    int for;
    int char;
    c do;

    public void a(a.b.c c2, int n2, int n3) {
        if (this.if > 240 && j.v != null) {
            if (this.byte == 1 || this.byte == 0) {
                c2.if(j.v, n2, n3, 0, 0, 64, 64);
            }
        } else if (j.B != null) {
            c2.do(j.B, n2 + this.else, n3 + this.case, 260, this.for, 14, 16, this.if);
            n2 += 14;
            int n4 = 0;
            while (n4 < this.int.length) {
                c2.do(j.B, n2 + this.else, n3 + this.case, this.int[n4], this.for, 22, 16, this.if);
                ++n4;
                n2 += 16;
            }
        }
    }

    public c(int n2, int n3, int n4) {
        this.byte = n2;
        this.try = n3;
        this.char = n4;
        if (n3 < 10) {
            this.int = new int[1];
            this.int[0] = n3 * 26;
        } else if (n3 < 100) {
            this.int = new int[2];
            this.int[0] = n3 / 10 * 26;
            this.int[1] = n3 % 10 * 26;
        } else if (n3 < 1000) {
            this.int = new int[3];
            this.int[0] = n3 / 100 * 26;
            this.int[1] = n3 / 10 % 10 * 26;
            this.int[2] = n3 % 10 * 26;
        } else if (n3 < 10000) {
            this.int = new int[4];
            this.int[0] = n3 / 1000 * 26;
            this.int[1] = n3 / 100 % 10 * 26;
            this.int[2] = n3 / 10 % 10 * 26;
            this.int[3] = n3 % 10 * 26;
        } else if (n3 < 100000) {
            this.int = new int[5];
            this.int[0] = n3 / 10000 * 26;
            this.int[1] = n3 / 1000 % 10 * 26;
            this.int[2] = n3 / 100 % 10 * 26;
            this.int[3] = n3 / 10 % 10 * 26;
            this.int[4] = n3 % 10 * 26;
        }
        switch (n2) {
            case 0: {
                this.for = 0;
                break;
            }
            case 1: {
                this.for = 39;
                break;
            }
            case 2: {
                this.for = 19;
                break;
            }
            case 3: {
                this.for = 86;
                break;
            }
        }
    }

    public void a(b.a.d.c c2) {
        switch (this.byte) {
            case 0: {
                c2.Q -= this.try;
                break;
            }
            case 1: {
                c2.Q -= this.try;
                break;
            }
            case 2: {
                c2.Q += this.try;
                break;
            }
        }
    }
}

