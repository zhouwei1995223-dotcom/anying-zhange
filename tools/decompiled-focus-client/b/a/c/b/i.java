/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.b;
import a.b.c;
import b.a.c.b.e;
import b.a.e.f;
import b.a.e.j;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class i
implements b {
    private static i r;
    private j q;
    private f p;

    public boolean char() {
        return this.q != null || this.p != null;
    }

    public f goto() {
        return this.p;
    }

    public void a(f f2) {
        this.p = f2;
        this.q = null;
    }

    public void a(c c2, int n2, int n3, int n4, int n5) {
        if (this.q != null) {
            e.a(c2, this.q, n2, n3);
        } else if (this.p != null) {
            e.a(c2, this.p, n2, n3);
        }
    }

    public int if() {
        return 24;
    }

    public j case() {
        return this.q;
    }

    public void a(j j2) {
        this.q = j2;
        this.p = null;
    }

    public int a() {
        return 24;
    }

    public static final i else() {
        if (r == null) {
            r = new i();
        }
        return r;
    }
}

