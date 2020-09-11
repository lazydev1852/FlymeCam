package com.meizu.share.utils;

import android.content.Context;
import com.meizu.sharewidget.p080a.C2876e;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.meizu.share.utils.e */
public class ShareWidgetUsageCollector {
    /* renamed from: a */
    public static void m17204a(final Context context, final String str) {
        if (context != null) {
            Executor.m17171a().mo24011b(new Runnable() {
                public void run() {
                    HashMap hashMap = new HashMap();
                    hashMap.put("sdk_share_view_open_form_package", str);
                    C2876e.m17269a(context, "sdk_share_view_open_show", (String) null, hashMap, "com.meizu.flyme.sdk");
                }
            });
        }
    }

    /* renamed from: a */
    public static void m17203a(final Context context) {
        if (context != null) {
            Executor.m17171a().mo24011b(new Runnable() {
                public void run() {
                    C2876e.m17269a(context, "sdk_share_view_whether_tick", (String) null, (Map<String, String>) null, "com.meizu.flyme.sdk");
                }
            });
        }
    }

    /* renamed from: b */
    public static void m17205b(final Context context, final String str) {
        if (context != null) {
            Executor.m17171a().mo24011b(new Runnable() {
                public void run() {
                    HashMap hashMap = new HashMap();
                    hashMap.put("sdk_share_view_app_selected_shareto_with_package", str);
                    C2876e.m17269a(context, "sdk_share_view_app_shareto", (String) null, hashMap, "com.meizu.flyme.sdk");
                }
            });
        }
    }
}
