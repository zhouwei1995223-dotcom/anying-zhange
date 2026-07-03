/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.z;
import b.a.c.b;
import b.a.c.b.al;
import b.a.c.b.au;
import b.a.c.b.e;
import b.a.c.b.g;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URLEncoder;

public class l
extends z
implements ActionListener {
    public static boolean fJ = true;
    public static boolean fD = true;
    private static final String[] fF = new String[]{"\u548c\u5e73\u6a21\u5f0f", "\u516c\u4f1a\u6a21\u5f0f", "PK\u6a21\u5f0f"};
    private static final String[] fC = new String[]{"fightMode:0", "fightMode:1", "fightMode:2"};
    private static final String[] fG = new String[]{"\u663e\u793a/\u9690\u85cf\u4e16\u754c\u9891\u9053", "\u663e\u793a/\u9690\u85cf\u961f\u4f0d\u9891\u9053", "\u663e\u793a/\u9690\u85cf\u516c\u4f1a\u9891\u9053", "\u663e\u793a/\u9690\u85cf\u5bc6\u8bed\u9891\u9053"};
    private static final String[] fK = new String[]{"chatView:1", "chatView:2", "chatView:3", "chatView:4"};
    private static final String[] fI = new String[]{"\u5f00\u542f\u80cc\u666f\u97f3\u4e50", "\u5173\u95ed\u80cc\u666f\u97f3\u4e50", "\u5f00\u542f\u6e38\u620f\u97f3\u6548", "\u5173\u95ed\u6e38\u620f\u97f3\u6548"};
    private static final String[] fH = new String[]{"music:1", "music:0", "sound:1", "sound:0"};
    private b fE;

    public l(b b2) {
        this.fE = b2;
        this.char(true);
        this.setVisible(false);
    }

    public void a(c c2) {
        e.a(c2, "\u7cfb\u7edf", this.getWidth(), this.getHeight());
        super.a(c2);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.equals("setChatView")) {
            al al2 = (al)actionEvent.getSource();
            this.a(fG, fK, this, al2.getX() + al2.getWidth(), al2.getY());
        } else if (string.equals("setSound")) {
            al al3 = (al)actionEvent.getSource();
            this.a(fI, fH, this, al3.getX() + al3.getWidth(), al3.getY());
        } else if (string.startsWith("music:")) {
            fJ = string.endsWith(":1");
            if (fJ) {
                this.fE.goto().w("\u4f60\u5f00\u542f\u4e86\u80cc\u666f\u97f3\u4e50");
                this.fE.try();
            } else {
                this.fE.goto().w("\u4f60\u5173\u95ed\u4e86\u80cc\u666f\u97f3\u4e50");
                this.fE.a();
            }
        } else if (string.startsWith("sound:")) {
            fD = string.endsWith(":1");
            if (fD) {
                this.fE.goto().w("\u4f60\u5f00\u542f\u4e86\u6218\u6597\u97f3\u6548");
            } else {
                this.fE.goto().w("\u4f60\u5173\u95ed\u4e86\u6218\u6597\u97f3\u6548");
            }
        } else if (string.equals("setFightMode")) {
            al al4 = (al)actionEvent.getSource();
            this.a(fF, fC, this, al4.getX() + al4.getWidth(), al4.getY());
        } else if (string.startsWith("chatView:")) {
            au au2;
            int n2 = string.charAt(string.length() - 1) - 48;
            au2.a(n2, !(au2 = this.fE.c().aB().T()).n(n2));
        } else if (string.startsWith("fightMode:")) {
            int n3 = string.charAt(string.length() - 1) - 48;
            this.fE.e().for(n3);
        } else if (string.equals("quitGame") || string.equals("quit")) {
            this.fE.new().if("\u4f60\u786e\u5b9a\u8981\u9000\u51fa\u6e38\u620f\u5417\uff1f", -16711696, "yesQuit", "", this);
        } else if (string.equals("yesQuit")) {
            String string2 = this.fE.do().getParameter("exitScript");
            if (string2 != null && string2.length() > 1 && this.fE.do().a()) {
                this.fE.do().a(string2, null);
            } else {
                this.fE.i();
            }
        } else if (string.equals("gameAd")) {
            String string3 = this.fE.do().getParameter("adUrl");
            if (string3 != null) {
                string3 = string3 + URLEncoder.encode(this.fE.case().a);
                a.a.b.if(string3);
                this.fE.new().if("\u4f60\u7684\u6e38\u620f\u63a8\u5e7f\u8fde\u63a5\u5730\u5740\u5df2\u7ecf\u590d\u5236\u5230\u7cfb\u7edf\u526a\u8d34\u677f\uff0c\u4f60\u53ef\u4ee5\u7c98\u8d34\u53d1\u9001\u7ed9\u4f60\u7684\u597d\u53cb\uff0c\u9080\u8bf7\u4ed6\u4eec\u4e00\u540c\u6765\u73a9\u8fd9\u4e2a\u6e38\u620f\uff0c\u4f60\u4f1a\u56e0\u6b64\u5f97\u5230\u7cfb\u7edf\u5956\u52b1\u3002\u5982\u679c\u4f60\u7684\u7cfb\u7edf\u7981\u6b62\u8bbf\u95ee\u7cfb\u7edf\u526a\u8d34\u677f\uff0c\u8bf7\u8bb0\u4e0b\u8fd9\u4e2a\u5730\u5740\uff1a" + string3, 0xFFFFFF);
            }
        } else if (string.equals("heroPassword")) {
            this.fE.new().if("\u89d2\u8272\u5bc6\u7801\u53ef\u4ee5\u4fdd\u62a4\u60a8\u7684\u4e3b\u89d2\u3002\u5047\u8bbe\u60a8\u7684\u8d26\u53f7\u4e0d\u5e78\u88ab\u76d7\uff0c\u800c\u60a8\u5982\u679c\u8bbe\u7f6e\u4e86\u5bc6\u7801\uff0c\u522b\u4eba\u5c06\u65e0\u6cd5\u4f7f\u7528\u548c\u5220\u9664\u8fd9\u4e2a\u89d2\u8272\u3002\u4f60\u8981\u8bbe\u7f6e\u5bc6\u7801\u5417\uff1f", -16711696, "yesHeroPassword", "", this);
        } else if (string.equals("yesHeroPassword")) {
            this.fE.void().a("\u8bf7\u8f93\u5165\u539f\u6765\u7684\u5bc6\u7801\uff0c\u5982\u679c\u6ca1\u6709\u8bbe\u7f6e\uff0c\u8bf7\u76f4\u63a5\u56de\u8f66\u786e\u5b9a", '*', "oldPassword", this);
        } else if (string.equals("oldPassword")) {
            String[] stringArray = new String[2];
            stringArray[0] = this.fE.void().cK();
            this.a(stringArray);
            this.fE.void().a("\u8bf7\u8f93\u5165\u65b0\u5bc6\u7801(6-12\u4e2a\u5b57\u6bcd\u6216\u6570\u5b57)", '*', "newPassword", this);
        } else if (string.equals("newPassword")) {
            String[] stringArray = (String[])this.case();
            stringArray[1] = this.fE.void().cK();
            if (stringArray[1].length() < 6 || stringArray[1].length() > 12) {
                this.fE.new().if("\u5bc6\u7801\u957f\u5ea6\u975e\u6cd5\uff0c\u9650\u52366-12\u4e2a\u5b57\u6bcd\u6216\u6570\u5b57", 0xFF0000);
            } else {
                this.fE.void().a("\u8bf7\u518d\u6b21\u8f93\u5165\u65b0\u5bc6\u7801(6-12\u4e2a\u5b57\u6bcd\u6216\u6570\u5b57)", '*', "confirmPassword", this);
            }
        } else if (string.equals("confirmPassword")) {
            String[] stringArray = (String[])this.case();
            if (!a.a.b.case(stringArray[1])) {
                this.fE.new().if("\u5bc6\u7801\u4e2d\u542b\u6709\u975e\u6cd5\u5b57\u7b26", 0xFF0000);
            } else if (!this.fE.void().cK().equals(stringArray[1])) {
                this.fE.new().if("\u4e24\u6b21\u8f93\u5165\u7684\u5bc6\u7801\u4e0d\u4e00\u81f4", 0xFF0000);
            } else {
                this.fE.byte().a(stringArray[0], stringArray[1]);
            }
        } else if (string.equals("setTitle")) {
            this.fE.void().a("\u8bf7\u8f93\u5165\u4f60\u8981\u7ed9\u7f51\u9875\u6216\u8005\u5ba2\u6237\u7aef\u7a97\u53e3\u8bbe\u7f6e\u7684\u6807\u9898\u6587\u5b57\uff1a", "yesTitle", this);
        } else if (string.equals("yesTitle")) {
            this.fE.do().do(this.fE.void().cK());
        }
    }

    public void cb() {
        int n2 = 204;
        int n3 = 341;
        this.setBounds(n2, 40, n2, n3);
        this.add(new g(this.getWidth() - 23, 7, 15, 15));
        String[] stringArray = new String[]{"\u89d2\u8272\u5bc6\u7801", "\u804a\u5929\u663e\u793a", "\u97f3\u4e50\u97f3\u6548", "\u6218\u6597\u6a21\u5f0f", "\u7a97\u53e3\u6807\u9898", "\u63a8\u5e7f\u6e38\u620f", "\u9000\u51fa\u6e38\u620f"};
        String[] stringArray2 = new String[]{"heroPassword", "setChatView", "setSound", "setFightMode", "setTitle", "gameAd", "quitGame"};
        int n4 = 0;
        while (n4 < stringArray.length) {
            al al2 = al.a(2, stringArray[n4], stringArray2[n4], this, 65, 80 + n4 * 25, 74, 19);
            this.add(al2);
            ++n4;
        }
    }
}

