/*
 * Decompiled with CFR 0.152.
 */
package b.a.e;

import a.a.e;
import a.a.h;
import a.a.i;
import b.a.b;
import b.a.d.k;
import b.a.e.f;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class g
extends b {
    public h fj = new h(10);

    public void a(e e2) {
        int n2 = e2.case();
        int n3 = 0;
        while (n3 < n2) {
            int n4 = e2.case();
            f f2 = f.goto(n4);
            f2.a(e2);
            this.fj.if(f2);
            ++n3;
        }
    }

    public f void(int n2) {
        n2 /= 100;
        int n3 = this.fj.for();
        int n4 = 0;
        while (n4 < n3) {
            f f2 = (f)this.fj.if(n4);
            if (f2.if / 100 == n2) {
                return f2;
            }
            ++n4;
        }
        return null;
    }

    public void if(e e2) {
        int n2 = this.fj.for();
        e2.a(n2);
        int n3 = 0;
        while (n3 < n2) {
            f f2 = (f)this.fj.if(n3);
            e2.a(f2.eH);
            f2.if(e2);
            ++n3;
        }
    }

    public i a(String string) {
        if (string.equals("spells")) {
            StringBuffer stringBuffer = new StringBuffer(1024);
            int n2 = this.fj.for();
            int n3 = 0;
            while (n3 < n2) {
                f f2 = (f)this.fj.if(n3);
                stringBuffer.append(f2.if);
                stringBuffer.append(',');
                stringBuffer.append(f2.eN);
                stringBuffer.append(';');
                ++n3;
            }
            i i2 = new i(string);
            i2.do(stringBuffer.toString());
            return i2;
        }
        return super.a(string);
    }

    public boolean a(String string, String string2) {
        if (string.equals("spells")) {
            String[] stringArray = a.a.b.a(string2, ";");
            int n2 = 0;
            while (n2 < stringArray.length) {
                if (stringArray[n2].length() == 0) break;
                int n3 = stringArray[n2].indexOf(44);
                int n4 = Integer.parseInt(stringArray[n2].substring(0, n3));
                int n5 = Integer.parseInt(stringArray[n2].substring(n3 + 1));
                f f2 = f.else(n4);
                if (f2 != null) {
                    f2 = (f)b.a(f2);
                    f2.eN = n5;
                    this.a(f2);
                }
                ++n2;
            }
            return true;
        }
        return super.a(string, string2);
    }

    public boolean b(int n2) {
        int n3 = n2 % 100;
        n2 /= 100;
        int n4 = this.fj.for();
        int n5 = 0;
        while (n5 < n4) {
            f f2 = (f)this.fj.if(n5);
            if (f2.if / 100 == n2 && f2.if % 100 >= n3) {
                return true;
            }
            ++n5;
        }
        return false;
    }

    public f long(int n2) {
        int n3 = this.fj.for();
        int n4 = 0;
        while (n4 < n3) {
            f f2 = (f)this.fj.if(n4);
            if (f2.if == n2) {
                return f2;
            }
            ++n4;
        }
        return null;
    }

    public void int(k k2) {
        int n2 = this.fj.for();
        int n3 = 0;
        while (n3 < n2) {
            f f2 = (f)this.fj.if(n3);
            if (f2.if / 10000 % 100 != k2.af) {
                this.fj.a(n3);
                --n3;
                --n2;
            }
            ++n3;
        }
    }

    public void a(f f2) {
        int n2 = this.fj.for();
        int n3 = 0;
        while (n3 < n2) {
            f f3 = (f)this.fj.if(n3);
            if (f3.if / 100 == f2.if / 100) {
                if (f3.if % 100 < f2.if % 100) {
                    f3.do(f2);
                }
                return;
            }
            ++n3;
        }
        this.fj.if(f2);
    }
}

