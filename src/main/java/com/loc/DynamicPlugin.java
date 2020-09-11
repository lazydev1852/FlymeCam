package com.loc;

import androidx.core.app.NotificationCompat;
import com.meizu.statsapp.p081v3.lib.plugin.constants.UxipConstants;
import java.util.HashMap;
import java.util.Map;

@EntityClass(mo13026a = "file")
/* renamed from: com.loc.w */
public class DynamicPlugin {
    @EntityField(mo13028a = "fname", mo13029b = 6)

    /* renamed from: a */
    private String f3421a;
    @EntityField(mo13028a = "md", mo13029b = 6)

    /* renamed from: b */
    private String f3422b;
    @EntityField(mo13028a = "sname", mo13029b = 6)

    /* renamed from: c */
    private String f3423c;
    @EntityField(mo13028a = "version", mo13029b = 6)

    /* renamed from: d */
    private String f3424d;
    @EntityField(mo13028a = "dversion", mo13029b = 6)

    /* renamed from: e */
    private String f3425e;
    @EntityField(mo13028a = "status", mo13029b = 6)

    /* renamed from: f */
    private String f3426f;

    /* renamed from: com.loc.w$a */
    /* compiled from: DynamicPlugin */
    public static class C1116a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public String f3427a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public String f3428b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public String f3429c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public String f3430d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public String f3431e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public String f3432f = "copy";

        public C1116a(String str, String str2, String str3, String str4, String str5) {
            this.f3427a = str;
            this.f3428b = str2;
            this.f3429c = str3;
            this.f3430d = str4;
            this.f3431e = str5;
        }

        /* renamed from: a */
        public final C1116a mo13327a(String str) {
            this.f3432f = str;
            return this;
        }

        /* renamed from: a */
        public final DynamicPlugin mo13328a() {
            return new DynamicPlugin(this);
        }
    }

    private DynamicPlugin() {
    }

    public DynamicPlugin(C1116a aVar) {
        this.f3421a = aVar.f3427a;
        this.f3422b = aVar.f3428b;
        this.f3423c = aVar.f3429c;
        this.f3424d = aVar.f3430d;
        this.f3425e = aVar.f3431e;
        this.f3426f = aVar.f3432f;
    }

    /* renamed from: a */
    public static String m3945a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("sname", str);
        return DBOperation.m3897a((Map<String, String>) hashMap);
    }

    /* renamed from: a */
    public static String m3946a(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("sname", str);
        hashMap.put("dversion", str2);
        return DBOperation.m3897a((Map<String, String>) hashMap);
    }

    /* renamed from: a */
    public static String m3947a(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("fname", str);
        hashMap.put("sname", str2);
        hashMap.put("dversion", str4);
        hashMap.put(UxipConstants.RESPONSE_KEY_VERSION, str3);
        return DBOperation.m3897a((Map<String, String>) hashMap);
    }

    /* renamed from: b */
    public static String m3948b(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("fname", str);
        return DBOperation.m3897a((Map<String, String>) hashMap);
    }

    /* renamed from: b */
    public static String m3949b(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("sname", str);
        hashMap.put(NotificationCompat.CATEGORY_STATUS, str2);
        return DBOperation.m3897a((Map<String, String>) hashMap);
    }

    /* renamed from: a */
    public final String mo13320a() {
        return this.f3421a;
    }

    /* renamed from: b */
    public final String mo13321b() {
        return this.f3422b;
    }

    /* renamed from: c */
    public final String mo13322c() {
        return this.f3423c;
    }

    /* renamed from: c */
    public final void mo13323c(String str) {
        this.f3426f = str;
    }

    /* renamed from: d */
    public final String mo13324d() {
        return this.f3424d;
    }

    /* renamed from: e */
    public final String mo13325e() {
        return this.f3425e;
    }

    /* renamed from: f */
    public final String mo13326f() {
        return this.f3426f;
    }
}
