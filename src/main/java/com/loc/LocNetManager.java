package com.loc;

import android.content.Context;

/* renamed from: com.loc.ca */
public final class LocNetManager {

    /* renamed from: b */
    private static LocNetManager f2851b;

    /* renamed from: a */
    BaseNetManager f2852a = null;

    /* renamed from: c */
    private Context f2853c = null;

    /* renamed from: d */
    private int f2854d = 0;

    /* renamed from: e */
    private int f2855e = CoreUtil.f2982f;

    /* renamed from: f */
    private boolean f2856f = false;

    /* renamed from: g */
    private int f2857g = 0;

    private LocNetManager(Context context) {
        try {
            HttpsDecisionUtil.m3747a().mo13261a(context);
        } catch (Throwable unused) {
        }
        this.f2853c = context;
        this.f2852a = BaseNetManager.m2998a();
    }

    /* renamed from: a */
    public static LocNetManager m3305a(Context context) {
        if (f2851b == null) {
            f2851b = new LocNetManager(context);
        }
        return f2851b;
    }

    /* renamed from: a */
    public final int mo13155a() {
        return this.f2854d;
    }

    /* renamed from: a */
    public final ResponseEntity mo13156a(LocationRequest cbVar) throws Throwable {
        long c = C1079cp.m3529c();
        boolean z = this.f2856f || C1079cp.m3556k(this.f2853c);
        BaseNetManager aiVar = this.f2852a;
        ResponseEntity a = BaseNetManager.m2999a(cbVar, z);
        this.f2854d = Long.valueOf(C1079cp.m3529c() - c).intValue();
        return a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x00c2, code lost:
        r12.put(r14, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00cb, code lost:
        r12.remove("custom");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00d0, code lost:
        r2.f2864l = r12;
        r2.mo13021a(r10.f2855e);
        r2.mo13023b(r10.f2855e);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00de, code lost:
        if (r10.f2856f != false) goto L_0x00e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00e4, code lost:
        if (com.loc.C1079cp.m3556k(r11) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00ec, code lost:
        if (r13.startsWith("http:") == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00ee, code lost:
        r2.f2859g = r2.mo12967c().replace("https:", "https:");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return r2;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.loc.LocationRequest mo13157a(android.content.Context r11, byte[] r12, java.lang.String r13, boolean r14) {
        /*
            r10 = this;
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Throwable -> 0x00fd }
            r1 = 16
            r0.<init>(r1)     // Catch:{ Throwable -> 0x00fd }
            com.loc.cb r2 = new com.loc.cb     // Catch:{ Throwable -> 0x00fd }
            com.loc.di r3 = com.loc.CoreUtil.m3392b()     // Catch:{ Throwable -> 0x00fd }
            r2.<init>(r11, r3)     // Catch:{ Throwable -> 0x00fd }
            java.lang.String r3 = "Content-Type"
            java.lang.String r4 = "application/octet-stream"
            r0.put(r3, r4)     // Catch:{ Throwable -> 0x00ff }
            java.lang.String r3 = "Accept-Encoding"
            java.lang.String r4 = "gzip"
            r0.put(r3, r4)     // Catch:{ Throwable -> 0x00ff }
            java.lang.String r3 = "gzipped"
            java.lang.String r4 = "1"
            r0.put(r3, r4)     // Catch:{ Throwable -> 0x00ff }
            java.lang.String r3 = "Connection"
            java.lang.String r4 = "Keep-Alive"
            r0.put(r3, r4)     // Catch:{ Throwable -> 0x00ff }
            java.lang.String r3 = "User-Agent"
            java.lang.String r4 = "AMAP_Location_SDK_Android 4.7.2"
            r0.put(r3, r4)     // Catch:{ Throwable -> 0x00ff }
            java.lang.String r3 = "KEY"
            java.lang.String r4 = com.loc.AppInfo.m3666f(r11)     // Catch:{ Throwable -> 0x00ff }
            r0.put(r3, r4)     // Catch:{ Throwable -> 0x00ff }
            java.lang.String r3 = "enginever"
            java.lang.String r4 = "5.1"
            r0.put(r3, r4)     // Catch:{ Throwable -> 0x00ff }
            java.lang.String r3 = com.loc.ClientInfo.m3686a()     // Catch:{ Throwable -> 0x00ff }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00ff }
            java.lang.String r5 = "key="
            r4.<init>(r5)     // Catch:{ Throwable -> 0x00ff }
            java.lang.String r5 = com.loc.AppInfo.m3666f(r11)     // Catch:{ Throwable -> 0x00ff }
            r4.append(r5)     // Catch:{ Throwable -> 0x00ff }
            java.lang.String r4 = r4.toString()     // Catch:{ Throwable -> 0x00ff }
            java.lang.String r4 = com.loc.ClientInfo.m3687a(r11, r3, r4)     // Catch:{ Throwable -> 0x00ff }
            java.lang.String r5 = "ts"
            r0.put(r5, r3)     // Catch:{ Throwable -> 0x00ff }
            java.lang.String r3 = "scode"
            r0.put(r3, r4)     // Catch:{ Throwable -> 0x00ff }
            java.lang.String r3 = "encr"
            java.lang.String r4 = "1"
            r0.put(r3, r4)     // Catch:{ Throwable -> 0x00ff }
            r2.f2858f = r0     // Catch:{ Throwable -> 0x00ff }
            java.lang.String r0 = "loc"
            if (r14 != 0) goto L_0x0076
            java.lang.String r0 = "locf"
        L_0x0076:
            r3 = 1
            r2.f2865m = r3     // Catch:{ Throwable -> 0x00ff }
            java.util.Locale r4 = java.util.Locale.US     // Catch:{ Throwable -> 0x00ff }
            java.lang.String r5 = "platform=Android&sdkversion=%s&product=%s&loc_channel=%s"
            r6 = 3
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ Throwable -> 0x00ff }
            r8 = 0
            java.lang.String r9 = "4.7.2"
            r7[r8] = r9     // Catch:{ Throwable -> 0x00ff }
            r7[r3] = r0     // Catch:{ Throwable -> 0x00ff }
            r0 = 2
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)     // Catch:{ Throwable -> 0x00ff }
            r7[r0] = r3     // Catch:{ Throwable -> 0x00ff }
            java.lang.String r0 = java.lang.String.format(r4, r5, r7)     // Catch:{ Throwable -> 0x00ff }
            r2.f2863k = r0     // Catch:{ Throwable -> 0x00ff }
            r2.f2862j = r14     // Catch:{ Throwable -> 0x00ff }
            r2.f2859g = r13     // Catch:{ Throwable -> 0x00ff }
            byte[] r12 = com.loc.C1079cp.m3515a((byte[]) r12)     // Catch:{ Throwable -> 0x00ff }
            r2.f2860h = r12     // Catch:{ Throwable -> 0x00ff }
            java.net.Proxy r12 = com.loc.ProxyUtil.m3768a(r11)     // Catch:{ Throwable -> 0x00ff }
            r2.mo13022a((java.net.Proxy) r12)     // Catch:{ Throwable -> 0x00ff }
            java.util.HashMap r12 = new java.util.HashMap     // Catch:{ Throwable -> 0x00ff }
            r12.<init>(r1)     // Catch:{ Throwable -> 0x00ff }
            java.lang.String r14 = "output"
            java.lang.String r0 = "bin"
            r12.put(r14, r0)     // Catch:{ Throwable -> 0x00ff }
            java.lang.String r14 = "policy"
            java.lang.String r0 = "3103"
            r12.put(r14, r0)     // Catch:{ Throwable -> 0x00ff }
            int r14 = r10.f2857g     // Catch:{ Throwable -> 0x00ff }
            switch(r14) {
                case 0: goto L_0x00cb;
                case 1: goto L_0x00c6;
                case 2: goto L_0x00be;
                default: goto L_0x00bd;
            }     // Catch:{ Throwable -> 0x00ff }
        L_0x00bd:
            goto L_0x00cb
        L_0x00be:
            java.lang.String r14 = "custom"
            java.lang.String r0 = "language:en"
        L_0x00c2:
            r12.put(r14, r0)     // Catch:{ Throwable -> 0x00ff }
            goto L_0x00d0
        L_0x00c6:
            java.lang.String r14 = "custom"
            java.lang.String r0 = "language:cn"
            goto L_0x00c2
        L_0x00cb:
            java.lang.String r14 = "custom"
            r12.remove(r14)     // Catch:{ Throwable -> 0x00ff }
        L_0x00d0:
            r2.f2864l = r12     // Catch:{ Throwable -> 0x00ff }
            int r12 = r10.f2855e     // Catch:{ Throwable -> 0x00ff }
            r2.mo13021a((int) r12)     // Catch:{ Throwable -> 0x00ff }
            int r12 = r10.f2855e     // Catch:{ Throwable -> 0x00ff }
            r2.mo13023b(r12)     // Catch:{ Throwable -> 0x00ff }
            boolean r12 = r10.f2856f     // Catch:{ Throwable -> 0x00ff }
            if (r12 != 0) goto L_0x00e6
            boolean r11 = com.loc.C1079cp.m3556k(r11)     // Catch:{ Throwable -> 0x00ff }
            if (r11 == 0) goto L_0x00ff
        L_0x00e6:
            java.lang.String r11 = "http:"
            boolean r11 = r13.startsWith(r11)     // Catch:{ Throwable -> 0x00ff }
            if (r11 == 0) goto L_0x00ff
            java.lang.String r11 = r2.mo12967c()     // Catch:{ Throwable -> 0x00ff }
            java.lang.String r12 = "https:"
            java.lang.String r13 = "https:"
            java.lang.String r11 = r11.replace(r12, r13)     // Catch:{ Throwable -> 0x00ff }
            r2.f2859g = r11     // Catch:{ Throwable -> 0x00ff }
            goto L_0x00ff
        L_0x00fd:
            r11 = 0
            r2 = r11
        L_0x00ff:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.LocNetManager.mo13157a(android.content.Context, byte[], java.lang.String, boolean):com.loc.cb");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x00c7, code lost:
        if (com.loc.C1079cp.m3556k(r7) == false) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00c9, code lost:
        r2.f2859g = "http://restapi.amap.com/v3/geocode/regeo".replace("http:", "https:");
        r7 = r6.f2852a;
        r7 = com.loc.BaseNetManager.m3000a(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00da, code lost:
        r2.f2859g = "http://restapi.amap.com/v3/geocode/regeo";
        r7 = r6.f2852a;
        r7 = com.loc.BaseNetManager.m3001b(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return new java.lang.String(r7, com.baidu.p020ar.util.IoUtils.UTF_8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0047, code lost:
        r3.put(r1, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0050, code lost:
        r3.remove("language");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0055, code lost:
        r1 = com.loc.ClientInfo.m3686a();
        r4 = com.loc.ClientInfo.m3687a(r7, r1, com.loc.C1107dj.m3821b((java.util.Map<java.lang.String, java.lang.String>) r3));
        r3.put("ts", r1);
        r3.put("scode", r4);
        r2.mo13161b(("output=json&radius=1000&extensions=all&location=" + r10 + com.baidu.p020ar.util.SystemInfoUtil.COMMA + r8).getBytes("UTF-8"));
        r2.f2865m = false;
        r2.f2862j = true;
        r2.f2863k = java.lang.String.format(java.util.Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", new java.lang.Object[]{"4.7.2", "loc", 3});
        r2.f2864l = r3;
        r2.f2858f = r0;
        r2.mo13022a(com.loc.ProxyUtil.m3768a(r7));
        r2.mo13021a(com.loc.CoreUtil.f2982f);
        r2.mo13023b(com.loc.CoreUtil.f2982f);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String mo13158a(android.content.Context r7, double r8, double r10) {
        /*
            r6 = this;
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Throwable -> 0x00f2 }
            r1 = 16
            r0.<init>(r1)     // Catch:{ Throwable -> 0x00f2 }
            com.loc.cb r2 = new com.loc.cb     // Catch:{ Throwable -> 0x00f2 }
            com.loc.di r3 = com.loc.CoreUtil.m3392b()     // Catch:{ Throwable -> 0x00f2 }
            r2.<init>(r7, r3)     // Catch:{ Throwable -> 0x00f2 }
            r0.clear()     // Catch:{ Throwable -> 0x00f2 }
            java.lang.String r3 = "Content-Type"
            java.lang.String r4 = "application/x-www-form-urlencoded"
            r0.put(r3, r4)     // Catch:{ Throwable -> 0x00f2 }
            java.lang.String r3 = "Connection"
            java.lang.String r4 = "Keep-Alive"
            r0.put(r3, r4)     // Catch:{ Throwable -> 0x00f2 }
            java.lang.String r3 = "User-Agent"
            java.lang.String r4 = "AMAP_Location_SDK_Android 4.7.2"
            r0.put(r3, r4)     // Catch:{ Throwable -> 0x00f2 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Throwable -> 0x00f2 }
            r3.<init>(r1)     // Catch:{ Throwable -> 0x00f2 }
            java.lang.String r1 = "custom"
            java.lang.String r4 = "26260A1F00020002"
            r3.put(r1, r4)     // Catch:{ Throwable -> 0x00f2 }
            java.lang.String r1 = "key"
            java.lang.String r4 = com.loc.AppInfo.m3666f(r7)     // Catch:{ Throwable -> 0x00f2 }
            r3.put(r1, r4)     // Catch:{ Throwable -> 0x00f2 }
            int r1 = r6.f2857g     // Catch:{ Throwable -> 0x00f2 }
            switch(r1) {
                case 0: goto L_0x0050;
                case 1: goto L_0x004b;
                case 2: goto L_0x0043;
                default: goto L_0x0042;
            }     // Catch:{ Throwable -> 0x00f2 }
        L_0x0042:
            goto L_0x0050
        L_0x0043:
            java.lang.String r1 = "language"
            java.lang.String r4 = "en"
        L_0x0047:
            r3.put(r1, r4)     // Catch:{ Throwable -> 0x00f2 }
            goto L_0x0055
        L_0x004b:
            java.lang.String r1 = "language"
            java.lang.String r4 = "zh-CN"
            goto L_0x0047
        L_0x0050:
            java.lang.String r1 = "language"
            r3.remove(r1)     // Catch:{ Throwable -> 0x00f2 }
        L_0x0055:
            java.lang.String r1 = com.loc.ClientInfo.m3686a()     // Catch:{ Throwable -> 0x00f2 }
            java.lang.String r4 = com.loc.C1107dj.m3821b((java.util.Map<java.lang.String, java.lang.String>) r3)     // Catch:{ Throwable -> 0x00f2 }
            java.lang.String r4 = com.loc.ClientInfo.m3687a(r7, r1, r4)     // Catch:{ Throwable -> 0x00f2 }
            java.lang.String r5 = "ts"
            r3.put(r5, r1)     // Catch:{ Throwable -> 0x00f2 }
            java.lang.String r1 = "scode"
            r3.put(r1, r4)     // Catch:{ Throwable -> 0x00f2 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00f2 }
            java.lang.String r4 = "output=json&radius=1000&extensions=all&location="
            r1.<init>(r4)     // Catch:{ Throwable -> 0x00f2 }
            r1.append(r10)     // Catch:{ Throwable -> 0x00f2 }
            java.lang.String r10 = ","
            r1.append(r10)     // Catch:{ Throwable -> 0x00f2 }
            r1.append(r8)     // Catch:{ Throwable -> 0x00f2 }
            java.lang.String r8 = r1.toString()     // Catch:{ Throwable -> 0x00f2 }
            java.lang.String r9 = "UTF-8"
            byte[] r8 = r8.getBytes(r9)     // Catch:{ Throwable -> 0x00f2 }
            r2.mo13161b(r8)     // Catch:{ Throwable -> 0x00f2 }
            r8 = 0
            r2.f2865m = r8     // Catch:{ Throwable -> 0x00f2 }
            r9 = 1
            r2.f2862j = r9     // Catch:{ Throwable -> 0x00f2 }
            java.util.Locale r10 = java.util.Locale.US     // Catch:{ Throwable -> 0x00f2 }
            java.lang.String r11 = "platform=Android&sdkversion=%s&product=%s&loc_channel=%s"
            r1 = 3
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Throwable -> 0x00f2 }
            java.lang.String r5 = "4.7.2"
            r4[r8] = r5     // Catch:{ Throwable -> 0x00f2 }
            java.lang.String r8 = "loc"
            r4[r9] = r8     // Catch:{ Throwable -> 0x00f2 }
            r8 = 2
            java.lang.Integer r9 = java.lang.Integer.valueOf(r1)     // Catch:{ Throwable -> 0x00f2 }
            r4[r8] = r9     // Catch:{ Throwable -> 0x00f2 }
            java.lang.String r8 = java.lang.String.format(r10, r11, r4)     // Catch:{ Throwable -> 0x00f2 }
            r2.f2863k = r8     // Catch:{ Throwable -> 0x00f2 }
            r2.f2864l = r3     // Catch:{ Throwable -> 0x00f2 }
            r2.f2858f = r0     // Catch:{ Throwable -> 0x00f2 }
            java.net.Proxy r8 = com.loc.ProxyUtil.m3768a(r7)     // Catch:{ Throwable -> 0x00f2 }
            r2.mo13022a((java.net.Proxy) r8)     // Catch:{ Throwable -> 0x00f2 }
            int r8 = com.loc.CoreUtil.f2982f     // Catch:{ Throwable -> 0x00f2 }
            r2.mo13021a((int) r8)     // Catch:{ Throwable -> 0x00f2 }
            int r8 = com.loc.CoreUtil.f2982f     // Catch:{ Throwable -> 0x00f2 }
            r2.mo13023b(r8)     // Catch:{ Throwable -> 0x00f2 }
            java.lang.String r8 = "http://restapi.amap.com/v3/geocode/regeo"
            boolean r7 = com.loc.C1079cp.m3556k(r7)     // Catch:{ Throwable -> 0x00ea }
            if (r7 == 0) goto L_0x00da
            java.lang.String r7 = "http:"
            java.lang.String r9 = "https:"
            java.lang.String r7 = r8.replace(r7, r9)     // Catch:{ Throwable -> 0x00ea }
            r2.f2859g = r7     // Catch:{ Throwable -> 0x00ea }
            com.loc.ai r7 = r6.f2852a     // Catch:{ Throwable -> 0x00ea }
            byte[] r7 = com.loc.BaseNetManager.m3000a(r2)     // Catch:{ Throwable -> 0x00ea }
            goto L_0x00e2
        L_0x00da:
            r2.f2859g = r8     // Catch:{ Throwable -> 0x00ea }
            com.loc.ai r7 = r6.f2852a     // Catch:{ Throwable -> 0x00ea }
            byte[] r7 = com.loc.BaseNetManager.m3001b(r2)     // Catch:{ Throwable -> 0x00ea }
        L_0x00e2:
            java.lang.String r8 = new java.lang.String     // Catch:{ Throwable -> 0x00ea }
            java.lang.String r9 = "utf-8"
            r8.<init>(r7, r9)     // Catch:{ Throwable -> 0x00ea }
            goto L_0x00f3
        L_0x00ea:
            r7 = move-exception
            java.lang.String r8 = "LocNetManager"
            java.lang.String r9 = "post"
            com.loc.CoreUtil.m3389a(r7, r8, r9)     // Catch:{ Throwable -> 0x00f2 }
        L_0x00f2:
            r8 = 0
        L_0x00f3:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.LocNetManager.mo13158a(android.content.Context, double, double):java.lang.String");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0009 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo13159a(long r2, boolean r4, int r5) {
        /*
            r1 = this;
            r1.f2856f = r4     // Catch:{ Throwable -> 0x0016 }
            com.loc.de r0 = com.loc.HttpsDecisionUtil.m3747a()     // Catch:{ Throwable -> 0x0009 }
            r0.mo13263a((boolean) r4)     // Catch:{ Throwable -> 0x0009 }
        L_0x0009:
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ Throwable -> 0x0016 }
            int r2 = r2.intValue()     // Catch:{ Throwable -> 0x0016 }
            r1.f2855e = r2     // Catch:{ Throwable -> 0x0016 }
            r1.f2857g = r5     // Catch:{ Throwable -> 0x0016 }
            return
        L_0x0016:
            r2 = move-exception
            java.lang.String r3 = "LocNetManager"
            java.lang.String r4 = "setOption"
            com.loc.CoreUtil.m3389a(r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.LocNetManager.mo13159a(long, boolean, int):void");
    }
}
