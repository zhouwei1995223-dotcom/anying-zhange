/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs;

import app.island.GameObject;
import app.island.data.Decoration;
import app.island.data.Equipment;
import app.island.data.Goods;
import app.island.data.SpecialProperty;
import app.island.data.Weapon;
import app.island.entity.Guild;
import app.island.entity.Hero;
import app.island.gs.ServerInfo;
import app.island.gs.b;
import app.island.gs.data.BetData;
import app.island.gs.data.BoxPlunder;
import app.island.gs.data.PlunderData;
import app.island.gs.e;
import app.island.gs.h;
import app.island.gs.n;
import app.island.gs.p;
import app.island.gs.u;
import app.island.gs.w;
import java.util.Date;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class l {
    public static final int[] do = new int[]{100, 100, 100, 100, 100, 100, 90, 90, 95, 80, 76, 72, 68, 64, 60, 56, 52, 48, 44, 40, 36, 32, 28, 24, 20, 16, 12, 8, 4};
    private static final int[] a = new int[100];
    private u if;

    public Goods a(BetData betData) {
        int n2 = (int)(Math.random() * 10000.0);
        return betData.getResultGoods(n2);
    }

    private void if(h h2) {
        Hero hero = h2.r();
        int n2 = 0;
        if (hero.personalDepot.weapon != null) {
            l.a[n2++] = 0;
        } else if (hero.personalDepot.armor != null) {
            l.a[n2++] = 0x10000 | hero.personalDepot.armor.eType << 8;
        } else if (hero.personalDepot.helmet != null) {
            l.a[n2++] = 0x10000 | hero.personalDepot.helmet.eType << 8;
        } else if (hero.personalDepot.boots != null) {
            l.a[n2++] = 0x10000 | hero.personalDepot.boots.eType << 8;
        } else if (hero.personalDepot.shield != null) {
            l.a[n2++] = 0x10000 | hero.personalDepot.shield.eType << 8;
        } else if (hero.personalDepot.leftEarbob != null) {
            l.a[n2++] = 0x20000 | hero.personalDepot.leftEarbob.dType << 8 | 1;
        } else if (hero.personalDepot.rightEarbob != null) {
            l.a[n2++] = 0x20000 | hero.personalDepot.rightEarbob.dType << 8 | 2;
        } else if (hero.personalDepot.necklace != null) {
            l.a[n2++] = 0x20000 | hero.personalDepot.necklace.dType << 8;
        } else if (hero.personalDepot.leftRing != null) {
            l.a[n2++] = 0x20000 | hero.personalDepot.leftRing.dType << 8 | 1;
        } else if (hero.personalDepot.rightRing != null) {
            l.a[n2++] = 0x20000 | hero.personalDepot.rightRing.dType << 8 | 2;
        }
        if (n2 == 0) {
            return;
        }
        int n3 = (int)Math.random() * n2;
        int n4 = a[n3];
        int n5 = n4 >> 8 & 0xFF;
        int n6 = n4 & 0xFF;
        Goods goods = null;
        switch (n4 >> 16) {
            case 0: {
                goods = hero.personalDepot.unequipWeapon();
                h2.a(p.void());
                h2.a((Weapon)goods, null);
                break;
            }
            case 1: {
                goods = hero.personalDepot.unequipEquipment(n5);
                h2.a(p.l(n5));
                h2.a((Equipment)goods, null);
                break;
            }
            case 2: {
                goods = hero.personalDepot.unequipDecoration(n5, n6);
                h2.a(p.k(n5, n6));
                h2.a((Decoration)goods, null);
                break;
            }
        }
        if (goods != null) {
            hero.calculateProperties();
            this.if.a(goods, 0, 0, hero.x, hero.y);
        }
    }

    public void a(h h2, h h3) {
        if (this.if.K() == 1) {
            int n2 = h3.r().level;
            h2.r().arenaScores += n2;
            h2.a(p.i(h2.r().arenaScores));
            this.if.do().a(h2.r(), 10);
            int n3 = h3.r().level;
            int n4 = n3 * n3 / 10 + 20;
            n4 *= ServerInfo.expTimes;
            n4 *= 2;
            if (h3.r().doubleExpLifeTime > 0) {
                n4 *= 2;
            }
            h2.int(n4);
        } else if (this.if.K() == 5) {
            int n5 = Math.min(h2.r().level, h3.r().level);
            int n6 = n5 * n5 / 10;
            n6 *= ServerInfo.expTimes;
            if (h3.r().doubleExpLifeTime > 0) {
                n6 *= 2;
            }
            h2.int(n6);
            ++h2.r().arenaScores;
        } else {
            this.a(h3);
        }
    }

    public static boolean do(int n2) {
        Date date = new Date();
        Date date2 = daff.a.b.a(n2);
        int n3 = date.getHours();
        int n4 = date2.getHours();
        int n5 = date.getMinutes();
        return Math.abs(n3 - n4) > 0 && n5 >= 0 && n5 <= 5;
    }

    public void a(n n2, h h2) {
        this.a(h2);
    }

    private void a(h h2) {
        Hero hero = h2.r();
        if (hero.level > ServerInfo.heroDeathPunishProtectionLevel || hero.nameColor > 0) {
            int n2 = 0;
            while (n2 < hero.personalDepot.goodsList.length) {
                if (hero.personalDepot.goodsList[n2] != null && hero.personalDepot.goodsList[n2].goodsType == 5) {
                    SpecialProperty specialProperty = (SpecialProperty)hero.personalDepot.goodsList[n2];
                    if (specialProperty.spType == 37) {
                        if (specialProperty.parameter1 > 1) {
                            specialProperty.parameter1 += -1;
                            h2.a(p.do(specialProperty.id, specialProperty.getExtraInfo()));
                        } else {
                            h2.long(n2);
                        }
                        return;
                    }
                }
                ++n2;
            }
        }
        switch (hero.nameColor) {
            case 0: {
                if (hero.level <= ServerInfo.heroDeathPunishProtectionLevel || !(Math.random() > 0.5)) break;
                this.do(h2);
                break;
            }
            case 1: {
                this.do(h2);
                if (!(Math.random() > 0.5)) break;
                this.if(h2);
                break;
            }
            case 2: {
                float f2 = 1.0f;
                float f3 = 1.0f;
                int n3 = 7;
                int n4 = 5;
                if (hero.pkValue <= 10) {
                    f2 = 0.8f;
                    f3 = 0.5f;
                    n3 = 3;
                    n4 = 2;
                } else if (hero.pkValue <= 30) {
                    f2 = 0.8f;
                    f3 = 0.8f;
                    n3 = 4;
                    n4 = 3;
                } else if (hero.pkValue <= 50) {
                    f2 = 0.8f;
                    f3 = 0.9f;
                    n3 = 6;
                    n4 = 3;
                }
                int n5 = 0;
                while (n5 < n3) {
                    if (Math.random() < (double)f2) {
                        this.do(h2);
                    }
                    ++n5;
                }
                n5 = 0;
                while (n5 < n4) {
                    if (Math.random() < (double)f3) {
                        this.if(h2);
                    }
                    ++n5;
                }
                break;
            }
        }
    }

    public Goods a(int n2) {
        BoxPlunder boxPlunder = w.case().else(n2);
        if (boxPlunder == null) {
            return null;
        }
        int n3 = (int)(Math.random() * 10000.0);
        int n4 = 0;
        while (n4 < boxPlunder.goodsIDTable.length) {
            if (n3 <= boxPlunder.extraGoodsRates[n4]) {
                return Goods.getGlobalGoods(boxPlunder.goodsIDTable[n4]);
            }
            ++n4;
        }
        return null;
    }

    public void a(h h2, n n2) {
        b b2;
        h h3;
        int n3;
        PlunderData plunderData;
        if (h2 == null || n2 == null) {
            return;
        }
        h h4 = n2.e();
        if (h4 != null) {
            h2 = h4;
        }
        if ((plunderData = n2.j()) == null) {
            return;
        }
        int n4 = 0;
        int n5 = 0;
        if (!h2.void()) {
            this.a(h2, plunderData, n2.i(), n2.try());
        }
        n4 = (int)((double)plunderData.minExp + Math.random() * (double)(plunderData.maxExp - plunderData.minExp));
        n5 = (int)((double)plunderData.minMoney + Math.random() * (double)(plunderData.maxMoney - plunderData.minMoney));
        if (h2.void()) {
            n5 /= 4;
        }
        Hero hero = h2.r();
        int n6 = Math.abs(hero.level - n2.g().level);
        if (this.if.u() > 0) {
            if (n6 >= do.length) {
                return;
            }
            n4 = n4 * do[n6] / 100;
            n5 = n5 * do[n6] / 100;
        }
        n4 = n4 * this.if.n() / 100;
        n5 = n5 * this.if.o() / 100;
        n4 *= ServerInfo.expTimes;
        n5 *= ServerInfo.moneyTimes;
        if (!h2.void() && n6 < do.length && (n3 = do[n6] / 100) > 0 && Math.random() * 1000.0 < (double)ServerInfo.treasureDropTimes) {
            h2.try(n3);
            ServerInfo.dropedTreasure += n3;
        }
        if (!h2.void() && h2.l() != null && n6 < do.length && (h3 = (h)h2.l().attachment) != null && !h3.i() && h3.j() == h2.j() && h3.g() && h2.j().a(hero.x, hero.y, h3.m(), h3.o())) {
            if (hero.friendList.master.closeness < 10000 && do[n6] == 100) {
                ++hero.friendList.master.closeness;
                h3.r().friendList.addStudentCloseness(hero.name, 1);
            }
            int n7 = 10 + hero.friendList.master.closeness * 90 / 10000;
            n4 += n4 * n7 / 100;
        }
        if (hero.expLuck != 100) {
            n4 = n4 * hero.expLuck / 100;
        }
        if ((b2 = h2.x()) != null) {
            n4 += b2.new() * (n4 / 5);
            n5 += b2.new() * (n5 / 5);
            b2.a(n4, h2);
            b2.if(n5, h2);
        } else {
            if (hero.doubleExpLifeTime > 0) {
                n4 = n4 * hero.doubleExpRate / 100;
            }
            h2.int(n4);
            h2.new(n5);
        }
    }

    public void a(h h2, PlunderData plunderData, int n2, int n3) {
        int n4;
        int n5 = plunderData.level;
        int n6 = 0;
        Goods goods = null;
        int n7 = 1;
        Hero hero = h2.r();
        if (plunderData.bigDropRate > 0 && Math.random() * 10000.0 < (double)plunderData.bigDropRate) {
            n7 = plunderData.bigDropTimes;
        }
        int n8 = n7 * plunderData.medicineDropCount;
        int n9 = 0;
        while (n9 < n8) {
            n6 = (int)(Math.random() * 10000.0 / (double)ServerInfo.medicineDropTimes);
            if ((n6 = n6 * 100 / this.if.N()) < plunderData.medicineDropRate && (goods = w.case().void(n5)) != null) {
                goods = (Goods)GameObject.cloneObject(goods);
                this.if.do().a(goods);
                if (plunderData.dropTopHeroDepot > 0) {
                    h2.a(goods);
                } else {
                    this.if.a(goods, h2.H(), plunderData.goodsProtectionTime, n2, n3);
                }
            }
            ++n9;
        }
        n9 = 0;
        while (n9 < plunderData.equipmentDropCounts.length) {
            n4 = n7 * plunderData.equipmentDropCounts[n9];
            int n10 = 0;
            while (n10 < n4) {
                n6 = (int)(Math.random() * 10000.0 / (double)ServerInfo.equipmentDropTimes);
                if ((n6 = n6 * 100 / this.if.N()) < plunderData.equipmentDropRates[n9]) {
                    if (Math.random() > (double)0.3f) {
                        goods = w.case().if(n5, n5 + 12, n9);
                        if (goods != null) {
                            goods = (Goods)GameObject.cloneObject(goods);
                            this.if.do().a(goods);
                            if (plunderData.dropTopHeroDepot > 0) {
                                h2.a(goods);
                            } else {
                                this.if.a(goods, h2.H(), plunderData.goodsProtectionTime, n2, n3);
                            }
                            if (goods.treasureCost > 0) {
                                this.if.do().long().saveUserLog(hero.user.name, hero.name, "plunderDrop", "goodsID=" + goods.id + ";cost=" + goods.treasureCost);
                            }
                        }
                    } else {
                        goods = w.case().do(n5, n5 + 12, n9);
                        if (goods != null) {
                            goods = (Goods)GameObject.cloneObject(goods);
                            this.if.do().a(goods);
                            if (plunderData.dropTopHeroDepot > 0) {
                                h2.a(goods);
                            } else {
                                this.if.a(goods, h2.H(), plunderData.goodsProtectionTime, n2, n3);
                            }
                            if (goods.treasureCost > 0) {
                                this.if.do().long().saveUserLog(hero.user.name, hero.name, "plunderDrop", "goodsID=" + goods.id + ";cost=" + goods.treasureCost);
                            }
                        }
                    }
                }
                ++n10;
            }
            n10 = n7 * plunderData.weaponDropCounts[n9];
            int n11 = 0;
            while (n11 < n10) {
                n6 = (int)(Math.random() * 10000.0 / (double)ServerInfo.equipmentDropTimes);
                if ((n6 = n6 * 100 / this.if.N()) < plunderData.weaponDropRates[n9] && (goods = w.case().a(n5, n5 + 12, n9)) != null) {
                    goods = (Goods)GameObject.cloneObject(goods);
                    this.if.do().a(goods);
                    if (plunderData.dropTopHeroDepot > 0) {
                        h2.a(goods);
                    } else {
                        this.if.a(goods, h2.H(), plunderData.goodsProtectionTime, n2, n3);
                    }
                    if (goods.treasureCost > 0) {
                        this.if.do().long().saveUserLog(hero.user.name, hero.name, "plunderDrop", "goodsID=" + goods.id + ";cost=" + goods.treasureCost);
                    }
                }
                ++n11;
            }
            ++n9;
        }
        n9 = plunderData.extraDropCount;
        n4 = 0;
        while (n4 < n9) {
            n6 = (int)(Math.random() * 10000.0 / (double)ServerInfo.extraGoodsDropTimes);
            if ((n6 = n6 * 100 / this.if.N()) < plunderData.extraGoodsRates[n4] && (goods = w.case().getGoods(plunderData.extraGoodsIDs[n4])) != null) {
                goods = (Goods)GameObject.cloneObject(goods);
                this.if.do().a(goods);
                if (plunderData.dropTopHeroDepot > 0) {
                    h2.a(goods);
                } else {
                    this.if.a(goods, h2.H(), plunderData.goodsProtectionTime, n2, n3);
                }
                if (goods.treasureCost > 0) {
                    this.if.do().long().saveUserLog(hero.user.name, hero.name, "plunderDrop", "goodsID=" + goods.id + ";cost=" + goods.treasureCost);
                }
            }
            ++n4;
        }
    }

    public u a() {
        return this.if;
    }

    public void a(u u2) {
        this.if = u2;
    }

    public Goods if(int n2) {
        BoxPlunder boxPlunder = w.case().else(n2);
        if (boxPlunder == null) {
            return null;
        }
        int n3 = (int)(Math.random() * 10000.0);
        int n4 = 0;
        while (n4 < boxPlunder.weaponRates.length) {
            if (n3 <= boxPlunder.weaponRates[n4]) {
                return w.case().a(boxPlunder.minLevel, boxPlunder.maxLevel, n4);
            }
            ++n4;
        }
        n4 = 0;
        while (n4 < boxPlunder.equipmentRates.length) {
            if (n3 <= boxPlunder.equipmentRates[n4]) {
                Goods goods;
                if (n3 % 4 == 0 && (goods = w.case().do(boxPlunder.minLevel, boxPlunder.maxLevel, n4)) != null) {
                    return goods;
                }
                return w.case().if(boxPlunder.minLevel, boxPlunder.maxLevel, n4);
            }
            ++n4;
        }
        n4 = 0;
        while (n4 < boxPlunder.goodsIDTable.length) {
            if (n3 <= boxPlunder.extraGoodsRates[n4]) {
                return Goods.getGlobalGoods(boxPlunder.goodsIDTable[n4]);
            }
            ++n4;
        }
        return null;
    }

    private void do(h h2) {
        Hero hero = h2.r();
        int n2 = 0;
        int n3 = 0;
        while (n3 < hero.personalDepot.goodsList.length) {
            if (hero.personalDepot.goodsList[n3] != null && hero.personalDepot.goodsList[n3].dropable > 0) {
                l.a[n2++] = n3;
            }
            ++n3;
        }
        if (n2 <= 0) {
            return;
        }
        n3 = (int)(Math.random() * (double)n2);
        int n4 = a[n3];
        if (n4 >= 0) {
            Goods goods = hero.personalDepot.goodsList[n4];
            h2.long(n4);
            this.if.a(goods, 0, 0, hero.x, hero.y);
        }
    }

    public void a(h h2, e e2) {
        if (h2 == null || e2 == null) {
            return;
        }
        Hero hero = h2.r();
        Guild guild = e2.e();
        if (guild.placedSign == null) {
            return;
        }
        int n2 = guild.money / 2;
        int n3 = guild.reputation / 2;
        h2.new(n2);
        if (hero.joinedGuild != null) {
            hero.joinedGuild.reputation += n3;
            h2.J().a(p.new(hero.joinedGuild.reputation));
        }
        guild.money -= n2;
        guild.reputation -= n3;
        e2.a(p.if(guild));
        e2.a(p.new(guild.reputation));
        int n4 = guild.placedSign.x;
        int n5 = guild.placedSign.y;
        int n6 = 0;
        while (n6 < guild.goodsList.length) {
            if (guild.goodsList[n6] != null && Math.random() < (double)0.1f) {
                this.if.a(guild.goodsList[n6], 0, 0, n4, n5);
                e2.a(p.do(n6));
                guild.goodsList[n6] = null;
            }
            ++n6;
        }
    }
}

