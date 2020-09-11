package com.meizu.update.usage;

import android.content.Context;
import android.os.AsyncTask;
import androidx.core.app.NotificationCompat;
import com.meizu.statsapp.UsageStatsProxy;
import com.meizu.update.util.Loger;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.meizu.update.usage.b */
public class VerifyUsageCollector {

    /* renamed from: b */
    private static VerifyUsageCollector f16348b;

    /* renamed from: a */
    final String f16349a = UUID.randomUUID().toString();

    /* renamed from: c */
    private UsageStatsProxy f16350c;

    /* renamed from: d */
    private Context f16351d;

    public VerifyUsageCollector(Context context) {
        this.f16351d = context.getApplicationContext();
        this.f16350c = UsageStatsProxy.getInstance(context, true);
    }

    /* renamed from: a */
    public static final synchronized VerifyUsageCollector m17923a(Context context) {
        VerifyUsageCollector bVar;
        synchronized (VerifyUsageCollector.class) {
            if (f16348b == null) {
                f16348b = new VerifyUsageCollector(context);
            }
            bVar = f16348b;
        }
        return bVar;
    }

    /* renamed from: a */
    private void m17925a(final String str, final String str2, final String str3) {
        new AsyncTask<Void, Void, Void>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public Void doInBackground(Void... voidArr) {
                HashMap hashMap = new HashMap();
                hashMap.put("local_package_name", str);
                hashMap.put("target_package_name", str2);
                hashMap.put(NotificationCompat.CATEGORY_MESSAGE, str3);
                VerifyUsageCollector.this.m17926a((Map<String, String>) hashMap);
                return null;
            }
        }.execute(new Void[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17926a(Map<String, String> map) {
        try {
            map.put("uuid", this.f16349a);
            Loger.m17939a("Write usage log:");
            for (String next : map.keySet()) {
                Loger.m17939a(next + "=" + map.get(next));
            }
            if (this.f16350c != null) {
                this.f16350c.onLog("update.component.verify", map);
            } else {
                Loger.m17943d("UsageStatsProxy is null!");
            }
        } catch (Exception e) {
            Loger.m17943d("onLog Error : " + e.getMessage());
        }
    }

    /* renamed from: a */
    public void mo24863a(String str, String str2) {
        m17925a(str, str2, (String) null);
    }
}
