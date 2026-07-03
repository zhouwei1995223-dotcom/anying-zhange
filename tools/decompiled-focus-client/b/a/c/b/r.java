/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.s;
import b.a.c.b;
import b.a.c.b.al;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

class r
extends s
implements ActionListener {
    private static final String[] ct = new String[]{"\u5bc6\u8bed", "\u793c\u54c1\u804a\u5929", "\u52a0\u4e3a\u597d\u53cb", "\u9080\u8bf7\u7ec4\u961f", "\u8bbe\u4e3a\u4ec7\u4eba", "\u52a0\u5165\u9ed1\u540d\u5355", "\u5bdf\u770b\u4fe1\u606f", "\u98de\u8fc7\u53bb", "\u62c9\u8fc7\u6765", "\u8e22\u4e0b\u7ebf", "\u7981\u6b62/\u5141\u8bb8\u53d1\u8a00", "\u6253\u5f00\u4e2a\u4eba\u5546\u5e97", "\u590d\u5236\u540d\u5b57"};
    private static final String[] cg = new String[]{"whisper", "giftChat", "addFriend", "teamInvite", "addEnemy", "addBlack", "viewInfo", "gotoPlayer", "pullPlayer", "kickPlayer", "forbidChat", "openShop", "copyName"};
    private static final String[] cr = new String[]{"\u5bc6\u8bed", "\u793c\u54c1\u804a\u5929", "\u52a0\u4e3a\u597d\u53cb", "\u9080\u8bf7\u7ec4\u961f", "\u8bbe\u4e3a\u4ec7\u4eba", "\u52a0\u5165\u9ed1\u540d\u5355", "\u5bdf\u770b\u4fe1\u606f", "\u6253\u5f00\u4e2a\u4eba\u5546\u5e97", "\u590d\u5236\u540d\u5b57"};
    private static final String[] cq = new String[]{"whisper", "giftChat", "addFriend", "teamInvite", "addEnemy", "addBlack", "viewInfo", "openShop", "copyName"};
    private static final String[] cp = new String[]{"\u52a0\u4e3a\u597d\u53cb", "\u793c\u54c1\u804a\u5929", "\u9080\u8bf7\u7ec4\u961f", "\u8bbe\u4e3a\u4ec7\u4eba", "\u52a0\u5165\u9ed1\u540d\u5355", "\u5bdf\u770b\u4fe1\u606f", "\u6253\u5f00\u4e2a\u4eba\u5546\u5e97", "\u590d\u5236\u540d\u5b57"};
    private static final String[] co = new String[]{"addFriend", "giftChat", "teamInvite", "addEnemy", "addBlack", "viewInfo", "openShop", "copyName"};
    private b cj;
    private String ch;
    private String cs;
    private int ck;
    private int cn = -65536;
    private int cl = -16711936;
    private boolean ci;
    private boolean cm;

    public r(b b2, String string, int n2) {
        this.cj = b2;
        this.ch = string;
        this.cs = "\u3010" + string + "\u3011";
        if (n2 == 0) {
            n2 = 0xFFFFFF;
        }
        this.ck = n2;
        this.cn = this.cl = c.if(n2, 32);
        this.enableEvents(16L);
        this.setCursor(al.c7);
    }

    protected void processMouseEvent(MouseEvent mouseEvent) {
        int n2 = mouseEvent.getID();
        if (n2 == 504) {
            this.ci = true;
            this.repaint();
        } else if (n2 == 505) {
            this.ci = false;
            this.repaint();
        } else if (n2 == 501) {
            this.cm = true;
            this.repaint();
            if ((mouseEvent.getModifiers() & 4) != 0) {
                if (this.cj.for().ao > 0) {
                    this.a(ct, cg, this, mouseEvent.getX(), mouseEvent.getY());
                } else if (this.getParent().getParent().getParent().getParent() == this.cj.c().ag()) {
                    this.a(cp, co, this, mouseEvent.getX(), mouseEvent.getY());
                } else {
                    this.a(cr, cq, this, mouseEvent.getX(), mouseEvent.getY());
                }
            }
        } else if (n2 == 502) {
            this.cm = false;
            this.repaint();
        } else if (n2 == 500 && mouseEvent.getClickCount() > 1 && this.getParent().getParent().getParent().getParent() != this.cj.c().ag()) {
            this.cj.c().ag().t(this.ch);
        }
    }

    public void a(c c2) {
        if (this.cm) {
            c2.a(this.cs, 1, 2, this.cl);
        } else if (this.ci) {
            c2.a(this.cs, 0, 1, this.cn);
        } else {
            c2.a(this.cs, 0, 2, this.ck);
        }
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.equals("whisper")) {
            this.cj.c().ag().t(this.ch);
        } else if (string.equals("addFriend")) {
            this.cj.c().W().j(this.ch);
        } else if (string.equals("teamInvite")) {
            this.cj.byte().k(this.ch);
        } else if (string.equals("addEnemy")) {
            this.cj.c().W().i(this.ch);
        } else if (string.equals("addBlack")) {
            this.cj.c().W().k(this.ch);
        } else if (string.equals("viewInfo")) {
            this.cj.byte().case(this.ch);
        } else if (string.equals("openShop")) {
            this.cj.byte().j(this.ch);
        } else if (string.equals("gotoPlayer")) {
            this.cj.byte().o(this.ch);
        } else if (string.equals("pullPlayer")) {
            this.cj.byte().g(this.ch);
        } else if (string.equals("kickPlayer")) {
            this.cj.byte().void(this.ch);
        } else if (string.equals("forbidChat")) {
            this.cj.byte().J(this.ch);
        } else if (string.equals("giftChat")) {
            this.cj.c().aM().r(this.ch);
        } else if (string.equals("copyName")) {
            a.a.b.if(this.ch);
        }
    }
}

