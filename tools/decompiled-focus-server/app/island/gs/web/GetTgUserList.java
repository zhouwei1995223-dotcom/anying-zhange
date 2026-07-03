/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.web;

import app.island.gs.GameServer;
import app.island.gs.o;
import app.island.gs.web.WebServlet;
import daff.a.b;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetTgUserList
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
        String string4 = b2.if("ad");
        if (string4.length() == 0) {
            return "no adOwner";
        }
        gameServer.new();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/" + string, string2, string3);
            StringBuffer stringBuffer = new StringBuffer(32768);
            stringBuffer.append("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\"></head><body>");
            stringBuffer.append("<h1 align=center>\u63a8\u5e7f\u6ce8\u518c\u8bb0\u5f55</h1>");
            stringBuffer.append("<table border=1 width=450 align='center'>");
            stringBuffer.append("<TR><TD>\u5e10\u53f7\u540d</TD><TD>\u63a8\u8350\u4eba</TD><TD>\u6ce8\u518c\u65f6\u95f4</TD></TR>");
            Statement statement = connection.createStatement();
            String string5 = "";
            string5 = string4.equals("all") ? "select username,content,time from userlogs where category='userCreated' and TO_DAYS(now())-TO_DAYS(time)<1 order by time" : "select username,content,time from userlogs where category='userCreated' and content='" + b.case(string4) + "' order by time";
            ResultSet resultSet = statement.executeQuery(string5);
            int n2 = 0;
            while (resultSet.next()) {
                stringBuffer.append("<TR><TD>");
                stringBuffer.append(b.do(resultSet.getString("username")));
                stringBuffer.append("</TD><TD>");
                String string6 = b.do(resultSet.getString("content"));
                if (string6.length() > 1) {
                    stringBuffer.append(b.do(string6));
                } else {
                    stringBuffer.append("no");
                }
                stringBuffer.append("</TD><TD>");
                stringBuffer.append(resultSet.getTimestamp("time"));
                stringBuffer.append("</TD><TR>");
                ++n2;
            }
            stringBuffer.append("</table>");
            stringBuffer.append("<BR><div align=\"center\" width=\"770\">");
            stringBuffer.append("\u6ce8\u518c\u603b\u6570:");
            stringBuffer.append(n2);
            resultSet.close();
            statement.close();
            connection.close();
            return stringBuffer.toString();
        }
        catch (Throwable throwable) {
            return b.a(throwable);
        }
    }
}

