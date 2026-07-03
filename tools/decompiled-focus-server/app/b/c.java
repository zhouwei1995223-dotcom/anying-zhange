/*
 * Decompiled with CFR 0.152.
 */
package app.b;

import app.b.a;
import app.b.b;
import app.b.d;
import daff.a.e;
import daff.a.k;
import daff.net.h;
import daff.net.i;
import daff.net.j;
import java.io.IOException;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class c {
    private j if;
    private boolean a;

    public void a() {
        if (this.if != null) {
            this.if.new();
        }
    }

    public c(String string, int n2, String string2, String string3, String string4, int n3) throws IOException {
        this(new h(string, n2, string2, string3, string4, n3));
    }

    public c(String string, int n2) throws IOException {
        this(new h(string, n2));
    }

    public c(h h2) {
        this.if = new j(h2);
        this.if.if(65535);
        d d2 = new d();
        a a2 = new a();
        this.if.a(d2);
        this.if.a(a2);
    }

    public boolean a(b b2) {
        if (this.if != null) {
            j j2 = this.if;
            synchronized (j2) {
                this.if.if(b2);
                boolean bl = this.if.c();
                Object var3_4 = null;
                return bl;
            }
        }
        return false;
    }

    public b for() throws IOException {
        h h2 = this.if.i();
        k k2 = h2.new();
        int n2 = k2.byte() & 0xFFFF;
        int n3 = k2.byte() & 0xFFFF;
        if (n2 < 0 || n3 == 0) {
            return b.ay;
        }
        e e2 = new e(n2);
        e2.a(k2);
        b b2 = new b(n3, e2);
        b2.a(this.if);
        return b2;
    }

    public i if() {
        return this.if;
    }

    public boolean do() {
        if (this.if != null) {
            return this.if.c();
        }
        return false;
    }
}

