package com.loc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.p020ar.util.SystemInfoUtil;
import com.meizu.savior.Constants;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.loc.dc */
public final class DeviceInfo {

    /* renamed from: a */
    static String f3271a = "";

    /* renamed from: b */
    static String f3272b = "";

    /* renamed from: c */
    public static boolean f3273c = false;

    /* renamed from: d */
    static String f3274d = "";

    /* renamed from: e */
    static boolean f3275e = false;

    /* renamed from: f */
    static int f3276f = -1;

    /* renamed from: g */
    static String f3277g = "";

    /* renamed from: h */
    static String f3278h = "";

    /* renamed from: i */
    private static String f3279i = null;

    /* renamed from: j */
    private static boolean f3280j = false;

    /* renamed from: k */
    private static String f3281k = "";

    /* renamed from: l */
    private static String f3282l = "";

    /* renamed from: m */
    private static String f3283m = "";

    /* renamed from: n */
    private static String f3284n = "";

    /* renamed from: o */
    private static String f3285o = "";

    /* renamed from: p */
    private static String f3286p = "";

    /* renamed from: q */
    private static boolean f3287q = false;

    /* renamed from: r */
    private static long f3288r = 0;

    /* renamed from: s */
    private static int f3289s = 0;

    /* renamed from: t */
    private static String f3290t = null;

