/*
 * Decompiled with CFR 0.152.
 */
package a.b;

import a.b.b;
import a.b.s;
import java.awt.AWTEventMulticaster;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class j
extends s {
    private b v;
    private b A;
    private b C;
    private b z;
    private boolean B;
    private boolean E;
    private ActionListener w;
    private String D = "";

    public b l() {
        return this.C;
    }

    public void do(b b2) {
        this.C = b2;
    }

    public boolean h() {
        return this.E;
    }

    public void int(boolean bl) {
        if (this.B == bl) {
            return;
        }
        this.B = bl;
        if (bl) {
            if (this.z != null) {
                this.if(this.z);
            }
        } else {
            this.if(this.v);
        }
    }

    public String m() {
        return this.D;
    }

    public void a(String string) {
        this.D = string;
    }

    public j() {
        this.enableEvents(48L);
    }

    protected void processMouseEvent(MouseEvent mouseEvent) {
        if (mouseEvent.getID() == 504) {
            if (this.C != null && !this.B) {
                this.if(this.C);
            }
        } else if (mouseEvent.getID() == 505) {
            if (!this.B) {
                this.if(this.v);
            }
        } else if (mouseEvent.getID() == 501) {
            if (this.E) {
                boolean bl = this.B = !this.B;
                if (this.B) {
                    this.if(this.z);
                } else {
                    this.if(this.v);
                }
            } else if (this.A != null) {
                this.if(this.A);
            }
        } else if (mouseEvent.getID() == 502) {
            if (this.contains(mouseEvent.getX(), mouseEvent.getY())) {
                if (!this.B) {
                    if (this.C != null) {
                        this.if(this.C);
                    } else {
                        this.if(this.v);
                    }
                }
                if (this.w != null) {
                    ActionEvent actionEvent = new ActionEvent(this, 1001, this.D);
                    this.w.actionPerformed(actionEvent);
                }
            } else if (!this.B) {
                this.if(this.v);
            }
        }
        super.processMouseEvent(mouseEvent);
    }

    public boolean j() {
        return this.B;
    }

    public void if(ActionListener actionListener) {
        this.w = AWTEventMulticaster.remove(this.w, actionListener);
    }

    public b i() {
        return this.v;
    }

    public void for(b b2) {
        this.v = b2;
        if (this.void() == null) {
            this.if(this.v);
        }
    }

    public void a(ActionListener actionListener) {
        this.w = AWTEventMulticaster.add(this.w, actionListener);
    }

    public b g() {
        return this.A;
    }

    public void int(b b2) {
        this.A = b2;
    }

    public b k() {
        return this.z;
    }

    public void new(b b2) {
        b b3 = this.z;
        this.z = b2;
        if (this.j() && b3 != b2) {
            this.repaint();
        }
    }

    public void for(boolean bl) {
        this.E = bl;
    }
}

