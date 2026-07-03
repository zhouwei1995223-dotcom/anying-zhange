/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.a.h;
import a.b.af;
import a.b.c;
import a.b.s;
import b.a.b.p;
import b.a.c.b;
import b.a.c.b.ap;
import b.a.c.b.bc;
import b.a.c.b.e;
import b.a.c.d;
import b.a.d.k;
import java.awt.event.MouseEvent;

public class ad
extends s {
    private b cK;
    private af cL;
    private int cO = 255;
    private int cN;
    private int cM;

    public ad(b b2) {
        this.cK = b2;
        this.enableEvents(16L);
    }

    public void a(c c2) {
        int n2;
        if (this.cL == null || this.cO <= 0) {
            return;
        }
        d d2 = this.cK.e();
        if (d2 == null) {
            return;
        }
        k k2 = this.cK.for();
        int n3 = this.getWidth() - 2;
        int n4 = this.getHeight() - 2;
        int n5 = this.cL.int();
        int n6 = this.cL.try();
        int n7 = k2.void * 2;
        int n8 = k2.long * 3 / 2;
        int n9 = n3 / 2;
        int n10 = n4 / 2;
        this.cN = 0;
        this.cM = 0;
        if (n7 > n9) {
            this.cN = n7 - n9;
            if (this.cN > n5 - n3) {
                this.cN = n5 - n3;
                n7 -= n5 - n3;
            } else {
                n7 = n9;
            }
        }
        if (n8 > n10) {
            this.cM = n8 - n10;
            if (this.cM > n6 - n4) {
                this.cM = n6 - n4;
                n8 -= n6 - n4;
            } else {
                n8 = n10;
            }
        }
        c2.if(0, 0, n3 + 2, n4 + 2, -16777216);
        c2.a(this.cL, 1, 1, this.cN, this.cM, n3, n4, 1, this.cO);
        h h2 = d2.d();
        int n11 = h2.for();
        int n12 = 0;
        while (n12 < n11) {
            p p2 = (p)h2.if(n12);
            if (!this.cK.c().ae().k(p2.j().if)) {
                c2.a(p2.case() / 20 - this.cN - 1, p2.a() / 20 - this.cM - 1, 3, 3, -1);
            }
            ++n12;
        }
        ap[] apArray = this.cK.c().ae().bk();
        int n13 = 0;
        while (n13 < apArray.length) {
            if (apArray[n13] != null) {
                b.a.d.d d3 = apArray[n13].bu();
                if (d3.ae > 0) {
                    n2 = d3.void * 2 - this.cN - 1;
                    int n14 = d3.long * 3 / 2 - this.cM - 1;
                    if (n2 > 1 && n14 > 1 && n2 <= n3 && n14 <= n4) {
                        c2.a(n2, n14, 3, 3, -16711936);
                    }
                }
            }
            ++n13;
        }
        h h3 = d2.f();
        n11 = h3.for();
        int n15 = 0;
        while (n15 < n11) {
            b.a.b.e e2 = (b.a.b.e)h3.if(n15);
            c2.a(e2.case() / 20 - this.cN - 1, e2.a() / 20 - this.cM - 1, 3, 3, -65536);
            ++n15;
        }
        h h4 = d2.j();
        n11 = h4.for();
        n2 = 0;
        while (n2 < n11) {
            b.a.b.b b2 = (b.a.b.b)h4.if(n2);
            if (b2.s().ci) {
                c2.a(b2.case() / 20 - this.cN - 1, b2.a() / 20 - this.cM - 1, 3, 3, -16307979);
            }
            ++n2;
        }
        c2.if(e.aZ, n7 - 5, n8 - 5, 0, 0, 11, 11);
    }

    protected void processMouseEvent(MouseEvent mouseEvent) {
        if (mouseEvent.getID() == 501) {
            int n2 = mouseEvent.getX() - 1;
            int n3 = mouseEvent.getY() - 1;
            n2 += this.cN;
            n3 += this.cM;
            n3 = n3 * 2 / 3;
            this.cK.e().char(n2 /= 2, n3);
        }
        super.processMouseEvent(mouseEvent);
    }

    public int bj() {
        return this.cO;
    }

    public void i(int n2) {
        this.cO = n2;
    }

    public void bh() {
        this.cO -= 51;
        if (this.cO < 0) {
            this.cO = 255;
            this.enableEvents(16L);
        } else if (this.cO < 8) {
            this.disableEvents(16L);
        }
    }

    public af bi() {
        return this.cL;
    }

    public void a(af af2) {
        this.cL = af2;
        if (af2 == null) {
            this.setSize(0, 0);
        } else {
            int n2 = 120;
            int n3 = 90;
            int n4 = this.cL.int();
            int n5 = this.cL.try();
            if (n4 < n2) {
                n2 = n4;
                n3 = n2 * 3 / 4;
            }
            if (n5 < n3) {
                n3 = n5;
            }
            bc bc2 = this.cK.j();
            this.setBounds(bc2.getWidth() + bc2.getX() - n2 - 2, bc2.getY(), n2 + 2, n3 + 2);
        }
    }
}

