/*
 * Decompiled with CFR 0.152.
 */
package app.island.data;

import app.island.GameObject;
import app.island.data.Goods;
import daff.a.e;

public class Material
extends Goods {
    public int grade;
    public int nextGradeID;
    public int level;
    public int nextLevelID;
    public int upgradeRate;
    public int poundage;
    public int function;

    public void readFrom(e e2) {
        super.readFrom(e2);
        this.grade = e2.for();
        this.level = e2.for();
        this.function = e2.for();
        this.description = e2.h();
    }

    public void writeTo(e e2) {
        super.writeTo(e2);
        e2.a(this.grade);
        e2.a(this.level);
        e2.a(this.function);
        e2.a(this.description);
    }

    public Material() {
        this.goodsType = 8;
    }

    public void copyFrom(GameObject gameObject) {
        super.copyFrom(gameObject);
        Material material = (Material)gameObject;
        this.grade = material.grade;
        this.nextGradeID = material.nextGradeID;
        this.level = material.level;
        this.nextLevelID = material.nextLevelID;
        this.upgradeRate = material.upgradeRate;
        this.poundage = material.poundage;
        this.function = material.function;
    }
}

