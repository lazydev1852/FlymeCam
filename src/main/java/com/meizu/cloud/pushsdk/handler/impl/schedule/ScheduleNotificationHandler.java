package com.meizu.cloud.pushsdk.handler.impl.schedule;

import android.content.Context;
import android.content.Intent;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.AbstractAppLogicListener;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.handler.impl.MessageV3Handler;
import com.meizu.cloud.pushsdk.notification.PushNotification;
import com.meizu.cloud.pushsdk.util.UxIPUtils;

public class ScheduleNotificationHandler extends MessageV3Handler {
    public int getProcessorType() {
        return 8192;
    }

    /* access modifiers changed from: protected */
    public int scheduleNotificationStatus(MessageV3 messageV3) {
        return 0;
    }

    public ScheduleNotificationHandler(Context context, AbstractAppLogicListener abstractAppLogicListener) {
        super(context, abstractAppLogicListener);
    }

    /* access modifiers changed from: protected */
    public MessageV3 getMessage(Intent intent) {
        return (MessageV3) intent.getParcelableExtra(PushConstants.EXTRA_APP_PUSH_SCHEDULE_NOTIFICATION_MESSAGE);
    }

    /* access modifiers changed from: protected */
    public void unsafeSend(MessageV3 messageV3, PushNotification pushNotification) {
        if (pushNotification != null) {
            pushNotification.show(messageV3);
            sendArrivedMessage(messageV3);
        }
    }

    public boolean messageMatch(Intent intent) {
        DebugLogger.m4829i("AbstractMessageHandler", "start ScheduleNotificationHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_SCHEDULE_NOTIFICATION.equals(getIntentMethod(intent));
    }

    /* access modifiers changed from: protected */
    public void onBeforeEvent(MessageV3 messageV3) {
        DebugLogger.m4828e("AbstractMessageHandler", "ScheduleNotificationHandler dont repeat upload receiver push event");
    }

    /* access modifiers changed from: protected */
    public void onAfterEvent(MessageV3 messageV3) {
        UxIPUtils.onShowPushMessageEvent(context(), messageV3.getUploadDataPackageName(), messageV3.getDeviceId(), messageV3.getTaskId(), messageV3.getSeqId(), messageV3.getPushTimestamp());
    }
}
