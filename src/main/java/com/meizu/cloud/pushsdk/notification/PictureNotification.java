package com.meizu.cloud.pushsdk.notification;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.notification.flyme.StandardNotification;
import com.meizu.cloud.pushsdk.notification.model.styleenum.InnerStyleLayout;
import com.meizu.cloud.pushsdk.notification.util.RProxy;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;

public class PictureNotification extends StandardNotification {
    private static final String TAG = "PictureNotification";

    public PictureNotification(Context context, PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    /* access modifiers changed from: protected */
    public void buildBigContentView(Notification notification, MessageV3 messageV3) {
        if (MinSdkChecker.isSupportNotificationBuild()) {
            Bitmap bitmapFromURL = getBitmapFromURL(messageV3.getmNotificationStyle().getBannerImageUrl());
            if (!isOnMainThread() && bitmapFromURL != null) {
                RemoteViews remoteViews = new RemoteViews(this.context.getPackageName(), RProxy.push_pure_pic_notification(this.context));
                remoteViews.setImageViewBitmap(RProxy.push_pure_bigview_banner(this.context), bitmapFromURL);
                remoteViews.setViewVisibility(RProxy.push_pure_bigview_expanded(this.context), 8);
                remoteViews.setViewVisibility(RProxy.push_pure_bigview_banner(this.context), 0);
                notification.contentView = remoteViews;
                if (messageV3.getmNotificationStyle().getInnerStyle() == InnerStyleLayout.EXPANDABLE_PIC.getCode()) {
                    Bitmap bitmapFromURL2 = getBitmapFromURL(messageV3.getmNotificationStyle().getExpandableImageUrl());
                    if (!isOnMainThread() && bitmapFromURL2 != null) {
                        RemoteViews remoteViews2 = new RemoteViews(this.context.getPackageName(), RProxy.push_pure_pic_notification(this.context));
                        remoteViews2.setImageViewBitmap(RProxy.push_pure_bigview_expanded(this.context), bitmapFromURL2);
                        remoteViews2.setViewVisibility(RProxy.push_pure_bigview_expanded(this.context), 0);
                        remoteViews2.setViewVisibility(RProxy.push_pure_bigview_banner(this.context), 8);
                        notification.bigContentView = remoteViews2;
                    }
                }
            }
        }
    }
}
