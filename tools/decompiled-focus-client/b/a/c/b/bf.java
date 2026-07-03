/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.q;
import a.b.s;
import java.awt.AWTEventMulticaster;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class bf
extends s {
    public static final Cursor mI = Cursor.getPredefinedCursor(12);
    private String mL = "";
    private int mJ;
    private int mM = -1;
    private int mG = -16777216;
    private ActionListener mD;
    private String mK = "";
    private boolean mF;
    private boolean mE;
    private boolean mH;

    public static final bf a(String string, String string2, ActionListener actionListener, int n2, int n3, int n4, int n5) {
        bf bf2 = new bf();
        bf2.z(string);
        bf2.y(string2);
        bf2.case(actionListener);
        bf2.setBounds(n2, n3, n4, n5);
        return bf2;
    }

    public void else(boolean bl) {
        if (this.mH != bl) {
            this.mH = bl;
            this.repaint();
        }
    }

    public String d7() {
        return this.mK;
    }

    public void y(String string) {
        this.mK = string;
    }

    public bf() {
        this.enableEvents(16L);
        this.setCursor(mI);
    }

    public boolean d6() {
        return this.mH;
    }

    protected void processMouseEvent(MouseEvent mouseEvent) {
        int n2 = mouseEvent.getID();
        if (n2 == 504) {
            this.mF = true;
            this.repaint();
        } else if (n2 == 505) {
            this.mF = false;
            this.repaint();
        } else if (n2 == 501) {
            this.mE = true;
            this.repaint();
        } else if (n2 == 502) {
            this.mE = false;
            this.repaint();
            if (this.contains(mouseEvent.getX(), mouseEvent.getY()) && this.mD != null) {
                this.mD.actionPerformed(new ActionEvent(this, 1001, this.mK));
            }
        }
    }

    public void a(c c2) {
        int n2 = this.getWidth() / 2 - this.mJ / 2;
        int n3 = this.getHeight() / 2 - 6;
        if (this.mE || this.mH) {
            c2.a(0, n3 - 1, this.getWidth(), 14, -16744566);
            c2.a(this.mL, n2, n3, this.mM);
        } else if (this.mF) {
            c2.a(0, n3 - 2, this.getWidth(), 14, -16744566);
            c2.a(this.mL, n2, n3 - 1, this.mM);
        } else {
            c2.a(this.mL, n2, n3, this.mM);
        }
    }

    public void char(ActionListener actionListener) {
        this.mD = AWTEventMulticaster.remove(this.mD, actionListener);
    }

    public int d5() {
        return this.mM;
    }

    public void P(int n2) {
        this.mM = n2;
    }

    public int d3() {
        return this.mG;
    }

    public void O(int n2) {
        this.mG = n2;
    }

    public void case(ActionListener actionListener) {
        this.mD = AWTEventMulticaster.add(this.mD, actionListener);
    }

    public String d4() {
        return this.mL;
    }

    public void z(String string) {
        this.mL = string;
        this.mJ = q.if(string);
    }
}

