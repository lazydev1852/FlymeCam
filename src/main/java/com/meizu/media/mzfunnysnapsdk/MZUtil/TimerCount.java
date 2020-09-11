package com.meizu.media.mzfunnysnapsdk.MZUtil;

import android.util.Log;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import java.util.Timer;
import java.util.TimerTask;

public class TimerCount {
    public static ChangeQuickRedirect changeQuickRedirect;
    private int mFrameCount = 0;
    private int mFrameCurrent = 0;
    private int mShowFrame = 0;
    private Timer mTimer = new Timer(true);
    private TimerTask mTimerTask;
    private int mTriggerAction = 0;
    private int mTriggerCurrent = 0;
    private boolean mbTrigger = true;

    public TimerCount(int i, int i2) {
        this.mFrameCount = i;
        this.mTriggerAction = i2;
        this.mTimerTask = new TimerTask() {
            public static ChangeQuickRedirect changeQuickRedirect;

            public void run() {
                if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9278, new Class[0], Void.TYPE).isSupported) {
                    synchronized (this) {
                        TimerCount.this.calaFrame();
                        TimerCount.this.calaTrigger();
                    }
                }
            }
        };
    }

    private void showDataTip() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9275, new Class[0], Void.TYPE).isSupported) {
            Log.e("timer", "=====" + this.mFrameCount + "=====");
            Log.e("timer", "=====" + this.mFrameCurrent + "=====");
            Log.e("timer", "=====" + this.mTriggerAction + "=====");
            Log.e("timer", "=====" + this.mbTrigger + "=====");
            Log.e("timer", "=====" + this.mTriggerCurrent + "=====");
        }
    }

    /* access modifiers changed from: private */
    public void calaFrame() {
        if (this.mbTrigger) {
            this.mShowFrame = this.mFrameCurrent;
        } else {
            this.mShowFrame = this.mFrameCount - 1;
        }
        this.mFrameCurrent++;
        if (this.mFrameCurrent >= this.mFrameCount) {
            this.mFrameCurrent = 0;
            this.mbTrigger = false;
            this.mTriggerCurrent++;
        }
    }

    /* access modifiers changed from: private */
    public void calaTrigger() {
        if (this.mTriggerCurrent >= this.mTriggerAction) {
            this.mTriggerCurrent = 0;
            this.mbTrigger = true;
        }
    }

    public void startTimer(long j) {
        Object[] objArr = {new Long(j)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9276, new Class[]{Long.TYPE}, Void.TYPE).isSupported) {
            this.mTimer.schedule(this.mTimerTask, 30, j);
        }
    }

    public int getFrameCurrent() {
        return this.mShowFrame;
    }

    public void stopTimer() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9277, new Class[0], Void.TYPE).isSupported) {
            if (this.mTimer != null) {
                this.mTimer.cancel();
                this.mTimer = null;
            }
            if (this.mTimerTask != null) {
                this.mTimerTask.cancel();
                this.mTimerTask = null;
            }
        }
    }
}
