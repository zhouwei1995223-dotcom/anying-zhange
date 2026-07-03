/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.web;

import app.island.gs.GameServer;
import app.island.gs.o;
import app.island.gs.web.DBConnectionUtil;
import app.island.gs.web.WebServlet;
import daff.a.b;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class QueryDatabase
extends WebServlet {
    private static final String char = "";
    private Connection else;
    private PreparedStatement long;
    private ResultSet case;
    private ResultSetMetaData goto;

    public String getResponseText(app.a.b b2, GameServer gameServer, o o2) {
        String string = b2.if("sql");
        if (!this.if(string)) {
            return "error:illegal sql statement";
        }
        this.else = DBConnectionUtil.getConnection();
        if (this.else == null) {
            return "error: no database";
        }
        try {
            StringBuffer stringBuffer = new StringBuffer(1024);
            String string2 = char;
            synchronized (char) {
                this.long = this.else.prepareStatement(string);
                this.case = this.long.executeQuery();
                this.goto = this.case.getMetaData();
                int n2 = this.goto.getColumnCount();
                int n3 = 1;
                while (n3 <= n2) {
                    stringBuffer.append(this.goto.getColumnName(n3));
                    if (n3 == n2) {
                        stringBuffer.append("\r\n");
                    } else {
                        stringBuffer.append("\t");
                    }
                    ++n3;
                }
                while (this.case.next()) {
                    n3 = 1;
                    while (n3 <= n2) {
                        String string3 = b.do(this.case.getString(n3));
                        stringBuffer.append(string3);
                        if (n3 == n2) {
                            stringBuffer.append("\r\n");
                        } else {
                            stringBuffer.append("\t");
                        }
                        ++n3;
                    }
                }
                Object var10_11 = null;
                // ** MonitorExit[var9_7] (shouldn't be in output)
                this.case.close();
                this.long.close();
                this.else.close();
                return stringBuffer.toString();
            }
        }
        catch (SQLException sQLException) {
            sQLException.printStackTrace();
            return "error";
        }
    }

    private boolean if(String string) {
        return string.toLowerCase().startsWith("select * from userlogs");
    }

    public boolean checkPassword(String string) {
        return true;
    }
}

