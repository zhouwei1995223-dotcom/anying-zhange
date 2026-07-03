/*
 * Decompiled with CFR 0.152.
 */
package b.a.d;

import a.a.b;
import a.a.e;
import b.a.d.d;
import b.a.d.l;
import b.a.e.g;
import b.a.e.h;
import b.a.e.i;
import b.a.e.s;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class k
extends d {
    public static final int[] aD = new int[256];
    public static final int[] aZ = new int[]{60, 70, 80, 90, 100, 110, 120, 130, 255};
    public static final int[] aN;
    public static final int[] a0;
    public static final int[] be;
    public static final int[] bC;
    public static final int[] bJ;
    public static final int[] bK;
    public static final int[] bI;
    public static final int[] bM;
    public static final int[] aM;
    public static final int[] aO;
    public static final int aB = 600;
    public static final int aC = 1000;
    public static final int bf = 500;
    public transient int aU;
    public transient int bz;
    public String bx = "";
    public int a9;
    public int bv;
    public int bl;
    public int aG;
    public int bc;
    public int bj;
    public int bw;
    public int bk;
    public int bm;
    public int bn;
    public int aW;
    public int bu;
    public int aT;
    public int bF;
    public int aR;
    public int bt;
    public int bg;
    public int bH;
    public int bs;
    public int aE;
    public int bi;
    public int aQ;
    public int bG;
    public int bB;
    public int bd;
    public int aL;
    public int a7;
    public int az;
    public int aA;
    public int bq;
    public int by;
    public int bh;
    public int bo;
    public transient int at;
    public transient int aV;
    public int bD;
    public transient int aJ;
    public transient int a4;
    public transient int bL;
    public transient int a3;
    public transient int aH;
    public transient int aF;
    public long aX;
    public long au;
    public int bb;
    public int br;
    public int bE;
    public int a1 = 0;
    public int ba;
    public transient int a8 = 1;
    public transient int aS;
    public transient boolean aY = true;
    public transient boolean av = true;
    public transient boolean aP = true;
    public transient boolean a5 = true;
    public transient l a2;
    public transient h bA = new h();
    public transient g aw = new g();
    public transient i aI = new i();
    public transient b.a.e.k ay = new b.a.e.k();
    public transient s ax = new s();
    public transient boolean aK;
    public transient boolean bp;
    public transient Object a6;

    public int void() {
        return super.void() + this.bj;
    }

    public void for(e e2) {
        super.a(e2);
        if (e2.for() > 0) {
            this.bx = "1";
        }
        this.K = e2.j();
        this.Y = e2.j();
        this.a9 = e2.i();
        this.N = e2.j();
        this.G = e2.j();
        this.X = e2.j();
        this.bv = e2.do();
        this.bl = e2.do();
        this.aG = e2.do();
        this.bc = e2.do();
        this.bj = e2.do();
        this.bw = e2.do();
        this.bk = e2.do();
        this.bm = e2.do();
        this.bn = e2.do();
        this.D = e2.j();
        this.Z = e2.j();
        this.aa = e2.j();
        this.B = e2.j();
        this.U = e2.j();
        this.L = e2.j();
        this.T = e2.j();
        this.E = e2.j();
        this.y = e2.j();
        this.n = e2.j();
        this.A = e2.j();
        this.x = e2.j();
        this.V = e2.case();
        this.aL = e2.do();
        this.ar = this.aL > 1 ? 2 : 0;
        this.az = e2.i();
        this.bq = e2.i();
        this.bh = e2.i();
        this.bi = e2.i();
        this.br = e2.case();
        if (this.br > 0) {
            this.bb = e2.case();
            this.aX = a.a.b.if(e2.i()).getTime();
            this.au = a.a.b.if(e2.i()).getTime();
        }
        this.bA.a(e2);
        this.aw.a(e2);
        this.aI.a(e2);
        this.ax.a(e2);
    }

    public void do(e e2) {
        super.if(e2);
        e2.a(this.bx.length());
        e2.for(this.K);
        e2.for(this.Y);
        e2.char(this.a9);
        e2.for(this.N);
        e2.for(this.G);
        e2.for(this.X);
        e2.for(this.bv);
        e2.for(this.bl);
        e2.for(this.aG);
        e2.for(this.bc);
        e2.for(this.bj);
        e2.for(this.bw);
        e2.for(this.bk);
        e2.for(this.bm);
        e2.for(this.bn);
        e2.for(this.D);
        e2.for(this.Z);
        e2.for(this.aa);
        e2.for(this.B);
        e2.for(this.U);
        e2.for(this.L);
        e2.for(this.T);
        e2.for(this.E);
        e2.for(this.y);
        e2.for(this.n);
        e2.for(this.A);
        e2.for(this.x);
        e2.a(this.V);
        e2.for(this.aL);
        e2.char(this.az);
        e2.char(this.bq);
        e2.char(this.bh);
        e2.char(this.bi);
        e2.a(this.br);
        if (this.br > 0) {
            e2.a(this.bb);
            e2.char(a.a.b.a(this.aX));
            e2.char(a.a.b.a(this.au));
        }
        if (this.bA == null) {
            this.bA = new h();
        }
        this.bA.if(e2);
        if (this.aw == null) {
            this.aw = new g();
        }
        this.aw.if(e2);
        if (this.aI == null) {
            this.aI = new i();
        }
        this.aI.if(e2);
        this.ax.if(e2);
    }

    public void do(int n2) {
        if (n2 < this.p) {
            int n3 = this.N + this.G + this.X;
            this.N = bK[this.af] + a0[this.af] * n2;
            this.G = bI[this.af] + be[this.af] * n2;
            this.X = bM[this.af] + bC[this.af] * n2;
            int n4 = this.N + this.G + this.X;
            this.bv += n3 - n4;
            this.i();
        }
    }

    public boolean h() {
        return this.au != 0L;
    }

    public void d() {
        this.a9 = 0;
        ++this.p;
        this.N += a0[this.af];
        this.G += be[this.af];
        this.X += bC[this.af];
        this.i();
        this.Q = this.r;
        this.K = this.Y;
    }

    public String toString() {
        return "hero{name=" + this.a + ";user=" + this.a2 + "}";
    }

    public void for(int n2) {
        int n3 = 0;
        if (this.bA.fp != null) {
            n3 = this.bA.fp.fM;
        }
        this.bl += (int)((float)(this.bA.D() + this.bA.new(this)) * (0.1f * (1.0f + (float)n3 * 0.15f)));
        this.aG += (int)((float)(this.bA.x() + this.bA.new(this)) * (0.1f * (1.0f + (float)n3 * 0.15f)));
        this.bc += (int)((float)(this.bA.R() + this.bA.byte(this)) * (0.1f * (1.0f + (float)n3 * 0.15f)));
        this.bj += (int)((float)(this.bA.C() + this.bA.byte(this)) * (0.1f * (1.0f + (float)n3 * 0.15f)));
        this.bw += this.bA.if(this, true);
        this.bk += this.bA.a(this, true);
        this.bm += this.bA.if(true);
        this.bn += this.bA.a(true);
        this.bA.T();
        this.bA.S();
        this.bA.A();
        this.ay = new b.a.e.k();
        this.p = n2;
        this.a9 = 0;
        this.N = bK[this.af];
        this.G = bI[this.af];
        this.X = bM[this.af];
        this.N += a0[this.af] * n2;
        this.G += be[this.af] * n2;
        this.X += bC[this.af] * n2;
        this.bv += bJ[this.ab];
        this.i();
        this.Q = this.r;
        this.K = this.Y;
        ++this.ab;
    }

    public int f() {
        return 0;
    }

    public int k() {
        return aD[this.p];
    }

    public int goto() {
        return super.goto() + this.bl;
    }

    public void g() {
        if (this.p != 0 || this.a9 < aD[0]) {
            return;
        }
        this.p = this.j();
        int n2 = aD[0];
        int n3 = 1;
        while (n3 < aD.length) {
            if (this.a9 < n2) {
                this.p = n3;
                this.a9 -= n2 - aD[n3 - 1];
                break;
            }
            n2 += aD[n3];
            ++n3;
        }
    }

    static {
        int[] nArray = aD;
        float[] fArray = new float[]{1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.5f, 2.0f, 2.5f, 3.0f, 3.5f, 5.0f, 10.0f, 13.0f, 16.0f, 20.0f};
        nArray[0] = 10;
        int n2 = 1;
        while (n2 < aD.length) {
            double d2 = (n2 + 1) * (n2 + 1);
            double d3 = d2 * d2;
            double d4 = Math.round(d3 / 100.0 + d2 * 10.0);
            int n3 = 0;
            if (n2 < 95) {
                n3 = (int)(d4 * (double)fArray[n2 / 10]);
            } else {
                int n4 = (n2 - 95) / 5 + 10;
                if (n4 >= fArray.length) {
                    n4 = fArray.length - 1;
                }
                n3 = (int)(d4 * (double)fArray[n4]);
            }
            nArray[n2] = n3;
            ++n2;
        }
        b.a.d.k.aD[b.a.d.k.aD.length - 1] = 0;
        aN = new int[]{6, 6, 6};
        a0 = new int[]{2, 1, 3};
        be = new int[]{3, 2, 2};
        bC = new int[]{1, 3, 1};
        bJ = new int[]{10, 20, 30, 40, 50, 60, 70, 70, 70};
        bK = new int[]{2, 2, 6};
        bI = new int[]{6, 2, 2};
        bM = new int[]{2, 6, 2};
        aM = new int[]{450, 400, 500};
        aO = new int[]{150, 200, 120};
    }

    public void if(int n2) {
        n2 = this.a9 + n2;
        while (this.p < this.j() && n2 >= this.k()) {
            n2 -= this.k();
            this.d();
        }
        this.a9 = n2;
    }

    public int else() {
        return super.else() + this.aG;
    }

    public int for() {
        return super.for() + this.bc;
    }

    public void i() {
        if (this.bA == null) {
            this.bA = new h();
        }
        this.V = this.af == 0 ? 5 : 2;
        if (this.bA.fp != null) {
            this.V += this.bA.fp.ia;
        }
        if (this.N == 0 || this.G == 0 || this.X == 0) {
            this.N = bK[this.af] + a0[this.af] * this.p;
            this.G = bI[this.af] + be[this.af] * this.p;
            this.X = bM[this.af] + bC[this.af] * this.p;
            this.bv = 0;
            if (this.ab > 0) {
                this.bv = bJ[this.ab - 1];
            }
        }
        this.aa = this.goto();
        this.aa += this.bA.D() + this.bA.new(this);
        this.B = this.else();
        this.B += this.bA.x() + this.bA.new(this);
        this.U = this.for();
        this.U += this.bA.R() + this.bA.byte(this);
        this.L = this.void();
        this.L += this.bA.C() + this.bA.byte(this);
        this.T = this.N / 2 + this.G * 4 / 10 + (this.N * this.N / 900 + this.G / 25) * 2;
        this.T += this.bw;
        this.E = this.X * 6 / 10 + this.G * 3 / 10 + (this.X * this.X / 900 + this.G / 25) * 2;
        this.E += this.bk;
        this.y = this.n = this.G * 2 / 10 + this.G * this.G / 2500 + this.p / 8 + 5;
        this.y += this.bA.L();
        this.n += this.bA.J();
        this.D = 600 + this.bA.N();
        this.A = 1000 + this.bA.w();
        this.x = 500 + this.bA.I();
        this.r = this.N * 8 + this.p * 12 + aM[this.af] + this.bA.E() + this.bm;
        this.r += this.O;
        this.Y = this.X * 5 + this.p * 8 + aO[this.af] + this.bA.G() + this.bn;
        if (this.Q > this.r) {
            this.Q = this.r;
        }
        if (this.K > this.Y) {
            this.K = this.Y;
        }
        this.ac = this.bA.fq != null ? this.bA.fq.ik : (this.bA.fx != null ? this.bA.fx.gm : 0);
        this.aq = this.bA.B();
        this.aU = this.bA.fm != null && this.bA.fm.iF != 0 ? this.bA.fm.iF : (this.bA.fw != null && this.bA.fw.iF != 0 ? this.bA.fw.iF : 100);
        this.bz = 100;
    }

    public void e() {
        this.p = 0;
        this.bv = 0;
        this.N = bK[this.af];
        this.G = bI[this.af];
        this.X = bM[this.af];
        this.i();
        this.Q = this.r;
        this.K = this.Y;
    }

    public int j() {
        return aZ[this.ab];
    }
}

