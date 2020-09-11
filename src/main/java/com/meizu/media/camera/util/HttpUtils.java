package com.meizu.media.camera.util;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.p020ar.util.SystemInfoUtil;
import com.loc.C1108h;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import com.meizu.statsapp.p081v3.lib.plugin.constants.UxipConstants;
import com.meizu.statsapp.p081v3.lib.plugin.net.multipart.HTTP;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* renamed from: com.meizu.media.camera.util.x */
public class HttpUtils {

    /* renamed from: a */
    public static ChangeQuickRedirect f14348a;

    /* renamed from: b */
    public static boolean f14349b = false;

    /* renamed from: c */
    public static boolean f14350c = false;

    /* renamed from: d */
    private static final LogUtil.C2630a f14351d = new LogUtil.C2630a("HttpUtils");

    /* renamed from: e */
    private static final byte[] f14352e = SystemInfoUtil.LINE_END.getBytes();

    /* renamed from: f */
    private static final byte[] f14353f = "----------MPCS_HTTP_POST_CONTENT_BOUNDARY--\r\n".getBytes();

    /* renamed from: g */
    private static final HostnameVerifier f14354g = new HostnameVerifier() {
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    };

    /* renamed from: h */
    private static final String[] f14355h = {"0", "1", "2", ExifInterface.GPS_MEASUREMENT_3D, UxipConstants.EVENT_UPLOAD_MIN_VERSION, "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", C1108h.f3354h};

    /* renamed from: com.meizu.media.camera.util.x$a */
    /* compiled from: HttpUtils */
    public static class C2661a {

        /* renamed from: a */
        public String f14370a;

        /* renamed from: b */
        public long f14371b;

        /* renamed from: c */
        public long f14372c;
    }

    /* renamed from: com.meizu.media.camera.util.x$b */
    /* compiled from: HttpUtils */
    public interface C2662b {
    }

    /* renamed from: com.meizu.media.camera.util.x$c */
    /* compiled from: HttpUtils */
    public interface C2663c {
        /* renamed from: a */
        void mo22756a(C2662b bVar);
    }

    /* renamed from: com.meizu.media.camera.util.x$e */
    /* compiled from: HttpUtils */
    public static class C2665e extends C2661a {

        /* renamed from: d */
        public String f14374d;

        /* renamed from: e */
        public String f14375e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public byte[] f14376f;
    }

