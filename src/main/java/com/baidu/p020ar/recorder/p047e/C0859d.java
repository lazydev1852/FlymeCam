package com.baidu.p020ar.recorder.p047e;

import android.opengl.GLES20;
import android.util.Log;
import com.baidu.p020ar.util.SystemInfoUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* renamed from: com.baidu.ar.recorder.e.d */
public class C0859d {
    /* renamed from: a */
    public static int m2464a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        m2467a("glCreateShader type=" + i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        Log.e("GlUtil", "Could not compile shader " + i + SystemInfoUtil.COLON);
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append(GLES20.glGetShaderInfoLog(glCreateShader));
        Log.e("GlUtil", sb.toString());
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    /* renamed from: a */
    public static int m2465a(String str, String str2) {
        int a;
        int a2 = m2464a(35633, str);
        if (a2 == 0 || (a = m2464a(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        m2467a("glCreateProgram");
        if (glCreateProgram == 0) {
            Log.e("GlUtil", "Could not create program");
        }
        GLES20.glAttachShader(glCreateProgram, a2);
        m2467a("glAttachShader");
        GLES20.glAttachShader(glCreateProgram, a);
        m2467a("glAttachShader");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            return glCreateProgram;
        }
        Log.e("GlUtil", "Could not link program: ");
        Log.e("GlUtil", GLES20.glGetProgramInfoLog(glCreateProgram));
        GLES20.glDeleteProgram(glCreateProgram);
        return 0;
    }

    /* renamed from: a */
    public static FloatBuffer m2466a(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    /* renamed from: a */
    public static void m2467a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Log.e("GlUtil", str + ": glError 0x" + Integer.toHexString(glGetError));
        }
    }
}
