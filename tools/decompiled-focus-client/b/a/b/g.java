/*
 * Decompiled with CFR 0.152.
 */
package b.a.b;

import a.b.af;
import a.b.c;
import b.a.b.d;
import b.a.d.e;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class g
extends d {
    public static af f = null;
    private int h;
    private int g;
    private int c;
    private int i;
    private int b;
    private int goto;
    private int e;
    private int d;
    private int char;
    private int void;
    private long else;
    private long long;

    public g(int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        this.b = n3;
        this.goto = n4;
        this.e = n5;
        this.d = n6;
        this.char = n7;
        this.void = n8;
        this.a(n2, n3, n4, n5, n6);
    }

    public int do() {
        return 2;
    }

    private void a(int n2, int n3, int n4, int n5, int n6) {
        int n7 = b.a.d.e.a(n3 / 40, n4 / 30, n5 / 40, n6 / 30);
        if (n7 == 0) {
            this.h = n6 > n4 ? 0 : (n6 < n4 ? 160 : (n5 > n3 ? 240 : 80));
        } else {
            if (n7 % 2 == 1) {
                double d2 = Math.abs((float)(n6 - n4) * 1.0f / (float)(n5 - n3));
                switch (n7) {
                    case 1: 
                    case 5: {
                        if (d2 > (double)1.8f) {
                            --n7;
                            break;
                        }
                        if (!(d2 < (double)0.3f)) break;
                        ++n7;
                        break;
                    }
                    case 3: 
                    case 7: {
                        if (d2 > (double)1.8f) {
                            n7 = (n7 + 1) % 8;
                            break;
                        }
                        if (!(d2 < (double)0.3f)) break;
                        --n7;
                        break;
                    }
                }
            }
            this.h = n7 * 40;
        }
        this.g = n2 * 20 - 20;
        if (n2 > 1) {
            this.c = 5;
        }
    }

    public int char() {
        return this.for - 10;
    }

    public void a(long l2) {
        if (this.long == 0L) {
            this.new = this.b;
            this.for = this.goto;
        } else if (this.void > 0) {
            this.void = (int)((long)this.void - (l2 - this.long));
            if (this.void <= 0) {
                this.else = l2;
            }
        } else {
            int n2 = (int)(l2 - this.else);
            if (n2 >= this.char) {
                this.new = this.e;
                this.for = this.d;
                this.int = false;
            } else {
                this.new = this.b + (this.e - this.b) * n2 / this.char;
                this.for = this.goto + (this.d - this.goto) * n2 / this.char;
            }
        }
        this.long = l2;
    }

    public void if(c c2) {
        if (this.void <= 0 && f != null) {
            c2.a(f, this.new - 20, this.for - 10, this.h, this.g, 40, 20, this.c, this.i);
        }
    }

    public int else() {
        return 20;
    }

    public int try() {
        return this.new - 20;
    }

    public int for() {
        return 40;
    }
}

