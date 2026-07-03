/*
 * Decompiled with CFR 0.152.
 */
package a.d;

import a.a.h;
import a.d.a;
import a.d.b;
import a.d.f;
import a.d.i;
import a.d.j;
import a.d.k;
import java.io.IOException;
import java.net.Socket;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class c
extends a
implements f,
Runnable {
    private b byte;
    private h char = new h();
    private h case = new h(8);
    private int try = 100;

    public void do() {
        try {
            this.byte.a();
            this.byte = null;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public int char() {
        return this.try;
    }

    public void new(int n2) {
        this.try = n2;
    }

    public int byte() {
        return this.char.for();
    }

    public boolean a(Socket socket) {
        if (!this.else()) {
            return false;
        }
        try {
            k k2 = new k(new i(socket), this);
            k2.if(System.currentTimeMillis());
            h h2 = this.char;
            synchronized (h2) {
                this.char.if(k2);
                Object var5_5 = null;
            }
            this.if(k2);
            Thread thread = new Thread((Runnable)k2, k2.toString());
            thread.start();
            return true;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return false;
        }
    }

    public boolean else() {
        return this.a() <= 0 || this.a() > this.byte();
    }

    public boolean int() {
        if (this.byte == null) {
            try {
                this.byte = new b(this.if(), (f)this);
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
                return false;
            }
            this.byte.if();
            new Thread((Runnable)this, "simpleNetServerIOThread").start();
        }
        return true;
    }

    public void run() {
        j j2;
        int n2;
        int n3;
        while (this.byte != null) {
            h h2 = this.char;
            synchronized (h2) {
                n3 = this.char.for();
                n2 = 0;
                while (n2 < n3) {
                    j2 = (k)this.char.if(n2);
                    if (!((k)j2).c()) {
                        this.a(j2);
                        this.char.a(n2--);
                        --n3;
                    }
                    ++n2;
                }
                a.a.b.a(50);
                Object var5_5 = null;
            }
        }
        n3 = this.char.for();
        n2 = 0;
        while (n2 < n3) {
            j2 = (j)this.char.if(n2);
            this.a(j2);
            j2.new();
            ++n2;
        }
        this.char.a();
    }
}

