/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.web;

import app.a.b;
import app.island.entity.Hero;
import app.island.entity.Player;
import app.island.gs.GameServer;
import app.island.gs.data.HeroRankData;
import app.island.gs.o;
import app.island.gs.web.WebServlet;

public class GetTopHeroList
extends WebServlet {
    public String getResponseText(b b2, GameServer gameServer, o o2) {
        HeroRankData heroRankData = gameServer.a().int(1);
        StringBuffer stringBuffer = new StringBuffer(1023);
        stringBuffer.append("document.write(\"");
        int n2 = 0;
        while (heroRankData.names[n2] != null) {
            Hero hero = gameServer.new().new(heroRankData.names[n2]);
            stringBuffer.append("<tr>");
            stringBuffer.append("<td align='center'>");
            stringBuffer.append(heroRankData.names[n2]);
            stringBuffer.append("</td>");
            stringBuffer.append("<td align='center'>");
            if (hero == null) {
                stringBuffer.append("-");
            } else {
                stringBuffer.append(Player.SEX_NAMES[hero.sex]);
            }
            stringBuffer.append("</td>");
            stringBuffer.append("<td align='center'>");
            if (hero == null) {
                stringBuffer.append(heroRankData.levels[n2]);
            } else {
                stringBuffer.append(hero.level);
            }
            stringBuffer.append("</td>");
            stringBuffer.append("<td align='center'>");
            if (hero == null) {
                stringBuffer.append("-");
            } else {
                stringBuffer.append(hero.turns);
            }
            stringBuffer.append("</td>");
            stringBuffer.append("<td align='center'>");
            if (hero == null) {
                stringBuffer.append("-");
            } else {
                stringBuffer.append(Player.RACE_NAMES[hero.race]);
            }
            stringBuffer.append("</td>");
            stringBuffer.append("<td align='center'>");
            if (hero == null) {
                stringBuffer.append(heroRankData.values[n2]);
            } else {
                stringBuffer.append(hero.personalDepot.money);
            }
            stringBuffer.append("</td>");
            stringBuffer.append("</tr>");
            if (++n2 < 20) continue;
        }
        stringBuffer.append("\");");
        return stringBuffer.toString();
    }
}

