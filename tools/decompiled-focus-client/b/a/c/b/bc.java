/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.a;
import a.b.c;
import a.b.i;
import a.b.s;
import b.a.b.j;
import b.a.b.q;
import b.a.c.b;
import b.a.c.b.a5;
import b.a.c.b.ap;
import b.a.c.b.ba;
import b.a.c.b.e;
import b.a.c.d;
import b.a.d.g;
import b.a.e.r;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class bc
extends s
implements i {
    private b l3;
    private d l5;
    private q l6;
    private boolean[] lZ = new boolean[256];
    private int l4;
    private int l2;
    private String l0 = "";
    private ap l7;
    private ba l1;

    public q dM() {
        return this.l6;
    }

    public void a(q q2) {
        if (this.l6 != null) {
            this.l6.a((s)null);
        }
        this.l6 = q2;
        if (this.l6 != null) {
            this.l6.a(this);
        }
        this.l0 = "";
        this.repaint();
    }

    public bc(b b2, d d2) {
        this.l3 = b2;
        this.l5 = d2;
        this.enableEvents(16L);
        this.enableEvents(32L);
        this.enableEvents(8L);
    }

    public void K(int n2) {
        this.l1.N(n2);
    }

    protected void processMouseEvent(MouseEvent mouseEvent) {
        q q2;
        if (mouseEvent.getID() == 504) {
            this.l4 = mouseEvent.getX();
            this.l2 = mouseEvent.getY();
        }
        if ((q2 = this.l6) != null) {
            this.l5.if(mouseEvent);
        }
        super.processMouseEvent(mouseEvent);
    }

    public void a(c c2) {
        q q2 = this.l6;
        if (q2 != null) {
            q2.do(this.J(18));
            q2.a(c2);
            b.a.b.d d2 = this.l5.c();
            if (d2 instanceof j) {
                this.a(c2, ((j)d2).b());
            }
            if (this.l5.l()) {
                int n2 = this.l3.c().an().getWidth();
                int n3 = this.getWidth() - n2 - 66;
                c2.a(n3, 2, 64, 16, -15855359);
                c2.a("[\u5b89\u5168\u533a\u57df]", n3 + 2, 4, -3738106);
            }
            this.for(c2);
            super.a(c2);
        }
    }

    private void for(c c2) {
        if (this.l0.length() > 0) {
            int n2 = a.b.q.if(this.l0);
            int n3 = this.l3.c().an().getWidth();
            int n4 = this.getWidth() - n3 - n2 - 6;
            c2.a(n4, 0, n2 + 4, 16, -15855359);
            c2.a(this.l0, n4 + 2, 2, -3738106);
        }
    }

    public boolean J(int n2) {
        return this.lZ[n2];
    }

    public void a(r r2) {
        this.l1.if(r2);
        this.l7.bw();
    }

    /*
     * Enabled aggressive block sorting
     */
    protected void processKeyEvent(KeyEvent keyEvent) {
        int n2 = keyEvent.getKeyCode();
        if (n2 >= this.lZ.length) {
            return;
        }
        if (keyEvent.getID() == 401) {
            this.lZ[n2] = true;
            this.l3.c().ab().a(n2, keyEvent.getKeyChar());
            return;
        }
        if (keyEvent.getID() == 402) {
            this.lZ[n2] = false;
            if (this.l6 != null && keyEvent.isControlDown() && n2 == 70) {
                this.l3.e().do();
                return;
            }
            if (this.l6 != null && n2 == 77) {
                this.l3.c().ah().setVisible(!this.l3.c().ah().isVisible());
                return;
            }
            if (keyEvent.getKeyCode() == 67) {
                this.l3.c().ay().setVisible(!this.l3.c().ay().isVisible());
                return;
            }
            if (keyEvent.getKeyCode() == 66) {
                this.l3.c().aD().setVisible(!this.l3.c().aD().isVisible());
                return;
            }
            if (keyEvent.getKeyCode() == 87) {
                this.l3.c().aH().setVisible(!this.l3.c().aH().isVisible());
                return;
            }
            if (keyEvent.getKeyCode() == 83) {
                this.l3.c().aL().setVisible(!this.l3.c().aL().isVisible());
                return;
            }
            if (keyEvent.getKeyCode() == 71) {
                this.l3.c().X().setVisible(!this.l3.c().X().isVisible());
                return;
            }
            if (keyEvent.getKeyCode() == 70) {
                this.l3.c().W().setVisible(!this.l3.c().W().isVisible());
                return;
            }
            if (keyEvent.getKeyCode() == 84) {
                this.l3.c().aF().setVisible(!this.l3.c().aF().isVisible());
                return;
            }
            if (keyEvent.getKeyCode() != 65) return;
            return;
        } else {
            if (keyEvent.getID() != 400) return;
            char c2 = keyEvent.getKeyChar();
            if (c2 == '\n' || c2 == '\r') {
                this.l3.c().ab().dS();
                return;
            }
            if (c2 == '\u001b') {
                if (this.l3.c().Y()) return;
                if (this.l5.b()) return;
                this.l3.c().az().setVisible(true);
                return;
            }
            if (this.l6 == null) return;
            if (c2 != ' ') return;
            this.l5.void();
        }
    }

    protected void processMouseMotionEvent(MouseEvent mouseEvent) {
        this.l4 = mouseEvent.getX();
        this.l2 = mouseEvent.getY();
        q q2 = this.l6;
        if (q2 != null) {
            this.l5.if(mouseEvent);
        }
        super.processMouseMotionEvent(mouseEvent);
    }

    public void a(long l2) {
        q q2 = this.l6;
        if (q2 != null) {
            q2.a(l2);
            q2.do(this.l4 + q2.int(), this.l2 + q2.long());
            this.l5.if(l2);
            this.repaint();
            super.a(l2);
        }
    }

    private void a(c c2, b.a.d.c c3) {
        int n2 = this.getWidth();
        int n3 = n2 / 2 - 50;
        int n4 = 4;
        String string = c3.a;
        int n5 = a.b.q.if(string);
        q.a(c2, string, n2 / 2 - n5 / 2, n4, -1);
        int n6 = c3.Q * 100 / c3.r;
        c2.a(n3, n4 += 14, n6, 14, -65536);
        c2.a(n3 + n6, n4, 100 - n6, 14, -1895825408);
        n5 = e.c(c3.Q) + e.c(c3.r) + 6;
        n3 = n2 / 2 - n5 / 2;
        int n7 = e.int(c2, c3.Q, n3, n4);
        c2.a('/', n7, n4, 0xFFFFFF);
        e.int(c2, c3.r, n7 + 6, n4);
        if (c3.d == 3) {
            n3 = n2 / 2 - 50;
            c2.a("Lv:", n3, n4 += 16, 0xFFFFFF);
            e.int(c2, c3.p, n3 + 19, n4 + 1);
            b.a.d.d d2 = (b.a.d.d)c3;
            c2.a((char)(48 + d2.ab), n3 + 82, n4, 0xFFFFFF);
            c2.a('\u8f6c', n3 + 88, n4, 0xFFFFFF);
        } else if (c3.d == 1) {
            n3 = n2 / 2 - 50;
            c2.a("Lv:", n3, n4 += 16, 0xFFFFFF);
            e.int(c2, c3.p, n3 + 19, n4 + 1);
            g g2 = (g)c3;
            c2.a(b.a.d.g.bV[g2.bN], n3 + 64, n4, 0xFFFFFF);
        }
    }

    public r[] dL() {
        return this.l1.dY();
    }

    public void I(int n2) {
        int n3 = n2;
        int n4 = n3 / 60;
        int n5 = n4 / 60;
        n4 %= 60;
        n3 %= 60;
        this.l0 = "\u5012\u8bb0\u65f6\uff1a";
        if (n5 > 0) {
            this.l0 = this.l0 + String.valueOf(n5) + "\u5c0f\u65f6";
        }
        if (n4 > 0) {
            this.l0 = this.l0 + n4 + "\u5206\u949f";
        }
        this.l0 = this.l0 + n3 + "\u79d2";
    }

    public void setBounds(int n2, int n3, int n4, int n5) {
        super.setBounds(n2, n3, n4, n5);
        q q2 = this.l6;
        if (q2 != null) {
            q2.a(0, 0, n4, n5);
        }
    }

    public void dK() {
        this.l7 = new ap();
        this.l7.setBounds(2, 2, 120, 66);
        this.l7.if(this.l3.for());
        this.add(this.l7);
        this.l1 = new ba(this.l3.for());
        this.l1.setBounds(2, 40, 64, 16);
        this.add(this.l1);
    }

    public void a(a a10, int n2, int n3) {
        a5 a52 = this.l3.c().aD();
        if (a10 != a52) {
            a10.do();
            return;
        }
        a52.dy();
    }

    public boolean isFocusTraversable() {
        return true;
    }
}

