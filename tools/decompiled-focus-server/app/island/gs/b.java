/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs;

import app.island.entity.Hero;
import app.island.gs.h;
import app.island.gs.k;
import app.island.gs.l;
import app.island.gs.p;
import app.island.gs.u;
import daff.a.e;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class b
extends k {
    private h new;

    public void goto(h h2) {
        u u2 = h2.j();
        Hero hero = h2.r();
        int n2 = 0;
        while (n2 < this.a.for()) {
            h h3 = (h)this.a.if(n2);
            if (h3 != h2 && h3.j() == u2) {
                h3.a(p.a(hero.id, hero.x, hero.y, u2.try(), u2.int()));
                h2.a(p.a(h3.H(), h3.m(), h3.o(), u2.try(), u2.int()));
            }
            ++n2;
        }
    }

    public void try(h h2) {
        Hero hero = h2.r();
        int n2 = 0;
        while (n2 < this.a.for()) {
            h h3 = (h)this.a.if(n2);
            if (h3 != h2) {
                h3.a(p.a(hero.id));
                h2.a(p.a(h3.H()));
            }
            ++n2;
        }
    }

    public b() {
        this.a = new daff.a.h(6);
        this.if = 6;
    }

    public void long(h h2) {
        u u2 = h2.j();
        Hero hero = h2.r();
        int n2 = 0;
        while (n2 < this.a.for()) {
            h h3 = (h)this.a.if(n2);
            if (!(h3 == h2 || h3.j() == u2 && u2.a(hero.x, hero.y, h3.m(), h3.o()))) {
                h3.a(p.p(hero.id, hero.nameColor));
            }
            ++n2;
        }
    }

    protected void a(h h2) {
        h2.a((b)null);
        this.a(p.n(h2.H()), null);
    }

    public void case(h h2) {
        this.a.if(h2);
        this.new = h2;
        this.new.a(this);
        this.new.a(p.else());
    }

    public void a(int n2, h h2) {
        if (n2 <= 0) {
            return;
        }
        int n3 = this.a.for();
        int n4 = 0;
        while (n4 < n3) {
            h h3 = (h)this.a.if(n4);
            if (!h3.i()) {
                Hero hero = h3.r();
                int n5 = n2 / this.a.for();
                int n6 = Math.abs(h2.r().level - h3.r().level);
                n5 = n6 >= l.do.length ? 0 : l.do[n6] * n5 / 100;
                if (hero.doubleExpLifeTime > 0) {
                    n5 = n5 * hero.doubleExpRate / 100;
                }
                if (h3 == h2) {
                    h3.int(n5 * 5 / 4);
                } else if (h3.j() == h2.j()) {
                    u u2 = h2.j();
                    if (u2.a(h3.m(), h3.o(), h2.m(), h2.o())) {
                        h3.int(n5);
                    } else {
                        h3.int(n5 / 2);
                    }
                }
            }
            ++n4;
        }
    }

    public h else() {
        return this.new;
    }

    public boolean do(String string) {
        int n2 = this.a.for();
        int n3 = 0;
        while (n3 < n2) {
            h h2 = (h)this.a.if(n3);
            if (h2.b().equals(string)) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    public boolean for(int n2) {
        int n3 = this.a.for();
        int n4 = 0;
        while (n4 < n3) {
            h h2 = (h)this.a.if(n4);
            if (h2.H() == n2) {
                return true;
            }
            ++n4;
        }
        return false;
    }

    public void char(h h2) {
        u u2 = h2.j();
        Hero hero = h2.r();
        int n2 = 0;
        while (n2 < this.a.for()) {
            h h3 = (h)this.a.if(n2);
            if (h3 != h2 && h3.j() == u2 && !u2.a(hero.x, hero.y, h3.m(), h3.o())) {
                h3.a(p.byte(hero.id, hero.x, hero.y));
            }
            ++n2;
        }
    }

    public void a(h h2, int n2, e e2) {
        switch (n2) {
            case 1537: {
                int n3 = e2.i();
                this.a(h2, n3);
                break;
            }
            case 1539: {
                if (h2 == this.new) {
                    this.char();
                    break;
                }
                this.do(h2);
                break;
            }
        }
    }

    public void else(h h2) {
        u u2 = h2.j();
        Hero hero = h2.r();
        int n2 = 0;
        while (n2 < this.a.for()) {
            h h3 = (h)this.a.if(n2);
            if (!(h3 == h2 || h3.j() == u2 && u2.a(hero.x, hero.y, h3.m(), h3.o()))) {
                h3.a(p.e(hero.id, hero.life));
            }
            ++n2;
        }
    }

    private void a(h h2, int n2) {
        if (h2 != this.new) {
            h2.try("\u4f60\u6ca1\u6709\u8e22\u4eba\u7684\u6743\u9650");
        } else {
            h h3 = this.a(n2);
            if (h3 != null) {
                h3.a(p.c());
                this.do(h3);
            }
        }
    }

    public void if(int n2, h h2) {
        if (n2 <= 0) {
            return;
        }
        int n3 = this.a.for();
        int n4 = 0;
        while (n4 < n3) {
            h h3 = (h)this.a.if(n4);
            if (!h3.i()) {
                Hero hero = h3.r();
                int n5 = n2 / this.a.for();
                int n6 = Math.abs(h2.r().level - h3.r().level);
                n5 = n6 >= l.do.length ? 0 : l.do[n6] * n5 / 100;
                if (hero.moneyLuck != 100) {
                    n5 = n5 * hero.moneyLuck / 100;
                }
                if (h3 == h2) {
                    h3.new(n5 * 5 / 4);
                } else if (h3.j() == h2.j()) {
                    u u2 = h2.j();
                    if (u2.a(h3.m(), h3.o(), h2.m(), h2.o())) {
                        h3.new(n5);
                    } else {
                        h3.new(n5 / 2);
                    }
                }
            }
            ++n4;
        }
    }

    public void char() {
        if (this.a.for() > 0) {
            app.b.b b2 = p.c();
            int n2 = this.a.for();
            int n3 = 0;
            while (n3 < n2) {
                h h2 = (h)this.a.if(n3);
                h2.a(b2);
                h2.a((b)null);
                ++n3;
            }
            this.a.a();
        }
        this.new = null;
    }

    public void byte(h h2) {
        u u2 = h2.j();
        Hero hero = h2.r();
        int n2 = 0;
        while (n2 < this.a.for()) {
            h h3 = (h)this.a.if(n2);
            if (!(h3 == h2 || h3.j() == u2 && u2.a(hero.x, hero.y, h3.m(), h3.o()))) {
                h3.a(p.for(hero.id, hero.level, hero.maxLife));
            }
            ++n2;
        }
    }

    public void new(h h2) {
        u u2 = h2.j();
        Hero hero = h2.r();
        int n2 = 0;
        while (n2 < this.a.for()) {
            h h3 = (h)this.a.if(n2);
            if (!(h3 == h2 || h3.j() == u2 && u2.a(hero.x, hero.y, h3.m(), h3.o()))) {
                h3.a(p.q(hero.id, hero.maxLife));
            }
            ++n2;
        }
    }

    protected void int(h h2) {
        h2.a(this);
        app.b.b b2 = p.a(h2);
        this.a(b2, h2);
        h2.a(p.a(this));
    }

    public boolean case() {
        return this.new != null && this.new.goto() && this.a.for() > 1;
    }
}

