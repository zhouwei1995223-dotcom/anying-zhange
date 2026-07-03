/*
 * Decompiled with CFR 0.152.
 */
package app.island.data;

import app.island.GameObject;
import app.island.data.Spell;
import daff.a.e;

public class TargetStateSpell
extends Spell {
    public int stateType;
    public int stateID;
    public int successRate;

    public void readFrom(e e2) {
        super.readFrom(e2);
        this.stateType = e2.for();
        this.successRate = e2.for();
    }

    public void writeTo(e e2) {
        super.writeTo(e2);
        e2.a(this.stateType);
        e2.a(this.successRate);
    }

    public TargetStateSpell() {
        this.lockAbility = 1;
        this.spellType = 2;
    }

    public void copyFrom(GameObject gameObject) {
        super.copyFrom(gameObject);
        TargetStateSpell targetStateSpell = (TargetStateSpell)gameObject;
        this.stateType = targetStateSpell.stateType;
        this.stateID = targetStateSpell.stateID;
        this.successRate = targetStateSpell.successRate;
    }
}

