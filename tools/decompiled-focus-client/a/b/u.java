/*
 * Decompiled with CFR 0.152.
 */
package a.b;

import a.b.ac;
import a.b.af;
import a.b.c;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ColorModel;
import java.awt.image.ImageConsumer;
import java.util.Hashtable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class u
implements ImageConsumer {
    public static final int for = 6;
    public static final int case = 12;
    private int char;
    private String byte;
    private int int;
    private ac[] if = new ac[65536];
    private ac try;
    private Image do;
    private FontMetrics new;
    private Font a;

    public void setHints(int n2) {
    }

    public int a(String string) {
        int n2 = 0;
        int n3 = string.length();
        int n4 = 0;
        while (n4 < n3) {
            n2 += this.a(string.charAt(n4));
            ++n4;
        }
        return n2;
    }

    public u(String string, int n2, int n3, Component component) {
        this.byte = string;
        this.int = n2;
        this.char = n3;
        this.a(component);
    }

    public int a(char[] cArray, int n2, int n3) {
        int n4 = 0;
        int n5 = n2 + n3;
        while (n2 < n5) {
            n4 += this.a(cArray[n2]);
            ++n2;
        }
        return n4;
    }

    public int a() {
        return 12;
    }

    private ac if(char c2) {
        Graphics graphics = this.do.getGraphics();
        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, 255, 255);
        graphics.setColor(Color.white);
        graphics.setFont(this.a);
        graphics.drawString(String.valueOf(c2), 0, 10);
        graphics.dispose();
        this.try = new ac(this.do.getWidth(null), this.do.getHeight(null), Short.MAX_VALUE);
        this.do.getSource().startProduction(this);
        return this.try;
    }

    public void setPixels(int n2, int n3, int n4, int n5, ColorModel colorModel, byte[] byArray, int n6, int n7) {
    }

    public void setPixels(int n2, int n3, int n4, int n5, ColorModel colorModel, int[] nArray, int n6, int n7) {
        int n8 = 0;
        while (n8 < nArray.length) {
            nArray[n8 + n6] = 0xFFFFFF & nArray[n8 + n6];
            ++n8;
        }
        this.try.a(n3, nArray, n6, 0);
    }

    public void setDimensions(int n2, int n3) {
    }

    public void setProperties(Hashtable hashtable) {
    }

    public af a(char c2, int n2) {
        if (this.if[c2] == null) {
            this.if[c2] = this.if(c2);
        }
        ac ac2 = this.if[c2];
        ac2.a(c.do(n2));
        return ac2;
    }

    public void imageComplete(int n2) {
    }

    private void a(Component component) {
        this.a = new Font(this.byte, this.int, this.char);
        this.new = Toolkit.getDefaultToolkit().getFontMetrics(this.a);
        int n2 = 12;
        int n3 = 12;
        this.do = component.createImage(n3, n2);
    }

    public void setColorModel(ColorModel colorModel) {
    }

    public int a(char c2) {
        if (c2 < '\u007f') {
            return 6;
        }
        return 12;
    }
}

