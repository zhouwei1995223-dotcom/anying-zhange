/*
 * Decompiled with CFR 0.152.
 */
package a.b;

import a.a.d;
import a.b.ab;
import a.b.ae;
import a.b.b;
import a.b.s;
import a.b.v;
import java.awt.Component;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class k
extends s
implements AdjustmentListener {
    private s I = new s();
    private ae K = new ae(1, true, true);
    private boolean N;
    private int G;
    private d P = new d();
    private int M;
    private int J;
    private int O;
    private int F;
    private int H;
    private boolean L;

    public ae u() {
        return this.K;
    }

    private void if(s s2) {
    }

    protected final void addImpl(Component component, Object object, int n2) {
    }

    public void B() {
        int n2 = this.K.getMaximum();
        this.K.setValue(n2);
        int n3 = ((s)this.I.getParent()).getHeight();
        int n4 = this.I.getHeight();
        if (n4 > n3) {
            this.I.setLocation(0, n3 - n4);
        }
    }

    public int t() {
        return this.H;
    }

    public void adjustmentValueChanged(AdjustmentEvent adjustmentEvent) {
        int n2 = adjustmentEvent.getValue();
        if (this.L) {
            int n3;
            int n4 = this.I.getY();
            if (n4 != (n3 = -n2 / this.M * this.M)) {
                this.I.setLocation(0, n3);
            }
        } else {
            this.I.setLocation(0, -n2);
        }
    }

    public boolean o() {
        return this.L;
    }

    public s try(int n2) {
        if (n2 < 0 || n2 >= this.P.for()) {
            return null;
        }
        return (s)this.P.if(n2);
    }

    public k() {
        s s2 = new s();
        s2.add(this.I);
        super.addImpl(s2, null, 0);
        super.addImpl(this.K, null, 1);
        this.r();
    }

    public int x() {
        return this.F;
    }

    public s A() {
        if (!this.N) {
            return null;
        }
        return null;
    }

    public void do(s s2) {
        this.P.do(s2);
        this.n();
    }

    public void new(int n2) {
        if (n2 >= 0 || n2 < this.P.for()) {
            this.P.a(n2);
        }
        this.n();
    }

    public void a(s s2) {
        this.P.if(s2);
        this.n();
    }

    public int z() {
        return this.getWidth() - this.K.getWidth() - this.J - this.O;
    }

    public int w() {
        return this.G;
    }

    public void v() {
        this.I.setLocation(0, 0);
        this.K.setValue(0);
    }

    public int p() {
        return this.M;
    }

    public void byte(int n2) {
        if (this.M == n2) {
            return;
        }
        this.M = n2;
        this.n();
    }

    public void y() {
        this.P.a();
        this.I.removeAll();
        this.K.setValue(0);
        this.repaint();
    }

    private void r() {
        b[] bArray = new ab[3];
        bArray[0] = new ab(v.if.for("image/ui/buttons/bar0.img"));
        this.K.setMaximum(0);
        this.K.do(bArray);
        this.K.addAdjustmentListener(this);
        bArray[0] = new ab(v.if.for("image/ui/buttons/add0.img"));
        bArray[1] = new ab(v.if.for("image/ui/buttons/add1.img"));
        bArray[2] = new ab(v.if.for("image/ui/buttons/add2.img"));
        this.K.a(bArray);
        bArray[0] = new ab(v.if.for("image/ui/buttons/sub0.img"));
        bArray[1] = new ab(v.if.for("image/ui/buttons/sub1.img"));
        bArray[2] = new ab(v.if.for("image/ui/buttons/sub2.img"));
        this.K.if(bArray);
    }

    public void setBounds(int n2, int n3, int n4, int n5) {
        super.setBounds(n2, n3, n4, n5);
        this.K.setBounds(n4 - 21 - this.O, this.F, 21, n5 - this.F - this.H);
        n4 = this.getWidth() - this.K.getWidth() - this.J - this.O;
        n5 = this.getHeight() - this.F - this.H;
        s s2 = (s)this.I.getParent();
        s2.setBounds(this.J, this.F, n4, n5);
        n5 = this.I.getHeight();
        if (n5 > s2.getHeight()) {
            int n6 = n5 - s2.getHeight();
            this.K.setMaximum(n6);
        }
    }

    public int q() {
        return this.J;
    }

    public int s() {
        return this.O;
    }

    public void if(int n2, int n3, int n4, int n5) {
        this.J = n2;
        this.O = n3;
        this.F = n4;
        this.H = n5;
    }

    public void new(boolean bl) {
        this.L = bl;
    }

    private void n() {
        this.I.removeAll();
        int n2 = this.getWidth() - this.K.getWidth() - this.J - this.O;
        int n3 = this.getHeight() - this.F - this.H;
        this.I.getParent().setBounds(this.J, this.F, n2, n3);
        int n4 = 0;
        int n5 = 0;
        d.a a10 = this.P.try();
        while (a10 != null) {
            s s2 = (s)a10.a();
            s2.setBounds(n4, n5, n2, this.M);
            this.I.add(s2);
            a10 = a10.if();
            n5 += this.M;
        }
        this.G = -1;
        this.K.setMinimum(0);
        this.K.setValue(0);
        if (n5 > n3) {
            this.K.setMaximum(n5 - n3);
        } else {
            this.K.setMaximum(0);
        }
        this.K.setUnitIncrement(this.M);
        this.K.setBlockIncrement(this.M * 5);
        this.I.setBounds(0, 0, n2, n5);
    }
}

