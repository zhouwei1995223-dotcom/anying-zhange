/*
 * Decompiled with CFR 0.152.
 */
package b.a.e;

import b.a.b;
import b.a.e.j;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class e
extends j {
    public static final int gw = 1;
    public static final int gc = 2;
    public static final int gh = 3;
    public static final int gx = 4;
    public int gb;
    public int gm;
    public int gB;
    public int gp;
    public int f9;
    public int gd;
    public int gk = 1;
    public int gs = 1;
    public int gr = 1;
    public int gi = 1;
    public int ge;
    public int gy;
    public int f8;
    public int f7;
    public int gD;
    public int gj;
    public int f6;
    public int gn;
    public int gC;
    public int ga;
    public int gl;
    public int gu;
    public int gq;
    public int gE;
    public int gt;
    public int gf;
    public int gA;
    public int go;
    public int[] f4 = new int[4];
    public int[] gz = new int[4];
    public int gg;
    public int gv;
    public transient int f5;

    public void a(a.a.e e2) {
        super.a(e2);
        this.gb = e2.case();
        this.gm = e2.case();
        this.gB = e2.do();
        this.f9 = e2.do();
        this.gp = e2.do();
        this.gd = e2.do();
        this.gk = e2.for();
        this.gs = e2.for();
        this.gr = e2.for();
        this.gi = e2.for();
        this.ge = e2.for();
        this.gy = e2.for();
        this.f8 = e2.for();
        this.f7 = e2.for();
        this.gD = e2.j();
        this.gj = e2.j();
        this.f6 = e2.for();
        this.gn = e2.case() * 10;
        this.gC = e2.case();
        int n2 = e2.for();
        this.ga = n2 >> 4;
        this.gu = n2 & 0xF;
        this.gl = e2.for();
        this.gA = e2.for();
        if (e2.c()) {
            this.go = e2.i();
            int n3 = 0;
            while (n3 < this.f4.length) {
                this.f4[n3] = e2.for();
                this.gz[n3] = e2.j();
                ++n3;
            }
        }
    }

    public void if(a.a.e e2) {
        super.if(e2);
        e2.a(this.gb);
        e2.a(this.gm);
        e2.for(this.gB);
        e2.for(this.f9);
        e2.for(this.gp);
        e2.for(this.gd);
        e2.a(this.gk);
        e2.a(this.gs);
        e2.a(this.gr);
        e2.a(this.gi);
        e2.a(this.ge);
        e2.a(this.gy);
        e2.a(this.f8);
        e2.a(this.f7);
        e2.for(this.gD);
        e2.for(this.gj);
        e2.a(this.f6);
        e2.a(this.gn / 10);
        e2.a(this.gC);
        e2.a(this.ga << 4 | this.gu);
        e2.a(this.gl);
        e2.a(this.gA);
        e2.a(this.go > 0);
        if (this.go > 0) {
            e2.char(this.go);
            int n2 = 0;
            while (n2 < this.f4.length) {
                e2.a(this.f4[n2]);
                e2.for(this.gz[n2]);
                ++n2;
            }
        }
    }

    public boolean a(String string, String string2) {
        if (string.equals("suitParamTypes")) {
            this.f4[this.f5] = Integer.parseInt(string2);
            return true;
        }
        if (string.equals("suitParamValues")) {
            this.gz[this.f5++] = Integer.parseInt(string2);
            return true;
        }
        return super.a(string, string2);
    }

    public e() {
        this.fW = 2;
    }

    public void do(b b2) {
        super.do(b2);
        e e2 = (e)b2;
        this.gb = e2.gb;
        this.gm = e2.gm;
        this.gB = e2.gB;
        this.f9 = e2.f9;
        this.gp = e2.gp;
        this.gd = e2.gd;
        this.gk = e2.gk;
        this.gs = e2.gs;
        this.gr = e2.gr;
        this.gi = e2.gi;
        this.ge = e2.ge;
        this.gy = e2.gy;
        this.f8 = e2.f8;
        this.f7 = e2.f7;
        this.gD = e2.gD;
        this.gj = e2.gj;
        this.f6 = e2.f6;
        this.gn = e2.gn;
        this.gC = e2.gC;
        this.ga = e2.ga;
        this.gl = e2.gl;
        this.gu = e2.gu;
        this.gq = e2.gq;
        this.gE = e2.gE;
        this.gt = e2.gt;
        this.gf = e2.gf;
        this.gA = e2.gA;
        this.go = e2.go;
        System.arraycopy(e2.f4, 0, this.f4, 0, this.f4.length);
        System.arraycopy(e2.gz, 0, this.gz, 0, this.gz.length);
        this.gg = e2.gg;
        this.gv = e2.gv;
    }
}

