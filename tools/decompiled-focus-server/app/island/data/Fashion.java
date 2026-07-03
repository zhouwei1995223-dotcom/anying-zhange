/*
 * Decompiled with CFR 0.152.
 */
package app.island.data;

import app.island.GameObject;
import app.island.data.Goods;
import app.island.entity.Hero;
import daff.a.b;
import daff.a.e;

public class Fashion
extends Goods {
    public int suit;
    public int sex;
    public int haloIndex;

    public Fashion() {
        this.quality = 6;
        this.goodsType = 6;
    }

    @Override
    public void readFrom(e e2) {
        super.readFrom(e2);
        this.suit = Fashion.readUnsignedByte(e2);
        this.sex = Fashion.readByte(e2);
        this.haloIndex = 0;
        int n2 = e2.i();
        if (n2 > 0) {
            this.createdTime = b.a(n2).getTime();
        }
        this.lifeTime = e2.i();
        this.description = e2.h();
    }

    @Override
    public void writeTo(e e2) {
        super.writeTo(e2);
        e2.a(this.suit);
        e2.a(this.sex);
        if (this.createdTime > 0L) {
            Fashion.writeInt(e2, Fashion.toGameTime(this.createdTime));
        } else {
            Fashion.writeInt(e2, 0);
        }
        Fashion.writeInt(e2, this.lifeTime);
        e2.a(this.description);
    }

    @Override
    public void copyFrom(GameObject gameObject) {
        super.copyFrom(gameObject);
        Fashion fashion = (Fashion)gameObject;
        this.suit = fashion.suit;
        this.sex = fashion.sex;
        this.haloIndex = fashion.haloIndex;
    }

    @Override
    public void parseExtrInfo(String string) {
        int n2 = Integer.parseInt(string);
        this.createdTime = b.a(n2).getTime();
    }

    @Override
    public String getExtraInfo() {
        int n2 = Fashion.toGameTime(this.createdTime);
        return String.valueOf(n2);
    }

    public static int resolveSuit(Hero hero) {
        if (hero.personalDepot == null) {
            return 0;
        }
        Fashion fashion = hero.personalDepot.fashion;
        if (fashion != null && fashion.suit > 0) {
            return fashion.suit;
        }
        if (hero.personalDepot.armor != null) {
            return hero.personalDepot.armor.appearance;
        }
        return 0;
    }

    public static int resolveHalo(Hero hero) {
        if (hero.personalDepot == null) {
            return 0;
        }
        int n2 = hero.personalDepot.getHaloIndex();
        Fashion fashion = hero.personalDepot.fashion;
        if (fashion != null && fashion.haloIndex > n2) {
            n2 = fashion.haloIndex;
        }
        return n2;
    }

    private static int readUnsignedByte(e e2) {
        try {
            Object object = e.class.getMethod("for", new Class[0]).invoke(e2, new Object[0]);
            return (Integer)object;
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    private static int readByte(e e2) {
        try {
            Object object = e.class.getMethod("case", new Class[0]).invoke(e2, new Object[0]);
            return (Integer)object;
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    private static void writeInt(e e2, int n2) {
        try {
            e.class.getMethod("char", Integer.TYPE).invoke(e2, new Integer(n2));
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    private static int toGameTime(long l2) {
        try {
            Object object = Class.forName("daff.a.b").getMethod("if", Long.TYPE).invoke(null, new Long(l2));
            return (Integer)object;
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}

