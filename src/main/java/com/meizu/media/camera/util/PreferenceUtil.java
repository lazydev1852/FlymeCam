package com.meizu.media.camera.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.meizu.media.camera.ComboPreferences;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.util.ak */
public class PreferenceUtil {

    /* renamed from: a */
    public static ChangeQuickRedirect f14105a;

    /* renamed from: a */
    public static void m15981a(Context context, String str, String str2) {
        ComboPreferences a;
        Class[] clsArr = {Context.class, String.class, String.class};
        if (!PatchProxy.proxy(new Object[]{context, str, str2}, (Object) null, f14105a, true, 8170, clsArr, Void.TYPE).isSupported && (a = ComboPreferences.m10003a(context.getApplicationContext())) != null) {
            a.mo19978b().edit().putString(str, str2).apply();
        }
    }

    /* renamed from: b */
    public static void m15982b(Context context, String str, String str2) {
        Class[] clsArr = {Context.class, String.class, String.class};
        if (!PatchProxy.proxy(new Object[]{context, str, str2}, (Object) null, f14105a, true, 8171, clsArr, Void.TYPE).isSupported) {
            ComboPreferences a = ComboPreferences.m10003a(context.getApplicationContext());
            if (a != null) {
                a.mo19976a().edit().putString(str, str2).apply();
                return;
            }
            SharedPreferences.Editor edit = ComboPreferences.m10007b(context).edit();
            edit.putString(str, str2);
            edit.apply();
        }
    }

    /* renamed from: c */
    public static String m15983c(Context context, String str, String str2) {
        ChangeQuickRedirect changeQuickRedirect = f14105a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, str, str2}, (Object) null, changeQuickRedirect, true, 8172, new Class[]{Context.class, String.class, String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        ComboPreferences a = ComboPreferences.m10003a(context.getApplicationContext());
        if (a != null) {
            return a.mo19976a().getString(str, str2);
        }
        return ComboPreferences.m10007b(context).getString(str, str2);
    }

    /* renamed from: a */
    public static String m15980a(Context context, String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, str}, (Object) null, f14105a, true, 8173, new Class[]{Context.class, String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        ComboPreferences a = ComboPreferences.m10003a(context.getApplicationContext());
        return a != null ? a.mo19978b().getString(str, "off") : "off";
    }

    /* renamed from: d */
    public static void m15984d(Context context, String str, String str2) {
        ComboPreferences a;
        Class[] clsArr = {Context.class, String.class, String.class};
        if (!PatchProxy.proxy(new Object[]{context, str, str2}, (Object) null, f14105a, true, 8174, clsArr, Void.TYPE).isSupported && (a = ComboPreferences.m10003a(context.getApplicationContext())) != null) {
            SharedPreferences.Editor edit = a.mo19979c().edit();
            edit.putString(str, str2);
            edit.apply();
        }
    }

    /* renamed from: e */
    public static String m15985e(Context context, String str, String str2) {
        ChangeQuickRedirect changeQuickRedirect = f14105a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, str, str2}, (Object) null, changeQuickRedirect, true, 8175, new Class[]{Context.class, String.class, String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        ComboPreferences a = ComboPreferences.m10003a(context.getApplicationContext());
        if (a != null) {
            return a.mo19979c().getString(str, str2);
        }
        return null;
    }
}
