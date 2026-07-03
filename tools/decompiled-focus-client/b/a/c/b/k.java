/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.o;
import a.b.q;
import a.b.s;
import b.a.c.b;
import b.a.c.b.al;
import b.a.c.b.bf;
import b.a.c.b.e;
import b.a.c.b.g;
import b.a.c.b.z;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class k
extends a.b.z
implements ActionListener {
    private b fy;
    private b.a.e.k fz;
    private z fB;
    private z fA;

    public void w(int n2) {
        if (!this.fz.iT) {
            return;
        }
        this.fz.n(n2);
        this.ca();
    }

    public k(b b2) {
        this.fy = b2;
        this.char(true);
        this.setVisible(false);
    }

    public void a(c c2) {
        c2.a(4, 30, this.getWidth() - 8, this.getHeight() - 59, -1627389952);
        e.if(c2, 0, 26, this.getWidth(), this.getHeight() - 52);
        e.for(c2, 0, 0, this.getWidth());
        c2.a("\u4efb\u52a1", 10, 9, -14698241);
        e.a(c2, 0, this.getHeight() - 26, this.getWidth());
        super.a(c2);
    }

    private String if(b.a.e.c c2) {
        if (c2.dV == -2) {
            return "\u4efb\u52a1\u5df2\u8fc7\u671f";
        }
        if (c2.dV == -1) {
            return "\u4efb\u52a1\u5df2\u653e\u5f03";
        }
        switch (c2.dF) {
            case 1: {
                return "\u6570\u91cf\uff1a" + c2.dV + "/" + c2.dG;
            }
            case 2: {
                return "\u6570\u91cf\uff1a" + c2.dV + "/" + c2.dG;
            }
        }
        if (c2.dV >= c2.dG) {
            return "\u4efb\u52a1\u5df2\u5b8c\u6210";
        }
        return "\u4efb\u52a1\u8fdb\u884c\u4e2d";
    }

    public void setVisible(boolean bl) {
        super.setVisible(bl);
        if (bl && !this.fz.iT) {
            this.fy.byte().x();
        }
    }

    public void else(int n2, int n3) {
        s s2;
        s s3;
        b.a.e.c c2 = this.fz.if(n2, n3);
        if (this.fA.case() != null && c2 == (b.a.e.c)(s3 = (s)(s2 = (s)this.fA.case()).case()).case()) {
            ((q)s3.void()).do(this.if(c2));
            if (this.isVisible()) {
                this.repaint();
            }
        }
        if (c2 != null) {
            if (c2.dV == -1) {
                this.fy.goto().int("\u4f60\u7684\u4efb\u52a1[" + c2.a + "]\u5df2\u7ecf\u653e\u5f03\u4e86", -1895825408, -7799040);
            } else if (c2.dV == -2) {
                this.fy.goto().int("\u4f60\u7684\u4efb\u52a1[" + c2.a + "]\u5df2\u7ecf\u8fc7\u671f\u4e86", -1895825408, -7799040);
            } else {
                this.fy.goto().int("\u4f60\u7684\u4efb\u52a1[" + c2.a + "]\u72b6\u6001\u6539\u53d8\u4e86", -1895825408, -7799040);
            }
        }
    }

    public void a(b.a.e.c c2) {
        if (!this.fz.iT) {
            return;
        }
        bf bf2 = bf.a(c2.a, "viewTask", this, 0, 0, q.if(c2.a) + 8, 16);
        bf2.a(c2);
        this.fB.a(bf2, 4, 4, 2);
    }

    private void a(bf bf2) {
        this.fA.bg();
        if (bf2.case() instanceof b.a.e.c) {
            b.a.e.c c2 = (b.a.e.c)bf2.case();
            s s2 = new s();
            int n2 = 0;
            s s3 = new s();
            s3.if(new q(c2.a, -1));
            s3.setBounds(0, 4, 200, 16);
            s2.add(s3);
            s3 = new s();
            s3.if(new q("\u76ee\u6807\uff1a", -1));
            s3.setBounds(0, n2 += 24, 200, 16);
            s2.add(s3);
            s3 = new s();
            o o2 = new o(c2.dR, this.fA.getWidth() - 16, -1, 24);
            s3.setBounds(0, n2 += 16, this.fA.getWidth() - 16, o2.if());
            s3.if(o2);
            s2.add(s3);
            s3 = new s();
            s3.if(new q("\u5956\u52b1\uff1a", -1));
            s3.setBounds(0, n2 += o2.if() + 4, 200, 16);
            s2.add(s3);
            s3 = new s();
            o2 = new o(c2.dU, this.fA.getWidth() - 16, -1, 24);
            s3.setBounds(0, n2 += 16, this.fA.getWidth() - 16, o2.if());
            s3.if(o2);
            s2.add(s3);
            s3 = new s();
            s3.if(new q("\u4fe1\u606f\uff1a", -1));
            s3.setBounds(0, n2 += o2.if() + 4, 200, 16);
            s2.add(s3);
            s3 = new s();
            o2 = new o(c2.dO, this.fA.getWidth() - 16, -1, 24);
            s3.setBounds(0, n2 += 16, this.fA.getWidth() - 16, o2.if());
            s3.if(o2);
            s2.add(s3);
            s3 = new s();
            s3.if(new q("\u65f6\u95f4\uff1a", -1));
            s3.setBounds(0, n2 += o2.if() + 4, 200, 16);
            s2.add(s3);
            s3 = new s();
            s3.if(new q("\u5f00\u59cb\u65f6\u95f4\uff1a" + a.a.b.do(c2.d9), -1));
            s3.setBounds(0, n2 += 16, 200, 16);
            s2.add(s3);
            n2 += 16;
            s3 = new s();
            if (c2.ed > 0) {
                s3.if(new q("\u7ed3\u675f\u65f6\u95f4\uff1a" + a.a.b.do(c2.ed), -1));
            } else {
                s3.if(new q("\u7ed3\u675f\u65f6\u95f4\uff1a\u6b64\u4efb\u52a1\u4e0d\u9650\u5236\u7ed3\u675f\u65f6\u95f4", -1));
            }
            s3.setBounds(0, n2, 200, 16);
            s2.add(s3);
            s3 = new s();
            s3.a(c2);
            s3.if(new q(this.if(c2), -16711681));
            s3.setBounds(0, n2 += 20, 200, 16);
            s2.add(s3);
            s2.setBounds(0, 0, 0, n2 += 16);
            this.fA.a(s2, 0, 0, 0);
            bf2.a(s2);
            s2.a(s3);
            this.fA.a(s2);
        } else {
            s s4 = (s)bf2.case();
            s s5 = (s)s4.case();
            b.a.e.c c3 = (b.a.e.c)s5.case();
            ((q)s5.void()).do(this.if(c3));
            this.fA.a(s4, 0, 0, 0);
            this.fA.a(s4);
        }
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.equals("viewTask")) {
            this.a((bf)actionEvent.getSource());
        } else if (string.equals("cancelTask") && this.fA.case() != null) {
            s s2 = (s)this.fA.case();
            s s3 = (s)s2.case();
            b.a.e.c c2 = (b.a.e.c)s3.case();
            if (c2.dV >= 0) {
                this.fy.byte().P(c2.if);
            }
        } else if (string.equals("deleteTask") && this.fA.case() != null) {
            s s4 = (s)this.fA.case();
            s s5 = (s)s4.case();
            b.a.e.c c3 = (b.a.e.c)s5.case();
            if (c3.dV < 0) {
                this.fy.byte().V(c3.if);
            } else {
                this.fy.new().if("\u4e0d\u80fd\u5220\u9664\u6b63\u5728\u8fdb\u884c\u4e2d\u7684\u4efb\u52a1", -65536);
            }
        } else if (string.equals("completeTask") && this.fA.case() != null) {
            s s6 = (s)this.fA.case();
            s s7 = (s)s6.case();
            b.a.e.c c4 = (b.a.e.c)s7.case();
            this.fy.byte().k(c4.if);
        }
    }

    public void b8() {
        this.fz = this.fy.for().ay;
        this.fA.bg();
        this.fA.a((Object)null);
    }

    public void b9() {
        this.fz = this.fy.for().ay;
        int n2 = 432;
        int n3 = 341;
        this.setBounds(0, 40, n2, n3);
        g g2 = new g();
        g2.setBounds(this.getWidth() - 23, 7, 15, 15);
        this.add(g2);
        this.fB = new z();
        this.fB.setBounds(4, 30, 150, n3 - 60);
        this.add(this.fB);
        this.fA = new z();
        this.fA.setBounds(160, 30, this.getWidth() - this.fB.getWidth() - 14, n3 - 60);
        this.add(this.fA);
        al al2 = al.a(2, "\u653e\u5f03\u4efb\u52a1", "cancelTask", this, 6, this.getHeight() - 25, 66, 19);
        this.add(al2);
        al2 = al.a(2, "\u5220\u9664\u4efb\u52a1", "deleteTask", this, 80, this.getHeight() - 25, 66, 19);
        this.add(al2);
        this.add(al.a(2, "\u5b8c\u6210\u4efb\u52a1", "completeTask", this, this.getWidth() - 72, this.getHeight() - 25, 66, 19));
    }

    public void ca() {
        this.fB.bg();
        this.fA.bg();
        this.fA.a((Object)null);
        int n2 = this.fz.iW.for();
        int n3 = 0;
        while (n3 < n2) {
            b.a.e.c c2 = (b.a.e.c)this.fz.iW.if(n3);
            this.a(c2);
            ++n3;
        }
    }
}

