/*
 * Decompiled with CFR 0.152.
 */
package daff.a;

import daff.a.h;
import java.io.Serializable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class i
implements Serializable {
    private String a = "";
    private String for = "";
    private h int;
    private h if;
    private int do = 0;

    public String for(String string) {
        String string2 = "";
        if (this.int != null) {
            for (int i2 = 0; i2 < this.int.for(); ++i2) {
                if (!((String[])this.int.if(i2))[0].equals(string)) continue;
                string2 = ((String[])this.int.if(i2))[1];
                break;
            }
        }
        return string2;
    }

    public String toString() {
        Object object;
        int n2;
        StringBuffer stringBuffer = new StringBuffer(1024);
        int n3 = 0;
        while (n3 < this.do) {
            stringBuffer.append('\t');
            ++n3;
        }
        stringBuffer.append('<');
        stringBuffer.append(this.a);
        if (this.int != null && this.int.for() > 0) {
            n3 = this.int.for();
            n2 = 0;
            while (n2 < n3) {
                stringBuffer.append(' ');
                object = (String[])this.int.if(n2);
                stringBuffer.append(object[0]);
                stringBuffer.append("=\"");
                stringBuffer.append((String)object[1]);
                stringBuffer.append('\"');
                ++n2;
            }
        }
        stringBuffer.append('>');
        if (this.if != null) {
            stringBuffer.append("\r\n");
            n3 = this.if.for();
            n2 = 0;
            while (n2 < n3) {
                object = (i)this.if.if(n2);
                ((i)object).a(this.do + 1);
                String string = ((i)object).toString();
                stringBuffer.append(string);
                stringBuffer.append("\r\n");
                ++n2;
            }
            n2 = 0;
            while (n2 < this.do) {
                stringBuffer.append('\t');
                ++n2;
            }
        } else {
            stringBuffer.append(this.for);
        }
        stringBuffer.append("</");
        stringBuffer.append(this.a);
        stringBuffer.append('>');
        return stringBuffer.toString();
    }

    public i() {
        this("root");
    }

    public i(String string) {
        this.a = string;
    }

    public i a(String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        if (this.if == null) {
            return null;
        }
        int n2 = 0;
        while (n2 < this.if.for()) {
            i i2 = (i)this.if.if(n2);
            if (string.equals(i2.do())) {
                return i2;
            }
            ++n2;
        }
        return null;
    }

    public i for(int n2) {
        if (n2 < 0 || n2 >= this.if.for()) {
            return null;
        }
        return (i)this.if.if(n2);
    }

    protected void if(int n2) {
        if (this.int != null) {
            if (n2 >= 0 && n2 < this.int.for()) {
                this.int.a(n2);
            } else {
                System.out.println("Index out of range: " + n2);
            }
        }
    }

    public h if() {
        return this.int;
    }

    protected void if(h h2) {
        this.int = h2;
    }

    public String for() {
        if (this.for != null) {
            return this.for;
        }
        return "";
    }

    public void do(String string) {
        if (string != null && string.startsWith("<![CDATA[") && (string = string.substring(9)).endsWith("]]>")) {
            string = string.substring(0, string.length() - 3);
        }
        this.for = string;
    }

    public void a(String string, String string2) {
        if (this.int == null) {
            this.int = new h(3);
        }
        this.int.if(new String[]{string, string2});
    }

    protected void do(int n2) {
        if (this.if != null) {
            if (n2 >= 0 && n2 < this.if.for()) {
                this.if.a(n2);
            } else {
                System.out.println("Index out of range: " + n2);
            }
        }
    }

    public String do() {
        return this.a;
    }

    public void if(String string) {
        this.a = string;
    }

    public h int() {
        return this.if;
    }

    protected void a(h h2) {
        this.if = h2;
    }

    public int a() {
        return this.do;
    }

    protected void a(int n2) {
        this.do = n2;
    }

    public void a(i i2) {
        if (this.if == null) {
            this.if = new h(5);
        }
        if (i2.a() == 0) {
            i2.a(this.do + 1);
        }
        this.if.if(i2);
    }
}

