/*
 * Decompiled with CFR 0.152.
 */
package app.island.data;

import app.island.GameObject;
import app.island.data.Goods;
import daff.a.e;

public class Medicine
extends Goods {
    public int lifeCured;
    public int manaCured;
    public int useCount;
    public int delayTime;
    public transient long lastUsedTime;

    public void readFrom(e e2) {
        super.readFrom(e2);
        this.lifeCured = e2.do();
        this.manaCured = e2.do();
        this.useCount = e2.case();
        this.delayTime = e2.for() * 100;
    }

    public void writeTo(e e2) {
        super.writeTo(e2);
        e2.for(this.lifeCured);
        e2.for(this.manaCured);
        e2.a(this.useCount);
        e2.a(this.delayTime / 100);
    }

    public Medicine() {
        this.goodsType = 0;
    }

    public void copyFrom(GameObject gameObject) {
        super.copyFrom(gameObject);
        Medicine medicine = (Medicine)gameObject;
        this.lifeCured = medicine.lifeCured;
        this.manaCured = medicine.manaCured;
        this.useCount = medicine.useCount;
        this.delayTime = medicine.delayTime;
    }
}

