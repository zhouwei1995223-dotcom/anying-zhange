/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.q;
import a.b.s;
import b.a.c.b;
import b.a.c.b.al;
import b.a.c.b.au;
import b.a.c.b.e;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URLEncoder;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class d
extends s
implements ActionListener {
    private b aC;
    private au aF;
    private String aH = "smallmap";
    private String aG;
    private int aE = 48;
    private int aD;

    public d(b b2) {
        this.aC = b2;
    }

    public void a(c c2) {
        c2.a(this.getWidth() - 92, 0, 92, 26, -16777216);
        e.for(c2, 0, 0, this.getWidth() - 90);
        c2.a(this.aH, this.aD, 9, -16713720);
        c2.a(0, 26, this.getWidth(), 2, -16777216);
        int n2 = 26;
        while (n2 < this.getHeight()) {
            c2.if(e.aZ, 0, n2, 289, 63, 7, 20);
            n2 += 12;
        }
        super.a(c2);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string;
        String string2 = actionEvent.getActionCommand();
        if (string2.equals("pay") && (string = this.aC.do().getParameter("payUrl")) != null && string.length() > 5) {
            this.aC.do().for(string + "?username=" + URLEncoder.encode(this.aC.case().a));
        }
    }

    public void do(int n2, int n3) {
        this.for(this.aG + "-\u5750\u6807[X=" + n2 + ";Y=" + n3 + "]");
    }

    private void for(String string) {
        this.repaint(this.aD, 9, this.aE, 12);
        this.aE = q.if(string);
        this.aD = this.getWidth() / 2 - 45 - this.aE / 2;
        this.repaint(this.aD, 9, this.aE, 12);
        this.aH = string;
    }

    public void U() {
        this.aF = new au(this.aC);
        this.aF.setBounds(7, 24, this.getWidth() - 7, this.getHeight() - 24);
        this.aF.bz();
        this.add(this.aF);
        String string = this.aC.do().getParameter("rightPayLabel");
        if (string == null || string.length() < 2) {
            string = "\u6e38\u620f\u5145\u503c";
        }
        al al2 = al.a(1, string, "pay", this, this.getWidth() - 84, 2, 76, 22);
        this.add(al2);
        this.aD = 125 - this.aE / 2;
    }

    public au T() {
        return this.aF;
    }

    public void int(String string) {
        this.aG = string;
        this.for(this.aG);
    }
}

