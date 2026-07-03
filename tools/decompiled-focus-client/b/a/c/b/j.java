/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.s;
import b.a.c.b;
import b.a.c.b.a2;
import b.a.c.b.z;
import b.a.d.k;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class j
extends s
implements ActionListener {
    private static final String[] bL = new String[]{"\u6e05\u9664\u7eaa\u5f55", "\u663e\u793a\u8bbe\u7f6e", "\u4f7f\u7528\u5e2e\u52a9"};
    private static final String[] bJ = new String[]{"clear", "setup", "help"};
    private b bG;
    private z bH;
    private int bI;
    private int bK;
    private int bM = 4;

    public void a(String string, int n2, String string2) {
        this.a(string, n2, string2, this.bK);
    }

    public void a(String string, int n2, String string2, int n3) {
        if (n3 == 0) {
            n3 = this.bK;
        }
        k k2 = this.bG.for();
        a2 a22 = null;
        if (k2.a.equals(string)) {
            string2 = "\u4f60" + string2;
            a22 = new a2(this.getWidth() - 24);
            a22.for(string2, n3);
        } else {
            a22 = new a2(this.getWidth() - 24);
            a22.a(this.bG, string, n2, string2, n3);
        }
        this.a(a22);
    }

    public void a(String string, int n2, String string2, int n3, String string3) {
        if (n2 == 0) {
            n2 = this.bK;
        }
        this.a(string, n2, string2, n3, string3, this.bK);
    }

    public void a(String string, int n2, String string2, int n3, String string3, int n4) {
        if (n2 == 0) {
            n2 = this.bK;
        }
        if (n4 == 0) {
            n4 = this.bK;
        }
        a2 a22 = new a2(this.getWidth() - 24);
        a22.a(this.bG, string, n2, string2, n3, string3, n4);
        this.a(a22);
    }

    public void a(b b2, String string, int n2, String string2, String string3, int n3, String string4, int n4) {
        if (n4 == 0) {
            n4 = this.bK;
        }
        a2 a22 = new a2(this.getWidth() - 24);
        a22.if(b2, string, n2, string2, string3, n3, string4, n4);
        this.a(a22);
    }

    public void a(b b2, String string, int n2, String string2, int n3, String string3, String string4, int n4, String string5, int n5) {
        if (n2 == 0) {
            n2 = this.bK;
        }
        if (n5 == 0) {
            n5 = this.bK;
        }
        a2 a22 = new a2(this.getWidth() - 24);
        a22.if(b2, string, n2, string2, n3, string3, string4, n4, string5, n5);
        this.a(a22);
    }

    public void if(String string, int n2, String string2, int n3) {
        if (n2 == 0) {
            n2 = this.bK;
        }
        if (n3 == 0) {
            n3 = this.bK;
        }
        a2 a22 = new a2(this.getWidth() - 24);
        a22.do(string, n2, string2, n3);
        this.a(a22);
    }

    private void a(a2 a22) {
        if (this.bH.bd() > 256) {
            this.aS();
        }
        this.bH.a(a22, 4, 4, this.bM);
        this.repaint();
    }

    public j(b b2, int n2, int n3) {
        this.bG = b2;
        this.bI = n2;
        this.bK = n3;
        this.enableEvents(16L);
        this.aR();
    }

    public void a(c c2) {
        c2.a(0, 0, this.getWidth() - 16, this.getHeight(), this.bI);
        c2.a(this.getWidth() - 16, 0, 16, this.getHeight(), -16777216);
        super.a(c2);
    }

    protected void processMouseEvent(MouseEvent mouseEvent) {
        if (mouseEvent.getID() == 501 && mouseEvent.getModifiers() == 4) {
            this.a(bL, bJ, this, mouseEvent.getX(), mouseEvent.getY());
        }
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.equals("clear")) {
            this.aS();
        } else if (string.equals("help")) {
            this.bG.new().if("\u5728\u4eba\u7684\u540d\u5b57\u4e0a\u53cc\u51fb\u9f20\u6807\u5de6\u952e\u53ef\u4ee5\u6253\u5f00\u5bc6\u804a\u7a97\u53e3\uff0c\u8ddf\u4ed6\u5355\u72ec\u8fdb\u884c\u804a\u5929\uff1b\u70b9\u9f20\u6807\u53f3\u952e\u53ef\u4ee5\u6709\u66f4\u591a\u9009\u9879\u3002", -1);
        } else if (string.equals("setup")) {
            this.bG.c().az().setVisible(true);
        }
    }

    public int aQ() {
        return this.bI;
    }

    public void f(int n2) {
        this.bI = n2;
    }

    public int aP() {
        return this.bK;
    }

    public void e(int n2) {
        this.bK = n2;
    }

    public void aS() {
        this.bH.bg();
    }

    public void setBounds(int n2, int n3, int n4, int n5) {
        super.setBounds(n2, n3, n4, n5);
        this.bH.setBounds(0, 0, n4, n5);
    }

    private void aR() {
        this.bH = new z();
        this.add(this.bH);
    }

    public void new(String string) {
        a2 a22 = new a2(this.getWidth() - 24);
        a22.for(string, this.bK);
        this.a(a22);
    }

    public void a(String string, int n2) {
        if (n2 == 0) {
            n2 = this.bK;
        }
        a2 a22 = new a2(this.getWidth() - 24);
        a22.for(string, n2);
        this.a(a22);
    }
}

