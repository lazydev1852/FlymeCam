package com.meizu.media.camera.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import com.meizu.media.camera.ComboPreferences;
import com.meizu.media.camera.MzCamcorderProfileManager;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.meizu.media.camera.util.k */
public class CameraSizeDefault {

    /* renamed from: a */
    public static ChangeQuickRedirect f14253a;

    /* renamed from: b */
    private static final LogUtil.C2630a f14254b = new LogUtil.C2630a("CameraSizeDefault");

    /* renamed from: c */
    private static int f14255c = 2;

    /* renamed from: d */
    private static int[] f14256d = {1, 0};

    /* renamed from: a */
    public static void m16167a(Activity activity, int i) {
        Object[] objArr = {activity, new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14253a;
        if (!PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect, true, 7814, new Class[]{Activity.class, Integer.TYPE}, Void.TYPE).isSupported) {
            if (i == f14255c || i == DeviceHelper.f13911bK || i == DeviceHelper.f13912bL || i == DeviceHelper.f14029du || i == DeviceHelper.f13913bM) {
                i = 0;
            }
            SharedPreferences.Editor edit = ComboPreferences.m10008b(activity, i).edit();
            edit.putString("pref_video_quality_key", m16166a(i));
            edit.apply();
        }
    }

    /* renamed from: b */
    public static void m16171b(Activity activity, int i) {
        Object[] objArr = {activity, new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14253a;
        if (!PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect, true, 7815, new Class[]{Activity.class, Integer.TYPE}, Void.TYPE).isSupported) {
            if (i == f14255c || i == DeviceHelper.f13911bK || i == DeviceHelper.f13912bL || i == DeviceHelper.f14029du || i == DeviceHelper.f13913bM) {
                i = 0;
            }
            SharedPreferences.Editor edit = ComboPreferences.m10008b(activity, i).edit();
            edit.putString("pref_camera_picturesize_key", m16165a());
            edit.apply();
        }
    }

    /* renamed from: a */
    public static String m16165a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f14253a, true, 7816, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        String[] a = CameraSizeUtil.m16179a();
        String str = null;
        if (a != null && a.length > 0) {
            str = a[0];
        }
        LogUtil.C2630a aVar = f14254b;
        LogUtil.m15952c(aVar, "getDefaultPictureSize: " + str);
        return str;
    }

    /* renamed from: c */
    public static void m16172c(Activity activity, int i) {
        if (!PatchProxy.proxy(new Object[]{activity, new Integer(i)}, (Object) null, f14253a, true, 7817, new Class[]{Activity.class, Integer.TYPE}, Void.TYPE).isSupported) {
            if (DeviceHelper.f13838R) {
                m16167a(activity, i);
                return;
            }
            for (int a : f14256d) {
                ArrayList<String> a2 = CameraSizeUtil.m16176a(a);
                SharedPreferences.Editor edit = ComboPreferences.m10003a(activity.getApplicationContext()).edit();
                edit.putString("pref_video_quality_key", a2.get(0));
                edit.apply();
            }
        }
    }

    /* renamed from: a */
    public static void m16168a(Activity activity, int i, List<Point> list) {
        Object[] objArr = {activity, new Integer(i), list};
        ChangeQuickRedirect changeQuickRedirect = f14253a;
        if (PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect, true, 7819, new Class[]{Activity.class, Integer.TYPE, List.class}, Void.TYPE).isSupported || list == null) {
            return;
        }
        if (DeviceHelper.f13838R) {
            m16171b(activity, i);
            return;
        }
        String a = CameraUtil.m15834a(activity, list, 1.3333333730697632d);
        SharedPreferences.Editor edit = ComboPreferences.m10003a(activity.getApplicationContext()).edit();
        edit.putString("pref_camera_picturesize_key", a);
        edit.apply();
    }

    /* renamed from: a */
    public static void m16169a(Context context, int i) {
        if (!PatchProxy.proxy(new Object[]{context, new Integer(i)}, (Object) null, f14253a, true, 7820, new Class[]{Context.class, Integer.TYPE}, Void.TYPE).isSupported) {
            if (i == f14255c || i == DeviceHelper.f13911bK || i == DeviceHelper.f13912bL || i == DeviceHelper.f14029du || i == DeviceHelper.f13913bM) {
                i = 0;
            }
            int intValue = Integer.valueOf(m16170b(context, i)).intValue();
            MzCamcorderProfileManager mVar = new MzCamcorderProfileManager();
            mVar.mo20361a(i, intValue);
            SharedPreferences.Editor edit = ComboPreferences.m10003a(context.getApplicationContext()).edit();
            edit.putString("pref_camera_videosize_key", mVar.mo20363b() + "x" + mVar.mo20364c());
            edit.apply();
        }
    }

    /* renamed from: a */
    public static String m16166a(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, (Object) null, f14253a, true, 7821, new Class[]{Integer.TYPE}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (i == f14255c || i == DeviceHelper.f13911bK || i == DeviceHelper.f13912bL || i == DeviceHelper.f13913bM) {
            i = 0;
        }
        if (DeviceHelper.f13838R) {
            return "6";
        }
        return CameraSizeUtil.m16176a(i).get(0);
    }

    /* renamed from: b */
    public static String m16170b(Context context, int i) {
        Object[] objArr = {context, new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14253a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 7822, new Class[]{Context.class, Integer.TYPE}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (i == f14255c || i == DeviceHelper.f13911bK || i == DeviceHelper.f13912bL || i == DeviceHelper.f13913bM) {
            i = 0;
        }
        return ComboPreferences.m10008b(context, i).getString("pref_video_quality_key", m16166a(i));
    }
}
