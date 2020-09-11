package com.loc;

import android.content.Context;

/* renamed from: com.loc.cn */
public final class RollBackDynamic {

    /* renamed from: a */
    static boolean f3059a = false;

    /* renamed from: b */
    static boolean f3060b = false;

    /* renamed from: c */
    static boolean f3061c = false;

    /* renamed from: d */
    static boolean f3062d = false;

    /* renamed from: e */
    static int f3063e = 0;

    /* renamed from: f */
    static int f3064f = 0;

    /* renamed from: g */
    static boolean f3065g = true;

    /* renamed from: h */
    static boolean f3066h = false;

    /* renamed from: a */
    public static void m3477a(Context context) {
        try {
            if (m3484e(context) && !f3059a) {
                SpUtil.m3485a(context, "loc", "startMark", SpUtil.m3490b(context, "loc", "startMark", 0) + 1);
                f3059a = true;
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "RollBackDynamic", "AddStartMark");
        }
    }

    /* renamed from: a */
    private static void m3478a(Context context, int i) {
        try {
            if (m3484e(context)) {
                SpUtil.m3485a(context, "loc", "endMark", i);
                SpUtil.m3485a(context, "loc", "startMark", i);
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "RollBackDynamic", "resetMark");
        }
    }

    /* renamed from: a */
    public static void m3479a(Context context, SDKInfo diVar) {
        if (!f3062d) {
            f3061c = InstanceFactory.m3974b(context, diVar);
            f3062d = true;
            if (!f3061c && CoreUtil.m3396d()) {
                InstanceFactory.m3970a(context, "loc");
                ReportUtil.m3436a("dexrollbackstatistics", "RollBack because of version error");
            }
        }
    }

    /* renamed from: a */
    public static void m3480a(Context context, String str, String str2) {
        try {
            InstanceFactory.m3970a(context, str);
            ReportUtil.m3436a("dexrollbackstatistics", "RollBack because of " + str2);
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "RollBackDynamic", "rollBackDynamicFile");
        }
    }

    /* renamed from: b */
    public static void m3481b(Context context) {
        try {
            if (m3484e(context) && !f3060b) {
                SpUtil.m3485a(context, "loc", "endMark", SpUtil.m3490b(context, "loc", "endMark", 0) + 1);
                f3060b = true;
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "RollBackDynamic", "AddEndMark");
        }
    }

    /* renamed from: c */
    public static boolean m3482c(Context context) {
        try {
            if (!m3484e(context)) {
                return false;
            }
            if (f3066h) {
                return f3065g;
            }
            if (f3063e == 0) {
                f3063e = SpUtil.m3490b(context, "loc", "startMark", 0);
            }
            if (f3064f == 0) {
                f3064f = SpUtil.m3490b(context, "loc", "endMark", 0);
            }
            if (!f3059a && !f3060b) {
                if (f3063e < f3064f) {
                    m3478a(context, 0);
                    f3065g = true;
                }
                if (f3063e - f3064f > 0 && f3063e > 99) {
                    m3478a(context, 0);
                    f3065g = true;
                }
                if (f3063e - f3064f > 0 && f3063e < 99) {
                    m3478a(context, -2);
                    f3065g = false;
                }
                if (f3063e - f3064f > 0 && f3064f < 0) {
                    m3480a(context, "loc", "checkMark");
                    f3065g = false;
                }
            }
            SpUtil.m3488a(context, "loc", "isload", f3065g);
            f3066h = true;
            return f3065g;
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "RollBackDynamic", "checkMark");
        }
    }

    /* renamed from: d */
    public static boolean m3483d(Context context) {
        try {
            if (!m3484e(context)) {
                return false;
            }
            return SpUtil.m3493b(context, "loc", "isload", false);
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "RollBackDynamic", "isLoad");
            return true;
        }
    }

    /* renamed from: e */
    private static boolean m3484e(Context context) {
        if (!f3062d) {
            m3479a(context, CoreUtil.m3392b());
        }
        return f3061c;
    }
}
