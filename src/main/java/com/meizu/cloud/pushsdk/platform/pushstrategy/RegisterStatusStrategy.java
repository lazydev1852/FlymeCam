package com.meizu.cloud.pushsdk.platform.pushstrategy;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.networking.common.ANResponse;
import com.meizu.cloud.pushsdk.networking.error.ANError;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.PushIdEncryptUtils;
import com.meizu.cloud.pushsdk.platform.api.PushAPI;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.pushtracer.emitter.classic.Executor;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import com.meizu.cloud.pushsdk.util.PushPreferencesUtils;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RegisterStatusStrategy extends Strategy<RegisterStatus> {
    protected int deviceIdRetry;
    protected Handler mainHandler;
    protected ScheduledExecutorService scheduledExecutorService;

    /* access modifiers changed from: protected */
    public RegisterStatus localResponse() {
        return null;
    }

    /* access modifiers changed from: protected */
    public int strategyType() {
        return 2;
    }

    public RegisterStatusStrategy(Context context, String str, String str2, PushAPI pushAPI, ScheduledExecutorService scheduledExecutorService2) {
        super(context, str, str2, pushAPI, scheduledExecutorService2);
        this.deviceIdRetry = 0;
    }

    public RegisterStatusStrategy(Context context, PushAPI pushAPI, ScheduledExecutorService scheduledExecutorService2) {
        this(context, (String) null, (String) null, pushAPI, scheduledExecutorService2);
        this.scheduledExecutorService = (ScheduledExecutorService) Executor.getExecutor();
        this.mainHandler = new Handler(context.getMainLooper()) {
            public void handleMessage(Message message) {
                if (message.what == 0) {
                    RegisterStatusStrategy.this.process();
                }
            }
        };
    }

    public RegisterStatusStrategy(Context context, PushAPI pushAPI, ScheduledExecutorService scheduledExecutorService2, boolean z) {
        this(context, pushAPI, scheduledExecutorService2);
        this.enableRPC = z;
    }

    public boolean matchCondition() {
        DebugLogger.m4828e(Strategy.TAG, "isBrandMeizu " + MzSystemUtils.isBrandMeizu(this.context));
        return !TextUtils.isEmpty(this.appId) && !TextUtils.isEmpty(this.appKey);
    }

    /* access modifiers changed from: protected */
    public RegisterStatus feedBackErrorResponse() {
        RegisterStatus registerStatus = new RegisterStatus();
        registerStatus.setCode(Strategy.FEEDBACK_PARAMETER_ERROR_CODE);
        if (TextUtils.isEmpty(this.appId)) {
            registerStatus.setMessage("appId not empty");
        } else if (TextUtils.isEmpty(this.appKey)) {
            registerStatus.setMessage("appKey not empty");
        }
        return registerStatus;
    }

    public Intent sendRpcRequest() {
        Intent intent = new Intent();
        intent.putExtra("app_id", this.appId);
        intent.putExtra(Strategy.APP_KEY, this.appKey);
        intent.putExtra(Strategy.STRATEGY_PACKAGE_NANME, this.context.getPackageName());
        intent.putExtra(Strategy.STRATEGY_TYPE, strategyType());
        return intent;
    }

    public RegisterStatus netWorkRequest() {
        RegisterStatus registerStatus = new RegisterStatus();
        String pushId = PushPreferencesUtils.getPushId(this.context, this.strategyPackageNanme);
        int pushIdExpireTime = PushPreferencesUtils.getPushIdExpireTime(this.context, this.strategyPackageNanme);
        if (!retryRegister(pushId, pushIdExpireTime)) {
            registerStatus.setCode("200");
            registerStatus.setMessage("already register PushId,dont register frequently");
            registerStatus.setPushId(pushId);
            registerStatus.setExpireTime((int) (((long) pushIdExpireTime) - (System.currentTimeMillis() / 1000)));
        } else {
            PushPreferencesUtils.putPushId(this.context, "", this.strategyPackageNanme);
            this.deviceId = getDeviceId();
            if (!TextUtils.isEmpty(this.deviceId) || this.deviceIdRetry >= 3) {
                this.deviceIdRetry = 0;
                ANResponse register = this.pushAPI.register(this.appId, this.appKey, this.deviceId);
                if (register.isSuccess()) {
                    registerStatus = new RegisterStatus((String) register.getResult());
                    DebugLogger.m4828e(Strategy.TAG, "registerStatus " + registerStatus);
                    if (!TextUtils.isEmpty(registerStatus.getPushId())) {
                        PushPreferencesUtils.putPushId(this.context, registerStatus.getPushId(), this.strategyPackageNanme);
                        PushPreferencesUtils.putPushIdExpireTime(this.context, (int) ((System.currentTimeMillis() / 1000) + ((long) registerStatus.getExpireTime())), this.strategyPackageNanme);
                    }
                } else {
                    ANError error = register.getError();
                    if (error.getResponse() != null) {
                        DebugLogger.m4828e(Strategy.TAG, "status code=" + error.getErrorCode() + " data=" + error.getResponse());
                    }
                    registerStatus.setCode(String.valueOf(error.getErrorCode()));
                    registerStatus.setMessage(error.getErrorBody());
                    DebugLogger.m4828e(Strategy.TAG, "registerStatus " + registerStatus);
                }
            } else {
                DebugLogger.m4829i(Strategy.TAG, "after " + (this.deviceIdRetry * 10) + " seconds start register");
                executeAfterGetDeviceId((long) (this.deviceIdRetry * 10));
                this.deviceIdRetry = this.deviceIdRetry + 1;
                registerStatus.setCode(Strategy.DEVICE_ERROR_CODE);
                registerStatus.setMessage("deviceId is empty");
            }
        }
        return registerStatus;
    }

    public void sendReceiverMessage(RegisterStatus registerStatus) {
        PlatformMessageSender.sendRegisterStatus(this.context, !TextUtils.isEmpty(this.strategyPackageNanme) ? this.strategyPackageNanme : this.context.getPackageName(), registerStatus);
    }

    /* access modifiers changed from: protected */
    public void executeAfterGetDeviceId(long j) {
        this.scheduledExecutorService.schedule(new Runnable() {
            public void run() {
                RegisterStatusStrategy.this.getDeviceId();
                RegisterStatusStrategy.this.mainHandler.sendEmptyMessage(0);
            }
        }, j, TimeUnit.SECONDS);
    }

    /* access modifiers changed from: protected */
    public boolean retryRegister(String str, int i) {
        String deviceId = getDeviceId();
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(deviceId) || (!str.startsWith(deviceId) && (TextUtils.isEmpty(PushIdEncryptUtils.decryptPushId(str)) || !PushIdEncryptUtils.decryptPushId(str).startsWith(deviceId))) || System.currentTimeMillis() / 1000 >= ((long) i);
    }
}
