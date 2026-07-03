/*
 * Decompiled with CFR 0.152.
 */
package daff.a;

import daff.a.l;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
class j
implements l {
    private Object[] do;
    private int if;
    private int a;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(this.getClass().getName() + "[");
        int n2 = 0;
        while (n2 < this.if) {
            stringBuffer.append(this.do[n2].toString() + ',');
            ++n2;
        }
        stringBuffer.setCharAt(stringBuffer.length() - 1, ']');
        return stringBuffer.toString();
    }

    j(Object[] objectArray, int n2) {
        this.do = objectArray;
        this.if = n2;
    }

    public boolean equals(Object object) {
        if (object instanceof j) {
            boolean bl;
            j j2 = (j)object;
            boolean bl2 = bl = j2.if == this.if;
            if (bl) {
                int n2 = 0;
                while (n2 < this.if) {
                    if (!this.do[n2].equals(j2.do[n2])) {
                        return false;
                    }
                    ++n2;
                }
            }
            return bl;
        }
        return false;
    }

    public boolean a() {
        return this.a < this.if;
    }

    public Object if() {
        return this.do[this.a++];
    }
}

