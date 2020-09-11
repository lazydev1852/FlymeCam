package com.mediatek.mmsdk;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.android.internal.util.Preconditions;
import com.mediatek.mmsdk.CameraEffectImpl;
import com.mediatek.mmsdk.CameraEffectSession;
import com.meizu.savior.Constants;

public class CameraEffectSessionImpl extends CameraEffectSession {
    private static final String TAG = "CameraEffectSessionImpl";
    private static final boolean VERBOSE = true;
    /* access modifiers changed from: private */
    public volatile boolean mAborting;
    private CameraEffectImpl mCameraMmEffectImpl;
    private boolean mClosed = false;
    private final Runnable mConfiguredFailRunnable = new Runnable() {
        public void run() {
            Log.e(CameraEffectSessionImpl.TAG, "[mConfiguredFailRunnable]Failed to create capture session: configuration failed");
            CameraEffectSessionImpl.this.mStateCallback.onConfigureFailed(CameraEffectSessionImpl.this);
        }
    };
    private final Runnable mConfiguredRunnable = new Runnable() {
        public void run() {
            Log.v(CameraEffectSessionImpl.TAG, "[mConfiguredRunnable] Created session successfully");
            CameraEffectSessionImpl.this.mStateCallback.onConfigured(CameraEffectSessionImpl.this);
        }
    };
    private final Handler mDeviceHandler;
    /* access modifiers changed from: private */
    public final CameraEffectSession.SessionStateCallback mStateCallback;
    private final Handler mStateHandler;

    public CameraEffectSessionImpl(CameraEffectSession.SessionStateCallback sessionStateCallback, Handler handler, CameraEffectImpl cameraEffectImpl, Handler handler2, boolean z) {
        Log.i(TAG, "[CameraEffectHalSessionImpl]++++ configureSuccess = " + z);
        if (sessionStateCallback != null) {
            this.mStateCallback = sessionStateCallback;
            this.mStateHandler = checkHandler(handler);
            this.mDeviceHandler = (Handler) Preconditions.checkNotNull(handler2, "deviceStateHandler must not be null");
            this.mCameraMmEffectImpl = (CameraEffectImpl) Preconditions.checkNotNull(cameraEffectImpl, "deviceImpl must not be null");
            if (z) {
                this.mStateHandler.post(this.mConfiguredRunnable);
            } else {
                this.mStateHandler.post(this.mConfiguredFailRunnable);
            }
        } else {
            throw new IllegalArgumentException("callback must not be null");
        }
    }

