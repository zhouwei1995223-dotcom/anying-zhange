/*
 * Decompiled with CFR 0.152.
 */
package b.a.b;

import a.b.af;
import a.b.c;
import b.a.b.d;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class i
extends d {
    public static final af[] o = new af[100];
    private int k;
    private af n;
    private int m;
    private int q;
    private int j = 60;
    private int l = 1;
    private int s;
    private int p;
    private int r;
    private long t;

    public int goto() {
        return this.k;
    }

    public i(int n2) {
        this.k = n2;
    }

    public int do() {
        return 1;
    }

    public int char() {
        return this.for - this.s + 6;
    }

    public void a(long l2) {
        if (this.p > 0) {
            this.p = (int)((long)this.p - this.byte.for);
        } else if (this.r > 0 && this.n != null) {
            this.r = (int)((long)this.r - this.byte.for);
            if (l2 - this.t > (long)this.j) {
                this.t = l2;
                this.m = (this.m + 1) % this.q;
            }
        } else {
            this.int = false;
        }
    }

    public void if(c c2) {
        if (this.n != null && this.p <= 0) {
            int n2 = this.try();
            int n3 = this.char();
            c2.a(this.n, n2, n3, this.m * this.l, 0, this.l, this.s, 5, 0);
        }
    }

    public int else() {
        return this.s;
    }

    public void if(int n2, int n3, int n4, int n5, int n6) {
        this.new = this.byte.try(n3);
        this.for = this.byte.int(n4) + 1;
        this.n = o[n2 - 1];
        if (this.n != null) {
            switch (n2) {
                case 1: {
                    this.l = 32;
                    break;
                }
                case 2: {
                    this.l = 64;
                    this.j = 0;
                    break;
                }
                case 11: 
                case 13: 
                case 14: 
                case 15: {
                    this.l = this.n.int() / 4;
                    break;
                }
                default: {
                    this.l = 92;
                }
            }
            this.q = this.n.int() / this.l;
            this.s = this.n.try();
        }
        this.p = n5;
        this.r = n6;
    }

    public int try() {
        return this.new - this.l / 2;
    }

    public int for() {
        return this.l;
    }
}

