/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.ab;
import a.b.ae;
import a.b.af;
import a.b.c;
import a.b.d;
import a.b.l;
import a.b.q;
import a.b.s;
import b.a.c.b;
import b.a.c.b.al;
import b.a.c.b.ap;
import b.a.c.b.e;
import b.a.c.b.g;
import b.a.c.b.z;
import b.a.d.j;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class w
extends a.b.z
implements ActionListener {
    private b gN;
    private s gU;
    private z gT;
    private s gO;
    private ae gQ;
    private String gS = "\u5730\u56fe\u4fe1\u606f";
    private al[] gR = new al[3];
    private int gM;
    private int gL;
    private d gP = new d("");

    public void cn() {
        this.gU.removeAll();
        this.gU.if(null);
    }

    public w(b b2) {
        this.gN = b2;
        this.char(true);
        this.setVisible(false);
        this.enableEvents(32L);
    }

    public void a(c c2) {
        e.if(c2, 0, 26, this.getWidth(), this.getHeight() - 52);
        e.for(c2, 0, 0, this.getWidth());
        c2.a(this.gS, 10, 9, -14698241);
        e.a(c2, 0, this.getHeight() - 26, this.getWidth());
        super.a(c2);
        a.b.b b2 = this.gU.void();
        if (b2 != null) {
            ap[] apArray = this.gN.c().ae().bk();
            int n2 = 0;
            while (n2 < apArray.length) {
                if (apArray[n2] != null) {
                    b.a.d.d d2 = apArray[n2].bu();
                    if (d2.ae > 0) {
                        int n3 = d2.void * 2 - 3 + this.gU.getX();
                        int n4 = d2.long * 3 / 2 - 6 + this.gU.getY();
                        c2.a('M', n3 += 150 - b2.a() / 2, n4 += 150 - b2.if() / 2, 0xFFFFFF);
                    }
                }
                ++n2;
            }
        }
    }

    protected void processMouseEvent(MouseEvent mouseEvent) {
        int n2 = mouseEvent.getX();
        int n3 = mouseEvent.getY();
        if (n3 < 30 || n3 > this.getHeight() - 30) {
            super.processMouseEvent(mouseEvent);
            return;
        }
        a.b.b b2 = this.gU.void();
        if (!this.gU.isVisible() || b2 == null) {
            return;
        }
        n2 -= this.gU.getX();
        n3 -= this.gU.getY();
        if (mouseEvent.getID() == 501 && (n2 -= 150 - b2.a() / 2) > 0 && (n3 -= 150 - b2.if() / 2) > 0 && n2 < b2.a() && n3 < b2.if()) {
            n2 /= 2;
            n3 = n3 * 2 / 3;
            if (mouseEvent.isControlDown() && (this.gN.for().ao > 0 || (this.gN.for().bA.M() & 1) > 0)) {
                this.gN.byte().int(n2, n3);
            } else {
                this.gN.e().char(n2, n3);
            }
        }
    }

    public void setVisible(boolean bl) {
        super.setVisible(bl);
        if (bl) {
            int n2 = this.gN.for().ao;
            this.gR[0].setVisible(n2 > 0);
            this.gR[1].setVisible(n2 > 0);
            this.gR[2].setVisible(this.gU.isVisible());
        }
        this.a((Rectangle)null, (a.b.b)null, 0, 0);
    }

    public void if(j j2) {
        a.b.b b2 = this.gU.void();
        if (b2 == null || !j2.cg && this.gN.for().ao <= 0) {
            return;
        }
        int n2 = j2.void * 2;
        int n3 = j2.long * 3 / 2;
        s s2 = new s();
        s2.if((a.b.b)this.gU.case());
        s2.setBounds((n2 += 150 - b2.a() / 2) - 3, (n3 += 150 - b2.if() / 2) - 6, 6, 12);
        s2.a(new d(j2.a + "\u5728" + j2.void + "\uff0c" + j2.long));
        s2.a(j2);
        this.gU.add(s2);
    }

    public void new(a.a.e e2) {
        this.gT.bg();
        int n2 = -1;
        int n3 = e2.for();
        int n4 = 0;
        int n5 = 0;
        while (n5 < n3) {
            int n6 = e2.i();
            String string = e2.h();
            int n7 = e2.j();
            n4 += n7;
            s s2 = new s();
            s2.setBounds(0, n5 * 20, 300, 20);
            s s3 = new s();
            s3.a(16);
            s3.if(new q(string, n2));
            s3.setBounds(12, 0, 120, 20);
            s2.add(s3);
            s3 = new s();
            s3.a(16);
            s3.if(new q("\u73a9\u5bb6\u6570\uff1a" + n7, n2));
            s3.setBounds(138, 0, 96, 20);
            s2.add(s3);
            al al2 = new al();
            al2.m(2);
            al2.char("goto:" + n6);
            al2.try(this);
            al2.else("\u524d\u5f80");
            al2.setBounds(232, 1, 44, 19);
            s2.add(al2);
            this.gT.a(s2, 0, 0, 0);
            ++n5;
        }
        this.gS = "\u573a\u666f\u5217\u8868[\u573a\u666f\u6570=" + n3 + ";\u603b\u4eba\u6570=" + n4 + "]";
    }

    protected void processMouseMotionEvent(MouseEvent mouseEvent) {
        a.b.b b2 = this.gU.void();
        if (this.gU.isVisible() && b2 != null && mouseEvent.getID() == 503) {
            int n2 = mouseEvent.getX();
            int n3 = mouseEvent.getY();
            n2 -= this.gU.getX();
            n3 -= this.gU.getY();
            if ((n2 -= 150 - b2.a() / 2) > 0 && (n3 -= 150 - b2.if() / 2) > 0 && n2 < b2.a() && n3 < b2.if()) {
                n2 /= 2;
                n3 = n3 * 2 / 3;
                ap[] apArray = this.gN.c().ae().bk();
                int n4 = 0;
                while (n4 < apArray.length) {
                    if (apArray[n4] != null) {
                        b.a.d.d d2 = apArray[n4].bu();
                        if (d2.ae > 0 && Math.abs(d2.void - n2) < 2 && Math.abs(d2.long - n3) < 4) {
                            this.gP.a("\u961f\u53cb\u3010" + d2.a + "\u3011\u5728" + n2 + "\uff0c" + n3);
                            this.a(null, this.gP, mouseEvent.getX(), mouseEvent.getY());
                            return;
                        }
                    }
                    ++n4;
                }
                this.gS = "\u5730\u56fe\u4fe1\u606f[" + n2 + "\uff0c" + n3 + "]";
            }
        }
        this.a((Rectangle)null, (a.b.b)null, 0, 0);
        super.processMouseMotionEvent(mouseEvent);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.equals("map")) {
            this.gU.setVisible(true);
            this.gT.setVisible(false);
            this.gR[2].setVisible(this.gU.isVisible());
            this.gS = "\u5730\u56fe\u4fe1\u606f";
        } else if (string.equals("world")) {
            if (this.gN.for().ao > 0) {
                this.gT.setVisible(true);
                this.gU.setVisible(false);
                this.gR[2].setVisible(this.gU.isVisible());
                this.gN.byte().v();
            }
        } else if (string.startsWith("goto:")) {
            if (this.gN.for().ao > 0) {
                String string2 = string.substring(5);
                int n2 = Integer.parseInt(string2);
                this.gN.byte().S(n2);
            }
        } else if (string.equals("alpha")) {
            int n3 = this.gU.long();
            if (n3 > 0) {
                n3 -= 50;
            }
            if (n3 <= 0) {
                n3 = 250;
            }
            this.gU.for(n3);
        }
    }

    public void c(int n2, int n3) {
        if (this.gO == null) {
            return;
        }
        d d2 = (d)this.gO.int();
        d2.a("\u6211\u7684\u5750\u6807\uff1a" + n2 + "\uff0c" + n3);
        a.b.b b2 = this.gU.void();
        if (b2 == null) {
            return;
        }
        n2 *= 2;
        n3 = n3 * 3 / 2;
        this.gO.setLocation((n2 += 150 - b2.a() / 2) - 5, (n3 += 150 - b2.if() / 2) - 5);
    }

    public void do(j j2) {
        int n2 = this.gU.getComponentCount();
        int n3 = 0;
        while (n3 < n2) {
            s s2 = this.gU.do(n3);
            if (s2.case() == j2) {
                this.gU.remove(n3);
                break;
            }
            ++n3;
        }
    }

    public void if(af af2) {
        if (af2 == null) {
            return;
        }
        ab ab2 = new ab(af2);
        this.gU.if(ab2);
        this.gU.for(100);
        this.gU.if(1);
        this.gN.for();
        s s2 = new s();
        s2.if(new ab(e.aZ, 0, 0, 11, 11));
        s2.setBounds(0, 0, 11, 11);
        s2.a(new d("\u6211\u7684\u5750\u6807\uff1a0\uff0c0"));
        this.gU.add(s2);
        this.gO = s2;
    }

    public void for(j j2) {
        int n2 = this.gU.getComponentCount();
        int n3 = 0;
        while (n3 < n2) {
            s s2 = this.gU.do(n3);
            if (s2.case() == j2) {
                s2.setVisible(j2.ci);
            }
            ++n3;
        }
    }

    public void co() {
        int n2 = 308;
        int n3 = 358;
        this.setBounds(152, 40, n2, n3);
        g g2 = new g();
        g2.setBounds(this.getWidth() - 23, 7, 15, 15);
        this.add(g2);
        this.gU = new s();
        this.gU.a(24);
        this.gU.a(new l(-1358954496));
        this.gU.setBounds(4, 30, 300, 300);
        this.gU.a((Object)new q("N", -1));
        this.add(this.gU);
        al al2 = new al();
        al2.char("map");
        al2.try(this);
        al2.else("\u5f53\u524d\u5730\u56fe");
        al2.m(2);
        al2.setBounds(this.getWidth() - 72, this.getHeight() - 25, 66, 19);
        this.add(al2);
        this.gR[0] = al2;
        al2 = new al();
        al2.char("world");
        al2.try(this);
        al2.else("\u573a\u666f\u5217\u8868");
        al2.m(2);
        al2.setBounds(6, this.getHeight() - 25, 66, 19);
        this.add(al2);
        this.gR[1] = al2;
        al2 = new al();
        al2.char("alpha");
        al2.try(this);
        al2.else("\u900f\u660e\u5ea6");
        al2.m(2);
        al2.setBounds(this.getWidth() / 2 - 33, this.getHeight() - 25, 66, 19);
        this.add(al2);
        this.gR[2] = al2;
        this.gT = new z();
        this.gT.setBounds(4, 30, 300, 300);
        this.gT.a(this.gU.try());
        this.gT.setVisible(false);
        this.add(this.gT);
    }
}

