package com.meizu.cloud.pushsdk;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.platform.api.PushPlatformManager;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import com.meizu.cloud.pushsdk.util.PushPreferencesUtils;

public class PushManager {
    static final String KEY_PUSH_ID = "pushId";
    static final String PUSH_ID_PREFERENCE_NAME = "com.meizu.flyme.push";
    public static final String TAG = "3.6.1";

    @Deprecated
    public static void register(Context context) {
        DebugLogger.initDebugLogger(context);
        String appVersionName = MzSystemUtils.getAppVersionName(context, "com.meizu.cloud");
        DebugLogger.m4829i(TAG, context.getPackageName() + " start register cloudVersion_name " + appVersionName);
        Intent intent = new Intent(PushConstants.MZ_PUSH_ON_START_PUSH_REGISTER);
        if ("com.meizu.cloud".equals(MzSystemUtils.getMzPushServicePackageName(context))) {
            intent.setClassName("com.meizu.cloud", "com.meizu.cloud.pushsdk.pushservice.MzPushService");
            intent.putExtra("sender", context.getPackageName());
        } else if (!TextUtils.isEmpty(appVersionName) && MzSystemUtils.compareVersion(appVersionName, "4.5.7")) {
            DebugLogger.m4828e(TAG, "flyme 4.x start register cloud versionName " + appVersionName);
            intent.setPackage("com.meizu.cloud");
            intent.putExtra("sender", context.getPackageName());
        } else if (TextUtils.isEmpty(appVersionName) || !appVersionName.startsWith(ExifInterface.GPS_MEASUREMENT_3D)) {
            DebugLogger.m4828e(TAG, context.getPackageName() + " start register ");
            intent.setClassName(context.getPackageName(), "com.meizu.cloud.pushsdk.pushservice.MzPushService");
            intent.putExtra("sender", context.getPackageName());
        } else {
            DebugLogger.m4828e(TAG, "flyme 3.x start register cloud versionName " + appVersionName);
            intent.setAction(PushConstants.REQUEST_REGISTRATION_INTENT);
            intent.setPackage("com.meizu.cloud");
            intent.putExtra(PushConstants.EXTRA_APPLICATION_PENDING_INTENT, PendingIntent.getBroadcast(context, 0, new Intent(), 0));
            intent.putExtra("sender", context.getPackageName());
        }
        context.startService(intent);
    }

    @Deprecated
    public static void unRegister(Context context) {
        String appVersionName = MzSystemUtils.getAppVersionName(context, "com.meizu.cloud");
        DebugLogger.m4828e(TAG, context.getPackageName() + " start unRegister cloud versionName " + appVersionName);
        Intent intent = new Intent(PushConstants.MZ_PUSH_ON_STOP_PUSH_REGISTER);
        if ("com.meizu.cloud".equals(MzSystemUtils.getMzPushServicePackageName(context))) {
            intent.setClassName("com.meizu.cloud", "com.meizu.cloud.pushsdk.pushservice.MzPushService");
            intent.putExtra("sender", context.getPackageName());
        } else if (!TextUtils.isEmpty(appVersionName) && MzSystemUtils.compareVersion(appVersionName, "4.5.7")) {
            intent.setPackage("com.meizu.cloud");
            intent.putExtra("sender", context.getPackageName());
        } else if (TextUtils.isEmpty(appVersionName) || !appVersionName.startsWith(ExifInterface.GPS_MEASUREMENT_3D)) {
            DebugLogger.m4828e(TAG, context.getPackageName() + " start unRegister ");
            intent.setClassName(context.getPackageName(), "com.meizu.cloud.pushsdk.pushservice.MzPushService");
            intent.putExtra("sender", context.getPackageName());
        } else {
            intent.setAction(PushConstants.REQUEST_UNREGISTRATION_INTENT);
            intent.setPackage("com.meizu.cloud");
            intent.putExtra(PushConstants.EXTRA_APPLICATION_PENDING_INTENT, PendingIntent.getBroadcast(context, 0, new Intent(), 0));
            intent.putExtra("sender", context.getPackageName());
        }
        context.startService(intent);
    }

