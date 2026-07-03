/*
 * Decompiled with CFR 0.152.
 */
package b.a.d;

import a.a.e;
import a.a.i;
import b.a.b;
import b.a.d.k;
import b.a.e.n;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class l
extends b {
    public String c3 = "";
    public String c7 = "";
    public int[] dm = new int[3];
    public String[] dn = new String[]{"", "", ""};
    public int c8;
    public int dg;
    public int de;
    public int di;
    public int c2;
    public String c1 = "";
    public transient int[] dj = new int[3];
    public transient int[] df = new int[3];
    public transient int[] dl = new int[3];
    public transient int[] c5 = new int[3];
    public transient int[] dh = new int[3];
    public transient n c9 = new n();
    public transient k[] db = new k[3];
    public transient int c4 = 0;
    public transient boolean dk;
    public transient long dc;
    public transient long da;
    public transient boolean dd;
    public transient int c6;

    public void a(e e2) {
        super.a(e2);
        int n2 = 0;
        do {
            this.dn[n2] = e2.h();
            this.dj[n2] = e2.case();
            this.df[n2] = e2.case();
            this.dl[n2] = e2.for();
            this.c5[n2] = e2.for();
            this.dh[n2] = e2.for();
        } while (++n2 < 3);
        this.dg = e2.i();
        this.c9.i6 = e2.c();
    }

    public void if(e e2) {
        super.if(e2);
        int n2 = 0;
        do {
            if (this.db[n2] != null) {
                e2.a(this.db[n2].a);
                e2.a(this.db[n2].af);
                e2.a(this.db[n2].an);
                e2.a(this.db[n2].ac);
                e2.a(this.db[n2].p);
                e2.a(this.db[n2].bx.length());
                continue;
            }
            e2.a("");
            e2.a(0);
            e2.a(0);
            e2.a(0);
            e2.a(0);
            e2.a(0);
        } while (++n2 < 3);
        e2.char(this.dg);
        e2.a(this.c9.i3.length() > 0);
    }

    public i a(String string) {
        if (string.equals("heroIds")) {
            StringBuffer stringBuffer = new StringBuffer(64);
            int n2 = 0;
            while (n2 < this.dm.length) {
                if (this.dm[n2] != 0) {
                    stringBuffer.append(this.dm[n2]);
                }
                stringBuffer.append(',');
                ++n2;
            }
            i i2 = new i(string);
            i2.do(stringBuffer.toString());
            return i2;
        }
        if (string.equals("heroNames")) {
            StringBuffer stringBuffer = new StringBuffer(64);
            int n3 = 0;
            while (n3 < this.dn.length) {
                if (this.dn[n3] != null) {
                    stringBuffer.append(this.dn[n3]);
                }
                stringBuffer.append(',');
                ++n3;
            }
            i i3 = new i(string);
            i3.do(stringBuffer.toString());
            return i3;
        }
        return super.a(string);
    }

    public boolean a(String string, String string2) {
        if (string.equals("heroIds")) {
            String[] stringArray = a.a.b.a(string2, ",");
            int n2 = 0;
            while (n2 < this.dm.length) {
                if (stringArray[n2].length() > 0) {
                    this.dm[n2] = Integer.parseInt(stringArray[n2]);
                }
                ++n2;
            }
            return true;
        }
        if (string.equals("heroNames")) {
            String[] stringArray = a.a.b.a(string2, ",");
            int n3 = 0;
            while (n3 < this.dn.length) {
                this.dn[n3] = stringArray[n3];
                ++n3;
            }
            return true;
        }
        return super.a(string, string2);
    }

    public boolean new(String string) {
        int n2 = 0;
        while (n2 < this.dn.length) {
            if (this.dn[n2].equals(string)) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    public boolean int(String string) {
        int n2 = 0;
        while (n2 < this.dn.length) {
            if (this.dn[n2].equals(string)) {
                this.dm[n2] = 0;
                this.dn[n2] = "";
                this.db[n2] = null;
                return true;
            }
            ++n2;
        }
        return false;
    }

    public String toString() {
        return "user[name=" + this.a + ";password=" + this.c3 + "]";
    }

    public void if(k k2) {
        int n2 = 0;
        while (n2 < this.db.length) {
            if (this.db[n2] == null) {
                this.db[n2] = k2;
                this.dm[n2] = k2.if;
                this.dn[n2] = k2.a;
                k2.a2 = this;
                break;
            }
            ++n2;
        }
    }

    public void o() {
        this.c9 = null;
        this.db[2] = null;
        this.db[1] = null;
        this.db[0] = null;
    }

    public int p() {
        int n2 = 0;
        int n3 = 0;
        while (n3 < this.db.length) {
            if (this.db[n3] != null) {
                ++n2;
            }
            ++n3;
        }
        return n2;
    }

    public void q() {
        int n2 = 0;
        while (n2 < this.db.length) {
            if (this.db[n2] != null) {
                this.dm[n2] = this.db[n2].if;
                this.dn[n2] = this.db[n2].a;
                this.c5[n2] = this.db[n2].p;
                this.db[n2].a2 = this;
            } else {
                this.dm[n2] = 0;
                this.dn[n2] = "";
            }
            ++n2;
        }
    }

    public k for(String string) {
        int n2 = 0;
        while (n2 < this.db.length) {
            if (this.db[n2] != null && this.db[n2].a.equals(string)) {
                return this.db[n2];
            }
            ++n2;
        }
        return null;
    }

    public void a(k k2) {
        int n2 = 0;
        while (n2 < this.dn.length) {
            if (this.dm[n2] == k2.if || this.dn[n2].equals(k2.a)) {
                k2.a2 = this;
                break;
            }
            ++n2;
        }
    }
}

