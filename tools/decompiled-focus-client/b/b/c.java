/*
 * Decompiled with CFR 0.152.
 */
package b.b;

import a.a.e;
import a.a.k;
import a.d.i;
import a.d.j;
import b.b.a;
import b.b.b;
import b.b.d;
import java.io.IOException;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class c {
    private a.d.k if;
    private boolean a;

    public void a() {
        if (this.if != null) {
            this.if.new();
        }
    }

    public c(String string, int n2, String string2, String string3, String string4, int n3) throws IOException {
        this(new i(string, n2, string2, string3, string4, n3));
    }

    public c(String string, int n2) throws IOException {
        this(new i(string, n2));
    }

    public c(i i2) {
        this.if = new a.d.k(i2);
        this.if.if(65535);
        d d2 = new d();
        a a10 = new a();
        this.if.a(d2);
        this.if.a(a10);
    }

    public boolean a(b b2) {
        if (this.if != null) {
            a.d.k k2 = this.if;
            synchronized (k2) {
                this.if.if(b2);
                boolean bl = this.if.c();
                Object var3_4 = null;
                return bl;
            }
        }
        return false;
    }

    public b for() throws IOException {
        i i2 = this.if.i();
        k k2 = i2.new();
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

    public j if() {
        return this.if;
    }

    public boolean do() {
        if (this.if != null) {
            return this.if.c();
        }
        return false;
    }
}

