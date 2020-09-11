package com.baidu.p020ar.load;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.p020ar.util.ARLog;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.baidu.ar.load.ARAsyncTask */
public abstract class ARAsyncTask<PARAMS, PROGRESS, RESULT> {
    private static final int MESSAGE_POST_DELAY = 5;
    private static final int MESSAGE_POST_ERROR = 4;
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final int MESSAGE_POST_RESULT = 1;
    private static final int MESSAGE_POST_TIME_OUT = 3;
    private static volatile Executor sDefaultExecutor = AsyncTask.SERIAL_EXECUTOR;
    private static final C0782b sHandler = new C0782b();
    private final AtomicBoolean mCancelled = new AtomicBoolean();
    /* access modifiers changed from: private */
    public boolean mCatchError = true;
    private boolean mDelayEnable = false;
    private final FutureTask<RESULT> mFuture = new FutureTask<RESULT>(this.mWorker) {
        /* access modifiers changed from: protected */
        public void done() {
            try {
                ARAsyncTask.this.postResultIfNotInvoked(get());
            } catch (InterruptedException e) {
                ARLog.m2696e(e.getMessage());
                ARAsyncTask.this.postError(e.getMessage());
            } catch (ExecutionException e2) {
                ARAsyncTask.this.postError(e2.getMessage());
                throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
            } catch (CancellationException unused) {
                ARAsyncTask.this.postResultIfNotInvoked(null);
            }
        }
    };
    private volatile Status mStatus = Status.PENDING;
    /* access modifiers changed from: private */
    public final AtomicBoolean mTaskInvoked = new AtomicBoolean();
    private long mTimeout = 30000;
    private boolean mTimerEnable = false;
    private final C0783c<PARAMS, RESULT> mWorker = new C0783c<PARAMS, RESULT>() {
        public RESULT call() {
            ARAsyncTask.this.mTaskInvoked.set(true);
            if (!ARAsyncTask.this.mCatchError) {
                return ARAsyncTask.this.postResult(ARAsyncTask.this.doInBackground(this.f1770b));
            }
            try {
                return ARAsyncTask.this.postResult(ARAsyncTask.this.doInBackground(this.f1770b));
            } catch (Exception e) {
                ARLog.m2696e(e.getMessage());
                ARAsyncTask.this.postError(e.getMessage());
                return null;
            }
        }
    };

    /* renamed from: com.baidu.ar.load.ARAsyncTask$Status */
    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* renamed from: com.baidu.ar.load.ARAsyncTask$a */
    private static class C0781a<DATA> {

        /* renamed from: a */
        final ARAsyncTask f1768a;

        /* renamed from: b */
        final DATA[] f1769b;

        C0781a(ARAsyncTask aRAsyncTask, DATA... dataArr) {
            this.f1768a = aRAsyncTask;
            this.f1769b = dataArr;
        }
    }

