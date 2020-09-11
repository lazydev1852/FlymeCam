package com.meizu.media.camera.views;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.preference.Preference;
import com.meizu.common.preference.SwitchPreference;
import com.meizu.media.camera.R;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.PreferenceUtil;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.HashMap;
import java.util.Map;

public class CameraOnlineSwitcherFragment extends BasePreferenceFragment {

    /* renamed from: b */
    public static ChangeQuickRedirect f14442b;

    /* renamed from: c */
    private SwitchPreference f14443c;

    /* renamed from: d */
    private SwitchPreference f14444d;

    /* renamed from: e */
    private SwitchPreference f14445e;

    public CameraOnlineSwitcherFragment() {
        super(R.xml.camera_switcher);
    }

    /* renamed from: a */
    public void mo22800a(Activity activity) {
        if (!PatchProxy.proxy(new Object[]{activity}, this, f14442b, false, 8293, new Class[]{Activity.class}, Void.TYPE).isSupported) {
            m16363a();
            m16367b();
            m16369c();
            if (!CameraModeType.m10985n(CameraModeType.ModeType.FUNNY_SNAP)) {
                getPreferenceScreen().removePreference(this.f14443c);
            }
            if (!CameraModeType.m10985n(CameraModeType.ModeType.AMAZINGAR)) {
                getPreferenceScreen().removePreference(this.f14445e);
            }
        }
    }

