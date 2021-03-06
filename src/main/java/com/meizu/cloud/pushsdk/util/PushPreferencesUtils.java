package com.meizu.cloud.pushsdk.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Set;

public class PushPreferencesUtils {
    public static final String MZ_PUSH_PREFERENCE = "mz_push_preference";
    private static final String MZ_PUSH_PREFIX_MESSAGE_SEQ = ".message_seq";
    private static final String MZ_PUSH_PREFIX_NOTIFICATION_ID = ".notification_id";
    private static final String MZ_PUSH_PREFIX_NOTIFY_ID = ".notify_id";
    private static final String MZ_PUSH_PREFIX_PUSH_TASK_ID = ".notification_push_task_id";

    private static SharedPreferences getSharePerferenceByName(Context context, String str) {
        return context.getSharedPreferences(str, 0);
    }

    public static void putStringByKey(Context context, String str, String str2, String str3) {
        getSharePerferenceByName(context, str).edit().putString(str2, str3).apply();
    }

    public static String getStringBykey(Context context, String str, String str2) {
        return getSharePerferenceByName(context, str).getString(str2, "");
    }

    public static Set<String> getStringSetBykey(Context context, String str, String str2) {
        return getSharePerferenceByName(context, str).getStringSet(str2, (Set) null);
    }

    public static void putStringSetByKey(Context context, String str, String str2, Set<String> set) {
        getSharePerferenceByName(context, str).edit().putStringSet(str2, set).commit();
    }

    public static void putIntBykey(Context context, String str, String str2, int i) {
        getSharePerferenceByName(context, str).edit().putInt(str2, i).apply();
    }

    public static int getIntBykey(Context context, String str, String str2) {
        return getSharePerferenceByName(context, str).getInt(str2, 0);
    }

    public static void putBooleanByKey(Context context, String str, String str2, boolean z) {
        getSharePerferenceByName(context, str).edit().putBoolean(str2, z).apply();
    }

    public static boolean getBooleanByKey(Context context, String str, String str2) {
        return getSharePerferenceByName(context, str).getBoolean(str2, true);
    }

    public static boolean remove(Context context, String str, String str2) {
        return getSharePerferenceByName(context, str).edit().remove(str2).commit();
    }

    public static boolean hasKey(Context context, String str, String str2) {
        return getSharePerferenceByName(context, str).contains(str2);
    }

    public static String getPushId(Context context, String str) {
        return getStringBykey(context, PushConstants.PUSH_ID_PREFERENCE_NAME, str + "_" + PushConstants.KEY_PUSH_ID);
    }

    public static void putPushId(Context context, String str, String str2) {
        putStringByKey(context, PushConstants.PUSH_ID_PREFERENCE_NAME, str2 + "_" + PushConstants.KEY_PUSH_ID, str);
    }

    public static void putPushIdExpireTime(Context context, int i, String str) {
        putIntBykey(context, PushConstants.PUSH_ID_PREFERENCE_NAME, str + "_" + PushConstants.KEY_PUSH_ID_EXPIRE_TIME, i);
    }

    public static int getPushIdExpireTime(Context context, String str) {
        return getIntBykey(context, PushConstants.PUSH_ID_PREFERENCE_NAME, str + "_" + PushConstants.KEY_PUSH_ID_EXPIRE_TIME);
    }

    public static String getDeviceId(Context context) {
        return getSharePerferenceByName(context, MZ_PUSH_PREFERENCE).getString(PushConstants.MZ_PUSH_MESSAGE_STATISTICS_IMEI_KEY, (String) null);
    }

    public static void putDeviceId(Context context, String str) {
        putStringByKey(context, MZ_PUSH_PREFERENCE, PushConstants.MZ_PUSH_MESSAGE_STATISTICS_IMEI_KEY, str);
    }

    public static void putDiscardNotificationIdByPackageName(Context context, String str, int i) {
        putIntBykey(context, MZ_PUSH_PREFERENCE, str + MZ_PUSH_PREFIX_NOTIFICATION_ID, i);
    }

