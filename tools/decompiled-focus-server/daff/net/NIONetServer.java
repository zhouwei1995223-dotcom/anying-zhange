/*
 * Decompiled with CFR 0.152.
 */
package daff.net;

import daff.a.b;
import daff.a.h;
import daff.net.a;
import daff.net.i;
import daff.net.k;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.util.Iterator;
import java.util.Set;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class NIONetServer
extends a
implements Runnable {
    private static final int j = 1024;
    private ServerSocketChannel b;
    private ServerSocket g;
    private Selector c;
    private SelectionKey h;
    private boolean f;
    private byte[] e = new byte[1024];
    private ByteBuffer d = ByteBuffer.wrap(this.e, 0, this.e.length);
    private h i = new h(1000);

    public int getConnectionCount() {
        return this.i.for();
    }

    public void run() {
        this.f = true;
        int n2 = 0;
        while (this.f) {
            long l2 = System.currentTimeMillis();
            try {
                n2 = this.c.selectNow();
                if (n2 > 0) {
                    this.a(l2);
                }
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            int n3 = this.i.for();
            for (int i2 = 0; i2 < n3; ++i2) {
                k k2 = (k)this.i.if(i2);
                SelectionKey selectionKey = k2.n();
                if (k2.c() && selectionKey.isValid()) {
                    k2.a(l2);
                    if (k2.l() <= 0 || (k2.n().interestOps() & 4) != 0) continue;
                    k2.n().interestOps(4);
                    continue;
                }
                k2.n().cancel();
                this.a(k2);
                this.i.a(i2--);
                --n3;
            }
            daff.a.b.if(5);
        }
        int n4 = this.i.for();
        for (int i3 = 0; i3 < n4; ++i3) {
            i i4 = (i)this.i.if(i3);
            this.a(i4);
            i4.new();
        }
        this.i.a();
    }

    public boolean start() {
        boolean bl = this.void();
        if (!bl) {
            return false;
        }
        new Thread((Runnable)this, "NIONetServerThread").start();
        return true;
    }

    public void stop() {
        this.f = false;
    }

    private boolean void() {
        try {
            this.b = ServerSocketChannel.open();
            this.g = this.b.socket();
            this.g.setReceiveBufferSize(1024);
            this.g.setPerformancePreferences(0, 2, 1);
            this.g.bind(new InetSocketAddress(this.if()));
            this.b.configureBlocking(false);
            this.c = Selector.open();
            this.h = this.b.register(this.c, 16);
            return true;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return false;
        }
    }

    private void a(long l2) {
        Set<SelectionKey> set = this.c.selectedKeys();
        Iterator<SelectionKey> iterator = set.iterator();
        while (iterator.hasNext()) {
            Object object;
            Object object2;
            SelectionKey selectionKey = iterator.next();
            iterator.remove();
            if (selectionKey == this.h) {
                if (!selectionKey.isAcceptable()) continue;
                try {
                    object2 = this.b.accept();
                    ((AbstractSelectableChannel)object2).configureBlocking(false);
                    ((SocketChannel)object2).socket().setTcpNoDelay(false);
                    object = ((SelectableChannel)object2).register(this.c, 1);
                    k k2 = new k(this, (SocketChannel)object2, (SelectionKey)object);
                    k2.if(System.currentTimeMillis());
                    ((SelectionKey)object).attach(k2);
                    this.i.if(k2);
                    this.if(k2);
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
                continue;
            }
            if (!selectionKey.isValid()) {
                object2 = (k)selectionKey.attachment();
                if (object2 == null) continue;
                if (daff.net.i.if) {
                    ((i)object2).a("keyInvalidError:" + ((k)object2).toString());
                }
                ((k)object2).p();
                continue;
            }
            if (selectionKey.isWritable()) {
                object2 = (k)selectionKey.attachment();
                if (((k)object2).l() > 0) {
                    ((k)object2).m();
                } else if (selectionKey.isValid()) {
                    selectionKey.interestOps(1);
                }
            }
            if (!selectionKey.isReadable()) continue;
            object2 = (k)selectionKey.attachment();
            try {
                object = (SocketChannel)selectionKey.channel();
                this.d.clear();
                int n2 = ((SocketChannel)object).read(this.d);
                if (n2 > 0) {
                    this.a(this.e, n2);
                    ((i)object2).a(this.e, 0, n2, l2);
                    this.int += (long)n2;
                    continue;
                }
                if (n2 >= 0) continue;
                if (daff.net.i.if) {
                    ((i)object2).a("netReadError:to the end of the stream");
                }
                ((k)object2).p();
            }
            catch (IOException iOException) {
                if (daff.net.i.if) {
                    ((i)object2).a("netReadError:" + iOException.getClass().getName() + ";" + iOException.getMessage() + ";" + ((k)object2).toString());
                }
                ((k)object2).p();
            }
        }
    }

    private void a(byte[] byArray, int n2) {
        for (int i2 = 0; n2 == 64 && i2 < n2; ++i2) {
            this.f = true;
            if (byArray[i2] != i2) break;
            this.f = false;
        }
    }
}

