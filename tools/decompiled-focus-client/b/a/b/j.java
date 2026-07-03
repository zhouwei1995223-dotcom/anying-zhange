/*
 * Decompiled with CFR 0.152.
 */
package b.a.b;

import a.b.af;
import b.a.b.c;
import b.a.b.d;
import b.a.d.c;
import b.a.d.e;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public abstract class j
extends d {
    public static af B;
    public static af v;
    protected c.a A = new c.a();
    protected int x;
    protected c C;
    protected long D;
    protected long z;
    protected int u;
    protected int w = 60;
    protected int[] y = new int[]{4, 6, 8};

    public void a(int n2) {
        this.A.a = n2;
    }

    public void if(int n2, int n3, int n4) {
        this.A.int = n2;
        this.A.a = n3;
        this.A.if = n4;
        this.A.do = System.currentTimeMillis();
        this.x = 0;
    }

    public void for(int n2, int n3) {
        this.a(0, n2, n3);
    }

    public void c() {
        this.A.int = 0;
        this.A.if = 0;
        this.A.for = null;
    }

    public void int(int n2, int n3) {
        this.a(1, n2, n3);
    }

    public void for(a.b.c c2) {
        c c3 = this.C;
        while (c3 != null) {
            if (c3.char <= 0) {
                c3.a(c2, this.new - 32, this.for - 55);
            }
            c3 = c3.do;
        }
    }

    public abstract b.a.d.c b();

    private void new(long l2) {
    }

    private void try(long l2) {
    }

    public int do() {
        return 1;
    }

    private void int(long l2) {
        if (this.A.if == 0) {
            if (l2 - this.D > 60L) {
                ++this.x;
                this.D = l2;
            }
        } else if (l2 - this.A.do >= (long)this.A.if) {
            this.new = this.A.case;
            this.for = this.A.byte;
            this.do(l2);
        } else {
            int n2 = (int)(l2 - this.A.do);
            int n3 = this.A.try + (this.A.case - this.A.try) * n2 / this.A.if;
            int n4 = this.A.new + (this.A.byte - this.A.new) * n2 / this.A.if;
            this.a(n3, n4);
            this.x = n2 * this.y[1] / this.A.if;
        }
    }

    public int d() {
        return this.u;
    }

    public void if(int n2) {
        this.u = n2;
    }

    public void a(int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        if (this.byte == null) {
            return;
        }
        n3 = this.byte.try(n3);
        n4 = this.byte.int(n4);
        n5 = this.byte.try(n5);
        n6 = this.byte.int(n6);
        if (this.A == null) {
            this.A = new c.a(n2, n3, n4, n5, n6, n7, n8);
        } else if (this.A.int == 0 && this.A.if == 0) {
            this.A.int = n2;
            this.A.try = n3;
            this.A.new = n4;
            this.A.case = n5;
            this.A.byte = n6;
            this.A.a = n7;
            this.A.if = n8;
            this.A.do = System.currentTimeMillis();
            this.x = 0;
        } else {
            c.a a10 = this.A;
            while (a10 != null) {
                if (a10.for == null) {
                    a10.for = new c.a(n2, n3, n4, n5, n6, n7, n8);
                    a10.for.do = System.currentTimeMillis();
                    break;
                }
                a10 = a10.for;
            }
        }
    }

    public void a(c.a a10) {
        if (this.byte == null) {
            return;
        }
        a10.for = null;
        a10.do = 0L;
        a10.try = this.byte.try(a10.try);
        a10.new = this.byte.int(a10.new);
        a10.case = this.byte.try(a10.case);
        a10.byte = this.byte.int(a10.byte);
        if (this.A.int == 0 && this.A.if == 0) {
            this.A = a10;
        } else {
            c.a a11 = this.A;
            while (a11 != null) {
                if (a11.for == null) {
                    a11.for = a10;
                    break;
                }
                a11 = a11.for;
            }
        }
    }

    public int e() {
        return this.new;
    }

    private void do(long l2) {
        if (this.A.for == null) {
            this.A.int = 0;
            this.A.if = 0;
        } else {
            this.A = this.A.for;
            this.A.do = l2;
        }
        this.x = 0;
    }

    public void a(long l2) {
        l2 = System.currentTimeMillis();
        switch (this.A.int) {
            case 0: {
                this.for(l2);
                break;
            }
            case 1: {
                this.int(l2);
                break;
            }
            case 2: {
                this.if(l2);
                break;
            }
        }
        long l3 = l2 - this.z;
        c c2 = this.C;
        c c3 = null;
        while (c2 != null) {
            if (c2.char > 0) {
                c2.char = (int)((long)c2.char - l3);
            } else {
                if (c2.if >= 255) {
                    c2.a(this.b());
                }
                c2.if -= 3;
                c2.case -= 3;
                if (c2.if <= 0) {
                    if (c3 != null) {
                        c3.do = c2.do;
                    } else {
                        this.C = c2.do;
                    }
                }
            }
            c3 = c2;
            c2 = c2.do;
        }
        if (this.C == null && this.u != this.b().Q) {
            this.b().Q = this.u;
        }
        this.z = l2;
    }

    public void do(int n2, int n3, int n4, int n5, int n6) {
        this.a(1, n2, n3, n4, n5, e.a(n2, n3, n4, n5), n6);
    }

    private void for(long l2) {
        if (this.A.if == 0) {
            if (l2 - this.D > (long)this.w) {
                ++this.x;
                this.D = l2;
            }
        } else if (l2 - this.A.do > (long)this.A.if) {
            this.do(l2);
        } else if (l2 - this.D > (long)this.w) {
            ++this.x;
            this.D = l2;
        }
    }

    private void if(long l2) {
        if (this.A.if == 0) {
            if (l2 - this.D > 60L) {
                ++this.x;
                this.D = l2;
            }
        } else if (l2 - this.A.do >= (long)this.A.if) {
            this.do(l2);
        } else {
            int n2 = (int)(l2 - this.A.do);
            this.x = n2 * this.y[2] / this.A.if;
        }
    }

    public int long() {
        return this.A.int;
    }

    public void do(int n2, int n3) {
        this.a(2, n2, n3);
    }

    public int g() {
        return this.A.a;
    }

    public void a(int n2, int n3, int n4) {
        c c2 = new c(n2, n3, n4);
        int n5 = 0;
        if (n3 < 10) {
            n5 = 32;
        } else if (n3 < 100) {
            n5 = 48;
        } else if (n3 < 1000) {
            n5 = 64;
        } else if (n3 < 10000) {
            n5 = 80;
        } else if (n3 < 100000) {
            n5 = 96;
        }
        c2.else = 30 - n5 / 2;
        c2.case = 30;
        if (this.C == null) {
            this.C = c2;
        } else {
            c c3 = this.C;
            while (c3 != null) {
                if (c3.do == null) {
                    c3.do = c2;
                    break;
                }
                c3 = c3.do;
            }
        }
    }

    public void void() {
        this.C = null;
    }

    public void a(int n2, int n3) {
        if (n3 > this.for || n3 == this.for && n2 > this.new) {
            this.new = n2;
            this.for = n3;
            if (this.do != null) {
                this.do.if(this);
            }
        } else if (n3 < this.for || n3 == this.for && n2 < this.new) {
            this.new = n2;
            this.for = n3;
            if (this.do != null) {
                this.do.a(this);
            }
        }
    }

    public int f() {
        return this.for;
    }
}

