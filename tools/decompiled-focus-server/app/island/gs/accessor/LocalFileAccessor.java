/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.accessor;

import app.island.a;
import app.island.data.Depot;
import app.island.data.FriendList;
import app.island.data.HeroTaskList;
import app.island.data.Shortcuts;
import app.island.data.SpellList;
import app.island.data.Store;
import app.island.entity.Guild;
import app.island.entity.Hero;
import app.island.entity.User;
import app.island.gs.c;
import daff.a.b;
import daff.a.h;
import daff.a.i;
import daff.a.n;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class LocalFileAccessor
extends c {
    private int k;
    private int i;
    private int g;
    private int j;
    String h = "";

    public void deleteGuild(Guild guild) {
        guild.deleted = true;
        this.new.a(new Integer(guild.id));
        this.for.a(guild.name);
        File file = new File("data/guild/" + guild.id + ".txt");
        file.delete();
    }

    public void loadUser(String string, String string2, String string3, c.c c2) {
        if (this.h.length() > 1) {
            UserCheckJob userCheckJob = new UserCheckJob(string, string2, string3, c2);
            this.int.a(userCheckJob);
            return;
        }
        File file = new File("data/user/" + string + ".txt");
        this.a(file, string, string2, c2);
    }

    public void stop() {
        if (this.int != null) {
            this.int.case();
        }
    }

    private int char() {
        return ++this.k;
    }

    public void saveServerLog(i i2) {
        String string = i2.toString();
        b.a("data/serverlogs/" + b.a() + ".txt", string.getBytes());
    }

    void a(boolean bl, String string, String string2, String string3, c.c c2) {
        File file = new File("data/user/" + string + ".txt");
        if (bl) {
            if (!file.exists()) {
                User user = new User();
                user.name = string;
                user.password = string2;
                user.adOwner = string3;
                user.id = this.char();
                user.store = new Store();
                user.dataChanged = true;
                this.saveUser(user, null);
                this.if.a((Object)string, (Object)user);
                ++this.byte;
            }
            this.a(file, string, null, c2);
        } else {
            this.a(file, string, string2, c2);
        }
    }

    public void createHero(String string, int n2, int n3, c.b b2) {
        byte[] byArray = string.getBytes();
        if (byArray.length < 4) {
            if (b2 != null) {
                b2.a(null, "\u89d2\u8272\u540d\u5b57\u957f\u5ea6\u4e0d\u80fd\u5c11\u4e8e4\u4e2a\u5b57\u8282\u6216\u4e24\u4e2a\u6c49\u5b57");
            }
            return;
        }
        if (byArray.length > 16) {
            if (b2 != null) {
                b2.a(null, "\u89d2\u8272\u540d\u5b57\u957f\u5ea6\u4e0d\u80fd\u5927\u4e8e16\u4e2a\u5b57\u8282\u62168\u4e2a\u6c49\u5b57");
            }
            return;
        }
        if (!this.byte(string)) {
            if (b2 != null) {
                b2.a(null, "\u89d2\u8272\u540d\u5b57\u4e2d\u542b\u6709\u975e\u6cd5\u5b57\u7b26");
            }
            return;
        }
        Hero hero = (Hero)this.try.for(string);
        if (hero != null) {
            if (b2 != null) {
                b2.a(null, "\u5df2\u7ecf\u5b58\u5728\u76f8\u540c\u540d\u5b57\u7684\u89d2\u8272");
            }
            return;
        }
        File file = new File("data/hero/" + string + ".txt");
        if (file.exists()) {
            if (b2 != null) {
                b2.a(null, "\u5df2\u7ecf\u5b58\u5728\u76f8\u540c\u540d\u5b57\u7684\u89d2\u8272");
            }
            return;
        }
        hero = new Hero();
        hero.id = this.case();
        hero.name = string;
        hero.race = n2;
        hero.sex = n3;
        hero.createdTime = b.a();
        hero.init();
        this.try.a((Object)string, (Object)hero);
        if (b2 != null) {
            b2.a(hero, "");
        }
        ++this.case;
    }

    private Guild do(int n2) {
        Integer n3 = new Integer(n2);
        Guild guild = (Guild)this.new.for(n3);
        return guild;
    }

    public void saveUser(User user, c.d d2) {
        if (this.int != null) {
            SaveUserJob saveUserJob = new SaveUserJob(user, d2);
            this.int.a(saveUserJob);
        } else {
            this.a(user, d2);
        }
    }

    void a(User user, c.d d2) {
        int n2 = 0;
        while (n2 < user.heroes.length) {
            if (user.heroes[n2] != null && user.heroes[n2].dataChanged) {
                this.a(user.heroes[n2]);
                user.heroes[n2].dataChanged = false;
            }
            ++n2;
        }
        i i2 = app.island.a.a().a(user);
        String string = i2.toString();
        b.a("data/user/" + user.name + ".txt", string.getBytes());
        i2 = app.island.a.a().a(user.store);
        string = i2.toString();
        b.a("data/store/" + user.name + ".txt", string.getBytes());
        user.dataChanged = false;
        if (d2 != null) {
            d2.a(true, "");
        }
    }

    private void a(Hero hero) {
        i i2 = app.island.a.a().a(hero);
        String string = i2.toString();
        byte[] byArray = string.getBytes();
        File file = new File("data/hero/" + hero.name + ".txt");
        b.a(file, byArray);
        hero.personalDepot.id = hero.id;
        hero.personalDepot.name = hero.name;
        i2 = app.island.a.a().a(hero.personalDepot);
        string = i2.toString();
        byArray = string.getBytes();
        file = new File("data/depot/" + hero.name + ".txt");
        b.a(file, byArray);
        hero.shortCuts.id = hero.id;
        hero.shortCuts.name = hero.name;
        i2 = app.island.a.a().a(hero.shortCuts);
        string = i2.toString();
        byArray = string.getBytes();
        file = new File("data/shortcut/" + hero.name + ".txt");
        b.a(file, byArray);
        hero.spellList.id = hero.id;
        hero.spellList.name = hero.name;
        i2 = app.island.a.a().a(hero.spellList);
        string = i2.toString();
        byArray = string.getBytes();
        file = new File("data/spell/" + hero.name + ".txt");
        b.a(file, byArray);
        hero.taskList.id = hero.id;
        hero.taskList.name = hero.name;
        i2 = app.island.a.a().a(hero.taskList);
        string = i2.toString();
        byArray = string.getBytes();
        file = new File("data/task/" + hero.name + ".txt");
        b.a(file, byArray);
        hero.friendList.id = hero.id;
        hero.friendList.name = hero.name;
        i2 = app.island.a.a().a(hero.friendList);
        string = i2.toString();
        byArray = string.getBytes();
        file = new File("data/friend/" + hero.name + ".txt");
        b.a(file, byArray);
        if (hero.joinedGuild != null && !hero.joinedGuild.deleted && hero.joinedGuild.onlineMemberCount <= 0 && hero.joinedGuild.dataChanged) {
            i2 = app.island.a.a().a(hero.joinedGuild);
            string = i2.toString();
            byArray = string.getBytes();
            file = new File("data/guild/" + hero.joinedGuild.id + ".txt");
            b.a(file, byArray);
            hero.joinedGuild.dataChanged = false;
        }
    }

    public void update() {
        byte[] byArray;
        String string;
        if (this.g != this.i) {
            string = String.valueOf(this.i);
            byArray = string.getBytes();
            b.a("data/hero/id.txt", byArray);
        }
        if (this.j != this.k) {
            string = String.valueOf(this.k);
            byArray = string.getBytes();
            b.a("data/user/id.txt", byArray);
        }
        this.g = this.i;
        this.j = this.k;
    }

    public void deleteHero(Hero hero) {
        this.try.a(hero.name);
        File file = new File("data/hero/" + hero.name + ".txt");
        if (file.exists()) {
            file.delete();
        }
        if (hero.joinedGuild != null && hero.joinedGuild.leader.equals(hero.name)) {
            this.deleteGuild(hero.joinedGuild);
        }
    }

    public void start() {
    }

    public void createGuild(int n2, String string, c.a a2) {
        Guild guild = (Guild)this.new.for(string);
        if (guild != null) {
            if (a2 != null) {
                a2.a(null, "\u76f8\u540c\u540d\u5b57\u7684\u516c\u4f1a\u5df2\u7ecf\u5b58\u5728\u4e86");
            }
            return;
        }
        guild = new Guild();
        guild.id = n2;
        guild.name = string;
        guild.createdTime = b.a();
        if (a2 != null) {
            a2.a(guild, "");
        }
    }

    public void createUser(String string, String string2, String string3, c.f f2) {
        if (string.length() < 4) {
            if (f2 != null) {
                f2.a(null, "\u5e10\u53f7\u540d\u79f0\u4e0d\u80fd\u5c0f\u4e8e4\u4e2a\u5b57\u7b26");
            }
            return;
        }
        if (string.length() > 16) {
            if (f2 != null) {
                f2.a(null, "\u5e10\u53f7\u540d\u79f0\u4e0d\u80fd\u5927\u4e8e16\u4e2a\u5b57\u7b26");
            }
            return;
        }
        if (!this.int(string)) {
            f2.a(null, "\u5e10\u53f7\u540d\u79f0\u542b\u6709\u975e\u6cd5\u5b57\u7b26");
            return;
        }
        if (string2.length() < 6) {
            if (f2 != null) {
                f2.a(null, "\u5bc6\u7801\u4e0d\u80fd\u5c11\u4e8e6\u4e2a\u5b57\u7b26");
            }
            return;
        }
        if (string2.length() > 20) {
            if (f2 != null) {
                f2.a(null, "\u5bc6\u7801\u4e0d\u80fd\u5927\u4e8e20\u4e2a\u5b57\u7b26");
            }
            return;
        }
        if (!this.try(string2)) {
            if (f2 != null) {
                f2.a(null, "\u5bc6\u7801\u4e2d\u542b\u6709\u975e\u6cd5\u5b57\u7b26");
            }
            return;
        }
        User user = (User)this.if.for(string);
        if (user != null) {
            if (f2 != null) {
                f2.a(null, "\u8be5\u5e10\u53f7\u5df2\u7ecf\u5b58\u5728\uff1a" + string);
            }
            return;
        }
        File file = new File("data/user/" + string + ".txt");
        if (file.exists()) {
            if (f2 != null) {
                f2.a(null, "\u8be5\u5e10\u53f7\u5df2\u7ecf\u5b58\u5728");
            }
            return;
        }
        user = new User();
        user.name = string;
        user.password = string2;
        user.adOwner = string3;
        user.id = this.char();
        user.store = new Store();
        user.dataChanged = true;
        this.if.a((Object)string, (Object)user);
        if (f2 != null) {
            f2.a(user, "");
        }
        ++this.byte;
    }

    private void a(File file, String string, String string2, c.c c2) {
        if (!file.exists()) {
            if (c2 != null) {
                c2.a(null, "\u4e0d\u5b58\u5728\u8be5\u5e10\u53f7\uff1a" + string);
            }
            return;
        }
        User user = (User)this.if.for(string);
        if (user == null) {
            byte[] byArray = b.a(file);
            String string3 = new String(byArray);
            i i2 = n.a().a(string3);
            user = (User)app.island.a.a().a(i2);
            if (user.id < 20000) {
                user.id = this.char();
            }
            if ((file = new File("data/store/" + string + ".txt")).exists()) {
                byArray = b.a(file);
                string3 = new String(byArray);
                i2 = n.a().a(string3);
                user.store = (Store)app.island.a.a().a(i2);
            } else {
                user.store = new Store();
                user.store.id = user.id;
                user.store.name = user.name;
            }
            int n2 = 0;
            while (n2 < user.heroNames.length) {
                if (user.heroNames[n2].length() > 0) {
                    user.heroes[n2] = this.long(user.heroNames[n2]);
                }
                ++n2;
            }
            user.compute();
            this.if.a((Object)string, (Object)user);
        }
        if (string2 != null) {
            boolean bl = false;
            bl = string2.length() == 32 && user.password.length() != 32 ? string2.equals(b.if(user.password)) : string2.equals(user.password);
            if (!bl) {
                if (c2 != null) {
                    c2.a(null, "\u5bc6\u7801\u9519\u8bef");
                }
                return;
            }
        }
        if (c2 != null) {
            c2.a(user, "");
        }
    }

    private int case() {
        return ++this.i;
    }

    public boolean checkUser(String string) {
        File file = new File("data/user/" + string + ".txt");
        return file.exists();
    }

    public h loadAllGuilds() {
        File file = new File("data/guild");
        if (!file.exists()) {
            return new h(0);
        }
        String[] stringArray = file.list();
        h h2 = new h(stringArray.length);
        int n2 = 0;
        while (n2 < stringArray.length) {
            if (stringArray[n2].endsWith(".txt")) {
                byte[] byArray = b.a(new File(file, stringArray[n2]));
                String string = new String(byArray);
                i i2 = n.a().a(string);
                Guild guild = (Guild)app.island.a.a().a(i2);
                guild.init();
                this.new.a((Object)new Integer(guild.id), (Object)guild);
                this.for.a((Object)guild.name, (Object)guild);
                h2.if(guild);
            }
            ++n2;
        }
        return h2;
    }

    public void init(i i2) throws Exception {
        i i3;
        Object object;
        this.k = 20000;
        this.i = 20000;
        byte[] byArray = b.new("data/user/id.txt");
        if (byArray != null) {
            object = new String(byArray);
            this.k = Integer.parseInt((String)object);
        }
        if ((byArray = b.new("data/hero/id.txt")) != null) {
            object = new String(byArray);
            this.i = Integer.parseInt((String)object);
        }
        this.g = this.i;
        this.j = this.k;
        object = new File("data/user");
        if (((File)object).exists()) {
            this.byte = ((File)object).list().length - 1;
        }
        if (((File)(object = new File("data/hero"))).exists()) {
            this.case = ((File)object).list().length - 1;
        }
        if ((i3 = i2.a("userCheckUrl")) != null) {
            this.h = i3.for();
        }
    }

    public void transferAccount(String string, String string2, int n2, c.e e2) {
        if (e2 != null) {
            e2.a(-1, "\u672c\u533a\u4e0d\u652f\u6301\u5145\u503c\u529f\u80fd");
        }
    }

    private Hero long(String string) {
        Hero hero = null;
        File file = new File("data/hero/" + string + ".txt");
        if (!file.exists()) {
            return null;
        }
        byte[] byArray = b.a(file);
        String string2 = new String(byArray);
        hero = (Hero)app.island.a.a().a(n.a().a(string2));
        hero.computeLevel();
        if (hero.id < 20000) {
            hero.id = this.case();
        }
        if ((file = new File("data/depot/" + string + ".txt")).exists()) {
            byArray = b.a(file);
            string2 = new String(byArray);
            hero.personalDepot = (Depot)app.island.a.a().a(n.a().a(string2));
        }
        hero.calculateProperties();
        file = new File("data/shortcut/" + string + ".txt");
        if (file.exists()) {
            byArray = b.a(file);
            string2 = new String(byArray);
            hero.shortCuts = (Shortcuts)app.island.a.a().a(n.a().a(string2));
        }
        if ((file = new File("data/spell/" + string + ".txt")).exists()) {
            byArray = b.a(file);
            string2 = new String(byArray);
            hero.spellList = (SpellList)app.island.a.a().a(n.a().a(string2));
        }
        if ((file = new File("data/task/" + string + ".txt")).exists()) {
            byArray = b.a(file);
            string2 = new String(byArray);
            hero.taskList = (HeroTaskList)app.island.a.a().a(n.a().a(string2));
        }
        if ((file = new File("data/friend/" + string + ".txt")).exists()) {
            byArray = b.a(file);
            string2 = new String(byArray);
            hero.friendList = (FriendList)app.island.a.a().a(n.a().a(string2));
        }
        if (hero.guildID > 0) {
            hero.joinedGuild = this.do(hero.guildID);
            if (hero.joinedGuild != null) {
                hero.guildID = hero.joinedGuild.id;
                hero.guildName = hero.joinedGuild.name;
                hero.guildIcon = hero.joinedGuild.icon;
            } else {
                hero.guildID = 0;
                hero.guildName = "";
            }
        } else {
            hero.guildName = "";
        }
        this.try.a((Object)string, (Object)hero);
        return hero;
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    private class UserCheckJob
    implements Runnable {
        private String for;
        private String a;
        private String if;
        private c.c do;

        UserCheckJob(String string, String string2, String string3, c.c c2) {
            LocalFileAccessor.this.getClass();
            this.for = string;
            this.a = string2;
            this.if = string3;
            this.do = c2;
        }

        public void run() {
            LocalFileAccessor localFileAccessor = LocalFileAccessor.this;
            String string = localFileAccessor.h + "user_account=" + URLEncoder.encode(this.for) + "&user_password=" + URLEncoder.encode(this.a);
            String string2 = "";
            boolean bl = true;
            String string3 = localFileAccessor.if(this.for);
            if (string3 != null) {
                if (!string3.equals(this.a)) {
                    string2 = "\u5bc6\u7801\u9519\u8bef";
                } else {
                    localFileAccessor.for(this.for);
                }
            } else {
                try {
                    URL uRL = new URL(string);
                    byte[] byArray = c.a(uRL);
                    String string4 = new String(byArray);
                    string4 = string4.trim();
                    if (!string4.equals("10")) {
                        if (string4.equals("103")) {
                            string2 = "\u6e38\u620f\u670d\u52a1\u5668\u88ab\u62d2\u7edd\u8bbf\u95ee\u6570\u636e\u5e93";
                        } else if (string4.equals("1101")) {
                            bl = false;
                        } else {
                            string2 = string4.equals("1102") ? "\u5bc6\u7801\u9519\u8bef" : "\u4e0d\u53ef\u9884\u77e5\u7684\u9519\u8bef:" + string4;
                        }
                    }
                }
                catch (IOException iOException) {
                    string2 = "network error\uff1a" + iOException.getClass().getName();
                }
            }
            if (string2.length() > 0) {
                this.do.a(null, string2);
            } else {
                localFileAccessor.a(bl, this.for, this.a, this.if, this.do);
            }
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    private class SaveUserJob
    implements Runnable {
        User a;
        c.d if;

        SaveUserJob(User user, c.d d2) {
            LocalFileAccessor.this.getClass();
            this.a = user;
            this.if = d2;
        }

        public void run() {
            LocalFileAccessor.this.a(this.a, this.if);
        }
    }
}

