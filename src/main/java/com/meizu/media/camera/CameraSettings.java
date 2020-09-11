package com.meizu.media.camera;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import com.meizu.media.camera.camcontroller.CameraProxyV1;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import com.meizu.savior.SaviorJobService;

/* renamed from: com.meizu.media.camera.d */
public class CameraSettings {

    /* renamed from: a */
    public static ChangeQuickRedirect f9274a;

    /* renamed from: b */
    private static final LogUtil.C2630a f9275b = new LogUtil.C2630a("CameraSettings");

    /* renamed from: a */
    public static int m9776a(Context context) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context}, (Object) null, f9274a, true, 865, new Class[]{Context.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        try {
            return context.getResources().getInteger(R.integer.max_video_recording_length);
        } catch (Resources.NotFoundException unused) {
            return 0;
        }
    }

    /* renamed from: a */
    public static void m9780a(SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2) {
        int i;
        if (!PatchProxy.proxy(new Object[]{sharedPreferences, sharedPreferences2}, (Object) null, f9274a, true, 866, new Class[]{SharedPreferences.class, SharedPreferences.class}, Void.TYPE).isSupported) {
            try {
                i = sharedPreferences.getInt("pref_local_version_key", 0);
            } catch (Exception unused) {
                i = 0;
            }
            LogUtil.C2630a aVar = f9275b;
            LogUtil.m15942a(aVar, "upgradeLocalPreferences version:" + i + ",CURRENT_LOCAL_VERSION:" + 6);
            if (i != 6) {
                if (i == 1) {
                    sharedPreferences.edit().remove("pref_camera_picturesize_key").remove("mz_pref_meter_separate_key").remove("pref_video_quality_key").remove("pref_camera_videosize_key").apply();
                }
                if (i == 3) {
                    String string = sharedPreferences.getString("mz_pref_fb_key", "off");
                    if (string.equals("smart")) {
                        sharedPreferences.edit().putString("mz_pref_fb_key", "smart_mile").apply();
                    } else if (string.equals("pro")) {
                        sharedPreferences.edit().putString("mz_pref_fb_key", "smart_depth").apply();
                    }
                }
                if (i == 4 && m9782b(sharedPreferences) == 1) {
                    sharedPreferences.edit().putString("pref_camera_flashmode_key", "off").apply();
                }
                if (i == 5 && m9782b(sharedPreferences) != 1) {
                    sharedPreferences.edit().putString("mz_pref_hdr_key", sharedPreferences2.getString("mz_pref_hdr_key", "off")).apply();
                    sharedPreferences2.edit().remove("mz_pref_hdr_key").apply();
                }
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putInt("pref_local_version_key", 6);
                edit.apply();
            }
        }
    }

    /* renamed from: a */
    public static void m9778a(SharedPreferences sharedPreferences) {
        if (!PatchProxy.proxy(new Object[]{sharedPreferences}, (Object) null, f9274a, true, 867, new Class[]{SharedPreferences.class}, Void.TYPE).isSupported) {
            m9786c(sharedPreferences);
            m9788d(sharedPreferences);
        }
    }

    /* renamed from: c */
    private static void m9786c(SharedPreferences sharedPreferences) {
        int i;
        if (!PatchProxy.proxy(new Object[]{sharedPreferences}, (Object) null, f9274a, true, 868, new Class[]{SharedPreferences.class}, Void.TYPE).isSupported) {
            try {
                i = sharedPreferences.getInt("pref_version_key", 0);
            } catch (Exception unused) {
                i = 0;
            }
            if (i != 2) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                if (i == 0) {
                    i = 1;
                }
                if (i == 1) {
                    edit.remove("pref_camera_timer_key");
                }
                edit.putInt("pref_version_key", 2);
                edit.apply();
            }
        }
    }

    /* renamed from: d */
    private static void m9788d(SharedPreferences sharedPreferences) {
        int b;
        if (!PatchProxy.proxy(new Object[]{sharedPreferences}, (Object) null, f9274a, true, 869, new Class[]{SharedPreferences.class}, Void.TYPE).isSupported && (b = m9782b(sharedPreferences)) != 0) {
            int i = CameraProxyV1.f9121e;
            if (b < 0 || b >= i) {
                m9784b(sharedPreferences, 0);
            }
        }
    }

    /* renamed from: b */
    public static int m9782b(SharedPreferences sharedPreferences) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{sharedPreferences}, (Object) null, f9274a, true, 870, new Class[]{SharedPreferences.class}, Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : Integer.parseInt(sharedPreferences.getString("pref_camera_id_key", "0"));
    }

    /* renamed from: a */
    public static void m9779a(SharedPreferences sharedPreferences, int i) {
        if (!PatchProxy.proxy(new Object[]{sharedPreferences, new Integer(i)}, (Object) null, f9274a, true, 871, new Class[]{SharedPreferences.class, Integer.TYPE}, Void.TYPE).isSupported) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt(SaviorJobService.CTA_PERMISSION, i);
            edit.apply();
        }
    }

    /* renamed from: b */
    public static void m9784b(SharedPreferences sharedPreferences, int i) {
        if (!PatchProxy.proxy(new Object[]{sharedPreferences, new Integer(i)}, (Object) null, f9274a, true, 872, new Class[]{SharedPreferences.class, Integer.TYPE}, Void.TYPE).isSupported) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("pref_camera_id_key", Integer.toString(i));
            edit.apply();
        }
    }

    /* renamed from: a */
    public static String m9777a(ComboPreferences eVar) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{eVar}, (Object) null, f9274a, true, 873, new Class[]{ComboPreferences.class}, String.class);
        return proxy.isSupported ? (String) proxy.result : eVar.getString("pref_camera_picturesize_key", (String) null);
    }

    /* renamed from: b */
    public static String m9783b(ComboPreferences eVar) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{eVar}, (Object) null, f9274a, true, 874, new Class[]{ComboPreferences.class}, String.class);
        return proxy.isSupported ? (String) proxy.result : eVar.getString("pref_camera_videosize_key", (String) null);
    }

    /* renamed from: a */
    public static void m9781a(ComboPreferences eVar, String str, String str2) {
        Class[] clsArr = {ComboPreferences.class, String.class, String.class};
        if (!PatchProxy.proxy(new Object[]{eVar, str, str2}, (Object) null, f9274a, true, 875, clsArr, Void.TYPE).isSupported) {
            SharedPreferences.Editor edit = eVar.edit();
            edit.putString(str, str2);
            edit.apply();
        }
    }

    /* renamed from: c */
    public static int m9785c(ComboPreferences eVar) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{eVar}, (Object) null, f9274a, true, 876, new Class[]{ComboPreferences.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        String string = eVar.getString("pref_camera_exposure_key", "0");
        try {
            return Integer.parseInt(string);
        } catch (Exception unused) {
            LogUtil.C2630a aVar = f9275b;
            LogUtil.m15949b(aVar, "Invalid exposure: " + string);
            return 0;
        }
    }

    /* renamed from: d */
    public static String m9787d(ComboPreferences eVar) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{eVar}, (Object) null, f9274a, true, 877, new Class[]{ComboPreferences.class}, String.class);
        return proxy.isSupported ? (String) proxy.result : eVar.getString("pref_camera_exposure_key", "0");
    }
}
