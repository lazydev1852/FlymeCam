package com.meizu.cloud.pushinternal;

import android.content.Context;
import android.os.Environment;
import com.meizu.cloud.pushsdk.base.Logger;

public class DebugLogger {
    public static boolean debug = false;

    public static void initDebugLogger(Context context) {
        Logger.get().init(context);
        Logger logger = Logger.get();
        logger.setFilePath(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdk/" + context.getPackageName());
    }

    public static void switchDebug(boolean z) {
        Logger.get().setDebugMode(z);
    }

    public static void flush() {
        Logger.get().flush(false);
    }

    public static boolean isDebuggable() {
        return Logger.get().isDebugMode();
    }

    /* renamed from: i */
    public static void m4829i(String str, String str2) {
        Logger.get().mo14455i(str, str2);
    }

    /* renamed from: d */
    public static void m4827d(String str, String str2) {
        Logger.get().mo14451d(str, str2);
    }

    /* renamed from: w */
    public static void m4830w(String str, String str2) {
        Logger.get().mo14461w(str, str2);
    }

    /* renamed from: e */
    public static void m4828e(String str, String str2) {
        Logger.get().mo14452e(str, str2);
    }
}
