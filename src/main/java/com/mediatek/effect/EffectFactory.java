package com.mediatek.effect;

import android.util.Log;

public class EffectFactory {
    public static final String EFFECTS_FACEBEAUTIFIER = "FaceBeautyEffect";
    private static final String TAG = "EffectFactory";
    private static EffectFactory sEffectFactory;

    private native boolean native_isEffectSupporteds(String str);

    EffectFactory() {
    }

    public static EffectFactory createEffectFactory() {
        if (sEffectFactory == null) {
            sEffectFactory = new EffectFactory();
        }
        return sEffectFactory;
    }

    public Effect createEffect(String str) {
        Log.i(TAG, "createEffect(), effectName:" + str);
        if (str.equals(EFFECTS_FACEBEAUTIFIER)) {
            return FaceBeautyEffect.createEffect();
        }
        return null;
    }

    public boolean isEffectSupported(String str) {
        Log.i(TAG, "isEffectSupporteds(), effectName:" + str);
        return native_isEffectSupporteds(str);
    }

    static {
        System.loadLibrary("jni_effects");
    }
}
