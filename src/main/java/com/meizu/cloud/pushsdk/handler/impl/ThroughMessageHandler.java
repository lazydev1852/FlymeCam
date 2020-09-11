package com.meizu.cloud.pushsdk.handler.impl;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.AbstractAppLogicListener;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.handler.impl.model.PlatformMessage;
import com.meizu.cloud.pushsdk.notification.PushNotification;
import com.meizu.cloud.pushsdk.util.UxIPUtils;

public class ThroughMessageHandler extends AbstractMessageHandler<MessageV3> {
    public int getProcessorType() {
        return 8;
    }

    public ThroughMessageHandler(Context context, AbstractAppLogicListener abstractAppLogicListener) {
        super(context, abstractAppLogicListener);
    }

    public boolean messageMatch(Intent intent) {
        DebugLogger.m4829i("AbstractMessageHandler", "start ThroughMessageHandler match");
        if (!canReceiveMessage(1, getPushServiceDefaultPackageName(intent))) {
            return false;
        }
        if (PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction())) {
            if ("message".equals(getIntentMethod(intent))) {
                return true;
            }
            if (TextUtils.isEmpty(getIntentMethod(intent))) {
                String stringExtra = intent.getStringExtra("message");
                if (!TextUtils.isEmpty(stringExtra) && !isNotificationJson(stringExtra)) {
                    return true;
                }
            }
        }
        return PushConstants.C2DM_INTENT.equals(intent.getAction());
    }

    /* access modifiers changed from: protected */
    public MessageV3 getMessage(Intent intent) {
        MessageV3 messageV3 = new MessageV3();
        if (PushConstants.C2DM_INTENT.equals(intent.getAction())) {
            appLogicListener().onMessage(context(), intent);
            return null;
        }
        messageV3.setThroughMessage(intent.getStringExtra("message"));
        messageV3.setTaskId(getTaskId(intent));
        messageV3.setDeviceId(getDeviceId(intent));
        messageV3.setSeqId(getSeqId(intent));
        messageV3.setPushTimestamp(getPushTimestamp(intent));
        messageV3.setUploadDataPackageName(getPushServiceDefaultPackageName(intent));
        return messageV3;
    }

    /* access modifiers changed from: protected */
    public void unsafeSend(MessageV3 messageV3, PushNotification pushNotification) {
        if (appLogicListener() != null && messageV3 != null && !TextUtils.isEmpty(messageV3.getThroughMessage())) {
            appLogicListener().onMessage(context(), messageV3.getThroughMessage());
            appLogicListener().onMessage(context(), messageV3.getThroughMessage(), PlatformMessage.builder().taskId(messageV3.getTaskId()).seqId(messageV3.getSeqId()).pushTimesTamp(messageV3.getPushTimestamp()).deviceId(messageV3.getDeviceId()).build().toJson());
        }
    }

    /* access modifiers changed from: protected */
    public void onBeforeEvent(MessageV3 messageV3) {
        if (messageV3 != null && !TextUtils.isEmpty(messageV3.getDeviceId()) && !TextUtils.isEmpty(messageV3.getTaskId())) {
            String deskTopNotificationPkg = getDeskTopNotificationPkg(messageV3.getThroughMessage());
            if (!TextUtils.isEmpty(deskTopNotificationPkg)) {
                UxIPUtils.onReceiveThroughMessage(context(), deskTopNotificationPkg, messageV3.getDeviceId(), messageV3.getTaskId(), messageV3.getSeqId(), messageV3.getPushTimestamp());
            } else {
                UxIPUtils.onReceiveThroughMessage(context(), messageV3.getUploadDataPackageName(), messageV3.getDeviceId(), messageV3.getTaskId(), messageV3.getSeqId(), messageV3.getPushTimestamp());
            }
        }
    }
}
