/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.a.h;
import a.b.s;
import b.a.c.b;
import b.a.c.b.a0;
import b.a.c.b.a1;
import b.a.c.b.n;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class bd
extends s {
    private b my;
    private a1[] mA = new a1[4];
    private a1[] mC = new a1[8];
    private h mz = new h(8);
    private a0 mB;

    public void int(String string, int n2, int n3) {
        a1 a12 = new a1(string, n2, n3);
        this.a(a12);
    }

    public void a(a1 a12) {
        a12.r(1);
        this.a(a12, this.mC);
    }

    private void a(a1 a12, a1[] a1Array) {
        int n2 = 0;
        while (n2 < a1Array.length) {
            if (a1Array[n2] == null) break;
            ++n2;
        }
        if (n2 >= a1Array.length) {
            this.a(a1Array);
            n2 = a1Array.length - 1;
        }
        if (a1Array == this.mC) {
            a12.setLocation(this.getWidth() + 4, this.getHeight() - n2 * 20 - 4 - 20);
            a12.try(4, a12.getY());
        } else {
            a12.setLocation(this.getWidth() / 2 - a12.getWidth() / 2, this.getHeight() / 2);
            a12.try(a12.getX(), n2 * 20 + 4);
        }
        a1Array[n2] = a12;
        this.add(a12);
    }

    public void dZ() {
        int n2 = 0;
        while (n2 < this.mC.length) {
            if (this.mC[n2] == null) break;
            this.mC[n2].q(0);
            ++n2;
        }
    }

    public a0 d1() {
        return this.mB;
    }

    public bd(b b2) {
        this.my = b2;
    }

    public void x(String string) {
        this.for(string, -1358954496, -1);
    }

    public void for(String string, int n2, int n3) {
        a1 a12 = new a1(string, n2, n3);
        this.if(a12);
    }

    public void if(a1 a12) {
        this.a(a12, this.mA);
    }

    public void a(long l2) {
        int n2 = 0;
        while (n2 < this.mC.length) {
            if (this.mC[n2] == null) break;
            this.mC[n2].a(l2);
            if (!this.mC[n2].bO()) {
                this.a(this.mC);
                break;
            }
            ++n2;
        }
        n2 = 0;
        while (n2 < this.mA.length) {
            if (this.mA[n2] == null) break;
            this.mA[n2].a(l2);
            if (!this.mA[n2].bO()) {
                this.a(this.mA);
                break;
            }
            ++n2;
        }
        n2 = this.mz.for();
        int n3 = 0;
        while (n3 < n2) {
            n n4 = (n)this.mz.if(n3);
            n4.a(l2);
            if (!n4.a9()) {
                this.mz.a(n3);
                this.remove(n4);
                --n2;
                int n5 = 0;
                while (n5 < n2) {
                    n4 = (n)this.mz.if(n5);
                    n4.setBounds(this.getWidth() - 54 - n5 * 28, this.getHeight() - 27, 24, 24);
                    ++n5;
                }
                break;
            }
            ++n3;
        }
        this.mB.a(l2);
    }

    public void a(a1[] a1Array) {
        this.remove(a1Array[0]);
        int n2 = 1;
        int n3 = 20;
        if (a1Array == this.mA) {
            n3 = -20;
        }
        while (n2 < a1Array.length) {
            if (a1Array[n2] == null) break;
            a1Array[n2].try(a1Array[n2].bN(), a1Array[n2].bM() + n3);
            a1Array[n2].setLocation(a1Array[n2].getX(), a1Array[n2].getY() + n3);
            a1Array[n2 - 1] = a1Array[n2];
            ++n2;
        }
        a1Array[n2 - 1] = null;
    }

    public void d0() {
        int n2 = 0;
        while (n2 < this.mA.length) {
            if (this.mA[n2] == null) break;
            this.mA[n2].q(0);
            ++n2;
        }
    }

    public void d2() {
        this.mB = new a0();
        this.mB.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.mB.bJ();
        this.add(this.mB);
    }

    public void a(n n2) {
        n2.setBounds(this.getWidth() - 54 - this.mz.for() * 28, this.getHeight() - 27, 24, 24);
        this.add(n2);
        this.mz.if(n2);
    }

    public void w(String string) {
        this.int(string, -1358954496, -1);
    }
}

