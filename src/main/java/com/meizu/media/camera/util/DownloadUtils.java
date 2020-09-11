package com.meizu.media.camera.util;

import com.meizu.media.camera.util.ThreadPool;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.URL;
import org.apache.http.client.methods.HttpGet;

/* renamed from: com.meizu.media.camera.util.r */
public class DownloadUtils {

    /* renamed from: a */
    public static ChangeQuickRedirect f14322a;

    /* renamed from: b */
    private static long[] f14323b = new long[256];

    /* renamed from: com.meizu.media.camera.util.r$a */
    /* compiled from: DownloadUtils */
    public interface C2656a {
        /* renamed from: a */
        HttpGet mo22746a(String str) throws Exception;
    }

    static {
        for (int i = 0; i < 256; i++) {
            long j = (long) i;
            for (int i2 = 0; i2 < 8; i2++) {
                j = (j >> 1) ^ ((((int) j) & 1) != 0 ? -7661587058870466123L : 0);
            }
            f14323b[i] = j;
        }
    }

    /* renamed from: a */
    public static boolean m16243a(ThreadPool.C2638c cVar, URL url, File file, C2656a aVar) {
        ChangeQuickRedirect changeQuickRedirect = f14322a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{cVar, url, file, aVar}, (Object) null, changeQuickRedirect, true, 8048, new Class[]{ThreadPool.C2638c.class, URL.class, File.class, C2656a.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                boolean a = m16244a(cVar, url, (OutputStream) fileOutputStream2, aVar);
                C2644av.m16096a((Closeable) fileOutputStream2);
                return a;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                C2644av.m16096a((Closeable) fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            C2644av.m16096a((Closeable) fileOutputStream);
            throw th;
        }
    }

    /* renamed from: a */
    public static boolean m16242a(ThreadPool.C2638c cVar, InputStream inputStream, OutputStream outputStream) throws IOException {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{cVar, inputStream, outputStream}, (Object) null, f14322a, true, 8049, new Class[]{ThreadPool.C2638c.class, InputStream.class, OutputStream.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        byte[] bArr = new byte[4096];
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read <= 0) {
            return false;
        }
        while (read > 0) {
            if (!cVar.mo22682b()) {
                outputStream.write(bArr, 0, read);
                read = inputStream.read(bArr, 0, bArr.length);
            } else {
                throw new InterruptedIOException();
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d9 A[SYNTHETIC, Splitter:B:44:0x00d9] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ed A[SYNTHETIC, Splitter:B:51:0x00ed] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m16244a(com.meizu.media.camera.util.ThreadPool.C2638c r9, java.net.URL r10, java.io.OutputStream r11, com.meizu.media.camera.util.DownloadUtils.C2656a r12) {
        /*
            r0 = 4
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r9
            r2 = 1
            r1[r2] = r10
            r3 = 2
            r1[r3] = r11
            r4 = 3
            r1[r4] = r12
            com.meizu.savior.ChangeQuickRedirect r5 = f14322a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<com.meizu.media.camera.util.aq$c> r0 = com.meizu.media.camera.util.ThreadPool.C2638c.class
            r6[r8] = r0
            java.lang.Class<java.net.URL> r0 = java.net.URL.class
            r6[r2] = r0
            java.lang.Class<java.io.OutputStream> r0 = java.io.OutputStream.class
            r6[r3] = r0
            java.lang.Class<com.meizu.media.camera.util.r$a> r0 = com.meizu.media.camera.util.DownloadUtils.C2656a.class
            r6[r4] = r0
            java.lang.Class r7 = java.lang.Boolean.TYPE
            r2 = 0
            r4 = 1
            r0 = 8051(0x1f73, float:1.1282E-41)
            r3 = r5
            r5 = r0
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r0.isSupported
            if (r1 == 0) goto L_0x003c
            java.lang.Object r9 = r0.result
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            return r9
        L_0x003c:
            r0 = 0
            org.apache.http.client.HttpClient r1 = com.meizu.media.camera.util.CustomerHttpClient.m16183a()     // Catch:{ Throwable -> 0x00b2, all -> 0x00ae }
            if (r12 == 0) goto L_0x004c
            java.lang.String r2 = r10.toString()     // Catch:{ Throwable -> 0x00b2, all -> 0x00ae }
            org.apache.http.client.methods.HttpGet r12 = r12.mo22746a(r2)     // Catch:{ Throwable -> 0x00b2, all -> 0x00ae }
            goto L_0x004d
        L_0x004c:
            r12 = r0
        L_0x004d:
            if (r12 != 0) goto L_0x0058
            org.apache.http.client.methods.HttpGet r12 = new org.apache.http.client.methods.HttpGet     // Catch:{ Throwable -> 0x00b2, all -> 0x00ae }
            java.net.URI r2 = r10.toURI()     // Catch:{ Throwable -> 0x00b2, all -> 0x00ae }
            r12.<init>(r2)     // Catch:{ Throwable -> 0x00b2, all -> 0x00ae }
        L_0x0058:
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ Throwable -> 0x00b2, all -> 0x00ae }
            com.meizu.media.camera.util.r$1 r3 = new com.meizu.media.camera.util.r$1     // Catch:{ Throwable -> 0x00b2, all -> 0x00ae }
            r3.<init>(r12, r2)     // Catch:{ Throwable -> 0x00b2, all -> 0x00ae }
            r9.mo22680a((com.meizu.media.camera.util.ThreadPool.C2636a) r3)     // Catch:{ Throwable -> 0x00b2, all -> 0x00ae }
            org.apache.http.HttpResponse r12 = r1.execute(r12)     // Catch:{ Throwable -> 0x00b2, all -> 0x00ae }
            org.apache.http.StatusLine r1 = r12.getStatusLine()     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
            int r1 = r1.getStatusCode()     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r1 != r2) goto L_0x0095
            org.apache.http.HttpEntity r1 = r12.getEntity()     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
            java.io.InputStream r1 = r1.getContent()     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
            boolean r11 = m16242a(r9, r1, r11)     // Catch:{ Throwable -> 0x0093 }
            if (r12 == 0) goto L_0x0089
            org.apache.http.HttpEntity r10 = r12.getEntity()     // Catch:{ IOException -> 0x0089 }
            r10.consumeContent()     // Catch:{ IOException -> 0x0089 }
        L_0x0089:
            com.meizu.media.camera.util.C2644av.m16096a((java.io.Closeable) r1)
            r9.mo22680a((com.meizu.media.camera.util.ThreadPool.C2636a) r0)
            java.lang.Thread.interrupted()
            return r11
        L_0x0093:
            r11 = move-exception
            goto L_0x00b5
        L_0x0095:
            if (r12 == 0) goto L_0x009e
            org.apache.http.HttpEntity r10 = r12.getEntity()     // Catch:{ IOException -> 0x009e }
            r10.consumeContent()     // Catch:{ IOException -> 0x009e }
        L_0x009e:
            com.meizu.media.camera.util.C2644av.m16096a((java.io.Closeable) r0)
            r9.mo22680a((com.meizu.media.camera.util.ThreadPool.C2636a) r0)
            java.lang.Thread.interrupted()
            return r8
        L_0x00a8:
            r10 = move-exception
            r1 = r0
            goto L_0x00eb
        L_0x00ab:
            r11 = move-exception
            r1 = r0
            goto L_0x00b5
        L_0x00ae:
            r10 = move-exception
            r12 = r0
            r1 = r12
            goto L_0x00eb
        L_0x00b2:
            r11 = move-exception
            r12 = r0
            r1 = r12
        L_0x00b5:
            java.lang.String r2 = "DownloadService"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ea }
            r3.<init>()     // Catch:{ all -> 0x00ea }
            java.lang.String r4 = "fail to download: "
            r3.append(r4)     // Catch:{ all -> 0x00ea }
            r3.append(r10)     // Catch:{ all -> 0x00ea }
            java.lang.String r10 = ", "
            r3.append(r10)     // Catch:{ all -> 0x00ea }
            java.lang.String r10 = r11.getMessage()     // Catch:{ all -> 0x00ea }
            r3.append(r10)     // Catch:{ all -> 0x00ea }
            java.lang.String r10 = r3.toString()     // Catch:{ all -> 0x00ea }
            android.util.Log.w(r2, r10)     // Catch:{ all -> 0x00ea }
            if (r12 == 0) goto L_0x00e0
            org.apache.http.HttpEntity r10 = r12.getEntity()     // Catch:{ IOException -> 0x00e0 }
            r10.consumeContent()     // Catch:{ IOException -> 0x00e0 }
        L_0x00e0:
            com.meizu.media.camera.util.C2644av.m16096a((java.io.Closeable) r1)
            r9.mo22680a((com.meizu.media.camera.util.ThreadPool.C2636a) r0)
            java.lang.Thread.interrupted()
            return r8
        L_0x00ea:
            r10 = move-exception
        L_0x00eb:
            if (r12 == 0) goto L_0x00f4
            org.apache.http.HttpEntity r11 = r12.getEntity()     // Catch:{ IOException -> 0x00f4 }
            r11.consumeContent()     // Catch:{ IOException -> 0x00f4 }
        L_0x00f4:
            com.meizu.media.camera.util.C2644av.m16096a((java.io.Closeable) r1)
            r9.mo22680a((com.meizu.media.camera.util.ThreadPool.C2636a) r0)
            java.lang.Thread.interrupted()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.DownloadUtils.m16244a(com.meizu.media.camera.util.aq$c, java.net.URL, java.io.OutputStream, com.meizu.media.camera.util.r$a):boolean");
    }
}
