/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.web;

import app.island.gs.GameServer;
import app.island.gs.o;
import app.island.gs.web.DBConnectionUtil;
import app.island.gs.web.WebServlet;
import daff.a.b;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class QueryPays
extends WebServlet {
    private static String int = "select * from userlogs where category like 'pay' and username like ? and time > ? and time < ? ";

    public String getResponseText(app.a.b b2, GameServer gameServer, o o2) {
        String string = b2.if("username");
        String string2 = b2.if("beginTime");
        String string3 = b2.if("endTime");
        StringBuffer stringBuffer = this.a(string, string2, string3);
        return stringBuffer.toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private StringBuffer a(String string, String string2, String string3) {
        Serializable serializable;
        ArrayList<Object> arrayList;
        block38: {
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;
            arrayList = new ArrayList<Object>();
            try {
                Serializable serializable2;
                Object object;
                connection = DBConnectionUtil.getConnection();
                if (connection == null) break block38;
                serializable = new Date();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime((Date)serializable);
                int n2 = calendar.get(1);
                int n3 = calendar.get(2) + 1;
                int[] nArray = new int[]{31, n2 % 4 == 0 && n2 % 100 != 0 || n2 % 400 == 0 ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
                statement = connection.prepareStatement(int);
                if (string != null && !string.equals("")) {
                    statement.setString(1, "%" + string + "%");
                } else {
                    statement.setString(1, "%");
                }
                try {
                    if (string2 != null && !string2.equals("")) {
                        object = Timestamp.valueOf(this.a(string2));
                        System.out.println(((Timestamp)object).toString());
                        statement.setTimestamp(2, (Timestamp)object);
                    } else {
                        object = n2 + "-" + n3 + "-1";
                        System.out.println((String)object);
                        serializable2 = Timestamp.valueOf(this.a((String)object));
                        statement.setTimestamp(2, (Timestamp)serializable2);
                    }
                }
                catch (ParseException parseException) {
                    StringBuffer stringBuffer = new StringBuffer("\u5f00\u59cb\u65e5\u671f\u683c\u5f0f\u4e0d\u7b26\u5408\u89c4\u8303");
                    try {
                        if (resultSet != null && !resultSet.isClosed()) {
                            resultSet.close();
                        }
                        if (statement != null && !statement.isClosed()) {
                            statement.close();
                        }
                        if (connection != null && !connection.isClosed()) {
                            connection.close();
                        }
                    }
                    catch (SQLException sQLException) {
                        sQLException.printStackTrace();
                    }
                    return stringBuffer;
                }
                try {
                    if (string3 != null && !string3.equals("")) {
                        object = Timestamp.valueOf(this.a(string3));
                        System.out.println(((Timestamp)object).toString());
                        statement.setTimestamp(3, (Timestamp)object);
                    } else {
                        object = n2 + "-" + n3 + "-" + nArray[n3 - 1];
                        serializable2 = Timestamp.valueOf(this.a((String)object));
                        System.out.println((String)object);
                        statement.setTimestamp(3, (Timestamp)serializable2);
                    }
                }
                catch (ParseException parseException) {
                    serializable2 = new StringBuffer("\u7ed3\u675f\u65e5\u671f\u683c\u5f0f\u4e0d\u7b26\u5408\u89c4\u8303");
                    try {
                        if (resultSet != null && !resultSet.isClosed()) {
                            resultSet.close();
                        }
                        if (statement != null && !statement.isClosed()) {
                            statement.close();
                        }
                        if (connection != null && !connection.isClosed()) {
                            connection.close();
                        }
                    }
                    catch (SQLException sQLException) {
                        sQLException.printStackTrace();
                    }
                    return serializable2;
                }
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    object = new PayInfo();
                    ((PayInfo)object).setUserName(resultSet.getString("username"));
                    ((PayInfo)object).setHeroName(resultSet.getString("heroname"));
                    ((PayInfo)object).setContentInfo(resultSet.getString("content"));
                    ((PayInfo)object).setTime(resultSet.getString("time"));
                    arrayList.add(object);
                }
            }
            catch (SQLException sQLException) {
                sQLException.printStackTrace();
            }
            finally {
                try {
                    if (resultSet != null && !resultSet.isClosed()) {
                        resultSet.close();
                    }
                    if (statement != null && !statement.isClosed()) {
                        statement.close();
                    }
                    if (connection != null && !connection.isClosed()) {
                        connection.close();
                    }
                }
                catch (SQLException sQLException) {
                    sQLException.printStackTrace();
                }
            }
        }
        serializable = new StringBuffer();
        ((StringBuffer)serializable).append("<html><head><meta http-equiv='Content-Type' content='text/html; charset=gb2312'></head><body style='text-align:center'>");
        ((StringBuffer)serializable).append("<table border='1px solid' style='font-size:13px;'><tr><th>\u7528\u6237\u540d</th><th>\u89d2\u8272\u540d</th><th>\u91d1\u989d</th><th>\u65f6\u95f4</th></tr>");
        for (Object e2 : arrayList) {
            PayInfo payInfo = (PayInfo)e2;
            ((StringBuffer)serializable).append("<tr>");
            ((StringBuffer)serializable).append("<td>");
            ((StringBuffer)serializable).append(payInfo.getUserName());
            ((StringBuffer)serializable).append("</td>");
            ((StringBuffer)serializable).append("<td>");
            ((StringBuffer)serializable).append(b.do(payInfo.getHeroName()));
            ((StringBuffer)serializable).append("</td>");
            ((StringBuffer)serializable).append("<td>");
            ((StringBuffer)serializable).append(payInfo.getContentInfo());
            ((StringBuffer)serializable).append("</td>");
            ((StringBuffer)serializable).append("<td>");
            ((StringBuffer)serializable).append(payInfo.getTime());
            ((StringBuffer)serializable).append("</td>");
            ((StringBuffer)serializable).append("<tr>");
        }
        ((StringBuffer)serializable).append("</table>");
        ((StringBuffer)serializable).append("<body></html>");
        return serializable;
    }

    public static void main(String[] stringArray) {
        QueryPays queryPays = new QueryPays();
        System.out.println(queryPays.a(null, null, "2009-08-30").toString());
    }

    private String a(String string) throws ParseException {
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String string2 = null;
        try {
            date = simpleDateFormat.parse(string);
        }
        catch (ParseException parseException) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = simpleDateFormat.parse(string);
        }
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        string2 = simpleDateFormat.format(date);
        return string2;
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    private class PayInfo {
        private String do;
        private String int;
        private String if;
        private String for;

        private PayInfo() {
        }

        public String getUserName() {
            return this.do;
        }

        public void setUserName(String string) {
            this.do = string;
        }

        public String getHeroName() {
            return this.int;
        }

        public void setHeroName(String string) {
            this.int = string;
        }

        public String getContentInfo() {
            return this.if;
        }

        public void setContentInfo(String string) {
            this.if = string;
        }

        public String getTime() {
            return this.for;
        }

        public void setTime(String string) {
            this.for = string;
        }
    }
}

