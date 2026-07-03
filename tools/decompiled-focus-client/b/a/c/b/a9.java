/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.q;
import a.b.s;
import b.a.c.b;
import b.a.c.b.al;
import b.a.c.b.e;
import b.a.c.b.g;
import b.a.c.b.z;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class a9
extends a.b.z
implements ActionListener {
    private b lB;
    private z lA;
    private int lC;
    private al[] lD = new al[2];
    private String lE = "";

    public a9(b b2) {
        this.lB = b2;
        this.char(true);
        this.setVisible(false);
    }

    public void a(c c2) {
        e.a(c2, this.lE, this.getWidth(), this.getHeight());
        super.a(c2);
    }

    public void long(a.a.e e2) {
        this.lA.bg();
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
            this.lA.a(s2, 0, 0, 0);
        }
        this.lD[0].setVisible(false);
        this.lD[1].setVisible(false);
        this.lE = "\u672c\u5730\u56fe\u73a9\u5bb6[\u4eba\u6570=" + n3 + "]";
        if (!this.isVisible()) {
            this.setVisible(true);
        }
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.equals("world")) {
            if (this.lB.for().ao > 0) {
                this.lB.byte().K(0);
            }
        } else if (string.equals("map")) {
            if (this.lB.for().ao > 0) {
                this.lB.byte().z();
            }
        } else if (string.startsWith("whisper:")) {
            String string2 = string.substring(8);
            this.lB.c().ag().t(string2);
        } else if (string.startsWith("gotoPlayer:")) {
            if (this.lB.for().ao > 0) {
                String string3 = string.substring(string.indexOf(58) + 1);
                this.lB.byte().o(string3);
                this.setVisible(false);
            }
        } else if (string.equals("next")) {
            if (this.lB.for().ao > 0) {
                this.lB.byte().K(this.lC + 1);
            }
        } else if (string.equals("prev") && this.lC > 0 && this.lB.for().ao > 0) {
            this.lB.byte().K(this.lC - 1);
        }
    }

    public void goto(a.a.e e2) {
        this.lC = e2.for();
        this.lA.bg();
        int n2 = -1;
        int n3 = 0;
        while (e2.if() > 0) {
            ++n3;
            String string = e2.h();
            String string2 = e2.h();
            s s2 = new s();
            s2.setSize(300, 20);
            s s3 = new s();
            s3.if(new q(string, n2));
            s3.setBounds(4, 4, 100, 12);
            s2.add(s3);
            s3 = new s();
            s3.if(new q(string2, n2));
            s3.setBounds(104, 4, 96, 12);
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
            this.lA.a(s2, 0, 0, 0);
        }
        this.lD[0].setVisible(true);
        this.lD[1].setVisible(true);
        this.lE = "\u4e16\u754c\u73a9\u5bb6[\u5f53\u524d\u7b2c" + (this.lC + 1) + "\u9875\uff1b\u672c\u9875\u4eba\u6570=" + n3 + "]";
        if (!this.isVisible()) {
            this.setVisible(true);
        }
    }

    public void dD() {
        int n2 = 328;
        int n3 = 360;
        this.setBounds(140, 40, n2, n3);
        g g2 = new g();
        g2.setBounds(this.getWidth() - 23, 7, 15, 15);
        this.add(g2);
        al al2 = new al();
        al2.char("world");
        al2.try(this);
        al2.else("\u5168\u4e16\u754c\u73a9\u5bb6");
        al2.m(2);
        al2.setBounds(6, this.getHeight() - 25, 78, 19);
        this.add(al2);
        al2 = new al();
        al2.setVisible(false);
        al2.char("next");
        al2.try(this);
        al2.else("\u4e0b\u9875");
        al2.m(2);
        al2.setBounds(95, this.getHeight() - 25, 36, 19);
        this.add(al2);
        this.lD[0] = al2;
        al2 = new al();
        al2.setVisible(false);
        al2.char("prev");
        al2.try(this);
        al2.else("\u4e0a\u9875");
        al2.m(2);
        al2.setBounds(140, this.getHeight() - 25, 36, 19);
        this.add(al2);
        this.lD[1] = al2;
        al2 = new al();
        al2.char("map");
        al2.try(this);
        al2.else("\u672c\u5730\u56fe\u73a9\u5bb6");
        al2.m(2);
        al2.setBounds(this.getWidth() - 84, this.getHeight() - 25, 78, 19);
        this.add(al2);
        this.lA = new z();
        this.lA.setBounds(4, 30, 320, 300);
        this.add(this.lA);
    }
}

