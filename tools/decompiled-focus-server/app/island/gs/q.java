/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs;

import app.island.GameObject;
import app.island.data.Goods;
import app.island.data.Task;
import app.island.entity.Hero;
import app.island.entity.Npc;
import app.island.gs.ServerInfo;
import app.island.gs.data.NpcAIData;
import app.island.gs.h;
import app.island.gs.npc.NpcScript;
import app.island.gs.p;
import app.island.gs.u;
import app.island.gs.v;
import app.island.gs.w;
import app.island.gs.x;
import daff.a.i;
import daff.a.n;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class q {
    private static final daff.a.q byte = new daff.a.q(4000);
    private u void;
    private Npc case;
    private NpcAIData char;
    public long int;
    public long try;
    private daff.a.q goto;
    private daff.a.h if;
    private String[] long;
    private daff.a.h b;
    private daff.a.h for;
    private daff.a.h do;
    private daff.a.h new;
    private v a;
    private NpcScript else;

    public void a(d d2, h h2) {
        h2.a(p.a(this.case.name, d2, this.for(), h2));
        h2.a(this);
        h2.a(d2);
    }

    public int try() {
        return this.case.id;
    }

    public int byte() {
        return this.case.x;
    }

    public void a(String string, h h2) {
        if (this.goto == null) {
            h2.try("\u6309\u89c4\u5b9a\u6211\u4e0d\u4f1a\u8ddf\u4f60\u8bb2\u8bdd\uff01");
            return;
        }
        d d2 = (d)this.goto.for(string);
        if (d2 == null) {
            h2.try("\u6211\u627e\u4e0d\u5230\u5bf9\u8bdd\u5165\u53e3\u6765\u548c\u4f60\u8bf4\u8bdd\u5440\uff01");
            return;
        }
        this.a(d2, h2);
    }

    private void do(String string) {
        if (string != null && string.equals(this.case.dialog)) {
            return;
        }
        this.goto = null;
        this.if = null;
        this.long = null;
        this.b = null;
        this.for = null;
        this.new = null;
        this.do = null;
        if (string != null && string.length() > 1) {
            i i2 = (i)byte.for(string);
            if (i2 == null) {
                byte[] byArray = daff.a.b.new("config/dialog/" + string + ".dlg");
                if (byArray != null) {
                    i2 = n.a().a(new String(byArray));
                    byte.a((Object)string, (Object)i2);
                } else {
                    System.out.println("dialog not found:" + string);
                }
            }
            if (i2 != null) {
                this.a(i2);
                this.case.dialog = string;
            }
        }
    }

    private String if(h h2) {
        if (this.if == null) {
            return null;
        }
        int n2 = this.if.for();
        int n3 = 0;
        while (n3 < n2) {
            c c2 = (c)this.if.if(n3);
            if (h2.r().taskList.isHistory(c2.do) && c2.for.length() > 0) {
                return c2.for;
            }
            Task task = h2.r().taskList.getTask(c2.do);
            if (task != null) {
                if (task.isCompleted(h2.r()) && c2.if.length() > 0) {
                    return c2.if;
                }
                if (c2.a.length() > 0) {
                    return c2.a;
                }
            }
            ++n3;
        }
        return null;
    }

    public v new() {
        return this.a;
    }

    public String int(h h2) {
        String string = null;
        if (this.else != null) {
            string = this.else.getResponseDailogEntry(h2);
        }
        if (string == null || string.length() == 0) {
            string = this.if(h2);
        }
        if (string == null || string.length() == 0) {
            string = this.for(h2);
        }
        if (string == null || string.length() == 0) {
            string = this.try(h2);
        }
        if (string == null || string.length() == 0) {
            string = this.do(h2);
        }
        if (string == null || string.length() == 0) {
            string = this.new(h2);
        }
        if (string == null || string.length() == 0) {
            string = this.a(this.void.G());
        }
        if (string == null || string.length() == 0) {
            string = "start";
        }
        return string;
    }

    private String a(int n2) {
        if (this.new == null) {
            return null;
        }
        int n3 = this.new.for();
        int n4 = 0;
        while (n4 < n3) {
            f f2 = (f)this.new.if(n4);
            if (n2 >= f2.a) {
                return f2.if;
            }
            ++n4;
        }
        return null;
    }

    public void case() {
        int n2;
        int n3;
        int n4;
        boolean bl = this.case.visible;
        if (this.case.visible) {
            if (this.char != null && this.char.refreshPosTime > 0 && ServerInfo.currentMilliSecond - this.try > (long)(this.char.refreshPosTime * 1000) && this.char.appearancePosX > 0 && this.char.appearancePosY > 0 && this.char.appearanceRegion > 1) {
                this.try = ServerInfo.currentMilliSecond;
                n4 = this.char.appearancePosX - this.char.appearanceRegion + (int)(Math.random() * (double)this.char.appearanceRegion * 2.0);
                n3 = this.char.appearancePosY - this.char.appearanceRegion + (int)(Math.random() * (double)this.char.appearanceRegion * 2.0);
                n2 = this.void.for(n4, n3);
                this.void.a(this, n2 & 0xFFFF, n2 >> 16);
            }
            if (this.int > 0L && ServerInfo.currentMilliSecond > this.int) {
                this.int = 0L;
                this.case.visible = false;
            }
        } else if (this.char != null) {
            if (this.char.appearanceDailyTime > 0) {
                n4 = this.char.appearanceDailyTime / 100;
                n3 = this.char.appearanceDailyTime % 100;
                if (ServerInfo.currentTimeParts[3] == n4 && ServerInfo.currentTimeParts[4] == n3) {
                    this.case.visible = true;
                }
            } else if (this.char.appearanceWeaklyTime > 0) {
                n4 = this.char.appearanceWeaklyTime / 10000;
                n3 = this.char.appearanceWeaklyTime / 100 % 100;
                n2 = this.char.appearanceWeaklyTime % 100;
                if (ServerInfo.currentTimeParts[3] == n3 && ServerInfo.currentTimeParts[4] == n2 && ServerInfo.currentTimeParts[6] == n4) {
                    this.case.visible = true;
                }
            } else if (this.char.appearanceMonthlyTime > 0) {
                n4 = this.char.appearanceMonthlyTime / 10000;
                n3 = this.char.appearanceMonthlyTime / 100 % 100;
                n2 = this.char.appearanceMonthlyTime % 100;
                if (ServerInfo.currentTimeParts[3] == n3 && ServerInfo.currentTimeParts[4] == n2 && ServerInfo.currentTimeParts[2] == n4) {
                    this.case.visible = true;
                }
            } else if (this.char.appearanceUniqueTime > 0) {
                n4 = this.char.appearanceUniqueTime / 100000000;
                n3 = this.char.appearanceUniqueTime / 1000000 % 100 - 1;
                n2 = this.char.appearanceUniqueTime / 10000 % 100;
                int n5 = this.char.appearanceUniqueTime / 100 % 100;
                int n6 = this.char.appearanceUniqueTime % 100;
                if (ServerInfo.currentTimeParts[0] == n4 && ServerInfo.currentTimeParts[1] == n3 && ServerInfo.currentTimeParts[2] == n2 && ServerInfo.currentTimeParts[3] == n5 && ServerInfo.currentTimeParts[4] == n6) {
                    this.case.visible = true;
                }
            } else {
                n4 = 1;
                if (this.char.appearanceSceneTime > 0) {
                    int n7 = n4 = ServerInfo.currentMilliSecond - this.void.H() < (long)(this.char.appearanceSceneTime * 1000) ? 0 : 1;
                }
                if (this.char.appearanceDeathCount > 0) {
                    n4 &= this.void.G() < this.char.appearanceDeathCount ? 0 : 1;
                }
                if (this.char.appearanceHeroCount > 0) {
                    n4 &= this.void.B() < this.char.appearanceHeroCount ? 0 : 1;
                }
                this.case.visible = n4;
            }
        }
        if (bl != this.case.visible) {
            if (this.case.visible) {
                this.int = this.char.visibleTimeLast > 0 ? (long)(this.char.visibleTimeLast * 1000) + ServerInfo.currentMilliSecond : 0L;
                if (this.char.appearancePosX > 0 && this.char.appearancePosY > 0 && this.char.appearanceRegion > 1) {
                    this.try = ServerInfo.currentMilliSecond;
                    n4 = this.char.appearancePosX - this.char.appearanceRegion + (int)(Math.random() * (double)this.char.appearanceRegion * 2.0);
                    n3 = this.char.appearancePosY - this.char.appearanceRegion + (int)(Math.random() * (double)this.char.appearanceRegion * 2.0);
                    n2 = this.void.for(n4, n3);
                    this.void.a(this, n2 & 0xFFFF, n2 >> 16);
                }
                if (this.char.appearanceNotice.length() > 1) {
                    app.b.b b2 = p.void(this.char.appearanceNotice);
                    this.for().a(b2, null);
                }
            }
            this.void.if(p.a(this.case));
        }
        if (this.else != null && this.case.visible) {
            this.else.update();
        }
    }

    public void do(h h2, int n2) {
        Hero hero = h2.r();
        if (hero.taskList.containsTask(n2)) {
            h2.try("\u4f60\u5df2\u7ecf\u6709\u8fd9\u4e2a\u4efb\u52a1\u4e86");
            return;
        }
        Task task = w.case().long(n2);
        if (task == null) {
            h2.try("\u6ca1\u6709\u8fd9\u4e2a\u4efb\u52a1");
        } else if (hero.level < task.requiredMinLevel || hero.level > task.requiredMaxLevel) {
            h2.try("\u4f60\u7b49\u7ea7\u4e0d\u591f\u63a5\u8fd9\u4e2a\u4efb\u52a1");
        } else if (task.requiredRace >= 0 && task.requiredRace != hero.race) {
            h2.try("\u4f60\u4e0d\u9002\u5408\u8fd9\u4e2a\u4efb\u52a1");
        } else if (task.requiredGoodsID > 0 && hero.personalDepot.getGoodsPosByID(task.requiredGoodsID) < 0) {
            h2.try("\u4f60\u6ca1\u6709\u63a5\u672c\u4efb\u52a1\u6240\u9700\u7684\u4fe1\u7269");
        } else if (hero.taskList.isHistory(task.id)) {
            h2.try("\u4f60\u66fe\u7ecf\u5b8c\u6210\u8fc7\u8fd9\u4e2a\u4efb\u52a1");
        } else if (!hero.taskList.isAcceptable(task, ServerInfo.currentMilliSecond, hero)) {
            h2.try("\u4f60\u73b0\u5728\u4e0d\u80fd\u63a5\u8fd9\u4e2a\u4efb\u52a1\uff0c\u8fc7\u4e9b\u65f6\u5019\u518d\u6765\u5427");
        } else {
            Goods goods;
            task = (Task)GameObject.cloneObject(task);
            task.stateData = 0;
            task.acceptedTime = daff.a.b.a();
            if (task.timeLast > 0) {
                long l2 = ServerInfo.currentMilliSecond + (long)(task.timeLast * 60 * 1000);
                task.expiredTime = daff.a.b.if(l2);
                task.taskDeadline = l2;
            }
            h2.a(task);
            if (task.attachedGoods > 0 && (goods = w.case().getGoods(task.attachedGoods)) != null) {
                goods = (Goods)GameObject.cloneObject(goods);
                this.void.do().a(goods);
                h2.a(goods);
            }
            if (task.requiredGoodsID > 0) {
                h2.b(task.requiredGoodsID);
            }
        }
    }

    public boolean do() {
        return this.case.visible;
    }

    public String int() {
        return this.case.name;
    }

    private String new(h h2) {
        if (this.for == null) {
            return null;
        }
        Hero hero = h2.r();
        int n2 = this.for.for();
        int n3 = 0;
        while (n3 < n2) {
            a a2 = (a)this.for.if(n3);
            if (hero.personalDepot.getGoodsPosByID(a2.a) >= 0) {
                return a2.if;
            }
            ++n3;
        }
        return null;
    }

    private String do(h h2) {
        if (this.b == null) {
            return null;
        }
        int n2 = h2.r().level;
        int n3 = this.b.for();
        int n4 = 0;
        while (n4 < n3) {
            b b2 = (b)this.b.if(n4);
            if (b2.a > n2) {
                return b2.if;
            }
            ++n4;
        }
        return null;
    }

    public Npc a() {
        return this.case;
    }

    private void if(String string) {
        if (string != null && string.equals(this.case.script)) {
            return;
        }
        this.case.script = "";
        if (string != null && string.length() > 1) {
            this.case.script = string;
            this.else = (NpcScript)daff.a.b.char("app.island.gs.npc." + string);
            if (this.else != null) {
                this.else.setController(this);
                this.else.init();
            }
        }
    }

    public void a(int n2, String string, String string2, String string3, int n3) {
        this.case.image = n2;
        this.case.name = string;
        this.do(string2);
        this.if(string3);
        this.if(n3);
    }

    public void if(h h2, int n2) {
        Goods goods;
        Hero hero = h2.r();
        Task task = hero.taskList.getTask(n2);
        if (task == null) {
            h2.try("\u4f60\u5e76\u6ca1\u6709\u63a5\u4efb\u52a1");
            return;
        }
        if (!task.isCompleted(hero)) {
            h2.try("\u4f60\u5c1a\u672a\u5b8c\u6210\u4efb\u52a1");
            return;
        }
        if (task.prizeGoodsID > 0 && hero.personalDepot.getNextFreePos() < 0) {
            h2.try("\u4f60\u80cc\u5305\u4e2d\u6ca1\u6709\u8db3\u591f\u7684\u7a7a\u95f4\u6765\u653e\u7f6e\u5956\u52b1\u7269\u54c1\uff0c\u8bf7\u5c06\u80cc\u5305\u6e05\u7406\u540e\u518d\u6765\u5b8c\u6210\u6b64\u4efb\u52a1\uff01");
            return;
        }
        if (task.subjectType == 1) {
            int n3 = 0;
            while (n3 < task.targetStateData) {
                h2.b(task.subjectDataInt);
                ++n3;
            }
        }
        if (task.prizeExp > 0) {
            h2.int(Math.abs(task.prizeExp));
        }
        if (task.prizeMoney > 0) {
            h2.new(task.prizeMoney);
        }
        if (task.prizeTreasure > 0) {
            hero.user.earnedTreasure += task.prizeTreasure;
            hero.earnedTreasure += task.prizeTreasure;
            h2.try(task.prizeTreasure);
            x.for().long().saveUserLog(hero.user.name, hero.name, "taskPrize", "taskID=" + task.id + ";treasure=" + task.prizeTreasure);
        }
        if (task.prizeGoodsID > 0 && (goods = w.case().getGoods(task.prizeGoodsID)) != null) {
            goods = (Goods)GameObject.cloneObject(goods);
            x.for().a(goods);
            h2.a(goods);
        }
        if (task.repeatable == 0) {
            hero.taskList.addHistory(task.id);
        } else if (task.intervalTime > 0) {
            task.completedTime = ServerInfo.currentMilliSecond;
            hero.taskList.addLimitedTask(task);
        }
        h2.if(task);
    }

    public u for() {
        return this.void;
    }

    public void a(u u2) {
        this.void = u2;
    }

    private String try(h h2) {
        if (this.do == null) {
            return null;
        }
        int n2 = h2.r().turns;
        int n3 = this.do.for();
        int n4 = 0;
        while (n4 < n3) {
            e e2 = (e)this.do.if(n4);
            if (e2.a > n2) {
                return e2.if;
            }
            ++n4;
        }
        return null;
    }

    public void a(int n2, daff.a.e e2, h h2) {
        if (n2 == 1025) {
            int n3 = e2.for();
            this.a(h2, n3);
        } else if (n2 == 1026) {
            h2.a((q)null);
            h2.a((d)null);
        }
    }

    private void a(i i2) {
        daff.a.h h2 = i2.int();
        int n2 = h2.for();
        this.goto = new daff.a.q(n2 * 4);
        int n3 = 0;
        while (n3 < n2) {
            Object object;
            Object object2;
            i i3 = (i)h2.if(n3);
            if (i3.do().equals("taskEntries")) {
                object2 = i3.int();
                this.if = new daff.a.h(((daff.a.h)object2).for());
                int n4 = 0;
                while (n4 < ((daff.a.h)object2).for()) {
                    i3 = (i)((daff.a.h)object2).if(n4);
                    object = new c();
                    ((c)object).do = Integer.parseInt(i3.for("id"));
                    ((c)object).a = i3.for("doing");
                    ((c)object).if = i3.for("completed");
                    ((c)object).for = i3.for("onceDone");
                    this.if.if(object);
                    ++n4;
                }
            } else if (i3.do().equals("raceEntries")) {
                this.long = new String[3];
                this.long[0] = i3.for("0");
                this.long[1] = i3.for("1");
                this.long[2] = i3.for("2");
            } else if (i3.do().equals("turnEntries")) {
                object2 = i3.int();
                this.do = new daff.a.h(((daff.a.h)object2).for());
                int n5 = 0;
                while (n5 < ((daff.a.h)object2).for()) {
                    i3 = (i)((daff.a.h)object2).if(n5);
                    if (i3.for().length() > 0) {
                        object = new e();
                        ((e)object).a = Integer.parseInt(i3.do());
                        ((e)object).if = i3.for();
                        this.do.if(object);
                    }
                    ++n5;
                }
            } else if (i3.do().equals("levelEntries")) {
                object2 = i3.int();
                this.b = new daff.a.h(((daff.a.h)object2).for());
                int n6 = 0;
                while (n6 < ((daff.a.h)object2).for()) {
                    i3 = (i)((daff.a.h)object2).if(n6);
                    object = new b();
                    ((b)object).a = Integer.parseInt(i3.do());
                    ((b)object).if = i3.for();
                    this.b.if(object);
                    ++n6;
                }
            } else if (i3.do().equals("goodsEntries")) {
                object2 = i3.int();
                this.for = new daff.a.h(((daff.a.h)object2).for());
                int n7 = 0;
                while (n7 < ((daff.a.h)object2).for()) {
                    i3 = (i)((daff.a.h)object2).if(n7);
                    if (i3.for().length() > 0) {
                        object = new a();
                        ((a)object).if = i3.do();
                        ((a)object).a = Integer.parseInt(i3.for());
                        this.for.if(object);
                    }
                    ++n7;
                }
            } else if (i3.do().equals("deathEntries")) {
                object2 = i3.int();
                this.new = new daff.a.h(((daff.a.h)object2).for());
                int n8 = 0;
                while (n8 < ((daff.a.h)object2).for()) {
                    i3 = (i)((daff.a.h)object2).if(n8);
                    object = new f();
                    ((f)object).if = i3.do();
                    ((f)object).a = Integer.parseInt(i3.for());
                    this.new.if(object);
                    ++n8;
                }
            } else {
                object2 = new d();
                ((d)object2).for = i3.do();
                i i4 = i3.a("text");
                ((d)object2).int = i4.for();
                ((d)object2).if = 0xFFFFFF;
                i4 = i3.a("color");
                if (i4.for().length() > 0) {
                    ((d)object2).if = Integer.parseInt(i4.for(), 16);
                }
                i4 = i3.a("options");
                object = i4.int();
                int n9 = ((daff.a.h)object).for();
                ((d)object2).do = new String[n9];
                ((d)object2).a = new String[n9];
                int n10 = 0;
                while (n10 < n9) {
                    i i5 = (i)((daff.a.h)object).if(n10);
                    ((d)object2).do[n10] = i5.for("text");
                    ((d)object2).a[n10] = i5.for("command");
                    ++n10;
                }
                this.goto.a((Object)((d)object2).for, object2);
            }
            ++n3;
        }
    }

    public d a(String string) {
        d d2 = (d)this.goto.for(string);
        return d2;
    }

    public int if() {
        return this.case.y;
    }

    public void a(q q2) {
        this.case = new Npc();
        this.case.copyFrom(q2.case);
        this.char = q2.char;
        this.goto = q2.goto;
        this.if = q2.if;
        this.long = q2.long;
        this.b = q2.b;
        this.for = q2.for;
        this.do = q2.do;
        this.new = q2.new;
        this.a = q2.a;
        this.else = q2.else;
    }

    public void a(String[] stringArray, String[] stringArray2) {
        String string = stringArray2[1];
        int n2 = Integer.parseInt(stringArray2[2]);
        int n3 = Integer.parseInt(stringArray2[3]);
        int n4 = Integer.parseInt(stringArray2[4]);
        String string2 = stringArray2[5];
        String string3 = stringArray2[7];
        int n5 = 0;
        if (stringArray2.length > 8 && stringArray2[8].length() > 1) {
            n5 = Integer.parseInt(stringArray2[8]);
        }
        this.a(n2, n3, n4, string, string2, string3, n5);
        if (stringArray2[6].length() > 1) {
            int n6 = Integer.parseInt(stringArray2[6]);
            this.a = this.void.do().a(n6);
        }
    }

    public void a(int n2, int n3, int n4, String string, String string2, String string3, int n5) {
        this.case = new Npc();
        this.case.id = ServerInfo.globalNpcIDCounter++;
        this.case.x = n2;
        this.case.y = n3;
        this.case.image = n4;
        this.case.name = string;
        this.do(string2);
        this.if(string3);
        this.if(n5);
    }

    protected void a(h h2, int n2) {
        d d2 = h2.a();
        h2.a((q)null);
        h2.a((d)null);
        if (!this.case.visible) {
            return;
        }
        if (!h2.g() || h2.i() || h2.j() != this.void) {
            return;
        }
        if (d2 == null || n2 >= d2.a.length) {
            return;
        }
        String string = d2.a[n2];
        if (string.length() == 0) {
            return;
        }
        String[] stringArray = daff.a.b.a(string, ";");
        int n3 = 0;
        while (n3 < stringArray.length) {
            this.a(h2, stringArray[n3]);
            ++n3;
        }
    }

    private void a(h h2, String string) {
        if (string.length() <= 2) {
            return;
        }
        Hero hero = h2.r();
        if (string.startsWith("goto:")) {
            String string2 = string.substring(5);
            this.a(string2, h2);
        } else if (string.startsWith("transport:")) {
            String[] stringArray = daff.a.b.a(string, ":");
            int n2 = Integer.parseInt(stringArray[1]);
            int n3 = Integer.parseInt(stringArray[2]);
            int n4 = Integer.parseInt(stringArray[3]);
            if (n2 < 0 || n2 == this.void.try()) {
                int n5 = this.void.for(n3, n4);
                n3 = n5 & 0xFFFF;
                n4 = n5 >> 16;
                h2.a(p.long(n3, n4));
                this.void.if(h2, n3, n4);
            } else {
                this.void.do().a(h2, n2, n3, n4);
            }
        } else if (string.startsWith("travel:")) {
            String[] stringArray = daff.a.b.a(string, ":");
            int n6 = Integer.parseInt(stringArray[1]);
            int n7 = Integer.parseInt(stringArray[2]);
            if (hero.personalDepot.money > n7) {
                if (this.void.do().a(h2, n6, 0, 0)) {
                    hero.personalDepot.money -= n7;
                    h2.a(p.case(hero));
                }
            } else {
                h2.try("\u91d1\u5e01\u4e0d\u8db3");
            }
        } else if (string.startsWith("giveTask:")) {
            String[] stringArray = daff.a.b.a(string, ":");
            int n8 = Integer.parseInt(stringArray[1]);
            this.do(h2, n8);
        } else if (string.startsWith("completeTask:")) {
            String[] stringArray = daff.a.b.a(string, ":");
            int n9 = Integer.parseInt(stringArray[1]);
            this.if(h2, n9);
        } else if (string.startsWith("markTask:")) {
            String[] stringArray = daff.a.b.a(string, ":");
            int n10 = Integer.parseInt(stringArray[1]);
            int n11 = Integer.parseInt(stringArray[2]);
            Task task = h2.r().taskList.getTask(n10);
            if (task != null) {
                int n12 = task.stateData;
                task.stateData |= n11;
                if (n12 != task.stateData) {
                    h2.a(p.h(task.id, task.stateData));
                }
            }
        } else if (string.startsWith("createDuplicate:")) {
            String[] stringArray = daff.a.b.a(string, ":");
            int n13 = Integer.parseInt(stringArray[1]);
            int n14 = 0;
            app.island.gs.b b2 = h2.x();
            if (stringArray.length > 2) {
                n14 = Integer.parseInt(stringArray[2]);
            }
            if (n14 > 0 && h2.r().personalDepot.money < n14) {
                h2.try("\u4f60\u8eab\u4e0a\u91d1\u5e01\u4e0d\u8db3\uff0c\u9700\u8981" + n14);
            } else if (b2 != null && b2.else() != h2) {
                h2.try("\u4f60\u4e0d\u662f\u961f\u957f\uff0c\u4e0d\u80fd\u521b\u5efa\u526f\u672c");
            } else {
                int n15 = this.void.do().if(n13);
                if (n15 > 0) {
                    if (b2 != null) {
                        if (b2.else() == h2) {
                            this.void.do().a(h2, n15, 0, 0);
                            int n16 = b2.a.for();
                            int n17 = 1;
                            while (n17 < n16) {
                                h h3 = (h)b2.a.if(n17);
                                if (h3.j() == this.void) {
                                    this.void.do().a(h3, n15, 0, 0);
                                }
                                ++n17;
                            }
                        }
                    } else {
                        this.void.do().a(h2, n15, 0, 0);
                    }
                }
                if (this.void != h2.j() && n14 > 0) {
                    h2.r().personalDepot.money -= n14;
                    h2.a(p.case(h2.r()));
                }
            }
        } else if (string.equals("buy")) {
            if (this.a != null) {
                this.a.j(h2);
            } else {
                h2.try("\u672c\u5904\u4e0d\u51fa\u552e\u5546\u54c1\uff01");
            }
        } else if (string.startsWith("openShop:")) {
            int n18 = Integer.parseInt(string.substring(string.indexOf(58) + 1));
            v v2 = this.void.do().a(n18);
            if (v2 != null) {
                v2.j(h2);
            } else {
                h2.try("\u672c\u5904\u4e0d\u51fa\u552e\u5546\u54c1\uff01");
            }
        } else if (string.equals("store")) {
            h2.a(p.d());
        } else if (string.equals("openBox")) {
            h2.a(p.j());
        } else if (string.startsWith("addTaskState:")) {
            Task task;
            String[] stringArray = daff.a.b.a(string, ":");
            int n19 = Integer.parseInt(stringArray[1]);
            int n20 = 1;
            if (stringArray.length > 2) {
                n20 = Integer.parseInt(stringArray[2]);
            }
            if ((task = hero.taskList.getTask(n19)) != null) {
                task.stateData += n20;
                h2.a(p.h(task.id, task.stateData));
            }
        } else if (string.startsWith("changeTaskState:")) {
            Task task;
            String[] stringArray = daff.a.b.a(string, ":");
            int n21 = Integer.parseInt(stringArray[1]);
            int n22 = 1;
            if (stringArray.length > 2) {
                n22 = Integer.parseInt(stringArray[2]);
            }
            if ((task = hero.taskList.getTask(n21)) != null) {
                task.stateData = n22;
                h2.a(p.h(task.id, task.stateData));
            }
        } else if (this.else != null) {
            this.else.processCommand(string, h2);
        } else if (string.length() > 0) {
            h2.try("\u672a\u77e5\u7684\u547d\u4ee4\uff1a" + string);
        }
    }

    private void if(int n2) {
        if (n2 > 0 && n2 != this.case.behaviorID) {
            this.case.behaviorID = n2;
            this.char = w.case().int(n2);
            if (this.char != null) {
                boolean bl = this.case.initialVisible = this.char.initialVisibility > 0;
                if (this.char.initialVisibility == 0) {
                    this.case.visible = false;
                } else if (this.char.visibleTimeLast > 0) {
                    this.int = ServerInfo.currentMilliSecond + (long)(this.char.visibleTimeLast * 1000);
                }
            }
        }
    }

    public void a(h h2) {
        if (!this.case.visible && h2.r().gmGrade <= 0) {
            h2.try("\u4f60\u770b\u4e0d\u5230\u6211");
        } else if (h2.j() != this.void || !h2.g()) {
            h2.try("\u975e\u6cd5\u8bbf\u95ee");
        } else if (!this.void.a(h2.m(), h2.o(), this.case.x, this.case.y)) {
            h2.try("\u8ddd\u79bb\u592a\u8fdc");
        } else if (h2.i()) {
            h2.try("\u4f60\u5feb\u590d\u6d3b\u5427");
        } else {
            this.a(this.int(h2), h2);
        }
    }

    private String for(h h2) {
        if (this.long == null) {
            return null;
        }
        return this.long[h2.r().race];
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    public static class d {
        public String for = "";
        public String int = "";
        public int if = -1;
        public String[] do;
        public String[] a;
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    public static class c {
        public int do;
        public String a;
        public String if;
        public String for;
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    public static class f {
        public int a;
        public String if;
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    public static class a {
        public int a;
        public String if;
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    public static class b {
        public int a;
        public String if;
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    public static class e {
        public int a;
        public String if;
    }
}

