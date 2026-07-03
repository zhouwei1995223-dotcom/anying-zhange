/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.l;
import a.b.n;
import a.b.q;
import a.b.s;
import a.b.z;
import b.a.c.b;
import b.a.c.b.al;
import b.a.c.b.bf;
import b.a.c.b.e;
import b.a.c.b.g;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class c
extends z
implements ActionListener {
    private b e7;
    private n e8;
    private a fa;
    private n e9;

    public void b0() {
        this.setVisible(true);
        this.e8.requestFocus();
    }

    public c(b b2) {
        this.e7 = b2;
        this.char(true);
        this.setVisible(false);
    }

    public void a(a.b.c c2) {
        e.a(c2, "\u521b\u5efa\u516c\u4f1a", this.getWidth(), this.getHeight());
        super.a(c2);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.equals("inputOK")) {
            if (actionEvent.getSource() == this.e8) {
                this.e9.requestFocus();
            } else if (actionEvent.getSource() == this.e9) {
                string = "ok";
            }
        }
        if (string.equals("ok")) {
            int n2 = q.if(this.e8.D());
            if (n2 < 24) {
                this.e7.new().if("\u516c\u4f1a\u540d\u5b57\u592a\u77ed\uff1a" + this.e8.D(), -65536);
            } else if (n2 > 72) {
                this.e7.new().if("\u516c\u4f1a\u540d\u5b57\u592a\u957f\uff1a" + this.e8.D(), -65536);
            } else {
                this.e7.j().requestFocus();
                this.setVisible(false);
                this.e7.byte().a(this.e8.D(), this.fa.aB, this.e9.D());
            }
        } else if (string.equals("cancel")) {
            this.e7.j().requestFocus();
            this.setVisible(false);
        } else if (string.equals("left")) {
            if (this.fa.getX() < 0) {
                this.fa.aB -= 10;
                this.fa.setLocation(this.fa.getX() + 160, 0);
            }
        } else if (string.equals("right") && this.fa.getX() > -640) {
            this.fa.aB += 10;
            this.fa.setLocation(this.fa.getX() - 160, 0);
        }
    }

    public void bZ() {
        s s2;
        int n2 = 308;
        int n3 = 168;
        this.setBounds(152, 100, n2, n3);
        g g2 = new g();
        g2.setBounds(this.getWidth() - 23, 7, 15, 15);
        this.add(g2);
        String[] stringArray = new String[]{"\u516c\u4f1a\u540d\u79f0\uff1a", "\u516c\u4f1a\u5fbd\u7ae0\uff1a", "\u516c\u4f1a\u4ecb\u7ecd\uff1a"};
        int n4 = 0;
        while (n4 < stringArray.length) {
            s2 = new s();
            s2.if(new q(stringArray[n4], -1));
            s2.setBounds(12, 42 + n4 * 32, 60, 12);
            this.add(s2);
            ++n4;
        }
        this.e8 = new n();
        this.e8.setBounds(76, 40, 100, 16);
        this.e8.else(7);
        this.e8.char(14408484);
        this.e8.goto(14408484);
        this.e8.a(new l(-1358921600));
        this.e8.do("inputOK");
        this.e8.for(this);
        this.add(this.e8);
        s s3 = new s();
        s3.setBounds(this.e8.getX() + this.e8.getWidth() + 2, 42, 120, 12);
        s3.if(new q("2-6\u4e2a\u6c49\u5b57", 14408484));
        this.add(s3);
        s3 = new s();
        s3.setBounds(104, 72, 160, 16);
        this.fa = new a();
        s3.add(this.fa);
        this.add(s3);
        s2 = bf.a("<<", "left", this, 76, 72, 24, 16);
        this.add(s2);
        s2 = bf.a(">>", "right", this, 268, 72, 24, 16);
        this.add(s2);
        this.e9 = new n();
        this.e9.else(100);
        this.e9.setBounds(76, 104, 216, 16);
        this.e9.char(14408484);
        this.e9.goto(14408484);
        this.e9.a(new l(-1358921600));
        this.e9.do("inputOK");
        this.e9.for(this);
        this.add(this.e9);
        al al2 = al.a(2, "\u786e\u5b9a", "ok", this, this.getWidth() / 2 - 46, this.getHeight() - 25, 44, 19);
        this.add(al2);
        al2 = al.a(2, "\u53d6\u6d88", "cancel", this, this.getWidth() / 2 + 2, this.getHeight() - 25, 44, 19);
        this.add(al2);
    }

    private class a
    extends s {
        int aB;

        public a() {
            c.this.getClass();
            this.setSize(800, 16);
            this.enableEvents(16L);
        }

        public void a(a.b.c c2) {
            c2.if(e.a5, 0, 0, 0, 720, this.getWidth(), this.getHeight());
            c2.if(this.aB * 16, 0, 16, 16, -1610612737);
        }

        protected void processMouseEvent(MouseEvent mouseEvent) {
            if (mouseEvent.getID() == 501) {
                this.aB = mouseEvent.getX() / 16;
            }
        }
    }
}

