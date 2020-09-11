package com.mediatek.mmsdk;

public class CameraEffectHalRuntimeException extends RuntimeException {
    private Throwable mCause;
    private String mMessage;
    private final int mReason;

    public final int getReason() {
        return this.mReason;
    }

    public CameraEffectHalRuntimeException(int i) {
        this.mReason = i;
    }

    public CameraEffectHalRuntimeException(int i, String str) {
        super(str);
        this.mReason = i;
        this.mMessage = str;
    }

    public CameraEffectHalRuntimeException(int i, String str, Throwable th) {
        super(str, th);
        this.mReason = i;
        this.mMessage = str;
        this.mCause = th;
    }

    public CameraEffectHalRuntimeException(int i, Throwable th) {
        super(th);
        this.mReason = i;
        this.mCause = th;
    }

    public CameraEffectHalException asChecked() {
        CameraEffectHalException cameraEffectHalException;
        if (this.mMessage != null && this.mCause != null) {
            cameraEffectHalException = new CameraEffectHalException(this.mReason, this.mMessage, this.mCause);
        } else if (this.mMessage != null) {
            cameraEffectHalException = new CameraEffectHalException(this.mReason, this.mMessage);
        } else if (this.mCause != null) {
            cameraEffectHalException = new CameraEffectHalException(this.mReason, this.mCause);
        } else {
            cameraEffectHalException = new CameraEffectHalException(this.mReason);
        }
        cameraEffectHalException.setStackTrace(getStackTrace());
        return cameraEffectHalException;
    }
}
