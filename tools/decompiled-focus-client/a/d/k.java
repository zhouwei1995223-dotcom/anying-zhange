/*
 * Decompiled with CFR 0.152.
 */
package a.d;

import a.a.b;
import a.a.e;
import a.d.a;
import a.d.i;
import a.d.j;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class k
extends j
implements Runnable {
    private i h;
    private e f = null;
    private a g;

    public boolean c() {
        return this.h.for();
    }

    protected int a(byte[] byArray, int n2, int n3) {
        block4: {
            block3: {
                if (this.f == null) break block3;
                e e2 = this.f;
                synchronized (e2) {
                    this.f.a(byArray, n2, n3);
                    this.g.int(n3);
                    Object var5_5 = null;
                    break block4;
                }
            }
            this.h.a(byArray, n2, n3);
        }
        return n3;
    }

    public void new() {
        this.h.do();
    }

    public String toString() {
        return "SimpleConnection(" + this.h.toString() + ")";
    }

    public k(i i2) {
        this.h = i2;
    }

    public k(i i2, a a10) {
        this.h = i2;
        this.g = a10;
        this.f = new e(10240);
    }

    public String h() {
        if (this.h != null) {
            return this.h.byte();
        }
        return null;
    }

    public i i() {
        return this.h;
    }

    public boolean j() {
        return this.h.else();
    }

    public void run() {
        byte[] byArray = new byte[1024];
        int n2 = 0;
        while (this.c()) {
            long l2 = System.currentTimeMillis();
            this.a(l2);
            if (this.h.else()) {
                n2 = this.h.a(byArray);
                this.a(byArray, 0, n2, l2);
                if (this.g != null) {
                    this.g.a(n2);
                }
            }
            e e2 = this.f;
            synchronized (e2) {
                block8: {
                    n2 = this.f.if();
                    if (n2 <= 0) break block8;
                    if (n2 > byArray.length) {
                        byArray = new byte[n2];
                    }
                    System.arraycopy(this.f.a(), this.f.d(), byArray, 0, n2);
                    this.f.char();
                }
                Object var6_5 = null;
            }
            if (n2 > 0) {
                this.h.a(byArray, 0, n2);
            }
            b.a(5);
        }
    }

    public byte[] d() {
        if (this.h != null) {
            return this.h.if();
        }
        return null;
    }

    public int case() {
        if (this.h != null) {
            return this.h.char();
        }
        return -1;
    }

    public int b() {
        if (this.h != null) {
            return this.h.goto();
        }
        return -1;
    }
}

