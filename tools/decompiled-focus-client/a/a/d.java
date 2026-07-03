/*
 * Decompiled with CFR 0.152.
 */
package a.a;

import a.a.j;
import a.a.l;
import a.a.p;
import a.a.r;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class d
implements a.a.a,
p {
    private a for;
    private a int;
    private int do;

    public a.a.a a(int n2, int n3) {
        return null;
    }

    public a new(Object object) {
        a a10 = this.for;
        while (a10 != null) {
            if (a10.a == object || a10.a.equals(object)) {
                return a10;
            }
            a10 = a10.if;
        }
        return null;
    }

    public boolean if(Object object) {
        if (this.a(object)) {
            return false;
        }
        if (object == null) {
            throw new IllegalArgumentException("item to been added is null!");
        }
        a a10 = new a();
        a10.a = object;
        this.if(a10);
        return true;
    }

    public void if(int n2, Object object) {
    }

    public a int(int n2) {
        int n3 = 0;
        a a10 = this.for;
        while (a10 != null && n3 < n2) {
            a10 = a10.if;
            ++n3;
        }
        return a10;
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

    public a byte() {
        return this.int;
    }

    public int int(Object object) {
        return -1;
    }

    public a try() {
        return this.for;
    }

    public void for(a a10, a a11) {
        Object object = a10.a;
        a10.a = a11.a;
        a11.a = object;
    }

    public boolean equals(Object object) {
        return false;
    }

    public l do() {
        Object[] objectArray = this.if();
        return new j(objectArray, objectArray.length);
    }

    public a if(Object object, a a10) {
        if (a10 == null) {
            throw new IllegalArgumentException("target is null");
        }
        a a11 = new a();
        a11.a = object;
        this.a(a11, a10);
        return a11;
    }

    public boolean if(r r2) {
        l l2 = r2.do();
        while (l2.a()) {
            if (this.a(l2.if())) continue;
            return false;
        }
        return true;
    }

    public boolean do(r r2) {
        this.a();
        this.for(r2);
        return true;
    }

    public a a(Object object, a a10) {
        if (a10 == null) {
            throw new IllegalArgumentException("target is null");
        }
        a a11 = new a();
        a11.a = object;
        this.do(a11, a10);
        return a11;
    }

    public boolean int() {
        return this.for == null;
    }

    public boolean do(Object object) {
        a a10 = this.new(object);
        if (a10 == null) {
            return false;
        }
        return this.a(a10);
    }

    public Object a(int n2) {
        a a10 = this.int(n2);
        this.a(a10);
        return a10.a;
    }

    public boolean a(r r2) {
        boolean bl = true;
        l l2 = r2.do();
        while (l2.a()) {
            bl &= this.do(l2.if());
        }
        return bl;
    }

    public Object[] if() {
        Object[] objectArray = new Object[this.do];
        a a10 = this.for;
        int n2 = 0;
        while (a10 != null) {
            objectArray[n2++] = a10.a;
            a10 = a10.if;
        }
        return objectArray;
    }

    public Object[] a(Object[] objectArray) {
        int n2 = 0;
        a a10 = this.for;
        while (n2 < objectArray.length && a10 != null) {
            objectArray[n2++] = a10.a;
            a10 = a10.if;
        }
        return objectArray;
    }

    public Object if(int n2) {
        if (this.do <= n2) {
            return null;
        }
        a a10 = this.int(n2);
        if (a10 != null) {
            return a10.a;
        }
        return null;
    }

    public Object a(int n2, Object object) {
        return null;
    }

    public boolean a(a a10) {
        if (a10 == null) {
            return false;
        }
        if (a10 == this.for) {
            this.for = a10.if;
            if (this.for != null) {
                this.for.do = null;
            }
        } else if (a10 == this.int) {
            this.int = a10.do;
            if (this.int != null) {
                this.int.if = null;
            }
        } else {
            a10.do.if = a10.if;
            a10.if.do = a10.do;
        }
        a10.if = null;
        a10.do = null;
        this.do += -1;
        if (this.do == 0) {
            this.int = null;
            this.for = null;
        } else if (this.do == 1) {
            this.int = null;
        }
        return true;
    }

    public void a(a a10, a a11) {
        if (this.for == a11) {
            this.for = a10;
        }
        if (this.int == null) {
            this.int = a11;
        }
        a10.if = a11;
        a10.do = a11.do;
        if (a10.do != null) {
            a10.do.if = a10;
        }
        a11.do = a10;
        ++this.do;
    }

    public void do(a a10, a a11) {
        if (this.for == null) {
            this.for = a10;
            a10.do = null;
            a10.if = null;
        } else if (this.int == null) {
            this.for.if = this.int = a10;
            this.int.do = this.for;
            this.int.if = null;
        } else {
            a10.do = a11;
            a10.if = a11.if;
            if (a11 == this.int) {
                this.int = a10;
            } else {
                a11.if.do = a10;
            }
            a11.if = a10;
        }
        ++this.do;
    }

    public boolean a(Object object) {
        a a10 = this.for;
        while (a10 != null) {
            if (a10.a == object || a10.a.equals(object)) {
                return true;
            }
            a10 = a10.if;
        }
        return false;
    }

    public int for() {
        return this.do;
    }

    public void a(d d2) {
        this.for = d2.for;
        this.int = d2.int;
        this.do = d2.do;
    }

    public void int(a a10, a a11) {
        this.a(a10);
        this.a(a10, a11);
    }

    public void if(a a10) {
        a10.do = null;
        a10.if = null;
        if (this.for == null) {
            this.for = a10;
        } else if (this.int == null) {
            this.for.if = this.int = a10;
            this.int.do = this.for;
        } else {
            a10.do = this.int;
            this.int.if = a10;
            this.int = a10;
        }
        ++this.do;
    }

    public void if(a a10, a a11) {
        if (a11 == null) {
            return;
        }
        this.a(a10);
        this.do(a10, a11);
    }

    public void a() {
        this.int = null;
        this.for = null;
        this.do = 0;
    }

    public int for(Object object) {
        return -1;
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    public class a {
        Object a;
        a if;
        a do;

        public String toString() {
            return this.a.toString();
        }

        a() {
            d.this.getClass();
        }

        public a if() {
            return this.if;
        }

        public Object a() {
            return this.a;
        }

        public a do() {
            return this.do;
        }
    }
}

