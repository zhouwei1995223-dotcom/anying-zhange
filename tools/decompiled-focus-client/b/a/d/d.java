/*
 * Decompiled with CFR 0.152.
 */
package b.a.d;

import a.a.e;
import b.a.d.c;
import b.a.d.f;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class d
extends c {
    public static final String[] ap = new String[]{"\u5f13\u7bad\u624b", "\u6cd5\u5e08", "\u6218\u58eb"};
    public static final String[] am = new String[]{"\u7537", "\u5973"};
    public int af;
    public int an;
    public int ab;
    public int ao;
    public int ae = 1;
    public transient String as = "";
    public transient boolean ad = true;
    public transient int ac;
    public transient int aq;
    public transient String aj = "";
    public transient int ah;
    public transient int al;
    public transient int ai;
    public transient int ar;
    public transient String ag = "";
    public transient f ak;
    public transient int titleEffect;
    public transient int auraEffect;

    public void a(e e2) {
        int n2;
        super.a(e2);
        int n3 = e2.for();
        this.af = n3 & 7;
        this.an = n3 >> 3 & 1;
        this.ab = n3 >> 4;
        this.ao = e2.for();
        this.ac = e2.for();
        this.aq = e2.for();
        this.ar = e2.case();
        this.al = e2.for();
        if (this.al > 0) {
            this.ai = e2.for();
            this.ah = e2.for();
            this.aj = e2.h();
        }
        if ((n2 = e2.for()) > 0) {
            char[] cArray = new char[n2];
            int n4 = 0;
            while (n4 < n2) {
                cArray[n4] = (char)e2.j();
                ++n4;
            }
            this.ag = new String(cArray);
        }
    }

    public void if(e e2) {
        super.if(e2);
        e2.a(this.af | this.an << 3 | this.ab << 4);
        e2.a(this.ao);
        e2.a(this.ac);
        e2.a(this.aq);
        e2.a(this.ar);
        if (this.ak != null) {
            e2.a(this.ak.cx);
            e2.a(this.ai);
            e2.a(this.ak.cU);
            e2.a(this.ak.a);
        } else {
            e2.a(0);
        }
        if (this.ag.length() == 0) {
            e2.a(0);
        } else {
            e2.a(this.ag.length());
            int n2 = 0;
            while (n2 < this.ag.length()) {
                e2.for(this.ag.charAt(n2));
                ++n2;
            }
        }
    }

    public d() {
        this.d = 3;
    }
}

