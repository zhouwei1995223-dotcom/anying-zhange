/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.ab;
import a.b.ae;
import a.b.b;
import a.b.s;
import b.a.c.b.e;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
class z
extends s
implements AdjustmentListener {
    private ae cF;
    private s cH;
    private boolean cG = true;
    private s[] cI = new s[100];
    private int cJ;

    public ae be() {
        return this.cF;
    }

    public s bf() {
        return this.cH;
    }

    public void bg() {
        this.cH.removeAll();
        this.cH.setBounds(0, 0, this.getWidth() - 16, 0);
        this.cF.setValue(0);
        this.cF.setMaximum(0);
        int n2 = 0;
        while (n2 < this.cJ) {
            this.cI[n2] = null;
            ++n2;
        }
        this.cJ = 0;
    }

    public void adjustmentValueChanged(AdjustmentEvent adjustmentEvent) {
        int n2 = this.cF.getValue();
        this.cH.setLocation(0, -n2);
    }

    public z() {
        this.cF = new ae(1);
        b[] bArray = new b[]{new ab(e.aZ, 194, 42, 16, 16), new ab(e.aZ, 210, 42, 16, 16), new ab(e.aZ, 226, 42, 16, 16)};
        this.cF.if(bArray);
        bArray[0] = new ab(e.aZ, 194, 72, 16, 16);
        bArray[1] = new ab(e.aZ, 210, 72, 16, 16);
        bArray[2] = new ab(e.aZ, 226, 72, 16, 16);
        this.cF.a(bArray);
        bArray[0] = new ab(e.aZ, 159, 45, 14, 40);
        bArray[1] = null;
        bArray[2] = new ab(e.aZ, 175, 45, 14, 40);
        this.cF.do(bArray);
        this.cF.addAdjustmentListener(this);
        this.cF.setMaximum(0);
        this.add(this.cF);
        this.cH = new s();
        this.add(this.cH);
    }

    public s case(String string) {
        s s2 = null;
        int n2 = 0;
        while (n2 < this.cJ) {
            if (string.equals(this.cI[n2].getName())) {
                s2 = this.cI[n2];
                int n3 = n2 + 1;
                while (n3 < this.cJ) {
                    this.cI[n3].setLocation(this.cI[n3].getX(), this.cI[n3].getY() - s2.getHeight());
                    this.cI[n3 - 1] = this.cI[n3];
                    ++n3;
                }
                this.cH.setSize(this.cH.getWidth(), this.cH.getHeight() - s2.getHeight());
                this.cH.remove(s2);
                if (this.cH.getHeight() > this.getHeight()) {
                    this.cF.setMaximum(this.cH.getHeight() - this.getHeight());
                    if (this.cG) {
                        this.cF.setValue(this.cF.getMaximum());
                        this.cH.setLocation(0, -this.cF.getValue());
                    }
                }
                this.cF.setValue(0);
                this.cJ += -1;
                break;
            }
            ++n2;
        }
        return s2;
    }

    public int bd() {
        return this.cJ;
    }

    public void int(s s2) {
        this.a(s2, 0, 0, 0);
    }

    public void a(s s2, int n2, int n3, int n4) {
        int n5 = this.cH.getWidth() - n2 - n3;
        int n6 = this.cH.getHeight() + n4;
        s2.setBounds(n2, n6, n5, s2.getHeight());
        this.cH.setSize(this.cH.getWidth(), s2.getY() + s2.getHeight());
        this.cH.add(s2);
        this.cF.setValue(0);
        if (this.cH.getHeight() > this.getHeight()) {
            this.cF.setMaximum(this.cH.getHeight() - this.getHeight());
            if (this.cG) {
                this.cF.setValue(this.cF.getMaximum());
                this.cH.setLocation(0, -this.cF.getValue());
            }
        }
        if (this.cI.length <= this.cJ) {
            s[] sArray = new s[this.cJ * 3 / 2];
            System.arraycopy(this.cI, 0, sArray, 0, this.cJ);
            this.cI = sArray;
        }
        this.cI[this.cJ++] = s2;
    }

    public void setBounds(int n2, int n3, int n4, int n5) {
        super.setBounds(n2, n3, n4, n5);
        this.cH.setBounds(0, 0, n4 - 16, 0);
        this.cF.setBounds(n4 - 16, 0, 16, n5);
    }

    public void byte(boolean bl) {
        this.cG = bl;
    }
}

