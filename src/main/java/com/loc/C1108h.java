package com.loc;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/* renamed from: com.loc.h */
/* compiled from: Log */
public final class C1108h {

    /* renamed from: a */
    public static final String f3347a = "/a/";

    /* renamed from: b */
    static final String f3348b = "b";

    /* renamed from: c */
    static final String f3349c = "c";

    /* renamed from: d */
    static final String f3350d = "d";

    /* renamed from: e */
    public static final String f3351e = "g";

    /* renamed from: f */
    public static final String f3352f = "h";

    /* renamed from: g */
    public static final String f3353g = "e";

    /* renamed from: h */
    public static final String f3354h = "f";

    /* renamed from: i */
    public static final String f3355i = "j";

    /* renamed from: a */
    public static String m3849a(Context context, String str) {
        return context.getSharedPreferences("AMSKLG_CFG", 0).getString(str, "");
    }

    /* renamed from: a */
    public static void m3850a(final Context context) {
        try {
            ExecutorService d = SDKLogHandler.m3869d();
            if (d == null) {
                return;
            }
            if (!d.isShutdown()) {
                d.submit(new Runnable() {
                    public final void run() {
                        try {
                            MarkInfoManager.m3053a(context);
                            ErrorLogManager.m3884b(context);
                            ErrorLogManager.m3886d(context);
                            ErrorLogManager.m3885c(context);
                            StatisticsManager.m3065a(context);
                            OfflineLocManager.m3059a(context);
                        } catch (RejectedExecutionException unused) {
                        } catch (Throwable th) {
                            SDKLogHandler.m3867b(th, "Lg", "proL");
                        }
                    }
                });
            }
        } catch (Throwable th) {
            SDKLogHandler.m3867b(th, "Lg", "proL");
        }
    }

    @TargetApi(9)
    /* renamed from: a */
    public static void m3851a(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    /* renamed from: a */
    static boolean m3852a(String[] strArr, String str) {
        if (!(strArr == null || str == null)) {
            try {
                String[] split = str.split("\n");
                int length = split.length;
                int i = 0;
                while (true) {
                    boolean z = true;
                    if (i < length) {
                        String str2 = split[i];
                        if (TextUtils.isEmpty(str2) || !str2.startsWith("at ") || !str2.contains("uncaughtException")) {
                            z = false;
                        }
                        if (z) {
                            return false;
                        }
                        i++;
                    } else {
                        for (String trim : split) {
                            if (m3855b(strArr, trim.trim())) {
                                return true;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    /* renamed from: b */
    static List<SDKInfo> m3853b(Context context) {
        List<SDKInfo> list = null;
        try {
            synchronized (Looper.getMainLooper()) {
                try {
                    List<SDKInfo> a = new SDKDBOperation(context, false).mo13307a();
                    try {
                        return a;
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        list = a;
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th4.printStackTrace();
            return list;
        }
    }

    /* renamed from: b */
    public static void m3854b(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.remove(str);
        edit.apply();
    }

    /* renamed from: b */
    static boolean m3855b(String[] strArr, String str) {
        if (!(strArr == null || str == null)) {
            try {
                String str2 = str;
                for (String str3 : strArr) {
                    str2 = str2.trim();
                    if (str2.startsWith("at ")) {
                        if (str2.contains(str3 + ".") && str2.endsWith(")") && !str2.contains("uncaughtException")) {
                            return true;
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    /* renamed from: c */
    public static String m3856c(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + f3347a + str;
    }
}
