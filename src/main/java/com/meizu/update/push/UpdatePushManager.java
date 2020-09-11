package com.meizu.update.push;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.PushManager;
import com.meizu.statsapp.p081v3.lib.plugin.constants.UxipConstants;
import com.meizu.update.p091e.StateManager;
import com.meizu.update.service.MzUpdateComponentService;
import com.meizu.update.usage.UpdateUsageCollector;
import com.meizu.update.util.AppUpgradeServiceHelper;
import com.meizu.update.util.Loger;
import com.meizu.update.util.Utility;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.meizu.update.push.b */
public class UpdatePushManager {
    /* renamed from: a */
    public static boolean m17816a(Context context, String str) {
        try {
            String packageName = context.getPackageName();
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has(packageName)) {
                return false;
            }
            try {
                UpdateUsageCollector.m17913a(context).mo24856a(UpdateUsageCollector.UpdateAction.PushMessageReceived, jSONObject.getJSONObject(packageName).getString(UxipConstants.RESPONSE_KEY_VERSION), Utility.m17970b(context, packageName));
                return true;
            } catch (Exception unused) {
                return true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Loger.m17942c("unknown server push : " + str);
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m17815a(Context context, Intent intent) {
        try {
            String packageName = context.getPackageName();
            String string = intent.getExtras().getString(packageName);
            if (TextUtils.isEmpty(string)) {
                return false;
            }
            try {
                UpdateUsageCollector.m17913a(context).mo24856a(UpdateUsageCollector.UpdateAction.PushMessageReceived, new JSONObject(string).getString(UxipConstants.RESPONSE_KEY_VERSION), Utility.m17970b(context, packageName));
                return true;
            } catch (Exception unused) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Loger.m17942c("unknown server push : " + intent);
            return false;
        }
    }

    /* renamed from: a */
    public static void m17813a(Context context) {
        if (!TextUtils.isEmpty(PushManager.getPushId(context)) && !m17819b(context)) {
            MzUpdateComponentService.m17857b(context);
        }
    }

    /* renamed from: b */
    public static final void m17817b(Context context, String str) {
        SharedPreferences.Editor edit = m17820c(context).edit();
        edit.putString("skip_version", str);
        edit.commit();
    }

    /* renamed from: c */
    public static final boolean m17821c(Context context, String str) {
        String string = m17820c(context).getString("skip_version", (String) null);
        return !TextUtils.isEmpty(string) && string.equals(str);
    }

    /* renamed from: a */
    public static final void m17814a(Context context, boolean z) {
        SharedPreferences.Editor edit = m17820c(context).edit();
        if (z) {
            edit.putString("push_version", Utility.m17960a(context));
        } else {
            edit.putString("push_version", "");
        }
        edit.commit();
    }

    /* renamed from: b */
    public static final boolean m17819b(Context context) {
        String string = m17820c(context).getString("push_version", (String) null);
        if (!TextUtils.isEmpty(string)) {
            return string.equals(Utility.m17960a(context));
        }
        return false;
    }

    /* renamed from: c */
    public static final SharedPreferences m17820c(Context context) {
        return context.getSharedPreferences("mz_update_component_history", 0);
    }

    /* renamed from: b */
    public static final void m17818b(Context context, boolean z) {
        if (!m17823d(context)) {
            Loger.m17942c("cloud server not enable, skip register");
        } else if (!z && AppUpgradeServiceHelper.m17931a()) {
            Loger.m17942c("Current System supports app register.Forget it!");
        } else if (TextUtils.isEmpty(PushManager.getPushId(context))) {
            Loger.m17940b(context, "Request sip register");
            String o = Utility.m17996o(context);
            String p = Utility.m17997p(context);
            if (TextUtils.isEmpty(o) || TextUtils.isEmpty(p)) {
                PushManager.register(context);
            } else {
                PushManager.register(context, o, p);
            }
        } else if (!m17819b(context)) {
            MzUpdateComponentService.m17857b(context);
        }
    }

    /* renamed from: d */
    public static final boolean m17823d(Context context) {
        return !TextUtils.isEmpty(Utility.m17970b(context, "com.meizu.cloud"));
    }

    /* renamed from: d */
    public static final void m17822d(Context context, String str) {
        if (str != null && !TextUtils.isEmpty(str)) {
            SharedPreferences c = m17820c(context);
            SharedPreferences.Editor edit = c.edit();
            edit.putInt(str, c.getInt(str, 0) + 1);
            edit.commit();
        }
    }

    /* renamed from: e */
    public static final int m17824e(Context context, String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        return m17820c(context).getInt(str, 0);
    }

    /* renamed from: f */
    public static void m17825f(Context context, String str) {
        int e = m17824e(context, str);
        Loger.m17942c("ignoredUpdate times : " + (e + 1));
        if (e >= 2) {
            m17817b(context, str);
            MzUpdateComponentService.m17868d(context);
            StateManager.m17775c(0);
            return;
        }
        m17822d(context, str);
    }
}
