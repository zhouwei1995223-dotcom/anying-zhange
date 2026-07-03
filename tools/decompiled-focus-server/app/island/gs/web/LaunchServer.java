/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.web;

import app.island.gs.GameServer;
import app.island.gs.o;
import app.island.gs.web.WebServlet;
import daff.a.b;

public class LaunchServer
extends WebServlet {
    public String getResponseText(app.a.b b2, GameServer gameServer, o o2) {
        String string = b2.if("file");
        if (string.length() < 1) {
            string = "run.bat";
        }
        String string2 = "OK";
        try {
            Process process = Runtime.getRuntime().exec(string);
            System.out.println(string);
            System.out.println(process);
            System.exit(0);
        }
        catch (Exception exception) {
            string2 = b.a(exception);
        }
        return string2;
    }
}

