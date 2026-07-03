/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs;

import app.island.data.Question;
import app.island.entity.Hero;
import app.island.gs.ServerInfo;
import app.island.gs.h;
import app.island.gs.p;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class g {
    public static final int new = 1;
    public static final int if = 2;
    private Question[] int;
    private h for;
    private int a = 0;
    private int try = 0;
    private int do = 0;

    public Question if() {
        return this.int[0];
    }

    private g() {
    }

    public void if(int n2) {
        int n3 = (int)(Math.pow(this.for.r().level, 2.0) / 10.0 + 20.0);
        n3 *= ServerInfo.expTimes;
        if (this.for.r().doubleExpLifeTime > 0) {
            n3 *= 2;
        }
        boolean bl = this.a(n2);
        Question question = this.a();
        switch (this.do) {
            case 1: {
                if (question != null) {
                    this.for.a(p.a(question, this.try, this.a));
                    break;
                }
                this.for.int(n3 *= this.try);
                this.for.a(p.case(this.try, this.a, n3));
                this.for.a((g)null);
                break;
            }
            case 2: {
                if (question != null) {
                    if (bl) {
                        this.for.a(p.a(question, this.try, this.a));
                        break;
                    }
                    this.for.a(p.case(this.try, this.a, n3 *= this.try));
                    this.for.a((g)null);
                    break;
                }
                this.for.int(n3 *= 3 * this.try);
                this.for.a(p.case(this.try, this.a, n3));
                this.for.a((g)null);
                break;
            }
        }
        Hero hero = this.for.r();
        ++hero.answerTimes;
        this.for.j().do().a(hero, 11);
    }

    private Question a() {
        ++this.a;
        if (this.a > this.int.length - 1) {
            return null;
        }
        Question question = this.int[this.a];
        return question;
    }

    public static g a(int n2, Question[] questionArray, h h2) {
        g g2 = new g();
        g2.do = n2;
        g2.int = questionArray;
        g2.for = h2;
        return g2;
    }

    public int do() {
        return this.int.length;
    }

    private boolean a(int n2) {
        boolean bl = false;
        if (n2 == this.int[this.a].answerIndex) {
            ++this.try;
            bl = true;
        }
        return bl;
    }
}