    public static String getPushId(Context context) {
        int pushIdExpireTime = PushPreferencesUtils.getPushIdExpireTime(context, context.getPackageName());
        if (pushIdExpireTime == 0 || System.currentTimeMillis() / 1000 <= ((long) pushIdExpireTime)) {
            return PushPreferencesUtils.getPushId(context, context.getPackageName());
        }
        return null;
    }

    public static void checkPush(Context context, String str, String str2, String str3) {
        PushPlatformManager.getInstance(context).checkPush(str, str2, context.getPackageName(), str3);
    }

    public static void switchPush(Context context, String str, String str2, String str3, int i, boolean z) {
        PushPlatformManager.getInstance(context).switchPush(str, str2, context.getPackageName(), str3, i, z);
    }

    public static void switchPush(Context context, String str, String str2, String str3, boolean z) {
        PushPlatformManager.getInstance(context).switchPush(str, str2, context.getPackageName(), str3, z);
    }

    public static void register(Context context, String str, String str2) {
        DebugLogger.initDebugLogger(context);
        PushPlatformManager.getInstance(context).register(str, str2, context.getPackageName());
    }

    public static void unRegister(Context context, String str, String str2) {
        PushPlatformManager.getInstance(context).unRegister(str, str2, context.getPackageName());
    }

    public static void subScribeTags(Context context, String str, String str2, String str3, String str4) {
        PushPlatformManager.getInstance(context).subScribeTags(str, str2, context.getPackageName(), str3, str4);
    }

    public static void unSubScribeTags(Context context, String str, String str2, String str3, String str4) {
        PushPlatformManager.getInstance(context).unSubScribeTags(str, str2, context.getPackageName(), str3, str4);
    }

    public static void unSubScribeAllTags(Context context, String str, String str2, String str3) {
        PushPlatformManager.getInstance(context).unSubScribeAllTags(str, str2, context.getPackageName(), str3);
    }

    public static void checkSubScribeTags(Context context, String str, String str2, String str3) {
        PushPlatformManager.getInstance(context).checkSubScribeTags(str, str2, context.getPackageName(), str3);
    }

    public static void subScribeAlias(Context context, String str, String str2, String str3, String str4) {
        PushPlatformManager.getInstance(context).subScribeAlias(str, str2, context.getPackageName(), str3, str4);
    }

    public static void unSubScribeAlias(Context context, String str, String str2, String str3, String str4) {
        PushPlatformManager.getInstance(context).unSubScribeAlias(str, str2, context.getPackageName(), str3, str4);
    }

    public static void checkSubScribeAlias(Context context, String str, String str2, String str3) {
        PushPlatformManager.getInstance(context).checkSubScribeAlias(str, str2, context.getPackageName(), str3);
    }

    public static void checkNotificationMessage(Context context) {
        String appVersionName = MzSystemUtils.getAppVersionName(context, "com.meizu.cloud");
        DebugLogger.m4829i(TAG, context.getPackageName() + " checkNotificationMessage cloudVersion_name " + appVersionName);
        if (!TextUtils.isEmpty(appVersionName) && appVersionName.startsWith("6")) {
            Intent intent = new Intent(PushConstants.MZ_PUSH_ON_GET_NOTIFICATION_MESSAGE);
            intent.putExtra(PushConstants.EXTRA_GET_NOTIFICATION_PACKAGE_NAME, context.getPackageName());
            intent.setClassName("com.meizu.cloud", "com.meizu.cloud.pushsdk.pushservice.MzPushService");
            context.startService(intent);
        }
    }

    public static void enableCacheRequest(Context context, boolean z) {
        PushPlatformManager.getInstance(context).enableRemoteInvoker(z);
    }

    public static void clearNotification(Context context) {
        PushPlatformManager.getInstance(context).clearAllNotification(context.getPackageName());
    }

    public static void clearNotification(Context context, int... iArr) {
        PushPlatformManager.getInstance(context).clearNotification(context.getPackageName(), iArr);
    }
}
