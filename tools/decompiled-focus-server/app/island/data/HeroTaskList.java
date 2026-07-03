/*
 * Decompiled with CFR 0.152.
 */
package app.island.data;

import app.island.GameObject;
import app.island.data.Task;
import app.island.entity.Hero;
import daff.a.b;
import daff.a.e;
import daff.a.h;
import daff.a.i;
import java.util.Date;

public class HeroTaskList
extends GameObject {
    public int[] historys = new int[0];
    public h tasks = new h(10);
    public h limitedTasks = new h(10);
    public int ringTaskCounter;
    public int lastEndRingTime;
    public int lastRingGroupID;
    public transient boolean dataLoaded;

    public void readFrom(e e2) {
        this.dataLoaded = true;
        int n2 = e2.for();
        int n3 = 0;
        while (n3 < n2) {
            Task task = new Task();
            task.readFrom(e2);
            this.tasks.if(task);
            ++n3;
        }
    }

    public void writeTo(e e2) {
        int n2 = this.tasks.for();
        e2.a(n2);
        int n3 = 0;
        while (n3 < n2) {
            Task task = (Task)this.tasks.if(n3);
            task.writeTo(e2);
            ++n3;
        }
    }

    public Task getTask(int n2) {
        int n3 = this.tasks.for();
        int n4 = 0;
        while (n4 < n3) {
            Task task = (Task)this.tasks.if(n4);
            if (task.id == n2) {
                return task;
            }
            ++n4;
        }
        return null;
    }

    public i getAttributeValue(String string) {
        if (string.equals("historys")) {
            StringBuffer stringBuffer = new StringBuffer(this.historys.length * 12);
            int n2 = 0;
            while (n2 < this.historys.length) {
                stringBuffer.append(this.historys[n2]);
                stringBuffer.append(',');
                ++n2;
            }
            i i2 = new i(string);
            i2.do(stringBuffer.toString());
            return i2;
        }
        if (string.equals("tasks")) {
            int n3 = this.tasks.for();
            StringBuffer stringBuffer = new StringBuffer(n3 * 22);
            int n4 = 0;
            while (n4 < n3) {
                Task task = (Task)this.tasks.if(n4);
                stringBuffer.append(task.id);
                stringBuffer.append(',');
                stringBuffer.append(task.stateData);
                stringBuffer.append(',');
                stringBuffer.append(task.acceptedTime);
                stringBuffer.append(',');
                stringBuffer.append(task.expiredTime);
                stringBuffer.append(';');
                ++n4;
            }
            i i3 = new i(string);
            i3.do(stringBuffer.toString());
            return i3;
        }
        if (string.equals("limitedTasks")) {
            int n5 = this.limitedTasks.for();
            StringBuffer stringBuffer = new StringBuffer(n5 * 20);
            int n6 = 0;
            while (n6 < n5) {
                Task task = (Task)this.limitedTasks.if(n6);
                stringBuffer.append(task.id);
                stringBuffer.append(',');
                stringBuffer.append(b.if(task.completedTime));
                stringBuffer.append(';');
                ++n6;
            }
            i i4 = new i(string);
            i4.do(stringBuffer.toString());
            return i4;
        }
        return super.getAttributeValue(string);
    }

    public boolean setAttributeValue(String string, i i2) {
        String string2 = i2.for();
        if (string.equals("historys")) {
            String[] stringArray = b.a(string2, ",");
            int n2 = Math.max(0, stringArray.length - 1);
            this.historys = new int[n2];
            int n3 = 0;
            while (n3 < n2) {
                this.historys[n3] = Integer.parseInt(stringArray[n3]);
                ++n3;
            }
            return true;
        }
        if (string.equals("tasks")) {
            String[] stringArray = b.a(string2, ";");
            int n4 = 0;
            while (n4 < stringArray.length) {
                if (stringArray[n4].length() > 0) {
                    String[] stringArray2 = b.a(stringArray[n4], ",");
                    int n5 = Integer.parseInt(stringArray2[0]);
                    int n6 = Integer.parseInt(stringArray2[1]);
                    Task task = Task.getGlobalTask(n5);
                    if (task != null) {
                        task = (Task)GameObject.cloneObject(task);
                        task.stateData = n6;
                        if (stringArray2.length > 2) {
                            task.acceptedTime = Integer.parseInt(stringArray2[2]);
                            task.expiredTime = Integer.parseInt(stringArray2[3]);
                            if (task.expiredTime > 0) {
                                task.taskDeadline = b.a(task.expiredTime).getTime();
                            }
                        }
                        this.tasks.if(task);
                    }
                }
                ++n4;
            }
            return true;
        }
        if (string.equals("limitedTasks")) {
            String[] stringArray = b.a(string2, ";");
            int n7 = 0;
            while (n7 < stringArray.length) {
                String[] stringArray3;
                int n8;
                Task task;
                if (stringArray[n7].length() > 0 && (task = Task.getGlobalTask(n8 = Integer.parseInt((stringArray3 = b.a(stringArray[n7], ","))[0]))) != null) {
                    task = (Task)GameObject.cloneObject(task);
                    int n9 = Integer.parseInt(stringArray3[1]);
                    task.completedTime = b.a(n9).getTime();
                    this.limitedTasks.if(task);
                }
                ++n7;
            }
            return true;
        }
        return super.setAttributeValue(string, i2);
    }

    public Task getLimitedTask(int n2) {
        int n3 = this.limitedTasks.for();
        int n4 = 0;
        while (n4 < n3) {
            Task task = (Task)this.limitedTasks.if(n4);
            if (task.id == n2) {
                return task;
            }
            ++n4;
        }
        return null;
    }

    public void removeTask(Task task) {
        this.tasks.do(task);
    }

    public Task removeTask(int n2) {
        int n3 = this.tasks.for();
        int n4 = 0;
        while (n4 < n3) {
            Task task = (Task)this.tasks.if(n4);
            if (task.id == n2) {
                this.tasks.a(n4);
                return task;
            }
            ++n4;
        }
        return null;
    }

    public Task changeTaskStateData(int n2, int n3) {
        int n4 = this.tasks.for();
        int n5 = 0;
        while (n5 < n4) {
            Task task = (Task)this.tasks.if(n5);
            if (task.id == n2) {
                task.stateData = n3;
                return task;
            }
            ++n5;
        }
        return null;
    }

    public void addTask(Task task) {
        this.tasks.if(task);
    }

    public Task getCompletedTask(Hero hero) {
        int n2 = this.tasks.for();
        int n3 = 0;
        while (n3 < n2) {
            Task task = (Task)this.tasks.if(n3);
            if (task.isCompleted(hero)) {
                return task;
            }
            ++n3;
        }
        return null;
    }

    public boolean isHistory(int n2) {
        int n3 = 0;
        while (n3 < this.historys.length) {
            if (this.historys[n3] == n2) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    public void addLimitedTask(Task task) {
        int n2 = this.limitedTasks.for();
        int n3 = 0;
        while (n3 < n2) {
            Task task2 = (Task)this.limitedTasks.if(n3);
            if (task2.id == task.id) {
                task2.acceptedTime = task.acceptedTime;
                task2.completedTime = task.completedTime;
                return;
            }
            ++n3;
        }
        this.limitedTasks.if(task);
    }

    public boolean containsTask(int n2) {
        return this.getTask(n2) != null;
    }

    public void addHistory(int n2) {
        int n3 = 0;
        while (n3 < this.historys.length) {
            if (this.historys[n3] == n2) {
                return;
            }
            ++n3;
        }
        int[] nArray = new int[this.historys.length + 1];
        System.arraycopy(this.historys, 0, nArray, 0, this.historys.length);
        nArray[this.historys.length] = n2;
        this.historys = nArray;
    }

    public boolean isAcceptable(Task task, long l2, Hero hero) {
        if (task.requiredRace != -1 && hero.race != task.requiredRace) {
            return false;
        }
        if (hero.turns < task.requiredTurn) {
            return false;
        }
        if (hero.level < task.requiredMinLevel || hero.level > task.requiredMaxLevel) {
            return false;
        }
        if (task.requiredGoodsID > 0 && hero.personalDepot.getGoodsCount(task.requiredGoodsID) <= 0) {
            return false;
        }
        if (task.requiredGuildLevel > 0 && (hero.joinedGuild == null || hero.joinedGuild.level < task.requiredGuildLevel)) {
            return false;
        }
        if (task.requiredTaskID > 0 && !this.isHistory(task.requiredTaskID)) {
            return false;
        }
        int n2 = task.id;
        if (this.isHistory(n2) || this.containsTask(n2)) {
            return false;
        }
        if (task.intervalTime == 0) {
            return true;
        }
        int n3 = this.limitedTasks.for();
        int n4 = 0;
        while (n4 < n3) {
            Task task2 = (Task)this.limitedTasks.if(n4);
            if (task2.id == n2) {
                if (task2.intervalTime == 1440) {
                    Date date = new Date(task2.completedTime);
                    Date date2 = new Date(l2);
                    return date.getDate() != date2.getDate();
                }
                return (l2 - task2.completedTime) / 60000L > (long)task2.intervalTime;
            }
            ++n4;
        }
        return true;
    }
}

