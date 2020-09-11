package com.meizu.cloud.pushsdk.handler.impl.platform;

import android.content.Context;
import android.content.Intent;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.AbstractAppLogicListener;
import com.meizu.cloud.pushsdk.handler.impl.AbstractMessageHandler;
import com.meizu.cloud.pushsdk.notification.PushNotification;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.meizu.cloud.pushsdk.util.PushPreferencesUtils;

public class PushSwitchStatusHandler extends AbstractMessageHandler<PushSwitchStatus> {
    public int getProcessorType() {
        return 256;
    }

    public PushSwitchStatusHandler(Context context, AbstractAppLogicListener abstractAppLogicListener) {
        super(context, abstractAppLogicListener);
    }

    /* access modifiers changed from: protected */
    public PushSwitchStatus getMessage(Intent intent) {
        PushSwitchStatus pushSwitchStatus = (PushSwitchStatus) intent.getSerializableExtra(PushConstants.EXTRA_APP_PUSH_SWITCH_STATUS);
        if ("200".equals(pushSwitchStatus.getCode())) {
            String pushServiceDefaultPackageName = getPushServiceDefaultPackageName(intent);
            DebugLogger.m4828e("AbstractMessageHandler", "PushSwitchStatusHandler update local " + pushServiceDefaultPackageName + " switch status " + pushSwitchStatus);
            PushPreferencesUtils.setNotificationMessageSwitchStatus(context(), pushServiceDefaultPackageName, pushSwitchStatus.isSwitchNotificationMessage());
            PushPreferencesUtils.setThroughMessageSwitchStatus(context(), pushServiceDefaultPackageName, pushSwitchStatus.isSwitchThroughMessage());
        }
        return pushSwitchStatus;
    }

    /* access modifiers changed from: protected */
    public void unsafeSend(PushSwitchStatus pushSwitchStatus, PushNotification pushNotification) {
        if (appLogicListener() != null && pushSwitchStatus != null) {
            appLogicListener().onPushStatus(context(), pushSwitchStatus);
        }
    }

    public boolean messageMatch(Intent intent) {
        DebugLogger.m4829i("AbstractMessageHandler", "start PushSwitchStatusHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PUSH_STATUS.equals(getIntentMethod(intent));
    }
}
