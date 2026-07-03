/*
 * Decompiled with CFR 0.152.
 */
package app.island.entity;

import app.island.entity.SceneObject;
import daff.a.e;

public class Door
extends SceneObject {
    public int levelRequired;
    public int raceRequired;
    public int destSceneID;
    public int destX;
    public int destY;

    public void readFrom(e e2) {
        super.readFrom(e2);
        this.levelRequired = e2.for();
        this.raceRequired = e2.for();
        this.destSceneID = e2.i();
        this.destX = e2.for();
        this.destY = e2.for();
    }

    public void writeTo(e e2) {
        super.writeTo(e2);
        e2.a(this.levelRequired);
        e2.a(this.raceRequired);
        e2.char(this.destSceneID);
        e2.a(this.destX);
        e2.a(this.destY);
    }

    public Door() {
        this.objectType = 7;
    }
}