    /* renamed from: a */
    public static String m16279a(String str, String str2, List<PostParameter> list, C2663c cVar) {
        ChangeQuickRedirect changeQuickRedirect = f14348a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, str2, list, cVar}, (Object) null, changeQuickRedirect, true, 8080, new Class[]{String.class, String.class, List.class, C2663c.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        LogUtil.m15942a(f14351d, "doHttpRequest start");
        String[] strArr = {null};
        final String[] strArr2 = strArr;
        final String str3 = str;
        final String str4 = str2;
        final List<PostParameter> list2 = list;
        final C2663c cVar2 = cVar;
        Thread thread = new Thread(new Runnable() {

            /* renamed from: a */
            public static ChangeQuickRedirect f14356a;

            public void run() {
                if (!PatchProxy.proxy(new Object[0], this, f14356a, false, 8092, new Class[0], Void.TYPE).isSupported) {
                    strArr2[0] = HttpUtils.m16281a(str3, str4, list2, cVar2, (TokenHandler) null, (List<C2661a>) null, 2500, 2500, new Object[0]);
                }
            }
        });
        thread.start();
        try {
            thread.join(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LogUtil.m15942a(f14351d, "doHttpRequest end");
        return strArr[0];
    }

    /* renamed from: a */
    public static String m16280a(String str, String str2, List<PostParameter> list, C2663c cVar, int i, int i2) {
        int i3 = i;
        Object[] objArr = {str, str2, list, cVar, new Integer(i3), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f14348a;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect, true, 8081, new Class[]{String.class, String.class, List.class, C2663c.class, Integer.TYPE, Integer.TYPE}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        LogUtil.m15942a(f14351d, "doHttpRequest start");
        String[] strArr = {null};
        final String[] strArr2 = strArr;
        final String str3 = str;
        final String str4 = str2;
        final List<PostParameter> list2 = list;
        final C2663c cVar2 = cVar;
        C26603 r10 = r1;
        final int i4 = i;
        final int i5 = i2;
        C26603 r1 = new Runnable() {

            /* renamed from: a */
            public static ChangeQuickRedirect f14362a;

            public void run() {
                if (!PatchProxy.proxy(new Object[0], this, f14362a, false, 8093, new Class[0], Void.TYPE).isSupported) {
                    strArr2[0] = HttpUtils.m16281a(str3, str4, list2, cVar2, (TokenHandler) null, (List<C2661a>) null, i4, i5, new Object[0]);
                }
            }
        };
        Thread thread = new Thread(r10);
        thread.start();
        try {
            thread.join((long) i3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LogUtil.m15942a(f14351d, "doHttpRequest end");
        return strArr[0];
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01dc, code lost:
        if (f14350c != false) goto L_0x01de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01df, code lost:
        r5 = new java.lang.Object[r15];
        r5[0] = "e.toString() = " + r0;
        com.meizu.media.camera.util.C2644av.m16099a("Exception : %s", r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0224, code lost:
        r4 = r0.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0229, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0246, code lost:
        r2.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0268, code lost:
        r2.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00be, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00bf, code lost:
        r1 = null;
        r2 = null;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00c4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00c5, code lost:
        r1 = null;
        r2 = null;
        r3 = null;
        r12 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00c9, code lost:
        r13 = -1;
        r15 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ed, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ee, code lost:
        r1 = null;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0162, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0164, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0165, code lost:
        r15 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0166, code lost:
        r1 = null;
        r2 = null;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x016b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x016c, code lost:
        r15 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01c6, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01c7, code lost:
        r1 = null;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01cb, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01cc, code lost:
        r15 = 1;
        r1 = null;
        r3 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01da A[Catch:{ all -> 0x0265 }] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0224 A[Catch:{ all -> 0x0265 }] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0229 A[Catch:{ all -> 0x0265 }] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0246  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0264 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0268  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01a8 A[EDGE_INSN: B:123:0x01a8->B:82:0x01a8 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00be A[ExcHandler: all (th java.lang.Throwable), Splitter:B:6:0x00aa] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00e4 A[SYNTHETIC, Splitter:B:26:0x00e4] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0127 A[SYNTHETIC, Splitter:B:48:0x0127] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0178 A[Catch:{ Exception -> 0x01c4, all -> 0x01c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0191 A[Catch:{ Exception -> 0x01bb }, LOOP:0: B:79:0x018b->B:81:0x0191, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01c6 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:23:0x00d9] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m16281a(java.lang.String r21, java.lang.String r22, java.util.List<com.meizu.media.camera.util.PostParameter> r23, com.meizu.media.camera.util.HttpUtils.C2663c r24, com.meizu.media.camera.util.TokenHandler r25, java.util.List<com.meizu.media.camera.util.HttpUtils.C2661a> r26, int r27, int r28, java.lang.Object... r29) {
        /*
            r0 = r21
            r10 = r22
            r3 = r23
            r4 = r24
            r1 = r25
            r6 = r26
            r7 = r27
            r8 = r28
            r2 = r29
            r5 = 9
            java.lang.Object[] r11 = new java.lang.Object[r5]
            r9 = 0
            r11[r9] = r0
            r15 = 1
            r11[r15] = r10
            r12 = 2
            r11[r12] = r3
            r13 = 3
            r11[r13] = r4
            r14 = 4
            r11[r14] = r1
            r16 = 5
            r11[r16] = r6
            java.lang.Integer r14 = new java.lang.Integer
            r14.<init>(r7)
            r17 = 6
            r11[r17] = r14
            java.lang.Integer r14 = new java.lang.Integer
            r14.<init>(r8)
            r18 = 7
            r11[r18] = r14
            r14 = 8
            r11[r14] = r2
            com.meizu.savior.ChangeQuickRedirect r19 = f14348a
            java.lang.Class[] r5 = new java.lang.Class[r5]
            java.lang.Class<java.lang.String> r20 = java.lang.String.class
            r5[r9] = r20
            java.lang.Class<java.lang.String> r20 = java.lang.String.class
            r5[r15] = r20
            java.lang.Class<java.util.List> r20 = java.util.List.class
            r5[r12] = r20
            java.lang.Class<com.meizu.media.camera.util.x$c> r12 = com.meizu.media.camera.util.HttpUtils.C2663c.class
            r5[r13] = r12
            java.lang.Class<com.meizu.media.camera.util.as> r12 = com.meizu.media.camera.util.TokenHandler.class
            r13 = 4
            r5[r13] = r12
            java.lang.Class<java.util.List> r12 = java.util.List.class
            r5[r16] = r12
            java.lang.Class r12 = java.lang.Integer.TYPE
            r5[r17] = r12
            java.lang.Class r12 = java.lang.Integer.TYPE
            r5[r18] = r12
            java.lang.Class<java.lang.Object[]> r12 = java.lang.Object[].class
            r5[r14] = r12
            java.lang.Class<java.lang.String> r17 = java.lang.String.class
            r12 = 0
            r14 = 1
            r16 = 8082(0x1f92, float:1.1325E-41)
            r13 = r19
            r9 = 1
            r15 = r16
            r16 = r5
            com.meizu.savior.PatchProxyResult r5 = com.meizu.savior.PatchProxy.proxy(r11, r12, r13, r14, r15, r16, r17)
            boolean r11 = r5.isSupported
            if (r11 == 0) goto L_0x0082
            java.lang.Object r0 = r5.result
            java.lang.String r0 = (java.lang.String) r0
            return r0
        L_0x0082:
            boolean r5 = f14349b
            boolean r11 = f14350c
            java.lang.String r12 = "XXX: %s"
            java.lang.Object[] r13 = new java.lang.Object[r9]
            r14 = 0
            r13[r14] = r10
            com.meizu.media.camera.util.C2644av.m16101a(r5, r11, r12, r13)
            com.meizu.media.camera.util.ac$a r5 = f14351d
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "doHttpRequest timeOut:"
            r11.append(r12)
            r11.append(r7)
            java.lang.String r11 = r11.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r5, (java.lang.String) r11)
            r5 = -1
            r11 = 0
            if (r2 == 0) goto L_0x00cd
            int r12 = r2.length     // Catch:{ Exception -> 0x00c4, all -> 0x00be }
            if (r12 <= 0) goto L_0x00cd
            r12 = 0
            r2 = r2[r12]     // Catch:{ Exception -> 0x00c4, all -> 0x00be }
            if (r2 == 0) goto L_0x00cd
            boolean r12 = r2 instanceof java.lang.Boolean     // Catch:{ Exception -> 0x00c4, all -> 0x00be }
            if (r12 == 0) goto L_0x00cd
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Exception -> 0x00c4, all -> 0x00be }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x00c4, all -> 0x00be }
            r12 = r2
            goto L_0x00ce
        L_0x00be:
            r0 = move-exception
            r1 = r11
            r2 = r1
            r3 = r2
            goto L_0x0266
        L_0x00c4:
            r0 = move-exception
            r1 = r11
            r2 = r1
            r3 = r2
            r12 = 0
        L_0x00c9:
            r13 = -1
            r15 = 1
            goto L_0x01d6
        L_0x00cd:
            r12 = 0
        L_0x00ce:
            java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x01d0, all -> 0x00be }
            r2.<init>(r10)     // Catch:{ Exception -> 0x01d0, all -> 0x00be }
            java.net.URLConnection r2 = r2.openConnection()     // Catch:{ Exception -> 0x01d0, all -> 0x00be }
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ Exception -> 0x01d0, all -> 0x00be }
            r2.setConnectTimeout(r7)     // Catch:{ Exception -> 0x01cb, all -> 0x01c6 }
            r2.setReadTimeout(r8)     // Catch:{ Exception -> 0x01cb, all -> 0x01c6 }
            r2.setDoInput(r9)     // Catch:{ Exception -> 0x01cb, all -> 0x01c6 }
            if (r4 == 0) goto L_0x00f1
            com.meizu.media.camera.util.x$d r13 = new com.meizu.media.camera.util.x$d     // Catch:{ Exception -> 0x00ed, all -> 0x01c6 }
            r13.<init>(r2)     // Catch:{ Exception -> 0x00ed, all -> 0x01c6 }
            r4.mo22756a(r13)     // Catch:{ Exception -> 0x00ed, all -> 0x01c6 }
            goto L_0x00f1
        L_0x00ed:
            r0 = move-exception
            r1 = r11
            r3 = r1
            goto L_0x00c9
        L_0x00f1:
            boolean r13 = r2 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ Exception -> 0x01cb, all -> 0x01c6 }
            if (r13 == 0) goto L_0x00fd
            r13 = r2
            javax.net.ssl.HttpsURLConnection r13 = (javax.net.ssl.HttpsURLConnection) r13     // Catch:{ Exception -> 0x00ed, all -> 0x01c6 }
            javax.net.ssl.HostnameVerifier r14 = f14354g     // Catch:{ Exception -> 0x00ed, all -> 0x01c6 }
            r13.setHostnameVerifier(r14)     // Catch:{ Exception -> 0x00ed, all -> 0x01c6 }
        L_0x00fd:
            java.lang.String r13 = "POST"
            boolean r13 = r13.equals(r0)     // Catch:{ Exception -> 0x01cb, all -> 0x01c6 }
            if (r13 == 0) goto L_0x0111
            java.lang.String r13 = "POST"
            r2.setRequestMethod(r13)     // Catch:{ Exception -> 0x00ed, all -> 0x01c6 }
            r2.setDoOutput(r9)     // Catch:{ Exception -> 0x00ed, all -> 0x01c6 }
            m16284a((java.net.HttpURLConnection) r2, (java.util.List<com.meizu.media.camera.util.PostParameter>) r3, (java.util.List<com.meizu.media.camera.util.HttpUtils.C2661a>) r6)     // Catch:{ Exception -> 0x00ed, all -> 0x01c6 }
            goto L_0x0121
        L_0x0111:
            java.lang.String r13 = "GET"
            r2.setRequestMethod(r13)     // Catch:{ Exception -> 0x01cb, all -> 0x01c6 }
            r13 = 0
            r2.setDoOutput(r13)     // Catch:{ Exception -> 0x01cb, all -> 0x01c6 }
            java.lang.String r13 = "x-requested-with"
            java.lang.String r14 = "XMLHttpRequest"
            r2.setRequestProperty(r13, r14)     // Catch:{ Exception -> 0x01cb, all -> 0x01c6 }
        L_0x0121:
            int r13 = r2.getResponseCode()     // Catch:{ Exception -> 0x01cb, all -> 0x01c6 }
            if (r1 == 0) goto L_0x0171
            r2.connect()     // Catch:{ Exception -> 0x016b, all -> 0x01c6 }
            int r5 = r2.getResponseCode()     // Catch:{ Exception -> 0x016b, all -> 0x01c6 }
            boolean r5 = r1.mo22687a(r5)     // Catch:{ Exception -> 0x016b, all -> 0x01c6 }
            if (r5 != 0) goto L_0x0171
            boolean r1 = r25.mo22686a()     // Catch:{ Exception -> 0x016b, all -> 0x01c6 }
            if (r1 == 0) goto L_0x0171
            r2.disconnect()     // Catch:{ Exception -> 0x016b, all -> 0x01c6 }
            r5 = 0
            java.lang.Object[] r14 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x0164, all -> 0x00be }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r12)     // Catch:{ Exception -> 0x0164, all -> 0x00be }
            r15 = 0
            r14[r15] = r1     // Catch:{ Exception -> 0x0164, all -> 0x00be }
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            r6 = r26
            r7 = r27
            r8 = r28
            r15 = 1
            r9 = r14
            java.lang.String r0 = m16281a(r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0162, all -> 0x00be }
            com.meizu.media.camera.util.C2644av.m16096a((java.io.Closeable) r11)
            com.meizu.media.camera.util.C2644av.m16096a((java.io.Closeable) r11)
            return r0
        L_0x0162:
            r0 = move-exception
            goto L_0x0166
        L_0x0164:
            r0 = move-exception
            r15 = 1
        L_0x0166:
            r1 = r11
            r2 = r1
            r3 = r2
            goto L_0x01d6
        L_0x016b:
            r0 = move-exception
            r15 = 1
        L_0x016d:
            r1 = r11
            r3 = r1
            goto L_0x01d6
        L_0x0171:
            r15 = 1
            java.io.InputStream r0 = r2.getErrorStream()     // Catch:{ Exception -> 0x01c4, all -> 0x01c6 }
            if (r0 != 0) goto L_0x017c
            java.io.InputStream r0 = r2.getInputStream()     // Catch:{ Exception -> 0x01c4, all -> 0x01c6 }
        L_0x017c:
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x01c4, all -> 0x01c6 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x01c4, all -> 0x01c6 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x01c1, all -> 0x01bd }
            r3.<init>(r1)     // Catch:{ Exception -> 0x01c1, all -> 0x01bd }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01bb }
            r0.<init>()     // Catch:{ Exception -> 0x01bb }
        L_0x018b:
            java.lang.String r4 = r3.readLine()     // Catch:{ Exception -> 0x01bb }
            if (r4 == 0) goto L_0x01a8
            boolean r5 = f14349b     // Catch:{ Exception -> 0x01bb }
            boolean r6 = f14350c     // Catch:{ Exception -> 0x01bb }
            java.lang.String r7 = "XXX: %s"
            java.lang.Object[] r8 = new java.lang.Object[r15]     // Catch:{ Exception -> 0x01bb }
            r9 = 0
            r8[r9] = r4     // Catch:{ Exception -> 0x01bb }
            com.meizu.media.camera.util.C2644av.m16101a(r5, r6, r7, r8)     // Catch:{ Exception -> 0x01bb }
            r0.append(r4)     // Catch:{ Exception -> 0x01bb }
            java.lang.String r4 = "\n"
            r0.append(r4)     // Catch:{ Exception -> 0x01bb }
            goto L_0x018b
        L_0x01a8:
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01bb }
            if (r2 == 0) goto L_0x01b1
            r2.disconnect()
        L_0x01b1:
            com.meizu.media.camera.util.C2644av.m16096a((java.io.Closeable) r3)
            com.meizu.media.camera.util.C2644av.m16096a((java.io.Closeable) r1)
            r4 = r11
            r11 = r0
            goto L_0x024f
        L_0x01bb:
            r0 = move-exception
            goto L_0x01d6
        L_0x01bd:
            r0 = move-exception
            r3 = r11
            goto L_0x0266
        L_0x01c1:
            r0 = move-exception
            r3 = r11
            goto L_0x01d6
        L_0x01c4:
            r0 = move-exception
            goto L_0x016d
        L_0x01c6:
            r0 = move-exception
            r1 = r11
            r3 = r1
            goto L_0x0266
        L_0x01cb:
            r0 = move-exception
            r15 = 1
            r1 = r11
            r3 = r1
            goto L_0x01d5
        L_0x01d0:
            r0 = move-exception
            r15 = 1
            r1 = r11
            r2 = r1
            r3 = r2
        L_0x01d5:
            r13 = -1
        L_0x01d6:
            boolean r4 = f14349b     // Catch:{ all -> 0x0265 }
            if (r4 != 0) goto L_0x01fb
            boolean r4 = f14350c     // Catch:{ all -> 0x0265 }
            if (r4 == 0) goto L_0x01df
            goto L_0x01fb
        L_0x01df:
            java.lang.String r4 = "Exception : %s"
            java.lang.Object[] r5 = new java.lang.Object[r15]     // Catch:{ all -> 0x0265 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0265 }
            r6.<init>()     // Catch:{ all -> 0x0265 }
            java.lang.String r7 = "e.toString() = "
            r6.append(r7)     // Catch:{ all -> 0x0265 }
            r6.append(r0)     // Catch:{ all -> 0x0265 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0265 }
            r7 = 0
            r5[r7] = r6     // Catch:{ all -> 0x0265 }
            com.meizu.media.camera.util.C2644av.m16099a((java.lang.String) r4, (java.lang.Object[]) r5)     // Catch:{ all -> 0x0265 }
            goto L_0x0222
        L_0x01fb:
            boolean r4 = f14349b     // Catch:{ all -> 0x0265 }
            boolean r5 = f14350c     // Catch:{ all -> 0x0265 }
            java.lang.String r6 = "Exception : %s"
            java.lang.Object[] r7 = new java.lang.Object[r15]     // Catch:{ all -> 0x0265 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0265 }
            r8.<init>()     // Catch:{ all -> 0x0265 }
            java.lang.String r9 = "urlString = "
            r8.append(r9)     // Catch:{ all -> 0x0265 }
            r8.append(r10)     // Catch:{ all -> 0x0265 }
            java.lang.String r9 = ", e.toString() = "
            r8.append(r9)     // Catch:{ all -> 0x0265 }
            r8.append(r0)     // Catch:{ all -> 0x0265 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0265 }
            r9 = 0
            r7[r9] = r8     // Catch:{ all -> 0x0265 }
            com.meizu.media.camera.util.C2644av.m16101a(r4, r5, r6, r7)     // Catch:{ all -> 0x0265 }
        L_0x0222:
            if (r12 == 0) goto L_0x0229
            java.lang.String r4 = r0.toString()     // Catch:{ all -> 0x0265 }
            goto L_0x022a
        L_0x0229:
            r4 = r11
        L_0x022a:
            com.meizu.media.camera.util.ac$a r5 = f14351d     // Catch:{ all -> 0x0265 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0265 }
            r6.<init>()     // Catch:{ all -> 0x0265 }
            java.lang.String r7 = "doHttpRequest exception:"
            r6.append(r7)     // Catch:{ all -> 0x0265 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0265 }
            r6.append(r0)     // Catch:{ all -> 0x0265 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x0265 }
            com.meizu.media.camera.util.LogUtil.m15956e(r5, r0)     // Catch:{ all -> 0x0265 }
            if (r2 == 0) goto L_0x0249
            r2.disconnect()
        L_0x0249:
            com.meizu.media.camera.util.C2644av.m16096a((java.io.Closeable) r3)
            com.meizu.media.camera.util.C2644av.m16096a((java.io.Closeable) r1)
        L_0x024f:
            if (r12 == 0) goto L_0x0264
            com.meizu.media.camera.a.e r0 = new com.meizu.media.camera.a.e
            r0.<init>()
            r0.mo18720a((int) r13)
            r0.mo18721a((java.lang.String) r11)
            r0.mo18722b(r4)
            java.lang.String r0 = com.alibaba.fastjson.JSONObject.toJSONString(r0)
            return r0
        L_0x0264:
            return r11
        L_0x0265:
            r0 = move-exception
        L_0x0266:
            if (r2 == 0) goto L_0x026b
            r2.disconnect()
        L_0x026b:
            com.meizu.media.camera.util.C2644av.m16096a((java.io.Closeable) r3)
            com.meizu.media.camera.util.C2644av.m16096a((java.io.Closeable) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.HttpUtils.m16281a(java.lang.String, java.lang.String, java.util.List, com.meizu.media.camera.util.x$c, com.meizu.media.camera.util.as, java.util.List, int, int, java.lang.Object[]):java.lang.String");
    }

    /* renamed from: a */
    private static void m16284a(HttpURLConnection httpURLConnection, List<PostParameter> list, List<C2661a> list2) throws IOException {
        int i;
        Throwable th;
        OutputStream outputStream;
        byte[] bArr;
        int i2;
        int i3;
        if (!PatchProxy.proxy(new Object[]{httpURLConnection, list, list2}, (Object) null, f14348a, true, 8083, new Class[]{HttpURLConnection.class, List.class, List.class}, Void.TYPE).isSupported) {
            int size = list == null ? 0 : list.size();
            if (list2 == null) {
                i = 0;
            } else {
                i = list2.size();
            }
            if (size != 0 || i != 0) {
                httpURLConnection.setUseCaches(false);
                OutputStream outputStream2 = null;
                if (i == 0) {
                    try {
                        if (httpURLConnection.getRequestProperty(HTTP.CONTENT_TYPE) == null) {
                            httpURLConnection.setRequestProperty(HTTP.CONTENT_TYPE, "application/x-www-form-urlencoded; charset=UTF-8");
                        }
                        StringBuilder sb = new StringBuilder();
                        for (PostParameter next : list) {
                            if (sb.length() > 0) {
                                sb.append('&');
                            }
                            if (next.mo22670a() != null) {
                                if (next.mo22670a().length() != 0) {
                                    sb.append(next.mo22670a());
                                    sb.append('=');
                                    sb.append(next.mo22671b());
                                }
                            }
                            sb.append(next.mo22671b());
                        }
                        C2644av.m16101a(f14349b, f14350c, "XXX: %s", sb.toString());
                        byte[] bytes = sb.toString().getBytes("UTF-8");
                        httpURLConnection.setRequestProperty(HTTP.CONTENT_LEN, String.valueOf(bytes.length));
                        outputStream = httpURLConnection.getOutputStream();
                        try {
                            outputStream.write(bytes);
                        } catch (Throwable th2) {
                            outputStream2 = outputStream;
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        C2644av.m16096a((Closeable) outputStream2);
                        throw th;
                    }
                } else {
                    httpURLConnection.setRequestProperty(HTTP.CONTENT_TYPE, "multipart/form-data; boundary=--------MPCS_HTTP_POST_CONTENT_BOUNDARY");
                    StringBuilder sb2 = new StringBuilder();
                    if (size > 0) {
                        for (PostParameter a : list) {
                            m16282a(sb2, a);
                        }
                        C2644av.m16101a(f14349b, f14350c, "XXX: %s", sb2.toString());
                        bArr = sb2.toString().getBytes("UTF-8");
                        i2 = bArr.length + 0;
                    } else {
                        bArr = null;
                        i2 = 0;
                    }
                    Iterator<C2661a> it = list2.iterator();
                    while (it.hasNext()) {
                        C2665e eVar = (C2665e) it.next();
                        sb2.setLength(0);
                        m16283a(sb2, eVar);
                        C2644av.m16101a(f14349b, f14350c, "XXX: %s", sb2.toString());
                        byte[] unused = eVar.f14376f = sb2.toString().getBytes("UTF-8");
                        int length = i2 + eVar.f14376f.length;
                        if (eVar.f14371b == 0 && eVar.f14372c == 0) {
                            i3 = (int) (((long) length) + new File(eVar.f14370a).length());
                        } else {
                            i3 = (int) (((long) length) + eVar.f14372c);
                        }
                        i2 = i3 + f14352e.length;
                    }
                    httpURLConnection.setFixedLengthStreamingMode(i2 + f14353f.length);
                    outputStream = httpURLConnection.getOutputStream();
                    if (bArr != null) {
                        outputStream.write(bArr);
                    }
                    Iterator<C2661a> it2 = list2.iterator();
                    while (it2.hasNext()) {
                        C2665e eVar2 = (C2665e) it2.next();
                        outputStream.write(eVar2.f14376f);
                        m16285a(eVar2, outputStream);
                        outputStream.write(f14352e);
                    }
                    outputStream.write(f14353f);
                }
                outputStream2 = outputStream;
                outputStream2.flush();
                C2644av.m16096a((Closeable) outputStream2);
            }
        }
    }

    /* renamed from: a */
    private static void m16282a(StringBuilder sb, PostParameter ajVar) {
        Class[] clsArr = {StringBuilder.class, PostParameter.class};
        if (!PatchProxy.proxy(new Object[]{sb, ajVar}, (Object) null, f14348a, true, 8084, clsArr, Void.TYPE).isSupported) {
            sb.append("--");
            sb.append("--------MPCS_HTTP_POST_CONTENT_BOUNDARY");
            sb.append(SystemInfoUtil.LINE_END);
            sb.append("Content-Disposition: form-data; name=\"");
            sb.append(ajVar.mo22670a());
            sb.append("\"\r\n");
            sb.append(SystemInfoUtil.LINE_END);
            sb.append(ajVar.mo22671b());
            sb.append(SystemInfoUtil.LINE_END);
        }
    }

    /* renamed from: a */
    private static void m16283a(StringBuilder sb, C2665e eVar) throws UnsupportedEncodingException {
        Class[] clsArr = {StringBuilder.class, C2665e.class};
        if (!PatchProxy.proxy(new Object[]{sb, eVar}, (Object) null, f14348a, true, 8085, clsArr, Void.TYPE).isSupported) {
            sb.append("--");
            sb.append("--------MPCS_HTTP_POST_CONTENT_BOUNDARY");
            sb.append(SystemInfoUtil.LINE_END);
            sb.append("Content-Disposition: form-data; name=\"");
            sb.append(eVar.f14374d);
            sb.append("\"; ");
            sb.append("filename=\"");
            sb.append(URLEncoder.encode(m16278a(eVar.f14370a), "UTF-8"));
            sb.append("\"\r\n");
            sb.append("Content-Type: ");
            sb.append(eVar.f14375e);
            sb.append("\r\n\r\n");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.io.RandomAccessFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.io.RandomAccessFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.io.RandomAccessFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.io.RandomAccessFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.io.RandomAccessFile} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m16285a(com.meizu.media.camera.util.HttpUtils.C2665e r10, java.io.OutputStream r11) throws java.io.IOException {
        /*
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r10
            r9 = 1
            r1[r9] = r11
            com.meizu.savior.ChangeQuickRedirect r3 = f14348a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<com.meizu.media.camera.util.x$e> r0 = com.meizu.media.camera.util.HttpUtils.C2665e.class
            r6[r8] = r0
            java.lang.Class<java.io.OutputStream> r0 = java.io.OutputStream.class
            r6[r9] = r0
            java.lang.Class r7 = java.lang.Boolean.TYPE
            r2 = 0
            r4 = 1
            r5 = 8086(0x1f96, float:1.1331E-41)
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r0.isSupported
            if (r1 == 0) goto L_0x002c
            java.lang.Object r10 = r0.result
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            return r10
        L_0x002c:
            long r0 = r10.f14371b
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 0
            if (r0 != 0) goto L_0x005c
            long r4 = r10.f14372c
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x005c
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ all -> 0x0057 }
            java.lang.String r10 = r10.f14370a     // Catch:{ all -> 0x0057 }
            r0.<init>(r10)     // Catch:{ all -> 0x0057 }
            int r10 = r0.available()     // Catch:{ all -> 0x0054 }
            boolean r10 = m16286a((java.io.InputStream) r0, (java.io.OutputStream) r11, (int) r10)     // Catch:{ all -> 0x0054 }
            if (r10 != 0) goto L_0x0050
            com.meizu.media.camera.util.C2644av.m16096a((java.io.Closeable) r0)
            return r8
        L_0x0050:
            com.meizu.media.camera.util.C2644av.m16096a((java.io.Closeable) r0)
            goto L_0x0078
        L_0x0054:
            r10 = move-exception
            r1 = r0
            goto L_0x0058
        L_0x0057:
            r10 = move-exception
        L_0x0058:
            com.meizu.media.camera.util.C2644av.m16096a((java.io.Closeable) r1)
            throw r10
        L_0x005c:
            java.io.RandomAccessFile r0 = new java.io.RandomAccessFile     // Catch:{ all -> 0x007c }
            java.lang.String r2 = r10.f14370a     // Catch:{ all -> 0x007c }
            java.lang.String r3 = "r"
            r0.<init>(r2, r3)     // Catch:{ all -> 0x007c }
            long r4 = r10.f14371b     // Catch:{ all -> 0x0079 }
            long r6 = r10.f14372c     // Catch:{ all -> 0x0079 }
            r2 = r0
            r3 = r11
            boolean r10 = m16287a((java.io.RandomAccessFile) r2, (java.io.OutputStream) r3, (long) r4, (long) r6)     // Catch:{ all -> 0x0079 }
            if (r10 != 0) goto L_0x0075
            com.meizu.media.camera.util.C2644av.m16096a((java.io.Closeable) r0)
            return r8
        L_0x0075:
            com.meizu.media.camera.util.C2644av.m16096a((java.io.Closeable) r0)
        L_0x0078:
            return r9
        L_0x0079:
            r10 = move-exception
            r1 = r0
            goto L_0x007d
        L_0x007c:
            r10 = move-exception
        L_0x007d:
            com.meizu.media.camera.util.C2644av.m16096a((java.io.Closeable) r1)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.HttpUtils.m16285a(com.meizu.media.camera.util.x$e, java.io.OutputStream):boolean");
    }

    /* renamed from: a */
    public static boolean m16286a(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{inputStream, outputStream, new Integer(i)}, (Object) null, f14348a, true, 8087, new Class[]{InputStream.class, OutputStream.class, Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        byte[] bArr = new byte[4096];
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read <= 0) {
            return false;
        }
        int i2 = 0;
        while (read > 0) {
            outputStream.write(bArr, 0, read);
            i2 += read;
            C2644av.m16099a("dump: %d ", Integer.valueOf(i2));
            read = inputStream.read(bArr, 0, bArr.length);
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m16287a(RandomAccessFile randomAccessFile, OutputStream outputStream, long j, long j2) throws IOException {
        Object[] objArr = {randomAccessFile, outputStream, new Long(j), new Long(j2)};
        ChangeQuickRedirect changeQuickRedirect = f14348a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 8088, new Class[]{RandomAccessFile.class, OutputStream.class, Long.TYPE, Long.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        randomAccessFile.seek(j);
        byte[] bArr = new byte[4096];
        int read = randomAccessFile.read(bArr, 0, (int) Math.min(j2, (long) bArr.length));
        if (read <= 0) {
            return false;
        }
        while (read > 0) {
            outputStream.write(bArr, 0, read);
            j2 -= (long) read;
            if (j2 <= 0) {
                return true;
            }
            read = randomAccessFile.read(bArr, 0, (int) Math.min(j2, (long) bArr.length));
        }
        return false;
    }

    /* renamed from: a */
    public static String m16278a(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f14348a, true, 8089, new Class[]{String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        int lastIndexOf = str.lastIndexOf(47);
        return lastIndexOf < 0 ? str : str.substring(lastIndexOf + 1, str.length());
    }

    /* renamed from: com.meizu.media.camera.util.x$d */
    /* compiled from: HttpUtils */
    private static class C2664d implements C2662b {

        /* renamed from: a */
        private HttpURLConnection f14373a;

        public C2664d(HttpURLConnection httpURLConnection) {
            this.f14373a = httpURLConnection;
        }
    }
}
