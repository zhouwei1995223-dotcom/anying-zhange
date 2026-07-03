/*
 * Decompiled with CFR 0.152.
 */
package app.island.entity;

import app.island.GameObject;
import app.island.entity.Door;
import app.island.entity.EffectObject;
import app.island.entity.GroundGoods;
import app.island.entity.Monster;
import app.island.entity.Npc;
import app.island.entity.Player;
import app.island.entity.Sign;
import daff.a.e;

public class SceneObject
extends GameObject {
    public static final int[] X_ADVANCE_AT;
    public static final int[] Y_ADVANCE_AT;
    public static final int DIRECTION_DOWN = 0;
    public static final int DIRECTION_LEFT_DOWN = 1;
    public static final int DIRECTION_LEFT = 2;
    public static final int DIRECTION_LEFT_UP = 3;
    public static final int DIRECTION_UP = 4;
    public static final int DIRECTION_RIGHT_UP = 5;
    public static final int DIRECTION_RIGHT = 6;
    public static final int DIRECTION_RIGHT_DOWN = 7;
    public static final int OBJECT_TYPE_MONSTER = 1;
    public static final int OBJECT_TYPE_NPC = 2;
    public static final int OBJECT_TYPE_PLAYER = 3;
    public static final int OBJECT_TYPE_GROUNDGOODS = 4;
    public static final int OBJECT_TYPE_EFFECT = 5;
    public static final int OBJECT_TYPE_SIGN = 6;
    public static final int OBJECT_TYPE_DOOR = 7;
    public transient int objectType;
    public int x;
    public int y;

    public void readFrom(e e2) {
        super.readFrom(e2);
        this.x = e2.for();
        this.y = e2.for();
    }

    public void writeTo(e e2) {
        super.writeTo(e2);
        e2.a(this.x);
        e2.a(this.y);
    }

    public static final int getFlyTime(int n2, int n3, int n4, int n5) {
        int n6 = Math.abs(n2 - n4);
        int n7 = Math.abs(n3 - n5);
        if (n6 > 4 || n7 > 4) {
            return 400;
        }
        if (n6 > 3 || n7 > 3) {
            return 300;
        }
        if (n6 > 2 || n7 > 2) {
            return 200;
        }
        return 100;
    }

    public static final SceneObject createObjectByType(int n2) {
        switch (n2) {
            case 1: {
                return new Monster();
            }
            case 2: {
                return new Npc();
            }
            case 3: {
                return new Player();
            }
            case 4: {
                return new GroundGoods();
            }
            case 5: {
                return new EffectObject();
            }
            case 6: {
                return new Sign();
            }
            case 7: {
                return new Door();
            }
        }
        return null;
    }

    public void copyFrom(GameObject gameObject) {
        super.copyFrom(gameObject);
        SceneObject sceneObject = (SceneObject)gameObject;
        this.x = sceneObject.x;
        this.y = sceneObject.y;
    }

    static {
        int[] nArray = new int[8];
        nArray[1] = -1;
        nArray[2] = -1;
        nArray[3] = -1;
        nArray[5] = 1;
        nArray[6] = 1;
        nArray[7] = 1;
        X_ADVANCE_AT = nArray;
        int[] nArray2 = new int[8];
        nArray2[0] = 1;
        nArray2[1] = 1;
        nArray2[3] = -1;
        nArray2[4] = -1;
        nArray2[5] = -1;
        nArray2[7] = 1;
        Y_ADVANCE_AT = nArray2;
    }

    public static final int getDirection(int n2, int n3, int n4, int n5) {
        if (n4 == n2 && n5 > n3) {
            return 0;
        }
        if (n4 < n2 && n5 > n3) {
            return 1;
        }
        if (n4 < n2 && n5 == n3) {
            return 2;
        }
        if (n4 < n2 && n5 < n3) {
            return 3;
        }
        if (n4 == n2 && n5 < n3) {
            return 4;
        }
        if (n4 > n2 && n5 < n3) {
            return 5;
        }
        if (n4 > n2 && n5 == n3) {
            return 6;
        }
        if (n4 > n2 && n5 > n3) {
            return 7;
        }
        return 0;
    }
}

