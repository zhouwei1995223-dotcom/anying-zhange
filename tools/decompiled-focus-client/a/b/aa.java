/*
 * Decompiled with CFR 0.152.
 */
package a.b;

import a.b.b;
import a.b.c;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class aa
implements b {
    public static final int e = 0;
    public static final int d = 1;
    public static final int j = 2;
    private int f;
    private int i;
    private int h;
    private int g;

    public aa(int n2, int n3, int n4, int n5) {
        this.f = n2;
        this.i = n3;
        this.h = n4;
        this.g = n5;
    }

    public void a(c c2, int n2, int n3, int n4, int n5) {
        block3: {
            block4: {
                block2: {
                    if (this.g != 0) break block2;
                    c2.a(n2, n3, this.f, this.i, this.h);
                    break block3;
                }
                if (this.g != 1) break block4;
                int n6 = n3;
                float f2 = n2 + this.f / 2;
                float f3 = (float)this.f * 1.0f / (float)this.i;
                float f4 = 1.0f;
                int n7 = 0;
                while (n7 < this.i) {
                    c2.do((int)f2, n6, (int)(f2 + f4), n6, this.h);
                    f4 += f3;
                    f2 -= f3 / 2.0f;
                    ++n6;
                    ++n7;
                }
                break block3;
            }
            if (this.g != 2) break block3;
            int n8 = n3;
            float f5 = n2;
            float f6 = (float)this.f * 1.0f / (float)this.i;
            float f7 = this.f;
            int n9 = 0;
            while (n9 < this.i) {
                c2.do((int)f5, n8, (int)(f5 + f7), n8, this.h);
                f7 -= f6;
                f5 += f6 / 2.0f;
                ++n8;
                ++n9;
            }
        }
    }

    public int if() {
        return this.i;
    }

    public int a() {
        return this.f;
    }
}

