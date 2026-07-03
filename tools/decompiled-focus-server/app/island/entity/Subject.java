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
public class Subject
extends GameObject {
    private int id;
    private String try;
    private String new;
    private String for;
    private Timestamp int;
    private Timestamp if;
    private boolean do;

    public int getId() {
        return this.id;
    }

    public void setId(int n2) {
        this.id = n2;
    }

    public void readFrom(e e2) {
        super.readFrom(e2);
        this.id = e2.i();
        this.try = e2.byte();
        this.new = e2.byte();
        this.for = e2.byte();
        this.do = e2.c();
        this.int = new Timestamp(e2.g());
        this.if = new Timestamp(e2.g());
    }

    public void writeTo(e e2) {
        super.writeTo(e2);
        e2.char(this.id);
        e2.if(this.try);
        e2.if(this.new);
        e2.if(this.for);
        e2.a(this.do);
        e2.a(((Date)this.int).getTime());
        e2.a(((Date)this.if).getTime());
    }

    public String getContent() {
        return this.new;
    }

    public void setContent(String string) {
        this.new = string;
    }

    public void setSelected(boolean bl) {
        this.do = bl;
    }

    public boolean isSelected() {
        return this.do;
    }

    public Timestamp getEndTime() {
        return this.if;
    }

    public void setEndTime(Timestamp timestamp) {
        this.if = timestamp;
    }

    public String getTitle() {
        return this.try;
    }

    public void setTitle(String string) {
        this.try = string;
    }

    public Timestamp getStartTime() {
        return this.int;
    }

    public String getSelectList() {
        return this.for;
    }

    public void setSelectList(String string) {
        this.for = string;
    }

    public void setStartTime(Timestamp timestamp) {
        this.int = timestamp;
    }
}

