/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javassist.runtime.DotClass
 */
package b.a.c;

import a.a.h;
import a.b.af;
import a.b.v;
import a.e.c;
import b.a.b.f;
import b.a.b.g;
import b.a.b.i;
import b.a.b.j;
import b.a.b.p;
import b.a.b.q;
import b.a.b.s;
import b.a.b.t;
import b.a.c.b;
import b.a.c.b.a0;
import java.io.UnsupportedEncodingException;
import javassist.runtime.DotClass;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class e
extends Thread {
    private static e if;
    private static h int;
    private static int a;
    private b do;
    private boolean for;

    private void a(af af2) {
        int n = af2.int();
        af2.try();
        int n2 = af2.try() / 8;
        int n3 = n / n2;
        int[] nArray = new int[n];
        int n4 = 5;
        do {
            int n5 = 0;
            while (n5 < n2) {
                int n6 = 0;
                while (n6 < n) {
                    nArray[n6] = 0;
                    ++n6;
                }
                n6 = (8 - n4) * n2 + n5;
                af2.if(n6, nArray, 0);
                int n7 = 0;
                while (n7 < n3) {
                    int n8 = n7 * n2;
                    int n9 = n7 * n2 + n2 - 1;
                    int n10 = n8;
                    int n11 = n9;
                    int n12 = n2 / 2;
                    int n13 = 0;
                    while (n13 < n12) {
                        int n14 = nArray[n10];
                        nArray[n10] = nArray[n11];
                        nArray[n11] = n14;
                        ++n10;
                        --n11;
                        ++n13;
                    }
                    ++n7;
                }
                af2.a(n4 * n2 + n5, nArray, 0);
                ++n5;
            }
        } while (++n4 < 8);
    }

    private void do(String string) {
        if (string.equals("tip")) {
            c c2 = v.if.int();
            byte[] byArray = c2.do("data/tips.txt");
            if (byArray != null) {
                String string2 = "";
                try {
                    string2 = new String(byArray, "GB2312");
                }
                catch (UnsupportedEncodingException unsupportedEncodingException) {
                    unsupportedEncodingException.printStackTrace();
                }
                String[] stringArray = a.a.b.a(string2, "\r\n");
                this.do.a(stringArray);
            }
        } else if (string.equals("hero")) {
            v.if.int("pak/hero.zip");
            b.a.c.b.e.a3[0][0] = v.if.if("image/hero/00.img", false);
            b.a.c.b.e.a3[0][1] = v.if.if("image/hero/01.img", false);
            b.a.c.b.e.a3[1][0] = v.if.if("image/hero/10.img", false);
            b.a.c.b.e.a3[1][1] = v.if.if("image/hero/11.img", false);
            b.a.c.b.e.a3[2][0] = v.if.if("image/hero/20.img", false);
            b.a.c.b.e.a3[2][1] = v.if.if("image/hero/21.img", false);
        } else if (string.equals("npc")) {
            this.do();
        } else if (string.startsWith("hero:")) {
            int n = string.charAt(string.length() - 3) - 48;
            int n2 = string.charAt(string.length() - 2) - 48;
            int n3 = string.charAt(string.length() - 1) - 48;
            this.a(n, n2, n3);
        } else if (string.startsWith("map:")) {
            String[] stringArray = a.a.b.a(string, ":");
            this.if(stringArray[1]);
        } else if (string.startsWith("monster:")) {
            String[] stringArray = a.a.b.a(string, ":");
            this.if(Integer.parseInt(stringArray[1]));
        } else if (string.startsWith("effect")) {
            this.for();
        } else if (string.startsWith("magic:")) {
            String[] stringArray = a.a.b.a(string, ":");
            this.a(Integer.parseInt(stringArray[1]));
        }
    }

    public e(b b2) {
        super("daemonLoader");
        this.setDaemon(true);
        this.do = b2;
        if = this;
    }

    private void a(int n, int n2, int n3) {
        String string = String.valueOf(n) + String.valueOf(n2);
        v.if.int("pak/hero/" + string + "/" + n3 + ".zip");
        string = string + "/" + n3;
        int n4 = n * 2 + n2;
        p.ag[n4][n3][0] = v.if.if("image/hero/" + string + "/0.img", false);
        p.ag[n4][n3][1] = v.if.if("image/hero/" + string + "/1.img", false);
        p.ag[n4][n3][2] = v.if.if("image/hero/" + string + "/2.img", false);
        p.ag[n4][n3][4] = v.if.if("image/hero/" + string + "/4.img", false);
        if (p.ag[n4][n3][0] != null) {
            this.a(p.ag[n4][n3][0]);
        }
        if (p.ag[n4][n3][1] != null) {
            this.a(p.ag[n4][n3][1]);
        }
        if (p.ag[n4][n3][2] != null) {
            this.a(p.ag[n4][n3][2]);
        }
    }

    private void if(String string) {
        String[] stringArray = a.a.b.a(string, "-");
        int n = Integer.parseInt(stringArray[0]);
        int n2 = Integer.parseInt(stringArray[1]);
        v.if.int("pak/mapimg/" + string + ".zip");
        int n3 = n;
        while (n3 <= n2) {
            q.long[n3] = v.if.if("image/map/" + n3 + ".img", false);
            ++n3;
        }
    }

    private void for() {
        v.if.int("pak/effect.zip");
        g.f = v.if.if("image/effect/flyer.img", false);
        j.B = v.if.if("image/effect/num.img", false);
        j.v = v.if.if("image/effect/blood.img", false);
        p.W[0] = v.if.if("image/effect/halo.img", false);
        p.W[1] = v.if.if("image/effect/halo2.img", false);
        a0.ev = v.if.if("image/effect/giftchat.img", false);
        f.O = v.if.if("image/effect/guild.img", false);
        int n = 1;
        do {
            p.Z[n] = v.if.if("image/effect/turn" + n + ".img", false);
        } while (++n <= 6);
        n = 7;
        while (n < p.Z.length) {
            p.Z[n] = p.Z[6];
            ++n;
        }
        n = 0;
        do {
            i.o[n] = v.if.if("image/effect/" + (n + 1) + ".img", false);
        } while (i.o[n] != null && ++n < 100);
        s.aD = v.if.for("image/effect/mouse.img");
        Object var3_2 = null;
        try {
            Class<?> clazz;
            Object object = Class.forName("a.b.v").getField("if").get(null);
            Class[] classArray = new Class[2];
            try {
                clazz = Class.forName("java.lang.String");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw DotClass.fail((ClassNotFoundException)classNotFoundException);
            }
            classArray[0] = clazz;
            classArray[1] = Boolean.TYPE;
            Object object2 = object.getClass().getMethod("if", classArray).invoke(object, "image/effect/title.img", Boolean.FALSE);
            Class.forName("b.a.b.p").getField("title").set(null, object2);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        Object var8_6 = null;
        try {
            Class<?> clazz;
            Object object = Class.forName("a.b.v").getField("if").get(null);
            Class[] classArray = new Class[2];
            try {
                clazz = Class.forName("java.lang.String");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw DotClass.fail((ClassNotFoundException)classNotFoundException);
            }
            classArray[0] = clazz;
            classArray[1] = Boolean.TYPE;
            Object object3 = object.getClass().getMethod("if", classArray).invoke(object, "image/effect/aura_dragon.img", Boolean.FALSE);
            Class.forName("b.a.b.p").getField("auraDragon").set(null, object3);
        }
        catch (Throwable throwable) {}
    }

    public void a(String string) {
        h h2 = int;
        synchronized (h2) {
            int n = int.for();
            int n2 = 0;
            while (n2 < n) {
                if (int.if(n2).equals(string)) {
                    Object var5_5 = null;
                    return;
                }
                ++n2;
            }
            int.if(string);
            Object var5_6 = null;
        }
    }

    private void a(int n) {
        b.a.b.v.aU[n] = v.if.for("image/magic/" + n + ".gif");
    }

    static {
        int = new h(500);
    }

    private void if(int n) {
        v.if.int("pak/monster/" + n + ".zip");
        b.a.b.e.L[n][0] = v.if.if("image/monster/" + n + "/0.img", false);
        b.a.b.e.L[n][1] = v.if.if("image/monster/" + n + "/1.img", false);
        b.a.b.e.L[n][2] = v.if.if("image/monster/" + n + "/2.img", false);
        if (b.a.b.e.L[n][0] != null) {
            this.a(b.a.b.e.L[n][0]);
        }
        if (b.a.b.e.L[n][1] != null) {
            this.a(b.a.b.e.L[n][1]);
        }
        if (b.a.b.e.L[n][2] != null) {
            this.a(b.a.b.e.L[n][2]);
        }
    }

    private void do() {
        v.if.int("pak/npc.zip");
        int n = 1;
        do {
            b.a.b.b.a9[n] = v.if.if("image/npc/" + n + ".img", false);
        } while (b.a.b.b.a9[n] != null && ++n < 100);
        t.aG = v.if.for("image/npc/door.img");
    }

    public void run() {
        this.for = true;
        while (this.for) {
            if (a >= int.for()) {
                a.a.b.a(100);
                this.do.if();
                continue;
            }
            String string = "";
            h h2 = int;
            synchronized (h2) {
                string = (String)int.if(a);
                ++a;
                Object var3_3 = null;
            }
            this.do(string);
        }
    }

    public void if() {
        this.for = false;
    }

    public static e a() {
        return if;
    }
}
