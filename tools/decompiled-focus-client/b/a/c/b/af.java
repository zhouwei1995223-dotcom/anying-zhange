/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.n;
import a.b.o;
import a.b.s;
import a.b.z;
import b.a.c.b;
import b.a.c.b.al;
import b.a.c.b.e;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class af
extends z
implements ActionListener {
    private b h9;
    private s ic;
    private al ib;
    private ActionListener id;
    private n ia;

    public af(b b2) {
        this.h9 = b2;
        this.char(true);
        this.setVisible(false);
    }

    public void a(c c2) {
        int n2 = this.getWidth();
        int n3 = this.getHeight();
        c2.a(0, 0, n2, n3 - 26, -1090519040);
        e.if(c2, 0, 0, n2, n3 - 26);
        e.a(c2, 0, n3 - 26, n2);
        c2.if(96, 65, 122, 18, -9944012);
        super.a(c2);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        actionEvent.getActionCommand();
        this.setVisible(false);
        if (this.h9.j() != null) {
            this.h9.j().requestFocus();
        } else {
            this.ia.transferFocus();
        }
        ActionListener actionListener = this.id;
        this.id = null;
        if (actionListener != null) {
            actionListener.actionPerformed(actionEvent);
        }
    }

    public String cK() {
        return this.ia.D();
    }

    public void cL() {
        this.setBounds(168, 142, 286, 146);
        this.ic = new s();
        this.ic.setBounds(8, 16, 270, 96);
        this.add(this.ic);
        int[] nArray = new int[]{this.getWidth() / 2 - 44 - 4, this.getWidth() / 2 + 4};
        int n2 = 0;
        do {
            al al2 = new al();
            al2.char(n2 == 0 ? "OK" : "");
            al2.try(this);
            al2.m(2);
            al2.setBounds(nArray[n2], this.getHeight() - 25, 44, 19);
            al2.else(n2 == 0 ? "\u786e \u5b9a" : "\u53d6 \u6d88");
            this.add(al2);
            if (n2 != 0) continue;
            this.ib = al2;
        } while (++n2 < 2);
        this.ia = new n();
        this.ia.setBounds(97, 66, 120, 16);
        this.ia.else(50);
        this.ia.goto(-1);
        this.ia.char(-1);
        this.ia.for(this);
        this.add(this.ia);
    }

    public void a(String string, String string2, ActionListener actionListener) {
        this.a(string, '\u0000', string2, actionListener);
    }

    public void a(String string, char c2, String string2, ActionListener actionListener) {
        this.ib.char(string2);
        this.ia.do(string2);
        this.id = actionListener;
        o o2 = new o(string, 270, -1, 24);
        this.ic.if(o2);
        this.ia.if("");
        this.ia.if(c2);
        this.new();
        this.setVisible(true);
        this.ia.requestFocus();
    }
}

