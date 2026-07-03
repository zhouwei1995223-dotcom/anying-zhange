/*
 * Decompiled with CFR 0.152.
 */
package b.a.e;

import a.a.e;
import a.a.h;
import b.a.b;
import b.a.e.o;
import b.a.e.q;
import b.a.e.z;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class f
extends b {
    public static long ex;
    private static h eG;
    public static final int ez = 1;
    public static final int eC = 2;
    public static final int eB = 3;
    public int eH;
    public int eS;
    public int ey;
    public int eQ;
    public int eD;
    public int eE;
    public int eM;
    public int ew;
    public int eR;
    public int et;
    public int eN;
    public int ev;
    public int eP;
    public int eK;
    public int eA;
    public int eJ;
    public int eF = 1000;
    public int eI = 500;
    public int eT = 5;
    public String eO;
    public transient long eu;
    public transient int eL;
    public transient int eU = 24;

    public void a(e e2) {
        super.a(e2);
        this.eS = e2.case();
        this.eR = e2.case();
        this.et = e2.case();
        this.eN = e2.i();
        this.ev = e2.i();
        this.eP = e2.i();
        this.eK = e2.for();
        this.eJ = e2.j();
        this.eF = e2.do() * 100;
        this.eI = e2.for() * 100;
        this.eT = e2.for();
        this.eO = e2.h();
    }

    public static void if(h h2) {
        eG = h2;
    }

    public void if(e e2) {
        super.if(e2);
        e2.a(this.eS);
        e2.a(this.eR);
        e2.a(this.et);
        e2.char(this.eN);
        e2.char(this.ev);
        e2.char(this.eP);
        e2.a(this.eK);
        e2.for(this.eJ);
        e2.for(this.eF / 100);
        e2.a(this.eI / 100);
        e2.a(this.eT);
        e2.a(this.eO);
    }

    public static final f goto(int n2) {
        switch (n2) {
            case 1: {
                return new z();
            }
            case 2: {
                return new o();
            }
            case 3: {
                return new q();
            }
        }
        return null;
    }

    public void do(b b2) {
        super.do(b2);
        f f2 = (f)b2;
        this.eS = f2.eS;
        this.ey = f2.ey;
        this.eQ = f2.eQ;
        this.eD = f2.eD;
        this.eE = f2.eE;
        this.eM = f2.eM;
        this.ew = f2.ew;
        this.eR = f2.eR;
        this.et = f2.et;
        this.eN = f2.eN;
        this.ev = f2.ev;
        this.eP = f2.eP;
        this.eK = f2.eK;
        this.eA = f2.eA;
        this.eJ = f2.eJ;
        this.eF = f2.eF;
        this.eI = f2.eI;
        this.eT = f2.eT;
        this.eO = f2.eO;
    }

    public static final f else(int n2) {
        int n3 = eG.for();
        int n4 = 0;
        while (n4 < n3) {
            f f2 = (f)eG.if(n4);
            if (f2.if == n2) {
                return f2;
            }
            ++n4;
        }
        return null;
    }
}

