/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.l;
import a.b.n;
import a.b.q;
import a.b.s;
import b.a.b.p;
import b.a.c.b.al;
import b.a.c.b.bf;
import b.a.c.b.e;
import b.a.d.d;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class m
extends s
implements ActionListener {
    b.a.c.b b1;
    private s b5;
    private s b6;
    private s b3;
    private s b4;
    private b.a.d.l b2;

    private void a(s s2, String string) {
        s s3 = new s();
        s3.a(24);
        s3.if(new q(string, -2301840));
        s3.setBounds(0, 2, s2.getWidth(), 26);
        s2.add(s3);
    }

    public m(b.a.c.b b2) {
        this.b1 = b2;
    }

    public void a(c c2) {
        if (this.b5.isVisible()) {
            int n2 = this.b5.getX();
            int n3 = this.b5.getY();
            int n4 = this.b5.getWidth();
            int n5 = this.b5.getHeight();
            c2.do(n2, n3);
            c2.a(0, 0, this.b5.getWidth(), this.b5.getHeight(), -1627389952);
            e.for(c2, 0, 0, n4);
            e.if(c2, 0, 26, n4, n5 - 52);
            c2.a("\u5e10\u53f7\uff1a", 64, 44, -1);
            c2.a("\u5bc6\u7801\uff1a", 64, 75, -1);
            c2.if(104, 43, 82, 16, -9944012);
            c2.if(104, 74, 82, 16, -9944012);
            e.a(c2, 0, n5 - 26, n4);
            this.b5.a(c2);
            c2.do(-n2, -n3);
        } else if (this.b6.isVisible()) {
            int n6 = this.b6.getX();
            int n7 = this.b6.getY();
            int n8 = this.b6.getWidth();
            int n9 = this.b6.getHeight();
            c2.do(n6, n7);
            e.for(c2, 0, 0, n8);
            c2.a(0, 0, this.b6.getWidth(), this.b6.getHeight(), -1627389952);
            e.if(c2, 0, 26, n8, n9 - 52);
            c2.if(124, 57, 142, 20, -9944012);
            c2.if(124, 95, 142, 20, -9944012);
            c2.if(124, 133, 142, 20, -9944012);
            e.a(c2, 0, n9 - 26, n8);
            this.b6.a(c2);
            c2.do(-n6, -n7);
        } else if (this.b3.isVisible()) {
            int n10 = this.b3.getX();
            int n11 = this.b3.getY();
            int n12 = this.b3.getWidth();
            int n13 = this.b3.getHeight();
            c2.do(n10, n11);
            c2.a(0, 0, this.b3.getWidth(), this.b3.getHeight(), -1627389952);
            e.for(c2, 0, 0, n12);
            e.if(c2, 0, 26, n12, n13 - 52);
            e.a(c2, 0, n13 - 26, n12);
            this.b3.a(c2);
            c2.do(-n10, -n11);
        } else if (this.b4.isVisible()) {
            int n14 = this.b4.getX();
            int n15 = this.b4.getY();
            int n16 = this.b4.getWidth();
            int n17 = this.b4.getHeight();
            c2.do(n14, n15);
            c2.a(0, 0, this.b4.getWidth(), this.b4.getHeight(), -1627389952);
            e.for(c2, 0, 0, n16);
            e.if(c2, 0, 26, n16, n17 - 52);
            c2.if(79, 41, 122, 20, -9944012);
            e.a(c2, 0, n17 - 26, n16);
            this.b4.a(c2);
            c2.do(-n14, -n15);
        }
    }

    private int aU() {
        a[] aArray = (a[])this.b3.case();
        int n2 = 0;
        while (n2 < aArray.length) {
            if (aArray[n2].bR && aArray[n2].bO.length() > 0) {
                return this.b2.dh[n2];
            }
            ++n2;
        }
        return 0;
    }

    public void a(int n2, a.a.e e2) {
        boolean bl = e2.c();
        if (!bl) {
            this.b1.new().if(e2.f(), -65536);
            return;
        }
        if (this.b1.new().isVisible()) {
            this.b1.new().setVisible(false);
        }
        if (n2 == 1 || n2 == 2) {
            this.b2.a(e2);
            this.a6();
        } else if (n2 == 5) {
            this.b1.for().for(e2);
            this.b1.else();
        } else if (n2 == 3) {
            String string = e2.h();
            int n3 = e2.case();
            int n4 = e2.case();
            int n5 = 0;
            while (n5 < this.b2.dn.length) {
                if (this.b2.dn[n5].length() == 0) {
                    this.b2.dn[n5] = string;
                    this.b2.dj[n5] = n3;
                    this.b2.df[n5] = n4;
                    this.b2.dl[n5] = 0;
                    this.b2.c5[n5] = 0;
                    this.b2.dh[n5] = 0;
                    break;
                }
                ++n5;
            }
            this.a6();
        } else if (n2 == 4) {
            String string = e2.h();
            this.b2.int(string);
            a[] aArray = (a[])this.b3.case();
            int n6 = 0;
            while (n6 < aArray.length) {
                if (aArray[n6].bO.equals(string)) {
                    aArray[n6].aT();
                    break;
                }
                ++n6;
            }
        }
    }

    private void a2() {
        n[] nArray = (n[])this.b5.case();
        if (nArray[0].D().length() == 0) {
            this.b1.new().if("\u8bf7\u8f93\u5165\u5e10\u53f7\uff01", -65536);
            return;
        }
        if (nArray[1].D().length() == 0) {
            this.b1.new().if("\u8bf7\u8f93\u5165\u5bc6\u7801\uff01", -65536);
            return;
        }
        if (!this.try(nArray[1].D())) {
            this.b1.new().if("\u4f60\u8f93\u5165\u7684\u5bc6\u7801\u4e2d\u542b\u6709\u975e\u6cd5\u5b57\u7b26\uff01", -65536);
            return;
        }
        this.b1.new().do("\u8fde\u63a5\u670d\u52a1\u5668...", -1);
        a.a.e e2 = new a.a.e(64);
        int n2 = (int)(Math.random() * 255.0);
        e2.char(n2);
        byte[] byArray = nArray[0].D().getBytes();
        int n3 = 0;
        while (n3 < byArray.length) {
            byArray[n3] = (byte)(byArray[n3] ^ n2);
            ++n3;
        }
        e2.a(byArray.length);
        e2.a(byArray);
        String string = nArray[1].D();
        if ("true".equals(this.b1.do().getParameter("md5Password"))) {
            string = a.a.b.do(string);
        }
        byArray = string.getBytes();
        int n4 = 0;
        while (n4 < byArray.length) {
            byArray[n4] = (byte)(byArray[n4] ^ n2);
            ++n4;
        }
        e2.a(byArray.length);
        e2.a(byArray);
        String string2 = this.b1.do().getParameter("adOwner");
        e2.do(string2);
        this.b1.byte().a(2, e2);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (this.b1.new().isVisible()) {
            return;
        }
        String string = actionEvent.getActionCommand();
        if (string.equals("focusToPassword")) {
            n[] nArray = (n[])this.b5.case();
            nArray[1].requestFocus();
        } else if (string.equals("loginOK")) {
            this.a2();
        } else if (string.equals("register")) {
            String string2 = this.b1.do().getParameter("registerPage");
            if (string2 != null && string2.length() > 5) {
                this.b1.do().for(string2);
            } else {
                String string3 = this.b1.do().new();
                if (string3.indexOf("webgame.com") >= 0 && string3.indexOf("azbeta") < 0) {
                    this.b1.do().for("http://passport.webgame.com.cn/register.do");
                } else {
                    this.b5.setVisible(false);
                    this.b6.setVisible(true);
                    n[] nArray = (n[])this.b6.case();
                    nArray[0].requestFocus();
                }
            }
        } else if (string.equals("changePassword")) {
            String string4 = this.b1.do().getParameter("changePwdPage");
            this.b1.do().for(string4);
        } else if (string.equals("findPassword")) {
            String string5 = this.b1.do().getParameter("findPwdPage");
            this.b1.do().for(string5);
        } else if (string.equals("registerOK")) {
            this.aV();
        } else if (string.equals("back")) {
            if (this.b4.isVisible()) {
                this.b4.setVisible(false);
                this.b3.setVisible(true);
            } else if (this.b6.isVisible()) {
                this.b6.setVisible(false);
                this.b5.setVisible(true);
                n[] nArray = (n[])this.b5.case();
                nArray[0].requestFocus();
            }
        } else if (string.equals("createHero")) {
            a[] aArray = (a[])this.b3.case();
            int n2 = 0;
            while (n2 < aArray.length) {
                if (aArray[n2].bO.length() == 0) {
                    this.b3.setVisible(false);
                    this.b4.setVisible(true);
                    s[] sArray = (s[])this.b4.case();
                    ((n)sArray[0]).requestFocus();
                    if (e.a3[0][0] == null) {
                        this.b1.char().a("hero");
                    }
                    return;
                }
                ++n2;
            }
            this.b1.new().if("\u4f60\u4e0d\u80fd\u518d\u521b\u5efa\u89d2\u8272\u4e86\uff01", -65536);
        } else if (string.equals("deleteHero")) {
            this.b1.void().a("\u4f60\u786e\u5b9a\u5220\u9664\u5417\uff1f\u8bf7\u8f93\u5165\u89d2\u8272\u7684\u4fdd\u62a4\u5bc6\u7801\uff0c\u5982\u679c\u6ca1\u6709\u5bc6\u7801\u8bf7\u8f93\u5165delete\uff1a", '*', "yesDeleteHero", this);
        } else if (string.equals("yesDeleteHero")) {
            if (this.aZ() != null) {
                this.byte(this.b1.void().cK());
            } else {
                this.b1.new().if("\u8bf7\u9009\u62e9\u8981\u5220\u9664\u7684\u89d2\u8272\uff01", -65536);
            }
        } else if (string.equals("createHeroOK")) {
            this.aY();
        } else if (string.startsWith("chooseRace:")) {
            bf bf2 = (bf)actionEvent.getSource();
            if (bf2.try() == null) {
                int n3 = string.charAt(string.length() - 1) - 48;
                s[] sArray = (s[])this.b4.case();
                ((b)sArray[1]).bZ = n3;
                sArray[1].repaint();
            }
        } else if (string.startsWith("chooseSex:")) {
            bf bf3 = (bf)actionEvent.getSource();
            if (bf3.try() == null) {
                int n4 = string.charAt(string.length() - 1) - 48;
                s[] sArray = (s[])this.b4.case();
                ((b)sArray[1]).b0 = n4;
                sArray[1].repaint();
            }
        } else if (string.equals("enterGame")) {
            this.a1();
        } else if (string.equals("yesEnterGame")) {
            String string6 = this.b1.void().cK();
            this.a(this.aZ(), string6);
        }
    }

    private void a6() {
        this.b5.setVisible(false);
        this.b6.setVisible(false);
        this.b4.setVisible(false);
        a[] aArray = (a[])this.b3.case();
        aArray[0].requestFocus();
        int n2 = 0;
        do {
            aArray[n2].a(this.b2.dn[n2], this.b2.dj[n2], this.b2.df[n2], this.b2.dl[n2], this.b2.c5[n2]);
        } while (++n2 < 3);
        this.b3.setVisible(true);
    }

    private boolean try(String string) {
        int n2 = string.length();
        int n3 = 0;
        while (n3 < n2) {
            char c2 = string.charAt(n3);
            if (c2 < ' ' || c2 > '\u007f' || c2 == '%' || c2 == '&' || c2 == '?') {
                return false;
            }
            ++n3;
        }
        return true;
    }

    private void aW() {
        this.b3 = this.a(320, 240, "\u9009\u62e9\u89d2\u8272");
        String[] stringArray = new String[]{"\u521b\u5efa\u89d2\u8272", "\u5220\u9664\u89d2\u8272", "\u8fdb\u5165\u6e38\u620f"};
        String[] stringArray2 = new String[]{"createHero", "deleteHero", "enterGame"};
        int n2 = 0;
        while (n2 < stringArray.length) {
            al al2 = new al();
            al2.else(stringArray[n2]);
            al2.m(2);
            al2.char(stringArray2[n2]);
            al2.try(this);
            al2.setBounds(60 + 70 * n2, this.b3.getHeight() - 25, 68, 19);
            this.b3.add(al2);
            ++n2;
        }
        a[] aArray = new a[3];
        this.b3.a(aArray);
        int n3 = 0;
        do {
            aArray[n3] = new a();
            aArray[n3].setLocation(12 + 100 * n3, 50);
            aArray[n3].bW = aArray;
            this.b3.add(aArray[n3]);
        } while (++n3 < 3);
    }

    private void byte(String string) {
        String string2 = this.aZ();
        if (string2 != null) {
            a.a.e e2 = new a.a.e(64);
            e2.a(string2);
            e2.a(string);
            this.b1.byte().a(5, e2);
            this.b1.new().do("\u8bf7\u7b49\u5f85...", -1);
        }
    }

    public void a5() {
        this.b5.setVisible(true);
        this.b6.setVisible(false);
        this.b3.setVisible(false);
        this.b4.setVisible(false);
        n[] nArray = (n[])this.b5.case();
        nArray[0].requestFocus();
        if (this.b1.do().a()) {
            String string = (String)this.b1.do().a("getUsername", null);
            String string2 = (String)this.b1.do().a("getPassword", null);
            if (string != null && !string.equals("undefined")) {
                nArray[0].if(string);
            }
            if (string2 != null && !string2.equals("undefined")) {
                nArray[1].if(string2);
            }
            if (string != null && string.length() > 0 && string2 != null && string2.length() > 0) {
                this.a2();
            }
        }
    }

    private void a(String string, String string2) {
        if (string == null) {
            this.b1.new().if("\u8bf7\u9009\u62e9\u89d2\u8272\u4ee5\u8fdb\u5165\u6e38\u620f\uff01", -65536);
            return;
        }
        a.a.e e2 = new a.a.e(24);
        e2.a(string);
        e2.a(string2);
        e2.a(this.b1.do().a());
        this.b1.byte().a(6, e2);
        this.b1.new().do("\u8bf7\u7b49\u5f85...", -1);
    }

    private String aZ() {
        a[] aArray = (a[])this.b3.case();
        int n2 = 0;
        while (n2 < aArray.length) {
            if (aArray[n2].bR && aArray[n2].bO.length() > 0) {
                return aArray[n2].bO;
            }
            ++n2;
        }
        return null;
    }

    private void aV() {
        n[] nArray = (n[])this.b6.case();
        if (nArray[0].D().length() < 4) {
            this.b1.new().if("\u5e10\u53f7\u4e0d\u80fd\u5c0f\u4e8e4\u4e2a\u5b57\u7b26\uff01", -65536);
            return;
        }
        if (nArray[1].D().length() < 6) {
            this.b1.new().if("\u5bc6\u7801\u4e0d\u80fd\u5c0f\u4e8e6\u4e2a\u5b57\u7b26\uff01", -65536);
            return;
        }
        if (!nArray[1].D().equals(nArray[2].D())) {
            this.b1.new().if("\u4e24\u6b21\u8f93\u5165\u7684\u5bc6\u7801\u4e0d\u7b26\uff01", -65536);
            return;
        }
        this.b1.new().do("\u8bf7\u7b49\u5f85...", -1);
        a.a.e e2 = new a.a.e(32);
        e2.a(nArray[0].D());
        if ("true".equals(this.b1.do().getParameter("md5Password"))) {
            e2.a(a.a.b.do(nArray[1].D()));
        } else {
            e2.a(nArray[1].D());
        }
        e2.a(this.b1.do().getParameter("adOwner"));
        this.b1.byte().a(3, e2);
    }

    public void a0() {
        this.b2 = this.b1.case();
        this.a(new l(-16777216));
        this.aX();
        this.a3();
        this.aW();
        this.a4();
    }

    private void aX() {
        this.b5 = this.a(264, 145, "\u767b\u5f55\u5e10\u53f7");
        n[] nArray = new n[2];
        this.b5.a(nArray);
        int n2 = 0;
        while (n2 < nArray.length) {
            nArray[n2] = new n();
            nArray[n2].a(new l(-16777216));
            nArray[n2].char(-1);
            nArray[n2].goto(-1);
            nArray[n2].setBounds(105, 44 + n2 * 31, 80, 14);
            nArray[n2].if(n2 > 0 ? (char)'*' : '\u0000');
            this.b5.add(nArray[n2]);
            ++n2;
        }
        nArray[0].do("focusToPassword");
        nArray[0].for(this);
        nArray[1].do("loginOK");
        nArray[1].for(this);
        String[] stringArray = new String[]{"\u767b\u5f55", "\u6ce8\u518c", "\u4fee\u6539\u5bc6\u7801", "\u627e\u56de\u5bc6\u7801"};
        String[] stringArray2 = new String[]{"loginOK", "register", "changePassword", "findPassword"};
        int n3 = 14;
        int n4 = 0;
        while (n4 < stringArray.length) {
            al al2 = new al();
            al2.char(stringArray2[n4]);
            al2.try(this);
            al2.else(stringArray[n4]);
            al2.m(2);
            al2.setBounds(n3, this.b5.getHeight() - 25, n4 > 1 ? 66 : 44, 19);
            n3 += n4 > 1 ? 66 : 44;
            n3 += 6;
            this.b5.add(al2);
            ++n4;
        }
    }

    private void a4() {
        s[] sArray;
        bf[] bfArray;
        this.b4 = this.a(320, 250, "\u521b\u5efa\u89d2\u8272");
        String[] stringArray = new String[]{"\u89d2\u8272\u540d\uff1a", "\u804c\u4e1a\uff1a", "\u6027\u522b\uff1a"};
        int[] nArray = new int[]{44, 82, 160};
        int n2 = 0;
        while (n2 < stringArray.length) {
            bfArray = new s();
            bfArray.setBounds(26, nArray[n2], 42, 12);
            bfArray.if(new q(stringArray[n2], -1));
            this.b4.add((Component)bfArray);
            ++n2;
        }
        n n3 = new n();
        n3.char(-1);
        n3.goto(-1);
        n3.setBounds(80, 42, 120, 18);
        this.b4.add(n3);
        bfArray = new bf[3];
        int n4 = 0;
        while (n4 < bfArray.length) {
            bfArray[n4] = new bf();
            bfArray[n4].y("chooseRace:" + n4);
            bfArray[n4].case(this);
            bfArray[n4].z(d.ap[n4]);
            bfArray[n4].O(-1901563);
            bfArray[n4].setBounds(80, 80 + n4 * 20, 120, 16);
            bfArray[n4].a(n4 > 0 ? null : n3.try());
            bfArray[n4].a(bfArray);
            this.b4.add(bfArray[n4]);
            ++n4;
        }
        bfArray = new bf[2];
        n4 = 0;
        while (n4 < bfArray.length) {
            bfArray[n4] = new bf();
            bfArray[n4].y("chooseSex:" + n4);
            bfArray[n4].case(this);
            bfArray[n4].z(d.am[n4]);
            bfArray[n4].O(-1901563);
            bfArray[n4].setBounds(80, 160 + n4 * 20, 120, 16);
            bfArray[n4].a(n4 > 0 ? null : n3.try());
            bfArray[n4].a(bfArray);
            this.b4.add(bfArray[n4]);
            ++n4;
        }
        stringArray = new String[]{"\u786e \u5b9a", "\u8fd4 \u56de"};
        String[] stringArray2 = new String[]{"createHeroOK", "back"};
        int n5 = 0;
        while (n5 < stringArray.length) {
            sArray = new al();
            sArray.char(stringArray2[n5]);
            sArray.try(this);
            sArray.else(stringArray[n5]);
            sArray.m(2);
            sArray.setBounds(112 + n5 * 54, this.b4.getHeight() - 25, 44, 19);
            this.b4.add((Component)sArray);
            ++n5;
        }
        b b2 = new b();
        b2.setBounds(180, 3, 140, 240);
        this.b4.add(b2);
        sArray = new s[]{n3, b2};
        this.b4.a(sArray);
    }

    private void a3() {
        this.b6 = this.a(320, 240, "\u6ce8\u518c\u5e10\u53f7");
        String[] stringArray = new String[]{"\u5e10\u53f7\u540d\u79f0\uff1a", "\u5bc6\u7801\uff1a", "\u786e\u8ba4\u5bc6\u7801\uff1a"};
        int n2 = 0;
        while (n2 < stringArray.length) {
            s s2 = new s();
            s2.a(2);
            s2.setBounds(0, 61 + 38 * n2, 116, 12);
            s2.if(new q(stringArray[n2], -1));
            this.b6.add(s2);
            ++n2;
        }
        n[] nArray = new n[3];
        this.b6.a(nArray);
        int n3 = 0;
        while (n3 < nArray.length) {
            nArray[n3] = new n();
            nArray[n3].char(-1);
            nArray[n3].goto(-1);
            nArray[n3].setBounds(125, 58 + 38 * n3, 140, 18);
            nArray[n3].if(n3 > 0 ? (char)'*' : '\u0000');
            this.b6.add(nArray[n3]);
            ++n3;
        }
        stringArray = new String[]{"\u53d6 \u6d88", "\u786e \u5b9a", "\u8fd4 \u56de"};
        String[] stringArray2 = new String[]{"cancelRegister", "registerOK", "back"};
        int n4 = 0;
        while (n4 < stringArray.length) {
            al al2 = new al();
            al2.char(stringArray2[n4]);
            al2.try(this);
            al2.else(stringArray[n4]);
            al2.m(2);
            al2.setBounds(85 + 50 * n4, this.b6.getHeight() - 25, 44, 19);
            this.b6.add(al2);
            ++n4;
        }
    }

    private void aY() {
        s[] sArray = (s[])this.b4.case();
        String string = ((n)sArray[0]).D();
        if (string.length() < 2) {
            this.b1.new().if("\u89d2\u8272\u540d\u5b57\u4e0d\u80fd\u5c11\u4e8e4\u4e2a\u5b57\u7b26\u6216\u80052\u4e2a\u6c49\u5b57\uff01", -65536);
            return;
        }
        if (string.length() > 16) {
            this.b1.new().if("\u89d2\u8272\u540d\u5b57\u4e0d\u80fd\u5927\u4e0e16\u4e2a\u5b57\u7b26\u6216\u80058\u4e2a\u6c49\u5b57\uff01", -65536);
            return;
        }
        int n2 = string.length();
        int n3 = 0;
        while (n3 < n2) {
            char c2 = string.charAt(n3);
            if (!(c2 > '0' && c2 <= '9' || c2 >= 'a' && c2 <= 'z' || c2 >= 'A' && c2 <= 'Z' || c2 > '\u4a38')) {
                this.b1.new().if("\u89d2\u8272\u540d\u4e2d\u542b\u6709\u975e\u6cd5\u5b57\u7b26\uff1a" + c2, -65536);
                return;
            }
            ++n3;
        }
        if (this.b1.do(string)) {
            this.b1.new().if("\u89d2\u8272\u540d\u4e2d\u5305\u542b\u6709\u654f\u611f\u6216\u4e0d\u6587\u660e\u7684\u5173\u952e\u8bcd\u8bed\uff01", -65536);
            return;
        }
        n3 = ((b)sArray[1]).bZ;
        int n4 = ((b)sArray[1]).b0;
        a.a.e e2 = new a.a.e(32);
        e2.a(string);
        e2.a(n3);
        e2.a(n4);
        this.b1.byte().a(4, e2);
        this.b1.new().do("\u8bf7\u7b49\u5f85...", -1);
    }

    private s a(int n2, int n3, String string) {
        s s2 = new s();
        s2.setSize(n2, n3);
        s2.setLocation(this.getWidth() / 2 - n2 / 2, this.getHeight() / 2 - n3 / 2);
        s2.setVisible(false);
        this.a(s2, string);
        this.add(s2);
        return s2;
    }

    void a1() {
        String string = this.aZ();
        if (string == null) {
            this.b1.new().if("\u8bf7\u9009\u62e9\u89d2\u8272\u4ee5\u8fdb\u5165\u6e38\u620f\uff01", -65536);
        } else if (this.aU() > 0) {
            this.b1.void().a("\u8bf7\u8f93\u5165\u8fd9\u4e2a\u89d2\u8272\u7684\u5bc6\u7801\uff1a", '*', "yesEnterGame", this);
        } else {
            this.a(string, "");
        }
    }

    private class a
    extends s {
        String bO;
        String bN;
        int bS;
        int bU;
        int bX;
        int bQ;
        long bY;
        boolean bR;
        int bP;
        int bT;
        int bV;
        a[] bW;

        public void a(String string, int n2, int n3, int n4, int n5) {
            this.bO = string;
            this.bS = n2;
            this.bU = n3;
            this.bX = n4;
            String string2 = d.ap[n2];
            this.bT = string2.length() * 12;
            this.bN = String.valueOf(n5) + "\u7ea7";
            this.bP = string.getBytes().length * 6;
            this.bV = this.bN.getBytes().length * 6;
            if (string.length() > 0 && p.ag[n2 * 2 + n3][n4][0] == null) {
                m.this.b1.char().a("hero:" + n2 + n3 + n4);
            }
        }

        public a() {
            m.this.getClass();
            this.bO = "";
            this.bN = "";
            this.setSize(96, 120);
            this.enableEvents(24L);
        }

        protected void processMouseEvent(MouseEvent mouseEvent) {
            int n2 = mouseEvent.getID();
            if (n2 == 501 && !this.bR) {
                int n3 = 0;
                while (n3 < this.bW.length) {
                    if (this.bW[n3].bR) {
                        this.bW[n3].bR = false;
                        this.bW[n3].repaint();
                    }
                    ++n3;
                }
                this.bR = true;
                this.requestFocus();
                this.repaint();
            } else if (n2 == 500 && mouseEvent.getClickCount() > 1) {
                m.this.a1();
            }
        }

        public void a(c c2) {
            c2.if(0, 0, this.getWidth(), this.getHeight(), -1);
            if (this.bO.length() > 0) {
                int n2 = 0;
                int n3 = this.bS * 2 + this.bU;
                if (this.bR) {
                    n2 = 1;
                    c2.a(0, 0, this.getWidth(), this.getHeight(), 1326674377);
                }
                if (p.ag[n3][this.bX][n2] == null) {
                    c2.a("Loading", 27, 26, -1);
                } else {
                    int n4 = this.bQ % 4;
                    if (n2 == 1) {
                        n4 = this.bQ % 6;
                    }
                    c2.if(p.ag[n3][this.bX][n2], -27, -33, n4 * 150, 600, 150, 150);
                }
                c2.a(this.bO, 48 - this.bP / 2, 70, -1);
                c2.a(d.ap[this.bS], 48 - this.bT / 2, 87, -1);
                c2.a(this.bN, 48 - this.bV / 2, 104, -1);
            } else {
                c2.a("\u6ca1\u6709\u89d2\u8272", 24, 54, -65536);
            }
        }

        protected void processKeyEvent(KeyEvent keyEvent) {
            char c2 = keyEvent.getKeyChar();
            if (keyEvent.getID() == 400 && (c2 == '\r' || c2 == '\n')) {
                m.this.a1();
            }
        }

        public void a(long l2) {
            if (this.bO.length() == 0) {
                return;
            }
            if (p.ag[this.bS * 2 + this.bU][this.bX][0] == null) {
                return;
            }
            if (l2 - this.bY >= 200L) {
                this.bY = l2;
                ++this.bQ;
                this.repaint();
            }
        }

        public void aT() {
            this.bO = "";
            this.bS = 0;
            this.bU = 0;
            this.bX = 0;
            this.bN = "";
            this.bR = false;
            this.repaint();
        }
    }

    private class b
    extends s {
        int bZ;
        int b0;

        public void a(c c2) {
            if (e.a3[this.bZ][this.b0] == null) {
                c2.a("Loading...", this.getWidth() / 2 - 30, this.getHeight() / 2 - 10, -1);
                this.repaint();
            } else {
                c2.a(e.a3[this.bZ][this.b0], this.getWidth() / 2 - 70, this.getHeight() / 2 - 120);
            }
        }

        b() {
            m.this.getClass();
        }
    }
}

