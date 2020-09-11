package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* renamed from: com.loc.as */
public class MarkInfoManager {

    /* renamed from: a */
    static WeakReference<LogConfig> f2600a;

    /* renamed from: a */
    public static void m3053a(final Context context) {
        SDKLogHandler.m3869d().submit(new Runnable() {
            public final void run() {
                synchronized (MarkInfoManager.class) {
                    LogConfig a = C1059ax.m3069a(MarkInfoManager.f2600a);
                    C1059ax.m3071a(context, a, C1108h.f3355i, 50, 102400, "10");
                    if (a.f2597g == null) {
                        String b = MarkInfoManager.m3054b(context);
                        a.f2597g = new LogJsonDataStrategy(new HeaderAddStrategy(context, new ZipUpdateDataStrategy(), new Base64EncryptProcessor(new RSAAESEncryptProcessor(new GZipEncryptProcessor())), "WImFwcG5hbWUiOiIlcyIsInBrZyI6IiVzIiwiZGl1IjoiJXMi", AppInfo.m3661b(context), AppInfo.m3663c(context), b));
                    }
                    a.f2598h = 14400000;
                    if (TextUtils.isEmpty(a.f2599i)) {
                        a.f2599i = "eKey";
                    }
                    if (a.f2596f == null) {
                        a.f2596f = new TimeUpdateStrategy(context, a.f2598h, a.f2599i, new FileNumUpdateStrategy(5, a.f2591a, new WiFiUplateStrategy(context)));
                    }
                    LogEngine.m3049a(a);
                }
            }
        });
    }

    /* renamed from: b */
    static /* synthetic */ String m3054b(Context context) {
        String v = DeviceInfo.m3733v(context);
        if (!TextUtils.isEmpty(v)) {
            return v;
        }
        String h = DeviceInfo.m3719h(context);
        if (!TextUtils.isEmpty(h)) {
            return h;
        }
        String m = DeviceInfo.m3724m(context);
        return !TextUtils.isEmpty(m) ? m : DeviceInfo.m3708b(context);
    }
}
