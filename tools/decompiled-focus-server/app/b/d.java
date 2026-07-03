/*
 * Decompiled with CFR 0.152.
 */
package app.b;

import app.b.b;
import daff.a.e;
import daff.net.m;

public class d
implements daff.net.e {
    public m a(e e2) {
        if (e2.if() < 4) {
            return null;
        }
        int n2 = e2.d();
        int n3 = e2.do();
        int n4 = e2.do();
        if (e2.if() < n3) {
            e2.case(n2);
            return null;
        }
        b b2 = new b(n4, n3);
        b2.for().a(e2, n3);
        return b2;
    }
}

