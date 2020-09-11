package com.loc;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.baidu.p020ar.util.MsgConstants;
import java.util.ArrayList;

@SuppressLint({"NewApi"})
/* renamed from: com.loc.cm */
public final class Aps {

    /* renamed from: D */
    static int f3015D = -1;

    /* renamed from: H */
    public static boolean f3016H = true;

    /* renamed from: M */
    private static boolean f3017M = false;

    /* renamed from: O */
    private static int f3018O = -1;

    /* renamed from: A */
    int f3019A = 12;

    /* renamed from: B */
    AmapSensorManager f3020B = null;

    /* renamed from: C */
    boolean f3021C = false;

    /* renamed from: E */
    LocFilter f3022E = null;

    /* renamed from: F */
    String f3023F = null;

    /* renamed from: G */
    CoManager f3024G = null;

    /* renamed from: I */
    IntentFilter f3025I = null;

    /* renamed from: J */
    LocationManager f3026J = null;

    /* renamed from: K */
    private int f3027K = 0;

    /* renamed from: L */
    private String f3028L = null;

    /* renamed from: N */
    private String f3029N = null;

    /* renamed from: P */
    private boolean f3030P = true;

    /* renamed from: a */
    Context f3031a = null;

    /* renamed from: b */
    ConnectivityManager f3032b = null;

    /* renamed from: c */
    WifiManagerWrapper f3033c = null;

    /* renamed from: d */
    CgiManager f3034d = null;

    /* renamed from: e */
    C1066bv f3035e = null;

    /* renamed from: f */
    ConnectionServiceManager f3036f = null;

    /* renamed from: g */
    Parser f3037g = null;

    /* renamed from: h */
    ArrayList<ScanResult> f3038h = new ArrayList<>();

    /* renamed from: i */
    C1077a f3039i = null;

    /* renamed from: j */
    AMapLocationClientOption f3040j = new AMapLocationClientOption();

    /* renamed from: k */
    AMapLocationServer f3041k = null;

    /* renamed from: l */
    long f3042l = 0;

    /* renamed from: m */
    Req f3043m = null;

    /* renamed from: n */
    boolean f3044n = false;

    /* renamed from: o */
    LocNetManager f3045o = null;

    /* renamed from: p */
    StringBuilder f3046p = new StringBuilder();

    /* renamed from: q */
    boolean f3047q = true;

    /* renamed from: r */
    boolean f3048r = true;

    /* renamed from: s */
    AMapLocationClientOption.GeoLanguage f3049s = AMapLocationClientOption.GeoLanguage.DEFAULT;

    /* renamed from: t */
    boolean f3050t = true;

    /* renamed from: u */
    boolean f3051u = false;

    /* renamed from: v */
    WifiInfo f3052v = null;

    /* renamed from: w */
    boolean f3053w = true;

    /* renamed from: x */
    StringBuilder f3054x = null;

    /* renamed from: y */
    boolean f3055y = false;

    /* renamed from: z */
    public boolean f3056z = false;

    /* renamed from: com.loc.cm$a */
    /* compiled from: Aps */
    class C1077a extends BroadcastReceiver {
        C1077a() {
        }

