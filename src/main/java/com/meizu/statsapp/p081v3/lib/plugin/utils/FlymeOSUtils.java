package com.meizu.statsapp.p081v3.lib.plugin.utils;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Point;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.p020ar.statistic.StatisticConstants;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.statsapp.p081v3.lib.plugin.constants.Parameters;
import com.meizu.statsapp.p081v3.utils.log.Logger;
import com.meizu.statsapp.p081v3.utils.reflect.ReflectHelper;
import com.meizu.statsapp.p081v3.utils.reflect.SystemProperties;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.utils.FlymeOSUtils */
public class FlymeOSUtils {
    public static final String ACTION_VCC_OFFLINE_STATS = "com.meizu.dataservice.action.vccOfflineStats";
    public static final String DATASERVICE_PACKAGENAME = "com.meizu.dataservice";
    private static final String TAG = "FlymeOSUtils";
    private static String sBUILD_MASK = "";
    private static String sDeviceId = "";
    private static String sDisplaySize = "";
    private static String sIMEI = "";
    private static Boolean sIsBox = null;
    private static Boolean sIsBrandMeizu = null;
    private static Boolean sIsProductInternational = null;
    private static Boolean sIsRoot = null;
    private static Boolean sIsTablet = null;
    private static String sPRODUCT_MODEL = null;
    private static String sSN = "";

    public static boolean isTablet(Context context) {
        if (sIsTablet != null) {
            return sIsTablet.booleanValue();
        }
        try {
            String str = SystemProperties.get("ro.target.product");
            Boolean valueOf = Boolean.valueOf(!TextUtils.isEmpty(str) && "tablet".equalsIgnoreCase(str));
            sIsTablet = valueOf;
            return valueOf.booleanValue();
        } catch (Exception e) {
            Logger.m17382w(TAG, "Exception: " + e.toString() + " - Cause: " + e.getCause());
            return false;
        }
    }

    public static boolean isBox(Context context) {
        if (sIsBox != null) {
            return sIsBox.booleanValue();
        }
        try {
            String str = SystemProperties.get("ro.target.product");
            Boolean valueOf = Boolean.valueOf(!TextUtils.isEmpty(str) && StatisticConstants.HOST_PLATFORM_BOX.equalsIgnoreCase(str));
            sIsBox = valueOf;
            return valueOf.booleanValue();
        } catch (Exception e) {
            Logger.m17382w(TAG, "Exception: " + e.toString() + " - Cause: " + e.getCause());
            return false;
        }
    }

    public static String getDeviceId(Context context) {
        if (isTablet(context) || isBox(context)) {
            return "";
        }
        if (TextUtils.isEmpty(sDeviceId)) {
            sDeviceId = getIMEI(context);
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.meizu.toolsfortablet", 0);
            if (TextUtils.isEmpty(sDeviceId)) {
                return sharedPreferences.getString("deviceId", "");
            }
            sharedPreferences.edit().putString("deviceId", sDeviceId).apply();
        }
        return sDeviceId;
    }

    private static String getIMEI(Context context) {
        if (TextUtils.isEmpty(sIMEI)) {
            try {
                sIMEI = (String) ReflectHelper.invokeStatic("android.telephony.MzTelephonyManager", "getDeviceId", (Class<?>[]) null, (Object[]) null);
            } catch (Exception e) {
                Logger.m17382w(TAG, "Exception: " + e.toString() + " - Cause: " + e.getCause());
            }
            if (TextUtils.isEmpty(sIMEI)) {
                try {
                    sIMEI = (String) ReflectHelper.invokeStatic("com.meizu.telephony.MzTelephonymanager", "getDeviceId", new Class[]{Context.class, Integer.TYPE}, new Object[]{context, 0});
                } catch (Exception e2) {
                    Logger.m17382w(TAG, "Exception: " + e2.toString() + " - Cause: " + e2.getCause());
                }
            }
            if (TextUtils.isEmpty(sIMEI)) {
                try {
                    sIMEI = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                } catch (Exception e3) {
                    Logger.m17382w(TAG, "Exception: " + e3.toString() + " - Cause: " + e3.getCause());
                }
            }
        }
        return sIMEI;
    }

