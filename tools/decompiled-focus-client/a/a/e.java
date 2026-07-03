/*
 * Decompiled with CFR 0.152.
 */
package a.a;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class e
implements Cloneable {
    private int if;
    private int a;
    private byte[] do;

    public void new(int n2) {
        this.if = this.a = n2;
    }

    public void a(InputStream inputStream) throws IOException {
        this.a(inputStream, this.try() - this.goto());
    }

    public void int(int n2) {
        this.if += n2;
    }

    public void a(InputStream inputStream, int n2) throws IOException {
        this.do(this.a + n2);
        int n3 = 0;
        while (n3 < n2) {
            n3 += inputStream.read(this.do, this.a + n3, n2 - n3);
        }
        this.a += n2;
    }

    public int try() {
        return this.do.length;
    }

    private void do(int n2) {
        if (n2 > this.do.length) {
            byte[] byArray = new byte[n2 * 3 / 2];
            System.arraycopy(this.do, 0, byArray, 0, this.a);
            this.do = byArray;
        }
    }

    public void a(OutputStream outputStream) throws IOException {
        int n2 = this.if();
        int n3 = 0;
        while (n3 < n2) {
            outputStream.write(this.do[this.if++]);
            ++n3;
        }
    }

    public void int() {
        if (this.if == 0) {
            return;
        }
        int n2 = this.if();
        int n3 = 0;
        while (n3 < n2) {
            this.do[n3] = this.do[this.if++];
            ++n3;
        }
        this.if = 0;
        this.a = n2;
    }

    public void a(int n2) {
        this.a(n2, 1);
    }

    public int case() {
        return this.do[this.if++];
    }

    public int for() {
        return this.do[this.if++] & 0xFF;
    }

    private void if(byte[] byArray, int n2, int n3, int n4) {
        System.arraycopy(this.do, n4, byArray, n2, n3);
    }

    public int long() {
        return this.if;
    }

    public void case(int n2) {
        this.if = n2;
    }

    private void a(byte[] byArray, int n2, int n3, int n4) {
        this.do(n4 + n3);
        System.arraycopy(byArray, n2, this.do, n4, n3);
    }

    public void a(char c2) {
        this.a(c2, 2);
    }

    public char new() {
        return (char)(this.if(2) & 0xFFFFL);
    }

    private void a(long l2, int n2) {
        this.do(this.a + n2);
        int n3 = 0;
        while (n3 < n2) {
            this.do[this.a++] = (byte)l2;
            l2 >>= 8;
            ++n3;
        }
    }

    private long if(int n2) {
        long l2 = 0L;
        int n3 = 0;
        while (n3 < n2) {
            l2 |= (long)(this.do[this.if++] & 0xFF) << (n3 << 3);
            ++n3;
        }
        return l2;
    }

    public byte[] void() {
        byte[] byArray = new byte[this.goto()];
        System.arraycopy(this.do, 0, byArray, 0, byArray.length);
        return byArray;
    }

    public Object clone() {
        e e2 = new e(this.a);
        System.arraycopy(this.do, 0, e2.do, 0, this.a);
        e2.a = this.a;
        e2.if = this.if;
        return e2;
    }

    public void do(String string) {
        this.if(string);
    }

    public String f() {
        return this.byte();
    }

    public int goto() {
        return this.a;
    }

    public void a(boolean bl) {
        this.a(bl ? 1 : 0);
    }

    public boolean c() {
        return this.case() != 0;
    }

    public float e() {
        int n2 = this.i();
        return Float.intBitsToFloat(n2);
    }

    public void b() {
        this.if = 0;
    }

    public void a(long l2) {
        this.a(l2, 8);
    }

    public e() {
        this(1024);
    }

    public e(int n2) {
        this.do = new byte[n2];
    }

    public e(byte[] byArray) {
        this(byArray, 0, byArray.length);
    }

    public e(byte[] byArray, int n2, int n3) {
        this.do = byArray;
        this.if = n2;
        this.a = n2 + n3;
    }

    public void a(String string) {
        this.if(string);
    }

    public long g() {
        return this.if(8);
    }

    public void for(int n2) {
        this.a(n2, 2);
    }

    public int j() {
        return (short)(this.if(2) & 0xFFFFL);
    }

    public void a(e e2) {
        this.a(e2, e2.if());
    }

    public void a(e e2, int n2) {
        this.do(this.goto() + n2);
        int n3 = 0;
        while (n3 < n2) {
            this.do[this.a++] = e2.do[e2.if++];
            ++n3;
        }
    }

    public void a(byte[] byArray) {
        this.a(byArray, 0, byArray.length);
    }

    public void a(byte[] byArray, int n2, int n3) {
        this.do(this.a + n3);
        int n4 = 0;
        while (n4 < n3) {
            this.do[this.a++] = byArray[n2++];
            ++n4;
        }
    }

    public byte[] try(int n2) {
        byte[] byArray = new byte[n2];
        int n3 = 0;
        while (n3 < n2) {
            byArray[n3] = this.do[this.if++];
            ++n3;
        }
        return byArray;
    }

    public int do() {
        return (int)(this.if(2) & 0xFFFFL);
    }

    public String h() {
        return this.byte();
    }

    public int if() {
        return this.a - this.if;
    }

    public String toString() {
        return new String(this.do, 0, this.a);
    }

    public int else() {
        return this.a;
    }

    public void byte(int n2) {
        this.a = n2;
    }

    public byte[] a() {
        return this.do;
    }

    public void if(String string) {
        char c2;
        if (string == null) {
            string = "";
        }
        int n2 = string.length();
        int n3 = 0;
        int n4 = 0;
        while (n4 < n2) {
            c2 = string.charAt(n4);
            n3 = c2 < '\u007f' ? ++n3 : (c2 > '\u07ff' ? (n3 += 3) : (n3 += 2));
            ++n4;
        }
        if (n3 > 65535) {
            throw new IllegalArgumentException("the string is too long:" + n2);
        }
        this.do(this.a + n3 + 2);
        this.for(n3);
        n4 = 0;
        while (n4 < n2) {
            c2 = string.charAt(n4);
            if (c2 < '\u007f') {
                this.do[this.a++] = (byte)c2;
            } else if (c2 > '\u07ff') {
                this.do[this.a++] = (byte)(0xE0 | c2 >> 12 & 0xF);
                this.do[this.a++] = (byte)(0x80 | c2 >> 6 & 0x3F);
                this.do[this.a++] = (byte)(0x80 | c2 & 0x3F);
            } else {
                this.do[this.a++] = (byte)(0xC0 | c2 >> 6 & 0x1F);
                this.do[this.a++] = (byte)(0x80 | c2 & 0x3F);
            }
            ++n4;
        }
    }

    public String byte() {
        int n2 = this.do();
        if (n2 == 0) {
            return "";
        }
        char[] cArray = new char[n2];
        int n3 = 0;
        int n4 = 0;
        byte by = 0;
        byte by2 = 0;
        int n5 = this.if + n2;
        while (this.if < n5) {
            if ((n4 = this.do[this.if++] & 0xFF) < 127) {
                cArray[n3++] = (char)n4;
                continue;
            }
            if (n4 >> 5 == 7) {
                by = this.do[this.if++];
                by2 = this.do[this.if++];
                cArray[n3++] = (char)((n4 & 0xF) << 12 | (by & 0x3F) << 6 | by2 & 0x3F);
                continue;
            }
            by = this.do[this.if++];
            cArray[n3++] = (char)((n4 & 0x1F) << 6 | by & 0x3F);
        }
        return new String(cArray, 0, n3);
    }

    public void char() {
        this.if = 0;
        this.a = 0;
    }

    public void char(int n2) {
        this.a(n2, 4);
    }

    public int i() {
        return (int)(this.if(4) & 0xFFFFFFFFFFFFFFFFL);
    }

    public int d() {
        return this.if;
    }
}

