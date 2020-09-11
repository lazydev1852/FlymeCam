package com.meizu.media.camera.stereobokeh;

import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\t\u001a\b\u0018\u00010\u0007R\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\rR\u0018\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0007R\u00020\u00000\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo27294d2 = {"Lcom/meizu/media/camera/stereobokeh/TofDataCache;", "", "mCacheSize", "", "(I)V", "mCache", "Ljava/util/ArrayDeque;", "Lcom/meizu/media/camera/stereobokeh/TofDataCache$TofData;", "mSyncObject", "getTofData", "timestamp", "", "printlog", "", "put", "data", "", "release", "Companion", "TofData", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.stereobokeh.d */
public final class TofDataCache {

    /* renamed from: a */
    public static ChangeQuickRedirect f12252a;

    /* renamed from: b */
    public static final C2374a f12253b = new C2374a((DefaultConstructorMarker) null);

    /* renamed from: f */
    private static final LogUtil.C2630a f12254f = new LogUtil.C2630a("TofDataCache");

    /* renamed from: c */
    private final ArrayDeque<C2375b> f12255c = new ArrayDeque<>();

    /* renamed from: d */
    private final Object f12256d = new Object();

    /* renamed from: e */
    private final int f12257e;

    public TofDataCache(int i) {
        this.f12257e = i;
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\n\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, mo27294d2 = {"Lcom/meizu/media/camera/stereobokeh/TofDataCache$TofData;", "", "mTimestamp", "", "mData", "", "(Lcom/meizu/media/camera/stereobokeh/TofDataCache;J[B)V", "getMData", "()[B", "setMData", "([B)V", "getMTimestamp", "()J", "setMTimestamp", "(J)V", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.stereobokeh.d$b */
    /* compiled from: TofDataCache.kt */
    public final class C2375b {

        /* renamed from: a */
        final /* synthetic */ TofDataCache f12258a;

        /* renamed from: b */
        private long f12259b;
        @NotNull

        /* renamed from: c */
        private byte[] f12260c;

        public C2375b(TofDataCache dVar, long j, @NotNull byte[] bArr) {
            C3443i.m21155b(bArr, "mData");
            this.f12258a = dVar;
            this.f12259b = j;
            this.f12260c = bArr;
        }

        /* renamed from: a */
        public final long mo21469a() {
            return this.f12259b;
        }

        @NotNull
        /* renamed from: b */
        public final byte[] mo21470b() {
            return this.f12260c;
        }
    }

    /* renamed from: a */
    public final void mo21467a(long j, @NotNull byte[] bArr) {
        Object[] objArr = {new Long(j), bArr};
        ChangeQuickRedirect changeQuickRedirect = f12252a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6251, new Class[]{Long.TYPE, byte[].class}, Void.TYPE).isSupported) {
            C3443i.m21155b(bArr, "data");
            synchronized (this.f12256d) {
                C2375b bVar = new C2375b(this, j, bArr);
                if (this.f12255c.size() < this.f12257e) {
                    this.f12255c.offer(bVar);
                } else {
                    this.f12255c.poll();
                    this.f12255c.offer(bVar);
                }
            }
        }
    }

    @Nullable
    /* renamed from: a */
    public final C2375b mo21465a(long j) {
        C2375b bVar;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Long(j)}, this, f12252a, false, 6252, new Class[]{Long.TYPE}, C2375b.class);
        if (proxy.isSupported) {
            return (C2375b) proxy.result;
        }
        synchronized (this.f12256d) {
            long j2 = Long.MAX_VALUE;
            bVar = null;
            Iterator<C2375b> it = this.f12255c.iterator();
            while (it.hasNext()) {
                C2375b next = it.next();
                if (Math.abs(next.mo21469a() - j) < j2) {
                    j2 = Math.abs(next.mo21469a() - j);
                    bVar = next;
                }
            }
        }
        return bVar;
    }

    /* renamed from: a */
    public final void mo21466a() {
        if (!PatchProxy.proxy(new Object[0], this, f12252a, false, 6253, new Class[0], Void.TYPE).isSupported) {
            synchronized (this.f12256d) {
                this.f12255c.clear();
                Unit tVar = Unit.f18749a;
            }
        }
    }

    /* renamed from: b */
    public final void mo21468b() {
        if (!PatchProxy.proxy(new Object[0], this, f12252a, false, 6254, new Class[0], Void.TYPE).isSupported) {
            Iterator<C2375b> it = this.f12255c.iterator();
            while (it.hasNext()) {
                LogUtil.C2630a aVar = f12254f;
                LogUtil.m15952c(aVar, "buffer mTimestamp:" + it.next().mo21469a());
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo27294d2 = {"Lcom/meizu/media/camera/stereobokeh/TofDataCache$Companion;", "", "()V", "TAG", "Lcom/meizu/media/camera/util/LogUtil$Tag;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.stereobokeh.d$a */
    /* compiled from: TofDataCache.kt */
    public static final class C2374a {
        private C2374a() {
        }

        public /* synthetic */ C2374a(DefaultConstructorMarker gVar) {
            this();
        }
    }
}
