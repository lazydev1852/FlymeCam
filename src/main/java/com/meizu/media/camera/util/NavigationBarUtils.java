package com.meizu.media.camera.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.IBinder;
import android.view.IWindowManager;
import android.view.Window;
import android.view.WindowManager;
import com.meizu.media.camera.R;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.meizu.media.camera.util.ah */
public class NavigationBarUtils {

    /* renamed from: a */
    public static ChangeQuickRedirect f14093a;

    /* renamed from: b */
    public static int f14094b;

    /* renamed from: c */
    private static final LogUtil.C2630a f14095c = new LogUtil.C2630a("NavigationBarUtils");

    /* renamed from: d */
    private static Method f14096d;

    /* renamed from: e */
    private static Field f14097e;

    /* renamed from: f */
    private static Method f14098f;

    /* renamed from: g */
    private static boolean f14099g;

    static {
        f14094b = 256;
        Class<Window> cls = Window.class;
        try {
            f14096d = cls.getDeclaredMethod("setNavigationBarIconColor", new Class[]{Boolean.TYPE});
            f14097e = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            f14098f = Window.class.getDeclaredMethod("setForcedNavigationBarColor", new Class[]{Boolean.TYPE});
            f14094b = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_NAVIGATION_BAR_ICON").getInt((Object) null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m15971a(Window window, boolean z) {
        if (!PatchProxy.proxy(new Object[]{window, new Byte(z ? (byte) 1 : 0)}, (Object) null, f14093a, true, 8152, new Class[]{Window.class, Boolean.TYPE}, Void.TYPE).isSupported && f14096d != null) {
            try {
                f14096d.invoke(window, new Object[]{Boolean.valueOf(z)});
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static int m15968a(Context context) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context}, (Object) null, f14093a, true, 8154, new Class[]{Context.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (m15972a()) {
            return context.getResources().getDimensionPixelSize(R.dimen.mz_camera_navigation_bar_height);
        }
        return 0;
    }

    /* renamed from: b */
    public static void m15974b(Context context) {
        if (!PatchProxy.proxy(new Object[]{context}, (Object) null, f14093a, true, 8156, new Class[]{Context.class}, Void.TYPE).isSupported) {
            if (DeviceHelper.f13874aa) {
                f14099g = true;
            } else {
                f14099g = m15973a(context.getResources());
            }
            LogUtil.C2630a aVar = f14095c;
            LogUtil.m15952c(aVar, "updateNavigationBarState " + f14099g);
        }
    }

    /* renamed from: a */
    public static boolean m15973a(Resources resources) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{resources}, (Object) null, f14093a, true, 8157, new Class[]{Resources.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (DeviceUtil.m16205e() >= 29) {
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            boolean z = identifier > 0 ? resources.getBoolean(identifier) : false;
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                String str = (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"qemu.hw.mainkeys"});
                if ("1".equals(str)) {
                    return false;
                }
                if ("0".equals(str)) {
                    return true;
                }
                return z;
            } catch (Exception e) {
                e.printStackTrace();
                return z;
            }
        } else {
            try {
                IWindowManager asInterface = IWindowManager.Stub.asInterface((IBinder) C2634am.m15996a("android.os.ServiceManager", "getService", (Object[]) new String[]{"window"}));
                if (asInterface == null) {
                    return f14099g;
                }
                boolean hasNavigationBar = asInterface.hasNavigationBar();
                LogUtil.C2630a aVar = f14095c;
                LogUtil.m15952c(aVar, "isNavigationBarShowing " + hasNavigationBar);
                return hasNavigationBar;
            } catch (NoSuchMethodError e2) {
                e2.printStackTrace();
                return false;
            } catch (Exception e3) {
                e3.printStackTrace();
                return false;
            }
        }
    }

    /* renamed from: a */
    public static boolean m15972a() {
        return f14099g;
    }

    /* renamed from: a */
    public static void m15970a(Window window, int i, boolean z) {
        if (!PatchProxy.proxy(new Object[]{window, new Integer(i), new Byte(z ? (byte) 1 : 0)}, (Object) null, f14093a, true, 8158, new Class[]{Window.class, Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            m15975b(window, z);
            window.setNavigationBarColor(i);
        }
    }

    /* renamed from: b */
    public static void m15975b(Window window, boolean z) {
        if (!PatchProxy.proxy(new Object[]{window, new Byte(z ? (byte) 1 : 0)}, (Object) null, f14093a, true, 8159, new Class[]{Window.class, Boolean.TYPE}, Void.TYPE).isSupported && f14098f != null) {
            try {
                f14098f.invoke(window, new Object[]{Boolean.valueOf(z)});
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m15969a(Window window) {
        if (!PatchProxy.proxy(new Object[]{window}, (Object) null, f14093a, true, 8160, new Class[]{Window.class}, Void.TYPE).isSupported) {
            window.clearFlags(134217728);
            int i = 1792;
            if (CameraUtil.m15916v()) {
                i = 1984;
            }
            window.getDecorView().setSystemUiVisibility(i);
            window.addFlags(Integer.MIN_VALUE);
            if (Build.VERSION.SDK_INT >= 29) {
                window.addFlags(134217728);
            }
            window.setNavigationBarColor(0);
        }
    }
}
