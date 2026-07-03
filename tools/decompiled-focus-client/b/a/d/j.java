/*
 * Decompiled with CFR 0.152.
 */
package b.a.d;

import b.a.b;
import b.a.d.e;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class j
extends e {
    public int ch;
    public String ce = "";
    public String cd = "";
    public int cf;
    public transient boolean cg = true;
    public transient boolean ci = true;

    public void a(a.a.e e2) {
        super.a(e2);
        this.ch = e2.for();
        this.cg = e2.c();
        this.ci = e2.c();
    }

    public void if(a.a.e e2) {
        super.if(e2);
        e2.a(this.ch);
        e2.a(this.cg);
        e2.a(this.ci);
    }

    public j() {
        this.d = 2;
    }

    public void do(b b2) {
        super.do(b2);
        j j2 = (j)b2;
        this.ch = j2.ch;
        this.cg = j2.cg;
        this.ci = j2.ci;
    }
}

