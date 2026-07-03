/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.npc;

import app.island.entity.Guild;
import app.island.entity.Hero;
import app.island.gs.ServerInfo;
import app.island.gs.e;
import app.island.gs.h;
import app.island.gs.npc.NpcScript;
import app.island.gs.p;
import daff.a.b;
import java.util.Date;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class CityManager
extends NpcScript {
    private int if = 0;
    private int int = 1000000;
    private int try = 1333990021;
    private int for = 63010421;
    private int new = 80010221;
    private int byte = 74010221;
    private long do;

    private int a() {
        Date date = new Date();
        int n2 = 6 - date.getDay();
        date = new Date(date.getYear(), date.getMonth(), date.getDate() + n2, 20, 0, 0);
        return b.a(date);
    }

    public void update() {
        e e2 = this.a.for().p();
        if (e2 == null) {
            return;
        }
        if (this.do == 0L) {
            this.do = ServerInfo.currentMilliSecond + (long)((int)(Math.random() * 120000.0));
            return;
        }
        Guild guild = e2.e();
        if (guild.battleGuild == null) {
            if (ServerInfo.currentMilliSecond - this.do > 600000L) {
                String string = "\u672c\u57ce\u5e02\u7684\u57ce\u4e3b\u662f\u3010" + guild.leader + "\u3011\uff0c\u5f53\u524d\u7684\u73a9\u5bb6\u6446\u644a\u7a0e\u7387\u662f" + guild.cityTaxRate + "%";
                this.a.for().if(p.else(string));
                this.do = ServerInfo.currentMilliSecond;
            }
        } else {
            int n2 = ServerInfo.currentTimeParts[6];
            int n3 = ServerInfo.currentTimeParts[3];
            int n4 = ServerInfo.currentTimeParts[4];
            if (n2 < 6) {
                if (ServerInfo.currentMilliSecond - this.do > 600000L) {
                    String string = this.a.for().int() + "\u7684\u653b\u57ce\u6218\u5c06\u4e8e" + (6 - n2) + "\u5929\u540e\u7684\u665a\u4e0a20\u70b9\u5f00\u59cb\uff0c\u6311\u6218\u8005\u662f\u3016" + guild.battleGuild.name + "\u3017";
                    this.a.for().do().a(p.d(string));
                    this.do = ServerInfo.currentMilliSecond;
                }
            } else if (n2 == 6) {
                if (n3 < 18) {
                    if (ServerInfo.currentMilliSecond - this.do > 600000L) {
                        String string = this.a.for().int() + "\u7684\u653b\u57ce\u6218\u5c06\u4e8e\u4eca\u5929\u665a\u4e0a20\u70b9\u5f00\u59cb\uff0c\u6311\u6218\u8005\u662f\u3016" + guild.battleGuild.name + "\u3017";
                        this.a.for().do().a(p.d(string));
                        this.do = ServerInfo.currentMilliSecond;
                    }
                } else if (n3 == 18) {
                    if (ServerInfo.currentMilliSecond - this.do > 300000L) {
                        String string = this.a.for().int() + "\u7684\u653b\u57ce\u6218\u5c06\u4e8e\u4eca\u5929\u665a\u4e0a20\u70b9\u5f00\u59cb\uff0c\u6311\u6218\u8005\u662f\u3016" + guild.battleGuild.name + "\u3017";
                        this.a.for().do().a(p.d(string));
                        this.do = ServerInfo.currentMilliSecond;
                    }
                } else if (n3 == 19) {
                    if (ServerInfo.currentMilliSecond - this.do > 59000L) {
                        String string = this.a.for().int() + "\u7684\u653b\u57ce\u6218\u5728" + (60 - n4) + "\u5206\u949f\u540e\u5f00\u59cb\uff0c\u6311\u6218\u8005\u662f\u3016" + guild.battleGuild.name + "\u3017";
                        this.a.for().do().a(p.d(string));
                        if (guild.placedSign == null && e2.c() != null) {
                            string = "\u8bf7\u4f60\u8d76\u5feb\u5728" + this.a.for().int() + "\u7684\u67d0\u4e2a\u4f4d\u7f6e\u653e\u7f6e\u516c\u4f1a\u6807\u5fd7\uff0c\u5426\u5219\u5c06\u89c6\u4e3a\u5f03\u6743\uff01";
                            e2.c().try(string);
                        }
                        this.do = ServerInfo.currentMilliSecond;
                    }
                } else if (n3 == 20 && n4 == 0) {
                    if (this.a.for().F() == 0) {
                        if (guild.placedSign == null) {
                            e e3 = (e)guild.battleGuild.attachment;
                            e3.e().money += 1000000;
                            e3.a(p.if(e3.e()));
                            e3.e().cityID = this.a.for().try();
                            e3.e().cityName = this.a.for().int();
                            e3.e().cityTakeTime = ServerInfo.currentTimeCode;
                            e3.e().tmpTreasure = 0;
                            e3.e().taxedTreasure = 0;
                            e3.e().taxedMoney = 0;
                            e3.a(p.do(e3.e()));
                            this.a.for().a(e3);
                            String string = "\u7531\u4e8e\u3016" + guild.name + "\u3017\u6ca1\u6709\u5728" + this.a.for().int() + "\u653e\u7f6e\u516c\u4f1a\u6807\u5fd7\u7269\uff0c\u88ab\u89c6\u4e3a\u5f03\u6743\uff0c\u5f88\u7a9d\u56ca\u5f97\u5931\u53bb\u4e86\u7edf\u6cbb\u6743\uff01";
                            guild.cityID = 0;
                            guild.battleGuild = null;
                            guild.battleTime = 0;
                            guild.challengerID = 0;
                            e2.a(p.do(guild));
                            this.a.for().do().a(p.d(string));
                            this.a.for().do().a(p.if(0, 0, 5, 5));
                            this.do = ServerInfo.currentMilliSecond;
                        } else {
                            this.a.for().e(1);
                            String string = this.a.for().int() + "\u7684\u653b\u57ce\u6218\u5f00\u59cb\u4e86\uff0c\u6218\u6597\u6253\u54cd\u5728[" + guild.placedSign.x + "," + guild.placedSign.y + "]\uff01";
                            this.a.for().do().a(p.d(string));
                            this.a.for().do().a(p.if(0, 0, 5, 5));
                            this.do = ServerInfo.currentMilliSecond;
                        }
                    }
                } else if (n3 == 23 && n4 == 0 && this.a.for().F() == 1) {
                    this.a.for().e(0);
                    guild.money += 1000000;
                    e2.a(p.if(guild));
                    String string = this.a.for().int() + "\u7684\u653b\u57ce\u6218\u7ed3\u675f\u4e86\uff0c\u3016" + guild.name + "\u3017\u987d\u5f3a\u7684\u634d\u536b\u4e86\u4ed6\u4eec\u7684\u7edf\u6cbb\u8005\u5730\u4f4d\uff01";
                    this.a.for().do().a(p.d(string));
                    this.a.for().do().a(p.if(0, 0, 5, 5));
                    this.do = ServerInfo.currentMilliSecond;
                }
            }
        }
    }

    public void init() {
    }

    public void processCommand(String string, h h2) {
        Hero hero = h2.r();
        Guild guild = hero.joinedGuild;
        if (string.equals("viewGuildList")) {
            this.a.for().do().a(h2, 0);
        } else if (string.equals("challengeBoss")) {
            if (guild != null && guild.level >= 5 && guild.leader.equals(hero.name) && this.if == 0) {
                if (hero.personalDepot.money < this.int) {
                    h2.try("\u4f60\u6ca1\u6709\u8fd9\u4e48\u591a\u91d1\u5e01:" + this.int);
                } else if (this.a.for().a(this.a.byte(), this.a.if(), this.for, this.new, this.byte, 0)) {
                    hero.personalDepot.money -= this.int;
                    h2.a(p.case(hero));
                    this.if = 1;
                    this.a.for().if(p.f(5000));
                    String string2 = "\u9ed1\u591c\u9b54\u738b\u51fa\u73b0\u5728" + this.a.for().int() + "\u7684[" + this.a.byte() + "," + this.a.if() + "]\uff0c\u6740\u6b7b\u5b83\u5c31\u53ef\u80fd\u5f53\u4e0a\u57ce\u4e3b\uff0c\u52c7\u58eb\u4eec\u4e0a\u554a\uff01";
                    this.a.for().do().a(p.d(string2));
                }
            }
        } else if (string.equals("gotLicence")) {
            if (guild != null && this.if != 0) {
                if (guild.level < 5) {
                    this.a.a("guildNoLevel", h2);
                } else if (!guild.leader.equals(hero.name)) {
                    this.a.a("notLeader", h2);
                } else if (hero.personalDepot.getGoodsPosByID(this.try) < 0) {
                    if (hero.user.treasure > 0) {
                        --hero.user.treasure;
                        h2.a(p.case(hero));
                    }
                    this.a.a("noLicence", h2);
                } else {
                    this.if = 0;
                    h2.b(this.try);
                    guild.cityID = this.a.for().try();
                    guild.cityName = this.a.for().int();
                    guild.cityTakeTime = ServerInfo.currentTimeCode;
                    guild.cityTaxRate = 5;
                    guild.tmpTreasure = 0;
                    guild.taxedTreasure = 0;
                    guild.taxedMoney = 0;
                    h2.J().a(p.do(guild));
                    this.a.for().a(h2.J());
                    String string3 = "\u606d\u559c\u4f1f\u5927\u7684\u3010" + hero.name + "\u3011\u6218\u80dc\u6311\u6218\uff0c\u6210\u4e3a\u300e" + this.a.for().int() + "\u300f\u7684\u57ce\u4e3b\uff01";
                    this.a.for().do().a(p.d(string3));
                    this.a.for().do().a(p.void(string3));
                    this.a.for().do().a(p.if(0, 0, 5, 10));
                    this.a.a("flagPrompt", h2);
                }
            }
        } else if (string.equals("manage")) {
            if (guild != null && guild.leader.equals(hero.name) && guild.cityID == h2.j().try()) {
                if (guild.placedSign == null) {
                    this.a.a("noFlag", h2);
                } else if (guild.placedSign.sceneID != this.a.for().try()) {
                    this.a.a("noFlag", h2);
                } else {
                    h2.a(p.goto());
                }
            }
        } else if (string.equals("challengeGuild")) {
            e e2 = this.a.for().p();
            if (e2.e().battleGuild == guild) {
                this.a.a("alreadyChallenged1", h2);
            } else if (e2.e().battleGuild != null) {
                this.a.a("alreadyChallenged2", h2);
            } else if (guild.money < 1000000) {
                this.a.a("noChallengeMoney", h2);
            } else if (ServerInfo.currentTimeParts[6] >= 6) {
                this.a.a("weekend", h2);
            } else {
                guild.money -= 1000000;
                h2.J().a(p.if(guild));
                e2.e().battleGuild = guild;
                e2.e().challengerID = guild.id;
                e2.e().battleTime = this.a();
                String string4 = "\u3016" + h2.J().int() + "\u3017\u5411\u3016" + e2.int() + "\u3017\u53d1\u8d77\u4e86\u6311\u6218\uff0c\u653b\u57ce\u6218\u5c06\u5728\u661f\u671f\u516d20\u70b9\u5f00\u59cb\uff01";
                this.a.for().do().a(p.d(string4));
                this.a.for().do().a(p.if(0, 0, 5, 5));
            }
        }
    }

    public String getResponseDailogEntry(h h2) {
        e e2 = h2.J();
        if (e2 == null) {
            return "noGuild";
        }
        if (e2.e().level < 5) {
            return "guildNoLevel";
        }
        if (e2.e().cityID > 0 && e2.e().cityID != this.a.for().try()) {
            return "otherCityOwner";
        }
        if (this.a.for().p() == null) {
            if (this.if == 1) {
                return "fighting";
            }
            if (e2.e().leader.equals(h2.b())) {
                return "noOwnerToLeader";
            }
            return "noOwnerToMember";
        }
        if (this.a.for().p() == e2) {
            if (e2.e().leader.equals(h2.b())) {
                return "cityOwner";
            }
            return "cityMember";
        }
        String string = "start";
        string = e2.e().leader.equals(h2.b()) ? "otherGuildLeader" : "otherGuildMember";
        return string;
    }
}

