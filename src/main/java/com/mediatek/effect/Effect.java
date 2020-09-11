package com.mediatek.effect;

import android.media.Image;

public abstract class Effect {
    private static final String TAG = "Effect";

    public interface EffectUpdateListener {
        void onEffectUpdateds(Effect effect, Object obj);
    }

    public abstract void apply(Image image, Image image2);

    public abstract String getName();

    /* access modifiers changed from: protected */
    public native void native_setUpdateListener(EffectUpdateListener effectUpdateListener);

    public abstract void release();

    public abstract void setParameter(String str, Object obj);

    protected Effect() {
    }

    public void setUpdateListener(EffectUpdateListener effectUpdateListener) {
        native_setUpdateListener(effectUpdateListener);
    }
}
