/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.q;
import a.b.s;
import a.b.z;
import b.a.c.b;
import b.a.c.b.e;
import b.a.c.b.g;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ay
extends z
implements ActionListener {
    private b kv;
    private String kw = "\u6211\u7684\u4f34\u4fa3";

    public ay(b b2) {
        this.kv = b2;
        this.char(true);
        this.setVisible(false);
    }

    public void a(c c2) {
        e.a(c2, this.kw, this.getWidth(), this.getHeight());
        super.a(c2);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        actionEvent.getActionCommand();
    }

    public void dk() {
        int n2 = 384;
        int n3 = 342;
        this.setBounds(130, 60, n2, n3);
        g g2 = new g();
        g2.setBounds(this.getWidth() - 23, 7, 15, 15);
        this.add(g2);
        s s2 = new s();
        s2.a(24);
        s2.setBounds(0, 30, this.getWidth(), this.getHeight() - 60);
        s2.if(new q("\u7ed3\u5a5a\u7cfb\u7edf\u6b63\u5728\u5f00\u53d1\u4e2d,\u5373\u5c06\u767b\u573a...", 0xFFFFFF));
        this.add(s2);
    }
}

