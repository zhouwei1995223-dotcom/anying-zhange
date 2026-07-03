/*
 * Decompiled with CFR 0.152.
 */
package b.a.e;

import a.a.e;
import a.a.h;
import a.a.i;
import b.a.b;
import b.a.e.c;
import java.util.Date;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class k
extends b {
    public int[] iR = new int[0];
    public h iW = new h(10);
    public h iS = new h(10);
    public int iV;
    public int iQ;
    public int iU;
    public transient boolean iT;

    public void a(e e2) {
        this.iT = true;
        int n2 = e2.for();
        int n3 = 0;
        while (n3 < n2) {
            c c2 = new c();
            c2.a(e2);
            this.iW.if(c2);
            ++n3;
        }
    }

    public void if(e e2) {
        int n2 = this.iW.for();
        e2.a(n2);
        int n3 = 0;
        while (n3 < n2) {
            c c2 = (c)this.iW.if(n3);
            c2.if(e2);
            ++n3;
        }
    }

    public c o(int n2) {
        int n3 = this.iW.for();
        int n4 = 0;
        while (n4 < n3) {
            c c2 = (c)this.iW.if(n4);
            if (c2.if == n2) {
                return c2;
            }
            ++n4;
        }
        return null;
    }

    public i a(String string) {
        if (string.equals("historys")) {
            StringBuffer stringBuffer = new StringBuffer(this.iR.length * 12);
            int n2 = 0;
            while (n2 < this.iR.length) {
                stringBuffer.append(this.iR[n2]);
                stringBuffer.append(',');
                ++n2;
            }
            i i2 = new i(string);
            i2.do(stringBuffer.toString());
            return i2;
        }
        if (string.equals("tasks")) {
            int n3 = this.iW.for();
            StringBuffer stringBuffer = new StringBuffer(n3 * 22);
            int n4 = 0;
            while (n4 < n3) {
                c c2 = (c)this.iW.if(n4);
                stringBuffer.append(c2.if);
                stringBuffer.append(',');
                stringBuffer.append(c2.dV);
                stringBuffer.append(',');
                stringBuffer.append(c2.d9);
                stringBuffer.append(',');
                stringBuffer.append(c2.ed);
                stringBuffer.append(';');
                ++n4;
            }
            i i3 = new i(string);
            i3.do(stringBuffer.toString());
            return i3;
        }
        if (string.equals("limitedTasks")) {
            int n5 = this.iS.for();
            StringBuffer stringBuffer = new StringBuffer(n5 * 20);
            int n6 = 0;
            while (n6 < n5) {
                c c3 = (c)this.iS.if(n6);
                stringBuffer.append(c3.if);
                stringBuffer.append(',');
                stringBuffer.append(a.a.b.a(c3.ef));
                stringBuffer.append(';');
                ++n6;
            }
            i i4 = new i(string);
            i4.do(stringBuffer.toString());
            return i4;
        }
        return super.a(string);
    }

    public boolean a(String string, i i2) {
        String string2 = i2.for();
        if (string.equals("historys")) {
            String[] stringArray = a.a.b.a(string2, ",");
            int n2 = Math.max(0, stringArray.length - 1);
            this.iR = new int[n2];
            int n3 = 0;
            while (n3 < n2) {
                this.iR[n3] = Integer.parseInt(stringArray[n3]);
                ++n3;
            }
            return true;
        }
        if (string.equals("tasks")) {
            String[] stringArray = a.a.b.a(string2, ";");
            int n4 = 0;
            while (n4 < stringArray.length) {
                if (stringArray[n4].length() > 0) {
                    String[] stringArray2 = a.a.b.a(stringArray[n4], ",");
                    int n5 = Integer.parseInt(stringArray2[0]);
                    int n6 = Integer.parseInt(stringArray2[1]);
                    c c2 = c.char(n5);
                    if (c2 != null) {
                        c2 = (c)b.a(c2);
                        c2.dV = n6;
                        if (stringArray2.length > 2) {
                            c2.d9 = Integer.parseInt(stringArray2[2]);
                            c2.ed = Integer.parseInt(stringArray2[3]);
                            if (c2.ed > 0) {
                                c2.ej = a.a.b.if(c2.ed).getTime();
                            }
                        }
                        this.iW.if(c2);
                    }
                }
                ++n4;
            }
            return true;
        }
        if (string.equals("limitedTasks")) {
            String[] stringArray = a.a.b.a(string2, ";");
            int n7 = 0;
            while (n7 < stringArray.length) {
                String[] stringArray3;
                int n8;
                c c3;
                if (stringArray[n7].length() > 0 && (c3 = c.char(n8 = Integer.parseInt((stringArray3 = a.a.b.a(stringArray[n7], ","))[0]))) != null) {
                    c3 = (c)b.a(c3);
                    int n9 = Integer.parseInt(stringArray3[1]);
                    c3.ef = a.a.b.if(n9).getTime();
                    this.iS.if(c3);
                }
                ++n7;
            }
            return true;
        }
        return super.a(string, i2);
    }

    public c k(int n2) {
        int n3 = this.iS.for();
        int n4 = 0;
        while (n4 < n3) {
            c c2 = (c)this.iS.if(n4);
            if (c2.if == n2) {
                return c2;
            }
            ++n4;
        }
        return null;
    }

    public void if(c c2) {
        this.iW.do(c2);
    }

    public c n(int n2) {
        int n3 = this.iW.for();
        int n4 = 0;
        while (n4 < n3) {
            c c2 = (c)this.iW.if(n4);
            if (c2.if == n2) {
                this.iW.a(n4);
                return c2;
            }
            ++n4;
        }
        return null;
    }

    public c if(int n2, int n3) {
        int n4 = this.iW.for();
        int n5 = 0;
        while (n5 < n4) {
            c c2 = (c)this.iW.if(n5);
            if (c2.if == n2) {
                c2.dV = n3;
                return c2;
            }
            ++n5;
        }
        return null;
    }

    public void do(c c2) {
        this.iW.if(c2);
    }

    public c char(b.a.d.k k2) {
        int n2 = this.iW.for();
        int n3 = 0;
        while (n3 < n2) {
            c c2 = (c)this.iW.if(n3);
            if (c2.do(k2)) {
                return c2;
            }
            ++n3;
        }
        return null;
    }

    public boolean m(int n2) {
        int n3 = 0;
        while (n3 < this.iR.length) {
            if (this.iR[n3] == n2) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    public void a(c c2) {
        int n2 = this.iS.for();
        int n3 = 0;
        while (n3 < n2) {
            c c3 = (c)this.iS.if(n3);
            if (c3.if == c2.if) {
                c3.d9 = c2.d9;
                c3.ef = c2.ef;
                return;
            }
            ++n3;
        }
        this.iS.if(c2);
    }

    public boolean l(int n2) {
        return this.o(n2) != null;
    }

    public void j(int n2) {
        int n3 = 0;
        while (n3 < this.iR.length) {
            if (this.iR[n3] == n2) {
                return;
            }
            ++n3;
        }
        int[] nArray = new int[this.iR.length + 1];
        System.arraycopy(this.iR, 0, nArray, 0, this.iR.length);
        nArray[this.iR.length] = n2;
        this.iR = nArray;
    }

    public boolean a(c c2, long l2, b.a.d.k k2) {
        if (c2.dK != -1 && k2.af != c2.dK) {
            return false;
        }
        if (k2.ab < c2.ee) {
            return false;
        }
        if (k2.p < c2.ec || k2.p > c2.ei) {
            return false;
        }
        if (c2.dS > 0 && k2.bA.d(c2.dS) <= 0) {
            return false;
        }
        if (c2.el > 0 && (k2.ak == null || k2.ak.cx < c2.el)) {
            return false;
        }
        if (c2.d6 > 0 && !this.m(c2.d6)) {
            return false;
        }
        int n2 = c2.if;
        if (this.m(n2) || this.l(n2)) {
            return false;
        }
        if (c2.dJ == 0) {
            return true;
        }
        int n3 = this.iS.for();
        int n4 = 0;
        while (n4 < n3) {
            c c3 = (c)this.iS.if(n4);
            if (c3.if == n2) {
                if (c3.dJ == 1440) {
                    Date date = new Date(c3.ef);
                    Date date2 = new Date(l2);
                    return date.getDate() != date2.getDate();
                }
                return (l2 - c3.ef) / 60000L > (long)c3.dJ;
            }
            ++n4;
        }
        return true;
    }
}

