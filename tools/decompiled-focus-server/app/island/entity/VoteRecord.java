/*
 * Decompiled with CFR 0.152.
 */
package app.island.entity;

import app.island.GameObject;
import daff.a.e;
import java.sql.Timestamp;
import java.util.Date;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class VoteRecord
extends GameObject {
    private int else;
    private String byte;
    private int case;
    private Timestamp char;

    public void setVoteName(String string) {
        this.byte = string;
    }

    public void readFrom(e e2) {
        super.readFrom(e2);
        this.else = e2.i();
        this.byte = e2.byte();
        this.case = e2.i();
        this.char = new Timestamp(e2.g());
    }

    public void writeTo(e e2) {
        super.writeTo(e2);
        e2.char(this.else);
        e2.if(this.byte);
        e2.char(this.case);
        this.char = new Timestamp(0L);
        e2.a(((Date)this.char).getTime());
    }

    public int getSubjectId() {
        return this.else;
    }

    public void setSubjectId(int n2) {
        this.else = n2;
    }

    public int getSelectId() {
        return this.case;
    }

    public void setSelectId(int n2) {
        this.case = n2;
    }

    public Timestamp getSelectTime() {
        return this.char;
    }

    public void setSelectTime(Timestamp timestamp) {
        this.char = timestamp;
    }

    public String getVoteName() {
        return this.byte;
    }
}

