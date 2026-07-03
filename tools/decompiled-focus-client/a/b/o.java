/*
 * Decompiled with CFR 0.152.
 */
package a.b;

import a.b.b;
import a.b.c;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class o
implements b {
    private int for;
    private char[][] byte = new char[10][];
    private int new;
    private int try;
    private int case;
    private int int = 14;

    public o(String string, int n2, int n3) {
        this(string, n2, n3, 24);
    }

    public o(String string, int n2, int n3, int n4) {
        this.for = n3;
        this.case = n4;
        int n5 = string.length();
        int n6 = n4;
        int n7 = 0;
        int n8 = 0;
        char[] cArray = new char[128];
        int n9 = 0;
        while (n9 < n5) {
            int n10;
            char c2 = string.charAt(n9);
            int n11 = n10 = c2 > '\u007f' ? 12 : 6;
            if (n10 + n6 > n2) {
                this.byte[n7] = new char[n8];
                System.arraycopy(cArray, 0, this.byte[n7], 0, n8);
                ++n7;
                n8 = 0;
                n6 = 0;
            }
            cArray[n8++] = c2;
            n6 += n10;
            ++n9;
        }
        if (n8 > 0) {
            this.byte[n7] = new char[n8];
            System.arraycopy(cArray, 0, this.byte[n7], 0, n8);
        }
        n9 = this.new = n7 + 1;
        while (n9 < this.byte.length) {
            this.byte[n9] = null;
            ++n9;
        }
        this.try = n2;
    }

    public void a(c c2, int n2, int n3, int n4, int n5) {
        c2.a(this.byte[0], 0, this.byte[0].length, n2 + this.case, n3, this.for);
        n3 += this.int;
        int n6 = 1;
        while (n6 < this.new) {
            c2.a(this.byte[n6], 0, this.byte[n6].length, n2, n3, this.for);
            ++n6;
            n3 += 14;
        }
    }

    public int if() {
        return this.new * this.int;
    }

    public int for() {
        return this.int;
    }

    public void a(int n2) {
        this.int = n2;
    }

    public int a() {
        return this.try;
    }
}

