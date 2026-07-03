/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs;

import app.island.entity.Guild;
import app.island.entity.Hero;
import app.island.entity.User;
import daff.a.h;
import daff.a.i;
import daff.a.l;
import daff.a.m;
import daff.a.q;
import daff.a.r;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public abstract class c {
    public static final String a = "/<>,.~!@#$%^&*";
    public static final String char = "/<>,.~!@#$%^&*";
    protected q if = new q(40000);
    protected q try = new q(80000);
    protected q new = new q(10000);
    protected q for = new q(10000);
    protected q do = new q();
    protected int case;
    protected int byte;
    protected m int;

    public Guild a(int n2) {
        return (Guild)this.new.for(new Integer(n2));
    }

    public void stop() {
    }

    public Guild do(String string) {
        return (Guild)this.for.for(string);
    }

    public abstract void deleteGuild(Guild var1);

    public abstract void createHero(String var1, int var2, int var3, b var4);

    protected boolean int(String string) {
        int n2 = string.length();
        int n3 = 0;
        while (n3 < n2) {
            char c2 = string.charAt(n3);
            if ("/<>,.~!@#$%^&*".indexOf(c2) >= 0) {
                return false;
            }
            ++n3;
        }
        return true;
    }

    public abstract void saveUser(User var1, d var2);

    public void saveUserLog(String string, String string2, String string3, String string4) {
    }

    public void update() {
    }

    public int int() {
        return this.byte;
    }

    public Hero new(String string) {
        return (Hero)this.try.for(string);
    }

    public abstract void deleteHero(Hero var1);

    public void start() {
    }

    public abstract void createGuild(int var1, String var2, a var3);

    public abstract void createUser(String var1, String var2, String var3, f var4);

    protected boolean byte(String string) {
        int n2 = string.length();
        int n3 = 0;
        while (n3 < n2) {
            char c2 = string.charAt(n3);
            if ("/<>,.~!@#$%^&*".indexOf(c2) >= 0) {
                return false;
            }
            if (!(c2 >= '0' && c2 <= '9' || c2 >= 'a' && c2 <= 'z' || c2 >= 'A' && c2 <= 'Z' || c2 > '\u4a38')) {
                return false;
            }
            ++n3;
        }
        return true;
    }

    public static byte[] a(URL uRL) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
        InputStream inputStream = httpURLConnection.getInputStream();
        int n2 = httpURLConnection.getContentLength();
        if (n2 <= 0) {
            n2 = inputStream.available();
        }
        byte[] byArray = null;
        if (n2 <= 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            int n3 = inputStream.read();
            while (n3 > 0) {
                byteArrayOutputStream.write(n3);
                n3 = inputStream.read();
            }
            byArray = byteArrayOutputStream.toByteArray();
        } else {
            byArray = new byte[n2];
            int n4 = 0;
            while (n4 < n2) {
                n4 += inputStream.read(byArray, n4, n2 - n4);
            }
        }
        inputStream.close();
        return byArray;
    }

    public abstract h loadAllGuilds();

    public void a(String string, String string2) {
        q q2 = this.do;
        synchronized (q2) {
            this.do.a((Object)string, (Object)string2);
            Object var4_4 = null;
        }
    }

    public User a(String string) {
        return (User)this.if.for(string);
    }

    public abstract void loadUser(String var1, String var2, String var3, c var4);

    public void saveServerLog(i i2) {
    }

    public int new() {
        return this.case;
    }

    public int if() {
        return this.try.for();
    }

    public int a() {
        return this.new.for();
    }

    public String if(String string) {
        q q2 = this.do;
        synchronized (q2) {
            String string2 = (String)this.do.for(string);
            Object var3_4 = null;
            return string2;
        }
    }

    public void for() {
        r r2 = this.if.do();
        int n2 = 0;
        l l2 = r2.do();
        while (l2.a()) {
            User user = (User)l2.if();
            if (!user.online && !user.dataChanged) continue;
            this.saveUser(user, null);
            ++n2;
        }
        System.out.println("user saved:" + n2);
    }

    public m do() {
        return this.int;
    }

    public void a(m m2) {
        this.int = m2;
    }

    public void for(String string) {
        q q2 = this.do;
        synchronized (q2) {
            this.do.a(string);
            Object var3_3 = null;
        }
    }

    protected boolean try(String string) {
        int n2 = string.length();
        int n3 = 0;
        while (n3 < n2) {
            char c2 = string.charAt(n3);
            if (c2 <= ' ' || c2 == '\"' || c2 == '/' || c2 == '>' || c2 == '<') {
                return false;
            }
            ++n3;
        }
        return true;
    }

    public abstract boolean checkUser(String var1);

    public void init(i i2) throws Exception {
    }

    public int try() {
        return this.if.for();
    }

    public abstract void transferAccount(String var1, String var2, int var3, e var4);

    public static interface d {
        public void a(boolean var1, String var2);
    }

    public static interface f {
        public void a(User var1, String var2);
    }

    public static interface c {
        public void a(User var1, String var2);
    }

    public static interface b {
        public void a(Hero var1, String var2);
    }

    public static interface a {
        public void a(Guild var1, String var2);
    }

    public static interface e {
        public void a(int var1, String var2);
    }
}

