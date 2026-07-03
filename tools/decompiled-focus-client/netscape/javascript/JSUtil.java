/*
 * Decompiled with CFR 0.152.
 */
package netscape.javascript;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

public class JSUtil {
    public static String getStackTrace(Throwable throwable) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintWriter printWriter = new PrintWriter(byteArrayOutputStream);
        throwable.printStackTrace(printWriter);
        printWriter.flush();
        return byteArrayOutputStream.toString();
    }
}

