package com.meizu.camera.effectlib.effects.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.p020ar.util.SystemInfoUtil;
import com.meizu.camera.MeizuCamera;
import com.meizu.camera.effectlib.effects.p058a.GLES20Utils;
import com.meizu.camera.effectlib.effects.p058a.GLTexture;
import com.meizu.camera.effectlib.effects.p059b.BaseRender;
import com.meizu.camera.effectlib.effects.views.EffectRenderFactory;
import com.meizu.camera.effectlib.effects.views.PreviewView;
import com.meizu.common.renderer.functor.DrawGLFunctor;
import com.meizu.common.renderer.functor.InvokeFunctor;
import com.meizu.imageproc.SurfaceTextureBitmap;
import com.meizu.imageproc.SurfaceTextureWrapper;
import com.meizu.imageproc.effects.renders.VideoFaceBeautyRender;
import com.meizu.imageproc.effects.renders.VideoMakeupRender;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.List;
import java.util.Vector;

public class CameraPreviewRenderView extends View implements PreviewView {
    /* access modifiers changed from: private */

    /* renamed from: A */
    public static final float[] f3662A = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    /* access modifiers changed from: private */

    /* renamed from: B */
    public static final float[] f3663B = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    /* access modifiers changed from: private */

    /* renamed from: C */
    public static final float[] f3664C = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};

    /* renamed from: D */
    private static final float[] f3665D = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    /* access modifiers changed from: private */

    /* renamed from: T */
    public static int f3666T = 0;

    /* renamed from: a */
    public static ChangeQuickRedirect f3667a;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public final float[] f3668E = new float[16];
    /* access modifiers changed from: private */

    /* renamed from: F */
    public final float[] f3669F = new float[16];
    /* access modifiers changed from: private */

    /* renamed from: G */
    public final float[] f3670G = new float[16];
    /* access modifiers changed from: private */

    /* renamed from: H */
    public final Object f3671H = new Object();
    /* access modifiers changed from: private */

    /* renamed from: I */
    public final Object f3672I = new Object();

    /* renamed from: J */
    private String f3673J;

    /* renamed from: K */
    private int f3674K;

    /* renamed from: L */
    private boolean f3675L;

    /* renamed from: M */
    private boolean f3676M;
    /* access modifiers changed from: private */

    /* renamed from: N */
    public boolean f3677N;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public Bitmap f3678O = null;

    /* renamed from: P */
    private int f3679P = 4;

    /* renamed from: Q */
    private int[] f3680Q = new int[6000000];

    /* renamed from: R */
    private int[] f3681R = new int[2];
    /* access modifiers changed from: private */

    /* renamed from: S */
    public PreviewView.C1193b f3682S = null;
    /* access modifiers changed from: private */

    /* renamed from: U */
    public boolean f3683U = false;
    /* access modifiers changed from: private */

    /* renamed from: V */
    public boolean f3684V = false;
    /* access modifiers changed from: private */

    /* renamed from: W */
    public boolean f3685W = false;

    /* renamed from: aA */
    private int f3686aA = -1;

    /* renamed from: aB */
    private int f3687aB = -1;

    /* renamed from: aC */
    private int f3688aC = -1;
    /* access modifiers changed from: private */

    /* renamed from: aD */
    public int f3689aD = -1;
    /* access modifiers changed from: private */

    /* renamed from: aE */
    public int f3690aE = -1;
    /* access modifiers changed from: private */

    /* renamed from: aF */
    public final float[] f3691aF = new float[16];
    /* access modifiers changed from: private */

    /* renamed from: aG */
    public final float[] f3692aG = new float[16];
    /* access modifiers changed from: private */

    /* renamed from: aH */
    public final float[] f3693aH = new float[16];
    /* access modifiers changed from: private */

    /* renamed from: aI */
    public short[] f3694aI = {0, 2, 1, 1, 2, 3};
    /* access modifiers changed from: private */

    /* renamed from: aJ */
    public boolean f3695aJ = false;
    /* access modifiers changed from: private */

    /* renamed from: aK */
    public boolean f3696aK = true;
    /* access modifiers changed from: private */

    /* renamed from: aL */
    public int f3697aL = -1;
    /* access modifiers changed from: private */

    /* renamed from: aM */
    public GLTexture f3698aM;

    /* renamed from: aN */
    private int f3699aN = -1;
    /* access modifiers changed from: private */

    /* renamed from: aO */
    public BaseRender f3700aO = null;
    /* access modifiers changed from: private */

    /* renamed from: aP */
    public boolean f3701aP = false;
    /* access modifiers changed from: private */

    /* renamed from: aQ */
    public boolean f3702aQ = false;
    /* access modifiers changed from: private */

    /* renamed from: aR */
    public int f3703aR = 1;
    /* access modifiers changed from: private */

    /* renamed from: aS */
    public float f3704aS = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: aT */
    public float f3705aT = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: aU */
    public float f3706aU = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: aV */
    public boolean f3707aV = true;
    /* access modifiers changed from: private */

    /* renamed from: aa */
    public boolean f3708aa = false;
    /* access modifiers changed from: private */

    /* renamed from: ab */
    public boolean f3709ab = false;
    /* access modifiers changed from: private */

    /* renamed from: ac */
    public byte[] f3710ac;

    /* renamed from: ad */
    private int f3711ad = 0;
    /* access modifiers changed from: private */

    /* renamed from: ae */
    public int f3712ae = 0;
    /* access modifiers changed from: private */

    /* renamed from: af */
    public Bitmap f3713af = null;
    /* access modifiers changed from: private */

    /* renamed from: ag */
    public int f3714ag = 0;
    /* access modifiers changed from: private */

    /* renamed from: ah */
    public YuvRenderProgram f3715ah = null;
    /* access modifiers changed from: private */

    /* renamed from: ai */
    public DepthRenderProgram f3716ai = null;
    /* access modifiers changed from: private */

    /* renamed from: aj */
    public boolean f3717aj = false;
    /* access modifiers changed from: private */

    /* renamed from: ak */
    public boolean f3718ak = false;
    /* access modifiers changed from: private */

    /* renamed from: al */
    public int f3719al = -1;
    /* access modifiers changed from: private */

    /* renamed from: am */
    public int f3720am = -1;
    /* access modifiers changed from: private */

    /* renamed from: an */
    public int f3721an = -1;
    /* access modifiers changed from: private */

    /* renamed from: ao */
    public int f3722ao = -1;
    /* access modifiers changed from: private */

    /* renamed from: ap */
    public int f3723ap = -1;
    /* access modifiers changed from: private */

    /* renamed from: aq */
    public int f3724aq = -1;
    /* access modifiers changed from: private */

    /* renamed from: ar */
    public int f3725ar = -1;

    /* renamed from: as */
    private int f3726as = -1;

    /* renamed from: at */
    private int f3727at = -1;

    /* renamed from: au */
    private int f3728au = -1;

    /* renamed from: av */
    private int f3729av = -1;

    /* renamed from: aw */
    private int f3730aw = -1;

    /* renamed from: ax */
    private int f3731ax = -1;

    /* renamed from: ay */
    private int f3732ay = -1;

    /* renamed from: az */
    private int f3733az = -1;

    /* renamed from: b */
    protected InvokeFunctor f3734b = new InvokeFunctor() {
        public static ChangeQuickRedirect changeQuickRedirect;

        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0126, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0146, code lost:
            com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.m4289b(r8.this$0, false);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x014b, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x0224, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:98:0x0244, code lost:
            com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.m4289b(r8.this$0, false);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:99:0x0249, code lost:
            throw r0;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [B:49:0x012b, B:94:0x0229] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onInvoke(int r9) {
            /*
                r8 = this;
                r0 = 1
                java.lang.Object[] r1 = new java.lang.Object[r0]
                java.lang.Integer r2 = new java.lang.Integer
                r2.<init>(r9)
                r9 = 0
                r1[r9] = r2
                com.meizu.savior.ChangeQuickRedirect r3 = changeQuickRedirect
                java.lang.Class[] r6 = new java.lang.Class[r0]
                java.lang.Class r2 = java.lang.Integer.TYPE
                r6[r9] = r2
                java.lang.Class r7 = java.lang.Void.TYPE
                r4 = 0
                r5 = 236(0xec, float:3.31E-43)
                r2 = r8
                com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                boolean r1 = r1.isSupported
                if (r1 == 0) goto L_0x0022
                return
            L_0x0022:
                java.lang.String r1 = "glrenderer"
                java.lang.String r2 = "onInvoke  release 1..................."
                android.util.Log.i(r1, r2)
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                java.lang.Object r1 = r1.f3671H
                monitor-enter(r1)
                java.lang.String r2 = "glrenderer"
                java.lang.String r3 = "CameraPreviewRenderView release"
                android.util.Log.i(r2, r3)     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                r2.mo14193b((com.meizu.camera.effectlib.effects.views.PreviewView) r3)     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                android.graphics.Bitmap r2 = r2.f3678O     // Catch:{ all -> 0x0381 }
                r3 = 0
                if (r2 == 0) goto L_0x0063
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                android.graphics.Bitmap r2 = r2.f3678O     // Catch:{ all -> 0x0381 }
                boolean r2 = r2.isRecycled()     // Catch:{ all -> 0x0381 }
                if (r2 != 0) goto L_0x0063
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                android.graphics.Bitmap r2 = r2.f3678O     // Catch:{ all -> 0x0381 }
                r2.recycle()     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                android.graphics.Bitmap unused = r2.f3678O = r3     // Catch:{ all -> 0x0381 }
            L_0x0063:
                com.meizu.imageproc.SurfaceTextureBitmap.m6368a((boolean) r9)     // Catch:{ all -> 0x0381 }
                int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0381 }
                r4 = 29
                if (r2 < r4) goto L_0x016a
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                com.meizu.imageproc.SurfaceTextureWrapper r2 = r2.f3742j     // Catch:{ all -> 0x0381 }
                if (r2 == 0) goto L_0x0266
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                com.meizu.imageproc.SurfaceTextureWrapper unused = r2.f3743k = r3     // Catch:{ all -> 0x0381 }
                int r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.f3666T     // Catch:{ all -> 0x0381 }
                if (r2 <= r0) goto L_0x0084
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                boolean unused = r2.f3683U = r0     // Catch:{ all -> 0x0381 }
            L_0x0084:
                int r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.f3666T     // Catch:{ all -> 0x0381 }
                if (r0 <= 0) goto L_0x008d
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.m4321o()     // Catch:{ all -> 0x0381 }
            L_0x008d:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                java.util.Vector r0 = r0.f3758z     // Catch:{ all -> 0x0381 }
                if (r0 == 0) goto L_0x00b5
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                java.util.Vector r0 = r0.f3758z     // Catch:{ all -> 0x0381 }
                boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0381 }
                if (r0 != 0) goto L_0x00b5
                java.lang.String r0 = "camPreviewRenderView"
                java.lang.String r2 = "sQueue.remove"
                android.util.Log.i(r0, r2)     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                java.util.Vector r0 = r0.f3758z     // Catch:{ all -> 0x0381 }
                java.lang.Object r0 = r0.remove(r9)     // Catch:{ all -> 0x0381 }
                java.lang.Runnable r0 = (java.lang.Runnable) r0     // Catch:{ all -> 0x0381 }
                goto L_0x00b6
            L_0x00b5:
                r0 = r3
            L_0x00b6:
                if (r0 == 0) goto L_0x00bb
                r0.run()     // Catch:{ all -> 0x0381 }
            L_0x00bb:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.b.a r0 = r0.f3755w     // Catch:{ all -> 0x0381 }
                if (r0 == 0) goto L_0x00cf
                java.lang.String r0 = "camPreviewRenderView"
                java.lang.String r2 = "CameraPreviewRenderView set Render null"
                android.util.Log.i(r0, r2)     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.p059b.BaseRender unused = r0.f3755w = r3     // Catch:{ all -> 0x0381 }
            L_0x00cf:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.b.a r0 = r0.f3700aO     // Catch:{ all -> 0x0381 }
                if (r0 == 0) goto L_0x00e3
                java.lang.String r0 = "camPreviewRenderView"
                java.lang.String r2 = "CameraPreviewRenderView set VfbRender null"
                android.util.Log.i(r0, r2)     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.p059b.BaseRender unused = r0.f3700aO = r3     // Catch:{ all -> 0x0381 }
            L_0x00e3:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                boolean r0 = r0.f3756x     // Catch:{ all -> 0x0381 }
                if (r0 == 0) goto L_0x014c
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r0 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                com.meizu.imageproc.SurfaceTextureWrapper r2 = r2.f3742j     // Catch:{ all -> 0x0381 }
                boolean r0 = r0.mo14196b((com.meizu.imageproc.SurfaceTextureWrapper) r2)     // Catch:{ all -> 0x0381 }
                if (r0 == 0) goto L_0x014c
                java.lang.String r0 = "glrenderer"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0128 }
                r2.<init>()     // Catch:{ Exception -> 0x0128 }
                java.lang.String r4 = "detachFromGLContext:"
                r2.append(r4)     // Catch:{ Exception -> 0x0128 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r4 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ Exception -> 0x0128 }
                com.meizu.imageproc.SurfaceTextureWrapper r4 = r4.f3742j     // Catch:{ Exception -> 0x0128 }
                r2.append(r4)     // Catch:{ Exception -> 0x0128 }
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0128 }
                android.util.Log.i(r0, r2)     // Catch:{ Exception -> 0x0128 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ Exception -> 0x0128 }
                com.meizu.imageproc.SurfaceTextureWrapper r0 = r0.f3742j     // Catch:{ Exception -> 0x0128 }
                r0.detachFromGLContext()     // Catch:{ Exception -> 0x0128 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
            L_0x0122:
                boolean unused = r0.f3756x = r9     // Catch:{ all -> 0x0381 }
                goto L_0x014c
            L_0x0126:
                r0 = move-exception
                goto L_0x0146
            L_0x0128:
                r0 = move-exception
                java.lang.String r2 = "glrenderer"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0126 }
                r4.<init>()     // Catch:{ all -> 0x0126 }
                java.lang.String r5 = "error:"
                r4.append(r5)     // Catch:{ all -> 0x0126 }
                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0126 }
                r4.append(r0)     // Catch:{ all -> 0x0126 }
                java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0126 }
                android.util.Log.e(r2, r0)     // Catch:{ all -> 0x0126 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                goto L_0x0122
            L_0x0146:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                boolean unused = r2.f3756x = r9     // Catch:{ all -> 0x0381 }
                throw r0     // Catch:{ all -> 0x0381 }
            L_0x014c:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.c$d r0 = r0.f3750r     // Catch:{ all -> 0x0381 }
                if (r0 == 0) goto L_0x0163
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.c$d r0 = r0.f3750r     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                com.meizu.imageproc.SurfaceTextureWrapper r2 = r2.f3742j     // Catch:{ all -> 0x0381 }
                r0.mo14353a(r2)     // Catch:{ all -> 0x0381 }
            L_0x0163:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                com.meizu.imageproc.SurfaceTextureWrapper unused = r0.f3742j = r3     // Catch:{ all -> 0x0381 }
                goto L_0x0266
            L_0x016a:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                android.graphics.SurfaceTexture r2 = r2.f3740h     // Catch:{ all -> 0x0381 }
                if (r2 == 0) goto L_0x0266
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                android.graphics.SurfaceTexture unused = r2.f3741i = r3     // Catch:{ all -> 0x0381 }
                int r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.f3666T     // Catch:{ all -> 0x0381 }
                if (r2 <= r0) goto L_0x0182
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                boolean unused = r2.f3683U = r0     // Catch:{ all -> 0x0381 }
            L_0x0182:
                int r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.f3666T     // Catch:{ all -> 0x0381 }
                if (r0 <= 0) goto L_0x018b
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.m4321o()     // Catch:{ all -> 0x0381 }
            L_0x018b:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                java.util.Vector r0 = r0.f3758z     // Catch:{ all -> 0x0381 }
                if (r0 == 0) goto L_0x01b3
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                java.util.Vector r0 = r0.f3758z     // Catch:{ all -> 0x0381 }
                boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0381 }
                if (r0 != 0) goto L_0x01b3
                java.lang.String r0 = "camPreviewRenderView"
                java.lang.String r2 = "sQueue.remove"
                android.util.Log.i(r0, r2)     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                java.util.Vector r0 = r0.f3758z     // Catch:{ all -> 0x0381 }
                java.lang.Object r0 = r0.remove(r9)     // Catch:{ all -> 0x0381 }
                java.lang.Runnable r0 = (java.lang.Runnable) r0     // Catch:{ all -> 0x0381 }
                goto L_0x01b4
            L_0x01b3:
                r0 = r3
            L_0x01b4:
                if (r0 == 0) goto L_0x01b9
                r0.run()     // Catch:{ all -> 0x0381 }
            L_0x01b9:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.b.a r0 = r0.f3755w     // Catch:{ all -> 0x0381 }
                if (r0 == 0) goto L_0x01cd
                java.lang.String r0 = "camPreviewRenderView"
                java.lang.String r2 = "CameraPreviewRenderView set Render null"
                android.util.Log.i(r0, r2)     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.p059b.BaseRender unused = r0.f3755w = r3     // Catch:{ all -> 0x0381 }
            L_0x01cd:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.b.a r0 = r0.f3700aO     // Catch:{ all -> 0x0381 }
                if (r0 == 0) goto L_0x01e1
                java.lang.String r0 = "camPreviewRenderView"
                java.lang.String r2 = "CameraPreviewRenderView set VfbRender null"
                android.util.Log.i(r0, r2)     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.p059b.BaseRender unused = r0.f3700aO = r3     // Catch:{ all -> 0x0381 }
            L_0x01e1:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                boolean r0 = r0.f3756x     // Catch:{ all -> 0x0381 }
                if (r0 == 0) goto L_0x024a
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r0 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                android.graphics.SurfaceTexture r2 = r2.f3740h     // Catch:{ all -> 0x0381 }
                boolean r0 = r0.mo14195b((android.graphics.SurfaceTexture) r2)     // Catch:{ all -> 0x0381 }
                if (r0 == 0) goto L_0x024a
                java.lang.String r0 = "glrenderer"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0226 }
                r2.<init>()     // Catch:{ Exception -> 0x0226 }
                java.lang.String r4 = "detachFromGLContext:"
                r2.append(r4)     // Catch:{ Exception -> 0x0226 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r4 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ Exception -> 0x0226 }
                android.graphics.SurfaceTexture r4 = r4.f3740h     // Catch:{ Exception -> 0x0226 }
                r2.append(r4)     // Catch:{ Exception -> 0x0226 }
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0226 }
                android.util.Log.i(r0, r2)     // Catch:{ Exception -> 0x0226 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ Exception -> 0x0226 }
                android.graphics.SurfaceTexture r0 = r0.f3740h     // Catch:{ Exception -> 0x0226 }
                r0.detachFromGLContext()     // Catch:{ Exception -> 0x0226 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
            L_0x0220:
                boolean unused = r0.f3756x = r9     // Catch:{ all -> 0x0381 }
                goto L_0x024a
            L_0x0224:
                r0 = move-exception
                goto L_0x0244
            L_0x0226:
                r0 = move-exception
                java.lang.String r2 = "glrenderer"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0224 }
                r4.<init>()     // Catch:{ all -> 0x0224 }
                java.lang.String r5 = "error:"
                r4.append(r5)     // Catch:{ all -> 0x0224 }
                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0224 }
                r4.append(r0)     // Catch:{ all -> 0x0224 }
                java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0224 }
                android.util.Log.e(r2, r0)     // Catch:{ all -> 0x0224 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                goto L_0x0220
            L_0x0244:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                boolean unused = r2.f3756x = r9     // Catch:{ all -> 0x0381 }
                throw r0     // Catch:{ all -> 0x0381 }
            L_0x024a:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.c$c r0 = r0.f3749q     // Catch:{ all -> 0x0381 }
                if (r0 == 0) goto L_0x0261
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.c$c r0 = r0.f3749q     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                android.graphics.SurfaceTexture r2 = r2.f3740h     // Catch:{ all -> 0x0381 }
                r0.mo14348a(r2)     // Catch:{ all -> 0x0381 }
            L_0x0261:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                android.graphics.SurfaceTexture unused = r0.f3740h = r3     // Catch:{ all -> 0x0381 }
            L_0x0266:
                int r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.f3666T     // Catch:{ all -> 0x0381 }
                if (r0 != 0) goto L_0x02eb
                java.lang.String r0 = "glrenderer"
                java.lang.String r2 = "onInvoke  release 2.................."
                android.util.Log.i(r0, r2)     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r0 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x0381 }
                boolean r0 = r0.mo14216g()     // Catch:{ all -> 0x0381 }
                if (r0 == 0) goto L_0x0286
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r0 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                r0.mo14193b((com.meizu.camera.effectlib.effects.views.PreviewView) r2)     // Catch:{ all -> 0x0381 }
            L_0x0286:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                boolean unused = r0.f3683U = r9     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r0 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x0381 }
                r0.mo14177a((com.meizu.camera.effectlib.effects.p058a.GLTexture) r3)     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.a.c r0 = r0.f3752t     // Catch:{ all -> 0x0381 }
                if (r0 == 0) goto L_0x02c8
                java.lang.String r0 = "glrenderer"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0381 }
                r2.<init>()     // Catch:{ all -> 0x0381 }
                java.lang.String r4 = " recycle mPreviewTexture id "
                r2.append(r4)     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r4 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.a.c r4 = r4.f3752t     // Catch:{ all -> 0x0381 }
                int r4 = r4.mo14028a()     // Catch:{ all -> 0x0381 }
                r2.append(r4)     // Catch:{ all -> 0x0381 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0381 }
                android.util.Log.i(r0, r2)     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.a.c r0 = r0.f3752t     // Catch:{ all -> 0x0381 }
                r0.mo14032c()     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.p058a.GLTexture unused = r0.f3752t = r3     // Catch:{ all -> 0x0381 }
            L_0x02c8:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                boolean r0 = r0.f3677N     // Catch:{ all -> 0x0381 }
                if (r0 == 0) goto L_0x02eb
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.a.c r0 = r0.f3698aM     // Catch:{ all -> 0x0381 }
                if (r0 == 0) goto L_0x02e6
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.a.c r0 = r0.f3698aM     // Catch:{ all -> 0x0381 }
                r0.mo14032c()     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.p058a.GLTexture unused = r0.f3698aM = r3     // Catch:{ all -> 0x0381 }
            L_0x02e6:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                r0.m4337w()     // Catch:{ all -> 0x0381 }
            L_0x02eb:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                byte[] r0 = r0.f3710ac     // Catch:{ all -> 0x0381 }
                if (r0 == 0) goto L_0x02f8
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                byte[] unused = r0.f3710ac = r3     // Catch:{ all -> 0x0381 }
            L_0x02f8:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.d r0 = r0.f3715ah     // Catch:{ all -> 0x0381 }
                r2 = -1
                if (r0 == 0) goto L_0x0337
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.d r0 = r0.f3715ah     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r4 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                int r4 = r4.f3719al     // Catch:{ all -> 0x0381 }
                r0.mo14360a((int) r4)     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.d r0 = r0.f3715ah     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r4 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                int r4 = r4.f3720am     // Catch:{ all -> 0x0381 }
                r0.mo14360a((int) r4)     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.d r0 = r0.f3715ah     // Catch:{ all -> 0x0381 }
                r0.mo14368h()     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.YuvRenderProgram unused = r0.f3715ah = r3     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                int unused = r0.f3719al = r2     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                int unused = r0.f3720am = r2     // Catch:{ all -> 0x0381 }
            L_0x0337:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.a r0 = r0.f3716ai     // Catch:{ all -> 0x0381 }
                if (r0 == 0) goto L_0x0361
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.a r0 = r0.f3716ai     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r4 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                int r4 = r4.f3690aE     // Catch:{ all -> 0x0381 }
                r0.mo14305a((int) r4)     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.a r0 = r0.f3716ai     // Catch:{ all -> 0x0381 }
                r0.mo14313h()     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.DepthRenderProgram unused = r0.f3716ai = r3     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                int unused = r0.f3690aE = r2     // Catch:{ all -> 0x0381 }
            L_0x0361:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                boolean unused = r0.f3717aj = r9     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                boolean unused = r0.f3718ak = r9     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                boolean unused = r0.f3708aa = r9     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                boolean unused = r0.f3684V = r9     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                boolean unused = r0.f3685W = r9     // Catch:{ all -> 0x0381 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x0381 }
                boolean unused = r0.f3701aP = r9     // Catch:{ all -> 0x0381 }
                monitor-exit(r1)     // Catch:{ all -> 0x0381 }
                return
            L_0x0381:
                r9 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0381 }
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.C11631.onInvoke(int):void");
        }
    };

    /* renamed from: c */
    protected InvokeFunctor f3735c = new InvokeFunctor() {
        public static ChangeQuickRedirect changeQuickRedirect;

        public void onInvoke(int i) {
            Integer num = new Integer(i);
            if (!PatchProxy.proxy(new Object[]{num}, this, changeQuickRedirect, false, 237, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
                synchronized (CameraPreviewRenderView.this.f3671H) {
                    EffectRenderContext.m4369h().mo14200c((SurfaceTexture) null);
                    List<SurfaceTexture> a = EffectRenderContext.m4369h().mo14171a();
                    for (int i2 = 0; i2 < a.size(); i2++) {
                        SurfaceTexture surfaceTexture = a.get(i2);
                        surfaceTexture.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener) null);
                        Log.i("glrenderer", "ReleaseSurfaceTexture:" + surfaceTexture);
                        if (CameraPreviewRenderView.this.f3749q != null) {
                            CameraPreviewRenderView.this.f3749q.mo14351c(surfaceTexture);
                        }
                    }
                    EffectRenderContext.m4369h().mo14208e();
                }
            }
        }
    };

    /* renamed from: d */
    protected InvokeFunctor f3736d = new InvokeFunctor() {
        public static ChangeQuickRedirect changeQuickRedirect;

        public void onInvoke(int i) {
            CameraPreviewRenderView cameraPreviewRenderView;
            if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, changeQuickRedirect, false, 238, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
                synchronized (CameraPreviewRenderView.this.f3671H) {
                    if (CameraPreviewRenderView.this.f3756x && EffectRenderContext.m4369h().mo14195b(CameraPreviewRenderView.this.f3740h)) {
                        try {
                            Log.i("glrenderer", "detachFromGLContextInvokeFunctor:" + CameraPreviewRenderView.this.f3740h);
                            CameraPreviewRenderView.this.f3740h.detachFromGLContext();
                            cameraPreviewRenderView = CameraPreviewRenderView.this;
                        } catch (Exception e) {
                            try {
                                Log.e("glrenderer", "error:" + e.getMessage());
                                cameraPreviewRenderView = CameraPreviewRenderView.this;
                            } catch (Throwable th) {
                                boolean unused = CameraPreviewRenderView.this.f3756x = false;
                                throw th;
                            }
                        }
                        boolean unused2 = cameraPreviewRenderView.f3756x = false;
                    }
                    EffectRenderContext.m4369h().mo14193b((PreviewView) CameraPreviewRenderView.this);
                    if (CameraPreviewRenderView.this.f3752t != null) {
                        Log.i("glrenderer", " recycle mPreviewTexture id " + CameraPreviewRenderView.this.f3752t.mo14028a());
                        CameraPreviewRenderView.this.f3752t.mo14032c();
                        GLTexture unused3 = CameraPreviewRenderView.this.f3752t = null;
                        EffectRenderContext.m4369h().mo14177a((GLTexture) null);
                    }
                    EffectRenderContext.m4369h().mo14159D();
                    EffectRenderContext.m4369h().mo14160E();
                    EffectRenderContext.m4369h().mo14163H();
                }
            }
        }
    };

    /* renamed from: e */
    protected InvokeFunctor f3737e = new InvokeFunctor() {
        public static ChangeQuickRedirect changeQuickRedirect;

        public void onInvoke(int i) {
            Integer num = new Integer(i);
            if (!PatchProxy.proxy(new Object[]{num}, this, changeQuickRedirect, false, 239, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
                synchronized (CameraPreviewRenderView.this.f3671H) {
                    EffectRenderContext.m4369h().mo14201c((SurfaceTextureWrapper) null);
                    List<SurfaceTextureWrapper> b = EffectRenderContext.m4369h().mo14189b();
                    for (int i2 = 0; i2 < b.size(); i2++) {
                        SurfaceTextureWrapper surfaceTextureWrapper = b.get(i2);
                        surfaceTextureWrapper.setOnFrameAvailableListener((SurfaceTextureWrapper.C1568a) null);
                        Log.i("glrenderer", "ReleaseSurfaceTextureWrapper:" + surfaceTextureWrapper);
                        if (CameraPreviewRenderView.this.f3750r != null) {
                            CameraPreviewRenderView.this.f3750r.mo14355b(surfaceTextureWrapper);
                        }
                    }
                    EffectRenderContext.m4369h().mo14211f();
                }
            }
        }
    };

    /* renamed from: f */
    protected InvokeFunctor f3738f = new InvokeFunctor() {
        public static ChangeQuickRedirect changeQuickRedirect;

        public void onInvoke(int i) {
            CameraPreviewRenderView cameraPreviewRenderView;
            if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, changeQuickRedirect, false, 240, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
                synchronized (CameraPreviewRenderView.this.f3671H) {
                    if (CameraPreviewRenderView.this.f3756x && EffectRenderContext.m4369h().mo14196b(CameraPreviewRenderView.this.f3742j)) {
                        try {
                            Log.i("glrenderer", "detachFromGLContextWrapperInvokeFunctor:" + CameraPreviewRenderView.this.f3742j);
                            CameraPreviewRenderView.this.f3742j.detachFromGLContext();
                            cameraPreviewRenderView = CameraPreviewRenderView.this;
                        } catch (Exception e) {
                            try {
                                Log.e("glrenderer", "error:" + e.getMessage());
                                cameraPreviewRenderView = CameraPreviewRenderView.this;
                            } catch (Throwable th) {
                                boolean unused = CameraPreviewRenderView.this.f3756x = false;
                                throw th;
                            }
                        }
                        boolean unused2 = cameraPreviewRenderView.f3756x = false;
                    }
                    EffectRenderContext.m4369h().mo14193b((PreviewView) CameraPreviewRenderView.this);
                    if (CameraPreviewRenderView.this.f3752t != null) {
                        Log.i("glrenderer", " recycle mPreviewTexture id " + CameraPreviewRenderView.this.f3752t.mo14028a());
                        CameraPreviewRenderView.this.f3752t.mo14032c();
                        GLTexture unused3 = CameraPreviewRenderView.this.f3752t = null;
                        EffectRenderContext.m4369h().mo14177a((GLTexture) null);
                    }
                    EffectRenderContext.m4369h().mo14159D();
                    EffectRenderContext.m4369h().mo14160E();
                    EffectRenderContext.m4369h().mo14163H();
                }
            }
        }
    };

    /* renamed from: g */
    protected InvokeFunctor f3739g = new InvokeFunctor() {
        public static ChangeQuickRedirect changeQuickRedirect;

        public void onInvoke(int i) {
            if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, changeQuickRedirect, false, 241, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
                Log.i("glrenderer", "releaseframeBuffer...................");
                synchronized (CameraPreviewRenderView.this.f3671H) {
                }
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: h */
    public SurfaceTexture f3740h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public SurfaceTexture f3741i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public SurfaceTextureWrapper f3742j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public SurfaceTextureWrapper f3743k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f3744l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f3745m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f3746n;

    /* renamed from: o */
    private C1169a f3747o;

    /* renamed from: p */
    private C1170b f3748p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public PreviewView.C1194c f3749q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public PreviewView.C1195d f3750r;

    /* renamed from: s */
    private PreviewView.C1192a f3751s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public GLTexture f3752t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public GLTexture f3753u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public EffectRenderFactory f3754v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public BaseRender f3755w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f3756x = false;

    /* renamed from: y */
    private boolean f3757y = false;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public final Vector<Runnable> f3758z = new Vector<>();

    /* renamed from: o */
    static /* synthetic */ int m4321o() {
        int i = f3666T;
        f3666T = i - 1;
        return i;
    }

    public CameraPreviewRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public CameraPreviewRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CameraPreviewRenderView(Context context) {
        super(context);
    }

    /* renamed from: a */
    public void mo14100a() {
        if (!PatchProxy.proxy(new Object[0], this, f3667a, false, 190, new Class[0], Void.TYPE).isSupported) {
            mo14104b();
        }
    }

    /* renamed from: b */
    public void mo14104b() {
        if (!PatchProxy.proxy(new Object[0], this, f3667a, false, 191, new Class[0], Void.TYPE).isSupported) {
            this.f3747o = new C1169a();
            this.f3748p = new C1170b(this);
            Matrix.setIdentityM(this.f3668E, 0);
            Matrix.setIdentityM(this.f3669F, 0);
            this.f3683U = false;
            Matrix.setIdentityM(this.f3691aF, 0);
            Matrix.setIdentityM(this.f3692aG, 0);
            Matrix.setIdentityM(this.f3693aH, 0);
            this.f3695aJ = false;
            Log.i("camPreviewRenderView", " createCameraPreviewRenderView :" + this + " getContext" + getContext());
        }
    }

    public void setSurfaceTextureListener(PreviewView.C1194c cVar) {
        this.f3749q = cVar;
    }

    public void setSurfaceTextureListener2(PreviewView.C1194c cVar, PreviewView.C1195d dVar) {
        this.f3749q = cVar;
        this.f3750r = dVar;
    }

    public void setRenderViewCallBackListener(PreviewView.C1193b bVar) {
        this.f3682S = bVar;
    }

    public void setEffectRenderFactory(EffectRenderFactory bVar) {
        if (!PatchProxy.proxy(new Object[]{bVar}, this, f3667a, false, Opcodes.CHECKCAST, new Class[]{EffectRenderFactory.class}, Void.TYPE).isSupported) {
            this.f3754v = bVar;
            if (this.f3754v != null) {
                this.f3673J = this.f3754v.mo14326b();
                this.f3674K = this.f3754v.mo14328c();
                this.f3675L = this.f3754v.mo14331d();
                this.f3676M = this.f3754v.mo14333e();
                this.f3677N = this.f3754v.mo14334f();
                EffectRenderContext.m4369h().mo14174a(this.f3674K, this.f3675L, this.f3676M, this.f3677N);
                Log.i("camPreviewRenderView", "mDeviceType " + this.f3673J + " mDevicePlatform " + this.f3674K + " mNeedFBThumnail " + this.f3675L + " misUseFBHigherLib " + this.f3676M + " mSupportFBandEffectOverlay" + this.f3677N);
                return;
            }
            Log.i("camPreviewRenderView", "mDeviceType is null ");
        }
    }

    /* renamed from: c */
    public void mo14105c() {
        if (!PatchProxy.proxy(new Object[0], this, f3667a, false, Opcodes.INSTANCEOF, new Class[0], Void.TYPE).isSupported) {
            Log.i("camPreviewRenderView", "initSurfaceTextureBitmap");
            SurfaceTextureBitmap.m6367a();
        }
    }

    public void setSurfaceTextureBitmap(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f3667a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 194, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            synchronized (this.f3671H) {
                SurfaceTextureBitmap.m6368a(true);
                Log.i("camPreviewRenderView", "setSurfaceTextureBitmap");
                try {
                    if (EffectRenderContext.m4369h().f3807d && this.f3755w != null && (this.f3755w.mo14046c().mo14345d().equals("Mzvfacebeauty") || this.f3755w.mo14046c().mo14345d().equals("Mzmake up"))) {
                        if (this.f3755w.mo14046c().mo14345d().equals("Mzvfacebeauty")) {
                            Log.i("camPreviewRenderView", "fastFaceBeauty thumbnail");
                            this.f3678O = ((VideoFaceBeautyRender) this.f3755w).mo17629a(this.f3681R, this.f3680Q, this.f3679P, i);
                        } else if (this.f3755w.mo14046c().mo14345d().equals("Mzmake up")) {
                            Log.i("camPreviewRenderView", "fastFaceBeauty thumbnail videomake");
                            this.f3678O = ((VideoMakeupRender) this.f3755w).mo17630a(this.f3681R, this.f3680Q, this.f3679P, i);
                        }
                        if (this.f3678O == null) {
                            Log.e("camPreviewRenderView", "get fastFaceBeauty thumbnail fail");
                            if (Build.VERSION.SDK_INT >= 29) {
                                this.f3678O = SurfaceTextureBitmap.m6366a(this.f3743k, this.f3681R, this.f3680Q, this.f3679P, i, EffectRenderContext.m4369h().mo14188b(this.f3674K, this.f3675L, this.f3676M, this.f3677N));
                            } else {
                                this.f3678O = SurfaceTextureBitmap.m6365a(this.f3741i, this.f3681R, this.f3680Q, this.f3679P, i, EffectRenderContext.m4369h().mo14188b(this.f3674K, this.f3675L, this.f3676M, this.f3677N));
                            }
                        }
                    } else if (Build.VERSION.SDK_INT >= 29) {
                        this.f3678O = SurfaceTextureBitmap.m6366a(this.f3743k, this.f3681R, this.f3680Q, this.f3679P, i, EffectRenderContext.m4369h().mo14188b(this.f3674K, this.f3675L, this.f3676M, this.f3677N));
                    } else {
                        this.f3678O = SurfaceTextureBitmap.m6365a(this.f3741i, this.f3681R, this.f3680Q, this.f3679P, i, EffectRenderContext.m4369h().mo14188b(this.f3674K, this.f3675L, this.f3676M, this.f3677N));
                    }
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    this.f3678O = SurfaceTextureBitmap.m6365a(this.f3741i, this.f3681R, this.f3680Q, this.f3679P, i, EffectRenderContext.m4369h().mo14188b(this.f3674K, this.f3675L, this.f3676M, this.f3677N));
                }
            }
        }
    }

    public void setSurfaceTextureBitmap(int i, int i2, boolean z) {
        Object[] objArr = {new Integer(i), new Integer(i2), new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f3667a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 195, new Class[]{Integer.TYPE, Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            synchronized (this.f3671H) {
                SurfaceTextureBitmap.m6368a(true);
                Log.i("camPreviewRenderView", "setSurfaceTextureBitmap rotation " + i + " factor " + i2);
                if (this.f3755w == null || this.f3755w.mo14046c() == null || ((!this.f3755w.mo14046c().mo14342a().equals("ColorTableRender") && !this.f3755w.mo14046c().mo14342a().equals("LutRender")) || !z)) {
                    this.f3702aQ = false;
                    if (!EffectRenderContext.m4369h().f3807d || this.f3755w == null || (!this.f3755w.mo14046c().mo14345d().equals("Mzvfacebeauty") && !this.f3755w.mo14046c().mo14345d().equals("Mzmake up"))) {
                        if (Build.VERSION.SDK_INT >= 29) {
                            this.f3678O = SurfaceTextureBitmap.m6366a(this.f3743k, this.f3681R, this.f3680Q, i2, i, EffectRenderContext.m4369h().mo14188b(this.f3674K, this.f3675L, this.f3676M, this.f3677N));
                        } else {
                            this.f3678O = SurfaceTextureBitmap.m6365a(this.f3741i, this.f3681R, this.f3680Q, i2, i, EffectRenderContext.m4369h().mo14188b(this.f3674K, this.f3675L, this.f3676M, this.f3677N));
                        }
                        Log.e("camPreviewRenderView", "get fastFaceBeauty thumbnail fail");
                    } else {
                        if (this.f3755w.mo14046c().mo14345d().equals("Mzvfacebeauty")) {
                            Log.i("camPreviewRenderView", "fastFaceBeauty thumbnail");
                            this.f3678O = ((VideoFaceBeautyRender) this.f3755w).mo17629a(this.f3681R, this.f3680Q, this.f3679P, i);
                        } else if (this.f3755w.mo14046c().mo14345d().equals("Mzmake up")) {
                            Log.i("camPreviewRenderView", "fastFaceBeauty thumbnail videomake");
                            this.f3678O = ((VideoMakeupRender) this.f3755w).mo17630a(this.f3681R, this.f3680Q, this.f3679P, i);
                        }
                        if (this.f3678O == null) {
                            Log.e("camPreviewRenderView", "get fastFaceBeauty thumbnail fail");
                            if (Build.VERSION.SDK_INT >= 29) {
                                this.f3678O = SurfaceTextureBitmap.m6366a(this.f3743k, this.f3681R, this.f3680Q, i2, i, EffectRenderContext.m4369h().mo14188b(this.f3674K, this.f3675L, this.f3676M, this.f3677N));
                            } else {
                                this.f3678O = SurfaceTextureBitmap.m6365a(this.f3741i, this.f3681R, this.f3680Q, i2, i, EffectRenderContext.m4369h().mo14188b(this.f3674K, this.f3675L, this.f3676M, this.f3677N));
                            }
                        }
                    }
                    if (this.f3678O == null) {
                        Log.e("camPreviewRenderView", "get thumbnail fail");
                    }
                } else {
                    this.f3702aQ = true;
                    this.f3703aR = i2;
                }
            }
        }
    }

    public void setSurfaceTextureBitmap(int i, int i2, boolean z, boolean z2) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2), new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)}, this, f3667a, false, 196, new Class[]{Integer.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            setSurfaceTextureBitmap(i, i2, z2);
            if (z) {
                this.f3678O = m4264a(this.f3678O);
            }
        }
    }

    /* renamed from: a */
    public static Bitmap m4264a(Bitmap bitmap) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap}, (Object) null, f3667a, true, 197, new Class[]{Bitmap.class}, Bitmap.class);
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
        if (!PatchProxy.proxy(new Object[]{str}, this, f3667a, false, Opcodes.IFNULL, new Class[]{String.class}, Void.TYPE).isSupported) {
            EffectRenderFactory.C1191c a = this.f3754v.mo14321a(str);
            if (this.f3755w == null || this.f3755w.mo14046c() != a) {
                if (this.f3755w != null && (this.f3755w.mo14046c().mo14345d().equals("Mzvfacebeauty") || this.f3755w.mo14046c().mo14345d().equals("Mzmake up"))) {
                    Log.i("camPreviewRenderView", SystemInfoUtil.COLON + this.f3755w + " renderType:" + this.f3755w.mo14046c().mo14345d());
                    EffectRenderContext.m4369h().mo14202c(this.f3755w.mo14046c().mo14345d());
                    this.f3758z.add(new C1171c(this.f3755w));
                }
                this.f3755w = this.f3754v.mo14319a(a);
                Log.i("camPreviewRenderView", "setRenderType   mRender " + this.f3755w.mo14046c().mo14345d());
            }
        }
    }

    public void setVfbRenderType(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f3667a, false, Opcodes.IFNONNULL, new Class[]{String.class}, Void.TYPE).isSupported) {
            EffectRenderFactory.C1191c a = this.f3754v.mo14321a(str);
            if (!this.f3677N) {
                Log.i("camPreviewRenderView", "not SupportFBandEffectOverlay");
            } else if (this.f3700aO == null || this.f3700aO.mo14046c() != a) {
                if (this.f3700aO != null && (this.f3755w.mo14046c().mo14345d().equals("Mzvfacebeauty") || this.f3755w.mo14046c().mo14345d().equals("Mzmake up"))) {
                    Log.i("camPreviewRenderView", SystemInfoUtil.COLON + this.f3700aO + " renderType:" + this.f3700aO.mo14046c().mo14345d());
                    EffectRenderContext.m4369h().mo14202c(this.f3700aO.mo14046c().mo14345d());
                    this.f3758z.add(new C1171c(this.f3700aO));
                }
                this.f3700aO = this.f3754v.mo14319a(a);
                Log.i("camPreviewRenderView", "setVfbRenderType   mVfbRender " + this.f3700aO.mo14046c().mo14345d());
            }
        }
    }

    public void setRender(BaseRender aVar) {
        if (!PatchProxy.proxy(new Object[]{aVar}, this, f3667a, false, ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, new Class[]{BaseRender.class}, Void.TYPE).isSupported) {
            Log.i("camPreviewRenderView", "setRender   mRender " + aVar);
            this.f3755w = aVar;
            if (this.f3700aO != null) {
                this.f3700aO = aVar;
            }
        }
    }

    /* renamed from: d */
    public void mo14106d() {
        if (!PatchProxy.proxy(new Object[0], this, f3667a, false, 201, new Class[0], Void.TYPE).isSupported) {
            if (Build.VERSION.SDK_INT >= 29) {
                mo14107e();
            } else {
                synchronized (this.f3671H) {
                    Log.i("camPreviewRenderView", "CameraPreviewRenderView init ");
                    if (this.f3740h == null) {
                        try {
                            this.f3752t = EffectRenderContext.m4369h().mo14169a((PreviewView) this);
                            if (this.f3752t != null) {
                                EffectRenderContext.m4369h().mo14177a(this.f3752t);
                            }
                            if (f3666T == 1) {
                                Log.i("camPreviewRenderView", "has watch init ");
                                EffectRenderContext.m4369h().mo14225k(true);
                                this.f3740h = GLES20Utils.m4016a().newInstance(new Object[]{false});
                                EffectRenderContext.m4369h().mo14175a(this.f3740h);
                                Log.i("camPreviewRenderView", "newInstance SurfaceTexture:" + this.f3740h + "PreviewTexture:" + this.f3752t);
                                this.f3756x = false;
                            } else {
                                this.f3740h = EffectRenderContext.m4369h().mo14241y();
                                if (this.f3740h == null) {
                                    this.f3740h = GLES20Utils.m4016a().newInstance(new Object[]{false});
                                    EffectRenderContext.m4369h().mo14175a(this.f3740h);
                                    Log.i("camPreviewRenderView", "newInstance SurfaceTexture:" + this.f3740h + "PreviewTexture:" + this.f3752t);
                                    this.f3756x = false;
                                } else {
                                    Log.i("camPreviewRenderView", "useInstance SurfaceTexture:" + this.f3740h + "PreviewTexture:" + this.f3752t);
                                }
                            }
                            if (!EffectRenderContext.m4369h().mo14216g()) {
                                SurfaceTexture c = EffectRenderContext.m4369h().mo14198c();
                                this.f3741i = c;
                                if (c == null) {
                                    Log.i("camPreviewRenderView", " EffectRenderContext.getInstance().getNeedNewSurfaceTexture() is false mBitmapSurfaceTexture is null");
                                    this.f3741i = this.f3740h;
                                }
                            } else {
                                this.f3741i = this.f3740h;
                            }
                            f3666T++;
                            Log.i("camPreviewRenderView", "count:" + f3666T);
                            EffectRenderContext.m4369h().mo14178a((PreviewView) this, this.f3740h);
                            EffectRenderContext.m4369h().mo14200c(this.f3740h);
                            if (this.f3749q != null) {
                                this.f3749q.mo14347a(this.f3740h, this.f3744l, this.f3745m);
                            }
                        } catch (Exception e) {
                            Log.e("camPreviewRenderView", "error:" + e.getMessage());
                        }
                    } else if (this.f3749q != null) {
                        this.f3749q.mo14347a(this.f3740h, this.f3744l, this.f3745m);
                    }
                }
            }
            this.f3695aJ = false;
        }
    }

    /* renamed from: e */
    public void mo14107e() {
        if (!PatchProxy.proxy(new Object[0], this, f3667a, false, 202, new Class[0], Void.TYPE).isSupported) {
            synchronized (this.f3671H) {
                Log.i("camPreviewRenderView", "CameraPreviewRenderView init ");
                if (this.f3742j == null) {
                    try {
                        this.f3752t = EffectRenderContext.m4369h().mo14169a((PreviewView) this);
                        if (this.f3752t != null) {
                            EffectRenderContext.m4369h().mo14177a(this.f3752t);
                        }
                        if (f3666T == 1) {
                            Log.i("camPreviewRenderView", "has watch init ");
                            EffectRenderContext.m4369h().mo14225k(true);
                            this.f3742j = new SurfaceTextureWrapper(false);
                            EffectRenderContext.m4369h().mo14181a(this.f3742j);
                            Log.i("camPreviewRenderView", "newInstance SurfaceTexture:" + this.f3742j + "PreviewTexture:" + this.f3752t);
                            this.f3756x = false;
                        } else {
                            this.f3742j = EffectRenderContext.m4369h().mo14242z();
                            if (this.f3742j == null) {
                                this.f3742j = new SurfaceTextureWrapper(false);
                                EffectRenderContext.m4369h().mo14181a(this.f3742j);
                                Log.i("camPreviewRenderView", "newInstance SurfaceTexture:" + this.f3742j + "PreviewTexture:" + this.f3752t);
                                this.f3756x = false;
                            } else {
                                Log.i("camPreviewRenderView", "useInstance SurfaceTexture:" + this.f3742j + "PreviewTexture:" + this.f3752t);
                            }
                        }
                        if (!EffectRenderContext.m4369h().mo14216g()) {
                            SurfaceTextureWrapper d = EffectRenderContext.m4369h().mo14205d();
                            this.f3743k = d;
                            if (d == null) {
                                Log.i("camPreviewRenderView", " EffectRenderContext.getInstance().getNeedNewSurfaceTexture() is false mBitmapSurfaceTexture is null");
                                this.f3743k = this.f3742j;
                            }
                        } else {
                            this.f3743k = this.f3742j;
                        }
                        f3666T++;
                        Log.i("camPreviewRenderView", "count:" + f3666T);
                        EffectRenderContext.m4369h().mo14180a((PreviewView) this, this.f3742j);
                        EffectRenderContext.m4369h().mo14201c(this.f3742j);
                        if (this.f3750r != null) {
                            this.f3750r.mo14352a(this.f3742j, this.f3744l, this.f3745m);
                        }
                    } catch (Exception e) {
                        Log.e("camPreviewRenderView", "error:" + e.getMessage());
                    }
                } else if (this.f3750r != null) {
                    this.f3750r.mo14352a(this.f3742j, this.f3744l, this.f3745m);
                }
            }
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo14108f() {
        /*
            r8 = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            com.meizu.savior.ChangeQuickRedirect r3 = f3667a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 203(0xcb, float:2.84E-43)
            r2 = r8
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0016
            return
        L_0x0016:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 29
            if (r1 < r2) goto L_0x0021
            r8.mo14109g()
            goto L_0x00e9
        L_0x0021:
            java.lang.Object r1 = r8.f3671H
            monitor-enter(r1)
            java.lang.String r2 = "camPreviewRenderView"
            java.lang.String r3 = "resumeSurfaceTexture "
            android.util.Log.i(r2, r3)     // Catch:{ all -> 0x00ea }
            java.lang.reflect.Constructor r2 = com.meizu.camera.effectlib.effects.p058a.GLES20Utils.m4016a()     // Catch:{ Exception -> 0x00cd }
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x00cd }
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r0)     // Catch:{ Exception -> 0x00cd }
            r3[r0] = r4     // Catch:{ Exception -> 0x00cd }
            java.lang.Object r2 = r2.newInstance(r3)     // Catch:{ Exception -> 0x00cd }
            android.graphics.SurfaceTexture r2 = (android.graphics.SurfaceTexture) r2     // Catch:{ Exception -> 0x00cd }
            r8.f3740h = r2     // Catch:{ Exception -> 0x00cd }
            com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ Exception -> 0x00cd }
            android.graphics.SurfaceTexture r3 = r8.f3740h     // Catch:{ Exception -> 0x00cd }
            r2.mo14175a((android.graphics.SurfaceTexture) r3)     // Catch:{ Exception -> 0x00cd }
            java.lang.String r2 = "camPreviewRenderView"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00cd }
            r3.<init>()     // Catch:{ Exception -> 0x00cd }
            java.lang.String r4 = "newInstance SurfaceTexture:"
            r3.append(r4)     // Catch:{ Exception -> 0x00cd }
            android.graphics.SurfaceTexture r4 = r8.f3740h     // Catch:{ Exception -> 0x00cd }
            r3.append(r4)     // Catch:{ Exception -> 0x00cd }
            java.lang.String r4 = "PreviewTexture:"
            r3.append(r4)     // Catch:{ Exception -> 0x00cd }
            com.meizu.camera.effectlib.effects.a.c r4 = r8.f3752t     // Catch:{ Exception -> 0x00cd }
            r3.append(r4)     // Catch:{ Exception -> 0x00cd }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00cd }
            android.util.Log.i(r2, r3)     // Catch:{ Exception -> 0x00cd }
            r8.f3756x = r0     // Catch:{ Exception -> 0x00cd }
            com.meizu.camera.effectlib.effects.views.EffectRenderContext r0 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ Exception -> 0x00cd }
            boolean r0 = r0.mo14216g()     // Catch:{ Exception -> 0x00cd }
            if (r0 != 0) goto L_0x008f
            com.meizu.camera.effectlib.effects.views.EffectRenderContext r0 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ Exception -> 0x00cd }
            android.graphics.SurfaceTexture r0 = r0.mo14198c()     // Catch:{ Exception -> 0x00cd }
            r8.f3741i = r0     // Catch:{ Exception -> 0x00cd }
            if (r0 != 0) goto L_0x0093
            java.lang.String r0 = "camPreviewRenderView"
            java.lang.String r2 = " EffectRenderContext.getInstance().getNeedNewSurfaceTexture() is false mBitmapSurfaceTexture is null"
            android.util.Log.e(r0, r2)     // Catch:{ Exception -> 0x00cd }
            android.graphics.SurfaceTexture r0 = r8.f3740h     // Catch:{ Exception -> 0x00cd }
            r8.f3741i = r0     // Catch:{ Exception -> 0x00cd }
            goto L_0x0093
        L_0x008f:
            android.graphics.SurfaceTexture r0 = r8.f3740h     // Catch:{ Exception -> 0x00cd }
            r8.f3741i = r0     // Catch:{ Exception -> 0x00cd }
        L_0x0093:
            java.lang.String r0 = "camPreviewRenderView"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00cd }
            r2.<init>()     // Catch:{ Exception -> 0x00cd }
            java.lang.String r3 = "count:"
            r2.append(r3)     // Catch:{ Exception -> 0x00cd }
            int r3 = f3666T     // Catch:{ Exception -> 0x00cd }
            r2.append(r3)     // Catch:{ Exception -> 0x00cd }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00cd }
            android.util.Log.i(r0, r2)     // Catch:{ Exception -> 0x00cd }
            com.meizu.camera.effectlib.effects.views.EffectRenderContext r0 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ Exception -> 0x00cd }
            android.graphics.SurfaceTexture r2 = r8.f3740h     // Catch:{ Exception -> 0x00cd }
            r0.mo14178a((com.meizu.camera.effectlib.effects.views.PreviewView) r8, (android.graphics.SurfaceTexture) r2)     // Catch:{ Exception -> 0x00cd }
            com.meizu.camera.effectlib.effects.views.EffectRenderContext r0 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ Exception -> 0x00cd }
            android.graphics.SurfaceTexture r2 = r8.f3740h     // Catch:{ Exception -> 0x00cd }
            r0.mo14200c((android.graphics.SurfaceTexture) r2)     // Catch:{ Exception -> 0x00cd }
            com.meizu.camera.effectlib.effects.views.c$c r0 = r8.f3749q     // Catch:{ Exception -> 0x00cd }
            if (r0 == 0) goto L_0x00e8
            com.meizu.camera.effectlib.effects.views.c$c r0 = r8.f3749q     // Catch:{ Exception -> 0x00cd }
            android.graphics.SurfaceTexture r2 = r8.f3740h     // Catch:{ Exception -> 0x00cd }
            int r3 = r8.f3744l     // Catch:{ Exception -> 0x00cd }
            int r4 = r8.f3745m     // Catch:{ Exception -> 0x00cd }
            r0.mo14347a(r2, r3, r4)     // Catch:{ Exception -> 0x00cd }
            goto L_0x00e8
        L_0x00cd:
            r0 = move-exception
            java.lang.String r2 = "camPreviewRenderView"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ea }
            r3.<init>()     // Catch:{ all -> 0x00ea }
            java.lang.String r4 = "error:"
            r3.append(r4)     // Catch:{ all -> 0x00ea }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x00ea }
            r3.append(r0)     // Catch:{ all -> 0x00ea }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x00ea }
            android.util.Log.e(r2, r0)     // Catch:{ all -> 0x00ea }
        L_0x00e8:
            monitor-exit(r1)     // Catch:{ all -> 0x00ea }
        L_0x00e9:
            return
        L_0x00ea:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00ea }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.mo14108f():void");
    }

    /* renamed from: g */
    public void mo14109g() {
        if (!PatchProxy.proxy(new Object[0], this, f3667a, false, MeizuCamera.TEMPERATURE_CLOSE_RECORD_NOTIFY, new Class[0], Void.TYPE).isSupported) {
            synchronized (this.f3671H) {
                Log.i("camPreviewRenderView", "resumeSurfaceTextureWrapper ");
                try {
                    this.f3742j = new SurfaceTextureWrapper(false);
                    EffectRenderContext.m4369h().mo14181a(this.f3742j);
                    Log.i("camPreviewRenderView", "newInstance SurfaceTexture:" + this.f3742j + "PreviewTexture:" + this.f3752t);
                    this.f3756x = false;
                    this.f3743k = this.f3742j;
                    Log.i("camPreviewRenderView", "count:" + f3666T);
                    EffectRenderContext.m4369h().mo14180a((PreviewView) this, this.f3742j);
                    EffectRenderContext.m4369h().mo14201c(this.f3742j);
                    if (this.f3750r != null) {
                        this.f3750r.mo14352a(this.f3742j, this.f3744l, this.f3745m);
                    }
                } catch (Exception e) {
                    Log.e("camPreviewRenderView", "error:" + e.getMessage());
                }
            }
        }
    }

    /* renamed from: h */
    public void mo14116h() {
        if (!PatchProxy.proxy(new Object[0], this, f3667a, false, MeizuCamera.TEMPERATURE_CLOSE_CAMERA_NOTIFY, new Class[0], Void.TYPE).isSupported) {
            Log.i("camPreviewRenderView", "release --> invoke:" + this + " context" + getContext());
            this.f3734b.invoke(true);
        }
    }

    /* renamed from: i */
    public void mo14117i() {
        if (!PatchProxy.proxy(new Object[0], this, f3667a, false, 206, new Class[0], Void.TYPE).isSupported) {
            Log.i("camPreviewRenderView", "releaseframeBuffer --> invoke:" + this + " context" + getContext());
            this.f3739g.invoke(true);
        }
    }

    /* renamed from: j */
    public void mo14118j() {
        if (!PatchProxy.proxy(new Object[0], this, f3667a, false, 207, new Class[0], Void.TYPE).isSupported) {
            Log.i("camPreviewRenderView", "releaseSurfaceTexture --> invoke");
            if (Build.VERSION.SDK_INT >= 29) {
                this.f3737e.invoke(true);
            } else {
                this.f3735c.invoke(true);
            }
        }
    }

    /* renamed from: k */
    public void mo14119k() {
        if (!PatchProxy.proxy(new Object[0], this, f3667a, false, 208, new Class[0], Void.TYPE).isSupported) {
            Log.i("camPreviewRenderView", "onResume");
            this.f3695aJ = false;
            synchronized (this.f3671H) {
                if (this.f3754v != null) {
                    if (!(this.f3755w == null || this.f3755w.mo14046c() == null || EffectRenderContext.m4369h().mo14197b(this.f3755w.mo14046c().mo14345d()))) {
                        this.f3755w = this.f3754v.mo14319a(this.f3755w.mo14046c());
                    }
                    if (!(this.f3700aO == null || this.f3700aO.mo14046c() == null || EffectRenderContext.m4369h().mo14197b(this.f3700aO.mo14046c().mo14345d()))) {
                        this.f3700aO = this.f3754v.mo14319a(this.f3700aO.mo14046c());
                    }
                }
            }
            this.f3707aV = true;
        }
    }

    /* renamed from: l */
    public void mo14120l() {
        if (!PatchProxy.proxy(new Object[0], this, f3667a, false, 209, new Class[0], Void.TYPE).isSupported) {
            Log.i("camPreviewRenderView", "onPause");
            this.f3695aJ = true;
            if (Build.VERSION.SDK_INT >= 29) {
                this.f3738f.invoke(false);
            } else {
                this.f3736d.invoke(false);
            }
        }
    }

    /* renamed from: a */
    public void mo14102a(boolean z, boolean z2) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f3667a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 210, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            Log.i("camPreviewRenderView", "enableDraw :" + z);
            this.f3696aK = z;
            if (!z2) {
                return;
            }
            if (this.f3696aK) {
                setViewAlpha(1.0f);
            } else {
                setViewAlpha(0.0f);
            }
        }
    }

    public void layout(int i, int i2, int i3, int i4) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4)}, this, f3667a, false, 211, new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            super.layout(i, i2, i3, i4);
            this.f3744l = getWidth();
            this.f3745m = getHeight();
            Log.v("camPreviewRenderView", "layout:" + this.f3744l + "x" + this.f3745m);
            EffectRenderContext.m4369h().mo14191b(this.f3744l, this.f3745m);
            invalidate();
        }
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4)}, this, f3667a, false, 212, new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            super.onSizeChanged(i, i2, i3, i4);
            Log.v("camPreviewRenderView", "onSizeChanged:" + i + "x" + i2 + " old" + i3 + "x" + i4);
            if (!(this.f3740h == null || this.f3749q == null)) {
                this.f3749q.mo14350b(this.f3740h, getWidth(), getHeight());
            }
            if (this.f3742j != null && this.f3750r != null) {
                this.f3750r.mo14354b(this.f3742j, getWidth(), getHeight());
            }
        }
    }

    public void onDraw(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f3667a, false, 213, new Class[]{Canvas.class}, Void.TYPE).isSupported && EffectRenderContext.m4369h().mo14238v()) {
            this.f3747o.draw(canvas);
        }
    }

    /* renamed from: m */
    public void mo14122m() {
        if (!PatchProxy.proxy(new Object[0], this, f3667a, false, 214, new Class[0], Void.TYPE).isSupported) {
            super.invalidate();
        }
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.f3740h;
    }

    public void setTransform(float[] fArr) {
        if (!PatchProxy.proxy(new Object[]{fArr}, this, f3667a, false, 215, new Class[]{float[].class}, Void.TYPE).isSupported && fArr != null && fArr.length >= this.f3668E.length) {
            System.arraycopy(fArr, 0, this.f3668E, 0, this.f3668E.length);
            System.arraycopy(fArr, 0, this.f3691aF, 0, this.f3691aF.length);
            System.arraycopy(fArr, 0, this.f3692aG, 0, this.f3692aG.length);
            Matrix.rotateM(this.f3691aF, 0, 180.0f, 0.0f, 1.0f, 0.0f);
            Matrix.rotateM(this.f3691aF, 0, 90.0f, 0.0f, 0.0f, 1.0f);
            Matrix.rotateM(this.f3692aG, 0, 90.0f, 0.0f, 0.0f, 1.0f);
            Matrix.rotateM(this.f3692aG, 0, 180.0f, 0.0f, 0.0f, 1.0f);
        }
    }

    public void setTransformParms(float f, float f2, float f3) {
        Object[] objArr = {new Float(f), new Float(f2), new Float(f3)};
        ChangeQuickRedirect changeQuickRedirect = f3667a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 216, new Class[]{Float.TYPE, Float.TYPE, Float.TYPE}, Void.TYPE).isSupported) {
            this.f3704aS = f;
            this.f3705aT = f2;
            this.f3706aU = f3;
            Log.v("camPreviewRenderView", "setTransformParms: mScaleX " + this.f3704aS + " mScaleY: " + this.f3705aT + " py:" + f3);
        }
    }

    /* renamed from: a */
    public void mo14103a(float[] fArr) {
        if (!PatchProxy.proxy(new Object[]{fArr}, this, f3667a, false, 217, new Class[]{float[].class}, Void.TYPE).isSupported && fArr != null && fArr.length >= this.f3668E.length) {
            System.arraycopy(this.f3668E, 0, fArr, 0, this.f3668E.length);
        }
    }

    public BaseRender getRender() {
        return this.f3755w;
    }

    public BaseRender getVfbRender() {
        return this.f3700aO;
    }

    public Bitmap getPreviewBitmap() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f3667a, false, 218, new Class[0], Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        synchronized (this.f3671H) {
            if (this.f3678O == null || this.f3678O.isRecycled()) {
                return null;
            }
            Bitmap bitmap = this.f3678O;
            return bitmap;
        }
    }

    /* renamed from: a */
    public Bitmap mo14099a(int i, int i2) {
        Bitmap bitmap;
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f3667a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 219, new Class[]{Integer.TYPE, Integer.TYPE}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        synchronized (this.f3671H) {
            bitmap = null;
            if (this.f3678O != null && !this.f3678O.isRecycled()) {
                bitmap = Bitmap.createScaledBitmap(this.f3678O, i, i2, false);
            }
        }
        return bitmap;
    }

    public void setRenderTranslationY(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f3667a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 220, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f3746n = i;
            invalidate();
        }
    }

    public int getViewWidth() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f3667a, false, 221, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : getWidth();
    }

    public int getViewHeight() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f3667a, false, 222, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : getHeight();
    }

    public void setViewAlpha(float f) {
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f3667a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 223, new Class[]{Float.TYPE}, Void.TYPE).isSupported) {
            setAlpha(f);
        }
    }

    public void setBokehStatus(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f3667a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 224, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            synchronized (this.f3671H) {
                Log.v("camPreviewRenderView", "setBokehStatus:" + z);
                if (!z) {
                    if (this.f3748p != null) {
                        this.f3748p.removeMessages(3);
                    }
                    this.f3684V = z;
                    this.f3708aa = z;
                } else if (this.f3748p != null) {
                    this.f3748p.sendEmptyMessageDelayed(3, 200);
                }
            }
            if (!z) {
                synchronized (this.f3672I) {
                    if (this.f3710ac != null) {
                        this.f3710ac = null;
                    }
                }
            }
        }
    }

    public void setTofStatus(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f3667a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 225, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            synchronized (this.f3671H) {
                Log.v("camPreviewRenderView", "setTofStatus:" + z);
                if (!z) {
                    if (this.f3748p != null) {
                        this.f3748p.removeMessages(4);
                    }
                    this.f3685W = z;
                } else if (this.f3748p != null) {
                    this.f3748p.sendEmptyMessageDelayed(4, 100);
                }
            }
            if (!z) {
                synchronized (this.f3672I) {
                    if (this.f3710ac != null) {
                        this.f3710ac = null;
                    }
                }
            }
        }
    }

    public void setShowBitmap(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f3667a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 226, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            Log.v("camPreviewRenderView", "setShowBitmap:" + z);
            this.f3709ab = z;
            if (!this.f3709ab) {
                synchronized (this.f3672I) {
                    if (this.f3713af != null) {
                        this.f3713af.recycle();
                        this.f3713af = null;
                    }
                }
            }
        }
    }

    public void setYuvInput(boolean z) {
        this.f3708aa = z;
    }

    public void setPreviewData(byte[] bArr, int i, int i2, int i3) {
        Object[] objArr = {bArr, new Integer(i), new Integer(i2), new Integer(i3)};
        ChangeQuickRedirect changeQuickRedirect = f3667a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 227, new Class[]{byte[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            synchronized (this.f3672I) {
                if (this.f3710ac == null) {
                    Log.v("camPreviewRenderView", "setPreviewData:" + i + "x" + i2 + "rowstride " + i3);
                    this.f3710ac = new byte[(((i3 * i2) * 3) / 2)];
                    this.f3711ad = i;
                    this.f3712ae = i2;
                    this.f3714ag = i3;
                } else if (!(this.f3711ad == i && this.f3712ae == i2)) {
                    Log.v("camPreviewRenderView", "setPreviewData:" + i + "x" + i2 + "rowstride " + i3);
                    this.f3710ac = new byte[(((i3 * i2) * 3) / 2)];
                    this.f3711ad = i;
                    this.f3712ae = i2;
                    this.f3714ag = i3;
                }
                System.arraycopy(bArr, 0, this.f3710ac, 0, this.f3710ac.length);
            }
        }
    }

    public void setPreviewBitmap(Bitmap bitmap, int i, int i2) {
        if (!PatchProxy.proxy(new Object[]{bitmap, new Integer(i), new Integer(i2)}, this, f3667a, false, 228, new Class[]{Bitmap.class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            synchronized (this.f3672I) {
                if (this.f3713af != null && !this.f3713af.isRecycled()) {
                    this.f3713af.recycle();
                }
                this.f3713af = bitmap;
                this.f3711ad = i;
                this.f3712ae = i2;
            }
        }
    }

    public void setBokehListener(PreviewView.C1192a aVar) {
        this.f3751s = aVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public void m4330s() {
        if (!PatchProxy.proxy(new Object[0], this, f3667a, false, 229, new Class[0], Void.TYPE).isSupported) {
            Log.v("camPreviewRenderView", "initRenderProgram");
            this.f3715ah.mo14359a();
            this.f3717aj = true;
            if (this.f3719al == -1) {
                this.f3719al = this.f3715ah.mo14369i();
            }
            if (this.f3720am == -1) {
                this.f3720am = this.f3715ah.mo14369i();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: t */
    public void m4332t() {
        if (!PatchProxy.proxy(new Object[0], this, f3667a, false, 230, new Class[0], Void.TYPE).isSupported) {
            Log.v("camPreviewRenderView", "initDepthRenderProgram");
            this.f3716ai.mo14311f();
            if (this.f3690aE == -1) {
                this.f3690aE = this.f3716ai.mo14314i();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public void m4333u() {
        if (!PatchProxy.proxy(new Object[0], this, f3667a, false, 231, new Class[0], Void.TYPE).isSupported) {
            Log.v("camPreviewRenderView", "setupBuffers");
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            this.f3697aL = iArr[0];
            GLES20.glBindFramebuffer(36160, this.f3697aL);
            if (this.f3698aM != null) {
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f3698aM.mo14028a(), 0);
            }
            mo14101a("glFrameBufferTexture2D");
            m4336v();
            mo14101a("glClear setupBuffers");
            GLES20.glBindFramebuffer(36160, 0);
        }
    }

    /* renamed from: v */
    private void m4336v() {
        if (!PatchProxy.proxy(new Object[0], this, f3667a, false, 232, new Class[0], Void.TYPE).isSupported) {
            int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
            mo14101a("glCheckFramebufferStatus");
            if (glCheckFramebufferStatus == 36057) {
                Log.e("camPreviewRenderView", "incomplete dimensions");
            } else if (glCheckFramebufferStatus != 36061) {
                switch (glCheckFramebufferStatus) {
                    case 36053:
                        Log.e("camPreviewRenderView", "complete");
                        return;
                    case 36054:
                        Log.e("camPreviewRenderView", "incomplete attachment");
                        return;
                    case 36055:
                        Log.e("camPreviewRenderView", "incomplete missing attachment");
                        return;
                    default:
                        Log.e("camPreviewRenderView", "default");
                        return;
                }
            } else {
                Log.e("camPreviewRenderView", "framebuffer unsupported");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: w */
    public void m4337w() {
        if (this.f3697aL != -1) {
            this.f3697aL = -1;
        }
    }

    /* renamed from: a */
    public void mo14101a(String str) {
        int eglGetError;
        if (!PatchProxy.proxy(new Object[]{str}, this, f3667a, false, 233, new Class[]{String.class}, Void.TYPE).isSupported && (eglGetError = EGL14.eglGetError()) != 12288) {
            Log.e("camPreviewRenderView", str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
            throw new IllegalStateException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
        }
    }

    public void setCleanScreen(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f3667a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 234, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            Log.i("camPreviewRenderView", "setCleanScreen: " + z);
            this.f3701aP = z;
        }
    }

    /* renamed from: com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView$a */
    protected class C1169a extends DrawGLFunctor {

        /* renamed from: a */
        public static ChangeQuickRedirect f3759a;

        public C1169a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:283:0x08e4, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onDraw(com.meizu.common.renderer.functor.DrawGLFunctor.GLInfo r18) {
            /*
                r17 = this;
                r8 = r17
                r9 = 1
                java.lang.Object[] r1 = new java.lang.Object[r9]
                r10 = 0
                r1[r10] = r18
                com.meizu.savior.ChangeQuickRedirect r3 = f3759a
                java.lang.Class[] r6 = new java.lang.Class[r9]
                java.lang.Class<com.meizu.common.renderer.functor.DrawGLFunctor$GLInfo> r2 = com.meizu.common.renderer.functor.DrawGLFunctor.GLInfo.class
                r6[r10] = r2
                java.lang.Class r7 = java.lang.Void.TYPE
                r4 = 0
                r5 = 242(0xf2, float:3.39E-43)
                r2 = r17
                com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                boolean r1 = r1.isSupported
                if (r1 == 0) goto L_0x0020
                return
            L_0x0020:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                boolean r1 = r1.f3707aV
                if (r1 == 0) goto L_0x0038
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                boolean unused = r1.f3707aV = r10
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r1 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()
                android.opengl.EGLContext r2 = android.opengl.EGL14.eglGetCurrentContext()
                r1.mo14176a((android.opengl.EGLContext) r2)
            L_0x0038:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                java.lang.Object r1 = r1.f3671H
                monitor-enter(r1)
                r2 = 0
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                java.util.Vector r3 = r3.f3758z     // Catch:{ all -> 0x08e5 }
                if (r3 == 0) goto L_0x0060
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                java.util.Vector r3 = r3.f3758z     // Catch:{ all -> 0x08e5 }
                boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x08e5 }
                if (r3 != 0) goto L_0x0060
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                java.util.Vector r2 = r2.f3758z     // Catch:{ all -> 0x08e5 }
                java.lang.Object r2 = r2.remove(r10)     // Catch:{ all -> 0x08e5 }
                java.lang.Runnable r2 = (java.lang.Runnable) r2     // Catch:{ all -> 0x08e5 }
            L_0x0060:
                if (r2 == 0) goto L_0x0065
                r2.run()     // Catch:{ all -> 0x08e5 }
            L_0x0065:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.b r2 = r2.f3754v     // Catch:{ all -> 0x08e5 }
                if (r2 != 0) goto L_0x006f
                monitor-exit(r1)     // Catch:{ all -> 0x08e5 }
                return
            L_0x006f:
                int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x08e5 }
                r3 = 29
                if (r2 < r3) goto L_0x00c4
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.imageproc.SurfaceTextureWrapper r2 = r2.f3742j     // Catch:{ all -> 0x08e5 }
                if (r2 != 0) goto L_0x007f
                monitor-exit(r1)     // Catch:{ all -> 0x08e5 }
                return
            L_0x007f:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                boolean r2 = r2.f3695aJ     // Catch:{ all -> 0x08e5 }
                if (r2 == 0) goto L_0x00a5
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
                boolean r2 = r2.f3756x     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
                if (r2 == 0) goto L_0x0098
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
                com.meizu.imageproc.SurfaceTextureWrapper r2 = r2.f3742j     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
                r2.updateTexImage()     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
            L_0x0098:
                java.lang.String r2 = "camPreviewRenderView"
                java.lang.String r3 = "app has been background ,not to draw ,return "
                android.util.Log.i(r2, r3)     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
                goto L_0x00a3
            L_0x00a0:
                r0 = move-exception
                r2 = r0
                throw r2     // Catch:{ all -> 0x08e5 }
            L_0x00a3:
                monitor-exit(r1)     // Catch:{ all -> 0x08e5 }
                return
            L_0x00a5:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                boolean r2 = r2.f3696aK     // Catch:{ all -> 0x08e5 }
                if (r2 != 0) goto L_0x0113
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ Exception -> 0x00c2, all -> 0x00bf }
                boolean r2 = r2.f3756x     // Catch:{ Exception -> 0x00c2, all -> 0x00bf }
                if (r2 == 0) goto L_0x00c2
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ Exception -> 0x00c2, all -> 0x00bf }
                com.meizu.imageproc.SurfaceTextureWrapper r2 = r2.f3742j     // Catch:{ Exception -> 0x00c2, all -> 0x00bf }
                r2.updateTexImage()     // Catch:{ Exception -> 0x00c2, all -> 0x00bf }
                goto L_0x00c2
            L_0x00bf:
                r0 = move-exception
                r2 = r0
                throw r2     // Catch:{ all -> 0x08e5 }
            L_0x00c2:
                monitor-exit(r1)     // Catch:{ all -> 0x08e5 }
                return
            L_0x00c4:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                android.graphics.SurfaceTexture r2 = r2.f3740h     // Catch:{ all -> 0x08e5 }
                if (r2 != 0) goto L_0x00ce
                monitor-exit(r1)     // Catch:{ all -> 0x08e5 }
                return
            L_0x00ce:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                boolean r2 = r2.f3695aJ     // Catch:{ all -> 0x08e5 }
                if (r2 == 0) goto L_0x00f4
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ Exception -> 0x00f2, all -> 0x00ef }
                boolean r2 = r2.f3756x     // Catch:{ Exception -> 0x00f2, all -> 0x00ef }
                if (r2 == 0) goto L_0x00e7
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ Exception -> 0x00f2, all -> 0x00ef }
                android.graphics.SurfaceTexture r2 = r2.f3740h     // Catch:{ Exception -> 0x00f2, all -> 0x00ef }
                r2.updateTexImage()     // Catch:{ Exception -> 0x00f2, all -> 0x00ef }
            L_0x00e7:
                java.lang.String r2 = "camPreviewRenderView"
                java.lang.String r3 = "app has been background ,not to draw ,return "
                android.util.Log.i(r2, r3)     // Catch:{ Exception -> 0x00f2, all -> 0x00ef }
                goto L_0x00f2
            L_0x00ef:
                r0 = move-exception
                r2 = r0
                throw r2     // Catch:{ all -> 0x08e5 }
            L_0x00f2:
                monitor-exit(r1)     // Catch:{ all -> 0x08e5 }
                return
            L_0x00f4:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                boolean r2 = r2.f3696aK     // Catch:{ all -> 0x08e5 }
                if (r2 != 0) goto L_0x0113
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ Exception -> 0x0111, all -> 0x010e }
                boolean r2 = r2.f3756x     // Catch:{ Exception -> 0x0111, all -> 0x010e }
                if (r2 == 0) goto L_0x0111
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ Exception -> 0x0111, all -> 0x010e }
                android.graphics.SurfaceTexture r2 = r2.f3740h     // Catch:{ Exception -> 0x0111, all -> 0x010e }
                r2.updateTexImage()     // Catch:{ Exception -> 0x0111, all -> 0x010e }
                goto L_0x0111
            L_0x010e:
                r0 = move-exception
                r2 = r0
                throw r2     // Catch:{ all -> 0x08e5 }
            L_0x0111:
                monitor-exit(r1)     // Catch:{ all -> 0x08e5 }
                return
            L_0x0113:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.a.c r2 = r2.f3752t     // Catch:{ all -> 0x08e5 }
                if (r2 != 0) goto L_0x01b1
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r4 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r5 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.a.c r4 = r4.mo14169a((com.meizu.camera.effectlib.effects.views.PreviewView) r5)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.p058a.GLTexture unused = r2.f3752t = r4     // Catch:{ all -> 0x08e5 }
                int[] r2 = new int[r9]     // Catch:{ all -> 0x08e5 }
                int r4 = r2.length     // Catch:{ all -> 0x08e5 }
                android.opengl.GLES20.glGenTextures(r4, r2, r10)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r4 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.a.c r4 = r4.f3752t     // Catch:{ all -> 0x08e5 }
                if (r4 != 0) goto L_0x0191
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r4 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.a.c r5 = new com.meizu.camera.effectlib.effects.a.c     // Catch:{ all -> 0x08e5 }
                r2 = r2[r10]     // Catch:{ all -> 0x08e5 }
                r6 = 36197(0x8d65, float:5.0723E-41)
                r5.<init>(r2, r6)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.p058a.GLTexture unused = r4.f3752t = r5     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r4 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.a.c r4 = r4.f3752t     // Catch:{ all -> 0x08e5 }
                r2.mo14177a((com.meizu.camera.effectlib.effects.p058a.GLTexture) r4)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r4 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r5 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.a.c r5 = r5.f3752t     // Catch:{ all -> 0x08e5 }
                r2.mo14179a((com.meizu.camera.effectlib.effects.views.PreviewView) r4, (com.meizu.camera.effectlib.effects.p058a.GLTexture) r5)     // Catch:{ all -> 0x08e5 }
                java.lang.String r2 = "camPreviewRenderView"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x08e5 }
                r4.<init>()     // Catch:{ all -> 0x08e5 }
                java.lang.String r5 = "onDraw create id "
                r4.append(r5)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r5 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.a.c r5 = r5.f3752t     // Catch:{ all -> 0x08e5 }
                int r5 = r5.mo14028a()     // Catch:{ all -> 0x08e5 }
                r4.append(r5)     // Catch:{ all -> 0x08e5 }
                java.lang.String r5 = " mPreviewTexture "
                r4.append(r5)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r5 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.a.c r5 = r5.f3752t     // Catch:{ all -> 0x08e5 }
                r4.append(r5)     // Catch:{ all -> 0x08e5 }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x08e5 }
                android.util.Log.i(r2, r4)     // Catch:{ all -> 0x08e5 }
            L_0x0191:
                java.lang.String r2 = "camPreviewRenderView"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x08e5 }
                r4.<init>()     // Catch:{ all -> 0x08e5 }
                java.lang.String r5 = "onDrRaw create id "
                r4.append(r5)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r5 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.a.c r5 = r5.f3752t     // Catch:{ all -> 0x08e5 }
                int r5 = r5.mo14028a()     // Catch:{ all -> 0x08e5 }
                r4.append(r5)     // Catch:{ all -> 0x08e5 }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x08e5 }
                android.util.Log.i(r2, r4)     // Catch:{ all -> 0x08e5 }
            L_0x01b1:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                boolean r2 = r2.f3677N     // Catch:{ all -> 0x08e5 }
                if (r2 == 0) goto L_0x021a
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.a.c r2 = r2.f3698aM     // Catch:{ all -> 0x08e5 }
                if (r2 != 0) goto L_0x021a
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r4 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                int r4 = r4.f3744l     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r5 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                int r5 = r5.f3745m     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.a.c r4 = com.meizu.camera.effectlib.effects.p058a.GLTexture.m4033a(r4, r5)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.p058a.GLTexture unused = r2.f3698aM = r4     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.a.c r2 = r2.f3698aM     // Catch:{ all -> 0x08e5 }
                if (r2 == 0) goto L_0x021a
                java.lang.String r2 = "camPreviewRenderView"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x08e5 }
                r4.<init>()     // Catch:{ all -> 0x08e5 }
                java.lang.String r5 = "onDraw create mShareTextureid "
                r4.append(r5)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r5 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.a.c r5 = r5.f3698aM     // Catch:{ all -> 0x08e5 }
                int r5 = r5.mo14028a()     // Catch:{ all -> 0x08e5 }
                r4.append(r5)     // Catch:{ all -> 0x08e5 }
                java.lang.String r5 = " size "
                r4.append(r5)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r5 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                int r5 = r5.f3744l     // Catch:{ all -> 0x08e5 }
                r4.append(r5)     // Catch:{ all -> 0x08e5 }
                java.lang.String r5 = "x"
                r4.append(r5)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r5 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                int r5 = r5.f3745m     // Catch:{ all -> 0x08e5 }
                r4.append(r5)     // Catch:{ all -> 0x08e5 }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x08e5 }
                android.util.Log.i(r2, r4)     // Catch:{ all -> 0x08e5 }
            L_0x021a:
                int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x08e5 }
                if (r2 < r3) goto L_0x0343
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                boolean r2 = r2.f3756x     // Catch:{ all -> 0x08e5 }
                if (r2 != 0) goto L_0x0297
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.imageproc.SurfaceTextureWrapper r3 = r3.f3742j     // Catch:{ all -> 0x08e5 }
                boolean r2 = r2.mo14196b((com.meizu.imageproc.SurfaceTextureWrapper) r3)     // Catch:{ all -> 0x08e5 }
                if (r2 != 0) goto L_0x023b
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                r2.mo14109g()     // Catch:{ all -> 0x08e5 }
            L_0x023b:
                java.lang.String r2 = "glrenderer"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x026b }
                r3.<init>()     // Catch:{ Exception -> 0x026b }
                java.lang.String r4 = "attachToGLContext:"
                r3.append(r4)     // Catch:{ Exception -> 0x026b }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r4 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ Exception -> 0x026b }
                com.meizu.imageproc.SurfaceTextureWrapper r4 = r4.f3742j     // Catch:{ Exception -> 0x026b }
                r3.append(r4)     // Catch:{ Exception -> 0x026b }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x026b }
                android.util.Log.i(r2, r3)     // Catch:{ Exception -> 0x026b }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ Exception -> 0x026b }
                com.meizu.imageproc.SurfaceTextureWrapper r2 = r2.f3742j     // Catch:{ Exception -> 0x026b }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ Exception -> 0x026b }
                com.meizu.camera.effectlib.effects.a.c r3 = r3.f3752t     // Catch:{ Exception -> 0x026b }
                int r3 = r3.mo14028a()     // Catch:{ Exception -> 0x026b }
                r2.attachToGLContext(r3)     // Catch:{ Exception -> 0x026b }
                goto L_0x0287
            L_0x026b:
                r0 = move-exception
                r2 = r0
                java.lang.String r3 = "glrenderer"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x08e5 }
                r4.<init>()     // Catch:{ all -> 0x08e5 }
                java.lang.String r5 = "error:"
                r4.append(r5)     // Catch:{ all -> 0x08e5 }
                java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x08e5 }
                r4.append(r2)     // Catch:{ all -> 0x08e5 }
                java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x08e5 }
                android.util.Log.e(r3, r2)     // Catch:{ all -> 0x08e5 }
            L_0x0287:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.imageproc.SurfaceTextureWrapper r2 = r2.f3742j     // Catch:{ all -> 0x08e5 }
                r2.updateTexImage()     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                boolean unused = r2.f3756x = r9     // Catch:{ all -> 0x08e5 }
                monitor-exit(r1)     // Catch:{ all -> 0x08e5 }
                return
            L_0x0297:
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.imageproc.SurfaceTextureWrapper r3 = r3.f3742j     // Catch:{ all -> 0x08e5 }
                boolean r2 = r2.mo14196b((com.meizu.imageproc.SurfaceTextureWrapper) r3)     // Catch:{ all -> 0x08e5 }
                if (r2 != 0) goto L_0x02ae
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                r2.mo14108f()     // Catch:{ all -> 0x08e5 }
                monitor-exit(r1)     // Catch:{ all -> 0x08e5 }
                return
            L_0x02ae:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.imageproc.SurfaceTextureWrapper r2 = r2.f3742j     // Catch:{ all -> 0x08e5 }
                r2.updateTexImage()     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.imageproc.SurfaceTextureWrapper r2 = r2.f3742j     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                float[] r3 = r3.f3670G     // Catch:{ all -> 0x08e5 }
                r2.getTransformMatrix(r3)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x08e5 }
                boolean r2 = r2.mo14216g()     // Catch:{ all -> 0x08e5 }
                if (r2 != 0) goto L_0x0319
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r3 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r4 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.a.c r3 = r3.mo14169a((com.meizu.camera.effectlib.effects.views.PreviewView) r4)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.p058a.GLTexture unused = r2.f3752t = r3     // Catch:{ all -> 0x08e5 }
                java.lang.String r2 = "CameraGLOnDraw"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x08e5 }
                r3.<init>()     // Catch:{ all -> 0x08e5 }
                java.lang.String r4 = "getGLTexture "
                r3.append(r4)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r4 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.a.c r4 = r4.f3752t     // Catch:{ all -> 0x08e5 }
                r3.append(r4)     // Catch:{ all -> 0x08e5 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x08e5 }
                android.util.Log.i(r2, r3)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.a.c r2 = r2.f3752t     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r3 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.a.c r3 = r3.mo14156A()     // Catch:{ all -> 0x08e5 }
                if (r2 == r3) goto L_0x0324
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.a.c r3 = r3.f3752t     // Catch:{ all -> 0x08e5 }
                r2.mo14177a((com.meizu.camera.effectlib.effects.p058a.GLTexture) r3)     // Catch:{ all -> 0x08e5 }
                goto L_0x0324
            L_0x0319:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.imageproc.SurfaceTextureWrapper r3 = r3.f3742j     // Catch:{ all -> 0x08e5 }
                com.meizu.imageproc.SurfaceTextureWrapper unused = r2.f3743k = r3     // Catch:{ all -> 0x08e5 }
            L_0x0324:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.imageproc.SurfaceTextureWrapper r2 = r2.f3742j     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r3 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x08e5 }
                com.meizu.imageproc.SurfaceTextureWrapper r3 = r3.mo14242z()     // Catch:{ all -> 0x08e5 }
                if (r2 == r3) goto L_0x0466
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.imageproc.SurfaceTextureWrapper r3 = r3.f3742j     // Catch:{ all -> 0x08e5 }
                r2.mo14201c((com.meizu.imageproc.SurfaceTextureWrapper) r3)     // Catch:{ all -> 0x08e5 }
                goto L_0x0466
            L_0x0343:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                boolean r2 = r2.f3756x     // Catch:{ all -> 0x08e5 }
                if (r2 != 0) goto L_0x03bc
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                android.graphics.SurfaceTexture r3 = r3.f3740h     // Catch:{ all -> 0x08e5 }
                boolean r2 = r2.mo14195b((android.graphics.SurfaceTexture) r3)     // Catch:{ all -> 0x08e5 }
                if (r2 != 0) goto L_0x0360
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                r2.mo14108f()     // Catch:{ all -> 0x08e5 }
            L_0x0360:
                java.lang.String r2 = "glrenderer"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0390 }
                r3.<init>()     // Catch:{ Exception -> 0x0390 }
                java.lang.String r4 = "attachToGLContext:"
                r3.append(r4)     // Catch:{ Exception -> 0x0390 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r4 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ Exception -> 0x0390 }
                android.graphics.SurfaceTexture r4 = r4.f3740h     // Catch:{ Exception -> 0x0390 }
                r3.append(r4)     // Catch:{ Exception -> 0x0390 }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0390 }
                android.util.Log.i(r2, r3)     // Catch:{ Exception -> 0x0390 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ Exception -> 0x0390 }
                android.graphics.SurfaceTexture r2 = r2.f3740h     // Catch:{ Exception -> 0x0390 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ Exception -> 0x0390 }
                com.meizu.camera.effectlib.effects.a.c r3 = r3.f3752t     // Catch:{ Exception -> 0x0390 }
                int r3 = r3.mo14028a()     // Catch:{ Exception -> 0x0390 }
                r2.attachToGLContext(r3)     // Catch:{ Exception -> 0x0390 }
                goto L_0x03ac
            L_0x0390:
                r0 = move-exception
                r2 = r0
                java.lang.String r3 = "glrenderer"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x08e5 }
                r4.<init>()     // Catch:{ all -> 0x08e5 }
                java.lang.String r5 = "error:"
                r4.append(r5)     // Catch:{ all -> 0x08e5 }
                java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x08e5 }
                r4.append(r2)     // Catch:{ all -> 0x08e5 }
                java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x08e5 }
                android.util.Log.e(r3, r2)     // Catch:{ all -> 0x08e5 }
            L_0x03ac:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                android.graphics.SurfaceTexture r2 = r2.f3740h     // Catch:{ all -> 0x08e5 }
                r2.updateTexImage()     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                boolean unused = r2.f3756x = r9     // Catch:{ all -> 0x08e5 }
                monitor-exit(r1)     // Catch:{ all -> 0x08e5 }
                return
            L_0x03bc:
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                android.graphics.SurfaceTexture r3 = r3.f3740h     // Catch:{ all -> 0x08e5 }
                boolean r2 = r2.mo14195b((android.graphics.SurfaceTexture) r3)     // Catch:{ all -> 0x08e5 }
                if (r2 != 0) goto L_0x03d3
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                r2.mo14108f()     // Catch:{ all -> 0x08e5 }
                monitor-exit(r1)     // Catch:{ all -> 0x08e5 }
                return
            L_0x03d3:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                android.graphics.SurfaceTexture r2 = r2.f3740h     // Catch:{ all -> 0x08e5 }
                r2.updateTexImage()     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                android.graphics.SurfaceTexture r2 = r2.f3740h     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                float[] r3 = r3.f3670G     // Catch:{ all -> 0x08e5 }
                r2.getTransformMatrix(r3)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x08e5 }
                boolean r2 = r2.mo14216g()     // Catch:{ all -> 0x08e5 }
                if (r2 != 0) goto L_0x043e
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r3 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r4 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.a.c r3 = r3.mo14169a((com.meizu.camera.effectlib.effects.views.PreviewView) r4)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.p058a.GLTexture unused = r2.f3752t = r3     // Catch:{ all -> 0x08e5 }
                java.lang.String r2 = "CameraGLOnDraw"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x08e5 }
                r3.<init>()     // Catch:{ all -> 0x08e5 }
                java.lang.String r4 = "getGLTexture "
                r3.append(r4)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r4 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.a.c r4 = r4.f3752t     // Catch:{ all -> 0x08e5 }
                r3.append(r4)     // Catch:{ all -> 0x08e5 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x08e5 }
                android.util.Log.i(r2, r3)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.a.c r2 = r2.f3752t     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r3 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.a.c r3 = r3.mo14156A()     // Catch:{ all -> 0x08e5 }
                if (r2 == r3) goto L_0x0449
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.a.c r3 = r3.f3752t     // Catch:{ all -> 0x08e5 }
                r2.mo14177a((com.meizu.camera.effectlib.effects.p058a.GLTexture) r3)     // Catch:{ all -> 0x08e5 }
                goto L_0x0449
            L_0x043e:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                android.graphics.SurfaceTexture r3 = r3.f3740h     // Catch:{ all -> 0x08e5 }
                android.graphics.SurfaceTexture unused = r2.f3741i = r3     // Catch:{ all -> 0x08e5 }
            L_0x0449:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                android.graphics.SurfaceTexture r2 = r2.f3740h     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r3 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x08e5 }
                android.graphics.SurfaceTexture r3 = r3.mo14241y()     // Catch:{ all -> 0x08e5 }
                if (r2 == r3) goto L_0x0466
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                android.graphics.SurfaceTexture r3 = r3.f3740h     // Catch:{ all -> 0x08e5 }
                r2.mo14200c((android.graphics.SurfaceTexture) r3)     // Catch:{ all -> 0x08e5 }
            L_0x0466:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                float[] r2 = r2.f3670G     // Catch:{ all -> 0x08e5 }
                boolean r2 = com.meizu.camera.effectlib.effects.p058a.GLES20Utils.m4018a((float[]) r2)     // Catch:{ all -> 0x08e5 }
                if (r2 != 0) goto L_0x04a6
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                float[] r2 = r2.f3670G     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                float[] r3 = r3.f3669F     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r4 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                float[] r4 = r4.f3669F     // Catch:{ all -> 0x08e5 }
                int r4 = r4.length     // Catch:{ all -> 0x08e5 }
                java.lang.System.arraycopy(r2, r10, r3, r10, r4)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                float[] r3 = r3.f3669F     // Catch:{ all -> 0x08e5 }
                r2.mo14187a((float[]) r3)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.c$b r2 = r2.f3682S     // Catch:{ all -> 0x08e5 }
                if (r2 == 0) goto L_0x04a6
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.c$b r2 = r2.f3682S     // Catch:{ all -> 0x08e5 }
                r2.mo14346n_()     // Catch:{ all -> 0x08e5 }
            L_0x04a6:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                boolean r2 = r2.f3708aa     // Catch:{ all -> 0x08e5 }
                if (r2 == 0) goto L_0x0512
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.b.a r2 = r2.f3755w     // Catch:{ all -> 0x08e5 }
                if (r2 == 0) goto L_0x08e3
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                android.graphics.SurfaceTexture r2 = r2.f3740h     // Catch:{ all -> 0x08e5 }
                if (r2 != 0) goto L_0x04c6
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.imageproc.SurfaceTextureWrapper r2 = r2.f3742j     // Catch:{ all -> 0x08e5 }
                if (r2 == 0) goto L_0x08e3
            L_0x04c6:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.d r2 = r2.f3715ah     // Catch:{ all -> 0x08e5 }
                if (r2 != 0) goto L_0x04e6
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.d r3 = new com.meizu.camera.effectlib.effects.views.d     // Catch:{ all -> 0x08e5 }
                r3.<init>()     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.YuvRenderProgram unused = r2.f3715ah = r3     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.d r2 = r2.f3715ah     // Catch:{ all -> 0x08e5 }
                r2.mo14362b()     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                boolean unused = r2.f3717aj = r10     // Catch:{ all -> 0x08e5 }
            L_0x04e6:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                boolean r2 = r2.f3717aj     // Catch:{ all -> 0x08e5 }
                if (r2 != 0) goto L_0x04f3
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                r2.m4330s()     // Catch:{ all -> 0x08e5 }
            L_0x04f3:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                java.lang.Object r2 = r2.f3672I     // Catch:{ all -> 0x08e5 }
                monitor-enter(r2)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x050e }
                byte[] r3 = r3.f3710ac     // Catch:{ all -> 0x050e }
                if (r3 == 0) goto L_0x050b
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x050e }
                byte[] r3 = r3.f3710ac     // Catch:{ all -> 0x050e }
                r8.m4362a((byte[]) r3)     // Catch:{ all -> 0x050e }
            L_0x050b:
                monitor-exit(r2)     // Catch:{ all -> 0x050e }
                goto L_0x08e3
            L_0x050e:
                r0 = move-exception
                r3 = r0
                monitor-exit(r2)     // Catch:{ all -> 0x050e }
                throw r3     // Catch:{ all -> 0x08e5 }
            L_0x0512:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                boolean r2 = r2.f3709ab     // Catch:{ all -> 0x08e5 }
                if (r2 == 0) goto L_0x0571
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.b.a r2 = r2.f3755w     // Catch:{ all -> 0x08e5 }
                if (r2 == 0) goto L_0x08e3
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                android.graphics.SurfaceTexture r2 = r2.f3740h     // Catch:{ all -> 0x08e5 }
                if (r2 != 0) goto L_0x0532
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.imageproc.SurfaceTextureWrapper r2 = r2.f3742j     // Catch:{ all -> 0x08e5 }
                if (r2 == 0) goto L_0x08e3
            L_0x0532:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.a r2 = r2.f3716ai     // Catch:{ all -> 0x08e5 }
                if (r2 != 0) goto L_0x0552
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.a r3 = new com.meizu.camera.effectlib.effects.views.a     // Catch:{ all -> 0x08e5 }
                r3.<init>()     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.DepthRenderProgram unused = r2.f3716ai = r3     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.a r2 = r2.f3716ai     // Catch:{ all -> 0x08e5 }
                r2.mo14312g()     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                r2.m4332t()     // Catch:{ all -> 0x08e5 }
            L_0x0552:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                java.lang.Object r2 = r2.f3672I     // Catch:{ all -> 0x08e5 }
                monitor-enter(r2)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x056d }
                android.graphics.Bitmap r3 = r3.f3713af     // Catch:{ all -> 0x056d }
                if (r3 == 0) goto L_0x056a
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x056d }
                android.graphics.Bitmap r3 = r3.f3713af     // Catch:{ all -> 0x056d }
                r8.m4361a((android.graphics.Bitmap) r3)     // Catch:{ all -> 0x056d }
            L_0x056a:
                monitor-exit(r2)     // Catch:{ all -> 0x056d }
                goto L_0x08e3
            L_0x056d:
                r0 = move-exception
                r3 = r0
                monitor-exit(r2)     // Catch:{ all -> 0x056d }
                throw r3     // Catch:{ all -> 0x08e5 }
            L_0x0571:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.a.c r2 = r2.f3752t     // Catch:{ all -> 0x08e5 }
                if (r2 == 0) goto L_0x08e3
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.b.a r2 = r2.f3755w     // Catch:{ all -> 0x08e5 }
                if (r2 != 0) goto L_0x0589
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.b.a r2 = r2.f3700aO     // Catch:{ all -> 0x08e5 }
                if (r2 == 0) goto L_0x08e3
            L_0x0589:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                boolean r2 = r2.f3701aP     // Catch:{ all -> 0x08e5 }
                r3 = 16384(0x4000, float:2.2959E-41)
                r4 = 0
                if (r2 == 0) goto L_0x059a
                android.opengl.GLES20.glClear(r3)     // Catch:{ all -> 0x08e5 }
                android.opengl.GLES20.glClearColor(r4, r4, r4, r4)     // Catch:{ all -> 0x08e5 }
            L_0x059a:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.b.a r2 = r2.f3755w     // Catch:{ all -> 0x08e5 }
                if (r2 == 0) goto L_0x0656
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.b.a r2 = r2.f3755w     // Catch:{ all -> 0x08e5 }
                float[] r5 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.f3662A     // Catch:{ all -> 0x08e5 }
                r2.mo14043a(r5)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x08e5 }
                boolean r2 = r2.mo14237u()     // Catch:{ all -> 0x08e5 }
                if (r2 == 0) goto L_0x05c7
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.b.a r2 = r2.f3755w     // Catch:{ all -> 0x08e5 }
                float[] r5 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.f3664C     // Catch:{ all -> 0x08e5 }
                r2.mo14045b(r5)     // Catch:{ all -> 0x08e5 }
                goto L_0x05d4
            L_0x05c7:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.b.a r2 = r2.f3755w     // Catch:{ all -> 0x08e5 }
                float[] r5 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.f3663B     // Catch:{ all -> 0x08e5 }
                r2.mo14045b(r5)     // Catch:{ all -> 0x08e5 }
            L_0x05d4:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                boolean r2 = r2.f3709ab     // Catch:{ all -> 0x08e5 }
                if (r2 == 0) goto L_0x0638
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.b.a r2 = r2.f3755w     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r5 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                float[] r5 = r5.f3692aG     // Catch:{ all -> 0x08e5 }
                r2.mo14047c(r5)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.b.a r2 = r2.f3755w     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r5 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                float[] r5 = r5.f3693aH     // Catch:{ all -> 0x08e5 }
                r2.mo14049d(r5)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.a.c r2 = r2.f3753u     // Catch:{ all -> 0x08e5 }
                if (r2 != 0) goto L_0x0656
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                r5 = 640(0x280, float:8.97E-43)
                r6 = 480(0x1e0, float:6.73E-43)
                com.meizu.camera.effectlib.effects.a.c r5 = com.meizu.camera.effectlib.effects.p058a.GLTexture.m4033a(r5, r6)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.p058a.GLTexture unused = r2.f3753u = r5     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.a.c r2 = r2.f3753u     // Catch:{ all -> 0x08e5 }
                if (r2 == 0) goto L_0x0656
                java.lang.String r2 = "camPreviewRenderView"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x08e5 }
                r5.<init>()     // Catch:{ all -> 0x08e5 }
                java.lang.String r6 = "onDraw create mDepthTexture "
                r5.append(r6)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r6 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.a.c r6 = r6.f3753u     // Catch:{ all -> 0x08e5 }
                int r6 = r6.mo14028a()     // Catch:{ all -> 0x08e5 }
                r5.append(r6)     // Catch:{ all -> 0x08e5 }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x08e5 }
                android.util.Log.i(r2, r5)     // Catch:{ all -> 0x08e5 }
                goto L_0x0656
            L_0x0638:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.b.a r2 = r2.f3755w     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r5 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                float[] r5 = r5.f3668E     // Catch:{ all -> 0x08e5 }
                r2.mo14047c(r5)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.b.a r2 = r2.f3755w     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r5 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                float[] r5 = r5.f3669F     // Catch:{ all -> 0x08e5 }
                r2.mo14049d(r5)     // Catch:{ all -> 0x08e5 }
            L_0x0656:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                int r2 = r2.f3744l     // Catch:{ all -> 0x08e5 }
                if (r2 <= 0) goto L_0x08a1
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                int r2 = r2.f3745m     // Catch:{ all -> 0x08e5 }
                if (r2 > 0) goto L_0x0668
                goto L_0x08a1
            L_0x0668:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.b.a r2 = r2.f3700aO     // Catch:{ all -> 0x08e5 }
                if (r2 == 0) goto L_0x084e
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.b.a r2 = r2.f3700aO     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.b$c r2 = r2.mo14046c()     // Catch:{ all -> 0x08e5 }
                java.lang.String r2 = r2.mo14345d()     // Catch:{ all -> 0x08e5 }
                java.lang.String r5 = "Mzvfacebeauty"
                boolean r2 = r2.equals(r5)     // Catch:{ all -> 0x08e5 }
                if (r2 == 0) goto L_0x084e
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                boolean r2 = r2.f3677N     // Catch:{ all -> 0x08e5 }
                if (r2 == 0) goto L_0x084e
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.b.a r2 = r2.f3700aO     // Catch:{ all -> 0x08e5 }
                float[] r5 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.f3662A     // Catch:{ all -> 0x08e5 }
                r2.mo14043a(r5)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x08e5 }
                boolean r2 = r2.mo14237u()     // Catch:{ all -> 0x08e5 }
                if (r2 == 0) goto L_0x06b3
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.b.a r2 = r2.f3700aO     // Catch:{ all -> 0x08e5 }
                float[] r5 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.f3664C     // Catch:{ all -> 0x08e5 }
                r2.mo14045b(r5)     // Catch:{ all -> 0x08e5 }
                goto L_0x06c0
            L_0x06b3:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.b.a r2 = r2.f3700aO     // Catch:{ all -> 0x08e5 }
                float[] r5 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.f3663B     // Catch:{ all -> 0x08e5 }
                r2.mo14045b(r5)     // Catch:{ all -> 0x08e5 }
            L_0x06c0:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.b.a r2 = r2.f3755w     // Catch:{ all -> 0x08e5 }
                if (r2 == 0) goto L_0x07e4
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.b.a r2 = r2.f3755w     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.b$c r2 = r2.mo14046c()     // Catch:{ all -> 0x08e5 }
                java.lang.String r2 = r2.mo14345d()     // Catch:{ all -> 0x08e5 }
                java.lang.String r5 = "Mznone"
                boolean r2 = r2.equals(r5)     // Catch:{ all -> 0x08e5 }
                if (r2 != 0) goto L_0x07e4
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.a.c r2 = r2.f3698aM     // Catch:{ all -> 0x08e5 }
                if (r2 == 0) goto L_0x07e4
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                int r2 = r2.f3697aL     // Catch:{ all -> 0x08e5 }
                r5 = -1
                if (r2 != r5) goto L_0x06f4
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                r2.m4333u()     // Catch:{ all -> 0x08e5 }
            L_0x06f4:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                java.lang.String r5 = "glBindFramebuffer"
                r2.mo14101a((java.lang.String) r5)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                int r2 = r2.f3697aL     // Catch:{ all -> 0x08e5 }
                r5 = 36160(0x8d40, float:5.0671E-41)
                android.opengl.GLES20.glBindFramebuffer(r5, r2)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                boolean r2 = r2.f3701aP     // Catch:{ all -> 0x08e5 }
                if (r2 == 0) goto L_0x0715
                android.opengl.GLES20.glClear(r3)     // Catch:{ all -> 0x08e5 }
                android.opengl.GLES20.glClearColor(r4, r4, r4, r4)     // Catch:{ all -> 0x08e5 }
            L_0x0715:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.b.a r2 = r2.f3700aO     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                float[] r3 = r3.f3693aH     // Catch:{ all -> 0x08e5 }
                r2.mo14047c(r3)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.b.a r2 = r2.f3700aO     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                float[] r3 = r3.f3669F     // Catch:{ all -> 0x08e5 }
                r2.mo14049d(r3)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.b.a r11 = r2.f3700aO     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.a.c r12 = r2.f3752t     // Catch:{ all -> 0x08e5 }
                r13 = 0
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                int r14 = r2.f3746n     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                int r15 = r2.f3744l     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                int r16 = r2.f3745m     // Catch:{ all -> 0x08e5 }
                r11.mo14040a(r12, r13, r14, r15, r16)     // Catch:{ all -> 0x08e5 }
                android.opengl.GLES20.glBindFramebuffer(r5, r10)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.b r2 = r2.f3754v     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.b.a r3 = r3.f3755w     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.b$c r3 = r3.mo14046c()     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.b.a r11 = r2.mo14325b((com.meizu.camera.effectlib.effects.views.EffectRenderFactory.C1191c) r3)     // Catch:{ all -> 0x08e5 }
                float[] r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.f3662A     // Catch:{ all -> 0x08e5 }
                r11.mo14043a(r2)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x08e5 }
                boolean r2 = r2.mo14237u()     // Catch:{ all -> 0x08e5 }
                if (r2 == 0) goto L_0x0785
                float[] r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.f3664C     // Catch:{ all -> 0x08e5 }
                r11.mo14045b(r2)     // Catch:{ all -> 0x08e5 }
                goto L_0x078c
            L_0x0785:
                float[] r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.f3663B     // Catch:{ all -> 0x08e5 }
                r11.mo14045b(r2)     // Catch:{ all -> 0x08e5 }
            L_0x078c:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                float[] r2 = r2.f3668E     // Catch:{ all -> 0x08e5 }
                r11.mo14047c(r2)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                float[] r2 = r2.f3693aH     // Catch:{ all -> 0x08e5 }
                r11.mo14049d(r2)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.a.c r12 = r2.f3698aM     // Catch:{ all -> 0x08e5 }
                r13 = 0
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                int r14 = r2.f3746n     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                int r15 = r2.f3744l     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                int r16 = r2.f3745m     // Catch:{ all -> 0x08e5 }
                r11.mo14040a(r12, r13, r14, r15, r16)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                boolean r2 = r2.f3702aQ     // Catch:{ all -> 0x08e5 }
                if (r2 == 0) goto L_0x08e3
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                int r3 = r3.f3744l     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r4 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                int r4 = r4.f3745m     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r5 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                int r5 = r5.f3703aR     // Catch:{ all -> 0x08e5 }
                android.graphics.Bitmap r3 = r8.m4360a(r3, r4, r5)     // Catch:{ all -> 0x08e5 }
                android.graphics.Bitmap unused = r2.f3678O = r3     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                boolean unused = r2.f3702aQ = r10     // Catch:{ all -> 0x08e5 }
                goto L_0x08e3
            L_0x07e4:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.b.a r2 = r2.f3700aO     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                float[] r3 = r3.f3668E     // Catch:{ all -> 0x08e5 }
                r2.mo14047c(r3)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.b.a r2 = r2.f3700aO     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                float[] r3 = r3.f3669F     // Catch:{ all -> 0x08e5 }
                r2.mo14049d(r3)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.b.a r11 = r2.f3700aO     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.a.c r12 = r2.f3752t     // Catch:{ all -> 0x08e5 }
                r13 = 0
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                int r14 = r2.f3746n     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                int r15 = r2.f3744l     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                int r16 = r2.f3745m     // Catch:{ all -> 0x08e5 }
                r11.mo14040a(r12, r13, r14, r15, r16)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                boolean r2 = r2.f3702aQ     // Catch:{ all -> 0x08e5 }
                if (r2 == 0) goto L_0x08e3
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                int r3 = r3.f3744l     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r4 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                int r4 = r4.f3745m     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r5 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                int r5 = r5.f3703aR     // Catch:{ all -> 0x08e5 }
                android.graphics.Bitmap r3 = r8.m4360a(r3, r4, r5)     // Catch:{ all -> 0x08e5 }
                android.graphics.Bitmap unused = r2.f3678O = r3     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                boolean unused = r2.f3702aQ = r10     // Catch:{ all -> 0x08e5 }
                goto L_0x08e3
            L_0x084e:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.b.a r2 = r2.f3755w     // Catch:{ all -> 0x08e5 }
                if (r2 == 0) goto L_0x08e3
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.b.a r11 = r2.f3755w     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.a.c r12 = r2.f3752t     // Catch:{ all -> 0x08e5 }
                r13 = 0
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                int r14 = r2.f3746n     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                int r15 = r2.f3744l     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                int r16 = r2.f3745m     // Catch:{ all -> 0x08e5 }
                r11.mo14040a(r12, r13, r14, r15, r16)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                boolean r2 = r2.f3702aQ     // Catch:{ all -> 0x08e5 }
                if (r2 == 0) goto L_0x08e3
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                int r3 = r3.f3744l     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r4 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                int r4 = r4.f3745m     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r5 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                int r5 = r5.f3703aR     // Catch:{ all -> 0x08e5 }
                android.graphics.Bitmap r3 = r8.m4360a(r3, r4, r5)     // Catch:{ all -> 0x08e5 }
                android.graphics.Bitmap unused = r2.f3678O = r3     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                boolean unused = r2.f3702aQ = r10     // Catch:{ all -> 0x08e5 }
                goto L_0x08e3
            L_0x08a1:
                java.lang.String r2 = "camPreviewRenderView"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x08e5 }
                r3.<init>()     // Catch:{ all -> 0x08e5 }
                java.lang.String r4 = "render view size not init:"
                r3.append(r4)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r4 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                int r4 = r4.f3744l     // Catch:{ all -> 0x08e5 }
                r3.append(r4)     // Catch:{ all -> 0x08e5 }
                java.lang.String r4 = "x"
                r3.append(r4)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r4 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                int r4 = r4.f3745m     // Catch:{ all -> 0x08e5 }
                r3.append(r4)     // Catch:{ all -> 0x08e5 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x08e5 }
                android.util.Log.i(r2, r3)     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                int r3 = r3.getViewWidth()     // Catch:{ all -> 0x08e5 }
                int unused = r2.f3744l = r3     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this     // Catch:{ all -> 0x08e5 }
                int r3 = r3.getViewHeight()     // Catch:{ all -> 0x08e5 }
                int unused = r2.f3745m = r3     // Catch:{ all -> 0x08e5 }
                monitor-exit(r1)     // Catch:{ all -> 0x08e5 }
                return
            L_0x08e3:
                monitor-exit(r1)     // Catch:{ all -> 0x08e5 }
                return
            L_0x08e5:
                r0 = move-exception
                r2 = r0
                monitor-exit(r1)     // Catch:{ all -> 0x08e5 }
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.C1169a.onDraw(com.meizu.common.renderer.functor.DrawGLFunctor$GLInfo):void");
        }

        /* renamed from: a */
        private Bitmap m4360a(int i, int i2, int i3) {
            float f;
            Object[] objArr = {new Integer(i), new Integer(i2), new Integer(i3)};
            ChangeQuickRedirect changeQuickRedirect = f3759a;
            ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
            PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 243, new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE}, Bitmap.class);
            if (proxy.isSupported) {
                return (Bitmap) proxy.result;
            }
            Log.i("camPreviewRenderView", "getBitmapforGpu:" + i + "x" + i2);
            ByteBuffer allocate = ByteBuffer.allocate(i * i2 * 4);
            GLES20.glReadPixels(0, 0, i, i2, 6408, 5121, allocate);
            ByteBuffer wrap = ByteBuffer.wrap(allocate.array());
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(wrap);
            Bitmap a = SurfaceTextureBitmap.m6364a(createBitmap);
            createBitmap.recycle();
            float f2 = (float) i;
            float U = CameraPreviewRenderView.this.f3704aS * f2;
            if (CameraPreviewRenderView.this.f3706aU < 0.0f) {
                f = (((float) i2) * CameraPreviewRenderView.this.f3705aT) + CameraPreviewRenderView.this.f3706aU;
                float unused = CameraPreviewRenderView.this.f3706aU = 0.0f;
            } else {
                f = ((float) i2) * CameraPreviewRenderView.this.f3705aT;
            }
            int i4 = (int) ((f / U) * f2);
            if (((int) CameraPreviewRenderView.this.f3706aU) + i4 >= a.getHeight()) {
                Log.i("camPreviewRenderView", "resize realHeight:" + i4 + " mPy: " + CameraPreviewRenderView.this.f3706aU);
                i4 = a.getHeight() - ((int) CameraPreviewRenderView.this.f3706aU);
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(a, 0, (int) CameraPreviewRenderView.this.f3706aU, i, i4);
            a.recycle();
            Log.i("camPreviewRenderView", "getBitmapforGpu end");
            return createBitmap2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.lang.Object[]} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void m4362a(byte[] r21) {
            /*
                r20 = this;
                r7 = r20
                r8 = r21
                r9 = 1
                java.lang.Object[] r0 = new java.lang.Object[r9]
                r10 = 0
                r0[r10] = r8
                com.meizu.savior.ChangeQuickRedirect r2 = f3759a
                java.lang.Class[] r5 = new java.lang.Class[r9]
                java.lang.Class<byte[]> r1 = byte[].class
                r5[r10] = r1
                java.lang.Class r6 = java.lang.Void.TYPE
                r3 = 0
                r4 = 244(0xf4, float:3.42E-43)
                r1 = r20
                com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r0, r1, r2, r3, r4, r5, r6)
                boolean r0 = r0.isSupported
                if (r0 == 0) goto L_0x0022
                return
            L_0x0022:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                com.meizu.camera.effectlib.effects.views.d r0 = r0.f3715ah
                java.nio.FloatBuffer r6 = r0.mo14364d()
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                com.meizu.camera.effectlib.effects.views.d r0 = r0.f3715ah
                java.nio.FloatBuffer r0 = r0.mo14365e()
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                com.meizu.camera.effectlib.effects.views.d r2 = r2.f3715ah
                int r2 = r2.mo14363c()
                java.lang.String r3 = "aPosition"
                int r2 = android.opengl.GLES20.glGetAttribLocation(r2, r3)
                int unused = r1.f3721an = r2
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                com.meizu.camera.effectlib.effects.views.d r2 = r2.f3715ah
                int r2 = r2.mo14363c()
                java.lang.String r3 = "aTextureCoordinate"
                int r2 = android.opengl.GLES20.glGetAttribLocation(r2, r3)
                int unused = r1.f3722ao = r2
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                com.meizu.camera.effectlib.effects.views.d r2 = r2.f3715ah
                int r2 = r2.mo14363c()
                java.lang.String r3 = "textureY"
                int r2 = android.opengl.GLES20.glGetUniformLocation(r2, r3)
                int unused = r1.f3723ap = r2
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                com.meizu.camera.effectlib.effects.views.d r2 = r2.f3715ah
                int r2 = r2.mo14363c()
                java.lang.String r3 = "textureUV"
                int r2 = android.opengl.GLES20.glGetUniformLocation(r2, r3)
                int unused = r1.f3724aq = r2
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                com.meizu.camera.effectlib.effects.views.d r2 = r2.f3715ah
                int r2 = r2.mo14363c()
                java.lang.String r3 = "uMVPMatrix"
                int r2 = android.opengl.GLES20.glGetUniformLocation(r2, r3)
                int unused = r1.f3725ar = r2
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r1 = r1.f3744l
                if (r1 <= 0) goto L_0x02f4
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r1 = r1.f3745m
                if (r1 > 0) goto L_0x00b1
                goto L_0x02f4
            L_0x00b1:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                com.meizu.camera.effectlib.effects.views.d r1 = r1.f3715ah
                boolean r1 = r1.mo14367g()
                if (r1 != 0) goto L_0x00c5
                java.lang.String r0 = "camPreviewRenderView"
                java.lang.String r1 = "RenderProgram not ready"
                android.util.Log.i(r0, r1)
                return
            L_0x00c5:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                com.meizu.camera.effectlib.effects.views.d r1 = r1.f3715ah
                int r1 = r1.mo14363c()
                android.opengl.GLES20.glUseProgram(r1)
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r1 = r1.f3744l
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r2 = r2.f3745m
                android.opengl.GLES20.glViewport(r10, r10, r1, r2)
                r1 = 0
                if (r8 == 0) goto L_0x0153
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r1 = r1.f3714ag
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r2 = r2.f3712ae
                int r1 = r1 * r2
                java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r1)
                r1.clear()
                r1.position(r10)
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r2 = r2.f3714ag
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r3 = r3.f3712ae
                int r2 = r2 * r3
                java.nio.ByteBuffer r2 = r1.put(r8, r10, r2)
                r2.position(r10)
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r2 = r2.f3714ag
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r3 = r3.f3712ae
                int r2 = r2 * r3
                int r2 = r2 / 2
                java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r2)
                r2.clear()
                r2.position(r10)
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r3 = r3.f3714ag
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r4 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r4 = r4.f3712ae
                int r3 = r3 * r4
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r4 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r4 = r4.f3714ag
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r5 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r5 = r5.f3712ae
                int r4 = r4 * r5
                int r4 = r4 / 2
                java.nio.ByteBuffer r3 = r2.put(r8, r3, r4)
                r3.position(r10)
                r8 = r1
                r5 = r2
                goto L_0x0155
            L_0x0153:
                r5 = r1
                r8 = r5
            L_0x0155:
                if (r8 == 0) goto L_0x01c6
                if (r5 == 0) goto L_0x01c6
                r1 = 33984(0x84c0, float:4.7622E-41)
                android.opengl.GLES20.glActiveTexture(r1)
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r1 = r1.f3719al
                r2 = 3553(0xde1, float:4.979E-42)
                android.opengl.GLES20.glBindTexture(r2, r1)
                r8.position(r10)
                r11 = 3553(0xde1, float:4.979E-42)
                r12 = 0
                r13 = 6409(0x1909, float:8.981E-42)
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r14 = r1.f3714ag
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r15 = r1.f3712ae
                r16 = 0
                r17 = 6409(0x1909, float:8.981E-42)
                r18 = 5121(0x1401, float:7.176E-42)
                r19 = r8
                android.opengl.GLES20.glTexImage2D(r11, r12, r13, r14, r15, r16, r17, r18, r19)
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r1 = r1.f3723ap
                android.opengl.GLES20.glUniform1i(r1, r10)
                r1 = 33985(0x84c1, float:4.7623E-41)
                android.opengl.GLES20.glActiveTexture(r1)
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r1 = r1.f3720am
                android.opengl.GLES20.glBindTexture(r2, r1)
                r5.position(r10)
                r13 = 6410(0x190a, float:8.982E-42)
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r1 = r1.f3714ag
                int r14 = r1 / 2
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r1 = r1.f3712ae
                int r15 = r1 / 2
                r17 = 6410(0x190a, float:8.982E-42)
                r19 = r5
                android.opengl.GLES20.glTexImage2D(r11, r12, r13, r14, r15, r16, r17, r18, r19)
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r1 = r1.f3724aq
                android.opengl.GLES20.glUniform1i(r1, r9)
            L_0x01c6:
                r6.position(r10)
                r1 = 34962(0x8892, float:4.8992E-41)
                android.opengl.GLES20.glBindBuffer(r1, r10)
                r1 = 34963(0x8893, float:4.8994E-41)
                android.opengl.GLES20.glBindBuffer(r1, r10)
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r1 = r1.f3721an
                r2 = 3
                r3 = 5126(0x1406, float:7.183E-42)
                r4 = 0
                r11 = 12
                r17 = r5
                r5 = r11
                android.opengl.GLES20.glVertexAttribPointer(r1, r2, r3, r4, r5, r6)
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                com.meizu.camera.effectlib.effects.views.d r1 = r1.f3715ah
                java.lang.String r2 = "glVertexAttribPointer PositionLocation"
                r1.mo14361a((java.lang.String) r2)
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r1 = r1.f3721an
                android.opengl.GLES20.glEnableVertexAttribArray(r1)
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                com.meizu.camera.effectlib.effects.views.d r1 = r1.f3715ah
                java.lang.String r2 = "glEnableVertexAttribArray PositionLocation"
                r1.mo14361a((java.lang.String) r2)
                r0.position(r10)
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r11 = r1.f3722ao
                r12 = 2
                r13 = 5126(0x1406, float:7.183E-42)
                r14 = 0
                r15 = 8
                r16 = r0
                android.opengl.GLES20.glVertexAttribPointer(r11, r12, r13, r14, r15, r16)
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r0 = r0.f3722ao
                android.opengl.GLES20.glEnableVertexAttribArray(r0)
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                com.meizu.camera.effectlib.effects.views.d r0 = r0.f3715ah
                java.lang.String r1 = "glEnableVertexAttribArray TextureCoordLocation"
                r0.mo14361a((java.lang.String) r1)
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                boolean r0 = r0.f3685W
                if (r0 == 0) goto L_0x026b
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r0 = r0.f3725ar
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                float[] r1 = r1.f3692aG
                android.opengl.GLES20.glUniformMatrix4fv(r0, r9, r10, r1, r10)
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                com.meizu.camera.effectlib.effects.views.d r0 = r0.f3715ah
                java.lang.String r1 = "glUniformMatrix4fv mMVPMatrix"
                r0.mo14361a((java.lang.String) r1)
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r0 = r0.f3725ar
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                float[] r1 = r1.f3692aG
                android.opengl.GLES20.glUniformMatrix4fv(r0, r9, r10, r1, r10)
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                com.meizu.camera.effectlib.effects.views.d r0 = r0.f3715ah
                java.lang.String r1 = "glUniformMatrix4fv mMVPMatrix"
                r0.mo14361a((java.lang.String) r1)
                goto L_0x029f
            L_0x026b:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r0 = r0.f3725ar
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                float[] r1 = r1.f3691aF
                android.opengl.GLES20.glUniformMatrix4fv(r0, r9, r10, r1, r10)
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                com.meizu.camera.effectlib.effects.views.d r0 = r0.f3715ah
                java.lang.String r1 = "glUniformMatrix4fv mMVPMatrix"
                r0.mo14361a((java.lang.String) r1)
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r0 = r0.f3725ar
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                float[] r1 = r1.f3691aF
                android.opengl.GLES20.glUniformMatrix4fv(r0, r9, r10, r1, r10)
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                com.meizu.camera.effectlib.effects.views.d r0 = r0.f3715ah
                java.lang.String r1 = "glUniformMatrix4fv mMVPMatrix"
                r0.mo14361a((java.lang.String) r1)
            L_0x029f:
                r0 = 4
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                short[] r1 = r1.f3694aI
                int r1 = r1.length
                r2 = 5123(0x1403, float:7.179E-42)
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                com.meizu.camera.effectlib.effects.views.d r3 = r3.f3715ah
                java.nio.ShortBuffer r3 = r3.mo14366f()
                android.opengl.GLES20.glDrawElements(r0, r1, r2, r3)
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                boolean r0 = r0.f3702aQ
                if (r0 == 0) goto L_0x02de
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r1 = r1.f3744l
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r2 = r2.f3745m
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r3 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r3 = r3.f3703aR
                android.graphics.Bitmap r1 = r7.m4360a(r1, r2, r3)
                android.graphics.Bitmap unused = r0.f3678O = r1
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                boolean unused = r0.f3702aQ = r10
            L_0x02de:
                if (r8 == 0) goto L_0x02e3
                r8.rewind()
            L_0x02e3:
                if (r17 == 0) goto L_0x02e8
                r17.rewind()
            L_0x02e8:
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                com.meizu.camera.effectlib.effects.views.d r0 = r0.f3715ah
                java.lang.String r1 = "glDrawElements"
                r0.mo14361a((java.lang.String) r1)
                return
            L_0x02f4:
                java.lang.String r0 = "camPreviewRenderView"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "view size not init:"
                r1.append(r2)
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r2 = r2.f3744l
                r1.append(r2)
                java.lang.String r2 = "x"
                r1.append(r2)
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r2 = r2.f3745m
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                android.util.Log.i(r0, r1)
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r1 = r1.getViewWidth()
                int unused = r0.f3744l = r1
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView r1 = com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.this
                int r1 = r1.getViewHeight()
                int unused = r0.f3745m = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView.C1169a.m4362a(byte[]):void");
        }

        /* renamed from: a */
        private void m4361a(Bitmap bitmap) {
            Bitmap bitmap2 = bitmap;
            if (!PatchProxy.proxy(new Object[]{bitmap2}, this, f3759a, false, 245, new Class[]{Bitmap.class}, Void.TYPE).isSupported) {
                FloatBuffer a = CameraPreviewRenderView.this.f3716ai.mo14304a();
                FloatBuffer b = CameraPreviewRenderView.this.f3716ai.mo14307b();
                int unused = CameraPreviewRenderView.this.f3721an = GLES20.glGetAttribLocation(CameraPreviewRenderView.this.f3716ai.mo14309d(), DepthRenderProgram.f4020b.mo14315a());
                int unused2 = CameraPreviewRenderView.this.f3722ao = GLES20.glGetAttribLocation(CameraPreviewRenderView.this.f3716ai.mo14309d(), DepthRenderProgram.f4020b.mo14316b());
                int unused3 = CameraPreviewRenderView.this.f3689aD = GLES20.glGetUniformLocation(CameraPreviewRenderView.this.f3716ai.mo14309d(), DepthRenderProgram.f4020b.mo14318d());
                int unused4 = CameraPreviewRenderView.this.f3725ar = GLES20.glGetUniformLocation(CameraPreviewRenderView.this.f3716ai.mo14309d(), DepthRenderProgram.f4020b.mo14317c());
                if (CameraPreviewRenderView.this.f3744l <= 0 || CameraPreviewRenderView.this.f3745m <= 0) {
                    Log.i("camPreviewRenderView", "view size not init:" + CameraPreviewRenderView.this.f3744l + "x" + CameraPreviewRenderView.this.f3745m);
                    int unused5 = CameraPreviewRenderView.this.f3744l = CameraPreviewRenderView.this.getViewWidth();
                    int unused6 = CameraPreviewRenderView.this.f3745m = CameraPreviewRenderView.this.getViewHeight();
                } else if (!CameraPreviewRenderView.this.f3716ai.mo14310e()) {
                    Log.i("camPreviewRenderView", "RenderProgram not ready");
                } else {
                    GLES20.glUseProgram(CameraPreviewRenderView.this.f3716ai.mo14309d());
                    GLES20.glViewport(0, 0, CameraPreviewRenderView.this.f3744l, CameraPreviewRenderView.this.f3745m);
                    if (bitmap2 != null) {
                        GLES20.glActiveTexture(33984);
                        GLES20.glBindTexture(3553, CameraPreviewRenderView.this.f3690aE);
                        ByteBuffer allocate = ByteBuffer.allocate(bitmap.getWidth() * bitmap.getHeight() * 4);
                        bitmap2.copyPixelsToBuffer(allocate);
                        allocate.position(0);
                        GLES20.glTexImage2D(3553, 0, 6408, bitmap.getWidth(), bitmap.getHeight(), 0, 6408, 5121, allocate);
                        GLES20.glUniform1i(CameraPreviewRenderView.this.f3689aD, 0);
                    }
                    a.position(0);
                    GLES20.glBindBuffer(34962, 0);
                    GLES20.glBindBuffer(34963, 0);
                    GLES20.glVertexAttribPointer(CameraPreviewRenderView.this.f3721an, 3, 5126, false, 12, a);
                    CameraPreviewRenderView.this.f3716ai.mo14306a("glVertexAttribPointer PositionLocation");
                    GLES20.glEnableVertexAttribArray(CameraPreviewRenderView.this.f3721an);
                    CameraPreviewRenderView.this.f3716ai.mo14306a("glEnableVertexAttribArray PositionLocation");
                    b.position(0);
                    GLES20.glVertexAttribPointer(CameraPreviewRenderView.this.f3722ao, 2, 5126, false, 8, b);
                    GLES20.glEnableVertexAttribArray(CameraPreviewRenderView.this.f3722ao);
                    CameraPreviewRenderView.this.f3716ai.mo14306a("glEnableVertexAttribArray TextureCoordLocation");
                    GLES20.glUniformMatrix4fv(CameraPreviewRenderView.this.f3725ar, 1, false, CameraPreviewRenderView.this.f3692aG, 0);
                    CameraPreviewRenderView.this.f3716ai.mo14306a("glUniformMatrix4fv mMVPMatrix");
                    GLES20.glDrawElements(4, CameraPreviewRenderView.this.f3694aI.length, 5123, CameraPreviewRenderView.this.f3716ai.mo14308c());
                    if (CameraPreviewRenderView.this.f3702aQ) {
                        Bitmap unused7 = CameraPreviewRenderView.this.f3678O = m4360a(CameraPreviewRenderView.this.f3744l, CameraPreviewRenderView.this.f3745m, CameraPreviewRenderView.this.f3703aR);
                        boolean unused8 = CameraPreviewRenderView.this.f3702aQ = false;
                    }
                    CameraPreviewRenderView.this.f3716ai.mo14306a("glDrawElements");
                }
            }
        }
    }

    /* renamed from: a */
    public int mo14098a(byte[] bArr, int[] iArr, int[] iArr2) {
        ChangeQuickRedirect changeQuickRedirect = f3667a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bArr, iArr, iArr2}, this, changeQuickRedirect, false, 235, new Class[]{byte[].class, int[].class, int[].class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        synchronized (this.f3671H) {
            if (!SurfaceTextureBitmap.m6369b()) {
                SurfaceTextureBitmap.m6368a(true);
            }
            if (Build.VERSION.SDK_INT >= 29) {
                int a = SurfaceTextureBitmap.m6363a(this.f3743k, bArr, iArr, iArr2, EffectRenderContext.m4369h().mo14188b(this.f3674K, this.f3675L, this.f3676M, this.f3677N));
                return a;
            }
            int a2 = SurfaceTextureBitmap.m6362a(this.f3741i, bArr, iArr, iArr2, EffectRenderContext.m4369h().mo14188b(this.f3674K, this.f3675L, this.f3676M, this.f3677N));
            return a2;
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* renamed from: com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView$b */
    protected class C1170b extends Handler {

        /* renamed from: a */
        public static ChangeQuickRedirect f3761a;

        /* renamed from: c */
        private WeakReference<CameraPreviewRenderView> f3763c;

        public C1170b(CameraPreviewRenderView cameraPreviewRenderView) {
            this.f3763c = new WeakReference<>(cameraPreviewRenderView);
        }

        public void handleMessage(Message message) {
            CameraPreviewRenderView cameraPreviewRenderView;
            if (!PatchProxy.proxy(new Object[]{message}, this, f3761a, false, 247, new Class[]{Message.class}, Void.TYPE).isSupported && (cameraPreviewRenderView = (CameraPreviewRenderView) this.f3763c.get()) != null && cameraPreviewRenderView.f3749q != null) {
                if (Build.VERSION.SDK_INT >= 29) {
                    switch (message.what) {
                        case 0:
                            cameraPreviewRenderView.f3750r.mo14352a(cameraPreviewRenderView.f3742j, cameraPreviewRenderView.f3744l, cameraPreviewRenderView.f3745m);
                            return;
                        case 1:
                            cameraPreviewRenderView.f3750r.mo14356c(cameraPreviewRenderView.f3742j);
                            return;
                        case 2:
                            cameraPreviewRenderView.f3750r.mo14353a((SurfaceTextureWrapper) message.obj);
                            return;
                        case 3:
                            Log.v("camPreviewRenderView", "enable bokeh");
                            boolean unused = CameraPreviewRenderView.this.f3684V = true;
                            boolean unused2 = CameraPreviewRenderView.this.f3708aa = true;
                            return;
                        case 4:
                            Log.v("camPreviewRenderView", "enable tof");
                            boolean unused3 = CameraPreviewRenderView.this.f3685W = true;
                            boolean unused4 = CameraPreviewRenderView.this.f3708aa = true;
                            return;
                        default:
                            return;
                    }
                } else {
                    switch (message.what) {
                        case 0:
                            cameraPreviewRenderView.f3749q.mo14347a(cameraPreviewRenderView.f3740h, cameraPreviewRenderView.f3744l, cameraPreviewRenderView.f3745m);
                            return;
                        case 1:
                            cameraPreviewRenderView.f3749q.mo14349b(cameraPreviewRenderView.f3740h);
                            return;
                        case 2:
                            cameraPreviewRenderView.f3749q.mo14348a((SurfaceTexture) message.obj);
                            return;
                        case 3:
                            Log.v("camPreviewRenderView", "enable bokeh");
                            boolean unused5 = CameraPreviewRenderView.this.f3684V = true;
                            boolean unused6 = CameraPreviewRenderView.this.f3708aa = true;
                            return;
                        case 4:
                            Log.v("camPreviewRenderView", "enable tof");
                            boolean unused7 = CameraPreviewRenderView.this.f3685W = true;
                            boolean unused8 = CameraPreviewRenderView.this.f3708aa = true;
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    }

    /* renamed from: com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView$c */
    protected class C1171c implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f3764a;

        /* renamed from: b */
        BaseRender f3765b;

        public C1171c(BaseRender aVar) {
            this.f3765b = aVar;
        }

        public void run() {
            if (!PatchProxy.proxy(new Object[0], this, f3764a, false, 248, new Class[0], Void.TYPE).isSupported) {
                Log.d("camPreviewRenderView", "CloseVFBRunnable render:" + this.f3765b);
                if (this.f3765b != null) {
                    this.f3765b.mo14048d();
                    this.f3765b = null;
                }
            }
        }
    }
}
