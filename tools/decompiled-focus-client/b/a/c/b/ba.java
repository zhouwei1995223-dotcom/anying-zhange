/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.b;
import a.b.c;
import a.b.s;
import b.a.c.b.at;
import b.a.c.b.e;
import b.a.d.k;
import b.a.e.r;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
class ba
extends s {
    private k mv;
    private r[] mu = new r[8];
    private int mx;
    private r mw;

    ba(k k2) {
        this.mv = k2;
        this.enableEvents(48L);
    }

    public r N(int n2) {
        r r2 = null;
        int n3 = 0;
        while (n3 < this.mx) {
            if (this.mu[n3].if == n2) {
                r2 = this.mu[n3];
                int n4 = n3 + 1;
                while (n4 < this.mx) {
                    this.mu[n4 - 1] = this.mu[n4];
                    ++n4;
                }
                this.mx += -1;
                this.mu[this.mx] = null;
                break;
            }
            ++n3;
        }
        if (r2 != null) {
            r2.do(this.mv);
        }
        this.setSize(this.mx * 16 + this.mx + 1, 18);
        return r2;
    }

    public void a(c c2) {
        if (this.mx <= 0) {
            return;
        }
        c2.a(0, 0, this.getWidth(), 18, -2821389);
        int n2 = 1;
        int n3 = 0;
        while (n3 < this.mx) {
            c2.if(e.a5, n2, 1, (this.mu[n3].jl - 1) * 16, 600, 16, 16);
            c2.do(n2, 1, n2, 17, -16183537);
            n2 += 17;
            ++n3;
        }
    }

    protected void processMouseEvent(MouseEvent mouseEvent) {
        if (mouseEvent.getID() == 504) {
            this.B(mouseEvent.getX(), mouseEvent.getY());
        } else {
            this.dX();
        }
    }

    private r C(int n2, int n3) {
        int n4;
        if ((n4 = --n2 / 17) < this.mx) {
            return this.mu[n4];
        }
        return null;
    }

    public r[] dY() {
        return this.mu;
    }

    public void if(r r2) {
        int n2 = 0;
        while (n2 < this.mu.length) {
            if (this.mu[n2] == null) {
                this.mu[n2] = r2;
                ++this.mx;
                break;
            }
            ++n2;
        }
        r2.for(this.mv);
        this.setSize(this.mx * 16 + this.mx + 1, 18);
    }

    protected void processMouseMotionEvent(MouseEvent mouseEvent) {
        this.B(mouseEvent.getX(), mouseEvent.getY());
    }

    private void B(int n2, int n3) {
        r r2 = this.C(n2, n3);
        if (r2 != this.mw) {
            this.mw = r2;
            at.b().if(r2);
            this.a(null, at.b(), n2, n3);
        }
    }

    private void dX() {
        this.a((Rectangle)null, (b)null, 0, 0);
        this.mw = null;
    }
}

