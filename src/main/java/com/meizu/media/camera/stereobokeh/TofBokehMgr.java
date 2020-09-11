package com.meizu.media.camera.stereobokeh;

import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.mode.CameraModeListener;
import com.meizu.media.camera.portrait.BokehFace;
import com.meizu.media.camera.portrait.CameraImageParam;
import com.meizu.media.camera.portrait.DualcamMeta;
import com.meizu.media.camera.portrait.FocusPoint;
import com.meizu.media.camera.stereobokeh.TofDataCache;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 N2\u00020\u0001:\u0002NOB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020\u000fJ\b\u0010(\u001a\u00020\u0006H\u0016J\b\u0010)\u001a\u0004\u0018\u00010\bJ\u0006\u0010*\u001a\u00020\u000fJ\u0006\u0010+\u001a\u00020&J\u0006\u0010,\u001a\u00020&J.\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u0006J\u0006\u00103\u001a\u00020&J\u0010\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\bH\u0016J\u0010\u00106\u001a\u00020&2\u0006\u00107\u001a\u00020\u000fH\u0016J\u0010\u00108\u001a\u00020&2\u0006\u00107\u001a\u00020\u000fH\u0016J:\u00109\u001a\u00020\u00062\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\u00062\u0006\u0010B\u001a\u00020CJ\u0010\u00109\u001a\u00020\u00062\u0006\u0010D\u001a\u00020\fH\u0016J.\u0010E\u001a\u00020&2\u0006\u0010F\u001a\u00020\b2\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00062\u0006\u0010G\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u000fJ.\u0010I\u001a\u00020&2\u0006\u0010F\u001a\u00020\b2\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00062\u0006\u0010G\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u000fJ\u000e\u0010J\u001a\u00020&2\u0006\u0010K\u001a\u00020\nJ\u0010\u0010L\u001a\u00020&2\u0006\u00107\u001a\u00020\u000fH\u0016J\u0010\u0010M\u001a\u00020&2\u0006\u00107\u001a\u00020\u000fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000¨\u0006P"}, mo27294d2 = {"Lcom/meizu/media/camera/stereobokeh/TofBokehMgr;", "Lcom/meizu/media/camera/camcontroller/CameraController$CameraBokehDetectionCallback;", "listener", "Lcom/meizu/media/camera/mode/CameraModeListener;", "(Lcom/meizu/media/camera/mode/CameraModeListener;)V", "dumpfp", "", "mCaptureData", "", "mDataCallback", "Lcom/meizu/media/camera/stereobokeh/TofBokehMgr$RecordDataCallback;", "mDualcamMeta", "Lcom/meizu/media/camera/portrait/DualcamMeta;", "mGetIndex", "mHEngine", "", "mIvalidValue", "mListener", "mMainCaptureTimestamp", "mMainPreviewTimestamp", "mPreviewData", "mPreviewData2", "mPreviewHight", "mPreviewHight2", "mPreviewRowstride", "mPreviewRowstride2", "mPreviewWidth", "mPreviewWidth2", "mSetIndex", "mSyncObject", "", "mSyncObjectForTofTimestamp", "mTofCache", "Lcom/meizu/media/camera/stereobokeh/TofDataCache;", "mTofCaptureTimestamp", "mTofPreviewTimestamp", "", "capture", "", "getMainPreviewTimestamp", "getRotation", "getTofData", "getTofPreviewTimestamp", "init", "onCameraSwitched", "previewProcess", "previewData", "previewData2", "width", "height", "rowstrite", "release", "setCaliData", "calidata", "setMainCaptureTimestamp", "timestamp", "setMainPreviewTimestamp", "setMetaData", "imageParams", "Lcom/meizu/media/camera/portrait/CameraImageParam;", "face", "Lcom/meizu/media/camera/portrait/BokehFace;", "point", "Lcom/meizu/media/camera/portrait/FocusPoint;", "blurIntensity", "i32DeviceRoll", "bAFstatus", "", "dualcamMeta", "setPreviewData", "data", "rowstride", "tiemstamp", "setPreviewData2", "setRecordDataCallback", "callback", "setTofCaptureTimestamp", "setTofPreviewTimestamp", "Companion", "RecordDataCallback", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.stereobokeh.c */
public final class TofBokehMgr implements CameraController.C1875b {

