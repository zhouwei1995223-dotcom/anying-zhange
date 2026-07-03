/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.npc;

import app.island.GameObject;
import app.island.data.Goods;
import app.island.entity.Hero;
import app.island.gs.ServerInfo;
import app.island.gs.h;
import app.island.gs.npc.NpcScript;
import app.island.gs.q;
import daff.a.q;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class FiveOne
extends NpcScript {
    private static q long = new q(1000);
    private static q void = new q(1000);
    private static Goods[] b = new Goods[100];
    private static int c;

    public void init() {
    }

    public void processCommand(String string, h h2) {
        Goods goods;
        Hero hero = h2.r();
        if (string.equals("setup")) {
            c = 0;
            int n2 = 0;
            while (n2 < hero.personalDepot.shopCapacity) {
                FiveOne.b[FiveOne.c] = hero.personalDepot.shopGoods[n2];
                if (b[c] != null) {
                    ++c;
                }
                ++n2;
            }
            h2.for("\u8bbe\u7f6e" + c + "\u4e2a\u5956\u54c1");
        } else if (string.equals("get") && (goods = (Goods)void.a(hero.name)) != null) {
            goods = (Goods)GameObject.cloneObject(goods);
            h2.a(goods);
            String cfr_ignored_0 = "\u606d\u559c\u3010" + hero.name + "\u3011\u5728\u4e94\u4e00\u793c\u54c1\u4f7f\u8005\u5904\u9886\u53d6\u4e86[" + goods.name + "]";
            long.a((Object)hero.user.name, (Object)goods);
        }
    }

    public String getResponseDailogEntry(h h2) {
        if (h2.q() > 1) {
            return "start";
        }
        if (ServerInfo.currentTimeParts[1] < 4) {
            return "before51";
        }
        if (ServerInfo.currentTimeParts[1] > 5 || ServerInfo.currentTimeParts[2] > 5) {
            return "after51";
        }
        if (long.do(h2.r().user.name)) {
            return "got";
        }
        if (h2.r().level < 60) {
            return "noLevel";
        }
        q.d d2 = this.a.a("gift");
        int n2 = (int)(Math.random() * (double)c);
        d2.int = "\u4f60\u597d\uff0c\u4eb2\u7231\u7684$heroName\uff01\u6211\u9001\u7ed9\u4f60[" + FiveOne.b[n2].name + "]\uff0c\u4f60\u8981\u5417\uff1f";
        void.a((Object)h2.b(), (Object)b[n2]);
        return "gift";
    }
}

