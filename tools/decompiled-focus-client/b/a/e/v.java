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
public class v
extends j {
    public int ic;
    public int hT;
    public int h6;
    public int hG;
    public int h9;
    public int h1;
    public int h2;
    public int hV;
    public int hO = 1;
    public int hZ = 1;
    public int hX = 1;
    public int hM = 1;
    public int hJ;
    public int h5;
    public int hF;
    public int hE;
    public int hQ;
    public int ia;
    public int hR;
    public int hN;
    public int hY = 20;
    public int hD;
    public int hS;
    public int hH;
    public int hP;
    public int h3;
    public int hW;
    public int ib;
    public int h0;
    public int hK;
    public int h8;
    public int hU;
    public int[] hB = new int[4];
    public int[] h7 = new int[4];
    public transient int hC;
    public int hL;
    public int h4;
    public String hI = "";

    public void a(e e2) {
        super.a(e2);
        this.ic = e2.do();
        this.hT = e2.do();
        this.h6 = e2.do();
        this.hG = e2.do();
        this.h9 = e2.do();
        this.h1 = e2.do();
        this.h2 = e2.do();
        this.hV = e2.do();
        this.hO = e2.for();
        this.hZ = e2.for();
        this.hX = e2.for();
        this.hM = e2.for();
        this.hJ = e2.for();
        this.h5 = e2.for();
        this.hF = e2.for();
        this.hE = e2.for();
        this.hQ = e2.for();
        this.ia = e2.for();
        this.hR = e2.case() * 10;
        this.hN = e2.case() * 10;
        this.hY = e2.case();
        int n2 = e2.for();
        this.hH = n2 >> 4;
        this.h3 = n2 & 0xF;
        this.hP = e2.for();
        this.h8 = e2.for();
        if (e2.c()) {
            this.hU = e2.i();
            int n3 = 0;
            while (n3 < this.hB.length) {
                this.hB[n3] = e2.for();
                this.h7[n3] = e2.j();
                ++n3;
            }
        }
        this.hI = e2.h();
    }

    public void if(e e2) {
        super.if(e2);
        e2.for(this.ic);
        e2.for(this.hT);
        e2.for(this.h6);
        e2.for(this.hG);
        e2.for(this.h9);
        e2.for(this.h1);
        e2.for(this.h2);
        e2.for(this.hV);
        e2.a(this.hO);
        e2.a(this.hZ);
        e2.a(this.hX);
        e2.a(this.hM);
        e2.a(this.hJ);
        e2.a(this.h5);
        e2.a(this.hF);
        e2.a(this.hE);
        e2.a(this.hQ);
        e2.a(this.ia);
        e2.a(this.hR / 10);
        e2.a(this.hN / 10);
        e2.a(this.hY);
        e2.a(this.hH << 4 | this.h3);
        e2.a(this.hP);
        e2.a(this.h8);
        e2.a(this.hU > 0);
        if (this.hU > 0) {
            e2.char(this.hU);
            int n2 = 0;
            while (n2 < this.hB.length) {
                e2.a(this.hB[n2]);
                e2.for(this.h7[n2]);
                ++n2;
            }
        }
        e2.a(this.hI);
    }

    public boolean a(String string, String string2) {
        if (string.equals("suitParamTypes")) {
            this.hB[this.hC] = Integer.parseInt(string2);
            return true;
        }
        if (string.equals("suitParamValues")) {
            this.h7[this.hC++] = Integer.parseInt(string2);
            return true;
        }
        return super.a(string, string2);
    }

    public v() {
        this.fW = 1;
    }

    public void do(b b2) {
        super.do(b2);
        v v2 = (v)b2;
        this.ic = v2.ic;
        this.hT = v2.hT;
        this.h6 = v2.h6;
        this.hG = v2.hG;
        this.h9 = v2.h9;
        this.h1 = v2.h1;
        this.h2 = v2.h2;
        this.hV = v2.hV;
        this.hO = v2.hO;
        this.hZ = v2.hZ;
        this.hX = v2.hX;
        this.hM = v2.hM;
        this.hJ = v2.hJ;
        this.h5 = v2.h5;
        this.hF = v2.hF;
        this.hE = v2.hE;
        this.hQ = v2.hQ;
        this.ia = v2.ia;
        this.hR = v2.hR;
        this.hN = v2.hN;
        this.hY = v2.hY;
        this.hD = v2.hD;
        this.hS = v2.hS;
        this.hH = v2.hH;
        this.hP = v2.hP;
        this.h3 = v2.h3;
        this.hW = v2.hW;
        this.ib = v2.ib;
        this.h0 = v2.h0;
        this.hK = v2.hK;
        this.hI = v2.hI;
        this.h8 = v2.h8;
        this.hU = v2.hU;
        System.arraycopy(v2.hB, 0, this.hB, 0, this.hB.length);
        System.arraycopy(v2.h7, 0, this.h7, 0, this.h7.length);
        this.hL = v2.hL;
        this.h4 = v2.h4;
    }
}

