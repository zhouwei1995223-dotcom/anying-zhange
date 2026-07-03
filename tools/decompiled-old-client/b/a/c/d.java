/*
 * Decompiled with CFR 0.152.
 */
package b.a.c;

import a.a.e;
import a.a.h;
import a.b.af;
import a.b.v;
import b.a.a.a;
import b.a.a.c;
import b.a.b.p;
import b.a.b.q;
import b.a.b.s;
import b.a.b.t;
import b.a.b.u;
import b.a.c.b;
import b.a.c.b.a8;
import b.a.c.b.a9;
import b.a.c.b.bc;
import b.a.d.g;
import b.a.d.i;
import b.a.d.k;
import b.a.d.m;
import b.a.d.n;
import b.a.e.f;
import b.a.e.j;
import b.a.e.o;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class d
implements Runnable,
c,
ActionListener {
    public static final int u = 1;
    public static final int b = 2;
    public static final int D = 3;
    public static final int o = 4;
    public static final int new = 5;
    private static final String[] R = new String[]{"\u9501\u5b9a", "\u5bc6\u8bed", "\u79fb\u52a8\u8ddf\u968f", "\u9080\u8bf7\u7ec4\u961f", "\u9080\u8bf7\u4ea4\u6613", "\u9080\u8bf7\u52a0\u5165\u516c\u4f1a", "\u62db\u7eb3\u4e3a\u5f92\u5f1f", "\u52a0\u4e3a\u597d\u53cb", "\u8bbe\u4e3a\u4ec7\u4eba", "\u5bdf\u770b\u88c5\u5907", "\u6253\u5f00\u4e2a\u4eba\u5546\u5e97"};
    private static final String[] T = new String[]{"lockPlayer", "whisper", "followPlayer", "teamInvite", "tradeInvite", "guildInvite", "studentInvite", "addFriend", "addEnemy", "viewPlayerEquipment", "openPersonalShop"};
    private static final String[] for = new String[]{"\u9501\u5b9a", "\u5bc6\u8bed", "\u793c\u54c1\u804a\u5929", "\u8ddf\u968f", "\u6253\u5f00\u4e2a\u4eba\u5546\u5e97", "\u9080\u8bf7\u4ea4\u6613", "\u52a0\u4e3a\u597d\u53cb", "\u5bdf\u770b\u88c5\u5907", "\u8e22\u4e0b\u7ebf", "\u7981\u6b62/\u5141\u8bb8\u79fb\u52a8", "\u7981\u6b62/\u5141\u8bb8\u6218\u6597", "\u7981\u6b62/\u5141\u8bb8\u53d1\u8a00"};
    private static final String[] h = new String[]{"lockPlayer", "whisper", "giftChat", "followPlayer", "openPersonalShop", "tradeInvite", "addFriend", "viewPlayerEquipment", "kickPlayer", "forbidPlayerMove", "forbidPlayerFight", "forbidPlayerChat"};
    private static final String[] X = new String[]{"\u9501\u5b9a", "\u5bc6\u8bed", "\u793c\u54c1\u804a\u5929", "\u8ddf\u968f", "\u6253\u5f00\u4e2a\u4eba\u5546\u5e97", "\u9080\u8bf7\u4ea4\u6613", "\u52a0\u4e3a\u597d\u53cb", "\u5bdf\u770b\u88c5\u5907", "\u8e22\u4e0b\u7ebf", "\u7981\u6b62/\u5141\u8bb8\u79fb\u52a8", "\u7981\u6b62/\u5141\u8bb8\u6218\u6597", "\u7981\u6b62/\u5141\u8bb8\u804a\u5929"};
    private static final String[] H = new String[]{"lockPlayer", "whisper", "giftChat", "followPlayer", "openPersonalShop", "tradeInvite", "addFriend", "viewPlayerEquipment", "kickPlayer", "forbidPlayerMove", "forbidPlayerFight", "forbidPlayerChat"};
    private static final String[] af = new String[]{"\u9501\u5b9a", "\u653b\u51fb", "\u7f16\u8f91\u4fe1\u606f", "\u5927\u51cf\u8840", "\u5220\u9664\u5b83", "\u62c9\u8fc7\u6765"};
    private static final String[] I = new String[]{"lockMonster", "attackMonster", "editMonster", "killMonster", "deleteMonster", "pullMonster"};
    private static final String[] try = new String[]{"\u7f16\u8f91\u4fe1\u606f", "\u9690\u85cf/\u663e\u793a", "\u5220\u9664\u5b83", "\u62c9\u8fc7\u6765"};
    private static final String[] j = new String[]{"editNpc", "showNpc", "deleteNpc", "pullNpc"};
    private static final String[] Q = new String[]{"\u7f16\u8f91\u4fe1\u606f", "\u5220\u9664\u5b83", "\u62c9\u8fc7\u6765"};
    private static final String[] k = new String[]{"editDoor", "deleteDoor", "pullDoor"};
    private static final String[] ad = new String[]{"\u9501\u5b9a", "\u653b\u51fb", "\u67e5\u770b\u4fe1\u606f"};
    private static final String[] ag = new String[]{"lockMonster", "attackMonster", "viewMonsterInfo"};
    private static final String[] C = new String[]{"\u5730\u56fe\u4fe1\u606f", "\u64cd\u4f5c\u6307\u5357", "\u5207\u6362\u6218\u6597\u6a21\u5f0f"};
    private static final String[] z = new String[]{"mapInfo", "guide", "changeFightMode"};
    private static final String[] S = new String[]{"\u5730\u56fe\u4fe1\u606f", "\u73a9\u5bb6\u5217\u8868", "\u6e05\u9664\u7269\u54c1", "\u6e05\u9664\u7279\u6548"};
    private static final String[] E = new String[]{"mapInfo", "playerList", "guide", "clearGoods", "clearEffects"};
    private static final String[] ab = new String[]{"\u5730\u56fe\u4fe1\u606f", "\u73a9\u5bb6\u5217\u8868", "\u6e05\u9664\u7269\u54c1", "\u6e05\u9664\u7279\u6548", "\u67e5\u8be2\u53c2\u6570", "\u653e\u7f6e\u602a\u7269", "\u653e\u7f6eNPC", "\u653e\u7f6e\u4f20\u9001\u95e8"};
    private static final String[] m = new String[]{"mapInfo", "playerList", "clearGoods", "clearEffects", "getConfig", "addMonster", "addNpc", "addDoor"};
    private static final String[] c = new String[]{"\u67e5\u770b\u4fe1\u606f", "\u751f\u547d\u63d0\u53d6", "\u751f\u547d\u6350\u732e", "\u53ec\u96c6\u961f\u5458", "\u5220\u9664\u6807\u5fd7", "\u57ce\u5e02\u7ba1\u7406"};
    private static final String[] a = new String[]{"viewGuildInfo", "getLifeFromSign", "devoteLifeToSign", "gatherMembers", "deleteSign", "manageCity"};
    private static final String[] Z = new String[]{"\u67e5\u770b\u4fe1\u606f", "\u751f\u547d\u63d0\u53d6", "\u751f\u547d\u6350\u732e"};
    private static final String[] do = new String[]{"viewGuildInfo", "getLifeFromSign", "devoteLifeToSign"};
    private static final String[] ah = new String[]{"\u67e5\u770b\u4fe1\u606f", "\u8bbe\u7f6e\u654c\u5bf9", "\u53d6\u6d88\u654c\u5bf9", "\u516c\u4f1a\u5ba3\u6218"};
    private static final String[] s = new String[]{"viewGuildInfo", "setEnemyGuild", "cancelEnemyGuild", "announceGuildBattle"};
    private b void;
    private bc g;
    private q O;
    private h d = new h(100);
    private h ai = new h(100);
    private h byte = new h(100);
    private h N = new h(100);
    private h J = new h(100);
    private h p = new h(100);
    private h L = new h(10);
    private p aa;
    private k r;
    private int ac = -1;
    private String goto = "";
    private b.a.d.a case;
    private a else;
    private int Y;
    private Rectangle n = new Rectangle();
    private int y;
    private int w;
    private boolean K;
    private boolean q;
    private int v;
    private int t;
    private b.a.b.d i;
    private int B;
    private b.a.b.d F;
    private int l;
    private f M;
    private long e;
    private long long;
    private String char = "";
    private String f = "";
    private boolean if;
    private int P = 10000;
    private boolean x = true;
    private boolean G = true;
    private double A = 0.9;
    private double U = 0.9;
    private b.a.c.a.b V = new b.a.c.a.b();
    private j[] int = new j[2];
    public boolean W = false;
    public boolean ae = false;

    public void do(int n2, int n3, int n4) {
        b.a.b.f f2 = this.case(n2);
        if (f2 != null) {
            int n5 = f2.d() - n3;
            f2.if(n3);
            if (n4 > 0) {
                if (n5 > 0) {
                    f2.for(n5, n4);
                } else if (n5 < 0) {
                    f2.do(-n5, n4);
                }
            } else {
                f2.b().Q = n3;
            }
            if (f2.d() <= 0) {
                this.L.do(f2);
            }
        }
    }

    public void int(int n2, int n3, int n4) {
        p p2 = this.new(n2);
        if (p2 != null) {
            b.a.d.d d2 = p2.j();
            d2.aq = n3;
            d2.r = n4;
            if (d2.Q > n4) {
                d2.Q = n4;
            }
            if (p2.d() > d2.Q) {
                p2.if(d2.Q);
            }
        }
    }

    public void try(int n2, int n3) {
        p p2 = this.new(n2);
        if (p2 != null) {
            b.a.d.d d2 = p2.j();
            d2.r = n3;
            if (d2.Q > n3) {
                d2.Q = n3;
            }
            p2.void();
            if (p2.d() > d2.Q) {
                p2.if(d2.Q);
            }
            this.void.c().ae().new(n2, n3);
        }
    }

    private void for(int n2, int n3) {
        if (n2 == this.r.void && n3 == this.r.long) {
            return;
        }
        if (Math.abs(n2 - this.r.void) < 2 && Math.abs(n3 - this.r.long) < 2 && !this.a(n2, n3)) {
            return;
        }
        int n4 = this.else.a(this.r.void, this.r.long, n2, n3, this);
        if (n4 < 0) {
            return;
        }
        this.y = this.r.void;
        this.w = this.r.long;
        n2 = this.r.void + b.a.d.e.do[n4];
        n3 = this.r.long + b.a.d.e.new[n4];
        this.aa.do(this.r.void, this.r.long, n2, n3, this.r.c() + 20);
        this.r.void = n2;
        this.r.long = n3;
        this.void.byte().byte(n4);
        this.K = false;
        this.void.if("sound/footstep");
    }

    public void a(int n2, int n3, int n4) {
        if (n3 <= 0 || n3 >= b.a.b.v.aU.length) {
            return;
        }
        b.a.b.j j2 = this.new(n2);
        if (j2 == null) {
            j2 = this.if(n2);
        }
        if (j2 == null) {
            return;
        }
        b.a.b.v v2 = new b.a.b.v(j2, n3, n4);
        v2.a(this.O);
        this.O.do(v2);
        if (b.a.b.v.aU[n3] == null) {
            this.void.char().a("magic:" + n3);
        }
    }

    public boolean if(int n2, int n3, int n4, int n5) {
        int n6 = Math.abs(n2 - n4);
        int n7 = Math.abs(n3 - n5);
        return n6 < this.Y && n7 < this.Y;
    }

    public boolean b() {
        if (this.F != null) {
            this.F.if(false);
            this.F = null;
            if (this.l == 1) {
                this.l = 0;
            }
            return true;
        }
        return false;
    }

    private b.a.b.e if(int n2) {
        int n3 = this.ai.for();
        int n4 = 0;
        while (n4 < n3) {
            b.a.b.e e2 = (b.a.b.e)this.ai.if(n4);
            if (e2.h().if == n2) {
                return e2;
            }
            ++n4;
        }
        return null;
    }

    private b.a.b.b try(int n2) {
        int n3 = this.N.for();
        int n4 = 0;
        while (n4 < n3) {
            b.a.b.b b2 = (b.a.b.b)this.N.if(n4);
            if (b2.s().if == n2) {
                return b2;
            }
            ++n4;
        }
        return null;
    }

    public void case(int n2, int n3) {
        p p2 = this.new(n2);
        if (p2 == null) {
            return;
        }
        b.a.d.d d2 = p2.j();
        d2.an = n3;
        if (b.a.b.p.ag[d2.af * 2 + d2.an][d2.ac][0] == null) {
            this.void.char().a("hero:" + d2.af + d2.an + d2.ac);
        }
    }

    private p new(int n2) {
        if (n2 == this.r.if) {
            return this.aa;
        }
        int n3 = this.d.for();
        int n4 = 0;
        while (n4 < n3) {
            p p2 = (p)this.d.if(n4);
            if (p2.j().if == n2) {
                return p2;
            }
            ++n4;
        }
        return null;
    }

    public void if(long l2) {
        if (this.O == null) {
            return;
        }
        this.O.if(this.aa.case(), this.aa.a());
        this.a(l2);
        this.void.c().am().di();
        this.void.c().aL().if(l2);
        if (this.l()) {
            if (this.void.k() != this.f) {
                this.void.a(this.f);
            }
        } else {
            this.V.a(l2, this.void);
            if (this.void.k() != this.char) {
                this.void.a(this.char);
            }
        }
    }

    public void do(boolean bl) {
        this.G = bl;
    }

    public void do(int n2, int n3, int n4, int n5, int n6) {
        b.a.b.e e2 = this.if(n2);
        if (e2 != null) {
            g g2 = e2.h();
            if (g2.void != n3 || g2.long != n4) {
                g2.s = b.a.d.e.a(g2.void, g2.long, n3, n4);
            }
            e2.a(2, g2.void, g2.long, g2.void, g2.long, g2.s, n5);
            int n7 = this.O.try(n3);
            int n8 = this.O.int(n4) - 40;
            int n9 = 0;
            if (n6 > 0) {
                n9 = b.a.d.e.if(g2.void, g2.long, n3, n4);
                b.a.b.g g3 = new b.a.b.g(n6, e2.e(), e2.f(), n7, n8, n9, n5);
                this.O.do(g3);
            }
        }
    }

    public h d() {
        return this.d;
    }

    public h f() {
        return this.ai;
    }

    public h j() {
        return this.N;
    }

    public bc p() {
        return this.g;
    }

    public void a(b.a.d.e e2) {
        if (e2.d == 1) {
            this.a((g)e2);
        } else if (e2.d == 2) {
            this.a((b.a.d.j)e2);
            this.void.c().ah().if((b.a.d.j)e2);
        } else if (e2.d == 3) {
            this.a((b.a.d.d)e2);
        } else if (e2.d == 4) {
            this.a((n)e2);
        } else if (e2.d == 5) {
            i i2 = (i)e2;
            this.if(i2.if, i2.void, i2.long, i2.b4, i2.ca == i2.b9 ? 600 : 0, Integer.MAX_VALUE);
        } else if (e2.d == 6) {
            this.a((b.a.d.h)e2);
        } else if (e2.d == 7) {
            this.a((m)e2);
        }
    }

    public boolean else(int n2, int n3) {
        return this.n.contains(n2, n3);
    }

    public void a(MouseEvent mouseEvent) {
    }

    public void char(int n2, int n3) {
        this.l = 0;
        this.v = n2;
        this.t = n3;
        if (!this.case.do(this.v, this.t)) {
            int n4 = this.case.for();
            int n5 = this.case.new();
            int n6 = 0;
            int n7 = 0;
            int n8 = 0;
            int n9 = 0;
            int n10 = 1;
            do {
                n6 = Math.max(0, this.v - n10);
                n7 = Math.max(0, this.t - n10);
                n8 = Math.min(this.v + n10, n4);
                n9 = Math.min(this.t + n10, n5);
                int n11 = n7;
                while (n11 < n9) {
                    int n12 = n6;
                    while (n12 < n8) {
                        if (this.a(n12, n11)) {
                            this.v = n12;
                            this.t = n11;
                            break;
                        }
                        ++n12;
                    }
                    ++n11;
                }
            } while (!this.case.do(this.v, this.t) && ++n10 < 65535);
        }
    }

    public void if(String string) {
        this.aa.a(string, -65536);
    }

    public void byte(int n2, int n3) {
        this.K = true;
        this.l = 0;
        this.t = 0;
        this.v = 0;
        if (this.F != null) {
            this.F.if(false);
        }
        this.r.void = n2;
        this.r.long = n3;
        this.aa.a(n2 * 40 + 20, n3 * 30 + 15);
        this.aa.if(0, this.r.s, 0);
        this.void.c().ah().c(n2, n3);
        this.void.c().aB().do(n2, n3);
        this.void.c().aG().cU();
        this.new();
    }

    public void a(boolean bl) {
        if (this.if == bl) {
            return;
        }
        this.if = bl;
        this.void.byte().a(bl);
    }

    public void a(m m2) {
        t t2 = new t();
        t2.a(this.O);
        t2.a(m2);
        this.O.do(t2);
        this.byte.if(t2);
    }

    public void if(int n2, int n3) {
        p p2 = this.new(n2);
        if (p2 != null) {
            p2.do(n3);
            this.void.c().ae().for(n2, n3);
        }
    }

    public boolean n() {
        return this.G;
    }

    public void a(int n2, int n3, int n4, int n5, String string) {
        p p2 = this.new(n2);
        if (p2 == null) {
            return;
        }
        b.a.d.d d2 = p2.j();
        d2.al = n3;
        d2.ai = n4;
        d2.ah = n5;
        d2.aj = string;
    }

    public j[] char() {
        return this.int;
    }

    public void a(j[] jArray) {
        this.int = jArray;
    }

    public void a(n n2) {
        u u2 = new u();
        u2.a(this.O);
        u2.a(n2);
        this.O.do(u2);
        this.J.if(u2);
    }

    public void a(int n2, int n3, int n4, int n5, int n6) {
        b.a.b.e e2 = this.if(n2);
        if (e2 == null) {
            return;
        }
        g g2 = e2.h();
        g2.s = b.a.d.e.a(g2.void, g2.long, n3, n4);
        e2.a(2, g2.void, g2.long, g2.void, g2.long, g2.s, n5);
        int n7 = this.O.try(n3);
        int n8 = this.O.int(n4) - 40;
        if (g2.bR > 0) {
            int n9 = b.a.d.e.if(g2.void, g2.long, n3, n4);
            b.a.b.g g3 = new b.a.b.g(g2.bR, e2.e(), e2.f(), n7, n8, n9, n5);
            this.O.do(g3);
            n5 += n9;
        }
        if (n6 > 0) {
            b.a.b.k k2 = new b.a.b.k(n6, n7, n8, n5);
            this.O.do(k2);
        }
    }

    public void a(int n2, boolean bl, int n3, int n4) {
        b.a.b.b b2 = this.try(n2);
        if (b2 != null) {
            b.a.d.j j2 = b2.s();
            this.case.a(j2.void, j2.long, 127);
            j2.ci = bl;
            j2.void = n3;
            j2.long = n4;
            this.case.a(n3, n4, 0);
            b2.a(this.O.try(n3), this.O.int(n4));
        }
    }

    public void do(int n2, int n3, int n4, int n5) {
        p p2 = this.new(n2);
        if (p2 == null) {
            return;
        }
        b.a.d.d d2 = p2.j();
        d2.Q = n4;
        d2.r = n5;
        d2.p = n3;
        p2.if(d2.Q);
        p2.void();
        this.if(0, d2.void, d2.long, 6, 0, 600);
        this.void.c().ae().a(n2, n3, n5);
        this.void.do().int().play2DSound("sound/hero_levelup");
    }

    private void long(int n2, int n3) {
        b.a.b.d d2 = this.O.case();
        if (d2 == this.aa) {
            return;
        }
        this.i = d2;
        if (d2 instanceof p) {
            if (this.r.ao > 1) {
                this.g.a(X, H, this, n2, n3);
            } else if (this.r.ao > 0) {
                this.g.a(for, h, this, n2, n3);
            } else {
                this.g.a(R, T, this, n2, n3);
            }
        } else if (d2 instanceof b.a.b.e) {
            if (this.r.ao > 1) {
                this.g.a(af, I, this, n2, n3);
            } else {
                this.g.a(ad, ag, this, n2, n3);
            }
        } else if (d2 instanceof b.a.b.b) {
            if (this.r.ao > 1) {
                this.g.a(try, j, this, n2, n3);
            }
        } else if (d2 instanceof b.a.b.f) {
            b.a.d.h h2 = (b.a.d.h)((b.a.b.f)d2).b();
            if (this.r.aj.equals(h2.a)) {
                if (this.r.ai == 2) {
                    this.g.a(c, a, this, n2, n3);
                } else {
                    this.g.a(Z, do, this, n2, n3);
                }
            } else {
                this.g.a(ah, s, this, n2, n3);
            }
        } else if (d2 instanceof t) {
            if (this.r.ao > 1) {
                this.g.a(Q, k, this, n2, n3);
            }
        } else if (d2 == null) {
            if (this.r.ao > 1) {
                this.g.a(ab, m, this, n2, n3);
            } else if (this.r.ao > 0) {
                this.g.a(S, E, this, n2, n3);
            } else {
                this.g.a(C, z, this, n2, n3);
            }
        }
    }

    public void void() {
        n n2;
        u u2;
        int n3 = this.J.for();
        int n4 = 0;
        while (n4 < n3) {
            u2 = (u)this.J.if(n4);
            n2 = u2.n();
            if (n2.void == this.r.void && n2.long == this.r.long) {
                this.void.byte().else(this.r.void, this.r.long);
                return;
            }
            ++n4;
        }
        n4 = 0;
        while (n4 < n3) {
            u2 = (u)this.J.if(n4);
            n2 = u2.n();
            if ((n2.ct == this.r.if || n2.ct == 0) && Math.abs(n2.void - this.r.void) <= 1 && Math.abs(n2.long - this.r.long) <= 1) {
                this.void.byte().else(n2.void, n2.long);
                return;
            }
            ++n4;
        }
    }

    public void a(int n2, int n3, int n4, int n5, int n6, int n7) {
        if (this.O == null) {
            return;
        }
        if (n2 > 50000000) {
            b.a.b.e e2 = this.if(n2);
            if (e2 != null) {
                g g2 = e2.h();
                if (Math.abs(n3 - n5) > 1 || Math.abs(n4 - n6) > 1) {
                    g2.void = n5;
                    g2.long = n6;
                    g2.s = b.a.d.e.a(n3, n4, n5, n6);
                    e2.a(this.O.try(n5), this.O.int(n6));
                } else {
                    g2.void = n5;
                    g2.long = n6;
                    e2.do(n3, n4, n5, n6, n7);
                }
            }
        } else {
            p p2 = this.new(n2);
            if (p2 != null) {
                b.a.d.d d2 = p2.j();
                if (Math.abs(n3 - n5) > 1 || Math.abs(n4 - n6) > 1) {
                    d2.void = n5;
                    d2.long = n6;
                    d2.s = b.a.d.e.a(n3, n4, n5, n6);
                    p2.a(this.O.try(n5), this.O.int(n6));
                } else {
                    d2.void = n5;
                    d2.long = n6;
                    p2.do(n3, n4, n5, n6, n7);
                }
                this.void.c().ae().if(d2.if, n5, n6);
            }
        }
    }

    private void int() {
        this.void.c().ah().cn();
        this.void.c().an().a((af)null);
        this.void.c().aG().setVisible(false);
        this.void.c().ak().setVisible(false);
        this.void.d().setVisible(false);
        this.void.c().ah().setVisible(false);
        this.void.c().aB().int("");
        String string = "data/map/" + this.ac + ".map";
        String string2 = "data/map/" + this.ac + ".blk";
        byte[] byArray = this.a(string);
        if (byArray == null) {
            return;
        }
        e e2 = new e(byArray);
        this.O = new q();
        this.O.a(e2);
        this.aa = new p();
        this.aa.a(this.O);
        this.aa.a(this.void.for());
        this.O.do(this.aa);
        byArray = this.a(string2);
        if (byArray == null) {
            return;
        }
        e2 = new e(byArray);
        this.case = new b.a.d.a();
        this.case.a(e2);
        af af2 = a.b.v.if.for("image/sm/" + this.ac + ".jpg");
        this.void.c().an().a(af2);
        this.void.c().ah().if(af2);
        this.void.c().aB().int(this.goto);
        if (b.a.b.b.a9[1] == null) {
            this.void.char().a("npc");
            this.void.char().a("effect");
        }
    }

    public void byte(int n2) {
        if (this.aa != null) {
            this.aa.if(n2);
        }
        this.r.Q = n2;
    }

    public void int(int n2, int n3, int n4, int n5) {
        p p2 = this.new(n2);
        if (p2 != null) {
            int n6 = p2.d() - n3 - n4;
            if (n6 < 0) {
                n6 = 0;
            }
            p2.if(n6);
            if (n3 > 0 && n3 < 65535) {
                p2.for(n3, n5);
            }
            if (n4 > 0 && n4 < 65535) {
                p2.int(n4, n5);
            }
            if (p2 == this.F && n6 <= 0) {
                this.F.if(false);
                this.F = null;
                this.l = 0;
            }
            this.void.c().ae().int(n2, p2.d());
            if (n6 <= 0) {
                this.void.if("sound/hero_death" + p2.j().an);
            }
        }
    }

    public void a(b.a.d.j j2) {
        b.a.b.b b2 = new b.a.b.b();
        b2.a(this.O);
        b2.a(j2);
        b2.do(this.r.ao > 0);
        this.O.do(b2);
        this.case.a(j2.void, j2.long, 0);
        this.N.if(b2);
    }

    private byte[] a(String string) {
        this.void.h().a(string);
        byte[] byArray = this.void.h().do(string);
        return byArray;
    }

    public h long() {
        return this.N;
    }

    public b.a.b.d c() {
        return this.F;
    }

    public void a(f f2) {
        this.M = f2;
    }

    private b.a.b.f case(int n2) {
        int n3 = this.L.for();
        int n4 = 0;
        while (n4 < n3) {
            b.a.b.f f2 = (b.a.b.f)this.L.if(n4);
            if (f2.b().if == n2) {
                return f2;
            }
            ++n4;
        }
        return null;
    }

    public void new(int n2, int n3) {
        p p2 = this.new(n2);
        if (p2 != null) {
            p2.do(n3, p2.d() > 0 ? 1230 : 0);
            p2.if(p2.d() + n3);
            this.void.c().ae().int(n2, p2.d());
            if (this.if) {
                this.W = false;
            }
        }
    }

    public void a(g g2) {
        b.a.b.e e2 = this.if(g2.if);
        if (e2 != null) {
            e2.h().do(g2);
            e2.c();
            e2.a(this.O.try(g2.void), this.O.int(g2.long));
        } else {
            e2 = new b.a.b.e();
            e2.a(this.O);
            e2.a(g2);
            this.O.do(e2);
            this.ai.if(e2);
            if (b.a.b.e.L[g2.bQ][0] == null) {
                this.void.char().a("monster:" + g2.bQ);
            }
        }
    }

    public void if(boolean bl) {
        this.x = bl;
    }

    public void a(b.a.d.d d2) {
        p p2 = this.new(d2.if);
        if (p2 != null) {
            p2.c();
            p2.j().do(d2);
            p2.a(this.O.try(d2.void), this.O.int(d2.long));
        } else {
            p2 = new p();
            p2.a(this.O);
            p2.a(d2);
            this.O.do(p2);
            this.d.if(p2);
            if (b.a.b.p.ag[d2.af * 2 + d2.an][d2.ac][0] == null) {
                this.void.char().a("hero:" + d2.af + d2.an + d2.ac);
            }
        }
    }

    public void int(int n2) {
        this.l = n2;
    }

    public int if() {
        return this.case.new();
    }

    public void if(int n2, int n3, int n4, int n5, int n6, int n7) {
        if (this.O != null) {
            b.a.b.i i2 = new b.a.b.i(n2);
            i2.a(this.O);
            i2.if(n5, n3, n4, n6, n7);
            this.O.do(i2);
            this.p.if(i2);
        }
    }

    public Rectangle h() {
        return this.n;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(long l2) {
        if (this.aa.d() <= 0) {
            return;
        }
        if (this.aa.long() != 0) {
            return;
        }
        if (!this.K) {
            return;
        }
        int n2 = 0;
        int n3 = 0;
        b.a.b.d d2 = this.O.case();
        if (this.F != null) {
            n2 = this.F.case() / 40;
            n3 = this.F.a() / 30;
        } else {
            n2 = this.O.char() / 40;
            n3 = this.O.c() / 30;
        }
        if (this.l == 1) {
            if (Math.abs(this.r.void - n2) <= this.r.V && Math.abs(this.r.long - n3) <= this.r.V) {
                if (l2 <= this.e) return;
                if (this.F instanceof b.a.b.j) {
                    this.void.byte().char(((b.a.b.j)this.F).b().if);
                } else {
                    this.void.byte().long(n2, n3);
                }
                this.e = l2 + (long)this.r.do() + (long)this.r.new();
                this.if(this.r.if, n2, n3, this.r.do(), 0);
                return;
            }
            if (this.F == null) return;
            if (l2 <= this.long) return;
            this.for(n2, n3);
            return;
        }
        if (this.l == 2 && l2 > this.long) {
            this.for(n2, n3);
            return;
        }
        if (this.l == 3 && this.M != null) {
            if (this.M.eH == 2 && ((o)this.M).eX == 0) {
                this.void.byte().void(this.M.if, this.r.if);
                this.l = 0;
                this.e = l2 + (long)this.r.do() + (long)this.r.new();
                this.long = l2 + (long)this.r.do();
                return;
            }
            if (this.M.eH == 2 && ((o)this.M).eX == 2 && !(d2 instanceof b.a.b.j)) {
                this.void.byte().void(this.M.if, this.r.if);
                this.l = 0;
                this.e = l2 + (long)this.r.do() + (long)this.r.new();
                this.long = l2 + (long)this.r.do();
                return;
            }
            if (Math.abs(this.r.void - n2) <= this.M.eT && Math.abs(this.r.long - n3) <= this.M.eT) {
                this.l = 0;
                if (!this.case.do(n2, n3)) {
                    this.aa.a("\u65e0\u6cd5\u653b\u51fb\u8be5\u4f4d\u7f6e", -65536);
                    return;
                }
                if (this.M.eJ > this.r.K) {
                    this.aa.a("\u9b54\u6cd5\u529b\u4e0d\u8db3", -65536);
                    return;
                }
                if (this.M.eU < 24) {
                    this.aa.a("\u6280\u80fd\u51b7\u5374\u4e2d\uff0c\u65e0\u6cd5\u65bd\u653e", -65536);
                    return;
                }
                b.a.b.d d3 = this.F;
                if ((this.M.eR > 0 || this.M.eH == 1) && d2 instanceof b.a.b.j) {
                    d3 = d2;
                }
                if (this.M.eR > 0) {
                    if (this.M.eH == 2) {
                        o o2 = (o)this.M;
                        if (o2.eX == 0 || o2.eX == 2 && d2 == null) {
                            d3 = this.aa;
                        }
                    }
                    if (d3 instanceof b.a.b.e) {
                        this.void.byte().byte(this.M.if, ((b.a.b.e)d3).h().if);
                    } else {
                        if (!(d3 instanceof p)) {
                            this.aa.a("\u6ca1\u6709\u9009\u62e9\u6cd5\u672f\u65bd\u653e\u76ee\u6807", -65536);
                            return;
                        }
                        this.void.byte().void(this.M.if, ((p)d3).j().if);
                    }
                } else if (this.M.eH == 3) {
                    this.void.byte().if(this.M.if, n2, n3);
                } else {
                    this.void.byte().if(this.M.if, n2, n3);
                }
                if (this.r.af != 1 && this.F instanceof b.a.b.j && this.M.eH == 1) {
                    this.l = 1;
                }
                this.e = l2 + (long)this.r.do() + (long)this.r.new();
                this.long = l2 + (long)this.r.do();
                return;
            }
            if (l2 <= this.long) return;
            this.for(n2, n3);
            return;
        }
        if (this.l == 4 && this.F != null) {
            u u2 = (u)this.F;
            if (this.r.void == u2.n().void && this.r.long == u2.n().long) {
                this.void.byte().else(u2.n().void, u2.n().long);
                this.F.if(false);
                this.F = null;
                this.l = 0;
                return;
            }
            if (l2 <= this.long) return;
            this.for(n2, n3);
            return;
        }
        if (this.l == 5 && this.F != null) {
            t t2 = (t)this.F;
            m m2 = t2.m();
            if (this.r.void == m2.void && this.r.long == m2.long || !this.a(m2.void, m2.long) && Math.abs(this.r.void - m2.void) < 2 && Math.abs(this.r.long - m2.long) < 2) {
                this.void.byte().i(m2.if);
                this.F.if(false);
                this.F = null;
                this.l = 0;
                return;
            }
            if (l2 <= this.long) return;
            this.for(n2, n3);
            return;
        }
        if (l2 <= this.long) return;
        int n4 = this.case();
        this.for(n4 & 0xFFFF, n4 >> 16);
    }

    public void run() {
        this.void.c().an().setVisible(false);
        a8 a82 = new a8(this.void);
        a82.setBounds(this.g.getX(), this.g.getY(), this.g.getWidth(), this.g.getHeight());
        this.void.b().add(a82);
        int n2 = this.ac;
        this.F = null;
        this.l = 0;
        this.byte.a();
        this.d.a();
        this.ai.a();
        this.N.a();
        this.J.a();
        this.L.a();
        this.int();
        if (n2 != this.ac) {
            return;
        }
        this.O.a(System.currentTimeMillis());
        this.void.byte().f(n2);
        while (this.r.void == 0 && this.r.long == 0) {
            a.a.b.a(100);
        }
        this.g.a(this.O);
        this.g.requestFocus();
        this.K = true;
        this.l = 0;
        this.long = 0L;
        this.e = 0L;
        this.M = null;
        this.void.b().remove(a82);
        this.void.c().an().setVisible(true);
    }

    public void goto(int n2, int n3) {
        block10: {
            b.a.d.d d2;
            p p2 = this.new(n2);
            if (p2 != null) {
                b.a.d.d d3 = p2.j();
                d3.ac = n3;
                if (b.a.b.p.ag[d3.af * 2 + d3.an][d3.ac][0] == null) {
                    this.void.char().a("hero:" + d3.af + d3.an + d3.ac);
                }
            }
            Object var6_5 = null;
            Object object = this.getClass().getMethod("new", Integer.TYPE).invoke(this, new Integer(n2));
            if (object != null && (d2 = (b.a.d.d)object.getClass().getMethod("j", new Class[0]).invoke(object, new Object[0])) != null && d2.aq > 0) {
                this.getClass().getMethod("for", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(this, new Integer(n2), new Integer(n3), new Integer(d2.aq), new Integer(d2.r));
            }
            Object var10_8 = null;
            try {
                p p3 = (p)this.getClass().getDeclaredMethod("new", Integer.TYPE).invoke(this, new Integer(n2));
                if (p3 != null) {
                    b.a.d.d d4 = p3.j();
                    Field field = this.getClass().getDeclaredField("r");
                    field.setAccessible(true);
                    Object object2 = field.get(this);
                    if (d4 == object2 && d4.aq <= 0) {
                        d4.aq = 18;
                    }
                }
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            Object var17_14 = null;
            try {
                Method method = this.getClass().getDeclaredMethod("new", Integer.TYPE);
                method.setAccessible(true);
                p p4 = (p)method.invoke(this, new Integer(n2));
                if (p4 == null) break block10;
                b.a.d.d d5 = p4.j();
                Field field = this.getClass().getDeclaredField("r");
                field.setAccessible(true);
                Object object3 = field.get(this);
                if (d5 == object3) {
                    d5.aq = 18;
                }
            }
            catch (Throwable throwable) {}
        }
    }

    public boolean byte() {
        return this.if;
    }

    public void k() {
        if (this.aa == null) {
            return;
        }
        this.if(0, this.r.void, this.r.long, 6, 0, 600);
        this.aa.if(this.r.Q);
        this.aa.void();
    }

    public void for(int n2, int n3, int n4) {
        if (n4 > 0) {
            int n5 = this.O.try(n2);
            int n6 = this.O.int(n3) - 40;
            b.a.b.k k2 = new b.a.b.k(n4, n5, n6, 0);
            this.O.do(k2);
        }
    }

    public void a(b.a.d.h h2) {
        b.a.b.f f2 = new b.a.b.f();
        f2.a(this.O);
        f2.a(h2);
        this.O.do(f2);
        this.L.if(f2);
    }

    public b o() {
        return this.void;
    }

    public void for(int n2, int n3, int n4, int n5) {
        p p2 = this.new(n2);
        if (p2 == null) {
            return;
        }
        b.a.d.d d2 = p2.j();
        d2.r = n5;
        if (p2.d() > n5) {
            d2.Q = n5;
            p2.if(n5);
        }
        d2.ac = n3;
        d2.aq = n4;
        if (b.a.b.p.ag[d2.af * 2 + d2.an][d2.ac][0] == null) {
            this.void.char().a("hero:" + d2.af + d2.an + d2.ac);
        }
    }

    private void new() {
        b.a.b.d d2;
        int n2 = this.d.for();
        int n3 = this.aa.j().void;
        int n4 = this.aa.j().long;
        int n5 = 0;
        while (n5 < n2) {
            d2 = (p)this.d.if(n5);
            if (!this.if(((p)d2).j().void, ((p)d2).j().long, n3, n4)) {
                d2.a(false);
                this.d.a(n5--);
                --n2;
                if (d2 == this.F) {
                    this.F.if(false);
                    this.F = null;
                    this.l = 0;
                }
                if (d2 == this.i) {
                    this.i = null;
                }
            }
            ++n5;
        }
        n2 = this.ai.for();
        n5 = 0;
        while (n5 < n2) {
            d2 = (b.a.b.e)this.ai.if(n5);
            if (!this.if(((b.a.b.e)d2).h().void, ((b.a.b.e)d2).h().long, n3, n4)) {
                d2.a(false);
                this.ai.a(n5--);
                --n2;
                if (d2 == this.F) {
                    this.F.if(false);
                    this.F = null;
                    this.l = 0;
                }
                if (d2 == this.i) {
                    this.i = null;
                }
            }
            ++n5;
        }
        n2 = this.J.for();
        n5 = 0;
        while (n5 < n2) {
            d2 = (u)this.J.if(n5);
            n n6 = ((u)d2).n();
            if (!this.if(n6.void, n6.long, n3, n4)) {
                d2.a(false);
                this.J.a(n5--);
                --n2;
                if (d2 == this.F) {
                    this.F = null;
                    this.l = 0;
                }
            }
            ++n5;
        }
        n2 = this.p.for();
        n5 = 0;
        while (n5 < n2) {
            d2 = (b.a.b.i)this.p.if(n5);
            n3 = d2.case() / 40;
            if (!this.if(n3, n4 = d2.a() / 30, this.r.void, this.r.long)) {
                d2.a(false);
                this.p.a(n5--);
                --n2;
            }
            ++n5;
        }
    }

    public void new(int n2, int n3, int n4, int n5) {
        if (n4 <= 0 || n4 >= b.a.b.v.aU.length) {
            return;
        }
        if (this.O == null) {
            return;
        }
        if (n2 == 0 && n3 == 0) {
            n2 = this.r.void;
            n3 = this.r.long;
        }
        b.a.b.v v2 = new b.a.b.v(this.O.try(n2), this.O.int(n3), n4, n5);
        v2.a(this.O);
        this.O.do(v2);
        if (b.a.b.v.aU[n4] == null) {
            this.void.char().a("magic:" + n4);
        }
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.equals("guide")) {
            String string2 = "\u57fa\u672c\u64cd\u4f5c\uff1a\u6309\u4f4f\u9f20\u6807\u4f7f\u4e3b\u89d2\u4e00\u76f4\u671d\u9f20\u6807\u65b9\u5411\u79fb\u52a8\uff1b\u70b9\u51fbNPC\u8fdb\u884c\u5bf9\u8bdd\uff0c\u70b9\u51fb\u602a\u7269\u8fdb\u884c\u653b\u51fb\uff1b\u6309\u56de\u8f66\u952e\u5207\u6362\u804a\u5929\u3002";
            this.void.new().if(string2, -1);
        } else if (string.equals("mapInfo")) {
            this.void.c().ah().setVisible(true);
        } else if (string.equals("playerList") && this.r.ao > 0) {
            a9 a92 = this.void.c().al();
            a92.new();
            a92.setVisible(true);
        } else if (string.equals("attackPlayer")) {
            this.F = this.i;
            this.l = 1;
        } else if (string.equals("followPlayer")) {
            this.F = this.i;
            this.l = 2;
        } else if (string.equals("viewMonsterInfo") && this.i != null) {
            b.a.b.e e2 = (b.a.b.e)this.i;
            this.void.byte().ad(e2.h().if);
        } else if (string.equals("attackMonster") && this.i != null) {
            this.F = (b.a.b.j)this.i;
            this.l = 1;
        } else if (string.equals("lockMonster") && this.i != null) {
            this.F = (b.a.b.j)this.i;
        } else if (string.equals("lockPlayer") && this.i != null) {
            this.F = (b.a.b.j)this.i;
        } else if (string.equals("teamInvite") && this.i != null) {
            p p2 = (p)this.i;
            this.void.byte().k(p2.j().a);
        } else if (string.equals("tradeInvite")) {
            p p3 = (p)this.i;
            int n2 = p3.j().if;
            this.void.byte().F(n2);
        } else if (string.equals("whisper") && this.i != null) {
            p p4 = (p)this.i;
            this.void.c().ag().t(p4.j().a);
        } else if (string.equals("relive")) {
            this.void.byte().t();
        } else if (string.equals("guildInvite")) {
            if (this.r.ak == null) {
                this.void.new().if("\u4f60\u8fd8\u6ca1\u6709\u516c\u4f1a", -1);
            } else if (this.r.ai < 1 || this.r.ai > 2) {
                this.void.new().if("\u4f60\u6ca1\u6709\u9080\u8bf7\u73a9\u5bb6\u7684\u6743\u9650", -1);
            } else {
                p p5 = (p)this.i;
                this.void.byte().e(p5.j().a);
            }
        } else if (string.equals("studentInvite")) {
            p p6 = (p)this.i;
            if (this.r.p < 60) {
                this.void.new().if("\u7b49\u7ea7\u8fbe\u523060\u4ee5\u540e\u5c31\u53ef\u4ee5\u62db\u6536\u5f92\u5f1f\u4e86", -1);
            } else if (p6.j().p >= this.r.p) {
                this.void.new().if("\u4f60\u53ea\u80fd\u62db\u6536\u7b49\u7ea7\u4f4e\u4e8e\u81ea\u5df1\u7684\u73a9\u5bb6\u4e3a\u5f92\u5f1f", -1);
            } else {
                this.void.byte().l(p6.j().a);
            }
        } else if (string.equals("addFriend")) {
            p p7 = (p)this.i;
            String string3 = p7.j().a;
            this.void.c().W().j(string3);
        } else if (string.equals("addEnemy")) {
            p p8 = (p)this.i;
            String string4 = p8.j().a;
            this.void.c().W().i(string4);
        } else if (string.equals("kickPlayer")) {
            p p9 = (p)this.i;
            String string5 = p9.j().a;
            this.void.new().if("\u4f60\u786e\u5b9a\u8981\u5c06\u3010" + string5 + "\u3011\u8e22\u4e0b\u7ebf\u5417\uff1f", 0xFFFFFF, "yesKickPlayer", "", this);
        } else if (string.equals("yesKickPlayer")) {
            p p10 = (p)this.i;
            String string6 = p10.j().a;
            this.void.byte().void(string6);
        } else if (string.equals("forbidPlayerChat")) {
            p p11 = (p)this.i;
            String string7 = p11.j().a;
            this.void.byte().J(string7);
        } else if (string.equals("forbidPlayerFight")) {
            p p12 = (p)this.i;
            String string8 = p12.j().a;
            this.void.byte().v(string8);
        } else if (string.equals("forbidPlayerMove")) {
            p p13 = (p)this.i;
            String string9 = p13.j().a;
            this.void.byte().n(string9);
        } else if (string.equals("forbidPlayerChat")) {
            p p14 = (p)this.i;
            String string10 = p14.j().a;
            this.void.byte().J(string10);
        } else if (string.equals("viewPlayerEquipment")) {
            p p15 = (p)this.i;
            this.void.byte().U(p15.j().if);
        } else if (string.equals("clearGoods")) {
            this.void.new().if("\u786e\u5b9a\u8981\u6e05\u9664\u533a\u57df\u5185\u7684\u6240\u6709\u7269\u54c1\u5417\uff1f", 0xFFFFFF, "yesClearGoods", "", this);
        } else if (string.equals("yesClearGoods")) {
            this.void.byte().int();
        } else if (string.equals("clearEffects")) {
            this.void.new().if("\u786e\u5b9a\u8981\u6e05\u9664\u533a\u57df\u5185\u7684\u6240\u6709\u9b54\u6cd5\u7279\u6548\u5417\uff1f", 0xFFFFFF, "yesClearEffects", "", this);
        } else if (string.equals("yesClearEffects")) {
            this.void.byte().new();
        } else if (string.equals("openPersonalShop")) {
            this.void.byte().j(((b.a.b.j)this.i).b().a);
        } else if (string.equals("changeFightMode")) {
            this.do();
        } else if (string.equals("giftChat")) {
            this.void.c().aM().r(((b.a.b.j)this.i).b().a);
        } else if (string.equals("killMonster")) {
            int n3 = ((b.a.b.e)this.i).h().if;
            this.void.byte().T(n3);
        } else if (string.equals("deleteMonster")) {
            int n4 = ((b.a.b.e)this.i).h().if;
            this.void.byte().Z(n4);
        } else if (string.equals("pullMonster")) {
            int n5 = ((b.a.b.e)this.i).h().if;
            this.void.byte().new(n5, this.r.void, this.r.long);
        } else if (string.equals("getConfig")) {
            this.void.byte().I();
        } else if (string.equals("addMonster")) {
            int n6 = this.O.new(this.O.char());
            int n7 = this.O.if(this.O.c());
            this.void.c().aC().b(n6, n7);
        } else if (string.equals("addNpc")) {
            int n8 = this.O.new(this.O.char());
            int n9 = this.O.if(this.O.c());
            this.void.c().aC().long(n8, n9);
        } else if (string.equals("addDoor")) {
            int n10 = this.O.new(this.O.char());
            int n11 = this.O.if(this.O.c());
            this.void.c().aC().void(n10, n11);
        } else if (string.equals("editMonster")) {
            b.a.b.e e3 = (b.a.b.e)this.i;
            g g2 = e3.h();
            this.void.c().aC().a(g2);
        } else if (string.equals("editNpc")) {
            b.a.b.b b2 = (b.a.b.b)this.i;
            b.a.d.j j2 = b2.s();
            this.void.c().aC().a(j2);
        } else if (string.equals("editDoor")) {
            t t2 = (t)this.i;
            m m2 = t2.m();
            this.void.c().aC().a(m2);
        } else if (string.equals("deleteDoor")) {
            int n12 = ((t)this.i).m().if;
            this.void.byte().j(n12);
        } else if (string.equals("pullDoor")) {
            int n13 = ((t)this.i).m().if;
            this.void.byte().for(n13, this.r.void, this.r.long);
        } else if (string.equals("showNpc")) {
            int n14 = ((b.a.b.b)this.i).s().if;
            this.void.byte().if(n14);
        } else if (string.equals("deleteNpc")) {
            int n15 = ((b.a.b.b)this.i).s().if;
            this.void.byte().h(n15);
        } else if (string.equals("pullNpc")) {
            int n16 = ((b.a.b.b)this.i).s().if;
            this.void.byte().int(n16, this.r.void, this.r.long);
        } else if (string.equals("viewGuildInfo")) {
            int n17 = ((b.a.b.f)this.i).b().if - 50000000;
            this.void.byte().J(n17);
        } else if (string.equals("getLifeFromSign")) {
            this.void.byte().C();
        } else if (string.equals("devoteLifeToSign")) {
            this.void.byte().o();
        } else if (string.equals("gatherMembers")) {
            this.void.byte().byte();
        } else if (string.equals("deleteSign")) {
            this.void.new().if("\u5220\u9664\u516c\u4f1a\u6807\u5fd7\u4f1a\u964d\u4f4e\u516c\u4f1a100\u70b9\u58f0\u671b\uff0c\u786e\u5b9a\u5417\uff1f", 0xFFFFFF, "yesDeleteSign", "", this);
        } else if (string.equals("manageCity")) {
            if (this.void.for().ak.cK > 0) {
                this.void.c().aa().cd();
            } else {
                this.void.new().if("\u8fd8\u6ca1\u6709\u5360\u9886\u57ce\u5e02\u5462", 0xFFFFFF);
            }
        } else if (string.equals("yesDeleteSign")) {
            this.void.byte().g();
        } else if (string.equals("setEnemyGuild")) {
            int n18 = ((b.a.b.f)this.i).b().if - 50000000;
            this.void.byte().N(n18);
        } else if (string.equals("cancelEnemyGuild")) {
            int n19 = ((b.a.b.f)this.i).b().if - 50000000;
            this.void.byte().e(n19);
        } else if (string.equals("conveyToGuildSign")) {
            this.void.byte().u();
        } else if (string.equals("announceGuildBattle")) {
            if (this.r.ak == null) {
                this.void.new().if("\u4f60\u8fd8\u6ca1\u6709\u516c\u4f1a\uff0c\u4e0d\u80fd\u5bf9\u8be5\u516c\u4f1a\u5ba3\u6218\uff01", 0xFF0000);
            } else if (this.r.ai != 2) {
                this.void.new().if("\u4f60\u4e0d\u662f\u4f1a\u957f\uff0c\u4e0d\u80fd\u5bf9\u8be5\u516c\u4f1a\u5ba3\u6218\uff01", 0xFF0000);
            } else {
                this.void.new().if("\u8bf7\u53bb\u57ce\u5e02\u7ba1\u7406\u5458\u90a3\u91cc\u5411\u5360\u9886\u57ce\u5e02\u7684\u516c\u4f1a\u5ba3\u6218", 0xFF0000);
            }
        } else if (string.equals("mix")) {
            boolean bl = true;
            int n20 = 0;
            while (n20 < this.void.c().aO().hw.length) {
                if (this.void.c().aO().hw[n20] != null && this.void.c().aO().hp[n20] == null) {
                    bl = false;
                    break;
                }
                ++n20;
            }
            if (bl) {
                this.void.byte().G();
            }
        } else if (string.endsWith("startQuestion")) {
            this.void.byte().p();
        }
        this.i = null;
    }

    public int i() {
        return this.P;
    }

    public void do(int n2) {
        this.P = n2 <= 0 ? 1000 : n2;
    }

    public void a(int n2, String string) {
        p p2 = this.new(n2);
        if (p2 == null) {
            return;
        }
        b.a.d.d d2 = p2.j();
        d2.ag = string;
        if (d2 == this.r) {
            if (string.length() > 0) {
                this.void.c().af().bV();
            } else {
                this.void.c().af().bX();
            }
        }
    }

    public double try() {
        return this.A;
    }

    public void if(double d2) {
        this.A = d2;
    }

    public int a() {
        return this.case.for();
    }

    public boolean a(int n2, int n3) {
        b.a.d.e e2;
        b.a.b.d d2;
        if (!this.r.ad) {
            return true;
        }
        if (!this.case.do(n2, n3)) {
            return false;
        }
        int n4 = this.ai.for();
        int n5 = 0;
        while (n5 < n4) {
            d2 = (b.a.b.e)this.ai.if(n5);
            e2 = ((b.a.b.e)d2).h();
            if (e2.void == n2 && e2.long == n3 && e2.Q > 0) {
                return false;
            }
            ++n5;
        }
        n4 = this.d.for();
        n5 = 0;
        while (n5 < n4) {
            d2 = (p)this.d.if(n5);
            e2 = ((p)d2).b();
            if (e2.void == n2 && e2.long == n3 && e2.Q > 0) {
                return false;
            }
            ++n5;
        }
        n4 = this.N.for();
        n5 = 0;
        while (n5 < n4) {
            d2 = (b.a.b.b)this.N.if(n5);
            e2 = ((b.a.b.b)d2).s();
            if (e2.void == n2 && e2.long == n3 && ((b.a.d.j)e2).ci) {
                return false;
            }
            ++n5;
        }
        n4 = this.L.for();
        n5 = 0;
        while (n5 < n4) {
            d2 = (b.a.b.f)this.L.if(n5);
            e2 = ((b.a.b.f)d2).b();
            if (e2.void == n2 && e2.long == n3 && e2.Q > 0) {
                return false;
            }
            ++n5;
        }
        return true;
    }

    public boolean for() {
        return this.x;
    }

    public void if(f f2) {
        b.a.b.d d2;
        if (this.r.Q < 0) {
            return;
        }
        if (this.F == null && f2.eH == 1 && (d2 = this.O.case()) instanceof b.a.b.j && d2 != this.aa) {
            if (this.F != null) {
                this.F.if(false);
            }
            this.F = d2;
            this.F.if(true);
        }
        this.l = 3;
        this.M = f2;
    }

    public void for(int n2, int n3, int n4, int n5, int n6) {
        p p2 = this.new(n2);
        if (p2 != null) {
            b.a.d.d d2 = p2.j();
            if (d2.void != n3 || d2.long != n4) {
                d2.s = b.a.d.e.a(d2.void, d2.long, n3, n4);
            }
            p2.a(2, d2.void, d2.long, n3, n4, d2.s, n5);
            int n7 = this.O.try(n3);
            int n8 = this.O.int(n4) - 40;
            int n9 = 0;
            if (n6 > 0) {
                n9 = b.a.d.e.if(d2.void, d2.long, n3, n4);
                b.a.b.g g2 = new b.a.b.g(n6, p2.e(), p2.f(), n7, n8, n9, n5);
                this.O.do(g2);
            }
            this.void.if("sound/hero_attack" + p2.j().af);
        }
    }

    public boolean l() {
        return this.n.contains(this.r.void, this.r.long);
    }

    public void char(int n2) {
        b.a.b.d d2;
        int n3 = this.ai.for();
        int n4 = 0;
        while (n4 < n3) {
            d2 = (b.a.b.e)this.ai.if(n4);
            if (((b.a.b.e)d2).h().if == n2) {
                this.ai.a(n4);
                this.O.if(d2);
                if (this.F == d2) {
                    this.F.if(false);
                    this.F = null;
                    this.l = 0;
                }
                return;
            }
            ++n4;
        }
        n3 = this.d.for();
        n4 = 0;
        while (n4 < n3) {
            d2 = (p)this.d.if(n4);
            if (((p)d2).j().if == n2) {
                this.d.a(n4);
                this.O.if(d2);
                if (this.F == d2) {
                    this.F.if(false);
                    this.F = null;
                    this.l = 0;
                }
                return;
            }
            ++n4;
        }
        n3 = this.J.for();
        n4 = 0;
        while (n4 < n3) {
            d2 = (u)this.J.if(n4);
            if (((u)d2).n().if == n2) {
                this.J.a(n4);
                if (this.F == d2) {
                    this.F = null;
                    this.l = 0;
                }
                this.O.if(d2);
                return;
            }
            ++n4;
        }
        n3 = this.p.for();
        n4 = 0;
        while (n4 < n3) {
            d2 = (b.a.b.i)this.p.if(n4);
            if (((b.a.b.i)d2).goto() == n2) {
                this.p.a(n4);
                d2.a(false);
                return;
            }
            ++n4;
        }
        n3 = this.L.for();
        n4 = 0;
        while (n4 < n3) {
            d2 = (b.a.b.f)this.L.if(n4);
            if (((b.a.b.f)d2).b().if == n2) {
                this.L.a(n4);
                d2.a(false);
                return;
            }
            ++n4;
        }
        n3 = this.byte.for();
        n4 = 0;
        while (n4 < n3) {
            d2 = (t)this.byte.if(n4);
            if (((t)d2).m().if == n2) {
                this.byte.a(n4);
                d2.a(false);
                return;
            }
            ++n4;
        }
        n3 = this.N.for();
        n4 = 0;
        while (n4 < n3) {
            d2 = (b.a.b.b)this.N.if(n4);
            if (((b.a.b.b)d2).s().if == n2) {
                this.N.a(n4);
                d2.a(false);
                this.void.c().ah().do(((b.a.b.b)d2).s());
                return;
            }
            ++n4;
        }
    }

    public b.a.b.d e() {
        return this.F;
    }

    public void a(b.a.b.d d2) {
        this.F = d2;
    }

    public p m() {
        return this.aa;
    }

    public d(b b2) {
        this.void = b2;
        this.r = b2.for();
        this.else = new b.a.a.b();
    }

    public int goto() {
        return this.B;
    }

    public void for(int n2) {
        if (this.B != n2) {
            this.B = n2;
            this.void.c().b(n2);
            this.void.byte().v(this.B);
        }
        switch (this.B) {
            case 0: {
                this.void.goto().int("\u5207\u6362\u653b\u51fb\u6a21\u5f0f\u4e3a[\u548c\u5e73\u6a21\u5f0f]", -1627389952, -16711921);
                break;
            }
            case 1: {
                this.void.goto().int("\u5207\u6362\u653b\u51fb\u6a21\u5f0f\u4e3a[\u516c\u4f1a\u6a21\u5f0f]", -1627389952, -16711921);
                break;
            }
            case 2: {
                this.void.goto().int("\u5207\u6362\u653b\u51fb\u6a21\u5f0f\u4e3a[PK\u6a21\u5f0f]", -1627389952, -16711921);
                break;
            }
        }
    }

    public void do() {
        this.for((this.B + 1) % 3);
    }

    public void if(MouseEvent mouseEvent) {
        if (this.void.c().af().bS()) {
            return;
        }
        if (mouseEvent.getID() == 501) {
            this.g.requestFocus();
            boolean bl = this.q = (mouseEvent.getModifiers() & 0x10) != 0;
            if (this.aa.d() <= 0 && this.r.Q <= 0) {
                String string = "\u4f60\u88ab\u6740\u6b7b\u4e86~~~\u5982\u679c\u56de\u5230\u4e3b\u57ce\u590d\u6d3b\uff0c\u53ef\u4ee5\u6062\u590d\u6240\u6709\u751f\u547d\uff0c\u4f60\u786e\u5b9a\u5417\uff1f";
                this.void.new().if(string, -16711681, "relive", "", this);
            } else if (this.q) {
                this.l = 0;
                this.q = false;
                b.a.b.d d2 = this.O.case();
                if (d2 != this.aa && this.r.Q > 0) {
                    this.t = 0;
                    this.v = 0;
                    if (d2 instanceof b.a.b.b) {
                        b.a.d.j j2 = ((b.a.b.b)d2).s();
                        this.aa.a(b.a.d.e.a(this.r.void, this.r.long, j2.void, j2.long));
                        this.void.byte().ae(j2.if);
                        this.l = 0;
                    } else if (d2 instanceof u) {
                        this.l = 4;
                        if (this.F != null) {
                            this.F.if(false);
                        }
                        this.F = d2;
                        this.F.if(true);
                    } else if (d2 instanceof t) {
                        this.l = 5;
                        if (this.F != null) {
                            this.F.if(false);
                        }
                        this.F = d2;
                        this.F.if(true);
                    } else if (d2 instanceof b.a.b.j) {
                        if (this.F != null) {
                            this.F.if(false);
                        }
                        this.F = d2;
                        this.F.if(true);
                        if (((b.a.b.j)d2).d() > 0) {
                            this.l = 1;
                        }
                        if (this.F instanceof p) {
                            p p2 = (p)this.F;
                            if (p2.j().ag.length() > 0 && this.O.c() > p2.a() - 60 && this.O.c() < p2.a() - 46) {
                                this.void.byte().j(p2.j().a);
                                this.F.if(false);
                                this.F = null;
                                this.l = 0;
                            }
                        }
                    } else if (mouseEvent.isShiftDown()) {
                        this.l = 1;
                    } else {
                        s s2 = new s(this.O.char(), this.O.c());
                        this.O.do(s2);
                        this.v = this.O.new(this.O.char());
                        this.t = this.O.if(this.O.c());
                        this.q = true;
                    }
                }
            } else if ((mouseEvent.getModifiers() & 4) != 0) {
                this.long(mouseEvent.getX(), mouseEvent.getY());
            }
        } else if (mouseEvent.getID() == 502) {
            if (this.q) {
                this.char(this.O.new(this.O.char()), this.O.if(this.O.c()));
            }
            this.q = false;
        }
    }

    public void a(int n2) {
        if (this.O != null) {
            this.O.a(1, n2);
        }
    }

    public void a(int n2, int n3, String string) {
        p p2 = this.new(n2);
        if (p2 != null) {
            p2.a(string);
            String string2 = p2.j().a;
            if (string2.equals(this.r.a)) {
                this.void.c().aB().T().void("region").new("\u4f60\u8bf4\uff1a" + string);
            } else if (!this.r.ax.g(string2)) {
                this.void.c().aB().T().void("region").a(string2, n3, "\u8bf4\uff1a" + string);
            }
        }
    }

    public void if(int n2, int n3, int n4, int n5, int n6) {
        p p2 = this.new(n2);
        if (p2 != null) {
            b.a.d.d d2 = p2.j();
            if (n3 != d2.void || n4 != d2.long) {
                d2.s = b.a.d.e.a(d2.void, d2.long, n3, n4);
            }
            p2.a(2, d2.void, d2.long, d2.void, d2.long, d2.s, n5);
            int n7 = this.O.try(n3);
            int n8 = this.O.int(n4) - 40;
            if (d2.af == 0) {
                n5 = n5 * 5 / 8;
                int n9 = b.a.d.e.if(d2.void, d2.long, n3, n4);
                b.a.b.g g2 = new b.a.b.g(1, p2.e(), p2.f(), n7, n8, n9, n5);
                this.O.do(g2);
                n5 += n9;
            }
            if (n6 > 0) {
                b.a.b.k k2 = new b.a.b.k(n6, n7, n8, n5);
                this.O.do(k2);
            }
            this.void.if("sound/hero_attack" + p2.j().af);
        }
    }

    public void if(int n2, int n3, int n4) {
        int n5 = this.byte.for();
        int n6 = 0;
        while (n6 < n5) {
            t t2 = (t)this.byte.if(n6);
            if (t2.m().if == n2) {
                t2.m().void = n3;
                t2.m().long = n4;
                t2.a(this.O.try(n3), this.O.int(n4));
                break;
            }
            ++n6;
        }
    }

    private int case() {
        int n2 = this.r.void;
        int n3 = this.r.long;
        if (this.q) {
            n2 = this.O.char() / this.O.b();
            n3 = this.O.c() / this.O.try();
        } else if (!(this.v <= 0 && this.t <= 0 || Math.abs(this.r.void - this.v) <= 1 && Math.abs(this.r.long - this.v) <= 1 && !this.a(this.v, this.t))) {
            n2 = this.v;
            n3 = this.t;
        }
        return n2 | n3 << 16;
    }

    public double else() {
        return this.U;
    }

    public void a(double d2) {
        this.U = d2;
    }

    public void a(int n2, String string, int n3, int n4, int n5, int n6, int n7) {
        this.g = this.void.j();
        this.r.long = 0;
        this.r.void = 0;
        this.r.ar = this.r.aL > 1 ? 2 : 0;
        this.ac = n2;
        this.goto = string;
        this.Y = n3;
        this.n.setBounds(n4 - n6, n5 - n7, n6 * 2, n7 * 2);
        this.O = null;
        this.g.a((q)null);
        this.f = this.void.do().getParameter("music" + n2);
        if (this.char == null || this.char.length() == 0) {
            this.char = this.void.do().getParameter("fightMusic");
        }
        Thread thread = new Thread((Runnable)this, "loadSceneThread");
        thread.start();
    }

    public void int(int n2, int n3) {
        this.K = true;
        if (this.r.void == n2 && this.r.long == n3) {
            this.r.s = b.a.d.e.a(this.y, this.w, n2, n3);
            this.void.c().ah().c(n2, n3);
            this.void.c().aB().do(n2, n3);
            this.void.c().aG().cU();
            this.new();
        } else {
            this.r.void = n2;
            this.r.long = n3;
            this.aa.c();
            this.aa.a(this.O.try(this.r.void), this.O.int(this.r.long));
        }
    }

    public k g() {
        return this.r;
    }

    public void a(int n2, int n3, int n4, int n5) {
        b.a.b.e e2 = this.if(n2);
        if (e2 != null) {
            int n6 = e2.d() - n3 - n4;
            if (n6 < 0) {
                n6 = 0;
            }
            e2.if(n6);
            if (n3 > 0) {
                e2.for(n3, n5);
            } else if (n4 > 0) {
                e2.int(n4, n5);
            }
            if (n6 <= 0) {
                this.ai.do(e2);
                if (this.F == e2) {
                    this.F.if(false);
                    this.F = null;
                    this.l = 0;
                }
                if (this.i == e2) {
                    this.i = null;
                }
            }
        }
    }

    public void do(int n2, int n3) {
        b.a.b.e e2 = this.if(n2);
        if (e2 != null) {
            e2.if(e2.d() + n3);
            e2.do(n3, 1000);
        }
    }
}
