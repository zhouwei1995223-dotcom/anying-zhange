/*
 * Decompiled with CFR 0.152.
 */
package daff.net;

import daff.a.a;
import daff.a.h;
import daff.net.e;
import daff.net.g;
import daff.net.l;
import daff.net.m;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public abstract class i {
    public static boolean if = false;
    public static final int case = 0x100000;
    public static final int e = 32768;
    private a else = new h();
    private Object byte;
    private int char = Integer.MAX_VALUE;
    private e void;
    private l new;
    private daff.a.e b = new daff.a.e(1024);
    private daff.a.e do = new daff.a.e(65536);
    private long for;
    private long a;
    private int goto = 0;
    private int try = 0;
    private int long;
    private int int;
    private int c;
    private int d;

    public void a(g g2) {
        this.else.if(g2);
    }

    public void a(Object object) {
        this.byte = object;
    }

    public Object char() {
        return this.byte;
    }

    public g[] a() {
        Object[] objectArray = new g[this.else.for()];
        this.else.a(objectArray);
        return objectArray;
    }

    public int e() {
        return this.int;
    }

    public e goto() {
        return this.void;
    }

    public void a(e e2) {
        this.void = e2;
    }

    public void do(m m2) {
        daff.a.e e2 = this.do;
        synchronized (e2) {
            block4: {
                if (this.do.goto() >= 0x100000) break block4;
                this.new.a(m2, this.do);
            }
            Object var3_3 = null;
        }
        if (this.do.goto() > 4096) {
            this.g();
        }
        ++this.c;
    }

    public void if(m m2) {
        daff.a.e e2 = this.do;
        synchronized (e2) {
            block3: {
                if (this.do.goto() >= 0x100000) break block3;
                this.new.a(m2, this.do);
            }
            Object var3_3 = null;
        }
        this.g();
        ++this.c;
    }

    public void a(long l2) {
        if (this.a == 0L) {
            this.a = l2;
        }
        if (this.goto > 0 && l2 - this.a > (long)this.goto) {
            this.else();
            this.a = l2;
        }
        if (this.try > 0 && l2 - this.a > (long)this.try) {
            if (if) {
                String string = "timeOutClose:" + this.try + ";" + this.toString();
                this.a(string);
            }
            this.new();
        }
    }

    public void a(String string) {
        int n2 = 0;
        while (n2 < this.else.for()) {
            g g2 = (g)this.else.if(n2);
            g2.a(this, string);
            ++n2;
        }
    }

    public int try() {
        return this.d;
    }

    public void a(m m2) {
        ++this.long;
        int n2 = 0;
        while (n2 < this.else.for()) {
            g g2 = (g)this.else.if(n2);
            g2.a(this, m2);
            ++n2;
        }
    }

    public void if(g g2) {
        this.else.do(g2);
    }

    public void g() {
        daff.a.e e2 = this.do;
        synchronized (e2) {
            block3: {
                int n2 = this.do.goto();
                if (n2 <= 0) break block3;
                n2 = Math.min(n2, 32768);
                n2 = this.a(this.do.a(), 0, n2);
                this.do.case(n2);
                this.do.int();
                this.d += n2;
            }
            Object var3_3 = null;
        }
    }

    public int for() {
        return this.try;
    }

    public void do(int n2) {
        this.try = n2;
    }

    public abstract int case();

    public abstract int b();

    protected abstract int a(byte[] var1, int var2, int var3);

    public abstract void new();

    public int int() {
        return this.c;
    }

    protected void a(byte[] byArray, int n2, int n3, long l2) {
        Object object;
        this.a = l2;
        this.int += n3;
        if (this.void != null) {
            this.b.a(byArray, n2, n3);
            object = this.void.a(this.b);
            while (object != null) {
                ((m)object).a(this);
                this.a((m)object);
                object = this.void.a(this.b);
            }
            this.b.int();
        }
        if (this.b.if() > this.char) {
            if (if) {
                object = "buffer overflow:" + this.char + ";" + this.toString();
                this.a((String)object);
            }
            daff.a.e e2 = this.do;
            synchronized (e2) {
                this.b.char();
                this.new();
                Object var8_7 = null;
            }
        }
    }

    public long f() {
        return this.for;
    }

    public void if(long l2) {
        this.for = l2;
    }

    public int do() {
        return this.goto;
    }

    public void a(int n2) {
        this.goto = n2;
    }

    public int byte() {
        return this.char;
    }

    public void if(int n2) {
        this.char = n2;
    }

    public abstract String h();

    protected void else() {
        this.if((m)null);
    }

    public void long() {
        this.else.a();
    }

    public l if() {
        return this.new;
    }

    public void a(l l2) {
        this.new = l2;
    }

    public int void() {
        return this.long;
    }

    public abstract byte[] d();

    public abstract boolean c();
}

