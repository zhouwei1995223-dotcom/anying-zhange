/*
 * Decompiled with CFR 0.152.
 */
package b.a.b;

import a.b.c;
import b.a.b.h;
import b.a.b.q;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public abstract class d {
    d case;
    d try;
    protected q byte;
    protected h do;
    protected int new;
    protected int for;
    protected boolean int = true;
    protected boolean if;
    protected boolean a;

    public q int() {
        return this.byte;
    }

    public void a(q q2) {
        this.byte = q2;
    }

    public int case() {
        return this.new;
    }

    public void do(c c2) {
    }

    public abstract int do();

    public abstract int char();

    public void a(c c2) {
    }

    public abstract void a(long var1);

    public void if(boolean bl) {
        this.a = bl;
    }

    public int a() {
        return this.for;
    }

    public boolean new() {
        return this.if;
    }

    public boolean if(int n2, int n3) {
        return n2 > this.try() && n3 > this.char() && n2 < this.try() + this.for() && n3 < this.char() + this.else();
    }

    public abstract void if(c var1);

    public void a(int n2, int n3) {
        if (this.new != n2 || this.for != n3) {
            this.new = n2;
            this.for = n3;
        }
    }

    public abstract int else();

    public int a(d d2) {
        if (this.for != d2.for) {
            return this.for - d2.for;
        }
        if (this.new != d2.new) {
            return this.new - d2.new;
        }
        return this.hashCode() - d2.hashCode();
    }

    public boolean byte() {
        return this.a;
    }

    public abstract int try();

    public abstract int for();

    public void a(boolean bl) {
        this.int = bl;
    }

    public boolean if() {
        return this.int;
    }
}

