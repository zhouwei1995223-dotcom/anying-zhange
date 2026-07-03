/*
 * Decompiled with CFR 0.152.
 */
package b.a.d;

import a.a.e;
import a.a.i;
import b.a.b;
import b.a.d.d;
import b.a.d.h;
import b.a.e.j;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class f
extends b {
    public static final String[] cA = new String[]{"\u4f1a\u5458", "\u526f\u4f1a\u957f", "\u4f1a\u957f", "\u5143\u8001", "\u5927\u81e3", "\u5143\u5e05", "\u5de6\u62a4\u6cd5", "\u53f3\u62a4\u6cd5", "\u5802\u4e3b", "\u957f\u8001", "\u5c06\u519b", "\u5b88\u62a4\u9a91\u58eb", "\u7981\u536b\u519b", "\u5a01\u9547\u5c06\u519b", "\u4fef\u5367\u6491", "\u6d6a\u5b50", "\u6dd1\u5973", "\u8c6a\u4fa0", "\u5973\u9b54\u5934", "\u5c71\u5927\u738b", "\u5149\u7984\u52cb", "\u4f2f\u7235", "\u4eb2\u738b", "\u5c0f\u5f3a", "\u5927\u5f3a", "\u957f\u6c5f7\u53f7", "\u529f\u592b\u4e4b\u738b", "\u559c\u5267\u4e4b\u738b", "\u7834\u574f\u4e4b\u738b", "\u5f00\u5fc3\u679c", "\u5927\u574f\u86cb", "\u5c0f\u751c\u751c", "\u5c0f\u56e7\u56e7"};
    public static final int[] cZ = new int[]{-1, -1, -13318080, -15629579, -7864065, -752332, -1186560, -65536, -1, -1};
    public static final int cu = 5;
    public int cU;
    public int cx = 1;
    public int c0;
    public int cE;
    public String cB;
    public int cH = 2;
    public String cz = "";
    public String cV = "";
    public transient int cY = 20;
    public a.a.h cw;
    public int cI;
    public transient int cT = 50;
    public j[] cP;
    public int cK;
    public transient String cC = "";
    public int cv;
    public int cG = 5;
    public String cy = "";
    public int cF;
    public int cX;
    public int cW;
    public transient int[] cM = new int[5];
    public h cN;
    public int cQ;
    public transient f cR;
    public int cD;
    public transient Object cJ;
    public transient int cS;
    public transient boolean cO;
    public transient boolean cL;

    public a do(String string) {
        int n2 = this.cw.for();
        int n3 = 0;
        while (n3 < n2) {
            a a10 = (a)this.cw.if(n3);
            if (a10.for.equals(string)) {
                return a10;
            }
            ++n3;
        }
        return null;
    }

    public void a(e e2) {
        this.n();
        super.a(e2);
        this.cU = e2.for();
        this.cx = e2.for();
        this.cE = e2.i();
        this.cK = e2.i();
        this.c0 = e2.i();
        this.cB = e2.h();
        this.cz = e2.h();
        this.cV = e2.h();
        this.cY = e2.case();
        int n2 = e2.case();
        int n3 = 0;
        while (n3 < n2) {
            a a10 = new a();
            a10.for = e2.h();
            a10.if = e2.for();
            a10.a = e2.i();
            a10.new = e2.for();
            a10.int = e2.for();
            a10.try = e2.for();
            a10.do = e2.c();
            this.cw.if(a10);
            ++n3;
        }
        this.cI = e2.i();
        this.cT = e2.for();
        n3 = 0;
        while (n3 < this.cT) {
            int n4 = e2.case();
            if (n4 >= 0) {
                this.cP[n3] = j.h(n4);
                this.cP[n3].a(e2);
            }
            ++n3;
        }
        this.cK = e2.i();
        if (this.cK > 0) {
            this.cv = e2.i();
            this.cG = e2.for();
            this.cy = e2.h();
            this.cF = e2.i();
            this.cX = e2.i();
        }
    }

    public void if(e e2) {
        super.if(e2);
        e2.a(this.cU);
        e2.a(this.cx);
        e2.char(this.cE);
        e2.char(this.cK);
        e2.char(this.c0);
        e2.a(this.cB);
        e2.a(this.cz);
        e2.a(this.cV);
        e2.a(this.cY);
        int n2 = this.cw.for();
        e2.a(n2);
        int n3 = 0;
        while (n3 < n2) {
            a a10 = (a)this.cw.if(n3);
            e2.a(a10.for);
            e2.a(a10.if);
            e2.char(a10.a);
            e2.a(a10.new);
            e2.a(a10.int);
            e2.a(a10.try);
            e2.a(a10.do);
            ++n3;
        }
        e2.char(this.cI);
        if (this.cT >= this.cP.length) {
            this.cT = this.cP.length;
        }
        e2.a(this.cT);
        n3 = 0;
        while (n3 < this.cT) {
            if (this.cP[n3] != null) {
                e2.a(this.cP[n3].fW);
                this.cP[n3].if(e2);
            } else {
                e2.a(-1);
            }
            ++n3;
        }
        e2.char(this.cK);
        if (this.cK > 0) {
            e2.char(this.cv);
            e2.a(this.cG);
            e2.a(this.cy);
            e2.char(this.cF);
            e2.char(this.cX);
        }
    }

    public i a(String string) {
        if (string.equals("memberList")) {
            i i2 = new i(string);
            int n2 = this.cw.for();
            int n3 = 0;
            while (n3 < n2) {
                a a10 = (a)this.cw.if(n3);
                i i3 = new i(String.valueOf(a10.if));
                i3.do(a10.for + ";" + (a10.int * 10000 + a10.new * 1000 + a10.try) + ";" + a10.a);
                i2.a(i3);
                ++n3;
            }
            return i2;
        }
        if (string.equals("goodsList")) {
            i i4 = new i(string);
            int n4 = 0;
            while (n4 < this.cT && n4 < this.cP.length) {
                if (this.cP[n4] != null) {
                    i i5 = new i(String.valueOf(n4));
                    String string2 = this.cP[n4].U();
                    if (string2.length() > 0) {
                        i5.do(this.cP[n4].if + "," + string2);
                    } else {
                        i5.do(String.valueOf(this.cP[n4].if));
                    }
                    i4.a(i5);
                }
                ++n4;
            }
            return i4;
        }
        if (string.equals("placedSign")) {
            i i6 = new i(string);
            if (this.cN != null) {
                i6.do(this.cN.bX + "," + this.cN.b1 + "," + this.cN.b2 + "," + this.cN.void + "," + this.cN.long);
            }
            return i6;
        }
        return super.a(string);
    }

    public boolean a(String string, i i2) {
        if (string.equals("memberList")) {
            this.cw = new a.a.h(100);
            a.a.h h2 = i2.int();
            if (h2 != null) {
                int n2 = h2.for();
                int n3 = 0;
                while (n3 < n2) {
                    i i3 = (i)h2.if(n3);
                    a a10 = new a();
                    a10.if = Integer.parseInt(i3.do());
                    String[] stringArray = a.a.b.a(i3.for(), ";");
                    a10.for = stringArray[0];
                    int n4 = Integer.parseInt(stringArray[1]);
                    a10.try = n4 % 1000;
                    a10.new = n4 / 1000 % 10;
                    a10.int = n4 / 10000;
                    a10.a = Integer.parseInt(stringArray[2]);
                    this.cw.if(a10);
                    ++n3;
                }
            }
            return true;
        }
        if (string.equals("goodsList")) {
            this.cP = new j[300];
            a.a.h h3 = i2.int();
            if (h3 != null) {
                int n5 = h3.for();
                int n6 = 0;
                while (n6 < n5 && n6 < this.cP.length) {
                    int n7;
                    j j2;
                    i i4 = (i)h3.if(n6);
                    String string2 = i4.for();
                    String string3 = "";
                    int n8 = string2.indexOf(44);
                    if (n8 > 0) {
                        string3 = string2.substring(n8 + 1);
                        string2 = string2.substring(0, n8);
                    }
                    if ((j2 = j.i(Integer.parseInt(string2))) != null) {
                        j2 = (j)b.a(j2);
                        j2.byte(string3);
                    }
                    if ((n7 = Integer.parseInt(i4.do())) < this.cP.length) {
                        this.cP[n7] = j2;
                    }
                    ++n6;
                }
            }
            return true;
        }
        if (string.equals("placedSign")) {
            String string4 = i2.for();
            if (string4.length() > 1) {
                String[] stringArray = a.a.b.a(string4, ",");
                this.cN = new h();
                this.cN.bZ = this;
                this.cN.bX = Integer.parseInt(stringArray[0]);
                this.cN.b1 = Integer.parseInt(stringArray[1]);
                this.cN.b2 = Integer.parseInt(stringArray[2]);
                this.cN.void = Integer.parseInt(stringArray[3]);
                this.cN.long = Integer.parseInt(stringArray[4]);
            }
            return true;
        }
        return super.a(string, i2);
    }

    public int m() {
        int n2 = 0;
        int n3 = 0;
        while (n3 < this.cT) {
            if (this.cP[n3] != null) {
                ++n2;
            }
            ++n3;
        }
        return n2;
    }

    public a if(String string) {
        int n2 = this.cw.for();
        int n3 = 0;
        while (n3 < n2) {
            a a10 = (a)this.cw.if(n3);
            if (a10.for.equals(string)) {
                this.cw.a(n3);
                return a10;
            }
            ++n3;
        }
        return null;
    }

    public void new(int n2) {
        int n3 = 0;
        while (n3 < this.cM.length) {
            if (this.cM[n3] == n2) {
                this.cM[n3] = 0;
                break;
            }
            ++n3;
        }
    }

    public boolean try(int n2) {
        int n3 = 0;
        while (n3 < this.cM.length) {
            if (this.cM[n3] == n2) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    public int l() {
        int n2 = 0;
        while (n2 < this.cT) {
            if (this.cP[n2] == null) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    public a a(d d2) {
        return this.a(d2, 0);
    }

    public a a(d d2, int n2) {
        return this.a(d2.a, d2.af, d2.ab, d2.p, n2);
    }

    public a a(String string, int n2, int n3, int n4, int n5) {
        a a10 = this.do(string);
        if (a10 == null) {
            a10 = new a();
            a10.for = string;
            this.cw.if(a10);
        }
        a10.new = n2;
        a10.int = n3;
        a10.try = n4;
        a10.if = n5;
        return a10;
    }

    public void n() {
        this.cx = Math.min(this.cx, 5);
        this.cY = this.cx * 20;
        this.cT = Math.min(this.cx * 50, 250);
        if (this.cw == null) {
            this.cw = new a.a.h(100);
        }
        if (this.cP == null) {
            this.cP = new j[300];
        }
    }

    public void int(int n2) {
        int n3 = 0;
        while (n3 < this.cM.length) {
            if (this.cM[n3] == 0 || this.cM[n3] == n2) {
                this.cM[n3] = n2;
                break;
            }
            ++n3;
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    public static class a {
        public String for;
        public int if;
        public int a;
        public int new;
        public int int;
        public int try;
        public boolean do;
    }
}

