/*
 * Decompiled with CFR 0.152.
 */
package app.island.entity;

import app.island.GameObject;
import app.island.data.Goods;
import app.island.entity.Player;
import app.island.entity.Sign;
import daff.a.b;
import daff.a.e;
import daff.a.h;
import daff.a.i;

public class Guild
extends GameObject {
    public static final String[] POS_NAMES = new String[]{"\u4f1a\u5458", "\u526f\u4f1a\u957f", "\u4f1a\u957f", "\u5143\u8001", "\u5927\u81e3", "\u5143\u5e05", "\u5de6\u62a4\u6cd5", "\u53f3\u62a4\u6cd5", "\u5802\u4e3b", "\u957f\u8001", "\u5c06\u519b", "\u5b88\u62a4\u9a91\u58eb", "\u7981\u536b\u519b", "\u5a01\u9547\u5c06\u519b", "\u4fef\u5367\u6491", "\u6d6a\u5b50", "\u6dd1\u5973", "\u8c6a\u4fa0", "\u5973\u9b54\u5934", "\u5c71\u5927\u738b", "\u5149\u7984\u52cb", "\u4f2f\u7235", "\u4eb2\u738b", "\u5c0f\u5f3a", "\u5927\u5f3a", "\u957f\u6c5f7\u53f7", "\u529f\u592b\u4e4b\u738b", "\u559c\u5267\u4e4b\u738b", "\u7834\u574f\u4e4b\u738b", "\u5f00\u5fc3\u679c", "\u5927\u574f\u86cb", "\u5c0f\u751c\u751c", "\u5c0f\u56e7\u56e7"};
    public static final int[] LEVEL_COLORS = new int[]{-1, -1, -13318080, -15629579, -7864065, -752332, -1186560, -65536, -1, -1};
    public static final int MAX_LEVEL = 5;
    public int icon;
    public int level = 1;
    public int reputation;
    public int createdTime;
    public String leader;
    public int acceptMethod = 2;
    public String introduction = "";
    public String notice = "";
    public transient int memberCapacity = 20;
    public h memberList;
    public int money;
    public transient int storeCapacity = 50;
    public Goods[] goodsList;
    public int cityID;
    public transient String cityName = "";
    public int cityTakeTime;
    public int cityTaxRate = 5;
    public String cityEnterTip = "";
    public int taxedMoney;
    public int taxedTreasure;
    public int tmpTreasure;
    public transient int[] enemies = new int[5];
    public Sign placedSign;
    public int challengerID;
    public transient Guild battleGuild;
    public int battleTime;
    public transient Object attachment;
    public transient int onlineMemberCount;
    public transient boolean dataChanged;
    public transient boolean deleted;

    public GuildMember getMember(String string) {
        int n2 = this.memberList.for();
        int n3 = 0;
        while (n3 < n2) {
            GuildMember guildMember = (GuildMember)this.memberList.if(n3);
            if (guildMember.name.equals(string)) {
                return guildMember;
            }
            ++n3;
        }
        return null;
    }

    public void readFrom(e e2) {
        this.init();
        super.readFrom(e2);
        this.icon = e2.for();
        this.level = e2.for();
        this.createdTime = e2.i();
        this.cityID = e2.i();
        this.reputation = e2.i();
        this.leader = e2.h();
        this.introduction = e2.h();
        this.notice = e2.h();
        this.memberCapacity = e2.case();
        int n2 = e2.case();
        int n3 = 0;
        while (n3 < n2) {
            GuildMember guildMember = new GuildMember();
            guildMember.name = e2.h();
            guildMember.position = e2.for();
            guildMember.contribution = e2.i();
            guildMember.race = e2.for();
            guildMember.turns = e2.for();
            guildMember.level = e2.for();
            guildMember.online = e2.c();
            this.memberList.if(guildMember);
            ++n3;
        }
        this.money = e2.i();
        this.storeCapacity = e2.for();
        n3 = 0;
        while (n3 < this.storeCapacity) {
            int n4 = e2.case();
            if (n4 >= 0) {
                this.goodsList[n3] = Goods.createGoodsByType(n4);
                this.goodsList[n3].readFrom(e2);
            }
            ++n3;
        }
        this.cityID = e2.i();
        if (this.cityID > 0) {
            this.cityTakeTime = e2.i();
            this.cityTaxRate = e2.for();
            this.cityEnterTip = e2.h();
            this.taxedMoney = e2.i();
            this.taxedTreasure = e2.i();
        }
    }

    public void writeTo(e e2) {
        super.writeTo(e2);
        e2.a(this.icon);
        e2.a(this.level);
        e2.char(this.createdTime);
        e2.char(this.cityID);
        e2.char(this.reputation);
        e2.a(this.leader);
        e2.a(this.introduction);
        e2.a(this.notice);
        e2.a(this.memberCapacity);
        int n2 = this.memberList.for();
        e2.a(n2);
        int n3 = 0;
        while (n3 < n2) {
            GuildMember guildMember = (GuildMember)this.memberList.if(n3);
            e2.a(guildMember.name);
            e2.a(guildMember.position);
            e2.char(guildMember.contribution);
            e2.a(guildMember.race);
            e2.a(guildMember.turns);
            e2.a(guildMember.level);
            e2.a(guildMember.online);
            ++n3;
        }
        e2.char(this.money);
        if (this.storeCapacity >= this.goodsList.length) {
            this.storeCapacity = this.goodsList.length;
        }
        e2.a(this.storeCapacity);
        n3 = 0;
        while (n3 < this.storeCapacity) {
            if (this.goodsList[n3] != null) {
                e2.a(this.goodsList[n3].goodsType);
                this.goodsList[n3].writeTo(e2);
            } else {
                e2.a(-1);
            }
            ++n3;
        }
        e2.char(this.cityID);
        if (this.cityID > 0) {
            e2.char(this.cityTakeTime);
            e2.a(this.cityTaxRate);
            e2.a(this.cityEnterTip);
            e2.char(this.taxedMoney);
            e2.char(this.taxedTreasure);
        }
    }

    public i getAttributeValue(String string) {
        if (string.equals("memberList")) {
            i i2 = new i(string);
            int n2 = this.memberList.for();
            int n3 = 0;
            while (n3 < n2) {
                GuildMember guildMember = (GuildMember)this.memberList.if(n3);
                i i3 = new i(String.valueOf(guildMember.position));
                i3.do(guildMember.name + ";" + (guildMember.turns * 10000 + guildMember.race * 1000 + guildMember.level) + ";" + guildMember.contribution);
                i2.a(i3);
                ++n3;
            }
            return i2;
        }
        if (string.equals("goodsList")) {
            i i4 = new i(string);
            int n4 = 0;
            while (n4 < this.storeCapacity && n4 < this.goodsList.length) {
                if (this.goodsList[n4] != null) {
                    i i5 = new i(String.valueOf(n4));
                    String string2 = this.goodsList[n4].getExtraInfo();
                    if (string2.length() > 0) {
                        i5.do(this.goodsList[n4].id + "," + string2);
                    } else {
                        i5.do(String.valueOf(this.goodsList[n4].id));
                    }
                    i4.a(i5);
                }
                ++n4;
            }
            return i4;
        }
        if (string.equals("placedSign")) {
            i i6 = new i(string);
            if (this.placedSign != null) {
                i6.do(this.placedSign.sceneID + "," + this.placedSign.image + "," + this.placedSign.stateID + "," + this.placedSign.x + "," + this.placedSign.y);
            }
            return i6;
        }
        return super.getAttributeValue(string);
    }

    public boolean setAttributeValue(String string, i i2) {
        if (string.equals("memberList")) {
            this.memberList = new h(100);
            h h2 = i2.int();
            if (h2 != null) {
                int n2 = h2.for();
                int n3 = 0;
                while (n3 < n2) {
                    i i3 = (i)h2.if(n3);
                    GuildMember guildMember = new GuildMember();
                    guildMember.position = Integer.parseInt(i3.do());
                    String[] stringArray = b.a(i3.for(), ";");
                    guildMember.name = stringArray[0];
                    int n4 = Integer.parseInt(stringArray[1]);
                    guildMember.level = n4 % 1000;
                    guildMember.race = n4 / 1000 % 10;
                    guildMember.turns = n4 / 10000;
                    guildMember.contribution = Integer.parseInt(stringArray[2]);
                    this.memberList.if(guildMember);
                    ++n3;
                }
            }
            return true;
        }
        if (string.equals("goodsList")) {
            this.goodsList = new Goods[300];
            h h3 = i2.int();
            if (h3 != null) {
                int n5 = h3.for();
                int n6 = 0;
                while (n6 < n5 && n6 < this.goodsList.length) {
                    int n7;
                    Goods goods;
                    i i4 = (i)h3.if(n6);
                    String string2 = i4.for();
                    String string3 = "";
                    int n8 = string2.indexOf(44);
                    if (n8 > 0) {
                        string3 = string2.substring(n8 + 1);
                        string2 = string2.substring(0, n8);
                    }
                    if ((goods = Goods.getGlobalGoods(Integer.parseInt(string2))) != null) {
                        goods = (Goods)GameObject.cloneObject(goods);
                        goods.parseExtrInfo(string3);
                    }
                    if ((n7 = Integer.parseInt(i4.do())) < this.goodsList.length) {
                        this.goodsList[n7] = goods;
                    }
                    ++n6;
                }
            }
            return true;
        }
        if (string.equals("placedSign")) {
            String string4 = i2.for();
            if (string4.length() > 1) {
                String[] stringArray = b.a(string4, ",");
                this.placedSign = new Sign();
                this.placedSign.targetGuild = this;
                this.placedSign.sceneID = Integer.parseInt(stringArray[0]);
                this.placedSign.image = Integer.parseInt(stringArray[1]);
                this.placedSign.stateID = Integer.parseInt(stringArray[2]);
                this.placedSign.x = Integer.parseInt(stringArray[3]);
                this.placedSign.y = Integer.parseInt(stringArray[4]);
            }
            return true;
        }
        return super.setAttributeValue(string, i2);
    }

    public int getGoodsCount() {
        int n2 = 0;
        int n3 = 0;
        while (n3 < this.storeCapacity) {
            if (this.goodsList[n3] != null) {
                ++n2;
            }
            ++n3;
        }
        return n2;
    }

    public GuildMember removeMember(String string) {
        int n2 = this.memberList.for();
        int n3 = 0;
        while (n3 < n2) {
            GuildMember guildMember = (GuildMember)this.memberList.if(n3);
            if (guildMember.name.equals(string)) {
                this.memberList.a(n3);
                return guildMember;
            }
            ++n3;
        }
        return null;
    }

    public void removeEnemy(int n2) {
        int n3 = 0;
        while (n3 < this.enemies.length) {
            if (this.enemies[n3] == n2) {
                this.enemies[n3] = 0;
                break;
            }
            ++n3;
        }
    }

    public boolean isEnemy(int n2) {
        int n3 = 0;
        while (n3 < this.enemies.length) {
            if (this.enemies[n3] == n2) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    public int getNextFreeGoodsPos() {
        int n2 = 0;
        while (n2 < this.storeCapacity) {
            if (this.goodsList[n2] == null) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    public GuildMember addMember(Player player) {
        return this.addMember(player, 0);
    }

    public GuildMember addMember(Player player, int n2) {
        return this.addMember(player.name, player.race, player.turns, player.level, n2);
    }

    public GuildMember addMember(String string, int n2, int n3, int n4, int n5) {
        GuildMember guildMember = this.getMember(string);
        if (guildMember == null) {
            guildMember = new GuildMember();
            guildMember.name = string;
            this.memberList.if(guildMember);
        }
        guildMember.race = n2;
        guildMember.turns = n3;
        guildMember.level = n4;
        guildMember.position = n5;
        return guildMember;
    }

    public void init() {
        this.level = Math.min(this.level, 5);
        this.memberCapacity = this.level * 20;
        this.storeCapacity = Math.min(this.level * 50, 250);
        if (this.memberList == null) {
            this.memberList = new h(100);
        }
        if (this.goodsList == null) {
            this.goodsList = new Goods[300];
        }
    }

    public void addEnemy(int n2) {
        int n3 = 0;
        while (n3 < this.enemies.length) {
            if (this.enemies[n3] == 0 || this.enemies[n3] == n2) {
                this.enemies[n3] = n2;
                break;
            }
            ++n3;
        }
    }

    public static class GuildMember {
        public String name;
        public int position;
        public int contribution;
        public int race;
        public int turns;
        public int level;
        public boolean online;
    }
}

