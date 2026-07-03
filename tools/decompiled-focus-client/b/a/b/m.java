/*
 * Decompiled with CFR 0.152.
 */
package b.a.b;

import a.b.c;
import b.a.b.d;
import b.a.b.j;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class m
extends d {
    private int aA;
    private long ax;
    private long ay;
    private int az;

    public m(int n2, int n3, int n4) {
        this.new = n2;
        this.for = n3;
        this.aA = n4;
        this.az = 255;
    }

    public int do() {
        return 2;
    }

    public int char() {
        return this.for - 13;
    }

    public void a(long l2) {
        if (this.ay != 0L) {
            if (this.aA > 0) {
                this.aA = (int)((long)this.aA - (l2 - this.ay));
                if (this.aA <= 0) {
                    this.ax = l2;
                }
            } else {
                this.for -= 2;
                this.az -= 3;
                if (this.az < 8) {
                    this.int = false;
                }
            }
        }
        this.ay = l2;
    }

    public void if(c c2) {
        if (this.aA <= 0) {
            c2.do(j.B, this.new - 12, this.for - 13, 9, 43, 25, 13, this.az);
        }
    }

    public int else() {
        return 13;
    }

    public int try() {
        return this.new - 12;
    }

    public int for() {
        return 25;
    }
}

