/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.z;
import b.a.c.b;
import b.a.c.b.a5;
import b.a.c.b.al;
import b.a.c.b.at;
import b.a.c.b.e;
import b.a.c.b.g;
import b.a.c.b.i;
import b.a.d.k;
import b.a.e.f;
import b.a.e.j;
import b.a.e.t;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class a
extends z
implements a.b.a,
a.b.i,
ActionListener {
    private b lS;
    private i lT;
    private f[] lR = new f[20];
    private String[] lX = new String[20];
    private int lW;
    private at lY;
    private int lV;
    private int lU = -1;

    private void dI() {
        this.a((Rectangle)null, (a.b.b)null, 0, 0);
    }

    public a(b b2) {
        this.lS = b2;
        this.char(true);
        this.setVisible(false);
    }

    public void a() {
    }

    public void a(f f2, int n2, int n3) {
        k k2 = this.lS.for();
        f2.eN += n2;
        k2.K -= n3;
        int n4 = k2.do();
        long l2 = System.currentTimeMillis();
        int n5 = n4 + f2.eI;
        int n6 = 0;
        while (n6 < this.lW) {
            if (this.lR[n6] != f2 && this.lR[n6].eU == 24) {
                this.lR[n6].eU = 0;
                this.lR[n6].eu = l2;
                this.lR[n6].eL = n5;
            }
            ++n6;
        }
        f2.eU = 0;
        f2.eu = l2;
        f2.eL = n4 + f2.eF;
        if (f2.eN >= f2.ev && n2 > 0) {
            this.lS.goto().w("\u4f60\u7684\u6280\u80fd<" + f2.a + ">\u53ef\u4ee5\u5347\u7ea7\u4e86");
        }
    }

    public void a(c c2) {
        e.a(c2, "\u6280\u80fd", this.getWidth(), this.getHeight());
        int n2 = 6;
        int n3 = 32;
        int n4 = 0;
        while (n4 < this.lW) {
            e.a(c2, this.lR[n4], n2, n3);
            c2.a(this.lX[n4], n2 + 26, n3 + 6, -1);
            n3 += 26;
            ++n4;
        }
        super.a(c2);
    }

    protected void processMouseEvent(MouseEvent mouseEvent) {
        int n2 = mouseEvent.getX();
        int n3 = mouseEvent.getY();
        if (n3 < 30 || n3 > this.getHeight() - 26) {
            super.processMouseEvent(mouseEvent);
            return;
        }
        if (mouseEvent.getID() == 501 && this.lV >= 0) {
            this.lT.a(this.lR[this.lV]);
            this.a(this.lT, this, n2, n3);
        }
        if (mouseEvent.getID() != 504) {
            this.dI();
        }
    }

    public Object if() {
        return this.lR[this.lV];
    }

    public void if(long l2) {
        boolean bl = false;
        int n2 = 0;
        while (n2 < this.lW) {
            if (this.lR[n2].eU < 24) {
                int n3 = (int)(l2 - this.lR[n2].eu);
                if (n3 < this.lR[n2].eL) {
                    this.lR[n2].eU = n3 * 24 / this.lR[n2].eL;
                    bl = true;
                } else {
                    this.lR[n2].eU = 24;
                }
            }
            ++n2;
        }
        if (bl) {
            this.lS.c().ab().dV();
        }
    }

    public void do() {
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.startsWith("upgrade:")) {
            int n2 = string.charAt(string.length() - 1) - 48;
            f f2 = this.lR[n2];
            if (f2.eN < f2.ev) {
                this.lS.new().if("\u6280\u80fd\u7684\u7ecf\u9a8c\u8fd8\u672a\u8fbe\u5230\u5347\u7ea7\u9700\u6c42", -1);
            } else if (f2.eP == 0) {
                this.lS.new().if("\u65e0\u6cd5\u518d\u5347\u7ea7\u4e86", -1);
            } else {
                this.lS.byte().R(f2.if);
            }
        }
    }

    protected void processMouseMotionEvent(MouseEvent mouseEvent) {
        if (mouseEvent.getID() == 503) {
            this.lV = this.x(mouseEvent.getX(), mouseEvent.getY());
            if (this.lU != this.lV) {
                if (this.lV >= 0) {
                    this.y(mouseEvent.getX(), mouseEvent.getY());
                } else {
                    this.dI();
                }
                this.lU = this.lV;
            }
        } else {
            super.processMouseMotionEvent(mouseEvent);
        }
    }

    public void a(f f2) {
        int n2 = 0;
        while (n2 < this.lW) {
            if (this.lR[n2].if == f2.if) {
                this.lX[n2] = f2.a + " \u7b49\u7ea7\uff1a" + f2.et;
                this.lS.c().ab().dR();
                return;
            }
            ++n2;
        }
        this.lR[this.lW] = f2;
        this.lX[this.lW] = f2.a + " \u7b49\u7ea7\uff1a" + f2.et;
        al al2 = new al();
        al2.char("upgrade:" + this.lW);
        al2.try(this);
        al2.else("\u5347\u7ea7");
        al2.m(2);
        al2.setBounds(this.getWidth() - 56, 32 + this.lW * 26 + 3, 44, 19);
        this.add(al2);
        ++this.lW;
        if (this.isVisible()) {
            this.repaint();
        }
    }

    public void a(int n2, f f2) {
        int n3 = 0;
        while (n3 < this.lR.length) {
            if (this.lR[n3].if / 100 == n2 / 100) {
                this.lS.c().ab().A(this.lR[n3].if, f2.if);
                this.lR[n3].do(f2);
                this.lX[n3] = this.lR[n3].a + " \u7b49\u7ea7\uff1a" + this.lR[n3].et;
                break;
            }
            ++n3;
        }
        if (this.isVisible()) {
            this.repaint();
        }
    }

    private void y(int n2, int n3) {
        this.lY.a(this.lR[this.lV], true);
        this.a(null, this.lY, n2, n3);
    }

    public void dJ() {
        int n2 = 204;
        int n3 = 341;
        this.setBounds(n2, 40, n2, n3);
        g g2 = new g();
        g2.setBounds(this.getWidth() - 23, 7, 15, 15);
        this.add(g2);
        k k2 = this.lS.for();
        int n4 = k2.aw.fj.for();
        int n5 = 0;
        while (n5 < n4) {
            f f2 = (f)k2.aw.fj.if(n5);
            this.a(f2);
            ++n5;
        }
        this.lT = new i();
        this.lY = at.b();
    }

    public void a(a.b.a a10, int n2, int n3) {
        a5 a52 = this.lS.c().aD();
        if (a10 != a52) {
            a10.do();
            return;
        }
        Point point = e.for(this);
        int n4 = this.x(n2 -= point.x, n3 -= point.y);
        if (n4 < 0 || n4 >= this.lW) {
            return;
        }
        j j2 = (j)a10.if();
        if (j2.fW == 5) {
            t t2 = (t)j2;
            if (t2.hg == 16) {
                if (this.lR[n4].eN >= this.lR[n4].ev) {
                    this.lS.new().if("\u8be5\u6280\u80fd\u7684\u7ecf\u9a8c\u5df2\u7ecf\u5230\u8fbe\u6700\u5927\u503c\uff0c\u4e0d\u9700\u8981\u518d\u52a0\u6280\u80fd\u7ecf\u9a8c\u77f3\u4e86", -1);
                } else {
                    a52.G(this.lR[n4].if);
                }
            }
        }
    }

    private int x(int n2, int n3) {
        if (n2 > 6 && n2 < this.getWidth() - 10) {
            int n4 = 32;
            int n5 = 0;
            while (n5 < this.lW) {
                if (n3 > n4 && n3 < n4 + 24) {
                    return n5;
                }
                ++n5;
                n4 += 26;
            }
        }
        return -1;
    }
}

