package com.meizu.imageproc;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.util.Log;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class SurfaceTextureBitmap {

    /* renamed from: a */
    public static ChangeQuickRedirect f6462a = null;

    /* renamed from: b */
    private static boolean f6463b = false;

    /* renamed from: c */
    private static int f6464c;

    /* renamed from: d */
    private static int f6465d;

    public enum IMAGE_FORMAT {
        IMAGE_FORMAT_NONE,
        IMAGE_FORMAT_YV12,
        IMAGE_FORMAT_I420,
        IMAGE_FORMAT_NV12,
        IMAGE_FORMAT_NV21,
        IMAGE_FORMAT_MAX;
        
        public static ChangeQuickRedirect changeQuickRedirect;
    }

    private static native void getSurfaceTextureBitmap(SurfaceTexture surfaceTexture, int[] iArr, int[] iArr2, int i, int i2, int i3);

    private static native void getSurfaceTextureBitmap(SurfaceTextureWrapper surfaceTextureWrapper, int[] iArr, int[] iArr2, int i, int i2, int i3);

    private static native void getSurfaceTextureYuv(SurfaceTexture surfaceTexture, byte[] bArr, int[] iArr, int[] iArr2, int[] iArr3, int i);

    private static native void getSurfaceTextureYuv(SurfaceTextureWrapper surfaceTextureWrapper, byte[] bArr, int[] iArr, int[] iArr2, int[] iArr3, int i);

    /* renamed from: a */
    public static void m6367a() {
        if (!PatchProxy.proxy(new Object[0], (Object) null, f6462a, true, 538, new Class[0], Void.TYPE).isSupported) {
            Log.i("mZ_SurfaceTextureBitmap", "init");
        }
    }

    /* renamed from: a */
    public static void m6368a(boolean z) {
        f6463b = z;
    }

    /* renamed from: b */
    public static boolean m6369b() {
        return f6463b;
    }

    /* renamed from: a */
    public static Bitmap m6365a(SurfaceTexture surfaceTexture, int[] iArr, int[] iArr2, int i, int i2, int i3) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{surfaceTexture, iArr, iArr2, new Integer(i), new Integer(i2), new Integer(i3)}, (Object) null, f6462a, true, 539, new Class[]{SurfaceTexture.class, int[].class, int[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        if (!f6463b) {
            Log.e("mZ_SurfaceTextureBitmap", "Texture is not Update");
            return null;
        } else if (surfaceTexture == null) {
            return null;
        } else {
            getSurfaceTextureBitmap(surfaceTexture, iArr, iArr2, i, i2, i3);
            if (iArr[0] <= 0 || iArr[1] <= 0) {
                Log.e("mZ_SurfaceTextureBitmap", "bitmap width and height must be > 0 width " + iArr[0] + " height " + iArr[1]);
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(iArr[0], iArr[1], Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr2, 0, iArr[0], 0, 0, iArr[0], iArr[1]);
            f6464c = iArr[0];
            f6465d = iArr[1];
            return createBitmap;
        }
    }

    /* renamed from: a */
    public static Bitmap m6366a(SurfaceTextureWrapper surfaceTextureWrapper, int[] iArr, int[] iArr2, int i, int i2, int i3) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{surfaceTextureWrapper, iArr, iArr2, new Integer(i), new Integer(i2), new Integer(i3)}, (Object) null, f6462a, true, 540, new Class[]{SurfaceTextureWrapper.class, int[].class, int[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        if (!f6463b) {
            Log.e("mZ_SurfaceTextureBitmap", "Texture is not Update");
            return null;
        } else if (surfaceTextureWrapper == null) {
            return null;
        } else {
            getSurfaceTextureBitmap(surfaceTextureWrapper, iArr, iArr2, i, i2, i3);
            if (iArr[0] <= 0 || iArr[1] <= 0) {
                Log.e("mZ_SurfaceTextureBitmap", "bitmap width and height must be > 0 width " + iArr[0] + " height " + iArr[1]);
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(iArr[0], iArr[1], Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr2, 0, iArr[0], 0, 0, iArr[0], iArr[1]);
            f6464c = iArr[0];
            f6465d = iArr[1];
            return createBitmap;
        }
    }

    /* renamed from: a */
    public static Bitmap m6364a(Bitmap bitmap) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap}, (Object) null, f6462a, true, 542, new Class[]{Bitmap.class}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        Canvas canvas = new Canvas();
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        canvas.setBitmap(createBitmap);
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.postRotate(180.0f, ((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
        matrix.postScale(-1.0f, 1.0f);
        matrix.postTranslate((float) bitmap.getWidth(), 0.0f);
        canvas.drawBitmap(bitmap, matrix, (Paint) null);
        return createBitmap;
    }

    /* renamed from: a */
    public static int m6362a(SurfaceTexture surfaceTexture, byte[] bArr, int[] iArr, int[] iArr2, int i) {
        Object[] objArr = {surfaceTexture, bArr, iArr, iArr2, new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f6462a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 543, new Class[]{SurfaceTexture.class, byte[].class, int[].class, int[].class, Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (!f6463b) {
            Log.e("mZ_SurfaceTextureBitmap", "Texture is not Update");
            return 0;
        } else if (surfaceTexture == null) {
            return 0;
        } else {
            int[] iArr3 = new int[2];
            getSurfaceTextureYuv(surfaceTexture, bArr, iArr, iArr2, iArr3, i);
            return iArr3[0];
        }
    }

    /* renamed from: a */
    public static int m6363a(SurfaceTextureWrapper surfaceTextureWrapper, byte[] bArr, int[] iArr, int[] iArr2, int i) {
        Object[] objArr = {surfaceTextureWrapper, bArr, iArr, iArr2, new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f6462a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 544, new Class[]{SurfaceTextureWrapper.class, byte[].class, int[].class, int[].class, Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (!f6463b) {
            Log.e("mZ_SurfaceTextureBitmap", "Texture is not Update");
            return 0;
        } else if (surfaceTextureWrapper == null) {
            return 0;
        } else {
            int[] iArr3 = new int[2];
            getSurfaceTextureYuv(surfaceTextureWrapper, bArr, iArr, iArr2, iArr3, i);
            return iArr3[0];
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 29) {
            Log.i("mZ_SurfaceTextureBitmap", "loadLibrary FlymeFixLinker");
            try {
                System.loadLibrary("FlymeFixLinker");
            } catch (UnsatisfiedLinkError unused) {
            }
        }
        try {
            Log.i("mZ_SurfaceTextureBitmap", "loadLibrary surfacetexture_bitmap");
            System.loadLibrary("surfacetexture_bitmap");
        } catch (UnsatisfiedLinkError e) {
            Log.i("mZ_SurfaceTextureBitmap", "loadLibrary surfacetexture_bitmap error: " + e.getMessage());
        }
    }
}
