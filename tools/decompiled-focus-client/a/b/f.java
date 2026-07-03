/*
 * Decompiled with CFR 0.152.
 */
package a.b;

import a.a.e;
import a.b.af;
import a.b.c;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class f
extends af {
    public void if(e e2) {
        super.if(e2);
        this.for = new short[this.if][this.int];
        int n2 = 0;
        while (n2 < this.if) {
            int n3 = 0;
            while (n3 < this.int) {
                this.for[n2][n3] = (short)e2.j();
                ++n3;
            }
            ++n2;
        }
    }

    protected void a(short[] sArray, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        int n9 = n4 * n2 + n3;
        int n10 = n2 - n7;
        int n11 = n6 + n8;
        int n12 = n6;
        while (n12 < n11) {
            System.arraycopy(this.for[n12], n5, sArray, n9, n7);
            n9 += n7;
            ++n12;
            n9 += n10;
        }
    }

    protected void int(short[] sArray, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        int n10 = n4 * n2 + n3;
        int n11 = n2 - n7;
        short[][] sArray2 = c.byte;
        short[][] sArray3 = c.case;
        short[][] sArray4 = c.b;
        int n12 = n5 + n7;
        int n13 = n6 + n8;
        short s2 = 0;
        int n14 = n6;
        while (n14 < n13) {
            int n15 = n5;
            while (n15 < n12) {
                s2 = this.for[n14][n15];
                sArray[n10++] = (short)(sArray2[s2][n9] | sArray3[s2][n9] | sArray4[s2][n9]);
                ++n15;
            }
            ++n14;
            n10 += n11;
        }
    }

    protected void a(short[] sArray, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        int n10 = n4 * n2 + n3;
        int n11 = n2 - n7;
        short[][] sArray2 = c.long;
        int n12 = n5 + n7;
        int n13 = n6 + n8;
        n9 = 31 - n9;
        int n14 = n6;
        while (n14 < n13) {
            int n15 = n5;
            while (n15 < n12) {
                sArray[n10] = sArray2[this.for[n14][n15]][n9];
                ++n15;
                ++n10;
            }
            ++n14;
            n10 += n11;
        }
    }

    public void if(int n2, int[] nArray, int n3) {
        short[] sArray = this.for[n2];
        int n4 = n3;
        int n5 = 0;
        while (n5 < sArray.length) {
            nArray[n4++] = c.a(sArray[n5]);
            ++n5;
        }
    }

    public void a(int n2, int[] nArray, int n3) {
        int n4 = 0;
        while (n4 < this.int) {
            this.for[n2][n4] = c.do(nArray[n3++]);
            ++n4;
        }
        ++this.do;
        if (this.new != null) {
            this.new.a(this, n2, 1);
        }
        if (this.do >= this.if) {
            this.new = null;
        }
    }

    public void a(e e2) {
        super.a(e2);
        int n2 = 0;
        while (n2 < this.if) {
            int n3 = 0;
            while (n3 < this.int) {
                e2.for(this.for[n2][n3]);
                ++n3;
            }
            ++n2;
        }
    }

    public f() {
    }

    public f(int n2, int n3) {
        this.int = n2;
        this.if = n3;
        this.for = new short[n3][n2];
    }

    public void do(short[] sArray, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        int n10 = n9 >> 27 & 0x1F;
        int n11 = n9 >> 19 & 0x1F;
        int n12 = n9 >> 11 & 0x1F;
        int n13 = n9 >> 3 & 0x1F;
        if (n10 <= 0) {
            return;
        }
        int n14 = n4 * n2 + n3;
        int n15 = n2 - n7;
        int n16 = n6 + n8;
        int n17 = n5 + n7;
        int n18 = 0;
        int n19 = 0;
        int n20 = 0;
        int n21 = 0;
        int n22 = n6;
        while (n22 < n16) {
            int n23 = n5;
            while (n23 < n17) {
                n18 = this.for[n22][n23] & 0x1F;
                n19 = n18 * n11 >> 5;
                n20 = n18 * n12 >> 5;
                n21 = n18 * n13 >> 5;
                n9 = sArray[n14];
                n19 = c.byte[n9][n19];
                n20 = c.case[n9][n20];
                n21 = c.b[n9][n21];
                sArray[n14] = (short)(n19 | n20 | n21);
                ++n23;
                ++n14;
            }
            ++n22;
            n14 += n15;
        }
    }

    protected void for(short[] sArray, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        int n10 = n4 * n2 + n3;
        int n11 = n2 - n7;
        short[][] sArray2 = c.long;
        int n12 = n5 + n7;
        int n13 = n6 + n8;
        int n14 = 31 - n9;
        int n15 = n6;
        while (n15 < n13) {
            int n16 = n5;
            while (n16 < n12) {
                sArray[n10] = (short)(sArray2[sArray[n10]][n14] + sArray2[this.for[n15][n16]][n9]);
                ++n16;
                ++n10;
            }
            ++n15;
            n10 += n11;
        }
    }

    public int for() {
        return 1;
    }

    protected void if(short[] sArray, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        int n9 = n4 * n2 + n3;
        int n10 = n2 - n7;
        short[] sArray2 = c.d;
        int n11 = n5 + n7;
        int n12 = n6 + n8;
        int n13 = n6;
        while (n13 < n12) {
            int n14 = n5;
            while (n14 < n11) {
                sArray[n9] = sArray2[this.for[n13][n14]];
                ++n14;
                ++n9;
            }
            ++n13;
            n9 += n10;
        }
    }

    protected void do(short[] sArray, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        int n9 = n6 + n8;
        int n10 = n5 + n7;
        int n11 = 0;
        int n12 = 0;
        int n13 = 0;
        short s2 = 0;
        int n14 = n4 * n2 + n3;
        int n15 = n2 - n7;
        int n16 = n6;
        while (n16 < n9) {
            int n17 = n5;
            while (n17 < n10) {
                n11 = this.for[n16][n17] >> 10 & 0x1F;
                n12 = this.for[n16][n17] >> 5 & 0x1F;
                n13 = this.for[n16][n17] & 0x1F;
                s2 = sArray[n14];
                n11 = c.byte[s2][n11];
                n12 = c.case[s2][n12];
                n13 = c.b[s2][n13];
                sArray[n14] = (short)(n11 | n12 | n13);
                ++n17;
                ++n14;
            }
            ++n16;
            n14 += n15;
        }
    }

    public short a(int n2, int n3) {
        return this.for[n3][n2];
    }

    public void a(int n2, int n3, short s2) {
        this.for[n3][n2] = s2;
    }

    public boolean if() {
        return true;
    }
}

