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

    public BlockInfo(int n2, int n3) {
        this.if = new byte[n3][n2];
        int n4 = 0;
        while (n4 < n3) {
            int n5 = 0;
            while (n5 < n2) {
                this.if[n4][n5] = 127;
                ++n5;
            }
            ++n4;
        }
    }

    public int getBlockType(int n2, int n3) {
        if (n3 < this.if.length && n3 >= 0 && n2 >= 0 && n2 < this.if[n3].length) {
            return this.if[n3][n2];
        }
        return 0;
    }

    public void setBlockType(int n2, int n3, int n4) {
        if (n3 < this.if.length && n3 >= 0 && n2 >= 0 && n2 < this.if[n3].length) {
            this.if[n3][n2] = (byte)n4;
        }
    }

    public void load(e e2) {
        int n2 = e2.j();
        int n3 = e2.j();
        this.if = new byte[n3][n2];
        int n4 = 0;
        while (n4 < n3) {
            int n5 = 0;
            while (n5 < n2) {
                this.if[n4][n5] = (byte)e2.case();
                ++n5;
            }
            ++n4;
        }
    }

    public BlockInfo copy() {
        BlockInfo blockInfo = new BlockInfo();
        blockInfo.a = this.a;
        blockInfo.do = this.do;
        blockInfo.if = new byte[this.if.length][this.if[0].length];
        int n2 = 0;
        while (n2 < this.if.length) {
            int n3 = 0;
            while (n3 < this.if[n2].length) {
                blockInfo.if[n2][n3] = this.if[n2][n3];
                ++n3;
            }
            ++n2;
        }
        return blockInfo;
    }

    public int getUnitWidth() {
        return this.a;
    }

    public boolean isFlyable(int n2, int n3) {
        return (this.getBlockType(n2, n3) & 2) != 0;
    }

    public void save(e e2) {
        e2.for(this.if[0].length);
        e2.for(this.if.length);
        int n2 = 0;
        while (n2 < this.if.length) {
            int n3 = 0;
            while (n3 < this.if[n2].length) {
                e2.a(this.if[n2][n3]);
                ++n3;
            }
            ++n2;
        }
    }

    public int getUnitHeight() {
        return this.do;
    }

    public void setUnitSize(int n2, int n3) {
        this.a = n2;
        this.do = n3;
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

    public boolean isWalkable(int n2, int n3) {
        return (this.getBlockType(n2, n3) & 1) != 0;
    }
}

