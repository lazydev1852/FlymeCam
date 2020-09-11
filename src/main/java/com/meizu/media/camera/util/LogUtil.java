package com.meizu.media.camera.util;

import android.util.Log;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.Formatter;
import java.util.Locale;

/* renamed from: com.meizu.media.camera.util.ac */
public class LogUtil {

    /* renamed from: a */
    public static ChangeQuickRedirect f14071a;

    /* renamed from: b */
    public static final C2630a f14072b = new C2630a("Tracer");
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final C2630a f14073c = new C2630a("LogUtil");

    /* renamed from: a */
    public static boolean m15946a() {
        return true;
    }

    /* renamed from: com.meizu.media.camera.util.ac$a */
    /* compiled from: LogUtil */
    public static final class C2630a {

        /* renamed from: b */
        private static final int f14074b = (23 - "MzCam_".length());

        /* renamed from: a */
        final String f14075a;

        public C2630a(String str) {
            int length = str.length() - f14074b;
            if (length > 0) {
                C2630a b = LogUtil.f14073c;
                LogUtil.m15956e(b, "Tag " + str + " is " + length + " chars longer than limit.");
            }
            StringBuilder sb = new StringBuilder();
            sb.append("MzCam_");
            sb.append(length > 0 ? str.substring(0, f14074b) : str);
            this.f14075a = sb.toString();
        }

        public String toString() {
            return this.f14075a;
        }
    }

    /* renamed from: a */
    public static void m15942a(C2630a aVar, String str) {
        Class[] clsArr = {C2630a.class, String.class};
        if (!PatchProxy.proxy(new Object[]{aVar, str}, (Object) null, f14071a, true, 8115, clsArr, Void.TYPE).isSupported) {
            m15952c(aVar, str);
        }
    }

    /* renamed from: a */
    public static void m15944a(C2630a aVar, String str, boolean z) {
        Object[] objArr = {aVar, str, new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f14071a;
        if (!PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect, true, 8116, new Class[]{C2630a.class, String.class, Boolean.TYPE}, Void.TYPE).isSupported && !z) {
            m15942a(aVar, str);
        }
    }

    /* renamed from: a */
    public static void m15943a(C2630a aVar, String str, Throwable th) {
        Class[] clsArr = {C2630a.class, String.class, Throwable.class};
        if (!PatchProxy.proxy(new Object[]{aVar, str, th}, (Object) null, f14071a, true, 8117, clsArr, Void.TYPE).isSupported) {
            m15953c(aVar, str, th);
        }
    }

    /* renamed from: b */
    public static void m15949b(C2630a aVar, String str) {
        Class[] clsArr = {C2630a.class, String.class};
        if (!PatchProxy.proxy(new Object[]{aVar, str}, (Object) null, f14071a, true, 8118, clsArr, Void.TYPE).isSupported && m15951b(aVar, 6)) {
            Log.e(aVar.toString(), str);
        }
    }

    /* renamed from: b */
    public static void m15950b(C2630a aVar, String str, Throwable th) {
        Class[] clsArr = {C2630a.class, String.class, Throwable.class};
        if (!PatchProxy.proxy(new Object[]{aVar, str, th}, (Object) null, f14071a, true, 8119, clsArr, Void.TYPE).isSupported && m15951b(aVar, 6)) {
            Log.e(aVar.toString(), str, th);
        }
    }

    /* renamed from: c */
    public static void m15952c(C2630a aVar, String str) {
        Class[] clsArr = {C2630a.class, String.class};
        if (!PatchProxy.proxy(new Object[]{aVar, str}, (Object) null, f14071a, true, 8120, clsArr, Void.TYPE).isSupported && m15951b(aVar, 4)) {
            Log.i(aVar.toString(), str);
        }
    }

    /* renamed from: c */
    public static void m15953c(C2630a aVar, String str, Throwable th) {
        Class[] clsArr = {C2630a.class, String.class, Throwable.class};
        if (!PatchProxy.proxy(new Object[]{aVar, str, th}, (Object) null, f14071a, true, 8121, clsArr, Void.TYPE).isSupported && m15951b(aVar, 4)) {
            Log.i(aVar.toString(), str, th);
        }
    }

    /* renamed from: d */
    public static void m15954d(C2630a aVar, String str) {
        Class[] clsArr = {C2630a.class, String.class};
        if (!PatchProxy.proxy(new Object[]{aVar, str}, (Object) null, f14071a, true, 8122, clsArr, Void.TYPE).isSupported) {
            m15952c(aVar, str);
        }
    }

    /* renamed from: e */
    public static void m15956e(C2630a aVar, String str) {
        Class[] clsArr = {C2630a.class, String.class};
        if (!PatchProxy.proxy(new Object[]{aVar, str}, (Object) null, f14071a, true, 8124, clsArr, Void.TYPE).isSupported && m15951b(aVar, 5)) {
            Log.w(aVar.toString(), str);
        }
    }

    /* renamed from: d */
    public static void m15955d(C2630a aVar, String str, Throwable th) {
        Class[] clsArr = {C2630a.class, String.class, Throwable.class};
        if (!PatchProxy.proxy(new Object[]{aVar, str, th}, (Object) null, f14071a, true, 8125, clsArr, Void.TYPE).isSupported && m15951b(aVar, 5)) {
            Log.w(aVar.toString(), str, th);
        }
    }

    /* renamed from: a */
    public static void m15945a(C2630a aVar, String str, Object... objArr) {
        Class[] clsArr = {C2630a.class, String.class, Object[].class};
        if (!PatchProxy.proxy(new Object[]{aVar, str, objArr}, (Object) null, f14071a, true, 8126, clsArr, Void.TYPE).isSupported) {
            Log.i(aVar.toString(), new Formatter(Locale.getDefault()).format(str, objArr).toString());
        }
    }

    /* renamed from: b */
    private static boolean m15951b(C2630a aVar, int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{aVar, new Integer(i)}, (Object) null, f14071a, true, 8127, new Class[]{C2630a.class, Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        try {
            return m15946a() || m15947a(aVar, i);
        } catch (IllegalArgumentException unused) {
            C2630a aVar2 = f14073c;
            m15956e(aVar2, "Tag too long:" + aVar);
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m15947a(C2630a aVar, int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{aVar, new Integer(i)}, (Object) null, f14071a, true, 8128, new Class[]{C2630a.class, Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (Log.isLoggable("MzCam_", i) || Log.isLoggable(aVar.toString(), i)) {
            return true;
        }
        return false;
    }
}
