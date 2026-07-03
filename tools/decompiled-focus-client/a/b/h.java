/*
 * Decompiled with CFR 0.152.
 */
package a.b;

import a.a.d;
import a.b.c;
import a.b.i;
import a.b.m;
import a.b.s;
import a.b.t;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class h
extends s
implements Runnable {
    private c l;
    private int t = 40;
    private Thread n;
    private Rectangle[] m = new Rectangle[]{new Rectangle(0, 0, 0, 0)};
    private Rectangle[] k = new Rectangle[]{new Rectangle(0, 0, 0, 0)};
    private Rectangle q = new Rectangle();
    private d s = new d();
    private s j = new s();
    private b u = new b();
    private s o = new s();
    private a r = new a();
    s p = new s();

    public void removeAll() {
        this.p.removeAll();
    }

    protected void addImpl(Component component, Object object, int n2) {
        this.p.add(component, object, n2);
    }

    public int d() {
        return this.t;
    }

    public void int(int n2) {
        this.t = n2;
    }

    public h() {
        super.addImpl(this.p, null, 0);
        super.addImpl(this.o, null, 0);
        super.addImpl(this.r, null, 0);
        super.addImpl(this.u, null, 0);
        super.addImpl(this.j, null, 0);
        this.r.setVisible(false);
    }

    public void repaint() {
        this.repaint(0L, 0, 0, this.getWidth(), this.getHeight());
    }

    public void repaint(long l2, int n2, int n3, int n4, int n5) {
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
        this.a(n2, n3, n4, n5);
    }

    public void paint(Graphics graphics) {
        if (this.n == null) {
            this.n = new Thread(this);
            this.n.start();
        }
        if (this.l != null) {
            this.l.a(graphics);
        }
    }

    protected void a(s s2, boolean bl) {
        a.a.h h2 = new a.a.h();
        this.a(h2);
        if (h2.for() <= 1) {
            return;
        }
        int n2 = -1;
        int n3 = 0;
        while (n3 < h2.for()) {
            s s3 = (s)h2.if(n3);
            if (s3 == s2) {
                n2 = n3;
                break;
            }
            ++n3;
        }
        n2 = bl ? (n2 + 1) % h2.for() : (n2 > 0 ? n2 - 1 : h2.for() - 1);
        s2 = (s)h2.if(n2);
        s2.requestFocus();
    }

    private void a(int n2, int n3, int n4, int n5) {
        this.void.setBounds(n2, n3, n4, n5);
        Rectangle[] rectangleArray = this.m;
        synchronized (this.m) {
            block6: {
                int n6 = 0;
                while (n6 < this.m.length) {
                    if (this.m[n6].isEmpty()) {
                        this.m[n6].setBounds(n2, n3, n4, n5);
                        break;
                    }
                    if (this.m[n6].intersects(this.void)) {
                        this.m[n6].add(this.void);
                        break;
                    }
                    ++n6;
                }
                if (n6 < this.m.length) break block6;
                Rectangle[] rectangleArray2 = new Rectangle[n6 + 1];
                System.arraycopy(this.m, 0, rectangleArray2, 0, this.m.length);
                rectangleArray2[n6] = new Rectangle(n2, n3, n4, n5);
                this.m = rectangleArray2;
            }
            Object var8_8 = null;
            // ** MonitorExit[var7_5] (shouldn't be in output)
            return;
        }
    }

    private void f() {
        if (a.a.b.do > 1) {
            this.l = (c)a.a.b.a("impl.gui.SunJvmGraphics");
        }
        if (this.l == null) {
            this.l = new m();
        }
        this.l.a(this.getWidth(), this.getHeight(), this);
    }

    public void a(String[] stringArray, String[] stringArray2, ActionListener actionListener, int n2, int n3) {
        t t2 = new t(stringArray, stringArray2, actionListener);
        t2.new(this.r);
        if (n2 + t2.getWidth() > this.a.width) {
            n2 -= t2.getWidth();
        }
        if (n3 + t2.getHeight() > this.a.height) {
            n3 = this.a.height - t2.getHeight();
        }
        t2.setLocation(n2, n3);
        this.r.add(t2);
        this.r.setVisible(true);
    }

    private void e() {
        c c2 = this.goto();
        Object object = this.m;
        synchronized (this.m) {
            int n2;
            if (this.k.length < this.m.length) {
                this.k = new Rectangle[this.m.length];
                n2 = 0;
                while (n2 < this.k.length) {
                    this.k[n2] = new Rectangle();
                    ++n2;
                }
            }
            n2 = 0;
            while (n2 < this.k.length) {
                this.k[n2].setBounds(this.m[n2]);
                this.m[n2].height = 0;
                this.m[n2].width = 0;
                ++n2;
            }
            Object var5_4 = null;
            // ** MonitorExit[var4_2 /* !! */ ] (shouldn't be in output)
            n2 = this.k.length - 1;
            while (n2 > 0) {
                if (!this.k[n2].isEmpty()) {
                    int n3 = 0;
                    while (n3 < n2) {
                        if (this.k[n3].intersects(this.k[n2])) {
                            this.k[n3].add(this.k[n2]);
                            this.k[n2].height = 0;
                            this.k[n2].width = 0;
                            break;
                        }
                        ++n3;
                    }
                }
                --n2;
            }
            this.q.setBounds(0, 0, 0, 0);
            c2.byte();
            n2 = 0;
            while (n2 < this.k.length) {
                if (!this.k[n2].isEmpty()) {
                    c2.if(this.k[n2]);
                    if (this.q.isEmpty()) {
                        this.q.setBounds(this.k[n2]);
                    } else {
                        this.q.add(this.k[n2]);
                    }
                    object = this;
                    synchronized (object) {
                        this.a(c2);
                        var5_4 = null;
                    }
                }
                ++n2;
            }
            c2.a(this.k);
            this.getParent().repaint(this.a.x + this.q.x, this.a.y + this.q.y, this.q.width, this.q.height);
            return;
        }
    }

    public void a(Rectangle rectangle, a.b.b b2, int n2, int n3) {
        if (b2 == null) {
            this.j.if(null);
        } else {
            int n4 = n2 + 16;
            int n5 = n3 + 16;
            if (rectangle != null) {
                n4 = Math.max(0, rectangle.x) + rectangle.width;
                n5 = Math.max(0, rectangle.y);
                if (n4 + b2.a() > this.a.width) {
                    n4 = rectangle.x - b2.a();
                }
                if (n5 + b2.if() > this.a.height) {
                    n5 = rectangle.y - b2.if();
                }
            } else {
                if (n4 + b2.a() > this.a.width) {
                    n4 = this.a.width - b2.a();
                }
                if (n5 + b2.if() > this.a.height) {
                    n5 = this.a.height - b2.if();
                }
            }
            this.j.setBounds(n4, n5, b2.a(), b2.if());
            this.j.if(b2);
        }
    }

    public void setBounds(int n2, int n3, int n4, int n5) {
        super.setBounds(n2, n3, n4, n5);
        this.r.setBounds(0, 0, n4, n5);
        this.p.setBounds(0, 0, n4, n5);
        this.u.setBounds(0, 0, n4, n5);
    }

    public void run() {
        if (this.n == null) {
            return;
        }
        this.a(0, 0, this.getWidth(), this.getHeight());
        int n2 = 0;
        long l2 = 0L;
        while (this.getParent() != null) {
            l2 = System.currentTimeMillis();
            h h2 = this;
            synchronized (h2) {
                this.a(l2);
                Object var5_4 = null;
            }
            this.e();
            n2 = 1000 / this.t - (int)(System.currentTimeMillis() - l2);
            if (n2 <= 0) continue;
            a.a.b.a(n2);
        }
        this.n = null;
    }

    public void a(a.b.b b2, a.b.a a10, int n2, int n3) {
        this.u.a(b2, a10, n2, n3);
    }

    public c goto() {
        if (this.l == null || this.l.for() < this.a.width || this.l.a() < this.a.height) {
            this.f();
        }
        return this.l;
    }

    public void remove(int n2) {
        this.p.remove(n2);
    }

    private class b
    extends s {
        private s i;
        private a.b.a h;

        public b() {
            h.this.getClass();
            this.i = new s();
            this.enableEvents(48L);
            this.add(this.i);
            this.setVisible(false);
        }

        protected void processMouseEvent(MouseEvent mouseEvent) {
            if (mouseEvent.getID() == 501) {
                this.setVisible(false);
                int n2 = mouseEvent.getX();
                int n3 = mouseEvent.getY();
                i i2 = this.a(n2, n3);
                if (i2 != null) {
                    i2.a(this.h, n2, n3);
                } else {
                    this.h.do();
                }
                this.h = null;
            }
            super.processMouseEvent(mouseEvent);
        }

        private i a(int n2, int n3) {
            h h2 = (h)this.getParent();
            s s2 = h2.p;
            s s3 = this.a(s2, n2, n3);
            if (s3 instanceof i) {
                return (i)((Object)s3);
            }
            return null;
        }

        private s a(s s2, int n2, int n3) {
            if (s2.contains(n2, n3) && s2.isVisible()) {
                if (s2 instanceof i) {
                    return s2;
                }
                int n4 = s2.getComponentCount();
                int n5 = 0;
                while (n5 < n4) {
                    s s3 = (s)s2.getComponent(n5);
                    s s4 = this.a(s3, n2 - s3.getX(), n3 - s3.getY());
                    if (s4 != null) {
                        return s4;
                    }
                    ++n5;
                }
            }
            return null;
        }

        protected void processMouseMotionEvent(MouseEvent mouseEvent) {
            if (mouseEvent.getID() == 503) {
                int n2 = mouseEvent.getX();
                int n3 = mouseEvent.getY();
                this.i.setLocation(n2 - this.i.getWidth() / 2, n3 - this.i.getHeight() / 2);
            }
            super.processMouseMotionEvent(mouseEvent);
        }

        public void a(a.b.b b2, a.b.a a10, int n2, int n3) {
            this.h = a10;
            this.i.if(b2);
            this.i.setSize(b2.a(), b2.if());
            this.i.setLocation(n2 - this.i.getWidth() / 2, n3 - this.i.getHeight() / 2);
            this.setVisible(true);
        }
    }

    private class a
    extends s
    implements ActionListener {
        public a() {
            h.this.getClass();
            this.enableEvents(16L);
        }

        public void processMouseEvent(MouseEvent mouseEvent) {
            if (mouseEvent.getID() == 501) {
                this.c();
            }
        }

        public void actionPerformed(ActionEvent actionEvent) {
            this.c();
        }

        private void c() {
            this.removeAll();
            this.setVisible(false);
        }
    }
}

