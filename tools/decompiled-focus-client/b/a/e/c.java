/*
 * Decompiled with CFR 0.152.
 */
package b.a.e;

import a.a.e;
import a.a.h;
import b.a.b;
import b.a.d.k;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class c
extends b {
    public static h eh;
    public static final int dQ = 0;
    public static final int ea = 1;
    public static final int en = 2;
    public static final int dP = 3;
    public static final int dY = 4;
    public static final int dZ = 5;
    public static final int d4 = 6;
    public static final int d7 = 7;
    public static final int d8 = 8;
    public static final int ep = 9;
    public static final int d5 = 10;
    public static final int dN = 11;
    public static final int dX = 12;
    public static final int dT = 13;
    public static final int dW = 14;
    public static final int d2 = 15;
    public static final int eg = 16;
    public static final int d1 = 17;
    public static final int dH = 18;
    public static final int d3 = 19;
    public static final int ek = 20;
    public int dF;
    public int d0;
    public int dM;
    public int em;
    public int dS;
    public int dK;
    public int ee;
    public int ec;
    public int ei;
    public int el;
    public int d6;
    public int dL;
    public int d9;
    public int ed;
    public int dJ;
    public int eo;
    public String eb;
    public int dG;
    public int dV;
    public int es;
    public int er;
    public int eq;
    public int dI;
    public String dR;
    public String dU;
    public String dO;
    public transient long ej;
    public transient long ef;

    public void a(e e2) {
        super.a(e2);
        this.dF = e2.case();
        this.dG = e2.i();
        this.dV = e2.i();
        this.d9 = e2.i();
        this.ed = e2.i();
        this.dR = e2.h();
        this.dU = e2.h();
        this.dO = e2.h();
    }

    public void if(e e2) {
        super.if(e2);
        e2.a(this.dF);
        e2.char(this.dG);
        e2.char(this.dV);
        e2.char(this.d9);
        e2.char(this.ed);
        e2.a(this.dR);
        e2.a(this.dU);
        e2.a(this.dO);
    }

    public void do(b b2) {
        super.do(b2);
        c c2 = (c)b2;
        this.dF = c2.dF;
        this.d0 = c2.d0;
        this.dM = c2.dM;
        this.em = c2.em;
        this.dK = c2.dK;
        this.ee = c2.ee;
        this.ec = c2.ec;
        this.ei = c2.ei;
        this.dL = c2.dL;
        this.dJ = c2.dJ;
        this.eo = c2.eo;
        this.eb = c2.eb;
        this.dG = c2.dG;
        this.es = c2.es;
        this.dI = c2.dI;
        this.er = c2.er;
        this.eq = c2.eq;
        this.dR = c2.dR;
        this.dU = c2.dU;
        this.dO = c2.dO;
        this.ef = c2.ef;
    }

    public static void a(h h2) {
        eh = h2;
    }

    public static final c char(int n2) {
        if (eh == null) {
            return null;
        }
        int n3 = eh.for();
        int n4 = 0;
        while (n4 < n3) {
            c c2 = (c)eh.if(n4);
            if (c2.if == n2) {
                return c2;
            }
            ++n4;
        }
        return null;
    }

    public boolean do(k k2) {
        switch (this.dF) {
            case 1: {
                this.dV = 0;
                int n2 = 0;
                while (n2 < k2.bA.fr.length) {
                    if (k2.bA.fr[n2] != null && k2.bA.fr[n2].if == this.eo) {
                        ++this.dV;
                    }
                    ++n2;
                }
                break;
            }
        }
        return this.dV >= this.dG;
    }
}

