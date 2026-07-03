/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.n;
import a.b.o;
import a.b.s;
import a.b.z;
import b.a.c.b;
import b.a.c.b.al;
import b.a.c.b.e;
import b.a.c.b.g;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class a6
extends z
implements ActionListener {
    private b ls;
    private s lu;
    private long lw = 0L;
    private long lq = 0L;
    private al ly;
    n lx;
    public boolean lp = false;
    private final int lt = 10;
    int lr = 0;
    int lz = 0;
    private boolean lv = false;

    public a6(b b2) {
        this.ls = b2;
        this.char(true);
        this.setVisible(false);
        this.new();
    }

    public void a(c c2) {
        e.a(c2, "\u672c\u5c0f\u65f6\u793c\u7269", this.getWidth(), this.getHeight());
        c2.a("\u4eb2\u7231\u7684 ", 10, 36, -1);
        c2.a(this.ls.for().a, 58, 36, Color.yellow.getRGB());
        if (this.ls.for().p >= 10) {
            c2.a("\u9274\u4e8e\u60a8\u4e3a\u8fd9\u4e2a\u6e38\u620f\u4e16\u754c\u6240\u505a\u7684\u8d21\u732e\uff0c", 30, 56, -1);
            c2.a("\u7cfb\u7edf\u6bcf\u4e2a\u5c0f\u65f6\u4f1a\u53d1\u9001\u4e00\u4e2a\u5956\u54c1\u7ed9\u60a8\u3002", 10, 70, -1);
            if (this.lv) {
                c2.a("\u9886\u5956\u7684\u65f6\u95f4\u8fd8\u5269" + this.lr + "\u5206" + this.lz + "\u79d2\uff0c\u5feb\u70b9\u9886\u5427!", 30, this.getHeight() / 2 + 40, -1);
            } else {
                c2.a("\u518d\u6709" + this.lr + "\u5206" + this.lz + "\u79d2\u60a8\u5c31\u53ef\u4ee5\u9886\u53d6\u5956\u54c1\u4e86\uff01", 30, this.getHeight() / 2 + 40, -1);
            }
            super.a(c2);
        } else {
            c2.a("\u6bcf\u5c0f\u65f6\u793c\u7269\u81f3\u5c11" + 10 + "\u7ea7\u624d\u53ef\u4ee5\u9886\u53d6\uff0c\u5feb\u70b9", 30, this.getHeight() / 2, -1);
            c2.a("\u5347\u7ea7\u5427\uff01", 10, this.getHeight() / 2 + 20, -1);
        }
        super.a(c2);
    }

    public void a(long l2) {
        if (this.ls.for().p < 10) {
            return;
        }
        if (l2 - this.lq >= 1000L) {
            this.lr = (int)(this.lw / 1000L / 60L);
            this.lz = (int)(this.lw / 1000L % 60L);
            this.lw -= 1000L;
            this.lq = l2;
            if (this.lr < 0 || this.lz < 0) {
                this.setVisible(false);
            }
        }
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.equals("getGift")) {
            this.ls.byte().char();
            this.setVisible(false);
        } else if (string.equals("getPrizes")) {
            this.ls.void().a("\u8bf7\u8f93\u5165\u60a8\u7684\u6ce8\u518c\u7801:", "inputCode", this);
        } else if (string.equals("inputCode")) {
            if (this.lp) {
                this.ls.new().if("\u6b63\u5728\u5904\u7406\u6d88\u606f\u4e2d,\u8bf7\u7a0d\u540e!", -1);
                return;
            }
            this.lp = true;
            String string2 = this.ls.void().cK().trim();
            if (string2.length() == 0) {
                this.ls.new().if("\u8bf7\u8f93\u5165\u6ce8\u518c\u7801!", -1);
                return;
            }
            this.ls.byte().m(string2);
            this.ls.void().setVisible(false);
            this.ls.c().ac().setVisible(false);
        }
    }

    public void dC() {
        int n2 = 244;
        int n3 = 281;
        this.setBounds(204, 40, n2, n3);
        this.add(new g(this.getWidth() - 23, 7, 15, 15));
        this.lu = new s();
        this.lu.setBounds(10, 100, this.getWidth(), this.getHeight() - 70);
        this.add(this.lu);
        this.ly = al.a(2, "\u9886\u53d6", "getGift", this, 30, this.getHeight() - 25, 80, 21);
        this.add(this.ly);
    }

    public void a(boolean bl, long l2, long l3) {
        this.lw = l2;
        this.lv = bl;
        if (this.lq == 0L) {
            this.lq = l3;
        }
        if (bl) {
            this.lu.if(new o("\u60a8\u73b0\u5728\u53ef\u4ee5\u9886\u53d6\u5956\u54c1\u4e86!", 224, -1));
            this.ly.char("getGift");
            this.ly.setVisible(true);
        } else {
            int n2 = new Date().getHours() + 1;
            if (n2 == 24) {
                n2 = 0;
            }
            this.lu.if(new o("\u4e0b\u4e00\u6b21\u9886\u53d6\u793c\u54c1\u7684\u65f6\u95f4\u662f\uff1a" + n2 + "\u70b9\u96f6\u5206\u5230" + n2 + "\u96f65\u5206\uff0c\u8bf7\u60a8\u8bb0\u5f97\u8981\u6309\u65f6\u9886\u53d6\uff0c\u8fc7\u65f6\u4e0d\u8865\u54e6!", 224, -1));
            this.ly.setVisible(false);
        }
        this.setVisible(!this.isVisible());
    }

    public void dB() {
        if (this.ls.for().p < 10) {
            this.ly.setVisible(false);
        }
        this.setVisible(true);
    }
}

