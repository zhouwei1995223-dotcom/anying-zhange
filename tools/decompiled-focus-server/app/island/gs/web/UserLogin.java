/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.web;

import app.a.b;
import app.island.entity.User;
import app.island.gs.GameServer;
import app.island.gs.o;
import app.island.gs.web.WebServlet;

public class UserLogin
extends WebServlet {
    public String getResponseText(b b2, GameServer gameServer, o o2) {
        String string;
        String string2 = b2.if("username");
        if (string2.length() == 0) {
            string2 = b2.if("name");
        }
        if ((string = b2.if("userPassword")).length() == 0) {
            string = b2.if("userPwd");
        }
        if (string2.length() < 2 || string.length() < 2) {
            return "0,invalid name or password";
        }
        User user = gameServer.new().a(string2);
        if (user != null && user.online) {
            return "0,user of this name is online";
        }
        gameServer.new().a(string2, string);
        return "1";
    }
}

