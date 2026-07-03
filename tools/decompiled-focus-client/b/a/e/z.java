/*
 * Decompiled with CFR 0.152.
 */
package b.a.e;

import a.a.e;
import b.a.b;
import b.a.d.c;
import b.a.e.f;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class z
extends f {
    public int e7;
    public int fd;
    public int fc;
    public int fg;
    public int fi;
    public int fe;
    public int e9;
    public int e8;
    public int ff;
    public int fh;
    public int fb;
    public int fa;

    public void a(e e2) {
        super.a(e2);
        this.e7 = e2.for();
        this.fd = e2.j();
        this.fc = e2.j();
        this.fi = e2.j();
        this.fe = e2.j();
        this.e9 = e2.j();
        this.e8 = e2.j();
        this.ff = e2.j();
    }

    public int if(c c2) {
        int n2 = this.fc;
        if (this.fi > 0) {
            n2 += c2.N * this.fi / 100;
        }
        if (this.fe > 0) {
            n2 += c2.G * this.fe / 100;
        }
        if (this.e9 > 0) {
            n2 += c2.X * this.e9 / 100;
        }
        if (this.ff > 0) {
            n2 += c2.int() * this.ff / 100;
        }
        if (this.e8 > 0) {
            n2 += c2.if() * this.e8 / 100;
        }
        return n2;
    }

    public void if(e e2) {
        super.if(e2);
        e2.a(this.e7);
        e2.for(this.fd);
        e2.for(this.fc);
        e2.for(this.fi);
        e2.for(this.fe);
        e2.for(this.e9);
        e2.for(this.e8);
        e2.for(this.ff);
    }

    public z() {
        this.eH = 1;
    }

    public void do(b b2) {
        super.do(b2);
        z z2 = (z)b2;
        this.e7 = z2.e7;
        this.fd = z2.fd;
        this.fc = z2.fc;
        this.fg = z2.fg;
        this.fi = z2.fi;
        this.fe = z2.fe;
        this.e9 = z2.e9;
        this.e8 = z2.e8;
        this.ff = z2.ff;
        this.fh = z2.fh;
        this.fb = z2.fb;
        this.fa = z2.fa;
    }

    public int a(c c2) {
        int n2 = this.fd;
        if (this.fi > 0) {
            n2 += c2.N * this.fi / 100;
        }
        if (this.fe > 0) {
            n2 += c2.G * this.fe / 100;
        }
        if (this.e9 > 0) {
            n2 += c2.X * this.e9 / 100;
        }
        if (this.ff > 0) {
            n2 += c2.case() * this.ff / 100;
        }
        if (this.e8 > 0) {
            n2 += c2.a() * this.e8 / 100;
        }
        return n2;
    }
}

