/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.o;
import a.b.s;
import a.b.z;
import b.a.c.b;
import b.a.c.b.bf;
import b.a.c.b.e;
import b.a.c.b.g;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class aj
extends z
implements ActionListener {
    private static final int iz = 350;
    private static final int ix = 260;
    private b iv;
    private String iA = "";
    private char[] iw;
    private int iy = -1;
    private s iC;
    private int iB;
    private s iu;

    public void a(String string, String string2, int n2, String[] stringArray) {
        this.iA = string;
        this.iw = new char[string2.length()];
        string2.getChars(0, this.iw.length, this.iw, 0);
        this.iy = n2;
        this.char(string2, n2);
        this.iC.removeAll();
        int n3 = 0;
        while (n3 < stringArray.length) {
            if (stringArray[n3].length() > 0) {
                bf bf2 = new bf();
                bf2.z(stringArray[n3]);
                bf2.y("choose:" + n3);
                bf2.case(this);
                bf2.P(-1);
                bf2.setBounds(26, 4 + n3 * 18, this.iC.getWidth() - 54, 18);
                this.iC.add(bf2);
            }
            ++n3;
        }
        this.setVisible(true);
    }

    public static String do(String string, String string2) {
        int n2 = string.indexOf(string2);
        if (n2 < 0) {
            return "";
        }
        if (string.length() <= n2 + string2.length() + 1) {
            return "";
        }
        int n3 = string.indexOf(61, n2 + string2.length());
        if (n3 < 0) {
            return "";
        }
        int n4 = string.indexOf(62, n2 + string2.length() + 1);
        if (n4 < 0) {
            n4 = string.length() - 1;
        }
        if (n4 <= ++n3) {
            return "";
        }
        return string.substring(n3, n4);
    }

    public aj(b b2) {
        this.iv = b2;
        this.char(true);
        this.setVisible(false);
    }

    public void a(c c2) {
        e.for(c2, 0, 0, this.getWidth());
        c2.a('\u4e0e', 24, 9, -1);
        c2.a(this.iA, 43, 9, -14698241);
        c2.a("\u4ea4\u8c08", 50 + this.iA.length() * 12, 9, -1);
        int n2 = (this.getHeight() - 52 - 7) * 1 / 2;
        c2.a(4, 30, this.getWidth() - 8, n2, -1627389952);
        e.if(c2, 3, n2 + 30, this.getWidth() - 3);
        c2.a(this.iC.getX(), this.iC.getY(), this.iC.getWidth(), this.iC.getHeight(), -1627389952);
        e.if(c2, 0, 26, this.getWidth(), this.getHeight() - 52);
        e.a(c2, 0, this.getHeight() - 26, this.getWidth());
        super.a(c2);
    }

    protected void processMouseEvent(MouseEvent mouseEvent) {
        if (mouseEvent.getID() == 501 && this.iw != null && this.iB < this.iw.length) {
            this.iB = this.iw.length;
            this.iC.setVisible(true);
            return;
        }
        super.processMouseEvent(mouseEvent);
    }

    public void setVisible(boolean bl) {
        super.setVisible(bl);
        if (!bl && this.iw != null) {
            this.iw = null;
            this.iv.byte().n();
        }
    }

    public void a(long l2) {
        if (this.iw != null && this.isVisible() && this.iB < this.iw.length) {
            if (++this.iB >= this.iw.length) {
                this.iC.setVisible(true);
            }
            this.repaint(12, 36, this.getWidth() - 28, 140);
        }
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        int n2 = string.charAt(string.length() - 1) - 48;
        this.iv.byte().new(n2);
        this.iw = null;
        this.setVisible(false);
    }

    public static String for(String string, String string2) {
        int n2 = string.indexOf(string2);
        if (n2 < 0) {
            return "";
        }
        return string.substring(0, n2) + string.substring(n2 + string2.length());
    }

    public void char(String string, int n2) {
        this.iu.removeAll();
        String[] stringArray = a.a.b.a(string, "\\n");
        int n3 = stringArray.length;
        a[] aArray = new a[n3];
        int n4 = 0;
        while (n4 < n3) {
            aArray[n4] = new a(stringArray[n4], n2);
            if (n4 == 0) {
                aArray[n4].setLocation(12, 36);
            } else {
                aArray[n4].setLocation(12, aArray[n4 - 1].getY() + aArray[n4 - 1].getHeight());
            }
            this.iu.add(aArray[n4]);
            ++n4;
        }
    }

    public void cQ() {
        this.setBounds(124, 40, 358, 319);
        g g2 = new g();
        g2.setBounds(this.getWidth() - 23, 7, 15, 15);
        this.add(g2);
        this.iu = new s();
        this.iu.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.add(this.iu);
        this.iC = new s();
        int n2 = (this.getHeight() - 52 - 7) * 2 / 4 - 4;
        this.iC.setBounds(4, this.getHeight() - 29 - n2, this.getWidth() - 8, n2);
        this.add(this.iC);
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    private class a
    extends s {
        private int c0;
        private char[] c3;
        private int c1;
        private int[] cZ;
        private int[] cY;
        private int[] c2;

        public a(String string, int n2) {
            aj.this.getClass();
            String string2 = new String();
            this.c1 = n2;
            String[] stringArray = a.a.b.a(string, "</color>");
            int n3 = stringArray.length;
            if (n3 > 1) {
                this.cZ = new int[n3 - 1];
                this.cY = new int[n3 - 1];
                this.c2 = new int[n3 - 1];
                int n4 = 0;
                while (n4 < n3) {
                    String string3 = aj.do(stringArray[n4], "<color");
                    if (string3.length() > 0) {
                        this.cZ[n4] = Integer.parseInt(string3, 16);
                        String string4 = "<color=" + string3 + ">";
                        this.cY[n4] = n4 > 0 ? string2.length() + stringArray[n4].indexOf(string4) : stringArray[n4].indexOf(string4);
                        string2 = string2 + aj.for(stringArray[n4], string4);
                        this.c2[n4] = string2.length() - 1;
                    } else {
                        string2 = string2 + stringArray[n4];
                    }
                    ++n4;
                }
            } else {
                string2 = string;
            }
            this.c3 = string2.toCharArray();
            o o2 = new o(string2, aj.this.getWidth() - 12, 0, 24);
            this.setSize(o2.a(), o2.if());
            this.c0 = this.getWidth();
        }

        public void a(c c2) {
            this.new(c2, 0, 0, this.c0 - 12);
        }

        private void new(c c2, int n2, int n3, int n4) {
            if (this.c3 == null) {
                return;
            }
            int n5 = this.c3.length;
            int n6 = n2 + 24;
            int n7 = n3;
            int n8 = n4 + n2;
            boolean bl = this.cZ == null;
            int n9 = 0;
            int n10 = 0;
            while (n10 < n5) {
                if (!bl && n9 < this.cZ.length && n10 >= this.cY[n9] && n10 <= this.c2[n9]) {
                    c2.a(this.c3[n10], n6, n7, this.cZ[n9]);
                } else {
                    c2.a(this.c3[n10], n6, n7, this.c1);
                }
                if (!bl && n9 < this.cZ.length && n10 >= this.c2[n9]) {
                    ++n9;
                }
                n6 = this.c3[n10] > '\u007f' ? (n6 += 12) : (n6 += 6);
                if (n6 > n8) {
                    n6 = n2;
                    n7 += 14;
                }
                ++n10;
            }
        }
    }
}

