package com.meizu.cloud.pushsdk.networking.common;

import android.util.Log;
import com.meizu.cloud.pushinternal.DebugLogger;

public class ANLog {
    private static boolean IS_LOGGING_ENABLED = false;
    private static String TAG = "AndroidNetworking";

    private ANLog() {
    }

    public static void enableLogging() {
        IS_LOGGING_ENABLED = true;
    }

    public static void disableLogging() {
        IS_LOGGING_ENABLED = false;
    }

    public static void setTag(String str) {
        if (str != null) {
            TAG = str;
        }
    }

    /* renamed from: d */
    public static void m4846d(String str) {
        if (IS_LOGGING_ENABLED) {
            DebugLogger.m4827d(TAG, str);
        }
    }

    /* renamed from: e */
    public static void m4847e(String str) {
        if (IS_LOGGING_ENABLED) {
            DebugLogger.m4828e(TAG, str);
        }
    }

    /* renamed from: i */
    public static void m4848i(String str) {
        if (IS_LOGGING_ENABLED) {
            DebugLogger.m4829i(TAG, str);
        }
    }

    /* renamed from: w */
    public static void m4849w(String str) {
        if (IS_LOGGING_ENABLED) {
            DebugLogger.m4830w(TAG, str);
        }
    }

    public static void wtf(String str) {
        if (IS_LOGGING_ENABLED) {
            Log.wtf(TAG, str);
        }
    }
}
