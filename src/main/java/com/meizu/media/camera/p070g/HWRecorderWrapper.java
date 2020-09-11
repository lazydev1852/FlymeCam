package com.meizu.media.camera.p070g;

import android.view.Surface;
import com.meizu.media.camera.MzCamcorderProfileManager;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\r\u0018\u0000 /2\u00020\u0001:\u0002/0B\u0005¢\u0006\u0002\u0010\u0002JH\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u000e\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020$J\u0010\u0010'\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010$J\u0006\u0010)\u001a\u00020\"J\u0010\u0010*\u001a\u00020\"2\b\u0010+\u001a\u0004\u0018\u00010\nJ\u0006\u0010,\u001a\u00020\"J\u000e\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u00061"}, mo27294d2 = {"Lcom/meizu/media/camera/mediacodec/HWRecorderWrapper;", "", "()V", "mAExecutor", "Ljava/util/concurrent/ExecutorService;", "mRecordPause", "", "mRecorder", "Lcom/meizu/media/camera/mediacodec/HWRecorder;", "mSavedCallback", "Lcom/meizu/media/camera/mediacodec/HWRecorderWrapper$VideoSavedCallback;", "mSurface", "Landroid/view/Surface;", "getMSurface", "()Landroid/view/Surface;", "mVExecutor", "mVideoPath", "", "videoStartTime", "", "getVideoStartTime", "()J", "init", "width", "", "height", "imageFormat", "sampleRate", "channels", "dstFilePath", "needSurface", "profile", "Lcom/meizu/media/camera/MzCamcorderProfileManager;", "nv21ToYuv420sp", "", "data", "", "recordImage", "image", "recordSample", "sample", "recordSurface", "setVideoSavedCallback", "callback", "stop", "updateRecordPauseStatus", "pause", "Companion", "VideoSavedCallback", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.g.c */
public final class HWRecorderWrapper {

    /* renamed from: a */
    public static ChangeQuickRedirect f10166a = null;

    /* renamed from: b */
    public static final C2082a f10167b = new C2082a((DefaultConstructorMarker) null);

    /* renamed from: h */
    private static final LogUtil.C2630a f10168h = new LogUtil.C2630a("HWRecordWrapper");
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static final long f10169i = f10169i;

