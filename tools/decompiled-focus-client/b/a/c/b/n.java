/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.d;
import a.b.s;
import b.a.c.b;
import b.a.c.b.al;
import b.a.c.b.e;
import java.awt.event.MouseEvent;

public class n
extends s {
    public static final int b9 = 0;
    public static final int cb = 1;
    private static final int[] b8;
    private b ca;
    private String ce;
    private int cc = 28000;
    private int cd;
    private int b7;
    private long cf;

    public b a8() {
        return this.ca;
    }

    public void a(b b2) {
        this.ca = b2;
    }

    public n(b b2, String string, String string2) {
        this.ca = b2;
        this.ce = string;
        this.setName(string2);
        this.setCursor(al.c7);
        this.enableEvents(48L);
        if (string2.indexOf("tradeInvite") > 0) {
            this.a(new d("\u6765\u81ea\u3010" + string2.substring(0, string2.indexOf(45)) + "\u3011\u7684\u4ea4\u6613\u9080\u8bf7"));
            this.cd = 1;
        } else if (string2.indexOf("teamInvite") > 0) {
            this.a(new d("\u6765\u81ea\u3010" + string2.substring(0, string2.indexOf(45)) + "\u3011\u7684\u7ec4\u961f\u9080\u8bf7"));
        } else if (string2.indexOf("join") > 0 || string2.indexOf("guildInvite") > 0) {
            this.cd = 2;
            this.a(new d("\u6765\u81ea\u3010" + string2.substring(0, string2.indexOf(45)) + "\u3011\u7684\u516c\u4f1a\u7533\u8bf7"));
        } else if (string2.indexOf("studentInvite") > 0) {
            this.cd = 2;
            this.a(new d("\u6765\u81ea\u3010" + string2.substring(0, string2.indexOf(45)) + "\u3011\u7684\u5e08\u5f92\u9080\u8bf7"));
        }
    }

    public void a(c c2) {
        c2.a(e.aZ, 0, 0, 24 * this.cd, 120, 24, 24, b8[this.b7], 0);
    }

    protected void processMouseEvent(MouseEvent mouseEvent) {
        if (mouseEvent.getID() == 501) {
            if (this.ca.for().Q > 0) {
                this.ca.new().if(this.ce, -1, "confirm:" + this.getName(), "cancel:" + this.getName(), this.ca);
                this.cc = 0;
            } else {
                String string = "\u4f60\u5df2\u7ecf\u6b7b\u4e86\uff0c\u4e0d\u80fd\u8fdb\u884c\u8be5\u9879\u64cd\u4f5c\uff0c\u4f60\u8981\u590d\u6d3b\u5417\uff1f";
                this.ca.new().if(string, -16711681, "relive", "", this.ca.e());
            }
        }
        super.processMouseEvent(mouseEvent);
    }

    public int a7() {
        return this.cc;
    }

    public void g(int n2) {
        this.cc = n2;
    }

    public void a(long l2) {
        if (l2 - this.cf > 100L) {
            this.cf = l2;
            this.b7 = (this.b7 + 1) % b8.length;
            this.cc -= 100;
        }
    }

    static {
        int[] nArray = new int[6];
        nArray[3] = 1;
        nArray[4] = 1;
        nArray[5] = 1;
        b8 = nArray;
    }

    public boolean a9() {
        return this.cc > 0;
    }
}

