/*
 * Decompiled with CFR 0.152.
 */
package app.island.data;

import app.island.GameObject;
import app.island.data.Spell;
import app.island.entity.Hero;
import daff.a.e;

public class SceneEffectSpell
extends Spell {
    public int effectType;
    public int effectAnimation;
    public int effectDelayTime;
    public int effectLifeTime;
    public int lifeChanged;
    public int strengthFactor;
    public int dexterityFactor;
    public int wisdomFactor;
    public int enmityFactor;

    public void readFrom(e e2) {
        super.readFrom(e2);
        this.effectType = e2.case();
        this.effectAnimation = e2.case();
        this.effectDelayTime = e2.j();
        this.effectLifeTime = e2.j();
        this.lifeChanged = e2.j();
        this.strengthFactor = e2.j();
        this.dexterityFactor = e2.j();
        this.wisdomFactor = e2.j();
    }

    public void writeTo(e e2) {
        super.writeTo(e2);
        e2.a(this.effectType);
        e2.a(this.effectAnimation);
        e2.for(this.effectDelayTime);
        e2.for(this.effectLifeTime);
        e2.for(this.lifeChanged);
        e2.for(this.strengthFactor);
        e2.for(this.dexterityFactor);
        e2.for(this.wisdomFactor);
    }

    public SceneEffectSpell() {
        this.spellType = 3;
    }

    public void copyFrom(GameObject gameObject) {
        super.copyFrom(gameObject);
        SceneEffectSpell sceneEffectSpell = (SceneEffectSpell)gameObject;
        this.effectType = sceneEffectSpell.effectType;
        this.effectAnimation = sceneEffectSpell.effectAnimation;
        this.effectDelayTime = sceneEffectSpell.effectDelayTime;
        this.effectLifeTime = sceneEffectSpell.effectLifeTime;
        this.lifeChanged = sceneEffectSpell.lifeChanged;
        this.strengthFactor = sceneEffectSpell.strengthFactor;
        this.dexterityFactor = sceneEffectSpell.dexterityFactor;
        this.wisdomFactor = sceneEffectSpell.wisdomFactor;
        this.enmityFactor = sceneEffectSpell.enmityFactor;
    }

    public int getLifeChanged(Hero hero) {
        return this.lifeChanged + this.strengthFactor * hero.strength / 100 + this.dexterityFactor * hero.dexterity / 100 + this.wisdomFactor * hero.wisdom / 100;
    }
}

