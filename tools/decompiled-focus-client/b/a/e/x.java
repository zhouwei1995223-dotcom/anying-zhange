/*
 * Decompiled with CFR 0.152.
 */
package b.a.e;

import a.a.e;
import b.a.b;
import b.a.e.j;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class x
extends j {
    public int ik;
    public int ij;

    public void a(e e2) {
        super.a(e2);
        this.ik = e2.for();
        this.ij = e2.case();
        int n2 = e2.i();
        if (n2 > 0) {
            this.fI = a.a.b.if(n2).getTime();
        }
        this.fY = e2.i();
        this.fR = e2.h();
    }

    public void if(e e2) {
        super.if(e2);
        e2.a(this.ik);
        e2.a(this.ij);
        if (this.fI > 0L) {
            e2.char(a.a.b.a(this.fI));
        } else {
            e2.char(0);
        }
        e2.char(this.fY);
        e2.a(this.fR);
    }

    public x() {
        this.fM = 6;
        this.fW = 6;
    }

    public void do(b b2) {
        super.do(b2);
        x x2 = (x)b2;
        this.ik = x2.ik;
        this.ij = x2.ij;
    }

    public void byte(String string) {
        int n2 = Integer.parseInt(string);
        this.fI = a.a.b.if(n2).getTime();
    }

    public String U() {
        int n2 = a.a.b.a(this.fI);
        return String.valueOf(n2);
    }
}

