/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs;

import app.island.data.Depot;
import app.island.data.FightState;
import app.island.data.Goods;
import app.island.data.GoodsFormula;
import app.island.data.HeroTaskList;
import app.island.data.Question;
import app.island.data.Spell;
import app.island.data.Store;
import app.island.data.Task;
import app.island.entity.Guild;
import app.island.entity.Hero;
import app.island.entity.Monster;
import app.island.entity.Npc;
import app.island.entity.SceneObject;
import app.island.entity.Sprite;
import app.island.entity.Subject;
import app.island.entity.User;
import app.island.gs.ServerInfo;
import app.island.gs.b;
import app.island.gs.data.ActivityItem;
import app.island.gs.data.BetData;
import app.island.gs.data.DialogItem;
import app.island.gs.data.HeroRankData;
import app.island.gs.data.SceneConfigData;
import app.island.gs.e;
import app.island.gs.h;
import app.island.gs.q;
import app.island.gs.u;
import app.island.gs.v;
import daff.a.a;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class p {
    private static final app.b.b[] if = new app.b.b[10];
    private static int a;

    public static app.b.b b(int n2, int n3) {
        app.b.b b2 = p.c(593);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        e2.a(n3);
        return b2;
    }

    public static app.b.b a(Question question) {
        app.b.b b2 = p.c(597);
        daff.a.e e2 = b2.for();
        question.writeTo(e2);
        return b2;
    }

    public static app.b.b a(Hero hero, String string) {
        app.b.b b2 = p.c(3);
        daff.a.e e2 = b2.for();
        e2.a(hero != null);
        if (hero != null) {
            e2.a(hero.name);
            e2.a(hero.race);
            e2.a(hero.sex);
        } else {
            e2.do(string);
        }
        return b2;
    }

    public static app.b.b d(String string) {
        app.b.b b2 = p.c(14);
        daff.a.e e2 = b2.for();
        e2.do(string);
        e2.char(ServerInfo.systemNoticeColor);
        return b2;
    }

    public static app.b.b for(String string, int n2) {
        app.b.b b2 = p.c(14);
        daff.a.e e2 = b2.for();
        e2.do(string);
        e2.char(n2);
        return b2;
    }

    public static app.b.b a(ActivityItem[] activityItemArray) {
        app.b.b b2 = p.c(604);
        daff.a.e e2 = b2.for();
        e2.char(activityItemArray.length);
        e2.a(ServerInfo.currentMilliSecond);
        int n2 = 0;
        while (n2 < activityItemArray.length) {
            ActivityItem activityItem = activityItemArray[n2];
            e2.if(activityItem.name);
            e2.a(activityItem.hour);
            e2.a(activityItem.minute);
            e2.for(activityItem.duration);
            e2.if(activityItem.description);
            ++n2;
        }
        return b2;
    }

    public static app.b.b do(int n2, int n3, int n4, int n5, int n6) {
        app.b.b b2 = p.c(268);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        e2.a(n3);
        e2.a(n4);
        e2.a(n5 / 100);
        e2.a(n6 / 100);
        return b2;
    }

    public static app.b.b a(Monster monster) {
        app.b.b b2 = p.c(273);
        daff.a.e e2 = b2.for();
        e2.do(monster.description);
        return b2;
    }

    public static app.b.b do(int n2, int n3, int n4) {
        app.b.b b2 = p.c(281);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        e2.a(n3);
        e2.for(n4);
        return b2;
    }

    public static app.b.b m(int n2, int n3) {
        app.b.b b2 = p.c(282);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        e2.for(n3);
        return b2;
    }

    public static app.b.b a(int n2, Goods goods) {
        app.b.b b2 = p.c(515);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        e2.a(goods.goodsType);
        goods.writeTo(e2);
        return b2;
    }

    public static app.b.b void() {
        app.b.b b2 = p.c(537);
        b2.for();
        return b2;
    }

    public static app.b.b b(int n2) {
        app.b.b b2 = p.c(520);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        return b2;
    }

    public static app.b.b g(int n2, int n3) {
        app.b.b b2 = p.c(553);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        e2.a(n3);
        return b2;
    }

    public static app.b.b m(int n2) {
        app.b.b b2 = p.c(525);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        return b2;
    }

    public static app.b.b for(int n2, int n3) {
        app.b.b b2 = p.c(550);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        e2.a(n3);
        return b2;
    }

    public static app.b.b a(Goods[] goodsArray, Goods goods) {
        app.b.b b2 = p.c(551);
        daff.a.e e2 = b2.for();
        e2.a(goodsArray.length);
        int n2 = 0;
        while (n2 < goodsArray.length) {
            e2.a(goodsArray[n2] != null);
            ++n2;
        }
        e2.a(goods != null);
        if (goods != null) {
            e2.a(goods.goodsType);
            goods.writeTo(e2);
        }
        return b2;
    }

    public static app.b.b a(int n2, int n3, String string) {
        app.b.b b2 = p.c(556);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        e2.char(n3);
        e2.a(string);
        return b2;
    }

    public static app.b.b a(String string, int n2, int n3, String string2, String string3) {
        app.b.b b2 = p.c(562);
        daff.a.e e2 = b2.for();
        e2.a(string);
        e2.a(n2);
        e2.a(n3);
        e2.a(string2);
        e2.a(string3);
        return b2;
    }

    public static app.b.b do(int n2, String string) {
        app.b.b b2 = p.c(567);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        e2.a(string);
        return b2;
    }

    public static app.b.b byte(int n2) {
        app.b.b b2 = p.c(569);
        b2.for().a(n2);
        return b2;
    }

    public static app.b.b j() {
        app.b.b b2 = p.c(570);
        return b2;
    }

    public static app.b.b int(int n2, int n3, int n4) {
        app.b.b b2 = p.c(584);
        daff.a.e e2 = b2.for();
        e2.a(n3);
        e2.a(n4);
        e2.for(n2);
        return b2;
    }

    public static app.b.b a(String string, int n2, int n3) {
        app.b.b b2 = p.c(587);
        daff.a.e e2 = b2.for();
        e2.a(string);
        e2.a(n2);
        e2.a(n3);
        return b2;
    }

    public static app.b.b a(String string, String string2, String string3, int n2, int n3, int n4, int n5) {
        app.b.b b2 = p.c(774);
        daff.a.e e2 = b2.for();
        e2.a(string);
        e2.a(string3);
        e2.a(string2);
        e2.a(n2);
        e2.a(n3);
        e2.a(n4);
        e2.a(n5);
        return b2;
    }

    public static app.b.b do(int n2, Goods goods) {
        app.b.b b2 = p.c(1283);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        e2.a(goods.goodsType);
        goods.writeTo(e2);
        return b2;
    }

    public static app.b.b int(Guild guild) {
        app.b.b b2 = p.c(1795);
        daff.a.e e2 = b2.for();
        guild.writeTo(e2);
        return b2;
    }

    public static app.b.b i() {
        app.b.b b2 = p.c(1796);
        return b2;
    }

    public static app.b.b case(String string) {
        app.b.b b2 = p.c(1799);
        daff.a.e e2 = b2.for();
        e2.a(string);
        return b2;
    }

    public static app.b.b int(String string) {
        app.b.b b2 = p.c(1814);
        daff.a.e e2 = b2.for();
        e2.a(string);
        return b2;
    }

    public static app.b.b do(String string, int n2, int n3, int n4) {
        app.b.b b2 = p.c(1801);
        daff.a.e e2 = b2.for();
        e2.a(string);
        e2.a(n2);
        e2.a(n3);
        e2.a(n4);
        return b2;
    }

    public static app.b.b new(String string) {
        app.b.b b2 = p.c(1802);
        daff.a.e e2 = b2.for();
        e2.a(string);
        return b2;
    }

    public static app.b.b do(String string, int n2, int n3) {
        app.b.b b2 = p.c(1806);
        daff.a.e e2 = b2.for();
        e2.a(string);
        e2.char(n2);
        e2.char(n3);
        return b2;
    }

    public static app.b.b e(String string) {
        app.b.b b2 = p.c(1810);
        daff.a.e e2 = b2.for();
        e2.a(string);
        return b2;
    }

    public static app.b.b if() {
        app.b.b b2 = p.c(1819);
        return b2;
    }

    public static app.b.b goto() {
        app.b.b b2 = p.c(1820);
        return b2;
    }

    public static app.b.b else() {
        app.b.b b2 = p.c(1537);
        return b2;
    }

    public static app.b.b for(int n2, int n3, int n4) {
        app.b.b b2 = p.c(1544);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        e2.a(n3);
        e2.for(n4);
        return b2;
    }

    public static app.b.b q(int n2, int n3) {
        app.b.b b2 = p.c(1546);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        e2.for(n3);
        return b2;
    }

    public static app.b.b a(int n2, int n3, int n4, int n5, String string) {
        app.b.b b2 = p.c(1547);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        e2.a(n3);
        e2.a(n4);
        e2.char(n5);
        e2.a(string);
        return b2;
    }

    public static app.b.b a(int n2) {
        app.b.b b2 = p.c(1548);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        return b2;
    }

    public static app.b.b byte(int n2, int n3, int n4) {
        app.b.b b2 = p.c(1549);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        e2.a(n3);
        e2.a(n4);
        return b2;
    }

    public static app.b.b h() {
        app.b.b b2 = p.c(2058);
        b2.for();
        return b2;
    }

    public static app.b.b new(int n2, int n3) {
        app.b.b b2 = p.c(2051);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        e2.char(n3);
        return b2;
    }

    public static app.b.b b() {
        app.b.b b2 = p.c(3586);
        return b2;
    }

    public static app.b.b if(boolean bl, User user, String string) {
        app.b.b b2 = p.c(2);
        daff.a.e e2 = b2.for();
        e2.a(bl);
        if (bl) {
            user.writeTo(e2);
        } else {
            e2.do(string);
        }
        return b2;
    }

    public static app.b.b try(String string) {
        app.b.b b2 = p.c(12);
        daff.a.e e2 = b2.for();
        e2.do(string);
        e2.char(ServerInfo.systemAlertColor);
        return b2;
    }

    public static app.b.b new(String string, int n2) {
        app.b.b b2 = p.c(12);
        daff.a.e e2 = b2.for();
        e2.do(string);
        e2.char(n2);
        return b2;
    }

    public static app.b.b char(String string) {
        app.b.b b2 = p.c(13);
        daff.a.e e2 = b2.for();
        e2.do(string);
        e2.char(ServerInfo.systemErrorColor);
        return b2;
    }

    public static app.b.b a(SceneObject sceneObject) {
        app.b.b b2 = p.c(260);
        daff.a.e e2 = b2.for();
        e2.char(sceneObject.id);
        return b2;
    }

    public static app.b.b goto(Hero hero) {
        app.b.b b2 = p.c(274);
        daff.a.e e2 = b2.for();
        e2.char(hero.id);
        e2.a(hero.level);
        e2.for(hero.maxLife);
        return b2;
    }

    public static app.b.b new(Hero hero) {
        app.b.b b2 = p.c(277);
        daff.a.e e2 = b2.for();
        e2.char(hero.id);
        e2.a(hero.level);
        e2.for(hero.life);
        e2.for(hero.maxLife);
        return b2;
    }

    public static app.b.b a(Sprite sprite, int n2, int n3, int n4, int n5, Hero hero) {
        app.b.b b2 = p.c(262);
        daff.a.e e2 = b2.for();
        e2.char(sprite.id);
        e2.a(n2);
        e2.a(n3);
        e2.a(n4);
        e2.a(n5);
        e2.for(sprite.stepTime);
        return b2;
    }

    public static app.b.b a(Sprite sprite, int n2, int n3, int n4) {
        app.b.b b2 = p.c(sprite.objectType == 1 ? 270 : 271);
        daff.a.e e2 = b2.for();
        e2.char(sprite.id);
        e2.for(n2);
        e2.for(n3);
        e2.for(n4);
        return b2;
    }

    public static app.b.b do(int n2, int n3) {
        app.b.b b2 = p.c(276);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        e2.for(n3);
        return b2;
    }

    public static app.b.b a(int n2, int n3, int n4, int n5) {
        app.b.b b2 = p.c(280);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        e2.a(n3);
        e2.a(n4);
        e2.for(n5);
        return b2;
    }

    public static app.b.b else(Hero hero) {
        app.b.b b2 = p.c(284);
        daff.a.e e2 = b2.for();
        e2.char(hero.id);
        e2.a(hero.sex);
        return b2;
    }

    public static app.b.b a(String string, String string2) {
        app.b.b b2 = p.c(285);
        daff.a.e e2 = b2.for();
        e2.a(string);
        e2.a(string2);
        return b2;
    }

    public static app.b.b a(Npc npc) {
        app.b.b b2 = p.c(287);
        daff.a.e e2 = b2.for();
        e2.char(npc.id);
        e2.a(npc.visible);
        e2.a(npc.x);
        e2.a(npc.y);
        return b2;
    }

    public static app.b.b else(int n2) {
        app.b.b b2 = p.c(289);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        return b2;
    }

    public static app.b.b if(int n2, int n3, int n4) {
        app.b.b b2 = p.c(293);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        e2.a(n3);
        e2.a(n4);
        return b2;
    }

    public static app.b.b else(String string) {
        app.b.b b2 = p.c(296);
        daff.a.e e2 = b2.for();
        e2.a(string);
        return b2;
    }

    public static app.b.b if(int n2) {
        app.b.b b2 = p.c(513);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        return b2;
    }

    public static app.b.b for(Hero hero) {
        app.b.b b2 = p.c(518);
        daff.a.e e2 = b2.for();
        e2.for(hero.mana);
        return b2;
    }

    public static app.b.b l(int n2) {
        app.b.b b2 = p.c(536);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        return b2;
    }

    public static app.b.b k(int n2, int n3) {
        app.b.b b2 = p.c(554);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        e2.a(n3);
        return b2;
    }

    public static app.b.b k(int n2) {
        app.b.b b2 = p.c(519);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        return b2;
    }

    public static app.b.b i(int n2, int n3) {
        app.b.b b2 = p.c(552);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        e2.a(n3);
        return b2;
    }

    public static app.b.b g() {
        app.b.b b2 = p.c(522);
        return b2;
    }

    public static app.b.b int(Hero hero) {
        app.b.b b2 = p.c(527);
        daff.a.e e2 = b2.for();
        hero.spellList.writeTo(e2);
        return b2;
    }

    public static app.b.b a(int n2, int n3, int n4) {
        app.b.b b2 = p.c(530);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        e2.a(n3);
        e2.for(n4);
        return b2;
    }

    public static app.b.b a(int n2, Spell spell) {
        app.b.b b2 = p.c(531);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        e2.a(spell.spellType);
        spell.writeTo(e2);
        return b2;
    }

    public static app.b.b a(FightState fightState) {
        app.b.b b2 = p.c(533);
        daff.a.e e2 = b2.for();
        fightState.writeTo(e2);
        return b2;
    }

    public static app.b.b char(int n2) {
        app.b.b b2 = p.c(535);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        return b2;
    }

    public static app.b.b l(int n2, int n3) {
        app.b.b b2 = p.c(541);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        e2.a(n3);
        return b2;
    }

    public static app.b.b try(int n2) {
        app.b.b b2 = p.c(544);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        return b2;
    }

    private p() {
    }

    public static app.b.b char() {
        app.b.b b2 = p.c(595);
        return b2;
    }

    public static app.b.b try(int n2, int n3) {
        app.b.b b2 = p.c(555);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        e2.a(n3);
        return b2;
    }

    public static app.b.b for(int n2, String string) {
        app.b.b b2 = p.c(560);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        e2.a(string);
        return b2;
    }

    public static app.b.b new(int n2, int n3, int n4) {
        app.b.b b2 = p.c(566);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        e2.char(n3);
        e2.a(n4);
        return b2;
    }

    public static app.b.b if(Goods goods) {
        app.b.b b2 = p.c(571);
        return b2;
    }

    public static app.b.b d(int n2, int n3) {
        app.b.b b2 = p.c(572);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        e2.a(n3);
        return b2;
    }

    public static app.b.b a(Depot depot) {
        app.b.b b2 = p.c(577);
        daff.a.e e2 = b2.for();
        depot.writeShop(e2);
        return b2;
    }

    public static app.b.b if(int n2, int n3, String string) {
        app.b.b b2 = p.c(579);
        daff.a.e e2 = b2.for();
        e2.for(n2);
        e2.char(n3);
        e2.a(string);
        return b2;
    }

    public static app.b.b do(Hero hero) {
        app.b.b b2 = p.c(582);
        daff.a.e e2 = b2.for();
        e2.a(hero.name);
        e2.a(hero.race);
        e2.a(hero.level);
        e2.a(hero.turns);
        return b2;
    }

    public static app.b.b a() {
        app.b.b b2 = p.c(581);
        return b2;
    }

    public static app.b.b byte() {
        app.b.b b2 = p.c(588);
        return b2;
    }

    public static app.b.b a(String string, String string2, int n2, int n3) {
        app.b.b b2 = p.c(770);
        daff.a.e e2 = b2.for();
        e2.a(string);
        e2.a(string2);
        e2.char(n2);
        e2.char(n3);
        return b2;
    }

    public static app.b.b do(String string, String string2, int n2) {
        app.b.b b2 = p.c(773);
        daff.a.e e2 = b2.for();
        e2.a(string);
        e2.a(string2);
        e2.char(n2);
        return b2;
    }

    public static app.b.b a(String string, q.d d2, u u2, h h2) {
        String string2 = d2.int;
        string2 = daff.a.b.a(string2, "$heroName", h2.b());
        string2 = daff.a.b.a(string2, "$sceneName", u2.int());
        e e2 = u2.p();
        if (e2 != null) {
            string2 = daff.a.b.a(string2, "$ownerGuild", e2.e().name);
            string2 = daff.a.b.a(string2, "$cityMaster", e2.e().leader);
            string2 = daff.a.b.a(string2, "$cityTakeTime", daff.a.b.do(e2.e().cityTakeTime));
        }
        app.b.b b2 = p.c(1025);
        daff.a.e e3 = b2.for();
        e3.a(string);
        e3.do(string2);
        e3.char(d2.if);
        e3.a(d2.do.length);
        int n2 = 0;
        while (n2 < d2.do.length) {
            e3.a(d2.do[n2]);
            ++n2;
        }
        return b2;
    }

    public static app.b.b a(v v2) {
        app.b.b b2 = p.c(1281);
        daff.a.e e2 = b2.for();
        e2.char(v2.try());
        e2.a(v2.int());
        e2.for(v2.l());
        e2.for(v2.m());
        int n2 = v2.j();
        e2.a(v2.j());
        int n3 = 0;
        while (n3 < n2) {
            Goods goods = v2.new(n3);
            if (goods == null) {
                e2.a(-1);
            } else {
                e2.a(goods.goodsType);
                goods.writeTo(e2);
                if (goods.goodsType == 2 || goods.goodsType == 1) {
                    e2.a(goods.description);
                }
            }
            ++n3;
        }
        return b2;
    }

    public static app.b.b int(int n2, int n3) {
        app.b.b b2 = p.c(1285);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        e2.char(n3);
        return b2;
    }

    public static app.b.b e() {
        return p.c(1793);
    }

    public static app.b.b if(Guild guild) {
        app.b.b b2 = p.c(1800);
        b2.for().char(guild.money);
        return b2;
    }

    public static app.b.b if(String string, int n2) {
        app.b.b b2 = p.c(1803);
        daff.a.e e2 = b2.for();
        e2.a(string);
        e2.a(n2);
        return b2;
    }

    public static app.b.b try(String string, int n2) {
        app.b.b b2 = p.c(1805);
        daff.a.e e2 = b2.for();
        e2.a(string);
        e2.char(n2);
        return b2;
    }

    public static app.b.b do(int n2) {
        app.b.b b2 = p.c(1817);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        return b2;
    }

    public static app.b.b a(b b2) {
        app.b.b b3 = p.c(1538);
        daff.a.e e2 = b3.for();
        int n2 = b2.new() - 1;
        e2.a(n2);
        int n3 = 0;
        while (n3 < n2) {
            h h2 = (h)b2.a.if(n3);
            Hero hero = h2.r();
            e2.char(hero.id);
            e2.a(hero.name);
            e2.a(hero.x);
            e2.a(hero.y);
            e2.a(hero.level);
            e2.for(hero.life);
            e2.for(hero.maxLife);
            e2.a(hero.nameColor);
            e2.char(h2.H());
            e2.a(h2.b());
            ++n3;
        }
        return b3;
    }

    public static app.b.b a(h h2) {
        app.b.b b2 = p.c(1540);
        daff.a.e e2 = b2.for();
        Hero hero = h2.r();
        e2.char(hero.id);
        e2.a(hero.name);
        e2.a(hero.x);
        e2.a(hero.y);
        e2.a(hero.level);
        e2.for(hero.life);
        e2.for(hero.maxLife);
        e2.a(hero.nameColor);
        e2.char(h2.j().try());
        e2.a(h2.j().int());
        return b2;
    }

    public static app.b.b p(int n2, int n3) {
        app.b.b b2 = p.c(1545);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        e2.a(n3);
        return b2;
    }

    public static app.b.b if(int n2, Goods goods) {
        app.b.b b2 = p.c(2053);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        e2.a(goods.goodsType);
        goods.writeTo(e2);
        return b2;
    }

    public static app.b.b o(int n2, int n3) {
        app.b.b b2 = p.c(2052);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        e2.a(n3);
        return b2;
    }

    public static app.b.b a(HeroRankData heroRankData) {
        app.b.b b2 = p.c(2564);
        daff.a.e e2 = b2.for();
        heroRankData.writeTo(e2);
        return b2;
    }

    public static app.b.b a(a a2) {
        app.b.b b2 = p.c(3584);
        daff.a.e e2 = b2.for();
        e2.char(a2.for());
        int n2 = 0;
        while (n2 < a2.for()) {
            Subject subject = (Subject)a2.if(n2);
            subject.writeTo(e2);
            ++n2;
        }
        return b2;
    }

    public static app.b.b a(Question question, int n2, int n3) {
        app.b.b b2 = p.c(598);
        daff.a.e e2 = b2.for();
        question.writeTo(e2);
        e2.char(n2);
        e2.char(n3);
        return b2;
    }

    public static app.b.b if(Hero hero, String string) {
        app.b.b b2 = p.c(5);
        daff.a.e e2 = b2.for();
        e2.a(hero != null);
        if (hero == null) {
            e2.do(string);
        } else {
            hero.writeData(e2);
        }
        return b2;
    }

    public static app.b.b a(boolean bl, String string, String string2) {
        app.b.b b2 = p.c(4);
        daff.a.e e2 = b2.for();
        e2.a(bl);
        if (bl) {
            e2.a(string);
        } else {
            e2.do(string2);
        }
        return b2;
    }

    public static app.b.b d(int n2) {
        app.b.b b2 = p.c(30);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        return b2;
    }

    public static app.b.b f(int n2) {
        app.b.b b2 = p.c(31);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        return b2;
    }

    public static app.b.b a(SceneObject sceneObject, h h2) {
        app.b.b b2 = p.c(259);
        daff.a.e e2 = b2.for();
        e2.a(sceneObject.objectType);
        sceneObject.writeTo(e2);
        if (h2 == null || h2.r().gmGrade < 100) {
            return b2;
        }
        if (sceneObject.objectType == 1) {
            Monster monster = (Monster)sceneObject;
            e2.char(monster.monsterID);
            e2.char(monster.behaviorID);
            e2.char(monster.plunderID);
            e2.char(monster.reliveTimes);
        } else if (sceneObject.objectType == 2) {
            Npc npc = (Npc)sceneObject;
            e2.a(npc.dialog);
            e2.a(npc.script);
            e2.char(npc.behaviorID);
        }
        return b2;
    }

    public static app.b.b if(SceneObject sceneObject) {
        app.b.b b2 = p.c(261);
        daff.a.e e2 = b2.for();
        sceneObject.writeTo(e2);
        return b2;
    }

    public static app.b.b a(h h2, String string) {
        app.b.b b2 = p.c(272);
        daff.a.e e2 = b2.for();
        e2.char(h2.H());
        e2.char(h2.q() > 0 ? ServerInfo.gmNameColor : 0);
        e2.a(string);
        return b2;
    }

    public static app.b.b if(Sprite sprite, int n2, int n3, int n4) {
        app.b.b b2 = p.c(sprite.objectType == 1 ? 264 : 265);
        daff.a.e e2 = b2.for();
        e2.char(sprite.id);
        e2.a(n2);
        e2.a(n3);
        e2.a(sprite.getAttackTime() / 100);
        e2.a(n4);
        return b2;
    }

    public static app.b.b else(int n2, int n3, int n4) {
        app.b.b b2 = p.c(288);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        e2.a(n3);
        e2.a(n4);
        return b2;
    }

    public static app.b.b a(int n2, int n3, int n4, int n5, int n6) {
        app.b.b b2 = p.c(266);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        e2.a(n3);
        e2.a(n4);
        e2.a(n5 / 50);
        e2.a(n6);
        return b2;
    }

    public static app.b.b case() {
        app.b.b b2 = p.c(606);
        return b2;
    }

    public static app.b.b if(int n2, int n3, int n4, int n5, int n6) {
        app.b.b b2 = p.c(267);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        e2.a(n3);
        e2.a(n4);
        e2.a(n5 / 50);
        e2.a(n6);
        return b2;
    }

    public static app.b.b a(int n2, int n3, int n4, int n5, int n6, int n7, boolean bl, int n8, int n9, int n10) {
        app.b.b b2 = p.c(269);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        e2.a(n3);
        e2.a(n4);
        e2.a(n5);
        e2.a(n6);
        e2.a(n7);
        e2.a(bl);
        e2.a(n8);
        e2.a(n9 / 100);
        e2.a(n10 / 100);
        return b2;
    }

    public static app.b.b else(int n2, int n3) {
        app.b.b b2 = p.c(275);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        e2.for(n3);
        return b2;
    }

    public static app.b.b f(int n2, int n3) {
        app.b.b b2 = p.c(279);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        e2.a(n3);
        return b2;
    }

    public static app.b.b if(Hero hero) {
        app.b.b b2 = p.c(283);
        daff.a.e e2 = b2.for();
        e2.a(hero.name);
        hero.personalDepot.writeEquipments(e2);
        return b2;
    }

    public static app.b.b try(Hero hero) {
        app.b.b b2 = p.c(290);
        daff.a.e e2 = b2.for();
        e2.char(hero.id);
        if (hero.joinedGuild != null) {
            e2.a(hero.joinedGuild.level);
            e2.a(hero.guildPosition);
            e2.a(hero.joinedGuild.icon);
            e2.a(hero.joinedGuild.name);
        } else {
            e2.a(0);
        }
        return b2;
    }

    public static app.b.b try(int n2, int n3, int n4) {
        app.b.b b2 = p.c(292);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        e2.char(n3);
        e2.for(n4);
        return b2;
    }

    public static app.b.b if(int n2, int n3, int n4, int n5) {
        app.b.b b2 = p.c(294);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        e2.a(n3);
        e2.a(n4);
        e2.a(n5);
        return b2;
    }

    public static app.b.b byte(Hero hero) {
        app.b.b b2 = p.c(517);
        daff.a.e e2 = b2.for();
        e2.for(hero.life);
        return b2;
    }

    public static app.b.b a(Spell spell) {
        app.b.b b2 = p.c(529);
        daff.a.e e2 = b2.for();
        e2.a(spell.spellType);
        spell.writeTo(e2);
        return b2;
    }

    public static app.b.b goto(int n2, int n3) {
        app.b.b b2 = p.c(523);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        e2.a(n3);
        return b2;
    }

    public static app.b.b long(int n2, int n3) {
        app.b.b b2 = p.c(524);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        e2.a(n3);
        return b2;
    }

    public static app.b.b if(FightState fightState) {
        app.b.b b2 = p.c(534);
        daff.a.e e2 = b2.for();
        e2.char(fightState.id);
        return b2;
    }

    public static app.b.b d() {
        app.b.b b2 = p.c(538);
        return b2;
    }

    public static app.b.b n(int n2, int n3) {
        app.b.b b2 = p.c(540);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        e2.a(n3);
        return b2;
    }

    public static app.b.b long(int n2) {
        app.b.b b2 = p.c(542);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        return b2;
    }

    public static app.b.b h(int n2, int n3) {
        app.b.b b2 = p.c(545);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        e2.char(n3);
        return b2;
    }

    public static app.b.b b(String string) {
        app.b.b b2 = p.c(20);
        daff.a.e e2 = b2.for();
        e2.a(string);
        return b2;
    }

    public static app.b.b o(int n2) {
        app.b.b b2 = p.c(576);
        b2.for().a(n2);
        return b2;
    }

    public static app.b.b byte(int n2, int n3) {
        app.b.b b2 = p.c(549);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        e2.a(n3);
        return b2;
    }

    public static app.b.b a(int n2, long l2, long l3) {
        app.b.b b2 = p.c(591);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        e2.a(l2);
        e2.a(l3);
        return b2;
    }

    public static app.b.b char(int n2, int n3) {
        app.b.b b2 = p.c(559);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        e2.char(n3);
        return b2;
    }

    public static app.b.b goto(int n2) {
        app.b.b b2 = p.c(563);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        return b2;
    }

    public static app.b.b long() {
        app.b.b b2 = p.c(565);
        return b2;
    }

    public static app.b.b do(int n2, int n3, int n4, int n5) {
        app.b.b b2 = p.c(573);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        e2.a(n3);
        e2.char(n4);
        e2.char(n5);
        return b2;
    }

    public static app.b.b long(String string) {
        app.b.b b2 = p.c(583);
        daff.a.e e2 = b2.for();
        e2.a(string);
        return b2;
    }

    public static app.b.b void(int n2, int n3) {
        app.b.b b2 = p.c(586);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        e2.a(n3);
        return b2;
    }

    public static app.b.b if(String string) {
        app.b.b b2 = p.c(589);
        daff.a.e e2 = b2.for();
        e2.a(string);
        return b2;
    }

    public static app.b.b a(BetData betData) {
        app.b.b b2 = p.c(600);
        daff.a.e e2 = b2.for();
        e2.char(betData.treasureCost);
        e2.char(betData.moneyCost);
        e2.char(betData.arenaScoreCost);
        Goods goods = null;
        int n2 = 0;
        while (n2 < betData.goodsList.length) {
            goods = betData.goodsList[n2];
            e2.a(goods.goodsType);
            goods.writeTo(e2);
            ++n2;
        }
        return b2;
    }

    public static app.b.b a(Goods goods) {
        app.b.b b2 = p.c(602);
        daff.a.e e2 = b2.for();
        e2.a(goods.goodsType);
        goods.writeTo(e2);
        return b2;
    }

    public static app.b.b a(String string, String string2, int n2) {
        app.b.b b2 = p.c(769);
        daff.a.e e2 = b2.for();
        e2.a(string);
        e2.a(string2);
        e2.char(n2);
        return b2;
    }

    public static app.b.b if(String string, int n2, int n3, int n4) {
        app.b.b b2 = p.c(1798);
        daff.a.e e2 = b2.for();
        e2.a(string);
        e2.a(n2);
        e2.a(n3);
        e2.a(n4);
        return b2;
    }

    public static app.b.b do() {
        app.b.b b2 = p.c(1807);
        return b2;
    }

    public static app.b.b a(int n2, int n3) {
        app.b.b b2 = p.c(1822);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        e2.char(n3);
        return b2;
    }

    public static app.b.b c() {
        app.b.b b2 = p.c(1539);
        return b2;
    }

    public static app.b.b n(int n2) {
        app.b.b b2 = p.c(1541);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        return b2;
    }

    public static app.b.b e(int n2, int n3) {
        app.b.b b2 = p.c(1543);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        e2.for(n3);
        return b2;
    }

    public static app.b.b a(String string) {
        app.b.b b2 = p.c(2057);
        daff.a.e e2 = b2.for();
        e2.a(string);
        return b2;
    }

    public static app.b.b h(int n2) {
        app.b.b b2 = p.c(2055);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        return b2;
    }

    public static app.b.b try() {
        app.b.b b2 = p.c(2056);
        return b2;
    }

    public static app.b.b a(e[] eArray, int n2, int n3) {
        int n4 = n3 * 20;
        int n5 = Math.min(n4 + 20, n2);
        app.b.b b2 = p.c(2565);
        daff.a.e e2 = b2.for();
        e2.for(n2);
        e2.a(n3);
        int n6 = n4;
        while (n6 < n5) {
            e e3 = eArray[n6];
            Guild guild = e3.e();
            e2.char(guild.id);
            e2.a(guild.name);
            e2.a(guild.leader);
            e2.char(guild.createdTime);
            e2.a(guild.level);
            e2.char(guild.reputation);
            e2.a(guild.memberList.for());
            ++n6;
        }
        return b2;
    }

    public static app.b.b c(int n2) {
        app.b.b b2 = if[a];
        b2.a(n2);
        b2.for().char();
        if (++a >= if.length) {
            a = 0;
        }
        return b2;
    }

    public static app.b.b a(GoodsFormula goodsFormula, String string) {
        app.b.b b2 = p.c(596);
        daff.a.e e2 = b2.for();
        goodsFormula.writeTo(e2);
        e2.do(string);
        return b2;
    }

    public static app.b.b if(int n2, int n3) {
        app.b.b b2 = p.c(594);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        e2.a(n3);
        return b2;
    }

    public static app.b.b c(int n2, int n3) {
        app.b.b b2 = p.c(603);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        e2.char(n3);
        return b2;
    }

    public static app.b.b case(int n2, int n3, int n4) {
        app.b.b b2 = p.c(599);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        e2.char(n3);
        e2.char(n4);
        return b2;
    }

    public static app.b.b a(boolean bl, User user, String string) {
        app.b.b b2 = p.c(1);
        daff.a.e e2 = b2.for();
        e2.a(bl);
        if (bl && user != null) {
            user.writeTo(e2);
        } else {
            e2.do(string);
        }
        return b2;
    }

    public static app.b.b void(String string) {
        app.b.b b2 = p.c(11);
        daff.a.e e2 = b2.for();
        e2.a(string);
        e2.char(ServerInfo.systemInfoColor);
        return b2;
    }

    public static app.b.b int(String string, int n2) {
        app.b.b b2 = p.c(11);
        daff.a.e e2 = b2.for();
        e2.a(string);
        e2.char(n2);
        return b2;
    }

    public static app.b.b byte(String string) {
        app.b.b b2 = p.c(15);
        daff.a.e e2 = b2.for();
        e2.do(string);
        e2.char(ServerInfo.systemReportColor);
        return b2;
    }

    public static app.b.b a(Hero hero, u u2) {
        SceneConfigData sceneConfigData = u2.z();
        app.b.b b2 = p.c(257);
        daff.a.e e2 = b2.for();
        e2.char(sceneConfigData.mapid);
        e2.a(sceneConfigData.name);
        e2.a(sceneConfigData.viewRange);
        e2.a(sceneConfigData.safeRegionCenterX);
        e2.a(sceneConfigData.safeRegionCenterY);
        e2.a(sceneConfigData.safeRegionWidth);
        e2.a(sceneConfigData.safeRegionHeight);
        return b2;
    }

    public static app.b.b g(int n2) {
        app.b.b b2 = p.c(258);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        return b2;
    }

    public static app.b.b case(int n2, int n3) {
        app.b.b b2 = p.c(286);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        e2.a(n3);
        return b2;
    }

    public static app.b.b if(int n2, String string) {
        app.b.b b2 = p.c(291);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        e2.a(string);
        return b2;
    }

    public static app.b.b char(int n2, int n3, int n4) {
        app.b.b b2 = p.c(295);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        e2.a(n3);
        e2.a(n4);
        return b2;
    }

    public static app.b.b a(boolean bl, Hero hero) {
        app.b.b b2 = p.c(263);
        daff.a.e e2 = b2.for();
        e2.a(hero.x);
        e2.a(hero.y);
        return b2;
    }

    public static app.b.b case(Hero hero) {
        app.b.b b2 = p.c(514);
        daff.a.e e2 = b2.for();
        e2.char(hero.personalDepot.money);
        e2.char(hero.user.treasure);
        return b2;
    }

    public static app.b.b e(int n2) {
        app.b.b b2 = p.c(516);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        return b2;
    }

    public static app.b.b p(int n2) {
        app.b.b b2 = p.c(521);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        return b2;
    }

    public static app.b.b a(Hero hero) {
        app.b.b b2 = p.c(526);
        daff.a.e e2 = b2.for();
        hero.personalDepot.writeTo(e2);
        return b2;
    }

    public static app.b.b char(Hero hero) {
        app.b.b b2 = p.c(528);
        daff.a.e e2 = b2.for();
        hero.shortCuts.writeTo(e2);
        return b2;
    }

    public static app.b.b a(Store store) {
        app.b.b b2 = p.c(539);
        store.writeTo(b2.for());
        return b2;
    }

    public static app.b.b a(daff.a.h h2) {
        app.b.b b2 = p.c(590);
        daff.a.e e2 = b2.for();
        int n2 = h2.for();
        e2.char(n2);
        int n3 = 0;
        while (n3 < n2) {
            Task task = (Task)h2.if(n3);
            e2.char(task.id);
            e2.if(task.name);
            e2.if(task.objectiveDesc);
            e2.if(task.rewardDesc);
            task = null;
            ++n3;
        }
        h2 = null;
        return b2;
    }

    public static app.b.b a(Task task) {
        app.b.b b2 = p.c(543);
        daff.a.e e2 = b2.for();
        task.writeTo(e2);
        return b2;
    }

    public static app.b.b a(HeroTaskList heroTaskList) {
        app.b.b b2 = p.c(546);
        daff.a.e e2 = b2.for();
        heroTaskList.writeTo(e2);
        return b2;
    }

    public static app.b.b int() {
        return p.c(592);
    }

    public static app.b.b for(int n2) {
        app.b.b b2 = p.c(557);
        daff.a.e e2 = b2.for();
        e2.for(n2);
        return b2;
    }

    public static app.b.b void(int n2) {
        app.b.b b2 = p.c(558);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        return b2;
    }

    public static app.b.b a(int n2, String string) {
        app.b.b b2 = p.c(561);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        e2.a(string);
        return b2;
    }

    public static app.b.b new() {
        app.b.b b2 = p.c(564);
        return b2;
    }

    public static app.b.b a(boolean bl) {
        app.b.b b2 = p.c(568);
        daff.a.e e2 = b2.for();
        e2.a(bl);
        return b2;
    }

    public static app.b.b a(int n2, int n3, int n4, String string) {
        app.b.b b2 = p.c(574);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        e2.char(n3);
        e2.char(n4);
        e2.a(string);
        return b2;
    }

    public static app.b.b a(int n2, Spell spell, int n3) {
        app.b.b b2 = p.c(575);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        e2.a(spell.spellType);
        spell.writeTo(e2);
        e2.char(n3);
        return b2;
    }

    public static app.b.b int(int n2) {
        app.b.b b2 = p.c(578);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        return b2;
    }

    public static app.b.b long(Hero hero) {
        app.b.b b2 = p.c(580);
        daff.a.e e2 = b2.for();
        e2.a(hero.name);
        e2.a(hero.race);
        e2.a(hero.level);
        e2.a(hero.turns);
        return b2;
    }

    public static app.b.b a(String string, int n2, int n3, int n4) {
        app.b.b b2 = p.c(585);
        daff.a.e e2 = b2.for();
        e2.a(string);
        e2.a(n3);
        e2.a(n4);
        e2.for(n2);
        return b2;
    }

    public static app.b.b i(int n2) {
        app.b.b b2 = p.c(605);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        return b2;
    }

    public static app.b.b if(String string, String string2, int n2, int n3) {
        app.b.b b2 = p.c(771);
        daff.a.e e2 = b2.for();
        e2.a(string);
        e2.a(string2);
        e2.char(n2);
        e2.char(n3);
        return b2;
    }

    public static app.b.b for(String string, String string2, int n2) {
        app.b.b b2 = p.c(772);
        daff.a.e e2 = b2.for();
        e2.a(string);
        e2.a(string2);
        e2.char(n2);
        return b2;
    }

    public static app.b.b a(String string, DialogItem dialogItem, h h2) {
        String string2 = dialogItem.text;
        string2 = daff.a.b.a(string2, "$heroName", h2.b());
        string2 = daff.a.b.a(string2, "$sceneName", h2.j().int());
        e e2 = h2.j().p();
        if (e2 != null) {
            string2 = daff.a.b.a(string2, "$ownerGuild", e2.e().name);
            string2 = daff.a.b.a(string2, "$cityMaster", e2.e().leader);
            string2 = daff.a.b.a(string2, "$cityTakeTime", daff.a.b.do(e2.e().cityTakeTime));
        }
        app.b.b b2 = p.c(1025);
        daff.a.e e3 = b2.for();
        e3.a(string);
        e3.do(string2);
        e3.char(dialogItem.color);
        e3.a(dialogItem.options.length);
        int n2 = 0;
        while (n2 < dialogItem.options.length) {
            e3.a(dialogItem.options[n2]);
            ++n2;
        }
        return b2;
    }

    public static app.b.b j(int n2) {
        app.b.b b2 = p.c(1284);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        return b2;
    }

    public static app.b.b f() {
        app.b.b b2 = p.c(1282);
        return b2;
    }

    public static app.b.b for(Guild guild) {
        app.b.b b2 = p.c(1794);
        daff.a.e e2 = b2.for();
        guild.writeTo(e2);
        return b2;
    }

    public static app.b.b a(Guild guild) {
        app.b.b b2 = p.c(1797);
        daff.a.e e2 = b2.for();
        guild.writeTo(e2);
        return b2;
    }

    public static app.b.b new(int n2) {
        app.b.b b2 = p.c(1815);
        b2.for().char(n2);
        return b2;
    }

    public static app.b.b a(String string, int n2) {
        app.b.b b2 = p.c(1804);
        daff.a.e e2 = b2.for();
        e2.a(string);
        e2.a(n2);
        return b2;
    }

    public static app.b.b for() {
        app.b.b b2 = p.c(1808);
        return b2;
    }

    public static app.b.b goto(String string) {
        app.b.b b2 = p.c(1809);
        daff.a.e e2 = b2.for();
        e2.a(string);
        return b2;
    }

    public static app.b.b do(String string, int n2) {
        app.b.b b2 = p.c(1811);
        daff.a.e e2 = b2.for();
        e2.a(string);
        e2.a(n2);
        return b2;
    }

    public static app.b.b do(String string) {
        app.b.b b2 = p.c(1812);
        daff.a.e e2 = b2.for();
        e2.a(string);
        return b2;
    }

    public static app.b.b if(String string, String string2, int n2) {
        app.b.b b2 = p.c(1813);
        daff.a.e e2 = b2.for();
        e2.a(string);
        e2.a(string2);
        e2.char(n2);
        return b2;
    }

    public static app.b.b a(int n2, Goods goods, String string) {
        app.b.b b2 = p.c(1816);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        e2.a(goods.goodsType);
        goods.writeTo(e2);
        e2.a(string);
        return b2;
    }

    public static app.b.b if(String string, int n2, int n3) {
        app.b.b b2 = p.c(1818);
        daff.a.e e2 = b2.for();
        e2.do(string);
        e2.char(n2);
        e2.char(n3);
        return b2;
    }

    public static app.b.b do(Guild guild) {
        app.b.b b2 = p.c(1823);
        daff.a.e e2 = b2.for();
        e2.char(guild.cityID);
        e2.a(guild.cityName);
        e2.char(guild.cityTakeTime);
        return b2;
    }

    public static app.b.b for(String string) {
        app.b.b b2 = p.c(2049);
        daff.a.e e2 = b2.for();
        e2.a(string);
        return b2;
    }

    public static app.b.b j(int n2, int n3) {
        app.b.b b2 = p.c(2050);
        daff.a.e e2 = b2.for();
        e2.a(n2);
        e2.a(n3);
        return b2;
    }

    public static app.b.b case(int n2) {
        app.b.b b2 = p.c(2054);
        daff.a.e e2 = b2.for();
        e2.char(n2);
        return b2;
    }

    public static app.b.b a(String string, String string2, String string3) {
        app.b.b b2 = p.c(2563);
        daff.a.e e2 = b2.for();
        e2.a(string2);
        e2.a(string3);
        return b2;
    }

    public static app.b.b c(String string) {
        app.b.b b2 = p.c(3075);
        daff.a.e e2 = b2.for();
        e2.if(string);
        return b2;
    }

    public static app.b.b a(Subject subject) {
        app.b.b b2 = p.c(3585);
        daff.a.e e2 = b2.for();
        subject.writeTo(e2);
        return b2;
    }

    static {
        int n2 = 0;
        while (n2 < if.length) {
            p.if[n2] = new app.b.b(0, new daff.a.e(4096));
            ++n2;
        }
    }

    public static app.b.b a(boolean bl, long l2) {
        app.b.b b2 = p.c(601);
        daff.a.e e2 = b2.for();
        e2.a(bl);
        e2.a(l2);
        e2.a(ServerInfo.currentMilliSecond);
        return b2;
    }
}

