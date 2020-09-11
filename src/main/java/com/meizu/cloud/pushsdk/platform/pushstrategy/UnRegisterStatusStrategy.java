package com.meizu.cloud.pushsdk.platform.pushstrategy;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.networking.common.ANResponse;
import com.meizu.cloud.pushsdk.networking.error.ANError;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.api.PushAPI;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;
import com.meizu.cloud.pushsdk.util.PushPreferencesUtils;
import java.util.concurrent.ScheduledExecutorService;

public class UnRegisterStatusStrategy extends Strategy<UnRegisterStatus> {
    /* access modifiers changed from: protected */
    public UnRegisterStatus localResponse() {
        return null;
    }

    /* access modifiers changed from: protected */
    public int strategyType() {
        return 32;
    }

    public UnRegisterStatusStrategy(Context context, String str, String str2, PushAPI pushAPI, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, pushAPI, scheduledExecutorService);
    }

    public UnRegisterStatusStrategy(Context context, PushAPI pushAPI, ScheduledExecutorService scheduledExecutorService) {
        this(context, (String) null, (String) null, pushAPI, scheduledExecutorService);
    }

    public UnRegisterStatusStrategy(Context context, PushAPI pushAPI, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, pushAPI, scheduledExecutorService);
        this.enableRPC = z;
    }

    /* access modifiers changed from: protected */
    public boolean matchCondition() {
        return !TextUtils.isEmpty(this.appId) && !TextUtils.isEmpty(this.appKey);
    }

    /* access modifiers changed from: protected */
    public UnRegisterStatus feedBackErrorResponse() {
        UnRegisterStatus unRegisterStatus = new UnRegisterStatus();
        unRegisterStatus.setCode(Strategy.FEEDBACK_PARAMETER_ERROR_CODE);
        if (TextUtils.isEmpty(this.appId)) {
            unRegisterStatus.setMessage("appId not empty");
        } else if (TextUtils.isEmpty(this.appKey)) {
            unRegisterStatus.setMessage("appKey not empty");
        }
        return unRegisterStatus;
    }

    /* access modifiers changed from: protected */
    public Intent sendRpcRequest() {
        Intent intent = new Intent();
        intent.putExtra("app_id", this.appId);
        intent.putExtra(Strategy.APP_KEY, this.appKey);
        intent.putExtra(Strategy.STRATEGY_PACKAGE_NANME, this.context.getPackageName());
        intent.putExtra(Strategy.STRATEGY_TYPE, strategyType());
        return intent;
    }

    /* access modifiers changed from: protected */
    public UnRegisterStatus netWorkRequest() {
        UnRegisterStatus unRegisterStatus = new UnRegisterStatus();
        if (TextUtils.isEmpty(PushPreferencesUtils.getPushId(this.context, this.strategyPackageNanme))) {
            unRegisterStatus.setCode("200");
            unRegisterStatus.setMessage("already unRegister PushId,dont unRegister frequently");
            unRegisterStatus.setIsUnRegisterSuccess(true);
        } else {
            this.deviceId = getDeviceId();
            ANResponse unRegister = this.pushAPI.unRegister(this.appId, this.appKey, this.deviceId);
            if (unRegister.isSuccess()) {
                unRegisterStatus = new UnRegisterStatus((String) unRegister.getResult());
                DebugLogger.m4828e(Strategy.TAG, "network unRegisterStatus " + unRegisterStatus);
                if ("200".equals(unRegisterStatus.getCode())) {
                    PushPreferencesUtils.putPushId(this.context, "", this.strategyPackageNanme);
                }
            } else {
                ANError error = unRegister.getError();
                if (error.getResponse() != null) {
                    DebugLogger.m4828e(Strategy.TAG, "status code=" + error.getErrorCode() + " data=" + error.getResponse());
                }
                unRegisterStatus.setCode(String.valueOf(error.getErrorCode()));
                unRegisterStatus.setMessage(error.getErrorBody());
                DebugLogger.m4828e(Strategy.TAG, "unRegisterStatus " + unRegisterStatus);
            }
        }
        return unRegisterStatus;
    }

    /* access modifiers changed from: protected */
    public void sendReceiverMessage(UnRegisterStatus unRegisterStatus) {
        PlatformMessageSender.sendUnRegisterStatus(this.context, !TextUtils.isEmpty(this.strategyPackageNanme) ? this.strategyPackageNanme : this.context.getPackageName(), unRegisterStatus);
    }
}
