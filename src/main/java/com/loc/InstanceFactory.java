package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Constructor;

/* renamed from: com.loc.x */
public final class InstanceFactory {
    /* renamed from: a */
    public static Class m3965a(Context context, SDKInfo diVar, String str) {
        BaseLoader c = m3975c(context, diVar);
        try {
            if (m3972a(c)) {
                return c.loadClass(str);
            }
            return null;
        } catch (Throwable th) {
            BasicLogHandler.m3844a(th, "InstanceFactory", "loadpn");
            return null;
        }
    }

    /* renamed from: a */
    public static <T> T m3966a(Context context, SDKInfo diVar, String str, Class cls, Class[] clsArr, Object[] objArr) throws AMapCoreException {
        T a = m3967a(m3975c(context, diVar), str, clsArr, objArr);
        if (a != null) {
            return a;
        }
        T a2 = m3968a(cls, clsArr, objArr);
        if (a2 != null) {
            return a2;
        }
        throw new AMapCoreException("获取对象错误");
    }

    /* renamed from: a */
    private static <T> T m3967a(BaseLoader aaVar, String str, Class[] clsArr, Object[] objArr) {
        Class loadClass;
        try {
            if (!m3972a(aaVar) || (loadClass = aaVar.loadClass(str)) == null) {
                return null;
            }
            Constructor declaredConstructor = loadClass.getDeclaredConstructor(clsArr);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(objArr);
        } catch (Throwable th) {
            BasicLogHandler.m3844a(th, "IFactory", "getWrap");
            return null;
        }
    }

    /* renamed from: a */
    private static <T> T m3968a(Class cls, Class[] clsArr, Object[] objArr) {
        if (cls == null) {
            return null;
        }
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(clsArr);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(objArr);
        } catch (Throwable th) {
            BasicLogHandler.m3844a(th, "IFactory", "gIns2()");
            return null;
        }
    }

    /* renamed from: a */
    public static String m3969a(Context context, SDKInfo diVar) {
        try {
            if (!new File(DexFileManager.m3924a(context)).exists()) {
                return null;
            }
            File file = new File(DexFileManager.m3934b(context, diVar.mo13272a(), diVar.mo13274b()));
            if (file.exists()) {
                return file.getAbsolutePath();
            }
            DexFileManager.m3932a(context, file, diVar);
            return null;
        } catch (Throwable th) {
            BasicLogHandler.m3844a(th, "IFactory", "isdowned");
            return null;
        }
    }

    /* renamed from: a */
    public static void m3970a(final Context context, final String str) {
        try {
            LoaderFactory.m3976b().mo13332a().submit(new Runnable() {
                public final void run() {
                    try {
                        DexFileManager.m3933a(new DBOperation(context, DynamicFileDBCreator.m3942b()), context, str);
                    } catch (Throwable th) {
                        BasicLogHandler.m3844a(th, "InstanceFactory", "rollBack");
                    }
                }
            });
        } catch (Throwable th) {
            BasicLogHandler.m3844a(th, "InstanceFactory", "rollBack");
        }
    }

    /* renamed from: a */
    public static boolean m3971a(Context context, DexDownloadItem sVar, SDKInfo diVar) {
        boolean z = sVar != null && sVar.mo13315c();
        try {
            if (!C1120z.m3987a(diVar, sVar) || !C1120z.m3990a(sVar) || !C1120z.m3986a(context, z) || C1120z.m3985a(context, sVar, diVar)) {
                return false;
            }
            DexFileManager.m3936b(context, diVar.mo13272a());
            return true;
        } catch (Throwable th) {
            BasicLogHandler.m3844a(th, "dDownLoad", "isNeedDownload()");
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m3972a(BaseLoader aaVar) {
        return aaVar != null && aaVar.mo12963a() && aaVar.f2503d;
    }

    /* renamed from: b */
    public static void m3973b(Context context, DexDownloadItem sVar, SDKInfo diVar) {
        if (sVar != null) {
            try {
                if (!TextUtils.isEmpty(sVar.mo13312a()) && !TextUtils.isEmpty(sVar.mo13314b())) {
                    if (!TextUtils.isEmpty(sVar.f3405d)) {
                        new DexDownLoad(context, sVar, diVar).mo13309a();
                    }
                }
            } catch (Throwable th) {
                BasicLogHandler.m3844a(th, "IFactory", "dDownload()");
            }
        }
    }

    /* renamed from: b */
    public static boolean m3974b(Context context, SDKInfo diVar) {
        try {
            if (!new File(DexFileManager.m3924a(context)).exists()) {
                return false;
            }
            File file = new File(DexFileManager.m3934b(context, diVar.mo13272a(), diVar.mo13274b()));
            if (file.exists()) {
                return true;
            }
            DexFileManager.m3932a(context, file, diVar);
            return false;
        } catch (Throwable th) {
            BasicLogHandler.m3844a(th, "IFactory", "isdowned");
            return false;
        }
    }

    /* renamed from: c */
    private static BaseLoader m3975c(Context context, SDKInfo diVar) {
        if (context == null) {
            return null;
        }
        try {
            if (m3974b(context, diVar)) {
                return LoaderFactory.m3976b().mo13330a(context, diVar);
            }
            return null;
        } catch (Throwable th) {
            BasicLogHandler.m3844a(th, "IFactory", "gIns1");
            return null;
        }
    }
}
