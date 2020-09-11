package com.meizu.statsapp.p081v3;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* renamed from: com.meizu.statsapp.v3.GlobalExecutor */
public class GlobalExecutor {
    private static final int KILL_WORKER = 5;
    /* access modifiers changed from: private */
    public static String TAG = "GlobalExecutor";
    /* access modifiers changed from: private */
    public static Handler sHandler;

    private static Handler getExecutor() {
        if (sHandler == null) {
            synchronized (GlobalExecutor.class) {
                HandlerThread handlerThread = new HandlerThread("com.meizu.statsapp.v3.apiWorker", 5);
                handlerThread.start();
                sHandler = new MessageHandler(handlerThread.getLooper());
            }
        }
        return sHandler;
    }

    /* renamed from: com.meizu.statsapp.v3.GlobalExecutor$MessageHandler */
    static class MessageHandler extends Handler {
        public MessageHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what == 5) {
                String access$000 = GlobalExecutor.TAG;
                Log.w(access$000, "Worker received a hard kill. Thread id " + Thread.currentThread().getId());
                synchronized (GlobalExecutor.class) {
                    Handler unused = GlobalExecutor.sHandler = null;
                    try {
                        Looper.myLooper().quit();
                    } catch (NullPointerException e) {
                        String access$0002 = GlobalExecutor.TAG;
                        Log.w(access$0002, "Exception: " + e.toString() + " - Cause: " + e.getCause());
                    }
                }
            }
        }
    }

    public static void execute(Runnable runnable) {
        getExecutor().post(runnable);
    }

    public static void schedule(Runnable runnable, long j) {
        getExecutor().postDelayed(runnable, j);
    }

    private static void sendMessage(Message message) {
        getExecutor().sendMessage(message);
    }

    public static void cancel(Runnable runnable) {
        getExecutor().removeCallbacks(runnable);
    }

    public static void shutdown() {
        Message obtain = Message.obtain();
        obtain.what = 5;
        getExecutor().sendMessage(obtain);
    }

    private static boolean isDead() {
        boolean z;
        synchronized (GlobalExecutor.class) {
            z = sHandler == null;
        }
        return z;
    }

    public static Looper getLooper() {
        return getExecutor().getLooper();
    }

    public static boolean status() {
        return isDead();
    }
}
