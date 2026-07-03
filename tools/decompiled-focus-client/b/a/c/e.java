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
        int n2 = af2.int();
        af2.try();
        int n3 = af2.try() / 8;
        int n4 = n2 / n3;
        int[] nArray = new int[n2];
        int n5 = 5;
        do {
            int n6 = 0;
            while (n6 < n3) {
                int n7 = 0;
                while (n7 < n2) {
                    nArray[n7] = 0;
                    ++n7;
                }
                n7 = (8 - n5) * n3 + n6;
                af2.if(n7, nArray, 0);
                int n8 = 0;
                while (n8 < n4) {
                    int n9 = n8 * n3;
                    int n10 = n8 * n3 + n3 - 1;
                    int n11 = n9;
                    int n12 = n10;
                    int n13 = n3 / 2;
                    int n14 = 0;
                    while (n14 < n13) {
                        int n15 = nArray[n11];
                        nArray[n11] = nArray[n12];
                        nArray[n12] = n15;
                        ++n11;
                        --n12;
                        ++n14;
                    }
                    ++n8;
                }
                af2.a(n5 * n3 + n6, nArray, 0);
                ++n6;
            }
        } while (++n5 < 8);
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
            int n2 = string.charAt(string.length() - 3) - 48;
            int n3 = string.charAt(string.length() - 2) - 48;
            int n4 = string.charAt(string.length() - 1) - 48;
            this.a(n2, n3, n4);
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

    private void a(int n2, int n3, int n4) {
        String string = String.valueOf(n2) + String.valueOf(n3);
        v.if.int("pak/hero/" + string + "/" + n4 + ".zip");
        string = string + "/" + n4;
        int n5 = n2 * 2 + n3;
        p.ag[n5][n4][0] = v.if.if("image/hero/" + string + "/0.img", false);
        p.ag[n5][n4][1] = v.if.if("image/hero/" + string + "/1.img", false);
        p.ag[n5][n4][2] = v.if.if("image/hero/" + string + "/2.img", false);
        p.ag[n5][n4][4] = v.if.if("image/hero/" + string + "/4.img", false);
        if (p.ag[n5][n4][0] != null) {
            this.a(p.ag[n5][n4][0]);
        }
        if (p.ag[n5][n4][1] != null) {
            this.a(p.ag[n5][n4][1]);
        }
        if (p.ag[n5][n4][2] != null) {
            this.a(p.ag[n5][n4][2]);
        }
    }

    private void if(String string) {
        String[] stringArray = a.a.b.a(string, "-");
        int n2 = Integer.parseInt(stringArray[0]);
        int n3 = Integer.parseInt(stringArray[1]);
        v.if.int("pak/mapimg/" + string + ".zip");
        int n4 = n2;
        while (n4 <= n3) {
            q.long[n4] = v.if.if("image/map/" + n4 + ".img", false);
            ++n4;
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
        int n2 = 1;
        do {
            p.Z[n2] = v.if.if("image/effect/turn" + n2 + ".img", false);
        } while (++n2 <= 6);
        n2 = 7;
        while (n2 < p.Z.length) {
            p.Z[n2] = p.Z[6];
            ++n2;
        }
        n2 = 0;
        do {
            i.o[n2] = v.if.if("image/effect/" + (n2 + 1) + ".img", false);
        } while (i.o[n2] != null && ++n2 < 100);
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
            int n2 = int.for();
            int n3 = 0;
            while (n3 < n2) {
                if (int.if(n3).equals(string)) {
                    Object var5_5 = null;
                    return;
                }
                ++n3;
            }
            int.if(string);
            Object var5_6 = null;
        }
    }

    private void a(int n2) {
        b.a.b.v.aU[n2] = v.if.for("image/magic/" + n2 + ".gif");
    }

    static {
        int = new h(500);
    }

    private void if(int n2) {
        v.if.int("pak/monster/" + n2 + ".zip");
        b.a.b.e.L[n2][0] = v.if.if("image/monster/" + n2 + "/0.img", false);
        b.a.b.e.L[n2][1] = v.if.if("image/monster/" + n2 + "/1.img", false);
        b.a.b.e.L[n2][2] = v.if.if("image/monster/" + n2 + "/2.img", false);
        if (b.a.b.e.L[n2][0] != null) {
            this.a(b.a.b.e.L[n2][0]);
        }
        if (b.a.b.e.L[n2][1] != null) {
            this.a(b.a.b.e.L[n2][1]);
        }
        if (b.a.b.e.L[n2][2] != null) {
            this.a(b.a.b.e.L[n2][2]);
        }
    }

    private void do() {
        v.if.int("pak/npc.zip");
        int n2 = 1;
        do {
            b.a.b.b.a9[n2] = v.if.if("image/npc/" + n2 + ".img", false);
        } while (b.a.b.b.a9[n2] != null && ++n2 < 100);
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

