package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.loc.AuthConfigManager;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import com.meizu.cloud.pushsdk.pushtracer.constant.Parameters;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.loc.ce */
public final class AuthUtil {

    /* renamed from: A */
    private static boolean f2911A = true;

    /* renamed from: B */
    private static int f2912B = -1;

    /* renamed from: C */
    private static long f2913C = 0;

    /* renamed from: D */
    private static ArrayList<String> f2914D = new ArrayList<>();

    /* renamed from: E */
    private static boolean f2915E = false;

    /* renamed from: F */
    private static int f2916F = -1;

    /* renamed from: G */
    private static long f2917G = 0;

    /* renamed from: H */
    private static ArrayList<String> f2918H = new ArrayList<>();

    /* renamed from: I */
    private static String f2919I = null;

    /* renamed from: J */
    private static String f2920J = null;

    /* renamed from: K */
    private static boolean f2921K = false;

    /* renamed from: L */
    private static int f2922L = 3000;

    /* renamed from: M */
    private static int f2923M = 3000;

    /* renamed from: N */
    private static boolean f2924N = true;

    /* renamed from: O */
    private static long f2925O = 300000;

    /* renamed from: P */
    private static boolean f2926P = false;

    /* renamed from: Q */
    private static List<OtherServiceEntity> f2927Q = new ArrayList();

    /* renamed from: R */
    private static boolean f2928R = false;

    /* renamed from: S */
    private static long f2929S = 0;

    /* renamed from: T */
    private static int f2930T = 0;

    /* renamed from: U */
    private static int f2931U = 0;

    /* renamed from: V */
    private static List<String> f2932V = new ArrayList();

    /* renamed from: W */
    private static boolean f2933W = true;

    /* renamed from: X */
    private static int f2934X = 80;

    /* renamed from: Y */
    private static boolean f2935Y = false;

    /* renamed from: Z */
    private static boolean f2936Z = true;

    /* renamed from: a */
    public static boolean f2937a = true;

    /* renamed from: aa */
    private static boolean f2938aa = false;

    /* renamed from: ab */
    private static boolean f2939ab = false;

    /* renamed from: ac */
    private static boolean f2940ac = true;

    /* renamed from: ad */
    private static boolean f2941ad = false;

    /* renamed from: ae */
    private static int f2942ae = -1;

    /* renamed from: af */
    private static boolean f2943af = true;

    /* renamed from: ag */
    private static long f2944ag = -1;

    /* renamed from: ah */
    private static boolean f2945ah = true;

    /* renamed from: ai */
    private static int f2946ai = 1;

    /* renamed from: aj */
    private static long f2947aj = 0;

    /* renamed from: b */
    static boolean f2948b = false;

    /* renamed from: c */
    static boolean f2949c = false;

    /* renamed from: d */
    static int f2950d = 3600000;

    /* renamed from: e */
    static long f2951e = 0;

    /* renamed from: f */
    static long f2952f = 0;

    /* renamed from: g */
    static boolean f2953g = false;

    /* renamed from: h */
    static boolean f2954h = true;

    /* renamed from: i */
    static boolean f2955i = false;

    /* renamed from: j */
    private static boolean f2956j = false;

    /* renamed from: k */
    private static boolean f2957k = true;

    /* renamed from: l */
    private static boolean f2958l = false;

    /* renamed from: m */
    private static long f2959m = 0;

    /* renamed from: n */
    private static long f2960n = 0;

    /* renamed from: o */
    private static long f2961o = 5000;

    /* renamed from: p */
    private static boolean f2962p = false;

    /* renamed from: q */
    private static int f2963q = 0;

    /* renamed from: r */
    private static boolean f2964r = false;

    /* renamed from: s */
    private static int f2965s = 0;

    /* renamed from: t */
    private static boolean f2966t = false;

    /* renamed from: u */
    private static boolean f2967u = true;

    /* renamed from: v */
    private static int f2968v = 1000;

    /* renamed from: w */
    private static int f2969w = 200;

    /* renamed from: x */
    private static boolean f2970x = false;

    /* renamed from: y */
    private static int f2971y = 20;

    /* renamed from: z */
    private static boolean f2972z = true;

    /* renamed from: com.loc.ce$a */
    /* compiled from: AuthUtil */
    static class C1074a {

        /* renamed from: a */
        boolean f2973a = false;

        /* renamed from: b */
        String f2974b = "0";

        /* renamed from: c */
        boolean f2975c = false;

        /* renamed from: d */
        int f2976d = 5;

        C1074a() {
        }
    }

    /* renamed from: A */
    public static int m3334A() {
        return f2942ae;
    }

    /* renamed from: B */
    public static boolean m3335B() {
        return f2955i;
    }

    /* renamed from: C */
    public static boolean m3336C() {
        return f2943af;
    }

    /* renamed from: D */
    public static long m3337D() {
        return f2944ag;
    }

    /* renamed from: E */
    public static boolean m3338E() {
        return f2945ah && f2946ai > 0;
    }

    /* renamed from: F */
    public static int m3339F() {
        return f2946ai;
    }

    /* renamed from: G */
    public static long m3340G() {
        return f2947aj;
    }

    /* renamed from: a */
    private static C1074a m3341a(JSONObject jSONObject, String str) {
        C1074a aVar;
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject(str);
                if (jSONObject2 != null) {
                    aVar = new C1074a();
                    try {
                        aVar.f2973a = AuthConfigManager.m3675a(jSONObject2.optString("b"), false);
                        aVar.f2974b = jSONObject2.optString("t");
                        aVar.f2975c = AuthConfigManager.m3675a(jSONObject2.optString(TimeDisplaySetting.START_SHOW_TIME), false);
                        aVar.f2976d = jSONObject2.optInt("i", 0);
                        return aVar;
                    } catch (Throwable th) {
                        th = th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                aVar = null;
                CoreUtil.m3389a(th, "AuthUtil", "getLocateObj");
                return aVar;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static boolean m3342a() {
        return f2962p;
    }

    /* renamed from: a */
    public static boolean m3343a(long j) {
        long c = C1079cp.m3529c();
        return f2958l && c - f2960n <= f2959m && c - j >= f2961o;
    }

    /* renamed from: a */
    public static boolean m3344a(Context context) {
        f2972z = true;
        boolean z = false;
        try {
            f2956j = SpUtil.m3493b(context, "pref", "oda", false);
            AuthConfigManager.C1092a a = AuthConfigManager.m3669a(context, CoreUtil.m3392b(), CoreUtil.m3394c(), f2956j);
            if (a != null) {
                f2957k = a.mo13255a();
                z = m3347a(context, a);
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "AuthUtil", "getConfig");
        }
        f2952f = C1079cp.m3529c();
        f2951e = C1079cp.m3529c();
        return z;
    }

    /* renamed from: a */
    public static boolean m3345a(Context context, long j) {
        if (!f2921K) {
            return false;
        }
        long b = C1079cp.m3518b();
        if (b - j < ((long) f2922L)) {
            return false;
        }
        if (f2923M == -1) {
            return true;
        }
        if (!C1079cp.m3531c(b, SpUtil.m3491b(context, "pref", "ngpsTime", 0))) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("pref", 0).edit();
                edit.putLong("ngpsTime", b);
                edit.putInt("ngpsCount", 0);
                SpUtil.m3489a(edit);
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "AuthUtil", "resetPrefsNGPS");
            }
            SpUtil.m3485a(context, "pref", "ngpsCount", 1);
            return true;
        }
        int b2 = SpUtil.m3490b(context, "pref", "ngpsCount", 0);
        if (b2 >= f2923M) {
            return false;
        }
        SpUtil.m3485a(context, "pref", "ngpsCount", b2 + 1);
        return true;
    }

