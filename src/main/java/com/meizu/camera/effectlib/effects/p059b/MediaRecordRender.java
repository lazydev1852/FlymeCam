package com.meizu.camera.effectlib.effects.p059b;

import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import androidx.core.app.NotificationCompat;
import com.alibaba.fastjson.asm.Opcodes;
import com.meizu.camera.effectlib.effects.filters.SurfaceManager;
import com.meizu.camera.effectlib.effects.p058a.GLTexture;
import com.meizu.camera.effectlib.effects.views.DepthRenderProgram;
import com.meizu.camera.effectlib.effects.views.EffectRenderContext;
import com.meizu.camera.effectlib.effects.views.EffectRenderFactory;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import java.nio.FloatBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0017\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 Y2\u00020\u0001:\u0002YZB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u00104\u001a\u000205J\u000e\u00106\u001a\u0002052\u0006\u00107\u001a\u00020\u000eJ\u0018\u00108\u001a\u0002052\u0006\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\tH\u0002J\u0018\u0010;\u001a\u0002052\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u0004H\u0002J\u0018\u0010>\u001a\u0002052\u0006\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\tH\u0002J\u0016\u0010?\u001a\u0002052\u0006\u0010@\u001a\u00020\u00102\u0006\u0010A\u001a\u000203J\b\u0010B\u001a\u000205H\u0002J\b\u0010C\u001a\u000205H\u0002J\b\u0010D\u001a\u000205H\u0002J\b\u0010E\u001a\u000205H\u0002J\u000e\u0010F\u001a\u0002052\u0006\u0010G\u001a\u00020\u001bJ\b\u0010H\u001a\u000205H\u0002J\u0006\u0010I\u001a\u000205J\u0006\u0010J\u001a\u000205J\u000e\u0010K\u001a\u0002052\u0006\u0010L\u001a\u00020#J\u001e\u0010M\u001a\u0002052\u0006\u0010N\u001a\u0002012\u0006\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\tJ\u0016\u0010M\u001a\u0002052\u0006\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\tJ\u000e\u0010O\u001a\u0002052\u0006\u0010P\u001a\u00020QJ\u000e\u0010R\u001a\u0002052\u0006\u0010S\u001a\u00020\tJ\u0010\u0010T\u001a\u0002052\b\u0010<\u001a\u0004\u0018\u00010\u0004J\u0016\u0010U\u001a\u0002052\u0006\u0010V\u001a\u00020\t2\u0006\u0010W\u001a\u00020\tJ\u0006\u0010X\u001a\u000205R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000¨\u0006["}, mo27294d2 = {"Lcom/meizu/camera/effectlib/effects/renders/MediaRecordRender;", "", "()V", "POS_VERTICES", "", "TEX_VERTICES", "mDepthRenderProgram", "Lcom/meizu/camera/effectlib/effects/views/DepthRenderProgram;", "mDepthTextureId", "", "mDepthTextureLocation", "mDrawOrder", "", "mDump", "", "mEglContext", "Landroid/opengl/EGLContext;", "mGetEffectBitmap", "mHandler", "Landroid/os/Handler;", "mHandlerThread", "Landroid/os/HandlerThread;", "mIsDrawTexture", "mMVPMatrixLocation", "mMVPTofMatrix", "mMVPVideoMatrix", "mMediaSurface", "Landroid/view/Surface;", "mNeedChangeRecordSurface", "mNeedClean", "mOESTextureId", "mOrientation", "mPositionLocation", "mPreviewHight", "mPreviewTexture", "Lcom/meizu/camera/effectlib/effects/gles/GLTexture;", "mPreviewWidth", "mRender", "Lcom/meizu/camera/effectlib/effects/renders/BaseRender;", "mShowBitmap", "mStartRecord", "mSurfaceMgr", "Lcom/meizu/camera/effectlib/effects/filters/SurfaceManager;", "mSyncObject", "mSyncObjectForPreviewData", "mTexMatrix", "mTextureCoordLocation", "mTextureId", "mTofPreviewBitmap", "Landroid/graphics/Bitmap;", "mlistener", "Lcom/meizu/camera/effectlib/effects/renders/MediaRecordRender$RecordCallback;", "destroy", "", "draw", "isDrawTexture", "drawDepth", "width", "height", "drawTexture", "texMatrix", "mvpMatrix", "getGpuBitmap", "init", "eglContext", "listener", "initDepthRenderProgram", "initEGL", "onDestroyGL", "onDraw", "onMediaSufacePrepared", "surface", "onRelease", "reInitEGL", "release", "setGLTexture", "texture", "setPreviewBitmap", "bitmap", "setRenderType", "renderType", "", "setTexture", "textureid", "setTransform", "startRecord", "orientation", "cameraId", "stopNightVisionRecord", "Companion", "RecordCallback", "effectlib_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.camera.effectlib.effects.b.e */
public final class MediaRecordRender {

