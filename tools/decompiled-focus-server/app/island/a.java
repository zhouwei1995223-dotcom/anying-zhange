/*
 * Decompiled with CFR 0.152.
 */
package app.island;

import app.island.GameObject;
import daff.a.b;
import daff.a.h;
import daff.a.i;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class a {
    private static a a;

    public GameObject a(int n2) {
        return null;
    }

    private a() {
    }

    public i a(GameObject gameObject) {
        if (gameObject == null) {
            return null;
        }
        Field[] fieldArray = gameObject.getClass().getFields();
        i i2 = new i(gameObject.getClass().getName());
        int n2 = fieldArray.length;
        int n3 = 0;
        while (n3 < n2) {
            String string;
            i i3;
            int n4 = fieldArray[n3].getModifiers();
            if (!Modifier.isStatic(n4) && !Modifier.isTransient(n4) && (i3 = gameObject.getAttributeValue(string = fieldArray[n3].getName())) != null) {
                i2.a(i3);
            }
            ++n3;
        }
        return i2;
    }

    public GameObject a(i i2) {
        String string = i2.do();
        GameObject gameObject = (GameObject)b.char(string);
        if (gameObject == null) {
            return gameObject;
        }
        h h2 = i2.int();
        if (h2 != null) {
            int n2 = h2.for();
            int n3 = 0;
            while (n3 < n2) {
                i2 = (i)h2.if(n3);
                gameObject.setAttributeValue(i2.do(), i2);
                ++n3;
            }
        }
        return gameObject;
    }

    public static final a a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }
}

