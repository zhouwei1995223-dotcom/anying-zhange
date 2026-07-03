/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.a;
import a.b.c;
import a.b.i;
import a.b.q;
import a.b.z;
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
public class b
extends z
implements ActionListener,
i {
    private static final String[] eW = new String[]{"\u53d6\u51fa\u7269\u54c1", "\u8bbe\u7f6e\u91d1\u5e01\u4ef7\u683c", "\u8bbe\u7f6e\u5143\u5b9d\u4ef7\u683c"};
    private static final String[] e4 = new String[]{"takeout", "setMoney", "setTreasure"};
    private b.a.c.b eX;
    private String e5;
    private k eZ;
    private int eV;
    private j[] e2;
    private int e6 = -1;
    private int eY = -1;
    private al e3;
    private boolean e0;
    private boolean e1;

    public void bW() {
        this.setVisible(true);
        if (!this.e1) {
            this.eX.byte().J();
        }
    }

    private void for(int n2, int n3, int n4) {
        if (n2 >= 0 && n2 < this.e2.length) {
            at at2 = at.b();
            at2.a(this.e2[n2], false, false, 0, 0, false);
            this.a(null, at2, n3, n4);
        } else {
            this.a((Rectangle)null, (a.b.b)null, 0, 0);
        }
    }

    public void bV() {
        this.e3.char("close");
        this.e3.else("\u5173\u95ed\u5546\u5e97");
        this.e0 = true;
    }

    public void bX() {
        this.e0 = false;
        this.e3.char("open");
        this.e3.else("\u5f00\u542f\u5546\u5e97");
    }

    public b(b.a.c.b b2) {
        this.eX = b2;
        this.eZ = b2.for();
        this.eV = this.eZ.bA.fu;
        this.e2 = b2.for().bA.fy;
        this.e5 = "\u4e2a\u4eba\u5546\u5e97";
        this.char(true);
        this.setVisible(false);
    }

    public void a(c c2) {
        e.a(c2, this.e5, this.getWidth(), this.getHeight());
        int n2 = 4;
        int n3 = 31;
        this.eV = this.eX.for().bA.fu;
        int n4 = 0;
        while (n4 < this.eV) {
            e.a(c2, n2, n3);
            if (this.e2[n4] != null) {
                e.a(c2, this.e2[n4], n2 + 2, n3 + 1);
                if (this.e6 == n4) {
                    c2.a(n2 + 2, n3 + 1, 24, 24, -1879048193);
                }
            }
            if ((n2 += 28) >= 228) {
                n2 = 4;
                n3 += 28;
            }
            ++n4;
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
        if (mouseEvent.getID() == 501 && !this.e0) {
            this.bT();
            this.e6 = this.eY;
            if (mouseEvent.getModifiers() == 4 && this.e6 >= 0 && this.e2[this.e6] != null) {
                this.a(eW, e4, this, mouseEvent.getX(), mouseEvent.getY());
                return;
            }
        }
    }

    private int byte(int n2, int n3) {
        int n4 = 4;
        int n5 = 31;
        int n6 = 0;
        while (n6 < this.eV) {
            if (n2 > n4 + 2 && n3 > n5 + 1 && n2 < n4 + 26 && n3 < n5 + 25) {
                return n6;
            }
            if ((n4 += 28) >= 228) {
                n4 = 4;
                n5 += 28;
            }
            ++n6;
        }
        return -1;
    }

    public void setVisible(boolean bl) {
        if (this.isVisible() != bl && !bl && this.e2 != null) {
            this.eX.byte().w();
        }
        super.setVisible(bl);
    }

    private void bT() {
        this.a((Rectangle)null, (a.b.b)null, 0, 0);
    }

    protected void processMouseMotionEvent(MouseEvent mouseEvent) {
        if (mouseEvent.getID() == 503) {
            int n2 = this.byte(mouseEvent.getX(), mouseEvent.getY());
            if (n2 < 0 || n2 >= this.e2.length || this.e2[n2] == null) {
                this.bT();
            } else if (this.eY != n2) {
                this.for(n2, mouseEvent.getX(), mouseEvent.getY());
            }
            this.eY = n2;
        }
        super.processMouseMotionEvent(mouseEvent);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        block40: {
            String string = actionEvent.getActionCommand();
            if (string.equals("setName")) {
                if (this.e0) {
                    this.eX.new().if("\u5fc5\u987b\u5728\u5546\u5e97\u5f00\u542f\u524d\u8bbe\u7f6e\u540d\u5b57", 0xFF0000);
                } else {
                    this.eX.void().a("\u8f93\u5165\u5546\u5e97\u7684\u540d\u79f0(2-8\u4e2a\u6c49\u5b57)", "yesSetName", this);
                }
            } else if (string.equals("yesSetName")) {
                int n2 = q.if(this.eX.void().cK());
                if (n2 < 24) {
                    this.eX.new().if("\u540d\u5b57\u592a\u77ed", 0xFF0000);
                } else if (n2 > 96) {
                    this.eX.new().if("\u540d\u5b57\u592a\u957f", 0xFF0000);
                } else {
                    this.e5 = this.eX.void().cK();
                }
            } else if (string.equals("open")) {
                int n3 = 0;
                int n4 = 0;
                while (n4 < this.e2.length) {
                    if (this.e2[n4] != null) {
                        ++n3;
                    }
                    ++n4;
                }
                if (n3 <= 0) {
                    this.eX.new().if("\u5546\u5e97\u662f\u7a7a\u7684\uff0c\u65e0\u6cd5\u5f00\u542f", 0xFF0000);
                } else if (this.eX.j().dM() == null) {
                    this.eX.new().if("\u53ea\u6709\u8fdb\u5165\u573a\u666f\u540e\u624d\u80fd\u6253\u5f00\u4e2a\u4eba\u5546\u5e97", 0xFF0000);
                } else if (this.eX.for().Q <= 0) {
                    this.eX.new().if("\u6b7b\u4ea1\u72b6\u6001\u4e0b\u65e0\u6cd5\u5f00\u542f\u5546\u5e97", 0xFF0000);
                } else {
                    this.eX.byte().r(this.e5);
                }
            } else if (string.equals("close")) {
                this.eX.byte().s();
            } else if (string.equals("takeout")) {
                k k2 = this.eX.for();
                int n5 = k2.bA.O();
                if (n5 >= 0) {
                    this.eX.byte().m(this.e6);
                    this.e6 = -1;
                } else {
                    this.eX.new().if("\u80cc\u5305\u7a7a\u95f4\u4e0d\u8db3", 0xFF0000);
                }
            } else if (string.equals("setMoney")) {
                this.eX.void().a("\u8f93\u5165\u4e3a\u8be5\u7269\u54c1\u8bbe\u7f6e\u7684\u91d1\u5e01\u4ef7\u683c(1-99999999)\u3002\u8bbe\u7f6e\u91d1\u5e01\u4ef7\u683c\u5c06\u53d6\u6d88\u5143\u5b9d\u4ef7\u683c", "yesSetMoney", this);
            } else if (string.equals("setTreasure")) {
                this.eX.void().a("\u8f93\u5165\u4e3a\u8be5\u7269\u54c1\u8bbe\u7f6e\u7684\u5143\u5b9d\u4ef7\u683c(1-999999)\u3002\u8bbe\u7f6e\u5143\u5b9d\u4ef7\u683c\u5c06\u53d6\u6d88\u91d1\u5e01\u4ef7\u683c", "yesSetTreasure", this);
            } else if (string.equals("yesSetMoney")) {
                try {
                    int n6 = Integer.parseInt(this.eX.void().cK());
                    if (n6 <= 0 || n6 > 99999999) {
                        this.eX.new().if("\u975e\u6cd5\u7684\u4ef7\u683c\uff1a" + n6, 0xFF0000);
                        break block40;
                    }
                    this.e2[this.e6].fS = n6;
                    this.e2[this.e6].fK = 0;
                    this.eX.byte().do(this.e6, n6, 0);
                }
                catch (NumberFormatException numberFormatException) {
                    this.eX.new().if("\u975e\u6cd5\u7684\u6570\u5b57\u8f93\u5165\uff1a" + this.eX.void().cK(), 0xFF0000);
                }
            } else if (string.equals("yesSetTreasure")) {
                try {
                    int n7 = Integer.parseInt(this.eX.void().cK());
                    if (n7 <= 0 || n7 > 999999) {
                        this.eX.new().if("\u975e\u6cd5\u7684\u4ef7\u683c\uff1a" + n7, 0xFF0000);
                    } else {
                        this.e2[this.e6].fS = 0;
                        this.e2[this.e6].fK = n7;
                        this.eX.byte().do(this.e6, 0, n7);
                    }
                }
                catch (NumberFormatException numberFormatException) {
                    this.eX.new().if("\u975e\u6cd5\u7684\u6570\u5b57\u8f93\u5165\uff1a" + this.eX.void().cK(), 0xFF0000);
                }
            }
        }
    }

    public void bY() {
        int n2 = 232;
        int n3 = 341;
        this.setBounds(0, 40, n2, n3);
        g g2 = new g();
        g2.setBounds(this.getWidth() - 23, 7, 15, 15);
        this.add(g2);
        this.e3 = al.a(2, "\u5f00\u542f\u5546\u5e97", "open", this, this.getWidth() - 72, this.getHeight() - 25, 66, 19);
        this.add(this.e3);
        this.add(al.a(2, "\u8bbe\u7f6e\u540d\u5b57", "setName", this, 6, this.getHeight() - 25, 66, 19));
    }

    public boolean bS() {
        return this.e0;
    }

    public void a(a a10, int n2, int n3) {
        if (this.e0) {
            return;
        }
        a5 a52 = this.eX.c().aD();
        if (a10 != a52) {
            return;
        }
        j j2 = (j)a10.if();
        if (j2.fV == 0) {
            this.eX.new().if("\u8be5\u7269\u54c1\u4e0d\u53ef\u7528\u4e8e\u4ea4\u6613", 0xFF0000);
        } else {
            k k2 = this.eX.for();
            int n4 = k2.bA.F();
            if (n4 >= 0) {
                a52.dz();
            }
        }
    }

    public void bU() {
        int n2 = 0;
        while (n2 < this.e2.length) {
            if (this.e2[n2] != null) {
                return;
            }
            ++n2;
        }
        this.eX.byte().s();
    }
}

