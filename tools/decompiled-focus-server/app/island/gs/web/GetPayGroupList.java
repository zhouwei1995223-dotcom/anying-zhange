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

public class GetPayGroupList
extends WebServlet {
    private StringBuffer c = new StringBuffer();

    public String getResponseText(b b2, GameServer gameServer, o o2) {
        Statement statement;
        Connection connection;
        int n2;
        int n3;
        block22: {
            this.c.setLength(0);
            n3 = 0;
            n2 = 0;
            String string = b2.if("beginTime");
            String string2 = b2.if("endTime");
            if (string == null || string.equals("")) {
                return "no parameter\uff1abeginTime";
            }
            if (string2 == null || string2.equals("")) {
                return "no parameter\uff1aendTime";
            }
            String string3 = "SELECT username,sum(content) as total FROM userlogs u where category = 'pay' and time between '" + string + "' and '" + string2 + "' group by username order by total desc;";
            connection = DBConnectionUtil.getConnection();
            statement = null;
            ResultSet resultSet = null;
            this.c.append("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\"></head><body>");
            this.c.append("<h1 align=center>\u5145\u503c\u7528\u6237\u6392\u884c\u699c</h1>");
            this.c.append("<table border=1 width=770 align='center'>");
            this.c.append("<TR><TH>\u5e10\u53f7</TH><TH>\u5408\u8ba1\u5145\u503c\u5143\u5b9d</TH></TR>");
            try {
                try {
                    statement = connection.createStatement();
                    resultSet = statement.executeQuery(string3);
                    while (resultSet.next()) {
                        this.c.append("<TR><TD>");
                        this.c.append(resultSet.getString("username"));
                        this.c.append("</TD><TD>");
                        int n4 = Integer.parseInt(resultSet.getString("total"));
                        this.c.append(n4);
                        this.c.append("</TD></TR>");
                        ++n3;
                        n2 += n4;
                    }
                }
                catch (NumberFormatException numberFormatException) {
                    numberFormatException.printStackTrace();
                }
                catch (SQLException sQLException) {
                    sQLException.printStackTrace();
                }
                Object var14_19 = null;
                if (resultSet == null) break block22;
            }
            catch (Throwable throwable) {
                SQLException sQLException2;
                Object var14_20 = null;
                if (resultSet != null) {
                    try {
                        resultSet.close();
                    }
                    catch (SQLException sQLException2) {
                        sQLException2.printStackTrace();
                    }
                }
                if (statement != null) {
                    try {
                        statement.close();
                    }
                    catch (SQLException sQLException2) {
                        sQLException2.printStackTrace();
                    }
                }
                if (connection != null) {
                    try {
                        connection.close();
                    }
                    catch (SQLException sQLException2) {
                        sQLException2.printStackTrace();
                    }
                }
                throw throwable;
            }
            try {
                resultSet.close();
            }
            catch (SQLException sQLException) {
                sQLException.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            }
            catch (SQLException sQLException) {
                sQLException.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            }
            catch (SQLException sQLException) {
                sQLException.printStackTrace();
            }
        }
        this.c.append("</table>");
        this.c.append("<BR><div align=\"center\" width=\"770\">");
        this.c.append("\u7528\u6237\u603b\u6570:");
        this.c.append(n3);
        this.c.append(";\u5143\u5b9d\u603b\u8ba1:");
        this.c.append(n2);
        this.c.append("</div>");
        this.c.append("</body></html>");
        return this.c.toString();
    }
}

