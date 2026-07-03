/*
 * Decompiled with CFR 0.152.
 */
package a.b;

import a.a.b;
import a.a.d;
import a.a.e;
import a.a.q;
import a.b.ac;
import a.b.af;
import a.b.f;
import a.b.p;
import a.b.w;
import a.e.c;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class v {
    public static final v if = new v(10000);
    private v a;
    private v int;
    private q for;
    private d do;
    private c new;

    public boolean a(String string) {
        return this.for.do(string);
    }

    public af if(String string) {
        return (af)this.for.a(string);
    }

    private af a(Image image) {
        if (image == null) {
            return null;
        }
        p p2 = new p(image);
        int n2 = 0;
        while (p2.a(0) == null) {
            b.a(10);
            if (!p2.a() && ++n2 < 10000) continue;
        }
        af af2 = p2.if();
        return af2;
    }

    public v do() {
        return this.int;
    }

    public void a(v v2) {
        this.int = v2;
    }

    public v() {
        this(null);
    }

    public v(int n2) {
        this(null, n2);
    }

    public v(v v2) {
        this(v2, 2048);
    }

    public v(v v2, int n2) {
        this.a = v2;
        if (v2 != null) {
            this.new = v2.int();
        }
        this.for = new q(n2);
    }

    public v for() {
        return this.a;
    }

    public int a() {
        return this.for.for();
    }

    private af a(byte[] byArray, int n2, int n3) {
        if (byArray[0] == 80 && byArray[1] == 75) {
            try {
                ZipInputStream zipInputStream = new ZipInputStream(new ByteArrayInputStream(byArray, n2, n3));
                zipInputStream.getNextEntry();
                e e2 = new e(4);
                zipInputStream.read(e2.a(), 0, 4);
                int n4 = e2.i();
                e2 = new e(n4);
                int n5 = zipInputStream.read(e2.a(), 0, n4);
                while (n4 > n5) {
                    n5 += zipInputStream.read(e2.a(), n5, n4 - n5);
                }
                return this.a(e2);
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        } else {
            return this.a(new e(byArray, n2, n3));
        }
        return null;
    }

    private af a(e e2) {
        af af2 = this.a(e2.for());
        if (af2 != null) {
            af2.if(e2);
        }
        return af2;
    }

    private af a(int n2) {
        if (n2 > 3) {
            n2 >>= 4;
        }
        if (n2 == 1) {
            return new f();
        }
        if (n2 == 2) {
            return new w();
        }
        if (n2 == 3) {
            return new ac();
        }
        return null;
    }

    public af do(String string) {
        if (this.new == null) {
            return null;
        }
        if (string.endsWith(".jpg") || string.endsWith(".gif") || string.endsWith("png")) {
            Image image = this.new.int(string);
            return this.a(image);
        }
        byte[] byArray = this.new.do(string);
        if (byArray == null) {
            return null;
        }
        return this.a(byArray, 0, byArray.length);
    }

    public c int() {
        return this.new;
    }

    public void a(c c2) {
        this.new = c2;
    }

    public void if() {
        this.for.if();
    }

    public af for(String string) {
        return this.if(string, true);
    }

    public af if(String string, boolean bl) {
        af af2 = null;
        if (this.a != null) {
            af2 = this.a.if(string, false);
        }
        if (af2 != null) {
            return af2;
        }
        af2 = (af)this.for.for(string);
        if (af2 == null) {
            if (this.int != null) {
                af2 = this.int.if(string, false);
            }
            if (af2 == null && bl) {
                af2 = this.do(string);
            }
            if (af2 != null) {
                this.for.a((Object)string, (Object)af2);
            }
        }
        return af2;
    }

    public void int(String string) {
        this.a(string, this.a != null);
    }

    public void a(String string, boolean bl) {
        string = string.intern();
        if (this.a != null && this.a.do != null && this.a.do.a(string)) {
            return;
        }
        if (this.int != null && this.int.do != null && this.int.do.a(string)) {
            return;
        }
        if (this.do == null) {
            this.do = new d();
        } else if (this.do.a(string)) {
            return;
        }
        if (this.new == null) {
            return;
        }
        if (bl) {
            this.new.a(string);
        }
        this.do.if(string);
        try {
            byte[] byArray = this.new.do(string);
            if (byArray == null) {
                return;
            }
            ZipInputStream zipInputStream = new ZipInputStream(new ByteArrayInputStream(byArray));
            ZipEntry zipEntry = zipInputStream.getNextEntry();
            e e2 = new e(4);
            byte[] byArray2 = new byte[8092];
            while (zipEntry != null) {
                string = zipEntry.getName().replace('\\', '/');
                if (!zipEntry.isDirectory()) {
                    Object object;
                    e2.char();
                    zipInputStream.read(e2.a(), 0, 4);
                    int n2 = e2.i();
                    if (n2 > 0x1000000) {
                        zipInputStream.read();
                    }
                    if (byArray2.length < (n2 &= 0xFFFFFF)) {
                        byArray2 = new byte[n2];
                    }
                    int n3 = zipInputStream.read(byArray2, 0, n2);
                    while (n2 > n3) {
                        n3 += zipInputStream.read(byArray2, n3, n2 - n3);
                    }
                    if (string.endsWith(".img")) {
                        object = this.a(byArray2, 0, n3);
                        if (object != null) {
                            this.for.a((Object)string, object);
                        }
                    } else if (string.endsWith(".gif") || string.endsWith(".jpg")) {
                        object = new byte[n3];
                        System.arraycopy(byArray2, 0, object, 0, n3);
                        Image image = Toolkit.getDefaultToolkit().createImage((byte[])object);
                        af af2 = this.a(image);
                        this.for.a((Object)string, (Object)af2);
                    }
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
}

