/*
 * Decompiled with CFR 0.152.
 */
package a.d;

import a.a.h;
import a.d.d;
import a.d.j;
import a.d.o;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public abstract class a {
    private int do;
    private a.a.a new = new h();
    private int for;
    private o if;
    protected long a;
    protected long int;

    public abstract void do();

    public abstract int byte();

    public synchronized void case() {
        this.new.a();
    }

    public void a(o o2) {
        this.if = o2;
    }

    public o try() {
        return this.if;
    }

    public abstract boolean int();

    public synchronized void a(d d2) {
        this.new.do(d2);
    }

    public void a(int n2) {
        this.int += (long)n2;
    }

    public void int(int n2) {
        this.a += (long)n2;
    }

    public synchronized void if(d d2) {
        this.new.if(d2);
    }

    public void for(int n2) {
        this.for = n2;
    }

    public int a() {
        return this.for;
    }

    public void if(int n2) {
        this.do = n2;
    }

    public long for() {
        return this.int;
    }

    public long new() {
        return this.a;
    }

    protected void if(j j2) {
        if (this.if != null) {
            j2.a(this.if.if());
            j2.a(this.if.a());
        }
        int n2 = this.new.for();
        int n3 = 0;
        while (n3 < n2) {
            d d2 = (d)this.new.if(n3);
            d2.if(j2);
            ++n3;
        }
    }

    protected void a(j j2) {
        int n2 = this.new.for();
        int n3 = 0;
        while (n3 < n2) {
            d d2 = (d)this.new.if(n3);
            d2.a(j2);
            ++n3;
        }
    }

    public int if() {
        return this.do;
    }

    public void do(int n2) {
        this.do = n2;
    }
}

