/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.s;
import b.a.c.b.e;
import java.awt.event.MouseEvent;

class g
extends s {
    private boolean bA;
    private boolean bB;

    public g() {
        this.enableEvents(16L);
    }

    public g(int n2, int n3, int n4, int n5) {
        this.enableEvents(16L);
        this.setBounds(n2, n3, n4, n5);
    }

    protected void processMouseEvent(MouseEvent mouseEvent) {
        switch (mouseEvent.getID()) {
            case 504: {
                this.bA = true;
                this.repaint();
                break;
            }
            case 505: {
                this.bA = false;
                this.repaint();
                break;
            }
            case 501: {
                this.bB = true;
                this.repaint();
                break;
            }
            case 502: {
                this.bB = false;
                this.repaint();
                if (!this.contains(mouseEvent.getX(), mouseEvent.getY())) break;
                this.getParent().setVisible(false);
            }
        }
    }

    public void a(c c2) {
        if (this.bB) {
            c2.if(e.aZ, 0, 0, 270, 98, 15, 15);
        } else if (this.bA) {
            c2.if(e.aZ, 0, 0, 255, 98, 15, 15);
        } else {
            c2.if(e.aZ, 0, 0, 240, 98, 15, 15);
        }
    }
}

