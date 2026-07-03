/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.ab;
import a.b.c;
import a.b.d;
import a.b.j;
import a.b.z;
import b.a.c.b;
import b.a.c.b.al;
import b.a.c.b.e;
import b.a.c.b.g;
import b.a.d.k;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class q
extends z
implements ActionListener {
    private static d[][] f1 = new d[][]{{new d("\u70b9\u51fb\u589e\u52a0\u5206\u914d\u4e00\u70b9\u5f3a\u58ee"), new d("\u70b9\u51fb\u51cf\u5c11\u5206\u914d\u4e00\u70b9\u5f3a\u58ee")}, {new d("\u70b9\u51fb\u589e\u52a0\u5206\u914d\u4e00\u70b9\u654f\u6377"), new d("\u70b9\u51fb\u51cf\u5c11\u5206\u914d\u4e00\u70b9\u654f\u6377")}, {new d("\u70b9\u51fb\u589e\u52a0\u5206\u914d\u4e00\u70b9\u667a\u6167"), new d("\u70b9\u51fb\u51cf\u5c11\u5206\u914d\u4e00\u70b9\u667a\u6167")}};
    private b fX;
    private int f0;
    private int fY;
    private int fZ;

    private void a(c c2, int n2, int n3, int n4, int n5, int n6) {
        c2.if(n2, n3, n4, n5, -4737099);
        c2.a(n2 + 1, n3 + 1, n4 - 2, n5 - 2, -16646141);
        int n7 = 0;
        n2 += n4 - 8;
        n3 += 2;
        do {
            n7 = n6 % 10;
            c2.a((char)(n7 + 48), n2, n3, -1);
            n2 -= 6;
        } while ((n6 /= 10) != 0);
    }

    public q(b b2) {
        this.fX = b2;
        this.char(true);
        this.setVisible(false);
    }

    public void a(c c2) {
        k k2 = this.fX.for();
        c2.a(4, 30, this.getWidth() - 8, this.getHeight() - 59, -1627389952);
        e.if(c2, 0, 26, this.getWidth(), this.getHeight() - 52);
        e.for(c2, 0, 0, this.getWidth());
        c2.a("\u5c5e\u6027", 10, 9, -14698241);
        int n2 = 18;
        int n3 = 42;
        c2.a("\u57fa\u7840\u5c5e\u6027", n2, n3, -4081);
        c2.a("\u5269\u4f59\u70b9\u6570", n2 + 128, n3, -4081);
        c2.a("\u5f3a\u58ee", n2, n3 += 21, -1);
        this.a(c2, n2 + 40, n3 - 2, 40, 16, k2.N);
        this.a(c2, n2 + 134, n3 - 2, 34, 16, k2.bv);
        c2.a("\u654f\u6377", n2, n3 += 21, -1);
        this.a(c2, n2 + 40, n3 - 2, 40, 16, k2.G);
        c2.a("\u667a\u529b", n2, n3 += 21, -1);
        this.a(c2, n2 + 40, n3 - 2, 40, 16, k2.X);
        e.if(c2, 3, n3 += 24, this.getWidth() - 3);
        c2.a("\u7269\u7406\u653b\u51fb\u529b", n2, n3 += 17, -1);
        int n4 = e.int(c2, k2.a(), n2 + 100, n3);
        c2.a('-', n4, n3, -1);
        e.int(c2, k2.if(), n4 + 6, n3);
        c2.a("\u9b54\u6cd5\u653b\u51fb\u529b", n2, n3 += 16, -1);
        n4 = e.int(c2, k2.case(), n2 + 100, n3);
        c2.a('-', n4, n3, -1);
        e.int(c2, k2.int(), n4 + 6, n3);
        c2.a("\u7269\u7406\u9632\u5fa1", n2, n3 += 16, -1);
        e.int(c2, k2.try() + k2.bA.try(k2), n2 + 100, n3);
        c2.a("\u9b54\u6cd5\u9632\u5fa1", n2, n3 += 16, -1);
        e.int(c2, k2.byte() + k2.bA.case(k2), n2 + 100, n3);
        c2.a("\u653b\u51fb\u65f6\u95f4", n2, n3 += 16, -1);
        e.int(c2, k2.do() + k2.new(), n2 + 100, n3);
        c2.a("\u547d\u4e2d\u529b", n2, n3 += 16, -1);
        e.int(c2, k2.char(), n2 + 100, n3);
        c2.a("\u8eb2\u907f\u529b", n2, n3 += 16, -1);
        e.int(c2, k2.b(), n2 + 100, n3);
        c2.a("PK\u503c", n2, n3 += 16, -1);
        e.int(c2, k2.aL, n2 + 100, n3);
        c2.a("\u8f6c\u751f\u6b21\u6570", n2, n3 += 16, -1);
        e.int(c2, k2.ab, n2 + 100, n3);
        c2.a("\u529f\u52cb\u503c", n2, n3 += 16, -1);
        e.int(c2, k2.bi, n2 + 100, n3);
        e.a(c2, 0, this.getHeight() - 26, this.getWidth());
        super.a(c2);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        k k2 = this.fX.for();
        String string = actionEvent.getActionCommand();
        if (string.equals("submitAddPoint")) {
            if (this.f0 > 0 || this.fY > 0 || this.fZ > 0) {
                this.fX.byte().a(this.f0, this.fY, this.fZ);
                this.f0 = 0;
                this.fY = 0;
                this.fZ = 0;
            }
        } else if (string.equals("cancelAddPoint")) {
            if (this.f0 > 0 || this.fY > 0 || this.fZ > 0) {
                k2.bv += this.f0 + this.fY + this.fZ;
                k2.N -= this.f0;
                k2.G -= this.fY;
                k2.X -= this.fZ;
                k2.i();
                this.f0 = 0;
                this.fY = 0;
                this.fZ = 0;
            }
        } else if (string.startsWith("addPoint:")) {
            if (k2.bv <= 0) {
                this.fX.new().if("\u5f53\u524d\u6ca1\u6709\u5269\u4f59\u7684\u5c5e\u6027\u70b9\u6570\u53ef\u4ee5\u5206\u914d\u4e86\uff01", -65536);
                return;
            }
            int n2 = string.charAt(string.length() - 1) - 48;
            if (n2 == 0) {
                ++this.f0;
                ++k2.N;
            } else if (n2 == 1) {
                ++this.fY;
                ++k2.G;
            } else {
                ++this.fZ;
                ++k2.X;
            }
            k2.bv += -1;
            k2.i();
        } else if (string.startsWith("reducePoint:")) {
            int n3 = string.charAt(string.length() - 1) - 48;
            if (n3 == 0) {
                if (this.f0 > 0) {
                    this.f0 += -1;
                    k2.N += -1;
                    ++k2.bv;
                } else {
                    this.fX.new().if("\u5f53\u524d\u5e76\u6ca1\u6709\u5206\u914d\u529b\u91cf\u5c5e\u6027\u70b9\u6570\uff01", -65536);
                }
            } else if (n3 == 1) {
                if (this.fY > 0) {
                    this.fY += -1;
                    k2.G += -1;
                    ++k2.bv;
                } else {
                    this.fX.new().if("\u5f53\u524d\u5e76\u6ca1\u6709\u5206\u914d\u654f\u6377\u5c5e\u6027\u70b9\u6570\uff01", -65536);
                }
            } else if (this.fZ > 0) {
                this.fZ += -1;
                k2.X += -1;
                ++k2.bv;
            } else {
                this.fX.new().if("\u5f53\u524d\u5e76\u6ca1\u6709\u5206\u914d\u667a\u6167\u5c5e\u6027\u70b9\u6570\uff01", -65536);
            }
            k2.i();
        }
        this.repaint();
    }

    public void cf() {
        int n2 = 204;
        int n3 = 342;
        this.setBounds(0, 40, n2, n3);
        g g2 = new g();
        g2.setBounds(this.getWidth() - 23, 7, 15, 15);
        this.add(g2);
        al al2 = al.a(2, "\u786e\u8ba4", "submitAddPoint", this, 130, 100, 32, 19);
        this.add(al2);
        al2 = al.a(2, "\u53d6\u6d88", "cancelAddPoint", this, 164, 100, 32, 19);
        this.add(al2);
        int n4 = 100;
        int n5 = 60;
        int n6 = 0;
        do {
            j j2 = new j();
            j2.a("addPoint:" + n6);
            j2.a(f1[n6][0]);
            j2.a(this);
            j2.setBounds(n4, n5, 8, 8);
            j2.for(new ab(e.aZ, 0, 188, 8, 8));
            this.add(j2);
            j2 = new j();
            j2.a("reducePoint:" + n6);
            j2.a(f1[n6][1]);
            j2.a(this);
            j2.setBounds(n4, n5 + 8, 8, 8);
            j2.for(new ab(e.aZ, 8, 188, 8, 8));
            this.add(j2);
            n5 += 22;
        } while (++n6 < 3);
    }
}

