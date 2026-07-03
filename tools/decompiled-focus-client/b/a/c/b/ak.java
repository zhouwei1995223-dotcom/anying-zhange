/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.a.h;
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
public class ak
extends a.b.z
implements ActionListener {
    private b iE;
    private int iD = 0;
    private char[] iH;
    private int iG = -1;
    private z iF;

    public ak(b b2) {
        this.iE = b2;
        this.char(true);
        this.setVisible(false);
        this.new();
    }

    public void a(c c2) {
        e.a(c2, "\u5f53\u524d\u53ef\u63a5\u4efb\u52a1\u5217\u8868", this.getWidth(), this.getHeight());
        c2.a("\u4eb2\u7231\u7684 ", 12, 36, -1);
        c2.a(this.iE.for().a, 58, 36, Color.yellow.getRGB());
        c2.a("\u5f53\u524d\u60a8\u53ef\u4ee5\u63a5\u53d7\u7684\u4efb\u52a1\u5982\u4e0b\uff1a", 12, 49, -1);
        super.a(c2);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        actionEvent.getActionCommand();
        bf bf2 = (bf)actionEvent.getSource();
        String[] stringArray = (String[])bf2.case();
        this.iE.c().aJ().a(stringArray);
    }

    public void if(h h2) {
        this.iF.bg();
        this.new();
        int n2 = h2.for();
        int n3 = 0;
        while (n3 < n2) {
            b.a.e.c c2 = (b.a.e.c)h2.if(n3);
            bf bf2 = new bf();
            bf2.z(c2.a);
            bf2.y("showTask");
            bf2.case(this);
            bf2.P(-1);
            bf2.setBounds(4, 50 + n3 * 18, this.iF.getWidth() - 8, 18);
            String[] stringArray = new String[]{c2.if + "", c2.a, c2.dR, c2.dU};
            bf2.a(stringArray);
            this.iF.a(bf2, 0, 0, 0);
            ++n3;
        }
        this.setVisible(true);
    }

    public void cR() {
        int n2 = 254;
        int n3 = 381;
        this.setBounds(100, 40, n2, n3);
        this.add(new g(this.getWidth() - 23, 7, 15, 15));
        int n4 = 70;
        this.iF = new z();
        this.iF.setBounds(3, n4, this.getWidth() - 8, this.getHeight() - n4 - 30);
        this.iF.byte(true);
        this.add(this.iF);
    }
}

