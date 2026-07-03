/*
 * Decompiled with CFR 0.152.
 */
package b.a.c.b;

import a.b.c;
import a.b.q;
import b.a.b;
import b.a.d.d;
import b.a.d.k;
import b.a.e.e;
import b.a.e.f;
import b.a.e.j;
import b.a.e.m;
import b.a.e.o;
import b.a.e.p;
import b.a.e.r;
import b.a.e.t;
import b.a.e.v;
import b.a.e.w;
import b.a.e.x;
import b.a.e.y;
import b.a.e.z;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class at
implements a.b.b {
    private static final at G = new at();
    public static final int[] y = new int[]{-1, -13318080, -15629579, -7864065, -752332, -1186560, -65536, -1, -1};
    private static final String[] E = new String[]{"", "\u62a4\u7532", "\u5e3d\u5b50", "\u9774\u5b50", "\u76fe\u724c"};
    private static final String[] I = new String[]{"", "\u8033\u73af", "\u9879\u94fe", "\u6212\u6307"};
    private static final String[] B = new String[]{"\u4ec5\u9650\u76ee\u6807\u4e00\u4e2a\u4eba", "\u4ec5\u9650\u76ee\u6807\u7684\u5c4f\u5e55\u4e0a\u73a9\u5bb6", "\u4ec5\u9650\u76ee\u6807\u7684\u573a\u666f\u5185\u73a9\u5bb6", "\u5168\u4e16\u754c\u73a9\u5bb6"};
    private static final String[] C = new String[]{"", "\u63d0\u5347\u7269\u7406\u653b\u51fb\uff1a", "\u63d0\u5347\u9b54\u6cd5\u653b\u51fb", "\u63d0\u9ad8\u6700\u5927\u751f\u547d\uff1a", "\u63d0\u9ad8\u6700\u5927\u9b54\u6cd5\uff1a", "\u63d0\u5347\u7269\u7406\u9632\u5fa1\uff1a", "\u63d0\u5347\u9b54\u6cd5\u9632\u5fa1\uff1a", "\u63d0\u5347\u653b\u51fb\u901f\u5ea6\uff1a", "\u63d0\u5347\u547d\u4e2d\u529b\uff1a", "\u63d0\u5347\u95ea\u907f\u529b\uff1a", ""};
    private static final int t = -1;
    private static final int A = -65536;
    private k w;
    private b x;
    private int u;
    private int H;
    private int F = -1090519040;
    private int v = -5653047;
    private int z;
    private String[] D = new String[32];
    private int[] s = new int[64];

    public b void() {
        return this.x;
    }

    public void if(r r2) {
        this.x = r2;
        this.long();
        this.a(r2);
    }

    public void d() {
        this.long();
        this.for("\u7279\u6b8a\u72b6\u6001\u4fe1\u606f");
        if (this.w.az > 0) {
            this.a("\u5728\u7ebf\u6302\u673a\u5269\u4f59" + this.w.az + "\u5206\u949f", -16711936);
        }
        if (this.w.bq > 0) {
            this.a("\u79bb\u7ebf\u6302\u673a\u5269\u4f59" + this.w.bq + "\u5206\u949f", -16711936);
        }
        if (this.w.bh > 0) {
            this.a("\u53cc\u500d\u7ecf\u9a8c\u5269\u4f59" + this.w.bh + "\u5206\u949f", -16711936);
        }
    }

    private void a(r r2) {
        this.for(r2.a);
        if (r2.jK > 0) {
            this.for("\u6301\u7eed\u65f6\u95f4\uff1a" + (float)(r2.jK * r2.jJ) / 1000.0f + "\u79d2");
        }
        this.a(r2.jo, -16711936);
    }

    private void long() {
        this.z = 0;
        this.u = 0;
        this.H = 18;
    }

    public void a(f f2, boolean bl) {
        this.x = f2;
        this.long();
        this.if(f2, bl);
    }

    private String int(int n2) {
        StringBuffer stringBuffer = new StringBuffer(64);
        int n3 = n2 / 86400;
        int n4 = n2 / 3600 % 24;
        int n5 = n2 / 60 % 60;
        n2 %= 60;
        stringBuffer.append(n3);
        stringBuffer.append('\u5929');
        stringBuffer.append(n4);
        stringBuffer.append("\u5c0f\u65f6");
        stringBuffer.append(n5);
        stringBuffer.append('\u5206');
        stringBuffer.append(n2);
        stringBuffer.append('\u79d2');
        return stringBuffer.toString();
    }

    public void a(c c2, int n2, int n3, int n4, int n5) {
        if (this.z <= 0) {
            return;
        }
        c2.if(n2, n3, this.u, this.H, this.v);
        c2.a(n2 + 1, n3 + 1, this.u - 2, this.H - 2, this.F);
        n2 += 9;
        n3 += 9;
        int n6 = 0;
        while (n6 < this.z) {
            c2.a(this.D[n6], n2, n3, this.s[n6]);
            n3 += 16;
            ++n6;
        }
    }

    private void if(f f2, boolean bl) {
        int n2;
        f f3;
        this.for(f2.a);
        this.for("\u7b49\u7ea7\uff1a" + f2.et);
        this.for("\u7ecf\u9a8c\uff1a" + f2.eN + "/" + f2.ev);
        if (f2.eH == 1) {
            f3 = (z)f2;
            if (f3.e7 == 0) {
                this.for("\u7c7b\u578b\uff1a\u9b54\u6cd5\u653b\u51fb");
            } else {
                this.for("\u7c7b\u578b\uff1a\u7269\u7406\u653b\u51fb");
            }
            if (f3.fd > 0) {
                this.for("\u6700\u5c0f\u4f24\u5bb3\u529b\uff1a" + f3.fd);
            }
            if (f3.fc > 0) {
                this.for("\u6700\u5927\u4f24\u5bb3\u529b\uff1a" + f3.fc);
            }
            if (f3.e8 > 0) {
                this.a("\u5c06\u81ea\u8eab\u7269\u7406\u653b\u51fb\u7684" + f3.e8 + "%\u7d2f\u52a0", y[2]);
            }
            if (f3.ff > 0) {
                this.a("\u5c06\u81ea\u8eab\u9b54\u6cd5\u653b\u51fb\u7684" + f3.ff + "%\u7d2f\u52a0", y[2]);
            }
            if (f3.fi > 0) {
                this.a("\u6bcf100\u70b9\u5f3a\u58ee\u589e\u52a0" + f3.fi + "\u70b9\u4f24\u5bb3", y[2]);
            }
            if (f3.fe > 0) {
                this.a("\u6bcf100\u70b9\u654f\u6377\u589e\u52a0" + f3.fe + "\u70b9\u4f24\u5bb3", y[2]);
            }
            if (f3.e9 > 0) {
                this.a("\u6bcf100\u70b9\u667a\u529b\u589e\u52a0" + f3.e9 + "\u70b9\u4f24\u5bb3", y[2]);
            }
        } else if (f2.eH == 3) {
            f3 = (b.a.e.q)f2;
            n2 = ((b.a.e.q)f3).e6 + ((b.a.e.q)f3).e0 * this.w.X / 100;
            this.for("\u6bcf\u6b21\u9020\u6210\u4f24\u5bb3\uff1a" + n2);
            this.for("\u6301\u7eed\u65f6\u95f4\uff1a" + ((b.a.e.q)f3).eY / 1000 + "\u79d2");
        } else if (f2.eH == 2) {
            f3 = (o)f2;
            this.for("\u547d\u4e2d\u51e0\u7387\uff1a" + ((o)f3).eV);
        }
        if (f2.eK > 0) {
            this.a("\u5347\u7ea7\u6240\u9700\u89d2\u8272\u7b49\u7ea7\uff1a" + f2.eK, this.w.p >= f2.eK ? -1 : -65536);
        }
        this.for("\u9b54\u6cd5\u6d88\u8017\uff1a" + f2.eJ);
        this.for("\u51b7\u5374\u65f6\u95f4\uff1a" + (float)f2.eF / 1000.0f + "\u79d2");
        if (f2.eO.length() > 0) {
            int n3 = f2.eO.length();
            n2 = 0;
            while (n3 > 0) {
                int n4 = Math.min(n3, 25);
                String string = f2.eO.substring(n2, n2 + n4);
                n3 -= n4;
                n2 += n4;
                this.a(string, -16711936);
            }
        }
        if (bl) {
            this.a("\u70b9\u9f20\u6807\u5de6\u952e\u53ef\u79fb\u52a8\u6b64\u6280\u80fd\u5230\u5feb\u6377\u680f", -16711696);
        } else {
            this.a("\u6309\u76f8\u5e94\u6570\u5b57\u952e\u53ef\u65bd\u653e\u8be5\u6280\u80fd", -16711696);
        }
    }

    public int e() {
        return this.v;
    }

    public void new(int n2) {
        this.v = n2;
    }

    private void for(String string) {
        this.a(string, -1);
    }

    private void a(String string, int n2) {
        this.D[this.z] = string;
        this.s[this.z] = n2;
        ++this.z;
        int n3 = q.if(string) + 18;
        if (n3 > this.u) {
            this.u = n3;
        }
        this.H += 16;
    }

    static {
        Object var1 = null;
        I = new String[]{"", "\u8033\u73af", "\u9879\u94fe", "\u6212\u6307", "\u79f0\u53f7"};
    }

    public int c() {
        return this.F;
    }

    public void for(int n2) {
        this.F = n2;
    }

    public int if() {
        return this.H;
    }

    public void a(j j2, boolean bl, boolean bl2, int n2, int n3, boolean bl3) {
        this.a(j2, bl, bl2, n2, n3, bl3, true);
    }

    public void a(j j2, boolean bl, boolean bl2, int n2, int n3, boolean bl3, boolean bl4) {
        this.x = j2;
        this.long();
        this.if(j2, bl, bl2, n2, n3, bl3, bl4);
    }

    private void if(j j2, boolean bl, boolean bl2, int n2, int n3, boolean bl3, boolean bl4) {
        this.a(j2.a, y[j2.fM]);
        this.for("\u7f16\u53f7\uff1a" + j2.if);
        if (j2.fS > 0) {
            long l2;
            if (n2 > 0 && j2.fK == 0) {
                this.for("\u91d1\u5e01\u4ef7\u503c\uff1a" + j2.fS);
                l2 = (long)j2.fS * 1L * (long)n2 / 100L;
                this.for("\u8d2d\u4e70\u4ef7\u683c\uff1a" + (int)l2);
            } else if (n3 > 0) {
                this.for("\u91d1\u5e01\u4ef7\u503c\uff1a" + j2.fS);
                l2 = (long)j2.fS * 1L * (long)n3 / 100L;
                this.for("\u51fa\u552e\u4ef7\u683c\uff1a" + (int)l2);
            } else {
                this.for("\u91d1\u5e01\u4ef7\u503c\uff1a" + j2.fS);
            }
        }
        if (j2.fK > 0) {
            this.for("\u5143\u5b9d\u4ef7\u503c\uff1a" + j2.fK);
            if (n2 > 0) {
                this.for("\u8d2d\u4e70\u4ef7\u683c\uff1a" + j2.fK * n2 / 100);
            }
        }
        if (j2.fW == 0) {
            p p2 = (p)j2;
            if (p2.gN > 1) {
                float f2 = (float)p2.gP / 1000.0f;
                this.for("\u7c7b\u578b\uff1a\u836f\u54c1");
                if (p2.gM > 0) {
                    this.for("\u6bcf" + f2 + "\u79d2\u56de\u590d" + p2.gM + "\u70b9\u751f\u547d");
                    this.for("\u603b\u5171\u56de\u590d" + p2.gM * p2.gN + "\u70b9\u751f\u547d");
                }
                if (p2.gQ > 0) {
                    this.for("\u6bcf" + f2 + "\u79d2\u56de\u590d" + p2.gQ + "\u70b9\u9b54\u6cd5");
                    this.for("\u603b\u5171\u56de\u590d" + p2.gQ * p2.gN + "\u70b9\u9b54\u6cd5");
                }
            } else {
                if (p2.gM > 0) {
                    this.for("\u4e00\u6b21\u6027\u56de\u590d" + p2.gM + "\u70b9\u751f\u547d");
                }
                if (p2.gQ > 0) {
                    this.for("\u4e00\u6b21\u6027\u56de\u590d" + p2.gQ + "\u70b9\u9b54\u6cd5");
                }
            }
            if (p2.fR.length() > 0) {
                int n4 = p2.fR.length();
                int n5 = 0;
                while (n4 > 0) {
                    int n6 = Math.min(n4, 25);
                    String string = p2.fR.substring(n5, n5 + n6);
                    n4 -= n6;
                    n5 += n6;
                    this.a(string, -16711936);
                }
            }
            if (bl) {
                this.a("\u5355\u51fb\u9f20\u6807\u53f3\u952e\u4f7f\u7528\u6b64\u836f\u54c1", -16711696);
            }
        } else if (j2.fW == 4) {
            this.for("\u7c7b\u578b\uff1a\u6280\u80fd\u4e66");
            w w2 = (w)j2;
            if (w2.ie >= 0) {
                this.a("\u9002\u7528\u804c\u4e1a\uff1a" + d.ap[w2.ie], this.w.af == w2.ie ? -1 : -65536);
            }
            if (w2.ig > 0) {
                this.a("\u8f6c\u751f\u9700\u6c42\uff1a" + w2.ig, this.w.ab >= w2.ig ? -1 : -65536);
            }
            if (w2.id > 0) {
                this.a("\u7b49\u7ea7\u9700\u6c42\uff1a" + w2.id, w2.id <= this.w.p ? -1 : -65536);
            }
            if (w2.fR.length() > 0) {
                this.a(w2.fR, -16711936);
            }
            if (bl) {
                this.a("\u5355\u51fb\u9f20\u6807\u53f3\u952e\u8fdb\u884c\u5b66\u4e60", -16711696);
            }
        } else if (j2.fW == 5) {
            int n7;
            int n8;
            this.for("\u7c7b\u578b\uff1a\u7279\u6b8a\u9053\u5177");
            t t2 = (t)j2;
            if (t2.ho > 0) {
                this.a("\u8fc7\u671f\u65f6\u95f4\uff1a" + a.a.b.do(t2.ho), a.a.b.if() >= t2.ho ? -65536 : -16711936);
            }
            if (t2.g6 > 0) {
                if (t2.g6 > this.w.p) {
                    this.a("\u4f7f\u7528\u7b49\u7ea7\u9650\u5236\uff1a" + t2.g6, -65536);
                } else {
                    this.a("\u4f7f\u7528\u7b49\u7ea7\u9650\u5236\uff1a" + t2.g6, -1);
                }
            }
            if (t2.fR.length() > 0) {
                n8 = t2.fR.length();
                n7 = 0;
                while (n8 > 0) {
                    int n9 = Math.min(n8, 25);
                    String string = t2.fR.substring(n7, n7 + n9);
                    n8 -= n9;
                    n7 += n9;
                    this.a(string, -16711936);
                }
            }
            if (t2.hg == 19) {
                if (t2.hi > 1000) {
                    n8 = t2.hi % 1000;
                    n7 = t2.hi / 1000 % 1000;
                    this.a("\u4f4d\u7f6e\uff1a" + n8 + "\uff0c" + n7, -16711936);
                } else {
                    this.a("\u5728\u795e\u79d8\u7684\u5750\u6807", -16711936);
                }
            } else if (t2.hg == 31) {
                this.a("\u5269\u4f59\u8840\u91cf\uff1a" + t2.hi, -1);
            } else if (t2.hg == 32) {
                this.a("\u5269\u4f59\u9b54\u6cd5\uff1a" + t2.hi, -1);
            } else if (t2.hg == 37) {
                this.a("\u53ef\u7528\u6b21\u6570\uff1a" + t2.hi, -1);
            }
            if (bl) {
                if (t2.hg > 0 && t2.gT > 0) {
                    this.a("\u5355\u51fb\u9f20\u6807\u53f3\u952e\u4f7f\u7528\u6b64\u9053\u5177", -16711696);
                } else {
                    this.a("\u672c\u9053\u5177\u4e0d\u53ef\u88ab\u4f7f\u7528", -65536);
                }
            }
        } else if (j2.fW == 8) {
            m m2 = (m)j2;
            if (m2.gK == 0) {
                this.for("\u7c7b\u578b\uff1a\u539f\u6750\u6599");
            } else {
                this.for("\u7c7b\u578b\uff1a\u5408\u6210\u6750\u6599");
            }
            if (m2.gL > 0 && m2.gL < 5) {
                this.a("\u5355\u51fb\u9f20\u6807\u53f3\u952e\u6253\u5f00\u6750\u6599\u5408\u6210\u754c\u9762", -16711696);
            }
            if (m2.fR.length() > 1) {
                this.a(m2.fR, -16711936);
            }
        } else if (j2.fW == 1) {
            int n10;
            int n11;
            v v2 = (v)j2;
            this.for("\u7c7b\u578b\uff1a\u6b66\u5668");
            this.for("\u7269\u7406\u653b\u51fb\u529b\uff1a" + v2.ic + "-" + v2.hT);
            this.for("\u9b54\u6cd5\u653b\u51fb\u529b\uff1a" + v2.h9 + "-" + v2.h1);
            if (v2.h6 > 0 || v2.hG > 0) {
                this.a("\u7269\u7406\u653b\u51fb\u529b\u63d0\u5347\uff1a" + v2.h6 + "-" + v2.hG, y[2]);
            }
            if (v2.h2 > 0 || v2.hV > 0) {
                this.a("\u9b54\u6cd5\u653b\u51fb\u529b\u63d0\u5347\uff1a" + v2.h2 + "-" + v2.hV, y[2]);
            }
            if (v2.hQ > 0) {
                this.a("\u589e\u52a0\u547d\u4e2d\u529b\uff1a" + v2.hQ, y[2]);
            }
            if (v2.ia > 0) {
                this.a("\u653b\u51fb\u8ddd\u79bb\u63d0\u5347\uff1a" + v2.ia, y[2]);
            }
            if (v2.hR > 0) {
                this.a("\u5ef6\u957f\u653b\u51fb\u65f6\u95f4\uff1a" + v2.hR, y[2]);
            } else if (v2.hR < 0) {
                this.a("\u7f29\u77ed\u653b\u51fb\u65f6\u95f4\uff1a" + -v2.hR, y[2]);
            }
            if (v2.hN > 0) {
                this.a("\u5ef6\u957f\u653b\u51fb\u505c\u987f\uff1a" + v2.hN, y[2]);
            } else if (v2.hN < 0) {
                this.a("\u7f29\u77ed\u653b\u51fb\u505c\u987f\uff1a" + -v2.hN, y[2]);
            }
            if (v2.hY > 0) {
                this.a("\u4ea7\u751f\u7206\u51fb\u51e0\u7387\uff1a" + v2.hY, y[2]);
            }
            if (v2.hO > 0) {
                this.a("\u6bcf\u7b49\u7ea7\u63d0\u5347\u7269\u7406\u653b\u51fb\uff1a" + (float)v2.hO * 1.0f / 10.0f, y[2]);
            }
            if (v2.hZ > 0) {
                this.a("\u6bcf\u70b9\u5f3a\u58ee\u63d0\u5347\u7269\u7406\u653b\u51fb\uff1a" + (float)v2.hZ * 1.0f / 100.0f, y[2]);
            }
            if (v2.hX > 0) {
                this.a("\u6bcf\u70b9\u654f\u6377\u63d0\u5347\u7269\u7406\u653b\u51fb\uff1a" + (float)v2.hX * 1.0f / 100.0f, y[2]);
            }
            if (v2.hM > 0) {
                this.a("\u6bcf\u70b9\u667a\u529b\u63d0\u5347\u7269\u7406\u653b\u51fb\uff1a" + (float)v2.hM * 1.0f / 100.0f, y[2]);
            }
            if (v2.hJ > 0) {
                this.a("\u6bcf\u7b49\u7ea7\u63d0\u5347\u9b54\u6cd5\u653b\u51fb\uff1a" + (float)v2.hJ * 1.0f / 10.0f, y[2]);
            }
            if (v2.h5 > 0) {
                this.a("\u6bcf\u70b9\u5f3a\u58ee\u63d0\u5347\u9b54\u6cd5\u653b\u51fb\uff1a" + (float)v2.h5 * 1.0f / 100.0f, y[2]);
            }
            if (v2.hF > 0) {
                this.a("\u6bcf\u70b9\u654f\u6377\u63d0\u5347\u9b54\u6cd5\u653b\u51fb\uff1a" + (float)v2.hF * 1.0f / 100.0f, y[2]);
            }
            if (v2.hE > 0) {
                this.a("\u6bcf\u70b9\u667a\u529b\u63d0\u5347\u9b54\u6cd5\u653b\u51fb\uff1a" + (float)v2.hE * 1.0f / 100.0f, y[2]);
            }
            if (v2.hU > 0) {
                this.a("\u5957\u88c5\u5c5e\u6027", y[5]);
                n11 = this.w.bA.g(v2.hU);
                n10 = 0;
                do {
                    if (v2.hB[n10] <= 0) continue;
                    if (n11 > n10 + 1) {
                        this.a(C[v2.hB[n10]] + Math.abs(v2.h7[n10]), y[5]);
                        continue;
                    }
                    this.a(C[v2.hB[n10]] + Math.abs(v2.h7[n10]), -65536);
                } while (++n10 < 4);
            }
            n11 = -1;
            if (this.w.p < v2.hP) {
                n11 = -65536;
            }
            this.a("\u7b49\u7ea7\u9700\u6c42\uff1a" + v2.hP, n11);
            n11 = -1;
            if (this.w.af != v2.hH) {
                n11 = -65536;
            }
            n11 = -1;
            if (this.w.ab < v2.h3) {
                n11 = -65536;
            }
            if (this.w.ab < v2.h3) {
                this.a("\u8f6c\u751f\u9650\u5236\uff1a" + v2.h3, 0xFF0000);
            }
            n11 = -1;
            if (v2.hH != this.w.af) {
                n11 = -65536;
            }
            this.a("\u804c\u4e1a\u9650\u5236\uff1a" + d.ap[v2.hH], n11);
            if (v2.fR.length() > 1) {
                this.a(v2.fR, -16711936);
            }
            if (v2.hI.length() > 0) {
                n10 = v2.hI.length();
                int n12 = 0;
                while (n10 > 0) {
                    int n13 = Math.min(n10, 15);
                    String string = v2.hI.substring(n12, n12 + n13);
                    n10 -= n13;
                    n12 += n13;
                    this.a(string, -16711936);
                }
            }
            if (bl) {
                if (!bl2) {
                    this.a("\u5355\u51fb\u9f20\u6807\u53f3\u952e\u88c5\u5907\u6b64\u6b66\u5668", -16711696);
                } else if (bl4) {
                    this.a("\u5355\u51fb\u9f20\u6807\u53f3\u952e\u5378\u4e0b\u6b64\u6b66\u5668", -16711696);
                }
            }
        } else if (j2.fW == 2) {
            int n14;
            e e2 = (e)j2;
            this.for("\u7c7b\u578b\uff1a" + E[e2.gb]);
            this.for("\u7269\u7406\u9632\u5fa1\u529b\uff1a" + e2.gB);
            this.for("\u9b54\u6cd5\u9632\u5fa1\u529b\uff1a" + e2.gp);
            if (e2.f9 > 0) {
                this.a("\u7269\u7406\u9632\u5fa1\u5f3a\u5316\uff1a" + e2.f9, y[2]);
            }
            if (e2.gd > 0) {
                this.a("\u9b54\u6cd5\u9632\u5fa1\u5f3a\u5316\uff1a" + e2.gd, y[2]);
            }
            if (e2.f6 > 0) {
                this.a("\u589e\u52a0\u8eb2\u907f\uff1a" + e2.f6, y[2]);
            }
            if (e2.gC > 0) {
                this.a("\u589e\u52a0\u683c\u6321\u51e0\u7387\uff1a" + e2.gC, y[2]);
            }
            if (e2.gD > 0) {
                this.a("\u63d0\u9ad8\u751f\u547d\u4e0a\u9650\uff1a" + e2.gD, y[2]);
            }
            if (e2.gj > 0) {
                this.a("\u63d0\u9ad8\u9b54\u6cd5\u4e0a\u9650\uff1a" + e2.gj, y[2]);
            }
            if (e2.gn > 0) {
                this.a("\u964d\u4f4e\u79fb\u52a8\u901f\u5ea6\uff1a" + -e2.gn, y[2]);
            } else if (e2.gn < 0) {
                this.a("\u63d0\u9ad8\u79fb\u52a8\u901f\u5ea6\uff1a" + -e2.gn, y[2]);
            }
            if (e2.gk > 0) {
                this.a("\u6bcf\u7b49\u7ea7\u63d0\u5347\u7269\u7406\u9632\u5fa1\uff1a" + (float)e2.gk * 1.0f / 10.0f, y[2]);
            }
            if (e2.gs > 0) {
                this.a("\u6bcf\u70b9\u5f3a\u58ee\u63d0\u5347\u7269\u7406\u9632\u5fa1\uff1a" + (float)e2.gs * 1.0f / 100.0f, y[2]);
            }
            if (e2.gr > 0) {
                this.a("\u6bcf\u70b9\u654f\u6377\u63d0\u5347\u7269\u7406\u9632\u5fa1\uff1a" + (float)e2.gr * 1.0f / 100.0f, y[2]);
            }
            if (e2.gi > 0) {
                this.a("\u6bcf\u70b9\u667a\u529b\u63d0\u5347\u7269\u7406\u9632\u5fa1\uff1a" + (float)e2.gi * 1.0f / 100.0f, y[2]);
            }
            if (e2.ge > 0) {
                this.a("\u6bcf\u7b49\u7ea7\u63d0\u5347\u9b54\u6cd5\u9632\u5fa1\uff1a" + (float)e2.ge * 1.0f / 10.0f, y[2]);
            }
            if (e2.gy > 0) {
                this.a("\u6bcf\u70b9\u5f3a\u58ee\u63d0\u5347\u9b54\u6cd5\u9632\u5fa1\uff1a" + (float)e2.gy * 1.0f / 100.0f, y[2]);
            }
            if (e2.f8 > 0) {
                this.a("\u6bcf\u70b9\u654f\u6377\u63d0\u5347\u9b54\u6cd5\u9632\u5fa1\uff1a" + (float)e2.f8 * 1.0f / 100.0f, y[2]);
            }
            if (e2.f7 > 0) {
                this.a("\u6bcf\u70b9\u667a\u529b\u63d0\u5347\u9b54\u6cd5\u9632\u5fa1\uff1a" + (float)e2.f7 * 1.0f / 100.0f, y[2]);
            }
            if (e2.go > 0) {
                this.a("\u5957\u88c5\u5c5e\u6027", y[5]);
                n14 = this.w.bA.g(e2.go);
                int n15 = 0;
                do {
                    if (e2.f4[n15] <= 0) continue;
                    if (n14 > n15 + 1) {
                        this.a(C[e2.f4[n15]] + Math.abs(e2.gz[n15]), y[5]);
                        continue;
                    }
                    this.a(C[e2.f4[n15]] + Math.abs(e2.gz[n15]), -65536);
                } while (++n15 < 4);
            }
            n14 = -1;
            if (this.w.p < e2.gl) {
                n14 = -65536;
            }
            this.a("\u7b49\u7ea7\u9700\u6c42\uff1a" + e2.gl, n14);
            n14 = -1;
            if (this.w.af != e2.ga) {
                n14 = -65536;
            }
            n14 = -1;
            if (this.w.ab < e2.gu) {
                n14 = -65536;
            }
            if (this.w.ab < e2.gu) {
                this.a("\u8f6c\u751f\u9650\u5236\uff1a" + e2.gu, 0xFF0000);
            }
            n14 = -1;
            if (e2.ga != this.w.af) {
                n14 = -65536;
            }
            this.a("\u804c\u4e1a\u9650\u5236\uff1a" + d.ap[e2.ga], n14);
            if (e2.fR.length() > 1) {
                this.a(e2.fR, -16711936);
            }
            if (bl) {
                if (!bl2) {
                    this.a("\u5355\u51fb\u9f20\u6807\u53f3\u952e\u88c5\u5907\u6b64" + E[e2.gb], -16711696);
                } else if (bl4) {
                    this.a("\u5355\u51fb\u9f20\u6807\u53f3\u952e\u5378\u4e0b\u6b64" + E[e2.gb], -16711696);
                }
            }
        } else if (j2.fW == 3) {
            int n16;
            y y2 = (y)j2;
            this.for("\u7c7b\u578b\uff1a" + I[y2.il]);
            if (y2.iv > 0) {
                this.for("\u7269\u7406\u9632\u5fa1\u529b\uff1a" + y2.iv);
            }
            if (y2.ip > 0) {
                this.for("\u9b54\u6cd5\u9632\u5fa1\u529b\uff1a" + y2.ip);
            }
            if (y2.ir > 0) {
                this.a("\u7269\u7406\u9632\u5fa1\u5f3a\u5316\uff1a" + y2.ir, y[2]);
            }
            if (y2.iB > 0) {
                this.a("\u9b54\u6cd5\u9632\u5fa1\u5f3a\u5316\uff1a" + y2.iB, y[2]);
            }
            if (y2.iK > 0) {
                this.a("\u63d0\u9ad8\u751f\u547d\u4e0a\u9650\uff1a" + y2.iK, y[2]);
            }
            if (y2.io > 0) {
                this.a("\u63d0\u9ad8\u9b54\u6cd5\u4e0a\u9650\uff1a" + y2.io, y[2]);
            }
            if (y2.iI > 0) {
                this.a("\u63d0\u9ad8\u751f\u547d\u6062\u590d\u901f\u5ea6\uff1a" + y2.iI + "%", y[2]);
            }
            if (y2.iC > 0) {
                this.a("\u63d0\u9ad8\u9b54\u6cd5\u6062\u590d\u901f\u5ea6\uff1a" + y2.iC + "%", y[2]);
            }
            if (y2.iL > 0) {
                this.a("\u4ea7\u751f\u66b4\u51fb\u51e0\u7387\uff1a" + y2.iL, y[2]);
            }
            if (y2.is > 0) {
                this.a("\u589e\u52a0\u547d\u4e2d\u529b\uff1a" + y2.is, y[2]);
            }
            if (y2.iz > 0) {
                this.a("\u589e\u52a0\u8eb2\u907f\u529b\uff1a" + y2.iz, y[2]);
            }
            if (y2.ix > 0) {
                this.a("\u5957\u88c5\u5c5e\u6027", y[5]);
                n16 = this.w.bA.g(y2.ix);
                int n17 = 0;
                do {
                    if (y2.iH[n17] <= 0) continue;
                    if (n16 > n17 + 1) {
                        this.a(C[y2.iH[n17]] + Math.abs(y2.iO[n17]), y[5]);
                        continue;
                    }
                    this.a(C[y2.iH[n17]] + Math.abs(y2.iO[n17]), -65536);
                } while (++n17 < 4);
            }
            n16 = -1;
            if (this.w.p < y2.iy) {
                n16 = -65536;
            }
            this.a("\u7b49\u7ea7\u9700\u6c42\uff1a" + y2.iy, n16);
            n16 = -1;
            if (this.w.ab < y2.iq) {
                n16 = -65536;
            }
            if (this.w.ab < y2.iq) {
                this.for("\u8f6c\u751f\u9650\u5236\uff1a" + y2.iq);
            }
            if (y2.fR.length() > 0) {
                this.a(y2.fR, -16711936);
            }
            if (bl) {
                if (!bl2) {
                    this.a("\u5355\u51fb\u9f20\u6807\u53f3\u952e\u88c5\u5907\u6b64" + I[y2.il], -16711696);
                } else if (bl4) {
                    this.a("\u5355\u51fb\u9f20\u6807\u53f3\u952e\u5378\u4e0b\u6b64" + I[y2.il], -16711696);
                }
            }
        } else if (j2.fW == 6) {
            x x2 = (x)j2;
            this.for("\u7c7b\u578b\uff1a" + j.fX[x2.fW]);
            int n18 = -1;
            if (this.w.an != x2.ij) {
                n18 = -65536;
            }
            this.a("\u6027\u522b\uff1a" + d.am[x2.ij], n18);
            if (x2.fI > 0L) {
                this.for("\u8d2d\u4e70\u65f6\u95f4\uff1a" + a.a.b.if(x2.fI));
                int n19 = (int)((long)x2.fY - (System.currentTimeMillis() - x2.fI) / 1000L);
                if (n19 > 0) {
                    this.a("\u5269\u4f59\u65f6\u95f4\uff1a" + this.int(n19), -1);
                } else {
                    this.a("\u65f6\u88c5\u5df2\u8fc7\u671f\uff0c\u5373\u5c06\u6d88\u5931", -65536);
                }
            } else {
                this.a("\u6301\u7eed\u65f6\u95f4\uff1a" + this.int(x2.fY), -1);
            }
            if (x2.fR.length() > 0) {
                this.a(x2.fR, -16711936);
            }
            if (bl) {
                if (!bl2) {
                    this.a("\u5355\u51fb\u9f20\u6807\u53f3\u952e\u88c5\u5907\u6b64\u65f6\u88c5", -16711696);
                } else if (bl4) {
                    this.a("\u5355\u51fb\u9f20\u6807\u53f3\u952e\u5378\u4e0b\u6b64\u65f6\u88c5", -16711696);
                }
            }
        } else if (j2.fW == 7) {
            b.a.e.d d2 = (b.a.e.d)j2;
            this.for("\u7c7b\u578b\uff1a" + j.fX[j2.fW]);
            this.for("\u6301\u7eed\u65f6\u95f4\uff1a" + d2.f1 + "\u79d2");
            this.for("\u4f18\u5148\u5ea6\uff1a" + d2.f0);
            this.a("\u663e\u793a\u8303\u56f4\uff1a" + B[d2.f2], -16711936);
            this.a("\u70b9\u9f20\u6807\u53f3\u952e\u6253\u5f00\u793c\u54c1\u804a\u5929\u754c\u9762", -16711696);
            if (d2.fR.length() > 0) {
                this.a(d2.fR, -16711936);
            }
        }
        if (j2.fO == 0) {
            this.a("\u8be5\u7269\u54c1\u4e0d\u53ef\u88ab\u4e22\u5f03", -65536);
        }
        if (j2.fL == 0) {
            this.a("\u8be5\u7269\u54c1\u4e0d\u53ef\u88ab\u51fa\u552e", -65536);
        }
        if (j2.fV == 0) {
            this.a("\u8be5\u7269\u54c1\u4e0d\u53ef\u88ab\u4ea4\u6613", -65536);
        }
        if (j2.fF == 0) {
            this.a("\u8be5\u7269\u54c1\u4e0d\u53ef\u5b58\u4ed3\u5e93", -65536);
        }
        if (bl) {
            this.a("\u70b9\u9f20\u6807\u5de6\u952e\u677e\u5f00\u540e\u53ef\u79fb\u52a8\u6b64\u7269\u54c1", -16711696);
        }
        if (bl3) {
            this.a("\u80cc\u5305\u5269\u4f59\u6570\u91cf\uff1a" + this.w.bA.d(j2.if), -16711696);
            this.a("\u70b9\u9f20\u6807\u53f3\u952e\u6216\u76f8\u5e94\u6570\u5b57\u952e\u4f7f\u7528\u6b64\u7269\u54c1", -16711696);
        }
        if (n2 > 0) {
            this.a("\u5355\u51fb\u9f20\u6807\u53f3\u952e\u8d2d\u4e70\u6b64\u7269\u54c1", -16711696);
        }
    }

    public int a() {
        return this.u;
    }

    public void a(k k2) {
        this.w = k2;
    }

    public static final at b() {
        return G;
    }
}

