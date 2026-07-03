/*
 * Decompiled with CFR 0.152.
 */
package app.island.entity;

import daff.a.e;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class BlockInfo {
    private byte[][] if;
    private int a = 40;
    private int do = 30;

    public BlockInfo() {
    }

    public BlockInfo(int n, int n2) {
        this.if = new byte[n2][n];
        int n3 = 0;
        while (n3 < n2) {
            int n4 = 0;
            while (n4 < n) {
                this.if[n3][n4] = 127;
                ++n4;
            }
            ++n3;
        }
    }

    public int getBlockType(int n, int n2) {
        if (n2 < this.if.length && n2 >= 0 && n >= 0 && n < this.if[n2].length) {
            return this.if[n2][n];
        }
        return 0;
    }

    public void setBlockType(int n, int n2, int n3) {
        if (n2 < this.if.length && n2 >= 0 && n >= 0 && n < this.if[n2].length) {
            this.if[n2][n] = (byte)n3;
        }
    }

    public void load(e e2) {
        int n = e2.j();
        int n2 = e2.j();
        this.if = new byte[n2][n];
        int n3 = 0;
        while (n3 < n2) {
            int n4 = 0;
            while (n4 < n) {
                this.if[n3][n4] = (byte)e2.case();
                ++n4;
            }
            ++n3;
        }
    }

    public BlockInfo copy() {
        BlockInfo blockInfo = new BlockInfo();
        blockInfo.a = this.a;
        blockInfo.do = this.do;
        blockInfo.if = new byte[this.if.length][this.if[0].length];
        int n = 0;
        while (n < this.if.length) {
            int n2 = 0;
            while (n2 < this.if[n].length) {
                blockInfo.if[n][n2] = this.if[n][n2];
                ++n2;
            }
            ++n;
        }
        return blockInfo;
    }

    public int getUnitWidth() {
        return this.a;
    }

    public boolean isFlyable(int n, int n2) {
        return (this.getBlockType(n, n2) & 2) != 0;
    }

    public void save(e e2) {
        e2.for(this.if[0].length);
        e2.for(this.if.length);
        int n = 0;
        while (n < this.if.length) {
            int n2 = 0;
            while (n2 < this.if[n].length) {
                e2.a(this.if[n][n2]);
                ++n2;
            }
            ++n;
        }
    }

    public int getUnitHeight() {
        return this.do;
    }

    public void setUnitSize(int n, int n2) {
        this.a = n;
        this.do = n2;
    }

    public int getHeight() {
        return this.if.length;
    }

    public int getWidth() {
        return this.if[0].length;
    }

    public byte[][] getBlockTable() {
        return this.if;
    }

    public boolean isWalkable(int n, int n2) {
        return (this.getBlockType(n, n2) & 1) != 0;
    }
}
