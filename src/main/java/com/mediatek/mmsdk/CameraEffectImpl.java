package com.mediatek.mmsdk;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import android.view.Surface;
import com.mediatek.mmsdk.CameraEffect;
import com.mediatek.mmsdk.CameraEffectSession;
import com.mediatek.mmsdk.CameraEffectStatus;
import com.mediatek.mmsdk.IEffectListener;
import com.meizu.savior.Constants;
import java.util.ArrayList;
import java.util.List;

public class CameraEffectImpl extends CameraEffect {
    private static final boolean DEBUG = true;
    private static final int SUCCESS_VALUE = 0;
    private static final String TAG = "CameraEffectImpl";
    private BaseParameters mBaseParameters;
    private final Runnable mCallOnActive = new Runnable() {
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
            r1.onActive(r2.this$0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
            if (r1 == null) goto L_?;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r2 = this;
                com.mediatek.mmsdk.CameraEffectImpl r0 = com.mediatek.mmsdk.CameraEffectImpl.this
                java.lang.Object r0 = r0.mInterfaceLock
                monitor-enter(r0)
                com.mediatek.mmsdk.CameraEffectImpl r1 = com.mediatek.mmsdk.CameraEffectImpl.this     // Catch:{ all -> 0x0020 }
                com.mediatek.mmsdk.IEffectHalClient r1 = r1.mIEffectHalClient     // Catch:{ all -> 0x0020 }
                if (r1 != 0) goto L_0x0011
                monitor-exit(r0)     // Catch:{ all -> 0x0020 }
                return
            L_0x0011:
                com.mediatek.mmsdk.CameraEffectImpl r1 = com.mediatek.mmsdk.CameraEffectImpl.this     // Catch:{ all -> 0x0020 }
                com.mediatek.mmsdk.CameraEffectImpl$DeviceStateCallback r1 = r1.mSessionStateCallback     // Catch:{ all -> 0x0020 }
                monitor-exit(r0)     // Catch:{ all -> 0x0020 }
                if (r1 == 0) goto L_0x001f
                com.mediatek.mmsdk.CameraEffectImpl r0 = com.mediatek.mmsdk.CameraEffectImpl.this
                r1.onActive(r0)
            L_0x001f:
                return
            L_0x0020:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0020 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mediatek.mmsdk.CameraEffectImpl.C11352.run():void");
        }
    };
    private final Runnable mCallOnBusy = new Runnable() {
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
            r1.onBusy(r2.this$0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
            if (r1 == null) goto L_?;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r2 = this;
                com.mediatek.mmsdk.CameraEffectImpl r0 = com.mediatek.mmsdk.CameraEffectImpl.this
                java.lang.Object r0 = r0.mInterfaceLock
                monitor-enter(r0)
                com.mediatek.mmsdk.CameraEffectImpl r1 = com.mediatek.mmsdk.CameraEffectImpl.this     // Catch:{ all -> 0x0020 }
                com.mediatek.mmsdk.IEffectHalClient r1 = r1.mIEffectHalClient     // Catch:{ all -> 0x0020 }
                if (r1 != 0) goto L_0x0011
                monitor-exit(r0)     // Catch:{ all -> 0x0020 }
                return
            L_0x0011:
                com.mediatek.mmsdk.CameraEffectImpl r1 = com.mediatek.mmsdk.CameraEffectImpl.this     // Catch:{ all -> 0x0020 }
                com.mediatek.mmsdk.CameraEffectImpl$DeviceStateCallback r1 = r1.mSessionStateCallback     // Catch:{ all -> 0x0020 }
                monitor-exit(r0)     // Catch:{ all -> 0x0020 }
                if (r1 == 0) goto L_0x001f
                com.mediatek.mmsdk.CameraEffectImpl r0 = com.mediatek.mmsdk.CameraEffectImpl.this
                r1.onBusy(r0)
            L_0x001f:
                return
            L_0x0020:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0020 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mediatek.mmsdk.CameraEffectImpl.C11363.run():void");
        }
    };
    private final Runnable mCallOnClosed = new Runnable() {
        private boolean isClosedOnce = false;

        public void run() {
            DeviceStateCallback access$700;
            if (!this.isClosedOnce) {
                synchronized (CameraEffectImpl.this.mInterfaceLock) {
                    access$700 = CameraEffectImpl.this.mSessionStateCallback;
                }
                if (access$700 != null) {
                    access$700.onClosed(CameraEffectImpl.this);
                }
                CameraEffectImpl.this.mEffectStateCallback.onClosed(CameraEffectImpl.this);
                this.isClosedOnce = CameraEffectImpl.DEBUG;
                return;
            }
            throw new AssertionError("Don't post #onClosed more than once");
        }
    };
    private final Runnable mCallOnIdle = new Runnable() {
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
            r1.onIdle(r2.this$0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
            if (r1 == null) goto L_?;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r2 = this;
                com.mediatek.mmsdk.CameraEffectImpl r0 = com.mediatek.mmsdk.CameraEffectImpl.this
                java.lang.Object r0 = r0.mInterfaceLock
                monitor-enter(r0)
                com.mediatek.mmsdk.CameraEffectImpl r1 = com.mediatek.mmsdk.CameraEffectImpl.this     // Catch:{ all -> 0x0020 }
                com.mediatek.mmsdk.IEffectHalClient r1 = r1.mIEffectHalClient     // Catch:{ all -> 0x0020 }
                if (r1 != 0) goto L_0x0011
                monitor-exit(r0)     // Catch:{ all -> 0x0020 }
                return
            L_0x0011:
                com.mediatek.mmsdk.CameraEffectImpl r1 = com.mediatek.mmsdk.CameraEffectImpl.this     // Catch:{ all -> 0x0020 }
                com.mediatek.mmsdk.CameraEffectImpl$DeviceStateCallback r1 = r1.mSessionStateCallback     // Catch:{ all -> 0x0020 }
                monitor-exit(r0)     // Catch:{ all -> 0x0020 }
                if (r1 == 0) goto L_0x001f
                com.mediatek.mmsdk.CameraEffectImpl r0 = com.mediatek.mmsdk.CameraEffectImpl.this
                r1.onIdle(r0)
            L_0x001f:
                return
            L_0x0020:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0020 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mediatek.mmsdk.CameraEffectImpl.C11385.run():void");
        }
    };
    /* access modifiers changed from: private */
    public SparseArray<CaptureCallbackHolder> mCaptureCallbackHolderMap = new SparseArray<>();
    /* access modifiers changed from: private */
    public CameraEffectSessionImpl mCurrentSession;
    /* access modifiers changed from: private */
    public long mCurrentStartId = -1;
    private Handler mEffectHalHandler;
    /* access modifiers changed from: private */
    public CameraEffectStatus mEffectHalStatus;
    /* access modifiers changed from: private */
    public CameraEffect.StateCallback mEffectStateCallback;
    /* access modifiers changed from: private */
    public IEffectHalClient mIEffectHalClient;
    private boolean mInError = false;
    /* access modifiers changed from: private */
    public final Object mInterfaceLock = new Object();
    /* access modifiers changed from: private */
    public DeviceStateCallback mSessionStateCallback;

