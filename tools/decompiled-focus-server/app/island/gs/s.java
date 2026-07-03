/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  app.island.gs.c.b
 *  app.island.gs.c.h
 *  app.island.gs.c.j
 */
package app.island.gs;

import app.island.entity.VoteRecord;
import app.island.gs.GameServer;
import app.island.gs.c.a;
import app.island.gs.c.b;
import app.island.gs.c.j;
import app.island.gs.h;
import daff.a.e;

public class s {
    public void a(h h2, int n2, e e2) {
        switch (n2) {
            case 3328: {
                GameServer.try().a((Runnable)new j(h2));
                break;
            }
            case 3329: {
                int n3 = e2.i();
                GameServer.try().a((Runnable)new b(h2, n3));
                break;
            }
            case 3330: {
                VoteRecord voteRecord = new VoteRecord();
                voteRecord.setSubjectId(e2.i());
                voteRecord.setSelectId(e2.i());
                voteRecord.setVoteName(h2.r().user.name);
                GameServer.try().a(new a(voteRecord, h2));
                GameServer.try().a((Runnable)new app.island.gs.c.h(voteRecord.getSubjectId(), h2));
                break;
            }
        }
    }
}

