/*
 * Decompiled with CFR 0.152.
 */
package app.island.entity;

import app.island.entity.Guild;
import app.island.entity.Sprite;
import daff.a.e;

public class Player
extends Sprite {
    public static final String[] RACE_NAMES = new String[]{"\u5f13\u7bad\u624b", "\u6cd5\u5e08", "\u6218\u58eb"};
    public static final String[] SEX_NAMES = new String[]{"\u7537", "\u5973"};
    public int race;
    public int sex;
    public int turns;
    public int gmGrade;
    public int sceneID = 1;
    public transient String sceneName = "";
    public transient boolean visible = true;
    public transient int suit;
    public transient int halo;
    public transient String guildName = "";
    public transient int guildIcon;
    public transient int guildLevel;
    public transient int guildPosition;
    public transient int nameColor;
    public transient String shopName = "";
    public transient Guild joinedGuild;

    public void readFrom(e e2) {
        int n2;
        super.readFrom(e2);
        int n3 = e2.for();
        this.race = n3 & 7;
        this.sex = n3 >> 3 & 1;
        this.turns = n3 >> 4;
        this.gmGrade = e2.for();
        this.suit = e2.for();
        this.halo = e2.for();
        this.nameColor = e2.case();
        this.guildLevel = e2.for();
        if (this.guildLevel > 0) {
            this.guildPosition = e2.for();
            this.guildIcon = e2.for();
            this.guildName = e2.h();
        }
        if ((n2 = e2.for()) > 0) {
            char[] cArray = new char[n2];
            int n4 = 0;
            while (n4 < n2) {
                cArray[n4] = (char)e2.j();
                ++n4;
            }
            this.shopName = new String(cArray);
        }
    }

    public void writeTo(e e2) {
        super.writeTo(e2);
        e2.a(this.race | this.sex << 3 | this.turns << 4);
        e2.a(this.gmGrade);
        e2.a(this.suit);
        e2.a(this.halo);
        e2.a(this.nameColor);
        if (this.joinedGuild != null) {
            e2.a(this.joinedGuild.level);
            e2.a(this.guildPosition);
            e2.a(this.joinedGuild.icon);
            e2.a(this.joinedGuild.name);
        } else {
            e2.a(0);
        }
        if (this.shopName.length() == 0) {
            e2.a(0);
        } else {
            e2.a(this.shopName.length());
            int n2 = 0;
            while (n2 < this.shopName.length()) {
                e2.for(this.shopName.charAt(n2));
                ++n2;
            }
        }
    }

    public Player() {
        this.objectType = 3;
    }
}

