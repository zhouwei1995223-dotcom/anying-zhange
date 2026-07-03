/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.a;
import a.b.c;
import a.b.i;
import a.b.n;
import a.b.z;
import b.a.c.b;
import b.a.c.b.al;
import b.a.c.b.at;
import b.a.c.b.bf;
import b.a.c.b.e;
import b.a.c.b.g;
import b.a.d.k;
import b.a.e.d;
import b.a.e.j;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class a3
extends z
implements ActionListener,
i {
    private b kx;
    private String kD = "\u793c\u54c1\u804a\u5929\u8f93\u5165";
    private n kz;
    private d ky;
    private boolean kC;
    private bf[] kA = new bf[3];
    private bf[] kB = new bf[3];

    public a3(b b2) {
        this.kx = b2;
        this.char(true);
        this.setVisible(false);
    }

    public void a(c c2) {
        e.a(c2, this.kD, this.getWidth(), this.getHeight());
        c2.a("\u9053\u5177\uff1a", 10, 44, -1);
        e.a(c2, 46, 36);
        if (this.ky != null) {
            e.a(c2, this.ky, 48, 37);
        }
        c2.a("\u540d\u5b57\uff1a", this.kz.getX() - 36, this.kz.getY() + 3, -1);
        c2.if(this.kz.getX() - 1, this.kz.getY() - 1, this.kz.getWidth() + 2, this.kz.getHeight() + 2, -9944012);
        c2.do(4, 66, this.getWidth() - 4, 66, -9944012);
        c2.do(this.getWidth() >> 1, 66, this.getWidth() >> 1, this.getHeight() - 30, -9944012);
        super.a(c2);
    }

    protected void processMouseMotionEvent(MouseEvent mouseEvent) {
        if (mouseEvent.getID() == 503) {
            int n2 = mouseEvent.getX();
            int n3 = mouseEvent.getY();
            if (n2 > 48 && n2 < 72 && n3 > 37 && n3 < 61 && this.ky != null) {
                at at2 = at.b();
                if (!this.kC) {
                    at2.a(this.ky, false, false, 0, 0, false);
                    this.a(null, at2, n2, n3);
                    this.kC = true;
                }
            } else {
                this.kC = false;
                this.a((Rectangle)null, (a.b.b)null, 0, 0);
            }
        } else {
            super.processMouseMotionEvent(mouseEvent);
        }
    }

    public void actionPerformed(ActionEvent actionEvent) {
        block15: {
            String string;
            block17: {
                block16: {
                    block14: {
                        string = actionEvent.getActionCommand();
                        k k2 = this.kx.for();
                        if (!string.equals("ok")) break block14;
                        if (this.kz.D().length() == 0) {
                            this.kx.new().if("\u8bf7\u8f93\u5165\u804a\u5929\u5bf9\u8c61\u7684\u540d\u5b57", -65536);
                        } else if (this.ky == null) {
                            this.kx.new().if("\u8bf7\u653e\u5165\u4f60\u8981\u4f7f\u7528\u7684\u804a\u5929\u793c\u54c1\u9053\u5177", -65536);
                        } else if (k2.bA.f(this.ky.if) < 0) {
                            this.kx.new().if("\u4f60\u7684\u80cc\u5305\u4e2d\u5df2\u7ecf\u6ca1\u6709\u8fd9\u4e2a\u9053\u5177\u4e86\uff1a" + this.ky.a, -65536);
                        } else {
                            int n2 = 0;
                            int n3 = 0;
                            if (this.kA[1].d6()) {
                                n2 = 1;
                            } else if (this.kA[2].d6()) {
                                n2 = 2;
                            }
                            if (this.kB[1].d6()) {
                                n3 = 1;
                            } else if (this.kB[2].d6()) {
                                n3 = 2;
                            }
                            this.kx.byte().a(this.ky.if, this.kz.D(), n2, n3);
                            this.setVisible(false);
                            this.kx.j().requestFocus();
                        }
                        break block15;
                    }
                    if (!string.equals("cancel")) break block16;
                    this.kx.j().requestFocus();
                    this.setVisible(false);
                    break block15;
                }
                if (!string.equals("textStyle")) break block17;
                int n4 = 0;
                while (n4 < this.kA.length) {
                    this.kA[n4].else(this.kA[n4] == actionEvent.getSource());
                    ++n4;
                }
                break block15;
            }
            if (!string.equals("effectStyle")) break block15;
            int n5 = 0;
            while (n5 < this.kB.length) {
                this.kB[n5].else(this.kB[n5] == actionEvent.getSource());
                ++n5;
            }
        }
    }

    public void dl() {
        this.setBounds(190, 100, 250, 200);
        g g2 = new g();
        g2.setBounds(this.getWidth() - 23, 7, 15, 15);
        this.add(g2);
        al al2 = al.a(2, "\u786e\u5b9a", "ok", this, 80, this.getHeight() - 25, 44, 19);
        this.add(al2);
        al2 = al.a(2, "\u53d6\u6d88", "cancel", this, 126, this.getHeight() - 25, 44, 19);
        this.add(al2);
        this.kz = new n();
        this.kz.goto(-1);
        this.kz.char(-1);
        this.kz.setBounds(this.getWidth() - 120, 41, 106, 18);
        this.add(this.kz);
        String[] stringArray = new String[]{"\u6ee1\u5929\u661f\u661f", "\u5de6\u53f3\u6eda\u52a8", "\u81ea\u7531\u6389\u843d"};
        int n2 = 0;
        while (n2 < this.kA.length) {
            this.kA[n2] = bf.a(stringArray[n2], "textStyle", this, 12, 80 + n2 * 26, 100, 20);
            this.add(this.kA[n2]);
            ++n2;
        }
        this.kA[0].else(true);
        stringArray = new String[]{"\u82b1\u74e3\u98de\u821e", "\u7ea2\u5fc3\u95ea\u70c1", "\u793c\u82b1\u7efd\u653e"};
        n2 = 0;
        while (n2 < this.kA.length) {
            this.kB[n2] = bf.a(stringArray[n2], "effectStyle", this, 137, 80 + n2 * 26, 100, 20);
            this.add(this.kB[n2]);
            ++n2;
        }
        this.kB[0].else(true);
    }

    public void r(String string) {
        this.kz.if(string);
        if (!this.isVisible()) {
            this.ky = null;
            this.setVisible(true);
        }
    }

    public void a(d d2) {
        this.ky = d2;
        if (!this.isVisible()) {
            this.kz.if("");
            this.setVisible(true);
        }
    }

    public void a(a a10, int n2, int n3) {
        if (a10 != this.kx.c().aD()) {
            return;
        }
        this.kx.c().aD();
        j j2 = (j)a10.if();
        if (j2.fW == 7) {
            this.ky = (d)j2;
        }
    }
}

