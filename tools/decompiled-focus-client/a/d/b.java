/*
 * Decompiled with CFR 0.152.
 */
package a.d;

import a.d.f;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class b {
    ServerSocket a;
    Thread for;
    f if;
    boolean do = true;

    public void a() throws IOException {
        if (this.for != null) {
            this.for.interrupt();
            this.for = null;
        }
    }

    public b(int n2, f f2) throws IOException {
        this(new ServerSocket(n2), f2);
    }

    public b(ServerSocket serverSocket, f f2) {
        this.a = serverSocket;
        this.if = f2;
    }

    public void a(boolean bl) {
        this.do = bl;
    }

    public boolean do() {
        return this.do;
    }

    public void if() {
        if (this.for == null) {
            this.for = new a();
            this.for.start();
        }
    }

    private class a
    extends Thread {
        public a() {
            super("socketFactoryListenThread");
            b.this.getClass();
        }

        public void run() {
            while (b.this.for == this) {
                if (b.this.if.char() > 0) {
                    a.a.b.a(b.this.if.char());
                }
                try {
                    Socket socket = b.this.a.accept();
                    if (b.this.if != null && b.this.if.a(socket)) continue;
                    socket.close();
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                    if (b.this.do) break;
                }
            }
            try {
                b.this.a.close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            b.this.for = null;
        }
    }
}

