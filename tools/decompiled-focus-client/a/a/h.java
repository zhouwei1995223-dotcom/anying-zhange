/*
 * Decompiled with CFR 0.152.
 */
package a.a;

import a.a.a;
import a.a.j;
import a.a.l;
import a.a.r;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class h
implements a {
    private Object[] if;
    private int a;

    public boolean a(r r2) {
        boolean bl = true;
        l l2 = r2.do();
        while (l2.a()) {
            bl &= this.do(l2.if());
        }
        return bl;
    }

    public a a(int n2, int n3) {
        h h2 = new h(n3 - n2);
        int n4 = n2;
        while (n4 < n3) {
            h2.if(this.if(n4));
            ++n4;
        }
        return h2;
    }

    public Object[] if() {
        Object[] objectArray = new Object[this.for()];
        System.arraycopy(this.if, 0, objectArray, 0, objectArray.length);
        return objectArray;
    }

    public Object[] a(Object[] objectArray) {
        System.arraycopy(this.if, 0, objectArray, 0, objectArray.length);
        return objectArray;
    }

    public int new() {
        return this.if.length;
    }

    private void for(int n2) {
        if (this.if.length < n2) {
            Object[] objectArray = new Object[n2 * 3 / 2];
            System.arraycopy(this.if, 0, objectArray, 0, this.a);
            this.if = objectArray;
        }
    }

    public Object if(int n2) {
        if (n2 < 0 || n2 >= this.a) {
            return null;
        }
        return this.if[n2];
    }

    public Object a(int n2, Object object) {
        Object object2 = this.if[n2];
        this.if[n2] = object;
        return object2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(this.getClass().getName() + "[");
        int n2 = 0;
        while (n2 < this.a) {
            stringBuffer.append(this.if[n2].toString() + ',');
            ++n2;
        }
        stringBuffer.setCharAt(stringBuffer.length() - 1, ']');
        return stringBuffer.toString();
    }

    public h() {
        this(2);
    }

    public boolean if(Object object) {
        if (object == null) {
            throw new NullPointerException("item is null");
        }
        this.for(this.a + 1);
        this.if[this.a++] = object;
        return true;
    }

    public void if(int n2, Object object) {
        if (object == null) {
            throw new NullPointerException("item is null");
        }
        this.for(this.a + 1);
        this.if[this.a++] = object;
    }

    public h(int n2) {
        this.if = new Object[n2];
        this.a = 0;
    }

    public boolean do(int n2) {
        return this.if(new Integer(n2));
    }

    public boolean for(r r2) {
        l l2 = r2.do();
        while (l2.a()) {
            this.if(l2.if());
        }
        return true;
    }

    public boolean a(int n2, r r2) {
        l l2 = r2.do();
        while (l2.a()) {
            this.if(n2++, l2.if());
        }
        return true;
    }

    public boolean a(Object object) {
        int n2 = 0;
        while (n2 < this.a) {
            if (this.if[n2] == object) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    public int for() {
        return this.a;
    }

    public int int(Object object) {
        int n2 = 0;
        while (n2 < this.for()) {
            if (this.if[n2] == object) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    public boolean equals(Object object) {
        if (object instanceof h) {
            boolean bl;
            h h2 = (h)object;
            boolean bl2 = bl = h2.a == this.a;
            if (bl) {
                int n2 = 0;
                while (n2 < this.a) {
                    if (!this.if[n2].equals(h2.if[n2])) {
                        return false;
                    }
                    ++n2;
                }
            }
            return bl;
        }
        return false;
    }

    public l do() {
        return new j(this.if, this.for());
    }

    public boolean if(r r2) {
        boolean bl = true;
        l l2 = r2.do();
        while (l2.a()) {
            bl &= this.a(l2.if());
        }
        return bl;
    }

    public boolean do(r r2) {
        this.a();
        this.for(r2);
        return true;
    }

    public void a() {
        int n2 = 0;
        while (n2 < this.a) {
            this.if[n2] = null;
            ++n2;
        }
        this.a = 0;
    }

    public int for(Object object) {
        int n2 = this.for() - 1;
        while (n2 > 0) {
            if (this.if[n2] == object) {
                return n2;
            }
            --n2;
        }
        return -1;
    }

    public boolean int() {
        return this.a == 0;
    }

    public boolean do(Object object) {
        Object object2 = this.a(this.int(object));
        return object2 != null;
    }

    public Object a(int n2) {
        if (n2 < 0 || n2 >= this.a) {
            return null;
        }
        Object object = this.if[n2];
        this.if[n2] = this.if[this.a - 1];
        this.if[this.a - 1] = null;
        this.a += -1;
        return object;
    }
}

