package com.meizu.cloud.pushsdk.handler.impl.platform;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.AbstractAppLogicListener;
import com.meizu.cloud.pushsdk.handler.impl.AbstractMessageHandler;
import com.meizu.cloud.pushsdk.notification.PushNotification;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.util.PushPreferencesUtils;

public class RegisterStatusHandler extends AbstractMessageHandler<RegisterStatus> {
    public int getProcessorType() {
        return 512;
    }

    public RegisterStatusHandler(Context context, AbstractAppLogicListener abstractAppLogicListener) {
        super(context, abstractAppLogicListener);
    }

    /* access modifiers changed from: protected */
    public RegisterStatus getMessage(Intent intent) {
        RegisterStatus registerStatus = (RegisterStatus) intent.getSerializableExtra(PushConstants.EXTRA_APP_PUSH_REGISTER_STATUS);
        if (!TextUtils.isEmpty(registerStatus.getPushId())) {
            PushPreferencesUtils.putPushId(context(), registerStatus.getPushId(), context().getPackageName());
            PushPreferencesUtils.putPushIdExpireTime(context(), (int) ((System.currentTimeMillis() / 1000) + ((long) registerStatus.getExpireTime())), context().getPackageName());
        }
        return registerStatus;
    }

    /* access modifiers changed from: protected */
    public void unsafeSend(RegisterStatus registerStatus, PushNotification pushNotification) {
        if (appLogicListener() != null && registerStatus != null) {
            appLogicListener().onRegisterStatus(context(), registerStatus);
        }
    }

    public boolean messageMatch(Intent intent) {
        DebugLogger.m4829i("AbstractMessageHandler", "start RegisterStatusHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_REGISTER_STATUS.equals(getIntentMethod(intent));
    }
}
