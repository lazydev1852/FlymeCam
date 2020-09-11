package com.meizu.statsapp.p081v3.utils.log;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.meizu.statsapp.p081v3.InitConfig;
import com.meizu.statsapp.p081v3.utils.CommonUtils;

/* renamed from: com.meizu.statsapp.v3.utils.log.Logger */
public class Logger {
    private static final String TAG = "UsageStats_";
    /* access modifiers changed from: private */
    public static LogLevel sConsoleLogLevel = LogLevel.DEBUG;
    public static boolean sDebug = false;
    /* access modifiers changed from: private */
    public static ILog sHook = null;
    private static Handler workHandler = null;
    private static final String workThreadName = "UsageStats_Logger";

    private static String getTag(String str) {
        return str;
    }

    static {
        sDebug = false;
        sDebug = CommonUtils.isPrintLog() | InitConfig.printLog;
        HandlerThread handlerThread = new HandlerThread(workThreadName);
        handlerThread.start();
        workHandler = new Handler(handlerThread.getLooper());
    }

    public static void setHook(ILog iLog) {
        sHook = iLog;
    }

    public static void setLevel(LogLevel logLevel) {
        sConsoleLogLevel = logLevel;
    }

    /* renamed from: v */
    public static void m17381v(String str, String str2) {
        if (sDebug) {
            workHandler.post(new LogInfo(LogLevel.VERBOSE, getTag(str), str2, getThread(), getThreadName()));
        }
    }

    /* renamed from: d */
    public static void m17378d(String str, String str2) {
        if (sDebug) {
            workHandler.post(new LogInfo(LogLevel.DEBUG, getTag(str), str2, getThread(), getThreadName()));
        }
    }

    /* renamed from: i */
    public static void m17380i(String str, String str2) {
        if (sDebug) {
            workHandler.post(new LogInfo(LogLevel.INFO, getTag(str), str2, getThread(), getThreadName()));
        }
    }

    /* renamed from: w */
    public static void m17382w(String str, String str2) {
        if (sDebug) {
            workHandler.post(new LogInfo(LogLevel.WARN, getTag(str), str2, getThread(), getThreadName()));
        }
    }

    /* renamed from: e */
    public static void m17379e(String str, String str2) {
        if (sDebug) {
            workHandler.post(new LogInfo(LogLevel.ERROR, getTag(str), str2, getThread(), getThreadName()));
        }
    }

    private static long getThread() {
        return Thread.currentThread().getId();
    }

    private static String getThreadName() {
        return Thread.currentThread().getName();
    }

    /* renamed from: com.meizu.statsapp.v3.utils.log.Logger$LogInfo */
    private static class LogInfo implements Runnable {
        private LogLevel mLogLevel;
        private String mMsg;
        private String mTag;
        private String mThreadName;
        private long mTid;

        public LogInfo(LogLevel logLevel, String str, String str2, long j, String str3) {
            this.mLogLevel = logLevel;
            this.mTag = str;
            this.mMsg = str2;
            this.mTid = j;
            this.mThreadName = str3;
        }

        private String getMessage() {
            return this.mThreadName + "|" + this.mMsg;
        }

        public void run() {
            if (this.mLogLevel.ordinal() >= Logger.sConsoleLogLevel.ordinal()) {
                if (this.mLogLevel == LogLevel.DEBUG) {
                    Log.d(this.mTag, getMessage());
                } else if (this.mLogLevel == LogLevel.INFO) {
                    Log.i(this.mTag, getMessage());
                } else if (this.mLogLevel == LogLevel.WARN) {
                    Log.w(this.mTag, getMessage());
                } else if (this.mLogLevel == LogLevel.ERROR) {
                    Log.e(this.mTag, getMessage());
                }
                if (Logger.sHook != null) {
                    Logger.sHook.print(this.mLogLevel, this.mTag, getMessage(), this.mTid);
                }
            }
        }
    }
}
