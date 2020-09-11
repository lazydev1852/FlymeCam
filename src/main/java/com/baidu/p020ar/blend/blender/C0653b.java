package com.baidu.p020ar.blend.blender;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build;
import android.util.Log;
import com.baidu.p020ar.blend.blender.C0654c;
import com.baidu.p020ar.blend.blender.TextureParams;
import com.baidu.p020ar.blend.gpuimage.graphics.C0749a;
import com.baidu.p020ar.blend.gpuimage.p039a.C0709d;
import com.baidu.p020ar.blend.gpuimage.p039a.C0711f;
import com.baidu.p020ar.blend.gpuimage.p039a.C0712g;
import com.baidu.p020ar.blend.gpuimage.p039a.C0724h;
import com.baidu.p020ar.blend.gpuimage.p039a.C0730m;
import com.baidu.p020ar.blend.gpuimage.p039a.C0733p;
import com.baidu.p020ar.blend.gpuimage.p039a.C0744v;
import com.baidu.p020ar.blend.p036a.C0630a;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.baidu.ar.blend.blender.b */
public class C0653b implements C0673e {

    /* renamed from: h */
    private static final String f1285h = "b";

    /* renamed from: A */
    private C0711f f1286A = null;

    /* renamed from: B */
    private C0744v f1287B = null;

    /* renamed from: C */
    private C0712g f1288C = null;

    /* renamed from: D */
    private C0709d f1289D = null;

    /* renamed from: E */
    private volatile C0724h f1290E;

    /* renamed from: F */
    private volatile C0724h f1291F;

    /* renamed from: G */
    private volatile C0724h f1292G;

    /* renamed from: H */
    private boolean f1293H = true;

    /* renamed from: I */
    private boolean f1294I = true;

    /* renamed from: J */
    private boolean f1295J = true;

    /* renamed from: K */
    private int f1296K = -1;

    /* renamed from: L */
    private int[] f1297L = {-1, -1};

    /* renamed from: M */
    private int f1298M = -1;

    /* renamed from: N */
    private int f1299N = -1;

    /* renamed from: O */
    private int f1300O = -1;

    /* renamed from: P */
    private int f1301P = -1;

    /* renamed from: Q */
    private int f1302Q = -1;

    /* renamed from: R */
    private int f1303R = -1;

    /* renamed from: S */
    private int f1304S = -1;

    /* renamed from: T */
    private int f1305T = -1;

    /* renamed from: U */
    private volatile C0654c.C0669d f1306U;

    /* renamed from: V */
    private int[] f1307V = null;

    /* renamed from: W */
    private C0733p f1308W = null;

    /* renamed from: X */
    private ByteBuffer f1309X = null;

    /* renamed from: Y */
    private Object f1310Y = new Object();

    /* renamed from: Z */
    private int f1311Z;

    /* renamed from: a */
    boolean f1312a = false;

    /* renamed from: aa */
    private int f1313aa;

    /* renamed from: ab */
    private float[] f1314ab = new float[16];

    /* renamed from: b */
    int f1315b = 0;

    /* renamed from: c */
    boolean f1316c = false;

    /* renamed from: d */
    TextureParams.VideoRenderMode f1317d = TextureParams.VideoRenderMode.NONE;

    /* renamed from: e */
    C0654c.C0666a f1318e;

    /* renamed from: f */
    boolean f1319f = true;

    /* renamed from: g */
    C0630a f1320g;

    /* renamed from: i */
    private int[] f1321i = {-1};

    /* renamed from: j */
    private int f1322j = 0;

    /* renamed from: k */
    private int f1323k = 0;

    /* renamed from: l */
    private long f1324l = System.currentTimeMillis();

    /* renamed from: m */
    private int f1325m = 0;

    /* renamed from: n */
    private C0654c.C0668c f1326n;

    /* renamed from: o */
    private boolean f1327o = false;

    /* renamed from: p */
    private SurfaceTexture f1328p;

    /* renamed from: q */
    private float f1329q = 1.0f;

    /* renamed from: r */
    private TextureParams.SourceType f1330r = TextureParams.SourceType.SURFACE_TEXTURE;

    /* renamed from: s */
    private boolean f1331s = true;

    /* renamed from: t */
    private float f1332t = 0.0f;

    /* renamed from: u */
    private int f1333u;

    /* renamed from: v */
    private int f1334v;

    /* renamed from: w */
    private boolean f1335w = false;

    /* renamed from: x */
    private final float[] f1336x = new float[16];

    /* renamed from: y */
    private int f1337y = -1;

    /* renamed from: z */
    private C0730m f1338z = null;

    C0653b() {
    }

    /* renamed from: a */
    private void m1539a(int i, int i2) {
        m1549c();
        this.f1305T = C0749a.m1934a(3553, i, i2);
    }

    /* renamed from: a */
    private void m1540a(C0724h hVar) {
        Log.d(f1285h, "clearGPUImageFilters: ");
        if (hVar != null && hVar.mo10009g()) {
            hVar.mo10005d();
        }
    }

    /* renamed from: a */
    private void m1541a(C0724h hVar, int i, int i2) {
        String str = f1285h;
        Log.d(str, "initGPUImageFilters: " + i + "x" + i2);
        hVar.mo10001c();
        if (i > 0 && i2 > 0) {
            hVar.mo9990a(i, i2);
        }
    }

    /* renamed from: a */
    private void m1542a(C0724h hVar, int i, int i2, int i3, int i4) {
        C0749a.m1944b(i2, 3553, this.f1298M);
        this.f1297L[0] = i3;
        this.f1297L[1] = i4;
        hVar.mo10029a(this.f1297L, this.f1296K);
        hVar.mo9997b(i, this.f1298M);
    }

    /* renamed from: a */
    private void m1543a(float[] fArr) {
        Matrix.setIdentityM(this.f1336x, 0);
        if (fArr != null && fArr.length == this.f1336x.length) {
            System.arraycopy(fArr, 0, this.f1336x, 0, fArr.length);
        }
    }

    /* renamed from: a */
    private boolean m1544a(int[] iArr, SurfaceTexture surfaceTexture) {
        if (iArr[0] > -1 || surfaceTexture == null) {
            return false;
        }
        String str = f1285h;
        Log.e(str, "bdar: oldTextureId = " + iArr[0]);
        int a = C0749a.m1931a();
        if (a <= -1) {
            Log.e(f1285h, "bdar: create texture id <= -1, Invalid ID!!!!");
            return false;
        }
        if (surfaceTexture != null) {
            try {
                if (Build.VERSION.SDK_INT >= 16) {
                    surfaceTexture.attachToGLContext(a);
                }
            } catch (Exception e) {
                String str2 = f1285h;
                Log.e(str2, "bdar: runException oldTextureId = " + iArr[0]);
                e.printStackTrace();
                m1548b(iArr, surfaceTexture);
                if (a >= 0) {
                    GLES20.glDeleteTextures(1, new int[]{a}, 0);
                }
                return false;
            }
        }
        iArr[0] = a;
        String str3 = f1285h;
        Log.d(str3, "bdar: newTextureId = " + iArr[0]);
        return true;
    }

