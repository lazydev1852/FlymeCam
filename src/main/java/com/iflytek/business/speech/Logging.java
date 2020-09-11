package com.iflytek.business.speech;

import android.util.Log;

/* renamed from: com.iflytek.business.speech.g */
public class Logging {

    /* renamed from: a */
    protected static boolean f2474a = true;

    /* renamed from: a */
    public static void m2834a(boolean z) {
        Log.i("Logging", "setIsLogEnable Enabled= " + z);
        f2474a = z;
    }

    /* renamed from: a */
    public static int m2831a(String str, String str2) {
        if (f2474a) {
            return Log.d(str, str2);
        }
        return 0;
    }

    /* renamed from: b */
    public static int m2835b(String str, String str2) {
        if (f2474a) {
            return Log.i(str, str2);
        }
        return 0;
    }

    /* renamed from: c */
    public static int m2836c(String str, String str2) {
        if (f2474a) {
            return Log.w(str, str2);
        }
        return 0;
    }

    /* renamed from: a */
    public static int m2833a(String str, Throwable th) {
        if (f2474a) {
            return Log.w(str, th);
        }
        return 0;
    }

    /* renamed from: d */
    public static int m2837d(String str, String str2) {
        if (f2474a) {
            return Log.e(str, str2);
        }
        return 0;
    }

    /* renamed from: a */
    public static int m2832a(String str, String str2, Throwable th) {
        if (f2474a) {
            return Log.e(str, str2, th);
        }
        return 0;
    }
}
