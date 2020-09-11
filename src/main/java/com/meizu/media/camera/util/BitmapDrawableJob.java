package com.meizu.media.camera.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.ParcelFileDescriptor;
import androidx.collection.LruCache;
import com.meizu.media.camera.util.ThreadPool;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.Closeable;

/* renamed from: com.meizu.media.camera.util.e */
public class BitmapDrawableJob implements ThreadPool.C2637b<Drawable> {

    /* renamed from: a */
    public static ChangeQuickRedirect f14219a;

    /* renamed from: k */
    private static LruCache<String, Bitmap> f14220k = new LruCache<>(64);

    /* renamed from: b */
    protected final Context f14221b;

    /* renamed from: c */
    protected final int f14222c;

    /* renamed from: d */
    protected final int f14223d;

    /* renamed from: e */
    protected final int f14224e;

    /* renamed from: f */
    protected final int f14225f;

    /* renamed from: g */
    protected String f14226g;

    /* renamed from: h */
    protected ParcelFileDescriptor f14227h;

    /* renamed from: i */
    protected String f14228i = null;

    /* renamed from: j */
    protected int f14229j = -1;

    /* renamed from: l */
    private int f14230l = 0;

    public BitmapDrawableJob(Context context, String str, int i, int i2, int i3, int i4, String str2, int i5) {
        this.f14221b = context;
        this.f14226g = str;
        this.f14222c = i;
        this.f14223d = i2;
        this.f14224e = i3;
        this.f14225f = i4;
        this.f14228i = str2;
        this.f14229j = i5;
    }

