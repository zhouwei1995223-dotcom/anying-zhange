/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs;

import app.island.data.Goods;
import app.island.entity.Hero;
import app.island.entity.Player;
import app.island.entity.Sprite;
import app.island.entity.User;
import app.island.gs.ServerInfo;
import app.island.gs.accessor.LocalFileAccessor;
import app.island.gs.c;
import app.island.gs.data.ServerCmdItem;
import app.island.gs.o;
import app.island.gs.p;
import app.island.gs.w;
import app.island.gs.web.GetPayList;
import app.island.gs.x;
import daff.a.n;
import daff.net.m;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class GameServer
implements Runnable,
daff.net.g,
daff.net.d {
    private static GameServer a = null;
    private daff.net.a byte;
    app.island.gs.c try;
    private o if;
    x case;
    daff.a.m int;
    private daff.a.m new;
    private boolean for;
    private daff.a.h do = new daff.a.h(100);
    private static /* synthetic */ Class class$app$island$gs$data$ServerCmdItem;

    public void if() {
        if (this.byte != null) {
            this.case.g();
            this.byte.stop();
            this.byte = null;
            this.try.for();
            daff.a.i i2 = ServerInfo.encodeInfoToXML();
            this.try.saveServerLog(i2);
        }
    }

    private void a(app.b.b b2) {
        f f2 = new f(b2);
        this.int.a(f2);
    }

    public void a(Runnable runnable) {
        this.new.a(runnable);
    }

    public void if(Runnable runnable) {
        this.int.a(runnable);
    }

    public void a(User user, int n2) {
        b b2 = new b(user, n2);
        this.int.a(b2);
    }

    int a(String string) {
        File file = new File("data/pay_queue/" + string);
        if (!file.exists()) {
            return 0;
        }
        String[] stringArray = file.list();
        int n2 = 0;
        int n3 = 0;
        while (n3 < stringArray.length) {
            File file2 = new File(file, stringArray[n3]);
            if (!file2.isDirectory() && file2.length() > 1L && file2.length() < 10L) {
                try {
                    String string2 = new String(daff.a.b.a(file2));
                    n2 += Integer.parseInt(string2);
                    file2.delete();
                    this.try.saveUserLog(string, "", "pay", string2);
                    String string3 = string + "\t" + string2;
                    daff.a.b.a("data/pay_logs/" + stringArray[n3], string3.getBytes());
                }
                catch (NumberFormatException numberFormatException) {}
            }
            ++n3;
        }
        file.delete();
        GetPayList.dataChanged = true;
        return n2;
    }

    private GameServer() {
    }

    public void a(daff.net.i i2, m m2) {
        app.b.b b2 = (app.b.b)m2;
        if (b2.do() > 0) {
            d d2 = new d(b2);
            this.int.a(d2);
            ++ServerInfo.receivedMessageCount;
        } else {
            ++ServerInfo.receivedPingCount;
        }
    }

    private void do() {
        this.do.a();
        w.a("config/cmd.txt", class$app$island$gs$data$ServerCmdItem != null ? class$app$island$gs$data$ServerCmdItem : (class$app$island$gs$data$ServerCmdItem = GameServer.class$("app.island.gs.data.ServerCmdItem")), this.do);
    }

    public x a() {
        return this.case;
    }

    private void if(daff.net.i i2, String string, String string2, String string3) {
        if (string3.indexOf("</") >= 0 || string3.indexOf("/>") >= 0 || string3.indexOf(60) >= 0 || string3.indexOf(62) >= 0) {
            string3 = "";
        }
        i2.a(1500);
        i2.do(30000);
        if (ServerInfo.userCreatable > 0) {
            this.try.createUser(string, string2, string3, new g(i2));
        } else {
            i2.if(p.if(false, null, "\u672c\u670d\u52a1\u5668\u6682\u65f6\u4e0d\u652f\u6301\u65b0\u7528\u6237\u6ce8\u518c"));
        }
    }

    public o for() {
        return this.if;
    }

    void a(daff.net.i i2, int n2, daff.a.e e2) {
        if (n2 == 1) {
            boolean bl = false;
            if (e2.if() == 12) {
                int n3;
                int n4;
                int n5 = e2.i();
                boolean bl2 = bl = n5 * (n4 = e2.i()) + (n3 = e2.i()) == app.b.b.new();
            }
            if (!bl) {
                i2.if(p.try("\u7248\u672c\u4e0d\u517c\u5bb9\uff0c\u8bf7\u5173\u95ed\u7a97\u53e3\u540e\u91cd\u65b0\u8fd0\u884c\u6e38\u620f"));
                i2.new();
            }
            return;
        }
        if (i2.void() == 1) {
            i2.if(p.try("\u7248\u672c\u4e0d\u517c\u5bb9\uff0c\u8bf7\u5173\u95ed\u7a97\u53e3\u540e\u91cd\u65b0\u8fd0\u884c\u6e38\u620f"));
            i2.new();
            return;
        }
        Object object = i2.char();
        switch (n2) {
            case 2: {
                if (object == null) {
                    int n6 = e2.i();
                    int n7 = e2.for();
                    byte[] byArray = e2.try(n7);
                    int n8 = 0;
                    while (n8 < byArray.length) {
                        byArray[n8] = (byte)(byArray[n8] ^ n6);
                        ++n8;
                    }
                    String string = new String(byArray);
                    n7 = e2.for();
                    byArray = e2.try(n7);
                    int n9 = 0;
                    while (n9 < byArray.length) {
                        byArray[n9] = (byte)(byArray[n9] ^ n6);
                        ++n9;
                    }
                    String string2 = new String(byArray);
                    String string3 = e2.h();
                    this.a(i2, string, string2, string3);
                    break;
                }
                i2.new();
                break;
            }
            case 3: {
                if (object == null) {
                    String string = e2.h();
                    String string4 = e2.h();
                    String string5 = e2.h();
                    this.if(i2, string, string4, string5);
                    break;
                }
                i2.new();
                break;
            }
            case 4: {
                if (object instanceof User) {
                    String string = e2.h();
                    int n10 = e2.for();
                    int n11 = e2.for();
                    this.a(i2, string, n10, n11);
                    break;
                }
                i2.new();
                break;
            }
            case 5: {
                if (object instanceof User) {
                    String string = e2.h();
                    String string6 = e2.h();
                    this.a(i2, string, string6);
                    break;
                }
                i2.new();
                break;
            }
            case 6: {
                if (object instanceof User) {
                    String string = e2.h();
                    String string7 = e2.h();
                    boolean bl = true;
                    if (e2.if() > 0) {
                        bl = e2.c();
                    }
                    this.a(i2, string, string7, bl);
                    break;
                }
                i2.new();
                break;
            }
            case 10: {
                ++ServerInfo.clientErrorReportCount;
                if (ServerInfo.printingErrorInfo <= 0) break;
                String string = e2.f();
                System.out.println("\u5ba2\u6237\u7aef\u9519\u8bef-" + i2.char());
                System.out.println(string);
                break;
            }
            default: {
                if (object instanceof app.island.gs.h) {
                    app.island.gs.h h2 = (app.island.gs.h)object;
                    this.case.a(h2, n2, e2);
                    break;
                }
                i2.new();
            }
        }
    }

    public static void main(String[] stringArray) throws Exception {
        byte[] byArray = daff.a.b.new("config/server.cfg");
        daff.a.i i2 = n.a().a(new String(byArray));
        GameServer gameServer = GameServer.try();
        if (!gameServer.a(i2)) {
            return;
        }
        gameServer.int();
        System.out.println("start GameServer at " + daff.a.b.do());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = "";
        while (true) {
            System.out.print("command>");
            try {
                string = bufferedReader.readLine();
                System.out.println(gameServer.if(string));
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            daff.a.b.if(1000);
        }
    }

    public app.island.gs.c new() {
        return this.try;
    }

    private void a(daff.net.i i2, String string, String string2) {
        User user = (User)i2.char();
        Hero hero = user.getHero(string);
        if (hero == null) {
            i2.if(p.a(false, string, "\u8981\u5220\u9664\u7684\u89d2\u8272\u4e0d\u5b58\u5728\uff1a" + string));
        } else if (hero.password.length() > 0 && hero.password.equals(string2) || hero.password.length() == 0 && string2.equals("delete")) {
            user.removeHero(string);
            this.case.if(hero);
            i2.if(p.a(true, string, ""));
            if (hero.joinedGuild != null) {
                app.island.gs.e e2 = (app.island.gs.e)hero.joinedGuild.attachment;
                if (hero.joinedGuild.leader.equals(hero.name)) {
                    e2.f();
                    app.b.b b2 = p.d("\u516c\u4f1a\u3010" + string + "\u3011\u4f1a\u957f\u88ab\u5f7b\u5e95\u5220\u9664\uff0c\u4ece\u6b64\u70df\u6d88\u4e91\u6563\uff01");
                    this.case.a(b2);
                } else {
                    hero.joinedGuild.removeMember(string);
                    e2.for(string);
                }
            }
            this.try.deleteHero(hero);
        } else {
            i2.if(p.a(false, string, "\u8f93\u5165\u5bc6\u7801\u4e0d\u6b63\u786e\uff1a" + string));
        }
    }

    private void a(daff.net.i i2, String string, String string2, boolean bl) {
        User user = (User)i2.char();
        Hero hero = user.getHero(string);
        if (hero == null) {
            i2.if(p.if(null, "\u4e0d\u5b58\u5728\u8be5\u89d2\u8272"));
        } else if (!hero.password.equals(string2)) {
            i2.if(p.if(null, "\u5bc6\u7801\u9519\u8bef"));
        } else if (hero.lockState > 0) {
            i2.if(p.if(null, "\u8be5\u89d2\u8272\u88ab\u7ba1\u7406\u5458\u9501\u5b9a\uff0c\u4e0d\u80fd\u8fdb\u5165\u6e38\u620f"));
        } else {
            Object object;
            int n2;
            if (hero.personalDepot != null && !hero.personalDepot.goodsProcessed) {
                hero.personalDepot.goodsProcessed = true;
                n2 = 0;
                while (n2 < hero.personalDepot.goodsList.length) {
                    object = hero.personalDepot.goodsList[n2];
                    if (object != null) {
                        this.case.a((Goods)object);
                    }
                    ++n2;
                }
                n2 = 0;
                while (n2 < hero.personalDepot.shopGoods.length) {
                    object = hero.personalDepot.shopGoods[n2];
                    if (object != null) {
                        this.case.a((Goods)object);
                    }
                    ++n2;
                }
            }
            if (!user.store.goodsProcessed) {
                user.store.goodsProcessed = true;
                n2 = 0;
                while (n2 < user.store.capacity) {
                    object = user.store.goods[n2];
                    if (object != null) {
                        this.case.a((Goods)object);
                    }
                    ++n2;
                }
            }
            if (hero.joinedGuild == null || hero.joinedGuild.deleted || hero.joinedGuild.attachment == null || hero.joinedGuild.getMember(hero.name) == null) {
                hero.guildID = 0;
                hero.joinedGuild = null;
            }
            if (hero.friendList.master != null) {
                hero.friendList.master.online = false;
                Hero hero2 = this.try.new(hero.friendList.master.name);
                if (hero2 != null) {
                    if (!hero2.friendList.hasStudent(hero.name)) {
                        hero.friendList.master = null;
                    } else {
                        hero.friendList.master.race = hero2.race;
                        hero.friendList.master.level = hero2.level;
                        hero.friendList.master.turns = hero2.turns;
                        hero.friendList.master.online = hero2.online;
                    }
                }
            }
            int n3 = 0;
            while (n3 < hero.friendList.studentCount) {
                hero.friendList.students[n3].online = false;
                object = this.try.new(hero.friendList.students[n3].name);
                if (object != null) {
                    if (((Hero)object).friendList.isMaster(hero.name)) {
                        hero.friendList.students[n3].race = ((Player)object).race;
                        hero.friendList.students[n3].level = ((Sprite)object).level;
                        hero.friendList.students[n3].turns = ((Player)object).turns;
                        hero.friendList.students[n3].online = ((Hero)object).online;
                    } else {
                        hero.friendList.removeStudent(hero.friendList.students[n3].name);
                    }
                }
                ++n3;
            }
            app.b.b b2 = p.if(hero, "");
            i2.if(b2);
            user.loginTime = ServerInfo.currentMilliSecond;
            hero.online = true;
            ++hero.loginCount;
            object = new app.island.gs.h(hero, bl);
            ((app.island.gs.h)object).a(i2);
            i2.a(object);
            this.case.if((app.island.gs.h)object);
            ++ServerInfo.heroLoginCount;
            this.try.saveUserLog(user.name, hero.name, "userLogin", "ip=" + i2.h());
        }
    }

    public void int() {
        if (this.byte.start()) {
            ServerInfo.launchTime = System.currentTimeMillis();
            if (this.if != null) {
                this.if.a();
            }
            this.try.start();
            this.new.for();
            this.int.for();
            this.case.f();
            this.try.saveUserLog("system", "system", "start", daff.a.b.do());
            new Thread((Runnable)this, "gameServerUpdatingThread").start();
        }
    }

    private static boolean a(int n2) {
        String string = "http://island.eleyo.com/servers/?port=" + n2;
        try {
            byte[] byArray = GameServer.a(new URL(string));
            String string2 = new String(byArray);
            if (string2.equals("ok") || string2.equals("yes")) {
                return true;
            }
        }
        catch (UnknownHostException unknownHostException) {
            return true;
        }
        catch (ConnectException connectException) {
            return true;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
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

    private static byte[] a(URL uRL) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
        InputStream inputStream = httpURLConnection.getInputStream();
        int n2 = httpURLConnection.getContentLength();
        if (n2 <= 0) {
            n2 = inputStream.available();
        }
        byte[] byArray = new byte[n2];
        int n3 = 0;
        n3 += inputStream.read(byArray, n3, n2 - n3);
        return byArray;
    }

    public void run() {
        this.for = true;
        while (this.for) {
            if (++ServerInfo.updatingCounter % 10 == 0) {
                e e2 = new e();
                this.int.a(e2);
            }
            if (ServerInfo.updatingCounter % 500 == 0) {
                this.try.update();
            }
            if (ServerInfo.updatingCounter % 70 == 0) {
                int n2 = this.do.for();
                int n3 = 0;
                while (n3 < n2) {
                    ServerCmdItem serverCmdItem = (ServerCmdItem)this.do.if(n3);
                    if (serverCmdItem.date == ServerInfo.currentTimeParts[6] && serverCmdItem.hour == ServerInfo.currentTimeParts[3] && serverCmdItem.minute == ServerInfo.currentTimeParts[4] && serverCmdItem.second == ServerInfo.currentTimeParts[5] && serverCmdItem.type.equals("weakly")) {
                        System.out.println(serverCmdItem.cmdText);
                        System.out.println(this.if(serverCmdItem.cmdText));
                        System.out.print("command>");
                    }
                    if (serverCmdItem.day == ServerInfo.currentTimeParts[2] && serverCmdItem.hour == ServerInfo.currentTimeParts[3] && serverCmdItem.minute == ServerInfo.currentTimeParts[4] && serverCmdItem.second == ServerInfo.currentTimeParts[5] && serverCmdItem.type.equals("monthly")) {
                        System.out.println(serverCmdItem.cmdText);
                        System.out.println(this.if(serverCmdItem.cmdText));
                        System.out.print("command>");
                    }
                    ++n3;
                }
            }
            daff.a.b.if(10);
        }
    }

    public void a(daff.net.i i2, String string) {
        Object object = i2.char();
        if (object instanceof app.island.gs.h) {
            app.island.gs.h h2 = (app.island.gs.h)object;
            Hero hero = h2.r();
            this.try.saveUserLog(hero.user.name, hero.name, "netError", string);
        } else if (object instanceof User) {
            User user = (User)object;
            this.try.saveUserLog(user.name, "", "netError", string);
        } else {
            this.try.saveUserLog("", "", "netError", string);
        }
    }

    public void if(daff.net.i i2) {
        if (!this.for) {
            i2.if(p.try("\u670d\u52a1\u5668\u5c1a\u672a\u542f\u52a8\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5"));
            i2.new();
            return;
        }
        if (ServerInfo.maxAcceptableClient > 0 && this.case.byte() >= ServerInfo.maxAcceptableClient) {
            i2.if(p.try("\u670d\u52a1\u5668\u4eba\u6570\u5df2\u6ee1\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5"));
            i2.new();
        } else {
            ++ServerInfo.connectionCount;
            i2.a(this);
            i2.if(512);
            i2.do(3000);
        }
    }

    public void a(daff.net.i i2) {
        Object object = i2.char();
        i2.a((Object)null);
        if (object instanceof app.island.gs.h) {
            app.island.gs.h h2 = (app.island.gs.h)object;
            j j2 = new j(h2);
            this.int.a(j2);
        } else if (object instanceof User) {
            User user = (User)object;
            user.online = false;
            this.try.saveUser((User)object, null);
        }
    }

    public boolean a(daff.a.i i2) throws Exception {
        daff.a.i i3 = i2.a("netServerClass");
        if (i3 != null && i3.for().length() > 0) {
            this.byte = (daff.net.a)daff.a.b.char(i3.for());
        }
        if (this.byte == null) {
            this.byte = new daff.net.c();
        }
        int n2 = 12345;
        i3 = i2.a("port");
        if (i3 != null && i3.for().length() > 0) {
            n2 = Integer.parseInt(i3.for());
        }
        if (!GameServer.a(n2)) {
            System.out.println("Server can not run at " + n2 + " on this machine");
            return false;
        }
        this.byte.if(n2);
        this.byte.if(this);
        this.byte.a(new app.b.e());
        String string = i2.a("accessor").for();
        i3 = i2.a(string);
        String string2 = i3.for("class");
        if (string2.length() > 0) {
            this.try = (app.island.gs.c)daff.a.b.char(string2);
        }
        if (this.try == null) {
            this.try = new LocalFileAccessor();
        }
        this.try.init(i3);
        i3 = i2.a("webInterface");
        if (i3 != null) {
            this.if = new o(this);
            this.if.a(i3);
        }
        i3 = i2.a("config");
        daff.a.h h2 = i3.int();
        int n3 = 0;
        while (n3 < h2.for()) {
            i3 = (daff.a.i)h2.if(n3);
            ServerInfo.setConfigValue(i3.do(), i3.for());
            ++n3;
        }
        this.do();
        this.int = new daff.a.m();
        this.new = new daff.a.m();
        this.try.a(this.new);
        this.case = x.for();
        this.case.a(this.try);
        this.case.i();
        return true;
    }

    public String if(String string) {
        if (string.equals("exit")) {
            this.if();
            System.exit(0);
            return "exited";
        }
        if (string.equals("saveAll")) {
            this.try.for();
            return "all data saved";
        }
        if (string.equals("stop")) {
            this.if();
            return "netserver stopped";
        }
        if (string.equals("allQuit")) {
            app.b.b b2 = p.d(0);
            b2 = b2.int();
            this.a(b2);
            return "broadcast completed";
        }
        if (string.startsWith("broadcast ")) {
            String string2 = string.substring(10);
            if (string2.length() > 0) {
                app.b.b b3 = p.d(string2);
                b3 = b3.int();
                this.a(b3);
            }
            return "broadcast completed";
        }
        if (string.startsWith("notice ")) {
            String[] stringArray = daff.a.b.a(string, " ");
            String string3 = stringArray[1];
            if (string3.length() > 0) {
                app.b.b b4 = p.d(string3);
                b4 = b4.int();
                this.a(b4);
            }
            return "broadcast completed";
        }
        if (string.startsWith("alert ")) {
            String[] stringArray = daff.a.b.a(string, " ");
            String string4 = stringArray[1];
            if (string4.length() > 0) {
                app.b.b b5 = p.try(string4);
                b5 = b5.int();
                this.a(b5);
            }
            return "broadcast completed";
        }
        if (string.startsWith("gmGrade ")) {
            String[] stringArray = daff.a.b.a(string, " ");
            String string5 = stringArray[1];
            int n2 = Integer.parseInt(stringArray[2]);
            app.island.gs.h h2 = this.case.if(string5);
            if (h2 != null) {
                h2.r().gmGrade = n2;
                h2.a(p.char(n2));
                return "gm grade changed for " + string5;
            }
            return "hero not online";
        }
        if (string.equals("onlineCount")) {
            return String.valueOf(this.byte.getConnectionCount());
        }
        if (string.equals("heroCount")) {
            return String.valueOf(this.case.byte());
        }
        if (string.equals("clearRanks")) {
            this.case.e();
            return "ranks cleared";
        }
        if (string.equals("currentJobCount")) {
            StringBuffer stringBuffer = new StringBuffer(64);
            stringBuffer.append("GameJob=");
            stringBuffer.append(this.int.byte());
            daff.a.m m2 = this.try.do();
            if (m2 != null) {
                stringBuffer.append(";DataJob=");
                stringBuffer.append(m2.byte());
            }
            return stringBuffer.toString();
        }
        if (string.equals("threads")) {
            StringBuffer stringBuffer = new StringBuffer(1024);
            int n3 = Thread.activeCount();
            Thread[] threadArray = new Thread[n3];
            Thread.enumerate(threadArray);
            int n4 = 0;
            while (n4 < n3) {
                stringBuffer.append(threadArray[n4]);
                stringBuffer.append("\r\n");
                ++n4;
            }
            return stringBuffer.toString();
        }
        if (string.equals("netDebug")) {
            daff.net.i.if = !daff.net.i.if;
            System.out.println("NetConnection.NET_DEBUG = " + daff.net.i.if);
        }
        if (string.equals("memory")) {
            long l2 = Runtime.getRuntime().totalMemory() / 1024L;
            long l3 = Runtime.getRuntime().freeMemory() / 1024L;
            return "memroy[total=" + l2 + ";free=" + l3 + "]";
        }
        if (string.startsWith("getServerInfo ")) {
            int n5 = string.indexOf(32);
            String string6 = string.substring(n5 + 1);
            if (string6.length() > 0) {
                return String.valueOf(ServerInfo.getFieldValue(string6));
            }
            return "null:" + string6;
        }
        if (string.startsWith("setServerConfig ")) {
            String[] stringArray = daff.a.b.a(string, " ");
            ServerInfo.setConfigValue(stringArray[1], stringArray[2]);
            return "config valued set:" + stringArray[2];
        }
        if (string.equals("totalBytesRead")) {
            return String.valueOf(this.byte.do());
        }
        if (string.equals("totalBytesSended")) {
            return String.valueOf(this.byte.for());
        }
        if (string.equals("getWebServiceIPList")) {
            if (this.if != null) {
                return this.if.do();
            }
            return "no webService";
        }
        if (string.equals("getWebServicePassword")) {
            if (this.if != null) {
                return this.if.if();
            }
            return "no webService";
        }
        if (string.startsWith("setWebServiceIPList ")) {
            if (this.if != null) {
                this.if.a(daff.a.b.a(string, " ")[1]);
            }
            return "no webService";
        }
        if (string.startsWith("setWebServicePassword ")) {
            if (this.if != null) {
                this.if.if(daff.a.b.a(string, " ")[1]);
            }
            return "no webService";
        }
        if (string.equals("loadCommands")) {
            this.do();
            return "commands loaded:" + this.do.for();
        }
        return "unknown instruction:" + string;
    }

    private void a(daff.net.i i2, String string, String string2, String string3) {
        if (string3.indexOf("</") >= 0 || string3.indexOf("/>") >= 0 || string3.indexOf(60) >= 0 || string3.indexOf(62) >= 0) {
            string3 = "";
        }
        if (ServerInfo.usernameMatchCase == 0) {
            string = string.toLowerCase();
        }
        if (!this.try.int(string)) {
            i2.if(p.a(false, null, "\u7528\u6237\u540d\u975e\u6cd5"));
            i2.new();
        } else if (string.length() > 20) {
            i2.if(p.a(false, null, "\u7528\u6237\u540d\u8d85\u957f"));
            i2.new();
        } else {
            i2.a(1500);
            i2.do(30000);
            this.try.loadUser(string, string2, string3, new c(i2));
        }
    }

    private void a(daff.net.i i2, String string, int n2, int n3) {
        User user = (User)i2.char();
        if (user.getHeroCount() >= 3) {
            i2.if(p.a(null, "\u5df2\u7ecf\u5230\u8fbe\u53ef\u521b\u5efa\u89d2\u8272\u7684\u4e0a\u9650"));
        } else if (n2 >= 3) {
            i2.if(p.a(null, "\u975e\u6cd5\u7684\u804c\u4e1a\u53c2\u6570"));
        } else if (n3 >= 2) {
            i2.if(p.a(null, "\u975e\u6cd5\u7684\u6027\u522b\u53c2\u6570"));
        } else if (user.hasHero(string)) {
            i2.if(p.a(null, "\u8981\u521b\u5efa\u7684\u89d2\u8272\u5df2\u7ecf\u5b58\u5728\u4e86"));
        } else {
            this.try.createHero(string, n2, n3, new i(i2));
        }
    }

    public static final GameServer try() {
        if (a == null) {
            a = new GameServer();
        }
        return a;
    }

    private class f
    implements Runnable {
        private app.b.b a;

        public f(app.b.b b2) {
            GameServer.this.getClass();
            this.a = b2;
        }

        public void run() {
            x x2 = GameServer.this.case;
            x2.a(this.a);
            System.out.println("\u6d88\u606f\u5df2\u7ecf\u6210\u529f\u5e7f\u64ad\u51fa\u53bb\uff01");
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    private class b
    implements Runnable {
        private User a;
        private int if;

        b(User user, int n2) {
            GameServer.this.getClass();
            this.a = user;
            this.if = n2;
        }

        public void run() {
            Object object;
            this.a.treasure += this.if;
            this.a.payedTreasure += this.if;
            this.a.dataChanged = true;
            ServerInfo.payedTreasure += this.if;
            String string = "";
            int n2 = 0;
            while (n2 < this.a.heroes.length) {
                if (this.a.heroes[n2] != null && this.a.heroes[n2].online) {
                    string = this.a.heroes[n2].name;
                    this.a.heroes[n2].payedTreasure += this.if;
                    GameServer.this.case.a(this.a.heroes[n2], 16);
                    object = (app.island.gs.h)this.a.heroes[n2].attachment;
                    ((app.island.gs.h)object).a(p.case(this.a.heroes[n2]));
                    ((app.island.gs.h)object).a(p.byte("\u4f60\u7684\u5e10\u53f7\u6210\u529f\u5145\u503c" + this.if + "\u5143\u5b9d"));
                    GameServer.this.case.c().a(p.void("\u5145\u503c\u4fe1\u606f[\u5e10\u53f7=" + this.a.name + ";\u89d2\u8272=" + this.a.heroes[n2].name + ";\u5143\u5b9d=" + this.if + "]"));
                }
                ++n2;
            }
            GameServer gameServer = GameServer.this;
            gameServer.try.saveUserLog(this.a.name, string, "pay", String.valueOf(this.if));
            if (this.a.adOwner != null && this.a.adOwner.length() > 1 && (object = gameServer.try.a(this.a.adOwner)) != null) {
                ((User)object).treasure += this.if / 10;
                ((User)object).earnedTreasure += this.if / 10;
                app.island.gs.h h2 = null;
                int n3 = 0;
                do {
                    if (((User)object).heroes[n3] == null || !((User)object).heroes[n3].online) continue;
                    h2 = (app.island.gs.h)((User)object).heroes[n3].attachment;
                    break;
                } while (++n3 < 3);
                if (h2 != null) {
                    String string2 = "";
                    string2 = string.length() > 0 ? "\u7531\u4f60\u63a8\u8350\u5728\u672c\u6e38\u620f\u6ce8\u518c\u7684\u73a9\u5bb6\u3010" + string + "\u3011\u5145\u503c\u4e86" + this.if + "\u5143\u5b9d" : "\u7531\u4f60\u63a8\u8350\u5728\u672c\u6e38\u620f\u6ce8\u518c\u7684\u5e10\u53f7\u3010" + this.a.name + "\u3011\u5145\u503c\u4e86" + this.if + "\u5143\u5b9d";
                    h2.do(string2);
                    h2.a(p.case(h2.r()));
                }
            }
        }
    }

    private class d
    implements Runnable {
        private app.b.b a;

        public String toString() {
            return "ClientMessageJob[message=" + this.a + ";source=" + this.a.if() + "]";
        }

        d(app.b.b b2) {
            GameServer.this.getClass();
            this.a = b2;
        }

        public void run() {
            daff.net.i i2 = (daff.net.i)this.a.if();
            if (!i2.c()) {
                return;
            }
            int n2 = this.a.do();
            daff.a.e e2 = this.a.for();
            try {
                GameServer.this.a(i2, n2, e2);
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                arrayIndexOutOfBoundsException.printStackTrace();
                System.out.println(this.a);
                if (n2 < 100) {
                    i2.new();
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
                System.out.println(this.a);
            }
        }
    }

    private class g
    implements c.f {
        private daff.net.i a;

        g(daff.net.i i2) {
            GameServer.this.getClass();
            this.a = i2;
        }

        public void a(User user, String string) {
            if (user != null) {
                user.online = true;
            }
            this.a.if(p.if(user != null, user, string));
            this.a.a(user);
        }
    }

    private class e
    implements Runnable {
        e() {
            GameServer.this.getClass();
        }

        public void run() {
            ServerInfo.currentMilliSecond = System.currentTimeMillis();
            ServerInfo.currentTimeCode = daff.a.b.a(ServerInfo.currentMilliSecond, ServerInfo.currentTimeParts);
            x x2 = GameServer.this.case;
            x2.b();
        }
    }

    private class j
    implements Runnable,
    c.d {
        private app.island.gs.h a;

        j(app.island.gs.h h2) {
            GameServer.this.getClass();
            this.a = h2;
        }

        public void run() {
            Hero hero = this.a.r();
            hero.online = false;
            User user = hero.user;
            user.online = false;
            GameServer.this.case.a(this.a);
            if (hero.life <= 0) {
                hero.life = hero.maxLife;
            }
            hero.lastLogoutTime = daff.a.b.a();
            GameServer.this.try.saveUser(user, this);
            user.logoutTime = ServerInfo.currentMilliSecond;
            GameServer.this.try.saveUserLog(user.name, hero.name, "userLogout", "curOnlineCount=" + GameServer.this.case.byte());
        }

        public void a(boolean bl, String string) {
        }
    }

    private class c
    implements c.c {
        private daff.net.i a;

        c(daff.net.i i2) {
            GameServer.this.getClass();
            this.a = i2;
        }

        public void a(User user, String string) {
            if (this.a.c()) {
                a a2 = new a(this.a, user, string);
                GameServer.this.int.a(a2);
            }
        }
    }

    private class i
    implements c.b {
        private daff.net.i a;

        public void a(Hero hero, String string) {
            h h2 = new h(this.a, hero, string);
            GameServer.this.int.a(h2);
        }

        i(daff.net.i i2) {
            GameServer.this.getClass();
            this.a = i2;
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    private class a
    implements Runnable {
        private daff.net.i do;
        private User a;
        private String if;

        a(daff.net.i i2, User user, String string) {
            GameServer.this.getClass();
            this.do = i2;
            this.a = user;
            this.if = string;
        }

        public void run() {
            if (!this.do.c()) {
                return;
            }
            boolean bl = false;
            if (this.a != null) {
                if (this.a.lockState > 0) {
                    this.if = "\u8be5\u5e10\u53f7\u88ab\u7ba1\u7406\u5458\u9501\u5b9a\uff0c\u4e0d\u80fd\u8fdb\u5165\u6e38\u620f";
                } else if (this.a.online) {
                    this.if = "\u8be5\u5e10\u53f7\u5df2\u7ecf\u5728\u6e38\u620f\u4e2d\u4e86";
                } else if (ServerInfo.currentMilliSecond - this.a.logoutTime < (long)ServerInfo.loginDelayTime) {
                    int n2 = (int)((long)ServerInfo.loginDelayTime - (ServerInfo.currentMilliSecond - this.a.logoutTime)) / 1000;
                    this.if = "\u8be5\u5e10\u53f7\u88ab\u9501\u5b9a\u4fdd\u62a4\uff0c\u8bf7" + n2 + "\u79d2\u540e\u518d\u767b\u5f55";
                } else {
                    bl = true;
                    this.a.online = true;
                    this.a.loginTime = ServerInfo.currentMilliSecond;
                    ++this.a.loginCount;
                    this.a.lastLoginIP = this.do.h();
                    int n3 = GameServer.this.a(this.a.name);
                    this.a.treasure += n3;
                    this.a.payedTreasure += n3;
                    while (this.a.treasure > ServerInfo.maxTreasure) {
                        this.a.treasure -= ServerInfo.maxTreasure;
                    }
                }
            }
            this.do.a(bl ? this.a : null);
            this.do.if(p.a(bl, this.a, this.if));
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    private class h
    implements Runnable {
        private daff.net.i do;
        private Hero a;
        private String if;

        h(daff.net.i i2, Hero hero, String string) {
            GameServer.this.getClass();
            this.do = i2;
            this.a = hero;
            this.if = string;
        }

        public void run() {
            if (this.a != null) {
                User user = (User)this.do.char();
                user.addHero(this.a);
                GameServer.this.try.saveUserLog(user.name, this.a.name, "heroCreated", "heroes=" + user.getHeroCount());
            }
            this.do.if(p.a(this.a, this.if));
        }
    }
}

