package com.meizu.update.usage;

import android.content.Context;
import android.os.AsyncTask;
import com.meizu.statsapp.UsageStatsProxy;
import com.meizu.statsapp.p081v3.lib.plugin.constants.UxipConstants;
import com.meizu.update.util.Loger;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.meizu.update.usage.a */
public class CommonUsageCollector {

    /* renamed from: c */
    private static CommonUsageCollector f16343c;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public UsageStatsProxy f16344a;

    /* renamed from: b */
    private Context f16345b;

    private CommonUsageCollector(Context context) {
        this.f16344a = UsageStatsProxy.getInstance(context, true);
        this.f16345b = context.getApplicationContext();
    }

    /* renamed from: a */
    public static final synchronized CommonUsageCollector m17918a(Context context) {
        CommonUsageCollector aVar;
        synchronized (CommonUsageCollector.class) {
            if (f16343c == null) {
                f16343c = new CommonUsageCollector(context);
            }
            aVar = f16343c;
        }
        return aVar;
    }

    /* renamed from: a */
    private void m17919a(final Map<String, String> map) {
        new AsyncTask<Void, Void, Void>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public Void doInBackground(Void... voidArr) {
                try {
                    Loger.m17939a("Write common usage log:");
                    for (String str : map.keySet()) {
                        Loger.m17939a(str + "=" + ((String) map.get(str)));
                    }
                    if (CommonUsageCollector.this.f16344a != null) {
                        CommonUsageCollector.this.f16344a.onLog("com.meizu.update.component", map);
                        return null;
                    }
                    Loger.m17943d("UsageStatsProxy is null!");
                    return null;
                } catch (Exception e) {
                    Loger.m17943d("onLog Error : " + e.getMessage());
                    return null;
                }
            }
        }.execute(new Void[0]);
    }

    /* renamed from: a */
    public void mo24859a(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("package_name", str);
        hashMap.put(UxipConstants.RESPONSE_KEY_VERSION, str2);
        mo24860a("app_check_base", (Map<String, String>) hashMap);
    }

    /* renamed from: a */
    public void mo24860a(String str, Map<String, String> map) {
        if (str != null) {
            if (map == null) {
                map = new HashMap<>();
            }
            map.put("event_name", str);
            map.put("up_sdk_version", "4.1.0");
            m17919a(map);
            return;
        }
        throw new NullPointerException("EventName can't be null!");
    }
}
