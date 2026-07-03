/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.q;
import a.b.s;
import b.a.c.b;
import b.a.c.b.al;
import b.a.c.b.e;
import b.a.c.b.g;
import b.a.c.b.z;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ao
extends a.b.z
implements ActionListener {
    static final int[] i6 = new int[]{86, 98, 76, 26, 38, 38};
    static final String[] i2 = new String[]{"\u67e5\u770b\u4fe1\u606f", "\u7533\u8bf7\u52a0\u5165", "\u8bbe\u7f6e\u654c\u5bf9", "\u590d\u5236\u540d\u5b57"};
    static final String[] i1 = new String[]{"view", "join", "enemy", "copyName"};
    static final String[] i0 = new String[]{"\u7533\u8bf7\u52a0\u5165", "\u67e5\u770b\u4fe1\u606f", "\u66f4\u6539\u540d\u5b57", "\u5220\u9664\u516c\u4f1a"};
    static final String[] i4 = new String[]{"join", "view", "setName", "delete"};
    b iZ;
    private z iX;
    private String i5 = "";
    private int i3;
    a iY;

    public void char(a.a.e e2) {
        this.iX.bg();
        int n2 = e2.j();
        this.i3 = e2.for();
        this.i5 = "\u516c\u4f1a\u5217\u8868[\u603b\u5171" + n2 + "\u4e2a\u516c\u4f1a\uff0c\u5f53\u524d\u7b2c" + (this.i3 + 1) + "\u9875]";
        while (e2.if() > 0) {
            a a10 = new a(e2);
            this.iX.a(a10, 0, 0, 0);
        }
        this.setVisible(true);
    }

    public ao(b b2) {
        this.iZ = b2;
        this.char(true);
        this.setVisible(false);
    }

    public void a(c c2) {
        e.a(c2, this.i5, this.getWidth(), this.getHeight());
        c2.do(4, this.iX.getY() - 1, this.getWidth() - 4, this.iX.getY() - 1, -3750223);
        super.a(c2);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.equals("prev") && this.i3 > 0) {
            this.iZ.byte().o(this.i3 - 1);
        } else if (string.equals("next")) {
            this.iZ.byte().o(this.i3 + 1);
        } else if (string.equals("view")) {
            this.iZ.byte().J(this.iY.dl);
        } else if (string.equals("join")) {
            if (this.iZ.for().ak == null) {
                this.iZ.void().a("\u8bf7\u8f93\u5165\u4e00\u6bb5\u4f60\u60f3\u8868\u8fbe\u7ed9\u8be5\u516c\u4f1a\u4f1a\u957f\u7684\u7533\u8bf7\u4fe1\u606f\u7684\u6587\u5b57", "okJoin", this);
            } else {
                this.iZ.new().if("\u4f60\u5df2\u7ecf\u6709\u516c\u4f1a\u4e86", 0xFF0000);
            }
        } else if (string.equals("okJoin")) {
            this.iZ.byte().a(this.iY.dl, this.iZ.void().cK());
        } else if (string.equals("enemy")) {
            if (this.iZ.for().ak == null) {
                this.iZ.new().if("\u4f60\u8fd8\u6ca1\u6709\u516c\u4f1a\uff01", 0xFF0000);
            } else {
                this.iZ.byte().N(this.iY.dl);
            }
        } else if (string.equals("copyName")) {
            a.a.b.if(this.iY.getName());
        } else if (string.equals("setName")) {
            this.iZ.void().a("\u8bf7\u8f93\u5165\u4f60\u8981\u4e3a\u8be5\u516c\u4f1a\u8bbe\u7f6e\u7684\u65b0\u540d\u5b57\uff1a", "yesSetName", this);
        } else if (string.equals("yesSetName")) {
            String string2 = this.iZ.void().cK();
            int n2 = q.if(string2);
            if (n2 < 24 || n2 > 96) {
                this.iZ.new().if("\u540d\u5b57\u5fc5\u987b\u662f2-7\u4e2a\u6c49\u5b57", 0xFF0000);
            } else {
                this.iZ.byte().if(this.iY.dl, string2);
            }
        } else if (string.equals("delete")) {
            this.iZ.new().if("\u4f60\u786e\u5b9a\u3001\u80af\u5b9a\u3001\u4e00\u5b9a\u8981\u5220\u9664\u8fd9\u4e2a\u516c\u4f1a\u5417\uff1f\u6ce8\u610f\uff0c\u5220\u9664\u4e4b\u540e\u5c06\u4e0d\u53ef\u6062\u590d\uff01", -65281, "yesDelete", "", this);
        } else if (string.equals("yesDelete")) {
            this.iZ.byte().n(this.iY.dl);
        }
    }

    public void cX() {
        int n2 = 384;
        int n3 = 300;
        this.setBounds(130, 100, n2, n3);
        g g2 = new g();
        g2.setBounds(this.getWidth() - 23, 7, 15, 15);
        this.add(g2);
        s s2 = new s();
        s2.setBounds(4, 32, this.getWidth() - 8, 12);
        String[] stringArray = new String[]{"\u516c\u4f1a\u540d\u79f0", "\u4f1a\u957f\u540d\u5b57", "\u521b\u5efa\u65e5\u671f", " \u7b49\u7ea7", "\u58f0\u671b", "\u6210\u5458\u6570"};
        int n4 = 0;
        int n5 = 0;
        while (n5 < stringArray.length) {
            s s3 = new s();
            s3.if(new q(stringArray[n5], -527356));
            s3.a(8);
            s3.setBounds(n4, 0, i6[n5], 12);
            s2.add(s3);
            n4 += i6[n5];
            ++n5;
        }
        this.add(s2);
        this.iX = new z();
        this.iX.setBounds(4, 50, this.getWidth() - 8, 220);
        this.add(this.iX);
        this.add(al.a(2, "\u4e0a\u9875", "prev", this, 8, this.getHeight() - 25, 44, 19));
        this.add(al.a(2, "\u4e0b\u9875", "next", this, 56, this.getHeight() - 25, 44, 19));
    }

    private class a
    extends s {
        int dl;
        String dn;
        private boolean dm;

        a(a.a.e e2) {
            ao.this.getClass();
            this.dn = "";
            this.setSize(0, 20);
            this.enableEvents(16L);
            this.dl = e2.i();
            String string = e2.h();
            this.setName(string);
            String string2 = e2.h();
            String string3 = a.a.b.a(a.a.b.do(e2.i()), " ")[0];
            String string4 = String.valueOf(e2.for());
            String string5 = String.valueOf(e2.i());
            String string6 = String.valueOf(e2.for());
            String[] stringArray = new String[]{string, string2, string3, string4, string5, string6};
            int n2 = 0;
            int n3 = 0;
            while (n3 < stringArray.length) {
                s s2 = new s();
                s2.if(new q(stringArray[n3], 0xFFFFFF));
                s2.a(8);
                s2.setBounds(n2, 4, i6[n3], 12);
                this.add(s2);
                n2 += i6[n3];
                ++n3;
            }
        }

        public void a(c c2) {
            if (this.dm) {
                c2.a(0, 0, this.getWidth(), this.getHeight(), -12017997);
            }
            super.a(c2);
        }

        protected void processMouseEvent(MouseEvent mouseEvent) {
            if (mouseEvent.getID() == 504) {
                this.dm = true;
                this.repaint();
            } else if (mouseEvent.getID() == 505) {
                this.dm = false;
                this.repaint();
            } else if (mouseEvent.getID() == 501 && mouseEvent.getModifiers() == 4) {
                ao.this.iY = this;
                if (ao.this.iZ.for().ao > 1) {
                    this.a(i0, i4, ao.this, mouseEvent.getX(), mouseEvent.getY());
                } else {
                    this.a(i2, i1, ao.this, mouseEvent.getX(), mouseEvent.getY());
                }
            }
        }
    }
}

