package com.meizu.cloud.pushsdk.notification;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.PowerManager;
import android.text.TextUtils;
import com.baidu.p020ar.parser.ARResourceKey;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.networking.AndroidNetworking;
import com.meizu.cloud.pushsdk.networking.common.ANConstants;
import com.meizu.cloud.pushsdk.networking.common.ANResponse;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.meizu.cloud.pushsdk.notification.model.NotifyOption;
import com.meizu.cloud.pushsdk.notification.util.NotificationUtils;
import com.meizu.cloud.pushsdk.notification.util.RProxy;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import com.meizu.cloud.pushsdk.util.PushPreferencesUtils;
import org.json.JSONObject;

public abstract class AbstractPushNotification implements PushNotification {
    protected static final String TAG = "AbstractPushNotification";
    protected Context context;
    protected Handler handler;
    private NotificationManager notificationManager;
    protected PushNotificationBuilder pushNotificationBuilder;

    /* access modifiers changed from: protected */
    public void appIconSettingBuilder(Notification.Builder builder, MessageV3 messageV3) {
    }

    /* access modifiers changed from: protected */
    public void buildBigContentView(Notification notification, MessageV3 messageV3) {
    }

    /* access modifiers changed from: protected */
    public void buildContentView(Notification notification, MessageV3 messageV3) {
    }

    /* access modifiers changed from: protected */
    public void buildExpandableContent(Notification.Builder builder, MessageV3 messageV3) {
    }

    protected AbstractPushNotification(Context context2, PushNotificationBuilder pushNotificationBuilder2) {
        this.pushNotificationBuilder = pushNotificationBuilder2;
        this.context = context2;
        this.handler = new Handler(context2.getMainLooper());
        this.notificationManager = (NotificationManager) context2.getSystemService("notification");
    }

    /* access modifiers changed from: protected */
    public Notification construtNotificationFinal(MessageV3 messageV3, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        Notification notification;
        Notification.Builder builder = new Notification.Builder(this.context);
        basicSettingBuilder(builder, messageV3, pendingIntent, pendingIntent2);
        advanceSettingBuilder(builder, messageV3);
        appIconSettingBuilder(builder, messageV3);
        buildExpandableContent(builder, messageV3);
        if (MinSdkChecker.isSupportNotificationBuild()) {
            notification = builder.build();
        } else {
            notification = builder.getNotification();
        }
        buildContentView(notification, messageV3);
        buildBigContentView(notification, messageV3);
        return notification;
    }

