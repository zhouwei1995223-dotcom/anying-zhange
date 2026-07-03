/*
 * Decompiled with CFR 0.152.
 */
package b.a.e;

import a.a.e;
import b.a.b;
import b.a.e.j;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class y
extends j {
    public static final int iN = 1;
    public static final int iJ = 2;
    public static final int iw = 3;
    public int il;
    public int iK;
    public int io;
    public int iv;
    public int ip;
    public int ir;
    public int iB;
    public int iL;
    public int iI;
    public int iC;
    public int is;
    public int iz;
    public int iE;
    public int iG;
    public int iF;
    public int im;
    public int iM;
    public int iD;
    public int iA;
    public int it;
    public int in;
    public int iP;
    public int iq;
    public int iy;
    public int ix;
    public int[] iH = new int[4];
    public int[] iO = new int[4];
    public transient int iu;

    public void a(e e2) {
        super.a(e2);
        this.il = e2.case();
        this.iK = e2.do();
        this.io = e2.do();
        this.iI = e2.case();
        this.iC = e2.case();
        this.iv = e2.do();
        this.ip = e2.do();
        this.ir = e2.do();
        this.iB = e2.do();
        this.iL = e2.case();
        this.is = e2.for();
        this.iz = e2.for();
        this.iD = e2.for();
        this.iq = e2.for();
        this.iy = e2.for();
        if (e2.c()) {
            this.ix = e2.i();
            int n2 = 0;
            while (n2 < this.iH.length) {
                this.iH[n2] = e2.for();
                this.iO[n2] = e2.j();
                ++n2;
            }
        }
        this.fR = e2.h();
    }

    public void if(e e2) {
        super.if(e2);
        e2.a(this.il);
        e2.for(this.iK);
        e2.for(this.io);
        e2.a(this.iI);
        e2.a(this.iC);
        e2.for(this.iv);
        e2.for(this.ip);
        e2.for(this.ir);
        e2.for(this.iB);
        e2.a(this.iL);
        e2.a(this.is);
        e2.a(this.iz);
        e2.a(this.iD);
        e2.a(this.iq);
        e2.a(this.iy);
        e2.a(this.ix > 0);
        if (this.ix > 0) {
            e2.char(this.ix);
            int n2 = 0;
            while (n2 < this.iH.length) {
                e2.a(this.iH[n2]);
                e2.for(this.iO[n2]);
                ++n2;
            }
        }
        e2.a(this.fR);
    }

    public boolean a(String string, String string2) {
        if (string.equals("suitParamTypes")) {
            this.iH[this.iu] = Integer.parseInt(string2);
            return true;
        }
        if (string.equals("suitParamValues")) {
            this.iO[this.iu++] = Integer.parseInt(string2);
            return true;
        }
        return super.a(string, string2);
    }

    public y() {
        this.fW = 3;
    }

    public void do(b b2) {
        super.do(b2);
        y y2 = (y)b2;
        this.il = y2.il;
        this.iK = y2.iK;
        this.io = y2.io;
        this.iI = y2.iI;
        this.iC = y2.iC;
        this.iv = y2.iv;
        this.ip = y2.ip;
        this.ir = y2.ir;
        this.iB = y2.iB;
        this.iL = y2.iL;
        this.is = y2.is;
        this.iz = y2.iz;
        this.iD = y2.iD;
        this.iE = y2.iE;
        this.iG = y2.iG;
        this.iF = y2.iF;
        this.im = y2.im;
        this.iM = y2.iM;
        this.iy = y2.iy;
        this.iq = y2.iq;
        this.iA = y2.iA;
        this.it = y2.it;
        this.in = y2.in;
        this.iP = y2.iP;
        this.ix = y2.ix;
        System.arraycopy(y2.iH, 0, this.iH, 0, this.iH.length);
        System.arraycopy(y2.iO, 0, this.iO, 0, this.iO.length);
    }
}

