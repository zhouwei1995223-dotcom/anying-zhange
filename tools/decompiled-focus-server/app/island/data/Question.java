/*
 * Decompiled with CFR 0.152.
 */
package app.island.data;

import app.island.GameObject;
import daff.a.e;

public class Question
extends GameObject {
    public String question;
    public String[] options;
    public int answerIndex;
    public int optionNum;

    public void readFrom(e e2) {
        super.readFrom(e2);
        this.optionNum = e2.i();
        this.question = e2.f();
        int n2 = this.optionNum;
        this.options = new String[this.optionNum];
        int n3 = 0;
        while (n3 < n2) {
            this.options[n3] = e2.f();
            ++n3;
        }
    }

    public void writeTo(e e2) {
        super.writeTo(e2);
        e2.char(this.optionNum);
        e2.do(this.question);
        int n2 = this.options.length;
        int n3 = 0;
        while (n3 < n2) {
            e2.do(this.options[n3]);
            ++n3;
        }
    }

    public Question(String string, String[] stringArray, int n2, int n3, int n4) {
        this.question = string;
        this.options = stringArray;
        this.answerIndex = n2;
        if (n4 == 1) {
            this.name = "\u6807\u51c6\u7b54\u9898";
        } else if (n4 == 2) {
            this.name = "\u6311\u6218\u7b54\u9898";
        }
        this.optionNum = n3;
    }

    public Question() {
    }

    public void copyFrom(GameObject gameObject) {
        super.copyFrom(gameObject);
        Question question = (Question)gameObject;
        this.question = question.question;
        this.options = question.options;
        this.answerIndex = question.answerIndex;
        this.optionNum = question.optionNum;
    }
}

