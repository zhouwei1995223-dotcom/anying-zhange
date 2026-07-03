/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.web;

import app.island.data.Goods;
import app.island.gs.GameServer;
import app.island.gs.o;
import app.island.gs.web.DBConnectionUtil;
import app.island.gs.web.WebServlet;
import daff.a.b;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class GetQueryTrades
extends WebServlet {
    private Connection if;
    private Statement do;
    private ResultSet a;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String getResponseText(app.a.b b2, GameServer gameServer, o o2) {
        String string = b2.if("heroName");
        String string2 = b2.if("beginTime");
        String string3 = b2.if("endTime");
        StringBuilder stringBuilder = new StringBuilder("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\"></head><body>");
        stringBuilder.append("<table border=1 width=800 align='center'>");
        stringBuilder.append("<TR><TD>\u5e10\u53f7</TD><TD>\u53d1\u8d77\u4ea4\u6613</TD><TD>\u63a5\u6536\u4ea4\u6613</TD><TD>\u91d1\u5e01</TD><TD>\u7269\u54c1</TD><TD>\u65f6\u95f4</TD></TR>");
        try {
            this.if = DBConnectionUtil.getConnection();
            this.do = this.if.createStatement();
            String string4 = "SELECT * FROM userlogs where category = 'trade'";
            if (string != null && !string.trim().equals("")) {
                string4 = string4 + " and heroname = '" + b.case(string) + "'";
            }
            if (string2 != null && !string2.trim().equals("") && string3 != null && !string3.trim().equals("")) {
                string4 = string4 + " and time between '" + string2 + "' and '" + string3 + "'";
            }
            string4 = string4 + " order by time desc";
            this.a = this.do.executeQuery(string4);
            int n2 = 0;
            while (this.a.next()) {
                ++n2;
                String string5 = this.a.getString("content");
                string5 = b.do(string5);
                String string6 = string5.split(";")[0].split("=")[1];
                String string7 = string5.split(";")[1].split("=")[1];
                String[] stringArray = string5.split(";")[2].split("=");
                stringBuilder.append("<TR><TD>");
                stringBuilder.append(this.a.getString("username"));
                stringBuilder.append("</TD><TD>");
                stringBuilder.append(b.do(this.a.getString("heroname")));
                stringBuilder.append("</TD><TD>");
                stringBuilder.append(string6);
                stringBuilder.append("</TD><TD>");
                stringBuilder.append(string7);
                stringBuilder.append("</TD><TD>");
                if (stringArray.length < 2) {
                    stringBuilder.append("\u65e0");
                } else {
                    String string8 = "";
                    for (String string9 : stringArray[1].split(",")) {
                        try {
                            string8 = string8 + Goods.getGlobalGoods((int)Integer.parseInt((String)string9)).name + ";";
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                    }
                    stringBuilder.append(string8);
                }
                stringBuilder.append("</TD><TD>");
                stringBuilder.append(this.a.getString("time"));
                stringBuilder.append("</TD></TR>");
            }
            stringBuilder.append("<h3>\u603b\u5171\u6709");
            stringBuilder.append(n2);
            stringBuilder.append("\u6761\u8bb0\u5f55</h3>");
        }
        catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
        finally {
            if (this.a != null) {
                try {
                    this.a.close();
                }
                catch (SQLException sQLException) {
                    sQLException.printStackTrace();
                }
            }
            if (this.do != null) {
                try {
                    this.do.close();
                }
                catch (SQLException sQLException) {
                    sQLException.printStackTrace();
                }
            }
            if (this.if != null) {
                try {
                    this.if.close();
                }
                catch (SQLException sQLException) {
                    sQLException.printStackTrace();
                }
            }
            stringBuilder.append("</table>");
        }
        return stringBuilder.toString();
    }
}

