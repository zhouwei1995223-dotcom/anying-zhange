/*
 * Decompiled with CFR 0.152.
 */
package b.a.b;

import a.b.af;
import a.b.c;
import b.a.b.n;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class a {
    public static af new = null;
    public static int[] char = new int[]{0xFFFFFF};
    private static final int void = 200;
    private n int;
    private int else;
    private int for;
    private int long;
    private int goto;
    private int case;
    private int try;
    private a[] b = new a[200];
    private int[] if;
    private int a;
    private float do;
    private long byte;

    public int new() {
        return this.long;
    }

    public int a() {
        return this.a;
    }

    public a(n n2) {
        this.int = n2;
        this.if = char;
    }

    public int if() {
        return this.else;
    }

    public void a(int n2) {
        this.else = n2;
    }

    public void a(long l2) {
        if (this.byte == 0L) {
            this.byte = l2;
            return;
        }
        int n2 = (int)(l2 - this.byte);
        a a10 = null;
        int n3 = 0;
        while (n3 < this.a) {
            a10 = this.b[n3];
            a10.new -= n2;
            if (a10.new <= 0) {
                a a11 = this.b[n3];
                this.b[n3] = this.b[this.a += -1];
                this.b[this.a] = a11;
                continue;
            }
            a10.byte += a10.void * n2;
            a10.goto += a10.else * n2;
            a10.try += a10.byte * n2;
            ++n3;
        }
        if (this.else > 0) {
            this.else -= n2;
            float f2 = this.int.l * (float)n2 + this.do;
            int n4 = (int)f2;
            this.do = f2 - (float)n4;
            int n5 = 0;
            while (n5 < n4) {
                if (this.a >= 200) break;
                this.int();
                ++n5;
            }
        }
        this.case = this.long;
        this.try = this.goto;
        this.byte = l2;
    }

    public void do() {
    }

    public int for() {
        return this.goto;
    }

    public void a(c c2) {
        int n2 = 0;
        while (n2 < this.a) {
            this.b[n2].a(c2);
            ++n2;
        }
    }

    public void a(int n2, int n3) {
        this.long = n2;
        this.goto = n3;
    }

    public void a(int[] nArray) {
        this.if = nArray;
    }

    private void int() {
        a a10 = this.b[this.a];
        if (a10 == null) {
            a10 = new a();
        }
        a10.do = (int)(Math.random() * 4.0);
        a10.char = (int)(Math.random() * 4.0);
        a10.int = this.if[(int)(Math.random() * (double)this.if.length)];
        float f2 = (float)Math.random();
        a10.new = (int)((float)this.int.h + f2 * (float)(this.int.g - this.int.h));
        a10.goto = (int)((float)this.case + (float)(this.long - this.case) * f2);
        a10.try = (int)((float)this.try + (float)(this.goto - this.try) * f2);
        a10.goto <<= 16;
        a10.try <<= 16;
        float f3 = (float)((double)this.int.f - 1.5707963267948966 + Math.random() * (double)this.int.j - (double)(this.int.j / 2.0f));
        if (this.int.e) {
            f3 += 1.5707964f;
        }
        int n2 = (int)((float)this.int.long + f2 * (float)(this.int.i - this.int.long));
        a10.else = (int)(Math.cos(f3) * (double)n2);
        a10.byte = (int)(Math.sin(f3) * (double)n2);
        a10.void = (int)((float)this.int.new + f2 * (float)(this.int.if - this.int.new));
        this.b[this.a++] = a10;
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    public static class a {
        int new;
        int do;
        int char;
        int goto;
        int try;
        int else;
        int byte;
        int void;
        int for;
        int c;
        int b;
        int case;
        int a;
        int long;
        int int;
        int if;

        void a(c c2) {
            int n2 = this.do * 6 + 18;
            c2.a(new, (this.goto >> 16) - (n2 >> 1), (this.try >> 16) - (n2 >> 1), this.char * n2, 54 + this.do * 18 + (this.do - 1) * 6, n2, n2, 6, this.int);
        }
    }
}

