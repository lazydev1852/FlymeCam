package com.meizu.media.camera.util;

import android.os.Build;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.util.b */
public class ApiHelper {

    /* renamed from: a */
    public static ChangeQuickRedirect f14200a;

    /* renamed from: b */
    public static final boolean f14201b = (Build.VERSION.SDK_INT >= 15);

    /* renamed from: c */
    public static final boolean f14202c = (Build.VERSION.SDK_INT >= 16);

    /* renamed from: d */
    public static final boolean f14203d = (Build.VERSION.SDK_INT >= 16);

    /* renamed from: e */
    public static final boolean f14204e = (Build.VERSION.SDK_INT >= 16);

    /* renamed from: f */
    public static final boolean f14205f = (Build.VERSION.SDK_INT >= 16);

    /* renamed from: g */
    public static final boolean f14206g = (Build.VERSION.SDK_INT >= 17);

    /* renamed from: h */
    public static final boolean f14207h;

    /* renamed from: i */
    public static final boolean f14208i = false;

    /* renamed from: j */
    public static final boolean f14209j = false;

    /* renamed from: k */
    public static final boolean f14210k = false;

    static {
        boolean z = true;
        if (Build.VERSION.SDK_INT < 18) {
            z = false;
        }
        f14207h = z;
    }

    /* renamed from: a */
    public static int m16125a(Class<?> cls, String str, Class<?> cls2, int i) {
        Object[] objArr = {cls, str, cls2, new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14200a;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect, true, 7725, new Class[]{Class.class, String.class, Class.class, Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        try {
            return cls.getDeclaredField(str).getInt(cls2);
        } catch (Exception unused) {
            return i;
        }
    }
}
