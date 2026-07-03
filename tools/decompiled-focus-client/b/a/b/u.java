/*
 * Decompiled with CFR 0.152.
 */
package b.a.b;

import a.b.af;
import a.b.c;
import b.a.b.d;
import b.a.b.q;
import b.a.d.n;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class u
extends d {
    public static final int[] aN = new int[]{-1, -13318080, -15629579, -7864065, -752332, -1186560, -1, -1, -1};
    public static af aK;
    private n aL;
    private String aM;
    private int aO;
    private int aJ = 1500;

    public void do(c c2) {
        if (this.aJ > 0) {
            return;
        }
        if (this.byte.b || this.byte.case() == this || this.a) {
            q.a(c2, this.aM, this.new - this.aO, this.for - 35, aN[this.aL.cs]);
        }
    }

    public int do() {
        return 1;
    }

    public int char() {
        return this.for - 18;
    }

    public void a(long l2) {
        int n2 = this.byte.h.x;
        int n3 = this.byte.h.y;
        this.if = (n2 -= this.try()) > 1 && n2 < 40 && (n3 -= this.char()) > 1 && n3 < 35;
        if (this.aJ > 0) {
            this.aJ = (int)((long)this.aJ - this.byte.for);
        }
    }

    public void if(c c2) {
        if (this.aJ > 0) {
            return;
        }
        int n2 = this.try();
        int n3 = this.char();
        if (this.byte.c == this) {
            c2.a(aK, n2, n3, 0, 444, 40, 36, 2, 32);
        } else {
            c2.a(aK, n2, n3, 0, 444, 40, 36, 0, 0);
        }
    }

    public int else() {
        return 36;
    }

    public n n() {
        return this.aL;
    }

    public void a(n n2) {
        this.aL = n2;
        this.new = this.byte.try(n2.void);
        this.for = this.byte.int(n2.long);
        this.aM = n2.a;
        this.aO = a.b.q.if(this.aM) / 2;
    }

    public int try() {
        return this.new - 20;
    }

    public int for() {
        return 40;
    }
}

