/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.a.h;
import a.b.c;
import a.b.q;
import a.b.s;
import b.a.c.b;
import b.a.c.b.al;
import b.a.c.b.e;
import b.a.c.b.g;
import b.a.c.b.z;
import b.a.d.d;
import b.a.d.k;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class t
extends a.b.z
implements ActionListener {
    static final String[] gh = new String[]{"\u5237\u65b0", "\u5bc6\u8bed", "\u7ec4\u961f", "\u5220\u9664", "\u8bbe\u4e3a\u4ec7\u4eba", "\u52a0\u5165\u9ed1\u540d\u5355", "\u67e5\u770b\u4fe1\u606f"};
    static final String[] ga = new String[]{"refresh", "whisper", "teamInvite", "delete", "moveToEnemy", "moveToBlack", "view"};
    static final String[] gg = new String[]{"\u5237\u65b0", "\u5bc6\u8bed", "\u5220\u9664", "\u52a0\u4e3a\u597d\u53cb", "\u52a0\u5165\u9ed1\u540d\u5355", "\u67e5\u770b\u4fe1\u606f"};
    static final String[] f9 = new String[]{"refresh", "whisper", "delete", "moveToFriend", "moveToBlack", "view"};
    static final String[] ge = new String[]{"\u5237\u65b0", "\u5bc6\u8bed", "\u5220\u9664", "\u52a0\u4e3a\u597d\u53cb", "\u8bbe\u4e3a\u4ec7\u4eba", "\u67e5\u770b\u4fe1\u606f"};
    static final String[] f7 = new String[]{"refresh", "whisper", "delete", "moveToFriend", "moveToEnemy", "view"};
    b f3;
    private String gb = "\u597d\u53cb\u5217\u8868";
    private a.a.q gd = new a.a.q(100);
    private z gc;
    private h f8 = new h(50);
    private z f4;
    private h f6 = new h(20);
    private z gf;
    private h f5 = new h(20);
    a f2;

    private void ci() {
        b.a.e.s s2 = this.f3.for().ax;
        this.gf.bg();
        this.f5.a();
        int n2 = 0;
        while (n2 < s2.jR) {
            a a10 = new a(s2.jT[n2], 3);
            a10.setSize(360, 20);
            String[] stringArray = (String[])this.gd.for(a10.cw);
            if (stringArray != null) {
                a10.cC = stringArray[1];
                a10.cx = stringArray[2];
                a10.cz = stringArray[3];
                a10.cA = stringArray[4];
            }
            this.gf.a(a10, 0, 0, 0);
            this.f5.if(a10);
            ++n2;
        }
    }

    public void k(String string) {
        k k2 = this.f3.for();
        if (k2.ax.g(string)) {
            this.f3.new().if("\u5bf9\u65b9\u5df2\u7ecf\u5728\u4f60\u7684\u9ed1\u540d\u5355\u91cc\u4e86", -65536);
        } else if (k2.ax.h(string)) {
            this.f3.new().if("\u5bf9\u65b9\u662f\u4f60\u7684\u597d\u53cb\uff0c\u4e0d\u80fd\u52a0\u5165\u9ed1\u540d\u5355", -65536);
        } else if (k2.ax.jR >= k2.ax.jT.length) {
            this.f3.new().if("\u4f60\u7684\u9ed1\u540d\u5355\u5df2\u7ecf\u5230\u8fbe\u4e0a\u9650\u4e86", -65536);
        } else {
            k2.ax.f(string);
            a a10 = new a(string, 3);
            a10.setSize(360, 20);
            this.gf.a(a10, 0, 0, 0);
            this.f5.if(a10);
            this.f3.byte().t(string);
            this.f3.goto().int("\u4f60\u628a[" + string + "]\u52a0\u5165\u9ed1\u540d\u5355", -1895825408, -16711936);
        }
    }

    public t(b b2) {
        this.f3 = b2;
        this.char(true);
        this.setVisible(false);
    }

    public void a(int n2, String string) {
        k k2 = this.f3.for();
        switch (n2) {
            case 1: {
                k2.ax.b(string);
                this.cg();
                this.f3.byte().byte(string);
                break;
            }
            case 2: {
                k2.ax.c(string);
                this.ch();
                this.f3.byte().if(string);
                break;
            }
            case 3: {
                k2.ax.else(string);
                this.ci();
                this.f3.byte().i(string);
                break;
            }
        }
    }

    public void a(c c2) {
        e.a(c2, this.gb, this.getWidth(), this.getHeight());
        super.a(c2);
        c2.do(4, 50, this.getWidth() - 4, 50, -3750223);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.equals("friends") && !this.gc.isVisible()) {
            this.gb = "\u597d\u53cb\u5217\u8868";
            this.gc.setVisible(true);
            this.f4.setVisible(false);
            this.gf.setVisible(false);
        } else if (string.equals("enemies") && !this.f4.isVisible()) {
            this.gb = "\u4ec7\u4eba\u5217\u8868";
            this.gc.setVisible(false);
            this.f4.setVisible(true);
            this.gf.setVisible(false);
        } else if (string.equals("blacklist") && !this.gf.isVisible()) {
            this.gc.setVisible(false);
            this.f4.setVisible(false);
            this.gf.setVisible(true);
            this.gb = "\u9ed1\u540d\u5355";
        } else if (string.equals("refresh")) {
            this.f3.byte().else(this.f2.cw);
        } else if (string.equals("whisper")) {
            this.f3.c().ag().t(this.f2.cw);
        } else if (string.equals("delete")) {
            this.a(this.f2.cy, this.f2.cw);
        } else if (string.equals("moveToFriend")) {
            String string2 = this.f2.cw;
            this.a(this.f2.cy, string2);
            this.j(string2);
        } else if (string.equals("moveToBlack")) {
            String string3 = this.f2.cw;
            if (this.f2.cy == 1) {
                this.a(this.f2.cy, string3);
            }
            this.k(string3);
        } else if (string.equals("moveToEnemy")) {
            String string4 = this.f2.cw;
            if (this.f2.cy == 1) {
                this.a(this.f2.cy, this.f2.cw);
            }
            this.i(string4);
        } else if (string.equals("view")) {
            this.f3.byte().case(this.f2.cw);
        }
    }

    public void j(String string) {
        k k2 = this.f3.for();
        if (k2.ax.h(string)) {
            this.f3.new().if("\u5bf9\u65b9\u5df2\u7ecf\u662f\u4f60\u7684\u597d\u53cb\u4e86", -65536);
        } else if (k2.ax.case(string)) {
            this.f3.new().if("\u4f60\u4e0d\u80fd\u628a\u81ea\u5df1\u7684\u4ec7\u4eba\u52a0\u4e3a\u597d\u53cb", -65536);
        } else if (k2.ax.g(string)) {
            this.f3.new().if("\u5bf9\u65b9\u5728\u4f60\u7684\u9ed1\u540d\u5355\u91cc\uff0c\u4e0d\u80fd\u52a0\u4e3a\u597d\u53cb", -65536);
        } else if (k2.ax.jM >= k2.ax.jU.length) {
            this.f3.new().if("\u4f60\u7684\u597d\u53cb\u5217\u8868\u5df2\u7ecf\u5230\u8fbe\u4e0a\u9650\u4e86", -65536);
        } else {
            k2.ax.e(string);
            a a10 = new a(string, 1);
            a10.setSize(360, 20);
            this.gc.a(a10, 0, 0, 0);
            this.f8.if(a10);
            this.f3.byte().B(string);
            this.f3.goto().int("\u4f60\u628a[" + string + "]\u52a0\u4e3a\u597d\u53cb", -1895825408, -16711936);
        }
    }

    public void a(String string, int n2, int n3, String string2, String string3) {
        a a10;
        String[] stringArray = new String[]{string, String.valueOf(n2), d.ap[n3], string2, string3};
        this.gd.a((Object)string, (Object)stringArray);
        int n4 = this.f8.for();
        int n5 = 0;
        while (n5 < n4) {
            a10 = (a)this.f8.if(n5);
            if (a10.cw.equals(string)) {
                a10.cC = stringArray[1];
                a10.cx = stringArray[2];
                a10.cz = string2;
                a10.cA = string3;
                a10.repaint();
                break;
            }
            ++n5;
        }
        n4 = this.f6.for();
        n5 = 0;
        while (n5 < n4) {
            a10 = (a)this.f6.if(n5);
            if (a10.cw.equals(string)) {
                a10.cC = stringArray[1];
                a10.cx = stringArray[2];
                a10.cz = string2;
                a10.cA = string3;
                a10.repaint();
                break;
            }
            ++n5;
        }
        n4 = this.f5.for();
        n5 = 0;
        while (n5 < n4) {
            a10 = (a)this.f5.if(n5);
            if (a10.cw.equals(string)) {
                a10.cC = stringArray[1];
                a10.cx = stringArray[2];
                a10.cz = string2;
                a10.cA = string3;
                a10.repaint();
                break;
            }
            ++n5;
        }
    }

    private void ch() {
        b.a.e.s s2 = this.f3.for().ax;
        this.f4.bg();
        this.f6.a();
        int n2 = 0;
        while (n2 < s2.jQ) {
            a a10 = new a(s2.jN[n2], 2);
            a10.setSize(360, 20);
            String[] stringArray = (String[])this.gd.for(a10.cw);
            if (stringArray != null) {
                a10.cC = stringArray[1];
                a10.cx = stringArray[2];
                a10.cz = stringArray[3];
                a10.cA = stringArray[4];
            }
            this.f4.a(a10, 0, 0, 0);
            this.f6.if(a10);
            ++n2;
        }
    }

    private void cg() {
        b.a.e.s s2 = this.f3.for().ax;
        this.f8.a();
        this.gc.bg();
        int n2 = 0;
        while (n2 < s2.jM) {
            a a10 = new a(s2.jU[n2], 1);
            a10.setSize(360, 20);
            String[] stringArray = (String[])this.gd.for(a10.cw);
            if (stringArray != null) {
                a10.cC = stringArray[1];
                a10.cx = stringArray[2];
                a10.cz = stringArray[3];
                a10.cA = stringArray[4];
            }
            this.gc.a(a10, 0, 0, 0);
            this.f8.if(a10);
            ++n2;
        }
    }

    public void cj() {
        int n2 = 384;
        int n3 = 342;
        this.setBounds(130, 60, n2, n3);
        g g2 = new g();
        g2.setBounds(this.getWidth() - 23, 7, 15, 15);
        this.add(g2);
        s s2 = new s();
        s2.setBounds(4, 30, this.getWidth() - 24, 20);
        String[] stringArray = new String[]{"\u540d\u5b57", "\u7b49\u7ea7", "\u804c\u4e1a", "\u516c\u4f1a", "\u4f4d\u7f6e"};
        int[] nArray = new int[]{4, 103, 133, 163, 263};
        int[] nArray2 = new int[]{100, 30, 30, 100, 100};
        int n4 = 0;
        do {
            s s3 = new s();
            s3.setBounds(nArray[n4], 4, nArray2[n4], 12);
            q q2 = new q(stringArray[n4], -527356);
            s3.if(q2);
            s2.add(s3);
        } while (++n4 < 5);
        this.add(s2);
        this.gc = new z();
        this.gc.setBounds(4, 50, n2 - 8, n3 - 80);
        this.add(this.gc);
        this.f4 = new z();
        this.f4.setVisible(false);
        this.f4.setBounds(4, 50, n2 - 8, n3 - 80);
        this.add(this.f4);
        this.gf = new z();
        this.gf.setVisible(false);
        this.gf.setBounds(4, 50, n2 - 8, n3 - 80);
        this.add(this.gf);
        this.cg();
        this.ch();
        this.ci();
        al al2 = al.a(2, "\u597d\u53cb", "friends", this, 6, this.getHeight() - 25, 44, 19);
        this.add(al2);
        al2 = al.a(2, "\u4ec7\u4eba", "enemies", this, 54, this.getHeight() - 25, 44, 19);
        this.add(al2);
        al2 = al.a(2, "\u9ed1\u540d\u5355", "blacklist", this, 102, this.getHeight() - 25, 54, 19);
        this.add(al2);
    }

    public void i(String string) {
        k k2 = this.f3.for();
        if (k2.ax.case(string)) {
            this.f3.new().if("\u5bf9\u65b9\u5df2\u7ecf\u662f\u4f60\u7684\u4ec7\u4eba\u4e86", -65536);
        } else if (k2.ax.h(string)) {
            this.f3.new().if("\u4f60\u4e0d\u80fd\u628a\u81ea\u5df1\u7684\u597d\u53cb\u8bbe\u4e3a\u4ec7\u4eba", -65536);
        } else if (k2.ax.jQ >= k2.ax.jN.length) {
            this.f3.new().if("\u4f60\u7684\u4ec7\u4eba\u5217\u8868\u5df2\u7ecf\u5230\u8fbe\u4e0a\u9650\u4e86", -65536);
        } else {
            k2.ax.goto(string);
            a a10 = new a(string, 2);
            a10.setSize(360, 20);
            this.f4.a(a10, 0, 0, 0);
            this.f6.if(a10);
            this.f3.byte().goto(string);
            this.f3.goto().int("\u4f60\u628a[" + string + "]\u8bbe\u4e3a\u4ec7\u4eba", -1895825408, -16711936);
        }
    }

    private class a
    extends s {
        int cy;
        String cw;
        String cC;
        String cx;
        String cz;
        String cA;
        boolean cB;

        public a(String string, int n2) {
            t.this.getClass();
            this.cw = "";
            this.cC = "-";
            this.cx = "-";
            this.cz = "-";
            this.cA = "-";
            this.cw = string;
            this.cy = n2;
            this.enableEvents(16L);
        }

        public void a(c c2) {
            if (this.cB) {
                c2.a(0, 0, this.getWidth(), this.getHeight(), -1894998535);
            }
            c2.a(this.cw, 2, 4, -1);
            c2.a(this.cC, 104, 4, -1);
            c2.a(this.cx, 134, 4, -1);
            c2.a(this.cz, 164, 4, -1);
            c2.a(this.cA, 264, 4, -1);
        }

        protected void processMouseEvent(MouseEvent mouseEvent) {
            if (mouseEvent.getID() == 504) {
                this.cB = true;
                this.repaint();
            } else if (mouseEvent.getID() == 505) {
                this.cB = false;
                this.repaint();
            } else if (mouseEvent.getID() == 501 && mouseEvent.getModifiers() == 4) {
                t.this.f2 = this;
                if (this.cy == 1) {
                    this.a(gh, ga, t.this, mouseEvent.getX(), mouseEvent.getY());
                } else if (this.cy == 2) {
                    this.a(gg, f9, t.this, mouseEvent.getX(), mouseEvent.getY());
                } else {
                    this.a(ge, f7, t.this, mouseEvent.getX(), mouseEvent.getY());
                }
            } else if (mouseEvent.getID() == 500 && mouseEvent.getClickCount() > 1) {
                t t2 = t.this;
                t2.f3.c().ag().t(this.cw);
            }
        }
    }
}

