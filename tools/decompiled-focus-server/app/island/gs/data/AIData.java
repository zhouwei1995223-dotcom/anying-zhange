/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.data;

import app.island.GameObject;
import app.island.data.Spell;

public class AIData
extends GameObject {
    public int initialAliveness = 1;
    public int activationSceneTime;
    public int activationHeroCount;
    public int activationDeathCount;
    public int minReliveDelay;
    public int maxReliveDelay;
    public int reliveRange;
    public int maxReliveTimes;
    public int randomMoveRange;
    public int randomMoveDelay;
    public int moveDestX;
    public int moveDestY;
    public int destRange;
    public int searchRange;
    public int searchDelay;
    public int lockTargetRate;
    public int preferredDistance;
    public int preferredLevel;
    public int preferredLife;
    public int preferredRace;
    public int fightRange;
    public int flyToOrigin;
    public int fightOnReturn;
    public int hurtResponseDelay;
    public int changeTargetOnHurt;
    public int changeTragetOnAway;
    public int tracingTargetOnAway;
    public int maxTracingSteps;
    public int useAttackSpellRate;
    public Spell[] attackSpells = new Spell[4];
    public int countOfAttackSpells;
    public int useCureSpellMinLife;
    public int useCureSpellRate;
    public Spell cureSpell;
    public int escapeMinLife;
    public int escapeMaxHurt;
    public int escapeAttackerLevel;
    public int escapeRange;
    public int deathCounterValue;
    public int autoCureDelay;
    public int cureRate;

    public boolean setAttributeValue(String string, String string2) {
        if (string.equals("attackSpells")) {
            return true;
        }
        if (string.equals("cureSpell")) {
            return true;
        }
        return super.setAttributeValue(string, string2);
    }
}

