/*
 * Decompiled with CFR 0.152.
 */
package app.island.data;

import app.island.GameObject;
import app.island.data.Spell;
import app.island.entity.Hero;
import daff.a.b;
import daff.a.e;
import daff.a.h;
import daff.a.i;

public class SpellList
extends GameObject {
    public h spells = new h(10);

    public void readFrom(e e2) {
        int n2 = e2.case();
        int n3 = 0;
        while (n3 < n2) {
            int n4 = e2.case();
            Spell spell = Spell.createSpellByType(n4);
            spell.readFrom(e2);
            this.spells.if(spell);
            ++n3;
        }
    }

    public Spell getSpellByGroup(int n2) {
        n2 /= 100;
        int n3 = this.spells.for();
        int n4 = 0;
        while (n4 < n3) {
            Spell spell = (Spell)this.spells.if(n4);
            if (spell.id / 100 == n2) {
                return spell;
            }
            ++n4;
        }
        return null;
    }

    public void writeTo(e e2) {
        int n2 = this.spells.for();
        e2.a(n2);
        int n3 = 0;
        while (n3 < n2) {
            Spell spell = (Spell)this.spells.if(n3);
            e2.a(spell.spellType);
            spell.writeTo(e2);
            ++n3;
        }
    }

    public i getAttributeValue(String string) {
        if (string.equals("spells")) {
            StringBuffer stringBuffer = new StringBuffer(1024);
            int n2 = this.spells.for();
            int n3 = 0;
            while (n3 < n2) {
                Spell spell = (Spell)this.spells.if(n3);
                stringBuffer.append(spell.id);
                stringBuffer.append(',');
                stringBuffer.append(spell.experience);
                stringBuffer.append(';');
                ++n3;
            }
            i i2 = new i(string);
            i2.do(stringBuffer.toString());
            return i2;
        }
        return super.getAttributeValue(string);
    }

    public boolean setAttributeValue(String string, String string2) {
        if (string.equals("spells")) {
            String[] stringArray = b.a(string2, ";");
            int n2 = 0;
            while (n2 < stringArray.length) {
                if (stringArray[n2].length() == 0) break;
                int n3 = stringArray[n2].indexOf(44);
                int n4 = Integer.parseInt(stringArray[n2].substring(0, n3));
                int n5 = Integer.parseInt(stringArray[n2].substring(n3 + 1));
                Spell spell = Spell.getGlobalSpell(n4);
                if (spell != null) {
                    spell = (Spell)GameObject.cloneObject(spell);
                    spell.experience = n5;
                    this.addSpell(spell);
                }
                ++n2;
            }
            return true;
        }
        return super.setAttributeValue(string, string2);
    }

    public boolean isSpellLearned(int n2) {
        int n3 = n2 % 100;
        n2 /= 100;
        int n4 = this.spells.for();
        int n5 = 0;
        while (n5 < n4) {
            Spell spell = (Spell)this.spells.if(n5);
            if (spell.id / 100 == n2 && spell.id % 100 >= n3) {
                return true;
            }
            ++n5;
        }
        return false;
    }

    public Spell getSpell(int n2) {
        int n3 = this.spells.for();
        int n4 = 0;
        while (n4 < n3) {
            Spell spell = (Spell)this.spells.if(n4);
            if (spell.id == n2) {
                return spell;
            }
            ++n4;
        }
        return null;
    }

    public void checkSpells(Hero hero) {
        int n2 = this.spells.for();
        int n3 = 0;
        while (n3 < n2) {
            Spell spell = (Spell)this.spells.if(n3);
            if (spell.id / 10000 % 100 != hero.race) {
                this.spells.a(n3);
                --n3;
                --n2;
            }
            ++n3;
        }
    }

    public void addSpell(Spell spell) {
        int n2 = this.spells.for();
        int n3 = 0;
        while (n3 < n2) {
            Spell spell2 = (Spell)this.spells.if(n3);
            if (spell2.id / 100 == spell.id / 100) {
                if (spell2.id % 100 < spell.id % 100) {
                    spell2.copyFrom(spell);
                }
                return;
            }
            ++n3;
        }
        this.spells.if(spell);
    }
}

