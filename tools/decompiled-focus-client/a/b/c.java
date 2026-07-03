/*
 * Decompiled with CFR 0.152.
 */
package a.b;

import a.b.af;
import a.b.u;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class c {
    public static final int j = 1;
    public static final int e = 2;
    public static final int if = 3;
    public static final int try = 4;
    public static final int do = 5;
    public static final int goto = 6;
    public static final int new = 7;
    static final int[] void;
    static final short[] d;
    static final short[][] long;
    static final short[][] byte;
    static final short[][] case;
    static final short[][] b;
    static final short[][] g;
    static final short[][] f;
    static final short[][] char;
    protected Dimension int;
    protected Rectangle for = new Rectangle();
    protected Rectangle h = new Rectangle();
    protected Point i = new Point();
    protected short[] a;
    private u else;
    protected boolean c;

    public void if(int n2, int n3, int n4, int n5, int n6) {
        this.do(n2, n3, n2 + n4, n3, n6);
        this.do(n2, n3 + n5 - 1, n2 + n4, n3 + n5 - 1, n6);
        this.do(n2, n3, n2, n3 + n5, n6);
        this.do(n2 + n4 - 1, n3, n2 + n4 - 1, n3 + n5, n6);
    }

    public void a(int n2) {
        short s2 = a.b.c.do(n2);
        int n3 = this.h.x;
        int n4 = this.h.y;
        int n5 = n3 + this.h.width;
        int n6 = n4 + this.h.height;
        int n7 = this.int.width * n4 + n3;
        int n8 = this.int.width - n3;
        int n9 = n4;
        while (n9 < n6) {
            int n10 = n3;
            while (n10 < n5) {
                this.a[n7] = (short)(this.a[n7] & s2);
                ++n10;
                ++n7;
            }
            ++n9;
            n7 += n8;
        }
    }

    public Rectangle goto() {
        return new Rectangle(this.h);
    }

    public void a(char c2, int n2, int n3, int n4) {
        af af2 = this.else.a(c2, n4);
        this.a(af2, n2, n3);
    }

    public void a(char c2, int n2, int n3, int n4, int n5) {
        af af2 = this.else.a(c2, n4);
        this.do(af2, n2, n3, n5);
    }

    public int long() {
        return this.i.x;
    }

    protected void a(Graphics graphics, int n2, int n3) {
    }

    public static final int a(short s2) {
        return void[s2];
    }

    public void do(int n2, int n3, int n4, int n5, int n6) {
        n3 += this.i.y;
        n5 += this.i.y;
        short s2 = a.b.c.do(n6);
        if ((n2 += this.i.x) == (n4 += this.i.x)) {
            if (n2 < this.for.x || n2 >= this.for.x + this.for.width) {
                return;
            }
            if (n3 < this.for.y) {
                n3 = this.for.y;
            } else if (n3 > this.for.y + this.for.height) {
                n3 = this.for.y + this.for.height;
            }
            if (n5 < this.for.y) {
                n5 = this.for.y;
            } else if (n5 > this.for.y + this.for.height) {
                n5 = this.for.y + this.for.height;
            }
            this.if(n2, Math.min(n3, n5), Math.abs(n5 - n3), s2);
        } else if (n3 == n5) {
            if (n3 < this.for.y || n3 >= this.for.y + this.for.height) {
                return;
            }
            if (n2 < this.for.x) {
                n2 = this.for.x;
            } else if (n2 > this.for.x + this.for.width) {
                n2 = this.for.x + this.for.width;
            }
            if (n4 < this.for.x) {
                n4 = this.for.x;
            } else if (n4 > this.for.x + this.for.width) {
                n4 = this.for.x + this.for.width;
            }
            this.a(Math.min(n2, n4), n3, Math.abs(n4 - n2), s2);
        }
        if (this.h.isEmpty()) {
            this.h.setBounds(n2, n3, 1, 1);
        } else {
            this.h.add(n2, n3);
        }
        this.h.add(n4, n5);
        this.c = false;
    }

    public int case() {
        return this.for.width;
    }

    public int do() {
        return this.for.y - this.i.y;
    }

    public void a(af af2, int n2, int n3, int n4) {
        this.a(af2, n2, n3, 0, 0, af2.int(), af2.try(), 3, n4);
    }

    public void a(af af2, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        this.a(af2, n2, n3, n4, n5, n6, n7, 3, n8);
    }

    public void if(af af2, int n2, int n3, int n4) {
        this.a(af2, n2, n3, 0, 0, af2.int(), af2.try(), 2, n4);
    }

    public void for(af af2, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        this.a(af2, n2, n3, n4, n5, n6, n7, 2, n8);
    }

    public void a(String string, int n2, int n3, int n4) {
        int n5 = string.length();
        int n6 = 0;
        while (n6 < n5) {
            char c2 = string.charAt(n6);
            this.a(c2, n2, n3, n4);
            n2 += this.else.a(c2);
            ++n6;
        }
    }

    public void a(String string, int n2, int n3, int n4, int n5) {
        int n6 = string.length();
        int n7 = 0;
        while (n7 < n6) {
            char c2 = string.charAt(n7);
            this.a(c2, n2, n3, n4, n5);
            n2 += this.else.a(c2);
            ++n7;
        }
    }

    public void a(Rectangle[] rectangleArray) {
    }

    private void if(int n2, int n3, int n4, short s2) {
        int n5 = n3 + n4;
        int n6 = this.int.width * n3 + n2;
        int n7 = n3;
        while (n7 < n5) {
            this.a[n6] = s2;
            ++n7;
            n6 += this.int.width;
        }
    }

    private void a(int n2, int n3, int n4, short s2) {
        int n5 = n2 + n4;
        int n6 = this.int.width * n3 + n2;
        int n7 = n2;
        while (n7 < n5) {
            this.a[n6++] = s2;
            ++n7;
        }
    }

    public void for(af af2, int n2, int n3, int n4) {
        this.if(af2, n2, n3, 0, 0, af2.int(), af2.try(), n4);
    }

    public void if(af af2, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        this.a(af2, n2, n3, n4, n5, n6, n7, 6, n8);
    }

    public void a(af af2, int n2, int n3, int n4, int n5) {
        this.a(af2, n2, n3, 0, 0, af2.int(), af2.try(), n4, n5);
    }

    public void a(int n2, int n3, Component component) {
        this.a(n2, n3);
        this.else = new u("\u5b8b\u4f53", 0, 12, component);
    }

    public void a(int n2, int n3, short[] sArray) {
        this.a(n2, n3);
        this.a = sArray;
    }

    public int else() {
        return this.for.x - this.i.x;
    }

    public void a(Polygon polygon, int n2) {
        int n3 = polygon.npoints - 1;
        int n4 = 0;
        while (n4 < n3 - 1) {
            this.do(polygon.xpoints[n4], polygon.ypoints[n4++], polygon.xpoints[n4], polygon.ypoints[n4], n2);
            ++n4;
        }
        this.do(polygon.xpoints[0], polygon.ypoints[0], polygon.xpoints[n3], polygon.ypoints[n3], n2);
    }

    public void a(int n2, int n3) {
        this.int = new Dimension(n2, n3);
    }

    public void a(af af2, int n2, int n3) {
        this.a(af2, n2, n3, 0, 0, af2.int(), af2.try(), 0, 0);
    }

    public void if(af af2, int n2, int n3, int n4, int n5, int n6, int n7) {
        this.a(af2, n2, n3, n4, n5, n6, n7, 0, 0);
    }

    public void a(int n2, int n3, int n4, int n5) {
        n3 += this.i.y;
        if ((n2 += this.i.x) < 0) {
            n4 += n2;
            n2 = 0;
        }
        if (n3 < 0) {
            n5 += n3;
            n3 = 0;
        }
        if (n2 + n4 > this.int.width) {
            n4 = this.int.width - n2;
        }
        if (n3 + n5 > this.int.height) {
            n5 = this.int.height - n3;
        }
        this.for.setBounds(n2, n3, n4, n5);
    }

    public void if(Rectangle rectangle) {
        this.a(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    public Rectangle char() {
        Rectangle rectangle = new Rectangle();
        this.a(rectangle);
        return rectangle;
    }

    public void a(Rectangle rectangle) {
        rectangle.setBounds(this.for.x - this.i.x, this.for.y - this.i.y, this.for.width, this.for.height);
    }

    public void int() {
        int n2 = this.h.x;
        int n3 = this.h.y;
        int n4 = n2 + this.h.width;
        int n5 = n3 + this.h.height;
        int n6 = this.int.width * n3 + n2;
        int n7 = this.int.width - n2;
        int n8 = n3;
        while (n8 < n5) {
            int n9 = n2;
            while (n9 < n4) {
                this.a[n6] = d[this.a[n6]];
                ++n9;
                ++n6;
            }
            ++n8;
            n6 += n7;
        }
    }

    public void a(af af2, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        int n10;
        if (af2 == null) {
            return;
        }
        if ((n2 += this.i.x) + n6 <= this.for.x || (n3 += this.i.y) + n7 <= this.for.y || n2 >= this.for.x + this.for.width || n3 >= this.for.y + this.for.height) {
            return;
        }
        if (n2 < this.for.x) {
            n10 = this.for.x - n2;
            n4 += n10;
            n6 -= n10;
            n2 = this.for.x;
        }
        if (n3 < this.for.y) {
            n10 = this.for.y - n3;
            n5 += n10;
            n7 -= n10;
            n3 = this.for.y;
        }
        if (n2 + n6 > this.for.x + this.for.width) {
            n6 = this.for.x + this.for.width - n2;
        }
        if (n3 + n7 > this.for.y + this.for.height) {
            n7 = this.for.y + this.for.height - n3;
        }
        if (n8 == 1 && n9 > 248) {
            n8 = 0;
        }
        switch (n8) {
            case 2: {
                af2.int(this.a, this.int.width, n2, n3, n4, n5, n6, n7, n9 >> 3);
                break;
            }
            case 5: {
                af2.do(this.a, this.int.width, n2, n3, n4, n5, n6, n7);
                break;
            }
            case 4: {
                af2.if(this.a, this.int.width, n2, n3, n4, n5, n6, n7);
                break;
            }
            case 6: {
                af2.do(this.a, this.int.width, n2, n3, n4, n5, n6, n7, n9);
                break;
            }
            case 3: {
                af2.a(this.a, this.int.width, n2, n3, n4, n5, n6, n7, n9 >> 3);
                break;
            }
            case 1: {
                af2.for(this.a, this.int.width, n2, n3, n4, n5, n6, n7, n9 >> 3);
                break;
            }
            case 7: {
                af2.if(this.a, this.int.width, n2, n3, n4, n5, n6, n7, n9);
                break;
            }
            default: {
                af2.a(this.a, this.int.width, n2, n3, n4, n5, n6, n7);
            }
        }
        if (this.h.isEmpty()) {
            this.h.setBounds(n2, n3, n6, n7);
        } else {
            this.h.add(n2, n3);
            this.h.add(n2 + n6, n3 + n7);
        }
        this.c = false;
    }

    public int for() {
        return this.int.width;
    }

    public void a(char[] cArray, int n2, int n3, int n4, int n5, int n6) {
        int n7 = 0;
        while (n7 < n3) {
            char c2 = cArray[n2++];
            this.a(c2, n4, n5, n6);
            n4 += this.else.a(c2);
            ++n7;
        }
    }

    public void a(int n2, int n3, int n4) {
        if (!this.for.contains(n2 += this.i.x, n3 += this.i.y)) {
            return;
        }
        this.a[n3 * this.int.width + n2] = a.b.c.do(n4);
        if (this.h.isEmpty()) {
            this.h.setBounds(n2, n3, 1, 1);
        } else {
            this.h.add(n2, n3);
        }
        this.c = false;
    }

    private void a(int n2, int n3, short s2) {
    }

    public int void() {
        return this.for.height;
    }

    public void a(int n2, int n3, int n4, int n5, int n6) {
        int n7 = n6 >> 24 & 0xFF;
        if ((n7 >>= 3) == 0) {
            return;
        }
        if ((n2 += this.i.x) + n4 <= this.for.x || (n3 += this.i.y) + n5 <= this.for.y || n2 >= this.for.x + this.for.width || n3 >= this.for.y + this.for.height) {
            return;
        }
        short s2 = a.b.c.do(n6);
        if (n2 < this.for.x) {
            n4 -= this.for.x - n2;
            n2 = this.for.x;
        }
        if (n3 < this.for.y) {
            n5 -= this.for.y - n3;
            n3 = this.for.y;
        }
        if (n2 + n4 > this.for.x + this.for.width) {
            n4 = this.for.x + this.for.width - n2;
        }
        if (n3 + n5 > this.for.y + this.for.height) {
            n5 = this.for.y + this.for.height - n3;
        }
        int n8 = n2 + n4;
        int n9 = n3 + n5;
        int n10 = this.int.width * n3 + n2;
        int n11 = this.int.width - n4;
        if (n7 < 31) {
            int n12 = 31 - n7;
            if ((s2 = long[s2][n7]) == 0) {
                int n13 = n3;
                while (n13 < n9) {
                    int n14 = n2;
                    while (n14 < n8) {
                        this.a[n10] = long[this.a[n10]][n12];
                        ++n14;
                        ++n10;
                    }
                    ++n13;
                    n10 += n11;
                }
            } else {
                int n15 = n3;
                while (n15 < n9) {
                    int n16 = n2;
                    while (n16 < n8) {
                        this.a[n10] = (short)(long[this.a[n10]][n12] + s2);
                        ++n16;
                        ++n10;
                    }
                    ++n15;
                    n10 += n11;
                }
            }
        } else {
            int n17 = n3;
            while (n17 < n9) {
                int n18 = n2;
                while (n18 < n8) {
                    this.a[n10++] = s2;
                    ++n18;
                }
                ++n17;
                n10 += n11;
            }
        }
        if (this.h.isEmpty()) {
            this.h.setBounds(n2, n3, n4, n5);
        } else {
            this.h.add(n2, n3);
            this.h.add(n2 + n4, n3 + n5);
        }
        this.c = false;
    }

    public void byte() {
        this.for.setBounds(0, 0, this.int.width, this.int.height);
        this.h.setBounds(0, 0, 0, 0);
        this.i.setLocation(0, 0);
    }

    public void do(int n2, int n3) {
        this.i.x += n2;
        this.i.y += n3;
    }

    public static final int if(int n2, int n3) {
        int n4 = n2 >> 16 & 0xFF;
        int n5 = n2 >> 8 & 0xFF;
        int n6 = n2 & 0xFF;
        n4 = Math.min(255, n4 + n3);
        n5 = Math.min(255, n5 + n3);
        n6 = Math.min(255, n6 + n3);
        return n4 << 16 | n5 << 8 | n6;
    }

    public void a(Graphics graphics) {
        this.if(graphics, 0, 0);
    }

    public void if(Graphics graphics, int n2, int n3) {
        this.a(graphics, n2, n3);
    }

    static {
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        void = new int[32768];
        d = new short[32768];
        long = new short[32768][32];
        byte = new short[32768][32];
        case = new short[32768][32];
        b = new short[32768][32];
        g = new short[32768][32];
        f = new short[32768][32];
        char = new short[32768][32];
        int n9 = 0;
        do {
            n8 = n9 >> 10 & 0x1F;
            n7 = n9 >> 5 & 0x1F;
            n6 = n9 & 0x1F;
            a.b.c.void[n9] = 0xFF000000 | (n8 <<= 3) << 16 | (n7 <<= 3) << 8 | (n6 <<= 3);
        } while (++n9 < 32768);
        n9 = 0;
        do {
            n8 = n9 >> 10 & 0x1F;
            n7 = n9 >> 5 & 0x1F;
            n6 = n9 & 0x1F;
            n5 = 0;
            do {
                n4 = n8 * n5 / 31;
                n3 = n7 * n5 / 31;
                n2 = n6 * n5 / 31;
                a.b.c.long[n9][n5] = (short)(n4 << 10 | n3 << 5 | n2);
            } while (++n5 < 32);
        } while (++n9 < 32768);
        n9 = 0;
        do {
            n8 = n9 >> 10 & 0x1F;
            n7 = n9 >> 5 & 0x1F;
            n6 = n9 & 0x1F;
            n5 = (n8 * 3 + n7 * 6 + n6) / 10;
            a.b.c.d[n9] = (short)(n5 << 10 | n5 << 5 | n5);
        } while (++n9 < 32768);
        n9 = 0;
        do {
            n8 = n9 >> 10 & 0x1F;
            n7 = n9 >> 5 & 0x1F;
            n6 = n9 & 0x1F;
            n5 = 0;
            do {
                n4 = n8 + n5;
                n3 = n7 + n5;
                n2 = n6 + n5;
                if (n4 > 31) {
                    n4 = 31;
                }
                if (n3 > 31) {
                    n3 = 31;
                }
                if (n2 > 31) {
                    n2 = 31;
                }
                a.b.c.byte[n9][n5] = (short)(n4 << 10);
                a.b.c.case[n9][n5] = (short)(n3 << 5);
                a.b.c.b[n9][n5] = (short)n2;
            } while (++n5 < 32);
        } while (++n9 < 32768);
        n9 = 0;
        do {
            n8 = n9 >> 10 & 0x1F;
            n7 = n9 >> 5 & 0x1F;
            n6 = n9 & 0x1F;
            n5 = 0;
            do {
                n4 = n8 * n5 / 31;
                n3 = n7 * n5 / 31;
                n2 = n6 * n5 / 31;
                a.b.c.g[n9][n5] = (short)(n4 << 10);
                a.b.c.f[n9][n5] = (short)(n3 << 5);
                a.b.c.char[n9][n5] = (short)n2;
            } while (++n5 < 32);
        } while (++n9 < 32768);
    }

    public void do(af af2, int n2, int n3, int n4) {
        this.do(af2, n2, n3, 0, 0, af2.int(), af2.try(), n4);
    }

    public void do(af af2, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        if (n8 <= 8) {
            return;
        }
        if (n8 >= 248) {
            this.a(af2, n2, n3, n4, n5, n6, n7, 0, 0);
        } else {
            this.a(af2, n2, n3, n4, n5, n6, n7, 1, n8);
        }
    }

    public static final short do(int n2) {
        int n3 = n2 >> 16 & 0xFF;
        int n4 = n2 >> 8 & 0xFF;
        int n5 = n2 & 0xFF;
        return (short)((n3 >>= 3) << 10 | (n4 >>= 3) << 5 | (n5 >>= 3));
    }

    public int new() {
        return this.i.y;
    }

    public int a() {
        return this.int.height;
    }

    public void if(int n2) {
        if (this.a != null) {
            short s2 = a.b.c.do(n2);
            int n3 = 0;
            while (n3 < this.a.length) {
                this.a[n3] = s2;
                ++n3;
            }
        }
    }

    public void try() {
        this.if(0);
    }

    public void if() {
    }

    public void for(int n2) {
        if ((n2 = (n2 & 0xFF) / 8) >= 31) {
            return;
        }
        if (n2 == 0) {
            this.if(0);
        } else {
            int n3 = this.h.x;
            int n4 = this.h.y;
            int n5 = n3 + this.h.width;
            int n6 = n4 + this.h.height;
            int n7 = this.int.width * n4 + n3;
            int n8 = this.int.width - n3;
            int n9 = n4;
            while (n9 < n6) {
                int n10 = n3;
                while (n10 < n5) {
                    this.a[n7] = long[this.a[n7]][n2];
                    ++n10;
                    ++n7;
                }
                ++n9;
                n7 += n8;
            }
        }
    }

    public void if(af af2, int n2, int n3) {
        this.a(af2, n2, n3, 0, 0, af2.int(), af2.try(), 4, 0);
    }

    public void a(af af2, int n2, int n3, int n4, int n5, int n6, int n7) {
        this.a(af2, n2, n3, n4, n5, n6, n7, 4, 0);
    }

    public void a(Rectangle rectangle, int n2) {
        this.if(rectangle.x, rectangle.y, rectangle.width, rectangle.height, n2);
    }
}

