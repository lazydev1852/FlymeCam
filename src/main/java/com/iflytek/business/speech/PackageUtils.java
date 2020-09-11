package com.iflytek.business.speech;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import java.util.HashMap;

/* renamed from: com.iflytek.business.speech.h */
public class PackageUtils {

    /* renamed from: a */
    private static PackageUtils f2475a = null;

    /* renamed from: c */
    private static String f2476c = "5285e404";

    /* renamed from: d */
    private static String f2477d = "";

    /* renamed from: e */
    private static String f2478e = "phone_meizu_No3";

    /* renamed from: b */
    private Context f2479b = null;

    /* renamed from: f */
    private HashMap<String, String> f2480f = new HashMap<>();

    /* renamed from: a */
    public static PackageUtils m2838a(Context context) {
        if (f2475a == null) {
            f2475a = new PackageUtils(context);
        }
        return f2475a;
    }

    public PackageUtils(Context context) {
        this.f2479b = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0042, code lost:
        r5 = r3.authority;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        com.iflytek.business.speech.Logging.m2835b("PackageInfo", "provider found: authority is " + r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005b, code lost:
        r6 = e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0074  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m2839a(android.content.Context r5, java.lang.String r6) {
        /*
            java.lang.String r0 = "PackageInfo"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getProviderAuthority "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            com.iflytek.business.speech.Logging.m2831a((java.lang.String) r0, (java.lang.String) r1)
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            r1 = 0
            if (r0 == 0) goto L_0x001e
            return r1
        L_0x001e:
            android.content.pm.PackageManager r0 = r5.getPackageManager()     // Catch:{ Exception -> 0x0069 }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ Exception -> 0x0069 }
            r2 = 8
            android.content.pm.PackageInfo r5 = r0.getPackageInfo(r5, r2)     // Catch:{ Exception -> 0x0069 }
            android.content.pm.ProviderInfo[] r5 = r5.providers     // Catch:{ Exception -> 0x0069 }
            if (r5 == 0) goto L_0x0060
            int r0 = r5.length     // Catch:{ Exception -> 0x0069 }
            if (r0 != 0) goto L_0x0034
            goto L_0x0060
        L_0x0034:
            int r0 = r5.length     // Catch:{ Exception -> 0x0069 }
            r2 = 0
        L_0x0036:
            if (r2 >= r0) goto L_0x0067
            r3 = r5[r2]     // Catch:{ Exception -> 0x0069 }
            java.lang.String r4 = r3.name     // Catch:{ Exception -> 0x0069 }
            boolean r4 = r6.equals(r4)     // Catch:{ Exception -> 0x0069 }
            if (r4 == 0) goto L_0x005d
            java.lang.String r5 = r3.authority     // Catch:{ Exception -> 0x0069 }
            java.lang.String r6 = "PackageInfo"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005b }
            r0.<init>()     // Catch:{ Exception -> 0x005b }
            java.lang.String r1 = "provider found: authority is "
            r0.append(r1)     // Catch:{ Exception -> 0x005b }
            r0.append(r5)     // Catch:{ Exception -> 0x005b }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x005b }
            com.iflytek.business.speech.Logging.m2835b(r6, r0)     // Catch:{ Exception -> 0x005b }
            goto L_0x0072
        L_0x005b:
            r6 = move-exception
            goto L_0x006b
        L_0x005d:
            int r2 = r2 + 1
            goto L_0x0036
        L_0x0060:
            java.lang.String r5 = "PackageInfo"
            java.lang.String r6 = "providerInfos is empty"
            com.iflytek.business.speech.Logging.m2836c(r5, r6)     // Catch:{ Exception -> 0x0069 }
        L_0x0067:
            r5 = r1
            goto L_0x0072
        L_0x0069:
            r6 = move-exception
            r5 = r1
        L_0x006b:
            java.lang.String r0 = "PackageInfo"
            java.lang.String r1 = "---- getProviderAuthority: "
            com.iflytek.business.speech.Logging.m2832a(r0, r1, r6)
        L_0x0072:
            if (r5 != 0) goto L_0x007b
            java.lang.String r6 = "PackageInfo"
            java.lang.String r0 = "provider not found"
            com.iflytek.business.speech.Logging.m2836c(r6, r0)
        L_0x007b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.business.speech.PackageUtils.m2839a(android.content.Context, java.lang.String):java.lang.String");
    }

    /* renamed from: b */
    public static String m2840b(Context context) {
        try {
            return context.getPackageName();
        } catch (Exception e) {
            Logging.m2837d("PackageInfo", "getPackageName: " + e.toString());
            Logging.m2832a("PackageInfo", "", e);
            return null;
        }
    }

    /* renamed from: a */
    public String mo12912a(String str) {
        if (this.f2480f.containsKey(str)) {
            return this.f2480f.get(str);
        }
        try {
            String packageName = this.f2479b.getPackageName();
            PackageInfo packageInfo = this.f2479b.getPackageManager().getPackageInfo(packageName, 0);
            ApplicationInfo applicationInfo = this.f2479b.getPackageManager().getApplicationInfo(packageName, 0);
            this.f2480f.put("caller.name", applicationInfo.loadLabel(this.f2479b.getPackageManager()).toString());
            this.f2480f.put("caller.pkg", applicationInfo.packageName);
            this.f2480f.put("caller.ver.name", packageInfo.versionName);
            this.f2480f.put("caller.ver.code", String.valueOf(packageInfo.versionCode));
        } catch (Exception e) {
            Logging.m2832a("PackageInfo", "", e);
        }
        return this.f2480f.get(str);
    }

    /* renamed from: a */
    public String mo12911a() {
        return f2476c;
    }

    /* renamed from: b */
    public String mo12913b() {
        return f2477d;
    }

    /* renamed from: c */
    public String mo12914c() {
        return f2478e;
    }
}
