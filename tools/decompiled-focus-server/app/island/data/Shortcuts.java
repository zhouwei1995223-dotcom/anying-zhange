/*
 * Decompiled with CFR 0.152.
 */
package app.island.data;

import app.island.GameObject;
import daff.a.b;
import daff.a.e;
import daff.a.i;

public class Shortcuts
extends GameObject {
    public int[] idArray = new int[12];
    public int[] flagArray = new int[12];

    public void readFrom(e e2) {
        int n2 = 0;
        while (n2 < this.idArray.length) {
            this.flagArray[n2] = e2.case();
            this.idArray[n2] = this.flagArray[n2] > 0 ? e2.i() : 0;
            ++n2;
        }
    }

    public void writeTo(e e2) {
        int n2 = 0;
        while (n2 < this.idArray.length) {
            e2.a(this.flagArray[n2]);
            if (this.flagArray[n2] > 0) {
                e2.char(this.idArray[n2]);
            }
            ++n2;
        }
    }

    public i getAttributeValue(String string) {
        if (string.equals("idArray")) {
            StringBuffer stringBuffer = new StringBuffer(1024);
            int n2 = 0;
            while (n2 < this.idArray.length) {
                stringBuffer.append(this.idArray[n2]);
                stringBuffer.append(',');
                ++n2;
            }
            i i2 = new i(string);
            i2.do(stringBuffer.toString());
            return i2;
        }
        if (string.equals("flagArray")) {
            StringBuffer stringBuffer = new StringBuffer(32);
            int n3 = 0;
            while (n3 < this.idArray.length) {
                stringBuffer.append(this.flagArray[n3]);
                stringBuffer.append(',');
                ++n3;
            }
            i i3 = new i(string);
            i3.do(stringBuffer.toString());
            return i3;
        }
        return super.getAttributeValue(string);
    }

    public boolean setAttributeValue(String string, String string2) {
        if (string.equals("idArray")) {
            String[] stringArray = b.a(string2, ",");
            int n2 = 0;
            while (n2 < stringArray.length) {
                if (stringArray[n2].length() == 0) break;
                this.idArray[n2] = Integer.parseInt(stringArray[n2]);
                ++n2;
            }
            return true;
        }
        if (string.equals("flagArray")) {
            String[] stringArray = b.a(string2, ",");
            int n3 = 0;
            while (n3 < stringArray.length) {
                if (stringArray[n3].length() == 0) break;
                this.flagArray[n3] = Integer.parseInt(stringArray[n3]);
                ++n3;
            }
            return true;
        }
        return super.setAttributeValue(string, string2);
    }
}

