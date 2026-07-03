/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.c;

import app.island.data.Question;
import app.island.data.SpecialProperty;
import app.island.gs.GameServer;
import app.island.gs.ServerInfo;
import app.island.gs.c;
import app.island.gs.h;
import app.island.gs.p;
import daff.a.b;
import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class g
implements Runnable {
    private static Question[] int;
    private static final String for = "http://192.168.1.27:8080/itempool/QuestionsServlet";
    private URL do;
    h if;
    int a = 0;
    private SpecialProperty new;

    public static void a(h h2, SpecialProperty specialProperty) {
        if (h2.u() != null) {
            h2.try("\u6b63\u5728\u7b54\u9898\u4e2d,\u65e0\u6cd5\u8fdb\u884c\u4e0b\u4e00\u6b21\u7b54\u9898,\u7b54\u9898\u5238\u5c06\u8fd4\u8fd8");
            h2.a(specialProperty);
            return;
        }
        h2.a(app.island.gs.g.a(-1, null, h2));
        g g2 = new g();
        g2.new = specialProperty;
        g2.a = specialProperty.parameter1;
        try {
            g2.do = ServerInfo.questionUrl == null || ServerInfo.questionUrl.length() == 0 ? new URL(for) : new URL(ServerInfo.questionUrl);
        }
        catch (MalformedURLException malformedURLException) {
            h2.try("\u7b54\u9898\u7cfb\u7edf\u7ef4\u62a4\u4e2d,\u7b54\u9898\u5238\u5c06\u8fd4\u8fd8");
            h2.a(specialProperty);
            return;
        }
        g2.if = h2;
        GameServer.try().a(g2);
    }

    private g() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        String string = "";
        try {
            string = new String(c.a(this.do));
        }
        catch (ConnectException connectException) {
            connectException.printStackTrace();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        boolean bl = false;
        Question[] questionArray = null;
        if (!string.equals("")) {
            String[] stringArray = b.a(string, "\r\n");
            int n2 = 0;
            int n3 = 0;
            while (n3 < stringArray.length) {
                String[] stringArray2 = b.a(stringArray[n3], "\t");
                int n4 = stringArray2.length;
                if (n4 > 2) {
                    ++n2;
                }
                ++n3;
            }
            questionArray = new Question[n2];
            n3 = 0;
            int n5 = 0;
            while (n5 < stringArray.length) {
                String[] stringArray3 = b.a(stringArray[n5], "\t");
                int n6 = stringArray3.length;
                if (n6 > 2) {
                    String[] stringArray4 = new String[n6 - 2];
                    int n7 = 1;
                    while (n7 < n6 - 1) {
                        stringArray4[n7 - 1] = stringArray3[n7];
                        ++n7;
                    }
                    int n8 = 0;
                    try {
                        n8 = Integer.parseInt(stringArray3[n6 - 1]);
                    }
                    catch (NumberFormatException numberFormatException) {
                        bl = true;
                        System.out.println("\u9898\u76ee:" + stringArray3[0] + " \u7b54\u6848\u4e3a\u975e\u6570\u5b57,\u8bf7\u68c0\u67e5");
                        break;
                    }
                    questionArray[n3] = new Question(stringArray3[0], stringArray4, n8, n6 - 2, this.a);
                    ++n3;
                }
                ++n5;
            }
        }
        if (questionArray == null || bl) {
            if (int == null) {
                this.if.try("\u7b54\u9898\u7cfb\u7edf\u7ef4\u62a4\u4e2d,\u7b54\u9898\u5238\u5c06\u8fd4\u8fd8");
                this.if.a(this.new);
                return;
            }
            questionArray = int;
        } else {
            int = questionArray;
        }
        final app.island.gs.g g2 = app.island.gs.g.a(this.a, questionArray, this.if);
        this.if.a(g2);
        GameServer.try().if(new Runnable(this){
            final /* synthetic */ g this$0;
            {
                this.this$0 = g22;
                this.this$0.getClass();
            }

            public void run() {
                this.this$0.if.a(p.c(this.this$0.a, g2.do()));
            }
        });
    }
}

