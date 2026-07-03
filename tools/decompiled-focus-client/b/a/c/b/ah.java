/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.s;
import b.a.c.b;
import b.a.c.b.ap;
import b.a.d.d;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ah
extends s
implements ActionListener {
    private static final int cU = 26;
    private static final String[] cX = new String[]{"\u5bdf\u770b\u4fe1\u606f", "\u53d1\u9001\u5bc6\u8bed", "\u8e22\u51fa\u961f\u4f0d", ""};
    private static final String[] cT = new String[]{"view", "whisper", "kick", "leave"};
    private b cR;
    private int cW = 0;
    private boolean cS;
    private ap[] cV = new ap[5];
    private int cQ;

    public void a(d[] dArray) {
        this.cS = false;
        int n2 = 0;
        while (n2 < dArray.length) {
            this.cV[n2] = new ap();
            this.cV[n2].setBounds(0, n2 * 28, 120, 26);
            this.cV[n2].if(dArray[n2]);
            this.add(this.cV[n2]);
            ++n2;
        }
        this.cW = dArray.length;
        this.setSize(120, this.cW * 28);
        ah.cX[3] = "\u9000\u51fa\u961f\u4f0d";
    }

    public void bl() {
        int n2 = 0;
        while (n2 < this.cW) {
            this.remove(this.cV[n2]);
            this.cV[n2] = null;
            ++n2;
        }
        this.cW = 0;
        this.cS = false;
        this.setSize(120, this.cW * 28);
    }

    public ah(b b2) {
        this.cR = b2;
        this.enableEvents(16L);
    }

    protected void processMouseEvent(MouseEvent mouseEvent) {
        int n2 = mouseEvent.getX();
        int n3 = mouseEvent.getY();
        if (mouseEvent.getID() == 501 && (mouseEvent.getModifiers() & 4) != 0) {
            this.cQ = n3 / 28;
            this.a(cX, cT, this, n2, n3);
        }
    }

    public void for(int n2, int n3) {
        int n4 = 0;
        while (n4 < this.cW) {
            if (this.cV[n4].bu().if == n2) {
                this.cV[n4].bu().ar = n3;
                break;
            }
            ++n4;
        }
    }

    public boolean bm() {
        return this.cW > 0;
    }

    public void bo() {
        this.cS = true;
        ah.cX[3] = "\u89e3\u6563\u961f\u4f0d";
    }

    public boolean bp() {
        return this.cS;
    }

    public boolean k(int n2) {
        int n3 = 0;
        while (n3 < this.cW) {
            if (this.cV[n3].bu().if == n2) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    public void j(int n2) {
        int n3 = 0;
        while (n3 < this.cW) {
            if (this.cV[n3].bu().if == n2) {
                this.remove(this.cV[n3]);
                this.cV[n3] = null;
                int n4 = n3 + 1;
                while (n4 < this.cW) {
                    this.cV[n4 - 1] = this.cV[n4];
                    if (this.cV[n4 - 1] != null) {
                        this.cV[n4 - 1].setBounds(0, (n4 - 1) * 28, 120, 26);
                    }
                    ++n4;
                }
                this.cW += -1;
                break;
            }
            ++n3;
        }
        this.setSize(120, this.cW * 28);
    }

    public void if(int n2, int n3, String string) {
        int n4 = 0;
        while (n4 < this.cW) {
            if (this.cV[n4].bu().if == n2) {
                d d2 = this.cV[n4].bu();
                d2.ae = n3;
                d2.as = string;
                break;
            }
            ++n4;
        }
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.equals("kick")) {
            if (this.cS) {
                if (this.cQ < this.cW) {
                    this.cR.byte().t(this.cV[this.cQ].bu().if);
                }
            } else {
                this.cR.new().if("\u4f60\u4e0d\u662f\u961f\u957f\uff0c\u6ca1\u6709\u8fd9\u4e2a\u6743\u9650", -65536);
            }
        } else if (string.equals("leave")) {
            if (this.cW > 0) {
                this.cR.byte().B();
                this.bl();
            }
        } else if (string.equals("view")) {
            this.cR.byte().case(this.cV[this.cQ].bu().a);
        } else if (string.equals("whisper") && this.cQ < this.cW) {
            this.cR.c().ag().t(this.cV[this.cQ].bu().a);
        }
    }

    public ap[] bk() {
        return this.cV;
    }

    public void int(int n2, int n3) {
        int n4 = 0;
        while (n4 < this.cW) {
            if (this.cV[n4].bu().if == n2) {
                this.cV[n4].bu().Q = n3;
                this.cV[n4].bw();
                break;
            }
            ++n4;
        }
    }

    public void a(d d2) {
        this.cV[this.cW] = new ap();
        this.cV[this.cW].setBounds(0, this.cW * 28, 120, 26);
        this.cV[this.cW].if(d2);
        this.add(this.cV[this.cW]);
        ++this.cW;
        this.setSize(120, this.cW * 28);
    }

    public void new(int n2, int n3) {
        int n4 = 0;
        while (n4 < this.cW) {
            if (this.cV[n4].bu().if == n2) {
                d d2 = this.cV[n4].bu();
                d2.r = n3;
                if (d2.Q > n3) {
                    d2.Q = n3;
                }
                this.cV[n4].bw();
                break;
            }
            ++n4;
        }
    }

    public void if(int n2, int n3, int n4) {
        int n5 = 0;
        while (n5 < this.cW) {
            if (this.cV[n5].bu().if == n2) {
                d d2 = this.cV[n5].bu();
                d2.void = n3;
                d2.long = n4;
                break;
            }
            ++n5;
        }
    }

    public void bn() {
        this.setBounds(2, 100, 120, 0);
    }

    public void a(int n2, int n3, int n4) {
        int n5 = 0;
        while (n5 < this.cW) {
            if (this.cV[n5].bu().if == n2) {
                d d2 = this.cV[n5].bu();
                d2.p = n3;
                d2.Q = d2.r = n4;
                this.cV[n5].bw();
                break;
            }
            ++n5;
        }
    }
}

