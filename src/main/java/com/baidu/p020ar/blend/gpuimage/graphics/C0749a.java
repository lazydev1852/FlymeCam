package com.baidu.p020ar.blend.gpuimage.graphics;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.util.Log;
import com.baidu.p020ar.util.SystemInfoUtil;
import com.mediatek.accessor.packer.PackUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* renamed from: com.baidu.ar.blend.gpuimage.graphics.a */
public class C0749a {

    /* renamed from: a */
    public static final float[] f1635a = new float[16];

    /* renamed from: b */
    public static final float[] f1636b = new float[16];

    /* renamed from: c */
    public static final float[] f1637c = new float[16];

    /* renamed from: d */
    public static final float[] f1638d = new float[16];

    static {
        Matrix.setIdentityM(f1635a, 0);
        Matrix.setIdentityM(f1636b, 0);
        Matrix.scaleM(f1636b, 0, -1.0f, 1.0f, 1.0f);
        Matrix.setIdentityM(f1637c, 0);
        Matrix.scaleM(f1637c, 0, 1.0f, -1.0f, 1.0f);
        Matrix.setIdentityM(f1638d, 0);
        Matrix.scaleM(f1638d, 0, -1.0f, -1.0f, 1.0f);
    }

    /* renamed from: a */
    public static int m1931a() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(iArr.length, iArr, 0);
        return iArr[0];
    }

    /* renamed from: a */
    public static int m1932a(int i) {
        return m1933a(i, 0);
    }

    /* renamed from: a */
    private static int m1933a(int i, int i2) {
        int i3 = i2 == 0 ? 9729 : 9728;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        m1941a("glGenTextures");
        int i4 = iArr[0];
        GLES20.glBindTexture(i, i4);
        m1941a("glBindTexture " + i4);
        float f = (float) i3;
        GLES20.glTexParameterf(i, 10241, f);
        GLES20.glTexParameterf(i, PackUtils.FIXED_BUFFER_SIZE, f);
        GLES20.glTexParameteri(i, 10242, 33071);
        GLES20.glTexParameteri(i, 10243, 33071);
        m1941a("glTexParameter");
        return i4;
    }

    /* renamed from: a */
    public static int m1934a(int i, int i2, int i3) {
        int a = m1932a(i);
        GLES20.glTexImage2D(i, 0, 6408, i2, i3, 0, 6408, 5121, (Buffer) null);
        m1941a("createTextureObject");
        return a;
    }

    /* renamed from: a */
    public static int m1935a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        m1941a("glCreateShader type=" + i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        Log.e("GlUtil", "Could not compile shader " + i + SystemInfoUtil.COLON);
        Log.e("GlUtil", "error=" + GLES20.glGetError() + ";log=" + GLES20.glGetShaderInfoLog(glCreateShader));
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    /* renamed from: a */
    public static int m1936a(Bitmap bitmap, int i, boolean z) {
        int[] iArr = new int[1];
        if (i == -1) {
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameterf(3553, PackUtils.FIXED_BUFFER_SIZE, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
        } else {
            GLES20.glBindTexture(3553, i);
            GLUtils.texSubImage2D(3553, 0, 0, 0, bitmap);
            iArr[0] = i;
        }
        if (z) {
            bitmap.recycle();
        }
        return iArr[0];
    }

    /* renamed from: a */
    public static int m1937a(String str, String str2) {
        int a;
        int a2 = m1935a(35633, str);
        if (a2 == 0 || (a = m1935a(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        m1941a("glCreateProgram");
        if (glCreateProgram == 0) {
            Log.e("GlUtil", "Could not create program");
        }
        GLES20.glAttachShader(glCreateProgram, a2);
        m1941a("glAttachShader");
        GLES20.glAttachShader(glCreateProgram, a);
        m1941a("glAttachShader");
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
    public static int m1938a(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, int i5) {
        int i6 = i5;
        int[] iArr = new int[1];
        if (i6 == -1) {
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameterf(3553, PackUtils.FIXED_BUFFER_SIZE, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glTexImage2D(3553, 0, 6408, i3, i4, 0, 6408, 5121, byteBuffer);
        } else {
            GLES20.glBindTexture(3553, i6);
            GLES20.glTexSubImage2D(3553, 0, i, i2, i3, i4, 6408, 5121, byteBuffer);
            iArr[0] = i6;
        }
        return iArr[0];
    }

    /* renamed from: a */
    public static FloatBuffer m1939a(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    /* renamed from: a */
    public static void m1940a(int i, int i2, int i3, int i4, int i5) {
        GLES20.glBindRenderbuffer(36161, i4);
        GLES20.glRenderbufferStorage(36161, i, i2, i3);
        GLES20.glBindRenderbuffer(36161, 0);
        GLES20.glBindFramebuffer(36160, i5);
        GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, i4);
        GLES20.glBindFramebuffer(36160, 0);
    }

    /* renamed from: a */
    public static void m1941a(String str) {
        GLES20.glGetError();
    }

    /* renamed from: b */
    public static int m1942b() {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        return iArr[0];
    }

    /* renamed from: b */
    public static void m1943b(int i) {
        if (i != -1) {
            GLES20.glDeleteTextures(1, new int[]{i}, 0);
            m1941a("glDeleteTextures");
        }
    }

    /* renamed from: b */
    public static void m1944b(int i, int i2, int i3) {
        GLES20.glBindFramebuffer(36160, i3);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glBindTexture(i2, i);
        GLES20.glFramebufferTexture2D(36160, 36064, i2, i, 0);
    }

    /* renamed from: b */
    public static void m1945b(int i, String str) {
    }

    /* renamed from: c */
    public static int m1946c() {
        int[] iArr = new int[1];
        GLES20.glGenRenderbuffers(1, iArr, 0);
        return iArr[0];
    }

    /* renamed from: c */
    public static void m1947c(int i) {
        if (i != -1) {
            GLES20.glDeleteFramebuffers(1, new int[]{i}, 0);
            m1941a("glDeleteFramebuffers");
        }
    }

    /* renamed from: d */
    public static void m1948d(int i) {
        if (i != -1) {
            GLES20.glDeleteRenderbuffers(1, new int[]{i}, 0);
            m1941a("glDeleteRenderbuffers");
        }
    }
}
