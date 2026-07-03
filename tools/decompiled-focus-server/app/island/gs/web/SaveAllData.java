/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.web;

import app.island.GameObject;
import app.island.a;
import app.island.entity.Hero;
import app.island.entity.User;
import app.island.gs.GameServer;
import app.island.gs.c;
import app.island.gs.o;
import app.island.gs.web.WebServlet;
import daff.a.b;
import daff.a.h;
import daff.a.i;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SaveAllData
extends WebServlet {
    private void a(User user, Connection connection) {
        byte[] byArray = this.a(user);
        byte[] byArray2 = this.a(user.store);
        try {
            byte[] byArray3;
            Hero hero;
            PreparedStatement preparedStatement = connection.prepareStatement("update users set data=?,store=? where id=?");
            preparedStatement.setBytes(1, byArray);
            preparedStatement.setBytes(2, byArray2);
            preparedStatement.setInt(3, user.id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            preparedStatement = null;
            int n2 = 0;
            while (n2 < user.heroes.length) {
                hero = user.heroes[n2];
                if (hero != null) {
                    if (preparedStatement == null) {
                        preparedStatement = connection.prepareStatement("update heroes set data=?,depot=?,spells=?,shortcuts=?,friends=?,tasks=?,name=? where id=?");
                    }
                    byArray3 = this.a(hero);
                    byte[] byArray4 = this.a(hero.personalDepot);
                    byte[] byArray5 = this.a(hero.spellList);
                    byte[] byArray6 = this.a(hero.shortCuts);
                    byte[] byArray7 = this.a(hero.friendList);
                    byte[] byArray8 = this.a(hero.taskList);
                    preparedStatement.setBytes(1, byArray3);
                    preparedStatement.setBytes(2, byArray4);
                    preparedStatement.setBytes(3, byArray5);
                    preparedStatement.setBytes(4, byArray6);
                    preparedStatement.setBytes(5, byArray7);
                    preparedStatement.setBytes(6, byArray8);
                    preparedStatement.setString(7, b.case(hero.name));
                    preparedStatement.setInt(8, user.heroes[n2].id);
                    preparedStatement.executeUpdate();
                }
                ++n2;
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            preparedStatement = null;
            n2 = 0;
            do {
                if ((hero = user.heroes[n2]) == null || hero.joinedGuild == null || hero.joinedGuild.deleted) continue;
                if (preparedStatement == null) {
                    preparedStatement = connection.prepareStatement("update guilds set name=?,data=? where id=?");
                }
                byArray3 = this.a(hero.joinedGuild);
                preparedStatement.setString(1, b.case(hero.joinedGuild.name));
                preparedStatement.setBytes(2, byArray3);
                preparedStatement.setInt(3, hero.joinedGuild.id);
                preparedStatement.executeUpdate();
                hero.joinedGuild.dataChanged = false;
            } while (++n2 < 3);
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
    }

    private void a(byte[] byArray) {
    }

    private byte[] a(GameObject gameObject) {
        if (gameObject == null) {
            return null;
        }
        i i2 = a.a().a(gameObject);
        String string = i2.toString();
        byte[] byArray = string.getBytes();
        this.a(byArray);
        return byArray;
    }

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
        c c2 = gameServer.new();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/" + string, string2, string3);
            h h2 = new h(1000);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select username from userlogs where category='userLogin' group by username");
            while (resultSet.next()) {
                h2.if(b.do(resultSet.getString("username")));
            }
            resultSet.close();
            statement.close();
            int n2 = h2.for();
            StringBuffer stringBuffer = new StringBuffer(n2 * 50);
            stringBuffer.append("UserCount:");
            stringBuffer.append(n2);
            stringBuffer.append("<BR>");
            int n3 = 0;
            int n4 = 0;
            while (n4 < n2) {
                User user = c2.a((String)h2.if(n4));
                if (user != null) {
                    this.a(user, connection);
                    stringBuffer.append("Saved:");
                    stringBuffer.append(user.name);
                    stringBuffer.append("<BR>");
                    ++n3;
                }
                ++n4;
            }
            stringBuffer.append("SaveCount:" + n3);
            if (connection != null) {
                connection.close();
            }
            return stringBuffer.toString();
        }
        catch (Throwable throwable) {
            return b.a(throwable);
        }
    }
}

