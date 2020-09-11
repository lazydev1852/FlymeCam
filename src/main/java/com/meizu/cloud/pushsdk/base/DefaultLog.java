package com.meizu.cloud.pushsdk.base;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class DefaultLog implements ICacheLog {
    private int mCacheCounter = 10;
    private long mCacheDuration = 60;
    /* access modifiers changed from: private */
    public List<LogInfo> mCachedList = Collections.synchronizedList(new ArrayList());
    /* access modifiers changed from: private */
    public SimpleDateFormat mDateFormat = new SimpleDateFormat("MM-dd HH:mm:ss");
    private boolean mDebugMode = false;
    /* access modifiers changed from: private */
    public Handler mDelayHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public String mPath = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdk/defaultLog");
    /* access modifiers changed from: private */
    public String mPid = String.valueOf(Process.myPid());
    /* access modifiers changed from: private */
    public EncryptionWriter mWriter = new EncryptionWriter();

    private void startDelayTimer() {
        if (this.mCachedList.size() == 0) {
            this.mDelayHandler.postDelayed(new Runnable() {
                public void run() {
                    DefaultLog.this.flush(true);
                }
            }, this.mCacheDuration * 1000);
        }
    }

    private void checkLogCount() {
        if (this.mCachedList.size() == this.mCacheCounter) {
            flush(true);
        }
    }

    /* renamed from: d */
    public void mo14451d(String str, String str2) {
        if (this.mDebugMode) {
            Log.d(str, str2);
        }
        synchronized (this.mCachedList) {
            startDelayTimer();
            addLogInfo(new LogInfo("D", str, str2));
            checkLogCount();
        }
    }

    /* renamed from: i */
    public void mo14455i(String str, String str2) {
        if (this.mDebugMode) {
            Log.i(str, str2);
        }
        synchronized (this.mCachedList) {
            startDelayTimer();
            addLogInfo(new LogInfo("I", str, str2));
            checkLogCount();
        }
    }

    /* renamed from: w */
    public void mo14461w(String str, String str2) {
        if (this.mDebugMode) {
            Log.w(str, str2);
        }
        synchronized (this.mCachedList) {
            startDelayTimer();
            addLogInfo(new LogInfo(ExifInterface.LONGITUDE_WEST, str, str2));
            checkLogCount();
        }
    }

    /* renamed from: e */
    public void mo14452e(String str, String str2) {
        if (this.mDebugMode) {
            Log.e(str, str2);
        }
        synchronized (this.mCachedList) {
            startDelayTimer();
            addLogInfo(new LogInfo(ExifInterface.LONGITUDE_EAST, str, str2));
            checkLogCount();
        }
    }

    /* renamed from: e */
    public void mo14453e(String str, String str2, Throwable th) {
        if (this.mDebugMode) {
            Log.e(str, str2, th);
        }
        synchronized (this.mCachedList) {
            startDelayTimer();
            addLogInfo(new LogInfo(ExifInterface.LONGITUDE_EAST, str, str2 + "\n" + Log.getStackTraceString(th)));
            checkLogCount();
        }
    }

    public void setCacheDuration(long j) {
        this.mCacheDuration = j;
    }

    public void setCacheCount(int i) {
        this.mCacheCounter = i;
    }

    public void setFilePath(String str) {
        this.mPath = str;
    }

    public void flush(boolean z) {
        C12082 r0 = new Runnable() {
            /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x006d */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r5 = this;
                    java.util.ArrayList r0 = new java.util.ArrayList
                    r0.<init>()
                    com.meizu.cloud.pushsdk.base.DefaultLog r1 = com.meizu.cloud.pushsdk.base.DefaultLog.this
                    java.util.List r1 = r1.mCachedList
                    monitor-enter(r1)
                    com.meizu.cloud.pushsdk.base.DefaultLog r2 = com.meizu.cloud.pushsdk.base.DefaultLog.this     // Catch:{ all -> 0x0071 }
                    android.os.Handler r2 = r2.mDelayHandler     // Catch:{ all -> 0x0071 }
                    r3 = 0
                    r2.removeCallbacksAndMessages(r3)     // Catch:{ all -> 0x0071 }
                    com.meizu.cloud.pushsdk.base.DefaultLog r2 = com.meizu.cloud.pushsdk.base.DefaultLog.this     // Catch:{ all -> 0x0071 }
                    java.util.List r2 = r2.mCachedList     // Catch:{ all -> 0x0071 }
                    r0.addAll(r2)     // Catch:{ all -> 0x0071 }
                    com.meizu.cloud.pushsdk.base.DefaultLog r2 = com.meizu.cloud.pushsdk.base.DefaultLog.this     // Catch:{ all -> 0x0071 }
                    java.util.List r2 = r2.mCachedList     // Catch:{ all -> 0x0071 }
                    r2.clear()     // Catch:{ all -> 0x0071 }
                    monitor-exit(r1)     // Catch:{ all -> 0x0071 }
                    com.meizu.cloud.pushsdk.base.DefaultLog r1 = com.meizu.cloud.pushsdk.base.DefaultLog.this     // Catch:{ Exception -> 0x006d, all -> 0x0062 }
                    com.meizu.cloud.pushsdk.base.EncryptionWriter r1 = r1.mWriter     // Catch:{ Exception -> 0x006d, all -> 0x0062 }
                    com.meizu.cloud.pushsdk.base.DefaultLog r2 = com.meizu.cloud.pushsdk.base.DefaultLog.this     // Catch:{ Exception -> 0x006d, all -> 0x0062 }
                    java.lang.String r2 = r2.mPath     // Catch:{ Exception -> 0x006d, all -> 0x0062 }
                    r1.open(r2)     // Catch:{ Exception -> 0x006d, all -> 0x0062 }
                    java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x006d, all -> 0x0062 }
                L_0x003c:
                    boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x006d, all -> 0x0062 }
                    if (r1 == 0) goto L_0x0058
                    java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x006d, all -> 0x0062 }
                    com.meizu.cloud.pushsdk.base.DefaultLog$LogInfo r1 = (com.meizu.cloud.pushsdk.base.DefaultLog.LogInfo) r1     // Catch:{ Exception -> 0x006d, all -> 0x0062 }
                    com.meizu.cloud.pushsdk.base.DefaultLog r2 = com.meizu.cloud.pushsdk.base.DefaultLog.this     // Catch:{ Exception -> 0x006d, all -> 0x0062 }
                    com.meizu.cloud.pushsdk.base.EncryptionWriter r2 = r2.mWriter     // Catch:{ Exception -> 0x006d, all -> 0x0062 }
                    java.lang.String r3 = r1.header     // Catch:{ Exception -> 0x006d, all -> 0x0062 }
                    java.lang.String r4 = r1.tag     // Catch:{ Exception -> 0x006d, all -> 0x0062 }
                    java.lang.String r1 = r1.msg     // Catch:{ Exception -> 0x006d, all -> 0x0062 }
                    r2.write(r3, r4, r1)     // Catch:{ Exception -> 0x006d, all -> 0x0062 }
                    goto L_0x003c
                L_0x0058:
                    com.meizu.cloud.pushsdk.base.DefaultLog r0 = com.meizu.cloud.pushsdk.base.DefaultLog.this     // Catch:{ Exception -> 0x0070 }
                L_0x005a:
                    com.meizu.cloud.pushsdk.base.EncryptionWriter r0 = r0.mWriter     // Catch:{ Exception -> 0x0070 }
                    r0.close()     // Catch:{ Exception -> 0x0070 }
                    goto L_0x0070
                L_0x0062:
                    r0 = move-exception
                    com.meizu.cloud.pushsdk.base.DefaultLog r1 = com.meizu.cloud.pushsdk.base.DefaultLog.this     // Catch:{ Exception -> 0x006c }
                    com.meizu.cloud.pushsdk.base.EncryptionWriter r1 = r1.mWriter     // Catch:{ Exception -> 0x006c }
                    r1.close()     // Catch:{ Exception -> 0x006c }
                L_0x006c:
                    throw r0
                L_0x006d:
                    com.meizu.cloud.pushsdk.base.DefaultLog r0 = com.meizu.cloud.pushsdk.base.DefaultLog.this     // Catch:{ Exception -> 0x0070 }
                    goto L_0x005a
                L_0x0070:
                    return
                L_0x0071:
                    r0 = move-exception
                    monitor-exit(r1)     // Catch:{ all -> 0x0071 }
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.base.DefaultLog.C12082.run():void");
            }
        };
        if (z) {
            ExecutorProxy.get().execute(r0);
        } else {
            r0.run();
        }
    }

    public void setDebugMode(boolean z) {
        this.mDebugMode = z;
    }

    public boolean isDebugMode() {
        return this.mDebugMode;
    }

    class LogInfo {
        String header;
        String msg;
        String tag;

        public LogInfo(String str, String str2, String str3) {
            StringBuffer stringBuffer = new StringBuffer(DefaultLog.this.mDateFormat.format(new Date()));
            stringBuffer.append(" ");
            stringBuffer.append(DefaultLog.this.mPid);
            stringBuffer.append("-");
            stringBuffer.append(String.valueOf(Thread.currentThread().getId()));
            stringBuffer.append(" ");
            stringBuffer.append(str);
            stringBuffer.append("/");
            this.header = stringBuffer.toString();
            this.tag = str2;
            this.msg = str3;
        }
    }

    private void addLogInfo(LogInfo logInfo) {
        try {
            this.mCachedList.add(logInfo);
        } catch (Exception e) {
            Log.e("Logger", "add logInfo error " + e.getMessage());
        }
    }
}
