/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.c;

import app.island.gs.GameServer;
import app.island.gs.ServerInfo;
import app.island.gs.c;
import app.island.gs.h;
import app.island.gs.p;
import app.island.gs.w;
import java.io.IOException;
import java.net.ConnectException;
import java.net.URL;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class e {
    String for = null;
    String int = null;
    String new = null;
    h a;
    String do = "";
    public a if = new a();

    public e(String string, h h2) {
        this.for = string;
        this.a = h2;
        this.int = h2.r().user.name;
        this.new = h2.r().name;
    }

    class a
    implements Runnable {
        a() {
            e.this.getClass();
        }

        public void run() {
            try {
                try {
                    String string = ServerInfo.getPrizesUrl + "?code=" + e.this.for + "&userName=" + e.this.int + "&heroName=" + e.this.new + "";
                    e.this.do = new String(c.a(new URL(string)));
                    GameServer.try().if(new b());
                }
                catch (ConnectException connectException) {
                    connectException.printStackTrace();
                    e.this.a.new("\u7f51\u7edc\u8fde\u63a5\u9519\u8bef,\u8bf7\u7a0d\u5019\u518d\u8bd5!");
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                    e.this.a.new("\u7f51\u7edc\u8fde\u63a5\u9519\u8bef,\u8bf7\u7a0d\u5019\u518d\u8bd5!");
                }
                Object var3_4 = null;
                e.this.a.a(p.case());
            }
            catch (Throwable throwable) {
                Object var3_5 = null;
                e.this.a.a(p.case());
                throw throwable;
            }
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    class b
    implements Runnable {
        int a;
        int do;
        daff.a.h if;

        b() {
            e.this.getClass();
            this.a = 0;
            this.do = 0;
            this.if = new daff.a.h();
        }

        public void run() {
            if (e.this.do.equals("error")) {
                e.this.a.new("\u6ca1\u6709\u8be5\u6ce8\u518c\u7801\u6216\u8005\u4e0e\u5bf9\u5e94\u7684\u5956\u52b1\u8d26\u53f7\u4e0d\u7b26\u5408!");
            } else if (e.this.do.equals("used")) {
                e.this.a.new("\u8be5\u5361\u5df2\u4f7f\u7528\u8fc7!");
            } else {
                String[] stringArray = daff.a.b.a(e.this.do, "\r\n");
                int n2 = 0;
                while (n2 < stringArray.length) {
                    if (stringArray[n2].trim().length() == 0) break;
                    String[] stringArray2 = daff.a.b.a(stringArray[n2], "\t");
                    int n3 = Integer.parseInt(stringArray2[0]);
                    e.this.a.new(n3);
                    this.a += n3;
                    int n4 = Integer.parseInt(stringArray2[1]);
                    e.this.a.try(n4);
                    this.do += n4;
                    int n5 = Integer.parseInt(stringArray2[2]);
                    e.this.a.a(w.case().getGoods(n5));
                    this.if.do(n5);
                    ++n2;
                }
                String string = "\u606d\u559c\u60a8\u83b7\u5f97\u91d1\u5e01\uff1a" + this.a + "\uff0c\u5143\u5b9d\uff1a" + this.do + "\uff0c\u83b7\u5f97\u7269\u54c1\uff1a";
                int n6 = 0;
                while (n6 < this.if.for()) {
                    string = string + w.case().getGoods((int)Integer.parseInt((String)this.if.if((int)n6).toString())).name;
                    if (n6 != this.if.for() - 1) {
                        string = string + "\u3001";
                    }
                    ++n6;
                }
                string = string + "\u3002";
                e.this.a.for(string);
            }
        }
    }
}

