/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.c;

import app.island.gs.b;
import app.island.gs.c.i;
import app.island.gs.h;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class d
extends i {
    private h do;
    private h for;

    public d(h h2, h h3, String string) {
        this.do = h2;
        this.for = h3;
        this.a = string;
    }

    public void a(boolean bl) {
        this.if = 0L;
        if (!this.do.goto()) {
            this.for.try("\u9080\u8bf7\u8005\u5df2\u7ecf\u4e0b\u7ebf\u4e86");
            return;
        }
        if (!bl) {
            this.do.try(this.for.b() + "\u62d2\u7edd\u4e86\u4f60\u7684\u9080\u8bf7");
            return;
        }
        if (this.for.x() != null) {
            this.for.try("\u4f60\u5df2\u7ecf\u6709\u961f\u4f0d\u4e86");
            return;
        }
        b b2 = this.do.x();
        if (b2 != null && b2.else() != this.do) {
            this.for.try(this.do.b() + "\u52a0\u5165\u4e86\u522b\u7684\u961f\u4f0d");
            return;
        }
        if (b2 != null && !b2.for(this.for)) {
            this.do.try("\u4f60\u7684\u961f\u4f0d\u4eba\u6570\u5df2\u5230\u4e0a\u9650");
            this.for.try("\u52a0\u5165\u5931\u8d25\uff0c\u961f\u4f0d\u5df2\u6ee1");
            return;
        }
        if (b2 == null) {
            b2 = new b();
            b2.case(this.do);
            this.do.j().do().a(b2);
        }
        b2.if(this.for);
    }

    public boolean a(h h2) {
        return h2 == this.for;
    }

    public void do() {
        if (this.if > 0L) {
            this.do.try("\u5bf9\u65b9\u6ca1\u6709\u56de\u5e94\u4f60\u7684\u9080\u8bf7");
        }
    }
}

