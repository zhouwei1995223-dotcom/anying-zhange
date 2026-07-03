/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.data;

import app.island.GameObject;
import app.island.entity.Hero;
import daff.a.b;
import daff.a.e;
import daff.a.i;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class HeroRankData
extends GameObject {
    public static final int TOTAL_TOP_COUNT = 20;
    public static final int RANK_TYPE_MONEY = 1;
    public static final int RANK_TYPE_LEVEL = 2;
    public static final int RANK_TYPE_HONNOR = 3;
    public static final int RANK_TYPE_PK = 4;
    public static final int RANK_TYPE_WALKING = 5;
    public static final int RANK_TYPE_ONLINETIME = 6;
    public static final int RANK_TYPE_ELF_LEVEL = 7;
    public static final int RANK_TYPE_HUMEN_LEVEL = 8;
    public static final int RANK_TYPE_ORC_LEVEL = 9;
    public static final int RANK_TYPE_ARENA = 10;
    public static final int RANK_TYPE_ANSWER_QUESTION = 11;
    public static final int RANK_TYPE_OPEN_BOX = 12;
    public static final int RANK_TYPE_REFINES = 13;
    public static final int RANK_TYPE_TRAINING = 14;
    public static final int RANK_TYPE_CONSUMPTION = 15;
    public static final int RANK_TYPE_PAYMENT = 16;
    public int type = 1;
    public int[] ids = new int[20];
    public String[] names = new String[20];
    public int[] levels = new int[20];
    public int[] values = new int[20];
    public int count;
    public transient boolean changed;

    public void writeTo(e e2) {
        e2.a(this.type);
        e2.a(this.count);
        int n2 = 0;
        while (n2 < this.count) {
            e2.a(this.names[n2]);
            e2.a(this.levels[n2]);
            e2.char(this.values[n2]);
            ++n2;
        }
    }

    public static final int getRankTypeAmount() {
        return 16;
    }

    public i getAttributeValue(String string) {
        if (string.equals("ids")) {
            StringBuffer stringBuffer = new StringBuffer(this.count * 10);
            int n2 = 0;
            while (n2 < this.count) {
                stringBuffer.append(this.ids[n2]);
                stringBuffer.append(',');
                ++n2;
            }
            i i2 = new i(string);
            i2.do(stringBuffer.toString());
            return i2;
        }
        if (string.equals("names")) {
            StringBuffer stringBuffer = new StringBuffer(this.count * 20);
            int n3 = 0;
            while (n3 < this.count) {
                stringBuffer.append(this.names[n3]);
                stringBuffer.append(',');
                ++n3;
            }
            i i3 = new i(string);
            i3.do(stringBuffer.toString());
            return i3;
        }
        if (string.equals("levels")) {
            StringBuffer stringBuffer = new StringBuffer(this.count * 4);
            int n4 = 0;
            while (n4 < this.count) {
                stringBuffer.append(this.levels[n4]);
                stringBuffer.append(',');
                ++n4;
            }
            i i4 = new i(string);
            i4.do(stringBuffer.toString());
            return i4;
        }
        if (string.equals("values")) {
            StringBuffer stringBuffer = new StringBuffer(this.count * 10);
            int n5 = 0;
            while (n5 < this.count) {
                stringBuffer.append(this.values[n5]);
                stringBuffer.append(',');
                ++n5;
            }
            i i5 = new i(string);
            i5.do(stringBuffer.toString());
            return i5;
        }
        return super.getAttributeValue(string);
    }

    public boolean setAttributeValue(String string, String string2) {
        if (string.equals("ids")) {
            String[] stringArray = b.a(string2, ",");
            int n2 = 0;
            while (n2 < stringArray.length) {
                if (stringArray[n2].length() <= 0) break;
                this.ids[n2] = Integer.parseInt(stringArray[n2]);
                ++n2;
            }
            return true;
        }
        if (string.equals("names")) {
            String[] stringArray = b.a(string2, ",");
            int n3 = 0;
            while (n3 < stringArray.length) {
                if (stringArray[n3].length() <= 0) break;
                this.names[n3] = stringArray[n3];
                ++n3;
            }
            return true;
        }
        if (string.equals("levels")) {
            String[] stringArray = b.a(string2, ",");
            int n4 = 0;
            while (n4 < stringArray.length) {
                if (stringArray[n4].length() <= 0) break;
                this.levels[n4] = Integer.parseInt(stringArray[n4]);
                ++n4;
            }
            return true;
        }
        if (string.equals("values")) {
            String[] stringArray = b.a(string2, ",");
            int n5 = 0;
            while (n5 < stringArray.length) {
                if (stringArray[n5].length() <= 0) break;
                this.values[n5] = Integer.parseInt(stringArray[n5]);
                ++n5;
            }
            return true;
        }
        return super.setAttributeValue(string, string2);
    }

    public void removeHero(int n2) {
        int n3 = -1;
        int n4 = 0;
        while (n4 < this.count) {
            if (this.ids[n4] == n2) {
                n3 = n4;
                break;
            }
            ++n4;
        }
        if (n3 < 0) {
            return;
        }
        this.count += -1;
        n4 = n3;
        while (n4 < this.count) {
            this.ids[n4] = this.ids[n4 + 1];
            this.names[n4] = this.names[n4 + 1];
            this.levels[n4] = this.levels[n4 + 1];
            this.values[n4] = this.values[n4 + 1];
            ++n4;
        }
    }

    private void a(int n2) {
        int n3 = 0;
        while (n3 < n2) {
            if (this.values[n3] < this.values[n2]) {
                int n4 = this.ids[n2];
                String string = this.names[n2];
                int n5 = this.levels[n2];
                int n6 = this.values[n2];
                int n7 = n2;
                while (n7 > n3) {
                    this.ids[n7] = this.ids[n7 - 1];
                    this.names[n7] = this.names[n7 - 1];
                    this.levels[n7] = this.levels[n7 - 1];
                    this.values[n7] = this.values[n7 - 1];
                    --n7;
                }
                this.ids[n3] = n4;
                this.names[n3] = string;
                this.levels[n3] = n5;
                this.values[n3] = n6;
                break;
            }
            ++n3;
        }
    }

    public void clearData() {
        this.count = 0;
    }

    private final int a(Hero hero) {
        switch (this.type) {
            case 1: {
                return hero.personalDepot.money;
            }
            case 2: {
                return hero.level | hero.turns << 16;
            }
            case 3: {
                return hero.monsterKills;
            }
            case 4: {
                return hero.pkValue;
            }
            case 5: {
                return hero.motionCount;
            }
            case 6: {
                return hero.onlineTime;
            }
            case 7: {
                if (hero.race == 0) {
                    return hero.level | hero.turns << 16;
                }
                return 0;
            }
            case 8: {
                if (hero.race == 1) {
                    return hero.level | hero.turns << 16;
                }
                return 0;
            }
            case 9: {
                if (hero.race == 2) {
                    return hero.level | hero.turns << 16;
                }
                return 0;
            }
            case 10: {
                return hero.arenaScores;
            }
            case 11: {
                return hero.answerTimes;
            }
            case 12: {
                return hero.openBoxTimes;
            }
            case 13: {
                return hero.refineTimes;
            }
            case 14: {
                return hero.trainingTimes;
            }
            case 15: {
                return hero.consumedTreasure;
            }
            case 16: {
                return hero.payedTreasure;
            }
        }
        return -1;
    }

    private void if(int n2) {
        int n3 = this.count - 1;
        while (n3 > n2) {
            if (this.values[n3] > this.values[n2]) {
                int n4 = this.ids[n2];
                String string = this.names[n2];
                int n5 = this.levels[n2];
                int n6 = this.values[n2];
                int n7 = n2;
                while (n7 < n3) {
                    this.ids[n7] = this.ids[n7 + 1];
                    this.names[n7] = this.names[n7 + 1];
                    this.levels[n7] = this.levels[n7 + 1];
                    this.values[n7] = this.values[n7 + 1];
                    ++n7;
                }
                this.ids[n3] = n4;
                this.names[n3] = string;
                this.levels[n3] = n5;
                this.values[n3] = n6;
                break;
            }
            --n3;
        }
    }

    public int getRankValue(int n2) {
        int n3 = 0;
        while (n3 < this.ids.length) {
            if (this.ids[n3] == n2) {
                return this.values[n3];
            }
            ++n3;
        }
        return -1;
    }

    private boolean a(Hero hero, int n2) {
        int n3 = -1;
        int n4 = 0;
        while (n4 < this.count) {
            if (this.ids[n4] == hero.id) {
                n3 = n4;
                this.names[n4] = hero.name;
                this.levels[n4] = hero.level;
                this.values[n4] = n2;
                break;
            }
            ++n4;
        }
        if (n3 < 0) {
            return false;
        }
        if (this.count != 1) {
            if (n3 == 0) {
                if (this.values[n3] < this.values[n3 + 1]) {
                    this.if(n3);
                }
            } else if (n3 == this.count - 1) {
                if (this.values[n3 - 1] < this.values[n3]) {
                    this.a(n3);
                }
            } else if (this.values[n3] < this.values[n3 + 1]) {
                this.if(n3);
            } else if (this.values[n3 - 1] < this.values[n3]) {
                this.a(n3);
            }
        }
        return true;
    }

    public void rankHero(Hero hero) {
        if (hero.rank == 0) {
            return;
        }
        int n2 = this.a(hero);
        if (this.a(hero, n2)) {
            return;
        }
        if (n2 <= 0) {
            return;
        }
        int n3 = 0;
        while (n3 < this.count) {
            if (n2 > this.values[n3]) {
                if (this.count < 20) {
                    ++this.count;
                }
                int n4 = this.count - 1;
                while (n4 > n3) {
                    this.ids[n4] = this.ids[n4 - 1];
                    this.names[n4] = this.names[n4 - 1];
                    this.levels[n4] = this.levels[n4 - 1];
                    this.values[n4] = this.values[n4 - 1];
                    --n4;
                }
                this.ids[n3] = hero.id;
                this.names[n3] = hero.name;
                this.levels[n3] = hero.level;
                this.values[n3] = n2;
                return;
            }
            ++n3;
        }
        if (this.count < 20) {
            this.ids[this.count] = hero.id;
            this.names[this.count] = hero.name;
            this.levels[this.count] = hero.level;
            this.values[this.count] = n2;
            ++this.count;
            this.changed = true;
        }
    }
}

