/*
 * Decompiled with CFR 0.152.
 */
package b.a.d;

import a.a.e;
import b.a.b;
import java.sql.Timestamp;
import java.util.Date;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class o
extends b {
    private int ds;
    private String dp;
    private int dq;
    private Timestamp dr;

    public void try(String string) {
        this.dp = string;
    }

    public void a(e e2) {
        super.a(e2);
        this.ds = e2.i();
        this.dp = e2.byte();
        this.dq = e2.i();
        this.dr = new Timestamp(e2.g());
    }

    public void if(e e2) {
        super.if(e2);
        e2.char(this.ds);
        e2.if(this.dp);
        e2.char(this.dq);
        this.dr = new Timestamp(0L);
        e2.a(((Date)this.dr).getTime());
    }

    public int r() {
        return this.ds;
    }

    public void case(int n2) {
        this.ds = n2;
    }

    public int s() {
        return this.dq;
    }

    public void byte(int n2) {
        this.dq = n2;
    }

    public Timestamp u() {
        return this.dr;
    }

    public void a(Timestamp timestamp) {
        this.dr = timestamp;
    }

    public String t() {
        return this.dp;
    }
}

