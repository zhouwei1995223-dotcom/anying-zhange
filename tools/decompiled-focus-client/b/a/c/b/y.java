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
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

class y
extends s {
    private k cD;
    private String cE = "";

    public void bc() {
        int n2 = 0;
        if (this.cD.az > 0) {
            n2 += 24;
        }
        if (this.cD.bq > 0) {
            n2 += 24;
        }
        if (this.cD.bh > 0) {
            n2 += 24;
        }
        if (n2 <= 0) {
            this.setSize(0, 0);
        } else {
            this.setSize(n2 + 2, 26);
        }
        this.repaint();
    }

    public y(k k2) {
        this.cD = k2;
        this.enableEvents(16L);
    }

    public void a(c c2) {
        c2.if(0, 0, this.getWidth(), this.getHeight(), -16360660);
        int n2 = 1;
        if (this.cD.az > 0) {
            c2.if(e.a5, n2, 1, 648, 420, 24, 24);
            n2 += 24;
        }
        if (this.cD.bq > 0) {
            c2.if(e.a5, n2, 1, 672, 420, 24, 24);
            n2 += 24;
        }
        if (this.cD.bh > 0) {
            c2.if(e.a5, n2, 1, 696, 420, 24, 24);
            n2 += 24;
        }
    }

    protected void processMouseEvent(MouseEvent mouseEvent) {
        if (mouseEvent.getID() == 504) {
            at at2 = at.b();
            at2.d();
            this.a(null, at2, mouseEvent.getX(), mouseEvent.getY());
        } else if (mouseEvent.getID() == 505) {
            this.a((Rectangle)null, (b)null, 0, 0);
        }
        super.processMouseEvent(mouseEvent);
    }
}

