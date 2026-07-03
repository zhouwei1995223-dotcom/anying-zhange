/*
 * Decompiled with CFR 0.152.
 */
package b.a;

import a.a.h;
import a.a.i;
import b.a.b;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class a {
    private static a a;

    public b a(int n2) {
        return null;
    }

    private a() {
    }

    public i a(b b2) {
        if (b2 == null) {
            return null;
        }
        Field[] fieldArray = b2.getClass().getFields();
        i i2 = new i(b2.getClass().getName());
        int n2 = fieldArray.length;
        int n3 = 0;
        while (n3 < n2) {
            String string;
            i i3;
            int n4 = fieldArray[n3].getModifiers();
            if (!Modifier.isStatic(n4) && !Modifier.isTransient(n4) && (i3 = b2.a(string = fieldArray[n3].getName())) != null) {
                i2.a(i3);
            }
            ++n3;
        }
        return i2;
    }

    public b a(i i2) {
        String string = i2.do();
        b b2 = (b)a.a.b.a(string);
        if (b2 == null) {
            return b2;
        }
        h h2 = i2.int();
        if (h2 != null) {
            int n2 = h2.for();
            int n3 = 0;
            while (n3 < n2) {
                i2 = (i)h2.if(n3);
                b2.a(i2.do(), i2);
                ++n3;
            }
        }
        return b2;
    }

    public static final a a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }
}

