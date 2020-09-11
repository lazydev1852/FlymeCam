package com.mediatek.mmsdk;

import android.util.Log;
import com.meizu.savior.Constants;

public class CameraEffectStatus {
    private static final boolean DEBUG = true;
    private static final String TAG = "CameraEffectStatus";
    private CameraEffectHalStatus mCurrentStatus = CameraEffectHalStatus.STATUS_UNINITIALIZED;

    public enum CameraEffectHalStatus {
        STATUS_UNINITIALIZED,
        STATUS_INITIALIZED,
        STATUS_CONFINGURED,
        STATUS_RUNNING
    }

    public void setEffectHalStatus(CameraEffectHalStatus cameraEffectHalStatus) {
        Log.i(TAG, Constants.ARRAY_TYPE + Thread.currentThread().getStackTrace()[2].getMethodName() + "] ,mCurrentStatus = " + this.mCurrentStatus + ",next status = " + cameraEffectHalStatus);
        this.mCurrentStatus = cameraEffectHalStatus;
    }

    public CameraEffectHalStatus getEffectHalStatus() {
        Log.i(TAG, Constants.ARRAY_TYPE + Thread.currentThread().getStackTrace()[2].getMethodName() + "] ,mCurrentStatus = " + this.mCurrentStatus);
        return this.mCurrentStatus;
    }
}
