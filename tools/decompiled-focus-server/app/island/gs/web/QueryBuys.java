/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.web;

import app.a.b;
import app.island.gs.GameServer;
import app.island.gs.o;
import app.island.gs.web.DBConnectionUtil;
import app.island.gs.web.WebServlet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryBuys
extends WebServlet {
    public String getResponseText(b b2, GameServer gameServer, o o2) {
        String string = "select * from userlogs where category = 'buy';";
        Connection connection = DBConnectionUtil.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(string);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("content"));
            }
        }
        catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
        String string2 = b2.if("playername");
        String string3 = b2.if("beginTime");
        String string4 = b2.if("endTime");
        System.out.println(string2);
        return string2 + string3 + string4 + ", hehe";
    }
}

