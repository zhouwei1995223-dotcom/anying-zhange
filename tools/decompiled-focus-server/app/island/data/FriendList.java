/*
 * Decompiled with CFR 0.152.
 */
package app.island.data;

import app.island.GameObject;
import app.island.a;
import app.island.data.Shifu;
import app.island.data.Tudi;
import app.island.entity.Hero;
import daff.a.b;
import daff.a.e;
import daff.a.h;
import daff.a.i;

public class FriendList
extends GameObject {
    public String[] friends = new String[50];
    public transient int friendCount;
    public String[] enemies = new String[20];
    public transient int enemyCount;
    public String[] blacks = new String[20];
    public transient int blackCount;
    public Shifu master;
    public Tudi[] students = new Tudi[15];
    public transient int studentCount;
    private static /* synthetic */ Class class$app$island$data$Shifu;
    private static /* synthetic */ Class class$app$island$data$Tudi;

    public boolean isMaster(String string) {
        return this.master != null && this.master.name.equals(string);
    }

    public void addStudentCloseness(String string, int n2) {
        int n3 = 0;
        while (n3 < this.studentCount) {
            if (string.equals(this.students[n3].name)) {
                this.students[n3].closeness += n2;
                break;
            }
            ++n3;
        }
    }

    public void readFrom(e e2) {
        this.friendCount = e2.case();
        int n2 = 0;
        while (n2 < this.friendCount) {
            this.friends[n2] = e2.h();
            ++n2;
        }
        this.enemyCount = e2.case();
        n2 = 0;
        while (n2 < this.enemyCount) {
            this.enemies[n2] = e2.h();
            ++n2;
        }
        this.blackCount = e2.case();
        n2 = 0;
        while (n2 < this.blackCount) {
            this.blacks[n2] = e2.h();
            ++n2;
        }
        if (e2.c()) {
            this.master = new Shifu();
            this.master.readFrom(e2);
        }
        this.studentCount = e2.for();
        n2 = 0;
        while (n2 < this.studentCount) {
            this.students[n2] = new Tudi();
            this.students[n2].readFrom(e2);
            ++n2;
        }
    }

    public void writeTo(e e2) {
        e2.a(this.friendCount);
        int n2 = 0;
        while (n2 < this.friendCount) {
            e2.a(this.friends[n2]);
            ++n2;
        }
        e2.a(this.enemyCount);
        n2 = 0;
        while (n2 < this.enemyCount) {
            e2.a(this.enemies[n2]);
            ++n2;
        }
        e2.a(this.blackCount);
        n2 = 0;
        while (n2 < this.blackCount) {
            e2.a(this.blacks[n2]);
            ++n2;
        }
        e2.a(this.master != null);
        if (this.master != null) {
            this.master.writeTo(e2);
        }
        e2.a(this.studentCount);
        n2 = 0;
        while (n2 < this.studentCount) {
            this.students[n2].writeTo(e2);
            ++n2;
        }
    }

    public void addBlack(String string) {
        if (this.blackCount < this.blacks.length) {
            this.blacks[this.blackCount++] = string;
        }
    }

    public Tudi getStudent(String string) {
        int n2 = 0;
        while (n2 < this.studentCount) {
            if (string.equals(this.students[n2].name)) {
                return this.students[n2];
            }
            ++n2;
        }
        return null;
    }

    public i getAttributeValue(String string) {
        if (string.equals("friends")) {
            i i2 = new i(string);
            int n2 = 0;
            while (n2 < this.friendCount) {
                i i3 = new i(String.valueOf(n2));
                i3.do(this.friends[n2]);
                i2.a(i3);
                ++n2;
            }
            return i2;
        }
        if (string.equals("enemies")) {
            i i4 = new i(string);
            int n3 = 0;
            while (n3 < this.enemyCount) {
                i i5 = new i(String.valueOf(n3));
                i5.do(this.enemies[n3]);
                i4.a(i5);
                ++n3;
            }
            return i4;
        }
        if (string.equals("blacks")) {
            i i6 = new i(string);
            int n4 = 0;
            while (n4 < this.blackCount) {
                i i7 = new i(String.valueOf(n4));
                i7.do(this.blacks[n4]);
                i6.a(i7);
                ++n4;
            }
            return i6;
        }
        if (string.equals("master")) {
            i i8 = a.a().a(this.master);
            if (i8 != null) {
                i8.if(string);
            }
            return i8;
        }
        if (string.equals("students")) {
            i i9 = new i(string);
            int n5 = 0;
            while (n5 < this.studentCount) {
                i i10 = a.a().a(this.students[n5]);
                if (i10 != null) {
                    i10.if(String.valueOf(n5));
                    i9.a(i10);
                }
                ++n5;
            }
            return i9;
        }
        return super.getAttributeValue(string);
    }

    public boolean setAttributeValue(String string, i i2) {
        if (string.equals("friends")) {
            h h2 = i2.int();
            int n2 = 0;
            while (h2 != null && n2 < h2.for()) {
                i i3 = (i)h2.if(n2);
                this.friends[this.friendCount++] = i3.for();
                ++n2;
            }
            return true;
        }
        if (string.equals("enemies")) {
            h h3 = i2.int();
            int n3 = 0;
            while (h3 != null && n3 < h3.for()) {
                i i4 = (i)h3.if(n3);
                this.enemies[this.enemyCount++] = i4.for();
                ++n3;
            }
            return true;
        }
        if (string.equals("blacks")) {
            h h4 = i2.int();
            int n4 = 0;
            while (h4 != null && n4 < h4.for()) {
                i i5 = (i)h4.if(n4);
                this.blacks[this.blackCount++] = i5.for();
                ++n4;
            }
            return true;
        }
        if (string.equals("master")) {
            h h5 = i2.int();
            if (h5 != null) {
                i2.if((class$app$island$data$Shifu != null ? class$app$island$data$Shifu : (class$app$island$data$Shifu = FriendList.class$("app.island.data.Shifu"))).getName());
                this.master = (Shifu)a.a().a(i2);
            }
            return true;
        }
        if (string.equals("students")) {
            h h6 = i2.int();
            int n5 = 0;
            while (h6 != null && n5 < h6.for()) {
                i i6 = (i)h6.if(n5);
                i6.if((class$app$island$data$Tudi != null ? class$app$island$data$Tudi : FriendList.class$("app.island.data.Tudi")).getName());
                this.students[this.studentCount] = (Tudi)a.a().a(i6);
                if (this.students[this.studentCount] != null) {
                    ++this.studentCount;
                }
                ++n5;
            }
            return true;
        }
        return super.setAttributeValue(string, i2);
    }

    public void removeStudent(String string) {
        if (string == null || string.length() < 1) {
            return;
        }
        int n2 = 0;
        while (n2 < this.studentCount) {
            if (string.equals(this.students[n2].name)) {
                this.studentCount += -1;
                int n3 = n2;
                while (n3 < this.studentCount) {
                    this.students[n3] = this.students[n3 + 1];
                    ++n3;
                }
                this.students[this.studentCount] = null;
                break;
            }
            ++n2;
        }
    }

    public void removeFriend(String string) {
        int n2 = 0;
        while (n2 < this.friendCount) {
            if (this.friends[n2].equals(string)) {
                this.friendCount += -1;
                int n3 = n2;
                while (n3 < this.friendCount) {
                    this.friends[n3] = this.friends[n3 + 1];
                    ++n3;
                }
                this.friends[this.friendCount] = null;
                break;
            }
            ++n2;
        }
    }

    public boolean hasFriend(String string) {
        int n2 = 0;
        while (n2 < this.friendCount) {
            if (this.friends[n2].equals(string)) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    public boolean hasStudent(String string) {
        if (string == null || string.length() < 1) {
            return false;
        }
        int n2 = 0;
        while (n2 < this.studentCount) {
            if (string.equals(this.students[n2].name)) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    public void addMaster(Hero hero) {
        this.master = new Shifu();
        this.master.name = hero.name;
        this.master.joinTime = b.a();
        this.master.race = hero.race;
        this.master.level = hero.level;
        this.master.turns = hero.turns;
    }

    public void addStudent(Hero hero) {
        Tudi tudi = new Tudi();
        tudi.name = hero.name;
        tudi.joinTime = b.a();
        tudi.race = hero.race;
        tudi.level = hero.level;
        tudi.turns = hero.turns;
        this.addStudent(tudi);
    }

    public void addFriend(String string) {
        if (this.friendCount < this.friends.length) {
            this.friends[this.friendCount++] = string;
        }
    }

    public void addStudent(Tudi tudi) {
        if (tudi == null) {
            return;
        }
        int n2 = 0;
        while (n2 < this.studentCount) {
            if (tudi.name.equals(this.students[n2].name)) {
                return;
            }
            ++n2;
        }
        this.students[this.studentCount++] = tudi;
    }

    public void removeEnemy(String string) {
        int n2 = 0;
        while (n2 < this.enemyCount) {
            if (this.enemies[n2].equals(string)) {
                this.enemyCount += -1;
                int n3 = n2;
                while (n3 < this.enemyCount) {
                    this.enemies[n3] = this.enemies[n3 + 1];
                    ++n3;
                }
                this.enemies[this.enemyCount] = null;
                break;
            }
            ++n2;
        }
    }

    public boolean hasEnemy(String string) {
        int n2 = 0;
        while (n2 < this.enemyCount) {
            if (this.enemies[n2].equals(string)) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    private static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError(classNotFoundException.getMessage());
        }
    }

    public void removeBlack(String string) {
        int n2 = 0;
        while (n2 < this.blackCount) {
            if (this.blacks[n2].equals(string)) {
                this.blackCount += -1;
                int n3 = n2;
                while (n3 < this.blackCount) {
                    this.blacks[n3] = this.blacks[n3 + 1];
                    ++n3;
                }
                this.blacks[this.blackCount] = null;
                break;
            }
            ++n2;
        }
    }

    public boolean hasBlack(String string) {
        int n2 = 0;
        while (n2 < this.blackCount) {
            if (this.blacks[n2].equals(string)) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    public void addEnemy(String string) {
        if (this.enemyCount < this.enemies.length) {
            this.enemies[this.enemyCount++] = string;
        }
    }
}

