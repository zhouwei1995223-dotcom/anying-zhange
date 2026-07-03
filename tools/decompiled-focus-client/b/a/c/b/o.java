/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.l;
import a.b.q;
import a.b.s;
import a.b.x;
import b.a.c.b;
import b.a.c.b.al;
import b.a.c.b.e;
import b.a.c.b.g;
import b.a.c.b.z;
import b.a.d.f;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class o
extends a.b.z
implements ActionListener {
    private b fL;
    private String fQ = "\u57ce\u5e02\u7ba1\u7406";
    private z fP;
    private s fN;
    private long fO;
    private f fM;

    public o(b b2) {
        this.fL = b2;
        this.char(true);
        this.setVisible(false);
    }

    public void goto(int n2, int n3) {
        this.fM = this.fL.for().ak;
        if (this.fM != null) {
            this.fM.cF = n2;
            this.fM.cX = n3;
            s[] sArray = (s[])this.fN.case();
            sArray[1].if(new q(" \u91d1\u5e01=" + this.fM.cF + ";\u5143\u5b9d=" + this.fM.cX, 0xFFFFFF));
        }
    }

    public void a(c c2) {
        e.a(c2, this.fQ, this.getWidth(), this.getHeight());
        super.a(c2);
    }

    public void for(a.a.e e2) {
        this.fP.bg();
        int n2 = -1;
        int n3 = 0;
        while (e2.if() > 0) {
            ++n3;
            String string = e2.h();
            int n4 = e2.for();
            int n5 = e2.for();
            s s2 = new s();
            s2.setSize(300, 20);
            s s3 = new s();
            s3.if(new q(string, n2));
            s3.setBounds(4, 4, 100, 12);
            s2.add(s3);
            s3 = new s();
            s3.if(new q("\u4f4d\u7f6e:" + n4 + "," + n5, n2));
            s3.setBounds(104, 4, 66, 12);
            s2.add(s3);
            al al2 = new al();
            al2.m(2);
            al2.char("whisper:" + string);
            al2.try(this);
            al2.else("\u5bc6\u8bed");
            al2.setBounds(200, 1, 44, 19);
            s2.add(al2);
            al2 = new al();
            al2.m(2);
            al2.char("gotoPlayer:" + string);
            al2.try(this);
            al2.else("\u524d\u5f80");
            al2.setBounds(250, 1, 44, 19);
            s2.add(al2);
            this.fP.a(s2, 0, 0, 0);
        }
        this.fQ = "\u73a9\u5bb6\u5217\u8868[\u4eba\u6570=" + n3 + "]";
        if (!this.isVisible()) {
            this.setVisible(true);
        }
    }

    public void actionPerformed(ActionEvent actionEvent) {
        block43: {
            String string = actionEvent.getActionCommand();
            if (string.equals("playerList")) {
                long l2 = System.currentTimeMillis();
                if (l2 - this.fO > 500L) {
                    this.fL.byte().k();
                    this.fO = l2;
                }
                this.fP.setVisible(true);
                this.fN.setVisible(false);
            } else if (string.equals("cityManage")) {
                this.fP.setVisible(false);
                this.fN.setVisible(true);
                this.fQ = "\u57ce\u5e02\u7ba1\u7406";
            } else if (string.startsWith("whisper:")) {
                String string2 = string.substring(8);
                this.fL.c().ag().t(string2);
            } else if (string.startsWith("gotoPlayer:")) {
                String string3 = string.substring(string.indexOf(58) + 1);
                this.fL.byte().z(string3);
            } else if (string.equals("changeTax")) {
                this.fL.void().a("\u8bf7\u8f93\u5165\u4f60\u8981\u8bbe\u7f6e\u7684\u6446\u644a\u7a0e\u7387(\u4f60\u5c06\u6309\u8fd9\u4e2a\u7a0e\u7387\u5411\u672c\u57ce\u5e02\u7684\u73a9\u5bb6\u6446\u644a\u6536\u7a0e)\u8303\u56f40\u523010", "changeTaxOK", this);
            } else if (string.equals("changeTaxOK")) {
                try {
                    int n2 = Integer.parseInt(this.fL.void().cK());
                    if (n2 < 0 || n2 > 10) {
                        this.fL.new().if("\u975e\u6cd5\u7684\u7a0e\u7387\uff0c\u5fc5\u987b\u662f0\u523010", 0xFFFFFF);
                        break block43;
                    }
                    this.fL.byte().W(n2);
                    this.fM.cG = n2;
                    s[] sArray = (s[])this.fN.case();
                    sArray[2].if(new q(" " + this.fM.cG + "%", 0xFFFFFF));
                }
                catch (NumberFormatException numberFormatException) {
                    this.fL.new().if("\u8f93\u5165\u975e\u6cd5\u7684\u6570\u5b57", 0xFF0000);
                }
            } else if (string.equals("changeTip")) {
                this.fL.void().a("\u8bf7\u8f93\u5165\u63d0\u793a\u4fe1\u606f(\u6bcf\u4e2a\u73a9\u5bb6\u8fdb\u5165\u672c\u57ce\u5e02\u573a\u666f\u65f6\u6240\u63a5\u53d7\u7684\u6b22\u8fce\u4fe1\u606f\u6587\u5b57)5\u523050\u4e2a\u6587\u5b57", "changeTipOK", this);
            } else if (string.equals("changeTipOK")) {
                String string4 = this.fL.void().cK();
                if (string4.length() < 5 || string4.length() > 50) {
                    this.fL.new().if("\u6587\u5b57\u592a\u77ed\u6216\u592a\u957f\uff0c\u9650\u52365-50", 0xFF0000);
                } else {
                    this.fL.byte().char(string4);
                    this.fM.cy = string4;
                    s[] sArray = (s[])this.fN.case();
                    sArray[3].if(new a.b.o(string4, sArray[3].getWidth() - 2, 0xFFFFFF, 25));
                }
            } else if (string.equals("notice")) {
                this.fL.void().a("\u8bf7\u8f93\u5165\u516c\u544a\u6587\u5b57(\u4fe1\u606f\u4f1a\u7acb\u5373\u53d1\u9001\u7ed9\u5f53\u524d\u672c\u573a\u666f\u7684\u6240\u6709\u73a9\u5bb6)", "noticeOK", this);
            } else if (string.equals("noticeOK")) {
                String string5 = this.fL.void().cK();
                if (string5.length() > 0 && string5.length() < 100) {
                    this.fL.byte().long(string5);
                }
            } else if (string.equals("getMoney")) {
                if (this.fM.cF > 0) {
                    this.fL.void().a("\u8bf7\u8f93\u5165\u4f60\u8981\u63d0\u53d6\u7684\u91d1\u5e01\u6570\u76ee(1\u5230" + this.fM.cF + ")", "getMoneyOK", this);
                }
            } else if (string.equals("getMoneyOK")) {
                try {
                    int n3 = Integer.parseInt(this.fL.void().cK());
                    if (n3 < 1 || n3 > this.fM.cF) {
                        this.fL.new().if("\u8f93\u5165\u6570\u5b57\u4e0d\u5728\u8303\u56f4\u5185", 0xFF0000);
                        break block43;
                    }
                    this.fL.byte().u(n3);
                }
                catch (NumberFormatException numberFormatException) {
                    this.fL.new().if("\u8f93\u5165\u6570\u5b57\u975e\u6cd5", 0xFF0000);
                }
            } else if (string.equals("getTreasure")) {
                if (this.fM.cX > 0) {
                    this.fL.void().a("\u8bf7\u8f93\u5165\u4f60\u8981\u63d0\u53d6\u7684\u5143\u5b9d\u6570\u76ee(1\u5230" + this.fM.cX + ")", "getTreasureOK", this);
                }
            } else if (string.equals("getTreasureOK")) {
                try {
                    int n4 = Integer.parseInt(this.fL.void().cK());
                    if (n4 < 1 || n4 > this.fM.cX) {
                        this.fL.new().if("\u8f93\u5165\u6570\u5b57\u4e0d\u5728\u8303\u56f4\u5185", 0xFF0000);
                    } else {
                        this.fL.byte().af(n4);
                    }
                }
                catch (NumberFormatException numberFormatException) {
                    this.fL.new().if("\u8f93\u5165\u6570\u5b57\u975e\u6cd5", 0xFF0000);
                }
            }
        }
    }

    public void cc() {
        int n2 = 328;
        int n3 = 320;
        this.setBounds(140, 40, n2, n3);
        g g2 = new g();
        g2.setBounds(this.getWidth() - 23, 7, 15, 15);
        this.add(g2);
        this.fP = new z();
        this.fP.setBounds(4, 30, 320, 260);
        this.fP.setVisible(false);
        this.add(this.fP);
        this.fN = new s();
        this.fN.setBounds(4, 30, 320, 260);
        String[] stringArray = new String[]{"\u5360\u9886\u65f6\u95f4\uff1a", "\u8d44\u4ea7\u603b\u8ba1\uff1a", "\u6446\u644a\u7a0e\u7387\uff1a", "\u6b22\u8fce\u4fe1\u606f\uff1a"};
        s[] sArray = new s[stringArray.length];
        this.fN.a(sArray);
        int n4 = 0;
        while (n4 < stringArray.length) {
            s s2 = new s();
            s2.a(18);
            s2.setBounds(0, 8 + n4 * 28, 80, 18);
            s2.if(new q(stringArray[n4], 0xFFFFFF));
            this.fN.add(s2);
            sArray[n4] = new s();
            sArray[n4].a(16);
            if (n4 == stringArray.length - 1) {
                sArray[n4].setBounds(s2.getWidth(), s2.getY(), this.fN.getWidth() - s2.getWidth() - 8, 60);
            } else {
                sArray[n4].setBounds(s2.getWidth(), s2.getY(), this.fN.getWidth() - s2.getWidth() - 8, 18);
            }
            sArray[n4].a(new x(5208358));
            this.fN.add(sArray[n4]);
            ++n4;
        }
        s s3 = new s();
        s3.a(new l(-11568858));
        s3.setBounds(4, 180, this.fN.getWidth() - 8, 1);
        this.fN.add(s3);
        this.fN.add(al.a(2, "\u7a0e\u7387\u8bbe\u7f6e", "changeTax", this, 54, 200, 66, 19));
        this.fN.add(al.a(2, "\u6b22\u8fce\u4fe1\u606f", "changeTip", this, 128, 200, 66, 19));
        this.fN.add(al.a(2, "\u53d1\u5e03\u516c\u544a", "notice", this, 202, 200, 66, 19));
        this.fN.add(al.a(2, "\u63d0\u53d6\u91d1\u5e01", "getMoney", this, 90, 228, 66, 19));
        this.fN.add(al.a(2, "\u63d0\u53d6\u5143\u5b9d", "getTreasure", this, 162, 228, 66, 19));
        this.add(this.fN);
        this.add(al.a(2, "\u73a9\u5bb6\u5217\u8868", "playerList", this, 6, this.getHeight() - 25, 66, 19));
        this.add(al.a(2, "\u7ba1\u7406\u529f\u80fd", "cityManage", this, this.getWidth() - 72, this.getHeight() - 25, 66, 19));
    }

    public void cd() {
        this.fM = this.fL.for().ak;
        s[] sArray = (s[])this.fN.case();
        if (sArray[0].void() == null && this.fM != null && this.fM.cK > 0) {
            sArray[0].if(new q(" " + a.a.b.do(this.fM.cv), 0xFFFFFF));
            sArray[1].if(new q(" \u91d1\u5e01=" + this.fM.cF + ";\u5143\u5b9d=" + this.fM.cX, 0xFFFFFF));
            sArray[2].if(new q(" " + this.fM.cG + "%", 0xFFFFFF));
            String string = this.fM.cy;
            if (string.length() < 5) {
                string = "\u5c1a\u672a\u8bbe\u7f6e(\u8be5\u4fe1\u606f\u662f\u6bcf\u4e2a\u73a9\u5bb6\u8fdb\u5165\u672c\u57ce\u5e02\u573a\u666f\u65f6\u6240\u63a5\u53d7\u7684\u6b22\u8fce\u4fe1\u606f\u6587\u5b57)";
            }
            sArray[3].if(new a.b.o(string, sArray[3].getWidth() - 2, 0xFFFFFF, 25));
        }
        this.setVisible(true);
    }
}

