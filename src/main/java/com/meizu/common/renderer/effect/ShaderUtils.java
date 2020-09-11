package com.meizu.common.renderer.effect;

import android.opengl.GLES20;
import android.util.Log;
import com.arcsoft.livebroadcast.ArcSpotlightOffscreen;
import com.baidu.p020ar.util.SystemInfoUtil;
import com.meizu.common.renderer.wrapper.GLES20Wrapper;

/* renamed from: com.meizu.common.renderer.effect.h */
public class ShaderUtils {
    /* renamed from: a */
    public static int m5095a(int i, String str) {
        int glCreateShader = GLES20Wrapper.glCreateShader(i);
        if (glCreateShader == 0) {
            return glCreateShader;
        }
        GLES20Wrapper.glShaderSource(glCreateShader, str);
        GLES20Wrapper.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20Wrapper.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        Log.e("glrenderer", "Could not compile shader " + i + SystemInfoUtil.COLON + str);
        StringBuilder sb = new StringBuilder();
        sb.append("Info :");
        sb.append(GLES20Wrapper.glGetShaderInfoLog(glCreateShader));
        Log.e("glrenderer", sb.toString());
        Log.e("glrenderer", str);
        GLES20Wrapper.glDeleteShader(glCreateShader);
        return 0;
    }

    /* renamed from: a */
    public static int m5096a(String str, String str2) {
        int a;
        int a2 = m5095a(35633, str);
        if (a2 == 0 || (a = m5095a(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20Wrapper.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20Wrapper.glAttachShader(glCreateProgram, a2);
            m5098a("glAttachShader");
            GLES20Wrapper.glAttachShader(glCreateProgram, a);
            m5098a("glAttachShader");
            GLES20Wrapper.glLinkProgram(glCreateProgram);
            GLES20Wrapper.glDeleteShader(a2);
            GLES20Wrapper.glDeleteShader(a);
            m5098a("glDeleteShader");
            int[] iArr = new int[1];
            GLES20Wrapper.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                Log.e("glrenderer", "Could not link program: ");
                Log.e("glrenderer", GLES20Wrapper.glGetProgramInfoLog(glCreateProgram));
                GLES20Wrapper.glDeleteProgram(glCreateProgram);
                return 0;
            }
        }
        return glCreateProgram;
    }

    /* renamed from: a */
    public static void m5098a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Log.e("glrenderer", str + ": glError " + glGetError);
            throw new RuntimeException(str + ": glError " + glGetError);
        }
    }

    /* renamed from: a */
    public static void m5097a() {
        int glGetError;
        String str;
        if (GLRenderer.f4381d && (glGetError = GLES20.glGetError()) != 0) {
            if (glGetError != 1285) {
                switch (glGetError) {
                    case 1280:
                        str = "GL_INVALID_ENUM";
                        break;
                    case ArcSpotlightOffscreen.ASVL_PAF_YUYV:
                        str = "GL_INVALID_VALUE";
                        break;
                    case 1282:
                        str = "GL_INVALID_OPERATION";
                        break;
                    default:
                        str = String.valueOf(glGetError);
                        break;
                }
            } else {
                str = "GL_OUT_OF_MEMORY";
            }
            Log.e("glrenderer", "glError: " + str);
            throw new IllegalStateException("glError: " + str);
        }
    }
}
