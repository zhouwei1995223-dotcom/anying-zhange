/*
 * Decompiled with CFR 0.152.
 */
package impl.gui;

import a.b.c;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferUShort;

public class SunJvmGraphics
extends c {
    private BufferedImage o;

    public void a(int n2, int n3, Component component) {
        super.a(n2, n3, component);
        this.o = new BufferedImage(n2, n3, 9);
        short[] sArray = ((DataBufferUShort)this.o.getRaster().getDataBuffer()).getData();
        this.a = sArray;
    }

    protected void a(Graphics graphics, int n2, int n3) {
        graphics.drawImage(this.o, n2, n3, null);
    }
}

