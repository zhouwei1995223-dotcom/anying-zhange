/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.d;
import b.a.c.b.e;
import b.a.d.k;

class s
extends a.b.s {
    private k cu;
    private int cv = 0;

    public void ba() {
        int n2;
        this.cv = n2 = this.getWidth();
        if (this.cu.p < this.cu.j()) {
            int n3 = this.cu.k() - this.cu.f();
            int n4 = this.cu.a9 - this.cu.f();
            this.cv = (int)((float)n4 * 1.0f / (float)n3 * (float)n2);
            if (this.cv < 0) {
                this.cv = 0;
            } else if (this.cv >= this.getWidth()) {
                this.cv = n2;
            }
        }
        String string = "\u6bd4\u4f8b\uff1a" + this.cv * 100 / n2 + "%  \u7ecf\u9a8c\uff1a" + this.h(this.cu.a9) + "/" + this.h(this.cu.k());
        d d2 = (d)this.int();
        if (d2 != null) {
            d2.a(string);
            this.repaint();
        } else {
            d2 = new d(string);
            this.a(d2);
        }
    }

    public s(k k2) {
        this.cu = k2;
    }

    public void a(c c2) {
        if (this.cv <= 10) {
            c2.if(e.aZ, 0, 0, 185, 206, this.cv, 5);
        } else {
            c2.if(e.aZ, 0, 0, 185, 206, 10, 5);
            int n2 = this.cv - 7;
            int n3 = 10;
            while (n3 < n2) {
                c2.if(e.aZ, n3, 0, 202, 206, 2, 5);
                n3 += 2;
            }
            c2.if(e.aZ, this.cv - 7, 0, 210, 206, 7, 5);
        }
        c2.a(this.cv, 0, this.getWidth() - this.cv, this.getHeight(), -16777216);
    }

    private String h(int n2) {
        return String.valueOf(n2);
    }

    public void bb() {
        this.ba();
    }
}

