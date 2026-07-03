/*
 * Decompiled with CFR 0.152.
 */
package a.b;

import a.b.s;
import java.awt.Point;
import java.awt.event.MouseEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class z
extends s {
    private boolean eT;
    private boolean eU;
    private Point eS = new Point();

    protected void processMouseEvent(MouseEvent mouseEvent) {
        if (this.eT && this.isEnabled()) {
            if (mouseEvent.getID() == 501) {
                this.eU = true;
                this.eS.x = mouseEvent.getX();
                this.eS.y = mouseEvent.getY();
                this.new();
            } else if (mouseEvent.getID() == 502) {
                this.eU = false;
            }
        }
        super.processMouseEvent(mouseEvent);
    }

    protected void processMouseMotionEvent(MouseEvent mouseEvent) {
        if (this.eT && this.eU && this.isEnabled()) {
            int n2 = mouseEvent.getX();
            int n3 = mouseEvent.getY();
            this.setLocation(this.a.x + n2 - this.eS.x, this.a.y + n3 - this.eS.y);
        }
        super.processMouseMotionEvent(mouseEvent);
    }

    public void char(boolean bl) {
        this.eT = bl;
        if (bl) {
            this.enableEvents(16L);
            this.enableEvents(32L);
        }
    }

    public boolean bR() {
        return this.eT;
    }
}

