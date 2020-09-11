package com.loc;

import android.text.TextUtils;
import com.meizu.savior.Constants;
import java.util.HashMap;
import java.util.Map;

@EntityClass(mo13026a = "a")
/* renamed from: com.loc.di */
public class SDKInfo {
    @EntityField(mo13028a = "a1", mo13029b = 6)

    /* renamed from: a */
    private String f3314a;
    @EntityField(mo13028a = "a2", mo13029b = 6)

    /* renamed from: b */
    private String f3315b;
    @EntityField(mo13028a = "a6", mo13029b = 2)

    /* renamed from: c */
    private int f3316c;
    @EntityField(mo13028a = "a3", mo13029b = 6)

    /* renamed from: d */
    private String f3317d;
    @EntityField(mo13028a = "a4", mo13029b = 6)

    /* renamed from: e */
    private String f3318e;
    @EntityField(mo13028a = "a5", mo13029b = 6)

    /* renamed from: f */
    private String f3319f;

    /* renamed from: g */
    private String f3320g;

    /* renamed from: h */
    private String f3321h;

    /* renamed from: i */
    private String f3322i;

    /* renamed from: j */
    private String f3323j;

    /* renamed from: k */
    private String f3324k;

    /* renamed from: l */
    private String[] f3325l;

    /* renamed from: com.loc.di$a */
    /* compiled from: SDKInfo */
    public static class C1106a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public String f3326a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public String f3327b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public String f3328c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public String f3329d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public boolean f3330e = true;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public String f3331f = "standard";
        /* access modifiers changed from: private */

        /* renamed from: g */
        public String[] f3332g = null;

        public C1106a(String str, String str2, String str3) {
            this.f3326a = str2;
            this.f3327b = str2;
            this.f3329d = str3;
            this.f3328c = str;
        }

        /* renamed from: a */
        public final C1106a mo13281a(String str) {
            this.f3327b = str;
            return this;
        }

        /* renamed from: a */
        public final C1106a mo13282a(String[] strArr) {
            if (strArr != null) {
                this.f3332g = (String[]) strArr.clone();
            }
            return this;
        }

        /* renamed from: a */
        public final SDKInfo mo13283a() throws AMapCoreException {
            if (this.f3332g != null) {
                return new SDKInfo(this, (byte) 0);
            }
            throw new AMapCoreException("sdk packages is null");
        }
    }

    private SDKInfo() {
        this.f3316c = 1;
        this.f3325l = null;
    }

    private SDKInfo(C1106a aVar) {
        this.f3316c = 1;
        this.f3325l = null;
        this.f3320g = aVar.f3326a;
        this.f3321h = aVar.f3327b;
        this.f3323j = aVar.f3328c;
        this.f3322i = aVar.f3329d;
        this.f3316c = aVar.f3330e ? 1 : 0;
        this.f3324k = aVar.f3331f;
        this.f3325l = aVar.f3332g;
        this.f3315b = C1107dj.m3820b(this.f3321h);
        this.f3314a = C1107dj.m3820b(this.f3323j);
        this.f3317d = C1107dj.m3820b(this.f3322i);
        this.f3318e = C1107dj.m3820b(m3784a(this.f3325l));
        this.f3319f = C1107dj.m3820b(this.f3324k);
    }

    /* synthetic */ SDKInfo(C1106a aVar, byte b) {
        this(aVar);
    }

    /* renamed from: a */
    public static String m3783a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("a1", C1107dj.m3820b(str));
        return DBOperation.m3897a((Map<String, String>) hashMap);
    }

    /* renamed from: a */
    private static String m3784a(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            for (String append : strArr) {
                sb.append(append);
                sb.append(Constants.PACKNAME_END);
            }
            return sb.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    private static String[] m3785b(String str) {
        try {
            return str.split(Constants.PACKNAME_END);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: g */
    public static String m3786g() {
        return "a6=1";
    }

    /* renamed from: a */
    public final String mo13272a() {
        if (TextUtils.isEmpty(this.f3323j) && !TextUtils.isEmpty(this.f3314a)) {
            this.f3323j = C1107dj.m3824c(this.f3314a);
        }
        return this.f3323j;
    }

    /* renamed from: a */
    public final void mo13273a(boolean z) {
        this.f3316c = z ? 1 : 0;
    }

    /* renamed from: b */
    public final String mo13274b() {
        return this.f3320g;
    }

    /* renamed from: c */
    public final String mo13275c() {
        if (TextUtils.isEmpty(this.f3321h) && !TextUtils.isEmpty(this.f3315b)) {
            this.f3321h = C1107dj.m3824c(this.f3315b);
        }
        return this.f3321h;
    }

    /* renamed from: d */
    public final String mo13276d() {
        if (TextUtils.isEmpty(this.f3324k) && !TextUtils.isEmpty(this.f3319f)) {
            this.f3324k = C1107dj.m3824c(this.f3319f);
        }
        if (TextUtils.isEmpty(this.f3324k)) {
            this.f3324k = "standard";
        }
        return this.f3324k;
    }

    /* renamed from: e */
    public final boolean mo13277e() {
        return this.f3316c == 1;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return getClass() == obj.getClass() && hashCode() == ((SDKInfo) obj).hashCode();
    }

    /* renamed from: f */
    public final String[] mo13279f() {
        if ((this.f3325l == null || this.f3325l.length == 0) && !TextUtils.isEmpty(this.f3318e)) {
            this.f3325l = m3785b(C1107dj.m3824c(this.f3318e));
        }
        return (String[]) this.f3325l.clone();
    }

    public int hashCode() {
        HashCodeBuilder eVar = new HashCodeBuilder();
        eVar.mo13285a((Object) this.f3323j).mo13285a((Object) this.f3320g).mo13285a((Object) this.f3321h).mo13286a((Object[]) this.f3325l);
        return eVar.mo13284a();
    }
}
