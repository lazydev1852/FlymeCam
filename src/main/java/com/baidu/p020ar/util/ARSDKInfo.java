package com.baidu.p020ar.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/* renamed from: com.baidu.ar.util.ARSDKInfo */
public class ARSDKInfo {

    /* renamed from: a */
    private static String f2355a = "pro";

    /* renamed from: b */
    private static String f2356b = "101";

    public static String getAppId(Context context) {
        if (context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            StringBuilder sb = new StringBuilder(context.getApplicationContext().getPackageName());
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getApplicationContext().getPackageName(), 0);
                if (packageInfo != null) {
                    String str = packageInfo.versionName;
                    if (!TextUtils.isEmpty(str)) {
                        sb.append("_");
                        sb.append(str);
                        ARLog.m2695d("appId = " + sb.toString());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            return sb.toString();
        } catch (NullPointerException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getCiVersion() {
        return "open_SDK_2.6_MEIZU_28732580daf4f15cb75037319e15fa63369c9ea6_2018-12-18";
    }

    public static String getFunctionType() {
        return f2356b;
    }

    public static String getSDKType() {
        return f2355a;
    }

    public static int getVersionCode() {
        return 190;
    }

    public static String getVersionName() {
        return "2.6";
    }

    public static void setFunctionType(String str) {
        f2356b = str;
    }

    public static void setSDKType(String str) {
        f2355a = str;
    }
}
