/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.npc;

import app.island.gs.h;
import app.island.gs.q;

public abstract class NpcScript {
    protected q a;

    public q getController() {
        return this.a;
    }

    public void setController(q q2) {
        this.a = q2;
    }

    public void update() {
    }

    public void init() {
    }

    public abstract void processCommand(String var1, h var2);

    public String getResponseDailogEntry(h h2) {
        return null;
    }
}

