/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.o;
import a.b.s;
import a.b.z;
import b.a.c.b.al;
import b.a.c.b.e;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class aw
extends s
implements ActionListener {
    private static final int dV = 1;
    private static final int d1 = 2;
    private static final int d0 = 3;
    private z dY;
    private s dW;
    private al[] dZ = new al[2];
    private ActionListener d2;
    private int dU;
    private a[] dT = new a[32];
    private int dX;

    private void a(int n2, String string, int n3, String string2, String string3, ActionListener actionListener) {
        if (string.length() == 0) {
            string = "null";
        }
        this.dZ[0].setVisible(n2 != 2);
        this.dZ[1].setVisible(n2 != 2);
        if (n2 == 3) {
            this.dZ[0].char(string2);
            this.dZ[1].char(string3);
            this.d2 = actionListener;
        }
        this.dW.if(new o(string, this.dW.getWidth(), n3));
        this.bA();
        if (!this.isVisible()) {
            this.setVisible(true);
        }
    }

    public aw() {
        this.enableEvents(16L);
        this.do(false);
        this.setVisible(false);
        this.bD();
    }

    public void if(String string, int n2) {
        if (this.isVisible() && this.dZ[0].isVisible()) {
            this.a(1, string, n2);
        } else {
            this.a(1, string, n2, "", "", null);
        }
    }

    public void a(c c2) {
        int n2 = this.dY.getX();
        int n3 = this.dY.getY();
        int n4 = this.dY.getWidth() - 2;
        int n5 = this.dY.getHeight();
        c2.do(n2, n3);
        c2.a(0, 0, n4, n5 - 26, -1090519040);
        e.if(c2, 0, 0, n4, n5 - 26);
        e.a(c2, 0, n5 - 26, n4);
        this.dY.a(c2);
        c2.do(-n2, -n3);
    }

    public void if(String string, int n2, String string2, String string3, ActionListener actionListener) {
        if (this.isVisible() && this.dZ[0].isVisible()) {
            this.a(string, n2, string2, string3, actionListener);
        } else {
            this.a(3, string, n2, string2, string3, actionListener);
        }
    }

    public int bC() {
        return this.dU;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        ActionListener actionListener = this.d2;
        this.d2 = null;
        if (this.dX > 0) {
            this.bB();
        } else {
            this.setVisible(false);
        }
        if (actionListener != null) {
            actionListener.actionPerformed(actionEvent);
        }
    }

    private void bA() {
        if (this.dY.getX() < 0) {
            this.dY.setLocation(this.getWidth() / 2 - this.dY.getWidth() / 2, this.getHeight() / 2 - this.dY.getHeight() / 2);
        }
    }

    public void do(int n2, int n3, int n4, int n5) {
        this.dY.setLocation(n2 + n4 / 2 - this.dY.getWidth() / 2, n3 + n5 / 2 - this.dY.getHeight() / 2);
    }

    public void do(String string, int n2) {
        if (this.isVisible() && this.dZ[0].isVisible()) {
            this.a(2, string, n2);
        } else {
            this.a(2, string, n2, "", "", null);
        }
    }

    private void bD() {
        this.dY = new z();
        this.dY.char(true);
        this.dY.setSize(286, 146);
        this.dY.setLocation(-65535, -65535);
        this.dW = new s();
        this.dW.setBounds(8, 16, 270, 96);
        this.dY.add(this.dW);
        int[] nArray = new int[]{this.dY.getWidth() / 2 - 44 - 4, this.dY.getWidth() / 2 + 4};
        int n2 = 0;
        do {
            this.dZ[n2] = new al();
            this.dZ[n2].char(n2 == 0 ? "OK" : "Cancel");
            this.dZ[n2].try(this);
            this.dZ[n2].m(2);
            this.dZ[n2].setBounds(nArray[n2], this.dY.getHeight() - 25, 44, 19);
            this.dZ[n2].else(n2 == 0 ? "\u786e \u5b9a" : "\u53d6 \u6d88");
            this.dY.add(this.dZ[n2]);
        } while (++n2 < 2);
        this.add(this.dY);
    }

    private void bB() {
        a a10 = this.dT[0];
        if (a10 == null) {
            this.setVisible(false);
            return;
        }
        int n2 = 1;
        while (n2 < this.dX) {
            this.dT[n2 - 1] = this.dT[n2];
            ++n2;
        }
        this.dT[this.dX += -1] = null;
        this.a(a10.do, a10.for, a10.a, a10.if, a10.new, a10.int);
    }

    private void a(int n2, String string, int n3) {
        if (this.dX >= this.dT.length) {
            return;
        }
        a a10 = new a();
        a10.do = n2;
        a10.for = string;
        a10.a = n3;
        this.dT[this.dX++] = a10;
    }

    private void a(String string, int n2, String string2, String string3, ActionListener actionListener) {
        if (this.dX >= this.dT.length) {
            return;
        }
        a a10 = new a();
        a10.do = 3;
        a10.for = string;
        a10.a = n2;
        a10.if = string2;
        a10.new = string3;
        a10.int = actionListener;
        this.dT[this.dX++] = a10;
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    private static class a {
        int do;
        String for;
        int a;
        String if;
        String new;
        ActionListener int;

        a() {
        }
    }
}

