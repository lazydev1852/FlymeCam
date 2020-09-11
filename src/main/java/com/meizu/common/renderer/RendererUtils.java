package com.meizu.common.renderer;

public class RendererUtils {
    @GLRendererNotProguard
    private static native void native_blurBitmap(Object obj, int i);

    /* renamed from: a */
    public static void m5021a(boolean z) {
        if (!z) {
            throw new AssertionError();
        }
    }
}
