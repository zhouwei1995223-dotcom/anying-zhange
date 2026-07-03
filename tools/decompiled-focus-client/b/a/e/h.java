/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javassist.runtime.DotClass
 */
package b.a.e;

import a.a.i;
import b.a.b;
import b.a.d.k;
import b.a.e.e;
import b.a.e.j;
import b.a.e.v;
import b.a.e.x;
import b.a.e.y;
import javassist.runtime.DotClass;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class h
extends b {
    public int fk = 0;
    public j[] fr = new j[64];
    public x fq;
    public v fp;
    public e fx;
    public e ft;
    public e fo;
    public e fv;
    public y fz;
    public y fs;
    public y fn;
    public y fm;
    public y fw;
    public j[] fy = new j[80];
    public int fu = 16;
    public transient boolean fl = false;
    public y title;
    public y aura;

    public int w() {
        int n2 = 0;
        if (this.fp != null) {
            n2 = this.fp.hR;
        }
        return n2 += this.e(7);
    }

    public y a(int n2, int n3) {
        if (n2 == 5) {
            y y2 = this.aura;
            this.aura = null;
            return y2;
        }
        if (n2 == 4) {
            y y3 = this.title;
            this.title = null;
            return y3;
        }
        y y4 = null;
        switch (n2) {
            case 1: {
                if (n3 == 1) {
                    y4 = this.fz;
                    this.fz = null;
                    break;
                }
                y4 = this.fs;
                this.fs = null;
                break;
            }
            case 2: {
                y4 = this.fn;
                this.fn = null;
                break;
            }
            case 3: {
                if (n3 == 1) {
                    y4 = this.fm;
                    this.fm = null;
                    break;
                }
                y4 = this.fw;
                this.fw = null;
                break;
            }
        }
        return y4;
    }

    public void a(a.a.e e2) {
        this.fk = e2.i();
        this.byte(e2);
        this.try(e2);
        this.fu = e2.for();
    }

    public int C() {
        int n2 = 0;
        if (this.fp != null) {
            n2 = this.fp.h1 + this.fp.hV;
        }
        return n2 += this.e(2);
    }

    public int J() {
        int n2 = 0;
        if (this.fx != null) {
            n2 += this.fx.f6;
        }
        if (this.ft != null) {
            n2 += this.ft.f6;
        }
        if (this.fo != null) {
            n2 += this.fo.f6;
        }
        if (this.fv != null) {
            n2 += this.fv.f6;
        }
        if (this.fz != null) {
            n2 += this.fz.iz;
        }
        if (this.fs != null) {
            n2 += this.fs.iz;
        }
        if (this.fn != null) {
            n2 += this.fn.iz;
        }
        if (this.fm != null) {
            n2 += this.fm.iz;
        }
        if (this.fw != null) {
            n2 += this.fw.iz;
        }
        return n2 += this.e(9);
    }

    public void if(a.a.e e2) {
        e2.char(this.fk);
        this.case(e2);
        this.new(e2);
        e2.a(this.fu);
    }

    public int H() {
        int n2 = 0;
        if (this.fn != null) {
            n2 += this.fn.iC;
        }
        return n2;
    }

    public int K() {
        if (this.fv != null) {
            return this.fv.gC;
        }
        return 0;
    }

    public int G() {
        return this.a(false);
    }

    public int a(boolean bl) {
        int n2 = 0;
        if (this.fx != null) {
            n2 = bl ? (n2 += (int)((float)this.fx.gj * 0.3f * (1.0f + (float)this.fx.fM * 0.15f))) : (n2 += this.fx.gj);
        }
        if (this.ft != null) {
            n2 = bl ? (n2 += (int)((float)this.ft.gj * 0.3f * (1.0f + (float)this.ft.fM * 0.15f))) : (n2 += this.ft.gj);
        }
        if (this.fo != null) {
            n2 = bl ? (n2 += (int)((float)this.fo.gj * 0.3f * (1.0f + (float)this.fo.fM * 0.15f))) : (n2 += this.fo.gj);
        }
        if (this.fv != null) {
            n2 = bl ? (n2 += (int)((float)this.fv.gj * 0.3f * (1.0f + (float)this.fv.fM * 0.15f))) : (n2 += this.fv.gj);
        }
        if (this.fz != null) {
            n2 = bl ? (n2 += (int)((float)this.fz.io * 0.3f * (1.0f + (float)this.fz.fM * 0.15f))) : (n2 += this.fz.io);
        }
        if (this.fs != null) {
            n2 = bl ? (n2 += (int)((float)this.fs.io * 0.3f * (1.0f + (float)this.fs.fM * 0.15f))) : (n2 += this.fs.io);
        }
        if (this.fn != null) {
            n2 = bl ? (n2 += (int)((float)this.fn.io * 0.3f * (1.0f + (float)this.fn.fM * 0.15f))) : (n2 += this.fn.io);
        }
        if (this.fm != null) {
            n2 = bl ? (n2 += (int)((float)this.fm.io * 0.3f * (1.0f + (float)this.fm.fM * 0.15f))) : (n2 += this.fm.io);
        }
        if (this.fw != null) {
            n2 = bl ? (n2 += (int)((float)this.fw.io * 0.3f * (1.0f + (float)this.fw.fM * 0.15f))) : (n2 += this.fw.io);
        }
        n2 = bl ? (n2 += this.e(4) / 2) : (n2 += this.e(4));
        return n2;
    }

    public int O() {
        int n2 = 0;
        while (n2 < this.fr.length) {
            if (this.fr[n2] == null) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    public int F() {
        int n2 = 0;
        while (n2 < this.fu) {
            if (this.fy[n2] == null) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    public int N() {
        if (this.fo != null) {
            return this.fo.gn;
        }
        return 0;
    }

    public void int(a.a.e e2) {
        int n2 = 0;
        while (n2 < this.fu) {
            if (e2.c()) {
                int n3 = e2.case();
                j j2 = j.h(n3);
                j2.a(e2);
                this.fy[n2] = j2;
            }
            ++n2;
        }
    }

    public void char(a.a.e e2) {
        int n2 = 0;
        while (n2 < this.fu) {
            if (this.fy[n2] == null) {
                e2.a(false);
            } else {
                e2.a(true);
                e2.a(this.fy[n2].fW);
                this.fy[n2].if(e2);
            }
            ++n2;
        }
    }

    public v Q() {
        v v2 = this.fp;
        this.fp = null;
        return v2;
    }

    public void A() {
        this.fp = null;
    }

    public void try(a.a.e e2) {
        int n2 = 0;
        while (n2 < this.fr.length) {
            boolean bl = e2.c();
            if (bl) {
                int n3 = e2.case();
                j j2 = j.h(n3);
                j2.a(e2);
                this.fr[n2] = j2;
            }
            ++n2;
        }
    }

    public void new(a.a.e e2) {
        int n2 = 0;
        while (n2 < this.fr.length) {
            if (this.fr[n2] == null) {
                e2.a(false);
            } else {
                e2.a(true);
                e2.a(this.fr[n2].fW);
                this.fr[n2].if(e2);
            }
            ++n2;
        }
    }

    public e c(int n2) {
        e e2 = null;
        switch (n2) {
            case 1: {
                e2 = this.fx;
                this.fx = null;
                break;
            }
            case 3: {
                e2 = this.fo;
                this.fo = null;
                break;
            }
            case 2: {
                e2 = this.ft;
                this.ft = null;
                break;
            }
            case 4: {
                e2 = this.fv;
                this.fv = null;
                break;
            }
        }
        return e2;
    }

    public v a(v v2) {
        v v3 = this.Q();
        this.fp = v2;
        return v3;
    }

    public int x() {
        int n2 = 0;
        if (this.fp != null) {
            n2 = this.fp.hT + this.fp.hG;
        }
        return n2 += this.e(1);
    }

    public int R() {
        int n2 = 0;
        if (this.fp != null) {
            n2 = this.fp.h9 + this.fp.h2;
        }
        return n2 += this.e(2);
    }

    public int case(k k2) {
        return this.a(k2, false);
    }

    public int a(k k2, boolean bl) {
        int n2 = 0;
        if (this.fx != null) {
            n2 = bl ? (n2 += (int)((float)(this.fx.gp + this.fx.gd) * (0.1f * (1.0f + 0.15f * (float)this.fx.fM)))) : (n2 += this.fx.gp + this.fx.gd);
        }
        if (this.ft != null) {
            n2 = bl ? (n2 += (int)((float)(this.ft.gp + this.ft.gd) * (0.1f * (1.0f + 0.15f * (float)this.ft.fM)))) : (n2 += this.ft.gp + this.ft.gd);
        }
        if (this.fo != null) {
            n2 = bl ? (n2 += (int)((float)(this.fo.gp + this.fo.gd) * (0.1f * (1.0f + 0.15f * (float)this.fo.fM)))) : (n2 += this.fo.gp + this.fo.gd);
        }
        if (this.fv != null) {
            n2 = bl ? (n2 += (int)((float)(this.fv.gp + this.fv.gd) * (0.1f * (1.0f + 0.15f * (float)this.fv.fM)))) : (n2 += this.fv.gp + this.fv.gd);
        }
        if (this.fz != null) {
            n2 = bl ? (n2 += (int)((float)(this.fz.ip + this.fz.iB) * (0.1f * (1.0f + 0.15f * (float)this.fz.fM)))) : (n2 += this.fz.ip + this.fz.iB);
        }
        if (this.fs != null) {
            n2 = bl ? (n2 += (int)((float)(this.fs.ip + this.fs.iB) * (0.1f * (1.0f + 0.15f * (float)this.fs.fM)))) : (n2 += this.fs.ip + this.fs.iB);
        }
        if (this.fm != null) {
            n2 = bl ? (n2 += (int)((float)(this.fm.ip + this.fm.iB) * (0.1f * (1.0f + 0.15f * (float)this.fm.fM)))) : (n2 += this.fm.ip + this.fm.iB);
        }
        if (this.fw != null) {
            n2 = bl ? (n2 += (int)((float)(this.fw.ip + this.fw.iB) * (0.1f * (1.0f + 0.15f * (float)this.fw.fM)))) : (n2 += this.fw.ip + this.fw.iB);
        }
        n2 = bl ? (n2 += this.e(6) / 10) : (n2 += this.e(6));
        if (bl) {
            return n2;
        }
        int n3 = 0;
        if (this.fx != null) {
            n3 += this.fx.ge * k2.p / 10;
            n3 += this.fx.gy * k2.N / 100;
            n3 += this.fx.f8 * k2.G / 100;
            n3 += this.fx.f7 * k2.X / 100;
        }
        if (this.ft != null) {
            n3 += this.ft.ge * k2.p / 10;
            n3 += this.ft.gy * k2.N / 100;
            n3 += this.ft.f8 * k2.G / 100;
            n3 += this.ft.f7 * k2.X / 100;
        }
        if (this.fo != null) {
            n3 += this.fo.ge * k2.p / 10;
            n3 += this.fo.gy * k2.N / 100;
            n3 += this.fo.f8 * k2.G / 100;
            n3 += this.fo.f7 * k2.X / 100;
        }
        if (this.fv != null) {
            n3 += this.fv.ge * k2.p / 10;
            n3 += this.fv.gy * k2.N / 100;
            n3 += this.fv.f8 * k2.G / 100;
            n3 += this.fv.f7 * k2.X / 100;
        }
        return n2 + n3;
    }

    public int y() {
        if (this.fp == null || this.fp.hU == 0) {
            return 0;
        }
        if (this.ft == null || this.ft.go == 0) {
            return 0;
        }
        if (this.fx == null || this.fx.go == 0) {
            return 0;
        }
        if (this.fo == null || this.fo.go == 0) {
            return 0;
        }
        if (this.fp.hU == this.ft.go && this.ft.go == this.fx.go && this.fx.go == this.fo.go) {
            return this.fp.hL;
        }
        return 0;
    }

    public void S() {
        this.ft = null;
        this.fx = null;
        this.fo = null;
        this.fv = null;
    }

    public void T() {
        this.fs = null;
        this.fz = null;
        this.fw = null;
        this.fm = null;
        this.fn = null;
    }

    public int B() {
        int n2 = 0;
        if (this.fp != null) {
            n2 = this.fp.h8;
        }
        if (this.ft != null && this.ft.gA > n2) {
            n2 = this.ft.gA;
        }
        if (this.fx != null && this.fx.gA > n2) {
            n2 = this.fx.gA;
        }
        if (this.fo != null && this.fo.gA > n2) {
            n2 = this.fo.gA;
        }
        if (this.fv != null && this.fv.gA > n2) {
            n2 = this.fv.gA;
        }
        return n2;
    }

    public String a(k k2, v v2) {
        if (v2.hH != k2.af) {
            return "\u804c\u4e1a\u4e0d\u7b26";
        }
        if (v2.hP > k2.p) {
            return "\u7b49\u7ea7\u4e0d\u591f";
        }
        if (v2.h3 > k2.ab) {
            return "\u8f6c\u751f\u4e0d\u591f";
        }
        return "";
    }

    public y if(y y2, int n2) {
        try {
            if (y2 != null && y2.getClass().getField("if").getInt(y2) == 1713059900) {
                y y3 = this.aura;
                this.aura = y2;
                return y3;
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        if (y2.il == 5) {
            y y4 = this.aura;
            this.aura = y2;
            return y4;
        }
        if (y2.il == 4) {
            y y5 = this.title;
            this.title = y2;
            return y5;
        }
        y y6 = null;
        switch (y2.il) {
            case 1: {
                if (n2 == 1) {
                    y6 = this.fz;
                    this.fz = y2;
                    break;
                }
                if (n2 == 2) {
                    y6 = this.fs;
                    this.fs = y2;
                    break;
                }
                if (this.fz == null) {
                    this.fz = y2;
                    break;
                }
                if (this.fs == null) {
                    this.fs = y2;
                    break;
                }
                y6 = this.fz;
                this.fz = y2;
                break;
            }
            case 2: {
                y6 = this.fn;
                this.fn = y2;
                break;
            }
            case 3: {
                if (n2 == 1) {
                    y6 = this.fm;
                    this.fm = y2;
                    break;
                }
                if (n2 == 2) {
                    y6 = this.fw;
                    this.fw = y2;
                    break;
                }
                if (this.fm == null) {
                    this.fm = y2;
                    break;
                }
                if (this.fw == null) {
                    this.fw = y2;
                    break;
                }
                y6 = this.fm;
                this.fm = y2;
                break;
            }
        }
        return y6;
    }

    public i a(String string) {
        if (string.equals("aura")) {
            i i2 = new i(string);
            if (this.aura != null) {
                Class<?> clazz;
                Class[] classArray = new Class[1];
                try {
                    clazz = Class.forName("java.lang.String");
                }
                catch (ClassNotFoundException classNotFoundException) {
                    throw DotClass.fail((ClassNotFoundException)classNotFoundException);
                }
                classArray[0] = clazz;
                i2.getClass().getMethod("do", classArray).invoke(i2, String.valueOf(this.aura.getClass().getField("if").getInt(this.aura)));
            }
            return i2;
        }
        if (string.equals("title")) {
            i i3 = new i(string);
            if (this.title != null) {
                Class<?> clazz;
                Class[] classArray = new Class[1];
                try {
                    clazz = Class.forName("java.lang.String");
                }
                catch (ClassNotFoundException classNotFoundException) {
                    throw DotClass.fail((ClassNotFoundException)classNotFoundException);
                }
                classArray[0] = clazz;
                i3.getClass().getMethod("do", classArray).invoke(i3, String.valueOf(this.title.getClass().getField("if").getInt(this.title)));
            }
            return i3;
        }
        i i4 = new i(string);
        if (string.equals("goodsList")) {
            int n2 = 0;
            while (n2 < this.fr.length) {
                if (this.fr[n2] != null) {
                    i i5 = new i(String.valueOf(n2));
                    String string2 = String.valueOf(this.fr[n2].if);
                    String string3 = this.fr[n2].U();
                    if (string3.length() > 0) {
                        string2 = string2 + ',' + string3;
                    }
                    i5.do(string2);
                    i4.a(i5);
                }
                ++n2;
            }
        } else if (string.equals("shopGoods")) {
            int n3 = 0;
            while (n3 < this.fu) {
                if (this.fy[n3] != null) {
                    i i6 = new i(String.valueOf(n3));
                    String string4 = String.valueOf(this.fy[n3].if);
                    String string5 = this.fy[n3].U();
                    if (string5.length() > 0) {
                        string4 = string4 + ',' + string5;
                    }
                    i6.do(string4);
                    i4.a(i6);
                }
                ++n3;
            }
        } else if (string.equals("fashion")) {
            if (this.fq != null) {
                i4.do(String.valueOf(this.fq.if) + ',' + this.fq.U());
            }
        } else if (string.equals("weapon")) {
            if (this.fp != null) {
                i4.do(String.valueOf(this.fp.if));
            }
        } else if (string.equals("helmet")) {
            if (this.ft != null) {
                i4.do(String.valueOf(this.ft.if));
            }
        } else if (string.equals("armor")) {
            if (this.fx != null) {
                i4.do(String.valueOf(this.fx.if));
            }
        } else if (string.equals("boots")) {
            if (this.fo != null) {
                i4.do(String.valueOf(this.fo.if));
            }
        } else if (string.equals("shield")) {
            if (this.fv != null) {
                i4.do(String.valueOf(this.fv.if));
            }
        } else if (string.equals("leftEarbob")) {
            if (this.fz != null) {
                i4.do(String.valueOf(this.fz.if));
            }
        } else if (string.equals("rightEarbob")) {
            if (this.fs != null) {
                i4.do(String.valueOf(this.fs.if));
            }
        } else if (string.equals("necklace")) {
            if (this.fn != null) {
                i4.do(String.valueOf(this.fn.if));
            }
        } else if (string.equals("leftRing")) {
            if (this.fm != null) {
                i4.do(String.valueOf(this.fm.if));
            }
        } else if (string.equals("rightRing")) {
            if (this.fw != null) {
                i4.do(String.valueOf(this.fw.if));
            }
        } else {
            return super.a(string);
        }
        return i4;
    }

    public boolean a(String string, i i2) {
        if (string.equals("aura")) {
            String string2 = (String)i2.getClass().getMethod("for", new Class[0]).invoke(i2, new Object[0]);
            if (string2.equals("null") || string2.length() < 1) {
                return false;
            }
            int n2 = Integer.parseInt(string2);
            if (n2 > 0) {
                this.aura = (y)b.a(j.i(n2));
            }
            return true;
        }
        if (string.equals("title")) {
            String string3 = (String)i2.getClass().getMethod("for", new Class[0]).invoke(i2, new Object[0]);
            if (string3.equals("null") || string3.length() < 1) {
                return false;
            }
            int n3 = Integer.parseInt(string3);
            if (n3 > 0) {
                this.title = (y)b.a(j.i(n3));
            }
            return true;
        }
        String string4 = i2.for();
        if (string.equals("goodsList")) {
            a.a.h h2 = i2.int();
            if (h2 != null) {
                int n4 = h2.for();
                int n5 = 0;
                while (n5 < n4) {
                    i i3 = (i)h2.if(n5);
                    if (i3.for().length() >= 1) {
                        j j2;
                        int n6;
                        int n7 = Integer.parseInt(i3.do());
                        String string5 = i3.for();
                        int n8 = string5.indexOf(44);
                        if (n8 < 0) {
                            n6 = Integer.parseInt(i3.for());
                            j2 = j.i(n6);
                            if (j2 != null) {
                                this.fr[n7] = (j)b.a(j2);
                            }
                        } else {
                            n6 = Integer.parseInt(string5.substring(0, n8));
                            j2 = j.i(n6);
                            if (j2 != null) {
                                this.fr[n7] = (j)b.a(j2);
                                this.fr[n7].byte(string5.substring(n8 + 1));
                            }
                        }
                    }
                    ++n5;
                }
            }
            return true;
        }
        if (string.equals("shopGoods")) {
            a.a.h h3 = i2.int();
            if (h3 != null) {
                int n9 = h3.for();
                int n10 = 0;
                while (n10 < n9) {
                    i i4 = (i)h3.if(n10);
                    if (i4.for().length() >= 1) {
                        j j3;
                        int n11;
                        int n12 = Integer.parseInt(i4.do());
                        String string6 = i4.for();
                        int n13 = string6.indexOf(44);
                        if (n13 < 0) {
                            n11 = Integer.parseInt(i4.for());
                            j3 = j.i(n11);
                            if (j3 != null) {
                                this.fy[n12] = (j)b.a(j3);
                            }
                        } else {
                            n11 = Integer.parseInt(string6.substring(0, n13));
                            j3 = j.i(n11);
                            if (j3 != null) {
                                this.fy[n12] = (j)b.a(j3);
                                this.fy[n12].byte(string6.substring(n13 + 1));
                            }
                        }
                        if (this.fy[n12] != null) {
                            this.fy[n12].fK = 0;
                        }
                    }
                    ++n10;
                }
            }
            return true;
        }
        if (string4.equals("null") || string4.length() < 1) {
            return false;
        }
        if (string.equals("fashion")) {
            int n14 = string4.indexOf(44);
            if (n14 > 0) {
                int n15 = Integer.parseInt(string4.substring(0, n14));
                String string7 = string4.substring(n14 + 1);
                this.fq = (x)j.i(n15);
                if (this.fq != null) {
                    this.fq = (x)b.a(this.fq);
                    this.fq.byte(string7);
                }
            } else {
                int n16 = Integer.parseInt(string4);
                this.fq = (x)j.i(n16);
                this.fq = (x)b.a(this.fq);
            }
        } else if (string.equals("weapon")) {
            int n17 = Integer.parseInt(string4);
            if (n17 > 0) {
                this.fp = (v)b.a(j.i(n17));
            }
        } else if (string.equals("helmet")) {
            int n18 = Integer.parseInt(string4);
            if (n18 > 0) {
                this.ft = (e)b.a(j.i(n18));
            }
        } else if (string.equals("armor")) {
            int n19 = Integer.parseInt(string4);
            if (n19 > 0) {
                this.fx = (e)b.a(j.i(n19));
            }
        } else if (string.equals("boots")) {
            int n20 = Integer.parseInt(string4);
            if (n20 > 0) {
                this.fo = (e)b.a(j.i(n20));
            }
        } else if (string.equals("shield")) {
            int n21 = Integer.parseInt(string4);
            if (n21 > 0) {
                this.fv = (e)b.a(j.i(n21));
            }
        } else if (string.equals("leftEarbob")) {
            int n22 = Integer.parseInt(string4);
            if (n22 > 0) {
                this.fz = (y)b.a(j.i(n22));
            }
        } else if (string.equals("rightEarbob")) {
            int n23 = Integer.parseInt(string4);
            if (n23 > 0) {
                this.fs = (y)b.a(j.i(n23));
            }
        } else if (string.equals("necklace")) {
            int n24 = Integer.parseInt(string4);
            if (n24 > 0) {
                this.fn = (y)b.a(j.i(n24));
            }
        } else if (string.equals("leftRing")) {
            int n25 = Integer.parseInt(string4);
            if (n25 > 0) {
                this.fm = (y)b.a(j.i(n25));
            }
        } else if (string.equals("rightRing")) {
            int n26 = Integer.parseInt(string4);
            if (n26 > 0) {
                this.fw = (y)b.a(j.i(n26));
            }
        } else {
            return super.a(string, i2);
        }
        return true;
    }

    public int e(int n2) {
        int n3 = 0;
        if (this.fz != null) {
            n3 += this.a(this.fz, n2);
        }
        if (this.fs != null) {
            n3 += this.a(this.fs, n2);
        }
        if (this.fn != null) {
            n3 += this.a(this.fn, n2);
        }
        if (this.fm != null) {
            n3 += this.a(this.fm, n2);
        }
        if (this.fw != null) {
            n3 += this.a(this.fw, n2);
        }
        if (this.fp != null) {
            n3 += this.a(this.fp, n2);
        }
        if (this.ft != null) {
            n3 += this.a(this.ft, n2);
        }
        if (this.fx != null) {
            n3 += this.a(this.fx, n2);
        }
        if (this.fv != null) {
            n3 += this.a(this.fv, n2);
        }
        if (this.fo != null) {
            n3 += this.a(this.fo, n2);
        }
        int n4 = n3;
        if (this.title != null) {
            n4 += this.a(this.title, n2);
        }
        int n5 = n4;
        if (this.aura != null) {
            n5 += this.a(this.aura, n2);
        }
        return n5;
    }

    public int a(y y2, int n2) {
        if (y2.ix == 0) {
            return 0;
        }
        int n3 = this.g(y2.ix);
        if (n3 <= 1) {
            return 0;
        }
        int n4 = 0;
        int n5 = 1;
        while (n5 < n3) {
            if (y2.iH[n5 - 1] == n2) {
                n4 += y2.iO[n5 - 1];
            }
            ++n5;
        }
        return n4;
    }

    public int P() {
        int n2 = 0;
        int n3 = 0;
        while (n3 < this.fr.length) {
            if (this.fr[n3] != null) {
                ++n2;
            }
            ++n3;
        }
        return n2;
    }

    public int d(int n2) {
        int n3 = 0;
        int n4 = 0;
        while (n4 < this.fr.length) {
            if (this.fr[n4] != null && this.fr[n4].if == n2) {
                ++n3;
            }
            ++n4;
        }
        return n3;
    }

    public int z() {
        int n2 = 0;
        if (this.fn != null) {
            n2 += this.fn.iI;
        }
        return n2;
    }

    public int g(int n2) {
        int n3 = 0;
        if (this.ft != null && this.ft.go == n2) {
            ++n3;
        }
        if (this.fx != null && this.fx.go == n2) {
            ++n3;
        }
        if (this.fv != null && this.fv.go == n2) {
            ++n3;
        }
        if (this.fo != null && this.fo.go == n2) {
            ++n3;
        }
        if (this.fp != null && this.fp.hU == n2) {
            ++n3;
        }
        if (this.fz != null && this.fz.ix == n2) {
            ++n3;
        }
        if (this.fs != null && this.fs.ix == n2) {
            ++n3;
        }
        if (this.fn != null && this.fn.ix == n2) {
            ++n3;
        }
        if (this.fm != null && this.fm.ix == n2) {
            ++n3;
        }
        if (this.fw != null && this.fw.ix == n2) {
            ++n3;
        }
        return n3;
    }

    public int a(e e2, int n2) {
        if (e2.go == 0) {
            return 0;
        }
        int n3 = this.g(e2.go);
        if (n3 <= 1) {
            return 0;
        }
        int n4 = 0;
        int n5 = 1;
        while (n5 < n3) {
            if (e2.f4[n5 - 1] == n2) {
                n4 += e2.gz[n5 - 1];
            }
            ++n5;
        }
        return n4;
    }

    public int a(v v2, int n2) {
        if (v2.hU == 0) {
            return 0;
        }
        int n3 = this.g(v2.hU);
        if (n3 <= 1) {
            return 0;
        }
        int n4 = 0;
        int n5 = 1;
        while (n5 < n3) {
            if (v2.hB[n5 - 1] == n2) {
                n4 += v2.h7[n5 - 1];
            }
            ++n5;
        }
        return n4;
    }

    public String a(k k2, e e2) {
        if (e2.ga != k2.af) {
            return "\u804c\u4e1a\u4e0d\u7b26";
        }
        if (e2.gl > k2.p) {
            return "\u7b49\u7ea7\u4e0d\u591f";
        }
        if (e2.gu > k2.ab) {
            return "\u8f6c\u751f\u4e0d\u591f";
        }
        return "";
    }

    public h() {
        Object var2_1 = null;
        this.fr = new j[96];
    }

    public int D() {
        int n2 = 0;
        if (this.fp != null) {
            n2 += this.fp.ic + this.fp.h6;
        }
        return n2 += this.e(1);
    }

    public int try(k k2) {
        return this.if(k2, false);
    }

    public int if(k k2, boolean bl) {
        int n2 = 0;
        if (this.fx != null) {
            n2 = bl ? (n2 += (int)((float)(this.fx.gB + this.fx.f9) * (0.1f * (1.0f + (float)this.fx.fM * 0.15f)))) : (n2 += this.fx.gB + this.fx.f9);
        }
        if (this.ft != null) {
            n2 = bl ? (n2 += (int)((float)(this.ft.gB + this.ft.f9) * (0.1f * (1.0f + (float)this.ft.fM * 0.15f)))) : (n2 += this.ft.gB + this.ft.f9);
        }
        if (this.fo != null) {
            n2 = bl ? (n2 += (int)((float)(this.fo.gB + this.fo.f9) * (0.1f * (1.0f + (float)this.fo.fM * 0.15f)))) : (n2 += this.fo.gB + this.fo.f9);
        }
        if (this.fv != null) {
            n2 = bl ? (n2 += (int)((float)(this.fv.gB + this.fv.f9) * (0.1f * (1.0f + (float)this.fv.fM * 0.15f)))) : (n2 += this.fv.gB + this.fv.f9);
        }
        if (this.fm != null) {
            n2 = bl ? (n2 += (int)((float)(this.fm.iv + this.fm.ir) * (0.1f * (1.0f + (float)this.fm.fM * 0.15f)))) : (n2 += this.fm.iv + this.fm.ir);
        }
        if (this.fw != null) {
            n2 = bl ? (n2 += (int)((float)(this.fw.iv + this.fw.ir) * (0.1f * (1.0f + (float)this.fw.fM * 0.15f)))) : (n2 += this.fw.iv + this.fw.ir);
        }
        if (this.fz != null) {
            n2 = bl ? (n2 += (int)((float)(this.fz.iv + this.fz.ir) * (0.1f * (1.0f + (float)this.fz.fM * 0.15f)))) : (n2 += this.fz.iv + this.fz.ir);
        }
        if (this.fs != null) {
            n2 = bl ? (n2 += (int)((float)(this.fs.iv + this.fs.ir) * (0.1f * (1.0f + (float)this.fs.fM * 0.15f)))) : (n2 += this.fs.iv + this.fs.ir);
        }
        n2 = bl ? (n2 += this.e(5) / 10) : (n2 += this.e(5));
        if (bl) {
            return n2;
        }
        int n3 = 0;
        if (this.fx != null) {
            n3 += this.fx.gk * k2.p / 10;
            n3 += this.fx.gs * k2.N / 100;
            n3 += this.fx.gr * k2.G / 100;
            n3 += this.fx.gi * k2.X / 100;
        }
        if (this.ft != null) {
            n3 += this.ft.gk * k2.p / 10;
            n3 += this.ft.gs * k2.N / 100;
            n3 += this.ft.gr * k2.G / 100;
            n3 += this.ft.gi * k2.X / 100;
        }
        if (this.fo != null) {
            n3 += this.fo.gk * k2.p / 10;
            n3 += this.fo.gs * k2.N / 100;
            n3 += this.fo.gr * k2.G / 100;
            n3 += this.fo.gi * k2.X / 100;
        }
        if (this.fv != null) {
            n3 += this.fv.gk * k2.p / 10;
            n3 += this.fv.gs * k2.N / 100;
            n3 += this.fv.gr * k2.G / 100;
            n3 += this.fv.gi * k2.X / 100;
        }
        return n2 + n3;
    }

    public int E() {
        return this.if(false);
    }

    public int if(boolean bl) {
        int n2 = 0;
        if (this.fx != null) {
            n2 = bl ? (n2 += (int)((float)this.fx.gD * 0.3f * (1.0f + (float)this.fx.fM * 0.15f))) : (n2 += this.fx.gD);
        }
        if (this.ft != null) {
            n2 = bl ? (n2 += (int)((float)this.ft.gD * 0.3f * (1.0f + (float)this.ft.fM * 0.15f))) : (n2 += this.ft.gD);
        }
        if (this.fo != null) {
            n2 = bl ? (n2 += (int)((float)this.fo.gD * 0.3f * (1.0f + (float)this.fo.fM * 0.15f))) : (n2 += this.fo.gD);
        }
        if (this.fv != null) {
            n2 = bl ? (n2 += (int)((float)this.fv.gD * 0.3f * (1.0f + (float)this.fv.fM * 0.15f))) : (n2 += this.fv.gD);
        }
        if (this.fz != null) {
            n2 = bl ? (n2 += (int)((float)this.fz.iK * 0.3f * (1.0f + (float)this.fz.fM * 0.15f))) : (n2 += this.fz.iK);
        }
        if (this.fs != null) {
            n2 = bl ? (n2 += (int)((float)this.fs.iK * 0.3f * (1.0f + (float)this.fs.fM * 0.15f))) : (n2 += this.fs.iK);
        }
        if (this.fn != null) {
            n2 = bl ? (n2 += (int)((float)this.fn.iK * 0.3f * (1.0f + (float)this.fn.fM * 0.15f))) : (n2 += this.fn.iK);
        }
        if (this.fm != null) {
            n2 = bl ? (n2 += (int)((float)this.fm.iK * 0.3f * (1.0f + (float)this.fm.fM * 0.15f))) : (n2 += this.fm.iK);
        }
        if (this.fw != null) {
            n2 = bl ? (n2 += (int)((float)this.fw.iK * 0.3f * (1.0f + (float)this.fw.fM * 0.15f))) : (n2 += this.fw.iK);
        }
        n2 = bl ? (n2 += this.e(3) / 2) : (n2 += this.e(3));
        return n2;
    }

    public void byte(a.a.e e2) {
        if (e2.c()) {
            this.fq = new x();
            this.fq.a(e2);
        }
        if (e2.c()) {
            this.ft = new e();
            this.ft.a(e2);
        }
        if (e2.c()) {
            this.fx = new e();
            this.fx.a(e2);
        }
        if (e2.c()) {
            this.fo = new e();
            this.fo.a(e2);
        }
        if (e2.c()) {
            this.fp = new v();
            this.fp.a(e2);
        }
        if (e2.c()) {
            this.fv = new e();
            this.fv.a(e2);
        }
        if (e2.c()) {
            this.fz = new y();
            this.fz.a(e2);
        }
        if (e2.c()) {
            this.fs = new y();
            this.fs.a(e2);
        }
        if (e2.c()) {
            this.fn = new y();
            this.fn.a(e2);
        }
        if (e2.c()) {
            this.fm = new y();
            this.fm.a(e2);
        }
        if (e2.c()) {
            this.fw = new y();
            this.fw.a(e2);
        }
        Object var3_2 = null;
        if (e2.c()) {
            this.title = new y();
            this.title.a(e2);
        }
        Object var5_3 = null;
        if (e2.c()) {
            this.aura = new y();
            this.aura.a(e2);
        }
    }

    public int f(int n2) {
        int n3 = 0;
        while (n3 < this.fr.length) {
            if (this.fr[n3] != null && this.fr[n3].if == n2) {
                return n3;
            }
            ++n3;
        }
        return -1;
    }

    public int I() {
        int n2 = 0;
        if (this.fp != null) {
            n2 = this.fp.hN;
        }
        return n2;
    }

    public int new(k k2) {
        int n2 = 0;
        if (this.fp != null) {
            n2 += this.fp.hO * k2.p / 10;
            n2 += this.fp.hZ * k2.N / 100;
            n2 += this.fp.hX * k2.G / 100;
            n2 += this.fp.hM * k2.X / 100;
        }
        return n2;
    }

    public int L() {
        int n2 = 0;
        if (this.fp != null) {
            n2 += this.fp.hQ;
        }
        if (this.fz != null) {
            n2 += this.fz.is;
        }
        if (this.fs != null) {
            n2 += this.fs.is;
        }
        if (this.fn != null) {
            n2 += this.fn.is;
        }
        if (this.fm != null) {
            n2 += this.fm.is;
        }
        if (this.fw != null) {
            n2 += this.fw.is;
        }
        return n2 += this.e(8);
    }

    public int M() {
        int n2 = 0;
        if (this.fz != null) {
            n2 |= this.fz.iD;
        }
        if (this.fs != null) {
            n2 |= this.fs.iD;
        }
        if (this.fn != null) {
            n2 |= this.fn.iD;
        }
        if (this.fm != null) {
            n2 |= this.fm.iD;
        }
        if (this.fw != null) {
            n2 |= this.fw.iD;
        }
        return n2;
    }

    public String a(k k2, y y2) {
        if (y2.iy > k2.p) {
            return "\u7b49\u7ea7\u4e0d\u591f";
        }
        if (y2.iq > k2.ab) {
            return "\u8f6c\u751f\u4e0d\u591f";
        }
        return "";
    }

    public int v() {
        int n2 = 0;
        if (this.fp != null) {
            n2 += this.fp.hY;
        }
        if (this.fn != null) {
            n2 += this.fn.iL;
        }
        return n2;
    }

    public e a(e e2) {
        e e3 = this.c(e2.gb);
        switch (e2.gb) {
            case 1: {
                this.fx = e2;
                break;
            }
            case 3: {
                this.fo = e2;
                break;
            }
            case 2: {
                this.ft = e2;
                break;
            }
            case 4: {
                this.fv = e2;
                break;
            }
        }
        return e3;
    }

    public void case(a.a.e e2) {
        e2.a(this.fq != null);
        if (this.fq != null) {
            this.fq.if(e2);
        }
        e2.a(this.ft != null);
        if (this.ft != null) {
            this.ft.if(e2);
        }
        e2.a(this.fx != null);
        if (this.fx != null) {
            this.fx.if(e2);
        }
        e2.a(this.fo != null);
        if (this.fo != null) {
            this.fo.if(e2);
        }
        e2.a(this.fp != null);
        if (this.fp != null) {
            this.fp.if(e2);
        }
        e2.a(this.fv != null);
        if (this.fv != null) {
            this.fv.if(e2);
        }
        e2.a(this.fz != null);
        if (this.fz != null) {
            this.fz.if(e2);
        }
        e2.a(this.fs != null);
        if (this.fs != null) {
            this.fs.if(e2);
        }
        e2.a(this.fn != null);
        if (this.fn != null) {
            this.fn.if(e2);
        }
        e2.a(this.fm != null);
        if (this.fm != null) {
            this.fm.if(e2);
        }
        e2.a(this.fw != null);
        if (this.fw != null) {
            this.fw.if(e2);
        }
    }

    public int byte(k k2) {
        int n2 = 0;
        if (this.fp != null) {
            n2 += this.fp.hJ * k2.p / 10;
            n2 += this.fp.h5 * k2.N / 100;
            n2 += this.fp.hF * k2.G / 100;
            n2 += this.fp.hE * k2.X / 100;
        }
        return n2;
    }
}

