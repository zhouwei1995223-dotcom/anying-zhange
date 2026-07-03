/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.c;

import app.island.entity.VoteRecord;
import app.island.gs.GameServer;
import app.island.gs.c;
import app.island.gs.h;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class a
implements Runnable {
    h do;
    private VoteRecord a;
    private String if = "http://192.168.1.38/vote/PostVoteServlet.jsp?id=";

    public a(VoteRecord voteRecord, h h2) {
        this.do = h2;
        this.a = voteRecord;
    }

    public void run() {
        String string = null;
        try {
            this.if = this.if + this.a.getSubjectId() + "&votename=" + this.a.getVoteName() + "&selected=" + this.a.getSelectId();
            string = new String(c.a(new URL(this.if)), "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            string = "\u6295\u7968\u5f02\u5e38";
            unsupportedEncodingException.printStackTrace();
        }
        catch (MalformedURLException malformedURLException) {
            string = "\u6295\u7968\u5f02\u5e38";
            malformedURLException.printStackTrace();
        }
        catch (IOException iOException) {
            string = "\u6295\u7968\u5f02\u5e38";
            iOException.printStackTrace();
        }
        if (string.equals("\u6295\u7968\u6210\u529f")) {
            GameServer.try().if(new Runnable(){
                {
                    a.this.getClass();
                }

                public void run() {
                    a.this.do.for("\u8c22\u8c22\u6295\u7968");
                    a.this.do.do("\u8c22\u8c22\u6295\u7968");
                }
            });
        } else {
            GameServer.try().if(new Runnable(){
                {
                    a.this.getClass();
                }

                public void run() {
                }
            });
        }
    }
}

