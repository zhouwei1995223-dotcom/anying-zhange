/*
 * Decompiled with CFR 0.152.
 */
package daff.net;

import daff.net.a;
import daff.net.b;
import daff.net.f;
import daff.net.h;
import daff.net.i;
import daff.net.j;
import java.io.IOException;
import java.net.Socket;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class c
extends a
implements f,
Runnable {
    private b goto;
    private daff.a.h void = new daff.a.h();
    private daff.a.h long = new daff.a.h(8);
    private int else = 100;

    public void stop() {
        try {
            this.goto.a();
            this.goto = null;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public int try() {
        return this.else;
    }

    public void new(int n2) {
        this.else = n2;
    }

    public int getConnectionCount() {
        return this.void.for();
    }

    public boolean a(Socket socket) {
        if (!this.byte()) {
            return false;
        }
        try {
            j j2 = new j(new h(socket), this);
            j2.if(System.currentTimeMillis());
            daff.a.h h2 = this.void;
            synchronized (h2) {
                this.void.if(j2);
                Object var5_5 = null;
            }
            this.if(j2);
            Thread thread = new Thread((Runnable)j2, j2.toString());
            thread.start();
            return true;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return false;
        }
    }

    public boolean byte() {
        return this.a() <= 0 || this.a() > this.getConnectionCount();
    }

    public boolean start() {
        if (this.goto == null) {
            try {
                this.goto = new b(this.if(), (f)this);
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
                return false;
            }
            this.goto.if();
            new Thread((Runnable)this, "simpleNetServerIOThread").start();
        }
        return true;
    }

    public void run() {
        i i2;
        int n2;
        int n3;
        while (this.goto != null) {
            daff.a.h h2 = this.void;
            synchronized (h2) {
                n3 = this.void.for();
                n2 = 0;
                while (n2 < n3) {
                    i2 = (j)this.void.if(n2);
                    if (!((j)i2).c()) {
                        this.a(i2);
                        this.void.a(n2--);
                        --n3;
                    }
                    ++n2;
                }
                daff.a.b.if(50);
                Object var5_5 = null;
            }
        }
        n3 = this.void.for();
        n2 = 0;
        while (n2 < n3) {
            i2 = (i)this.void.if(n2);
            this.a(i2);
            i2.new();
            ++n2;
        }
        this.void.a();
    }
}

