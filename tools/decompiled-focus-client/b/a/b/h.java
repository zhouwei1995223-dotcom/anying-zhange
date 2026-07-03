/*
 * Decompiled with CFR 0.152.
 */
package b.a.b;

import a.b.c;
import b.a.b.d;
import b.a.b.q;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
class h {
    private d for;
    private d if;
    private q do;
    private boolean new;
    private int int;
    private int a;

    void if(d d2) {
        d d3 = null;
        d d4 = d2.case;
        while (d4 != null) {
            if (d2.a(d4) <= 0) break;
            d3 = d4;
            d4 = d4.case;
        }
        if (d3 != null) {
            this.for(d2);
            this.if(d2, d3);
        }
    }

    public void a(c c2) {
        d d2 = this.for;
        while (d2 != null) {
            d2.if(c2);
            d2 = d2.case;
        }
    }

    public int if() {
        return this.int;
    }

    public h(q q2, int n2) {
        this.do = q2;
        this.a = n2;
    }

    void a(a.a.h h2) {
        d d2 = this.for;
        while (d2 != null) {
            h2.if(d2);
            d2 = d2.case;
        }
    }

    void a(d d2, d d3) {
        d2.try = d3.try;
        d2.case = d3;
        d3.try = d2;
        if (d2.try != null) {
            d2.try.case = d2;
        } else {
            this.for = d2;
        }
        if (this.if == null) {
            this.if = d3;
        }
        d2.byte = this.do;
        d2.do = this;
    }

    public void if(c c2) {
        d d2 = this.for;
        while (d2 != null) {
            d2.do(c2);
            d2 = d2.case;
        }
    }

    public int a() {
        return this.a;
    }

    void if(d d2, d d3) {
        d2.case = d3.case;
        d2.try = d3;
        d3.case = d2;
        if (d2.case != null) {
            d2.case.try = d2;
        } else {
            this.if = d2;
        }
        d2.byte = this.do;
        d2.do = this;
    }

    public void for(d d2) {
        d d3 = d2.try;
        d d4 = d2.case;
        d2.case = null;
        d2.try = null;
        if (d3 != null) {
            d3.case = d4;
        }
        if (d4 != null) {
            d4.try = d3;
        }
        if (this.for == d2) {
            this.for = d4;
        } else if (this.if == d2) {
            this.if = d3;
        }
        if (this.for == this.if) {
            this.if = null;
        }
        d2.byte = null;
        d2.do = null;
        this.int += -1;
    }

    public d a(long l2) {
        d d2 = this.if;
        d d3 = null;
        d d4 = null;
        if (d2 == null) {
            d2 = this.for;
        }
        while (d2 != null) {
            if (d2.if()) {
                d2.a(l2);
                if (d2.new() && d3 == null) {
                    d3 = d2;
                }
                d2 = d2.try;
                continue;
            }
            d4 = d2.try;
            this.for(d2);
            d2 = d4;
        }
        return d3;
    }

    public void do(c c2) {
        d d2 = this.for;
        while (d2 != null) {
            d2.a(c2);
            d2 = d2.case;
        }
    }

    public void do(d d2) {
        if (this.for == null) {
            this.for = d2;
        } else {
            d d3 = this.for;
            d d4 = null;
            while (d3 != null) {
                if (d2.a(d3) < 0) {
                    d4 = d3;
                    break;
                }
                d3 = d3.case;
            }
            if (d4 != null) {
                this.a(d2, d4);
            } else {
                if (this.if != null) {
                    this.if.case = d2;
                    d2.try = this.if;
                } else {
                    d2.try = this.for;
                    this.for.case = d2;
                }
                this.if = d2;
            }
        }
        d2.byte = this.do;
        d2.do = this;
        ++this.int;
    }

    public d a(int n2, int n3) {
        d d2 = this.if;
        if (d2 == null) {
            d2 = this.for;
        }
        while (d2 != null) {
            if (d2.if(n2, n3)) {
                return d2;
            }
            d2 = d2.try;
        }
        return null;
    }

    void a(d d2) {
        d d3 = null;
        d d4 = d2.try;
        while (d4 != null) {
            if (d2.a(d4) >= 0) break;
            d3 = d4;
            d4 = d4.try;
        }
        if (d3 != null) {
            this.for(d2);
            this.a(d2, d3);
        }
    }
}

