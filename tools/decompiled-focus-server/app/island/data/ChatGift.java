/*
 * Decompiled with CFR 0.152.
 */
package app.island.data;

import app.island.GameObject;
import app.island.data.Goods;
import daff.a.e;

public class ChatGift
extends Goods {
    public int cType;
    public int coverage = 3;
    public int timeLast;
    public int priority;
    public String text = "";

    public void readFrom(e e2) {
        super.readFrom(e2);
        this.cType = e2.for();
        this.coverage = e2.for();
        this.timeLast = e2.for();
        this.priority = e2.for();
        this.description = e2.h();
        this.text = e2.h();
    }

    public void writeTo(e e2) {
        super.writeTo(e2);
        e2.a(this.cType);
        e2.a(this.coverage);
        e2.a(this.timeLast);
        e2.a(this.priority);
        e2.a(this.description);
        e2.a(this.text);
    }

    public ChatGift() {
        this.goodsType = 7;
    }

    public void copyFrom(GameObject gameObject) {
        super.copyFrom(gameObject);
        ChatGift chatGift = (ChatGift)gameObject;
        this.cType = chatGift.cType;
        this.coverage = chatGift.coverage;
        this.timeLast = chatGift.timeLast;
        this.priority = chatGift.priority;
        this.text = chatGift.text;
    }
}

