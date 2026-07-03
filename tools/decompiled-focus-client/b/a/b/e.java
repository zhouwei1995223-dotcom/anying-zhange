/*
 * Decompiled with CFR 0.152.
 */
package b.a.b;

import a.b.af;
import b.a.b.j;
import b.a.b.q;
import b.a.d.c;
import b.a.d.g;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class e
extends j {
    public static final af[][] L = new af[100][3];
    public static final int[] J = new int[]{-1, -7168, -4586288, -4128768, -1};
    private g K;
    private int I = 55;
    private int H;
    private int F;
    private int G;
    private int M;
    private Object E;

    public g h() {
        return this.K;
    }

    public void do(a.b.c c2) {
        if (this.u > 0 && this.byte.b || this.a || this.byte.case() == this) {
            int n2 = this.new - this.H / 2;
            int n3 = this.for - 72;
            int n4 = this.K.Q * 100 / this.K.r;
            q.a(c2, this.K.a, n2, n3, J[this.K.bN]);
            n2 = this.new - 50;
            c2.a(n2, n3 += 14, n4, 2, -65536);
            c2.a(n2 + n4, n3, 100 - n4, 2, -16777216);
        }
        this.for(c2);
    }

    public c b() {
        return this.K;
    }

    public int char() {
        return this.for - this.I;
    }

    public int e() {
        return this.new;
    }

    public void a(a.b.c c2) {
        if (this.K.Q <= 0 && this.F > 0 && j.v != null) {
            c2.do(j.v, this.case() - 32, this.a() - 46, 64, 0, 64, 64, this.F >> 1);
        }
    }

    public void a(long l2) {
        super.a(l2);
        int n2 = this.byte.h.x;
        int n3 = this.byte.h.y;
        this.if = this.K.Q > 0 && n2 > this.new - 15 && n2 < this.new + 15 && n3 > this.for - 50 && n3 < this.for + 2;
        if (this.K.Q <= 0) {
            if (this.F == 0) {
                this.F = 500;
            } else if (this.F > 0) {
                this.F += -1;
                if (this.F <= 0) {
                    this.int = false;
                }
            }
        }
    }

    public void if(a.b.c c2) {
        int n2 = this.try();
        int n3 = this.char();
        af af2 = L[this.K.bQ][this.A.int];
        if (af2 == null) {
            c2.a(n2, n3, this.G, this.M, -1895825408);
            c2.a("Loading", this.G / 2 - 21, this.M / 2 - 6, -1);
        } else if (this.K.Q > 0) {
            int n4 = this.A.a;
            if (this.K.bQ != 57) {
                n4 = (this.A.a + 4) % 8;
            }
            int n5 = this.x % this.y[this.A.int];
            if (this.byte.c == this) {
                c2.a(af2, n2, n3, n5 * this.G, n4 * this.M, this.G, this.M, 2, 32);
            } else {
                c2.a(af2, n2, n3, n5 * this.G, n4 * this.M, this.G, this.M, 0, 0);
                af2.a(0);
            }
        }
    }

    public Object i() {
        return this.E;
    }

    public void a(Object object) {
        this.E = object;
    }

    public int else() {
        return this.M;
    }

    public void a(g g2) {
        this.K = g2;
        this.A.a = g2.s;
        this.A.int = g2.m;
        int n2 = this.byte.b();
        int n3 = this.byte.try();
        this.new = g2.void * n2 + n2 / 2;
        this.for = g2.long * n3 + n3 / 2;
        this.H = a.b.q.if(g2.a);
        if (g2.bQ <= 30 || g2.bQ == 33 || g2.bQ >= 43 && g2.bQ <= 50) {
            this.M = 60;
            this.G = 60;
            this.y = new int[]{10, 10, 10};
        } else if (g2.bQ == 57) {
            this.M = 150;
            this.G = 150;
            this.I = 105;
            this.w = 200;
            this.y = new int[]{5, 4, 4};
        } else {
            this.M = 150;
            this.G = 150;
            this.I = 94;
            this.w = 150;
        }
        switch (g2.bQ) {
            case 2: {
                this.I = 36;
                break;
            }
            case 7: {
                this.I = 50;
                break;
            }
            case 10: {
                this.I = 48;
                break;
            }
        }
        this.u = g2.Q;
    }

    public int try() {
        return this.new - (this.G >> 1);
    }

    public int for() {
        return this.G;
    }

    public int f() {
        return this.for - 25;
    }
}

