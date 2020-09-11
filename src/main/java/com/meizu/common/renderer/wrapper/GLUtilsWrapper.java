package com.meizu.common.renderer.wrapper;

import android.graphics.Bitmap;
import android.opengl.GLUtils;
import com.meizu.common.renderer.GLRendererNotProguard;
import com.meizu.common.renderer.effect.ShaderUtils;

@GLRendererNotProguard
public class GLUtilsWrapper {
    public static int getInternalFormat(Bitmap bitmap) {
        int internalFormat = GLUtils.getInternalFormat(bitmap);
        ShaderUtils.m5097a();
        return internalFormat;
    }

    public static int getType(Bitmap bitmap) {
        int type = GLUtils.getType(bitmap);
        ShaderUtils.m5097a();
        return type;
    }

    public static void texImage2D(int i, int i2, int i3, Bitmap bitmap, int i4) {
        GLUtils.texImage2D(i, i2, i3, bitmap, i4);
        ShaderUtils.m5097a();
    }

    public static void texImage2D(int i, int i2, int i3, Bitmap bitmap, int i4, int i5) {
        GLUtils.texImage2D(i, i2, i3, bitmap, i4, i5);
        ShaderUtils.m5097a();
    }

    public static void texImage2D(int i, int i2, Bitmap bitmap, int i3) {
        GLUtils.texImage2D(i, i2, bitmap, i3);
        ShaderUtils.m5097a();
    }

    public static void texSubImage2D(int i, int i2, int i3, int i4, Bitmap bitmap) {
        GLUtils.texSubImage2D(i, i2, i3, i4, bitmap);
        ShaderUtils.m5097a();
    }

    public static void texSubImage2D(int i, int i2, int i3, int i4, Bitmap bitmap, int i5, int i6) {
        GLUtils.texSubImage2D(i, i2, i3, i4, bitmap, i5, i6);
        ShaderUtils.m5097a();
    }

    public static String getEGLErrorString(int i) {
        String eGLErrorString = GLUtils.getEGLErrorString(i);
        ShaderUtils.m5097a();
        return eGLErrorString;
    }
}
