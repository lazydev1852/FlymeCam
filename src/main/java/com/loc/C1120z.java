package com.loc;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.loc.DexFileManager;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.List;

/* renamed from: com.loc.z */
/* compiled from: Utils */
public final class C1120z {
    /* renamed from: a */
    static PublicKey m3981a() {
        ByteArrayInputStream byteArrayInputStream;
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            byteArrayInputStream = new ByteArrayInputStream(C1102dd.m3744b("MIIDRzCCAi+gAwIBAgIEeuDbsDANBgkqhkiG9w0BAQsFADBTMQswCQYDVQQGEwJjbjELMAkGA1UECBMCYmoxCzAJBgNVBAcTAmJqMQ0wCwYDVQQKEwRvcGVuMQ4wDAYDVQQLEwVnYW9kZTELMAkGA1UEAxMCUWkwIBcNMTYwODAxMDE0ODMwWhgPMjA3MTA1MDUwMTQ4MzBaMFMxCzAJBgNVBAYTAmNuMQswCQYDVQQIEwJiajELMAkGA1UEBxMCYmoxDTALBgNVBAoTBG9wZW4xDjAMBgNVBAsTBWdhb2RlMQswCQYDVQQDEwJRaTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAKpL13mZm4q6AFP5csQE7130Lwq8m+HICy3rBARd9vbw5Cb1wFF96KdhC5P/aASlrPb+6MSyP1nE97p3ygKJWsgxExyvVuOvh1KUqOFuK15oY7JKTk6L4eLCbkBJZV2DLffpW0HGiRpmFG8LJR0sjNOoubSd5R/6XoBwyRglsyVHprjrK2qDRvT3Edgtfvxp4HnUzMsDD3CJRtgsaDw6ECyF7fhYKEz9I6OEEVsPlpbgzRmhSeFDL77/k1mhPve1ZyKGlPcxvSSdLSAlV0hzr5NKlujHll7BbouwDnr6l/0O44AzZ0V/ieft1iBkSLirnlm56uI/8jdh8ANrD1fW4ZUCAwEAAaMhMB8wHQYDVR0OBBYEFBzudtI5UKRvHGDV+VQRzItIj3PqMA0GCSqGSIb3DQEBCwUAA4IBAQBS2EGndgvIBnf7Ce4IhDbm7F5h4L+6TYGmT9acnQbEFY8oUoFblMDgg+cETT44jU/elwbJJVmKhj/WRQl+AdSALBAgDvxq1AcjlGg+c8H3pa2BWlrxNJP9MFLIEI5bA8m5og/Epjut50uemZ9ggoNmJeW0N/a6D8euhYJKOYngUQqDu6cwLj1Ec0ptwrNRbvRXXgzjfJMPE/ii4K/b8JZ+QN2d/bl7QEvKWBSzVueZifV659qAbMh6C9TCVstWWfV53Z3Vyt+duDNU5ed7aWao42Ppw4VHslrJW0V6BXDUhhzgXx28UWY78W7LmYGCtC8PfDId2+k4tPoTNPM6HHP5"));
            try {
                PublicKey publicKey = ((X509Certificate) instance.generateCertificate(byteArrayInputStream)).getPublicKey();
                try {
                    m3982a((Closeable) byteArrayInputStream);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                return publicKey;
            } catch (Throwable th2) {
                th = th2;
                try {
                    BasicLogHandler.m3844a(th, "DyLoader", "init");
                    try {
                        m3982a((Closeable) byteArrayInputStream);
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                    return null;
                } catch (Throwable th4) {
                    th = th4;
                    try {
                        m3982a((Closeable) byteArrayInputStream);
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                    throw th;
                }
            }
        } catch (Throwable th6) {
            byteArrayInputStream = null;
            th = th6;
            m3982a((Closeable) byteArrayInputStream);
            throw th;
        }
    }

    /* renamed from: a */
    public static void m3982a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    static void m3983a(List<DynamicPlugin> list) {
        int i = 0;
        while (i < list.size() - 1) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < list.size(); i3++) {
                DynamicPlugin wVar = list.get(i);
                DynamicPlugin wVar2 = list.get(i3);
                if (m3992b(wVar2.mo13325e(), wVar.mo13325e()) > 0) {
                    list.set(i, wVar2);
                    list.set(i3, wVar);
                }
            }
            i = i2;
        }
    }