    /* renamed from: a */
    private void m16363a() {
        if (!PatchProxy.proxy(new Object[0], this, f14442b, false, 8294, new Class[0], Void.TYPE).isSupported) {
            mo22799a("enable_funny_snap_mode", new Preference.OnPreferenceChangeListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f14446a;

                public boolean onPreferenceChange(final Preference preference, Object obj) {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{preference, obj}, this, f14446a, false, 8301, new Class[]{Preference.class, Object.class}, Boolean.TYPE);
                    if (proxy.isSupported) {
                        return ((Boolean) proxy.result).booleanValue();
                    }
                    if (((Boolean) obj).booleanValue()) {
                        PreferenceUtil.m15982b(CameraOnlineSwitcherFragment.this.getActivity(), "enable_funny_snap_mode", "1");
                        CameraOnlineSwitcherFragment.this.m16366a("enable_funny_snap_mode", true);
                        CameraOnlineSwitcherFragment.this.m16371e();
                        CameraOnlineSwitcherFragment.this.m16370d();
                        return true;
                    } else if (CameraUtil.m15913s() != 0) {
                        new AlertDialog.Builder(CameraOnlineSwitcherFragment.this.getActivity()).setTitle(R.string.mz_online_funny_close_download_title).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).setPositiveButton(17039370, new DialogInterface.OnClickListener() {

                            /* renamed from: a */
                            public static ChangeQuickRedirect f14448a;

                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (!PatchProxy.proxy(new Object[]{dialogInterface, new Integer(i)}, this, f14448a, false, 8302, new Class[]{DialogInterface.class, Integer.TYPE}, Void.TYPE).isSupported) {
                                    ((SwitchPreference) preference).setChecked(false);
                                    PreferenceUtil.m15982b(CameraOnlineSwitcherFragment.this.getActivity(), "enable_funny_snap_mode", "0");
                                    CameraOnlineSwitcherFragment.this.m16366a("enable_funny_snap_mode", false);
                                    CameraOnlineSwitcherFragment.this.m16371e();
                                    CameraOnlineSwitcherFragment.this.m16370d();
                                }
                            }
                        }).show();
                        return false;
                    } else {
                        new AlertDialog.Builder(CameraOnlineSwitcherFragment.this.getActivity()).setTitle(R.string.mz_online_funny_close_title).setMessage(R.string.mz_online_funny_close_msg).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).setPositiveButton(17039370, new DialogInterface.OnClickListener() {

                            /* renamed from: a */
                            public static ChangeQuickRedirect f14451a;

                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (!PatchProxy.proxy(new Object[]{dialogInterface, new Integer(i)}, this, f14451a, false, 8303, new Class[]{DialogInterface.class, Integer.TYPE}, Void.TYPE).isSupported) {
                                    ((SwitchPreference) preference).setChecked(false);
                                    PreferenceUtil.m15982b(CameraOnlineSwitcherFragment.this.getActivity(), "enable_funny_snap_mode", "0");
                                    CameraOnlineSwitcherFragment.this.m16366a("enable_funny_snap_mode", false);
                                    CameraOnlineSwitcherFragment.this.m16371e();
                                    CameraOnlineSwitcherFragment.this.m16370d();
                                }
                            }
                        }).show();
                        return false;
                    }
                }
            });
            this.f14443c = (SwitchPreference) findPreference("enable_funny_snap_mode");
        }
    }

    /* renamed from: b */
    private void m16367b() {
        if (!PatchProxy.proxy(new Object[0], this, f14442b, false, 8295, new Class[0], Void.TYPE).isSupported) {
            mo22799a("pref_camera_recordlocation_key", new Preference.OnPreferenceChangeListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f14454a;

                public boolean onPreferenceChange(Preference preference, Object obj) {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{preference, obj}, this, f14454a, false, 8304, new Class[]{Preference.class, Object.class}, Boolean.TYPE);
                    if (proxy.isSupported) {
                        return ((Boolean) proxy.result).booleanValue();
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    ((SwitchPreference) preference).setChecked(booleanValue);
                    PreferenceUtil.m15982b(CameraOnlineSwitcherFragment.this.getActivity(), "pref_camera_recordlocation_key", booleanValue ? "on" : "off");
                    CameraOnlineSwitcherFragment.this.m16366a("pref_camera_recordlocation_key", booleanValue);
                    return booleanValue;
                }
            });
            this.f14444d = (SwitchPreference) findPreference("pref_camera_recordlocation_key");
        }
    }

    /* renamed from: c */
    private void m16369c() {
        if (!PatchProxy.proxy(new Object[0], this, f14442b, false, 8296, new Class[0], Void.TYPE).isSupported) {
            mo22799a("enable_amazing_ar_mode", new Preference.OnPreferenceChangeListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f14456a;

                public boolean onPreferenceChange(final Preference preference, Object obj) {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{preference, obj}, this, f14456a, false, 8305, new Class[]{Preference.class, Object.class}, Boolean.TYPE);
                    if (proxy.isSupported) {
                        return ((Boolean) proxy.result).booleanValue();
                    }
                    if (!((Boolean) obj).booleanValue()) {
                        new AlertDialog.Builder(CameraOnlineSwitcherFragment.this.getActivity()).setTitle(R.string.mz_online_amazing_ar_close_title).setMessage(R.string.mz_online_funny_close_msg).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).setPositiveButton(17039370, new DialogInterface.OnClickListener() {

                            /* renamed from: a */
                            public static ChangeQuickRedirect f14458a;

                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (!PatchProxy.proxy(new Object[]{dialogInterface, new Integer(i)}, this, f14458a, false, 8306, new Class[]{DialogInterface.class, Integer.TYPE}, Void.TYPE).isSupported) {
                                    ((SwitchPreference) preference).setChecked(false);
                                    PreferenceUtil.m15982b(CameraOnlineSwitcherFragment.this.getActivity(), "enable_amazing_ar_mode", "0");
                                    CameraOnlineSwitcherFragment.this.m16366a("enable_amazing_ar_mode", false);
                                    CameraOnlineSwitcherFragment.this.m16370d();
                                }
                            }
                        }).show();
                        return false;
                    }
                    PreferenceUtil.m15982b(CameraOnlineSwitcherFragment.this.getActivity(), "enable_amazing_ar_mode", "1");
                    CameraOnlineSwitcherFragment.this.m16366a("enable_amazing_ar_mode", true);
                    CameraOnlineSwitcherFragment.this.m16370d();
                    return true;
                }
            });
            this.f14445e = (SwitchPreference) findPreference("enable_amazing_ar_mode");
            this.f14445e.setEnabled(PreferenceUtil.m15983c(getActivity(), "amazing_ar_mode_value", "0").equals("1"));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16366a(String str, boolean z) {
        String str2;
        if (!PatchProxy.proxy(new Object[]{str, new Byte(z ? (byte) 1 : 0)}, this, f14442b, false, 8297, new Class[]{String.class, Boolean.TYPE}, Void.TYPE).isSupported) {
            if (str.equals("enable_funny_snap_mode")) {
                str2 = "funny_snap_enable";
            } else {
                str2 = str.equals("enable_amazing_ar_mode") ? "amazing_ar_enable" : "camera_record_location";
            }
            HashMap hashMap = new HashMap();
            hashMap.put("enable", z ? "1" : "0");
            UsageStatsHelper.m16042a((Context) getActivity()).mo22693a(str2, (Map<String, String>) hashMap);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m16370d() {
        if (!PatchProxy.proxy(new Object[0], this, f14442b, false, 8298, new Class[0], Void.TYPE).isSupported) {
            getActivity().sendBroadcast(new Intent("com.meizu.camera.ACTION_FINISH_ACTIVITY"));
        }
    }

    public void onResume() {
        if (!PatchProxy.proxy(new Object[0], this, f14442b, false, 8299, new Class[0], Void.TYPE).isSupported) {
            super.onResume();
            if (this.f14443c != null) {
                this.f14443c.setChecked(PreferenceUtil.m15983c(getActivity(), "enable_funny_snap_mode", "1").equals("1"));
            }
            if (this.f14445e != null) {
                this.f14445e.setChecked(PreferenceUtil.m15983c(getActivity(), "enable_amazing_ar_mode", "1").equals("1"));
                this.f14445e.setEnabled(PreferenceUtil.m15983c(getActivity(), "amazing_ar_mode_value", "0").equals("1"));
            }
            if (this.f14444d != null) {
                this.f14444d.setChecked(PreferenceUtil.m15983c(getActivity(), "pref_camera_recordlocation_key", "on").equals("on"));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m16371e() {
        if (!PatchProxy.proxy(new Object[0], this, f14442b, false, 8300, new Class[0], Void.TYPE).isSupported) {
            for (int i = 0; i < DeviceHelper.f14035e.length; i++) {
                if (DeviceHelper.f14035e[i].getSortDeterminer() < 0) {
                    int sortDeterminer = DeviceHelper.f14035e[i].getSortDeterminer();
                    DeviceHelper.f14035e[i].setSortDeterminer(CameraModeType.ModeType.FUNNY_SNAP.getSortDeterminer());
                    PreferenceUtil.m15984d(getActivity(), CameraModeType.ModeType.FUNNY_SNAP.toString(), String.valueOf(sortDeterminer));
                    PreferenceUtil.m15984d(getActivity(), DeviceHelper.f14035e[i].toString(), String.valueOf(DeviceHelper.f14035e[i].getSortDeterminer()));
                    return;
                }
            }
        }
    }
}
