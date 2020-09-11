package com.meizu.sharewidget.p080a;

import android.view.Window;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.meizu.sharewidget.a.c */
/* compiled from: NavigationBarUtils */
public class C2865c {

    /* renamed from: a */
    public static int f15855a = 256;

    /* renamed from: b */
    private static Method f15856b = null;

    /* renamed from: c */
    private static Method f15857c = null;

    /* renamed from: d */
    private static Field f15858d = null;

    /* renamed from: e */
    private static Method f15859e = null;

    /* renamed from: f */
    private static String f15860f = "com.android.internal.policy.DecorView";

    /* renamed from: g */
    private static Field f15861g;

    /* renamed from: h */
    private static Field f15862h;

    /* renamed from: i */
    private static Field f15863i;

    /* renamed from: j */
    private static Method f15864j;

    /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|(1:6)|7|(1:9)|10|(1:12)|13|15|16|(2:18|20)(1:22)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0050 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0084 A[Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0089 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x009d A[Catch:{ NoSuchMethodException -> 0x00a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0062 A[Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0089 }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0073 A[Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0089 }] */
    static {
        /*
            r0 = 0
            r1 = 1
            java.lang.Class<android.view.Window> r2 = android.view.Window.class
            java.lang.String r3 = "setNavigationBarIconColor"
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x0050 }
            java.lang.Class r5 = java.lang.Boolean.TYPE     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x0050 }
            r4[r0] = r5     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x0050 }
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r3, r4)     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x0050 }
            f15856b = r2     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x0050 }
            java.lang.Class<android.view.WindowManager$LayoutParams> r2 = android.view.WindowManager.LayoutParams.class
            java.lang.String r3 = "meizuFlags"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x0050 }
            f15858d = r2     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x0050 }
            java.lang.Class<android.view.Window> r2 = android.view.Window.class
            java.lang.String r3 = "setForcedNavigationBarColor"
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x0050 }
            java.lang.Class r5 = java.lang.Boolean.TYPE     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x0050 }
            r4[r0] = r5     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x0050 }
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r3, r4)     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x0050 }
            f15859e = r2     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x0050 }
            java.lang.Class<android.view.WindowManager$LayoutParams> r2 = android.view.WindowManager.LayoutParams.class
            java.lang.String r3 = "MEIZU_FLAG_DARK_NAVIGATION_BAR_ICON"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x0050 }
            r3 = 0
            int r2 = r2.getInt(r3)     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x0050 }
            f15855a = r2     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x0050 }
            java.lang.Class<android.view.Window> r2 = android.view.Window.class
            java.lang.String r3 = "setNavigationBarIconColor"
            r4 = 2
            java.lang.Class[] r4 = new java.lang.Class[r4]     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x0050 }
            java.lang.Class r5 = java.lang.Boolean.TYPE     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x0050 }
            r4[r0] = r5     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x0050 }
            java.lang.Class r5 = java.lang.Boolean.TYPE     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x0050 }
            r4[r1] = r5     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x0050 }
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r3, r4)     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x0050 }
            f15857c = r2     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x0050 }
        L_0x0050:
            java.lang.String r2 = f15860f     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0089 }
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0089 }
            java.lang.String r3 = "mLastBottomInset"
            java.lang.reflect.Field r3 = r2.getDeclaredField(r3)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0089 }
            f15861g = r3     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0089 }
            java.lang.reflect.Field r3 = f15861g     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0089 }
            if (r3 == 0) goto L_0x0067
            java.lang.reflect.Field r3 = f15861g     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0089 }
            r3.setAccessible(r1)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0089 }
        L_0x0067:
            java.lang.String r3 = "mLastRightInset"
            java.lang.reflect.Field r3 = r2.getDeclaredField(r3)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0089 }
            f15863i = r3     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0089 }
            java.lang.reflect.Field r3 = f15863i     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0089 }
            if (r3 == 0) goto L_0x0078
            java.lang.reflect.Field r3 = f15863i     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0089 }
            r3.setAccessible(r1)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0089 }
        L_0x0078:
            java.lang.String r3 = "mLastLeftInset"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0089 }
            f15862h = r2     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0089 }
            java.lang.reflect.Field r2 = f15862h     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0089 }
            if (r2 == 0) goto L_0x0089
            java.lang.reflect.Field r2 = f15862h     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0089 }
            r2.setAccessible(r1)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0089 }
        L_0x0089:
            java.lang.Class<android.view.Window> r2 = android.view.Window.class
            java.lang.String r3 = "setNavigationBarColorExt"
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch:{ NoSuchMethodException -> 0x00a2 }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x00a2 }
            r4[r0] = r5     // Catch:{ NoSuchMethodException -> 0x00a2 }
            java.lang.reflect.Method r0 = r2.getDeclaredMethod(r3, r4)     // Catch:{ NoSuchMethodException -> 0x00a2 }
            f15864j = r0     // Catch:{ NoSuchMethodException -> 0x00a2 }
            java.lang.reflect.Method r0 = f15864j     // Catch:{ NoSuchMethodException -> 0x00a2 }
            if (r0 == 0) goto L_0x00a2
            java.lang.reflect.Method r0 = f15864j     // Catch:{ NoSuchMethodException -> 0x00a2 }
            r0.setAccessible(r1)     // Catch:{ NoSuchMethodException -> 0x00a2 }
        L_0x00a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.sharewidget.p080a.C2865c.<clinit>():void");
    }

    /* renamed from: a */
    public static void m17248a(Window window, boolean z) {
        if (f15856b != null) {
            try {
                f15856b.invoke(window, new Object[]{Boolean.valueOf(z)});
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m17249a(Window window, boolean z, boolean z2) {
        if (f15857c != null) {
            try {
                f15857c.invoke(window, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        } else {
            m17248a(window, z);
        }
    }

    /* renamed from: a */
    public static void m17247a(Window window, int i) {
        if (f15864j != null) {
            try {
                f15864j.invoke(window, new Object[]{Integer.valueOf(i)});
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
    }
}
