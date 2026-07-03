/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.l;
import a.b.n;
import a.b.q;
import a.b.s;
import a.b.z;
import b.a.c.b;
import b.a.c.b.al;
import b.a.c.b.e;
import b.a.d.g;
import b.a.d.j;
import b.a.d.m;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class u
extends z
implements ActionListener {
    public static final String[] gn = new String[]{"\u5750\u6807X\uff1a", "\u5750\u6807Y\uff1a", "\u602a\u7269\u7f16\u53f7\uff1a", "\u884c\u4e3a\u7f16\u53f7\uff1a", "\u5956\u54c1\u7f16\u53f7\uff1a", "\u53ef\u590d\u6d3b\u6b21\u6570\uff1a"};
    public static final String[] gs = new String[]{"\u5750\u6807X\uff1a", "\u5750\u6807Y\uff1a", "\u663e\u793a\u540d\u5b57\uff1a", "\u56fe\u50cf\u7d22\u5f15\uff1a", "\u5bf9\u8bdd\u6587\u4ef6\uff1a", "\u811a\u672c\u7a0b\u5e8f\uff1a"};
    public static final String[] gj = new String[]{"\u5750\u6807X\uff1a", "\u5750\u6807Y\uff1a", "\u663e\u793a\u540d\u5b57\uff1a", "\u9650\u5236\u7b49\u7ea7\uff1a", "\u9650\u5236\u804c\u4e1a\uff1a", "\u76ee\u6807\u573a\u666fID\uff1a", "\u76ee\u6807\u4f4d\u7f6eX\uff1a", "\u76ee\u6807\u4f4d\u7f6eY\uff1a"};
    public static final String[] gq = new String[]{"\u602a\u7269\u53c2\u6570", "NPC\u53c2\u6570", "\u4f20\u9001\u95e8\u53c2\u6570"};
    public static final int gv = 1;
    public static final int gp = 2;
    public static final int gi = 1;
    public static final int gm = 2;
    public static final int gx = 3;
    private b gl;
    private String gw = "";
    private s[] gr;
    private al[] gu;
    private b.a.d.e gk;
    private int go = 1;
    private int gt = 1;

    public u(b b2) {
        this.gl = b2;
        this.char(true);
        this.setVisible(false);
    }

    public void a(c c2) {
        e.a(c2, this.gw, this.getWidth(), this.getHeight());
        super.a(c2);
    }

    public void a(j j2) {
        this.a(2, j2, new String[]{String.valueOf(j2.void), String.valueOf(j2.long), j2.a, String.valueOf(j2.ch), j2.ce, j2.cd});
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.equals("ok")) {
            n[] nArray = (n[])this.gr[this.gt - 1].case();
            int n2 = Integer.parseInt(nArray[0].D());
            int n3 = Integer.parseInt(nArray[1].D());
            if (this.gt == 3) {
                String string2 = nArray[2].D();
                int n4 = Integer.parseInt(nArray[3].D());
                int n5 = Integer.parseInt(nArray[4].D());
                int n6 = Integer.parseInt(nArray[5].D());
                int n7 = Integer.parseInt(nArray[6].D());
                int n8 = Integer.parseInt(nArray[7].D());
                if (this.gk == null) {
                    this.gl.byte().a(n2, n3, string2, n4, n5, n6, n7, n8);
                } else {
                    m m2 = (m)this.gk;
                    if (m2.void != n2 || m2.long != n3) {
                        this.gl.byte().for(m2.if, n2, n3);
                    }
                    this.gl.byte().a(m2.if, string2, n4, n5, n6, n7, n8);
                }
            } else if (this.gt == 1) {
                int n9 = Integer.parseInt(nArray[2].D());
                int n10 = Integer.parseInt(nArray[3].D());
                int n11 = Integer.parseInt(nArray[4].D());
                int n12 = Integer.parseInt(nArray[5].D());
                if (this.gk == null) {
                    this.gl.byte().a(n2, n3, n9, n10, n11, n12);
                } else {
                    g g2 = (g)this.gk;
                    if (g2.void != n2 || g2.long != n3) {
                        this.gl.byte().new(g2.if, n2, n3);
                    }
                    this.gl.byte().a(g2.if, n9, n10, n11, n12);
                }
            } else {
                String string3 = nArray[2].D();
                int n13 = Integer.parseInt(nArray[3].D());
                String string4 = nArray[4].D();
                String string5 = nArray[5].D();
                if (this.gk == null) {
                    this.gl.byte().a(n2, n3, string3, n13, string4, string5);
                } else {
                    j j2 = (j)this.gk;
                    if (j2.void != n2 || j2.long != n3) {
                        this.gl.byte().int(j2.if, n2, n3);
                    }
                    this.gl.byte().a(j2.if, string3, n13, string4, string5, 0);
                }
            }
        }
        this.setVisible(false);
        this.gl.j().requestFocus();
    }

    public void a(m m2) {
        this.a(3, m2, new String[]{String.valueOf(m2.void), String.valueOf(m2.long), m2.a, String.valueOf(m2.cm), String.valueOf(m2.ck), String.valueOf(m2.cn), String.valueOf(m2.cl), String.valueOf(m2.cj)});
    }

    public void a(g g2) {
        this.a(1, g2, new String[]{String.valueOf(g2.void), String.valueOf(g2.long), String.valueOf(g2.bO), String.valueOf(g2.bS), String.valueOf(g2.bT), String.valueOf(g2.bP)});
    }

    public void long(int n2, int n3) {
        this.a(2, null, new String[]{String.valueOf(n2), String.valueOf(n3)});
    }

    public void b(int n2, int n3) {
        this.a(1, null, new String[]{String.valueOf(n2), String.valueOf(n3)});
    }

    public void ck() {
        int n2 = 208;
        int n3 = 60;
        this.setBounds(12, 50, n2, n3);
        this.gr = new s[]{this.if(gn), this.if(gs), this.if(gj)};
        this.add(this.gr[0]);
        this.add(this.gr[1]);
        this.add(this.gr[2]);
        this.gu = new al[]{al.a(2, "\u53d6\u6d88", "cancel", this, 6, this.getHeight() - 25, 44, 19), al.a(2, "\u786e\u5b9a", "ok", this, this.getWidth() - 50, this.getHeight() - 25, 44, 19)};
        this.add(this.gu[0]);
        this.add(this.gu[1]);
    }

    private s if(String[] stringArray) {
        s s2 = new s();
        s2.setBounds(4, 30, 200, stringArray.length * 24);
        s2.setVisible(false);
        n[] nArray = new n[stringArray.length];
        s2.a(nArray);
        l l2 = new l(-1358954496);
        int n2 = 0;
        while (n2 < stringArray.length) {
            s s3 = new s();
            s3.a(18);
            s3.if(new q(stringArray[n2], -1));
            s3.setBounds(0, 24 * n2, 100, 20);
            s2.add(s3);
            nArray[n2] = new n();
            nArray[n2].a(l2);
            nArray[n2].goto(-1);
            nArray[n2].char(-1);
            nArray[n2].setBounds(100, 24 * n2, 96, 20);
            nArray[n2].if("0");
            s2.add(nArray[n2]);
            ++n2;
        }
        return s2;
    }

    public void void(int n2, int n3) {
        this.a(3, null, new String[]{String.valueOf(n2), String.valueOf(n3)});
    }

    private void a(int n2, b.a.d.e e2, String[] stringArray) {
        this.gt = n2;
        this.gw = gq[n2 - 1];
        this.gk = e2;
        s s2 = this.gr[n2 - 1];
        n[] nArray = (n[])s2.case();
        int n3 = 0;
        while (n3 < stringArray.length) {
            nArray[n3].if(stringArray[n3]);
            ++n3;
        }
        this.gr[0].setVisible(n2 == 1);
        this.gr[1].setVisible(n2 == 2);
        this.gr[2].setVisible(n2 == 3);
        this.setSize(this.getWidth(), s2.getHeight() + 60);
        this.gu[0].setLocation(this.gu[0].getX(), this.getHeight() - 25);
        this.gu[1].setLocation(this.gu[1].getX(), this.getHeight() - 25);
        this.setVisible(true);
    }
}

