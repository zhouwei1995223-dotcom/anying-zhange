/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.npc;

import app.island.entity.Hero;
import app.island.gs.h;
import app.island.gs.npc.NpcScript;
import app.island.gs.p;

public class MoneyGambler
extends NpcScript {
    private static int y;

    public void init() {
    }

    public void processCommand(String string, h h2) {
        if (string.equals("bet")) {
            Hero hero = h2.r();
            if (hero.personalDepot.money < 100) {
                this.a.a("nomoney", h2);
            } else {
                hero.personalDepot.money -= 100;
                y += 100;
                if (Math.random() > 0.5) {
                    int n2 = (int)(Math.random() * (double)y) * 4 / 5;
                    y -= n2;
                    hero.personalDepot.money += n2;
                    this.a.a("success", h2);
                } else {
                    this.a.a("failed", h2);
                }
                h2.a(p.case(hero));
            }
        }
    }
}