    /* access modifiers changed from: protected */
    public PendingIntent createClickIntent(MessageV3 messageV3) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("custom://" + System.currentTimeMillis()));
        intent.putExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE, messageV3);
        intent.putExtra(PushConstants.MZ_PUSH_MESSAGE_METHOD, PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE);
        intent.setClassName(messageV3.getUploadDataPackageName(), MzSystemUtils.findReceiver(this.context, PushConstants.MZ_PUSH_ON_MESSAGE_ACTION, messageV3.getUploadDataPackageName()));
        intent.setAction(PushConstants.MZ_PUSH_ON_MESSAGE_ACTION);
        intent.setFlags(32);
        return PendingIntent.getBroadcast(this.context, 0, intent, 1073741824);
    }

    /* access modifiers changed from: protected */
    public PendingIntent createDeleteIntent(MessageV3 messageV3) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("custom://" + System.currentTimeMillis()));
        intent.putExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE, messageV3);
        intent.putExtra(PushConstants.MZ_PUSH_MESSAGE_METHOD, PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_NOTIFICATION_DELETE);
        intent.setClassName(messageV3.getPackageName(), MzSystemUtils.findReceiver(this.context, PushConstants.MZ_PUSH_ON_MESSAGE_ACTION, messageV3.getPackageName()));
        intent.setAction(PushConstants.MZ_PUSH_ON_MESSAGE_ACTION);
        return PendingIntent.getBroadcast(this.context, 0, intent, 1073741824);
    }

    /* access modifiers changed from: protected */
    public PendingIntent createStateIntent(MessageV3 messageV3) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("custom://" + System.currentTimeMillis()));
        intent.putExtra(PushConstants.MZ_PUSH_NOTIFICATION_STATE_MESSAGE, messageV3.getNotificationMessage());
        intent.putExtra(PushConstants.NOTIFICATION_EXTRA_TASK_ID, messageV3.getTaskId());
        intent.putExtra(PushConstants.NOTIFICATION_EXTRA_SEQ_ID, messageV3.getSeqId());
        intent.putExtra(PushConstants.NOTIFICATION_EXTRA_DEVICE_ID, messageV3.getDeviceId());
        intent.putExtra(PushConstants.NOTIFICATION_EXTRA_PUSH_TIMESTAMP, messageV3.getPushTimestamp());
        intent.putExtra(PushConstants.NOTIFICATION_EXTRA_SHOW_PACKAGE_NAME, messageV3.getUploadDataPackageName());
        intent.putExtra(PushConstants.MZ_PUSH_MESSAGE_METHOD, PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_NOTIFICATION_STATE);
        intent.setClassName(messageV3.getPackageName(), MzSystemUtils.findReceiver(this.context, PushConstants.MZ_PUSH_ON_MESSAGE_ACTION, messageV3.getPackageName()));
        intent.setAction(PushConstants.MZ_PUSH_ON_MESSAGE_ACTION);
        return PendingIntent.getBroadcast(this.context, 0, intent, 1073741824);
    }

    /* access modifiers changed from: protected */
    public void basicSettingBuilder(Notification.Builder builder, MessageV3 messageV3, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        builder.setContentTitle(messageV3.getTitle());
        builder.setContentText(messageV3.getContent());
        builder.setTicker(messageV3.getTitle());
        builder.setAutoCancel(true);
        if (MinSdkChecker.isSupportSendNotification()) {
            builder.setVisibility(1);
        }
        if (MinSdkChecker.isSupportSetDrawableSmallIcon()) {
            Icon loadSmallIcon = loadSmallIcon(messageV3.getUploadDataPackageName());
            if (loadSmallIcon != null) {
                builder.setSmallIcon(loadSmallIcon);
            } else {
                DebugLogger.m4828e(TAG, "cannot get " + messageV3.getUploadDataPackageName() + " smallIcon");
                builder.setSmallIcon(RProxy.stat_sys_third_app_notify(this.context));
            }
        } else {
            builder.setSmallIcon((this.pushNotificationBuilder == null || this.pushNotificationBuilder.getmStatusbarIcon() == 0) ? RProxy.stat_sys_third_app_notify(this.context) : this.pushNotificationBuilder.getmStatusbarIcon());
        }
        builder.setContentIntent(pendingIntent);
        builder.setDeleteIntent(pendingIntent2);
    }

    /* access modifiers changed from: protected */
    public void advanceSettingBuilder(Notification.Builder builder, MessageV3 messageV3) {
        AdvanceSetting advanceSetting = messageV3.getmAdvanceSetting();
        if (advanceSetting != null) {
            if (advanceSetting.getNotifyType() != null) {
                boolean isVibrate = advanceSetting.getNotifyType().isVibrate();
                boolean isLights = advanceSetting.getNotifyType().isLights();
                boolean isSound = advanceSetting.getNotifyType().isSound();
                if (isVibrate || isLights || isSound) {
                    int i = 0;
                    if (isVibrate) {
                        i = 2;
                    }
                    if (isLights) {
                        i |= 4;
                    }
                    if (isSound) {
                        i |= 1;
                    }
                    DebugLogger.m4828e(TAG, "current notification type is " + i);
                    builder.setDefaults(i);
                }
            }
            builder.setOngoing(!advanceSetting.isClearNotification());
            if (advanceSetting.isHeadUpNotification() && MinSdkChecker.isSupportNotificationBuild()) {
                builder.setPriority(2);
            }
        }
    }

    public Bitmap getBitmapFromURL(String str) {
        ANResponse executeForBitmap = AndroidNetworking.get(str).build().executeForBitmap();
        if (!executeForBitmap.isSuccess() || executeForBitmap.getResult() == null) {
            DebugLogger.m4829i(TAG, "ANRequest On other Thread down load largeIcon " + str + "image fail");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ANRequest On other Thread down load largeIcon ");
        sb.append(str);
        sb.append("image ");
        sb.append(executeForBitmap.getResult() != null ? ANConstants.SUCCESS : "fail");
        DebugLogger.m4829i(TAG, sb.toString());
        return (Bitmap) executeForBitmap.getResult();
    }

    @TargetApi(23)
    private Icon loadSmallIcon(String str) {
        try {
            int identifier = this.context.getPackageManager().getResourcesForApplication(str).getIdentifier(PushConstants.MZ_PUSH_NOTIFICATION_SMALL_ICON, "drawable", str);
            if (identifier == 0) {
                return null;
            }
            DebugLogger.m4829i(TAG, "get " + str + " smallIcon success resId " + identifier);
            return Icon.createWithResource(str, identifier);
        } catch (Exception e) {
            DebugLogger.m4828e(TAG, "cannot load smallIcon form package " + str + " Error message " + e.getMessage());
            return null;
        }
    }

    public Bitmap getAppIcon(Context context2, String str) {
        try {
            return ((BitmapDrawable) context2.getPackageManager().getApplicationIcon(str)).getBitmap();
        } catch (PackageManager.NameNotFoundException e) {
            DebugLogger.m4829i(TAG, "getappicon error " + e.getMessage());
            return ((BitmapDrawable) context2.getApplicationInfo().loadIcon(context2.getPackageManager())).getBitmap();
        }
    }

    /* access modifiers changed from: protected */
    public boolean isOnMainThread() {
        return Thread.currentThread() == this.context.getMainLooper().getThread();
    }

    /* access modifiers changed from: protected */
    public boolean isScreenOnAndUnlock() {
        PowerManager powerManager = (PowerManager) this.context.getSystemService(ARResourceKey.HTTP_POWER);
        if (Build.VERSION.SDK_INT < 20) {
            if (!powerManager.isScreenOn()) {
                return false;
            }
        } else if (!powerManager.isInteractive()) {
            return false;
        }
        return !((KeyguardManager) this.context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }

    /* access modifiers changed from: protected */
    public String getFlymeGreenNotificationSetting(MessageV3 messageV3) {
        String str = null;
        try {
            if (!TextUtils.isEmpty(messageV3.getNotificationMessage())) {
                str = new JSONObject(messageV3.getNotificationMessage()).getJSONObject("data").getJSONObject(PushConstants.EXTRA).getString("fns");
            }
        } catch (Exception e) {
            DebugLogger.m4828e(TAG, "parse flyme notifification setting error " + e.getMessage());
        }
        DebugLogger.m4829i(TAG, "current FlymeGreen notification setting is " + str);
        return str;
    }

    @SuppressLint({"NewApi"})
    public void show(MessageV3 messageV3) {
        Notification construtNotificationFinal = construtNotificationFinal(messageV3, createClickIntent(messageV3), createDeleteIntent(messageV3));
        NotificationUtils.setInternalApp(construtNotificationFinal, true);
        NotificationUtils.setReplyIntent(construtNotificationFinal, createStateIntent(messageV3));
        construtNotificationFinal.extras.putString(PushConstants.EXTRA_ORIGINAL_NOTIFICATION_PACKAGE_NAME, messageV3.getUploadDataPackageName());
        construtNotificationFinal.extras.putString(PushConstants.EXTRA_FLYME_GREEN_NOTIFICATION_SETTING, getFlymeGreenNotificationSetting(messageV3));
        construtNotificationFinal.extras.putString(PushConstants.NOTIFICATION_EXTRA_TASK_ID, messageV3.getTaskId());
        construtNotificationFinal.extras.putString(PushConstants.NOTIFICATION_EXTRA_SEQ_ID, messageV3.getSeqId());
        construtNotificationFinal.extras.putString(PushConstants.NOTIFICATION_EXTRA_DEVICE_ID, messageV3.getDeviceId());
        construtNotificationFinal.extras.putString(PushConstants.NOTIFICATION_EXTRA_PUSH_TIMESTAMP, messageV3.getPushTimestamp());
        int abs = Math.abs((int) System.currentTimeMillis());
        NotifyOption notifyOptionSetting = NotifyOption.getNotifyOptionSetting(messageV3);
        if (!(notifyOptionSetting == null || notifyOptionSetting.getNotifyId() == 0)) {
            abs = notifyOptionSetting.getNotifyId();
            DebugLogger.m4828e(TAG, "server notify id " + abs);
            if (!TextUtils.isEmpty(notifyOptionSetting.getNotifyKey())) {
                int notifyIdByNotifyKey = PushPreferencesUtils.getNotifyIdByNotifyKey(this.context, messageV3.getUploadDataPackageName(), notifyOptionSetting.getNotifyKey());
                DebugLogger.m4828e(TAG, "notifyKey " + notifyOptionSetting.getNotifyKey() + " preference notifyId is " + notifyIdByNotifyKey);
                if (notifyIdByNotifyKey != 0) {
                    DebugLogger.m4828e(TAG, "use preference notifyId " + notifyIdByNotifyKey + " and cancel it");
                    this.notificationManager.cancel(notifyIdByNotifyKey);
                }
                DebugLogger.m4828e(TAG, "store new notifyId " + abs + " by notifyKey " + notifyOptionSetting.getNotifyKey());
                PushPreferencesUtils.putNotifyIdByNotifyKey(this.context, messageV3.getUploadDataPackageName(), notifyOptionSetting.getNotifyKey(), abs);
            }
        }
        DebugLogger.m4828e(TAG, "current notify id " + abs);
        if (messageV3.isDiscard()) {
            if (PushPreferencesUtils.getDiscardNotificationId(this.context, messageV3.getPackageName()) == 0) {
                PushPreferencesUtils.putDiscardNotificationIdByPackageName(this.context, messageV3.getPackageName(), abs);
                DebugLogger.m4829i(TAG, "no notification show so put notification id " + abs);
            }
            if (!TextUtils.isEmpty(messageV3.getTaskId())) {
                if (PushPreferencesUtils.getDiscardNotificationTaskId(this.context, messageV3.getPackageName()) == 0) {
                    PushPreferencesUtils.putDiscardNotificationTaskId(this.context, messageV3.getPackageName(), Integer.valueOf(messageV3.getTaskId()).intValue());
                } else if (Integer.valueOf(messageV3.getTaskId()).intValue() < PushPreferencesUtils.getDiscardNotificationTaskId(this.context, messageV3.getPackageName())) {
                    DebugLogger.m4829i(TAG, "current package " + messageV3.getPackageName() + " taskid " + messageV3.getTaskId() + " dont show notification");
                    return;
                } else {
                    PushPreferencesUtils.putDiscardNotificationTaskId(this.context, messageV3.getPackageName(), Integer.valueOf(messageV3.getTaskId()).intValue());
                    abs = PushPreferencesUtils.getDiscardNotificationId(this.context, messageV3.getPackageName());
                }
            }
            DebugLogger.m4829i(TAG, "current package " + messageV3.getPackageName() + " notificationId=" + abs + " taskId=" + messageV3.getTaskId());
        }
        this.notificationManager.notify(abs, construtNotificationFinal);
        dismissFloatNotification(this.notificationManager, abs, messageV3);
    }

    /* access modifiers changed from: protected */
    public void dismissFloatNotification(final NotificationManager notificationManager2, final int i, MessageV3 messageV3) {
        AdvanceSetting advanceSetting = messageV3.getmAdvanceSetting();
        if (advanceSetting != null) {
            boolean isHeadUpNotification = advanceSetting.isHeadUpNotification();
            boolean isClearNotification = advanceSetting.isClearNotification();
            if (isHeadUpNotification && !isClearNotification) {
                messageV3.getmAdvanceSetting().setHeadUpNotification(false);
                messageV3.getmAdvanceSetting().getNotifyType().setSound(false);
                messageV3.getmAdvanceSetting().getNotifyType().setVibrate(false);
                final Notification construtNotificationFinal = construtNotificationFinal(messageV3, createClickIntent(messageV3), createDeleteIntent(messageV3));
                this.handler.postDelayed(new Runnable() {
                    public void run() {
                        notificationManager2.notify(i, construtNotificationFinal);
                    }
                }, 5000);
            }
        }
    }
}
