/*
 * Decompiled with CFR 0.152.
 */
package app.island.entity;

import app.island.GameObject;
import app.island.entity.Sprite;
import daff.a.e;

public class Monster
extends Sprite {
    public static final String[] GRADE_NAMES = new String[]{"\u666e\u901a\u602a", "\u5c0f\u5934\u76ee", "\u7cbe\u82f1\u602a", "\u5927BOSS", "\u53d8\u6001\u602a", "\u53d8\u6001\u602a"};
    public int image;
    public int flyerType;
    public int grade;
    public String description;
    public transient int monsterID;
    public transient int behaviorID;
    public transient int plunderID;
    public transient int reliveTimes;

    public void readFrom(e e2) {
        super.readFrom(e2);
        this.image = e2.for();
        this.flyerType = e2.case();
        this.grade = e2.case();
    }

    public int getBaseMaxMagicDamage() {
        return this.maxMagicDamage;
    }

    public void writeTo(e e2) {
        super.writeTo(e2);
        e2.a(this.image);
        e2.a(this.flyerType);
        e2.a(this.grade);
    }

    public Monster() {
        this.objectType = 1;
    }

    public void copyFrom(GameObject gameObject) {
        super.copyFrom(gameObject);
        Monster monster = (Monster)gameObject;
        this.image = monster.image;
        this.flyerType = monster.flyerType;
        this.grade = monster.grade;
        this.description = monster.description;
        this.monsterID = monster.monsterID;
        this.behaviorID = monster.behaviorID;
        this.plunderID = monster.plunderID;
    }

    public int getBaseMinPhysicalDamage() {
        return this.minPhysicalDamage;
    }

    public int getBaseMaxPhysicalDamage() {
        return this.maxPhysicalDamage;
    }

    public int getBaseMinMagicDamage() {
        return this.minMagicDamage;
    }
}

