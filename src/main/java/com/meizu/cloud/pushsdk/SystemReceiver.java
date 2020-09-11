package com.meizu.cloud.pushsdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.base.IntentReceiver;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.pushtracer.QuickTracker;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import com.meizu.cloud.pushsdk.util.UxIPUtils;

public class SystemReceiver extends IntentReceiver {
    private static final String TAG = "SystemReceiver";

    public void onReceive(Context context, Intent intent) {
        try {
            super.onReceive(context, intent);
        } catch (Exception e) {
            DebugLogger.m4828e(TAG, "Event core error " + e.getMessage());
            String packageName = context.getPackageName();
            UxIPUtils.onRecordMessageFlow(context, packageName, (String) null, (String) null, PushManager.TAG, "SystemReceiver " + e.getMessage(), 3000);
        }
    }

    public void onHandleIntent(Context context, Intent intent) {
        if (intent != null) {
            try {
                if ("com.meizu.cloud.pushservice.action.PUSH_SERVICE_START".equals(intent.getAction())) {
                    restartCloudService(context);
                    QuickTracker.init(context, false).restartEventTracking();
                }
            } catch (Exception e) {
                DebugLogger.m4828e(TAG, "onHandleIntent Exception " + e.getMessage());
            }
        }
    }

    public void startPushService(Context context, Intent intent) {
        try {
            context.startService(intent);
        } catch (SecurityException e) {
            DebugLogger.m4828e(TAG, "start service error " + e.getMessage());
        }
    }

    public void restartCloudService(Context context) {
        String appVersionName = MzSystemUtils.getAppVersionName(context, "com.meizu.cloud");
        DebugLogger.m4829i(TAG, context.getPackageName() + " start register cloudVersion_name " + appVersionName);
        Intent intent = new Intent();
        if ("com.meizu.cloud".equals(MzSystemUtils.getMzPushServicePackageName(context))) {
            DebugLogger.m4828e(TAG, "cloud pushService start");
            intent.setAction("com.meizu.pushservice.action.START");
            intent.setClassName("com.meizu.cloud", "com.meizu.cloud.pushsdk.pushservice.MzPushService");
        } else if (!TextUtils.isEmpty(appVersionName) && MzSystemUtils.compareVersion(appVersionName, "4.5.7")) {
            DebugLogger.m4828e(TAG, "flyme 4.x start register cloud versionName " + appVersionName);
            intent.setPackage("com.meizu.cloud");
            intent.setAction(PushConstants.MZ_PUSH_ON_START_PUSH_REGISTER);
        } else if (TextUtils.isEmpty(appVersionName) || !appVersionName.startsWith(ExifInterface.GPS_MEASUREMENT_3D)) {
            DebugLogger.m4828e(TAG, context.getPackageName() + " start register ");
            intent.setClassName(context.getPackageName(), "com.meizu.cloud.pushsdk.pushservice.MzPushService");
            intent.setAction("com.meizu.pushservice.action.START");
        } else {
            DebugLogger.m4828e(TAG, "flyme 3.x start register cloud versionName " + appVersionName);
            intent.setAction(PushConstants.REQUEST_REGISTRATION_INTENT);
            intent.setPackage("com.meizu.cloud");
        }
        startPushService(context, intent);
    }
}
