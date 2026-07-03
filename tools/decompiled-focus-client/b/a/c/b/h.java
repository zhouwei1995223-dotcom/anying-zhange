/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.d;
import a.b.s;
import b.a.c.b;
import b.a.c.b.e;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

class h
extends s
implements ActionListener {
    static final String[] bF = new String[]{"\u548c\u5e73\u6a21\u5f0f", "\u516c\u4f1a\u6a21\u5f0f", "PK\u6a21\u5f0f"};
    static final String[] bD = new String[]{"mode:0", "mode:1", "mode:2"};
    private int bE;
    private b bC;

    public h(b b2) {
        this.bC = b2;
        this.d(0);
    }

    public void d(int n2) {
        this.bE = n2;
        this.a(new d("\u5f53\u524d\u6218\u6597\u6a21\u5f0f\u4e3a\u3010" + bF[n2] + "\u3011"));
    }

    public void a(c c2) {
        c2.if(e.a5, 0, 0, this.bE * 24, 660, 24, 24);
    }

    protected void processMouseEvent(MouseEvent mouseEvent) {
        if (mouseEvent.getID() == 501 && mouseEvent.getModifiers() == 4) {
            this.a(bF, bD, this, 0, 0);
        }
        if (mouseEvent.getID() == 500) {
            this.bC.e().do();
        }
        super.processMouseEvent(mouseEvent);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        int n2 = string.charAt(string.length() - 1) - 48;
        this.bC.e().for(n2);
    }
}