    public static abstract class CaptureCallback {
        public void onCaptureFailed(CameraEffectSession cameraEffectSession, BaseParameters baseParameters) {
        }

        public void onCaptureSequenceAborted(CameraEffectSession cameraEffectSession, BaseParameters baseParameters) {
        }

        public void onCaptureSequenceCompleted(CameraEffectSession cameraEffectSession, BaseParameters baseParameters, long j) {
        }

        public void onInputFrameProcessed(CameraEffectSession cameraEffectSession, BaseParameters baseParameters, BaseParameters baseParameters2) {
        }

        public void onOutputFrameProcessed(CameraEffectSession cameraEffectSession, BaseParameters baseParameters, BaseParameters baseParameters2) {
        }
    }

    public static abstract class DeviceStateCallback extends CameraEffect.StateCallback {
        public void onActive(CameraEffect cameraEffect) {
        }

        public void onBusy(CameraEffect cameraEffect) {
        }

        public void onIdle(CameraEffect cameraEffect) {
        }

        public void onUnconfigured(CameraEffect cameraEffect) {
        }
    }

    public CameraEffectImpl(CameraEffect.StateCallback stateCallback, Handler handler) {
        this.mEffectStateCallback = stateCallback;
        this.mEffectHalHandler = handler;
        this.mEffectHalStatus = new CameraEffectStatus();
    }

