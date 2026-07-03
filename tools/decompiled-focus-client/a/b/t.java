/*
 * Decompiled with CFR 0.152.
 */
package a.b;

import a.b.c;
import a.b.q;
import a.b.s;
import java.awt.AWTEventMulticaster;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
class t
extends s {
    private String[] ao;
    private q[] an;
    private ActionListener al;
    private int am = 0;
    private int width;
    private int ap;

    public t(String[] stringArray, String[] stringArray2, ActionListener actionListener) {
        this.ao = stringArray2;
        this.an = new q[stringArray.length];
        int n2 = 0;
        int n3 = 0;
        while (n3 < this.an.length) {
            this.an[n3] = new q(stringArray[n3], -11167);
            n2 = Math.max(n2, this.an[n3].a());
            ++n3;
        }
        this.ap = this.an[0].if() * 2;
        this.setSize(n2 += 32, this.an.length * this.ap + 4);
        this.enableEvents(48L);
        if (actionListener != null) {
            this.new(actionListener);
        }
    }

    protected void processMouseEvent(MouseEvent mouseEvent) {
        if (mouseEvent.getID() == 501) {
            ActionEvent actionEvent = new ActionEvent(this, 1001, this.ao[this.am]);
            this.al.actionPerformed(actionEvent);
        } else if (mouseEvent.getID() == 505) {
            this.repaint(0, this.ap * this.am, this.getWidth(), this.ap);
            this.am = -1;
        }
    }

    public void a(c c2) {
        int n2 = this.getWidth() - 4;
        int n3 = this.getHeight() - 4;
        c2.a(0, 0, n2, n3, -1090519040);
        if (this.am != -1) {
            c2.a(0, this.am * this.ap, n2, this.ap, -16744566);
        }
        int n4 = this.ap;
        int n5 = this.an.length - 2;
        while (n5 >= 0) {
            c2.do(0, n4, n2, n4, -16777216);
            n4 += this.ap;
            --n5;
        }
        n4 = this.ap / 2 - this.an[0].if() / 2;
        n5 = 0;
        while (n5 < this.an.length) {
            this.an[n5].a(c2, 16, n4, 0, 0);
            n4 += this.ap;
            ++n5;
        }
    }

    public void int(ActionListener actionListener) {
        this.al = AWTEventMulticaster.remove(this.al, actionListener);
    }

    protected void processMouseMotionEvent(MouseEvent mouseEvent) {
        int n2;
        if (mouseEvent.getID() == 503 && (n2 = mouseEvent.getY() / this.ap) != this.am && n2 < this.an.length) {
            this.repaint(0, this.ap * this.am, this.getWidth(), this.ap);
            this.am = n2;
            this.repaint(0, this.ap * this.am, this.getWidth(), this.ap);
        }
    }

    protected void processKeyEvent(KeyEvent keyEvent) {
    }

    public void new(ActionListener actionListener) {
        this.al = AWTEventMulticaster.add(this.al, actionListener);
    }

    public boolean isFocusTraversable() {
        return true;
    }
}

