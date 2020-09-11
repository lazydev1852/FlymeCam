package com.meizu.media.camera.util;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.meizu.media.camera.util.ap */
public class StatusbarColorUtils {

    /* renamed from: a */
    public static ChangeQuickRedirect f14119a;

    /* renamed from: b */
    private static Method f14120b;

    /* renamed from: c */
    private static Method f14121c;

    /* renamed from: d */
    private static Field f14122d;

    /* renamed from: e */
    private static int f14123e;

    static {
        Class<Activity> cls = Activity.class;
        try {
            f14120b = cls.getMethod("setStatusBarDarkIcon", new Class[]{Integer.TYPE});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        Class<Activity> cls2 = Activity.class;
        try {
            f14121c = cls2.getMethod("setStatusBarDarkIcon", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        }
        try {
            f14122d = WindowManager.LayoutParams.class.getField("statusBarColor");
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
        }
        try {
            f14123e = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt((Object) null);
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
        } catch (IllegalAccessException e5) {
            e5.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m16005a(Activity activity, boolean z) {
        if (!PatchProxy.proxy(new Object[]{activity, new Byte(z ? (byte) 1 : 0)}, (Object) null, f14119a, true, 8202, new Class[]{Activity.class, Boolean.TYPE}, Void.TYPE).isSupported) {
            m16006a(activity, z, true);
        }
    }

    /* renamed from: a */
    private static boolean m16010a(WindowManager.LayoutParams layoutParams, String str, boolean z) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{layoutParams, str, new Byte(z ? (byte) 1 : 0)}, (Object) null, f14119a, true, 8203, new Class[]{WindowManager.LayoutParams.class, String.class, Boolean.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        try {
            Field declaredField = layoutParams.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            int i = declaredField.getInt(layoutParams);
            Field declaredField2 = layoutParams.getClass().getDeclaredField("meizuFlags");
            declaredField2.setAccessible(true);
            int i2 = declaredField2.getInt(layoutParams);
            int i3 = z ? i | i2 : (~i) & i2;
            if (i2 != i3) {
                declaredField2.setInt(layoutParams, i3);
                return true;
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    /* renamed from: a */
    private static void m16007a(View view, boolean z) {
        int i;
        if (!PatchProxy.proxy(new Object[]{view, new Byte(z ? (byte) 1 : 0)}, (Object) null, f14119a, true, 8204, new Class[]{View.class, Boolean.TYPE}, Void.TYPE).isSupported) {
            int systemUiVisibility = view.getSystemUiVisibility();
            if (z) {
                i = f14123e | systemUiVisibility;
            } else {
                i = (~f14123e) & systemUiVisibility;
            }
            if (i != systemUiVisibility) {
                view.setSystemUiVisibility(i);
            }
        }
    }

    /* renamed from: a */
    private static void m16008a(Window window, int i) {
        if (!PatchProxy.proxy(new Object[]{window, new Integer(i)}, (Object) null, f14119a, true, 8205, new Class[]{Window.class, Integer.TYPE}, Void.TYPE).isSupported) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (f14122d != null) {
                try {
                    if (f14122d.getInt(attributes) != i) {
                        f14122d.set(attributes, Integer.valueOf(i));
                        window.setAttributes(attributes);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public static void m16009a(Window window, boolean z) {
        Object[] objArr = {window, new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f14119a;
        if (!PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect, true, 8206, new Class[]{Window.class, Boolean.TYPE}, Void.TYPE).isSupported) {
            if (Build.VERSION.SDK_INT < 23) {
                m16010a(window.getAttributes(), "MEIZU_FLAG_DARK_STATUS_BAR_ICON", z);
                return;
            }
            View decorView = window.getDecorView();
            if (decorView != null) {
                m16007a(decorView, z);
                m16008a(window, 0);
            }
        }
    }

    /* renamed from: a */
    private static void m16006a(Activity activity, boolean z, boolean z2) {
        Object[] objArr = {activity, new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f14119a;
        if (!PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect, true, 8207, new Class[]{Activity.class, Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            if (f14121c != null) {
                try {
                    f14121c.invoke(activity, new Object[]{Boolean.valueOf(z)});
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e2) {
                    e2.printStackTrace();
                }
            } else if (z2) {
                m16009a(activity.getWindow(), z);
            }
        }
    }
}
