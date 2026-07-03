/*
 * Decompiled with CFR 0.152.
 */
package app.b;

import app.b.b;
import daff.a.e;
import daff.net.l;
import daff.net.m;

public class a
implements l {
    public void a(m m2, e e2) {
        b b2 = (b)m2;
        if (b2 == null) {
            b2 = b.ay;
        }
        int n2 = b2.do();
        e e3 = b2.for();
        int n3 = e3 == null ? 0 : e3.goto();
        e2.for(n3);
        e2.for(n2);
        if (e3 != null) {
            int n4 = e3.long();
            e2.a(e3, n3);
            e3.case(n4);
        }
    }
}

