/*
 * Decompiled with CFR 0.152.
 */
package b.a.b;

import a.b.af;
import a.b.c;
import b.a.b.d;
import b.a.b.q;
import b.a.d.m;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class t
extends d {
    public static af aG = null;
    private m aE;
    private int aH;
    private long aF;
    private int aI;

    public void do(c c2) {
        if (this.byte.b || this.byte.case() == this || this.a) {
            q.a(c2, this.aE.a, this.new - this.aH, this.for - 70, 0xFFFFFF);
        }
    }

    public int do() {
        return 1;
    }

    public int char() {
        return this.for - 47;
    }

    public void a(c c2) {
    }

    public void a(long l2) {
        if (l2 - this.aF > 100L) {
            this.aF = l2;
            this.aI = (this.aI + 1) % 13;
        }
        int n2 = this.byte.h.x - this.new;
        int n3 = this.byte.h.y - this.for;
        this.if = n2 > -30 && n2 < 30 && n3 > -30 && n3 < 20;
    }

    public void if(c c2) {
        int n2 = this.try();
        int n3 = this.char();
        if (aG != null) {
            c2.a(aG, n2, n3, this.aI * 87, 0, 87, 73, 5, 0);
        }
    }

    public m m() {
        return this.aE;
    }

    public int else() {
        return 73;
    }

    public void a(m m2) {
        this.aE = m2;
        this.new = this.byte.try(m2.void);
        this.for = this.byte.int(m2.long) - 1;
        this.aH = a.b.q.if(m2.a) / 2;
    }

    public int try() {
        return this.new - 44;
    }

    public int for() {
        return 87;
    }
}

