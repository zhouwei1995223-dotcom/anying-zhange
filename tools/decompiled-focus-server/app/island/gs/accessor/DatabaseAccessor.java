/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.accessor;

import app.island.GameObject;
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
import app.island.gs.ServerInfo;
import app.island.gs.c;
import daff.a.b;
import daff.a.h;
import daff.a.i;
import daff.a.n;
import daff.a.q;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class DatabaseAccessor
extends c {
    String b;
    String d;
    private String long;
    private String c;
    private String e = "";
    private String f = "";
    q else = new q(100);
    private Connection void;
    private Connection goto;

    public void deleteGuild(Guild guild) {
        guild.deleted = true;
        this.new.a(new Integer(guild.id));
        this.for.a(guild.name);
        GuildDeletionJob guildDeletionJob = new GuildDeletionJob(guild);
        this.int.a(guildDeletionJob);
    }

    public void stop() {
        try {
            this.void.close();
        }
        catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
    }

    void a(User user) {
        byte[] byArray = this.a((GameObject)user);
        byte[] byArray2 = this.a(user.store);
        try {
            byte[] byArray3;
            Hero hero;
            PreparedStatement preparedStatement = this.void.prepareStatement("update users set data=?,store=? where id=?");
            preparedStatement.setBytes(1, byArray);
            preparedStatement.setBytes(2, byArray2);
            preparedStatement.setInt(3, user.id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            preparedStatement = null;
            int n2 = 0;
            while (n2 < user.heroes.length) {
                hero = user.heroes[n2];
                if (hero != null && hero.dataChanged) {
                    if (preparedStatement == null) {
                        preparedStatement = this.void.prepareStatement("update heroes set data=?,depot=?,spells=?,shortcuts=?,friends=?,tasks=?,name=? where id=?");
                    }
                    byArray3 = this.a(hero);
                    byte[] byArray4 = this.a(hero.personalDepot);
                    byte[] byArray5 = this.a(hero.spellList);
                    byte[] byArray6 = this.a(hero.shortCuts);
                    byte[] byArray7 = this.a(hero.friendList);
                    byte[] byArray8 = this.a(hero.taskList);
                    preparedStatement.setBytes(1, byArray3);
                    preparedStatement.setBytes(2, byArray4);
                    preparedStatement.setBytes(3, byArray5);
                    preparedStatement.setBytes(4, byArray6);
                    preparedStatement.setBytes(5, byArray7);
                    preparedStatement.setBytes(6, byArray8);
                    preparedStatement.setString(7, daff.a.b.case(hero.name));
                    preparedStatement.setInt(8, user.heroes[n2].id);
                    preparedStatement.executeUpdate();
                }
                ++n2;
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            preparedStatement = null;
            n2 = 0;
            do {
                if ((hero = user.heroes[n2]) == null || !hero.dataChanged || hero.joinedGuild == null || hero.joinedGuild.deleted || !hero.joinedGuild.dataChanged) continue;
                if (preparedStatement == null) {
                    preparedStatement = this.void.prepareStatement("update guilds set name=?,data=? where id=?");
                }
                byArray3 = this.a(hero.joinedGuild);
                preparedStatement.setString(1, daff.a.b.case(hero.joinedGuild.name));
                preparedStatement.setBytes(2, byArray3);
                preparedStatement.setInt(3, hero.joinedGuild.id);
                preparedStatement.executeUpdate();
                hero.joinedGuild.dataChanged = false;
            } while (++n2 < 3);
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            n2 = 0;
            do {
                if (user.heroes[n2] == null) continue;
                user.heroes[n2].dataChanged = false;
            } while (++n2 < 3);
            user.dataChanged = false;
        }
        catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
    }

    void a(String string, String string2, String string3, c.f f2) {
        User user = this.if(string, string3);
        user.name = string;
        user.password = string2;
        if (f2 != null) {
            f2.a(user, "");
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
        if (this.try.do(string)) {
            if (b2 != null) {
                b2.a(null, "\u5df2\u7ecf\u5b58\u5728\u76f8\u540c\u540d\u5b57\u7684\u89d2\u8272");
            }
            return;
        }
        HeroCreateJob heroCreateJob = new HeroCreateJob(string, n2, n3, b2);
        this.int.a(heroCreateJob);
    }

    void a(String string, String string2, int n2, int n3, String string3, c.e e2) {
        e2.a(n2, string3);
        User user = this.a(string);
        if (user != null && !user.online && n2 > 0 && string3.length() == 0) {
            user.treasure += n2;
            user.payedTreasure += n2;
            ServerInfo.payedTreasure += n2;
            int n4 = 0;
            while (n4 < user.heroes.length) {
                if (user.heroes[n4] != null && user.heroes[n4].name.equals(string2)) {
                    user.heroes[n4].payedTreasure += n2;
                    user.heroes[n4].dataChanged = true;
                    break;
                }
                ++n4;
            }
            this.a(user);
            UserLogItem userLogItem = new UserLogItem();
            userLogItem.username = string;
            userLogItem.heroname = string2;
            userLogItem.type = "pay";
            userLogItem.desc = n2 > 0 && string3.length() == 0 ? String.valueOf(n2) : daff.a.b.case(string3);
            this.a(userLogItem);
        }
    }

    private int do(String string, String string2) {
        if (string2.indexOf(37) < 0) {
            string2 = daff.a.b.case(string2);
        }
        int n2 = -1;
        try {
            Statement statement = this.void.createStatement();
            String string3 = "insert into " + string + " (name) values('" + string2 + "')";
            statement.executeUpdate(string3);
            string3 = "select max(id) as id from " + string;
            ResultSet resultSet = statement.executeQuery(string3);
            if (resultSet.next()) {
                n2 = resultSet.getInt("id");
            }
            resultSet.close();
            statement.close();
        }
        catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
        return n2;
    }

    int a(String string, int n2, String string2) {
        if (string2.indexOf(37) < 0) {
            string2 = daff.a.b.case(string2);
        }
        try {
            Statement statement = this.void.createStatement();
            String string3 = "insert into " + string + " (id,name) values(" + n2 + ",'" + string2 + "')";
            statement.executeUpdate(string3);
            string3 = "select max(id) as id from " + string;
            statement.close();
        }
        catch (SQLException sQLException) {
            sQLException.printStackTrace();
            return -1;
        }
        return n2;
    }

    public void saveUser(User user, c.d d2) {
        UserSaveJob userSaveJob = new UserSaveJob(user, d2);
        this.int.a(userSaveJob);
    }

    boolean goto(String string) {
        boolean bl = false;
        if (string.indexOf(37) < 0) {
            string = daff.a.b.case(string);
        }
        try {
            Statement statement = this.void.createStatement();
            ResultSet resultSet = statement.executeQuery("select id from users where name='" + string + "'");
            if (resultSet.next()) {
                bl = true;
            }
            resultSet.close();
            statement.close();
        }
        catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
        return bl;
    }

    void a(i i2) {
        String string = i2.toString();
        byte[] byArray = string.getBytes();
        this.if(byArray);
        try {
            PreparedStatement preparedStatement = this.void.prepareStatement("insert into serverlogs (data) values(?)");
            preparedStatement.setBytes(1, byArray);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
    }

    public void saveUserLog(String string, String string2, String string3, String string4) {
        UserLogItem userLogItem = new UserLogItem();
        userLogItem.username = string;
        userLogItem.heroname = string2;
        userLogItem.type = string3;
        userLogItem.desc = string4;
        UserLogJob userLogJob = new UserLogJob(userLogItem);
        this.int.a(userLogJob);
    }

    public void update() {
        ConnectionCheckJob connectionCheckJob = new ConnectionCheckJob();
        this.int.a(connectionCheckJob);
    }

    void a(Hero hero, c.b b2) {
        hero.id = this.do("heroes", hero.name);
        if (hero.id < 0) {
            b2.a(null, "\u6570\u636e\u5e93\u9519\u8bef");
        } else {
            this.try.a((Object)hero.name, (Object)hero);
            hero.personalDepot.id = hero.id;
            hero.spellList.id = hero.id;
            hero.shortCuts.id = hero.id;
            hero.taskList.id = hero.id;
            b2.a(hero, "");
            ++this.case;
        }
    }

    public void deleteHero(Hero hero) {
        this.try.a(hero.name);
        HeroDeleteJob heroDeleteJob = new HeroDeleteJob(hero.name);
        this.int.a(heroDeleteJob);
        UserLogItem userLogItem = new UserLogItem();
        userLogItem.username = hero.user.name;
        userLogItem.heroname = hero.name;
        userLogItem.type = "heroDeleted";
        userLogItem.desc = "";
        this.int.a(new UserLogJob(userLogItem));
        if (hero.joinedGuild != null && hero.joinedGuild.leader.equals(hero.name)) {
            this.deleteGuild(hero.joinedGuild);
        }
    }

    public void start() {
    }

    public void createGuild(int n2, String string, c.a a2) {
        if (a2 == null) {
            return;
        }
        Guild guild = (Guild)this.for.for(string);
        if (guild != null) {
            a2.a(null, "\u76f8\u540c\u540d\u5b57\u7684\u516c\u4f1a\u5df2\u7ecf\u5b58\u5728");
            return;
        }
        guild = (Guild)this.new.for(new Integer(n2));
        if (guild != null) {
            a2.a(null, "\u76f8\u540cID\u7684\u516c\u4f1a\u5df2\u7ecf\u5b58\u5728");
            return;
        }
        GuildCreationJob guildCreationJob = new GuildCreationJob(n2, string, a2);
        this.int.a(guildCreationJob);
    }

    public void createUser(String string, String string2, String string3, c.f f2) {
        User user = (User)this.if.for(string);
        if (user != null) {
            if (f2 != null) {
                f2.a(null, "\u8be5\u5e10\u53f7\u5df2\u7ecf\u5b58\u5728\uff1a" + string);
            }
            return;
        }
        String string4 = (String)this.else.for("userCreatingNotAllowed");
        if (string4 == null || string4.length() <= 1) {
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
            UserCreationJob userCreationJob = new UserCreationJob(string, string2, string3, f2);
            this.int.a(userCreationJob);
        } else {
            f2.a(null, string4);
        }
    }

    void if(int n2) {
        try {
            Statement statement = this.void.createStatement();
            statement.execute("delete from guilds where id=" + n2);
            statement.close();
        }
        catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
    }

    private User char(String string) {
        User user = null;
        if (string.indexOf(37) < 0) {
            string = daff.a.b.case(string);
        }
        try {
            GameObject gameObject;
            byte[] byArray;
            Statement statement = this.void.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where name='" + string + "'");
            if (resultSet.next() && (user = (User)this.do(byArray = resultSet.getBytes("data"))) != null && (gameObject = (Store)this.do(byArray = resultSet.getBytes("store"))) != null) {
                user.store = gameObject;
            }
            resultSet.close();
            if (user == null) {
                statement.close();
                return null;
            }
            int n2 = 0;
            do {
                if (user.heroIds[n2] == 0) continue;
                resultSet = statement.executeQuery("select * from heroes where id=" + user.heroIds[n2]);
                user.heroes[n2] = this.a(resultSet);
                if (user.heroes[n2] != null) {
                    this.try.a((Object)user.heroes[n2].name, (Object)user.heroes[n2]);
                }
                resultSet.close();
            } while (++n2 < 3);
            user.compute();
            n2 = 0;
            do {
                if (user.heroes[n2] == null || user.heroes[n2].guildID <= 0) continue;
                gameObject = (Guild)this.new.for(new Integer(user.heroes[n2].guildID));
                if (gameObject != null && !((Guild)gameObject).deleted) {
                    user.heroes[n2].joinedGuild = gameObject;
                    user.heroes[n2].guildName = gameObject.name;
                    user.heroes[n2].guildIcon = ((Guild)gameObject).icon;
                    continue;
                }
                user.heroes[n2].guildID = 0;
            } while (++n2 < 3);
            statement.close();
        }
        catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
        return user;
    }

    public h loadAllGuilds() {
        h h2 = new h(1000);
        try {
            Statement statement = this.void.createStatement();
            ResultSet resultSet = statement.executeQuery("select data from guilds");
            while (resultSet.next()) {
                byte[] byArray = resultSet.getBytes("data");
                Guild guild = (Guild)this.do(byArray);
                if (guild == null) continue;
                guild.init();
                this.new.a((Object)new Integer(guild.id), (Object)guild);
                this.for.a((Object)guild.name, (Object)guild);
                h2.if(guild);
                if (guild.challengerID <= 0 || this.new.if(guild.challengerID) != null) continue;
                guild.challengerID = 0;
            }
            resultSet.close();
            statement.close();
        }
        catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
        return h2;
    }

    private Hero a(ResultSet resultSet) throws SQLException {
        byte[] byArray;
        Hero hero = null;
        if (resultSet.next() && (hero = (Hero)this.do(byArray = resultSet.getBytes("data"))) != null) {
            HeroTaskList heroTaskList;
            FriendList friendList;
            Shortcuts shortcuts;
            SpellList spellList;
            hero.computeLevel();
            byArray = resultSet.getBytes("depot");
            Depot depot = (Depot)this.do(byArray);
            if (depot != null) {
                hero.personalDepot = depot;
            }
            if ((spellList = (SpellList)this.do(byArray = resultSet.getBytes("spells"))) != null) {
                hero.spellList = spellList;
                hero.spellList.checkSpells(hero);
            }
            if ((shortcuts = (Shortcuts)this.do(byArray = resultSet.getBytes("shortcuts"))) != null) {
                hero.shortCuts = shortcuts;
            }
            if ((friendList = (FriendList)this.do(byArray = resultSet.getBytes("friends"))) != null) {
                hero.friendList = friendList;
            }
            if ((heroTaskList = (HeroTaskList)this.do(byArray = resultSet.getBytes("tasks"))) != null) {
                hero.taskList = heroTaskList;
            }
            hero.calculateProperties();
        }
        return hero;
    }

    public void loadUser(String string, String string2, String string3, c.c c2) {
        UserCheckJob userCheckJob = new UserCheckJob(string, string2, string3, c2);
        this.int.a(userCheckJob);
    }

    void byte() {
        try {
            Statement statement = this.void.createStatement();
            statement.executeQuery("select min(id) from users");
            statement.close();
            return;
        }
        catch (SQLException sQLException) {
            sQLException.printStackTrace();
            try {
                if (this.void.isClosed()) {
                    System.out.println("reset connection at " + daff.a.b.do());
                    this.void.close();
                    this.void = DriverManager.getConnection(this.c, this.e, this.f);
                }
            }
            catch (SQLException sQLException2) {
                sQLException2.printStackTrace();
            }
            return;
        }
    }

    private void if(byte[] byArray) {
    }

    public void saveServerLog(i i2) {
        ServerLogJob serverLogJob = new ServerLogJob(i2);
        this.int.a(serverLogJob);
    }

    void a(String string, String string2, String string3, c.c c2, String string4) {
        if (string4.length() > 0) {
            c2.a(null, string4);
        } else {
            User user = this.if(string, string3);
            if (user != null) {
                user.password = string2;
            } else {
                string4 = "\u52a0\u8f7d\u7528\u6237\u6570\u636e\u51fa\u9519\uff0c\u8bf7\u91cd\u65b0\u5c1d\u8bd5";
            }
            c2.a(user, string4);
        }
    }

    private void a(byte[] byArray) {
        if (byArray[byArray.length - 1] != 62) {
            int n2 = 0;
            while (n2 < byArray.length) {
                byArray[n2] = (byte)(byArray[n2] ^ n2);
                ++n2;
            }
        }
    }

    void else(String string) {
        if (string.indexOf(37) < 0) {
            string = daff.a.b.case(string);
        }
        try {
            Statement statement = this.void.createStatement();
            statement.executeUpdate("delete from heroes where name='" + string + "'");
            statement.close();
        }
        catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
    }

    void a(UserLogItem userLogItem) {
        if (userLogItem.username.indexOf(37) < 0) {
            userLogItem.username = daff.a.b.case(userLogItem.username);
        }
        if (userLogItem.heroname.indexOf(37) < 0) {
            userLogItem.heroname = daff.a.b.case(userLogItem.heroname);
        }
        if (userLogItem.desc.indexOf(37) < 0) {
            userLogItem.desc = daff.a.b.case(userLogItem.desc);
        }
        try {
            PreparedStatement preparedStatement = this.void.prepareStatement("insert into userlogs (username,heroname,category,content) values(?,?,?,?)");
            preparedStatement.setString(1, userLogItem.username);
            preparedStatement.setString(2, userLogItem.heroname);
            preparedStatement.setString(3, userLogItem.type);
            preparedStatement.setString(4, userLogItem.desc);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
    }

    private byte[] a(GameObject gameObject) {
        if (gameObject == null) {
            return null;
        }
        i i2 = app.island.a.a().a(gameObject);
        String string = i2.toString();
        byte[] byArray = string.getBytes();
        this.if(byArray);
        return byArray;
    }

    User if(String string, String string2) {
        User user = (User)this.if.for(string);
        if (user != null) {
            return user;
        }
        user = this.char(string);
        if (user == null) {
            int n2 = this.do("users", string);
            if (n2 < 0) {
                return null;
            }
            user = new User();
            user.id = n2;
            user.adOwner = string2;
            user.store.id = user.id;
            user.store.name = user.name;
            this.saveUserLog(string, "", "userCreated", string2);
            ++this.byte;
        }
        user.name = string;
        this.if.a((Object)string, (Object)user);
        return user;
    }

    public boolean checkUser(String string) {
        return this.goto(string);
    }

    boolean case(String string) {
        if (this.try.do(string)) {
            return true;
        }
        boolean bl = false;
        if (string.indexOf(37) < 0) {
            string = daff.a.b.case(string);
        }
        try {
            Statement statement = this.void.createStatement();
            ResultSet resultSet = statement.executeQuery("select name from heroes where name='" + string + "'");
            if (resultSet.next()) {
                bl = true;
            }
            resultSet.close();
            statement.close();
        }
        catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
        return bl;
    }

    public void init(i i2) throws Exception {
        this.b = i2.a("userCheckUrl").for();
        this.d = i2.a("payUrl").for();
        this.long = i2.a("driverName").for();
        this.c = i2.a("urlString").for();
        String string = "";
        i i3 = i2.a("another-urlString");
        if (i3 != null) {
            string = i3.for();
        }
        if ((i3 = i2.a("username")) != null) {
            this.e = i3.for();
        }
        if ((i3 = i2.a("password")) != null) {
            this.f = i3.for();
        }
        i3 = i2.a("responseCodes");
        h h2 = i3.int();
        int n2 = 0;
        while (n2 < h2.for()) {
            i3 = (i)h2.if(n2);
            this.else.a((Object)i3.do(), (Object)i3.for());
            ++n2;
        }
        Class.forName(this.long);
        this.void = DriverManager.getConnection(this.c, this.e, this.f);
        if (string.length() > 0) {
            this.goto = DriverManager.getConnection(string, this.e, this.f);
        }
        try {
            Statement statement = this.void.createStatement();
            statement.execute("delete from userlogs where TO_DAYS(now())-TO_DAYS(time)>20 and category!='pay' and category!='buy' and category!='userLogin' and category!='userLogout' and category!='userCreated' and category!='heroCreated' and category!='heroDeleted'");
            ResultSet resultSet = statement.executeQuery("select count(id) as amount from users");
            if (resultSet.next()) {
                this.byte = resultSet.getInt("amount");
            }
            resultSet.close();
            resultSet = statement.executeQuery("select count(id) as amount from heroes");
            if (resultSet.next()) {
                this.case = resultSet.getInt("amount");
            }
            resultSet.close();
            statement.close();
        }
        catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
    }

    public void transferAccount(String string, String string2, int n2, c.e e2) {
        String string3 = "user_pay[" + string + ";amount=" + n2 + ";time=" + ServerInfo.currentMilliSecond + "]";
        String string4 = "anzhan_account_transfer[username=" + string + ";heroname=" + URLEncoder.encode(string2) + ";amount=" + n2 + "]";
        AcountTransferJob acountTransferJob = new AcountTransferJob(string, string2, n2, string3, string4, e2);
        this.int.a(acountTransferJob);
    }

    private GameObject do(byte[] byArray) {
        if (byArray == null || byArray.length <= 5) {
            return null;
        }
        this.a(byArray);
        String string = new String(byArray);
        i i2 = n.a().a(string);
        if (i2 == null) {
            return null;
        }
        return app.island.a.a().a(i2);
    }

    private class GuildDeletionJob
    implements Runnable {
        private Guild a;

        public GuildDeletionJob(Guild guild) {
            DatabaseAccessor.this.getClass();
            this.a = guild;
        }

        public void run() {
            DatabaseAccessor databaseAccessor = DatabaseAccessor.this;
            databaseAccessor.if(this.a.id);
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    private class HeroCreateJob
    implements Runnable {
        private String a;
        private int do;
        private int if;
        private c.b for;

        HeroCreateJob(String string, int n2, int n3, c.b b2) {
            DatabaseAccessor.this.getClass();
            this.a = string;
            this.if = n2;
            this.do = n3;
            this.for = b2;
        }

        public void run() {
            DatabaseAccessor databaseAccessor = DatabaseAccessor.this;
            if (databaseAccessor.case(this.a)) {
                this.for.a(null, "\u5df2\u7ecf\u5b58\u5728\u76f8\u540c\u540d\u5b57\u7684\u89d2\u8272");
                return;
            }
            Hero hero = new Hero();
            hero.name = this.a;
            hero.race = this.if;
            hero.sex = this.do;
            hero.createdTime = daff.a.b.a();
            hero.init();
            databaseAccessor.a(hero, this.for);
        }
    }

    private static class UserLogItem {
        public String username;
        public String heroname;
        public String type = "";
        public String desc = "";

        UserLogItem() {
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    private class UserSaveJob
    implements Runnable {
        private User a;
        private c.d if;

        UserSaveJob(User user, c.d d2) {
            DatabaseAccessor.this.getClass();
            this.a = user;
            this.if = d2;
        }

        public void run() {
            DatabaseAccessor databaseAccessor = DatabaseAccessor.this;
            databaseAccessor.a(this.a);
            if (this.if != null) {
                this.if.a(true, "");
            }
        }
    }

    private class UserLogJob
    implements Runnable {
        private UserLogItem a;

        UserLogJob(UserLogItem userLogItem) {
            DatabaseAccessor.this.getClass();
            this.a = userLogItem;
        }

        public void run() {
            DatabaseAccessor databaseAccessor = DatabaseAccessor.this;
            databaseAccessor.a(this.a);
        }
    }

    private class ConnectionCheckJob
    implements Runnable {
        ConnectionCheckJob() {
            DatabaseAccessor.this.getClass();
        }

        public void run() {
            DatabaseAccessor.this.byte();
        }
    }

    private class HeroDeleteJob
    implements Runnable {
        private String a;

        HeroDeleteJob(String string) {
            DatabaseAccessor.this.getClass();
            this.a = string;
        }

        public void run() {
            DatabaseAccessor databaseAccessor = DatabaseAccessor.this;
            databaseAccessor.else(this.a);
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    private class GuildCreationJob
    implements Runnable {
        private int do;
        private String a;
        private c.a if;

        public GuildCreationJob(int n2, String string, c.a a2) {
            DatabaseAccessor.this.getClass();
            this.do = n2;
            this.a = string;
            this.if = a2;
        }

        public void run() {
            DatabaseAccessor databaseAccessor = DatabaseAccessor.this;
            Guild guild = new Guild();
            guild.id = this.do;
            guild.name = this.a;
            guild.createdTime = daff.a.b.a();
            databaseAccessor.a("guilds", this.do, this.a);
            this.if.a(guild, "");
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    private class UserCreationJob
    implements Runnable {
        private c.f for;
        private String do;
        private String a;
        private String if;

        UserCreationJob(String string, String string2, String string3, c.f f2) {
            DatabaseAccessor.this.getClass();
            this.do = string;
            this.a = string2;
            this.if = string3;
            this.for = f2;
        }

        public void run() {
            DatabaseAccessor databaseAccessor = DatabaseAccessor.this;
            if (databaseAccessor.goto(this.do) && this.for != null) {
                this.for.a(null, "\u76f8\u540c\u540d\u5b57\u7684\u7528\u6237\u5df2\u7ecf\u5b58\u5728\u4e86");
            }
            databaseAccessor.a(this.do, this.a, this.if, this.for);
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    class UserCheckJob
    implements Runnable {
        private String for;
        private String a;
        private String if;
        private c.c do;

        UserCheckJob(String string, String string2, String string3, c.c c2) {
            DatabaseAccessor.this.getClass();
            this.for = string;
            this.a = string2;
            this.if = string3;
            this.do = c2;
        }

        public void run() {
            DatabaseAccessor databaseAccessor = DatabaseAccessor.this;
            String string = "";
            String string2 = databaseAccessor.if(this.for);
            if (string2 != null) {
                if (!string2.equals(this.a)) {
                    string = "\u5bc6\u7801\u9519\u8bef";
                } else {
                    databaseAccessor.for(this.for);
                }
            } else if (databaseAccessor.b.length() <= 1) {
                if (databaseAccessor.goto(this.for)) {
                    User user = databaseAccessor.if(this.for, this.if);
                    if (!user.password.equals(this.a)) {
                        string = "\u5bc6\u7801\u9519\u8bef";
                    }
                } else {
                    string = "\u4e0d\u5b58\u5728\u8be5\u5e10\u53f7";
                }
            } else {
                String string3 = databaseAccessor.b + "user_account=" + URLEncoder.encode(this.for) + "&user_password=" + URLEncoder.encode(this.a);
                try {
                    URL uRL = new URL(string3);
                    byte[] byArray = app.island.gs.c.a(uRL);
                    string3 = new String(byArray);
                    String string4 = string3 = string3.trim();
                    int n2 = string3.indexOf(44);
                    if (n2 > 0) {
                        string4 = string3.substring(0, n2);
                    }
                    if (!string4.equals("10") && (string = (String)databaseAccessor.else.for(string3)) == null) {
                        string = "unknown error:" + string3;
                    }
                }
                catch (IOException iOException) {
                    string = "network error\uff1a" + iOException.getClass().getName();
                }
            }
            databaseAccessor.a(this.for, this.a, this.if, this.do, string);
        }
    }

    private class ServerLogJob
    implements Runnable {
        private i a;

        ServerLogJob(i i2) {
            DatabaseAccessor.this.getClass();
            this.a = i2;
        }

        public void run() {
            DatabaseAccessor databaseAccessor = DatabaseAccessor.this;
            databaseAccessor.a(this.a);
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    private class AcountTransferJob
    implements Runnable {
        private String new;
        private String a;
        private int if;
        private String int;
        private String do;
        private c.e for;

        AcountTransferJob(String string, String string2, int n2, String string3, String string4, c.e e2) {
            DatabaseAccessor.this.getClass();
            this.new = string;
            this.a = string2;
            this.if = n2;
            this.int = string3;
            this.do = string4;
            this.for = e2;
        }

        public void run() {
            DatabaseAccessor databaseAccessor = DatabaseAccessor.this;
            String string = "";
            String string2 = databaseAccessor.d + "user_account=" + this.new + "&fee_money=" + this.if + "&order_id=" + this.int + "&subject=" + this.do;
            int n2 = 0;
            try {
                URL uRL = new URL(string2);
                byte[] byArray = app.island.gs.c.a(uRL);
                String string3 = string2 = new String(byArray);
                int n3 = string2.indexOf(44);
                if (n3 > 0) {
                    string3 = string2.substring(0, n3);
                }
                if (!(string3.equals("10") || (string = (String)databaseAccessor.else.for(string3)) != null && string.length() != 0)) {
                    string = "unknown error:" + string3;
                }
            }
            catch (IOException iOException) {
                string = "network error\uff1a" + iOException.getClass().getName();
            }
            databaseAccessor.a(this.new, this.a, this.if, n2, string, this.for);
        }
    }
}

