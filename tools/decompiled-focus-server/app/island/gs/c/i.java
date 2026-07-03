/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.c;

import app.island.gs.ServerInfo;
import app.island.gs.h;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public abstract class i {
    protected String a;
    protected long if;

    public abstract void a(boolean var1);

    public void a(long l2) {
        this.if = l2;
    }

    public void for() {
    }

    public abstract boolean a(h var1);

    public String if() {
        return this.a;
    }

    public abstract void do();

    public boolean a() {
        return ServerInfo.currentMilliSecond - this.if < 30000L;
    }
}

