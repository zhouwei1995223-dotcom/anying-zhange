/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.web;

import app.a.b;
import app.island.gs.GameServer;
import app.island.gs.o;
import app.island.gs.web.WebServlet;

public class Command
extends WebServlet {
    public String getResponseText(b b2, GameServer gameServer, o o2) {
        String string = b2.if("cmd");
        return gameServer.if(string);
    }
}

