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
import b.a.c.b.i;
import b.a.d.k;
import b.a.e.j;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ac
extends z
implements ActionListener,
a.b.i,
a {
    private static final String[] hI = new String[]{"\u64cd\u4f5c\u4e2d", "\u5df2\u786e\u8ba4", "\u5df2\u53d6\u6d88", "\u5df2\u5b8c\u6210"};
    private static final int[] hF = new int[]{-16711936, -65281, -1, -1};
    private int[] hA = new int[16];
    private int[] hL = new int[16];
    private int[] hM = new int[16];
    private int[] hH = new int[16];
    private b hy;
    private String hK = "trade";
    private j[] hJ = new j[16];
    private j[] hN = new j[16];
    private int hC = 1234;
    private int hE = 5678;
    private int hB;
    private int hD;
    private j hz;
    private int hx;
    private i hG = new i();

    public void j(int n2, int n3) {
        this.hC = n2;
        this.hy.for().bA.fk = n3;
        this.hB = 0;
        this.hD = 0;
    }

    private void i(int n2, int n3) {
        j j2 = this.h(n2, n3);
        if (j2 != this.hz) {
            if (j2 != null) {
                at at2 = at.b();
                at2.a(j2, false, false, 0, 0, false);
                this.a(null, at2, n2, n3);
            } else {
                this.cF();
            }
            this.hz = j2;
        }
    }

    public void if(int n2, j j2) {
        this.hN[n2] = j2;
        this.hB = 0;
        this.hD = 0;
    }

    private j h(int n2, int n3) {
        this.hx = -1;
        int n4 = 0;
        while (n4 < this.hA.length) {
            if (n2 > this.hA[n4] + 2 && n2 < this.hA[n4] + 26 && n3 > this.hL[n4] + 1 && n3 < this.hL[n4] + 25) {
                return this.hN[n4];
            }
            ++n4;
        }
        n4 = 0;
        while (n4 < this.hM.length) {
            if (n2 > this.hM[n4] + 2 && n2 < this.hM[n4] + 26 && n3 > this.hH[n4] + 1 && n3 < this.hH[n4] + 25) {
                this.hx = n4;
                return this.hJ[n4];
            }
            ++n4;
        }
        return null;
    }

    public void cD() {
        this.hD = 1;
    }

    public ac(b b2) {
        this.hy = b2;
        this.char(true);
        this.setVisible(false);
    }

    public void a() {
    }

    public void m(String string) {
        this.hK = "\u4e0e\u300e" + string + "\u300f\u4ea4\u6613\u4e2d";
        int n2 = 0;
        while (n2 < this.hJ.length) {
            this.hN[n2] = null;
            this.hJ[n2] = null;
            ++n2;
        }
        this.hE = 0;
        this.hC = 0;
        this.hD = 0;
        this.hB = 0;
        this.setLocation(0, 40);
        this.setVisible(true);
        this.hy.c().aD().setLocation(this.getWidth() + this.getX(), 40);
        this.hy.c().aD().setVisible(true);
    }

    public void a(c c2) {
        c2.a(4, 30, this.getWidth() - 8, this.getHeight() - 59, -1627389952);
        e.if(c2, 0, 26, this.getWidth(), this.getHeight() - 52);
        e.for(c2, 0, 0, this.getWidth());
        c2.a(this.hK, 10, 9, -14698241);
        e.if(c2, 3, 110, this.getWidth() - 3);
        e.a(c2, 0, this.getHeight() - 26, this.getWidth());
        int n2 = 4;
        int n3 = 30;
        int n4 = 0;
        while (n4 < this.hN.length) {
            n2 = this.hA[n4];
            n3 = this.hL[n4];
            e.a(c2, n2, n3);
            if (this.hN[n4] != null) {
                e.a(c2, this.hN[n4], n2 + 2, n3 + 1);
            }
            ++n4;
        }
        n3 = 92;
        c2.a("\u91d1\u5e01:", 8, n3, -1);
        e.do(c2, this.hE, 34, n3);
        c2.if(158, n3 - 2, 60, 16, -9944012);
        c2.a(159, n3 - 1, 58, 14, -16777216);
        c2.a(hI[this.hD], 170, n3, hF[this.hD]);
        n3 = this.hH[0];
        n4 = 0;
        while (n4 < this.hN.length) {
            n2 = this.hM[n4];
            n3 = this.hH[n4];
            e.a(c2, n2, n3);
            if (this.hJ[n4] != null) {
                e.a(c2, this.hJ[n4], n2 + 2, n3 + 1);
            }
            ++n4;
        }
        n3 = 175;
        c2.a("\u91d1\u5e01:", 8, n3, -1);
        e.do(c2, this.hC, 34, n3);
        c2.if(158, n3 - 2, 60, 16, -9944012);
        c2.a(159, n3 - 1, 58, 14, -16777216);
        c2.a(hI[this.hB], 170, n3, hF[this.hB]);
        super.a(c2);
    }

    protected void processMouseEvent(MouseEvent mouseEvent) {
        int n2 = mouseEvent.getID();
        if (n2 == 501 || n2 == 505) {
            this.cF();
        }
        if (n2 == 501 && this.hz != null && this.hx >= 0) {
            this.hG.a(this.hz);
            this.a(this.hG, this, mouseEvent.getX(), mouseEvent.getY());
        }
        if (mouseEvent.getY() < 30) {
            super.processMouseEvent(mouseEvent);
        }
    }

    public void setVisible(boolean bl) {
        if (bl != this.isVisible()) {
            super.setVisible(bl);
            if (!bl && this.hB < 2) {
                this.hy.byte().H();
            }
        }
    }

    public Object if() {
        return this.hz;
    }

    public void C(int n2) {
        this.hE = n2;
        this.hB = 0;
        this.hD = 0;
    }

    private void cF() {
        this.a((Rectangle)null, (a.b.b)null, 0, 0);
    }

    public void cH() {
        if (this.isVisible() && this.hx >= 0 && this.hz != null) {
            this.hy.byte().D(this.hx);
            this.hz = null;
            this.hx = -1;
        }
    }

    protected void processMouseMotionEvent(MouseEvent mouseEvent) {
        this.i(mouseEvent.getX(), mouseEvent.getY());
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.equals("cancel")) {
            this.hB = 2;
            this.hy.byte().H();
            this.setVisible(false);
        } else if (string.equals("complete")) {
            this.hy.byte().m();
            this.hB = 1;
        } else if (string.equals("setMoney")) {
            this.hy.c().aq().a("\u8bf7\u8f93\u5165\u8981\u4ea4\u6613\u7684\u91d1\u5e01\u6570\u91cf(\u6700\u5927\u4e3a" + (this.hC + this.hy.for().bA.fk) + ")", "setMoneyOK", this);
        } else if (string.equals("setMoneyOK") && this.isVisible()) {
            String string2 = this.hy.c().aq().cK();
            try {
                int n2 = Integer.parseInt(string2);
                if (n2 >= 0) {
                    int n3 = this.hC + this.hy.for().bA.fk;
                    if (n2 > n3) {
                        this.hy.new().if("\u4f60\u5e76\u6ca1\u6709\u8fd9\u4e48\u591a\u91d1\u5e01", -65281);
                    } else {
                        this.hy.byte().int(n2);
                    }
                }
            }
            catch (NumberFormatException numberFormatException) {
                this.hy.new().if("\u8f93\u5165\u7684\u4e0d\u662f\u5408\u6cd5\u7684\u6570\u5b57", -65281);
            }
        }
    }

    public void do() {
    }

    public void k(int n2, int n3) {
        k k2 = this.hy.for();
        k2.bA.fr[n3] = this.hJ[n2];
        this.hJ[n2] = null;
        this.hB = 0;
        this.hD = 0;
    }

    public void l(int n2, int n3) {
        j j2;
        k k2 = this.hy.for();
        this.hJ[n3] = j2 = k2.bA.fr[n2];
        k2.bA.fr[n2] = null;
        this.hB = 0;
        this.hD = 0;
    }

    public void cE() {
        int n2 = 232;
        int n3 = 223;
        this.setBounds(0, 40, n2, n3);
        al al2 = al.a(2, "\u8bbe\u7f6e", "setMoney", this, 102, this.getHeight() - 51, 44, 19);
        this.add(al2);
        al2 = al.a(2, "\u53d6\u6d88\u4ea4\u6613", "cancel", this, 6, this.getHeight() - 25, 66, 19);
        this.add(al2);
        al2 = al.a(2, "\u786e\u5b9a\u4ea4\u6613", "complete", this, this.getWidth() - 72, this.getHeight() - 25, 66, 19);
        this.add(al2);
        int n4 = 0;
        do {
            this.hA[n4] = 4 + n4 % 8 * 28;
            this.hM[n4] = this.hA[n4];
            this.hL[n4] = 30 + n4 / 8 * 28;
            this.hH[n4] = 113 + n4 / 8 * 28;
        } while (++n4 < 16);
    }

    public void B(int n2) {
        this.hN[n2] = null;
        this.hB = 0;
        this.hD = 0;
    }

    public void a(a a10, int n2, int n3) {
        a5 a52 = this.hy.c().aD();
        if (a10 != a52) {
            return;
        }
        a52.dr();
    }

    public void n(String string) {
        this.hy.new().if(string, -16711681);
        this.setVisible(false);
    }

    public void cG() {
        this.hB = 3;
        this.setVisible(false);
        this.hy.new().if("\u4ea4\u6613\u6210\u529f", -16711681);
    }
}

