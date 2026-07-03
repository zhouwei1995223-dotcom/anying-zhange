/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs;

import app.island.GameObject;
import app.island.data.Goods;
import app.island.entity.Hero;
import app.island.gs.ServerInfo;
import app.island.gs.h;
import app.island.gs.p;
import app.island.gs.w;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class a {
    private static a a;

    public void a(h h2, int n2) {
        Hero hero = h2.r();
        int n3 = n2;
        hero.trainType = n2;
        hero.beginTrainTime = ServerInfo.currentMilliSecond;
        hero.endTrainTime = h2.r().beginTrainTime + (long)(n3 * 3600 * 1000);
        hero.isTrain = 1;
        h2.a(p.a(n2, hero.beginTrainTime, hero.endTrainTime));
    }

    private a() {
    }

    public void a(h h2) {
        if (!h2.f()) {
            return;
        }
        Hero hero = h2.r();
        Goods goods = null;
        int n2 = 0;
        int n3 = app.island.gs.a.a(h2.r());
        if (n3 <= 0) {
            return;
        }
        hero.trainingTimes += n3 / 60;
        h2.j().do().a(hero, 14);
        if (ServerInfo.currentMilliSecond >= h2.r().endTrainTime) {
            goods = this.if(h2.r());
            if (goods != null) {
                h2.a(goods);
            }
            n2 = hero.level * hero.level / 10 + 20;
            n2 = (int)((double)(n2 * 150 / 100) * 0.35);
            n2 *= n3;
        } else {
            n2 = hero.level * hero.level / 10 + 20;
            n2 = (int)((double)(n2 * 150 / 100) * 0.35);
            n2 *= n3;
        }
        if (h2.r().level < hero.getMaxLevel()) {
            h2.int(n2);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("\u901a\u8fc7\u672c\u6b21\u4fee\u70bc\uff0c\u60a8\u5f97\u5230\u5982\u4e0b\u6536\u83b7\uff1a\u7ecf\u9a8c");
            stringBuffer.append(n2);
            stringBuffer.append("\u70b9");
            if (goods != null) {
                stringBuffer.append("  \u7269\u54c1\uff1a");
                stringBuffer.append(goods.name);
            }
            h2.for(stringBuffer.toString());
        }
        hero.endTrainTime = 0L;
        hero.beginTrainTime = 0L;
        hero.isTrain = 0;
        hero.trainType = 0;
        h2.a(p.int());
    }

    public static int a(Hero hero) {
        int n2 = (int)((Math.min(ServerInfo.currentMilliSecond, hero.endTrainTime) - hero.beginTrainTime) / 60L / 1000L);
        if (n2 < 0) {
            n2 = 0;
        }
        return n2;
    }

    private Goods if(Hero hero) {
        Goods goods = w.case().byte(hero.level);
        Goods goods2 = (Goods)GameObject.cloneObject(goods);
        return goods2;
    }

    private void if() {
    }

    public static a a() {
        if (a == null) {
            a = new a();
            a.if();
        }
        return a;
    }
}

