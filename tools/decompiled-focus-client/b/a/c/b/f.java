/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.o;
import a.b.q;
import a.b.s;
import b.a.c.b.a5;
import b.a.c.b.al;
import b.a.c.b.at;
import b.a.c.b.bf;
import b.a.c.b.e;
import b.a.c.b.g;
import b.a.c.b.i;
import b.a.c.b.z;
import b.a.d.d;
import b.a.d.f;
import b.a.d.k;
import b.a.e.j;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class f
extends a.b.z
implements ActionListener {
    private static boolean fs;
    private static boolean fr;
    static final String[] fi;
    static final String[] fw;
    static final String[] fp;
    static final String[] fx;
    b.a.c.b fn;
    b.a.d.f fq;
    private String fv = "";
    private z[] fl = new z[2];
    private s[] ft = new s[9];
    f.a fm;
    private s fo;
    private s fk;
    private c fu;
    private a fj;

    private void b3() {
        this.fm = null;
        this.fv = this.fq.a + "[" + this.fq.cx + "\u7ea7]";
        if (this.fq.cz.length() < 4) {
            this.fq.cz = "\u5c1a\u672a\u586b\u5199\u4ecb\u7ecd\u4fe1\u606f";
        }
        if (this.fq.cV.length() < 4) {
            this.fq.cV = "\u5c1a\u672a\u586b\u5199\u516c\u544a\u4fe1\u606f";
        }
        this.fo.if(new o(this.fq.cz, this.fo.getWidth(), 0xFFFFFF, 24));
        this.fk.if(new o(this.fq.cV, this.fk.getWidth(), 0xFFFFFF, 24));
        if (this.fn.for().a.equals(this.fq.cB)) {
            ((al)this.ft[8]).else("\u89e3\u6563\u516c\u4f1a");
        }
        this.fl[0].bg();
        this.fl[1].bg();
        int n2 = this.fq.cw.for();
        int n3 = 0;
        while (n3 < n2) {
            f.a a10 = (f.a)this.fq.cw.if(n3);
            this.fl[0].a(new b(a10), 0, 0, 0);
            if (a10.do) {
                this.fl[1].a(new b(a10), 0, 0, 0);
            }
            ++n3;
        }
        ((s)this.case()).setVisible(true);
        this.fl[0].setVisible(true);
        this.fl[1].setVisible(false);
        n3 = 0;
        while (n3 < this.ft.length) {
            if (this.ft[n3] != null) {
                this.ft[n3].setVisible(true);
            }
            ++n3;
        }
        ((bf)this.ft[0]).else(true);
        ((bf)this.ft[1]).else(false);
        ((bf)this.ft[2]).else(true);
        ((bf)this.ft[3]).else(false);
        this.fo.setVisible(true);
        this.fk.setVisible(false);
    }

    public void if(String string, int n2, int n3) {
        this.fq.cI -= n2;
        this.fq.c0 -= n3;
        String string2 = "\u300e" + string + "\u300f\u4ece\u516c\u4f1a\u53d6\u51fa" + n2 + "\u91d1\u5e01\uff0c\u516c\u4f1a\u58f0\u671b\u51cf\u5c11" + n3;
        this.fn.goto().w(string2);
        this.fn.c().aB().T().void("guild").if("\u3010\u4fe1\u606f\u3011", 0, string2, 0xFFFFFF);
        if (this.fq.c0 < 0) {
            this.fn.new().if("\u4f60\u516c\u4f1a\u7684\u58f0\u671b\u5c11\u4e8e0\uff0c\u968f\u65f6\u9762\u4e34\u964d\u7ea7\u6216\u89e3\u6563\u7684\u5371\u9669\uff0c\u8bf7\u8d76\u5feb\u60f3\u6cd5\u63d0\u9ad8\u516c\u4f1a\u7684\u58f0\u671b\u5427\uff01", 0xFF0000);
        }
    }

    public void if(String string, int n2, int n3, int n4) {
        f.a a10 = this.fq.a(string, n2, n3, n4, 0);
        a10.do = true;
        this.fl[0].a(new b(a10), 0, 0, 0);
        this.fl[1].a(new b(a10), 0, 0, 0);
        this.fn.goto().w("\u300e" + string + "\u300f\u52a0\u5165\u4e86\u516c\u4f1a");
    }

    public void a(String string, int n2, int n3, int n4) {
        f.a a10 = this.fq.do(string);
        a10.new = n2;
        a10.int = n3;
        a10.try = n4;
        a10.do = true;
        this.fl[1].a(new b(a10), 0, 0, 0);
        String string2 = "\u516c\u4f1a\u6210\u5458\u300e" + string + "\u300f\u8fdb\u5165\u4e86\u6e38\u620f";
        this.fn.c().aB().T().void("guild").if("\u3010\u4fe1\u606f\u3011", 0, string2, -1);
        this.fn.goto().w(string2);
    }

    public void f(String string) {
        this.fq.do((String)string).do = false;
        this.fl[1].case(string);
        String string2 = "\u516c\u4f1a\u6210\u5458\u300e" + string + "\u300f\u79bb\u5f00\u4e86\u6e38\u620f";
        this.fn.c().aB().T().void("guild").if("\u3010\u4fe1\u606f\u3011", 0, string2, -1);
        this.fn.goto().w(string2);
    }

    public void byte(String string, int n2) {
        f.a a10 = this.fq.do(string);
        a10.if = n2;
        if (this.fq.cB.equals(this.fn.for().a)) {
            this.fn.new().if("\u3010" + string + "\u3011\u88ab\u4f60\u8d4b\u4e88" + b.a.d.f.cA[n2] + "\u7684\u804c\u4f4d", 0xFFFFFF);
        } else if (string.equals(this.fn.for().a)) {
            this.fn.for().ai = n2;
            this.fn.new().if("\u4f60\u88ab\u7ba1\u7406\u5458\u8bbe\u7f6e\u4e3a" + b.a.d.f.cA[n2] + "\u7684\u804c\u4f4d", 0xFFFFFF);
        } else {
            this.fn.goto().w("\u3010" + string + "\u3011\u88ab\u7ba1\u7406\u5458\u8d4b\u4e88" + b.a.d.f.cA[n2] + "\u7684\u804c\u4f4d");
        }
    }

    public void a(int n2, j j2, String string) {
        this.fq.cP[n2] = j2;
        if (this.fj != null && this.fj.getParent() != null && this.fj.isVisible()) {
            this.fj.repaint();
        }
        if (!string.equals(this.fn.for().a)) {
            String string2 = "\u300e" + string + "\u300f\u4e3a\u516c\u4f1a\u4ed3\u5e93\u8d21\u732e\u4e86\u7269\u54c1[" + j2.a + "]";
            this.fn.goto().w(string2);
            this.fn.c().aB().T().void("guild").if("\u3010\u4fe1\u606f\u3011", 0, string2, 0xFFFFFF);
        }
    }

    public void actionPerformed(ActionEvent actionEvent) {
        block129: {
            String string = actionEvent.getActionCommand();
            if (string.equals("leaveGuild")) {
                if (this.fn.for().a.equals(this.fq.cB)) {
                    this.fn.void().a("\u4f60\u786e\u5b9a\u8981\u89e3\u6563\u516c\u4f1a\u5417\uff1f\u8bf7\u5728\u4e0b\u9762\u8f93\u5165disband", "yesLeave", this);
                } else {
                    this.fn.void().a("\u4f60\u786e\u5b9a\u8981\u9000\u51fa\u516c\u4f1a\u5417\uff1f\u8bf7\u5728\u4e0b\u9762\u8f93\u5165leave", "yesLeave", this);
                }
            } else if (string.equals("conveyToSign")) {
                int n2 = this.fn.for().ai;
                if (n2 != 1 && n2 != 2) {
                    this.fn.new().if("\u524d\u5f80\u9a7b\u5730\u5c06\u6d88\u80171000\u516c\u4f1a\u8d44\u91d1\uff0c\u4f60\u786e\u5b9a\u5417\uff1f", -1, "yesConveyToSign", "", this);
                } else {
                    this.fn.byte().u();
                }
            } else if (string.equals("yesConveyToSign")) {
                this.fn.byte().u();
                this.setVisible(false);
            } else if (string.equals("yesLeave")) {
                if (this.fn.for().a.equals(this.fq.cB)) {
                    if (this.fn.void().cK().equals("disband")) {
                        this.fn.byte().A();
                    } else {
                        this.fn.new().if("\u8f93\u5165\u4e0d\u7b26\uff0c\u4f60\u53d6\u6d88\u4e86\u89e3\u6563\u516c\u4f1a", -65281);
                    }
                } else if (this.fn.void().cK().equals("leave")) {
                    this.fn.byte().A();
                } else {
                    this.fn.new().if("\u8f93\u5165\u4e0d\u7b26\uff0c\u4f60\u53d6\u6d88\u4e86\u9000\u51fa\u516c\u4f1a", -65281);
                }
            } else if (string.equals("delete")) {
                this.fn.void().a("\u5f00\u9664\u8be5\u4f1a\u5458\u5c06\u51cf\u5c11\u516c\u4f1a10\u70b9\u58f0\u671b\uff0c\u4f60\u786e\u5b9a\u8981\u5f00\u9664\u3010" + this.fm.for + "\u3011\u5417\uff1f\u8bf7\u5728\u4e0b\u9762\u8f93\u5165delete", "yesDelete", this);
            } else if (string.equals("yesDelete")) {
                if (this.fq.c0 < 10) {
                    this.fn.new().if("\u516c\u4f1a\u58f0\u671b\u4e0d\u8db3\uff0c\u65e0\u6cd5\u5f00\u9664\u4f1a\u5458", -65281);
                } else if (this.fn.void().cK().equals("delete")) {
                    this.fn.byte().C(this.fm.for);
                } else {
                    this.fn.new().if("\u8f93\u5165\u4e0d\u7b26\uff0c\u4f60\u53d6\u6d88\u4e86\u5220\u9664\u4f1a\u5458", -65281);
                }
            } else if (string.equals("copyName")) {
                a.a.b.if(this.fm.for);
            } else if (string.equals("whisper")) {
                this.fn.c().ag().t(this.fm.for);
            } else if (string.equals("view")) {
                this.fn.byte().case(this.fm.for);
            } else if (string.equals("teamInvite")) {
                this.fn.byte().k(this.fm.for);
            } else if (string.equals("guildIntro")) {
                bf bf2 = (bf)this.ft[0];
                if (!bf2.d6()) {
                    ((bf)this.ft[1]).else(false);
                    bf2.else(true);
                    this.fo.setVisible(true);
                    this.fk.setVisible(false);
                }
            } else if (string.equals("guildNotice")) {
                bf bf3 = (bf)this.ft[1];
                if (!bf3.d6()) {
                    ((bf)this.ft[0]).else(false);
                    bf3.else(true);
                    this.fo.setVisible(false);
                    this.fk.setVisible(true);
                }
            } else if (string.equals("showAll")) {
                bf bf4 = (bf)this.ft[2];
                if (!bf4.d6()) {
                    ((bf)this.ft[3]).else(false);
                    bf4.else(true);
                    this.fl[0].setVisible(true);
                    this.fl[1].setVisible(false);
                }
            } else if (string.equals("showOnline")) {
                bf bf5 = (bf)this.ft[3];
                if (!bf5.d6()) {
                    ((bf)this.ft[2]).else(false);
                    bf5.else(true);
                    this.fl[0].setVisible(false);
                    this.fl[1].setVisible(true);
                }
            } else if (string.equals("contribute")) {
                this.fn.void().a("\u8bf7\u8f93\u5165\u4f60\u8981\u6350\u52a9\u7ed9\u516c\u4f1a\u7684\u91d1\u5e01", "okContribute", this);
            } else if (string.equals("okContribute")) {
                try {
                    int n3 = Integer.parseInt(this.fn.void().cK());
                    if (n3 <= 0) {
                        this.fn.new().if("\u975e\u6cd5\u7684\u6570\u5b57\u8f93\u5165\uff1a" + n3, -65536);
                        break block129;
                    }
                    if (n3 > this.fn.for().bA.fk) {
                        this.fn.new().if("\u80cc\u5305\u4e2d\u5e76\u6ca1\u6709\u8fd9\u4e48\u591a\u91d1\u5e01\uff1a" + n3, -65536);
                        break block129;
                    }
                    this.fn.byte().do(n3);
                }
                catch (NumberFormatException numberFormatException) {
                    this.fn.new().if("\u8f93\u5165\u6570\u5b57\u975e\u6cd5\uff01", -65536);
                }
            } else if (string.equals("takeMoney")) {
                k k2 = this.fn.for();
                if (k2.ai == 1 || k2.ai == 2) {
                    this.fn.void().a("\u8bf7\u8f93\u5165\u4f60\u8981\u53d6\u51fa\u7684\u91d1\u5e01\u6570\u989d\uff0c\u53d6\u51fa\u91d1\u94b1\u4e0d\u4f1a\u964d\u4f4e\u516c\u4f1a\u58f0\u671b", "okTakeMoney", this);
                } else {
                    this.fn.new().if("\u4f60\u6ca1\u6709\u53d6\u94b1\u7684\u6743\u9650", -65536);
                }
            } else if (string.equals("okTakeMoney")) {
                try {
                    int n4 = Integer.parseInt(this.fn.void().cK());
                    if (n4 <= 0) {
                        this.fn.new().if("\u975e\u6cd5\u7684\u6570\u5b57\u8f93\u5165\uff1a" + n4, -65536);
                        break block129;
                    }
                    if (n4 > this.fq.cI) {
                        this.fn.new().if("\u516c\u4f1a\u8d44\u4ea7\u4e2d\u5e76\u6ca1\u6709\u8fd9\u4e48\u591a\u91d1\u5e01\uff1a" + n4, -65536);
                        break block129;
                    }
                    this.fn.byte().for(n4);
                }
                catch (NumberFormatException numberFormatException) {
                    this.fn.new().if("\u8f93\u5165\u6570\u5b57\u975e\u6cd5\uff01", -65536);
                }
            } else if (string.equals("setIntro")) {
                if (this.fn.void().cK().length() > 2) {
                    this.fn.byte().q(this.fn.void().cK());
                }
            } else if (string.equals("setNotice")) {
                if (this.fn.void().cK().length() > 2) {
                    this.fn.byte().G(this.fn.void().cK());
                }
            } else if (string.equals("pullMember")) {
                if (!this.fm.do) {
                    this.fn.new().if("\u8be5\u6210\u5458\u5f53\u524d\u4e0d\u5728\u7ebf", 0xFF0000);
                } else if (!fs) {
                    fs = true;
                    this.fn.new().if("\u5c06\u8be5\u6210\u5458\u4f20\u9001\u5230\u4f60\u7684\u9762\u524d\uff0c\u6bcf\u6b21\u9700\u8981\u6d88\u80172\u70b9\u516c\u4f1a\u58f0\u671b\uff0c\u4f60\u786e\u5b9a\u5417\uff1f", 0xFFFFFF, "yesPullMember", "", this);
                } else if (this.fq.c0 < 2) {
                    this.fn.new().if("\u516c\u4f1a\u58f0\u671b\u4e0d\u8db3", 0xFF0000);
                } else {
                    this.fn.byte().w(this.fm.for);
                }
            } else if (string.equals("yesPullMember")) {
                if (this.fq.c0 < 2) {
                    this.fn.new().if("\u516c\u4f1a\u58f0\u671b\u4e0d\u8db3", 0xFF0000);
                } else {
                    this.fn.byte().w(this.fm.for);
                }
            } else if (string.equals("gotoMember")) {
                if (!this.fm.do) {
                    this.fn.new().if("\u8be5\u6210\u5458\u5f53\u524d\u4e0d\u5728\u7ebf", 0xFF0000);
                } else if (!fr) {
                    fr = true;
                    this.fn.new().if("\u4f60\u4f20\u9001\u5230\u8be5\u6210\u5458\u8eab\u8fb9\uff0c\u6bcf\u6b21\u9700\u8981\u6d88\u80172\u70b9\u516c\u4f1a\u58f0\u671b\uff0c\u4f60\u786e\u5b9a\u5417\uff1f", 0xFFFFFF, "yesGotoMember", "", this);
                } else if (this.fq.c0 < 2) {
                    this.fn.new().if("\u516c\u4f1a\u58f0\u671b\u4e0d\u8db3", 0xFF0000);
                } else {
                    this.fn.byte().E(this.fm.for);
                }
            } else if (string.equals("yesGotoMember")) {
                if (this.fq.c0 < 2) {
                    this.fn.new().if("\u516c\u4f1a\u58f0\u671b\u4e0d\u8db3", 0xFF0000);
                } else {
                    this.fn.byte().E(this.fm.for);
                }
            } else if (string.equals("viceLeader")) {
                if (this.fm.if == 1) {
                    this.fn.byte().a(this.fm.for, 0);
                } else if (this.fm.if == 0) {
                    this.fn.new().if("\u516c\u4f1a\u7684\u526f\u4f1a\u957f\u5177\u6709\u5904\u7406\u5165\u4f1a\u7533\u8bf7\u3001\u9080\u8bf7\u4f1a\u5458\u3001\u53d6\u51fa\u516c\u4f1a\u4ed3\u5e93\u7269\u54c1\u548c\u91d1\u94b1\u7684\u6743\u9650\u3002\u4f60\u786e\u5b9a\u5417\uff1f", -1, "yesViceLeader", "", this);
                } else {
                    this.fn.byte().a(this.fm.for, 0);
                }
            } else if (string.equals("yesViceLeader")) {
                this.fn.byte().a(this.fm.for, 1);
            } else if (string.equals("transferLeader")) {
                if (this.fm.if <= 0) {
                    this.fn.new().if("\u4f60\u53ea\u80fd\u5c06\u4f1a\u957f\u8eab\u4efd\u8f6c\u8ba9\u7ed9\u526f\u4f1a\u957f", 0xFF0000);
                } else {
                    this.fn.new().if("\u6267\u884c\u4f1a\u957f\u8eab\u4efd\u8f6c\u8ba9\uff0c\u4f60\u5c06\u6210\u4e3a\u526f\u4f1a\u957f\uff0c\u516c\u4f1a\u58f0\u671b\u964d\u4f4e100\u70b9\u3002\u4f60\u786e\u5b9a\u8981\u8f6c\u8ba9\u8eab\u4efd\u5417\uff1f", 0xFFFFFF, "yesTransfer", "", this);
                }
            } else if (string.equals("yesTransfer")) {
                if (this.fq.c0 < 100) {
                    this.fn.new().if("\u516c\u4f1a\u58f0\u671b\u4e0d\u8db3", 0xFF0000);
                } else {
                    this.fn.byte().D(this.fm.for);
                }
            } else if (string.equals("store")) {
                if (this.fq.cx < 2) {
                    this.fn.new().if("1\u7ea7\u516c\u4f1a\u65e0\u6cd5\u4f7f\u7528\u4ed3\u5e93\u529f\u80fd", 0xFF0000);
                } else {
                    if (this.fj == null) {
                        this.fj = new a();
                    }
                    this.fj.setLocation(this.getX() + this.getWidth() / 2 - this.fj.getWidth() / 2, this.getY() + this.getHeight() / 2 - this.fj.getHeight() / 2);
                    if (this.fj.getParent() == null) {
                        this.getParent().add((Component)this.fj, 0);
                    }
                    this.fj.setVisible(true);
                }
            } else if (string.equals("setTitle")) {
                if (this.fm.if > 2) {
                    this.fn.byte().a(this.fm.for, 0);
                } else {
                    if (this.fu == null) {
                        this.fu = new c();
                    }
                    this.fu.setLocation(this.getX() + this.getWidth() / 2 - this.fu.getWidth() / 2, this.getY() + this.getHeight() / 2 - this.fu.getHeight() / 2);
                    if (this.fu.getParent() == null) {
                        this.getParent().add((Component)this.fu, 0);
                    }
                    this.fu.setVisible(true);
                }
            } else if (string.equals("setContribution")) {
                this.fn.void().a("\u8f93\u5165\u4f60\u8981\u4e3a\u8be5\u4f1a\u5458\u8bbe\u7f6e\u7684\u8d21\u732e\u503c0-99999", "okContribution", this);
            } else if (string.equals("okContribution")) {
                try {
                    int n5 = Integer.parseInt(this.fn.void().cK());
                    if (n5 < 0 || n5 > 99999) {
                        this.fn.new().if("\u975e\u6cd5\u7684\u6570\u5b57\u8f93\u5165\uff1a" + n5, -65536);
                    } else {
                        this.fn.byte().do(this.fm.for, n5);
                    }
                }
                catch (NumberFormatException numberFormatException) {
                    this.fn.new().if("\u8f93\u5165\u6570\u5b57\u975e\u6cd5\uff01", -65536);
                }
            }
        }
    }

    public void g(String string) {
        this.fq.c0 -= 10;
        f.a a10 = this.fq.if(string);
        if (a10 != null) {
            this.fl[0].case(string);
            if (a10.do) {
                this.fl[1].case(string);
            }
            this.fn.goto().w("\u300e" + string + "\u300f\u88ab\u4f1a\u957f\u5f00\u9664\uff0c\u516c\u4f1a\u58f0\u671b\u51cf\u5c1110\u70b9");
        }
        if (this.fq.c0 < 0) {
            this.fn.new().if("\u4f60\u516c\u4f1a\u7684\u58f0\u671b\u5c11\u4e8e0\uff0c\u968f\u65f6\u9762\u4e34\u964d\u7ea7\u6216\u89e3\u6563\u7684\u5371\u9669\uff0c\u8bf7\u8d76\u5feb\u60f3\u6cd5\u63d0\u9ad8\u516c\u4f1a\u7684\u58f0\u671b\u5427\uff01", 0xFF0000);
        }
    }

    public void if(a.a.e e2) {
        k k2 = this.fn.for();
        this.fq = new b.a.d.f();
        this.fq.a(e2);
        k2.aj = this.fq.a;
        k2.al = this.fq.cx;
        k2.ah = this.fq.cU;
        k2.ak = this.fq;
        k2.ai = 0;
        this.b3();
        this.setVisible(true);
        this.fn.goto().w("\u4f60\u52a0\u5165\u4e86\u516c\u4f1a\u300e" + this.fq.a + "\u300f");
    }

    public void a(String string, int n2, int n3) {
        this.fn.goto().w("\u300e" + string + "\u300f\u4e3a\u516c\u4f1a\u6350\u732e\u4e86" + n2 + "\u91d1\u5e01");
        this.fq.cI += n2;
        if (string.equals(this.fn.for().a)) {
            this.fn.for().bA.fk -= n2;
        }
    }

    public void b2() {
        this.fq.cx += -1;
        this.fq.cY += 20;
        this.fq.cT += 50;
        this.fn.for().al = this.fq.cx;
        this.fv = this.fq.a + "[" + this.fq.cx + "\u7ea7]";
        this.fn.new().if("\u7531\u4e8e\u8fd0\u8f6c\u4e0d\u7075\uff0c\u4f60\u7684\u516c\u4f1a\u88ab\u964d\u7ea7\u4e86", -16711936);
    }

    public void b6() {
        ++this.fq.cx;
        this.fq.cY += 20;
        this.fq.cT += 50;
        this.fn.for().al = this.fq.cx;
        this.fv = this.fq.a + "[" + this.fq.cx + "\u7ea7]";
        this.fn.new().if("\u606d\u559c\uff0c\u4f60\u7684\u516c\u4f1a\u7b49\u7ea7\u63d0\u5347\u4e86", -16711936);
    }

    public void if(String string, String string2, int n2) {
        this.fq.cB = string2;
        this.fq.c0 = n2;
        k k2 = this.fn.for();
        if (k2.a.equals(string)) {
            k2.ai = 1;
            this.fn.new().if("\u4f60\u5931\u53bb\u4e86\u4f1a\u957f\u804c\u4f4d", 0xFFFFFF);
        } else if (k2.a.equals(string2)) {
            k2.ai = 2;
            this.fn.new().if("\u4f60\u83b7\u5f97\u4e86\u4f1a\u957f\u804c\u4f4d", 0xFFFFFF);
        }
        this.fq.do((String)string).if = 1;
        this.fq.do((String)string2).if = 2;
    }

    public void c(String string) {
        this.fq.cV = string;
        this.fk.if(new o(string, this.fk.getWidth(), 0xFFFFFF, 24));
        String string2 = "\u3010\u516c\u4f1a\u516c\u544a\u3011" + string;
        this.fn.goto().x(string2);
        this.fn.c().aB().T().void("guild").new(string2);
    }

    public void v(int n2) {
        int n3 = this.fq.cI;
        this.fq.cI = n2;
        String string = "";
        string = n3 > n2 ? "\u516c\u4f1a\u8d44\u4ea7\u51cf\u5c11\u4e86" + (n3 - n2) : "\u516c\u4f1a\u8d44\u4ea7\u589e\u52a0\u4e86" + (n2 - n3);
        this.fn.c().aB().T().void("guild").if("\u3010\u4fe1\u606f\u3011", 0, string, -1);
        this.fn.goto().w(string);
    }

    public f(b.a.c.b b2) {
        this.fn = b2;
        this.char(true);
        this.setVisible(false);
    }

    public void a(a.b.c c2) {
        b.a.d.f f2 = this.fq;
        if (f2 == null) {
            e.a(c2, "\u6682\u65e0\u516c\u4f1a", this.getWidth(), this.getHeight());
            super.a(c2);
            return;
        }
        e.if(c2, this.getWidth(), this.getHeight());
        c2.if(e.a5, 7, 7, f2.cU * 16, 720, 16, 16);
        c2.a(this.fv, 26, 9, b.a.d.f.cZ[f2.cx]);
        super.a(c2);
        int n2 = this.fl[0].getX();
        int n3 = this.fl[0].getY() - 1;
        int n4 = n3 + this.fl[0].getHeight();
        c2.do(4, n3, this.getWidth() - 4, n3, -3750223);
        c2.do(4, n3 -= 14, this.getWidth() - 4, n3, -3750223);
        c2.do(100, n3, 100, n4, -3750223);
        c2.do(154, n3, 154, n4, -3750223);
        c2.do(208, n3, 208, n4, -3750223);
        c2.do(262, n3, 262, n4, -3750223);
        c2.do(316, n3, 316, n4, -3750223);
        c2.do(4, n4, this.getWidth() - 4, n4, -3750223);
        c2.a(7, 33, 152, 14, -16724737);
        c2.a("\u516c\u4f1a\u4f1a\u957f:", 8, 34, 0);
        c2.a(f2.cB, 62, 34, 0);
        c2.a(199, 33, 174, 14, -16724737);
        c2.a("\u521b\u5efa\u65f6\u95f4:", 200, 34, 0);
        c2.a(a.a.b.do(f2.cE), 254, 34, 0);
        c2.a(7, 53, 92, 14, -16724737);
        c2.a("\u516c\u4f1a\u58f0\u671b:", 8, 54, 0);
        e.a(c2, f2.c0, 62, 54, 0);
        c2.a(135, 53, 110, 14, -16724737);
        c2.a("\u516c\u4f1a\u8d44\u91d1:", 136, 54, 0);
        e.a(c2, f2.cI, 190, 54, 0);
        c2.a(275, 53, 98, 14, -16724737);
        c2.a("\u516c\u4f1a\u6210\u5458:", 276, 54, 0);
        n2 = e.a(c2, f2.cw.for(), 330, 54, 0);
        c2.a('/', n2, 54, 0);
        e.a(c2, f2.cY, n2 + 6, 54, 0);
        c2.if(this.fk.getX() - 1, this.fk.getY() - 3, this.fk.getWidth() + 2, this.fk.getHeight() + 2, -16724737);
    }

    protected void processMouseEvent(MouseEvent mouseEvent) {
        if (mouseEvent.getY() < 30 || mouseEvent.getY() > this.getHeight() - 30) {
            super.processMouseEvent(mouseEvent);
            return;
        }
        if (mouseEvent.getID() == 500 && mouseEvent.getClickCount() > 1 && this.fk.contains(mouseEvent.getX() - this.fk.getX(), mouseEvent.getY() - this.fk.getY()) && this.fq != null && this.fn.for().ai > 0) {
            if (this.fo.isVisible()) {
                this.fn.void().a("\u8bf7\u8f93\u5165\u516c\u4f1a\u4ecb\u7ecd\u6587\u5b57(100\u5b57\u4ee5\u5185)", "setIntro", this);
            } else {
                this.fn.void().a("\u8bf7\u8f93\u5165\u516c\u4f1a\u516c\u544a\u6587\u5b57(100\u5b57\u4ee5\u5185)", "setNotice", this);
            }
        }
    }

    public void d(String string) {
        this.fq.c0 -= 5;
        f.a a10 = this.fq.if(string);
        if (a10 != null) {
            this.fl[0].case(string);
            if (a10.do) {
                this.fl[1].case(string);
            }
            this.fn.goto().w("\u300e" + string + "\u300f\u79bb\u5f00\u4e86\u516c\u4f1a\uff0c\u516c\u4f1a\u58f0\u671b\u964d\u4f4e5\u70b9");
        }
        if (this.fq.c0 < 0) {
            this.fn.new().if("\u4f60\u516c\u4f1a\u7684\u58f0\u671b\u5c11\u4e8e0\uff0c\u968f\u65f6\u9762\u4e34\u964d\u7ea7\u6216\u89e3\u6563\u7684\u5371\u9669\uff0c\u8bf7\u8d76\u5feb\u60f3\u6cd5\u63d0\u9ad8\u516c\u4f1a\u7684\u58f0\u671b\u5427\uff01", 0xFF0000);
        }
    }

    public void do(a.a.e e2) {
        k k2 = this.fn.for();
        this.fq = new b.a.d.f();
        this.fq.a(e2);
        k2.ak = this.fq;
        k2.ai = this.fq.do((String)k2.a).if;
        this.b3();
    }

    public void h(String string) {
        this.fq.a = string;
        this.fn.for().aj = string;
        this.fv = this.fq.a + "[" + this.fq.cx + "\u7ea7]";
    }

    public void b7() {
        this.fn.goto().w("\u4f60\u79bb\u5f00\u4e86\u516c\u4f1a\u300e" + this.fq.a + "\u300f");
        int n2 = 0;
        while (n2 < this.ft.length) {
            if (this.ft[n2] != null) {
                this.ft[n2].setVisible(false);
            }
            ++n2;
        }
        ((s)this.case()).setVisible(false);
        this.fl[0].setVisible(false);
        this.fl[1].setVisible(false);
        this.fk.setVisible(false);
        this.fo.setVisible(false);
        if (this.fu != null && this.fu.getParent() != null) {
            this.getParent().remove(this.fu);
        }
        if (this.fj != null && this.fj.getParent() != null) {
            this.getParent().remove(this.fj);
        }
        k k2 = this.fn.for();
        k2.al = 0;
        k2.ah = 0;
        k2.aj = "";
        this.fv = "";
        this.fq = null;
        k2.ak = null;
    }

    public void new(String string, int n2) {
        ++this.fq.c0;
        this.fq.do((String)string).try = n2;
        String string2 = "\u516c\u4f1a\u6210\u5458\u300e" + string + "\u300f\u7b49\u7ea7\u63d0\u5347\u4e86\uff0c\u516c\u4f1a\u58f0\u671b\u63d0\u9ad81\u70b9";
        this.fn.c().aB().T().void("guild").if("\u3010\u4fe1\u606f\u3011", 0, string2, -1);
        this.fn.goto().w(string2);
    }

    public void u(int n2) {
        int n3 = this.fq.c0;
        this.fq.c0 = n2;
        String string = "";
        string = n3 > n2 ? "\u516c\u4f1a\u58f0\u671b\u51cf\u5c11\u4e86" + (n3 - n2) : "\u516c\u4f1a\u58f0\u671b\u589e\u52a0\u4e86" + (n2 - n3);
        this.fn.c().aB().T().void("guild").if("\u3010\u4fe1\u606f\u3011", 0, string, -1);
        this.fn.goto().w(string);
        if (this.fq.c0 < 0) {
            this.fn.new().if("\u4f60\u516c\u4f1a\u7684\u58f0\u671b\u5c11\u4e8e0\uff0c\u968f\u65f6\u9762\u4e34\u964d\u7ea7\u6216\u89e3\u6563\u7684\u5371\u9669\uff0c\u8bf7\u8d76\u5feb\u60f3\u6cd5\u63d0\u9ad8\u516c\u4f1a\u7684\u58f0\u671b\u5427\uff01", 0xFF0000);
        }
    }

    static {
        fi = new String[]{"\u5bc6\u8bed", "\u67e5\u770b\u4fe1\u606f", "\u9080\u8bf7\u7ec4\u961f", "\u590d\u5236\u540d\u5b57"};
        fw = new String[]{"whisper", "view", "teamInvite", "copyName"};
        fp = new String[]{"\u5bc6\u8bed", "\u62c9\u5230\u9762\u524d", "\u4f20\u9001\u8fc7\u53bb", "\u67e5\u770b\u4fe1\u606f", "\u9080\u8bf7\u7ec4\u961f", "\u5f00\u9664\u4f1a\u5458", "\u590d\u5236\u540d\u5b57", "\u8bbe\u7f6e/\u53d6\u6d88\u526f\u4f1a\u957f", "\u8f6c\u8ba9\u4f1a\u957f\u8eab\u4efd", "\u8bbe\u7f6e/\u53d6\u6d88\u79f0\u53f7", "\u4fee\u6539\u8d21\u732e\u503c"};
        fx = new String[]{"whisper", "pullMember", "gotoMember", "view", "teamInvite", "delete", "copyName", "viceLeader", "transferLeader", "setTitle", "setContribution"};
    }

    public void e(String string) {
        this.fq.cz = string;
        this.fo.if(new o(string, this.fo.getWidth(), 0xFFFFFF, 24));
        if (!this.fq.cB.equals(this.fn.for().a)) {
            this.fn.goto().w("\u516c\u4f1a\u7ba1\u7406\u5458\u4fee\u6539\u4e86\u516c\u4f1a\u4ecb\u7ecd\u4fe1\u606f");
        }
    }

    public void try(String string, int n2) {
        this.fq.do((String)string).a = n2;
        String string2 = "\u516c\u4f1a\u6210\u5458\u300e" + string + "\u300f\u7684\u8d21\u732e\u5ea6\u6539\u53d8\u4e86";
        this.fn.c().aB().T().void("guild").if("\u3010\u4fe1\u606f\u3011", 0, string2, -1);
        this.fn.goto().w(string2);
    }

    public void t(int n2) {
        this.fq.cP[n2] = null;
        if (this.fj != null && this.fj.isVisible() && this.fj.getParent() != null) {
            this.fj.repaint();
        }
    }

    public void int(String string, int n2) {
        this.fq.c0 += 100;
        f.a a10 = this.fq.do(string);
        a10.int = n2;
        a10.try = 0;
        String string2 = "\u516c\u4f1a\u6210\u5458\u300e" + string + "\u300f\u8f6c\u751f\u4e86\uff0c\u516c\u4f1a\u58f0\u671b\u63d0\u9ad8100\u70b9";
        this.fn.c().aB().T().void("guild").if("\u3010\u4fe1\u606f\u3011", 0, string2, -1);
        this.fn.goto().w(string2);
    }

    public void b5() {
        int n2 = 384;
        int n3 = 392;
        this.setBounds(128, 40, n2, n3);
        g g2 = new g();
        g2.setBounds(this.getWidth() - 23, 7, 15, 15);
        this.add(g2);
        s s2 = new s();
        s2.setBounds(4, 72, this.getWidth() - 8, 12);
        s2.setVisible(false);
        this.a(s2);
        String[] stringArray = new String[]{"\u540d\u5b57", "\u804c\u52a1", "\u804c\u4e1a", "\u8f6c\u751f", "\u7b49\u7ea7", "\u8d21\u732e"};
        int[] nArray = new int[]{100, 54, 54, 54, 54, 54};
        int n4 = 0;
        int n5 = 0;
        while (n5 < stringArray.length) {
            s s3 = new s();
            s3.if(new q(stringArray[n5], -527356));
            s3.setBounds(n4, 0, nArray[n5], 12);
            s3.a(8);
            s2.add(s3);
            n4 += nArray[n5];
            ++n5;
        }
        this.add(s2);
        n5 = 0;
        while (n5 < this.fl.length) {
            this.fl[n5] = new z();
            this.fl[n5].setBounds(4, 86, this.getWidth() - 8, 200);
            this.add(this.fl[n5]);
            ++n5;
        }
        this.fl[0].setVisible(false);
        this.fl[1].setVisible(false);
        this.ft[0] = bf.a("\u516c\u4f1a\u4ecb\u7ecd", "guildIntro", this, 6, 290, 52, 16);
        this.add(this.ft[0]);
        this.ft[1] = bf.a("\u516c\u4f1a\u516c\u544a", "guildNotice", this, 60, 290, 52, 16);
        this.add(this.ft[1]);
        this.ft[2] = bf.a("\u5168\u90e8\u4f1a\u5458", "showAll", this, this.getWidth() - 110, 290, 52, 16);
        this.add(this.ft[2]);
        this.ft[3] = bf.a("\u5728\u7ebf\u4f1a\u5458", "showOnline", this, this.getWidth() - 56, 290, 52, 16);
        this.add(this.ft[3]);
        this.fo = new s();
        this.fo.setBounds(6, 312, this.getWidth() - 12, 48);
        this.fo.setVisible(false);
        this.add(this.fo);
        this.fk = new s();
        this.fk.setBounds(6, 312, this.getWidth() - 12, 46);
        this.fk.setVisible(false);
        this.add(this.fk);
        this.ft[4] = al.a(2, "\u8d44\u4ea7\u6350\u732e", "contribute", this, 6, this.getHeight() - 25, 66, 19);
        this.add(this.ft[4]);
        this.ft[5] = al.a(2, "\u516c\u4f1a\u4ed3\u5e93", "store", this, 74, this.getHeight() - 25, 66, 19);
        this.add(this.ft[5]);
        this.ft[6] = al.a(2, "\u524d\u5f80\u9a7b\u5730", "conveyToSign", this, 142, this.getHeight() - 25, 66, 19);
        this.add(this.ft[6]);
        this.ft[7] = al.a(2, "\u516c\u4f1a\u4efb\u52a1", "openTask", this, 210, this.getHeight() - 25, 66, 19);
        this.add(this.ft[7]);
        this.ft[8] = al.a(2, "\u9000\u51fa\u516c\u4f1a", "leaveGuild", this, this.getWidth() - 72, this.getHeight() - 25, 66, 19);
        this.add(this.ft[8]);
        n5 = 0;
        while (n5 < this.ft.length) {
            if (this.ft[n5] != null) {
                this.ft[n5].setVisible(false);
            }
            ++n5;
        }
    }

    public void a(a.a.e e2) {
        k k2 = this.fn.for();
        this.fq = new b.a.d.f();
        this.fq.a(e2);
        k2.al = this.fq.cx;
        k2.aj = this.fq.a;
        k2.ah = this.fq.cU;
        k2.ai = 2;
        this.b3();
        k2.ak = this.fq;
        this.setVisible(true);
        this.fn.new().if("\u606d\u559c\u4f60\u6210\u529f\u521b\u5efa\u4e86\u516c\u4f1a\uff01\u4f60\u9700\u8981\u591a\u52aa\u529b\u58ee\u5927\u516c\u4f1a\uff0c\u53d1\u5c55\u4f1a\u5458\uff0c\u63d0\u9ad8\u516c\u4f1a\u8d44\u4ea7\u548c\u516c\u4f1a\u58f0\u671b\u3002", -16711936);
    }

    public a b4() {
        return this.fj;
    }

    private class b
    extends s {
        f.a bz;
        boolean by;

        b(f.a a10) {
            f.this.getClass();
            this.bz = a10;
            this.enableEvents(16L);
            this.setSize(0, 20);
            this.setName(a10.for);
        }

        public void a(a.b.c c2) {
            int n2 = 0xFFFFFF;
            if (this.by) {
                c2.a(0, 0, this.getWidth(), this.getHeight(), -12017997);
            }
            if (!this.bz.do) {
                n2 = 0x7F7F7F;
            }
            c2.a(this.bz.for, 0, 4, n2);
            c2.a(b.a.d.f.cA[this.bz.if], 100, 4, n2);
            c2.a(d.ap[this.bz.new], 154, 4, n2);
            e.a(c2, this.bz.int, 208, 4, n2);
            e.a(c2, this.bz.try, 262, 4, n2);
            e.a(c2, this.bz.a, 316, 4, n2);
        }

        protected void processMouseEvent(MouseEvent mouseEvent) {
            if (mouseEvent.getID() == 504) {
                this.by = true;
                this.repaint();
            } else if (mouseEvent.getID() == 505) {
                this.by = false;
                this.repaint();
            } else if (mouseEvent.getID() == 501 && mouseEvent.getModifiers() == 4) {
                f.this.fm = this.bz;
                if (!this.bz.for.equals(f.this.fn.for().a)) {
                    if (f.this.fq.cB.equals(f.this.fn.for().a)) {
                        this.a(fp, fx, f.this, mouseEvent.getX(), mouseEvent.getY());
                    } else {
                        this.a(fi, fw, f.this, mouseEvent.getX(), mouseEvent.getY());
                    }
                }
            } else if (mouseEvent.getID() == 500 && mouseEvent.getClickCount() > 1) {
                if (this.bz.do) {
                    f.this.fn.c().ag().t(this.bz.for);
                } else {
                    f.this.fn.new().if(this.bz.for + "\u5f53\u524d\u4e0d\u5728\u7ebf\uff0c\u65e0\u6cd5\u5bc6\u8bed", -65281);
                }
            }
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    private class a
    extends a.b.z
    implements ActionListener,
    a.b.i,
    a.b.a {
        int fc;
        String fe;
        private j ff;
        private int fd;
        private i fb;

        private void case(int n2, int n3) {
            j j2 = this.char(n2, n3);
            if (j2 != this.ff) {
                if (j2 != null) {
                    at at2 = at.b();
                    at2.a(j2, false, false, 0, 0, false);
                    this.a(null, at2, n2, n3);
                } else {
                    this.b1();
                }
                this.ff = j2;
            }
        }

        private j char(int n2, int n3) {
            int n4 = 31;
            int n5 = 4;
            int n6 = this.fc * 80;
            int n7 = 0;
            while (n7 < 10 && n6 < f.this.fq.cT) {
                n5 = 4;
                int n8 = 0;
                while (n8 < 8 && n6 < f.this.fq.cT) {
                    if (f.this.fq.cP[n6] != null && n2 > n5 + 2 && n3 > n4 + 1 && n2 < n5 + 24 && n3 < n4 + 24) {
                        this.fd = n6;
                        return f.this.fq.cP[n6];
                    }
                    ++n8;
                    n5 += 28;
                    ++n6;
                }
                n4 += 28;
                ++n7;
            }
            this.fd = -1;
            return null;
        }

        public a() {
            f.this.getClass();
            this.fe = "\u516c\u4f1a\u4ed3\u5e93[\u7b2c1\u9875]";
            this.fb = new i();
            int n2 = 232;
            int n3 = 341;
            this.setSize(n2, n3);
            this.char(true);
            this.add(al.a(2, "\u4e0a\u9875", "prev", this, 6, this.getHeight() - 25, 44, 19));
            this.add(al.a(2, "\u4e0b\u9875", "next", this, 54, this.getHeight() - 25, 44, 19));
            this.add(al.a(2, "\u53d6\u94b1", "takeMoney", f.this, 102, this.getHeight() - 25, 44, 19));
            this.add(al.a(2, "\u5173\u95ed", "close", this, this.getWidth() - 56, this.getHeight() - 25, 44, 19));
        }

        public void a() {
            if (f.this.fn.for().ai == 1 || f.this.fn.for().ai == 2) {
                f.this.fn.byte().I(this.fd);
            } else {
                f.this.fn.new().if("\u4f60\u6ca1\u6709\u53d6\u51fa\u7269\u54c1\u7684\u6743\u9650", 0xFF0000);
            }
        }

        public void a(a.b.c c2) {
            e.a(c2, this.fe, this.getWidth(), this.getHeight());
            int n2 = 31;
            int n3 = 4;
            int n4 = this.fc * 80;
            int n5 = 0;
            while (n5 < 10 && n4 < f.this.fq.cT) {
                n3 = 4;
                int n6 = 0;
                while (n6 < 8 && n4 < f.this.fq.cT) {
                    e.a(c2, n3, n2);
                    if (f.this.fq.cP[n4] != null) {
                        e.a(c2, f.this.fq.cP[n4], n3 + 2, n2 + 1);
                    }
                    ++n6;
                    n3 += 28;
                    ++n4;
                }
                n2 += 28;
                ++n5;
            }
            super.a(c2);
        }

        protected void processMouseEvent(MouseEvent mouseEvent) {
            mouseEvent.getX();
            int n2 = mouseEvent.getY();
            if (n2 < 30 || n2 >= this.getHeight() - 30) {
                super.processMouseEvent(mouseEvent);
                return;
            }
            if (mouseEvent.getID() == 501 && this.ff != null) {
                this.fb.a(this.ff);
                this.a(this.fb, this, mouseEvent.getX(), mouseEvent.getY());
            }
            this.b1();
        }

        public Object if() {
            return this.ff;
        }

        private void b1() {
            this.a((Rectangle)null, (a.b.b)null, 0, 0);
        }

        protected void processMouseMotionEvent(MouseEvent mouseEvent) {
            if (mouseEvent.getID() == 503) {
                this.case(mouseEvent.getX(), mouseEvent.getY());
            } else {
                super.processMouseMotionEvent(mouseEvent);
            }
        }

        public void actionPerformed(ActionEvent actionEvent) {
            String string = actionEvent.getActionCommand();
            if (string.equals("prev")) {
                if (this.fc > 0) {
                    this.fc += -1;
                    this.fe = "\u516c\u4f1a\u4ed3\u5e93[\u7b2c" + (this.fc + 1) + "\u9875]";
                    this.repaint();
                }
            } else if (string.equals("next")) {
                if ((this.fc + 1) * 80 < f.this.fq.cT) {
                    ++this.fc;
                    this.fe = "\u516c\u4f1a\u4ed3\u5e93[\u7b2c" + (this.fc + 1) + "\u9875]";
                    this.repaint();
                }
            } else if (string.equals("close")) {
                this.getParent().remove(this);
            }
        }

        public void do() {
        }

        public void a(a.b.a a10, int n2, int n3) {
            a5 a52 = f.this.fn.c().aD();
            if (a10 != a52) {
                return;
            }
            j j2 = (j)a52.if();
            if (j2.fF > 0) {
                a52.ds();
            } else {
                f.this.fn.new().if("\u8be5\u7269\u54c1\u4e0d\u53ef\u5b58\u4ed3\u5e93", -65536);
            }
        }
    }

    private class c
    extends a.b.z
    implements ActionListener {
        bf[] fh;
        int fg;

        public c() {
            f.this.getClass();
            this.fh = new bf[b.a.d.f.cA.length - 3];
            int n2 = 200;
            int n3 = 268;
            this.setSize(n2, n3);
            this.char(true);
            int n4 = 0;
            while (n4 < this.fh.length) {
                this.fh[n4] = bf.a(b.a.d.f.cA[n4 + 3], "pos", this, n4 / 10 * 58 + 12, n4 % 10 * 20 + 36, 54, 16);
                this.add(this.fh[n4]);
                ++n4;
            }
            this.fh[0].else(true);
            this.add(al.a(2, "\u53d6\u6d88", "cancel", this, 6, this.getHeight() - 25, 44, 19));
            this.add(al.a(2, "\u786e\u5b9a", "ok", this, this.getWidth() - 50, this.getHeight() - 25, 44, 19));
        }

        public void a(a.b.c c2) {
            e.a(c2, "\u9009\u62e9\u804c\u4f4d", this.getWidth(), this.getHeight());
            super.a(c2);
        }

        public void actionPerformed(ActionEvent actionEvent) {
            String string = actionEvent.getActionCommand();
            if (string.equals("pos")) {
                int n2 = 0;
                while (n2 < this.fh.length) {
                    if (this.fh[n2] == actionEvent.getSource()) {
                        this.fg = n2;
                        this.fh[n2].else(true);
                    } else {
                        this.fh[n2].else(false);
                    }
                    ++n2;
                }
            } else if (string.equals("ok")) {
                f.this.fn.byte().a(f.this.fm.for, this.fg + 3);
                this.getParent().remove(this);
            } else if (string.equals("cancel")) {
                this.getParent().remove(this);
            }
        }
    }
}

