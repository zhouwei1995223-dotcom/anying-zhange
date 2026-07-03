/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.o;
import a.b.z;
import b.a.c.b;
import b.a.c.b.al;
import b.a.c.b.e;
import b.a.c.b.g;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class ar
extends z
implements ActionListener {
    private static final long js = -8858809185291408424L;
    private int jE = 100;
    private int jz = 100;
    private int jx = 249;
    private int jG = 300;
    public String[] jr;
    public int jn;
    public int jm;
    public o jw;
    private int jv = 20;
    private int ju = 40;
    private int jC;
    private int jt = 15;
    private int jB = -1;
    private int jo = 10;
    private int jF = 60;
    private int jD;
    private long jy;
    private long jA;
    private boolean jl;
    private boolean jH;
    private b jp;
    al jq = null;
    public String jI;

    private void c3() {
        this.jl = false;
        this.jp.byte().d(this.jB);
        this.jB = -1;
    }

    public ar(b b2) {
        this.jp = b2;
        this.char(true);
        this.do(true);
    }

    public void a(c c2) {
        int n2;
        if (this.jw == null) {
            return;
        }
        c2.a(4, 30, this.getWidth() - 8, this.getHeight() - 59, -1627389952);
        e.if(c2, 0, 26, this.getWidth(), this.getHeight() - 52);
        e.for(c2, 0, 0, this.getWidth());
        c2.a(this.jI, 10, 9, -14698241);
        e.a(c2, 0, this.getHeight() - 26, this.getWidth());
        this.jw.a(c2, this.jv, this.ju, this.jw.a(), this.jw.if());
        if (this.jB >= 0) {
            n2 = this.ju + this.jw.if() + this.jo + this.jB * (this.jo + this.jt) - 2;
            c2.a(this.jv - 3, n2, this.jC, this.jt, -1);
        }
        n2 = this.jr.length;
        int n3 = this.ju + this.jw.if() + this.jo;
        int n4 = 0;
        while (n4 < n2) {
            int n5 = 0;
            n5 = n4 == this.jB ? 0 : -1;
            c2.a(this.jr[n4], this.jv, n3, n5);
            n3 += this.jt + this.jo;
            ++n4;
        }
        c2.a("\u7b54\u9898\u6570:\t" + this.jm + ",\u6b63\u786e\u6570:\t" + this.jn, this.jv, n3, -256);
        if (this.jl) {
            if (this.jD > 10) {
                c2.a("\u5012\u8ba1\u65f6 \u5269\u4f59:" + this.jD + "\u79d2", this.jv, this.getHeight() - 30 - this.jt, -1);
            } else {
                c2.a("\u5012\u8ba1\u65f6 \u5269\u4f59:" + this.jD + "\u79d2", this.jv, this.getHeight() - 30 - this.jt, -65536);
            }
        }
        super.a(c2);
    }

    public void processMouseEvent(MouseEvent mouseEvent) {
        int n2 = mouseEvent.getY();
        if (n2 < 30 || n2 > this.getHeight() - 30) {
            super.processMouseEvent(mouseEvent);
            return;
        }
        if (mouseEvent.getID() == 501 && mouseEvent.getModifiers() == 16) {
            int n3 = mouseEvent.getX();
            int n4 = mouseEvent.getY();
            int n5 = 0;
            while (n5 < this.jr.length) {
                int n6 = this.ju + this.jw.if() + this.jo + n5 * (this.jt + this.jo);
                int n7 = this.jv;
                int n8 = n6 + this.jt;
                int n9 = n6 + this.jC;
                if (n3 >= n7 && n3 <= n9 && n4 >= n6 && n4 <= n8) {
                    this.jB = n5;
                }
                ++n5;
            }
        }
    }

    public void setVisible(boolean bl) {
        super.setVisible(bl);
        this.jB = -1;
        if (!bl) {
            this.jp.byte().goto();
            this.jn = 0;
            this.jm = 0;
            this.jl = false;
        }
    }

    public void a(long l2) {
        if (this.jH) {
            this.jA = l2;
            this.jH = false;
        }
        if (this.jl) {
            if (l2 > this.jy + 1000L) {
                this.jD += -1;
                this.jy = l2;
                this.repaint();
            }
            if (l2 > this.c5()) {
                this.c3();
            }
        }
        super.a(l2);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("nextQuestion")) {
            if (this.jB == -1) {
                this.jp.new().if("\u4f60\u5c1a\u672a\u9009\u62e9\u8bf7\u9009\u62e9,\u6ce8\u610f\u7b54\u9898\u65f6\u95f4", -1);
                return;
            }
            this.c3();
        }
    }

    public void c4() {
        this.jl = true;
        this.jH = true;
        this.jD = this.jF;
    }

    public void o(String string) {
        this.jw = new o(string, this.getWidth() - 2 * this.jv, -1, 0);
    }

    public void c6() {
        this.setBounds(this.jE, this.jz, this.jx, this.jG);
        this.jq = al.a(0, "\u4e0b\u4e00\u9898", "nextQuestion", this, this.getWidth() - 72, this.getHeight() - 25, 66, 19);
        g g2 = new g();
        g2.setBounds(this.getWidth() - 23, 7, 15, 15);
        this.add(this.jq);
        this.add(g2);
        this.jC = this.getWidth() - 30;
        this.setVisible(false);
    }

    private long c5() {
        return this.jA + (long)(this.jF * 1000);
    }
}