    public static int getDiscardNotificationId(Context context, String str) {
        SharedPreferences sharePerferenceByName = getSharePerferenceByName(context, MZ_PUSH_PREFERENCE);
        return sharePerferenceByName.getInt(str + MZ_PUSH_PREFIX_NOTIFICATION_ID, 0);
    }

    public static void putDiscardNotificationTaskId(Context context, String str, int i) {
        putIntBykey(context, MZ_PUSH_PREFERENCE, str + MZ_PUSH_PREFIX_PUSH_TASK_ID, i);
    }

    public static int getDiscardNotificationTaskId(Context context, String str) {
        SharedPreferences sharePerferenceByName = getSharePerferenceByName(context, MZ_PUSH_PREFERENCE);
        return sharePerferenceByName.getInt(str + MZ_PUSH_PREFIX_PUSH_TASK_ID, 0);
    }

    public static void setNotificationMessageSwitchStatus(Context context, String str, boolean z) {
        putBooleanByKey(context, MZ_PUSH_PREFERENCE, "switch_notification_message_" + str, z);
    }

    public static boolean getNotificationMessageSwitchStatus(Context context, String str) {
        return getBooleanByKey(context, MZ_PUSH_PREFERENCE, "switch_notification_message_" + str);
    }

    public static boolean hasNotificationSwitchStatus(Context context, String str) {
        return hasKey(context, MZ_PUSH_PREFERENCE, "switch_notification_message_" + str);
    }

    public static void setAlias(Context context, String str, String str2) {
        putStringByKey(context, MZ_PUSH_PREFERENCE, "push_alias_" + str, str2);
    }

    public static String getAlias(Context context, String str) {
        return getStringBykey(context, MZ_PUSH_PREFERENCE, "push_alias_" + str);
    }

    public static void setThroughMessageSwitchStatus(Context context, String str, boolean z) {
        putBooleanByKey(context, MZ_PUSH_PREFERENCE, "switch_through_message_" + str, z);
    }

    public static boolean getThroughMessageSwitchStatus(Context context, String str) {
        return getBooleanByKey(context, MZ_PUSH_PREFERENCE, "switch_through_message_" + str);
    }

    public static boolean hasThroughMessageSwitchStatus(Context context, String str) {
        return hasKey(context, MZ_PUSH_PREFERENCE, "switch_through_message_" + str);
    }

    public static void putMessageSeq(Context context, String str, int i) {
        putIntBykey(context, MZ_PUSH_PREFERENCE, str + MZ_PUSH_PREFIX_MESSAGE_SEQ, i);
    }

    public static int getMessageSeqInCrease(Context context, String str) {
        int intBykey = getIntBykey(context, MZ_PUSH_PREFERENCE, str + MZ_PUSH_PREFIX_MESSAGE_SEQ) + 1;
        putMessageSeq(context, str, intBykey);
        DebugLogger.m4828e(MZ_PUSH_PREFERENCE, "current messageSeq " + intBykey);
        return intBykey;
    }

    public static void putNotifyIdByPackageName(Context context, String str, Set<String> set) {
        putStringSetByKey(context, MZ_PUSH_PREFERENCE, str + MZ_PUSH_PREFIX_NOTIFY_ID, set);
    }

    public static Set<String> getNotifyIdByPackageName(Context context, String str) {
        return getStringSetBykey(context, MZ_PUSH_PREFERENCE, str + MZ_PUSH_PREFIX_NOTIFY_ID);
    }

    public static void putNotifyIdByNotifyKey(Context context, String str, String str2, int i) {
        putIntBykey(context, MZ_PUSH_PREFERENCE, str + "." + str2, i);
    }

    public static int getNotifyIdByNotifyKey(Context context, String str, String str2) {
        return getIntBykey(context, MZ_PUSH_PREFERENCE, str + "." + str2);
    }

    public static boolean removeNotifyKey(Context context, String str, String str2) {
        return remove(context, MZ_PUSH_PREFERENCE, str + "." + str2);
    }
}
