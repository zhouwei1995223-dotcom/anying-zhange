/*
 * Decompiled with CFR 0.152.
 */
package app.island.data;

import app.island.GameObject;
import app.island.entity.Hero;
import daff.a.e;
import daff.a.h;

public class Task
extends GameObject {
    public static h globalTaskList;
    public static final int TASK_TYPE_NONE = 0;
    public static final int TASK_TYPE_GATHER_GOODS = 1;
    public static final int TASK_TYPE_KILL_MONSTER = 2;
    public static final int TASK_TYPE_TALK_TO_NPC = 3;
    public static final int TASK_TYPE_GET_ARENA_SCORES = 4;
    public static final int TASK_TYPE_USE_WEAPON = 5;
    public static final int TASK_TYPE_USE_EQUIPMENT = 6;
    public static final int TASK_TYPE_LEARN_SKILL = 7;
    public static final int TASK_TYPE_SELL_GOODS = 8;
    public static final int TASK_TYPE_BUY_GOODS = 9;
    public static final int TASK_TYPE_USE_SPECIAL = 10;
    public static final int TASK_TYPE_REACH_LEVEL = 11;
    public static final int TASK_TYPE_WORLD_CHAT = 12;
    public static final int TASK_TYPE_MAKE_TEAM = 13;
    public static final int TASK_TYPE_JOIN_GUILD = 14;
    public static final int TASK_TYPE_MAKE_FRIENDS = 15;
    public static final int TASK_TYPE_TALK_TO_FRIEND = 16;
    public static final int TASK_TYPE_INCREASE_EQUIPMENT = 17;
    public static final int TASK_TYPE_UPGRADE_EQUIPMENT = 18;
    public static final int TASK_TYPE_REFINE_EQUIPMENT = 19;
    public static final int TASK_TYPE_MIX_EQUIPMENT = 20;
    public int subjectType;
    public int cancelable;
    public int repeatable;
    public int attachedGoods;
    public int requiredGoodsID;
    public int requiredRace;
    public int requiredTurn;
    public int requiredMinLevel;
    public int requiredMaxLevel;
    public int requiredGuildLevel;
    public int requiredTaskID;
    public int timeLast;
    public int acceptedTime;
    public int expiredTime;
    public int intervalTime;
    public int subjectDataInt;
    public String subjectDataString;
    public int targetStateData;
    public int stateData;
    public int prizeExp;
    public int prizeMoney;
    public int prizeTreasure;
    public int prizeGoodsID;
    public String objectiveDesc;
    public String rewardDesc;
    public String helpInfo;
    public transient long taskDeadline;
    public transient long completedTime;

    public void readFrom(e e2) {
        super.readFrom(e2);
        this.subjectType = e2.case();
        this.targetStateData = e2.i();
        this.stateData = e2.i();
        this.acceptedTime = e2.i();
        this.expiredTime = e2.i();
        this.objectiveDesc = e2.h();
        this.rewardDesc = e2.h();
        this.helpInfo = e2.h();
    }

    public void writeTo(e e2) {
        super.writeTo(e2);
        e2.a(this.subjectType);
        e2.char(this.targetStateData);
        e2.char(this.stateData);
        e2.char(this.acceptedTime);
        e2.char(this.expiredTime);
        e2.a(this.objectiveDesc);
        e2.a(this.rewardDesc);
        e2.a(this.helpInfo);
    }

    public void copyFrom(GameObject gameObject) {
        super.copyFrom(gameObject);
        Task task = (Task)gameObject;
        this.subjectType = task.subjectType;
        this.cancelable = task.cancelable;
        this.repeatable = task.repeatable;
        this.attachedGoods = task.attachedGoods;
        this.requiredRace = task.requiredRace;
        this.requiredTurn = task.requiredTurn;
        this.requiredMinLevel = task.requiredMinLevel;
        this.requiredMaxLevel = task.requiredMaxLevel;
        this.timeLast = task.timeLast;
        this.intervalTime = task.intervalTime;
        this.subjectDataInt = task.subjectDataInt;
        this.subjectDataString = task.subjectDataString;
        this.targetStateData = task.targetStateData;
        this.prizeExp = task.prizeExp;
        this.prizeGoodsID = task.prizeGoodsID;
        this.prizeMoney = task.prizeMoney;
        this.prizeTreasure = task.prizeTreasure;
        this.objectiveDesc = task.objectiveDesc;
        this.rewardDesc = task.rewardDesc;
        this.helpInfo = task.helpInfo;
        this.completedTime = task.completedTime;
    }

    public static void setGlobalTaskList(h h2) {
        globalTaskList = h2;
    }

    public static final Task getGlobalTask(int n2) {
        if (globalTaskList == null) {
            return null;
        }
        int n3 = globalTaskList.for();
        int n4 = 0;
        while (n4 < n3) {
            Task task = (Task)globalTaskList.if(n4);
            if (task.id == n2) {
                return task;
            }
            ++n4;
        }
        return null;
    }

    public boolean isCompleted(Hero hero) {
        switch (this.subjectType) {
            case 1: {
                this.stateData = 0;
                int n2 = 0;
                while (n2 < hero.personalDepot.goodsList.length) {
                    if (hero.personalDepot.goodsList[n2] != null && hero.personalDepot.goodsList[n2].id == this.subjectDataInt) {
                        ++this.stateData;
                    }
                    ++n2;
                }
                break;
            }
        }
        return this.stateData >= this.targetStateData;
    }
}