    /* renamed from: a */
    private static boolean m3984a(final Context context, DBOperation nVar, DynamicPlugin wVar, DexDownloadItem sVar, final SDKInfo diVar) {
        String str = sVar.f3404c;
        String str2 = sVar.f3405d;
        final String str3 = sVar.f3406e;
        if ("errorstatus".equals(wVar.mo13326f())) {
            try {
                if (!new File(DexFileManager.m3934b(context, diVar.mo13272a(), diVar.mo13274b())).exists()) {
                    if (!TextUtils.isEmpty(DexFileManager.m3925a(context, nVar, diVar))) {
                        LoaderFactory.m3976b().mo13332a().submit(new Runnable() {
                            public final void run() {
                                try {
                                    DexFileManager.m3929a(context, diVar);
                                } catch (Throwable unused) {
                                }
                            }
                        });
                    }
                }
            } catch (Throwable unused) {
            }
            return true;
        }
        final String a = DexFileManager.m3926a(context, sVar.f3403b);
        if (!new File(a).exists()) {
            return false;
        }
        List<DynamicPlugin> b = nVar.mo13304b(DynamicPlugin.m3947a(DexFileManager.m3927a(context, str, str2), str, str2, str3), DynamicPlugin.class);
        if (b != null && b.size() > 0) {
            return true;
        }
        DexFileManager.m3927a(context, str, diVar.mo13274b());
        try {
            final Context context2 = context;
            final DBOperation nVar2 = nVar;
            final SDKInfo diVar2 = diVar;
            LoaderFactory.m3976b().mo13332a().submit(new Runnable() {
                public final void run() {
                    try {
                        DexFileManager.m3930a(context2, nVar2, diVar2, a, str3);
                        DexFileManager.m3929a(context2, diVar2);
                    } catch (Throwable th) {
                        BasicLogHandler.m3844a(th, "dDownLoad", "processDownloadedFile()");
                    }
                }
            });
        } catch (Throwable unused2) {
        }
        return true;
    }

    /* renamed from: a */
    static boolean m3985a(Context context, DexDownloadItem sVar, SDKInfo diVar) {
        DBOperation nVar = new DBOperation(context, DynamicFileDBCreator.m3942b());
        if (m3988a(nVar, sVar)) {
            return true;
        }
        DynamicPlugin a = DexFileManager.C1115a.m3939a(nVar, sVar.f3403b);
        if (a != null) {
            return m3984a(context, nVar, a, sVar, diVar);
        }
        return false;
    }

    /* renamed from: a */
    static boolean m3986a(Context context, boolean z) {
        if (!z) {
            return DeviceInfo.m3729r(context) == 1;
        }
    }

    /* renamed from: a */
    static boolean m3987a(SDKInfo diVar, DexDownloadItem sVar) {
        return diVar != null && diVar.mo13272a().equals(sVar.f3404c) && diVar.mo13274b().equals(sVar.f3405d);
    }

    /* renamed from: a */
    private static boolean m3988a(DBOperation nVar, DexDownloadItem sVar) {
        try {
            List<DynamicPlugin> a = DexFileManager.C1115a.m3940a(nVar, sVar.f3404c, "used");
            return a != null && a.size() > 0 && m3992b(a.get(0).mo13325e(), sVar.f3406e) > 0;
        } catch (Throwable th) {
            BasicLogHandler.m3844a(th, "dDownLoad", "isUsed");
        }
    }

    /* renamed from: a */
    static boolean m3989a(DBOperation nVar, String str, String str2, SDKInfo diVar) {
        DynamicPlugin a = DexFileManager.C1115a.m3939a(nVar, str);
        return a != null && diVar.mo13274b().equals(a.mo13324d()) && m3991a(str2, a.mo13321b());
    }

    /* renamed from: a */
    static boolean m3990a(DexDownloadItem sVar) {
        return Build.VERSION.SDK_INT >= sVar.f3408g && Build.VERSION.SDK_INT <= sVar.f3407f;
    }

    /* renamed from: a */
    static boolean m3991a(String str, String str2) {
        String a = MD5.m3759a(str);
        return a != null && a.equalsIgnoreCase(str2);
    }

    /* renamed from: b */
    private static int m3992b(String str, String str2) {
        try {
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            int min = Math.min(split.length, split2.length);
            int i = 0;
            for (int i2 = 0; i2 < min; i2++) {
                i = split[i2].length() - split2[i2].length();
                if (i != 0 || (i = split[i2].compareTo(split2[i2])) != 0) {
                    break;
                }
            }
            return i != 0 ? i : split.length - split2.length;
        } catch (Exception e) {
            BasicLogHandler.m3844a((Throwable) e, "Utils", "compareVersion");
            return -1;
        }
    }
}
