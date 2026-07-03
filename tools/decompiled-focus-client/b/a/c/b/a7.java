/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.a.h;
import a.b.c;
import a.b.d;
import a.b.n;
import a.b.s;
import b.a.c.b;
import b.a.c.b.a5;
import b.a.c.b.ae;
import b.a.c.b.al;
import b.a.c.b.as;
import b.a.c.b.at;
import b.a.c.b.ax;
import b.a.c.b.e;
import b.a.c.b.f;
import b.a.c.b.i;
import b.a.c.b.k;
import b.a.c.b.l;
import b.a.c.b.q;
import b.a.c.b.t;
import b.a.c.b.y;
import b.a.e.j;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

public class a7
extends s
implements ActionListener,
KeyListener {
    private static boolean mo;
    private static final String[] mn;
    private static final String[] ml;
    private static final String[] mk;
    private static final d[] mf;
    b mg;
    private y mh;
    private a[] mm = new a[12];
    private n mr;
    private n mq;
    private s mj;
    private h mp = new h(8);
    private int me;
    private long mi;

    public boolean M(int n2) {
        if (this.mm[n2] != null) {
            return this.mm[n2].l9 != -1;
        }
        return false;
    }

    public void dQ() {
        this.mh.bc();
    }

    public a7(b b2) {
        this.mg = b2;
    }

    public void keyTyped(KeyEvent keyEvent) {
    }

    public void keyPressed(KeyEvent keyEvent) {
    }

    public void a(c c2) {
        c2.if(e.aZ, 0, 0, 22, 12, this.getWidth(), 5);
        int n2 = this.getHeight() - 8;
        int n3 = 5;
        while (n3 < n2) {
            c2.if(e.aZ, 0, n3, 22, 21, this.getWidth(), 2);
            ++n3;
        }
        c2.if(e.aZ, 0, this.getHeight() - 8, 22, 31, this.getWidth(), 8);
        c2.a(3, 4, this.getWidth() - 5, this.getHeight() - 7, e.bi);
        n3 = this.mm[0].getY() - 4;
        int n4 = this.mm[0].getX() - 4;
        c2.if(e.aZ, n4, n3, 312, 156, 258, 32);
        n4 += 28;
        int n5 = (n3 += 4) + 24;
        int n6 = 0;
        do {
            c2.do(n4, n3, n4, n5, -16777216);
            n4 += 25;
        } while (++n6 < 9);
        c2.if(e.aZ, n4 += 20, n3 - 4, 312, 156, 52, 32);
        c2.do(n4 + 28, n3, n4 + 28, n5, -16777216);
        c2.if(e.aZ, n4 += 52, n3 - 4, 566, 156, 5, 32);
        super.a(c2);
    }

    private void u(String string) {
        String[] stringArray = a.a.b.a(string, " ");
        if (string.startsWith("/\u52a0\u7ecf\u9a8c ")) {
            int n2 = Integer.parseInt(stringArray[1]);
            this.mg.byte().Q(n2);
        } else if (string.startsWith("/\u52a0\u91d1\u5e01 ")) {
            int n3 = Integer.parseInt(stringArray[1]);
            this.mg.byte().try(n3);
        } else if (string.startsWith("/\u52a0\u7269\u54c1 ")) {
            int n4 = Integer.parseInt(stringArray[1]);
            this.mg.byte().void(n4);
        } else if (string.startsWith("/\u52a0\u5b9d\u7269 ")) {
            int n5 = Integer.parseInt(stringArray[1]);
            this.mg.byte().r(n5);
        } else if (string.startsWith("/\u98de\u8fc7\u53bb ")) {
            if (stringArray.length > 2) {
                this.mg.byte().int(Integer.parseInt(stringArray[1]), Integer.parseInt(stringArray[2]));
            } else {
                this.mg.byte().o(stringArray[1]);
            }
        } else if (string.startsWith("/\u62c9\u8fc7\u6765 ")) {
            this.mg.byte().g(stringArray[1]);
        } else if (string.startsWith("/\u516c\u544a ")) {
            int n6 = 0;
            if (stringArray.length > 2) {
                n6 = Integer.parseInt(stringArray[2], 16);
            }
            this.mg.byte().else(stringArray[1], n6);
        } else if (stringArray[0].equals("/\u8b66\u544a")) {
            int n7 = 0;
            if (stringArray.length > 2) {
                n7 = Integer.parseInt(stringArray[2], 16);
            }
            this.mg.byte().goto(stringArray[1], n7);
        } else if (stringArray[0].equals("/\u4fe1\u606f")) {
            int n8 = 0;
            if (stringArray.length > 2) {
                n8 = Integer.parseInt(stringArray[2], 16);
            }
            this.mg.byte().for(stringArray[1], n8);
        } else if (string.startsWith("/\u7ecf\u9a8c\u500d\u6570 ")) {
            this.mg.byte().ac(Integer.parseInt(stringArray[1]));
        } else if (string.startsWith("/\u91d1\u94b1\u500d\u6570 ")) {
            this.mg.byte().a(Integer.parseInt(stringArray[1]));
        } else if (string.startsWith("/\u7269\u54c1\u500d\u6570 ")) {
            this.mg.byte().g(Integer.parseInt(stringArray[1]));
        } else if (string.equals("/\u67e5\u8be2\u5143\u5b9d\u5145\u503c")) {
            this.mg.byte().c();
        } else if (string.equals("/\u67e5\u8be2\u5143\u5b9d\u6d88\u8d39")) {
            this.mg.byte().do();
        } else if (string.equals("/\u67e5\u8be2\u5e73\u5747\u5728\u7ebf")) {
            this.mg.byte().p("averageOnlineCount");
        } else if (string.startsWith("/\u67e5\u8be2\u53d8\u91cf ")) {
            this.mg.byte().p(stringArray[1]);
        } else if (string.startsWith("/\u51cf\u73a9\u5bb6\u91d1\u5e01 ")) {
            this.mg.byte().int(stringArray[1], Integer.parseInt(stringArray[2]));
        } else if (string.startsWith("/\u6e05\u73a9\u5bb6\u80cc\u5305 ")) {
            this.mg.byte().u(stringArray[1]);
        } else if (string.startsWith("/\u6e05\u73a9\u5bb6\u4ed3\u5e93 ")) {
            this.mg.byte().I(stringArray[1]);
        } else if (string.startsWith("/\u67e5\u73a9\u5bb6\u5bc6\u7801 ")) {
            this.mg.byte().do(stringArray[1]);
        } else if (string.startsWith("/\u6e05\u73a9\u5bb6\u88c5\u5907 ")) {
            this.mg.byte().new(stringArray[1]);
        } else if (string.startsWith("/\u52a0\u73a9\u5bb6\u7ecf\u9a8c ")) {
            this.mg.byte().case(stringArray[1], Integer.parseInt(stringArray[2]));
        } else if (stringArray[0].equals("/\u8e22\u5e10\u53f7")) {
            this.mg.byte().f(stringArray[1]);
        } else if (stringArray[0].equals("/\u67e5\u73a9\u5bb6\u4fe1\u606f")) {
            this.mg.byte().case(stringArray[1]);
        } else if (stringArray[0].equals("/\u52a0\u73a9\u5bb6\u5143\u5b9d")) {
            this.mg.byte().new(stringArray[1], Integer.parseInt(stringArray[2]));
        } else if (stringArray[0].equals("/\u51cf\u73a9\u5bb6\u5143\u5b9d")) {
            this.mg.byte().byte(stringArray[1], Integer.parseInt(stringArray[2]));
        } else if (stringArray[0].equals("/\u521b\u5efa\u602a\u7269")) {
            this.mg.byte().a(this.mg.for().void, this.mg.for().long, Integer.parseInt(stringArray[1]), Integer.parseInt(stringArray[2]), Integer.parseInt(stringArray[3]), 0);
        } else if (stringArray[0].equals("/\u4e00\u5b9a\u62c9\u8fc7\u6765\u554a")) {
            this.mg.byte().H(stringArray[1]);
        } else if (stringArray[0].equals("/\u521b\u5efa\u526f\u672c")) {
            this.mg.byte().s(Integer.parseInt(stringArray[1]));
        } else if (stringArray[0].equals("/\u8bbe\u7f6e\u573a\u666f\u53c2\u6570")) {
            this.mg.byte().long(stringArray[1], Integer.parseInt(stringArray[2]));
        } else if (stringArray[0].equals("/\u9690\u8eab")) {
            this.mg.byte().try();
        } else if (stringArray[0].equals("/\u8bbe\u7f6e\u7269\u54c1\u5143\u5b9d\u4ef7\u683c")) {
            this.mg.byte().a(Integer.parseInt(stringArray[1]), Integer.parseInt(stringArray[2]));
        } else if (stringArray[0].equals("/\u8bbe\u7f6e\u7269\u54c1\u91d1\u5e01\u4ef7\u683c")) {
            this.mg.byte().b(Integer.parseInt(stringArray[1]), Integer.parseInt(stringArray[2]));
        } else if (stringArray[0].equals("/\u8981\u6c42\u4e0b\u7ebf")) {
            int n9 = 0;
            if (stringArray.length > 1) {
                n9 = Integer.parseInt(stringArray[1]);
            }
            this.mg.byte().b(n9);
        } else if (stringArray[0].equals("/\u6392\u884c\u516c\u4f1a")) {
            this.mg.byte().long();
        } else if (stringArray[0].equals("/\u91cd\u8bbe\u73a9\u5bb6\u5c5e\u6027")) {
            this.mg.byte().F(stringArray[1]);
        } else if (stringArray[0].equals("/\u516c\u4f1a\u6807\u5fd7")) {
            b.a.d.h h2 = new b.a.d.h();
            h2.a = "\u516c\u4f1a\u6807\u5fd7";
            h2.r = 200;
            h2.Q = 70;
            h2.p = (int)(Math.random() * 6.0);
            h2.b1 = (int)(Math.random() * 10.0);
            h2.void = Integer.parseInt(stringArray[1]);
            h2.long = Integer.parseInt(stringArray[2]);
            h2.if = (int)(Math.random() * 100.0);
            this.mg.e().a(h2);
        } else if (stringArray[0].equals("/\u4fee\u6539\u7528\u6237\u5bc6\u7801")) {
            this.mg.byte().for(stringArray[1], stringArray[2]);
        } else if (stringArray[0].equals("/\u4fee\u6539\u89d2\u8272\u5bc6\u7801")) {
            this.mg.byte().do(stringArray[1], stringArray[2]);
        } else if (stringArray[0].equals("/\u9501\u5b9a\u7528\u6237")) {
            this.mg.byte().char(stringArray[1], Integer.parseInt(stringArray[2]));
        } else if (stringArray[0].equals("/\u9501\u5b9a\u89d2\u8272")) {
            this.mg.byte().try(stringArray[1], Integer.parseInt(stringArray[2]));
        } else if (stringArray[0].equals("/\u4fdd\u5b58\u4f20\u9001\u95e8")) {
            this.mg.byte().i();
        } else if (stringArray[0].equals("/\u4fdd\u5b58\u602a\u7269")) {
            this.mg.byte().e();
        } else if (stringArray[0].equals("/\u4fdd\u5b58NPC")) {
            this.mg.byte().q();
        } else if (!stringArray[0].equals("/\u8bbe\u7f6eGM")) {
            if (stringArray[0].equals("/\u52a0\u7279\u6548")) {
                int n10 = Integer.parseInt(stringArray[1]);
                int n11 = Integer.parseInt(stringArray[2]);
                this.mg.byte().do(n10, n11);
            } else if (stringArray[0].equals("/\u52a0\u73a9\u5bb6\u7279\u6548")) {
                String string2 = stringArray[1];
                int n12 = Integer.parseInt(stringArray[2]);
                int n13 = Integer.parseInt(stringArray[3]);
                this.mg.byte().a(string2, n12, n13);
            } else if (stringArray[0].equals("/\u67e5\u7528\u6237\u4fe1\u606f")) {
                this.mg.byte().h(stringArray[1]);
            } else if (stringArray[0].equals("/\u5f00\u59cb\u7ade\u6280")) {
                this.mg.byte().long("stateData", 1);
            } else if (stringArray[0].equals("/\u505c\u6b62\u7ade\u6280")) {
                this.mg.byte().long("stateData", 0);
            } else if (stringArray[0].equals("/\u6447\u6643")) {
                int n14 = Integer.parseInt(stringArray[1]);
                this.mg.j().dM().a(1, n14);
            } else if (stringArray[0].equals("/\u7070\u8272")) {
                int n15 = Integer.parseInt(stringArray[1]);
                this.mg.j().dM().a(2, n15);
            } else {
                this.mg.new().if("\u672a\u77e5\u7684GM\u6307\u4ee4\uff1a" + string, -65536);
            }
        }
    }

    public void dV() {
        this.repaint(this.mm[0].getX(), this.mm[0].getY(), 250, 24);
    }

    public void dS() {
        this.mr.requestFocus();
    }

    public void L(int n2) {
        b.a.d.k k2 = this.mg.for();
        this.mm[n2].z(k2.aI.fB[n2], k2.aI.fA[n2]);
    }

    public void a(int n2, char c2) {
        if (c2 >= '0' && c2 <= '9') {
            int n3 = c2 - 48 - 1;
            if (n3 < 0) {
                n3 = 9;
            }
            this.mm[n3].dN();
        }
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.equals("sendChat")) {
            this.dW();
        } else if (string.equals("shitu")) {
            as as2;
            as2.setVisible(!(as2 = this.mg.c().aE()).isVisible());
        } else if (string.equals("property")) {
            q q2;
            q2.setVisible(!(q2 = this.mg.c().ay()).isVisible());
        } else if (string.equals("bag")) {
            a5 a52;
            a52.setVisible(!(a52 = this.mg.c().aD()).isVisible());
        } else if (string.equals("skill")) {
            b.a.c.b.a a10;
            a10.setVisible(!(a10 = this.mg.c().aL()).isVisible());
        } else if (string.equals("task")) {
            k k2;
            ((Component)k2).setVisible(!(k2 = this.mg.c().aF()).isVisible());
        } else if (string.equals("guild")) {
            f f2;
            f2.setVisible(!(f2 = this.mg.c().X()).isVisible());
        } else if (string.equals("train")) {
            ax ax2;
            ax2.setVisible(!(ax2 = this.mg.c().am()).isVisible());
            if (ax2 != null) {
                ax2.new();
            }
        } else if (string.equals("friends")) {
            t t2;
            t2.setVisible(!(t2 = this.mg.c().W()).isVisible());
        } else if (string.equals("guaji")) {
            ae ae2;
            ((Component)ae2).setVisible(!(ae2 = this.mg.c().aH()).isVisible());
        } else if (string.equals("chooseChannel")) {
            this.a(mn, ml, this, this.mr.getX(), this.getHeight());
        } else if (string.startsWith("channel:")) {
            int n2 = string.charAt(string.length() - 1) - 48;
            ((a.b.q)this.mj.void()).do(mn[n2].substring(0, 2));
            this.mj.a(mk[n2]);
            this.mj.a(mf[n2]);
            this.mj.repaint();
            this.mq.setVisible(n2 == mk.length - 1);
            if (!this.mq.isVisible()) {
                this.mr.requestFocus();
            } else {
                this.mq.requestFocus();
            }
            if (mk[n2].equals("world") && !mo) {
                mo = true;
                this.mg.new().if("\u5728\u4e16\u754c\u9891\u9053\u804a\u5929\uff0c\u6bcf\u6b21\u9700\u8981\u6d88\u8017\u4e00\u4e2a\u5c0f\u5587\u53ed", -1);
            }
        } else if (string.equals("system")) {
            l l2;
            l2.setVisible(!(l2 = this.mg.c().az()).isVisible());
        }
    }

    public void keyReleased(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 38 && this.mp.for() > 0) {
            this.me = (this.me + 1) % this.mp.for();
            if (this.me >= 0 && this.me < this.mp.for()) {
                this.mr.if((String)this.mp.if(this.me));
            }
        } else if (keyEvent.getKeyCode() == 40 && this.mp.for() > 0) {
            this.me += -1;
            if (this.me < 0) {
                this.me = this.mp.for() - 1;
            }
            if (this.me >= 0 && this.me < this.mp.for()) {
                this.mr.if((String)this.mp.if(this.me));
            }
        } else if (keyEvent.getKeyCode() == 27) {
            if (this.mr.D().length() > 0) {
                this.mr.if("");
            } else {
                this.mg.j().requestFocus();
            }
        }
    }

    public void A(int n2, int n3) {
        int n4 = 0;
        while (n4 < this.mm.length) {
            if (this.mm[n4].l8 == n2) {
                this.mm[n4].l8 = n3;
            }
            ++n4;
        }
    }

    private void dW() {
        String string = this.mr.D();
        if (string.length() == 0) {
            this.mg.j().requestFocus();
            return;
        }
        long l2 = System.currentTimeMillis();
        String string2 = (String)this.mj.case();
        if (l2 > 0L && l2 - this.mi < 2000L && (string2.equals("area") || string2.equals("region")) && string.charAt(0) != '/') {
            this.mg.new().if("\u4f60\u53d1\u6d88\u606f\u7684\u901f\u5ea6\u592a\u5feb\u4e86\uff0c\u6b47\u6b47\u5427", -65536);
        } else {
            this.mi = l2;
            if (string.charAt(0) == '/' && this.mg.for().ao > 0) {
                this.u(string);
            } else {
                this.v(string);
            }
            this.mp.if(string);
            if (this.mp.for() > 8) {
                int n2 = this.mp.for();
                int n3 = 1;
                while (n3 < n2) {
                    Object object = this.mp.if(n3);
                    this.mp.a(n3 - 1, object);
                    ++n3;
                }
                this.mp.a(n2 - 1);
            }
            this.me = this.mp.for() - 2;
            this.mr.if("");
        }
    }

    private void v(String string) {
        string = this.mg.int(string);
        String string2 = (String)this.mj.case();
        if (string2.equals("area")) {
            this.mg.byte().try(string);
        } else if (string2.equals("region")) {
            this.mg.byte().c(string);
        } else if (string2.equals("world")) {
            this.mg.byte().int(string);
        } else if (string2.equals("team")) {
            if (!this.mg.c().ae().bm() && this.mg.for().ao == 0) {
                this.mg.new().if("\u4f60\u8fd8\u6ca1\u6709\u961f\u4f0d\u5440\uff0c\u4e0d\u80fd\u5728\u8fd9\u4e2a\u9891\u9053\u804a\u5929\uff01", -16711681);
                return;
            }
            this.mg.byte().K(string);
        } else if (string2.equals("guild")) {
            this.mg.byte().s(string);
        } else if (string2.equals("whisper")) {
            if (this.mq.D().length() == 0) {
                this.mg.new().if("\u4f60\u8fd8\u6ca1\u8f93\u5165\u5bc6\u8bed\u5bf9\u8c61\u73a9\u5bb6\u7684\u540d\u5b57\u5440\uff01", -16711681);
                this.mq.requestFocus();
                return;
            }
            if (this.mq.D().equals(this.mg.for().a)) {
                this.mg.new().if("\u81ea\u5df1\u8ddf\u81ea\u5df1\u804a\u5929\u6709\u4ec0\u4e48\u610f\u601d\u5440\uff1f", -16711681);
                this.mq.requestFocus();
                return;
            }
            this.mg.c().aB().T().void("whisper").a("\u4f60\u5bf9", 0, this.mq.D(), 0, "\u8bf4\uff1a" + string);
            this.mg.byte().if(this.mq.D(), string);
        }
    }

    static {
        mn = new String[]{"\u533a\u57df\u9891\u9053", "\u573a\u666f\u9891\u9053", "\u4e16\u754c\u9891\u9053", "\u961f\u4f0d\u9891\u9053", "\u516c\u4f1a\u9891\u9053", "\u5bc6\u804a\u9891\u9053"};
        ml = new String[]{"channel:0", "channel:1", "channel:2", "channel:3", "channel:4", "channel:5"};
        mk = new String[]{"area", "region", "world", "team", "guild", "whisper"};
        mf = new d[]{new d("\u804a\u5929\u6d88\u606f\u53ea\u53d1\u9001\u7ed9\u5c4f\u5e55\u533a\u57df\u5185\u7684\u73a9\u5bb6"), new d("\u804a\u5929\u6d88\u606f\u4f1a\u53d1\u9001\u7ed9\u6240\u6709\u672c\u573a\u666f\u7684\u73a9\u5bb6"), new d("\u804a\u5929\u6d88\u606f\u4f1a\u53d1\u9001\u7ed9\u6574\u4e2a\u6e38\u620f\u4e16\u754c\u7684\u73a9\u5bb6\uff0c\u6bcf\u6b21\u6d88\u80171\u4e2a\u5143\u5b9d"), new d("\u804a\u5929\u6d88\u606f\u4f1a\u53d1\u9001\u7ed9\u4f60\u6240\u5728\u961f\u4f0d\u7684\u5176\u4ed6\u73a9\u5bb6"), new d("\u804a\u5929\u6d88\u606f\u4f1a\u53d1\u9001\u7ed9\u4f60\u6240\u5728\u516c\u4f1a\u7684\u5176\u4ed6\u73a9\u5bb6"), new d("\u804a\u5929\u6d88\u606f\u53ea\u53d1\u9001\u7ed9\u4f60\u9009\u62e9\u5bc6\u8bed\u7684\u5bf9\u8c61")};
    }

    public a[] dT() {
        return this.mm;
    }

    public void dU() {
        int n2;
        this.mh = new y(this.mg.for());
        this.mh.setBounds(14, 9, 200, 26);
        this.add(this.mh);
        this.mh.bc();
        String[] stringArray = new String[]{"\u5c5e\u6027", "\u80cc\u5305", "\u6280\u80fd", "\u4efb\u52a1", "\u516c\u4f1a", "\u597d\u53cb", "\u5e08\u5f92", "\u6302\u673a", "\u4fee\u70bc", "\u7cfb\u7edf"};
        String[] stringArray2 = new String[]{"property", "bag", "skill", "task", "guild", "friends", "shitu", "guaji", "train", "system"};
        int n3 = 0;
        while (n3 < stringArray2.length) {
            n2 = 13 + n3 * 62;
            int n4 = 40;
            al al2 = al.a(1, stringArray[n3], stringArray2[n3], this, n2, n4, 58, 24);
            this.add(al2);
            ++n3;
        }
        b.a.d.k k2 = this.mg.for();
        n2 = 0;
        do {
            this.mm[n2] = new a(n2);
            this.mm[n2].setBounds(196 + n2 * 25, 8, 24, 24);
            this.mm[n2].z(k2.aI.fB[n2], k2.aI.fA[n2]);
            this.add(this.mm[n2]);
        } while (++n2 < 10);
        this.mm[10] = new a(10);
        this.mm[10].setBounds(470, 8, 24, 24);
        this.mm[10].z(k2.aI.fB[10], k2.aI.fA[10]);
        this.add(this.mm[10]);
        this.mm[11] = new a(11);
        this.mm[11].setBounds(495, 8, 24, 24);
        this.mm[11].z(k2.aI.fB[11], k2.aI.fA[11]);
        this.add(this.mm[11]);
        this.mr = new n();
        this.mr.else(50);
        this.mr.do("sendChat");
        this.mr.for(this);
        this.mr.setBounds(636, 44, 330, 18);
        this.mr.goto(-16777216);
        this.mr.a(new a.b.l(-4539718));
        this.mr.char(-16777216);
        this.mr.addKeyListener(this);
        al al3 = new al();
        al3.setBounds(this.mr.getX(), this.mr.getY() - 26, 58, 24);
        al3.else("\u9891\u9053");
        al3.char("chooseChannel");
        al3.try(this);
        this.add(al3);
        this.mj = new s();
        this.mj.a(24);
        this.mj.a(this.mr.try());
        this.mj.if(new a.b.q("\u533a\u57df", -16777216));
        this.mj.a("area");
        this.mj.a(mf[0]);
        this.mj.setBounds(al3.getX() + al3.getWidth() + 4, al3.getY() + 3, 44, 18);
        this.add(this.mj);
        this.mq = new n();
        this.mq.else(16);
        this.mq.do("sendChat");
        this.mq.for(this);
        this.mq.setBounds(this.mr.getX() + this.mr.getWidth() - 112, this.mj.getY(), 112, 18);
        this.mq.goto(-16777216);
        this.mq.a(this.mj.try());
        this.mq.char(-16777216);
        this.mq.setVisible(false);
        this.add(this.mq);
        this.add(this.mr);
    }

    public void dR() {
        int n2 = 0;
        while (n2 < this.mm.length) {
            this.mm[n2].dO();
            ++n2;
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    private class a
    extends s
    implements a.b.i,
    a.b.a {
        int ma;
        char md;
        int l9;
        int mc;
        int l8;
        i mb;

        void int(j j2) {
            this.dP();
            b b2 = a7.this.mg;
            this.l9 = j2.if;
            this.mc = b2.for().bA.d(this.l9);
            this.mb.a(j2);
        }

        void if(b.a.e.f f2) {
            this.dP();
            this.l8 = f2.if;
            this.mb.a(f2);
        }

        void z(int n2, int n3) {
            b.a.e.f f2;
            this.dP();
            b b2 = a7.this.mg;
            b.a.d.k k2 = b2.for();
            if (n3 == 1) {
                int n4 = k2.bA.f(n2);
                if (n4 >= 0) {
                    j j2 = k2.bA.fr[n4];
                    this.int(j2);
                }
            } else if (n3 == 2 && (f2 = k2.aw.long(n2)) != null) {
                this.if(f2);
            }
            this.repaint();
        }

        public a(int n2) {
            a7.this.getClass();
            this.l9 = -1;
            this.l8 = -1;
            this.ma = n2;
            this.md = (char)((n2 + 1) % 10 + 48);
            this.mb = new i();
            this.enableEvents(16L);
        }

        public void a() {
        }

        public void a(c c2) {
            super.a(c2);
            if (this.mb.char()) {
                this.mb.a(c2, 0, 0, 0, 0);
                if (this.l9 > 0 && this.mc > 0) {
                    if (this.mc < 10) {
                        c2.a((char)(48 + this.mc), 17, 12, -1);
                    } else {
                        c2.a((char)(48 + this.mc / 10), 11, 12, -1);
                        c2.a((char)(48 + this.mc % 10), 17, 12, -1);
                    }
                }
            } else if (this.ma == 10) {
                c2.a('\u8840', 6, 6, -65536);
            } else if (this.ma == 11) {
                c2.a('\u84dd', 6, 6, -16776961);
            } else {
                c2.a(this.md, 9, 6, 0xFFFFFF);
            }
        }

        protected void processMouseEvent(MouseEvent mouseEvent) {
            if (mouseEvent.getID() == 501) {
                if (mouseEvent.getModifiers() == 16 && this.mb.char()) {
                    this.a(this.mb, this, mouseEvent.getX(), mouseEvent.getY());
                } else if (mouseEvent.getModifiers() == 4) {
                    this.dN();
                }
                this.a((Rectangle)null, (a.b.b)null, 0, 0);
            } else if (mouseEvent.getID() == 504) {
                if (this.mb.char()) {
                    at at2 = at.b();
                    if (this.mb.case() != null) {
                        at2.a(this.mb.case(), false, false, 0, 0, true);
                        this.a(null, at2, mouseEvent.getX(), mouseEvent.getY());
                    } else if (this.mb.goto() != null) {
                        at2.a(this.mb.goto(), false);
                        this.a(null, at2, mouseEvent.getX(), mouseEvent.getY());
                    }
                }
            } else if (mouseEvent.getID() == 505) {
                this.a((Rectangle)null, (a.b.b)null, 0, 0);
            }
            super.processMouseEvent(mouseEvent);
        }

        public Object if() {
            return null;
        }

        void dO() {
            b b2 = a7.this.mg;
            b.a.d.k k2 = b2.for();
            if (this.l9 > 0) {
                this.mc = k2.bA.d(this.l9);
                if (this.mc <= 0) {
                    this.dP();
                    b2.byte().try(this.ma, this.l9, this.l8);
                }
                this.repaint();
            } else if (this.l8 > 0 && k2.aw.long(this.l8) == null) {
                this.dP();
                b2.byte().try(this.ma, this.l9, this.l8);
            }
        }

        public void do() {
            this.dP();
            a7.this.mg.byte().try(this.ma, 0, 0);
        }

        void dN() {
            if (this.ma >= 10) {
                return;
            }
            b b2 = a7.this.mg;
            if (this.l9 > 0) {
                b2.byte().d(-1, this.l9);
            } else if (this.l8 > 0) {
                b2.e().if(b2.for().aw.long(this.l8));
            }
        }

        void dP() {
            this.l8 = -1;
            this.l9 = -1;
            this.mb.a((j)null);
            this.mb.a((b.a.e.f)null);
        }

        public void a(a.b.a a10, int n2, int n3) {
            b b2 = a7.this.mg;
            if (a10 == b2.c().aD()) {
                j j2 = (j)a10.if();
                if (j2.fW == 0 || j2.fW == 5) {
                    int n4 = b2.for().bA.f(j2.if);
                    j2 = b2.for().bA.fr[n4];
                    if (this.ma < 10) {
                        this.int(j2);
                        b2.byte().try(this.ma, this.l9, this.l8);
                    } else if (j2.fW == 5) {
                        b.a.e.t t2 = (b.a.e.t)j2;
                        if (t2.hg == 31 && this.ma == 10) {
                            this.int(j2);
                            b2.byte().try(this.ma, this.l9, this.l8);
                        } else if (t2.hg == 32 && this.ma == 11) {
                            this.int(j2);
                            b2.byte().try(this.ma, this.l9, this.l8);
                        }
                    } else {
                        b2.new().if("\u4e0d\u80fd\u5728\u8be5\u4f4d\u7f6e\u653e\u5165\u8be5\u7269\u54c1\u7684\u5feb\u6377\u65b9\u5f0f", -65536);
                    }
                }
            } else if (a10 == b2.c().aL()) {
                if (this.ma < 10) {
                    b.a.e.f f2 = (b.a.e.f)a10.if();
                    this.if(f2);
                    b2.byte().try(this.ma, this.l9, this.l8);
                } else {
                    b2.new().if("\u4e0d\u80fd\u5728\u8be5\u4f4d\u7f6e\u653e\u5165\u8be5\u6280\u80fd\u7684\u5feb\u6377\u65b9\u5f0f", -65536);
                }
            } else if (a10 instanceof a) {
                a a11 = (a)a10;
                if (this.ma < 10 && a11.ma < 10) {
                    int n5 = this.l9;
                    int n6 = this.l8;
                    int n7 = this.mc;
                    i i2 = this.mb;
                    this.l9 = a11.l9;
                    this.mc = a11.mc;
                    this.l8 = a11.l8;
                    this.mb = a11.mb;
                    a11.l9 = n5;
                    a11.mc = n7;
                    a11.l8 = n6;
                    a11.mb = i2;
                    b2.byte().try(this.ma, this.l9, this.l8);
                    b2.byte().try(a11.ma, a11.l9, a11.l8);
                }
            }
        }
    }
}

