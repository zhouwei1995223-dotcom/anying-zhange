/*
 * Decompiled with CFR 0.152.
 */
package b.a.b;

import a.b.af;
import a.b.c;
import b.a.b.d;
import b.a.b.q;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class l
extends d {
    private static final int[][] au = new int[][]{{316, 320, 1}, {321, 324, 2}, {325, 332, 1}, {366, 373, 1}, {418, 426, 1}, {427, 435, 1}, {436, 444, 1}, {445, 453, 1}, {761, 770, 1}, {782, 786, 5}, {787, 791, 5}};
    private af[] ar;
    private int as;
    private int aw;
    private int av = 1;
    private int at;

    public l(int n2, int n3, int n4) {
        this.as = n2;
        this.new = n3;
        this.for = n4;
        this.int(n2);
    }

    public int k() {
        return this.as;
    }

    public int do() {
        return this.at;
    }

    public void for(int n2) {
        this.at = n2;
    }

    public int l() {
        return 1;
    }

    public int char() {
        return this.for;
    }

    public void a(long l2) {
        ++this.aw;
        if (this.ar[0] == null && q.long[this.as] != null && q.long[this.as].int() > 1) {
            int n2 = this.as;
            int n3 = 0;
            while (n3 < this.ar.length) {
                this.ar[n3] = q.long[n2];
                ++n3;
                ++n2;
            }
        }
    }

    public void if(c c2) {
        int n2 = this.aw / this.av % this.ar.length;
        if (this.ar[n2] != null) {
            c2.a(this.ar[n2], this.try(), this.char());
        }
        if (this.a) {
            c2.if(this.try(), this.char(), this.for(), this.else(), -16711936);
        }
    }

    public int else() {
        return this.ar[0].try();
    }

    public int try() {
        return this.new;
    }

    public int for() {
        return this.ar[0].int();
    }

    private void int(int n2) {
        int n3 = 0;
        while (n3 < au.length) {
            if (n2 >= au[n3][0] && n2 <= au[n3][1]) {
                this.ar = new af[au[n3][1] - au[n3][0] + 1];
                this.av = au[n3][2] * 2;
                break;
            }
            ++n3;
        }
        if (this.ar == null) {
            this.ar = new af[1];
        }
    }
}

