/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.npc;

import app.island.GameObject;
import app.island.data.Goods;
import app.island.gs.h;
import app.island.gs.npc.NpcScript;
import app.island.gs.v;

public class ArenaPrizeProvider
extends NpcScript {
    protected boolean x = false;

    public void processCommand(String string, h h2) {
        if (string.equals("stopDeliveringPrize") && h2.r().gmGrade > 0) {
            this.x = false;
            h2.for("\u5956\u54c1\u53d1\u653e\u5df2\u7ecf\u505c\u6b62");
        } else if (string.equals("beginToDeliverPrize") && h2.r().gmGrade > 0) {
            this.x = true;
            h2.for("\u5956\u54c1\u53d1\u653e\u5df2\u7ecf\u5f00\u59cb");
        } else if (string.equals("claimPrize") && this.x && this.a(h2)) {
            v v2 = this.a.new();
            if (v2 != null) {
                int n2 = 0;
                int n3 = v2.j();
                int n4 = 0;
                while (n4 < n3) {
                    Goods goods = v2.new(n4);
                    if (goods != null) {
                        goods = (Goods)GameObject.cloneObject(goods);
                        this.a.for().do().a(goods);
                        h2.a(goods);
                        ++n2;
                    }
                    ++n4;
                }
                if (n2 > 0) {
                    h2.for("\u606d\u559c\u4f60\u83b7\u5f97\u80dc\u5229\uff01\u5df2\u7ecf\u628a" + n2 + "\u4e2a\u5956\u54c1\u53d1\u653e\u7ed9\u4f60\uff0c\u8bf7\u67e5\u6536");
                } else {
                    this.a.a("noPrize", h2);
                }
                this.x = false;
            } else {
                this.a.a("noPrize", h2);
            }
        } else if (string.equals("setPrizeDeliverStatus") && h2.r().gmGrade > 0) {
            if (this.x) {
                this.a.a("stopDeliveringPrize", h2);
            } else {
                this.a.a("beginToDeliverPrize", h2);
            }
        }
    }

    private boolean a(h h2) {
        return this.a.for().s() == 1 && !h2.i() && h2.goto();
    }

    public String getResponseDailogEntry(h h2) {
        if (this.a.for().K() != 1) {
            return null;
        }
        if (h2.r().gmGrade > 0) {
            return "gmEntry";
        }
        if (!this.x) {
            return "prizeIsNotDelivering";
        }
        if (this.a(h2)) {
            return "lastOneStanding";
        }
        return "notLastOneStanding";
    }
}

