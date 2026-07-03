/*
 * Decompiled with CFR 0.152.
 */
package b.a.a;

import b.a.a.a;
import b.a.a.c;
import b.a.d.e;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class b
implements a {
    private c a;

    private int if(int n2, int n3, int n4, int n5) {
        int n6 = e.a(n2, n3, n4, n5);
        int n7 = n2;
        int n8 = n3;
        int n9 = -1;
        int n10 = -1;
        int n11 = 0;
        while ((n9 != n4 || n10 != n5) && n11 < 100) {
            int n12 = n6 % 8;
            n9 = n7 + e.do[n12];
            n10 = n8 + e.new[n12];
            if (this.a.a(n9, n10)) {
                n7 = n9;
                n8 = n10;
                n6 = e.a(n7, n8, n4, n5);
            } else if (++n6 > 15) {
                return Integer.MAX_VALUE;
            }
            ++n11;
        }
        return n11;
    }

    private int a(int n2, int n3, int n4, int n5) {
        int n6 = e.a(n2, n3, n4, n5);
        int n7 = n2;
        int n8 = n3;
        int n9 = -1;
        int n10 = -1;
        int n11 = 0;
        while ((n9 != n4 || n10 != n5) && n11 < 100) {
            int n12 = n6;
            if (n12 < 0) {
                n12 += 8;
            }
            if (this.a.a(n9 = n7 + e.do[n12], n10 = n8 + e.new[n12])) {
                n7 = n9;
                n8 = n10;
                n6 = e.a(n7, n8, n4, n5);
            } else if (--n6 < -8) {
                return Integer.MAX_VALUE;
            }
            ++n11;
        }
        return n11;
    }

    public int a(int n2, int n3, int n4, int n5, c c2) {
        int n6;
        int n7;
        this.a = c2;
        int n8 = e.a(n2, n3, n4, n5);
        int n9 = e.do[n8] + n2;
        if (c2.a(n9, n7 = e.new[n8] + n3)) {
            return n8;
        }
        int n10 = this.if(n2, n3, n4, n5);
        if (n10 == (n6 = this.a(n2, n3, n4, n5)) && n6 == Integer.MAX_VALUE) {
            return -1;
        }
        if (n10 < n6) {
            int n11 = 1;
            do {
                int n12;
                if (!c2.a(n9 = n2 + e.do[n12 = (n8 + n11) % 8], n7 = n3 + e.new[n12])) continue;
                return n12;
            } while (++n11 < 8);
        } else {
            int n13 = 1;
            do {
                int n14;
                if ((n14 = n8 - n13) < 0) {
                    n14 += 8;
                }
                if (!c2.a(n9 = n2 + e.do[n14], n7 = n3 + e.new[n14])) continue;
                return n14;
            } while (++n13 < 8);
        }
        return -1;
    }
}

