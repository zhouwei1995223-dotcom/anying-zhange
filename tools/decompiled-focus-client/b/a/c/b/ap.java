/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.q;
import a.b.s;
import b.a.b.p;
import b.a.c.b.e;
import b.a.d.d;
import b.a.d.k;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
class ap
extends s {
    private static final int[] dr = new int[]{-485368, -1550328, -4186104, -6813696, -6813696, -4186104, -1550328, -485368};
    private static final int[] dt = new int[]{-16205576, -16215824, -16226096, -16758608, -16758608, -16226096, -16215824, -16205576};
    private d dp;
    private int dw;
    private int dz;
    private int dB;
    private int dq;
    private String du = "";
    private String dy = "";
    private int dx;
    private int dv;
    private int ds;
    private boolean dA;

    public d bu() {
        return this.dp;
    }

    public void bw() {
        if (this.dp.Q < 0) {
            this.dp.Q = 0;
        }
        this.dx = this.dA ? this.dp.Q * (this.getWidth() - 2) / this.dp.r : this.dp.Q * (this.getWidth() - 26) / this.dp.r;
        this.du = this.dp.Q + "/" + this.dp.r;
    }

    public void a(c c2) {
        c2.a(0, 0, this.getWidth(), 16, -1626335216);
        int n2 = 4;
        int n3 = 2;
        c2.a(this.dp.a, this.ds, n3, p.aa[this.dp.ar]);
        n3 += 14;
        if (this.dA) {
            c2.if(0, n3, this.getWidth(), 10, -5197648);
            int n4 = this.dx;
            ++n3;
            int n5 = 0;
            do {
                c2.do(1, n3 + n5, n4 + 1, n3 + n5, dr[n5]);
            } while (++n5 < 8);
            c2.a(1 + n4, n3, this.getWidth() - 2 - n4, 8, -1895825408);
            c2.a(this.du, this.getWidth() / 2 - this.du.length() * 3, n3 - 2, -1);
            c2.if(0, n3 += 10, this.getWidth() - 24, 10, -5197648);
            n4 = this.dv;
            ++n3;
            n5 = 0;
            do {
                c2.do(1, n3 + n5, n4 + 1, n3 + n5, dt[n5]);
            } while (++n5 < 8);
            c2.a(1 + n4, n3, this.getWidth() - 26 - n4, 8, -1895825408);
            c2.a(this.dy, this.getWidth() / 2 - 13 - this.dy.length() * 3, n3 - 2, -1);
        } else {
            c2.if(0, n3, this.getWidth() - 24, 10, -5197648);
            int n6 = this.dx;
            ++n3;
            int n7 = 0;
            do {
                c2.do(1, n3 + n7, n6 + 1, n3 + n7, dr[n7]);
            } while (++n7 < 8);
            c2.a(1 + n6, n3, this.getWidth() - 26 - n6, 8, -1895825408);
            c2.a(this.du, this.getWidth() / 2 - 13 - this.du.length() * 3, n3 - 2, -1);
        }
        n2 = this.getWidth() - 24;
        c2.a(n2, --n3, 24, 10, -1626335216);
        n2 = this.dp.p < 10 ? e.a(c2, this.dp.p, n2 + 9, n3 - 1, -16711936) : (this.dp.p < 100 ? e.a(c2, this.dp.p, n2 + 6, n3 - 1, -16711936) : e.a(c2, this.dp.p, n2 + 3, n3 - 1, -16711936));
    }

    ap() {
    }

    public void a(long l2) {
        if (this.dp.Q != this.dw || this.dp.r != this.dz) {
            this.bw();
            this.dw = this.dp.Q;
            this.dz = this.dp.r;
        }
        if (this.dp.K != this.dB || this.dp.Y != this.dq) {
            this.bv();
            this.dB = this.dp.K;
            this.dq = this.dp.Y;
        }
    }

    public void if(d d2) {
        this.dp = d2;
        this.ds = this.getWidth() / 2 - q.if(d2.a) / 2;
        this.dA = d2 instanceof k;
        this.bw();
        if (this.dA) {
            this.bv();
        }
    }

    public void bv() {
        if (this.dp.K < 0) {
            this.dp.K = 0;
        }
        this.dv = this.dp.K * (this.getWidth() - 26) / this.dp.Y;
        this.dy = this.dp.K + "/" + this.dp.Y;
    }
}

