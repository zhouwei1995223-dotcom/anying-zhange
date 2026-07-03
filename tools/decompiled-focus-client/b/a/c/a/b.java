/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.a;

import a.a.h;
import b.a.b.e;
import b.a.c.a;
import b.a.c.a.c;
import b.a.c.b.a7;
import b.a.c.d;
import b.a.d.g;
import b.a.d.k;
import b.a.e.f;
import b.a.e.j;
import b.a.e.o;
import b.a.e.p;
import b.a.e.r;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class b {
    private b.a.c.a.d for;
    private c a;
    int if = 0;
    private long do = System.currentTimeMillis();

    private c a(final b.a.c.b b2) {
        if (this.a == null) {
            this.a = new c(this){
                k a;
                a do;
                a7 if;
                final /* synthetic */ b this$0;

                public void a(double d2, j j2) {
                    if (this.a.Q <= 0) {
                        b2.c().aH().cI();
                    }
                    p p2 = (p)j2;
                    int n2 = p2.gN * p2.gP / 100;
                    int n3 = n2 = n2 == 0 ? 10 : n2;
                    if (this.this$0.if % n2 != 0) {
                        return;
                    }
                    if (!this.if.M(10) && (double)b2.e().m().d() / (double)this.a.r < d2 && !b2.e().W) {
                        b2.e().W = true;
                        this.do.g(0, p2.if);
                    }
                }

                public void if(double d2, j j2) {
                    p p2 = (p)j2;
                    int n2 = p2.gN * p2.gP / 100;
                    int n3 = n2 = n2 == 0 ? 10 : n2;
                    if (this.this$0.if % n2 != 0) {
                        return;
                    }
                    if (!this.if.M(11) && (double)this.a.K / (double)this.a.Y < d2 && !b2.e().ae) {
                        b2.e().ae = true;
                        this.do.g(0, p2.if);
                    }
                }
                {
                    this.this$0 = b22;
                    this.this$0.getClass();
                    this.a = b2.for();
                    this.do = b2.byte();
                    this.if = b2.c().ab();
                }
            };
        }
        return this.a;
    }

    public void a(long l2, b.a.c.b b2) {
        if (b2.e().byte() && l2 - this.do > 100L) {
            this.do = l2;
            ++this.if;
        } else {
            return;
        }
        d d2 = b2.e();
        j[] jArray = d2.char();
        if (jArray[0] != null) {
            this.a(b2).a(d2.try(), jArray[0]);
        }
        if (jArray[1] != null) {
            this.a(b2).if(d2.else(), jArray[1]);
        }
        if (this.if % 10 == 0) {
            this.a(b2.e()).do();
            this.a(b2.e()).for();
        }
        if (this.if % 100 == 0) {
            this.a(b2.e()).if();
        }
    }

    private b.a.c.a.d a(final d d2) {
        if (this.for == null) {
            this.for = new b.a.c.a.d(this){
                private a.a.a if;
                private a.a.a a;
                final /* synthetic */ b this$0;

                public void if() {
                    this.a();
                    int n2 = 0;
                    while (n2 < this.if.for()) {
                        block4: {
                            f f2 = (f)this.if.if(n2);
                            if (f2.eU == 24) {
                                r[] rArray = d2.p().dL();
                                int n3 = 0;
                                while (n3 < rArray.length) {
                                    if (rArray[n3] == null || rArray[n3].if != ((o)f2).eW) {
                                        ++n3;
                                        continue;
                                    }
                                    break block4;
                                }
                                d2.a(f2);
                                break;
                            }
                        }
                        ++n2;
                    }
                }
                {
                    this.this$0 = b2;
                    this.this$0.getClass();
                    this.if = new h();
                    this.a = new h();
                }

                private void int() {
                    h h2 = d2.g().aw.fj;
                    int n2 = 0;
                    while (n2 < h2.for()) {
                        f f2 = (f)h2.if(n2);
                        if (f2.eH == 2) {
                            this.if.if(f2);
                        } else if (f2.eH == 1) {
                            this.a.if(f2);
                        }
                        ++n2;
                    }
                }

                public void for() {
                    e e2;
                    b.a.b.d d22;
                    if (this.a == null || this.a.for() == 0) {
                        d2.int(1);
                        return;
                    }
                    f f2 = (f)this.a.if((int)Math.random() * this.a.for());
                    if (f2.eU == 24 && (d22 = d2.e()) instanceof e && (e2 = (e)d22).h() != null && e2.h().Q > 0) {
                        d2.a(f2);
                        d2.int(3);
                    }
                }

                public void a() {
                    k k2 = d2.g();
                    h h2 = k2.aw.fj;
                    int n2 = 0;
                    while (n2 < h2.for()) {
                        f f2 = (f)h2.if(n2);
                        if (f2.eN >= f2.ev && f2.eK <= k2.p && f2.eP != 0) {
                            d2.o().byte().R(f2.if);
                            this.int();
                        }
                        ++n2;
                    }
                }

                public void do() {
                    this.int();
                    int n2 = Integer.MAX_VALUE;
                    b.a.b.d d22 = d2.e();
                    if (d22 == null) {
                        int n3 = 0;
                        while (n3 < d2.f().for()) {
                            int n4;
                            e e2 = (e)d2.f().if(n3);
                            g g2 = e2.h();
                            if (g2.r < d2.i() && (n4 = Math.abs(g2.void - d2.g().void) + Math.abs(g2.long - d2.g().long)) < n2) {
                                n2 = n4;
                                d22 = e2;
                            }
                            ++n3;
                        }
                        if (d22 != null) {
                            d2.a(d22);
                        }
                        if (!d2.for()) {
                            d2.int(1);
                        }
                    }
                }
            };
        }
        return this.for;
    }
}

