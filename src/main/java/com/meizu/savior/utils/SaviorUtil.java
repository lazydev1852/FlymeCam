package com.meizu.savior.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import androidx.core.p005os.EnvironmentCompat;
import com.meizu.savior.Constants;

public class SaviorUtil {
    private static int sInternational = -1;

    private static String getSystemProperties(String str, String str2) {
        try {
            return (String) ReflectHelper.invokeStatic("android.os.SystemProperties", "get", new Class[]{String.class, String.class}, new Object[]{str, EnvironmentCompat.MEDIA_UNKNOWN});
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    public static synchronized boolean isInternational() {
        boolean z;
        synchronized (SaviorUtil.class) {
            z = false;
            if (sInternational == -1) {
                if ((!getSystemProperties("ro.product.locale.language", "null").equals("zh") || !getSystemProperties("ro.product.locale.region", "null").equals("CN")) && !getSystemProperties("ro.product.locale", "null").equals("zh-CN")) {
                    sInternational = 1;
                } else {
                    sInternational = 0;
                }
            }
            if (sInternational == 1) {
                z = true;
            }
        }
        return z;
    }

    public static boolean isPackageVersionUpdate(Context context, String str) {
        try {
            int i = context.getPackageManager().getPackageInfo(str, 0).versionCode;
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(context.getPackageName(), 0);
            int i2 = sharedPreferences.getInt(Constants.PARAM_PKG_VERSION, -1);
            if (i2 == -1) {
                sharedPreferences.edit().putInt(Constants.PARAM_PKG_VERSION, i).apply();
            }
            return i > i2;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
