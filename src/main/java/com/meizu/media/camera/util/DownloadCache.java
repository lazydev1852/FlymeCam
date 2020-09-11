package com.meizu.media.camera.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.meizu.media.camera.util.DownloadUtils;
import com.meizu.media.camera.util.ThreadPool;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.meizu.media.camera.util.p */
public class DownloadCache {

    /* renamed from: a */
    public static ChangeQuickRedirect f14271a;

    /* renamed from: b */
    private static final String[] f14272b = {"_id", "_data"};

    /* renamed from: c */
    private static final String f14273c = String.format("%s = ? AND %s = ?", new Object[]{"hash_code", "content_url"});

    /* renamed from: d */
    private static final String[] f14274d = {"_id", "_data", "content_url", "_size"};

    /* renamed from: e */
    private static final String f14275e = String.format("%s ASC", new Object[]{"last_access"});

    /* renamed from: f */
    private static final String[] f14276f = {String.format("sum(%s)", new Object[]{"_size"})};

    /* renamed from: g */
    private static DownloadCache f14277g = null;

    /* renamed from: h */
    private static Context f14278h;

    /* renamed from: i */
    private static String f14279i;

    /* renamed from: j */
    private static long f14280j;

    /* renamed from: k */
    private static DownloadUtils.C2656a f14281k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final LruCache<String, C2652c> f14282l = new LruCache<>(4);
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final HashMap<String, C2651b> f14283m = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final File f14284n;

    /* renamed from: o */
    private final SQLiteDatabase f14285o;

    /* renamed from: p */
    private final long f14286p;

    /* renamed from: q */
    private String f14287q = null;

    /* renamed from: r */
    private long f14288r = 0;

    /* renamed from: s */
    private boolean f14289s = false;

    /* renamed from: t */
    private int f14290t = 0;

    /* renamed from: u */
    private long[] f14291u = new long[50];

    /* renamed from: v */
    private long[] f14292v = new long[50];

    /* renamed from: w */
    private ContentValues f14293w = new ContentValues();

    /* renamed from: x */
    private String[] f14294x = new String[1];
    /* access modifiers changed from: private */

    /* renamed from: y */
    public DownloadUtils.C2656a f14295y = null;

    public DownloadCache(Context context, File file, long j) {
        this.f14284n = file;
        this.f14286p = j;
        this.f14285o = new C2650a(context).getWritableDatabase();
    }

    /* renamed from: a */
    public static void m16215a(Context context, String str, long j) {
        Object[] objArr = {context, str, new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f14271a;
        if (!PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect, true, 8024, new Class[]{Context.class, String.class, Long.TYPE}, Void.TYPE).isSupported) {
            m16216a(context, str, j, (DownloadUtils.C2656a) null);
        }
    }

