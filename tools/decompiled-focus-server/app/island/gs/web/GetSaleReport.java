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
import daff.a.q;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetSaleReport
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
        String string4 = b2.if("days");
        int n2 = 30;
        if (string4.length() > 0) {
            n2 = Integer.parseInt(string4);
        }
        gameServer.new();
        try {
            Object[] objectArray;
            Object object;
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/" + string, string2, string3);
            StringBuffer stringBuffer = new StringBuffer(32768);
            stringBuffer.append("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\"></head><body>");
            stringBuffer.append("<h1 align=center>\u9053\u5177\u51fa\u552e\u8bb0\u5f55</h1>");
            stringBuffer.append("<table border=1 width=400 align='center'>");
            stringBuffer.append("<TR><TD>\u7269\u54c1\u540d</TD><TD>\u4ef7\u683c</TD><TD>\u51fa\u552e\u4e2a\u6570</TD><TD>\u5143\u5b9d\u603b\u8ba1</TD></TR>");
            Statement statement = connection.createStatement();
            String string5 = "select content from userlogs where category='buy' and  TO_DAYS(now())-TO_DAYS(time)<" + n2;
            ResultSet resultSet = statement.executeQuery(string5);
            int n3 = 0;
            q q2 = new q(1000);
            while (resultSet.next()) {
                object = resultSet.getString("content");
                objectArray = b.a((String)object, ";");
                if (objectArray.length == 1) continue;
                int n4 = Integer.parseInt(b.a(objectArray[0], "=")[1]);
                int n5 = Integer.parseInt(b.a(objectArray[1], "=")[1]);
                Integer n6 = new Integer(n4);
                int[] nArray = (int[])q2.for(n6);
                if (nArray == null) {
                    q2.a((Object)n6, (Object)new int[]{n4, 1, n5});
                } else {
                    nArray[1] = nArray[1] + 1;
                    nArray[2] = nArray[2] + n5;
                }
                n3 += n5;
            }
            object = q2.do().do();
            while (object.a()) {
                objectArray = (int[])object.if();
                Goods goods = w.case().getGoods((int)objectArray[0]);
                if (goods == null) continue;
                stringBuffer.append("<TR><TD>");
                stringBuffer.append(goods.name);
                stringBuffer.append("</TD><TD>");
                stringBuffer.append(goods.treasureCost);
                stringBuffer.append("</TD><TD>");
                stringBuffer.append((int)objectArray[1]);
                stringBuffer.append("</TD><TD>");
                stringBuffer.append((int)objectArray[2]);
                stringBuffer.append("</TD></TR>");
            }
            stringBuffer.append("</table>");
            stringBuffer.append("<BR><div align=\"center\" width=\"770\">");
            stringBuffer.append("\u51fa\u552e\u5143\u5b9d\u603b\u8ba1:");
            stringBuffer.append(n3);
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

