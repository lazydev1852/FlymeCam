package com.meizu.cloud.pushsdk.handler.impl.platform;

import android.content.Context;
import android.content.Intent;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.AbstractAppLogicListener;
import com.meizu.cloud.pushsdk.handler.impl.AbstractMessageHandler;
import com.meizu.cloud.pushsdk.notification.PushNotification;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;
import com.meizu.cloud.pushsdk.util.PushPreferencesUtils;

public class UnRegisterStatusHandler extends AbstractMessageHandler<UnRegisterStatus> {
    public int getProcessorType() {
        return 1024;
    }

    public UnRegisterStatusHandler(Context context, AbstractAppLogicListener abstractAppLogicListener) {
        super(context, abstractAppLogicListener);
    }

    /* access modifiers changed from: protected */
    public UnRegisterStatus getMessage(Intent intent) {
        UnRegisterStatus unRegisterStatus = (UnRegisterStatus) intent.getSerializableExtra(PushConstants.EXTRA_APP_PUSH_UNREGISTER_STATUS);
        if (unRegisterStatus.isUnRegisterSuccess()) {
            PushPreferencesUtils.putPushId(context(), "", context().getPackageName());
        }
        return unRegisterStatus;
    }

    /* access modifiers changed from: protected */
    public void unsafeSend(UnRegisterStatus unRegisterStatus, PushNotification pushNotification) {
        if (appLogicListener() != null && unRegisterStatus != null) {
            appLogicListener().onUnRegisterStatus(context(), unRegisterStatus);
        }
    }

    public boolean messageMatch(Intent intent) {
        DebugLogger.m4829i("AbstractMessageHandler", "start UnRegisterStatusHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_UNREGISTER_STATUS.equals(getIntentMethod(intent));
    }
}
