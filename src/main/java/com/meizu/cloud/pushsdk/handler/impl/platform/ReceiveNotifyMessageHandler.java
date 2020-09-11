package com.meizu.cloud.pushsdk.handler.impl.platform;

import android.content.Context;
import android.content.Intent;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.AbstractAppLogicListener;
import com.meizu.cloud.pushsdk.handler.impl.AbstractMessageHandler;
import com.meizu.cloud.pushsdk.notification.PushNotification;

public class ReceiveNotifyMessageHandler extends AbstractMessageHandler<String> {
    public int getProcessorType() {
        return 16384;
    }

    public ReceiveNotifyMessageHandler(Context context, AbstractAppLogicListener abstractAppLogicListener) {
        super(context, abstractAppLogicListener);
    }

    /* access modifiers changed from: protected */
    public String getMessage(Intent intent) {
        return intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_RESPONSE_NOTIFICATION_MESSAGE);
    }

    /* access modifiers changed from: protected */
    public void unsafeSend(String str, PushNotification pushNotification) {
        if (appLogicListener() != null && str != null) {
            appLogicListener().onNotifyMessageArrived(context(), str);
        }
    }

    public boolean messageMatch(Intent intent) {
        DebugLogger.m4829i("AbstractMessageHandler", "start ReceiveNotifyMessageHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_RESPONSE_NOTIFICATION_MESSAGE.equals(getIntentMethod(intent));
    }
}
