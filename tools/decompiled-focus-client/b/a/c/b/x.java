/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.a;
import a.b.c;
import a.b.z;
import b.a.c.b;
import b.a.c.b.a5;
import b.a.c.b.al;
import b.a.c.b.at;
import b.a.c.b.e;
import b.a.c.b.g;
import b.a.c.b.i;
import b.a.e.j;
import b.a.e.n;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class x
extends z
implements ActionListener,
a.b.i,
a {
    private b gV;
    private String g0 = "\u4ed3\u5e93[\u7b2c1\u9875]";
    private int gY;
    private j g1;
    private int gZ;
    private i gW = new i();
    private n gX;

    private void d(int n2, int n3) {
        j j2 = this.e(n2, n3);
        if (j2 != this.g1) {
            if (j2 != null) {
                at at2 = at.b();
                at2.a(j2, false, false, 0, 0, false);
                this.a(null, at2, n2, n3);
            } else {
                this.cp();
            }
            this.g1 = j2;
        }
    }

    public void cr() {
        this.gV.byte().z(this.gZ);
    }

    private j e(int n2, int n3) {
        int n4 = 31;
        int n5 = 4;
        int n6 = this.gY * 80;
        int n7 = 0;
        while (n7 < 10 && n6 < this.gX.i2) {
            n5 = 4;
            int n8 = 0;
            while (n8 < 8 && n6 < this.gX.i2) {
                if (this.gX.i1[n6] != null && n2 > n5 + 2 && n3 > n4 + 1 && n2 < n5 + 24 && n3 < n4 + 24) {
                    this.gZ = n6;
                    return this.gX.i1[n6];
                }
                ++n8;
                n5 += 28;
                ++n6;
            }
            n4 += 28;
            ++n7;
        }
        this.gZ = -1;
        return null;
    }

    public x(b b2) {
        this.gV = b2;
        this.char(true);
        this.setVisible(false);
    }

    public void a() {
    }

    public void a(c c2) {
        c2.a(4, 30, this.getWidth() - 8, this.getHeight() - 59, -1627389952);
        e.for(c2, 0, 0, this.getWidth());
        c2.a(this.g0, 10, 9, -14698241);
        e.if(c2, 0, 26, this.getWidth(), this.getHeight() - 52);
        e.a(c2, 0, this.getHeight() - 26, this.getWidth());
        int n2 = 31;
        int n3 = 4;
        int n4 = this.gY * 80;
        int n5 = 0;
        while (n5 < 10 && n4 < this.gX.i2) {
            n3 = 4;
            int n6 = 0;
            while (n6 < 8 && n4 < this.gX.i2) {
                e.a(c2, n3, n2);
                if (this.gX.i1[n4] != null) {
                    e.a(c2, this.gX.i1[n4], n3 + 2, n2 + 1);
                }
                ++n6;
                n3 += 28;
                ++n4;
            }
            n2 += 28;
            ++n5;
        }
        super.a(c2);
    }

    protected void processMouseEvent(MouseEvent mouseEvent) {
        mouseEvent.getX();
        int n2 = mouseEvent.getY();
        if (n2 < 30 || n2 >= this.getHeight() - 30) {
            super.processMouseEvent(mouseEvent);
            return;
        }
        if (mouseEvent.getID() == 501 && this.g1 != null) {
            this.gW.a(this.g1);
            this.a(this.gW, this, mouseEvent.getX(), mouseEvent.getY());
        }
        this.cp();
    }

    public Object if() {
        return this.g1;
    }

    private void cp() {
        this.a((Rectangle)null, (a.b.b)null, 0, 0);
    }

    protected void processMouseMotionEvent(MouseEvent mouseEvent) {
        if (mouseEvent.getID() == 503) {
            this.d(mouseEvent.getX(), mouseEvent.getY());
        } else {
            super.processMouseMotionEvent(mouseEvent);
        }
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.equals("prev")) {
            if (this.gY > 0) {
                this.gY += -1;
                this.g0 = "\u4ed3\u5e93[\u7b2c" + (this.gY + 1) + "\u9875]";
            }
        } else if (string.equals("next")) {
            if ((this.gY + 1) * 80 < this.gX.i2) {
                ++this.gY;
                this.g0 = "\u4ed3\u5e93[\u7b2c" + (this.gY + 1) + "\u9875]";
            }
        } else if (string.equals("password")) {
            this.gV.c().aq().a("\u8bf7\u8f93\u5165\u5bc6\u7801\uff1a", '*', "inputPassword", this);
        } else if (string.equals("inputPassword")) {
            this.a(this.gV.c().aq().cK());
            this.gV.c().aq().a("\u8bf7\u786e\u8ba4\u5bc6\u7801\uff1a", '*', "confirmPassword", this);
        } else if (string.equals("confirmPassword")) {
            String string2;
            String string3 = (String)this.case();
            if (!string3.equals(string2 = this.gV.c().aq().cK())) {
                this.gV.new().if("\u4e24\u6b21\u8f93\u5165\u7684\u5bc6\u7801\u4e0d\u7b26", -65536);
            } else if (!a.a.b.case(string3)) {
                this.gV.new().if("\u5bc6\u7801\u4e2d\u542b\u6709\u975e\u6cd5\u5b57\u7b26", 0xFF0000);
            } else {
                this.gV.byte().A(string2);
            }
        } else if (string.equals("openStorePassword")) {
            String string4 = this.gV.c().aq().cK();
            this.gV.byte().x(string4);
        }
    }

    public void do() {
    }

    public void cq() {
        this.gX = this.gV.case().c9;
        if (this.gX.i4) {
            this.setLocation(0, 40);
            this.gV.c().aD().setLocation(this.getWidth(), 40);
            this.gV.c().aD().setVisible(true);
            this.setVisible(true);
        } else if (this.gX.i6) {
            this.gV.c().aq().a("\u8bf7\u8f93\u5165\u4ed3\u5e93\u5bc6\u7801\uff1a", '*', "openStorePassword", this);
        } else {
            this.gV.byte().x("");
        }
    }

    public void cs() {
        int n2 = 232;
        int n3 = 341;
        this.setBounds(0, 40, n2, n3);
        g g2 = new g();
        g2.setBounds(this.getWidth() - 23, 7, 15, 15);
        this.add(g2);
        al al2 = al.a(2, "\u4e0a\u9875", "prev", this, 6, this.getHeight() - 25, 44, 19);
        this.add(al2);
        al2 = al.a(2, "\u4e0b\u9875", "next", this, 54, this.getHeight() - 25, 44, 19);
        this.add(al2);
        al2 = al.a(2, "\u8bbe\u7f6e\u5bc6\u7801", "password", this, this.getWidth() - 72, this.getHeight() - 25, 66, 19);
        this.add(al2);
    }

    public void a(a a10, int n2, int n3) {
        a5 a52 = this.gV.c().aD();
        if (a10 != a52) {
            return;
        }
        j j2 = (j)a52.if();
        if (j2.fF > 0) {
            a52.dv();
        } else {
            this.gV.new().if("\u8be5\u7269\u54c1\u4e0d\u53ef\u5b58\u4ed3\u5e93", -65536);
        }
    }
}

