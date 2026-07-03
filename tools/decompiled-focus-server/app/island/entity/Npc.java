/*
 * Decompiled with CFR 0.152.
 */
package app.island.entity;

import app.island.GameObject;
import app.island.entity.SceneObject;
import daff.a.e;

public class Npc
extends SceneObject {
    public int image;
    public String dialog = "";
    public String script = "";
    public int behaviorID;
    public transient boolean initialVisible = true;
    public transient boolean visible = true;

    public void readFrom(e e2) {
        super.readFrom(e2);
        this.image = e2.for();
        this.initialVisible = e2.c();
        this.visible = e2.c();
    }

    public void writeTo(e e2) {
        super.writeTo(e2);
        e2.a(this.image);
        e2.a(this.initialVisible);
        e2.a(this.visible);
    }

    public Npc() {
        this.objectType = 2;
    }

    public void copyFrom(GameObject gameObject) {
        super.copyFrom(gameObject);
        Npc npc = (Npc)gameObject;
        this.image = npc.image;
        this.initialVisible = npc.initialVisible;
        this.visible = npc.visible;
    }
}

