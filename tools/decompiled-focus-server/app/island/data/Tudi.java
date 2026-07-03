/*
 * Decompiled with CFR 0.152.
 */
package app.island.data;

import app.island.GameObject;
import daff.a.e;

public class Tudi
extends GameObject {
    public int joinTime;
    public int closeness;
    public transient int race;
    public transient int level;
    public transient int turns;
    public transient boolean online = true;

    public void readFrom(e e2) {
        this.name = e2.h();
        this.joinTime = e2.i();
        this.closeness = e2.i();
        this.race = e2.for();
        this.level = e2.for();
        this.turns = e2.for();
        this.online = e2.c();
    }

    public void writeTo(e e2) {
        if (this.closeness > 10000) {
            this.closeness = 10000;
        }
        e2.a(this.name);
        e2.char(this.joinTime);
        e2.char(this.closeness);
        e2.a(this.race);
        e2.a(this.level);
        e2.a(this.turns);
        e2.a(this.online);
    }
}

