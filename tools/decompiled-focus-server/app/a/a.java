/*
 * Decompiled with CFR 0.152.
 */
package app.a;

import daff.a.h;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class a {
    private String if = "HTTP/1.0 200 OK";
    private h int = new h(8);
    private byte[] for;
    private OutputStream do;
    private int a;

    public String a(String string) {
        int n2 = this.int.for();
        int n3 = 0;
        while (n3 < n2) {
            String[] stringArray = (String[])this.int.if(n3);
            if (stringArray[0].equals(string)) {
                return stringArray[1];
            }
            ++n3;
        }
        return "";
    }

    public void a(String string, String string2) {
        int n2 = this.int.for();
        int n3 = 0;
        while (n3 < n2) {
            String[] stringArray = (String[])this.int.if(n3);
            if (stringArray[0].equals(string)) {
                stringArray[1] = string2;
                return;
            }
            ++n3;
        }
        String[] stringArray = new String[]{string, string2};
        this.int.if(stringArray);
    }

    public void for(String string) {
        this.a("Server", string);
    }

    a(OutputStream outputStream) {
        this.do = outputStream;
        this.for("Daff's WebServer 1.0");
        this.do("text/html");
    }

    public String a() {
        return this.if;
    }

    public void if(String string) {
        this.if = string;
    }

    public void a(Date date) {
        this.a("Date", date.toString());
    }

    public void for() throws IOException {
        if (this.a >= 2) {
            return;
        }
        if (this.for == null) {
            throw new IllegalStateException("response data not set yet");
        }
        this.a(this.for.length);
        this.do();
        this.do.write(this.for, 0, this.for.length);
        this.a = 2;
    }

    public void do(String string) {
        this.a("Content-Type", string);
    }

    public byte[] if() {
        return this.for;
    }

    public void a(byte[] byArray) {
        this.for = byArray;
    }

    public void int(String string) {
        this.for = string != null ? string.getBytes() : new byte[0];
    }

    public void a(int n2) {
        this.a("Content-Length", String.valueOf(n2));
    }

    public void do() throws IOException {
        byte[] byArray = this.if.getBytes();
        this.do.write(byArray);
        this.do.write(13);
        this.do.write(10);
        int n2 = this.int.for();
        int n3 = 0;
        while (n3 < n2) {
            String[] stringArray = (String[])this.int.if(n3);
            String string = stringArray[0] + ": " + stringArray[1];
            byArray = string.getBytes();
            this.do.write(byArray);
            this.do.write(13);
            this.do.write(10);
            ++n3;
        }
        this.do.write(13);
        this.do.write(10);
        this.a = 1;
    }
}

