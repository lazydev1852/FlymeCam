package com.meizu.camera.effectlib.effects.views;

import android.opengl.EGL14;
import android.opengl.GLES20;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.mediatek.accessor.packer.PackUtils;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import kotlin.Metadata;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0017\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 52\u00020\u0001:\u00015B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020 J\u0006\u0010$\u001a\u00020\u0012J\u0006\u0010%\u001a\u00020 J\u0016\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u0012J\u0016\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\"J\u000e\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020\u0012J\u0006\u0010.\u001a\u00020 J(\u0010/\u001a\u00020 2\b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u00020\u0012R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0012XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u001e\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0012@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u00066"}, mo27294d2 = {"Lcom/meizu/camera/effectlib/effects/views/DepthRenderProgram;", "", "()V", "<set-?>", "Ljava/nio/FloatBuffer;", "coordBuffer", "getCoordBuffer", "()Ljava/nio/FloatBuffer;", "Ljava/nio/ShortBuffer;", "drawlistBuffer", "getDrawlistBuffer", "()Ljava/nio/ShortBuffer;", "", "isReady", "()Z", "mDrawOrder", "", "mFragmenEffectShader", "", "mFragmentShader", "mTriangleUVData", "", "mTriangleVerticesData", "mVertexData", "mVertexEffectShader", "mVertexShader", "postionBuffer", "getPostionBuffer", "program", "getProgram", "()I", "checkEglError", "", "msg", "", "createBuffer", "createTextureId", "initProgram", "linkProgram", "verShader", "fragShader", "loadShader", "type", "shaderSource", "recycleTexture", "textureid", "release", "setBitmap", "bitmap", "Landroid/graphics/Bitmap;", "w", "h", "mTextureID", "Companion", "effectlib_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.camera.effectlib.effects.views.a */
public final class DepthRenderProgram {

    /* renamed from: a */
    public static ChangeQuickRedirect f4019a = null;

    /* renamed from: b */
    public static final C1187a f4020b = new C1187a((DefaultConstructorMarker) null);

    /* renamed from: p */
    private static final String f4021p = f4021p;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: q */
    public static final String f4022q = f4022q;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: r */
    public static final String f4023r = f4023r;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: s */
    public static final String f4024s = f4024s;
    @NotNull

    /* renamed from: t */
    private static final String f4025t = f4025t;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: u */
    public static final String f4026u = f4026u;

    /* renamed from: v */
    private static final String f4027v = f4027v;

    /* renamed from: w */
    private static final String f4028w = f4028w;
    @Nullable

    /* renamed from: c */
    private FloatBuffer f4029c;
    @Nullable

    /* renamed from: d */
    private FloatBuffer f4030d;
    @Nullable

    /* renamed from: e */
    private ShortBuffer f4031e;

    /* renamed from: f */
    private int f4032f = -1;

    /* renamed from: g */
    private int f4033g = -1;

    /* renamed from: h */
    private int f4034h = -1;

    /* renamed from: i */
    private final int f4035i = -1;

    /* renamed from: j */
    private final int f4036j = -1;

    /* renamed from: k */
    private boolean f4037k = false;

    /* renamed from: l */
    private final float[] f4038l = {1.0f, 1.0f, 1.0f, 0.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, 1.0f, -1.0f, 0.0f, 0.0f};

    /* renamed from: m */
    private final short[] f4039m = {0, 1, 2, 2, 1, 3};

    /* renamed from: n */
    private final float[] f4040n = {-1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f};

    /* renamed from: o */
    private final float[] f4041o = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};

    @Nullable
    /* renamed from: a */
    public final FloatBuffer mo14304a() {
        return this.f4029c;
    }

    @Nullable
    /* renamed from: b */
    public final FloatBuffer mo14307b() {
        return this.f4030d;
    }

    @Nullable
    /* renamed from: c */
    public final ShortBuffer mo14308c() {
        return this.f4031e;
    }

    /* renamed from: d */
    public final int mo14309d() {
        return this.f4034h;
    }

    /* renamed from: e */
    public final boolean mo14310e() {
        return this.f4037k;
    }

    /* renamed from: f */
    public final void mo14311f() {
        if (!PatchProxy.proxy(new Object[0], this, f4019a, false, 249, new Class[0], Void.TYPE).isSupported && !this.f4037k) {
            Log.i(f4021p, "initProgram");
            this.f4032f = mo14303a(35633, f4027v);
            this.f4033g = mo14303a(35632, f4028w);
            this.f4034h = mo14302a(this.f4032f, this.f4033g);
            this.f4037k = true;
        }
    }

    /* renamed from: g */
    public final void mo14312g() {
        if (!PatchProxy.proxy(new Object[0], this, f4019a, false, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, new Class[0], Void.TYPE).isSupported) {
            this.f4029c = ByteBuffer.allocateDirect(this.f4040n.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            FloatBuffer floatBuffer = this.f4029c;
            if (floatBuffer == null) {
                C3443i.m21151a();
            }
            floatBuffer.put(this.f4040n).position(0);
            this.f4030d = ByteBuffer.allocateDirect(this.f4041o.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            FloatBuffer floatBuffer2 = this.f4030d;
            if (floatBuffer2 == null) {
                C3443i.m21151a();
            }
            floatBuffer2.put(this.f4041o).position(0);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.f4039m.length * 2);
            allocateDirect.order(ByteOrder.nativeOrder());
            this.f4031e = allocateDirect.asShortBuffer();
            ShortBuffer shortBuffer = this.f4031e;
            if (shortBuffer == null) {
                C3443i.m21151a();
            }
            shortBuffer.put(this.f4039m);
            ShortBuffer shortBuffer2 = this.f4031e;
            if (shortBuffer2 == null) {
                C3443i.m21151a();
            }
            shortBuffer2.position(0);
        }
    }

    /* renamed from: a */
    public final int mo14303a(int i, @NotNull String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), str}, this, f4019a, false, 251, new Class[]{Integer.TYPE, String.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        C3443i.m21155b(str, "shaderSource");
        int glCreateShader = GLES20.glCreateShader(i);
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] != 0) {
                return glCreateShader;
            }
            int[] iArr2 = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35716, iArr2, 0);
            if (iArr2[0] > 1) {
                String glGetShaderInfoLog = GLES20.glGetShaderInfoLog(glCreateShader);
                String str2 = f4021p;
                Log.e(str2, "Error Compiling shader" + glGetShaderInfoLog);
            }
            GLES20.glDeleteShader(glCreateShader);
            return 0;
        }
        throw new IllegalStateException("Create Shader Failed!" + GLES20.glGetError());
    }

    /* renamed from: a */
    public final int mo14302a(int i, int i2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, f4019a, false, 252, new Class[]{Integer.TYPE, Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, i);
            GLES20.glAttachShader(glCreateProgram, i2);
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 0) {
                return glCreateProgram;
            }
            int[] iArr2 = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35716, iArr2, 0);
            if (iArr2[0] > 1) {
                String glGetProgramInfoLog = GLES20.glGetProgramInfoLog(glCreateProgram);
                String str = f4021p;
                Log.e(str, "Error linking program: " + glGetProgramInfoLog);
            }
            GLES20.glDeleteProgram(glCreateProgram);
            return 0;
        }
        throw new IllegalStateException("Create Program Failed: " + GLES20.glGetError());
    }

    /* renamed from: h */
    public final void mo14313h() {
        if (!PatchProxy.proxy(new Object[0], this, f4019a, false, 253, new Class[0], Void.TYPE).isSupported) {
            Log.i(f4021p, "release");
            FloatBuffer floatBuffer = this.f4029c;
            if (floatBuffer == null) {
                C3443i.m21151a();
            }
            floatBuffer.clear();
            ShortBuffer shortBuffer = this.f4031e;
            if (shortBuffer == null) {
                C3443i.m21151a();
            }
            shortBuffer.clear();
            FloatBuffer floatBuffer2 = this.f4030d;
            if (floatBuffer2 == null) {
                C3443i.m21151a();
            }
            floatBuffer2.clear();
            FloatBuffer floatBuffer3 = null;
            this.f4029c = floatBuffer3;
            this.f4031e = null;
            this.f4030d = floatBuffer3;
            if (this.f4037k) {
                Log.i(f4021p, "glDeleteProgram");
                GLES20.glDeleteProgram(this.f4034h);
                mo14306a("glDeleteProgram");
                this.f4037k = false;
            }
        }
    }

    /* renamed from: i */
    public final int mo14314i() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f4019a, false, 254, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        float f = (float) 9729;
        GLES20.glTexParameterf(3553, PackUtils.FIXED_BUFFER_SIZE, f);
        GLES20.glTexParameterf(3553, 10241, f);
        float f2 = (float) 33071;
        GLES20.glTexParameterf(3553, 10242, f2);
        GLES20.glTexParameterf(3553, 10243, f2);
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            String str = f4021p;
            Log.e(str, "Create Texture failed!:" + glGetError);
        }
        GLES20.glBindTexture(3553, 0);
        String str2 = f4021p;
        Log.d(str2, "Create Texture:" + iArr[0]);
        return iArr[0];
    }

    /* renamed from: a */
    public final void mo14305a(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f4019a, false, 256, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            String str = f4021p;
            Log.e(str, "glDeleteTextures texture:" + i);
            if (i != -1) {
                GLES20.glDeleteTextures(1, new int[]{i}, 0);
                mo14306a("glDeleteTextures");
            }
        }
    }

    /* renamed from: a */
    public final void mo14306a(@NotNull String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f4019a, false, 257, new Class[]{String.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(str, NotificationCompat.CATEGORY_MESSAGE);
            int eglGetError = EGL14.eglGetError();
            if (eglGetError != 12288) {
                Log.d("CameraGLOnDraw", str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
                throw new IllegalStateException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u000e\u0010\n\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0007R\u000e\u0010\u0011\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo27294d2 = {"Lcom/meizu/camera/effectlib/effects/views/DepthRenderProgram$Companion;", "", "()V", "FRAGMENT_SHADER", "", "MVP_MATRIX", "getMVP_MATRIX", "()Ljava/lang/String;", "POSITION_ATTRIBUTE", "getPOSITION_ATTRIBUTE", "TAG", "TEXTURE_ATTRIBUTE", "getTEXTURE_ATTRIBUTE", "TEXTURE_COORD_ATTRIBUTE", "getTEXTURE_COORD_ATTRIBUTE", "TEX_MATRIX", "getTEX_MATRIX", "VERTEX_SHADER", "effectlib_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.camera.effectlib.effects.views.a$a */
    /* compiled from: DepthRenderProgram.kt */
    public static final class C1187a {

        /* renamed from: a */
        public static ChangeQuickRedirect f4042a;

        private C1187a() {
        }

        public /* synthetic */ C1187a(DefaultConstructorMarker gVar) {
            this();
        }

        @NotNull
        /* renamed from: a */
        public final String mo14315a() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f4042a, false, 258, new Class[0], String.class);
            return proxy.isSupported ? (String) proxy.result : DepthRenderProgram.f4022q;
        }

        @NotNull
        /* renamed from: b */
        public final String mo14316b() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f4042a, false, 259, new Class[0], String.class);
            return proxy.isSupported ? (String) proxy.result : DepthRenderProgram.f4023r;
        }

        @NotNull
        /* renamed from: c */
        public final String mo14317c() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f4042a, false, 260, new Class[0], String.class);
            return proxy.isSupported ? (String) proxy.result : DepthRenderProgram.f4024s;
        }

        @NotNull
        /* renamed from: d */
        public final String mo14318d() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f4042a, false, 262, new Class[0], String.class);
            return proxy.isSupported ? (String) proxy.result : DepthRenderProgram.f4026u;
        }
    }
}
