/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.q;
import a.b.s;
import b.a.c.b;

public class a8
extends s {
    private b ms;
    private String mt = "Loading...";

    public a8(b b2) {
        this.ms = b2;
        String string = b2.do().getParameter("loadSceneText");
        if (string != null && string.length() > 1) {
            this.mt = string;
        }
        this.enableEvents(16L);
    }

    public void a(c c2) {
        c2.a(0, 0, this.getWidth(), this.getHeight(), -16777216);
        int n2 = this.getWidth() / 2 - q.if(this.mt) / 2;
        int n3 = this.getHeight() / 2 - 12;
        c2.a(this.mt, n2, n3, -1);
    }
}

