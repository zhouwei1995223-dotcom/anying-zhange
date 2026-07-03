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
public class ab
extends z
implements i,
a,
ActionListener {
    private b hk;
    public String hs = "";
    private int hr = 10;
    private int ho = 30;
    public j[] hw = new j[5];
    public j[] hp = new j[5];
    public int[] hq = new int[5];
    public int hm = 0;
    private at hu = null;
    private int ht = -1;
    private al hv = null;
    private al hj = null;
    private String hi = "";
    private int hn;
    private int hl;

    public j A(int n2) {
        j j2 = this.hp[n2];
        this.hp[n2] = null;
        return j2;
    }

    public ab(b b2) {
        this.hk = b2;
        this.char(true);
    }

    public void a() {
    }

    public void a(c c2) {
        c2.a(4, 30, this.getWidth() - 8, this.getHeight() - 59, -1627389952);
        e.if(c2, 0, 26, this.getWidth(), this.getHeight() - 52);
        e.for(c2, 0, 0, this.getWidth());
        c2.a(this.hs, 10, 9, -14698241);
        e.a(c2, 0, this.getHeight() - 26, this.getWidth());
        int n2 = 0;
        int n3 = 0;
        while (n3 < this.hw.length) {
            if (this.hw[n3] != null) {
                e.a(c2, this.hr + n2, this.ho);
                if (this.hp[n3] == null) {
                    e.if(c2, this.hw[n3], this.hr + n2 + 2, this.ho + 1);
                } else {
                    e.a(c2, this.hw[n3], this.hr + n2 + 2, this.ho + 1);
                }
                n2 += 28;
            }
            ++n3;
        }
        n3 = this.ho + 30;
        c2.a("\u5408\u6210\u8d39\u7528:" + this.hm + "\u91d1\u5e01", this.hr, n3, -1);
        if (!this.hi.equals("")) {
            String[] stringArray = a.a.b.a(this.hi, "\n");
            int n4 = 0;
            while (n4 < stringArray.length) {
                c2.a(stringArray[n4], this.hr, n3 += 15, -65536);
                ++n4;
            }
        } else {
            c2.a("\u5408\u6210\u7269\u54c1\u5df2\u7ecf\u9f50\u5907", this.hr, n3 += 15, -1);
        }
        super.a(c2);
    }

    public void processMouseEvent(MouseEvent mouseEvent) {
        int n2 = mouseEvent.getY();
        if (n2 < 30 || n2 > this.getHeight() - 30) {
            super.processMouseEvent(mouseEvent);
            return;
        }
        if (mouseEvent.getModifiers() == 4) {
            int n3 = this.hw.length;
            int n4 = 0;
            while (n4 < n3) {
                int n5 = this.hr + n4 * 28;
                int n6 = this.ho;
                int n7 = n5 + 27;
                int n8 = n6 + 27;
                if (mouseEvent.getX() >= n5 && mouseEvent.getX() <= n7 && mouseEvent.getY() >= n6 && mouseEvent.getY() <= n8) {
                    if (this.hp[n4] != null && this.hq[n4] != -1) {
                        this.hk.byte().x(this.hq[n4]);
                    }
                    this.repaint();
                }
                ++n4;
            }
        }
    }

    public void setVisible(boolean bl) {
        super.setVisible(bl);
        if (!bl) {
            boolean bl2 = false;
            k k2 = this.hk.for();
            int n2 = 0;
            while (n2 < this.hp.length) {
                if (this.hp[n2] != null) {
                    bl2 = true;
                    int n3 = k2.bA.O();
                    if (n3 >= 0) {
                        k2.bA.fr[n3] = this.hp[n2];
                    }
                    this.hp[n2] = null;
                }
                this.hq[n2] = -1;
                ++n2;
            }
            if (bl2) {
                this.hk.byte().for();
            }
        }
    }

    public void cB() {
        this.hi = "";
        int n2 = 0;
        while (n2 < this.hw.length) {
            if (this.hw[n2] != null && this.hp[n2] == null) {
                this.hi = this.hi + "\u8fd8\u9700\u8981\u7269\u54c1:\t" + this.hw[n2].a + "\t\n";
            }
            ++n2;
        }
    }

    public Object if() {
        return null;
    }

    public void processMouseMotionEvent(MouseEvent mouseEvent) {
        if (mouseEvent.getID() == 503) {
            boolean bl = false;
            int n2 = this.hw.length;
            int n3 = 0;
            while (n3 < n2) {
                int n4 = this.hr + n3 * 28;
                int n5 = this.ho;
                int n6 = n4 + 27;
                int n7 = n5 + 27;
                if (mouseEvent.getX() >= n4 && mouseEvent.getX() <= n6 && mouseEvent.getY() >= n5 && mouseEvent.getY() <= n7) {
                    if (this.ht != n3) {
                        this.hn = mouseEvent.getX();
                        this.hl = mouseEvent.getY();
                    }
                    this.ht = n3;
                    bl = true;
                    break;
                }
                ++n3;
            }
            this.hu = at.b();
            if (bl && this.hw[this.ht] != null) {
                this.hu.a(this.hw[this.ht], false, false, 0, 0, false);
                this.a(null, this.hu, this.hn, this.hl);
            } else {
                this.ht = -1;
                this.a((Rectangle)null, (a.b.b)null, 0, 0);
            }
        } else {
            super.processMouseMotionEvent(mouseEvent);
        }
    }

    public void do() {
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("cancel")) {
            this.setVisible(false);
            return;
        }
        this.hk.e().actionPerformed(actionEvent);
    }

    public void cC() {
        this.setBounds(10, 90, 204, 245);
        g g2 = new g();
        g2.setBounds(this.getWidth() - 23, 7, 15, 15);
        this.hv = al.a(0, "\u5408\u6210", "mix", this, this.getWidth() - 72, this.getHeight() - 25, 66, 19);
        this.hj = al.a(0, "\u53d6\u6d88", "cancel", this, 6, this.getHeight() - 25, 66, 19);
        this.add(this.hv);
        this.add(this.hj);
        this.add(g2);
        this.setVisible(false);
    }

    public void a(a a10, int n2, int n3) {
        a5 a52 = this.hk.c().aD();
        if (a10 != a52) {
            a10.do();
            return;
        }
        Object object = a10.if();
        if (object instanceof j) {
            n2 -= 12;
            n3 -= 12;
            j j2 = (j)object;
            int n4 = this.hw.length;
            int n5 = 0;
            while (n5 < n4) {
                int n6 = this.getLocation().x + this.hr + n5 * 28;
                int n7 = this.getLocation().y + this.ho;
                int n8 = n6 + 27;
                int n9 = n7 + 27;
                if (n2 >= n6 && n2 <= n8 && n3 >= n7 && n3 <= n9) {
                    if (j2.if == this.hw[n5].if) {
                        a52.dt();
                        break;
                    }
                    this.hk.new().if("\u8bf7\u653e\u5165" + this.hw[n5].a, -1);
                    break;
                }
                ++n5;
            }
        }
    }
}

