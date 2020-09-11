package com.meizu.camera.effectlib.effects.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.meizu.camera.effectlib.effects.filters.SurfaceManager;
import com.meizu.camera.effectlib.effects.p058a.GLES20Utils;
import com.meizu.camera.effectlib.effects.p058a.GLTexture;
import com.meizu.camera.effectlib.effects.p059b.BaseRender;
import com.meizu.camera.effectlib.effects.p059b.MediaRecordRender;
import com.meizu.camera.effectlib.effects.views.PreviewView;
import com.meizu.imageproc.SurfaceTextureBitmap;
import com.meizu.imageproc.SurfaceTextureWrapper;
import com.meizu.imageproc.effects.renders.VideoFaceBeautyRender;
import com.meizu.imageproc.effects.renders.VideoMakeupRender;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class MzVideoSurfaceView extends SurfaceView implements SurfaceHolder.Callback, PreviewView {

    /* renamed from: a */
    public static ChangeQuickRedirect f3942a;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final float[] f3943f = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final float[] f3944g = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static final float[] f3945h = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};

    /* renamed from: A */
    private boolean f3946A;

    /* renamed from: B */
    private boolean f3947B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public Bitmap f3948C;

    /* renamed from: D */
    private int f3949D;

    /* renamed from: E */
    private int[] f3950E;

    /* renamed from: F */
    private int[] f3951F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public EffectRenderFactory f3952G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public boolean f3953H;

    /* renamed from: I */
    private boolean f3954I;

    /* renamed from: J */
    private final float[] f3955J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public boolean f3956K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public boolean f3957L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public boolean f3958M;
    /* access modifiers changed from: private */

    /* renamed from: N */
    public boolean f3959N;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public final Object f3960O;

    /* renamed from: P */
    private int f3961P;

    /* renamed from: Q */
    private int f3962Q;
    /* access modifiers changed from: private */

    /* renamed from: R */
    public Bitmap f3963R;
    /* access modifiers changed from: private */

    /* renamed from: S */
    public DepthRenderProgram f3964S;
    /* access modifiers changed from: private */

    /* renamed from: T */
    public int f3965T;
    /* access modifiers changed from: private */

    /* renamed from: U */
    public int f3966U;
    /* access modifiers changed from: private */

    /* renamed from: V */
    public boolean f3967V;
    /* access modifiers changed from: private */

    /* renamed from: W */
    public int f3968W;
    /* access modifiers changed from: private */

    /* renamed from: aa */
    public int f3969aa;
    /* access modifiers changed from: private */

    /* renamed from: ab */
    public int f3970ab;

    /* renamed from: ac */
    private boolean f3971ac;

    /* renamed from: ad */
    private int f3972ad;

    /* renamed from: ae */
    private float f3973ae;

    /* renamed from: af */
    private float f3974af;

    /* renamed from: ag */
    private float f3975ag;
    /* access modifiers changed from: private */

    /* renamed from: ah */
    public final float[] f3976ah;
    /* access modifiers changed from: private */

    /* renamed from: ai */
    public short[] f3977ai;
    /* access modifiers changed from: private */

    /* renamed from: aj */
    public boolean f3978aj;
    /* access modifiers changed from: private */

    /* renamed from: ak */
    public MediaRecordRender f3979ak;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public SurfaceTexture f3980b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public SurfaceTextureWrapper f3981c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Object f3982d;

    /* renamed from: e */
    private SurfaceHolder f3983e;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C1184b f3984i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public C1185c f3985j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f3986k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f3987l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f3988m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public GLTexture f3989n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f3990o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public final float[] f3991p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public final float[] f3992q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public final float[] f3993r;

    /* renamed from: s */
    private final float[] f3994s;

    /* renamed from: t */
    private C1182a f3995t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public BaseRender f3996u;

    /* renamed from: v */
    private int f3997v;

    /* renamed from: w */
    private int f3998w;

    /* renamed from: x */
    private String f3999x;

    /* renamed from: y */
    private int f4000y;

    /* renamed from: z */
    private boolean f4001z;

    /* renamed from: com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView$b */
    public interface C1184b {
        /* renamed from: a */
        void mo14293a();

        /* renamed from: a */
        void mo14294a(SurfaceTexture surfaceTexture, int i, int i2);

        /* renamed from: a */
        boolean mo14295a(SurfaceTexture surfaceTexture);

        /* renamed from: b */
        void mo14296b(SurfaceTexture surfaceTexture, int i, int i2);
    }

    /* renamed from: com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView$c */
    public interface C1185c {
        /* renamed from: a */
        void mo14297a();

        /* renamed from: a */
        void mo14298a(SurfaceTextureWrapper surfaceTextureWrapper, int i, int i2);

        /* renamed from: a */
        boolean mo14299a(SurfaceTextureWrapper surfaceTextureWrapper);
    }

    public BaseRender getVfbRender() {
        return null;
    }

    /* renamed from: i */
    public void mo14117i() {
    }

    /* renamed from: l */
    public void mo14120l() {
    }

    public void setBokehListener(PreviewView.C1192a aVar) {
    }

    public void setBokehStatus(boolean z) {
    }

    public void setPreviewData(byte[] bArr, int i, int i2, int i3) {
    }

    public void setRenderViewCallBackListener(PreviewView.C1193b bVar) {
    }

    public void setSurfaceTextureListener(PreviewView.C1194c cVar) {
    }

    public void setSurfaceTextureListener2(PreviewView.C1194c cVar, PreviewView.C1195d dVar) {
    }

    public void setTofStatus(boolean z) {
    }

    public void setTransformParms(float f, float f2, float f3) {
    }

    public void setVfbRenderType(String str) {
    }

    public void setYuvInput(boolean z) {
    }

    public MzVideoSurfaceView(Context context) {
        super(context);
        this.f3982d = new Object();
        this.f3990o = false;
        this.f3991p = new float[16];
        this.f3992q = new float[16];
        this.f3993r = new float[16];
        this.f3994s = new float[16];
        this.f3948C = null;
        this.f3949D = 4;
        this.f3950E = new int[6000000];
        this.f3951F = new int[2];
        this.f3953H = false;
        this.f3954I = false;
        this.f3955J = new float[16];
        this.f3956K = false;
        this.f3957L = false;
        this.f3958M = true;
        this.f3959N = false;
        this.f3960O = new Object();
        this.f3961P = 0;
        this.f3962Q = 0;
        this.f3963R = null;
        this.f3964S = null;
        this.f3965T = -1;
        this.f3966U = -1;
        this.f3967V = false;
        this.f3968W = -1;
        this.f3969aa = -1;
        this.f3970ab = -1;
        this.f3971ac = false;
        this.f3972ad = 1;
        this.f3973ae = 0.0f;
        this.f3974af = 0.0f;
        this.f3975ag = 0.0f;
        this.f3976ah = new float[16];
        this.f3977ai = new short[]{0, 2, 1, 1, 2, 3};
        this.f3978aj = false;
        this.f3983e = getHolder();
        this.f3983e.addCallback(this);
    }

    public MzVideoSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3982d = new Object();
        this.f3990o = false;
        this.f3991p = new float[16];
        this.f3992q = new float[16];
        this.f3993r = new float[16];
        this.f3994s = new float[16];
        this.f3948C = null;
        this.f3949D = 4;
        this.f3950E = new int[6000000];
        this.f3951F = new int[2];
        this.f3953H = false;
        this.f3954I = false;
        this.f3955J = new float[16];
        this.f3956K = false;
        this.f3957L = false;
        this.f3958M = true;
        this.f3959N = false;
        this.f3960O = new Object();
        this.f3961P = 0;
        this.f3962Q = 0;
        this.f3963R = null;
        this.f3964S = null;
        this.f3965T = -1;
        this.f3966U = -1;
        this.f3967V = false;
        this.f3968W = -1;
        this.f3969aa = -1;
        this.f3970ab = -1;
        this.f3971ac = false;
        this.f3972ad = 1;
        this.f3973ae = 0.0f;
        this.f3974af = 0.0f;
        this.f3975ag = 0.0f;
        this.f3976ah = new float[16];
        this.f3977ai = new short[]{0, 2, 1, 1, 2, 3};
        this.f3978aj = false;
        this.f3983e = getHolder();
        this.f3983e.addCallback(this);
    }

    /* renamed from: a */
    public void mo14100a() {
        if (!PatchProxy.proxy(new Object[0], this, f3942a, false, 405, new Class[0], Void.TYPE).isSupported) {
            mo14271b();
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (!PatchProxy.proxy(new Object[]{surfaceHolder}, this, f3942a, false, 406, new Class[]{SurfaceHolder.class}, Void.TYPE).isSupported) {
            Log.i("MzVideoSurfaceView", " surfaceCreated");
            this.f3953H = true;
            this.f3959N = true;
            if (this.f3954I) {
                mo14108f();
            } else if (this.f3995t != null) {
                this.f3954I = true;
                this.f3995t.mo14291a(this);
            }
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Object[] objArr = {surfaceHolder, new Integer(i), new Integer(i2), new Integer(i3)};
        ChangeQuickRedirect changeQuickRedirect = f3942a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 407, new Class[]{SurfaceHolder.class, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            Log.d("MzVideoSurfaceView", " surfaceChanged w:" + i2 + "x" + i3);
            if (i2 <= 0 || i3 <= 0 || (i2 == this.f3997v && i3 == this.f3998w)) {
                this.f3997v = i2;
                this.f3998w = i3;
            } else if (this.f3997v == 0 && this.f3998w == 0) {
                this.f3997v = i2;
                this.f3998w = i3;
            }
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (!PatchProxy.proxy(new Object[]{surfaceHolder}, this, f3942a, false, 408, new Class[]{SurfaceHolder.class}, Void.TYPE).isSupported) {
            Log.i("MzVideoSurfaceView", "surfaceDestroyed");
            this.f3953H = false;
        }
    }

    /* renamed from: b */
    public void mo14271b() {
        if (!PatchProxy.proxy(new Object[0], this, f3942a, false, 409, new Class[0], Void.TYPE).isSupported) {
            Log.i("MzVideoSurfaceView", " initCameraPreviewRender ");
            this.f3995t = new C1182a();
            Matrix.setIdentityM(this.f3991p, 0);
            Matrix.setIdentityM(this.f3992q, 0);
            Matrix.setIdentityM(this.f3994s, 0);
            Matrix.setIdentityM(this.f3955J, 0);
            this.f3956K = false;
        }
    }

    public void layout(int i, int i2, int i3, int i4) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4)}, this, f3942a, false, 410, new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            super.layout(i, i2, i3, i4);
            this.f3986k = getWidth();
            this.f3987l = getHeight();
            if (!(this.f3980b == null || this.f3984i == null)) {
                this.f3984i.mo14296b(this.f3980b, this.f3986k, this.f3987l);
            }
            invalidate();
        }
    }

    /* renamed from: m */
    public void mo14122m() {
        if (!PatchProxy.proxy(new Object[0], this, f3942a, false, 411, new Class[0], Void.TYPE).isSupported && EffectRenderContext.m4369h().mo14238v() && this.f3995t != null) {
            this.f3995t.m4688c();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setTransform(float[] r18) {
        /*
            r17 = this;
            r7 = r17
            r8 = r18
            r9 = 1
            java.lang.Object[] r0 = new java.lang.Object[r9]
            r10 = 0
            r0[r10] = r8
            com.meizu.savior.ChangeQuickRedirect r2 = f3942a
            java.lang.Class[] r5 = new java.lang.Class[r9]
            java.lang.Class<float[]> r1 = float[].class
            r5[r10] = r1
            java.lang.Class r6 = java.lang.Void.TYPE
            r3 = 0
            r4 = 412(0x19c, float:5.77E-43)
            r1 = r17
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r0, r1, r2, r3, r4, r5, r6)
            boolean r0 = r0.isSupported
            if (r0 == 0) goto L_0x0022
            return
        L_0x0022:
            java.lang.String r0 = "MzVideoSurfaceView"
            java.lang.String r1 = "setTransform"
            android.util.Log.i(r0, r1)
            if (r8 == 0) goto L_0x0072
            int r0 = r8.length
            float[] r1 = r7.f3991p
            int r1 = r1.length
            if (r0 < r1) goto L_0x0072
            float[] r0 = r7.f3991p
            float[] r1 = r7.f3991p
            int r1 = r1.length
            java.lang.System.arraycopy(r8, r10, r0, r10, r1)
            float[] r0 = r7.f3955J
            float[] r1 = r7.f3955J
            int r1 = r1.length
            java.lang.System.arraycopy(r8, r10, r0, r10, r1)
            float[] r0 = r7.f3976ah
            float[] r1 = r7.f3976ah
            int r1 = r1.length
            java.lang.System.arraycopy(r8, r10, r0, r10, r1)
            float[] r11 = r7.f3955J
            r12 = 0
            r13 = 1127481344(0x43340000, float:180.0)
            r14 = 0
            r15 = 1065353216(0x3f800000, float:1.0)
            r16 = 0
            android.opengl.Matrix.rotateM(r11, r12, r13, r14, r15, r16)
            float[] r0 = r7.f3955J
            r1 = 0
            r2 = 1119092736(0x42b40000, float:90.0)
            r3 = 0
            r4 = 0
            r5 = 1065353216(0x3f800000, float:1.0)
            android.opengl.Matrix.rotateM(r0, r1, r2, r3, r4, r5)
            float[] r10 = r7.f3976ah
            r11 = 0
            r12 = 1119092736(0x42b40000, float:90.0)
            r13 = 0
            android.opengl.Matrix.rotateM(r10, r11, r12, r13, r14, r15)
            float[] r0 = r7.f3976ah
            r2 = 1127481344(0x43340000, float:180.0)
            android.opengl.Matrix.rotateM(r0, r1, r2, r3, r4, r5)
        L_0x0072:
            r7.setCleanScreen(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.setTransform(float[]):void");
    }

    /* renamed from: a */
    public void mo14103a(float[] fArr) {
        if (!PatchProxy.proxy(new Object[]{fArr}, this, f3942a, false, 413, new Class[]{float[].class}, Void.TYPE).isSupported && fArr != null && fArr.length >= this.f3991p.length) {
            System.arraycopy(this.f3991p, 0, fArr, 0, this.f3991p.length);
        }
    }

    public MzVideoSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3982d = new Object();
        this.f3990o = false;
        this.f3991p = new float[16];
        this.f3992q = new float[16];
        this.f3993r = new float[16];
        this.f3994s = new float[16];
        this.f3948C = null;
        this.f3949D = 4;
        this.f3950E = new int[6000000];
        this.f3951F = new int[2];
        this.f3953H = false;
        this.f3954I = false;
        this.f3955J = new float[16];
        this.f3956K = false;
        this.f3957L = false;
        this.f3958M = true;
        this.f3959N = false;
        this.f3960O = new Object();
        this.f3961P = 0;
        this.f3962Q = 0;
        this.f3963R = null;
        this.f3964S = null;
        this.f3965T = -1;
        this.f3966U = -1;
        this.f3967V = false;
        this.f3968W = -1;
        this.f3969aa = -1;
        this.f3970ab = -1;
        this.f3971ac = false;
        this.f3972ad = 1;
        this.f3973ae = 0.0f;
        this.f3974af = 0.0f;
        this.f3975ag = 0.0f;
        this.f3976ah = new float[16];
        this.f3977ai = new short[]{0, 2, 1, 1, 2, 3};
        this.f3978aj = false;
    }

    public void setVideoSurfaceTextureListener(C1184b bVar) {
        this.f3984i = bVar;
    }

    public void setVideoSurfaceTextureWrapperListener(C1185c cVar) {
        this.f3985j = cVar;
    }

    public BaseRender getRender() {
        return this.f3996u;
    }

    public Bitmap getPreviewBitmap() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f3942a, false, 414, new Class[0], Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        synchronized (this.f3982d) {
            if (this.f3948C == null || this.f3948C.isRecycled()) {
                return null;
            }
            Bitmap bitmap = this.f3948C;
            return bitmap;
        }
    }

    /* renamed from: a */
    public Bitmap mo14099a(int i, int i2) {
        Bitmap bitmap;
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f3942a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 415, new Class[]{Integer.TYPE, Integer.TYPE}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        synchronized (this.f3982d) {
            bitmap = null;
            if (this.f3948C != null && !this.f3948C.isRecycled()) {
                bitmap = Bitmap.createScaledBitmap(this.f3948C, i, i2, false);
            }
        }
        return bitmap;
    }

    public void setRenderTranslationY(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f3942a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 416, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f3988m = i;
            mo14122m();
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo14106d() {
        /*
            r8 = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            com.meizu.savior.ChangeQuickRedirect r3 = f3942a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 417(0x1a1, float:5.84E-43)
            r2 = r8
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0016
            return
        L_0x0016:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 29
            if (r1 < r2) goto L_0x0021
            r8.m4652s()
            goto L_0x00d9
        L_0x0021:
            java.lang.Object r1 = r8.f3982d
            monitor-enter(r1)
            java.lang.String r2 = "MzVideoSurfaceView"
            java.lang.String r3 = "MzVideoSurfaceView init "
            android.util.Log.i(r2, r3)     // Catch:{ all -> 0x00da }
            android.graphics.SurfaceTexture r2 = r8.f3980b     // Catch:{ all -> 0x00da }
            r3 = 1
            if (r2 != 0) goto L_0x0094
            java.lang.reflect.Constructor r2 = com.meizu.camera.effectlib.effects.p058a.GLES20Utils.m4016a()     // Catch:{ Exception -> 0x0078 }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0078 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r0)     // Catch:{ Exception -> 0x0078 }
            r4[r0] = r5     // Catch:{ Exception -> 0x0078 }
            java.lang.Object r2 = r2.newInstance(r4)     // Catch:{ Exception -> 0x0078 }
            android.graphics.SurfaceTexture r2 = (android.graphics.SurfaceTexture) r2     // Catch:{ Exception -> 0x0078 }
            r8.f3980b = r2     // Catch:{ Exception -> 0x0078 }
            java.lang.String r2 = "MzVideoSurfaceView"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0078 }
            r4.<init>()     // Catch:{ Exception -> 0x0078 }
            java.lang.String r5 = "newInstance SurfaceTexture:"
            r4.append(r5)     // Catch:{ Exception -> 0x0078 }
            android.graphics.SurfaceTexture r5 = r8.f3980b     // Catch:{ Exception -> 0x0078 }
            r4.append(r5)     // Catch:{ Exception -> 0x0078 }
            java.lang.String r5 = "PreviewTexture:"
            r4.append(r5)     // Catch:{ Exception -> 0x0078 }
            com.meizu.camera.effectlib.effects.a.c r5 = r8.f3989n     // Catch:{ Exception -> 0x0078 }
            r4.append(r5)     // Catch:{ Exception -> 0x0078 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0078 }
            android.util.Log.i(r2, r4)     // Catch:{ Exception -> 0x0078 }
            r8.f3990o = r0     // Catch:{ Exception -> 0x0078 }
            com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView$b r0 = r8.f3984i     // Catch:{ Exception -> 0x0078 }
            if (r0 == 0) goto L_0x00c5
            com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView$b r0 = r8.f3984i     // Catch:{ Exception -> 0x0078 }
            android.graphics.SurfaceTexture r2 = r8.f3980b     // Catch:{ Exception -> 0x0078 }
            int r4 = r8.f3986k     // Catch:{ Exception -> 0x0078 }
            int r5 = r8.f3987l     // Catch:{ Exception -> 0x0078 }
            r0.mo14294a(r2, r4, r5)     // Catch:{ Exception -> 0x0078 }
            goto L_0x00c5
        L_0x0078:
            r0 = move-exception
            java.lang.String r2 = "MzVideoSurfaceView"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00da }
            r4.<init>()     // Catch:{ all -> 0x00da }
            java.lang.String r5 = "error:"
            r4.append(r5)     // Catch:{ all -> 0x00da }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x00da }
            r4.append(r0)     // Catch:{ all -> 0x00da }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x00da }
            android.util.Log.e(r2, r0)     // Catch:{ all -> 0x00da }
            goto L_0x00c5
        L_0x0094:
            java.lang.String r0 = "MzVideoSurfaceView"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00da }
            r2.<init>()     // Catch:{ all -> 0x00da }
            java.lang.String r4 = "useInstance SurfaceTexture:"
            r2.append(r4)     // Catch:{ all -> 0x00da }
            android.graphics.SurfaceTexture r4 = r8.f3980b     // Catch:{ all -> 0x00da }
            r2.append(r4)     // Catch:{ all -> 0x00da }
            java.lang.String r4 = "PreviewTexture:"
            r2.append(r4)     // Catch:{ all -> 0x00da }
            com.meizu.camera.effectlib.effects.a.c r4 = r8.f3989n     // Catch:{ all -> 0x00da }
            r2.append(r4)     // Catch:{ all -> 0x00da }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00da }
            android.util.Log.i(r0, r2)     // Catch:{ all -> 0x00da }
            com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView$b r0 = r8.f3984i     // Catch:{ all -> 0x00da }
            if (r0 == 0) goto L_0x00c5
            com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView$b r0 = r8.f3984i     // Catch:{ all -> 0x00da }
            android.graphics.SurfaceTexture r2 = r8.f3980b     // Catch:{ all -> 0x00da }
            int r4 = r8.f3986k     // Catch:{ all -> 0x00da }
            int r5 = r8.f3987l     // Catch:{ all -> 0x00da }
            r0.mo14294a(r2, r4, r5)     // Catch:{ all -> 0x00da }
        L_0x00c5:
            boolean r0 = r8.f3953H     // Catch:{ all -> 0x00da }
            if (r0 == 0) goto L_0x00d8
            boolean r0 = r8.f3954I     // Catch:{ all -> 0x00da }
            if (r0 != 0) goto L_0x00d8
            com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView$a r0 = r8.f3995t     // Catch:{ all -> 0x00da }
            if (r0 == 0) goto L_0x00d8
            r8.f3954I = r3     // Catch:{ all -> 0x00da }
            com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView$a r0 = r8.f3995t     // Catch:{ all -> 0x00da }
            r0.mo14291a((com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView) r8)     // Catch:{ all -> 0x00da }
        L_0x00d8:
            monitor-exit(r1)     // Catch:{ all -> 0x00da }
        L_0x00d9:
            return
        L_0x00da:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00da }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.mo14106d():void");
    }

    /* renamed from: s */
    private void m4652s() {
        if (!PatchProxy.proxy(new Object[0], this, f3942a, false, 418, new Class[0], Void.TYPE).isSupported) {
            synchronized (this.f3982d) {
                Log.i("MzVideoSurfaceView", "MzVideoSurfaceView init ");
                if (this.f3981c == null) {
                    try {
                        this.f3981c = new SurfaceTextureWrapper(false);
                        Log.i("MzVideoSurfaceView", "newInstance SurfaceTexture:" + this.f3981c + "PreviewTexture:" + this.f3989n);
                        this.f3990o = false;
                        if (this.f3985j != null) {
                            this.f3985j.mo14298a(this.f3981c, this.f3986k, this.f3987l);
                        }
                    } catch (Exception e) {
                        Log.e("MzVideoSurfaceView", "error:" + e.getMessage());
                    }
                } else {
                    Log.i("MzVideoSurfaceView", "useInstance SurfaceTexture:" + this.f3981c + "PreviewTexture:" + this.f3989n);
                    if (this.f3985j != null) {
                        this.f3985j.mo14298a(this.f3981c, this.f3986k, this.f3987l);
                    }
                }
                if (this.f3953H && !this.f3954I && this.f3995t != null) {
                    this.f3954I = true;
                    this.f3995t.mo14291a(this);
                }
            }
        }
    }

    /* renamed from: h */
    public void mo14116h() {
        if (!PatchProxy.proxy(new Object[0], this, f3942a, false, 419, new Class[0], Void.TYPE).isSupported) {
            Log.i("MzVideoSurfaceView", "release");
        }
    }

    /* renamed from: e */
    public void mo14273e() {
        if (!PatchProxy.proxy(new Object[0], this, f3942a, false, 420, new Class[0], Void.TYPE).isSupported) {
            Log.i("MzVideoSurfaceView", "detach");
            if (this.f3995t != null) {
                this.f3995t.m4686b();
            }
        }
    }

    /* renamed from: g */
    public void mo14274g() {
        if (!PatchProxy.proxy(new Object[0], this, f3942a, false, 421, new Class[0], Void.TYPE).isSupported) {
            Log.i("MzVideoSurfaceView", "destroy");
            if (this.f3995t != null && this.f3954I) {
                this.f3995t.m4690d();
                this.f3954I = false;
            }
        }
    }

    /* renamed from: j */
    public void mo14118j() {
        if (!PatchProxy.proxy(new Object[0], this, f3942a, false, 422, new Class[0], Void.TYPE).isSupported) {
            Log.i("MzVideoSurfaceView", "ReleaseSurfaceTexture");
            if (this.f3980b != null) {
                this.f3980b.release();
                this.f3980b = null;
                if (this.f3984i != null) {
                    this.f3984i.mo14295a(this.f3980b);
                }
            }
            if (this.f3981c != null) {
                this.f3981c.release();
                this.f3981c = null;
                if (this.f3985j != null) {
                    this.f3985j.mo14299a(this.f3981c);
                }
            }
        }
    }

    /* renamed from: f */
    public void mo14108f() {
        if (!PatchProxy.proxy(new Object[0], this, f3942a, false, 423, new Class[0], Void.TYPE).isSupported) {
            Log.i("MzVideoSurfaceView", "resumeSurfaceTexture");
            if (Build.VERSION.SDK_INT >= 29) {
                m4654t();
            } else if (this.f3980b == null) {
                try {
                    this.f3980b = GLES20Utils.m4016a().newInstance(new Object[]{false});
                    Log.i("MzVideoSurfaceView", "newInstance SurfaceTexture:" + this.f3980b + "PreviewTexture:" + this.f3989n);
                    this.f3990o = false;
                    if (this.f3984i != null) {
                        this.f3984i.mo14294a(this.f3980b, this.f3986k, this.f3987l);
                    }
                } catch (Exception e) {
                    Log.e("MzVideoSurfaceView", "error:" + e.getMessage());
                }
            } else {
                Log.i("MzVideoSurfaceView", "useInstance SurfaceTexture:" + this.f3980b + "PreviewTexture:" + this.f3989n);
                if (this.f3984i != null) {
                    this.f3984i.mo14294a(this.f3980b, this.f3986k, this.f3987l);
                }
            }
        }
    }

    /* renamed from: t */
    private void m4654t() {
        if (!PatchProxy.proxy(new Object[0], this, f3942a, false, 424, new Class[0], Void.TYPE).isSupported) {
            if (this.f3981c == null) {
                try {
                    this.f3981c = new SurfaceTextureWrapper(false);
                    Log.i("MzVideoSurfaceView", "newInstance SurfaceTexture:" + this.f3981c + "PreviewTexture:" + this.f3989n);
                    this.f3990o = false;
                    if (this.f3984i != null) {
                        this.f3985j.mo14298a(this.f3981c, this.f3986k, this.f3987l);
                    }
                } catch (Exception e) {
                    Log.e("MzVideoSurfaceView", "error:" + e.getMessage());
                }
            } else {
                Log.i("MzVideoSurfaceView", "useInstance SurfaceTexture:" + this.f3981c + "PreviewTexture:" + this.f3989n);
                if (this.f3985j != null) {
                    this.f3985j.mo14298a(this.f3981c, this.f3986k, this.f3987l);
                }
            }
        }
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.f3980b;
    }

    public SurfaceTextureWrapper getSurfaceTextureWrapper() {
        return this.f3981c;
    }

    /* renamed from: k */
    public void mo14119k() {
        if (!PatchProxy.proxy(new Object[0], this, f3942a, false, 425, new Class[0], Void.TYPE).isSupported) {
            Log.i("MzVideoSurfaceView", "onResume");
            mo14108f();
        }
    }

    /* renamed from: a */
    public void mo14269a(int i) {
        boolean z = true;
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f3942a, false, 426, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            Log.i("MzVideoSurfaceView", "onPause");
            if (i != 1) {
                z = false;
            }
            int i2 = 90;
            if (z) {
                i2 = -90;
            }
            setSurfaceTextureBitmap(i2);
            mo14273e();
        }
    }

    /* renamed from: a */
    public void mo14102a(boolean z, boolean z2) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f3942a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 427, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            Log.i("MzVideoSurfaceView", "enableDraw :" + z);
            this.f3958M = z;
            if (!z2) {
                return;
            }
            if (this.f3958M) {
                setViewAlpha(1.0f);
            } else {
                setViewAlpha(0.0f);
            }
        }
    }

    public void setEffectRenderFactory(EffectRenderFactory bVar) {
        if (!PatchProxy.proxy(new Object[]{bVar}, this, f3942a, false, 428, new Class[]{EffectRenderFactory.class}, Void.TYPE).isSupported) {
            this.f3952G = bVar;
            if (this.f3952G != null) {
                this.f3999x = this.f3952G.mo14326b();
                this.f4000y = this.f3952G.mo14328c();
                this.f4001z = this.f3952G.mo14331d();
                this.f3946A = this.f3952G.mo14333e();
                this.f3947B = this.f3952G.mo14334f();
                EffectRenderContext.m4369h().mo14174a(this.f4000y, this.f4001z, this.f3946A, this.f3947B);
                EffectRenderContext.m4369h().mo14174a(this.f4000y, this.f4001z, this.f3946A, this.f3947B);
                Log.i("MzVideoSurfaceView", "mDeviceType " + this.f3999x + " mDevicePlatform " + this.f4000y + " mNeedFBThumnail " + this.f4001z + " misUseFBHigherLib " + this.f3946A + " mSupportFBandEffectOverlay" + this.f3947B);
                return;
            }
            Log.i("MzVideoSurfaceView", "mDeviceType is null ");
        }
    }

    /* renamed from: c */
    public void mo14105c() {
        if (!PatchProxy.proxy(new Object[0], this, f3942a, false, 429, new Class[0], Void.TYPE).isSupported) {
            Log.i("MzVideoSurfaceView", "initSurfaceTextureBitmap");
            SurfaceTextureBitmap.m6367a();
        }
    }

    public void setSurfaceTextureBitmap(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f3942a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 430, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            setSurfaceTextureBitmap(i, this.f3949D, true);
        }
    }

    public void setSurfaceTextureBitmap(int i, int i2, boolean z) {
        Object[] objArr = {new Integer(i), new Integer(i2), new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f3942a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 431, new Class[]{Integer.TYPE, Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            synchronized (this.f3982d) {
                SurfaceTextureBitmap.m6368a(true);
                Log.i("MzVideoSurfaceView", "setSurfaceTextureBitmap rotation " + i + " factor " + i2);
                if (EffectRenderContext.m4369h().f3807d && this.f3996u != null && (this.f3996u.mo14046c().mo14345d().equals("Mzvfacebeauty") || this.f3996u.mo14046c().mo14345d().equals("Mzmake up"))) {
                    if (this.f3996u.mo14046c().mo14345d().equals("Mzvfacebeauty")) {
                        Log.i("MzVideoSurfaceView", "fastFaceBeauty thumbnail");
                        this.f3948C = ((VideoFaceBeautyRender) this.f3996u).mo17629a(this.f3951F, this.f3950E, i2, i);
                    } else if (this.f3996u.mo14046c().mo14345d().equals("Mzmake up")) {
                        Log.i("MzVideoSurfaceView", "fastFaceBeauty thumbnail videomake");
                        this.f3948C = ((VideoMakeupRender) this.f3996u).mo17630a(this.f3951F, this.f3950E, i2, i);
                    }
                    if (this.f3948C == null) {
                        Log.e("MzVideoSurfaceView", "get fastFaceBeauty thumbnail fail");
                        if (Build.VERSION.SDK_INT >= 29) {
                            this.f3948C = SurfaceTextureBitmap.m6366a(this.f3981c, this.f3951F, this.f3950E, i2, i, EffectRenderContext.m4369h().mo14188b(this.f4000y, this.f4001z, this.f3946A, this.f3947B));
                        } else {
                            this.f3948C = SurfaceTextureBitmap.m6365a(this.f3980b, this.f3951F, this.f3950E, i2, i, EffectRenderContext.m4369h().mo14188b(this.f4000y, this.f4001z, this.f3946A, this.f3947B));
                        }
                    }
                } else if (Build.VERSION.SDK_INT >= 29) {
                    this.f3948C = SurfaceTextureBitmap.m6366a(this.f3981c, this.f3951F, this.f3950E, i2, i, EffectRenderContext.m4369h().mo14188b(this.f4000y, this.f4001z, this.f3946A, this.f3947B));
                } else {
                    this.f3948C = SurfaceTextureBitmap.m6365a(this.f3980b, this.f3951F, this.f3950E, i2, i, EffectRenderContext.m4369h().mo14188b(this.f4000y, this.f4001z, this.f3946A, this.f3947B));
                }
            }
        }
    }

    public void setSurfaceTextureBitmap(int i, int i2, boolean z, boolean z2) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2), new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)}, this, f3942a, false, 432, new Class[]{Integer.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            setSurfaceTextureBitmap(i, i2, z2);
            if (z) {
                this.f3948C = m4615a(this.f3948C);
            }
        }
    }

    /* renamed from: a */
    public static Bitmap m4615a(Bitmap bitmap) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap}, (Object) null, f3942a, true, 433, new Class[]{Bitmap.class}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        Canvas canvas = new Canvas();
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        canvas.setBitmap(createBitmap);
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.reset();
        matrix.postRotate(180.0f, (float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2));
        matrix.postScale(-1.0f, 1.0f);
        matrix.postTranslate((float) bitmap.getWidth(), 0.0f);
        canvas.drawBitmap(bitmap, matrix, (Paint) null);
        bitmap.recycle();
        return createBitmap;
    }

    public void setRenderType(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f3942a, false, 434, new Class[]{String.class}, Void.TYPE).isSupported) {
            this.f3996u = this.f3952G.mo14330d(this.f3952G.mo14321a(str));
            Log.i("MzVideoSurfaceView", "setRenderType   mRender :" + this.f3996u.mo14046c().mo14345d());
            if (this.f3979ak != null) {
                this.f3979ak.mo14059a(str);
            }
        }
    }

    public void setRender(BaseRender aVar) {
        if (!PatchProxy.proxy(new Object[]{aVar}, this, f3942a, false, 435, new Class[]{BaseRender.class}, Void.TYPE).isSupported) {
            Log.i("MzVideoSurfaceView", "setRender   mRender " + aVar);
            this.f3996u = aVar;
        }
    }

    public int getViewWidth() {
        return this.f3997v;
    }

    public int getViewHeight() {
        return this.f3998w;
    }

    public void setViewAlpha(float f) {
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f3942a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 436, new Class[]{Float.TYPE}, Void.TYPE).isSupported) {
            setAlpha(f);
        }
    }

    public void setShowBitmap(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f3942a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 437, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            Log.v("MzVideoSurfaceView", "setShowBitmap:" + z);
            this.f3967V = z;
            if (!this.f3967V) {
                synchronized (this.f3960O) {
                    if (this.f3963R != null) {
                        this.f3963R.recycle();
                        this.f3963R = null;
                    }
                }
            }
        }
    }

    public void setPreviewBitmap(Bitmap bitmap, int i, int i2) {
        if (!PatchProxy.proxy(new Object[]{bitmap, new Integer(i), new Integer(i2)}, this, f3942a, false, 438, new Class[]{Bitmap.class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            synchronized (this.f3960O) {
                if (this.f3963R != null && !this.f3963R.isRecycled()) {
                    this.f3963R.recycle();
                }
                this.f3963R = bitmap;
                this.f3961P = i;
                this.f3962Q = i2;
            }
            if (this.f3979ak != null) {
                this.f3979ak.mo14055a(i, i2);
            }
        }
    }

    /* renamed from: a */
    public int mo14098a(byte[] bArr, int[] iArr, int[] iArr2) {
        int a;
        ChangeQuickRedirect changeQuickRedirect = f3942a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bArr, iArr, iArr2}, this, changeQuickRedirect, false, 440, new Class[]{byte[].class, int[].class, int[].class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        synchronized (this.f3982d) {
            if (!SurfaceTextureBitmap.m6369b()) {
                SurfaceTextureBitmap.m6368a(true);
            }
            a = SurfaceTextureBitmap.m6362a(this.f3980b, bArr, iArr, iArr2, EffectRenderContext.m4369h().mo14188b(this.f4000y, this.f4001z, this.f3946A, this.f3947B));
        }
        return a;
    }

    public void setCleanScreen(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f3942a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 441, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            Log.i("MzVideoSurfaceView", "setCleanScreen: " + z);
            this.f3957L = z;
            if (this.f3957L) {
                this.f3995t.m4692e();
            }
        }
    }

    /* renamed from: n */
    public void mo14280n() {
        if (!PatchProxy.proxy(new Object[0], this, f3942a, false, 442, new Class[0], Void.TYPE).isSupported) {
            this.f3995t.m4694f();
        }
    }

    /* renamed from: a */
    public void mo14270a(Surface surface) {
        if (!PatchProxy.proxy(new Object[]{surface}, this, f3942a, false, 443, new Class[]{Surface.class}, Void.TYPE).isSupported && this.f3979ak != null) {
            this.f3979ak.mo14057a(surface);
        }
    }

    /* renamed from: b */
    public void mo14272b(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f3942a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 444, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            this.f3978aj = true;
            if (this.f3979ak != null) {
                this.f3979ak.mo14063b(i, i2);
            }
        }
    }

    /* renamed from: o */
    public void mo14281o() {
        if (!PatchProxy.proxy(new Object[0], this, f3942a, false, 445, new Class[0], Void.TYPE).isSupported) {
            this.f3978aj = false;
            if (this.f3979ak != null) {
                this.f3979ak.mo14065d();
            }
            setCleanScreen(true);
        }
    }

    /* renamed from: com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView$a */
    private class C1182a implements MediaRecordRender.C1156b {

        /* renamed from: a */
        public static ChangeQuickRedirect f4002a;

        /* renamed from: c */
        private HandlerThread f4004c;

        /* renamed from: d */
        private MzVideoSurfaceView f4005d;

        /* renamed from: e */
        private Handler f4006e;

        /* renamed from: f */
        private SurfaceManager f4007f;

        /* renamed from: g */
        private boolean f4008g;

        private C1182a() {
            this.f4007f = null;
            this.f4008g = true;
        }

        /* renamed from: a */
        public void mo14291a(MzVideoSurfaceView mzVideoSurfaceView) {
            if (!PatchProxy.proxy(new Object[]{mzVideoSurfaceView}, this, f4002a, false, 446, new Class[]{MzVideoSurfaceView.class}, Void.TYPE).isSupported) {
                Log.d("MzVideoSurfaceView", "initThread");
                this.f4005d = mzVideoSurfaceView;
                this.f4004c = new HandlerThread("SurfaceView Renderer Thread");
                this.f4004c.start();
                this.f4006e = new Handler(this.f4004c.getLooper()) {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f4009a;

                    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
                        return;
                     */
                    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void handleMessage(android.os.Message r9) {
                        /*
                            r8 = this;
                            r0 = 1
                            java.lang.Object[] r1 = new java.lang.Object[r0]
                            r2 = 0
                            r1[r2] = r9
                            com.meizu.savior.ChangeQuickRedirect r3 = f4009a
                            java.lang.Class[] r6 = new java.lang.Class[r0]
                            java.lang.Class<android.os.Message> r0 = android.os.Message.class
                            r6[r2] = r0
                            java.lang.Class r7 = java.lang.Void.TYPE
                            r4 = 0
                            r5 = 464(0x1d0, float:6.5E-43)
                            r2 = r8
                            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                            boolean r0 = r0.isSupported
                            if (r0 == 0) goto L_0x001d
                            return
                        L_0x001d:
                            int r9 = r9.what
                            switch(r9) {
                                case 0: goto L_0x008e;
                                case 1: goto L_0x0088;
                                case 2: goto L_0x0082;
                                case 3: goto L_0x0022;
                                case 4: goto L_0x007c;
                                case 5: goto L_0x0076;
                                case 6: goto L_0x006c;
                                case 7: goto L_0x0023;
                                default: goto L_0x0022;
                            }
                        L_0x0022:
                            return
                        L_0x0023:
                            int r9 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
                            r0 = 29
                            if (r9 < r0) goto L_0x0049
                            com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView$a r9 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.C1182a.this     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
                            com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r9 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
                            com.meizu.imageproc.SurfaceTextureWrapper r9 = r9.f3981c     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
                            if (r9 == 0) goto L_0x006b
                            com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView$a r9 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.C1182a.this     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
                            com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r9 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
                            boolean r9 = r9.f3990o     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
                            if (r9 == 0) goto L_0x006b
                            com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView$a r9 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.C1182a.this     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
                            com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r9 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
                            com.meizu.imageproc.SurfaceTextureWrapper r9 = r9.f3981c     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
                            r9.updateTexImage()     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
                            goto L_0x006b
                        L_0x0049:
                            com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView$a r9 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.C1182a.this     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
                            com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r9 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
                            android.graphics.SurfaceTexture r9 = r9.f3980b     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
                            if (r9 == 0) goto L_0x006b
                            com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView$a r9 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.C1182a.this     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
                            com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r9 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
                            boolean r9 = r9.f3990o     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
                            if (r9 == 0) goto L_0x006b
                            com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView$a r9 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.C1182a.this     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
                            com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r9 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
                            android.graphics.SurfaceTexture r9 = r9.f3980b     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
                            r9.updateTexImage()     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
                            goto L_0x006b
                        L_0x0069:
                            r9 = move-exception
                            throw r9
                        L_0x006b:
                            return
                        L_0x006c:
                            r9 = 16384(0x4000, float:2.2959E-41)
                            android.opengl.GLES20.glClear(r9)
                            r9 = 0
                            android.opengl.GLES20.glClearColor(r9, r9, r9, r9)
                            return
                        L_0x0076:
                            com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView$a r9 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.C1182a.this
                            r9.m4702j()
                            goto L_0x0088
                        L_0x007c:
                            com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView$a r9 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.C1182a.this
                            r9.m4700i()
                            return
                        L_0x0082:
                            com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView$a r9 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.C1182a.this
                            r9.m4698h()
                            return
                        L_0x0088:
                            com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView$a r9 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.C1182a.this
                            r9.m4704k()
                            return
                        L_0x008e:
                            com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView$a r9 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.C1182a.this
                            r9.m4696g()
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.C1182a.C11831.handleMessage(android.os.Message):void");
                    }
                };
                this.f4006e.sendEmptyMessage(0);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m4686b() {
            if (!PatchProxy.proxy(new Object[0], this, f4002a, false, 447, new Class[0], Void.TYPE).isSupported && this.f4006e != null) {
                this.f4006e.sendEmptyMessage(5);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public void m4688c() {
            if (!PatchProxy.proxy(new Object[0], this, f4002a, false, 448, new Class[0], Void.TYPE).isSupported && this.f4006e != null) {
                this.f4006e.sendEmptyMessage(1);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: d */
        public void m4690d() {
            if (!PatchProxy.proxy(new Object[0], this, f4002a, false, 450, new Class[0], Void.TYPE).isSupported) {
                if (this.f4006e != null) {
                    this.f4006e.sendEmptyMessage(2);
                }
                if (MzVideoSurfaceView.this.f3979ak != null) {
                    MzVideoSurfaceView.this.f3979ak.mo14064c();
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: e */
        public void m4692e() {
            if (!PatchProxy.proxy(new Object[0], this, f4002a, false, 451, new Class[0], Void.TYPE).isSupported && this.f4006e != null) {
                this.f4006e.sendEmptyMessage(6);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: f */
        public void m4694f() {
            if (!PatchProxy.proxy(new Object[0], this, f4002a, false, 452, new Class[0], Void.TYPE).isSupported && this.f4006e != null) {
                this.f4006e.sendEmptyMessage(7);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: g */
        public void m4696g() {
            if (!PatchProxy.proxy(new Object[0], this, f4002a, false, 454, new Class[0], Void.TYPE).isSupported) {
                Log.d("MzVideoSurfaceView", "initEGL");
                this.f4007f = new SurfaceManager(true);
                this.f4007f.mo14093a(EffectRenderContext.m4369h().mo14168M());
                SurfaceHolder holder = this.f4005d.getHolder();
                if (holder == null || !this.f4005d.f3953H) {
                    Log.d("MzVideoSurfaceView", "holder null or surface not be created");
                } else if (holder.getSurface() == null || holder.getSurface().isValid()) {
                    this.f4007f.mo14095a(holder);
                    boolean unused = MzVideoSurfaceView.this.f3959N = false;
                    MediaRecordRender unused2 = MzVideoSurfaceView.this.f3979ak = new MediaRecordRender();
                    MzVideoSurfaceView.this.f3979ak.mo14056a(EffectRenderContext.m4369h().mo14168M(), (MediaRecordRender.C1156b) this);
                } else {
                    Log.d("MzVideoSurfaceView", "holder surface not valid");
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: h */
        public void m4698h() {
            if (!PatchProxy.proxy(new Object[0], this, f4002a, false, 455, new Class[0], Void.TYPE).isSupported) {
                Log.i("MzVideoSurfaceView", "onDestroyGL");
                m4700i();
                if (MzVideoSurfaceView.this.f3948C != null && !MzVideoSurfaceView.this.f3948C.isRecycled()) {
                    MzVideoSurfaceView.this.f3948C.recycle();
                    Bitmap unused = MzVideoSurfaceView.this.f3948C = null;
                }
                if (this.f4007f != null) {
                    this.f4007f.mo14097c();
                }
                this.f4004c.getLooper().quit();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: i */
        public void m4700i() {
            if (!PatchProxy.proxy(new Object[0], this, f4002a, false, 456, new Class[0], Void.TYPE).isSupported) {
                synchronized (MzVideoSurfaceView.this.f3982d) {
                    Log.i("MzVideoSurfaceView", "onRelease");
                    if (MzVideoSurfaceView.this.f3989n != null) {
                        Log.i("MzVideoSurfaceView", " recycle mPreviewTexture id " + MzVideoSurfaceView.this.f3989n.mo14028a());
                        MzVideoSurfaceView.this.f3989n.mo14032c();
                        GLTexture unused = MzVideoSurfaceView.this.f3989n = null;
                    }
                    boolean unused2 = MzVideoSurfaceView.this.f3957L = false;
                    MzVideoSurfaceView.this.mo14118j();
                    if (MzVideoSurfaceView.this.f3989n != null) {
                        Log.i("MzVideoSurfaceView", " recycle mPreviewTexture id " + MzVideoSurfaceView.this.f3989n.mo14028a());
                        MzVideoSurfaceView.this.f3989n.mo14032c();
                        GLTexture unused3 = MzVideoSurfaceView.this.f3989n = null;
                    }
                    EffectRenderContext.m4369h().mo14161F();
                    EffectRenderContext.m4369h().mo14160E();
                    EffectRenderContext.m4369h().mo14163H();
                    if (MzVideoSurfaceView.this.f3996u != null) {
                        BaseRender unused4 = MzVideoSurfaceView.this.f3996u = null;
                    }
                    if (MzVideoSurfaceView.this.f3964S != null) {
                        MzVideoSurfaceView.this.f3964S.mo14305a(MzVideoSurfaceView.this.f3966U);
                        MzVideoSurfaceView.this.f3964S.mo14313h();
                        DepthRenderProgram unused5 = MzVideoSurfaceView.this.f3964S = null;
                        int unused6 = MzVideoSurfaceView.this.f3966U = -1;
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0066, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0086, code lost:
            com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.m4628c(r8.f4003b, false);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x008b, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bf, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00df, code lost:
            com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.m4628c(r8.f4003b, false);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x00e4, code lost:
            throw r2;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [B:21:0x006b, B:38:0x00c4] */
        /* renamed from: j */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void m4702j() {
            /*
                r8 = this;
                r0 = 0
                java.lang.Object[] r1 = new java.lang.Object[r0]
                com.meizu.savior.ChangeQuickRedirect r3 = f4002a
                java.lang.Class[] r6 = new java.lang.Class[r0]
                java.lang.Class r7 = java.lang.Void.TYPE
                r4 = 0
                r5 = 458(0x1ca, float:6.42E-43)
                r2 = r8
                com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                boolean r1 = r1.isSupported
                if (r1 == 0) goto L_0x0016
                return
            L_0x0016:
                java.lang.String r1 = "MzVideoSurfaceView"
                java.lang.String r2 = "detachTex"
                android.util.Log.i(r1, r2)
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r1 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this
                java.lang.Object r1 = r1.f3982d
                monitor-enter(r1)
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x00e7 }
                boolean r2 = r2.f3990o     // Catch:{ all -> 0x00e7 }
                if (r2 == 0) goto L_0x00e5
                int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00e7 }
                r3 = 29
                if (r2 < r3) goto L_0x008c
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x00e7 }
                com.meizu.imageproc.SurfaceTextureWrapper r2 = r2.f3981c     // Catch:{ all -> 0x00e7 }
                if (r2 == 0) goto L_0x00e5
                java.lang.String r2 = "MzVideoSurfaceView"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0068 }
                r3.<init>()     // Catch:{ Exception -> 0x0068 }
                java.lang.String r4 = "detachTex:"
                r3.append(r4)     // Catch:{ Exception -> 0x0068 }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ Exception -> 0x0068 }
                com.meizu.imageproc.SurfaceTextureWrapper r4 = r4.f3981c     // Catch:{ Exception -> 0x0068 }
                r3.append(r4)     // Catch:{ Exception -> 0x0068 }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0068 }
                android.util.Log.i(r2, r3)     // Catch:{ Exception -> 0x0068 }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ Exception -> 0x0068 }
                com.meizu.imageproc.SurfaceTextureWrapper r2 = r2.f3981c     // Catch:{ Exception -> 0x0068 }
                r2.detachFromGLContext()     // Catch:{ Exception -> 0x0068 }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x00e7 }
            L_0x0061:
                boolean unused = r2.f3990o = r0     // Catch:{ all -> 0x00e7 }
                goto L_0x00e5
            L_0x0066:
                r2 = move-exception
                goto L_0x0086
            L_0x0068:
                r2 = move-exception
                java.lang.String r3 = "MzVideoSurfaceView"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0066 }
                r4.<init>()     // Catch:{ all -> 0x0066 }
                java.lang.String r5 = "error:"
                r4.append(r5)     // Catch:{ all -> 0x0066 }
                java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x0066 }
                r4.append(r2)     // Catch:{ all -> 0x0066 }
                java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x0066 }
                android.util.Log.e(r3, r2)     // Catch:{ all -> 0x0066 }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x00e7 }
                goto L_0x0061
            L_0x0086:
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x00e7 }
                boolean unused = r3.f3990o = r0     // Catch:{ all -> 0x00e7 }
                throw r2     // Catch:{ all -> 0x00e7 }
            L_0x008c:
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x00e7 }
                android.graphics.SurfaceTexture r2 = r2.f3980b     // Catch:{ all -> 0x00e7 }
                if (r2 == 0) goto L_0x00e5
                java.lang.String r2 = "MzVideoSurfaceView"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c1 }
                r3.<init>()     // Catch:{ Exception -> 0x00c1 }
                java.lang.String r4 = "detachTex:"
                r3.append(r4)     // Catch:{ Exception -> 0x00c1 }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r4 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ Exception -> 0x00c1 }
                android.graphics.SurfaceTexture r4 = r4.f3980b     // Catch:{ Exception -> 0x00c1 }
                r3.append(r4)     // Catch:{ Exception -> 0x00c1 }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00c1 }
                android.util.Log.i(r2, r3)     // Catch:{ Exception -> 0x00c1 }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ Exception -> 0x00c1 }
                android.graphics.SurfaceTexture r2 = r2.f3980b     // Catch:{ Exception -> 0x00c1 }
                r2.detachFromGLContext()     // Catch:{ Exception -> 0x00c1 }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x00e7 }
            L_0x00bb:
                boolean unused = r2.f3990o = r0     // Catch:{ all -> 0x00e7 }
                goto L_0x00e5
            L_0x00bf:
                r2 = move-exception
                goto L_0x00df
            L_0x00c1:
                r2 = move-exception
                java.lang.String r3 = "MzVideoSurfaceView"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bf }
                r4.<init>()     // Catch:{ all -> 0x00bf }
                java.lang.String r5 = "error:"
                r4.append(r5)     // Catch:{ all -> 0x00bf }
                java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x00bf }
                r4.append(r2)     // Catch:{ all -> 0x00bf }
                java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x00bf }
                android.util.Log.e(r3, r2)     // Catch:{ all -> 0x00bf }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x00e7 }
                goto L_0x00bb
            L_0x00df:
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x00e7 }
                boolean unused = r3.f3990o = r0     // Catch:{ all -> 0x00e7 }
                throw r2     // Catch:{ all -> 0x00e7 }
            L_0x00e5:
                monitor-exit(r1)     // Catch:{ all -> 0x00e7 }
                return
            L_0x00e7:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x00e7 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.C1182a.m4702j():void");
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:162:0x03fa, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a9, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x01dc, code lost:
            return;
         */
        /* renamed from: k */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void m4704k() {
            /*
                r9 = this;
                r0 = 0
                java.lang.Object[] r1 = new java.lang.Object[r0]
                com.meizu.savior.ChangeQuickRedirect r3 = f4002a
                java.lang.Class[] r6 = new java.lang.Class[r0]
                java.lang.Class r7 = java.lang.Void.TYPE
                r4 = 0
                r5 = 459(0x1cb, float:6.43E-43)
                r2 = r9
                com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                boolean r1 = r1.isSupported
                if (r1 == 0) goto L_0x0016
                return
            L_0x0016:
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r1 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this
                java.lang.Object r1 = r1.f3982d
                monitor-enter(r1)
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                boolean r2 = r2.f3959N     // Catch:{ all -> 0x03fb }
                r3 = 16384(0x4000, float:2.2959E-41)
                r4 = 0
                if (r2 == 0) goto L_0x006c
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = r9.f4005d     // Catch:{ all -> 0x03fb }
                android.view.SurfaceHolder r2 = r2.getHolder()     // Catch:{ all -> 0x03fb }
                if (r2 == 0) goto L_0x0063
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r5 = r9.f4005d     // Catch:{ all -> 0x03fb }
                boolean r5 = r5.f3953H     // Catch:{ all -> 0x03fb }
                if (r5 != 0) goto L_0x0039
                goto L_0x0063
            L_0x0039:
                android.view.Surface r5 = r2.getSurface()     // Catch:{ all -> 0x03fb }
                if (r5 == 0) goto L_0x0052
                android.view.Surface r5 = r2.getSurface()     // Catch:{ all -> 0x03fb }
                boolean r5 = r5.isValid()     // Catch:{ all -> 0x03fb }
                if (r5 != 0) goto L_0x0052
                java.lang.String r0 = "MzVideoSurfaceView"
                java.lang.String r2 = "holder surface not valid"
                android.util.Log.d(r0, r2)     // Catch:{ all -> 0x03fb }
                monitor-exit(r1)     // Catch:{ all -> 0x03fb }
                return
            L_0x0052:
                com.meizu.camera.effectlib.effects.filters.b r5 = r9.f4007f     // Catch:{ all -> 0x03fb }
                r5.mo14095a((android.view.SurfaceHolder) r2)     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                boolean unused = r2.f3959N = r0     // Catch:{ all -> 0x03fb }
                android.opengl.GLES20.glClear(r3)     // Catch:{ all -> 0x03fb }
                android.opengl.GLES20.glClearColor(r4, r4, r4, r4)     // Catch:{ all -> 0x03fb }
                goto L_0x006c
            L_0x0063:
                java.lang.String r0 = "MzVideoSurfaceView"
                java.lang.String r2 = "holder null or surface not be created"
                android.util.Log.d(r0, r2)     // Catch:{ all -> 0x03fb }
                monitor-exit(r1)     // Catch:{ all -> 0x03fb }
                return
            L_0x006c:
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.b r2 = r2.f3952G     // Catch:{ all -> 0x03fb }
                if (r2 != 0) goto L_0x0076
                monitor-exit(r1)     // Catch:{ all -> 0x03fb }
                return
            L_0x0076:
                int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x03fb }
                r5 = 29
                r6 = 36197(0x8d65, float:5.0723E-41)
                r7 = 1
                if (r2 < r5) goto L_0x01b3
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                com.meizu.imageproc.SurfaceTextureWrapper r2 = r2.f3981c     // Catch:{ all -> 0x03fb }
                if (r2 == 0) goto L_0x02e4
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                boolean r2 = r2.f3956K     // Catch:{ all -> 0x03fb }
                if (r2 == 0) goto L_0x00aa
                java.lang.String r0 = "MzVideoSurfaceView"
                java.lang.String r2 = "app has been background ,not to draw ,return "
                android.util.Log.i(r0, r2)     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                boolean r0 = r0.f3990o     // Catch:{ all -> 0x03fb }
                if (r0 == 0) goto L_0x00a8
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                com.meizu.imageproc.SurfaceTextureWrapper r0 = r0.f3981c     // Catch:{ all -> 0x03fb }
                r0.updateTexImage()     // Catch:{ all -> 0x03fb }
            L_0x00a8:
                monitor-exit(r1)     // Catch:{ all -> 0x03fb }
                return
            L_0x00aa:
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                boolean r2 = r2.f3958M     // Catch:{ all -> 0x03fb }
                if (r2 != 0) goto L_0x00bd
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                com.meizu.imageproc.SurfaceTextureWrapper r0 = r0.f3981c     // Catch:{ all -> 0x03fb }
                r0.updateTexImage()     // Catch:{ all -> 0x03fb }
                monitor-exit(r1)     // Catch:{ all -> 0x03fb }
                return
            L_0x00bd:
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.a.c r2 = r2.f3989n     // Catch:{ all -> 0x03fb }
                if (r2 != 0) goto L_0x0129
                int[] r2 = new int[r7]     // Catch:{ all -> 0x03fb }
                int r5 = r2.length     // Catch:{ all -> 0x03fb }
                android.opengl.GLES20.glGenTextures(r5, r2, r0)     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r5 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.a.c r8 = new com.meizu.camera.effectlib.effects.a.c     // Catch:{ all -> 0x03fb }
                r2 = r2[r0]     // Catch:{ all -> 0x03fb }
                r8.<init>(r2, r6)     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.p058a.GLTexture unused = r5.f3989n = r8     // Catch:{ all -> 0x03fb }
                java.lang.String r2 = "MzVideoSurfaceView"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x03fb }
                r5.<init>()     // Catch:{ all -> 0x03fb }
                java.lang.String r6 = "onDraw create id "
                r5.append(r6)     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r6 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.a.c r6 = r6.f3989n     // Catch:{ all -> 0x03fb }
                int r6 = r6.mo14028a()     // Catch:{ all -> 0x03fb }
                r5.append(r6)     // Catch:{ all -> 0x03fb }
                java.lang.String r6 = " mPreviewTexture "
                r5.append(r6)     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r6 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.a.c r6 = r6.f3989n     // Catch:{ all -> 0x03fb }
                r5.append(r6)     // Catch:{ all -> 0x03fb }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x03fb }
                android.util.Log.i(r2, r5)     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.b.e r2 = r2.f3979ak     // Catch:{ all -> 0x03fb }
                if (r2 == 0) goto L_0x011c
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.b.e r2 = r2.f3979ak     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r5 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.a.c r5 = r5.f3989n     // Catch:{ all -> 0x03fb }
                r2.mo14058a((com.meizu.camera.effectlib.effects.p058a.GLTexture) r5)     // Catch:{ all -> 0x03fb }
            L_0x011c:
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r5 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.a.c r5 = r5.f3989n     // Catch:{ all -> 0x03fb }
                r2.mo14192b((com.meizu.camera.effectlib.effects.p058a.GLTexture) r5)     // Catch:{ all -> 0x03fb }
            L_0x0129:
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                boolean r2 = r2.f3990o     // Catch:{ all -> 0x03fb }
                if (r2 != 0) goto L_0x0199
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                com.meizu.imageproc.SurfaceTextureWrapper r0 = r0.f3981c     // Catch:{ all -> 0x03fb }
                if (r0 != 0) goto L_0x013e
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                r0.mo14108f()     // Catch:{ all -> 0x03fb }
            L_0x013e:
                java.lang.String r0 = "MzVideoSurfaceView"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x016e }
                r2.<init>()     // Catch:{ Exception -> 0x016e }
                java.lang.String r3 = "attachToGLContext:"
                r2.append(r3)     // Catch:{ Exception -> 0x016e }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ Exception -> 0x016e }
                com.meizu.imageproc.SurfaceTextureWrapper r3 = r3.f3981c     // Catch:{ Exception -> 0x016e }
                r2.append(r3)     // Catch:{ Exception -> 0x016e }
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x016e }
                android.util.Log.i(r0, r2)     // Catch:{ Exception -> 0x016e }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ Exception -> 0x016e }
                com.meizu.imageproc.SurfaceTextureWrapper r0 = r0.f3981c     // Catch:{ Exception -> 0x016e }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ Exception -> 0x016e }
                com.meizu.camera.effectlib.effects.a.c r2 = r2.f3989n     // Catch:{ Exception -> 0x016e }
                int r2 = r2.mo14028a()     // Catch:{ Exception -> 0x016e }
                r0.attachToGLContext(r2)     // Catch:{ Exception -> 0x016e }
                goto L_0x0189
            L_0x016e:
                r0 = move-exception
                java.lang.String r2 = "MzVideoSurfaceView"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x03fb }
                r3.<init>()     // Catch:{ all -> 0x03fb }
                java.lang.String r4 = "error:"
                r3.append(r4)     // Catch:{ all -> 0x03fb }
                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x03fb }
                r3.append(r0)     // Catch:{ all -> 0x03fb }
                java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x03fb }
                android.util.Log.e(r2, r0)     // Catch:{ all -> 0x03fb }
            L_0x0189:
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                com.meizu.imageproc.SurfaceTextureWrapper r0 = r0.f3981c     // Catch:{ all -> 0x03fb }
                r0.updateTexImage()     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                boolean unused = r0.f3990o = r7     // Catch:{ all -> 0x03fb }
                monitor-exit(r1)     // Catch:{ all -> 0x03fb }
                return
            L_0x0199:
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                com.meizu.imageproc.SurfaceTextureWrapper r2 = r2.f3981c     // Catch:{ all -> 0x03fb }
                r2.updateTexImage()     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                com.meizu.imageproc.SurfaceTextureWrapper r2 = r2.f3981c     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r5 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                float[] r5 = r5.f3993r     // Catch:{ all -> 0x03fb }
                r2.getTransformMatrix(r5)     // Catch:{ all -> 0x03fb }
                goto L_0x02e4
            L_0x01b3:
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                android.graphics.SurfaceTexture r2 = r2.f3980b     // Catch:{ all -> 0x03fb }
                if (r2 == 0) goto L_0x02e4
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                boolean r2 = r2.f3956K     // Catch:{ all -> 0x03fb }
                if (r2 == 0) goto L_0x01dd
                java.lang.String r0 = "MzVideoSurfaceView"
                java.lang.String r2 = "app has been background ,not to draw ,return "
                android.util.Log.i(r0, r2)     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                boolean r0 = r0.f3990o     // Catch:{ all -> 0x03fb }
                if (r0 == 0) goto L_0x01db
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                android.graphics.SurfaceTexture r0 = r0.f3980b     // Catch:{ all -> 0x03fb }
                r0.updateTexImage()     // Catch:{ all -> 0x03fb }
            L_0x01db:
                monitor-exit(r1)     // Catch:{ all -> 0x03fb }
                return
            L_0x01dd:
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                boolean r2 = r2.f3958M     // Catch:{ all -> 0x03fb }
                if (r2 != 0) goto L_0x01f0
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                android.graphics.SurfaceTexture r0 = r0.f3980b     // Catch:{ all -> 0x03fb }
                r0.updateTexImage()     // Catch:{ all -> 0x03fb }
                monitor-exit(r1)     // Catch:{ all -> 0x03fb }
                return
            L_0x01f0:
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.a.c r2 = r2.f3989n     // Catch:{ all -> 0x03fb }
                if (r2 != 0) goto L_0x025c
                int[] r2 = new int[r7]     // Catch:{ all -> 0x03fb }
                int r5 = r2.length     // Catch:{ all -> 0x03fb }
                android.opengl.GLES20.glGenTextures(r5, r2, r0)     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r5 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.a.c r8 = new com.meizu.camera.effectlib.effects.a.c     // Catch:{ all -> 0x03fb }
                r2 = r2[r0]     // Catch:{ all -> 0x03fb }
                r8.<init>(r2, r6)     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.p058a.GLTexture unused = r5.f3989n = r8     // Catch:{ all -> 0x03fb }
                java.lang.String r2 = "MzVideoSurfaceView"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x03fb }
                r5.<init>()     // Catch:{ all -> 0x03fb }
                java.lang.String r6 = "onDraw create id "
                r5.append(r6)     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r6 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.a.c r6 = r6.f3989n     // Catch:{ all -> 0x03fb }
                int r6 = r6.mo14028a()     // Catch:{ all -> 0x03fb }
                r5.append(r6)     // Catch:{ all -> 0x03fb }
                java.lang.String r6 = " mPreviewTexture "
                r5.append(r6)     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r6 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.a.c r6 = r6.f3989n     // Catch:{ all -> 0x03fb }
                r5.append(r6)     // Catch:{ all -> 0x03fb }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x03fb }
                android.util.Log.i(r2, r5)     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.b.e r2 = r2.f3979ak     // Catch:{ all -> 0x03fb }
                if (r2 == 0) goto L_0x024f
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.b.e r2 = r2.f3979ak     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r5 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.a.c r5 = r5.f3989n     // Catch:{ all -> 0x03fb }
                r2.mo14058a((com.meizu.camera.effectlib.effects.p058a.GLTexture) r5)     // Catch:{ all -> 0x03fb }
            L_0x024f:
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r5 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.a.c r5 = r5.f3989n     // Catch:{ all -> 0x03fb }
                r2.mo14192b((com.meizu.camera.effectlib.effects.p058a.GLTexture) r5)     // Catch:{ all -> 0x03fb }
            L_0x025c:
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                boolean r2 = r2.f3990o     // Catch:{ all -> 0x03fb }
                if (r2 != 0) goto L_0x02cc
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                android.graphics.SurfaceTexture r0 = r0.f3980b     // Catch:{ all -> 0x03fb }
                if (r0 != 0) goto L_0x0271
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                r0.mo14108f()     // Catch:{ all -> 0x03fb }
            L_0x0271:
                java.lang.String r0 = "MzVideoSurfaceView"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a1 }
                r2.<init>()     // Catch:{ Exception -> 0x02a1 }
                java.lang.String r3 = "attachToGLContext:"
                r2.append(r3)     // Catch:{ Exception -> 0x02a1 }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ Exception -> 0x02a1 }
                android.graphics.SurfaceTexture r3 = r3.f3980b     // Catch:{ Exception -> 0x02a1 }
                r2.append(r3)     // Catch:{ Exception -> 0x02a1 }
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x02a1 }
                android.util.Log.i(r0, r2)     // Catch:{ Exception -> 0x02a1 }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ Exception -> 0x02a1 }
                android.graphics.SurfaceTexture r0 = r0.f3980b     // Catch:{ Exception -> 0x02a1 }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ Exception -> 0x02a1 }
                com.meizu.camera.effectlib.effects.a.c r2 = r2.f3989n     // Catch:{ Exception -> 0x02a1 }
                int r2 = r2.mo14028a()     // Catch:{ Exception -> 0x02a1 }
                r0.attachToGLContext(r2)     // Catch:{ Exception -> 0x02a1 }
                goto L_0x02bc
            L_0x02a1:
                r0 = move-exception
                java.lang.String r2 = "MzVideoSurfaceView"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x03fb }
                r3.<init>()     // Catch:{ all -> 0x03fb }
                java.lang.String r4 = "error:"
                r3.append(r4)     // Catch:{ all -> 0x03fb }
                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x03fb }
                r3.append(r0)     // Catch:{ all -> 0x03fb }
                java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x03fb }
                android.util.Log.e(r2, r0)     // Catch:{ all -> 0x03fb }
            L_0x02bc:
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                android.graphics.SurfaceTexture r0 = r0.f3980b     // Catch:{ all -> 0x03fb }
                r0.updateTexImage()     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                boolean unused = r0.f3990o = r7     // Catch:{ all -> 0x03fb }
                monitor-exit(r1)     // Catch:{ all -> 0x03fb }
                return
            L_0x02cc:
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                android.graphics.SurfaceTexture r2 = r2.f3980b     // Catch:{ all -> 0x03fb }
                r2.updateTexImage()     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                android.graphics.SurfaceTexture r2 = r2.f3980b     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r5 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                float[] r5 = r5.f3993r     // Catch:{ all -> 0x03fb }
                r2.getTransformMatrix(r5)     // Catch:{ all -> 0x03fb }
            L_0x02e4:
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                float[] r2 = r2.f3993r     // Catch:{ all -> 0x03fb }
                boolean r2 = com.meizu.camera.effectlib.effects.p058a.GLES20Utils.m4018a((float[]) r2)     // Catch:{ all -> 0x03fb }
                if (r2 != 0) goto L_0x0313
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                float[] r2 = r2.f3993r     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r5 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                float[] r5 = r5.f3992q     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r6 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                float[] r6 = r6.f3992q     // Catch:{ all -> 0x03fb }
                int r6 = r6.length     // Catch:{ all -> 0x03fb }
                java.lang.System.arraycopy(r2, r0, r5, r0, r6)     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r5 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                float[] r5 = r5.f3992q     // Catch:{ all -> 0x03fb }
                r2.mo14187a((float[]) r5)     // Catch:{ all -> 0x03fb }
            L_0x0313:
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                boolean r2 = r2.f3967V     // Catch:{ all -> 0x03fb }
                if (r2 == 0) goto L_0x03a4
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.b.a r2 = r2.f3996u     // Catch:{ all -> 0x03fb }
                if (r2 == 0) goto L_0x0385
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                android.graphics.SurfaceTexture r2 = r2.f3980b     // Catch:{ all -> 0x03fb }
                if (r2 != 0) goto L_0x0333
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                com.meizu.imageproc.SurfaceTextureWrapper r2 = r2.f3981c     // Catch:{ all -> 0x03fb }
                if (r2 == 0) goto L_0x0385
            L_0x0333:
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                boolean r2 = r2.f3953H     // Catch:{ all -> 0x03fb }
                if (r2 == 0) goto L_0x0385
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.a r2 = r2.f3964S     // Catch:{ all -> 0x03fb }
                if (r2 != 0) goto L_0x0359
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.a r5 = new com.meizu.camera.effectlib.effects.views.a     // Catch:{ all -> 0x03fb }
                r5.<init>()     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.DepthRenderProgram unused = r2.f3964S = r5     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.a r2 = r2.f3964S     // Catch:{ all -> 0x03fb }
                r2.mo14312g()     // Catch:{ all -> 0x03fb }
                r9.m4705l()     // Catch:{ all -> 0x03fb }
            L_0x0359:
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                java.lang.Object r2 = r2.f3960O     // Catch:{ all -> 0x03fb }
                monitor-enter(r2)     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r5 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x0382 }
                android.graphics.Bitmap r5 = r5.f3963R     // Catch:{ all -> 0x0382 }
                if (r5 == 0) goto L_0x0380
                android.opengl.GLES20.glClear(r3)     // Catch:{ all -> 0x0382 }
                android.opengl.GLES20.glClearColor(r4, r4, r4, r4)     // Catch:{ all -> 0x0382 }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r3 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x0382 }
                android.graphics.Bitmap r3 = r3.f3963R     // Catch:{ all -> 0x0382 }
                r9.m4683a((android.graphics.Bitmap) r3)     // Catch:{ all -> 0x0382 }
                com.meizu.camera.effectlib.effects.filters.b r3 = r9.f4007f     // Catch:{ all -> 0x0382 }
                if (r3 == 0) goto L_0x0380
                com.meizu.camera.effectlib.effects.filters.b r3 = r9.f4007f     // Catch:{ all -> 0x0382 }
                r3.mo14096b()     // Catch:{ all -> 0x0382 }
            L_0x0380:
                monitor-exit(r2)     // Catch:{ all -> 0x0382 }
                goto L_0x0385
            L_0x0382:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0382 }
                throw r0     // Catch:{ all -> 0x03fb }
            L_0x0385:
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                boolean r2 = r2.f3978aj     // Catch:{ all -> 0x03fb }
                if (r2 == 0) goto L_0x03f9
                monitor-enter(r9)     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03a1 }
                com.meizu.camera.effectlib.effects.b.e r2 = r2.f3979ak     // Catch:{ all -> 0x03a1 }
                if (r2 == 0) goto L_0x039f
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03a1 }
                com.meizu.camera.effectlib.effects.b.e r2 = r2.f3979ak     // Catch:{ all -> 0x03a1 }
                r2.mo14060a((boolean) r0)     // Catch:{ all -> 0x03a1 }
            L_0x039f:
                monitor-exit(r9)     // Catch:{ all -> 0x03a1 }
                goto L_0x03f9
            L_0x03a1:
                r0 = move-exception
                monitor-exit(r9)     // Catch:{ all -> 0x03a1 }
                throw r0     // Catch:{ all -> 0x03fb }
            L_0x03a4:
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = r9.f4005d     // Catch:{ all -> 0x03fb }
                int r2 = r2.getWidth()     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r3 = r9.f4005d     // Catch:{ all -> 0x03fb }
                int r3 = r3.getHeight()     // Catch:{ all -> 0x03fb }
                android.opengl.GLES20.glViewport(r0, r0, r2, r3)     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                float[] r0 = r0.f3993r     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                float[] r2 = r2.f3991p     // Catch:{ all -> 0x03fb }
                r9.m4685a(r0, r2)     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.filters.b r0 = r9.f4007f     // Catch:{ all -> 0x03fb }
                if (r0 == 0) goto L_0x03cb
                com.meizu.camera.effectlib.effects.filters.b r0 = r9.f4007f     // Catch:{ all -> 0x03fb }
                r0.mo14096b()     // Catch:{ all -> 0x03fb }
            L_0x03cb:
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03fb }
                boolean r0 = r0.f3978aj     // Catch:{ all -> 0x03fb }
                if (r0 == 0) goto L_0x03f9
                monitor-enter(r9)     // Catch:{ all -> 0x03fb }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03f6 }
                com.meizu.camera.effectlib.effects.b.e r0 = r0.f3979ak     // Catch:{ all -> 0x03f6 }
                if (r0 == 0) goto L_0x03f4
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03f6 }
                com.meizu.camera.effectlib.effects.b.e r0 = r0.f3979ak     // Catch:{ all -> 0x03f6 }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r2 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03f6 }
                float[] r2 = r2.f3993r     // Catch:{ all -> 0x03f6 }
                r0.mo14061a((float[]) r2)     // Catch:{ all -> 0x03f6 }
                com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView r0 = com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.this     // Catch:{ all -> 0x03f6 }
                com.meizu.camera.effectlib.effects.b.e r0 = r0.f3979ak     // Catch:{ all -> 0x03f6 }
                r0.mo14060a((boolean) r7)     // Catch:{ all -> 0x03f6 }
            L_0x03f4:
                monitor-exit(r9)     // Catch:{ all -> 0x03f6 }
                goto L_0x03f9
            L_0x03f6:
                r0 = move-exception
                monitor-exit(r9)     // Catch:{ all -> 0x03f6 }
                throw r0     // Catch:{ all -> 0x03fb }
            L_0x03f9:
                monitor-exit(r1)     // Catch:{ all -> 0x03fb }
                return
            L_0x03fb:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x03fb }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView.C1182a.m4704k():void");
        }

        /* renamed from: a */
        private void m4685a(float[] fArr, float[] fArr2) {
            if (!PatchProxy.proxy(new Object[]{fArr, fArr2}, this, f4002a, false, 460, new Class[]{float[].class, float[].class}, Void.TYPE).isSupported && MzVideoSurfaceView.this.f3989n != null && MzVideoSurfaceView.this.f3996u != null) {
                if (MzVideoSurfaceView.this.f3957L) {
                    GLES20.glClear(16384);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                    boolean unused = MzVideoSurfaceView.this.f3957L = false;
                }
                MzVideoSurfaceView.this.f3996u.mo14043a(MzVideoSurfaceView.f3943f);
                if (EffectRenderContext.m4369h().mo14237u()) {
                    MzVideoSurfaceView.this.f3996u.mo14045b(MzVideoSurfaceView.f3945h);
                } else {
                    MzVideoSurfaceView.this.f3996u.mo14045b(MzVideoSurfaceView.f3944g);
                }
                MzVideoSurfaceView.this.f3996u.mo14047c(fArr2);
                MzVideoSurfaceView.this.f3996u.mo14049d(fArr);
                if (MzVideoSurfaceView.this.f3986k <= 0 || MzVideoSurfaceView.this.f3987l <= 0) {
                    Log.i("MzVideoSurfaceView", "render view size not init:" + MzVideoSurfaceView.this.f3986k + "x" + MzVideoSurfaceView.this.f3987l);
                    int unused2 = MzVideoSurfaceView.this.f3986k = MzVideoSurfaceView.this.getViewWidth();
                    int unused3 = MzVideoSurfaceView.this.f3987l = MzVideoSurfaceView.this.getViewHeight();
                    return;
                }
                MzVideoSurfaceView.this.f3996u.mo14040a(MzVideoSurfaceView.this.f3989n, 0, MzVideoSurfaceView.this.f3988m, MzVideoSurfaceView.this.f3986k, MzVideoSurfaceView.this.f3987l);
            }
        }

        /* renamed from: l */
        private void m4705l() {
            if (!PatchProxy.proxy(new Object[0], this, f4002a, false, 461, new Class[0], Void.TYPE).isSupported) {
                Log.v("MzVideoSurfaceView", "initDepthRenderProgram");
                MzVideoSurfaceView.this.f3964S.mo14311f();
                if (MzVideoSurfaceView.this.f3966U == -1) {
                    int unused = MzVideoSurfaceView.this.f3966U = MzVideoSurfaceView.this.f3964S.mo14314i();
                    if (MzVideoSurfaceView.this.f3979ak != null) {
                        MzVideoSurfaceView.this.f3979ak.mo14054a(MzVideoSurfaceView.this.f3966U);
                    }
                }
            }
        }

        /* renamed from: a */
        private void m4683a(Bitmap bitmap) {
            Bitmap bitmap2 = bitmap;
            if (!PatchProxy.proxy(new Object[]{bitmap2}, this, f4002a, false, 462, new Class[]{Bitmap.class}, Void.TYPE).isSupported) {
                FloatBuffer a = MzVideoSurfaceView.this.f3964S.mo14304a();
                FloatBuffer b = MzVideoSurfaceView.this.f3964S.mo14307b();
                int unused = MzVideoSurfaceView.this.f3968W = GLES20.glGetAttribLocation(MzVideoSurfaceView.this.f3964S.mo14309d(), DepthRenderProgram.f4020b.mo14315a());
                int unused2 = MzVideoSurfaceView.this.f3969aa = GLES20.glGetAttribLocation(MzVideoSurfaceView.this.f3964S.mo14309d(), DepthRenderProgram.f4020b.mo14316b());
                int unused3 = MzVideoSurfaceView.this.f3965T = GLES20.glGetUniformLocation(MzVideoSurfaceView.this.f3964S.mo14309d(), DepthRenderProgram.f4020b.mo14318d());
                int unused4 = MzVideoSurfaceView.this.f3970ab = GLES20.glGetUniformLocation(MzVideoSurfaceView.this.f3964S.mo14309d(), DepthRenderProgram.f4020b.mo14317c());
                if (MzVideoSurfaceView.this.f3986k <= 0 || MzVideoSurfaceView.this.f3987l <= 0) {
                    Log.i("MzVideoSurfaceView", "view size not init:" + MzVideoSurfaceView.this.f3986k + "x" + MzVideoSurfaceView.this.f3987l);
                    int unused5 = MzVideoSurfaceView.this.f3986k = MzVideoSurfaceView.this.getViewWidth();
                    int unused6 = MzVideoSurfaceView.this.f3987l = MzVideoSurfaceView.this.getViewHeight();
                } else if (!MzVideoSurfaceView.this.f3964S.mo14310e()) {
                    Log.i("MzVideoSurfaceView", "RenderProgram not ready");
                } else {
                    GLES20.glUseProgram(MzVideoSurfaceView.this.f3964S.mo14309d());
                    GLES20.glViewport(0, 0, this.f4005d.getWidth(), this.f4005d.getHeight());
                    if (bitmap2 != null) {
                        GLES20.glActiveTexture(33984);
                        GLES20.glBindTexture(3553, MzVideoSurfaceView.this.f3966U);
                        ByteBuffer allocate = ByteBuffer.allocate(bitmap.getWidth() * bitmap.getHeight() * 4);
                        bitmap2.copyPixelsToBuffer(allocate);
                        allocate.position(0);
                        GLES20.glTexImage2D(3553, 0, 6408, bitmap.getWidth(), bitmap.getHeight(), 0, 6408, 5121, allocate);
                        GLES20.glUniform1i(MzVideoSurfaceView.this.f3965T, 0);
                    }
                    a.position(0);
                    GLES20.glBindBuffer(34962, 0);
                    GLES20.glBindBuffer(34963, 0);
                    GLES20.glVertexAttribPointer(MzVideoSurfaceView.this.f3968W, 3, 5126, false, 12, a);
                    MzVideoSurfaceView.this.f3964S.mo14306a("glVertexAttribPointer PositionLocation");
                    GLES20.glEnableVertexAttribArray(MzVideoSurfaceView.this.f3968W);
                    MzVideoSurfaceView.this.f3964S.mo14306a("glEnableVertexAttribArray PositionLocation");
                    b.position(0);
                    GLES20.glVertexAttribPointer(MzVideoSurfaceView.this.f3969aa, 2, 5126, false, 8, b);
                    GLES20.glEnableVertexAttribArray(MzVideoSurfaceView.this.f3969aa);
                    MzVideoSurfaceView.this.f3964S.mo14306a("glEnableVertexAttribArray TextureCoordLocation");
                    GLES20.glUniformMatrix4fv(MzVideoSurfaceView.this.f3970ab, 1, false, MzVideoSurfaceView.this.f3976ah, 0);
                    MzVideoSurfaceView.this.f3964S.mo14306a("glUniformMatrix4fv mMVPMatrix");
                    GLES20.glDrawElements(4, MzVideoSurfaceView.this.f3977ai.length, 5123, MzVideoSurfaceView.this.f3964S.mo14308c());
                    MzVideoSurfaceView.this.f3964S.mo14306a("glDrawElements");
                }
            }
        }

        /* renamed from: a */
        public void mo14066a() {
            if (!PatchProxy.proxy(new Object[0], this, f4002a, false, 463, new Class[0], Void.TYPE).isSupported) {
                if (MzVideoSurfaceView.this.f3985j != null) {
                    MzVideoSurfaceView.this.f3985j.mo14297a();
                }
                if (MzVideoSurfaceView.this.f3984i != null) {
                    MzVideoSurfaceView.this.f3984i.mo14293a();
                }
            }
        }
    }
}