    public void startCapture(CameraEffectSession.CaptureCallback captureCallback, Handler handler) {
        Log.v(TAG, Constants.ARRAY_TYPE + Thread.currentThread().getStackTrace()[2].getMethodName() + "]++++ callback " + captureCallback + " handler " + handler);
        checkNotClosed();
        this.mCameraMmEffectImpl.startEffectHal(this.mDeviceHandler, createCaptureCallback(checkHandler(handler, captureCallback), captureCallback));
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.ARRAY_TYPE);
        sb.append(Thread.currentThread().getStackTrace()[2].getMethodName());
        sb.append("]----");
        Log.v(TAG, sb.toString());
    }

    public void setFrameParameters(boolean z, int i, BaseParameters baseParameters, long j, boolean z2) {
        if (baseParameters != null) {
            this.mCameraMmEffectImpl.setFrameParameters(z, i, baseParameters, j, z2);
            return;
        }
        throw new IllegalArgumentException("[addInputFrameParameter] parameters is null");
    }

    public int setFrameSyncMode(boolean z, int i, boolean z2) {
        int frameSyncMode = this.mCameraMmEffectImpl.setFrameSyncMode(z, i, z2);
        Log.i(TAG, "[setInputsyncMode] status_t = " + frameSyncMode);
        return frameSyncMode;
    }

    public boolean getFrameSyncMode(boolean z, int i) {
        boolean frameSyncMode = this.mCameraMmEffectImpl.getFrameSyncMode(z, i);
        Log.i(TAG, "[getInputsyncMode] value = " + frameSyncMode);
        return frameSyncMode;
    }

    public void stopCapture(BaseParameters baseParameters) {
        Log.v(TAG, "[abort]baseParameters " + baseParameters);
        this.mCameraMmEffectImpl.abortCapture(baseParameters);
    }

    public void closeSession() {
        this.mCameraMmEffectImpl.abortCapture((BaseParameters) null);
    }

    public void close() {
        if (this.mClosed) {
            Log.i(TAG, "[close],current session is closed,so return");
            return;
        }
        Log.i(TAG, "[close] on going");
        this.mClosed = VERBOSE;
    }

    /* access modifiers changed from: package-private */
    public void replaceSessionClose() {
        Log.i(TAG, "[replaceSessionClose]");
        close();
    }

    private void checkNotClosed() {
        if (this.mClosed) {
            throw new IllegalStateException("Session has been closed; further changes are illegal.");
        }
    }

    private static <T> Handler checkHandler(Handler handler, T t) {
        return t != null ? checkHandler(handler) : handler;
    }

    private static Handler checkHandler(Handler handler) {
        if (handler != null) {
            return handler;
        }
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            return new Handler(myLooper);
        }
        throw new IllegalArgumentException("No handler given, and current thread has no looper!");
    }

    /* access modifiers changed from: package-private */
    public CameraEffectImpl.DeviceStateCallback getDeviceStateCallback() {
        return new CameraEffectImpl.DeviceStateCallback() {
            private boolean mActive = false;
            private boolean mBusy = false;

            public void onDisconnected(CameraEffect cameraEffect) {
                Log.v(CameraEffectSessionImpl.TAG, Constants.ARRAY_TYPE + Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
                CameraEffectSessionImpl.this.close();
            }

            public void onUnconfigured(CameraEffect cameraEffect) {
                Log.v(CameraEffectSessionImpl.TAG, Constants.ARRAY_TYPE + Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
            }

            public void onActive(CameraEffect cameraEffect) {
                this.mActive = CameraEffectSessionImpl.VERBOSE;
                Log.v(CameraEffectSessionImpl.TAG, Constants.ARRAY_TYPE + Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
            }

            public void onBusy(CameraEffect cameraEffect) {
                this.mBusy = CameraEffectSessionImpl.VERBOSE;
                Log.v(CameraEffectSessionImpl.TAG, Constants.ARRAY_TYPE + Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
            }

            public void onIdle(CameraEffect cameraEffect) {
                boolean access$000;
                Log.v(CameraEffectSessionImpl.TAG, Constants.ARRAY_TYPE + Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
                synchronized (this) {
                    access$000 = CameraEffectSessionImpl.this.mAborting;
                }
                if (this.mBusy && access$000) {
                    boolean unused = CameraEffectSessionImpl.this.mAborting = false;
                }
                this.mBusy = false;
                this.mActive = false;
            }

            public void onError(CameraEffect cameraEffect, int i) {
                Log.wtf(CameraEffectSessionImpl.TAG, "Got device error " + i);
            }
        };
    }

    private CameraEffectImpl.CaptureCallback createCaptureCallback(Handler handler, final CameraEffectSession.CaptureCallback captureCallback) {
        return new CameraEffectImpl.CaptureCallback() {
            public void onInputFrameProcessed(CameraEffectSession cameraEffectSession, BaseParameters baseParameters, BaseParameters baseParameters2) {
                Log.i(CameraEffectSessionImpl.TAG, Constants.ARRAY_TYPE + Thread.currentThread().getStackTrace()[2].getMethodName() + "],callback = " + captureCallback);
                captureCallback.onInputFrameProcessed(cameraEffectSession, baseParameters, baseParameters2);
            }

            public void onOutputFrameProcessed(CameraEffectSession cameraEffectSession, BaseParameters baseParameters, BaseParameters baseParameters2) {
                Log.i(CameraEffectSessionImpl.TAG, Constants.ARRAY_TYPE + Thread.currentThread().getStackTrace()[2].getMethodName() + "],callback = " + captureCallback);
                captureCallback.onOutputFrameProcessed(cameraEffectSession, baseParameters, baseParameters2);
            }

            public void onCaptureSequenceCompleted(CameraEffectSession cameraEffectSession, BaseParameters baseParameters, long j) {
                Log.i(CameraEffectSessionImpl.TAG, Constants.ARRAY_TYPE + Thread.currentThread().getStackTrace()[2].getMethodName() + "],callback = " + captureCallback);
                captureCallback.onCaptureSequenceCompleted(cameraEffectSession, baseParameters, j);
            }

            public void onCaptureSequenceAborted(CameraEffectSession cameraEffectSession, BaseParameters baseParameters) {
                Log.i(CameraEffectSessionImpl.TAG, Constants.ARRAY_TYPE + Thread.currentThread().getStackTrace()[2].getMethodName() + "],callback = " + captureCallback);
                captureCallback.onCaptureSequenceAborted(cameraEffectSession, baseParameters);
            }

            public void onCaptureFailed(CameraEffectSession cameraEffectSession, BaseParameters baseParameters) {
                Log.i(CameraEffectSessionImpl.TAG, Constants.ARRAY_TYPE + Thread.currentThread().getStackTrace()[2].getMethodName() + "],callback = " + captureCallback);
                captureCallback.onCaptureFailed(cameraEffectSession, baseParameters);
            }
        };
    }
}
