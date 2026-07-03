/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.s;
import b.a.c.b;
import b.a.c.b.e;
import b.a.c.b.j;
import java.awt.event.MouseEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class au
extends s {
    private static final String[] dM = new String[]{"\u5168\u90e8", "\u4e16\u754c", "\u961f\u4f0d", "\u516c\u4f1a", "\u5bc6\u804a", "\u7cfb\u7edf"};
    private static final String[] dP = new String[]{"region", "world", "team", "guild", "whisper", "system"};
    private b dJ;
    private j[] dS = new j[dM.length];
    private int dR;
    private int dN = 54;
    private int dK = 20;
    private boolean[] dH = new boolean[]{true, true, true, true, true, true};
    private final int[] dI;
    private int dL;
    private int dQ;
    private int dO;

    public j by() {
        return this.dS[this.dR];
    }

    public void b(String string) {
        int n2 = 0;
        while (n2 < this.dS.length) {
            if (string.equals(this.dS[n2].getName())) {
                this.dS[this.dR].setVisible(false);
                this.dR = n2;
                this.dS[n2].setVisible(true);
                break;
            }
            ++n2;
        }
        this.repaint();
    }

    public void if(String string, String string2) {
        this.a(string, string2, 0);
    }

    public void a(String string, String string2, int n2) {
        j j2 = this.void(string);
        if (j2 == null) {
            return;
        }
        j2.a(string2, n2);
    }

    public void a(String string, String string2, int n2, String string3) {
        j j2 = this.void(string);
        if (j2 == null) {
            return;
        }
        j2.a(string2, n2, string3);
        if (j2 != this.dS[0] && this.dH[this.a(j2)]) {
            this.dS[0].a("\u3013" + au.long(string) + "\u3013", this.dI[this.a(j2)], string2, n2, string3);
        }
    }

    public void a(String string, String string2, int n2, String string3, int n3) {
        j j2 = this.void(string);
        if (j2 == null) {
            return;
        }
        j2.a(string2, n2, string3, n3);
        if (j2 != this.dS[0] && this.dH[this.a(j2)]) {
            this.dS[0].a("\u3013" + au.long(string) + "\u3013", this.dI[this.a(j2)], string2, n2, string3, n3);
        }
    }

    public void a(String string, String string2, int n2, String string3, String string4, int n3, String string5, int n4) {
        j j2 = this.void(string);
        if (j2 == null) {
            return;
        }
        j2.a(this.dJ, string2, n2, string3, string4, n3, string5, n4);
        if (j2 != this.dS[0] && this.dH[this.a(j2)]) {
            this.dS[0].a(this.dJ, "\u3013" + au.long(string) + "\u3013", this.dI[this.a(j2)], string2, n2, string3, string4, n3, string5, n4);
        }
    }

    public au(b b2) {
        int[] nArray = new int[6];
        nArray[1] = -588294;
        nArray[2] = -11747483;
        nArray[3] = -6570462;
        nArray[4] = -15750175;
        this.dI = nArray;
        this.dL = -13422032;
        this.dQ = -14736596;
        this.dO = 0xFFFFFF;
        this.dJ = b2;
        this.enableEvents(16L);
    }

    public void a(c c2) {
        c2.a(0, 3, this.getWidth(), 20, -16777216);
        c2.a(0, 23, this.getWidth(), this.getHeight(), -10720172);
        e.if(c2, 0, 23, this.getWidth(), this.getHeight() - 23);
        int n2 = 2;
        int n3 = 3;
        int n4 = 0;
        while (n4 < dM.length) {
            if (this.dR != n4) {
                c2.a(n2 + 4, n3 + 3, this.dN - 8, this.dK - 3, this.dL);
                c2.if(e.aZ, n2, n3, 314, 202, this.dN, this.dK);
                c2.a(dM[n4], n2 + 15, n3 + 4, -1);
            }
            ++n4;
            n2 += this.dN;
        }
        n2 = this.dR * this.dN;
        n3 = 0;
        c2.a(n2 + 4, n3 + 3, this.dN, this.dK + 4, this.dS[this.dR].aQ());
        if (this.dR == 0) {
            c2.if(e.aZ, n2, n3, 372, 198, this.dN + 7, this.dK + 8);
        } else {
            c2.if(e.aZ, n2, n3, 372, 198, this.dN + 7, this.dK + 3);
        }
        c2.a(dM[this.dR], n2 + 19, n3 + 5, -1);
        super.a(c2);
    }

    protected void processMouseEvent(MouseEvent mouseEvent) {
        if (mouseEvent.getID() == 501) {
            int n2;
            int n3 = mouseEvent.getX();
            int n4 = mouseEvent.getY();
            if (n4 < 20 && (n2 = n3 / 54) < this.dS.length && n2 != this.dR) {
                this.dS[this.dR].setVisible(false);
                this.dR = n2;
                this.dS[this.dR].setVisible(true);
                this.repaint();
            }
        }
    }

    private static final String long(String string) {
        int n2 = 0;
        while (n2 < dP.length) {
            if (string.equals(dP[n2])) {
                return dM[n2];
            }
            ++n2;
        }
        return "\u672a\u77e5\u9891\u9053";
    }

    public j void(String string) {
        int n2 = 0;
        while (n2 < this.dS.length) {
            if (string.equals(this.dS[n2].getName())) {
                return this.dS[n2];
            }
            ++n2;
        }
        return null;
    }

    public int a(j j2) {
        int n2 = 0;
        while (n2 < this.dS.length) {
            if (this.dS[n2] == j2) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    public j[] bx() {
        return this.dS;
    }

    public void bz() {
        this.dQ = this.dJ.if("chatBackground", this.dQ);
        this.dO = this.dJ.if("chatForeground", this.dO);
        this.dL = this.dJ.if("channelButtonColor", this.dL);
        int n2 = 0;
        while (n2 < this.dS.length) {
            j j2 = new j(this.dJ, this.dQ, this.dO);
            j2.setBounds(4, 27, this.getWidth() - 8, this.getHeight() - 30);
            j2.setName(dP[n2]);
            this.dS[n2] = j2;
            this.dS[n2].setVisible(n2 == 0);
            this.add(j2);
            ++n2;
        }
    }

    public void a(int n2, boolean bl) {
        this.dH[n2] = bl;
        if (bl) {
            this.dJ.goto().int("\u4f60\u5f00\u542f\u4e86" + dM[n2] + "\u9891\u9053\u6d88\u606f\u5728\u573a\u666f\u9891\u9053\u7684\u663e\u793a", -1627389952, 0xFEEF00);
        } else {
            this.dJ.goto().int("\u4f60\u5173\u95ed\u4e86" + dM[n2] + "\u9891\u9053\u6d88\u606f\u5728\u573a\u666f\u9891\u9053\u7684\u663e\u793a", -1627389952, 0xFEEF00);
        }
    }

    public boolean n(int n2) {
        return this.dH[n2];
    }
}

