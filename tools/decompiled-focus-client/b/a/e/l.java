/*
 * Decompiled with CFR 0.152.
 */
package b.a.e;

import a.a.e;
import b.a.b;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class l
extends b {
    public String iY;
    public String[] iZ;
    public int i0;
    public int iX;

    public void a(e e2) {
        super.a(e2);
        this.iX = e2.i();
        this.iY = e2.f();
        int n2 = this.iX;
        this.iZ = new String[this.iX];
        int n3 = 0;
        while (n3 < n2) {
            this.iZ[n3] = e2.f();
            ++n3;
        }
    }

    public void if(e e2) {
        super.if(e2);
        e2.char(this.iX);
        e2.do(this.iY);
        int n2 = this.iZ.length;
        int n3 = 0;
        while (n3 < n2) {
            e2.do(this.iZ[n3]);
            ++n3;
        }
    }

    public l(String string, String[] stringArray, int n2, int n3, int n4) {
        this.iY = string;
        this.iZ = stringArray;
        this.i0 = n2;
        if (n4 == 1) {
            this.a = "\u6807\u51c6\u7b54\u9898";
        } else if (n4 == 2) {
            this.a = "\u6311\u6218\u7b54\u9898";
        }
        this.iX = n3;
    }

    public l() {
    }

    public void do(b b2) {
        super.do(b2);
        l l2 = (l)b2;
        this.iY = l2.iY;
        this.iZ = l2.iZ;
        this.i0 = l2.i0;
        this.iX = l2.iX;
    }
}

