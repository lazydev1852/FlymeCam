package com.meizu.update.p084b;

import android.content.Context;
import android.content.SharedPreferences;
import com.meizu.update.push.UpdatePushManager;

/* renamed from: com.meizu.update.b.b */
public class CheckInterval {
    /* renamed from: a */
    public static final boolean m17551a(Context context, long j) {
        long a = m17550a(context);
        if (a <= 0) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (j <= 0) {
            j = 86400000;
        }
        if (Math.abs(currentTimeMillis - a) > j) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static final long m17550a(Context context) {
        SharedPreferences c = UpdatePushManager.m17820c(context);
        if (c != null) {
            return c.getLong("check_update_time", 0);
        }
        return 0;
    }

    /* renamed from: b */
    public static final void m17552b(Context context) {
        m17553b(context, System.currentTimeMillis());
    }

    /* renamed from: b */
    private static final void m17553b(Context context, long j) {
        SharedPreferences.Editor edit = UpdatePushManager.m17820c(context).edit();
        edit.putLong("check_update_time", j);
        edit.commit();
    }
}
