/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.s;
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
import b.a.e.t;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class aq
extends z
implements ActionListener,
a.b.i,
a.b.a {
    private static final String[] jc = new String[]{"\u8bf7\u653e\u5165\u60a8\u8981\u5f00\u542f\u7684\u5b9d\u7bb1", "\u8bf7\u653e\u5165\u5f00\u542f\u7bb1\u5b50\u7684\u94a5\u5319", "\u8bf7\u70b9\u786e\u5b9a\u5f00\u59cb\u5f00\u542f\u7bb1\u5b50", "\u6b63\u5728\u5f00\u542f\u7bb1\u5b50\uff0c\u8bf7\u8010\u5fc3\u7b49\u5f85...", "\u4f60\u6210\u529f\u5f00\u542f\u4e86\u5b9d\u7bb1\uff0c\u8bf7\u53d6\u51fa\u5b9d\u7269", "\u5982\u679c\u653e\u5165\u94a5\u5319\u5c06\u6781\u5927\u63d0\u9ad8\u4f60\u7684\u6536\u76ca", "\u81ea\u52a8\u4f7f\u7528\u94a5\u5319(\u7cfb\u7edf\u5c06\u81ea\u52a8\u8d2d\u4e70)"};
    private static final String[] je = new String[]{"\u7bb1\u5b50", "\u94a5\u5319", "\u7269\u54c1"};
    private static final int[] jf = new int[]{-2459092, -2459092, -16711936, -12262825, -6163693, 0xFFF000};
    b i8;
    private i jg = new i();
    private String jh = "\u5f00\u542f\u5b9d\u7bb1";
    private int[] jk = new int[2];
    private int[] ji = new int[2];
    j[] jd = new j[2];
    private int jb;
    private j ja;
    boolean i7;
    private al i9 = null;
    private boolean jj;

    private void p(int n2, int n3) {
        j j2 = this.o(n2, n3);
        if (j2 != this.ja) {
            if (j2 != null) {
                at at2 = at.b();
                at2.a(j2, false, false, 0, 0, false);
                this.a(null, at2, n2, n3);
            } else {
                this.c0();
            }
            this.ja = j2;
        }
    }

    public j E(int n2) {
        if (!this.isVisible()) {
            return null;
        }
        j j2 = this.jd[n2];
        this.jd[n2] = null;
        this.repaint();
        return j2;
    }

    private j o(int n2, int n3) {
        this.jb = -1;
        int n4 = 0;
        while (n4 < this.jk.length) {
            if (n2 > this.jk[n4] + 2 && n2 < this.jk[n4] + 26 && n3 > this.ji[n4] + 1 && n3 < this.ji[n4] + 25) {
                this.jb = n4;
                return this.jd[n4];
            }
            ++n4;
        }
        return null;
    }

    public aq(b b2) {
        this.i8 = b2;
        this.setVisible(false);
        this.char(true);
    }

    public void a() {
    }

    public void a(c c2) {
        e.a(c2, this.jh, this.getWidth(), this.getHeight());
        int n2 = 0;
        while (n2 < this.jk.length) {
            c2.a(je[n2], this.jk[n2] + 3, this.ji[n2] + 6, Color.red.getRGB());
            e.a(c2, this.jk[n2], this.ji[n2]);
            if (this.jd[n2] != null) {
                e.a(c2, this.jd[n2], this.jk[n2] + 2, this.ji[n2] + 1);
            }
            ++n2;
        }
        c2.a(jc[5], 20, 72, jf[5]);
        c2.a(jc[6], 40, 92, jf[4]);
        if (this.jd[0] == null) {
            c2.a(jc[0], 8, this.getHeight() - 52, jf[0]);
        } else if (this.jd[1] == null) {
            c2.a(jc[1], 8, this.getHeight() - 52, jf[1]);
        } else {
            c2.a(jc[2], 8, this.getHeight() - 52, jf[2]);
        }
        super.a(c2);
    }

    protected void processMouseEvent(MouseEvent mouseEvent) {
        int n2 = mouseEvent.getID();
        if (n2 == 501 || n2 == 505) {
            this.c0();
        }
        if (n2 == 501 && this.ja != null && this.jb >= 0) {
            this.jg.a(this.ja);
            this.a(this.jg, this, mouseEvent.getX(), mouseEvent.getY());
        }
        super.processMouseEvent(mouseEvent);
    }

    public void setVisible(boolean bl) {
        if (this.i7) {
            return;
        }
        super.setVisible(bl);
        if (bl) {
            this.i9.else("");
            this.jj = false;
        } else if (!bl && this.jh.length() > 0) {
            boolean bl2 = false;
            k k2 = this.i8.for();
            int n2 = 0;
            while (n2 < this.jd.length) {
                if (this.jd[n2] != null) {
                    bl2 = true;
                    int n3 = k2.bA.O();
                    if (n3 >= 0) {
                        k2.bA.fr[n3] = this.jd[n2];
                    }
                    this.jd[n2] = null;
                }
                ++n2;
            }
            if (bl2) {
                this.i8.byte().if();
            }
        }
    }

    public Object if() {
        return this.ja;
    }

    private void c0() {
        this.a((Rectangle)null, (a.b.b)null, 0, 0);
    }

    public void for(int n2, j j2) {
        if (this.isVisible()) {
            this.jd[n2] = j2;
            this.repaint();
        }
    }

    public void c2() {
        if (this.isVisible() && this.jb >= 0 && this.ja != null) {
            this.i8.byte().Y(this.jb);
            this.ja = null;
            this.jb = -1;
        }
    }

    protected void processMouseMotionEvent(MouseEvent mouseEvent) {
        if (mouseEvent.getID() == 503) {
            this.p(mouseEvent.getX(), mouseEvent.getY());
        } else if (this.ja == null) {
            super.processMouseMotionEvent(mouseEvent);
        }
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (this.i7) {
            this.i8.new().if("\u6b63\u5728\u5f00\u542f\u7bb1\u5b50\uff0c\u8bf7\u8010\u5fc3\u7b49\u5f85", -65536);
            return;
        }
        String string = actionEvent.getActionCommand();
        if (string.equals("cancel")) {
            this.setVisible(false);
        } else if (string.equals("ok")) {
            if (this.jd[0] != null) {
                this.i8.byte().case();
            } else {
                this.i8.new().if("\u6761\u4ef6\u4e0d\u8db3\uff0c\u65e0\u6cd5\u5f00\u542f\u7bb1\u5b50", -65536);
            }
        } else if (string.equals("autoBuy")) {
            al al2 = (al)actionEvent.getSource();
            if (!this.jj) {
                al2.else("\u221a");
                if (this.jd[0] != null && this.jd[1] == null) {
                    int n2 = this.jd[0].if + 300000000;
                    int n3 = this.i8.for().bA.f(n2);
                    if (n3 >= 0) {
                        this.i8.byte().try(n3, -1);
                    } else {
                        this.i8.byte().X(n2);
                    }
                }
            } else {
                al2.else("");
            }
            this.jj = !this.jj;
        }
    }

    public void do() {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private int if(j j2) {
        if (j2.fW != 5) return -1;
        t t2 = (t)j2;
        if (t2.hg == 34) {
            if (this.jd[0] == null) return 0;
            if (this.i8.for().bA.O() < 0) return -1;
            this.i8.byte().Y(0);
            return 0;
        }
        if (this.jd[0] == null || t2.hg != 0) return -1;
        if (this.jd[1] == null) return 1;
        if (this.i8.for().bA.O() < 0) return -1;
        this.i8.byte().Y(1);
        return 1;
    }

    public void do(j j2) {
        int n2 = this.jd[0].if;
        this.jd[1] = null;
        this.jd[0] = null;
        int n3 = this.i8.for().bA.f(n2);
        if (n3 >= 0 && n3 < this.i8.for().bA.fr.length) {
            this.i8.byte().try(n3, -1);
            if (this.jj) {
                int n4 = n2 + 300000000;
                n3 = this.i8.for().bA.f(n4);
                if (n3 >= 0) {
                    this.i8.byte().try(n3, -1);
                } else {
                    this.i8.byte().X(n4);
                }
            }
        }
    }

    public boolean cY() {
        return this.jd[0] == null;
    }

    public void cZ() {
        this.setBounds(0, 100, 230, 200);
        g g2 = new g();
        g2.setBounds(this.getWidth() - 23, 7, 15, 15);
        this.add(g2);
        al al2 = al.a(2, "\u786e\u5b9a", "ok", this, 80, this.getHeight() - 25, 44, 19);
        this.add(al2);
        al2 = al.a(2, "\u53d6\u6d88", "cancel", this, 126, this.getHeight() - 25, 44, 19);
        this.add(al2);
        al2 = al.a(2, "", "autoBuy", this, 15, 88, 20, 20);
        this.add(al2);
        this.i9 = al2;
        this.jk[0] = 15;
        this.ji[0] = 36;
        this.jk[1] = 45;
        this.ji[1] = 36;
    }

    public void c1() {
        if (this.isVisible()) {
            return;
        }
        int n2 = 0;
        while (n2 < this.jd.length) {
            this.jd[n2] = null;
            ++n2;
        }
        this.jb = -1;
        this.ja = null;
        this.i7 = false;
        this.setVisible(true);
        this.i8.c().ax().setVisible(false);
        this.i8.c().aD().setVisible(true);
    }

    public void a(a.b.a a10, int n2, int n3) {
        a5 a52 = this.i8.c().aD();
        if (a10 != a52 || this.i7) {
            a10.do();
            return;
        }
        j j2 = (j)a10.if();
        int n4 = this.if(j2);
        if (n4 >= 0) {
            a52.dq();
            a10.a();
        } else {
            a10.do();
        }
    }

    private class a
    extends s
    implements Runnable {
        private j dD;
        private int dC;

        a(j j2) {
            aq.this.getClass();
            this.dD = j2;
        }

        public void a(c c2) {
            c2.if(e.aZ, 0, 0, 0, 226, 13, 20);
            int n2 = this.getWidth() * this.dC / 100 - 6;
            int n3 = 13;
            while (n3 < n2) {
                c2.if(e.aZ, n3, 0, 13, 226, Math.min(20, n2 - n3), 20);
                n3 += 20;
            }
            c2.if(e.aZ, n2, 0, 33, 226, 6, 20);
        }

        public void run() {
            int n2 = 40;
            int n3 = 1;
            do {
                a.a.b.a(n2);
                this.dC = n3++;
                this.repaint();
            } while (n3 <= 100);
            this.getParent().repaint();
            this.getParent().remove(this);
            aq.this.jd[1] = null;
            aq.this.jd[0] = null;
            aq.this.jd[2] = this.dD;
            aq.this.i8.new().if("\u5f00\u5b9d\u7bb1\u83b7\u5f97\u7ecf\u9a8c:xx,\u91d1\u5e01:xx;" + this.dD.a, Color.red.getRGB());
            aq.this.i7 = false;
        }
    }
}

