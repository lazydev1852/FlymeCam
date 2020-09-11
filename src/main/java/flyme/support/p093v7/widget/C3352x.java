package flyme.support.p093v7.widget;

import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import androidx.core.view.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: flyme.support.v7.widget.x */
/* compiled from: ViewUtils */
public class C3352x {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static Method f18631a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static Method f18632b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static int f18633c = 1;

    /* renamed from: a */
    public static int m20911a(int i, int i2) {
        return i | i2;
    }

    static {
        new C3354a().start();
    }

    /* renamed from: a */
    public static void m20912a() {
        if (f18631a != null && f18632b != null) {
            return;
        }
        if (f18633c == 2 || f18633c == 0) {
            new C3354a().start();
            f18633c = 1;
        }
    }

    /* renamed from: a */
    public static boolean m20913a(View view) {
        return ViewCompat.getLayoutDirection(view) == 1;
    }

    /* renamed from: a */
    public static boolean m20914a(View view, Rect rect, Rect rect2) {
        if (f18631a != null) {
            try {
                return ((Boolean) f18631a.invoke(view, new Object[]{rect, rect2})).booleanValue();
            } catch (Exception e) {
                Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e);
            }
        }
        return false;
    }

    /* renamed from: b */
    public static void m20916b(final View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                if (f18632b == null) {
                    if (f18633c == 2) {
                        new C3354a().run();
                    }
                    new Handler().postAtFrontOfQueue(new Runnable() {
                        public void run() {
                            C3352x.m20916b(view);
                        }
                    });
                    return;
                }
                f18632b.invoke(view, new Object[0]);
            } catch (InvocationTargetException e) {
                Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e.getTargetException());
            } catch (IllegalAccessException e2) {
                Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static void m20920f() {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                f18631a = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[]{Rect.class, Rect.class});
                if (!f18631a.isAccessible()) {
                    f18631a.setAccessible(true);
                }
            } catch (NoSuchMethodException unused) {
                Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public static void m20921g() {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                Method method = View.class.getMethod("makeOptionalFitsSystemWindows", new Class[0]);
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                f18632b = method;
            } catch (NoSuchMethodException unused) {
                Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
            }
        }
    }

    /* renamed from: flyme.support.v7.widget.x$a */
    /* compiled from: ViewUtils */
    private static class C3354a extends Thread {
        private C3354a() {
        }

        public void run() {
            if (C3352x.f18632b == null) {
                C3352x.m20921g();
            }
            if (C3352x.f18631a == null) {
                C3352x.m20920f();
            }
            int unused = C3352x.f18633c = 2;
        }
    }
}
