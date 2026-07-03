/*
 * Decompiled with CFR 0.152.
 */
package a.b;

import a.a.h;
import a.b.a;
import a.b.b;
import a.b.c;
import a.b.e;
import a.b.g;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class s
extends Container {
    public static final int g = 1;
    public static final int b = 2;
    public static final int for = 1;
    public static final int case = 4;
    public static final int if = 8;
    public static final int do = 16;
    protected Rectangle void = new Rectangle();
    private Rectangle f = new Rectangle();
    protected Rectangle a = new Rectangle();
    private g background;
    private b long;
    private e d;
    private int else;
    private int e;
    private int c;
    private boolean goto = true;
    private b char;
    private boolean new = true;
    private s[] try = new s[0];
    private int byte;
    private Object int;

    public s do(int n2) {
        return this.try[n2];
    }

    public void setLocation(int n2, int n3) {
        this.setBounds(n2, n3, this.getWidth(), this.getHeight());
    }

    public void paintComponents(Graphics graphics) {
    }

    public void a(boolean bl) {
        this.new = bl;
    }

    public int getX() {
        return this.a.x;
    }

    protected void addImpl(Component component, Object object, int n2) {
        if (n2 > 0) {
            n2 = 0;
        }
        s s2 = (s)component;
        super.addImpl(component, object, n2);
        if (this.byte >= this.try.length) {
            s[] sArray = new s[this.byte * 2 + 1];
            int n3 = 0;
            while (n3 < this.byte) {
                sArray[n3] = this.try[n3];
                ++n3;
            }
            this.try = sArray;
        }
        if (n2 == -1 || n2 >= this.byte) {
            this.try[this.byte] = s2;
        } else {
            int n4 = this.byte;
            while (n4 > n2) {
                this.try[n4] = this.try[n4 - 1];
                --n4;
            }
            this.try[n2] = s2;
        }
        s2.repaint();
        ++this.byte;
    }

    public boolean byte() {
        return this.goto;
    }

    public void do(boolean bl) {
        this.goto = bl;
    }

    public void a(e e2) {
        e e3 = this.d;
        this.d = e2;
        if (e3 != e2) {
            this.repaint();
        }
    }

    public e for() {
        return this.d;
    }

    protected void a(s s2, boolean bl) {
    }

    public void transferFocus() {
        this.if(true);
    }

    public void if(boolean bl) {
        s s2;
        if (this.getParent() instanceof s && (s2 = (s)this.getParent()) != null) {
            s2.a(this, bl);
        }
    }

    public int long() {
        return this.c;
    }

    public void for(int n2) {
        this.c = n2;
    }

    public void update(Graphics graphics) {
        this.paint(graphics);
    }

    public void a(long l2) {
        if (!this.goto) {
            return;
        }
        int n2 = this.byte;
        s s2 = null;
        int n3 = n2 - 1;
        while (n3 >= 0) {
            s2 = this.try[n3];
            if (s2 != null) {
                s2.a(l2);
            }
            --n3;
        }
    }

    public void a(String[] stringArray, String[] stringArray2, ActionListener actionListener, int n2, int n3) {
        if (this.getParent() instanceof s) {
            ((s)this.getParent()).a(stringArray, stringArray2, actionListener, n2 += this.getX(), n3 += this.getY());
        }
    }

    protected void a(h h2) {
        if (this.isFocusTraversable()) {
            h2.if(this);
        }
        int n2 = this.getComponentCount();
        int n3 = 0;
        while (n3 < n2) {
            s s2 = (s)this.getComponent(n3);
            s2.a(h2);
            ++n3;
        }
    }

    public void setSize(Dimension dimension) {
        this.setSize(dimension.width, dimension.height);
    }

    public void setSize(int n2, int n3) {
        this.setBounds(this.getX(), this.getY(), n2, n3);
    }

    public b int() {
        return this.char;
    }

    public void a(b b2) {
        this.char = b2;
        if (this.char != null) {
            this.enableEvents(16L);
        }
    }

    public void setBounds(int n2, int n3, int n4, int n5) {
        if (n2 == this.a.x && n3 == this.a.y && n4 == this.a.width && n5 == this.a.height) {
            return;
        }
        this.repaint();
        this.a.setBounds(n2, n3, n4, n5);
        super.setBounds(n2, n3, n4, n5);
        this.repaint();
    }

    public void a(Rectangle rectangle, b b2, int n2, int n3) {
        if (this.getParent() != null) {
            s s2 = (s)this.getParent();
            n2 += this.getX();
            n3 += this.getY();
            if (rectangle != null) {
                rectangle.translate(this.getX(), this.getY());
            }
            s2.a(rectangle, b2, n2, n3);
        }
    }

    public int getWidth() {
        return this.a.width;
    }

    public void remove(int n2) {
        this.try[n2].repaint();
        super.remove(n2);
        int n3 = n2;
        while (n3 < this.byte - 1) {
            this.try[n3] = this.try[n3 + 1];
            ++n3;
        }
        this.try[this.byte - 1] = null;
        this.byte += -1;
    }

    public void removeAll() {
        super.removeAll();
        int n2 = 0;
        while (n2 < this.try.length) {
            this.try[n2] = null;
            ++n2;
        }
        this.byte = 0;
        this.repaint();
    }

    public void a(g g2) {
        g g3 = this.background;
        this.background = g2;
        if (g3 != g2) {
            this.repaint();
        }
    }

    public void new() {
        Container container = this.getParent();
        if (container != null) {
            if (container.getComponent(0) == this) {
                return;
            }
            container.remove(this);
            container.add((Component)this, 0);
            this.repaint();
        }
    }

    public int b() {
        return this.e;
    }

    public void if(int n2) {
        this.e = n2;
    }

    public void repaint() {
        this.repaint(0, 0, this.a.width, this.a.height);
    }

    public void repaint(long l2, int n2, int n3, int n4, int n5) {
        Container container;
        if (n2 >= this.a.width || n3 >= this.a.height || n2 + n4 <= 0 || n3 + n5 <= 0) {
            return;
        }
        if (n2 < 0) {
            n4 += n2;
            n2 = 0;
        }
        if (n3 < 0) {
            n5 += n3;
            n3 = 0;
        }
        if (n2 + n4 > this.a.width) {
            n4 = this.a.width - n2;
        }
        if (n3 + n5 > this.a.height) {
            n5 = this.a.height - n3;
        }
        if ((container = this.getParent()) != null) {
            container.repaint(l2, n2 + this.a.x, n3 + this.a.y, n4, n5);
        }
    }

    protected void processMouseEvent(MouseEvent mouseEvent) {
        if (mouseEvent.getID() == 504) {
            if (this.char != null) {
                if (this.new) {
                    this.a(null, this.char, mouseEvent.getX(), mouseEvent.getY());
                } else {
                    this.void.setBounds(0, 0, this.getWidth(), this.getHeight());
                    this.a(this.void, this.char, mouseEvent.getX(), mouseEvent.getY());
                }
            }
        } else if (mouseEvent.getID() == 505) {
            if (this.char != null) {
                this.a((Rectangle)null, (b)null, 0, 0);
            }
        } else if (mouseEvent.getID() == 501 && this.char != null) {
            this.a((Rectangle)null, (b)null, 0, 0);
        }
        super.processMouseEvent(mouseEvent);
    }

    public void paint(Graphics graphics) {
    }

    public void a(c c2) {
        int n2;
        int n3;
        int n4;
        b b2;
        g g2 = this.background;
        if (g2 != null) {
            g2.a(c2, this.a.width, this.a.height);
        }
        if ((b2 = this.long) != null) {
            n4 = 0;
            n3 = 0;
            n2 = b2.a();
            int n5 = b2.if();
            if ((this.else & 8) != 0) {
                n4 = (this.getWidth() - n2) / 2;
            } else if ((this.else & 2) != 0) {
                n4 = this.getWidth() - n2;
            }
            if ((this.else & 0x10) != 0) {
                n3 = (this.getHeight() - n5) / 2;
            } else if ((this.else & 4) != 0) {
                n3 = this.getHeight() - n5;
            }
            b2.a(c2, n4, n3, this.e, this.c);
        }
        n4 = 0;
        n3 = 0;
        n2 = this.byte;
        s s2 = null;
        int n6 = n2 - 1;
        while (n6 >= 0) {
            s2 = this.try[n6];
            if (s2 != null && s2.isVisible()) {
                n4 = s2.getX();
                n3 = s2.getY();
                c2.a(this.f);
                this.void.setBounds(n4, n3, s2.getWidth(), s2.getHeight());
                a.a.b.a(this.f, this.void, this.void);
                if (!this.void.isEmpty()) {
                    c2.if(this.void);
                    c2.do(n4, n3);
                    s2.a(c2);
                    c2.do(-n4, -n3);
                    c2.if(this.f);
                }
            }
            --n6;
        }
        e e2 = this.d;
        if (e2 != null) {
            e2.a(c2, this.a.width, this.a.height);
        }
    }

    public void if(b b2) {
        b b3 = this.long;
        this.long = b2;
        if (b2 != b3) {
            this.repaint();
        }
    }

    public b void() {
        return this.long;
    }

    public boolean char() {
        return this.new;
    }

    public int getY() {
        return this.a.y;
    }

    public g try() {
        return this.background;
    }

    public int getHeight() {
        return this.a.height;
    }

    public Object case() {
        return this.int;
    }

    public void a(Object object) {
        this.int = object;
    }

    public Dimension getPreferredSize() {
        if (this.long != null) {
            return new Dimension(this.long.a(), this.long.if());
        }
        return super.getPreferredSize();
    }

    public int else() {
        return this.else;
    }

    public void a(int n2) {
        if (n2 == this.else) {
            return;
        }
        this.else = n2;
        this.repaint();
    }

    public void a(b b2, a a10, int n2, int n3) {
        if (this.getParent() != null) {
            s s2 = (s)this.getParent();
            s2.a(b2, a10, n2 + this.getX(), n3 + this.getY());
        }
    }

    public c goto() {
        s s2 = (s)this.getParent();
        if (s2 != null) {
            return s2.goto();
        }
        return null;
    }

    public void setLocation(Point point) {
        this.setLocation(point.x, point.y);
    }
}

