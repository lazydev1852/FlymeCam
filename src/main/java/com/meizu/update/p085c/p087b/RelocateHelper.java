package com.meizu.update.p085c.p087b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.meizu.update.util.Loger;
import com.meizu.update.util.UrlRequest;
import com.meizu.update.util.Utility;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.meizu.update.c.b.a */
public class RelocateHelper {

    /* renamed from: a */
    private static RelocateProxyInfo f16160a;

    /* renamed from: a */
    public RelocateProxyInfo mo24718a(Context context) {
        if (f16160a != null && !f16160a.mo24721a(context)) {
            return f16160a;
        }
        f16160a = new RelocateHelper().m17589b(context);
        return f16160a;
    }

    /* renamed from: a */
    public static void m17588a() {
        f16160a = null;
    }

    /* renamed from: b */
    private RelocateProxyInfo m17589b(Context context) {
        try {
            String c = m17590c(context);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair("sim_card_sp", c));
            arrayList.add(new Pair("rule_id", "15"));
            String a = mo24719a(context, "http://servicecut.meizu.com/interface/locate", arrayList);
            if (!TextUtils.isEmpty(a)) {
                Loger.m17939a("Proxy info: " + a);
                return new RelocateProxyInfo(a, context);
            }
            Loger.m17943d("Proxy response is null!");
            return null;
        } catch (Exception e) {
            Loger.m17943d("Load proxy exception!");
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    private String m17590c(Context context) {
        if (Utility.m17991j(context)) {
            return "wifi";
        }
        return Utility.m17993l(context);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo24719a(Context context, String str, List<Pair<String, String>> list) {
        return UrlRequest.m17953a(context, str, list);
    }
}
