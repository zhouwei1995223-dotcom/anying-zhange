/*
 * Decompiled with CFR 0.152.
 */
package daff.a;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class m {
    private static m if;
    Thread new;
    private Runnable[] a = new Runnable[1000];
    private int int;
    int byte;
    private int for;
    int try;
    Runnable do;

    public static final void a() {
        if (if != null) {
            if.case();
        }
        if = null;
    }

    public void a(Runnable runnable) {
        m m2 = this;
        synchronized (m2) {
            if (this.int >= this.a.length) {
                Runnable[] runnableArray = new Runnable[this.int * 2];
                System.arraycopy(this.a, 0, runnableArray, 0, this.int);
                this.a = runnableArray;
            }
            this.a[this.int++] = runnable;
            this.notify();
            Object var4_4 = null;
        }
    }

    public void case() {
        if (this.new != null) {
            this.new.interrupt();
            this.new = null;
        }
        m m2 = this;
        synchronized (m2) {
            int n2 = 0;
            while (n2 < this.int) {
                this.a[n2] = null;
                ++n2;
            }
            this.int = 0;
            this.notify();
            Object var3_3 = null;
        }
    }

    Runnable try() {
        m m2 = this;
        synchronized (m2) {
            if (this.int <= 0) {
                try {
                    this.wait();
                    ++this.for;
                }
                catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
            if (this.int <= 0) {
                Runnable runnable = null;
                Object var4_6 = null;
                return runnable;
            }
            Runnable runnable = this.a[0];
            int n2 = 1;
            while (n2 < this.int) {
                this.a[n2 - 1] = this.a[n2];
                ++n2;
            }
            this.a[this.int += -1] = null;
            Runnable runnable2 = runnable;
            Object var4_7 = null;
            return runnable2;
        }
    }

    public Runnable int() {
        return this.do;
    }

    public int if() {
        return this.try;
    }

    public int byte() {
        return this.int;
    }

    public int new() {
        return this.for;
    }

    public void for() {
        if (this.new == null) {
            this.new = new b();
            this.new.setDaemon(true);
            this.new.start();
        }
    }

    public int do() {
        return this.byte;
    }

    public static final m char() {
        if (if == null) {
            if = new m();
            if.for();
        }
        return if;
    }

    private class b
    extends Thread {
        public b() {
            super("jobQueueProcessorThread");
            m.this.getClass();
        }

        public void run() {
            while (m.this.new == this) {
                m.this.try = 1;
                Runnable runnable = m.this.try();
                if (runnable == null) continue;
                if (m.this.new != this) break;
                try {
                    m.this.try = 2;
                    m.this.do = runnable;
                    runnable.run();
                    m.this.try = 0;
                    m.this.do = null;
                    ++m.this.byte;
                }
                catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
            m.this.try = 0;
            m.this.new = null;
        }
    }
}

