package com.meizu.update.p091e;

import com.meizu.update.component.StateListener;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

/* renamed from: com.meizu.update.e.b */
public class StateManager {

    /* renamed from: a */
    private static int f16289a;

    /* renamed from: b */
    private static int f16290b;

    /* renamed from: a */
    public static synchronized void m17772a(int i) {
        synchronized (StateManager.class) {
            if (f16290b != i) {
                f16290b = i;
            }
        }
    }

    /* renamed from: a */
    public static synchronized int m17771a() {
        int i;
        synchronized (StateManager.class) {
            i = f16290b;
        }
        return i;
    }

    /* renamed from: b */
    public static synchronized void m17774b(int i) {
        synchronized (StateManager.class) {
            if (i < 0) {
                try {
                    f16289a = 0;
                } catch (Throwable th) {
                    throw th;
                }
            } else if (i > 100) {
                f16289a = 100;
            } else if (i != f16289a) {
                f16289a = i;
            }
        }
    }

    /* renamed from: b */
    public static synchronized int m17773b() {
        int i;
        synchronized (StateManager.class) {
            i = f16289a;
        }
        return i;
    }

    /* renamed from: c */
    public static void m17775c(int i) {
        if (i != m17771a()) {
            LinkedList<WeakReference<StateListener>> a = StateCallbackKeeper.m17770a();
            if (a != null) {
                for (int i2 = 0; i2 < a.size(); i2++) {
                    StateListener dVar = (StateListener) a.get(i2).get();
                    if (dVar != null) {
                        dVar.mo24754a(i, false);
                    }
                }
            }
            m17772a(i);
        }
    }

    /* renamed from: d */
    public static void m17776d(int i) {
        if (m17773b() != i) {
            LinkedList<WeakReference<StateListener>> a = StateCallbackKeeper.m17770a();
            if (a != null) {
                for (int i2 = 0; i2 < a.size(); i2++) {
                    StateListener dVar = (StateListener) a.get(i2).get();
                    if (dVar != null) {
                        dVar.mo24753a(i);
                    }
                }
            }
            m17774b(i);
        }
    }
}
