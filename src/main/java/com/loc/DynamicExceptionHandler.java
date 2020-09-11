package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.lang.Thread;

/* renamed from: com.loc.u */
public final class DynamicExceptionHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private static DynamicExceptionHandler f3416a;

    /* renamed from: b */
    private Thread.UncaughtExceptionHandler f3417b = Thread.getDefaultUncaughtExceptionHandler();

    /* renamed from: c */
    private Context f3418c;

    /* renamed from: d */
    private SDKInfo f3419d;

    private DynamicExceptionHandler(Context context, SDKInfo diVar) {
        this.f3418c = context.getApplicationContext();
        this.f3419d = diVar;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /* renamed from: a */
    static synchronized DynamicExceptionHandler m3941a(Context context, SDKInfo diVar) {
        DynamicExceptionHandler uVar;
        synchronized (DynamicExceptionHandler.class) {
            if (f3416a == null) {
                f3416a = new DynamicExceptionHandler(context, diVar);
            }
            uVar = f3416a;
        }
        return uVar;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        DBOperation nVar;
        Context context;
        String str;
        String a = C1107dj.m3808a(th);
        try {
            if (!TextUtils.isEmpty(a)) {
                if ((a.contains("amapdynamic") || a.contains("admic")) && a.contains("com.amap.api")) {
                    DBOperation nVar2 = new DBOperation(this.f3418c, DynamicFileDBCreator.m3942b());
                    if (a.contains("loc")) {
                        DexFileManager.m3933a(nVar2, this.f3418c, "loc");
                    }
                    if (a.contains("navi")) {
                        DexFileManager.m3933a(nVar2, this.f3418c, "navi");
                    }
                    if (a.contains("sea")) {
                        DexFileManager.m3933a(nVar2, this.f3418c, "sea");
                    }
                    if (a.contains("2dmap")) {
                        DexFileManager.m3933a(nVar2, this.f3418c, "2dmap");
                    }
                    if (a.contains("3dmap")) {
                        DexFileManager.m3933a(nVar2, this.f3418c, "3dmap");
                    }
                } else {
                    if (a.contains("com.autonavi.aps.amapapi.offline")) {
                        nVar = new DBOperation(this.f3418c, DynamicFileDBCreator.m3942b());
                        context = this.f3418c;
                        str = "OfflineLocation";
                    } else if (a.contains("com.data.carrier_v4")) {
                        nVar = new DBOperation(this.f3418c, DynamicFileDBCreator.m3942b());
                        context = this.f3418c;
                        str = "Collection";
                    } else {
                        if (!a.contains("com.autonavi.aps.amapapi.httpdns")) {
                            if (!a.contains("com.autonavi.httpdns")) {
                                if (a.contains("com.amap.api.aiunet")) {
                                    nVar = new DBOperation(this.f3418c, DynamicFileDBCreator.m3942b());
                                    context = this.f3418c;
                                    str = "aiu";
                                } else if (a.contains("com.amap.co") || a.contains("com.amap.opensdk.co") || a.contains("com.amap.location")) {
                                    nVar = new DBOperation(this.f3418c, DynamicFileDBCreator.m3942b());
                                    context = this.f3418c;
                                    str = "co";
                                }
                            }
                        }
                        nVar = new DBOperation(this.f3418c, DynamicFileDBCreator.m3942b());
                        context = this.f3418c;
                        str = "HttpDNS";
                    }
                    DexFileManager.m3933a(nVar, context, str);
                }
            }
        } catch (Throwable th2) {
            BasicLogHandler.m3844a(th2, "DynamicExceptionHandler", "uncaughtException");
        }
        if (this.f3417b != null) {
            this.f3417b.uncaughtException(thread, th);
        }
    }
}
