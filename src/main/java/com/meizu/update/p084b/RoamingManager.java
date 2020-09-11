package com.meizu.update.p084b;

import android.content.Context;
import android.content.SharedPreferences;
import com.meizu.update.push.UpdatePushManager;

/* renamed from: com.meizu.update.b.c */
public class RoamingManager {
    /* renamed from: a */
    public static final int m17554a(Context context) {
        return UpdatePushManager.m17820c(context).getInt("roaming_times", 0);
    }

    /* renamed from: a */
    public static final void m17555a(Context context, int i) {
        if (i < 0) {
            i = 0;
        }
        SharedPreferences.Editor edit = UpdatePushManager.m17820c(context).edit();
        edit.putInt("roaming_times", i);
        edit.commit();
    }

    /* renamed from: b */
    public static boolean m17556b(Context context) {
        return m17554a(context) >= 7;
    }

    /* renamed from: c */
    public static void m17557c(Context context) {
        m17555a(context, m17554a(context) + 1);
    }

    /* renamed from: d */
    public static void m17558d(Context context) {
        if (m17554a(context) > 0) {
            m17555a(context, 0);
        }
    }
}
