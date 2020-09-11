package com.meizu.statsapp.p081v3.lib.plugin.session;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import com.meizu.statsapp.p081v3.GlobalExecutor;
import com.meizu.statsapp.p081v3.utils.log.Logger;
import java.util.HashMap;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.session.ActivityLifecycleCallback */
public class ActivityLifecycleCallback implements Application.ActivityLifecycleCallbacks {
    private static final String TAG = "ActivityLifecycleCallback";
    private final int ONCE_USE = 1;
    /* access modifiers changed from: private */
    public long endElapse;
    /* access modifiers changed from: private */
    public long endTime;
    /* access modifiers changed from: private */
    public long initElapse;
    /* access modifiers changed from: private */
    public long initTime;
    private Handler mainHandler;
    /* access modifiers changed from: private */
    public SessionController sessionController;
    /* access modifiers changed from: private */
    public long startElapse;
    /* access modifiers changed from: private */
    public long startTime;

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    ActivityLifecycleCallback(SessionController sessionController2) {
        this.sessionController = sessionController2;
        this.endElapse = 0;
        this.startElapse = 0;
        this.endTime = 0;
        this.startTime = 0;
        this.initTime = System.currentTimeMillis();
        this.initElapse = SystemClock.elapsedRealtime();
        this.mainHandler = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    Logger.m17378d(ActivityLifecycleCallback.TAG, "msg.what: ONCE_USE");
                    if (ActivityLifecycleCallback.this.startTime == 0) {
                        ActivityLifecycleCallback.this.sessionController.onForeground();
                        long unused = ActivityLifecycleCallback.this.startTime = ActivityLifecycleCallback.this.initTime;
                        long unused2 = ActivityLifecycleCallback.this.startElapse = ActivityLifecycleCallback.this.initElapse;
                    }
                    ActivityLifecycleCallback.this.sessionController.onBackground();
                    ActivityLifecycleCallback.this.onceUse();
                    long unused3 = ActivityLifecycleCallback.this.startTime = ActivityLifecycleCallback.this.endTime = ActivityLifecycleCallback.this.startElapse = ActivityLifecycleCallback.this.endElapse = 0;
                }
            }
        };
    }

    public void onActivityResumed(Activity activity) {
        Logger.m17378d(TAG, "onActivityResumed, process:" + Process.myPid());
        onForeground();
    }

    public void onAppWidgetResumed() {
        Logger.m17378d(TAG, "onWidgetResumed, process:" + Process.myPid());
        onForeground();
    }

    public void onActivityPaused(Activity activity) {
        Logger.m17378d(TAG, "onActivityPaused, process:" + Process.myPid());
        onBackground();
    }

    public void onAppWidgetPaused() {
        Logger.m17378d(TAG, "onAppWidgetPaused, process:" + Process.myPid());
        onBackground();
    }

    private void onForeground() {
        if (this.startTime == 0) {
            this.sessionController.onForeground();
            this.startTime = System.currentTimeMillis();
            this.startElapse = SystemClock.elapsedRealtime();
        }
        this.mainHandler.removeMessages(1);
    }

    private void onBackground() {
        this.endTime = System.currentTimeMillis();
        this.endElapse = SystemClock.elapsedRealtime();
        this.mainHandler.removeMessages(1);
        this.mainHandler.sendEmptyMessageDelayed(1, 1000);
    }

    /* access modifiers changed from: private */
    public void onceUse() {
        long j = this.endTime - this.startTime;
        long j2 = this.endElapse - this.startElapse;
        Logger.m17378d(TAG, "onceUse, startTime:" + this.startTime + ", endTime:" + this.endTime + ", duration:" + j);
        if (this.startTime > 0 && this.endTime > 0 && j > 0) {
            final HashMap hashMap = new HashMap();
            hashMap.put("startTime", String.valueOf(this.startTime));
            hashMap.put("endTime", String.valueOf(this.endTime));
            hashMap.put("duration", String.valueOf(j));
            hashMap.put("duration2", String.valueOf(j2));
            GlobalExecutor.execute(new Runnable() {
                public void run() {
                    if (ActivityLifecycleCallback.this.sessionController.sdkInstanceImpl != null) {
                        ActivityLifecycleCallback.this.sessionController.sdkInstanceImpl.onEvent("_onceuse_", (String) null, hashMap);
                    }
                }
            });
        }
    }
}
