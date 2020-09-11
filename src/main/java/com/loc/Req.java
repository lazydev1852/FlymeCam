package com.loc;

import android.annotation.SuppressLint;
import android.net.wifi.ScanResult;
import android.text.TextUtils;
import com.baidu.p020ar.util.SystemInfoUtil;
import java.util.ArrayList;

@SuppressLint({"NewApi"})
/* renamed from: com.loc.cd */
public final class Req {

    /* renamed from: J */
    protected static String f2869J;

    /* renamed from: L */
    protected static String f2870L;

    /* renamed from: A */
    protected String f2871A = null;

    /* renamed from: B */
    protected String f2872B = null;

    /* renamed from: C */
    protected ArrayList<Cgi> f2873C = new ArrayList<>();

    /* renamed from: D */
    protected String f2874D = null;

    /* renamed from: E */
    protected String f2875E = null;

    /* renamed from: F */
    protected ArrayList<ScanResult> f2876F = new ArrayList<>();

    /* renamed from: G */
    protected String f2877G = null;

    /* renamed from: H */
    protected String f2878H = null;

    /* renamed from: I */
    protected byte[] f2879I = null;

    /* renamed from: K */
    protected String f2880K = null;

    /* renamed from: M */
    protected String f2881M = null;

    /* renamed from: N */
    protected String f2882N = null;

    /* renamed from: O */
    private byte[] f2883O = null;

    /* renamed from: P */
    private int f2884P = 0;

    /* renamed from: a */
    public String f2885a = "1";

    /* renamed from: b */
    protected short f2886b = 0;

    /* renamed from: c */
    protected String f2887c = null;

    /* renamed from: d */
    protected String f2888d = null;

    /* renamed from: e */
    protected String f2889e = null;

    /* renamed from: f */
    protected String f2890f = null;

    /* renamed from: g */
    protected String f2891g = null;

    /* renamed from: h */
    public String f2892h = null;

    /* renamed from: i */
    public String f2893i = null;

    /* renamed from: j */
    protected String f2894j = null;

    /* renamed from: k */
    protected String f2895k = null;

    /* renamed from: l */
    protected String f2896l = null;

    /* renamed from: m */
    protected String f2897m = null;

    /* renamed from: n */
    protected String f2898n = null;

    /* renamed from: o */
    protected String f2899o = null;

    /* renamed from: p */
    protected String f2900p = null;

    /* renamed from: q */
    protected String f2901q = null;

    /* renamed from: r */
    protected String f2902r = null;

    /* renamed from: s */
    protected String f2903s = null;

    /* renamed from: t */
    protected String f2904t = null;

    /* renamed from: u */
    protected String f2905u = null;

    /* renamed from: v */
    protected String f2906v = null;

    /* renamed from: w */
    protected String f2907w = null;

    /* renamed from: x */
    protected String f2908x = null;

    /* renamed from: y */
    protected String f2909y = null;

    /* renamed from: z */
    protected int f2910z = 0;

