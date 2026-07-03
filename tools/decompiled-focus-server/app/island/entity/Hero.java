/*
 * Decompiled with CFR 0.152.
 */
package app.island.entity;

import app.island.data.Depot;
import app.island.data.Fashion;
import app.island.data.FriendList;
import app.island.data.HeroTaskList;
import app.island.data.Shortcuts;
import app.island.data.SpellList;
import app.island.entity.Player;
import app.island.entity.User;
import daff.a.b;
import daff.a.e;

public class Hero
extends Player {
    public static final int[] EXP_TABLE = new int[256];
    public static final int[] MAX_LEVEL_TABLE = new int[]{60, 70, 80, 90, 100, 110, 120, 130, 255};
    public static final int[] UPGRADE_ADD_POINTS;
    public static final int[] STRENGTH_UPGRADE_QUOTIETY;
    public static final int[] DEXTERITY_UPGRADE_QUOTIETY;
    public static final int[] WISDOM_UPGRADE_QUOTIETY;
    public static final int[] TURN_ADD_POINTS;
    public static final int[] ORIGIN_STRENGTH;
    public static final int[] ORIGIN_DEXTERITY;
    public static final int[] ORIGIN_WISDOM;
    public static final int[] ORIGIN_LIFE;
    public static final int[] ORIGIN_MANA;
    public static final int ORIGIN_STEP_TIME = 600;
    public static final int ORIGIN_ATTACK_TIME = 1000;
    public static final int ORIGIN_ATTACK_DELAY = 500;
    public transient int expLuck;
    public transient int moneyLuck;
    public String password = "";
    public int experience;
    public int unassignedPoints;
    public int baseMinPhysicalDamage;
    public int baseMaxPhysicalDamage;
    public int baseMinMagicDamage;
    public int baseMaxMagicDamage;
    public int basePhysicalDefense;
    public int baseMagicDefense;
    public int raisedLife;
    public int raisedMana;
    public int consumedTreasure;
    public int earnedTreasure;
    public int payedTreasure;
    public int createdTime;
    public int deathCount;
    public int onlineTime;
    public int motionCount;
    public int monsterKills;
    public int loginCount;
    public int playerKills;
    public int arenaScores;
    public int answerTimes;
    public int openBoxTimes;
    public int refineTimes;
    public int trainingTimes;
    public int pkValue;
    public int guildID;
    public int onlineExpLifeTime;
    public int onlineExpRate;
    public int offlineExpLifeTime;
    public int offlineExpRate;
    public int doubleExpLifeTime;
    public int doubleExpRate;
    public transient int doubleMoneyLifeTime;
    public transient int doubleMoneyRate;
    public int sceneLifeTime;
    public transient int l30GiftGot;
    public transient int l60GiftGot;
    public transient int l90GiftGot;
    public transient int l80GiftGot;
    public transient int l100GiftGot;
    public transient int l120GiftGot;
    public long beginTrainTime;
    public long endTrainTime;
    public int trainType;
    public int isTrain;
    public int lastLogoutTime;
    public int lockState = 0;
    public int tmpTreasure;
    public transient int rank = 1;
    public transient int lastGetGiftTime;
    public transient boolean chatable = true;
    public transient boolean movable = true;
    public transient boolean fightable = true;
    public transient boolean tradable = true;
    public transient User user;
    public transient Depot personalDepot = new Depot();
    public transient SpellList spellList = new SpellList();
    public transient Shortcuts shortCuts = new Shortcuts();
    public transient HeroTaskList taskList = new HeroTaskList();
    public transient FriendList friendList = new FriendList();
    public transient boolean dataChanged;
    public transient boolean online;
    public transient Object attachment;

    public int getBaseMaxMagicDamage() {
        return super.getBaseMaxMagicDamage() + this.baseMaxMagicDamage;
    }

    public void readData(e e2) {
        super.readFrom(e2);
        if (e2.for() > 0) {
            this.password = "1";
        }
        this.mana = e2.j();
        this.maxMana = e2.j();
        this.experience = e2.i();
        this.strength = e2.j();
        this.dexterity = e2.j();
        this.wisdom = e2.j();
        this.unassignedPoints = e2.do();
        this.baseMinPhysicalDamage = e2.do();
        this.baseMaxPhysicalDamage = e2.do();
        this.baseMinMagicDamage = e2.do();
        this.baseMaxMagicDamage = e2.do();
        this.basePhysicalDefense = e2.do();
        this.baseMagicDefense = e2.do();
        this.raisedLife = e2.do();
        this.raisedMana = e2.do();
        this.stepTime = e2.j();
        this.moveDelay = e2.j();
        this.minPhysicalDamage = e2.j();
        this.maxPhysicalDamage = e2.j();
        this.minMagicDamage = e2.j();
        this.maxMagicDamage = e2.j();
        this.physicalDefense = e2.j();
        this.magicDefense = e2.j();
        this.hittingAbility = e2.j();
        this.evadingAbility = e2.j();
        this.attackTime = e2.j();
        this.attackDelay = e2.j();
        this.attackRange = e2.case();
        this.pkValue = e2.do();
        this.nameColor = this.pkValue > 1 ? 2 : 0;
        this.onlineExpLifeTime = e2.i();
        this.offlineExpLifeTime = e2.i();
        this.doubleExpLifeTime = e2.i();
        this.arenaScores = e2.i();
        this.isTrain = e2.case();
        if (this.isTrain > 0) {
            this.trainType = e2.case();
            this.beginTrainTime = b.a(e2.i()).getTime();
            this.endTrainTime = b.a(e2.i()).getTime();
        }
        this.personalDepot.readFrom(e2);
        this.spellList.readFrom(e2);
        this.shortCuts.readFrom(e2);
        this.friendList.readFrom(e2);
    }

    public void writeData(e e2) {
        super.writeTo(e2);
        e2.a(this.password.length());
        e2.for(this.mana);
        e2.for(this.maxMana);
        e2.char(this.experience);
        e2.for(this.strength);
        e2.for(this.dexterity);
        e2.for(this.wisdom);
        e2.for(this.unassignedPoints);
        e2.for(this.baseMinPhysicalDamage);
        e2.for(this.baseMaxPhysicalDamage);
        e2.for(this.baseMinMagicDamage);
        e2.for(this.baseMaxMagicDamage);
        e2.for(this.basePhysicalDefense);
        e2.for(this.baseMagicDefense);
        e2.for(this.raisedLife);
        e2.for(this.raisedMana);
        e2.for(this.stepTime);
        e2.for(this.moveDelay);
        e2.for(this.minPhysicalDamage);
        e2.for(this.maxPhysicalDamage);
        e2.for(this.minMagicDamage);
        e2.for(this.maxMagicDamage);
        e2.for(this.physicalDefense);
        e2.for(this.magicDefense);
        e2.for(this.hittingAbility);
        e2.for(this.evadingAbility);
        e2.for(this.attackTime);
        e2.for(this.attackDelay);
        e2.a(this.attackRange);
        e2.for(this.pkValue);
        e2.char(this.onlineExpLifeTime);
        e2.char(this.offlineExpLifeTime);
        e2.char(this.doubleExpLifeTime);
        e2.char(this.arenaScores);
        e2.a(this.isTrain);
        if (this.isTrain > 0) {
            e2.a(this.trainType);
            e2.char(b.if(this.beginTrainTime));
            e2.char(b.if(this.endTrainTime));
        }
        if (this.personalDepot == null) {
            this.personalDepot = new Depot();
        }
        this.personalDepot.writeTo(e2);
        if (this.spellList == null) {
            this.spellList = new SpellList();
        }
        this.spellList.writeTo(e2);
        if (this.shortCuts == null) {
            this.shortCuts = new Shortcuts();
        }
        this.shortCuts.writeTo(e2);
        this.friendList.writeTo(e2);
    }

    public void restorePropertiesTo(int n2) {
        if (n2 < this.level) {
            int n3 = this.strength + this.dexterity + this.wisdom;
            this.strength = ORIGIN_STRENGTH[this.race] + STRENGTH_UPGRADE_QUOTIETY[this.race] * n2;
            this.dexterity = ORIGIN_DEXTERITY[this.race] + DEXTERITY_UPGRADE_QUOTIETY[this.race] * n2;
            this.wisdom = ORIGIN_WISDOM[this.race] + WISDOM_UPGRADE_QUOTIETY[this.race] * n2;
            int n4 = this.strength + this.dexterity + this.wisdom;
            this.unassignedPoints += n3 - n4;
            this.calculateProperties();
        }
    }

    public boolean isInTrain() {
        return this.endTrainTime != 0L;
    }

    public void addLevel() {
        this.experience = 0;
        ++this.level;
        this.strength += STRENGTH_UPGRADE_QUOTIETY[this.race];
        this.dexterity += DEXTERITY_UPGRADE_QUOTIETY[this.race];
        this.wisdom += WISDOM_UPGRADE_QUOTIETY[this.race];
        this.calculateProperties();
        this.life = this.maxLife;
        this.mana = this.maxMana;
    }

    public String toString() {
        return "hero{name=" + this.name + ";user=" + this.user + "}";
    }

    public void upgradeTurn(int n2) {
        int n3 = 0;
        if (this.personalDepot.weapon != null) {
            n3 = this.personalDepot.weapon.quality;
        }
        this.baseMinPhysicalDamage += (int)((float)(this.personalDepot.getMinPhysicalDamage() + this.personalDepot.getPhysicalDamageAddition(this)) * (0.1f * (1.0f + (float)n3 * 0.15f)));
        this.baseMaxPhysicalDamage += (int)((float)(this.personalDepot.getMaxPhysicalDamage() + this.personalDepot.getPhysicalDamageAddition(this)) * (0.1f * (1.0f + (float)n3 * 0.15f)));
        this.baseMinMagicDamage += (int)((float)(this.personalDepot.getMinMagicDamage() + this.personalDepot.getMagicDamageAddition(this)) * (0.1f * (1.0f + (float)n3 * 0.15f)));
        this.baseMaxMagicDamage += (int)((float)(this.personalDepot.getMaxMagicDamage() + this.personalDepot.getMagicDamageAddition(this)) * (0.1f * (1.0f + (float)n3 * 0.15f)));
        this.basePhysicalDefense += this.personalDepot.getPhysicalDefense(this, true);
        this.baseMagicDefense += this.personalDepot.getMagicDefense(this, true);
        this.raisedLife += this.personalDepot.getLifeRaised(true);
        this.raisedMana += this.personalDepot.getManaRaised(true);
        this.personalDepot.clearDecorations();
        this.personalDepot.clearEquipments();
        this.personalDepot.clearWeapon();
        this.taskList = new HeroTaskList();
        this.level = n2;
        this.experience = 0;
        this.strength = ORIGIN_STRENGTH[this.race];
        this.dexterity = ORIGIN_DEXTERITY[this.race];
        this.wisdom = ORIGIN_WISDOM[this.race];
        this.strength += STRENGTH_UPGRADE_QUOTIETY[this.race] * n2;
        this.dexterity += DEXTERITY_UPGRADE_QUOTIETY[this.race] * n2;
        this.wisdom += WISDOM_UPGRADE_QUOTIETY[this.race] * n2;
        this.unassignedPoints += TURN_ADD_POINTS[this.turns];
        this.calculateProperties();
        this.life = this.maxLife;
        this.mana = this.maxMana;
        ++this.turns;
    }

    public int getMinExp() {
        return 0;
    }

    public int getMaxExp() {
        return EXP_TABLE[this.level];
    }

    public int getBaseMinPhysicalDamage() {
        return super.getBaseMinPhysicalDamage() + this.baseMinPhysicalDamage;
    }

    public void computeLevel() {
        if (this.level != 0 || this.experience < EXP_TABLE[0]) {
            return;
        }
        this.level = this.getMaxLevel();
        int n2 = EXP_TABLE[0];
        int n3 = 1;
        while (n3 < EXP_TABLE.length) {
            if (this.experience < n2) {
                this.level = n3;
                this.experience -= n2 - EXP_TABLE[n3 - 1];
                break;
            }
            n2 += EXP_TABLE[n3];
            ++n3;
        }
    }

    static {
        int[] nArray = EXP_TABLE;
        float[] fArray = new float[]{1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.5f, 2.0f, 2.5f, 3.0f, 3.5f, 5.0f, 10.0f, 13.0f, 16.0f, 20.0f};
        nArray[0] = 10;
        int n2 = 1;
        while (n2 < EXP_TABLE.length) {
            double d2 = (n2 + 1) * (n2 + 1);
            double d3 = d2 * d2;
            double d4 = Math.round(d3 / 100.0 + d2 * 10.0);
            int n3 = 0;
            if (n2 < 95) {
                n3 = (int)(d4 * (double)fArray[n2 / 10]);
            } else {
                int n4 = (n2 - 95) / 5 + 10;
                if (n4 >= fArray.length) {
                    n4 = fArray.length - 1;
                }
                n3 = (int)(d4 * (double)fArray[n4]);
            }
            nArray[n2] = n3;
            ++n2;
        }
        Hero.EXP_TABLE[Hero.EXP_TABLE.length - 1] = 0;
        UPGRADE_ADD_POINTS = new int[]{6, 6, 6};
        STRENGTH_UPGRADE_QUOTIETY = new int[]{2, 1, 3};
        DEXTERITY_UPGRADE_QUOTIETY = new int[]{3, 2, 2};
        WISDOM_UPGRADE_QUOTIETY = new int[]{1, 3, 1};
        TURN_ADD_POINTS = new int[]{10, 20, 30, 40, 50, 60, 70, 70, 70};
        ORIGIN_STRENGTH = new int[]{2, 2, 6};
        ORIGIN_DEXTERITY = new int[]{6, 2, 2};
        ORIGIN_WISDOM = new int[]{2, 6, 2};
        ORIGIN_LIFE = new int[]{450, 400, 500};
        ORIGIN_MANA = new int[]{150, 200, 120};
    }

    public void addExp(int n2) {
        n2 = this.experience + n2;
        while (this.level < this.getMaxLevel() && n2 >= this.getMaxExp()) {
            n2 -= this.getMaxExp();
            this.addLevel();
        }
        this.experience = n2;
    }

    public int getBaseMaxPhysicalDamage() {
        return super.getBaseMaxPhysicalDamage() + this.baseMaxPhysicalDamage;
    }

    public int getBaseMinMagicDamage() {
        return super.getBaseMinMagicDamage() + this.baseMinMagicDamage;
    }

    public void calculateProperties() {
        if (this.personalDepot == null) {
            this.personalDepot = new Depot();
        }
        this.attackRange = this.race == 0 ? 5 : 2;
        if (this.personalDepot.weapon != null) {
            this.attackRange += this.personalDepot.weapon.attackRange;
        }
        if (this.strength == 0 || this.dexterity == 0 || this.wisdom == 0) {
            this.strength = ORIGIN_STRENGTH[this.race] + STRENGTH_UPGRADE_QUOTIETY[this.race] * this.level;
            this.dexterity = ORIGIN_DEXTERITY[this.race] + DEXTERITY_UPGRADE_QUOTIETY[this.race] * this.level;
            this.wisdom = ORIGIN_WISDOM[this.race] + WISDOM_UPGRADE_QUOTIETY[this.race] * this.level;
            this.unassignedPoints = 0;
            if (this.turns > 0) {
                this.unassignedPoints = TURN_ADD_POINTS[this.turns - 1];
            }
        }
        this.minPhysicalDamage = this.getBaseMinPhysicalDamage();
        this.minPhysicalDamage += this.personalDepot.getMinPhysicalDamage() + this.personalDepot.getPhysicalDamageAddition(this);
        this.maxPhysicalDamage = this.getBaseMaxPhysicalDamage();
        this.maxPhysicalDamage += this.personalDepot.getMaxPhysicalDamage() + this.personalDepot.getPhysicalDamageAddition(this);
        this.minMagicDamage = this.getBaseMinMagicDamage();
        this.minMagicDamage += this.personalDepot.getMinMagicDamage() + this.personalDepot.getMagicDamageAddition(this);
        this.maxMagicDamage = this.getBaseMaxMagicDamage();
        this.maxMagicDamage += this.personalDepot.getMaxMagicDamage() + this.personalDepot.getMagicDamageAddition(this);
        this.physicalDefense = this.strength / 2 + this.dexterity * 4 / 10 + (this.strength * this.strength / 900 + this.dexterity / 25) * 2;
        this.physicalDefense += this.basePhysicalDefense;
        this.magicDefense = this.wisdom * 6 / 10 + this.dexterity * 3 / 10 + (this.wisdom * this.wisdom / 900 + this.dexterity / 25) * 2;
        this.magicDefense += this.baseMagicDefense;
        this.hittingAbility = this.evadingAbility = this.dexterity * 2 / 10 + this.dexterity * this.dexterity / 2500 + this.level / 8 + 5;
        this.hittingAbility += this.personalDepot.getHittingAbility();
        this.evadingAbility += this.personalDepot.getEvadingAbility();
        this.stepTime = 600 + this.personalDepot.getStepTime();
        this.attackTime = 1000 + this.personalDepot.getAttackTime();
        this.attackDelay = 500 + this.personalDepot.getAttackDelay();
        this.maxLife = this.strength * 8 + this.level * 12 + ORIGIN_LIFE[this.race] + this.personalDepot.getLifeRaised() + this.raisedLife;
        this.maxLife += this.changedMaxLife;
        this.maxMana = this.wisdom * 5 + this.level * 8 + ORIGIN_MANA[this.race] + this.personalDepot.getManaRaised() + this.raisedMana;
        if (this.life > this.maxLife) {
            this.life = this.maxLife;
        }
        if (this.mana > this.maxMana) {
            this.mana = this.maxMana;
        }
        this.suit = Fashion.resolveSuit(this);
        this.halo = Fashion.resolveHalo(this);
        this.expLuck = this.personalDepot.leftRing != null && this.personalDepot.leftRing.expLuck != 0 ? this.personalDepot.leftRing.expLuck : (this.personalDepot.rightRing != null && this.personalDepot.rightRing.expLuck != 0 ? this.personalDepot.rightRing.expLuck : 100);
        this.moneyLuck = 100;
    }

    public void init() {
        this.level = 0;
        this.unassignedPoints = 0;
        this.strength = ORIGIN_STRENGTH[this.race];
        this.dexterity = ORIGIN_DEXTERITY[this.race];
        this.wisdom = ORIGIN_WISDOM[this.race];
        this.calculateProperties();
        this.life = this.maxLife;
        this.mana = this.maxMana;
    }

    public int getMaxLevel() {
        return MAX_LEVEL_TABLE[this.turns];
    }
}

