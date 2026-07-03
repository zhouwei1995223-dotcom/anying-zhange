/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.s;
import b.a.c.b;
import java.awt.event.MouseEvent;

public class az
extends s {
    private static String[] d9;
    private static int[] ea;
    private b d5;
    private int[][] d7 = new int[1024][];
    private int d4;
    private int d6;
    private int d8;

    public az(b b2) {
        this.d5 = b2;
        this.enableEvents(16L);
    }

    protected void processMouseEvent(MouseEvent mouseEvent) {
        if (mouseEvent.getID() == 501 && this.d8 == 2) {
            this.bE();
        }
    }

    public void a(c c2) {
        c2.a(0, 0, this.getWidth(), this.getHeight(), -16777216);
        int n2 = 0;
        while (n2 < this.d4) {
            c2.a((char)this.d7[n2][0], this.d7[n2][1], this.d7[n2][2], this.d7[n2][5]);
            ++n2;
        }
    }

    private void bI() {
        byte[] byArray = this.d5.do().do().do("data/info.txt");
        if (byArray == null) {
            d9 = new String[]{"\u8bf7\u70b9\u9f20\u6807\u5f00\u59cb\u6e38\u620f"};
            ea = new int[]{-1};
            return;
        }
        String string = new String(byArray);
        String[] stringArray = a.a.b.a(string, "\r\n");
        d9 = new String[stringArray.length];
        ea = new int[stringArray.length];
        int n2 = 0;
        while (n2 < stringArray.length) {
            int n3 = stringArray[n2].indexOf(9);
            if (n3 < 0) {
                az.d9[n2] = stringArray[n2];
                az.ea[n2] = 0xFFFFFF;
            } else {
                az.d9[n2] = stringArray[n2].substring(0, n3);
                az.ea[n2] = Integer.parseInt(stringArray[n2].substring(n3 + 1), 16);
            }
            ++n2;
        }
    }

    public void a(long l2) {
        if (this.d8 != 1 && this.d8 != 3) {
            return;
        }
        boolean bl = false;
        int n2 = 0;
        while (n2 < this.d4) {
            int[] nArray = this.d7[n2];
            if (nArray[1] < nArray[3]) {
                nArray[1] = nArray[1] + 8;
                if (nArray[1] > nArray[3]) {
                    nArray[1] = nArray[3];
                }
                bl = true;
            } else if (nArray[1] > nArray[3]) {
                nArray[1] = nArray[1] - 8;
                if (nArray[1] < nArray[3]) {
                    nArray[1] = nArray[3];
                }
                bl = true;
            }
            if (nArray[2] < nArray[4]) {
                nArray[2] = nArray[2] + 8;
                if (nArray[2] > nArray[4]) {
                    nArray[2] = nArray[4];
                }
                bl = true;
            } else if (nArray[2] > nArray[4]) {
                nArray[2] = nArray[2] - 8;
                if (nArray[2] < nArray[4]) {
                    nArray[2] = nArray[4];
                }
                bl = true;
            }
            ++n2;
        }
        if (bl) {
            this.repaint();
        } else if (this.d8 == 1) {
            this.d8 = 2;
        } else if (this.d8 == 3) {
            this.d5.long();
        }
    }

    private void bE() {
        int n2 = this.getWidth();
        int n3 = this.getHeight();
        int n4 = 0;
        while (n4 < this.d4) {
            int[] nArray = this.d7[n4];
            int n5 = (int)(Math.random() * 4.0);
            switch (n5) {
                case 0: {
                    nArray[3] = (int)(Math.random() * (double)n2);
                    nArray[4] = n3 + 12;
                    break;
                }
                case 1: {
                    nArray[3] = -12;
                    nArray[4] = (int)(Math.random() * (double)n3);
                    break;
                }
                case 2: {
                    nArray[3] = (int)(Math.random() * (double)n2);
                    nArray[4] = -12;
                    break;
                }
                case 3: {
                    nArray[3] = n2 + 12;
                    nArray[4] = (int)(Math.random() * (double)n3);
                    break;
                }
            }
            ++n4;
        }
        this.d8 = 3;
    }

    public void bH() {
        this.bF();
    }

    private void bF() {
        int n2 = this.getWidth();
        int n3 = this.getHeight();
        int n4 = n3 / 2 - d9.length * 15;
        int n5 = 0;
        while (n5 < d9.length) {
            int n6 = d9[n5].length();
            int n7 = this.getWidth() / 2 - d9[n5].getBytes().length * 3;
            int n8 = 0;
            while (n8 < n6) {
                char c2 = d9[n5].charAt(n8);
                if (c2 != ' ') {
                    int[] nArray = new int[]{c2, (int)(Math.random() * (double)n2), (int)(Math.random() * (double)n3), n7, n4, ea[n5]};
                    this.d7[this.d4++] = nArray;
                }
                n7 += c2 > '\u007f' ? 12 : 6;
                ++n8;
            }
            n4 += 20;
            ++n5;
        }
        this.d8 = 1;
    }

    public void bG() {
        if (d9 == null) {
            this.bI();
        }
    }
}

