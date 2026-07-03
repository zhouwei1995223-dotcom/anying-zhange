/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.web;

import app.a.b;
import app.island.entity.Hero;
import app.island.entity.Player;
import app.island.gs.GameServer;
import app.island.gs.h;
import app.island.gs.o;
import app.island.gs.web.WebServlet;
import java.net.URLEncoder;

public class GetHeroList
extends WebServlet {
    public String getResponseText(b b2, GameServer gameServer, o o2) {
        daff.a.h h2 = gameServer.a().a();
        int n2 = h2.for();
        StringBuffer stringBuffer = new StringBuffer(n2 * 100);
        stringBuffer.append("total hero count:");
        stringBuffer.append(n2);
        stringBuffer.append("<BR>");
        int n3 = 0;
        while (n3 < n2) {
            h h3 = (h)h2.if(n3);
            Hero hero = h3.r();
            stringBuffer.append("<a href='GetHeroInfo?name=");
            stringBuffer.append(URLEncoder.encode(hero.name));
            stringBuffer.append("&pwd=");
            stringBuffer.append(o2.if());
            stringBuffer.append("'>");
            stringBuffer.append(hero.name);
            stringBuffer.append("</a>");
            stringBuffer.append('[');
            stringBuffer.append("User=");
            stringBuffer.append(hero.user.name);
            stringBuffer.append(";\u7b49\u7ea7=");
            stringBuffer.append(hero.level);
            stringBuffer.append(";\u804c\u4e1a=");
            stringBuffer.append(Player.RACE_NAMES[hero.race]);
            stringBuffer.append(";\u65b9\u5f0f=");
            if (h3.for()) {
                stringBuffer.append("\u6d4f\u89c8\u5668\u7f51\u9875");
            } else {
                stringBuffer.append("\u672c\u5730\u5ba2\u6237\u7aef");
            }
            stringBuffer.append(']');
            stringBuffer.append("<BR>");
            ++n3;
        }
        return stringBuffer.toString();
    }
}

