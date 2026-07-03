/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.q;
import a.b.s;
import a.b.x;
import b.a.c.b;
import b.a.c.b.al;
import b.a.c.b.be;
import b.a.c.b.e;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class am
extends s
implements ActionListener {
    private static final String[] df = new String[]{"\u65e5\u5e38\u7528\u54c1", "\u6253\u6298\u70ed\u5356", "vip\u670d\u52a1", "\u526f\u672c", "\u6750\u6599", "\u8f85\u52a9", "\u6218\u6597", "\u6e38\u4fa0\u5546\u5e97", "\u6cd5\u5e08\u5546\u5e97", "\u6218\u58eb\u5546\u5e97\u4e00", "\u6218\u58eb\u5546\u5e97\u4e8c", "\u9996\u9970\u5546\u5e97", "\u8d85\u7ea7\u5546\u5e97", "\u65f6\u88c5\u5546\u5e97", "\u6253\u5305\u5546\u5e97"};
    private static final String[] dj = new String[df.length];
    private static final String[] di = new String[be.lO.length - 2];
    private static final String[] de = new String[be.lO.length - 2];
    private static final String[] dh = be.lO;
    private static final String[] dg = new String[dh.length];
    private b dd;
    private s dk;

    public am(b b2) {
        this.dd = b2;
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
        super.a(c2);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.startsWith("url")) {
            String string2 = this.dd.do().getParameter(string);
            if (string2 != null && string2.length() > 1) {
                this.dd.do().for(string2);
            }
        } else if (string.equals("shops")) {
            this.a(df, dj, this, 100, 33);
        } else if (string.startsWith("shop:") && this.dd.j().dM() != null) {
            int n2 = Integer.parseInt(string.substring(5));
            this.dd.c().aG().setVisible(false);
            this.dd.byte().B(n2);
        } else if (string.equals("rank")) {
            if (this.dd.for().ao > 1) {
                this.a(dh, dg, this, 16, 33);
            } else {
                this.a(di, de, this, 16, 33);
            }
        } else if (string.startsWith("top:")) {
            int n3 = Integer.parseInt(string.substring(string.indexOf(58) + 1));
            this.dd.byte().ab(n3);
        } else if (string.equals("dailyTask")) {
            this.dd.byte().f();
        } else if (string.equals("movement")) {
            this.dd.byte().b();
            this.dd.c().ao().setVisible(!this.dd.c().ao().isVisible());
        } else if (string.equals("gift")) {
            if (this.dd.for().p < 10) {
                this.dd.c().ac().dB();
            } else {
                this.dd.byte().E();
            }
        } else if (string.equals("tackOutGift")) {
            this.dd.c().as().dd();
            this.dd.c().as().new();
        }
    }

    static {
        int n2 = 0;
        while (n2 < df.length) {
            am.dj[n2] = "shop:" + n2;
            ++n2;
        }
        n2 = 0;
        while (n2 < di.length) {
            am.di[n2] = be.lO[n2];
            am.de[n2] = "top:" + (n2 + 1);
            ++n2;
        }
        n2 = 0;
        while (n2 < dh.length) {
            am.dh[n2] = be.lO[n2];
            am.dg[n2] = "top:" + (n2 + 1);
            ++n2;
        }
    }

    public void bt() {
        al al2 = al.a(1, "\u6392\u884c\u699c", "rank", this, 16, 9, 76, 24);
        this.add(al2);
        al2 = al.a(1, "\u5feb\u6377\u5546\u5e97", "shops", this, 100, 9, 76, 24);
        this.add(al2);
        al2 = al.a(1, "\u5f53\u524d\u4efb\u52a1", "dailyTask", this, 186, 9, 76, 24);
        this.add(al2);
        String[] stringArray = new String[]{"\u6d3b\u52a8", "\u793c\u54c1", "\u62bd\u5956"};
        String[] stringArray2 = new String[]{"movement", "gift", "tackOutGift"};
        int n2 = 0;
        while (n2 < stringArray2.length) {
            al2 = al.a(1, stringArray[n2], stringArray2[n2], this, 765 + n2 * 70, 9, 56, 24);
            this.add(al2);
            ++n2;
        }
        this.dk = new s();
        this.dk.setBounds(270, 11, 480, 20);
        this.dk.a(new x(-16777216));
        this.dk.a(24);
        n2 = this.dd.if("tipTextColor", 0xFFFFFF);
        this.dk.if(new q("welcome", n2));
        this.add(this.dk);
    }

    public void goto(String string) {
        q q2 = (q)this.dk.void();
        if (q2 == null || string == null) {
            return;
        }
        q2.do(string);
        this.dk.repaint();
    }
}

