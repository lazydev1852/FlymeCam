package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.pushtracer.constant.Parameters;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ExecutorService;

/* renamed from: com.loc.by */
public final class DnsManager {

    /* renamed from: c */
    private static DnsManager f2797c;

    /* renamed from: a */
    LocationRequest f2798a;

    /* renamed from: b */
    int f2799b;

    /* renamed from: d */
    private Object f2800d;

    /* renamed from: e */
    private Context f2801e;

    /* renamed from: f */
    private ExecutorService f2802f;

    /* renamed from: g */
    private boolean f2803g;

    /* renamed from: h */
    private boolean f2804h;

    /* renamed from: i */
    private final int f2805i;

    /* renamed from: j */
    private String f2806j;

    /* renamed from: k */
    private String f2807k;

    /* renamed from: l */
    private String[] f2808l;

    /* renamed from: m */
    private final int f2809m;

    /* renamed from: n */
    private final int f2810n;

    /* renamed from: com.loc.by$a */
    /* compiled from: DnsManager */
    class C1068a implements Runnable {

        /* renamed from: a */
        LocationRequest f2811a = null;

        C1068a(LocationRequest cbVar) {
            this.f2811a = cbVar;
        }

        public final void run() {
            DnsManager.this.f2799b++;
            DnsManager.this.mo13144b(this.f2811a);
            DnsManager byVar = DnsManager.this;
            byVar.f2799b--;
        }
    }

