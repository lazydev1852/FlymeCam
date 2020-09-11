package com.meizu.imageproc.effects.renders;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.util.Log;
import com.meizu.camera.effectlib.effects.p058a.GLTexture;
import com.meizu.camera.effectlib.effects.p059b.BaseRender;
import com.meizu.camera.effectlib.effects.views.EffectRenderContext;
import com.meizu.imageproc.SurfaceTextureWrapper;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class VideoFaceBeautyRender extends BaseRender {

    /* renamed from: k */
    public static ChangeQuickRedirect f6473k;

    /* renamed from: l */
    public static VideoFaceBeautyRender f6474l;

    /* renamed from: p */
    private static final float[] f6475p = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: q */
    private static final float[] f6476q = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: m */
    private long f6477m = 0;

    /* renamed from: n */
    private SurfaceTexture f6478n;

    /* renamed from: o */
    private SurfaceTextureWrapper f6479o;

    /* renamed from: r */
    private float[] f6480r;

    private native boolean nativeGetProcessedFrame(long j, int[] iArr, int[] iArr2, int i, int i2);

    private native long nativeInit(SurfaceTexture surfaceTexture);

    private native long nativeInit(SurfaceTextureWrapper surfaceTextureWrapper);

    private native void nativeProcess(long j, int i, int i2, int i3, int i4);

    private native void nativeRelease(long j);

    private native void nativeSetEyeEnlargementStrength(long j, int i);

    private native void nativeSetMvpMatrix(long j, float[] fArr);

    private native void nativeSetPosVertices(long j, float[] fArr);

    private native void nativeSetSkinToneBrightStrength(long j, int i);

    private native void nativeSetSkinToneStyleStrength(long j, int i);

    private native void nativeSetSlimmingStrength(long j, int i);

    private native void nativeSetSmoothingStrength(long j, int i);

    private native void nativeSetTexMatrix(long j, float[] fArr);

    private native void nativeSetTexVertices(long j, float[] fArr);

    private native void nativeSetToningStrength(long j, int i);

    static {
        if (Build.VERSION.SDK_INT < 29) {
            Log.i("VideoFaceBeautyRender", "loadLibrary FlymeFixLinker");
            try {
                System.loadLibrary("FlymeFixLinker");
            } catch (UnsatisfiedLinkError unused) {
            }
        }
        try {
            Log.e("VideoFaceBeautyRender", "loadLibrary vfb_render");
            System.loadLibrary("vfb_render");
        } catch (UnsatisfiedLinkError e) {
            Log.e("VideoFaceBeautyRender", "loadLibrary vfb_render error");
            e.printStackTrace();
        }
    }

    /* renamed from: g */
    public static VideoFaceBeautyRender m6376g() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f6473k, true, 581, new Class[0], VideoFaceBeautyRender.class);
        if (proxy.isSupported) {
            return (VideoFaceBeautyRender) proxy.result;
        }
        EffectRenderContext.m4369h().mo14218h(true);
        if (f6474l == null) {
            f6474l = new VideoFaceBeautyRender();
        }
        return f6474l;
    }

    /* renamed from: a */
    public void mo14038a() {
        if (!PatchProxy.proxy(new Object[0], this, f6473k, false, 582, new Class[0], Void.TYPE).isSupported) {
            if (Build.VERSION.SDK_INT >= 29) {
                SurfaceTextureWrapper z = EffectRenderContext.m4369h().mo14242z();
                if (z == null) {
                    mo14048d();
                } else if (this.f6479o != z) {
                    if (0 != this.f6477m) {
                        nativeRelease(this.f6477m);
                        this.f6477m = 0;
                    }
                    this.f6477m = nativeInit(z);
                    this.f6479o = z;
                }
            } else {
                SurfaceTexture y = EffectRenderContext.m4369h().mo14241y();
                if (y == null) {
                    mo14048d();
                } else if (this.f6478n != y) {
                    if (0 != this.f6477m) {
                        nativeRelease(this.f6477m);
                        this.f6477m = 0;
                    }
                    this.f6477m = nativeInit(y);
                    this.f6478n = y;
                }
            }
        }
    }

    /* renamed from: a */
    public void mo14042a(String str, Object obj) {
        Class[] clsArr = {String.class, Object.class};
        if (!PatchProxy.proxy(new Object[]{str, obj}, this, f6473k, false, 583, clsArr, Void.TYPE).isSupported) {
            super.mo14042a(str, obj);
            if ("eyeEnlargement-Strength".equals(str)) {
                EffectRenderContext.m4369h().mo14209e(((Integer) obj).intValue());
            } else if ("slimming-Strength".equals(str)) {
                EffectRenderContext.m4369h().mo14212f(((Integer) obj).intValue());
            } else if ("smoothing-Strength".equals(str)) {
                EffectRenderContext.m4369h().mo14206d(((Integer) obj).intValue());
            } else if ("toning-Strength".equals(str)) {
                EffectRenderContext.m4369h().mo14172a(((Integer) obj).intValue());
            } else if ("skinbright-Strength".equals(str)) {
                EffectRenderContext.m4369h().mo14190b(((Integer) obj).intValue());
            } else if ("skinauto-Strength".equals(str)) {
                EffectRenderContext.m4369h().mo14199c(((Integer) obj).intValue());
            }
        }
    }

    /* renamed from: b */
    public void mo14045b(float[] fArr) {
        if (!PatchProxy.proxy(new Object[]{fArr}, this, f6473k, false, 584, new Class[]{float[].class}, Void.TYPE).isSupported && fArr != null) {
            if (this.f6480r == null) {
                this.f6480r = new float[8];
            }
            System.arraycopy(fArr, 0, this.f6480r, 0, this.f6480r.length);
        }
    }

    /* renamed from: a */
    public void mo14040a(GLTexture cVar, int i, int i2, int i3, int i4) {
        Object[] objArr = {cVar, new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4)};
        ChangeQuickRedirect changeQuickRedirect = f6473k;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 585, new Class[]{GLTexture.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            mo14038a();
            if (0 != this.f6477m) {
                nativeSetSmoothingStrength(this.f6477m, EffectRenderContext.m4369h().mo14230n());
                nativeSetToningStrength(this.f6477m, EffectRenderContext.m4369h().mo14224k());
                nativeSetSlimmingStrength(this.f6477m, EffectRenderContext.m4369h().mo14232p());
                nativeSetEyeEnlargementStrength(this.f6477m, EffectRenderContext.m4369h().mo14231o());
                if (EffectRenderContext.m4369h().f3808e) {
                    if (EffectRenderContext.m4369h().mo14226l() != -1) {
                        nativeSetSkinToneBrightStrength(this.f6477m, EffectRenderContext.m4369h().mo14226l());
                    }
                    if (EffectRenderContext.m4369h().mo14228m() != -1) {
                        nativeSetSkinToneStyleStrength(this.f6477m, EffectRenderContext.m4369h().mo14228m());
                    }
                }
                if (this.f6480r != null) {
                    nativeSetTexVertices(this.f6477m, this.f6480r);
                    this.f6480r = null;
                } else {
                    nativeSetTexVertices(this.f6477m, f6475p);
                }
                nativeSetPosVertices(this.f6477m, f6476q);
                nativeSetTexMatrix(this.f6477m, this.f3494i);
                nativeSetMvpMatrix(this.f6477m, this.f3493h);
                nativeProcess(this.f6477m, i, i2, i3, i4);
            }
        }
    }

    /* renamed from: a */
    public Bitmap mo17629a(int[] iArr, int[] iArr2, int i, int i2) {
        Object[] objArr = {iArr, iArr2, new Integer(i), new Integer(i2)};
        Object[] objArr2 = objArr;
        PatchProxyResult proxy = PatchProxy.proxy(objArr2, this, f6473k, false, 586, new Class[]{int[].class, int[].class, Integer.TYPE, Integer.TYPE}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        if (0 == this.f6477m) {
            return null;
        }
        Log.d("VideoFaceBeautyRender", "getRenderFrame");
        if (!nativeGetProcessedFrame(this.f6477m, iArr, iArr2, i, i2) || iArr[0] <= 0 || iArr[1] <= 0) {
            Log.e("VideoFaceBeautyRender", "nativeGetProcessedFrame failed.");
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(iArr[0], iArr[1], Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr2, 0, iArr[0], 0, 0, iArr[0], iArr[1]);
        return createBitmap;
    }

    /* renamed from: d */
    public void mo14048d() {
        if (!PatchProxy.proxy(new Object[0], this, f6473k, false, 587, new Class[0], Void.TYPE).isSupported) {
            if (0 != this.f6477m) {
                nativeRelease(this.f6477m);
                this.f6477m = 0;
            }
            EffectRenderContext.m4369h().mo14213f(false);
            EffectRenderContext.m4369h().mo14218h(false);
            this.f6478n = null;
            f6474l = null;
        }
    }
}
