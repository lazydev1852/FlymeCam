package com.meizu.update.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.core.p005os.EnvironmentCompat;
import com.baidu.p020ar.constants.HttpConstants;
import com.baidu.p020ar.statistic.StatisticConstants;
import com.baidu.p020ar.util.IoUtils;
import com.meizu.p055b.ReflectHelper;
import com.meizu.update.UpdateInfo;
import com.meizu.update.p083a.UpdateInfoCache;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apaches.commons.codec.digest.MessageDigestAlgorithms;

/* renamed from: com.meizu.update.util.j */
public class Utility {

    /* renamed from: a */
    private static String f16363a;

    /* renamed from: b */
    private static Boolean f16364b;

    /* renamed from: c */
    private static String f16365c;

    /* renamed from: d */
    private static String f16366d;

    /* renamed from: e */
    private static final char[] f16367e = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: f */
    private static Boolean f16368f = null;

    /* renamed from: g */
    private static Boolean f16369g = null;

    /* renamed from: h */
    private static Boolean f16370h = null;

    /* renamed from: i */
    private static String f16371i;

    /* renamed from: j */
    private static Boolean f16372j = null;

    /* renamed from: k */
    private static Integer f16373k = null;

    /* renamed from: l */
    private static String f16374l = null;

    /* renamed from: a */
    public static String m17960a(Context context) {
        return m17961a(context, context.getPackageName());
    }

    /* renamed from: a */
    public static String m17961a(Context context, String str) {
        return m17970b(context, str);
    }