    public static String getSN() {
        if (!TextUtils.isEmpty(sSN)) {
            return sSN;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                sSN = (String) ReflectHelper.invokeStatic("android.os.Build", "getSerial", new Object[0]);
            } catch (Exception e) {
                Logger.m17379e(TAG, e.getMessage());
            }
        } else {
            String str = SystemProperties.get("ro.serialno");
            if (!TextUtils.isEmpty(str)) {
                sSN = str;
            }
        }
        return sSN;
    }

    public static String getBuildMask() {
        if (TextUtils.isEmpty(sBUILD_MASK)) {
            sBUILD_MASK = SystemProperties.get("ro.build.mask.id");
        }
        return sBUILD_MASK;
    }

    public static String getDisplaySize(Context context) {
        Display defaultDisplay;
        if (TextUtils.isEmpty(sDisplaySize) && (defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay()) != null) {
            Point point = new Point();
            if (Build.VERSION.SDK_INT >= 13) {
                defaultDisplay.getSize(point);
            }
            int i = point.x;
            int i2 = point.y;
            sDisplaySize = i + "." + i2;
        }
        return sDisplaySize;
    }

    public static String getBrand() {
        return Build.BRAND;
    }

    public static boolean isBrandMeizu() {
        boolean z;
        if (sIsBrandMeizu != null) {
            return sIsBrandMeizu.booleanValue();
        }
        try {
            if (TextUtils.isEmpty(SystemProperties.get("ro.meizu.product.model")) && !"meizu".equalsIgnoreCase(Build.BRAND)) {
                if (!"22c4185e".equalsIgnoreCase(Build.BRAND)) {
                    z = false;
                    Boolean valueOf = Boolean.valueOf(z);
                    sIsBrandMeizu = valueOf;
                    return valueOf.booleanValue();
                }
            }
            z = true;
            Boolean valueOf2 = Boolean.valueOf(z);
            sIsBrandMeizu = valueOf2;
            return valueOf2.booleanValue();
        } catch (Exception e) {
            Logger.m17382w(TAG, "Exception: " + e.toString() + " - Cause: " + e.getCause());
            return false;
        }
    }

    public static String getCountry(Context context) {
        if (context == null) {
            return "";
        }
        try {
            if (context.getResources().getConfiguration() == null || context.getResources().getConfiguration().locale == null) {
                return "";
            }
            return context.getResources().getConfiguration().locale.getCountry();
        } catch (Exception e) {
            Logger.m17379e(TAG, "Exception: " + e.toString() + " - Cause: " + e.getCause());
            return "";
        }
    }

    public static String getFlymeUid(Context context) {
        try {
            Account[] accountsByType = ((AccountManager) context.getSystemService("account")).getAccountsByType("com.meizu.account");
            if (accountsByType == null || accountsByType.length <= 0 || accountsByType[0] == null) {
                return "";
            }
            return accountsByType[0].name;
        } catch (Exception e) {
            Logger.m17379e(TAG, "Exception: " + e.toString() + " - Cause: " + e.getCause());
            return "";
        }
    }

    public static String getOperator(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null || 5 != telephonyManager.getSimState()) {
                return "";
            }
            return telephonyManager.getSimOperator();
        } catch (Exception e) {
            Logger.m17379e(TAG, "Exception: " + e.toString() + " - Cause: " + e.getCause());
            return "";
        }
    }

    public static boolean isRoot(Context context) {
        if (sIsRoot != null) {
            Logger.m17378d(TAG, "isRoot = " + sIsRoot);
            return sIsRoot.booleanValue();
        }
        try {
            if (!new File("/system/bin/su").exists()) {
                if (!new File("/system/xbin/su").exists()) {
                    Object systemService = context.getSystemService("device_states");
                    if (systemService == null && (systemService = context.getSystemService("deivce_states")) == null) {
                        sIsRoot = false;
                        Logger.m17378d(TAG, "isRoot = " + sIsRoot);
                        return sIsRoot.booleanValue();
                    }
                    Integer num = (Integer) ReflectHelper.invoke(systemService, "doCheckState", (Class<?>[]) new Class[]{Integer.class}, new Object[]{1});
                    if (num != null && 1 == num.intValue()) {
                        sIsRoot = true;
                        Logger.m17378d(TAG, "isRoot = " + sIsRoot);
                        return sIsRoot.booleanValue();
                    }
                    sIsRoot = false;
                    Logger.m17378d(TAG, "isRoot = " + sIsRoot);
                    return sIsRoot.booleanValue();
                }
            }
            sIsRoot = true;
            Logger.m17378d(TAG, "isRoot = " + sIsRoot);
            return sIsRoot.booleanValue();
        } catch (Exception e) {
            Logger.m17382w(TAG, "Exception:" + e.toString() + " - Cause:" + e.getCause());
        }
    }

    public static String getProductModel() {
        if (TextUtils.isEmpty(sPRODUCT_MODEL)) {
            sPRODUCT_MODEL = SystemProperties.get("ro.meizu.product.model");
            if (TextUtils.isEmpty(sPRODUCT_MODEL)) {
                sPRODUCT_MODEL = Build.MODEL;
            }
        }
        return sPRODUCT_MODEL;
    }

    public static String getLocationLanguage(Context context) {
        Locale locale = context.getResources().getConfiguration().locale;
        String language = locale.getLanguage();
        String country = locale.getCountry();
        if (language == null) {
            language = "";
        }
        if (country == null) {
            country = "";
        }
        return language + "_" + country;
    }

    public static String getPackageVersion(String str, Context context) {
        PackageManager packageManager;
        PackageInfo packageInfo;
        if (TextUtils.isEmpty(str) || context == null || (packageManager = context.getPackageManager()) == null) {
            return "";
        }
        try {
            packageInfo = packageManager.getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            Logger.m17382w(TAG, "Exception: " + e.toString() + " - Cause: " + e.getCause());
            packageInfo = null;
        }
        return packageInfo != null ? packageInfo.versionName : "";
    }

    public static int getPackageCode(String str, Context context) {
        PackageManager packageManager;
        PackageInfo packageInfo;
        if (TextUtils.isEmpty(str) || context == null || (packageManager = context.getPackageManager()) == null) {
            return 0;
        }
        try {
            packageInfo = packageManager.getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            Logger.m17382w(TAG, "Exception: " + e.toString() + " - Cause: " + e.getCause());
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    public static String[] getImsi(Context context) {
        Object invoke;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        String[] strArr = new String[2];
        int i = 0;
        while (i < 2) {
            try {
                Object invokeStatic = ReflectHelper.invokeStatic("android.telephony.SubscriptionManager", "getSubId", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i)});
                if (invokeStatic != null && (invokeStatic instanceof int[])) {
                    int[] iArr = (int[]) invokeStatic;
                    if (!(iArr.length == 0 || (invoke = ReflectHelper.invoke((Object) telephonyManager, "getSubscriberId", (Class<?>[]) new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(iArr[0])})) == null || !(invoke instanceof String))) {
                        strArr[i] = (String) invoke;
                    }
                }
                i++;
            } catch (Exception e) {
                Logger.m17382w(TAG, "Exception: " + e.toString() + " - Cause: " + e.getCause());
            }
        }
        return strArr;
    }

    public static String getAdvertisingId(Context context) {
        try {
            return (String) ReflectHelper.invoke(ReflectHelper.invokeStatic("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", new Class[]{Context.class}, new Object[]{context}), "getId", (Object[]) null);
        } catch (Exception unused) {
            Logger.m17382w(TAG, "can't getting the Advertising ID");
            return null;
        }
    }

    public static String getAndroidId(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), Parameters.ANDROID_ID);
        return (TextUtils.isEmpty(string) || string.toLowerCase().equals("9774d56d682e549c")) ? "" : string;
    }

    public static String getCurProcessName(Context context) {
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo next : ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses()) {
            if (next.pid == myPid) {
                return next.processName;
            }
        }
        return null;
    }

    public static boolean firmwareProductInternational() {
        if (sIsProductInternational != null) {
            Logger.m17378d(TAG, "isProductInternational = " + sIsProductInternational);
            return sIsProductInternational.booleanValue();
        }
        try {
            if ((!SystemProperties.get("ro.product.locale.language").equals("zh") || !SystemProperties.get("ro.product.locale.region").equals("CN")) && !SystemProperties.get("ro.product.locale").equals("zh-CN")) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String[] readTestIds() {
        String[] strArr = new String[4];
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Environment.getExternalStorageDirectory(), "fakeId_testx.txt")));
            int i = 0;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append("读取第");
                int i2 = i + 1;
                sb.append(i2);
                sb.append("行");
                sb.append(readLine);
                printStream.println(sb.toString());
                if (i < 4) {
                    strArr[i] = readLine;
                    i = i2;
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strArr;
    }

    public static boolean isCTA() {
        String str = SystemProperties.get("ro.build.cta");
        return str != null && str.equalsIgnoreCase("CTA");
    }

    public static boolean kaiJiXiangDao(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "device_provisioned", 0) == 1;
    }

    public static boolean findDataService(Context context) {
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent(ACTION_VCC_OFFLINE_STATS), 64);
        Logger.m17378d(TAG, "queryIntentServices: " + queryIntentServices);
        if (queryIntentServices != null) {
            for (ResolveInfo next : queryIntentServices) {
                String str = next.serviceInfo.packageName;
                String str2 = next.serviceInfo.name;
                if (DATASERVICE_PACKAGENAME.equals(str)) {
                    Logger.m17378d(TAG, "choose serviceName---" + str2 + " pkgName---" + str);
                    return true;
                }
            }
        }
        Log.w(TAG, "findDataService false");
        return false;
    }

    public static boolean findExperienceDataSync(Context context) {
        Iterator<PackageInfo> it = context.getPackageManager().getInstalledPackages(8).iterator();
        while (true) {
            if (!it.hasNext()) {
                return false;
            }
            ProviderInfo[] providerInfoArr = it.next().providers;
            if (providerInfoArr != null) {
                for (ProviderInfo providerInfo : providerInfoArr) {
                    if (providerInfo != null && providerInfo.authority != null && providerInfo.authority.equals("com.meizu.usagestats")) {
                        return true;
                    }
                }
                continue;
            }
        }
    }

    public static boolean isPreFlyme8() {
        int i;
        try {
            i = Integer.parseInt(SystemProperties.get("ro.build.flyme.version", "0"));
        } catch (Exception e) {
            Logger.m17382w(TAG, "isPreFlyme8 make an error, e = " + e);
            i = 0;
        }
        if (i < 8) {
            return true;
        }
        return false;
    }
}
