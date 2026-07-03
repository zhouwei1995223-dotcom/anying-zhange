/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.data;

import app.island.GameObject;

public class NpcAIData
extends GameObject {
    public int initialVisibility = 1;
    public int visibleTimeLast = Integer.MAX_VALUE;
    public int appearanceSceneTime;
    public int appearanceHeroCount;
    public int appearanceDeathCount;
    public int appearanceDailyTime;
    public int appearanceWeaklyTime;
    public int appearanceMonthlyTime;
    public int appearanceUniqueTime;
    public int appearancePosX;
    public int appearancePosY;
    public int appearanceRegion;
    public int refreshPosTime;
    public String appearanceNotice = "";
}