    /* renamed from: j */
    private static final Object f10170j = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ExecutorService f10171c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ExecutorService f10172d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C2083b f10173e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f10174f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final HWRecorder f10175g = new HWRecorder();

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, mo27294d2 = {"Lcom/meizu/media/camera/mediacodec/HWRecorderWrapper$VideoSavedCallback;", "", "onVideoSaved", "", "path", "", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.g.c$b */
    /* compiled from: HWRecorderWrapper.kt */
    public interface C2083b {
        /* renamed from: a */
        void mo20142a(@Nullable String str);
    }

    /* renamed from: a */
    public final long mo20133a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10166a, false, 4486, new Class[0], Long.TYPE);
        return proxy.isSupported ? ((Long) proxy.result).longValue() : this.f10175g.mo20121a();
    }

    @Nullable
    /* renamed from: b */
    public final Surface mo20138b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10166a, false, 4487, new Class[0], Surface.class);
        return proxy.isSupported ? (Surface) proxy.result : this.f10175g.mo20125b();
    }

    /* renamed from: a */
    public final boolean mo20137a(int i, int i2, int i3, int i4, int i5, @NotNull String str, boolean z, @Nullable MzCamcorderProfileManager mVar) {
        int i6;
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        String str2 = str;
        MzCamcorderProfileManager mVar2 = mVar;
        Object[] objArr = {new Integer(i7), new Integer(i8), new Integer(i9), new Integer(i4), new Integer(i5), str2, new Byte(z ? (byte) 1 : 0), mVar2};
        ChangeQuickRedirect changeQuickRedirect = f10166a;
        Class[] clsArr = {Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, String.class, Boolean.TYPE, MzCamcorderProfileManager.class};
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4488, clsArr, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        C3443i.m21155b(str2, "dstFilePath");
        LogUtil.C2630a aVar = f10168h;
        LogUtil.m15952c(aVar, " init: " + i7 + "x" + i8 + "profile: " + mVar2);
        if (i9 == 17) {
            i6 = 21;
        } else if (i9 == 842094169) {
            i6 = 19;
        } else if (i9 != 42) {
            return false;
        } else {
            i6 = 2130708361;
        }
        this.f10174f = str2;
        try {
            this.f10175g.mo20122a(i, i2, i6, i4, i5, str, z, mVar);
            this.f10171c = Executors.newSingleThreadExecutor();
            this.f10172d = Executors.newSingleThreadExecutor();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public final void mo20134a(@Nullable C2083b bVar) {
        this.f10173e = bVar;
    }

    /* renamed from: a */
    public final void mo20136a(@NotNull byte[] bArr) {
        if (!PatchProxy.proxy(new Object[]{bArr}, this, f10166a, false, 4489, new Class[]{byte[].class}, Void.TYPE).isSupported) {
            C3443i.m21155b(bArr, "image");
            ExecutorService executorService = this.f10171c;
            if (executorService == null) {
                C3443i.m21151a();
            }
            if (executorService.isShutdown()) {
                LogUtil.m15956e(f10168h, "video record thread has been shut down");
                return;
            }
            ExecutorService executorService2 = this.f10171c;
            if (executorService2 == null) {
                C3443i.m21151a();
            }
            executorService2.execute(new C2084c(this, bArr));
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo27294d2 = {"<anonymous>", "", "run"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.g.c$c */
    /* compiled from: HWRecorderWrapper.kt */
    static final class C2084c implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f10176a;

        /* renamed from: b */
        final /* synthetic */ HWRecorderWrapper f10177b;

        /* renamed from: c */
        final /* synthetic */ byte[] f10178c;

        C2084c(HWRecorderWrapper cVar, byte[] bArr) {
            this.f10177b = cVar;
            this.f10178c = bArr;
        }

        public final void run() {
            if (!PatchProxy.proxy(new Object[0], this, f10176a, false, 4494, new Class[0], Void.TYPE).isSupported) {
                try {
                    this.f10177b.m10434c(this.f10178c);
                    this.f10177b.f10175g.mo20124a(this.f10178c);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: c */
    public final void mo20140c() {
        if (!PatchProxy.proxy(new Object[0], this, f10166a, false, 4490, new Class[0], Void.TYPE).isSupported) {
            ExecutorService executorService = this.f10171c;
            if (executorService == null) {
                C3443i.m21151a();
            }
            if (executorService.isShutdown()) {
                LogUtil.m15956e(f10168h, "video record thread has been shut down");
                return;
            }
            ExecutorService executorService2 = this.f10171c;
            if (executorService2 == null) {
                C3443i.m21151a();
            }
            executorService2.execute(new C2086e(this));
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo27294d2 = {"<anonymous>", "", "run"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.g.c$e */
    /* compiled from: HWRecorderWrapper.kt */
    static final class C2086e implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f10182a;

        /* renamed from: b */
        final /* synthetic */ HWRecorderWrapper f10183b;

        C2086e(HWRecorderWrapper cVar) {
            this.f10183b = cVar;
        }

        public final void run() {
            if (!PatchProxy.proxy(new Object[0], this, f10182a, false, 4496, new Class[0], Void.TYPE).isSupported) {
                try {
                    this.f10183b.f10175g.mo20127c();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m10434c(byte[] bArr) {
        for (int length = (bArr.length * 2) / 3; length < bArr.length - 1; length += 2) {
            byte b = bArr[length];
            int i = length + 1;
            bArr[length] = bArr[i];
            bArr[i] = b;
        }
    }

    /* renamed from: b */
    public final void mo20139b(@Nullable byte[] bArr) {
        if (!PatchProxy.proxy(new Object[]{bArr}, this, f10166a, false, 4491, new Class[]{byte[].class}, Void.TYPE).isSupported) {
            ExecutorService executorService = this.f10172d;
            if (executorService == null) {
                C3443i.m21151a();
            }
            if (executorService.isShutdown()) {
                LogUtil.m15956e(f10168h, "audio record thread has been shut down");
                return;
            }
            ExecutorService executorService2 = this.f10172d;
            if (executorService2 == null) {
                C3443i.m21151a();
            }
            executorService2.execute(new C2085d(this, bArr));
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo27294d2 = {"<anonymous>", "", "run"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.g.c$d */
    /* compiled from: HWRecorderWrapper.kt */
    static final class C2085d implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f10179a;

        /* renamed from: b */
        final /* synthetic */ HWRecorderWrapper f10180b;

        /* renamed from: c */
        final /* synthetic */ byte[] f10181c;

        C2085d(HWRecorderWrapper cVar, byte[] bArr) {
            this.f10180b = cVar;
            this.f10181c = bArr;
        }

        public final void run() {
            if (!PatchProxy.proxy(new Object[0], this, f10179a, false, 4495, new Class[0], Void.TYPE).isSupported) {
                try {
                    this.f10180b.f10175g.mo20126b(this.f10181c);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo20135a(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f10166a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4492, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f10175g.mo20123a(z);
        }
    }

    /* renamed from: d */
    public final void mo20141d() {
        if (!PatchProxy.proxy(new Object[0], this, f10166a, false, 4493, new Class[0], Void.TYPE).isSupported) {
            Executors.newSingleThreadExecutor().execute(new C2087f(this));
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo27294d2 = {"<anonymous>", "", "run"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.g.c$f */
    /* compiled from: HWRecorderWrapper.kt */
    static final class C2087f implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f10184a;

        /* renamed from: b */
        final /* synthetic */ HWRecorderWrapper f10185b;

        C2087f(HWRecorderWrapper cVar) {
            this.f10185b = cVar;
        }

        public final void run() {
            if (!PatchProxy.proxy(new Object[0], this, f10184a, false, 4497, new Class[0], Void.TYPE).isSupported) {
                try {
                    ExecutorService b = this.f10185b.f10171c;
                    if (b == null) {
                        C3443i.m21151a();
                    }
                    b.shutdown();
                    ExecutorService b2 = this.f10185b.f10171c;
                    if (b2 == null) {
                        C3443i.m21151a();
                    }
                    b2.awaitTermination(HWRecorderWrapper.f10169i, TimeUnit.MILLISECONDS);
                    ExecutorService c = this.f10185b.f10172d;
                    if (c == null) {
                        C3443i.m21151a();
                    }
                    c.shutdown();
                    ExecutorService c2 = this.f10185b.f10172d;
                    if (c2 == null) {
                        C3443i.m21151a();
                    }
                    c2.awaitTermination(HWRecorderWrapper.f10169i, TimeUnit.MICROSECONDS);
                    this.f10185b.f10175g.mo20128d();
                    if (this.f10185b.f10173e != null) {
                        C2083b d = this.f10185b.f10173e;
                        if (d == null) {
                            C3443i.m21151a();
                        }
                        d.mo20142a(this.f10185b.f10174f);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo27294d2 = {"Lcom/meizu/media/camera/mediacodec/HWRecorderWrapper$Companion;", "", "()V", "MAX_TIMEOUT", "", "TAG", "Lcom/meizu/media/camera/util/LogUtil$Tag;", "sLock", "Ljava/lang/Object;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.g.c$a */
    /* compiled from: HWRecorderWrapper.kt */
    public static final class C2082a {
        private C2082a() {
        }

        public /* synthetic */ C2082a(DefaultConstructorMarker gVar) {
            this();
        }
    }
}
