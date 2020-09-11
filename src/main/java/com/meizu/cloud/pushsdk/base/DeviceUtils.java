package com.meizu.cloud.pushsdk.base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.p020ar.util.SystemInfoUtil;
import com.meizu.cloud.pushinternal.DebugLogger;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class DeviceUtils {
    private static final String TAG = "DeviceUtils";
    private static String sDeviceId = "";
    private static String sMacAddr = "";

    public static boolean isPhone() {
        String str = SystemProperties.get("ro.target.product");
        if (!TextUtils.isEmpty(str)) {
            DebugLogger.m4829i(TAG, "current product is " + str);
            return false;
        }
        DebugLogger.m4829i(TAG, "current product is phone");
        return true;
    }

    public static String getDeviceType() {
        String str = SystemProperties.get("ro.target.product");
        if (!TextUtils.isEmpty(str)) {
            DebugLogger.m4829i(TAG, "current product is " + str);
        }
        return str;
    }

    public static String getDeviceId(Context context) {
        if (TextUtils.isEmpty(sDeviceId)) {
            if (isPhone()) {
                sDeviceId = MzTelephoneManager.getDeviceId(context);
            } else if (TextUtils.isEmpty(sDeviceId)) {
                StringBuilder sb = new StringBuilder();
                String str = Build.SERIAL;
                DebugLogger.m4829i(TAG, "device serial " + str);
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                sb.append(str);
                String mACAddress = getMACAddress(context);
                DebugLogger.m4828e(TAG, "mac address " + mACAddress);
                if (TextUtils.isEmpty(mACAddress)) {
                    return null;
                }
                sb.append(mACAddress.replace(SystemInfoUtil.COLON, "").toUpperCase());
                sDeviceId = sb.toString();
            }
        }
        return sDeviceId;
    }

    public static String getMACAddress(Context context) {
        WifiInfo connectionInfo;
        String macAddress;
        if (!TextUtils.isEmpty(sMacAddr)) {
            return sMacAddr;
        }
        String str = null;
        if (Build.VERSION.SDK_INT >= 23) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    macAddress = getMacAddressWithIfName("wlan0");
                    if (TextUtils.isEmpty(macAddress)) {
                        macAddress = getMacAddressWithIfName("eth0");
                    }
                } else if (activeNetworkInfo.getType() == 1) {
                    macAddress = getMacAddressWithIfName("wlan0");
                } else if (activeNetworkInfo.getType() == 9) {
                    macAddress = getMacAddressWithIfName("eth0");
                }
            }
            sMacAddr = str;
            return sMacAddr;
        }
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (!(wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null)) {
            macAddress = connectionInfo.getMacAddress();
        }
        sMacAddr = str;
        return sMacAddr;
        str = macAddress;
        sMacAddr = str;
        return sMacAddr;
    }

    private static String getMacAddressWithIfName(String str) {
        String str2 = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("/sys/class/net/" + str + "/address");
            Scanner scanner = new Scanner(fileInputStream);
            if (scanner.hasNextLine()) {
                str2 = scanner.nextLine().trim();
            }
            fileInputStream.close();
        } catch (FileNotFoundException unused) {
            DebugLogger.m4828e(TAG, "getMacAddressWithIfName File not found Exception");
        } catch (IOException unused2) {
            DebugLogger.m4828e(TAG, "getMacAddressWithIfName IOException");
        }
        return str2;
    }
}
