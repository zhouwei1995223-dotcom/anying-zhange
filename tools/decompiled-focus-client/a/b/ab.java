/*
 * Decompiled with CFR 0.152.
 */
package a.b;

import a.b.af;
import a.b.b;
import a.b.c;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ab
implements b {
    private af l;
    private int n;
    private int k;
    private int m;
    private int o;

    public ab(af af2) {
        this.a(af2);
    }

    public ab(af af2, int n2, int n3, int n4, int n5) {
        this.a(af2, n2, n3, n4, n5);
    }

    public void a(c c2, int n2, int n3, int n4, int n5) {
        if (this.m == 0 && this.o == 0 && this.l != null) {
            this.m = this.l.int();
            this.o = this.l.try();
        }
        c2.a(this.l, n2, n3, this.n, this.k, this.m, this.o, n4, n5);
    }

    public int if() {
        return this.o;
    }

    public af byte() {
        return this.l;
    }

    public void a(af af2) {
        if (af2 != null) {
            this.a(af2, 0, 0, af2.int(), af2.try());
        }
    }

    public void a(af af2, int n2, int n3, int n4, int n5) {
        this.l = af2;
        this.n = n2;
        this.k = n3;
        this.m = n4;
        this.o = n5;
    }

    public int a() {
        return this.m;
    }
}

