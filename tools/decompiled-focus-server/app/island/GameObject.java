/*
 * Decompiled with CFR 0.152.
 */
package app.island;

import daff.a.b;
import daff.a.e;
import daff.a.h;
import daff.a.i;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class GameObject {
    public int id;
    public String name = "";

    public void readFrom(e e2) {
        this.id = e2.i();
        this.name = e2.h();
    }

    public void writeTo(e e2) {
        e2.char(this.id);
        e2.a(this.name);
    }

    public i getAttributeValue(String string) {
        i i2 = new i(string);
        try {
            Field field = this.getClass().getField(string);
            Class<?> clazz = field.getType();
            if (clazz == Integer.TYPE) {
                i2.do(String.valueOf(field.getInt(this)));
            } else if (clazz == Long.TYPE) {
                i2.do(String.valueOf(field.getLong(this)));
            } else if (clazz == Boolean.TYPE) {
                i2.do(String.valueOf(field.getBoolean(this)));
            } else if (clazz == Float.TYPE) {
                i2.do(String.valueOf(field.getFloat(this)));
            } else if (clazz == Double.TYPE) {
                i2.do(String.valueOf(field.getDouble(this)));
            } else {
                i2.do(String.valueOf(field.get(this)));
            }
        }
        catch (NoSuchFieldException noSuchFieldException) {
            noSuchFieldException.printStackTrace();
        }
        catch (SecurityException securityException) {
            securityException.printStackTrace();
        }
        catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        }
        return i2;
    }

    public boolean setAttributeValue(String string, i i2) {
        return this.setAttributeValue(string, i2.for());
    }

    public boolean setAttributeValue(String string, String string2) {
        try {
            Field field = this.getClass().getField(string);
            Class<?> clazz = field.getType();
            if (clazz == Integer.TYPE) {
                field.setInt(this, Integer.parseInt(string2));
            } else if (clazz == Long.TYPE) {
                field.setLong(this, Long.parseLong(string2));
            } else if (clazz == Boolean.TYPE) {
                field.setBoolean(this, Boolean.getBoolean(string2));
            } else if (clazz == Float.TYPE) {
                field.setFloat(this, Float.valueOf(string2).floatValue());
            } else if (clazz == Double.TYPE) {
                field.setDouble(this, Double.valueOf(string2));
            } else {
                field.set(this, string2);
            }
            return true;
        }
        catch (NoSuchFieldException noSuchFieldException) {
            noSuchFieldException.printStackTrace();
        }
        catch (SecurityException securityException) {
            securityException.printStackTrace();
        }
        catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        }
        return false;
    }

    public static final i encodeObject(GameObject gameObject) {
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

    public void copyFrom(GameObject gameObject) {
        this.id = gameObject.id;
        this.name = gameObject.name;
    }

    public static final h loadObjects(String string, Class clazz, h h2) {
        String[] stringArray = b.a(string, "\r\n");
        String[] stringArray2 = b.a(stringArray[1], "\t");
        if (h2 == null) {
            h2 = new h(stringArray.length - 2);
        }
        int n2 = 2;
        while (n2 < stringArray.length) {
            if (stringArray[n2].length() < 1) break;
            String[] stringArray3 = b.a(stringArray[n2], "\t");
            GameObject gameObject = null;
            try {
                gameObject = (GameObject)clazz.newInstance();
            }
            catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }
            catch (InstantiationException instantiationException) {
                instantiationException.printStackTrace();
            }
            if (gameObject == null) break;
            int n3 = 0;
            while (n3 < stringArray3.length) {
                if (stringArray3[n3].length() > 0) {
                    gameObject.setAttributeValue(stringArray2[n3], stringArray3[n3]);
                }
                ++n3;
            }
            h2.if(gameObject);
            ++n2;
        }
        return h2;
    }

    public static GameObject cloneObject(GameObject gameObject) {
        if (gameObject == null) {
            return null;
        }
        Class<?> clazz = gameObject.getClass();
        try {
            GameObject gameObject2 = (GameObject)clazz.newInstance();
            gameObject2.copyFrom(gameObject);
            return gameObject2;
        }
        catch (InstantiationException instantiationException) {
            instantiationException.printStackTrace();
        }
        catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        }
        return null;
    }

    public static final GameObject parseObject(i i2) {
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

    public static final GameObject parseObject(GameObject gameObject, String[] stringArray, String[] stringArray2) {
        int n2 = 0;
        while (n2 < stringArray2.length) {
            if (stringArray2[n2].length() > 0) {
                gameObject.setAttributeValue(stringArray[n2], stringArray2[n2]);
            }
            ++n2;
        }
        return gameObject;
    }
}

