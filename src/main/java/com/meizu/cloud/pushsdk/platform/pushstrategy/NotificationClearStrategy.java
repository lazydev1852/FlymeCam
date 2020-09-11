package com.meizu.cloud.pushsdk.platform.pushstrategy;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.notification.util.NotificationUtils;
import com.meizu.cloud.pushsdk.platform.api.PushAPI;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
import java.util.concurrent.ScheduledExecutorService;

public class NotificationClearStrategy extends Strategy {
    public static final int CLEAR_ALL = 0;
    public static final int CLEAR_NOTIFY_ID = 1;
    public static final int CLEAR_NOTIFY_KEY = 2;
    private int clearType;
    private int[] notifyId;
    private String notifyKey;

    /* access modifiers changed from: protected */
    public BasicPushStatus feedBackErrorResponse() {
        return null;
    }

    /* access modifiers changed from: protected */
    public BasicPushStatus localResponse() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void sendReceiverMessage(BasicPushStatus basicPushStatus) {
    }

    /* access modifiers changed from: protected */
    public int strategyType() {
        return 64;
    }

    public NotificationClearStrategy(Context context, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, (String) null, (String) null, (PushAPI) null, scheduledExecutorService);
        this.enableRPC = z;
    }

    public NotificationClearStrategy(Context context, String str, String str2, PushAPI pushAPI, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, pushAPI, scheduledExecutorService);
        this.isSupportRemoteInvoke = MinSdkChecker.isSupportSetDrawableSmallIcon();
    }

    public void setNotifyId(int... iArr) {
        this.notifyId = iArr;
    }

    public void setClearType(int i) {
        this.clearType = i;
    }

    public void setNotifyKey(String str) {
        this.notifyKey = str;
    }

    /* access modifiers changed from: protected */
    public boolean matchCondition() {
        if (this.clearType == 0) {
            return true;
        }
        if (this.notifyId != null && this.notifyId.length > 0 && this.clearType == 1) {
            return true;
        }
        if (this.clearType != 2 || TextUtils.isEmpty(this.notifyKey)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public Intent sendRpcRequest() {
        Intent intent = new Intent();
        intent.putExtra(Strategy.STRATEGY_PACKAGE_NANME, this.context.getPackageName());
        intent.putExtra(Strategy.STRATEGY_TYPE, strategyType());
        intent.putExtra(Strategy.STRATEGY_CHILD_TYPE, this.clearType);
        if (this.clearType == 2) {
            intent.putExtra(Strategy.STRATEGY_PARAMS, this.notifyKey);
            return intent;
        } else if (this.clearType == 1) {
            return null;
        } else {
            return intent;
        }
    }

    /* access modifiers changed from: protected */
    public Intent[] sendRpcRequests() {
        if (this.notifyId == null) {
            return null;
        }
        Intent[] intentArr = new Intent[this.notifyId.length];
        for (int i = 0; i < this.notifyId.length; i++) {
            DebugLogger.m4829i(Strategy.TAG, "send notifyId " + this.notifyId[i] + " to PushManagerService");
            Intent intent = new Intent();
            intent.putExtra(Strategy.STRATEGY_PACKAGE_NANME, this.context.getPackageName());
            intent.putExtra(Strategy.STRATEGY_TYPE, strategyType());
            intent.putExtra(Strategy.STRATEGY_CHILD_TYPE, this.clearType);
            intent.putExtra(Strategy.STRATEGY_PARAMS, "" + this.notifyId[i]);
            intentArr[i] = intent;
        }
        return intentArr;
    }

    /* access modifiers changed from: protected */
    public BasicPushStatus netWorkRequest() {
        switch (this.clearType) {
            case 0:
                if (!MinSdkChecker.isSupportSetDrawableSmallIcon()) {
                    DebugLogger.m4828e(Strategy.TAG, "android 6.0 blow so cancel all by context");
                    NotificationUtils.clearAllNotification(this.context);
                }
                NotificationUtils.clearNotification(this.context, this.strategyPackageNanme);
                return null;
            case 1:
                if (this.notifyId == null) {
                    return null;
                }
                for (int i : this.notifyId) {
                    DebugLogger.m4828e(Strategy.TAG, "clear notifyId " + i);
                    NotificationUtils.clearNotification(this.context, this.strategyPackageNanme, i);
                }
                return null;
            case 2:
                NotificationUtils.removeNotifyKey(this.context, this.strategyPackageNanme, this.notifyKey);
                return null;
            default:
                return null;
        }
    }
}
