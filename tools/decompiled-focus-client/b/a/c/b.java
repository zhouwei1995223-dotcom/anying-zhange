/*
 * Decompiled with CFR 0.152.
 */
package b.a.c;

import a.b.ab;
import a.b.g;
import a.b.h;
import a.b.s;
import a.b.v;
import a.b.y;
import b.a.b.u;
import b.a.c.a;
import b.a.c.b.af;
import b.a.c.b.aj;
import b.a.c.b.aw;
import b.a.c.b.az;
import b.a.c.b.bc;
import b.a.c.b.bd;
import b.a.c.b.l;
import b.a.c.b.m;
import b.a.c.c;
import b.a.c.d;
import b.a.c.e;
import b.a.d.k;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class b
implements ActionListener {
    private static String[] d;
    private c int;
    private a try;
    private b.a.d.l f;
    private k e;
    private h c;
    private s else;
    private d for;
    private bc do;
    private s goto;
    private aw char;
    private aj if;
    private af new;
    private e case;
    private m long;
    private b.a.c.b.e a;
    private int byte;
    private String b = "";
    private String[] void;

    public s o() {
        return this.else;
    }

    public void g() {
        this.c.removeAll();
        this.try.h();
        this.case.if();
    }

    public m int() {
        return this.long;
    }

    public boolean do(String string) {
        int n2 = 0;
        while (n2 < this.void.length) {
            if (string.indexOf(this.void[n2]) >= 0) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    public void a(String string) {
        if (l.fJ) {
            this.b = string;
            if (this.b != null && this.b.length() > 0) {
                this.int.int().playMusic(this.b);
            } else {
                this.int.int().stopMusic();
            }
        }
    }

    public void long() {
        this.goto.removeAll();
        this.long = new m(this);
        this.long.setBounds(this.c.getWidth() / 2 - 300, this.c.getHeight() / 2 - 200, 600, 400);
        this.long.a0();
        this.goto.add(this.long);
        this.long.a5();
        this.char.do(this.long.getX(), this.long.getY(), this.long.getWidth(), this.long.getHeight());
        a.b.af af2 = null;
        String string = this.int.getParameter("logo");
        if (string != null && string.length() > 3) {
            String[] stringArray = a.a.b.a(string, ",");
            int n2 = (int)(Math.random() * (double)stringArray.length);
            af2 = v.if.do("image/ui/" + stringArray[n2]);
        } else {
            af2 = v.if.do("image/ui/logo.jpg");
        }
        if (af2 != null) {
            this.c.if(new ab(af2));
        } else {
            this.c.a(new a.b.l(-16777216));
        }
    }

    public aw new() {
        return this.char;
    }

    public aj d() {
        return this.if;
    }

    public boolean for(String string) {
        String string2 = this.int.getParameter(string);
        return "true".equals(string2);
    }

    public b.a.d.l case() {
        return this.f;
    }

    public void a(String[] stringArray) {
        d = stringArray;
    }

    public bc j() {
        return this.do;
    }

    public String k() {
        return this.b;
    }

    public void try() {
        this.int.int().resumeMusic();
    }

    public static void if(String[] stringArray) {
        int n2 = 0;
        while (true) {
            b.a.c.b.a("www.anying.us", 12346);
            System.out.println(++n2);
        }
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.startsWith("confirm:")) {
            String string2 = string.substring(string.indexOf(58) + 1);
            this.try.a(string2, true);
        } else if (string.startsWith("cancel:")) {
            String string3 = string.substring(string.indexOf(58) + 1);
            this.try.a(string3, false);
        }
    }

    public void f() {
        this.case.start();
        this.try = new a(this);
        String string = this.int.getParameter("splash");
        if (string == null || string.length() == 0 || string.equals("true")) {
            this.l();
        } else {
            this.long();
        }
        String string2 = this.int.getParameter("loginMusic");
        if (string2 != null && string2.length() > 4 && l.fJ) {
            String[] stringArray = a.a.b.a(string2, ",");
            this.a(stringArray[(int)(Math.random() * (double)stringArray.length)]);
        }
    }

    public d e() {
        return this.for;
    }

    public void else() {
        this.c.if(null);
        this.c.a((g)null);
        s s2 = new s();
        s2.setBounds(0, 0, this.c.getWidth(), this.c.getHeight());
        this.c.add((Component)s2, 0);
        this.c.a(s2);
        a.b.af af2 = v.if.if("image/ui/border.img", false);
        if (af2 == null) {
            af2 = v.if.for("image/ui/border.gif");
        }
        if (af2 != null) {
            s2.a(new y(af2));
        }
        this.goto.removeAll();
        this.long = null;
        this.a = new b.a.c.b.e(this);
        this.a.setBounds(0, 0, this.goto.getWidth(), this.goto.getHeight());
        this.a.aN();
        this.goto.add(this.a);
        this.for = new d(this);
        this.do = new bc(this, this.for);
        this.do.setBounds(0, 40, this.else.getWidth() - 340, this.else.getHeight() - 117);
        this.do.dK();
        this.else.add(this.do);
        this.char.do(this.do.getX(), this.do.getY(), this.do.getWidth(), this.do.getHeight());
    }

    public a byte() {
        return this.try;
    }

    public bd goto() {
        return this.a.ai();
    }

    private static void a(String string, int n2) {
        try {
            b.b.c c2 = new b.b.c(string, n2);
            String string2 = c2.toString();
            String string3 = "asdfasdfsadfsadfsad";
            a.a.e e2 = new a.a.e(1024);
            int n3 = 20091031;
            int n4 = (int)(Math.random() * 1000.0 + 10.0);
            e2.char(n4);
            e2.char(n3 / n4);
            e2.char(n3 % n4);
            c2.a(new b.b.b(1, e2));
            int n5 = 0;
            do {
                e2 = new a.a.e(64);
                int n6 = (int)(Math.random() * 255.0);
                e2.char(n6);
                byte[] byArray = string2.getBytes();
                int n7 = 0;
                while (n7 < byArray.length) {
                    byArray[n7] = (byte)(byArray[n7] ^ n6);
                    ++n7;
                }
                e2.a(byArray.length);
                e2.a(byArray);
                byArray = string3.getBytes();
                n7 = 0;
                while (n7 < byArray.length) {
                    byArray[n7] = (byte)(byArray[n7] ^ n6);
                    ++n7;
                }
                e2.a(byArray.length);
                e2.a(byArray);
                e2.do("");
                c2.a(new b.b.b(2, e2));
            } while (++n5 < 20);
            a.a.b.a(100);
            c2.a();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public void i() {
        h h2 = this.c;
        synchronized (h2) {
            if (this.do != null) {
                this.else.remove(this.do);
            }
            if (this.c.case() != null) {
                this.c.remove((s)this.c.case());
            }
            this.char.setVisible(false);
            this.if.setVisible(false);
            this.try.h();
            this.try = new a(this);
            this.f = new b.a.d.l();
            this.e = new k();
            this.e.a2 = this.f;
            this.a = null;
            this.do = null;
            this.for = null;
            this.long();
            Object var2_2 = null;
        }
    }

    public s b() {
        return this.goto;
    }

    public void if(String string) {
        if (l.fD) {
            this.int.int().play2DSound(string);
        }
    }

    public b(c c2, h h2) {
        this.int = c2;
        this.c = h2;
        this.f = new b.a.d.l();
        this.e = new k();
        this.e.a2 = this.f;
    }

    public h m() {
        return this.c;
    }

    public String int(String string) {
        int n2 = 0;
        while (n2 < this.void.length) {
            if (this.void[n2].length() > 0) {
                string = a.a.b.a(string, this.void[n2], "*");
            }
            ++n2;
        }
        return string;
    }

    public b.a.c.b.e c() {
        return this.a;
    }

    public af void() {
        return this.new;
    }

    public void if() {
        ++this.byte;
        if (d != null && this.a != null && this.a.aK() != null && this.byte % 100 == 0) {
            int n2 = (int)(Math.random() * (double)d.length);
            this.a.aK().goto(d[n2]);
        }
    }

    public a.e.c h() {
        return this.int.do();
    }

    public e char() {
        return this.case;
    }

    public void a() {
        this.int.int().pauseMusic();
    }

    public void n() {
        if (this.void == null) {
            byte[] byArray = this.int.do().do("filters.txt");
            if (byArray == null) {
                this.void = new String[0];
            } else {
                String string = new String(byArray);
                this.void = a.a.b.a(string, "\r\n");
            }
        }
        v.if.a(this.int.do());
        v.if.int("pak/ui.zip");
        if (b.a.c.b.e.aZ == null) {
            b.a.c.b.e.aZ = v.if.if("image/ui/ui.img", false);
        }
        if (b.a.c.b.e.a5 == null) {
            b.a.c.b.e.a5 = v.if.if("image/ui/icon.img", false);
        }
        if (b.a.c.b.e.aZ == null) {
            b.a.c.b.e.aZ = v.if.do("image/ui/ui.gif");
        }
        if (b.a.c.b.e.a5 == null) {
            b.a.c.b.e.a5 = v.if.do("image/ui/icon.gif");
        }
        u.aK = b.a.c.b.e.a5;
        this.else = new s();
        this.else.setBounds(10, 11, this.c.getWidth() - 20, this.c.getHeight() - 22);
        this.c.add(this.else);
        this.char = new aw();
        this.char.setBounds(0, 0, this.else.getWidth(), this.else.getHeight());
        this.else.add(this.char);
        this.if = new aj(this);
        this.if.cQ();
        this.else.add(this.if);
        this.new = new af(this);
        this.new.cL();
        this.else.add(this.new);
        this.goto = new s();
        this.goto.setBounds(0, 0, this.else.getWidth(), this.else.getHeight());
        this.else.add(this.goto);
        this.case = new e(this);
        this.case.a("tip");
    }

    public void l() {
        this.goto.removeAll();
        az az2 = new az(this);
        az2.setBounds(this.else.getWidth() / 2 - 300, this.else.getHeight() / 2 - 200, 600, 400);
        az2.bG();
        this.goto.add(az2);
        az2.bH();
    }

    public int if(String string, int n2) {
        String string2 = this.int.getParameter(string);
        if (string2 != null && string2.length() > 0) {
            try {
                int n3 = Integer.parseInt(string2, 16);
                return n3 |= 0xFF000000;
            }
            catch (NumberFormatException numberFormatException) {}
        }
        return n2;
    }

    public k for() {
        return this.e;
    }

    public c do() {
        return this.int;
    }
}

