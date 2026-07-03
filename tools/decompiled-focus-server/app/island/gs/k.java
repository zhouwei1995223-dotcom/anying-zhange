/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs;

import app.b.b;
import app.island.gs.h;
import app.island.gs.x;
import daff.a.e;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public abstract class k {
    protected int int;
    protected String do;
    protected daff.a.h a;
    protected int if;
    protected x for;

    public void if(b b2, h h2) {
        int n2 = this.a.for();
        int n3 = 0;
        while (n3 < n2) {
            h h3 = (h)this.a.if(n3);
            if (h3.g() && h2 != h3) {
                h3.a(b2);
            }
            ++n3;
        }
    }

    public boolean for(h h2) {
        return this.if <= 0 || this.if > this.a.for();
    }

    public int try() {
        return this.int;
    }

    public void do(int n2) {
        this.int = n2;
    }

    public void a(b b2) {
        this.a(b2, null);
    }

    public void a(b b2, h h2) {
        int n2 = this.a.for();
        int n3 = 0;
        while (n3 < n2) {
            h h3 = (h)this.a.if(n3);
            if (h3 != h2) {
                h3.a(b2);
            }
            ++n3;
        }
    }

    public final void do(h h2) {
        this.a.do(h2);
        this.a(h2);
    }

    protected void a(h h2) {
    }

    public final void if(h h2) {
        if (this.a == null) {
            this.a = new daff.a.h(8);
        }
        this.a.if(h2);
        this.int(h2);
    }

    public x do() {
        return this.for;
    }

    public void a(x x2) {
        this.for = x2;
    }

    public h if(String string) {
        int n2 = this.a.for();
        int n3 = 0;
        while (n3 < n2) {
            h h2 = (h)this.a.if(n3);
            if (h2.b().equals(string)) {
                return h2;
            }
            ++n3;
        }
        return null;
    }

    public void a(h h2, int n2, e e2) {
    }

    public int new() {
        return this.a.for();
    }

    public int for() {
        return this.if;
    }

    public void if(int n2) {
        this.if = n2;
    }

    public void byte() {
        int n2 = this.a.for();
        int n3 = 0;
        while (n3 < n2) {
            h h2 = (h)this.a.if(n3);
            if (!h2.goto()) {
                this.a.a(n3--);
                --n2;
                this.a(h2);
            }
            ++n3;
        }
    }

    public String int() {
        return this.do;
    }

    public void a(String string) {
        this.do = string;
    }

    public h a(int n2) {
        int n3 = this.a.for();
        int n4 = 0;
        while (n4 < n3) {
            h h2 = (h)this.a.if(n4);
            if (h2.H() == n2) {
                return h2;
            }
            ++n4;
        }
        return null;
    }

    protected void int(h h2) {
    }

    public void if(b b2) {
        int n2 = this.a.for();
        int n3 = 0;
        while (n3 < n2) {
            h h2 = (h)this.a.if(n3);
            if (h2.g()) {
                h2.a(b2);
            }
            ++n3;
        }
    }
}

