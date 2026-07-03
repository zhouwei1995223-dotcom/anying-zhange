/*
 * Decompiled with CFR 0.152.
 */
package app.island.entity;

import app.island.data.Goods;
import app.island.entity.SceneObject;
import daff.a.e;

public class GroundGoods
extends SceneObject {
    public int ownerID;
    public Goods data;
    public int goodsType;
    public int quality;
    public transient int remainedLifeTime;
    public transient int remainedProtectionTime;

    public void readFrom(e e2) {
        super.readFrom(e2);
        this.goodsType = e2.case();
        this.ownerID = e2.i();
        this.quality = e2.case();
    }

    public void writeTo(e e2) {
        super.writeTo(e2);
        e2.a(this.data.goodsType);
        e2.char(this.ownerID);
        if (e2.if() > 0) {
            e2.a(this.data.quality);
        }
    }

    public GroundGoods() {
        this.objectType = 4;
    }
}

