package com.meizu.cloud.pushsdk.handler.impl;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.AbstractAppLogicListener;
import com.meizu.cloud.pushsdk.notification.PushNotification;
import com.meizu.cloud.pushsdk.util.PushPreferencesUtils;

public class UnRegisterMessageHandler extends AbstractMessageHandler<Boolean> {
    public int getProcessorType() {
        return 32;
    }

    public UnRegisterMessageHandler(Context context, AbstractAppLogicListener abstractAppLogicListener) {
        super(context, abstractAppLogicListener);
    }

    /* access modifiers changed from: protected */
    public Boolean getMessage(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra(PushConstants.EXTRA_APP_IS_UNREGISTER_SUCCESS, false);
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_REGISTRATION_ERROR);
        String stringExtra2 = intent.getStringExtra(PushConstants.EXTRA_UNREGISTERED);
        DebugLogger.m4829i("AbstractMessageHandler", "processUnRegisterCallback 5.0:" + booleanExtra + " 4.0:" + stringExtra + " 3.0:" + stringExtra2);
        if (!TextUtils.isEmpty(stringExtra) && !booleanExtra && TextUtils.isEmpty(stringExtra2)) {
            return false;
        }
        PushPreferencesUtils.putPushId(context(), "", context().getPackageName());
        return true;
    }

    /* access modifiers changed from: protected */
    public void unsafeSend(Boolean bool, PushNotification pushNotification) {
        if (appLogicListener() != null) {
            appLogicListener().onUnRegister(context(), bool.booleanValue());
        }
    }

    public boolean messageMatch(Intent intent) {
        DebugLogger.m4829i("AbstractMessageHandler", "start UnRegisterMessageHandler match");
        return PushConstants.MZ_PUSH_ON_UNREGISTER_ACTION.equals(intent.getAction()) || (PushConstants.REQUEST_UNREGISTRATION_INTENT.equals(intent.getAction()) && TextUtils.isEmpty(intent.getStringExtra(PushConstants.EXTRA_UNREGISTERED)));
    }
}
