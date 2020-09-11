package com.android.volley.toolbox;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.android.volley.Cache;
import com.android.volley.Header;
import com.android.volley.VolleyLog;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.android.volley.toolbox.e */
public class DiskBasedCache implements Cache {

    /* renamed from: a */
    private final Map<String, C0456a> f368a;

    /* renamed from: b */
    private long f369b;

    /* renamed from: c */
    private final File f370c;

    /* renamed from: d */
    private final int f371d;

    public DiskBasedCache(File file, int i) {
        this.f368a = new LinkedHashMap(16, 0.75f, true);
        this.f369b = 0;
        this.f370c = file;
        this.f371d = i;
    }

    public DiskBasedCache(File file) {
        this(file, 5242880);
    }

    /* renamed from: a */
    public synchronized Cache.C0443a mo8676a(String str) {
        C0457b bVar;
        C0456a aVar = this.f368a.get(str);
        if (aVar == null) {
            return null;
        }
        File c = mo8734c(str);
        try {
            bVar = new C0457b(new BufferedInputStream(mo8731a(c)), c.length());
            C0456a a = C0456a.m658a(bVar);
            if (!TextUtils.equals(str, a.f373b)) {
                VolleyLog.m728b("%s: key=%s, found=%s", c.getAbsolutePath(), str, a.f373b);
                m650e(str);
                bVar.close();
                return null;
            }
            Cache.C0443a a2 = aVar.mo8735a(m645a(bVar, bVar.mo8737a()));
            bVar.close();
            return a2;
        } catch (IOException e) {
            VolleyLog.m728b("%s: %s", c.getAbsolutePath(), e.toString());
            mo8733b(str);
            return null;
        } catch (Throwable th) {
            bVar.close();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0059 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo8677a() {
        /*
            r9 = this;
            monitor-enter(r9)
            java.io.File r0 = r9.f370c     // Catch:{ all -> 0x0061 }
            boolean r0 = r0.exists()     // Catch:{ all -> 0x0061 }
            r1 = 0
            if (r0 != 0) goto L_0x0024
            java.io.File r0 = r9.f370c     // Catch:{ all -> 0x0061 }
            boolean r0 = r0.mkdirs()     // Catch:{ all -> 0x0061 }
            if (r0 != 0) goto L_0x0022
            java.lang.String r0 = "Unable to create cache dir %s"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0061 }
            java.io.File r3 = r9.f370c     // Catch:{ all -> 0x0061 }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x0061 }
            r2[r1] = r3     // Catch:{ all -> 0x0061 }
            com.android.volley.VolleyLog.m729c(r0, r2)     // Catch:{ all -> 0x0061 }
        L_0x0022:
            monitor-exit(r9)
            return
        L_0x0024:
            java.io.File r0 = r9.f370c     // Catch:{ all -> 0x0061 }
            java.io.File[] r0 = r0.listFiles()     // Catch:{ all -> 0x0061 }
            if (r0 != 0) goto L_0x002e
            monitor-exit(r9)
            return
        L_0x002e:
            int r2 = r0.length     // Catch:{ all -> 0x0061 }
        L_0x002f:
            if (r1 >= r2) goto L_0x005f
            r3 = r0[r1]     // Catch:{ all -> 0x0061 }
            long r4 = r3.length()     // Catch:{ IOException -> 0x0059 }
            com.android.volley.toolbox.e$b r6 = new com.android.volley.toolbox.e$b     // Catch:{ IOException -> 0x0059 }
            java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0059 }
            java.io.InputStream r8 = r9.mo8731a((java.io.File) r3)     // Catch:{ IOException -> 0x0059 }
            r7.<init>(r8)     // Catch:{ IOException -> 0x0059 }
            r6.<init>(r7, r4)     // Catch:{ IOException -> 0x0059 }
            com.android.volley.toolbox.e$a r7 = com.android.volley.toolbox.DiskBasedCache.C0456a.m658a((com.android.volley.toolbox.DiskBasedCache.C0457b) r6)     // Catch:{ all -> 0x0054 }
            r7.f372a = r4     // Catch:{ all -> 0x0054 }
            java.lang.String r4 = r7.f373b     // Catch:{ all -> 0x0054 }
            r9.m643a((java.lang.String) r4, (com.android.volley.toolbox.DiskBasedCache.C0456a) r7)     // Catch:{ all -> 0x0054 }
            r6.close()     // Catch:{ IOException -> 0x0059 }
            goto L_0x005c
        L_0x0054:
            r4 = move-exception
            r6.close()     // Catch:{ IOException -> 0x0059 }
            throw r4     // Catch:{ IOException -> 0x0059 }
        L_0x0059:
            r3.delete()     // Catch:{ all -> 0x0061 }
        L_0x005c:
            int r1 = r1 + 1
            goto L_0x002f
        L_0x005f:
            monitor-exit(r9)
            return
        L_0x0061:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.DiskBasedCache.mo8677a():void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:13|14|(1:16)|17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0048, code lost:
        if (r0.delete() == false) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004a, code lost:
        com.android.volley.VolleyLog.m728b("Could not clean up file %s", r0.getAbsolutePath());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0058, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0044 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo8678a(java.lang.String r7, com.android.volley.Cache.C0443a r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            byte[] r0 = r8.f289a     // Catch:{ all -> 0x0059 }
            int r0 = r0.length     // Catch:{ all -> 0x0059 }
            r6.m639a((int) r0)     // Catch:{ all -> 0x0059 }
            java.io.File r0 = r6.mo8734c((java.lang.String) r7)     // Catch:{ all -> 0x0059 }
            r1 = 0
            r2 = 1
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0044 }
            java.io.OutputStream r4 = r6.mo8732b((java.io.File) r0)     // Catch:{ IOException -> 0x0044 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0044 }
            com.android.volley.toolbox.e$a r4 = new com.android.volley.toolbox.e$a     // Catch:{ IOException -> 0x0044 }
            r4.<init>(r7, r8)     // Catch:{ IOException -> 0x0044 }
            boolean r5 = r4.mo8736a((java.io.OutputStream) r3)     // Catch:{ IOException -> 0x0044 }
            if (r5 == 0) goto L_0x002e
            byte[] r8 = r8.f289a     // Catch:{ IOException -> 0x0044 }
            r3.write(r8)     // Catch:{ IOException -> 0x0044 }
            r3.close()     // Catch:{ IOException -> 0x0044 }
            r6.m643a((java.lang.String) r7, (com.android.volley.toolbox.DiskBasedCache.C0456a) r4)     // Catch:{ IOException -> 0x0044 }
            monitor-exit(r6)
            return
        L_0x002e:
            r3.close()     // Catch:{ IOException -> 0x0044 }
            java.lang.String r7 = "Failed to write header for %s"
            java.lang.Object[] r8 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x0044 }
            java.lang.String r3 = r0.getAbsolutePath()     // Catch:{ IOException -> 0x0044 }
            r8[r1] = r3     // Catch:{ IOException -> 0x0044 }
            com.android.volley.VolleyLog.m728b(r7, r8)     // Catch:{ IOException -> 0x0044 }
            java.io.IOException r7 = new java.io.IOException     // Catch:{ IOException -> 0x0044 }
            r7.<init>()     // Catch:{ IOException -> 0x0044 }
            throw r7     // Catch:{ IOException -> 0x0044 }
        L_0x0044:
            boolean r7 = r0.delete()     // Catch:{ all -> 0x0059 }
            if (r7 != 0) goto L_0x0057
            java.lang.String r7 = "Could not clean up file %s"
            java.lang.Object[] r8 = new java.lang.Object[r2]     // Catch:{ all -> 0x0059 }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x0059 }
            r8[r1] = r0     // Catch:{ all -> 0x0059 }
            com.android.volley.VolleyLog.m728b(r7, r8)     // Catch:{ all -> 0x0059 }
        L_0x0057:
            monitor-exit(r6)
            return
        L_0x0059:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.DiskBasedCache.mo8678a(java.lang.String, com.android.volley.b$a):void");
    }

    /* renamed from: b */
    public synchronized void mo8733b(String str) {
        boolean delete = mo8734c(str).delete();
        m650e(str);
        if (!delete) {
            VolleyLog.m728b("Could not delete cache entry for key=%s, filename=%s", str, m649d(str));
        }
    }

    /* renamed from: d */
    private String m649d(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(str.substring(0, length).hashCode());
        return valueOf + String.valueOf(str.substring(length).hashCode());
    }

    /* renamed from: c */
    public File mo8734c(String str) {
        return new File(this.f370c, m649d(str));
    }

    /* renamed from: a */
    private void m639a(int i) {
        long j;
        long j2 = (long) i;
        if (this.f369b + j2 >= ((long) this.f371d)) {
            if (VolleyLog.f420b) {
                VolleyLog.m726a("Pruning old cache entries.", new Object[0]);
            }
            long j3 = this.f369b;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator<Map.Entry<String, C0456a>> it = this.f368a.entrySet().iterator();
            int i2 = 0;
            while (it.hasNext()) {
                C0456a aVar = (C0456a) it.next().getValue();
                if (mo8734c(aVar.f373b).delete()) {
                    j = j2;
                    this.f369b -= aVar.f372a;
                } else {
                    j = j2;
                    VolleyLog.m728b("Could not delete cache entry for key=%s, filename=%s", aVar.f373b, m649d(aVar.f373b));
                }
                it.remove();
                i2++;
                if (((float) (this.f369b + j)) < ((float) this.f371d) * 0.9f) {
                    break;
                }
                j2 = j;
            }
            if (VolleyLog.f420b) {
                VolleyLog.m726a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.f369b - j3), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
    }

    /* renamed from: a */
    private void m643a(String str, C0456a aVar) {
        if (!this.f368a.containsKey(str)) {
            this.f369b += aVar.f372a;
        } else {
            this.f369b += aVar.f372a - this.f368a.get(str).f372a;
        }
        this.f368a.put(str, aVar);
    }

    /* renamed from: e */
    private void m650e(String str) {
        C0456a remove = this.f368a.remove(str);
        if (remove != null) {
            this.f369b -= remove.f372a;
        }
    }

    /* renamed from: a */
    static byte[] m645a(C0457b bVar, long j) throws IOException {
        long a = bVar.mo8737a();
        if (j >= 0 && j <= a) {
            int i = (int) j;
            if (((long) i) == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(bVar).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j + ", maxLength=" + a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public InputStream mo8731a(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public OutputStream mo8732b(File file) throws FileNotFoundException {
        return new FileOutputStream(file);
    }

    /* renamed from: com.android.volley.toolbox.e$a */
    /* compiled from: DiskBasedCache */
    static class C0456a {

        /* renamed from: a */
        long f372a;

        /* renamed from: b */
        final String f373b;

        /* renamed from: c */
        final String f374c;

        /* renamed from: d */
        final long f375d;

        /* renamed from: e */
        final long f376e;

        /* renamed from: f */
        final long f377f;

        /* renamed from: g */
        final long f378g;

        /* renamed from: h */
        final List<Header> f379h;

        private C0456a(String str, String str2, long j, long j2, long j3, long j4, List<Header> list) {
            this.f373b = str;
            this.f374c = "".equals(str2) ? null : str2;
            this.f375d = j;
            this.f376e = j2;
            this.f377f = j3;
            this.f378g = j4;
            this.f379h = list;
        }

        C0456a(String str, Cache.C0443a aVar) {
            this(str, aVar.f290b, aVar.f291c, aVar.f292d, aVar.f293e, aVar.f294f, m659a(aVar));
            this.f372a = (long) aVar.f289a.length;
        }

        /* renamed from: a */
        private static List<Header> m659a(Cache.C0443a aVar) {
            if (aVar.f296h != null) {
                return aVar.f296h;
            }
            return HttpHeaderParser.m675b(aVar.f295g);
        }

        /* renamed from: a */
        static C0456a m658a(C0457b bVar) throws IOException {
            if (DiskBasedCache.m637a((InputStream) bVar) == 538247942) {
                return new C0456a(DiskBasedCache.m638a(bVar), DiskBasedCache.m638a(bVar), DiskBasedCache.m646b((InputStream) bVar), DiskBasedCache.m646b((InputStream) bVar), DiskBasedCache.m646b((InputStream) bVar), DiskBasedCache.m646b((InputStream) bVar), DiskBasedCache.m647b(bVar));
            }
            throw new IOException();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public Cache.C0443a mo8735a(byte[] bArr) {
            Cache.C0443a aVar = new Cache.C0443a();
            aVar.f289a = bArr;
            aVar.f290b = this.f374c;
            aVar.f291c = this.f375d;
            aVar.f292d = this.f376e;
            aVar.f293e = this.f377f;
            aVar.f294f = this.f378g;
            aVar.f295g = HttpHeaderParser.m674a(this.f379h);
            aVar.f296h = Collections.unmodifiableList(this.f379h);
            return aVar;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo8736a(OutputStream outputStream) {
            try {
                DiskBasedCache.m640a(outputStream, 538247942);
                DiskBasedCache.m642a(outputStream, this.f373b);
                DiskBasedCache.m642a(outputStream, this.f374c == null ? "" : this.f374c);
                DiskBasedCache.m641a(outputStream, this.f375d);
                DiskBasedCache.m641a(outputStream, this.f376e);
                DiskBasedCache.m641a(outputStream, this.f377f);
                DiskBasedCache.m641a(outputStream, this.f378g);
                DiskBasedCache.m644a(this.f379h, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                VolleyLog.m728b("%s", e.toString());
                return false;
            }
        }
    }

    @VisibleForTesting
    /* renamed from: com.android.volley.toolbox.e$b */
    /* compiled from: DiskBasedCache */
    static class C0457b extends FilterInputStream {

        /* renamed from: a */
        private final long f380a;

        /* renamed from: b */
        private long f381b;

        C0457b(InputStream inputStream, long j) {
            super(inputStream);
            this.f380a = j;
        }

        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.f381b++;
            }
            return read;
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.f381b += (long) read;
            }
            return read;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public long mo8737a() {
            return this.f380a - this.f381b;
        }
    }

    /* renamed from: c */
    private static int m648c(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    /* renamed from: a */
    static void m640a(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    /* renamed from: a */
    static int m637a(InputStream inputStream) throws IOException {
        return (m648c(inputStream) << 24) | (m648c(inputStream) << 0) | 0 | (m648c(inputStream) << 8) | (m648c(inputStream) << 16);
    }

    /* renamed from: a */
    static void m641a(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) ((int) (j >>> 0)));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    /* renamed from: b */
    static long m646b(InputStream inputStream) throws IOException {
        return ((((long) m648c(inputStream)) & 255) << 0) | 0 | ((((long) m648c(inputStream)) & 255) << 8) | ((((long) m648c(inputStream)) & 255) << 16) | ((((long) m648c(inputStream)) & 255) << 24) | ((((long) m648c(inputStream)) & 255) << 32) | ((((long) m648c(inputStream)) & 255) << 40) | ((((long) m648c(inputStream)) & 255) << 48) | ((255 & ((long) m648c(inputStream))) << 56);
    }

    /* renamed from: a */
    static void m642a(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        m641a(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    /* renamed from: a */
    static String m638a(C0457b bVar) throws IOException {
        return new String(m645a(bVar, m646b((InputStream) bVar)), "UTF-8");
    }

    /* renamed from: a */
    static void m644a(List<Header> list, OutputStream outputStream) throws IOException {
        if (list != null) {
            m640a(outputStream, list.size());
            for (Header next : list) {
                m642a(outputStream, next.mo8694a());
                m642a(outputStream, next.mo8695b());
            }
            return;
        }
        m640a(outputStream, 0);
    }

    /* renamed from: b */
    static List<Header> m647b(C0457b bVar) throws IOException {
        int a = m637a((InputStream) bVar);
        if (a >= 0) {
            List<Header> emptyList = a == 0 ? Collections.emptyList() : new ArrayList<>();
            for (int i = 0; i < a; i++) {
                emptyList.add(new Header(m638a(bVar).intern(), m638a(bVar).intern()));
            }
            return emptyList;
        }
        throw new IOException("readHeaderList size=" + a);
    }
}
