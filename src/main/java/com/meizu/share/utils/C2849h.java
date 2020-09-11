package com.meizu.share.utils;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;

/* renamed from: com.meizu.share.utils.h */
/* compiled from: Utils */
public class C2849h {
    /* renamed from: a */
    public static boolean m17216a(Context context) {
        if (Build.VERSION.SDK_INT < 17 || Settings.Global.getInt(context.getContentResolver(), "flymelab_flyme_night_mode", 0) != 1) {
            return false;
        }
        return true;
    }
}
