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

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class HeroCreatedAndDeleted
extends WebServlet {
    private StringBuffer for = new StringBuffer();

    public String getResponseText(b b2, GameServer gameServer, o o2) {
        this.for.setLength(0);
        String string = b2.if("beginTime");
        String string2 = b2.if("endTime");
        if (string == null || string.equals("")) {
            return "no parameter\uff1abeginTime";
        }
        if (string2 == null || string2.equals("")) {
            return "no parameter\uff1aendTime";
        }
        String string3 = "SELECT count(*) FROM userlogs u where category = 'heroCreated' and time between '" + string + "' and '" + string2 + "';";
        String string4 = "SELECT count(*) FROM userlogs u where category = 'heroDeleted' and time between '" + string + "' and '" + string2 + "';";
        Connection connection = DBConnectionUtil.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        ResultSet resultSet2 = null;
        this.for.append("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\"></head><body>");
        this.for.append("<h1 align=center>\u67e5\u8be2\u5728\u7ebf\u4eba\u6570</h1>");
        this.for.append("<table border=1 width=770 align='center'>");
        try {
            try {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(string3);
                while (resultSet.next()) {
                    this.for.append("<tr><td>\u521b\u5efa\u7528\u6237\u6570</td><td>");
                    this.for.append(resultSet.getString(1));
                    this.for.append("</td></tr>");
                }
                resultSet2 = statement.executeQuery(string4);
                while (resultSet2.next()) {
                    this.for.append("<tr><td>\u5220\u9664\u7528\u6237\u6570</td><td>");
                    this.for.append(resultSet2.getString(1));
                    this.for.append("</td></tr>");
                }
            }
            catch (SQLException sQLException) {
                sQLException.printStackTrace();
            }
            Object var14_15 = null;
        }
        catch (Throwable throwable) {
            Object var14_16 = null;
            try {
                if (resultSet != null) {
                    resultSet.close();
                    resultSet = null;
                }
                if (resultSet2 != null) {
                    resultSet2.close();
                    resultSet2 = null;
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
            if (resultSet2 != null) {
                resultSet2.close();
                resultSet2 = null;
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
        this.for.append("</tabel></body></html>");
        return this.for.toString();
    }
}

