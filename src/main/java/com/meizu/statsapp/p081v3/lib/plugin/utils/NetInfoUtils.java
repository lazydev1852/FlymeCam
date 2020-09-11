package com.meizu.statsapp.p081v3.lib.plugin.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.p005os.EnvironmentCompat;
import com.meizu.statsapp.p081v3.lib.plugin.constants.Parameters;
import com.meizu.statsapp.p081v3.utils.CommonUtils;
import com.meizu.statsapp.p081v3.utils.log.Logger;
import com.meizu.statsapp.p081v3.utils.reflect.SystemProperties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.utils.NetInfoUtils */
public class NetInfoUtils {
    private static final String TAG = "NetInfoUtils";

    public static boolean isOnline(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            boolean z = activeNetworkInfo != null && activeNetworkInfo.isConnected();
            Logger.m17378d(TAG, "isOnline:" + z);
            return z;
        } catch (SecurityException e) {
            Logger.m17379e(TAG, "Security exception:" + e.toString());
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        r4 = r4.getNetworkInfo(1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isWiFiWorking(android.content.Context r4) {
        /*
            r0 = 0
            java.lang.String r1 = "connectivity"
            java.lang.Object r4 = r4.getSystemService(r1)     // Catch:{ Exception -> 0x001c }
            android.net.ConnectivityManager r4 = (android.net.ConnectivityManager) r4     // Catch:{ Exception -> 0x001c }
            if (r4 != 0) goto L_0x000c
            return r0
        L_0x000c:
            r1 = 1
            android.net.NetworkInfo r4 = r4.getNetworkInfo(r1)     // Catch:{ Exception -> 0x001c }
            if (r4 == 0) goto L_0x0043
            android.net.NetworkInfo$State r2 = android.net.NetworkInfo.State.CONNECTED     // Catch:{ Exception -> 0x001c }
            android.net.NetworkInfo$State r4 = r4.getState()     // Catch:{ Exception -> 0x001c }
            if (r2 != r4) goto L_0x0043
            return r1
        L_0x001c:
            r4 = move-exception
            java.lang.String r1 = "NetInfoUtils"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Exception: "
            r2.append(r3)
            java.lang.String r3 = r4.toString()
            r2.append(r3)
            java.lang.String r3 = " - Cause: "
            r2.append(r3)
            java.lang.Throwable r4 = r4.getCause()
            r2.append(r4)
            java.lang.String r4 = r2.toString()
            com.meizu.statsapp.p081v3.utils.log.Logger.m17379e(r1, r4)
        L_0x0043:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.statsapp.p081v3.lib.plugin.utils.NetInfoUtils.isWiFiWorking(android.content.Context):boolean");
    }

    public static String getMACAddress(Context context) {
        String macAndroid7;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.meizu.toolsfortablet", 0);
        if (sharedPreferences.contains(Parameters.MAC_ADDRESS)) {
            sharedPreferences.edit().remove(Parameters.MAC_ADDRESS).apply();
        }
        try {
            if (Build.VERSION.SDK_INT < 23) {
                macAndroid7 = getMacAndroid6_(context);
            } else if (Build.VERSION.SDK_INT >= 23 && Build.VERSION.SDK_INT < 24) {
                macAndroid7 = getMacAndroid6_7(context);
            } else if (Build.VERSION.SDK_INT < 24) {
                return "";
            } else {
                macAndroid7 = getMacAndroid7(context);
            }
            return macAndroid7;
        } catch (Exception e) {
            Logger.m17382w(TAG, "Exception: " + e.toString() + " - Cause: " + e.getCause());
            return "";
        }
    }

    private static String getMacAndroid6_(Context context) {
        String macAddress;
        String str = "";
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager != null) {
            try {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (connectionInfo == null) {
                    macAddress = null;
                } else {
                    macAddress = connectionInfo.getMacAddress();
                }
                str = macAddress;
            } catch (SecurityException e) {
                Logger.m17379e(TAG, "Security exception:" + e.toString());
            }
        }
        Logger.m17378d(TAG, "6_ " + str);
        return str;
    }

    private static String getMacAndroid6_7(Context context) {
        String macAddressWithIfName = getMacAddressWithIfName(SystemProperties.get("wifi.interface", "wlan0"));
        Logger.m17378d(TAG, "6_7 " + macAddressWithIfName);
        return macAddressWithIfName;
    }

    @TargetApi(24)
    private static String getMacAndroid7(Context context) {
        Logger.m17378d(TAG, "7_ 1. " + MacAndroid7.getMacAddress());
        Logger.m17378d(TAG, "7_ 2. " + MacAndroid7.getMachineHardwareAddress());
        Logger.m17378d(TAG, "7_ 3. " + MacAndroid7.getLocalMacAddressFromBusybox());
        String macAddress = MacAndroid7.getMacAddress();
        if (TextUtils.isEmpty(macAddress)) {
            macAddress = MacAndroid7.getMachineHardwareAddress();
        }
        return TextUtils.isEmpty(macAddress) ? MacAndroid7.getLocalMacAddressFromBusybox() : macAddress;
    }

    private static String getMacAddressWithIfName(String str) {
        String str2 = "";
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream("/sys/class/net/" + str + "/address");
            try {
                byte[] bArr = new byte[1024];
                if (fileInputStream2.read(bArr) > 0) {
                    str2 = new String(bArr).trim();
                }
                CommonUtils.closeQuietly(fileInputStream2);
            } catch (FileNotFoundException e) {
                e = e;
                fileInputStream = fileInputStream2;
                Logger.m17382w(TAG, "Exception: " + e.toString() + " - Cause: " + e.getCause());
                CommonUtils.closeQuietly(fileInputStream);
                return str2.toUpperCase();
            } catch (IOException e2) {
                e = e2;
                fileInputStream = fileInputStream2;
                Logger.m17382w(TAG, "Exception: " + e.toString() + " - Cause: " + e.getCause());
                CommonUtils.closeQuietly(fileInputStream);
                return str2.toUpperCase();
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                CommonUtils.closeQuietly(fileInputStream);
                throw th;
            }
        } catch (FileNotFoundException e3) {
            e = e3;
            Logger.m17382w(TAG, "Exception: " + e.toString() + " - Cause: " + e.getCause());
            CommonUtils.closeQuietly(fileInputStream);
            return str2.toUpperCase();
        } catch (IOException e4) {
            e = e4;
            Logger.m17382w(TAG, "Exception: " + e.toString() + " - Cause: " + e.getCause());
            CommonUtils.closeQuietly(fileInputStream);
            return str2.toUpperCase();
        } catch (Throwable th2) {
            th = th2;
            CommonUtils.closeQuietly(fileInputStream);
            throw th;
        }
        return str2.toUpperCase();
    }

    public static String getNetworkType(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return EnvironmentCompat.MEDIA_UNKNOWN;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                return "off";
            }
            if (activeNetworkInfo.getType() == 1) {
                return "wifi";
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager.getNetworkType() == 1) {
                return "2g";
            }
            if (telephonyManager.getNetworkType() == 2) {
                return "2g";
            }
            return telephonyManager.getNetworkType() == 13 ? "4g" : "3g";
        } catch (Exception e) {
            Logger.m17382w(TAG, "Exception: " + e.toString() + " - Cause: " + e.getCause());
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    public static String getNetworkTypeForFlymeTv(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
                return EnvironmentCompat.MEDIA_UNKNOWN;
            }
            if (activeNetworkInfo.getType() == 9) {
                return "ethernet";
            }
            if (activeNetworkInfo.getType() == 1) {
                return "wifi";
            }
            return EnvironmentCompat.MEDIA_UNKNOWN;
        } catch (Exception e) {
            Logger.m17382w(TAG, "Exception: " + e.toString() + " - Cause: " + e.getCause());
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }
}
