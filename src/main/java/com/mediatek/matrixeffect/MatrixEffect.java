package com.mediatek.matrixeffect;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import java.lang.ref.WeakReference;

public class MatrixEffect {
    private static final int MSG_EFFECT_DONE = 100;
    private static final String TAG = "MatrixEffect_Framework";
    private static MatrixEffect sMatrixEffect;
    /* access modifiers changed from: private */
    public EffectsCallback mEffectsListener;
    private EventHandler mEventHandler;

    public interface EffectsCallback {
        void onEffectsDone();
    }

    private native void native_displayEffect(byte[] bArr, int i);

    private native void native_initializeEffect(int i, int i2, int i3, int i4);

    private native void native_processEffect(byte[] bArr, int[] iArr);

    private native void native_registerEffectBuffers(int i, int i2, byte[][] bArr);

    private native void native_releaseEffect();

    private native void native_setSurfaceToNative(Surface surface, int i);

    private native void native_setup(Object obj);

    MatrixEffect() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.mEventHandler = new EventHandler(myLooper);
        } else {
            this.mEventHandler = new EventHandler(Looper.getMainLooper());
        }
        native_setup(new WeakReference(this));
    }

    public static MatrixEffect getInstance() {
        if (sMatrixEffect == null) {
            sMatrixEffect = new MatrixEffect();
        }
        return sMatrixEffect;
    }

    public void setCallback(EffectsCallback effectsCallback) {
        this.mEffectsListener = effectsCallback;
    }

    public void setSurface(Surface surface, int i) {
        native_setSurfaceToNative(surface, i);
    }

    public void initialize(int i, int i2, int i3, int i4) {
        native_initializeEffect(i, i2, i3, i4);
    }

    public void setBuffers(int i, int i2, byte[][] bArr) {
        native_registerEffectBuffers(i, i2, bArr);
    }

    public void process(byte[] bArr, int[] iArr) {
        native_processEffect(bArr, iArr);
    }

    public void release() {
        native_releaseEffect();
    }

    private class EventHandler extends Handler {
        public EventHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            Log.i(MatrixEffect.TAG, "handleMessage:" + message);
            if (message.what == 100 && MatrixEffect.this.mEffectsListener != null) {
                MatrixEffect.this.mEffectsListener.onEffectsDone();
            }
        }
    }

    private static void postEventFromNative(Object obj, int i) {
        ((MatrixEffect) ((WeakReference) obj).get()).mEventHandler.obtainMessage(i).sendToTarget();
    }

    static {
        System.loadLibrary("jni_lomoeffect");
    }
}
