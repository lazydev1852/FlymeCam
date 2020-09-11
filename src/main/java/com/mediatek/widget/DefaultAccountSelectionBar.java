package com.mediatek.widget;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.util.Log;
import com.mediatek.widget.CustomAccountRemoteViews;
import java.util.List;

public class DefaultAccountSelectionBar {
    private static final String TAG = "DefaultAccountSelectionBar";
    private Context mContext;
    private CustomAccountRemoteViews mCustomAccountRemoteViews;
    private Notification mNotification = new Notification.Builder(this.mContext).setSmallIcon(134348800).setWhen(System.currentTimeMillis()).setPriority(2).build();
    private NotificationManager mNotificationManager = ((NotificationManager) this.mContext.getSystemService("notification"));
    private String mPackageName;

    public DefaultAccountSelectionBar(Context context, String str, List<CustomAccountRemoteViews.AccountInfo> list) {
        this.mContext = context;
        this.mPackageName = str;
        configureView(list);
        this.mNotification.flags = 32;
    }

    public void updateData(List<CustomAccountRemoteViews.AccountInfo> list) {
        configureView(list);
    }

    public void show() {
        this.mNotification.contentView = this.mCustomAccountRemoteViews.getNormalRemoteViews();
        this.mNotification.bigContentView = this.mCustomAccountRemoteViews.getBigRemoteViews();
        this.mNotificationManager.notify(135331894, this.mNotification);
        Log.d(TAG, "In package show accountBar: " + this.mPackageName);
    }

    public void hide() {
        this.mNotificationManager.cancel(135331894);
        Log.d(TAG, "In package hide accountBar: " + this.mPackageName);
    }

    private void configureView(List<CustomAccountRemoteViews.AccountInfo> list) {
        this.mCustomAccountRemoteViews = new CustomAccountRemoteViews(this.mContext, this.mPackageName, list);
        this.mCustomAccountRemoteViews.configureView();
    }
}
