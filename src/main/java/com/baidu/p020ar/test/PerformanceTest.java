package com.baidu.p020ar.test;

/* renamed from: com.baidu.ar.test.PerformanceTest */
public class PerformanceTest {

    /* renamed from: a */
    private static boolean f2307a = false;

    /* renamed from: b */
    private static boolean f2308b = true;

    /* renamed from: c */
    private static boolean f2309c = true;

    /* renamed from: d */
    private static boolean f2310d = true;

    /* renamed from: e */
    private static boolean f2311e = true;

    /* renamed from: f */
    private static int f2312f = 25;

    public static int getMaxFrameRate() {
        return f2312f;
    }

    public static boolean isDrawCamera() {
        return f2308b || !f2307a;
    }

    public static boolean isOpen3DEngine() {
        return f2309c || !f2307a;
    }

    public static boolean isOpenIMU() {
        return f2310d || !f2307a;
    }

    public static boolean isOpenSlam() {
        return f2311e || !f2307a;
    }

    public static boolean isTestOpen() {
        return f2307a;
    }

    public static void setDrawCamera(boolean z) {
        f2308b = z;
    }

    public static void setMaxFrameRate(int i) {
        f2312f = i;
    }

    public static void setOpen3DEngine(boolean z) {
        f2309c = z;
    }

    public static void setOpenIMU(boolean z) {
        f2310d = z;
    }

    public static void setOpenSlam(boolean z) {
        f2311e = z;
    }

    public static void setTestOpen(boolean z) {
        f2307a = z;
    }
}
