/*
 * Decompiled with CFR 0.152.
 */
package b.a.b;

import a.b.af;
import a.b.c;
import b.a.b.d;
import b.a.b.q;
import b.a.d.j;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class b
extends d {
    public static final af[] a9 = new af[100];
    private j a7;
    private int a5;
    private int a8;
    private Object a6;
    private boolean a4;

    public void do(c c2) {
        if (this.a7.ci || this.a4) {
            int n2 = this.new;
            int n3 = this.char();
            q.a(c2, this.a7.a, n2 - this.a5, n3 - 16, -16278792);
        }
    }

    public int do() {
        return 1;
    }

    public int char() {
        return this.for - 56;
    }

    public void a(long l2) {
        int n2 = this.byte.h.x;
        int n3 = this.byte.h.y;
        this.if = (this.a7.ci || this.a4) && n2 > this.new - 15 && n2 < this.new + 15 && n3 > this.for - 50 && n3 < this.for + 2;
    }

    public void do(boolean bl) {
        this.a4 = bl;
    }

    public void if(c c2) {
        if (this.a7.ci || this.a4) {
            int n2 = this.try();
            int n3 = this.char();
            af af2 = a9[this.a7.ch];
            if (af2 != null) {
                if (this.byte.case() == this) {
                    c2.if(af2, n2, n3, 40);
                } else if (!this.a7.ci) {
                    c2.do(af2, n2, n3, 120);
                } else {
                    c2.a(af2, n2, n3);
                }
            } else {
                c2.a(n2, n3, 64, 64, -1627389952);
            }
        }
    }

    public void a(int n2, int n3) {
        if (n3 > this.for || n3 == this.for && n2 > this.new) {
            this.new = n2;
            this.for = n3;
            if (this.do != null) {
                this.do.if(this);
            }
        } else if (n3 < this.for || n3 == this.for && n2 < this.new) {
            this.new = n2;
            this.for = n3;
            if (this.do != null) {
                this.do.a(this);
            }
        }
    }

    public int else() {
        return 64;
    }

    public Object u() {
        return this.a6;
    }

    public void if(Object object) {
        this.a6 = object;
    }

    public void a(j j2) {
        this.a7 = j2;
        this.new = this.byte.try(j2.void);
        this.for = this.byte.int(j2.long);
        this.a8 = a.b.q.if(j2.a);
        this.a5 = this.a8 / 2;
    }

    public int try() {
        return this.new - 32;
    }

    public int for() {
        return 64;
    }

    public boolean t() {
        return this.a4;
    }

    public j s() {
        return this.a7;
    }
}

