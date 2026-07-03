/*
 * Decompiled with CFR 0.152.
 */
package b.a.d;

import a.a.e;
import java.sql.Timestamp;
import java.util.Date;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class b
extends b.a.b {
    private int if;
    private String j8;
    private String j7;
    private String j5;
    private Timestamp j6;
    private Timestamp j3;
    private boolean j4;

    public int Z() {
        return this.if;
    }

    public void p(int n2) {
        this.if = n2;
    }

    public void a(e e2) {
        super.a(e2);
        this.if = e2.i();
        this.j8 = e2.byte();
        this.j7 = e2.byte();
        this.j5 = e2.byte();
        this.j4 = e2.c();
        this.j6 = new Timestamp(e2.g());
        this.j3 = new Timestamp(e2.g());
    }

    public void if(e e2) {
        super.if(e2);
        e2.char(this.if);
        e2.if(this.j8);
        e2.if(this.j7);
        e2.if(this.j5);
        e2.a(this.j4);
        e2.a(((Date)this.j6).getTime());
        e2.a(((Date)this.j3).getTime());
    }

    public String ab() {
        return this.j7;
    }

    public void i(String string) {
        this.j7 = string;
    }

    public void do(boolean bl) {
        this.j4 = bl;
    }

    public boolean aa() {
        return this.j4;
    }

    public Timestamp Y() {
        return this.j3;
    }

    public void do(Timestamp timestamp) {
        this.j3 = timestamp;
    }

    public String X() {
        return this.j8;
    }

    public void k(String string) {
        this.j8 = string;
    }

    public Timestamp W() {
        return this.j6;
    }

    public String ac() {
        return this.j5;
    }

    public void j(String string) {
        this.j5 = string;
    }

    public void if(Timestamp timestamp) {
        this.j6 = timestamp;
    }
}

