/*
 * Decompiled with CFR 0.152.
 */
package a.d;

import a.a.e;
import a.a.g;
import a.a.k;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class i {
    private k new;
    private g do;
    private InputStream if;
    private OutputStream int;
    private Socket a;
    private boolean for = true;

    public g case() {
        return this.do;
    }

    public synchronized void do() {
        this.for = false;
        if (this.a == null) {
            return;
        }
        try {
            try {
                this.if.close();
                this.int.close();
                this.a.close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            Object var3_2 = null;
            this.new = null;
            this.do = null;
            this.if = null;
            this.int = null;
            this.a = null;
        }
        catch (Throwable throwable) {
            Object var3_3 = null;
            this.new = null;
            this.do = null;
            this.if = null;
            this.int = null;
            this.a = null;
            throw throwable;
        }
    }

    public String toString() {
        if (this.a != null) {
            return "remoteIP=" + this.a.getInetAddress().getHostAddress() + ";remotePort=" + this.a.getPort() + ";localPort=" + this.a.getLocalPort();
        }
        return "";
    }

    public i(String string, int n2) throws IOException {
        this(new Socket(string, n2));
    }

    public i(Socket socket) throws IOException {
        this.a = socket;
        this.if = socket.getInputStream();
        this.int = socket.getOutputStream();
        this.new = new k(this.if);
        this.do = new g(this.int);
    }

    public i(String string, int n2, String string2, int n3) throws IOException {
        this(new Socket(string, n2), string2, n3);
    }

    public i(String string, int n2, String string2, String string3, String string4, int n3) throws IOException {
        this(new Socket(string, n2), string2, string3, string4, n3);
    }

    public i(Socket socket, String string, int n2) throws IOException {
        this.if = socket.getInputStream();
        this.int = socket.getOutputStream();
        this.new = new k(this.if);
        this.do = new g(this.int);
        byte[] byArray = new byte[3];
        byArray[0] = 5;
        byArray[1] = 1;
        byte[] byArray2 = byArray;
        this.int.write(byArray2);
        int n3 = this.new.byte();
        if (n3 != 5) {
            throw new IOException("proxy not support!");
        }
        byte[] byArray3 = new byte[4];
        byArray3[0] = 5;
        byArray3[1] = 1;
        byArray3[3] = 3;
        byArray2 = byArray3;
        this.int.write(byArray2);
        byArray2 = string.getBytes();
        this.int.write(byArray2.length);
        this.int.write(byArray2);
        this.int.write(n2 >> 8);
        this.int.write(n2 & 0xFF);
        n3 = this.new.if();
        if (n3 != 0x1000005) {
            throw new IOException("proxy failed");
        }
        this.new.a(4);
        int n4 = this.if.read();
        int n5 = this.if.read();
        this.a = socket;
    }

    public i(Socket socket, String string, String string2, String string3, int n2) throws IOException {
        this.if = socket.getInputStream();
        this.int = socket.getOutputStream();
        this.new = new k(this.if);
        this.do = new g(this.int);
        byte[] byArray = new byte[4];
        byArray[0] = 5;
        byArray[1] = 2;
        byArray[3] = 2;
        byte[] byArray2 = byArray;
        this.int.write(byArray2);
        int n3 = this.new.byte();
        if (n3 != 517) {
            throw new IOException("proxy not support!");
        }
        this.int.write(1);
        byArray2 = string.getBytes();
        this.int.write(byArray2.length);
        this.int.write(byArray2);
        byArray2 = string2.getBytes();
        this.int.write(byArray2.length);
        this.int.write(byArray2);
        n3 = this.new.byte();
        if (n3 != 1) {
            throw new IOException("invalid username or password");
        }
        byte[] byArray3 = new byte[4];
        byArray3[0] = 5;
        byArray3[1] = 1;
        byArray3[3] = 3;
        byArray2 = byArray3;
        this.int.write(byArray2);
        byArray2 = string3.getBytes();
        this.int.write(byArray2.length);
        this.int.write(byArray2);
        this.int.write(n2 >> 8 & 0xFF);
        this.int.write(n2 & 0xFF);
        n3 = this.new.if();
        if (n3 != 0x1000005) {
            throw new IOException("proxy failed");
        }
        this.new.a(4);
        int n4 = this.if.read();
        int n5 = this.if.read();
        this.a = socket;
    }

    public byte[] int() {
        if (!this.for) {
            return null;
        }
        if (this.if == null) {
            return null;
        }
        try {
            int n2 = this.if.available();
            byte[] byArray = new byte[n2];
            n2 = this.if.read(byArray, 0, byArray.length);
            while (n2 < byArray.length) {
                n2 += this.if.read(byArray, n2, byArray.length - n2);
            }
            return byArray;
        }
        catch (IOException iOException) {
            this.for = false;
            return null;
        }
    }

    public int a(byte[] byArray) {
        if (!this.for) {
            return 0;
        }
        if (this.if == null) {
            return 0;
        }
        try {
            int n2 = Math.min(byArray.length, this.if.available());
            int n3 = 0;
            while (n3 < n2) {
                byArray[n3] = (byte)this.if.read();
                ++n3;
            }
            return n2;
        }
        catch (Exception exception) {
            this.for = false;
            return 0;
        }
    }

    public k new() {
        return this.new;
    }

    public int long() {
        if (this.if == null || !this.for) {
            return 0;
        }
        try {
            return this.if.available();
        }
        catch (IOException iOException) {
            this.for = false;
            return 0;
        }
    }

    public byte[] a() {
        if (this.a != null) {
            return this.a.getLocalAddress().getAddress();
        }
        return null;
    }

    public String byte() {
        if (this.a != null) {
            return this.a.getInetAddress().getHostAddress();
        }
        return null;
    }

    public String try() {
        if (this.a != null) {
            return this.a.getLocalAddress().getHostAddress();
        }
        return null;
    }

    public byte[] if() {
        if (this.a != null) {
            return this.a.getInetAddress().getAddress();
        }
        return null;
    }

    public boolean for() {
        return this.for;
    }

    public boolean else() {
        if (this.if == null || !this.for) {
            return false;
        }
        try {
            return this.if.available() > 0;
        }
        catch (IOException iOException) {
            this.for = false;
            return false;
        }
    }

    public boolean a(byte[] byArray, int n2, int n3) {
        if (!this.for) {
            return false;
        }
        try {
            this.int.write(byArray, n2, n3);
            this.int.flush();
            return true;
        }
        catch (IOException iOException) {
            this.for = false;
            return false;
        }
    }

    public boolean a(e e2) {
        byte[] byArray = e2.a();
        int n2 = e2.d();
        int n3 = e2.if();
        return this.a(byArray, n2, n3);
    }

    public int char() {
        if (this.a != null) {
            return this.a.getPort();
        }
        return 0;
    }

    public int goto() {
        if (this.a != null) {
            return this.a.getLocalPort();
        }
        return 0;
    }
}

