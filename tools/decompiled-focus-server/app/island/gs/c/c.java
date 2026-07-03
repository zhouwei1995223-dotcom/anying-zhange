/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.c;

import app.island.entity.Hero;
import app.island.gs.c.i;
import app.island.gs.h;
import app.island.gs.p;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class c
extends i {
    private h else;
    private h goto;

    public c(h h2, h h3, String string) {
        this.else = h2;
        this.goto = h3;
        this.a = string;
    }

    public void a(boolean bl) {
        this.if = 0L;
        if (!this.else.goto()) {
            this.goto.try("\u9080\u8bf7\u8005\u5df2\u7ecf\u4e0b\u7ebf\u4e86");
            return;
        }
        if (!bl) {
            this.else.try(this.goto.b() + "\u62d2\u7edd\u4e86\u4f60\u7684\u9080\u8bf7");
            return;
        }
        Hero hero = this.goto.r();
        if (hero.level >= this.else.r().level) {
            return;
        }
        if (hero.friendList.master != null) {
            this.else.try("\u5bf9\u65b9\u5df2\u7ecf\u6709\u5e08\u7236\u4e86");
            this.goto.try("\u4f60\u5df2\u7ecf\u6709\u5e08\u7236\u4e86");
            return;
        }
        if (hero.friendList.studentCount > 0) {
            this.else.try("\u5bf9\u65b9\u5df2\u7ecf\u662f\u5e08\u7236\u4e86\uff0c\u4e0d\u80fd\u6210\u4e3a\u4f60\u7684\u5f92\u5f1f");
            this.goto.try("\u4f60\u5df2\u7ecf\u662f\u5e08\u7236\u4e86\uff0c\u4e0d\u80fd\u6210\u4e3a\u5f92\u5f1f");
            return;
        }
        hero.friendList.addMaster(this.else.r());
        this.else.r().friendList.addStudent(this.goto.r());
        this.goto.a(this.else.r());
        this.goto.a(p.long(this.else.r()));
        this.else.a(p.do(hero));
        this.else.j().do().a(p.d("\u606d\u559c\u3010" + this.else.b() + "\u3011\u62db\u6536\u3010" + hero.name + "\u3011\u4e3a\u5f92\u5f1f"));
        this.else.j().a(p.char(this.goto.H(), 5, 3));
    }

    public boolean a(h h2) {
        return h2 == this.goto;
    }

    public void do() {
        if (this.if > 0L) {
            this.else.try("\u5bf9\u65b9\u6ca1\u6709\u56de\u5e94\u4f60\u7684\u9080\u8bf7");
        }
    }
}

