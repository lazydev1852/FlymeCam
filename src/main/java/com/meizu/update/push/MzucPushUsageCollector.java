package com.meizu.update.push;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.meizu.statsapp.UsageStatsProxy;
import com.meizu.update.Constants;
import com.meizu.update.p085c.p089d.IpHelper;
import com.meizu.update.util.Loger;
import com.meizu.update.util.Utility;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.meizu.update.push.a */
public class MzucPushUsageCollector {

    /* renamed from: a */
    final String f16303a = UUID.randomUUID().toString();

    /* renamed from: b */
    private UsageStatsProxy f16304b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f16305c;

    public MzucPushUsageCollector(Context context) {
        this.f16304b = UsageStatsProxy.getInstance(context, true);
        this.f16305c = context;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17806a(Map<String, String> map, String str) {
        try {
            map.put("uuid", this.f16303a);
            map.put("clientip", IpHelper.m17658a());
            if (!TextUtils.isEmpty(str)) {
                String host = Uri.parse(str).getHost();
                if (!TextUtils.isEmpty(host)) {
                    map.put("serverip", IpHelper.m17659a(host));
                }
            }
            map.put("product", this.f16305c.getPackageName());
            Loger.m17939a("Write push usage log:");
            for (String next : map.keySet()) {
                Loger.m17939a(next + "=" + map.get(next));
            }
            if (this.f16304b != null) {
                this.f16304b.onLog("update.push.system.app", map);
            } else {
                Loger.m17943d("UsageStatsProxy is null!");
            }
        } catch (Exception e) {
            Loger.m17943d("onLog Error : " + e.getMessage());
        }
    }

    /* renamed from: a */
    private void m17804a(final int i, final int i2, final String str) {
        new AsyncTask<Void, Void, Void>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public Void doInBackground(Void... voidArr) {
                HashMap hashMap = new HashMap();
                hashMap.put("result_mark", String.valueOf(i));
                hashMap.put("rescode", String.valueOf(i2));
                if (str != null) {
                    hashMap.put(NotificationCompat.CATEGORY_MESSAGE, str);
                }
                String d = Utility.m17979d(MzucPushUsageCollector.this.f16305c);
                String c = Utility.m17974c(MzucPushUsageCollector.this.f16305c);
                String b = Utility.m17969b(MzucPushUsageCollector.this.f16305c);
                String a = Utility.m17960a(MzucPushUsageCollector.this.f16305c);
                if (d != null) {
                    hashMap.put("local_model", d);
                }
                if (c != null) {
                    hashMap.put("android_version", c);
                }
                if (b != null) {
                    hashMap.put("flyme_version", b);
                }
                if (a != null) {
                    hashMap.put("app_version", a);
                }
                MzucPushUsageCollector.this.m17806a((Map<String, String>) hashMap, Constants.f16134b);
                return null;
            }
        }.execute(new Void[0]);
    }

    /* renamed from: a */
    public void mo24816a(String str) {
        m17804a(3, (int) ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, str);
    }

    /* renamed from: b */
    public void mo24817b(String str) {
        m17804a(1, (int) ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, str);
    }

    /* renamed from: c */
    public void mo24818c(String str) {
        m17804a(2, (int) ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, str);
    }

    /* renamed from: d */
    public void mo24819d(String str) {
        m17804a(4, (int) ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, str);
    }

    /* renamed from: a */
    public void mo24815a(int i, String str) {
        m17804a(5, i, str);
    }
}
