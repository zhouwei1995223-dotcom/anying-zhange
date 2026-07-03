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
import b.a.d.k;
import b.a.e.j;
import b.a.e.m;
import b.a.e.t;
import b.a.e.v;
import b.a.e.y;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class aa
extends z
implements ActionListener,
a.b.i,
a {
    public static final String[] hf = new String[]{"\u88c5\u5907\u51b2\u7b49", "\u88c5\u5907\u7cbe\u70bc", "\u88c5\u5907\u5347\u7ea7", "\u6750\u6599\u5408\u6210"};
    private b g4;
    private i hc = new i();
    protected String he = "";
    protected int[] hh = new int[21];
    protected int[] hg = new int[21];
    protected j[] hb = new j[21];
    private int g6;
    private j g5;
    protected int ha = 0;
    private int g2 = 0;
    private int g3 = 0;
    private String hd = "";
    private boolean g8;
    protected String[] g9 = new String[]{"", "", "", "", "", "", ""};
    protected int[] g7 = new int[6];

    public void x(int n2) {
        if (this.isVisible()) {
            this.cA();
        }
        this.ha = n2;
        this.he = hf[this.ha];
        this.setLocation(0, 40);
        this.setVisible(true);
        this.g4.c().aD().setLocation(this.getWidth(), 40);
        this.g4.c().aD().setVisible(true);
        this.ct();
    }

    private void g(int n2, int n3) {
        j j2 = this.f(n2, n3);
        if (j2 != this.g5) {
            if (j2 != null) {
                at at2 = at.b();
                at2.a(j2, false, false, 0, 0, false);
                this.a(null, at2, n2, n3);
            } else {
                this.cv();
            }
            this.g5 = j2;
        }
    }

    private boolean cz() {
        int n2 = 0;
        while (n2 < this.hb.length) {
            if (this.hb[n2] instanceof t) {
                t t2 = (t)this.hb[n2];
                if (t2.hg == 14) {
                    return true;
                }
            }
            ++n2;
        }
        return false;
    }

    private void int(c c2, int n2) {
        c2.a("\u8bf7\u653e\u5165\u8981\u5347\u7ea7\u7684\u88c5\u5907", 30, 50, 0xFFFFFF);
        this.for(c2, n2);
    }

    private void cv() {
        this.a((Rectangle)null, (a.b.b)null, 0, 0);
    }

    public void a(int n2, j j2) {
        if (this.isVisible()) {
            this.hb[n2] = j2;
            this.g4.byte().case(this.ha);
        }
    }

    public void cx() {
        if (this.isVisible() && this.g6 >= 0 && this.g5 != null) {
            this.g4.byte().Y(this.g6);
            this.g5 = null;
            this.g6 = -1;
        }
    }

    protected void processMouseMotionEvent(MouseEvent mouseEvent) {
        if (mouseEvent.getID() == 503) {
            this.g(mouseEvent.getX(), mouseEvent.getY());
        } else if (mouseEvent.getY() < 30) {
            super.processMouseMotionEvent(mouseEvent);
        }
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.equals("cancel")) {
            this.setVisible(false);
        } else if (string.equals("ok")) {
            this.g4.byte().long(this.ha);
        }
    }

    public void do() {
    }

    private void if(c c2, int n2) {
        c2.a("\u8bf7\u653e\u5165\u8981\u7cbe\u70bc\u7684\u88c5\u5907", 30, 50, 0xFFFFFF);
        c2.a("\u8bf7\u653e\u5165\u7cbe\u70bc\u6240\u9700\u6750\u6599", 30, 80, 0xFFFFFF);
        c2.a("\u53ef\u4ee5\u653e\u4e00\u4e2a\u7948\u7977\u5b9d\u77f3", 30, 110, 0xFFFFFF);
        this.for(c2, n2);
    }

    private int cw() {
        int n2 = 0;
        int n3 = 0;
        while (n3 < this.hb.length) {
            if (this.hb[n3] instanceof b.a.e.e) {
                n2 = this.hb[n3].if;
            } else if (this.hb[n3] instanceof y) {
                n2 = this.hb[n3].if;
            } else if (this.hb[n3] instanceof v) {
                n2 = this.hb[n3].if;
            }
            ++n3;
        }
        return n2;
    }

    private int a(j j2) {
        if (this.ha == 0) {
            if (j2.fW == 2 || j2.fW == 3 || j2.fW == 1) {
                return 0;
            }
            if (j2.fW == 8) {
                return 1;
            }
            if (j2.a.equals("\u7948\u7977\u5b9d\u77f3")) {
                return 2;
            }
        } else if (this.ha == 1) {
            if (j2.fW == 2 || j2.fW == 3 || j2.fW == 1) {
                return 0;
            }
            if (j2.fW == 8) {
                if (this.hb[1] == null) {
                    return 1;
                }
                if (this.hb[3] == null) {
                    return 3;
                }
                return 1;
            }
            if (j2.a.equals("\u7948\u7977\u5b9d\u77f3")) {
                return 2;
            }
        } else if (this.ha == 2) {
            if (j2.fW == 2 || j2.fW == 3 || j2.fW == 1) {
                return 0;
            }
        } else if (this.ha == 3 && j2.fW == 8) {
            if (this.hb[0] == null) {
                return 0;
            }
            if (this.hb[1] == null) {
                return 1;
            }
        }
        return -1;
    }

    private void a(c c2, int n2) {
        c2.a("\u8bf7\u653e\u5165\u4e00\u4e2a\u6750\u6599", 30, 50, 0xFFFFFF);
        c2.a("\u8bf7\u518d\u653e\u5165\u4e00\u4e2a\u6750\u6599", 30, 80, 0xFFFFFF);
        this.for(c2, n2);
    }

    public j y(int n2) {
        j j2 = this.hb[n2];
        this.hb[n2] = null;
        this.g4.byte().case(this.ha);
        return j2;
    }

    private void for(c c2, int n2) {
        int n3 = 0;
        while (n3 < n2) {
            e.a(c2, this.hh[n3] - 2, this.hg[n3] - 1);
            if (this.hb[n3] != null) {
                e.a(c2, this.hb[n3], this.hh[n3], this.hg[n3]);
            }
            ++n3;
        }
    }

    private void cA() {
        boolean bl = false;
        k k2 = this.g4.for();
        int n2 = 0;
        while (n2 < this.hb.length) {
            if (this.hb[n2] != null) {
                bl = true;
                int n3 = k2.bA.O();
                if (n3 >= 0) {
                    k2.bA.fr[n3] = this.hb[n2];
                }
                this.hb[n2] = null;
            }
            ++n2;
        }
        if (bl) {
            this.g4.byte().if();
        }
    }

    private j f(int n2, int n3) {
        this.g6 = -1;
        int n4 = 0;
        while (n4 < this.hh.length) {
            if (n2 > this.hh[n4] + 2 && n2 < this.hh[n4] + 26 && n3 > this.hg[n4] + 1 && n3 < this.hg[n4] + 25) {
                this.g6 = n4;
                return this.hb[n4];
            }
            ++n4;
        }
        return null;
    }

    private void case(String string, int n2) {
        int n3 = 0;
        while (n3 < this.g9.length) {
            if (this.g9[n3].length() == 0) {
                this.g9[n3] = string;
                this.g7[n3] = n2;
                break;
            }
            ++n3;
        }
    }

    private boolean z(int n2) {
        int n3 = 0;
        while (n3 < this.hb.length) {
            if (this.hb[n3] instanceof m) {
                m m2 = (m)this.hb[n3];
                if (m2.gF == n2) {
                    return true;
                }
            }
            ++n3;
        }
        return false;
    }

    public aa(b b2) {
        this.g4 = b2;
        this.char(true);
        this.setVisible(false);
    }

    public void a() {
    }

    public void a(c c2) {
        c2.a(4, 30, this.getWidth() - 8, this.getHeight() - 59, -1627389952);
        e.if(c2, 0, 26, this.getWidth(), this.getHeight() - 52);
        e.for(c2, 0, 0, this.getWidth());
        c2.a(this.he, 10, 9, -14698241);
        e.a(c2, 0, this.getHeight() - 26, this.getWidth());
        if (this.he.equals(hf[0])) {
            this.do(c2, 3);
        } else if (this.he.equals(hf[1])) {
            this.if(c2, 4);
        } else if (this.he.equals(hf[2])) {
            this.int(c2, 1);
        } else if (this.he.equals(hf[3])) {
            this.a(c2, 2);
        }
        int n2 = 0;
        while (n2 < this.g9.length) {
            if (this.g9[n2].length() <= 0) break;
            c2.a(this.g9[n2], 10, 155 + (n2 << 4), this.g7[n2]);
            ++n2;
        }
        super.a(c2);
    }

    protected void processMouseEvent(MouseEvent mouseEvent) {
        int n2 = mouseEvent.getID();
        if (n2 == 501 || n2 == 505) {
            this.cv();
        }
        if (n2 == 501 && this.g5 != null && this.g6 >= 0) {
            this.hc.a(this.g5);
            this.a(this.hc, this, mouseEvent.getX(), mouseEvent.getY());
        }
        super.processMouseEvent(mouseEvent);
    }

    private void ct() {
        int n2 = 0;
        while (n2 < this.g9.length) {
            this.g9[n2] = "";
            ++n2;
        }
        if (this.ha == 0) {
            n2 = this.z(1) ? 1 : 0;
            int n3 = this.cw();
            if (n3 == 0) {
                this.case("\u8bf7\u653e\u5165\u8981\u51b2\u7b49\u7684\u88c5\u5907", 0xFF0000);
            }
            if (!this.z(1)) {
                this.case("\u8bf7\u653e\u5165\u51b2\u7b49\u6240\u9700\u6750\u6599", 0xFF0000);
            }
            if (n3 > 0) {
                if (this.g3 <= 0) {
                    this.case("\u6b64\u88c5\u5907\u5df2\u7ecf\u662f\u6700\u9ad8\u7b49\u7ea7\uff0c\u4e0d\u80fd\u51b2\u7b49", 0xFF0000);
                } else if (n2 != 0) {
                    this.case("\u51b2\u7b49\u6210\u529f\u51e0\u7387\uff1a" + this.g2 + "%", 0xFFFFFF);
                    this.case("\u6240\u9700\u624b\u7eed\u8d39\u7528\uff1a" + this.g3, 0xFFFFFF);
                    if (this.cz()) {
                        this.case("\u5982\u679c\u5931\u8d25\uff0c\u88c5\u5907\u4e0d\u4f1a\u88ab\u9500\u6bc1", 65280);
                    } else {
                        this.case("\u5982\u679c\u5931\u8d25\uff0c\u88c5\u5907\u53ef\u80fd\u964d\u7ea7\u6216\u8005\u9500\u6bc1", 65280);
                    }
                }
            }
        } else if (this.ha == 1) {
            n2 = !this.z(2) || !this.z(3) ? 0 : 1;
            int n4 = this.cw();
            int n5 = n4 / 10000 % 100;
            int n6 = n4 % 100;
            if (n4 == 0) {
                this.case("\u8bf7\u653e\u5165\u8981\u7cbe\u70bc\u7684\u88c5\u5907", 0xFF0000);
            } else if (n5 == 0 && n6 < 3) {
                this.case("\u672c\u88c5\u5907\u4e0d\u80fd\u7cbe\u70bc\uff0c\u9700\u8981+3", 0xFF0000);
            } else if (n5 == 1 && n6 < 4) {
                this.case("\u672c\u88c5\u5907\u4e0d\u80fd\u7cbe\u70bc\uff0c\u9700\u8981+4", 0xFF0000);
            } else if (n5 == 2 && n6 < 5) {
                this.case("\u672c\u88c5\u5907\u4e0d\u80fd\u7cbe\u70bc\uff0c\u9700\u8981+5", 0xFF0000);
            } else if (n5 == 3 && n6 < 7) {
                this.case("\u672c\u88c5\u5907\u4e0d\u80fd\u7cbe\u70bc\uff0c\u9700\u8981+7", 0xFF0000);
            } else if (n5 > 3) {
                this.case("\u6b64\u88c5\u5907\u5df2\u7ecf\u8fbe\u5230\u6700\u9ad8\u54c1\u8d28\u4e86", 0xFF0000);
            }
            if (n2 != 0) {
                int n7 = this.g2 > 100 ? this.g2 / 100 : (this.g2 > 0 ? 1 : 0);
                this.case("\u7cbe\u70bc\u6210\u529f\u51e0\u7387\uff1a" + n7 + "%", 0xFFFFFF);
                this.case("\u7cbe\u70bc\u624b\u7eed\u8d39\u7528\uff1a" + this.g3, 0xFFFFFF);
                if (this.cz()) {
                    this.case("\u5982\u679c\u5931\u8d25\uff0c\u88c5\u5907\u4e0d\u4f1a\u88ab\u9500\u6bc1", 65280);
                } else {
                    this.case("\u5982\u679c\u5931\u8d25\uff0c\u88c5\u5907\u53ef\u80fd\u964d\u7ea7\u6216\u8005\u9500\u6bc1", 65280);
                }
            } else {
                this.case("\u8bf7\u653e\u5165\u7cbe\u70bc\u6240\u9700\u6750\u6599", 0xFF0000);
            }
        } else if (this.ha == 2) {
            n2 = this.cw();
            if (n2 == 0) {
                this.case("\u8bf7\u653e\u5165\u8981\u5347\u7ea7\u7684\u88c5\u5907", 0xFF0000);
            } else if (this.g3 <= 0) {
                this.case("\u672c\u88c5\u5907\u4e0d\u80fd\u8fdb\u884c\u5347\u7ea7", 0xFF0000);
            } else {
                this.case("\u5347\u7ea7\u5143\u5b9d\u8d39\u7528\uff1a" + this.g3, 0xFFFFFF);
            }
        } else if (this.ha == 3) {
            n2 = this.cy();
            if (n2 < 2) {
                this.case("\u8bf7\u653e\u5165\u8981\u5347\u7ea7\u7684\u6750\u6599", 0xFF0000);
            } else if (this.g2 > 0 && this.g3 > 0) {
                this.case("\u5347\u7ea7\u6210\u529f\u51e0\u7387\uff1a" + this.g2 + "%", 0xFFFFFF);
                this.case("\u5347\u7ea7\u624b\u7eed\u8d39\u7528\uff1a" + this.g3, 0xFFFFFF);
            } else {
                this.case("\u672c\u6750\u6599\u65e0\u6cd5\u8fdb\u884c\u5347\u7ea7\u4e86", 0xFF0000);
            }
        } else if (this.ha == 4) {
            if (this.g3 > 0) {
                this.case("\u5408\u6210\u7ed3\u679c\uff1a" + this.hd, 0xFFFFFF);
                this.case("\u624b\u7eed\u8d39\u7528\uff1a" + this.g3, 0xFFFFFF);
            } else {
                this.case("\u6ca1\u6709\u4e0e\u4e4b\u5339\u914d\u7684\u5408\u6210\u914d\u65b9", 0xFF0000);
            }
        }
    }

    private int cy() {
        int n2 = 0;
        int n3 = 0;
        while (n3 < this.hb.length) {
            if (this.hb[n3] instanceof m) {
                m m2 = (m)this.hb[n3];
                if (m2.gK == 1) {
                    ++n2;
                }
            }
            ++n3;
        }
        return n2;
    }

    public void do(int n2, int n3, String string) {
        this.g2 = n2;
        this.g3 = n3;
        this.hd = string;
        this.ct();
    }

    public void setVisible(boolean bl) {
        super.setVisible(bl);
        if (!bl && this.he.length() > 0) {
            this.cA();
        }
    }

    public Object if() {
        return this.g5;
    }

    public void a(boolean[] blArray, j j2) {
        int n2 = 0;
        while (n2 < blArray.length) {
            if (!blArray[n2]) {
                this.hb[n2] = null;
            }
            ++n2;
        }
        n2 = 0;
        while (n2 < blArray.length) {
            if (this.hb[n2] == null) {
                this.hb[n2] = j2;
                break;
            }
            ++n2;
        }
        if (j2 != null) {
            this.g4.byte().case(this.ha);
        } else {
            this.ct();
        }
    }

    private void do(c c2, int n2) {
        c2.a("\u8bf7\u653e\u5165\u8981\u51b2\u7b49\u7684\u88c5\u5907", 30, 50, 0xFFFFFF);
        c2.a("\u8bf7\u653e\u5165\u51b2\u7b49\u6240\u9700\u6750\u6599", 30, 80, 0xFFFFFF);
        c2.a("\u53ef\u4ee5\u653e\u4e00\u4e2a\u7948\u7977\u5b9d\u77f3", 30, 110, 0xFFFFFF);
        this.for(c2, n2);
    }

    public void cu() {
        int n2 = 216;
        int n3 = 249;
        this.setBounds(0, 40, n2, n3);
        g g2 = new g();
        g2.setBounds(this.getWidth() - 23, 7, 15, 15);
        this.add(g2);
        al al2 = al.a(2, "\u53d6\u6d88", "cancel", this, 6, this.getHeight() - 25, 66, 19);
        this.add(al2);
        al2 = al.a(2, "\u786e\u5b9a", "ok", this, this.getWidth() - 72, this.getHeight() - 25, 66, 19);
        this.add(al2);
        int n4 = 0;
        while (n4 < this.hg.length) {
            this.hh[n4] = 153;
            this.hg[n4] = 43 + n4 * 30;
            ++n4;
        }
        this.hh[3] = 183;
        this.hg[3] = 73;
    }

    public void a(a a10, int n2, int n3) {
        a5 a52 = this.g4.c().aD();
        if (a10 != a52) {
            a10.do();
            return;
        }
        j j2 = (j)a10.if();
        int n4 = this.a(j2);
        if (n4 >= 0) {
            a52.H(n4);
            a10.a();
        }
    }
}

