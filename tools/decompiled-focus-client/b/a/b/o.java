/*
 * Decompiled with CFR 0.152.
 */
package b.a.b;

import a.b.c;
import b.a.b.j;
import b.a.b.q;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
class o {
    int for;
    int int = 255;
    int[] try;
    int a;
    int new;
    int if;
    o do;

    public void a(c c2, int n2, int n3) {
        if (this.int > 240) {
            c2.a(q.long[40], n2, n3);
        } else {
            c2.do(j.B, n2 + this.a, n3 + this.new, 112, 25, 10, 11, this.int);
            n2 += 10;
            int n4 = 0;
            while (n4 < this.try.length) {
                c2.do(j.B, n2 + this.a, n3 + this.new, this.try[n4], 25, 10, 11, this.int);
                ++n4;
                n2 += 10;
            }
        }
    }

    public o(int n2, int n3) {
        this.for = n2;
        this.if = n3;
        if (n2 < 10) {
            this.try = new int[1];
            this.try[0] = n2 * 11 + 2;
        } else if (n2 < 100) {
            this.try = new int[2];
            this.try[0] = n2 / 10 * 11 + 2;
            this.try[1] = n2 % 10 * 11 + 2;
        } else if (n2 < 1000) {
            this.try = new int[3];
            this.try[0] = n2 / 100 * 11 + 2;
            this.try[1] = n2 / 10 % 10 * 11 + 2;
            this.try[2] = n2 % 10 * 11 + 2;
        } else if (n2 < 10000) {
            this.try = new int[4];
            this.try[0] = n2 / 1000 * 11 + 2;
            this.try[1] = n2 / 100 % 100 * 11 + 2;
            this.try[2] = n2 / 10 % 10 * 11 + 2;
            this.try[3] = n2 % 10 * 11 + 2;
        }
    }
}