    /* renamed from: u */
    private static String f3291u = "";

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0098 A[SYNTHETIC, Splitter:B:45:0x0098] */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* renamed from: A */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m3696A(android.content.Context r8) {
        /*
            r0 = 0
            java.lang.String r1 = "android.permission.READ_EXTERNAL_STORAGE"
            boolean r8 = com.loc.C1107dj.m3815a((android.content.Context) r8, (java.lang.String) r1)     // Catch:{ Throwable -> 0x009c, all -> 0x0095 }
            if (r8 == 0) goto L_0x008f
            java.lang.String r8 = "mounted"
            java.lang.String r1 = android.os.Environment.getExternalStorageState()     // Catch:{ Throwable -> 0x009c, all -> 0x0095 }
            boolean r8 = r8.equals(r1)     // Catch:{ Throwable -> 0x009c, all -> 0x0095 }
            if (r8 == 0) goto L_0x008f
            java.io.File r8 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Throwable -> 0x009c, all -> 0x0095 }
            java.lang.String r8 = r8.getAbsolutePath()     // Catch:{ Throwable -> 0x009c, all -> 0x0095 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x009c, all -> 0x0095 }
            r1.<init>()     // Catch:{ Throwable -> 0x009c, all -> 0x0095 }
            r1.append(r8)     // Catch:{ Throwable -> 0x009c, all -> 0x0095 }
            java.lang.String r8 = "/.UTSystemConfig/Global/Alvin2.xml"
            r1.append(r8)     // Catch:{ Throwable -> 0x009c, all -> 0x0095 }
            java.lang.String r8 = r1.toString()     // Catch:{ Throwable -> 0x009c, all -> 0x0095 }
            java.io.File r1 = new java.io.File     // Catch:{ Throwable -> 0x009c, all -> 0x0095 }
            r1.<init>(r8)     // Catch:{ Throwable -> 0x009c, all -> 0x0095 }
            org.xmlpull.v1.XmlPullParser r8 = android.util.Xml.newPullParser()     // Catch:{ Throwable -> 0x009c, all -> 0x0095 }
            int r2 = r8.getEventType()     // Catch:{ Throwable -> 0x009c, all -> 0x0095 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x009c, all -> 0x0095 }
            r3.<init>(r1)     // Catch:{ Throwable -> 0x009c, all -> 0x0095 }
            java.lang.String r0 = "utf-8"
            r8.setInput(r3, r0)     // Catch:{ Throwable -> 0x008d, all -> 0x008a }
            r0 = 0
            r1 = 0
        L_0x0047:
            r4 = 1
            if (r4 == r2) goto L_0x0088
            if (r2 == 0) goto L_0x0083
            switch(r2) {
                case 2: goto L_0x005c;
                case 3: goto L_0x005a;
                case 4: goto L_0x0050;
                default: goto L_0x004f;
            }     // Catch:{ Throwable -> 0x008d, all -> 0x008a }
        L_0x004f:
            goto L_0x0083
        L_0x0050:
            if (r1 == 0) goto L_0x0083
            java.lang.String r8 = r8.getText()     // Catch:{ Throwable -> 0x008d, all -> 0x008a }
            r3.close()     // Catch:{ Throwable -> 0x0059 }
        L_0x0059:
            return r8
        L_0x005a:
            r1 = 0
            goto L_0x0083
        L_0x005c:
            int r2 = r8.getAttributeCount()     // Catch:{ Throwable -> 0x008d, all -> 0x008a }
            if (r2 <= 0) goto L_0x0083
            int r2 = r8.getAttributeCount()     // Catch:{ Throwable -> 0x008d, all -> 0x008a }
            r5 = r1
            r1 = 0
        L_0x0068:
            if (r1 >= r2) goto L_0x0082
            java.lang.String r6 = r8.getAttributeValue(r1)     // Catch:{ Throwable -> 0x008d, all -> 0x008a }
            java.lang.String r7 = "UTDID2"
            boolean r7 = r7.equals(r6)     // Catch:{ Throwable -> 0x008d, all -> 0x008a }
            if (r7 != 0) goto L_0x007e
            java.lang.String r7 = "UTDID"
            boolean r6 = r7.equals(r6)     // Catch:{ Throwable -> 0x008d, all -> 0x008a }
            if (r6 == 0) goto L_0x007f
        L_0x007e:
            r5 = 1
        L_0x007f:
            int r1 = r1 + 1
            goto L_0x0068
        L_0x0082:
            r1 = r5
        L_0x0083:
            int r2 = r8.next()     // Catch:{ Throwable -> 0x008d, all -> 0x008a }
            goto L_0x0047
        L_0x0088:
            r0 = r3
            goto L_0x008f
        L_0x008a:
            r8 = move-exception
            r0 = r3
            goto L_0x0096
        L_0x008d:
            r0 = r3
            goto L_0x009c
        L_0x008f:
            if (r0 == 0) goto L_0x009f
        L_0x0091:
            r0.close()     // Catch:{ Throwable -> 0x009f }
            goto L_0x009f
        L_0x0095:
            r8 = move-exception
        L_0x0096:
            if (r0 == 0) goto L_0x009b
            r0.close()     // Catch:{ Throwable -> 0x009b }
        L_0x009b:
            throw r8
        L_0x009c:
            if (r0 == 0) goto L_0x009f
            goto L_0x0091
        L_0x009f:
            java.lang.String r8 = ""
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.DeviceInfo.m3696A(android.content.Context):java.lang.String");
    }

    /* renamed from: B */
    private static String m3697B(Context context) throws InvocationTargetException, IllegalAccessException {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        if (f3291u != null && !"".equals(f3291u)) {
            return f3291u;
        }
        if (!m3710b(context, C1107dj.m3824c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return f3291u;
        }
        TelephonyManager G = m3702G(context);
        if (G == null) {
            return "";
        }
        Method a = C1107dj.m3811a((Class) G.getClass(), "UZ2V0U3Vic2NyaWJlcklk", (Class<?>[]) new Class[0]);
        if (a != null) {
            f3291u = (String) a.invoke(G, new Object[0]);
        }
        if (f3291u == null) {
            f3291u = "";
        }
        return f3291u;
    }

    /* renamed from: C */
    private static String m3698C(Context context) {
        if (!m3710b(context, C1107dj.m3824c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return null;
        }
        TelephonyManager G = m3702G(context);
        if (G == null) {
            return "";
        }
        String simOperatorName = G.getSimOperatorName();
        return TextUtils.isEmpty(simOperatorName) ? G.getNetworkOperatorName() : simOperatorName;
    }

    /* renamed from: D */
    private static int m3699D(Context context) {
        ConnectivityManager E;
        NetworkInfo activeNetworkInfo;
        if (context == null || !m3710b(context, C1107dj.m3824c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) || (E = m3700E(context)) == null || (activeNetworkInfo = E.getActiveNetworkInfo()) == null) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    /* renamed from: E */
    private static ConnectivityManager m3700E(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    /* renamed from: F */
    private static int m3701F(Context context) {
        TelephonyManager G;
        if (m3710b(context, C1107dj.m3824c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")) && (G = m3702G(context)) != null) {
            return G.getNetworkType();
        }
        return -1;
    }

    /* renamed from: G */
    private static TelephonyManager m3702G(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    /* renamed from: a */
    public static String m3703a() {
        return f3279i;
    }

    /* renamed from: a */
    public static String m3704a(Context context) {
        try {
            if (!TextUtils.isEmpty(f3274d)) {
                return f3274d;
            }
            SDKInfo a = ConstConfig.m3835a();
            if (!InstanceFactory.m3974b(context, a)) {
                return "";
            }
            Class a2 = InstanceFactory.m3965a(context, a, C1107dj.m3824c("WY29tLmFtYXAuYXBpLmFpdW5ldC5OZXRSZXVlc3RQYXJhbQ"));
            if (a2 != null) {
                f3274d = (String) a2.getMethod("getAdiuExtras", new Class[0]).invoke(a2, new Object[0]);
            }
            return f3274d;
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r7 = r1.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0083, code lost:
        if (r7.length() == 0) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0085, code lost:
        f3276f = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0089, code lost:
        return "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008a, code lost:
        r7 = r7.substring(0, r7.length() - 1);
        f3277g = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0095, code lost:
        return r7;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0042 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x007b */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m3705a(android.content.Context r7, java.lang.String r8) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 < r1) goto L_0x0009
            java.lang.String r7 = ""
            return r7
        L_0x0009:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Throwable -> 0x0096 }
            r1 = 21
            if (r0 >= r1) goto L_0x0012
            java.lang.String r7 = ""
            return r7
        L_0x0012:
            java.lang.String r0 = f3277g     // Catch:{ Throwable -> 0x0096 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Throwable -> 0x0096 }
            if (r0 != 0) goto L_0x001d
            java.lang.String r7 = f3277g     // Catch:{ Throwable -> 0x0096 }
            return r7
        L_0x001d:
            android.telephony.TelephonyManager r7 = m3702G(r7)     // Catch:{ Throwable -> 0x0096 }
            int r0 = f3276f     // Catch:{ Throwable -> 0x0096 }
            r1 = -1
            r2 = 0
            if (r0 != r1) goto L_0x0044
            java.lang.Class<android.telephony.TelephonyManager> r0 = android.telephony.TelephonyManager.class
            java.lang.String r1 = "UZ2V0UGhvbmVDb3VudA="
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ Throwable -> 0x0096 }
            java.lang.reflect.Method r0 = com.loc.C1107dj.m3811a((java.lang.Class) r0, (java.lang.String) r1, (java.lang.Class<?>[]) r3)     // Catch:{ Throwable -> 0x0096 }
            if (r0 == 0) goto L_0x0042
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ Throwable -> 0x0042 }
            java.lang.Object r0 = r0.invoke(r7, r1)     // Catch:{ Throwable -> 0x0042 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Throwable -> 0x0042 }
            int r0 = r0.intValue()     // Catch:{ Throwable -> 0x0042 }
            f3276f = r0     // Catch:{ Throwable -> 0x0042 }
            goto L_0x0044
        L_0x0042:
            f3276f = r2     // Catch:{ Throwable -> 0x0096 }
        L_0x0044:
            java.lang.Class<android.telephony.TelephonyManager> r0 = android.telephony.TelephonyManager.class
            java.lang.String r1 = "MZ2V0SW1laQ="
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Throwable -> 0x0096 }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ Throwable -> 0x0096 }
            r4[r2] = r5     // Catch:{ Throwable -> 0x0096 }
            java.lang.reflect.Method r0 = com.loc.C1107dj.m3811a((java.lang.Class) r0, (java.lang.String) r1, (java.lang.Class<?>[]) r4)     // Catch:{ Throwable -> 0x0096 }
            if (r0 != 0) goto L_0x005a
            f3276f = r2     // Catch:{ Throwable -> 0x0096 }
            java.lang.String r7 = ""
            return r7
        L_0x005a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0096 }
            r1.<init>()     // Catch:{ Throwable -> 0x0096 }
            r4 = 0
        L_0x0060:
            int r5 = f3276f     // Catch:{ Throwable -> 0x007b }
            if (r4 >= r5) goto L_0x007b
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ Throwable -> 0x007b }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)     // Catch:{ Throwable -> 0x007b }
            r5[r2] = r6     // Catch:{ Throwable -> 0x007b }
            java.lang.Object r5 = r0.invoke(r7, r5)     // Catch:{ Throwable -> 0x007b }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Throwable -> 0x007b }
            r1.append(r5)     // Catch:{ Throwable -> 0x007b }
            r1.append(r8)     // Catch:{ Throwable -> 0x007b }
            int r4 = r4 + 1
            goto L_0x0060
        L_0x007b:
            java.lang.String r7 = r1.toString()     // Catch:{ Throwable -> 0x0096 }
            int r8 = r7.length()     // Catch:{ Throwable -> 0x0096 }
            if (r8 != 0) goto L_0x008a
            f3276f = r2     // Catch:{ Throwable -> 0x0096 }
            java.lang.String r7 = ""
            return r7
        L_0x008a:
            int r8 = r7.length()     // Catch:{ Throwable -> 0x0096 }
            int r8 = r8 - r3
            java.lang.String r7 = r7.substring(r2, r8)     // Catch:{ Throwable -> 0x0096 }
            f3277g = r7     // Catch:{ Throwable -> 0x0096 }
            return r7
        L_0x0096:
            java.lang.String r7 = ""
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.DeviceInfo.m3705a(android.content.Context, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    private static List<ScanResult> m3706a(List<ScanResult> list) {
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            for (int i2 = 1; i2 < size - i; i2++) {
                int i3 = i2 - 1;
                if (list.get(i3).level > list.get(i2).level) {
                    list.set(i3, list.get(i2));
                    list.set(i2, list.get(i3));
                }
            }
        }
        return list;
    }

