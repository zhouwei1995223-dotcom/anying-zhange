/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.o;
import a.b.q;
import a.b.s;
import b.a.c.b;
import b.a.c.b.r;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
class a2
extends s {
    private int eR = 0;
    private r eQ;
    private r eP;

    public void for(String string, int n2) {
        o o2 = new o(string, this.getWidth(), n2, 0);
        this.setSize(this.getWidth(), o2.if());
        this.if(o2);
    }

    public void a(b b2, String string, int n2, String string2, int n3) {
        int n4 = 0;
        if (!string.equals(b2.for().a)) {
            n4 = q.if(string) + 24;
            this.eQ = new r(b2, string, n2);
            this.eQ.setBounds(0, 0, n4, 14);
            this.add(this.eQ);
        } else {
            string2 = "\u4f60" + string2;
        }
        o o2 = new o(string2, this.getWidth(), n3, n4);
        this.setSize(this.getWidth(), o2.if() + 4);
        this.if(o2);
    }

    public void do(String string, int n2, String string2, int n3) {
        s s2 = new s();
        a.b.b b2 = new q(string, n2);
        s2.if(b2);
        s2.setBounds(0, 2, b2.a(), 14);
        this.add(s2);
        b2 = new o(string2, this.getWidth(), n3, s2.getWidth());
        this.setSize(this.getWidth(), b2.if() + 4);
        this.if(b2);
    }

    public void a(b b2, String string, int n2, String string2, int n3, String string3, int n4) {
        s s2 = new s();
        a.b.b b3 = new q(string, n2);
        s2.if(b3);
        s2.setBounds(0, 2, b3.a(), 14);
        this.add(s2);
        int n5 = 0;
        if (!string2.equals(b2.for().a)) {
            this.eP = new r(b2, string2, n3);
            n5 = q.if(string2) + 24;
            this.eP.setBounds(b3.a(), 0, n5, 14);
            this.add(this.eP);
        } else {
            string3 = "\u4f60" + string3;
        }
        b3 = new o(string3, this.getWidth(), n4, n5 + s2.getWidth());
        this.setSize(this.getWidth(), b3.if() + 4);
        this.if(b3);
    }

    public void if(b b2, String string, int n2, String string2, String string3, int n3, String string4, int n4) {
        r r2 = new r(b2, string, n2);
        r2.setBounds(0, 0, q.if(string) + 24, 14);
        this.add(r2);
        int n5 = r2.getWidth();
        s s2 = new s();
        a.b.b b3 = new q(string2, n4);
        s2.if(b3);
        s2.setBounds(n5, 2, b3.a(), 14);
        this.add(s2);
        r r3 = new r(b2, string3, n3);
        r3.setBounds(n5 += s2.getWidth(), 0, q.if(string3) + 24, 14);
        this.add(r3);
        b3 = new o(string4, this.getWidth(), n4, n5 += r3.getWidth());
        this.setSize(this.getWidth(), b3.if() + 4);
        this.if(b3);
    }

    public a2(int n2) {
        this.a(24);
        this.setSize(n2, 0);
    }

    public void if(b b2, String string, int n2, String string2, int n3, String string3, String string4, int n4, String string5, int n5) {
        s s2 = new s();
        a.b.b b3 = new q(string, n2);
        s2.if(b3);
        s2.setBounds(0, 2, b3.a(), 14);
        this.add(s2);
        int n6 = s2.getWidth();
        r r2 = new r(b2, string2, n3);
        r2.setBounds(n6, 0, q.if(string2) + 24, 14);
        this.add(r2);
        s2 = new s();
        b3 = new q(string3, n5);
        s2.if(b3);
        s2.setBounds(n6 += r2.getWidth(), 2, b3.a(), 14);
        this.add(s2);
        r r3 = new r(b2, string4, n4);
        r3.setBounds(n6 += s2.getWidth(), 0, q.if(string4) + 24, 14);
        this.add(r3);
        b3 = new o(string5, this.getWidth(), n5, n6 += r3.getWidth());
        this.setSize(this.getWidth(), b3.if() + 4);
        this.if(b3);
    }

    public void a(c c2) {
        if (this.eR != 0) {
            c2.a(0, 0, this.getWidth(), this.getHeight(), this.eR);
        }
        super.a(c2);
    }

    public int bQ() {
        return this.eR;
    }

    public void s(int n2) {
        this.eR = n2;
    }
}

