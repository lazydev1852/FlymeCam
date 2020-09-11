package com.meizu.cloud.pushsdk.notification.android;

import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.handler.MessageV4;
import com.meizu.cloud.pushsdk.networking.AndroidNetworking;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.notification.util.FileUtil;
import com.meizu.cloud.pushsdk.notification.util.ZipExtractTask;
import com.meizu.cloud.pushsdk.pushtracer.emitter.classic.Executor;
import com.meizu.cloud.pushsdk.util.Connectivity;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
import java.io.File;

public class AndroidVideoNotification extends AndroidStandardNotification {
    public AndroidVideoNotification(Context context, PushNotificationBuilder pushNotificationBuilder) {
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

    /* access modifiers changed from: protected */
    public void buildContentView(Notification notification, MessageV3 messageV3) {
        super.buildContentView(notification, messageV3);
        MessageV4 parse = MessageV4.parse(messageV3);
        if (parse.getActVideoSetting() == null || (parse.getActVideoSetting().isWifiDisplay() && !Connectivity.isConnectedWifi(this.context))) {
            DebugLogger.m4828e("AbstractPushNotification", "only wifi can download act");
            return;
        }
        final String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdkAct/" + messageV3.getUploadDataPackageName();
        String valueOf = String.valueOf(System.currentTimeMillis());
        String actUrl = parse.getActVideoSetting().getActUrl();
        if (!TextUtils.isEmpty(actUrl) && AndroidNetworking.download(actUrl, str, valueOf).build().executeForDownload().isSuccess()) {
            DebugLogger.m4829i("AbstractPushNotification", "down load " + actUrl + " success");
            String str2 = str + File.separator + "ACT-" + valueOf;
            boolean doUnzipSync = new ZipExtractTask(str + File.separator + valueOf, str2).doUnzipSync();
            StringBuilder sb = new StringBuilder();
            sb.append("zip file ");
            sb.append(doUnzipSync);
            DebugLogger.m4829i("AbstractPushNotification", sb.toString());
            if (doUnzipSync) {
                Bundle bundle = new Bundle();
                bundle.putString("path", str2);
                Bundle bundle2 = new Bundle();
                bundle2.putBundle("big", bundle);
                if (MinSdkChecker.isSupportVideoNotification()) {
                    notification.extras.putBundle("flyme.active", bundle2);
                }
            }
        }
        Executor.execute(new Runnable() {
            public void run() {
                for (File file : FileUtil.listFile(str, String.valueOf(System.currentTimeMillis() - 86400000))) {
                    FileUtil.deleteDirectory(file.getPath());
                    DebugLogger.m4829i("AbstractPushNotification", "Delete file directory " + file.getName() + "\n");
                }
            }
        });
    }
}
