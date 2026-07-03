/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.data;

import app.island.GameObject;

public class SceneConfigData
extends GameObject
implements Cloneable {
    public static final int SCENE_TYPE_NORMAL = 0;
    public static final int SCENE_TYPE_ARENA = 1;
    public static final int SCENE_TYPE_DUPLICATE = 2;
    public static final int SCENE_TYPE_PRISON = 3;
    public static final int SCENE_TYPE_TOLLGATE = 4;
    public static final int SCENE_TYPE_MATCH = 5;
    public int sceneType;
    public int mapid;
    public int homeCity;
    public int saveHeroPos = 1;
    public int monsterCreatableCount = 5;
    public int enterX;
    public int enterY;
    public int safeRegionCenterX;
    public int safeRegionCenterY;
    public int safeRegionWidth;
    public int safeRegionHeight;
    public int viewRange = 8;
    public int heroCountLimit;
    public int minTurn;
    public int maxTurn;
    public int minHeroLevel;
    public int maxHeroLevel;
    public int plunderExpRate;
    public int plunderMoneyRate;
    public int plunderGoodsRate;
    public int goodsLifeTime = 60;
    public int goodsProtectionTime = 30;
    public int sceneLifeTime;
    public int unitExpRate = 0;
    public int medicineUsable;
    public int specialUsable;
    public int personalShopLimit = 30;
    public int earningLevelWeakening = 1;
    public String playerEnterTip = "";
    public String playerEnterScript = "";
    public transient int stateData;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("SceneConfigData[");
        stringBuffer.append("sceneType=");
        stringBuffer.append(this.sceneType);
        stringBuffer.append(";plunderExpRate=");
        stringBuffer.append(this.plunderExpRate);
        stringBuffer.append(";plunderMoneyRate=");
        stringBuffer.append(this.plunderMoneyRate);
        stringBuffer.append(";plunderGoodsRate=");
        stringBuffer.append(this.plunderGoodsRate);
        stringBuffer.append(";goodsLifeTime=");
        stringBuffer.append(this.goodsLifeTime);
        stringBuffer.append(";goodsProtectionTime=");
        stringBuffer.append(this.goodsProtectionTime);
        stringBuffer.append(";medicineUsable=");
        stringBuffer.append(this.medicineUsable);
        stringBuffer.append(";specialUsable=");
        stringBuffer.append(this.specialUsable);
        stringBuffer.append(";personalShopLimit=");
        stringBuffer.append(this.personalShopLimit);
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            cloneNotSupportedException.printStackTrace();
            return null;
        }
    }
}

