/*
 * Decompiled with CFR 0.152.
 */
package app.island.entity;

import app.island.data.FightState;
import app.island.entity.Guild;
import app.island.entity.Sprite;
import daff.a.e;

public class Sign
extends Sprite {
    public int image;
    public transient Guild targetGuild;
    public transient int sceneID;
    public transient String sceneName;
    public transient int stateID;
    public transient FightState fightState;
    public transient long lastAddReputationTime;

    public void readFrom(e e2) {
        super.readFrom(e2);
        this.image = e2.for();
    }

    public void writeTo(e e2) {
        super.writeTo(e2);
        e2.a(this.image);
    }

    public Sign() {
        this.objectType = 6;
    }
}

