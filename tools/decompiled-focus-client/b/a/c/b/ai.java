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

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ai
extends a.b.z
implements ActionListener {
    private static final int WIDTH = 262;
    private static final int HEIGHT = 300;
    private b iq;
    private z ip;
    private int is;
    private int[] it;
    private b.a.d.b[] ir;

    public int[] cN() {
        return this.it;
    }

    public ai(b b2) {
        this.iq = b2;
        this.char(true);
        this.setVisible(false);
    }

    public void a(c c2) {
        e.a(c2, "\u6295\u7968\u5217\u8868", this.getWidth(), this.getHeight());
        c2.a("\u8bf7\u60a8\u9009\u62e9\u4e00\u4e2a\u60a8\u611f\u5174\u8da3\u7684\u9009\u9879\u8fdb\u884c\u6295\u7968", 28, 45, Color.yellow.getRGB());
        super.a(c2);
    }

    public void case(a.a.e e2) {
        this.ip.bg();
        this.is = e2.i();
        this.ir = new b.a.d.b[this.is];
        this.it = new int[this.is];
        int n2 = 0;
        while (n2 < this.is) {
            b.a.d.b b2 = new b.a.d.b();
            b2.a(e2);
            this.ir[n2] = b2;
            bf bf2 = new bf();
            if (this.ir[n2].aa()) {
                this.it[n2] = this.ir[n2].Z();
                bf2.z(this.ir[n2].Z() + "  " + this.ir[n2].X() + "(\u70b9\u51fb\u8fdb\u5165\u6295\u7968)");
                bf2.setBounds(20, 48 * n2 - 5, this.getWidth(), 18);
                bf2.case(this);
                bf2.y("show:" + this.ir[n2].Z());
                bf2.P(-1);
            } else {
                bf2.z(this.ir[n2].Z() + "  " + this.ir[n2].X() + "(\u70b9\u51fb\u8fdb\u5165\u6295\u7968)");
                bf2.setBounds(20, 48 * n2 - 5, this.getWidth(), 18);
                bf2.case(this);
                bf2.y(String.valueOf(this.ir[n2].Z()));
                bf2.P(-1);
            }
            this.ip.int(bf2);
            ++n2;
        }
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.startsWith("show")) {
            a.a.b.a(string, ":");
        }
        this.iq.c().au().setVisible(true);
        this.setVisible(false);
    }

    public void cP() {
        this.setBounds(200, 50, 262, 300);
        this.ip = new z();
        this.ip.setBounds(10, 70, this.getWidth() - 16, 240);
        this.ip.byte(true);
        this.add(new g(this.getWidth() - 23, 7, 15, 15));
        this.add(this.ip);
    }

    public b.a.d.b[] cO() {
        return this.ir;
    }
}

