package com.meizu.update.p083a;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.meizu.update.util.Loger;
import com.meizu.update.util.Utility;
import java.io.File;

/* renamed from: com.meizu.update.a.a */
public class FileCacheHelper {
    /* renamed from: a */
    private static final String m17525a(int i) {
        if (i < 0 || i > 8) {
            return "";
        }
        switch (i) {
            case 0:
                return ".so";
            case 1:
                return ".jar";
            case 2:
                return ".apk";
            case 3:
                return ".rar";
            case 4:
                return ".dex";
            case 5:
                return ".zip";
            case 6:
                return ".7z";
            case 7:
                return ".tar";
            case 8:
                return ".gz";
            default:
                return "";
        }
    }

    /* renamed from: a */
    public static void m17529a(Context context) {
        m17530a(context, (String) null);
    }

    /* renamed from: a */
    public static void m17532a(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            Loger.m17943d("clearCustomPathCache : root path is null!");
            return;
        }
        String str4 = null;
        if (!TextUtils.isEmpty(str2)) {
            str4 = m17527a(str2);
            str3 = m17535b(str2);
        } else {
            str3 = null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return;
        }
        if (!file.isDirectory()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isFile() && ((str4 == null || !file2.getName().equals(str4)) && (str3 == null || !file2.getName().equals(str3)))) {
                    m17540c("delete cache file : " + file2.getName());
                    file2.delete();
                }
            }
        }
    }

    /* renamed from: a */
    public static void m17530a(Context context, String str) {
        String str2;
        String c = m17538c(context);
        String str3 = null;
        if (!TextUtils.isEmpty(str)) {
            str3 = m17527a(str);
            str2 = m17535b(str);
        } else {
            str2 = null;
        }
        File file = new File(c);
        if (!file.exists()) {
            return;
        }
        if (!file.isDirectory()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isFile() && ((str3 == null || !file2.getName().equals(str3)) && (str2 == null || !file2.getName().equals(str2)))) {
                    m17540c("delete cache file : " + file2.getName());
                    file2.delete();
                }
            }
        }
    }

    /* renamed from: a */
    public static void m17531a(Context context, String str, String str2, int i) {
        String str3;
        String e = m17542e(context.getPackageName(), str);
        String str4 = null;
        if (!TextUtils.isEmpty(str2)) {
            str4 = m17527a(str2);
            str3 = m17528a(str2, i);
        } else {
            str3 = null;
        }
        File file = new File(e);
        if (!file.exists()) {
            return;
        }
        if (!file.isDirectory()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isFile() && ((str4 == null || !file2.getName().equals(str4)) && (str3 == null || !file2.getName().equals(str3)))) {
                    m17540c("delete cache file : " + file2.getName());
                    file2.delete();
                }
            }
        }
    }

    /* renamed from: b */
    public static void m17537b(Context context) {
        String packageName = context.getPackageName();
        String c = m17538c(context);
        String b = m17535b(Utility.m17970b(context, packageName));
        File file = new File(c + b);
        if (file.exists()) {
            m17540c("delete cur cache : " + file.getName());
            file.delete();
        }
    }

    /* renamed from: b */
    public static final String m17533b(Context context, String str) {
        String b = m17535b(str);
        String c = m17538c(context);
        return c + b;
    }

    /* renamed from: b */
    public static final String m17536b(String str, String str2) {
        String b = m17535b(str2);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return str + b;
    }

    /* renamed from: c */
    public static final String m17539c(String str, String str2) {
        String a = m17527a(str2);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return str + a;
    }

    /* renamed from: a */
    private static final String m17527a(String str) {
        return "update_cache_" + str + ".temp";
    }

    /* renamed from: b */
    private static final String m17535b(String str) {
        return "update_cache_" + str + ".apk";
    }

    /* renamed from: c */
    public static final String m17538c(Context context) {
        return context.getExternalCacheDir() + "/InstallCache/";
    }

    /* renamed from: d */
    public static final boolean m17541d(String str, String str2) {
        try {
            return new File(str).renameTo(new File(str2));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: c */
    private static void m17540c(String str) {
        Log.d("FileCacheManager", str);
    }

    /* renamed from: b */
    public static final String m17534b(Context context, String str, String str2, int i) {
        String a = m17528a(str2, i);
        String e = m17542e(context.getPackageName(), str);
        return e + a;
    }

    /* renamed from: a */
    public static final String m17526a(Context context, String str, String str2) {
        String a = m17527a(str2);
        String e = m17542e(context.getPackageName(), str);
        return e + a;
    }

    /* renamed from: e */
    private static final String m17542e(String str, String str2) {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + str + "/Plugins/" + str2 + "/Cache/";
    }

    /* renamed from: a */
    private static final String m17528a(String str, int i) {
        return "update_plugin_" + str + m17525a(i);
    }
}
