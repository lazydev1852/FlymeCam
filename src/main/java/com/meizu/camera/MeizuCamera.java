package com.meizu.camera;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;

public class MeizuCamera {
    public static final int CONTINUOUS_ENCODING_NOTIFY = 1;
    public static final int CONTINUOUS_END_NOTIFY = 16;
    public static final int CONTINUOUS_WRITE_FAILED_NOTIFY = 4;
    public static final int CONTINUOUS_WRITE_FILE_NOTIFY = 2;
    public static final int CONTINUOUS_WRITE_LAST_NOTIFY = 8;
    public static final int LIGHT_FIELD_ENCODING_NOTIFY = 1;
    public static final int LIGHT_FIELD_END_NOTIFY = 16;
    public static final int LIGHT_FIELD_WRITE_FAILED_NOTIFY = 4;
    public static final int LIGHT_FIELD_WRITE_FILE_NOTIFY = 2;
    public static final int LIGHT_FIELD_WRITE_LAST_NOTIFY = 8;
    public static final int LOWLIGHT_CAPTURE_OFF = 1;
    public static final int LOWLIGHT_CAPTURE_ON = 0;
    private static final int MEIZU_CAMERA_ERROR_DISCONNECT = 102;
    private static final int MEIZU_CAMERA_ERROR_SERVER_DIED = 100;
    private static final int MEIZU_CAMERA_ERROR_UNKNOWN = 101;
    private static final int MEIZU_CAMERA_MSG_CONTINUOUS_SHOT = 2;
    private static final int MEIZU_CAMERA_MSG_ERROR = 1;
    private static final int MEIZU_CAMERA_MSG_FLASH_LIGHT = 8;
    private static final int MEIZU_CAMERA_MSG_META_DATA = 256;
    private static final int MEIZU_CAMERA_MSG_MODULE_COVERED_DETECTION = 64;
    private static final int MEIZU_CAMERA_MSG_REFOCUS_SHOT = 16;
    private static final int MEIZU_CAMERA_MSG_SCENEMODE_DETECTION = 32;
    private static final int MEIZU_CAMERA_MSG_SECURE_DETECTION = 4;
    public static final int METADATA_LOWLIGHT_CAPTURE = 401;
    public static final int SCENEMODE_NIGHT_NOTIFY = 302;
    public static final int SCENEMODE_NORMAL_NOTIFY = 301;
    private static final String TAG = "MeizuCamera";
    public static final int TEMPERATURE_CLOSE_CAMERA_NOTIFY = 205;
    public static final int TEMPERATURE_CLOSE_FLASH_NOTIFY = 203;
    public static final int TEMPERATURE_CLOSE_RECORD_NOTIFY = 204;
    public static final int TEMPERATURE_FLASH_DANGER_NOTIFY = 202;
    public static final int TEMPERATURE_NORMAL_NOTIFY = 201;
    /* access modifiers changed from: private */
    public MeizuCameraContinuousCallback mContinuousCallback;
    private C1154a mEventHandler;
    /* access modifiers changed from: private */
    public FlashLightListener mFlashLightListener = null;
    /* access modifiers changed from: private */
    public MeizuCameraErrorCallback mMeizuCameraErrorCb = null;
    /* access modifiers changed from: private */
    public MeizuMetaDataCallback mMeizuMetaDataCallback;
    /* access modifiers changed from: private */
    public MeizuModuleCoveredDetectionCallback mModuleCoveredDetectionCallback;
    private long mNativeContext;
    /* access modifiers changed from: private */
    public MeizuCameraRefocusCallback mRefocusCallback;
    /* access modifiers changed from: private */
    public MeizuSceneModeDetectionCallback mSceneModeDetectionCallback;
    /* access modifiers changed from: private */
    public MeizuSecureDetectionCallback mSecureDetectionCallback;

    public interface FlashLightListener {
        void onFlashLight(boolean z);
    }

    public interface MeizuCameraContinuousCallback {
        void onContinuousNotify(int i, int i2);
    }

    public interface MeizuCameraErrorCallback {
        void onError(int i);
    }

    public interface MeizuCameraRefocusCallback {
        void onRefocusNotify(int i, int i2, MeizuCamera meizuCamera);
    }

    public interface MeizuMetaDataCallback {
        void onMeizuMetaDataNotify(int i, int i2);
    }

    public interface MeizuModuleCoveredDetectionCallback {
        void onModuleCoveredDetection(int i);
    }

    public interface MeizuSceneModeDetectionCallback {
        void onSceneModeDetection(int i);
    }

    public interface MeizuSecureDetectionCallback {
        void onSecureDetection(int i, int i2);
    }

    private final native void native_release();

    private final native void native_setMeizutMetadataCb(boolean z);

    private final native void native_setup(Object obj, int i);

    public native void cancelContinuousShot();

    public final native int closeFlashLight(int i);

    public final native int getFlashLightNum();

    public final native int getFocusDistance();

    public final native int getMaxFlashLightLevel(int i);

    public final native int ifSupportFlashlight();

    public final native int openFlashLight(int i);

    public final native int reset();

    public final native int setFileDescriptor(FileDescriptor[] fileDescriptorArr);

    public final native int setFlashLightLevel(int i, int i2);

    public final native int setSpecialFlashLightMode(int i);

    public final native void shutterButtonDown();

    public final int openTorch() {
        return openFlashLight(0);
    }

