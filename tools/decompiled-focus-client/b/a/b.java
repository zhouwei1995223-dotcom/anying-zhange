/*
 * Decompiled with CFR 0.152.
 */
package b.a;

import a.a.e;
import a.a.h;
import a.a.i;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class b {
    public int if;
    public String a = "";

    public void a(e e2) {
        this.if = e2.i();
        this.a = e2.h();
    }

    public void if(e e2) {
        e2.char(this.if);
        e2.a(this.a);
    }

    public i a(String string) {
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

    public boolean a(String string, i i2) {
        return this.a(string, i2.for());
    }

    public boolean a(String string, String string2) {
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

    public static final i if(b b2) {
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

    public void do(b b2) {
        this.if = b2.if;
        this.a = b2.a;
    }

    public static final h a(String string, Class clazz, h h2) {
        String[] stringArray = a.a.b.a(string, "\r\n");
        String[] stringArray2 = a.a.b.a(stringArray[1], "\t");
        if (h2 == null) {
            h2 = new h(stringArray.length - 2);
        }
        int n2 = 2;
        while (n2 < stringArray.length) {
            if (stringArray[n2].length() < 1) break;
            String[] stringArray3 = a.a.b.a(stringArray[n2], "\t");
            b b2 = null;
            try {
                b2 = (b)clazz.newInstance();
            }
            catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }
            catch (InstantiationException instantiationException) {
                instantiationException.printStackTrace();
            }
            if (b2 == null) break;
            int n3 = 0;
            while (n3 < stringArray3.length) {
                if (stringArray3[n3].length() > 0) {
                    b2.a(stringArray2[n3], stringArray3[n3]);
                }
                ++n3;
            }
            h2.if(b2);
            ++n2;
        }
        return h2;
    }

    public static b a(b b2) {
        if (b2 == null) {
            return null;
        }
        Class<?> clazz = b2.getClass();
        try {
            b b3 = (b)clazz.newInstance();
            b3.do(b2);
            return b3;
        }
        catch (InstantiationException instantiationException) {
            instantiationException.printStackTrace();
        }
        catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        }
        return null;
    }

    public static final b a(i i2) {
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

    public static final b a(b b2, String[] stringArray, String[] stringArray2) {
        int n2 = 0;
        while (n2 < stringArray2.length) {
            if (stringArray2[n2].length() > 0) {
                b2.a(stringArray[n2], stringArray2[n2]);
            }
            ++n2;
        }
        return b2;
    }
}

