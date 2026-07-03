/*
 * Decompiled with CFR 0.152.
 */
package b.a.e;

import a.a.e;
import b.a.b;
import b.a.e.f;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class o
extends f {
    public int eX;
    public int eW;
    public int eV;

    public void a(e e2) {
        super.a(e2);
        this.eX = e2.for();
        this.eV = e2.for();
    }

    public void if(e e2) {
        super.if(e2);
        e2.a(this.eX);
        e2.a(this.eV);
    }

    public o() {
        this.eR = 1;
        this.eH = 2;
    }

    public void do(b b2) {
        super.do(b2);
        o o2 = (o)b2;
        this.eX = o2.eX;
        this.eW = o2.eW;
        this.eV = o2.eV;
    }
}

