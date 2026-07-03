/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import b.a.c.b;
import b.a.c.b.bf;
import b.a.c.b.e;
import b.a.c.b.g;
import b.a.c.b.z;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class v
extends a.b.z
implements ActionListener {
    private b gB;
    private z gy;
    private String gE;
    private String gC;
    private String gD;
    private char[] gI;
    private int gJ = -1;
    private boolean gF;
    private long[] gK;
    private int gH;
    Calendar[] gA;
    Thread gG = null;
    private Date gz = new Date();

    public v(b b2) {
        this.gB = b2;
        this.char(true);
        this.setVisible(false);
        this.new();
    }

    public void a(c c2) {
        e.a(c2, "\u4eca\u65e5\u6d3b\u52a8\u5217\u8868", this.getWidth(), this.getHeight());
        if (this.gF) {
            if (Integer.parseInt(this.gC) < 10) {
                c2.a("\u6d3b\u52a8\u5f00\u59cb\u65f6\u95f4 : " + this.gE + ":0" + this.gC + "\u5206", 150, 65, Color.white.getRGB());
            } else {
                c2.a("\u6d3b\u52a8\u5f00\u59cb\u65f6\u95f4 : " + this.gE + ":" + this.gC + "\u5206", 150, 65, Color.white.getRGB());
            }
            c2.a("\u6d3b\u52a8\u6301\u7eed\u65f6\u95f4 : " + this.gD + "\u5206\u949f", 150, 85, Color.white.getRGB());
            c2.a("\u6d3b\u52a8\u5185\u5bb9 : ", 150, 105, Color.white.getRGB());
            this.if(this.gI, c2, 150, 130, 180);
        }
        super.a(c2);
    }

    public void l(String string) {
        String[] stringArray = a.a.b.a(string, ";");
        this.gE = stringArray[0];
        this.gC = stringArray[1];
        this.gD = stringArray[2];
        this.gI = new char[stringArray[3].length()];
        this.gH = Integer.parseInt(stringArray[4]);
        stringArray[3].getChars(0, this.gI.length, this.gI, 0);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string != null) {
            this.gF = true;
            this.l(string);
        }
    }

    public void int(a.a.e e2) {
        this.gy.bg();
        this.gF = false;
        int n2 = e2.i();
        this.gA = new Calendar[n2];
        this.gK = new long[n2];
        e2.g();
        int n3 = 0;
        while (n3 < n2) {
            String string = e2.byte();
            int n4 = e2.for();
            int n5 = e2.for();
            int n6 = e2.do();
            String string2 = e2.byte();
            bf bf2 = new bf();
            bf2.z(string);
            bf2.y(n4 + ";" + n5 + ";" + n6 + ";" + string2 + ";" + n3);
            bf2.case(this);
            bf2.P(-1);
            bf2.setBounds(4, 50 + n3 * 28, this.gy.getWidth() - 8, 18);
            this.gy.int(bf2);
            ++n3;
        }
    }

    public void cm() {
        this.gF = false;
        int n2 = 400;
        int n3 = 300;
        this.setBounds(120, 60, n2, n3);
        this.gy = new z();
        this.gy.setBounds(3, 30, 100, 240);
        this.gy.byte(true);
        this.add(this.gy);
        this.add(new g(this.getWidth() - 23, 7, 15, 15));
    }

    public void cl() {
        while (true) {
            if (this.gA == null) {
                continue;
            }
            int n2 = 0;
            while (n2 < this.gA.length) {
                this.gA[n2].add(13, -1);
                ++n2;
            }
            a.a.b.a(1000);
        }
    }

    private void if(char[] cArray, c c2, int n2, int n3, int n4) {
        if (cArray == null) {
            return;
        }
        int n5 = cArray.length;
        int n6 = n2 + 24;
        int n7 = n3;
        int n8 = n4 + n2;
        int n9 = 0;
        while (n9 < n5) {
            c2.a(cArray[n9], n6, n7, this.gJ);
            n6 = cArray[n9] > '\u007f' ? (n6 += 12) : (n6 += 6);
            if (n6 >= n8) {
                n6 = n2;
                n7 += 14;
            }
            ++n9;
        }
    }
}

