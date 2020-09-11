package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;

/* renamed from: com.loc.l  reason: case insensitive filesystem */
public final class SPUtil {

    /* renamed from: a */
    private String f3382a;

    public SPUtil(String str) {
        this.f3382a = MD5.m3762b(TextUtils.isDigitsOnly(str) ? "SPUtil" : str);
    }

    /* renamed from: a */
    public final void mo13297a(Context context, String str, boolean z) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(this.f3382a, 0).edit();
            edit.putBoolean(str, z);
            if (edit == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public final boolean mo13298a(Context context, String str) {
        if (context == null) {
            return true;
        }
        try {
            return context.getSharedPreferences(this.f3382a, 0).getBoolean(str, true);
        } catch (Throwable unused) {
            return true;
        }
    }
}