    /* renamed from: com.baidu.ar.load.ARAsyncTask$b */
    private static class C0782b extends Handler {
        public C0782b() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            C0781a aVar = (C0781a) message.obj;
            switch (message.what) {
                case 1:
                    aVar.f1768a.finish(aVar.f1769b[0]);
                    return;
                case 2:
                    aVar.f1768a.onProgressUpdate(aVar.f1769b);
                    return;
                case 3:
                    aVar.f1768a.onTimeout();
                    return;
                case 4:
                    aVar.f1768a.onError(Arrays.toString(aVar.f1769b));
                    return;
                case 5:
                    aVar.f1768a.executeDelay(((Integer) aVar.f1769b[0]).intValue());
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.baidu.ar.load.ARAsyncTask$c */
    private static abstract class C0783c<PARAMS, RESULT> implements Callable<RESULT> {

        /* renamed from: b */
        PARAMS[] f1770b;

        private C0783c() {
        }
    }

    public static void execute(Runnable runnable) {
        sDefaultExecutor.execute(runnable);
    }

    /* access modifiers changed from: private */
    public void executeDelay(int i) {
        if (i == 0) {
            execute((PARAMS[]) new Object[0]);
        } else {
            executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public void finish(RESULT result) {
        if (this.mCatchError) {
            try {
                if (this.mTimerEnable) {
                    removeTimer();
                }
                if (isCancelled()) {
                    onCancelled();
                } else {
                    onPostExecute(result);
                }
            } catch (Exception e) {
                ARLog.m2696e(e.getMessage());
                postError(e.getMessage());
            }
        } else {
            if (this.mTimerEnable) {
                removeTimer();
            }
            if (isCancelled()) {
                onCancelled();
            } else {
                onPostExecute(result);
            }
        }
        this.mStatus = Status.FINISHED;
    }

    /* access modifiers changed from: private */
    public void postError(String str) {
        sHandler.obtainMessage(4, new C0781a(this, str)).sendToTarget();
    }

    /* access modifiers changed from: private */
    public RESULT postResult(RESULT result) {
        sHandler.obtainMessage(1, new C0781a(this, result)).sendToTarget();
        return result;
    }

    /* access modifiers changed from: private */
    public void postResultIfNotInvoked(RESULT result) {
        if (!this.mTaskInvoked.get()) {
            postResult(result);
        }
    }

    private void postTimer() {
        sHandler.sendMessageDelayed(sHandler.obtainMessage(3, new C0781a(this, (DATA[]) null)), this.mTimeout);
    }

    private void removeDelay() {
        sHandler.removeMessages(5);
    }

    private void removeTimer() {
        sHandler.removeMessages(3);
    }

    protected static void setDefaultExecutor(Executor executor) {
        sDefaultExecutor = executor;
    }

    public final boolean cancel(boolean z) {
        if (this.mTimerEnable) {
            removeTimer();
        }
        if (this.mDelayEnable) {
            removeDelay();
        }
        this.mCancelled.set(true);
        return this.mFuture.cancel(z);
    }

    /* access modifiers changed from: protected */
    public abstract RESULT doInBackground(PARAMS... paramsArr);

    public void enableTimer() {
        this.mTimerEnable = true;
    }

    public final ARAsyncTask<PARAMS, PROGRESS, RESULT> execute(PARAMS... paramsArr) {
        return executeOnExecutor(sDefaultExecutor, paramsArr);
    }

    public final ARAsyncTask<PARAMS, PROGRESS, RESULT> executeOnExecutor(Executor executor, PARAMS... paramsArr) {
        if (this.mStatus != Status.PENDING) {
            switch (this.mStatus) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.mStatus = Status.RUNNING;
        if (this.mCatchError) {
            try {
                onPreExecute();
            } catch (Exception e) {
                ARLog.m2696e(e.getMessage());
                postError(e.getMessage());
                return null;
            }
        } else {
            onPreExecute();
        }
        this.mWorker.f1770b = paramsArr;
        if (this.mTimerEnable) {
            postTimer();
        }
        executor.execute(this.mFuture);
        return this;
    }

    public final RESULT get() {
        return this.mFuture.get();
    }

    public final RESULT get(long j, TimeUnit timeUnit) {
        return this.mFuture.get(j, timeUnit);
    }

    /* access modifiers changed from: protected */
    public final FutureTask<RESULT> getFutureTask() {
        return this.mFuture;
    }

    /* access modifiers changed from: protected */
    public Handler getHandler() {
        return sHandler;
    }

    public final Status getStatus() {
        return this.mStatus;
    }

    public final boolean isCancelled() {
        return this.mCancelled.get();
    }

    public final boolean isFinished() {
        return this.mStatus == Status.FINISHED;
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
    }

    /* access modifiers changed from: protected */
    public void onCancelled(RESULT result) {
        onCancelled();
    }

    /* access modifiers changed from: protected */
    public void onError(String str) {
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(RESULT result) {
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
    }

    /* access modifiers changed from: protected */
    public void onProgressUpdate(PROGRESS... progressArr) {
    }

    /* access modifiers changed from: protected */
    public void onTimeout() {
    }

    /* access modifiers changed from: protected */
    public void postDelay(long j, int i) {
        sHandler.sendMessageDelayed(sHandler.obtainMessage(5, new C0781a(this, Integer.valueOf(i))), j);
        this.mDelayEnable = true;
    }

    /* access modifiers changed from: protected */
    public final void publishProgress(PROGRESS... progressArr) {
        if (!isCancelled()) {
            sHandler.obtainMessage(2, new C0781a(this, progressArr)).sendToTarget();
        }
    }

    public void setTimeOut(long j) {
        this.mTimeout = j;
    }
}
