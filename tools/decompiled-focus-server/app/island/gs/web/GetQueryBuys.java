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
import daff.a.q;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetQueryBuys
extends WebServlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String getResponseText(app.a.b b2, GameServer gameServer, o o2) {
        String string = b2.if("playername");
        String string2 = b2.if("beginTime");
        String string3 = b2.if("endTime");
        String string4 = b.case(string);
        String string5 = "select * from userlogs where category = 'buy' ";
        if (!"".equals(string)) {
            string5 = string5 + " and heroname = '" + string4 + "'";
        }
        if (!"".equals(string2) && !"".equals(string3)) {
            string5 = string5 + " and time >= '" + string2 + "'";
            string5 = string5 + " and time <= '" + string3 + " 23:59:59'";
        }
        string5 = string5 + " order by heroname,time desc";
        Connection connection = DBConnectionUtil.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        q q2 = new q();
        StringBuffer stringBuffer = new StringBuffer("");
        stringBuffer.append("<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=GB2312\">\n<title>\u73a9\u5bb6\u7684\u6d88\u8d39\u8bb0\u5f55</title>\n</head>\n<body>\n<center>");
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(string5);
            String string6 = "";
            String[] stringArray = null;
            String[] stringArray2 = null;
            stringBuffer.append("\n<table border='1' style='size:12'>");
            stringBuffer.append("<tr>");
            stringBuffer.append("\n<th>\u82f1\u96c4\u540d\u79f0</th>");
            stringBuffer.append("\n<th>\u9053\u5177\u540d\u79f0</th>");
            stringBuffer.append("\n<th>\u5143\u5b9d\u6570\u91cf</th>");
            stringBuffer.append("\n<th>\u8d2d\u4e70\u65f6\u95f4</th>");
            stringBuffer.append("\n</tr>");
            int n2 = 0;
            int n3 = 0;
            while (resultSet.next()) {
                ++n2;
                string6 = resultSet.getString("content");
                stringArray = string6.split(";");
                stringArray2 = stringArray[1].split("=");
                stringArray = stringArray[0].split("=");
                q2.a((Object)stringArray[1], (Object)stringArray2[1]);
                stringBuffer.append("\n<tr>");
                stringBuffer.append("\n<td>" + b.do(resultSet.getString("heroname")) + "</td>");
                stringBuffer.append("\n<td>" + Goods.getGlobalGoods((int)Integer.parseInt((String)stringArray[1])).name + "</td>");
                stringBuffer.append("\n<td>" + stringArray2[1] + "</td>");
                stringBuffer.append("\n<td>" + resultSet.getString("time") + "</td>");
                stringBuffer.append("\n</tr>");
                n3 += Integer.parseInt(stringArray2[1]);
            }
            if (n2 == 0) {
                stringBuffer.append("\u82f1\u96c4: " + string + ", \u5f53\u524d\u65f6\u95f4\u6bb5\u6ca1\u6709\u8d2d\u4e70\u8bb0\u5f55");
            } else {
                stringBuffer.append("\n<tr>");
                stringBuffer.append("\n<td></td>");
                stringBuffer.append("\n<td></td>");
                stringBuffer.append("\n<td>\u603b\u6d88\u8d39: " + n3 + "</td>");
                stringBuffer.append("\n<td></td>");
                stringBuffer.append("\n</tr>");
            }
            stringBuffer.append("\n</table></center></body></html>");
        }
        catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
        finally {
            try {
                if (null != resultSet) {
                    resultSet.close();
                }
                if (null != statement) {
                    statement.close();
                }
                if (null != connection) {
                    connection.close();
                }
            }
            catch (SQLException sQLException) {
                sQLException.printStackTrace();
            }
        }
        return stringBuffer.toString();
    }
}

