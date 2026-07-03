/*
 * Decompiled with CFR 0.152.
 */
package a.b;

import a.b.c;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageProducer;
import java.util.Hashtable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class m
extends c
implements ImageProducer {
    private Image l;
    private ImageConsumer n;
    private int[] m;
    private ColorModel k;

    protected void a(Graphics graphics, int n2, int n3) {
        graphics.drawImage(this.l, n2, n3, null);
    }

    public void a(Rectangle[] rectangleArray) {
        if (this.c) {
            return;
        }
        this.c = true;
        int n2 = 0;
        while (n2 < rectangleArray.length) {
            if (!rectangleArray[n2].isEmpty()) {
                this.a(this.n, rectangleArray[n2].x, rectangleArray[n2].y, rectangleArray[n2].width, rectangleArray[n2].height);
            }
            ++n2;
        }
        this.n.imageComplete(2);
    }

    public void requestTopDownLeftRightResend(ImageConsumer imageConsumer) {
    }

    private void a(ImageConsumer imageConsumer, int n2, int n3, int n4, int n5) {
        if (n2 < 0) {
            n2 = 0;
        }
        if (n3 < 0) {
            n3 = 0;
        }
        int n6 = n2 + n4;
        int n7 = n3 + n5;
        if (n6 > this.int.width) {
            n6 = this.int.width;
        }
        if (n7 > this.int.height) {
            n7 = this.int.height;
        }
        int n8 = this.int.width * n3 + n2;
        int n9 = this.int.width - n4;
        int n10 = n3;
        while (n10 < n7) {
            int n11 = n2;
            while (n11 < n6) {
                this.m[n11] = a.b.c.void[this.a[n8]];
                ++n11;
                ++n8;
            }
            imageConsumer.setPixels(n2, n10, n4, 1, this.k, this.m, n2, this.m.length);
            ++n10;
            n8 += n9;
        }
    }

    public void a(int n2, int n3, Component component) {
        super.a(n2, n3, component);
        this.a = new short[n3 * n2];
        this.m = new int[n2];
        this.l = Toolkit.getDefaultToolkit().createImage(this);
        this.l.getWidth(null);
        this.k = new DirectColorModel(24, 0xFF0000, 65280, 255);
    }

    public boolean isConsumer(ImageConsumer imageConsumer) {
        return imageConsumer == this.n;
    }

    public void removeConsumer(ImageConsumer imageConsumer) {
    }

    public void startProduction(ImageConsumer imageConsumer) {
        this.n = imageConsumer;
        imageConsumer.setDimensions(this.int.width, this.int.height);
        imageConsumer.setHints(1);
        imageConsumer.setProperties(new Hashtable());
    }

    public void if() {
        this.l.flush();
    }

    public void addConsumer(ImageConsumer imageConsumer) {
        this.n = imageConsumer;
    }
}

