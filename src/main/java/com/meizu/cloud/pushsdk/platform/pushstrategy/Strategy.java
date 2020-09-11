package com.meizu.cloud.pushsdk.platform.pushstrategy;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.platform.api.PushAPI;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

public abstract class Strategy<T extends BasicPushStatus> {
    public static final String APP_ID = "app_id";
    public static final String APP_KEY = "app_key";
    public static final String DEVICE_ERROR_CODE = "20000";
    public static final String FEEDBACK_PARAMETER_ERROR_CODE = "20001";
    public static final String PUSH_ID = "push_id";
    public static final String STRATEGY_CHILD_TYPE = "strategy_child_type";
    public static final int STRATEGY_ClEAR_NOTIFICATION = 64;
    public static final String STRATEGY_PACKAGE_NANME = "strategy_package_name";
    public static final String STRATEGY_PARAMS = "strategy_params";
    public static final int STRATEGY_REGISTER = 2;
    public static final int STRATEGY_SUBALIAS = 8;
    public static final int STRATEGY_SUBTAGS = 4;
    public static final int STRATEGY_SWITCH = 16;
    public static final String STRATEGY_TYPE = "strategy_type";
    public static final int STRATEGY_UNREGISTER = 32;
    public static final String SUCCESS_CODE = "200";
    public static final String TAG = "Strategy";
    protected String appId;
    protected String appKey;
    protected Context context;
    protected volatile String deviceId;
    protected boolean enableRPC = true;
    protected ScheduledExecutorService executorService;
    protected boolean isSupportRemoteInvoke = true;
    private String managerServicePackageName = null;
    protected PushAPI pushAPI;
    protected String strategyPackageNanme;

    private boolean isServiceCode(int i) {
        return i >= 110000 && i <= 200000;
    }

    /* access modifiers changed from: protected */
    public abstract T feedBackErrorResponse();

    /* access modifiers changed from: protected */
    public abstract T localResponse();

    /* access modifiers changed from: protected */
    public abstract boolean matchCondition();

    /* access modifiers changed from: protected */
    public abstract T netWorkRequest();

    /* access modifiers changed from: protected */
    public abstract void sendReceiverMessage(T t);

    /* access modifiers changed from: protected */
    public abstract Intent sendRpcRequest();

    /* access modifiers changed from: protected */
    public Intent[] sendRpcRequests() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract int strategyType();

    public Strategy(Context context2, String str, String str2, PushAPI pushAPI2, ScheduledExecutorService scheduledExecutorService) {
        this.executorService = scheduledExecutorService;
        this.context = context2;
        this.appId = str;
        this.appKey = str2;
        this.pushAPI = pushAPI2;
    }

