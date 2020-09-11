package com.loc;

import com.baidu.p020ar.msghandler.ComponentMessageType;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/* renamed from: com.loc.ad */
public final class DiskLruCache implements Closeable {

    /* renamed from: a */
    static final Pattern f2514a = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: b */
    static ThreadPoolExecutor f2515b = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), f2516q);

    /* renamed from: q */
    private static final ThreadFactory f2516q = new ThreadFactory() {

        /* renamed from: a */
        private final AtomicInteger f2533a = new AtomicInteger(1);

        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "disklrucache#" + this.f2533a.getAndIncrement());
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: s */
    public static final OutputStream f2517s = new OutputStream() {
        public final void write(int i) throws IOException {
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final File f2518c;

    /* renamed from: d */
    private final File f2519d;

    /* renamed from: e */
    private final File f2520e;

    /* renamed from: f */
    private final File f2521f;

    /* renamed from: g */
    private final int f2522g;

    /* renamed from: h */
    private long f2523h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final int f2524i;

    /* renamed from: j */
    private long f2525j = 0;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Writer f2526k;

    /* renamed from: l */
    private int f2527l = 1000;

    /* renamed from: m */
    private final LinkedHashMap<String, C1047c> f2528m = new LinkedHashMap<>(0, 0.75f, true);
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f2529n;

    /* renamed from: o */
    private FileOperationListener f2530o;

    /* renamed from: p */
    private long f2531p = 0;

    /* renamed from: r */
    private final Callable<Void> f2532r = new Callable<Void>() {
        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
            return null;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void call() throws java.lang.Exception {
            /*
                r3 = this;
                com.loc.ad r0 = com.loc.DiskLruCache.this
                monitor-enter(r0)
                com.loc.ad r1 = com.loc.DiskLruCache.this     // Catch:{ all -> 0x0027 }
                java.io.Writer r1 = r1.f2526k     // Catch:{ all -> 0x0027 }
                r2 = 0
                if (r1 != 0) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x0027 }
                return r2
            L_0x000e:
                com.loc.ad r1 = com.loc.DiskLruCache.this     // Catch:{ all -> 0x0027 }
                r1.m2960l()     // Catch:{ all -> 0x0027 }
                com.loc.ad r1 = com.loc.DiskLruCache.this     // Catch:{ all -> 0x0027 }
                boolean r1 = r1.m2958j()     // Catch:{ all -> 0x0027 }
                if (r1 == 0) goto L_0x0025
                com.loc.ad r1 = com.loc.DiskLruCache.this     // Catch:{ all -> 0x0027 }
                r1.m2957i()     // Catch:{ all -> 0x0027 }
                com.loc.ad r1 = com.loc.DiskLruCache.this     // Catch:{ all -> 0x0027 }
                int unused = r1.f2529n = 0     // Catch:{ all -> 0x0027 }
            L_0x0025:
                monitor-exit(r0)     // Catch:{ all -> 0x0027 }
                return r2
            L_0x0027:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.loc.DiskLruCache.C10422.call():java.lang.Void");
        }
    };

    /* renamed from: com.loc.ad$a */
    /* compiled from: DiskLruCache */
    public final class C1044a {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final C1047c f2536b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final boolean[] f2537c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public boolean f2538d;

        /* renamed from: e */
        private boolean f2539e;

        /* renamed from: com.loc.ad$a$a */
        /* compiled from: DiskLruCache */
        private class C1045a extends FilterOutputStream {
            private C1045a(OutputStream outputStream) {
                super(outputStream);
            }

            /* synthetic */ C1045a(C1044a aVar, OutputStream outputStream, byte b) {
                this(outputStream);
            }

            public final void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    boolean unused2 = C1044a.this.f2538d = true;
                }
            }

            public final void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    boolean unused2 = C1044a.this.f2538d = true;
                }
            }

            public final void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException unused) {
                    boolean unused2 = C1044a.this.f2538d = true;
                }
            }

            public final void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException unused) {
                    boolean unused2 = C1044a.this.f2538d = true;
                }
            }
        }

        private C1044a(C1047c cVar) {
            this.f2536b = cVar;
            this.f2537c = cVar.f2549d ? null : new boolean[DiskLruCache.this.f2524i];
        }

        /* synthetic */ C1044a(DiskLruCache adVar, C1047c cVar, byte b) {
            this(cVar);
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002d */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.io.OutputStream mo12982a() throws java.io.IOException {
            /*
                r4 = this;
                com.loc.ad r0 = com.loc.DiskLruCache.this
                int r0 = r0.f2524i
                if (r0 <= 0) goto L_0x0051
                com.loc.ad r0 = com.loc.DiskLruCache.this
                monitor-enter(r0)
                com.loc.ad$c r1 = r4.f2536b     // Catch:{ all -> 0x004e }
                com.loc.ad$a r1 = r1.f2550e     // Catch:{ all -> 0x004e }
                if (r1 != r4) goto L_0x0048
                com.loc.ad$c r1 = r4.f2536b     // Catch:{ all -> 0x004e }
                boolean r1 = r1.f2549d     // Catch:{ all -> 0x004e }
                r2 = 0
                if (r1 != 0) goto L_0x0021
                boolean[] r1 = r4.f2537c     // Catch:{ all -> 0x004e }
                r3 = 1
                r1[r2] = r3     // Catch:{ all -> 0x004e }
            L_0x0021:
                com.loc.ad$c r1 = r4.f2536b     // Catch:{ all -> 0x004e }
                java.io.File r1 = r1.mo12993b((int) r2)     // Catch:{ all -> 0x004e }
                java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x002d }
                r3.<init>(r1)     // Catch:{ FileNotFoundException -> 0x002d }
                goto L_0x003b
            L_0x002d:
                com.loc.ad r3 = com.loc.DiskLruCache.this     // Catch:{ all -> 0x004e }
                java.io.File r3 = r3.f2518c     // Catch:{ all -> 0x004e }
                r3.mkdirs()     // Catch:{ all -> 0x004e }
                java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0042 }
                r3.<init>(r1)     // Catch:{ FileNotFoundException -> 0x0042 }
            L_0x003b:
                com.loc.ad$a$a r1 = new com.loc.ad$a$a     // Catch:{ all -> 0x004e }
                r1.<init>(r4, r3, r2)     // Catch:{ all -> 0x004e }
                monitor-exit(r0)     // Catch:{ all -> 0x004e }
                return r1
            L_0x0042:
                java.io.OutputStream r1 = com.loc.DiskLruCache.f2517s     // Catch:{ all -> 0x004e }
                monitor-exit(r0)     // Catch:{ all -> 0x004e }
                return r1
            L_0x0048:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x004e }
                r1.<init>()     // Catch:{ all -> 0x004e }
                throw r1     // Catch:{ all -> 0x004e }
            L_0x004e:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            L_0x0051:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "Expected index 0 to be greater than 0 and less than the maximum value count of "
                r1.<init>(r2)
                com.loc.ad r2 = com.loc.DiskLruCache.this
                int r2 = r2.f2524i
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.loc.DiskLruCache.C1044a.mo12982a():java.io.OutputStream");
        }

        /* renamed from: b */
        public final void mo12983b() throws IOException {
            if (this.f2538d) {
                DiskLruCache.this.m2941a(this, false);
                DiskLruCache.this.mo12976c(this.f2536b.f2547b);
            } else {
                DiskLruCache.this.m2941a(this, true);
            }
            this.f2539e = true;
        }

        /* renamed from: c */
        public final void mo12984c() throws IOException {
            DiskLruCache.this.m2941a(this, false);
        }
    }

    /* renamed from: com.loc.ad$b */
    /* compiled from: DiskLruCache */
    public final class C1046b implements Closeable {

        /* renamed from: b */
        private final String f2542b;

        /* renamed from: c */
        private final long f2543c;

        /* renamed from: d */
        private final InputStream[] f2544d;

        /* renamed from: e */
        private final long[] f2545e;

        private C1046b(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.f2542b = str;
            this.f2543c = j;
            this.f2544d = inputStreamArr;
            this.f2545e = jArr;
        }

        /* synthetic */ C1046b(DiskLruCache adVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, byte b) {
            this(str, j, inputStreamArr, jArr);
        }

        /* renamed from: a */
        public final InputStream mo12989a() {
            return this.f2544d[0];
        }

        public final void close() {
            for (InputStream a : this.f2544d) {
                Util.m2992a((Closeable) a);
            }
        }
    }

    /* renamed from: com.loc.ad$c */
    /* compiled from: DiskLruCache */
    private final class C1047c {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final String f2547b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final long[] f2548c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public boolean f2549d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public C1044a f2550e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public long f2551f;

        private C1047c(String str) {
            this.f2547b = str;
            this.f2548c = new long[DiskLruCache.this.f2524i];
        }

        /* synthetic */ C1047c(DiskLruCache adVar, String str, byte b) {
            this(str);
        }

        /* renamed from: a */
        private static IOException m2978a(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* renamed from: a */
        static /* synthetic */ void m2979a(C1047c cVar, String[] strArr) throws IOException {
            if (strArr.length == DiskLruCache.this.f2524i) {
                int i = 0;
                while (i < strArr.length) {
                    try {
                        cVar.f2548c[i] = Long.parseLong(strArr[i]);
                        i++;
                    } catch (NumberFormatException unused) {
                        throw m2978a(strArr);
                    }
                }
                return;
            }
            throw m2978a(strArr);
        }

        /* renamed from: a */
        public final File mo12991a(int i) {
            File g = DiskLruCache.this.f2518c;
            return new File(g, this.f2547b + "." + i);
        }

        /* renamed from: a */
        public final String mo12992a() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long append : this.f2548c) {
                sb.append(' ');
                sb.append(append);
            }
            return sb.toString();
        }

        /* renamed from: b */
        public final File mo12993b(int i) {
            File g = DiskLruCache.this.f2518c;
            return new File(g, this.f2547b + "." + i + ".tmp");
        }
    }

    private DiskLruCache(File file, long j) {
        this.f2518c = file;
        this.f2522g = 1;
        this.f2519d = new File(file, "journal");
        this.f2520e = new File(file, "journal.tmp");
        this.f2521f = new File(file, "journal.bkp");
        this.f2524i = 1;
        this.f2523h = j;
    }

    /* renamed from: a */
    public static DiskLruCache m2938a(File file, long j) throws IOException {
        if (j > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    m2944a(file2, file3, false);
                }
            }
            DiskLruCache adVar = new DiskLruCache(file, j);
            if (adVar.f2519d.exists()) {
                try {
                    adVar.m2955g();
                    adVar.m2956h();
                    adVar.f2526k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(adVar.f2519d, true), Util.f2558a));
                    return adVar;
                } catch (Throwable unused) {
                    adVar.mo12978d();
                }
            }
            file.mkdirs();
            DiskLruCache adVar2 = new DiskLruCache(file, j);
            adVar2.m2957i();
            return adVar2;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* renamed from: a */
    public static void m2940a() {
        if (f2515b != null && !f2515b.isShutdown()) {
            f2515b.shutdown();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0103, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m2941a(com.loc.DiskLruCache.C1044a r10, boolean r11) throws java.io.IOException {
        /*
            r9 = this;
            monitor-enter(r9)
            com.loc.ad$c r0 = r10.f2536b     // Catch:{ all -> 0x010a }
            com.loc.ad$a r1 = r0.f2550e     // Catch:{ all -> 0x010a }
            if (r1 != r10) goto L_0x0104
            r1 = 0
            if (r11 == 0) goto L_0x004a
            boolean r2 = r0.f2549d     // Catch:{ all -> 0x010a }
            if (r2 != 0) goto L_0x004a
            r2 = 0
        L_0x0015:
            int r3 = r9.f2524i     // Catch:{ all -> 0x010a }
            if (r2 >= r3) goto L_0x004a
            boolean[] r3 = r10.f2537c     // Catch:{ all -> 0x010a }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x010a }
            if (r3 == 0) goto L_0x0033
            java.io.File r3 = r0.mo12993b((int) r2)     // Catch:{ all -> 0x010a }
            boolean r3 = r3.exists()     // Catch:{ all -> 0x010a }
            if (r3 != 0) goto L_0x0030
            r10.mo12984c()     // Catch:{ all -> 0x010a }
            monitor-exit(r9)
            return
        L_0x0030:
            int r2 = r2 + 1
            goto L_0x0015
        L_0x0033:
            r10.mo12984c()     // Catch:{ all -> 0x010a }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x010a }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x010a }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r11.<init>(r0)     // Catch:{ all -> 0x010a }
            r11.append(r2)     // Catch:{ all -> 0x010a }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x010a }
            r10.<init>(r11)     // Catch:{ all -> 0x010a }
            throw r10     // Catch:{ all -> 0x010a }
        L_0x004a:
            int r10 = r9.f2524i     // Catch:{ all -> 0x010a }
            if (r1 >= r10) goto L_0x007f
            java.io.File r10 = r0.mo12993b((int) r1)     // Catch:{ all -> 0x010a }
            if (r11 == 0) goto L_0x0079
            boolean r2 = r10.exists()     // Catch:{ all -> 0x010a }
            if (r2 == 0) goto L_0x007c
            java.io.File r2 = r0.mo12991a((int) r1)     // Catch:{ all -> 0x010a }
            r10.renameTo(r2)     // Catch:{ all -> 0x010a }
            long[] r10 = r0.f2548c     // Catch:{ all -> 0x010a }
            r3 = r10[r1]     // Catch:{ all -> 0x010a }
            long r5 = r2.length()     // Catch:{ all -> 0x010a }
            long[] r10 = r0.f2548c     // Catch:{ all -> 0x010a }
            r10[r1] = r5     // Catch:{ all -> 0x010a }
            long r7 = r9.f2525j     // Catch:{ all -> 0x010a }
            r10 = 0
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.f2525j = r7     // Catch:{ all -> 0x010a }
            goto L_0x007c
        L_0x0079:
            m2943a((java.io.File) r10)     // Catch:{ all -> 0x010a }
        L_0x007c:
            int r1 = r1 + 1
            goto L_0x004a
        L_0x007f:
            int r10 = r9.f2529n     // Catch:{ all -> 0x010a }
            int r10 = r10 + 1
            r9.f2529n = r10     // Catch:{ all -> 0x010a }
            r10 = 0
            com.loc.DiskLruCache.C1044a unused = r0.f2550e = r10     // Catch:{ all -> 0x010a }
            boolean r10 = r0.f2549d     // Catch:{ all -> 0x010a }
            r10 = r10 | r11
            r1 = 10
            if (r10 == 0) goto L_0x00c3
            boolean unused = r0.f2549d = true     // Catch:{ all -> 0x010a }
            java.io.Writer r10 = r9.f2526k     // Catch:{ all -> 0x010a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x010a }
            java.lang.String r3 = "CLEAN "
            r2.<init>(r3)     // Catch:{ all -> 0x010a }
            java.lang.String r3 = r0.f2547b     // Catch:{ all -> 0x010a }
            r2.append(r3)     // Catch:{ all -> 0x010a }
            java.lang.String r3 = r0.mo12992a()     // Catch:{ all -> 0x010a }
            r2.append(r3)     // Catch:{ all -> 0x010a }
            r2.append(r1)     // Catch:{ all -> 0x010a }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x010a }
            r10.write(r1)     // Catch:{ all -> 0x010a }
            if (r11 == 0) goto L_0x00e6
            long r10 = r9.f2531p     // Catch:{ all -> 0x010a }
            r1 = 1
            long r1 = r1 + r10
            r9.f2531p = r1     // Catch:{ all -> 0x010a }
            long unused = r0.f2551f = r10     // Catch:{ all -> 0x010a }
            goto L_0x00e6
        L_0x00c3:
            java.util.LinkedHashMap<java.lang.String, com.loc.ad$c> r10 = r9.f2528m     // Catch:{ all -> 0x010a }
            java.lang.String r11 = r0.f2547b     // Catch:{ all -> 0x010a }
            r10.remove(r11)     // Catch:{ all -> 0x010a }
            java.io.Writer r10 = r9.f2526k     // Catch:{ all -> 0x010a }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x010a }
            java.lang.String r2 = "REMOVE "
            r11.<init>(r2)     // Catch:{ all -> 0x010a }
            java.lang.String r0 = r0.f2547b     // Catch:{ all -> 0x010a }
            r11.append(r0)     // Catch:{ all -> 0x010a }
            r11.append(r1)     // Catch:{ all -> 0x010a }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x010a }
            r10.write(r11)     // Catch:{ all -> 0x010a }
        L_0x00e6:
            java.io.Writer r10 = r9.f2526k     // Catch:{ all -> 0x010a }
            r10.flush()     // Catch:{ all -> 0x010a }
            long r10 = r9.f2525j     // Catch:{ all -> 0x010a }
            long r0 = r9.f2523h     // Catch:{ all -> 0x010a }
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 > 0) goto L_0x00f9
            boolean r10 = r9.m2958j()     // Catch:{ all -> 0x010a }
            if (r10 == 0) goto L_0x0102
        L_0x00f9:
            java.util.concurrent.ThreadPoolExecutor r10 = m2953f()     // Catch:{ all -> 0x010a }
            java.util.concurrent.Callable<java.lang.Void> r11 = r9.f2532r     // Catch:{ all -> 0x010a }
            r10.submit(r11)     // Catch:{ all -> 0x010a }
        L_0x0102:
            monitor-exit(r9)
            return
        L_0x0104:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x010a }
            r10.<init>()     // Catch:{ all -> 0x010a }
            throw r10     // Catch:{ all -> 0x010a }
        L_0x010a:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.DiskLruCache.m2941a(com.loc.ad$a, boolean):void");
    }

    /* renamed from: a */
    private static void m2943a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* renamed from: a */
    private static void m2944a(File file, File file2, boolean z) throws IOException {
        if (z) {
            m2943a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* renamed from: d */
    private synchronized C1044a m2947d(String str) throws IOException {
        m2959k();
        m2951e(str);
        C1047c cVar = this.f2528m.get(str);
        if (cVar == null) {
            cVar = new C1047c(this, str, (byte) 0);
            this.f2528m.put(str, cVar);
        } else if (cVar.f2550e != null) {
            return null;
        }
        C1044a aVar = new C1044a(this, cVar, (byte) 0);
        C1044a unused = cVar.f2550e = aVar;
        Writer writer = this.f2526k;
        writer.write("DIRTY " + str + 10);
        this.f2526k.flush();
        return aVar;
    }

    /* renamed from: e */
    private static void m2951e(String str) {
        if (!f2514a.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* renamed from: f */
    private static ThreadPoolExecutor m2953f() {
        try {
            if (f2515b == null || f2515b.isShutdown()) {
                f2515b = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(256), f2516q);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return f2515b;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:48|49|50|51) */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r10.f2529n = r2 - r10.f2528m.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0114, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x0108 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:13:0x0054=Splitter:B:13:0x0054, B:52:0x0115=Splitter:B:52:0x0115} */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2955g() throws java.io.IOException {
        /*
            r10 = this;
            com.loc.af r0 = new com.loc.af
            java.io.FileInputStream r1 = new java.io.FileInputStream
            java.io.File r2 = r10.f2519d
            r1.<init>(r2)
            java.nio.charset.Charset r2 = com.loc.Util.f2558a
            r0.<init>(r1, r2)
            java.lang.String r1 = r0.mo12994a()     // Catch:{ all -> 0x0146 }
            java.lang.String r2 = r0.mo12994a()     // Catch:{ all -> 0x0146 }
            java.lang.String r3 = r0.mo12994a()     // Catch:{ all -> 0x0146 }
            java.lang.String r4 = r0.mo12994a()     // Catch:{ all -> 0x0146 }
            java.lang.String r5 = r0.mo12994a()     // Catch:{ all -> 0x0146 }
            java.lang.String r6 = "libcore.io.DiskLruCache"
            boolean r6 = r6.equals(r1)     // Catch:{ all -> 0x0146 }
            if (r6 == 0) goto L_0x0115
            java.lang.String r6 = "1"
            boolean r6 = r6.equals(r2)     // Catch:{ all -> 0x0146 }
            if (r6 == 0) goto L_0x0115
            int r6 = r10.f2522g     // Catch:{ all -> 0x0146 }
            java.lang.String r6 = java.lang.Integer.toString(r6)     // Catch:{ all -> 0x0146 }
            boolean r3 = r6.equals(r3)     // Catch:{ all -> 0x0146 }
            if (r3 == 0) goto L_0x0115
            int r3 = r10.f2524i     // Catch:{ all -> 0x0146 }
            java.lang.String r3 = java.lang.Integer.toString(r3)     // Catch:{ all -> 0x0146 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0146 }
            if (r3 == 0) goto L_0x0115
            java.lang.String r3 = ""
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0146 }
            if (r3 == 0) goto L_0x0115
            r1 = 0
            r2 = 0
        L_0x0054:
            java.lang.String r3 = r0.mo12994a()     // Catch:{ EOFException -> 0x0108 }
            r4 = 32
            int r5 = r3.indexOf(r4)     // Catch:{ EOFException -> 0x0108 }
            r6 = -1
            if (r5 == r6) goto L_0x00f4
            int r7 = r5 + 1
            int r4 = r3.indexOf(r4, r7)     // Catch:{ EOFException -> 0x0108 }
            if (r4 != r6) goto L_0x007e
            java.lang.String r7 = r3.substring(r7)     // Catch:{ EOFException -> 0x0108 }
            r8 = 6
            if (r5 != r8) goto L_0x0082
            java.lang.String r8 = "REMOVE"
            boolean r8 = r3.startsWith(r8)     // Catch:{ EOFException -> 0x0108 }
            if (r8 == 0) goto L_0x0082
            java.util.LinkedHashMap<java.lang.String, com.loc.ad$c> r3 = r10.f2528m     // Catch:{ EOFException -> 0x0108 }
            r3.remove(r7)     // Catch:{ EOFException -> 0x0108 }
            goto L_0x00dc
        L_0x007e:
            java.lang.String r7 = r3.substring(r7, r4)     // Catch:{ EOFException -> 0x0108 }
        L_0x0082:
            java.util.LinkedHashMap<java.lang.String, com.loc.ad$c> r8 = r10.f2528m     // Catch:{ EOFException -> 0x0108 }
            java.lang.Object r8 = r8.get(r7)     // Catch:{ EOFException -> 0x0108 }
            com.loc.ad$c r8 = (com.loc.DiskLruCache.C1047c) r8     // Catch:{ EOFException -> 0x0108 }
            if (r8 != 0) goto L_0x0096
            com.loc.ad$c r8 = new com.loc.ad$c     // Catch:{ EOFException -> 0x0108 }
            r8.<init>(r10, r7, r1)     // Catch:{ EOFException -> 0x0108 }
            java.util.LinkedHashMap<java.lang.String, com.loc.ad$c> r9 = r10.f2528m     // Catch:{ EOFException -> 0x0108 }
            r9.put(r7, r8)     // Catch:{ EOFException -> 0x0108 }
        L_0x0096:
            r7 = 5
            if (r4 == r6) goto L_0x00ba
            if (r5 != r7) goto L_0x00ba
            java.lang.String r9 = "CLEAN"
            boolean r9 = r3.startsWith(r9)     // Catch:{ EOFException -> 0x0108 }
            if (r9 == 0) goto L_0x00ba
            int r4 = r4 + 1
            java.lang.String r3 = r3.substring(r4)     // Catch:{ EOFException -> 0x0108 }
            java.lang.String r4 = " "
            java.lang.String[] r3 = r3.split(r4)     // Catch:{ EOFException -> 0x0108 }
            boolean unused = r8.f2549d = true     // Catch:{ EOFException -> 0x0108 }
            r4 = 0
            com.loc.DiskLruCache.C1044a unused = r8.f2550e = r4     // Catch:{ EOFException -> 0x0108 }
            com.loc.DiskLruCache.C1047c.m2979a((com.loc.DiskLruCache.C1047c) r8, (java.lang.String[]) r3)     // Catch:{ EOFException -> 0x0108 }
            goto L_0x00dc
        L_0x00ba:
            if (r4 != r6) goto L_0x00cf
            if (r5 != r7) goto L_0x00cf
            java.lang.String r7 = "DIRTY"
            boolean r7 = r3.startsWith(r7)     // Catch:{ EOFException -> 0x0108 }
            if (r7 == 0) goto L_0x00cf
            com.loc.ad$a r3 = new com.loc.ad$a     // Catch:{ EOFException -> 0x0108 }
            r3.<init>(r10, r8, r1)     // Catch:{ EOFException -> 0x0108 }
            com.loc.DiskLruCache.C1044a unused = r8.f2550e = r3     // Catch:{ EOFException -> 0x0108 }
            goto L_0x00dc
        L_0x00cf:
            if (r4 != r6) goto L_0x00e0
            r4 = 4
            if (r5 != r4) goto L_0x00e0
            java.lang.String r4 = "READ"
            boolean r4 = r3.startsWith(r4)     // Catch:{ EOFException -> 0x0108 }
            if (r4 == 0) goto L_0x00e0
        L_0x00dc:
            int r2 = r2 + 1
            goto L_0x0054
        L_0x00e0:
            java.io.IOException r1 = new java.io.IOException     // Catch:{ EOFException -> 0x0108 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x0108 }
            java.lang.String r5 = "unexpected journal line: "
            r4.<init>(r5)     // Catch:{ EOFException -> 0x0108 }
            r4.append(r3)     // Catch:{ EOFException -> 0x0108 }
            java.lang.String r3 = r4.toString()     // Catch:{ EOFException -> 0x0108 }
            r1.<init>(r3)     // Catch:{ EOFException -> 0x0108 }
            throw r1     // Catch:{ EOFException -> 0x0108 }
        L_0x00f4:
            java.io.IOException r1 = new java.io.IOException     // Catch:{ EOFException -> 0x0108 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x0108 }
            java.lang.String r5 = "unexpected journal line: "
            r4.<init>(r5)     // Catch:{ EOFException -> 0x0108 }
            r4.append(r3)     // Catch:{ EOFException -> 0x0108 }
            java.lang.String r3 = r4.toString()     // Catch:{ EOFException -> 0x0108 }
            r1.<init>(r3)     // Catch:{ EOFException -> 0x0108 }
            throw r1     // Catch:{ EOFException -> 0x0108 }
        L_0x0108:
            java.util.LinkedHashMap<java.lang.String, com.loc.ad$c> r1 = r10.f2528m     // Catch:{ all -> 0x0146 }
            int r1 = r1.size()     // Catch:{ all -> 0x0146 }
            int r2 = r2 - r1
            r10.f2529n = r2     // Catch:{ all -> 0x0146 }
            com.loc.Util.m2992a((java.io.Closeable) r0)
            return
        L_0x0115:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x0146 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0146 }
            java.lang.String r7 = "unexpected journal header: ["
            r6.<init>(r7)     // Catch:{ all -> 0x0146 }
            r6.append(r1)     // Catch:{ all -> 0x0146 }
            java.lang.String r1 = ", "
            r6.append(r1)     // Catch:{ all -> 0x0146 }
            r6.append(r2)     // Catch:{ all -> 0x0146 }
            java.lang.String r1 = ", "
            r6.append(r1)     // Catch:{ all -> 0x0146 }
            r6.append(r4)     // Catch:{ all -> 0x0146 }
            java.lang.String r1 = ", "
            r6.append(r1)     // Catch:{ all -> 0x0146 }
            r6.append(r5)     // Catch:{ all -> 0x0146 }
            java.lang.String r1 = "]"
            r6.append(r1)     // Catch:{ all -> 0x0146 }
            java.lang.String r1 = r6.toString()     // Catch:{ all -> 0x0146 }
            r3.<init>(r1)     // Catch:{ all -> 0x0146 }
            throw r3     // Catch:{ all -> 0x0146 }
        L_0x0146:
            r1 = move-exception
            com.loc.Util.m2992a((java.io.Closeable) r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.DiskLruCache.m2955g():void");
    }

    /* renamed from: h */
    private void m2956h() throws IOException {
        m2943a(this.f2520e);
        Iterator<C1047c> it = this.f2528m.values().iterator();
        while (it.hasNext()) {
            C1047c next = it.next();
            int i = 0;
            if (next.f2550e == null) {
                while (i < this.f2524i) {
                    this.f2525j += next.f2548c[i];
                    i++;
                }
            } else {
                C1044a unused = next.f2550e = null;
                while (i < this.f2524i) {
                    m2943a(next.mo12991a(i));
                    m2943a(next.mo12993b(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* renamed from: i */
    public synchronized void m2957i() throws IOException {
        String str;
        if (this.f2526k != null) {
            this.f2526k.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f2520e), Util.f2558a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f2522g));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f2524i));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (C1047c next : this.f2528m.values()) {
                if (next.f2550e != null) {
                    str = "DIRTY " + next.f2547b + 10;
                } else {
                    str = "CLEAN " + next.f2547b + next.mo12992a() + 10;
                }
                bufferedWriter.write(str);
            }
            bufferedWriter.close();
            if (this.f2519d.exists()) {
                m2944a(this.f2519d, this.f2521f, true);
            }
            m2944a(this.f2520e, this.f2519d, false);
            this.f2521f.delete();
            this.f2526k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f2519d, true), Util.f2558a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public boolean m2958j() {
        return this.f2529n >= 2000 && this.f2529n >= this.f2528m.size();
    }

    /* renamed from: k */
    private void m2959k() {
        if (this.f2526k == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m2960l() throws IOException {
        while (true) {
            if (this.f2525j > this.f2523h || this.f2528m.size() > this.f2527l) {
                mo12976c((String) this.f2528m.entrySet().iterator().next().getKey());
                if (this.f2530o != null) {
                    FileOperationListener aeVar = this.f2530o;
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:32|33|28|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r11.f2529n++;
        r11.f2526k.append("READ " + r12 + 10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        if (m2958j() == false) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0058, code lost:
        m2953f().submit(r11.f2532r);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0073, code lost:
        return new com.loc.DiskLruCache.C1046b(r11, r12, com.loc.DiskLruCache.C1047c.m2985f(r0), r8, com.loc.DiskLruCache.C1047c.m2982c(r0), (byte) 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0085, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0074 */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007c  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.loc.DiskLruCache.C1046b mo12971a(java.lang.String r12) throws java.io.IOException {
        /*
            r11 = this;
            monitor-enter(r11)
            r11.m2959k()     // Catch:{ all -> 0x0086 }
            m2951e((java.lang.String) r12)     // Catch:{ all -> 0x0086 }
            java.util.LinkedHashMap<java.lang.String, com.loc.ad$c> r0 = r11.f2528m     // Catch:{ all -> 0x0086 }
            java.lang.Object r0 = r0.get(r12)     // Catch:{ all -> 0x0086 }
            com.loc.ad$c r0 = (com.loc.DiskLruCache.C1047c) r0     // Catch:{ all -> 0x0086 }
            r1 = 0
            if (r0 != 0) goto L_0x0014
            monitor-exit(r11)
            return r1
        L_0x0014:
            boolean r2 = r0.f2549d     // Catch:{ all -> 0x0086 }
            if (r2 != 0) goto L_0x001c
            monitor-exit(r11)
            return r1
        L_0x001c:
            int r2 = r11.f2524i     // Catch:{ all -> 0x0086 }
            java.io.InputStream[] r8 = new java.io.InputStream[r2]     // Catch:{ all -> 0x0086 }
            r2 = 0
            r3 = 0
        L_0x0022:
            int r4 = r11.f2524i     // Catch:{ FileNotFoundException -> 0x0074 }
            if (r3 >= r4) goto L_0x0034
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0074 }
            java.io.File r5 = r0.mo12991a((int) r3)     // Catch:{ FileNotFoundException -> 0x0074 }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0074 }
            r8[r3] = r4     // Catch:{ FileNotFoundException -> 0x0074 }
            int r3 = r3 + 1
            goto L_0x0022
        L_0x0034:
            int r1 = r11.f2529n     // Catch:{ all -> 0x0086 }
            int r1 = r1 + 1
            r11.f2529n = r1     // Catch:{ all -> 0x0086 }
            java.io.Writer r1 = r11.f2526k     // Catch:{ all -> 0x0086 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0086 }
            java.lang.String r3 = "READ "
            r2.<init>(r3)     // Catch:{ all -> 0x0086 }
            r2.append(r12)     // Catch:{ all -> 0x0086 }
            r3 = 10
            r2.append(r3)     // Catch:{ all -> 0x0086 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0086 }
            r1.append(r2)     // Catch:{ all -> 0x0086 }
            boolean r1 = r11.m2958j()     // Catch:{ all -> 0x0086 }
            if (r1 == 0) goto L_0x0061
            java.util.concurrent.ThreadPoolExecutor r1 = m2953f()     // Catch:{ all -> 0x0086 }
            java.util.concurrent.Callable<java.lang.Void> r2 = r11.f2532r     // Catch:{ all -> 0x0086 }
            r1.submit(r2)     // Catch:{ all -> 0x0086 }
        L_0x0061:
            com.loc.ad$b r1 = new com.loc.ad$b     // Catch:{ all -> 0x0086 }
            long r6 = r0.f2551f     // Catch:{ all -> 0x0086 }
            long[] r9 = r0.f2548c     // Catch:{ all -> 0x0086 }
            r10 = 0
            r3 = r1
            r4 = r11
            r5 = r12
            r3.<init>(r4, r5, r6, r8, r9, r10)     // Catch:{ all -> 0x0086 }
            monitor-exit(r11)
            return r1
        L_0x0074:
            int r12 = r11.f2524i     // Catch:{ all -> 0x0086 }
            if (r2 >= r12) goto L_0x0084
            r12 = r8[r2]     // Catch:{ all -> 0x0086 }
            if (r12 == 0) goto L_0x0084
            r12 = r8[r2]     // Catch:{ all -> 0x0086 }
            com.loc.Util.m2992a((java.io.Closeable) r12)     // Catch:{ all -> 0x0086 }
            int r2 = r2 + 1
            goto L_0x0074
        L_0x0084:
            monitor-exit(r11)
            return r1
        L_0x0086:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.DiskLruCache.mo12971a(java.lang.String):com.loc.ad$b");
    }

    /* renamed from: a */
    public final void mo12972a(int i) {
        if (i < 10) {
            i = 10;
        } else if (i > 10000) {
            i = ComponentMessageType.MSG_TYPE_ON_SHAKE;
        }
        this.f2527l = i;
    }

    /* renamed from: b */
    public final C1044a mo12973b(String str) throws IOException {
        return m2947d(str);
    }

    /* renamed from: b */
    public final File mo12974b() {
        return this.f2518c;
    }

    /* renamed from: c */
    public final synchronized void mo12975c() throws IOException {
        m2959k();
        m2960l();
        this.f2526k.flush();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008c, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008e, code lost:
        return false;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean mo12976c(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            monitor-enter(r7)
            r7.m2959k()     // Catch:{ all -> 0x008f }
            m2951e((java.lang.String) r8)     // Catch:{ all -> 0x008f }
            java.util.LinkedHashMap<java.lang.String, com.loc.ad$c> r0 = r7.f2528m     // Catch:{ all -> 0x008f }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x008f }
            com.loc.ad$c r0 = (com.loc.DiskLruCache.C1047c) r0     // Catch:{ all -> 0x008f }
            r1 = 0
            if (r0 == 0) goto L_0x008d
            com.loc.ad$a r2 = r0.f2550e     // Catch:{ all -> 0x008f }
            if (r2 == 0) goto L_0x0019
            goto L_0x008d
        L_0x0019:
            int r2 = r7.f2524i     // Catch:{ all -> 0x008f }
            if (r1 >= r2) goto L_0x0059
            java.io.File r2 = r0.mo12991a((int) r1)     // Catch:{ all -> 0x008f }
            boolean r3 = r2.exists()     // Catch:{ all -> 0x008f }
            if (r3 == 0) goto L_0x0042
            boolean r3 = r2.delete()     // Catch:{ all -> 0x008f }
            if (r3 == 0) goto L_0x002e
            goto L_0x0042
        L_0x002e:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x008f }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x008f }
            java.lang.String r1 = "failed to delete "
            r0.<init>(r1)     // Catch:{ all -> 0x008f }
            r0.append(r2)     // Catch:{ all -> 0x008f }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x008f }
            r8.<init>(r0)     // Catch:{ all -> 0x008f }
            throw r8     // Catch:{ all -> 0x008f }
        L_0x0042:
            long r2 = r7.f2525j     // Catch:{ all -> 0x008f }
            long[] r4 = r0.f2548c     // Catch:{ all -> 0x008f }
            r5 = r4[r1]     // Catch:{ all -> 0x008f }
            r4 = 0
            long r2 = r2 - r5
            r7.f2525j = r2     // Catch:{ all -> 0x008f }
            long[] r2 = r0.f2548c     // Catch:{ all -> 0x008f }
            r3 = 0
            r2[r1] = r3     // Catch:{ all -> 0x008f }
            int r1 = r1 + 1
            goto L_0x0019
        L_0x0059:
            int r0 = r7.f2529n     // Catch:{ all -> 0x008f }
            r1 = 1
            int r0 = r0 + r1
            r7.f2529n = r0     // Catch:{ all -> 0x008f }
            java.io.Writer r0 = r7.f2526k     // Catch:{ all -> 0x008f }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x008f }
            java.lang.String r3 = "REMOVE "
            r2.<init>(r3)     // Catch:{ all -> 0x008f }
            r2.append(r8)     // Catch:{ all -> 0x008f }
            r3 = 10
            r2.append(r3)     // Catch:{ all -> 0x008f }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x008f }
            r0.append(r2)     // Catch:{ all -> 0x008f }
            java.util.LinkedHashMap<java.lang.String, com.loc.ad$c> r0 = r7.f2528m     // Catch:{ all -> 0x008f }
            r0.remove(r8)     // Catch:{ all -> 0x008f }
            boolean r8 = r7.m2958j()     // Catch:{ all -> 0x008f }
            if (r8 == 0) goto L_0x008b
            java.util.concurrent.ThreadPoolExecutor r8 = m2953f()     // Catch:{ all -> 0x008f }
            java.util.concurrent.Callable<java.lang.Void> r0 = r7.f2532r     // Catch:{ all -> 0x008f }
            r8.submit(r0)     // Catch:{ all -> 0x008f }
        L_0x008b:
            monitor-exit(r7)
            return r1
        L_0x008d:
            monitor-exit(r7)
            return r1
        L_0x008f:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.DiskLruCache.mo12976c(java.lang.String):boolean");
    }

    public final synchronized void close() throws IOException {
        if (this.f2526k != null) {
            Iterator it = new ArrayList(this.f2528m.values()).iterator();
            while (it.hasNext()) {
                C1047c cVar = (C1047c) it.next();
                if (cVar.f2550e != null) {
                    cVar.f2550e.mo12984c();
                }
            }
            m2960l();
            this.f2526k.close();
            this.f2526k = null;
        }
    }

    /* renamed from: d */
    public final void mo12978d() throws IOException {
        close();
        Util.m2993a(this.f2518c);
    }
}
