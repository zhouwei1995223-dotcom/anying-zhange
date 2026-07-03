/*
 * Decompiled with CFR 0.152.
 */
package daff.a;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class g
extends FilterOutputStream {
    private byte[] a = new byte[2];
    private OutputStream out;

    public void a(boolean bl) throws IOException {
        this.write(bl ? 1 : 0);
    }

    public void do(int n2) throws IOException {
        this.write(n2 & 0xFF);
    }

    public void a() throws IOException {
        this.out.close();
    }

    public void a(String string) throws IOException {
        if (string == null || string.length() == 0) {
            this.do(0);
        } else {
            byte[] byArray = string.getBytes();
            if (byArray.length > 255) {
                throw new IOException("string length overflow");
            }
            this.do(byArray.length);
            this.write(byArray);
        }
    }

    public g(OutputStream outputStream) {
        super(outputStream);
        this.out = outputStream;
    }

    public void a(int n2) throws IOException {
        this.a[0] = (byte)(n2 & 0xFF);
        this.a[1] = (byte)(n2 >> 8 & 0xFF);
        this.write(this.a, 0, 2);
    }

    public void write(byte[] byArray) throws IOException {
        this.out.write(byArray);
    }

    public void write(byte[] byArray, int n2, int n3) throws IOException {
        this.out.write(byArray, n2, n3);
    }

    public void a(char c2) throws IOException {
        this.a((int)c2);
    }

    public void if(int n2) throws IOException {
        this.a(n2 & 0xFFFF);
        this.a(n2 >> 16 & 0xFFFF);
    }

    public void if(String string) throws IOException {
        if (string == null || string.length() == 0) {
            this.a(0);
        } else {
            byte[] byArray = string.getBytes();
            if (byArray.length > 65535) {
                throw new IOException("string length overflow");
            }
            this.a(byArray.length);
            this.write(byArray);
        }
    }
}

