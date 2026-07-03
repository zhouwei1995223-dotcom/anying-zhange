/*
 * Decompiled with CFR 0.152.
 */
package a.a;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class m {
    private static m new;
    Thread for;
    private Runnable[] if = new Runnable[1000];
    private int do;
    int int;
    Runnable a;

    public static final void a() {
        if (new != null) {
            new.try();
        }
        new = null;
    }

    public void a(Runnable runnable) {
        m m2 = this;
        synchronized (m2) {
            if (this.do >= this.if.length) {
                Runnable[] runnableArray = new Runnable[this.do * 2];
                System.arraycopy(this.if, 0, runnableArray, 0, this.do);
                this.if = runnableArray;
            }
            this.if[this.do++] = runnable;
            this.notify();
            Object var4_4 = null;
        }
    }

    public void try() {
        if (this.for != null) {
            this.for.interrupt();
            this.for = null;
        }
        m m2 = this;
        synchronized (m2) {
            int n2 = 0;
            while (n2 < this.do) {
                this.if[n2] = null;
                ++n2;
            }
            this.do = 0;
            this.notify();
            Object var3_3 = null;
        }
    }

    Runnable do() {
        m m2 = this;
        synchronized (m2) {
            if (this.do <= 0) {
                try {
                    this.wait();
                }
                catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
            if (this.do <= 0) {
                Runnable runnable = null;
                Object var4_6 = null;
                return runnable;
            }
            Runnable runnable = this.if[0];
            int n2 = 1;
            while (n2 < this.do) {
                this.if[n2 - 1] = this.if[n2];
                ++n2;
            }
            this.if[this.do += -1] = null;
            Runnable runnable2 = runnable;
            Object var4_7 = null;
            return runnable2;
        }
    }

    public Runnable int() {
        return this.a;
    }

    public int new() {
        return this.do;
    }

    public void for() {
        if (this.for == null) {
            this.for = new b();
            this.for.setDaemon(true);
            this.for.start();
        }
    }

    public int if() {
        return this.int;
    }

    public static final m byte() {
        if (new == null) {
            new = new m();
            new.for();
        }
        return new;
    }

    private class b
    extends Thread {
        public b() {
            super("jobQueueProcessorThread");
            m.this.getClass();
        }

        public void run() {
            while (m.this.for == this) {
                Runnable runnable = m.this.do();
                if (runnable == null) continue;
                if (m.this.for != this) break;
                try {
                    m.this.a = runnable;
                    runnable.run();
                    ++m.this.int;
                }
                catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
            m.this.for = null;
        }
    }
}

