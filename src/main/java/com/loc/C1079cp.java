package com.loc;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.location.Location;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.MotionEventCompat;
import com.amap.api.location.AMapLocation;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.baidu.p020ar.util.SystemInfoUtil;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.networking.common.ANConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import org.json.JSONObject;

/* renamed from: com.loc.cp */
/* compiled from: Utils */
public final class C1079cp {

    /* renamed from: a */
    static WifiManager f3068a = null;

    /* renamed from: b */
    private static int f3069b;

    /* renamed from: c */
    private static String[] f3070c;

    /* renamed from: d */
    private static Hashtable<String, Long> f3071d = new Hashtable<>();

    /* renamed from: e */
    private static SparseArray<String> f3072e = null;

    /* renamed from: f */
    private static String[] f3073f = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};

    /* renamed from: g */
    private static String f3074g = "android.permission.ACCESS_BACKGROUND_LOCATION";

    /* renamed from: h */
    private static boolean f3075h = false;

    /* renamed from: a */
    public static double m3495a(double d) {
        return ((double) ((long) (d * 1000000.0d))) / 1000000.0d;
    }

    /* renamed from: a */
    public static float m3496a(float f) {
        return (float) (((double) ((long) (((double) f) * 100.0d))) / 100.0d);
    }

    /* renamed from: a */
    public static float m3497a(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        return m3498a(new double[]{aMapLocation.getLatitude(), aMapLocation.getLongitude(), aMapLocation2.getLatitude(), aMapLocation2.getLongitude()});
    }

    /* renamed from: a */
    public static float m3498a(double[] dArr) {
        if (dArr.length != 4) {
            return 0.0f;
        }
        float[] fArr = new float[1];
        Location.distanceBetween(dArr[0], dArr[1], dArr[2], dArr[3], fArr);
        return fArr[0];
    }

    /* renamed from: a */
    public static int m3499a(int i) {
        return (i * 2) - 113;
    }

    /* renamed from: a */
    public static int m3500a(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            return networkInfo.getType();
        }
        return -1;
    }

    /* renamed from: a */
    public static Object m3501a(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return context.getApplicationContext().getSystemService(str);
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "Utils", "getServ");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002e  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m3502a(long r4, java.lang.String r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L_0x0008
            java.lang.String r6 = "yyyy-MM-dd HH:mm:ss"
        L_0x0008:
            r0 = 0
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat     // Catch:{ Throwable -> 0x0016 }
            java.util.Locale r2 = java.util.Locale.CHINA     // Catch:{ Throwable -> 0x0016 }
            r1.<init>(r6, r2)     // Catch:{ Throwable -> 0x0016 }
            r1.applyPattern(r6)     // Catch:{ Throwable -> 0x0014 }
            goto L_0x001f
        L_0x0014:
            r6 = move-exception
            goto L_0x0018
        L_0x0016:
            r6 = move-exception
            r1 = r0
        L_0x0018:
            java.lang.String r0 = "Utils"
            java.lang.String r2 = "formatUTC"
            com.loc.CoreUtil.m3389a(r6, r0, r2)
        L_0x001f:
            r2 = 0
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 > 0) goto L_0x0029
            long r4 = java.lang.System.currentTimeMillis()
        L_0x0029:
            if (r1 != 0) goto L_0x002e
            java.lang.String r4 = "NULL"
            return r4
        L_0x002e:
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            java.lang.String r4 = r1.format(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.C1079cp.m3502a(long, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static void m3503a() {
    }

    /* renamed from: a */
    public static boolean m3504a(long j, long j2) {
        String a = m3502a(j, "yyyyMMddHH");
        String a2 = m3502a(j2, "yyyyMMddHH");
        if ("NULL".equals(a) || "NULL".equals(a2)) {
            return false;
        }
        return a.equals(a2);
    }

    /* renamed from: a */
    public static boolean m3505a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return m3535d() < 17 ? m3538d(context, "android.provider.Settings$System") : m3538d(context, "android.provider.Settings$Global");
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m3506a(android.database.sqlite.SQLiteDatabase r6, java.lang.String r7) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.lang.String r0 = "2.0.201501131131"
            java.lang.String r2 = "."
            java.lang.String r3 = ""
            java.lang.String r0 = r0.replace(r2, r3)
            if (r6 == 0) goto L_0x006e
            r2 = 1
            r3 = 0
            boolean r4 = r6.isOpen()     // Catch:{ Throwable -> 0x0066, all -> 0x005f }
            if (r4 != 0) goto L_0x001d
            goto L_0x006e
        L_0x001d:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0066, all -> 0x005f }
            r4.<init>()     // Catch:{ Throwable -> 0x0066, all -> 0x005f }
            java.lang.String r5 = "SELECT count(*) as c FROM sqlite_master WHERE type = 'table' AND name = '"
            r4.append(r5)     // Catch:{ Throwable -> 0x0066, all -> 0x005f }
            java.lang.String r7 = r7.trim()     // Catch:{ Throwable -> 0x0066, all -> 0x005f }
            r4.append(r7)     // Catch:{ Throwable -> 0x0066, all -> 0x005f }
            r4.append(r0)     // Catch:{ Throwable -> 0x0066, all -> 0x005f }
            java.lang.String r7 = "' "
            r4.append(r7)     // Catch:{ Throwable -> 0x0066, all -> 0x005f }
            java.lang.String r7 = r4.toString()     // Catch:{ Throwable -> 0x0066, all -> 0x005f }
            android.database.Cursor r6 = r6.rawQuery(r7, r3)     // Catch:{ Throwable -> 0x0066, all -> 0x005f }
            if (r6 == 0) goto L_0x0051
            boolean r7 = r6.moveToFirst()     // Catch:{ Throwable -> 0x0067, all -> 0x004e }
            if (r7 == 0) goto L_0x0051
            int r7 = r6.getInt(r1)     // Catch:{ Throwable -> 0x0067, all -> 0x004e }
            if (r7 <= 0) goto L_0x0051
            r7 = 1
            goto L_0x0052
        L_0x004e:
            r7 = move-exception
            r3 = r6
            goto L_0x0060
        L_0x0051:
            r7 = 0
        L_0x0052:
            int r0 = r4.length()     // Catch:{ Throwable -> 0x0067, all -> 0x004e }
            r4.delete(r1, r0)     // Catch:{ Throwable -> 0x0067, all -> 0x004e }
            if (r6 == 0) goto L_0x006d
            r6.close()
            goto L_0x006d
        L_0x005f:
            r7 = move-exception
        L_0x0060:
            if (r3 == 0) goto L_0x0065
            r3.close()
        L_0x0065:
            throw r7
        L_0x0066:
            r6 = r3
        L_0x0067:
            if (r6 == 0) goto L_0x006c
            r6.close()
        L_0x006c:
            r7 = 1
        L_0x006d:
            return r7
        L_0x006e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.C1079cp.m3506a(android.database.sqlite.SQLiteDatabase, java.lang.String):boolean");
    }

    /* renamed from: a */
    public static boolean m3507a(Location location, int i) {
        Boolean bool = false;
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                bool = (Boolean) Reflect.m3412a((Object) location, "isFromMockProvider", new Object[0]);
            } catch (Throwable unused) {
            }
        }
        if (bool.booleanValue()) {
            return true;
        }
        Bundle extras = location.getExtras();
        if ((extras != null ? extras.getInt("satellites") : 0) <= 0) {
            return true;
        }
        return i == 0 && location.getAltitude() == 0.0d && location.getBearing() == 0.0f && location.getSpeed() == 0.0f;
    }

    /* renamed from: a */
    public static boolean m3508a(AMapLocation aMapLocation) {
        if (aMapLocation != null && aMapLocation.mo8484c() == 0) {
            return m3525b(aMapLocation);
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m3509a(AMapLocationServer aMapLocationServer) {
        if (aMapLocationServer != null && !"8".equals(aMapLocationServer.mo8796C()) && !"5".equals(aMapLocationServer.mo8796C()) && !"6".equals(aMapLocationServer.mo8796C())) {
            return m3525b((AMapLocation) aMapLocationServer);
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m3510a(String str) {
        return !TextUtils.isEmpty(str) && !"00:00:00:00:00:00".equals(str) && !str.contains(" :");
    }

    /* renamed from: a */
    public static boolean m3511a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ArrayList<String> d = m3536d(str);
            String[] split = str2.toString().split("#");
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < split.length; i3++) {
                if (split[i3].contains(",nb") || split[i3].contains(",access")) {
                    i++;
                    if (d.contains(split[i3])) {
                        i2++;
                    }
                }
            }
            if (((double) (i2 * 2)) >= ((double) (d.size() + i)) * 0.618d) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m3512a(JSONObject jSONObject, String str) {
        return C1107dj.m3817a(jSONObject, str);
    }

    /* renamed from: a */
    public static byte[] m3513a(int i, byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            bArr = new byte[2];
        }
        bArr[0] = (byte) (i & 255);
        bArr[1] = (byte) ((i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8);
        return bArr;
    }

    /* renamed from: a */
    public static byte[] m3514a(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) ((int) ((j >> (i * 8)) & 255));
        }
        return bArr;
    }

    /* renamed from: a */
    public static byte[] m3515a(byte[] bArr) {
        try {
            return C1107dj.m3823b(bArr);
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "Utils", "gz");
            return null;
        }
    }

    /* renamed from: a */
    public static String[] m3516a(TelephonyManager telephonyManager) {
        int i;
        String networkOperator = telephonyManager != null ? telephonyManager.getNetworkOperator() : null;
        String[] strArr = {"0", "0"};
        if (!TextUtils.isEmpty(networkOperator) && TextUtils.isDigitsOnly(networkOperator) && networkOperator.length() > 4) {
            strArr[0] = networkOperator.substring(0, 3);
            char[] charArray = networkOperator.substring(3).toCharArray();
            int i2 = 0;
            while (i2 < charArray.length && Character.isDigit(charArray[i2])) {
                i2++;
            }
            strArr[1] = networkOperator.substring(3, i2 + 3);
        }
        try {
            i = Integer.parseInt(strArr[0]);
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "Utils", "getMccMnc");
            i = 0;
        }
        if (i == 0) {
            strArr[0] = "0";
        }
        if ("0".equals(strArr[0]) || "0".equals(strArr[1])) {
            return (!"0".equals(strArr[0]) || !"0".equals(strArr[1]) || f3070c == null) ? strArr : f3070c;
        }
        f3070c = strArr;
        return strArr;
    }

    /* renamed from: b */
    public static double m3517b(double d) {
        return ((double) ((long) (d * 100.0d))) / 100.0d;
    }

    /* renamed from: b */
    public static long m3518b() {
        return System.currentTimeMillis();
    }

    /* renamed from: b */
    public static String m3519b(int i) {
        switch (i) {
            case 0:
                return ANConstants.SUCCESS;
            case 1:
                return "重要参数为空";
            case 2:
                return "WIFI信息不足";
            case 3:
                return "请求参数获取出现异常";
            case 4:
                return "网络连接异常";
            case 5:
                return "解析数据异常";
            case 6:
                return "定位结果错误";
            case 7:
                return "KEY错误";
            case 8:
                return "其他错误";
            case 9:
                return "初始化异常";
            case 10:
                return "定位服务启动失败";
            case 11:
                return "错误的基站信息，请检查是否插入SIM卡";
            case 12:
                return "缺少定位权限";
            case 13:
                return "网络定位失败，请检查设备是否插入sim卡，是否开启移动网络或开启了wifi模块";
            case 14:
                return "GPS 定位失败，由于设备当前 GPS 状态差,建议持设备到相对开阔的露天场所再次尝试";
            case 15:
                return "当前返回位置为模拟软件返回，请关闭模拟软件，或者在option中设置允许模拟";
            case 18:
                return "定位失败，飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关";
            case 19:
                return "定位失败，没有检查到SIM卡，并且关闭了WIFI开关，请打开WIFI开关或者插入SIM卡";
            default:
                return "其他错误";
        }
    }

    /* renamed from: b */
    public static String m3520b(Context context) {
        PackageInfo packageInfo;
        if (!TextUtils.isEmpty(CoreUtil.f2983g)) {
            return CoreUtil.f2983g;
        }
        CharSequence charSequence = null;
        if (context == null) {
            return null;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(AppInfo.m3663c(context), 64);
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "Utils", "getAppName part");
            packageInfo = null;
        }
        try {
            if (TextUtils.isEmpty(CoreUtil.f2984h)) {
                CoreUtil.f2984h = null;
            }
        } catch (Throwable th2) {
            CoreUtil.m3389a(th2, "Utils", "getAppName");
        }
        StringBuilder sb = new StringBuilder();
        if (packageInfo != null) {
            if (packageInfo.applicationInfo != null) {
                charSequence = packageInfo.applicationInfo.loadLabel(context.getPackageManager());
            }
            if (charSequence != null) {
                sb.append(charSequence.toString());
            }
            if (!TextUtils.isEmpty(packageInfo.versionName)) {
                sb.append(packageInfo.versionName);
            }
        }
        String c = AppInfo.m3663c(context);
        if (!TextUtils.isEmpty(c)) {
            sb.append(SystemInfoUtil.COMMA);
            sb.append(c);
        }
        if (!TextUtils.isEmpty(CoreUtil.f2984h)) {
            sb.append(SystemInfoUtil.COMMA);
            sb.append(CoreUtil.f2984h);
        }
        String sb2 = sb.toString();
        CoreUtil.f2983g = sb2;
        return sb2;
    }

    /* renamed from: b */
    public static String m3521b(TelephonyManager telephonyManager) {
        int i = 0;
        if (f3072e == null) {
            SparseArray<String> sparseArray = new SparseArray<>();
            f3072e = sparseArray;
            sparseArray.append(0, "UNKWN");
            f3072e.append(1, "GPRS");
            f3072e.append(2, "EDGE");
            f3072e.append(3, "UMTS");
            f3072e.append(4, "CDMA");
            f3072e.append(5, "EVDO_0");
            f3072e.append(6, "EVDO_A");
            f3072e.append(7, "1xRTT");
            f3072e.append(8, "HSDPA");
            f3072e.append(9, "HSUPA");
            f3072e.append(10, "HSPA");
            f3072e.append(11, "IDEN");
            f3072e.append(12, "EVDO_B");
            f3072e.append(13, "LTE");
            f3072e.append(14, "EHRPD");
            f3072e.append(15, "HSPAP");
        }
        if (telephonyManager != null) {
            try {
                i = telephonyManager.getNetworkType();
            } catch (Throwable unused) {
            }
        }
        return f3072e.get(i, "UNKWN");
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v2, types: [java.util.zip.ZipInputStream] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v5, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:24|(1:26)|27|(4:28|29|30|(1:32)(1:74))|33|34|35|72|69) */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ae, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00af, code lost:
        r0 = r7;
        r7 = r8;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0037 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x00a2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0037 A[LOOP:0: B:11:0x0037->B:69:0x0037, LOOP_START, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009f A[SYNTHETIC, Splitter:B:40:0x009f] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ae A[ExcHandler: all (r8v4 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:34:0x0095] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0037 A[SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m3522b(java.lang.String r7, java.lang.String r8) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ Throwable -> 0x00b9 }
            r1.<init>(r7)     // Catch:{ Throwable -> 0x00b9 }
            boolean r7 = r1.exists()     // Catch:{ Throwable -> 0x00b9 }
            if (r7 == 0) goto L_0x00b6
            boolean r7 = r1.isDirectory()     // Catch:{ Throwable -> 0x00b9 }
            if (r7 == 0) goto L_0x0014
            goto L_0x00b6
        L_0x0014:
            java.lang.String r7 = java.io.File.separator     // Catch:{ Throwable -> 0x00b9 }
            boolean r7 = r8.endsWith(r7)     // Catch:{ Throwable -> 0x00b9 }
            if (r7 != 0) goto L_0x002d
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00b9 }
            r7.<init>()     // Catch:{ Throwable -> 0x00b9 }
            r7.append(r8)     // Catch:{ Throwable -> 0x00b9 }
            java.lang.String r8 = java.io.File.separator     // Catch:{ Throwable -> 0x00b9 }
            r7.append(r8)     // Catch:{ Throwable -> 0x00b9 }
            java.lang.String r8 = r7.toString()     // Catch:{ Throwable -> 0x00b9 }
        L_0x002d:
            java.util.zip.ZipInputStream r7 = new java.util.zip.ZipInputStream     // Catch:{ Throwable -> 0x00b9 }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x00b9 }
            r2.<init>(r1)     // Catch:{ Throwable -> 0x00b9 }
            r7.<init>(r2)     // Catch:{ Throwable -> 0x00b9 }
        L_0x0037:
            java.util.zip.ZipEntry r1 = r7.getNextEntry()     // Catch:{ Throwable -> 0x00b2, all -> 0x00ae }
            if (r1 == 0) goto L_0x00a7
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r2]     // Catch:{ Exception -> 0x00a3, all -> 0x009c }
            java.lang.String r4 = r1.getName()     // Catch:{ Exception -> 0x00a3, all -> 0x009c }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x00a3, all -> 0x009c }
            if (r5 != 0) goto L_0x00a7
            java.lang.String r5 = "../"
            boolean r5 = r4.contains(r5)     // Catch:{ Exception -> 0x00a3, all -> 0x009c }
            if (r5 == 0) goto L_0x0054
            goto L_0x00a7
        L_0x0054:
            boolean r1 = r1.isDirectory()     // Catch:{ Exception -> 0x00a3, all -> 0x009c }
            if (r1 == 0) goto L_0x005b
            goto L_0x0037
        L_0x005b:
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x00a3, all -> 0x009c }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a3, all -> 0x009c }
            r5.<init>()     // Catch:{ Exception -> 0x00a3, all -> 0x009c }
            r5.append(r8)     // Catch:{ Exception -> 0x00a3, all -> 0x009c }
            r5.append(r4)     // Catch:{ Exception -> 0x00a3, all -> 0x009c }
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x00a3, all -> 0x009c }
            r1.<init>(r4)     // Catch:{ Exception -> 0x00a3, all -> 0x009c }
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x00a3, all -> 0x009c }
            java.lang.String r5 = r1.getParent()     // Catch:{ Exception -> 0x00a3, all -> 0x009c }
            r4.<init>(r5)     // Catch:{ Exception -> 0x00a3, all -> 0x009c }
            boolean r5 = r4.exists()     // Catch:{ Exception -> 0x00a3, all -> 0x009c }
            if (r5 != 0) goto L_0x0081
            r4.mkdirs()     // Catch:{ Exception -> 0x00a3, all -> 0x009c }
        L_0x0081:
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00a3, all -> 0x009c }
            r4.<init>(r1)     // Catch:{ Exception -> 0x00a3, all -> 0x009c }
        L_0x0086:
            r1 = 0
            int r5 = r7.read(r3, r1, r2)     // Catch:{ Exception -> 0x00a4, all -> 0x0099 }
            r6 = -1
            if (r5 == r6) goto L_0x0092
            r4.write(r3, r1, r5)     // Catch:{ Exception -> 0x00a4, all -> 0x0099 }
            goto L_0x0086
        L_0x0092:
            r4.flush()     // Catch:{ Exception -> 0x00a4, all -> 0x0099 }
        L_0x0095:
            r4.close()     // Catch:{ Throwable -> 0x0037, all -> 0x00ae }
            goto L_0x0037
        L_0x0099:
            r8 = move-exception
            r0 = r4
            goto L_0x009d
        L_0x009c:
            r8 = move-exception
        L_0x009d:
            if (r0 == 0) goto L_0x00a2
            r0.close()     // Catch:{ Throwable -> 0x00a2, all -> 0x00ae }
        L_0x00a2:
            throw r8     // Catch:{ Throwable -> 0x00b2, all -> 0x00ae }
        L_0x00a3:
            r4 = r0
        L_0x00a4:
            if (r4 == 0) goto L_0x0037
            goto L_0x0095
        L_0x00a7:
            r7.closeEntry()     // Catch:{ Throwable -> 0x00ad }
            r7.close()     // Catch:{ Throwable -> 0x00ad }
        L_0x00ad:
            return
        L_0x00ae:
            r8 = move-exception
            r0 = r7
            r7 = r8
            goto L_0x00ca
        L_0x00b2:
            r8 = move-exception
            r0 = r7
            r7 = r8
            goto L_0x00ba
        L_0x00b6:
            return
        L_0x00b7:
            r7 = move-exception
            goto L_0x00ca
        L_0x00b9:
            r7 = move-exception
        L_0x00ba:
            java.lang.String r8 = "Utils"
            java.lang.String r1 = "unZip"
            com.loc.CoreUtil.m3389a(r7, r8, r1)     // Catch:{ all -> 0x00b7 }
            if (r0 == 0) goto L_0x00c9
            r0.closeEntry()     // Catch:{ Throwable -> 0x00c9 }
            r0.close()     // Catch:{ Throwable -> 0x00c9 }
        L_0x00c9:
            return
        L_0x00ca:
            if (r0 == 0) goto L_0x00d2
            r0.closeEntry()     // Catch:{ Throwable -> 0x00d2 }
            r0.close()     // Catch:{ Throwable -> 0x00d2 }
        L_0x00d2:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.C1079cp.m3522b(java.lang.String, java.lang.String):void");
    }

    /* renamed from: b */
    public static boolean m3523b(long j, long j2) {
        String a = m3502a(j, "yyyyMMdd");
        String a2 = m3502a(j2, "yyyyMMdd");
        if ("NULL".equals(a) || "NULL".equals(a2)) {
            return false;
        }
        return a.equals(a2);
    }

    /* renamed from: b */
    public static boolean m3524b(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m3525b(AMapLocation aMapLocation) {
        double longitude = aMapLocation.getLongitude();
        double latitude = aMapLocation.getLatitude();
        return !(longitude == 0.0d && latitude == 0.0d) && longitude <= 180.0d && latitude <= 90.0d && longitude >= -180.0d && latitude >= -90.0d;
    }

    /* renamed from: b */
    public static byte[] m3526b(int i, byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            bArr = new byte[4];
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = (byte) ((i >> (i2 * 8)) & 255);
        }
        return bArr;
    }

    /* renamed from: b */
    public static byte[] m3527b(String str) {
        return m3513a(Integer.parseInt(str), (byte[]) null);
    }

    /* renamed from: c */
    public static double m3528c(double d) {
        return ((double) ((long) (d * 1000000.0d))) / 1000000.0d;
    }

    /* renamed from: c */
    public static long m3529c() {
        return SystemClock.elapsedRealtime();
    }

    /* renamed from: c */
    public static NetworkInfo m3530c(Context context) {
        try {
            return DeviceInfo.m3730s(context);
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "Utils", "getNetWorkInfo");
            return null;
        }
    }

    /* renamed from: c */
    public static boolean m3531c(long j, long j2) {
        if (!m3523b(j, j2)) {
            return false;
        }
        Calendar instance = Calendar.getInstance(Locale.CHINA);
        instance.setTimeInMillis(j);
        int i = instance.get(11);
        instance.setTimeInMillis(j2);
        int i2 = instance.get(11);
        if (i > 12) {
            if (i2 > 12) {
                return true;
            }
        } else if (i2 <= 12) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m3532c(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(str, 256);
        } catch (Throwable unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    /* renamed from: c */
    public static boolean m3533c(String str, String str2) {
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory() && file2.getName().equals(str2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public static byte[] m3534c(String str) {
        return m3526b(Integer.parseInt(str), (byte[]) null);
    }

    /* renamed from: d */
    public static int m3535d() {
        if (f3069b > 0) {
            return f3069b;
        }
        try {
            return Reflect.m3417b("android.os.Build$VERSION", "SDK_INT");
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* renamed from: d */
    public static ArrayList<String> m3536d(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("#");
            for (int i = 0; i < split.length; i++) {
                if (split[i].contains(",nb") || split[i].contains(",access")) {
                    arrayList.add(split[i]);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    public static boolean m3537d(Context context) {
        try {
            NetworkInfo c = m3530c(context);
            return c != null && c.isConnectedOrConnecting();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: d */
    private static boolean m3538d(Context context, String str) throws Throwable {
        return ((Integer) Reflect.m3414a(str, "getInt", new Object[]{context.getContentResolver(), ((String) Reflect.m3413a(str, "AIRPLANE_MODE_ON")).toString()}, (Class<?>[]) new Class[]{ContentResolver.class, String.class})).intValue() == 1;
    }

    /* renamed from: e */
    public static String m3539e() {
        return Build.MODEL;
    }

    /* renamed from: e */
    public static void m3540e(String str) {
        try {
            if (!str.endsWith(File.separator)) {
                str = str + File.separator;
            }
            File file = new File(str);
            if (!file.exists()) {
                return;
            }
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    if (file2.isDirectory()) {
                        m3540e(file2.getAbsolutePath());
                    } else {
                        file2.delete();
                    }
                }
                file.delete();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: e */
    public static boolean m3541e(Context context) {
        try {
            Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.processName.equals(AppInfo.m3663c(context))) {
                    if (next.importance != 100) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "Utils", "isApplicationBroughtToBackground");
            return true;
        }
    }

    /* renamed from: f */
    public static double m3542f(String str) throws NumberFormatException {
        return Double.parseDouble(str);
    }

    /* renamed from: f */
    public static String m3543f() {
        return Build.VERSION.RELEASE;
    }

    /* renamed from: f */
    public static boolean m3544f(Context context) {
        int i;
        if (Build.VERSION.SDK_INT < 23 || context.getApplicationInfo().targetSdkVersion < 23) {
            for (String checkCallingOrSelfPermission : f3073f) {
                if (context.checkCallingOrSelfPermission(checkCallingOrSelfPermission) != 0) {
                    return false;
                }
            }
        } else {
            Application application = (Application) context;
            for (String str : f3073f) {
                try {
                    i = Reflect.m3416b(application.getBaseContext(), "checkSelfPermission", str);
                } catch (Throwable unused) {
                    i = 0;
                }
                if (i != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: g */
    public static float m3545g(String str) throws NumberFormatException {
        return Float.parseFloat(str);
    }

    /* renamed from: g */
    public static int m3546g() {
        return new Random().nextInt(65536) - 32768;
    }

    /* renamed from: g */
    public static boolean m3547g(Context context) {
        int i;
        if (context.getApplicationInfo().targetSdkVersion < 29) {
            return true;
        }
        try {
            i = Reflect.m3416b(((Application) context).getBaseContext(), "checkSelfPermission", f3074g);
        } catch (Throwable unused) {
            i = 0;
        }
        return i == 0;
    }

    /* renamed from: h */
    public static int m3548h(String str) throws NumberFormatException {
        return Integer.parseInt(str);
    }

    /* renamed from: h */
    public static void m3549h() {
        f3071d.clear();
    }

    @SuppressLint({"NewApi"})
    /* renamed from: h */
    public static boolean m3550h(Context context) {
        boolean z;
        if (context == null) {
            return true;
        }
        if (f3068a == null) {
            f3068a = (WifiManager) m3501a(context, "wifi");
        }
        try {
            z = f3068a.isWifiEnabled();
        } catch (Throwable unused) {
            z = false;
        }
        if (!z && m3535d() > 17) {
            try {
                return "true".equals(String.valueOf(Reflect.m3412a((Object) f3068a, "isScanAlwaysAvailable", new Object[0])));
            } catch (Throwable unused2) {
            }
        }
        return z;
    }

    /* renamed from: i */
    public static int m3551i(String str) throws NumberFormatException {
        return Integer.parseInt(str, 16);
    }

    /* renamed from: i */
    public static String m3552i() {
        try {
            return C1102dd.m3743b("S128DF1572465B890OE3F7A13167KLEI".getBytes("UTF-8")).substring(20);
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0035, code lost:
        return "2G";
     */
    /* renamed from: i */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m3553i(android.content.Context r3) {
        /*
            android.net.NetworkInfo r3 = m3530c((android.content.Context) r3)
            if (r3 == 0) goto L_0x0052
            boolean r0 = r3.isConnectedOrConnecting()
            if (r0 != 0) goto L_0x000d
            goto L_0x0052
        L_0x000d:
            java.lang.String r0 = "UNKNOWN"
            int r1 = r3.getType()
            r2 = 1
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = "WIFI"
            goto L_0x0051
        L_0x0019:
            if (r1 != 0) goto L_0x0051
            java.lang.String r0 = r3.getSubtypeName()
            int r3 = r3.getSubtype()
            switch(r3) {
                case 1: goto L_0x0035;
                case 2: goto L_0x0035;
                case 3: goto L_0x0032;
                case 4: goto L_0x0035;
                case 5: goto L_0x0032;
                case 6: goto L_0x0032;
                case 7: goto L_0x0035;
                case 8: goto L_0x0032;
                case 9: goto L_0x0032;
                case 10: goto L_0x0032;
                case 11: goto L_0x0035;
                case 12: goto L_0x0032;
                case 13: goto L_0x002f;
                case 14: goto L_0x0032;
                case 15: goto L_0x0032;
                case 16: goto L_0x0035;
                case 17: goto L_0x0032;
                default: goto L_0x0026;
            }
        L_0x0026:
            java.lang.String r3 = "GSM"
            boolean r3 = r3.equalsIgnoreCase(r0)
            if (r3 == 0) goto L_0x0038
            goto L_0x0035
        L_0x002f:
            java.lang.String r0 = "4G"
            goto L_0x0051
        L_0x0032:
            java.lang.String r0 = "3G"
            goto L_0x0051
        L_0x0035:
            java.lang.String r0 = "2G"
            goto L_0x0051
        L_0x0038:
            java.lang.String r3 = "TD-SCDMA"
            boolean r3 = r3.equalsIgnoreCase(r0)
            if (r3 != 0) goto L_0x0032
            java.lang.String r3 = "WCDMA"
            boolean r3 = r3.equalsIgnoreCase(r0)
            if (r3 != 0) goto L_0x0032
            java.lang.String r3 = "CDMA2000"
            boolean r3 = r3.equalsIgnoreCase(r0)
            if (r3 == 0) goto L_0x0051
            goto L_0x0032
        L_0x0051:
            return r0
        L_0x0052:
            java.lang.String r3 = "DISCONNECTED"
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.C1079cp.m3553i(android.content.Context):java.lang.String");
    }

    /* renamed from: j */
    public static byte m3554j(String str) throws NumberFormatException {
        return Byte.parseByte(str);
    }

    /* renamed from: j */
    public static String m3555j(Context context) {
        String m = DeviceInfo.m3724m(context);
        if (TextUtils.isEmpty(m) || m.equals("00:00:00:00:00:00")) {
            m = "00:00:00:00:00:00";
            if (context != null) {
                m = SpUtil.m3492b(context, "pref", "smac", m);
            }
        }
        if (TextUtils.isEmpty(m)) {
            m = "00:00:00:00:00:00";
        }
        if (!f3075h) {
            if (context != null && !TextUtils.isEmpty(m)) {
                SpUtil.m3487a(context, "pref", "smac", m);
            }
            f3075h = true;
        }
        return m;
    }

    /* renamed from: k */
    public static boolean m3556k(Context context) {
        return Build.VERSION.SDK_INT >= 28 && context.getApplicationInfo().targetSdkVersion >= 28;
    }

    /* renamed from: l */
    public static boolean m3557l(Context context) {
        ServiceInfo serviceInfo;
        try {
            serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, "com.amap.api.location.APSService"), 128);
        } catch (Throwable unused) {
            serviceInfo = null;
        }
        return serviceInfo != null;
    }
}
