/*
 * Decompiled with CFR 0.152.
 */
package a.b;

import a.b.b;
import a.b.j;
import a.b.s;
import java.awt.AWTEventMulticaster;
import java.awt.Adjustable;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ae
extends s
implements Adjustable,
MouseMotionListener,
MouseListener {
    private int az;
    private int au = 5;
    private int ax = 1;
    private int aq = 100;
    private int ar = 0;
    private int as;
    private j at;
    private j av;
    private j aw;
    private Point aA = new Point();
    private AdjustmentListener ay;

    private void void(int n2) {
        if (this.aw == null || this.aq <= this.ar) {
            return;
        }
        if (this.az == 0) {
            this.aw.setLocation(n2 * (this.getWidth() - (this.av != null ? this.av.getWidth() : 0) - (this.at != null ? this.at.getWidth() : 0) - this.aw.getWidth()) / (this.aq - this.ar) + (this.av != null ? this.av.getWidth() : 0), 0);
        } else {
            this.aw.setLocation(0, n2 * (this.getHeight() - (this.av != null ? this.av.getHeight() : 0) - (this.at != null ? this.at.getHeight() : 0) - this.aw.getHeight()) / (this.aq - this.ar) + (this.av != null ? this.av.getHeight() : 0));
        }
    }

    protected final void addImpl(Component component, Object object, int n2) {
    }

    public void mouseReleased(MouseEvent mouseEvent) {
    }

    public void a(b[] bArray) {
        if (this.at != null) {
            this.at.for(bArray[0]);
            this.at.do(bArray[1]);
            this.at.int(bArray[2]);
            this.at.setSize(bArray[0].a(), bArray[0].if());
        }
    }

    public void do(b[] bArray) {
        if (this.aw != null) {
            this.aw.for(bArray[0]);
            this.aw.do(bArray[1]);
            this.aw.int(bArray[2]);
            this.aw.setSize(bArray[0].a(), bArray[0].if());
        }
    }

    public void mouseEntered(MouseEvent mouseEvent) {
    }

    public void setMaximum(int n2) {
        if (n2 < this.ar) {
            throw new IllegalArgumentException("invalid maxmum:" + n2);
        }
        this.aq = n2;
    }

    public int getMaximum() {
        return this.aq;
    }

    public void mouseExited(MouseEvent mouseEvent) {
    }

    public void if(b[] bArray) {
        if (this.av != null) {
            this.av.for(bArray[0]);
            this.av.do(bArray[1]);
            this.av.int(bArray[2]);
            this.av.setSize(bArray[0].a(), bArray[0].if());
        }
    }

    public void setBounds(int n2, int n3, int n4, int n5) {
        super.setBounds(n2, n3, n4, n5);
        this.S();
    }

    private void S() {
        int n2 = this.getWidth();
        int n3 = this.getHeight();
        if (this.az == 0) {
            if (this.at != null) {
                this.at.setBounds(n2 - this.at.getWidth(), 0, this.at.getWidth(), n3);
            }
            if (this.av != null) {
                this.av.setBounds(0, 0, this.av.getWidth(), n3);
            }
            if (this.aw != null) {
                this.aw.setBounds(this.av != null ? this.av.getWidth() : 0, 0, this.aw.getWidth(), n3);
            }
        } else {
            if (this.at != null) {
                this.at.setBounds(0, n3 - this.at.getHeight(), n2, this.at.getHeight());
            }
            if (this.av != null) {
                this.av.setBounds(0, 0, n2, this.av.getHeight());
            }
            if (this.aw != null) {
                this.aw.setBounds(0, this.av != null ? this.av.getHeight() : 0, n2, this.aw.getHeight());
            }
        }
    }

    public void setValue(int n2) {
        if (n2 < this.ar || n2 > this.aq) {
            throw new IllegalArgumentException("invalid value:" + n2);
        }
        this.as = n2;
        if (this.aw != null) {
            this.void(this.as);
        }
    }

    public int getValue() {
        return this.as;
    }

    public void mouseDragged(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() != this.aw) {
            return;
        }
        int n2 = mouseEvent.getX();
        int n3 = mouseEvent.getY();
        n2 -= this.aA.x;
        n3 -= this.aA.y;
        if (this.az == 0) {
            n2 = Math.max(this.av != null ? this.av.getWidth() : 0, Math.min(this.aw.getX() + n2, this.getWidth() - (this.at != null ? this.at.getWidth() : 0) - this.aw.getWidth()));
            this.aw.setLocation(n2, this.aw.getY());
        } else {
            n3 = Math.max(this.av != null ? this.av.getHeight() : 0, Math.min(this.aw.getY() + n3, this.getHeight() - (this.at != null ? this.at.getHeight() : 0) - this.aw.getHeight()));
            this.aw.setLocation(this.aw.getX(), n3);
        }
        int n4 = this.as;
        this.as = this.R();
        if (this.as != n4 && this.ay != null) {
            AdjustmentEvent adjustmentEvent = new AdjustmentEvent(this, 601, 5, this.as);
            this.ay.adjustmentValueChanged(adjustmentEvent);
        }
    }

    public void setMinimum(int n2) {
        if (n2 < 0 || n2 > this.aq) {
            throw new IllegalArgumentException("invalid minmum:" + n2);
        }
        this.ar = n2;
    }

    public int getMinimum() {
        return this.ar;
    }

    public void setUnitIncrement(int n2) {
        if (n2 <= 0) {
            throw new IllegalArgumentException("invalid unitIncrement:" + n2);
        }
        this.ax = n2;
    }

    public int getUnitIncrement() {
        return this.ax;
    }

    public void setBlockIncrement(int n2) {
        if (n2 <= 1) {
            throw new IllegalArgumentException("invalid blockIncrement:" + n2);
        }
        this.au = n2;
    }

    public int getBlockIncrement() {
        return this.au;
    }

    public void mouseMoved(MouseEvent mouseEvent) {
    }

    public void mouseClicked(MouseEvent mouseEvent) {
        int n2;
        if (!(mouseEvent.getSource() instanceof j)) {
            return;
        }
        j j2 = (j)mouseEvent.getSource();
        int n3 = n2 = this.getValue();
        if (j2 == this.at) {
            n3 = Math.min(this.aq, n2 + this.ax);
        } else if (j2 == this.av) {
            n3 = Math.max(this.ar, n2 - this.ax);
        }
        if (n3 == n2) {
            return;
        }
        this.setValue(n3);
        if (this.ay != null) {
            int n4 = n3 > n2 ? 1 : 2;
            AdjustmentEvent adjustmentEvent = new AdjustmentEvent(this, 601, n4, n3);
            this.ay.adjustmentValueChanged(adjustmentEvent);
        }
    }

    public void mousePressed(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() == this.aw) {
            this.aA.setLocation(mouseEvent.getX(), mouseEvent.getY());
        } else if (mouseEvent.getSource() == this && this.aw != null) {
            int n2 = mouseEvent.getX();
            int n3 = mouseEvent.getY();
            int n4 = this.getValue();
            int n5 = 0;
            n5 = this.az == 0 ? (n2 < this.aw.getX() ? Math.max(this.ar, n4 - this.au) : Math.min(this.aq, n4 + this.au)) : (n3 < this.aw.getY() ? Math.max(this.ar, n4 - this.au) : Math.min(this.aq, n4 + this.au));
            this.setValue(n5);
            if (this.ay != null) {
                int n6 = n5 > n4 ? 4 : 3;
                AdjustmentEvent adjustmentEvent = new AdjustmentEvent(this, 601, n6, n5);
                this.ay.adjustmentValueChanged(adjustmentEvent);
            }
        }
    }

    public ae() {
        this(1);
    }

    public void removeAdjustmentListener(AdjustmentListener adjustmentListener) {
        this.ay = AWTEventMulticaster.remove(this.ay, adjustmentListener);
    }

    public ae(int n2) {
        this(n2, true, true);
    }

    public ae(int n2, boolean bl, boolean bl2) {
        if (!bl && !bl2) {
            throw new IllegalArgumentException("");
        }
        this.a(n2, bl, bl2);
    }

    public void addAdjustmentListener(AdjustmentListener adjustmentListener) {
        this.ay = AWTEventMulticaster.add(this.ay, adjustmentListener);
    }

    public void setVisibleAmount(int n2) {
    }

    public int getVisibleAmount() {
        return 0;
    }

    private void a(int n2, boolean bl, boolean bl2) {
        if (n2 != 0 && n2 != 1) {
            throw new IllegalArgumentException("unknown orientation:" + n2);
        }
        this.az = n2;
        if (bl2) {
            this.aw = new j();
            this.aw.a(24);
            this.aw.setName("barButton");
            this.aw.addMouseListener(this);
            this.aw.addMouseMotionListener(this);
            super.addImpl(this.aw, null, -1);
        }
        if (bl) {
            this.at = new j();
            this.at.setName("addButton");
            this.at.addMouseListener(this);
            super.addImpl(this.at, null, -1);
            this.av = new j();
            this.av.setName("subButton");
            this.av.addMouseListener(this);
            super.addImpl(this.av, null, -1);
        }
        this.addMouseListener(this);
    }

    private int R() {
        int n2 = 0;
        int n3 = 0;
        if (this.az == 0) {
            n2 = this.getWidth();
            int n4 = this.aw.getX();
            if (this.av != null) {
                n2 -= this.av.getWidth();
                n4 -= this.av.getWidth();
            }
            if (this.at != null) {
                n2 -= this.at.getWidth();
            }
            n3 = n4 * (this.aq - this.ar) / (n2 -= this.aw.getWidth());
        } else {
            n2 = this.getHeight();
            int n5 = this.aw.getY();
            if (this.av != null) {
                n2 -= this.av.getHeight();
                n5 -= this.av.getHeight();
            }
            if (this.at != null) {
                n2 -= this.at.getHeight();
            }
            n3 = n5 * (this.aq - this.ar) / (n2 -= this.aw.getHeight());
        }
        return n3;
    }

    public int getOrientation() {
        return this.az;
    }
}

