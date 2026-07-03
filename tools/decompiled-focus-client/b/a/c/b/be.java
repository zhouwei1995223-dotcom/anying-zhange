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
public class be
extends a.b.z
implements ActionListener {
    public static final String[] lO = new String[]{"\u5bcc\u7fc1\u699c", "\u7b49\u7ea7\u699c", "\u8363\u8000\u699c", "\u6076\u4eba\u699c", "\u884c\u8005\u699c", "\u6d3b\u8dc3\u699c", "\u6e38\u4fa0\u699c", "\u6cd5\u5e08\u699c", "\u6218\u58eb\u699c", "\u529f\u52cb\u699c", "\u7b54\u9898\u699c", "\u5f00\u7bb1\u699c", "\u5320\u5e08\u699c", "\u4fee\u70bc\u699c", "\u6d88\u8d39\u699c", "\u5145\u503c\u699c"};
    public static final String[] lN = new String[]{"\u91d1\u5e01\u6570", "\u8f6c\u751f\u6b21\u6570", "\u6740\u602a\u6570\u91cf", "PK\u503c", "\u79fb\u52a8\u6b65\u6570", "\u5728\u7ebf\u65f6\u95f4", "\u8f6c\u751f\u6b21\u6570", "\u8f6c\u751f\u6b21\u6570", "\u8f6c\u751f\u6b21\u6570", "\u529f\u52cb\u503c", "\u7b54\u9898\u6210\u7ee9", "\u5f00\u7bb1\u6b21\u6570", "\u6253\u9020\u6b21\u6570", "\u4fee\u70bc\u65f6\u95f4", "\u6d88\u8d39\u5143\u5b9d", "\u5145\u503c\u5143\u5b9d"};
    private b lM;
    private String lP;
    private s lQ;
    private z lL;

    public be(b b2) {
        this.lM = b2;
        this.char(true);
        this.setVisible(false);
    }

    public void a(c c2) {
        e.a(c2, this.lP, this.getWidth(), this.getHeight());
        super.a(c2);
        c2.do(4, 50, this.getWidth() - 4, 50, -3750223);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.startsWith("whisper:")) {
            String string2 = string.substring(8);
            this.lM.c().ag().t(string2);
        }
    }

    public void void(a.a.e e2) {
        this.lL.bg();
        int n2 = e2.for();
        boolean bl = lN[n2 - 1].equals("\u8f6c\u751f\u6b21\u6570");
        int n3 = e2.for();
        int n4 = 0;
        while (n4 < n3) {
            String string = e2.h();
            int n5 = e2.for();
            int n6 = e2.i();
            if (bl) {
                n6 >>= 16;
            }
            s s2 = new s();
            s2.setSize(300, 20);
            s s3 = new s();
            s3.a(8);
            s3.if(new q(String.valueOf(n4 + 1), -1));
            s3.setBounds(4, 4, 24, 12);
            s2.add(s3);
            s3 = new s();
            s3.a(8);
            s3.if(new q(string, -1));
            s3.setBounds(28, 4, 110, 12);
            s2.add(s3);
            s3 = new s();
            s3.a(8);
            s3.if(new q(String.valueOf(n5), -1));
            s3.setBounds(138, 4, 24, 12);
            s2.add(s3);
            s3 = new s();
            s3.a(8);
            if (lN[n2 - 1].equals("\u5728\u7ebf\u65f6\u95f4")) {
                s3.if(new q(String.valueOf(n6 / 3600) + "\u5c0f\u65f6", -1));
            } else {
                s3.if(new q(String.valueOf(n6), -1));
            }
            s3.setBounds(162, 4, 110, 12);
            s2.add(s3);
            al al2 = al.a(2, "\u5bc6\u8bed", "whisper:" + string, this, 272, 1, 44, 19);
            s2.add(al2);
            this.lL.a(s2, 0, 0, 0);
            ++n4;
        }
        s s4 = (s)this.lQ.case();
        ((q)s4.void()).do(lN[n2 - 1]);
        s4.repaint();
        this.lP = lO[n2 - 1];
        if (!this.isVisible()) {
            this.setVisible(true);
        }
    }

    public void dH() {
        int n2 = 350;
        int n3 = 300;
        this.setBounds(140, 80, n2, n3);
        g g2 = new g();
        g2.setBounds(this.getWidth() - 23, 7, 15, 15);
        this.add(g2);
        this.lQ = new s();
        this.lQ.setBounds(4, 30, this.getWidth() - 8, 20);
        String[] stringArray = new String[]{"\u6392\u540d", "\u73a9\u5bb6\u540d", "\u7b49\u7ea7", "data", "\u5bc6\u8bed"};
        int[] nArray = new int[]{4, 28, 138, 162, 272};
        int[] nArray2 = new int[]{24, 110, 24, 110, 44};
        int n4 = 0;
        while (n4 < stringArray.length) {
            s s2 = new s();
            s2.a(8);
            s2.if(new q(stringArray[n4], -527356));
            s2.setBounds(nArray[n4], 4, nArray2[n4], 12);
            this.lQ.add(s2);
            if (n4 == 3) {
                this.lQ.a(s2);
            }
            ++n4;
        }
        this.add(this.lQ);
        this.lL = new z();
        this.lL.byte(false);
        this.lL.setBounds(4, 50, this.getWidth() - 8, 220);
        this.add(this.lL);
    }
}

