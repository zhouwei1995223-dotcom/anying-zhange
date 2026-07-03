/*
 * Decompiled with CFR 0.152.
 */
package b.a.e;

import a.a.e;
import a.a.h;
import a.a.i;
import b.a.d.k;
import b.a.e.a;
import b.a.e.b;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class s
extends b.a.b {
    public String[] jU = new String[50];
    public transient int jM;
    public String[] jN = new String[20];
    public transient int jQ;
    public String[] jT = new String[20];
    public transient int jR;
    public a jP;
    public b[] jS = new b[15];
    public transient int jO;
    private static /* synthetic */ Class class$app$island$data$Shifu;
    private static /* synthetic */ Class class$app$island$data$Tudi;

    public boolean char(String string) {
        return this.jP != null && this.jP.a.equals(string);
    }

    public void a(String string, int n2) {
        int n3 = 0;
        while (n3 < this.jO) {
            if (string.equals(this.jS[n3].a)) {
                this.jS[n3].dA += n2;
                break;
            }
            ++n3;
        }
    }

    public void a(e e2) {
        this.jM = e2.case();
        int n2 = 0;
        while (n2 < this.jM) {
            this.jU[n2] = e2.h();
            ++n2;
        }
        this.jQ = e2.case();
        n2 = 0;
        while (n2 < this.jQ) {
            this.jN[n2] = e2.h();
            ++n2;
        }
        this.jR = e2.case();
        n2 = 0;
        while (n2 < this.jR) {
            this.jT[n2] = e2.h();
            ++n2;
        }
        if (e2.c()) {
            this.jP = new a();
            this.jP.a(e2);
        }
        this.jO = e2.for();
        n2 = 0;
        while (n2 < this.jO) {
            this.jS[n2] = new b();
            this.jS[n2].a(e2);
            ++n2;
        }
    }

    public void if(e e2) {
        e2.a(this.jM);
        int n2 = 0;
        while (n2 < this.jM) {
            e2.a(this.jU[n2]);
            ++n2;
        }
        e2.a(this.jQ);
        n2 = 0;
        while (n2 < this.jQ) {
            e2.a(this.jN[n2]);
            ++n2;
        }
        e2.a(this.jR);
        n2 = 0;
        while (n2 < this.jR) {
            e2.a(this.jT[n2]);
            ++n2;
        }
        e2.a(this.jP != null);
        if (this.jP != null) {
            this.jP.if(e2);
        }
        e2.a(this.jO);
        n2 = 0;
        while (n2 < this.jO) {
            this.jS[n2].if(e2);
            ++n2;
        }
    }

    public void f(String string) {
        if (this.jR < this.jT.length) {
            this.jT[this.jR++] = string;
        }
    }

    public b long(String string) {
        int n2 = 0;
        while (n2 < this.jO) {
            if (string.equals(this.jS[n2].a)) {
                return this.jS[n2];
            }
            ++n2;
        }
        return null;
    }

    public i a(String string) {
        if (string.equals("friends")) {
            i i2 = new i(string);
            int n2 = 0;
            while (n2 < this.jM) {
                i i3 = new i(String.valueOf(n2));
                i3.do(this.jU[n2]);
                i2.a(i3);
                ++n2;
            }
            return i2;
        }
        if (string.equals("enemies")) {
            i i4 = new i(string);
            int n3 = 0;
            while (n3 < this.jQ) {
                i i5 = new i(String.valueOf(n3));
                i5.do(this.jN[n3]);
                i4.a(i5);
                ++n3;
            }
            return i4;
        }
        if (string.equals("blacks")) {
            i i6 = new i(string);
            int n4 = 0;
            while (n4 < this.jR) {
                i i7 = new i(String.valueOf(n4));
                i7.do(this.jT[n4]);
                i6.a(i7);
                ++n4;
            }
            return i6;
        }
        if (string.equals("master")) {
            i i8 = b.a.a.a().a(this.jP);
            if (i8 != null) {
                i8.if(string);
            }
            return i8;
        }
        if (string.equals("students")) {
            i i9 = new i(string);
            int n5 = 0;
            while (n5 < this.jO) {
                i i10 = b.a.a.a().a(this.jS[n5]);
                if (i10 != null) {
                    i10.if(String.valueOf(n5));
                    i9.a(i10);
                }
                ++n5;
            }
            return i9;
        }
        return super.a(string);
    }

    public boolean a(String string, i i2) {
        if (string.equals("friends")) {
            h h2 = i2.int();
            int n2 = 0;
            while (h2 != null && n2 < h2.for()) {
                i i3 = (i)h2.if(n2);
                this.jU[this.jM++] = i3.for();
                ++n2;
            }
            return true;
        }
        if (string.equals("enemies")) {
            h h3 = i2.int();
            int n3 = 0;
            while (h3 != null && n3 < h3.for()) {
                i i4 = (i)h3.if(n3);
                this.jN[this.jQ++] = i4.for();
                ++n3;
            }
            return true;
        }
        if (string.equals("blacks")) {
            h h4 = i2.int();
            int n4 = 0;
            while (h4 != null && n4 < h4.for()) {
                i i5 = (i)h4.if(n4);
                this.jT[this.jR++] = i5.for();
                ++n4;
            }
            return true;
        }
        if (string.equals("master")) {
            h h5 = i2.int();
            if (h5 != null) {
                i2.if((class$app$island$data$Shifu != null ? class$app$island$data$Shifu : (class$app$island$data$Shifu = s.class$("app.island.data.Shifu"))).getName());
                this.jP = (a)b.a.a.a().a(i2);
            }
            return true;
        }
        if (string.equals("students")) {
            h h6 = i2.int();
            int n5 = 0;
            while (h6 != null && n5 < h6.for()) {
                i i6 = (i)h6.if(n5);
                i6.if((class$app$island$data$Tudi != null ? class$app$island$data$Tudi : s.class$("app.island.data.Tudi")).getName());
                this.jS[this.jO] = (b)b.a.a.a().a(i6);
                if (this.jS[this.jO] != null) {
                    ++this.jO;
                }
                ++n5;
            }
            return true;
        }
        return super.a(string, i2);
    }

    public void void(String string) {
        if (string == null || string.length() < 1) {
            return;
        }
        int n2 = 0;
        while (n2 < this.jO) {
            if (string.equals(this.jS[n2].a)) {
                this.jO += -1;
                int n3 = n2;
                while (n3 < this.jO) {
                    this.jS[n3] = this.jS[n3 + 1];
                    ++n3;
                }
                this.jS[this.jO] = null;
                break;
            }
            ++n2;
        }
    }

    public void b(String string) {
        int n2 = 0;
        while (n2 < this.jM) {
            if (this.jU[n2].equals(string)) {
                this.jM += -1;
                int n3 = n2;
                while (n3 < this.jM) {
                    this.jU[n3] = this.jU[n3 + 1];
                    ++n3;
                }
                this.jU[this.jM] = null;
                break;
            }
            ++n2;
        }
    }

    public boolean h(String string) {
        int n2 = 0;
        while (n2 < this.jM) {
            if (this.jU[n2].equals(string)) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    public boolean d(String string) {
        if (string == null || string.length() < 1) {
            return false;
        }
        int n2 = 0;
        while (n2 < this.jO) {
            if (string.equals(this.jS[n2].a)) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    public void goto(k k2) {
        this.jP = new a();
        this.jP.a = k2.a;
        this.jP.dt = a.a.b.if();
        this.jP.dx = k2.af;
        this.jP.dy = k2.p;
        this.jP.dw = k2.ab;
    }

    public void else(k k2) {
        b b2 = new b();
        b2.a = k2.a;
        b2.dz = a.a.b.if();
        b2.dD = k2.af;
        b2.dE = k2.p;
        b2.dC = k2.ab;
        this.a(b2);
    }

    public void e(String string) {
        if (this.jM < this.jU.length) {
            this.jU[this.jM++] = string;
        }
    }

    public void a(b b2) {
        if (b2 == null) {
            return;
        }
        int n2 = 0;
        while (n2 < this.jO) {
            if (b2.a.equals(this.jS[n2].a)) {
                return;
            }
            ++n2;
        }
        this.jS[this.jO++] = b2;
    }

    public void c(String string) {
        int n2 = 0;
        while (n2 < this.jQ) {
            if (this.jN[n2].equals(string)) {
                this.jQ += -1;
                int n3 = n2;
                while (n3 < this.jQ) {
                    this.jN[n3] = this.jN[n3 + 1];
                    ++n3;
                }
                this.jN[this.jQ] = null;
                break;
            }
            ++n2;
        }
    }

    public boolean case(String string) {
        int n2 = 0;
        while (n2 < this.jQ) {
            if (this.jN[n2].equals(string)) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    private static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError(classNotFoundException.getMessage());
        }
    }

    public void else(String string) {
        int n2 = 0;
        while (n2 < this.jR) {
            if (this.jT[n2].equals(string)) {
                this.jR += -1;
                int n3 = n2;
                while (n3 < this.jR) {
                    this.jT[n3] = this.jT[n3 + 1];
                    ++n3;
                }
                this.jT[this.jR] = null;
                break;
            }
            ++n2;
        }
    }

    public boolean g(String string) {
        int n2 = 0;
        while (n2 < this.jR) {
            if (this.jT[n2].equals(string)) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    public void goto(String string) {
        if (this.jQ < this.jN.length) {
            this.jN[this.jQ++] = string;
        }
    }
}

