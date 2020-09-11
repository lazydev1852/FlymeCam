package com.meizu.common.util;

import android.content.Context;
import android.provider.Settings;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: com.meizu.common.util.a */
public class CommonUtils {

    /* renamed from: a */
    private static Boolean f4496a;

    /* renamed from: b */
    private static Boolean f4497b;

    /* renamed from: c */
    private static Boolean f4498c;

    /* renamed from: d */
    private static Class f4499d;

    /* renamed from: e */
    private static Method f4500e;

    /* renamed from: f */
    private static Class f4501f;

    /* renamed from: g */
    private static Field f4502g;

    /* renamed from: h */
    private static Field f4503h;

    /* renamed from: a */
    public static boolean m5119a() {
        try {
            if (f4499d == null) {
                f4499d = Class.forName("android.os.BuildExt");
            }
            if (f4500e == null) {
                f4500e = f4499d.getDeclaredMethod("isProductInternational", new Class[0]);
            }
            return ((Boolean) f4500e.invoke(f4499d, new Object[0])).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0035 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m5121b() {
        /*
            r0 = 1
            java.lang.Class r1 = f4501f     // Catch:{ ClassNotFoundException -> 0x002d, NoSuchFieldException -> 0x0028, IllegalAccessException -> 0x0023 }
            if (r1 != 0) goto L_0x000d
            java.lang.String r1 = "flyme.config.FlymeFeature"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x002d, NoSuchFieldException -> 0x0028, IllegalAccessException -> 0x0023 }
            f4501f = r1     // Catch:{ ClassNotFoundException -> 0x002d, NoSuchFieldException -> 0x0028, IllegalAccessException -> 0x0023 }
        L_0x000d:
            java.lang.reflect.Field r1 = f4502g     // Catch:{ ClassNotFoundException -> 0x002d, NoSuchFieldException -> 0x0028, IllegalAccessException -> 0x0023 }
            if (r1 != 0) goto L_0x001b
            java.lang.Class r1 = f4501f     // Catch:{ ClassNotFoundException -> 0x002d, NoSuchFieldException -> 0x0028, IllegalAccessException -> 0x0023 }
            java.lang.String r2 = "SHELL_FINGERPRINT_KEY"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r2)     // Catch:{ ClassNotFoundException -> 0x002d, NoSuchFieldException -> 0x0028, IllegalAccessException -> 0x0023 }
            f4502g = r1     // Catch:{ ClassNotFoundException -> 0x002d, NoSuchFieldException -> 0x0028, IllegalAccessException -> 0x0023 }
        L_0x001b:
            java.lang.reflect.Field r1 = f4502g     // Catch:{ ClassNotFoundException -> 0x002d, NoSuchFieldException -> 0x0028, IllegalAccessException -> 0x0023 }
            r2 = 0
            boolean r1 = r1.getBoolean(r2)     // Catch:{ ClassNotFoundException -> 0x002d, NoSuchFieldException -> 0x0028, IllegalAccessException -> 0x0023 }
            goto L_0x0032
        L_0x0023:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x0031
        L_0x0028:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x0031
        L_0x002d:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0031:
            r1 = 1
        L_0x0032:
            if (r1 != 0) goto L_0x0035
            goto L_0x0036
        L_0x0035:
            r0 = 0
        L_0x0036:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.util.CommonUtils.m5121b():boolean");
    }

    /* renamed from: a */
    public static int m5117a(Context context, int i) {
        return Settings.System.getInt(context.getContentResolver(), "mz_show_navigation_bar", i);
    }

    /* renamed from: a */
    public static boolean m5120a(Context context) {
        if (m5117a(context, (m5121b() || m5119a()) ? 1 : 0) == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static void m5118a(View view) {
        if (m5122c()) {
            view.performHapticFeedback(20120);
        }
    }

    /* renamed from: c */
    private static boolean m5122c() {
        try {
            if (f4503h == null) {
                f4503h = Class.forName("flyme.config.FlymeFeature").getDeclaredField("SHELL_HAPTICFEEDBACK_MOTOR");
            }
            return f4503h.getBoolean((Object) null);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
