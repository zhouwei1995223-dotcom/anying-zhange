/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.s;
import a.b.z;
import b.a.c.b;
import b.a.c.b.al;
import b.a.c.b.e;
import b.a.c.b.g;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class p
extends z
implements ActionListener {
    private char[] fV;
    private char[] fW;
    private int fU = -1;
    private int fT;
    private b fR;
    private s fS;

    public void a(String[] stringArray) {
        this.fT = Integer.parseInt(stringArray[0]);
        this.fV = new char[stringArray[2].length()];
        stringArray[2].getChars(0, this.fV.length, this.fV, 0);
        this.fW = new char[stringArray[3].length()];
        stringArray[3].getChars(0, this.fW.length, this.fW, 0);
        this.new();
        this.setVisible(true);
    }

    public p(b b2) {
        this.fR = b2;
    }

    public void a(c c2) {
        e.a(c2, "\u4efb\u52a1\u8bf4\u660e", this.getWidth(), this.getHeight());
        c2.a("\u4efb\u52a1\u8981\u6c42", 6, 36, 65535);
        this.a(this.fV, c2, 6, 56, this.getWidth() - 6);
        c2.a("\u4efb\u52a1\u5956\u52b1", 6, this.getHeight() / 2, 65535);
        this.a(this.fW, c2, 6, this.getHeight() / 2 + 20, this.getWidth() - 6);
        super.a(c2);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.equals("acceptTask")) {
            this.fR.byte().H(this.fT);
            this.setVisible(false);
        } else if (string.equals("shut")) {
            this.setVisible(false);
        }
    }

    public void ce() {
        int n2 = 254;
        int n3 = 281;
        this.setBounds(this.fR.c().aA().getX() + this.fR.c().aA().getWidth(), 40, n2, n3);
        this.char(true);
        this.add(new g(this.getWidth() - 23, 7, 15, 15));
        this.add(al.a(2, "\u63a5\u53d7", "acceptTask", this, 50, this.getHeight() - 25, 40, 19));
        this.add(al.a(2, "\u8fd4\u56de", "shut", this, 150, this.getHeight() - 25, 40, 19));
        this.setVisible(false);
    }

    private void a(char[] cArray, c c2, int n2, int n3, int n4) {
        if (cArray == null) {
            return;
        }
        int n5 = cArray.length;
        int n6 = n2 + 24;
        int n7 = n3;
        int n8 = 0;
        while (n8 < n5) {
            int n9 = 6;
            if (cArray[n8] > '\u007f') {
                n9 = 12;
            }
            if (n6 + n9 >= n4) {
                n6 = n2;
                n7 += 14;
            }
            c2.a(cArray[n8], n6, n7, this.fU);
            n6 += n9;
            ++n8;
        }
    }
}

