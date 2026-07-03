/*
 * Decompiled with CFR 0.152.
 */
package b.a.e;

import a.a.e;
import b.a.b;
import b.a.e.j;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class u
extends b {
    public int[] jW = new int[3];
    public int[] jY = new int[3];
    public int[] jV = new int[5];
    public j[] jZ = new j[5];
    public int jX;
    public transient int j2;
    public transient int j0;
    public transient int j1;

    public void a(e e2) {
        super.a(e2);
        this.jX = e2.i();
        int n2 = this.jZ.length;
        int n3 = 0;
        int n4 = 0;
        while (n4 < n2) {
            this.jV[n4] = e2.i();
            if (this.jV[n4] != 0) {
                ++n3;
            }
            ++n4;
        }
        n4 = 0;
        while (n4 < n2) {
            if (this.jV[n4] != 0) {
                j j2 = j.h(8);
                j2.a(e2);
                this.jZ[n4] = j2;
            } else {
                e2.i();
                this.jZ[n4] = null;
            }
            ++n4;
        }
    }

    public void if(e e2) {
        super.if(e2);
        e2.char(this.jX);
        int n2 = this.jZ.length;
        int n3 = 0;
        while (n3 < n2) {
            e2.char(this.jV[n3]);
            ++n3;
        }
        n3 = 0;
        while (n3 < n2) {
            if (this.jZ[n3] != null) {
                this.jZ[n3].if(e2);
            } else {
                e2.char(0);
            }
            ++n3;
        }
    }

    public boolean a(String string, String string2) {
        if (string.equals("targetGoods")) {
            if (string2.length() > 1) {
                this.jW[this.j2++] = Integer.parseInt(string2);
            }
            return true;
        }
        if (string.equals("rates")) {
            if (string2.length() > 1) {
                this.jY[this.j0++] = Integer.parseInt(string2);
            }
            return true;
        }
        if (string.equals("materials")) {
            if (string2.length() > 1) {
                this.jV[this.j1++] = Integer.parseInt(string2);
            }
            return true;
        }
        return super.a(string, string2);
    }

    public boolean if(j[] jArray) {
        if (this.a(jArray) != this.j1) {
            return false;
        }
        boolean bl = true;
        int n2 = 0;
        while (n2 < this.j1) {
            bl &= this.a(jArray, this.jV[n2]) >= 1;
            ++n2;
        }
        return bl;
    }

    private int a(j[] jArray) {
        int n2 = 0;
        int n3 = 0;
        while (n3 < jArray.length) {
            if (jArray[n3] != null) {
                ++n2;
            }
            ++n3;
        }
        return n2;
    }

    private int a(j[] jArray, int n2) {
        int n3 = 0;
        int n4 = 0;
        while (n4 < jArray.length) {
            if (jArray[n4] != null && jArray[n4].if == n2) {
                ++n3;
            }
            ++n4;
        }
        return n3;
    }

    public void do(b b2) {
        super.do(b2);
        u u2 = (u)b2;
        System.arraycopy(u2.jW, 0, this.jW, 0, u2.jW.length);
        System.arraycopy(u2.jZ, 0, this.jZ, 0, u2.jZ.length);
        System.arraycopy(u2.jY, 0, this.jY, 0, u2.jW.length);
        System.arraycopy(u2.jV, 0, this.jV, 0, u2.jV.length);
        this.jX = u2.jX;
    }
}

