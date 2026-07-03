/*
 * Decompiled with CFR 0.152.
 */
package b.a.e;

import b.a.b;
import b.a.e.d;
import b.a.e.e;
import b.a.e.m;
import b.a.e.p;
import b.a.e.t;
import b.a.e.v;
import b.a.e.w;
import b.a.e.x;
import b.a.e.y;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class j
extends b {
    private static a fN;
    public static final String[] fX;
    public static final int fD = 0;
    public static final int fQ = 1;
    public static final int fP = 2;
    public static final int fG = 3;
    public static final int fE = 4;
    public static final int fU = 5;
    public static final int fJ = 6;
    public static final int fH = 7;
    public static final int fC = 8;
    public int fM;
    public int fW;
    public int fT;
    public int fS;
    public int fK;
    public int fO = 1;
    public int fL = 1;
    public int fV = 1;
    public int fF = 1;
    public String fR = "";
    public long fI;
    public int fY;

    public static void a(a a10) {
        fN = a10;
    }

    public void a(a.a.e e2) {
        super.a(e2);
        this.fM = e2.for();
        this.fT = e2.for();
        this.fS = e2.i();
        this.fK = e2.i();
        int n2 = e2.case();
        this.fO = n2 & 1;
        this.fL = n2 >> 1 & 1;
        this.fV = n2 >> 2 & 1;
        this.fF = n2 >> 3 & 1;
    }

    public void if(a.a.e e2) {
        super.if(e2);
        e2.a(this.fM);
        e2.a(this.fT);
        e2.char(this.fS);
        e2.char(this.fK);
        e2.a(this.fO | this.fL << 1 | this.fV << 2 | this.fF << 3);
    }

    public String toString() {
        return "Goods[id=" + this.if + ";name=" + this.a + "]";
    }

    public static final j h(int n2) {
        switch (n2) {
            case 0: {
                return new p();
            }
            case 1: {
                return new v();
            }
            case 2: {
                return new e();
            }
            case 3: {
                return new y();
            }
            case 4: {
                return new w();
            }
            case 5: {
                return new t();
            }
            case 6: {
                return new x();
            }
            case 7: {
                return new d();
            }
            case 8: {
                return new m();
            }
        }
        return null;
    }

    public void do(b b2) {
        super.do(b2);
        j j2 = (j)b2;
        this.fM = j2.fM;
        this.fT = j2.fT;
        this.fS = j2.fS;
        this.fK = j2.fK;
        this.fO = j2.fO;
        this.fL = j2.fL;
        this.fV = j2.fV;
        this.fF = j2.fF;
        this.fR = j2.fR;
        this.fI = 0L;
        this.fY = j2.fY;
    }

    public static final j i(int n2) {
        if (fN != null) {
            return fN.a(n2);
        }
        return null;
    }

    static {
        fX = new String[]{"\u836f\u54c1", "\u6b66\u5668", "\u9632\u5177", "\u9970\u54c1", "\u6280\u80fd\u4e66", "\u7279\u6b8a\u9053\u5177", "\u65f6\u88c5", "\u804a\u5929\u9053\u5177"};
    }

    public void byte(String string) {
    }

    public String U() {
        return "";
    }

    public static interface a {
        public j a(int var1);
    }
}

