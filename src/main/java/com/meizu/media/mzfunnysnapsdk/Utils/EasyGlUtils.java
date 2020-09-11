package com.meizu.media.mzfunnysnapsdk.Utils;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import com.mediatek.accessor.packer.PackUtils;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.nio.Buffer;

public enum EasyGlUtils {
    ;
    
    public static ChangeQuickRedirect changeQuickRedirect;

    public static void useTexParameter() {
        if (!PatchProxy.proxy(new Object[0], (Object) null, changeQuickRedirect, true, 9401, new Class[0], Void.TYPE).isSupported) {
            GLES20.glTexParameterf(3553, 10241, 9728.0f);
            GLES20.glTexParameterf(3553, PackUtils.FIXED_BUFFER_SIZE, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
        }
    }

    public static void useTexParameter(int i, int i2, int i3, int i4) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4)}, (Object) null, changeQuickRedirect, true, 9402, new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            GLES20.glTexParameterf(3553, 10242, (float) i);
            GLES20.glTexParameterf(3553, 10243, (float) i2);
            GLES20.glTexParameterf(3553, 10241, (float) i3);
            GLES20.glTexParameterf(3553, PackUtils.FIXED_BUFFER_SIZE, (float) i4);
        }
    }

    public static void genTexturesWithParameter(int i, int[] iArr, int i2, int i3, int i4, int i5) {
        int i6 = i;
        if (!PatchProxy.proxy(new Object[]{new Integer(i6), iArr, new Integer(i2), new Integer(i3), new Integer(i4), new Integer(i5)}, (Object) null, changeQuickRedirect, true, 9403, new Class[]{Integer.TYPE, int[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            GLES20.glGenTextures(i, iArr, i2);
            int i7 = 0;
            while (i7 < i6) {
                GLES20.glBindTexture(3553, iArr[i7]);
                GLES20.glTexImage2D(3553, 0, i3, i4, i5, 0, i3, 5121, (Buffer) null);
                useTexParameter();
                i7++;
                int i8 = i3;
                int i9 = i5;
            }
            GLES20.glBindTexture(3553, 0);
        }
    }

    public static void bindFrameTexture(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 9404, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            GLES20.glBindFramebuffer(36160, i);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
        }
    }

    public static void unBindFrameBuffer() {
        if (!PatchProxy.proxy(new Object[0], (Object) null, changeQuickRedirect, true, 9405, new Class[0], Void.TYPE).isSupported) {
            GLES20.glBindFramebuffer(36160, 0);
        }
    }

    public static int getTextureFromBitmap(Bitmap bitmap, int[] iArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap, iArr}, (Object) null, changeQuickRedirect, true, 9406, new Class[]{Bitmap.class, int[].class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int[] iArr2 = new int[1];
        GLES20.glGenTextures(1, iArr2, 0);
        if (iArr2[0] == 0) {
            Log.d("GLES20", "Failed at glGenTextures");
            return 0;
        } else if (bitmap == null) {
            Log.d("GLES20", "Failed at decoding bitmap");
            GLES20.glDeleteTextures(1, iArr2, 0);
            return 0;
        } else {
            if (iArr != null && iArr.length >= 2) {
                iArr[0] = bitmap.getWidth();
                iArr[1] = bitmap.getHeight();
            }
            GLES20.glBindTexture(3553, iArr2[0]);
            GLES20.glTexParameterf(3553, PackUtils.FIXED_BUFFER_SIZE, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
            bitmap.recycle();
            GLES20.glBindTexture(3553, 0);
            return iArr2[0];
        }
    }

    public static void bindTexture2D(int i, int i2, int i3, int i4) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4)}, (Object) null, changeQuickRedirect, true, 9407, new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported && i != 0) {
            GLES20.glActiveTexture(i2);
            GLES20.glBindTexture(3553, i);
            GLES20.glUniform1i(i3, i4);
        }
    }

    public static void checkEglError(String str) {
        int eglGetError;
        if (!PatchProxy.proxy(new Object[]{str}, (Object) null, changeQuickRedirect, true, 9408, new Class[]{String.class}, Void.TYPE).isSupported && (eglGetError = EGL14.eglGetError()) != 12288) {
            Log.d("GLES20", str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
        }
    }
}
