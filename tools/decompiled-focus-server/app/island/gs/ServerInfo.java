/*
 * Decompiled with CFR 0.152.
 */
package app.island.gs;

import daff.a.i;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ServerInfo {
    public static transient int globalMonsterIDCounter = 60000000;
    public static transient int globalNpcIDCounter = 69000000;
    public static transient int globalGroundIDCounter = 70000000;
    public static transient int globalEffectIDCounter = 90000000;
    public static transient int usernameMatchCase = 0;
    public static transient int maxAcceptableClient = 1000;
    public static transient int maxTreasure = 99999;
    public static transient int gmWordsColor = 0xFF00FF;
    public static transient int gmNameColor = 2078975;
    public static transient int systemAlertColor = 13524198;
    public static transient int systemInfoColor = 719215;
    public static transient int systemErrorColor = 16320286;
    public static transient int systemNoticeColor = 16771584;
    public static transient int systemReportColor = 65280;
    public static transient int pkProtectionLevel = 20;
    public static transient int heroDeathPunishProtectionLevel = 20;
    public static transient int loginDelayTime = 5000;
    public static transient int reducePkValueTime = 21600000;
    public static transient int pkStateTimeLast = 30000;
    public static transient int heroRestoreLifeManaDelay = 15000;
    public static transient int addShiTuClosenessTime = 300000;
    public static transient int expTimes = 1;
    public static transient int moneyTimes = 1;
    public static transient int medicineDropTimes = 1;
    public static transient int weaponDropTimes = 1;
    public static transient int equipmentDropTimes = 1;
    public static transient int decorationDropTimes = 1;
    public static transient int extraGoodsDropTimes = 1;
    public static transient int spellExpTimes = 1;
    public static transient int treasureDropTimes = 1;
    public static transient int worldChatMoneyCost = 5000;
    public static transient int worldChatSpeekerGoodsID = 1633040011;
    public static transient int userCreatable = 0;
    public static transient String questionUrl = "";
    public static transient String getPrizesUrl = "";
    public static transient int guildCreationMoneyCost = 1;
    public static transient int guildCreationGoodsCost = 0;
    public static transient int guildCreationHeroLevel = 0;
    public static transient int guildInitialMoney = 10000;
    public static transient int guildDailyMoneyCost = 10000;
    public static transient int guildMemberLowerLimit = 10;
    public static transient int guildUpgradeMoneyCost = 10000;
    public static transient int guildUpgradeGoodsCost = 0;
    public static transient int guildUpgradeReputationRequired = 10;
    public static transient int guildUpgradeMemberRequired = 1;
    public static transient int personalShopTaxRate = 5;
    public static transient int saveUserDelay = 300000;
    public static int dropedTreasure;
    public static int prizedTreasure;
    public static int payedTreasure;
    public static int consumedTreasure;
    public static int connectionCount;
    public static int heroLoginCount;
    public static int createdDuplicateCount;
    public static long receivedMessageCount;
    public static long receivedPingCount;
    public static long sendedMessageCount;
    public static transient int clientErrorReportCount;
    public static transient int printingErrorInfo;
    public static int elfCount;
    public static int manCount;
    public static int orcCount;
    public static int maxOnlineCount;
    public static int onlinePeakTime;
    public static int heroUsingAppletCount;
    public static transient int[] countsOfOnline;
    public static transient int countsArrayPointer;
    public static int averageOnlineCount;
    public static long launchTime;
    public static transient int currentTimeCode;
    public static transient int[] currentTimeParts;
    public static transient long currentMilliSecond;
    public static transient int updatingCounter;
    private static /* synthetic */ Class class$app$island$gs$ServerInfo;
    private static /* synthetic */ Class class$java$lang$String;

    public static final i encodeInfoToXML() {
        i i2 = new i("serverInfo");
        try {
            Class clazz = class$app$island$gs$ServerInfo != null ? class$app$island$gs$ServerInfo : (class$app$island$gs$ServerInfo = ServerInfo.class$("app.island.gs.ServerInfo"));
            Field[] fieldArray = clazz.getFields();
            int n2 = fieldArray.length;
            int n3 = 0;
            while (n3 < n2) {
                block5: {
                    String string;
                    i i3;
                    block7: {
                        block8: {
                            block6: {
                                int n4 = fieldArray[n3].getModifiers();
                                if (Modifier.isTransient(n4) || Modifier.isFinal(n4)) break block5;
                                fieldArray[n3].getModifiers();
                                String string2 = fieldArray[n3].getName();
                                i3 = new i(string2);
                                string = "";
                                if (fieldArray[n3].getType() != Integer.TYPE) break block6;
                                string = String.valueOf(fieldArray[n3].getInt(null));
                                break block7;
                            }
                            if (fieldArray[n3].getType() != Long.TYPE) break block8;
                            string = String.valueOf(fieldArray[n3].getLong(null));
                            break block7;
                        }
                        if (fieldArray[n3].getType() != (class$java$lang$String != null ? class$java$lang$String : ServerInfo.class$("java.lang.String"))) break block5;
                        string = String.valueOf(fieldArray[n3].get(null));
                    }
                    i3.do(string);
                    i2.a(i3);
                }
                ++n3;
            }
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return i2;
    }

    public static final String getFieldValue(String string) {
        try {
            Class clazz = class$app$island$gs$ServerInfo != null ? class$app$island$gs$ServerInfo : (class$app$island$gs$ServerInfo = ServerInfo.class$("app.island.gs.ServerInfo"));
            Field field = clazz.getDeclaredField(string);
            int n2 = field.getModifiers();
            if (Modifier.isPublic(n2) && Modifier.isStatic(n2) && !Modifier.isFinal(n2)) {
                if (field.getType() == Integer.TYPE) {
                    return String.valueOf(field.getInt(null));
                }
                if (field.getType() == Long.TYPE) {
                    return String.valueOf(field.getLong(null));
                }
                if (field.getType() == (class$java$lang$String != null ? class$java$lang$String : (class$java$lang$String = ServerInfo.class$("java.lang.String")))) {
                    return (String)field.get(null);
                }
            }
        }
        catch (NoSuchFieldException noSuchFieldException) {
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return "not found:" + string;
    }

    public static final void setConfigValue(String string, String string2) {
        try {
            Class clazz = class$app$island$gs$ServerInfo != null ? class$app$island$gs$ServerInfo : (class$app$island$gs$ServerInfo = ServerInfo.class$("app.island.gs.ServerInfo"));
            Field field = clazz.getDeclaredField(string);
            int n2 = field.getModifiers();
            if (Modifier.isPublic(n2) && Modifier.isStatic(n2) && !Modifier.isFinal(n2)) {
                if (field.getType() == Integer.TYPE) {
                    field.setInt(null, Integer.parseInt(string2));
                } else if (field.getType() == (class$java$lang$String != null ? class$java$lang$String : (class$java$lang$String = ServerInfo.class$("java.lang.String")))) {
                    field.set(null, string2);
                }
            }
        }
        catch (NoSuchFieldException noSuchFieldException) {
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    static {
        printingErrorInfo = 1;
        countsOfOnline = new int[8640];
        currentTimeParts = new int[7];
    }

    private static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError(classNotFoundException.getMessage());
        }
    }
}

