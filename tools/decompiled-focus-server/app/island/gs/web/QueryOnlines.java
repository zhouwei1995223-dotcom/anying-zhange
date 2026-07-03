/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.web;

import app.island.gs.GameServer;
import app.island.gs.o;
import app.island.gs.web.DBConnectionUtil;
import app.island.gs.web.WebServlet;
import daff.a.b;
import daff.a.h;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class QueryOnlines
extends WebServlet {
    private StringBuffer try = new StringBuffer();
    private h new = new h();

    public String getResponseText(app.a.b b2, GameServer gameServer, o o2) {
        this.try.setLength(0);
        this.new.a();
        String string = b2.if("beginTime");
        String string2 = b2.if("endTime");
        if (string == null || string.equals("")) {
            return "no parameter\uff1abeginTime";
        }
        if (string2 == null || string2.equals("")) {
            return "no parameter\uff1aendTime";
        }
        String string3 = "select content,time from userlogs where category = 'serverOnlineLog' and heroname='system' and username='system' and time between '" + string + "' and '" + string2 + "' order by time;";
        Connection connection = DBConnectionUtil.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        this.try.append("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\"></head><body>");
        this.try.append("<h1 align=center>\u67e5\u8be2\u5728\u7ebf\u4eba\u6570</h1>");
        this.try.append("<table border=1 width=770 align='center'>");
        this.try.append("<TR><TH>\u4eba\u6570</TH><TH>\u53d1\u751f\u65f6\u95f4</TH></TR>");
        try {
            try {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(string3);
                while (resultSet.next()) {
                    int n2 = Integer.parseInt(b.a(b.a(resultSet.getString("content"), ";")[0], "=")[1]);
                    String string4 = resultSet.getString("time");
                    this.new.if(new OnlineHero(n2, string4));
                    this.try.append("<tr><td>");
                    this.try.append(n2);
                    this.try.append("</td><td>");
                    this.try.append(string4);
                    this.try.append("</td></tr>");
                }
                this.try.append("</table>");
            }
            catch (SQLException sQLException) {
                sQLException.printStackTrace();
            }
            Object var13_15 = null;
        }
        catch (Throwable throwable) {
            Object var13_16 = null;
            try {
                if (resultSet != null) {
                    resultSet.close();
                    resultSet = null;
                }
                if (statement != null) {
                    statement.close();
                    statement = null;
                }
                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            }
            catch (SQLException sQLException) {
                sQLException.printStackTrace();
            }
            throw throwable;
        }
        try {
            if (resultSet != null) {
                resultSet.close();
                resultSet = null;
            }
            if (statement != null) {
                statement.close();
                statement = null;
            }
            if (connection != null) {
                connection.close();
                connection = null;
            }
        }
        catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
        return this.try.toString();
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    private static class OnlineHero {
        int a;
        String if;

        private OnlineHero() {
        }

        OnlineHero(int n2, String string) {
            this.a = n2;
            this.if = string;
        }

        public int compareTo(OnlineHero onlineHero) {
            if (this.a > onlineHero.a) {
                return 1;
            }
            return -1;
        }
    }
}

