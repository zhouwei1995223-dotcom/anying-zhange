/*
 * Decompiled with CFR 0.152.
 */
package daff.a;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class k
extends FilterInputStream {
    private byte[] a = new byte[4];

    public boolean new() throws IOException {
        return this.for() == 1;
    }

    public byte for() throws IOException {
        int n2 = this.in.read();
        if (n2 < 0) {
            throw new IOException("end of inputStream");
        }
        return (byte)n2;
    }

    public void do() throws IOException {
        this.in.close();
    }

    public String try() throws IOException {
        int n2 = this.for() & 0xFF;
        if (n2 == 0) {
            return null;
        }
        byte[] byArray = this.a(n2);
        return new String(byArray);
    }

    public k(InputStream inputStream) {
        super(inputStream);
    }

    public short byte() throws IOException {
        int n2 = this.in.read();
        int n3 = this.in.read();
        if (n2 < 0 || n3 < 0) {
            throw new IOException("end of inputstream");
        }
        this.a[0] = (byte)n2;
        this.a[1] = (byte)n3;
        return (short)(this.a[0] & 0xFF | (this.a[1] & 0xFF) << 8);
    }

    /*
     * Unable to fully structure code
     */
    public byte[] a(int var1_1) throws IOException {
        var2_2 = new byte[var1_1];
        if ((var1_1 = this.in.read(var2_2, 0, var2_2.length)) >= 0) ** GOTO lbl8
        throw new IOException("end of inputstream");
lbl-1000:
        // 1 sources

        {
            var3_3 = this.in.read(var2_2, var1_1, var2_2.length - var1_1);
            if (var3_3 < 0) {
                throw new IOException("end of inputStream");
            }
            var1_1 += var3_3;
lbl8:
            // 2 sources

            ** while (var1_1 < var2_2.length)
        }
lbl9:
        // 1 sources

        return var2_2;
    }

    public char a() throws IOException {
        return (char)this.byte();
    }

    public int if() throws IOException {
        int n2 = this.byte() & 0xFFFF;
        int n3 = this.byte() & 0xFFFF;
        return n2 | n3 << 16;
    }

    public String int() throws IOException {
        int n2 = this.byte() & 0xFFFF;
        if (n2 == 0) {
            return null;
        }
        byte[] byArray = this.a(n2);
        return new String(byArray);
    }
}

