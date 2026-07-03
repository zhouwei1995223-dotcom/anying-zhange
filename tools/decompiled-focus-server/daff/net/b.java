/*
 * Decompiled with CFR 0.152.
 */
package daff.net;

import daff.net.f;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class b {
    ServerSocket do;
    Thread if;
    f a;
    boolean for = true;

    public void a() throws IOException {
        if (this.if != null) {
            this.if = null;
        }
    }

    public b(int n2, f f2) throws IOException {
        this(new ServerSocket(n2), f2);
    }

    public b(ServerSocket serverSocket, f f2) {
        this.do = serverSocket;
        this.a = f2;
    }

    public void a(boolean bl) {
        this.for = bl;
    }

    public boolean do() {
        return this.for;
    }

    public void if() {
        if (this.if == null) {
            this.if = new a();
            this.if.start();
        }
    }

    private class a
    extends Thread {
        public a() {
            super("socketFactoryListenThread");
            b.this.getClass();
        }

        public void run() {
            while (b.this.if == this) {
                if (b.this.a.try() > 0) {
                    daff.a.b.if(b.this.a.try());
                }
                try {
                    Socket socket = b.this.do.accept();
                    if (b.this.a != null && b.this.a.a(socket)) continue;
                    socket.close();
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                    if (b.this.for) break;
                }
            }
            try {
                b.this.do.close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            b.this.if = null;
        }
    }
}

