/*
 * Decompiled with CFR 0.152.
 */
package a.d;

import a.a.a;
import a.d.e;
import a.d.h;
import a.d.m;
import a.d.n;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public abstract class j {
    public static boolean if = false;
    public static final int case = 65536;
    public static final int e = 8092;
    private a else = new a.a.h();
    private Object byte;
    private int char = Integer.MAX_VALUE;
    private e void;
    private m new;
    private a.a.e b = new a.a.e(1024);
    private a.a.e do = new a.a.e(16384);
    private long for;
    private long a;
    private int goto = 0;
    private int try = 0;
    private int long;
    private int int;
    private int c;
    private int d;

    public void a(h h2) {
        this.else.if(h2);
    }

    public void a(Object object) {
        this.byte = object;
    }

    public Object char() {
        return this.byte;
    }

    public h[] a() {
        Object[] objectArray = new h[this.else.for()];
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

    public void do(n n2) {
        a.a.e e2 = this.do;
        synchronized (e2) {
            this.new.a(n2, this.do);
            Object var3_3 = null;
        }
        if (this.do.goto() > 4000) {
            this.g();
        }
        ++this.c;
    }

    public void if(n n2) {
        a.a.e e2 = this.do;
        synchronized (e2) {
            this.new.a(n2, this.do);
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
            h h2 = (h)this.else.if(n2);
            h2.a(this, string);
            ++n2;
        }
    }

    public int try() {
        return this.d;
    }

    public void a(n n2) {
        ++this.long;
        int n3 = 0;
        while (n3 < this.else.for()) {
            h h2 = (h)this.else.if(n3);
            h2.a(this, n2);
            ++n3;
        }
    }

    public void if(h h2) {
        this.else.do(h2);
    }

    public void g() {
        a.a.e e2 = this.do;
        synchronized (e2) {
            block4: {
                int n2 = this.do.goto();
                if (n2 > 0) {
                    n2 = Math.min(n2, 8092);
                    n2 = this.a(this.do.a(), 0, n2);
                    this.do.case(n2);
                    this.do.int();
                    this.d += n2;
                }
                if (this.do.goto() < 65536) break block4;
                this.do.char();
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
                ((n)object).a(this);
                this.a((n)object);
                object = this.void.a(this.b);
            }
            this.b.int();
        }
        if (this.b.if() > this.char) {
            if (if) {
                object = "buffer overflow:" + this.char + ";" + this.toString();
                this.a((String)object);
            }
            a.a.e e2 = this.do;
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
        this.if((n)null);
    }

    public void long() {
        this.else.a();
    }

    public m if() {
        return this.new;
    }

    public void a(m m2) {
        this.new = m2;
    }

    public int void() {
        return this.long;
    }

    public abstract byte[] d();

    public abstract boolean c();
}

