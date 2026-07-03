/*
 * Decompiled with CFR 0.152.
 */
package a.b;

import a.a.e;
import a.a.h;
import a.b.c;
import a.b.w;
import java.awt.image.IndexColorModel;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ac
extends w {
    public void if(e e2) {
        super.if(e2);
        this.a = (short)e2.j();
    }

    protected void a(short[] sArray, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        this.a(sArray, n2, n3, n4, n5, n6, n7, n8, (short)this.a);
    }

    protected void int(short[] sArray, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        short[][] sArray2 = c.byte;
        short[][] sArray3 = c.case;
        short[][] sArray4 = c.b;
        short s2 = (short)(sArray2[this.a][n9] | sArray3[this.a][n9] | sArray4[this.a][n9]);
        this.a(sArray, n2, n3, n4, n5, n6, n7, n8, s2);
    }

    public void a(int n2, byte[] byArray, int n3, IndexColorModel indexColorModel) {
        byte by = (byte)indexColorModel.getTransparentPixel();
        this.a(n2, byArray, n3, by);
    }

    public void a(int n2, int[] nArray, int n3, int n4) {
        h h2 = new h(8);
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        while (n5 < this.int) {
            n7 = nArray[n3 + n5] == n4 ? 8192 : 4096;
            if (n7 == 8192) {
                n6 = n5 + 1;
                while (n6 < this.int) {
                    if (nArray[n3 + n6] != n4) break;
                    ++n6;
                }
                if (n6 >= this.int) break;
                h2.if(new Short((short)(n7 |= n6 - n5)));
            } else {
                n6 = n5 + 1;
                while (n6 < this.int) {
                    if (nArray[n3 + n6] == n4) break;
                    ++n6;
                }
                n8 = n6 - n5;
                h2.if(new Short((short)(n7 |= n8)));
            }
            n5 = n6;
        }
        if (h2.int()) {
            return;
        }
        this.for[n2] = new short[h2.for()];
        int n9 = 0;
        while (n9 < h2.for()) {
            this.for[n2][n9] = (Short)h2.if(n9);
            ++n9;
        }
    }

    public void a(int n2, byte[] byArray, int n3, byte by) {
        h h2 = new h(8);
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        while (n4 < this.int) {
            n6 = byArray[n3 + n4] == by ? 8192 : 4096;
            if (n6 == 8192) {
                n5 = n4 + 1;
                while (n5 < this.int) {
                    if (byArray[n3 + n5] != by) break;
                    ++n5;
                }
                if (n5 >= this.int) break;
                h2.if(new Short((short)(n6 |= n5 - n4)));
            } else {
                n5 = n4 + 1;
                while (n5 < this.int) {
                    if (byArray[n3 + n5] == by) break;
                    ++n5;
                }
                n7 = n5 - n4;
                h2.if(new Short((short)(n6 |= n7)));
            }
            n4 = n5;
        }
        this.for[n2] = new short[h2.for()];
        int n8 = 0;
        while (n8 < h2.for()) {
            this.for[n2][n8] = (Short)h2.if(n8);
            ++n8;
        }
    }

    protected void a(short[] sArray, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        short[][] sArray2 = c.long;
        this.a(sArray, n2, n3, n4, n5, n6, n7, n8, sArray2[this.a][31 - n9]);
    }

    public void a(e e2) {
        super.a(e2);
        e2.for(this.a);
    }

    public ac() {
    }

    public ac(int n2, int n3) {
        super(n2, n3);
    }

    public ac(int n2, int n3, short s2) {
        super(n2, n3);
        this.a = s2;
        int n4 = 0;
        while (n4 < this.for.length) {
            this.for[n4] = new short[0];
            ++n4;
        }
    }

    protected void do(short[] sArray, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
    }

    protected void for(short[] sArray, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        int n10 = 0;
        short[][] sArray2 = c.long;
        int n11 = 31 - n9;
        short s2 = sArray2[this.a][n9];
        int n12 = 0;
        int n13 = 0;
        int n14 = 0;
        int n15 = 0;
        int n16 = 0;
        int n17 = 0;
        int n18 = n6;
        int n19 = n5 + n7;
        int n20 = n6 + n8;
        short[] sArray3 = null;
        while (n18 < n20) {
            sArray3 = this.for[n18];
            n10 = n2 * n4 + n3;
            n14 = 0;
            while (n17 < n19 && n14 < sArray3.length) {
                n12 = sArray3[n14] & 0xF000;
                n13 = sArray3[n14] & 0xFFF;
                switch (n12) {
                    case 12288: {
                        n18 += n13;
                        n4 += n13;
                        break;
                    }
                    case 8192: {
                        if (n17 < n5) {
                            if (n17 + n13 > n5) {
                                n10 += n17 + n13 - n5;
                            }
                        } else {
                            n10 += n13;
                        }
                        n17 += n13;
                        break;
                    }
                    case 4096: {
                        if (n12 != 4096) break;
                        if (n17 < n5) {
                            if (n17 + n13 > n5) {
                                n15 = n5;
                                n16 = n17 + n13;
                                if (n16 > n19) {
                                    n16 = n19;
                                }
                                while (n15 < n16) {
                                    sArray[n10] = (short)(sArray2[sArray[n10]][n11] + s2);
                                    ++n10;
                                    ++n15;
                                }
                            }
                        } else if (n17 >= n5 && n17 < n19) {
                            n15 = n17;
                            n16 = n17 + n13;
                            if (n16 > n19) {
                                n16 = n19;
                            }
                            while (n15 < n16) {
                                sArray[n10] = (short)(sArray2[sArray[n10]][n11] + s2);
                                ++n10;
                                ++n15;
                            }
                        }
                        n17 += n13;
                    }
                }
                ++n14;
            }
            ++n18;
            n17 = 0;
            ++n4;
        }
    }

    public int for() {
        return 3;
    }

    protected void if(short[] sArray, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        short[] sArray2 = c.d;
        this.a(sArray, n2, n3, n4, n5, n6, n7, n8, sArray2[this.a]);
    }

    protected void do(short[] sArray, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
    }

    private void a(short[] sArray, int n2, int n3, int n4, int n5, int n6, int n7, int n8, short s2) {
        int n9 = 0;
        int n10 = 0;
        int n11 = 0;
        int n12 = 0;
        int n13 = 0;
        int n14 = 0;
        int n15 = 0;
        int n16 = n6;
        int n17 = n5 + n7;
        int n18 = n6 + n8;
        short[] sArray2 = null;
        while (n16 < n18) {
            sArray2 = this.for[n16];
            n9 = n2 * n4 + n3;
            n12 = 0;
            while (n15 < n17 && n12 < sArray2.length) {
                n10 = sArray2[n12] & 0xF000;
                n11 = sArray2[n12] & 0xFFF;
                switch (n10) {
                    case 12288: {
                        n16 += n11;
                        n4 += n11;
                        break;
                    }
                    case 8192: {
                        if (n15 < n5) {
                            if (n15 + n11 > n5) {
                                n9 += n15 + n11 - n5;
                            }
                        } else {
                            n9 += n11;
                        }
                        n15 += n11;
                        break;
                    }
                    case 4096: {
                        if (n15 < n5) {
                            if (n15 + n11 > n5) {
                                n13 = n5;
                                n14 = n15 + n11;
                                if (n14 > n17) {
                                    n14 = n17;
                                }
                                while (n13 < n14) {
                                    sArray[n9++] = s2;
                                    ++n13;
                                }
                            }
                        } else if (n15 >= n5 && n15 < n17) {
                            n13 = n15;
                            n14 = n15 + n11;
                            if (n14 > n17) {
                                n14 = n17;
                            }
                            while (n13 < n14) {
                                sArray[n9++] = s2;
                                ++n13;
                            }
                        }
                        n15 += n11;
                        break;
                    }
                }
                ++n12;
            }
            ++n16;
            n15 = 0;
            ++n4;
        }
    }

    public short a(int n2, int n3) {
        short[] sArray = this.for[n3];
        if (sArray == null) {
            return -1;
        }
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        while (n7 < sArray.length) {
            n5 = sArray[n7] & 0xF000;
            n4 = sArray[n7] & 0xFFF;
            if (n5 == 4096) {
                if (n6 + n4 >= n2) {
                    return (short)this.a;
                }
            } else if (n5 == 12288) {
                return -1;
            }
            if ((n6 += n4) > n2) {
                return -1;
            }
            ++n7;
        }
        return -1;
    }
}

