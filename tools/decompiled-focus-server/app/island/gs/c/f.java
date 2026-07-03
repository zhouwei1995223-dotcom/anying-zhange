/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.c;

import app.island.entity.Guild;
import app.island.gs.c.i;
import app.island.gs.e;
import app.island.gs.h;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class f
extends i {
    private h int;
    private h new;

    public f(h h2, h h3, String string) {
        this.int = h2;
        this.new = h3;
        this.a = string;
    }

    public void a(boolean bl) {
        this.if = 0L;
        if (!this.int.goto()) {
            this.new.try("\u9080\u8bf7\u8005\u5df2\u7ecf\u4e0b\u7ebf\u4e86");
            return;
        }
        if (!bl) {
            this.int.try(this.new.b() + "\u62d2\u7edd\u4e86\u4f60\u7684\u9080\u8bf7");
            return;
        }
        if (this.new.J() != null) {
            this.new.try("\u4f60\u5df2\u7ecf\u6709\u516c\u4f1a\u4e86");
            return;
        }
        Guild guild = this.int.r().joinedGuild;
        if (guild == null) {
            this.int.try("\u4f60\u7684\u516c\u4f1a\u5df2\u7ecf\u89e3\u6563\u4e86");
            this.new.try("\u5bf9\u65b9\u7684\u516c\u4f1a\u5df2\u7ecf\u89e3\u6563\u4e86");
            return;
        }
        if (this.int.r().guildPosition < 1 || this.int.r().guildPosition > 2) {
            this.int.try("\u4f60\u6ca1\u6709\u6743\u9650\u9080\u8bf7\u4f1a\u5458");
            this.new.try(this.int.b() + "\u6ca1\u6709\u6743\u9650\u9080\u8bf7\u4f1a\u5458");
            return;
        }
        if (guild.memberList.for() >= guild.memberCapacity) {
            this.int.try("\u4f60\u7684\u516c\u4f1a\u4eba\u6570\u5df2\u6ee1\uff01");
            this.new.try("\u65e0\u6cd5\u52a0\u5165\u516c\u4f1a\uff0c\u4eba\u6570\u5df2\u7ecf\u8fbe\u5230\u4e0a\u9650");
            return;
        }
        e e2 = (e)guild.attachment;
        if (e2 != null) {
            e2.e(this.new);
        }
    }

    public boolean a(h h2) {
        return h2 == this.new;
    }

    public void do() {
        if (this.if > 0L) {
            this.int.try("\u5bf9\u65b9\u6ca1\u6709\u56de\u5e94\u4f60\u7684\u9080\u8bf7");
        }
    }
}