    public final int setFlashlightMode(int i) {
        return setSpecialFlashLightMode(i);
    }

    public final int ifSupportFlashLight() {
        return ifSupportFlashlight();
    }

    public final int closeTorch() {
        return closeFlashLight(0);
    }

    MeizuCamera(int i) {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.mEventHandler = new C1154a(this, myLooper);
        } else {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null) {
                this.mEventHandler = new C1154a(this, mainLooper);
            } else {
                this.mEventHandler = null;
            }
        }
        native_setup(new WeakReference(this), i);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        release();
    }

    public final void release() {
        native_release();
    }

    public static MeizuCamera open(int i) {
        return new MeizuCamera(i);
    }

    public static MeizuCamera open(int i, int i2) {
        return new MeizuCamera(i);
    }

    public final void setFlashLightListener(FlashLightListener flashLightListener) {
        this.mFlashLightListener = flashLightListener;
    }

    public final void setMeizuCameraErrorCallback(MeizuCameraErrorCallback meizuCameraErrorCallback) {
        this.mMeizuCameraErrorCb = meizuCameraErrorCallback;
    }

    public final void setMeizuCameraRefocusCallBack(MeizuCameraRefocusCallback meizuCameraRefocusCallback) {
        this.mRefocusCallback = meizuCameraRefocusCallback;
    }

    public final void setMeizuCameraContinuousCallback(MeizuCameraContinuousCallback meizuCameraContinuousCallback) {
        this.mContinuousCallback = meizuCameraContinuousCallback;
    }

    public final void setSecureDetectionCallback(MeizuSecureDetectionCallback meizuSecureDetectionCallback) {
        this.mSecureDetectionCallback = meizuSecureDetectionCallback;
    }

    public final void setSceneModeDetectionCallback(MeizuSceneModeDetectionCallback meizuSceneModeDetectionCallback) {
        this.mSceneModeDetectionCallback = meizuSceneModeDetectionCallback;
    }

    public final void setModuleCoveredDetectionCallback(MeizuModuleCoveredDetectionCallback meizuModuleCoveredDetectionCallback) {
        this.mModuleCoveredDetectionCallback = meizuModuleCoveredDetectionCallback;
    }

    public final void setMeizuMetaDataCallback(MeizuMetaDataCallback meizuMetaDataCallback) {
        this.mMeizuMetaDataCallback = meizuMetaDataCallback;
        native_setMeizutMetadataCb(meizuMetaDataCallback != null);
    }

    /* renamed from: com.meizu.camera.MeizuCamera$a */
    private class C1154a extends Handler {

        /* renamed from: b */
        private MeizuCamera f3456b;

        public C1154a(MeizuCamera meizuCamera, Looper looper) {
            super(looper);
            this.f3456b = meizuCamera;
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 4) {
                if (i != 8) {
                    if (i != 16) {
                        if (i != 32) {
                            if (i != 64) {
                                if (i != 256) {
                                    switch (i) {
                                        case 1:
                                            if (MeizuCamera.this.mMeizuCameraErrorCb != null) {
                                                MeizuCamera.this.mMeizuCameraErrorCb.onError(message.arg1);
                                                return;
                                            }
                                            return;
                                        case 2:
                                            if (MeizuCamera.this.mContinuousCallback != null) {
                                                MeizuCamera.this.mContinuousCallback.onContinuousNotify(message.arg1, message.arg2);
                                                return;
                                            }
                                            return;
                                    }
                                } else if (MeizuCamera.this.mMeizuMetaDataCallback != null) {
                                    MeizuCamera.this.mMeizuMetaDataCallback.onMeizuMetaDataNotify(message.arg1, message.arg2);
                                }
                                Log.e(MeizuCamera.TAG, "Unknown message type" + message.what + "arg1 = " + message.arg1 + "arg2 = " + message.arg2);
                            } else if (MeizuCamera.this.mModuleCoveredDetectionCallback != null) {
                                MeizuCamera.this.mModuleCoveredDetectionCallback.onModuleCoveredDetection(message.arg1);
                            }
                        } else if (MeizuCamera.this.mSceneModeDetectionCallback != null) {
                            MeizuCamera.this.mSceneModeDetectionCallback.onSceneModeDetection(message.arg1);
                        }
                    } else if (MeizuCamera.this.mRefocusCallback != null) {
                        MeizuCamera.this.mRefocusCallback.onRefocusNotify(message.arg1, message.arg2, this.f3456b);
                    }
                } else if (MeizuCamera.this.mFlashLightListener != null) {
                    FlashLightListener access$000 = MeizuCamera.this.mFlashLightListener;
                    boolean z = true;
                    if (message.arg1 != 1) {
                        z = false;
                    }
                    access$000.onFlashLight(z);
                }
            } else if (MeizuCamera.this.mSecureDetectionCallback != null) {
                MeizuCamera.this.mSecureDetectionCallback.onSecureDetection(message.arg1, message.arg2);
            }
        }
    }

    private static void postEventFromNative(Object obj, int i, int i2, int i3, Object obj2) {
        MeizuCamera meizuCamera = (MeizuCamera) ((WeakReference) obj).get();
        if (meizuCamera != null && meizuCamera.mEventHandler != null) {
            meizuCamera.mEventHandler.sendMessage(meizuCamera.mEventHandler.obtainMessage(i, i2, i3, obj2));
        }
    }

    static {
        System.loadLibrary("meizucamera");
    }
}
