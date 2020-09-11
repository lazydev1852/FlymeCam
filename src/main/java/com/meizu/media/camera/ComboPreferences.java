package com.meizu.media.camera;

import android.app.backup.BackupManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.meizu.media.camera.e */
public class ComboPreferences implements SharedPreferences, SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a */
    public static ChangeQuickRedirect f9889a;

    /* renamed from: g */
    private static WeakHashMap<Context, ComboPreferences> f9890g = new WeakHashMap<>();

    /* renamed from: h */
    private static int f9891h = 2;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public SharedPreferences f9892b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public SharedPreferences f9893c;

    /* renamed from: d */
    private SharedPreferences f9894d;

    /* renamed from: e */
    private String f9895e;

    /* renamed from: f */
    private CopyOnWriteArrayList<SharedPreferences.OnSharedPreferenceChangeListener> f9896f;

    public ComboPreferences(Context context) {
        this.f9895e = context.getPackageName();
        this.f9892b = context.getSharedPreferences(m10011c(context), 0);
        this.f9892b.registerOnSharedPreferenceChangeListener(this);
        this.f9894d = context.getSharedPreferences(context.getPackageName() + "_mode_sort", 0);
        synchronized (f9890g) {
            f9890g.put(context, this);
        }
        this.f9896f = new CopyOnWriteArrayList<>();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (!this.f9892b.contains("pref_version_key") && defaultSharedPreferences.contains("pref_version_key")) {
            m10004a(defaultSharedPreferences);
        }
    }

    /* renamed from: a */
    public static ComboPreferences m10003a(Context context) {
        ComboPreferences eVar;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context}, (Object) null, f9889a, true, 949, new Class[]{Context.class}, ComboPreferences.class);
        if (proxy.isSupported) {
            return (ComboPreferences) proxy.result;
        }
        synchronized (f9890g) {
            eVar = f9890g.get(context);
        }
        return eVar;
    }

    /* renamed from: c */
    private static String m10012c(Context context, int i) {
        Object[] objArr = {context, new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f9889a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 950, new Class[]{Context.class, Integer.TYPE}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (i == f9891h || i == DeviceHelper.f13911bK || i == DeviceHelper.f13912bL || i == DeviceHelper.f14029du || i == DeviceHelper.f13913bM) {
            i = 0;
        }
        return context.getPackageName() + "_preferences_" + i;
    }

    /* renamed from: c */
    private static String m10011c(Context context) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context}, (Object) null, f9889a, true, 951, new Class[]{Context.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return context.getPackageName() + "_preferences_camera";
    }

    /* renamed from: a */
    private void m10005a(Map<String, ?> map, String str, SharedPreferences sharedPreferences) {
        Class[] clsArr = {Map.class, String.class, SharedPreferences.class};
        if (!PatchProxy.proxy(new Object[]{map, str, sharedPreferences}, this, f9889a, false, 952, clsArr, Void.TYPE).isSupported && map.containsKey(str)) {
            Object obj = map.get(str);
            if (obj instanceof String) {
                this.f9892b.edit().putString(str, (String) obj).apply();
            } else if (obj instanceof Integer) {
                this.f9892b.edit().putInt(str, ((Integer) obj).intValue()).apply();
            } else if (obj instanceof Long) {
                this.f9892b.edit().putLong(str, ((Long) obj).longValue()).apply();
            } else if (obj instanceof Float) {
                this.f9892b.edit().putFloat(str, ((Float) obj).floatValue()).apply();
            } else if (obj instanceof Boolean) {
                this.f9892b.edit().putBoolean(str, ((Boolean) obj).booleanValue()).apply();
            }
            sharedPreferences.edit().remove(str).apply();
        }
    }

    /* renamed from: a */
    private void m10004a(SharedPreferences sharedPreferences) {
        if (!PatchProxy.proxy(new Object[]{sharedPreferences}, this, f9889a, false, 953, new Class[]{SharedPreferences.class}, Void.TYPE).isSupported) {
            Map<String, ?> all = sharedPreferences.getAll();
            m10005a(all, "pref_version_key", sharedPreferences);
            m10005a(all, "pref_video_time_lapse_frame_interval_key", sharedPreferences);
            m10005a(all, "pref_camera_id_key", sharedPreferences);
            m10005a(all, "pref_camera_recordlocation_key", sharedPreferences);
            m10005a(all, "pref_camera_first_use_hint_shown_key", sharedPreferences);
            m10005a(all, "pref_video_first_use_hint_shown_key", sharedPreferences);
            m10005a(all, "pref_video_effect_key", sharedPreferences);
        }
    }

    /* renamed from: a */
    public void mo19977a(Context context, int i) {
        Object[] objArr = {context, new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f9889a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 954, new Class[]{Context.class, Integer.TYPE}, Void.TYPE).isSupported) {
            if (i == f9891h || i == DeviceHelper.f13911bK || i == DeviceHelper.f13912bL || i == DeviceHelper.f14029du || i == DeviceHelper.f13913bM) {
                i = 0;
            }
            String c = m10012c(context, i);
            if (this.f9893c != null) {
                this.f9893c.unregisterOnSharedPreferenceChangeListener(this);
            }
            this.f9893c = context.getSharedPreferences(c, 0);
            this.f9893c.registerOnSharedPreferenceChangeListener(this);
        }
    }

    /* renamed from: b */
    public static SharedPreferences m10008b(Context context, int i) {
        Object[] objArr = {context, new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f9889a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 955, new Class[]{Context.class, Integer.TYPE}, SharedPreferences.class);
        if (proxy.isSupported) {
            return (SharedPreferences) proxy.result;
        }
        if (i == f9891h || i == DeviceHelper.f13911bK || i == DeviceHelper.f13912bL || i == DeviceHelper.f14029du || i == DeviceHelper.f13913bM) {
            i = 0;
        }
        return context.getSharedPreferences(m10012c(context, i), 0);
    }

    /* renamed from: b */
    public static SharedPreferences m10007b(Context context) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context}, (Object) null, f9889a, true, 956, new Class[]{Context.class}, SharedPreferences.class);
        if (proxy.isSupported) {
            return (SharedPreferences) proxy.result;
        }
        return context.getSharedPreferences(m10011c(context), 0);
    }

    /* renamed from: a */
    public SharedPreferences mo19976a() {
        return this.f9892b;
    }

    /* renamed from: b */
    public SharedPreferences mo19978b() {
        return this.f9893c;
    }

    /* renamed from: c */
    public SharedPreferences mo19979c() {
        return this.f9894d;
    }

    public Map<String, ?> getAll() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9889a, false, 957, new Class[0], Map.class);
        if (proxy.isSupported) {
            return (Map) proxy.result;
        }
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m10010b(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f9889a, true, 958, new Class[]{String.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (str.equals("pref_video_time_lapse_frame_interval_key") || str.equals("pref_camera_id_key") || str.equals("pref_camera_recordlocation_key") || str.equals("pref_camera_first_use_hint_shown_key") || str.equals("pref_video_first_use_hint_shown_key") || str.equals("pref_video_effect_key") || str.equals("pref_camera_slowmotion_high_frame_rate_key") || str.equals("pref_camera_timer_sound_key") || str.equals("pref_photosphere_picturesize_key") || str.equals("mz_pref_meshline_key") || str.equals("mz_pref_level_key") || str.equals("camera.startup_userduide") || str.equals("mz_pref_mirror") || str.equals("mz_pref_storage_key") || str.equals("mz_pref_voice_action_key") || str.equals("mz_pref_time_mark_key") || str.equals("mz_pref_eis_switch_key") || str.equals("mz_pref_device_mark_key") || str.equals("mz_pref_custom_device_mark_key") || str.equals("mz_pref_meizu_mark_key") || str.equals("mz_pref_funny_hd_key") || str.equals("mz_pref_stereo_level_key") || str.equals("mz_pref_sdcard_key") || str.equals("mz_pref_watch_capture_action_key") || str.equals("funny_mode_launch_time") || str.equals("funny_mode_filter") || str.equals("funny_whiten_skin_level") || str.equals("funny_thin_face_level") || str.equals("ar_mode_guide_show_count") || str.equals("mz_pref_fb_high_picturesize_key") || str.equals("mz_pref_asd_enable_key") || str.equals("mz_pref_barcode_in_auto_enable_key") || str.equals("is_supernight_hint_showed") || str.equals("mz_pref_wide_angle_undistort_enable_key")) {
            return true;
        }
        return false;
    }

    public String getString(String str, String str2) {
        ChangeQuickRedirect changeQuickRedirect = f9889a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, str2}, this, changeQuickRedirect, false, 959, new Class[]{String.class, String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (this.f9893c == null) {
            return str2;
        }
        if (m10010b(str) || !this.f9893c.contains(str)) {
            return this.f9892b.getString(str, str2);
        }
        return this.f9893c.getString(str, str2);
    }

    public int getInt(String str, int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, new Integer(i)}, this, f9889a, false, 960, new Class[]{String.class, Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (m10010b(str) || !this.f9893c.contains(str)) {
            return this.f9892b.getInt(str, i);
        }
        return this.f9893c.getInt(str, i);
    }

    public long getLong(String str, long j) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, new Long(j)}, this, f9889a, false, 961, new Class[]{String.class, Long.TYPE}, Long.TYPE);
        if (proxy.isSupported) {
            return ((Long) proxy.result).longValue();
        }
        if (m10010b(str) || !this.f9893c.contains(str)) {
            return this.f9892b.getLong(str, j);
        }
        return this.f9893c.getLong(str, j);
    }

    public float getFloat(String str, float f) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, new Float(f)}, this, f9889a, false, 962, new Class[]{String.class, Float.TYPE}, Float.TYPE);
        if (proxy.isSupported) {
            return ((Float) proxy.result).floatValue();
        }
        if (m10010b(str) || !this.f9893c.contains(str)) {
            return this.f9892b.getFloat(str, f);
        }
        return this.f9893c.getFloat(str, f);
    }

    public boolean getBoolean(String str, boolean z) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, new Byte(z ? (byte) 1 : 0)}, this, f9889a, false, 963, new Class[]{String.class, Boolean.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (m10010b(str) || !this.f9893c.contains(str)) {
            return this.f9892b.getBoolean(str, z);
        }
        return this.f9893c.getBoolean(str, z);
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, set}, this, f9889a, false, 964, new Class[]{String.class, Set.class}, Set.class);
        if (proxy.isSupported) {
            return (Set) proxy.result;
        }
        throw new UnsupportedOperationException();
    }

    public boolean contains(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f9889a, false, 965, new Class[]{String.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return this.f9893c.contains(str) || this.f9892b.contains(str);
    }

    /* renamed from: com.meizu.media.camera.e$a */
    /* compiled from: ComboPreferences */
    private class C2039a implements SharedPreferences.Editor {

        /* renamed from: a */
        public static ChangeQuickRedirect f9897a;

        /* renamed from: c */
        private SharedPreferences.Editor f9899c;

        /* renamed from: d */
        private SharedPreferences.Editor f9900d;

        C2039a() {
            this.f9899c = ComboPreferences.this.f9892b.edit();
            this.f9900d = ComboPreferences.this.f9893c.edit();
        }

        public boolean commit() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9897a, false, 971, new Class[0], Boolean.TYPE);
            if (proxy.isSupported) {
                return ((Boolean) proxy.result).booleanValue();
            }
            boolean commit = this.f9899c.commit();
            boolean commit2 = this.f9900d.commit();
            if (!commit || !commit2) {
                return false;
            }
            return true;
        }

        public void apply() {
            if (!PatchProxy.proxy(new Object[0], this, f9897a, false, 972, new Class[0], Void.TYPE).isSupported) {
                this.f9899c.apply();
                this.f9900d.apply();
            }
        }

        public SharedPreferences.Editor clear() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9897a, false, 973, new Class[0], SharedPreferences.Editor.class);
            if (proxy.isSupported) {
                return (SharedPreferences.Editor) proxy.result;
            }
            this.f9899c.clear();
            this.f9900d.clear();
            return this;
        }

        public SharedPreferences.Editor remove(String str) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f9897a, false, 974, new Class[]{String.class}, SharedPreferences.Editor.class);
            if (proxy.isSupported) {
                return (SharedPreferences.Editor) proxy.result;
            }
            this.f9899c.remove(str);
            this.f9900d.remove(str);
            return this;
        }

        public SharedPreferences.Editor putString(String str, String str2) {
            ChangeQuickRedirect changeQuickRedirect = f9897a;
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, str2}, this, changeQuickRedirect, false, 975, new Class[]{String.class, String.class}, SharedPreferences.Editor.class);
            if (proxy.isSupported) {
                return (SharedPreferences.Editor) proxy.result;
            }
            if (ComboPreferences.m10010b(str)) {
                this.f9899c.putString(str, str2);
            } else {
                this.f9900d.putString(str, str2);
            }
            return this;
        }

        public SharedPreferences.Editor putInt(String str, int i) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, new Integer(i)}, this, f9897a, false, 976, new Class[]{String.class, Integer.TYPE}, SharedPreferences.Editor.class);
            if (proxy.isSupported) {
                return (SharedPreferences.Editor) proxy.result;
            }
            if (ComboPreferences.m10010b(str)) {
                this.f9899c.putInt(str, i);
            } else {
                this.f9900d.putInt(str, i);
            }
            return this;
        }

        public SharedPreferences.Editor putLong(String str, long j) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, new Long(j)}, this, f9897a, false, 977, new Class[]{String.class, Long.TYPE}, SharedPreferences.Editor.class);
            if (proxy.isSupported) {
                return (SharedPreferences.Editor) proxy.result;
            }
            if (ComboPreferences.m10010b(str)) {
                this.f9899c.putLong(str, j);
            } else {
                this.f9900d.putLong(str, j);
            }
            return this;
        }

        public SharedPreferences.Editor putFloat(String str, float f) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, new Float(f)}, this, f9897a, false, 978, new Class[]{String.class, Float.TYPE}, SharedPreferences.Editor.class);
            if (proxy.isSupported) {
                return (SharedPreferences.Editor) proxy.result;
            }
            if (ComboPreferences.m10010b(str)) {
                this.f9899c.putFloat(str, f);
            } else {
                this.f9900d.putFloat(str, f);
            }
            return this;
        }

        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, new Byte(z ? (byte) 1 : 0)}, this, f9897a, false, 979, new Class[]{String.class, Boolean.TYPE}, SharedPreferences.Editor.class);
            if (proxy.isSupported) {
                return (SharedPreferences.Editor) proxy.result;
            }
            if (ComboPreferences.m10010b(str)) {
                this.f9899c.putBoolean(str, z);
            } else {
                this.f9900d.putBoolean(str, z);
            }
            return this;
        }

        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, set}, this, f9897a, false, 980, new Class[]{String.class, Set.class}, SharedPreferences.Editor.class);
            if (proxy.isSupported) {
                return (SharedPreferences.Editor) proxy.result;
            }
            throw new UnsupportedOperationException();
        }
    }

    public SharedPreferences.Editor edit() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9889a, false, 966, new Class[0], SharedPreferences.Editor.class);
        return proxy.isSupported ? (SharedPreferences.Editor) proxy.result : new C2039a();
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (!PatchProxy.proxy(new Object[]{onSharedPreferenceChangeListener}, this, f9889a, false, 967, new Class[]{SharedPreferences.OnSharedPreferenceChangeListener.class}, Void.TYPE).isSupported) {
            this.f9896f.add(onSharedPreferenceChangeListener);
        }
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (!PatchProxy.proxy(new Object[]{onSharedPreferenceChangeListener}, this, f9889a, false, 968, new Class[]{SharedPreferences.OnSharedPreferenceChangeListener.class}, Void.TYPE).isSupported) {
            this.f9896f.remove(onSharedPreferenceChangeListener);
        }
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (!PatchProxy.proxy(new Object[]{sharedPreferences, str}, this, f9889a, false, 969, new Class[]{SharedPreferences.class, String.class}, Void.TYPE).isSupported) {
            Iterator<SharedPreferences.OnSharedPreferenceChangeListener> it = this.f9896f.iterator();
            while (it.hasNext()) {
                it.next().onSharedPreferenceChanged(this, str);
            }
            BackupManager.dataChanged(this.f9895e);
        }
    }
}
