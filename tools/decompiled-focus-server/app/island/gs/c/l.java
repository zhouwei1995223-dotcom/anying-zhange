/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.c;

import app.island.gs.c.i;
import app.island.gs.e;
import app.island.gs.h;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class l
extends i {
    private h case;
    private h char;

    public l(h h2, h h3, String string) {
        this.case = h2;
        this.char = h3;
        this.a = string;
    }

    public void a(boolean bl) {
        this.if = 0L;
        if (!this.char.goto()) {
            this.case.try("\u7533\u8bf7\u4eba\u5df2\u7ecf\u4e0b\u7ebf\u4e86");
            return;
        }
        if (!bl) {
            this.char.try(this.case.b() + "\u62d2\u7edd\u4e86\u4f60\u7684\u7533\u8bf7");
            return;
        }
        if (this.char.J() != null) {
            this.char.try("\u4f60\u5df2\u7ecf\u6709\u516c\u4f1a\u4e86");
            return;
        }
        e e2 = this.case.J();
        if (e2 == null) {
            this.case.try("\u4f60\u7684\u516c\u4f1a\u5df2\u7ecf\u89e3\u6563\u4e86");
            this.char.try(this.case.b() + "\u7684\u516c\u4f1a\u5df2\u7ecf\u89e3\u6563\u4e86");
            return;
        }
        if (this.case.r().guildPosition < 1 || this.case.r().guildPosition > 2) {
            this.case.try("\u4f60\u6ca1\u6709\u62db\u6536\u4f1a\u5458\u7684\u6743\u9650");
            this.char.try(this.case.b() + "\u6ca1\u6709\u62db\u6536\u4f1a\u5458\u7684\u6743\u9650");
            return;
        }
        if (e2.b()) {
            this.case.try("\u4f60\u7684\u516c\u4f1a\u4e0d\u80fd\u5bb9\u7eb3\u66f4\u591a\u7684\u4f1a\u5458\u4e86");
            this.char.try(this.case.b() + "\u7684\u516c\u4f1a\u4e0d\u80fd\u5bb9\u7eb3\u66f4\u591a\u7684\u4f1a\u5458\u4e86");
            return;
        }
        e2.e(this.char);
    }

    public boolean a(h h2) {
        return h2 == this.case;
    }

    public void do() {
        if (this.if > 0L) {
            this.char.try("\u5bf9\u65b9\u6ca1\u6709\u56de\u5e94\u4f60\u7684\u7533\u8bf7");
        }
    }
}

