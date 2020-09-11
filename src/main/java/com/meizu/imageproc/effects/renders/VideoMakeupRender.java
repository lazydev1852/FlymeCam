package com.meizu.imageproc.effects.renders;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.Log;
import com.meizu.camera.effectlib.effects.p058a.GLTexture;
import com.meizu.camera.effectlib.effects.p059b.BaseRender;
import com.meizu.camera.effectlib.effects.views.EffectRenderContext;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.HashMap;
import java.util.Map;

public class VideoMakeupRender extends BaseRender {

    /* renamed from: k */
    public static ChangeQuickRedirect f6481k;

    /* renamed from: l */
    private static Map<String, Integer> f6482l = new HashMap();

    /* renamed from: p */
    private static final float[] f6483p = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: q */
    private static final float[] f6484q = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: m */
    private long f6485m = 0;

    /* renamed from: n */
    private SurfaceTexture f6486n;

    /* renamed from: o */
    private int f6487o = 0;

    /* renamed from: r */
    private float[] f6488r;

    private native boolean nativeGetProcessedVMFrame(long j, int[] iArr, int[] iArr2, int i, int i2);

    private native long nativeInit(SurfaceTexture surfaceTexture);

    private native void nativeProcess(long j, int i, int i2, int i3, int i4);

    private native void nativeRelease(long j);

    private native void nativeSetMakeupStyle(long j, int i);

    private native void nativeSetMvpMatrix(long j, float[] fArr);

    private native void nativeSetPosVertices(long j, float[] fArr);

    private native void nativeSetTexMatrix(long j, float[] fArr);

    private native void nativeSetTexVertices(long j, float[] fArr);

    static {
        f6482l.put("original", 0);
        f6482l.put("enthusiasm", 1);
        f6482l.put("intellectuality", 2);
        f6482l.put("innocent", 3);
        f6482l.put("fresh", 4);
        f6482l.put("addict", 5);
        System.loadLibrary("vmp_render");
    }

    /* renamed from: a */
    public void mo14038a() {
        if (!PatchProxy.proxy(new Object[0], this, f6481k, false, 588, new Class[0], Void.TYPE).isSupported) {
            SurfaceTexture y = EffectRenderContext.m4369h().mo14241y();
            if (y == null) {
                mo14048d();
            } else if (this.f6486n != y) {
                if (0 != this.f6485m) {
                    nativeRelease(this.f6485m);
                    this.f6485m = 0;
                }
                this.f6485m = nativeInit(y);
                this.f6486n = y;
            }
        }
    }

    /* renamed from: a */
    public static int m6383a(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f6481k, true, 589, new Class[]{String.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        Integer num = f6482l.get(str);
        if (num != null) {
            return num.intValue();
        }
        Log.e("VideoMakeupRender", "invalid style key");
        return 0;
    }

    /* renamed from: b */
    public void mo17631b(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f6481k, false, 590, new Class[]{String.class}, Void.TYPE).isSupported) {
            this.f6487o = m6383a(str);
        }
    }

    /* renamed from: b */
    public void mo14045b(float[] fArr) {
        if (!PatchProxy.proxy(new Object[]{fArr}, this, f6481k, false, 591, new Class[]{float[].class}, Void.TYPE).isSupported && fArr != null) {
            if (this.f6488r == null) {
                this.f6488r = new float[8];
            }
            System.arraycopy(fArr, 0, this.f6488r, 0, this.f6488r.length);
        }
    }

    /* renamed from: a */
    public void mo14040a(GLTexture cVar, int i, int i2, int i3, int i4) {
        Object[] objArr = {cVar, new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4)};
        ChangeQuickRedirect changeQuickRedirect = f6481k;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 592, new Class[]{GLTexture.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            mo14038a();
            if (0 != this.f6485m) {
                nativeSetMakeupStyle(this.f6485m, this.f6487o);
                if (this.f6488r != null) {
                    nativeSetTexVertices(this.f6485m, this.f6488r);
                    this.f6488r = null;
                } else {
                    nativeSetTexVertices(this.f6485m, f6483p);
                }
                nativeSetPosVertices(this.f6485m, f6484q);
                nativeSetTexMatrix(this.f6485m, this.f3494i);
                nativeSetMvpMatrix(this.f6485m, this.f3493h);
                nativeProcess(this.f6485m, i, i2, i3, i4);
            }
        }
    }

    /* renamed from: a */
    public Bitmap mo17630a(int[] iArr, int[] iArr2, int i, int i2) {
        Object[] objArr = {iArr, iArr2, new Integer(i), new Integer(i2)};
        Object[] objArr2 = objArr;
        PatchProxyResult proxy = PatchProxy.proxy(objArr2, this, f6481k, false, 593, new Class[]{int[].class, int[].class, Integer.TYPE, Integer.TYPE}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        if (0 == this.f6485m) {
            return null;
        }
        Log.d("VideoFaceBeautyRender", "getRenderFrame");
        if (!nativeGetProcessedVMFrame(this.f6485m, iArr, iArr2, i, i2) || iArr[0] <= 0 || iArr[1] <= 0) {
            Log.e("VideoFaceBeautyRender", "nativeGetProcessedFrame failed.");
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(iArr[0], iArr[1], Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr2, 0, iArr[0], 0, 0, iArr[0], iArr[1]);
        return createBitmap;
    }

    /* renamed from: d */
    public void mo14048d() {
        if (!PatchProxy.proxy(new Object[0], this, f6481k, false, 594, new Class[0], Void.TYPE).isSupported) {
            if (0 != this.f6485m) {
                nativeRelease(this.f6485m);
                this.f6485m = 0;
            }
            EffectRenderContext.m4369h().mo14213f(false);
            EffectRenderContext.m4369h().mo14218h(false);
            this.f6486n = null;
        }
    }
}