    /* renamed from: a */
    public static void m16216a(Context context, String str, long j, DownloadUtils.C2656a aVar) {
        Object[] objArr = {context, str, new Long(j), aVar};
        ChangeQuickRedirect changeQuickRedirect = f14271a;
        if (!PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect, true, 8025, new Class[]{Context.class, String.class, Long.TYPE, DownloadUtils.C2656a.class}, Void.TYPE).isSupported && f14277g == null) {
            File file = new File(context.getExternalCacheDir(), str);
            if (!file.isDirectory()) {
                file.mkdirs();
            }
            f14277g = new DownloadCache(context, file, j);
            f14277g.f14295y = aVar;
        }
    }

    /* renamed from: a */
    public static DownloadCache m16211a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f14271a, true, 8026, new Class[0], DownloadCache.class);
        if (proxy.isSupported) {
            return (DownloadCache) proxy.result;
        }
        if (f14277g == null) {
            synchronized (DownloadCache.class) {
                m16216a(f14278h, f14279i, f14280j, f14281k);
                f14278h = null;
                f14279i = null;
                f14281k = null;
            }
        }
        return f14277g;
    }

    /* renamed from: b */
    public synchronized String mo22737b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f14271a, false, 8027, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (this.f14287q == null) {
            this.f14287q = DownloadEntry.f14314b.mo22747a();
        }
        return this.f14287q;
    }

    /* renamed from: a */
    public C2652c mo22736a(String str) {
        C2652c b;
        String str2 = str;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str2}, this, f14271a, false, 8028, new Class[]{String.class}, C2652c.class);
        if (proxy.isSupported) {
            return (C2652c) proxy.result;
        }
        Cursor query = this.f14285o.query(mo22737b(), f14272b, f14273c, new String[]{m16218b(str), str2}, (String) null, (String) null, (String) null);
        try {
            if (query.moveToNext()) {
                File file = new File(query.getString(1));
                if (file.exists()) {
                    long j = (long) query.getInt(0);
                    synchronized (this.f14282l) {
                        b = this.f14282l.mo22662b(str2);
                        if (b == null) {
                            b = new C2652c(j, file);
                            this.f14282l.mo22660a(str2, b);
                        }
                    }
                    query.close();
                    return b;
                }
            }
            query.close();
            return null;
        } catch (Throwable th) {
            query.close();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0052, code lost:
        r0 = new com.meizu.media.camera.util.DownloadCache.C2653d();
        r1 = r8.f14283m;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0059, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r2 = mo22736a(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005e, code lost:
        if (r2 == null) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0060, code lost:
        m16214a(r2.f14304b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0065, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0066, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0067, code lost:
        r2 = r8.f14283m.get(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006f, code lost:
        if (r2 != null) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0071, code lost:
        r2 = new com.meizu.media.camera.util.DownloadCache.C2651b(r8, r10);
        r8.f14283m.put(r10, r2);
        com.meizu.media.camera.util.DownloadCache.C2651b.m16230a(r2, com.meizu.media.camera.util.ThreadPool.m16011a().mo22678a(r2, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0086, code lost:
        r2.mo22742b(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0089, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008e, code lost:
        return r0.mo22743a(r9);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.meizu.media.camera.util.DownloadCache.C2652c mo22735a(com.meizu.media.camera.util.ThreadPool.C2638c r9, java.net.URL r10) {
        /*
            r8 = this;
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r2 = 0
            r1[r2] = r9
            r3 = 1
            r1[r3] = r10
            com.meizu.savior.ChangeQuickRedirect r4 = f14271a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<com.meizu.media.camera.util.aq$c> r0 = com.meizu.media.camera.util.ThreadPool.C2638c.class
            r6[r2] = r0
            java.lang.Class<java.net.URL> r0 = java.net.URL.class
            r6[r3] = r0
            java.lang.Class<com.meizu.media.camera.util.p$c> r7 = com.meizu.media.camera.util.DownloadCache.C2652c.class
            r0 = 0
            r5 = 8029(0x1f5d, float:1.1251E-41)
            r2 = r8
            r3 = r4
            r4 = r0
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r0.isSupported
            if (r1 == 0) goto L_0x002a
            java.lang.Object r9 = r0.result
            com.meizu.media.camera.util.p$c r9 = (com.meizu.media.camera.util.DownloadCache.C2652c) r9
            return r9
        L_0x002a:
            boolean r0 = r8.f14289s
            if (r0 != 0) goto L_0x0031
            r8.m16225d()
        L_0x0031:
            java.lang.String r10 = r10.toString()
            com.meizu.media.camera.util.ad<java.lang.String, com.meizu.media.camera.util.p$c> r0 = r8.f14282l
            monitor-enter(r0)
            com.meizu.media.camera.util.ad<java.lang.String, com.meizu.media.camera.util.p$c> r1 = r8.f14282l     // Catch:{ all -> 0x0092 }
            java.lang.Object r1 = r1.mo22662b(r10)     // Catch:{ all -> 0x0092 }
            com.meizu.media.camera.util.p$c r1 = (com.meizu.media.camera.util.DownloadCache.C2652c) r1     // Catch:{ all -> 0x0092 }
            if (r1 == 0) goto L_0x0051
            java.io.File r2 = r1.f14303a     // Catch:{ all -> 0x0092 }
            boolean r2 = r2.exists()     // Catch:{ all -> 0x0092 }
            if (r2 == 0) goto L_0x0051
            long r9 = r1.f14304b     // Catch:{ all -> 0x0092 }
            r8.m16214a((long) r9)     // Catch:{ all -> 0x0092 }
            monitor-exit(r0)     // Catch:{ all -> 0x0092 }
            return r1
        L_0x0051:
            monitor-exit(r0)     // Catch:{ all -> 0x0092 }
            com.meizu.media.camera.util.p$d r0 = new com.meizu.media.camera.util.p$d
            r0.<init>()
            java.util.HashMap<java.lang.String, com.meizu.media.camera.util.p$b> r1 = r8.f14283m
            monitor-enter(r1)
            com.meizu.media.camera.util.p$c r2 = r8.mo22736a((java.lang.String) r10)     // Catch:{ all -> 0x008f }
            if (r2 == 0) goto L_0x0067
            long r9 = r2.f14304b     // Catch:{ all -> 0x008f }
            r8.m16214a((long) r9)     // Catch:{ all -> 0x008f }
            monitor-exit(r1)     // Catch:{ all -> 0x008f }
            return r2
        L_0x0067:
            java.util.HashMap<java.lang.String, com.meizu.media.camera.util.p$b> r2 = r8.f14283m     // Catch:{ all -> 0x008f }
            java.lang.Object r2 = r2.get(r10)     // Catch:{ all -> 0x008f }
            com.meizu.media.camera.util.p$b r2 = (com.meizu.media.camera.util.DownloadCache.C2651b) r2     // Catch:{ all -> 0x008f }
            if (r2 != 0) goto L_0x0086
            com.meizu.media.camera.util.p$b r2 = new com.meizu.media.camera.util.p$b     // Catch:{ all -> 0x008f }
            r2.<init>(r10)     // Catch:{ all -> 0x008f }
            java.util.HashMap<java.lang.String, com.meizu.media.camera.util.p$b> r3 = r8.f14283m     // Catch:{ all -> 0x008f }
            r3.put(r10, r2)     // Catch:{ all -> 0x008f }
            com.meizu.media.camera.util.aq r10 = com.meizu.media.camera.util.ThreadPool.m16011a()     // Catch:{ all -> 0x008f }
            com.meizu.media.camera.util.v r10 = r10.mo22678a(r2, r2)     // Catch:{ all -> 0x008f }
            com.meizu.media.camera.util.Future unused = r2.f14302e = r10     // Catch:{ all -> 0x008f }
        L_0x0086:
            r2.mo22742b((com.meizu.media.camera.util.DownloadCache.C2653d) r0)     // Catch:{ all -> 0x008f }
            monitor-exit(r1)     // Catch:{ all -> 0x008f }
            com.meizu.media.camera.util.p$c r9 = r0.mo22743a((com.meizu.media.camera.util.ThreadPool.C2638c) r9)
            return r9
        L_0x008f:
            r9 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x008f }
            throw r9
        L_0x0092:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0092 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.DownloadCache.mo22735a(com.meizu.media.camera.util.aq$c, java.net.URL):com.meizu.media.camera.util.p$c");
    }

    /* renamed from: a */
    private void m16214a(long j) {
        if (!PatchProxy.proxy(new Object[]{new Long(j)}, this, f14271a, false, 8030, new Class[]{Long.TYPE}, Void.TYPE).isSupported) {
            synchronized (this.f14293w) {
                this.f14291u[this.f14290t] = System.currentTimeMillis();
                this.f14292v[this.f14290t] = j;
                this.f14290t++;
                if (this.f14290t == 50) {
                    m16222c();
                }
            }
        }
    }

    /* renamed from: c */
    private void m16222c() {
        if (!PatchProxy.proxy(new Object[0], this, f14271a, false, 8031, new Class[0], Void.TYPE).isSupported && this.f14290t > 0) {
            this.f14285o.beginTransaction();
            int i = 0;
            while (i < this.f14290t) {
                try {
                    this.f14293w.put("last_access", Long.valueOf(this.f14291u[i]));
                    this.f14294x[0] = String.valueOf(this.f14292v[i]);
                    this.f14285o.update(mo22737b(), this.f14293w, "_id = ?", this.f14294x);
                    i++;
                } finally {
                    this.f14290t = 0;
                    this.f14285o.endTransaction();
                }
            }
            this.f14285o.setTransactionSuccessful();
        }
    }

    /* renamed from: b */
    public static String m16218b(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f14271a, true, 8032, new Class[]{String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        int c = m16220c(str);
        int d = m16223d(str);
        return String.valueOf(c) + String.valueOf(d);
    }

    /* renamed from: c */
    private static int m16220c(String str) {
        int i;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f14271a, true, 8033, new Class[]{String.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            if ((i3 & 1) == 0) {
                i = ((i2 << 7) ^ str.charAt(i3)) ^ (i2 >> 3);
            } else {
                i = ~(((i2 << 11) ^ str.charAt(i3)) ^ (i2 >> 5));
            }
            i2 ^= i;
        }
        return i2;
    }

    /* renamed from: d */
    private static int m16223d(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f14271a, true, 8034, new Class[]{String.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            i = (i << 4) + str.charAt(i2);
            int i3 = (int) (((long) i) & 4026531840L);
            if (i3 != 0) {
                i = (i ^ (i3 >> 24)) & (~i3);
            }
        }
        return Integer.MAX_VALUE & i;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m16213a(int i) {
        boolean a;
        synchronized (this) {
            int i2 = i;
            if (!PatchProxy.proxy(new Object[]{new Integer(i2)}, this, f14271a, false, 8035, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
                if (this.f14288r > this.f14286p) {
                    m16222c();
                    Cursor query = this.f14285o.query(mo22737b(), f14274d, (String) null, (String[]) null, (String) null, (String) null, f14275e);
                    while (i2 > 0) {
                        try {
                            if (this.f14288r <= this.f14286p || !query.moveToNext()) {
                                break;
                            }
                            long j = query.getLong(0);
                            String string = query.getString(2);
                            long j2 = query.getLong(3);
                            String string2 = query.getString(1);
                            synchronized (this.f14282l) {
                                a = this.f14282l.mo22661a(string);
                            }
                            if (!a) {
                                i2--;
                                this.f14288r -= j2;
                                new File(string2).delete();
                                this.f14285o.delete(mo22737b(), "_id = ?", new String[]{String.valueOf(j)});
                            }
                        } catch (Throwable th) {
                            query.close();
                            throw th;
                        }
                    }
                    query.close();
                }
            }
        }
    }

    /* renamed from: a */
    public synchronized long mo22734a(String str, File file) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, file}, this, f14271a, false, 8036, new Class[]{String.class, File.class}, Long.TYPE);
        if (proxy.isSupported) {
            return ((Long) proxy.result).longValue();
        }
        long length = file.length();
        this.f14288r += length;
        ContentValues contentValues = new ContentValues();
        String b = m16218b(str);
        contentValues.put("_data", file.getAbsolutePath());
        contentValues.put("hash_code", b);
        contentValues.put("content_url", str);
        contentValues.put("_size", Long.valueOf(length));
        contentValues.put("last_updated", Long.valueOf(System.currentTimeMillis()));
        return this.f14285o.insert(mo22737b(), "", contentValues);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008f, code lost:
        return;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m16225d() {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0090 }
            com.meizu.savior.ChangeQuickRedirect r3 = f14271a     // Catch:{ all -> 0x0090 }
            r4 = 0
            r5 = 8037(0x1f65, float:1.1262E-41)
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x0090 }
            java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x0090 }
            r2 = r10
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0090 }
            boolean r1 = r1.isSupported     // Catch:{ all -> 0x0090 }
            if (r1 == 0) goto L_0x0018
            monitor-exit(r10)
            return
        L_0x0018:
            boolean r1 = r10.f14289s     // Catch:{ all -> 0x0090 }
            if (r1 != 0) goto L_0x008e
            java.io.File r1 = r10.f14284n     // Catch:{ all -> 0x0090 }
            if (r1 != 0) goto L_0x0021
            goto L_0x008e
        L_0x0021:
            r1 = 1
            r10.f14289s = r1     // Catch:{ all -> 0x0090 }
            java.io.File r1 = r10.f14284n     // Catch:{ all -> 0x0090 }
            boolean r1 = r1.isDirectory()     // Catch:{ all -> 0x0090 }
            if (r1 != 0) goto L_0x0031
            java.io.File r1 = r10.f14284n     // Catch:{ all -> 0x0090 }
            r1.mkdirs()     // Catch:{ all -> 0x0090 }
        L_0x0031:
            java.io.File r1 = r10.f14284n     // Catch:{ all -> 0x0090 }
            boolean r1 = r1.isDirectory()     // Catch:{ all -> 0x0090 }
            if (r1 == 0) goto L_0x0071
            android.database.sqlite.SQLiteDatabase r2 = r10.f14285o     // Catch:{ all -> 0x0090 }
            java.lang.String r3 = r10.mo22737b()     // Catch:{ all -> 0x0090 }
            java.lang.String[] r4 = f14276f     // Catch:{ all -> 0x0090 }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0090 }
            r2 = 0
            r10.f14288r = r2     // Catch:{ all -> 0x0090 }
            boolean r2 = r1.moveToNext()     // Catch:{ all -> 0x006c }
            if (r2 == 0) goto L_0x005a
            long r2 = r1.getLong(r0)     // Catch:{ all -> 0x006c }
            r10.f14288r = r2     // Catch:{ all -> 0x006c }
        L_0x005a:
            r1.close()     // Catch:{ all -> 0x0090 }
            long r0 = r10.f14288r     // Catch:{ all -> 0x0090 }
            long r2 = r10.f14286p     // Catch:{ all -> 0x0090 }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x006a
            r0 = 16
            r10.m16213a((int) r0)     // Catch:{ all -> 0x0090 }
        L_0x006a:
            monitor-exit(r10)
            return
        L_0x006c:
            r0 = move-exception
            r1.close()     // Catch:{ all -> 0x0090 }
            throw r0     // Catch:{ all -> 0x0090 }
        L_0x0071:
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException     // Catch:{ all -> 0x0090 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0090 }
            r1.<init>()     // Catch:{ all -> 0x0090 }
            java.lang.String r2 = "cannot create "
            r1.append(r2)     // Catch:{ all -> 0x0090 }
            java.io.File r2 = r10.f14284n     // Catch:{ all -> 0x0090 }
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ all -> 0x0090 }
            r1.append(r2)     // Catch:{ all -> 0x0090 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0090 }
            r0.<init>(r1)     // Catch:{ all -> 0x0090 }
            throw r0     // Catch:{ all -> 0x0090 }
        L_0x008e:
            monitor-exit(r10)
            return
        L_0x0090:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.DownloadCache.m16225d():void");
    }

    /* renamed from: com.meizu.media.camera.util.p$d */
    /* compiled from: DownloadCache */
    public static class C2653d {

        /* renamed from: a */
        public static ChangeQuickRedirect f14306a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public C2651b f14307b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public boolean f14308c = false;

        /* renamed from: d */
        private boolean f14309d = false;

        /* renamed from: e */
        private C2652c f14310e;

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public synchronized void mo22744a(C2652c cVar) {
            if (!PatchProxy.proxy(new Object[]{cVar}, this, f14306a, false, 8044, new Class[]{C2652c.class}, Void.TYPE).isSupported) {
                if (!this.f14308c) {
                    this.f14310e = cVar;
                    this.f14309d = true;
                    notifyAll();
                }
            }
        }

        /* renamed from: a */
        public C2652c mo22743a(ThreadPool.C2638c cVar) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{cVar}, this, f14306a, false, 8045, new Class[]{ThreadPool.C2638c.class}, C2652c.class);
            if (proxy.isSupported) {
                return (C2652c) proxy.result;
            }
            cVar.mo22680a((ThreadPool.C2636a) new ThreadPool.C2636a() {

                /* renamed from: a */
                public static ChangeQuickRedirect f14311a;

                /* renamed from: a */
                public void mo22679a() {
                    if (!PatchProxy.proxy(new Object[0], this, f14311a, false, 8046, new Class[0], Void.TYPE).isSupported) {
                        C2653d.this.f14307b.mo22741a(C2653d.this);
                        synchronized (C2653d.this) {
                            boolean unused = C2653d.this.f14308c = true;
                            C2653d.this.notifyAll();
                        }
                    }
                }
            });
            cVar.mo22681a(0);
            synchronized (this) {
                while (!this.f14308c && !this.f14309d) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Log.w("DownloadCache", "ignore interrupt", e);
                    }
                }
            }
            cVar.mo22680a((ThreadPool.C2636a) null);
            return this.f14310e;
        }
    }

    /* renamed from: com.meizu.media.camera.util.p$a */
    /* compiled from: DownloadCache */
    private final class C2650a extends SQLiteOpenHelper {

        /* renamed from: a */
        public static ChangeQuickRedirect f14296a;

        public C2650a(Context context) {
            super(context, "download_cache.db", (SQLiteDatabase.CursorFactory) null, 2);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            File[] listFiles;
            if (!PatchProxy.proxy(new Object[]{sQLiteDatabase}, this, f14296a, false, 8038, new Class[]{SQLiteDatabase.class}, Void.TYPE).isSupported) {
                DownloadEntry.f14314b.mo22748a(sQLiteDatabase);
                if (DownloadCache.this.f14284n != null && (listFiles = DownloadCache.this.f14284n.listFiles()) != null) {
                    for (File file : listFiles) {
                        if (!file.delete()) {
                            Log.w("DownloadCache", "fail to remove: " + file.getAbsolutePath());
                        }
                    }
                }
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (!PatchProxy.proxy(new Object[]{sQLiteDatabase, new Integer(i), new Integer(i2)}, this, f14296a, false, 8039, new Class[]{SQLiteDatabase.class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
                DownloadEntry.f14314b.mo22749b(sQLiteDatabase);
                onCreate(sQLiteDatabase);
            }
        }
    }

    /* renamed from: com.meizu.media.camera.util.p$c */
    /* compiled from: DownloadCache */
    public class C2652c {

        /* renamed from: a */
        public File f14303a;

        /* renamed from: b */
        protected long f14304b;

        C2652c(long j, File file) {
            this.f14304b = j;
            this.f14303a = file;
        }
    }

    /* renamed from: com.meizu.media.camera.util.p$b */
    /* compiled from: DownloadCache */
    private class C2651b implements ThreadPool.C2637b<File>, FutureListener<File> {

        /* renamed from: a */
        public static ChangeQuickRedirect f14298a;

        /* renamed from: c */
        private final String f14300c;

        /* renamed from: d */
        private HashSet<C2653d> f14301d = new HashSet<>();
        /* access modifiers changed from: private */

        /* renamed from: e */
        public Future<File> f14302e;

        public C2651b(String str) {
            this.f14300c = (String) C2644av.m16095a(str);
        }

        /* renamed from: a */
        public void mo22741a(C2653d dVar) {
            if (!PatchProxy.proxy(new Object[]{dVar}, this, f14298a, false, 8040, new Class[]{C2653d.class}, Void.TYPE).isSupported) {
                synchronized (DownloadCache.this.f14283m) {
                    C2644av.m16100a(this.f14301d.remove(dVar));
                    if (this.f14301d.isEmpty()) {
                        this.f14302e.mo22653a();
                        DownloadCache.this.f14283m.remove(this.f14300c);
                    }
                }
            }
        }

        /* renamed from: b */
        public void mo22742b(C2653d dVar) {
            if (!PatchProxy.proxy(new Object[]{dVar}, this, f14298a, false, 8041, new Class[]{C2653d.class}, Void.TYPE).isSupported) {
                C2651b unused = dVar.f14307b = this;
                this.f14301d.add(dVar);
            }
        }

        /* renamed from: a */
        public void mo18710a(Future<File> vVar) {
            if (!PatchProxy.proxy(new Object[]{vVar}, this, f14298a, false, 8042, new Class[]{Future.class}, Void.TYPE).isSupported) {
                File c = vVar.mo22657c();
                long j = 0;
                if (c != null) {
                    j = DownloadCache.this.mo22734a(this.f14300c, c);
                }
                if (vVar.mo22656b()) {
                    C2644av.m16100a(this.f14301d.isEmpty());
                    return;
                }
                synchronized (DownloadCache.this.f14283m) {
                    C2652c cVar = null;
                    synchronized (DownloadCache.this.f14282l) {
                        if (c != null) {
                            try {
                                cVar = new C2652c(j, c);
                                DownloadCache.this.f14282l.mo22660a(this.f14300c, cVar);
                            } catch (Throwable th) {
                                while (true) {
                                    throw th;
                                }
                            }
                        }
                    }
                    Iterator<C2653d> it = this.f14301d.iterator();
                    while (it.hasNext()) {
                        it.next().mo22744a(cVar);
                    }
                    DownloadCache.this.f14283m.remove(this.f14300c);
                    DownloadCache.this.m16213a(16);
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:27:0x009f  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.io.File mo22655b(com.meizu.media.camera.util.ThreadPool.C2638c r10) {
            /*
                r9 = this;
                r0 = 1
                java.lang.Object[] r1 = new java.lang.Object[r0]
                r8 = 0
                r1[r8] = r10
                com.meizu.savior.ChangeQuickRedirect r3 = f14298a
                java.lang.Class[] r6 = new java.lang.Class[r0]
                java.lang.Class<com.meizu.media.camera.util.aq$c> r2 = com.meizu.media.camera.util.ThreadPool.C2638c.class
                r6[r8] = r2
                java.lang.Class<java.io.File> r7 = java.io.File.class
                r4 = 0
                r5 = 8043(0x1f6b, float:1.127E-41)
                r2 = r9
                com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                boolean r2 = r1.isSupported
                if (r2 == 0) goto L_0x0021
                java.lang.Object r10 = r1.result
                java.io.File r10 = (java.io.File) r10
                return r10
            L_0x0021:
                r1 = 2
                r10.mo22681a((int) r1)
                r2 = 0
                com.meizu.media.camera.util.p r3 = com.meizu.media.camera.util.DownloadCache.this     // Catch:{ Exception -> 0x0087 }
                java.io.File r3 = r3.f14284n     // Catch:{ Exception -> 0x0087 }
                boolean r3 = r3.isDirectory()     // Catch:{ Exception -> 0x0087 }
                if (r3 != 0) goto L_0x003b
                com.meizu.media.camera.util.p r3 = com.meizu.media.camera.util.DownloadCache.this     // Catch:{ Exception -> 0x0087 }
                java.io.File r3 = r3.f14284n     // Catch:{ Exception -> 0x0087 }
                r3.mkdirs()     // Catch:{ Exception -> 0x0087 }
            L_0x003b:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0087 }
                r3.<init>()     // Catch:{ Exception -> 0x0087 }
                java.lang.String r4 = r9.f14300c     // Catch:{ Exception -> 0x0087 }
                java.lang.String r4 = com.meizu.media.camera.util.DownloadCache.m16218b((java.lang.String) r4)     // Catch:{ Exception -> 0x0087 }
                r3.append(r4)     // Catch:{ Exception -> 0x0087 }
                java.lang.String r4 = ".tmp"
                r3.append(r4)     // Catch:{ Exception -> 0x0087 }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0087 }
                java.net.URL r4 = new java.net.URL     // Catch:{ Exception -> 0x0087 }
                java.lang.String r5 = r9.f14300c     // Catch:{ Exception -> 0x0087 }
                r4.<init>(r5)     // Catch:{ Exception -> 0x0087 }
                java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x0087 }
                com.meizu.media.camera.util.p r6 = com.meizu.media.camera.util.DownloadCache.this     // Catch:{ Exception -> 0x0087 }
                java.io.File r6 = r6.f14284n     // Catch:{ Exception -> 0x0087 }
                r5.<init>(r6, r3)     // Catch:{ Exception -> 0x0087 }
                boolean r3 = r5.exists()     // Catch:{ Exception -> 0x0083 }
                if (r3 != 0) goto L_0x006d
                r5.createNewFile()     // Catch:{ Exception -> 0x0083 }
            L_0x006d:
                r10.mo22681a((int) r1)     // Catch:{ Exception -> 0x0083 }
                com.meizu.media.camera.util.p r1 = com.meizu.media.camera.util.DownloadCache.this     // Catch:{ Exception -> 0x0083 }
                com.meizu.media.camera.util.r$a r1 = r1.f14295y     // Catch:{ Exception -> 0x0083 }
                boolean r1 = com.meizu.media.camera.util.DownloadUtils.m16243a((com.meizu.media.camera.util.ThreadPool.C2638c) r10, (java.net.URL) r4, (java.io.File) r5, (com.meizu.media.camera.util.DownloadUtils.C2656a) r1)     // Catch:{ Exception -> 0x0083 }
                r10.mo22681a((int) r8)     // Catch:{ Exception -> 0x0083 }
                if (r1 == 0) goto L_0x009a
                r10.mo22681a((int) r8)
                return r5
            L_0x0083:
                r1 = move-exception
                goto L_0x0089
            L_0x0085:
                r0 = move-exception
                goto L_0x00a3
            L_0x0087:
                r1 = move-exception
                r5 = r2
            L_0x0089:
                java.lang.String r3 = "DownloadCache"
                java.lang.String r4 = "fail to download %s"
                java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x0085 }
                java.lang.String r6 = r9.f14300c     // Catch:{ all -> 0x0085 }
                r0[r8] = r6     // Catch:{ all -> 0x0085 }
                java.lang.String r0 = java.lang.String.format(r4, r0)     // Catch:{ all -> 0x0085 }
                android.util.Log.e(r3, r0, r1)     // Catch:{ all -> 0x0085 }
            L_0x009a:
                r10.mo22681a((int) r8)
                if (r5 == 0) goto L_0x00a2
                r5.delete()
            L_0x00a2:
                return r2
            L_0x00a3:
                r10.mo22681a((int) r8)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.DownloadCache.C2651b.mo22655b(com.meizu.media.camera.util.aq$c):java.io.File");
        }
    }
}
