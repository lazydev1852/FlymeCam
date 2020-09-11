package com.baidu.p020ar.util;

import android.os.Handler;
import android.os.Looper;

/* renamed from: com.baidu.ar.util.UiThreadUtil */
public class UiThreadUtil {

    /* renamed from: a */
    private static Handler f2382a = new Handler(Looper.getMainLooper());

    public static boolean isOnUiThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static void postDelayed(Runnable runnable, long j) {
        f2382a.postDelayed(runnable, j);
    }

    public static void removeCallbacks(Runnable runnable) {
        f2382a.removeCallbacks(runnable);
    }

    public static void removeCallbacksAndMessages() {
        f2382a.removeCallbacksAndMessages((Object) null);
    }

    public static void runOnUiThread(Runnable runnable) {
        if (runnable != null) {
            if (isOnUiThread()) {
                runnable.run();
            } else {
                f2382a.post(runnable);
            }
        }
    }
}
