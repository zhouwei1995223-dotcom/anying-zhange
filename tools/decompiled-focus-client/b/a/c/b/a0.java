/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.af;
import a.b.c;
import a.b.q;
import a.b.s;
import b.a.b.a;
import b.a.b.n;
import b.a.c.b.e;

public class a0
extends s {
    public static af ev;
    private static final int[] ex;
    private static final int[] ew;
    private static final int[] ee;
    private static final int[] ec;
    private static final int[] eb;
    private static int ed;
    private String eA = "";
    private String ey = "";
    private String et = "";
    private char[] el;
    private int[] eh;
    private int[] en;
    private int[] ez;
    private int[] ep;
    private int eg;
    private int eq;
    private int em;
    private int ef;
    private int ek;
    private long ei;
    private int ej = 255;
    private int[] eo = new int[ex.length];
    private int[] eu = new int[100];
    private int er;
    private a es;

    public void a(String string, String string2, String string3, int n2, int n3, int n4, int n5) {
        this.et = "";
        char[] cArray = new char[string3.length()];
        string3.getChars(0, string3.length(), cArray, 0);
        int[] nArray = new int[cArray.length];
        int[] nArray2 = new int[cArray.length];
        int[] nArray3 = new int[cArray.length];
        this.el = cArray;
        this.eh = nArray;
        this.en = nArray2;
        this.ep = nArray3;
        this.eq = n2;
        this.em = n3;
        this.ef = n4;
        this.ez = new int[nArray.length];
        this.eg = q.if(string3);
        this.et = string3;
        this.eA = string;
        this.ey = string2;
        this.p(n3);
        this.o(n4);
        this.ej = 255;
        this.ei = System.currentTimeMillis() + (long)(n5 * 1000);
        this.ek = 0;
    }

    public void a(c c2) {
        if (this.et.length() == 0) {
            return;
        }
        c2.a(0, this.getHeight() - 66, this.getWidth(), 24, -1627389952);
        c2.do(e.a5, this.eh[0] - 26, this.en[0] - 6, this.eq * 24, 690, 24, 24, this.ej);
        int n2 = 0;
        while (n2 < this.el.length) {
            c2.a(this.el[n2], this.eh[n2], this.en[n2], this.ep[n2], this.ej);
            ++n2;
        }
        if (ev == null) {
            return;
        }
        if (this.ef == 0) {
            n2 = 0;
            while (n2 < this.er) {
                int n3 = this.eu[n2] % 1000;
                int n4 = this.eu[n2] / 1000 % 1000;
                int n5 = this.eu[n2] / 1000000 % 10;
                int n6 = this.eu[n2] / 10000000 % 10;
                if (n6 > 0) {
                    c2.a(ev, n3 - 12, n4 - 12, n5 * 24, 30, 24, 24, 5, 0);
                } else {
                    c2.a(ev, n3 - 8, n4 - 8, n5 * 16 + 144, 30, 16, 16, 5, 0);
                }
                ++n2;
            }
        } else if (this.ef == 1) {
            n2 = 0;
            while (n2 < ex.length) {
                c2.a(ev, ex[n2] - 15, ew[n2] - 15, (this.eo[n2] >> 2) * 30, 0, 30, 30, 5, 0);
                ++n2;
            }
        } else {
            b.a.b.a.new = ev;
            this.es.a(c2);
        }
    }

    public void a(long l2) {
        int n2;
        int n3;
        int n4;
        int n5;
        if (this.et.length() == 0) {
            return;
        }
        if (l2 > this.ei) {
            this.et = "";
            return;
        }
        if (this.em == 0) {
            if (this.ek == 0) {
                n5 = 1;
                n4 = 0;
                while (n4 < this.el.length) {
                    int n6 = n4;
                    this.en[n6] = this.en[n6] + 6;
                    if (this.en[n4] > ed) {
                        this.en[n4] = ed;
                    } else {
                        n5 = 0;
                    }
                    ++n4;
                }
                if (n5 != 0) {
                    this.ek = 1;
                }
            } else if (this.ek == 1) {
                if (this.ei - l2 < 1000L) {
                    this.ek = 2;
                }
            } else if (this.ek == 2) {
                this.ej -= 2;
            }
        } else if (this.em == 1) {
            if (this.ek == 0) {
                if (this.eh[0] >= this.ez[0]) {
                    n5 = 0;
                    while (n5 < this.el.length) {
                        int n7 = n5++;
                        this.eh[n7] = this.eh[n7] - 5;
                    }
                } else {
                    this.ek = 1;
                }
            } else if (this.ek == 1) {
                if (this.ei - l2 < 1000L) {
                    this.ek = 2;
                }
            } else if (this.ek == 2) {
                n5 = 0;
                while (n5 < this.el.length) {
                    int n8 = n5++;
                    this.eh[n8] = this.eh[n8] - 5;
                }
            }
        } else if (this.em == 2) {
            if (this.ek == 0) {
                n5 = 1;
                n4 = 0;
                while (n4 < this.el.length) {
                    int n9 = n4;
                    this.en[n9] = this.en[n9] + 50;
                    if (this.en[n4] > ed) {
                        this.en[n4] = ed;
                    } else {
                        n5 = 0;
                    }
                    ++n4;
                }
                if (n5 != 0) {
                    this.ek = 1;
                    n4 = 0;
                    n3 = 0;
                    n2 = 0;
                    while (n2 < this.el.length) {
                        n4 = 30 - (int)(Math.random() * 50.0);
                        n3 = 40 - (int)(Math.random() * 60.0);
                        this.ez[n2] = n3 << 16 | n4;
                        ++n2;
                    }
                }
            } else if (this.ek == 1) {
                if (this.ei - l2 < 1000L) {
                    this.ek = 2;
                }
            } else if (this.ek == 2) {
                n5 = 0;
                while (n5 < this.el.length) {
                    int n10 = n5;
                    this.eh[n10] = this.eh[n10] + (this.ez[n5] & 0xFFFF);
                    int n11 = n5;
                    this.en[n11] = this.en[n11] + (this.ez[n5] >> 16);
                    ++n5;
                }
            }
        }
        if (this.ef == 0) {
            int n12;
            if (this.er < this.eu.length && Math.random() * 100.0 < 10.0) {
                n5 = (int)(Math.random() * (double)ee.length);
                n4 = ee[n5];
                n3 = ec[n5];
                n2 = 0;
                n12 = (int)(Math.random() * 2.0);
                this.eu[this.er++] = n4 + n3 * 1000 + n2 * 1000000 + n12 * 10000000;
            }
            n5 = 0;
            while (n5 < this.er) {
                n4 = this.eu[n5] % 1000;
                n3 = this.eu[n5] / 1000 % 1000;
                n2 = this.eu[n5] / 1000000 % 10;
                n12 = this.eu[n5] / 10000000 % 10;
                if ((n4 += (int)(1.0 + Math.random() * 2.0)) > this.getWidth() || (n3 += (int)(2.0 + Math.random() * 5.0)) > this.getHeight()) {
                    this.eu[n5] = this.eu[this.er += -1];
                } else {
                    if (Math.random() > (double)0.9f) {
                        n2 = (int)(Math.random() * 6.0);
                    }
                    this.eu[n5] = n4 + n3 * 1000 + n2 * 1000000 + n12 * 10000000;
                }
                ++n5;
            }
        } else if (this.ef == 1) {
            n5 = 0;
            while (n5 < this.eo.length) {
                this.eo[n5] = (this.eo[n5] + 1) % 20;
                ++n5;
            }
        } else if (this.ef == 2) {
            this.es.a(l2);
        }
    }

    static {
        ex = new int[]{330, 242, 147, 182, 258, 330, 400, 477, 512, 416};
        ew = new int[]{106, 59, 119, 217, 296, 358, 296, 217, 119, 59};
        int[] nArray = new int[20];
        nArray[8] = 50;
        nArray[9] = 100;
        nArray[10] = 150;
        nArray[11] = 200;
        nArray[12] = 250;
        nArray[13] = 300;
        nArray[14] = 350;
        nArray[15] = 400;
        nArray[16] = 450;
        nArray[17] = 500;
        nArray[18] = 550;
        nArray[19] = 600;
        ee = nArray;
        int[] nArray2 = new int[20];
        nArray2[1] = 50;
        nArray2[2] = 100;
        nArray2[3] = 150;
        nArray2[4] = 200;
        nArray2[5] = 250;
        nArray2[6] = 300;
        nArray2[7] = 350;
        ec = nArray2;
        eb = new int[]{14402564, 0xFFFFFF, 14360556, 1635204, 1060093};
        ed = 0;
    }

    private void p(int n2) {
        int n3;
        int n4 = 0;
        while (n4 < this.el.length) {
            this.ep[n4] = 0xFFFFFF;
            ++n4;
        }
        n4 = this.et.indexOf(this.eA, 0);
        while (n4 >= 0) {
            n3 = 0;
            while (n3 < this.eA.length()) {
                this.ep[n4 + n3] = 65280;
                ++n3;
            }
            n4 = this.et.indexOf(this.eA, n4 + this.eA.length());
        }
        n4 = this.et.indexOf(this.ey, n4 + this.ey.length());
        while (n4 >= 0) {
            n3 = 0;
            while (n3 < this.ey.length()) {
                this.ep[n4 + n3] = 61680;
                ++n3;
            }
            n4 = this.et.indexOf(this.ey, n4 + this.ey.length());
        }
        switch (n2) {
            case 0: {
                n3 = this.el.length / 2;
                int n5 = q.a(this.el[n3]);
                int n6 = this.getWidth() / 2 - n5 / 2 + 12;
                int n7 = this.getHeight() / 8 - 10;
                int n8 = n3 - 1;
                while (n8 >= 0) {
                    this.eh[n8] = n6 -= q.a(this.el[n8]);
                    this.en[n8] = n7 += 5;
                    --n8;
                }
                n6 = this.getWidth() / 2 - n5 / 2 + 12;
                n7 = this.getHeight() / 8 - 10;
                n8 = n3;
                while (n8 < this.el.length) {
                    this.eh[n8] = n6;
                    this.en[n8] = n7;
                    n6 += q.a(this.el[n8]);
                    n7 += 5;
                    ++n8;
                }
                break;
            }
            case 1: {
                n3 = this.getWidth();
                n4 = this.getWidth() / 2 - this.eg / 2 + 12;
                int n9 = 0;
                while (n9 < this.el.length) {
                    this.eh[n9] = n3;
                    this.en[n9] = ed;
                    this.ez[n9] = n4;
                    int n10 = q.a(this.el[n9]);
                    n3 += n10;
                    n4 += n10;
                    ++n9;
                }
                break;
            }
            default: {
                n3 = this.getWidth() / 2 - this.eg / 2 + 12;
                int n11 = 0;
                while (n11 < this.el.length) {
                    this.eh[n11] = n3;
                    this.en[n11] = 0 - (int)((double)this.getHeight() * Math.random() * (double)this.el.length / 3.0);
                    n3 += q.a(this.el[n11]);
                    ++n11;
                }
                break block0;
            }
        }
    }

    public void bJ() {
        ed = this.getHeight() - 60;
    }

    private void o(int n2) {
        if (n2 == 0) {
            int n3 = 0;
            while (n3 < this.eo.length) {
                this.eo[n3] = 0;
                ++n3;
            }
        } else if (n2 == 1) {
            this.er = 0;
        } else {
            n n4 = new n();
            n4.l = 0.06f;
            n4.j = 1.0471976f;
            n4.h = 500;
            n4.g = 2000;
            n4.long = 22000;
            n4.i = 40000;
            n4.new = 20;
            n4.if = 100;
            this.es = new a(n4);
            this.es.a(Integer.MAX_VALUE);
            this.es.a(this.getWidth() / 2, 210);
            this.es.a(eb);
            this.es.do();
            this.es.a(System.currentTimeMillis());
        }
    }
}

