package com.meizu.statsapp.p081v3.lib.plugin.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import com.meizu.statsapp.p081v3.utils.log.Logger;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.utils.PermissionUtils */
public class PermissionUtils {
    private static final String TAG = "PermissionUtils";

    public static boolean checkInternetPermission(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        if (packageManager == null || packageName == null) {
            Logger.m17379e(TAG, "Can't check configuration when using a Context with null packageManager or packageName");
            return false;
        } else if (packageManager.checkPermission("android.permission.INTERNET", packageName) == 0) {
            return true;
        } else {
            Logger.m17379e(TAG, "Package does not have permission android.permission.INTERNET - usage will not work at all!");
            Logger.m17379e(TAG, "You can fix this by adding the following to your AndroidManifest.xml file:\n<uses-permission android:name=\"android.permission.INTERNET\" />");
            return false;
        }
    }
}
