/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.npc;

import app.island.entity.Hero;
import app.island.gs.ServerInfo;
import app.island.gs.h;
import app.island.gs.npc.NpcScript;

public class ArenaManager
extends NpcScript {
    public void init() {
    }

    public void processCommand(String string, h h2) {
        if (string.equals("enter")) {
            Hero hero = h2.r();
            if (hero.level > 60) {
                h2.j().do().a(h2, 100, 0, 0);
            } else {
                h2.for("\u60a8\u7684\u7b49\u7ea7\u4e0d\u591f\uff0c\u9700\u898160\u7ea7\u624d\u53ef\u4ee5\u53c2\u52a0\u7ade\u6280\u573a\u6d3b\u52a8");
            }
        }
    }

    public String getResponseDailogEntry(h h2) {
        if (ServerInfo.currentTimeParts[3] < 13) {
            return "not-time";
        }
        if (ServerInfo.currentTimeParts[3] == 13 && ServerInfo.currentTimeParts[4] < 30) {
            return "start";
        }
        if (ServerInfo.currentTimeParts[3] < 21) {
            return "over-time1";
        }
        if (ServerInfo.currentTimeParts[3] == 21 && ServerInfo.currentTimeParts[4] < 30) {
            return "start";
        }
        return "over-time2";
    }
}

