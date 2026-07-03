/*
 * Decompiled with CFR 0.152.
 */
package a.b;

import a.a.e;
import a.a.h;
import a.b.af;
import a.b.c;
import java.awt.image.IndexColorModel;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class w
extends af {
    protected static final int try = 4096;
    protected static final int else = 8192;
    protected static final int char = 12288;
    protected static final int case = 16384;
    protected static final int byte = 20480;

    protected void if(short[] sArray, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        n9 = c.do(n9);
        int n10 = 0;
        short[][] sArray2 = c.long;
        short s2 = 0;
        int n11 = 0;
        int n12 = 0;
        int n13 = 0;
        int n14 = 0;
        int n15 = 0;
        int n16 = 0;
        int n17 = 0;
        int n18 = 0;
        int n19 = n6;
        int n20 = n5 + n7;
        int n21 = n6 + n8;
        short[] sArray3 = null;
        while (n19 < n21) {
            sArray3 = this.for[n19];
            if (sArray3 != null) {
                n10 = n2 * n4 + n3;
                n14 = 0;
                while (n18 < n20 && n14 < sArray3.length) {
                    n12 = sArray3[n14] & 0xF000;
                    n13 = sArray3[n14] & 0xFFF;
                    switch (n12) {
                        case 12288: {
                            n19 += n13;
                            n4 += n13;
                            break;
                        }
                        case 8192: {
                            if (n18 < n5) {
                                if (n18 + n13 > n5) {
                                    n10 += n18 + n13 - n5;
                                }
                            } else {
                                n10 += n13;
                            }
                            n18 += n13;
                            break;
                        }
                        case 4096: {
                            if (n18 < n5) {
                                if (n18 + n13 > n5) {
                                    n15 = n5;
                                    n16 = n18 + n13;
                                    if (n16 > n20) {
                                        n16 = n20;
                                    }
                                    n17 = n14 + 1 + n5 - n18;
                                    while (n15 < n16) {
                                        sArray[n10++] = (short)(sArray3[n17++] & n9);
                                        ++n15;
                                    }
                                }
                            } else if (n18 >= n5 && n18 < n20) {
                                n15 = n18;
                                n16 = n18 + n13;
                                if (n16 > n20) {
                                    n16 = n20;
                                }
                                n17 = n14 + 1;
                                while (n15 < n16) {
                                    sArray[n10++] = (short)(sArray3[n17++] & n9);
                                    ++n15;
                                }
                            }
                            n14 += n13;
                            n18 += n13;
                            break;
                        }
                        case 16384: {
                            if (n18 < n5) {
                                if (n18 + n13 > n5) {
                                    n15 = n5;
                                    n16 = n18 + n13;
                                    if (n16 > n20) {
                                        n16 = n20;
                                    }
                                    n17 = n14 + (n5 - n18 << 1) + 1;
                                    while (n15 < n16) {
                                        s2 = sArray3[n17++];
                                        n11 = sArray2[sArray3[n17++]][s2] & n9;
                                        sArray[n10++] = (short)n11;
                                        ++n15;
                                    }
                                }
                            } else if (n18 >= n5 && n18 < n20) {
                                n15 = n18;
                                n16 = n18 + n13;
                                if (n16 > n20) {
                                    n16 = n20;
                                }
                                n17 = n14 + 1;
                                while (n15 < n16) {
                                    s2 = sArray3[n17++];
                                    n11 = sArray2[sArray3[n17++]][s2] & n9;
                                    sArray[n10++] = (short)n11;
                                    ++n15;
                                }
                            }
                            n14 += n13 << 1;
                            n18 += n13;
                            break;
                        }
                    }
                    ++n14;
                }
            }
            ++n19;
            n18 = 0;
            ++n4;
        }
    }

    public void if(e e2) {
        super.if(e2);
        this.for = new short[this.if][];
        int n2 = 0;
        while (n2 < this.if) {
            int n3 = e2.j();
            this.for[n2] = new short[n3];
            int n4 = 0;
            while (n4 < n3) {
                this.for[n2][n4] = (short)e2.j();
                ++n4;
            }
            ++n2;
        }
    }

    protected void a(short[] sArray, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        if (this.a == 0) {
            this.int(sArray, n2, n3, n4, n5, n6, n7, n8);
        } else {
            this.for(sArray, n2, n3, n4, n5, n6, n7, n8);
        }
    }

    protected void int(short[] sArray, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        int n10 = 0;
        short[][] sArray2 = c.long;
        short[][] sArray3 = c.byte;
        short[][] sArray4 = c.case;
        short[][] sArray5 = c.b;
        short s2 = 0;
        short s3 = 0;
        int n11 = 0;
        int n12 = 0;
        int n13 = 0;
        int n14 = 0;
        int n15 = 0;
        int n16 = 0;
        int n17 = 0;
        int n18 = n6;
        int n19 = n5 + n7;
        int n20 = n6 + n8;
        short[] sArray6 = null;
        while (n18 < n20) {
            sArray6 = this.for[n18];
            n10 = n2 * n4 + n3;
            n13 = 0;
            while (n17 < n19 && n13 < sArray6.length) {
                n11 = sArray6[n13] & 0xF000;
                n12 = sArray6[n13] & 0xFFF;
                switch (n11) {
                    case 12288: {
                        n18 += n12;
                        n4 += n12;
                        break;
                    }
                    case 8192: {
                        if (n17 < n5) {
                            if (n17 + n12 > n5) {
                                n10 += n17 + n12 - n5;
                            }
                        } else {
                            n10 += n12;
                        }
                        n17 += n12;
                        break;
                    }
                    case 4096: {
                        if (n17 < n5) {
                            if (n17 + n12 > n5) {
                                n14 = n5;
                                n15 = n17 + n12;
                                if (n15 > n19) {
                                    n15 = n19;
                                }
                                n16 = n13 + 1 + n5 - n17;
                                while (n14 < n15) {
                                    s2 = sArray6[n16++];
                                    sArray[n10++] = (short)(sArray3[s2][n9] | sArray4[s2][n9] | sArray5[s2][n9]);
                                    ++n14;
                                }
                            }
                        } else if (n17 >= n5 && n17 < n19) {
                            n14 = n17;
                            n15 = n17 + n12;
                            if (n15 > n19) {
                                n15 = n19;
                            }
                            n16 = n13 + 1;
                            while (n14 < n15) {
                                s2 = sArray6[n16++];
                                sArray[n10++] = (short)(sArray3[s2][n9] | sArray4[s2][n9] | sArray5[s2][n9]);
                                ++n14;
                            }
                        }
                        n13 += n12;
                        n17 += n12;
                        break;
                    }
                    case 16384: {
                        if (n17 < n5) {
                            if (n17 + n12 > n5) {
                                n14 = n5;
                                n15 = n17 + n12;
                                if (n15 > n19) {
                                    n15 = n19;
                                }
                                n16 = n13 + (n5 - n17 << 1) + 1;
                                while (n14 < n15) {
                                    s3 = sArray6[n16++];
                                    s2 = (short)(sArray2[sArray[n10]][31 - s3] + sArray2[sArray6[n16++]][s3]);
                                    sArray[n10++] = (short)(sArray3[s2][n9] | sArray4[s2][n9] | sArray5[s2][n9]);
                                    ++n14;
                                }
                            }
                        } else if (n17 >= n5 && n17 < n19) {
                            n14 = n17;
                            n15 = n17 + n12;
                            if (n15 > n19) {
                                n15 = n19;
                            }
                            n16 = n13 + 1;
                            while (n14 < n15) {
                                s3 = sArray6[n16++];
                                s2 = (short)(sArray2[sArray[n10]][31 - s3] + sArray2[sArray6[n16++]][s3]);
                                sArray[n10++] = (short)(sArray3[s2][n9] | sArray4[s2][n9] | sArray5[s2][n9]);
                                ++n14;
                            }
                        }
                        n13 += n12 << 1;
                        n17 += n12;
                        break;
                    }
                }
                ++n13;
            }
            ++n18;
            n17 = 0;
            ++n4;
        }
    }

    public void if(int n2, int[] nArray, int n3) {
        short[] sArray = this.for[n2];
        int n4 = 0;
        int n5 = 0;
        int n6 = n3;
        int n7 = 0;
        while (n7 < sArray.length) {
            int n8;
            int n9;
            n5 = sArray[n7] & 0xF000;
            n4 = sArray[n7] & 0xFFF;
            if (n5 == 8192) {
                n6 += n4;
            } else if (n5 == 4096) {
                n9 = n7 + 1;
                n8 = 0;
                while (n8 < n4) {
                    nArray[n6++] = c.a(sArray[n9++]);
                    ++n8;
                }
                n7 += n4;
            } else {
                if (n5 == 12288) break;
                if (n5 == 16384) {
                    n9 = n7 + 1;
                    n8 = 0;
                    while (n8 < n4) {
                        nArray[n6++] = sArray[n9] * 8 << 24 & c.a(sArray[n9 + 1]);
                        ++n8;
                        n9 += 2;
                    }
                    n7 += n4 * 2;
                }
            }
            ++n7;
        }
    }

    public void a(int n2, int[] nArray, int n3) {
        int n4;
        h h2 = new h(this.int);
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        while (n6 < this.int) {
            int n9;
            n4 = nArray[n5 + n3] >> 24 & 0xFF;
            n7 = n4 < 8 ? 8192 : (n4 < 248 ? 16384 : 4096);
            if (n7 == 8192) {
                n6 = n5 + 1;
                while (n6 < this.int) {
                    n4 = nArray[n6 + n3] >> 24 & 0xFF;
                    if (n4 >= 8) break;
                    ++n6;
                }
                if (n6 >= this.int) break;
                h2.if(new Short((short)(n7 |= n6 - n5)));
            } else if (n7 == 4096) {
                n6 = n5 + 1;
                while (n6 < this.int) {
                    n4 = nArray[n6 + n3] >> 24 & 0xFF;
                    if (n4 < 248) break;
                    ++n6;
                }
                n8 = n6 - n5;
                h2.if(new Short((short)(n7 |= n8)));
                n9 = n5;
                while (n9 < n6) {
                    h2.if(new Short(c.do(nArray[n9 + n3])));
                    ++n9;
                }
            } else if (n7 == 16384) {
                n6 = n5 + 1;
                while (n6 < this.int) {
                    n4 = nArray[n6 + n3] >> 24 & 0xFF;
                    if (n4 < 8 || n4 >= 248) break;
                    ++n6;
                }
                n8 = n6 - n5;
                h2.if(new Short((short)(n7 |= n8)));
                n9 = n5;
                while (n9 < n6) {
                    n4 = (nArray[n9 + n3] >> 24 & 0xFF) >> 3;
                    h2.if(new Short((short)n4));
                    h2.if(new Short(c.do(nArray[n9 + n3])));
                    ++n9;
                }
            }
            n5 = n6;
        }
        this.for[n2] = new short[h2.for()];
        n4 = 0;
        while (n4 < h2.for()) {
            this.for[n2][n4] = (Short)h2.if(n4);
            ++n4;
        }
        this.do = n2 + 1;
        if (this.new != null) {
            this.new.a(this, n2, 1);
        }
        if (this.do >= this.if) {
            this.new = null;
        }
    }

    public void a(int n2, byte[] byArray, int n3, IndexColorModel indexColorModel) {
        int n4;
        byte by = (byte)indexColorModel.getTransparentPixel();
        h h2 = new h(this.int);
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        while (n5 < this.int) {
            n7 = byArray[n3 + n5] == by ? 8192 : 4096;
            if (n7 == 8192) {
                n6 = n5 + 1;
                while (n6 < this.int) {
                    if (byArray[n3 + n6] != by) break;
                    ++n6;
                }
                if (n6 >= this.int) break;
                h2.if(new Short((short)(n7 |= n6 - n5)));
            } else {
                n6 = n5 + 1;
                while (n6 < this.int) {
                    if (byArray[n3 + n6] == by) break;
                    ++n6;
                }
                n8 = n6 - n5;
                h2.if(new Short((short)(n7 |= n8)));
                n4 = n5;
                while (n4 < n6) {
                    h2.if(new Short(c.do(indexColorModel.getRGB(byArray[n4 + n3] & 0xFF))));
                    ++n4;
                }
            }
            n5 = n6;
        }
        this.for[n2] = new short[0];
        this.for[n2] = new short[h2.for()];
        n4 = 0;
        while (n4 < h2.for()) {
            this.for[n2][n4] = (Short)h2.if(n4);
            ++n4;
        }
        this.do = n2 + 1;
        if (this.new != null) {
            this.new.a(this, n2, 1);
        }
        if (this.do >= this.if) {
            this.new = null;
        }
    }

    protected void a(short[] sArray, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        int n10 = 0;
        short[][] sArray2 = c.long;
        n9 = 31 - n9;
        short s2 = 0;
        int n11 = 0;
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
            n13 = 0;
            while (n17 < n19 && n13 < sArray3.length) {
                n11 = sArray3[n13] & 0xF000;
                n12 = sArray3[n13] & 0xFFF;
                switch (n11) {
                    case 12288: {
                        n18 += n12;
                        n4 += n12;
                        break;
                    }
                    case 8192: {
                        if (n17 < n5) {
                            if (n17 + n12 > n5) {
                                n10 += n17 + n12 - n5;
                            }
                        } else {
                            n10 += n12;
                        }
                        n17 += n12;
                        break;
                    }
                    case 4096: {
                        if (n17 < n5) {
                            if (n17 + n12 > n5) {
                                n14 = n5;
                                n15 = n17 + n12;
                                if (n15 > n19) {
                                    n15 = n19;
                                }
                                n16 = n13 + 1 + n5 - n17;
                                while (n14 < n15) {
                                    sArray[n10++] = sArray2[sArray3[n16++]][n9];
                                    ++n14;
                                }
                            }
                        } else if (n17 >= n5 && n17 < n19) {
                            n14 = n17;
                            n15 = n17 + n12;
                            if (n15 > n19) {
                                n15 = n19;
                            }
                            n16 = n13 + 1;
                            while (n14 < n15) {
                                sArray[n10++] = sArray2[sArray3[n16++]][n9];
                                ++n14;
                            }
                        }
                        n13 += n12;
                        n17 += n12;
                        break;
                    }
                    case 16384: {
                        if (n17 < n5) {
                            if (n17 + n12 > n5) {
                                n14 = n5;
                                n15 = n17 + n12;
                                if (n15 > n19) {
                                    n15 = n19;
                                }
                                n16 = n13 + (n5 - n17 << 1) + 1;
                                while (n14 < n15) {
                                    s2 = sArray3[n16++];
                                    sArray[n10] = sArray2[sArray2[sArray[n10]][31 - s2] + sArray2[sArray3[n16++]][s2]][n9];
                                    ++n10;
                                    ++n14;
                                }
                            }
                        } else if (n17 >= n5 && n17 < n19) {
                            n14 = n17;
                            n15 = n17 + n12;
                            if (n15 > n19) {
                                n15 = n19;
                            }
                            n16 = n13 + 1;
                            while (n14 < n15) {
                                s2 = sArray3[n16++];
                                sArray[n10] = sArray2[sArray2[sArray[n10]][31 - s2] + sArray2[sArray3[n16++]][s2]][n9];
                                ++n10;
                                ++n14;
                            }
                        }
                        n13 += n12 << 1;
                        n17 += n12;
                        break;
                    }
                }
                ++n13;
            }
            ++n18;
            n17 = 0;
            ++n4;
        }
    }

    public boolean a(int n2, int n3, int n4, int n5) {
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        int n9 = n3 + n5;
        int n10 = n3;
        while (n10 < n9) {
            short[] sArray = this.for[n10];
            if (sArray == null || sArray.length == 0) {
                return true;
            }
            n8 = 0;
            int n11 = 0;
            while (n11 < sArray.length) {
                n7 = sArray[n11] & 0xF000;
                n6 = sArray[n11] & 0xFFF;
                if (n7 == 12288) {
                    return true;
                }
                if (n7 == 4096) {
                    n11 += n6;
                } else if (n7 == 16384) {
                    if (n8 < n4 || n8 + n6 > n2) {
                        return true;
                    }
                    n11 += n6 << 1;
                } else if (n7 == 8192 && (n8 < n4 || n8 + n6 > n2)) {
                    return true;
                }
                n8 += n6;
                ++n11;
            }
            ++n10;
        }
        return false;
    }

    public w() {
    }

    public w(int n2, int n3) {
        this.int = n2;
        this.if = n3;
        this.for = new short[n3][];
    }

    public void a(e e2) {
        super.a(e2);
        int n2 = 0;
        while (n2 < this.for.length) {
            e2.for(this.for[n2].length);
            int n3 = 0;
            while (n3 < this.for[n2].length) {
                e2.for(this.for[n2][n3]);
                ++n3;
            }
            ++n2;
        }
    }

    public void a() {
        int n2 = 0;
        while (n2 < this.if) {
            if (this.for[n2].length == 0) {
                int n3 = n2 + 1;
                while (n3 < this.if) {
                    if (this.for[n3].length > 0) break;
                    ++n3;
                }
                if (n3 - n2 > 3) {
                    int n4 = n2;
                    while (n4 < n3 - 2) {
                        this.for[n4] = new short[]{(short)(0x3000 | n3 - n4 - 1)};
                        ++n4;
                    }
                    n2 = n3;
                }
            }
            ++n2;
        }
    }

    protected void do(short[] sArray, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        int n10 = 0;
        short[][] sArray2 = c.long;
        short s2 = 0;
        int n11 = 0;
        int n12 = 0;
        int n13 = 0;
        int n14 = 0;
        int n15 = 0;
        int n16 = 0;
        int n17 = 0;
        int n18 = n6;
        int n19 = n5 + n7;
        int n20 = n6 + n8;
        int n21 = 0;
        int n22 = 0;
        int n23 = 0;
        short s3 = 0;
        int n24 = 0;
        int n25 = n9 >> 19 & 0x1F;
        int n26 = n9 >> 11 & 0x1F;
        int n27 = n9 >> 3 & 0x1F;
        short[] sArray3 = null;
        while (n18 < n20) {
            sArray3 = this.for[n18];
            if (sArray3 != null) {
                n10 = n2 * n4 + n3;
                n13 = 0;
                while (n17 < n19 && n13 < sArray3.length) {
                    n11 = sArray3[n13] & 0xF000;
                    n12 = sArray3[n13] & 0xFFF;
                    switch (n11) {
                        case 12288: {
                            n18 += n12;
                            n4 += n12;
                            break;
                        }
                        case 8192: {
                            if (n17 < n5) {
                                if (n17 + n12 > n5) {
                                    n10 += n17 + n12 - n5;
                                }
                            } else {
                                n10 += n12;
                            }
                            n17 += n12;
                            break;
                        }
                        case 4096: {
                            if (n17 < n5) {
                                if (n17 + n12 > n5) {
                                    n14 = n5;
                                    n15 = n17 + n12;
                                    if (n15 > n19) {
                                        n15 = n19;
                                    }
                                    n16 = n13 + 1 + n5 - n17;
                                    while (n14 < n15) {
                                        n24 = sArray3[n16++] & 0x1F;
                                        n21 = n24 * n25 >> 5;
                                        n22 = n24 * n26 >> 5;
                                        n23 = n24 * n27 >> 5;
                                        s3 = sArray[n10];
                                        n21 = c.byte[s3][n21];
                                        n22 = c.case[s3][n22];
                                        n23 = c.b[s3][n23];
                                        sArray[n10++] = (short)(n21 | n22 | n23);
                                        ++n14;
                                    }
                                }
                            } else if (n17 >= n5 && n17 < n19) {
                                n14 = n17;
                                n15 = n17 + n12;
                                if (n15 > n19) {
                                    n15 = n19;
                                }
                                n16 = n13 + 1;
                                while (n14 < n15) {
                                    n24 = sArray3[n16++] & 0x1F;
                                    n21 = n24 * n25 >> 5;
                                    n22 = n24 * n26 >> 5;
                                    n23 = n24 * n27 >> 5;
                                    s3 = sArray[n10];
                                    n21 = c.byte[s3][n21];
                                    n22 = c.case[s3][n22];
                                    n23 = c.b[s3][n23];
                                    sArray[n10++] = (short)(n21 | n22 | n23);
                                    ++n14;
                                }
                            }
                            n13 += n12;
                            n17 += n12;
                            break;
                        }
                        case 16384: {
                            if (n17 < n5) {
                                if (n17 + n12 > n5) {
                                    n14 = n5;
                                    n15 = n17 + n12;
                                    if (n15 > n19) {
                                        n15 = n19;
                                    }
                                    n16 = n13 + (n5 - n17 << 1) + 1;
                                    while (n14 < n15) {
                                        s2 = sArray3[n16++];
                                        n24 = sArray2[sArray3[n16++]][s2] & 0x1F;
                                        n21 = n24 * n25 >> 5;
                                        n22 = n24 * n26 >> 5;
                                        n23 = n24 * n27 >> 5;
                                        s3 = sArray[n10];
                                        n21 = c.byte[s3][n21];
                                        n22 = c.case[s3][n22];
                                        n23 = c.b[s3][n23];
                                        sArray[n10++] = (short)(n21 | n22 | n23);
                                        ++n14;
                                    }
                                }
                            } else if (n17 >= n5 && n17 < n19) {
                                n14 = n17;
                                n15 = n17 + n12;
                                if (n15 > n19) {
                                    n15 = n19;
                                }
                                n16 = n13 + 1;
                                while (n14 < n15) {
                                    s2 = sArray3[n16++];
                                    n24 = sArray2[sArray3[n16++]][s2] & 0x1F;
                                    n21 = n24 * n25 >> 5;
                                    n22 = n24 * n26 >> 5;
                                    n23 = n24 * n27 >> 5;
                                    s3 = sArray[n10];
                                    n21 = c.byte[s3][n21];
                                    n22 = c.case[s3][n22];
                                    n23 = c.b[s3][n23];
                                    sArray[n10++] = (short)(n21 | n22 | n23);
                                    ++n14;
                                }
                            }
                            n13 += n12 << 1;
                            n17 += n12;
                            break;
                        }
                    }
                    ++n13;
                }
            }
            ++n18;
            n17 = 0;
            ++n4;
        }
    }

    private void int(short[] sArray, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        int n9 = 0;
        short[][] sArray2 = c.long;
        int n10 = 0;
        int n11 = 0;
        short s2 = 0;
        int n12 = 0;
        int n13 = 0;
        int n14 = 0;
        int n15 = 0;
        int n16 = 0;
        int n17 = n6;
        int n18 = n5 + n7;
        int n19 = n6 + n8;
        short[] sArray3 = null;
        while (n17 < n19) {
            sArray3 = this.for[n17];
            if (sArray3 != null) {
                n9 = n2 * n4 + n3;
                n12 = 0;
                while (n16 < n18 && n12 < sArray3.length) {
                    n10 = sArray3[n12] & 0xF000;
                    n11 = sArray3[n12] & 0xFFF;
                    switch (n10) {
                        case 12288: {
                            n17 += n11;
                            n4 += n11;
                            break;
                        }
                        case 8192: {
                            if (n16 < n5) {
                                if (n16 + n11 > n5) {
                                    n9 += n16 + n11 - n5;
                                }
                            } else {
                                n9 += n11;
                            }
                            n16 += n11;
                            break;
                        }
                        case 4096: {
                            if (n16 < n5) {
                                if (n16 + n11 > n5) {
                                    n14 = n16 + n11;
                                    if (n14 > n18) {
                                        n14 = n18;
                                    }
                                    n15 = n12 + 1 + n5 - n16;
                                    if (n11 > 20) {
                                        n13 = n14 - n5;
                                        System.arraycopy(sArray3, n15, sArray, n9, n13);
                                        n9 += n13;
                                    } else {
                                        n13 = n5;
                                        while (n13 < n14) {
                                            sArray[n9++] = sArray3[n15++];
                                            ++n13;
                                        }
                                    }
                                }
                            } else if (n16 >= n5 && n16 < n18) {
                                n14 = n16 + n11;
                                if (n14 > n18) {
                                    n14 = n18;
                                }
                                n15 = n12 + 1;
                                if (n11 > 20) {
                                    n13 = n14 - n16;
                                    System.arraycopy(sArray3, n15, sArray, n9, n13);
                                    n9 += n13;
                                } else {
                                    n13 = n16;
                                    while (n13 < n14) {
                                        sArray[n9++] = sArray3[n15++];
                                        ++n13;
                                    }
                                }
                            }
                            n12 += n11;
                            n16 += n11;
                            break;
                        }
                        case 16384: {
                            if (n16 < n5) {
                                if (n16 + n11 > n5) {
                                    n13 = n5;
                                    n14 = n16 + n11;
                                    if (n14 > n18) {
                                        n14 = n18;
                                    }
                                    n15 = n12 + (n5 - n16 << 1) + 1;
                                    while (n13 < n14) {
                                        s2 = sArray3[n15++];
                                        sArray[n9] = (short)(sArray2[sArray[n9]][31 - s2] + sArray2[sArray3[n15++]][s2]);
                                        ++n13;
                                        ++n9;
                                    }
                                }
                            } else if (n16 >= n5 && n16 < n18) {
                                n13 = n16;
                                n14 = n16 + n11;
                                if (n14 > n18) {
                                    n14 = n18;
                                }
                                n15 = n12 + 1;
                                while (n13 < n14) {
                                    s2 = sArray3[n15++];
                                    sArray[n9] = (short)(sArray2[sArray[n9]][31 - s2] + sArray2[sArray3[n15++]][s2]);
                                    ++n13;
                                    ++n9;
                                }
                            }
                            n12 += n11 << 1;
                            n16 += n11;
                            break;
                        }
                    }
                    ++n12;
                }
            }
            ++n17;
            n16 = 0;
            ++n4;
        }
    }

    protected void for(short[] sArray, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        int n10 = 0;
        short[][] sArray2 = c.long;
        int n11 = 31 - n9;
        int n12 = 0;
        int n13 = 0;
        int n14 = 0;
        int n15 = 0;
        int n16 = 0;
        int n17 = 0;
        int n18 = 0;
        int n19 = 0;
        int n20 = n6;
        int n21 = n5 + n7;
        int n22 = n6 + n8;
        short[] sArray3 = null;
        while (n20 < n22) {
            sArray3 = this.for[n20];
            n10 = n2 * n4 + n3;
            n15 = 0;
            while (n19 < n21 && n15 < sArray3.length) {
                n13 = sArray3[n15] & 0xF000;
                n14 = sArray3[n15] & 0xFFF;
                switch (n13) {
                    case 12288: {
                        n20 += n14;
                        n4 += n14;
                        break;
                    }
                    case 8192: {
                        if (n19 < n5) {
                            if (n19 + n14 > n5) {
                                n10 += n19 + n14 - n5;
                            }
                        } else {
                            n10 += n14;
                        }
                        n19 += n14;
                        break;
                    }
                    case 4096: {
                        if (n19 < n5) {
                            if (n19 + n14 > n5) {
                                n16 = n5;
                                n17 = n19 + n14;
                                if (n17 > n21) {
                                    n17 = n21;
                                }
                                n18 = n15 + 1 + n5 - n19;
                                while (n16 < n17) {
                                    sArray[n10] = (short)(sArray2[sArray[n10]][n11] + sArray2[sArray3[n18++]][n9]);
                                    ++n16;
                                    ++n10;
                                }
                            }
                        } else if (n19 >= n5 && n19 < n21) {
                            n16 = n19;
                            n17 = n19 + n14;
                            if (n17 > n21) {
                                n17 = n21;
                            }
                            n18 = n15 + 1;
                            while (n16 < n17) {
                                sArray[n10] = (short)(sArray2[sArray[n10]][n11] + sArray2[sArray3[n18++]][n9]);
                                ++n16;
                                ++n10;
                            }
                        }
                        n15 += n14;
                        n19 += n14;
                        break;
                    }
                    case 16384: {
                        if (n19 < n5) {
                            if (n19 + n14 > n5) {
                                n16 = n5;
                                n17 = n19 + n14;
                                if (n17 > n21) {
                                    n17 = n21;
                                }
                                n18 = n15 + (n5 - n19 << 1) + 1;
                                while (n16 < n17) {
                                    n12 = sArray3[n18++] * n9 >> 5;
                                    sArray[n10] = (short)(sArray2[sArray[n10]][31 - n12] + sArray2[sArray3[n18++]][n12]);
                                    ++n16;
                                    ++n10;
                                }
                            }
                        } else if (n19 >= n5 && n19 < n21) {
                            n16 = n19;
                            n17 = n19 + n14;
                            if (n17 > n21) {
                                n17 = n21;
                            }
                            n18 = n15 + 1;
                            while (n16 < n17) {
                                n12 = sArray3[n18++] * n9 >> 5;
                                sArray[n10] = (short)(sArray2[sArray[n10]][31 - n12] + sArray2[sArray3[n18++]][n12]);
                                ++n16;
                                ++n10;
                            }
                        }
                        n15 += n14 << 1;
                        n19 += n14;
                        break;
                    }
                }
                ++n15;
            }
            ++n20;
            n19 = 0;
            ++n4;
        }
    }

    private void for(short[] sArray, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        int n9 = 0;
        short[][] sArray2 = c.long;
        short[][] sArray3 = c.g;
        short[][] sArray4 = c.f;
        short[][] sArray5 = c.char;
        int n10 = 0;
        int n11 = 0;
        short s2 = 0;
        int n12 = 0;
        int n13 = 0;
        int n14 = 0;
        int n15 = 0;
        int n16 = 0;
        int n17 = n6;
        int n18 = n5 + n7;
        int n19 = n6 + n8;
        short[] sArray6 = null;
        int n20 = this.a >> 19 & 0x1F;
        int n21 = this.a >> 11 & 0x1F;
        int n22 = this.a >> 3 & 0x1F;
        short s3 = 0;
        while (n17 < n19) {
            sArray6 = this.for[n17];
            n9 = n2 * n4 + n3;
            n12 = 0;
            while (n16 < n18 && n12 < sArray6.length) {
                n10 = sArray6[n12] & 0xF000;
                n11 = sArray6[n12] & 0xFFF;
                switch (n10) {
                    case 12288: {
                        n17 += n11;
                        n4 += n11;
                        break;
                    }
                    case 8192: {
                        if (n16 < n5) {
                            if (n16 + n11 > n5) {
                                n9 += n16 + n11 - n5;
                            }
                        } else {
                            n9 += n11;
                        }
                        n16 += n11;
                        break;
                    }
                    case 4096: {
                        if (n16 < n5) {
                            if (n16 + n11 > n5) {
                                n14 = n16 + n11;
                                if (n14 > n18) {
                                    n14 = n18;
                                }
                                n15 = n12 + 1 + n5 - n16;
                                n13 = n5;
                                while (n13 < n14) {
                                    s3 = sArray6[n15++];
                                    sArray[n9++] = (short)(sArray3[s3][n20] | sArray4[s3][n21] | sArray5[s3][n22]);
                                    ++n13;
                                }
                            }
                        } else if (n16 >= n5 && n16 < n18) {
                            n14 = n16 + n11;
                            if (n14 > n18) {
                                n14 = n18;
                            }
                            n15 = n12 + 1;
                            n13 = n16;
                            while (n13 < n14) {
                                s3 = sArray6[n15++];
                                sArray[n9++] = (short)(sArray3[s3][n20] | sArray4[s3][n21] | sArray5[s3][n22]);
                                ++n13;
                            }
                        }
                        n12 += n11;
                        n16 += n11;
                        break;
                    }
                    case 16384: {
                        if (n16 < n5) {
                            if (n16 + n11 > n5) {
                                n13 = n5;
                                n14 = n16 + n11;
                                if (n14 > n18) {
                                    n14 = n18;
                                }
                                n15 = n12 + (n5 - n16 << 1) + 1;
                                while (n13 < n14) {
                                    s2 = sArray6[n15++];
                                    s3 = sArray6[n15++];
                                    s3 = (short)(sArray3[s3][n20] | sArray4[s3][n21] | sArray5[s3][n22]);
                                    sArray[n9] = (short)(sArray2[sArray[n9]][31 - s2] + sArray2[s3][s2]);
                                    ++n13;
                                    ++n9;
                                }
                            }
                        } else if (n16 >= n5 && n16 < n18) {
                            n13 = n16;
                            n14 = n16 + n11;
                            if (n14 > n18) {
                                n14 = n18;
                            }
                            n15 = n12 + 1;
                            while (n13 < n14) {
                                s2 = sArray6[n15++];
                                s3 = sArray6[n15++];
                                s3 = (short)(sArray3[s3][n20] | sArray4[s3][n21] | sArray5[s3][n22]);
                                sArray[n9] = (short)(sArray2[sArray[n9]][31 - s2] + sArray2[s3][s2]);
                                ++n13;
                                ++n9;
                            }
                        }
                        n12 += n11 << 1;
                        n16 += n11;
                        break;
                    }
                }
                ++n12;
            }
            ++n17;
            n16 = 0;
            ++n4;
        }
    }

    public int for() {
        return 2;
    }

    protected void if(short[] sArray, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        int n9 = 0;
        short[][] sArray2 = c.long;
        short[] sArray3 = c.d;
        short s2 = 0;
        int n10 = 0;
        int n11 = 0;
        int n12 = 0;
        int n13 = 0;
        int n14 = 0;
        int n15 = 0;
        int n16 = 0;
        int n17 = n6;
        int n18 = n5 + n7;
        int n19 = n6 + n8;
        short[] sArray4 = null;
        while (n17 < n19) {
            sArray4 = this.for[n17];
            n9 = n2 * n4 + n3;
            n12 = 0;
            while (n16 < n18 && n12 < sArray4.length) {
                n10 = sArray4[n12] & 0xF000;
                n11 = sArray4[n12] & 0xFFF;
                switch (n10) {
                    case 12288: {
                        n17 += n11;
                        n4 += n11;
                        break;
                    }
                    case 8192: {
                        if (n16 < n5) {
                            if (n16 + n11 > n5) {
                                n9 += n16 + n11 - n5;
                            }
                        } else {
                            n9 += n11;
                        }
                        n16 += n11;
                        break;
                    }
                    case 4096: {
                        if (n16 < n5) {
                            if (n16 + n11 > n5) {
                                n13 = n5;
                                n14 = n16 + n11;
                                if (n14 > n18) {
                                    n14 = n18;
                                }
                                n15 = n12 + 1 + n5 - n16;
                                while (n13 < n14) {
                                    sArray[n9++] = sArray3[sArray4[n15++]];
                                    ++n13;
                                }
                            }
                        } else if (n16 >= n5 && n16 < n18) {
                            n13 = n16;
                            n14 = n16 + n11;
                            if (n14 > n18) {
                                n14 = n18;
                            }
                            n15 = n12 + 1;
                            while (n13 < n14) {
                                sArray[n9++] = sArray3[sArray4[n15++]];
                                ++n13;
                            }
                        }
                        n12 += n11;
                        n16 += n11;
                        break;
                    }
                    case 16384: {
                        if (n16 < n5) {
                            if (n16 + n11 > n5) {
                                n13 = n5;
                                n14 = n16 + n11;
                                if (n14 > n18) {
                                    n14 = n18;
                                }
                                n15 = n12 + (n5 - n16 << 1) + 1;
                                while (n13 < n14) {
                                    s2 = sArray4[n15++];
                                    sArray[n9] = sArray3[sArray2[sArray[n9]][31 - s2] + sArray2[sArray4[n15++]][s2]];
                                    ++n9;
                                    ++n13;
                                }
                            }
                        } else if (n16 >= n5 && n16 < n18) {
                            n13 = n16;
                            n14 = n16 + n11;
                            if (n14 > n18) {
                                n14 = n18;
                            }
                            n15 = n12 + 1;
                            while (n13 < n14) {
                                s2 = sArray4[n15++];
                                sArray[n9] = sArray3[sArray2[sArray[n9]][31 - s2] + sArray2[sArray4[n15++]][s2]];
                                ++n9;
                                ++n13;
                            }
                        }
                        n12 += n11 << 1;
                        n16 += n11;
                        break;
                    }
                }
                ++n12;
            }
            ++n17;
            n16 = 0;
            ++n4;
        }
    }

    protected void do(short[] sArray, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        int n9 = 0;
        short s2 = 0;
        int n10 = 0;
        int n11 = 0;
        int n12 = 0;
        int n13 = 0;
        int n14 = 0;
        int n15 = 0;
        int n16 = 0;
        int n17 = n6;
        int n18 = n5 + n7;
        int n19 = n6 + n8;
        int n20 = 0;
        int n21 = 0;
        int n22 = 0;
        short s3 = 0;
        short[] sArray2 = null;
        while (n17 < n19) {
            sArray2 = this.for[n17];
            if (sArray2 != null) {
                n9 = n2 * n4 + n3;
                n12 = 0;
                while (n16 < n18 && n12 < sArray2.length) {
                    n10 = sArray2[n12] & 0xF000;
                    n11 = sArray2[n12] & 0xFFF;
                    switch (n10) {
                        case 12288: {
                            n17 += n11;
                            n4 += n11;
                            break;
                        }
                        case 8192: {
                            if (n16 < n5) {
                                if (n16 + n11 > n5) {
                                    n9 += n16 + n11 - n5;
                                }
                            } else {
                                n9 += n11;
                            }
                            n16 += n11;
                            break;
                        }
                        case 4096: {
                            if (n16 < n5) {
                                if (n16 + n11 > n5) {
                                    n13 = n5;
                                    n14 = n16 + n11;
                                    if (n14 > n18) {
                                        n14 = n18;
                                    }
                                    n15 = n12 + 1 + n5 - n16;
                                    while (n13 < n14) {
                                        n20 = sArray2[n15] >> 10 & 0x1F;
                                        n21 = sArray2[n15] >> 5 & 0x1F;
                                        n22 = sArray2[n15++] & 0x1F;
                                        s3 = sArray[n9];
                                        n20 = c.byte[s3][n20];
                                        n21 = c.case[s3][n21];
                                        n22 = c.b[s3][n22];
                                        sArray[n9++] = (short)(n20 | n21 | n22);
                                        ++n13;
                                    }
                                }
                            } else if (n16 >= n5 && n16 < n18) {
                                n13 = n16;
                                n14 = n16 + n11;
                                if (n14 > n18) {
                                    n14 = n18;
                                }
                                n15 = n12 + 1;
                                while (n13 < n14) {
                                    n20 = sArray2[n15] >> 10 & 0x1F;
                                    n21 = sArray2[n15] >> 5 & 0x1F;
                                    n22 = sArray2[n15++] & 0x1F;
                                    s3 = sArray[n9];
                                    n20 = c.byte[s3][n20];
                                    n21 = c.case[s3][n21];
                                    n22 = c.b[s3][n22];
                                    sArray[n9++] = (short)(n20 | n21 | n22);
                                    ++n13;
                                }
                            }
                            n12 += n11;
                            n16 += n11;
                            break;
                        }
                        case 16384: {
                            if (n16 < n5) {
                                if (n16 + n11 > n5) {
                                    n13 = n5;
                                    n14 = n16 + n11;
                                    if (n14 > n18) {
                                        n14 = n18;
                                    }
                                    n15 = n12 + (n5 - n16 << 1) + 1;
                                    while (n13 < n14) {
                                        s2 = sArray2[n15++];
                                        s3 = c.long[sArray2[n15++]][s2];
                                        n20 = s3 >> 10 & 0x1F;
                                        n21 = s3 >> 5 & 0x1F;
                                        n22 = s3 & 0x1F;
                                        s3 = sArray[n9];
                                        n20 = c.byte[s3][n20];
                                        n21 = c.case[s3][n21];
                                        n22 = c.b[s3][n22];
                                        sArray[n9++] = (short)(n20 | n21 | n22);
                                        ++n13;
                                    }
                                }
                            } else if (n16 >= n5 && n16 < n18) {
                                n13 = n16;
                                n14 = n16 + n11;
                                if (n14 > n18) {
                                    n14 = n18;
                                }
                                n15 = n12 + 1;
                                while (n13 < n14) {
                                    s2 = sArray2[n15++];
                                    s3 = c.long[sArray2[n15++]][s2];
                                    n20 = s3 >> 10 & 0x1F;
                                    n21 = s3 >> 5 & 0x1F;
                                    n22 = s3 & 0x1F;
                                    s3 = sArray[n9];
                                    n20 = c.byte[s3][n20];
                                    n21 = c.case[s3][n21];
                                    n22 = c.b[s3][n22];
                                    sArray[n9++] = (short)(n20 | n21 | n22);
                                    ++n13;
                                }
                            }
                            n12 += n11 << 1;
                            n16 += n11;
                            break;
                        }
                    }
                    ++n12;
                }
            }
            ++n17;
            n16 = 0;
            ++n4;
        }
    }

    public short a(int n2, int n3) {
        if (n2 < 0 || n2 >= this.int || n3 < 0 || n3 >= this.if) {
            return -1;
        }
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
                if (n6 + n4 > n2) {
                    return sArray[n7 + n2 - n6];
                }
                n7 += n4;
            } else {
                if (n5 == 12288) {
                    return -1;
                }
                if (n5 == 16384) {
                    if (n6 + n4 > n2) {
                        return sArray[(n2 - n6 << 1) + n7];
                    }
                    n7 += n4 << 1;
                }
            }
            if ((n6 += n4) > n2) {
                return -1;
            }
            ++n7;
        }
        return -1;
    }
}

