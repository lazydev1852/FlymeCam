package com.meizu.common.renderer;

import android.util.Log;
import java.lang.reflect.Method;

/* renamed from: com.meizu.common.renderer.a */
public class SystemProperty {

    /* renamed from: a */
    private static Method f4375a;

    /* renamed from: b */
    private static Method f4376b;

    /* renamed from: c */
    private static Method f4377c;

    static {
        m5023a();
    }

    /* renamed from: a */
    public static boolean m5024a(String str, boolean z) {
        try {
            return ((Boolean) f4376b.invoke((Object) null, new Object[]{str, Boolean.valueOf(z)})).booleanValue();
        } catch (Exception e) {
            Log.e("glrenderer", "SystemProperty getBoolean " + e.toString());
            return z;
        }
    }

    /* renamed from: a */
    public static int m5022a(String str, int i) {
        try {
            return ((Integer) f4377c.invoke((Object) null, new Object[]{str, Integer.valueOf(i)})).intValue();
        } catch (Exception e) {
            Log.e("glrenderer", "SystemProperty getBoolean " + e.toString());
            return i;
        }
    }

    /* renamed from: a */
    private static void m5023a() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            f4375a = cls.getMethod("get", new Class[]{String.class});
            f4376b = cls.getMethod("getBoolean", new Class[]{String.class, Boolean.TYPE});
            f4377c = cls.getMethod("getInt", new Class[]{String.class, Integer.TYPE});
        } catch (Exception e) {
            Log.e("glrenderer", "SystemProperty init " + e.toString());
        }
    }
}
