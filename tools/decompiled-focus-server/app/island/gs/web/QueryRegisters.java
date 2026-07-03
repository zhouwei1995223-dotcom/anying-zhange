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
import java.sql.Statement;

public class QueryRegisters
extends WebServlet {
    public static void main(String[] stringArray) {
    }

    public String getResponseText(b b2, GameServer gameServer, o o2) {
        StringBuffer stringBuffer = new StringBuffer();
        String string = b2.if("startTime");
        String string2 = b2.if("endTime");
        try {
            Connection connection = DBConnectionUtil.getConnection();
            String string3 = string.trim().length() == 0 ? "SELECT * FROM anzhan.userlogs u " : "SELECT * FROM anzhan.userlogs u where time > '" + string + "' and time < '" + string2 + " 23:59:59' and category = 'userCreated'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(string3);
            stringBuffer.append("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\"></head><body>");
            stringBuffer.append("<h1 align=center>\u73a9\u5bb6\u6ce8\u518c\u8bb0\u5f55</h1>");
            stringBuffer.append("<table border=1 width=600 align='center'>");
            stringBuffer.append("<TR><TD>\u5e10\u53f7</TD><TD>\u65f6\u95f4</TD></TR>");
            while (resultSet.next()) {
                stringBuffer.append("<TR><TD>" + resultSet.getString("username") + "</TD><TD>" + resultSet.getString("time") + "</TD></TR>");
            }
            resultSet.close();
            statement.close();
            connection.close();
            return stringBuffer.toString();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
}