    /* renamed from: a */
    private static int m3328a(String str, byte[] bArr, int i) {
        try {
            if (TextUtils.isEmpty(str)) {
                bArr[i] = 0;
                return i + 1;
            }
            byte[] bytes = str.getBytes("GBK");
            int length = bytes.length;
            if (length > 127) {
                length = 127;
            }
            bArr[i] = (byte) length;
            int i2 = i + 1;
            System.arraycopy(bytes, 0, bArr, i2, length);
            return i2 + length;
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "Req", "copyContentWithByteLen");
            bArr[i] = 0;
        }
    }

    /* renamed from: a */
    private String m3329a(String str, int i) {
        String[] split = this.f2872B.split("\\*")[i].split(SystemInfoUtil.COMMA);
        if ("lac".equals(str)) {
            return split[0];
        }
        if ("cellid".equals(str)) {
            return split[1];
        }
        if ("signal".equals(str)) {
            return split[2];
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0023 A[Catch:{ Throwable -> 0x0010 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] m3330a(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = ":"
            java.lang.String[] r0 = r7.split(r0)
            r1 = 6
            byte[] r2 = new byte[r1]
            r3 = 0
            if (r0 == 0) goto L_0x0012
            int r4 = r0.length     // Catch:{ Throwable -> 0x0010 }
            if (r4 == r1) goto L_0x001f
            goto L_0x0012
        L_0x0010:
            r0 = move-exception
            goto L_0x0042
        L_0x0012:
            java.lang.String[] r0 = new java.lang.String[r1]     // Catch:{ Throwable -> 0x0010 }
            r1 = 0
        L_0x0015:
            int r4 = r0.length     // Catch:{ Throwable -> 0x0010 }
            if (r1 >= r4) goto L_0x001f
            java.lang.String r4 = "0"
            r0[r1] = r4     // Catch:{ Throwable -> 0x0010 }
            int r1 = r1 + 1
            goto L_0x0015
        L_0x001f:
            r1 = 0
        L_0x0020:
            int r4 = r0.length     // Catch:{ Throwable -> 0x0010 }
            if (r1 >= r4) goto L_0x005b
            r4 = r0[r1]     // Catch:{ Throwable -> 0x0010 }
            int r4 = r4.length()     // Catch:{ Throwable -> 0x0010 }
            r5 = 2
            if (r4 <= r5) goto L_0x0034
            r4 = r0[r1]     // Catch:{ Throwable -> 0x0010 }
            java.lang.String r4 = r4.substring(r3, r5)     // Catch:{ Throwable -> 0x0010 }
            r0[r1] = r4     // Catch:{ Throwable -> 0x0010 }
        L_0x0034:
            r4 = r0[r1]     // Catch:{ Throwable -> 0x0010 }
            r5 = 16
            int r4 = java.lang.Integer.parseInt(r4, r5)     // Catch:{ Throwable -> 0x0010 }
            byte r4 = (byte) r4     // Catch:{ Throwable -> 0x0010 }
            r2[r1] = r4     // Catch:{ Throwable -> 0x0010 }
            int r1 = r1 + 1
            goto L_0x0020
        L_0x0042:
            java.lang.String r1 = "Req"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "getMacBa "
            r2.<init>(r3)
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            com.loc.CoreUtil.m3389a(r0, r1, r7)
            java.lang.String r7 = "00:00:00:00:00:00"
            byte[] r2 = r6.m3330a(r7)
        L_0x005b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.Req.m3330a(java.lang.String):byte[]");
    }

    /* renamed from: b */
    private String m3331b(String str) {
        String str2 = this.f2871A;
        if (!str2.contains(str + ">")) {
            return "0";
        }
        String str3 = this.f2871A;
        int indexOf = str3.indexOf(str + ">");
        String str4 = this.f2871A;
        return this.f2871A.substring(indexOf + str.length() + 1, str4.indexOf("</" + str));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(29:0|(1:2)|3|(1:5)|6|(9:8|(2:10|11)|14|15|(1:19)|20|(2:22|23)|26|(1:31))(1:32)|(3:33|34|35)|38|(2:40|(1:42)(1:43))(1:44)|45|(3:47|48|64)(1:65)|66|(1:71)(1:70)|72|(2:(2:75|(7:77|(1:79)|82|83|84|(1:88)|89))|(1:93))(2:94|(1:96))|97|(1:99)|100|101|102|(1:104)|105|106|(1:108)|109|110|(1:112)|113|115) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:105:0x035b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:109:0x0369 */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0363 A[Catch:{ Throwable -> 0x0369 }] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0371 A[Catch:{ Throwable -> 0x0377 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo13166a(android.content.Context r29, boolean r30, boolean r31, com.loc.CgiManager r32, com.loc.WifiManagerWrapper r33, android.net.ConnectivityManager r34, java.lang.String r35, java.lang.String r36) {
        /*
            r28 = this;
            r1 = r28
            java.lang.String r0 = "0"
            java.lang.String r2 = "0"
            java.lang.String r3 = "0"
            java.lang.String r4 = "0"
            java.lang.String r5 = "0"
            java.lang.String r6 = com.loc.AppInfo.m3666f(r29)
            int r7 = com.loc.C1079cp.m3546g()
            java.lang.String r8 = ""
            java.lang.String r9 = ""
            java.lang.String r10 = ""
            r11 = r36
            r1.f2880K = r11
            java.lang.String r11 = "api_serverSDK_130905"
            java.lang.String r12 = "S128DF1572465B890OE3F7A13167KLEI"
            if (r31 != 0) goto L_0x0028
            java.lang.String r11 = "UC_nlp_20131029"
            java.lang.String r12 = "BKZCHMBBSSUK7U8GLUKHBB56CCFF78U"
        L_0x0028:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            int r14 = r32.mo13083e()
            int r15 = r32.mo13084f()
            android.telephony.TelephonyManager r16 = r32.mo13085g()
            r17 = r8
            java.util.ArrayList r8 = r32.mo13077a()
            r18 = r9
            java.util.ArrayList r9 = r32.mo13080b()
            r19 = r10
            java.util.ArrayList r10 = r33.mo13109c()
            r20 = r7
            r7 = 2
            if (r15 != r7) goto L_0x0052
            java.lang.String r0 = "1"
        L_0x0052:
            r21 = r0
            if (r16 == 0) goto L_0x00ae
            java.lang.String r0 = com.loc.CoreUtil.f2980d
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0070
            java.lang.String r0 = com.loc.DeviceInfo.m3733v(r29)     // Catch:{ Throwable -> 0x0065 }
            com.loc.CoreUtil.f2980d = r0     // Catch:{ Throwable -> 0x0065 }
            goto L_0x0070
        L_0x0065:
            r0 = move-exception
            java.lang.String r7 = "Aps"
            r22 = r6
            java.lang.String r6 = "getApsReq part4"
            com.loc.CoreUtil.m3389a(r0, r7, r6)
            goto L_0x0072
        L_0x0070:
            r22 = r6
        L_0x0072:
            java.lang.String r0 = com.loc.CoreUtil.f2980d
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r6 = 29
            if (r0 == 0) goto L_0x0084
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 >= r6) goto L_0x0084
            java.lang.String r0 = "888888888888888"
            com.loc.CoreUtil.f2980d = r0
        L_0x0084:
            java.lang.String r0 = com.loc.CoreUtil.f2981e
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x009b
            java.lang.String r0 = com.loc.DeviceInfo.m3735x(r29)     // Catch:{ SecurityException -> 0x009b, Throwable -> 0x0093 }
            com.loc.CoreUtil.f2981e = r0     // Catch:{ SecurityException -> 0x009b, Throwable -> 0x0093 }
            goto L_0x009b
        L_0x0093:
            r0 = move-exception
            java.lang.String r7 = "Aps"
            java.lang.String r6 = "getApsReq part2"
            com.loc.CoreUtil.m3389a(r0, r7, r6)
        L_0x009b:
            java.lang.String r0 = com.loc.CoreUtil.f2981e
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x00b0
            int r0 = android.os.Build.VERSION.SDK_INT
            r6 = 29
            if (r0 >= r6) goto L_0x00b0
            java.lang.String r0 = "888888888888888"
            com.loc.CoreUtil.f2981e = r0
            goto L_0x00b0
        L_0x00ae:
            r22 = r6
        L_0x00b0:
            android.net.NetworkInfo r0 = r34.getActiveNetworkInfo()     // Catch:{ Throwable -> 0x00b7 }
            r23 = r0
            goto L_0x00c2
        L_0x00b7:
            r0 = move-exception
            r7 = r0
            java.lang.String r0 = "Aps"
            java.lang.String r6 = "getApsReq part"
            com.loc.CoreUtil.m3389a(r7, r0, r6)
            r23 = 0
        L_0x00c2:
            boolean r0 = r33.mo13106a((android.net.ConnectivityManager) r34)
            int r6 = com.loc.C1079cp.m3500a((android.net.NetworkInfo) r23)
            r7 = -1
            if (r6 == r7) goto L_0x00d9
            java.lang.String r6 = com.loc.C1079cp.m3521b((android.telephony.TelephonyManager) r16)
            if (r0 == 0) goto L_0x00d6
            java.lang.String r7 = "2"
            goto L_0x00dd
        L_0x00d6:
            java.lang.String r7 = "1"
            goto L_0x00dd
        L_0x00d9:
            r6 = r17
            r7 = r18
        L_0x00dd:
            boolean r16 = r8.isEmpty()
            r24 = r7
            if (r16 != 0) goto L_0x0228
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            switch(r15) {
                case 1: goto L_0x0180;
                case 2: goto L_0x00f5;
                default: goto L_0x00ed;
            }
        L_0x00ed:
            r26 = r5
            r25 = r6
            r27 = r19
            goto L_0x021d
        L_0x00f5:
            r15 = 0
            java.lang.Object r8 = r8.get(r15)
            com.loc.bq r8 = (com.loc.Cgi) r8
            r25 = r6
            int r6 = r7.length()
            r7.delete(r15, r6)
            java.lang.String r6 = "<mcc>"
            r7.append(r6)
            int r6 = r8.f2706a
            r7.append(r6)
            java.lang.String r6 = "</mcc>"
            r7.append(r6)
            java.lang.String r6 = "<sid>"
            r7.append(r6)
            int r6 = r8.f2712g
            r7.append(r6)
            java.lang.String r6 = "</sid>"
            r7.append(r6)
            java.lang.String r6 = "<nid>"
            r7.append(r6)
            int r6 = r8.f2713h
            r7.append(r6)
            java.lang.String r6 = "</nid>"
            r7.append(r6)
            java.lang.String r6 = "<bid>"
            r7.append(r6)
            int r6 = r8.f2714i
            r7.append(r6)
            java.lang.String r6 = "</bid>"
            r7.append(r6)
            int r6 = r8.f2711f
            if (r6 <= 0) goto L_0x0167
            int r6 = r8.f2710e
            if (r6 <= 0) goto L_0x0167
            java.lang.String r6 = "<lon>"
            r7.append(r6)
            int r6 = r8.f2711f
            r7.append(r6)
            java.lang.String r6 = "</lon>"
            r7.append(r6)
            java.lang.String r6 = "<lat>"
            r7.append(r6)
            int r6 = r8.f2710e
            r7.append(r6)
            java.lang.String r6 = "</lat>"
            r7.append(r6)
        L_0x0167:
            java.lang.String r6 = "<signal>"
            r7.append(r6)
            int r6 = r8.f2715j
            r7.append(r6)
            java.lang.String r6 = "</signal>"
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r26 = r5
            r27 = r6
            goto L_0x021d
        L_0x0180:
            r25 = r6
            r6 = 0
            java.lang.Object r15 = r8.get(r6)
            com.loc.bq r15 = (com.loc.Cgi) r15
            r26 = r5
            int r5 = r7.length()
            r7.delete(r6, r5)
            java.lang.String r5 = "<mcc>"
            r7.append(r5)
            int r5 = r15.f2706a
            r7.append(r5)
            java.lang.String r5 = "</mcc>"
            r7.append(r5)
            java.lang.String r5 = "<mnc>"
            r7.append(r5)
            int r5 = r15.f2707b
            r7.append(r5)
            java.lang.String r5 = "</mnc>"
            r7.append(r5)
            java.lang.String r5 = "<lac>"
            r7.append(r5)
            int r5 = r15.f2708c
            r7.append(r5)
            java.lang.String r5 = "</lac>"
            r7.append(r5)
            java.lang.String r5 = "<cellid>"
            r7.append(r5)
            int r5 = r15.f2709d
            r7.append(r5)
            java.lang.String r5 = "</cellid>"
            r7.append(r5)
            java.lang.String r5 = "<signal>"
            r7.append(r5)
            int r5 = r15.f2715j
            r7.append(r5)
            java.lang.String r5 = "</signal>"
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r15 = 1
        L_0x01e2:
            int r6 = r8.size()
            if (r15 >= r6) goto L_0x021b
            java.lang.Object r6 = r8.get(r15)
            com.loc.bq r6 = (com.loc.Cgi) r6
            r27 = r5
            int r5 = r6.f2708c
            r13.append(r5)
            java.lang.String r5 = ","
            r13.append(r5)
            int r5 = r6.f2709d
            r13.append(r5)
            java.lang.String r5 = ","
            r13.append(r5)
            int r5 = r6.f2715j
            r13.append(r5)
            int r5 = r8.size()
            r6 = 1
            int r5 = r5 - r6
            if (r15 >= r5) goto L_0x0216
            java.lang.String r5 = "*"
            r13.append(r5)
        L_0x0216:
            int r15 = r15 + 1
            r5 = r27
            goto L_0x01e2
        L_0x021b:
            r27 = r5
        L_0x021d:
            int r5 = r7.length()
            r6 = 0
            r7.delete(r6, r5)
            r5 = r27
            goto L_0x022e
        L_0x0228:
            r26 = r5
            r25 = r6
            r5 = r19
        L_0x022e:
            r6 = r14 & 4
            r7 = 4
            if (r6 != r7) goto L_0x0244
            boolean r6 = r9.isEmpty()
            if (r6 != 0) goto L_0x0244
            java.util.ArrayList<com.loc.bq> r6 = r1.f2873C
            r6.clear()
            java.util.ArrayList<com.loc.bq> r6 = r1.f2873C
            r6.addAll(r9)
            goto L_0x0249
        L_0x0244:
            java.util.ArrayList<com.loc.bq> r6 = r1.f2873C
            r6.clear()
        L_0x0249:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            boolean r7 = r33.mo13113g()
            if (r7 == 0) goto L_0x02b7
            if (r0 == 0) goto L_0x02a6
            android.net.wifi.WifiInfo r0 = r33.mo13114h()
            boolean r7 = com.loc.WifiManagerWrapper.m3186a((android.net.wifi.WifiInfo) r0)
            if (r7 == 0) goto L_0x02a6
            java.lang.String r7 = r0.getBSSID()
            r6.append(r7)
            java.lang.String r7 = ","
            r6.append(r7)
            int r7 = r0.getRssi()
            r8 = -128(0xffffffffffffff80, float:NaN)
            if (r7 >= r8) goto L_0x0276
        L_0x0274:
            r7 = 0
            goto L_0x027b
        L_0x0276:
            r8 = 127(0x7f, float:1.78E-43)
            if (r7 <= r8) goto L_0x027b
            goto L_0x0274
        L_0x027b:
            r6.append(r7)
            java.lang.String r7 = ","
            r6.append(r7)
            java.lang.String r7 = r0.getSSID()
            r8 = 32
            java.lang.String r0 = r0.getSSID()     // Catch:{ Exception -> 0x0295 }
            java.lang.String r9 = "UTF-8"
            byte[] r0 = r0.getBytes(r9)     // Catch:{ Exception -> 0x0295 }
            int r0 = r0.length     // Catch:{ Exception -> 0x0295 }
            goto L_0x0297
        L_0x0295:
            r0 = 32
        L_0x0297:
            if (r0 < r8) goto L_0x029b
            java.lang.String r7 = "unkwn"
        L_0x029b:
            java.lang.String r0 = "*"
            java.lang.String r8 = "."
            java.lang.String r0 = r7.replace(r0, r8)
            r6.append(r0)
        L_0x02a6:
            if (r10 == 0) goto L_0x02c3
            java.util.ArrayList<android.net.wifi.ScanResult> r0 = r1.f2876F
            if (r0 == 0) goto L_0x02c3
            java.util.ArrayList<android.net.wifi.ScanResult> r0 = r1.f2876F
            r0.clear()
            java.util.ArrayList<android.net.wifi.ScanResult> r0 = r1.f2876F
            r0.addAll(r10)
            goto L_0x02c3
        L_0x02b7:
            r33.mo13110d()
            java.util.ArrayList<android.net.wifi.ScanResult> r0 = r1.f2876F
            if (r0 == 0) goto L_0x02c3
            java.util.ArrayList<android.net.wifi.ScanResult> r0 = r1.f2876F
            r0.clear()
        L_0x02c3:
            r0 = 0
            r1.f2886b = r0
            if (r30 != 0) goto L_0x02cf
            short r0 = r1.f2886b
            r7 = 2
            r0 = r0 | r7
            short r0 = (short) r0
            r1.f2886b = r0
        L_0x02cf:
            r1.f2887c = r11
            r1.f2888d = r12
            java.lang.String r0 = com.loc.C1079cp.m3539e()
            r1.f2890f = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r7 = "android"
            r0.<init>(r7)
            java.lang.String r7 = com.loc.C1079cp.m3543f()
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            r1.f2891g = r0
            java.lang.String r0 = com.loc.C1079cp.m3520b((android.content.Context) r29)
            r1.f2892h = r0
            r7 = r21
            r1.f2893i = r7
            r1.f2894j = r2
            java.lang.String r0 = "0"
            r1.f2895k = r0
            r1.f2896l = r3
            r1.f2897m = r4
            r2 = r26
            r1.f2898n = r2
            r2 = r22
            r1.f2899o = r2
            java.lang.String r0 = com.loc.CoreUtil.f2980d
            r1.f2900p = r0
            java.lang.String r0 = com.loc.CoreUtil.f2981e
            r1.f2901q = r0
            java.lang.String r0 = java.lang.String.valueOf(r20)
            r1.f2903s = r0
            java.lang.String r0 = com.loc.C1079cp.m3555j((android.content.Context) r29)
            r1.f2904t = r0
            java.lang.String r0 = "4.7.2"
            r1.f2906v = r0
            r2 = r35
            r1.f2907w = r2
            java.lang.String r0 = ""
            r1.f2905u = r0
            r0 = r25
            r1.f2908x = r0
            r7 = r24
            r1.f2909y = r7
            r1.f2910z = r14
            r1.f2871A = r5
            java.lang.String r0 = r13.toString()
            r1.f2872B = r0
            java.lang.String r0 = r32.mo13089k()
            r1.f2874D = r0
            java.lang.String r0 = com.loc.WifiManagerWrapper.m3187l()
            r1.f2877G = r0
            java.lang.String r0 = r6.toString()
            r1.f2875E = r0
            java.lang.String r0 = f2869J     // Catch:{ Throwable -> 0x035b }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Throwable -> 0x035b }
            if (r0 == 0) goto L_0x035b
            java.lang.String r0 = com.loc.DeviceInfo.m3719h(r29)     // Catch:{ Throwable -> 0x035b }
            f2869J = r0     // Catch:{ Throwable -> 0x035b }
        L_0x035b:
            java.lang.String r0 = f2870L     // Catch:{ Throwable -> 0x0369 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Throwable -> 0x0369 }
            if (r0 == 0) goto L_0x0369
            java.lang.String r0 = com.loc.DeviceInfo.m3708b(r29)     // Catch:{ Throwable -> 0x0369 }
            f2870L = r0     // Catch:{ Throwable -> 0x0369 }
        L_0x0369:
            java.lang.String r0 = r1.f2882N     // Catch:{ Throwable -> 0x0377 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Throwable -> 0x0377 }
            if (r0 == 0) goto L_0x0377
            java.lang.String r0 = com.loc.DeviceInfo.m3720i(r29)     // Catch:{ Throwable -> 0x0377 }
            r1.f2882N = r0     // Catch:{ Throwable -> 0x0377 }
        L_0x0377:
            int r0 = r13.length()
            r2 = 0
            r13.delete(r2, r0)
            int r0 = r6.length()
            r6.delete(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.Req.mo13166a(android.content.Context, boolean, boolean, com.loc.br, com.loc.bt, android.net.ConnectivityManager, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:140:0x02c4  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x02f5  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0367  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x03c1  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x03f8 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x04f5  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x04f9  */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x0518  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x051d  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x05a0  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x05a6  */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x065b A[Catch:{ Throwable -> 0x0671 }] */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x065e A[Catch:{ Throwable -> 0x0671 }] */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x0663 A[Catch:{ Throwable -> 0x0671 }] */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x0684 A[Catch:{ Throwable -> 0x06a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:301:0x0696 A[SYNTHETIC, Splitter:B:301:0x0696] */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x06c4  */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x06c9  */
    /* JADX WARNING: Removed duplicated region for block: B:322:0x06d8  */
    /* JADX WARNING: Removed duplicated region for block: B:325:0x06f2  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] mo13167a() {
        /*
            r20 = this;
            r1 = r20
            java.lang.String r0 = r1.f2885a
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x000e
            java.lang.String r0 = ""
            r1.f2885a = r0
        L_0x000e:
            java.lang.String r0 = r1.f2887c
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x001a
            java.lang.String r0 = ""
            r1.f2887c = r0
        L_0x001a:
            java.lang.String r0 = r1.f2888d
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0026
            java.lang.String r0 = ""
            r1.f2888d = r0
        L_0x0026:
            java.lang.String r0 = r1.f2889e
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0032
            java.lang.String r0 = ""
            r1.f2889e = r0
        L_0x0032:
            java.lang.String r0 = r1.f2890f
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x003e
            java.lang.String r0 = ""
            r1.f2890f = r0
        L_0x003e:
            java.lang.String r0 = r1.f2891g
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x004a
            java.lang.String r0 = ""
            r1.f2891g = r0
        L_0x004a:
            java.lang.String r0 = r1.f2892h
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0056
            java.lang.String r0 = ""
            r1.f2892h = r0
        L_0x0056:
            java.lang.String r0 = r1.f2893i
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0062
            java.lang.String r0 = ""
            r1.f2893i = r0
        L_0x0062:
            java.lang.String r0 = r1.f2894j
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x006f
        L_0x006a:
            java.lang.String r0 = "0"
            r1.f2894j = r0
            goto L_0x0084
        L_0x006f:
            java.lang.String r0 = "0"
            java.lang.String r2 = r1.f2894j
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0084
            java.lang.String r0 = "2"
            java.lang.String r2 = r1.f2894j
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0084
            goto L_0x006a
        L_0x0084:
            java.lang.String r0 = r1.f2895k
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0091
        L_0x008c:
            java.lang.String r0 = "0"
            r1.f2895k = r0
            goto L_0x00a6
        L_0x0091:
            java.lang.String r0 = "0"
            java.lang.String r2 = r1.f2895k
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x00a6
            java.lang.String r0 = "1"
            java.lang.String r2 = r1.f2895k
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x00a6
            goto L_0x008c
        L_0x00a6:
            java.lang.String r0 = r1.f2896l
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x00b2
            java.lang.String r0 = ""
            r1.f2896l = r0
        L_0x00b2:
            java.lang.String r0 = r1.f2897m
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x00be
            java.lang.String r0 = ""
            r1.f2897m = r0
        L_0x00be:
            java.lang.String r0 = r1.f2898n
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x00ca
            java.lang.String r0 = ""
            r1.f2898n = r0
        L_0x00ca:
            java.lang.String r0 = r1.f2899o
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x00d6
            java.lang.String r0 = ""
            r1.f2899o = r0
        L_0x00d6:
            java.lang.String r0 = r1.f2900p
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x00e2
            java.lang.String r0 = ""
            r1.f2900p = r0
        L_0x00e2:
            java.lang.String r0 = r1.f2901q
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x00ee
            java.lang.String r0 = ""
            r1.f2901q = r0
        L_0x00ee:
            java.lang.String r0 = r1.f2902r
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x00fa
            java.lang.String r0 = ""
            r1.f2902r = r0
        L_0x00fa:
            java.lang.String r0 = r1.f2903s
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0106
            java.lang.String r0 = ""
            r1.f2903s = r0
        L_0x0106:
            java.lang.String r0 = r1.f2904t
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0112
            java.lang.String r0 = ""
            r1.f2904t = r0
        L_0x0112:
            java.lang.String r0 = r1.f2905u
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x011e
            java.lang.String r0 = ""
            r1.f2905u = r0
        L_0x011e:
            java.lang.String r0 = r1.f2906v
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x012a
            java.lang.String r0 = ""
            r1.f2906v = r0
        L_0x012a:
            java.lang.String r0 = r1.f2907w
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0136
            java.lang.String r0 = ""
            r1.f2907w = r0
        L_0x0136:
            java.lang.String r0 = r1.f2908x
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0142
            java.lang.String r0 = ""
            r1.f2908x = r0
        L_0x0142:
            java.lang.String r0 = r1.f2909y
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x014f
        L_0x014a:
            java.lang.String r0 = "0"
            r1.f2909y = r0
            goto L_0x0164
        L_0x014f:
            java.lang.String r0 = "1"
            java.lang.String r2 = r1.f2909y
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0164
            java.lang.String r0 = "2"
            java.lang.String r2 = r1.f2909y
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0164
            goto L_0x014a
        L_0x0164:
            int r0 = r1.f2910z
            r2 = 1
            r3 = 0
            if (r0 <= 0) goto L_0x0171
            r4 = 15
            if (r0 <= r4) goto L_0x016f
            goto L_0x0171
        L_0x016f:
            r0 = 1
            goto L_0x0172
        L_0x0171:
            r0 = 0
        L_0x0172:
            if (r0 != 0) goto L_0x0176
            r1.f2910z = r3
        L_0x0176:
            java.lang.String r0 = r1.f2871A
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0182
            java.lang.String r0 = ""
            r1.f2871A = r0
        L_0x0182:
            java.lang.String r0 = r1.f2872B
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x018e
            java.lang.String r0 = ""
            r1.f2872B = r0
        L_0x018e:
            java.lang.String r0 = r1.f2875E
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x019a
            java.lang.String r0 = ""
            r1.f2875E = r0
        L_0x019a:
            java.lang.String r0 = r1.f2877G
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x01a6
            java.lang.String r0 = ""
            r1.f2877G = r0
        L_0x01a6:
            java.lang.String r0 = r1.f2878H
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x01b2
            java.lang.String r0 = ""
            r1.f2878H = r0
        L_0x01b2:
            java.lang.String r0 = f2869J
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x01be
            java.lang.String r0 = ""
            f2869J = r0
        L_0x01be:
            byte[] r0 = r1.f2879I
            if (r0 != 0) goto L_0x01c6
            byte[] r0 = new byte[r3]
            r1.f2879I = r0
        L_0x01c6:
            java.lang.String r0 = r1.f2882N
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x01d2
            java.lang.String r0 = ""
            r1.f2882N = r0
        L_0x01d2:
            r4 = 2
            byte[] r5 = new byte[r4]
            r6 = 4
            byte[] r7 = new byte[r6]
            byte[] r0 = r1.f2879I
            r8 = 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x01e3
            byte[] r0 = r1.f2879I
            int r0 = r0.length
            int r0 = r0 + r2
            int r8 = r8 + r0
        L_0x01e3:
            byte[] r0 = r1.f2883O
            if (r0 == 0) goto L_0x01ef
            int r0 = r1.f2884P
            if (r8 <= r0) goto L_0x01ec
            goto L_0x01ef
        L_0x01ec:
            byte[] r0 = r1.f2883O
            goto L_0x01f5
        L_0x01ef:
            byte[] r0 = new byte[r8]
            r1.f2883O = r0
            r1.f2884P = r8
        L_0x01f5:
            r8 = r0
            java.lang.String r0 = r1.f2885a
            byte r0 = com.loc.C1079cp.m3554j((java.lang.String) r0)
            r8[r3] = r0
            short r0 = r1.f2886b
            r9 = 0
            byte[] r0 = com.loc.C1079cp.m3513a((int) r0, (byte[]) r9)
            int r10 = r0.length
            java.lang.System.arraycopy(r0, r3, r8, r2, r10)
            int r0 = r0.length
            int r0 = r0 + r2
            java.lang.String r10 = r1.f2887c
            int r0 = m3328a(r10, r8, r0)
            java.lang.String r10 = r1.f2888d
            int r0 = m3328a(r10, r8, r0)
            java.lang.String r10 = r1.f2899o
            int r0 = m3328a(r10, r8, r0)
            java.lang.String r10 = r1.f2889e
            int r0 = m3328a(r10, r8, r0)
            java.lang.String r10 = r1.f2890f
            int r0 = m3328a(r10, r8, r0)
            java.lang.String r10 = r1.f2891g
            int r0 = m3328a(r10, r8, r0)
            java.lang.String r10 = r1.f2905u
            int r0 = m3328a(r10, r8, r0)
            java.lang.String r10 = r1.f2892h
            int r0 = m3328a(r10, r8, r0)
            java.lang.String r10 = r1.f2900p
            int r0 = m3328a(r10, r8, r0)
            java.lang.String r10 = r1.f2901q
            int r10 = m3328a(r10, r8, r0)
            java.lang.String r0 = r1.f2904t     // Catch:{ Throwable -> 0x0265 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Throwable -> 0x0265 }
            if (r0 == 0) goto L_0x0252
            r8[r10] = r3     // Catch:{ Throwable -> 0x0265 }
            goto L_0x026f
        L_0x0252:
            java.lang.String r0 = r1.f2904t     // Catch:{ Throwable -> 0x0265 }
            byte[] r0 = r1.m3330a(r0)     // Catch:{ Throwable -> 0x0265 }
            int r11 = r0.length     // Catch:{ Throwable -> 0x0265 }
            byte r11 = (byte) r11     // Catch:{ Throwable -> 0x0265 }
            r8[r10] = r11     // Catch:{ Throwable -> 0x0265 }
            int r10 = r10 + 1
            int r11 = r0.length     // Catch:{ Throwable -> 0x0265 }
            java.lang.System.arraycopy(r0, r3, r8, r10, r11)     // Catch:{ Throwable -> 0x0265 }
            int r0 = r0.length     // Catch:{ Throwable -> 0x0265 }
            int r10 = r10 + r0
            goto L_0x0270
        L_0x0265:
            r0 = move-exception
            java.lang.String r11 = "Req"
            java.lang.String r12 = "buildV4Dot219"
            com.loc.CoreUtil.m3389a(r0, r11, r12)
            r8[r10] = r3
        L_0x026f:
            int r10 = r10 + r2
        L_0x0270:
            java.lang.String r0 = r1.f2906v
            int r0 = m3328a(r0, r8, r10)
            java.lang.String r10 = r1.f2907w
            int r0 = m3328a(r10, r8, r0)
            java.lang.String r10 = f2869J
            int r0 = m3328a(r10, r8, r0)
            java.lang.String r10 = f2870L
            int r0 = m3328a(r10, r8, r0)
            java.lang.String r10 = r1.f2908x
            int r0 = m3328a(r10, r8, r0)
            java.lang.String r10 = r1.f2909y
            byte r10 = java.lang.Byte.parseByte(r10)
            r8[r0] = r10
            int r0 = r0 + r2
            java.lang.String r10 = r1.f2894j
            byte r10 = java.lang.Byte.parseByte(r10)
            r8[r0] = r10
            int r0 = r0 + r2
            int r10 = r1.f2910z
            r11 = 3
            r10 = r10 & r11
            int r12 = r1.f2910z
            byte r12 = (byte) r12
            r8[r0] = r12
            int r0 = r0 + r2
            r12 = -128(0xffffffffffffff80, float:NaN)
            r13 = 127(0x7f, float:1.78E-43)
            if (r10 == r2) goto L_0x02b2
            if (r10 != r4) goto L_0x03c6
        L_0x02b2:
            java.lang.String r14 = "mcc"
            java.lang.String r14 = r1.m3331b(r14)
            byte[] r14 = com.loc.C1079cp.m3527b((java.lang.String) r14)
            int r15 = r14.length
            java.lang.System.arraycopy(r14, r3, r8, r0, r15)
            int r14 = r14.length
            int r0 = r0 + r14
            if (r10 != r2) goto L_0x02f5
            java.lang.String r14 = "mnc"
            java.lang.String r14 = r1.m3331b(r14)
            byte[] r14 = com.loc.C1079cp.m3527b((java.lang.String) r14)
            int r15 = r14.length
            java.lang.System.arraycopy(r14, r3, r8, r0, r15)
            int r14 = r14.length
            int r0 = r0 + r14
            java.lang.String r14 = "lac"
            java.lang.String r14 = r1.m3331b(r14)
            byte[] r14 = com.loc.C1079cp.m3527b((java.lang.String) r14)
            int r15 = r14.length
            java.lang.System.arraycopy(r14, r3, r8, r0, r15)
            int r14 = r14.length
            int r0 = r0 + r14
            java.lang.String r14 = "cellid"
            java.lang.String r14 = r1.m3331b(r14)
            byte[] r14 = com.loc.C1079cp.m3534c((java.lang.String) r14)
            int r15 = r14.length
            java.lang.System.arraycopy(r14, r3, r8, r0, r15)
            int r14 = r14.length
        L_0x02f3:
            int r0 = r0 + r14
            goto L_0x0347
        L_0x02f5:
            if (r10 != r4) goto L_0x0347
            java.lang.String r14 = "sid"
            java.lang.String r14 = r1.m3331b(r14)
            byte[] r14 = com.loc.C1079cp.m3527b((java.lang.String) r14)
            int r15 = r14.length
            java.lang.System.arraycopy(r14, r3, r8, r0, r15)
            int r14 = r14.length
            int r0 = r0 + r14
            java.lang.String r14 = "nid"
            java.lang.String r14 = r1.m3331b(r14)
            byte[] r14 = com.loc.C1079cp.m3527b((java.lang.String) r14)
            int r15 = r14.length
            java.lang.System.arraycopy(r14, r3, r8, r0, r15)
            int r14 = r14.length
            int r0 = r0 + r14
            java.lang.String r14 = "bid"
            java.lang.String r14 = r1.m3331b(r14)
            byte[] r14 = com.loc.C1079cp.m3527b((java.lang.String) r14)
            int r15 = r14.length
            java.lang.System.arraycopy(r14, r3, r8, r0, r15)
            int r14 = r14.length
            int r0 = r0 + r14
            java.lang.String r14 = "lon"
            java.lang.String r14 = r1.m3331b(r14)
            byte[] r14 = com.loc.C1079cp.m3534c((java.lang.String) r14)
            int r15 = r14.length
            java.lang.System.arraycopy(r14, r3, r8, r0, r15)
            int r14 = r14.length
            int r0 = r0 + r14
            java.lang.String r14 = "lat"
            java.lang.String r14 = r1.m3331b(r14)
            byte[] r14 = com.loc.C1079cp.m3534c((java.lang.String) r14)
            int r15 = r14.length
            java.lang.System.arraycopy(r14, r3, r8, r0, r15)
            int r14 = r14.length
            goto L_0x02f3
        L_0x0347:
            java.lang.String r14 = "signal"
            java.lang.String r14 = r1.m3331b(r14)
            int r14 = java.lang.Integer.parseInt(r14)
            if (r14 <= r13) goto L_0x0355
        L_0x0353:
            r14 = 0
            goto L_0x0358
        L_0x0355:
            if (r14 >= r12) goto L_0x0358
            goto L_0x0353
        L_0x0358:
            byte r14 = (byte) r14
            r8[r0] = r14
            int r0 = r0 + r2
            byte[] r14 = com.loc.C1079cp.m3513a((int) r3, (byte[]) r5)
            int r15 = r14.length
            java.lang.System.arraycopy(r14, r3, r8, r0, r15)
            int r0 = r0 + r4
            if (r10 != r2) goto L_0x03c1
            java.lang.String r10 = r1.f2872B
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 == 0) goto L_0x0374
            r8[r0] = r3
        L_0x0371:
            int r0 = r0 + 1
            goto L_0x03c6
        L_0x0374:
            java.lang.String r10 = r1.f2872B
            java.lang.String r14 = "\\*"
            java.lang.String[] r10 = r10.split(r14)
            int r10 = r10.length
            byte r14 = (byte) r10
            r8[r0] = r14
            int r0 = r0 + 1
            r14 = r0
            r0 = 0
        L_0x0384:
            if (r0 >= r10) goto L_0x03bf
            java.lang.String r15 = "lac"
            java.lang.String r15 = r1.m3329a(r15, r0)
            byte[] r15 = com.loc.C1079cp.m3527b((java.lang.String) r15)
            int r9 = r15.length
            java.lang.System.arraycopy(r15, r3, r8, r14, r9)
            int r9 = r15.length
            int r14 = r14 + r9
            java.lang.String r9 = "cellid"
            java.lang.String r9 = r1.m3329a(r9, r0)
            byte[] r9 = com.loc.C1079cp.m3534c((java.lang.String) r9)
            int r15 = r9.length
            java.lang.System.arraycopy(r9, r3, r8, r14, r15)
            int r9 = r9.length
            int r14 = r14 + r9
            java.lang.String r9 = "signal"
            java.lang.String r9 = r1.m3329a(r9, r0)
            int r9 = java.lang.Integer.parseInt(r9)
            if (r9 <= r13) goto L_0x03b4
        L_0x03b2:
            r9 = 0
            goto L_0x03b7
        L_0x03b4:
            if (r9 >= r12) goto L_0x03b7
            goto L_0x03b2
        L_0x03b7:
            byte r9 = (byte) r9
            r8[r14] = r9
            int r14 = r14 + r2
            int r0 = r0 + 1
            r9 = 0
            goto L_0x0384
        L_0x03bf:
            r0 = r14
            goto L_0x03c6
        L_0x03c1:
            if (r10 != r4) goto L_0x03c6
            r8[r0] = r3
            goto L_0x0371
        L_0x03c6:
            java.lang.String r9 = r1.f2874D
            if (r9 == 0) goto L_0x03e8
            int r10 = r1.f2910z
            r14 = 8
            r10 = r10 & r14
            if (r10 != r14) goto L_0x03e8
            java.lang.String r10 = "GBK"
            byte[] r9 = r9.getBytes(r10)     // Catch:{ Exception -> 0x03e8 }
            int r10 = r9.length     // Catch:{ Exception -> 0x03e8 }
            r14 = 60
            int r10 = java.lang.Math.min(r10, r14)     // Catch:{ Exception -> 0x03e8 }
            byte r14 = (byte) r10     // Catch:{ Exception -> 0x03e8 }
            r8[r0] = r14     // Catch:{ Exception -> 0x03e8 }
            int r0 = r0 + 1
            java.lang.System.arraycopy(r9, r3, r8, r0, r10)     // Catch:{ Exception -> 0x03e8 }
            int r0 = r0 + r10
            goto L_0x03eb
        L_0x03e8:
            r8[r0] = r3
            int r0 = r0 + r2
        L_0x03eb:
            java.util.ArrayList<com.loc.bq> r9 = r1.f2873C
            int r10 = r9.size()
            int r14 = r1.f2910z
            r14 = r14 & r6
            r16 = 4617315517961601024(0x4014000000000000, double:5.0)
            if (r14 != r6) goto L_0x050c
            if (r10 <= 0) goto L_0x050c
            java.lang.Object r14 = r9.get(r3)
            com.loc.bq r14 = (com.loc.Cgi) r14
            boolean r14 = r14.f2721p
            if (r14 != 0) goto L_0x0406
            int r10 = r10 + -1
        L_0x0406:
            byte r14 = (byte) r10
            r8[r0] = r14
            int r0 = r0 + r2
            r14 = r0
            r0 = 0
        L_0x040c:
            if (r0 >= r10) goto L_0x0510
            java.lang.Object r15 = r9.get(r0)
            com.loc.bq r15 = (com.loc.Cgi) r15
            boolean r12 = r15.f2721p
            if (r12 == 0) goto L_0x0505
            int r12 = r15.f2716k
            if (r12 == r2) goto L_0x047f
            int r12 = r15.f2716k
            if (r12 == r11) goto L_0x047f
            int r12 = r15.f2716k
            if (r12 != r6) goto L_0x0425
            goto L_0x047f
        L_0x0425:
            int r12 = r15.f2716k
            if (r12 != r4) goto L_0x04bd
            int r12 = r15.f2716k
            byte r12 = (byte) r12
            boolean r4 = r15.f2719n
            if (r4 == 0) goto L_0x0433
            r4 = r12 | 8
            byte r12 = (byte) r4
        L_0x0433:
            r8[r14] = r12
            int r14 = r14 + 1
            int r4 = r15.f2706a
            byte[] r4 = com.loc.C1079cp.m3513a((int) r4, (byte[]) r5)
            int r12 = r4.length
            java.lang.System.arraycopy(r4, r3, r8, r14, r12)
            int r4 = r4.length
            int r14 = r14 + r4
            int r4 = r15.f2712g
            byte[] r4 = com.loc.C1079cp.m3513a((int) r4, (byte[]) r5)
            int r12 = r4.length
            java.lang.System.arraycopy(r4, r3, r8, r14, r12)
            int r4 = r4.length
            int r14 = r14 + r4
            int r4 = r15.f2713h
            byte[] r4 = com.loc.C1079cp.m3513a((int) r4, (byte[]) r5)
            int r12 = r4.length
            java.lang.System.arraycopy(r4, r3, r8, r14, r12)
            int r4 = r4.length
            int r14 = r14 + r4
            int r4 = r15.f2714i
            byte[] r4 = com.loc.C1079cp.m3513a((int) r4, (byte[]) r5)
            int r12 = r4.length
            java.lang.System.arraycopy(r4, r3, r8, r14, r12)
            int r4 = r4.length
            int r14 = r14 + r4
            int r4 = r15.f2711f
            byte[] r4 = com.loc.C1079cp.m3526b((int) r4, (byte[]) r7)
            int r12 = r4.length
            java.lang.System.arraycopy(r4, r3, r8, r14, r12)
            int r4 = r4.length
            int r14 = r14 + r4
            int r4 = r15.f2710e
            byte[] r4 = com.loc.C1079cp.m3526b((int) r4, (byte[]) r7)
            int r12 = r4.length
            java.lang.System.arraycopy(r4, r3, r8, r14, r12)
            int r4 = r4.length
            goto L_0x04bc
        L_0x047f:
            int r4 = r15.f2716k
            byte r4 = (byte) r4
            boolean r12 = r15.f2719n
            if (r12 == 0) goto L_0x0489
            r4 = r4 | 8
            byte r4 = (byte) r4
        L_0x0489:
            r8[r14] = r4
            int r14 = r14 + 1
            int r4 = r15.f2706a
            byte[] r4 = com.loc.C1079cp.m3513a((int) r4, (byte[]) r5)
            int r12 = r4.length
            java.lang.System.arraycopy(r4, r3, r8, r14, r12)
            int r4 = r4.length
            int r14 = r14 + r4
            int r4 = r15.f2707b
            byte[] r4 = com.loc.C1079cp.m3513a((int) r4, (byte[]) r5)
            int r12 = r4.length
            java.lang.System.arraycopy(r4, r3, r8, r14, r12)
            int r4 = r4.length
            int r14 = r14 + r4
            int r4 = r15.f2708c
            byte[] r4 = com.loc.C1079cp.m3513a((int) r4, (byte[]) r5)
            int r12 = r4.length
            java.lang.System.arraycopy(r4, r3, r8, r14, r12)
            int r4 = r4.length
            int r14 = r14 + r4
            int r4 = r15.f2709d
            byte[] r4 = com.loc.C1079cp.m3526b((int) r4, (byte[]) r7)
            int r12 = r4.length
            java.lang.System.arraycopy(r4, r3, r8, r14, r12)
            int r4 = r4.length
        L_0x04bc:
            int r14 = r14 + r4
        L_0x04bd:
            int r4 = r15.f2715j
            if (r4 <= r13) goto L_0x04c4
        L_0x04c1:
            r4 = 99
            goto L_0x04c9
        L_0x04c4:
            r12 = -128(0xffffffffffffff80, float:NaN)
            if (r4 >= r12) goto L_0x04c9
            goto L_0x04c1
        L_0x04c9:
            byte r4 = (byte) r4
            r8[r14] = r4
            int r14 = r14 + r2
            short r4 = r15.f2717l
            byte[] r4 = com.loc.C1079cp.m3513a((int) r4, (byte[]) r5)
            int r12 = r4.length
            java.lang.System.arraycopy(r4, r3, r8, r14, r12)
            int r4 = r4.length
            int r14 = r14 + r4
            java.lang.String r4 = "5.1"
            java.lang.Double r4 = java.lang.Double.valueOf(r4)
            double r18 = r4.doubleValue()
            int r4 = (r18 > r16 ? 1 : (r18 == r16 ? 0 : -1))
            if (r4 < 0) goto L_0x0505
            int r4 = r15.f2716k
            if (r4 == r11) goto L_0x04ef
            int r4 = r15.f2716k
            if (r4 != r6) goto L_0x0505
        L_0x04ef:
            int r4 = r15.f2720o
            r12 = 32767(0x7fff, float:4.5916E-41)
            if (r4 <= r12) goto L_0x04f7
            r4 = 32767(0x7fff, float:4.5916E-41)
        L_0x04f7:
            if (r4 >= 0) goto L_0x04fb
            r4 = 32767(0x7fff, float:4.5916E-41)
        L_0x04fb:
            byte[] r4 = com.loc.C1079cp.m3513a((int) r4, (byte[]) r5)
            int r12 = r4.length
            java.lang.System.arraycopy(r4, r3, r8, r14, r12)
            int r4 = r4.length
            int r14 = r14 + r4
        L_0x0505:
            int r0 = r0 + 1
            r4 = 2
            r12 = -128(0xffffffffffffff80, float:NaN)
            goto L_0x040c
        L_0x050c:
            r8[r0] = r3
            int r14 = r0 + 1
        L_0x0510:
            java.lang.String r0 = r1.f2875E
            int r0 = r0.length()
            if (r0 != 0) goto L_0x051d
            r8[r14] = r3
        L_0x051a:
            int r14 = r14 + r2
            goto L_0x0592
        L_0x051d:
            r8[r14] = r2
            int r14 = r14 + r2
            java.lang.String r0 = r1.f2875E     // Catch:{ Throwable -> 0x0572 }
            java.lang.String r4 = ","
            java.lang.String[] r4 = r0.split(r4)     // Catch:{ Throwable -> 0x0572 }
            r0 = r4[r3]     // Catch:{ Throwable -> 0x0572 }
            byte[] r0 = r1.m3330a(r0)     // Catch:{ Throwable -> 0x0572 }
            int r6 = r0.length     // Catch:{ Throwable -> 0x0572 }
            java.lang.System.arraycopy(r0, r3, r8, r14, r6)     // Catch:{ Throwable -> 0x0572 }
            int r0 = r0.length     // Catch:{ Throwable -> 0x0572 }
            int r14 = r14 + r0
            r6 = 2
            r0 = r4[r6]     // Catch:{ Throwable -> 0x054c }
            java.lang.String r6 = "GBK"
            byte[] r0 = r0.getBytes(r6)     // Catch:{ Throwable -> 0x054c }
            int r6 = r0.length     // Catch:{ Throwable -> 0x054c }
            if (r6 <= r13) goto L_0x0542
            r6 = 127(0x7f, float:1.78E-43)
        L_0x0542:
            byte r7 = (byte) r6     // Catch:{ Throwable -> 0x054c }
            r8[r14] = r7     // Catch:{ Throwable -> 0x054c }
            int r14 = r14 + 1
            java.lang.System.arraycopy(r0, r3, r8, r14, r6)     // Catch:{ Throwable -> 0x054c }
            int r14 = r14 + r6
            goto L_0x0558
        L_0x054c:
            r0 = move-exception
            java.lang.String r6 = "Req"
            java.lang.String r7 = "buildV4Dot214"
            com.loc.CoreUtil.m3389a(r0, r6, r7)     // Catch:{ Throwable -> 0x0572 }
            r8[r14] = r3     // Catch:{ Throwable -> 0x0572 }
            int r14 = r14 + 1
        L_0x0558:
            r0 = r4[r2]     // Catch:{ Throwable -> 0x0572 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Throwable -> 0x0572 }
            if (r0 <= r13) goto L_0x0562
        L_0x0560:
            r0 = 0
            goto L_0x0567
        L_0x0562:
            r4 = -128(0xffffffffffffff80, float:NaN)
            if (r0 >= r4) goto L_0x0567
            goto L_0x0560
        L_0x0567:
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Throwable -> 0x0572 }
            byte r0 = java.lang.Byte.parseByte(r0)     // Catch:{ Throwable -> 0x0572 }
            r8[r14] = r0     // Catch:{ Throwable -> 0x0572 }
            goto L_0x051a
        L_0x0572:
            r0 = move-exception
            java.lang.String r4 = "Req"
            java.lang.String r6 = "buildV4Dot216"
            com.loc.CoreUtil.m3389a(r0, r4, r6)
            java.lang.String r0 = "00:00:00:00:00:00"
            byte[] r0 = r1.m3330a(r0)
            int r4 = r0.length
            java.lang.System.arraycopy(r0, r3, r8, r14, r4)
            int r0 = r0.length
            int r14 = r14 + r0
            r8[r14] = r3
            int r14 = r14 + r2
            java.lang.String r0 = "0"
            byte r0 = java.lang.Byte.parseByte(r0)
            r8[r14] = r0
            goto L_0x051a
        L_0x0592:
            java.util.ArrayList<android.net.wifi.ScanResult> r0 = r1.f2876F
            int r4 = r0.size()
            r6 = 25
            int r4 = java.lang.Math.min(r4, r6)
            if (r4 != 0) goto L_0x05a6
            r8[r14] = r3
            int r14 = r14 + r2
            r12 = 0
            goto L_0x064c
        L_0x05a6:
            byte r6 = (byte) r4
            r8[r14] = r6
            int r14 = r14 + r2
            int r6 = com.loc.C1079cp.m3535d()
            r7 = 17
            if (r6 < r7) goto L_0x05b4
            r6 = 1
            goto L_0x05b5
        L_0x05b4:
            r6 = 0
        L_0x05b5:
            r9 = 0
            if (r6 == 0) goto L_0x05c0
            long r9 = com.loc.C1079cp.m3529c()
            r11 = 1000(0x3e8, double:4.94E-321)
            long r9 = r9 / r11
        L_0x05c0:
            r7 = 0
        L_0x05c1:
            if (r7 >= r4) goto L_0x063b
            java.lang.Object r11 = r0.get(r7)
            android.net.wifi.ScanResult r11 = (android.net.wifi.ScanResult) r11
            java.lang.String r12 = r11.BSSID
            byte[] r12 = r1.m3330a(r12)
            int r15 = r12.length
            java.lang.System.arraycopy(r12, r3, r8, r14, r15)
            int r12 = r12.length
            int r14 = r14 + r12
            java.lang.String r12 = r11.SSID     // Catch:{ Exception -> 0x05ea }
            java.lang.String r15 = "GBK"
            byte[] r12 = r12.getBytes(r15)     // Catch:{ Exception -> 0x05ea }
            int r15 = r12.length     // Catch:{ Exception -> 0x05ea }
            byte r15 = (byte) r15     // Catch:{ Exception -> 0x05ea }
            r8[r14] = r15     // Catch:{ Exception -> 0x05ea }
            int r14 = r14 + 1
            int r15 = r12.length     // Catch:{ Exception -> 0x05ea }
            java.lang.System.arraycopy(r12, r3, r8, r14, r15)     // Catch:{ Exception -> 0x05ea }
            int r12 = r12.length     // Catch:{ Exception -> 0x05ea }
            int r14 = r14 + r12
            goto L_0x05ed
        L_0x05ea:
            r8[r14] = r3
            int r14 = r14 + r2
        L_0x05ed:
            int r12 = r11.level
            if (r12 <= r13) goto L_0x05f5
            r12 = 0
            r15 = -128(0xffffffffffffff80, float:NaN)
            goto L_0x05fa
        L_0x05f5:
            r15 = -128(0xffffffffffffff80, float:NaN)
            if (r12 >= r15) goto L_0x05fa
            r12 = 0
        L_0x05fa:
            java.lang.String r12 = java.lang.String.valueOf(r12)
            byte r12 = java.lang.Byte.parseByte(r12)
            r8[r14] = r12
            int r14 = r14 + r2
            if (r6 == 0) goto L_0x0617
            long r2 = r11.timestamp
            r18 = 1000000(0xf4240, double:4.940656E-318)
            long r2 = r2 / r18
            r18 = 1
            long r2 = r2 + r18
            long r2 = r9 - r2
            int r3 = (int) r2
            if (r3 >= 0) goto L_0x0618
        L_0x0617:
            r3 = 0
        L_0x0618:
            r2 = 65535(0xffff, float:9.1834E-41)
            if (r3 <= r2) goto L_0x061e
            goto L_0x061f
        L_0x061e:
            r2 = r3
        L_0x061f:
            byte[] r2 = com.loc.C1079cp.m3513a((int) r2, (byte[]) r5)
            int r3 = r2.length
            r12 = 0
            java.lang.System.arraycopy(r2, r12, r8, r14, r3)
            int r2 = r2.length
            int r14 = r14 + r2
            int r2 = r11.frequency
            byte[] r2 = com.loc.C1079cp.m3513a((int) r2, (byte[]) r5)
            int r3 = r2.length
            java.lang.System.arraycopy(r2, r12, r8, r14, r3)
            int r2 = r2.length
            int r14 = r14 + r2
            int r7 = r7 + 1
            r2 = 1
            r3 = 0
            goto L_0x05c1
        L_0x063b:
            r12 = 0
            java.lang.String r0 = r1.f2877G
            int r0 = java.lang.Integer.parseInt(r0)
            byte[] r0 = com.loc.C1079cp.m3513a((int) r0, (byte[]) r5)
            int r2 = r0.length
            java.lang.System.arraycopy(r0, r12, r8, r14, r2)
            int r0 = r0.length
            int r14 = r14 + r0
        L_0x064c:
            r8[r14] = r12
            r2 = 1
            int r14 = r14 + r2
            java.lang.String r0 = r1.f2878H     // Catch:{ Throwable -> 0x0671 }
            java.lang.String r2 = "GBK"
            byte[] r9 = r0.getBytes(r2)     // Catch:{ Throwable -> 0x0671 }
            int r0 = r9.length     // Catch:{ Throwable -> 0x0671 }
            if (r0 <= r13) goto L_0x065c
            r9 = 0
        L_0x065c:
            if (r9 != 0) goto L_0x0663
            r2 = 0
            r8[r14] = r2     // Catch:{ Throwable -> 0x0671 }
            r2 = 1
            goto L_0x0675
        L_0x0663:
            int r0 = r9.length     // Catch:{ Throwable -> 0x0671 }
            byte r0 = (byte) r0     // Catch:{ Throwable -> 0x0671 }
            r8[r14] = r0     // Catch:{ Throwable -> 0x0671 }
            int r14 = r14 + 1
            int r0 = r9.length     // Catch:{ Throwable -> 0x0671 }
            r2 = 0
            java.lang.System.arraycopy(r9, r2, r8, r14, r0)     // Catch:{ Throwable -> 0x0671 }
            int r0 = r9.length     // Catch:{ Throwable -> 0x0671 }
            int r14 = r14 + r0
            goto L_0x0676
        L_0x0671:
            r2 = 0
            r8[r14] = r2
            r2 = 1
        L_0x0675:
            int r14 = r14 + r2
        L_0x0676:
            r2 = 2
            byte[] r0 = new byte[r2]
            r0 = {0, 0} // fill-array
            java.lang.String r2 = r1.f2880K     // Catch:{ Throwable -> 0x06a7 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Throwable -> 0x06a7 }
            if (r2 != 0) goto L_0x068e
            java.lang.String r0 = r1.f2880K     // Catch:{ Throwable -> 0x06a7 }
            int r0 = r0.length()     // Catch:{ Throwable -> 0x06a7 }
            byte[] r0 = com.loc.C1079cp.m3513a((int) r0, (byte[]) r5)     // Catch:{ Throwable -> 0x06a7 }
        L_0x068e:
            r3 = 0
            r4 = 2
            java.lang.System.arraycopy(r0, r3, r8, r14, r4)     // Catch:{ Throwable -> 0x06a7 }
            int r14 = r14 + r4
            if (r2 != 0) goto L_0x06a5
            java.lang.String r0 = r1.f2880K     // Catch:{ Throwable -> 0x06a5 }
            java.lang.String r2 = "GBK"
            byte[] r0 = r0.getBytes(r2)     // Catch:{ Throwable -> 0x06a5 }
            int r2 = r0.length     // Catch:{ Throwable -> 0x06a5 }
            r3 = 0
            java.lang.System.arraycopy(r0, r3, r8, r14, r2)     // Catch:{ Throwable -> 0x06a5 }
            int r0 = r0.length     // Catch:{ Throwable -> 0x06a5 }
            int r14 = r14 + r0
        L_0x06a5:
            r2 = 2
            goto L_0x06a9
        L_0x06a7:
            r2 = 2
            int r14 = r14 + r2
        L_0x06a9:
            byte[] r0 = new byte[r2]
            r0 = {0, 0} // fill-array
            r3 = 0
            byte[] r0 = com.loc.C1079cp.m3513a((int) r3, (byte[]) r5)     // Catch:{ Throwable -> 0x06b6 }
            java.lang.System.arraycopy(r0, r3, r8, r14, r2)     // Catch:{ Throwable -> 0x06b6 }
        L_0x06b6:
            int r14 = r14 + r2
            byte[] r0 = new byte[r2]
            r0 = {0, 0} // fill-array
            java.lang.System.arraycopy(r0, r3, r8, r14, r2)     // Catch:{ Throwable -> 0x06bf }
        L_0x06bf:
            int r14 = r14 + r2
            byte[] r0 = r1.f2879I
            if (r0 == 0) goto L_0x06c9
            byte[] r0 = r1.f2879I
            int r3 = r0.length
            r2 = 0
            goto L_0x06cb
        L_0x06c9:
            r2 = 0
            r3 = 0
        L_0x06cb:
            byte[] r0 = com.loc.C1079cp.m3513a((int) r3, (byte[]) r2)
            int r2 = r0.length
            r4 = 0
            java.lang.System.arraycopy(r0, r4, r8, r14, r2)
            int r0 = r0.length
            int r14 = r14 + r0
            if (r3 <= 0) goto L_0x06e4
            byte[] r0 = r1.f2879I
            byte[] r2 = r1.f2879I
            int r2 = r2.length
            java.lang.System.arraycopy(r0, r4, r8, r14, r2)
            byte[] r0 = r1.f2879I
            int r0 = r0.length
            int r14 = r14 + r0
        L_0x06e4:
            java.lang.String r0 = "5.1"
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            double r2 = r0.doubleValue()
            int r0 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
            if (r0 < 0) goto L_0x06fc
            r8[r14] = r4
            int r14 = r14 + 1
            java.lang.String r0 = r1.f2882N
            int r14 = m3328a(r0, r8, r14)
        L_0x06fc:
            byte[] r0 = new byte[r14]
            java.lang.System.arraycopy(r8, r4, r0, r4, r14)
            java.util.zip.CRC32 r2 = new java.util.zip.CRC32
            r2.<init>()
            r2.update(r0)
            long r2 = r2.getValue()
            byte[] r2 = com.loc.C1079cp.m3514a((long) r2)
            int r3 = r2.length
            int r3 = r3 + r14
            byte[] r3 = new byte[r3]
            java.lang.System.arraycopy(r0, r4, r3, r4, r14)
            int r0 = r2.length
            java.lang.System.arraycopy(r2, r4, r3, r14, r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.Req.mo13167a():byte[]");
    }
}
