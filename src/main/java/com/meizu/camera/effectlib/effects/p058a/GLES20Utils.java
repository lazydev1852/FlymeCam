package com.meizu.camera.effectlib.effects.p058a;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.util.Log;
import com.meizu.imageproc.SurfaceTextureWrapper;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import java.lang.reflect.Constructor;

/* renamed from: com.meizu.camera.effectlib.effects.a.a */
public class GLES20Utils {

    /* renamed from: a */
    public static ChangeQuickRedirect f3459a = null;

    /* renamed from: b */
    private static int f3460b = 9999;

    /* renamed from: c */
    private static Constructor<SurfaceTexture> f3461c;

    /* renamed from: d */
    private static Constructor<SurfaceTextureWrapper> f3462d;

    static {
        Class<SurfaceTexture> cls = SurfaceTexture.class;
        try {
            f3461c = cls.getDeclaredConstructor(new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        Class<SurfaceTextureWrapper> cls2 = SurfaceTextureWrapper.class;
        try {
            f3462d = cls2.getDeclaredConstructor(new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    public static Constructor<SurfaceTexture> m4016a() {
        return f3461c;
    }

    /* renamed from: a */
    public static void m4017a(String str) {
        int glGetError;
        if (!PatchProxy.proxy(new Object[]{str}, (Object) null, f3459a, true, 89, new Class[]{String.class}, Void.TYPE).isSupported && (glGetError = GLES20.glGetError()) != 0) {
            throw new IllegalStateException(str + ": glError " + glGetError);
        }
    }

    /* renamed from: b */
    public static void m4019b(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, (Object) null, f3459a, true, 90, new Class[]{String.class}, Void.TYPE).isSupported) {
            while (true) {
                int glGetError = GLES20.glGetError();
                if (glGetError != 0) {
                    Log.e("GLES20Utils", str + " glError" + glGetError);
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public static boolean m4018a(float[] fArr) {
        return fArr[0] == 1.0f && fArr[1] == 0.0f && fArr[2] == 0.0f && fArr[3] == 0.0f && fArr[4] == 0.0f && fArr[5] == 1.0f && fArr[6] == 0.0f && fArr[7] == 0.0f && fArr[8] == 0.0f && fArr[9] == 0.0f && fArr[10] == 1.0f && fArr[11] == 0.0f && fArr[12] == 0.0f && fArr[13] == 0.0f && fArr[14] == 0.0f && fArr[15] == 1.0f;
    }
}
