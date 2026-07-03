/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.web;

import app.island.entity.User;
import app.island.gs.GameServer;
import app.island.gs.o;
import app.island.gs.web.GetPayList;
import app.island.gs.web.WebServlet;
import daff.a.b;
import java.io.File;

public class UserPay
extends WebServlet {
    public String getResponseText(app.a.b b2, GameServer gameServer, o o2) {
        String string = b2.if("name");
        String string2 = b2.if("orderID");
        String string3 = b2.if("amount");
        String string4 = b2.if("code");
        if (string4.length() == 32 && !string4.equalsIgnoreCase(b.if(string + string2 + string3 + o2.if()))) {
            return "0,invalid code";
        }
        String string5 = string;
        String string6 = string2;
        if (string6.length() < 5 || string6.length() > 32) {
            return "0,invalid pay order:" + string6;
        }
        int n2 = -1;
        try {
            n2 = Integer.parseInt(string3);
        }
        catch (NumberFormatException numberFormatException) {
            return "0,invalid pay amount:" + b2.if("amount");
        }
        File file = new File("data/pay_logs/" + string6 + ".txt");
        if (file.exists()) {
            return "0,pay order repeated:" + string6;
        }
        User user = gameServer.new().a(string5);
        if (user == null) {
            File file2 = new File("data/pay_queue/" + string5 + "/" + string6 + ".txt");
            if (file2.exists()) {
                return "0,pay order repeated:" + string6;
            }
            String string7 = String.valueOf(n2);
            b.a(file2, string7.getBytes());
            return "1,user not exits:" + string5;
        }
        GameServer gameServer2 = gameServer;
        synchronized (gameServer2) {
            File file3 = new File("data/pay_logs/" + string6 + ".txt");
            if (file3.exists()) {
                String string8 = "0,pay order repeated:" + string6;
                Object var16_19 = null;
                return string8;
            }
            String string9 = string5 + "\t" + n2 + "\t" + user.adOwner;
            b.a(file3, string9.getBytes());
            gameServer.a(user, n2);
            GetPayList.dataChanged = true;
            Object var16_20 = null;
        }
        return "1,success:" + string6;
    }
}

