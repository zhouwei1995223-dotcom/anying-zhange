/*
 * Decompiled with CFR 0.152.
 */
package app.island.entity;

import app.island.GameObject;
import app.island.data.Store;
import app.island.entity.Hero;
import daff.a.b;
import daff.a.e;
import daff.a.i;

public class User
extends GameObject {
    public String password = "";
    public String adOwner = "";
    public int[] heroIds = new int[3];
    public String[] heroNames = new String[]{"", "", ""};
    public int loginCount;
    public int treasure;
    public int earnedTreasure;
    public int payedTreasure;
    public int consumedTreasure;
    public String lastLoginIP = "";
    public transient int[] heroRaces = new int[3];
    public transient int[] heroSexes = new int[3];
    public transient int[] heroSuits = new int[3];
    public transient int[] heroLevels = new int[3];
    public transient int[] heroPasswords = new int[3];
    public transient Store store = new Store();
    public transient Hero[] heroes = new Hero[3];
    public transient int lockState = 0;
    public transient boolean online;
    public transient long loginTime;
    public transient long logoutTime;
    public transient boolean dataChanged;
    public transient int getDailyGiftDay;

    public void readFrom(e e2) {
        super.readFrom(e2);
        int n2 = 0;
        do {
            this.heroNames[n2] = e2.h();
            this.heroRaces[n2] = e2.case();
            this.heroSexes[n2] = e2.case();
            this.heroSuits[n2] = e2.for();
            this.heroLevels[n2] = e2.for();
            this.heroPasswords[n2] = e2.for();
        } while (++n2 < 3);
        this.treasure = e2.i();
        this.store.hasPassword = e2.c();
    }

    public void writeTo(e e2) {
        super.writeTo(e2);
        int n2 = 0;
        do {
            if (this.heroes[n2] != null) {
                e2.a(this.heroes[n2].name);
                e2.a(this.heroes[n2].race);
                e2.a(this.heroes[n2].sex);
                e2.a(this.heroes[n2].suit);
                e2.a(this.heroes[n2].level);
                e2.a(this.heroes[n2].password.length());
                continue;
            }
            e2.a("");
            e2.a(0);
            e2.a(0);
            e2.a(0);
            e2.a(0);
            e2.a(0);
        } while (++n2 < 3);
        e2.char(this.treasure);
        e2.a(this.store.password.length() > 0);
    }

    public i getAttributeValue(String string) {
        if (string.equals("heroIds")) {
            StringBuffer stringBuffer = new StringBuffer(64);
            int n2 = 0;
            while (n2 < this.heroIds.length) {
                if (this.heroIds[n2] != 0) {
                    stringBuffer.append(this.heroIds[n2]);
                }
                stringBuffer.append(',');
                ++n2;
            }
            i i2 = new i(string);
            i2.do(stringBuffer.toString());
            return i2;
        }
        if (string.equals("heroNames")) {
            StringBuffer stringBuffer = new StringBuffer(64);
            int n3 = 0;
            while (n3 < this.heroNames.length) {
                if (this.heroNames[n3] != null) {
                    stringBuffer.append(this.heroNames[n3]);
                }
                stringBuffer.append(',');
                ++n3;
            }
            i i3 = new i(string);
            i3.do(stringBuffer.toString());
            return i3;
        }
        return super.getAttributeValue(string);
    }

    public boolean setAttributeValue(String string, String string2) {
        if (string.equals("heroIds")) {
            String[] stringArray = b.a(string2, ",");
            int n2 = 0;
            while (n2 < this.heroIds.length) {
                if (stringArray[n2].length() > 0) {
                    this.heroIds[n2] = Integer.parseInt(stringArray[n2]);
                }
                ++n2;
            }
            return true;
        }
        if (string.equals("heroNames")) {
            String[] stringArray = b.a(string2, ",");
            int n3 = 0;
            while (n3 < this.heroNames.length) {
                this.heroNames[n3] = stringArray[n3];
                ++n3;
            }
            return true;
        }
        return super.setAttributeValue(string, string2);
    }

    public boolean hasHero(String string) {
        int n2 = 0;
        while (n2 < this.heroNames.length) {
            if (this.heroNames[n2].equals(string)) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    public boolean removeHero(String string) {
        int n2 = 0;
        while (n2 < this.heroNames.length) {
            if (this.heroNames[n2].equals(string)) {
                this.heroIds[n2] = 0;
                this.heroNames[n2] = "";
                this.heroes[n2] = null;
                return true;
            }
            ++n2;
        }
        return false;
    }

    public String toString() {
        return "user[name=" + this.name + ";password=" + this.password + "]";
    }

    public void addHero(Hero hero) {
        int n2 = 0;
        while (n2 < this.heroes.length) {
            if (this.heroes[n2] == null) {
                this.heroes[n2] = hero;
                this.heroIds[n2] = hero.id;
                this.heroNames[n2] = hero.name;
                hero.user = this;
                break;
            }
            ++n2;
        }
    }

    public void clearData() {
        this.store = null;
        this.heroes[2] = null;
        this.heroes[1] = null;
        this.heroes[0] = null;
    }

    public int getHeroCount() {
        int n2 = 0;
        int n3 = 0;
        while (n3 < this.heroes.length) {
            if (this.heroes[n3] != null) {
                ++n2;
            }
            ++n3;
        }
        return n2;
    }

    public void compute() {
        int n2 = 0;
        while (n2 < this.heroes.length) {
            if (this.heroes[n2] != null) {
                this.heroIds[n2] = this.heroes[n2].id;
                this.heroNames[n2] = this.heroes[n2].name;
                this.heroLevels[n2] = this.heroes[n2].level;
                this.heroes[n2].user = this;
            } else {
                this.heroIds[n2] = 0;
                this.heroNames[n2] = "";
            }
            ++n2;
        }
    }

    public Hero getHero(String string) {
        int n2 = 0;
        while (n2 < this.heroes.length) {
            if (this.heroes[n2] != null && this.heroes[n2].name.equals(string)) {
                return this.heroes[n2];
            }
            ++n2;
        }
        return null;
    }

    public void setHero(Hero hero) {
        int n2 = 0;
        while (n2 < this.heroNames.length) {
            if (this.heroIds[n2] == hero.id || this.heroNames[n2].equals(hero.name)) {
                hero.user = this;
                break;
            }
            ++n2;
        }
    }
}

