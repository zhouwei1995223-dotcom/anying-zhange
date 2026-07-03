/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.q;
import a.b.s;
import b.a.c.b.e;
import java.awt.AWTEventMulticaster;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class al
extends s {
    public static final Cursor c7 = Cursor.getPredefinedCursor(12);
    private String db = "";
    private int dc = -11167;
    private int c8;
    private ActionListener c4;
    private String da = "";
    private boolean c6;
    private boolean c5;
    private int c9 = 1;

    public String bs() {
        return this.da;
    }

    public void char(String string) {
        this.da = string;
    }

    private void do(c c2) {
        int n2 = this.getWidth() / 2 - this.c8 / 2;
        int n3 = this.getHeight() / 2 - 6;
        if (this.c5) {
            c2.if(e.aZ, 0, 0, 54, 200, 6, 19);
            int n4 = this.getWidth() - 5;
            int n5 = 16;
            int n6 = 6;
            while (n6 < n4) {
                n5 = Math.min(n4 - n6, 16);
                c2.if(e.aZ, n6, 0, 60, 200, 16, 19);
                n6 += n5;
            }
            c2.if(e.aZ, n4, 0, 76, 200, 5, 19);
            c2.a(this.db, n2, n3 + 1, this.dc);
        } else if (this.c6) {
            c2.if(e.aZ, 0, 0, 27, 200, 6, 19);
            int n7 = this.getWidth() - 5;
            int n8 = 16;
            int n9 = 6;
            while (n9 < n7) {
                n8 = Math.min(n7 - n9, 16);
                c2.if(e.aZ, n9, 0, 33, 200, 16, 19);
                n9 += n8;
            }
            c2.if(e.aZ, n7, 0, 49, 200, 5, 19);
            c2.a(this.db, n2, n3, this.dc);
        } else {
            c2.if(e.aZ, 0, 0, 0, 200, 6, 19);
            int n10 = this.getWidth() - 5;
            int n11 = 16;
            int n12 = 6;
            while (n12 < n10) {
                n11 = Math.min(n10 - n12, 16);
                c2.if(e.aZ, n12, 0, 5, 200, 16, 19);
                n12 += n11;
            }
            c2.if(e.aZ, n10, 0, 22, 200, 5, 19);
            c2.a(this.db, n2, n3, this.dc);
        }
    }

    public al() {
        this.enableEvents(16L);
        this.setCursor(c7);
        this.do(false);
    }

    protected void processMouseEvent(MouseEvent mouseEvent) {
        int n2 = mouseEvent.getID();
        if (n2 == 504) {
            this.c6 = true;
            this.repaint();
        } else if (n2 == 505) {
            this.c6 = false;
            this.repaint();
        } else if (n2 == 501) {
            this.c5 = true;
            this.repaint();
        } else if (n2 == 502) {
            this.c5 = false;
            this.repaint();
            if (this.contains(mouseEvent.getX(), mouseEvent.getY()) && this.c4 != null) {
                this.c4.actionPerformed(new ActionEvent(this, 1001, this.da));
            }
        }
        super.processMouseEvent(mouseEvent);
    }

    public void a(c c2) {
        if (this.c9 == 1) {
            this.if(c2);
        } else {
            this.do(c2);
        }
    }

    public void byte(ActionListener actionListener) {
        this.c4 = AWTEventMulticaster.remove(this.c4, actionListener);
    }

    private void if(c c2) {
        int n2 = this.getWidth() / 2 - this.c8 / 2;
        int n3 = this.getHeight() / 2 - 6;
        if (this.c5) {
            c2.if(e.aZ, 0, 0, 20, 162, 11, 24);
            int n4 = this.getWidth() - 11;
            int n5 = 16;
            int n6 = 11;
            while (n6 < n4) {
                n5 = Math.min(n4 - n6, 16);
                c2.if(e.aZ, n6, 0, 35, 162, 16, 24);
                n6 += n5;
            }
            c2.if(e.aZ, n4, 0, 59, 162, 11, 24);
            c2.a(this.db, n2, n3 + 1, this.dc);
        } else if (this.c6) {
            c2.if(e.aZ, 0, 0, 20, 85, 11, 24);
            int n7 = this.getWidth() - 11;
            int n8 = 16;
            int n9 = 11;
            while (n9 < n7) {
                n8 = Math.min(n7 - n9, 16);
                c2.if(e.aZ, n9, 0, 35, 85, 16, 24);
                n9 += n8;
            }
            c2.if(e.aZ, n7, 0, 59, 85, 11, 24);
            c2.a(this.db, n2, n3, this.dc);
        } else {
            c2.if(e.aZ, 0, 0, 20, 57, 11, 24);
            int n10 = this.getWidth() - 11;
            int n11 = 16;
            int n12 = 11;
            while (n12 < n10) {
                n11 = Math.min(n10 - n12, 16);
                c2.if(e.aZ, n12, 0, 35, 57, 16, 24);
                n12 += n11;
            }
            c2.if(e.aZ, n10, 0, 59, 57, 11, 24);
            c2.a(this.db, n2, n3, this.dc);
        }
    }

    public void l(int n2) {
        this.dc = n2;
    }

    public int bq() {
        return this.c9;
    }

    public void m(int n2) {
        this.c9 = n2;
        this.dc = n2 == 1 ? -11167 : -1;
    }

    public void try(ActionListener actionListener) {
        this.c4 = AWTEventMulticaster.add(this.c4, actionListener);
    }

    public String br() {
        return this.db;
    }

    public void else(String string) {
        this.db = string;
        this.c8 = q.if(string);
    }

    public static final al a(int n2, String string, String string2, ActionListener actionListener, int n3, int n4, int n5, int n6) {
        if (string == null) {
            string = "null";
        }
        if (string2 == null) {
            string2 = "null";
        }
        al al2 = new al();
        al2.m(n2);
        al2.else(string);
        al2.char(string2);
        al2.try(actionListener);
        al2.setBounds(n3, n4, n5, n6);
        return al2;
    }
}

