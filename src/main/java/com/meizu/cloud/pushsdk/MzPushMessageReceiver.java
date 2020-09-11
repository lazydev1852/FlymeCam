package com.meizu.cloud.pushsdk;

import android.content.Context;
import android.content.Intent;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.base.IntentReceiver;
import com.meizu.cloud.pushsdk.handler.AbstractAppLogicListener;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;
import com.meizu.cloud.pushsdk.util.UxIPUtils;

public abstract class MzPushMessageReceiver extends IntentReceiver {
    public static final String TAG = "MzPushMessageReceiver";

    public void onMessage(Context context, Intent intent) {
    }

    public void onMessage(Context context, String str) {
    }

    public void onMessage(Context context, String str, String str2) {
    }

    public void onNotificationArrived(Context context, MzPushMessage mzPushMessage) {
    }

    public void onNotificationClicked(Context context, MzPushMessage mzPushMessage) {
    }

    public void onNotificationDeleted(Context context, MzPushMessage mzPushMessage) {
    }

    public void onNotifyMessageArrived(Context context, String str) {
    }

    public abstract void onPushStatus(Context context, PushSwitchStatus pushSwitchStatus);

    @Deprecated
    public abstract void onRegister(Context context, String str);

    public abstract void onRegisterStatus(Context context, RegisterStatus registerStatus);

    public abstract void onSubAliasStatus(Context context, SubAliasStatus subAliasStatus);

    public abstract void onSubTagsStatus(Context context, SubTagsStatus subTagsStatus);

    @Deprecated
    public abstract void onUnRegister(Context context, boolean z);

    public abstract void onUnRegisterStatus(Context context, UnRegisterStatus unRegisterStatus);

    public void onUpdateNotificationBuilder(PushNotificationBuilder pushNotificationBuilder) {
    }

    public void onReceive(Context context, Intent intent) {
        try {
            super.onReceive(context, intent);
        } catch (Exception e) {
            DebugLogger.m4828e(TAG, "Event core error " + e.getMessage());
            String packageName = context.getPackageName();
            UxIPUtils.onRecordMessageFlow(context, packageName, (String) null, (String) null, PushManager.TAG, "MzPushMessageReceiver " + e.getMessage(), 3000);
        }
    }

    public void onHandleIntent(Context context, Intent intent) {
        PushMessageProxy.with(context).receiverListener(TAG, new AbstractAppLogicListener() {
            public void onRegister(Context context, String str) {
                DebugLogger.m4829i(MzPushMessageReceiver.TAG, "onRegister " + str);
                MzPushMessageReceiver.this.onRegister(context, str);
            }

            public void onMessage(Context context, String str) {
                MzPushMessageReceiver.this.onMessage(context, str);
                DebugLogger.m4829i(MzPushMessageReceiver.TAG, "receive message " + str);
            }

            public void onMessage(Context context, String str, String str2) {
                MzPushMessageReceiver.this.onMessage(context, str, str2);
                DebugLogger.m4829i(MzPushMessageReceiver.TAG, "receive message " + str + " platformExtra " + str2);
            }

            public void onUnRegister(Context context, boolean z) {
                DebugLogger.m4829i(MzPushMessageReceiver.TAG, "onUnRegister " + z);
                MzPushMessageReceiver.this.onUnRegister(context, z);
            }

            public void onMessage(Context context, Intent intent) {
                DebugLogger.m4829i(MzPushMessageReceiver.TAG, "onMessage Flyme3 " + intent);
                MzPushMessageReceiver.this.onMessage(context, intent);
            }

            public void onUpdateNotificationBuilder(PushNotificationBuilder pushNotificationBuilder) {
                MzPushMessageReceiver.this.onUpdateNotificationBuilder(pushNotificationBuilder);
            }

            public void onPushStatus(Context context, PushSwitchStatus pushSwitchStatus) {
                DebugLogger.m4829i(MzPushMessageReceiver.TAG, "onPushStatus " + pushSwitchStatus);
                MzPushMessageReceiver.this.onPushStatus(context, pushSwitchStatus);
            }

            public void onRegisterStatus(Context context, RegisterStatus registerStatus) {
                DebugLogger.m4829i(MzPushMessageReceiver.TAG, "onRegisterStatus " + registerStatus);
                MzPushMessageReceiver.this.onRegisterStatus(context, registerStatus);
            }

            public void onUnRegisterStatus(Context context, UnRegisterStatus unRegisterStatus) {
                DebugLogger.m4829i(MzPushMessageReceiver.TAG, "onUnRegisterStatus " + unRegisterStatus);
                MzPushMessageReceiver.this.onUnRegisterStatus(context, unRegisterStatus);
            }

            public void onSubTagsStatus(Context context, SubTagsStatus subTagsStatus) {
                DebugLogger.m4829i(MzPushMessageReceiver.TAG, "onSubTagsStatus " + subTagsStatus);
                MzPushMessageReceiver.this.onSubTagsStatus(context, subTagsStatus);
            }

            public void onSubAliasStatus(Context context, SubAliasStatus subAliasStatus) {
                DebugLogger.m4829i(MzPushMessageReceiver.TAG, "onSubAliasStatus " + subAliasStatus);
                MzPushMessageReceiver.this.onSubAliasStatus(context, subAliasStatus);
            }

            public void onNotificationClicked(Context context, MzPushMessage mzPushMessage) {
                DebugLogger.m4829i(MzPushMessageReceiver.TAG, "onNotificationClicked title " + mzPushMessage.getTitle() + "content " + mzPushMessage.getContent() + " selfDefineContentString " + mzPushMessage.getSelfDefineContentString());
                MzPushMessageReceiver.this.onNotificationClicked(context, mzPushMessage);
            }

            public void onNotificationArrived(Context context, MzPushMessage mzPushMessage) {
                DebugLogger.m4829i(MzPushMessageReceiver.TAG, "onNotificationArrived title " + mzPushMessage.getTitle() + "content " + mzPushMessage.getContent() + " selfDefineContentString " + mzPushMessage.getSelfDefineContentString());
                MzPushMessageReceiver.this.onNotificationArrived(context, mzPushMessage);
            }

            public void onNotificationDeleted(Context context, MzPushMessage mzPushMessage) {
                DebugLogger.m4829i(MzPushMessageReceiver.TAG, "onNotificationDeleted title " + mzPushMessage.getTitle() + "content " + mzPushMessage.getContent() + " selfDefineContentString " + mzPushMessage.getSelfDefineContentString());
                MzPushMessageReceiver.this.onNotificationDeleted(context, mzPushMessage);
            }

            public void onNotifyMessageArrived(Context context, String str) {
                DebugLogger.m4829i(MzPushMessageReceiver.TAG, "onNotifyMessageArrived " + str);
                MzPushMessageReceiver.this.onNotifyMessageArrived(context, str);
            }
        }).processMessage(intent);
    }
}
