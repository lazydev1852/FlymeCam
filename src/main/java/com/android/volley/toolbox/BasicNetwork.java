package com.android.volley.toolbox;

import com.android.volley.Cache;
import com.android.volley.Header;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* renamed from: com.android.volley.toolbox.c */
public class BasicNetwork implements Network {

    /* renamed from: a */
    protected static final boolean f359a = VolleyLog.f420b;
    @Deprecated

    /* renamed from: b */
    protected final HttpStack f360b;

    /* renamed from: c */
    protected final ByteArrayPool f361c;

    /* renamed from: d */
    private final BaseHttpStack f362d;

    @Deprecated
    public BasicNetwork(HttpStack iVar) {
        this(iVar, new ByteArrayPool(4096));
    }

    @Deprecated
    public BasicNetwork(HttpStack iVar, ByteArrayPool dVar) {
        this.f360b = iVar;
        this.f362d = new AdaptedHttpStack(iVar);
        this.f361c = dVar;
    }

    public BasicNetwork(BaseHttpStack bVar) {
        this(bVar, new ByteArrayPool(4096));
    }

    public BasicNetwork(BaseHttpStack bVar, ByteArrayPool dVar) {
        this.f362d = bVar;
        this.f360b = bVar;
        this.f361c = dVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0060, code lost:
        r15 = null;
        r19 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ad, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00af, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b0, code lost:
        r1 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b1, code lost:
        r19 = r1;
        r15 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b6, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b7, code lost:
        r1 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00be, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00bf, code lost:
        r19 = r1;
        r12 = null;
        r15 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00c5, code lost:
        r0 = r12.mo8742a();
        com.android.volley.VolleyLog.m729c("Unexpected response code %d for %s", java.lang.Integer.valueOf(r0), r29.getUrl());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00de, code lost:
        if (r15 != null) goto L_0x00e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e0, code lost:
        r13 = new com.android.volley.NetworkResponse(r0, r15, false, android.os.SystemClock.elapsedRealtime() - r9, r19);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00f1, code lost:
        if (r0 == 401) goto L_0x012d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00fa, code lost:
        if (r0 < 400) goto L_0x0107;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0106, code lost:
        throw new com.android.volley.ClientError(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0109, code lost:
        if (r0 < 500) goto L_0x0127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0113, code lost:
        if (r29.shouldRetryServerErrors() != false) goto L_0x0115;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0115, code lost:
        m630a("server", r8, new com.android.volley.ServerError(r13));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0126, code lost:
        throw new com.android.volley.ServerError(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x012c, code lost:
        throw new com.android.volley.ServerError(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x012d, code lost:
        m630a("auth", r8, new com.android.volley.AuthFailureError(r13));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0139, code lost:
        m630a(com.meizu.statsapp.p081v3.lib.plugin.constants.Parameters.NETWORK, r8, new com.android.volley.NetworkError());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x014a, code lost:
        throw new com.android.volley.NoConnectionError(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x014b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0166, code lost:
        throw new java.lang.RuntimeException("Bad URL " + r29.getUrl(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0167, code lost:
        m630a("socket", r8, new com.android.volley.TimeoutError());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x014b A[ExcHandler: MalformedURLException (r0v1 'e' java.net.MalformedURLException A[CUSTOM_DECLARE]), Splitter:B:2:0x000e] */
    /* JADX WARNING: Removed duplicated region for block: B:79:? A[ExcHandler: SocketTimeoutException (unused java.net.SocketTimeoutException), SYNTHETIC, Splitter:B:2:0x000e] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0145 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.android.volley.NetworkResponse mo8699a(com.android.volley.Request<?> r29) throws com.android.volley.VolleyError {
        /*
            r28 = this;
            r7 = r28
            r8 = r29
            long r9 = android.os.SystemClock.elapsedRealtime()
        L_0x0008:
            java.util.List r1 = java.util.Collections.emptyList()
            r11 = 0
            r2 = 0
            com.android.volley.b$a r0 = r29.getCacheEntry()     // Catch:{ SocketTimeoutException -> 0x0167, MalformedURLException -> 0x014b, IOException -> 0x00be }
            java.util.Map r0 = r7.m628a((com.android.volley.Cache.C0443a) r0)     // Catch:{ SocketTimeoutException -> 0x0167, MalformedURLException -> 0x014b, IOException -> 0x00be }
            com.android.volley.toolbox.b r3 = r7.f362d     // Catch:{ SocketTimeoutException -> 0x0167, MalformedURLException -> 0x014b, IOException -> 0x00be }
            com.android.volley.toolbox.h r12 = r3.mo8725a(r8, r0)     // Catch:{ SocketTimeoutException -> 0x0167, MalformedURLException -> 0x014b, IOException -> 0x00be }
            int r14 = r12.mo8742a()     // Catch:{ SocketTimeoutException -> 0x0167, MalformedURLException -> 0x014b, IOException -> 0x00b9 }
            java.util.List r13 = r12.mo8743b()     // Catch:{ SocketTimeoutException -> 0x0167, MalformedURLException -> 0x014b, IOException -> 0x00b9 }
            r0 = 304(0x130, float:4.26E-43)
            if (r14 != r0) goto L_0x0065
            com.android.volley.b$a r0 = r29.getCacheEntry()     // Catch:{ SocketTimeoutException -> 0x0167, MalformedURLException -> 0x014b, IOException -> 0x005f }
            if (r0 != 0) goto L_0x0044
            com.android.volley.k r0 = new com.android.volley.k     // Catch:{ SocketTimeoutException -> 0x0167, MalformedURLException -> 0x014b, IOException -> 0x005f }
            r16 = 304(0x130, float:4.26E-43)
            r17 = 0
            r18 = 1
            long r3 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0167, MalformedURLException -> 0x014b, IOException -> 0x005f }
            r1 = 0
            long r19 = r3 - r9
            r15 = r0
            r21 = r13
            r15.<init>((int) r16, (byte[]) r17, (boolean) r18, (long) r19, (java.util.List<com.android.volley.Header>) r21)     // Catch:{ SocketTimeoutException -> 0x0167, MalformedURLException -> 0x014b, IOException -> 0x005f }
            return r0
        L_0x0044:
            java.util.List r27 = m627a((java.util.List<com.android.volley.Header>) r13, (com.android.volley.Cache.C0443a) r0)     // Catch:{ SocketTimeoutException -> 0x0167, MalformedURLException -> 0x014b, IOException -> 0x005f }
            com.android.volley.k r1 = new com.android.volley.k     // Catch:{ SocketTimeoutException -> 0x0167, MalformedURLException -> 0x014b, IOException -> 0x005f }
            r22 = 304(0x130, float:4.26E-43)
            byte[] r0 = r0.f289a     // Catch:{ SocketTimeoutException -> 0x0167, MalformedURLException -> 0x014b, IOException -> 0x005f }
            r24 = 1
            long r3 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0167, MalformedURLException -> 0x014b, IOException -> 0x005f }
            r5 = 0
            long r25 = r3 - r9
            r21 = r1
            r23 = r0
            r21.<init>((int) r22, (byte[]) r23, (boolean) r24, (long) r25, (java.util.List<com.android.volley.Header>) r27)     // Catch:{ SocketTimeoutException -> 0x0167, MalformedURLException -> 0x014b, IOException -> 0x005f }
            return r1
        L_0x005f:
            r0 = move-exception
            r15 = r2
            r19 = r13
            goto L_0x00c3
        L_0x0065:
            java.io.InputStream r0 = r12.mo8745d()     // Catch:{ SocketTimeoutException -> 0x0167, MalformedURLException -> 0x014b, IOException -> 0x00b6 }
            if (r0 == 0) goto L_0x0074
            int r1 = r12.mo8744c()     // Catch:{ SocketTimeoutException -> 0x0167, MalformedURLException -> 0x014b, IOException -> 0x005f }
            byte[] r0 = r7.m631a((java.io.InputStream) r0, (int) r1)     // Catch:{ SocketTimeoutException -> 0x0167, MalformedURLException -> 0x014b, IOException -> 0x005f }
            goto L_0x0076
        L_0x0074:
            byte[] r0 = new byte[r11]     // Catch:{ SocketTimeoutException -> 0x0167, MalformedURLException -> 0x014b, IOException -> 0x00b6 }
        L_0x0076:
            r20 = r0
            long r0 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0167, MalformedURLException -> 0x014b, IOException -> 0x00af }
            r2 = 0
            long r2 = r0 - r9
            r1 = r28
            r4 = r29
            r5 = r20
            r6 = r14
            r1.m629a(r2, r4, r5, r6)     // Catch:{ SocketTimeoutException -> 0x0167, MalformedURLException -> 0x014b, IOException -> 0x00af }
            r0 = 200(0xc8, float:2.8E-43)
            if (r14 < r0) goto L_0x00a6
            r0 = 299(0x12b, float:4.19E-43)
            if (r14 > r0) goto L_0x00a6
            com.android.volley.k r0 = new com.android.volley.k     // Catch:{ SocketTimeoutException -> 0x0167, MalformedURLException -> 0x014b, IOException -> 0x00af }
            r16 = 0
            long r1 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0167, MalformedURLException -> 0x014b, IOException -> 0x00af }
            r3 = 0
            long r17 = r1 - r9
            r1 = r13
            r13 = r0
            r15 = r20
            r19 = r1
            r13.<init>((int) r14, (byte[]) r15, (boolean) r16, (long) r17, (java.util.List<com.android.volley.Header>) r19)     // Catch:{ SocketTimeoutException -> 0x0167, MalformedURLException -> 0x014b, IOException -> 0x00ad }
            return r0
        L_0x00a6:
            r1 = r13
            java.io.IOException r0 = new java.io.IOException     // Catch:{ SocketTimeoutException -> 0x0167, MalformedURLException -> 0x014b, IOException -> 0x00ad }
            r0.<init>()     // Catch:{ SocketTimeoutException -> 0x0167, MalformedURLException -> 0x014b, IOException -> 0x00ad }
            throw r0     // Catch:{ SocketTimeoutException -> 0x0167, MalformedURLException -> 0x014b, IOException -> 0x00ad }
        L_0x00ad:
            r0 = move-exception
            goto L_0x00b1
        L_0x00af:
            r0 = move-exception
            r1 = r13
        L_0x00b1:
            r19 = r1
            r15 = r20
            goto L_0x00c3
        L_0x00b6:
            r0 = move-exception
            r1 = r13
            goto L_0x00ba
        L_0x00b9:
            r0 = move-exception
        L_0x00ba:
            r19 = r1
            r15 = r2
            goto L_0x00c3
        L_0x00be:
            r0 = move-exception
            r19 = r1
            r12 = r2
            r15 = r12
        L_0x00c3:
            if (r12 == 0) goto L_0x0145
            int r0 = r12.mo8742a()
            java.lang.String r1 = "Unexpected response code %d for %s"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            r2[r11] = r3
            r3 = 1
            java.lang.String r4 = r29.getUrl()
            r2[r3] = r4
            com.android.volley.VolleyLog.m729c(r1, r2)
            if (r15 == 0) goto L_0x0139
            com.android.volley.k r1 = new com.android.volley.k
            r16 = 0
            long r2 = android.os.SystemClock.elapsedRealtime()
            long r17 = r2 - r9
            r13 = r1
            r14 = r0
            r13.<init>((int) r14, (byte[]) r15, (boolean) r16, (long) r17, (java.util.List<com.android.volley.Header>) r19)
            r2 = 401(0x191, float:5.62E-43)
            if (r0 == r2) goto L_0x012d
            r2 = 403(0x193, float:5.65E-43)
            if (r0 != r2) goto L_0x00f8
            goto L_0x012d
        L_0x00f8:
            r2 = 400(0x190, float:5.6E-43)
            if (r0 < r2) goto L_0x0107
            r2 = 499(0x1f3, float:6.99E-43)
            if (r0 <= r2) goto L_0x0101
            goto L_0x0107
        L_0x0101:
            com.android.volley.d r0 = new com.android.volley.d
            r0.<init>(r1)
            throw r0
        L_0x0107:
            r2 = 500(0x1f4, float:7.0E-43)
            if (r0 < r2) goto L_0x0127
            r2 = 599(0x257, float:8.4E-43)
            if (r0 > r2) goto L_0x0127
            boolean r0 = r29.shouldRetryServerErrors()
            if (r0 == 0) goto L_0x0121
            java.lang.String r0 = "server"
            com.android.volley.r r2 = new com.android.volley.r
            r2.<init>(r1)
            m630a(r0, r8, r2)
            goto L_0x0008
        L_0x0121:
            com.android.volley.r r0 = new com.android.volley.r
            r0.<init>(r1)
            throw r0
        L_0x0127:
            com.android.volley.r r0 = new com.android.volley.r
            r0.<init>(r1)
            throw r0
        L_0x012d:
            java.lang.String r0 = "auth"
            com.android.volley.a r2 = new com.android.volley.a
            r2.<init>(r1)
            m630a(r0, r8, r2)
            goto L_0x0008
        L_0x0139:
            java.lang.String r0 = "network"
            com.android.volley.j r1 = new com.android.volley.j
            r1.<init>()
            m630a(r0, r8, r1)
            goto L_0x0008
        L_0x0145:
            com.android.volley.l r1 = new com.android.volley.l
            r1.<init>(r0)
            throw r1
        L_0x014b:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Bad URL "
            r2.append(r3)
            java.lang.String r3 = r29.getUrl()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2, r0)
            throw r1
        L_0x0167:
            java.lang.String r0 = "socket"
            com.android.volley.s r1 = new com.android.volley.s
            r1.<init>()
            m630a(r0, r8, r1)
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.BasicNetwork.mo8699a(com.android.volley.Request):com.android.volley.k");
    }

    /* renamed from: a */
    private void m629a(long j, Request<?> request, byte[] bArr, int i) {
        if (f359a || j > 3000) {
            Object[] objArr = new Object[5];
            objArr[0] = request;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(i);
            objArr[4] = Integer.valueOf(request.getRetryPolicy().mo8687b());
            VolleyLog.m728b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    /* renamed from: a */
    private static void m630a(String str, Request<?> request, VolleyError tVar) throws VolleyError {
        RetryPolicy retryPolicy = request.getRetryPolicy();
        int timeoutMs = request.getTimeoutMs();
        try {
            retryPolicy.mo8686a(tVar);
            request.addMarker(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(timeoutMs)}));
        } catch (VolleyError e) {
            request.addMarker(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str, Integer.valueOf(timeoutMs)}));
            throw e;
        }
    }

    /* renamed from: a */
    private Map<String, String> m628a(Cache.C0443a aVar) {
        if (aVar == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        if (aVar.f290b != null) {
            hashMap.put("If-None-Match", aVar.f290b);
        }
        if (aVar.f292d > 0) {
            hashMap.put("If-Modified-Since", HttpHeaderParser.m670a(aVar.f292d));
        }
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0046 A[SYNTHETIC, Splitter:B:23:0x0046] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] m631a(java.io.InputStream r6, int r7) throws java.io.IOException, com.android.volley.ServerError {
        /*
            r5 = this;
            com.android.volley.toolbox.m r0 = new com.android.volley.toolbox.m
            com.android.volley.toolbox.d r1 = r5.f361c
            r0.<init>(r1, r7)
            r7 = 0
            r1 = 0
            if (r6 == 0) goto L_0x003d
            com.android.volley.toolbox.d r2 = r5.f361c     // Catch:{ all -> 0x0043 }
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r2 = r2.mo8728a((int) r3)     // Catch:{ all -> 0x0043 }
        L_0x0013:
            int r1 = r6.read(r2)     // Catch:{ all -> 0x0038 }
            r3 = -1
            if (r1 == r3) goto L_0x001e
            r0.write(r2, r7, r1)     // Catch:{ all -> 0x0038 }
            goto L_0x0013
        L_0x001e:
            byte[] r1 = r0.toByteArray()     // Catch:{ all -> 0x0038 }
            if (r6 == 0) goto L_0x002f
            r6.close()     // Catch:{ IOException -> 0x0028 }
            goto L_0x002f
        L_0x0028:
            java.lang.String r6 = "Error occurred when closing InputStream"
            java.lang.Object[] r7 = new java.lang.Object[r7]
            com.android.volley.VolleyLog.m726a(r6, r7)
        L_0x002f:
            com.android.volley.toolbox.d r6 = r5.f361c
            r6.mo8727a((byte[]) r2)
            r0.close()
            return r1
        L_0x0038:
            r1 = move-exception
            r4 = r2
            r2 = r1
            r1 = r4
            goto L_0x0044
        L_0x003d:
            com.android.volley.r r2 = new com.android.volley.r     // Catch:{ all -> 0x0043 }
            r2.<init>()     // Catch:{ all -> 0x0043 }
            throw r2     // Catch:{ all -> 0x0043 }
        L_0x0043:
            r2 = move-exception
        L_0x0044:
            if (r6 == 0) goto L_0x0051
            r6.close()     // Catch:{ IOException -> 0x004a }
            goto L_0x0051
        L_0x004a:
            java.lang.Object[] r6 = new java.lang.Object[r7]
            java.lang.String r7 = "Error occurred when closing InputStream"
            com.android.volley.VolleyLog.m726a(r7, r6)
        L_0x0051:
            com.android.volley.toolbox.d r6 = r5.f361c
            r6.mo8727a((byte[]) r1)
            r0.close()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.BasicNetwork.m631a(java.io.InputStream, int):byte[]");
    }

    /* renamed from: a */
    private static List<Header> m627a(List<Header> list, Cache.C0443a aVar) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            for (Header a : list) {
                treeSet.add(a.mo8694a());
            }
        }
        ArrayList arrayList = new ArrayList(list);
        if (aVar.f296h != null) {
            if (!aVar.f296h.isEmpty()) {
                for (Header next : aVar.f296h) {
                    if (!treeSet.contains(next.mo8694a())) {
                        arrayList.add(next);
                    }
                }
            }
        } else if (!aVar.f295g.isEmpty()) {
            for (Map.Entry next2 : aVar.f295g.entrySet()) {
                if (!treeSet.contains(next2.getKey())) {
                    arrayList.add(new Header((String) next2.getKey(), (String) next2.getValue()));
                }
            }
        }
        return arrayList;
    }
}
