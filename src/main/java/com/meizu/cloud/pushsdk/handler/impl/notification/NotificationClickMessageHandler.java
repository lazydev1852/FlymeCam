package com.meizu.cloud.pushsdk.handler.impl.notification;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.AbstractAppLogicListener;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import com.meizu.cloud.pushsdk.handler.impl.AbstractMessageHandler;
import com.meizu.cloud.pushsdk.handler.impl.model.PlatformMessage;
import com.meizu.cloud.pushsdk.notification.MPushMessage;
import com.meizu.cloud.pushsdk.notification.PushNotification;
import com.meizu.cloud.pushsdk.notification.model.NotifyOption;
import com.meizu.cloud.pushsdk.platform.api.PushPlatformManager;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
import com.meizu.cloud.pushsdk.util.PushPreferencesUtils;
import com.meizu.cloud.pushsdk.util.UxIPUtils;
import java.util.Map;

public class NotificationClickMessageHandler extends AbstractMessageHandler<MessageV3> {
    public int getProcessorType() {
        return 64;
    }

    public NotificationClickMessageHandler(Context context, AbstractAppLogicListener abstractAppLogicListener) {
        super(context, abstractAppLogicListener);
    }

    /* access modifiers changed from: protected */
    public MessageV3 getMessage(Intent intent) {
        try {
            DebugLogger.m4828e("AbstractMessageHandler", "parse message V3");
            MessageV3 messageV3 = (MessageV3) intent.getParcelableExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE);
            if (messageV3 != null) {
                return messageV3;
            }
        } catch (Exception unused) {
            DebugLogger.m4828e("AbstractMessageHandler", "cannot get messageV3");
        } catch (Throwable th) {
            DebugLogger.m4828e("AbstractMessageHandler", "parse MessageV2 to MessageV3");
            MPushMessage mPushMessage = (MPushMessage) intent.getSerializableExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE);
            MessageV3.parse(getPushServiceDefaultPackageName(intent), getDeviceId(intent), mPushMessage.getTaskId(), mPushMessage);
            throw th;
        }
        DebugLogger.m4828e("AbstractMessageHandler", "parse MessageV2 to MessageV3");
        MPushMessage mPushMessage2 = (MPushMessage) intent.getSerializableExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE);
        return MessageV3.parse(getPushServiceDefaultPackageName(intent), getDeviceId(intent), mPushMessage2.getTaskId(), mPushMessage2);
    }

    /* access modifiers changed from: protected */
    public void unsafeSend(MessageV3 messageV3, PushNotification pushNotification) {
        PushPreferencesUtils.putDiscardNotificationIdByPackageName(context(), messageV3.getPackageName(), 0);
        Intent buildIntent = buildIntent(context(), messageV3);
        if (buildIntent != null) {
            buildIntent.addFlags(268435456);
            try {
                context().startActivity(buildIntent);
            } catch (Exception e) {
                DebugLogger.m4828e("AbstractMessageHandler", "Click message StartActivity error " + e.getMessage());
            }
        }
        if (!TextUtils.isEmpty(messageV3.getTitle()) && !TextUtils.isEmpty(messageV3.getContent()) && appLogicListener() != null) {
            appLogicListener().onNotificationClicked(context(), MzPushMessage.fromMessageV3(messageV3));
        }
        if (!MinSdkChecker.isSupportSetDrawableSmallIcon()) {
            clearNotifyOption(messageV3);
            return;
        }
        NotifyOption notifyOptionSetting = NotifyOption.getNotifyOptionSetting(messageV3);
        if (notifyOptionSetting != null) {
            DebugLogger.m4828e("AbstractMessageHandler", "delete notifyId " + notifyOptionSetting.getNotifyId() + " notifyKey " + notifyOptionSetting.getNotifyKey());
            if (!TextUtils.isEmpty(notifyOptionSetting.getNotifyKey())) {
                PushPlatformManager.getInstance(context()).clearNotifyKey(messageV3.getUploadDataPackageName(), notifyOptionSetting.getNotifyKey());
                return;
            }
            PushPlatformManager.getInstance(context()).clearNotification(messageV3.getUploadDataPackageName(), notifyOptionSetting.getNotifyId());
        }
    }

    public boolean messageMatch(Intent intent) {
        DebugLogger.m4829i("AbstractMessageHandler", "start NotificationClickMessageHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE.equals(getIntentMethod(intent));
    }

    /* access modifiers changed from: protected */
    public void onBeforeEvent(MessageV3 messageV3) {
        UxIPUtils.onClickPushMessageEvent(context(), messageV3.getUploadDataPackageName(), TextUtils.isEmpty(messageV3.getDeviceId()) ? getDeviceId((Intent) null) : messageV3.getDeviceId(), messageV3.getTaskId(), messageV3.getSeqId(), messageV3.getPushTimestamp());
    }

    private Intent buildIntent(Context context, MessageV3 messageV3) {
        Intent intent;
        String uriPackageName = messageV3.getUriPackageName();
        if (TextUtils.isEmpty(uriPackageName)) {
            uriPackageName = messageV3.getUploadDataPackageName();
        }
        DebugLogger.m4829i("AbstractMessageHandler", "openClassName is " + uriPackageName);
        if (messageV3.getClickType() == 0) {
            intent = context.getPackageManager().getLaunchIntentForPackage(uriPackageName);
            if (!(intent == null || messageV3.getParamsMap() == null)) {
                for (Map.Entry next : messageV3.getParamsMap().entrySet()) {
                    DebugLogger.m4829i("AbstractMessageHandler", " launcher activity key " + ((String) next.getKey()) + " value " + ((String) next.getValue()));
                    if (!TextUtils.isEmpty((CharSequence) next.getKey()) && !TextUtils.isEmpty((CharSequence) next.getValue())) {
                        intent.putExtra((String) next.getKey(), (String) next.getValue());
                    }
                }
            }
        } else if (1 == messageV3.getClickType()) {
            intent = new Intent();
            if (messageV3.getParamsMap() != null) {
                for (Map.Entry next2 : messageV3.getParamsMap().entrySet()) {
                    DebugLogger.m4829i("AbstractMessageHandler", " key " + ((String) next2.getKey()) + " value " + ((String) next2.getValue()));
                    if (!TextUtils.isEmpty((CharSequence) next2.getKey()) && !TextUtils.isEmpty((CharSequence) next2.getValue())) {
                        intent.putExtra((String) next2.getKey(), (String) next2.getValue());
                    }
                }
            }
            intent.setClassName(uriPackageName, messageV3.getActivity());
            DebugLogger.m4829i("AbstractMessageHandler", intent.toUri(1));
        } else if (2 == messageV3.getClickType()) {
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(messageV3.getWebUrl()));
            String uriPackageName2 = messageV3.getUriPackageName();
            if (!TextUtils.isEmpty(uriPackageName2)) {
                intent2.setPackage(uriPackageName2);
                DebugLogger.m4829i("AbstractMessageHandler", "set uri package " + uriPackageName2);
            }
            intent = intent2;
        } else {
            if (3 == messageV3.getClickType()) {
                DebugLogger.m4829i("AbstractMessageHandler", "CLICK_TYPE_SELF_DEFINE_ACTION");
            }
            intent = null;
        }
        if (intent != null) {
            intent.putExtra(PushConstants.MZ_PUSH_PLATFROM_EXTRA, PlatformMessage.builder().taskId(messageV3.getTaskId()).build().toJson());
        }
        return intent;
    }
}
