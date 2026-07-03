/*
 * Decompiled with CFR 0.152.
 */
package b.a.b;

import a.a.e;
import a.b.af;
import a.b.c;
import a.b.f;
import a.b.s;
import a.b.v;
import b.a.b.d;
import b.a.b.h;
import b.a.b.l;
import b.a.b.r;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class q {
    public static final int a = 1;
    public static final int g = 2;
    public static final af[] long = new af[1200];
    private static final af if = new f(0, 0);
    private static final int[] case = new int[]{0x270000, 3473448, 4194358, 5439553, 6291540, 6553697, 0x660065, 8323175, 0x830080, 0x840084, 0x850085, 0x860086, 9240711, 9765006, 10813590, 12452006, 13172927, 13435082, 0xCE00CE, 0xCF00CF, 0xD500D0, 14352598, 14680284, 0xE100E1, 0xE200E2, 0xE300E3, 15139044, 0xE800E8, 16056553, 16449782, 16843004, 18219266, 18350359, 18481433, 18612507, 18743581, 19005727, 19071267, 19661092, 20185389, 20578613, 20644155, 20971836, 0x1440141, 21758277, 22151501, 23920979, 24445294, 25035126, 25100671, 25559424, 25690503, 26149257, 27263376, 0x1A101A1, 27918754, 28508587, 29098420, 29688253, 30605766, 30867924, 31261144, 31916510, 33423848, 33554943, 34210305, 35455499, 37290526, 37356090, 37421627, 38470204, 40436300, 42402410, 42664584, 42730124, 43451021, 43516568, 0x2990299, 44434074, 45286055, 45417140, 45482678, 47186615, 47448785, 47514325, 48235222, 49152737, 49545967, 49808117, 50463481, 0x3050303, 51184390, 51512078, 51839763, 51905304, 52364057, 53543712, 54330162, 55247678, 57738060, 66978674, 67372031, 67765253, 68027403, 68224015, 68355090, 68551700, 68748311, 68813850, 68879387, 71042076, 71894077, 72680522, 73729111, 74187879, 74646638, 74843252};
    protected a.a.h int = new a.a.h(4);
    protected s i;
    protected Rectangle e = new Rectangle();
    protected Dimension do = new Dimension(40, 30);
    protected Dimension f = new Dimension();
    protected Point h = new Point(-1, -1);
    protected d c;
    protected r new;
    protected h[] char = new h[]{new h(this, 0), new h(this, 1), new h(this, 2), new h(this, 3)};
    protected boolean void;
    protected boolean b;
    protected boolean d;
    long try;
    long for;
    private int goto;
    private int else;
    private long byte;

    public int try(int n2) {
        return n2 * this.do.width + this.do.width / 2;
    }

    private static void do(int n2) {
        if (--n2 < 0) {
            return;
        }
        if (long[n2] == null) {
            q.for(n2);
        }
        if (n2 >= 1 && n2 <= 13 && long[233] == null) {
            q.for(233);
        }
    }

    public int else() {
        return this.goto;
    }

    public void a(int n2, int n3) {
        this.goto = n2;
        this.else = n3;
        this.byte = 0L;
    }

    public int goto() {
        return this.e.width;
    }

    public s d() {
        return this.i;
    }

    public void a(s s2) {
        this.i = s2;
        if (s2 != null) {
            this.e.setSize(s2.getWidth(), s2.getHeight());
        }
    }

    public void do(d d2) {
        a.a.h h2 = this.int;
        synchronized (h2) {
            this.int.if(d2);
            Object var3_3 = null;
        }
    }

    public int if(int n2) {
        return n2 / this.do.height;
    }

    private static void for(int n2) {
        int n3 = 0;
        int n4 = 0;
        String string = null;
        int n5 = 0;
        while (n5 < case.length) {
            n3 = case[n5] & 0xFFFF;
            n4 = case[n5] >> 16;
            if (n2 >= n3 && n2 <= n4) {
                string = "pak/mapimg/" + n3 + "-" + n4 + ".zip";
                break;
            }
            ++n5;
        }
        if (string == null) {
            return;
        }
        if (b.a.c.e.a() != null) {
            b.a.c.e.a().a("map:" + n3 + "-" + n4);
            n5 = n3;
            while (n5 <= n4) {
                q.long[n5] = if;
                ++n5;
            }
        } else {
            v.if.int(string);
            n5 = n3;
            while (n5 <= n4) {
                q.long[n5] = v.if.if("image/map/" + n5 + ".img", false);
                ++n5;
            }
        }
    }

    public void a(long l2) {
        int n2;
        a.a.h h2 = this.int;
        synchronized (h2) {
            n2 = this.int.for();
            int n3 = 0;
            while (n3 < n2) {
                d d2 = (d)this.int.if(n3);
                this.for(d2);
                ++n3;
            }
            this.int.a();
            Object var7_7 = null;
        }
        if (this.try >= 0L) {
            this.for = l2 - this.try;
        }
        this.c = null;
        n2 = this.char.length - 1;
        while (n2 >= 0) {
            d d3 = this.char[n2].a(l2);
            if (this.c == null) {
                this.c = d3;
            }
            --n2;
        }
        this.new.a(l2);
        this.try = l2;
        if (this.goto > 0) {
            if (this.byte == 0L) {
                this.byte = l2;
            } else if (l2 - this.byte > (long)this.else) {
                this.goto = 0;
            }
        }
    }

    public void a(e e2) {
        int n2;
        int n3;
        int n4 = e2.j();
        int n5 = e2.j();
        this.new = new r(n4, n5, 60);
        this.new.a(long);
        this.f.setSize(n4 * 60, n5 * 60);
        int n6 = 0;
        while (n6 < n5) {
            n3 = 0;
            while (n3 < n4) {
                n2 = e2.j();
                if (n2 == 133) {
                    System.out.println("invalid tile:" + n3 + ";" + n6);
                    n2 = this.new.a(n3, n6 - 1);
                }
                q.do(n2);
                this.new.a(n3, n6, n2);
                ++n3;
            }
            ++n6;
        }
        int[] nArray = new int[3];
        nArray[1] = 1;
        nArray[2] = 3;
        int[] nArray2 = nArray;
        n3 = 0;
        do {
            n2 = e2.j();
            int n7 = nArray2[n3];
            int n8 = 0;
            while (n8 < n2) {
                int n9 = e2.j();
                int n10 = e2.j();
                int n11 = e2.j();
                if (q.a(n9)) {
                    q.do(n9);
                    l l2 = new l(n9 - 1, n10, n11);
                    l2.for(n7);
                    this.char[n7].do(l2);
                }
                ++n8;
            }
        } while (++n3 < 3);
    }

    public void if(boolean bl) {
        this.void = bl;
    }

    public boolean void() {
        return this.b;
    }

    public boolean if() {
        return this.d;
    }

    public void if(e e2) {
        int n2 = this.new.int();
        int n3 = this.new.try();
        e2.for(n2);
        e2.for(n3);
        int n4 = 0;
        while (n4 < n3) {
            int n5 = 0;
            while (n5 < n2) {
                e2.for(this.new.a(n5, n4));
                ++n5;
            }
            ++n4;
        }
        int[] nArray = new int[3];
        nArray[1] = 1;
        nArray[2] = 3;
        int[] nArray2 = nArray;
        a.a.h h2 = new a.a.h(1000);
        int n6 = 0;
        while (n6 < nArray2.length) {
            d d2;
            int n7 = nArray2[n6];
            h h3 = this.char[n7];
            h2.a();
            h3.a(h2);
            int n8 = h2.for();
            int n9 = 0;
            while (n9 < n8) {
                d2 = (d)h2.if(n9);
                if (!(d2 instanceof l)) {
                    h2.a(n9);
                    --n9;
                    --n8;
                }
                ++n9;
            }
            n8 = h2.for();
            e2.for(n8);
            n9 = 0;
            while (n9 < n8) {
                d2 = (l)h2.if(n9);
                e2.for(((l)d2).k() + 1);
                e2.for(d2.case());
                e2.for(d2.a());
                ++n9;
            }
            ++n6;
        }
    }

    private static boolean a(int n2) {
        return --n2 != 1133;
    }

    public void new(int n2, int n3) {
        this.f.setSize(n2, n3);
    }

    public int try() {
        return this.do.height;
    }

    public int new(int n2) {
        return n2 / this.do.width;
    }

    public d for(int n2, int n3) {
        int n4 = 0;
        while (n4 < this.char.length) {
            d d2 = this.char[n4].a(n2, n3);
            if (d2 != null) {
                return d2;
            }
            ++n4;
        }
        return null;
    }

    private void for(d d2) {
        int n2 = d2.do();
        if (n2 >= 0 && n2 < this.char.length) {
            this.char[n2].do(d2);
        }
    }

    public static final void a(c c2, String string, int n2, int n3, int n4) {
        c2.a(string, n2 - 1, n3, 0);
        c2.a(string, n2 + 1, n3, 0);
        c2.a(string, n2, n3 - 1, 0);
        c2.a(string, n2, n3 + 1, 0);
        c2.a(string, n2, n3, n4);
    }

    public int do() {
        return this.f.width;
    }

    public int c() {
        return this.h.y;
    }

    public int new() {
        return this.e.height;
    }

    public void a(int n2, int n3, int n4, int n5) {
        this.e.setBounds(n2, n3, n4, n5);
    }

    public void if(d d2) {
        d2.a(false);
    }

    public r a() {
        return this.new;
    }

    public int long() {
        return this.e.y;
    }

    public void a(r r2) {
        this.new = r2;
    }

    public void do(boolean bl) {
        this.b = bl;
    }

    public void a(boolean bl) {
        this.d = bl;
    }

    public int char() {
        return this.h.x;
    }

    public d case() {
        return this.c;
    }

    private void a(d d2) {
        int n2 = d2.do();
        if (n2 >= 0 && n2 < this.char.length) {
            this.char[n2].for(d2);
        }
    }

    public int int(int n2) {
        return n2 * this.do.height + this.do.height / 2;
    }

    public int b() {
        return this.do.width;
    }

    public int int() {
        return this.e.x;
    }

    public void a(c c2) {
        int n2 = this.e.x;
        int n3 = this.e.y;
        if (this.goto == 1) {
            n2 = (int)((double)n2 + (5.0 - Math.random() * 10.0));
            n3 = (int)((double)n3 + (5.0 - Math.random() * 10.0));
        }
        c2.do(-n2, -n3);
        this.new.a(c2, n2, n3, this.e.width, this.e.height);
        int n4 = 0;
        while (n4 < this.char.length) {
            if (n4 == 1) {
                this.char[n4].do(c2);
            }
            this.char[n4].a(c2);
            ++n4;
        }
        this.char[1].if(c2);
        if (this.void) {
            n4 = this.do.width;
            int n5 = this.do.height;
            int n6 = this.f.width;
            int n7 = this.f.height;
            while (n4 < n6) {
                c2.do(n4, 0, n4, this.f.height, -16711936);
                n4 += this.do.width;
            }
            while (n5 < n7) {
                c2.do(0, n5, this.f.width, n5, -16711936);
                n5 += this.do.height;
            }
        }
        c2.do(n2, n3);
        if (this.goto == 2) {
            c2.int();
        }
    }

    public void int(int n2, int n3) {
        this.do.setSize(n2, n3);
    }

    public int for() {
        return this.f.height;
    }

    public void if(int n2, int n3) {
        int n4 = this.e.width >> 1;
        int n5 = this.e.height >> 1;
        n3 -= n5;
        if ((n2 -= n4) < 0) {
            n2 = 0;
        } else if (n2 > this.f.width - this.e.width) {
            n2 = this.f.width - this.e.width;
        }
        if (n3 < 0) {
            n3 = 0;
        } else if (n3 > this.f.height - this.e.height) {
            n3 = this.f.height - this.e.height;
        }
        if (n2 != this.e.x || n3 != this.e.y) {
            this.e.x = n2;
            this.e.y = n3;
        }
    }

    public boolean byte() {
        return this.void;
    }

    public void do(int n2, int n3) {
        this.h.setLocation(n2, n3);
    }
}

