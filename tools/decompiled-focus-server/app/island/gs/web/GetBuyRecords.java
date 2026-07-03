/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.web;

import app.island.data.Goods;
import app.island.gs.GameServer;
import app.island.gs.o;
import app.island.gs.w;
import app.island.gs.web.WebServlet;
import daff.a.b;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetBuyRecords
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
        String string4 = b2.if("username");
        if (string4.indexOf(37) < 0) {
            string4 = b.case(string4);
        }
        gameServer.new();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/" + string, string2, string3);
            StringBuffer stringBuffer = new StringBuffer(32768);
            stringBuffer.append("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\"></head><body>");
            stringBuffer.append("<h1 align=center>\u9053\u5177\u8d2d\u4e70\u8bb0\u5f55</h1>");
            stringBuffer.append("<table border=1 width=800 align='center'>");
            stringBuffer.append("<TR><TD>\u5e10\u53f7</TD><TD>\u89d2\u8272</TD><TD>\u9053\u5177</TD><TD>\u4ef7\u683c</TD><TD>\u65f6\u95f4</TD></TR>");
            String string5 = "";
            string5 = string4.length() == 0 ? "select username,heroname,time,content from userlogs where category='buy' and  TO_DAYS(now())-TO_DAYS(time)<1 order by time" : "select username,heroname,time,content from userlogs where category='buy' and  username='" + string4 + "' order by time";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(string5);
            int n2 = 0;
            while (resultSet.next()) {
                String string6 = resultSet.getString("content");
                String[] stringArray = b.a(string6, ";");
                if (stringArray.length == 1) continue;
                int n3 = Integer.parseInt(b.a(stringArray[0], "=")[1]);
                int n4 = Integer.parseInt(b.a(stringArray[1], "=")[1]);
                n2 += n4;
                Goods goods = w.case().getGoods(n3);
                String string7 = "";
                string7 = goods != null ? goods.name : String.valueOf(n3);
                stringBuffer.append("<TR><TD>");
                stringBuffer.append(b.do(resultSet.getString("username")));
                stringBuffer.append("</TD><TD>");
                stringBuffer.append(b.do(resultSet.getString("heroname")));
                stringBuffer.append("</TD><TD>");
                stringBuffer.append(string7);
                stringBuffer.append("</TD><TD>");
                stringBuffer.append(n4);
                stringBuffer.append("</TD><TD>");
                stringBuffer.append(resultSet.getTimestamp("time"));
                stringBuffer.append("</TD></TR>");
            }
            stringBuffer.append("</table>");
            stringBuffer.append("<BR><div align=\"center\" width=\"770\">");
            stringBuffer.append("\u51fa\u552e\u5143\u5b9d\u603b\u8ba1:");
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

