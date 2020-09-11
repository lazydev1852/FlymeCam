package com.meizu.cloud.pushsdk.handler.impl;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.AbstractAppLogicListener;
import com.meizu.cloud.pushsdk.handler.MessageHandler;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import com.meizu.cloud.pushsdk.notification.PushNotification;
import com.meizu.cloud.pushsdk.notification.model.NotifyOption;
import com.meizu.cloud.pushsdk.notification.util.NotificationUtils;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import com.meizu.cloud.pushsdk.util.PushPreferencesUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class AbstractMessageHandler<T> implements MessageHandler {
    public static final int MESSAGE_TYPE_NOTIFICATION_ARRIVED = 131072;
    public static final int MESSAGE_TYPE_NOTIFICATION_CLICK = 64;
    public static final int MESSAGE_TYPE_NOTIFICATION_DELETE = 128;
    public static final int MESSAGE_TYPE_NOTIFICATION_STATE = 32768;
    public static final int MESSAGE_TYPE_PUSH_REGISTER_STATUS = 512;
    public static final int MESSAGE_TYPE_PUSH_SERVICE_V2 = 2;
    public static final int MESSAGE_TYPE_PUSH_SERVICE_V3 = 4;
    public static final int MESSAGE_TYPE_PUSH_SUBALIAS_STATUS = 4096;
    public static final int MESSAGE_TYPE_PUSH_SUBTAGS_STATUS = 2048;
    public static final int MESSAGE_TYPE_PUSH_SWITCH_STATUS = 256;
    public static final int MESSAGE_TYPE_PUSH_UNREGISTER_STATUS = 1024;
    public static final int MESSAGE_TYPE_RECEIVE_NOTIFY_MESSAGE = 16384;
    public static final int MESSAGE_TYPE_REGISTER = 16;
    public static final int MESSAGE_TYPE_SCHEDULE_NOTIFICATION = 8192;
    public static final int MESSAGE_TYPE_THROUGH = 8;
    public static final int MESSAGE_TYPE_UNREGISTER = 32;
    public static final int MESSAGE_TYPE_UPLOAD_FILE_LOG = 65536;
    public static final int SCHEDULE_OFF = 0;
    public static final int SCHEDULE_ON_DELAY = 3;
    public static final int SCHEDULE_ON_EXPIRE = 1;
    public static final int SCHEDULE_ON_TIME = 2;
    protected static final String TAG = "AbstractMessageHandler";
    private AbstractAppLogicListener abstractAppLogicListener;
    private Context context;
    private Map<Integer, String> messageHandlerMap;

    /* access modifiers changed from: protected */
    public boolean canSendMessage(T t) {
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract T getMessage(Intent intent);

    /* access modifiers changed from: protected */
    public void onAfterEvent(T t) {
    }

    /* access modifiers changed from: protected */
    public void onBeforeEvent(T t) {
    }

    /* access modifiers changed from: protected */
    public PushNotification onCreateNotification(T t) {
        return null;
    }

    /* access modifiers changed from: protected */
    public int scheduleNotificationStatus(T t) {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void scheduleShowNotification(T t) {
    }

    /* access modifiers changed from: protected */
    public abstract void unsafeSend(T t, PushNotification pushNotification);

    protected AbstractMessageHandler(Context context2) {
        this(context2, (AbstractAppLogicListener) null);
    }

    protected AbstractMessageHandler(Context context2, AbstractAppLogicListener abstractAppLogicListener2) {
        if (context2 != null) {
            this.context = context2.getApplicationContext();
            this.abstractAppLogicListener = abstractAppLogicListener2;
            this.messageHandlerMap = new HashMap();
            this.messageHandlerMap.put(2, "MESSAGE_TYPE_PUSH_SERVICE_V2");
            this.messageHandlerMap.put(4, "MESSAGE_TYPE_PUSH_SERVICE_V3");
            this.messageHandlerMap.put(16, "MESSAGE_TYPE_REGISTER");
            this.messageHandlerMap.put(32, "MESSAGE_TYPE_UNREGISTER");
            this.messageHandlerMap.put(8, "MESSAGE_TYPE_THROUGH");
            this.messageHandlerMap.put(64, "MESSAGE_TYPE_NOTIFICATION_CLICK");
            this.messageHandlerMap.put(128, "MESSAGE_TYPE_NOTIFICATION_DELETE");
            this.messageHandlerMap.put(256, "MESSAGE_TYPE_PUSH_SWITCH_STATUS");
            this.messageHandlerMap.put(512, "MESSAGE_TYPE_PUSH_REGISTER_STATUS");
            this.messageHandlerMap.put(2048, "MESSAGE_TYPE_PUSH_SUBTAGS_STATUS");
            this.messageHandlerMap.put(1024, "MESSAGE_TYPE_PUSH_UNREGISTER_STATUS");
            this.messageHandlerMap.put(4096, "MESSAGE_TYPE_PUSH_SUBALIAS_STATUS");
            this.messageHandlerMap.put(8192, "MESSAGE_TYPE_SCHEDULE_NOTIFICATION");
            this.messageHandlerMap.put(16384, "MESSAGE_TYPE_RECEIVE_NOTIFY_MESSAGE");
            this.messageHandlerMap.put(32768, "MESSAGE_TYPE_NOTIFICATION_STATE");
            this.messageHandlerMap.put(65536, "MESSAGE_TYPE_UPLOAD_FILE_LOG");
            this.messageHandlerMap.put(131072, "MESSAGE_TYPE_NOTIFICATION_ARRIVED");
            return;
        }
        throw new IllegalArgumentException("Context must not be null.");
    }

    /* access modifiers changed from: protected */
    public String getDeviceId(Intent intent) {
        String stringExtra = intent != null ? intent.getStringExtra(PushConstants.MZ_PUSH_MESSAGE_STATISTICS_IMEI_KEY) : null;
        if (!TextUtils.isEmpty(stringExtra)) {
            return stringExtra;
        }
        String deviceId = MzSystemUtils.getDeviceId(context());
        DebugLogger.m4828e(TAG, "force get deviceId " + deviceId);
        return deviceId;
    }

    /* access modifiers changed from: protected */
    public String getTaskId(Intent intent) {
        return intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_TASK_ID);
    }

    /* access modifiers changed from: protected */
    public String getSeqId(Intent intent) {
        return intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_SEQ_ID);
    }

    /* access modifiers changed from: protected */
    public String getPushServiceDefaultPackageName(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_SERVICE_DEFAULT_PACKAGE_NAME);
        return TextUtils.isEmpty(stringExtra) ? context().getPackageName() : stringExtra;
    }

    /* access modifiers changed from: protected */
    public String getPushTimestamp(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_TASK_TIMES_TAMP);
        DebugLogger.m4828e(TAG, "receive push timestamp from pushservice " + stringExtra);
        return TextUtils.isEmpty(stringExtra) ? String.valueOf(System.currentTimeMillis() / 1000) : stringExtra;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0070, code lost:
        r0 = canSendMessage(r7);
        com.meizu.cloud.pushinternal.DebugLogger.m4828e(TAG, "can send message " + r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x008a, code lost:
        if (r1 == false) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x008c, code lost:
        if (r2 == false) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x008e, code lost:
        if (r0 == false) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0090, code lost:
        unsafeSend(r7, onCreateNotification(r7));
        onAfterEvent(r7);
        com.meizu.cloud.pushinternal.DebugLogger.m4828e(TAG, "send message end ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x004a, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x006f, code lost:
        r1 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean sendMessage(android.content.Intent r7) {
        /*
            r6 = this;
            boolean r0 = r6.messageMatch(r7)
            r1 = 0
            if (r0 == 0) goto L_0x00a1
            java.lang.String r0 = "AbstractMessageHandler"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "current message Type "
            r2.append(r3)
            int r3 = r6.getProcessorType()
            java.lang.String r3 = r6.getMessageHandlerType(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.meizu.cloud.pushinternal.DebugLogger.m4828e(r0, r2)
            java.lang.Object r7 = r6.getMessage(r7)
            java.lang.String r0 = "AbstractMessageHandler"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "current Handler message "
            r2.append(r3)
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            com.meizu.cloud.pushinternal.DebugLogger.m4828e(r0, r2)
            r6.onBeforeEvent(r7)
            int r0 = r6.scheduleNotificationStatus(r7)
            r2 = 1
            switch(r0) {
                case 0: goto L_0x0068;
                case 1: goto L_0x0060;
                case 2: goto L_0x0058;
                case 3: goto L_0x004c;
                default: goto L_0x004a;
            }
        L_0x004a:
            r2 = 0
            goto L_0x0070
        L_0x004c:
            java.lang.String r0 = "AbstractMessageHandler"
            java.lang.String r3 = "schedule notification"
            com.meizu.cloud.pushinternal.DebugLogger.m4828e(r0, r3)
            r6.scheduleShowNotification(r7)
            r1 = 1
            goto L_0x004a
        L_0x0058:
            java.lang.String r0 = "AbstractMessageHandler"
            java.lang.String r1 = "notification on time ,show message"
            com.meizu.cloud.pushinternal.DebugLogger.m4828e(r0, r1)
            goto L_0x006f
        L_0x0060:
            java.lang.String r0 = "AbstractMessageHandler"
            java.lang.String r2 = "expire notification, dont show message"
            com.meizu.cloud.pushinternal.DebugLogger.m4828e(r0, r2)
            goto L_0x004a
        L_0x0068:
            java.lang.String r0 = "AbstractMessageHandler"
            java.lang.String r1 = "schedule send message off, send message directly"
            com.meizu.cloud.pushinternal.DebugLogger.m4828e(r0, r1)
        L_0x006f:
            r1 = 1
        L_0x0070:
            boolean r0 = r6.canSendMessage(r7)
            java.lang.String r3 = "AbstractMessageHandler"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "can send message "
            r4.append(r5)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            com.meizu.cloud.pushinternal.DebugLogger.m4828e(r3, r4)
            if (r1 == 0) goto L_0x00a1
            if (r2 == 0) goto L_0x00a1
            if (r0 == 0) goto L_0x00a1
            com.meizu.cloud.pushsdk.notification.PushNotification r0 = r6.onCreateNotification(r7)
            r6.unsafeSend(r7, r0)
            r6.onAfterEvent(r7)
            java.lang.String r7 = "AbstractMessageHandler"
            java.lang.String r0 = "send message end "
            com.meizu.cloud.pushinternal.DebugLogger.m4828e(r7, r0)
        L_0x00a1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.handler.impl.AbstractMessageHandler.sendMessage(android.content.Intent):boolean");
    }

    public AbstractAppLogicListener appLogicListener() {
        return this.abstractAppLogicListener;
    }

    public Context context() {
        return this.context;
    }

    public String getIntentMethod(Intent intent) {
        return intent.getStringExtra(PushConstants.MZ_PUSH_MESSAGE_METHOD);
    }

    public boolean isNotificationJson(String str) {
        try {
            return context().getPackageName().equals(new JSONObject(str).getString("appId"));
        } catch (Exception unused) {
            DebugLogger.m4828e(TAG, "parse notification error");
            return false;
        }
    }

    public String getDeskTopNotificationPkg(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("launcher");
            if (!jSONObject.has("pkg") || TextUtils.isEmpty(jSONObject.getString("pkg"))) {
                return "";
            }
            return jSONObject.getString("pkg");
        } catch (Exception unused) {
            DebugLogger.m4828e(TAG, "parse desk top json error");
            return "";
        }
    }

    private String getMessageHandlerType(int i) {
        return this.messageHandlerMap.get(Integer.valueOf(i));
    }

    /* access modifiers changed from: protected */
    public boolean canReceiveMessage(int i, String str) {
        boolean z = true;
        if (i == 0) {
            z = PushPreferencesUtils.getNotificationMessageSwitchStatus(context(), str);
        } else if (i == 1) {
            z = PushPreferencesUtils.getThroughMessageSwitchStatus(context(), str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i == 0 ? " canNotificationMessage " : " canThroughMessage ");
        sb.append(z);
        DebugLogger.m4828e(TAG, sb.toString());
        return z;
    }

    /* access modifiers changed from: protected */
    public void clearNotifyOption(MessageV3 messageV3) {
        NotifyOption notifyOptionSetting = NotifyOption.getNotifyOptionSetting(messageV3);
        if (notifyOptionSetting != null) {
            DebugLogger.m4828e(TAG, "delete notifyKey " + notifyOptionSetting.getNotifyKey() + " notifyId " + notifyOptionSetting.getNotifyId());
            if (!TextUtils.isEmpty(notifyOptionSetting.getNotifyKey())) {
                NotificationUtils.removeNotifyKey(context(), messageV3.getUploadDataPackageName(), notifyOptionSetting.getNotifyKey());
            } else {
                NotificationUtils.removeNotifyIdByPackageName(context(), messageV3.getUploadDataPackageName(), notifyOptionSetting.getNotifyId());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void sendArrivedMessage(MessageV3 messageV3) {
        if (!MinSdkChecker.isSupportSetDrawableSmallIcon()) {
            appLogicListener().onNotificationArrived(context(), MzPushMessage.fromMessageV3(messageV3));
        } else if (MzSystemUtils.isRunningProcess(context(), messageV3.getUploadDataPackageName())) {
            DebugLogger.m4829i(TAG, "send notification arrived message to " + messageV3.getUploadDataPackageName());
            Intent intent = new Intent();
            intent.putExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE, messageV3);
            intent.putExtra(PushConstants.MZ_PUSH_MESSAGE_METHOD, PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_NOTIFICATION_ARRIVED);
            MzSystemUtils.sendMessageFromBroadcast(context(), intent, PushConstants.MZ_PUSH_ON_MESSAGE_ACTION, messageV3.getUploadDataPackageName());
        }
    }
}
