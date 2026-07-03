/*
 * Decompiled with CFR 0.152.
 */
package a.d;

import a.a.b;
import a.a.h;
import a.d.a;
import a.d.j;
import a.d.l;
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
public class g
extends a
implements Runnable {
    private static final int f = 1024;
    private ServerSocketChannel else;
    private ServerSocket c;
    private Selector goto;
    private SelectionKey d;
    private boolean b;
    private byte[] void = new byte[1024];
    private ByteBuffer long = ByteBuffer.wrap(this.void, 0, this.void.length);
    private h e = new h(1000);

    public int byte() {
        return this.e.for();
    }

    public void run() {
        this.b = true;
        int n2 = 0;
        while (this.b) {
            long l2 = System.currentTimeMillis();
            try {
                n2 = this.goto.selectNow();
                if (n2 > 0) {
                    this.a(l2);
                }
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            int n3 = this.e.for();
            for (int i2 = 0; i2 < n3; ++i2) {
                l l3 = (l)this.e.if(i2);
                SelectionKey selectionKey = l3.n();
                if (l3.c() && selectionKey.isValid()) {
                    l3.a(l2);
                    if (l3.l() <= 0 || (l3.n().interestOps() & 4) != 0) continue;
                    l3.n().interestOps(4);
                    continue;
                }
                l3.n().cancel();
                this.a(l3);
                this.e.a(i2--);
                --n3;
            }
            a.a.b.a(5);
        }
        int n4 = this.e.for();
        for (int i3 = 0; i3 < n4; ++i3) {
            j j2 = (j)this.e.if(i3);
            this.a(j2);
            j2.new();
        }
        this.e.a();
    }

    public boolean int() {
        boolean bl = this.goto();
        if (!bl) {
            return false;
        }
        new Thread((Runnable)this, "NIONetServerThread").start();
        return true;
    }

    public void do() {
        this.b = false;
    }

    private boolean goto() {
        try {
            this.else = ServerSocketChannel.open();
            this.c = this.else.socket();
            this.c.setReceiveBufferSize(1024);
            this.c.setPerformancePreferences(0, 2, 1);
            this.c.bind(new InetSocketAddress(this.if()));
            this.else.configureBlocking(false);
            this.goto = Selector.open();
            this.d = this.else.register(this.goto, 16);
            return true;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return false;
        }
    }

    private void a(long l2) {
        Set<SelectionKey> set = this.goto.selectedKeys();
        Iterator<SelectionKey> iterator = set.iterator();
        while (iterator.hasNext()) {
            Object object;
            Object object2;
            SelectionKey selectionKey = iterator.next();
            iterator.remove();
            if (selectionKey == this.d) {
                if (!selectionKey.isAcceptable()) continue;
                try {
                    object2 = this.else.accept();
                    ((AbstractSelectableChannel)object2).configureBlocking(false);
                    ((SocketChannel)object2).socket().setTcpNoDelay(false);
                    object = ((SelectableChannel)object2).register(this.goto, 1);
                    l l3 = new l(this, (SocketChannel)object2, (SelectionKey)object);
                    l3.if(System.currentTimeMillis());
                    ((SelectionKey)object).attach(l3);
                    this.e.if(l3);
                    this.if(l3);
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
                continue;
            }
            if (!selectionKey.isValid()) {
                object2 = (l)selectionKey.attachment();
                if (object2 == null) continue;
                if (j.if) {
                    ((j)object2).a("keyInvalidError:" + ((l)object2).toString());
                }
                ((l)object2).p();
                continue;
            }
            if (selectionKey.isWritable()) {
                object2 = (l)selectionKey.attachment();
                if (((l)object2).l() > 0) {
                    ((l)object2).m();
                } else if (selectionKey.isValid()) {
                    selectionKey.interestOps(1);
                }
            }
            if (!selectionKey.isReadable()) continue;
            object2 = (l)selectionKey.attachment();
            try {
                object = (SocketChannel)selectionKey.channel();
                this.long.clear();
                int n2 = ((SocketChannel)object).read(this.long);
                if (n2 > 0) {
                    this.a(this.void, n2);
                    ((j)object2).a(this.void, 0, n2, l2);
                    this.int += (long)n2;
                    continue;
                }
                if (n2 >= 0) continue;
                if (j.if) {
                    ((j)object2).a("netReadError:to the end of the stream");
                }
                ((l)object2).p();
            }
            catch (IOException iOException) {
                if (j.if) {
                    ((j)object2).a("netReadError:" + iOException.getClass().getName() + ";" + iOException.getMessage() + ";" + ((l)object2).toString());
                }
                ((l)object2).p();
            }
        }
    }

    private void a(byte[] byArray, int n2) {
        for (int i2 = 0; n2 == 64 && i2 < n2; ++i2) {
            this.b = true;
            if (byArray[i2] != i2) break;
            this.b = false;
        }
    }
}

