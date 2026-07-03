/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.web;

import app.a.b;
import app.island.entity.Guild;
import app.island.gs.GameServer;
import app.island.gs.e;
import app.island.gs.o;
import app.island.gs.web.WebServlet;

public class GetGuildList
extends WebServlet {
    public String getResponseText(b b2, GameServer gameServer, o o2) {
        e[] eArray = gameServer.a().d();
        int n2 = gameServer.a().void();
        StringBuffer stringBuffer = new StringBuffer(128 * n2);
        stringBuffer.append("document.write(\"");
        int n3 = 0;
        while (n3 < n2) {
            Guild guild = eArray[n3].e();
            stringBuffer.append("<tr>");
            stringBuffer.append("<td align='center'>");
            stringBuffer.append(guild.name);
            stringBuffer.append("</td>");
            stringBuffer.append("<td align='center'>");
            stringBuffer.append(guild.leader);
            stringBuffer.append("</td>");
            stringBuffer.append("<td align='center'>");
            stringBuffer.append(guild.level);
            stringBuffer.append("</td>");
            stringBuffer.append("<td align='center'>");
            stringBuffer.append(guild.memberList.for());
            stringBuffer.append("</td>");
            stringBuffer.append("<td align='center'>");
            stringBuffer.append(guild.reputation);
            stringBuffer.append("</td>");
            stringBuffer.append("</tr>");
            ++n3;
        }
        stringBuffer.append("\");");
        return stringBuffer.toString();
    }
}

