package com.mediatek.accessor.util;

public class Log {
    private static final String BUILD_TYPE = SystemPropertyUtils.get("ro.build.type");
    private static final int CUST_LOG_LEVEL;
    private static final int CUST_LOG_LEVEL_D = 1;
    private static final int CUST_LOG_LEVEL_E = 4;
    private static final int CUST_LOG_LEVEL_I = 2;
    private static final int CUST_LOG_LEVEL_V = 0;
    private static final int CUST_LOG_LEVEL_W = 3;
    private static final boolean IS_ENG = "eng".equalsIgnoreCase(BUILD_TYPE);
    private static final String LOGTAG_PREFIX = "Xmp/";
    private static final int LOG_LEVEL_IN_PROPERTY = SystemPropertyUtils.getInt("debug.gallery.loglevel", 2);
    private static final String TAG = "Xmp/Log";

    static {
        int i = 2;
        if (LOG_LEVEL_IN_PROPERTY >= 0 && LOG_LEVEL_IN_PROPERTY <= 4) {
            i = LOG_LEVEL_IN_PROPERTY;
        }
        CUST_LOG_LEVEL = i;
        android.util.Log.d(TAG, "BUILD_TYPE: " + BUILD_TYPE + ", IS_ENG: " + IS_ENG + ", CUST_LOG_LEVEL: " + CUST_LOG_LEVEL);
    }

    public static String Tag(String str) {
        return LOGTAG_PREFIX + str;
    }

    /* renamed from: v */
    public static void m3999v(String str, String str2) {
        if (str != null) {
            if (IS_ENG || enableCustLog(0)) {
                android.util.Log.v(str, str2);
            }
        }
    }

    /* renamed from: v */
    public static void m4000v(String str, String str2, Throwable th) {
        if (str != null) {
            if (IS_ENG || enableCustLog(0)) {
                android.util.Log.v(str, str2, th);
            }
        }
    }

    /* renamed from: d */
    public static void m3993d(String str, String str2) {
        if (str != null) {
            if (IS_ENG || enableCustLog(1)) {
                android.util.Log.d(str, str2);
            }
        }
    }

    /* renamed from: d */
    public static void m3994d(String str, String str2, Throwable th) {
        if (str != null) {
            if (IS_ENG || enableCustLog(1)) {
                android.util.Log.d(str, str2, th);
            }
        }
    }

    /* renamed from: i */
    public static void m3997i(String str, String str2) {
        if (str != null) {
            if (IS_ENG || enableCustLog(2)) {
                android.util.Log.i(str, str2);
            }
        }
    }

    /* renamed from: i */
    public static void m3998i(String str, String str2, Throwable th) {
        if (str != null) {
            if (IS_ENG || enableCustLog(2)) {
                android.util.Log.i(str, str2, th);
            }
        }
    }

    /* renamed from: w */
    public static void m4001w(String str, String str2) {
        if (str != null) {
            if (IS_ENG || enableCustLog(3)) {
                android.util.Log.w(str, str2);
            }
        }
    }

    /* renamed from: w */
    public static void m4002w(String str, String str2, Throwable th) {
        if (str != null) {
            if (IS_ENG || enableCustLog(3)) {
                android.util.Log.w(str, str2, th);
            }
        }
    }

    /* renamed from: e */
    public static void m3995e(String str, String str2) {
        if (str != null) {
            if (IS_ENG || enableCustLog(4)) {
                android.util.Log.e(str, str2);
            }
        }
    }

    /* renamed from: e */
    public static void m3996e(String str, String str2, Throwable th) {
        if (str != null) {
            if (IS_ENG || enableCustLog(4)) {
                android.util.Log.e(str, str2, th);
            }
        }
    }

    private static boolean enableCustLog(int i) {
        if (CUST_LOG_LEVEL < 0 || CUST_LOG_LEVEL > 4 || i < CUST_LOG_LEVEL) {
            return false;
        }
        return true;
    }
}
