package com.meizu.update.p083a;

import android.content.Context;
import android.content.SharedPreferences;
import com.meizu.update.push.UpdatePushManager;
import com.meizu.update.util.Loger;
import com.meizu.update.util.Utility;

/* renamed from: com.meizu.update.a.b */
public class UpdateInfoCache {
    /* renamed from: a */
    public static final void m17543a(Context context) {
        if (context == null) {
            Loger.m17943d("markLastCheckCurrentVersion : context is null!");
            return;
        }
        UpdatePushManager.m17820c(context).edit().putString("check_current_version", Utility.m17970b(context, context.getPackageName())).commit();
    }

    /* renamed from: b */
    public static final String m17545b(Context context) {
        if (context == null) {
            Loger.m17943d("getLastCheckCurrentVersion : context is null!");
            return "";
        }
        SharedPreferences c = UpdatePushManager.m17820c(context);
        if (c != null) {
            return c.getString("check_current_version", "");
        }
        return "";
    }

    /* renamed from: a */
    public static final void m17544a(Context context, String str) {
        UpdatePushManager.m17820c(context).edit().putString("last_check_update_info_data", str).commit();
    }

    /* renamed from: c */
    public static final void m17546c(Context context) {
        UpdatePushManager.m17820c(context).edit().putString("last_check_update_info_data", (String) null).commit();
        Loger.m17942c("clearLastCheckUpdateInfoData");
    }
}
