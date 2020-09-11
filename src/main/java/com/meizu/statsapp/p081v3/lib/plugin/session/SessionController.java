package com.meizu.statsapp.p081v3.lib.plugin.session;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.meizu.statsapp.p081v3.lib.plugin.sdk.SDKInstanceImpl;
import com.meizu.statsapp.p081v3.utils.log.Logger;
import java.util.UUID;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.session.SessionController */
public class SessionController {
    private static final int MSG_SESSION_END = 1;
    /* access modifiers changed from: private */
    public static String TAG = "SessionController";
    private static final String WORK_THREAD_NAME = "com.meizu.statsapp.v3.SessionControllerWorker";
    private ActivityLifecycleCallback mActivityLifecycleCallback;
    private Context mContext;
    private Handler mHandler;
    protected SDKInstanceImpl sdkInstanceImpl;
    /* access modifiers changed from: private */
    public String sessionId;
    private final int sessionTimeoutMillis = 30000;
    /* access modifiers changed from: private */
    public String source;

    public SessionController(Context context) {
        this.mContext = context;
        HandlerThread handlerThread = new HandlerThread(WORK_THREAD_NAME, 5);
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper()) {
            public void handleMessage(Message message) {
                Logger.m17378d(SessionController.TAG, "session timeout");
                SessionController.this.endSessionId();
                Logger.m17378d(SessionController.TAG, "flush events when session end");
                if (SessionController.this.sdkInstanceImpl != null) {
                    SessionController.this.sdkInstanceImpl.getTracker().getEmitter().flush();
                }
            }
        };
        registerApplicationLifeCycle();
        Logger.m17378d(TAG, "SessionController init");
    }

    public void attach(SDKInstanceImpl sDKInstanceImpl) {
        this.sdkInstanceImpl = sDKInstanceImpl;
    }

    public String getOrGenerateSessionId() {
        if (this.sessionId == null) {
            synchronized (this) {
                this.sessionId = UUID.randomUUID().toString();
                String str = TAG;
                Logger.m17378d(str, "generate a sessionId: " + this.sessionId);
            }
        }
        return this.sessionId;
    }

    /* access modifiers changed from: private */
    public void endSessionId() {
        if (this.sessionId != null) {
            synchronized (this) {
                String str = TAG;
                Logger.m17378d(str, "end a session id: " + this.sessionId);
                this.sessionId = null;
                this.source = null;
            }
        }
    }

    public void onForeground() {
        Logger.m17378d(TAG, "onForeground");
        this.mHandler.removeCallbacksAndMessages((Object) null);
    }

    public void onBackground() {
        Logger.m17378d(TAG, "onBackground");
        this.mHandler.removeCallbacksAndMessages((Object) null);
        this.mHandler.sendEmptyMessageDelayed(1, 30000);
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(final String str) {
        if (TextUtils.isEmpty(this.source)) {
            this.mHandler.post(new Runnable() {
                public void run() {
                    if (TextUtils.isEmpty(SessionController.this.source)) {
                        String unused = SessionController.this.source = str;
                        String access$000 = SessionController.TAG;
                        Logger.m17378d(access$000, "set source: " + SessionController.this.source);
                        if (SessionController.this.sessionId != null && SessionController.this.sdkInstanceImpl != null) {
                            SessionController.this.sdkInstanceImpl.getTracker().updateSessionSource(SessionController.this.sessionId, str);
                        }
                    }
                }
            });
            return;
        }
        String str2 = TAG;
        Logger.m17378d(str2, "source already exist: " + this.source + ", session: " + this.sessionId + ", not set again");
    }

    private void registerApplicationLifeCycle() {
        if (this.mContext != null) {
            Application application = (Application) this.mContext.getApplicationContext();
            if (this.mActivityLifecycleCallback != null) {
                application.unregisterActivityLifecycleCallbacks(this.mActivityLifecycleCallback);
                this.mActivityLifecycleCallback = null;
            }
            this.mActivityLifecycleCallback = new ActivityLifecycleCallback(this);
            application.registerActivityLifecycleCallbacks(this.mActivityLifecycleCallback);
            Logger.m17378d(TAG, "registerApplicationLifeCycle");
        }
    }

    public void onAppWidgetResume() {
        if (this.mActivityLifecycleCallback != null) {
            this.mActivityLifecycleCallback.onAppWidgetResumed();
        }
    }

    public void onAppWidgetPaused() {
        if (this.mActivityLifecycleCallback != null) {
            this.mActivityLifecycleCallback.onAppWidgetPaused();
        }
    }
}