    /* renamed from: a */
    public static ChangeQuickRedirect f12228a;

    /* renamed from: b */
    public static final C2372a f12229b = new C2372a((DefaultConstructorMarker) null);

    /* renamed from: x */
    private static final LogUtil.C2630a f12230x = new LogUtil.C2630a("TofBokehMgr");

    /* renamed from: c */
    private volatile byte[] f12231c;

    /* renamed from: d */
    private volatile byte[] f12232d;

    /* renamed from: e */
    private volatile byte[] f12233e;

    /* renamed from: f */
    private int f12234f;

    /* renamed from: g */
    private int f12235g;

    /* renamed from: h */
    private int f12236h;

    /* renamed from: i */
    private int f12237i;

    /* renamed from: j */
    private int f12238j;

    /* renamed from: k */
    private int f12239k;

    /* renamed from: l */
    private final CameraModeListener f12240l;

    /* renamed from: m */
    private final Object f12241m = new Object();

    /* renamed from: n */
    private final Object f12242n = new Object();

    /* renamed from: o */
    private DualcamMeta f12243o;

    /* renamed from: p */
    private long f12244p = -1;

    /* renamed from: q */
    private long f12245q = -1;

    /* renamed from: r */
    private C2373b f12246r;

    /* renamed from: s */
    private long f12247s = -1;

    /* renamed from: t */
    private final long[] f12248t = new long[10];

    /* renamed from: u */
    private long f12249u = -1;

    /* renamed from: v */
    private long f12250v = -1;

