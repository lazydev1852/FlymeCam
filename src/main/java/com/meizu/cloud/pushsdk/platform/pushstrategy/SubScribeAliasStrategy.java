package com.meizu.cloud.pushsdk.platform.pushstrategy;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.api.PushAPI;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import com.meizu.cloud.pushsdk.util.PushPreferencesUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

public class SubScribeAliasStrategy extends Strategy<SubAliasStatus> {
    public static final int CHECK_ALIAS = 2;
    public static final int SUB_ALIAS = 0;
    public static final int UNSUB_ALIAS = 1;
    private String alias;
    private Map<String, Boolean> aliasStatusMap;
    private String pushId;
    private int subAliasType;

    /* access modifiers changed from: protected */
    public int strategyType() {
        return 8;
    }

    public SubScribeAliasStrategy(Context context, String str, String str2, PushAPI pushAPI, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, pushAPI, scheduledExecutorService);
        this.aliasStatusMap = new HashMap();
    }

    public SubScribeAliasStrategy(Context context, String str, String str2, String str3, PushAPI pushAPI, ScheduledExecutorService scheduledExecutorService) {
        this(context, str, str2, pushAPI, scheduledExecutorService);
        this.pushId = str3;
    }

    public SubScribeAliasStrategy(Context context, PushAPI pushAPI, ScheduledExecutorService scheduledExecutorService) {
        this(context, (String) null, (String) null, (String) null, pushAPI, scheduledExecutorService);
    }

    public SubScribeAliasStrategy(Context context, PushAPI pushAPI, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, pushAPI, scheduledExecutorService);
        this.enableRPC = z;
    }

    public void setSubAliasType(int i) {
        this.subAliasType = i;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public void setPushId(String str) {
        this.pushId = str;
    }

    /* access modifiers changed from: protected */
    public boolean matchCondition() {
        return !TextUtils.isEmpty(this.appId) && !TextUtils.isEmpty(this.appKey) && !TextUtils.isEmpty(this.pushId);
    }

    /* access modifiers changed from: protected */
    public SubAliasStatus feedBackErrorResponse() {
        SubAliasStatus subAliasStatus = new SubAliasStatus();
        subAliasStatus.setCode(Strategy.FEEDBACK_PARAMETER_ERROR_CODE);
        if (TextUtils.isEmpty(this.appId)) {
            subAliasStatus.setMessage("appId not empty");
        } else if (TextUtils.isEmpty(this.appKey)) {
            subAliasStatus.setMessage("appKey not empty");
        } else if (TextUtils.isEmpty(this.pushId)) {
            subAliasStatus.setMessage("pushId not empty");
        }
        return subAliasStatus;
    }

    /* access modifiers changed from: protected */
    public Intent sendRpcRequest() {
        if (this.subAliasType == 2) {
            return null;
        }
        Intent intent = new Intent();
        intent.putExtra("app_id", this.appId);
        intent.putExtra(Strategy.APP_KEY, this.appKey);
        intent.putExtra(Strategy.STRATEGY_PACKAGE_NANME, this.context.getPackageName());
        intent.putExtra(Strategy.PUSH_ID, this.pushId);
        intent.putExtra(Strategy.STRATEGY_TYPE, strategyType());
        intent.putExtra(Strategy.STRATEGY_CHILD_TYPE, this.subAliasType);
        intent.putExtra(Strategy.STRATEGY_PARAMS, this.alias);
        return intent;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.meizu.cloud.pushsdk.platform.message.SubAliasStatus netWorkRequest() {
        /*
            r6 = this;
            com.meizu.cloud.pushsdk.platform.message.SubAliasStatus r0 = new com.meizu.cloud.pushsdk.platform.message.SubAliasStatus
            r0.<init>()
            java.lang.String r1 = r6.pushId
            r0.setPushId(r1)
            java.lang.String r1 = ""
            r0.setMessage(r1)
            int r1 = r6.subAliasType
            r2 = 1
            switch(r1) {
                case 0: goto L_0x005d;
                case 1: goto L_0x0025;
                case 2: goto L_0x0017;
                default: goto L_0x0015;
            }
        L_0x0015:
            goto L_0x0097
        L_0x0017:
            java.lang.String r1 = r6.localAlias()
            r0.setAlias(r1)
            java.lang.String r1 = "200"
            r0.setCode(r1)
            goto L_0x0097
        L_0x0025:
            java.lang.String r1 = r6.localAlias()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0040
            boolean r1 = r6.isSyncAliasStatus()
            if (r1 != 0) goto L_0x0040
            java.lang.String r1 = "200"
            r0.setCode(r1)
            java.lang.String r1 = ""
            r0.setAlias(r1)
            goto L_0x0097
        L_0x0040:
            r6.changeSyncAliasStatus(r2)
            boolean r1 = r6.isCacheAlias()
            if (r1 == 0) goto L_0x004e
            java.lang.String r1 = ""
            r6.storeAlias(r1)
        L_0x004e:
            com.meizu.cloud.pushsdk.platform.api.PushAPI r1 = r6.pushAPI
            java.lang.String r2 = r6.appId
            java.lang.String r3 = r6.appKey
            java.lang.String r4 = r6.pushId
            java.lang.String r5 = r6.alias
            com.meizu.cloud.pushsdk.networking.common.ANResponse r1 = r1.unSubScribeAlias(r2, r3, r4, r5)
            goto L_0x0098
        L_0x005d:
            java.lang.String r1 = r6.alias
            java.lang.String r3 = r6.localAlias()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x007a
            boolean r1 = r6.isSyncAliasStatus()
            if (r1 != 0) goto L_0x007a
            java.lang.String r1 = "200"
            r0.setCode(r1)
            java.lang.String r1 = r6.alias
            r0.setAlias(r1)
            goto L_0x0097
        L_0x007a:
            r6.changeSyncAliasStatus(r2)
            boolean r1 = r6.isCacheAlias()
            if (r1 == 0) goto L_0x0088
            java.lang.String r1 = r6.alias
            r6.storeAlias(r1)
        L_0x0088:
            com.meizu.cloud.pushsdk.platform.api.PushAPI r1 = r6.pushAPI
            java.lang.String r2 = r6.appId
            java.lang.String r3 = r6.appKey
            java.lang.String r4 = r6.pushId
            java.lang.String r5 = r6.alias
            com.meizu.cloud.pushsdk.networking.common.ANResponse r1 = r1.subScribeAlias(r2, r3, r4, r5)
            goto L_0x0098
        L_0x0097:
            r1 = 0
        L_0x0098:
            if (r1 == 0) goto L_0x012a
            boolean r2 = r1.isSuccess()
            if (r2 == 0) goto L_0x00d2
            com.meizu.cloud.pushsdk.platform.message.SubAliasStatus r0 = new com.meizu.cloud.pushsdk.platform.message.SubAliasStatus
            java.lang.Object r1 = r1.getResult()
            java.lang.String r1 = (java.lang.String) r1
            r0.<init>(r1)
            java.lang.String r1 = "Strategy"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "network subAliasStatus "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.meizu.cloud.pushinternal.DebugLogger.m4828e(r1, r2)
            java.lang.String r1 = "200"
            java.lang.String r2 = r0.getCode()
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x012a
            r1 = 0
            r6.changeSyncAliasStatus(r1)
            goto L_0x012a
        L_0x00d2:
            com.meizu.cloud.pushsdk.networking.error.ANError r1 = r1.getError()
            com.meizu.cloud.pushsdk.networking.http.Response r2 = r1.getResponse()
            if (r2 == 0) goto L_0x0102
            java.lang.String r2 = "Strategy"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "status code="
            r3.append(r4)
            int r4 = r1.getErrorCode()
            r3.append(r4)
            java.lang.String r4 = " data="
            r3.append(r4)
            com.meizu.cloud.pushsdk.networking.http.Response r4 = r1.getResponse()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.meizu.cloud.pushinternal.DebugLogger.m4828e(r2, r3)
        L_0x0102:
            int r2 = r1.getErrorCode()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r0.setCode(r2)
            java.lang.String r1 = r1.getErrorBody()
            r0.setMessage(r1)
            java.lang.String r1 = "Strategy"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "subAliasStatus "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.meizu.cloud.pushinternal.DebugLogger.m4828e(r1, r2)
        L_0x012a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.platform.pushstrategy.SubScribeAliasStrategy.netWorkRequest():com.meizu.cloud.pushsdk.platform.message.SubAliasStatus");
    }

    /* access modifiers changed from: protected */
    public SubAliasStatus localResponse() {
        if (this.subAliasType != 2) {
            return null;
        }
        SubAliasStatus subAliasStatus = new SubAliasStatus();
        subAliasStatus.setCode("200");
        subAliasStatus.setPushId(this.pushId);
        subAliasStatus.setAlias(localAlias());
        subAliasStatus.setMessage("check alias success");
        return subAliasStatus;
    }

    /* access modifiers changed from: protected */
    public void sendReceiverMessage(SubAliasStatus subAliasStatus) {
        PlatformMessageSender.sendSubAlias(this.context, !TextUtils.isEmpty(this.strategyPackageNanme) ? this.strategyPackageNanme : this.context.getPackageName(), subAliasStatus);
    }

    private void storeAlias(String str) {
        PushPreferencesUtils.setAlias(this.context, !TextUtils.isEmpty(this.strategyPackageNanme) ? this.strategyPackageNanme : this.context.getPackageName(), str);
    }

    private String localAlias() {
        return PushPreferencesUtils.getAlias(this.context, !TextUtils.isEmpty(this.strategyPackageNanme) ? this.strategyPackageNanme : this.context.getPackageName());
    }

    private void changeSyncAliasStatus(boolean z) {
        Map<String, Boolean> map = this.aliasStatusMap;
        map.put(this.strategyPackageNanme + "_" + this.subAliasType, Boolean.valueOf(z));
    }

    private boolean isSyncAliasStatus() {
        Map<String, Boolean> map = this.aliasStatusMap;
        Boolean bool = map.get(this.strategyPackageNanme + "_" + this.subAliasType);
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    private boolean isCacheAlias() {
        return !this.isSupportRemoteInvoke && "com.meizu.cloud".equals(this.strategyPackageNanme);
    }
}
