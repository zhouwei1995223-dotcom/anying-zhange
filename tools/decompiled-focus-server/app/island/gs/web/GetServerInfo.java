/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.web;

import app.a.b;
import app.island.gs.GameServer;
import app.island.gs.ServerInfo;
import app.island.gs.o;
import app.island.gs.web.WebServlet;

public class GetServerInfo
extends WebServlet {
    public String getContentType() {
        return "text/plain";
    }

    public String getResponseText(b b2, GameServer gameServer, o o2) {
        return ServerInfo.encodeInfoToXML().toString();
    }
}

