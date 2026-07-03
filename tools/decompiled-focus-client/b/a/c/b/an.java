/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.a;
import a.b.c;
import a.b.i;
import a.b.z;
import b.a.c.b;
import b.a.c.b.a5;
import b.a.c.b.al;
import b.a.c.b.at;
import b.a.c.b.e;
import b.a.c.b.g;
import b.a.d.k;
import b.a.e.j;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class an
extends z
implements ActionListener,
i {
    private static String[] iM = new String[]{"\u4e0a\u67b6\u65b0\u7269\u54c1", "\u4e0b\u67b6\u8001\u7269\u54c1", "\u8bbe\u7f6e\u51fa\u552e\u6bd4\u7387", "\u8bbe\u7f6e\u56de\u6536\u6bd4\u7387"};
    private static String[] iU = new String[]{"addGoods", "removeGoods", "saleScale", "purchaseScale"};
    private b iL;
    private int iT = 8;
    private int iS = 10;
    private int iK;
    private String iJ = "\u5546\u5e97";
    private int iW;
    private int iI;
    private j[] iP;
    private int iV;
    private int iN;
    private int iQ;
    private int iO;
    private String iR = "";

    public void cU() {
        if (this.isVisible()) {
            k k2 = this.iL.for();
            if (Math.abs(k2.void - this.iQ) > 5 || Math.abs(k2.long - this.iO) > 5) {
                this.setVisible(false);
            }
        }
    }

    private void int(int n2, int n3, int n4) {
        if (n2 >= 0 && n2 < this.iP.length) {
            at at2 = at.b();
            at2.a(this.iP[n2], false, false, this.iW, 0, false);
            this.a(null, at2, n3, n4);
        } else {
            this.a((Rectangle)null, (a.b.b)null, 0, 0);
        }
    }

    public void D(int n2) {
        this.iP[n2] = null;
        if (this.iV == n2) {
            this.iV = -1;
        }
        this.repaint();
    }

    public an(b b2) {
        this.iL = b2;
        this.char(true);
        this.setVisible(false);
    }

    public void a(c c2) {
        c2.a(4, 30, this.getWidth() - 8, this.getHeight() - 59, -1627389952);
        e.if(c2, 0, 26, this.getWidth(), this.getHeight() - 52);
        e.for(c2, 0, 0, this.getWidth());
        c2.a(this.iJ, 10, 9, -14698241);
        int n2 = 4;
        int n3 = 31;
        int n4 = 0;
        int n5 = 0;
        while (n5 < this.iS) {
            n2 = 4;
            int n6 = 0;
            while (n6 < this.iT) {
                if (n4 < this.iP.length) {
                    e.a(c2, n2, n3);
                    if (this.iP[n4] != null) {
                        e.a(c2, this.iP[n4], n2 + 2, n3 + 1);
                        if (this.iV == n4) {
                            c2.a(n2 + 2, n3 + 1, 24, 24, -1879048193);
                        }
                    }
                }
                ++n4;
                n2 += 28;
                ++n6;
            }
            n3 += 28;
            ++n5;
        }
        e.a(c2, 0, this.getHeight() - 26, this.getWidth());
        if (this.iL.for().ao > 0) {
            c2.a(this.iR, 8, this.getHeight() - 21, -16711936);
        }
        super.a(c2);
    }

    protected void processMouseEvent(MouseEvent mouseEvent) {
        mouseEvent.getX();
        int n2 = mouseEvent.getY();
        if (n2 <= 30 || n2 >= this.getHeight() - 30) {
            super.processMouseEvent(mouseEvent);
            return;
        }
        if (mouseEvent.getID() == 501) {
            int n3 = this.n(mouseEvent.getX(), mouseEvent.getY());
            if (n3 >= 0 && n3 < this.iP.length && this.iP[n3] != null && this.iV != n3) {
                this.iV = n3;
            }
            if (mouseEvent.getModifiers() == 4) {
                if (this.iL.for().ao > 1) {
                    if (this.iI < 100) {
                        this.a(iM, iU, this, mouseEvent.getX(), mouseEvent.getY());
                    }
                } else {
                    this.actionPerformed(new ActionEvent(this, 0, "buy"));
                }
            }
        }
        if (mouseEvent.getID() != 504) {
            this.cS();
        }
    }

    private int n(int n2, int n3) {
        int n4 = 31;
        int n5 = 4;
        int n6 = 0;
        int n7 = 0;
        do {
            n5 = 4;
            int n8 = 0;
            do {
                if (n2 > n5 + 2 && n3 > n4 + 1 && n2 < n5 + 24 && n3 < n4 + 24) {
                    return n6;
                }
                n5 += 28;
                ++n6;
            } while (++n8 < 8);
            n4 += 28;
        } while (++n7 < 10);
        return -1;
    }

    public void m(int n2, int n3) {
        this.iW = n2;
        this.iI = n3;
        this.iR = "\u51fa\u552e/\u56de\u6536\u4ef7\u683c\u6bd4\u7387:" + n2 + "/" + n3;
        this.repaint();
    }

    public void setVisible(boolean bl) {
        if (this.isVisible() != bl && !bl && this.iP != null) {
            this.iL.byte().w();
        }
        super.setVisible(bl);
    }

    private void cS() {
        this.a((Rectangle)null, (a.b.b)null, 0, 0);
    }

    public void do(int n2, j j2) {
        this.iP[n2] = j2;
        this.repaint();
    }

    protected void processMouseMotionEvent(MouseEvent mouseEvent) {
        if (mouseEvent.getID() == 503) {
            int n2 = this.n(mouseEvent.getX(), mouseEvent.getY());
            if (n2 < 0 || n2 >= this.iP.length || this.iP[n2] == null) {
                this.cS();
            } else if (this.iN != n2) {
                this.int(n2, mouseEvent.getX(), mouseEvent.getY());
            }
            this.iN = n2;
        }
        super.processMouseMotionEvent(mouseEvent);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.equals("buy")) {
            if (this.iV >= 0 && this.iV < this.iP.length && this.iP[this.iV] != null) {
                j j2 = this.iP[this.iV];
                int n2 = j2.fK * this.iW / 100;
                if (n2 > 0 && n2 > this.iL.case().dg) {
                    this.iL.new().if("\u60a8\u7684\u5143\u5b9d\u6570\u989d\u4e0d\u8db3\uff0c\u65e0\u6cd5\u8d2d\u4e70\u6b64\u7269\u54c1\uff0c\u8bf7\u60a8\u5148\u4e3a\u5e10\u6237\u5145\u503c\u5143\u5b9d\u3002\u73b0\u5728\u5c31\u5145\u503c\u5417\uff1f", -1, "pay", "", this);
                } else {
                    this.iL.byte().L(this.iV);
                }
            } else {
                this.iL.new().if("\u4f60\u8fd8\u6ca1\u6709\u9009\u5b9a\u7269\u54c1\uff01", -65536);
            }
        } else if (string.equals("pay")) {
            if ("buy".equals(this.iL.do().getParameter("payType"))) {
                this.iL.c().aB().actionPerformed(actionEvent);
            } else {
                this.iL.c().aD().actionPerformed(actionEvent);
            }
        } else if (string.equals("yesSell")) {
            a5 a52 = this.iL.c().aD();
            a52.dA();
        } else if (string.equals("addGoods")) {
            String string2 = "\u8bf7\u8f93\u5165\u8981\u4e0a\u67b6\u7684\u7269\u54c1\u7f16\u53f7\uff0c\u6ce8\u610f\u4e0d\u8981\u8f93\u9519\u54e6\uff1a";
            this.iL.void().a(string2, "yesAdd", this);
        } else if (string.equals("removeGoods")) {
            String string3 = "\u8bf7\u8f93\u5165\u8981\u4e0b\u67b6\u7684\u7269\u54c1\u7f16\u53f7\uff0c\u6ce8\u610f\u4e0d\u8981\u8f93\u9519\u54e6\uff1a";
            this.iL.void().a(string3, "yesRemove", this);
        } else if (string.equals("saleScale")) {
            String string4 = "\u8bf7\u8f93\u5165\u65b0\u7684\u51fa\u552e\u4ef7\u683c\u6bd4\u7387\uff0c\u5fc5\u987b\u662f\u5927\u4e8e0\u4e14\u5c0f\u4e8e10000\uff1a";
            this.iL.void().a(string4, "yesSaleScale", this);
        } else if (string.equals("purchaseScale")) {
            String string5 = "\u8bf7\u8f93\u5165\u65b0\u7684\u56de\u6536\u4ef7\u683c\u6bd4\u7387\uff0c\u5fc5\u987b\u662f\u5927\u4e8e0\u4e14\u5c0f\u4e8e100\uff1a";
            this.iL.void().a(string5, "yesPurchaseScale", this);
        } else if (string.equals("yesAdd")) {
            String string6 = this.iL.void().cK();
            this.iL.byte().char(this.iK, Integer.parseInt(string6));
        } else if (string.equals("yesRemove")) {
            String string7 = this.iL.void().cK();
            this.iL.byte().case(this.iK, Integer.parseInt(string7));
        } else if (string.equals("yesSaleScale")) {
            String string8 = this.iL.void().cK();
            this.iL.byte().new(this.iK, Integer.parseInt(string8));
        } else if (string.equals("yesPurchaseScale")) {
            String string9 = this.iL.void().cK();
            this.iL.byte().goto(this.iK, Integer.parseInt(string9));
        }
    }

    public void a(int n2, String string, int n3, int n4, j[] jArray) {
        this.iK = n2;
        this.iJ = string;
        this.iW = n3;
        this.iI = n4;
        this.iP = jArray;
        this.iV = -1;
        this.setLocation(0, 40);
        this.setVisible(true);
        this.iL.c().aD().setLocation(this.getWidth(), 40);
        this.iL.c().aD().setVisible(true);
        k k2 = this.iL.for();
        this.iQ = k2.void;
        this.iO = k2.long;
        this.iR = "\u51fa\u552e/\u56de\u6536\u4ef7\u683c\u6bd4\u7387:" + n3 + "/" + n4;
    }

    public void cW() {
        int n2 = this.iT * 28 + 8;
        int n3 = this.iS * 28 + 61;
        this.setBounds(12, 50, n2, n3);
        g g2 = new g();
        g2.setBounds(this.getWidth() - 23, 7, 15, 15);
        this.add(g2);
        al al2 = al.a(2, "\u8d2d\u4e70", "buy", this, this.getWidth() - 50, this.getHeight() - 25, 44, 19);
        this.add(al2);
    }

    public void a(a a10, int n2, int n3) {
        a5 a52 = this.iL.c().aD();
        if (a10 != a52) {
            return;
        }
        if (this.iI == 100) {
            this.iL.new().if("\u672c\u5546\u5e97\u4e0d\u6536\u8d2d\u7269\u54c1", 0xFFFFFF);
            return;
        }
        j j2 = (j)a52.if();
        if (j2.fK == 0) {
            a52.dA();
        } else {
            this.iL.new().if("\u60a8\u786e\u5b9a\u8981\u51fa\u552e\u3010" + j2.a + "\u3011\u5417\uff1f\u8bf7\u6ce8\u610f\uff0c\u901a\u8fc7\u5546\u5e97\u51fa\u552e\u6b64\u7269\u54c1\u5c06\u53ea\u80fd\u83b7\u5f97\u6e38\u620f\u91d1\u5e01\uff01", -16711936, "yesSell", "", this);
        }
    }

    public int cT() {
        return this.iW;
    }

    public int cV() {
        return this.iI;
    }
}

