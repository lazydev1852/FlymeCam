package com.meizu.update.util;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;

/* renamed from: com.meizu.update.util.b */
public class ForegroundUtil {
    /* renamed from: a */
    public static boolean m17932a(Context context) {
        return m17933a(context, context.getPackageName());
    }

    /* renamed from: a */
    private static boolean m17933a(Context context, String str) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        boolean z = true;
        if (activityManager.getRunningTasks(1).size() > 0) {
            ComponentName componentName = activityManager.getRunningTasks(1).get(0).topActivity;
            if (TextUtils.isEmpty(str) || componentName == null || !str.equals(componentName.getPackageName())) {
                z = false;
            }
            Loger.m17938a(context, str + " is current on top : " + z);
            return z;
        }
        Loger.m17938a(context, str + " RunningTasks's size : " + activityManager.getRunningTasks(1).size());
        return false;
    }
}