    /* renamed from: a */
    public static void m3707a(String str) {
        f3279i = str;
    }

    /* renamed from: b */
    public static String m3708b(final Context context) {
        try {
            if (!TextUtils.isEmpty(f3272b)) {
                return f3272b;
            }
            SDKInfo a = ConstConfig.m3835a();
            if (a == null) {
                return null;
            }
            if (!InstanceFactory.m3974b(context, a)) {
                return "";
            }
            final Class a2 = InstanceFactory.m3965a(context, a, C1107dj.m3824c("WY29tLmFtYXAuYXBpLmFpdW5ldC5OZXRSZXVlc3RQYXJhbQ"));
            if (a2 == null) {
                return f3272b;
            }
            String str = (String) a2.getMethod("getADIU", new Class[]{Context.class}).invoke(a2, new Object[]{context});
            if (!TextUtils.isEmpty(str)) {
                f3272b = str;
                return str;
            } else if (f3280j) {
                return "";
            } else {
                f3280j = true;
                SDKLogHandler.m3869d().submit(new Runnable() {
                    public final void run() {
                        try {
                            Map map = (Map) a2.getMethod("getGetParams", new Class[0]).invoke(a2, new Object[0]);
                            if (map != null) {
                                String str = (String) a2.getMethod("getPostParam", new Class[]{String.class, String.class, String.class, String.class}).invoke(a2, new Object[]{DeviceInfo.m3719h(context), DeviceInfo.m3733v(context), DeviceInfo.m3724m(context), DeviceInfo.m3735x(context)});
                                if (!TextUtils.isEmpty(str)) {
                                    BaseNetManager.m2998a();
                                    byte[] a = BaseNetManager.m3000a(new ADIURequest(str.getBytes(), map));
                                    a2.getMethod("parseResult", new Class[]{Context.class, String.class}).invoke(a2, new Object[]{context, new String(a)});
                                }
                            }
                        } catch (Throwable unused) {
                        }
                    }
                });
                return "";
            }
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: b */
    public static void m3709b() {
        try {
            if (Build.VERSION.SDK_INT > 14) {
                TrafficStats.class.getDeclaredMethod("setThreadStatsTag", new Class[]{Integer.TYPE}).invoke((Object) null, new Object[]{40964});
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    private static boolean m3710b(Context context, String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    /* renamed from: c */
    public static long m3711c() {
        long j;
        long j2;
        if (f3288r != 0) {
            return f3288r;
        }
        try {
            StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            if (Build.VERSION.SDK_INT >= 18) {
                j2 = (statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / 1048576;
                j = (statFs2.getBlockCountLong() * statFs2.getBlockSizeLong()) / 1048576;
            } else {
                j2 = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1048576;
                j = (((long) statFs2.getBlockCount()) * ((long) statFs2.getBlockSize())) / 1048576;
            }
            f3288r = j2 + j;
        } catch (Throwable unused) {
        }
        return f3288r;
    }

    /* renamed from: c */
    public static String m3712c(Context context) {
        try {
            return m3698C(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* renamed from: d */
    public static String m3713d() {
        if (!TextUtils.isEmpty(f3290t)) {
            return f3290t;
        }
        String property = System.getProperty("os.arch");
        f3290t = property;
        return property;
    }

    /* renamed from: d */
    public static String m3714d(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            String x = m3735x(context);
            if (x != null) {
                if (x.length() >= 5) {
                    return x.substring(3, 5);
                }
            }
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* renamed from: e */
    public static int m3715e(Context context) {
        try {
            return m3701F(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    /* renamed from: e */
    private static String m3716e() {
        try {
            for (T t : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (t.getName().equalsIgnoreCase("wlan0")) {
                    byte[] bArr = null;
                    if (Build.VERSION.SDK_INT >= 9) {
                        bArr = t.getHardwareAddress();
                    }
                    if (bArr == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte b : bArr) {
                        String upperCase = Integer.toHexString(b & 255).toUpperCase();
                        if (upperCase.length() == 1) {
                            sb.append("0");
                        }
                        sb.append(upperCase);
                        sb.append(SystemInfoUtil.COLON);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: f */
    public static int m3717f(Context context) {
        try {
            return m3699D(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    /* renamed from: g */
    public static String m3718g(Context context) {
        try {
            return m3697B(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:7|(1:9)|10|(2:14|15)|16|17|18|(1:21)(2:22|23)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x003a */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0047  */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m3719h(android.content.Context r2) {
        /*
            java.lang.String r0 = f3271a     // Catch:{ Throwable -> 0x003a }
            if (r0 == 0) goto L_0x0011
            java.lang.String r0 = ""
            java.lang.String r1 = f3271a     // Catch:{ Throwable -> 0x003a }
            boolean r0 = r0.equals(r1)     // Catch:{ Throwable -> 0x003a }
            if (r0 != 0) goto L_0x0011
            java.lang.String r0 = f3271a     // Catch:{ Throwable -> 0x003a }
            return r0
        L_0x0011:
            java.lang.String r0 = "WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT"
            java.lang.String r0 = com.loc.C1107dj.m3824c((java.lang.String) r0)     // Catch:{ Throwable -> 0x003a }
            boolean r0 = m3710b(r2, r0)     // Catch:{ Throwable -> 0x003a }
            if (r0 == 0) goto L_0x0029
            android.content.ContentResolver r0 = r2.getContentResolver()     // Catch:{ Throwable -> 0x003a }
            java.lang.String r1 = "mqBRboGZkQPcAkyk"
            java.lang.String r0 = android.provider.Settings.System.getString(r0, r1)     // Catch:{ Throwable -> 0x003a }
            f3271a = r0     // Catch:{ Throwable -> 0x003a }
        L_0x0029:
            java.lang.String r0 = f3271a     // Catch:{ Throwable -> 0x003a }
            if (r0 == 0) goto L_0x003a
            java.lang.String r0 = ""
            java.lang.String r1 = f3271a     // Catch:{ Throwable -> 0x003a }
            boolean r0 = r0.equals(r1)     // Catch:{ Throwable -> 0x003a }
            if (r0 != 0) goto L_0x003a
            java.lang.String r0 = f3271a     // Catch:{ Throwable -> 0x003a }
            return r0
        L_0x003a:
            java.lang.String r2 = m3696A(r2)     // Catch:{ Throwable -> 0x0040 }
            f3271a = r2     // Catch:{ Throwable -> 0x0040 }
        L_0x0040:
            java.lang.String r2 = f3271a
            if (r2 != 0) goto L_0x0047
            java.lang.String r2 = ""
            return r2
        L_0x0047:
            java.lang.String r2 = f3271a
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.DeviceInfo.m3719h(android.content.Context):java.lang.String");
    }

    /* renamed from: i */
    public static String m3720i(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        if (!TextUtils.isEmpty(f3282l)) {
            return f3282l;
        }
        if (!m3710b(context, C1107dj.m3824c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return "";
        }
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                return (String) C1107dj.m3811a(Build.class, "MZ2V0U2VyaWFs", (Class<?>[]) new Class[0]).invoke(Build.class, new Object[0]);
            }
            if (Build.VERSION.SDK_INT >= 9) {
                f3282l = Build.SERIAL;
            }
            return f3282l == null ? "" : f3282l;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: j */
    public static String m3721j(Context context) {
        if (!TextUtils.isEmpty(f3281k)) {
            return f3281k;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), C1107dj.m3824c(new String(ConstConfig.m3836a(13))));
            f3281k = string;
            return string == null ? "" : f3281k;
        } catch (Throwable unused) {
            return f3281k;
        }
    }

    /* renamed from: k */
    static String m3722k(Context context) {
        if (context == null) {
            return "";
        }
        try {
            if (!m3710b(context, C1107dj.m3824c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
                return "";
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            return (wifiManager != null && wifiManager.isWifiEnabled()) ? wifiManager.getConnectionInfo().getBSSID() : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: l */
    static String m3723l(Context context) {
        StringBuilder sb = new StringBuilder();
        if (context != null) {
            try {
                if (m3710b(context, C1107dj.m3824c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
                    WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                    if (wifiManager == null) {
                        return "";
                    }
                    if (wifiManager.isWifiEnabled()) {
                        List<ScanResult> scanResults = wifiManager.getScanResults();
                        if (scanResults != null) {
                            if (scanResults.size() != 0) {
                                List<ScanResult> a = m3706a(scanResults);
                                int i = 0;
                                boolean z = true;
                                while (i < a.size() && i < 7) {
                                    ScanResult scanResult = a.get(i);
                                    if (z) {
                                        z = false;
                                    } else {
                                        sb.append(Constants.PACKNAME_END);
                                    }
                                    sb.append(scanResult.BSSID);
                                    i++;
                                }
                            }
                        }
                        return sb.toString();
                    }
                    return sb.toString();
                }
            } catch (Throwable unused) {
            }
        }
        return sb.toString();
    }

    /* renamed from: m */
    public static String m3724m(Context context) {
        try {
            if (f3283m != null && !"".equals(f3283m)) {
                return f3283m;
            }
            if (!m3710b(context, C1107dj.m3824c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
                return f3283m;
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null) {
                return "";
            }
            f3283m = wifiManager.getConnectionInfo().getMacAddress();
            if (C1107dj.m3824c("YMDI6MDA6MDA6MDA6MDA6MDA").equals(f3283m) || C1107dj.m3824c("YMDA6MDA6MDA6MDA6MDA6MDA").equals(f3283m)) {
                f3283m = m3716e();
            }
            return f3283m;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: n */
    static String[] m3725n(Context context) {
        try {
            if (m3710b(context, C1107dj.m3824c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                if (m3710b(context, C1107dj.m3824c("EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04="))) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager == null) {
                        return new String[]{"", ""};
                    }
                    CellLocation cellLocation = telephonyManager.getCellLocation();
                    if (cellLocation instanceof GsmCellLocation) {
                        GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                        int cid = gsmCellLocation.getCid();
                        int lac = gsmCellLocation.getLac();
                        return new String[]{lac + "||" + cid, "gsm"};
                    }
                    if (cellLocation instanceof CdmaCellLocation) {
                        CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                        int systemId = cdmaCellLocation.getSystemId();
                        int networkId = cdmaCellLocation.getNetworkId();
                        int baseStationId = cdmaCellLocation.getBaseStationId();
                        return new String[]{systemId + "||" + networkId + "||" + baseStationId, "cdma"};
                    }
                    return new String[]{"", ""};
                }
            }
            return new String[]{"", ""};
        } catch (Throwable unused) {
        }
    }

    /* renamed from: o */
    static String m3726o(Context context) {
        try {
            TelephonyManager G = m3702G(context);
            if (G == null) {
                return "";
            }
            String networkOperator = G.getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator)) {
                if (networkOperator.length() >= 3) {
                    return networkOperator.substring(0, 3);
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: p */
    static String m3727p(Context context) {
        try {
            TelephonyManager G = m3702G(context);
            if (G == null) {
                return "";
            }
            String networkOperator = G.getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator)) {
                if (networkOperator.length() >= 3) {
                    return networkOperator.substring(3);
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: q */
    public static int m3728q(Context context) {
        try {
            return m3701F(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* renamed from: r */
    public static int m3729r(Context context) {
        try {
            return m3699D(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* renamed from: s */
    public static NetworkInfo m3730s(Context context) {
        ConnectivityManager E;
        if (m3710b(context, C1107dj.m3824c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && (E = m3700E(context)) != null) {
            return E.getActiveNetworkInfo();
        }
        return null;
    }

    /* renamed from: t */
    static String m3731t(Context context) {
        try {
            NetworkInfo s = m3730s(context);
            if (s == null) {
                return null;
            }
            return s.getExtraInfo();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: u */
    static String m3732u(Context context) {
        StringBuilder sb;
        try {
            if (f3284n != null && !"".equals(f3284n)) {
                return f3284n;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return "";
            }
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            if (i2 > i) {
                sb = new StringBuilder();
                sb.append(i);
                sb.append("*");
                sb.append(i2);
            } else {
                sb = new StringBuilder();
                sb.append(i2);
                sb.append("*");
                sb.append(i);
            }
            f3284n = sb.toString();
            return f3284n;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: v */
    public static String m3733v(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                return "";
            }
            if (f3285o != null && !"".equals(f3285o)) {
                return f3285o;
            }
            if (!m3710b(context, C1107dj.m3824c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return f3285o;
            }
            TelephonyManager G = m3702G(context);
            if (G == null) {
                return "";
            }
            Method a = C1107dj.m3811a((Class) G.getClass(), "QZ2V0RGV2aWNlSWQ", (Class<?>[]) new Class[0]);
            if (Build.VERSION.SDK_INT >= 26) {
                a = C1107dj.m3811a((Class) G.getClass(), "QZ2V0SW1laQ==", (Class<?>[]) new Class[0]);
            }
            if (a != null) {
                f3285o = (String) a.invoke(G, new Object[0]);
            }
            if (f3285o == null) {
                f3285o = "";
            }
            return f3285o;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: w */
    public static String m3734w(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            if (f3286p != null && !"".equals(f3286p)) {
                return f3286p;
            }
            if (!m3710b(context, C1107dj.m3824c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return f3286p;
            }
            TelephonyManager G = m3702G(context);
            if (G == null) {
                return "";
            }
            if (Build.VERSION.SDK_INT >= 26) {
                Method a = C1107dj.m3811a((Class) G.getClass(), "QZ2V0TWVpZA==", (Class<?>[]) new Class[0]);
                if (a != null) {
                    f3286p = (String) a.invoke(G, new Object[0]);
                }
                if (f3286p == null) {
                    f3286p = "";
                }
            }
            return f3286p;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: x */
    public static String m3735x(Context context) {
        try {
            return m3697B(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x005d A[SYNTHETIC, Splitter:B:25:0x005d] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0063 A[SYNTHETIC, Splitter:B:31:0x0063] */
    /* renamed from: y */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m3736y(android.content.Context r4) {
        /*
            int r0 = f3289s
            if (r0 == 0) goto L_0x0007
            int r4 = f3289s
            return r4
        L_0x0007:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 16
            r2 = 0
            if (r0 < r1) goto L_0x0028
            java.lang.String r0 = "activity"
            java.lang.Object r4 = r4.getSystemService(r0)
            android.app.ActivityManager r4 = (android.app.ActivityManager) r4
            if (r4 != 0) goto L_0x0019
            return r2
        L_0x0019:
            android.app.ActivityManager$MemoryInfo r0 = new android.app.ActivityManager$MemoryInfo
            r0.<init>()
            r4.getMemoryInfo(r0)
            long r0 = r0.totalMem
            r2 = 1024(0x400, double:5.06E-321)
            long r0 = r0 / r2
            int r2 = (int) r0
            goto L_0x0066
        L_0x0028:
            r4 = 0
            java.io.File r0 = new java.io.File     // Catch:{ Throwable -> 0x0061, all -> 0x005a }
            java.lang.String r1 = "/proc/meminfo"
            r0.<init>(r1)     // Catch:{ Throwable -> 0x0061, all -> 0x005a }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Throwable -> 0x0061, all -> 0x005a }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ Throwable -> 0x0061, all -> 0x005a }
            r3.<init>(r0)     // Catch:{ Throwable -> 0x0061, all -> 0x005a }
            r1.<init>(r3)     // Catch:{ Throwable -> 0x0061, all -> 0x005a }
            java.lang.String r4 = r1.readLine()     // Catch:{ Throwable -> 0x0058, all -> 0x0054 }
            java.lang.String r0 = "\\s+"
            java.lang.String[] r4 = r4.split(r0)     // Catch:{ Throwable -> 0x0058, all -> 0x0054 }
            r0 = 1
            r4 = r4[r0]     // Catch:{ Throwable -> 0x0058, all -> 0x0054 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Throwable -> 0x0058, all -> 0x0054 }
            int r4 = r4.intValue()     // Catch:{ Throwable -> 0x0058, all -> 0x0054 }
            r1.close()     // Catch:{ IOException -> 0x0052 }
        L_0x0052:
            r2 = r4
            goto L_0x0066
        L_0x0054:
            r4 = move-exception
            r0 = r4
            r4 = r1
            goto L_0x005b
        L_0x0058:
            r4 = r1
            goto L_0x0061
        L_0x005a:
            r0 = move-exception
        L_0x005b:
            if (r4 == 0) goto L_0x0060
            r4.close()     // Catch:{ IOException -> 0x0060 }
        L_0x0060:
            throw r0
        L_0x0061:
            if (r4 == 0) goto L_0x0066
            r4.close()     // Catch:{ IOException -> 0x0066 }
        L_0x0066:
            int r2 = r2 / 1024
            f3289s = r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.DeviceInfo.m3736y(android.content.Context):int");
    }

    /* renamed from: z */
    static String m3737z(Context context) {
        try {
            return m3698C(context);
        } catch (Throwable unused) {
            return "";
        }
    }
}
