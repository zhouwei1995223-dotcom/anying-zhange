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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class as
extends a.b.z
implements ActionListener {
    static final String[] jQ = new String[]{"\u5bc6\u8bed", "\u67e5\u770b\u4fe1\u606f", "\u4f20\u9001\u8fc7\u53bb", "\u9080\u8bf7\u7ec4\u961f", "\u8e22\u51fa\u5e08\u95e8"};
    static final String[] jM = new String[]{"whisperStudent", "viewStudent", "gotoStudent", "teamInvite", "delete"};
    b jL;
    private String jP = "\u5e08\u5f92\u754c\u9762";
    private z jN;
    private h jJ = new h(100);
    a jO;
    private s jK;

    public void c9() {
        b.a.e.a a10 = this.jL.for().ax.jP;
        a10.dv = false;
        this.jL.goto().w("\u4f60\u7684\u5e08\u7236\u3010" + a10.a + "\u3011\u79bb\u5f00\u4e86\u6e38\u620f");
        s[] sArray = (s[])this.jK.case();
        q q2 = (q)sArray[0].void();
        q2.if(0x7F7F7F);
    }

    public void da() {
        this.jL.for().ax.jP = null;
        this.c8();
    }

    private void c8() {
        this.jK.removeAll();
        this.jK.if(null);
        b.a.e.a a10 = this.jL.for().ax.jP;
        if (a10 == null) {
            this.jK.if(new q("\u6ca1\u6709\u5e08\u7236", 0xFFFFFF));
            return;
        }
        s[] sArray = new s[2];
        this.jK.a(sArray);
        int n2 = 4;
        int n3 = 7;
        s s2 = new s();
        s2.if(new q("\u5e08\u7236\u540d:", 0xFFFFFF));
        s2.a(16);
        s2.setBounds(n2, n3, 42, 14);
        n2 += s2.getWidth();
        this.jK.add(s2);
        sArray[0] = s2 = new s();
        s2.if(new q(a10.a, a10.dv ? 0xFFFFFF : 0x7F7F7F));
        s2.a(16);
        s2.setBounds(n2, n3, 100, 14);
        n2 += s2.getWidth();
        this.jK.add(s2);
        s2 = new s();
        s2.if(new q("\u62dc\u5e08\u65f6\u95f4:", 0xFFFFFF));
        s2.a(16);
        s2.setBounds(n2, n3, 54, 14);
        n2 += s2.getWidth();
        this.jK.add(s2);
        String string = a.a.b.do(a10.dt);
        s2 = new s();
        s2.if(new q(string, 0xFFFFFF));
        s2.a(16);
        s2.setBounds(n2, n3, q.if(string), 14);
        n2 += s2.getWidth();
        this.jK.add(s2);
        n2 = 4;
        s2 = new s();
        s2.if(new q("\u4eb2\u5bc6\u5ea6:", 0xFFFFFF));
        s2.a(16);
        s2.setBounds(n2, n3 += 19, 42, 14);
        this.jK.add(s2);
        n2 += s2.getWidth();
        string = String.valueOf(a10.du);
        sArray[1] = s2 = new s();
        s2.if(new q(string, 0xFFFFFF));
        s2.a(16);
        s2.setBounds(n2, n3, 100, 14);
        this.jK.add(s2);
        this.jK.add(al.a(2, "\u804a\u5929", "whisperMaster", this, n2 += 100, n3, 40, 19));
        this.jK.add(al.a(2, "\u67e5\u770b", "viewMaster", this, n2 + 44, n3, 40, 19));
        this.jK.add(al.a(2, "\u4f20\u9001", "gotoMaster", this, n2 + 88, n3, 40, 19));
        this.jK.add(al.a(2, "\u9000\u51fa", "leaveMaster", this, n2 + 132, n3, 40, 19));
    }

    public as(b b2) {
        this.jL = b2;
        this.char(true);
        this.setVisible(false);
    }

    public void p(String string) {
        this.jL.for().ax.void(string);
        this.c7();
    }

    public void a(c c2) {
        e.a(c2, this.jP, this.getWidth(), this.getHeight());
        super.a(c2);
        c2.do(4, 80, this.getWidth() - 4, 80, -3750223);
        c2.do(4, 100, this.getWidth() - 4, 100, -3750223);
    }

    public void new(int n2, int n3, int n4) {
        s[] sArray = (s[])this.jK.case();
        sArray[1].if(new q(String.valueOf(n4), 0xFFFFFF));
        if (n4 != this.jL.for().ax.jP.du) {
            String string = "\u4f60\u548c\u5e08\u7236\u7684\u4eb2\u5bc6\u5ea6\u6539\u53d8\u4e3a" + n4;
            this.jL.goto().w(string);
            this.jL.c().aB().T().if("system", string);
        }
    }

    public void do(String string, int n2, int n3) {
        int n4 = this.jJ.for();
        int n5 = 0;
        while (n5 < n4) {
            a a10 = (a)this.jJ.if(n5);
            if (a10.dE.a.equals(string)) {
                a10.case(true);
                a10.do(n2, n3, a10.dE.dA);
                break;
            }
            ++n5;
        }
        this.jL.goto().w("\u4f60\u7684\u5f92\u5f1f\u3010" + string + "\u3011\u8fdb\u5165\u4e86\u6e38\u620f");
    }

    public void q(String string) {
        int n2 = this.jJ.for();
        int n3 = 0;
        while (n3 < n2) {
            a a10 = (a)this.jJ.if(n3);
            if (a10.dE.a.equals(string)) {
                a10.case(false);
                break;
            }
            ++n3;
        }
        this.jL.goto().w("\u4f60\u7684\u5f92\u5f1f\u3010" + string + "\u3011\u79bb\u5f00\u4e86\u6e38\u620f");
    }

    public void a(b.a.e.a a10) {
        this.jL.for().ax.jP = a10;
        this.c8();
    }

    public void a(b.a.e.b b2) {
        this.jL.for().ax.a(b2);
        a a10 = new a(b2);
        a10.setSize(360, 20);
        this.jN.a(a10, 0, 0, 0);
        this.jJ.if(a10);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.equals("viewStudent")) {
            if (this.jO.dE.dB) {
                this.jL.byte().case(this.jO.dE.a);
            } else {
                this.jL.new().if("\u8be5\u5f92\u5f1f\u4e0d\u5728\u7ebf\u4e0a", 0xFF0000);
            }
        } else if (string.equals("viewMaster")) {
            if (this.jL.for().ax.jP.dv) {
                this.jL.byte().case(this.jL.for().ax.jP.a);
            } else {
                this.jL.new().if("\u5e08\u7236\u4e0d\u5728\u7ebf\u4e0a", 0xFF0000);
            }
        } else if (string.equals("whisperStudent")) {
            if (this.jO.dE.dB) {
                this.jL.c().ag().t(this.jO.dE.a);
            } else {
                this.jL.new().if("\u8be5\u5f92\u5f1f\u4e0d\u5728\u7ebf\u4e0a", 0xFF0000);
            }
        } else if (string.equals("whisperMaster")) {
            if (this.jL.for().ax.jP.dv) {
                this.jL.c().ag().t(this.jL.for().ax.jP.a);
            } else {
                this.jL.new().if("\u5e08\u7236\u4e0d\u5728\u7ebf\u4e0a", 0xFF0000);
            }
        } else if (string.equals("gotoStudent")) {
            if (!this.jO.dE.dB) {
                this.jL.new().if("\u8be5\u5f92\u5f1f\u4e0d\u5728\u7ebf\u4e0a", 0xFF0000);
            } else if (this.jO.dE.dA < 1000) {
                this.jL.new().if("\u4eb2\u5bc6\u5ea6\u9ad8\u4e8e1000\u624d\u53ef\u4ee5\u4f7f\u7528\u4f20\u9001\u529f\u80fd", 0xFF0000);
            } else {
                this.jL.new().if("\u4f20\u9001\u4f9d\u6b21\u4f1a\u6d88\u80175\u70b9\u4eb2\u5bc6\u5ea6\uff0c\u786e\u5b9a\u4f20\u9001\u5417\uff1f", 0xFFFFFF, "yesGotoStudent", "", this);
            }
        } else if (string.equals("yesGotoStudent")) {
            this.jL.byte().b(this.jO.dE.a);
        } else if (string.equals("gotoMaster")) {
            b.a.e.a a10 = this.jL.for().ax.jP;
            if (!a10.dv) {
                this.jL.new().if("\u5e08\u7236\u4e0d\u5728\u7ebf\u4e0a", 0xFF0000);
            } else if (a10.du < 1000) {
                this.jL.new().if("\u4eb2\u5bc6\u5ea6\u9ad8\u4e8e1000\u624d\u53ef\u4ee5\u4f7f\u7528\u4f20\u9001\u529f\u80fd", 0xFF0000);
            } else {
                this.jL.new().if("\u4f20\u9001\u4f9d\u6b21\u4f1a\u6d88\u80175\u70b9\u4eb2\u5bc6\u5ea6\uff0c\u786e\u5b9a\u4f20\u9001\u5417\uff1f", 0xFFFFFF, "yesGotoMaster", "", this);
            }
        } else if (string.equals("yesGotoMaster")) {
            this.jL.byte().y(this.jL.for().ax.jP.a);
        } else if (string.equals("teamInvite")) {
            if (this.jO.dE.dB) {
                this.jL.byte().k(this.jO.dE.a);
            } else {
                this.jL.new().if("\u8be5\u5f92\u5f1f\u4e0d\u5728\u7ebf\u4e0a", 0xFF0000);
            }
        } else if (string.equals("delete")) {
            this.jL.new().if("\u4f60\u786e\u5b9a\u8981\u5c06\u3010" + this.jO.dE.a + "\u3011\u8e22\u51fa\u5e08\u95e8\u5417\uff1f", 0xFFFFFF, "yesDelete", "", this);
        } else if (string.equals("yesDelete")) {
            this.jL.byte().for(this.jO.dE.a);
        } else if (string.equals("leaveMaster")) {
            this.jL.new().if("\u4f60\u786e\u5b9a\u8981\u80cc\u53db\u3010" + this.jL.for().ax.jP.a + "\u3011\u4f5c\u4e3a\u4f60\u7684\u5e08\u7236\u5417\uff1f", 0xFFFFFF, "yesLeave", "", this);
        } else if (string.equals("yesLeave")) {
            this.jL.byte().d();
        }
    }

    public void do(String string, int n2, int n3, int n4) {
        int n5 = this.jJ.for();
        int n6 = 0;
        while (n6 < n5) {
            a a10 = (a)this.jJ.if(n6);
            if (a10.dE.a.equals(string)) {
                if (n4 != a10.dE.dA) {
                    String string2 = "\u4f60\u548c\u5f92\u5f1f\u3010" + string + "\u3011\u7684\u4eb2\u5bc6\u5ea6\u6539\u53d8\u4e3a" + n4;
                    this.jL.goto().w(string2);
                    this.jL.c().aB().T().if("system", string2);
                }
                a10.do(n2, n3, n4);
                break;
            }
            ++n6;
        }
    }

    private void c7() {
        this.jN.bg();
        this.jJ.a();
        b.a.e.s s2 = this.jL.for().ax;
        int n2 = 0;
        while (n2 < s2.jO) {
            this.a(s2.jS[n2]);
            ++n2;
        }
    }

    public void db() {
        int n2 = 384;
        int n3 = 342;
        this.setBounds(130, 60, n2, n3);
        g g2 = new g();
        g2.setBounds(this.getWidth() - 23, 7, 15, 15);
        this.add(g2);
        this.jK = new s();
        this.jK.setBounds(4, 30, this.getWidth() - 8, 50);
        this.jK.a(24);
        this.c8();
        this.add(this.jK);
        s s2 = new s();
        s2.setBounds(4, 80, this.getWidth() - 24, 20);
        String[] stringArray = new String[]{"\u5f92\u5f1f\u540d", "\u804c\u4e1a", "\u7b49\u7ea7", "\u8f6c\u751f", "\u4eb2\u5bc6\u5ea6", "\u62db\u6536\u65f6\u95f4"};
        int[] nArray = new int[]{100, 32, 32, 32, 40, 114};
        int n4 = 0;
        int n5 = 0;
        while (n5 < stringArray.length) {
            s s3 = new s();
            s3.setBounds(n4, 4, nArray[n5], 12);
            n4 += nArray[n5];
            q q2 = new q(stringArray[n5], -527356);
            s3.a(8);
            s3.if(q2);
            s2.add(s3);
            ++n5;
        }
        this.add(s2);
        this.jN = new z();
        this.jN.setBounds(4, 100, n2 - 8, n3 - 130);
        this.add(this.jN);
        this.c7();
    }

    public void q(int n2, int n3) {
        b.a.e.a a10 = this.jL.for().ax.jP;
        a10.dv = true;
        a10.dy = n2;
        a10.dw = n3;
        this.jL.goto().w("\u4f60\u7684\u5e08\u7236\u3010" + a10.a + "\u3011\u8fdb\u5165\u4e86\u6e38\u620f");
        s[] sArray = (s[])this.jK.case();
        q q2 = (q)sArray[0].void();
        q2.if(0xFFFFFF);
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    private class a
    extends s {
        b.a.e.b dE;
        s[] dG;
        boolean dF;

        public a(b.a.e.b b2) {
            as.this.getClass();
            this.dG = new s[6];
            this.dE = b2;
            int[] nArray = new int[]{100, 32, 32, 32, 40, 114};
            int n2 = 0;
            int n3 = 0;
            while (n3 < nArray.length) {
                this.dG[n3] = new s();
                this.dG[n3].a(8);
                this.dG[n3].setBounds(n2, 4, nArray[n3], 12);
                n2 += nArray[n3];
                this.add(this.dG[n3]);
                ++n3;
            }
            n3 = b2.dB ? 0xFFFFFF : 0x7F7F7F;
            this.dG[0].if(new q(b2.a, n3));
            this.dG[1].if(new q(d.ap[b2.dD], n3));
            this.dG[2].if(new q(String.valueOf(b2.dE), n3));
            this.dG[3].if(new q(String.valueOf(b2.dC), n3));
            this.dG[4].if(new q(String.valueOf(b2.dA), n3));
            this.dG[5].if(new q(String.valueOf(a.a.b.do(b2.dz)), n3));
            this.enableEvents(16L);
        }

        public void a(c c2) {
            if (this.dF) {
                c2.a(0, 0, this.getWidth(), this.getHeight(), -1894998535);
            }
            super.a(c2);
        }

        protected void processMouseEvent(MouseEvent mouseEvent) {
            if (mouseEvent.getID() == 504) {
                this.dF = true;
                this.repaint();
            } else if (mouseEvent.getID() == 505) {
                this.dF = false;
                this.repaint();
            } else if (mouseEvent.getID() == 501 && mouseEvent.getModifiers() == 4) {
                as.this.jO = this;
                this.a(jQ, jM, as.this, mouseEvent.getX(), mouseEvent.getY());
            } else if (mouseEvent.getID() == 500 && mouseEvent.getClickCount() > 1) {
                as as2 = as.this;
                as2.jL.c().ag().t(this.dE.a);
            }
        }

        public void case(boolean bl) {
            this.dE.dB = bl;
            int n2 = bl ? 0xFFFFFF : 0x7F7F7F;
            int n3 = 0;
            while (n3 < this.dG.length) {
                q q2 = (q)this.dG[n3].void();
                q2.if(n2);
                ++n3;
            }
        }

        public void do(int n2, int n3, int n4) {
            this.dE.dE = n2;
            this.dE.dC = n3;
            this.dE.dA = n4;
            this.dG[2].if(new q(String.valueOf(n2), 0xFFFFFF));
            this.dG[3].if(new q(String.valueOf(n3), 0xFFFFFF));
            this.dG[4].if(new q(String.valueOf(n4), 0xFFFFFF));
        }
    }
}

