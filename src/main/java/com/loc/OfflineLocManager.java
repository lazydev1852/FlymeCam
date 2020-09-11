package com.loc;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* renamed from: com.loc.au */
public class OfflineLocManager {

    /* renamed from: a */
    static int f2605a = 1000;

    /* renamed from: b */
    static boolean f2606b = false;

    /* renamed from: c */
    static int f2607c = 20;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static WeakReference<LogConfig> f2608d = null;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static int f2609e = 10;

    /* renamed from: a */
    public static synchronized void m3058a(int i, boolean z, int i2) {
        synchronized (OfflineLocManager.class) {
            f2605a = i;
            f2606b = z;
            if (i2 < 10 || i2 > 100) {
                i2 = 20;
            }
            f2607c = i2;
            if (i2 / 5 > f2609e) {
                f2609e = f2607c / 5;
            }
        }
    }

    /* renamed from: a */
    public static void m3059a(final Context context) {
        SDKLogHandler.m3869d().submit(new Runnable() {
            public final void run() {
                try {
                    LogConfig a = C1059ax.m3069a(OfflineLocManager.f2608d);
                    C1059ax.m3071a(context, a, C1108h.f3354h, OfflineLocManager.f2605a, 2097152, "6");
                    a.f2598h = 14400000;
                    if (a.f2597g == null) {
                        Base64EncryptProcessor dmVar = new Base64EncryptProcessor(new GZipEncryptProcessor(new RSAAESEncryptProcessor()));
                        a.f2597g = new LogJsonDataStrategy(new HeaderAddStrategy(context, new ZipUpdateDataStrategy(), dmVar, new String(ConstConfig.m3836a(10)), AppInfo.m3666f(context), DeviceInfo.m3733v(context), DeviceInfo.m3724m(context), DeviceInfo.m3719h(context), DeviceInfo.m3703a(), Build.MANUFACTURER, Build.DEVICE, DeviceInfo.m3735x(context), AppInfo.m3663c(context), Build.MODEL, AppInfo.m3664d(context), AppInfo.m3661b(context)));
                    }
                    if (TextUtils.isEmpty(a.f2599i)) {
                        a.f2599i = "fKey";
                    }
                    a.f2596f = new TimeUpdateStrategy(context, a.f2598h, a.f2599i, new MobileUpdateStrategy(context, OfflineLocManager.f2606b, OfflineLocManager.f2609e * 1024, OfflineLocManager.f2607c * 1024));
                    LogEngine.m3049a(a);
                } catch (Throwable th) {
                    SDKLogHandler.m3867b(th, "ofm", "uold");
                }
            }
        });
    }

    /* renamed from: a */
    public static synchronized void m3060a(final OfflineLocEntity atVar, final Context context) {
        synchronized (OfflineLocManager.class) {
            SDKLogHandler.m3869d().submit(new Runnable() {
                public final void run() {
                    try {
                        synchronized (OfflineLocManager.class) {
                            String l = Long.toString(System.currentTimeMillis());
                            LogConfig a = C1059ax.m3069a(OfflineLocManager.f2608d);
                            C1059ax.m3071a(context, a, C1108h.f3354h, OfflineLocManager.f2605a, 2097152, "6");
                            if (a.f2595e == null) {
                                a.f2595e = new Base64EncryptProcessor(new GZipEncryptProcessor(new RSAAESEncryptProcessor(new GZipEncryptProcessor())));
                            }
                            LogEngine.m3050a(l, atVar.mo13031a(), a);
                        }
                    } catch (Throwable th) {
                        SDKLogHandler.m3867b(th, "ofm", "aple");
                    }
                }
            });
        }
    }
}
