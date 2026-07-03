/*
 * Decompiled with CFR 0.152.
 */
package b.a.e;

import a.a.e;
import b.a.b;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class i
extends b {
    public int[] fB = new int[12];
    public int[] fA = new int[12];

    public void a(e e2) {
        int n2 = 0;
        while (n2 < this.fB.length) {
            this.fA[n2] = e2.case();
            this.fB[n2] = this.fA[n2] > 0 ? e2.i() : 0;
            ++n2;
        }
    }

    public void if(e e2) {
        int n2 = 0;
        while (n2 < this.fB.length) {
            e2.a(this.fA[n2]);
            if (this.fA[n2] > 0) {
                e2.char(this.fB[n2]);
            }
            ++n2;
        }
    }

    public a.a.i a(String string) {
        if (string.equals("idArray")) {
            StringBuffer stringBuffer = new StringBuffer(1024);
            int n2 = 0;
            while (n2 < this.fB.length) {
                stringBuffer.append(this.fB[n2]);
                stringBuffer.append(',');
                ++n2;
            }
            a.a.i i2 = new a.a.i(string);
            i2.do(stringBuffer.toString());
            return i2;
        }
        if (string.equals("flagArray")) {
            StringBuffer stringBuffer = new StringBuffer(32);
            int n3 = 0;
            while (n3 < this.fB.length) {
                stringBuffer.append(this.fA[n3]);
                stringBuffer.append(',');
                ++n3;
            }
            a.a.i i3 = new a.a.i(string);
            i3.do(stringBuffer.toString());
            return i3;
        }
        return super.a(string);
    }

    public boolean a(String string, String string2) {
        if (string.equals("idArray")) {
            String[] stringArray = a.a.b.a(string2, ",");
            int n2 = 0;
            while (n2 < stringArray.length) {
                if (stringArray[n2].length() == 0) break;
                this.fB[n2] = Integer.parseInt(stringArray[n2]);
                ++n2;
            }
            return true;
        }
        if (string.equals("flagArray")) {
            String[] stringArray = a.a.b.a(string2, ",");
            int n3 = 0;
            while (n3 < stringArray.length) {
                if (stringArray[n3].length() == 0) break;
                this.fA[n3] = Integer.parseInt(stringArray[n3]);
                ++n3;
            }
            return true;
        }
        return super.a(string, string2);
    }
}

