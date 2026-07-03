/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.web;

import app.island.gs.GameServer;
import app.island.gs.ServerInfo;
import app.island.gs.o;
import app.island.gs.web.WebServlet;
import daff.a.b;

public class GetGameInfo
extends WebServlet {
    public String getResponseText(app.a.b b2, GameServer gameServer, o o2) {
        StringBuffer stringBuffer = new StringBuffer(1024);
        stringBuffer.append("<h1 align=center>\u670d\u52a1\u5668\u7edf\u8ba1\u4fe1\u606f</h1>");
        stringBuffer.append("<table border=1 width=400 align='center'>");
        stringBuffer.append("<TR><TD align=\"right\">\u670d\u52a1\u5668\u5f00\u542f\u65f6\u95f4\uff1a</TD><TD>");
        stringBuffer.append(b.a(ServerInfo.launchTime));
        stringBuffer.append("</TD></TR><TR><TD align=\"right\">\u5f53\u524d\u5728\u7ebf\u73a9\u5bb6\u6570\uff1a</TD><TD>");
        stringBuffer.append(gameServer.a().byte());
        stringBuffer.append("</TD></TR><TR><TD align=\"right\">\u5e73\u5747\u5728\u7ebf\u73a9\u5bb6\u6570\uff1a</TD><TD>");
        stringBuffer.append(ServerInfo.averageOnlineCount);
        stringBuffer.append("</TD></TR><TR><TD align=\"right\">\u6700\u5927\u5728\u7ebf\u73a9\u5bb6\u6570\uff1a</TD><TD>");
        stringBuffer.append(ServerInfo.maxOnlineCount);
        stringBuffer.append("</TD></TR><TR><TD align=\"right\">\u6700\u5927\u5728\u7ebf\u65f6\u95f4\u70b9\uff1a</TD><TD>");
        stringBuffer.append(b.do(ServerInfo.onlinePeakTime));
        stringBuffer.append("</TD></TR><TR><TD align=\"right\">\u5f53\u524d\u5143\u5b9d\u6d88\u8d39\u6570\uff1a</TD><TD>");
        stringBuffer.append(ServerInfo.consumedTreasure);
        stringBuffer.append("</TD></TR><TR><TD align=\"right\">\u5f53\u524d\u5143\u5b9d\u6389\u843d\u6570\uff1a</TD><TD>");
        stringBuffer.append(ServerInfo.dropedTreasure);
        stringBuffer.append("</TD></TR><TR><TD align=\"right\">\u5f53\u524d\u5143\u5b9d\u5145\u503c\u6570\uff1a</TD><TD>");
        stringBuffer.append(ServerInfo.payedTreasure);
        stringBuffer.append("</TD></TR><TR><TD align=\"right\">\u670d\u52a1\u5668\u5e10\u53f7\u603b\u6570\uff1a</TD><TD>");
        stringBuffer.append(gameServer.new().int());
        stringBuffer.append("</TD></TR><TR><TD align=\"right\">\u670d\u52a1\u5668\u89d2\u8272\u603b\u6570\uff1a</TD><TD>");
        stringBuffer.append(gameServer.new().new());
        stringBuffer.append("</TD></TR>");
        stringBuffer.append("</table>");
        return stringBuffer.toString();
    }
}

