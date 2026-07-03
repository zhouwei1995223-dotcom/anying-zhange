/*
 * Decompiled with CFR 0.152.
 */
package b.a.e;

import a.a.e;
import a.a.h;
import a.a.i;
import b.a.b;
import b.a.e.j;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class n
extends b {
    public String i3 = "";
    public int i2 = 8;
    public j[] i1 = new j[200];
    public transient boolean i5;
    public transient boolean i6;
    public transient boolean i4;

    public void a(e e2) {
        this.i2 = e2.for();
        int n2 = 0;
        while (n2 < this.i2) {
            if (e2.c()) {
                int n3 = e2.case();
                this.i1[n2] = j.h(n3);
                this.i1[n2].a(e2);
            }
            ++n2;
        }
        this.i4 = true;
    }

    public void if(e e2) {
        e2.a(this.i2);
        int n2 = 0;
        while (n2 < this.i2) {
            e2.a(this.i1[n2] != null);
            if (this.i1[n2] != null) {
                e2.a(this.i1[n2].fW);
                this.i1[n2].if(e2);
            }
            ++n2;
        }
    }

    public i a(String string) {
        if (string.equals("goods")) {
            i i2 = new i(string);
            int n2 = 0;
            while (n2 < this.i2) {
                if (this.i1[n2] != null) {
                    i i3 = new i(String.valueOf(n2));
                    String string2 = String.valueOf(this.i1[n2].if);
                    String string3 = this.i1[n2].U();
                    if (string3.length() > 0) {
                        string2 = string2 + ',' + string3;
                    }
                    i3.do(string2);
                    i2.a(i3);
                }
                ++n2;
            }
            return i2;
        }
        return super.a(string);
    }

    public boolean a(String string, i i2) {
        if (string.equals("goods")) {
            i2.for();
            h h2 = i2.int();
            if (h2 != null) {
                int n2 = h2.for();
                int n3 = 0;
                while (n3 < n2) {
                    i i3 = (i)h2.if(n3);
                    if (i3.for().length() >= 1) {
                        Object object;
                        int n4;
                        int n5 = Integer.parseInt(i3.do());
                        String string2 = i3.for();
                        int n6 = string2.indexOf(44);
                        if (n6 > 0) {
                            n4 = Integer.parseInt(string2.substring(0, n6));
                            object = string2.substring(n6 + 1);
                            j j2 = j.i(n4);
                            if (j2 != null) {
                                this.i1[n5] = (j)b.a(j2);
                                this.i1[n5].byte((String)object);
                            }
                        } else {
                            n4 = Integer.parseInt(i3.for());
                            object = j.i(n4);
                            if (object != null) {
                                this.i1[n5] = (j)b.a((b)object);
                            }
                        }
                    }
                    ++n3;
                }
            }
            return true;
        }
        return super.a(string, i2);
    }

    public int V() {
        int n2 = 0;
        while (n2 < this.i2) {
            if (this.i1[n2] == null) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }
}

