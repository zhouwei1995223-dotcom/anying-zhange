/*
 * Decompiled with CFR 0.152.
 */
package daff.a;

import daff.a.j;
import daff.a.l;
import daff.a.p;
import daff.a.r;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class d
implements daff.a.a,
p {
    private a int;
    private a for;
    private int do;

    public daff.a.a a(int n2, int n3) {
        return null;
    }

    public a new(Object object) {
        a a2 = this.int;
        while (a2 != null) {
            if (a2.do == object || a2.do.equals(object)) {
                return a2;
            }
            a2 = a2.a;
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
        a a2 = new a();
        a2.do = object;
        this.if(a2);
        return true;
    }

    public void if(int n2, Object object) {
    }

    public a int(int n2) {
        int n3 = 0;
        a a2 = this.int;
        while (a2 != null && n3 < n2) {
            a2 = a2.a;
            ++n3;
        }
        return a2;
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
        return this.for;
    }

    public int int(Object object) {
        return -1;
    }

    public a try() {
        return this.int;
    }

    public void for(a a2, a a3) {
        Object object = a2.do;
        a2.do = a3.do;
        a3.do = object;
    }

    public boolean equals(Object object) {
        return false;
    }

    public l do() {
        Object[] objectArray = this.if();
        return new j(objectArray, objectArray.length);
    }

    public a if(Object object, a a2) {
        if (a2 == null) {
            throw new IllegalArgumentException("target is null");
        }
        a a3 = new a();
        a3.do = object;
        this.a(a3, a2);
        return a3;
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

    public a a(Object object, a a2) {
        if (a2 == null) {
            throw new IllegalArgumentException("target is null");
        }
        a a3 = new a();
        a3.do = object;
        this.do(a3, a2);
        return a3;
    }

    public boolean int() {
        return this.int == null;
    }

    public boolean do(Object object) {
        a a2 = this.new(object);
        if (a2 == null) {
            return false;
        }
        return this.a(a2);
    }

    public Object a(int n2) {
        a a2 = this.int(n2);
        this.a(a2);
        return a2.do;
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
        a a2 = this.int;
        int n2 = 0;
        while (a2 != null) {
            objectArray[n2++] = a2.do;
            a2 = a2.a;
        }
        return objectArray;
    }

    public Object[] a(Object[] objectArray) {
        int n2 = 0;
        a a2 = this.int;
        while (n2 < objectArray.length && a2 != null) {
            objectArray[n2++] = a2.do;
            a2 = a2.a;
        }
        return objectArray;
    }

    public Object if(int n2) {
        if (this.do <= n2) {
            return null;
        }
        a a2 = this.int(n2);
        if (a2 != null) {
            return a2.do;
        }
        return null;
    }

    public Object a(int n2, Object object) {
        return null;
    }

    public boolean a(a a2) {
        if (a2 == null) {
            return false;
        }
        if (a2 == this.int) {
            this.int = a2.a;
            if (this.int != null) {
                this.int.if = null;
            }
        } else if (a2 == this.for) {
            this.for = a2.if;
            if (this.for != null) {
                this.for.a = null;
            }
        } else {
            if (a2.if != null) {
                a2.if.a = a2.a;
            }
            if (a2.a != null) {
                a2.a.if = a2.if;
            }
        }
        a2.a = null;
        a2.if = null;
        this.do += -1;
        if (this.do == 0) {
            this.for = null;
            this.int = null;
        } else if (this.do == 1) {
            this.for = null;
        }
        return true;
    }

    public void a(a a2, a a3) {
        if (this.int == a3) {
            this.int = a2;
        }
        if (this.for == null) {
            this.for = a3;
        }
        a2.a = a3;
        a2.if = a3.if;
        if (a2.if != null) {
            a2.if.a = a2;
        }
        a3.if = a2;
        ++this.do;
    }

    public void do(a a2, a a3) {
        if (this.int == null) {
            this.int = a2;
            a2.if = null;
            a2.a = null;
        } else if (this.for == null) {
            this.int.a = this.for = a2;
            this.for.if = this.int;
            this.for.a = null;
        } else {
            a2.if = a3;
            a2.a = a3.a;
            if (a3 == this.for) {
                this.for = a2;
            } else {
                a3.a.if = a2;
            }
            a3.a = a2;
        }
        ++this.do;
    }

    public boolean a(Object object) {
        a a2 = this.int;
        while (a2 != null) {
            if (a2.do == object || a2.do.equals(object)) {
                return true;
            }
            a2 = a2.a;
        }
        return false;
    }

    public int for() {
        return this.do;
    }

    public void a(d d2) {
        this.int = d2.int;
        this.for = d2.for;
        this.do = d2.do;
    }

    public void int(a a2, a a3) {
        this.a(a2);
        this.a(a2, a3);
    }

    public void if(a a2) {
        a2.if = null;
        a2.a = null;
        if (this.int == null) {
            this.int = a2;
        } else if (this.for == null) {
            this.int.a = this.for = a2;
            this.for.if = this.int;
        } else {
            a2.if = this.for;
            this.for.a = a2;
            this.for = a2;
        }
        ++this.do;
    }

    public void if(a a2, a a3) {
        if (a3 == null) {
            return;
        }
        this.a(a2);
        this.do(a2, a3);
    }

    public void a() {
        this.for = null;
        this.int = null;
        this.do = 0;
    }

    public int for(Object object) {
        return -1;
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    public class a {
        Object do;
        a a;
        a if;

        public String toString() {
            return this.do.toString();
        }

        a() {
            d.this.getClass();
        }

        public a if() {
            return this.a;
        }

        public Object a() {
            return this.do;
        }

        public a do() {
            return this.if;
        }
    }
}

