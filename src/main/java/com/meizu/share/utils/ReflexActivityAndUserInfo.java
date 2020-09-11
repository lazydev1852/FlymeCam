package com.meizu.share.utils;

import android.content.pm.ResolveInfo;
import java.lang.reflect.Field;

/* renamed from: com.meizu.share.utils.d */
public class ReflexActivityAndUserInfo {

    /* renamed from: a */
    public static int f15792a = -1;

    /* renamed from: b */
    public static int f15793b = -2;

    /* renamed from: c */
    public static int f15794c = 0;

    /* renamed from: d */
    public static int f15795d = 4;

    /* renamed from: e */
    private static Field f15796e = null;

    /* renamed from: f */
    private static String f15797f = "android.nonvccUsageStats.UsageStatsNonVccProxy3";

    /* renamed from: a */
    public static int m17202a(ResolveInfo resolveInfo) {
        try {
            if (f15796e == null) {
                f15796e = ResolveInfo.class.getDeclaredField("targetUserId");
            }
            return f15796e.getInt(resolveInfo);
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            return f15793b;
        }
    }
}
