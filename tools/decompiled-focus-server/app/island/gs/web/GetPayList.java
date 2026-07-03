/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.web;

import app.island.gs.GameServer;
import app.island.gs.o;
import app.island.gs.web.WebServlet;
import daff.a.b;
import daff.a.h;
import java.io.File;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class GetPayList
extends WebServlet {
    public static boolean dataChanged = true;
    private static h byte = null;

    private void a() {
        File file = new File("data/pay_logs");
        String[] stringArray = file.list();
        String[][] stringArrayArray = new String[stringArray.length][];
        int n2 = 0;
        long[] lArray = new long[stringArray.length];
        int n3 = 0;
        while (n3 < stringArray.length) {
            File file2 = new File(file, stringArray[n3]);
            byte[] byArray = b.a(file2);
            String string = new String(byArray);
            String[] stringArray2 = null;
            if (string.indexOf(9) > 0) {
                stringArray2 = b.a(string, "\t");
            } else if (string.indexOf(58) > 0) {
                stringArray2 = b.a(string, ":");
            }
            if (stringArray2 != null) {
                String string2 = b.a(file2.getName(), ".")[0];
                String string3 = "no";
                if (stringArray2.length > 2 && stringArray2[2].length() > 1) {
                    string3 = stringArray2[2];
                }
                long l2 = file2.lastModified();
                stringArray2 = new String[]{stringArray2[0], stringArray2[1], string2, string3, b.a(l2)};
                int n4 = n2;
                int n5 = 0;
                while (n5 < n2) {
                    if (l2 < lArray[n5]) {
                        int n6 = n2;
                        while (n6 > n5) {
                            lArray[n6] = lArray[n6 - 1];
                            stringArrayArray[n6] = stringArrayArray[n6 - 1];
                            --n6;
                        }
                        n4 = n5;
                        break;
                    }
                    ++n5;
                }
                lArray[n4] = l2;
                stringArrayArray[n4] = stringArray2;
                ++n2;
            }
            ++n3;
        }
        byte = new h(n2);
        n3 = 0;
        while (n3 < n2) {
            byte.if(stringArrayArray[n3]);
            ++n3;
        }
    }

    public synchronized String getResponseText(app.a.b b2, GameServer gameServer, o o2) {
        if (dataChanged || byte == null) {
            this.a();
            dataChanged = false;
        }
        String string = b2.if("user");
        String string2 = b2.if("ad");
        String string3 = b2.if("time");
        int n2 = byte.for();
        int n3 = 0;
        int n4 = 0;
        StringBuffer stringBuffer = new StringBuffer(n2 * 100);
        stringBuffer.append("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\"></head><body>");
        stringBuffer.append("<h1 align=center>\u670d\u52a1\u5668\u5145\u503c\u8bb0\u5f55</h1>");
        stringBuffer.append("<table border=1 width=770 align='center'>");
        stringBuffer.append("<TR><TD>\u5e10\u53f7</TD><TD>\u5143\u5b9d</TD><TD>\u5b9a\u5355\u53f7</TD><TD>\u63a8\u8350\u4eba</TD><TD>\u65f6\u95f4 </TD></TR>");
        int n5 = 0;
        while (n5 < n2) {
            String[] stringArray = (String[])byte.if(n5);
            if (!(string.length() > 0 && !string.equals(stringArray[0]) || string2.length() > 0 && !string2.equals(stringArray[3]) || string3.length() > 0 && stringArray[4].indexOf(string3) < 0)) {
                stringBuffer.append("<TR><TD>");
                stringBuffer.append(stringArray[0]);
                stringBuffer.append("</TD><TD>");
                stringBuffer.append(stringArray[1]);
                stringBuffer.append("</TD><TD>");
                stringBuffer.append(stringArray[2]);
                stringBuffer.append("</TD><TD>");
                stringBuffer.append(stringArray[3]);
                stringBuffer.append("</TD><TD>");
                stringBuffer.append(stringArray[4]);
                stringBuffer.append("</TD></TR>");
                ++n3;
                n4 += Integer.parseInt(stringArray[1]);
            }
            ++n5;
        }
        stringBuffer.append("</table>");
        stringBuffer.append("<BR><div align=\"center\" width=\"770\">");
        stringBuffer.append("\u5b9a\u5355\u603b\u6570:");
        stringBuffer.append(n3);
        stringBuffer.append(";\u5143\u5b9d\u603b\u8ba1:");
        stringBuffer.append(n4);
        stringBuffer.append("</div>");
        stringBuffer.append("</body></html>");
        dataChanged = false;
        return stringBuffer.toString();
    }
}

