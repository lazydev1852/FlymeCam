package com.loc;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;

/* renamed from: com.loc.de */
public final class HttpsDecisionUtil {

    /* renamed from: a */
    private volatile C1104b f3296a = new C1104b((byte) 0);

    /* renamed from: b */
    private SPUtil f3297b = new SPUtil("HttpsDecisionUtil");

    /* renamed from: com.loc.de$a */
    /* compiled from: HttpsDecisionUtil */
    private static class C1103a {

        /* renamed from: a */
        static HttpsDecisionUtil f3298a = new HttpsDecisionUtil();
    }

    /* renamed from: com.loc.de$b */
    /* compiled from: HttpsDecisionUtil */
    private static class C1104b {

        /* renamed from: a */
        protected boolean f3299a;

        /* renamed from: b */
        private int f3300b;

        /* renamed from: c */
        private final boolean f3301c;

        /* renamed from: d */
        private boolean f3302d;

        private C1104b() {
            this.f3300b = 0;
            this.f3299a = true;
            this.f3301c = true;
            this.f3302d = false;
        }

        /* synthetic */ C1104b(byte b) {
            this();
        }

        /* renamed from: a */
        public final void mo13266a(Context context) {
            if (context != null && this.f3300b <= 0 && Build.VERSION.SDK_INT >= 4) {
                this.f3300b = context.getApplicationContext().getApplicationInfo().targetSdkVersion;
            }
        }

        /* renamed from: a */
        public final void mo13267a(boolean z) {
            this.f3299a = z;
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x0031 A[RETURN] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean mo13268a() {
            /*
                r5 = this;
                boolean r0 = r5.f3302d
                r1 = 1
                if (r0 != 0) goto L_0x0032
                int r0 = android.os.Build.VERSION.SDK_INT
                r2 = 28
                r3 = 0
                if (r0 < r2) goto L_0x000e
                r0 = 1
                goto L_0x000f
            L_0x000e:
                r0 = 0
            L_0x000f:
                boolean r4 = r5.f3299a
                if (r4 == 0) goto L_0x0026
                int r4 = r5.f3300b
                if (r4 > 0) goto L_0x001a
                r4 = 28
                goto L_0x001c
            L_0x001a:
                int r4 = r5.f3300b
            L_0x001c:
                if (r4 < r2) goto L_0x0020
                r2 = 1
                goto L_0x0021
            L_0x0020:
                r2 = 0
            L_0x0021:
                if (r2 == 0) goto L_0x0024
                goto L_0x0026
            L_0x0024:
                r2 = 0
                goto L_0x0027
            L_0x0026:
                r2 = 1
            L_0x0027:
                if (r0 == 0) goto L_0x002d
                if (r2 == 0) goto L_0x002d
                r0 = 1
                goto L_0x002e
            L_0x002d:
                r0 = 0
            L_0x002e:
                if (r0 == 0) goto L_0x0031
                goto L_0x0032
            L_0x0031:
                return r3
            L_0x0032:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.loc.HttpsDecisionUtil.C1104b.mo13268a():boolean");
        }

        /* renamed from: b */
        public final void mo13269b(boolean z) {
            this.f3302d = z;
        }
    }

    /* renamed from: a */
    public static HttpsDecisionUtil m3747a() {
        return C1103a.f3298a;
    }

    /* renamed from: a */
    public static String m3748a(String str) {
        if (!TextUtils.isEmpty(str) && !str.startsWith("https")) {
            try {
                Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                buildUpon.scheme("https");
                return buildUpon.build().toString();
            } catch (Throwable unused) {
            }
        }
        return str;
    }

    /* renamed from: b */
    public static boolean m3749b() {
        return Build.VERSION.SDK_INT == 19;
    }

    /* renamed from: a */
    public final void mo13261a(Context context) {
        if (this.f3296a == null) {
            this.f3296a = new C1104b((byte) 0);
        }
        this.f3296a.mo13267a(this.f3297b.mo13298a(context, "isTargetRequired"));
        this.f3296a.mo13266a(context);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo13262a(Context context, boolean z) {
        if (this.f3296a == null) {
            this.f3296a = new C1104b((byte) 0);
        }
        this.f3297b.mo13297a(context, "isTargetRequired", z);
        this.f3296a.mo13267a(z);
    }

    /* renamed from: a */
    public final void mo13263a(boolean z) {
        if (this.f3296a == null) {
            this.f3296a = new C1104b((byte) 0);
        }
        this.f3296a.mo13269b(z);
    }

    /* renamed from: b */
    public final void mo13264b(Context context) {
        this.f3297b.mo13297a(context, "isTargetRequired", true);
    }

    /* renamed from: b */
    public final boolean mo13265b(boolean z) {
        if (m3749b()) {
            return false;
        }
        if (z) {
            return true;
        }
        if (this.f3296a == null) {
            this.f3296a = new C1104b((byte) 0);
        }
        return this.f3296a.mo13268a();
    }
}