    /* renamed from: a */
    private static boolean m3346a(Context context, AuthConfigManager.C1092a.C1094b bVar, String str, String str2, boolean z) {
        if (bVar != null) {
            try {
                boolean z2 = bVar.f3224a;
                String str3 = bVar.f3225b;
                String str4 = bVar.f3226c;
                String str5 = bVar.f3227d;
                boolean z3 = bVar.f3228e;
                SDKInfo a = CoreUtil.m3385a(str, str2);
                if (z2) {
                    if (z3 && z && !TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str5)) {
                        DexDownloadItem sVar = new DexDownloadItem(str3, str4, f2957k);
                        sVar.mo13313a(f2956j);
                        InstanceFactory.m3973b(context, sVar, a);
                    }
                } else if (ReportUtil.m3439a(context, a)) {
                    RollBackDynamic.m3480a(context, str, "config|get dex able is false");
                }
                return z2 && z3;
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "AuthUtil", "downLoadPluginDex");
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:138:0x021b A[SYNTHETIC, Splitter:B:138:0x021b] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x025e A[Catch:{ Throwable -> 0x02d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x02f4 A[Catch:{ Throwable -> 0x0301, Throwable -> 0x0360 }] */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0311 A[Catch:{ Throwable -> 0x0301, Throwable -> 0x0360 }] */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0338 A[Catch:{ Throwable -> 0x0301, Throwable -> 0x0360 }] */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x036c A[Catch:{ Throwable -> 0x0397 }] */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x03a3 A[Catch:{ Throwable -> 0x03d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x03df A[Catch:{ Throwable -> 0x03ef }] */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x03fb A[Catch:{ Throwable -> 0x04f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x0446 A[SYNTHETIC, Splitter:B:256:0x0446] */
    /* JADX WARNING: Removed duplicated region for block: B:280:0x04d9 A[Catch:{ Throwable -> 0x04f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x0504 A[Catch:{ Throwable -> 0x051f }] */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x052b  */
    /* JADX WARNING: Removed duplicated region for block: B:334:0x0611 A[Catch:{ Throwable -> 0x0652 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m3347a(android.content.Context r16, com.loc.AuthConfigManager.C1092a r17) {
        /*
            r1 = r16
            r2 = r17
            r3 = 0
            org.json.JSONObject r4 = r2.f3201g     // Catch:{ Throwable -> 0x00da }
            if (r4 == 0) goto L_0x00e2
            java.lang.String r0 = "at"
            r5 = 123(0x7b, float:1.72E-43)
            int r0 = r4.optInt(r0, r5)     // Catch:{ Throwable -> 0x0018 }
            int r0 = r0 * 60
            int r0 = r0 * 1000
            f2950d = r0     // Catch:{ Throwable -> 0x0018 }
            goto L_0x0020
        L_0x0018:
            r0 = move-exception
            java.lang.String r5 = "AuthUtil"
            java.lang.String r6 = "requestSdkAuthInterval"
            com.loc.CoreUtil.m3389a(r0, r5, r6)     // Catch:{ Throwable -> 0x00da }
        L_0x0020:
            java.lang.String r0 = "ila"
            java.lang.String r0 = r4.optString(r0)     // Catch:{ Throwable -> 0x002f }
            boolean r5 = f2935Y     // Catch:{ Throwable -> 0x002f }
            boolean r0 = com.loc.AuthConfigManager.m3675a((java.lang.String) r0, (boolean) r5)     // Catch:{ Throwable -> 0x002f }
            f2935Y = r0     // Catch:{ Throwable -> 0x002f }
            goto L_0x0037
        L_0x002f:
            r0 = move-exception
            java.lang.String r5 = "AuthUtil"
            java.lang.String r6 = "loadConfigData_indoor"
            com.loc.CoreUtil.m3389a(r0, r5, r6)     // Catch:{ Throwable -> 0x00da }
        L_0x0037:
            java.lang.String r0 = "icbd"
            java.lang.String r0 = r4.optString(r0)     // Catch:{ Throwable -> 0x004d }
            boolean r5 = f2949c     // Catch:{ Throwable -> 0x004d }
            boolean r0 = com.loc.AuthConfigManager.m3675a((java.lang.String) r0, (boolean) r5)     // Catch:{ Throwable -> 0x004d }
            f2949c = r0     // Catch:{ Throwable -> 0x004d }
            if (r0 == 0) goto L_0x0055
            java.lang.String r0 = "loc"
            com.loc.InstanceFactory.m3970a((android.content.Context) r1, (java.lang.String) r0)     // Catch:{ Throwable -> 0x004d }
            goto L_0x0055
        L_0x004d:
            r0 = move-exception
            java.lang.String r5 = "AuthUtil"
            java.lang.String r6 = "loadConfigData_CallBackDex"
            com.loc.CoreUtil.m3389a(r0, r5, r6)     // Catch:{ Throwable -> 0x00da }
        L_0x0055:
            if (r1 == 0) goto L_0x007a
            if (r4 != 0) goto L_0x005a
            goto L_0x007a
        L_0x005a:
            java.lang.String r0 = "re"
            java.lang.String r0 = r4.optString(r0)     // Catch:{ Throwable -> 0x0072 }
            boolean r5 = f2954h     // Catch:{ Throwable -> 0x0072 }
            boolean r0 = com.loc.AuthConfigManager.m3675a((java.lang.String) r0, (boolean) r5)     // Catch:{ Throwable -> 0x0072 }
            f2954h = r0     // Catch:{ Throwable -> 0x0072 }
            java.lang.String r0 = "pref"
            java.lang.String r5 = "fr"
            boolean r6 = f2954h     // Catch:{ Throwable -> 0x0072 }
            com.loc.SpUtil.m3488a((android.content.Context) r1, (java.lang.String) r0, (java.lang.String) r5, (boolean) r6)     // Catch:{ Throwable -> 0x0072 }
            goto L_0x007a
        L_0x0072:
            r0 = move-exception
            java.lang.String r5 = "AuthUtil"
            java.lang.String r6 = "checkReLocationAble"
            com.loc.CoreUtil.m3389a(r0, r5, r6)     // Catch:{ Throwable -> 0x00da }
        L_0x007a:
            java.lang.String r0 = "nla"
            java.lang.String r0 = r4.optString(r0)     // Catch:{ Throwable -> 0x0088 }
            boolean r5 = f2936Z     // Catch:{ Throwable -> 0x0088 }
            boolean r0 = com.loc.AuthConfigManager.m3675a((java.lang.String) r0, (boolean) r5)     // Catch:{ Throwable -> 0x0088 }
            f2936Z = r0     // Catch:{ Throwable -> 0x0088 }
        L_0x0088:
            java.lang.String r0 = "oda"
            java.lang.String r0 = r4.optString(r0)     // Catch:{ Throwable -> 0x009f }
            boolean r5 = f2956j     // Catch:{ Throwable -> 0x009f }
            boolean r0 = com.loc.AuthConfigManager.m3675a((java.lang.String) r0, (boolean) r5)     // Catch:{ Throwable -> 0x009f }
            f2956j = r0     // Catch:{ Throwable -> 0x009f }
            java.lang.String r0 = "pref"
            java.lang.String r5 = "oda"
            boolean r6 = f2956j     // Catch:{ Throwable -> 0x009f }
            com.loc.SpUtil.m3488a((android.content.Context) r1, (java.lang.String) r0, (java.lang.String) r5, (boolean) r6)     // Catch:{ Throwable -> 0x009f }
        L_0x009f:
            java.lang.String r0 = "asw"
            java.lang.String r0 = r4.optString(r0)     // Catch:{ Throwable -> 0x00b6 }
            boolean r5 = f2943af     // Catch:{ Throwable -> 0x00b6 }
            boolean r0 = com.loc.AuthConfigManager.m3675a((java.lang.String) r0, (boolean) r5)     // Catch:{ Throwable -> 0x00b6 }
            f2943af = r0     // Catch:{ Throwable -> 0x00b6 }
            java.lang.String r0 = "pref"
            java.lang.String r5 = "asw"
            boolean r6 = f2943af     // Catch:{ Throwable -> 0x00b6 }
            com.loc.SpUtil.m3488a((android.content.Context) r1, (java.lang.String) r0, (java.lang.String) r5, (boolean) r6)     // Catch:{ Throwable -> 0x00b6 }
        L_0x00b6:
            java.lang.String r0 = "mlpl"
            org.json.JSONArray r0 = r4.optJSONArray(r0)     // Catch:{ Throwable -> 0x00e2 }
            if (r0 == 0) goto L_0x00e2
            int r4 = r0.length()     // Catch:{ Throwable -> 0x00e2 }
            if (r4 <= 0) goto L_0x00e2
            r4 = 0
        L_0x00c5:
            int r5 = r0.length()     // Catch:{ Throwable -> 0x00e2 }
            if (r4 >= r5) goto L_0x00e2
            java.lang.String r5 = r0.getString(r4)     // Catch:{ Throwable -> 0x00e2 }
            boolean r5 = com.loc.C1079cp.m3532c((android.content.Context) r1, (java.lang.String) r5)     // Catch:{ Throwable -> 0x00e2 }
            f2938aa = r5     // Catch:{ Throwable -> 0x00e2 }
            if (r5 != 0) goto L_0x00e2
            int r4 = r4 + 1
            goto L_0x00c5
        L_0x00da:
            r0 = move-exception
            java.lang.String r4 = "AuthUtil"
            java.lang.String r5 = "loadConfigAbleStatus"
            com.loc.CoreUtil.m3389a(r0, r4, r5)     // Catch:{ Throwable -> 0x0696 }
        L_0x00e2:
            r4 = 0
            r6 = -1
            r7 = 1
            org.json.JSONObject r0 = r2.f3202h     // Catch:{ Throwable -> 0x0164 }
            if (r0 == 0) goto L_0x016c
            java.lang.String r8 = "callamapflag"
            java.lang.String r8 = r0.optString(r8)     // Catch:{ Throwable -> 0x0164 }
            boolean r9 = f2911A     // Catch:{ Throwable -> 0x0164 }
            boolean r8 = com.loc.AuthConfigManager.m3675a((java.lang.String) r8, (boolean) r9)     // Catch:{ Throwable -> 0x0164 }
            f2911A = r8     // Catch:{ Throwable -> 0x0164 }
            java.lang.String r8 = "co"
            java.lang.String r8 = r0.optString(r8)     // Catch:{ Throwable -> 0x0164 }
            boolean r8 = com.loc.AuthConfigManager.m3675a((java.lang.String) r8, (boolean) r3)     // Catch:{ Throwable -> 0x0164 }
            if (r8 == 0) goto L_0x010a
            boolean r8 = f2911A     // Catch:{ Throwable -> 0x0164 }
            if (r8 == 0) goto L_0x010a
            r8 = 1
            goto L_0x010b
        L_0x010a:
            r8 = 0
        L_0x010b:
            f2948b = r8     // Catch:{ Throwable -> 0x0164 }
            boolean r8 = f2911A     // Catch:{ Throwable -> 0x0164 }
            if (r8 == 0) goto L_0x016c
            java.lang.String r8 = "count"
            int r9 = f2912B     // Catch:{ Throwable -> 0x0164 }
            int r8 = r0.optInt(r8, r9)     // Catch:{ Throwable -> 0x0164 }
            f2912B = r8     // Catch:{ Throwable -> 0x0164 }
            java.lang.String r8 = "sysTime"
            long r9 = f2913C     // Catch:{ Throwable -> 0x0164 }
            long r8 = r0.optLong(r8, r9)     // Catch:{ Throwable -> 0x0164 }
            f2913C = r8     // Catch:{ Throwable -> 0x0164 }
            java.lang.String r8 = "sn"
            org.json.JSONArray r0 = r0.optJSONArray(r8)     // Catch:{ Throwable -> 0x0164 }
            if (r0 == 0) goto L_0x0146
            int r8 = r0.length()     // Catch:{ Throwable -> 0x0164 }
            if (r8 <= 0) goto L_0x0146
            r8 = 0
        L_0x0134:
            int r9 = r0.length()     // Catch:{ Throwable -> 0x0164 }
            if (r8 >= r9) goto L_0x0146
            java.util.ArrayList<java.lang.String> r9 = f2914D     // Catch:{ Throwable -> 0x0164 }
            java.lang.String r10 = r0.getString(r8)     // Catch:{ Throwable -> 0x0164 }
            r9.add(r10)     // Catch:{ Throwable -> 0x0164 }
            int r8 = r8 + 1
            goto L_0x0134
        L_0x0146:
            int r0 = f2912B     // Catch:{ Throwable -> 0x0164 }
            if (r0 == r6) goto L_0x016c
            long r8 = f2913C     // Catch:{ Throwable -> 0x0164 }
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x016c
            java.lang.String r0 = "pref"
            java.lang.String r8 = "nowtime"
            long r8 = com.loc.SpUtil.m3491b((android.content.Context) r1, (java.lang.String) r0, (java.lang.String) r8, (long) r4)     // Catch:{ Throwable -> 0x0164 }
            long r10 = f2913C     // Catch:{ Throwable -> 0x0164 }
            boolean r0 = com.loc.C1079cp.m3523b((long) r10, (long) r8)     // Catch:{ Throwable -> 0x0164 }
            if (r0 != 0) goto L_0x016c
            m3362h(r16)     // Catch:{ Throwable -> 0x0164 }
            goto L_0x016c
        L_0x0164:
            r0 = move-exception
            java.lang.String r8 = "AuthUtil"
            java.lang.String r9 = "loadConfigDataCallAMapSer"
            com.loc.CoreUtil.m3389a(r0, r8, r9)     // Catch:{ Throwable -> 0x0696 }
        L_0x016c:
            org.json.JSONObject r0 = r2.f3205k     // Catch:{ Throwable -> 0x01d3 }
            if (r0 == 0) goto L_0x01db
            java.lang.String r8 = "amappushflag"
            java.lang.String r8 = r0.optString(r8)     // Catch:{ Throwable -> 0x01d3 }
            boolean r9 = f2915E     // Catch:{ Throwable -> 0x01d3 }
            boolean r8 = com.loc.AuthConfigManager.m3675a((java.lang.String) r8, (boolean) r9)     // Catch:{ Throwable -> 0x01d3 }
            f2915E = r8     // Catch:{ Throwable -> 0x01d3 }
            if (r8 == 0) goto L_0x01db
            java.lang.String r8 = "count"
            int r9 = f2916F     // Catch:{ Throwable -> 0x01d3 }
            int r8 = r0.optInt(r8, r9)     // Catch:{ Throwable -> 0x01d3 }
            f2916F = r8     // Catch:{ Throwable -> 0x01d3 }
            java.lang.String r8 = "sysTime"
            long r9 = f2917G     // Catch:{ Throwable -> 0x01d3 }
            long r8 = r0.optLong(r8, r9)     // Catch:{ Throwable -> 0x01d3 }
            f2917G = r8     // Catch:{ Throwable -> 0x01d3 }
            java.lang.String r8 = "sn"
            org.json.JSONArray r0 = r0.optJSONArray(r8)     // Catch:{ Throwable -> 0x01d3 }
            if (r0 == 0) goto L_0x01b5
            int r8 = r0.length()     // Catch:{ Throwable -> 0x01d3 }
            if (r8 <= 0) goto L_0x01b5
            r8 = 0
        L_0x01a3:
            int r9 = r0.length()     // Catch:{ Throwable -> 0x01d3 }
            if (r8 >= r9) goto L_0x01b5
            java.util.ArrayList<java.lang.String> r9 = f2918H     // Catch:{ Throwable -> 0x01d3 }
            java.lang.String r10 = r0.getString(r8)     // Catch:{ Throwable -> 0x01d3 }
            r9.add(r10)     // Catch:{ Throwable -> 0x01d3 }
            int r8 = r8 + 1
            goto L_0x01a3
        L_0x01b5:
            int r0 = f2916F     // Catch:{ Throwable -> 0x01d3 }
            if (r0 == r6) goto L_0x01db
            long r8 = f2917G     // Catch:{ Throwable -> 0x01d3 }
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x01db
            java.lang.String r0 = "pref"
            java.lang.String r8 = "pushSerTime"
            long r4 = com.loc.SpUtil.m3491b((android.content.Context) r1, (java.lang.String) r0, (java.lang.String) r8, (long) r4)     // Catch:{ Throwable -> 0x01d3 }
            long r8 = f2917G     // Catch:{ Throwable -> 0x01d3 }
            boolean r0 = com.loc.C1079cp.m3523b((long) r8, (long) r4)     // Catch:{ Throwable -> 0x01d3 }
            if (r0 != 0) goto L_0x01db
            m3363i(r16)     // Catch:{ Throwable -> 0x01d3 }
            goto L_0x01db
        L_0x01d3:
            r0 = move-exception
            java.lang.String r4 = "AuthUtil"
            java.lang.String r5 = "loadConfigDataCallAMapPush"
            com.loc.CoreUtil.m3389a(r0, r4, r5)     // Catch:{ Throwable -> 0x0696 }
        L_0x01db:
            com.loc.di r0 = com.loc.CoreUtil.m3392b()     // Catch:{ Throwable -> 0x020f }
            com.loc.cz$a$d r4 = r2.f3219y     // Catch:{ Throwable -> 0x020f }
            r5 = 0
            if (r4 == 0) goto L_0x020b
            java.lang.String r8 = r4.f3232b     // Catch:{ Throwable -> 0x020f }
            java.lang.String r9 = r4.f3231a     // Catch:{ Throwable -> 0x020f }
            java.lang.String r4 = r4.f3233c     // Catch:{ Throwable -> 0x020f }
            boolean r10 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Throwable -> 0x020f }
            if (r10 != 0) goto L_0x020b
            boolean r10 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Throwable -> 0x020f }
            if (r10 != 0) goto L_0x020b
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Throwable -> 0x020f }
            if (r4 == 0) goto L_0x01fd
            goto L_0x020b
        L_0x01fd:
            com.loc.s r4 = new com.loc.s     // Catch:{ Throwable -> 0x020f }
            boolean r5 = f2957k     // Catch:{ Throwable -> 0x020f }
            r4.<init>(r9, r8, r5)     // Catch:{ Throwable -> 0x020f }
            r4.mo13313a(r7)     // Catch:{ Throwable -> 0x020f }
            com.loc.InstanceFactory.m3973b(r1, r4, r0)     // Catch:{ Throwable -> 0x020f }
            goto L_0x0217
        L_0x020b:
            com.loc.InstanceFactory.m3973b(r1, r5, r0)     // Catch:{ Throwable -> 0x020f }
            goto L_0x0217
        L_0x020f:
            r0 = move-exception
            java.lang.String r4 = "AuthUtil"
            java.lang.String r5 = "loadConfigDataSdkUpdate"
            com.loc.CoreUtil.m3389a(r0, r4, r5)     // Catch:{ Throwable -> 0x0696 }
        L_0x0217:
            boolean r0 = f2937a     // Catch:{ Throwable -> 0x0696 }
            if (r0 == 0) goto L_0x0258
            com.loc.cz$a$c r0 = r2.f3188B     // Catch:{ Throwable -> 0x0250 }
            if (r0 == 0) goto L_0x0258
            java.lang.String r4 = r0.f3229a     // Catch:{ Throwable -> 0x0250 }
            f2919I = r4     // Catch:{ Throwable -> 0x0250 }
            java.lang.String r0 = r0.f3230b     // Catch:{ Throwable -> 0x0250 }
            f2920J = r0     // Catch:{ Throwable -> 0x0250 }
            java.lang.String r0 = f2919I     // Catch:{ Throwable -> 0x0250 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Throwable -> 0x0250 }
            if (r0 != 0) goto L_0x0258
            java.lang.String r0 = f2920J     // Catch:{ Throwable -> 0x0250 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Throwable -> 0x0250 }
            if (r0 != 0) goto L_0x0258
            com.loc.db r0 = new com.loc.db     // Catch:{ Throwable -> 0x0250 }
            java.lang.String r4 = "loc"
            java.lang.String r5 = f2919I     // Catch:{ Throwable -> 0x0250 }
            java.lang.String r8 = f2920J     // Catch:{ Throwable -> 0x0250 }
            r0.<init>(r1, r4, r5, r8)     // Catch:{ Throwable -> 0x0250 }
            boolean r4 = f2957k     // Catch:{ Throwable -> 0x0250 }
            r0.mo13259b(r4)     // Catch:{ Throwable -> 0x0250 }
            boolean r4 = f2956j     // Catch:{ Throwable -> 0x0250 }
            r0.mo13258a(r4)     // Catch:{ Throwable -> 0x0250 }
            r0.mo13257a()     // Catch:{ Throwable -> 0x0250 }
            goto L_0x0258
        L_0x0250:
            r0 = move-exception
            java.lang.String r4 = "AuthUtil"
            java.lang.String r5 = "loadConfigDataGroupOffset"
            com.loc.CoreUtil.m3389a(r0, r4, r5)     // Catch:{ Throwable -> 0x0696 }
        L_0x0258:
            r4 = 30
            com.loc.cz$a$a r0 = r2.f3218x     // Catch:{ Throwable -> 0x02d3 }
            if (r0 == 0) goto L_0x02db
            boolean r5 = r0.f3221a     // Catch:{ Throwable -> 0x02d3 }
            f2967u = r5     // Catch:{ Throwable -> 0x02d3 }
            java.lang.String r5 = "pref"
            java.lang.String r8 = "exception"
            boolean r9 = f2967u     // Catch:{ Throwable -> 0x02d3 }
            com.loc.SpUtil.m3488a((android.content.Context) r1, (java.lang.String) r5, (java.lang.String) r8, (boolean) r9)     // Catch:{ Throwable -> 0x02d3 }
            org.json.JSONObject r0 = r0.f3223c     // Catch:{ Throwable -> 0x02d3 }
            java.lang.String r5 = "fn"
            int r8 = f2968v     // Catch:{ Throwable -> 0x02d3 }
            int r5 = r0.optInt(r5, r8)     // Catch:{ Throwable -> 0x02d3 }
            f2968v = r5     // Catch:{ Throwable -> 0x02d3 }
            java.lang.String r5 = "mpn"
            int r8 = f2969w     // Catch:{ Throwable -> 0x02d3 }
            int r5 = r0.optInt(r5, r8)     // Catch:{ Throwable -> 0x02d3 }
            f2969w = r5     // Catch:{ Throwable -> 0x02d3 }
            r8 = 500(0x1f4, float:7.0E-43)
            if (r5 <= r8) goto L_0x0287
            f2969w = r8     // Catch:{ Throwable -> 0x02d3 }
        L_0x0287:
            int r5 = f2969w     // Catch:{ Throwable -> 0x02d3 }
            if (r5 >= r4) goto L_0x028d
            f2969w = r4     // Catch:{ Throwable -> 0x02d3 }
        L_0x028d:
            java.lang.String r5 = "igu"
            java.lang.String r5 = r0.optString(r5)     // Catch:{ Throwable -> 0x02d3 }
            boolean r8 = f2970x     // Catch:{ Throwable -> 0x02d3 }
            boolean r5 = com.loc.AuthConfigManager.m3675a((java.lang.String) r5, (boolean) r8)     // Catch:{ Throwable -> 0x02d3 }
            f2970x = r5     // Catch:{ Throwable -> 0x02d3 }
            java.lang.String r5 = "ms"
            int r8 = f2971y     // Catch:{ Throwable -> 0x02d3 }
            int r0 = r0.optInt(r5, r8)     // Catch:{ Throwable -> 0x02d3 }
            f2971y = r0     // Catch:{ Throwable -> 0x02d3 }
            int r0 = f2968v     // Catch:{ Throwable -> 0x02d3 }
            boolean r5 = f2970x     // Catch:{ Throwable -> 0x02d3 }
            int r8 = f2971y     // Catch:{ Throwable -> 0x02d3 }
            com.loc.OfflineLocManager.m3058a(r0, r5, r8)     // Catch:{ Throwable -> 0x02d3 }
            java.lang.String r0 = "pref"
            java.lang.String r5 = "fn"
            int r8 = f2968v     // Catch:{ Throwable -> 0x02d3 }
            com.loc.SpUtil.m3485a((android.content.Context) r1, (java.lang.String) r0, (java.lang.String) r5, (int) r8)     // Catch:{ Throwable -> 0x02d3 }
            java.lang.String r0 = "pref"
            java.lang.String r5 = "mpn"
            int r8 = f2969w     // Catch:{ Throwable -> 0x02d3 }
            com.loc.SpUtil.m3485a((android.content.Context) r1, (java.lang.String) r0, (java.lang.String) r5, (int) r8)     // Catch:{ Throwable -> 0x02d3 }
            java.lang.String r0 = "pref"
            java.lang.String r5 = "igu"
            boolean r8 = f2970x     // Catch:{ Throwable -> 0x02d3 }
            com.loc.SpUtil.m3488a((android.content.Context) r1, (java.lang.String) r0, (java.lang.String) r5, (boolean) r8)     // Catch:{ Throwable -> 0x02d3 }
            java.lang.String r0 = "pref"
            java.lang.String r5 = "ms"
            int r8 = f2971y     // Catch:{ Throwable -> 0x02d3 }
            com.loc.SpUtil.m3485a((android.content.Context) r1, (java.lang.String) r0, (java.lang.String) r5, (int) r8)     // Catch:{ Throwable -> 0x02d3 }
            goto L_0x02db
        L_0x02d3:
            r0 = move-exception
            java.lang.String r5 = "AuthUtil"
            java.lang.String r8 = "loadConfigDataUploadException"
            com.loc.CoreUtil.m3389a(r0, r5, r8)     // Catch:{ Throwable -> 0x0696 }
        L_0x02db:
            r5 = 2
            org.json.JSONObject r8 = r2.f3207m     // Catch:{ Throwable -> 0x0360 }
            if (r8 == 0) goto L_0x0368
            java.lang.String r0 = "able"
            java.lang.String r0 = r8.optString(r0)     // Catch:{ Throwable -> 0x0360 }
            boolean r0 = com.loc.AuthConfigManager.m3675a((java.lang.String) r0, (boolean) r3)     // Catch:{ Throwable -> 0x0360 }
            if (r0 == 0) goto L_0x0368
            java.lang.String r0 = "fs"
            com.loc.ce$a r0 = m3341a((org.json.JSONObject) r8, (java.lang.String) r0)     // Catch:{ Throwable -> 0x0360 }
            if (r0 == 0) goto L_0x0309
            boolean r9 = r0.f2975c     // Catch:{ Throwable -> 0x0360 }
            f2962p = r9     // Catch:{ Throwable -> 0x0360 }
            java.lang.String r0 = r0.f2974b     // Catch:{ Throwable -> 0x0301 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Throwable -> 0x0301 }
            f2963q = r0     // Catch:{ Throwable -> 0x0301 }
            goto L_0x0309
        L_0x0301:
            r0 = move-exception
            java.lang.String r9 = "AuthUtil"
            java.lang.String r10 = "loadconfig part2"
            com.loc.CoreUtil.m3389a(r0, r9, r10)     // Catch:{ Throwable -> 0x0360 }
        L_0x0309:
            java.lang.String r0 = "us"
            com.loc.ce$a r0 = m3341a((org.json.JSONObject) r8, (java.lang.String) r0)     // Catch:{ Throwable -> 0x0360 }
            if (r0 == 0) goto L_0x0330
            boolean r9 = r0.f2975c     // Catch:{ Throwable -> 0x0360 }
            f2964r = r9     // Catch:{ Throwable -> 0x0360 }
            boolean r9 = r0.f2973a     // Catch:{ Throwable -> 0x0360 }
            f2966t = r9     // Catch:{ Throwable -> 0x0360 }
            java.lang.String r0 = r0.f2974b     // Catch:{ Throwable -> 0x0322 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Throwable -> 0x0322 }
            f2965s = r0     // Catch:{ Throwable -> 0x0322 }
            goto L_0x032a
        L_0x0322:
            r0 = move-exception
            java.lang.String r9 = "AuthUtil"
            java.lang.String r10 = "loadconfig part1"
            com.loc.CoreUtil.m3389a(r0, r9, r10)     // Catch:{ Throwable -> 0x0360 }
        L_0x032a:
            int r0 = f2965s     // Catch:{ Throwable -> 0x0360 }
            if (r0 >= r5) goto L_0x0330
            f2964r = r3     // Catch:{ Throwable -> 0x0360 }
        L_0x0330:
            java.lang.String r0 = "rs"
            com.loc.ce$a r0 = m3341a((org.json.JSONObject) r8, (java.lang.String) r0)     // Catch:{ Throwable -> 0x0360 }
            if (r0 == 0) goto L_0x0368
            boolean r8 = r0.f2975c     // Catch:{ Throwable -> 0x0360 }
            f2958l = r8     // Catch:{ Throwable -> 0x0360 }
            if (r8 == 0) goto L_0x034b
            long r8 = com.loc.C1079cp.m3529c()     // Catch:{ Throwable -> 0x0360 }
            f2960n = r8     // Catch:{ Throwable -> 0x0360 }
            int r8 = r0.f2976d     // Catch:{ Throwable -> 0x0360 }
            int r8 = r8 * 1000
            long r8 = (long) r8     // Catch:{ Throwable -> 0x0360 }
            f2961o = r8     // Catch:{ Throwable -> 0x0360 }
        L_0x034b:
            java.lang.String r0 = r0.f2974b     // Catch:{ Throwable -> 0x0357 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Throwable -> 0x0357 }
            int r0 = r0 * 1000
            long r8 = (long) r0     // Catch:{ Throwable -> 0x0357 }
            f2959m = r8     // Catch:{ Throwable -> 0x0357 }
            goto L_0x0368
        L_0x0357:
            r0 = move-exception
            java.lang.String r8 = "AuthUtil"
            java.lang.String r9 = "loadconfig part"
            com.loc.CoreUtil.m3389a(r0, r8, r9)     // Catch:{ Throwable -> 0x0360 }
            goto L_0x0368
        L_0x0360:
            r0 = move-exception
            java.lang.String r8 = "AuthUtil"
            java.lang.String r9 = "loadConfigDataLocate"
            com.loc.CoreUtil.m3389a(r0, r8, r9)     // Catch:{ Throwable -> 0x0696 }
        L_0x0368:
            org.json.JSONObject r0 = r2.f3209o     // Catch:{ Throwable -> 0x0397 }
            if (r0 == 0) goto L_0x039f
            java.lang.String r8 = "able"
            java.lang.String r8 = r0.optString(r8)     // Catch:{ Throwable -> 0x0397 }
            boolean r9 = f2921K     // Catch:{ Throwable -> 0x0397 }
            boolean r8 = com.loc.AuthConfigManager.m3675a((java.lang.String) r8, (boolean) r9)     // Catch:{ Throwable -> 0x0397 }
            f2921K = r8     // Catch:{ Throwable -> 0x0397 }
            if (r8 == 0) goto L_0x039f
            java.lang.String r8 = "c"
            int r8 = r0.optInt(r8, r3)     // Catch:{ Throwable -> 0x0397 }
            if (r8 != 0) goto L_0x0389
            r8 = 3000(0xbb8, float:4.204E-42)
            f2922L = r8     // Catch:{ Throwable -> 0x0397 }
            goto L_0x038d
        L_0x0389:
            int r8 = r8 * 1000
            f2922L = r8     // Catch:{ Throwable -> 0x0397 }
        L_0x038d:
            java.lang.String r8 = "t"
            int r0 = r0.getInt(r8)     // Catch:{ Throwable -> 0x0397 }
            int r0 = r0 / r5
            f2923M = r0     // Catch:{ Throwable -> 0x0397 }
            goto L_0x039f
        L_0x0397:
            r0 = move-exception
            java.lang.String r5 = "AuthUtil"
            java.lang.String r8 = "loadConfigDataNgps"
            com.loc.CoreUtil.m3389a(r0, r5, r8)     // Catch:{ Throwable -> 0x0696 }
        L_0x039f:
            org.json.JSONObject r0 = r2.f3210p     // Catch:{ Throwable -> 0x03d3 }
            if (r0 == 0) goto L_0x03db
            java.lang.String r5 = "able"
            java.lang.String r5 = r0.optString(r5)     // Catch:{ Throwable -> 0x03d3 }
            boolean r8 = f2924N     // Catch:{ Throwable -> 0x03d3 }
            boolean r5 = com.loc.AuthConfigManager.m3675a((java.lang.String) r5, (boolean) r8)     // Catch:{ Throwable -> 0x03d3 }
            f2924N = r5     // Catch:{ Throwable -> 0x03d3 }
            if (r5 == 0) goto L_0x03c0
            java.lang.String r5 = "c"
            r8 = 300(0x12c, float:4.2E-43)
            int r0 = r0.optInt(r5, r8)     // Catch:{ Throwable -> 0x03d3 }
            int r0 = r0 * 1000
            long r8 = (long) r0     // Catch:{ Throwable -> 0x03d3 }
            f2925O = r8     // Catch:{ Throwable -> 0x03d3 }
        L_0x03c0:
            java.lang.String r0 = "pref"
            java.lang.String r5 = "ca"
            boolean r8 = f2924N     // Catch:{ Throwable -> 0x03d3 }
            com.loc.SpUtil.m3488a((android.content.Context) r1, (java.lang.String) r0, (java.lang.String) r5, (boolean) r8)     // Catch:{ Throwable -> 0x03d3 }
            java.lang.String r0 = "pref"
            java.lang.String r5 = "ct"
            long r8 = f2925O     // Catch:{ Throwable -> 0x03d3 }
            com.loc.SpUtil.m3486a((android.content.Context) r1, (java.lang.String) r0, (java.lang.String) r5, (long) r8)     // Catch:{ Throwable -> 0x03d3 }
            goto L_0x03db
        L_0x03d3:
            r0 = move-exception
            java.lang.String r5 = "AuthUtil"
            java.lang.String r8 = "loadConfigDataCacheAble"
            com.loc.CoreUtil.m3389a(r0, r5, r8)     // Catch:{ Throwable -> 0x0696 }
        L_0x03db:
            com.loc.cz$a$b r0 = r2.f3191E     // Catch:{ Throwable -> 0x03ef }
            if (r0 == 0) goto L_0x03f7
            boolean r5 = com.loc.DnsManager.m3250c()     // Catch:{ Throwable -> 0x03ef }
            r5 = r5 ^ r7
            java.lang.String r8 = "HttpDNS"
            java.lang.String r9 = "1.0.0"
            boolean r0 = m3346a(r1, r0, r8, r9, r5)     // Catch:{ Throwable -> 0x03ef }
            f2926P = r0     // Catch:{ Throwable -> 0x03ef }
            goto L_0x03f7
        L_0x03ef:
            r0 = move-exception
            java.lang.String r5 = "AuthUtil"
            java.lang.String r8 = "loadConfigDataDnsDex"
            com.loc.CoreUtil.m3389a(r0, r5, r8)     // Catch:{ Throwable -> 0x0696 }
        L_0x03f7:
            org.json.JSONObject r0 = r2.f3204j     // Catch:{ Throwable -> 0x04f8 }
            if (r0 == 0) goto L_0x0500
            java.lang.String r5 = "able"
            java.lang.String r5 = r0.optString(r5)     // Catch:{ Throwable -> 0x04f8 }
            boolean r8 = f2928R     // Catch:{ Throwable -> 0x04f8 }
            boolean r5 = com.loc.AuthConfigManager.m3675a((java.lang.String) r5, (boolean) r8)     // Catch:{ Throwable -> 0x04f8 }
            f2928R = r5     // Catch:{ Throwable -> 0x04f8 }
            java.lang.String r5 = "sysTime"
            long r8 = com.loc.C1079cp.m3518b()     // Catch:{ Throwable -> 0x04f8 }
            long r8 = r0.optLong(r5, r8)     // Catch:{ Throwable -> 0x04f8 }
            f2929S = r8     // Catch:{ Throwable -> 0x04f8 }
            java.lang.String r5 = "n"
            int r5 = r0.optInt(r5, r7)     // Catch:{ Throwable -> 0x04f8 }
            f2930T = r5     // Catch:{ Throwable -> 0x04f8 }
            java.lang.String r5 = "nh"
            int r5 = r0.optInt(r5, r7)     // Catch:{ Throwable -> 0x04f8 }
            f2931U = r5     // Catch:{ Throwable -> 0x04f8 }
            int r5 = f2930T     // Catch:{ Throwable -> 0x04f8 }
            if (r5 == r6) goto L_0x0432
            int r5 = f2930T     // Catch:{ Throwable -> 0x04f8 }
            int r8 = f2931U     // Catch:{ Throwable -> 0x04f8 }
            if (r5 < r8) goto L_0x0430
            goto L_0x0432
        L_0x0430:
            r5 = 0
            goto L_0x0433
        L_0x0432:
            r5 = 1
        L_0x0433:
            boolean r8 = f2928R     // Catch:{ Throwable -> 0x04f8 }
            if (r8 == 0) goto L_0x0500
            if (r5 == 0) goto L_0x0500
            java.lang.String r5 = "l"
            org.json.JSONArray r5 = r0.optJSONArray(r5)     // Catch:{ Throwable -> 0x04f8 }
            r8 = 0
        L_0x0440:
            int r9 = r5.length()     // Catch:{ Throwable -> 0x04f8 }
            if (r8 >= r9) goto L_0x04d1
            org.json.JSONObject r9 = r5.optJSONObject(r8)     // Catch:{ Throwable -> 0x04ca }
            com.loc.ci r10 = new com.loc.ci     // Catch:{ Throwable -> 0x04ca }
            r10.<init>()     // Catch:{ Throwable -> 0x04ca }
            java.lang.String r11 = "able"
            java.lang.String r12 = "false"
            java.lang.String r11 = r9.optString(r11, r12)     // Catch:{ Throwable -> 0x04ca }
            boolean r11 = com.loc.AuthConfigManager.m3675a((java.lang.String) r11, (boolean) r3)     // Catch:{ Throwable -> 0x04ca }
            r10.f2995a = r11     // Catch:{ Throwable -> 0x04ca }
            if (r11 != 0) goto L_0x0460
            goto L_0x04ca
        L_0x0460:
            java.lang.String r11 = "pn"
            java.lang.String r12 = ""
            java.lang.String r11 = r9.optString(r11, r12)     // Catch:{ Throwable -> 0x04ca }
            r10.f2996b = r11     // Catch:{ Throwable -> 0x04ca }
            java.lang.String r11 = "cn"
            java.lang.String r12 = ""
            java.lang.String r11 = r9.optString(r11, r12)     // Catch:{ Throwable -> 0x04ca }
            r10.f2997c = r11     // Catch:{ Throwable -> 0x04ca }
            java.lang.String r11 = "a"
            java.lang.String r12 = ""
            java.lang.String r11 = r9.optString(r11, r12)     // Catch:{ Throwable -> 0x04ca }
            r10.f2999e = r11     // Catch:{ Throwable -> 0x04ca }
            java.lang.String r11 = "b"
            org.json.JSONArray r11 = r9.optJSONArray(r11)     // Catch:{ Throwable -> 0x04ca }
            if (r11 == 0) goto L_0x04b7
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ Throwable -> 0x04ca }
            r12.<init>()     // Catch:{ Throwable -> 0x04ca }
            r13 = 0
        L_0x048c:
            int r14 = r11.length()     // Catch:{ Throwable -> 0x04ca }
            if (r13 >= r14) goto L_0x04b5
            org.json.JSONObject r14 = r11.optJSONObject(r13)     // Catch:{ Throwable -> 0x04ca }
            java.util.HashMap r15 = new java.util.HashMap     // Catch:{ Throwable -> 0x04ca }
            r4 = 16
            r15.<init>(r4)     // Catch:{ Throwable -> 0x04ca }
            java.lang.String r4 = "k"
            java.lang.String r4 = r14.optString(r4)     // Catch:{ Throwable -> 0x04af }
            java.lang.String r7 = "v"
            java.lang.String r7 = r14.optString(r7)     // Catch:{ Throwable -> 0x04af }
            r15.put(r4, r7)     // Catch:{ Throwable -> 0x04af }
            r12.add(r15)     // Catch:{ Throwable -> 0x04af }
        L_0x04af:
            int r13 = r13 + 1
            r4 = 30
            r7 = 1
            goto L_0x048c
        L_0x04b5:
            r10.f2998d = r12     // Catch:{ Throwable -> 0x04ca }
        L_0x04b7:
            java.lang.String r4 = "is"
            java.lang.String r7 = "false"
            java.lang.String r4 = r9.optString(r4, r7)     // Catch:{ Throwable -> 0x04ca }
            boolean r4 = com.loc.AuthConfigManager.m3675a((java.lang.String) r4, (boolean) r3)     // Catch:{ Throwable -> 0x04ca }
            r10.f3000f = r4     // Catch:{ Throwable -> 0x04ca }
            java.util.List<com.loc.ci> r4 = f2927Q     // Catch:{ Throwable -> 0x04ca }
            r4.add(r10)     // Catch:{ Throwable -> 0x04ca }
        L_0x04ca:
            int r8 = r8 + 1
            r4 = 30
            r7 = 1
            goto L_0x0440
        L_0x04d1:
            java.lang.String r4 = "sl"
            org.json.JSONArray r0 = r0.optJSONArray(r4)     // Catch:{ Throwable -> 0x04f8 }
            if (r0 == 0) goto L_0x0500
            r4 = 0
        L_0x04da:
            int r5 = r0.length()     // Catch:{ Throwable -> 0x04f8 }
            if (r4 >= r5) goto L_0x0500
            org.json.JSONObject r5 = r0.optJSONObject(r4)     // Catch:{ Throwable -> 0x04f8 }
            java.lang.String r7 = "pan"
            java.lang.String r5 = r5.optString(r7)     // Catch:{ Throwable -> 0x04f8 }
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Throwable -> 0x04f8 }
            if (r7 != 0) goto L_0x04f5
            java.util.List<java.lang.String> r7 = f2932V     // Catch:{ Throwable -> 0x04f8 }
            r7.add(r5)     // Catch:{ Throwable -> 0x04f8 }
        L_0x04f5:
            int r4 = r4 + 1
            goto L_0x04da
        L_0x04f8:
            r0 = move-exception
            java.lang.String r4 = "AuthUtil"
            java.lang.String r5 = "loadConfigData_otherServiceList"
            com.loc.CoreUtil.m3389a(r0, r4, r5)     // Catch:{ Throwable -> 0x0696 }
        L_0x0500:
            org.json.JSONObject r0 = r2.f3203i     // Catch:{ Throwable -> 0x051f }
            if (r0 == 0) goto L_0x0527
            java.lang.String r4 = "able"
            java.lang.String r4 = r0.optString(r4)     // Catch:{ Throwable -> 0x051f }
            boolean r5 = f2933W     // Catch:{ Throwable -> 0x051f }
            boolean r4 = com.loc.AuthConfigManager.m3675a((java.lang.String) r4, (boolean) r5)     // Catch:{ Throwable -> 0x051f }
            f2933W = r4     // Catch:{ Throwable -> 0x051f }
            if (r4 == 0) goto L_0x0527
            java.lang.String r4 = "c"
            int r5 = f2934X     // Catch:{ Throwable -> 0x051f }
            int r0 = r0.optInt(r4, r5)     // Catch:{ Throwable -> 0x051f }
            f2934X = r0     // Catch:{ Throwable -> 0x051f }
            goto L_0x0527
        L_0x051f:
            r0 = move-exception
            java.lang.String r4 = "AuthUtil"
            java.lang.String r5 = "loadConfigDataGpsGeoAble"
            com.loc.CoreUtil.m3389a(r0, r4, r5)     // Catch:{ Throwable -> 0x0696 }
        L_0x0527:
            org.json.JSONObject r2 = r2.f3217w     // Catch:{ Throwable -> 0x0696 }
            if (r2 == 0) goto L_0x0604
            java.lang.String r0 = "157"
            org.json.JSONObject r0 = r2.optJSONObject(r0)     // Catch:{ Throwable -> 0x05fc }
            if (r0 == 0) goto L_0x0604
            java.lang.String r4 = "able"
            java.lang.String r4 = r0.optString(r4)     // Catch:{ Throwable -> 0x05fc }
            boolean r5 = f2939ab     // Catch:{ Throwable -> 0x05fc }
            boolean r4 = com.loc.AuthConfigManager.m3675a((java.lang.String) r4, (boolean) r5)     // Catch:{ Throwable -> 0x05fc }
            f2939ab = r4     // Catch:{ Throwable -> 0x05fc }
            java.lang.String r4 = "co"
            java.lang.String r5 = "1.0.0"
            com.loc.di r4 = com.loc.CoreUtil.m3385a((java.lang.String) r4, (java.lang.String) r5)     // Catch:{ Throwable -> 0x05fc }
            boolean r5 = f2939ab     // Catch:{ Throwable -> 0x05fc }
            if (r5 == 0) goto L_0x05c4
            java.lang.String r5 = "cv"
            int r5 = r0.optInt(r5, r6)     // Catch:{ Throwable -> 0x05fc }
            f2942ae = r5     // Catch:{ Throwable -> 0x05fc }
            java.lang.String r5 = "co"
            java.lang.String r5 = r0.optString(r5)     // Catch:{ Throwable -> 0x05fc }
            boolean r6 = f2940ac     // Catch:{ Throwable -> 0x05fc }
            boolean r5 = com.loc.AuthConfigManager.m3675a((java.lang.String) r5, (boolean) r6)     // Catch:{ Throwable -> 0x05fc }
            f2940ac = r5     // Catch:{ Throwable -> 0x05fc }
            java.lang.String r5 = "oo"
            java.lang.String r5 = r0.optString(r5)     // Catch:{ Throwable -> 0x05fc }
            boolean r6 = f2941ad     // Catch:{ Throwable -> 0x05fc }
            boolean r5 = com.loc.AuthConfigManager.m3675a((java.lang.String) r5, (boolean) r6)     // Catch:{ Throwable -> 0x05fc }
            f2941ad = r5     // Catch:{ Throwable -> 0x05fc }
            java.lang.String r5 = "v"
            java.lang.String r5 = r0.optString(r5)     // Catch:{ Throwable -> 0x05fc }
            java.lang.String r6 = "u"
            java.lang.String r6 = r0.optString(r6)     // Catch:{ Throwable -> 0x05fc }
            java.lang.String r7 = "m"
            java.lang.String r0 = r0.optString(r7)     // Catch:{ Throwable -> 0x05fc }
            boolean r7 = com.loc.CoManager.m3173a()     // Catch:{ Throwable -> 0x05fc }
            if (r7 != 0) goto L_0x05d7
            boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Throwable -> 0x05fc }
            if (r7 != 0) goto L_0x05d7
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Throwable -> 0x05fc }
            if (r7 != 0) goto L_0x05d7
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Throwable -> 0x05fc }
            if (r5 != 0) goto L_0x05d7
            com.loc.s r5 = new com.loc.s     // Catch:{ Throwable -> 0x05fc }
            boolean r7 = f2957k     // Catch:{ Throwable -> 0x05fc }
            r5.<init>(r6, r0, r7)     // Catch:{ Throwable -> 0x05fc }
            boolean r0 = f2956j     // Catch:{ Throwable -> 0x05fc }
            r5.mo13313a(r0)     // Catch:{ Throwable -> 0x05fc }
            boolean r0 = com.loc.InstanceFactory.m3971a((android.content.Context) r1, (com.loc.DexDownloadItem) r5, (com.loc.SDKInfo) r4)     // Catch:{ Throwable -> 0x05fc }
            r6 = r0 ^ 1
            f2955i = r6     // Catch:{ Throwable -> 0x05fc }
            if (r0 == 0) goto L_0x05d7
            java.lang.String r0 = "pref"
            java.lang.String r6 = "ok4"
            r7 = 1
            com.loc.SpUtil.m3488a((android.content.Context) r1, (java.lang.String) r0, (java.lang.String) r6, (boolean) r7)     // Catch:{ Throwable -> 0x05fc }
            java.lang.String r0 = "pref"
            java.lang.String r6 = "ok1"
            com.loc.SpUtil.m3485a((android.content.Context) r1, (java.lang.String) r0, (java.lang.String) r6, (int) r3)     // Catch:{ Throwable -> 0x05fc }
            com.loc.InstanceFactory.m3973b(r1, r5, r4)     // Catch:{ Throwable -> 0x05fc }
            goto L_0x05d7
        L_0x05c4:
            f2955i = r3     // Catch:{ Throwable -> 0x05fc }
            f2940ac = r3     // Catch:{ Throwable -> 0x05fc }
            f2941ad = r3     // Catch:{ Throwable -> 0x05fc }
            boolean r0 = com.loc.ReportUtil.m3439a((android.content.Context) r1, (com.loc.SDKInfo) r4)     // Catch:{ Throwable -> 0x05fc }
            if (r0 == 0) goto L_0x05d7
            java.lang.String r0 = "co"
            java.lang.String r4 = "config|coDex able is false"
            com.loc.RollBackDynamic.m3480a(r1, r0, r4)     // Catch:{ Throwable -> 0x05fc }
        L_0x05d7:
            java.lang.String r0 = "pref"
            java.lang.String r4 = "ok0"
            boolean r5 = f2939ab     // Catch:{ Throwable -> 0x05fc }
            com.loc.SpUtil.m3488a((android.content.Context) r1, (java.lang.String) r0, (java.lang.String) r4, (boolean) r5)     // Catch:{ Throwable -> 0x05fc }
            java.lang.String r0 = "pref"
            java.lang.String r4 = "ok1"
            boolean r5 = f2955i     // Catch:{ Throwable -> 0x05fc }
            com.loc.SpUtil.m3488a((android.content.Context) r1, (java.lang.String) r0, (java.lang.String) r4, (boolean) r5)     // Catch:{ Throwable -> 0x05fc }
            java.lang.String r0 = "pref"
            java.lang.String r4 = "ok2"
            boolean r5 = f2940ac     // Catch:{ Throwable -> 0x05fc }
            com.loc.SpUtil.m3488a((android.content.Context) r1, (java.lang.String) r0, (java.lang.String) r4, (boolean) r5)     // Catch:{ Throwable -> 0x05fc }
            java.lang.String r0 = "pref"
            java.lang.String r4 = "ok3"
            boolean r5 = f2941ad     // Catch:{ Throwable -> 0x05fc }
            com.loc.SpUtil.m3488a((android.content.Context) r1, (java.lang.String) r0, (java.lang.String) r4, (boolean) r5)     // Catch:{ Throwable -> 0x05fc }
            goto L_0x0604
        L_0x05fc:
            r0 = move-exception
            java.lang.String r4 = "AuthUtil"
            java.lang.String r5 = "loadConfigDataNewCollectionOffline"
            com.loc.CoreUtil.m3389a(r0, r4, r5)     // Catch:{ Throwable -> 0x0696 }
        L_0x0604:
            if (r1 == 0) goto L_0x0652
            if (r2 != 0) goto L_0x0609
            goto L_0x0652
        L_0x0609:
            java.lang.String r0 = "15O"
            org.json.JSONObject r0 = r2.optJSONObject(r0)     // Catch:{ Throwable -> 0x0652 }
            if (r0 == 0) goto L_0x0652
            java.lang.String r4 = "able"
            java.lang.String r4 = r0.optString(r4)     // Catch:{ Throwable -> 0x0652 }
            boolean r3 = com.loc.AuthConfigManager.m3675a((java.lang.String) r4, (boolean) r3)     // Catch:{ Throwable -> 0x0652 }
            if (r3 == 0) goto L_0x0645
            java.lang.String r3 = "fl"
            org.json.JSONArray r3 = r0.optJSONArray(r3)     // Catch:{ Throwable -> 0x0652 }
            if (r3 == 0) goto L_0x0637
            int r4 = r3.length()     // Catch:{ Throwable -> 0x0652 }
            if (r4 <= 0) goto L_0x0637
            java.lang.String r3 = r3.toString()     // Catch:{ Throwable -> 0x0652 }
            java.lang.String r4 = android.os.Build.MANUFACTURER     // Catch:{ Throwable -> 0x0652 }
            boolean r3 = r3.contains(r4)     // Catch:{ Throwable -> 0x0652 }
            if (r3 == 0) goto L_0x0645
        L_0x0637:
            java.lang.String r3 = "iv"
            r4 = 30
            int r0 = r0.optInt(r3, r4)     // Catch:{ Throwable -> 0x0652 }
            int r0 = r0 * 1000
            long r3 = (long) r0     // Catch:{ Throwable -> 0x0652 }
            f2944ag = r3     // Catch:{ Throwable -> 0x0652 }
            goto L_0x0649
        L_0x0645:
            r3 = -1
            f2944ag = r3     // Catch:{ Throwable -> 0x0652 }
        L_0x0649:
            java.lang.String r0 = "pref"
            java.lang.String r3 = "awsi"
            long r4 = f2944ag     // Catch:{ Throwable -> 0x0652 }
            com.loc.SpUtil.m3486a((android.content.Context) r1, (java.lang.String) r0, (java.lang.String) r3, (long) r4)     // Catch:{ Throwable -> 0x0652 }
        L_0x0652:
            if (r1 == 0) goto L_0x0694
            if (r2 != 0) goto L_0x0657
            goto L_0x0694
        L_0x0657:
            java.lang.String r0 = "15U"
            org.json.JSONObject r0 = r2.optJSONObject(r0)     // Catch:{ Throwable -> 0x0694 }
            if (r0 == 0) goto L_0x0694
            java.lang.String r2 = "able"
            java.lang.String r2 = r0.optString(r2)     // Catch:{ Throwable -> 0x0694 }
            boolean r3 = f2945ah     // Catch:{ Throwable -> 0x0694 }
            boolean r2 = com.loc.AuthConfigManager.m3675a((java.lang.String) r2, (boolean) r3)     // Catch:{ Throwable -> 0x0694 }
            java.lang.String r3 = "yn"
            int r4 = f2946ai     // Catch:{ Throwable -> 0x0694 }
            int r3 = r0.optInt(r3, r4)     // Catch:{ Throwable -> 0x0694 }
            java.lang.String r4 = "sysTime"
            long r5 = f2947aj     // Catch:{ Throwable -> 0x0694 }
            long r4 = r0.optLong(r4, r5)     // Catch:{ Throwable -> 0x0694 }
            f2947aj = r4     // Catch:{ Throwable -> 0x0694 }
            java.lang.String r0 = "pref"
            java.lang.String r4 = "15ua"
            com.loc.SpUtil.m3488a((android.content.Context) r1, (java.lang.String) r0, (java.lang.String) r4, (boolean) r2)     // Catch:{ Throwable -> 0x0694 }
            java.lang.String r0 = "pref"
            java.lang.String r2 = "15un"
            com.loc.SpUtil.m3485a((android.content.Context) r1, (java.lang.String) r0, (java.lang.String) r2, (int) r3)     // Catch:{ Throwable -> 0x0694 }
            java.lang.String r0 = "pref"
            java.lang.String r2 = "15ust"
            long r3 = f2947aj     // Catch:{ Throwable -> 0x0694 }
            com.loc.SpUtil.m3486a((android.content.Context) r1, (java.lang.String) r0, (java.lang.String) r2, (long) r3)     // Catch:{ Throwable -> 0x0694 }
        L_0x0694:
            r1 = 1
            return r1
        L_0x0696:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.AuthUtil.m3347a(android.content.Context, com.loc.cz$a):boolean");
    }

    /* renamed from: b */
    public static int m3348b() {
        return f2963q;
    }

    /* renamed from: b */
    public static boolean m3349b(long j) {
        if (!f2924N) {
            return false;
        }
        return f2925O < 0 || C1079cp.m3518b() - j < f2925O;
    }

    /* renamed from: b */
    public static boolean m3350b(Context context) {
        if (!f2911A) {
            return false;
        }
        if (f2912B == -1 || f2913C == 0) {
            return true;
        }
        if (!C1079cp.m3523b(f2913C, SpUtil.m3491b(context, "pref", "nowtime", 0))) {
            m3362h(context);
            SpUtil.m3485a(context, "pref", "count", 1);
            return true;
        }
        int b = SpUtil.m3490b(context, "pref", "count", 0);
        if (b >= f2912B) {
            return false;
        }
        SpUtil.m3485a(context, "pref", "count", b + 1);
        return true;
    }

    /* renamed from: c */
    public static boolean m3351c() {
        return f2964r;
    }

    /* renamed from: c */
    public static boolean m3352c(Context context) {
        if (!f2915E) {
            return false;
        }
        if (f2916F == -1 || f2917G == 0) {
            return true;
        }
        if (!C1079cp.m3523b(f2917G, SpUtil.m3491b(context, "pref", "pushSerTime", 0))) {
            m3363i(context);
            SpUtil.m3485a(context, "pref", "pushCount", 1);
            return true;
        }
        int b = SpUtil.m3490b(context, "pref", "pushCount", 0);
        if (b >= f2916F) {
            return false;
        }
        SpUtil.m3485a(context, "pref", "pushCount", b + 1);
        return true;
    }

    /* renamed from: d */
    public static int m3353d() {
        return f2965s;
    }

    /* renamed from: d */
    public static void m3354d(Context context) {
        try {
            f2967u = SpUtil.m3493b(context, "pref", "exception", f2967u);
            m3355e(context);
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "AuthUtil", "loadLastAbleState p1");
        }
        try {
            f2968v = SpUtil.m3490b(context, "pref", "fn", f2968v);
            f2969w = SpUtil.m3490b(context, "pref", "mpn", f2969w);
            f2970x = SpUtil.m3493b(context, "pref", "igu", f2970x);
            f2971y = SpUtil.m3490b(context, "pref", Parameters.MESSAGE_SEQ, f2971y);
            OfflineLocManager.m3058a(f2968v, f2970x, f2971y);
        } catch (Throwable unused) {
        }
        try {
            f2924N = SpUtil.m3493b(context, "pref", Parameters.CARRIER, f2924N);
            f2925O = SpUtil.m3491b(context, "pref", "ct", f2925O);
        } catch (Throwable unused2) {
        }
        try {
            f2954h = SpUtil.m3493b(context, "pref", "fr", f2954h);
        } catch (Throwable unused3) {
        }
        try {
            f2939ab = SpUtil.m3493b(context, "pref", "ok0", f2939ab);
            f2955i = SpUtil.m3493b(context, "pref", "ok1", f2955i);
            f2940ac = SpUtil.m3493b(context, "pref", "ok2", f2940ac);
            f2941ad = SpUtil.m3493b(context, "pref", "ok3", f2941ad);
        } catch (Throwable unused4) {
        }
        try {
            f2943af = SpUtil.m3493b(context, "pref", "asw", f2943af);
        } catch (Throwable unused5) {
        }
        try {
            f2944ag = SpUtil.m3491b(context, "pref", "awsi", f2944ag);
        } catch (Throwable unused6) {
        }
        try {
            f2945ah = SpUtil.m3493b(context, "pref", "15ua", f2945ah);
            f2946ai = SpUtil.m3490b(context, "pref", "15un", f2946ai);
            f2947aj = SpUtil.m3491b(context, "pref", "15ust", f2947aj);
        } catch (Throwable unused7) {
        }
    }

    /* renamed from: e */
    public static void m3355e(Context context) {
        try {
            SDKInfo b = CoreUtil.m3392b();
            b.mo13273a(f2967u);
            SDKLogHandler.m3862a(context, b);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: e */
    public static boolean m3356e() {
        return f2966t;
    }

    /* renamed from: f */
    public static boolean m3357f() {
        return f2948b;
    }

    /* renamed from: f */
    public static boolean m3358f(Context context) {
        boolean z = f2930T != -1 && f2930T < f2931U;
        if (!(!f2928R || f2930T == 0 || f2931U == 0 || f2929S == 0 || z)) {
            if (f2932V != null && f2932V.size() > 0) {
                for (String b : f2932V) {
                    if (C1079cp.m3524b(context, b)) {
                        return false;
                    }
                }
            }
            if (f2930T == -1 && f2931U == -1) {
                return true;
            }
            long b2 = SpUtil.m3491b(context, "pref", "ots", 0);
            long b3 = SpUtil.m3491b(context, "pref", "otsh", 0);
            int b4 = SpUtil.m3490b(context, "pref", "otn", 0);
            int b5 = SpUtil.m3490b(context, "pref", "otnh", 0);
            if (f2930T != -1) {
                if (!C1079cp.m3523b(f2929S, b2)) {
                    try {
                        SharedPreferences.Editor edit = context.getSharedPreferences("pref", 0).edit();
                        edit.putLong("ots", f2929S);
                        edit.putLong("otsh", f2929S);
                        edit.putInt("otn", 0);
                        edit.putInt("otnh", 0);
                        SpUtil.m3489a(edit);
                    } catch (Throwable th) {
                        CoreUtil.m3389a(th, "AuthUtil", "resetPrefsBind");
                    }
                    SpUtil.m3485a(context, "pref", "otn", 1);
                    SpUtil.m3485a(context, "pref", "otnh", 1);
                    return true;
                } else if (b4 < f2930T) {
                    if (f2931U == -1) {
                        SpUtil.m3485a(context, "pref", "otn", b4 + 1);
                        SpUtil.m3485a(context, "pref", "otnh", 0);
                        return true;
                    } else if (!C1079cp.m3504a(f2929S, b3)) {
                        SpUtil.m3486a(context, "pref", "otsh", f2929S);
                        SpUtil.m3485a(context, "pref", "otn", b4 + 1);
                        SpUtil.m3485a(context, "pref", "otnh", 1);
                        return true;
                    } else if (b5 < f2931U) {
                        SpUtil.m3485a(context, "pref", "otn", b4 + 1);
                        SpUtil.m3485a(context, "pref", "otnh", b5 + 1);
                        return true;
                    }
                }
            }
            if (f2930T == -1) {
                SpUtil.m3485a(context, "pref", "otn", 0);
                if (f2931U == -1) {
                    SpUtil.m3485a(context, "pref", "otnh", 0);
                    return true;
                } else if (!C1079cp.m3504a(f2929S, b3)) {
                    SpUtil.m3486a(context, "pref", "otsh", f2929S);
                    SpUtil.m3485a(context, "pref", "otnh", 1);
                    return true;
                } else if (b5 < f2931U) {
                    SpUtil.m3485a(context, "pref", "otnh", b5 + 1);
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: g */
    public static ArrayList<String> m3359g() {
        return f2914D;
    }

    /* renamed from: g */
    public static boolean m3360g(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if (C1079cp.m3529c() - f2952f >= ((long) f2950d)) {
                f2953g = true;
                return true;
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "Aps", "isConfigNeedUpdate");
        }
        return false;
    }

    /* renamed from: h */
    public static ArrayList<String> m3361h() {
        return f2918H;
    }

    /* renamed from: h */
    private static void m3362h(Context context) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("pref", 0).edit();
            edit.putLong("nowtime", f2913C);
            edit.putInt("count", 0);
            SpUtil.m3489a(edit);
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "AuthUtil", "resetPrefsBind");
        }
    }

    /* renamed from: i */
    private static void m3363i(Context context) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("pref", 0).edit();
            edit.putLong("pushSerTime", f2917G);
            edit.putInt("pushCount", 0);
            SpUtil.m3489a(edit);
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "AuthUtil", "resetPrefsBind");
        }
    }

    /* renamed from: i */
    public static boolean m3364i() {
        return f2967u;
    }

    /* renamed from: j */
    public static int m3365j() {
        return f2969w;
    }

    /* renamed from: k */
    public static boolean m3366k() {
        return f2972z;
    }

    /* renamed from: l */
    public static void m3367l() {
        f2972z = false;
    }

    /* renamed from: m */
    public static boolean m3368m() {
        return f2921K;
    }

    /* renamed from: n */
    public static long m3369n() {
        return f2925O;
    }

    /* renamed from: o */
    public static boolean m3370o() {
        return f2924N;
    }

    /* renamed from: p */
    public static boolean m3371p() {
        return f2926P;
    }

    /* renamed from: q */
    public static List<OtherServiceEntity> m3372q() {
        return f2927Q;
    }

    /* renamed from: r */
    public static boolean m3373r() {
        return f2933W;
    }

    /* renamed from: s */
    public static int m3374s() {
        return f2934X;
    }

    /* renamed from: t */
    public static boolean m3375t() {
        return f2936Z;
    }

    /* renamed from: u */
    public static boolean m3376u() {
        return f2938aa;
    }

    /* renamed from: v */
    public static boolean m3377v() {
        if (!f2953g) {
            return f2953g;
        }
        f2953g = false;
        return true;
    }

    /* renamed from: w */
    public static boolean m3378w() {
        return f2954h;
    }

    /* renamed from: x */
    public static boolean m3379x() {
        return f2939ab;
    }

    /* renamed from: y */
    public static boolean m3380y() {
        return f2941ad;
    }

    /* renamed from: z */
    public static boolean m3381z() {
        return f2940ac;
    }
}
