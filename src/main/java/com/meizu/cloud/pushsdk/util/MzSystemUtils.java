package com.meizu.cloud.pushsdk.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.analytics.FastTracker;
import com.meizu.cloud.pushsdk.base.BuildExt;
import com.meizu.cloud.pushsdk.base.DeviceUtils;
import com.meizu.cloud.pushsdk.base.SystemProperties;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MzSystemUtils {
    private static final String TAG = "MzSystemUtils";

    private static String getServicesByPackageName(Context context, String str) {
        ServiceInfo[] serviceInfoArr;
        try {
            serviceInfoArr = context.getPackageManager().getPackageInfo(str, 4).services;
        } catch (PackageManager.NameNotFoundException unused) {
            serviceInfoArr = null;
        }
        if (serviceInfoArr == null) {
            return null;
        }
        for (int i = 0; i < serviceInfoArr.length; i++) {
            if ("com.meizu.cloud.pushsdk.pushservice.MzPushService".equals(serviceInfoArr[i].name)) {
                return serviceInfoArr[i].processName;
            }
        }
        return null;
    }

    public static String getMzPushServicePackageName(Context context) {
        String packageName = context.getPackageName();
        try {
            String servicesByPackageName = getServicesByPackageName(context, "com.meizu.cloud");
            if (!TextUtils.isEmpty(servicesByPackageName) && servicesByPackageName.contains("mzservice_v1")) {
                return "com.meizu.cloud";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DebugLogger.m4829i("SystemUtils", "startservice package name " + packageName);
        return packageName;
    }

    public static String getAppVersionName(Context context, String str) {
        try {
            String str2 = context.getPackageManager().getPackageInfo(str, 0).versionName;
            if (str2 != null) {
                return str2.length() <= 0 ? "" : str2;
            }
            return "";
        } catch (Exception e) {
            DebugLogger.m4828e("VersionInfo", "Exception message " + e.getMessage());
            return "";
        }
    }

    public static boolean compareVersion(String str, String str2) {
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int min = Math.min(split.length, split2.length);
        int i = 0;
        for (int i2 = 0; i2 < min; i2++) {
            i = split[i2].length() - split2[i2].length();
            if (i != 0 || (i = split[i2].compareTo(split2[i2])) != 0) {
                break;
            }
        }
        if (i == 0) {
            i = split.length - split2.length;
        }
        if (i >= 0) {
            return true;
        }
        return false;
    }

    public static void sendMessageFromBroadcast(Context context, Intent intent, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            intent.setAction(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            intent.setPackage(str2);
        }
        String findReceiver = findReceiver(context, str, str2);
        if (!TextUtils.isEmpty(findReceiver)) {
            intent.setClassName(str2, findReceiver);
        }
        context.sendBroadcast(intent);
    }

    public static String findReceiver(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.setPackage(str2);
        List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
            return null;
        }
        return queryBroadcastReceivers.get(0).activityInfo.name;
    }

    public static String getDeviceId(Context context) {
        try {
            return DeviceUtils.getDeviceId(context);
        } catch (Exception e) {
            DebugLogger.m4828e(TAG, "getDeviceId error " + e.getMessage());
            return null;
        }
    }

    public static boolean isBrandMeizu(Context context) {
        boolean z = !TextUtils.isEmpty(SystemProperties.get("ro.meizu.product.model")) || "meizu".equalsIgnoreCase(Build.BRAND) || "22c4185e".equalsIgnoreCase(Build.BRAND);
        if (!z) {
            FastTracker.uploadData(context.getApplicationContext());
        }
        return z;
    }

    public static boolean isInternational() {
        if (BuildExt.isInternational().f4119ok) {
            return ((Boolean) BuildExt.isInternational().value).booleanValue();
        }
        return false;
    }

    public static boolean isIndiaLocal() {
        return "india".equals(SystemProperties.get("ro.meizu.locale.region"));
    }

    public static String getSubscribeId(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return telephonyManager.getSubscriberId();
            }
            return null;
        } catch (Exception e) {
            DebugLogger.m4828e(TAG, "getSubscribeId error " + e.getMessage());
            return null;
        }
    }

    public static String getLineNumber(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return telephonyManager.getLine1Number();
            }
            return null;
        } catch (Exception e) {
            DebugLogger.m4828e(TAG, "getLineNumber error " + e.getMessage());
            return null;
        }
    }

    public static String getOperator(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return telephonyManager.getSimOperator();
            }
            return null;
        } catch (Exception e) {
            DebugLogger.m4828e(TAG, "getOperator error " + e.getMessage());
            return null;
        }
    }

    public static String getNetWorkType(Context context) {
        String str;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                int type = activeNetworkInfo.getType();
                if (type == 7) {
                    return "BLUETOOTH";
                }
                if (type == 9) {
                    return "ETHERNET";
                }
                switch (type) {
                    case 0:
                        switch (activeNetworkInfo.getSubtype()) {
                            case 1:
                            case 2:
                            case 4:
                            case 7:
                            case 11:
                                str = "MOBILE_2G";
                                break;
                            case 3:
                            case 5:
                            case 6:
                            case 8:
                            case 9:
                            case 10:
                            case 12:
                            case 14:
                            case 15:
                                str = "MOBILE_3G";
                                break;
                            case 13:
                                str = "MOBILE_4G";
                                break;
                            default:
                                str = "MOBILE_XG";
                                break;
                        }
                        String str2 = str;
                        break;
                    case 1:
                        return "WIFI";
                }
                return "OTHER";
            }
        } catch (SecurityException e) {
            DebugLogger.m4828e(TAG, "Security exception checking connection: " + e.getMessage());
        }
        return "";
    }

    public static String getWifiMac(Context context) {
        WifiInfo connectionInfo;
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
                return null;
            }
            return connectionInfo.getMacAddress();
        } catch (Exception e) {
            DebugLogger.m4828e(TAG, "getWifiMac error " + e.getMessage());
            return null;
        }
    }

    public static String getBSSID(Context context) {
        WifiInfo connectionInfo;
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
                return null;
            }
            return connectionInfo.getBSSID();
        } catch (Exception e) {
            DebugLogger.m4828e(TAG, "getOperator error " + e.getMessage());
            return null;
        }
    }

    public static String getCurrentLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static boolean isApplicationDebug(Context context) {
        try {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getAppVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static int getAppVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    public static boolean compatApi(int i) {
        return Build.VERSION.SDK_INT >= i;
    }

    public static String getSn() {
        String str = SystemProperties.get("ro.serialno");
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return Build.SERIAL;
    }

    public static boolean isPackageInstalled(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0011 A[Catch:{ Exception -> 0x003f }, LOOP:0: B:3:0x0011->B:6:0x0023, LOOP_START, PHI: r0 
  PHI: (r0v3 boolean) = (r0v2 boolean), (r0v8 boolean) binds: [B:2:?, B:6:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isRunningProcess(android.content.Context r2, java.lang.String r3) {
        /*
            java.lang.String r0 = "activity"
            java.lang.Object r2 = r2.getSystemService(r0)     // Catch:{ Exception -> 0x003f }
            android.app.ActivityManager r2 = (android.app.ActivityManager) r2     // Catch:{ Exception -> 0x003f }
            java.util.List r2 = r2.getRunningAppProcesses()     // Catch:{ Exception -> 0x003f }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x003f }
            r0 = 0
        L_0x0011:
            boolean r1 = r2.hasNext()     // Catch:{ Exception -> 0x003f }
            if (r1 == 0) goto L_0x0025
            java.lang.Object r0 = r2.next()     // Catch:{ Exception -> 0x003f }
            android.app.ActivityManager$RunningAppProcessInfo r0 = (android.app.ActivityManager.RunningAppProcessInfo) r0     // Catch:{ Exception -> 0x003f }
            java.lang.String r0 = r0.processName     // Catch:{ Exception -> 0x003f }
            boolean r0 = r0.contains(r3)     // Catch:{ Exception -> 0x003f }
            if (r0 == 0) goto L_0x0011
        L_0x0025:
            java.lang.String r2 = "MzSystemUtils"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003f }
            r1.<init>()     // Catch:{ Exception -> 0x003f }
            r1.append(r3)     // Catch:{ Exception -> 0x003f }
            java.lang.String r3 = " is running "
            r1.append(r3)     // Catch:{ Exception -> 0x003f }
            r1.append(r0)     // Catch:{ Exception -> 0x003f }
            java.lang.String r3 = r1.toString()     // Catch:{ Exception -> 0x003f }
            com.meizu.cloud.pushinternal.DebugLogger.m4829i(r2, r3)     // Catch:{ Exception -> 0x003f }
            goto L_0x0047
        L_0x003f:
            java.lang.String r2 = "MzSystemUtils"
            java.lang.String r3 = "can not get running process info so set running true"
            com.meizu.cloud.pushinternal.DebugLogger.m4828e(r2, r3)
            r0 = 1
        L_0x0047:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.util.MzSystemUtils.isRunningProcess(android.content.Context, java.lang.String):boolean");
    }

    public static List<String> getRunningProcess(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses()) {
                arrayList.add(runningAppProcessInfo.processName);
            }
        } catch (Exception unused) {
            DebugLogger.m4828e(TAG, "can not get running process info so set running true");
        }
        return arrayList;
    }

    public static List<String> getInstalledPackage(Context context) {
        List<PackageInfo> installedPackages;
        ArrayList arrayList = new ArrayList();
        try {
            PackageManager packageManager = context.getPackageManager();
            if (!(packageManager == null || (installedPackages = packageManager.getInstalledPackages(0)) == null)) {
                for (PackageInfo packageInfo : installedPackages) {
                    arrayList.add(packageInfo.packageName);
                }
            }
        } catch (Exception e) {
            DebugLogger.m4828e(TAG, "getInstalledPackage error " + e.getMessage());
        }
        return arrayList;
    }

    public static String getProcessName(Context context) {
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo next : ((ActivityManager) context.getApplicationContext().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses()) {
            DebugLogger.m4829i(TAG, "processName " + next.processName);
            if (next.pid == myPid) {
                return next.processName;
            }
        }
        return "";
    }
}
