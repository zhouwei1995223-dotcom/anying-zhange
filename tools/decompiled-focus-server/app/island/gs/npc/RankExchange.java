/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.npc;

import app.island.entity.Hero;
import app.island.gs.data.HeroRankData;
import app.island.gs.h;
import app.island.gs.npc.NpcScript;
import app.island.gs.x;

public class RankExchange
extends NpcScript {
    public void update() {
    }

    public void init() {
    }

    public void processCommand(String string, h h2) {
        int n2;
        Hero hero = h2.r();
        if (string.startsWith("rank:") && hero.rank != (n2 = string.charAt(string.length() - 1) - 48)) {
            hero.rank = n2;
            if (n2 == 0) {
                this.a.for().do().if(hero);
            } else {
                this.a.for().do().a(hero);
            }
            this.a.a("result", h2);
        }
        if (string.startsWith("exchange:")) {
            n2 = string.charAt(string.length() - 1) - 48;
            x x2 = this.a.for().do();
            HeroRankData heroRankData = x2.int(n2);
            if (heroRankData.getRankValue(hero.id) < 0) {
                this.a.a("notOnTop", h2);
            } else {
                int n3 = 0;
                if (n2 == 3) {
                    n3 = hero.monsterKills / 1000;
                    hero.monsterKills %= 1000;
                } else if (n2 == 5) {
                    int n4 = 36000;
                    n3 = hero.onlineTime / n4;
                    hero.onlineTime %= n4;
                } else if (n2 == 6) {
                    n3 = hero.motionCount / 10000;
                    hero.motionCount %= 10000;
                }
                if (n3 > 0) {
                    h2.try(n3);
                    h2.for("\u4f60\u5151\u6362\u5f97\u5230" + n3 + "\u5143\u5b9d");
                    heroRankData.rankHero(hero);
                } else {
                    this.a.a("noProperty", h2);
                }
            }
        }
    }
}

