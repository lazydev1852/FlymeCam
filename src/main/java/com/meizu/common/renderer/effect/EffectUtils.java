package com.meizu.common.renderer.effect;

import com.meizu.common.renderer.GLRendererNotProguard;

public class EffectUtils {
    @GLRendererNotProguard
    private static native void native_glReadPixels(Object obj, int i, int i2);
}
