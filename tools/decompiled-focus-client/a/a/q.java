/*
 * Decompiled with CFR 0.152.
 */
package a.a;

import a.a.c;
import a.a.f;
import a.a.h;
import a.a.l;
import a.a.p;
import a.a.r;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class q
implements c {
    private int a;
    private int do;
    private a[] if;

    private int int(Object object) {
        return -1;
    }

    private void new() {
        int n2 = this.do * 100 / this.a;
        if (n2 >= this.if.length) {
            a[] aArray = this.if;
            this.a(n2 * 100 / this.a);
            int n3 = 0;
            while (n3 < aArray.length) {
                a a10 = aArray[n3];
                while (a10 != null) {
                    this.a(a10.if, a10.a);
                    a10 = a10.do;
                }
                ++n3;
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    public Object a(Object var1_1, Object var2_2) {
        if (var1_1 == null || var2_2 == null) {
            return null;
        }
        this.new();
        var3_3 = Math.abs(var1_1.hashCode()) % this.if.length;
        var4_4 = this.if[var3_3];
        if (var4_4 == null) {
            var4_4 = new a(var1_1, var2_2);
            var4_4.if = var1_1;
            var4_4.a = var2_2;
            this.if[var3_3] = var4_4;
            ++this.do;
            return var2_2;
        }
        if (!var4_4.if.equals(var1_1)) ** GOTO lbl24
        var4_4.a = var2_2;
        return var2_2;
lbl-1000:
        // 1 sources

        {
            if (var4_4.if.equals(var1_1)) {
                var4_4.a = var2_2;
                return var2_2;
            }
            if (var4_4.do == null) {
                var4_4.do = new a(var1_1, var2_2);
                ++this.do;
                return var2_2;
            }
            var4_4 = var4_4.do;
lbl24:
            // 2 sources

            ** while (var4_4 != null)
        }
lbl25:
        // 1 sources

        return null;
    }

    public Object for(Object object) {
        if (object == null) {
            return null;
        }
        int n2 = Math.abs(object.hashCode()) % this.if.length;
        a a10 = this.if[n2];
        while (a10 != null) {
            if (a10.if.equals(object)) {
                return a10.a;
            }
            a10 = a10.do;
        }
        return null;
    }

    public void a(int n2, Object object) {
        this.a((Object)new Integer(n2), object);
    }

    public Object if(int n2) {
        return this.for(new Integer(n2));
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.getClass().getName() + "{");
        int n2 = 0;
        while (n2 < this.if.length) {
            a a10 = this.if[n2];
            if (a10 != null) {
                stringBuffer.append(a10.if + "=" + a10.a + ";");
                a10 = a10.do;
                while (a10 != null) {
                    stringBuffer.append(a10.if + "=" + a10.a + ";");
                    a10 = a10.do;
                }
            }
            ++n2;
        }
        stringBuffer.setCharAt(stringBuffer.length() - 1, '}');
        return stringBuffer.toString();
    }

    public q() {
        this(100);
    }

    public q(int n2) {
        this(n2, 75);
    }

    public q(int n2, int n3) {
        if (n3 < 0 || n3 >= 100) {
            throw new IllegalArgumentException();
        }
        this.a = n3;
        this.a(n2);
    }

    private int new(Object object) {
        return -1;
    }

    public int for() {
        return this.do;
    }

    public boolean do(Object object) {
        int n2 = Math.abs(object.hashCode()) % this.if.length;
        if (this.if[n2] == null) {
            return false;
        }
        a a10 = this.if[n2];
        if (a10.if.equals(object)) {
            return true;
        }
        a10 = a10.do;
        while (a10 != null) {
            if (a10.if.equals(object)) {
                return true;
            }
            a10 = a10.do;
        }
        return false;
    }

    private int a(Object object, int n2) {
        return -1;
    }

    public boolean equals(Object object) {
        return false;
    }

    public void a(c c2) {
        l l2 = c2.a().do();
        while (l2.a()) {
            Object object = l2.if();
            this.a(object, c2.for(object));
        }
    }

    public r do() {
        h h2 = new h(this.do);
        int n2 = 0;
        while (n2 < this.if.length) {
            a a10 = this.if[n2];
            if (a10 != null) {
                h2.if(a10.a);
                a10 = a10.do;
                while (a10 != null) {
                    h2.if(a10.a);
                    a10 = a10.do;
                }
            }
            ++n2;
        }
        return h2;
    }

    public void if() {
        int n2 = 0;
        while (n2 < this.if.length) {
            this.if[n2] = null;
            ++n2;
        }
        this.do = 0;
    }

    public boolean int() {
        return this.do == 0;
    }

    public boolean if(Object object) {
        int n2 = 0;
        while (n2 < this.if.length) {
            a a10 = this.if[n2];
            if (a10 != null) {
                if (a10.a.equals(object)) {
                    return true;
                }
                a10 = a10.do;
                while (a10 != null) {
                    if (a10.a.equals(object)) {
                        return true;
                    }
                    a10 = a10.do;
                }
            }
            ++n2;
        }
        return false;
    }

    /*
     * Unable to fully structure code
     */
    public p a() {
        var1_1 = new f(this.do);
        var2_2 = 0;
        while (var2_2 < this.if.length) {
            block2: {
                var3_3 = this.if[var2_2];
                if (var3_3 != null) ** GOTO lbl10
                break block2;
lbl-1000:
                // 1 sources

                {
                    var1_1.if(var3_3.if);
                    var3_3 = var3_3.do;
lbl10:
                    // 2 sources

                    ** while (var3_3 != null)
                }
            }
            ++var2_2;
        }
        return var1_1;
    }

    private void a(int n2) {
        this.if = new a[n2];
        this.do = 0;
    }

    /*
     * Unable to fully structure code
     */
    public Object a(Object var1_1) {
        if (var1_1 == null) {
            return null;
        }
        var2_2 = Math.abs(var1_1.hashCode()) % this.if.length;
        var3_3 = this.if[var2_2];
        if (var3_3 == null) {
            return null;
        }
        this.do += -1;
        if (!var3_3.if.equals(var1_1)) ** GOTO lbl16
        this.if[var2_2] = var3_3.do;
        return var3_3.a;
lbl-1000:
        // 1 sources

        {
            if (var3_3.do.if.equals(var1_1)) {
                var4_4 = var3_3.do.a;
                var3_3.do = var3_3.do.do;
                return var4_4;
            }
            var3_3 = var3_3.do;
lbl16:
            // 2 sources

            ** while (var3_3.do != null)
        }
lbl17:
        // 1 sources

        ++this.do;
        return null;
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    private class a {
        Object if;
        Object a;
        a do;

        a(Object object, Object object2) {
            q.this.getClass();
            this.if = object;
            this.a = object2;
        }
    }
}

