package com.meizu.cloud.pushsdk.platform.pushstrategy;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.api.PushAPI;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.meizu.cloud.pushsdk.util.PushPreferencesUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

public class SwitchStatusStrategy extends Strategy<PushSwitchStatus> {
    public static final int CHECK_PUSH = 2;
    public static final int SWITCH_ALL = 3;
    public static final int SWITCH_NOTIFICATION = 0;
    public static final int SWITCH_THROUGH_MESSAGE = 1;
    private String pushId;
    private Map<String, Boolean> pushStatusMap;
    private int switchType;
    boolean switcher;

    /* access modifiers changed from: protected */
    public int strategyType() {
        return 16;
    }

    public SwitchStatusStrategy(Context context, String str, String str2, PushAPI pushAPI, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, pushAPI, scheduledExecutorService);
        this.switchType = 0;
        this.pushStatusMap = new HashMap();
    }

    public SwitchStatusStrategy(Context context, String str, String str2, String str3, PushAPI pushAPI, ScheduledExecutorService scheduledExecutorService) {
        this(context, str, str2, pushAPI, scheduledExecutorService);
        this.pushId = str3;
    }

    public SwitchStatusStrategy(Context context, PushAPI pushAPI, ScheduledExecutorService scheduledExecutorService) {
        this(context, (String) null, (String) null, (String) null, pushAPI, scheduledExecutorService);
    }

    public SwitchStatusStrategy(Context context, PushAPI pushAPI, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, pushAPI, scheduledExecutorService);
        this.enableRPC = z;
    }

    public void setSwitcher(boolean z) {
        this.switcher = z;
    }

    public void setSwitchType(int i) {
        this.switchType = i;
    }

    public void setPushId(String str) {
        this.pushId = str;
    }

    /* access modifiers changed from: protected */
    public boolean matchCondition() {
        return !TextUtils.isEmpty(this.appId) && !TextUtils.isEmpty(this.appKey) && !TextUtils.isEmpty(this.pushId);
    }

    /* access modifiers changed from: protected */
    public PushSwitchStatus feedBackErrorResponse() {
        PushSwitchStatus pushSwitchStatus = new PushSwitchStatus();
        pushSwitchStatus.setCode(Strategy.FEEDBACK_PARAMETER_ERROR_CODE);
        if (TextUtils.isEmpty(this.appId)) {
            pushSwitchStatus.setMessage("appId not empty");
        } else if (TextUtils.isEmpty(this.appKey)) {
            pushSwitchStatus.setMessage("appKey not empty");
        } else if (TextUtils.isEmpty(this.pushId)) {
            pushSwitchStatus.setMessage("pushId not empty");
        }
        return pushSwitchStatus;
    }

    /* access modifiers changed from: protected */
    public Intent sendRpcRequest() {
        Intent intent = new Intent();
        intent.putExtra("app_id", this.appId);
        intent.putExtra(Strategy.APP_KEY, this.appKey);
        intent.putExtra(Strategy.STRATEGY_PACKAGE_NANME, this.context.getPackageName());
        intent.putExtra(Strategy.PUSH_ID, this.pushId);
        intent.putExtra(Strategy.STRATEGY_TYPE, strategyType());
        intent.putExtra(Strategy.STRATEGY_CHILD_TYPE, this.switchType);
        intent.putExtra(Strategy.STRATEGY_PARAMS, this.switcher ? "1" : "0");
        return intent;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus netWorkRequest() {
        /*
            r9 = this;
            com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus r0 = new com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus
            r0.<init>()
            java.lang.String r1 = r9.pushId
            r0.setPushId(r1)
            java.lang.String r1 = "200"
            r0.setCode(r1)
            int r1 = r9.switchType
            r2 = 1
            switch(r1) {
                case 0: goto L_0x00c7;
                case 1: goto L_0x008e;
                case 2: goto L_0x0056;
                case 3: goto L_0x0017;
                default: goto L_0x0015;
            }
        L_0x0015:
            goto L_0x0100
        L_0x0017:
            java.lang.String r1 = "SWITCH_ALL"
            r0.setMessage(r1)
            boolean r1 = r9.notificationSwitch()
            boolean r3 = r9.switcher
            if (r1 != r3) goto L_0x003e
            boolean r1 = r9.throughMessageSwitch()
            boolean r3 = r9.switcher
            if (r1 != r3) goto L_0x003e
            boolean r1 = r9.isSyncPushStatus()
            if (r1 != 0) goto L_0x003e
            boolean r1 = r9.switcher
            r0.setSwitchNotificationMessage(r1)
            boolean r1 = r9.switcher
            r0.setSwitchThroughMessage(r1)
            goto L_0x0100
        L_0x003e:
            r9.changeSyncPushStatus(r2)
            boolean r1 = r9.switcher
            r9.switchAll(r1)
            com.meizu.cloud.pushsdk.platform.api.PushAPI r1 = r9.pushAPI
            java.lang.String r3 = r9.appId
            java.lang.String r4 = r9.appKey
            java.lang.String r5 = r9.pushId
            boolean r6 = r9.switcher
            com.meizu.cloud.pushsdk.networking.common.ANResponse r1 = r1.switchPush(r3, r4, r5, r6)
            goto L_0x0101
        L_0x0056:
            java.lang.String r1 = "CHECK_PUSH"
            r0.setMessage(r1)
            boolean r1 = r9.hasNotificationSwitch()
            if (r1 == 0) goto L_0x007d
            boolean r1 = r9.hasThroughMessageSwitch()
            if (r1 == 0) goto L_0x007d
            boolean r1 = r9.isSyncPushStatus()
            if (r1 != 0) goto L_0x007d
            boolean r1 = r9.notificationSwitch()
            r0.setSwitchNotificationMessage(r1)
            boolean r1 = r9.throughMessageSwitch()
            r0.setSwitchThroughMessage(r1)
            goto L_0x0100
        L_0x007d:
            r9.changeSyncPushStatus(r2)
            com.meizu.cloud.pushsdk.platform.api.PushAPI r1 = r9.pushAPI
            java.lang.String r3 = r9.appId
            java.lang.String r4 = r9.appKey
            java.lang.String r5 = r9.pushId
            com.meizu.cloud.pushsdk.networking.common.ANResponse r1 = r1.checkPush(r3, r4, r5)
            goto L_0x0101
        L_0x008e:
            java.lang.String r1 = "SWITCH_THROUGH_MESSAGE"
            r0.setMessage(r1)
            boolean r1 = r9.throughMessageSwitch()
            boolean r3 = r9.switcher
            if (r1 != r3) goto L_0x00ae
            boolean r1 = r9.isSyncPushStatus()
            if (r1 != 0) goto L_0x00ae
            boolean r1 = r9.notificationSwitch()
            r0.setSwitchNotificationMessage(r1)
            boolean r1 = r9.switcher
            r0.setSwitchThroughMessage(r1)
            goto L_0x0100
        L_0x00ae:
            r9.changeSyncPushStatus(r2)
            boolean r1 = r9.switcher
            r9.switchThroughMessage(r1)
            com.meizu.cloud.pushsdk.platform.api.PushAPI r3 = r9.pushAPI
            java.lang.String r4 = r9.appId
            java.lang.String r5 = r9.appKey
            java.lang.String r6 = r9.pushId
            int r7 = r9.switchType
            boolean r8 = r9.switcher
            com.meizu.cloud.pushsdk.networking.common.ANResponse r1 = r3.switchPush((java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (int) r7, (boolean) r8)
            goto L_0x0101
        L_0x00c7:
            java.lang.String r1 = "SWITCH_NOTIFICATION"
            r0.setMessage(r1)
            boolean r1 = r9.notificationSwitch()
            boolean r3 = r9.switcher
            if (r1 != r3) goto L_0x00e7
            boolean r1 = r9.isSyncPushStatus()
            if (r1 != 0) goto L_0x00e7
            boolean r1 = r9.switcher
            r0.setSwitchNotificationMessage(r1)
            boolean r1 = r9.throughMessageSwitch()
            r0.setSwitchThroughMessage(r1)
            goto L_0x0100
        L_0x00e7:
            r9.changeSyncPushStatus(r2)
            boolean r1 = r9.switcher
            r9.switchNotification(r1)
            com.meizu.cloud.pushsdk.platform.api.PushAPI r3 = r9.pushAPI
            java.lang.String r4 = r9.appId
            java.lang.String r5 = r9.appKey
            java.lang.String r6 = r9.pushId
            int r7 = r9.switchType
            boolean r8 = r9.switcher
            com.meizu.cloud.pushsdk.networking.common.ANResponse r1 = r3.switchPush((java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (int) r7, (boolean) r8)
            goto L_0x0101
        L_0x0100:
            r1 = 0
        L_0x0101:
            r3 = 0
            if (r1 == 0) goto L_0x01b6
            boolean r4 = r1.isSuccess()
            if (r4 == 0) goto L_0x015e
            com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus r4 = new com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus
            java.lang.Object r1 = r1.getResult()
            java.lang.String r1 = (java.lang.String) r1
            r4.<init>(r1)
            java.lang.String r1 = "Strategy"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "network pushSwitchStatus "
            r5.append(r6)
            r5.append(r4)
            java.lang.String r5 = r5.toString()
            com.meizu.cloud.pushinternal.DebugLogger.m4828e(r1, r5)
            java.lang.String r1 = "200"
            java.lang.String r5 = r0.getCode()
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x01b6
            r9.changeSyncPushStatus(r3)
            java.lang.String r1 = "Strategy"
            java.lang.String r5 = "update local switch preference"
            com.meizu.cloud.pushinternal.DebugLogger.m4828e(r1, r5)
            boolean r1 = r4.isSwitchNotificationMessage()
            r0.setSwitchNotificationMessage(r1)
            boolean r1 = r4.isSwitchThroughMessage()
            r0.setSwitchThroughMessage(r1)
            boolean r1 = r4.isSwitchNotificationMessage()
            r9.switchNotification(r1)
            boolean r1 = r4.isSwitchThroughMessage()
            r9.switchThroughMessage(r1)
            goto L_0x01b6
        L_0x015e:
            com.meizu.cloud.pushsdk.networking.error.ANError r1 = r1.getError()
            com.meizu.cloud.pushsdk.networking.http.Response r4 = r1.getResponse()
            if (r4 == 0) goto L_0x018e
            java.lang.String r4 = "Strategy"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "status code="
            r5.append(r6)
            int r6 = r1.getErrorCode()
            r5.append(r6)
            java.lang.String r6 = " data="
            r5.append(r6)
            com.meizu.cloud.pushsdk.networking.http.Response r6 = r1.getResponse()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.meizu.cloud.pushinternal.DebugLogger.m4828e(r4, r5)
        L_0x018e:
            int r4 = r1.getErrorCode()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r0.setCode(r4)
            java.lang.String r1 = r1.getErrorBody()
            r0.setMessage(r1)
            java.lang.String r1 = "Strategy"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "pushSwitchStatus "
            r4.append(r5)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            com.meizu.cloud.pushinternal.DebugLogger.m4828e(r1, r4)
        L_0x01b6:
            java.lang.String r1 = "Strategy"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "enableRPC "
            r4.append(r5)
            boolean r5 = r9.enableRPC
            r4.append(r5)
            java.lang.String r5 = " isSupportRemoteInvoke "
            r4.append(r5)
            boolean r5 = r9.isSupportRemoteInvoke
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.meizu.cloud.pushinternal.DebugLogger.m4828e(r1, r4)
            boolean r1 = r9.enableRPC
            if (r1 == 0) goto L_0x0207
            boolean r1 = r9.isSupportRemoteInvoke
            if (r1 != 0) goto L_0x0207
            int r1 = r9.switchType
            r4 = 3
            if (r1 == r4) goto L_0x01f5
            switch(r1) {
                case 0: goto L_0x01e9;
                case 1: goto L_0x01e9;
                default: goto L_0x01e8;
            }
        L_0x01e8:
            goto L_0x0207
        L_0x01e9:
            android.content.Context r1 = r9.context
            int r2 = r9.switchType
            boolean r3 = r9.switcher
            java.lang.String r4 = r9.strategyPackageNanme
            com.meizu.cloud.pushsdk.platform.PlatformMessageSender.switchPushMessageSetting(r1, r2, r3, r4)
            goto L_0x0207
        L_0x01f5:
            android.content.Context r1 = r9.context
            boolean r4 = r9.switcher
            java.lang.String r5 = r9.strategyPackageNanme
            com.meizu.cloud.pushsdk.platform.PlatformMessageSender.switchPushMessageSetting(r1, r3, r4, r5)
            android.content.Context r1 = r9.context
            boolean r3 = r9.switcher
            java.lang.String r4 = r9.strategyPackageNanme
            com.meizu.cloud.pushsdk.platform.PlatformMessageSender.switchPushMessageSetting(r1, r2, r3, r4)
        L_0x0207:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.platform.pushstrategy.SwitchStatusStrategy.netWorkRequest():com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus");
    }

    /* access modifiers changed from: protected */
    public PushSwitchStatus localResponse() {
        switch (this.switchType) {
            case 0:
                switchNotification(this.switcher);
                return null;
            case 1:
                switchThroughMessage(this.switcher);
                return null;
            case 3:
                switchAll(this.switcher);
                return null;
            default:
                return null;
        }
    }

    /* access modifiers changed from: protected */
    public void sendReceiverMessage(PushSwitchStatus pushSwitchStatus) {
        PlatformMessageSender.sendPushStatus(this.context, !TextUtils.isEmpty(this.strategyPackageNanme) ? this.strategyPackageNanme : this.context.getPackageName(), pushSwitchStatus);
    }

    private void switchNotification(boolean z) {
        PushPreferencesUtils.setNotificationMessageSwitchStatus(this.context, !TextUtils.isEmpty(this.strategyPackageNanme) ? this.strategyPackageNanme : this.context.getPackageName(), z);
    }

    private void switchThroughMessage(boolean z) {
        PushPreferencesUtils.setThroughMessageSwitchStatus(this.context, !TextUtils.isEmpty(this.strategyPackageNanme) ? this.strategyPackageNanme : this.context.getPackageName(), z);
    }

    private void switchAll(boolean z) {
        PushPreferencesUtils.setNotificationMessageSwitchStatus(this.context, !TextUtils.isEmpty(this.strategyPackageNanme) ? this.strategyPackageNanme : this.context.getPackageName(), z);
        PushPreferencesUtils.setThroughMessageSwitchStatus(this.context, !TextUtils.isEmpty(this.strategyPackageNanme) ? this.strategyPackageNanme : this.context.getPackageName(), z);
    }

    private boolean notificationSwitch() {
        return PushPreferencesUtils.getNotificationMessageSwitchStatus(this.context, !TextUtils.isEmpty(this.strategyPackageNanme) ? this.strategyPackageNanme : this.context.getPackageName());
    }

    private boolean hasNotificationSwitch() {
        return PushPreferencesUtils.hasNotificationSwitchStatus(this.context, !TextUtils.isEmpty(this.strategyPackageNanme) ? this.strategyPackageNanme : this.context.getPackageName());
    }

    private boolean throughMessageSwitch() {
        return PushPreferencesUtils.getThroughMessageSwitchStatus(this.context, !TextUtils.isEmpty(this.strategyPackageNanme) ? this.strategyPackageNanme : this.context.getPackageName());
    }

    private boolean hasThroughMessageSwitch() {
        return PushPreferencesUtils.hasThroughMessageSwitchStatus(this.context, !TextUtils.isEmpty(this.strategyPackageNanme) ? this.strategyPackageNanme : this.context.getPackageName());
    }

    private void changeSyncPushStatus(boolean z) {
        Map<String, Boolean> map = this.pushStatusMap;
        map.put(this.strategyPackageNanme + "_" + this.switchType, Boolean.valueOf(z));
    }

    private boolean isSyncPushStatus() {
        Map<String, Boolean> map = this.pushStatusMap;
        Boolean bool = map.get(this.strategyPackageNanme + "_" + this.switchType);
        boolean booleanValue = bool != null ? bool.booleanValue() : true;
        DebugLogger.m4828e(Strategy.TAG, "isSyncPushStatus " + this.strategyPackageNanme + " switch type->" + this.switchType + " flag->" + booleanValue);
        return booleanValue;
    }
}
