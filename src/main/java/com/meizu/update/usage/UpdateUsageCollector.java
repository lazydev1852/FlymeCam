package com.meizu.update.usage;

import android.content.Context;
import com.meizu.statsapp.UsageStatsProxy;
import com.meizu.update.util.Loger;
import java.util.HashMap;

public class UpdateUsageCollector {

    /* renamed from: a */
    private static UpdateUsageCollector f16339a;

    /* renamed from: b */
    private UsageStatsProxy f16340b;

    /* renamed from: c */
    private Context f16341c;

    /* renamed from: d */
    private final String f16342d;

    public enum UpdateAction {
        PushMessageReceived("PushMessageReceived"),
        UpdateDisplay_Alert("UpdateDisplay_Alert"),
        UpdateDisplay_Alert_Silent("UpdateDisplay_Silent"),
        UpdateDisplay_Notification("UpdateDisplay_Notification"),
        UpdateDisplay_Notification_Silent("UpdateDisplay_Notification_Silent"),
        UpdateAlert_Yes("UpdateAlert_Yes"),
        UpdateAlert_Ignore("UpdateAlert_Ignore"),
        UpdateAlert_No("UpdateAlert_No"),
        Download_Del("Download_Del"),
        Download_Failure("Download_Failure"),
        Download_Done("Download_Done"),
        Install_Yes("Install_Yes"),
        Install_No("Install_No"),
        Install_Complete("Install_Complete"),
        Install_Failure("Install_Failure"),
        WifiDisplay_Alert("WifiDisplay_Alert"),
        WifiAlert_Yes("WifiAlert_Yes"),
        WifiAlert_No("WifiAlert_No");
        
        private String mName;

        private UpdateAction(String str) {
            this.mName = str;
        }

        public String getName() {
            return this.mName;
        }
    }

    public UpdateUsageCollector(Context context) {
        this.f16341c = context.getApplicationContext();
        this.f16342d = context.getPackageName();
        this.f16340b = UsageStatsProxy.getInstance(context, true);
    }

    /* renamed from: a */
    public static final synchronized UpdateUsageCollector m17913a(Context context) {
        UpdateUsageCollector updateUsageCollector;
        synchronized (UpdateUsageCollector.class) {
            if (f16339a == null) {
                f16339a = new UpdateUsageCollector(context);
            }
            updateUsageCollector = f16339a;
        }
        return updateUsageCollector;
    }

    /* renamed from: a */
    public void mo24855a(UpdateAction updateAction, String str) {
        mo24856a(updateAction, str, (String) null);
    }

    /* renamed from: a */
    public void mo24856a(UpdateAction updateAction, String str, String str2) {
        mo24857a(updateAction, str, str2, false);
    }

    /* renamed from: a */
    public void mo24857a(UpdateAction updateAction, String str, String str2, boolean z) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("update_action", updateAction.getName());
            hashMap.put("package_name", this.f16342d);
            if (str != null) {
                hashMap.put("new_version", str);
            }
            if (str2 != null) {
                hashMap.put("old_version", str2);
            }
            if (z) {
                hashMap.put("update_manual", "manual");
            }
            hashMap.put("up_sdk_version", "4.1.0");
            if (this.f16340b != null) {
                this.f16340b.onLog("update.component.app", hashMap);
            } else {
                Loger.m17943d("UsageStatsProxy is null!");
            }
        } catch (Exception e) {
            Loger.m17943d("onLog Error : " + e.getMessage());
        }
    }
}
