/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.q;
import a.b.s;
import b.a.c.b;
import b.a.c.b.al;
import java.awt.event.MouseEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class a1
extends s {
    public static final int eH = 0;
    public static final int eI = 1;
    public static final int eD = 2;
    private b eE;
    private int eK;
    private int eN = -1358954496;
    private int eC;
    private int eF;
    private String eO = "";
    private int eB;
    private int eJ = 15000;
    private int eM;
    private int eL;
    private transient long eG;

    public int bM() {
        return this.eL;
    }

    public b bP() {
        return this.eE;
    }

    public void if(b b2) {
        this.eE = b2;
    }

    public int bL() {
        return this.eC;
    }

    public void r(int n2) {
        this.eC = n2;
    }

    public a1(String string, int n2, int n3) {
        this(0, string, n2, n3);
    }

    public a1(int n2, String string, int n3, int n4) {
        this.eK = n2;
        this.eO = string;
        this.eN = n3;
        this.eB = n4;
        this.setSize(q.if(this.eO) + 4, 18);
        if (n2 > 0) {
            this.setCursor(al.c7);
            this.enableEvents(48L);
        }
    }

    public void a(c c2) {
        c2.a(0, 0, this.getWidth(), this.getHeight(), this.eN);
        switch (this.eC) {
            case 0: {
                c2.a(this.eO, 2, 3, this.eB, this.eF);
                break;
            }
            case 1: {
                c2.a(this.eO, 2, 3, this.eB);
                break;
            }
            case 2: {
                c2.a(this.eO, 2, 3, this.eB);
                break;
            }
            case 3: {
                c2.a(this.eO, 2, 3, this.eB, this.eF);
            }
        }
    }

    protected void processMouseEvent(MouseEvent mouseEvent) {
        if (mouseEvent.getID() == 501) {
            if (this.eK == 1) {
                this.eE.c().ag().t(this.getName());
            } else if (this.eK == 2) {
                this.eE.new().if((String)this.case(), -1, "confirm:" + this.getName(), "cancel:" + this.getName(), this.eE);
            }
        }
    }

    public void try(int n2, int n3) {
        this.eM = n2;
        this.eL = n3;
    }

    public int bK() {
        return this.eJ;
    }

    public void q(int n2) {
        this.eJ = n2;
    }

    public int bN() {
        return this.eM;
    }

    public void a(long l2) {
        switch (this.eC) {
            case 0: {
                this.eF += 4;
                if (this.eF < 255) break;
                this.eC = 1;
                break;
            }
            case 1: {
                int n2;
                if (this.getX() > this.eM) {
                    n2 = Math.max(this.getX() - 20, this.eM);
                    this.setLocation(n2, this.getY());
                }
                if (this.getY() > this.eL) {
                    n2 = Math.max(this.getY() - 8, this.eL);
                    this.setLocation(this.getX(), n2);
                }
                if (this.getX() != this.eM || this.getY() != this.eL) break;
                this.eG = l2;
                this.eC = 2;
                break;
            }
            case 2: {
                if (l2 - this.eG <= (long)this.eJ) break;
                this.eC = 3;
                this.eF = 255;
                break;
            }
            default: {
                this.eF -= 4;
            }
        }
    }

    public boolean bO() {
        return this.eC < 3 || this.eF > 0;
    }
}

