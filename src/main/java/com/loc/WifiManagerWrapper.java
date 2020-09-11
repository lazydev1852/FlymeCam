package com.loc;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.p020ar.util.MsgConstants;
import com.meizu.statsapp.p081v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

/* renamed from: com.loc.bt */
public final class WifiManagerWrapper {

    /* renamed from: c */
    static long f2751c;

    /* renamed from: d */
    static long f2752d;

    /* renamed from: e */
    static long f2753e;

    /* renamed from: f */
    static long f2754f;

    /* renamed from: g */
    static long f2755g;

    /* renamed from: q */
    public static HashMap<String, Long> f2756q = new HashMap<>(36);

    /* renamed from: r */
    public static long f2757r = 0;

    /* renamed from: s */
    static int f2758s = 0;

    /* renamed from: a */
    WifiManager f2759a;

    /* renamed from: b */
    ArrayList<ScanResult> f2760b = new ArrayList<>();

    /* renamed from: h */
    Context f2761h;

    /* renamed from: i */
    boolean f2762i = false;

    /* renamed from: j */
    StringBuilder f2763j = null;

    /* renamed from: k */
    boolean f2764k = true;

    /* renamed from: l */
    boolean f2765l = true;

    /* renamed from: m */
    boolean f2766m = true;

    /* renamed from: n */
    String f2767n = null;

    /* renamed from: o */
    TreeMap<Integer, ScanResult> f2768o = null;

    /* renamed from: p */
    public boolean f2769p = true;

    /* renamed from: t */
    ConnectivityManager f2770t = null;

    /* renamed from: u */
    volatile boolean f2771u = false;

    /* renamed from: v */
    private volatile WifiInfo f2772v = null;

    /* renamed from: w */
    private long f2773w = 30000;

    public WifiManagerWrapper(Context context, WifiManager wifiManager) {
        this.f2759a = wifiManager;
        this.f2761h = context;
    }

    /* renamed from: a */
    public static long m3184a() {
        return ((C1079cp.m3529c() - f2757r) / 1000) + 1;
    }

    /* renamed from: a */
    private static boolean m3185a(int i) {
        int i2;
        try {
            i2 = WifiManager.calculateSignalLevel(i, 20);
        } catch (ArithmeticException e) {
            CoreUtil.m3389a(e, "Aps", "wifiSigFine");
            i2 = 20;
        }
        return i2 > 0;
    }

    /* renamed from: a */
    public static boolean m3186a(WifiInfo wifiInfo) {
        return wifiInfo != null && !TextUtils.isEmpty(wifiInfo.getSSID()) && C1079cp.m3510a(wifiInfo.getBSSID());
    }

    /* renamed from: l */
    public static String m3187l() {
        return String.valueOf(C1079cp.m3529c() - f2754f);
    }

    /* renamed from: m */
    private List<ScanResult> m3188m() {
        long c;
        if (this.f2759a != null) {
            try {
                List<ScanResult> scanResults = this.f2759a.getScanResults();
                if (Build.VERSION.SDK_INT >= 17) {
                    HashMap<String, Long> hashMap = new HashMap<>(36);
                    for (ScanResult next : scanResults) {
                        hashMap.put(next.BSSID, Long.valueOf(next.timestamp));
                    }
                    if (f2756q.isEmpty() || !f2756q.equals(hashMap)) {
                        f2756q = hashMap;
                        c = C1079cp.m3529c();
                    }
                    this.f2767n = null;
                    return scanResults;
                }
                c = C1079cp.m3529c();
                f2757r = c;
                this.f2767n = null;
                return scanResults;
            } catch (SecurityException e) {
                this.f2767n = e.getMessage();
            } catch (Throwable th) {
                this.f2767n = null;
                CoreUtil.m3389a(th, "WifiManagerWrapper", "getScanResults");
            }
        }
        return null;
    }

