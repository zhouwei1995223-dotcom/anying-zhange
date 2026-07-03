/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.z;
import b.a.c.b;
import b.a.c.b.e;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class a4
extends z
implements ActionListener {
    private b kE;
    private String kG;
    private int kF;

    public void else(a.a.e e2) {
        this.kF = e2.for();
        int n2 = e2.j();
        this.kG = "\u516c\u4f1a\u5217\u8868[\u603b\u6570=" + n2 + ";\u7b2c" + this.kF + "\u9875]";
    }

    public a4(b b2) {
        this.kE = b2;
    }

    public void a(c c2) {
        e.a(c2, this.kG, this.getWidth(), this.getHeight());
        super.a(c2);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.equals("ok")) {
            // empty if block
        }
    }

    public void dn() {
    }

    public void dm() {
    }
}

