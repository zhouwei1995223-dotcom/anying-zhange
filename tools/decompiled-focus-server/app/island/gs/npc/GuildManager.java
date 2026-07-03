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

public class GuildManager
extends NpcScript {
    public void processCommand(String string, h h2) {
        Hero hero = h2.r();
        Guild guild = hero.joinedGuild;
        if (string.equals("create") && guild == null) {
            if (hero.level >= ServerInfo.guildCreationHeroLevel && hero.personalDepot.money >= ServerInfo.guildCreationMoneyCost && (ServerInfo.guildCreationGoodsCost <= 0 || hero.personalDepot.getGoodsPosByID(ServerInfo.guildCreationGoodsCost) >= 0)) {
                this.a.a("create-can", h2);
            } else {
                this.a.a("create-cannot", h2);
            }
        } else if (string.equals("yesCreate") && hero.joinedGuild == null) {
            h2.a(p.e());
        } else if (string.equals("view")) {
            this.a.for().do().a(h2, 0);
        } else if (string.equals("upgradeGuild") && guild != null && guild.leader.equals(hero.name)) {
            if (guild.level >= 5) {
                this.a.a("upgrade-full", h2);
            } else if (hero.personalDepot.money >= ServerInfo.guildUpgradeMoneyCost * guild.level && guild.memberList.for() >= ServerInfo.guildUpgradeMemberRequired * guild.level && guild.reputation >= ServerInfo.guildUpgradeReputationRequired * guild.level && (ServerInfo.guildUpgradeGoodsCost <= 0 || hero.personalDepot.getGoodsPosByID(ServerInfo.guildUpgradeGoodsCost) >= 0)) {
                this.a.a("upgrade-can", h2);
            } else {
                this.a.a("upgrade-cannot", h2);
            }
        } else if (string.equals("yesUpgrade") && guild != null && guild.leader.equals(hero.name)) {
            if (hero.personalDepot.money >= ServerInfo.guildUpgradeMoneyCost * guild.level && guild.memberList.for() >= ServerInfo.guildUpgradeMemberRequired * guild.level && guild.reputation >= ServerInfo.guildUpgradeReputationRequired * guild.level && (ServerInfo.guildUpgradeGoodsCost <= 0 || hero.personalDepot.getGoodsPosByID(ServerInfo.guildUpgradeGoodsCost) >= 0)) {
                hero.personalDepot.money -= ServerInfo.guildUpgradeMoneyCost * guild.level;
                h2.a(p.case(hero));
                h2.b(ServerInfo.guildUpgradeGoodsCost);
                e e2 = (e)guild.attachment;
                e2.long();
            } else {
                this.a.a("upgrade-cannot", h2);
            }
        } else if (string.startsWith("acceptMethod:") && guild.leader.equals(hero.name)) {
            int n2;
            guild.acceptMethod = n2 = string.charAt(string.length() - 1) - 48;
            switch (n2) {
                case 0: {
                    h2.for("\u4f60\u9009\u62e9\u4e86\u62d2\u7edd\u73a9\u5bb6\u7684\u5165\u4f1a\u7533\u8bf7\uff0c\u5176\u4ed6\u73a9\u5bb6\u65e0\u6cd5\u7533\u8bf7\u52a0\u5165\u4f60\u7684\u516c\u4f1a\u4e86\u3002");
                    break;
                }
                case 1: {
                    h2.for("\u4f60\u9009\u62e9\u4e86\u672c\u4eba\u5904\u7406\u7533\u8bf7\uff0c\u5219\u5f53\u4f60\u4e0d\u5728\u7ebf\u7684\u65f6\u5019\uff0c\u5176\u4ed6\u73a9\u5bb6\u65e0\u6cd5\u7533\u8bf7\u52a0\u5165\u4f60\u7684\u516c\u4f1a\u3002");
                    break;
                }
                case 2: {
                    h2.for("\u4f60\u9009\u62e9\u4e86\u526f\u4f1a\u957f\u5904\u7406\u5165\u4f1a\u7533\u8bf7\uff0c\u5f53\u4f60\u4e0d\u5728\u7ebf\u7684\u65f6\u5019\uff0c\u7533\u8bf7\u4fe1\u606f\u4f1a\u53d1\u7ed9\u526f\u4f1a\u957f\u3002");
                    break;
                }
            }
        }
    }

    public String getResponseDailogEntry(h h2) {
        e e2 = h2.J();
        if (e2 == null) {
            return "start1";
        }
        if (e2.e().leader.equals(h2.b())) {
            return "start2";
        }
        return "start3";
    }
}

