/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs;

import app.island.GameObject;
import app.island.data.Book;
import app.island.data.Decoration;
import app.island.data.Equipment;
import app.island.data.FightState;
import app.island.data.Goods;
import app.island.data.GoodsFormula;
import app.island.data.Medicine;
import app.island.data.SpecialProperty;
import app.island.data.Spell;
import app.island.data.Task;
import app.island.data.Weapon;
import app.island.entity.Monster;
import app.island.gs.data.BetData;
import app.island.gs.data.BoxPlunder;
import app.island.gs.data.IncreaseConfig;
import app.island.gs.data.MonsterAIData;
import app.island.gs.data.NpcAIData;
import app.island.gs.data.PlunderData;
import app.island.gs.data.RefineConfig;
import daff.a.b;
import daff.a.h;
import java.io.File;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class w
implements Goods.GoodsFetcher {
    private static w h = new w();
    private h byte = new h(40000);
    private h try = new h(500);
    private h c = new h(100);
    private h f = new h(100);
    private h char = new h(100);
    private h do = new h(100);
    private h if = new h(500);
    private h[] for = new h[6];
    private h[] d = new h[6];
    private h[] else = new h[6];
    private h new = new h(50);
    private h long = new h(400);
    private h j = new h(400);
    private h e = new h(500);
    private h b = new h(50);
    private h void = new h(100);
    private h int = new h(200);
    private h a = new h(100);
    private h goto = new h(200);
    private h k = new h(200);
    private h case = new h(200);
    private h l = new h(100);
    private h i = new h(100);
    private Goods[] g;
    private static /* synthetic */ Class class$app$island$data$DamageSpell;
    private static /* synthetic */ Class class$app$island$data$SceneEffectSpell;
    private static /* synthetic */ Class class$app$island$data$TargetStateSpell;
    private static /* synthetic */ Class class$app$island$gs$data$PlunderData;
    private static /* synthetic */ Class class$app$island$data$Task;
    private static /* synthetic */ Class class$app$island$gs$data$BetData;
    private static /* synthetic */ Class class$app$island$gs$data$ActivityItem;
    private static /* synthetic */ Class class$app$island$data$GoodsFormula;
    private static /* synthetic */ Class class$app$island$gs$data$IncreaseConfig;
    private static /* synthetic */ Class class$app$island$gs$data$RefineConfig;
    private static /* synthetic */ Class class$app$island$entity$Monster;
    private static /* synthetic */ Class class$app$island$gs$data$BoxPlunder;
    private static /* synthetic */ Class class$app$island$data$FightState;
    private static /* synthetic */ Class class$app$island$gs$data$MonsterAIData;
    private static /* synthetic */ Class class$app$island$gs$data$NpcAIData;
    private static /* synthetic */ Class class$app$island$data$Equipment;
    private static /* synthetic */ Class class$app$island$data$Weapon;
    private static /* synthetic */ Class class$app$island$data$Decoration;
    private static /* synthetic */ Class class$app$island$data$SpecialProperty;
    private static /* synthetic */ Class class$app$island$data$Medicine;
    private static /* synthetic */ Class class$app$island$data$Book;
    private static /* synthetic */ Class class$app$island$data$Fashion;
    private static /* synthetic */ Class class$app$island$data$ChatGift;
    private static /* synthetic */ Class class$app$island$data$Material;

    private GameObject a(int n2, h h2) {
        int n3 = h2.for();
        int n4 = 0;
        while (n4 < n3) {
            GameObject gameObject = (GameObject)h2.if(n4);
            if (gameObject.id == n2) {
                return gameObject;
            }
            ++n4;
        }
        return null;
    }

    public Monster for(int n2) {
        return (Monster)this.a(n2, this.if);
    }

    public BoxPlunder else(int n2) {
        return (BoxPlunder)this.a(n2, this.a);
    }

    public Task long(int n2) {
        return (Task)this.a(n2, this.e);
    }

    public FightState b(int n2) {
        return (FightState)this.a(n2, this.j);
    }

    public IncreaseConfig for(int n2, int n3, int n4) {
        int n5 = this.k.for();
        int n6 = 0;
        while (n6 < n5) {
            IncreaseConfig increaseConfig = (IncreaseConfig)this.k.if(n6);
            if (increaseConfig.eType == n2 && increaseConfig.requiredLevel == n3 && increaseConfig.increaseLevel == n4) {
                return increaseConfig;
            }
            ++n6;
        }
        return null;
    }

    public void a() {
        this.long.a();
        w.a("config/data/damage_spells.txt", class$app$island$data$DamageSpell != null ? class$app$island$data$DamageSpell : (class$app$island$data$DamageSpell = w.class$("app.island.data.DamageSpell")), this.long);
        w.a("config/data/effect_spells.txt", class$app$island$data$SceneEffectSpell != null ? class$app$island$data$SceneEffectSpell : (class$app$island$data$SceneEffectSpell = w.class$("app.island.data.SceneEffectSpell")), this.long);
        w.a("config/data/state_spells.txt", class$app$island$data$TargetStateSpell != null ? class$app$island$data$TargetStateSpell : (class$app$island$data$TargetStateSpell = w.class$("app.island.data.TargetStateSpell")), this.long);
        Spell.setGlobalSpellList(this.long);
    }

    public Spell if(int n2) {
        return (Spell)this.a(n2, this.long);
    }

    public NpcAIData int(int n2) {
        return (NpcAIData)this.a(n2, this.f);
    }

    public GoodsFormula a(Goods[] goodsArray) {
        int n2 = this.goto.for();
        int n3 = 0;
        while (n3 < n2) {
            GoodsFormula goodsFormula = (GoodsFormula)this.goto.if(n3);
            if (goodsFormula.testMaterials(goodsArray)) {
                return goodsFormula;
            }
            ++n3;
        }
        return null;
    }

    public GoodsFormula new(int n2) {
        int n3 = this.goto.for();
        int n4 = 0;
        while (n4 < n3) {
            GoodsFormula goodsFormula = (GoodsFormula)this.goto.if(n4);
            if (goodsFormula.id == n2) {
                return goodsFormula;
            }
            ++n4;
        }
        return null;
    }

    public Medicine case(int n2) {
        return (Medicine)this.a(n2, this.char);
    }

    public Goods void(int n2) {
        if (n2 < 20) {
            if (Math.random() < (double)0.6f) {
                return this.case(1313000100);
            }
            return this.case(1313001100);
        }
        if (n2 < 40) {
            if (Math.random() < (double)0.6f) {
                return this.case(1313000200);
            }
            return this.case(1313001200);
        }
        if (n2 < 70) {
            if (Math.random() < (double)0.6f) {
                return this.case(1313000300);
            }
            return this.case(1313001300);
        }
        if (Math.random() < (double)0.6f) {
            return this.case(1313000400);
        }
        return this.case(1313001400);
    }

    public SpecialProperty do(int n2) {
        return (SpecialProperty)this.a(n2, this.do);
    }

    public Goods a(int n2, int n3, int n4) {
        int n5 = (int)(Math.random() * 3.0);
        h h2 = this.d[n4];
        int n6 = h2.for();
        int n7 = 0;
        while (n7 < n6) {
            Weapon weapon = (Weapon)h2.if(n7);
            if (weapon.id % 100 == 0 && weapon.requiredRace == n5 && weapon.requiredLevel >= n2 && weapon.requiredLevel <= n3) {
                return weapon;
            }
            ++n7;
        }
        return null;
    }

    public void int() {
        byte[] byArray = daff.a.b.new("config/data/gifts.txt");
        if (byArray == null) {
            return;
        }
        String string = new String(byArray);
        String[] stringArray = daff.a.b.a(string, "\r\n");
        h h2 = new h(stringArray.length);
        int n2 = 0;
        while (n2 < stringArray.length) {
            int n3;
            Goods goods;
            if (stringArray[n2].length() >= 5 && !stringArray[n2].startsWith("#") && (goods = this.getGoods(n3 = Integer.parseInt(stringArray[n2]))) != null) {
                h2.if(goods);
            }
            ++n2;
        }
        this.g = new Goods[h2.for()];
        h2.a(this.g);
    }

    public Goods getGoods(int n2) {
        int n3 = n2 / 10000000;
        switch (n3) {
            case 131: {
                return this.case(n2);
            }
            case 132: {
                return this.try(n2);
            }
            case 133: {
                return this.do(n2);
            }
            case 143: {
                return (Goods)this.a(n2, this.int);
            }
        }
        if ((n3 /= 10) == 11) {
            int n4 = n2 / 10000 % 100;
            if (n4 >= this.for.length) {
                return null;
            }
            return (Goods)this.a(n2, this.for[n4]);
        }
        if (n3 == 12) {
            int n5 = n2 / 10000 % 100;
            if (n5 >= this.d.length) {
                return null;
            }
            return (Goods)this.a(n2, this.d[n5]);
        }
        if (n3 == 16) {
            Goods goods = this.do(n2);
            if (goods == null) {
                goods = (Goods)this.a(n2, this.void);
            }
            return goods;
        }
        if (n3 == 17 || n3 == 18) {
            int n6 = n2 / 10000 % 100;
            if (n6 >= this.else.length) {
                return null;
            }
            return (Goods)this.a(n2, this.else[n6]);
        }
        if (n3 == 19) {
            return (Goods)this.a(n2, this.b);
        }
        return (Goods)this.a(n2, this.byte);
    }

    public RefineConfig a(int n2, int n3) {
        int n4 = this.case.for();
        int n5 = 0;
        while (n5 < n4) {
            RefineConfig refineConfig = (RefineConfig)this.case.if(n5);
            if (refineConfig.requiredLevel == n2 && refineConfig.quality == n3) {
                return refineConfig;
            }
            ++n5;
        }
        return null;
    }

    public void do() {
        this.try.a();
        w.a("config/data/plunders.txt", class$app$island$gs$data$PlunderData != null ? class$app$island$gs$data$PlunderData : (class$app$island$gs$data$PlunderData = w.class$("app.island.gs.data.PlunderData")), this.try);
    }

    public void try() {
        this.e.a();
        w.a("config/data/tasks.txt", class$app$island$data$Task != null ? class$app$island$data$Task : (class$app$island$data$Task = w.class$("app.island.data.Task")), this.e);
        Task.setGlobalTaskList(this.e);
    }

    public Goods do(int n2, int n3, int n4) {
        int n5 = (int)(Math.random() * 3.0) + 1;
        h h2 = this.else[n4];
        int n6 = h2.for();
        int n7 = 0;
        while (n7 < n6) {
            Decoration decoration = (Decoration)h2.if(n7);
            if (decoration.id % 100 == 0 && decoration.dType == n5 && decoration.requiredLevel >= n2 && decoration.requiredLevel <= n3) {
                return decoration;
            }
            ++n7;
        }
        return null;
    }

    public Goods if(int n2, int n3, int n4, int n5) {
        h h2 = this.d[n5];
        int n6 = h2.for();
        int n7 = 0;
        while (n7 < n6) {
            Weapon weapon = (Weapon)h2.if(n7);
            if (weapon.name.indexOf("\u8d85\u7ea7") < 0 && weapon.id % 100 == 0 && weapon.requiredRace == n2 && weapon.requiredLevel >= n3 && weapon.requiredLevel <= n4) {
                return weapon;
            }
            ++n7;
        }
        return null;
    }

    public Book try(int n2) {
        return (Book)this.a(n2, this.new);
    }

    public void new() {
        this.long();
        this.a();
        this.else();
        this.try();
        this.if();
        this.for();
        this.do();
        this.goto();
        this.int();
        w.a("config/data/bets.txt", class$app$island$gs$data$BetData != null ? class$app$island$gs$data$BetData : (class$app$island$gs$data$BetData = w.class$("app.island.gs.data.BetData")), this.l);
        w.a("config/data/huodong.txt", class$app$island$gs$data$ActivityItem != null ? class$app$island$gs$data$ActivityItem : (class$app$island$gs$data$ActivityItem = w.class$("app.island.gs.data.ActivityItem")), this.i);
        w.a("config/data/formula/equipment_mix.txt", class$app$island$data$GoodsFormula != null ? class$app$island$data$GoodsFormula : (class$app$island$data$GoodsFormula = w.class$("app.island.data.GoodsFormula")), this.goto);
        w.a("config/data/increases.txt", class$app$island$gs$data$IncreaseConfig != null ? class$app$island$gs$data$IncreaseConfig : (class$app$island$gs$data$IncreaseConfig = w.class$("app.island.gs.data.IncreaseConfig")), this.k);
        w.a("config/data/refines.txt", class$app$island$gs$data$RefineConfig != null ? class$app$island$gs$data$RefineConfig : (class$app$island$gs$data$RefineConfig = w.class$("app.island.gs.data.RefineConfig")), this.case);
    }

    private w() {
        int n2 = 0;
        while (n2 < this.for.length) {
            this.for[n2] = new h(5000);
            this.d[n2] = new h(6000);
            this.else[n2] = new h(1000);
            ++n2;
        }
    }

    public void if() {
        this.if.a();
        w.a("config/data/monsters.txt", class$app$island$entity$Monster != null ? class$app$island$entity$Monster : (class$app$island$entity$Monster = w.class$("app.island.entity.Monster")), this.if);
    }

    public void goto() {
        this.a.a();
        w.a("config/data/box_drops.txt", class$app$island$gs$data$BoxPlunder != null ? class$app$island$gs$data$BoxPlunder : (class$app$island$gs$data$BoxPlunder = w.class$("app.island.gs.data.BoxPlunder")), this.a);
    }

    public void else() {
        this.j.a();
        w.a("config/data/states.txt", class$app$island$data$FightState != null ? class$app$island$data$FightState : (class$app$island$data$FightState = w.class$("app.island.data.FightState")), this.j);
    }

    public Goods byte(int n2) {
        if (n2 < 10) {
            return null;
        }
        if (n2 < 100 || Math.random() < (double)0.7f) {
            int n3 = (int)(Math.random() * (double)this.g.length);
            return this.g[n3];
        }
        int n4 = 1330010001 + (int)(Math.random() * 154.0);
        return this.getGoods(n4);
    }

    public MonsterAIData goto(int n2) {
        return (MonsterAIData)this.a(n2, this.c);
    }

    public h char() {
        return this.i;
    }

    public void for() {
        this.c.a();
        w.a("config/data/monster_ai.txt", class$app$island$gs$data$MonsterAIData != null ? class$app$island$gs$data$MonsterAIData : (class$app$island$gs$data$MonsterAIData = w.class$("app.island.gs.data.MonsterAIData")), this.c);
        this.f.a();
        w.a("config/data/npc_ai.txt", class$app$island$gs$data$NpcAIData != null ? class$app$island$gs$data$NpcAIData : (class$app$island$gs$data$NpcAIData = w.class$("app.island.gs.data.NpcAIData")), this.f);
    }

    public void long() {
        Goods goods;
        h h2 = new h(20000);
        File file = new File("config/data/equipments");
        String[] stringArray = file.list();
        int n2 = 0;
        while (n2 < stringArray.length) {
            if (stringArray[n2].endsWith(".txt")) {
                new File(file, stringArray[n2]);
                w.a("config/data/equipments/" + stringArray[n2], class$app$island$data$Equipment != null ? class$app$island$data$Equipment : w.class$("app.island.data.Equipment"), h2);
            }
            ++n2;
        }
        h h3 = new h(10000);
        file = new File("config/data/weapons");
        stringArray = file.list();
        int n3 = 0;
        while (n3 < stringArray.length) {
            if (stringArray[n3].endsWith(".txt")) {
                new File(file, stringArray[n3]);
                w.a("config/data/weapons/" + stringArray[n3], class$app$island$data$Weapon != null ? class$app$island$data$Weapon : w.class$("app.island.data.Weapon"), h3);
            }
            ++n3;
        }
        h h4 = new h(2000);
        file = new File("config/data/jewels");
        stringArray = file.list();
        int n4 = 0;
        while (n4 < stringArray.length) {
            if (stringArray[n4].endsWith(".txt")) {
                new File(file, stringArray[n4]);
                w.a("config/data/jewels/" + stringArray[n4], class$app$island$data$Decoration != null ? class$app$island$data$Decoration : w.class$("app.island.data.Decoration"), h4);
            }
            ++n4;
        }
        this.do.a();
        file = new File("config/data/specials");
        stringArray = file.list();
        n4 = 0;
        while (n4 < stringArray.length) {
            if (stringArray[n4].endsWith(".txt")) {
                new File(file, stringArray[n4]);
                w.a("config/data/specials/" + stringArray[n4], class$app$island$data$SpecialProperty != null ? class$app$island$data$SpecialProperty : w.class$("app.island.data.SpecialProperty"), this.do);
            }
            ++n4;
        }
        this.char.a();
        w.a("config/data/medicine.txt", class$app$island$data$Medicine != null ? class$app$island$data$Medicine : (class$app$island$data$Medicine = w.class$("app.island.data.Medicine")), this.char);
        this.new.a();
        w.a("config/data/books.txt", class$app$island$data$Book != null ? class$app$island$data$Book : (class$app$island$data$Book = w.class$("app.island.data.Book")), this.new);
        this.b.a();
        w.a("config/data/fashions.txt", class$app$island$data$Fashion != null ? class$app$island$data$Fashion : (class$app$island$data$Fashion = w.class$("app.island.data.Fashion")), this.b);
        this.void.a();
        w.a("config/data/chatgifts.txt", class$app$island$data$ChatGift != null ? class$app$island$data$ChatGift : (class$app$island$data$ChatGift = w.class$("app.island.data.ChatGift")), this.void);
        this.int.a();
        w.a("config/data/materials.txt", class$app$island$data$Material != null ? class$app$island$data$Material : (class$app$island$data$Material = w.class$("app.island.data.Material")), this.int);
        this.byte.a();
        this.byte.for(h2);
        this.byte.for(h3);
        this.byte.for(h4);
        this.byte.for(this.char);
        this.byte.for(this.do);
        this.byte.for(this.new);
        this.byte.for(this.b);
        this.byte.for(this.void);
        this.byte.for(this.int);
        Goods.setGoodsFetcher(this);
        n4 = h3.for();
        int n5 = 0;
        while (n5 < n4) {
            goods = (Weapon)h3.if(n5);
            this.d[goods.quality].if(goods);
            ++n5;
        }
        n4 = h2.for();
        n5 = 0;
        while (n5 < n4) {
            goods = (Equipment)h2.if(n5);
            this.for[goods.quality].if(goods);
            ++n5;
        }
        n4 = h4.for();
        n5 = 0;
        while (n5 < n4) {
            goods = (Decoration)h4.if(n5);
            this.else[goods.quality].if(goods);
            ++n5;
        }
    }

    private static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError(classNotFoundException.getMessage());
        }
    }

    public static final void a(String string, Class clazz, h h2) {
        System.out.println("loading:" + string);
        byte[] byArray = daff.a.b.new(string);
        if (byArray == null) {
            return;
        }
        String string2 = new String(byArray);
        String[] stringArray = daff.a.b.a(string2, "\r\n");
        String[] stringArray2 = daff.a.b.a(stringArray[1], "\t");
        int n2 = 2;
        while (n2 < stringArray.length) {
            if (stringArray[n2].length() < 1) break;
            String[] stringArray3 = daff.a.b.a(stringArray[n2], "\t");
            GameObject gameObject = null;
            try {
                gameObject = (GameObject)clazz.newInstance();
            }
            catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }
            catch (InstantiationException instantiationException) {
                instantiationException.printStackTrace();
            }
            if (gameObject == null) break;
            int n3 = 0;
            while (n3 < stringArray3.length) {
                if (stringArray3[n3].length() > 0) {
                    gameObject.setAttributeValue(stringArray2[n3], stringArray3[n3]);
                }
                ++n3;
            }
            h2.if(gameObject);
            ++n2;
        }
    }

    public Goods a(int n2, int n3, int n4, int n5) {
        int n6 = 0;
        n6 = n2 == 2 ? (int)(4.0 * Math.random()) + 1 : (int)(3.0 * Math.random()) + 1;
        h h2 = this.for[n5];
        int n7 = h2.for();
        int n8 = 0;
        while (n8 < n7) {
            Equipment equipment = (Equipment)h2.if(n8);
            if (equipment.name.indexOf("\u8d85\u7ea7") < 0 && equipment.id % 100 == 0 && equipment.requiredRace == n2 && equipment.eType == n6 && equipment.requiredLevel >= n3 && equipment.requiredLevel <= n4) {
                return equipment;
            }
            ++n8;
        }
        return null;
    }

    public BetData byte() {
        int n2 = (int)(Math.random() * (double)this.l.for());
        return (BetData)this.l.if(n2);
    }

    public PlunderData char(int n2) {
        return (PlunderData)this.a(n2, this.try);
    }

    public Goods a(int n2) {
        Goods goods = this.getGoods(n2);
        if (goods != null) {
            return (Goods)GameObject.cloneObject(goods);
        }
        return null;
    }

    public Goods if(int n2, int n3, int n4) {
        int n5 = (int)(Math.random() * 3.0);
        int n6 = 0;
        n6 = n5 == 2 ? (int)(4.0 * Math.random()) + 1 : (int)(3.0 * Math.random()) + 1;
        h h2 = this.for[n4];
        int n7 = h2.for();
        int n8 = 0;
        while (n8 < n7) {
            Equipment equipment = (Equipment)h2.if(n8);
            if (equipment.id % 100 == 0 && equipment.requiredRace == n5 && equipment.eType == n6 && equipment.requiredLevel >= n2 && equipment.requiredLevel <= n3) {
                return equipment;
            }
            ++n8;
        }
        return null;
    }

    public static final w case() {
        return h;
    }
}

