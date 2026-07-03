/*
 * Decompiled with CFR 0.152.
 */
package b.a.e;

import a.a.e;
import b.a.b;
import b.a.d.k;
import b.a.e.f;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class q
extends f {
    public int eZ;
    public int e2;
    public int e3;
    public int eY;
    public int e6;
    public int e5;
    public int e4;
    public int e0;
    public int e1;

    public void a(e e2) {
        super.a(e2);
        this.eZ = e2.case();
        this.e2 = e2.case();
        this.e3 = e2.j();
        this.eY = e2.j();
        this.e6 = e2.j();
        this.e5 = e2.j();
        this.e4 = e2.j();
        this.e0 = e2.j();
    }

    public void if(e e2) {
        super.if(e2);
        e2.a(this.eZ);
        e2.a(this.e2);
        e2.for(this.e3);
        e2.for(this.eY);
        e2.for(this.e6);
        e2.for(this.e5);
        e2.for(this.e4);
        e2.for(this.e0);
    }

    public q() {
        this.eH = 3;
    }

    public void do(b b2) {
        super.do(b2);
        q q2 = (q)b2;
        this.eZ = q2.eZ;
        this.e2 = q2.e2;
        this.e3 = q2.e3;
        this.eY = q2.eY;
        this.e6 = q2.e6;
        this.e5 = q2.e5;
        this.e4 = q2.e4;
        this.e0 = q2.e0;
        this.e1 = q2.e1;
    }

    public int for(k k2) {
        return this.e6 + this.e5 * k2.N / 100 + this.e4 * k2.G / 100 + this.e0 * k2.X / 100;
    }
}

