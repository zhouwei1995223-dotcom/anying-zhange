/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.web;

import app.a.b;
import app.island.gs.GameServer;
import app.island.gs.o;

public abstract class WebServlet {
    public abstract String getResponseText(b var1, GameServer var2, o var3);

    public String getContentType() {
        return "text/html";
    }

    public boolean checkPassword(String string, o o2) {
        return o2.if().equals(string);
    }
}

