package com.meizu.cloud.pushsdk.notification.android;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;

public class AndroidExpandablePicNotification extends AndroidStandardNotification {
    public AndroidExpandablePicNotification(Context context, PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    /* access modifiers changed from: protected */
    public void buildExpandableContent(Notification.Builder builder, MessageV3 messageV3) {
        Bitmap bitmapFromURL;
        if (MinSdkChecker.isSupportNotificationBuild()) {
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle();
            if (messageV3.getmNotificationStyle() != null && !isOnMainThread() && !TextUtils.isEmpty(messageV3.getmNotificationStyle().getExpandableImageUrl()) && (bitmapFromURL = getBitmapFromURL(messageV3.getmNotificationStyle().getExpandableImageUrl())) != null) {
                bigPictureStyle.setBigContentTitle(messageV3.getTitle());
                bigPictureStyle.bigPicture(bitmapFromURL);
                builder.setStyle(bigPictureStyle);
            }
        }
    }
}
