package com.meizu.update.p085c.p089d;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.baidu.p020ar.parser.ARResourceKey;
import com.meizu.statsapp.UsageStatsProxy;
import com.meizu.update.util.Loger;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.meizu.update.c.d.a */
public class DownloadUsageCollector {

    /* renamed from: a */
    final String f16196a = UUID.randomUUID().toString();

    /* renamed from: b */
    private UsageStatsProxy f16197b;

    /* renamed from: c */
    private Context f16198c;

    public DownloadUsageCollector(Context context) {
        this.f16197b = UsageStatsProxy.getInstance(context, true);
        this.f16198c = context;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17651a(Map<String, String> map) {
        try {
            map.put("uuid", this.f16196a);
            map.put("clientip", IpHelper.m17658a());
            String str = null;
            if (map.containsKey(ARResourceKey.HTTP_AR_REDIRECT_URL)) {
                str = map.get(ARResourceKey.HTTP_AR_REDIRECT_URL);
            } else if (map.containsKey("requrl")) {
                str = map.get("requrl");
            }
            if (!TextUtils.isEmpty(str)) {
                String host = Uri.parse(str).getHost();
                if (!TextUtils.isEmpty(host)) {
                    map.put("serverip", IpHelper.m17659a(host));
                }
            }
            map.put("product", this.f16198c.getPackageName());
            map.put("up_sdk_version", "4.1.0");
            Loger.m17939a("Write usage log:");
            for (String next : map.keySet()) {
                Loger.m17939a(next + "=" + map.get(next));
            }
            if (this.f16197b != null) {
                this.f16197b.onLog("dns.download.app", map);
            } else {
                Loger.m17943d("UsageStatsProxy is null!");
            }
        } catch (Exception e) {
            Loger.m17943d("onLog Error : " + e.getMessage());
        }
    }

    /* renamed from: a */
    private void m17650a(String str, int i, String str2, int i2, String str3, String str4, String str5) {
        final int i3 = i;
        final String str6 = str;
        final String str7 = str2;
        final int i4 = i2;
        final String str8 = str3;
        final String str9 = str4;
        final String str10 = str5;
        new AsyncTask<Void, Void, Void>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public Void doInBackground(Void... voidArr) {
                HashMap hashMap = new HashMap();
                hashMap.put("result_mark", String.valueOf(i3));
                if (str6 != null) {
                    hashMap.put("package_name", str6);
                }
                if (str7 != null) {
                    hashMap.put("requrl", str7);
                }
                hashMap.put("rescode", String.valueOf(i4));
                if (str8 != null && !str8.equalsIgnoreCase(str7)) {
                    hashMap.put(ARResourceKey.HTTP_AR_REDIRECT_URL, str8);
                }
                if (str9 != null) {
                    hashMap.put(NotificationCompat.CATEGORY_MESSAGE, str9);
                }
                if (str10 != null) {
                    hashMap.put("version_log", str10);
                }
                DownloadUsageCollector.this.m17651a(hashMap);
                return null;
            }
        }.execute(new Void[0]);
    }

    /* renamed from: a */
    public void mo24745a(String str, String str2, int i, String str3, String str4, String str5) {
        m17650a(str, 3, str2, i, str3, str4, str5);
    }

    /* renamed from: b */
    public void mo24747b(String str, String str2, int i, String str3, String str4, String str5) {
        m17650a(str, 2, str2, i, str3, str4, str5);
    }

    /* renamed from: a */
    public void mo24746a(String str, String str2, String str3, String str4, String str5) {
        m17650a(str, 1, str2, ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, str3, str4, str5);
    }

    /* renamed from: b */
    public void mo24748b(String str, String str2, String str3, String str4, String str5) {
        m17650a(str, 4, str2, 100002, str3, str4, str5);
    }

    /* renamed from: c */
    public void mo24749c(String str, String str2, String str3, String str4, String str5) {
        m17650a(str, 5, str2, ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, str3, str4, str5);
    }
}
