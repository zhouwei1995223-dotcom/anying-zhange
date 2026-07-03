/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.web;

import app.island.gs.GameServer;
import app.island.gs.o;
import app.island.gs.web.DBConnectionUtil;
import app.island.gs.web.WebServlet;
import daff.a.b;
import daff.a.q;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class GetBuyList
extends WebServlet {
    private q void = new q();
    private StringBuffer b = new StringBuffer(32768);

    private void if() {
        int n2 = this.void.for();
        Object[] objectArray = new Goods[n2];
        this.void.do().a(objectArray);
        this.b.append("<h3>\u9053\u5177\u9500\u552e\u7edf\u8ba1</h3>");
        this.b.append("<table>");
        this.b.append("<TR><TH>\u9053\u5177</TH><TH>\u5355\u4ef7</TH><TH>\u51fa\u552e\u4e2a\u6570</TH><TH>\u603b\u91d1\u989d</TH></TR>");
        int n3 = 0;
        while (n3 < n2) {
            Object object = objectArray[n3];
            this.b.append("<tr><td>");
            this.b.append(((Goods)object).a);
            this.b.append("</td><td>");
            this.b.append(((Goods)object).do);
            this.b.append("</td><td>");
            this.b.append(((Goods)object).if);
            this.b.append("</td><td>");
            this.b.append(((Goods)object).if * ((Goods)object).do);
            this.b.append("</td></tr>");
            ++n3;
        }
        this.b.append("</table>");
    }

    private String if(String string, String string2, String string3) {
        String string4 = "SELECT username,heroname,content,time FROM userlogs u where category='buy'";
        if (string3 != null && !string3.equals("")) {
            string4 = string4 + " and username = '" + daff.a.b.case(string3) + "' ";
        }
        return string4 + " and time between '" + string + "' and '" + string2 + "' order by time;";
    }

    public String getResponseText(app.a.b b2, GameServer gameServer, o o2) {
        Object object2;
        Statement statement;
        Connection connection;
        block23: {
            int n2 = 0;
            int n3 = 0;
            this.b.setLength(0);
            String string = b2.if("beginTime");
            String string2 = b2.if("endTime");
            String string3 = b2.if("username");
            if (string == null || string.equals("")) {
                return "no parameter\uff1abeginTime";
            }
            if (string2 == null || string2.equals("")) {
                return "no parameter\uff1aendTime";
            }
            String string4 = this.if(string, string2, string3);
            connection = DBConnectionUtil.getConnection();
            statement = null;
            ResultSet resultSet = null;
            try {
                try {
                    statement = connection.createStatement();
                    resultSet = statement.executeQuery(string4);
                    this.b.append("<h3>\u73a9\u5bb6\u6d88\u8d39\u8bb0\u5f55\u6e05\u5355</h3>");
                    this.b.append("<table>");
                    this.b.append("<tr><th>\u5e10\u53f7</th><th>\u82f1\u96c4</th><th>\u9053\u5177</th><th>\u82b1\u8d39</th><th>\u65f6\u95f4</th></tr>");
                    while (resultSet.next()) {
                        Goods goods;
                        ++n2;
                        this.b.append("<tr><td>");
                        this.b.append(resultSet.getString("username"));
                        this.b.append("</td><td>");
                        this.b.append(daff.a.b.do(resultSet.getString("heroname")));
                        this.b.append("</td><td>");
                        object2 = daff.a.b.a(resultSet.getString("content"), ";");
                        String string5 = daff.a.b.a(object2[0], "=")[1];
                        int n4 = Integer.parseInt(daff.a.b.a(object2[1], "=")[1]);
                        this.b.append(string5);
                        if (this.void.do(string5)) {
                            goods = (Goods)this.void.for(string5);
                            goods.addNumber();
                        } else {
                            goods = new Goods();
                            goods.do = n4;
                            goods.a = string5;
                            goods.if = 1;
                            this.void.a((Object)string5, (Object)goods);
                        }
                        n3 += n4;
                        this.b.append("</td><td>");
                        this.b.append(n4);
                        this.b.append("</td><td>");
                        this.b.append(resultSet.getString("time"));
                        this.b.append("</td></tr>");
                    }
                    this.b.append("</table>");
                    this.b.append("\u8d2d\u4e70\u603b\u6b21\u6570\uff1a");
                    this.b.append(n2);
                    this.b.append("\uff1b \u51fa\u552e\u5143\u5b9d\u603b\u8ba1\uff1a");
                    this.b.append(n3);
                    this.b.append("<br/>");
                }
                catch (SQLException sQLException) {
                    sQLException.printStackTrace();
                }
                Object var18_19 = null;
                if (resultSet == null) break block23;
            }
            catch (Throwable throwable) {
                SQLException sQLException2;
                Object var18_20 = null;
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
            catch (SQLException object2) {
                object2.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            }
            catch (SQLException object2) {
                object2.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            }
            catch (SQLException object2) {
                object2.printStackTrace();
            }
        }
        this.if();
        return this.b.toString();
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    private static class Goods {
        String a;
        int do;
        int if;

        Goods() {
        }

        public int compareTo(Goods goods) {
            if (this.do * this.if > goods.do * goods.if) {
                return 1;
            }
            return -1;
        }

        public void addNumber() {
            ++this.if;
        }
    }
}

