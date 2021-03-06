package com.meizu.cloud.pushsdk.handler.impl.platform;

import android.content.Context;
import android.content.Intent;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.AbstractAppLogicListener;
import com.meizu.cloud.pushsdk.handler.impl.AbstractMessageHandler;
import com.meizu.cloud.pushsdk.notification.PushNotification;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;

public class SubScribeTagsStatusHandler extends AbstractMessageHandler<SubTagsStatus> {
    public int getProcessorType() {
        return 2048;
    }

    public SubScribeTagsStatusHandler(Context context, AbstractAppLogicListener abstractAppLogicListener) {
        super(context, abstractAppLogicListener);
    }

    /* access modifiers changed from: protected */
    public SubTagsStatus getMessage(Intent intent) {
        return (SubTagsStatus) intent.getSerializableExtra(PushConstants.EXTRA_APP_PUSH_SUBTAGS_STATUS);
    }

    /* access modifiers changed from: protected */
    public void unsafeSend(SubTagsStatus subTagsStatus, PushNotification pushNotification) {
        if (appLogicListener() != null && subTagsStatus != null) {
            appLogicListener().onSubTagsStatus(context(), subTagsStatus);
        }
    }

    public boolean messageMatch(Intent intent) {
        DebugLogger.m4829i("AbstractMessageHandler", "start SubScribeTagsStatusHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_SUBTAGS_STATUS.equals(getIntentMethod(intent));
    }
}
