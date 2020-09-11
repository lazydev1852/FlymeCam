package com.meizu.camera.effectlib.effects.filters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.hardware.camera2.TotalCaptureResult;
import android.location.Location;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import com.mediatek.accessor.packer.PackUtils;
import com.meizu.camera.effectlib.effects.p058a.GLTexture3D;
import com.meizu.camera.effectlib.effects.views.EffectRenderFactory;
import com.meizu.camera.effectlib.utils.C1198Utils;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class EffectRenderEngine {

    /* renamed from: a */
    public static ChangeQuickRedirect f3556a;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public SceneType f3557A = SceneType.TYPE_NONE;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public SparseArray<C1162c> f3558B = new SparseArray<>();

    /* renamed from: C */
    private final AtomicInteger f3559C = new AtomicInteger(1);

    /* renamed from: b */
    private final Object f3560b = new Object();

    /* renamed from: c */
    private C1159a f3561c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public EffectRenderProgram f3562d;

    /* renamed from: e */
    private boolean f3563e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f3564f = -1;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f3565g = -1;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f3566h = -1;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C1161b f3567i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f3568j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f3569k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f3570l = 0;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f3571m = 0;

    /* renamed from: n */
    private int f3572n = 0;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public Context f3573o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f3574p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public short[] f3575q = {0, 2, 1, 1, 2, 3};
    /* access modifiers changed from: private */

    /* renamed from: r */
    public final float[] f3576r = new float[16];

    /* renamed from: s */
    private final float[] f3577s = new float[16];
    /* access modifiers changed from: private */

    /* renamed from: t */
    public EffectRenderFactory.C1191c f3578t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public boolean f3579u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public float f3580v = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public float f3581w = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public float f3582x = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public float f3583y = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public float f3584z = 128.0f;

    public enum SceneType {
        TYPE_LUTSCENE,
        TYPE_NORMALSCENE,
        TYPE_COLOREFFECT,
        TYPE_NONE;
        
        public static ChangeQuickRedirect changeQuickRedirect;
    }

    /* renamed from: com.meizu.camera.effectlib.effects.filters.EffectRenderEngine$b */
    public interface C1161b {
        /* renamed from: a */
        void mo14080a();

        /* renamed from: a */
        void mo14081a(UUID uuid, byte[] bArr, byte[] bArr2, String str, long j, int i, Location location, int i2, int i3, boolean z, int i4, boolean z2, int i5, Rect rect, TotalCaptureResult totalCaptureResult, String str2, boolean z3, boolean z4, int i6, boolean z5, boolean z6, boolean z7);

        /* renamed from: a */
        void mo14082a(byte[] bArr, byte[] bArr2, long j, Location location, int i, int i2, boolean z, int i3, boolean z2, int i4, Rect rect, TotalCaptureResult totalCaptureResult, String str, boolean z3, boolean z4, int i5, boolean z5);
    }

    /* renamed from: com.meizu.camera.effectlib.effects.filters.EffectRenderEngine$c */
    private class C1162c {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public UUID f3617b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public String f3618c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public long f3619d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public int f3620e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public Location f3621f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public int f3622g;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public int f3623h;
        /* access modifiers changed from: private */

        /* renamed from: i */
        public boolean f3624i;
        /* access modifiers changed from: private */

        /* renamed from: j */
        public int f3625j;
        /* access modifiers changed from: private */

        /* renamed from: k */
        public int f3626k;
        /* access modifiers changed from: private */

        /* renamed from: l */
        public Rect f3627l;
        /* access modifiers changed from: private */

        /* renamed from: m */
        public TotalCaptureResult f3628m;
        /* access modifiers changed from: private */

        /* renamed from: n */
        public boolean f3629n;
        /* access modifiers changed from: private */

        /* renamed from: o */
        public String f3630o;
        /* access modifiers changed from: private */

        /* renamed from: p */
        public boolean f3631p;
        /* access modifiers changed from: private */

        /* renamed from: q */
        public boolean f3632q;
        /* access modifiers changed from: private */

        /* renamed from: r */
        public int f3633r;
        /* access modifiers changed from: private */

        /* renamed from: s */
        public boolean f3634s;
        /* access modifiers changed from: private */

        /* renamed from: t */
        public boolean f3635t;
        /* access modifiers changed from: private */

        /* renamed from: u */
        public boolean f3636u;

        private C1162c() {
        }
    }

    public EffectRenderEngine(Context context) {
        this.f3573o = context;
        this.f3561c = new C1159a();
        this.f3562d = new EffectRenderProgram();
        this.f3562d.mo14086b();
        Matrix.setIdentityM(this.f3576r, 0);
        Matrix.rotateM(this.f3576r, 0, 180.0f, 0.0f, 1.0f, 0.0f);
        Matrix.rotateM(this.f3576r, 0, 180.0f, 0.0f, 0.0f, 1.0f);
        Matrix.setIdentityM(this.f3577s, 0);
    }

    /* renamed from: a */
    public void mo14068a() {
        if (!PatchProxy.proxy(new Object[0], this, f3556a, false, 10, new Class[0], Void.TYPE).isSupported) {
            synchronized (this.f3560b) {
                Log.i("EffectRenderEngine", "init");
                if (!this.f3563e && this.f3561c != null) {
                    this.f3563e = true;
                    this.f3561c.mo14077a();
                }
                Log.i("EffectRenderEngine", "init end");
            }
        }
    }

    /* renamed from: a */
    public void mo14069a(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f3556a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 11, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            this.f3570l = i;
            this.f3571m = i2;
            Log.i("EffectRenderEngine", "setPictureSize:" + this.f3570l + "x" + this.f3571m);
        }
    }

    /* renamed from: a */
    public void mo14072a(UUID uuid, byte[] bArr, String str, long j, int i, Location location, int i2, int i3, boolean z, int i4, boolean z2, int i5, Rect rect, TotalCaptureResult totalCaptureResult, String str2, boolean z3, boolean z4, int i6, boolean z5, boolean z6, boolean z7) {
        UUID uuid2 = uuid;
        String str3 = str;
        long j2 = j;
        int i7 = i;
        Location location2 = location;
        int i8 = i2;
        int i9 = i3;
        boolean z8 = z2;
        TotalCaptureResult totalCaptureResult2 = totalCaptureResult;
        String str4 = str2;
        Object[] objArr = new Object[21];
        objArr[0] = uuid2;
        objArr[1] = bArr;
        objArr[2] = str3;
        objArr[3] = new Long(j2);
        objArr[4] = new Integer(i7);
        objArr[5] = location2;
        objArr[6] = new Integer(i8);
        objArr[7] = new Integer(i9);
        objArr[8] = new Byte(z ? (byte) 1 : 0);
        objArr[9] = new Integer(i4);
        objArr[10] = new Byte(z8 ? (byte) 1 : 0);
        objArr[11] = new Integer(i5);
        objArr[12] = rect;
        Object[] objArr2 = objArr;
        objArr2[13] = totalCaptureResult;
        String str5 = str2;
        objArr2[14] = str5;
        objArr2[15] = new Byte(z3 ? (byte) 1 : 0);
        objArr2[16] = new Byte(z4 ? (byte) 1 : 0);
        objArr2[17] = new Integer(i6);
        objArr2[18] = new Byte(z5 ? (byte) 1 : 0);
        objArr2[19] = new Byte(z6 ? (byte) 1 : 0);
        objArr2[20] = new Byte(z7 ? (byte) 1 : 0);
        ChangeQuickRedirect changeQuickRedirect = f3556a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        boolean z9 = z8;
        int i10 = i9;
        if (!PatchProxy.proxy(objArr2, this, changeQuickRedirect2, false, 13, new Class[]{UUID.class, byte[].class, String.class, Long.TYPE, Integer.TYPE, Location.class, Integer.TYPE, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Rect.class, TotalCaptureResult.class, String.class, Boolean.TYPE, Boolean.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            Log.i("EffectRenderEngine", "doEffect");
            C1162c cVar = new C1162c();
            UUID unused = cVar.f3617b = uuid2;
            String unused2 = cVar.f3618c = str3;
            long unused3 = cVar.f3619d = j2;
            int unused4 = cVar.f3620e = i7;
            Location unused5 = cVar.f3621f = location2;
            int unused6 = cVar.f3622g = i8;
            int unused7 = cVar.f3623h = i10;
            boolean unused8 = cVar.f3624i = z;
            int unused9 = cVar.f3625j = i4;
            boolean unused10 = cVar.f3629n = z9;
            int unused11 = cVar.f3626k = i5;
            Rect unused12 = cVar.f3627l = rect;
            TotalCaptureResult unused13 = cVar.f3628m = totalCaptureResult;
            String unused14 = cVar.f3630o = str5;
            boolean unused15 = cVar.f3631p = z3;
            boolean unused16 = cVar.f3632q = z4;
            int unused17 = cVar.f3633r = i6;
            boolean unused18 = cVar.f3634s = z5;
            boolean unused19 = cVar.f3635t = z6;
            boolean unused20 = cVar.f3636u = z7;
            mo14069a(i8, i10);
            this.f3579u = false;
            if (this.f3557A == SceneType.TYPE_NONE) {
                Log.i("EffectRenderEngine", "not effect render");
                this.f3567i.mo14081a(cVar.f3617b, (byte[]) null, bArr, cVar.f3618c, cVar.f3619d, cVar.f3620e, cVar.f3621f, cVar.f3622g, cVar.f3623h, cVar.f3624i, cVar.f3625j, cVar.f3629n, cVar.f3626k, cVar.f3627l, cVar.f3628m, cVar.f3630o, cVar.f3631p, cVar.f3632q, cVar.f3633r, cVar.f3634s, cVar.f3635t, cVar.f3636u);
                return;
            }
            int andIncrement = this.f3559C.getAndIncrement();
            Log.i("EffectRenderEngine", "put pramData for index: " + andIncrement);
            this.f3558B.put(andIncrement, cVar);
            this.f3561c.m4156a(bArr, andIncrement);
        }
    }

    /* renamed from: a */
    public void mo14073a(byte[] bArr, long j, Location location, int i, int i2, boolean z, int i3, int i4, Rect rect, TotalCaptureResult totalCaptureResult, String str, boolean z2, boolean z3, int i5, boolean z4) {
        long j2 = j;
        Location location2 = location;
        int i6 = i;
        int i7 = i2;
        boolean z5 = z;
        int i8 = i3;
        int i9 = i4;
        String str2 = str;
        int i10 = i5;
        Object[] objArr = new Object[15];
        objArr[0] = bArr;
        objArr[1] = new Long(j2);
        objArr[2] = location2;
        objArr[3] = new Integer(i6);
        objArr[4] = new Integer(i7);
        objArr[5] = new Byte(z5 ? (byte) 1 : 0);
        objArr[6] = new Integer(i8);
        objArr[7] = new Integer(i9);
        objArr[8] = rect;
        objArr[9] = totalCaptureResult;
        objArr[10] = str2;
        objArr[11] = new Byte(z2 ? (byte) 1 : 0);
        objArr[12] = new Byte(z3 ? (byte) 1 : 0);
        Object[] objArr2 = objArr;
        objArr2[13] = new Integer(i5);
        objArr2[14] = new Byte(z4 ? (byte) 1 : 0);
        ChangeQuickRedirect changeQuickRedirect = f3556a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        String str3 = str2;
        int i11 = i9;
        if (!PatchProxy.proxy(objArr2, this, changeQuickRedirect2, false, 14, new Class[]{byte[].class, Long.TYPE, Location.class, Integer.TYPE, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Rect.class, TotalCaptureResult.class, String.class, Boolean.TYPE, Boolean.TYPE, Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            Log.i("EffectRenderEngine", "doThirdEffect");
            C1162c cVar = new C1162c();
            long unused = cVar.f3619d = j2;
            Location unused2 = cVar.f3621f = location2;
            int unused3 = cVar.f3622g = i6;
            int unused4 = cVar.f3623h = i7;
            boolean unused5 = cVar.f3624i = z5;
            int unused6 = cVar.f3625j = i8;
            int unused7 = cVar.f3626k = i11;
            Rect unused8 = cVar.f3627l = rect;
            TotalCaptureResult unused9 = cVar.f3628m = totalCaptureResult;
            String unused10 = cVar.f3630o = str3;
            boolean unused11 = cVar.f3631p = z2;
            boolean unused12 = cVar.f3632q = z3;
            int unused13 = cVar.f3633r = i5;
            boolean unused14 = cVar.f3635t = z4;
            mo14069a(i6, i7);
            this.f3579u = true;
            if (this.f3557A == SceneType.TYPE_NONE) {
                Log.i("EffectRenderEngine", "not effect render");
                this.f3567i.mo14082a((byte[]) null, bArr, cVar.f3619d, cVar.f3621f, cVar.f3622g, cVar.f3623h, cVar.f3624i, cVar.f3625j, cVar.f3629n, cVar.f3626k, cVar.f3627l, cVar.f3628m, cVar.f3630o, cVar.f3631p, cVar.f3632q, cVar.f3633r, cVar.f3635t);
                return;
            }
            int andIncrement = this.f3559C.getAndIncrement();
            Log.i("EffectRenderEngine", "put pramData for index: " + andIncrement);
            this.f3558B.put(andIncrement, cVar);
            this.f3561c.m4156a(bArr, andIncrement);
        }
    }

    /* renamed from: a */
    public void mo14070a(C1161b bVar) {
        this.f3567i = bVar;
    }

    /* renamed from: a */
    public void mo14071a(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f3556a, false, 16, new Class[]{String.class}, Void.TYPE).isSupported) {
            Log.d("EffectRenderEngine", "setRenderType:" + str);
            this.f3578t = EffectRenderFactory.m4739a().mo14321a(str);
            if (this.f3578t.mo14345d().contains("normalscene")) {
                this.f3557A = SceneType.TYPE_NORMALSCENE;
            } else if (this.f3578t.mo14342a().contains("Lut")) {
                this.f3557A = SceneType.TYPE_LUTSCENE;
                Log.d("EffectRenderEngine", "setRenderTypeLUT");
            } else if (this.f3578t.mo14345d().contains("none") || this.f3578t.mo14345d().contains("vface beauty")) {
                this.f3557A = SceneType.TYPE_NONE;
            } else {
                this.f3557A = SceneType.TYPE_COLOREFFECT;
            }
        }
    }

    /* renamed from: b */
    public void mo14074b() {
        if (!PatchProxy.proxy(new Object[0], this, f3556a, false, 17, new Class[0], Void.TYPE).isSupported) {
            Log.i("EffectRenderEngine", "release");
            if (this.f3561c != null) {
                this.f3561c.m4159c();
            }
            if (this.f3561c != null && this.f3563e) {
                this.f3561c.m4161d();
                this.f3563e = false;
            }
        }
    }

    /* renamed from: com.meizu.camera.effectlib.effects.filters.EffectRenderEngine$a */
    private class C1159a {

        /* renamed from: a */
        public static ChangeQuickRedirect f3585a;

        /* renamed from: A */
        private final int f3586A;

        /* renamed from: B */
        private final int f3587B;

        /* renamed from: C */
        private final int f3588C;

        /* renamed from: c */
        private HandlerThread f3590c;

        /* renamed from: d */
        private int f3591d;

        /* renamed from: e */
        private int f3592e;

        /* renamed from: f */
        private FloatBuffer f3593f;

        /* renamed from: g */
        private FloatBuffer f3594g;

        /* renamed from: h */
        private ShortBuffer f3595h;

        /* renamed from: i */
        private int f3596i;

        /* renamed from: j */
        private int f3597j;

        /* renamed from: k */
        private int f3598k;

        /* renamed from: l */
        private int f3599l;

        /* renamed from: m */
        private int f3600m;

        /* renamed from: n */
        private int f3601n;

        /* renamed from: o */
        private int f3602o;

        /* renamed from: p */
        private int f3603p;

        /* renamed from: q */
        private int f3604q;

        /* renamed from: r */
        private int f3605r;

        /* renamed from: s */
        private int f3606s;

        /* renamed from: t */
        private int f3607t;

        /* renamed from: u */
        private Handler f3608u;

        /* renamed from: v */
        private SurfaceManager f3609v;

        /* renamed from: w */
        private int f3610w;

        /* renamed from: x */
        private int f3611x;

        /* renamed from: y */
        private final int f3612y;

        /* renamed from: z */
        private final int f3613z;

        private C1159a() {
            this.f3591d = -1;
            this.f3592e = -1;
            this.f3596i = -1;
            this.f3597j = -1;
            this.f3598k = -1;
            this.f3599l = -1;
            this.f3600m = -1;
            this.f3601n = -1;
            this.f3602o = -1;
            this.f3603p = -1;
            this.f3604q = -1;
            this.f3605r = -1;
            this.f3606s = -1;
            this.f3607t = -1;
            this.f3609v = null;
            this.f3610w = 0;
            this.f3611x = 0;
            this.f3612y = 4;
            this.f3613z = 3;
            this.f3586A = 2;
            this.f3587B = 12;
            this.f3588C = 8;
        }

        /* renamed from: a */
        public void mo14077a() {
            if (!PatchProxy.proxy(new Object[0], this, f3585a, false, 18, new Class[0], Void.TYPE).isSupported) {
                Log.d("EffectRenderEngine", "init");
                this.f3590c = new HandlerThread("Effect Renderer Thread");
                this.f3590c.start();
                this.f3608u = new Handler(this.f3590c.getLooper()) {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f3614a;

                    public void handleMessage(Message message) {
                        if (!PatchProxy.proxy(new Object[]{message}, this, f3614a, false, 41, new Class[]{Message.class}, Void.TYPE).isSupported) {
                            switch (message.what) {
                                case 0:
                                    C1159a.this.m4163e();
                                    return;
                                case 1:
                                    byte[] bArr = (byte[]) message.obj;
                                    int i = message.getData().getInt("index");
                                    Log.i("EffectRenderEngine", "get pramData for index: " + i);
                                    C1162c cVar = (C1162c) EffectRenderEngine.this.f3558B.get(i);
                                    if (cVar != null) {
                                        C1159a.this.m4157a(bArr, cVar);
                                        EffectRenderEngine.this.f3558B.remove(i);
                                        return;
                                    }
                                    Log.d("EffectRenderEngine", "no send pramData");
                                    return;
                                case 2:
                                    C1159a.this.m4165f();
                                    return;
                                case 4:
                                    C1159a.this.m4166g();
                                    return;
                                case 5:
                                    C1159a.this.mo14078b();
                                    return;
                                default:
                                    return;
                            }
                        }
                    }
                };
                this.f3608u.sendEmptyMessage(0);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m4156a(byte[] bArr, int i) {
            if (!PatchProxy.proxy(new Object[]{bArr, new Integer(i)}, this, f3585a, false, 20, new Class[]{byte[].class, Integer.TYPE}, Void.TYPE).isSupported && this.f3608u != null) {
                Message message = new Message();
                message.obj = bArr;
                message.what = 1;
                Bundle bundle = new Bundle();
                bundle.putInt("index", i);
                message.setData(bundle);
                this.f3608u.sendMessage(message);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public void m4159c() {
            if (!PatchProxy.proxy(new Object[0], this, f3585a, false, 21, new Class[0], Void.TYPE).isSupported && this.f3608u != null) {
                this.f3608u.sendEmptyMessage(4);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: d */
        public void m4161d() {
            if (!PatchProxy.proxy(new Object[0], this, f3585a, false, 22, new Class[0], Void.TYPE).isSupported && this.f3608u != null) {
                this.f3608u.sendEmptyMessage(2);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: e */
        public void m4163e() {
            if (!PatchProxy.proxy(new Object[0], this, f3585a, false, 23, new Class[0], Void.TYPE).isSupported) {
                Log.d("EffectRenderEngine", "initEGL");
                this.f3609v = new SurfaceManager();
                this.f3609v.mo14092a();
                m4169j();
                int unused = EffectRenderEngine.this.f3574p = (int) Thread.currentThread().getId();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: f */
        public void m4165f() {
            if (!PatchProxy.proxy(new Object[0], this, f3585a, false, 24, new Class[0], Void.TYPE).isSupported) {
                Log.i("EffectRenderEngine", "onDestroyGL");
                m4151a(EffectRenderEngine.this.f3564f);
                m4168i();
                m4151a(this.f3592e);
                m4151a(this.f3591d);
                m4151a(EffectRenderEngine.this.f3565g);
                int unused = EffectRenderEngine.this.f3564f = -1;
                this.f3592e = -1;
                this.f3591d = -1;
                int unused2 = EffectRenderEngine.this.f3565g = -1;
                this.f3609v.mo14097c();
                if (this.f3590c.getLooper() != null) {
                    Log.i("EffectRenderEngine", "quit");
                    this.f3590c.getLooper().quit();
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: g */
        public void m4166g() {
            if (!PatchProxy.proxy(new Object[0], this, f3585a, false, 25, new Class[0], Void.TYPE).isSupported) {
                Log.i("EffectRenderEngine", "onRelease");
            }
        }

        /* renamed from: b */
        public void mo14078b() {
            if (!PatchProxy.proxy(new Object[0], this, f3585a, false, 26, new Class[0], Void.TYPE).isSupported) {
                if (this.f3610w == EffectRenderEngine.this.f3570l && this.f3611x == EffectRenderEngine.this.f3571m && EffectRenderEngine.this.f3564f != -1) {
                    Log.d("EffectRenderEngine", "the same size ,no need to init texture:" + this.f3610w + "x" + this.f3611x);
                    return;
                }
                Log.d("EffectRenderEngine", "initEffectTexture start");
                this.f3610w = EffectRenderEngine.this.f3570l;
                this.f3611x = EffectRenderEngine.this.f3571m;
                m4151a(EffectRenderEngine.this.f3564f);
                m4168i();
                m4151a(this.f3592e);
                m4151a(this.f3591d);
                m4151a(EffectRenderEngine.this.f3565g);
                int unused = EffectRenderEngine.this.f3564f = m4150a(true);
                this.f3591d = m4150a(false);
                this.f3592e = m4150a(false);
                m4167h();
                Log.d("EffectRenderEngine", "initShareTexture texture id:" + EffectRenderEngine.this.f3564f);
                Log.i("EffectRenderEngine", "initEffectTexture end");
            }
        }

        /* renamed from: a */
        private int m4150a(boolean z) {
            boolean z2 = z;
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Byte(z2 ? (byte) 1 : 0)}, this, f3585a, false, 27, new Class[]{Boolean.TYPE}, Integer.TYPE);
            if (proxy.isSupported) {
                return ((Integer) proxy.result).intValue();
            }
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(3553, iArr[0]);
            if (z2) {
                GLES20.glTexImage2D(3553, 0, 6408, this.f3610w, this.f3611x, 0, 6408, 5121, (Buffer) null);
            }
            GLES20.glTexParameterf(3553, PackUtils.FIXED_BUFFER_SIZE, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            int glGetError = GLES20.glGetError();
            if (glGetError != 0) {
                Log.i("EffectRenderEngine", "Create Texture failed!:" + glGetError);
            }
            GLES20.glBindTexture(3553, 0);
            return iArr[0];
        }

        /* renamed from: a */
        private int m4149a(EffectRenderFactory.C1191c cVar, boolean z) {
            Bitmap a;
            Object[] objArr = {cVar, new Byte(z ? (byte) 1 : 0)};
            ChangeQuickRedirect changeQuickRedirect = f3585a;
            ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
            PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 28, new Class[]{EffectRenderFactory.C1191c.class, Boolean.TYPE}, Integer.TYPE);
            if (proxy.isSupported) {
                return ((Integer) proxy.result).intValue();
            }
            Log.d("EffectRenderEngine", "createLutTexture");
            new BitmapFactory.Options().inScaled = false;
            Bitmap bitmap = null;
            if (z) {
                try {
                    a = mo14076a(EffectRenderEngine.this.f3573o, cVar.mo14343b());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                a = C1198Utils.m4821a(cVar.mo14343b(), false, EffectRenderEngine.this.f3573o);
            }
            bitmap = a;
            if (bitmap == null) {
                return -1;
            }
            int a2 = mo14075a(bitmap.getWidth(), bitmap.getWidth(), bitmap.getWidth(), bitmap);
            bitmap.recycle();
            return a2;
        }

        /* renamed from: a */
        public int mo14075a(int i, int i2, int i3, Bitmap bitmap) {
            Object[] objArr = {new Integer(i), new Integer(i2), new Integer(i3), bitmap};
            ChangeQuickRedirect changeQuickRedirect = f3585a;
            PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 30, new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Bitmap.class}, Integer.TYPE);
            if (proxy.isSupported) {
                return ((Integer) proxy.result).intValue();
            }
            GLTexture3D dVar = null;
            if (i > 0 && i2 > 0 && i3 > 0 && bitmap != null) {
                dVar = new GLTexture3D();
                dVar.mo14035b(i, i2, i3, bitmap);
            }
            return dVar.mo14033a();
        }

        /* renamed from: h */
        private void m4167h() {
            if (!PatchProxy.proxy(new Object[0], this, f3585a, false, 31, new Class[0], Void.TYPE).isSupported) {
                Log.d("EffectRenderEngine", "setupBuffers");
                int[] iArr = new int[1];
                GLES20.glGenFramebuffers(1, iArr, 0);
                int unused = EffectRenderEngine.this.f3566h = iArr[0];
                GLES20.glBindFramebuffer(36160, EffectRenderEngine.this.f3566h);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, EffectRenderEngine.this.f3564f, 0);
                m4155a("glFrameBufferTexture2D");
                m4171l();
                m4155a("glClear setupBuffers");
                GLES20.glBindFramebuffer(36160, 0);
            }
        }

        /* renamed from: a */
        private void m4151a(int i) {
            if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f3585a, false, 32, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
                Log.e("EffectRenderEngine", "glDeleteTextures texture:" + i);
                if (i != -1) {
                    GLES20.glDeleteTextures(1, new int[]{i}, 0);
                    m4155a("glDeleteTextures");
                }
            }
        }

        /* renamed from: i */
        private void m4168i() {
            if (!PatchProxy.proxy(new Object[0], this, f3585a, false, 33, new Class[0], Void.TYPE).isSupported && EffectRenderEngine.this.f3566h != -1) {
                GLES20.glDeleteBuffers(1, new int[]{EffectRenderEngine.this.f3566h}, 0);
                m4155a("glDeleteBuffers deleteFrameBuffer");
            }
        }

        /* renamed from: j */
        private void m4169j() {
            if (!PatchProxy.proxy(new Object[0], this, f3585a, false, 34, new Class[0], Void.TYPE).isSupported) {
                Log.v("EffectRenderEngine", "initGLEnv");
                EffectRenderEngine.this.f3562d.mo14085a();
                this.f3593f = EffectRenderEngine.this.f3562d.mo14088d();
                this.f3594g = EffectRenderEngine.this.f3562d.mo14089e();
                this.f3595h = EffectRenderEngine.this.f3562d.mo14090f();
                this.f3596i = EffectRenderEngine.this.f3562d.mo14087c();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.lang.Object[]} */
        /* access modifiers changed from: private */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void m4157a(byte[] r33, com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.C1162c r34) {
            /*
                r32 = this;
                r7 = r32
                r10 = r33
                r8 = 2
                java.lang.Object[] r0 = new java.lang.Object[r8]
                r9 = 0
                r0[r9] = r10
                r11 = 1
                r0[r11] = r34
                com.meizu.savior.ChangeQuickRedirect r2 = f3585a
                java.lang.Class[] r5 = new java.lang.Class[r8]
                java.lang.Class<byte[]> r1 = byte[].class
                r5[r9] = r1
                java.lang.Class<com.meizu.camera.effectlib.effects.filters.EffectRenderEngine$c> r1 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.C1162c.class
                r5[r11] = r1
                java.lang.Class r6 = java.lang.Void.TYPE
                r3 = 0
                r4 = 35
                r1 = r32
                com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r0, r1, r2, r3, r4, r5, r6)
                boolean r0 = r0.isSupported
                if (r0 == 0) goto L_0x0029
                return
            L_0x0029:
                java.lang.String r0 = "EffectRenderEngine"
                java.lang.String r1 = "drawFrame"
                android.util.Log.i(r0, r1)
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r0 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine$b r0 = r0.f3567i
                r0.mo14080a()
                r32.mo14078b()
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r0 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                int r0 = r0.f3565g
                r7.m4151a((int) r0)
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r0 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                int r1 = r32.m4170k()
                int unused = r0.f3565g = r1
                r0 = 16384(0x4000, float:2.2959E-41)
                android.opengl.GLES20.glClear(r0)
                r0 = 0
                android.opengl.GLES20.glClearColor(r0, r0, r0, r0)
                int r1 = r7.f3596i
                java.lang.String r2 = "aPosition"
                int r1 = android.opengl.GLES20.glGetAttribLocation(r1, r2)
                r7.f3597j = r1
                int r1 = r7.f3596i
                java.lang.String r2 = "aTextureCoordinate"
                int r1 = android.opengl.GLES20.glGetAttribLocation(r1, r2)
                r7.f3598k = r1
                int r1 = r7.f3596i
                java.lang.String r2 = "textureY"
                int r1 = android.opengl.GLES20.glGetUniformLocation(r1, r2)
                r7.f3599l = r1
                int r1 = r7.f3596i
                java.lang.String r2 = "textureUV"
                int r1 = android.opengl.GLES20.glGetUniformLocation(r1, r2)
                r7.f3600m = r1
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r1 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                int r2 = r7.f3596i
                java.lang.String r3 = "lut_tab"
                int r2 = android.opengl.GLES20.glGetUniformLocation(r2, r3)
                int unused = r1.f3568j = r2
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r1 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                int r2 = r7.f3596i
                java.lang.String r3 = "lut_scenetab"
                int r2 = android.opengl.GLES20.glGetUniformLocation(r2, r3)
                int unused = r1.f3569k = r2
                int r1 = r7.f3596i
                java.lang.String r2 = "uMVPMatrix"
                int r1 = android.opengl.GLES20.glGetUniformLocation(r1, r2)
                r7.f3601n = r1
                int r1 = r7.f3596i
                java.lang.String r2 = "u_IsSceneRender"
                int r1 = android.opengl.GLES20.glGetUniformLocation(r1, r2)
                r7.f3602o = r1
                int r1 = r7.f3596i
                java.lang.String r2 = "u_brightness"
                int r1 = android.opengl.GLES20.glGetUniformLocation(r1, r2)
                r7.f3603p = r1
                int r1 = r7.f3596i
                java.lang.String r2 = "u_saturation"
                int r1 = android.opengl.GLES20.glGetUniformLocation(r1, r2)
                r7.f3604q = r1
                int r1 = r7.f3596i
                java.lang.String r2 = "u_contrast"
                int r1 = android.opengl.GLES20.glGetUniformLocation(r1, r2)
                r7.f3605r = r1
                int r1 = r7.f3596i
                java.lang.String r2 = "u_temperature"
                int r1 = android.opengl.GLES20.glGetUniformLocation(r1, r2)
                r7.f3606s = r1
                int r1 = r7.f3596i
                java.lang.String r2 = "u_threshold"
                int r1 = android.opengl.GLES20.glGetUniformLocation(r1, r2)
                r7.f3607t = r1
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r1 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                int r1 = r1.f3570l
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r2 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                int r2 = r2.f3571m
                android.opengl.GLES20.glViewport(r9, r9, r1, r2)
                int r1 = r7.f3596i
                android.opengl.GLES20.glUseProgram(r1)
                r1 = 0
                r2 = 4
                if (r10 == 0) goto L_0x013d
                java.lang.String r1 = "EffectRenderEngine"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "process data length:"
                r3.append(r4)
                int r4 = r10.length
                r3.append(r4)
                java.lang.String r3 = r3.toString()
                android.util.Log.i(r1, r3)
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r1 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                int r1 = r1.f3570l
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r3 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                int r3 = r3.f3571m
                int r1 = r1 * r3
                int r1 = r1 * 4
                java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r1)
                r1.clear()
                r1.position(r9)
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r3 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                int r3 = r3.f3570l
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r4 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                int r4 = r4.f3571m
                int r3 = r3 * r4
                java.nio.ByteBuffer r3 = r1.put(r10, r9, r3)
                r3.position(r9)
            L_0x013d:
                r3 = 3553(0xde1, float:4.979E-42)
                if (r1 == 0) goto L_0x01c1
                r4 = 33984(0x84c0, float:4.7622E-41)
                android.opengl.GLES20.glActiveTexture(r4)
                int r4 = r7.f3591d
                android.opengl.GLES20.glBindTexture(r3, r4)
                r1.position(r9)
                r12 = 3553(0xde1, float:4.979E-42)
                r13 = 0
                r14 = 6409(0x1909, float:8.981E-42)
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r4 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                int r15 = r4.f3570l
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r4 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                int r16 = r4.f3571m
                r17 = 0
                r18 = 6409(0x1909, float:8.981E-42)
                r19 = 5121(0x1401, float:7.176E-42)
                r20 = r1
                android.opengl.GLES20.glTexImage2D(r12, r13, r14, r15, r16, r17, r18, r19, r20)
                int r4 = r7.f3599l
                android.opengl.GLES20.glUniform1i(r4, r9)
                r4 = 33985(0x84c1, float:4.7623E-41)
                android.opengl.GLES20.glActiveTexture(r4)
                int r4 = r7.f3592e
                android.opengl.GLES20.glBindTexture(r3, r4)
                r1.clear()
                r1.position(r9)
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r4 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                int r4 = r4.f3570l
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r5 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                int r5 = r5.f3571m
                int r4 = r4 * r5
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r5 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                int r5 = r5.f3570l
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r6 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                int r6 = r6.f3571m
                int r5 = r5 * r6
                int r5 = r5 / r8
                java.nio.ByteBuffer r4 = r1.put(r10, r4, r5)
                r4.position(r9)
                r14 = 6410(0x190a, float:8.982E-42)
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r4 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                int r4 = r4.f3570l
                int r15 = r4 / 2
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r4 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                int r4 = r4.f3571m
                int r16 = r4 / 2
                r18 = 6410(0x190a, float:8.982E-42)
                android.opengl.GLES20.glTexImage2D(r12, r13, r14, r15, r16, r17, r18, r19, r20)
                int r4 = r7.f3600m
                android.opengl.GLES20.glUniform1i(r4, r11)
            L_0x01c1:
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r4 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine$SceneType r4 = r4.f3557A
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine$SceneType r5 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.SceneType.TYPE_NORMALSCENE
                if (r4 != r5) goto L_0x020a
                int r0 = r7.f3602o
                r4 = 1065353216(0x3f800000, float:1.0)
                android.opengl.GLES20.glUniform1f(r0, r4)
                int r0 = r7.f3603p
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r4 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                float r4 = r4.f3580v
                android.opengl.GLES20.glUniform1f(r0, r4)
                int r0 = r7.f3605r
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r4 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                float r4 = r4.f3582x
                android.opengl.GLES20.glUniform1f(r0, r4)
                int r0 = r7.f3604q
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r4 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                float r4 = r4.f3581w
                android.opengl.GLES20.glUniform1f(r0, r4)
                int r0 = r7.f3606s
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r4 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                float r4 = r4.f3583y
                android.opengl.GLES20.glUniform1f(r0, r4)
                int r0 = r7.f3607t
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r4 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                float r4 = r4.f3584z
                android.opengl.GLES20.glUniform1f(r0, r4)
                goto L_0x0258
            L_0x020a:
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r4 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine$SceneType r4 = r4.f3557A
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine$SceneType r5 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.SceneType.TYPE_LUTSCENE
                r6 = 32879(0x806f, float:4.6073E-41)
                r12 = 33986(0x84c2, float:4.7625E-41)
                if (r4 != r5) goto L_0x023e
                java.lang.String r0 = "EffectRenderEngine"
                java.lang.String r4 = "setRenderTypeLUT"
                android.util.Log.d(r0, r4)
                int r0 = r7.f3602o
                r4 = 1073741824(0x40000000, float:2.0)
                android.opengl.GLES20.glUniform1f(r0, r4)
                android.opengl.GLES20.glActiveTexture(r12)
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r0 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                int r0 = r0.f3565g
                android.opengl.GLES20.glBindTexture(r6, r0)
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r0 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                int r0 = r0.f3568j
                android.opengl.GLES20.glUniform1i(r0, r8)
                goto L_0x0258
            L_0x023e:
                int r4 = r7.f3602o
                android.opengl.GLES20.glUniform1f(r4, r0)
                android.opengl.GLES20.glActiveTexture(r12)
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r0 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                int r0 = r0.f3565g
                android.opengl.GLES20.glBindTexture(r6, r0)
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r0 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                int r0 = r0.f3568j
                android.opengl.GLES20.glUniform1i(r0, r8)
            L_0x0258:
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r0 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                int r0 = r0.f3566h
                r4 = 36160(0x8d40, float:5.0671E-41)
                android.opengl.GLES20.glBindFramebuffer(r4, r0)
                java.nio.FloatBuffer r0 = r7.f3593f
                r0.position(r9)
                int r12 = r7.f3597j
                r13 = 3
                r14 = 5126(0x1406, float:7.183E-42)
                r15 = 0
                r16 = 12
                java.nio.FloatBuffer r0 = r7.f3593f
                r17 = r0
                android.opengl.GLES20.glVertexAttribPointer(r12, r13, r14, r15, r16, r17)
                java.lang.String r0 = "glVertexAttribPointer PositionLocation"
                r7.m4155a((java.lang.String) r0)
                int r0 = r7.f3597j
                android.opengl.GLES20.glEnableVertexAttribArray(r0)
                java.lang.String r0 = "glEnableVertexAttribArray PositionLocation"
                r7.m4155a((java.lang.String) r0)
                java.nio.FloatBuffer r0 = r7.f3594g
                r0.position(r9)
                int r12 = r7.f3598k
                r13 = 2
                r16 = 8
                java.nio.FloatBuffer r0 = r7.f3594g
                r17 = r0
                android.opengl.GLES20.glVertexAttribPointer(r12, r13, r14, r15, r16, r17)
                java.lang.String r0 = "glVertexAttribPointer TextureCoordLocation"
                r7.m4155a((java.lang.String) r0)
                int r0 = r7.f3598k
                android.opengl.GLES20.glEnableVertexAttribArray(r0)
                java.lang.String r0 = "glEnableVertexAttribArray TextureCoordLocation"
                r7.m4155a((java.lang.String) r0)
                java.lang.String r0 = "glUniformMatrix4fv mMVPMatrix"
                r7.m4155a((java.lang.String) r0)
                int r0 = r7.f3601n
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r5 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                float[] r5 = r5.f3576r
                android.opengl.GLES20.glUniformMatrix4fv(r0, r11, r9, r5, r9)
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r0 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                short[] r0 = r0.f3575q
                int r0 = r0.length
                r5 = 5123(0x1403, float:7.179E-42)
                java.nio.ShortBuffer r6 = r7.f3595h
                android.opengl.GLES20.glDrawElements(r2, r0, r5, r6)
                java.lang.String r0 = "EffectRenderEngine"
                java.lang.String r2 = "drawFrame end"
                android.util.Log.i(r0, r2)
                r1.rewind()
                r1.position(r9)
                r1.clear()
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r0 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                int r0 = r0.f3564f
                android.opengl.GLES20.glBindTexture(r3, r0)
                r12 = 0
                r13 = 0
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r0 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                int r14 = r0.f3570l
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r0 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                int r15 = r0.f3571m
                r16 = 6408(0x1908, float:8.98E-42)
                r17 = 5121(0x1401, float:7.176E-42)
                r18 = r1
                android.opengl.GLES20.glReadPixels(r12, r13, r14, r15, r16, r17, r18)
                java.lang.String r0 = "EffectRenderEngine"
                java.lang.String r2 = "glReadPixels end"
                android.util.Log.i(r0, r2)
                int r0 = r1.remaining()
                byte[] r0 = new byte[r0]
                int r2 = r0.length
                r1.get(r0, r9, r2)
                java.lang.String r2 = "EffectRenderEngine"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "glReadPixels data length:"
                r5.append(r6)
                int r6 = r0.length
                r5.append(r6)
                java.lang.String r5 = r5.toString()
                android.util.Log.i(r2, r5)
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r2 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                boolean r2 = r2.f3579u
                if (r2 == 0) goto L_0x036f
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r2 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine$b r8 = r2.f3567i
                long r11 = r34.f3619d
                android.location.Location r13 = r34.f3621f
                int r14 = r34.f3622g
                int r15 = r34.f3623h
                boolean r16 = r34.f3624i
                int r17 = r34.f3625j
                boolean r18 = r34.f3629n
                int r19 = r34.f3626k
                android.graphics.Rect r20 = r34.f3627l
                android.hardware.camera2.TotalCaptureResult r21 = r34.f3628m
                java.lang.String r22 = r34.f3630o
                boolean r23 = r34.f3631p
                boolean r24 = r34.f3632q
                int r25 = r34.f3633r
                boolean r26 = r34.f3635t
                r2 = 0
                r9 = r0
                r10 = r33
                r8.mo14082a(r9, r10, r11, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
                goto L_0x03cc
            L_0x036f:
                r2 = 0
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine r5 = com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.this
                com.meizu.camera.effectlib.effects.filters.EffectRenderEngine$b r8 = r5.f3567i
                java.util.UUID r9 = r34.f3617b
                java.lang.String r12 = r34.f3618c
                long r13 = r34.f3619d
                int r15 = r34.f3620e
                android.location.Location r16 = r34.f3621f
                int r17 = r34.f3622g
                int r18 = r34.f3623h
                boolean r19 = r34.f3624i
                int r20 = r34.f3625j
                boolean r21 = r34.f3629n
                int r22 = r34.f3626k
                android.graphics.Rect r23 = r34.f3627l
                android.hardware.camera2.TotalCaptureResult r24 = r34.f3628m
                java.lang.String r25 = r34.f3630o
                boolean r26 = r34.f3631p
                boolean r27 = r34.f3632q
                int r28 = r34.f3633r
                boolean r29 = r34.f3634s
                boolean r30 = r34.f3635t
                boolean r31 = r34.f3636u
                r10 = r0
                r11 = r33
                r8.mo14081a(r9, r10, r11, r12, r13, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            L_0x03cc:
                r1.rewind()
                r1.clear()
                android.opengl.GLES20.glBindFramebuffer(r4, r2)
                android.opengl.GLES20.glBindTexture(r3, r2)
                r32.m4171l()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.filters.EffectRenderEngine.C1159a.m4157a(byte[], com.meizu.camera.effectlib.effects.filters.EffectRenderEngine$c):void");
        }

        /* renamed from: k */
        private int m4170k() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f3585a, false, 36, new Class[0], Integer.TYPE);
            if (proxy.isSupported) {
                return ((Integer) proxy.result).intValue();
            }
            if (EffectRenderEngine.this.f3557A == SceneType.TYPE_NORMALSCENE) {
                return -1;
            }
            if (EffectRenderEngine.this.f3557A == SceneType.TYPE_LUTSCENE) {
                int a = m4149a(EffectRenderEngine.this.f3578t, false);
                Log.d("EffectRenderEngine", "getLubTexture :" + EffectRenderEngine.this.f3578t.mo14345d() + " id:" + a);
                return a;
            }
            int a2 = m4149a(EffectRenderEngine.this.f3578t, true);
            Log.d("EffectRenderEngine", "getLubTexture from zip:" + EffectRenderEngine.this.f3578t.mo14345d() + " id:" + a2);
            return a2;
        }

        /* renamed from: a */
        private void m4155a(String str) {
            int eglGetError;
            if (!PatchProxy.proxy(new Object[]{str}, this, f3585a, false, 37, new Class[]{String.class}, Void.TYPE).isSupported && (eglGetError = EGL14.eglGetError()) != 12288) {
                Log.d("EffectRenderEngine", str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
                throw new IllegalStateException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
            }
        }

        /* renamed from: l */
        private void m4171l() {
            if (!PatchProxy.proxy(new Object[0], this, f3585a, false, 38, new Class[0], Void.TYPE).isSupported) {
                int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
                m4155a("glCheckFramebufferStatus");
                if (glCheckFramebufferStatus == 36057) {
                    Log.e("EffectRenderEngine", "incomplete dimensions");
                } else if (glCheckFramebufferStatus != 36061) {
                    switch (glCheckFramebufferStatus) {
                        case 36053:
                            Log.d("EffectRenderEngine", "complete");
                            return;
                        case 36054:
                            Log.e("EffectRenderEngine", "incomplete attachment");
                            return;
                        case 36055:
                            Log.e("EffectRenderEngine", "incomplete missing attachment");
                            return;
                        default:
                            Log.d("EffectRenderEngine", "default");
                            return;
                    }
                } else {
                    Log.e("EffectRenderEngine", "framebuffer unsupported");
                }
            }
        }

        /* renamed from: a */
        public Bitmap mo14076a(Context context, String str) throws Exception {
            InputStream inputStream;
            FileInputStream fileInputStream;
            ZipInputStream zipInputStream;
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, str}, this, f3585a, false, 40, new Class[]{Context.class, String.class}, Bitmap.class);
            if (proxy.isSupported) {
                return (Bitmap) proxy.result;
            }
            String str2 = "/system/media/" + str;
            Log.i("BaseRender", "readZipFile systemFilePath :" + str2);
            Bitmap bitmap = null;
            if (new File(str2).exists()) {
                fileInputStream = new FileInputStream(str2);
                inputStream = new BufferedInputStream(fileInputStream);
                zipInputStream = new ZipInputStream(inputStream);
                Log.i("BaseRender", "readZipFile from system");
            } else {
                inputStream = context.getAssets().open(str);
                zipInputStream = new ZipInputStream(inputStream);
                fileInputStream = null;
            }
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    break;
                }
                String name = nextEntry.getName();
                Log.i("BaseRender", "readZipFile: " + name);
                if (nextEntry.isDirectory()) {
                    String substring = name.substring(0, name.length() - 1);
                    substring.substring(substring.lastIndexOf("/") + 1);
                } else {
                    nextEntry.getSize();
                    if (!name.contains("MACOSX") && (name.endsWith(".png") || name.endsWith(".jpg"))) {
                        Log.i("BaseRender", "decodeStream: " + name);
                        bitmap = BitmapFactory.decodeStream(zipInputStream);
                    }
                }
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            inputStream.close();
            zipInputStream.close();
            return bitmap;
        }
    }
}
