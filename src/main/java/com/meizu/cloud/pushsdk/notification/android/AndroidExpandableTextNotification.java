package com.meizu.cloud.pushsdk.notification.android;

import android.app.Notification;
import android.content.Context;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;

public class AndroidExpandableTextNotification extends AndroidStandardNotification {
    public AndroidExpandableTextNotification(Context context, PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    /* access modifiers changed from: protected */
    public void buildExpandableContent(Notification.Builder builder, MessageV3 messageV3) {
        if (MinSdkChecker.isSupportNotificationBuild()) {
            Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
            bigTextStyle.setBigContentTitle(messageV3.getTitle());
            bigTextStyle.bigText(messageV3.getmNotificationStyle().getExpandableText());
            builder.setStyle(bigTextStyle);
        }
    }
}
