package com.mediatek.gesture;

import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemProperties;
import android.util.Log;

public class Gesture {
    private static final int MSG_RECEIVER_GESTURE = 0;
    private static final String POSE_OPENPALM = "openpalm";
    private static final String POSE_VICTORY = "victory";
    private static final String TAG = "Gesture_Framework";
    private static boolean mIsEmulator;
    private static Gesture sGesture;
    /* access modifiers changed from: private */
    public HandPose mDetectedPose;
    /* access modifiers changed from: private */
    public EmulatorHandler mEmulatorHandler;
    /* access modifiers changed from: private */
    public HandDetectionListener mHandDetectionListener;

    public interface HandDetectionListener {
        void onHandDetected(HandDetectionEvent handDetectionEvent);
    }

    private static native void native_addGesture(HandDetectionListener handDetectionListener, HandPose handPose);

    private static native void native_removeGesture(HandDetectionListener handDetectionListener, HandPose handPose);

    private native void native_setup(Gesture gesture);

    static {
        boolean z = false;
        if (SystemProperties.getInt("ro.mtk_emulator_support", 0) == 1) {
            z = true;
        }
        mIsEmulator = z;
        if (!mIsEmulator) {
            System.loadLibrary("jni_gesture");
        }
    }

    Gesture() {
        Log.i(TAG, "mIsEmulator:" + mIsEmulator);
        if (!mIsEmulator) {
            native_setup(this);
            return;
        }
        HandlerThread handlerThread = new HandlerThread("emulator-gesture-thread");
        handlerThread.start();
        this.mEmulatorHandler = new EmulatorHandler(handlerThread.getLooper());
    }

    public static Gesture createGesture() {
        if (sGesture == null) {
            sGesture = new Gesture();
        }
        return sGesture;
    }

    public class HandDetectionEvent {
        private Rect boundBox;
        /* access modifiers changed from: private */
        public float confidence;

        /* renamed from: id */
        private int f3451id;
        /* access modifiers changed from: private */
        public HandPose pose;

        public HandDetectionEvent() {
        }

        public void setBoundBox(Rect rect) {
            this.boundBox = rect;
        }

        public Rect getBoundBox() {
            return this.boundBox;
        }

        public void setConfidence(float f) {
            this.confidence = f;
        }

        public float getConfidence() {
            return this.confidence;
        }

        public void setId(int i) {
            this.f3451id = i;
        }

        public int getId() {
            return this.f3451id;
        }

        public void setPose(HandPose handPose) {
            this.pose = handPose;
        }

        public HandPose getPose() {
            return this.pose;
        }
    }

    public enum HandPose {
        POSE_OPENPLAM(0),
        POSE_VICTORY(1);
        
        private int mValue;

        private HandPose(int i) {
            this.mValue = i;
        }

        private int getValue() {
            return this.mValue;
        }
    }

    public void addHandDetectionListener(HandDetectionListener handDetectionListener, HandPose handPose) {
        Log.i(TAG, "addHandDetectionListener(), pose:" + handPose + ", listener:" + handDetectionListener);
        this.mHandDetectionListener = handDetectionListener;
        this.mDetectedPose = handPose;
        if (!mIsEmulator) {
            native_addGesture(handDetectionListener, handPose);
        } else if (this.mEmulatorHandler != null) {
            this.mEmulatorHandler.sendEmptyMessage(0);
        }
    }

    public void removeHandDetectionListener(HandDetectionListener handDetectionListener, HandPose handPose) {
        Log.i(TAG, "removeHandDetectionListener(), pose:" + handPose + ", listener:" + handDetectionListener);
        this.mHandDetectionListener = null;
        if (!mIsEmulator) {
            native_removeGesture(handDetectionListener, handPose);
        } else if (this.mEmulatorHandler != null) {
            this.mEmulatorHandler.removeMessages(0);
        }
    }

    private class EmulatorHandler extends Handler {
        public EmulatorHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what == 0) {
                String str = SystemProperties.get("com.mediatek.gesture.pose", (String) null);
                Log.i(Gesture.TAG, "detected pose from DDMS:" + str);
                if (str != null) {
                    HandDetectionEvent handDetectionEvent = new HandDetectionEvent();
                    float unused = handDetectionEvent.confidence = 100.0f;
                    if (Gesture.POSE_OPENPALM.equalsIgnoreCase(str) && Gesture.this.mDetectedPose == HandPose.POSE_OPENPLAM) {
                        HandPose unused2 = handDetectionEvent.pose = HandPose.POSE_OPENPLAM;
                        Gesture.this.mHandDetectionListener.onHandDetected(handDetectionEvent);
                    } else if (!Gesture.POSE_VICTORY.equalsIgnoreCase(str) || Gesture.this.mDetectedPose != HandPose.POSE_VICTORY) {
                        Gesture.this.mHandDetectionListener.onHandDetected((HandDetectionEvent) null);
                    } else {
                        HandPose unused3 = handDetectionEvent.pose = HandPose.POSE_VICTORY;
                        Gesture.this.mHandDetectionListener.onHandDetected(handDetectionEvent);
                    }
                }
                Gesture.this.mEmulatorHandler.sendEmptyMessageDelayed(0, 1000);
            }
        }
    }
}