    /* renamed from: H */
    private static final String f3505H = f3505H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public static final int f3506I = 0;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public static final int f3507J = 1;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public static final int f3508K = 2;

    /* renamed from: L */
    private static final int f3509L = 3;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public static final int f3510M = 4;

    /* renamed from: N */
    private static final int f3511N = 5;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public static final int f3512O = 6;

    /* renamed from: P */
    private static final int f3513P = 7;

    /* renamed from: a */
    public static ChangeQuickRedirect f3514a;

    /* renamed from: b */
    public static final C1155a f3515b = new C1155a((DefaultConstructorMarker) null);

    /* renamed from: A */
    private final float[] f3516A = new float[16];

    /* renamed from: B */
    private GLTexture f3517B;

    /* renamed from: C */
    private boolean f3518C;

    /* renamed from: D */
    private BaseRender f3519D;

    /* renamed from: E */
    private boolean f3520E = true;

    /* renamed from: F */
    private final float[] f3521F = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: G */
    private final float[] f3522G = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: c */
    private HandlerThread f3523c;

    /* renamed from: d */
    private Handler f3524d;

    /* renamed from: e */
    private SurfaceManager f3525e;

    /* renamed from: f */
    private final Object f3526f = new Object();

    /* renamed from: g */
    private final Object f3527g = new Object();

    /* renamed from: h */
    private int f3528h = 1920;

    /* renamed from: i */
    private int f3529i = 1080;

    /* renamed from: j */
    private DepthRenderProgram f3530j;

    /* renamed from: k */
    private int f3531k = -1;

    /* renamed from: l */
    private final int f3532l = -1;

    /* renamed from: m */
    private int f3533m = -1;

    /* renamed from: n */
    private int f3534n = -1;

    /* renamed from: o */
    private int f3535o = -1;

    /* renamed from: p */
    private final float[] f3536p = new float[16];

    /* renamed from: q */
    private final float[] f3537q = new float[16];

    /* renamed from: r */
    private final short[] f3538r = {0, 2, 1, 1, 2, 3};

    /* renamed from: s */
    private boolean f3539s;

    /* renamed from: t */
    private Surface f3540t;

    /* renamed from: u */
    private boolean f3541u;

    /* renamed from: v */
    private boolean f3542v;

    /* renamed from: w */
    private int f3543w = -1;

    /* renamed from: x */
    private int f3544x;

    /* renamed from: y */
    private EGLContext f3545y;

