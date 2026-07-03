/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.web;

import app.island.a;
import app.island.entity.User;
import app.island.gs.GameServer;
import app.island.gs.o;
import app.island.gs.web.WebServlet;
import daff.a.b;
import daff.a.i;
import daff.a.n;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CheckUser
extends WebServlet {
    public String getResponseText(app.a.b b2, GameServer gameServer, o o2) {
        String string = b2.if("dbname");
        if (string.length() == 0) {
            return "no dbname";
        }
        String string2 = b2.if("dbuser");
        if (string2.length() == 0) {
            return "new dbuser";
        }
        String string3 = b2.if("dbpass");
        if (string2.length() == 0) {
            return "no dbpass";
        }
        String string4 = b2.if("user");
        if (string4.length() == 0) {
            return "no user";
        }
        String string5 = b2.if("password");
        User user = gameServer.new().a(string4);
        if (user != null && user.password.equals(string5)) {
            return "10";
        }
        gameServer.new();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/" + string, string2, string3);
            Statement statement = connection.createStatement();
            String string6 = "select data from users where name='" + string4 + "'";
            ResultSet resultSet = statement.executeQuery(string6);
            String string7 = "1102";
            if (resultSet.next()) {
                byte[] byArray = resultSet.getBytes("data");
                if (byArray == null) {
                    string7 = "1101";
                } else {
                    i i2 = n.a().a(new String(byArray));
                    user = (User)a.a().a(i2);
                    string7 = user.password.equals(string5) ? "10" : "1102";
                }
            }
            resultSet.close();
            statement.close();
            connection.close();
            return string7;
        }
        catch (Throwable throwable) {
            return b.a(throwable);
        }
    }
}

