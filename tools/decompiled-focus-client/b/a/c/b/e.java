/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.z;
import b.a.c.b;
import b.a.c.b.a;
import b.a.c.b.a3;
import b.a.c.b.a5;
import b.a.c.b.a6;
import b.a.c.b.a7;
import b.a.c.b.a9;
import b.a.c.b.aa;
import b.a.c.b.ab;
import b.a.c.b.ac;
import b.a.c.b.ad;
import b.a.c.b.ae;
import b.a.c.b.af;
import b.a.c.b.ag;
import b.a.c.b.ah;
import b.a.c.b.ai;
import b.a.c.b.ak;
import b.a.c.b.am;
import b.a.c.b.an;
import b.a.c.b.ao;
import b.a.c.b.aq;
import b.a.c.b.ar;
import b.a.c.b.as;
import b.a.c.b.av;
import b.a.c.b.ax;
import b.a.c.b.ay;
import b.a.c.b.bb;
import b.a.c.b.bd;
import b.a.c.b.be;
import b.a.c.b.c;
import b.a.c.b.d;
import b.a.c.b.f;
import b.a.c.b.h;
import b.a.c.b.k;
import b.a.c.b.l;
import b.a.c.b.o;
import b.a.c.b.p;
import b.a.c.b.q;
import b.a.c.b.s;
import b.a.c.b.t;
import b.a.c.b.u;
import b.a.c.b.v;
import b.a.c.b.w;
import b.a.c.b.x;
import b.a.e.j;
import b.a.e.y;
import java.awt.Point;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class e
extends a.b.s {
    public static a.b.af aZ;
    public static a.b.af a5;
    public static int bi;
    public static final a.b.af[][] a3;
    private static final int[] aX;
    private static final char[] aO;
    private ae a6;
    private b bo;
    private am aP;
    private a7 aI;
    private d bm;
    private s bl;
    private ad bk;
    private bd bu;
    private q bn;
    private a5 bj;
    private a5 aS;
    private a aK;
    private k bg;
    private t bp;
    private ay aL;
    private as bh;
    private f aN;
    private o a9;
    private af ba;
    private ah bs;
    private an bx;
    private w bd;
    private a9 aM;
    private l aT;
    private x a4;
    private ac a7;
    private aa aY;
    private bb be;
    private be bf;
    private h aJ;
    private a3 a2;
    private aq aR;
    private c bb;
    private ao a8;
    private b.a.c.b.b a1;
    private u bc;
    private ax aV;
    private ak bw;
    private p aQ;
    private v br;
    private a6 a0;
    private av aU;
    private ab bv;
    private ar aW;
    private ai bt;
    private ag bq;

    public static void a(a.b.c c2, int n2, int n3, int n4) {
        c2.if(aZ, n2, n3, 88, 92, 17, 26);
        int n5 = n2 + n4 - 13;
        int n6 = n2 + 17;
        while (n6 < n5) {
            c2.if(aZ, n6, n3, 114, 92, 15, 26);
            n6 += 15;
        }
        c2.if(aZ, n5, n3, 140, 92, 13, 26);
    }

    public ai aj() {
        return this.bt;
    }

    public a6 ac() {
        return this.a0;
    }

    public ac V() {
        return this.a7;
    }

    public u aC() {
        return this.bc;
    }

    public l az() {
        return this.aT;
    }

    public aa ax() {
        return this.aY;
    }

    public aq aw() {
        return this.aR;
    }

    public void ap() {
        this.bl.ba();
    }

    public b.a.c.b.b af() {
        return this.a1;
    }

    public static void for(a.b.c c2, int n2, int n3, int n4) {
        c2.if(aZ, n2, n3, 88, 58, 17, 26);
        int n5 = n2 + n4 - 13;
        int n6 = n2 + 17;
        while (n6 < n5) {
            c2.if(aZ, n6, n3, 114, 58, 15, 26);
            n6 += 15;
        }
        c2.if(aZ, n5, n3, 140, 58, 13, 26);
    }

    public static Point for(a.b.s s2) {
        int n2 = s2.getX();
        int n3 = s2.getY();
        a.b.s s3 = (a.b.s)s2.getParent();
        while (!(s3 instanceof a.b.h)) {
            n2 += s3.getX();
            n3 += s3.getY();
            s3 = (a.b.s)s3.getParent();
        }
        return new Point(n2, n3);
    }

    public ak aA() {
        return this.bw;
    }

    public as aE() {
        return this.bh;
    }

    public ax am() {
        return this.aV;
    }

    public ar at() {
        return this.aW;
    }

    public ag au() {
        return this.bq;
    }

    public p aJ() {
        return this.aQ;
    }

    public a5 aD() {
        return this.bj;
    }

    public a5 Z() {
        return this.aS;
    }

    public ay av() {
        return this.aL;
    }

    public af aq() {
        return this.ba;
    }

    public be ad() {
        return this.bf;
    }

    public static void if(a.b.c c2, int n2, int n3, int n4, int n5) {
        int n6 = n2;
        int n7 = n2 + n4 - 16;
        int n8 = n3;
        c2.if(aZ, n6, n8, 194, 98, 14, 4);
        c2.do(n6 += 14, n8, n7, n8, -15001836);
        c2.do(n6, ++n8, n7, n8, -2435373);
        c2.do(n6, ++n8, n7, n8, -14671830);
        c2.do(n6, ++n8, n7, n8, -8553081);
        c2.if(aZ, n7, n3, 222, 98, 16, 4);
        n6 = n2;
        n8 = n3 + 4;
        int n9 = n3 + n5 - 14;
        c2.if(aZ, n6, n8, 194, 102, 4, 10);
        c2.do(n6, n8 += 10, n6, n9, -14409444);
        c2.do(++n6, n8, n6, n9, -10330278);
        c2.do(++n6, n8, n6, n9, -7960703);
        c2.do(++n6, n8, n6, n9, -14605796);
        c2.if(aZ, n2, n9, 194, 120, 4, 14);
        n6 = n2 + 4;
        n8 = n3 + n5 - 3;
        n7 = n2 + n4 - 16;
        c2.if(aZ, n6, n8, 198, 131, 9, 3);
        c2.if(aZ, n7, n8, 222, 131, 16, 3);
        c2.do(n6 += 9, n8, n7, n8, -6974562);
        c2.do(n6, ++n8, n7, n8, -10068912);
        c2.do(n6, ++n8, n7, n8, -10068912);
        n8 = n3 + 4;
        n7 = n2 + n4 - 4;
        n9 = n3 + n5 - 14;
        c2.if(aZ, n7, n8, 234, 102, 4, 12);
        c2.if(aZ, n7, n9, 234, 120, 4, 10);
        c2.do(n7, n8 += 12, n7, n9, -14343912);
        c2.do(++n7, n8, n7, n9, -7698819);
        c2.do(++n7, n8, n7, n9, -10396073);
        c2.do(++n7, n8, n7, n9, -14605795);
    }

    public static void a(a.b.c c2, int n2, int n3) {
        c2.if(aZ, n2, n3, 784, 68, 2, 28);
        c2.do(n2 + 2, n3, n2 + 26, n3, -4673104);
        c2.if(aZ, n2 + 2, n3 + 25, 786, 93, 5, 3);
        c2.do(n2 + 7, n3 + 25, n2 + 22, n3 + 25, -11449277);
        c2.do(n2 + 7, n3 + 26, n2 + 22, n3 + 26, -4739929);
        c2.do(n2 + 7, n3 + 27, n2 + 22, n3 + 27, -11852268);
        c2.if(aZ, n2 + 22, n3 + 25, 808, 93, 6, 3);
        c2.if(aZ, n2 + 26, n3, 812, 68, 2, 25);
    }

    public void aN() {
        bi = this.bo.if("uiBackground", bi);
        if (aZ == null) {
            aZ = a.b.v.if.for("image/ui/ui.img");
        }
        if (a5 == null) {
            a5 = a.b.v.if.for("image/ui/icon.img");
        }
        this.aP = new am(this.bo);
        this.aP.setBounds(0, 0, this.getWidth(), 40);
        this.aP.bt();
        this.add(this.aP);
        this.aI = new a7(this.bo);
        this.aI.setBounds(0, this.getHeight() - 72, this.getWidth(), 72);
        this.aI.dU();
        this.add(this.aI);
        this.bm = new d(this.bo);
        this.bm.setBounds(this.getWidth() - 340, 40, 340, this.getHeight() - 107);
        this.bm.U();
        this.add(this.bm);
        this.bl = new s(this.bo.for());
        this.bl.setBounds(0, this.getHeight() - 77, this.getWidth() - this.bm.getWidth(), 5);
        this.bl.bb();
        this.add(this.bl);
        this.bd = new w(this.bo);
        this.bd.co();
        this.add(this.bd);
        this.aM = new a9(this.bo);
        this.aM.dD();
        this.add(this.aM);
        this.be = new bb(this.bo);
        this.be.dG();
        this.add(this.be);
        this.a2 = new a3(this.bo);
        this.a2.dl();
        this.add(this.a2);
        this.aR = new aq(this.bo);
        this.aR.cZ();
        this.add(this.aR);
        this.bx = new an(this.bo);
        this.bx.cW();
        this.add(this.bx);
        this.bv = new ab(this.bo);
        this.bv.cC();
        this.add(this.bv);
        this.aW = new ar(this.bo);
        this.aW.c6();
        this.add(this.aW);
        this.a4 = new x(this.bo);
        this.a4.cs();
        this.add(this.a4);
        this.bn = new q(this.bo);
        this.bn.cf();
        this.add(this.bn);
        this.bj = new a5(this.bo, true);
        this.bj.dw();
        this.add(this.bj);
        this.aS = new a5(this.bo, false);
        this.aS.dw();
        this.add(this.aS);
        this.aK = new a(this.bo);
        this.aK.dJ();
        this.add(this.aK);
        this.bg = new k(this.bo);
        this.bg.b9();
        this.add(this.bg);
        this.bp = new t(this.bo);
        this.bp.cj();
        this.add(this.bp);
        this.bh = new as(this.bo);
        this.bh.db();
        this.add(this.bh);
        this.aL = new ay(this.bo);
        this.aL.dk();
        this.add(this.aL);
        this.aN = new f(this.bo);
        this.aN.b5();
        this.add(this.aN);
        this.a9 = new o(this.bo);
        this.a9.cc();
        this.add(this.a9);
        this.ba = this.bo.void();
        this.aT = new l(this.bo);
        this.aT.cb();
        this.add(this.aT);
        this.a7 = new ac(this.bo);
        this.a7.cE();
        this.add(this.a7);
        this.aY = new aa(this.bo);
        this.aY.cu();
        this.add(this.aY);
        this.bf = new be(this.bo);
        this.bf.dH();
        this.add(this.bf);
        this.bs = new ah(this.bo);
        this.bs.bn();
        this.add(this.bs);
        this.bb = new c(this.bo);
        this.bb.bZ();
        this.add(this.bb);
        this.a8 = new ao(this.bo);
        this.a8.cX();
        this.add(this.a8);
        this.a1 = new b.a.c.b.b(this.bo);
        this.a1.bY();
        this.add(this.a1);
        this.bc = new u(this.bo);
        this.bc.ck();
        this.add(this.bc);
        this.aV = new ax(this.bo);
        this.aV.dh();
        this.add(this.aV);
        this.bu = new bd(this.bo);
        this.bu.setBounds(0, 40, this.getWidth() - 340, this.getHeight() - 117);
        this.bu.d2();
        this.add(this.bu);
        this.bk = new ad(this.bo);
        this.add(this.bk);
        this.aJ = new h(this.bo);
        this.aJ.setBounds(this.getWidth() - this.bm.getWidth() - 26, this.getHeight() - this.aI.getHeight() - 32, 24, 24);
        this.add(this.aJ);
        this.a6 = new ae(this.bo);
        this.a6.setLocation((this.getWidth() - this.a6.getWidth() - 300) / 2, (this.getHeight() - this.a6.getHeight()) / 2);
        this.add(this.a6);
        this.bw = new ak(this.bo);
        this.bw.cR();
        this.add(this.bw);
        this.aQ = new p(this.bo);
        this.aQ.ce();
        this.add(this.aQ);
        this.br = new v(this.bo);
        this.br.cm();
        this.add(this.br);
        this.a0 = new a6(this.bo);
        this.a0.dC();
        this.add(this.a0);
        this.aU = new av(this.bo);
        this.aU.df();
        this.add(this.aU);
        this.bt = new ai(this.bo);
        this.bt.cP();
        this.add(this.bt);
        this.bq = new ag(this.bo);
        this.bq.cM();
        this.add(this.bq);
    }

    public d aB() {
        return this.bm;
    }

    public q ay() {
        return this.bn;
    }

    public f X() {
        return this.aN;
    }

    public ad an() {
        return this.bk;
    }

    public static int int(a.b.c c2, int n2, int n3, int n4) {
        return e.a(c2, n2, n3, n4, 0xFFFFFF);
    }

    public static int a(a.b.c c2, int n2, int n3, int n4, int n5) {
        int n6 = aO.length;
        do {
            e.aO[--n6] = (char)(n2 % 10 + 48);
        } while ((n2 /= 10) != 0);
        int n7 = n6;
        while (n7 < aO.length) {
            c2.a(aO[n7], n3, n4, n5);
            ++n7;
            n3 += 6;
        }
        return n3;
    }

    public a7 ab() {
        return this.aI;
    }

    public a aL() {
        return this.aK;
    }

    public ab aO() {
        return this.bv;
    }

    public bb ag() {
        return this.be;
    }

    public static void if(a.b.c c2, int n2, int n3, int n4) {
        int n5 = 0;
        while (n5 < aX.length) {
            c2.do(n2, n3 + n5, n4, n3 + n5, aX[n5]);
            ++n5;
        }
    }

    public void a(long l2) {
        this.bu.a(l2);
        if (this.aW.isVisible()) {
            this.aW.a(l2);
        }
        if (this.aU.isVisible()) {
            this.aU.a(l2);
        }
        if (this.a0.isVisible()) {
            this.a0.a(l2);
        }
    }

    public k aF() {
        return this.bg;
    }

    public static void a(a.b.c c2, b.a.e.f f2, int n2, int n3) {
        int n4 = f2.eU;
        int n5 = (f2.eS - 1) * 24;
        c2.if(a5, n2, n3, n5, 480, 24, 24);
        int n6 = 24 - n4;
        if (n6 > 0) {
            c2.a(n2, n3, 24, n6, -1358954496);
        }
    }

    public o aa() {
        return this.a9;
    }

    public x ak() {
        return this.a4;
    }

    public static int c(int n2) {
        int n3 = 0;
        while (n2 > 0) {
            n3 += 6;
            n2 /= 10;
        }
        return n3;
    }

    public a9 al() {
        return this.aM;
    }

    public a3 aM() {
        return this.a2;
    }

    public ao aI() {
        return this.a8;
    }

    public bd ai() {
        return this.bu;
    }

    public v ao() {
        return this.br;
    }

    public c ar() {
        return this.bb;
    }

    public boolean Y() {
        int n2 = this.getComponentCount();
        int n3 = 0;
        while (n3 < n2) {
            a.b.s s2 = this.do(n3);
            if (s2.isVisible() && s2 instanceof z) {
                s2.setVisible(false);
                return true;
            }
            ++n3;
        }
        return false;
    }

    public e(b b2) {
        this.bo = b2;
    }

    public static final void if(a.b.c c2, int n2, int n3) {
        e.a(c2, null, n2, n3);
    }

    public static final void a(a.b.c c2, String string, int n2, int n3) {
        c2.a(4, 30, n2 - 8, n3 - 59, -1627389952);
        e.if(c2, 0, 26, n2, n3 - 52);
        e.for(c2, 0, 0, n2);
        e.a(c2, 0, n3 - 26, n2);
        if (string != null) {
            c2.a(string, 10, 9, -14698241);
        }
    }

    public am aK() {
        return this.aP;
    }

    public ah ae() {
        return this.bs;
    }

    public an aG() {
        return this.bx;
    }

    public w ah() {
        return this.bd;
    }

    static {
        bi = -15460330;
        a3 = new a.b.af[3][2];
        aX = new int[]{-8287098, -10068658, -9476521, -15197932};
        aO = new char[12];
    }

    public static void do(a.b.c c2, int n2, int n3, int n4) {
        int n5 = aO.length;
        do {
            e.aO[--n5] = (char)(n2 % 10 + 48);
        } while ((n2 /= 10) != 0);
        int n6 = 0xFFFFFF;
        int n7 = 0;
        n3 += 6 * (aO.length - n5);
        int n8 = aO.length - 1;
        while (n8 >= n5) {
            if (n7 >= 8) {
                n6 = 0xFF1111;
            } else if (n7 >= 4) {
                n6 = 196586;
            }
            c2.a(aO[n8], n3, n4, n6);
            --n8;
            n3 -= 6;
            ++n7;
        }
    }

    public void b(int n2) {
        this.aJ.d(n2);
    }

    public av as() {
        return this.aU;
    }

    public t W() {
        return this.bp;
    }

    public ae aH() {
        return this.a6;
    }

    public static void if(a.b.c c2, j j2, int n2, int n3) {
        block0 : switch (j2.fW) {
            case 0: {
                c2.a(a5, n2, n3, (j2.fT - 1) * 24, 0, 24, 24);
                break;
            }
            case 1: {
                b.a.e.v v2 = (b.a.e.v)j2;
                c2.a(a5, n2, n3, (j2.fT - 1) * 24, v2.hH * 30 + 330, 24, 24);
                break;
            }
            case 2: {
                b.a.e.e e2 = (b.a.e.e)j2;
                switch (e2.gb) {
                    case 1: {
                        c2.a(a5, n2, n3, (j2.fT - 1) * 24, e2.ga * 90 + 60, 24, 24);
                        break block0;
                    }
                    case 2: {
                        c2.a(a5, n2, n3, (j2.fT - 1) * 24, e2.ga * 90 + 30, 24, 24);
                        break block0;
                    }
                    case 3: {
                        c2.a(a5, n2, n3, (j2.fT - 1) * 24, e2.ga * 90 + 90, 24, 24);
                        break block0;
                    }
                    case 4: {
                        c2.a(a5, n2, n3, (j2.fT - 1) * 24, 300, 24, 24);
                        break block0;
                    }
                }
                break;
            }
            case 3: {
                y y2 = (y)j2;
                c2.a(a5, n2, n3, (y2.fT - 1) * 24, 510 + (y2.il - 1) * 30, 24, 24);
                break;
            }
            case 4: 
            case 5: {
                c2.a(a5, n2, n3, (j2.fT - 1) * 24, 420, 24, 24);
                break;
            }
            case 6: {
                c2.a(a5, n2, n3, (j2.fT - 1) * 24, 630, 24, 24);
                break;
            }
            case 7: {
                c2.a(a5, n2, n3, (j2.fT - 1) * 24, 690, 24, 24);
                break;
            }
            case 8: {
                c2.a(a5, n2, n3, (j2.fT - 1) * 24, 750, 24, 24);
                break;
            }
        }
    }

    public static int a(a.b.c c2, String string, int n2, int n3, int n4, int n5, int n6, int n7) {
        int n8 = n2;
        int n9 = string.length();
        int n10 = 0;
        while (n10 < n9) {
            char c3 = string.charAt(n10);
            c2.a(c3, n2, n3, n6);
            n2 = c3 < '\u007f' ? (n2 += 6) : (n2 += 12);
            if (n2 > n5) {
                n2 = n8;
                n3 += n7;
            }
            ++n10;
        }
        return n3;
    }

    public static void a(a.b.c c2, j j2, int n2, int n3) {
        block0 : switch (j2.fW) {
            case 0: {
                c2.if(a5, n2, n3, (j2.fT - 1) * 24, 0, 24, 24);
                break;
            }
            case 1: {
                b.a.e.v v2 = (b.a.e.v)j2;
                c2.if(a5, n2, n3, (j2.fT - 1) * 24, v2.hH * 30 + 330, 24, 24);
                break;
            }
            case 2: {
                b.a.e.e e2 = (b.a.e.e)j2;
                switch (e2.gb) {
                    case 1: {
                        c2.if(a5, n2, n3, (j2.fT - 1) * 24, e2.ga * 90 + 60, 24, 24);
                        break block0;
                    }
                    case 2: {
                        c2.if(a5, n2, n3, (j2.fT - 1) * 24, e2.ga * 90 + 30, 24, 24);
                        break block0;
                    }
                    case 3: {
                        c2.if(a5, n2, n3, (j2.fT - 1) * 24, e2.ga * 90 + 90, 24, 24);
                        break block0;
                    }
                    case 4: {
                        c2.if(a5, n2, n3, (j2.fT - 1) * 24, 300, 24, 24);
                        break block0;
                    }
                }
                break;
            }
            case 3: {
                y y2 = (y)j2;
                c2.if(a5, n2, n3, (y2.fT - 1) * 24, 510 + (y2.il - 1) * 30, 24, 24);
                break;
            }
            case 4: 
            case 5: {
                c2.if(a5, n2, n3, (j2.fT - 1) * 24, 420, 24, 24);
                break;
            }
            case 6: {
                c2.if(a5, n2, n3, (j2.fT - 1) * 24, 630, 24, 24);
                break;
            }
            case 7: {
                c2.if(a5, n2, n3, (j2.fT - 1) * 24, 690, 24, 24);
                break;
            }
            case 8: {
                c2.if(a5, n2, n3, (j2.fT - 1) * 24, 750, 24, 24);
                break;
            }
        }
    }
}