    /* renamed from: z */
    private C1156b f3546z;

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, mo27294d2 = {"Lcom/meizu/camera/effectlib/effects/renders/MediaRecordRender$RecordCallback;", "", "onDepthFrameAvailable", "", "effectlib_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.camera.effectlib.effects.b.e$b */
    /* compiled from: MediaRecordRender.kt */
    public interface C1156b {
        /* renamed from: a */
        void mo14066a();
    }

    /* renamed from: a */
    public final void mo14056a(@NotNull EGLContext eGLContext, @NotNull C1156b bVar) {
        Class[] clsArr = {EGLContext.class, C1156b.class};
        if (!PatchProxy.proxy(new Object[]{eGLContext, bVar}, this, f3514a, false, Opcodes.IF_ICMPEQ, clsArr, Void.TYPE).isSupported) {
            C3443i.m21155b(eGLContext, "eglContext");
            C3443i.m21155b(bVar, "listener");
            String str = f3505H;
            Log.d(str, "initThread: EGLContext: " + eGLContext);
            this.f3545y = eGLContext;
            this.f3546z = bVar;
            this.f3523c = new HandlerThread("SurfaceView Renderer Thread");
            HandlerThread handlerThread = this.f3523c;
            if (handlerThread == null) {
                C3443i.m21151a();
            }
            handlerThread.start();
            HandlerThread handlerThread2 = this.f3523c;
            if (handlerThread2 == null) {
                C3443i.m21151a();
            }
            this.f3524d = new C1157c(this, handlerThread2.getLooper());
            this.f3519D = EffectRenderFactory.m4739a().mo14330d(EffectRenderFactory.m4739a().mo14321a("Mznone"));
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo27294d2 = {"com/meizu/camera/effectlib/effects/renders/MediaRecordRender$init$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "effectlib_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.camera.effectlib.effects.b.e$c */
    /* compiled from: MediaRecordRender.kt */
    public static final class C1157c extends Handler {

        /* renamed from: a */
        public static ChangeQuickRedirect f3547a;

        /* renamed from: b */
        final /* synthetic */ MediaRecordRender f3548b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1157c(MediaRecordRender eVar, Looper looper) {
            super(looper);
            this.f3548b = eVar;
        }

        public void handleMessage(@NotNull Message message) {
            if (!PatchProxy.proxy(new Object[]{message}, this, f3547a, false, 180, new Class[]{Message.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(message, NotificationCompat.CATEGORY_MESSAGE);
                int i = message.what;
                if (i == MediaRecordRender.f3506I) {
                    this.f3548b.m4088j();
                } else if (i == MediaRecordRender.f3507J) {
                    this.f3548b.m4091m();
                } else if (i == MediaRecordRender.f3510M) {
                    this.f3548b.m4090l();
                } else if (i == MediaRecordRender.f3508K) {
                    this.f3548b.m4089k();
                } else if (i == MediaRecordRender.f3512O) {
                    GLES20.glClear(16384);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo14053a() {
        Handler handler;
        if (!PatchProxy.proxy(new Object[0], this, f3514a, false, Opcodes.IF_ICMPNE, new Class[0], Void.TYPE).isSupported && (handler = this.f3524d) != null) {
            handler.sendEmptyMessage(f3506I);
        }
    }

    /* renamed from: a */
    public final void mo14060a(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f3514a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, Opcodes.IF_ICMPLT, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f3518C = z;
            Handler handler = this.f3524d;
            if (handler != null) {
                handler.sendEmptyMessage(f3507J);
            }
        }
    }

    /* renamed from: b */
    public final void mo14062b() {
        Handler handler;
        if (!PatchProxy.proxy(new Object[0], this, f3514a, false, Opcodes.IF_ICMPGE, new Class[0], Void.TYPE).isSupported && this.f3524d != null && (handler = this.f3524d) != null) {
            handler.sendEmptyMessage(f3510M);
        }
    }

    /* renamed from: c */
    public final void mo14064c() {
        Handler handler;
        if (!PatchProxy.proxy(new Object[0], this, f3514a, false, Opcodes.IF_ICMPGT, new Class[0], Void.TYPE).isSupported && (handler = this.f3524d) != null) {
            handler.sendEmptyMessage(f3508K);
        }
    }

    /* renamed from: a */
    public final void mo14054a(int i) {
        this.f3543w = i;
    }

    /* renamed from: a */
    public final void mo14058a(@NotNull GLTexture cVar) {
        if (!PatchProxy.proxy(new Object[]{cVar}, this, f3514a, false, 164, new Class[]{GLTexture.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(cVar, "texture");
            String str = f3505H;
            Log.i(str, "setGLTexture id " + cVar.mo14028a());
            this.f3517B = cVar;
        }
    }

    /* renamed from: a */
    public final void mo14061a(@Nullable float[] fArr) {
        if (!PatchProxy.proxy(new Object[]{fArr}, this, f3514a, false, Opcodes.IF_ACMPEQ, new Class[]{float[].class}, Void.TYPE).isSupported && fArr != null) {
            System.arraycopy(fArr, 0, this.f3516A, 0, this.f3516A.length);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0044, code lost:
        r1 = r1.mo14046c();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo14059a(@org.jetbrains.annotations.NotNull java.lang.String r9) {
        /*
            r8 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r2 = 0
            r1[r2] = r9
            com.meizu.savior.ChangeQuickRedirect r3 = f3514a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r6[r2] = r0
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 166(0xa6, float:2.33E-43)
            r2 = r8
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = r0.isSupported
            if (r0 == 0) goto L_0x001d
            return
        L_0x001d:
            java.lang.String r0 = "renderType"
            kotlin.jvm.p108b.C3443i.m21155b(r9, r0)
            com.meizu.camera.effectlib.effects.views.b r0 = com.meizu.camera.effectlib.effects.views.EffectRenderFactory.m4739a()
            com.meizu.camera.effectlib.effects.views.b$c r9 = r0.mo14321a((java.lang.String) r9)
            com.meizu.camera.effectlib.effects.views.b r0 = com.meizu.camera.effectlib.effects.views.EffectRenderFactory.m4739a()
            com.meizu.camera.effectlib.effects.b.a r9 = r0.mo14332e(r9)
            r8.f3519D = r9
            java.lang.String r9 = f3505H
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "setRenderType   mRender :"
            r0.append(r1)
            com.meizu.camera.effectlib.effects.b.a r1 = r8.f3519D
            if (r1 == 0) goto L_0x004f
            com.meizu.camera.effectlib.effects.views.b$c r1 = r1.mo14046c()
            if (r1 == 0) goto L_0x004f
            java.lang.String r1 = r1.mo14345d()
            goto L_0x0050
        L_0x004f:
            r1 = 0
        L_0x0050:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.i(r9, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.p059b.MediaRecordRender.mo14059a(java.lang.String):void");
    }

    /* renamed from: a */
    public final void mo14055a(int i, int i2) {
        synchronized (this.f3527g) {
            this.f3528h = i;
            this.f3529i = i2;
            Unit tVar = Unit.f18749a;
        }
    }

    /* renamed from: b */
    public final void mo14063b(int i, int i2) {
        float f;
        int i3 = i;
        int i4 = i2;
        Object[] objArr = {new Integer(i3), new Integer(i4)};
        if (!PatchProxy.proxy(objArr, this, f3514a, false, 168, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            this.f3539s = true;
            this.f3544x = i3;
            mo14053a();
            String str = f3505H;
            Log.i(str, "startRecord: orientation" + this.f3544x);
            Matrix.setIdentityM(this.f3536p, 0);
            Matrix.setIdentityM(this.f3537q, 0);
            Matrix.rotateM(this.f3536p, 0, (float) i3, 0.0f, 0.0f, 1.0f);
            EffectRenderContext h = EffectRenderContext.m4369h();
            C3443i.m21152a((Object) h, "EffectRenderContext.getInstance()");
            this.f3529i = h.mo14239w();
            EffectRenderContext h2 = EffectRenderContext.m4369h();
            C3443i.m21152a((Object) h2, "EffectRenderContext.getInstance()");
            this.f3528h = h2.mo14240x();
            if (this.f3544x == 90 || this.f3544x == 270) {
                Matrix.rotateM(this.f3536p, 0, 180.0f, 0.0f, 0.0f, 1.0f);
                if (i4 == 1) {
                    f = ((float) this.f3544x) + 90.0f;
                } else {
                    f = ((float) this.f3544x) - 90.0f;
                }
            } else {
                f = ((float) this.f3544x) + 90.0f;
                EffectRenderContext h3 = EffectRenderContext.m4369h();
                C3443i.m21152a((Object) h3, "EffectRenderContext.getInstance()");
                this.f3529i = h3.mo14240x();
                EffectRenderContext h4 = EffectRenderContext.m4369h();
                C3443i.m21152a((Object) h4, "EffectRenderContext.getInstance()");
                this.f3528h = h4.mo14239w();
            }
            float f2 = f;
            String str2 = f3505H;
            Log.i(str2, "rotateM: mMVPVideoMatrix: " + f2);
            Matrix.rotateM(this.f3537q, 0, f2, 0.0f, 0.0f, 1.0f);
            if (i4 == 1) {
                Matrix.rotateM(this.f3537q, 0, 180.0f, 0.0f, 1.0f, 0.0f);
            }
        }
    }

    /* renamed from: d */
    public final void mo14065d() {
        if (!PatchProxy.proxy(new Object[0], this, f3514a, false, Opcodes.RET, new Class[0], Void.TYPE).isSupported) {
            Log.i(f3505H, "sstopNightVisionRecord");
            this.f3539s = false;
            mo14062b();
        }
    }

    /* renamed from: a */
    public final void mo14057a(@NotNull Surface surface) {
        if (!PatchProxy.proxy(new Object[]{surface}, this, f3514a, false, 170, new Class[]{Surface.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(surface, "surface");
            String str = f3505H;
            Log.i(str, "onMediaSufacePrepared: " + surface);
            this.f3540t = surface;
            this.f3541u = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public final void m4088j() {
        if (!PatchProxy.proxy(new Object[0], this, f3514a, false, 171, new Class[0], Void.TYPE).isSupported) {
            Log.d(f3505H, "initEGL");
            if (this.f3525e == null) {
                this.f3525e = new SurfaceManager(true);
                SurfaceManager bVar = this.f3525e;
                if (bVar == null) {
                    C3443i.m21151a();
                }
                EffectRenderContext effectRenderContext = EffectRenderContext.f3778b;
                C3443i.m21152a((Object) effectRenderContext, "EffectRenderContext.sInstance");
                bVar.mo14093a(effectRenderContext.mo14168M());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public final void m4089k() {
        if (!PatchProxy.proxy(new Object[0], this, f3514a, false, 172, new Class[0], Void.TYPE).isSupported) {
            Log.i(f3505H, "onDestroyGL");
            m4090l();
            HandlerThread handlerThread = this.f3523c;
            if (handlerThread == null) {
                C3443i.m21151a();
            }
            handlerThread.getLooper().quit();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public final void m4090l() {
        if (!PatchProxy.proxy(new Object[0], this, f3514a, false, 173, new Class[0], Void.TYPE).isSupported) {
            synchronized (this.f3526f) {
                Log.i(f3505H, "onRelease");
                this.f3542v = false;
                if (this.f3525e != null) {
                    SurfaceManager bVar = this.f3525e;
                    if (bVar == null) {
                        C3443i.m21151a();
                    }
                    bVar.mo14097c();
                    this.f3525e = null;
                }
                if (this.f3530j != null) {
                    DepthRenderProgram aVar = this.f3530j;
                    if (aVar == null) {
                        C3443i.m21151a();
                    }
                    aVar.mo14313h();
                    this.f3530j = null;
                }
                EffectRenderContext.m4369h().mo14162G();
                Unit tVar = Unit.f18749a;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public final void m4091m() {
        if (!PatchProxy.proxy(new Object[0], this, f3514a, false, 174, new Class[0], Void.TYPE).isSupported) {
            synchronized (this.f3526f) {
                if (this.f3539s && this.f3525e != null) {
                    if (this.f3541u) {
                        SurfaceManager bVar = this.f3525e;
                        if (bVar == null) {
                            C3443i.m21151a();
                        }
                        bVar.mo14094a(this.f3540t);
                        this.f3541u = false;
                        GLES20.glClear(16384);
                        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                    }
                    if (this.f3518C) {
                        m4078a(this.f3516A, this.f3537q);
                        if (this.f3525e != null) {
                            SurfaceManager bVar2 = this.f3525e;
                            if (bVar2 == null) {
                                C3443i.m21151a();
                            }
                            bVar2.mo14096b();
                        }
                        if (this.f3546z != null) {
                            C1156b bVar3 = this.f3546z;
                            if (bVar3 == null) {
                                C3443i.m21151a();
                            }
                            bVar3.mo14066a();
                        }
                    } else {
                        if (this.f3530j == null) {
                            this.f3530j = new DepthRenderProgram();
                            DepthRenderProgram aVar = this.f3530j;
                            if (aVar == null) {
                                C3443i.m21151a();
                            }
                            aVar.mo14312g();
                            m4092n();
                        }
                        synchronized (this.f3527g) {
                            m4080c(this.f3528h, this.f3529i);
                            if (this.f3525e != null) {
                                SurfaceManager bVar4 = this.f3525e;
                                if (bVar4 == null) {
                                    C3443i.m21151a();
                                }
                                bVar4.mo14096b();
                            }
                            if (this.f3546z != null) {
                                C1156b bVar5 = this.f3546z;
                                if (bVar5 == null) {
                                    C3443i.m21151a();
                                }
                                bVar5.mo14066a();
                            }
                            Unit tVar = Unit.f18749a;
                        }
                    }
                }
                Unit tVar2 = Unit.f18749a;
            }
        }
    }

    /* renamed from: n */
    private final void m4092n() {
        if (!PatchProxy.proxy(new Object[0], this, f3514a, false, Opcodes.ARETURN, new Class[0], Void.TYPE).isSupported) {
            Log.v(f3505H, "initDepthRenderProgram");
            DepthRenderProgram aVar = this.f3530j;
            if (aVar == null) {
                C3443i.m21151a();
            }
            aVar.mo14311f();
        }
    }

    /* renamed from: c */
    private final void m4080c(int i, int i2) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, f3514a, false, Opcodes.RETURN, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            DepthRenderProgram aVar = this.f3530j;
            if (aVar == null) {
                C3443i.m21151a();
            }
            FloatBuffer a = aVar.mo14304a();
            DepthRenderProgram aVar2 = this.f3530j;
            if (aVar2 == null) {
                C3443i.m21151a();
            }
            FloatBuffer b = aVar2.mo14307b();
            DepthRenderProgram aVar3 = this.f3530j;
            if (aVar3 == null) {
                C3443i.m21151a();
            }
            this.f3533m = GLES20.glGetAttribLocation(aVar3.mo14309d(), DepthRenderProgram.f4020b.mo14315a());
            DepthRenderProgram aVar4 = this.f3530j;
            if (aVar4 == null) {
                C3443i.m21151a();
            }
            this.f3534n = GLES20.glGetAttribLocation(aVar4.mo14309d(), DepthRenderProgram.f4020b.mo14316b());
            DepthRenderProgram aVar5 = this.f3530j;
            if (aVar5 == null) {
                C3443i.m21151a();
            }
            this.f3531k = GLES20.glGetUniformLocation(aVar5.mo14309d(), DepthRenderProgram.f4020b.mo14318d());
            DepthRenderProgram aVar6 = this.f3530j;
            if (aVar6 == null) {
                C3443i.m21151a();
            }
            this.f3535o = GLES20.glGetUniformLocation(aVar6.mo14309d(), DepthRenderProgram.f4020b.mo14317c());
            DepthRenderProgram aVar7 = this.f3530j;
            if (aVar7 == null) {
                C3443i.m21151a();
            }
            if (!aVar7.mo14310e()) {
                Log.i(f3505H, "RenderProgram not ready");
                return;
            }
            DepthRenderProgram aVar8 = this.f3530j;
            if (aVar8 == null) {
                C3443i.m21151a();
            }
            GLES20.glUseProgram(aVar8.mo14309d());
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.f3543w);
            GLES20.glUniform1i(this.f3531k, 0);
            if (a == null) {
                C3443i.m21151a();
            }
            a.position(0);
            GLES20.glBindBuffer(34962, 0);
            GLES20.glBindBuffer(34963, 0);
            GLES20.glVertexAttribPointer(this.f3533m, 3, 5126, false, 12, a);
            DepthRenderProgram aVar9 = this.f3530j;
            if (aVar9 == null) {
                C3443i.m21151a();
            }
            aVar9.mo14306a("glVertexAttribPointer PositionLocation");
            GLES20.glEnableVertexAttribArray(this.f3533m);
            DepthRenderProgram aVar10 = this.f3530j;
            if (aVar10 == null) {
                C3443i.m21151a();
            }
            aVar10.mo14306a("glEnableVertexAttribArray PositionLocation");
            if (b == null) {
                C3443i.m21151a();
            }
            b.position(0);
            GLES20.glVertexAttribPointer(this.f3534n, 2, 5126, false, 8, b);
            GLES20.glEnableVertexAttribArray(this.f3534n);
            DepthRenderProgram aVar11 = this.f3530j;
            if (aVar11 == null) {
                C3443i.m21151a();
            }
            aVar11.mo14306a("glEnableVertexAttribArray TextureCoordLocation");
            GLES20.glUniformMatrix4fv(this.f3535o, 1, false, this.f3536p, 0);
            DepthRenderProgram aVar12 = this.f3530j;
            if (aVar12 == null) {
                C3443i.m21151a();
            }
            aVar12.mo14306a("glUniformMatrix4fv mMVPMatrix");
            int length = this.f3538r.length;
            DepthRenderProgram aVar13 = this.f3530j;
            if (aVar13 == null) {
                C3443i.m21151a();
            }
            GLES20.glDrawElements(4, length, 5123, aVar13.mo14308c());
            DepthRenderProgram aVar14 = this.f3530j;
            if (aVar14 == null) {
                C3443i.m21151a();
            }
            aVar14.mo14306a("glDrawElements");
        }
    }

    /* renamed from: a */
    private final void m4078a(float[] fArr, float[] fArr2) {
        Class[] clsArr = {float[].class, float[].class};
        if (!PatchProxy.proxy(new Object[]{fArr, fArr2}, this, f3514a, false, Opcodes.GETSTATIC, clsArr, Void.TYPE).isSupported && this.f3517B != null) {
            try {
                if (this.f3519D != null) {
                    BaseRender aVar = this.f3519D;
                    if (aVar == null) {
                        C3443i.m21151a();
                    }
                    aVar.mo14043a(this.f3521F);
                    BaseRender aVar2 = this.f3519D;
                    if (aVar2 == null) {
                        C3443i.m21151a();
                    }
                    aVar2.mo14045b(this.f3522G);
                    BaseRender aVar3 = this.f3519D;
                    if (aVar3 == null) {
                        C3443i.m21151a();
                    }
                    aVar3.mo14047c(fArr2);
                    BaseRender aVar4 = this.f3519D;
                    if (aVar4 == null) {
                        C3443i.m21151a();
                    }
                    aVar4.mo14049d(fArr);
                    BaseRender aVar5 = this.f3519D;
                    if (aVar5 == null) {
                        C3443i.m21151a();
                    }
                    aVar5.mo14040a(this.f3517B, 0, 0, this.f3528h, this.f3529i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo27294d2 = {"Lcom/meizu/camera/effectlib/effects/renders/MediaRecordRender$Companion;", "", "()V", "MSG_ATTACH", "", "MSG_CLEAN_SCREEN", "MSG_DEINIT", "MSG_DETACH", "MSG_INIT", "MSG_RELEASE", "MSG_RENDER", "MSG_UPDATETEXTURE", "TAG", "", "saveJpeg", "", "jpegpath", "bitmap", "Landroid/graphics/Bitmap;", "effectlib_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.camera.effectlib.effects.b.e$a */
    /* compiled from: MediaRecordRender.kt */
    public static final class C1155a {
        private C1155a() {
        }

        public /* synthetic */ C1155a(DefaultConstructorMarker gVar) {
            this();
        }
    }
}
