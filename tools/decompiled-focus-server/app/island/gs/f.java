/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs;

import app.island.GameObject;
import app.island.data.Goods;
import app.island.data.Task;
import app.island.entity.Hero;
import app.island.gs.ServerInfo;
import app.island.gs.h;
import app.island.gs.p;
import app.island.gs.w;
import app.island.gs.x;
import daff.a.b;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class f {
    public x a;

    public void a(h h2) {
        if (h2.r().level < 100) {
            return;
        }
        int n2 = Task.globalTaskList.for();
        daff.a.h h3 = new daff.a.h();
        int n3 = 0;
        while (n3 < n2) {
            Task task = (Task)Task.globalTaskList.if(n3);
            if (task.repeatable > 0) {
                if (h2.r().taskList.isAcceptable(task, ServerInfo.currentMilliSecond, h2.r())) {
                    h3.if(task);
                }
                task = null;
            }
            ++n3;
        }
        h2.a(p.a(h3));
    }

    public void if(h h2, int n2) {
        Goods goods;
        Hero hero = h2.r();
        Task task = hero.taskList.getTask(n2);
        if (task == null) {
            h2.for("\u4f60\u5e76\u6ca1\u6709\u63a5\u4efb\u52a1");
            return;
        }
        if (task.targetStateData != 2) {
            h2.for("\u672c\u4efb\u52a1\u9700\u8981\u5728\u6307\u5b9a\u7684NPC\u90a3\u91cc\u5b8c\u6210");
            return;
        }
        if (!task.isCompleted(hero)) {
            h2.for("\u4f60\u5c1a\u672a\u5b8c\u6210\u4efb\u52a1");
            return;
        }
        if (task.prizeGoodsID > 0 && hero.personalDepot.getNextFreePos() < 0) {
            h2.for("\u4f60\u80cc\u5305\u4e2d\u6ca1\u6709\u8db3\u591f\u7684\u7a7a\u95f4\u6765\u653e\u7f6e\u5956\u52b1\u7269\u54c1\uff0c\u8bf7\u5c06\u80cc\u5305\u6e05\u7406\u540e\u518d\u6765\u5b8c\u6210\u6b64\u4efb\u52a1\uff01");
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
            h2.int(task.prizeExp);
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

    public f(x x2) {
        this.a = x2;
    }

    public void a(h h2, int n2) {
        Hero hero = h2.r();
        if (hero.taskList.containsTask(n2)) {
            h2.for("\u4f60\u5df2\u63a5\u53d7\u6b64\u4efb\u52a1\u4e86");
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
        } else if (hero.taskList.isAcceptable(task, ServerInfo.currentMilliSecond, hero)) {
            Goods goods;
            task = (Task)GameObject.cloneObject(task);
            task.stateData = 0;
            task.acceptedTime = b.a();
            if (task.timeLast > 0) {
                long l2 = ServerInfo.currentMilliSecond + (long)(task.timeLast * 60 * 1000);
                task.expiredTime = b.if(l2);
                task.taskDeadline = l2;
            }
            h2.a(task);
            if (task.attachedGoods > 0 && (goods = w.case().getGoods(task.attachedGoods)) != null) {
                goods = (Goods)GameObject.cloneObject(goods);
                h2.j().do().a(goods);
                h2.a(goods);
            }
            if (task.requiredGoodsID > 0) {
                h2.b(task.requiredGoodsID);
            }
        }
    }
}

