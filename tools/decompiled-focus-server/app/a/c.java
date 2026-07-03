/*
 * Decompiled with CFR 0.152.
 */
package app.a;

import app.a.b;
import app.a.d;
import app.a.e;
import app.a.f;
import java.io.IOException;
import java.net.Socket;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class c
implements daff.net.f {
    private int char;
    private daff.net.b try;
    private f case;
    d byte;

    public void long() throws IOException {
        if (this.try == null) {
            return;
        }
        this.try.a();
        this.try = null;
    }

    public int try() {
        return 50;
    }

    public c(int n2) {
        this.char = n2;
    }

    public boolean a(Socket socket) {
        if (this.case == null || this.case.a(socket)) {
            a a2 = new a(socket);
            new Thread((Runnable)a2, socket.toString()).start();
            return true;
        }
        return false;
    }

    public boolean byte() {
        return true;
    }

    public static void a(String[] stringArray) throws IOException {
        c c2 = new c(8000);
        c2.else();
    }

    public void else() throws IOException {
        if (this.try != null) {
            return;
        }
        this.try = new daff.net.b(this.char, (daff.net.f)this);
        this.try.if();
    }

    public f goto() {
        return this.case;
    }

    public void a(f f2) {
        this.case = f2;
    }

    public d case() {
        return this.byte;
    }

    public void a(d d2) {
        this.byte = d2;
    }

    public int char() {
        return this.char;
    }

    private class a
    implements Runnable {
        private Socket a;

        a(Socket socket) {
            c.this.getClass();
            this.a = socket;
        }

        public void run() {
            try {
                this.a.setSoTimeout(10000);
                b b2 = new b();
                b2.a(this.a);
                app.a.a a2 = new app.a.a(this.a.getOutputStream());
                e e2 = new e(b2, a2, this.a);
                if (c.this.byte != null) {
                    c.this.byte.a(e2);
                } else {
                    e2.if();
                }
            }
            catch (IOException iOException) {}
        }
    }
}

