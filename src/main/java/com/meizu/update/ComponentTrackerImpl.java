package com.meizu.update;

import android.content.Context;
import com.meizu.update.util.Loger;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

/* renamed from: com.meizu.update.a */
public class ComponentTrackerImpl {

    /* renamed from: a */
    private static LinkedList<WeakReference<Context>> f16132a;

    /* renamed from: a */
    public static final synchronized void m17520a(Context context) {
        synchronized (ComponentTrackerImpl.class) {
            m17521b();
            if (m17523c(context) == -1) {
                f16132a.add(new WeakReference(context));
                Loger.m17941b("add tracker : " + context);
            } else {
                Loger.m17941b("duplicate tracker : " + context);
            }
        }
    }

    /* renamed from: b */
    public static final synchronized void m17522b(Context context) {
        synchronized (ComponentTrackerImpl.class) {
            int c = m17523c(context);
            if (c != -1) {
                f16132a.remove(c);
                Loger.m17941b("rm tracker : " + context);
            } else {
                Loger.m17941b("cant find tracker : " + context);
            }
            m17524c();
        }
    }

    /* renamed from: a */
    public static synchronized Context m17519a() {
        synchronized (ComponentTrackerImpl.class) {
            if (f16132a != null && f16132a.size() > 0) {
                for (int size = f16132a.size() - 1; size >= 0; size--) {
                    Context context = (Context) f16132a.get(size).get();
                    if (context != null) {
                        return context;
                    }
                }
            }
            return null;
        }
    }

    /* renamed from: b */
    private static void m17521b() {
        if (f16132a == null) {
            Loger.m17941b("init com list");
            f16132a = new LinkedList<>();
        }
    }

    /* renamed from: c */
    private static void m17524c() {
        if (f16132a != null) {
            for (int size = f16132a.size() - 1; size >= 0; size--) {
                if (((Context) f16132a.get(size).get()) == null) {
                    Loger.m17941b("discard no reference list index:" + size);
                    f16132a.remove(size);
                }
            }
            if (f16132a.size() == 0) {
                Loger.m17941b("discard com list");
                f16132a = null;
            }
        }
    }

    /* renamed from: c */
    private static int m17523c(Context context) {
        if (f16132a == null || f16132a.size() <= 0) {
            return -1;
        }
        for (int size = f16132a.size() - 1; size >= 0; size--) {
            if (((Context) f16132a.get(size).get()) == context) {
                return size;
            }
        }
        return -1;
    }
}
