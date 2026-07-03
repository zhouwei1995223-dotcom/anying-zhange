/*
 * Decompiled with CFR 0.152.
 */
package b.b;

import a.a.e;
import a.d.m;
import a.d.n;
import b.b.b;

public class a
implements m {
    public void a(n n2, e e2) {
        b b2 = (b)n2;
        if (b2 == null) {
            b2 = b.ay;
        }
        int n3 = b2.do();
        e e3 = b2.for();
        int n4 = e3 == null ? 0 : e3.goto();
        e2.for(n4);
        e2.for(n3);
        if (e3 != null) {
            int n5 = e3.long();
            e2.a(e3, n4);
            e3.case(n5);
        }
    }
}

