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

public class GetHeroInfo
extends WebServlet {
    public String getResponseText(b b2, GameServer gameServer, o o2) {
        String string = b2.if("name");
        Hero hero = gameServer.new().new(string);
        if (hero == null) {
            return "hero not found:" + string;
        }
        StringBuffer stringBuffer = new StringBuffer(1024);
        stringBuffer.append(hero.name);
        stringBuffer.append('[');
        stringBuffer.append("User=");
        stringBuffer.append(hero.user.name);
        stringBuffer.append(";\u5143\u5b9d=");
        stringBuffer.append(hero.user.treasure);
        stringBuffer.append(";\u8d26\u53f7\u5145\u503c=");
        stringBuffer.append(hero.user.payedTreasure);
        stringBuffer.append(";\u8d26\u53f7\u6536\u76ca=");
        stringBuffer.append(hero.user.earnedTreasure);
        stringBuffer.append(";\u8d26\u53f7\u6d88\u8d39=");
        stringBuffer.append(hero.user.consumedTreasure);
        stringBuffer.append(";\u89d2\u8272\u5145\u503c=");
        stringBuffer.append(hero.payedTreasure);
        stringBuffer.append(";\u89d2\u8272\u6536\u76ca=");
        stringBuffer.append(hero.earnedTreasure);
        stringBuffer.append(";\u89d2\u8272\u6d88\u8d39=");
        stringBuffer.append(hero.consumedTreasure);
        stringBuffer.append(";\u6b7b\u4ea1=");
        stringBuffer.append(hero.deathCount);
        stringBuffer.append(";\u6740\u602a=");
        stringBuffer.append(hero.monsterKills);
        stringBuffer.append(";\u6740\u4eba=");
        stringBuffer.append(hero.playerKills);
        stringBuffer.append(";PK=");
        stringBuffer.append(hero.pkValue);
        stringBuffer.append(";\u5728\u7ebf\u65f6\u95f4=");
        int n2 = hero.onlineTime;
        stringBuffer.append(n2 / 3600);
        stringBuffer.append("\u5c0f\u65f6");
        stringBuffer.append(n2 / 60 % 60);
        stringBuffer.append('\u5206');
        stringBuffer.append(n2 % 60);
        stringBuffer.append('\u79d2');
        stringBuffer.append(";\u79fb\u52a8=");
        stringBuffer.append(hero.movable);
        stringBuffer.append(";\u6218\u6597=");
        stringBuffer.append(hero.fightable);
        stringBuffer.append(";\u804a\u5929=");
        stringBuffer.append(hero.chatable);
        stringBuffer.append(";\u7b49\u7ea7=");
        stringBuffer.append(hero.level);
        stringBuffer.append(";\u804c\u4e1a=");
        stringBuffer.append(Player.RACE_NAMES[hero.race]);
        h h2 = (h)hero.attachment;
        if (h2 != null) {
            stringBuffer.append(";\u573a\u666f=");
            stringBuffer.append(hero.sceneName);
            stringBuffer.append(";\u6e38\u620f\u65b9\u5f0f=");
            if (h2.for()) {
                stringBuffer.append("\u6d4f\u89c8\u5668\u7f51\u9875");
            } else {
                stringBuffer.append("\u672c\u5730\u5ba2\u6237\u7aef");
            }
        } else {
            stringBuffer.append(";\u79bb\u7ebf");
        }
        stringBuffer.append(']');
        stringBuffer.append("<BR><a href='HeroList?pwd=");
        stringBuffer.append(o2.if());
        stringBuffer.append("'>\u8fd4\u56de</a>");
        return stringBuffer.toString();
    }
}

