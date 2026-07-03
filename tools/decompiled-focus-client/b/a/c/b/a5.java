/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.a;
import a.b.c;
import a.b.z;
import b.a.c.b;
import b.a.c.b.aa;
import b.a.c.b.al;
import b.a.c.b.at;
import b.a.c.b.e;
import b.a.c.b.g;
import b.a.c.b.i;
import b.a.d.l;
import b.a.e.d;
import b.a.e.h;
import b.a.e.j;
import b.a.e.m;
import b.a.e.t;
import b.a.e.y;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.lang.reflect.Method;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class a5
extends z
implements a.b.i,
a,
ActionListener {
    private static final String[] lg;
    private static final int kN = 102;
    private static final int lf = 101;
    private static final int kP = 103;
    private static final int k6 = 104;
    private static final int li = 200;
    private static final int kW = 311;
    private static final int le = 312;
    private static final int ln = 320;
    private static final int kJ = 331;
    private static final int k1 = 332;
    private static final int kM = 401;
    private static final int kY = 107;
    private static final int kX = 51;
    private static final int kS = 107;
    private static final int kQ = 86;
    private static final int k8 = 108;
    private static final int k7 = 154;
    private static final int k4 = 92;
    private static final int k3 = 119;
    private static final int kI = 124;
    private static final int kH = 119;
    private static final int kV = 77;
    private static final int kU = 51;
    private static final int k2 = 137;
    private static final int k0 = 51;
    private static final int kT = 77;
    private static final int kR = 86;
    private static final int lb = 62;
    private static final int la = 119;
    private static final int lm = 154;
    private static final int lj = 119;
    private static final int ld = 171;
    private static final int lc = 51;
    private b lh;
    private h k9;
    private boolean kO;
    private String k5 = "\u80cc\u5305";
    private int[][] kZ = new int[64][2];
    private j ll;
    private int kL;
    private at lo;
    private j lk;
    private i kK;
    private int auraDragFrom = -1;
    private j auraDragItem;
    private static boolean auraHoverSlotPatched;

    public void G(int n2) {
        this.lh.byte().c(n2, this.kL);
    }

    public void dz() {
        this.lh.byte().c(this.kL);
    }

    private void t(int n2, int n3) {
        if (this.ll == null) {
            this.dx();
        } else if (this.lk != this.ll) {
            int n4 = 0;
            if (this.lh.c().aG().isVisible()) {
                n4 = this.lh.c().aG().cV();
            }
            this.lo.a(this.ll, true, this.kL > 100, 0, n4, false, this.kO);
            this.a(null, this.lo, n2, n3);
        }
        this.lk = this.ll;
    }

    public void F(int n2) {
        if (this.k9.fr[n2] != null) {
            String string = "\u4f60\u51cf\u5c11\u7269\u54c1\uff1a" + this.k9.fr[n2].a;
            this.lh.c().aB().T().if("system", string);
            this.lh.goto().w(string);
        }
        this.k9.fr[n2] = null;
        this.repaint();
    }

    public a5(b b2, boolean bl) {
        this.lh = b2;
        this.kO = bl;
        this.char(true);
        this.setVisible(false);
        this.lo = at.b();
        this.lo.a(b2.for());
        this.kK = new i();
        Object var4_3 = null;
        this.setBounds(232, 40, 232, 566);
        this.kZ = new int[96][2];
        int n2 = 0;
        int n3 = 202;
        for (int i2 = 0; i2 < 12; ++i2) {
            int n4 = 4;
            for (int i3 = 0; i3 < 8; ++i3) {
                this.kZ[n2][0] = n4;
                this.kZ[n2][1] = n3;
                ++n2;
                n4 += 28;
            }
            n3 += 28;
        }
    }

    public void a() {
    }

    public void dr() {
        if (this.ll != null) {
            if (this.ll.fV > 0) {
                this.lh.byte().else(this.kL);
            } else {
                this.lh.new().if("\u8be5\u7269\u54c1\u4e0d\u53ef\u88ab\u4ea4\u6613", -65536);
            }
        }
    }

    public void dt() {
        this.lh.byte().A(this.kL);
    }

    public void a(c c2) {
        Object object;
        Object object2;
        e.a(c2, this.k5, this.getWidth(), this.getHeight());
        int n2 = 44;
        int n3 = 42;
        int n4 = 0;
        do {
            c2.if(e.aZ, n2, n3, 743, 148, 28, 28);
            n3 += 38;
        } while (++n4 < 4);
        c2.if(e.aZ, 56, 50, 645, 45, 124, 131);
        if (this.k9.ft != null) {
            e.a(c2, this.k9.ft, 107, 51);
        }
        if (this.k9.fx != null) {
            e.a(c2, this.k9.fx, 107, 86);
        }
        if (this.k9.fp != null) {
            e.a(c2, this.k9.fp, 92, 119);
        }
        if (this.k9.fo != null) {
            e.a(c2, this.k9.fo, 108, 154);
        }
        if (this.k9.fv != null) {
            e.a(c2, this.k9.fv, 124, 119);
        }
        if (this.k9.fz != null) {
            e.a(c2, this.k9.fz, 77, 51);
        }
        if (this.k9.fs != null) {
            e.a(c2, this.k9.fs, 137, 51);
        }
        if (this.k9.fn != null) {
            e.a(c2, this.k9.fn, 77, 86);
        }
        if (this.k9.fm != null) {
            e.a(c2, this.k9.fm, 62, 119);
        }
        if (this.k9.fw != null) {
            e.a(c2, this.k9.fw, 154, 119);
        }
        e.a(c2, 169, 50);
        if (this.k9.fq != null) {
            e.a(c2, this.k9.fq, 171, 51);
        }
        if (this.kO) {
            e.if(c2, 3, 198, this.getWidth() - 3);
            n4 = 0;
            do {
                e.a(c2, this.kZ[n4][0], this.kZ[n4][1]);
                if (this.k9.fr[n4] == null) continue;
                e.a(c2, this.k9.fr[n4], this.kZ[n4][0] + 2, this.kZ[n4][1] + 1);
            } while (++n4 < 64);
            n2 = 12;
            n3 = this.getHeight() - 22;
            c2.a("\u91d1\u5e01:", n2, n3, -2302088);
            e.do(c2, this.k9.fk, n2 += 26, n3);
            n2 = this.getWidth() - 124;
            c2.a("\u5143\u5b9d:", n2, n3, -2302088);
            e.do(c2, this.lh.case().dg, n2 += 26, n3);
        }
        super.a(c2);
        Object var6_5 = null;
        Class<?> clazz = Class.forName("b.a.c.b.e");
        clazz.getMethod("a", Class.forName("a.b.c"), Integer.TYPE, Integer.TYPE).invoke(null, c2, new Integer(169), new Integer(86));
        if (this.k9 != null && (object2 = this.k9.getClass().getField("title").get(this.k9)) != null) {
            clazz.getMethod("a", Class.forName("a.b.c"), Class.forName("b.a.e.j"), Integer.TYPE, Integer.TYPE).invoke(null, c2, object2, new Integer(171), new Integer(87));
        }
        Object var10_8 = null;
        if (this.k9 != null && this.k9.fr != null && this.kZ != null && this.kZ.length >= 96) {
            try {
                Class<?> clazz2 = Class.forName("b.a.c.b.e");
                Method method = clazz2.getMethod("a", Class.forName("a.b.c"), Integer.TYPE, Integer.TYPE);
                Method method2 = clazz2.getMethod("a", Class.forName("a.b.c"), Class.forName("b.a.e.j"), Integer.TYPE, Integer.TYPE);
                int n5 = this.k9.fr.length < 96 ? this.k9.fr.length : 96;
                for (int i2 = 64; i2 < n5; ++i2) {
                    method.invoke(null, c2, new Integer(this.kZ[i2][0]), new Integer(this.kZ[i2][1]));
                    if (this.k9.fr[i2] == null) continue;
                    method2.invoke(null, c2, this.k9.fr[i2], new Integer(this.kZ[i2][0] + 2), new Integer(this.kZ[i2][1] + 1));
                }
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        Object var18_15 = null;
        Class<?> clazz3 = Class.forName("b.a.c.b.e");
        clazz3.getMethod("a", Class.forName("a.b.c"), Integer.TYPE, Integer.TYPE).invoke(null, c2, new Integer(199), new Integer(86));
        if (this.k9 != null && (object = this.k9.getClass().getField("aura").get(this.k9)) != null) {
            clazz3.getMethod("a", Class.forName("a.b.c"), Class.forName("b.a.e.j"), Integer.TYPE, Integer.TYPE).invoke(null, c2, object, new Integer(201), new Integer(87));
        }
    }

    protected void processMouseEvent(MouseEvent mouseEvent) {
        mouseEvent.getX();
        int n2 = mouseEvent.getY();
        if (n2 <= 30 || n2 >= this.getHeight() - 30) {
            super.processMouseEvent(mouseEvent);
            return;
        }
        if (mouseEvent.getID() == 501 && this.kO) {
            if (mouseEvent.getModifiers() == 16) {
                this.v(mouseEvent.getX(), mouseEvent.getY());
            } else if (mouseEvent.getModifiers() == 4) {
                if (this.ll == null) {
                    this.a(aa.hf, lg, this, mouseEvent.getX(), mouseEvent.getY());
                } else {
                    this.dp();
                }
            }
            this.dx();
        } else if (mouseEvent.getID() == 505) {
            this.dx();
        }
    }

    public void dv() {
        this.lh.byte().w(this.kL);
    }

    public void ds() {
        this.lh.byte().G(this.kL);
    }

    public Object if() {
        return this.ll;
    }

    public void w(int n2, int n3) {
        String string = "";
        if (n2 > this.k9.fk) {
            string = "\u4f60\u7684\u91d1\u5e01\u589e\u52a0" + (n2 - this.k9.fk);
        } else if (n2 < this.k9.fk) {
            string = "\u4f60\u7684\u91d1\u5e01\u51cf\u5c11" + (this.k9.fk - n2);
        }
        l l2 = this.lh.for().a2;
        if (n3 > l2.dg) {
            string = "\u4f60\u7684\u5143\u5b9d\u589e\u52a0" + (n3 - l2.dg);
        } else if (n3 < l2.dg) {
            string = "\u4f60\u7684\u5143\u5b9d\u51cf\u5c11" + (l2.dg - n3);
        }
        this.k9.fk = n2;
        l2.dg = n3;
        this.repaint();
        if (string.length() > 0) {
            this.lh.c().aB().T().if("system", string);
            this.lh.goto().w(string);
        }
        Object var6_5 = null;
        if (n2 > 171 && n2 < 195 && n3 > 86 && n3 < 110) {
            this.ll = (y)this.k9.getClass().getField("title").get(this.k9);
            this.kL = 341;
        }
        Object var8_6 = null;
        if (n2 > 201 && n2 < 225 && n3 > 86 && n3 < 110) {
            this.ll = (y)this.k9.getClass().getField("aura").get(this.k9);
            this.kL = 342;
        }
    }

    private void dx() {
        this.a((Rectangle)null, (a.b.b)null, 0, 0);
        this.lk = null;
    }

    public void dA() {
        if (this.ll != null) {
            if (this.ll.fL == 0) {
                this.lh.new().if("\u8be5\u9053\u5177\u4e0d\u53ef\u88ab\u51fa\u552e", -65536);
            } else {
                this.lh.byte().M(this.kL);
            }
        }
    }

    public void int(int n2, j j2) {
        this.k9.fr[n2] = j2;
        this.repaint();
        String string = "\u4f60\u5f97\u5230\u7269\u54c1\uff1a" + j2.a;
        this.lh.c().aB().T().if("system", string);
        this.lh.goto().w(string);
    }

    protected void processMouseMotionEvent(MouseEvent mouseEvent) {
        if (mouseEvent.getID() == 503) {
            this.u(mouseEvent.getX(), mouseEvent.getY());
            if (this.ll != null) {
                this.t(mouseEvent.getX(), mouseEvent.getY());
            } else {
                this.dx();
            }
        } else {
            super.processMouseMotionEvent(mouseEvent);
        }
    }

    public void do() {
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.equals("gambling")) {
            this.lh.c().as().dd();
            this.lh.c().as().new();
        } else if (string.equals("yesDrop")) {
            if (this.kL >= 0 && this.kL < this.k9.fr.length) {
                this.k9.fr[this.kL] = null;
                this.lh.byte().l(this.kL);
            }
        } else if (string.equals("pay")) {
            String string2 = this.lh.do().getParameter("payText");
            if (string2 == null || string2.length() == 0) {
                string2 = "\u8bf7\u8f93\u5165\u8981\u5145\u503c\u7684\u5143\u5b9d\u6570\u91cf(1-50000)\u3002\u786e\u4fdd\u60a8\u8d26\u6237\u4e0a\u6709\u8db3\u591f\u7684\u4f59\u989d\u3002";
            }
            this.lh.c().aq().a(string2, "yesPay", this);
        } else if (string.equals("yesPay")) {
            String string3 = this.lh.c().aq().cK();
            int n2 = Integer.parseInt(string3);
            if (n2 <= 0 || n2 > 50000) {
                this.lh.new().if("\u975e\u6cd5\u7684\u5145\u503c\u6570\u91cf", -65536);
            } else {
                this.lh.byte().p(n2);
            }
        } else if (string.equals("gotoPay")) {
            this.lh.do().for("http://passport.webgame.com.cn/pay.do");
        } else if (string.equals("viewInfo")) {
            this.lh.byte().case(this.k9.a);
        } else if (string.startsWith("operation:")) {
            int n3 = string.charAt(string.length() - 1) - 48;
            this.lh.c().ax().x(n3);
        } else if (string.startsWith("sale")) {
            if (this.lh.for().p > 10) {
                this.lh.c().af().bW();
            } else {
                this.lh.new().if("\u9700\u8981\u89d2\u8272\u7b49\u7ea7\u9ad8\u4e8e10\u7ea7\u624d\u53ef\u4ee5\u4f7f\u7528\u6b64\u529f\u80fd", 0xFFFFFF);
            }
        }
    }

    public void dq() {
        this.lh.byte().try(this.kL, -1);
    }

    private void v(int n2, int n3) {
        if (this.ll != null && this.kL < 100) {
            this.kK.a(this.ll);
            this.a(this.kK, this, n2, n3);
        }
    }

    static {
        auraHoverSlotPatched = true;
        lg = new String[]{"operation:0", "operation:1", "operation:2", "operation:3"};
    }

    public int du() {
        return this.kL;
    }

    public void H(int n2) {
        this.lh.byte().try(this.kL, n2);
    }

    private void u(int n2, int n3) {
        block27: {
            int n4 = 0;
            int n5 = 0;
            this.ll = null;
            this.kL = -1;
            int n6 = 0;
            while (n6 < this.kZ.length) {
                n4 = n2 - this.kZ[n6][0] - 2;
                n5 = n3 - this.kZ[n6][1] - 1;
                if (n4 > 0 && n4 < 24 && n5 > 0 && n5 < 24) {
                    this.ll = this.k9.fr[n6];
                    this.kL = n6;
                    break block27;
                }
                ++n6;
            }
            if (n2 > 107 && n2 < 131 && n3 > 51 && n3 < 75) {
                this.ll = this.k9.ft;
                this.kL = 102;
            } else if (n2 > 107 && n2 < 131 && n3 > 86 && n3 < 110) {
                this.ll = this.k9.fx;
                this.kL = 101;
            } else if (n2 > 92 && n2 < 116 && n3 > 119 && n3 < 143) {
                this.ll = this.k9.fp;
                this.kL = 200;
            } else if (n2 > 108 && n2 < 132 && n3 > 154 && n3 < 178) {
                this.ll = this.k9.fo;
                this.kL = 103;
            } else if (n2 > 124 && n2 < 148 && n3 > 119 && n3 < 143) {
                this.ll = this.k9.fv;
                this.kL = 104;
            } else if (n2 > 77 && n2 < 101 && n3 > 51 && n3 < 75) {
                this.ll = this.k9.fz;
                this.kL = 311;
            } else if (n2 > 137 && n2 < 161 && n3 > 51 && n3 < 75) {
                this.ll = this.k9.fs;
                this.kL = 312;
            } else if (n2 > 77 && n2 < 101 && n3 > 86 && n3 < 110) {
                this.ll = this.k9.fn;
                this.kL = 320;
            } else if (n2 > 62 && n2 < 86 && n3 > 119 && n3 < 143) {
                this.ll = this.k9.fm;
                this.kL = 331;
            } else if (n2 > 154 && n2 < 178 && n3 > 119 && n3 < 143) {
                this.ll = this.k9.fw;
                this.kL = 332;
            } else if (n2 > 171 && n2 < 195 && n3 > 51 && n3 < 75) {
                this.ll = this.k9.fq;
                this.kL = 401;
            }
        }
        Object var7_6 = null;
        if (n2 > 171 && n2 < 195 && n3 > 86 && n3 < 110) {
            this.ll = (y)this.k9.getClass().getField("title").get(this.k9);
            this.kL = 341;
        }
        Object var9_7 = null;
        try {
            Object object;
            if (this.ll == null && n2 > 201 && n2 < 225 && n3 > 86 && n3 < 110 && (object = this.k9.getClass().getField("aura").get(this.k9)) != null) {
                this.ll = (j)object;
                this.kL = 342;
            }
        }
        catch (Throwable throwable) {}
    }

    public void dy() {
        if (this.ll != null) {
            if (this.ll.fO > 0) {
                this.lh.new().if("\u4f60\u786e\u5b9a\u8981\u4e22\u5f03\u7269\u54c1[" + this.ll.a + "]\u5417\uff1f", -65281, "yesDrop", "noDrop", this);
            } else {
                this.lh.new().if("\u8be5\u7269\u54c1\u4e0d\u53ef\u88ab\u4e22\u5f03", -65536);
            }
        }
    }

    public void dw() {
        int n2 = 232;
        int n3 = 454;
        this.setBounds(n2, 40, n2, n3);
        g g2 = new g();
        g2.setBounds(this.getWidth() - 23, 7, 15, 15);
        this.add(g2);
        int n4 = 4;
        int n5 = 202;
        int n6 = 0;
        int n7 = 0;
        do {
            n4 = 4;
            int n8 = 0;
            do {
                this.kZ[n6][0] = n4;
                this.kZ[n6++][1] = n5;
                n4 += 28;
            } while (++n8 < 8);
            n5 += 28;
        } while (++n7 < 8);
        if (this.kO) {
            this.k9 = this.lh.for().bA;
            if (!"buy".equals(this.lh.do().getParameter("payType"))) {
                al al2 = al.a(2, "\u5145\u503c", "pay", this, this.getWidth() - 50, this.getHeight() - 25, 44, 19);
                al2.l(-2560);
                this.add(al2);
            }
        } else {
            al al3 = al.a(2, "\u5176\u4ed6\u4fe1\u606f", "viewInfo", this, this.getWidth() - 72, this.getHeight() - 25, 66, 19);
            this.add(al3);
        }
        al al4 = al.a(1, "\u6446\u644a", "sale", this, 175, 165, 45, 25);
        this.add(al4);
        Object var10_12 = null;
        this.setBounds(232, 40, 232, 566);
        this.kZ = new int[96][2];
        int n9 = 0;
        int n10 = 202;
        for (int i2 = 0; i2 < 12; ++i2) {
            int n11 = 4;
            for (int i3 = 0; i3 < 8; ++i3) {
                this.kZ[n9][0] = n11;
                this.kZ[n9][1] = n10;
                ++n9;
                n11 += 28;
            }
            n10 += 28;
        }
    }

    public void dp() {
        if (this.kL == 342) {
            Object object = this.lh.getClass().getMethod("byte", new Class[0]).invoke(this.lh, new Object[0]);
            object.getClass().getMethod("for", Integer.TYPE, Integer.TYPE).invoke(object, new Integer(5), new Integer(1));
            return;
        }
        if (this.kL == 341) {
            Object object = this.lh.getClass().getMethod("byte", new Class[0]).invoke(this.lh, new Object[0]);
            object.getClass().getMethod("for", Integer.TYPE, Integer.TYPE).invoke(object, new Integer(4), new Integer(1));
            return;
        }
        if (this.kL == 200) {
            this.lh.byte().D();
        } else if (this.kL > 100 && this.kL < 200) {
            this.lh.byte().O(this.kL - 100);
        } else if (this.kL == 311) {
            this.lh.byte().for(1, 1);
        } else if (this.kL == 312) {
            this.lh.byte().for(1, 2);
        } else if (this.kL == 320) {
            this.lh.byte().for(2, 0);
        } else if (this.kL == 331) {
            this.lh.byte().for(3, 1);
        } else if (this.kL == 332) {
            this.lh.byte().for(3, 2);
        } else if (this.kL == 401) {
            this.lh.byte().y();
        } else if (this.ll.fW == 7) {
            this.lh.c().aM().a((d)this.ll);
        } else if (this.ll.fW == 8) {
            m m2 = (m)this.ll;
            if (m2.gL > 0 && m2.gL < 5) {
                this.lh.c().ax().x(3);
                this.H(-1);
            }
        } else {
            j j2 = null;
            j j3 = j2 = this.kL >= 0 && this.kL <= 31 ? this.k9.fr[this.kL] : null;
            if (j2 != null && j2.fW == 5) {
                t t2 = (t)j2;
                if (t2.hg == 34) {
                    if (!this.lh.c().aw().isVisible()) {
                        this.lh.c().aw().setVisible(true);
                    }
                    if (this.lh.c().aw().cY()) {
                        this.dq();
                    }
                    return;
                }
            }
            this.lh.byte().d(this.kL, 0);
        }
    }

    public void a(String string, h h2) {
        h2.a = string;
        this.k5 = "\u88c5\u5907\u4fe1\u606f[" + string + "]";
        this.k9 = h2;
        this.setLocation(158, 50);
        this.setVisible(true);
    }

    public void a(a a10, int n2, int n3) {
        this.auraDragFrom = this.kL;
        this.auraDragItem = this.ll;
        if (!this.kO) {
        } else if (a10 == this) {
            Point point = e.for(this);
            j j2 = this.ll;
            int n4 = this.kL;
            this.u(n2 -= point.x, n3 -= point.y);
            if (this.kL >= 0) {
                if (n4 == this.kL) {
                } else {
                    switch (this.kL) {
                        case 101: 
                        case 102: 
                        case 103: 
                        case 104: {
                            if (j2.fW == 2) {
                                b.a.e.e e2 = (b.a.e.e)j2;
                                if (e2.gb == this.kL - 100) {
                                    this.lh.byte().d(n4, 0);
                                    break;
                                }
                                this.lh.new().if("\u4e0d\u80fd\u88c5\u5907\u3016" + j2.a + "\u3017\u5230\u8be5\u4f4d\u7f6e", -65536);
                                break;
                            }
                            this.lh.new().if("\u4e0d\u80fd\u88c5\u5907\u8be5\u7269\u54c1\uff0c\u4e0d\u662f\u9632\u5177\u7c7b\u578b\uff1a" + j2.a, -65536);
                            break;
                        }
                        case 200: {
                            if (j2.fW == 1) {
                                this.lh.byte().d(n4, 0);
                                break;
                            }
                            this.lh.new().if("\u4e0d\u80fd\u88c5\u5907\u8be5\u7269\u54c1\uff0c\u4e0d\u662f\u6b66\u5668\u7c7b\u578b\uff1a" + j2.a, -65536);
                            break;
                        }
                        case 311: 
                        case 312: 
                        case 320: 
                        case 331: 
                        case 332: {
                            if (j2.fW == 3) {
                                y y2 = (y)j2;
                                if (y2.il == this.kL / 10 % 10) {
                                    this.lh.byte().if(n4, this.kL % 10);
                                    break;
                                }
                                this.lh.new().if("\u4e0d\u80fd\u88c5\u5907\u3016" + j2.a + "\u3017\u5230\u8be5\u4f4d\u7f6e", -65536);
                                break;
                            }
                            this.lh.new().if("\u4e0d\u80fd\u88c5\u5907\u8be5\u7269\u54c1\uff0c\u4e0d\u662f\u9970\u54c1\u7c7b\u578b\uff1a" + j2.a, -65536);
                            break;
                        }
                        case 401: {
                            if (j2.fW == 6) {
                                this.lh.byte().d(n4, 0);
                                break;
                            }
                            this.lh.new().if("\u4e0d\u80fd\u88c5\u5907\u8be5\u7269\u54c1\uff0c\u4e0d\u662f\u65f6\u88c5\u7c7b\u578b\uff1a" + j2.a, -65536);
                            break;
                        }
                        default: {
                            this.lh.byte().f(n4, this.kL);
                        }
                    }
                }
            }
        } else if (a10 == this.lh.c().V()) {
            this.lh.c().V().cH();
        } else if (a10 == this.lh.c().ak()) {
            this.lh.c().ak().cr();
        } else if (a10 == this.lh.c().ax()) {
            this.lh.c().ax().cx();
        } else if (a10 == this.lh.c().aw()) {
            this.lh.c().aw().c2();
        } else if (a10 == this.lh.c().X().b4()) {
            a10.a();
        }
        Object var9_9 = null;
        try {
            if (this.kL == 342 && this.auraDragFrom >= 0 && this.auraDragItem != null && this.auraDragItem.getClass().getField("if").getInt(this.auraDragItem) == 1713059900) {
                Object object = this.lh.getClass().getMethod("byte", new Class[0]).invoke(this.lh, new Object[0]);
                object.getClass().getMethod("if", Integer.TYPE, Integer.TYPE).invoke(object, new Integer(this.auraDragFrom), new Integer(2));
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        this.auraDragFrom = -1;
        this.auraDragItem = null;
    }
}

