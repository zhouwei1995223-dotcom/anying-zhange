/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.a;
import a.b.c;
import a.b.d;
import a.b.i;
import a.b.l;
import a.b.n;
import a.b.s;
import a.b.x;
import a.b.z;
import b.a.c.b;
import b.a.c.b.al;
import b.a.c.b.e;
import b.a.c.b.g;
import b.a.e.j;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ae
extends z
implements ActionListener,
i,
a {
    private static final long hU = -2858093048349790594L;
    private n hZ;
    private b hR;
    private al hV;
    private int[] hP = new int[2];
    private int[] hO = new int[2];
    private j[] h4 = new j[2];
    private j hQ;
    private al h1;
    private al h8;
    private al h2;
    private al h3;
    private String[] h6 = new String[]{"\u5f00\u59cb\u6302\u673a", "\u7ed3\u675f\u6302\u673a"};
    private String[] hS = new String[]{"start", "exit"};
    private String[] hX = new String[]{"90%", "80%", "70%", "60%", "50%", "40%", "30%", "20%"};
    private String[] hW = new String[]{"hp:0.9", "hp:0.8", "hp:0.7", "hp:0.6", "hp:0.5", "hp:0.4", "hp:0.3", "hp:0.2"};
    private String[] hY = new String[]{"mp:0.9", "mp:0.8", "mp:0.7", "mp:0.6", "mp:0.5", "mp:0.4", "mp:0.3", "mp:0.2"};
    private static final int h7 = 100;
    private static final int h0 = 19;
    private a.b.b h5 = new d("\u8bf7\u4ece\u80cc\u5305\u4e2d\uff0c\u653e\u5165\u4e00\u4e2a\u836f\u54c1");
    private a.b.b hT = new d("\u7cfb\u7edf\u4f18\u5148\u4f7f\u7528\u751f\u547d\u4e4b\u6e90\u548c\u9b54\u529b\u4e4b\u6e90");

    public ae(b b2) {
        this.hR = b2;
        this.setSize(400, 300);
        this.char(true);
        this.cJ();
        this.setVisible(false);
    }

    public void a() {
    }

    public void a(c c2) {
        e.a(c2, "\u81ea\u52a8\u6302\u673a", this.getWidth(), this.getHeight());
        c2.a("\u653b\u51fb\u7684\u602a\u7269\u8840\u91cf\u4f4e\u4e8e\uff1a", 100, 70, Color.white.getRGB());
        c2.a("\u8840\u91cf\u4f4e\u4e8e", 100, 110, Color.white.getRGB());
        c2.a("\u65f6\uff0c\u8d2d\u4e70\u5e76\u4f7f\u7528", 190, 110, Color.white.getRGB());
        c2.a("\u9b54\u6cd5\u4f4e\u4e8e", 100, 140, Color.white.getRGB());
        c2.a("\u65f6\uff0c\u8d2d\u4e70\u5e76\u4f7f\u7528", 190, 140, Color.white.getRGB());
        int n2 = 0;
        while (n2 < this.hP.length) {
            e.a(c2, this.hP[n2], this.hO[n2]);
            if (this.h4[n2] != null) {
                e.a(c2, this.h4[n2], this.hP[n2] + 2, this.hO[n2] + 1);
            }
            ++n2;
        }
        super.a(c2);
    }

    protected void processMouseEvent(MouseEvent mouseEvent) {
        if (mouseEvent.getID() == 500) {
            if (mouseEvent.getX() > 282 && mouseEvent.getX() < 304 && mouseEvent.getY() > 101 && mouseEvent.getY() < 120) {
                this.h4[0] = null;
                this.hR.e().char()[0] = null;
            } else if (mouseEvent.getX() > 282 && mouseEvent.getX() < 304 && mouseEvent.getY() > 130 && mouseEvent.getY() < 158) {
                this.h4[1] = null;
                this.hR.e().char()[1] = null;
            }
        } else {
            super.processMouseEvent(mouseEvent);
        }
    }

    public void setVisible(boolean bl) {
        super.setVisible(bl);
        if (!bl) {
            this.a((Rectangle)null, (a.b.b)null, 100, 100);
        }
    }

    public Object if() {
        return this.hQ;
    }

    protected void processMouseMotionEvent(MouseEvent mouseEvent) {
        if (mouseEvent.getID() == 503) {
            if (mouseEvent.getX() > 282 && mouseEvent.getX() < 304 && mouseEvent.getY() > 101 && mouseEvent.getY() < 150) {
                this.a(null, this.h5, mouseEvent.getX(), mouseEvent.getY());
            } else if (mouseEvent.getX() > 99 && mouseEvent.getY() > 110 && mouseEvent.getX() < 268 && mouseEvent.getY() < 168) {
                this.a(null, this.hT, 50, mouseEvent.getY());
            } else {
                this.a((Rectangle)null, (a.b.b)null, 100, 100);
            }
        } else {
            super.processMouseMotionEvent(mouseEvent);
        }
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.equals("start")) {
            int n2 = 10000;
            try {
                n2 = Integer.parseInt(this.hZ.D());
            }
            catch (Exception exception) {
                n2 = 10000;
            }
            if (n2 < 1) {
                n2 = 10000;
            }
            this.hZ.if("" + n2);
            this.hR.e().do(n2);
            if (this.hR.for().p < 30) {
                this.hR.new().if("\u4f4e\u4e8e30\u7ea7\u4e0d\u5141\u8bb8\u6302\u673a", -3253018);
                return;
            }
            this.hR.e().a(true);
            this.hV.char(this.hS[1]);
            this.hV.else(this.h6[1]);
        } else if (string.equals("exit")) {
            this.hR.e().a(false);
            this.hV.char(this.hS[0]);
            this.hV.else("\u7ee7\u7eed\u6302\u673a");
        } else if (string.equals("sureExit")) {
            this.cI();
        } else if (string.equals("damage")) {
            this.a(new String[]{"\u91ca\u653e\u653b\u51fb\u6280\u80fd", "\u7981\u7528\u653b\u51fb\u6280\u80fd"}, new String[]{"damage_true", "damage_false"}, this, 90, 175);
        } else if (string.equals("damage_true")) {
            this.hR.e().if(true);
            this.h1.l(11791930);
            this.h1.else("\u91ca\u653e\u653b\u51fb\u6280\u80fd");
        } else if (string.equals("damage_false")) {
            this.hR.e().if(false);
            this.h1.l(0xEE3B3B);
            this.h1.else("\u7981\u7528\u653b\u51fb\u6280\u80fd");
        } else if (string.equals("state")) {
            this.a(new String[]{"\u91ca\u653e\u72b6\u6001\u6280\u80fd", "\u7981\u7528\u72b6\u6001\u6280\u80fd"}, new String[]{"state_true", "state_false"}, this, 210, 175);
        } else if (string.equals("state_true")) {
            this.hR.e().do(true);
            this.h8.l(11791930);
            this.h8.else("\u91ca\u653e\u72b6\u6001\u6280\u80fd");
        } else if (string.equals("state_false")) {
            this.hR.e().do(false);
            this.h8.l(0xEE3B3B);
            this.h8.else("\u7981\u7528\u72b6\u6001\u6280\u80fd");
        } else if (string.startsWith("hp")) {
            this.a(this.hX, this.hW, this, 150, 105);
            double d2 = new Double(a.a.b.a(string, ":")[1]);
            this.hR.e().if(d2);
            this.h2.else((int)(d2 * 100.0) + "%");
        } else if (string.startsWith("mp")) {
            this.a(this.hX, this.hY, this, 150, 135);
            double d3 = new Double(a.a.b.a(string, ":")[1]);
            this.hR.e().a(d3);
            this.h3.else((int)(d3 * 100.0) + "%");
        } else if (!string.equals("test")) {
            // empty if block
        }
    }

    public void do() {
    }

    private void cJ() {
        this.add(new g(this.getWidth() - 23, 7, 15, 15));
        this.hZ = new n();
        this.hZ.if("10000");
        this.hZ.a(new l(-16777216));
        this.hZ.char(-1);
        this.hZ.goto(-1);
        this.hZ.setBounds(220, 65, 90, 20);
        s s2 = new s();
        s2.setBounds(219, 64, 92, 22);
        s2.a(new x(Color.red.getRGB()));
        this.add(s2);
        this.add(this.hZ);
        this.hV = al.a(2, this.h6[0], this.hS[0], this, 150, 215, 100, 19);
        this.add(this.hV);
        this.hP[0] = 280;
        this.hO[0] = 100;
        this.hP[1] = 280;
        this.hO[1] = 130;
        this.h1 = al.a(2, "\u91ca\u653e\u653b\u51fb\u6280\u80fd", "damage", this, 90, 175, 100, 19);
        this.h1.l(11791930);
        this.add(this.h1);
        this.h8 = al.a(2, "\u91ca\u653e\u72b6\u6001\u6280\u80fd", "state", this, 210, 175, 100, 19);
        this.h8.l(11791930);
        this.add(this.h8);
        this.h2 = al.a(2, this.hX[0], this.hW[0], this, 150, 105, 30, 20);
        this.h2.l(0xEEEE00);
        this.add(this.h2);
        this.h3 = al.a(2, this.hX[0], this.hY[0], this, 150, 135, 30, 20);
        this.h3.l(0xEEEE00);
        this.add(this.h3);
    }

    public void a(a a10, int n2, int n3) {
        j j2 = (j)a10.if();
        if (j2 != null && j2.fW == 0) {
            n3 -= this.getLocation().y;
            if ((n2 -= this.getLocation().x) > 293 && n2 < 311) {
                if (n3 > 114 && n3 < 129) {
                    this.hR.e().char()[0] = this.h4[0] = j2;
                } else if (n3 > 143 && n3 < 164) {
                    this.hR.e().char()[1] = this.h4[1] = j2;
                }
            }
        }
    }

    public void cI() {
        this.hZ.if("10000");
        this.hR.e().a(false);
        this.hV.char(this.hS[0]);
        this.hV.else("\u7ee7\u7eed\u6302\u673a");
    }
}