    /* renamed from: b */
    public static String m17970b(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            m17965a(packageInfo);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    /* renamed from: b */
    public static final String m17969b(Context context) {
        String str;
        try {
            str = m17962a("ro.build.mask.id", "");
        } catch (Exception e) {
            e.printStackTrace();
            str = null;
        }
        return TextUtils.isEmpty(str) ? Build.DISPLAY : str;
    }

    /* renamed from: a */
    public static final String m17958a() {
        return Build.DISPLAY;
    }

    /* renamed from: c */
    public static final String m17974c(Context context) {
        return Build.VERSION.RELEASE;
    }

    /* renamed from: d */
    public static final String m17979d(Context context) {
        if (m18003v(context)) {
            return "All";
        }
        return m17968b();
    }

    /* renamed from: b */
    public static String m17968b() {
        if (f16363a == null && !m17976c()) {
            try {
                f16363a = (String) ReflectHelper.m4010a("android.os.BuildExt", "MZ_MODEL");
            } catch (Exception unused) {
            }
        }
        if (TextUtils.isEmpty(f16363a) || f16363a.toLowerCase().equals(EnvironmentCompat.MEDIA_UNKNOWN)) {
            f16363a = Build.MODEL;
        }
        return f16363a;
    }

    /* renamed from: c */
    public static boolean m17976c() {
        if (f16364b != null) {
            return f16364b.booleanValue();
        }
        f16364b = false;
        try {
            f16364b = (Boolean) ReflectHelper.m4012a("android.os.BuildExt", "isFlymeRom", (Object[]) null);
        } catch (Exception unused) {
        }
        return f16364b.booleanValue();
    }

    /* renamed from: e */
    public static final String m17982e(Context context) {
        return m17988g(context);
    }

    /* renamed from: f */
    public static final String m17986f(Context context) {
        if (f16365c == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    f16365c = (String) ReflectHelper.m4012a("android.os.Build", "getSerial", (Object[]) null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                f16365c = m17962a("ro.serialno", (String) null);
            }
        }
        return f16365c;
    }

    /* renamed from: g */
    public static String m17988g(Context context) {
        if (TextUtils.isEmpty(f16366d)) {
            try {
                f16366d = (String) ReflectHelper.m4011a("android.telephony.MzTelephonyManager", "getDeviceId", (Class<?>[]) null, (Object[]) null);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (TextUtils.isEmpty(f16366d)) {
                try {
                    f16366d = (String) ReflectHelper.m4011a("com.meizu.telephony.MzTelephonymanager", "getDeviceId", (Class<?>[]) new Class[]{Context.class, Integer.TYPE}, new Object[]{context, 0});
                } catch (Exception unused) {
                }
            }
            if (TextUtils.isEmpty(f16366d)) {
                f16366d = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            }
        }
        return f16366d;
    }

    /* renamed from: c */
    public static final boolean m17977c(Context context, String str) {
        try {
            File file = new File(str);
            if (!file.isFile() || !file.exists() || context.getPackageManager().getPackageArchiveInfo(str, 0) == null) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /* renamed from: d */
    public static final PackageInfo m17978d(Context context, String str) {
        try {
            File file = new File(str);
            if (!file.isFile() || !file.exists()) {
                return null;
            }
            return context.getPackageManager().getPackageArchiveInfo(str, 0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static final long m17955a(String str) {
        try {
            File file = new File(str);
            if (!file.exists() || !file.isFile()) {
                return 0;
            }
            return file.length();
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: h */
    public static final String m17989h(Context context) {
        return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
    }

    /* renamed from: a */
    public static String m17964a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[(length << 1)];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            cArr[i] = f16367e[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr[i3] = f16367e[bArr[i2] & 15];
        }
        return new String(cArr);
    }

    /* renamed from: b */
    public static String m17971b(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(str.getBytes(IoUtils.UTF_8));
            return m17964a(instance.digest());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: d */
    public static boolean m17981d() {
        if (f16368f != null) {
            return f16368f.booleanValue();
        }
        f16368f = false;
        try {
            f16368f = (Boolean) Class.forName("android.os.BuildExt").getMethod("isProductInternational", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        }
        return f16368f.booleanValue();
    }

    /* renamed from: a */
    public static String m17962a(String str, String str2) {
        try {
            return (String) ReflectHelper.m4012a("android.os.SystemProperties", "get", new Object[]{str});
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    /* renamed from: e */
    public static boolean m17984e(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                if ((applicationInfo.flags & 1) == 0 && (applicationInfo.flags & 128) == 0) {
                    return false;
                }
                return true;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    /* renamed from: a */
    public static final Bitmap m17957a(String str, Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Drawable loadIcon = packageManager.getPackageInfo(str, 0).applicationInfo.loadIcon(packageManager);
            if (loadIcon != null) {
                return m17956a(loadIcon);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static Bitmap m17956a(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    /* renamed from: i */
    public static boolean m17990i(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    /* renamed from: j */
    public static boolean m17991j(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable() || activeNetworkInfo.getType() != 1) {
            return false;
        }
        return true;
    }

    /* renamed from: k */
    public static boolean m17992k(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable() || activeNetworkInfo.getType() != 0) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static String m17959a(double d) {
        if (d < 1024.0d) {
            return String.format("%d B", new Object[]{Integer.valueOf(d > 0.0d ? (int) d : 0)});
        } else if (d >= 1024.0d && d < 10240.0d) {
            return String.format("%d KB", new Object[]{Integer.valueOf((int) (d / 1024.0d))});
        } else if (d >= 10240.0d && d < 102400.0d) {
            return String.format("%d KB", new Object[]{Integer.valueOf((int) (d / 1024.0d))});
        } else if (d >= 102400.0d && d < 1048576.0d) {
            return String.format("%d KB", new Object[]{Integer.valueOf((int) (d / 1024.0d))});
        } else if (d >= 1048576.0d && d < 1.048576E8d) {
            return String.format("%.2f MB", new Object[]{Double.valueOf(d / 1048576.0d)});
        } else if (d >= 1.048576E8d && d < 1.073741824E9d) {
            return String.format("%.1f MB", new Object[]{Double.valueOf(d / 1048576.0d)});
        } else if (d >= 1.073741824E9d && d < 1.073741824E10d) {
            return String.format("%.2f GB", new Object[]{Double.valueOf(d / 1.073741824E9d)});
        } else if (d < 1.073741824E10d || d >= 1.073741824E11d) {
            return String.format("%d GB", new Object[]{Integer.valueOf((int) (d / 1.073741824E9d))});
        } else {
            return String.format("%.1f GB", new Object[]{Double.valueOf(d / 1.073741824E9d)});
        }
    }

    /* renamed from: v */
    private static boolean m18003v(Context context) {
        if (f16369g == null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo.metaData != null) {
                    f16369g = Boolean.valueOf(applicationInfo.metaData.getBoolean("system_independent", false));
                    Log.d("MzUpdateComponent", "sSystemIndependent : " + f16369g);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (f16369g == null) {
                f16369g = false;
            }
        }
        return f16369g.booleanValue();
    }

    /* renamed from: e */
    public static boolean m17983e() {
        if (f16370h != null) {
            return f16370h.booleanValue();
        }
        f16370h = false;
        try {
            f16370h = (Boolean) ReflectHelper.m4010a("android.os.BuildExt", "IS_SHOPDEMO");
        } catch (Exception unused) {
        }
        return f16370h.booleanValue();
    }

    /* renamed from: l */
    public static String m17993l(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager.getSimState() == 5 ? telephonyManager.getSimOperator() : "";
    }

    /* renamed from: m */
    public static int m17994m(Context context) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, intentFilter);
        if (registerReceiver == null) {
            return 0;
        }
        return (registerReceiver.getIntExtra("level", -1) * 100) / registerReceiver.getIntExtra("scale", -1);
    }

    /* renamed from: n */
    public static Bundle m17995n(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException e) {
            Loger.m17943d(e.getMessage());
            return null;
        }
    }

    /* renamed from: o */
    public static String m17996o(Context context) {
        Bundle n = m17995n(context);
        if (n == null || !n.containsKey("com.meizu.update.key.appid")) {
            return null;
        }
        return String.valueOf(n.get("com.meizu.update.key.appid"));
    }

    /* renamed from: p */
    public static String m17997p(Context context) {
        Bundle n = m17995n(context);
        if (n == null || !n.containsKey("com.meizu.update.key.appkey")) {
            return null;
        }
        return n.getString("com.meizu.update.key.appkey");
    }

    /* renamed from: a */
    public static boolean m17967a(Context context, UpdateInfo updateInfo) {
        String str = updateInfo.mVersionName;
        String b = m17970b(context, context.getPackageName());
        String b2 = UpdateInfoCache.m17545b(context);
        if (TextUtils.isEmpty(b) || TextUtils.isEmpty(b2) || !b.equalsIgnoreCase(b2)) {
            return false;
        }
        BigDecimal c = m17975c(b);
        BigDecimal c2 = m17975c(str);
        if (c == null || c2 == null || c2.compareTo(c) <= 0) {
            return false;
        }
        return true;
    }

    /* renamed from: q */
    public static String m17998q(Context context) {
        return m18000s(context) ? m17999r(context) : m17982e(context);
    }

    /* renamed from: r */
    public static String m17999r(Context context) {
        WifiInfo connectionInfo;
        String macAddress;
        if (!TextUtils.isEmpty(f16371i)) {
            return f16371i;
        }
        String str = null;
        if (Build.VERSION.SDK_INT >= 23) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || connectivityManager.getActiveNetworkInfo() == null) {
                macAddress = m17980d("wlan0");
                if (TextUtils.isEmpty(macAddress)) {
                    macAddress = m17980d("eth0");
                }
            } else {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo.getType() == 1) {
                    macAddress = m17980d("wlan0");
                } else {
                    if (activeNetworkInfo.getType() == 9) {
                        macAddress = m17980d("eth0");
                    }
                    f16371i = str;
                    return f16371i;
                }
            }
        } else {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (!(wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null)) {
                macAddress = connectionInfo.getMacAddress();
            }
            f16371i = str;
            return f16371i;
        }
        str = macAddress;
        f16371i = str;
        return f16371i;
    }

    /* renamed from: d */
    private static String m17980d(String str) {
        String str2 = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("/sys/class/net/" + str + "/address");
            Scanner scanner = new Scanner(fileInputStream);
            if (scanner.hasNextLine()) {
                str2 = scanner.nextLine().trim();
            }
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return str2;
    }

    /* renamed from: s */
    public static boolean m18000s(Context context) {
        try {
            if (f16372j != null) {
                return f16372j.booleanValue();
            }
            String a = m17962a("ro.target.product", (String) null);
            Boolean valueOf = Boolean.valueOf(!TextUtils.isEmpty(a) && ("tablet".equalsIgnoreCase(a) || StatisticConstants.HOST_PLATFORM_BOX.equalsIgnoreCase(a)));
            f16372j = valueOf;
            return valueOf.booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: t */
    public static int m18001t(Context context) {
        int i;
        try {
            if (f16373k != null) {
                return f16373k.intValue();
            }
            String a = m17962a("ro.target.product", (String) null);
            if (!TextUtils.isEmpty(a)) {
                if ("tablet".equalsIgnoreCase(a)) {
                    i = 2;
                } else if (StatisticConstants.HOST_PLATFORM_BOX.equalsIgnoreCase(a)) {
                    i = 1;
                }
                Integer valueOf = Integer.valueOf(i);
                f16373k = valueOf;
                return valueOf.intValue();
            }
            i = 0;
            Integer valueOf2 = Integer.valueOf(i);
            f16373k = valueOf2;
            return valueOf2.intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: f */
    public static int m17985f(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    /* renamed from: c */
    public static BigDecimal m17975c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("_");
        if (indexOf > 0) {
            str = str.substring(0, indexOf);
        }
        try {
            String[] split = str.split("-");
            String[] split2 = split[0].split("\\.");
            int length = split2.length;
            StringBuilder sb = new StringBuilder((length * 4) + 10 + 5);
            if (2 <= length) {
                if (3 >= length) {
                    for (String trim : split2) {
                        String trim2 = trim.trim();
                        int length2 = trim2.length();
                        if (length2 > 4) {
                            Loger.m17943d("Invalid versionSize! maxVsSize = " + length2);
                            return null;
                        }
                        while (true) {
                            int i = length2 + 1;
                            if (4 <= length2) {
                                break;
                            }
                            sb.append("0");
                            length2 = i;
                        }
                        sb.append(trim2);
                    }
                    if (length < 3) {
                        for (int i2 = 0; i2 < 4; i2++) {
                            sb.append("0");
                        }
                    }
                    if (split.length > 1) {
                        split[1] = split[1].trim();
                        int length3 = split[1].length();
                        if (length3 > 10) {
                            Loger.m17943d("invalid  RvLen RvLen = " + length3);
                            return null;
                        }
                        while (true) {
                            int i3 = length3 + 1;
                            if (10 <= length3) {
                                break;
                            }
                            sb.append("0");
                            length3 = i3;
                        }
                        sb.append(split[1]);
                    }
                    return new BigDecimal(sb.toString());
                }
            }
            Loger.m17943d("Invalid versionName length! vsLen = " + length);
            return null;
        } catch (Exception unused) {
            Loger.m17943d("Build version code error! versionName = " + str);
            return null;
        }
    }

    /* renamed from: f */
    public static boolean m17987f() {
        String str = Build.DISPLAY;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains("flyme");
    }

    /* renamed from: u */
    public static String m18002u(Context context) {
        if (f16374l != null) {
            return f16374l;
        }
        if (context == null) {
            return "";
        }
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        if (packageName == null) {
            packageName = "";
        }
        String a = m17960a(applicationContext);
        if (a == null) {
            a = "";
        }
        f16374l = packageName + "/" + a;
        return f16374l;
    }

    /* renamed from: a */
    public static void m17966a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private static void m17965a(PackageInfo packageInfo) {
        if (packageInfo != null && "com.android.packageinstaller".equals(packageInfo.packageName)) {
            Log.w("MzUpdateComponent", packageInfo.packageName + ": " + packageInfo.versionName);
            String str = packageInfo.versionName;
            if (str.endsWith("-beta")) {
                packageInfo.versionName = str.replace("-beta", "_beta");
            }
            Log.w("MzUpdateComponent", packageInfo.packageName + ": " + packageInfo.versionName);
        }
    }

    /* renamed from: a */
    public static String m17963a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("apps", str));
        arrayList.add(new Pair(HttpConstants.TIMESTAMP, str2));
        Collections.sort(arrayList, new Comparator<Pair<String, String>>() {
            /* renamed from: a */
            public int compare(Pair<String, String> pair, Pair<String, String> pair2) {
                return ((String) pair.first).compareTo((String) pair2.first);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            Pair pair = (Pair) arrayList.get(i);
            if (i != 0) {
                sb.append("&");
            }
            sb.append((String) pair.first);
            sb.append("=");
            sb.append((String) pair.second);
        }
        try {
            return m17972b(sb.toString(), str3);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        } catch (InvalidKeyException e2) {
            e2.printStackTrace();
            return "";
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
            return "";
        }
    }

    /* renamed from: b */
    private static String m17972b(String str, String str2) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        Mac instance = Mac.getInstance("HmacSHA256");
        instance.init(new SecretKeySpec(str2.getBytes("UTF-8"), "HmacSHA256"));
        return m17973b(instance.doFinal(str.getBytes("UTF-8")));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m17973b(byte[] r6) {
        /*
            int r0 = r6.length
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r2 = r0 * 2
            r1.<init>(r2)
            r2 = 0
        L_0x0009:
            if (r2 >= r0) goto L_0x0025
            byte r3 = r6[r2]
        L_0x000d:
            if (r3 >= 0) goto L_0x0012
            int r3 = r3 + 256
            goto L_0x000d
        L_0x0012:
            r4 = 16
            if (r3 >= r4) goto L_0x001b
            java.lang.String r5 = "0"
            r1.append(r5)
        L_0x001b:
            java.lang.String r3 = java.lang.Integer.toString(r3, r4)
            r1.append(r3)
            int r2 = r2 + 1
            goto L_0x0009
        L_0x0025:
            java.lang.String r6 = r1.toString()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.update.util.Utility.m17973b(byte[]):java.lang.String");
    }
}