    /* renamed from: w */
    private TofDataCache f12251w;

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, mo27294d2 = {"Lcom/meizu/media/camera/stereobokeh/TofBokehMgr$RecordDataCallback;", "", "onPreviewDataUpdate", "", "data", "", "width", "", "height", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.stereobokeh.c$b */
    /* compiled from: TofBokehMgr.kt */
    public interface C2373b {
        /* renamed from: a */
        void mo20655a(@Nullable byte[] bArr, int i, int i2);
    }

    /* renamed from: b */
    public final void mo21461b() {
    }

    public TofBokehMgr(@NotNull CameraModeListener hVar) {
        C3443i.m21155b(hVar, "listener");
        LogUtil.m15952c(f12230x, "init");
        this.f12240l = hVar;
        CameraController.m8868g().mo19468a((CameraController.C1875b) this);
        this.f12251w = new TofDataCache(5);
        this.f12248t[0] = -1;
        this.f12248t[1] = -1;
        this.f12248t[2] = -1;
        this.f12248t[3] = -1;
        this.f12248t[4] = -1;
        this.f12248t[5] = -1;
        this.f12248t[6] = -1;
        this.f12248t[7] = -1;
        this.f12248t[8] = -1;
        this.f12248t[9] = -1;
    }

    /* renamed from: a */
    public final void mo21459a(@NotNull C2373b bVar) {
        if (!PatchProxy.proxy(new Object[]{bVar}, this, f12228a, false, 6239, new Class[]{C2373b.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(bVar, "callback");
            this.f12246r = bVar;
        }
    }

    /* renamed from: a */
    public final void mo21460a(@NotNull byte[] bArr, int i, int i2, int i3, long j) {
        byte[] bArr2 = bArr;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j2 = j;
        if (!PatchProxy.proxy(new Object[]{bArr2, new Integer(i4), new Integer(i5), new Integer(i6), new Long(j2)}, this, f12228a, false, 6240, new Class[]{byte[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Long.TYPE}, Void.TYPE).isSupported) {
            C3443i.m21155b(bArr2, "data");
            synchronized (this.f12241m) {
                if (this.f12231c == null) {
                    LogUtil.C2630a aVar = f12230x;
                    LogUtil.m15952c(aVar, "setPreviewData:" + i4 + "x" + i5 + "x" + i6);
                    this.f12231c = new byte[(((i6 * i5) * 3) / 2)];
                    this.f12234f = i4;
                    this.f12235g = i5;
                    this.f12236h = i6;
                } else if (!(this.f12234f == i4 && this.f12235g == i5)) {
                    LogUtil.C2630a aVar2 = f12230x;
                    LogUtil.m15954d(aVar2, "setPreviewData:" + i4 + "x" + i5 + "x" + i6);
                    this.f12231c = new byte[(((i6 * i5) * 3) / 2)];
                    this.f12234f = i4;
                    this.f12235g = i5;
                    this.f12236h = i6;
                }
                this.f12231c = bArr2;
                if (this.f12231c == null || this.f12232d == null) {
                    this.f12240l.mo18017a(this.f12231c, i4, i5, i6);
                } else {
                    byte[] bArr3 = this.f12231c;
                    if (bArr3 == null) {
                        C3443i.m21151a();
                    }
                    TofDataCache dVar = this.f12251w;
                    if (dVar == null) {
                        C3443i.m21151a();
                    }
                    TofDataCache.C2375b a = dVar.mo21465a(j2);
                    if (a == null) {
                        C3443i.m21151a();
                    }
                    mo21458a(bArr3, a.mo21470b(), i, i2, i3);
                    this.f12240l.mo18017a(this.f12231c, i4, i5, i6);
                }
                if (this.f12246r != null) {
                    C2373b bVar = this.f12246r;
                    if (bVar == null) {
                        C3443i.m21151a();
                    }
                    bVar.mo20655a(this.f12231c, i4, i5);
                }
                Unit tVar = Unit.f18749a;
            }
        }
    }

    /* renamed from: b */
    public final void mo21462b(@NotNull byte[] bArr, int i, int i2, int i3, long j) {
        if (!PatchProxy.proxy(new Object[]{bArr, new Integer(i), new Integer(i2), new Integer(i3), new Long(j)}, this, f12228a, false, 6241, new Class[]{byte[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Long.TYPE}, Void.TYPE).isSupported) {
            C3443i.m21155b(bArr, "data");
            if (this.f12233e == null) {
                LogUtil.C2630a aVar = f12230x;
                LogUtil.m15952c(aVar, "setPreviewData2:" + i + "x" + i2);
                this.f12233e = new byte[(i * i2 * 2)];
            }
            if (this.f12232d == null) {
                LogUtil.C2630a aVar2 = f12230x;
                LogUtil.m15952c(aVar2, "setPreviewData2:" + i + "x" + i2);
                this.f12232d = new byte[(i * i2 * 2)];
                this.f12237i = i;
                this.f12238j = i2;
                this.f12239k = i3;
            } else if (!(this.f12234f == i && this.f12235g == i2)) {
                int i4 = i * i2 * 2;
                this.f12232d = new byte[i4];
                this.f12233e = new byte[i4];
                this.f12237i = i;
                this.f12238j = i2;
                this.f12239k = i3;
            }
            this.f12232d = bArr;
            TofDataCache dVar = this.f12251w;
            if (dVar == null) {
                C3443i.m21151a();
            }
            byte[] bArr2 = this.f12232d;
            if (bArr2 == null) {
                C3443i.m21151a();
            }
            dVar.mo21467a(j, bArr2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00e8, code lost:
        return r1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int mo21458a(@org.jetbrains.annotations.NotNull byte[] r21, @org.jetbrains.annotations.NotNull byte[] r22, int r23, int r24, int r25) {
        /*
            r20 = this;
            r8 = r20
            r0 = r21
            r13 = r22
            monitor-enter(r20)
            r1 = 5
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ all -> 0x00e9 }
            r3 = 0
            r2[r3] = r0     // Catch:{ all -> 0x00e9 }
            r4 = 1
            r2[r4] = r13     // Catch:{ all -> 0x00e9 }
            java.lang.Integer r5 = new java.lang.Integer     // Catch:{ all -> 0x00e9 }
            r14 = r23
            r5.<init>(r14)     // Catch:{ all -> 0x00e9 }
            r6 = 2
            r2[r6] = r5     // Catch:{ all -> 0x00e9 }
            java.lang.Integer r5 = new java.lang.Integer     // Catch:{ all -> 0x00e9 }
            r15 = r24
            r5.<init>(r15)     // Catch:{ all -> 0x00e9 }
            r7 = 3
            r2[r7] = r5     // Catch:{ all -> 0x00e9 }
            java.lang.Integer r5 = new java.lang.Integer     // Catch:{ all -> 0x00e9 }
            r12 = r25
            r5.<init>(r12)     // Catch:{ all -> 0x00e9 }
            r9 = 4
            r2[r9] = r5     // Catch:{ all -> 0x00e9 }
            com.meizu.savior.ChangeQuickRedirect r5 = f12228a     // Catch:{ all -> 0x00e9 }
            r10 = 0
            r11 = 6242(0x1862, float:8.747E-42)
            java.lang.Class[] r1 = new java.lang.Class[r1]     // Catch:{ all -> 0x00e9 }
            java.lang.Class<byte[]> r16 = byte[].class
            r1[r3] = r16     // Catch:{ all -> 0x00e9 }
            java.lang.Class<byte[]> r3 = byte[].class
            r1[r4] = r3     // Catch:{ all -> 0x00e9 }
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00e9 }
            r1[r6] = r3     // Catch:{ all -> 0x00e9 }
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00e9 }
            r1[r7] = r3     // Catch:{ all -> 0x00e9 }
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00e9 }
            r1[r9] = r3     // Catch:{ all -> 0x00e9 }
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00e9 }
            r6 = r1
            r1 = r2
            r2 = r20
            r3 = r5
            r4 = r10
            r5 = r11
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00e9 }
            boolean r2 = r1.isSupported     // Catch:{ all -> 0x00e9 }
            if (r2 == 0) goto L_0x0064
            java.lang.Object r0 = r1.result     // Catch:{ all -> 0x00e9 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x00e9 }
            int r0 = r0.intValue()     // Catch:{ all -> 0x00e9 }
            monitor-exit(r20)
            return r0
        L_0x0064:
            java.lang.String r1 = "previewData"
            kotlin.jvm.p108b.C3443i.m21155b(r0, r1)     // Catch:{ all -> 0x00e9 }
            java.lang.String r1 = "previewData2"
            kotlin.jvm.p108b.C3443i.m21155b(r13, r1)     // Catch:{ all -> 0x00e9 }
            r1 = -1
            long r2 = r8.f12244p     // Catch:{ all -> 0x00e9 }
            long r4 = r8.f12245q     // Catch:{ all -> 0x00e9 }
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x00e7
            com.meizu.media.camera.portrait.DualcamMeta r1 = r8.f12243o     // Catch:{ all -> 0x00e9 }
            if (r1 != 0) goto L_0x007e
            kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x00e9 }
        L_0x007e:
            com.meizu.media.camera.portrait.CameraImageParam r2 = r1.getCamParam()     // Catch:{ all -> 0x00e9 }
            com.meizu.media.camera.portrait.DualcamMeta r1 = r8.f12243o     // Catch:{ all -> 0x00e9 }
            if (r1 != 0) goto L_0x0089
            kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x00e9 }
        L_0x0089:
            com.meizu.media.camera.portrait.BokehFace r3 = r1.getFace()     // Catch:{ all -> 0x00e9 }
            com.meizu.media.camera.portrait.FocusPoint r4 = new com.meizu.media.camera.portrait.FocusPoint     // Catch:{ all -> 0x00e9 }
            com.meizu.media.camera.portrait.DualcamMeta r1 = r8.f12243o     // Catch:{ all -> 0x00e9 }
            if (r1 != 0) goto L_0x0096
            kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x00e9 }
        L_0x0096:
            android.graphics.Point r1 = r1.getFocusPoint()     // Catch:{ all -> 0x00e9 }
            int r1 = r1.x     // Catch:{ all -> 0x00e9 }
            com.meizu.media.camera.portrait.DualcamMeta r5 = r8.f12243o     // Catch:{ all -> 0x00e9 }
            if (r5 != 0) goto L_0x00a3
            kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x00e9 }
        L_0x00a3:
            android.graphics.Point r5 = r5.getFocusPoint()     // Catch:{ all -> 0x00e9 }
            int r5 = r5.y     // Catch:{ all -> 0x00e9 }
            r4.<init>(r1, r5)     // Catch:{ all -> 0x00e9 }
            r5 = 100
            com.meizu.media.camera.portrait.DualcamMeta r1 = r8.f12243o     // Catch:{ all -> 0x00e9 }
            if (r1 != 0) goto L_0x00b5
            kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x00e9 }
        L_0x00b5:
            int r6 = r1.getI32DeviceRoll()     // Catch:{ all -> 0x00e9 }
            com.meizu.media.camera.portrait.DualcamMeta r1 = r8.f12243o     // Catch:{ all -> 0x00e9 }
            if (r1 != 0) goto L_0x00c0
            kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x00e9 }
        L_0x00c0:
            boolean r7 = r1.getAf()     // Catch:{ all -> 0x00e9 }
            r1 = r20
            r1.mo21457a(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00e9 }
            com.meizu.media.camera.stereobokeh.TofBokehUtil r9 = com.meizu.media.camera.stereobokeh.TofBokehUtil.f12194a     // Catch:{ all -> 0x00e9 }
            long r10 = r8.f12244p     // Catch:{ all -> 0x00e9 }
            int r1 = r8.f12237i     // Catch:{ all -> 0x00e9 }
            int r2 = r8.f12238j     // Catch:{ all -> 0x00e9 }
            int r3 = r8.f12239k     // Catch:{ all -> 0x00e9 }
            r12 = r21
            r13 = r22
            r14 = r23
            r15 = r24
            r16 = r25
            r17 = r1
            r18 = r2
            r19 = r3
            int r1 = r9.previewProcess(r10, r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ all -> 0x00e9 }
        L_0x00e7:
            monitor-exit(r20)
            return r1
        L_0x00e9:
            r0 = move-exception
            monitor-exit(r20)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.stereobokeh.TofBokehMgr.mo21458a(byte[], byte[], int, int, int):int");
    }

    /* renamed from: a */
    public final int mo21457a(@Nullable CameraImageParam cameraImageParam, @Nullable BokehFace bokehFace, @NotNull FocusPoint focusPoint, int i, int i2, boolean z) {
        FocusPoint focusPoint2 = focusPoint;
        Object[] objArr = {cameraImageParam, bokehFace, focusPoint2, new Integer(i), new Integer(i2), new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f12228a;
        Class[] clsArr = {CameraImageParam.class, BokehFace.class, FocusPoint.class, Integer.TYPE, Integer.TYPE, Boolean.TYPE};
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6244, clsArr, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        C3443i.m21155b(focusPoint2, "point");
        if (this.f12244p == this.f12245q) {
            return -1;
        }
        TofBokehUtil tofBokehUtil = TofBokehUtil.f12194a;
        long j = this.f12244p;
        if (cameraImageParam == null) {
            C3443i.m21151a();
        }
        if (bokehFace == null) {
            C3443i.m21151a();
        }
        return tofBokehUtil.setMetaData(j, cameraImageParam, bokehFace, focusPoint, i, i2, z);
    }

    /* renamed from: a */
    public int mo19548a(@NotNull byte[] bArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bArr}, this, f12228a, false, 6245, new Class[]{byte[].class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        C3443i.m21155b(bArr, "calidata");
        int i = -1;
        LogUtil.C2630a aVar = f12230x;
        LogUtil.m15952c(aVar, "setCaliData mHEngine : " + this.f12244p);
        synchronized (this.f12241m) {
            if (this.f12244p == this.f12245q) {
                this.f12244p = TofBokehUtil.f12194a.initPreview();
                LogUtil.C2630a aVar2 = f12230x;
                LogUtil.m15952c(aVar2, "init mHEngine : " + this.f12244p);
            }
            if (this.f12244p != this.f12245q) {
                LogUtil.C2630a aVar3 = f12230x;
                LogUtil.m15952c(aVar3, "setCaliData: " + bArr.length);
                i = TofBokehUtil.f12194a.setCaliData(this.f12244p, bArr);
            }
            Unit tVar = Unit.f18749a;
        }
        return i;
    }

    /* renamed from: a */
    public int mo19547a(@NotNull DualcamMeta dualcamMeta) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{dualcamMeta}, this, f12228a, false, 6246, new Class[]{DualcamMeta.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        C3443i.m21155b(dualcamMeta, "dualcamMeta");
        synchronized (this.f12241m) {
            this.f12243o = dualcamMeta;
            Unit tVar = Unit.f18749a;
        }
        return 0;
    }

    /* renamed from: c */
    public final void mo21463c() {
        if (!PatchProxy.proxy(new Object[0], this, f12228a, false, 6247, new Class[0], Void.TYPE).isSupported) {
            byte[] bArr = null;
            this.f12231c = bArr;
            this.f12232d = bArr;
            if (this.f12244p != this.f12245q) {
                TofBokehUtil.f12194a.uninitPreview(this.f12244p);
                this.f12244p = -1;
            }
            CameraController.m8868g().mo19468a((CameraController.C1875b) null);
            if (this.f12251w != null) {
                TofDataCache dVar = this.f12251w;
                if (dVar == null) {
                    C3443i.m21151a();
                }
                dVar.mo21466a();
            }
        }
    }

    /* renamed from: d */
    public final void mo21464d() {
        if (!PatchProxy.proxy(new Object[0], this, f12228a, false, 6248, new Class[0], Void.TYPE).isSupported) {
            byte[] bArr = null;
            this.f12231c = bArr;
            this.f12232d = bArr;
            if (this.f12244p != this.f12245q) {
                TofBokehUtil.f12194a.uninitPreview(this.f12244p);
                this.f12244p = -1;
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo27294d2 = {"Lcom/meizu/media/camera/stereobokeh/TofBokehMgr$Companion;", "", "()V", "TAG", "Lcom/meizu/media/camera/util/LogUtil$Tag;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.stereobokeh.c$a */
    /* compiled from: TofBokehMgr.kt */
    public static final class C2372a {
        private C2372a() {
        }

        public /* synthetic */ C2372a(DefaultConstructorMarker gVar) {
            this();
        }
    }

    /* renamed from: a */
    public void mo19549a(long j) {
        Object[] objArr = {new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f12228a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6249, new Class[]{Long.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f12230x;
            LogUtil.m15952c(aVar, "setMainCaptureTimestamp：" + j + ' ');
            this.f12249u = j;
            TofDataCache dVar = this.f12251w;
            if (dVar == null) {
                C3443i.m21151a();
            }
            dVar.mo21468b();
            TofDataCache dVar2 = this.f12251w;
            if (dVar2 == null) {
                C3443i.m21151a();
            }
            TofDataCache.C2375b a = dVar2.mo21465a(this.f12249u);
            if (a == null) {
                C3443i.m21151a();
            }
            this.f12233e = a.mo21470b();
            LogUtil.C2630a aVar2 = f12230x;
            StringBuilder sb = new StringBuilder();
            sb.append("getcaptureTofData:");
            byte[] bArr = this.f12233e;
            if (bArr == null) {
                C3443i.m21151a();
            }
            sb.append(bArr.length);
            sb.append("timestamp ");
            TofDataCache dVar3 = this.f12251w;
            if (dVar3 == null) {
                C3443i.m21151a();
            }
            TofDataCache.C2375b a2 = dVar3.mo21465a(this.f12249u);
            if (a2 == null) {
                C3443i.m21151a();
            }
            sb.append(a2.mo21469a());
            LogUtil.m15952c(aVar2, sb.toString());
            CameraController.m8868g().mo19478a(this.f12233e);
        }
    }

    /* renamed from: b */
    public void mo19550b(long j) {
        this.f12247s = j;
    }

    /* renamed from: a */
    public int mo19546a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12228a, false, 6250, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        CameraModeListener hVar = this.f12240l;
        if (hVar == null) {
            C3443i.m21151a();
        }
        return hVar.mo18198dV();
    }
}
