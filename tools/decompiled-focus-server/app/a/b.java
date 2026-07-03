/*
 * Decompiled with CFR 0.152.
 */
package app.a;

import daff.a.h;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class b {
    private String a;
    private int for;
    private String new;
    private String if;
    private h int = new h(8);
    private h do;

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

    b() {
    }

    public String for() {
        return this.a;
    }

    public String do() {
        return this.new;
    }

    public String a() {
        return this.if;
    }

    void a(Socket socket) throws IOException {
        this.a = socket.getInetAddress().getHostAddress();
        this.for = socket.getPort();
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String string = bufferedReader.readLine();
        if (string == null || string.length() < 4) {
            throw new IOException("illegal request:" + string);
        }
        if (string.indexOf(32) <= 0) {
            throw new IOException("illegal request:" + string);
        }
        String[] stringArray = daff.a.b.a(string, " ");
        this.new = stringArray[0];
        this.if = stringArray[1];
        if (!this.new.equals("POST") && !this.new.equals("GET")) {
            throw new IOException("illegal method:" + this.new);
        }
        if (this.if.length() > 256) {
            throw new IOException("illegal file:" + this.if);
        }
        string = bufferedReader.readLine();
        while (string != null && string.length() > 0) {
            if (string.indexOf(32) <= 0) {
                throw new IOException("illegal header:" + string);
            }
            stringArray = daff.a.b.a(string, ": ");
            this.int.if(stringArray);
            string = bufferedReader.readLine();
        }
        String string2 = "";
        if (this.new.equals("POST")) {
            String string3 = this.a("Content-Length");
            try {
                int n2 = Integer.parseInt(string3);
                StringBuffer stringBuffer = new StringBuffer(n2);
                int n3 = 0;
                while (n3 < n2) {
                    stringBuffer.append((char)bufferedReader.read());
                    ++n3;
                }
                string2 = stringBuffer.toString();
            }
            catch (NumberFormatException numberFormatException) {
                throw new IOException("illegal Content-Length:" + string3);
            }
        } else if (this.if.indexOf(63) > 0) {
            stringArray = daff.a.b.a(this.if, "?");
            this.if = stringArray[0];
            string2 = stringArray[1];
        }
        if (this.if.charAt(0) == '/') {
            this.if = this.if.substring(1);
        }
        if (string2.length() > 0) {
            stringArray = daff.a.b.a(string2, "&");
            this.do = new h(stringArray.length);
            int n4 = 0;
            while (n4 < stringArray.length) {
                if (stringArray[n4].indexOf(61) > 0) {
                    String[] stringArray2 = daff.a.b.a(stringArray[n4], "=");
                    stringArray2[0] = daff.a.b.int(stringArray2[0]);
                    stringArray2[1] = daff.a.b.int(stringArray2[1]);
                    this.do.if(stringArray2);
                } else {
                    this.do.if(new String[]{stringArray[n4], "true"});
                }
                ++n4;
            }
        }
    }

    public int if() {
        return this.for;
    }

    public String if(String string) {
        if (this.do == null) {
            return "";
        }
        int n2 = this.do.for();
        int n3 = 0;
        while (n3 < n2) {
            String[] stringArray = (String[])this.do.if(n3);
            if (stringArray[0].equals(string)) {
                return stringArray[1];
            }
            ++n3;
        }
        return "";
    }
}

