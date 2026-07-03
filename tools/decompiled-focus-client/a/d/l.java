/*
 * Decompiled with CFR 0.152.
 */
package a.d;

import a.d.a;
import a.d.j;
import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class l
extends j {
    private a p;
    private SocketChannel n;
    private SelectionKey q;
    private boolean j = true;
    private int i;
    private String r;
    private int l;
    private byte[] o;
    private byte[] k = new byte[32768];
    private int m;

    public l(a a10, SocketChannel socketChannel, SelectionKey selectionKey) {
        this.n = socketChannel;
        this.p = a10;
        this.q = selectionKey;
        Socket socket = socketChannel.socket();
        this.r = socket.getInetAddress().getHostAddress();
        this.o = socket.getInetAddress().getAddress();
        this.i = socket.getPort();
        this.l = socket.getLocalPort();
    }

    public SocketChannel k() {
        return this.n;
    }

    public SelectionKey n() {
        return this.q;
    }

    public String h() {
        return this.r;
    }

    public byte[] d() {
        return this.o;
    }

    public int case() {
        return this.i;
    }

    public int b() {
        return this.l;
    }

    public int l() {
        return this.m;
    }

    public byte[] o() {
        return this.k;
    }

    public boolean c() {
        return this.j;
    }

    public void new() {
        if (!this.j) {
            return;
        }
        if (this.m > 0) {
            this.m();
        }
        this.j = false;
        try {
            this.n.socket().close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public String toString() {
        return "NIOConnection[host=" + this.r + ";port=" + this.i + "]";
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected int a(byte[] byArray, int n2, int n3) {
        if (!this.j) {
            return n3;
        }
        byte[] byArray2 = this.k;
        synchronized (this.k) {
            n3 = Math.min(n3, this.k.length - this.m);
            System.arraycopy(byArray, 0, this.k, this.m, n3);
            this.m += n3;
            // ** MonitorExit[var4_4] (shouldn't be in output)
            return n3;
        }
    }

    void p() {
        this.j = false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void m() {
        byte[] byArray = this.k;
        synchronized (this.k) {
            block8: {
                int n2 = 0;
                ByteBuffer byteBuffer = ByteBuffer.wrap(this.k, 0, this.m);
                try {
                    n2 = this.n.write(byteBuffer);
                    if (n2 > 0) {
                        this.m -= n2;
                        for (int i2 = 0; i2 < this.m; ++i2) {
                            this.k[i2] = this.k[i2 + n2];
                        }
                        if (this.p != null) {
                            this.p.int(n2);
                        }
                    }
                }
                catch (IOException iOException) {
                    this.j = false;
                    if (!if) break block8;
                    this.a("writeDataError:" + iOException.getClass().getName() + ";" + iOException.getMessage() + ";" + this.toString());
                }
            }
            // ** MonitorExit[var1_1] (shouldn't be in output)
            return;
        }
    }
}