    /* renamed from: b */
    private void m1545b(int i, int i2) {
        m1551d();
        this.f1337y = C0749a.m1934a(3553, i, i2);
    }

    /* renamed from: b */
    private void m1546b(SurfaceTexture surfaceTexture) {
        if (surfaceTexture != null) {
            surfaceTexture.updateTexImage();
        }
    }

    /* renamed from: b */
    private void m1547b(float[] fArr) {
        Matrix.setIdentityM(this.f1314ab, 0);
        if (fArr != null && fArr.length == this.f1314ab.length) {
            System.arraycopy(fArr, 0, this.f1314ab, 0, fArr.length);
        }
    }

    /* renamed from: b */
    private void m1548b(int[] iArr, SurfaceTexture surfaceTexture) {
        if (surfaceTexture != null && iArr[0] >= 0) {
            try {
                if (Build.VERSION.SDK_INT >= 16 && surfaceTexture != null) {
                    surfaceTexture.detachFromGLContext();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (iArr[0] >= 0) {
            GLES20.glDeleteTextures(1, iArr, 0);
        }
        iArr[0] = -1;
    }

    /* renamed from: c */
    private void m1549c() {
        if (this.f1305T != -1) {
            C0749a.m1943b(this.f1305T);
            this.f1305T = -1;
        }
    }

    /* renamed from: c */
    private void m1550c(int i, int i2) {
        m1553e();
        this.f1303R = C0749a.m1934a(3553, i, i2);
    }

    /* renamed from: d */
    private void m1551d() {
        if (this.f1337y != -1) {
            C0749a.m1943b(this.f1337y);
            this.f1337y = -1;
        }
    }

    /* renamed from: d */
    private void m1552d(int i, int i2) {
        m1555f();
        this.f1302Q = C0749a.m1934a(3553, i, i2);
    }

    /* renamed from: e */
    private void m1553e() {
        if (this.f1303R != -1) {
            C0749a.m1943b(this.f1303R);
            this.f1303R = -1;
        }
    }

    /* renamed from: e */
    private void m1554e(int i, int i2) {
        m1557g();
        this.f1304S = C0749a.m1934a(3553, i, i2);
    }

    /* renamed from: f */
    private void m1555f() {
        if (this.f1302Q != -1) {
            C0749a.m1943b(this.f1302Q);
            this.f1302Q = -1;
        }
    }

    /* renamed from: f */
    private void m1556f(int i, int i2) {
        m1558h();
        this.f1299N = C0749a.m1934a(3553, i, i2);
        this.f1300O = C0749a.m1934a(3553, i, i2);
        this.f1301P = C0749a.m1934a(3553, i, i2);
    }

    /* renamed from: g */
    private void m1557g() {
        if (this.f1304S != -1) {
            C0749a.m1943b(this.f1304S);
            this.f1304S = -1;
        }
    }

    /* renamed from: h */
    private void m1558h() {
        if (this.f1299N != -1) {
            C0749a.m1943b(this.f1299N);
            this.f1299N = -1;
        }
        if (this.f1300O != -1) {
            C0749a.m1943b(this.f1300O);
            this.f1300O = -1;
        }
        if (this.f1301P != -1) {
            C0749a.m1943b(this.f1301P);
            this.f1301P = -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x01d0 A[Catch:{ Exception -> 0x02cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01e2 A[Catch:{ Exception -> 0x02cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0201 A[Catch:{ Exception -> 0x02cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x020e A[Catch:{ Exception -> 0x02cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0220 A[Catch:{ Exception -> 0x02cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0236 A[Catch:{ Exception -> 0x02cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0246 A[Catch:{ Exception -> 0x02cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0260 A[Catch:{ Exception -> 0x02cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0267 A[Catch:{ Exception -> 0x02cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0292 A[Catch:{ Exception -> 0x02cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x02b6 A[Catch:{ Exception -> 0x02cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:154:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0078 A[Catch:{ Exception -> 0x02cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a6 A[Catch:{ Exception -> 0x02cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a8 A[Catch:{ Exception -> 0x02cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0143 A[Catch:{ Exception -> 0x02cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x014a A[Catch:{ Exception -> 0x02cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x014d A[Catch:{ Exception -> 0x02cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x015e A[Catch:{ Exception -> 0x02cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0160 A[Catch:{ Exception -> 0x02cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x016c A[Catch:{ Exception -> 0x02cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x016e A[Catch:{ Exception -> 0x02cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01b7 A[Catch:{ Exception -> 0x02cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01c9 A[ADDED_TO_REGION, Catch:{ Exception -> 0x02cf }] */
    /* renamed from: i */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1559i() {
        /*
            r20 = this;
            r7 = r20
            int r0 = r7.f1322j     // Catch:{ Exception -> 0x02cf }
            if (r0 == 0) goto L_0x02c7
            int r0 = r7.f1323k     // Catch:{ Exception -> 0x02cf }
            if (r0 != 0) goto L_0x000c
            goto L_0x02c7
        L_0x000c:
            java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x02cf }
            java.lang.System.nanoTime()     // Catch:{ Exception -> 0x02cf }
            com.baidu.ar.blend.blender.TextureParams$VideoRenderMode r0 = r7.f1317d     // Catch:{ Exception -> 0x02cf }
            com.baidu.ar.blend.blender.TextureParams$VideoRenderMode r1 = com.baidu.p020ar.blend.blender.TextureParams.VideoRenderMode.BG     // Catch:{ Exception -> 0x02cf }
            r8 = 0
            r9 = -1
            r10 = 3553(0xde1, float:4.979E-42)
            if (r0 == r1) goto L_0x0022
            com.baidu.ar.blend.blender.TextureParams$VideoRenderMode r0 = r7.f1317d     // Catch:{ Exception -> 0x02cf }
            com.baidu.ar.blend.blender.TextureParams$VideoRenderMode r1 = com.baidu.p020ar.blend.blender.TextureParams.VideoRenderMode.FG     // Catch:{ Exception -> 0x02cf }
            if (r0 != r1) goto L_0x013d
        L_0x0022:
            int r0 = r7.f1303R     // Catch:{ Exception -> 0x02cf }
            int r11 = r7.f1337y     // Catch:{ Exception -> 0x02cf }
            int r12 = r7.f1299N     // Catch:{ Exception -> 0x02cf }
            int r6 = r7.f1300O     // Catch:{ Exception -> 0x02cf }
            com.baidu.ar.blend.blender.TextureParams$SourceType r1 = r7.f1330r     // Catch:{ Exception -> 0x02cf }
            com.baidu.ar.blend.blender.TextureParams$SourceType r2 = com.baidu.p020ar.blend.blender.TextureParams.SourceType.SURFACE_TEXTURE     // Catch:{ Exception -> 0x02cf }
            if (r1 == r2) goto L_0x0046
            com.baidu.ar.blend.blender.TextureParams$SourceType r1 = r7.f1330r     // Catch:{ Exception -> 0x02cf }
            com.baidu.ar.blend.blender.TextureParams$SourceType r2 = com.baidu.p020ar.blend.blender.TextureParams.SourceType.IM     // Catch:{ Exception -> 0x02cf }
            if (r1 != r2) goto L_0x0037
            goto L_0x0046
        L_0x0037:
            com.baidu.ar.blend.blender.TextureParams$SourceType r1 = r7.f1330r     // Catch:{ Exception -> 0x02cf }
            com.baidu.ar.blend.blender.TextureParams$SourceType r2 = com.baidu.p020ar.blend.blender.TextureParams.SourceType.YUV_DATA     // Catch:{ Exception -> 0x02cf }
            if (r1 != r2) goto L_0x0074
            int r1 = r7.f1298M     // Catch:{ Exception -> 0x02cf }
            com.baidu.p020ar.blend.gpuimage.graphics.C0749a.m1944b(r0, r10, r1)     // Catch:{ Exception -> 0x02cf }
            r20.m1560j()     // Catch:{ Exception -> 0x02cf }
            goto L_0x0074
        L_0x0046:
            int[] r1 = r7.f1321i     // Catch:{ Exception -> 0x02cf }
            android.graphics.SurfaceTexture r2 = r7.f1328p     // Catch:{ Exception -> 0x02cf }
            r7.m1544a((int[]) r1, (android.graphics.SurfaceTexture) r2)     // Catch:{ Exception -> 0x02cf }
            int[] r1 = r7.f1321i     // Catch:{ Exception -> 0x02cf }
            r1 = r1[r8]     // Catch:{ Exception -> 0x02cf }
            com.baidu.ar.blend.gpuimage.a.f r2 = r7.f1286A     // Catch:{ Exception -> 0x02cf }
            float[] r3 = r7.f1336x     // Catch:{ Exception -> 0x02cf }
            r2.mo10004c(r3)     // Catch:{ Exception -> 0x02cf }
            int r2 = r7.f1298M     // Catch:{ Exception -> 0x02cf }
            com.baidu.p020ar.blend.gpuimage.graphics.C0749a.m1944b(r0, r10, r2)     // Catch:{ Exception -> 0x02cf }
            com.baidu.ar.blend.gpuimage.a.f r2 = r7.f1286A     // Catch:{ Exception -> 0x02cf }
            int r3 = r7.f1298M     // Catch:{ Exception -> 0x02cf }
            r2.mo9997b((int) r1, (int) r3)     // Catch:{ Exception -> 0x02cf }
            android.graphics.SurfaceTexture r1 = r7.f1328p     // Catch:{ Exception -> 0x02cf }
            r7.m1546b((android.graphics.SurfaceTexture) r1)     // Catch:{ Exception -> 0x02cf }
            boolean r1 = r7.f1319f     // Catch:{ Exception -> 0x02cf }
            if (r1 != 0) goto L_0x0074
            android.graphics.SurfaceTexture r1 = r7.f1328p     // Catch:{ Exception -> 0x02cf }
            float[] r2 = r7.f1336x     // Catch:{ Exception -> 0x02cf }
            r1.getTransformMatrix(r2)     // Catch:{ Exception -> 0x02cf }
        L_0x0074:
            boolean r1 = r7.f1293H     // Catch:{ Exception -> 0x02cf }
            if (r1 == 0) goto L_0x00a0
            com.baidu.ar.blend.gpuimage.a.h r2 = r7.f1290E     // Catch:{ Exception -> 0x02cf }
            r1 = r20
            r3 = r0
            r4 = r11
            r5 = r12
            r1.m1542a(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x02cf }
            com.baidu.ar.blend.blender.TextureParams$VideoRenderMode r1 = r7.f1317d     // Catch:{ Exception -> 0x02cf }
            com.baidu.ar.blend.blender.TextureParams$VideoRenderMode r2 = com.baidu.p020ar.blend.blender.TextureParams.VideoRenderMode.BG     // Catch:{ Exception -> 0x02cf }
            if (r1 != r2) goto L_0x00a0
            com.baidu.ar.blend.gpuimage.a.v r1 = r7.f1287B     // Catch:{ Exception -> 0x02cf }
            r1.mo10030m()     // Catch:{ Exception -> 0x02cf }
            com.baidu.ar.blend.gpuimage.a.v r1 = r7.f1287B     // Catch:{ Exception -> 0x02cf }
            float[] r2 = com.baidu.p020ar.blend.gpuimage.graphics.C0749a.f1635a     // Catch:{ Exception -> 0x02cf }
            r1.mo10000b(r2)     // Catch:{ Exception -> 0x02cf }
            int r1 = r7.f1298M     // Catch:{ Exception -> 0x02cf }
            com.baidu.p020ar.blend.gpuimage.graphics.C0749a.m1944b(r0, r10, r1)     // Catch:{ Exception -> 0x02cf }
            com.baidu.ar.blend.gpuimage.a.v r1 = r7.f1287B     // Catch:{ Exception -> 0x02cf }
            int r2 = r7.f1298M     // Catch:{ Exception -> 0x02cf }
            r1.mo9997b((int) r11, (int) r2)     // Catch:{ Exception -> 0x02cf }
        L_0x00a0:
            com.baidu.ar.blend.blender.TextureParams$VideoRenderMode r1 = r7.f1317d     // Catch:{ Exception -> 0x02cf }
            com.baidu.ar.blend.blender.TextureParams$VideoRenderMode r2 = com.baidu.p020ar.blend.blender.TextureParams.VideoRenderMode.BG     // Catch:{ Exception -> 0x02cf }
            if (r1 != r2) goto L_0x00a8
            goto L_0x013e
        L_0x00a8:
            com.baidu.ar.blend.blender.TextureParams$VideoRenderMode r1 = r7.f1317d     // Catch:{ Exception -> 0x02cf }
            com.baidu.ar.blend.blender.TextureParams$VideoRenderMode r2 = com.baidu.p020ar.blend.blender.TextureParams.VideoRenderMode.FG     // Catch:{ Exception -> 0x02cf }
            if (r1 != r2) goto L_0x013d
            com.baidu.ar.blend.gpuimage.a.v r1 = r7.f1287B     // Catch:{ Exception -> 0x02cf }
            int r1 = r1.mo10010h()     // Catch:{ Exception -> 0x02cf }
            com.baidu.ar.blend.gpuimage.a.v r2 = r7.f1287B     // Catch:{ Exception -> 0x02cf }
            int r2 = r2.mo10011i()     // Catch:{ Exception -> 0x02cf }
            int r3 = r7.f1304S     // Catch:{ Exception -> 0x02cf }
            int r4 = r7.f1298M     // Catch:{ Exception -> 0x02cf }
            com.baidu.p020ar.blend.gpuimage.graphics.C0749a.m1944b(r12, r10, r4)     // Catch:{ Exception -> 0x02cf }
            com.baidu.ar.blend.gpuimage.a.v r4 = r7.f1287B     // Catch:{ Exception -> 0x02cf }
            int r5 = r7.f1322j     // Catch:{ Exception -> 0x02cf }
            int r6 = r7.f1323k     // Catch:{ Exception -> 0x02cf }
            r4.mo9990a((int) r5, (int) r6)     // Catch:{ Exception -> 0x02cf }
            com.baidu.ar.blend.gpuimage.a.v r4 = r7.f1287B     // Catch:{ Exception -> 0x02cf }
            float[] r5 = r7.f1314ab     // Catch:{ Exception -> 0x02cf }
            r4.mo10000b(r5)     // Catch:{ Exception -> 0x02cf }
            boolean r4 = r7.f1335w     // Catch:{ Exception -> 0x02cf }
            if (r4 == 0) goto L_0x00db
            com.baidu.ar.blend.gpuimage.a.v r4 = r7.f1287B     // Catch:{ Exception -> 0x02cf }
            r4.mo10066n()     // Catch:{ Exception -> 0x02cf }
            goto L_0x00e0
        L_0x00db:
            com.baidu.ar.blend.gpuimage.a.v r4 = r7.f1287B     // Catch:{ Exception -> 0x02cf }
            r4.mo10030m()     // Catch:{ Exception -> 0x02cf }
        L_0x00e0:
            java.nio.ByteBuffer r4 = r7.f1309X     // Catch:{ Exception -> 0x02cf }
            if (r4 == 0) goto L_0x00f8
            com.baidu.ar.blend.gpuimage.a.v r13 = r7.f1287B     // Catch:{ Exception -> 0x02cf }
            java.nio.ByteBuffer r14 = r7.f1309X     // Catch:{ Exception -> 0x02cf }
            r15 = 0
            r16 = 0
            int r4 = r7.f1311Z     // Catch:{ Exception -> 0x02cf }
            int r5 = r7.f1313aa     // Catch:{ Exception -> 0x02cf }
            r17 = r4
            r18 = r5
            r19 = r3
            r13.mo10064a(r14, r15, r16, r17, r18, r19)     // Catch:{ Exception -> 0x02cf }
        L_0x00f8:
            java.lang.Object r4 = r7.f1310Y     // Catch:{ Exception -> 0x02cf }
            monitor-enter(r4)     // Catch:{ Exception -> 0x02cf }
            com.baidu.ar.blend.gpuimage.a.v r5 = r7.f1287B     // Catch:{ all -> 0x013a }
            int r6 = r7.f1298M     // Catch:{ all -> 0x013a }
            r5.mo9997b((int) r3, (int) r6)     // Catch:{ all -> 0x013a }
            monitor-exit(r4)     // Catch:{ all -> 0x013a }
            com.baidu.ar.blend.gpuimage.a.v r3 = r7.f1287B     // Catch:{ Exception -> 0x02cf }
            float[] r4 = com.baidu.p020ar.blend.gpuimage.graphics.C0749a.f1635a     // Catch:{ Exception -> 0x02cf }
            r3.mo10000b(r4)     // Catch:{ Exception -> 0x02cf }
            com.baidu.ar.blend.gpuimage.a.v r3 = r7.f1287B     // Catch:{ Exception -> 0x02cf }
            r3.mo9990a((int) r1, (int) r2)     // Catch:{ Exception -> 0x02cf }
            int r1 = r7.f1302Q     // Catch:{ Exception -> 0x02cf }
            int r2 = r7.f1298M     // Catch:{ Exception -> 0x02cf }
            com.baidu.p020ar.blend.gpuimage.graphics.C0749a.m1944b(r1, r10, r2)     // Catch:{ Exception -> 0x02cf }
            com.baidu.ar.blend.gpuimage.a.p r1 = r7.f1308W     // Catch:{ Exception -> 0x02cf }
            r1.mo10060b(r12)     // Catch:{ Exception -> 0x02cf }
            boolean r1 = r7.f1293H     // Catch:{ Exception -> 0x02cf }
            if (r1 == 0) goto L_0x0127
            com.baidu.ar.blend.gpuimage.a.p r0 = r7.f1308W     // Catch:{ Exception -> 0x02cf }
            int r1 = r7.f1298M     // Catch:{ Exception -> 0x02cf }
            r0.mo9997b((int) r11, (int) r1)     // Catch:{ Exception -> 0x02cf }
            goto L_0x012e
        L_0x0127:
            com.baidu.ar.blend.gpuimage.a.p r1 = r7.f1308W     // Catch:{ Exception -> 0x02cf }
            int r2 = r7.f1298M     // Catch:{ Exception -> 0x02cf }
            r1.mo9997b((int) r0, (int) r2)     // Catch:{ Exception -> 0x02cf }
        L_0x012e:
            int r0 = r7.f1302Q     // Catch:{ Exception -> 0x02cf }
            com.baidu.ar.blend.a.a r1 = r7.f1320g     // Catch:{ Exception -> 0x02cf }
            if (r1 == 0) goto L_0x013e
            com.baidu.ar.blend.a.a r1 = r7.f1320g     // Catch:{ Exception -> 0x02cf }
            r1.mo9742b((int) r0)     // Catch:{ Exception -> 0x02cf }
            goto L_0x013e
        L_0x013a:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x013a }
            throw r0     // Catch:{ Exception -> 0x02cf }
        L_0x013d:
            r0 = -1
        L_0x013e:
            com.baidu.ar.blend.a.a r1 = r7.f1320g     // Catch:{ Exception -> 0x02cf }
            r11 = 0
            if (r1 == 0) goto L_0x014a
            com.baidu.ar.blend.a.a r1 = r7.f1320g     // Catch:{ Exception -> 0x02cf }
            int[] r1 = r1.mo9750k()     // Catch:{ Exception -> 0x02cf }
            goto L_0x014b
        L_0x014a:
            r1 = r11
        L_0x014b:
            if (r1 == 0) goto L_0x0152
            r20.mo9826a()     // Catch:{ Exception -> 0x02cf }
            r7.f1307V = r1     // Catch:{ Exception -> 0x02cf }
        L_0x0152:
            int[] r1 = r7.f1307V     // Catch:{ Exception -> 0x02cf }
            r2 = 3
            r12 = 1
            if (r1 == 0) goto L_0x0160
            int[] r1 = r7.f1307V     // Catch:{ Exception -> 0x02cf }
            r1 = r1[r2]     // Catch:{ Exception -> 0x02cf }
            if (r1 == r9) goto L_0x0160
            r13 = 1
            goto L_0x0161
        L_0x0160:
            r13 = 0
        L_0x0161:
            int[] r1 = r7.f1307V     // Catch:{ Exception -> 0x02cf }
            r3 = 4
            if (r1 == 0) goto L_0x016e
            int[] r1 = r7.f1307V     // Catch:{ Exception -> 0x02cf }
            r1 = r1[r3]     // Catch:{ Exception -> 0x02cf }
            if (r1 == r9) goto L_0x016e
            r1 = 1
            goto L_0x016f
        L_0x016e:
            r1 = 0
        L_0x016f:
            int[] r4 = r7.f1307V     // Catch:{ Exception -> 0x02cf }
            r14 = 5
            if (r4 == 0) goto L_0x01b0
            int[] r4 = r7.f1307V     // Catch:{ Exception -> 0x02cf }
            int r4 = r4.length     // Catch:{ Exception -> 0x02cf }
            if (r4 < r14) goto L_0x01b0
            if (r13 == 0) goto L_0x01b0
            int[] r4 = r7.f1307V     // Catch:{ Exception -> 0x02cf }
            r2 = r4[r2]     // Catch:{ Exception -> 0x02cf }
            int[] r4 = r7.f1307V     // Catch:{ Exception -> 0x02cf }
            r3 = r4[r3]     // Catch:{ Exception -> 0x02cf }
            int r4 = r7.f1337y     // Catch:{ Exception -> 0x02cf }
            int r15 = r7.f1299N     // Catch:{ Exception -> 0x02cf }
            int r5 = r7.f1300O     // Catch:{ Exception -> 0x02cf }
            int r6 = r7.f1301P     // Catch:{ Exception -> 0x02cf }
            if (r1 == 0) goto L_0x01a0
            int r1 = r7.f1298M     // Catch:{ Exception -> 0x02cf }
            com.baidu.p020ar.blend.gpuimage.graphics.C0749a.m1944b(r4, r10, r1)     // Catch:{ Exception -> 0x02cf }
            com.baidu.ar.blend.gpuimage.a.d r1 = r7.f1289D     // Catch:{ Exception -> 0x02cf }
            r1.mo10060b(r3)     // Catch:{ Exception -> 0x02cf }
            com.baidu.ar.blend.gpuimage.a.d r1 = r7.f1289D     // Catch:{ Exception -> 0x02cf }
            int r3 = r7.f1298M     // Catch:{ Exception -> 0x02cf }
            r1.mo9997b((int) r2, (int) r3)     // Catch:{ Exception -> 0x02cf }
            r3 = r4
            goto L_0x01a1
        L_0x01a0:
            r3 = r2
        L_0x01a1:
            boolean r1 = r7.f1294I     // Catch:{ Exception -> 0x02cf }
            if (r1 == 0) goto L_0x01ae
            com.baidu.ar.blend.gpuimage.a.h r2 = r7.f1291F     // Catch:{ Exception -> 0x02cf }
            r1 = r20
            r4 = r15
            r1.m1542a(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x02cf }
            goto L_0x01b1
        L_0x01ae:
            r15 = r3
            goto L_0x01b1
        L_0x01b0:
            r15 = -1
        L_0x01b1:
            com.baidu.ar.blend.blender.TextureParams$VideoRenderMode r1 = r7.f1317d     // Catch:{ Exception -> 0x02cf }
            com.baidu.ar.blend.blender.TextureParams$VideoRenderMode r2 = com.baidu.p020ar.blend.blender.TextureParams.VideoRenderMode.BG     // Catch:{ Exception -> 0x02cf }
            if (r1 == r2) goto L_0x01bd
            if (r13 == 0) goto L_0x01ba
            goto L_0x01bd
        L_0x01ba:
            r0 = -1
            goto L_0x023c
        L_0x01bd:
            int r1 = r7.f1337y     // Catch:{ Exception -> 0x02cf }
            int r6 = r7.f1300O     // Catch:{ Exception -> 0x02cf }
            int r5 = r7.f1301P     // Catch:{ Exception -> 0x02cf }
            com.baidu.ar.blend.blender.TextureParams$VideoRenderMode r2 = r7.f1317d     // Catch:{ Exception -> 0x02cf }
            com.baidu.ar.blend.blender.TextureParams$VideoRenderMode r3 = com.baidu.p020ar.blend.blender.TextureParams.VideoRenderMode.BG     // Catch:{ Exception -> 0x02cf }
            if (r2 != r3) goto L_0x01cd
            if (r13 == 0) goto L_0x01cd
            r2 = 1
            goto L_0x01ce
        L_0x01cd:
            r2 = 0
        L_0x01ce:
            if (r2 == 0) goto L_0x01e2
            int r2 = r7.f1298M     // Catch:{ Exception -> 0x02cf }
            com.baidu.p020ar.blend.gpuimage.graphics.C0749a.m1944b(r1, r10, r2)     // Catch:{ Exception -> 0x02cf }
            com.baidu.ar.blend.gpuimage.a.d r2 = r7.f1289D     // Catch:{ Exception -> 0x02cf }
            r2.mo10060b(r15)     // Catch:{ Exception -> 0x02cf }
            com.baidu.ar.blend.gpuimage.a.d r2 = r7.f1289D     // Catch:{ Exception -> 0x02cf }
            int r3 = r7.f1298M     // Catch:{ Exception -> 0x02cf }
            r2.mo9997b((int) r0, (int) r3)     // Catch:{ Exception -> 0x02cf }
            goto L_0x01f8
        L_0x01e2:
            com.baidu.ar.blend.blender.TextureParams$VideoRenderMode r2 = r7.f1317d     // Catch:{ Exception -> 0x02cf }
            com.baidu.ar.blend.blender.TextureParams$VideoRenderMode r3 = com.baidu.p020ar.blend.blender.TextureParams.VideoRenderMode.BG     // Catch:{ Exception -> 0x02cf }
            if (r2 != r3) goto L_0x01ea
            r3 = r0
            goto L_0x01fb
        L_0x01ea:
            if (r13 == 0) goto L_0x01fa
            int r0 = r7.f1298M     // Catch:{ Exception -> 0x02cf }
            com.baidu.p020ar.blend.gpuimage.graphics.C0749a.m1944b(r1, r10, r0)     // Catch:{ Exception -> 0x02cf }
            com.baidu.ar.blend.gpuimage.a.g r0 = r7.f1288C     // Catch:{ Exception -> 0x02cf }
            int r2 = r7.f1298M     // Catch:{ Exception -> 0x02cf }
            r0.mo9997b((int) r15, (int) r2)     // Catch:{ Exception -> 0x02cf }
        L_0x01f8:
            r3 = r1
            goto L_0x01fb
        L_0x01fa:
            r3 = -1
        L_0x01fb:
            int r0 = r7.f1299N     // Catch:{ Exception -> 0x02cf }
            boolean r1 = r7.f1295J     // Catch:{ Exception -> 0x02cf }
            if (r1 == 0) goto L_0x020e
            com.baidu.ar.blend.gpuimage.a.h r2 = r7.f1292G     // Catch:{ Exception -> 0x02cf }
            r1 = r20
            r4 = r0
            r13 = r5
            r5 = r6
            r15 = r6
            r6 = r13
            r1.m1542a(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x02cf }
            goto L_0x0210
        L_0x020e:
            r15 = r6
            r0 = r3
        L_0x0210:
            int[] r1 = r7.f1307V     // Catch:{ Exception -> 0x02cf }
            if (r1 == 0) goto L_0x0236
            int[] r1 = r7.f1307V     // Catch:{ Exception -> 0x02cf }
            int r1 = r1.length     // Catch:{ Exception -> 0x02cf }
            r2 = 6
            if (r1 < r2) goto L_0x0236
            int[] r1 = r7.f1307V     // Catch:{ Exception -> 0x02cf }
            r1 = r1[r14]     // Catch:{ Exception -> 0x02cf }
            if (r1 == r9) goto L_0x0236
            int[] r1 = r7.f1307V     // Catch:{ Exception -> 0x02cf }
            r1 = r1[r14]     // Catch:{ Exception -> 0x02cf }
            int r2 = r7.f1298M     // Catch:{ Exception -> 0x02cf }
            com.baidu.p020ar.blend.gpuimage.graphics.C0749a.m1944b(r15, r10, r2)     // Catch:{ Exception -> 0x02cf }
            com.baidu.ar.blend.gpuimage.a.d r2 = r7.f1289D     // Catch:{ Exception -> 0x02cf }
            r2.mo10060b(r1)     // Catch:{ Exception -> 0x02cf }
            com.baidu.ar.blend.gpuimage.a.d r1 = r7.f1289D     // Catch:{ Exception -> 0x02cf }
            int r2 = r7.f1298M     // Catch:{ Exception -> 0x02cf }
            r1.mo9997b((int) r0, (int) r2)     // Catch:{ Exception -> 0x02cf }
            goto L_0x0237
        L_0x0236:
            r15 = r0
        L_0x0237:
            com.baidu.ar.blend.gpuimage.a.g r1 = r7.f1288C     // Catch:{ Exception -> 0x02cf }
            r1.mo9988a((int) r15)     // Catch:{ Exception -> 0x02cf }
        L_0x023c:
            if (r0 == r9) goto L_0x0260
            com.baidu.ar.blend.blender.c$c r1 = r7.f1326n     // Catch:{ Exception -> 0x02cf }
            if (r1 != 0) goto L_0x0246
            com.baidu.ar.blend.blender.c$d r1 = r7.f1306U     // Catch:{ Exception -> 0x02cf }
            if (r1 == 0) goto L_0x0260
        L_0x0246:
            int r1 = r7.f1305T     // Catch:{ Exception -> 0x02cf }
            if (r1 != r9) goto L_0x0251
            int r1 = r7.f1322j     // Catch:{ Exception -> 0x02cf }
            int r2 = r7.f1323k     // Catch:{ Exception -> 0x02cf }
            r7.m1539a((int) r1, (int) r2)     // Catch:{ Exception -> 0x02cf }
        L_0x0251:
            int r1 = r7.f1305T     // Catch:{ Exception -> 0x02cf }
            int r2 = r7.f1298M     // Catch:{ Exception -> 0x02cf }
            com.baidu.p020ar.blend.gpuimage.graphics.C0749a.m1944b(r1, r10, r2)     // Catch:{ Exception -> 0x02cf }
            com.baidu.ar.blend.gpuimage.a.g r1 = r7.f1288C     // Catch:{ Exception -> 0x02cf }
            int r2 = r7.f1298M     // Catch:{ Exception -> 0x02cf }
            r1.mo9997b((int) r0, (int) r2)     // Catch:{ Exception -> 0x02cf }
            goto L_0x0263
        L_0x0260:
            r20.m1549c()     // Catch:{ Exception -> 0x02cf }
        L_0x0263:
            com.baidu.ar.blend.blender.c$d r0 = r7.f1306U     // Catch:{ Exception -> 0x02cf }
            if (r0 == 0) goto L_0x028e
            int r0 = r7.f1322j     // Catch:{ Exception -> 0x02cf }
            int r1 = r7.f1323k     // Catch:{ Exception -> 0x02cf }
            int r2 = r0 * r1
            int[] r2 = new int[r2]     // Catch:{ Exception -> 0x02cf }
            java.nio.IntBuffer r3 = java.nio.IntBuffer.wrap(r2)     // Catch:{ Exception -> 0x02cf }
            r3.position(r8)     // Catch:{ Exception -> 0x02cf }
            r3.rewind()     // Catch:{ Exception -> 0x02cf }
            r13 = 0
            r14 = 0
            r17 = 6408(0x1908, float:8.98E-42)
            r18 = 5121(0x1401, float:7.176E-42)
            r15 = r0
            r16 = r1
            r19 = r3
            android.opengl.GLES20.glReadPixels(r13, r14, r15, r16, r17, r18, r19)     // Catch:{ Exception -> 0x02cf }
            com.baidu.ar.blend.blender.c$d r3 = r7.f1306U     // Catch:{ Exception -> 0x02cf }
            r3.mo9550a(r2, r0, r1)     // Catch:{ Exception -> 0x02cf }
            r7.f1306U = r11     // Catch:{ Exception -> 0x02cf }
        L_0x028e:
            com.baidu.ar.blend.blender.c$c r0 = r7.f1326n     // Catch:{ Exception -> 0x02cf }
            if (r0 == 0) goto L_0x02b2
            boolean r0 = r7.f1327o     // Catch:{ Exception -> 0x02cf }
            if (r0 != 0) goto L_0x02ab
            com.baidu.ar.blend.blender.c$c r0 = r7.f1326n     // Catch:{ Exception -> 0x02cf }
            javax.microedition.khronos.egl.EGL r1 = javax.microedition.khronos.egl.EGLContext.getEGL()     // Catch:{ Exception -> 0x02cf }
            javax.microedition.khronos.egl.EGL10 r1 = (javax.microedition.khronos.egl.EGL10) r1     // Catch:{ Exception -> 0x02cf }
            javax.microedition.khronos.egl.EGLContext r1 = r1.eglGetCurrentContext()     // Catch:{ Exception -> 0x02cf }
            int r2 = r7.f1322j     // Catch:{ Exception -> 0x02cf }
            int r3 = r7.f1323k     // Catch:{ Exception -> 0x02cf }
            r0.mo9509a(r1, r2, r3)     // Catch:{ Exception -> 0x02cf }
            r7.f1327o = r12     // Catch:{ Exception -> 0x02cf }
        L_0x02ab:
            com.baidu.ar.blend.blender.c$c r0 = r7.f1326n     // Catch:{ Exception -> 0x02cf }
            int r1 = r7.f1305T     // Catch:{ Exception -> 0x02cf }
            r0.mo9506a(r1)     // Catch:{ Exception -> 0x02cf }
        L_0x02b2:
            com.baidu.ar.blend.a.a r0 = r7.f1320g     // Catch:{ Exception -> 0x02cf }
            if (r0 == 0) goto L_0x02d3
            com.baidu.ar.blend.a.a r0 = r7.f1320g     // Catch:{ Exception -> 0x02cf }
            int r0 = r0.mo9751l()     // Catch:{ Exception -> 0x02cf }
            if (r0 == 0) goto L_0x02c1
            r20.mo9826a()     // Catch:{ Exception -> 0x02cf }
        L_0x02c1:
            com.baidu.ar.blend.a.a r0 = r7.f1320g     // Catch:{ Exception -> 0x02cf }
            r0.mo9749j()     // Catch:{ Exception -> 0x02cf }
            goto L_0x02d3
        L_0x02c7:
            java.lang.String r0 = f1285h     // Catch:{ Exception -> 0x02cf }
            java.lang.String r1 = "Skipping Frame Processing!"
            android.util.Log.e(r0, r1)     // Catch:{ Exception -> 0x02cf }
            return
        L_0x02cf:
            r0 = move-exception
            r0.printStackTrace()
        L_0x02d3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.blend.blender.C0653b.m1559i():void");
    }

    /* renamed from: j */
    private void m1560j() {
        if (C0654c.f1341c != null && C0654c.f1339a != 0 && C0654c.f1340b != 0) {
            int i = C0654c.f1339a;
            int i2 = C0654c.f1340b;
            byte[] bArr = C0654c.f1341c;
            if (this.f1338z != null) {
                this.f1338z.mo10000b(this.f1336x);
                synchronized (C0654c.class) {
                    System.currentTimeMillis();
                    this.f1338z.mo10043a(i, i2, bArr);
                }
                this.f1338z.mo9997b(-1, this.f1298M);
                if (this.f1318e != null) {
                    this.f1318e.mo9871a();
                    this.f1318e = null;
                }
            }
        }
    }

    /* renamed from: a */
    public void mo9826a() {
        if (this.f1320g != null && this.f1307V != null) {
            this.f1320g.mo9744b(this.f1307V);
            this.f1307V = null;
        }
    }

    /* renamed from: a */
    public void mo9827a(int i) {
        if (i > 0 && i <= 60) {
            this.f1325m = 1000 / i;
        }
    }

    /* renamed from: a */
    public void mo9828a(SurfaceTexture surfaceTexture) {
        if (this.f1328p != surfaceTexture) {
            m1548b(this.f1321i, this.f1328p);
            this.f1317d = TextureParams.VideoRenderMode.NONE;
            this.f1328p = surfaceTexture;
        }
    }

    /* renamed from: a */
    public void mo9829a(C0630a aVar) {
        this.f1320g = aVar;
    }

    /* renamed from: a */
    public void mo9830a(TextureParams textureParams) {
        boolean z = false;
        boolean z2 = (this.f1333u == textureParams.mo9777b() && this.f1334v == textureParams.mo9778c()) ? false : true;
        this.f1317d = textureParams.mo9780e();
        this.f1330r = textureParams.mo9783h();
        this.f1331s = textureParams.mo9781f();
        this.f1332t = textureParams.mo9782g();
        this.f1319f = textureParams.mo9776a();
        this.f1333u = textureParams.mo9777b();
        this.f1334v = textureParams.mo9778c();
        this.f1335w = textureParams.mo9787l();
        m1543a(textureParams.mo9779d());
        if (this.f1317d == TextureParams.VideoRenderMode.FG) {
            m1547b(textureParams.mo9785j());
        }
        if (this.f1338z != null) {
            this.f1338z.mo10044a(this.f1331s, this.f1332t);
        }
        float i = textureParams.mo9784i();
        if (Float.compare(i, 0.0f) == 0) {
            i = 1.0f;
        }
        if (!(this.f1317d == TextureParams.VideoRenderMode.NONE || this.f1322j == 0 || this.f1323k == 0)) {
            if (this.f1303R == -1 || Float.compare(i, this.f1329q) != 0) {
                m1550c((int) (((float) this.f1322j) / i), (int) (((float) this.f1323k) / i));
                if (this.f1338z != null) {
                    this.f1338z.mo9990a((int) (((float) this.f1322j) / i), (int) (((float) this.f1323k) / i));
                }
                if (this.f1286A != null) {
                    this.f1286A.mo9990a((int) (((float) this.f1322j) / i), (int) (((float) this.f1323k) / i));
                }
                if (this.f1287B != null) {
                    this.f1287B.mo9990a((int) (((float) this.f1322j) / i), (int) (((float) this.f1323k) / i));
                }
            }
            if (this.f1317d != TextureParams.VideoRenderMode.FG) {
                m1555f();
            } else if (this.f1302Q == -1 || Float.compare(i, this.f1329q) != 0) {
                m1552d((int) (((float) this.f1322j) / i), (int) (((float) this.f1323k) / i));
                if (this.f1308W != null) {
                    this.f1308W.mo9990a((int) (((float) this.f1322j) / i), (int) (((float) this.f1323k) / i));
                }
            }
        }
        if (this.f1317d == TextureParams.VideoRenderMode.FG) {
            if (this.f1287B != null && this.f1335w) {
                C0744v vVar = this.f1287B;
                if (this.f1333u <= this.f1334v) {
                    z = this.f1331s;
                } else if (!this.f1331s) {
                    z = true;
                }
                vVar.mo10065a(z, this.f1332t);
            }
            boolean k = textureParams.mo9786k();
            if (this.f1304S == -1 || z2) {
                m1554e(k ? Math.min(this.f1333u, this.f1334v) : Math.max(this.f1333u, this.f1334v), k ? Math.max(this.f1333u, this.f1334v) : Math.min(this.f1333u, this.f1334v));
            }
        } else {
            m1557g();
        }
        this.f1329q = i;
        GLES20.glFlush();
    }

    /* renamed from: a */
    public void mo9831a(C0654c.C0668c cVar) {
        this.f1326n = cVar;
        this.f1327o = false;
    }

    /* renamed from: a */
    public void mo9832a(C0654c.C0669d dVar) {
        this.f1306U = dVar;
    }

    /* renamed from: a */
    public void mo9833a(List<C0712g> list) {
        Log.d(f1285h, "setGPUImageFiltersInternal: ");
        m1540a(this.f1290E);
        this.f1290E.mo10027a(list);
        m1541a(this.f1290E, this.f1322j, this.f1323k);
    }

    /* renamed from: a */
    public void mo9834a(boolean z) {
        this.f1312a = z;
    }

    /* renamed from: a */
    public void mo9835a(byte[] bArr, int i, int i2) {
        synchronized (this.f1310Y) {
            this.f1311Z = i;
            this.f1313aa = i2;
            if (this.f1309X == null) {
                this.f1309X = ByteBuffer.allocateDirect(bArr.length);
            }
            this.f1309X.put(bArr, 0, bArr.length);
            this.f1309X.position(0);
        }
    }

    /* renamed from: b */
    public void mo9836b() {
        Log.d(f1285h, "bdar onContextDestroy");
        if (this.f1326n != null) {
            this.f1326n.mo9509a((EGLContext) null, 0, 0);
        }
        m1548b(this.f1321i, this.f1328p);
        this.f1315b = 0;
        this.f1318e = null;
        this.f1322j = 0;
        this.f1323k = 0;
        this.f1338z.mo10005d();
        this.f1338z = null;
        this.f1286A.mo10005d();
        this.f1286A = null;
        this.f1287B.mo10005d();
        this.f1287B = null;
        this.f1288C.mo10005d();
        this.f1288C = null;
        this.f1289D.mo10005d();
        this.f1289D = null;
        this.f1308W.mo10005d();
        this.f1308W = null;
        m1540a(this.f1290E);
        m1540a(this.f1291F);
        m1540a(this.f1292G);
        this.f1290E = null;
        this.f1291F = null;
        this.f1292G = null;
        m1551d();
        m1558h();
        m1549c();
        m1553e();
        m1557g();
        m1555f();
        C0749a.m1943b(this.f1298M);
        this.f1298M = -1;
        C0749a.m1943b(this.f1296K);
        this.f1296K = -1;
        if (this.f1306U != null) {
            this.f1306U.mo9550a((int[]) null, 0, 0);
            this.f1306U = null;
        }
        if (this.f1307V != null) {
            C0630a.m1402a(this.f1307V);
            this.f1307V = null;
        }
        this.f1316c = true;
    }

    /* renamed from: b */
    public void mo9837b(List<C0712g> list) {
        Log.d(f1285h, "setGPUImageFiltersInternal: ");
        m1540a(this.f1291F);
        this.f1291F.mo10027a(list);
        m1541a(this.f1291F, this.f1322j, this.f1323k);
    }

    /* renamed from: c */
    public void mo9838c(List<C0712g> list) {
        Log.d(f1285h, "setGPUImageFiltersInternal: ");
        m1540a(this.f1292G);
        this.f1292G.mo10027a(list);
        m1541a(this.f1292G, this.f1322j, this.f1323k);
    }

    public void onDrawFrame(GL10 gl10) {
        String str = f1285h;
        Log.i(str, "bdar: blender renderer onDrawFrame  mEnginSoLoaded = " + this.f1312a + ", mContextDestroy = " + this.f1316c);
        if (!this.f1316c) {
            if (this.f1325m > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.f1324l;
                if (currentTimeMillis < ((long) this.f1325m)) {
                    try {
                        Thread.sleep(((long) this.f1325m) - currentTimeMillis);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                this.f1324l = System.currentTimeMillis();
            }
            System.currentTimeMillis();
            m1559i();
        }
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        Log.d(f1285h, String.format("bdar:onSurfaceChanged thread name %s id %s width %d height %d", new Object[]{Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(i), Integer.valueOf(i2)}));
        GLES20.glViewport(0, 0, i, i2);
        if (this.f1322j != i || this.f1323k != i2) {
            this.f1322j = i;
            this.f1323k = i2;
            String str = f1285h;
            Log.e(str, "bdar: glview Width = " + this.f1322j + ", height = " + this.f1323k);
            m1548b(this.f1321i, this.f1328p);
            this.f1290E.mo9990a(i, i2);
            this.f1291F.mo9990a(i, i2);
            this.f1292G.mo9990a(i, i2);
            this.f1288C.mo9990a(i, i2);
            this.f1289D.mo9990a(i, i2);
            m1545b(i, i2);
            m1556f(i, i2);
            if (this.f1317d != TextureParams.VideoRenderMode.NONE) {
                float f = (float) i;
                float f2 = (float) i2;
                m1550c((int) (f / this.f1329q), (int) (f2 / this.f1329q));
                this.f1338z.mo9990a((int) (f / this.f1329q), (int) (f2 / this.f1329q));
                this.f1286A.mo9990a((int) (f / this.f1329q), (int) (f2 / this.f1329q));
                this.f1287B.mo9990a((int) (f / this.f1329q), (int) (f2 / this.f1329q));
                if (this.f1317d == TextureParams.VideoRenderMode.FG) {
                    if (this.f1302Q != -1) {
                        m1552d((int) (f / this.f1329q), (int) (f2 / this.f1329q));
                    }
                    this.f1308W.mo9990a((int) (f / this.f1329q), (int) (f2 / this.f1329q));
                }
            }
            GLES20.glFlush();
        }
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Log.e(f1285h, "bdar:onSurfaceCreated");
        this.f1316c = false;
        this.f1338z = new C0730m();
        if (Float.compare(this.f1332t, 0.0f) != 0) {
            this.f1338z.mo10044a(this.f1331s, this.f1332t);
        }
        this.f1338z.mo10001c();
        this.f1286A = new C0711f();
        this.f1286A.mo10001c();
        this.f1287B = new C0744v();
        if (Float.compare(this.f1332t, 0.0f) != 0 && this.f1317d == TextureParams.VideoRenderMode.FG && this.f1335w) {
            this.f1287B.mo10065a(this.f1333u > this.f1334v ? !this.f1331s : this.f1331s, this.f1332t);
        }
        this.f1287B.mo10001c();
        this.f1288C = new C0712g();
        this.f1288C.mo10001c();
        this.f1289D = new C0709d();
        this.f1289D.mo10001c();
        this.f1308W = new C0733p();
        this.f1308W.mo10001c();
        this.f1298M = C0749a.m1942b();
        this.f1296K = C0749a.m1942b();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C0712g());
        this.f1290E = new C0724h(arrayList);
        this.f1290E.mo10028a(true);
        m1541a(this.f1290E, 0, 0);
        this.f1291F = new C0724h(arrayList);
        this.f1291F.mo10028a(true);
        m1541a(this.f1291F, 0, 0);
        this.f1292G = new C0724h(arrayList);
        this.f1292G.mo10028a(true);
        m1541a(this.f1292G, 0, 0);
    }
}
