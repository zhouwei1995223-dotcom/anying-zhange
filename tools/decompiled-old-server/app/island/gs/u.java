/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs;

import app.island.GameObject;
import app.island.a.a;
import app.island.a.b;
import app.island.a.c;
import app.island.data.DamageSpell;
import app.island.data.Goods;
import app.island.data.Spell;
import app.island.entity.BlockInfo;
import app.island.entity.Door;
import app.island.entity.EffectObject;
import app.island.entity.GroundGoods;
import app.island.entity.Hero;
import app.island.entity.Monster;
import app.island.entity.Npc;
import app.island.entity.Player;
import app.island.entity.SceneObject;
import app.island.entity.Sign;
import app.island.gs.ServerInfo;
import app.island.gs.c.i;
import app.island.gs.data.MonsterAIData;
import app.island.gs.data.PlunderData;
import app.island.gs.data.SceneConfigData;
import app.island.gs.e;
import app.island.gs.h;
import app.island.gs.k;
import app.island.gs.l;
import app.island.gs.m;
import app.island.gs.n;
import app.island.gs.p;
import app.island.gs.q;
import app.island.gs.r;
import app.island.gs.w;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class u
extends k
implements c {
    private SceneConfigData C;
    private BlockInfo v;
    private n[] k;
    private int p;
    private int G;
    private n[][] A;
    private h[][] l;
    private GroundGoods[][] o;
    private daff.a.h u;
    private EffectObject[][] z;
    private daff.a.h j;
    private daff.a.h n;
    private daff.a.h q;
    private daff.a.h r;
    private a t;
    private r B;
    private l m;
    private m y;
    private e H;
    private long s;
    private int x;
    private int w;
    private int D;
    private long E;
    private long F;

    public boolean L() {
        return this.C.sceneType != 2 && this.C.sceneType != 4 || this.x > 0 && this.a.for() != 0;
    }

    private void long(h h2, int n2) {
        String string;
        Object object;
        if (n2 != this.C.mapid) {
            return;
        }
        if (h2.g()) {
            return;
        }
        if (!this.m(h2)) {
            System.out.println("scene is full:" + h2.b() + ";" + h2.m() + ";" + h2.o() + ";" + this.C.mapid + ";" + this.try() + ";" + this.a.for() + ";" + this.p);
            h2.t();
            return;
        }
        if (!h2.r().visible) {
            this.l[h2.o()][h2.m()] = null;
        }
        h2.a(app.island.gs.p.long(h2.m(), h2.o()));
        int n3 = this.r.for();
        int n4 = 0;
        while (n4 < n3) {
            object = (q)this.r.if(n4);
            h2.a(app.island.gs.p.a(((q)object).a(), h2));
            ++n4;
        }
        n3 = this.q.for();
        n4 = 0;
        while (n4 < n3) {
            object = (Door)this.q.if(n4);
            h2.a(app.island.gs.p.a((SceneObject)object, h2));
            ++n4;
        }
        if (this.n != null) {
            n4 = 0;
            while (n4 < this.n.for()) {
                h2.a(app.island.gs.p.a((Sign)this.n.if(n4), h2));
                ++n4;
            }
        }
        h2.a(true);
        ++this.G;
        h2.a(this);
        this.a(h2, -65535, -65535, h2.m(), h2.o());
        if (this.C.playerEnterTip.length() > 1 && h2.r().gmGrade == 0) {
            String string2 = daff.a.b.a(this.C.playerEnterTip, "Y", h2.b());
            object = app.island.gs.p.d(string2);
            this.for.a((app.b.b)object);
        }
        if (this.H != null && (string = this.H.e().cityEnterTip).length() >= 5) {
            h2.a(app.island.gs.p.else(string));
        }
        if (h2.x() != null) {
            h2.x().goto(h2);
        }
    }

    private boolean do(n n2) {
        int n3;
        Monster monster = n2.g();
        if (monster.x == 0 && monster.y == 0) {
            monster.x = this.C.enterX;
            monster.y = this.C.enterY;
        }
        if ((n3 = this.for(monster.x, monster.y)) < 0) {
            return false;
        }
        int n4 = n3 & 0xFFFF;
        int n5 = n3 >> 16;
        monster.x = n4;
        monster.y = n5;
        this.A[n5][n4] = n2;
        return true;
    }

    public int v() {
        return this.x;
    }

    public void long(int n2) {
        this.x = n2;
    }

    public boolean a(int n2, int n3, int n4, int n5) {
        return Math.abs(n2 - n4) < this.C.viewRange && Math.abs(n3 - n5) < this.C.viewRange;
    }

    public boolean if(int n2, int n3, int n4, int n5, int n6) {
        return Math.abs(n2 - n4) < n6 && Math.abs(n3 - n5) < n6;
    }

    public h do(int n2, int n3) {
        return this.l[n3][n2];
    }

    public boolean if(h h2, Spell spell, int n2) {
        h h3 = this.a(n2);
        if (h3 == null || h3.i()) {
            return false;
        }
        Hero hero = h2.r();
        if (!hero.visible) {
            return false;
        }
        if (spell.spellType == 1 && !this.do(h2, h3)) {
            return false;
        }
        if (Math.abs(hero.x - h3.m()) > spell.releaseRange || Math.abs(hero.y - h3.o()) > spell.releaseRange) {
            return false;
        }
        if (h2 != h3) {
            hero.direction = SceneObject.getDirection(hero.x, hero.y, h3.m(), h3.o());
        }
        this.B.a(h2, spell, h3);
        return true;
    }

    public boolean a(h h2, int n2, boolean bl) {
        Hero hero = h2.r();
        if (bl || this.C.homeCity == this.int || this.C.homeCity == 0) {
            int n3;
            int n4 = this.C.enterX;
            int n5 = this.C.enterY;
            if (bl) {
                n4 = hero.x;
                n5 = hero.y;
            }
            if ((n3 = this.for(n4, n5)) >= 0) {
                h2.for(n2);
                int n6 = n3 & 0xFFFF;
                int n7 = n3 >> 16;
                if (n6 == hero.x && n7 == hero.y) {
                    this.l[hero.y][hero.x] = h2;
                } else {
                    h2.a(app.island.gs.p.long(n6, n7));
                    this.if(h2, n6, n7);
                }
            }
        } else {
            hero.life = hero.maxLife;
            this.for.a(h2, this.C.homeCity, 0, 0);
            if (h2.x() != null) {
                h2.x().else(h2);
            }
        }
        return true;
    }

    public void a(q q2, int n2, int n3) {
        Npc npc = q2.a();
        this.v.setBlockType(npc.x, npc.y, 127);
        npc.x = n2;
        npc.y = n3;
        this.v.setBlockType(npc.x, npc.y, 0);
        this.if(app.island.gs.p.a(npc));
    }

    public boolean a(int n2, int n3, String string, String string2, String string3, int n4) {
        q q2 = this.b(n2);
        if (q2 == null) {
            return false;
        }
        q2.a(n3, string, string2, string3, n4);
        int n5 = this.a.for();
        int n6 = 0;
        while (n6 < n5) {
            h h2 = (h)this.a.if(n6);
            if (h2.g()) {
                h2.a(app.island.gs.p.a((SceneObject)q2.a()));
                h2.a(app.island.gs.p.a(q2.a(), h2));
            }
            ++n6;
        }
        return true;
    }

    public boolean else(int n2) {
        int n3 = this.r.for();
        int n4 = 0;
        while (n4 < n3) {
            q q2 = (q)this.r.if(n4);
            if (q2.try() == n2) {
                this.r.a(n4);
                this.v.setBlockType(q2.byte(), q2.if(), 127);
                this.if(app.island.gs.p.a((SceneObject)q2.a()));
                return true;
            }
            ++n4;
        }
        return false;
    }

    public String P() {
        StringBuffer stringBuffer = new StringBuffer(this.p * 100);
        stringBuffer.append("X\u5750\u6807\tY\u5750\u6807\t\u602a\u7269\u6570\u636e\u7f16\u53f7\t\u602a\u7269\u6389\u843d\u7f16\u53f7\t\u602a\u7269\u884c\u4e3a\u7f16\u53f7\r\n");
        stringBuffer.append("x\ty\tmonsterID\tplunderID\tbehaviorID\r\n");
        int n2 = 0;
        while (n2 < this.p) {
            n n3 = this.k[n2];
            stringBuffer.append(n3.i());
            stringBuffer.append('\t');
            stringBuffer.append(n3.try());
            stringBuffer.append('\t');
            stringBuffer.append(n3.g().monsterID);
            stringBuffer.append('\t');
            stringBuffer.append(n3.g().plunderID);
            stringBuffer.append('\t');
            stringBuffer.append(n3.g().behaviorID);
            stringBuffer.append("\r\n");
            ++n2;
        }
        return stringBuffer.toString();
    }

    public boolean if(h h2, int n2, int n3) {
        if (n2 < 0 || n3 < 0 || n2 >= this.v.getWidth() || n3 >= this.v.getHeight()) {
            return false;
        }
        if (h2.i()) {
            return false;
        }
        Hero hero = h2.r();
        if (hero.x == n2 && hero.y == n3) {
            return false;
        }
        if (hero.visible && !this.a(n2, n3)) {
            return false;
        }
        int n4 = hero.x;
        int n5 = hero.y;
        if (this.l[hero.y][hero.x] == h2) {
            this.l[hero.y][hero.x] = null;
        }
        hero.x = n2;
        hero.y = n3;
        if (hero.visible) {
            this.l[hero.y][hero.x] = h2;
        }
        this.a(h2, n4, n5, hero.x, hero.y);
        h2.do();
        return true;
    }

    public String A() {
        int n2 = this.r.for();
        StringBuffer stringBuffer = new StringBuffer(n2 * 100);
        stringBuffer.append("\u7f16\u53f7\t\u540d\u5b57\t\u5750\u6807X\t\u5750\u6807Y\t\u56fe\u50cf\t\u5bf9\u8bdd\t\u5546\u5e97\t\u811a\u672c\r\n");
        stringBuffer.append("id\tname\tx\ty\timage\tdialog\tshop\tscript\r\n");
        int n3 = 0;
        while (n3 < n2) {
            q q2 = (q)this.r.if(n3);
            Npc npc = q2.a();
            stringBuffer.append("0\t");
            stringBuffer.append(npc.name);
            stringBuffer.append('\t');
            stringBuffer.append(npc.x);
            stringBuffer.append('\t');
            stringBuffer.append(npc.y);
            stringBuffer.append('\t');
            stringBuffer.append(npc.image);
            stringBuffer.append('\t');
            stringBuffer.append(npc.dialog);
            stringBuffer.append('\t');
            if (q2.new() != null) {
                stringBuffer.append(q2.new().try());
            } else {
                stringBuffer.append('0');
            }
            stringBuffer.append('\t');
            stringBuffer.append(npc.script);
            stringBuffer.append("\r\n");
            ++n3;
        }
        return stringBuffer.toString();
    }

    public int M() {
        return this.v.getHeight();
    }

    public int Q() {
        return this.C.viewRange;
    }

    private void void(h h2, int n2) {
        if (h2.i()) {
            h2.try("\u4f60\u5df2\u7ecf\u6b7b\u4e86\uff0c\u4e0d\u65b9\u4fbf\u4ea4\u6613");
            return;
        }
        h h3 = this.a(n2);
        if (h3 == h2) {
            h2.try("\u4e0d\u80fd\u9080\u8bf7\u81ea\u5df1");
            return;
        }
        if (h2.n() != null) {
            h2.try("\u4f60\u6b63\u5728\u4ea4\u6613\u4e2d");
            return;
        }
        if (h3 == null) {
            h2.try("\u76ee\u6807\u73a9\u5bb6\u4e0d\u5728\u5f53\u524d\u573a\u666f");
            return;
        }
        if (h3.i()) {
            h2.try("\u4ed6\u5df2\u7ecf\u6b7b\u4e86\uff0c\u4e0d\u65b9\u4fbf\u4ea4\u6613");
            return;
        }
        if (!this.a(h2.m(), h2.o(), h3.m(), h3.o())) {
            h2.try("\u8ddd\u79bb\u592a\u8fdc");
            return;
        }
        if (h3.n() != null) {
            h2.try("\u5bf9\u65b9\u6b63\u5728\u548c\u5176\u4ed6\u4eba\u4ea4\u6613\u4e2d");
            return;
        }
        String string = h2.b() + "-tradeInvite-" + h3.b();
        i i2 = this.for.do(string);
        if (i2 != null) {
            h2.try("\u4f60\u5df2\u7ecf\u9080\u8bf7\u8fc7\u5bf9\u65b9\u4e86");
            return;
        }
        app.island.gs.c.k k2 = new app.island.gs.c.k(h2, h3, string);
        this.for.a(k2);
        String string2 = h2.b() + "\u9080\u8bf7\u4f60\u4ea4\u6613\uff0c\u4f60\u540c\u610f\u5417\uff1f";
        app.b.b b2 = app.island.gs.p.a(h2.b(), string, string2);
        h3.a(b2);
        h2.do("\u5df2\u5c06\u9080\u8bf7\u53d1\u9001\u7ed9\u300e" + h3.b() + "\u300f");
    }

    public void a(app.b.b b2, int n2, int n3, h h2) {
        int n4 = this.a.for();
        int n5 = 0;
        while (n5 < n4) {
            h h3 = (h)this.a.if(n5);
            if (h3.g() && h3 != h2 && this.a(n2, n3, h3.m(), h3.o())) {
                h3.a(b2);
            }
            ++n5;
        }
    }

    public boolean a(h h2, Spell spell, int n2, int n3) {
        Hero hero = h2.r();
        if (!hero.visible || Math.abs(hero.x - n2) > spell.releaseRange || Math.abs(hero.y - n3) > spell.releaseRange) {
            return false;
        }
        if (!this.byte(n2, n3)) {
            return false;
        }
        hero.direction = SceneObject.getDirection(hero.x, hero.y, n2, n3);
        this.B.a(h2, spell, n2, n3);
        return true;
    }

    public boolean a(Door door) {
        door.id = this.q.for() + 1;
        this.q.if(door);
        int n2 = this.a.for();
        int n3 = 0;
        while (n3 < n2) {
            h h2 = (h)this.a.if(n3);
            if (h2.g()) {
                h2.a(app.island.gs.p.a(door, h2));
            }
            ++n3;
        }
        return true;
    }

    public void try(int n2, int n3) {
        int n4 = this.j.for();
        int n5 = 0;
        while (n5 < n4) {
            EffectObject effectObject = (EffectObject)this.j.if(n5);
            if (this.a(effectObject.x, effectObject.y, n2, n3)) {
                effectObject.lifeTime = 0;
            }
            ++n5;
        }
    }

    public int w() {
        return this.C.mapid;
    }

    public int q() {
        return this.C.homeCity;
    }

    public void a(Goods goods, int n2, int n3, int n4, int n5) {
        if (this.C.goodsLifeTime <= 0) {
            return;
        }
        GroundGoods groundGoods = new GroundGoods();
        groundGoods.id = ServerInfo.globalGroundIDCounter++;
        groundGoods.name = goods.name;
        groundGoods.ownerID = n2;
        groundGoods.data = goods;
        int n6 = this.new(n4, n5);
        if (n6 == 0) {
            return;
        }
        groundGoods.x = n6 & 0xFFFF;
        groundGoods.y = n6 >> 16;
        groundGoods.remainedLifeTime = this.C.goodsLifeTime * 1000;
        if (n3 > 0) {
            groundGoods.ownerID = Integer.MAX_VALUE;
            groundGoods.remainedProtectionTime = n3 * 1000;
        } else {
            groundGoods.remainedProtectionTime = this.C.goodsProtectionTime * 1000;
        }
        this.u.if(groundGoods);
        this.o[groundGoods.y][groundGoods.x] = groundGoods;
        this.a(groundGoods);
    }

    protected void int(h h2) {
        if (h2.j() == this) {
            new Exception("\u91cd\u590d\u8fdb\u5165\uff1a" + h2).printStackTrace();
        }
        h2.a(false);
        h2.do(this);
        h2.r().sceneID = this.C.id;
        h2.r().sceneName = this.C.name;
        h2.long();
        h2.a(app.island.gs.p.a(h2.r(), this));
        h2.a(app.island.gs.p.byte(h2.r()));
    }

    protected void if(EffectObject effectObject) {
        if (effectObject.animation > 0) {
            this.a(app.island.gs.p.a(effectObject, null), effectObject.x, effectObject.y, null);
        }
    }

    public int u() {
        return this.C.earningLevelWeakening;
    }

    private void do(h h2, int n2, int n3) {
        if (h2.i()) {
            return;
        }
        if (Math.abs(n2 - h2.m()) > 1 || Math.abs(n3 - h2.o()) > 1) {
            return;
        }
        GroundGoods groundGoods = this.o[n3][n2];
        if (groundGoods == null) {
            return;
        }
        Hero hero = h2.r();
        if (!(groundGoods.ownerID == 0 || groundGoods.remainedProtectionTime <= 0 || groundGoods.ownerID == hero.id || h2.x() != null && h2.x().for(groundGoods.ownerID))) {
            h2.if("\u65e0\u6cd5\u62fe\u53d6\u522b\u4eba\u7684\u7269\u54c1");
            return;
        }
        int n4 = hero.personalDepot.getNextFreePos();
        if (n4 < 0) {
            h2.if("\u80cc\u5305\u5df2\u6ee1");
            return;
        }
        this.o[n3][n2] = null;
        this.u.do(groundGoods);
        this.if(groundGoods);
        h2.a(groundGoods.data);
        h2.C();
    }

    public m O() {
        return this.y;
    }

    public int t() {
        return this.C.enterY;
    }

    protected void if(GroundGoods groundGoods) {
        this.a(app.island.gs.p.a(groundGoods), groundGoods.x, groundGoods.y, null);
    }

    public int o() {
        return this.C.plunderMoneyRate;
    }

    public int N() {
        return this.C.plunderGoodsRate;
    }

    public void I() {
        u u2 = this.for.do(this.C.homeCity);
        if (u2 == null) {
            return;
        }
        int n2 = this.a.for();
        int n3 = 0;
        while (n3 < n2) {
            h h2 = (h)this.a.if(n3);
            h2.if(0, 0);
            if (h2.i()) {
                h2.r().life = 1;
            }
            u2.if(h2);
            ++n3;
        }
        this.a.a();
    }

    protected void a(h h2) {
        Hero hero = h2.r();
        hero.sceneName = "";
        if (h2.g() && hero.visible) {
            this.G += -1;
            this.a(h2, hero.x, hero.y, -65535, -65535);
        }
        if (this.l[hero.y][hero.x] == h2) {
            this.l[hero.y][hero.x] = null;
        }
        h2.a(false);
        h2.do((u)null);
        if (h2.D() != null) {
            this.D += -1;
        }
        h2.if(this);
        if (!h2.goto()) {
            hero.sceneLifeTime = 0;
            hero.sceneID = 0;
            if (hero.life <= 0 || this.C.saveHeroPos <= 0) {
                hero.y = 0;
                hero.x = 0;
                hero.sceneID = this.C.homeCity;
            } else if (this.int >= 1000000 && this.C.saveHeroPos > 0) {
                hero.sceneLifeTime = this.x;
                hero.sceneID = this.C.id;
            } else {
                hero.sceneID = this.int;
            }
        }
        if (h2.x() != null) {
            h2.x().try(h2);
        }
    }

    public void a(n n2, h h2, DamageSpell damageSpell) {
        this.B.a(n2, h2.m(), h2.o(), damageSpell);
    }

    protected void a(EffectObject effectObject) {
        if (effectObject.animation > 0) {
            this.a(app.island.gs.p.a(effectObject), effectObject.x, effectObject.y, null);
        }
    }

    public int K() {
        return this.C.sceneType;
    }

    public boolean a(n n2, int n3, int n4) {
        Monster monster = n2.g();
        if (monster.x == n3 && monster.y == n4) {
            new Exception("\u602a\u7269\u539f\u5730\u79fb\u52a8:" + monster.id + ";" + monster.x + ";" + monster.y + ";scene=" + this.try()).printStackTrace();
            return false;
        }
        if (!this.a(n3, n4)) {
            new Exception("\u602a\u7269\u975e\u6cd5\u79fb\u52a8\uff1a" + n2.void() + ";" + n3 + ";" + n4).printStackTrace();
            return false;
        }
        int n5 = monster.x;
        int n6 = monster.y;
        if (this.A[monster.y][monster.x] == n2) {
            this.A[monster.y][monster.x] = null;
        }
        monster.x = n3;
        monster.y = n4;
        this.A[monster.y][monster.x] = n2;
        this.a(n2, n5, n6, monster.x, monster.y);
        return true;
    }

    public boolean a(h h2, Spell spell, int n2) {
        n n3 = this.void(n2);
        if (n3 == null || !n3.goto()) {
            return false;
        }
        Hero hero = h2.r();
        if (!hero.visible || Math.abs(hero.x - n3.i()) > spell.releaseRange || Math.abs(hero.y - n3.try()) > spell.releaseRange) {
            return false;
        }
        hero.direction = SceneObject.getDirection(hero.x, hero.y, n3.i(), n3.try());
        this.B.a(h2, spell, n3);
        return true;
    }

    public boolean a(int n2, int n3, int n4, int n5, int n6) {
        n n7 = this.void(n2);
        if (n7 == null) {
            return false;
        }
        Monster monster = app.island.gs.w.case().for(n3);
        if (monster == null) {
            return false;
        }
        MonsterAIData monsterAIData = app.island.gs.w.case().goto(n4);
        if (monsterAIData == null) {
            return false;
        }
        boolean bl = monsterAIData != n7.do();
        PlunderData plunderData = app.island.gs.w.case().char(n5);
        n7.a(monster, monsterAIData, plunderData);
        int n8 = this.a.for();
        int n9 = 0;
        while (n9 < n8) {
            h h2 = (h)this.a.if(n9);
            if (h2.g() && this.a(h2.m(), h2.o(), n7.i(), n7.try())) {
                h2.a(app.island.gs.p.a((SceneObject)n7.g()));
                h2.a(app.island.gs.p.a(n7.g(), h2));
                if (bl && h2.r().visible) {
                    n7.do(h2);
                }
            }
            ++n9;
        }
        return true;
    }

    public long H() {
        return this.s;
    }

    public void if(n n2) {
        this.f(n2.new());
    }

    public void f(int n2) {
        int n3 = 0;
        while (n3 < this.p) {
            if (this.k[n3].new() == n2) {
                n n4 = this.k[n3];
                this.p += -1;
                this.k[n3] = this.k[this.p];
                this.k[this.p] = null;
                if (this.A[n4.try()][n4.i()] == n4) {
                    this.A[n4.try()][n4.i()] = null;
                }
                if (!n4.goto()) break;
                this.a(n4, n4.i(), n4.try(), -65535, -65535);
                break;
            }
            ++n3;
        }
    }

    public boolean a(n n2) {
        Monster monster = n2.g();
        int n3 = n2.d();
        int n4 = n3 & 0xFFFF;
        int n5 = n3 >> 16;
        if ((n3 = this.for(n4, n5)) < 0) {
            return false;
        }
        n4 = n3 & 0xFFFF;
        n5 = n3 >> 16;
        if (n4 != monster.x || n5 != monster.y) {
            if (this.A[monster.y][monster.x] == n2) {
                this.A[monster.y][monster.x] = null;
            }
            monster.x = n4;
            monster.y = n5;
        }
        this.A[n5][n4] = n2;
        monster.life = monster.maxLife;
        monster.mana = monster.maxMana;
        this.a(n2, -65535, -65535, monster.x, monster.y);
        return true;
    }

    public boolean a(int n2, int n3, int n4, String string, String string2, String string3, int n5) {
        q q2 = new q();
        q2.a(this);
        q2.a(n2, n3, n4, string, string2, string3, n5);
        this.r.if(q2);
        int n6 = this.a.for();
        int n7 = 0;
        while (n7 < n6) {
            h h2 = (h)this.a.if(n7);
            if (h2.g()) {
                h2.a(app.island.gs.p.a(q2.a(), h2));
            }
            ++n7;
        }
        return true;
    }

    public void a(h h2, int n2, daff.a.e e2) {
        if (!h2.g() && n2 != 257) {
            return;
        }
        switch (n2) {
            default: {
                break;
            }
            case 257: {
                int n3 = e2.i();
                this.long(h2, n3);
                break;
            }
            case 258: {
                int n4 = e2.for() % 8;
                h2.f(n4);
                break;
            }
            case 259: {
                int n5 = e2.for();
                int n6 = e2.for();
                h2.a(n5, n6);
                break;
            }
            case 260: {
                int n7 = e2.i();
                h2.d(n7);
                break;
            }
            case 261: {
                int n8;
                q q2;
                if (h2.k() != null || (q2 = this.b(n8 = e2.i())) == null) break;
                q2.a(h2);
                break;
            }
            case 262: {
                String string = e2.h();
                this.for(h2, string);
                break;
            }
            case 263: {
                int n9 = e2.i();
                this.do(n9, h2);
                break;
            }
            case 265: {
                int n10 = e2.for();
                int n11 = e2.for();
                this.do(h2, n10, n11);
                break;
            }
            case 266: {
                int n12 = e2.i();
                int n13 = e2.for();
                int n14 = e2.for();
                h2.a(n12, n13, n14);
                break;
            }
            case 267: {
                int n15 = e2.i();
                int n16 = e2.i();
                h2.for(n15, n16);
                break;
            }
            case 268: {
                int n17 = e2.i();
                int n18 = e2.i();
                h2.new(n17, n18);
                break;
            }
            case 270: {
                int n19 = e2.i();
                this.void(h2, n19);
                break;
            }
            case 271: {
                int n20 = e2.i();
                h h3 = this.a(n20);
                if (h3 == null || h3 == h2 || !h3.g()) break;
                h2.a(app.island.gs.p.if(h3.r()));
                break;
            }
            case 272: {
                int n21 = e2.i();
                Door door = this.goto(n21);
                Hero hero = h2.r();
                if (door == null || Math.abs(door.x - h2.m()) >= 3 || Math.abs(door.y - h2.o()) >= 3) break;
                if (door.levelRequired > hero.level) {
                    h2.try("\u4f60\u7b49\u7ea7\u4e0d\u591f\uff0c\u4e0d\u80fd\u4f20\u9001\uff0c\u9700\u8981\u7b49\u7ea7" + door.levelRequired);
                    break;
                }
                if (door.raceRequired > 0 && door.raceRequired - 1 != hero.race) {
                    h2.try("\u4f60\u804c\u4e1a\u4e0d\u7b26\uff0c\u4e0d\u80fd\u4f20\u9001\uff0c\u9650\u5236" + Player.RACE_NAMES[door.raceRequired - 1]);
                    break;
                }
                this.for.a(h2, door.destSceneID, door.destX, door.destY);
                break;
            }
        }
    }

    public n int(int n2, int n3) {
        return this.A[n3][n2];
    }

    private void a(h h2, int n2, int n3, int n4, int n5) {
        boolean bl;
        boolean bl2;
        Object object;
        Hero hero = h2.r();
        int n6 = this.a.for();
        int n7 = 0;
        while (n7 < n6) {
            object = (h)this.a.if(n7);
            if (((h)object).g() && object != h2) {
                bl2 = this.a(((h)object).m(), ((h)object).o(), n2, n3);
                bl = this.a(((h)object).m(), ((h)object).o(), n4, n5);
                if (bl2 && bl) {
                    if (hero.visible) {
                        ((h)object).a(app.island.gs.p.a(hero, n2, n3, n4, n5, ((h)object).r()));
                    }
                } else if (bl2 && !bl) {
                    if (hero.visible) {
                        ((h)object).a(app.island.gs.p.a((SceneObject)hero));
                    }
                } else if (!bl2 && bl) {
                    if (hero.visible) {
                        ((h)object).a(app.island.gs.p.a((SceneObject)hero, (h)object));
                    }
                    if (((h)object).r().visible) {
                        h2.a(app.island.gs.p.a((SceneObject)((h)object).r(), h2));
                    }
                }
            }
            ++n7;
        }
        n7 = 0;
        while (n7 < this.p) {
            if (this.k[n7].goto()) {
                boolean bl3 = this.a(this.k[n7].i(), this.k[n7].try(), n2, n3);
                bl2 = this.a(this.k[n7].i(), this.k[n7].try(), n4, n5);
                if (bl3 && bl2) {
                    if (hero.visible) {
                        this.k[n7].a(h2);
                    }
                } else if (bl3 && !bl2) {
                    if (hero.visible) {
                        this.k[n7].if(h2);
                    }
                } else if (!bl3 && bl2) {
                    if (hero.visible) {
                        this.k[n7].do(h2);
                    }
                    h2.a(app.island.gs.p.a(this.k[n7].g(), h2));
                }
            }
            ++n7;
        }
        n6 = this.u.for();
        n7 = 0;
        while (n7 < n6) {
            object = (GroundGoods)this.u.if(n7);
            bl2 = this.a(((SceneObject)object).x, ((SceneObject)object).y, n2, n3);
            bl = this.a(((SceneObject)object).x, ((SceneObject)object).y, n4, n5);
            if (!bl2 && bl) {
                h2.a(app.island.gs.p.a((SceneObject)object, h2));
            }
            ++n7;
        }
        n6 = this.j.for();
        n7 = 0;
        while (n7 < n6) {
            object = (EffectObject)this.j.if(n7);
            bl2 = this.a(((SceneObject)object).x, ((SceneObject)object).y, n2, n3);
            bl = this.a(((SceneObject)object).x, ((SceneObject)object).y, n4, n5);
            if (!bl2 && bl) {
                h2.a(app.island.gs.p.a((SceneObject)object, h2));
            }
            ++n7;
        }
        if (this.n != null) {
            n7 = this.n.for();
            int n8 = 0;
            while (n8 < n7) {
                Sign sign = (Sign)this.n.if(n8);
                bl = this.a(sign.x, sign.y, n2, n3);
                boolean bl4 = this.a(sign.x, sign.y, n4, n5);
                if (!bl && bl4) {
                    h2.a(app.island.gs.p.try(sign.id, sign.life, 0));
                }
                ++n8;
            }
        }
        if (hero.joinedGuild != null && hero.joinedGuild.placedSign != null && hero.joinedGuild.placedSign.fightState != null && hero.joinedGuild.placedSign.sceneID == this.try()) {
            n7 = this.if(n2, n3, hero.joinedGuild.placedSign.x, hero.joinedGuild.placedSign.y, 10) ? 1 : 0;
            boolean bl5 = this.if(n4, n5, hero.joinedGuild.placedSign.x, hero.joinedGuild.placedSign.y, 10);
            if (n7 == 0 && bl5) {
                h2.a(hero.joinedGuild.placedSign.fightState);
            } else if (n7 != 0 && !bl5) {
                h2.I();
            }
        }
        if (h2.x() != null) {
            h2.x().char(h2);
        }
    }

    public l E() {
        return this.m;
    }

    public int x() {
        return this.v.getWidth();
    }

    public void a(h h2, n n2) {
        int n3 = h2.m();
        int n4 = h2.o();
        int n5 = 0;
        while (n5 < this.p) {
            boolean bl;
            n n6 = this.k[n5];
            if (n6.goto() && (bl = this.a(n3, n4, n6.i(), n6.try()))) {
                n6.a(h2, n2);
            }
            ++n5;
        }
    }

    public void for(h h2, h h3) {
        if (h3.r().visible && this.C.sceneType != 1) {
            app.b.b b2 = app.island.gs.p.a(h3.b(), h2.b());
            this.a(b2, null);
        }
    }

    public int r() {
        return this.C.enterX;
    }

    public boolean a(int n2, int n3, int n4, int n5, int n6, int n7) {
        Monster monster = app.island.gs.w.case().for(n4);
        if (monster == null) {
            return false;
        }
        MonsterAIData monsterAIData = app.island.gs.w.case().goto(n5);
        if (monsterAIData == null) {
            return false;
        }
        PlunderData plunderData = app.island.gs.w.case().char(n6);
        monster = (Monster)GameObject.cloneObject(monster);
        n n8 = new n();
        n8.a(this);
        n8.a(monster, n2, n3, monsterAIData, plunderData);
        if (this.k.length <= this.p) {
            n[] nArray = new n[this.p + this.C.monsterCreatableCount];
            System.arraycopy(this.k, 0, nArray, 0, this.p);
            this.k = nArray;
        }
        this.k[this.p++] = n8;
        if (n8.goto()) {
            this.do(n8);
            this.a(n8, -65535, -65535, n8.i(), n8.try());
        }
        n8.a(n7);
        return true;
    }

    public boolean do(h h2, String string) {
        if (this.D < this.C.personalShopLimit) {
            ++this.D;
            this.a(app.island.gs.p.if(h2.H(), string), h2.m(), h2.o(), null);
            return true;
        }
        return false;
    }

    public int new(int n2, int n3) {
        if (!this.v.isWalkable(n2, n3) || this.o[n3][n2] != null) {
            int n4 = this.v.getWidth();
            int n5 = this.v.getHeight();
            int n6 = 1;
            do {
                int n7 = Math.max(0, n2 - n6);
                int n8 = Math.max(0, n3 - n6);
                int n9 = Math.min(n2 + n6, n4);
                int n10 = Math.min(n3 + n6, n5);
                int n11 = n8;
                while (n11 < n10) {
                    int n12 = n7;
                    while (n12 < n9) {
                        if (this.v.isWalkable(n12, n11) && this.o[n11][n12] == null) {
                            return n12 | n11 << 16;
                        }
                        ++n12;
                    }
                    ++n11;
                }
            } while (++n6 < 65535);
            return 0;
        }
        return n2 | n3 << 16;
    }

    public int if() {
        return this.v.getHeight();
    }

    public a J() {
        return this.t;
    }

    public int s() {
        int n2 = 0;
        int n3 = this.a.for();
        int n4 = 0;
        while (n4 < n3) {
            h h2 = (h)this.a.if(n4);
            if (h2.g() && !h2.i() && h2.r().visible) {
                ++n2;
            }
            ++n4;
        }
        return n2;
    }

    public void a(SceneConfigData sceneConfigData) {
        Object object;
        String[] stringArray;
        int n2;
        String[] stringArray2;
        int n3;
        String[] stringArray3;
        String string;
        this.C = sceneConfigData;
        this.do(sceneConfigData.id);
        this.a(sceneConfigData.name);
        this.if(sceneConfigData.heroCountLimit);
        this.a = new daff.a.h(255);
        this.u = new daff.a.h(255);
        this.j = new daff.a.h(255);
        this.B = new r();
        this.B.a(this);
        this.m = new l();
        this.m.a(this);
        this.y = new m();
        this.y.a(this);
        this.t = new b();
        byte[] byArray = daff.a.b.new("data/map/" + sceneConfigData.mapid + ".blk");
        daff.a.e e2 = new daff.a.e(byArray);
        this.v = new BlockInfo();
        this.v.load(e2);
        int n4 = this.v.getWidth();
        int n5 = this.v.getHeight();
        this.A = new n[n5][n4];
        this.l = new h[n5][n4];
        this.o = new GroundGoods[n5][n4];
        this.z = new EffectObject[n5][n4];
        byArray = daff.a.b.new("config/monster/" + sceneConfigData.id + ".txt");
        if (byArray != null) {
            string = new String(byArray);
            stringArray3 = daff.a.b.a(string, "\r\n");
            n3 = stringArray3.length - 2;
            if (stringArray3[stringArray3.length - 1].length() == 0) {
                --n3;
            }
            stringArray2 = daff.a.b.a(stringArray3[0], "\t");
            this.k = new n[n3 + sceneConfigData.monsterCreatableCount];
            this.p = n3;
            n2 = 0;
            while (n2 < n3) {
                stringArray = daff.a.b.a(stringArray3[n2 + 2], "\t");
                this.k[n2] = new n();
                this.k[n2].a(this);
                this.k[n2].a(stringArray2, stringArray);
                if (this.k[n2].goto()) {
                    this.do(this.k[n2]);
                }
                ++n2;
            }
        } else {
            this.k = new n[sceneConfigData.monsterCreatableCount];
            this.p = 0;
        }
        byArray = daff.a.b.new("config/npc/" + sceneConfigData.id + ".txt");
        if (byArray != null) {
            string = new String(byArray);
            stringArray3 = daff.a.b.a(string, "\r\n");
            n3 = stringArray3.length - 2;
            if (stringArray3[stringArray3.length - 1].length() == 0) {
                --n3;
            }
            stringArray2 = daff.a.b.a(stringArray3[1], "\t");
            this.r = new daff.a.h(n3 + 2);
            n2 = 0;
            while (n2 < n3) {
                stringArray = new q();
                stringArray.a(this);
                object = daff.a.b.a(stringArray3[n2 + 2], "\t");
                stringArray.a(stringArray2, (String[])object);
                this.v.setBlockType(stringArray.byte(), stringArray.if(), 0);
                this.r.if(stringArray);
                ++n2;
            }
        } else {
            this.r = new daff.a.h(2);
        }
        byArray = daff.a.b.new("config/door/" + sceneConfigData.id + ".txt");
        if (byArray != null) {
            string = new String(byArray);
            stringArray3 = daff.a.b.a(string, "\r\n");
            n3 = stringArray3.length - 2;
            if (stringArray3[stringArray3.length - 1].length() == 0) {
                --n3;
            }
            stringArray2 = daff.a.b.a(stringArray3[1], "\t");
            this.q = new daff.a.h(n3 + 2);
            n2 = 0;
            while (n2 < n3) {
                stringArray = daff.a.b.a(stringArray3[n2 + 2], "\t");
                object = new Door();
                ((GameObject)object).id = n2 + 10;
                int n6 = 0;
                while (n6 < stringArray.length) {
                    ((GameObject)object).setAttributeValue(stringArray2[n6], stringArray[n6]);
                    ++n6;
                }
                this.q.if(object);
                ++n2;
            }
        } else {
            this.q = new daff.a.h(2);
        }
        this.s = System.currentTimeMillis();
        this.x = Integer.MAX_VALUE;
    }

    protected void l(h h2) {
        Hero hero = h2.r();
        if (this.l[hero.y][hero.x] == h2) {
            this.l[hero.y][hero.x] = null;
        }
    }

    public boolean C() {
        return this.C.specialUsable > 0;
    }

    public int for(int n2, int n3) {
        if (!this.a(n2, n3)) {
            int n4 = this.v.getWidth();
            int n5 = this.v.getHeight();
            int n6 = 1;
            do {
                int n7 = Math.max(0, n2 - n6);
                int n8 = Math.max(0, n3 - n6);
                int n9 = Math.min(n2 + n6, n4);
                int n10 = Math.min(n3 + n6, n5);
                int n11 = n8;
                while (n11 < n10) {
                    int n12 = n7;
                    while (n12 < n9) {
                        if (this.a(n12, n11)) {
                            return n12 | n11 << 16;
                        }
                        ++n12;
                    }
                    ++n11;
                }
            } while (++n6 < 65535);
            return -1;
        }
        return n2 | n3 << 16;
    }

    public void a(Sign sign) {
        if (this.C.sceneType != 0) {
            return;
        }
        sign.id = sign.targetGuild.id + 50000000;
        sign.name = sign.targetGuild.name;
        sign.level = sign.targetGuild.level;
        sign.maxLife = 200000;
        sign.life = 200000;
        sign.fightState = app.island.gs.w.case().b(sign.stateID);
        sign.sceneID = this.try();
        sign.sceneName = this.int();
        sign.lastAddReputationTime = System.currentTimeMillis();
        this.if(app.island.gs.p.a(sign, null));
        if (this.n == null) {
            this.n = new daff.a.h(100);
        }
        this.n.if(sign);
        if (sign.fightState != null) {
            int n2 = this.a.for();
            int n3 = 0;
            while (n3 < n2) {
                h h2 = (h)this.a.if(n3);
                Hero hero = h2.r();
                if (hero.joinedGuild == sign.targetGuild && this.a(hero.x, hero.y, sign.x, sign.y)) {
                    h2.a(sign.fightState);
                }
                ++n3;
            }
        }
    }

    public boolean for(h h2, int n2, int n3) {
        Hero hero = h2.r();
        if (Math.abs(hero.x - n2) > hero.attackRange || Math.abs(hero.y - n3) > hero.attackRange) {
            return false;
        }
        int n4 = 1;
        hero.direction = SceneObject.getDirection(hero.x, hero.y, n2, n3);
        n n5 = this.int(n2, n3);
        if (n5 != null && this.if(h2, n5)) {
            n4 = this.B.a(h2, n5);
        } else {
            h h3 = this.do(n2, n3);
            if (h3 != null && this.do(h2, h3)) {
                n4 = this.B.a(h2, h3);
            }
        }
        this.a(app.island.gs.p.if(hero, n2, n3, n4), hero.x, hero.y, h2);
        h2.a(app.island.gs.p.else(n2, n3, n4));
        return true;
    }

    public boolean goto(h h2, int n2) {
        Hero hero = h2.r();
        int n3 = -1;
        int n4 = 0;
        int n5 = 0;
        if (n2 < 50000000) {
            h h3 = this.a(n2);
            if (h3 != null) {
                if (h3.r().visible) {
                    n4 = h3.m();
                    n5 = h3.o();
                    n3 = 1;
                } else {
                    h3 = null;
                }
            }
            if (h3 != null && this.do(h2, h3) && Math.abs(hero.x - h3.m()) <= hero.attackRange && Math.abs(hero.y - h3.o()) <= hero.attackRange) {
                n3 = this.B.a(h2, h3);
            }
        } else if (n2 < 60000000) {
            Sign sign = this.d(n2);
            if (sign != null && this.a(h2, sign)) {
                int n6 = this.B.a(h2, sign);
                sign.life -= n6;
                this.a(app.island.gs.p.try(sign.id, sign.life, hero.getAttackTime()), sign.x, sign.y, null);
                ((e)sign.targetGuild.attachment).a(h2, n6, sign);
                n4 = sign.x;
                n5 = sign.y;
                n3 = 0;
            }
        } else {
            n n7 = this.void(n2);
            if (n7 != null) {
                n4 = n7.i();
                n5 = n7.try();
                n3 = 1;
            }
            if (n7 != null && this.if(h2, n7) && Math.abs(hero.x - n7.i()) <= hero.attackRange && Math.abs(hero.y - n7.try()) <= hero.attackRange) {
                n3 = this.B.a(h2, n7);
            }
        }
        if (n3 >= 0) {
            this.a(app.island.gs.p.if(hero, n4, n5, n3), hero.x, hero.y, h2);
            h2.a(app.island.gs.p.else(n4, n5, n3));
            return true;
        }
        return false;
    }

    public boolean a(n n2, h h2) {
        Monster monster = n2.g();
        Hero hero = h2.r();
        hero.direction = SceneObject.getDirection(monster.x, monster.y, hero.x, hero.y);
        int n3 = this.B.a(n2, h2);
        this.a(app.island.gs.p.if(monster, hero.x, hero.y, n3), monster.x, monster.y, null);
        return true;
    }

    private void for(h h2, String string) {
        if (h2.r().chatable) {
            this.a(app.island.gs.p.a(h2, string), h2.m(), h2.o(), null);
        }
    }

    public int F() {
        return this.C.stateData;
    }

    public void e(int n2) {
        this.C.stateData = n2;
    }

    public int G() {
        return this.w;
    }

    public void byte() {
        h h2;
        h h3;
        int n2;
        int n3;
        if ((this.C.sceneType == 2 || this.C.sceneType == 4) && ServerInfo.currentMilliSecond - this.E >= 1000L) {
            this.E = ServerInfo.currentMilliSecond;
            this.x += -1;
            this.a(app.island.gs.p.g(this.x));
        }
        if (this.C.unitExpRate > 0 && ServerInfo.currentMilliSecond - this.F > 1000L) {
            this.F = ServerInfo.currentMilliSecond;
            n3 = this.a.for();
            n2 = 0;
            while (n2 < n3) {
                h3 = (h)this.a.if(n2);
                if (h3.g() && !h3.i() && !h3.void()) {
                    int n4 = h3.r().level;
                    int n5 = n4 * n4 / 10 + 20;
                    n5 = n5 * this.C.unitExpRate / 100;
                    if (h3.r().doubleExpLifeTime > 0) {
                        n5 *= 2;
                    }
                    h3.int(n5 *= ServerInfo.expTimes);
                }
                ++n2;
            }
        }
        n3 = this.a.for();
        n2 = 0;
        while (n2 < n3) {
            h3 = (h)this.a.if(n2);
            if (h3.g()) {
                h3.y();
            }
            ++n2;
        }
        if (ServerInfo.updatingCounter % 20 == 0) {
            n2 = this.j.for();
            int n6 = 0;
            while (n6 < n2) {
                EffectObject effectObject = (EffectObject)this.j.if(n6);
                effectObject.lifeTime -= 200;
                if (effectObject.lifeTime <= 0) {
                    this.j.a(n6--);
                    --n2;
                    this.z[effectObject.y][effectObject.x] = null;
                    this.a(effectObject);
                } else if (ServerInfo.currentMilliSecond - effectObject.lastDamageTime > (long)effectObject.delayTime) {
                    effectObject.lastDamageTime = ServerInfo.currentMilliSecond;
                    n n7 = this.int(effectObject.x, effectObject.y);
                    h2 = this.do(effectObject.x, effectObject.y);
                    if (n7 != null && n7.goto()) {
                        this.B.a(n7, effectObject);
                    } else if (h2 != null && this.do((h)effectObject.userData, h2)) {
                        this.B.a(h2, effectObject);
                    }
                }
                ++n6;
            }
        }
        if (this.G > 0) {
            n2 = 0;
            while (n2 < this.p) {
                n n8 = this.k[n2];
                n8.c();
                if (this.A[n8.try()][n8.i()] != n8 && n8.goto()) {
                    System.out.println("\u602a\u7269\u4f4d\u7f6e\u51fa\u9519\uff1a" + n8.void() + ";" + n8.i() + ";" + n8.try() + "/" + this.A[n8.try()][n8.i()]);
                }
                ++n2;
            }
        }
        if (ServerInfo.updatingCounter % 100 == 0) {
            n2 = this.u.for();
            int n9 = 0;
            while (n9 < n2) {
                GroundGoods groundGoods = (GroundGoods)this.u.if(n9);
                groundGoods.remainedLifeTime -= 1000;
                groundGoods.remainedProtectionTime -= 1000;
                if (groundGoods.remainedLifeTime <= 0) {
                    this.u.a(n9--);
                    --n2;
                    this.o[groundGoods.y][groundGoods.x] = null;
                    this.if(groundGoods);
                }
                ++n9;
            }
        }
        if (ServerInfo.updatingCounter % 100 == 0) {
            n2 = this.r.for();
            int n10 = 0;
            while (n10 < n2) {
                q q2 = (q)this.r.if(n10);
                q2.case();
                ++n10;
            }
        }
        if (this.n != null && ServerInfo.updatingCounter % 300 == 0) {
            n2 = this.n.for();
            int n11 = 0;
            while (n11 < n2) {
                Sign sign = (Sign)this.n.if(n11);
                if (sign.life <= 0 || sign.targetGuild.deleted) {
                    if (sign.fightState != null) {
                        int n12 = 0;
                        while (n12 < this.a.for()) {
                            h2 = (h)this.a.if(n12);
                            Hero hero = h2.r();
                            if (hero.joinedGuild == sign.targetGuild && this.a(hero.x, hero.y, sign.x, sign.y)) {
                                h2.I();
                            }
                            ++n12;
                        }
                    }
                    sign.targetGuild.placedSign = null;
                    this.n.a(n11);
                    --n11;
                    --n2;
                    this.if(app.island.gs.p.try(sign.id, 0, 0));
                    sign.targetGuild.placedSign = null;
                } else if (sign.life < sign.maxLife) {
                    int n13 = Math.min(sign.maxLife / 1000, sign.maxLife - sign.life);
                    sign.life += n13;
                    this.a(app.island.gs.p.try(sign.id, sign.life, 1000), sign.x, sign.y, null);
                }
                ++n11;
            }
        }
    }

    public q case(String string) {
        int n2 = this.r.for();
        int n3 = 0;
        while (n3 < n2) {
            q q2 = (q)this.r.if(n3);
            if (q2.int().equals(string)) {
                return q2;
            }
            ++n3;
        }
        return null;
    }

    public Door goto(int n2) {
        int n3 = this.q.for();
        int n4 = 0;
        while (n4 < n3) {
            Door door = (Door)this.q.if(n4);
            if (door.id == n2) {
                return door;
            }
            ++n4;
        }
        return null;
    }

    private void a(n n2, int n3, int n4, int n5, int n6) {
        if (this.G <= 0) {
            return;
        }
        Monster monster = n2.g();
        int n7 = this.a.for();
        int n8 = 0;
        while (n8 < n7) {
            h h2 = (h)this.a.if(n8);
            if (h2.g()) {
                boolean bl = this.a(n3, n4, h2.m(), h2.o());
                boolean bl2 = this.a(n5, n6, h2.m(), h2.o());
                if (bl && bl2) {
                    h2.a(app.island.gs.p.a(monster, n3, n4, n5, n6, h2.r()));
                } else if (bl && !bl2) {
                    h2.a(app.island.gs.p.a((SceneObject)monster));
                    if (h2.r().visible) {
                        n2.if(h2);
                    }
                } else if (!bl && bl2) {
                    h2.a(app.island.gs.p.a(monster, h2));
                    if (h2.r().visible) {
                        n2.do(h2);
                    }
                }
            }
            ++n8;
        }
    }

    public int a() {
        return this.v.getWidth();
    }

    public boolean a(int n2, int n3) {
        return !(!this.v.isWalkable(n2, n3) || this.A[n3][n2] != null && this.A[n3][n2].goto() || this.l[n3][n2] != null && this.l[n3][n2].g());
    }

    public boolean for(h h2) {
        if (h2.r().gmGrade > 0) {
            return true;
        }
        if (this.C.sceneType == 1 && this.C.stateData > 0) {
            h2.try("\u7ade\u6280\u6bd4\u8d5b\u5df2\u7ecf\u5f00\u59cb\uff0c\u65e0\u6cd5\u518d\u8fdb\u5165");
            return false;
        }
        return super.for(h2);
    }

    public void k(h h2) {
        this.a(app.island.gs.p.if(h2.H(), ""), h2.m(), h2.o(), null);
        this.D += -1;
    }

    private boolean m(h h2) {
        int n2;
        Hero hero = h2.r();
        if (hero.x <= 0 && hero.y <= 0) {
            hero.x = this.C.enterX;
            hero.y = this.C.enterY;
        }
        if ((n2 = this.for(hero.x, hero.y)) < 0) {
            return false;
        }
        int n3 = n2 & 0xFFFF;
        int n4 = n2 >> 16;
        hero.x = n3;
        hero.y = n4;
        this.l[n4][n3] = h2;
        return true;
    }

    public n void(int n2) {
        int n3 = 0;
        while (n3 < this.p) {
            if (this.k[n3].new() == n2) {
                return this.k[n3];
            }
            ++n3;
        }
        return null;
    }

    public q b(int n2) {
        int n3 = this.r.for();
        int n4 = 0;
        while (n4 < n3) {
            q q2 = (q)this.r.if(n4);
            if (q2.try() == n2) {
                return q2;
            }
            ++n4;
        }
        return null;
    }

    public void a(EffectObject effectObject, h h2, int n2, int n3) {
        if (n2 < 0 || n3 < 0 || n3 >= this.z.length || n2 > this.z[0].length) {
            return;
        }
        if (this.z[n3][n2] == null) {
            effectObject.markedID = effectObject.id;
            effectObject.id = ServerInfo.globalEffectIDCounter++;
            effectObject.x = n2;
            effectObject.y = n3;
            effectObject.userData = h2;
            effectObject.lastDamageTime = ServerInfo.currentMilliSecond;
            this.z[n3][n2] = effectObject;
            this.j.if(effectObject);
            this.if(effectObject);
        } else if (this.z[n3][n2].markedID == effectObject.id) {
            this.z[n3][n2].lifeTime = effectObject.maxLifeTime;
            this.z[n3][n2].userData = h2;
        }
    }

    public String D() {
        int n2 = this.q.for();
        StringBuffer stringBuffer = new StringBuffer(n2 * 100);
        stringBuffer.append("\u540d\u5b57\t\u5750\u6807X\t\u5750\u6807Y\t\u7b49\u7ea7\u9650\u5236\t\u804c\u4e1a\u9650\u5236\t\u76ee\u6807\u573a\u666f\u7f16\u53f7\t\u76ee\u6807\u4f4d\u7f6eX\t\u76ee\u6807\u4f4d\u7f6eY\r\n");
        stringBuffer.append("name\tx\ty\tlevelRequired\traceRequired\tdestSceneID\tdestX\tdestY\r\n");
        int n3 = 0;
        while (n3 < n2) {
            Door door = (Door)this.q.if(n3);
            stringBuffer.append(door.name);
            stringBuffer.append('\t');
            stringBuffer.append(door.x);
            stringBuffer.append('\t');
            stringBuffer.append(door.y);
            stringBuffer.append('\t');
            stringBuffer.append(door.levelRequired);
            stringBuffer.append('\t');
            stringBuffer.append(door.raceRequired);
            stringBuffer.append('\t');
            stringBuffer.append(door.destSceneID);
            stringBuffer.append('\t');
            stringBuffer.append(door.destX);
            stringBuffer.append('\t');
            stringBuffer.append(door.destY);
            stringBuffer.append("\r\n");
            ++n3;
        }
        return stringBuffer.toString();
    }

    public int B() {
        return this.G;
    }

    public boolean if(h h2, n n2) {
        if (h2.f()) {
            return false;
        }
        Hero hero = h2.r();
        if (hero.visible && n2 != null && n2.goto()) {
            return n2.do().preferredPKValue <= 0 || h2.e() == 2;
        }
        return false;
    }

    public e p() {
        return this.H;
    }

    public void a(e e2) {
        this.H = e2;
    }

    public boolean do(h h2, h h3) {
        if (h2 == h3) {
            return false;
        }
        if (h2.f()) {
            return false;
        }
        Hero hero = h2.r();
        Hero hero2 = h3.r();
        if (hero2.life <= 0 || !hero.visible || !hero2.visible) {
            return false;
        }
        if (this.C.sceneType == 5) {
            return true;
        }
        if (this.C.sceneType == 1) {
            return ServerInfo.currentTimeParts[4] <= 30;
        }
        if (this.C.sceneType == 0 && this.C.stateData > 0 && hero.joinedGuild != null && hero2.joinedGuild != null && h2.e() == 2 && (hero.joinedGuild.battleGuild == hero2.joinedGuild || hero2.joinedGuild.battleGuild == hero.joinedGuild)) {
            return true;
        }
        if (h2.x() == h3.x() && h2.x() != null) {
            return false;
        }
        if (hero.level <= ServerInfo.pkProtectionLevel || hero2.level <= ServerInfo.pkProtectionLevel) {
            return false;
        }
        if (hero.x > this.C.safeRegionCenterX - this.C.safeRegionWidth && hero.x < this.C.safeRegionCenterX + this.C.safeRegionWidth && hero.y > this.C.safeRegionCenterY - this.C.safeRegionHeight && hero.y < this.C.safeRegionCenterY + this.C.safeRegionHeight) {
            return false;
        }
        if (hero2.x > this.C.safeRegionCenterX - this.C.safeRegionWidth && hero2.x < this.C.safeRegionCenterX + this.C.safeRegionWidth && hero2.y > this.C.safeRegionCenterY - this.C.safeRegionHeight && hero2.y < this.C.safeRegionCenterY + this.C.safeRegionHeight) {
            return false;
        }
        switch (h2.e()) {
            case 0: {
                if (h3.z() > 0) {
                    return true;
                }
                return hero.friendList.hasEnemy(hero2.name);
            }
            case 1: {
                if (hero.joinedGuild == hero2.joinedGuild || hero.joinedGuild == null || hero2.joinedGuild == null) {
                    return false;
                }
                return hero.joinedGuild.isEnemy(hero2.joinedGuild.id) || hero2.joinedGuild.isEnemy(hero.joinedGuild.id);
            }
            case 2: {
                return true;
            }
        }
        return false;
    }

    public boolean byte(int n2, int n3) {
        return this.v.isWalkable(n2, n3);
    }

    public boolean a(h h2, Sign sign) {
        if (h2.f()) {
            return false;
        }
        if (sign.life <= 0) {
            return false;
        }
        if (this.C.sceneType == 0 && this.C.stateData > 0 && sign.targetGuild.cityID == this.try() && h2.e() == 2) {
            return sign.targetGuild.battleGuild == h2.r().joinedGuild;
        }
        if (this.if(sign.x, sign.y)) {
            return false;
        }
        Hero hero = h2.r();
        if (sign.targetGuild == hero.joinedGuild) {
            return false;
        }
        if (h2.e() == 1) {
            if (hero.joinedGuild == null) {
                return true;
            }
            if (hero.joinedGuild.isEnemy(sign.targetGuild.id)) {
                return true;
            }
        }
        return false;
    }

    public boolean y() {
        return this.C.medicineUsable > 0;
    }

    public void n(h h2) {
        if (!h2.g()) {
            return;
        }
        Hero hero = h2.r();
        if (!hero.visible) {
            hero.visible = true;
            int n2 = this.for(hero.x, hero.y);
            int n3 = n2 & 0xFFFF;
            int n4 = n2 >> 16;
            if (hero.x != n3 || hero.y != n4) {
                hero.x = n3;
                hero.y = n4;
                h2.a(app.island.gs.p.long(n3, n4));
            }
            this.l[n4][n3] = h2;
            this.a(h2, -65535, -65535, hero.x, hero.y);
        } else {
            this.l[hero.y][hero.x] = null;
            this.a(h2, hero.x, hero.y, -65535, -65535);
            hero.visible = false;
        }
    }

    public Sign d(int n2) {
        if (this.n == null) {
            return null;
        }
        int n3 = this.n.for();
        int n4 = 0;
        while (n4 < n3) {
            Sign sign = (Sign)this.n.if(n4);
            if (sign.id == n2) {
                return sign;
            }
            ++n4;
        }
        return null;
    }

    protected void a(GroundGoods groundGoods) {
        this.a(app.island.gs.p.a(groundGoods, null), groundGoods.x, groundGoods.y, null);
    }

    public boolean a(Door door, int n2, int n3) {
        door.x = n2;
        door.y = n3;
        this.if(app.island.gs.p.if(door.id, n2, n3));
        return true;
    }

    public boolean a(int n2, String string, int n3, int n4, int n5, int n6, int n7) {
        Door door = this.goto(n2);
        if (door == null) {
            return false;
        }
        door.name = string;
        door.levelRequired = n3;
        door.raceRequired = n4;
        door.destSceneID = n5;
        door.destX = n6;
        door.destY = n7;
        int n8 = this.a.for();
        int n9 = 0;
        while (n9 < n8) {
            h h2 = (h)this.a.if(n9);
            if (h2.g()) {
                h2.a(app.island.gs.p.a(door));
                h2.a(app.island.gs.p.a(door, h2));
            }
            ++n9;
        }
        return true;
    }

    public boolean c(int n2) {
        int n3 = this.q.for();
        int n4 = 0;
        while (n4 < n3) {
            Door door = (Door)this.q.if(n4);
            if (door.id == n2) {
                this.q.a(n4);
                this.if(app.island.gs.p.a(door));
                return true;
            }
            ++n4;
        }
        return false;
    }

    private void do(int n2, h h2) {
        n n3 = this.void(n2);
        if (n3 == null) {
            h2.try("\u627e\u4e0d\u5230\u8be5\u602a\u7269\u7684\u4efb\u4f55\u4fe1\u606f\uff01");
        } else {
            h2.a(app.island.gs.p.a(n3.g()));
        }
    }

    public void a(u u2) {
        this.C = (SceneConfigData)u2.C.clone();
        this.for = u2.for;
        this.do(this.C.id);
        this.a(this.C.name);
        this.if(this.C.heroCountLimit);
        this.a = new daff.a.h(255);
        this.u = new daff.a.h(255);
        this.j = new daff.a.h(255);
        this.B = new r();
        this.B.a(this);
        this.m = new l();
        this.m.a(this);
        this.y = new m();
        this.y.a(this);
        this.t = new b();
        this.v = u2.v.copy();
        int n2 = this.v.getWidth();
        int n3 = this.v.getHeight();
        this.A = new n[n3][n2];
        this.l = new h[n3][n2];
        this.o = new GroundGoods[n3][n2];
        this.z = new EffectObject[n3][n2];
        this.k = new n[u2.k.length];
        this.p = u2.p;
        int n4 = 0;
        while (n4 < u2.p) {
            this.k[n4] = new n();
            this.k[n4].a(u2.k[n4]);
            this.k[n4].a(this);
            this.A[this.k[n4].try()][this.k[n4].i()] = this.k[n4];
            ++n4;
        }
        n4 = u2.r.for();
        this.r = new daff.a.h(n4);
        int n5 = 0;
        while (n5 < n4) {
            q q2 = new q();
            q2.a((q)u2.r.if(n5));
            q2.a(this);
            this.r.if(q2);
            ++n5;
        }
        this.q = u2.q;
        this.s = ServerInfo.currentMilliSecond;
        this.x = this.C.sceneLifeTime;
    }

    public SceneConfigData z() {
        return this.C;
    }

    public void case(int n2, int n3) {
        int n4 = this.u.for();
        int n5 = 0;
        while (n5 < n4) {
            GroundGoods groundGoods = (GroundGoods)this.u.if(n5);
            if (this.a(groundGoods.x, groundGoods.y, n2, n3)) {
                groundGoods.remainedLifeTime = 0;
            }
            ++n5;
        }
    }

    public int n() {
        return this.C.plunderExpRate;
    }

    public void g(int n2) {
        this.w += n2;
    }

    public boolean if(int n2, int n3) {
        return n2 > this.C.safeRegionCenterX - this.C.safeRegionWidth && n2 < this.C.safeRegionCenterX + this.C.safeRegionWidth && n3 > this.C.safeRegionCenterY - this.C.safeRegionHeight && n3 < this.C.safeRegionCenterY + this.C.safeRegionHeight;
    }
}