    public void setExecutorService(ScheduledExecutorService scheduledExecutorService) {
        this.executorService = scheduledExecutorService;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setAppKey(String str) {
        this.appKey = str;
    }

    public void setStrategyPackageNanme(String str) {
        this.strategyPackageNanme = str;
    }

    public void setSupportRemoteInvoke(boolean z) {
        this.isSupportRemoteInvoke = z;
    }

    /* access modifiers changed from: protected */
    public boolean supportServiceRpc() {
        return this.enableRPC && this.isSupportRemoteInvoke && !TextUtils.isEmpty(findService(this.context, PushConstants.MZ_PUSH_MANAGER_SERVICE_ACTION));
    }

    private boolean supportAllResponse() {
        return this.enableRPC && !this.context.getPackageName().equals(this.managerServicePackageName);
    }

    /* access modifiers changed from: protected */
    public boolean isRegisterStatus() {
        return 2 == strategyType() || 32 == strategyType();
    }

    public boolean process() {
        if (this.executorService == null) {
            return processMainThread();
        }
        this.executorService.execute(new Runnable() {
            public void run() {
                Strategy.this.processMainThread();
            }
        });
        return true;
    }

    public boolean processMainThread() {
        BasicPushStatus basicPushStatus;
        if (!matchCondition()) {
            DebugLogger.m4828e(TAG, "Missing required parameters");
            basicPushStatus = feedBackErrorResponse();
            sendReceiverMessage(basicPushStatus);
        } else if (!supportServiceRpc()) {
            basicPushStatus = netWorkRequest();
            DebugLogger.m4829i(TAG, "real response status " + basicPushStatus);
            if (basicPushStatus != null) {
                if (isRegisterStatus() && DEVICE_ERROR_CODE.equals(basicPushStatus.getCode())) {
                    return true;
                }
                if (supportAllResponse()) {
                    DebugLogger.m4828e(TAG, "response all request in local app");
                    sendReceiverMessage(basicPushStatus);
                } else {
                    String code = basicPushStatus.getCode();
                    if (TextUtils.isEmpty(code)) {
                        code = "0";
                    }
                    if ("200".equals(basicPushStatus.getCode())) {
                        sendReceiverMessage(basicPushStatus);
                    }
                    int intValue = Integer.valueOf(code).intValue();
                    if (isServiceCode(intValue)) {
                        DebugLogger.m4828e(TAG, "service error so notify pushManager invoker code=" + intValue + " message " + basicPushStatus.getMessage());
                        sendReceiverMessage(basicPushStatus);
                    }
                }
            }
        } else {
            DebugLogger.m4829i(TAG, "send message to remote service");
            if (!isRegisterStatus()) {
                basicPushStatus = localResponse();
                if (basicPushStatus != null) {
                    DebugLogger.m4828e(TAG, "local response " + basicPushStatus);
                    sendReceiverMessage(basicPushStatus);
                }
            } else {
                basicPushStatus = null;
            }
            Intent sendRpcRequest = sendRpcRequest();
            if (sendRpcRequest != null) {
                sendIntentMessage(sendRpcRequest);
            }
            Intent[] sendRpcRequests = sendRpcRequests();
            if (sendRpcRequests != null) {
                DebugLogger.m4828e(TAG, "send sendRpcRequests length " + sendRpcRequests.length);
                for (Intent sendIntentMessage : sendRpcRequests) {
                    sendIntentMessage(sendIntentMessage);
                }
            }
            MzSystemUtils.sendMessageFromBroadcast(this.context, new Intent("com.meizu.cloud.pushservice.action.PUSH_SERVICE_START"), (String) null, this.context.getPackageName());
        }
        if (basicPushStatus == null) {
            return true;
        }
        DebugLogger.m4828e(TAG, "current status code " + basicPushStatus.getCode());
        return true ^ isServerError(basicPushStatus);
    }

    private boolean isServerError(T t) {
        int intValue = Integer.valueOf(t.getCode()).intValue();
        return (intValue > 200 && intValue < 600) || (intValue > 1000 && intValue < 2000) || intValue == 0;
    }

    /* access modifiers changed from: protected */
    public String getDeviceId() {
        if (TextUtils.isEmpty(this.deviceId)) {
            this.deviceId = MzSystemUtils.getDeviceId(this.context);
            DebugLogger.m4828e(TAG, "deviceId " + this.deviceId);
        }
        return this.deviceId;
    }

    /* access modifiers changed from: protected */
    public String findService(Context context2, String str) {
        List<ResolveInfo> queryIntentServices;
        String str2 = null;
        if (!TextUtils.isEmpty(str) && (queryIntentServices = context2.getPackageManager().queryIntentServices(new Intent(str), 0)) != null) {
            Iterator<ResolveInfo> it = queryIntentServices.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ResolveInfo next = it.next();
                if ("com.meizu.cloud".equals(next.serviceInfo.packageName)) {
                    this.managerServicePackageName = next.serviceInfo.packageName;
                    str2 = next.serviceInfo.name;
                    break;
                }
            }
            if (TextUtils.isEmpty(str2) && queryIntentServices.size() > 0) {
                this.managerServicePackageName = queryIntentServices.get(0).serviceInfo.packageName;
                str2 = queryIntentServices.get(0).serviceInfo.name;
            }
        }
        DebugLogger.m4829i(TAG, "current process packageName " + this.managerServicePackageName);
        return str2;
    }

    /* access modifiers changed from: protected */
    public void sendIntentMessage(Intent intent) {
        try {
            intent.setPackage(this.managerServicePackageName);
            intent.setAction(PushConstants.MZ_PUSH_MANAGER_SERVICE_ACTION);
            this.context.startService(intent);
        } catch (Exception e) {
            DebugLogger.m4828e(TAG, "start RemoteService error " + e.getMessage());
        }
    }
}
