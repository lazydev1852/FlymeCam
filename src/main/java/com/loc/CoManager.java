package com.loc;

import android.content.Context;
import android.net.wifi.ScanResult;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
import com.meizu.cloud.pushsdk.pushtracer.constant.Parameters;
import java.io.File;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.loc.bs */
public final class CoManager {

    /* renamed from: a */
    boolean f2745a = false;

    /* renamed from: b */
    boolean f2746b = false;

    /* renamed from: c */
    private Context f2747c;

    /* renamed from: d */
    private Object f2748d = null;

    /* renamed from: e */
    private int f2749e = -1;

    /* renamed from: f */
    private boolean f2750f = false;

    public CoManager(Context context) {
        this.f2747c = context;
    }

    /* renamed from: a */
    private static String m3169a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sv", "4.7.2");
            jSONObject.put("als", "S128DF1572465B890OE3F7A13167KLEI");
            jSONObject.put(Parameters.PACKAGE_NAME, AppInfo.m3663c(context));
            jSONObject.put("ak", AppInfo.m3666f(context));
            jSONObject.put("ud", DeviceInfo.m3719h(context));
            jSONObject.put(ActVideoSetting.ACT_URL, DeviceInfo.m3708b(context));
            return jSONObject.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static String m3170a(CgiManager brVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (brVar == null) {
                return null;
            }
            Cgi c = brVar.mo13081c();
            Cgi d = brVar.mo13082d();
            if (c != null) {
                jSONObject.put("mainCgi", c.mo13073a());
            }
            if (d != null) {
                jSONObject.put("mainCgi2", d.mo13073a());
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "APSCoManager", "buildCgiJsonStr");
            return null;
        }
    }

    /* renamed from: a */
    private void m3171a(CgiManager brVar, List<ScanResult> list, AMapLocationServer aMapLocationServer, int i) {
        try {
            if (m3175e() && C1079cp.m3509a(aMapLocationServer)) {
                m3176f();
                if (this.f2748d != null) {
                    Object a = m3170a(brVar);
                    Object a2 = m3174a(list);
                    if (i == 1) {
                        Reflect.m3411a(this.f2748d, "trainingFps", new Class[]{String.class, ScanResult[].class}, new Object[]{a, a2});
                    } else if (i == 2) {
                        Reflect.m3411a(this.f2748d, "correctOfflineLocation", new Class[]{String.class, ScanResult[].class, Double.TYPE, Double.TYPE}, new Object[]{a, a2, Double.valueOf(aMapLocationServer.getLatitude()), Double.valueOf(aMapLocationServer.getLongitude())});
                    } else {
                        return;
                    }
                    this.f2746b = true;
                }
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("action-");
            sb.append(1 == i ? "training" : "correct");
            CoreUtil.m3389a(th, "APSCoManager", sb.toString());
        }
    }

    /* renamed from: a */
    private static void m3172a(String str, String str2, String str3) {
        if (!str2.endsWith(File.separator)) {
            str2 = str2 + File.separator;
        }
        C1079cp.m3540e(str2);
        C1079cp.m3522b(str, str2 + str3);
    }

    /* renamed from: a */
    public static boolean m3173a() {
        try {
            Class.forName("com.amap.opensdk.co.CoManager");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: a */
    private static ScanResult[] m3174a(List<ScanResult> list) {
        if (list == null) {
            return null;
        }
        try {
            if (list.size() <= 0) {
                return null;
            }
            ScanResult[] scanResultArr = new ScanResult[list.size()];
            for (int i = 0; i < list.size(); i++) {
                scanResultArr[i] = list.get(i);
            }
            return scanResultArr;
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "APSCoManager", "buildScanResults");
            return null;
        }
    }

    /* renamed from: e */
    private boolean m3175e() {
        if (!AuthUtil.m3379x()) {
            mo13103d();
            return false;
        } else if (AuthUtil.m3380y()) {
            return true;
        } else {
            if (this.f2746b) {
                try {
                    if (this.f2748d != null) {
                        Reflect.m3412a(this.f2748d, "destroyOfflineLoc", new Object[0]);
                    }
                } catch (Throwable th) {
                    CoreUtil.m3389a(th, "APSCoManager", "destroyOffline");
                }
                this.f2746b = false;
            }
            return false;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:21|(3:22|23|(2:27|(8:29|30|(1:32)(4:33|(1:36)|37|(1:39)(4:40|(1:42)|43|(1:45)))|46|47|48|49|(1:53))))|54|55) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:29|30|(1:32)(4:33|(1:36)|37|(1:39)(4:40|(1:42)|43|(1:45)))|46|47|48|49|(1:53)) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0081, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        com.loc.CoreUtil.m3389a(r1, "APSCoManager", "initForJar");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0199, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01b7, code lost:
        r14.f2750f = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01b9, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01e2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01e3, code lost:
        com.loc.CoreUtil.m3389a(r0, "APSCoManager", "init");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01ea, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:15:0x0061, B:54:0x0196, B:59:0x01a0] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x017e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x0196 */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3176f() {
        /*
            r14 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r2 = "CoManager ==> init "
            r3 = 0
            r1[r3] = r2
            com.loc.C1079cp.m3503a()
            java.lang.Object r1 = r14.f2748d     // Catch:{ Throwable -> 0x01e2 }
            if (r1 != 0) goto L_0x01ba
            android.content.Context r1 = r14.f2747c     // Catch:{ Throwable -> 0x01e2 }
            java.lang.String r2 = "pref"
            java.lang.String r4 = "ok5"
            int r1 = com.loc.SpUtil.m3490b((android.content.Context) r1, (java.lang.String) r2, (java.lang.String) r4, (int) r3)     // Catch:{ Throwable -> 0x01e2 }
            android.content.Context r2 = r14.f2747c     // Catch:{ Throwable -> 0x01e2 }
            java.lang.String r4 = "pref"
            java.lang.String r5 = "ok7"
            r6 = 0
            long r4 = com.loc.SpUtil.m3491b((android.content.Context) r2, (java.lang.String) r4, (java.lang.String) r5, (long) r6)     // Catch:{ Throwable -> 0x01e2 }
            if (r1 == 0) goto L_0x0039
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x0039
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x01e2 }
            r2 = 0
            long r8 = r8 - r4
            r4 = 259200000(0xf731400, double:1.280618154E-315)
            int r2 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x0039
            return
        L_0x0039:
            android.content.Context r2 = r14.f2747c     // Catch:{ Throwable -> 0x01e2 }
            java.lang.String r4 = "pref"
            java.lang.String r5 = "ok5"
            int r1 = r1 + r0
            com.loc.SpUtil.m3485a((android.content.Context) r2, (java.lang.String) r4, (java.lang.String) r5, (int) r1)     // Catch:{ Throwable -> 0x01e2 }
            android.content.Context r1 = r14.f2747c     // Catch:{ Throwable -> 0x01e2 }
            java.lang.String r2 = "pref"
            java.lang.String r4 = "ok7"
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x01e2 }
            com.loc.SpUtil.m3486a((android.content.Context) r1, (java.lang.String) r2, (java.lang.String) r4, (long) r8)     // Catch:{ Throwable -> 0x01e2 }
            boolean r1 = m3173a()     // Catch:{ Throwable -> 0x01e2 }
            if (r1 == 0) goto L_0x008b
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ Throwable -> 0x01e2 }
            java.lang.String r2 = "CoManager ==> initForJar "
            r1[r3] = r2     // Catch:{ Throwable -> 0x01e2 }
            com.loc.C1079cp.m3503a()     // Catch:{ Throwable -> 0x01e2 }
            java.lang.String r1 = "com.amap.opensdk.co.CoManager"
            java.lang.Class[] r2 = new java.lang.Class[r0]     // Catch:{ Throwable -> 0x0081 }
            java.lang.Class<android.content.Context> r4 = android.content.Context.class
            r2[r3] = r4     // Catch:{ Throwable -> 0x0081 }
            java.lang.Object[] r4 = new java.lang.Object[r0]     // Catch:{ Throwable -> 0x0081 }
            android.content.Context r5 = r14.f2747c     // Catch:{ Throwable -> 0x0081 }
            r4[r3] = r5     // Catch:{ Throwable -> 0x0081 }
            java.lang.Object r1 = com.loc.Reflect.m3415a((java.lang.String) r1, (java.lang.Class<?>[]) r2, (java.lang.Object[]) r4)     // Catch:{ Throwable -> 0x0081 }
            r14.f2748d = r1     // Catch:{ Throwable -> 0x0081 }
            r14.m3177g()     // Catch:{ Throwable -> 0x0081 }
            java.lang.Object r1 = r14.f2748d     // Catch:{ Throwable -> 0x0081 }
            java.lang.String r2 = "loadLocalSo"
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Throwable -> 0x0081 }
            com.loc.Reflect.m3412a((java.lang.Object) r1, (java.lang.String) r2, (java.lang.Object[]) r4)     // Catch:{ Throwable -> 0x0081 }
            goto L_0x01a4
        L_0x0081:
            r1 = move-exception
            java.lang.String r2 = "APSCoManager"
            java.lang.String r4 = "initForJar"
            com.loc.CoreUtil.m3389a(r1, r2, r4)     // Catch:{ Throwable -> 0x01e2 }
            goto L_0x01a4
        L_0x008b:
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ Throwable -> 0x01e2 }
            java.lang.String r2 = "CoManager ==> initForDex"
            r1[r3] = r2     // Catch:{ Throwable -> 0x01e2 }
            com.loc.C1079cp.m3503a()     // Catch:{ Throwable -> 0x01e2 }
            boolean r1 = r14.f2750f     // Catch:{ Throwable -> 0x019b }
            if (r1 != 0) goto L_0x0196
            boolean r1 = com.loc.AuthUtil.m3335B()     // Catch:{ Throwable -> 0x019b }
            if (r1 == 0) goto L_0x0196
            java.lang.String r1 = "co"
            java.lang.String r2 = "1.0.0"
            com.loc.di r9 = com.loc.CoreUtil.m3385a((java.lang.String) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x019b }
            android.content.Context r1 = r14.f2747c     // Catch:{ Throwable -> 0x019b }
            boolean r1 = com.loc.ReportUtil.m3439a((android.content.Context) r1, (com.loc.SDKInfo) r9)     // Catch:{ Throwable -> 0x019b }
            r14.f2750f = r1     // Catch:{ Throwable -> 0x019b }
            boolean r1 = r14.f2750f     // Catch:{ Throwable -> 0x019b }
            if (r1 == 0) goto L_0x0196
            android.content.Context r1 = r14.f2747c     // Catch:{ Throwable -> 0x0196 }
            java.lang.String r1 = com.loc.InstanceFactory.m3969a((android.content.Context) r1, (com.loc.SDKInfo) r9)     // Catch:{ Throwable -> 0x0196 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Throwable -> 0x0196 }
            r4 = 0
            if (r2 == 0) goto L_0x00c1
            goto L_0x0167
        L_0x00c1:
            java.lang.StringBuffer r2 = new java.lang.StringBuffer     // Catch:{ Throwable -> 0x0196 }
            r2.<init>()     // Catch:{ Throwable -> 0x0196 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0196 }
            r5.<init>()     // Catch:{ Throwable -> 0x0196 }
            android.content.Context r8 = r14.f2747c     // Catch:{ Throwable -> 0x0196 }
            android.content.Context r8 = r8.getApplicationContext()     // Catch:{ Throwable -> 0x0196 }
            java.io.File r8 = r8.getFilesDir()     // Catch:{ Throwable -> 0x0196 }
            java.lang.String r8 = r8.getAbsolutePath()     // Catch:{ Throwable -> 0x0196 }
            r5.append(r8)     // Catch:{ Throwable -> 0x0196 }
            java.lang.String r8 = java.io.File.separator     // Catch:{ Throwable -> 0x0196 }
            r5.append(r8)     // Catch:{ Throwable -> 0x0196 }
            java.lang.String r8 = "loc_cozip"
            r5.append(r8)     // Catch:{ Throwable -> 0x0196 }
            java.lang.String r5 = r5.toString()     // Catch:{ Throwable -> 0x0196 }
            java.lang.String r8 = java.io.File.separator     // Catch:{ Throwable -> 0x0196 }
            int r8 = r1.lastIndexOf(r8)     // Catch:{ Throwable -> 0x0196 }
            int r8 = r8 + r0
            java.lang.String r10 = "."
            int r10 = r1.lastIndexOf(r10)     // Catch:{ Throwable -> 0x0196 }
            java.lang.String r8 = r1.substring(r8, r10)     // Catch:{ Throwable -> 0x0196 }
            boolean r10 = com.loc.C1079cp.m3533c((java.lang.String) r5, (java.lang.String) r8)     // Catch:{ Throwable -> 0x0196 }
            android.content.Context r11 = r14.f2747c     // Catch:{ Throwable -> 0x0196 }
            java.lang.String r12 = "pref"
            java.lang.String r13 = "ok4"
            boolean r11 = com.loc.SpUtil.m3493b((android.content.Context) r11, (java.lang.String) r12, (java.lang.String) r13, (boolean) r3)     // Catch:{ Throwable -> 0x0196 }
            if (r10 == 0) goto L_0x010d
            if (r11 == 0) goto L_0x0119
        L_0x010d:
            android.content.Context r10 = r14.f2747c     // Catch:{ Throwable -> 0x0196 }
            java.lang.String r11 = "pref"
            java.lang.String r12 = "ok4"
            com.loc.SpUtil.m3488a((android.content.Context) r10, (java.lang.String) r11, (java.lang.String) r12, (boolean) r3)     // Catch:{ Throwable -> 0x0196 }
            m3172a((java.lang.String) r1, (java.lang.String) r5, (java.lang.String) r8)     // Catch:{ Throwable -> 0x0196 }
        L_0x0119:
            android.content.Context r10 = r14.f2747c     // Catch:{ Throwable -> 0x0196 }
            java.lang.String r10 = com.loc.C1107dj.m3807a((android.content.Context) r10)     // Catch:{ Throwable -> 0x0196 }
            boolean r11 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Throwable -> 0x0196 }
            if (r11 == 0) goto L_0x0126
            goto L_0x0167
        L_0x0126:
            r2.append(r5)     // Catch:{ Throwable -> 0x0196 }
            java.lang.String r11 = java.io.File.separator     // Catch:{ Throwable -> 0x0196 }
            r2.append(r11)     // Catch:{ Throwable -> 0x0196 }
            r2.append(r8)     // Catch:{ Throwable -> 0x0196 }
            java.lang.String r11 = java.io.File.separator     // Catch:{ Throwable -> 0x0196 }
            r2.append(r11)     // Catch:{ Throwable -> 0x0196 }
            java.lang.String r11 = "libs"
            r2.append(r11)     // Catch:{ Throwable -> 0x0196 }
            java.lang.String r11 = java.io.File.separator     // Catch:{ Throwable -> 0x0196 }
            r2.append(r11)     // Catch:{ Throwable -> 0x0196 }
            r2.append(r10)     // Catch:{ Throwable -> 0x0196 }
            java.lang.String r10 = java.io.File.separator     // Catch:{ Throwable -> 0x0196 }
            r2.append(r10)     // Catch:{ Throwable -> 0x0196 }
            java.lang.String r10 = "libapssdk.so"
            r2.append(r10)     // Catch:{ Throwable -> 0x0196 }
            java.lang.String r2 = r2.toString()     // Catch:{ Throwable -> 0x0196 }
            java.io.File r10 = new java.io.File     // Catch:{ Throwable -> 0x0196 }
            r10.<init>(r2)     // Catch:{ Throwable -> 0x0196 }
            boolean r11 = r10.exists()     // Catch:{ Throwable -> 0x0196 }
            if (r11 != 0) goto L_0x015f
            m3172a((java.lang.String) r1, (java.lang.String) r5, (java.lang.String) r8)     // Catch:{ Throwable -> 0x0196 }
        L_0x015f:
            boolean r1 = r10.exists()     // Catch:{ Throwable -> 0x0196 }
            if (r1 != 0) goto L_0x0166
            goto L_0x0167
        L_0x0166:
            r4 = r2
        L_0x0167:
            android.content.Context r8 = r14.f2747c     // Catch:{ Throwable -> 0x017e }
            java.lang.String r10 = "com.amap.opensdk.co.CoManager"
            r11 = 0
            java.lang.Class[] r12 = new java.lang.Class[r0]     // Catch:{ Throwable -> 0x017e }
            java.lang.Class<android.content.Context> r1 = android.content.Context.class
            r12[r3] = r1     // Catch:{ Throwable -> 0x017e }
            java.lang.Object[] r13 = new java.lang.Object[r0]     // Catch:{ Throwable -> 0x017e }
            android.content.Context r1 = r14.f2747c     // Catch:{ Throwable -> 0x017e }
            r13[r3] = r1     // Catch:{ Throwable -> 0x017e }
            java.lang.Object r1 = com.loc.InstanceFactory.m3966a(r8, r9, r10, r11, r12, r13)     // Catch:{ Throwable -> 0x017e }
            r14.f2748d = r1     // Catch:{ Throwable -> 0x017e }
        L_0x017e:
            r14.m3177g()     // Catch:{ Throwable -> 0x0196 }
            java.lang.Object r1 = r14.f2748d     // Catch:{ Throwable -> 0x0196 }
            if (r1 == 0) goto L_0x0196
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Throwable -> 0x0196 }
            if (r1 != 0) goto L_0x0196
            java.lang.Object r1 = r14.f2748d     // Catch:{ Throwable -> 0x0196 }
            java.lang.String r2 = "loadSo"
            java.lang.Object[] r5 = new java.lang.Object[r0]     // Catch:{ Throwable -> 0x0196 }
            r5[r3] = r4     // Catch:{ Throwable -> 0x0196 }
            com.loc.Reflect.m3412a((java.lang.Object) r1, (java.lang.String) r2, (java.lang.Object[]) r5)     // Catch:{ Throwable -> 0x0196 }
        L_0x0196:
            r14.f2750f = r0     // Catch:{ Throwable -> 0x01e2 }
            goto L_0x01a4
        L_0x0199:
            r1 = move-exception
            goto L_0x01b7
        L_0x019b:
            r1 = move-exception
            java.lang.String r2 = "APSCoManager"
            java.lang.String r4 = "initForDexQ"
            com.loc.CoreUtil.m3389a(r1, r2, r4)     // Catch:{ all -> 0x0199 }
            goto L_0x0196
        L_0x01a4:
            android.content.Context r1 = r14.f2747c     // Catch:{ Throwable -> 0x01e2 }
            java.lang.String r2 = "pref"
            java.lang.String r4 = "ok5"
            com.loc.SpUtil.m3485a((android.content.Context) r1, (java.lang.String) r2, (java.lang.String) r4, (int) r3)     // Catch:{ Throwable -> 0x01e2 }
            android.content.Context r1 = r14.f2747c     // Catch:{ Throwable -> 0x01e2 }
            java.lang.String r2 = "pref"
            java.lang.String r4 = "ok7"
            com.loc.SpUtil.m3486a((android.content.Context) r1, (java.lang.String) r2, (java.lang.String) r4, (long) r6)     // Catch:{ Throwable -> 0x01e2 }
            goto L_0x01ba
        L_0x01b7:
            r14.f2750f = r0     // Catch:{ Throwable -> 0x01e2 }
            throw r1     // Catch:{ Throwable -> 0x01e2 }
        L_0x01ba:
            int r1 = com.loc.AuthUtil.m3334A()     // Catch:{ Throwable -> 0x01d9 }
            int r2 = r14.f2749e     // Catch:{ Throwable -> 0x01d9 }
            if (r2 != r1) goto L_0x01c3
            return
        L_0x01c3:
            r14.f2749e = r1     // Catch:{ Throwable -> 0x01d9 }
            java.lang.Object r2 = r14.f2748d     // Catch:{ Throwable -> 0x01d9 }
            if (r2 == 0) goto L_0x01d8
            java.lang.Object r2 = r14.f2748d     // Catch:{ Throwable -> 0x01d9 }
            java.lang.String r4 = "setCloudConfigVersion"
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ Throwable -> 0x01d9 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Throwable -> 0x01d9 }
            r0[r3] = r1     // Catch:{ Throwable -> 0x01d9 }
            com.loc.Reflect.m3412a((java.lang.Object) r2, (java.lang.String) r4, (java.lang.Object[]) r0)     // Catch:{ Throwable -> 0x01d9 }
        L_0x01d8:
            return
        L_0x01d9:
            r0 = move-exception
            java.lang.String r1 = "APSCoManager"
            java.lang.String r2 = "setCloudVersion"
            com.loc.CoreUtil.m3389a(r0, r1, r2)     // Catch:{ Throwable -> 0x01e2 }
            return
        L_0x01e2:
            r0 = move-exception
            java.lang.String r1 = "APSCoManager"
            java.lang.String r2 = "init"
            com.loc.CoreUtil.m3389a(r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.CoManager.m3176f():void");
    }

    /* renamed from: g */
    private void m3177g() {
        try {
            if (this.f2747c != null) {
                String a = m3169a(this.f2747c);
                if (this.f2748d != null) {
                    Reflect.m3412a(this.f2748d, "init", a);
                }
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "APSCoManager", "setConfig");
        }
    }

    /* renamed from: a */
    public final AMapLocationServer mo13098a(CgiManager brVar, List<ScanResult> list, AMapLocationServer aMapLocationServer) {
        String D;
        try {
            if (!m3175e()) {
                return aMapLocationServer;
            }
            if (aMapLocationServer != null && aMapLocationServer.mo8484c() == 7) {
                return aMapLocationServer;
            }
            m3176f();
            if (this.f2748d != null) {
                this.f2746b = true;
                Object a = m3170a(brVar);
                Object a2 = m3174a(list);
                Object a3 = Reflect.m3411a(this.f2748d, "getOfflineLoc", new Class[]{String.class, ScanResult[].class, Boolean.TYPE}, new Object[]{a, a2, false});
                if (a3 != null) {
                    JSONObject jSONObject = new JSONObject((String) a3);
                    AMapLocationServer aMapLocationServer2 = new AMapLocationServer("lbs");
                    aMapLocationServer2.mo8807b(jSONObject);
                    if (C1079cp.m3509a(aMapLocationServer2)) {
                        StringBuffer stringBuffer = new StringBuffer();
                        if (aMapLocationServer2.mo8797D().equals("file")) {
                            D = "基站离线定位";
                        } else if (aMapLocationServer2.mo8797D().equals("wifioff")) {
                            D = "WIFI离线定位";
                        } else {
                            stringBuffer.append("离线定位，");
                            D = aMapLocationServer2.mo8797D();
                        }
                        stringBuffer.append(D);
                        if (aMapLocationServer != null) {
                            stringBuffer.append("，在线定位失败原因:" + aMapLocationServer.mo8489d());
                        }
                        aMapLocationServer2.mo8500g(2);
                        aMapLocationServer2.mo8478a(stringBuffer.toString());
                        aMapLocationServer2.mo8481b(8);
                    }
                    return aMapLocationServer2;
                }
            }
            return aMapLocationServer;
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "APSCoManager", "getOffLoc");
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo13099b() {
        /*
            r4 = this;
            boolean r0 = com.loc.AuthUtil.m3379x()     // Catch:{ Throwable -> 0x0047 }
            if (r0 != 0) goto L_0x000a
            r4.mo13103d()     // Catch:{ Throwable -> 0x0047 }
            return
        L_0x000a:
            boolean r0 = com.loc.AuthUtil.m3381z()     // Catch:{ Throwable -> 0x0047 }
            r1 = 0
            if (r0 != 0) goto L_0x002e
            boolean r0 = r4.f2745a     // Catch:{ Throwable -> 0x0047 }
            if (r0 == 0) goto L_0x002d
            java.lang.Object r0 = r4.f2748d     // Catch:{ Throwable -> 0x0023 }
            if (r0 == 0) goto L_0x002b
            java.lang.Object r0 = r4.f2748d     // Catch:{ Throwable -> 0x0023 }
            java.lang.String r2 = "destroyCollect"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ Throwable -> 0x0023 }
            com.loc.Reflect.m3412a((java.lang.Object) r0, (java.lang.String) r2, (java.lang.Object[]) r3)     // Catch:{ Throwable -> 0x0023 }
            goto L_0x002b
        L_0x0023:
            r0 = move-exception
            java.lang.String r2 = "APSCoManager"
            java.lang.String r3 = "destroyCollection"
            com.loc.CoreUtil.m3389a(r0, r2, r3)     // Catch:{ Throwable -> 0x0047 }
        L_0x002b:
            r4.f2745a = r1     // Catch:{ Throwable -> 0x0047 }
        L_0x002d:
            return
        L_0x002e:
            boolean r0 = r4.f2745a     // Catch:{ Throwable -> 0x0047 }
            if (r0 == 0) goto L_0x0033
            return
        L_0x0033:
            r4.m3176f()     // Catch:{ Throwable -> 0x0047 }
            java.lang.Object r0 = r4.f2748d     // Catch:{ Throwable -> 0x0047 }
            if (r0 == 0) goto L_0x0046
            java.lang.Object r0 = r4.f2748d     // Catch:{ Throwable -> 0x0047 }
            java.lang.String r2 = "startCollect"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Throwable -> 0x0047 }
            com.loc.Reflect.m3412a((java.lang.Object) r0, (java.lang.String) r2, (java.lang.Object[]) r1)     // Catch:{ Throwable -> 0x0047 }
            r0 = 1
            r4.f2745a = r0     // Catch:{ Throwable -> 0x0047 }
        L_0x0046:
            return
        L_0x0047:
            r0 = move-exception
            java.lang.String r1 = "APSCoManager"
            java.lang.String r2 = "startCollection"
            com.loc.CoreUtil.m3389a(r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.CoManager.mo13099b():void");
    }

    /* renamed from: b */
    public final void mo13100b(CgiManager brVar, List<ScanResult> list, AMapLocationServer aMapLocationServer) {
        try {
            m3171a(brVar, list, aMapLocationServer, 1);
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "APSCoManager", "trainingFps");
        }
    }

    /* renamed from: c */
    public final String mo13101c() {
        try {
            if (!AuthUtil.m3379x()) {
                mo13103d();
                return null;
            } else if (this.f2748d != null) {
                return (String) Reflect.m3412a(this.f2748d, "getCollectVersion", new Object[0]);
            } else {
                return null;
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "APSCoManager", "getCollectionVersion");
            return null;
        }
    }

    /* renamed from: c */
    public final void mo13102c(CgiManager brVar, List<ScanResult> list, AMapLocationServer aMapLocationServer) {
        try {
            m3171a(brVar, list, aMapLocationServer, 2);
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "APSCoManager", "correctOffLoc");
        }
    }

    /* renamed from: d */
    public final void mo13103d() {
        try {
            if (this.f2748d != null) {
                Reflect.m3412a(this.f2748d, "destroy", new Object[0]);
            }
            this.f2745a = false;
            this.f2746b = false;
            this.f2748d = null;
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "APSCoManager", "destroy");
        }
    }
}
