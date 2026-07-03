/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.c;

import app.island.gs.c.i;
import app.island.gs.h;
import app.island.gs.j;
import app.island.gs.p;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class k
extends i {
    private h try;
    private h byte;

    public k(h h2, h h3, String string) {
        this.try = h2;
        this.byte = h3;
        this.a = string;
    }

    public void a(boolean bl) {
        this.if = 0L;
        if (!this.try.goto()) {
            this.byte.try("\u9080\u8bf7\u8005\u5df2\u7ecf\u4e0b\u7ebf\u4e86");
            return;
        }
        if (!bl) {
            this.try.try(this.byte.b() + "\u62d2\u7edd\u4e86\u4f60\u7684\u9080\u8bf7");
            return;
        }
        if (this.try.j() != this.byte.j()) {
            this.byte.try(this.try.b() + "\u8ddf\u4f60\u4e0d\u5728\u540c\u4e00\u573a\u666f\uff0c\u65e0\u6cd5\u4ea4\u6613");
            return;
        }
        if (!this.try.j().a(this.try.m(), this.try.o(), this.byte.m(), this.byte.o())) {
            this.try.try("\u8ddd\u79bb\u592a\u8fdc\uff0c\u65e0\u6cd5\u4ea4\u6613");
            this.byte.try("\u8ddd\u79bb\u592a\u8fdc\uff0c\u65e0\u6cd5\u4ea4\u6613");
            return;
        }
        if (this.try.n() != null) {
            this.try.try("\u4f60\u6b63\u5728\u4ea4\u6613\u4e2d");
            return;
        }
        if (this.byte.n() != null) {
            this.try.try("\u5bf9\u65b9\u6b63\u5728\u548c\u5176\u4ed6\u4eba\u4ea4\u6613");
            this.byte.try("\u4f60\u5df2\u7ecf\u5728\u548c\u5176\u4ed6\u4eba\u4ea4\u6613\u4e86");
            return;
        }
        j j2 = new j(this.try, this.byte);
        this.try.j().do().a(j2);
        this.try.a(p.for(this.byte.b()));
        this.byte.a(p.for(this.try.b()));
    }

    public boolean a(h h2) {
        return h2 == this.byte;
    }

    public void do() {
        if (this.if > 0L) {
            this.try.try("\u5bf9\u65b9\u6ca1\u6709\u56de\u5e94\u4f60\u7684\u9080\u8bf7");
        }
    }
}

