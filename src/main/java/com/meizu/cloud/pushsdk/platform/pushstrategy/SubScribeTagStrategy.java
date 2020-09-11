package com.meizu.cloud.pushsdk.platform.pushstrategy;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.networking.common.ANResponse;
import com.meizu.cloud.pushsdk.networking.error.ANError;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.api.PushAPI;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import java.util.concurrent.ScheduledExecutorService;

public class SubScribeTagStrategy extends Strategy<SubTagsStatus> {
    public static final int CHECK_SUB_TAGS = 3;
    public static final int SUB_TAGS = 0;
    public static final int UNSUB_ALL_TAGS = 2;
    public static final int UNSUB_TAGS = 1;
    private String pushId;
    private int subTagType;
    private String tags;

    /* access modifiers changed from: protected */
    public SubTagsStatus localResponse() {
        return null;
    }

    /* access modifiers changed from: protected */
    public int strategyType() {
        return 4;
    }

    public SubScribeTagStrategy(Context context, String str, String str2, PushAPI pushAPI, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, pushAPI, scheduledExecutorService);
        this.subTagType = 3;
    }

    public SubScribeTagStrategy(Context context, String str, String str2, String str3, PushAPI pushAPI, ScheduledExecutorService scheduledExecutorService) {
        this(context, str, str2, pushAPI, scheduledExecutorService);
        this.pushId = str3;
    }

    public SubScribeTagStrategy(Context context, PushAPI pushAPI, ScheduledExecutorService scheduledExecutorService) {
        this(context, (String) null, (String) null, (String) null, pushAPI, scheduledExecutorService);
    }

    public SubScribeTagStrategy(Context context, PushAPI pushAPI, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, pushAPI, scheduledExecutorService);
        this.enableRPC = z;
    }

    public void setSubTagType(int i) {
        this.subTagType = i;
    }

    public void setSubTags(String str) {
        this.tags = str;
    }

    public void setPushId(String str) {
        this.pushId = str;
    }

    /* access modifiers changed from: protected */
    public boolean matchCondition() {
        return !TextUtils.isEmpty(this.appId) && !TextUtils.isEmpty(this.appKey) && !TextUtils.isEmpty(this.pushId);
    }

    /* access modifiers changed from: protected */
    public SubTagsStatus feedBackErrorResponse() {
        SubTagsStatus subTagsStatus = new SubTagsStatus();
        subTagsStatus.setCode(Strategy.FEEDBACK_PARAMETER_ERROR_CODE);
        if (TextUtils.isEmpty(this.appId)) {
            subTagsStatus.setMessage("appId not empty");
        } else if (TextUtils.isEmpty(this.appKey)) {
            subTagsStatus.setMessage("appKey not empty");
        } else if (TextUtils.isEmpty(this.pushId)) {
            subTagsStatus.setMessage("pushId not empty");
        }
        return subTagsStatus;
    }

    /* access modifiers changed from: protected */
    public Intent sendRpcRequest() {
        Intent intent = new Intent();
        intent.putExtra("app_id", this.appId);
        intent.putExtra(Strategy.APP_KEY, this.appKey);
        intent.putExtra(Strategy.STRATEGY_PACKAGE_NANME, this.context.getPackageName());
        intent.putExtra(Strategy.PUSH_ID, this.pushId);
        intent.putExtra(Strategy.STRATEGY_TYPE, strategyType());
        intent.putExtra(Strategy.STRATEGY_CHILD_TYPE, this.subTagType);
        intent.putExtra(Strategy.STRATEGY_PARAMS, this.tags);
        return intent;
    }

    /* access modifiers changed from: protected */
    public SubTagsStatus netWorkRequest() {
        ANResponse aNResponse;
        SubTagsStatus subTagsStatus = new SubTagsStatus();
        switch (this.subTagType) {
            case 0:
                aNResponse = this.pushAPI.subScribeTags(this.appId, this.appKey, this.pushId, this.tags);
                break;
            case 1:
                aNResponse = this.pushAPI.unSubScribeTags(this.appId, this.appKey, this.pushId, this.tags);
                break;
            case 2:
                aNResponse = this.pushAPI.unSubAllScribeTags(this.appId, this.appKey, this.pushId);
                break;
            case 3:
                aNResponse = this.pushAPI.checkSubScribeTags(this.appId, this.appKey, this.pushId);
                break;
            default:
                aNResponse = null;
                break;
        }
        if (aNResponse.isSuccess()) {
            SubTagsStatus subTagsStatus2 = new SubTagsStatus((String) aNResponse.getResult());
            DebugLogger.m4828e(Strategy.TAG, "network subTagsStatus " + subTagsStatus2);
            return subTagsStatus2;
        }
        ANError error = aNResponse.getError();
        if (error.getResponse() != null) {
            DebugLogger.m4828e(Strategy.TAG, "status code=" + error.getErrorCode() + " data=" + error.getResponse());
        }
        subTagsStatus.setCode(String.valueOf(error.getErrorCode()));
        subTagsStatus.setMessage(error.getErrorBody());
        DebugLogger.m4828e(Strategy.TAG, "subTagsStatus " + subTagsStatus);
        return subTagsStatus;
    }

    /* access modifiers changed from: protected */
    public void sendReceiverMessage(SubTagsStatus subTagsStatus) {
        PlatformMessageSender.sendSubTags(this.context, !TextUtils.isEmpty(this.strategyPackageNanme) ? this.strategyPackageNanme : this.context.getPackageName(), subTagsStatus);
    }
}
