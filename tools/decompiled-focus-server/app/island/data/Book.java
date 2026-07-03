/*
 * Decompiled with CFR 0.152.
 */
package app.island.data;

import app.island.GameObject;
import app.island.data.Goods;
import daff.a.e;

public class Book
extends Goods {
    public int targetSpellID;
    public int requiredRace;
    public int requiredTurn;
    public int requiredLevel;
    public int sourceSpellID;

    public void readFrom(e e2) {
        super.readFrom(e2);
        this.targetSpellID = e2.i();
        this.requiredRace = e2.case();
        this.requiredTurn = e2.case();
        this.requiredLevel = e2.for();
        this.description = e2.h();
    }

    public void writeTo(e e2) {
        super.writeTo(e2);
        e2.char(this.targetSpellID);
        e2.a(this.requiredRace);
        e2.a(this.requiredTurn);
        e2.a(this.requiredLevel);
        e2.a(this.description);
    }

    public Book() {
        this.goodsType = 4;
    }

    public void copyFrom(GameObject gameObject) {
        super.copyFrom(gameObject);
        Book book = (Book)gameObject;
        this.targetSpellID = book.targetSpellID;
        this.requiredRace = book.requiredRace;
        this.requiredTurn = book.requiredTurn;
        this.requiredLevel = book.requiredLevel;
        this.sourceSpellID = book.sourceSpellID;
    }
}

