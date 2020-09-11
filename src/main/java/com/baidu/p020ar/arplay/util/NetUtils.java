package com.baidu.p020ar.arplay.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.Locale;

/* renamed from: com.baidu.ar.arplay.util.NetUtils */
public class NetUtils {

    /* renamed from: com.baidu.ar.arplay.util.NetUtils$NetType */
    public enum NetType {
        WIFI,
        CMNET,
        CMWAP,
        NONE
    }

    /* renamed from: a */
    public static boolean m1163a(Context context) {
        NetworkInfo[] allNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getAllNetworkInfo();
        if (allNetworkInfo != null) {
            for (NetworkInfo state : allNetworkInfo) {
                if (state.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    public static NetType m1164b(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return NetType.NONE;
        }
        int type = activeNetworkInfo.getType();
        return type == 0 ? activeNetworkInfo.getExtraInfo().toLowerCase(Locale.getDefault()).equals("cmnet") ? NetType.CMNET : NetType.CMWAP : type == 1 ? NetType.WIFI : NetType.NONE;
    }
}
