package com.baidu.p020ar.util.sputil;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

/* renamed from: com.baidu.ar.util.sputil.ARSharedPreference */
public class ARSharedPreference {

    /* renamed from: a */
    private static SharedPreferences f2394a;

    /* renamed from: a */
    private static SharedPreferences m2752a(Context context) {
        synchronized (ARSharedPreference.class) {
            if (f2394a == null) {
                synchronized (ARSharedPreference.class) {
                    f2394a = context.getSharedPreferences("ar_info", 0);
                }
            }
        }
        return f2394a;
    }

    public static boolean contains(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).contains(str);
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        return m2752a(context).getBoolean(str, z);
    }

    public static int getInt(Context context, String str, int i) {
        return m2752a(context).getInt(str, i);
    }

    public static boolean putBoolean(Context context, String str, boolean z) {
        return m2752a(context).edit().putBoolean(str, z).commit();
    }

    public static boolean putInt(Context context, String str, int i) {
        return m2752a(context).edit().putInt(str, i).commit();
    }

    public static void removeKey(Context context, String str) {
        m2752a(context).edit().remove(str).commit();
    }

    public static void setPref(Context context, String str, Object obj) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        String valueOf = String.valueOf(obj);
        if (!TextUtils.isEmpty(valueOf)) {
            if (obj instanceof Boolean) {
                edit.putBoolean(str, Boolean.valueOf(valueOf).booleanValue());
            } else if (obj instanceof Float) {
                edit.putFloat(str, Float.valueOf(valueOf).floatValue());
            } else if (obj instanceof Integer) {
                edit.putInt(str, Integer.parseInt(valueOf));
            } else if (obj instanceof Long) {
                edit.putLong(str, Long.parseLong(valueOf));
            } else if (obj instanceof String) {
                edit.putString(str, valueOf);
            }
        }
        edit.commit();
    }
}
