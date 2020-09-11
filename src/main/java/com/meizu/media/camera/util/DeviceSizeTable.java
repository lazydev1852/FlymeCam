package com.meizu.media.camera.util;

import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.Locale;

/* renamed from: com.meizu.media.camera.util.n */
public class DeviceSizeTable {

    /* renamed from: a */
    public static ChangeQuickRedirect f14264a;

    /* renamed from: b */
    private static String[][] f14265b = {new String[]{"480", "480P"}, new String[]{"720", "720P"}, new String[]{"1080", "1080P"}, new String[]{"2160", "4K"}, new String[]{"2176", "4K"}};

    /* renamed from: a */
    private static String m16184a(int i, int i2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, (Object) null, f14264a, true, 7995, new Class[]{Integer.TYPE, Integer.TYPE}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        String valueOf = String.valueOf(Math.min(i, i2));
        for (int i3 = 0; i3 < f14265b.length; i3++) {
            if (f14265b[i3][0].equals(valueOf)) {
                return f14265b[i3][1];
            }
        }
        return valueOf;
    }

    /* renamed from: a */
    public static String m16185a(int i, int i2, String str) {
        Object[] objArr = {new Integer(i), new Integer(i2), str};
        ChangeQuickRedirect changeQuickRedirect = f14264a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 7996, new Class[]{Integer.TYPE, Integer.TYPE, String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        float f = ((float) i) / ((float) i2);
        if (str == null) {
            str = "";
        }
        if (Math.abs(1.7777778f - f) <= 0.04f) {
            Locale locale = Locale.ENGLISH;
            return String.format(locale, "16 : 9" + str, new Object[0]);
        } else if (Math.abs(1.6666666f - f) <= 0.02f) {
            Locale locale2 = Locale.ENGLISH;
            return String.format(locale2, "15 : 9" + str, new Object[0]);
        } else if (Math.abs(1.3333334f - f) <= 0.04f) {
            Locale locale3 = Locale.ENGLISH;
            return String.format(locale3, "4 : 3" + str, new Object[0]);
        } else if (Math.abs(1.5f - f) <= 0.02f) {
            Locale locale4 = Locale.ENGLISH;
            return String.format(locale4, "3 : 2" + str, new Object[0]);
        } else if (Math.abs(2.0f - f) <= 0.02f) {
            Locale locale5 = Locale.ENGLISH;
            return String.format(locale5, "18 : 9" + str, new Object[0]);
        } else if (!DeviceHelper.f13883aj || !DeviceHelper.f13874aa || Math.abs((((float) CameraUtil.m15865b()) / ((float) CameraUtil.m15809a())) - f) > 0.02f) {
            Locale locale6 = Locale.ENGLISH;
            return String.format(locale6, "N : N" + str, new Object[0]);
        } else {
            Locale locale7 = Locale.ENGLISH;
            return String.format(locale7, CameraSizeUtil.m16174a(CameraUtil.m15809a(), CameraUtil.m15865b()) + str, new Object[0]);
        }
    }

    /* renamed from: a */
    public static String m16186a(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f14264a, true, 7998, new Class[]{String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        int indexOf = str.indexOf(120);
        if (indexOf == -1) {
            return str;
        }
        int parseInt = Integer.parseInt(str.substring(0, indexOf));
        int parseInt2 = Integer.parseInt(str.substring(indexOf + 1));
        if (parseInt > parseInt2) {
            return m16185a(parseInt, parseInt2, (String) null);
        }
        return m16185a(parseInt2, parseInt, (String) null);
    }

    /* renamed from: b */
    public static String m16188b(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f14264a, true, 7999, new Class[]{String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        int indexOf = str.indexOf(120);
        if (indexOf == -1) {
            return str;
        }
        int parseInt = Integer.parseInt(str.substring(0, indexOf));
        int parseInt2 = Integer.parseInt(str.substring(indexOf + 1));
        if (parseInt > parseInt2) {
            return m16184a(parseInt, parseInt2);
        }
        return m16184a(parseInt2, parseInt);
    }

    /* renamed from: a */
    public static String m16187a(String str, String str2, String str3) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, str2, str3}, (Object) null, f14264a, true, 8000, new Class[]{String.class, String.class, String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        int indexOf = str2.indexOf(120);
        if (indexOf == -1) {
            return str2;
        }
        int parseInt = Integer.parseInt(str2.substring(0, indexOf));
        int parseInt2 = Integer.parseInt(str2.substring(indexOf + 1));
        if (parseInt > parseInt2) {
            return str + " ( " + m16185a(parseInt, parseInt2, str3) + " ) ";
        }
        return str + " ( " + m16185a(parseInt, parseInt2, str3) + " ) ";
    }
}
