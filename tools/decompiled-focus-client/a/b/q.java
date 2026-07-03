/*
 * Decompiled with CFR 0.152.
 */
package a.b;

import a.b.b;
import a.b.c;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class q
implements b {
    private static final int char = 6;
    private static final int void = 12;
    private String c;
    private int goto;
    private int else;
    private int long;
    private int b;

    public static final int if(String string) {
        int n2 = string.length();
        int n3 = n2 * 6;
        int n4 = 0;
        while (n4 < n2) {
            char c2 = string.charAt(n4);
            if (c2 > '\u007f') {
                n3 += 6;
            }
            ++n4;
        }
        return n3;
    }

    public q(String string) {
        this(string, -16777216);
    }

    public q(String string, int n2) {
        this(string, n2, 0);
    }

    public q(String string, int n2, int n3) {
        this.do(string);
        this.if(n2);
        this.do(n3);
    }

    public int try() {
        return this.long;
    }

    public void if(int n2) {
        this.long = n2;
    }

    public String new() {
        return this.c;
    }

    public void do(String string) {
        this.c = string;
        this.goto = q.if(string);
        this.else = 12;
    }

    public void a(c c2, int n2, int n3, int n4, int n5) {
        if (this.b != 0) {
            c2.a(n2, n3, this.goto, this.else, this.b);
        }
        c2.a(this.c, n2, n3, this.long);
    }

    public int int() {
        return this.b;
    }

    public void do(int n2) {
        this.b = n2;
    }

    public int if() {
        return this.else;
    }

    public int a() {
        return this.goto;
    }

    public static final int a(char c2) {
        if (c2 > '\u007f') {
            return 12;
        }
        return 6;
    }
}

