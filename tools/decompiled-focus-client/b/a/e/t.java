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
public class t
extends j {
    public static final int gV = 1;
    public static final int g9 = 2;
    public static final int hl = 3;
    public static final int hx = 4;
    public static final int gY = 5;
    public static final int hj = 6;
    public static final int g2 = 7;
    public static final int g4 = 8;
    public static final int hs = 9;
    public static final int gS = 10;
    public static final int hr = 12;
    public static final int hn = 13;
    public static final int hc = 14;
    public static final int gZ = 16;
    public static final int g8 = 18;
    public static final int hy = 19;
    public static final int hw = 20;
    public static final int hp = 23;
    public static final int g1 = 24;
    public static final int hd = 25;
    public static final int g5 = 26;
    public static final int hb = 27;
    public static final int gR = 28;
    public static final int ht = 29;
    public static final int g7 = 30;
    public static final int hu = 31;
    public static final int hA = 32;
    public static final int gX = 33;
    public static final int hz = 34;
    public static final int g0 = 35;
    public static final int ha = 36;
    public static final int gU = 37;
    public static final int hm = 38;
    public static final int g3 = 39;
    public static final int hk = 40;
    public static final int hq = 41;
    public int hg;
    public int gT = 1;
    public int ho;
    public int hi;
    public int hh;
    public int hf;
    public int he;
    public int g6;
    public int[] hv = new int[10];
    public transient int gW;

    public void a(e e2) {
        super.a(e2);
        this.hg = e2.for();
        this.gT = e2.case();
        this.g6 = e2.for();
        this.hi = e2.i();
        this.hh = e2.i();
        this.hf = e2.i();
        this.he = e2.i();
        this.fR = e2.h();
    }

    public void if(e e2) {
        super.if(e2);
        e2.a(this.hg);
        e2.a(this.gT);
        e2.a(this.g6);
        e2.char(this.hi);
        e2.char(this.hh);
        e2.char(this.hf);
        e2.char(this.he);
        e2.a(this.fR);
    }

    public boolean a(String string, String string2) {
        if (string.equals("extraData")) {
            this.hv[this.gW++] = Integer.parseInt(string2);
            return true;
        }
        if (string.equals("expiredTime")) {
            return true;
        }
        return super.a(string, string2);
    }

    public t() {
        this.fW = 5;
    }

    public void do(b b2) {
        super.do(b2);
        t t2 = (t)b2;
        this.hg = t2.hg;
        this.gT = t2.gT;
        this.g6 = t2.g6;
        this.hi = t2.hi;
        this.hh = t2.hh;
        this.hf = t2.hf;
        this.he = t2.he;
        this.hv = t2.hv;
        this.gW = t2.gW;
    }

    public void byte(String string) {
        if (string == null || string.length() == 0) {
            return;
        }
        if (this.hg == 31) {
            this.hi = Integer.parseInt(string);
        } else if (this.hg == 32) {
            this.hi = Integer.parseInt(string);
        } else if (this.hg == 37) {
            this.hi = Integer.parseInt(string);
        }
    }

    public String U() {
        if (this.hg == 31) {
            return String.valueOf(this.hi);
        }
        if (this.hg == 32) {
            return String.valueOf(this.hi);
        }
        if (this.hg == 37) {
            return String.valueOf(this.hi);
        }
        return "";
    }
}

