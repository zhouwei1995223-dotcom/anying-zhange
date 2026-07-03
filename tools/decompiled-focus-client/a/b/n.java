/*
 * Decompiled with CFR 0.152.
 */
package a.b;

import a.a.b;
import a.b.c;
import a.b.s;
import java.awt.AWTEventMulticaster;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class n
extends s {
    private static final int U = 256;
    private char ak = '\u0000';
    private String V = "";
    private char[] aj = new char[256];
    private int ag;
    private boolean ae;
    private long W;
    private boolean Z;
    private int ab;
    private int aa = -16777216;
    private int ac;
    private ActionListener ai;
    private String X = "";
    private TextListener Y;
    private boolean S = true;
    private int T;
    private int af;
    private int R;
    private int Q;
    private int ad;
    private int ah;

    public char L() {
        return this.ak;
    }

    public void if(char c2) {
        this.ak = c2;
    }

    public void a(TextListener textListener) {
        this.Y = AWTEventMulticaster.remove(this.Y, textListener);
    }

    protected void processFocusEvent(FocusEvent focusEvent) {
        if (!this.isEnabled()) {
            return;
        }
        if (focusEvent.getID() == 1004) {
            this.ae = true;
            this.repaint();
        } else if (focusEvent.getID() == 1005) {
            this.ae = false;
            this.repaint();
        }
        super.processFocusEvent(focusEvent);
    }

    public String G() {
        return this.X;
    }

    public void do(String string) {
        this.X = string;
    }

    public void E() {
        String string = a.a.b.for();
        if (string != null && string.length() > 0) {
            int n2 = string.length();
            int n3 = 0;
            while (n3 < n2) {
                this.a(string.charAt(n3));
                ++n3;
            }
        }
    }

    public int H() {
        return this.af;
    }

    private void N() {
        if (this.T < this.af && this.T >= 0 && this.af <= this.V.length()) {
            this.V = this.V.substring(0, this.T) + this.V.substring(this.af);
            this.V.getChars(0, this.V.length(), this.aj, 0);
            this.ag = this.af = this.T;
            this.repaint();
        }
    }

    public void if(int n2, int n3) {
        if (n2 >= 0 && n2 < n3 && n3 <= this.V.length()) {
            this.T = n2;
            this.af = n3;
            this.repaint();
        }
    }

    protected void processKeyEvent(KeyEvent keyEvent) {
        if (!this.isEnabled()) {
            return;
        }
        int n2 = keyEvent.getKeyCode();
        char c2 = keyEvent.getKeyChar();
        if (keyEvent.getID() == 400) {
            if (c2 == '\b') {
                if (this.af > this.T) {
                    this.N();
                } else if (this.ag > 0) {
                    this.long(-1);
                }
            } else if (c2 == '\t') {
                this.if(!keyEvent.isShiftDown());
            } else if (c2 == '\n' || c2 == '\r') {
                if (this.ai != null) {
                    ActionEvent actionEvent = new ActionEvent(this, 1001, this.X);
                    this.ai.actionPerformed(actionEvent);
                }
            } else if (c2 >= ' ' && c2 < '\u007f' || c2 > '\u0400') {
                this.a(c2);
            }
        } else if (keyEvent.getID() == 401) {
            if (n2 != 229) {
                if (n2 == 37) {
                    if (this.ag > 0) {
                        this.ag += -1;
                        if (keyEvent.isShiftDown()) {
                            if (this.ag == this.T - 1) {
                                this.T += -1;
                            } else if (this.af - 1 == this.ag) {
                                this.af += -1;
                            }
                        } else {
                            this.T = this.af = this.ag;
                        }
                        this.repaint();
                    } else if (this.af > this.T && !keyEvent.isShiftDown()) {
                        this.T = this.af = this.ag;
                        this.repaint();
                    }
                } else if (n2 == 39) {
                    if (this.ag < this.V.length()) {
                        ++this.ag;
                        if (keyEvent.isShiftDown()) {
                            if (this.ag == this.af + 1) {
                                ++this.af;
                            } else {
                                ++this.T;
                            }
                        } else {
                            this.T = this.af = this.ag;
                        }
                        this.repaint();
                    } else if (this.af > this.T && !keyEvent.isShiftDown()) {
                        this.T = this.af = this.ag;
                        this.repaint();
                    }
                } else if (n2 == 127) {
                    if (this.af > this.T) {
                        this.N();
                    } else if (this.ag < this.V.length()) {
                        this.long(0);
                    }
                } else if (n2 == 36) {
                    this.ag = 0;
                    this.T = keyEvent.isShiftDown() ? 0 : (this.af = this.ag);
                    this.repaint();
                } else if (n2 == 35) {
                    this.ag = this.V.length();
                    if (keyEvent.isShiftDown()) {
                        this.af = this.ag;
                    } else {
                        this.T = this.af = this.ag;
                    }
                    this.repaint();
                } else if (n2 == 86 && keyEvent.isControlDown()) {
                    this.E();
                } else if (n2 == 67 && keyEvent.isControlDown()) {
                    this.J();
                } else if (n2 == 88 && keyEvent.isControlDown()) {
                    this.M();
                }
            }
        } else if (keyEvent.getID() == 402 && a.a.b.do == 1) {
            if (this.ad == 229 && c2 >= 'A' && c2 <= 'Z') {
                this.a(c2);
            } else if (this.ad == 229 && c2 < 'A' && c2 > ' ') {
                this.a(c2);
            } else if (this.ad == 229 && n2 == 0) {
                this.a(c2);
            } else if (this.ad == 229 && (c2 == '~' || c2 == '`')) {
                this.a(c2);
            }
        }
        this.Q = keyEvent.getID();
        this.ad = n2;
        super.processKeyEvent(keyEvent);
    }

    protected void processMouseMotionEvent(MouseEvent mouseEvent) {
        if (!this.isEnabled()) {
            return;
        }
        if (mouseEvent.getID() == 506 && this.S) {
            int n2 = this.case(mouseEvent.getX() - this.R);
            this.T = Math.min(n2, this.ag);
            this.af = Math.max(n2, this.ag);
            this.repaint();
        }
        super.processMouseMotionEvent(mouseEvent);
    }

    public int I() {
        return this.ab;
    }

    public void goto(int n2) {
        this.ab = n2;
    }

    public int K() {
        return this.aa;
    }

    public void char(int n2) {
        this.aa = n2;
    }

    public boolean C() {
        return this.S;
    }

    public boolean isFocusable() {
        return this.S;
    }

    private void a(char c2) {
        int n2;
        if (!this.S) {
            return;
        }
        if (this.ac > 0 && this.V.length() >= this.ac) {
            return;
        }
        if (this.V.length() >= this.aj.length) {
            return;
        }
        this.N();
        int n3 = n2 = this.V.length();
        while (n3 > this.ag) {
            this.aj[n3] = this.aj[n3 - 1];
            --n3;
        }
        this.aj[this.ag++] = c2;
        this.V = String.valueOf(this.aj, 0, n2 + 1);
        this.af = this.T = this.ag;
        this.repaint();
    }

    private void long(int n2) {
        if (!this.S) {
            return;
        }
        int n3 = this.V.length();
        if (n3 <= 0) {
            return;
        }
        int n4 = this.ag + n2;
        int n5 = n4 + 1;
        while (n5 < n3) {
            this.aj[n5 - 1] = this.aj[n5];
            ++n5;
        }
        if (n2 < 0) {
            this.ag += -1;
        }
        this.V = String.valueOf(this.aj, 0, n3 - 1);
        this.af = this.T = this.ag;
        this.repaint();
    }

    public void M() {
        if (this.T < this.af) {
            this.J();
            this.N();
        }
    }

    public String F() {
        if (this.af <= this.T) {
            return "";
        }
        return this.V.substring(this.T, this.af);
    }

    public boolean isFocusTraversable() {
        return this.S;
    }

    public n() {
        this.enableEvents(60L);
        this.setCursor(Cursor.getPredefinedCursor(2));
        this.do(false);
    }

    protected void processMouseEvent(MouseEvent mouseEvent) {
        if (!this.isEnabled()) {
            return;
        }
        if (mouseEvent.getID() == 501 && this.S) {
            if (!this.ae) {
                this.requestFocus();
            }
            int n2 = this.case(mouseEvent.getX() - this.R);
            if (mouseEvent.isShiftDown()) {
                this.T = Math.min(n2, this.ag);
                this.af = Math.max(n2, this.ag);
            } else {
                this.af = this.ag = n2;
                this.T = this.ag;
            }
            this.repaint();
        } else if (mouseEvent.getID() == 500 && mouseEvent.getClickCount() > 1 && this.S) {
            this.T = 0;
            this.ag = this.af = this.V.length();
            this.repaint();
        } else if (mouseEvent.getID() == 502 && this.S) {
            this.ag = this.case(mouseEvent.getX() - this.R);
            this.repaint();
        }
        super.processMouseEvent(mouseEvent);
    }

    public int Q() {
        return this.ac;
    }

    public void else(int n2) {
        this.ac = n2;
    }

    public void a(c c2) {
        int n2;
        int n3;
        int n4;
        if (this.try() != null) {
            this.try().a(c2, this.getWidth(), this.getHeight());
        }
        int n5 = 0;
        int n6 = this.getHeight() / 2 - 6;
        int n7 = n5;
        this.R = 0;
        if (this.ak > '\u0000') {
            n4 = this.V.length();
            n3 = 0;
            while (n3 < n4) {
                c2.a(this.ak, n5, n6, this.ab);
                n5 += 6;
                ++n3;
            }
            n7 = n5;
        } else {
            n4 = this.getWidth();
            n3 = 0;
            while (n3 < this.ag) {
                n7 += this.aj[n3] > '\u007f' ? 12 : 6;
                ++n3;
            }
            if (n7 > n4) {
                this.R = n5 = n4 - n7;
                n7 = n4;
            }
            n3 = this.V.length();
            n2 = 0;
            while (n2 < n3) {
                c2.a(this.aj[n2], n5, n6, this.ab);
                n5 += this.aj[n2] > '\u007f' ? 12 : 6;
                ++n2;
            }
        }
        if (this.ae && this.S) {
            long l2 = System.currentTimeMillis();
            if (l2 - this.W > 500L) {
                this.Z = !this.Z;
                this.W = l2;
            }
            if ((n2 = n7) == 0 && this.for() != null) {
                n2 = 1;
            }
            if (this.Z) {
                c2.do(n2, n6, n2, n6 + 12, this.aa);
            }
            this.repaint(n2, n6, 1, 12);
        }
        if (this.af != this.T) {
            n5 = this.R;
            if (this.ak == '\u0000') {
                int n8 = 0;
                while (n8 < this.T) {
                    n5 += this.aj[n8] > '\u007f' ? 12 : 6;
                    ++n8;
                }
                n7 = n5;
                n8 = this.T;
                while (n8 < this.af) {
                    n7 += this.aj[n8] > '\u007f' ? 12 : 6;
                    ++n8;
                }
            } else {
                n7 = (n5 += this.T * 6) + (this.af - this.T) * 6;
            }
            c2.a(n5, n6, n7 - n5, 12, 0x6F0000FF);
        }
        if (this.for() != null) {
            this.for().a(c2, this.getWidth(), this.getHeight());
        }
    }

    public void try(boolean bl) {
        this.S = bl;
    }

    public int P() {
        return this.T;
    }

    public void do(ActionListener actionListener) {
        this.ai = AWTEventMulticaster.remove(this.ai, actionListener);
    }

    public void if(TextListener textListener) {
        this.Y = AWTEventMulticaster.add(this.Y, textListener);
    }

    public void J() {
        if (this.T < this.af && this.T >= 0 && this.af <= this.V.length()) {
            a.a.b.if(this.V.substring(this.T, this.af));
        }
    }

    private int case(int n2) {
        int n3 = 0;
        int n4 = 0;
        int n5 = this.V.length();
        int n6 = 0;
        while (n6 < n5) {
            int n7 = this.ak > '\u0000' ? 6 : (n4 = this.aj[n6] > '\u007f' ? 12 : 6);
            if (n2 < (n3 += n4) - n4 / 2) {
                return n6;
            }
            ++n6;
        }
        return n5;
    }

    public void for(ActionListener actionListener) {
        this.ai = AWTEventMulticaster.add(this.ai, actionListener);
    }

    public void O() {
        this.if(0, this.V.length());
    }

    public void setEnabled(boolean bl) {
        super.setEnabled(bl);
        if (!bl && this.ae) {
            this.transferFocus();
        }
    }

    public void if(String string) {
        if (this.V.equals(string)) {
            return;
        }
        this.V = string;
        if (this.Y != null) {
            TextEvent textEvent = new TextEvent(this, 900);
            this.Y.textValueChanged(textEvent);
        }
        this.V.getChars(0, this.V.length(), this.aj, 0);
        this.T = this.ag = this.V.length();
        this.af = this.ag;
        this.repaint();
    }

    public String D() {
        return this.V;
    }
}

