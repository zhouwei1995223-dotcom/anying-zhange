/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.web;

import daff.a.b;
import daff.a.h;
import daff.a.i;
import daff.a.n;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
    private static i a;

    static {
        byte[] byArray = b.new("config/server.cfg");
        a = n.a().a(new String(byArray));
    }

    public static Connection getConnection() {
        Connection connection = null;
        i i2 = DBConnectionUtil.a();
        String string = i2.a("urlString").for();
        String string2 = i2.a("driverName").for();
        String string3 = i2.a("username").for();
        String string4 = i2.a("password").for();
        try {
            Class.forName(string2);
            connection = DriverManager.getConnection(string, string3, string4);
        }
        catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
        catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
        return connection;
    }

    private static final i a() {
        h h2 = a.int();
        int n2 = h2.for();
        int n3 = 0;
        while (n3 < n2) {
            i i2 = a.for(n3);
            h h3 = i2.int();
            if (h3 != null && h3.for() > 4 && i2.for("class").indexOf("DatabaseAccessor") > 0) {
                return i2;
            }
            ++n3;
        }
        return null;
    }
}

