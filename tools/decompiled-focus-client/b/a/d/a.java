/*
 * Decompiled with CFR 0.152.
 */
package b.a.d;

import a.a.e;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class a {
    private byte[][] if;
    private int a = 40;
    private int do = 30;

    public a() {
    }

    public a(int n2, int n3) {
        this.if = new byte[n3][n2];
        int n4 = 0;
        while (n4 < n3) {
            int n5 = 0;
            while (n5 < n2) {
                this.if[n4][n5] = 127;
                ++n5;
            }
            ++n4;
        }
    }

    public int for(int n2, int n3) {
        if (n3 < this.if.length && n3 >= 0 && n2 >= 0 && n2 < this.if[n3].length) {
            return this.if[n3][n2];
        }
        return 0;
    }

    public void a(int n2, int n3, int n4) {
        if (n3 < this.if.length && n3 >= 0 && n2 >= 0 && n2 < this.if[n3].length) {
            this.if[n3][n2] = (byte)n4;
        }
    }

    public void a(e e2) {
        int n2 = e2.j();
        int n3 = e2.j();
        this.if = new byte[n3][n2];
        int n4 = 0;
        while (n4 < n3) {
            int n5 = 0;
            while (n5 < n2) {
                this.if[n4][n5] = (byte)e2.case();
                ++n5;
            }
            ++n4;
        }
    }

    public a if() {
        a a10 = new a();
        a10.a = this.a;
        a10.do = this.do;
        a10.if = new byte[this.if.length][this.if[0].length];
        int n2 = 0;
        while (n2 < this.if.length) {
            int n3 = 0;
            while (n3 < this.if[n2].length) {
                a10.if[n2][n3] = this.if[n2][n3];
                ++n3;
            }
            ++n2;
        }
        return a10;
    }

    public int do() {
        return this.a;
    }

    public boolean if(int n2, int n3) {
        return (this.for(n2, n3) & 2) != 0;
    }

    public void if(e e2) {
        e2.for(this.if[0].length);
        e2.for(this.if.length);
        int n2 = 0;
        while (n2 < this.if.length) {
            int n3 = 0;
            while (n3 < this.if[n2].length) {
                e2.a(this.if[n2][n3]);
                ++n3;
            }
            ++n2;
        }
    }

    public int a() {
        return this.do;
    }

    public void a(int n2, int n3) {
        this.a = n2;
        this.do = n3;
    }

    public int new() {
        return this.if.length;
    }

    public int for() {
        return this.if[0].length;
    }

    public byte[][] int() {
        return this.if;
    }

    public boolean do(int n2, int n3) {
        return (this.for(n2, n3) & 1) != 0;
    }
}

