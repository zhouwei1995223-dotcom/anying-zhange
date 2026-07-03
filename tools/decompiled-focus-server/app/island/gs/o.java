/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs;

import app.a.a;
import app.a.c;
import app.a.d;
import app.a.e;
import app.a.f;
import app.island.gs.GameServer;
import app.island.gs.web.WebServlet;
import daff.a.b;
import daff.a.i;
import java.io.IOException;
import java.net.Socket;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class o
implements d,
f {
    GameServer do;
    private c for;
    private String if = "";
    private String a = "";

    public void a(e e2) throws IOException {
        app.a.b b2 = e2.for();
        a a2 = e2.a();
        String string = b2.a();
        String string2 = b2.if("pwd");
        String string3 = "";
        if (string.length() < 3) {
            string3 = "0,invalid filename";
        } else {
            Object object = b.char("app.island.gs.web." + string);
            if (object != null && object instanceof WebServlet) {
                WebServlet webServlet = (WebServlet)object;
                if (!webServlet.checkPassword(string2, this)) {
                    string3 = "0,invalid password";
                } else {
                    try {
                        string3 = webServlet.getResponseText(b2, this.do, this);
                    }
                    catch (Throwable throwable) {
                        string3 = b.a(throwable);
                    }
                }
            } else {
                string3 = "invalid access:" + string;
            }
        }
        a2.int(string3);
        a2.for();
        e2.if();
    }

    public void for() {
        try {
            this.for.long();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public String do() {
        return this.a;
    }

    public void a(String string) {
        this.a = string;
    }

    public o(GameServer gameServer) {
        this.do = gameServer;
    }

    public String if() {
        return this.if;
    }

    public void if(String string) {
        this.if = string;
    }

    public boolean a(Socket socket) {
        if (this.a == null || this.a.length() < 7) {
            return true;
        }
        String string = socket.getInetAddress().getHostAddress();
        return this.a.indexOf(string) >= 0;
    }

    public void a() {
        try {
            this.for.else();
            System.out.println("start web interface at:" + this.for.char());
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public void a(i i2) {
        i i3 = i2.a("port");
        int n2 = 8080;
        if (i3 != null && i3.for().length() > 0) {
            n2 = Integer.parseInt(i3.for());
        }
        if ((i3 = i2.a("password")) != null) {
            this.if = i3.for();
        }
        if ((i3 = i2.a("ipList")) != null) {
            this.a = i3.for();
        }
        this.for = new c(n2);
        this.for.a(this);
        this.for.a(this);
    }
}

