/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.l;
import a.b.n;
import a.b.q;
import a.b.z;
import b.a.c.b;
import b.a.c.b.al;
import b.a.c.b.e;
import b.a.c.b.g;
import b.a.c.b.j;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class bb
extends z
implements ActionListener,
KeyListener {
    private a.a.q lH = new a.a.q(200);
    private b lF;
    private String lI = "\u81ea\u5df1";
    private int lJ = 24;
    private j lK;
    private n lG;

    public bb(b b2) {
        this.lF = b2;
    }

    public void keyTyped(KeyEvent keyEvent) {
    }

    public void keyPressed(KeyEvent keyEvent) {
    }

    public String dF() {
        return this.lI;
    }

    public void if(String string, int n2, String string2) {
        j j2 = this.s(string);
        j2.a(string, n2, string2);
    }

    public void a(c c2) {
        e.if(c2, 0, 26, this.getWidth(), this.getHeight() - 52);
        e.for(c2, 0, 0, this.getWidth());
        c2.a('\u4e0e', 24, 9, -1);
        c2.a(this.lI, 43, 9, -14698241);
        c2.a("\u5bc6\u804a\u4e2d", 50 + this.lJ, 9, -1);
        e.if(c2, 3, this.getHeight() - 52, this.getWidth() - 3);
        e.a(c2, 0, this.getHeight() - 26, this.getWidth());
        super.a(c2);
    }

    public void setVisible(boolean bl) {
        super.setVisible(bl);
        if (!bl) {
            this.lF.j().requestFocus();
        }
    }

    private j s(String string) {
        j j2 = (j)this.lH.for(string);
        if (j2 == null) {
            j2 = new j(this.lF, -1627389952, -54592);
            j2.setBounds(4, 30, this.getWidth() - 8, this.getHeight() - 52 - 30);
            j2.setName(string);
            this.lH.a((Object)string, (Object)j2);
        }
        return j2;
    }

    private void dE() {
        String string = this.lG.D();
        if (string.length() == 0) {
            return;
        }
        this.lG.if("");
        this.lF.byte().if(this.lI, string);
        this.lK.new("\u4f60\u8bf4\uff1a" + string);
        j j2 = this.lF.c().aB().T().void("whisper");
        j2.a("\u4f60\u5bf9", 0, this.lI, 0, "\u8bf4\uff1a" + string);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.equals("sendChat")) {
            this.dE();
        } else if (string.equals("clearRecords") && this.lK != null) {
            this.lK.aS();
        }
    }

    public void keyReleased(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 27 && this.lG.D().length() == 0) {
            this.setVisible(false);
        }
    }

    public void dG() {
        int n2 = 308;
        int n3 = 328;
        this.setBounds(152, 60, n2, n3);
        g g2 = new g();
        g2.setBounds(this.getWidth() - 23, 7, 15, 15);
        this.add(g2);
        this.lG = new n();
        this.lG.a(new l(-4539718));
        this.lG.goto(-16777216);
        this.lG.char(-16777216);
        this.lG.else(50);
        this.lG.do("sendChat");
        this.lG.for(this);
        this.lG.addKeyListener(this);
        this.lG.setBounds(3, this.getHeight() - 49, this.getWidth() - 6, 20);
        this.add(this.lG);
        al al2 = new al();
        al2.char("clearRecords");
        al2.try(this);
        al2.else("\u6e05\u9664\u7eaa\u5f55");
        al2.m(2);
        al2.setBounds(6, this.getHeight() - 25, 66, 19);
        this.add(al2);
        al2 = new al();
        al2.char("sendChat");
        al2.try(this);
        al2.else("\u53d1\u9001\u6d88\u606f");
        al2.m(2);
        al2.setBounds(this.getWidth() - 72, this.getHeight() - 25, 66, 19);
        this.add(al2);
        this.char(true);
        super.setVisible(false);
    }

    public void t(String string) {
        if (string.equals(this.lF.for().a)) {
            this.lF.new().if("\u4e0d\u53ef\u4e0e\u81ea\u5df1\u79c1\u804a", -65536);
            return;
        }
        if (string.equals(this.lI) && this.isVisible()) {
            return;
        }
        this.lI = string;
        this.lJ = q.if(this.lI);
        j j2 = this.s(string);
        if (j2 != this.lK) {
            if (this.lK != null) {
                this.remove(this.lK);
            }
            this.add(j2);
            this.lK = j2;
        }
        if (!this.isVisible()) {
            this.setVisible(true);
            this.new();
            this.lG.requestFocus();
        }
    }
}

