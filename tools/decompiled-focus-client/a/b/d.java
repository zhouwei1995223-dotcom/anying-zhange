/*
 * Decompiled with CFR 0.152.
 */
package a.b;

import a.b.b;
import a.b.c;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class d
implements b {
    private String do;
    private int a;
    private int if;

    public d(String string) {
        this.a(string);
    }

    public void a(c c2, int n2, int n3, int n4, int n5) {
        c2.a(n2 + 1, n3 + 1, this.a - 2, this.if - 2, -31);
        c2.if(n2, n3, this.a, this.if, -16777216);
        c2.a(this.do, n2 + 3, n3 + 3, 0);
    }

    public int if() {
        return this.if;
    }

    public int a() {
        return this.a;
    }

    public String do() {
        return this.do;
    }

    public void a(String string) {
        this.do = string;
        int n2 = string.length();
        int n3 = 0;
        int n4 = 0;
        while (n4 < n2) {
            char c2 = string.charAt(n4);
            n3 += c2 > '\u007f' ? 12 : 6;
            ++n4;
        }
        this.a = n3 + 6;
        this.if = 18;
    }
}

