package com.baidu.p020ar.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* renamed from: com.baidu.ar.util.NetworkUtil */
public final class NetworkUtil {
    public static final int NETWORKTYPE_2G = 2;
    public static final int NETWORKTYPE_3G = 3;
    public static final int NETWORKTYPE_4G = 4;
    public static final int NETWORKTYPE_WIFI = 5;

    private NetworkUtil() {
    }

    /* renamed from: a */
    private static NetworkInfo m2725a(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return null;
        }
        return connectivityManager.getActiveNetworkInfo();
    }

    public static int getActiveNetworkType(Context context) {
        NetworkInfo a = m2725a(context);
        if (!(a != null && a.isAvailable() && a.getType() == 0)) {
            return Integer.MIN_VALUE;
        }
        String subtypeName = a.getSubtypeName();
        switch (a.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 3;
            case 13:
                return 4;
            default:
                return (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) ? 3 : Integer.MIN_VALUE;
        }
    }

    public static String getNetworkType(Context context) {
        if (!isNetworkConnected(context) || context == null) {
            return "not_Reachable";
        }
        if (isWifiNetworkConnected(context)) {
            return "wifi";
        }
        int activeNetworkType = getActiveNetworkType(context);
        return activeNetworkType == 2 ? "2G" : activeNetworkType == 3 ? "3G" : activeNetworkType == 4 ? "4G" : "other_network";
    }

    public static boolean isMobileNetworkConnected(Context context) {
        NetworkInfo a = m2725a(context);
        return a != null && a.isAvailable() && a.getType() == 0;
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo a = m2725a(context);
        return a != null && a.isAvailable();
    }

    public static boolean isWifiNetworkConnected(Context context) {
        NetworkInfo a = m2725a(context);
        return a != null && a.isAvailable() && a.getType() == 1;
    }
}
