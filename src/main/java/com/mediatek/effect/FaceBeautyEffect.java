package com.mediatek.effect;

import android.media.Image;
import android.util.Log;

public class FaceBeautyEffect extends Effect {
    private static final String TAG = "FaceBeautyEffect";

    private native void native_apply(Image image, Image image2);

    private native void native_release();

    private native void native_setParameter(String str, Object obj);

    private native void native_setup(FaceBeautyEffect faceBeautyEffect);

    FaceBeautyEffect() {
        native_setup(this);
    }

    public static Effect createEffect() {
        return new FaceBeautyEffect();
    }

    public void apply(Image image, Image image2) {
        Log.i("FaceBeautyEffect", "apply(), srcImage:" + image + ", targetImage:" + image2);
        native_apply(image, image2);
    }

    public String getName() {
        Log.i("FaceBeautyEffect", "getName(), effectName:" + "facebeautyeffect");
        return "facebeautyeffect";
    }

    public void setParameter(String str, Object obj) {
        Log.i("FaceBeautyEffect", "setParameter(), parameterKey:" + str + ", value:" + obj.toString());
        native_setParameter(str, obj);
    }

    public void release() {
        native_release();
    }
}
