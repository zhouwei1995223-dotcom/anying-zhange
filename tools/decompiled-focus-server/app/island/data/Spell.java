/*
 * Decompiled with CFR 0.152.
 */
package app.island.data;

import app.island.GameObject;
import app.island.data.DamageSpell;
import app.island.data.SceneEffectSpell;
import app.island.data.TargetStateSpell;
import daff.a.e;
import daff.a.h;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class Spell
extends GameObject {
    public static long nextReleaseTime;
    private static h goto;
    public static final int SPELL_TYPE_DAMAGE = 1;
    public static final int SPELL_TYPE_TARGETSTATE = 2;
    public static final int SPELL_TYPE_SCENEEFFECT = 3;
    public int spellType;
    public int icon;
    public int flyerType;
    public int animation;
    public int timeLast;
    public int xExtHurtRange;
    public int yExtHurtRange;
    public int extHurtRangeFilled;
    public int lockAbility;
    public int level;
    public int experience;
    public int maxExperience;
    public int nextLevelSpellID;
    public int requiredLevel;
    public int requiredTurn;
    public int manaCost;
    public int selfCoolTime = 1000;
    public int globalCoolTime = 500;
    public int releaseRange = 5;
    public String description;
    public transient long startCoolTime;
    public transient int coolLastTime;
    public transient int coolPercent = 24;

    public void readFrom(e e2) {
        super.readFrom(e2);
        this.icon = e2.case();
        this.lockAbility = e2.case();
        this.level = e2.case();
        this.experience = e2.i();
        this.maxExperience = e2.i();
        this.nextLevelSpellID = e2.i();
        this.requiredLevel = e2.for();
        this.manaCost = e2.j();
        this.selfCoolTime = e2.do() * 100;
        this.globalCoolTime = e2.for() * 100;
        this.releaseRange = e2.for();
        this.description = e2.h();
    }

    public static void setGlobalSpellList(h h2) {
        goto = h2;
    }

    public void writeTo(e e2) {
        super.writeTo(e2);
        e2.a(this.icon);
        e2.a(this.lockAbility);
        e2.a(this.level);
        e2.char(this.experience);
        e2.char(this.maxExperience);
        e2.char(this.nextLevelSpellID);
        e2.a(this.requiredLevel);
        e2.for(this.manaCost);
        e2.for(this.selfCoolTime / 100);
        e2.a(this.globalCoolTime / 100);
        e2.a(this.releaseRange);
        e2.a(this.description);
    }

    public static final Spell createSpellByType(int n2) {
        switch (n2) {
            case 1: {
                return new DamageSpell();
            }
            case 2: {
                return new TargetStateSpell();
            }
            case 3: {
                return new SceneEffectSpell();
            }
        }
        return null;
    }

    public void copyFrom(GameObject gameObject) {
        super.copyFrom(gameObject);
        Spell spell = (Spell)gameObject;
        this.icon = spell.icon;
        this.flyerType = spell.flyerType;
        this.animation = spell.animation;
        this.timeLast = spell.timeLast;
        this.xExtHurtRange = spell.xExtHurtRange;
        this.yExtHurtRange = spell.yExtHurtRange;
        this.extHurtRangeFilled = spell.extHurtRangeFilled;
        this.lockAbility = spell.lockAbility;
        this.level = spell.level;
        this.experience = spell.experience;
        this.maxExperience = spell.maxExperience;
        this.nextLevelSpellID = spell.nextLevelSpellID;
        this.requiredLevel = spell.requiredLevel;
        this.requiredTurn = spell.requiredTurn;
        this.manaCost = spell.manaCost;
        this.selfCoolTime = spell.selfCoolTime;
        this.globalCoolTime = spell.globalCoolTime;
        this.releaseRange = spell.releaseRange;
        this.description = spell.description;
    }

    public static final Spell getGlobalSpell(int n2) {
        int n3 = goto.for();
        int n4 = 0;
        while (n4 < n3) {
            Spell spell = (Spell)goto.if(n4);
            if (spell.id == n2) {
                return spell;
            }
            ++n4;
        }
        return null;
    }
}

