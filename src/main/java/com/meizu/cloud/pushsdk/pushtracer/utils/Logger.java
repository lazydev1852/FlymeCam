package com.meizu.cloud.pushsdk.pushtracer.utils;

import com.meizu.cloud.pushinternal.DebugLogger;

public class Logger {
    private static int level;

    /* renamed from: e */
    public static void m4855e(String str, String str2, Object... objArr) {
        if (level >= 1) {
            DebugLogger.m4828e(getTag(str), getMessage(str2, objArr));
        }
    }

    /* renamed from: d */
    public static void m4854d(String str, String str2, Object... objArr) {
        if (level >= 2) {
            DebugLogger.m4827d(getTag(str), getMessage(str2, objArr));
        }
    }

    /* renamed from: i */
    public static void m4856i(String str, String str2, Object... objArr) {
        if (level >= 3) {
            DebugLogger.m4829i(getTag(str), getMessage(str2, objArr));
        }
    }

    private static String getMessage(String str, Object... objArr) {
        return getThread() + "|" + String.format(str, objArr);
    }

    private static String getTag(String str) {
        return "PushTracker->" + str;
    }

    private static String getThread() {
        return Thread.currentThread().getName();
    }

    public static void updateLogLevel(LogLevel logLevel) {
        level = logLevel.getLevel();
    }
}
