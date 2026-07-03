/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs.data;

import app.island.GameObject;

public class DialogItem
extends GameObject {
    public int minTurn;
    public int maxTurn;
    public int minLevel;
    public int maxLevel;
    public int gmGrade;
    public int race = -1;
    public int sex = -1;
    public int taskDone;
    public int taskDoing;
    public int minTaskData;
    public int maxTaskData;
    public int requiredGoodsID;
    public int minGoodsCount;
    public int maxGoodsCount;
    public int offerTask;
    public String text;
    public int color = 0xFFFFFF;
    public String[] options = new String[6];
    public String[] commands = new String[6];
    public transient long talkingTime;

    public boolean setAttributeValue(String string, String string2) {
        if (string.equals("options")) {
            int n2 = 0;
            while (n2 < this.options.length) {
                if (this.options[n2] == null) {
                    this.options[n2] = string2;
                    break;
                }
                ++n2;
            }
            return true;
        }
        if (string.equals("commands")) {
            int n3 = 0;
            while (n3 < this.commands.length) {
                if (this.commands[n3] == null) {
                    this.commands[n3] = string2;
                    break;
                }
                ++n3;
            }
            return true;
        }
        if (string.equals("color")) {
            if (string2.length() > 1) {
                this.color = Integer.parseInt(string2, 16);
            }
            return true;
        }
        return super.setAttributeValue(string, string2);
    }

    public void copyFrom(GameObject gameObject) {
        super.copyFrom(gameObject);
        DialogItem dialogItem = (DialogItem)gameObject;
        this.text = dialogItem.text;
        System.arraycopy(dialogItem.options, 0, this.options, 0, this.options.length);
        System.arraycopy(dialogItem.commands, 0, this.commands, 0, this.commands.length);
    }
}

