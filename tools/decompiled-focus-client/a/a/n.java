/*
 * Decompiled with CFR 0.152.
 */
package a.a;

import a.a.h;
import a.a.i;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class n {
    private static n a = null;

    public void a(i i2, i i3) {
        this.a(i2, i2, i3, i2.do());
    }

    private void a(i i2, i i3, i i4, String string) {
        h h2 = i3.int();
        if (h2 != null) {
            int[] nArray = new int[h2.for()];
            int n2 = 0;
            int n3 = 0;
            while (n3 < h2.for()) {
                i i5 = (i)h2.if(n3);
                String string2 = string + "/" + i5.do();
                if (this.a(string2, i4).for() == 0) {
                    nArray[n2] = n3;
                    ++n2;
                } else {
                    this.a(i2, i5, i4, string2);
                }
                ++n3;
            }
            n3 = 0;
            while (n3 < n2) {
                i3.do(nArray[n3] - n3);
                ++n3;
            }
        }
    }

    public h a(String string, i i2) {
        if (string.charAt(string.length() - 1) != '/') {
            string = string + "/";
        }
        if (string.charAt(0) == '/') {
            string = string.substring(1);
        }
        h h2 = new h();
        this.a(string, i2, "", h2);
        return h2;
    }

    private void a(String string, i i2, String string2, h h2) {
        String string3 = string2 + i2.do() + "/";
        if (!string.equals(string3)) {
            h h3;
            if (string.startsWith(string3) && (h3 = i2.int()) != null) {
                int n2 = 0;
                while (n2 < h3.for()) {
                    i i3 = (i)h3.if(n2);
                    this.a(string, i3, string3, h2);
                    ++n2;
                }
            }
        } else {
            h2.if(i2);
        }
    }

    private int do(int n2, String string) {
        int n3;
        boolean bl = true;
        do {
            int n4;
            char c2;
            bl = true;
            n3 = string.indexOf("<", n2);
            if (n3 == -1 || (c2 = string.charAt(n3 + 1)) != '?' && c2 != '!') continue;
            if (string.indexOf("<![CDATA[", n2) != -1) {
                n4 = string.indexOf("]]>", n2 + 10);
                if (n4 != -1) {
                    n2 = n4 + 3;
                }
            } else {
                n2 = n3 + 1;
                n4 = string.indexOf(">", n2);
                if (n4 != -1) {
                    n2 = n4 + 1;
                }
            }
            bl = false;
        } while (n3 != -1 && !bl);
        return n3;
    }

    private n() {
    }

    private boolean a(String string, int n2, int n3, String string2) {
        boolean bl = true;
        int n4 = 0;
        int n5 = 0;
        int n6 = n2 - 1;
        String string3 = "<" + string;
        int n7 = string3.length();
        do {
            int n8;
            if ((n6 = string2.indexOf(string3, n6)) != -1 && n6 <= n3 && (n8 = string2.charAt(n6 + n7)) != 32 && n8 != 47 && n8 != 62) {
                n6 = -1;
            }
            if (n6 == -1 || n6 > n3) continue;
            n8 = string2.indexOf(">", n6);
            int n9 = string2.indexOf("/", n6);
            int n10 = string2.indexOf("<", n6 + 1);
            if (n10 == -1) {
                n10 = 999999999;
            }
            if (n9 != -1 && n8 != -1 && n9 < n8 && n10 > n8) {
                ++n4;
                ++n5;
            } else {
                ++n4;
            }
            ++n6;
        } while (n6 <= n3 && n6 != -1);
        n6 = n2 - 1;
        string3 = "</" + string + ">";
        do {
            if ((n6 = string2.indexOf(string3, n6)) == -1 || n6 > n3) continue;
            ++n5;
            ++n6;
        } while (n6 <= n3 && n6 != -1);
        bl = n5 - n4 == 0;
        return bl;
    }

    private h a(int n2, String string) {
        int n3;
        h h2 = new h(4);
        int n4 = string.indexOf("/>", n2);
        int n5 = string.indexOf(">", n2);
        if (n4 == -1) {
            n4 = n5;
        } else if (n5 < n4) {
            n4 = n5;
        }
        if (n4 != -1 && (n3 = string.indexOf(" ", n2)) != -1 && n3 < n4) {
            String string2 = string.substring(n3, n4) + " ";
            n3 = 0;
            int n6 = 0;
            do {
                int n7;
                if ((n6 = string2.indexOf("=", ++n3)) == -1) continue;
                String string3 = string2.substring(n3, n6).trim();
                n3 = string2.indexOf(" ", ++n6);
                if (string2.charAt(n6) == '\"') {
                    int n8 = string2.indexOf("\"", n6 + 1);
                    if (n8 != -1 && n8 > n3) {
                        n3 = n8;
                    }
                } else if (string2.charAt(n6) == '\'' && (n7 = string2.indexOf("'", n6 + 1)) != -1 && n7 > n3) {
                    n3 = n7;
                }
                if (n3 == -1 || string3.length() <= 0) continue;
                String string4 = string2.substring(n6, n3).trim();
                if (string4.charAt(0) == '\"') {
                    string4 = string4.substring(1);
                } else if (string4.charAt(0) == '\'') {
                    string4 = string4.substring(1);
                }
                if (string4.charAt(string4.length() - 1) == '\"') {
                    string4 = string4.substring(0, string4.length() - 1);
                } else if (string4.charAt(string4.length() - 1) == '\'') {
                    string4 = string4.substring(0, string4.length() - 1);
                }
                h2.if(new String[]{string3, string4.trim()});
            } while (n6 != -1 && n3 != -1);
        }
        return h2;
    }

    private String a(int n2, int n3, String string) {
        int n4 = string.indexOf(">", n2);
        if (n4 != -1 && n4 < n3) {
            return string.substring(n4 + 1, n3);
        }
        return null;
    }

    private String if(int n2, String string) {
        int n3 = string.indexOf(">", n2);
        String string2 = "";
        if (n3 != -1) {
            String string3 = string.substring(n2, n3);
            int n4 = 0;
            while (n4 < string3.length()) {
                char c2 = string3.charAt(n4);
                if (c2 == ' ' || c2 == '/') break;
                if (c2 != '<') {
                    string2 = string2 + c2;
                }
                ++n4;
            }
        }
        return string2;
    }

    private int a(int n2, int n3, String string, String string2) {
        String string3;
        int n4;
        int n5 = n2;
        if (n3 == -1) {
            n3 = n2;
        }
        int n6 = string2.indexOf(">", n3);
        int n7 = string2.indexOf("/", n3);
        int n8 = string2.indexOf("<", n3 + 1);
        if (n8 == -1) {
            n8 = 999999999;
        }
        if (n7 != -1 && n6 != -1 && n7 < n6 && n8 > n6) {
            return n6;
        }
        if (n6 != -1 && (n4 = string2.indexOf(string3 = "</" + string + ">", n3)) != -1) {
            boolean bl = this.a(string, n5, n4, string2);
            if (bl) {
                return n4;
            }
            return this.a(n5, n4 + 2, string, string2);
        }
        return -1;
    }

    public i a(String string) {
        h h2 = this.a(string + " ", 0);
        if (h2 != null) {
            return (i)h2.if(0);
        }
        return null;
    }

    private h a(String string, int n2) {
        int n3 = 0;
        h h2 = null;
        do {
            String string2;
            if ((n3 = this.do(n3, string)) == -1 || (string2 = this.if(++n3, string)).length() <= 0) continue;
            int n4 = this.a(n3, -1, string2, string);
            if (n4 != -1) {
                i i2 = new i();
                i2.if(string2);
                i2.a(n2);
                i2.if(this.a(n3, string));
                h h3 = this.a(string.substring(n3 + string2.length(), n4), n2 + 1);
                if (h3 != null) {
                    i2.a(h3);
                }
                if (h3 == null || h3.for() == 0) {
                    i2.do(this.a(n3, n4, string));
                }
                if (h2 == null) {
                    h2 = new h(5);
                }
                h2.if(i2);
            }
            n3 = n4;
        } while (n3 != -1);
        return h2;
    }

    public static n a() {
        if (a == null) {
            a = new n();
        }
        return a;
    }
}

