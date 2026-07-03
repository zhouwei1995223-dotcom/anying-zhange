/*
 * Decompiled with CFR 0.152.
 */
package daff.net;

import daff.a.h;
import daff.net.d;
import daff.net.i;
import daff.net.n;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public abstract class a {
    private int do;
    private daff.a.a new = new h();
    private int for;
    private n if;
    protected long a;
    protected long int;

    public abstract void stop();

    public abstract int getConnectionCount();

    public synchronized void new() {
        this.new.a();
    }

    public void a(n n2) {
        this.if = n2;
    }

    public n int() {
        return this.if;
    }

    public abstract boolean start();

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

    public long do() {
        return this.int;
    }

    public long for() {
        return this.a;
    }

    protected void if(i i2) {
        if (this.if != null) {
            i2.a(this.if.if());
            i2.a(this.if.a());
        }
        int n2 = this.new.for();
        int n3 = 0;
        while (n3 < n2) {
            d d2 = (d)this.new.if(n3);
            d2.if(i2);
            ++n3;
        }
    }

    protected void a(i i2) {
        int n2 = this.new.for();
        int n3 = 0;
        while (n3 < n2) {
            d d2 = (d)this.new.if(n3);
            d2.a(i2);
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

