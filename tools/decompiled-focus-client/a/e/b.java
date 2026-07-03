/*
 * Decompiled with CFR 0.152.
 */
package a.e;

import a.a.e;
import a.a.q;
import a.e.c;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class b
implements c {
    private File if;
    private URL a;
    private q int = new q(1024);
    private q do = new q(1024);
    private c.a for;

    public byte[] a(String string, boolean bl) {
        if (this.int.do(string)) {
            return (byte[])this.int.for(string);
        }
        return this.do(string);
    }

    public b(File file) {
        this.if = file;
    }

    public c.a a() {
        return this.for;
    }

    public void a(c.a a10) {
        this.for = a10;
    }

    public void if(String string) {
    }

    public Image int(String string) {
        new File(this.if, string);
        byte[] byArray = this.do(string);
        if (byArray == null) {
            return null;
        }
        return Toolkit.getDefaultToolkit().createImage(byArray);
    }

    public URL if() {
        return this.a;
    }

    public void a(URL uRL) {
        this.a = uRL;
    }

    public void a(String string) {
    }

    private boolean a(File file, String string) {
        if (this.a == null) {
            return false;
        }
        if (this.do.do(string)) {
            return false;
        }
        try {
            URL uRL = new URL(this.a, string);
            HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
            httpURLConnection.setRequestMethod("HEAD");
            httpURLConnection.setRequestProperty("Connection", "close");
            this.do.a((Object)string, (Object)uRL);
            if ((long)httpURLConnection.getContentLength() != file.length()) {
                return true;
            }
            if (httpURLConnection.getLastModified() > file.lastModified()) {
                return true;
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        return false;
    }

    private byte[] new(String string) {
        if (this.a == null) {
            return null;
        }
        try {
            URL uRL = new URL(this.a, string);
            URLConnection uRLConnection = uRL.openConnection();
            int n2 = uRLConnection.getContentLength();
            if (n2 <= 0) {
                return null;
            }
            InputStream inputStream = uRLConnection.getInputStream();
            byte[] byArray = new byte[n2];
            int n3 = 0;
            while (n3 < n2) {
                n3 += inputStream.read(byArray, n3, Math.min(n2 - n3, 4092));
                if (this.for == null) continue;
                this.for.a(string, n3, n2);
            }
            inputStream.close();
            File file = new File(this.if, string);
            a.a.b.a(file, byArray);
            return byArray;
        }
        catch (IOException iOException) {
            return null;
        }
    }

    public void for(String string) {
        try {
            byte[] byArray = this.do(string);
            if (byArray == null) {
                return;
            }
            ZipInputStream zipInputStream = new ZipInputStream(new ByteArrayInputStream(byArray));
            ZipEntry zipEntry = zipInputStream.getNextEntry();
            e e2 = new e(4);
            while (zipEntry != null) {
                string = zipEntry.getName().replace('\\', '/');
                if (!zipEntry.isDirectory()) {
                    e2.char();
                    zipInputStream.read(e2.a(), 0, 4);
                    int n2 = e2.i();
                    byArray = new byte[n2 & 0xFFFFFF];
                    if (n2 > 0x1000000) {
                        zipInputStream.read();
                    }
                    int n3 = zipInputStream.read(byArray, 0, byArray.length);
                    while (byArray.length > n3) {
                        n3 += zipInputStream.read(byArray, n3, byArray.length - n3);
                    }
                    this.int.a((Object)string, (Object)byArray);
                }
                zipInputStream.closeEntry();
                zipEntry = zipInputStream.getNextEntry();
            }
            zipInputStream.close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public byte[] do(String string) {
        if (this.int.do(string)) {
            return (byte[])this.int.for(string);
        }
        File file = new File(this.if, string);
        if (!file.exists() || file.isDirectory()) {
            return this.new(string);
        }
        try {
            if (this.a(file, string)) {
                return this.new(string);
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] byArray = new byte[((InputStream)fileInputStream).available()];
            int n2 = 0;
            while (n2 < byArray.length) {
                n2 += ((InputStream)fileInputStream).read(byArray, n2, byArray.length - n2);
                if (this.for == null) continue;
                this.for.a(string, n2, byArray.length);
            }
            ((InputStream)fileInputStream).close();
            return byArray;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return null;
        }
    }
}

