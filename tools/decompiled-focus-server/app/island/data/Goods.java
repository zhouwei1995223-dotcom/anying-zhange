/*
 * Decompiled with CFR 0.152.
 */
package app.island.data;

import app.island.GameObject;
import app.island.data.Book;
import app.island.data.ChatGift;
import app.island.data.Decoration;
import app.island.data.Equipment;
import app.island.data.Fashion;
import app.island.data.Material;
import app.island.data.Medicine;
import app.island.data.SpecialProperty;
import app.island.data.Weapon;
import daff.a.e;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class Goods
extends GameObject {
    private static GoodsFetcher long;
    public static final String[] GOODS_TYPE_NAMES;
    public static final int GOODS_TYPE_MEDICINE = 0;
    public static final int GOODS_TYPE_WEAPON = 1;
    public static final int GOODS_TYPE_EQUIPMENT = 2;
    public static final int GOODS_TYPE_DECORATION = 3;
    public static final int GOODS_TYPE_BOOK = 4;
    public static final int GOODS_TYPE_SPECIAL = 5;
    public static final int GOODS_TYPE_FASHION = 6;
    public static final int GOODS_TYPE_CHATGIFT = 7;
    public static final int GOODS_TYPE_MATERIAL = 8;
    public int quality;
    public int goodsType;
    public int icon;
    public int moneyCost;
    public int treasureCost;
    public int dropable = 1;
    public int soldable = 1;
    public int tradable = 1;
    public int storable = 1;
    public String description = "";
    public long createdTime;
    public int lifeTime;

    public static void setGoodsFetcher(GoodsFetcher goodsFetcher) {
        long = goodsFetcher;
    }

    public void readFrom(e e2) {
        super.readFrom(e2);
        this.quality = e2.for();
        this.icon = e2.for();
        this.moneyCost = e2.i();
        this.treasureCost = e2.i();
        int n2 = e2.case();
        this.dropable = n2 & 1;
        this.soldable = n2 >> 1 & 1;
        this.tradable = n2 >> 2 & 1;
        this.storable = n2 >> 3 & 1;
    }

    public void writeTo(e e2) {
        super.writeTo(e2);
        e2.a(this.quality);
        e2.a(this.icon);
        e2.char(this.moneyCost);
        e2.char(this.treasureCost);
        e2.a(this.dropable | this.soldable << 1 | this.tradable << 2 | this.storable << 3);
    }

    public String toString() {
        return "Goods[id=" + this.id + ";name=" + this.name + "]";
    }

    public static final Goods createGoodsByType(int n2) {
        switch (n2) {
            case 0: {
                return new Medicine();
            }
            case 1: {
                return new Weapon();
            }
            case 2: {
                return new Equipment();
            }
            case 3: {
                return new Decoration();
            }
            case 4: {
                return new Book();
            }
            case 5: {
                return new SpecialProperty();
            }
            case 6: {
                return new Fashion();
            }
            case 7: {
                return new ChatGift();
            }
            case 8: {
                return new Material();
            }
        }
        return null;
    }

    public void copyFrom(GameObject gameObject) {
        super.copyFrom(gameObject);
        Goods goods = (Goods)gameObject;
        this.quality = goods.quality;
        this.icon = goods.icon;
        this.moneyCost = goods.moneyCost;
        this.treasureCost = goods.treasureCost;
        this.dropable = goods.dropable;
        this.soldable = goods.soldable;
        this.tradable = goods.tradable;
        this.storable = goods.storable;
        this.description = goods.description;
        this.createdTime = 0L;
        this.lifeTime = goods.lifeTime;
    }

    public static final Goods getGlobalGoods(int n2) {
        if (long != null) {
            return long.getGoods(n2);
        }
        return null;
    }

    static {
        GOODS_TYPE_NAMES = new String[]{"\u836f\u54c1", "\u6b66\u5668", "\u9632\u5177", "\u9970\u54c1", "\u6280\u80fd\u4e66", "\u7279\u6b8a\u9053\u5177", "\u65f6\u88c5", "\u804a\u5929\u9053\u5177"};
    }

    public void parseExtrInfo(String string) {
    }

    public String getExtraInfo() {
        return "";
    }

    public static interface GoodsFetcher {
        public Goods getGoods(int var1);
    }
}

