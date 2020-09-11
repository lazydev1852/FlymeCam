package com.meizu.media.camera.p077ui;

import android.content.Context;
import com.meizu.flyme.sdk.ContextBuilder;
import com.meizu.media.camera.ListPreference;
import com.meizu.media.camera.PreferenceGroup;
import com.meizu.media.camera.PreferenceInflater;
import com.meizu.media.camera.R;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.ui.ah */
public class SettingController {

    /* renamed from: b */
    public static ChangeQuickRedirect f12733b;

    /* renamed from: a */
    private final Context f12734a;

    /* renamed from: c */
    protected C2436a f12735c;

    /* renamed from: d */
    private final String f12736d;

    /* renamed from: e */
    private final String f12737e;

    /* renamed from: f */
    private PreferenceGroup f12738f;

    /* renamed from: com.meizu.media.camera.ui.ah$a */
    /* compiled from: SettingController */
    public interface C2436a {
        /* renamed from: a */
        void mo18013a(SettingController ahVar, String str);

        /* renamed from: cM */
        boolean mo18135cM();
    }

    public SettingController(Context context, int i) {
        this.f12734a = ContextBuilder.m6349a(context, false, false);
        this.f12736d = context.getString(R.string.setting_on_value);
        this.f12737e = context.getString(R.string.setting_off_value);
        this.f12738f = (PreferenceGroup) new PreferenceInflater(this.f12734a).mo22769a(i);
    }

    /* renamed from: d */
    public void mo21881d(String str, boolean z) {
        if (!PatchProxy.proxy(new Object[]{str, new Byte(z ? (byte) 1 : 0)}, this, f12733b, false, 7704, new Class[]{String.class, Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = LogUtil.f14072b;
            LogUtil.m15942a(aVar, "Click setting item " + str + ", check value:" + z);
            if ("mz_pref_storage_key".equals(str)) {
                mo21883e(str, z);
            } else {
                this.f12738f.mo18590a(str).mo17819a(z ? this.f12736d : this.f12737e);
            }
            mo21877a(this, str);
            CameraUtil.m15847a(this.f12734a, str, z);
        }
    }

    /* renamed from: a */
    public void mo21878a(String str, int i, boolean z) {
        boolean z2 = false;
        Object[] objArr = {str, new Integer(i), new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f12733b;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7705, new Class[]{String.class, Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            ListPreference a = this.f12738f.mo18590a(str);
            if (a != null) {
                a.mo17817a(i);
            }
            mo21877a(this, str);
            Context context = this.f12734a;
            String num = Integer.toString(i);
            if (this.f12735c != null && this.f12735c.mo18135cM()) {
                z2 = true;
            }
            CameraUtil.m15846a(context, str, num, z, z2);
        }
    }

    /* renamed from: e */
    public void mo21883e(String str, boolean z) {
        if (!PatchProxy.proxy(new Object[]{str, new Byte(z ? (byte) 1 : 0)}, this, f12733b, false, 7706, new Class[]{String.class, Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f12738f.mo18590a(str).mo17817a(z ^ true ? 1 : 0);
        }
    }

    /* renamed from: b */
    public boolean mo21879b(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f12733b, false, 7707, new Class[]{String.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if ("mz_pref_storage_key".equals(str)) {
            return mo21882d(str);
        }
        if ("mz_pref_mfll_key".equals(str) && DeviceHelper.f14041k) {
            this.f12738f.mo18590a("mz_pref_mfll_key").mo17818a((CharSequence) this.f12736d);
        }
        return mo21880c(str).equals(this.f12736d);
    }

    /* renamed from: c */
    public String mo21880c(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f12733b, false, 7708, new Class[]{String.class}, String.class);
        return proxy.isSupported ? (String) proxy.result : this.f12738f.mo18590a(str).mo17825k();
    }

    /* renamed from: d */
    public boolean mo21882d(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f12733b, false, 7709, new Class[]{String.class}, Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : mo21880c(str).equals("sdcard");
    }

    /* renamed from: e */
    public CharSequence[] mo21884e(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f12733b, false, 7711, new Class[]{String.class}, CharSequence[].class);
        return proxy.isSupported ? (CharSequence[]) proxy.result : this.f12738f.mo18590a(str).mo17823i();
    }

    /* renamed from: f */
    public int[] mo21885f(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f12733b, false, 7712, new Class[]{String.class}, int[].class);
        return proxy.isSupported ? (int[]) proxy.result : this.f12738f.mo18593b(str).mo17811c();
    }

    /* renamed from: g */
    public int[] mo21886g(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f12733b, false, 7713, new Class[]{String.class}, int[].class);
        return proxy.isSupported ? (int[]) proxy.result : this.f12738f.mo18593b(str).mo17812d();
    }

    /* renamed from: h */
    public int[] mo21887h(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f12733b, false, 7714, new Class[]{String.class}, int[].class);
        return proxy.isSupported ? (int[]) proxy.result : this.f12738f.mo18593b(str).mo17813e();
    }

    /* renamed from: i */
    public int mo21888i(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f12733b, false, 7715, new Class[]{String.class}, Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : this.f12738f.mo18593b(str).mo17826l();
    }

    /* renamed from: j */
    public int mo21889j(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f12733b, false, 7717, new Class[]{String.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        mo21891l(str);
        return this.f12738f.mo18593b(str).mo17814f();
    }

    /* renamed from: k */
    public int mo21890k(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f12733b, false, 7718, new Class[]{String.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        mo21891l(str);
        return this.f12738f.mo18593b(str).mo17815g();
    }

    /* renamed from: l */
    public void mo21891l(String str) {
        ListPreference a;
        if (!PatchProxy.proxy(new Object[]{str}, this, f12733b, false, 7719, new Class[]{String.class}, Void.TYPE).isSupported && (a = this.f12738f.mo18590a(str)) != null) {
            a.mo17827m();
        }
    }

    /* renamed from: a */
    public void mo21876a(C2436a aVar) {
        this.f12735c = aVar;
    }

    /* renamed from: a */
    public void mo21877a(SettingController ahVar, String str) {
        Class[] clsArr = {SettingController.class, String.class};
        if (PatchProxy.proxy(new Object[]{ahVar, str}, this, f12733b, false, 7722, clsArr, Void.TYPE).isSupported || this.f12735c == null) {
            return;
        }
        if ("pref_camera_recordlocation_key".equals(str) || "mz_pref_storage_key".equals(str) || "mz_pref_watch_capture_action_key".equals(str) || "mz_pref_fb_high_picturesize_key".equals(str) || "mz_pref_asd_enable_key".equals(str) || "mz_pref_barcode_in_auto_enable_key".equals(str) || "mz_pref_wide_angle_undistort_enable_key".equals(str)) {
            this.f12735c.mo18013a(ahVar, str);
        }
    }
}
