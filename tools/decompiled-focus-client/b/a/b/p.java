/*
 * Decompiled with CFR 0.152.
 */
package b.a.b;

import a.b.af;
import a.b.c;
import a.b.o;
import b.a.b.j;
import b.a.b.q;
import b.a.b.u;
import b.a.d.d;
import b.a.d.f;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class p
extends j {
    public static final int[] ad = new int[]{6052698, 0xFFFF00, 16738304, 65280, 65535, 16127, 0xFF00FF, 0xFF0000};
    public static final int[] aa = new int[]{-1, -8847274, -3211264, -16768513};
    public static final af[][][] ag = new af[6][100][5];
    public static final int[][] X = new int[][]{{33, 30}, {14, 26}, {7, 19}, {13, 6}, {26, 2}, {50, 4}, {54, 17}, {52, 34}};
    public static final af[] W = new af[2];
    public static final af[] Z = new af[9];
    private static final int[] ac;
    private d af;
    private int S;
    private o R;
    private long V;
    private a.b.q Y;
    private long U;
    private int Q;
    private int ae;
    private int ab;
    private long T;
    public static af title;
    public static af auraDragon;

    public d j() {
        return this.af;
    }

    public void do(c c2) {
        int n2;
        int n3;
        int n4;
        int n5 = this.try();
        int n6 = this.char();
        if (this.byte.b || this.byte.case() == this) {
            n4 = this.for - 96;
            if (this.af.al > 0) {
                c2.if(b.a.b.u.aK, n5 + 25, n4, this.af.ah * 16, 720, 16, 16);
                n3 = f.cZ[this.af.al];
                n2 = n5 + 43;
                int n7 = n4 + 2;
                q.a(c2, this.af.aj, n2, n7, n3);
                c2.a('-', n2 += a.b.q.if(this.af.aj), n7, 0xFFFFFF);
                q.a(c2, f.cA[this.af.ai], n2 += 6, n7, n3);
            }
            n4 += 18;
            n3 = n5 + 75 - this.S / 2;
            if (this.af.ao > 0) {
                q.a(c2, this.af.a, n3, n4, -16408070);
            } else {
                q.a(c2, this.af.a, n3, n4, aa[this.af.ar]);
            }
            n2 = this.af.Q * 100 / this.af.r;
            c2.a(n5 + 25, n4 += 14, n2, 2, -65536);
            c2.a(n5 + 25 + n2, n4, 100 - n2, 2, -16777216);
        }
        if (this.R != null) {
            n4 = this.R.a();
            n3 = this.R.if();
            n2 = this.for - 64 - n3;
            c2.a(n5 + 11, n2, n4 + 8, n3 + 6, -1627389952);
            this.R.a(c2, n5 + 15, n2 + 4, 0, 0);
        }
        if (this.Y != null) {
            this.Y.a(c2, n5 - this.Y.a() / 2 + 75, n6 + 12, 0, 0);
        }
        this.for(c2);
    }

    public b.a.d.c b() {
        return this.af;
    }

    public int char() {
        return this.for - 87;
    }

    public int e() {
        int n2 = this.af.s;
        return this.new - 30 + X[n2][0];
    }

    public void a(c c2) {
        if (this.af.Q <= 0) {
            af[] afArray = ag[this.af.af * 2 + this.af.an][this.af.ac];
            int n2 = this.try();
            int n3 = this.char();
            if (afArray[4] == null) {
                c2.a(n2, n3, 150, 150, 0x7F000000);
                c2.a("Loading", n2 + 54, n3 + 69, -1);
            } else {
                c2.a(afArray[4], n2, n3);
            }
        }
    }

    public void a(String string) {
        this.R = new o(string, 120, -1, 0);
        this.V = this.byte.try;
    }

    public void a(long l2) {
        l2 = System.currentTimeMillis();
        super.a(l2);
        if (this.V > 0L && l2 - this.V > 15000L) {
            this.V = 0L;
            this.R = null;
        }
        if (this.U > 0L && l2 - this.U > 3000L) {
            this.Y = null;
            this.U = 0L;
        }
        if (this.af.ab > 0 && l2 - this.T > 50L) {
            ++this.ab;
            this.T = l2;
            if (this.ab >= 100 + ac[this.af.ab]) {
                this.ab = 0;
            }
        }
        int n2 = this.byte.h.x;
        int n3 = this.byte.h.y;
        this.if = n2 > this.new - 15 && n2 < this.new + 15 && n3 > this.for - 50 && n3 < this.for + 2 || n2 > this.new - 50 && n2 < this.new + 50 && n3 > this.for - 60 && n3 < this.for - 46 && this.af.ag.length() > 0;
        ++this.Q;
        this.ae = this.ae < 200 ? ++this.ae : 0;
    }

    public void do(int n2) {
        this.af.ar = n2;
    }

    static {
        int[] nArray = new int[9];
        nArray[1] = 8;
        nArray[2] = 8;
        nArray[3] = 8;
        nArray[4] = 16;
        nArray[5] = 8;
        nArray[6] = 21;
        nArray[7] = 21;
        nArray[8] = 21;
        ac = nArray;
    }

    public void a(String string, int n2) {
        if (this.Y != null) {
            this.Y.do(string);
            this.Y.if(n2);
        } else {
            this.Y = new a.b.q(string, n2, -1895825408);
        }
        this.U = this.byte.try;
    }

    public void if(c c2) {
        af[] afArray;
        try {
            if (this.af != null) {
                this.af.titleEffect = 0;
                this.af.auraEffect = 0;
                afArray = this.af.getClass().getField("bA");
                Object object = afArray.get(this.af);
                if (object != null) {
                    if (object.getClass().getField("title").get(object) != null) {
                        this.af.titleEffect = 18;
                    }
                    if (object.getClass().getField("aura").get(object) != null) {
                        this.af.auraEffect = 1;
                    }
                }
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        afArray = ag[this.af.af * 2 + this.af.an][this.af.ac];
        int n2 = this.A.int;
        int n3 = this.A.a;
        int n4 = this.try();
        int n5 = this.char();
        if (afArray[n2] == null) {
            c2.a(n4, n5, 150, 150, 0x7F000000);
            c2.a("Loading", n4 + 54, n5 + 69, -1);
        } else {
            int n6;
            if (this.af.Q > 0 || this.u > 0) {
                n6 = (n3 + 4) % 8;
                int n7 = this.x % this.y[n2];
                int n8 = n7 * 150;
                int n9 = n6 * 150;
                int n10 = 0;
                int n11 = 32;
                if (!this.af.ad) {
                    n10 = 1;
                    n11 = 100;
                }
                if (this.byte.c == this) {
                    n10 = 2;
                }
                if ((this.af.ab == 2 || this.af.ab == 3 || this.af.ab == 5 || this.af.ab == 6) && Z[this.af.ab] != null && this.ab >= 100) {
                    n7 = this.ab - 100;
                    c2.a(Z[this.af.ab], n4, n5, n7 * 150, 150, 150, 150, 5, 0);
                }
                c2.a(afArray[n2], n4, n5, n8, n9, 150, 150, n10, n11);
                if (this.af.aq > 0 && W[0] != null) {
                    int n12 = this.af.aq % 10;
                    int n13 = this.af.aq / 10;
                    n7 = this.Q / 4 % 8;
                    c2.a(W[n13], n4, n5, n7 * 150, 0, 150, 150, 6, ad[n12 - 1]);
                    if (this.ae < 32) {
                        n7 = this.ae / 4 % 8;
                        c2.a(W[n13], n4, n5, n7 * 150, 150, 150, 150, 6, -797690);
                    }
                }
                if (this.af.ab > 0 && Z[this.af.ab] != null && this.ab >= 100) {
                    n7 = this.ab - 100;
                    c2.a(Z[this.af.ab], n4, n5, n7 * 150, 0, 150, 150, 5, 0);
                }
            }
            if (this.af.ag.length() > 0) {
                n6 = a.b.q.if(this.af.ag);
                n4 = n4 + 75 - n6 / 2;
                n5 = this.for - 60;
                c2.a(this.new - 50, n5 - 1, 100, 14, -471544);
                c2.a(this.af.ag, n4, n5, 0);
            }
        }
        Object var16_17 = null;
        if (this.af != null) {
            int n14 = (Integer)this.getClass().getMethod("try", new Class[0]).invoke(this, new Object[0]);
            int n15 = (Integer)this.getClass().getMethod("char", new Class[0]).invoke(this, new Object[0]);
            if (this.af.auraEffect == 1 && auraDragon != null) {
                int n16 = this.Q / 4 % 8;
                c2.a(auraDragon, n14, n15, n16 * 150, 0, 150, 150, 0, 0);
            }
            if (this.af.titleEffect == 18 && title != null) {
                int n17 = this.Q / 4 % 8;
                c2.a(title, n14, n15 - 12, n17 * 150, 0, 150, 150, 0, 0);
                if (this.ae < 32) {
                    int n18 = this.ae / 4 % 8;
                    c2.a(title, n14, n15 - 12, n18 * 150, 150, 150, 150, 0, 0);
                }
            }
        }
    }

    public int else() {
        return 150;
    }

    public void a(d d2) {
        this.af = d2;
        int n2 = this.byte.b();
        int n3 = this.byte.try();
        this.new = d2.void * n2 + n2 / 2;
        this.for = d2.long * n3 + n3 / 2;
        this.S = a.b.q.if(d2.a);
        this.A.a = d2.s;
        this.A.int = d2.m;
        this.u = d2.Q;
        this.w = 200;
        this.ae = this.Q = (int)(Math.random() * 100.0);
    }

    public int try() {
        return this.new - 75;
    }

    public int for() {
        return 150;
    }

    public int f() {
        int n2 = this.af.s;
        return this.for - 55 + X[n2][1];
    }
}

