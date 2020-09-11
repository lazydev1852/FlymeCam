package com.meizu.cloud.pushsdk.notification.android;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.notification.AbstractPushNotification;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;

public class AndroidStandardNotification extends AbstractPushNotification {
    public AndroidStandardNotification(Context context, PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    /* access modifiers changed from: protected */
    public void appIconSettingBuilder(Notification.Builder builder, MessageV3 messageV3) {
        AppIconSetting appIconSetting = messageV3.getmAppIconSetting();
        if (appIconSetting == null) {
            return;
        }
        if (appIconSetting.isDefaultLargeIcon()) {
            builder.setLargeIcon((this.pushNotificationBuilder == null || this.pushNotificationBuilder.getmLargIcon() == 0) ? getAppIcon(this.context, messageV3.getUploadDataPackageName()) : BitmapFactory.decodeResource(this.context.getResources(), this.pushNotificationBuilder.getmLargIcon()));
        } else if (Thread.currentThread() != this.context.getMainLooper().getThread()) {
            Bitmap bitmapFromURL = getBitmapFromURL(appIconSetting.getLargeIconUrl());
            if (bitmapFromURL != null) {
                DebugLogger.m4829i("AbstractPushNotification", "On other Thread down load largeIcon image success");
                builder.setLargeIcon(bitmapFromURL);
                return;
            }
            builder.setLargeIcon(getAppIcon(this.context, messageV3.getUploadDataPackageName()));
        }
    }
}
