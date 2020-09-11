package com.baidu.p020ar.util;

import android.util.Log;
import com.meizu.savior.Constants;

/* renamed from: com.baidu.ar.util.ARLog */
public final class ARLog {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    /* renamed from: a */
    private static int f2354a = 5;

    private ARLog() {
    }

    /* renamed from: d */
    public static void m2695d(String str) {
        if (f2354a <= 3) {
            Log.d("ARLOG", getFileLineMethod() + " " + str);
        }
    }

    /* renamed from: e */
    public static void m2696e(String str) {
        if (f2354a <= 6) {
            Log.e("ARLOG", getFileLineMethod() + " " + str);
        }
    }

    public static String getFileLineMethod() {
        StackTraceElement stackTraceElement = new Exception().getStackTrace()[2];
        StringBuffer stringBuffer = new StringBuffer(Constants.ARRAY_TYPE);
        stringBuffer.append(stackTraceElement.getFileName());
        stringBuffer.append(" | ");
        stringBuffer.append(stackTraceElement.getLineNumber());
        stringBuffer.append(" | ");
        stringBuffer.append(stackTraceElement.getMethodName());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    /* renamed from: i */
    public static void m2697i(String str) {
        if (f2354a <= 4) {
            Log.i("ARLOG", getFileLineMethod() + " " + str);
        }
    }

    public static void setDebugEnable(boolean z) {
        f2354a = z ? 2 : 6;
    }

    /* renamed from: v */
    public static void m2698v(String str) {
        if (f2354a <= 2) {
            Log.v("ARLOG", getFileLineMethod() + " " + str);
        }
    }

    /* renamed from: w */
    public static void m2699w(String str) {
        if (f2354a <= 5) {
            Log.w("ARLOG", getFileLineMethod() + " " + str);
        }
    }
}