    /* renamed from: a */
    public Drawable mo22655b(ThreadPool.C2638c cVar) {
        Bitmap a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{cVar}, this, f14219a, false, 7767, new Class[]{ThreadPool.C2638c.class}, Drawable.class);
        if (proxy.isSupported) {
            return (Drawable) proxy.result;
        }
        if (this.f14226g == null || this.f14226g.length() <= 0) {
            return null;
        }
        try {
            if (this.f14225f == 0 && (a = m16128a()) != null) {
                return new BitmapDrawable(this.f14221b.getResources(), a);
            }
            if (!m16133e(cVar)) {
                m16130b();
                return null;
            }
            Bitmap a2 = BitmapUtils.m16143a(cVar, this.f14227h.getFileDescriptor(), this.f14222c, this.f14223d, this.f14224e, this.f14225f, this.f14229j);
            if (!cVar.mo22682b()) {
                if (a2 != null) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f14221b.getResources(), a2);
                    if (this.f14225f == 0) {
                        m16129a(a2);
                    }
                    m16130b();
                    return bitmapDrawable;
                }
            }
            m16130b();
            return null;
        } finally {
            m16130b();
        }
    }

    /* renamed from: a */
    private Bitmap m16128a() {
        Bitmap bitmap;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f14219a, false, 7768, new Class[0], Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        synchronized (f14220k) {
            bitmap = f14220k.get(this.f14226g);
        }
        return bitmap;
    }

    /* renamed from: a */
    private void m16129a(Bitmap bitmap) {
        if (!PatchProxy.proxy(new Object[]{bitmap}, this, f14219a, false, 7769, new Class[]{Bitmap.class}, Void.TYPE).isSupported) {
            synchronized (f14220k) {
                if (f14220k.get(this.f14226g) == null) {
                    f14220k.put(this.f14226g, bitmap);
                }
            }
        }
    }

    /* renamed from: c */
    private void m16131c(ThreadPool.C2638c cVar) {
        if (!PatchProxy.proxy(new Object[]{cVar}, this, f14219a, false, 7770, new Class[]{ThreadPool.C2638c.class}, Void.TYPE).isSupported) {
            int d = m16132d(cVar);
            synchronized (this) {
                this.f14230l = d;
                if (!(this.f14230l == 2 || this.f14227h == null)) {
                    C2644av.m16096a((Closeable) this.f14227h);
                    this.f14227h = null;
                }
                notifyAll();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b4 A[Catch:{ Throwable -> 0x00a1, all -> 0x009e, Throwable -> 0x00f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00bb A[Catch:{ Throwable -> 0x00a1, all -> 0x009e, Throwable -> 0x00f1 }] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m16132d(com.meizu.media.camera.util.ThreadPool.C2638c r10) {
        /*
            r9 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r10
            com.meizu.savior.ChangeQuickRedirect r3 = f14219a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<com.meizu.media.camera.util.aq$c> r0 = com.meizu.media.camera.util.ThreadPool.C2638c.class
            r6[r8] = r0
            java.lang.Class r7 = java.lang.Integer.TYPE
            r4 = 0
            r5 = 7771(0x1e5b, float:1.089E-41)
            r2 = r9
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r0.isSupported
            if (r1 == 0) goto L_0x0025
            java.lang.Object r10 = r0.result
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            return r10
        L_0x0025:
            r0 = -1
            java.lang.String r1 = r9.f14226g     // Catch:{ Throwable -> 0x00f1 }
            java.lang.String r2 = "http"
            boolean r1 = r1.startsWith(r2)     // Catch:{ Throwable -> 0x00f1 }
            r2 = 2
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            if (r1 == 0) goto L_0x00c8
            java.net.URL r1 = new java.net.URL     // Catch:{ Throwable -> 0x00f1 }
            java.lang.String r4 = r9.f14226g     // Catch:{ Throwable -> 0x00f1 }
            r1.<init>(r4)     // Catch:{ Throwable -> 0x00f1 }
            com.meizu.media.camera.util.p r4 = com.meizu.media.camera.util.DownloadCache.m16211a()     // Catch:{ Throwable -> 0x00f1 }
            com.meizu.media.camera.util.p$c r4 = r4.mo22735a((com.meizu.media.camera.util.ThreadPool.C2638c) r10, (java.net.URL) r1)     // Catch:{ Throwable -> 0x00f1 }
            boolean r5 = r10.mo22682b()     // Catch:{ Throwable -> 0x00f1 }
            if (r5 == 0) goto L_0x0049
            return r8
        L_0x0049:
            if (r4 != 0) goto L_0x0062
            java.lang.String r10 = "BitmapDrawableJob"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00f1 }
            r2.<init>()     // Catch:{ Throwable -> 0x00f1 }
            java.lang.String r3 = "download failed "
            r2.append(r3)     // Catch:{ Throwable -> 0x00f1 }
            r2.append(r1)     // Catch:{ Throwable -> 0x00f1 }
            java.lang.String r1 = r2.toString()     // Catch:{ Throwable -> 0x00f1 }
            android.util.Log.w(r10, r1)     // Catch:{ Throwable -> 0x00f1 }
            return r0
        L_0x0062:
            java.lang.String r1 = r9.f14228i     // Catch:{ Throwable -> 0x00f1 }
            if (r1 == 0) goto L_0x00bf
            java.io.File r1 = new java.io.File     // Catch:{ Throwable -> 0x00f1 }
            java.lang.String r5 = r9.f14228i     // Catch:{ Throwable -> 0x00f1 }
            r1.<init>(r5)     // Catch:{ Throwable -> 0x00f1 }
            boolean r5 = r1.exists()     // Catch:{ Throwable -> 0x00f1 }
            if (r5 != 0) goto L_0x00b1
            java.io.File r6 = r1.getParentFile()     // Catch:{ Throwable -> 0x00f1 }
            boolean r7 = r6.exists()     // Catch:{ Throwable -> 0x00f1 }
            if (r7 != 0) goto L_0x0083
            boolean r6 = r6.mkdirs()     // Catch:{ Throwable -> 0x00f1 }
            if (r6 == 0) goto L_0x00b1
        L_0x0083:
            r1.createNewFile()     // Catch:{ Throwable -> 0x00f1 }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ Throwable -> 0x00f1 }
            r6.<init>(r1)     // Catch:{ Throwable -> 0x00f1 }
            r7 = 0
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x00ab, all -> 0x00a3 }
            java.io.File r4 = r4.f14303a     // Catch:{ Throwable -> 0x00ab, all -> 0x00a3 }
            r8.<init>(r4)     // Catch:{ Throwable -> 0x00ab, all -> 0x00a3 }
            boolean r10 = com.meizu.media.camera.util.DownloadUtils.m16242a(r10, r8, r6)     // Catch:{ Throwable -> 0x00a1, all -> 0x009e }
            com.meizu.media.camera.util.C2644av.m16096a((java.io.Closeable) r8)     // Catch:{ Throwable -> 0x00f1 }
            com.meizu.media.camera.util.C2644av.m16096a((java.io.Closeable) r6)     // Catch:{ Throwable -> 0x00f1 }
            goto L_0x00b2
        L_0x009e:
            r10 = move-exception
            r7 = r8
            goto L_0x00a4
        L_0x00a1:
            r7 = r8
            goto L_0x00ab
        L_0x00a3:
            r10 = move-exception
        L_0x00a4:
            com.meizu.media.camera.util.C2644av.m16096a((java.io.Closeable) r7)     // Catch:{ Throwable -> 0x00f1 }
            com.meizu.media.camera.util.C2644av.m16096a((java.io.Closeable) r6)     // Catch:{ Throwable -> 0x00f1 }
            throw r10     // Catch:{ Throwable -> 0x00f1 }
        L_0x00ab:
            com.meizu.media.camera.util.C2644av.m16096a((java.io.Closeable) r7)     // Catch:{ Throwable -> 0x00f1 }
            com.meizu.media.camera.util.C2644av.m16096a((java.io.Closeable) r6)     // Catch:{ Throwable -> 0x00f1 }
        L_0x00b1:
            r10 = r5
        L_0x00b2:
            if (r10 == 0) goto L_0x00bb
            android.os.ParcelFileDescriptor r10 = android.os.ParcelFileDescriptor.open(r1, r3)     // Catch:{ Throwable -> 0x00f1 }
            r9.f14227h = r10     // Catch:{ Throwable -> 0x00f1 }
            return r2
        L_0x00bb:
            r1.delete()     // Catch:{ Throwable -> 0x00f1 }
            return r0
        L_0x00bf:
            java.io.File r10 = r4.f14303a     // Catch:{ Throwable -> 0x00f1 }
            android.os.ParcelFileDescriptor r10 = android.os.ParcelFileDescriptor.open(r10, r3)     // Catch:{ Throwable -> 0x00f1 }
            r9.f14227h = r10     // Catch:{ Throwable -> 0x00f1 }
            return r2
        L_0x00c8:
            java.io.File r10 = new java.io.File     // Catch:{ Throwable -> 0x00f1 }
            java.lang.String r1 = r9.f14226g     // Catch:{ Throwable -> 0x00f1 }
            r10.<init>(r1)     // Catch:{ Throwable -> 0x00f1 }
            boolean r1 = r10.exists()     // Catch:{ Throwable -> 0x00f1 }
            if (r1 == 0) goto L_0x00dc
            android.os.ParcelFileDescriptor r10 = android.os.ParcelFileDescriptor.open(r10, r3)     // Catch:{ Throwable -> 0x00f1 }
            r9.f14227h = r10     // Catch:{ Throwable -> 0x00f1 }
            goto L_0x00f0
        L_0x00dc:
            java.lang.String r10 = r9.f14226g     // Catch:{ Throwable -> 0x00f1 }
            android.net.Uri r10 = android.net.Uri.parse(r10)     // Catch:{ Throwable -> 0x00f1 }
            android.content.Context r1 = r9.f14221b     // Catch:{ Throwable -> 0x00f1 }
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ Throwable -> 0x00f1 }
            java.lang.String r3 = "r"
            android.os.ParcelFileDescriptor r10 = r1.openFileDescriptor(r10, r3)     // Catch:{ Throwable -> 0x00f1 }
            r9.f14227h = r10     // Catch:{ Throwable -> 0x00f1 }
        L_0x00f0:
            return r2
        L_0x00f1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.BitmapDrawableJob.m16132d(com.meizu.media.camera.util.aq$c):int");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:25|26|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        m16131c(r10);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0052 */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m16133e(com.meizu.media.camera.util.ThreadPool.C2638c r10) {
        /*
            r9 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r10
            com.meizu.savior.ChangeQuickRedirect r3 = f14219a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<com.meizu.media.camera.util.aq$c> r2 = com.meizu.media.camera.util.ThreadPool.C2638c.class
            r6[r8] = r2
            java.lang.Class r7 = java.lang.Boolean.TYPE
            r4 = 0
            r5 = 7772(0x1e5c, float:1.0891E-41)
            r2 = r9
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r2 = r1.isSupported
            if (r2 == 0) goto L_0x0025
            java.lang.Object r10 = r1.result
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            return r10
        L_0x0025:
            com.meizu.media.camera.util.e$1 r1 = new com.meizu.media.camera.util.e$1
            r1.<init>()
            r10.mo22680a((com.meizu.media.camera.util.ThreadPool.C2636a) r1)
        L_0x002d:
            monitor-enter(r9)
            boolean r1 = r10.mo22682b()     // Catch:{ all -> 0x0054 }
            if (r1 == 0) goto L_0x0036
            monitor-exit(r9)     // Catch:{ all -> 0x0054 }
            return r8
        L_0x0036:
            int r1 = r9.f14230l     // Catch:{ all -> 0x0054 }
            if (r1 != 0) goto L_0x0041
            r9.f14230l = r0     // Catch:{ all -> 0x0054 }
            monitor-exit(r9)     // Catch:{ all -> 0x0054 }
            r9.m16131c(r10)
            goto L_0x002d
        L_0x0041:
            int r1 = r9.f14230l     // Catch:{ all -> 0x0054 }
            r2 = -1
            if (r1 != r2) goto L_0x0048
            monitor-exit(r9)     // Catch:{ all -> 0x0054 }
            return r8
        L_0x0048:
            int r1 = r9.f14230l     // Catch:{ all -> 0x0054 }
            r2 = 2
            if (r1 != r2) goto L_0x004f
            monitor-exit(r9)     // Catch:{ all -> 0x0054 }
            return r0
        L_0x004f:
            r9.wait()     // Catch:{ InterruptedException -> 0x0052 }
        L_0x0052:
            monitor-exit(r9)     // Catch:{ all -> 0x0054 }
            goto L_0x002d
        L_0x0054:
            r10 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x0054 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.BitmapDrawableJob.m16133e(com.meizu.media.camera.util.aq$c):boolean");
    }

    /* renamed from: b */
    private void m16130b() {
        if (!PatchProxy.proxy(new Object[0], this, f14219a, false, 7773, new Class[0], Void.TYPE).isSupported && this.f14227h != null && (this.f14227h instanceof Closeable)) {
            C2644av.m16096a((Closeable) this.f14227h);
        }
    }

    public void finalize() throws Throwable {
        if (!PatchProxy.proxy(new Object[0], this, f14219a, false, 7774, new Class[0], Void.TYPE).isSupported) {
            try {
                m16130b();
            } finally {
                super.finalize();
            }
        }
    }
}
