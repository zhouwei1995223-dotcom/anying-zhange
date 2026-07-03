/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.npc;

import app.island.GameObject;
import app.island.data.Goods;
import app.island.gs.ServerInfo;
import app.island.gs.h;
import app.island.gs.npc.NpcScript;
import app.island.gs.w;
import daff.a.b;
import daff.a.q;
import java.io.File;

public class PrizeProvider
extends NpcScript {
    private q e = new q(1000);
    private long d;
    private long f;

    private void a(File file) {
        if (!file.exists()) {
            return;
        }
        long l2 = file.lastModified();
        if (l2 <= this.f) {
            return;
        }
        this.f = l2;
        byte[] byArray = b.a(file);
        String string = new String(byArray);
        String[] stringArray = b.a(string, "\r\n");
        int n2 = 0;
        while (n2 < stringArray.length) {
            String[] stringArray2;
            if (stringArray[n2].length() <= 0 || (stringArray2 = b.a(stringArray[n2], "\t")).length < 2) break;
            this.a(stringArray2[0], Integer.parseInt(stringArray2[1]));
            ++n2;
        }
    }

    public void update() {
        long l2 = ServerInfo.currentMilliSecond;
        if (l2 - this.d > 30000L) {
            this.d = l2;
            File file = new File("config/npc/prize.txt");
            this.a(file);
        }
    }

    private void a(String string, int n2) {
        Goods goods;
        daff.a.h h2 = (daff.a.h)this.e.for(string);
        if (h2 == null) {
            h2 = new daff.a.h(8);
            this.e.a((Object)string, (Object)h2);
        }
        if ((goods = w.case().getGoods(n2)) != null) {
            goods = (Goods)GameObject.cloneObject(goods);
            this.getController().for().do().a(goods);
            h2.if(goods);
        }
    }

    public void init() {
        File file = new File("config/npc/prize.txt");
        if (file.exists()) {
            this.f = file.lastModified();
            this.d = ServerInfo.currentMilliSecond + 60000L;
        }
    }

    public void processCommand(String string, h h2) {
        if (string.equals("viewMine")) {
            daff.a.h h3 = (daff.a.h)this.e.for(h2.b());
            if (h3 == null || h3.int()) {
                this.a.a("none", h2);
            } else if (h3.for() > 0) {
                this.a.a((String)"prize").int = "\u8fd9\u91cc\u6709\u4f60\u7684\u5956\u54c1\uff0c\u4e00\u5171" + h3.for() + "\u4ef6\uff0c\u4f60\u8981\u9886\u53d6\u5417\uff1f\u9886\u53d6\u524d\u8bf7\u5148\u786e\u8ba4\u4f60\u7684\u80cc\u5305\u6709\u8db3\u591f\u7684\u7a7a\u95f4\uff01";
                this.a.a("prize", h2);
            }
        } else if (string.equals("getMine")) {
            daff.a.h h4 = (daff.a.h)this.e.for(h2.b());
            if (h4.for() > 0) {
                int n2 = 0;
                while (n2 < h4.for()) {
                    Goods goods = (Goods)h4.if(n2);
                    h2.a(goods);
                    ++n2;
                }
                h4.a();
                h2.try("\u5168\u90e8\u7269\u54c1\u5df2\u7ecf\u653e\u5165\u4f60\u7684\u80cc\u5305\uff0c\u8bf7\u67e5\u6536");
            } else {
                h2.try("\u6ca1\u6709\u4f60\u7684\u7269\u54c1");
            }
        }
    }
}

