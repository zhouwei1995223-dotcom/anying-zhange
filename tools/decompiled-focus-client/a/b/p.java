/*
 * Decompiled with CFR 0.152.
 */
package a.b;

import a.b.ac;
import a.b.af;
import a.b.c;
import a.b.f;
import a.b.w;
import java.awt.Image;
import java.awt.image.ColorModel;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageObserver;
import java.awt.image.IndexColorModel;
import java.util.Hashtable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class p
implements ImageConsumer,
ImageObserver {
    private int for;
    private int if;
    private boolean a;
    private af do;
    private Image int;

    public void setHints(int n2) {
    }

    public p(Image image) {
        this.int = image;
        image.getSource().startProduction(this);
    }

    public int do() {
        if (this.do != null) {
            return 1;
        }
        return 0;
    }

    public boolean imageUpdate(Image image, int n2, int n3, int n4, int n5, int n6) {
        int n7 = 224;
        return (n2 & n7) == 0;
    }

    public boolean a() {
        return this.a;
    }

    public void setPixels(int n2, int n3, int n4, int n5, ColorModel colorModel, byte[] byArray, int n6, int n7) {
        IndexColorModel indexColorModel = (IndexColorModel)colorModel;
        if (this.do instanceof ac) {
            short s2 = c.do(indexColorModel.getRGB(1 - indexColorModel.getTransparentPixel()));
            ac ac2 = (ac)this.do;
            ac2.a(s2);
            int n8 = 0;
            while (n8 < n5) {
                ac2.a(n3, byArray, n6, indexColorModel);
                ++n3;
                n6 += n7;
                ++n8;
            }
        } else {
            w w2 = (w)this.do;
            int n9 = 0;
            while (n9 < n5) {
                w2.a(n3, byArray, n6, indexColorModel);
                ++n3;
                n6 += n7;
                ++n9;
            }
        }
    }

    public void setPixels(int n2, int n3, int n4, int n5, ColorModel colorModel, int[] nArray, int n6, int n7) {
        if (this.do instanceof f) {
            f f2 = (f)this.do;
            f2.a(n3, nArray, n6);
        } else {
            w w2 = (w)this.do;
            int n8 = 0;
            while (n8 < n5) {
                w2.a(n3, nArray, n6);
                n6 += n7;
                ++n8;
                ++n3;
            }
        }
    }

    public void setDimensions(int n2, int n3) {
        this.for = n2;
        this.if = n3;
    }

    public void setProperties(Hashtable hashtable) {
    }

    public af if() {
        return this.a(0);
    }

    public af a(int n2) {
        return this.do;
    }

    public void imageComplete(int n2) {
        if (n2 == 3) {
            this.do.a();
            this.a = true;
            this.int.getSource().removeConsumer(this);
            this.int.flush();
            this.int = null;
        } else if (n2 == 2) {
            this.do.a();
            this.a = true;
        } else if (n2 == 1 && !this.a) {
            System.out.println("image error:" + this.int + "/" + this.for + ";" + this.if);
            this.int.getSource().removeConsumer(this);
            this.int.flush();
            this.int = null;
            this.a = true;
        }
    }

    public void setColorModel(ColorModel colorModel) {
        if (colorModel instanceof IndexColorModel) {
            IndexColorModel indexColorModel = (IndexColorModel)colorModel;
            boolean bl = false;
            int n2 = indexColorModel.getMapSize();
            if (n2 == 2 && indexColorModel.getTransparentPixel() >= 0) {
                bl = true;
            }
            if (this.do == null) {
                this.do = bl ? new ac(this.for, this.if) : new w(this.for, this.if);
            }
        } else {
            this.do = colorModel.getPixelSize() == 32 ? new w(this.for, this.if) : new f(this.for, this.if);
        }
    }
}

