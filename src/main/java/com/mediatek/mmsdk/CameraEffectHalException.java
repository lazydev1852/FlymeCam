package com.mediatek.mmsdk;

import android.util.AndroidException;

public class CameraEffectHalException extends AndroidException {
    public static final int EFFECT_HAL_CLIENT_ERROR = 105;
    public static final int EFFECT_HAL_ERROR = 104;
    public static final int EFFECT_HAL_FACTORY_ERROR = 103;
    public static final int EFFECT_HAL_FEATUREMANAGER_ERROR = 102;
    public static final int EFFECT_HAL_IN_USE = 107;
    public static final int EFFECT_HAL_LISTENER_ERROR = 106;
    public static final int EFFECT_HAL_SERVICE_ERROR = 101;
    public static final int EFFECT_INITIAL_ERROR = 201;
    private final int mReason;

    public enum EffectHalError {
        EFFECT_HAL_SERVICE_ERROR,
        EFFECT_HAL_FEATUREMANAGER_ERROR,
        EFFECT_HAL_FACTORY_ERROR,
        EFFECT_HAL_ERROR,
        EFFECT_HAL_CLIENT_ERROR,
        EFFECT_HAL_LISTENER_ERROR,
        EFFECT_HAL_IN_USE
    }

    public enum EffectHalStatusError {
        EFFECT_INITIAL_ERROR
    }

    public static String getDefaultMessage(int i) {
        if (i == 107) {
            return "the problem type not in the camera hal,please add that in CameraEffectHalException ";
        }
        switch (i) {
        }
        return "the problem type not in the camera hal,please add that in CameraEffectHalException ";
    }

    public final int getReason() {
        return this.mReason;
    }

    public CameraEffectHalException(int i) {
        super(getDefaultMessage(i));
        this.mReason = i;
    }

    public CameraEffectHalException(int i, String str) {
        super(str);
        this.mReason = i;
    }

    public CameraEffectHalException(int i, String str, Throwable th) {
        super(str, th);
        this.mReason = i;
    }

    public CameraEffectHalException(int i, Throwable th) {
        super(getDefaultMessage(i), th);
        this.mReason = i;
    }
}
