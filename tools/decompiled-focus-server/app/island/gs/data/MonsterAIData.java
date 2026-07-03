/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.data;

import app.island.GameObject;
import app.island.data.DamageSpell;
import app.island.data.Spell;

public class MonsterAIData
extends GameObject {
    public int initialAliveness = 1;
    public int activationSceneTime;
    public int activationHeroCount;
    public int activationDeathCount;
    public int minReliveDelay;
    public int maxReliveDelay;
    public int reliveRange;
    public int maxReliveTimes;
    public int noticeRangeOnRelived;
    public String wordsOfNotice = "";
    public int randomMoveRange;
    public int randomMoveDelay;
    public int moveDestX;
    public int moveDestY;
    public int destRange;
    public int searchRange;
    public int searchDelay;
    public int lockTargetRate;
    public int preferredPKValue;
    public int preferredDistance;
    public int preferredLevel;
    public int preferredLife;
    public int preferredRace;
    public int fightRange;
    public int flyToTarget;
    public int flyToOrigin;
    public int fightOnReturn;
    public int hurtResponseDelay;
    public int changeTargetOnHurt;
    public int changeTragetOnAway;
    public int tracingTargetOnAway;
    public int maxTracingSteps;
    public int rateOfUsingSpellToAttack;
    public int rateOfRepeatingSpell;
    public DamageSpell[] attackSpells = new DamageSpell[5];
    public int[] useAttackSpellRates = new int[5];
    public int[] lifeRatesOfUsingSpell = new int[5];
    public int[] spellTargetPriorities = new int[5];
    public transient int countOfAttackSpells;
    public int useCureSpellLifeRate;
    public int useCureSpellRate;
    public Spell cureSpell;
    public int[] statesResistance = new int[10];
    public int[] resistanceRates = new int[10];
    public transient int countOfStateResistance;
    public int escapeMinLife;
    public int escapeMaxHurt;
    public int escapeAttackerLevel;
    public int escapeRange;
    public int deathCounterValue;
    public int autoCureDelay;
    public int cureRate;
    public int enmityEnabled;
    public int enemyPriority;
    public int[] raceEnmityFactors = new int[3];
    public int nearDamageEnmityFactor;
    public int remoteDamageEnmityFactor;
    public int doubleDamageEnmityFactor;
    public int magicDamageEnmityFactor;
    public int physicalDamageEnmityFactor;

    public boolean setAttributeValue(String string, String string2) {
        if (string.equals("attackSpells")) {
            if (string2.length() > 1) {
                this.attackSpells[this.countOfAttackSpells] = (DamageSpell)Spell.getGlobalSpell(Integer.parseInt(string2));
                if (this.attackSpells[this.countOfAttackSpells] == null) {
                    System.out.println("attack spell not found:" + string2 + "/" + this.name);
                }
            }
        } else if (string.equals("useAttackSpellRates")) {
            if (string2.length() > 1) {
                this.useAttackSpellRates[this.countOfAttackSpells] = Integer.parseInt(string2);
            }
        } else if (string.equals("lifeRatesOfUsingSpell")) {
            if (string2.length() > 1) {
                this.lifeRatesOfUsingSpell[this.countOfAttackSpells] = Integer.parseInt(string2);
            }
        } else if (string.equals("spellTargetPriorities")) {
            if (string2.length() > 0) {
                this.spellTargetPriorities[this.countOfAttackSpells++] = Integer.parseInt(string2);
            }
        } else if (string.equals("cureSpell")) {
            if (string2.length() > 1) {
                this.cureSpell = Spell.getGlobalSpell(Integer.parseInt(string2));
                if (this.cureSpell == null) {
                    System.out.println("cure spell not found:" + string2);
                }
            }
        } else if (string.equals("statesResistance")) {
            this.statesResistance[this.countOfStateResistance] = Integer.parseInt(string2);
        } else if (string.equals("resistanceRates")) {
            this.resistanceRates[this.countOfStateResistance++] = Integer.parseInt(string2);
        } else if (string.equals("elfEnmityFactor")) {
            this.raceEnmityFactors[0] = Integer.parseInt(string2);
        } else if (string.equals("manEnmityFactor")) {
            this.raceEnmityFactors[1] = Integer.parseInt(string2);
        } else if (string.equals("orcEnmityFactor")) {
            this.raceEnmityFactors[2] = Integer.parseInt(string2);
        } else {
            return super.setAttributeValue(string, string2);
        }
        return true;
    }
}

