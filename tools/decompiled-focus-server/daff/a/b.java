/*
 * Decompiled with CFR 0.152.
 */
package daff.a;

import daff.a.a;
import daff.a.c;
import daff.a.e;
import daff.a.h;
import daff.a.o;
import daff.a.q;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class b {
    private static final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final int do = System.getProperty("java.version").charAt(2) - 48;
    private static o if;

    public static c a(String string, String string2, String string3, c c2) {
        if (c2 == null) {
            c2 = new q(4);
        }
        if (string3 == null) {
            string3 = " ";
        }
        if (string2 == null) {
            string2 = "=";
        }
        int n2 = 0;
        int n3 = string.indexOf(string2);
        int n4 = 0;
        String string4 = null;
        String string5 = null;
        while (n3 > 0) {
            n4 = string.indexOf(string3, n3 + string2.length());
            if (n4 < 0) {
                n4 = string.length();
            }
            string4 = string.substring(n2, n3);
            string5 = n3 < n4 ? string.substring(n3 + string2.length(), n4) : "";
            if (string5.length() > 0 && string5.charAt(0) == '\"' && string5.charAt(string5.length() - 1) == '\"') {
                string5 = string5.substring(1, string5.length() - 1);
            }
            if (string5.length() > 0) {
                c2.a(string4, string5);
            }
            n2 = n4 + string3.length();
            n3 = string.indexOf(string2, n2);
        }
        return c2;
    }

    public static final byte[] a(URL uRL) throws IOException {
        URLConnection uRLConnection = uRL.openConnection();
        InputStream inputStream = uRLConnection.getInputStream();
        int n2 = uRLConnection.getContentLength();
        if (n2 <= 0) {
            n2 = 65536;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(n2);
        byte[] byArray = new byte[1024];
        int n3 = inputStream.read(byArray);
        while (n3 > 0) {
            byteArrayOutputStream.write(byArray, 0, n3);
            n3 = inputStream.read(byArray);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static void if(int n2) {
        try {
            Thread.sleep(n2);
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public static boolean try(String string) {
        if (string.indexOf(92) > -1) {
            string = string.replace('\\', '/');
        }
        int n2 = string.lastIndexOf(47);
        if (do == 1) {
            String[] stringArray = b.a(string, "/");
            String string2 = stringArray[0] + "/";
            int n3 = 1;
            while (n3 < stringArray.length - 1) {
                File file = new File(string2 = string2 + stringArray[n3] + "/");
                if (!file.exists() && !file.mkdir()) {
                    return false;
                }
                ++n3;
            }
            return true;
        }
        String string3 = string.substring(0, n2 + 1);
        File file = new File(string3);
        return file.mkdirs();
    }

    public static o for() {
        return if;
    }

    public static void a(o o2) {
        if = o2;
    }

    public static String if(String string) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] byArray = string.getBytes();
            byArray = messageDigest.digest(byArray);
            StringBuffer stringBuffer = new StringBuffer(32);
            int n2 = 0;
            while (n2 < byArray.length) {
                String string2 = Integer.toHexString(byArray[n2] & 0xFF);
                if (string2.length() == 1) {
                    stringBuffer.append('0');
                }
                stringBuffer.append(string2);
                ++n2;
            }
            return stringBuffer.toString();
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            return "";
        }
    }

    public static String a(Throwable throwable) {
        if (throwable == null) {
            return "no exception";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(byteArrayOutputStream));
        throwable.printStackTrace(printWriter);
        printWriter.flush();
        printWriter.close();
        return byteArrayOutputStream.toString();
    }

    public static boolean a(int n2, int n3) {
        int n4 = (n2 >> 26) + 100;
        int n5 = n2 >> 22 & 0xF;
        int n6 = n2 >> 17 & 0x1F;
        int n7 = (n3 >> 26) + 100;
        int n8 = n3 >> 22 & 0xF;
        int n9 = n3 >> 17 & 0x1F;
        return n4 == n7 && n5 == n8 && n6 == n9;
    }

    public static boolean a(long l2, long l3) {
        Date date = new Date(l2);
        Date date2 = new Date(l3);
        return date.getDate() == date2.getDate() && date.getMonth() == date2.getMonth() && date.getYear() == date2.getYear();
    }

    public static int a(byte[] byArray, byte[] byArray2) {
        int n2 = byArray.length - byArray2.length;
        int n3 = 0;
        while (n3 < n2) {
            boolean bl = true;
            int n4 = 0;
            while (n4 < byArray2.length) {
                if (!(bl &= byArray[n3 + n4] == byArray2[n4])) break;
                ++n4;
            }
            if (bl) {
                return n3;
            }
            ++n3;
        }
        return -1;
    }

    public static String[] a(String string, String string2) {
        Object[] objectArray;
        if (string.indexOf(string2) < 0) {
            return new String[]{string};
        }
        h h2 = new h();
        int n2 = string.indexOf(string2);
        while (n2 >= 0) {
            objectArray = string.substring(0, n2);
            String string3 = string.substring(string2.length() + n2);
            h2.if(objectArray);
            string = string3;
            n2 = string.indexOf(string2);
        }
        h2.if(string);
        objectArray = new String[h2.for()];
        h2.a(objectArray);
        return objectArray;
    }

    public static String int(String string) {
        byte[] byArray = string.getBytes();
        e e2 = new e();
        int n2 = 0;
        while (n2 < byArray.length) {
            if (byArray[n2] == 43) {
                e2.a(32);
            } else if (byArray[n2] == 37) {
                String string2 = new String(byArray, n2 + 1, 2);
                int n3 = Integer.parseInt(string2, 16);
                e2.a(n3);
                n2 += 2;
            } else {
                e2.a(byArray[n2]);
            }
            ++n2;
        }
        return e2.toString();
    }

    public static String case(String string) {
        char c2 = '\u0000';
        StringBuffer stringBuffer = new StringBuffer(string.length() * 6);
        int n2 = 0;
        while (n2 < string.length()) {
            c2 = string.charAt(n2);
            if (c2 > '\u00ff' || c2 == '%' || c2 == '+' || c2 == '\"' || c2 == '\'' || c2 == '<' || c2 == '>') {
                stringBuffer.append('%');
                stringBuffer.append(Integer.toHexString(c2));
                stringBuffer.append('%');
            } else if (c2 == ' ') {
                stringBuffer.append('+');
            } else {
                stringBuffer.append(c2);
            }
            ++n2;
        }
        return stringBuffer.toString();
    }

    public static final int if(int n2, int n3) {
        Date date = b.a(n2);
        Date date2 = b.a(n3);
        long l2 = date.getTime();
        long l3 = date2.getTime();
        int n4 = (int)((l3 - l2) / 1000L);
        return n4;
    }

    public static final int a(int n2, long l2) {
        Date date = b.a(n2);
        int n3 = (int)((l2 - date.getTime()) / 1000L);
        return n3;
    }

    public static String do() {
        Date date = new Date();
        return a.format(date);
    }

    public static final String byte(String string) {
        int n2 = string.length();
        StringBuffer stringBuffer = new StringBuffer(string.length() * 4);
        stringBuffer.append('{');
        int n3 = 0;
        while (n3 < n2) {
            char c2 = string.charAt(n3);
            stringBuffer.append((int)c2);
            if (n3 < n2 - 1) {
                stringBuffer.append(',');
            } else {
                stringBuffer.append('}');
            }
            ++n3;
        }
        return stringBuffer.toString();
    }

    private b() {
    }

    public static String do(String string) {
        if (string.indexOf(37) < 0 && string.indexOf(43) < 0) {
            return string;
        }
        StringBuffer stringBuffer = new StringBuffer(string.length());
        char c2 = '\u0000';
        int n2 = 0;
        while (n2 < string.length()) {
            c2 = string.charAt(n2);
            if (c2 == '%') {
                int n3 = string.indexOf(37, n2 + 1);
                String string2 = string.substring(n2 + 1, n3);
                c2 = (char)Integer.parseInt(string2, 16);
                n2 = n3;
            } else if (c2 == '+') {
                c2 = ' ';
            }
            stringBuffer.append(c2);
            ++n2;
        }
        return stringBuffer.toString();
    }

    public static final Date a(int n2) {
        int n3 = (n2 >> 26) + 100;
        int n4 = n2 >> 22 & 0xF;
        int n5 = n2 >> 17 & 0x1F;
        int n6 = n2 >> 12 & 0x1F;
        int n7 = n2 >> 6 & 0x3F;
        int n8 = n2 & 0x3F;
        Date date = new Date(n3, n4, n5, n6, n7, n8);
        return date;
    }

    public static int a() {
        Date date = new Date();
        return b.a(date);
    }

    public static byte[] new(String string) {
        return b.a(new File(string));
    }

    public static byte[] a(File file) {
        if (!file.exists() || file.isDirectory()) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] byArray = new byte[((InputStream)fileInputStream).available()];
            ((InputStream)fileInputStream).read(byArray);
            ((InputStream)fileInputStream).close();
            return byArray;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return null;
        }
    }

    public static void a(String string, byte[] byArray) {
        b.a(new File(string), byArray);
    }

    public static void a(File file, byte[] byArray) {
        Object object;
        String string = file.getParent();
        if (string != null && !((File)(object = new File(file.getParent()))).exists()) {
            b.try(file.getAbsolutePath());
        }
        try {
            object = new FileOutputStream(file);
            ((FileOutputStream)object).write(byArray);
            ((FileOutputStream)object).close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public static void a(File file, a a2, String string, boolean bl) {
        String[] stringArray = file.list();
        if (stringArray == null) {
            return;
        }
        int n2 = 0;
        while (n2 < stringArray.length) {
            File file2 = new File(file, stringArray[n2]);
            if (file2.isDirectory() && bl) {
                b.a(file2, a2, string, bl);
            } else if (stringArray[n2].toLowerCase().endsWith(string)) {
                a2.if(file2.getPath());
            }
            ++n2;
        }
    }

    public static final String do(int n2) {
        Date date = b.a(n2);
        return a.format(date);
    }

    public static final String a(long l2) {
        Date date = new Date(l2);
        return a.format(date);
    }

    public static int if(long l2) {
        Date date = new Date(l2);
        return b.a(date);
    }

    public static int a(long l2, int[] nArray) {
        Date date = new Date(l2);
        int n2 = date.getYear() - 100;
        int n3 = date.getMonth();
        int n4 = date.getDate();
        int n5 = date.getHours();
        int n6 = date.getMinutes();
        int n7 = date.getSeconds();
        nArray[0] = n2;
        nArray[1] = n3;
        nArray[2] = n4;
        nArray[3] = n5;
        nArray[4] = n6;
        nArray[5] = n7;
        nArray[6] = date.getDay();
        return n2 << 26 | n3 << 22 | n4 << 17 | n5 << 12 | n6 << 6 | n7;
    }

    public static int a(int n2, int n3, int n4, int n5, int n6, int n7) {
        return n2 << 26 | n3 << 22 | n4 << 17 | n5 << 12 | n6 << 6 | n7;
    }

    public static final int a(Date date) {
        int n2 = date.getYear() - 100;
        int n3 = date.getMonth();
        int n4 = date.getDate();
        int n5 = date.getHours();
        int n6 = date.getMinutes();
        int n7 = date.getSeconds();
        return n2 << 26 | n3 << 22 | n4 << 17 | n5 << 12 | n6 << 6 | n7;
    }

    public static String if() {
        if (if != null) {
            return if.a();
        }
        try {
            Transferable transferable = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
            Object object = transferable.getTransferData(DataFlavor.stringFlavor);
            if (object instanceof String) {
                return (String)object;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return "";
    }

    public static boolean a(String string) {
        int n2 = string.length();
        int n3 = 0;
        while (n3 < n2) {
            char c2 = string.charAt(n3);
            if (c2 <= ' ' || c2 == '\"' || c2 == '\'' || c2 == '/' || c2 == '>' || c2 == '<') {
                return false;
            }
            ++n3;
        }
        return true;
    }

    public static void for(String string) {
        if (if != null) {
            if.a(string);
        } else {
            StringSelection stringSelection = new StringSelection(string);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, stringSelection);
        }
    }

    public static String a(String string, String string2, String string3) {
        int n2;
        if (string3 == null) {
            string3 = "";
        }
        if ((n2 = string.indexOf(string2)) < 0) {
            return string;
        }
        String[] stringArray = b.a(string, string2);
        StringBuffer stringBuffer = new StringBuffer(string.length() + string3.length());
        int n3 = 0;
        while (n3 < stringArray.length - 1) {
            stringBuffer.append(stringArray[n3]);
            stringBuffer.append(string3);
            ++n3;
        }
        stringBuffer.append(stringArray[stringArray.length - 1]);
        return stringBuffer.toString();
    }

    public static void a(Rectangle rectangle, Rectangle rectangle2, Rectangle rectangle3) {
        int n2 = rectangle.x;
        int n3 = rectangle.y;
        int n4 = rectangle2.x;
        int n5 = rectangle2.y;
        int n6 = n2;
        n6 += rectangle.width;
        int n7 = n3;
        n7 += rectangle.height;
        int n8 = n4;
        n8 += rectangle2.width;
        int n9 = n5;
        n9 += rectangle2.height;
        if (n2 < n4) {
            n2 = n4;
        }
        if (n3 < n5) {
            n3 = n5;
        }
        if (n6 > n8) {
            n6 = n8;
        }
        if (n7 > n9) {
            n7 = n9;
        }
        n7 -= n3;
        if ((n6 -= n2) < Integer.MIN_VALUE) {
            n6 = Integer.MIN_VALUE;
        }
        if (n7 < Integer.MIN_VALUE) {
            n7 = Integer.MIN_VALUE;
        }
        rectangle3.setBounds(n2, n3, n6, n7);
    }

    public static Object char(String string) {
        try {
            Class<?> clazz = Class.forName(string);
            return clazz.newInstance();
        }
        catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
        catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        }
        catch (InstantiationException instantiationException) {
            instantiationException.printStackTrace();
        }
        return null;
    }
}