    /* renamed from: n */
    private WifiInfo m3189n() {
        try {
            if (this.f2759a != null) {
                return this.f2759a.getConnectionInfo();
            }
            return null;
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "WifiManagerWrapper", "getConnectionInfo");
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0058, code lost:
        if (r0 < r6) goto L_0x0075;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0078 A[Catch:{ Throwable -> 0x007f }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* renamed from: o */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3190o() {
        /*
            r10 = this;
            boolean r0 = r10.m3191p()
            if (r0 == 0) goto L_0x0087
            long r0 = com.loc.C1079cp.m3529c()     // Catch:{ Throwable -> 0x007f }
            long r2 = f2751c     // Catch:{ Throwable -> 0x007f }
            r4 = 0
            long r0 = r0 - r2
            r2 = 4900(0x1324, double:2.421E-320)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0075
            android.net.ConnectivityManager r2 = r10.f2770t     // Catch:{ Throwable -> 0x007f }
            if (r2 != 0) goto L_0x0024
            android.content.Context r2 = r10.f2761h     // Catch:{ Throwable -> 0x007f }
            java.lang.String r3 = "connectivity"
            java.lang.Object r2 = com.loc.C1079cp.m3501a((android.content.Context) r2, (java.lang.String) r3)     // Catch:{ Throwable -> 0x007f }
            android.net.ConnectivityManager r2 = (android.net.ConnectivityManager) r2     // Catch:{ Throwable -> 0x007f }
            r10.f2770t = r2     // Catch:{ Throwable -> 0x007f }
        L_0x0024:
            android.net.ConnectivityManager r2 = r10.f2770t     // Catch:{ Throwable -> 0x007f }
            boolean r2 = r10.mo13106a((android.net.ConnectivityManager) r2)     // Catch:{ Throwable -> 0x007f }
            if (r2 == 0) goto L_0x0032
            r2 = 9900(0x26ac, double:4.8912E-320)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0075
        L_0x0032:
            int r2 = f2758s     // Catch:{ Throwable -> 0x007f }
            r3 = 1
            if (r2 <= r3) goto L_0x005a
            long r4 = r10.f2773w     // Catch:{ Throwable -> 0x007f }
            r6 = 30000(0x7530, double:1.4822E-319)
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x0042
            long r6 = r10.f2773w     // Catch:{ Throwable -> 0x007f }
            goto L_0x0050
        L_0x0042:
            long r4 = com.loc.AuthUtil.m3337D()     // Catch:{ Throwable -> 0x007f }
            r8 = -1
            int r2 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r2 == 0) goto L_0x0050
            long r6 = com.loc.AuthUtil.m3337D()     // Catch:{ Throwable -> 0x007f }
        L_0x0050:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ Throwable -> 0x007f }
            r4 = 28
            if (r2 < r4) goto L_0x005a
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 < 0) goto L_0x0075
        L_0x005a:
            android.net.wifi.WifiManager r0 = r10.f2759a     // Catch:{ Throwable -> 0x007f }
            if (r0 == 0) goto L_0x0075
            long r0 = com.loc.C1079cp.m3529c()     // Catch:{ Throwable -> 0x007f }
            f2751c = r0     // Catch:{ Throwable -> 0x007f }
            int r0 = f2758s     // Catch:{ Throwable -> 0x007f }
            r1 = 2
            if (r0 >= r1) goto L_0x006e
            int r0 = f2758s     // Catch:{ Throwable -> 0x007f }
            int r0 = r0 + r3
            f2758s = r0     // Catch:{ Throwable -> 0x007f }
        L_0x006e:
            android.net.wifi.WifiManager r0 = r10.f2759a     // Catch:{ Throwable -> 0x007f }
            boolean r0 = r0.startScan()     // Catch:{ Throwable -> 0x007f }
            goto L_0x0076
        L_0x0075:
            r0 = 0
        L_0x0076:
            if (r0 == 0) goto L_0x007e
            long r0 = com.loc.C1079cp.m3529c()     // Catch:{ Throwable -> 0x007f }
            f2753e = r0     // Catch:{ Throwable -> 0x007f }
        L_0x007e:
            return
        L_0x007f:
            r0 = move-exception
            java.lang.String r1 = "WifiManager"
            java.lang.String r2 = "wifiScan"
            com.loc.CoreUtil.m3389a(r0, r1, r2)
        L_0x0087:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.WifiManagerWrapper.m3190o():void");
    }

    /* renamed from: p */
    private boolean m3191p() {
        this.f2769p = this.f2759a == null ? false : C1079cp.m3550h(this.f2761h);
        if (!this.f2769p || !this.f2764k) {
            return false;
        }
        if (f2753e != 0) {
            if (C1079cp.m3529c() - f2753e < 4900 || C1079cp.m3529c() - f2754f < 1500) {
                return false;
            }
            int i = ((C1079cp.m3529c() - f2754f) > 4900 ? 1 : ((C1079cp.m3529c() - f2754f) == 4900 ? 0 : -1));
        }
        return true;
    }

    /* renamed from: a */
    public final void mo13104a(boolean z) {
        Context context = this.f2761h;
        if (AuthUtil.m3336C() && this.f2766m && this.f2759a != null && context != null && z && C1079cp.m3535d() > 17) {
            ContentResolver contentResolver = context.getContentResolver();
            try {
                if (((Integer) Reflect.m3414a("android.provider.Settings$Global", "getInt", new Object[]{contentResolver, "wifi_scan_always_enabled"}, (Class<?>[]) new Class[]{ContentResolver.class, String.class})).intValue() == 0) {
                    Reflect.m3414a("android.provider.Settings$Global", "putInt", new Object[]{contentResolver, "wifi_scan_always_enabled", 1}, (Class<?>[]) new Class[]{ContentResolver.class, String.class, Integer.TYPE});
                }
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "WifiManagerWrapper", "enableWifiAlwaysScan");
            }
        }
    }

    /* renamed from: a */
    public final void mo13105a(boolean z, boolean z2, boolean z3, long j) {
        this.f2764k = z;
        this.f2765l = z2;
        this.f2766m = z3;
        if (j < 10000) {
            this.f2773w = 10000;
        } else {
            this.f2773w = j;
        }
    }

    /* renamed from: a */
    public final boolean mo13106a(ConnectivityManager connectivityManager) {
        WifiManager wifiManager = this.f2759a;
        if (wifiManager == null) {
            return false;
        }
        try {
            return C1079cp.m3500a(connectivityManager.getActiveNetworkInfo()) == 1 && m3186a(wifiManager.getConnectionInfo());
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "WifiManagerWrapper", "wifiAccess");
            return false;
        }
    }

    /* renamed from: b */
    public final String mo13107b() {
        return this.f2767n;
    }

    /* renamed from: b */
    public final void mo13108b(boolean z) {
        String str;
        if (!z) {
            m3190o();
        } else if (m3191p()) {
            long c = C1079cp.m3529c();
            if (c - f2752d >= 10000) {
                this.f2760b.clear();
                f2755g = f2754f;
            }
            m3190o();
            if (c - f2752d >= 10000) {
                for (int i = 20; i > 0 && f2754f == f2755g; i--) {
                    try {
                        Thread.sleep(150);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        if (this.f2771u) {
            this.f2771u = false;
            mo13110d();
        }
        if (f2755g != f2754f) {
            List<ScanResult> list = null;
            try {
                list = m3188m();
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "WifiManager", "updateScanResult");
            }
            f2755g = f2754f;
            if (list != null) {
                this.f2760b.clear();
                this.f2760b.addAll(list);
            } else {
                this.f2760b.clear();
            }
        }
        if (C1079cp.m3529c() - f2754f > 20000) {
            this.f2760b.clear();
        }
        f2752d = C1079cp.m3529c();
        if (this.f2760b.isEmpty()) {
            f2754f = C1079cp.m3529c();
            List<ScanResult> m = m3188m();
            if (m != null) {
                this.f2760b.addAll(m);
            }
        }
        if (this.f2760b != null && !this.f2760b.isEmpty()) {
            if (C1079cp.m3529c() - f2754f > UxipConstants.HOUR_MILLISENCOND) {
                mo13110d();
            }
            if (this.f2768o == null) {
                this.f2768o = new TreeMap<>(Collections.reverseOrder());
            }
            this.f2768o.clear();
            int size = this.f2760b.size();
            for (int i2 = 0; i2 < size; i2++) {
                ScanResult scanResult = this.f2760b.get(i2);
                if (C1079cp.m3510a(scanResult != null ? scanResult.BSSID : "") && (size <= 20 || m3185a(scanResult.level))) {
                    if (!TextUtils.isEmpty(scanResult.SSID)) {
                        if (!"<unknown ssid>".equals(scanResult.SSID)) {
                            str = String.valueOf(i2);
                        }
                        this.f2768o.put(Integer.valueOf((scanResult.level * 25) + i2), scanResult);
                    } else {
                        str = "unkwn";
                    }
                    scanResult.SSID = str;
                    this.f2768o.put(Integer.valueOf((scanResult.level * 25) + i2), scanResult);
                }
            }
            this.f2760b.clear();
            for (ScanResult add : this.f2768o.values()) {
                this.f2760b.add(add);
            }
            this.f2768o.clear();
        }
    }

    /* renamed from: c */
    public final ArrayList<ScanResult> mo13109c() {
        if (this.f2760b == null) {
            return null;
        }
        ArrayList<ScanResult> arrayList = new ArrayList<>();
        if (!this.f2760b.isEmpty()) {
            arrayList.addAll(this.f2760b);
        }
        return arrayList;
    }

    /* renamed from: d */
    public final void mo13110d() {
        this.f2772v = null;
        this.f2760b.clear();
    }

    /* renamed from: e */
    public final void mo13111e() {
        if (this.f2759a != null && C1079cp.m3529c() - f2754f > 4900) {
            f2754f = C1079cp.m3529c();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0027  */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo13112f() {
        /*
            r4 = this;
            android.net.wifi.WifiManager r0 = r4.f2759a
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 4
            android.net.wifi.WifiManager r1 = r4.f2759a     // Catch:{ Throwable -> 0x0011 }
            if (r1 == 0) goto L_0x0019
            android.net.wifi.WifiManager r1 = r4.f2759a     // Catch:{ Throwable -> 0x0011 }
            int r1 = r1.getWifiState()     // Catch:{ Throwable -> 0x0011 }
            goto L_0x001a
        L_0x0011:
            r1 = move-exception
            java.lang.String r2 = "Aps"
            java.lang.String r3 = "onReceive part"
            com.loc.CoreUtil.m3389a(r1, r2, r3)
        L_0x0019:
            r1 = 4
        L_0x001a:
            java.util.ArrayList<android.net.wifi.ScanResult> r2 = r4.f2760b
            if (r2 != 0) goto L_0x0025
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r4.f2760b = r2
        L_0x0025:
            if (r1 == r0) goto L_0x002b
            switch(r1) {
                case 0: goto L_0x002b;
                case 1: goto L_0x002b;
                default: goto L_0x002a;
            }
        L_0x002a:
            goto L_0x002e
        L_0x002b:
            r0 = 1
            r4.f2771u = r0
        L_0x002e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.WifiManagerWrapper.mo13112f():void");
    }

    /* renamed from: g */
    public final boolean mo13113g() {
        return this.f2769p;
    }

    /* renamed from: h */
    public final WifiInfo mo13114h() {
        this.f2772v = m3189n();
        return this.f2772v;
    }

    /* renamed from: i */
    public final boolean mo13115i() {
        return this.f2762i;
    }

    /* renamed from: j */
    public final String mo13116j() {
        if (this.f2763j == null) {
            this.f2763j = new StringBuilder(MsgConstants.TRACK_CLOSE_CLOUD_RECOGNITION);
        } else {
            this.f2763j.delete(0, this.f2763j.length());
        }
        this.f2762i = false;
        String str = "";
        this.f2772v = mo13114h();
        if (m3186a(this.f2772v)) {
            str = this.f2772v.getBSSID();
        }
        int size = this.f2760b.size();
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            String str2 = this.f2760b.get(i).BSSID;
            if (!this.f2765l && !"<unknown ssid>".equals(this.f2760b.get(i).SSID)) {
                z = true;
            }
            String str3 = "nb";
            if (str.equals(str2)) {
                str3 = "access";
                z2 = true;
            }
            this.f2763j.append(String.format(Locale.US, "#%s,%s", new Object[]{str2, str3}));
        }
        if (this.f2760b.size() == 0) {
            z = true;
        }
        if (!this.f2765l && !z) {
            this.f2762i = true;
        }
        if (!z2 && !TextUtils.isEmpty(str)) {
            StringBuilder sb = this.f2763j;
            sb.append("#");
            sb.append(str);
            this.f2763j.append(",access");
        }
        return this.f2763j.toString();
    }

    /* renamed from: k */
    public final void mo13117k() {
        mo13110d();
        this.f2760b.clear();
    }
}
