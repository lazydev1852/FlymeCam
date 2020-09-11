package com.meizu.statsapp.p081v3.lib.plugin.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.utils.IntervalTimer */
public abstract class IntervalTimer {
    private static final int MSG = 1;
    private static final int SKIP = -1;
    /* access modifiers changed from: private */
    public boolean mCancelled;
    /* access modifiers changed from: private */
    public final long mCountdownInterval;
    private Handler mHandler;
    /* access modifiers changed from: private */
    public long mTriggerTimeInFuture;

    public abstract void onTrigger();

    public IntervalTimer(long j) {
        this((Looper) null, j);
    }

    public IntervalTimer(Looper looper, long j) {
        this.mCancelled = false;
        this.mCountdownInterval = j;
        this.mHandler = new Handler(looper == null ? Looper.getMainLooper() : looper) {
            public void handleMessage(Message message) {
                synchronized (IntervalTimer.this) {
                    if (!IntervalTimer.this.mCancelled) {
                        int i = message.what;
                        if (i == -1) {
                            long unused = IntervalTimer.this.mTriggerTimeInFuture = SystemClock.elapsedRealtime() + IntervalTimer.this.mCountdownInterval;
                        } else if (i == 1) {
                            long access$100 = IntervalTimer.this.mTriggerTimeInFuture - SystemClock.elapsedRealtime();
                            if (access$100 <= 0) {
                                IntervalTimer.this.onTrigger();
                                long unused2 = IntervalTimer.this.mTriggerTimeInFuture = (IntervalTimer.this.mTriggerTimeInFuture + IntervalTimer.this.mCountdownInterval) - access$100;
                                sendMessageDelayed(obtainMessage(1), IntervalTimer.this.mCountdownInterval);
                            } else if (access$100 <= IntervalTimer.this.mCountdownInterval) {
                                sendMessageDelayed(obtainMessage(1), access$100);
                            }
                        }
                    }
                }
            }
        };
    }

    public synchronized void cancel() {
        this.mCancelled = true;
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(-1);
    }

    public void skip() {
        this.mHandler.sendEmptyMessage(-1);
    }

    public synchronized IntervalTimer start() {
        this.mCancelled = false;
        this.mTriggerTimeInFuture = SystemClock.elapsedRealtime() + this.mCountdownInterval;
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        return this;
    }
}
