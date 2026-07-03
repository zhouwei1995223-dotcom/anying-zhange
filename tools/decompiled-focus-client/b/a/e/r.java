/*
 * Decompiled with CFR 0.152.
 */
package b.a.e;

import a.a.e;
import b.a.b;
import b.a.d.c;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class r
extends b {
    public transient int jf;
    public transient int jn;
    public transient int jz;
    public transient int i8;
    public transient int jI;
    public transient int jr;
    public transient int jv;
    public transient int ja;
    public transient int jF;
    public transient int jG;
    public transient int jy;
    public transient int ji;
    public transient int jE;
    public int jl;
    public int jL;
    public int jd;
    public int ju;
    public int i9;
    public int jm;
    public int jp;
    public int jb;
    public int jx;
    public int jc;
    public int jD;
    public int jh;
    public int jq;
    public int jB;
    public int jC;
    public int js;
    public int jj;
    public int jk;
    public int jt;
    public int jJ;
    public int jK;
    public int jH;
    public int i7;
    public transient long jg;
    public transient int jA;
    public int jw;
    public String jo;
    public transient Object je;

    public void a(e e2) {
        super.a(e2);
        this.jl = e2.for();
        this.jK = e2.case();
        this.jJ = e2.case() * 100;
        this.jm = e2.case() * 5;
        this.jp = e2.case() * 5;
        this.jb = e2.case() * 5;
        this.jx = e2.case() * 5;
        this.jc = e2.j();
        this.jD = e2.j();
        this.jh = e2.j();
        this.jq = e2.j();
        this.jB = e2.j();
        this.jC = e2.j();
        this.js = e2.j();
        this.jj = e2.j();
        this.jk = e2.j();
        this.jo = e2.h();
    }

    public void if(e e2) {
        super.if(e2);
        e2.a(this.jl);
        e2.a(this.jK);
        e2.a(this.jJ / 100);
        e2.a(this.jm / 5);
        e2.a(this.jp / 5);
        e2.a(this.jb / 5);
        e2.a(this.jx / 5);
        e2.for(this.jc);
        e2.for(this.jD);
        e2.for(this.jh);
        e2.for(this.jq);
        e2.for(this.jB);
        e2.for(this.jC);
        e2.for(this.js);
        e2.for(this.jj);
        e2.for(this.jk);
        e2.a(this.jo);
    }

    public void do(c c2) {
        if (this.jH == 0) {
            c2.q -= this.jf;
            c2.u -= this.jn;
            c2.J -= this.jz;
            c2.j -= this.i8;
            c2.W -= this.jI;
            c2.w -= this.jr;
            c2.C -= this.jv;
            c2.k -= this.ja;
            c2.P -= this.jF;
            c2.S -= this.jG;
            c2.I -= this.jy;
            c2.t -= this.ji;
            c2.r -= this.jE;
            c2.O -= this.jE;
            if (c2.Q > c2.r) {
                c2.Q = c2.r;
            }
            if (this.ju <= 0) {
                c2.R += -1;
            }
            if (this.i9 <= 0) {
                c2.z += -1;
            }
        }
    }

    public void do(b b2) {
        super.do(b2);
        r r2 = (r)b2;
        this.jl = r2.jl;
        this.jL = r2.jL;
        this.jd = r2.jd;
        this.ju = r2.ju;
        this.i9 = r2.i9;
        this.jm = r2.jm;
        this.jp = r2.jp;
        this.jb = r2.jb;
        this.jx = r2.jx;
        this.jc = r2.jc;
        this.jD = r2.jD;
        this.jh = r2.jh;
        this.jq = r2.jq;
        this.jB = r2.jB;
        this.jC = r2.jC;
        this.js = r2.js;
        this.jj = r2.jj;
        this.jk = r2.jk;
        this.jt = r2.jt;
        this.jJ = r2.jJ;
        this.jK = r2.jK;
        this.jH = r2.jH;
        this.i7 = r2.i7;
        this.jw = r2.jw;
        this.jo = r2.jo;
    }

    public void for(c c2) {
        if (this.jH == 0) {
            this.jf = this.jm;
            this.jn = this.jp;
            this.jz = this.jb;
            this.i8 = this.jx;
            this.jI = c2.goto() * this.jc / 100;
            this.jr = c2.else() * this.jD / 100;
            this.jv = c2.T * this.jh / 100;
            this.ja = c2.for() * this.jq / 100;
            this.jF = c2.void() * this.jB / 100;
            this.jG = c2.E * this.jC / 100;
            this.jy = c2.y * this.js / 100;
            this.ji = c2.n * this.jj / 100;
            this.jE = c2.r * this.jk / 100;
            c2.q += this.jf;
            c2.u += this.jn;
            c2.J += this.jz;
            c2.j += this.i8;
            c2.W += this.jI;
            c2.w += this.jr;
            c2.C += this.jv;
            c2.k += this.ja;
            c2.P += this.jF;
            c2.S += this.jG;
            c2.I += this.jy;
            c2.t += this.ji;
            c2.O += this.jE;
            c2.r += this.jE;
            if (c2.Q > c2.r) {
                c2.Q = c2.r;
            }
            if (this.ju <= 0) {
                ++c2.R;
            }
            if (this.i9 <= 0) {
                ++c2.z;
            }
        }
    }
}

