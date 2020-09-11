package com.meizu.cloud.pushsdk.handler.impl;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.AbstractAppLogicListener;
import com.meizu.cloud.pushsdk.notification.PushNotification;
import com.meizu.cloud.pushsdk.util.PushPreferencesUtils;

public class RegisterMessageHandler extends AbstractMessageHandler<String> {
    public int getProcessorType() {
        return 16;
    }

    public RegisterMessageHandler(Context context, AbstractAppLogicListener abstractAppLogicListener) {
        super(context, abstractAppLogicListener);
    }

    /* access modifiers changed from: protected */
    public String getMessage(Intent intent) {
        String stringExtra = intent.getStringExtra("registration_id");
        PushPreferencesUtils.putPushId(context(), stringExtra, context().getPackageName());
        PushPreferencesUtils.putPushIdExpireTime(context(), 0, context().getPackageName());
        return stringExtra;
    }

    /* access modifiers changed from: protected */
    public void unsafeSend(String str, PushNotification pushNotification) {
        if (appLogicListener() != null) {
            appLogicListener().onRegister(context(), str);
        }
    }

    public boolean messageMatch(Intent intent) {
        DebugLogger.m4829i("AbstractMessageHandler", "start RegisterMessageHandler match");
        return PushConstants.MZ_PUSH_ON_REGISTER_ACTION.equals(intent.getAction()) || (PushConstants.REGISTRATION_CALLBACK_INTENT.equals(intent.getAction()) && !TextUtils.isEmpty(intent.getStringExtra("registration_id")));
    }
}