    private DnsManager() {
        this.f2800d = null;
        this.f2801e = null;
        this.f2802f = null;
        this.f2803g = false;
        this.f2804h = true;
        this.f2798a = null;
        this.f2805i = 2;
        this.f2806j = "";
        this.f2807k = "";
        this.f2808l = null;
        this.f2799b = 0;
        this.f2809m = 5;
        this.f2810n = 2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:29|30|31|32|33|(1:35)|36) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x00cd */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d1 A[Catch:{ Throwable -> 0x00d8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private DnsManager(android.content.Context r13) {
        /*
            r12 = this;
            r12.<init>()
            r0 = 0
            r12.f2800d = r0
            r12.f2801e = r0
            r12.f2802f = r0
            r1 = 0
            r12.f2803g = r1
            r2 = 1
            r12.f2804h = r2
            r12.f2798a = r0
            r3 = 2
            r12.f2805i = r3
            java.lang.String r4 = ""
            r12.f2806j = r4
            java.lang.String r4 = ""
            r12.f2807k = r4
            r12.f2808l = r0
            r12.f2799b = r1
            r0 = 5
            r12.f2809m = r0
            r12.f2810n = r3
            r12.f2801e = r13
            android.content.Context r13 = r12.f2801e
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r3 = "DnsManager ==> init "
            r0[r1] = r3
            com.loc.C1079cp.m3503a()
            boolean r0 = com.loc.AuthUtil.m3371p()     // Catch:{ Throwable -> 0x00ed }
            if (r0 != 0) goto L_0x003a
            return
        L_0x003a:
            java.lang.Object r0 = r12.f2800d     // Catch:{ Throwable -> 0x00ed }
            if (r0 != 0) goto L_0x00ec
            java.lang.String r0 = "pref"
            java.lang.String r3 = "ok6"
            int r0 = com.loc.SpUtil.m3490b((android.content.Context) r13, (java.lang.String) r0, (java.lang.String) r3, (int) r1)     // Catch:{ Throwable -> 0x00ed }
            java.lang.String r3 = "pref"
            java.lang.String r4 = "ok8"
            r10 = 0
            long r3 = com.loc.SpUtil.m3491b((android.content.Context) r13, (java.lang.String) r3, (java.lang.String) r4, (long) r10)     // Catch:{ Throwable -> 0x00ed }
            if (r0 == 0) goto L_0x0064
            int r5 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x0064
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x00ed }
            r7 = 0
            long r5 = r5 - r3
            r3 = 259200000(0xf731400, double:1.280618154E-315)
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0064
            return
        L_0x0064:
            java.lang.String r3 = "pref"
            java.lang.String r4 = "ok6"
            int r0 = r0 + r2
            com.loc.SpUtil.m3485a((android.content.Context) r13, (java.lang.String) r3, (java.lang.String) r4, (int) r0)     // Catch:{ Throwable -> 0x00ed }
            java.lang.String r0 = "pref"
            java.lang.String r3 = "ok8"
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x00ed }
            com.loc.SpUtil.m3486a((android.content.Context) r13, (java.lang.String) r0, (java.lang.String) r3, (long) r4)     // Catch:{ Throwable -> 0x00ed }
            boolean r0 = m3250c()     // Catch:{ Throwable -> 0x00ed }
            if (r0 == 0) goto L_0x00a2
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ Throwable -> 0x00ed }
            java.lang.String r3 = "DnsManager ==> initForJar "
            r0[r1] = r3     // Catch:{ Throwable -> 0x00ed }
            com.loc.C1079cp.m3503a()     // Catch:{ Throwable -> 0x00ed }
            java.lang.String r0 = "com.autonavi.httpdns.HttpDnsManager"
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ Throwable -> 0x0099 }
            java.lang.Class<android.content.Context> r4 = android.content.Context.class
            r3[r1] = r4     // Catch:{ Throwable -> 0x0099 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Throwable -> 0x0099 }
            r2[r1] = r13     // Catch:{ Throwable -> 0x0099 }
            java.lang.Object r0 = com.loc.Reflect.m3415a((java.lang.String) r0, (java.lang.Class<?>[]) r3, (java.lang.Object[]) r2)     // Catch:{ Throwable -> 0x0099 }
            r12.f2800d = r0     // Catch:{ Throwable -> 0x0099 }
            goto L_0x00de
        L_0x0099:
            r0 = move-exception
            java.lang.String r2 = "DnsManager"
            java.lang.String r3 = "initForJar"
        L_0x009e:
            com.loc.CoreUtil.m3389a(r0, r2, r3)     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00de
        L_0x00a2:
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ Throwable -> 0x00ed }
            java.lang.String r3 = "DnsManager ==> initHttpDnsDex "
            r0[r1] = r3     // Catch:{ Throwable -> 0x00ed }
            com.loc.C1079cp.m3503a()     // Catch:{ Throwable -> 0x00ed }
            java.lang.String r0 = "HttpDNS"
            java.lang.String r3 = "1.0.0"
            com.loc.di r5 = com.loc.CoreUtil.m3385a((java.lang.String) r0, (java.lang.String) r3)     // Catch:{ Throwable -> 0x00d8 }
            boolean r0 = com.loc.ReportUtil.m3439a((android.content.Context) r13, (com.loc.SDKInfo) r5)     // Catch:{ Throwable -> 0x00d8 }
            if (r0 == 0) goto L_0x00de
            java.lang.String r6 = "com.autonavi.httpdns.HttpDnsManager"
            r7 = 0
            java.lang.Class[] r8 = new java.lang.Class[r2]     // Catch:{ Throwable -> 0x00cd }
            java.lang.Class<android.content.Context> r0 = android.content.Context.class
            r8[r1] = r0     // Catch:{ Throwable -> 0x00cd }
            java.lang.Object[] r9 = new java.lang.Object[r2]     // Catch:{ Throwable -> 0x00cd }
            r9[r1] = r13     // Catch:{ Throwable -> 0x00cd }
            r4 = r13
            java.lang.Object r0 = com.loc.InstanceFactory.m3966a(r4, r5, r6, r7, r8, r9)     // Catch:{ Throwable -> 0x00cd }
            r12.f2800d = r0     // Catch:{ Throwable -> 0x00cd }
        L_0x00cd:
            java.lang.Object r0 = r12.f2800d     // Catch:{ Throwable -> 0x00d8 }
            if (r0 != 0) goto L_0x00d2
            r2 = 0
        L_0x00d2:
            java.lang.String r0 = "HttpDns"
            com.loc.ReportUtil.m3430a((android.content.Context) r13, (java.lang.String) r0, (int) r2)     // Catch:{ Throwable -> 0x00d8 }
            goto L_0x00de
        L_0x00d8:
            r0 = move-exception
            java.lang.String r2 = "DNSManager"
            java.lang.String r3 = "initHttpDns"
            goto L_0x009e
        L_0x00de:
            java.lang.String r0 = "pref"
            java.lang.String r2 = "ok6"
            com.loc.SpUtil.m3485a((android.content.Context) r13, (java.lang.String) r0, (java.lang.String) r2, (int) r1)     // Catch:{ Throwable -> 0x00ed }
            java.lang.String r0 = "pref"
            java.lang.String r1 = "ok8"
            com.loc.SpUtil.m3486a((android.content.Context) r13, (java.lang.String) r0, (java.lang.String) r1, (long) r10)     // Catch:{ Throwable -> 0x00ed }
        L_0x00ec:
            return
        L_0x00ed:
            r13 = move-exception
            java.lang.String r0 = "APSCoManager"
            java.lang.String r1 = "init"
            com.loc.CoreUtil.m3389a(r13, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.DnsManager.<init>(android.content.Context):void");
    }

    /* renamed from: a */
    public static DnsManager m3247a(Context context) {
        if (f2797c == null) {
            f2797c = new DnsManager(context);
        }
        return f2797c;
    }

    /* renamed from: a */
    private String m3248a(String str) {
        int i;
        String str2;
        String str3 = null;
        if (m3252f()) {
            try {
                String[] strArr = (String[]) Reflect.m3412a(this.f2800d, "getIpsByHostAsync", str);
                if (strArr == null || strArr.length <= 0) {
                    str2 = null;
                } else if (this.f2808l == null) {
                    this.f2808l = strArr;
                    str2 = strArr[0];
                } else if (m3249a(strArr, this.f2808l)) {
                    str2 = this.f2808l[0];
                } else {
                    this.f2808l = strArr;
                    str2 = strArr[0];
                }
                str3 = str2;
                i = 1;
            } catch (Throwable unused) {
                i = 0;
            }
            ReportUtil.m3442b(this.f2801e, "HttpDns", i);
        }
        new Object[1][0] = "DnsManager ==> getIpAsync  host ： " + str + " ， ip ： " + str3;
        C1079cp.m3503a();
        return str3;
    }

    /* renamed from: a */
    private static boolean m3249a(String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 == null) {
            return false;
        }
        if (strArr == null && strArr2 != null) {
            return false;
        }
        if (strArr == null && strArr2 == null) {
            return true;
        }
        try {
            if (strArr.length != strArr2.length) {
                return false;
            }
            ArrayList arrayList = new ArrayList(12);
            ArrayList arrayList2 = new ArrayList(12);
            arrayList.addAll(Arrays.asList(strArr));
            arrayList2.addAll(Arrays.asList(strArr2));
            Collections.sort(arrayList);
            Collections.sort(arrayList2);
            for (int i = 0; i < arrayList.size(); i++) {
                if (!((String) arrayList.get(i)).equals(arrayList2.get(i))) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: c */
    public static boolean m3250c() {
        try {
            Class.forName("com.autonavi.httpdns.HttpDnsManager");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: e */
    public static void m3251e() {
        f2797c = null;
    }

    /* renamed from: f */
    private boolean m3252f() {
        return AuthUtil.m3371p() && this.f2800d != null && !m3253g() && SpUtil.m3491b(this.f2801e, "pref", "dns_faile_count_total", 0) < 2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x003e A[ADDED_TO_REGION] */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m3253g() {
        /*
            r7 = this;
            r0 = 0
            r1 = 1
            r2 = -1
            r3 = 0
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Throwable -> 0x0034 }
            r5 = 14
            if (r4 < r5) goto L_0x000c
            r4 = 1
            goto L_0x000d
        L_0x000c:
            r4 = 0
        L_0x000d:
            if (r4 == 0) goto L_0x0027
            java.lang.String r4 = "http.proxyHost"
            java.lang.String r4 = java.lang.System.getProperty(r4)     // Catch:{ Throwable -> 0x0034 }
            java.lang.String r3 = "http.proxyPort"
            java.lang.String r3 = java.lang.System.getProperty(r3)     // Catch:{ Throwable -> 0x0025 }
            if (r3 == 0) goto L_0x001e
            goto L_0x0020
        L_0x001e:
            java.lang.String r3 = "-1"
        L_0x0020:
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ Throwable -> 0x0025 }
            goto L_0x003c
        L_0x0025:
            r3 = move-exception
            goto L_0x0038
        L_0x0027:
            android.content.Context r4 = r7.f2801e     // Catch:{ Throwable -> 0x0034 }
            java.lang.String r4 = android.net.Proxy.getHost(r4)     // Catch:{ Throwable -> 0x0034 }
            android.content.Context r3 = r7.f2801e     // Catch:{ Throwable -> 0x0025 }
            int r3 = android.net.Proxy.getPort(r3)     // Catch:{ Throwable -> 0x0025 }
            goto L_0x003c
        L_0x0034:
            r4 = move-exception
            r6 = r4
            r4 = r3
            r3 = r6
        L_0x0038:
            r3.printStackTrace()
            r3 = -1
        L_0x003c:
            if (r4 == 0) goto L_0x0041
            if (r3 == r2) goto L_0x0041
            return r1
        L_0x0041:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.DnsManager.m3253g():boolean");
    }

    /* renamed from: a */
    public final void mo13141a() {
        if (TextUtils.isEmpty(this.f2807k)) {
            return;
        }
        if (TextUtils.isEmpty(this.f2806j) || !this.f2807k.equals(this.f2806j)) {
            this.f2806j = this.f2807k;
            SpUtil.m3487a(this.f2801e, Parameters.IP_ADDRESS, "last_ip", this.f2807k);
        }
    }

    /* renamed from: a */
    public final void mo13142a(LocationRequest cbVar) {
        try {
            this.f2803g = false;
            if (m3252f() && cbVar != null) {
                this.f2798a = cbVar;
                String c = cbVar.mo12967c();
                String host = new URL(c).getHost();
                if ("http://abroad.apilocate.amap.com/mobile/binary".equals(c)) {
                    return;
                }
                if (!"abroad.apilocate.amap.com".equals(host)) {
                    String str = "apilocate.amap.com".equalsIgnoreCase(host) ? "httpdns.apilocate.amap.com" : host;
                    String a = m3248a(str);
                    if (this.f2804h && TextUtils.isEmpty(a)) {
                        this.f2804h = false;
                        a = SpUtil.m3492b(this.f2801e, Parameters.IP_ADDRESS, "last_ip", "");
                        if (!TextUtils.isEmpty(a)) {
                            this.f2806j = a;
                        }
                    }
                    if (!TextUtils.isEmpty(a)) {
                        this.f2807k = a;
                        cbVar.f2859g = c.replace(host, a);
                        cbVar.mo12965a().put("host", str);
                        cbVar.mo13160a(str);
                        this.f2803g = true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public final void mo13143b() {
        if (this.f2803g) {
            SpUtil.m3486a(this.f2801e, "pref", "dns_faile_count_total", 0);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        com.loc.SpUtil.m3486a(r8.f2801e, "pref", "dns_faile_count_total", 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0049, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x003f */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo13144b(com.loc.LocationRequest r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            r0 = 0
            java.lang.String r2 = com.loc.CoreUtil.m3386a()     // Catch:{ Throwable -> 0x003f }
            r9.f2859g = r2     // Catch:{ Throwable -> 0x003f }
            android.content.Context r2 = r8.f2801e     // Catch:{ Throwable -> 0x003f }
            java.lang.String r3 = "pref"
            java.lang.String r4 = "dns_faile_count_total"
            long r2 = com.loc.SpUtil.m3491b((android.content.Context) r2, (java.lang.String) r3, (java.lang.String) r4, (long) r0)     // Catch:{ Throwable -> 0x003f }
            r4 = 2
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 < 0) goto L_0x001b
            monitor-exit(r8)
            return
        L_0x001b:
            com.loc.BaseNetManager.m2998a()     // Catch:{ Throwable -> 0x003f }
            r6 = 0
            com.loc.BaseNetManager.m2999a(r9, r6)     // Catch:{ Throwable -> 0x003f }
            r6 = 1
            long r2 = r2 + r6
            int r9 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r9 < 0) goto L_0x0032
            android.content.Context r9 = r8.f2801e     // Catch:{ Throwable -> 0x003f }
            java.lang.String r4 = "HttpDNS"
            java.lang.String r5 = "dns failed too much"
            com.loc.RollBackDynamic.m3480a(r9, r4, r5)     // Catch:{ Throwable -> 0x003f }
        L_0x0032:
            android.content.Context r9 = r8.f2801e     // Catch:{ Throwable -> 0x003f }
            java.lang.String r4 = "pref"
            java.lang.String r5 = "dns_faile_count_total"
            com.loc.SpUtil.m3486a((android.content.Context) r9, (java.lang.String) r4, (java.lang.String) r5, (long) r2)     // Catch:{ Throwable -> 0x003f }
            monitor-exit(r8)
            return
        L_0x003d:
            r9 = move-exception
            goto L_0x004a
        L_0x003f:
            android.content.Context r9 = r8.f2801e     // Catch:{ all -> 0x003d }
            java.lang.String r2 = "pref"
            java.lang.String r3 = "dns_faile_count_total"
            com.loc.SpUtil.m3486a((android.content.Context) r9, (java.lang.String) r2, (java.lang.String) r3, (long) r0)     // Catch:{ all -> 0x003d }
            monitor-exit(r8)
            return
        L_0x004a:
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.DnsManager.mo13144b(com.loc.cb):void");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0042 A[Catch:{ Throwable -> 0x0060 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo13145d() {
        /*
            r4 = this;
            boolean r0 = r4.m3252f()     // Catch:{ Throwable -> 0x0060 }
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            boolean r0 = r4.f2803g     // Catch:{ Throwable -> 0x0060 }
            if (r0 == 0) goto L_0x0039
            java.lang.String[] r0 = r4.f2808l     // Catch:{ Throwable -> 0x0060 }
            if (r0 == 0) goto L_0x0039
            java.lang.String[] r0 = r4.f2808l     // Catch:{ Throwable -> 0x0060 }
            if (r0 == 0) goto L_0x0039
            int r1 = r0.length     // Catch:{ Throwable -> 0x0039 }
            r2 = 1
            if (r1 > r2) goto L_0x0018
            goto L_0x0039
        L_0x0018:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Throwable -> 0x0039 }
            r2 = 12
            r1.<init>(r2)     // Catch:{ Throwable -> 0x0039 }
            java.util.List r2 = java.util.Arrays.asList(r0)     // Catch:{ Throwable -> 0x0039 }
            r1.addAll(r2)     // Catch:{ Throwable -> 0x0039 }
            java.util.Iterator r2 = r1.iterator()     // Catch:{ Throwable -> 0x0039 }
            java.lang.Object r3 = r2.next()     // Catch:{ Throwable -> 0x0039 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Throwable -> 0x0039 }
            r2.remove()     // Catch:{ Throwable -> 0x0039 }
            r1.add(r3)     // Catch:{ Throwable -> 0x0039 }
            r1.toArray(r0)     // Catch:{ Throwable -> 0x0039 }
        L_0x0039:
            int r0 = r4.f2799b     // Catch:{ Throwable -> 0x0060 }
            r1 = 5
            if (r0 > r1) goto L_0x0060
            boolean r0 = r4.f2803g     // Catch:{ Throwable -> 0x0060 }
            if (r0 == 0) goto L_0x0060
            java.util.concurrent.ExecutorService r0 = r4.f2802f     // Catch:{ Throwable -> 0x0060 }
            if (r0 != 0) goto L_0x004c
            java.util.concurrent.ExecutorService r0 = com.loc.SDKLogHandler.m3869d()     // Catch:{ Throwable -> 0x0060 }
            r4.f2802f = r0     // Catch:{ Throwable -> 0x0060 }
        L_0x004c:
            java.util.concurrent.ExecutorService r0 = r4.f2802f     // Catch:{ Throwable -> 0x0060 }
            boolean r0 = r0.isShutdown()     // Catch:{ Throwable -> 0x0060 }
            if (r0 != 0) goto L_0x0060
            java.util.concurrent.ExecutorService r0 = r4.f2802f     // Catch:{ Throwable -> 0x0060 }
            com.loc.by$a r1 = new com.loc.by$a     // Catch:{ Throwable -> 0x0060 }
            com.loc.cb r2 = r4.f2798a     // Catch:{ Throwable -> 0x0060 }
            r1.<init>(r2)     // Catch:{ Throwable -> 0x0060 }
            r0.submit(r1)     // Catch:{ Throwable -> 0x0060 }
        L_0x0060:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.DnsManager.mo13145d():void");
    }
}
