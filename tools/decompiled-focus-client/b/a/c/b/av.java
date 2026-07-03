/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.z;
import b.a.c.b;
import b.a.c.b.al;
import b.a.c.b.at;
import b.a.c.b.e;
import b.a.c.b.g;
import b.a.d.k;
import b.a.e.j;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class av
extends z
implements ActionListener {
    private b jY = null;
    private String kj = "";
    private int j4 = 260;
    private int kf = 300;
    private int[] jV = new int[20];
    private int[] jT = new int[20];
    private j[] j8 = new j[20];
    private static final String[] j6 = new String[]{"\u5143\u5b9d", "\u91d1\u5e01", "\u529f\u52cb"};
    private static final int[] j5 = new int[]{0xFFFFFF, 13567751};
    private int kg = 35;
    private int x = 28;
    private int y = 48;
    private int kb = 0;
    private boolean kc = true;
    private boolean j2;
    private int j3 = 0;
    private boolean jR = false;
    private int ki = 50;
    private int jU;
    private j jX;
    private boolean kd;
    private int[] jZ = new int[3];
    private int[] j1 = new int[3];
    private String j9 = "loading....";
    private long kh = System.currentTimeMillis();
    private j j7;
    private int jS = -1;
    private al jW = null;
    private int j0 = 0;
    private al[] ke = new al[3];
    private int ka = -1;

    private void r(int n2, int n3) {
        j j2 = this.s(n2, n3);
        if (j2 != this.jX) {
            if (j2 != null) {
                at at2 = at.b();
                at2.a(j2, false, false, 0, 0, false);
                this.a(null, at2, n2, n3);
            } else {
                this.dc();
            }
            this.jX = j2;
        }
    }

    private j s(int n2, int n3) {
        this.jU = -1;
        int n4 = 0;
        while (n4 < this.jV.length) {
            if (n2 > this.jV[n4] + 2 && n2 < this.jV[n4] + 26 && n3 > this.jT[n4] + 1 && n3 < this.jT[n4] + 25) {
                this.jU = n4;
                return this.j8[n4];
            }
            ++n4;
        }
        return null;
    }

    public av(b b2) {
        this.jY = b2;
        this.kj = "\u5e78\u8fd0\u62bd\u5956";
        this.char(true);
        this.setVisible(false);
    }

    public void a(c c2) {
        e.a(c2, this.kj, this.getWidth(), this.getHeight());
        j j2 = null;
        if (!this.kc) {
            int n2 = 0;
            while (n2 < this.jV.length) {
                j2 = this.j8[n2];
                e.a(c2, this.jV[n2], this.jT[n2]);
                if (j2 != null) {
                    e.a(c2, j2, this.jV[n2] + 2, this.jT[n2] + 1);
                }
                ++n2;
            }
            c2.if(this.jV[this.kb] - 3, this.jT[this.kb] - 3, 35, 35, Color.yellow.getRGB());
            c2.a("\u8bf7\u9009\u62e9\u62bd\u5956\u65b9\u5f0f:", this.x + this.kg + 20, this.y + this.kg + 5, Color.green.getRGB());
            n2 = 0;
            while (n2 < j6.length) {
                c2.a(j6[n2] + "\u6d88\u8017: " + this.jZ[n2], this.x + this.kg + 33, this.y + this.kg + 20 + n2 * 35 + 3, j5[this.j1[n2]]);
                ++n2;
            }
        } else {
            c2.a(this.j9, this.getWidth() / 2, (this.getHeight() - 30) / 2, Color.white.getRGB());
        }
        super.a(c2);
    }

    public void setVisible(boolean bl) {
        if (!bl) {
            this.dc();
            if (this.jW != null) {
                this.jW.else("\u5f00\u59cb");
            }
            this.j2 = false;
            if (this.jS >= 0 || this.jR) {
                int n2 = this.jY.for().bA.O();
                this.jY.for().bA.fr[n2] = this.j7;
            }
        }
        super.setVisible(bl);
    }

    private void de() {
        this.j1[2] = 0;
        this.j1[1] = 0;
        this.j1[0] = 0;
        k k2 = this.jY.for();
        if (k2.a2.dg < this.jZ[0]) {
            this.j1[0] = 1;
            if (this.ka == 0) {
                this.ka = -1;
            }
        }
        if (k2.bA.fk < this.jZ[1]) {
            this.j1[1] = 1;
            if (this.ka == 1) {
                this.ka = -1;
            }
        }
        if (k2.bi < this.jZ[2]) {
            this.j1[2] = 1;
            if (this.ka == 2) {
                this.ka = -1;
            }
        }
        if (this.ka == -1) {
            int n2 = 0;
            while (n2 < this.j1.length) {
                if (this.j1[n2] != 1) {
                    this.ka = n2;
                    this.ke[n2].else("\u221a");
                    break;
                }
                ++n2;
            }
            n2 = 0;
            while (n2 < this.j1.length) {
                if (this.ka != n2) {
                    this.ke[n2].else("");
                }
                ++n2;
            }
        }
    }

    public void a(int[] nArray, j[] jArray) {
        this.j8 = jArray;
        this.jZ = nArray;
        this.kc = false;
        this.de();
    }

    private void dc() {
        this.a((Rectangle)null, (a.b.b)null, 0, 0);
    }

    public void a(long l2) {
        this.de();
        if (this.j2 && (this.jR || l2 - this.kh > (long)this.ki)) {
            if (!this.jR && this.kd && this.jS > 0) {
                this.ki += this.j0;
                this.jS += -1;
            }
            if (this.jS == 0) {
                this.j2 = false;
                int n2 = this.jY.for().bA.O();
                this.jY.for().bA.fr[n2] = this.j7;
                String string = "\u672c\u6b21\u62bd\u5956\u83b7\u5f97\u5956\u54c1:" + this.j7.a + ", \u662f\u5426\u7ee7\u7eed\u62bd\u5956?";
                this.jY.new().if(string, -16711936, "ok", "no", this);
                this.jS = -1;
            }
            this.kb = this.kb == this.jV.length - 1 ? 0 : ++this.kb;
            this.kh = l2;
        }
    }

    public void actionPerformed(ActionEvent actionEvent) {
        block13: {
            String string;
            block11: {
                al al2;
                block14: {
                    block12: {
                        string = actionEvent.getActionCommand();
                        Object object = actionEvent.getSource();
                        if (!string.equals("begin")) break block11;
                        this.jR = !this.jR;
                        al2 = (al)object;
                        if (!"\u5f00\u59cb".equals(al2.br())) break block12;
                        if (this.ka >= 0) {
                            this.jY.byte().C(this.ka);
                        }
                        break block13;
                    }
                    if (!"\u505c\u6b62".equals(al2.br())) break block14;
                    this.jR = false;
                    int n2 = this.j8.length - 1;
                    this.jS = n2 - this.kb + this.j3 + 1;
                    this.jS = this.jS > 16 ? this.jS : this.jS + 20;
                    this.j0 = 750 / this.jS;
                    al2.else("\u5173\u95ed");
                    break block13;
                }
                if (!"\u5173\u95ed".equals(al2.br())) break block13;
                al2.else("\u5f00\u59cb");
                this.j2 = false;
                this.setVisible(false);
                break block13;
            }
            if (string.equals("ok")) {
                this.jS = -1;
                this.jY.new().setVisible(false);
                this.jW.else("\u5f00\u59cb");
                this.de();
            } else if (string.equals("no")) {
                this.jY.new().setVisible(false);
                this.setVisible(false);
            } else if (string.startsWith("select:")) {
                int n3 = Integer.parseInt(string.substring("select:".length()));
                if (this.j1[n3] == 1) {
                    this.jY.new().if("\u4f60\u7684" + j6[n3] + "\u4e0d\u8db3,\u8bf7\u9009\u62e9\u5176\u4ed6\u62bd\u5956\u65b9\u5f0f!", Color.green.getRGB());
                } else {
                    int n4 = 0;
                    while (n4 < this.ke.length) {
                        if (n4 == n3) {
                            this.ka = n3;
                            this.ke[n4].else("\u221a");
                        } else {
                            this.ke[n4].else("");
                        }
                        ++n4;
                    }
                }
            }
        }
    }

    protected void processMouseMotionEvent(MouseEvent mouseEvent) {
        if (mouseEvent.getID() == 503) {
            this.r(mouseEvent.getX(), mouseEvent.getY());
        } else if (mouseEvent.getY() < 30) {
            super.processMouseMotionEvent(mouseEvent);
        }
    }

    public void df() {
        this.setBounds(50, 50, this.j4, this.kf);
        this.add(new g(this.getWidth() - 23, 7, 15, 15));
        this.jW = al.a(2, "\u5f00\u59cb", "begin", this, 110, this.getHeight() - 25, 44, 19);
        this.add(this.jW);
        String[] stringArray = new String[]{"select:0", "select:1", "select:2"};
        int n2 = 0;
        while (n2 < stringArray.length) {
            this.ke[n2] = al.a(0, "", stringArray[n2], this, this.x + this.kg + 10, this.y + this.kg + 20 + n2 * 35, 20, 20);
            this.add(this.ke[n2]);
            ++n2;
        }
        this.jV[0] = this.x;
        this.jT[0] = this.y;
        n2 = 0;
        do {
            this.jV[n2] = n2 == 0 ? this.x : this.jV[n2 - 1] + this.kg;
            this.jV[n2 + 10] = (5 - n2) * this.kg + this.x;
            this.jT[n2] = this.y;
            this.jT[n2 + 10] = this.kg * 5 + this.y;
            if (n2 >= 4) continue;
            this.jV[n2 + 6] = this.x + 5 * this.kg;
            this.jV[n2 + 16] = this.x;
            this.jT[n2 + 6] = this.y + (n2 + 1) * this.kg;
            this.jT[n2 + 16] = (4 - n2) * this.kg + this.y;
        } while (++n2 < 6);
        this.kb = 0;
    }

    public void dd() {
        if (this.isVisible()) {
            return;
        }
        int n2 = 0;
        while (n2 < this.j8.length) {
            this.j8[n2] = null;
            ++n2;
        }
        n2 = 0;
        while (n2 < this.jZ.length) {
            this.jZ[n2] = 0;
            ++n2;
        }
        this.setVisible(true);
        this.kb = 0;
        this.jS = -1;
        this.jY.byte().void();
    }

    public void for(j j2) {
        this.j7 = j2;
        int n2 = 0;
        while (n2 < this.j8.length) {
            if (this.j7.if == this.j8[n2].if) {
                this.j3 = n2;
                this.kd = true;
                break;
            }
            ++n2;
        }
        this.jW.else("\u505c\u6b62");
        this.ki = 50;
        this.jR = true;
        this.j2 = true;
    }
}

