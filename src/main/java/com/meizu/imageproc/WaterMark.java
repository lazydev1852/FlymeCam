package com.meizu.imageproc;

import android.util.Log;
import androidx.core.p005os.EnvironmentCompat;
import com.meizu.camera.effectlib.utils.C1200a;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class WaterMark {

    /* renamed from: a */
    public static ChangeQuickRedirect f6466a = null;

    /* renamed from: b */
    private static boolean f6467b = false;

    /* renamed from: c */
    private static boolean f6468c = false;

    private static native boolean nativePhotoWaterMarkNV21(byte[] bArr, int i, int i2, String str, int i3, boolean z);

    /* renamed from: a */
    public static String m6371a(String str, String str2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, str2}, (Object) null, f6466a, true, 566, new Class[]{String.class, String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        try {
            return (String) C1200a.m4824a("android.os.SystemProperties", "get", new Class[]{String.class, String.class}, new Object[]{str, EnvironmentCompat.MEDIA_UNKNOWN});
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    /* renamed from: a */
    public static synchronized boolean m6372a() {
        synchronized (WaterMark.class) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f6466a, true, 567, new Class[0], Boolean.TYPE);
            if (proxy.isSupported) {
                boolean booleanValue = ((Boolean) proxy.result).booleanValue();
                return booleanValue;
            }
            if ((!m6371a("ro.product.locale.language", "null").equals("zh") || !m6371a("ro.product.locale.region", "null").equals("CN")) && !m6371a("ro.product.locale", "null").equals("zh-CN")) {
                f6467b = true;
            } else {
                f6467b = false;
            }
            boolean z = f6467b;
            return z;
        }
    }

    /* renamed from: a */
    public static boolean m6373a(byte[] bArr, int i, int i2, String str, int i3) {
        Object[] objArr = {bArr, new Integer(i), new Integer(i2), str, new Integer(i3)};
        ChangeQuickRedirect changeQuickRedirect = f6466a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 569, new Class[]{byte[].class, Integer.TYPE, Integer.TYPE, String.class, Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (bArr == null || i < 0 || i2 < 0 || str == null) {
            Log.e("WaterMark", "error : dy " + bArr + " width " + i + " height " + i2 + " device_type " + str);
            return false;
        }
        if (!f6468c) {
            m6372a();
            f6468c = true;
            Log.e("WaterMark", " sInternational " + f6467b);
        }
        return nativePhotoWaterMarkNV21(bArr, i, i2, str, i3, f6467b);
    }

    static {
        System.loadLibrary("photo_timestamp");
    }
}