        public final void onReceive(Context context, Intent intent) {
            if (context != null && intent != null) {
                try {
                    String action = intent.getAction();
                    if (!TextUtils.isEmpty(action)) {
                        if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                            if (Aps.this.f3033c != null) {
                                Aps.this.f3033c.mo13111e();
                            }
                        } else if (action.equals("android.net.wifi.WIFI_STATE_CHANGED") && Aps.this.f3033c != null) {
                            Aps.this.f3033c.mo13112f();
                        }
                    }
                } catch (Throwable th) {
                    CoreUtil.m3389a(th, "Aps", "onReceive");
                }
            }
        }
    }

    /* renamed from: a */
    private static AMapLocationServer m3450a(int i, String str) {
        AMapLocationServer aMapLocationServer = new AMapLocationServer("");
        aMapLocationServer.mo8485c(i);
        aMapLocationServer.mo8478a(str);
        if (i == 15) {
            ReportUtil.m3435a((String) null, 2151);
        }
        return aMapLocationServer;
    }

    /* renamed from: a */
    private AMapLocationServer m3451a(AMapLocationServer aMapLocationServer, ResponseEntity anVar) {
        if (anVar != null) {
            try {
                if (anVar.f2587a != null) {
                    if (anVar.f2587a.length != 0) {
                        Parser ccVar = new Parser();
                        String str = new String(anVar.f2587a, "UTF-8");
                        if (str.contains("\"status\":\"0\"")) {
                            AMapLocationServer a = ccVar.mo13164a(str, this.f3031a, anVar);
                            try {
                                a.mo8817z(this.f3054x.toString());
                                return a;
                            } catch (Throwable th) {
                                AMapLocationServer aMapLocationServer2 = a;
                                th = th;
                                aMapLocationServer = aMapLocationServer2;
                                aMapLocationServer.mo8485c(4);
                                CoreUtil.m3389a(th, "Aps", "checkResponseEntity");
                                StringBuilder sb = this.f3046p;
                                sb.append("check response exception ex is" + th.getMessage() + "#0403");
                                aMapLocationServer.mo8478a(this.f3046p.toString());
                                return aMapLocationServer;
                            }
                        } else if (!str.contains("</body></html>")) {
                            return null;
                        } else {
                            aMapLocationServer.mo8485c(5);
                            if (this.f3033c == null || !this.f3033c.mo13106a(this.f3032b)) {
                                this.f3046p.append("请求可能被劫持了#0502");
                                ReportUtil.m3435a((String) null, 2052);
                            } else {
                                this.f3046p.append("您连接的是一个需要登录的网络，请确认已经登入网络#0501");
                                ReportUtil.m3435a((String) null, 2051);
                            }
                            aMapLocationServer.mo8478a(this.f3046p.toString());
                            return aMapLocationServer;
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                aMapLocationServer.mo8485c(4);
                CoreUtil.m3389a(th, "Aps", "checkResponseEntity");
                StringBuilder sb2 = this.f3046p;
                sb2.append("check response exception ex is" + th.getMessage() + "#0403");
                aMapLocationServer.mo8478a(this.f3046p.toString());
                return aMapLocationServer;
            }
        }
        aMapLocationServer.mo8485c(4);
        this.f3046p.append("网络异常,请求异常#0403");
        aMapLocationServer.mo8817z(this.f3054x.toString());
        aMapLocationServer.mo8478a(this.f3046p.toString());
        if (anVar != null) {
            ReportUtil.m3435a(anVar.f2590d, 2041);
        }
        return aMapLocationServer;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private AMapLocationServer m3452a(boolean z, boolean z2) {
        int i;
        StringBuilder sb;
        String str;
        AMapLocationServer aMapLocationServer = new AMapLocationServer("");
        try {
            if (this.f3043m == null) {
                this.f3043m = new Req();
            }
            if (this.f3040j == null) {
                this.f3040j = new AMapLocationClientOption();
            }
            this.f3043m.mo13166a(this.f3031a, this.f3040j.mo8556e(), this.f3040j.mo8566o(), this.f3034d, this.f3033c, this.f3032b, this.f3024G != null ? this.f3024G.mo13101c() : null, this.f3023F);
            byte[] a = this.f3043m.mo13167a();
            this.f3042l = C1079cp.m3529c();
            try {
                CoreUtil.m3395c(this.f3031a);
                LocationRequest a2 = this.f3045o.mo13157a(this.f3031a, a, CoreUtil.m3386a(), z2);
                DnsManager.m3247a(this.f3031a).mo13142a(a2);
                ResponseEntity a3 = this.f3045o.mo13156a(a2);
                DnsManager.m3247a(this.f3031a).mo13141a();
                String str2 = "";
                if (a3 != null) {
                    DnsManager.m3247a(this.f3031a).mo13143b();
                    aMapLocationServer.mo8805a((long) this.f3045o.mo13155a());
                    if (!TextUtils.isEmpty(a3.f2589c)) {
                        StringBuilder sb2 = this.f3046p;
                        sb2.append("#csid:" + a3.f2589c);
                    }
                    str2 = a3.f2590d;
                    aMapLocationServer.mo8817z(this.f3054x.toString());
                }
                if (!z) {
                    AMapLocationServer a4 = m3451a(aMapLocationServer, a3);
                    if (a4 != null) {
                        return a4;
                    }
                    byte[] a5 = Encrypt.m3208a(a3.f2587a);
                    if (a5 == null) {
                        aMapLocationServer.mo8485c(5);
                        this.f3046p.append("解密数据失败#0503");
                        aMapLocationServer.mo8478a(this.f3046p.toString());
                        ReportUtil.m3435a(str2, 2053);
                        return aMapLocationServer;
                    }
                    aMapLocationServer = this.f3037g.mo13162a(aMapLocationServer, a5);
                    if (!C1079cp.m3509a(aMapLocationServer)) {
                        this.f3028L = aMapLocationServer.mo8794A();
                        ReportUtil.m3435a(str2, !TextUtils.isEmpty(this.f3028L) ? 2062 : 2061);
                        aMapLocationServer.mo8485c(6);
                        StringBuilder sb3 = this.f3046p;
                        StringBuilder sb4 = new StringBuilder("location faile retype:");
                        sb4.append(aMapLocationServer.mo8796C());
                        sb4.append(" rdesc:");
                        sb4.append(TextUtils.isEmpty(this.f3028L) ? "" : this.f3028L);
                        sb4.append("#0601");
                        sb3.append(sb4.toString());
                        aMapLocationServer.mo8817z(this.f3054x.toString());
                        aMapLocationServer.mo8478a(this.f3046p.toString());
                        return aMapLocationServer;
                    }
                    if (aMapLocationServer.mo8484c() == 0 && aMapLocationServer.mo8475a() == 0) {
                        if ("-5".equals(aMapLocationServer.mo8796C()) || "1".equals(aMapLocationServer.mo8796C()) || "2".equals(aMapLocationServer.mo8796C()) || "14".equals(aMapLocationServer.mo8796C()) || "24".equals(aMapLocationServer.mo8796C()) || "-1".equals(aMapLocationServer.mo8796C())) {
                            aMapLocationServer.mo8481b(5);
                        } else {
                            aMapLocationServer.mo8481b(6);
                        }
                    }
                    aMapLocationServer.mo8479a(this.f3048r);
                    aMapLocationServer.mo8808d(this.f3047q);
                    aMapLocationServer.mo8814x(String.valueOf(this.f3049s));
                }
                aMapLocationServer.mo8813w("new");
                aMapLocationServer.mo8478a(this.f3046p.toString());
                this.f3023F = aMapLocationServer.mo8816z();
                return aMapLocationServer;
            } catch (Throwable th) {
                DnsManager.m3247a(this.f3031a).mo13145d();
                CoreUtil.m3389a(th, "Aps", "getApsLoc req");
                ReportUtil.m3438a("/mobile/binary", th);
                if (!C1079cp.m3537d(this.f3031a)) {
                    sb = this.f3046p;
                    str = "网络异常，未连接到网络，请连接网络#0401";
                } else {
                    if (th instanceof AMapCoreException) {
                        AMapCoreException cxVar = (AMapCoreException) th;
                        if (cxVar.mo13248a().contains("网络异常状态码")) {
                            StringBuilder sb5 = this.f3046p;
                            sb5.append("网络异常，状态码错误#0404");
                            sb5.append(cxVar.mo13253e());
                            i = 4;
                            AMapLocationServer a6 = m3450a(i, this.f3046p.toString());
                            a6.mo8817z(this.f3054x.toString());
                            return a6;
                        } else if (cxVar.mo13253e() == 23 || Math.abs((C1079cp.m3529c() - this.f3042l) - this.f3040j.mo8565n()) < 500) {
                            sb = this.f3046p;
                            str = "网络异常，连接超时#0402";
                        }
                    }
                    sb = this.f3046p;
                    str = "网络异常,请求异常#0403";
                }
                sb.append(str);
                i = 4;
                AMapLocationServer a62 = m3450a(i, this.f3046p.toString());
                a62.mo8817z(this.f3054x.toString());
                return a62;
            }
        } catch (Throwable th2) {
            StringBuilder sb6 = this.f3046p;
            sb6.append("get parames error:" + th2.getMessage() + "#0301");
            ReportUtil.m3435a((String) null, 2031);
            i = 3;
            AMapLocationServer a622 = m3450a(i, this.f3046p.toString());
            a622.mo8817z(this.f3054x.toString());
            return a622;
        }
    }

    /* renamed from: a */
    private StringBuilder m3453a(StringBuilder sb) {
        if (sb == null) {
            sb = new StringBuilder(MsgConstants.TRACK_CLOSE_CLOUD_RECOGNITION);
        } else {
            sb.delete(0, sb.length());
        }
        sb.append(this.f3034d.mo13090l());
        sb.append(this.f3033c.mo13116j());
        return sb;
    }

    /* renamed from: b */
    public static void m3454b(Context context) {
        try {
            if (f3018O == -1 || AuthUtil.m3360g(context)) {
                f3018O = 1;
                AuthUtil.m3344a(context);
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "Aps", "initAuth");
        }
    }

    /* renamed from: b */
    private void m3455b(AMapLocationServer aMapLocationServer) {
        if (aMapLocationServer != null) {
            this.f3041k = aMapLocationServer;
        }
    }

    /* renamed from: l */
    private void m3456l() {
        if (this.f3045o != null) {
            try {
                if (this.f3040j == null) {
                    this.f3040j = new AMapLocationClientOption();
                }
                int i = 0;
                if (this.f3040j.mo8571t() != null) {
                    switch (this.f3040j.mo8571t()) {
                        case DEFAULT:
                            break;
                        case ZH:
                            i = 1;
                            break;
                        case EN:
                            i = 2;
                            break;
                    }
                }
                this.f3045o.mo13159a(this.f3040j.mo8565n(), this.f3040j.mo8560i().equals(AMapLocationClientOption.AMapLocationProtocol.HTTPS), i);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: m */
    private void m3457m() {
        try {
            if (this.f3039i == null) {
                this.f3039i = new C1077a();
            }
            if (this.f3025I == null) {
                this.f3025I = new IntentFilter();
                this.f3025I.addAction("android.net.wifi.WIFI_STATE_CHANGED");
                this.f3025I.addAction("android.net.wifi.SCAN_RESULTS");
            }
            this.f3031a.registerReceiver(this.f3039i, this.f3025I);
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "Aps", "initBroadcastListener");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:119:0x02e9, code lost:
        if (android.text.TextUtils.isEmpty(r0) != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x02ef, code lost:
        if (r0.startsWith("#") != false) goto L_0x0300;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x02f1, code lost:
        r0 = "#" + r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:?, code lost:
        return com.loc.C1079cp.m3552i() + r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01de, code lost:
        if (r11.f3053w == false) goto L_0x0225;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0222, code lost:
        if (r11.f3053w == false) goto L_0x0225;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0225, code lost:
        r1 = "cgi";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0228, code lost:
        r1 = "cgiwifi";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x022a, code lost:
        r0.append(r1);
        r0 = r0.toString();
     */
    /* renamed from: n */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m3458n() {
        /*
            r11 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "network"
            com.loc.br r2 = r11.f3034d
            int r2 = r2.mo13084f()
            com.loc.br r3 = r11.f3034d
            com.loc.bq r3 = r3.mo13081c()
            java.util.ArrayList<android.net.wifi.ScanResult> r4 = r11.f3038h
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0021
            java.util.ArrayList<android.net.wifi.ScanResult> r4 = r11.f3038h
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            r4 = 0
            goto L_0x0022
        L_0x0021:
            r4 = 1
        L_0x0022:
            r7 = 0
            if (r3 != 0) goto L_0x016c
            if (r4 == 0) goto L_0x016c
            android.net.ConnectivityManager r1 = r11.f3032b
            if (r1 != 0) goto L_0x0037
            android.content.Context r1 = r11.f3031a
            java.lang.String r2 = "connectivity"
            java.lang.Object r1 = com.loc.C1079cp.m3501a((android.content.Context) r1, (java.lang.String) r2)
            android.net.ConnectivityManager r1 = (android.net.ConnectivityManager) r1
            r11.f3032b = r1
        L_0x0037:
            android.content.Context r1 = r11.f3031a
            boolean r1 = com.loc.C1079cp.m3505a((android.content.Context) r1)
            if (r1 == 0) goto L_0x0058
            com.loc.bt r1 = r11.f3033c
            boolean r1 = r1.mo13113g()
            if (r1 != 0) goto L_0x0058
            r1 = 18
            r11.f3019A = r1
            java.lang.StringBuilder r1 = r11.f3046p
            java.lang.String r2 = "飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关#1801"
            r1.append(r2)
            r1 = 2132(0x854, float:2.988E-42)
            com.loc.ReportUtil.m3435a((java.lang.String) r7, (int) r1)
            return r0
        L_0x0058:
            int r1 = com.loc.C1079cp.m3535d()
            r2 = 28
            r3 = 2121(0x849, float:2.972E-42)
            r4 = 12
            if (r1 < r2) goto L_0x0097
            android.location.LocationManager r1 = r11.f3026J
            if (r1 != 0) goto L_0x0078
            android.content.Context r1 = r11.f3031a
            android.content.Context r1 = r1.getApplicationContext()
            java.lang.String r5 = "location"
            java.lang.Object r1 = r1.getSystemService(r5)
            android.location.LocationManager r1 = (android.location.LocationManager) r1
            r11.f3026J = r1
        L_0x0078:
            android.location.LocationManager r1 = r11.f3026J
            java.lang.String r5 = "isLocationEnabled"
            java.lang.Object[] r8 = new java.lang.Object[r6]
            java.lang.Object r1 = com.loc.Reflect.m3412a((java.lang.Object) r1, (java.lang.String) r5, (java.lang.Object[]) r8)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x0097
            r11.f3019A = r4
            java.lang.StringBuilder r1 = r11.f3046p
            java.lang.String r2 = "定位服务没有开启，请在设置中打开定位服务开关#1206"
            r1.append(r2)
            com.loc.ReportUtil.m3435a((java.lang.String) r7, (int) r3)
            return r0
        L_0x0097:
            android.content.Context r1 = r11.f3031a
            boolean r1 = com.loc.C1079cp.m3544f((android.content.Context) r1)
            if (r1 != 0) goto L_0x00ac
            r11.f3019A = r4
            java.lang.StringBuilder r1 = r11.f3046p
            java.lang.String r2 = "定位权限被禁用,请授予应用定位权限#1201"
            r1.append(r2)
            com.loc.ReportUtil.m3435a((java.lang.String) r7, (int) r3)
            return r0
        L_0x00ac:
            int r1 = com.loc.C1079cp.m3535d()
            r5 = 24
            if (r1 < r5) goto L_0x00d5
            int r1 = com.loc.C1079cp.m3535d()
            if (r1 >= r2) goto L_0x00d5
            android.content.Context r1 = r11.f3031a
            android.content.ContentResolver r1 = r1.getContentResolver()
            java.lang.String r2 = "location_mode"
            int r1 = android.provider.Settings.Secure.getInt(r1, r2, r6)
            if (r1 != 0) goto L_0x00d5
            r11.f3019A = r4
            java.lang.StringBuilder r1 = r11.f3046p
            java.lang.String r2 = "定位服务没有开启，请在设置中打开定位服务开关#1206"
            r1.append(r2)
            com.loc.ReportUtil.m3435a((java.lang.String) r7, (int) r3)
            return r0
        L_0x00d5:
            com.loc.br r1 = r11.f3034d
            java.lang.String r1 = r1.mo13088j()
            com.loc.bt r2 = r11.f3033c
            java.lang.String r2 = r2.mo13107b()
            com.loc.bt r5 = r11.f3033c
            android.net.ConnectivityManager r6 = r11.f3032b
            boolean r5 = r5.mo13106a((android.net.ConnectivityManager) r6)
            if (r5 == 0) goto L_0x00fa
            if (r2 == 0) goto L_0x00fa
            r11.f3019A = r4
            java.lang.StringBuilder r1 = r11.f3046p
            java.lang.String r2 = "获取基站与获取WIFI的权限都被禁用，请在安全软件中打开应用的定位权限#1202"
            r1.append(r2)
            com.loc.ReportUtil.m3435a((java.lang.String) r7, (int) r3)
            return r0
        L_0x00fa:
            if (r1 == 0) goto L_0x0117
            r11.f3019A = r4
            com.loc.bt r1 = r11.f3033c
            boolean r1 = r1.mo13113g()
            if (r1 != 0) goto L_0x010e
            java.lang.StringBuilder r1 = r11.f3046p
            java.lang.String r2 = "WIFI开关关闭，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限或者打开WIFI开关#1204"
        L_0x010a:
            r1.append(r2)
            goto L_0x0113
        L_0x010e:
            java.lang.StringBuilder r1 = r11.f3046p
            java.lang.String r2 = "获取的WIFI列表为空，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限#1205"
            goto L_0x010a
        L_0x0113:
            com.loc.ReportUtil.m3435a((java.lang.String) r7, (int) r3)
            return r0
        L_0x0117:
            com.loc.bt r1 = r11.f3033c
            boolean r1 = r1.mo13113g()
            if (r1 != 0) goto L_0x0138
            com.loc.br r1 = r11.f3034d
            boolean r1 = r1.mo13091m()
            if (r1 != 0) goto L_0x0138
            r1 = 19
            r11.f3019A = r1
            java.lang.StringBuilder r1 = r11.f3046p
            java.lang.String r2 = "没有检查到SIM卡，并且WIFI开关关闭，请打开WIFI开关或者插入SIM卡#1901"
            r1.append(r2)
            r1 = 2133(0x855, float:2.989E-42)
            com.loc.ReportUtil.m3435a((java.lang.String) r7, (int) r1)
            return r0
        L_0x0138:
            android.content.Context r1 = r11.f3031a
            boolean r1 = com.loc.C1079cp.m3547g((android.content.Context) r1)
            if (r1 != 0) goto L_0x014d
            r11.f3019A = r4
            java.lang.StringBuilder r1 = r11.f3046p
            java.lang.String r2 = "后台定位服务没有开启，请在设置中打开后台定位服务开关#1207"
            r1.append(r2)
            com.loc.ReportUtil.m3435a((java.lang.String) r7, (int) r3)
            return r0
        L_0x014d:
            com.loc.bt r1 = r11.f3033c
            boolean r1 = r1.mo13113g()
            if (r1 != 0) goto L_0x015d
            java.lang.StringBuilder r1 = r11.f3046p
            java.lang.String r2 = "获取到的基站为空，并且关闭了WIFI开关，请您打开WIFI开关再发起定位#1301"
        L_0x0159:
            r1.append(r2)
            goto L_0x0162
        L_0x015d:
            java.lang.StringBuilder r1 = r11.f3046p
            java.lang.String r2 = "获取到的基站和WIFI信息均为空，请移动到有WIFI的区域，若确定当前区域有WIFI，请检查是否授予APP定位权限#1302"
            goto L_0x0159
        L_0x0162:
            r1 = 13
            r11.f3019A = r1
            r1 = 2131(0x853, float:2.986E-42)
            com.loc.ReportUtil.m3435a((java.lang.String) r7, (int) r1)
            return r0
        L_0x016c:
            com.loc.bt r4 = r11.f3033c
            android.net.wifi.WifiInfo r4 = r4.mo13114h()
            r11.f3052v = r4
            com.loc.bt r4 = r11.f3033c
            android.net.wifi.WifiInfo r4 = r11.f3052v
            boolean r4 = com.loc.WifiManagerWrapper.m3186a((android.net.wifi.WifiInfo) r4)
            r11.f3053w = r4
            switch(r2) {
                case 0: goto L_0x0233;
                case 1: goto L_0x01e1;
                case 2: goto L_0x0193;
                default: goto L_0x0181;
            }
        L_0x0181:
            r1 = 11
            r11.f3019A = r1
            r1 = 2111(0x83f, float:2.958E-42)
            com.loc.ReportUtil.m3435a((java.lang.String) r7, (int) r1)
            java.lang.StringBuilder r1 = r11.f3046p
            java.lang.String r2 = "get cgi failure#1101"
            r1.append(r2)
            goto L_0x02e3
        L_0x0193:
            if (r3 == 0) goto L_0x02e3
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r2 = r3.f2706a
            r0.append(r2)
            java.lang.String r2 = "#"
            r0.append(r2)
            int r2 = r3.f2707b
            r0.append(r2)
            java.lang.String r2 = "#"
            r0.append(r2)
            int r2 = r3.f2712g
            r0.append(r2)
            java.lang.String r2 = "#"
            r0.append(r2)
            int r2 = r3.f2713h
            r0.append(r2)
            java.lang.String r2 = "#"
            r0.append(r2)
            int r2 = r3.f2714i
            r0.append(r2)
            java.lang.String r2 = "#"
            r0.append(r2)
            r0.append(r1)
            java.lang.String r1 = "#"
            r0.append(r1)
            java.util.ArrayList<android.net.wifi.ScanResult> r1 = r11.f3038h
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0228
            boolean r1 = r11.f3053w
            if (r1 == 0) goto L_0x0225
            goto L_0x0228
        L_0x01e1:
            if (r3 == 0) goto L_0x02e3
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r2 = r3.f2706a
            r0.append(r2)
            java.lang.String r2 = "#"
            r0.append(r2)
            int r2 = r3.f2707b
            r0.append(r2)
            java.lang.String r2 = "#"
            r0.append(r2)
            int r2 = r3.f2708c
            r0.append(r2)
            java.lang.String r2 = "#"
            r0.append(r2)
            int r2 = r3.f2709d
            r0.append(r2)
            java.lang.String r2 = "#"
            r0.append(r2)
            r0.append(r1)
            java.lang.String r1 = "#"
            r0.append(r1)
            java.util.ArrayList<android.net.wifi.ScanResult> r1 = r11.f3038h
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0228
            boolean r1 = r11.f3053w
            if (r1 == 0) goto L_0x0225
            goto L_0x0228
        L_0x0225:
            java.lang.String r1 = "cgi"
            goto L_0x022a
        L_0x0228:
            java.lang.String r1 = "cgiwifi"
        L_0x022a:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L_0x02e3
        L_0x0233:
            java.util.ArrayList<android.net.wifi.ScanResult> r2 = r11.f3038h
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0242
            boolean r2 = r11.f3053w
            if (r2 == 0) goto L_0x0240
            goto L_0x0242
        L_0x0240:
            r2 = 0
            goto L_0x0243
        L_0x0242:
            r2 = 1
        L_0x0243:
            boolean r3 = r11.f3053w
            r4 = 2021(0x7e5, float:2.832E-42)
            r8 = 2
            if (r3 == 0) goto L_0x025f
            java.util.ArrayList<android.net.wifi.ScanResult> r3 = r11.f3038h
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x025f
            r11.f3019A = r8
            java.lang.StringBuilder r1 = r11.f3046p
            java.lang.String r2 = "当前基站为伪基站，并且WIFI权限被禁用，请在安全软件中打开应用的定位权限#0201"
            r1.append(r2)
            com.loc.ReportUtil.m3435a((java.lang.String) r7, (int) r4)
            return r0
        L_0x025f:
            java.util.ArrayList<android.net.wifi.ScanResult> r3 = r11.f3038h
            int r3 = r3.size()
            r9 = 2022(0x7e6, float:2.833E-42)
            if (r3 != r5) goto L_0x029f
            r11.f3019A = r8
            boolean r3 = r11.f3053w
            if (r3 != 0) goto L_0x027a
            java.lang.StringBuilder r1 = r11.f3046p
            java.lang.String r2 = "当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202"
            r1.append(r2)
            com.loc.ReportUtil.m3435a((java.lang.String) r7, (int) r9)
            return r0
        L_0x027a:
            java.util.ArrayList<android.net.wifi.ScanResult> r3 = r11.f3038h
            java.lang.Object r3 = r3.get(r6)
            android.net.wifi.ScanResult r3 = (android.net.wifi.ScanResult) r3
            java.lang.String r3 = r3.BSSID
            com.loc.bt r10 = r11.f3033c
            android.net.wifi.WifiInfo r10 = r10.mo13114h()
            java.lang.String r10 = r10.getBSSID()
            boolean r3 = r10.equals(r3)
            if (r3 == 0) goto L_0x029f
            java.lang.StringBuilder r1 = r11.f3046p
            java.lang.String r2 = "当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202"
            r1.append(r2)
            com.loc.ReportUtil.m3435a((java.lang.String) r7, (int) r4)
            return r0
        L_0x029f:
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r3 = "#%s#"
            java.lang.Object[] r4 = new java.lang.Object[r5]
            r4[r6] = r1
            java.lang.String r0 = java.lang.String.format(r0, r3, r4)
            if (r2 == 0) goto L_0x02bf
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "wifi"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x02e3
        L_0x02bf:
            java.lang.String r2 = "network"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x02e3
            java.lang.String r0 = ""
            r11.f3019A = r8
            com.loc.bt r1 = r11.f3033c
            boolean r1 = r1.mo13113g()
            if (r1 != 0) goto L_0x02db
            java.lang.StringBuilder r1 = r11.f3046p
            java.lang.String r2 = "当前基站为伪基站,并且关闭了WIFI开关，请在设置中打开WIFI开关#0203"
        L_0x02d7:
            r1.append(r2)
            goto L_0x02e0
        L_0x02db:
            java.lang.StringBuilder r1 = r11.f3046p
            java.lang.String r2 = "当前基站为伪基站,并且没有搜索到WIFI，请移动到WIFI比较丰富的区域#0204"
            goto L_0x02d7
        L_0x02e0:
            com.loc.ReportUtil.m3435a((java.lang.String) r7, (int) r9)
        L_0x02e3:
            java.lang.String r1 = "#"
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0313
            boolean r2 = r0.startsWith(r1)
            if (r2 != 0) goto L_0x0300
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
        L_0x0300:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = com.loc.C1079cp.m3552i()
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x0313:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.Aps.m3458n():java.lang.String");
    }

    /* renamed from: o */
    private boolean m3459o() {
        this.f3038h = this.f3033c.mo13109c();
        return this.f3038h == null || this.f3038h.size() <= 0;
    }

    /* renamed from: a */
    public final AMapLocationServer mo13186a(double d, double d2) {
        try {
            String a = this.f3045o.mo13158a(this.f3031a, d, d2);
            if (!a.contains("\"status\":\"1\"")) {
                return null;
            }
            AMapLocationServer a2 = this.f3037g.mo13163a(a);
            a2.setLatitude(d);
            a2.setLongitude(d2);
            return a2;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    public final AMapLocationServer mo13187a(AMapLocationServer aMapLocationServer, String... strArr) {
        this.f3022E.mo13061a(this.f3050t);
        if (strArr == null || strArr.length == 0 || strArr[0].equals("shake")) {
            return this.f3022E.mo13059a(aMapLocationServer);
        }
        if (strArr[0].equals("fusion")) {
            LocFilter bnVar = this.f3022E;
        }
        return aMapLocationServer;
    }

    /* renamed from: a */
    public final AMapLocationServer mo13188a(boolean z) {
        int i;
        String str;
        if (this.f3031a == null) {
            this.f3046p.append("context is null#0101");
            ReportUtil.m3435a((String) null, 2011);
            i = 1;
        } else if (this.f3033c.mo13115i()) {
            i = 15;
            str = "networkLocation has been mocked!#1502";
            return m3450a(i, str);
        } else {
            mo13189a();
            if (TextUtils.isEmpty(this.f3029N)) {
                i = this.f3019A;
            } else {
                AMapLocationServer a = m3452a(false, z);
                if (C1079cp.m3509a(a)) {
                    this.f3035e.mo13124a(this.f3054x.toString());
                    this.f3035e.mo13123a(this.f3034d.mo13081c());
                    m3455b(a);
                }
                return a;
            }
        }
        str = this.f3046p.toString();
        return m3450a(i, str);
    }

    /* renamed from: a */
    public final void mo13189a() {
        this.f3045o = LocNetManager.m3305a(this.f3031a);
        m3456l();
        if (this.f3032b == null) {
            this.f3032b = (ConnectivityManager) C1079cp.m3501a(this.f3031a, "connectivity");
        }
        if (this.f3043m == null) {
            this.f3043m = new Req();
        }
    }

    /* renamed from: a */
    public final void mo13190a(Context context) {
        try {
            if (this.f3031a == null) {
                this.f3022E = new LocFilter();
                this.f3031a = context.getApplicationContext();
                AuthUtil.m3354d(this.f3031a);
                C1079cp.m3520b(this.f3031a);
                if (this.f3033c == null) {
                    this.f3033c = new WifiManagerWrapper(this.f3031a, (WifiManager) C1079cp.m3501a(this.f3031a, "wifi"));
                }
                if (this.f3034d == null) {
                    this.f3034d = new CgiManager(this.f3031a);
                }
                if (this.f3035e == null) {
                    this.f3035e = new C1066bv();
                }
                if (this.f3037g == null) {
                    this.f3037g = new Parser();
                }
                if (this.f3024G == null) {
                    this.f3024G = new CoManager(this.f3031a);
                }
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "Aps", "initBase");
        }
    }

    /* renamed from: a */
    public final void mo13191a(AMapLocationClientOption aMapLocationClientOption) {
        boolean z;
        boolean z2;
        boolean z3;
        AMapLocationClientOption.GeoLanguage geoLanguage;
        this.f3040j = aMapLocationClientOption;
        if (this.f3040j == null) {
            this.f3040j = new AMapLocationClientOption();
        }
        if (this.f3033c != null) {
            WifiManagerWrapper btVar = this.f3033c;
            this.f3040j.mo8557f();
            boolean g = this.f3040j.mo8558g();
            boolean b = this.f3040j.mo8550b();
            AMapLocationClientOption aMapLocationClientOption2 = this.f3040j;
            btVar.mo13105a(g, b, AMapLocationClientOption.m485w(), aMapLocationClientOption.mo8575x());
        }
        m3456l();
        if (this.f3035e != null) {
            this.f3035e.mo13122a(this.f3040j);
        }
        if (this.f3037g != null) {
            this.f3037g.mo13165a(this.f3040j);
        }
        try {
            geoLanguage = this.f3040j.mo8571t();
            try {
                z = this.f3040j.mo8556e();
            } catch (Throwable unused) {
                z = true;
                z3 = true;
                z2 = true;
                this.f3048r = z3;
                this.f3047q = z;
                this.f3050t = z2;
                this.f3049s = geoLanguage;
            }
            try {
                z3 = this.f3040j.mo8566o();
                try {
                    z2 = this.f3040j.mo8567p();
                    try {
                        this.f3051u = this.f3040j.mo8568q();
                        this.f3021C = this.f3040j.mo8569r();
                        if (!(z3 == this.f3048r && z == this.f3047q && z2 == this.f3050t && geoLanguage == this.f3049s)) {
                            if (this.f3035e != null) {
                                this.f3035e.mo13120a();
                            }
                            m3455b((AMapLocationServer) null);
                            this.f3030P = false;
                            if (this.f3022E != null) {
                                this.f3022E.mo13060a();
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable unused3) {
                    z2 = true;
                    this.f3048r = z3;
                    this.f3047q = z;
                    this.f3050t = z2;
                    this.f3049s = geoLanguage;
                }
            } catch (Throwable unused4) {
                z3 = true;
                z2 = true;
                this.f3048r = z3;
                this.f3047q = z;
                this.f3050t = z2;
                this.f3049s = geoLanguage;
            }
        } catch (Throwable unused5) {
            geoLanguage = AMapLocationClientOption.GeoLanguage.DEFAULT;
            z = true;
            z3 = true;
            z2 = true;
            this.f3048r = z3;
            this.f3047q = z;
            this.f3050t = z2;
            this.f3049s = geoLanguage;
        }
        this.f3048r = z3;
        this.f3047q = z;
        this.f3050t = z2;
        this.f3049s = geoLanguage;
    }

    /* renamed from: a */
    public final void mo13192a(AMapLocationServer aMapLocationServer) {
        if (C1079cp.m3509a(aMapLocationServer)) {
            this.f3035e.mo13125a(this.f3029N, this.f3054x, aMapLocationServer, this.f3031a, true);
        }
    }

    /* renamed from: b */
    public final void mo13193b() {
        if (this.f3020B == null) {
            this.f3020B = new AmapSensorManager(this.f3031a);
        }
        if (this.f3036f == null) {
            this.f3036f = new ConnectionServiceManager(this.f3031a);
        }
        m3457m();
        this.f3033c.mo13108b(false);
        this.f3038h = this.f3033c.mo13109c();
        this.f3034d.mo13078a(false, m3459o());
        this.f3035e.mo13121a(this.f3031a);
        this.f3036f.mo13048b();
        try {
            if (this.f3031a.checkCallingOrSelfPermission(C1107dj.m3824c("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFQ1VSRV9TRVRUSU5HUw==")) == 0) {
                this.f3044n = true;
            }
        } catch (Throwable unused) {
        }
        this.f3056z = true;
    }

    /* renamed from: c */
    public final void mo13194c() {
        if (this.f3046p.length() > 0) {
            this.f3046p.delete(0, this.f3046p.length());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x010f  */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.autonavi.aps.amapapi.model.AMapLocationServer mo13195d() throws java.lang.Throwable {
        /*
            r15 = this;
            r15.mo13194c()
            android.content.Context r0 = r15.f3031a
            r1 = 1
            if (r0 != 0) goto L_0x001a
            java.lang.StringBuilder r0 = r15.f3046p
            java.lang.String r2 = "context is null#0101"
            r0.append(r2)
            java.lang.StringBuilder r0 = r15.f3046p
            java.lang.String r0 = r0.toString()
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = m3450a((int) r1, (java.lang.String) r0)
            return r0
        L_0x001a:
            int r0 = r15.f3027K
            int r0 = r0 + r1
            r15.f3027K = r0
            int r0 = r15.f3027K
            if (r0 != r1) goto L_0x002e
            com.loc.bt r0 = r15.f3033c
            if (r0 == 0) goto L_0x002e
            com.loc.bt r0 = r15.f3033c
            boolean r2 = r15.f3044n
            r0.mo13104a((boolean) r2)
        L_0x002e:
            long r2 = r15.f3042l
            boolean r0 = r15.f3030P
            r4 = 0
            r6 = 0
            if (r0 != 0) goto L_0x003b
            r15.f3030P = r1
        L_0x0039:
            r0 = 0
            goto L_0x0062
        L_0x003b:
            long r7 = com.loc.C1079cp.m3529c()
            long r7 = r7 - r2
            r2 = 800(0x320, double:3.953E-321)
            int r0 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x0039
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = r15.f3041k
            boolean r0 = com.loc.C1079cp.m3509a((com.autonavi.aps.amapapi.model.AMapLocationServer) r0)
            if (r0 == 0) goto L_0x005a
            long r2 = com.loc.C1079cp.m3518b()
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = r15.f3041k
            long r7 = r0.getTime()
            long r2 = r2 - r7
            goto L_0x005b
        L_0x005a:
            r2 = r4
        L_0x005b:
            r7 = 10000(0x2710, double:4.9407E-320)
            int r0 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r0 > 0) goto L_0x0039
            r0 = 1
        L_0x0062:
            r2 = 2
            if (r0 == 0) goto L_0x0085
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = r15.f3041k
            boolean r0 = com.loc.C1079cp.m3509a((com.autonavi.aps.amapapi.model.AMapLocationServer) r0)
            if (r0 == 0) goto L_0x0085
            boolean r0 = r15.f3050t
            if (r0 == 0) goto L_0x0082
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = r15.f3041k
            long r0 = r0.getTime()
            boolean r0 = com.loc.AuthUtil.m3349b((long) r0)
            if (r0 == 0) goto L_0x0082
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = r15.f3041k
            r0.mo8481b((int) r2)
        L_0x0082:
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = r15.f3041k
            return r0
        L_0x0085:
            com.loc.bo r0 = r15.f3020B
            if (r0 == 0) goto L_0x0098
            boolean r0 = r15.f3021C
            if (r0 == 0) goto L_0x0093
            com.loc.bo r0 = r15.f3020B
            r0.mo13062a()
            goto L_0x0098
        L_0x0093:
            com.loc.bo r0 = r15.f3020B
            r0.mo13063b()
        L_0x0098:
            com.amap.api.location.AMapLocationClientOption r0 = r15.f3040j     // Catch:{ Throwable -> 0x00ba }
            boolean r0 = r0.mo8568q()     // Catch:{ Throwable -> 0x00ba }
            if (r0 != 0) goto L_0x00ab
            com.amap.api.location.AMapLocationClientOption r0 = r15.f3040j     // Catch:{ Throwable -> 0x00ba }
            boolean r0 = r0.mo8554d()     // Catch:{ Throwable -> 0x00ba }
            if (r0 != 0) goto L_0x00a9
            goto L_0x00ab
        L_0x00a9:
            r0 = 0
            goto L_0x00ac
        L_0x00ab:
            r0 = 1
        L_0x00ac:
            com.loc.bt r3 = r15.f3033c     // Catch:{ Throwable -> 0x00ba }
            r3.mo13108b(r0)     // Catch:{ Throwable -> 0x00ba }
            com.loc.bt r0 = r15.f3033c     // Catch:{ Throwable -> 0x00ba }
            java.util.ArrayList r0 = r0.mo13109c()     // Catch:{ Throwable -> 0x00ba }
            r15.f3038h = r0     // Catch:{ Throwable -> 0x00ba }
            goto L_0x00c2
        L_0x00ba:
            r0 = move-exception
            java.lang.String r3 = "Aps"
            java.lang.String r7 = "getLocation getScanResultsParam"
            com.loc.CoreUtil.m3389a(r0, r3, r7)
        L_0x00c2:
            com.loc.br r0 = r15.f3034d     // Catch:{ Throwable -> 0x00cc }
            boolean r3 = r15.m3459o()     // Catch:{ Throwable -> 0x00cc }
            r0.mo13078a((boolean) r6, (boolean) r3)     // Catch:{ Throwable -> 0x00cc }
            goto L_0x00d4
        L_0x00cc:
            r0 = move-exception
            java.lang.String r3 = "Aps"
            java.lang.String r7 = "getLocation getCgiListParam"
            com.loc.CoreUtil.m3389a(r0, r3, r7)
        L_0x00d4:
            java.lang.String r0 = r15.m3458n()
            r15.f3029N = r0
            java.lang.String r0 = r15.f3029N
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r3 = 4
            if (r0 == 0) goto L_0x010f
            com.loc.bm r0 = r15.f3036f
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = r0.mo13051e()
            r15.f3041k = r0
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = r15.f3041k
            if (r0 == 0) goto L_0x0102
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = r15.f3041k
            java.lang.StringBuilder r1 = r15.f3046p
            java.lang.String r1 = r1.toString()
            r0.mo8478a((java.lang.String) r1)
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = r15.f3041k
            r0.mo8500g((int) r3)
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = r15.f3041k
            return r0
        L_0x0102:
            int r0 = r15.f3019A
            java.lang.StringBuilder r1 = r15.f3046p
            java.lang.String r1 = r1.toString()
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = m3450a((int) r0, (java.lang.String) r1)
            return r0
        L_0x010f:
            java.lang.StringBuilder r0 = r15.f3054x
            java.lang.StringBuilder r0 = r15.m3453a((java.lang.StringBuilder) r0)
            r15.f3054x = r0
            com.loc.bt r0 = r15.f3033c
            boolean r0 = r0.mo13115i()
            if (r0 == 0) goto L_0x012e
            r0 = 15
            java.lang.String r2 = "networkLocation has been mocked!#1502"
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = m3450a((int) r0, (java.lang.String) r2)
            r0.mo8487c((boolean) r1)
            r0.mo8500g((int) r3)
            return r0
        L_0x012e:
            long r7 = r15.f3042l
            int r0 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x0136
        L_0x0134:
            r9 = 1
            goto L_0x0145
        L_0x0136:
            long r4 = com.loc.C1079cp.m3529c()
            long r7 = r15.f3042l
            long r4 = r4 - r7
            r7 = 20000(0x4e20, double:9.8813E-320)
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 <= 0) goto L_0x0144
            goto L_0x0134
        L_0x0144:
            r9 = 0
        L_0x0145:
            com.loc.bv r7 = r15.f3035e
            com.loc.br r8 = r15.f3034d
            com.autonavi.aps.amapapi.model.AMapLocationServer r10 = r15.f3041k
            com.loc.bt r11 = r15.f3033c
            java.lang.StringBuilder r12 = r15.f3054x
            java.lang.String r13 = r15.f3029N
            android.content.Context r14 = r15.f3031a
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = r7.mo13119a(r8, r9, r10, r11, r12, r13, r14)
            boolean r4 = com.loc.C1079cp.m3509a((com.autonavi.aps.amapapi.model.AMapLocationServer) r0)
            if (r4 == 0) goto L_0x0164
            r0.mo8500g((int) r2)
            r15.m3455b((com.autonavi.aps.amapapi.model.AMapLocationServer) r0)
            goto L_0x01a3
        L_0x0164:
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = r15.m3452a((boolean) r6, (boolean) r1)
            r15.f3041k = r0
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = r15.f3041k
            boolean r0 = com.loc.C1079cp.m3509a((com.autonavi.aps.amapapi.model.AMapLocationServer) r0)
            if (r0 == 0) goto L_0x01a3
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = r15.f3041k
            java.lang.String r4 = "new"
            r0.mo8813w(r4)
            com.loc.bv r0 = r15.f3035e
            java.lang.StringBuilder r4 = r15.f3054x
            java.lang.String r4 = r4.toString()
            r0.mo13124a((java.lang.String) r4)
            com.loc.bv r0 = r15.f3035e
            com.loc.br r4 = r15.f3034d
            com.loc.bq r4 = r4.mo13081c()
            r0.mo13123a((com.loc.Cgi) r4)
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = r15.f3041k
            r15.m3455b((com.autonavi.aps.amapapi.model.AMapLocationServer) r0)
            com.loc.bs r0 = r15.f3024G
            if (r0 == 0) goto L_0x01a3
            com.loc.bs r0 = r15.f3024G
            com.loc.br r4 = r15.f3034d
            java.util.ArrayList<android.net.wifi.ScanResult> r5 = r15.f3038h
            com.autonavi.aps.amapapi.model.AMapLocationServer r7 = r15.f3041k
            r0.mo13102c(r4, r5, r7)
        L_0x01a3:
            com.loc.bt r0 = r15.f3033c     // Catch:{ Throwable -> 0x01d8 }
            if (r0 == 0) goto L_0x01d8
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = r15.f3041k     // Catch:{ Throwable -> 0x01d8 }
            if (r0 == 0) goto L_0x01d8
            com.loc.bt r0 = r15.f3033c     // Catch:{ Throwable -> 0x01d8 }
            long r4 = com.loc.WifiManagerWrapper.m3184a()     // Catch:{ Throwable -> 0x01d8 }
            r7 = 15
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 > 0) goto L_0x01bd
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = r15.f3041k     // Catch:{ Throwable -> 0x01d8 }
        L_0x01b9:
            r0.mo8500g((int) r1)     // Catch:{ Throwable -> 0x01d8 }
            goto L_0x01d8
        L_0x01bd:
            r0 = 120(0x78, double:5.93E-322)
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x01c9
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = r15.f3041k     // Catch:{ Throwable -> 0x01d8 }
            r0.mo8500g((int) r2)     // Catch:{ Throwable -> 0x01d8 }
            goto L_0x01d8
        L_0x01c9:
            r0 = 600(0x258, double:2.964E-321)
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x01d3
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = r15.f3041k     // Catch:{ Throwable -> 0x01d8 }
            r1 = 3
            goto L_0x01b9
        L_0x01d3:
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = r15.f3041k     // Catch:{ Throwable -> 0x01d8 }
            r0.mo8500g((int) r3)     // Catch:{ Throwable -> 0x01d8 }
        L_0x01d8:
            com.loc.bs r0 = r15.f3024G
            if (r0 == 0) goto L_0x01e7
            com.loc.bs r0 = r15.f3024G
            com.loc.br r1 = r15.f3034d
            java.util.ArrayList<android.net.wifi.ScanResult> r2 = r15.f3038h
            com.autonavi.aps.amapapi.model.AMapLocationServer r3 = r15.f3041k
            r0.mo13100b(r1, r2, r3)
        L_0x01e7:
            com.loc.bv r7 = r15.f3035e
            java.lang.String r8 = r15.f3029N
            java.lang.StringBuilder r9 = r15.f3054x
            com.autonavi.aps.amapapi.model.AMapLocationServer r10 = r15.f3041k
            android.content.Context r11 = r15.f3031a
            r12 = 1
            r7.mo13125a(r8, r9, r10, r11, r12)
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = r15.f3041k
            boolean r0 = com.loc.C1079cp.m3509a((com.autonavi.aps.amapapi.model.AMapLocationServer) r0)
            if (r0 != 0) goto L_0x0211
            com.loc.bs r0 = r15.f3024G
            if (r0 == 0) goto L_0x0211
            com.loc.bs r0 = r15.f3024G
            android.content.Context r1 = r15.f3031a
            com.loc.br r1 = r15.f3034d
            java.util.ArrayList<android.net.wifi.ScanResult> r2 = r15.f3038h
            com.autonavi.aps.amapapi.model.AMapLocationServer r3 = r15.f3041k
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = r0.mo13098a((com.loc.CgiManager) r1, (java.util.List<android.net.wifi.ScanResult>) r2, (com.autonavi.aps.amapapi.model.AMapLocationServer) r3)
            r15.f3041k = r0
        L_0x0211:
            java.lang.StringBuilder r0 = r15.f3054x
            java.lang.StringBuilder r1 = r15.f3054x
            int r1 = r1.length()
            r0.delete(r6, r1)
            boolean r0 = r15.f3021C
            if (r0 == 0) goto L_0x0244
            com.loc.bo r0 = r15.f3020B
            if (r0 == 0) goto L_0x0244
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = r15.f3041k
            com.loc.bo r1 = r15.f3020B
            double r1 = r1.mo13064c()
            r0.setAltitude(r1)
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = r15.f3041k
            com.loc.bo r1 = r15.f3020B
            float r1 = r1.mo13065d()
            r0.setBearing(r1)
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = r15.f3041k
            com.loc.bo r1 = r15.f3020B
            double r1 = r1.mo13066e()
            float r1 = (float) r1
            goto L_0x0253
        L_0x0244:
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = r15.f3041k
            r1 = 0
            r0.setAltitude(r1)
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = r15.f3041k
            r1 = 0
            r0.setBearing(r1)
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = r15.f3041k
        L_0x0253:
            r0.setSpeed(r1)
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = r15.f3041k
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.Aps.mo13195d():com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    /* renamed from: e */
    public final void mo13196e() {
        try {
            mo13190a(this.f3031a);
            mo13191a(this.f3040j);
            Context context = this.f3031a;
            mo13200i();
            mo13192a(m3452a(true, true));
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "Aps", "doFusionLocation");
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: f */
    public final void mo13197f() {
        this.f3023F = null;
        this.f3055y = false;
        this.f3056z = false;
        if (this.f3024G != null) {
            this.f3024G.mo13103d();
        }
        if (this.f3036f != null) {
            this.f3036f.mo13047a();
        }
        if (this.f3035e != null) {
            this.f3035e.mo13126b(this.f3031a);
        }
        if (this.f3022E != null) {
            this.f3022E.mo13060a();
        }
        if (this.f3037g != null) {
            this.f3037g = null;
        }
        C1079cp.m3549h();
        try {
            if (!(this.f3031a == null || this.f3039i == null)) {
                this.f3031a.unregisterReceiver(this.f3039i);
            }
        } catch (Throwable th) {
            this.f3039i = null;
            throw th;
        }
        this.f3039i = null;
        if (this.f3034d != null) {
            this.f3034d.mo13086h();
        }
        if (this.f3033c != null) {
            this.f3033c.mo13117k();
        }
        if (this.f3038h != null) {
            this.f3038h.clear();
        }
        if (this.f3020B != null) {
            this.f3020B.mo13067f();
        }
        DnsManager.m3251e();
        this.f3041k = null;
        this.f3031a = null;
        this.f3054x = null;
        this.f3026J = null;
    }

    /* renamed from: g */
    public final void mo13198g() {
        try {
            if (this.f3036f != null) {
                this.f3036f.mo13049c();
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "Aps", "bindAMapService");
        }
    }

    /* renamed from: h */
    public final void mo13199h() {
        try {
            if (this.f3036f != null) {
                this.f3036f.mo13050d();
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "Aps", "bindOtherService");
        }
    }

    /* renamed from: i */
    public final void mo13200i() {
        try {
            if (!this.f3055y) {
                if (this.f3029N != null) {
                    this.f3029N = null;
                }
                if (this.f3054x != null) {
                    this.f3054x.delete(0, this.f3054x.length());
                }
                if (this.f3051u) {
                    m3457m();
                }
                this.f3033c.mo13108b(this.f3051u);
                this.f3038h = this.f3033c.mo13109c();
                this.f3034d.mo13078a(true, m3459o());
                this.f3029N = m3458n();
                if (!TextUtils.isEmpty(this.f3029N)) {
                    this.f3054x = m3453a(this.f3054x);
                }
                this.f3055y = true;
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "Aps", "initFirstLocateParam");
        }
    }

    /* renamed from: j */
    public final AMapLocationServer mo13201j() {
        int i;
        String sb;
        if (this.f3033c.mo13115i()) {
            i = 15;
            sb = "networkLocation has been mocked!#1502";
        } else if (TextUtils.isEmpty(this.f3029N)) {
            i = this.f3019A;
            sb = this.f3046p.toString();
        } else {
            AMapLocationServer a = this.f3035e.mo13118a(this.f3031a, this.f3029N, this.f3054x, true);
            if (C1079cp.m3509a(a)) {
                m3455b(a);
            }
            return a;
        }
        return m3450a(i, sb);
    }

    /* renamed from: k */
    public final void mo13202k() {
        if (this.f3024G != null) {
            this.f3024G.mo13099b();
        }
    }
}
