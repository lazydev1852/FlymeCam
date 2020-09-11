package com.meizu.sharewidget.p080a;

import android.content.Context;
import android.content.pm.ResolveInfo;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* renamed from: com.meizu.sharewidget.a.e */
/* compiled from: ReflexActivityAndUserInfo */
public class C2876e {

    /* renamed from: a */
    public static int f15873a = -1;

    /* renamed from: b */
    public static int f15874b = -2;

    /* renamed from: c */
    public static int f15875c = 0;

    /* renamed from: d */
    public static int f15876d = 4;

    /* renamed from: e */
    private static Method f15877e = null;

    /* renamed from: f */
    private static Method f15878f = null;

    /* renamed from: g */
    private static Field f15879g = null;

    /* renamed from: h */
    private static String f15880h = "android.nonvccUsageStats.UsageStatsNonVccProxy3";

    /* renamed from: a */
    public static void m17269a(Context context, String str, String str2, Map<String, String> map, String str3) {
        try {
            Class<?> cls = Class.forName(f15880h);
            if (f15877e == null) {
                f15877e = cls.getDeclaredMethod("getInstance", new Class[]{Context.class});
            }
            if (f15878f == null) {
                f15878f = cls.getDeclaredMethod("onAppEvent", new Class[]{String.class, String.class, Map.class, String.class});
            }
            f15878f.invoke(f15877e.invoke((Object) null, new Object[]{context}), new Object[]{str, str2, map, str3});
        } catch (ClassNotFoundException | Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
    }

    /* renamed from: a */
    public static int m17268a(ResolveInfo resolveInfo) {
        try {
            if (f15879g == null) {
                f15879g = ResolveInfo.class.getDeclaredField("targetUserId");
            }
            return f15879g.getInt(resolveInfo);
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            return f15874b;
        }
    }
}
