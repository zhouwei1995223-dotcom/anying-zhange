/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.s;
import a.b.z;
import b.a.c.b;
import b.a.c.b.al;
import b.a.c.b.bf;
import b.a.c.b.e;
import b.a.c.b.g;
import b.a.d.o;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ag
extends z
implements ActionListener {
    private static final int WIDTH = 232;
    private static final int HEIGHT = 300;
    private b ii;
    private int ie;
    private char[] il;
    private String[] ih;
    private int in = -1;
    private b.a.d.b im = new b.a.d.b();
    private s ig;
    private s io;
    int ik = 0;
    bf[] ij;

    public void try(a.a.e e2) {
        int n2 = e2.i();
        int n3 = 0;
        b.a.d.b b2 = new b.a.d.b();
        b.a.d.b[] bArray = this.ii.c().aj().cO();
        int[] nArray = this.ii.c().aj().cN();
        int n4 = 0;
        while (n4 < bArray.length) {
            if (bArray[n4].Z() == nArray[n4]) {
                b2 = bArray[n4];
            }
            ++n4;
        }
        if (this.ih == null) {
            this.ih = new String[b2.ac().length()];
            this.ih = a.a.b.a(b2.ac(), "$");
        }
        if (this.il == null) {
            this.il = new char[b2.ab().length()];
            b2.ab().getChars(0, this.il.length, this.il, 0);
        }
        o[] oArray = new o[this.ih.length];
        int n5 = 0;
        while (n5 < oArray.length) {
            oArray[n5] = new o();
            oArray[n5].try(this.ih[n5]);
            ++n5;
        }
        n5 = 0;
        while (n5 < n2) {
            o o2 = new o();
            o2.a(e2);
            oArray[o2.s() - 1].case(o2.r());
            oArray[o2.s() - 1].byte(o2.s());
            this.ik = n3 += o2.r();
            ++n5;
        }
        this.io.removeAll();
        n5 = 0;
        while (n5 < this.ih.length) {
            this.io.add(new a(oArray[n5], 120 + n5 * 40));
            ++n5;
        }
        this.ig.setVisible(false);
        this.io.setVisible(true);
    }

    public ag(b b2) {
        this.ii = b2;
        this.char(true);
        this.setVisible(false);
    }

    public void a(c c2) {
        e.a(c2, "\u6295\u7968", this.getWidth(), this.getHeight());
        if (this.ig.isVisible()) {
            c2.a("\u8bf7\u9009\u62e9\u4e00\u4e2a\u8fdb\u884c\u6295\u7968", 67, 45, Color.yellow.getRGB());
        }
        if (this.il != null) {
            this.do(this.il, c2, 3, 70, this.getWidth() - 10);
        }
        super.a(c2);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.startsWith("turn")) {
            this.setVisible(false);
            this.ii.c().aj().setVisible(true);
        } else if (string.startsWith("id")) {
            a.a.b.a(string, ":");
        }
    }

    public void byte(a.a.e e2) {
        int n2;
        this.im.a(e2);
        this.ie = this.im.Z();
        this.il = new char[this.im.ab().length()];
        this.im.ab().getChars(0, this.il.length, this.il, 0);
        this.ih = new String[this.im.ac().length()];
        this.ih = a.a.b.a(this.im.ac(), "$");
        if (this.ij != null) {
            n2 = 0;
            while (n2 < this.ij.length) {
                this.ig.remove(this.ij[n2]);
                ++n2;
            }
        }
        this.ij = new bf[this.ih.length];
        n2 = 0;
        while (n2 < this.ih.length) {
            this.ij[n2] = new bf();
            this.ij[n2].setBounds(3, 30 * n2 + 100, this.getWidth(), 18);
            this.ij[n2].case(this);
            this.ij[n2].y("id:" + (n2 + 1));
            this.ij[n2].z(this.ih[n2]);
            this.ij[n2].P(-1);
            this.ig.add(this.ij[n2]);
            ++n2;
        }
        this.io.setVisible(false);
        this.ig.setVisible(true);
    }

    public void cM() {
        this.setBounds(200, 50, 232, 300);
        this.add(new g(this.getWidth() - 23, 7, 15, 15));
        this.ig = new s();
        this.ig.setSize(232, 240);
        this.io = new s();
        this.io.setSize(232, 300);
        this.add(this.ig);
        this.add(this.io);
        al al2 = al.a(2, "\u8fd4\u56de", "turn", this, 93, 275, 50, 21);
        this.add(al2);
    }

    private void do(char[] cArray, c c2, int n2, int n3, int n4) {
        if (cArray == null) {
            return;
        }
        int n5 = cArray.length;
        int n6 = n2 + 24;
        int n7 = n3;
        int n8 = n4 + n2;
        int n9 = 0;
        while (n9 < n5) {
            c2.a(cArray[n9], n6, n7, this.in);
            n6 = cArray[n9] > '\u007f' ? (n6 += 12) : (n6 += 6);
            if (n6 >= n8) {
                n6 = n2;
                n7 += 14;
            }
            ++n9;
        }
    }

    private class a
    extends s {
        private o cP;
        private int y;

        a(o o2, int n2) {
            ag.this.getClass();
            this.cP = o2;
            this.y = n2;
            this.setVisible(true);
            this.setBounds(20, n2, 200, 150);
        }

        public void a(c c2) {
            if (this.cP != null) {
                c2.a(this.cP.t() + "  \u5f97\u7968\u6570 : " + this.cP.r() + " / " + ag.this.ik + " (" + (int)((float)this.cP.r() / (float)ag.this.ik * 100.0f) + "%)", 0, 0, Color.white.getRGB());
            } else {
                c2.a(this.cP.t() + "  \u5f97\u7968\u6570 : 0 / 0%", 0, 0, Color.white.getRGB());
            }
            super.a(c2);
        }
    }
}