    public CameraEffectSession createCaptureSession(List<Surface> list, List<BaseParameters> list2, CameraEffectSession.SessionStateCallback sessionStateCallback, Handler handler) throws CameraEffectHalException {
        boolean z;
        Log.i(TAG, Constants.ARRAY_TYPE + Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
        checkIfCameraClosedOrInError();
        if (list != null) {
            Handler checkHandler = checkHandler(handler);
            if (this.mCurrentSession != null) {
                this.mCurrentSession.replaceSessionClose();
            }
            CameraEffectHalException e = null;
            try {
                z = configureOutputs(list, list2);
            } catch (CameraEffectHalException e2) {
                e = e2;
                Log.v(TAG, "createCaptureSession- failed with exception ", e);
                z = false;
            }
            this.mCurrentSession = new CameraEffectSessionImpl(sessionStateCallback, checkHandler, this, this.mEffectHalHandler, z);
            if (e == null) {
                this.mSessionStateCallback = this.mCurrentSession.getDeviceStateCallback();
                this.mEffectHalHandler.post(this.mCallOnIdle);
                return this.mCurrentSession;
            }
            throw e;
        }
        throw new IllegalArgumentException("createEffectSession: the outputSurface must not be null");
    }

    public void setParamters(BaseParameters baseParameters) {
        try {
            this.mIEffectHalClient.setParameters(baseParameters);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException during setParameters [BaseParameters]", e);
        }
    }

    public List<Surface> getInputSurface() {
        Log.d(TAG, "[getInputSurface],current status = " + this.mEffectHalStatus.getEffectHalStatus());
        ArrayList arrayList = new ArrayList();
        try {
            this.mIEffectHalClient.configure();
            this.mIEffectHalClient.prepare();
            this.mIEffectHalClient.getInputSurfaces(arrayList);
            this.mEffectHalStatus.setEffectHalStatus(CameraEffectStatus.CameraEffectHalStatus.STATUS_CONFINGURED);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException during configure or prepare or getInputSurfaces", e);
        }
        return arrayList;
    }

    public List<BaseParameters> getCaputreRequirement(BaseParameters baseParameters) {
        int i;
        ArrayList arrayList = new ArrayList();
        CameraEffectStatus.CameraEffectHalStatus effectHalStatus = this.mEffectHalStatus.getEffectHalStatus();
        Log.i(TAG, "[getCaputreRequirement] currentStatus = " + effectHalStatus);
        try {
            if (CameraEffectStatus.CameraEffectHalStatus.STATUS_CONFINGURED != effectHalStatus) {
                this.mIEffectHalClient.configure();
                this.mEffectHalStatus.setEffectHalStatus(CameraEffectStatus.CameraEffectHalStatus.STATUS_CONFINGURED);
            }
            i = this.mIEffectHalClient.getCaptureRequirement(baseParameters, arrayList);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException during getCaptureRequirement", e);
            i = -1;
        }
        Log.i(TAG, "[getCaputreRequirement] return value from native : " + i + ",parameters = " + arrayList.toString());
        return arrayList;
    }

    public void closeEffect() {
        Log.i(TAG, "[closeEffect] +++,mIEffectHalClient = " + this.mIEffectHalClient);
        abortCapture((BaseParameters) null);
        unConfigureEffectHal();
        unInitEffectHal();
        Log.i(TAG, "[closeEffect] ---");
    }

    public EffectHalClientListener getEffectHalListener() {
        return new EffectHalClientListener();
    }

    public void setRemoteCameraEffect(IEffectHalClient iEffectHalClient) {
        synchronized (this.mInterfaceLock) {
            if (!this.mInError) {
                this.mIEffectHalClient = iEffectHalClient;
                this.mEffectHalStatus.setEffectHalStatus(CameraEffectStatus.CameraEffectHalStatus.STATUS_INITIALIZED);
            }
        }
    }

    public void setRemoteCameraEffectFail(CameraEffectHalRuntimeException cameraEffectHalRuntimeException) {
        final boolean z;
        final int i = 4;
        switch (cameraEffectHalRuntimeException.getReason()) {
            case 101:
                i = 3;
                break;
            case 102:
                z = false;
                break;
            case 103:
                break;
            case 106:
                i = 6;
                break;
            case 107:
                z = DEBUG;
                i = 1;
                break;
            default:
                Log.wtf(TAG, "Unknown failure in opening camera device: " + cameraEffectHalRuntimeException.getReason());
                break;
        }
        z = DEBUG;
        synchronized (this.mInterfaceLock) {
            this.mInError = DEBUG;
            this.mEffectHalStatus.setEffectHalStatus(CameraEffectStatus.CameraEffectHalStatus.STATUS_INITIALIZED);
            this.mEffectHalHandler.post(new Runnable() {
                public void run() {
                    if (z) {
                        CameraEffectImpl.this.mEffectStateCallback.onError(CameraEffectImpl.this, i);
                    } else {
                        CameraEffectImpl.this.mEffectStateCallback.onDisconnected(CameraEffectImpl.this);
                    }
                }
            });
        }
    }

    public boolean configureOutputs(List<Surface> list, List<BaseParameters> list2) throws CameraEffectHalException {
        boolean z;
        Log.i(TAG, Constants.ARRAY_TYPE + Thread.currentThread().getStackTrace()[2].getMethodName() + "]++++,current status = " + this.mEffectHalStatus.getEffectHalStatus());
        if (list == null) {
            list = new ArrayList<>();
        }
        synchronized (this.mInterfaceLock) {
            checkIfCameraClosedOrInError();
            this.mEffectHalHandler.post(this.mCallOnBusy);
            z = false;
            try {
                if (this.mIEffectHalClient.setOutputSurfaces(list, list2) == 0) {
                    z = DEBUG;
                }
            } catch (RemoteException e) {
                Log.e(TAG, "RemoteException during setOutputSurfaces", e);
            }
        }
        Log.i(TAG, "[configureOutputs]----, success = " + z);
        return z;
    }

    public void startEffectHal(Handler handler, CaptureCallback captureCallback) {
        Log.i(TAG, Constants.ARRAY_TYPE + Thread.currentThread().getStackTrace()[2].getMethodName() + "]++++,status = " + this.mEffectHalStatus.getEffectHalStatus());
        Handler checkHandler = checkHandler(handler, captureCallback);
        try {
            if (CameraEffectStatus.CameraEffectHalStatus.STATUS_CONFINGURED != this.mEffectHalStatus.getEffectHalStatus()) {
                this.mIEffectHalClient.configure();
                this.mEffectHalStatus.setEffectHalStatus(CameraEffectStatus.CameraEffectHalStatus.STATUS_CONFINGURED);
            }
            this.mIEffectHalClient.prepare();
            this.mCurrentStartId = this.mIEffectHalClient.start();
            this.mEffectHalStatus.setEffectHalStatus(CameraEffectStatus.CameraEffectHalStatus.STATUS_RUNNING);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException during prepare or start", e);
        }
        this.mCaptureCallbackHolderMap.put((int) this.mCurrentStartId, new CaptureCallbackHolder(captureCallback, checkHandler));
        this.mEffectHalHandler.post(this.mCallOnActive);
        Log.i(TAG, Constants.ARRAY_TYPE + Thread.currentThread().getStackTrace()[2].getMethodName() + "]----, mCurrentStartId = " + this.mCurrentStartId + ",callback = " + captureCallback + ",get the map's callback = " + this.mCaptureCallbackHolderMap.get((int) this.mCurrentStartId));
    }

    public void setFrameParameters(boolean z, int i, BaseParameters baseParameters, long j, boolean z2) {
        if (z) {
            try {
                this.mIEffectHalClient.addInputParameter(i, baseParameters, j, z2);
            } catch (RemoteException e) {
                Log.e(TAG, "RemoteException during addInputParameter or addOutputParameter", e);
            }
        } else {
            this.mIEffectHalClient.addOutputParameter(i, baseParameters, j, z2);
        }
    }

    public void addOutputParameter(int i, BaseParameters baseParameters, long j, boolean z) {
        try {
            this.mIEffectHalClient.addOutputParameter(i, baseParameters, j, z);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException during addOutputParameter", e);
        }
    }

    public void abortCapture(BaseParameters baseParameters) {
        try {
            if (CameraEffectStatus.CameraEffectHalStatus.STATUS_RUNNING == this.mEffectHalStatus.getEffectHalStatus()) {
                this.mIEffectHalClient.abort(this.mBaseParameters);
                this.mEffectHalStatus.setEffectHalStatus(CameraEffectStatus.CameraEffectHalStatus.STATUS_CONFINGURED);
            }
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException during abort", e);
        }
        this.mBaseParameters = baseParameters;
    }

    public class EffectHalClientListener extends IEffectListener.Stub {
        public EffectHalClientListener() {
        }

        public void onPrepared(IEffectHalClient iEffectHalClient, BaseParameters baseParameters) throws RemoteException {
            Log.i(CameraEffectImpl.TAG, "[onPrepared] effect = " + iEffectHalClient + ",result = " + baseParameters.flatten());
        }

        public void onInputFrameProcessed(IEffectHalClient iEffectHalClient, BaseParameters baseParameters, final BaseParameters baseParameters2) throws RemoteException {
            Log.i(CameraEffectImpl.TAG, Constants.ARRAY_TYPE + Thread.currentThread().getStackTrace()[2].getMethodName() + "]++++");
            final CaptureCallbackHolder captureCallbackHolder = CameraEffectImpl.this.mCurrentStartId > 0 ? (CaptureCallbackHolder) CameraEffectImpl.this.mCaptureCallbackHolderMap.valueAt((int) CameraEffectImpl.this.mCurrentStartId) : null;
            if (!(baseParameters == null || baseParameters2 == null)) {
                Log.i(CameraEffectImpl.TAG, "[onInputFrameProcessed] effect = " + iEffectHalClient + ",parameter = " + baseParameters.flatten() + ",partialResult = " + baseParameters2.flatten() + ",callbackHolder = " + captureCallbackHolder);
            }
            if (captureCallbackHolder != null) {
                captureCallbackHolder.getHandler().post(new Runnable(baseParameters2) {
                    final /* synthetic */ BaseParameters val$parameters;

                    {
                        this.val$parameters = r3;
                    }

                    public void run() {
                        captureCallbackHolder.getCaptureCallback().onInputFrameProcessed(CameraEffectImpl.this.mCurrentSession, this.val$parameters, baseParameters2);
                    }
                });
            }
            Log.i(CameraEffectImpl.TAG, Constants.ARRAY_TYPE + Thread.currentThread().getStackTrace()[2].getMethodName() + "]----");
        }

        public void onOutputFrameProcessed(IEffectHalClient iEffectHalClient, BaseParameters baseParameters, final BaseParameters baseParameters2) throws RemoteException {
            Log.i(CameraEffectImpl.TAG, Constants.ARRAY_TYPE + Thread.currentThread().getStackTrace()[2] + "]++++");
            final CaptureCallbackHolder captureCallbackHolder = CameraEffectImpl.this.mCurrentStartId > 0 ? (CaptureCallbackHolder) CameraEffectImpl.this.mCaptureCallbackHolderMap.get((int) CameraEffectImpl.this.mCurrentStartId) : null;
            if (!(baseParameters == null || baseParameters2 == null)) {
                Log.i(CameraEffectImpl.TAG, "[onOutputFrameProcessed]++++, effect = " + iEffectHalClient + ",parameter = " + baseParameters.flatten() + ",partialResult = " + baseParameters2.flatten() + ",mCurrentStartId = " + CameraEffectImpl.this.mCurrentStartId + ",callbackHolder = " + captureCallbackHolder);
            }
            if (captureCallbackHolder != null) {
                captureCallbackHolder.getHandler().post(new Runnable(baseParameters2) {
                    final /* synthetic */ BaseParameters val$parameters;

                    {
                        this.val$parameters = r3;
                    }

                    public void run() {
                        captureCallbackHolder.getCaptureCallback().onOutputFrameProcessed(CameraEffectImpl.this.mCurrentSession, this.val$parameters, baseParameters2);
                    }
                });
            }
            Log.i(CameraEffectImpl.TAG, Constants.ARRAY_TYPE + Thread.currentThread().getStackTrace()[2] + "]----");
        }

        public void onCompleted(IEffectHalClient iEffectHalClient, final BaseParameters baseParameters, long j) throws RemoteException {
            Log.i(CameraEffectImpl.TAG, Constants.ARRAY_TYPE + Thread.currentThread().getStackTrace()[2].getMethodName() + "]++++");
            final int i = (int) j;
            final CaptureCallbackHolder captureCallbackHolder = i > 0 ? (CaptureCallbackHolder) CameraEffectImpl.this.mCaptureCallbackHolderMap.get(i) : null;
            if (baseParameters != null) {
                Log.i(CameraEffectImpl.TAG, "[onCompleted]++++, effect = ,partialResult = " + baseParameters.flatten() + ",uid = " + j + ",compleateId = " + i + ",mCurrentStartId = " + CameraEffectImpl.this.mCurrentStartId + ",callbackHolder = " + captureCallbackHolder);
            }
            if (captureCallbackHolder != null) {
                captureCallbackHolder.getHandler().post(new Runnable() {
                    public void run() {
                        captureCallbackHolder.getCaptureCallback().onCaptureSequenceCompleted(CameraEffectImpl.this.mCurrentSession, baseParameters, (long) i);
                    }
                });
            }
            CameraEffectImpl.this.mIEffectHalClient.abort((BaseParameters) null);
            CameraEffectImpl.this.mEffectHalStatus.setEffectHalStatus(CameraEffectStatus.CameraEffectHalStatus.STATUS_CONFINGURED);
            Log.i(CameraEffectImpl.TAG, Constants.ARRAY_TYPE + Thread.currentThread().getStackTrace()[2].getMethodName() + "]----");
        }

        public void onAborted(IEffectHalClient iEffectHalClient, final BaseParameters baseParameters) throws RemoteException {
            Log.i(CameraEffectImpl.TAG, Constants.ARRAY_TYPE + Thread.currentThread().getStackTrace()[2] + "]++++");
            final CaptureCallbackHolder captureCallbackHolder = CameraEffectImpl.this.mCurrentStartId > 0 ? (CaptureCallbackHolder) CameraEffectImpl.this.mCaptureCallbackHolderMap.get((int) CameraEffectImpl.this.mCurrentStartId) : null;
            if (baseParameters != null) {
                Log.i(CameraEffectImpl.TAG, Constants.ARRAY_TYPE + Thread.currentThread().getStackTrace()[2].getMethodName() + "] ++++,effect = " + iEffectHalClient + ",result = " + baseParameters.flatten());
            }
            if (captureCallbackHolder != null) {
                captureCallbackHolder.getHandler().post(new Runnable() {
                    public void run() {
                        captureCallbackHolder.getCaptureCallback().onCaptureSequenceAborted(CameraEffectImpl.this.mCurrentSession, baseParameters);
                    }
                });
            }
            CameraEffectImpl.this.mCaptureCallbackHolderMap.removeAt((int) CameraEffectImpl.this.mCurrentStartId);
            Log.i(CameraEffectImpl.TAG, Constants.ARRAY_TYPE + Thread.currentThread().getStackTrace()[2].getMethodName() + "] ----");
        }

        public void onFailed(IEffectHalClient iEffectHalClient, final BaseParameters baseParameters) throws RemoteException {
            Log.i(CameraEffectImpl.TAG, Constants.ARRAY_TYPE + Thread.currentThread().getStackTrace()[2] + "]++++");
            final CaptureCallbackHolder captureCallbackHolder = CameraEffectImpl.this.mCurrentStartId > 0 ? (CaptureCallbackHolder) CameraEffectImpl.this.mCaptureCallbackHolderMap.get((int) CameraEffectImpl.this.mCurrentStartId) : null;
            if (baseParameters != null) {
                Log.i(CameraEffectImpl.TAG, Constants.ARRAY_TYPE + Thread.currentThread().getStackTrace()[2].getMethodName() + "] ++++,effect = " + iEffectHalClient + ",result = " + baseParameters.flatten());
            }
            if (captureCallbackHolder != null) {
                captureCallbackHolder.getHandler().post(new Runnable() {
                    public void run() {
                        captureCallbackHolder.getCaptureCallback().onCaptureFailed(CameraEffectImpl.this.mCurrentSession, baseParameters);
                    }
                });
            }
            CameraEffectImpl.this.mCaptureCallbackHolderMap.removeAt((int) CameraEffectImpl.this.mCurrentStartId);
            Log.i(CameraEffectImpl.TAG, Constants.ARRAY_TYPE + Thread.currentThread().getStackTrace()[2].getMethodName() + "] ----");
        }
    }

    public void close() {
        Log.i(TAG, "[close]");
        if (this.mIEffectHalClient != null || this.mInError) {
            this.mEffectHalHandler.post(this.mCallOnClosed);
        }
        this.mIEffectHalClient = null;
        this.mInError = false;
    }

    public int setFrameSyncMode(boolean z, int i, boolean z2) {
        int i2;
        if (z) {
            try {
                i2 = this.mIEffectHalClient.setInputsyncMode(i, z2);
            } catch (RemoteException e) {
                e.printStackTrace();
                i2 = -1;
            }
        } else {
            i2 = this.mIEffectHalClient.setOutputsyncMode(i, z2);
        }
        Log.i(TAG, "[setFrameSyncMode] status_t = " + i2 + ",isInput = " + z);
        return i2;
    }

    public int setOutputsyncMode(int i, boolean z) {
        int i2;
        try {
            i2 = this.mIEffectHalClient.setOutputsyncMode(i, z);
        } catch (RemoteException e) {
            e.printStackTrace();
            i2 = -1;
        }
        Log.i(TAG, "[setOutputsyncMode] status_t = " + i2);
        return i2;
    }

    public boolean getFrameSyncMode(boolean z, int i) {
        boolean z2;
        try {
            z2 = this.mIEffectHalClient.getInputsyncMode(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            z2 = false;
        }
        Log.i(TAG, "[getInputsyncMode] value = " + z2);
        return z2;
    }

    public boolean getOutputsyncMode(int i) {
        boolean z;
        try {
            z = this.mIEffectHalClient.getOutputsyncMode(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            z = false;
        }
        Log.i(TAG, "[getOutputsyncMode] value = " + z);
        return z;
    }

    private void checkIfCameraClosedOrInError() throws CameraEffectHalException {
        if (this.mInError) {
            throw new CameraEffectHalRuntimeException(103, "The camera device has encountered a serious error");
        } else if (this.mIEffectHalClient == null) {
            throw new IllegalStateException("effect hal client have closed");
        }
    }

    private void unConfigureEffectHal() {
        Log.i(TAG, "[unConfigureEffectHal]");
        if (CameraEffectStatus.CameraEffectHalStatus.STATUS_CONFINGURED == this.mEffectHalStatus.getEffectHalStatus()) {
            try {
                this.mIEffectHalClient.unconfigure();
                this.mEffectHalStatus.setEffectHalStatus(CameraEffectStatus.CameraEffectHalStatus.STATUS_INITIALIZED);
            } catch (RemoteException e) {
                Log.e(TAG, "RemoteException during unconfigure", e);
            }
        }
    }

    private void unInitEffectHal() {
        Log.i(TAG, "[unInitEffectHal]");
        if (CameraEffectStatus.CameraEffectHalStatus.STATUS_INITIALIZED == this.mEffectHalStatus.getEffectHalStatus()) {
            try {
                this.mIEffectHalClient.uninit();
                this.mEffectHalStatus.setEffectHalStatus(CameraEffectStatus.CameraEffectHalStatus.STATUS_UNINITIALIZED);
            } catch (RemoteException e) {
                Log.e(TAG, "RemoteException during uninit", e);
            }
        }
    }

    private class CaptureCallbackHolder {
        private final CaptureCallback mCaptureCallback;
        private final Handler mHandler;

        CaptureCallbackHolder(CaptureCallback captureCallback, Handler handler) {
            this.mCaptureCallback = captureCallback;
            this.mHandler = handler;
        }

        public CaptureCallback getCaptureCallback() {
            return this.mCaptureCallback;
        }

        public Handler getHandler() {
            return this.mHandler;
        }
    }

    private Handler checkHandler(Handler handler) {
        if (handler != null) {
            return handler;
        }
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            return new Handler(myLooper);
        }
        throw new IllegalArgumentException("No handler given, and current thread has no looper!");
    }

    private <T> Handler checkHandler(Handler handler, T t) {
        return t != null ? checkHandler(handler) : handler;
    }
}
