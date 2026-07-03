/*
 * Decompiled with CFR 0.152.
 */
package app.island.entity;

import app.island.entity.SceneObject;
import daff.a.e;

public class EffectObject
extends SceneObject {
    public int layer = 1;
    public int animation;
    public int lifeTime = Integer.MAX_VALUE;
    public int maxLifeTime;
    public int hpPerTime;
    public int delayTime = 800;
    public transient int enmityFactor;
    public transient int markedID;
    public transient long lastDamageTime;
    public transient Object userData;

    public void readFrom(e e2) {
        super.readFrom(e2);
        this.layer = e2.case();
        this.animation = e2.case();
        this.lifeTime = e2.j();
        this.maxLifeTime = e2.j();
    }

    public void writeTo(e e2) {
        super.writeTo(e2);
        e2.a(this.layer);
        e2.a(this.animation);
        e2.for(this.lifeTime);
        e2.for(this.maxLifeTime);
    }

    public EffectObject() {
        this.objectType = 5;
    }
}

