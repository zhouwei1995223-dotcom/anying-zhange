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
public class k
extends d {
    public static final int ah = 1;
    public static final int aq = 2;
    public static final int ai = 3;
    private int an;
    private int al;
    private long ak;
    private long am;
    private int ap;
    private int ao;
    private int aj;

    public k(int n2, int n3, int n4, int n5) {
        this.an = n2--;
        this.new = n3;
        this.for = n4;
        this.al = n5;
        this.ap = n2 % 4 * 62;
        this.ao = 61 + n2 / 4 * 27;
        this.aj = 255;
    }

    public int do() {
        return 2;
    }

    public int char() {
        return this.for - 20;
    }

    public void a(long l2) {
        if (this.am != 0L) {
            if (this.al > 0) {
                this.al = (int)((long)this.al - (l2 - this.am));
                if (this.al <= 0) {
                    this.ak = l2;
                }
            } else {
                this.for -= 4;
                this.aj -= 4;
                if (this.aj < 8) {
                    this.int = false;
                }
            }
        }
        this.am = l2;
    }

    public void if(c c2) {
        if (this.al <= 0 && j.B != null) {
            c2.do(j.B, this.new - 22, this.for - 11, this.ap, this.ao, 42, 20, this.aj);
        }
    }

    public int else() {
        return 20;
    }

    public int try() {
        return this.new - 21;
    }

    public int for() {
        return 42;
    }
}

