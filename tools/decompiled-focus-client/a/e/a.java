/*
 * Decompiled with CFR 0.152.
 */
package a.e;

import a.a.e;
import a.a.q;
import a.e.c;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageProducer;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class a
implements c {
    private static a case;
    private q byte = new q(1024);
    private URL new;
    private c.a try;

    public static a for() {
        if (case == null) {
            case = new a();
        }
        return case;
    }

    public byte[] a(String string, boolean bl) {
        if (bl) {
            this.a(string);
        }
        return (byte[])this.byte.for(string);
    }

    private a() {
    }

    public a(URL uRL) {
        this.new = uRL;
    }

    public c.a a() {
        return this.try;
    }

    public void a(c.a a10) {
        this.try = a10;
    }

    public void if(String string) {
        this.byte.a(string);
    }

    public Image int(String string) {
        if (this.byte.do(string)) {
            return Toolkit.getDefaultToolkit().createImage((byte[])this.byte.for(string));
        }
        try {
            URL uRL = new URL(this.new, string);
            URLConnection uRLConnection = uRL.openConnection();
            uRLConnection.setUseCaches(true);
            Object object = uRLConnection.getContent();
            if (object instanceof ImageProducer) {
                return Toolkit.getDefaultToolkit().createImage((ImageProducer)object);
            }
        }
        catch (IOException iOException) {
            System.out.println("image not found:" + string);
        }
        return null;
    }

    public int do() {
        return this.byte.for();
    }

    public URL int() {
        return this.new;
    }

    public void a(String string) {
        if (this.byte.do(string)) {
            return;
        }
        byte[] byArray = this.do(string);
        if (byArray != null) {
            this.byte.a((Object)string, (Object)byArray);
        }
    }

    public void if(URL uRL) {
        this.new = uRL;
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
                    int n3 = zipInputStream.read(byArray, 0, n2);
                    while (n2 > n3) {
                        n3 += zipInputStream.read(byArray, n3, n2 - n3);
                    }
                    this.byte.a((Object)string, (Object)byArray);
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
        if (this.byte.do(string)) {
            return (byte[])this.byte.for(string);
        }
        try {
            InputStream inputStream = null;
            int n2 = 0;
            URL uRL = new URL(this.new, string);
            URLConnection uRLConnection = uRL.openConnection();
            uRLConnection.setUseCaches(true);
            n2 = uRLConnection.getContentLength();
            inputStream = uRLConnection.getInputStream();
            if (inputStream == null || n2 <= 0) {
                return null;
            }
            byte[] byArray = new byte[n2];
            int n3 = 0;
            while (n3 < n2) {
                n3 += inputStream.read(byArray, n3, Math.min(n2 - n3, 4092));
                if (this.try == null) continue;
                this.try.a(string, n3, n2);
            }
            inputStream.close();
            return byArray;
        }
        catch (IOException iOException) {
            System.out.println("resource not found:" + string);
            return null;
        }
    }
}

