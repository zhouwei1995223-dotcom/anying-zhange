/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.o;
import a.b.q;
import a.b.s;
import a.b.z;
import b.a.b.p;
import b.a.c.b;
import b.a.c.b.al;
import b.a.c.b.e;
import b.a.c.b.g;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ax
extends z
implements ActionListener {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private String[] ks = new String[]{"1\u5c0f\u65f6", "3\u5c0f\u65f6", "6\u5c0f\u65f6", "9\u5c0f\u65f6", "12\u5c0f\u65f6"};
    private String[] km = new String[]{"one", "three", "six", "nine", "twelve"};
    private String[] kl = new String[]{"\u4fee\u70bc\u65f6\u95f4"};
    private String[] kr = new String[]{"time"};
    b kn;
    private al[] kp = new al[2];
    private al kk = new al();
    private a.b.b[] kq = new a.b.b[2];
    int ku = 0;
    private s ko;
    private s kt;

    public void dg() {
        a a10 = new a();
        a10.setBounds(8, 225, this.getWidth() - 16, 10);
        this.add(a10);
        new Thread(a10).start();
        this.kn.new().setVisible(false);
    }

    public void dj() {
        if (this.kn.for().br == 1) {
            this.ko.if(this.kq[1]);
        } else {
            this.ko.if(this.kq[0]);
        }
    }

    public ax(b b2) {
        this.kn = b2;
        this.char(true);
        this.setVisible(false);
    }

    public void a(c c2) {
        e.a(c2, "\u4fee\u70bc\u6a21\u5f0f", this.getWidth(), this.getHeight());
        String string = "";
        int n2 = 0;
        int n3 = 0;
        if (this.kn.for().h() && this.kn.for().br == 1) {
            int n4;
            if (this.ku != 0) {
                n2 = (int)(System.currentTimeMillis() - this.kn.for().aX) / 1000;
                n4 = this.ku * 3600;
                if (n2 < 0) {
                    n2 = 0;
                }
                if (n4 < 0) {
                    n4 = 0;
                }
                if (n2 < n4) {
                    StringBuffer stringBuffer = new StringBuffer("\u4fee\u70bc\u8fdb\u5ea6\uff1a");
                    stringBuffer.append(n2);
                    stringBuffer.append("/");
                    stringBuffer.append(n4);
                    string = stringBuffer.toString();
                } else {
                    string = "\u4fee\u70bc\u5df2\u5b8c\u6210\uff0c\u8bf7\u70b9\u201c\u505c\u6b62\u4fee\u70bc\u201d\u7ed3\u7b97\u6536\u76ca";
                    n2 = 0;
                }
                n3 = (this.getWidth() - q.if(string)) / 2;
                c2.a(string, n3, 250, Color.yellow.getRGB());
            }
            n4 = (int)(System.currentTimeMillis() / 130L % 8L);
            if (System.currentTimeMillis() <= this.kn.for().au) {
                if (p.ag[this.kn.for().af * 2 + this.kn.for().an] != null && p.ag[this.kn.for().af * 2 + this.kn.for().an][this.kn.for().ac] != null && p.ag[this.kn.for().af * 2 + this.kn.for().an][this.kn.for().ac][2] != null) {
                    c2.a(p.ag[this.kn.for().af * 2 + this.kn.for().an][this.kn.for().ac][2], 0, 55, 150 * n4, 600, 150, 150, 5, 0);
                }
            } else {
                n4 = (int)(System.currentTimeMillis() / 260L % 4L);
                if (p.ag[this.kn.for().af * 2 + this.kn.for().an] != null && p.ag[this.kn.for().af * 2 + this.kn.for().an][this.kn.for().ac] != null && p.ag[this.kn.for().af * 2 + this.kn.for().an][this.kn.for().ac][0] != null) {
                    c2.a(p.ag[this.kn.for().af * 2 + this.kn.for().an][this.kn.for().ac][0], 0, 55, 150 * n4, 600, 150, 150, 5, 0);
                }
            }
        } else {
            int n5 = (int)(System.currentTimeMillis() / 260L % 4L);
            if (p.ag[this.kn.for().af * 2 + this.kn.for().an] != null && p.ag[this.kn.for().af * 2 + this.kn.for().an][this.kn.for().ac] != null && p.ag[this.kn.for().af * 2 + this.kn.for().an][this.kn.for().ac][0] != null) {
                c2.a(p.ag[this.kn.for().af * 2 + this.kn.for().an][this.kn.for().ac][0], 0, 55, 150 * n5, 600, 150, 150, 5, 0);
            }
        }
        super.a(c2);
    }

    public void di() {
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.startsWith("time")) {
            al al2 = (al)actionEvent.getSource();
            this.a(this.ks, this.km, this, al2.getX() + al2.getWidth(), al2.getY());
        } else if (string.startsWith("one")) {
            this.ku = 1;
            this.kk.else(this.ks[0]);
        } else if (string.startsWith("three")) {
            this.ku = 3;
            this.kk.else(this.ks[1]);
        } else if (string.startsWith("six")) {
            this.ku = 6;
            this.kk.else(this.ks[2]);
        } else if (string.startsWith("nine")) {
            this.ku = 9;
            this.kk.else(this.ks[3]);
        } else if (string.startsWith("twelve")) {
            this.ku = 12;
            this.kk.else(this.ks[4]);
        } else if (string.startsWith("beginTrain")) {
            if (this.kn.for().p >= 30) {
                if (this.ku == 0) {
                    this.kn.new().if("\u8bf7\u9009\u62e9\u4fee\u70bc\u65f6\u95f4!", -11167, "", "", this);
                    this.kn.for().br = 0;
                } else {
                    this.kn.for().br = 1;
                    this.kn.for().aX = System.currentTimeMillis();
                    this.kp[0].else("\u505c\u6b62\u4fee\u70bc");
                    this.kp[0].char("endTrain");
                    this.kt.if(null);
                    this.ko.if(this.kq[1]);
                    this.kk.setVisible(false);
                    this.kn.byte().E(this.ku);
                    this.dg();
                }
            } else {
                this.kn.new().if("\u7b49\u7ea7\u8fbe\u523030\u7ea7\u624d\u53ef\u4ee5\u4fee\u70bc!", -11167, "", "", this);
            }
        } else if (string.equals("endTrain")) {
            this.kn.for().br = 0;
            this.kp[0].else("\u5f00\u59cb\u4fee\u70bc");
            this.kp[0].char("beginTrain");
            this.kt.if(new q("\u8bf7\u9009\u62e9\u4fee\u70bc\u65f6\u95f4:", Color.green.getRGB()));
            this.kk.else("\u4fee\u70bc\u65f6\u95f4");
            this.kk.setVisible(true);
            this.kn.byte().a();
        } else if (string.startsWith("closeTrain")) {
            this.setVisible(false);
        }
    }

    public void dh() {
        String[] stringArray;
        int n2 = 0;
        while (n2 < this.kl.length) {
            stringArray = al.a(2, this.kl[n2], this.kr[n2], this, 265, 200, 90, 15);
            this.kk = stringArray;
            this.add((Component)stringArray);
            ++n2;
        }
        this.setBounds(70, 50, 400, 300);
        this.kq[0] = new o("\u6b22\u8fce\u4f7f\u7528\u4fee\u70bc\u529f\u80fd\u3002\u901a\u8fc7\u4fee\u70bc\u53ef\u4ee5\u63d0\u9ad8\u60a8\u7684\u6280\u827a\u6c34\u5e73\uff0c\u8f7b\u677e\u83b7\u5f97\u7ecf\u9a8c\u5e76\u6709\u51e0\u7387\u83b7\u5f97\u5b9d\u7269\u3002\u5f53\u60a8\u79bb\u7ebf\u65f6\u4fee\u70bc\u7ee7\u7eed\u6709\u6548\u3002\u4fee\u70bc\u8fc7\u7a0b\u4e2d\u65e0\u6cd5\u8fdb\u884c\u4efb\u4f55\u653b\u51fb\u64cd\u4f5c\uff0c\u505c\u6b62\u4fee\u70bc\u5373\u53ef\u6062\u590d\u6b63\u5e38\u3002\u4fee\u70bc\u83b7\u5f97\u7ecf\u9a8c\u968f\u73a9\u5bb6\u7b49\u7ea7\u63d0\u5347\u800c\u63d0\u5347\u3002", 220, Color.white.getRGB());
        this.kq[1] = new o("    \u8bf7\u7b49\u5f85\uff0c\u6b63\u5728\u8fdb\u884c\u4fee\u70bc\u4e2d...           \u5728\u4fee\u70bc\u65f6\u95f4\u5230\u8fbe\u540e\uff0c\u60a8\u53ef\u4ee5\u70b9\u201c\u505c\u6b62\u4fee\u70bc\u201d\u6309\u94ae\u6765\u7ed3\u7b97\u672c\u6b21\u4fee\u70bc\u6240\u5f97\u7684\u6536\u76ca\u3002\u5f53\u60a8\u79bb\u7ebf\u65f6\u4fee\u70bc\u7ee7\u7eed\u6709\u6548\u3002\u5982\u679c\u65f6\u95f4\u672a\u6ee1\uff0c\u60a8\u4e5f\u53ef\u4ee5\u7ed3\u675f\u4fee\u70bc\uff0c\u4e0d\u8fc7\u53ef\u80fd\u4f1a\u635f\u5931\u4e00\u4e9b\u7ecf\u9a8c\uff0c\u5e76\u5c06\u4e0d\u80fd\u6536\u83b7\u5b9d\u7269\u3002", 220, Color.white.getRGB(), 0);
        this.kt = new s();
        this.kt.setBounds(165, 201, 90, 12);
        this.kt.if(new q("\u8bf7\u9009\u62e9\u4fee\u70bc\u65f6\u95f4:", Color.green.getRGB()));
        this.add(this.kt);
        this.ko = new s();
        this.ko.setBounds(150, 76, 220, 100);
        this.add(this.ko);
        this.add(new g(this.getWidth() - 23, 7, 15, 15));
        String[] stringArray2 = new String[]{"\u5f00\u59cb\u4fee\u70bc", "\u5173\u95ed"};
        stringArray = new String[]{"beginTrain", "closeTrain"};
        int n3 = 0;
        while (n3 < stringArray2.length) {
            al al2;
            this.kp[n3] = al2 = al.a(2, stringArray2[n3], stringArray[n3], this, 100 * n3 + 110, 275, 74, 19);
            this.add(al2);
            ++n3;
        }
        this.dj();
        if (this.kn.for().br == 1) {
            this.ku = this.kn.for().bb;
            this.kp[0].else("\u505c\u6b62\u4fee\u70bc");
            this.kp[0].char("endTrain");
            this.kt.if(null);
            this.ko.if(this.kq[1]);
            this.kk.setVisible(false);
            this.dg();
        }
    }

    private class a
    extends s
    implements Runnable {
        private int d3;

        public void a(c c2) {
            float f2 = (float)(this.d3 / 60) / (float)(ax.this.ku * 3600 / 60);
            int n2 = (int)((float)this.getWidth() * f2);
            int n3 = 0;
            while (n3 < n2) {
                c2.if(e.aZ, n3, 0, 35, 226, 17, 20);
                c2.if(e.aZ, n3, 0, 35, 226, Math.min(20, n2 - n3), 20);
                ++n3;
            }
        }

        a() {
            ax.this.getClass();
            this.d3 = 0;
        }

        public void run() {
            int n2 = 100;
            while (ax.this.kn.for().br == 1) {
                a.a.b.a(n2);
                this.d3 = (int)(System.currentTimeMillis() - ax.this.kn.for().aX) / 1000;
                this.repaint();
            }
            this.getParent().remove(this);
            ax.this.ku = 0;
        }
    }
}

