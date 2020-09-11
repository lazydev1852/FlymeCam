package com.loc;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.meizu.statsapp.p081v3.lib.plugin.constants.UxipConstants;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.loc.cz */
public final class AuthConfigManager {

    /* renamed from: a */
    public static int f3185a = -1;

    /* renamed from: b */
    public static String f3186b = "";

    /* renamed from: com.loc.cz$a */
    /* compiled from: AuthConfigManager */
    public static class C1092a {
        @Deprecated

        /* renamed from: A */
        public C1095c f3187A;

        /* renamed from: B */
        public C1095c f3188B;

        /* renamed from: C */
        public C1094b f3189C;

        /* renamed from: D */
        public C1094b f3190D;

        /* renamed from: E */
        public C1094b f3191E;

        /* renamed from: F */
        public C1094b f3192F;

        /* renamed from: G */
        public C1097e f3193G;
        /* access modifiers changed from: private */

        /* renamed from: H */
        public boolean f3194H;

        /* renamed from: a */
        public String f3195a;

        /* renamed from: b */
        public int f3196b = -1;
        @Deprecated

        /* renamed from: c */
        public JSONObject f3197c;
        @Deprecated

        /* renamed from: d */
        public JSONObject f3198d;
        @Deprecated

        /* renamed from: e */
        public JSONObject f3199e;
        @Deprecated

        /* renamed from: f */
        public JSONObject f3200f;
        @Deprecated

        /* renamed from: g */
        public JSONObject f3201g;
        @Deprecated

        /* renamed from: h */
        public JSONObject f3202h;
        @Deprecated

        /* renamed from: i */
        public JSONObject f3203i;
        @Deprecated

        /* renamed from: j */
        public JSONObject f3204j;
        @Deprecated

        /* renamed from: k */
        public JSONObject f3205k;
        @Deprecated

        /* renamed from: l */
        public JSONObject f3206l;
        @Deprecated

        /* renamed from: m */
        public JSONObject f3207m;
        @Deprecated

        /* renamed from: n */
        public JSONObject f3208n;
        @Deprecated

        /* renamed from: o */
        public JSONObject f3209o;
        @Deprecated

        /* renamed from: p */
        public JSONObject f3210p;
        @Deprecated

        /* renamed from: q */
        public JSONObject f3211q;
        @Deprecated

        /* renamed from: r */
        public JSONObject f3212r;
        @Deprecated

        /* renamed from: s */
        public JSONObject f3213s;
        @Deprecated

        /* renamed from: t */
        public JSONObject f3214t;
        @Deprecated

        /* renamed from: u */
        public JSONObject f3215u;
        @Deprecated

        /* renamed from: v */
        public JSONObject f3216v;

        /* renamed from: w */
        public JSONObject f3217w;

        /* renamed from: x */
        public C1093a f3218x;

        /* renamed from: y */
        public C1096d f3219y;

        /* renamed from: z */
        public C1098f f3220z;

        /* renamed from: com.loc.cz$a$a */
        /* compiled from: AuthConfigManager */
        public static class C1093a {

            /* renamed from: a */
            public boolean f3221a;

            /* renamed from: b */
            public boolean f3222b;

            /* renamed from: c */
            public JSONObject f3223c;
        }

        /* renamed from: com.loc.cz$a$b */
        /* compiled from: AuthConfigManager */
        public static class C1094b {

            /* renamed from: a */
            public boolean f3224a;

            /* renamed from: b */
            public String f3225b;

            /* renamed from: c */
            public String f3226c;

            /* renamed from: d */
            public String f3227d;

            /* renamed from: e */
            public boolean f3228e;
        }

        /* renamed from: com.loc.cz$a$c */
        /* compiled from: AuthConfigManager */
        public static class C1095c {

            /* renamed from: a */
            public String f3229a;

            /* renamed from: b */
            public String f3230b;
        }

        /* renamed from: com.loc.cz$a$d */
        /* compiled from: AuthConfigManager */
        public static class C1096d {

            /* renamed from: a */
            public String f3231a;

            /* renamed from: b */
            public String f3232b;

            /* renamed from: c */
            public String f3233c;
        }

        /* renamed from: com.loc.cz$a$e */
        /* compiled from: AuthConfigManager */
        public static class C1097e {

            /* renamed from: a */
            public boolean f3234a;

            /* renamed from: b */
            public boolean f3235b;

            /* renamed from: c */
            public boolean f3236c;

            /* renamed from: d */
            public String f3237d;

            /* renamed from: e */
            public String f3238e;

            /* renamed from: f */
            public String f3239f;
        }

        /* renamed from: com.loc.cz$a$f */
        /* compiled from: AuthConfigManager */
        public static class C1098f {

            /* renamed from: a */
            public boolean f3240a;
        }

        /* renamed from: a */
        public final boolean mo13255a() {
            return this.f3194H;
        }
    }

    /* renamed from: com.loc.cz$b */
    /* compiled from: AuthConfigManager */
    static class C1099b extends BinaryRequest {

        /* renamed from: f */
        private String f3241f;

        /* renamed from: g */
        private Map<String, String> f3242g = null;

        /* renamed from: h */
        private boolean f3243h;

        C1099b(Context context, SDKInfo diVar, String str) {
            super(context, diVar);
            this.f3241f = str;
            this.f3243h = Build.VERSION.SDK_INT != 19;
        }

        /* renamed from: a */
        public final Map<String, String> mo12965a() {
            return null;
        }

        /* renamed from: c */
        public final String mo12967c() {
            return this.f3243h ? "https://restapi.amap.com/v3/iasdkauth" : "http://restapi.amap.com/v3/iasdkauth";
        }

        /* access modifiers changed from: protected */
        /* renamed from: g */
        public final String mo13001g() {
            return "3.0";
        }

        /* renamed from: h */
        public final byte[] mo13002h() {
            return null;
        }

        /* renamed from: i */
        public final byte[] mo13003i() {
            String v = DeviceInfo.m3733v(this.f2565a);
            if (TextUtils.isEmpty(v)) {
                v = DeviceInfo.m3720i(this.f2565a);
            }
            if (!TextUtils.isEmpty(v)) {
                v = MD5.m3762b(new StringBuilder(v).reverse().toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("authkey", this.f3241f);
            hashMap.put("plattype", "android");
            hashMap.put("product", this.f2566b.mo13272a());
            hashMap.put(UxipConstants.RESPONSE_KEY_VERSION, this.f2566b.mo13274b());
            hashMap.put("output", "json");
            StringBuilder sb = new StringBuilder();
            sb.append(Build.VERSION.SDK_INT);
            hashMap.put("androidversion", sb.toString());
            hashMap.put("deviceId", v);
            hashMap.put("manufacture", Build.MANUFACTURER);
            if (this.f3242g != null && !this.f3242g.isEmpty()) {
                hashMap.putAll(this.f3242g);
            }
            hashMap.put("abitype", C1107dj.m3807a(this.f2565a));
            hashMap.put("ext", this.f2566b.mo13276d());
            return C1107dj.m3818a(C1107dj.m3809a((Map<String, String>) hashMap));
        }

        /* renamed from: m */
        public final boolean mo13256m() {
            return this.f3243h;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0092, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0093, code lost:
        r3 = r13;
        r13 = null;
        r5 = r4;
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009f, code lost:
        r3 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a3, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a4, code lost:
        r3 = r13;
        r13 = null;
        r5 = r4;
        r4 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0088 */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[ExcHandler: IllegalBlockSizeException (unused javax.crypto.IllegalBlockSizeException), PHI: r13 
  PHI: (r13v21 java.lang.String) = (r13v0 java.lang.String), (r13v0 java.lang.String), (r13v0 java.lang.String), (r13v25 java.lang.String) binds: [B:1:0x0013, B:2:?, B:3:0x0018, B:27:0x0088] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC, Splitter:B:1:0x0013] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b6  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.loc.AuthConfigManager.C1092a m3669a(android.content.Context r11, com.loc.SDKInfo r12, java.lang.String r13, boolean r14) {
        /*
            com.loc.cz$a r0 = new com.loc.cz$a
            r0.<init>()
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            r0.f3217w = r1
            com.loc.de r1 = com.loc.HttpsDecisionUtil.C1103a.f3298a
            r1.mo13261a((android.content.Context) r11)
            r1 = 0
            r2 = 0
            com.loc.ai r3 = new com.loc.ai     // Catch:{ cx -> 0x00a3, IllegalBlockSizeException -> 0x009f, Throwable -> 0x0092 }
            r3.<init>()     // Catch:{ cx -> 0x00a3, IllegalBlockSizeException -> 0x009f, Throwable -> 0x0092 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ cx -> 0x0090, Throwable -> 0x0088, IllegalBlockSizeException -> 0x009f }
            r3.<init>()     // Catch:{ cx -> 0x0090, Throwable -> 0x0088, IllegalBlockSizeException -> 0x009f }
            r3.append(r13)     // Catch:{ cx -> 0x0090, Throwable -> 0x0088, IllegalBlockSizeException -> 0x009f }
            java.lang.String r4 = ";14N;15K;16H"
            r3.append(r4)     // Catch:{ cx -> 0x0090, Throwable -> 0x0088, IllegalBlockSizeException -> 0x009f }
            java.lang.String r3 = r3.toString()     // Catch:{ cx -> 0x0090, Throwable -> 0x0088, IllegalBlockSizeException -> 0x009f }
            com.loc.cz$b r13 = new com.loc.cz$b     // Catch:{ cx -> 0x0083, Throwable -> 0x0081, IllegalBlockSizeException -> 0x00a0 }
            r13.<init>(r11, r12, r3)     // Catch:{ cx -> 0x0083, Throwable -> 0x0081, IllegalBlockSizeException -> 0x00a0 }
            boolean r4 = r13.mo13256m()     // Catch:{ cx -> 0x0083, Throwable -> 0x0081, IllegalBlockSizeException -> 0x00a0 }
            com.loc.an r13 = com.loc.BaseNetManager.m2999a(r13, r4)     // Catch:{ cx -> 0x0083, Throwable -> 0x0081, IllegalBlockSizeException -> 0x00a0 }
            if (r13 == 0) goto L_0x0048
            byte[] r4 = r13.f2587a     // Catch:{ cx -> 0x0043, IllegalBlockSizeException -> 0x0040, Throwable -> 0x003b }
            goto L_0x0049
        L_0x003b:
            r4 = move-exception
            r5 = r4
            r4 = r1
            goto L_0x0097
        L_0x0040:
            r4 = r1
            goto L_0x00b3
        L_0x0043:
            r4 = move-exception
            r5 = r4
            r4 = r1
            goto L_0x00a8
        L_0x0048:
            r4 = r1
        L_0x0049:
            r5 = 16
            byte[] r6 = new byte[r5]     // Catch:{ cx -> 0x007f, IllegalBlockSizeException -> 0x00b3, Throwable -> 0x007d }
            int r7 = r4.length     // Catch:{ cx -> 0x007f, IllegalBlockSizeException -> 0x00b3, Throwable -> 0x007d }
            int r7 = r7 - r5
            byte[] r7 = new byte[r7]     // Catch:{ cx -> 0x007f, IllegalBlockSizeException -> 0x00b3, Throwable -> 0x007d }
            java.lang.System.arraycopy(r4, r2, r6, r2, r5)     // Catch:{ cx -> 0x007f, IllegalBlockSizeException -> 0x00b3, Throwable -> 0x007d }
            int r8 = r4.length     // Catch:{ cx -> 0x007f, IllegalBlockSizeException -> 0x00b3, Throwable -> 0x007d }
            int r8 = r8 - r5
            java.lang.System.arraycopy(r4, r5, r7, r2, r8)     // Catch:{ cx -> 0x007f, IllegalBlockSizeException -> 0x00b3, Throwable -> 0x007d }
            javax.crypto.spec.SecretKeySpec r5 = new javax.crypto.spec.SecretKeySpec     // Catch:{ cx -> 0x007f, IllegalBlockSizeException -> 0x00b3, Throwable -> 0x007d }
            java.lang.String r8 = "AES"
            r5.<init>(r6, r8)     // Catch:{ cx -> 0x007f, IllegalBlockSizeException -> 0x00b3, Throwable -> 0x007d }
            java.lang.String r6 = "AES/CBC/PKCS5Padding"
            javax.crypto.Cipher r6 = javax.crypto.Cipher.getInstance(r6)     // Catch:{ cx -> 0x007f, IllegalBlockSizeException -> 0x00b3, Throwable -> 0x007d }
            javax.crypto.spec.IvParameterSpec r8 = new javax.crypto.spec.IvParameterSpec     // Catch:{ cx -> 0x007f, IllegalBlockSizeException -> 0x00b3, Throwable -> 0x007d }
            byte[] r9 = com.loc.C1107dj.m3825c()     // Catch:{ cx -> 0x007f, IllegalBlockSizeException -> 0x00b3, Throwable -> 0x007d }
            r8.<init>(r9)     // Catch:{ cx -> 0x007f, IllegalBlockSizeException -> 0x00b3, Throwable -> 0x007d }
            r9 = 2
            r6.init(r9, r5, r8)     // Catch:{ cx -> 0x007f, IllegalBlockSizeException -> 0x00b3, Throwable -> 0x007d }
            byte[] r5 = r6.doFinal(r7)     // Catch:{ cx -> 0x007f, IllegalBlockSizeException -> 0x00b3, Throwable -> 0x007d }
            java.lang.String r5 = com.loc.C1107dj.m3810a((byte[]) r5)     // Catch:{ cx -> 0x007f, IllegalBlockSizeException -> 0x00b3, Throwable -> 0x007d }
            r1 = r5
            goto L_0x00b3
        L_0x007d:
            r5 = move-exception
            goto L_0x0097
        L_0x007f:
            r5 = move-exception
            goto L_0x00a8
        L_0x0081:
            r13 = r3
            goto L_0x0088
        L_0x0083:
            r13 = move-exception
            r10 = r3
            r3 = r13
            r13 = r10
            goto L_0x0091
        L_0x0088:
            com.loc.cx r3 = new com.loc.cx     // Catch:{ cx -> 0x00a3, IllegalBlockSizeException -> 0x009f, Throwable -> 0x0092 }
            java.lang.String r4 = "未知的错误"
            r3.<init>(r4)     // Catch:{ cx -> 0x00a3, IllegalBlockSizeException -> 0x009f, Throwable -> 0x0092 }
            throw r3     // Catch:{ cx -> 0x00a3, IllegalBlockSizeException -> 0x009f, Throwable -> 0x0092 }
        L_0x0090:
            r3 = move-exception
        L_0x0091:
            throw r3     // Catch:{ cx -> 0x00a3, IllegalBlockSizeException -> 0x009f, Throwable -> 0x0092 }
        L_0x0092:
            r4 = move-exception
            r3 = r13
            r13 = r1
            r5 = r4
            r4 = r13
        L_0x0097:
            java.lang.String r6 = "at"
            java.lang.String r7 = "lc"
            com.loc.SDKLogHandler.m3867b((java.lang.Throwable) r5, (java.lang.String) r6, (java.lang.String) r7)
            goto L_0x00b3
        L_0x009f:
            r3 = r13
        L_0x00a0:
            r13 = r1
            r4 = r13
            goto L_0x00b3
        L_0x00a3:
            r4 = move-exception
            r3 = r13
            r13 = r1
            r5 = r4
            r4 = r13
        L_0x00a8:
            java.lang.String r6 = r5.mo13248a()
            r0.f3195a = r6
            java.lang.String r6 = "/v3/iasdkauth"
            com.loc.SDKLogHandler.m3863a((com.loc.SDKInfo) r12, (java.lang.String) r6, (com.loc.AMapCoreException) r5)
        L_0x00b3:
            if (r4 != 0) goto L_0x00b6
            return r0
        L_0x00b6:
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            if (r5 == 0) goto L_0x00c0
            java.lang.String r1 = com.loc.C1107dj.m3810a((byte[]) r4)
        L_0x00c0:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0347 }
            r4.<init>(r1)     // Catch:{ Throwable -> 0x0347 }
            java.lang.String r1 = "status"
            boolean r1 = r4.has(r1)     // Catch:{ Throwable -> 0x0347 }
            if (r1 == 0) goto L_0x034f
            java.lang.String r1 = "status"
            int r1 = r4.getInt(r1)     // Catch:{ Throwable -> 0x0347 }
            r5 = 1
            if (r1 != r5) goto L_0x00d9
            f3185a = r5     // Catch:{ Throwable -> 0x0347 }
            goto L_0x011a
        L_0x00d9:
            if (r1 != 0) goto L_0x011a
            java.lang.String r1 = "authcsid"
            java.lang.String r5 = "authgsid"
            if (r13 == 0) goto L_0x00e5
            java.lang.String r1 = r13.f2589c     // Catch:{ Throwable -> 0x0347 }
            java.lang.String r5 = r13.f2590d     // Catch:{ Throwable -> 0x0347 }
        L_0x00e5:
            com.loc.C1107dj.m3812a(r11, r1, r5, r4)     // Catch:{ Throwable -> 0x0347 }
            f3185a = r2     // Catch:{ Throwable -> 0x0347 }
            java.lang.String r13 = "info"
            boolean r13 = r4.has(r13)     // Catch:{ Throwable -> 0x0347 }
            if (r13 == 0) goto L_0x00fa
            java.lang.String r13 = "info"
            java.lang.String r13 = r4.getString(r13)     // Catch:{ Throwable -> 0x0347 }
            f3186b = r13     // Catch:{ Throwable -> 0x0347 }
        L_0x00fa:
            java.lang.String r13 = ""
            java.lang.String r1 = "infocode"
            boolean r1 = r4.has(r1)     // Catch:{ Throwable -> 0x0347 }
            if (r1 == 0) goto L_0x010a
            java.lang.String r13 = "infocode"
            java.lang.String r13 = r4.getString(r13)     // Catch:{ Throwable -> 0x0347 }
        L_0x010a:
            java.lang.String r1 = "/v3/iasdkauth"
            java.lang.String r6 = f3186b     // Catch:{ Throwable -> 0x0347 }
            com.loc.SDKLogHandler.m3864a(r12, r1, r6, r5, r13)     // Catch:{ Throwable -> 0x0347 }
            int r12 = f3185a     // Catch:{ Throwable -> 0x0347 }
            if (r12 != 0) goto L_0x011a
            java.lang.String r11 = f3186b     // Catch:{ Throwable -> 0x0347 }
            r0.f3195a = r11     // Catch:{ Throwable -> 0x0347 }
            return r0
        L_0x011a:
            java.lang.String r12 = "ver"
            boolean r12 = r4.has(r12)     // Catch:{ Throwable -> 0x012b }
            if (r12 == 0) goto L_0x0133
            java.lang.String r12 = "ver"
            int r12 = r4.getInt(r12)     // Catch:{ Throwable -> 0x012b }
            r0.f3196b = r12     // Catch:{ Throwable -> 0x012b }
            goto L_0x0133
        L_0x012b:
            r12 = move-exception
            java.lang.String r13 = "at"
            java.lang.String r1 = "lc"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r12, (java.lang.String) r13, (java.lang.String) r1)     // Catch:{ Throwable -> 0x0347 }
        L_0x0133:
            java.lang.String r12 = "result"
            boolean r12 = com.loc.C1107dj.m3817a((org.json.JSONObject) r4, (java.lang.String) r12)     // Catch:{ Throwable -> 0x0347 }
            if (r12 == 0) goto L_0x034f
            com.loc.cz$a$a r12 = new com.loc.cz$a$a     // Catch:{ Throwable -> 0x0347 }
            r12.<init>()     // Catch:{ Throwable -> 0x0347 }
            r12.f3221a = r2     // Catch:{ Throwable -> 0x0347 }
            r12.f3222b = r2     // Catch:{ Throwable -> 0x0347 }
            r0.f3218x = r12     // Catch:{ Throwable -> 0x0347 }
            java.lang.String r13 = "result"
            org.json.JSONObject r13 = r4.getJSONObject(r13)     // Catch:{ Throwable -> 0x0347 }
            java.lang.String r1 = ";"
            java.lang.String[] r1 = r3.split(r1)     // Catch:{ Throwable -> 0x016f }
            if (r1 == 0) goto L_0x0177
            int r3 = r1.length     // Catch:{ Throwable -> 0x016f }
            if (r3 <= 0) goto L_0x0177
            int r3 = r1.length     // Catch:{ Throwable -> 0x016f }
            r4 = 0
        L_0x0159:
            if (r4 >= r3) goto L_0x0177
            r5 = r1[r4]     // Catch:{ Throwable -> 0x016f }
            boolean r6 = r13.has(r5)     // Catch:{ Throwable -> 0x016f }
            if (r6 == 0) goto L_0x016c
            org.json.JSONObject r6 = r0.f3217w     // Catch:{ Throwable -> 0x016f }
            java.lang.Object r7 = r13.get(r5)     // Catch:{ Throwable -> 0x016f }
            r6.putOpt(r5, r7)     // Catch:{ Throwable -> 0x016f }
        L_0x016c:
            int r4 = r4 + 1
            goto L_0x0159
        L_0x016f:
            r1 = move-exception
            java.lang.String r3 = "at"
            java.lang.String r4 = "co"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r1, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ Throwable -> 0x0347 }
        L_0x0177:
            java.lang.String r1 = "16H"
            boolean r1 = com.loc.C1107dj.m3817a((org.json.JSONObject) r13, (java.lang.String) r1)     // Catch:{ Throwable -> 0x0347 }
            if (r1 == 0) goto L_0x0192
            java.lang.String r1 = "16H"
            org.json.JSONObject r1 = r13.getJSONObject(r1)     // Catch:{ Throwable -> 0x0347 }
            java.lang.String r3 = "able"
            java.lang.String r1 = r1.optString(r3)     // Catch:{ Throwable -> 0x0347 }
            boolean r1 = m3675a((java.lang.String) r1, (boolean) r2)     // Catch:{ Throwable -> 0x0347 }
            boolean unused = r0.f3194H = r1     // Catch:{ Throwable -> 0x0347 }
        L_0x0192:
            java.lang.String r1 = "11K"
            boolean r1 = com.loc.C1107dj.m3817a((org.json.JSONObject) r13, (java.lang.String) r1)     // Catch:{ Throwable -> 0x0347 }
            if (r1 == 0) goto L_0x01c5
            java.lang.String r1 = "11K"
            org.json.JSONObject r1 = r13.getJSONObject(r1)     // Catch:{ Throwable -> 0x01bd }
            java.lang.String r3 = "able"
            java.lang.String r3 = r1.getString(r3)     // Catch:{ Throwable -> 0x01bd }
            boolean r3 = m3675a((java.lang.String) r3, (boolean) r2)     // Catch:{ Throwable -> 0x01bd }
            r12.f3221a = r3     // Catch:{ Throwable -> 0x01bd }
            java.lang.String r3 = "off"
            boolean r3 = r1.has(r3)     // Catch:{ Throwable -> 0x01bd }
            if (r3 == 0) goto L_0x01c5
            java.lang.String r3 = "off"
            org.json.JSONObject r1 = r1.getJSONObject(r3)     // Catch:{ Throwable -> 0x01bd }
            r12.f3223c = r1     // Catch:{ Throwable -> 0x01bd }
            goto L_0x01c5
        L_0x01bd:
            r12 = move-exception
            java.lang.String r1 = "AuthConfigManager"
            java.lang.String r3 = "loadException"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r12, (java.lang.String) r1, (java.lang.String) r3)     // Catch:{ Throwable -> 0x0347 }
        L_0x01c5:
            java.lang.String r12 = "001"
            boolean r12 = com.loc.C1107dj.m3817a((org.json.JSONObject) r13, (java.lang.String) r12)     // Catch:{ Throwable -> 0x0347 }
            if (r12 == 0) goto L_0x0210
            java.lang.String r12 = "001"
            org.json.JSONObject r12 = r13.getJSONObject(r12)     // Catch:{ Throwable -> 0x0347 }
            com.loc.cz$a$d r1 = new com.loc.cz$a$d     // Catch:{ Throwable -> 0x0347 }
            r1.<init>()     // Catch:{ Throwable -> 0x0347 }
            if (r12 == 0) goto L_0x020e
            java.lang.String r3 = "md5"
            java.lang.String r3 = m3670a((org.json.JSONObject) r12, (java.lang.String) r3)     // Catch:{ Throwable -> 0x0206 }
            java.lang.String r4 = "url"
            java.lang.String r4 = m3670a((org.json.JSONObject) r12, (java.lang.String) r4)     // Catch:{ Throwable -> 0x0206 }
            java.lang.String r5 = "sdkversion"
            java.lang.String r12 = m3670a((org.json.JSONObject) r12, (java.lang.String) r5)     // Catch:{ Throwable -> 0x0206 }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Throwable -> 0x0206 }
            if (r5 != 0) goto L_0x020e
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Throwable -> 0x0206 }
            if (r5 != 0) goto L_0x020e
            boolean r5 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Throwable -> 0x0206 }
            if (r5 == 0) goto L_0x01ff
            goto L_0x020e
        L_0x01ff:
            r1.f3231a = r4     // Catch:{ Throwable -> 0x0206 }
            r1.f3232b = r3     // Catch:{ Throwable -> 0x0206 }
            r1.f3233c = r12     // Catch:{ Throwable -> 0x0206 }
            goto L_0x020e
        L_0x0206:
            r12 = move-exception
            java.lang.String r3 = "at"
            java.lang.String r4 = "psu"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r12, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ Throwable -> 0x0347 }
        L_0x020e:
            r0.f3219y = r1     // Catch:{ Throwable -> 0x0347 }
        L_0x0210:
            java.lang.String r12 = "002"
            boolean r12 = com.loc.C1107dj.m3817a((org.json.JSONObject) r13, (java.lang.String) r12)     // Catch:{ Throwable -> 0x0347 }
            if (r12 == 0) goto L_0x0228
            java.lang.String r12 = "002"
            org.json.JSONObject r12 = r13.getJSONObject(r12)     // Catch:{ Throwable -> 0x0347 }
            com.loc.cz$a$c r1 = new com.loc.cz$a$c     // Catch:{ Throwable -> 0x0347 }
            r1.<init>()     // Catch:{ Throwable -> 0x0347 }
            m3674a((org.json.JSONObject) r12, (com.loc.AuthConfigManager.C1092a.C1095c) r1)     // Catch:{ Throwable -> 0x0347 }
            r0.f3187A = r1     // Catch:{ Throwable -> 0x0347 }
        L_0x0228:
            java.lang.String r12 = "14S"
            boolean r12 = com.loc.C1107dj.m3817a((org.json.JSONObject) r13, (java.lang.String) r12)     // Catch:{ Throwable -> 0x0347 }
            if (r12 == 0) goto L_0x0240
            java.lang.String r12 = "14S"
            org.json.JSONObject r12 = r13.getJSONObject(r12)     // Catch:{ Throwable -> 0x0347 }
            com.loc.cz$a$c r1 = new com.loc.cz$a$c     // Catch:{ Throwable -> 0x0347 }
            r1.<init>()     // Catch:{ Throwable -> 0x0347 }
            m3674a((org.json.JSONObject) r12, (com.loc.AuthConfigManager.C1092a.C1095c) r1)     // Catch:{ Throwable -> 0x0347 }
            r0.f3188B = r1     // Catch:{ Throwable -> 0x0347 }
        L_0x0240:
            m3672a((com.loc.AuthConfigManager.C1092a) r0, (org.json.JSONObject) r13)     // Catch:{ Throwable -> 0x0347 }
            java.lang.String r12 = "14Z"
            boolean r12 = com.loc.C1107dj.m3817a((org.json.JSONObject) r13, (java.lang.String) r12)     // Catch:{ Throwable -> 0x0347 }
            if (r12 == 0) goto L_0x029d
            java.lang.String r12 = "14Z"
            org.json.JSONObject r12 = r13.getJSONObject(r12)     // Catch:{ Throwable -> 0x0347 }
            com.loc.cz$a$e r1 = new com.loc.cz$a$e     // Catch:{ Throwable -> 0x0347 }
            r1.<init>()     // Catch:{ Throwable -> 0x0347 }
            java.lang.String r3 = "md5"
            java.lang.String r3 = m3670a((org.json.JSONObject) r12, (java.lang.String) r3)     // Catch:{ Throwable -> 0x0293 }
            java.lang.String r4 = "md5info"
            java.lang.String r4 = m3670a((org.json.JSONObject) r12, (java.lang.String) r4)     // Catch:{ Throwable -> 0x0293 }
            java.lang.String r5 = "url"
            java.lang.String r5 = m3670a((org.json.JSONObject) r12, (java.lang.String) r5)     // Catch:{ Throwable -> 0x0293 }
            java.lang.String r6 = "able"
            java.lang.String r6 = m3670a((org.json.JSONObject) r12, (java.lang.String) r6)     // Catch:{ Throwable -> 0x0293 }
            java.lang.String r7 = "on"
            java.lang.String r7 = m3670a((org.json.JSONObject) r12, (java.lang.String) r7)     // Catch:{ Throwable -> 0x0293 }
            java.lang.String r8 = "mobileable"
            java.lang.String r12 = m3670a((org.json.JSONObject) r12, (java.lang.String) r8)     // Catch:{ Throwable -> 0x0293 }
            r1.f3238e = r3     // Catch:{ Throwable -> 0x0293 }
            r1.f3239f = r4     // Catch:{ Throwable -> 0x0293 }
            r1.f3237d = r5     // Catch:{ Throwable -> 0x0293 }
            boolean r3 = m3675a((java.lang.String) r6, (boolean) r2)     // Catch:{ Throwable -> 0x0293 }
            r1.f3234a = r3     // Catch:{ Throwable -> 0x0293 }
            boolean r3 = m3675a((java.lang.String) r7, (boolean) r2)     // Catch:{ Throwable -> 0x0293 }
            r1.f3235b = r3     // Catch:{ Throwable -> 0x0293 }
            boolean r12 = m3675a((java.lang.String) r12, (boolean) r2)     // Catch:{ Throwable -> 0x0293 }
            r1.f3236c = r12     // Catch:{ Throwable -> 0x0293 }
            goto L_0x029b
        L_0x0293:
            r12 = move-exception
            java.lang.String r3 = "at"
            java.lang.String r4 = "pes"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r12, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ Throwable -> 0x0347 }
        L_0x029b:
            r0.f3193G = r1     // Catch:{ Throwable -> 0x0347 }
        L_0x029d:
            java.lang.String r12 = "151"
            boolean r12 = com.loc.C1107dj.m3817a((org.json.JSONObject) r13, (java.lang.String) r12)     // Catch:{ Throwable -> 0x0347 }
            if (r12 == 0) goto L_0x02c0
            java.lang.String r12 = "151"
            org.json.JSONObject r12 = r13.getJSONObject(r12)     // Catch:{ Throwable -> 0x0347 }
            com.loc.cz$a$f r1 = new com.loc.cz$a$f     // Catch:{ Throwable -> 0x0347 }
            r1.<init>()     // Catch:{ Throwable -> 0x0347 }
            if (r12 == 0) goto L_0x02be
            java.lang.String r3 = "able"
            java.lang.String r12 = r12.optString(r3)     // Catch:{ Throwable -> 0x0347 }
            boolean r12 = m3675a((java.lang.String) r12, (boolean) r2)     // Catch:{ Throwable -> 0x0347 }
            r1.f3240a = r12     // Catch:{ Throwable -> 0x0347 }
        L_0x02be:
            r0.f3220z = r1     // Catch:{ Throwable -> 0x0347 }
        L_0x02c0:
            m3672a((com.loc.AuthConfigManager.C1092a) r0, (org.json.JSONObject) r13)     // Catch:{ Throwable -> 0x0347 }
            java.lang.String r12 = "14N"
            boolean r12 = com.loc.C1107dj.m3817a((org.json.JSONObject) r13, (java.lang.String) r12)     // Catch:{ Throwable -> 0x0347 }
            if (r12 == 0) goto L_0x031a
            java.lang.String r12 = "14N"
            org.json.JSONObject r12 = r13.getJSONObject(r12)     // Catch:{ Throwable -> 0x0347 }
            com.loc.cz$a$b r1 = new com.loc.cz$a$b     // Catch:{ Throwable -> 0x0347 }
            r1.<init>()     // Catch:{ Throwable -> 0x0347 }
            java.lang.String r3 = "able"
            java.lang.String r3 = r12.optString(r3)     // Catch:{ Throwable -> 0x0347 }
            boolean r3 = m3675a((java.lang.String) r3, (boolean) r2)     // Catch:{ Throwable -> 0x0347 }
            r1.f3224a = r3     // Catch:{ Throwable -> 0x0347 }
            java.lang.String r3 = "url"
            java.lang.String r3 = r12.optString(r3)     // Catch:{ Throwable -> 0x0347 }
            r1.f3225b = r3     // Catch:{ Throwable -> 0x0347 }
            java.lang.String r3 = "md5"
            java.lang.String r12 = r12.optString(r3)     // Catch:{ Throwable -> 0x0347 }
            r1.f3226c = r12     // Catch:{ Throwable -> 0x0347 }
            boolean r12 = r1.f3224a     // Catch:{ Throwable -> 0x0347 }
            if (r12 == 0) goto L_0x0315
            com.loc.di r12 = com.loc.ConstConfig.m3835a()     // Catch:{ Throwable -> 0x0347 }
            if (r12 == 0) goto L_0x031a
            com.loc.s r3 = new com.loc.s     // Catch:{ Throwable -> 0x0347 }
            java.lang.String r4 = r1.f3225b     // Catch:{ Throwable -> 0x0347 }
            java.lang.String r1 = r1.f3226c     // Catch:{ Throwable -> 0x0347 }
            boolean r5 = r0.f3194H     // Catch:{ Throwable -> 0x0347 }
            r3.<init>(r4, r1, r5)     // Catch:{ Throwable -> 0x0347 }
            r3.mo13313a(r14)     // Catch:{ Throwable -> 0x0347 }
            com.loc.r r14 = new com.loc.r     // Catch:{ Throwable -> 0x0347 }
            r14.<init>(r11, r3, r12)     // Catch:{ Throwable -> 0x0347 }
            r14.mo13309a()     // Catch:{ Throwable -> 0x0347 }
            goto L_0x031a
        L_0x0315:
            java.lang.String r12 = "aiu"
            com.loc.InstanceFactory.m3970a((android.content.Context) r11, (java.lang.String) r12)     // Catch:{ Throwable -> 0x0347 }
        L_0x031a:
            java.lang.String r12 = "15K"
            org.json.JSONObject r12 = r13.getJSONObject(r12)     // Catch:{ Throwable -> 0x0342 }
            java.lang.String r13 = "isTargetAble"
            java.lang.String r13 = r12.optString(r13)     // Catch:{ Throwable -> 0x0342 }
            boolean r13 = m3675a((java.lang.String) r13, (boolean) r2)     // Catch:{ Throwable -> 0x0342 }
            java.lang.String r14 = "able"
            java.lang.String r12 = r12.optString(r14)     // Catch:{ Throwable -> 0x0342 }
            boolean r12 = m3675a((java.lang.String) r12, (boolean) r2)     // Catch:{ Throwable -> 0x0342 }
            if (r12 != 0) goto L_0x033c
            com.loc.de r12 = com.loc.HttpsDecisionUtil.C1103a.f3298a     // Catch:{ Throwable -> 0x0342 }
            r12.mo13264b((android.content.Context) r11)     // Catch:{ Throwable -> 0x0342 }
            goto L_0x034f
        L_0x033c:
            com.loc.de r12 = com.loc.HttpsDecisionUtil.C1103a.f3298a     // Catch:{ Throwable -> 0x0342 }
            r12.mo13262a(r11, r13)     // Catch:{ Throwable -> 0x0342 }
            goto L_0x034f
        L_0x0342:
            r11 = move-exception
            r11.printStackTrace()     // Catch:{ Throwable -> 0x0347 }
            goto L_0x034f
        L_0x0347:
            r11 = move-exception
            java.lang.String r12 = "at"
            java.lang.String r13 = "lc"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r11, (java.lang.String) r12, (java.lang.String) r13)
        L_0x034f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.AuthConfigManager.m3669a(android.content.Context, com.loc.di, java.lang.String, boolean):com.loc.cz$a");
    }

    /* renamed from: a */
    private static String m3670a(JSONObject jSONObject, String str) throws JSONException {
        return (jSONObject != null && jSONObject.has(str) && !jSONObject.getString(str).equals("[]")) ? jSONObject.optString(str) : "";
    }

    /* renamed from: a */
    public static void m3671a(Context context, String str) {
        AppInfo.m3658a(context, str);
    }

    /* renamed from: a */
    private static void m3672a(C1092a aVar, JSONObject jSONObject) {
        try {
            if (C1107dj.m3817a(jSONObject, "11B")) {
                aVar.f3202h = jSONObject.getJSONObject("11B");
            }
            if (C1107dj.m3817a(jSONObject, "11C")) {
                aVar.f3205k = jSONObject.getJSONObject("11C");
            }
            if (C1107dj.m3817a(jSONObject, "11I")) {
                aVar.f3206l = jSONObject.getJSONObject("11I");
            }
            if (C1107dj.m3817a(jSONObject, "11H")) {
                aVar.f3207m = jSONObject.getJSONObject("11H");
            }
            if (C1107dj.m3817a(jSONObject, "11E")) {
                aVar.f3208n = jSONObject.getJSONObject("11E");
            }
            if (C1107dj.m3817a(jSONObject, "11F")) {
                aVar.f3209o = jSONObject.getJSONObject("11F");
            }
            if (C1107dj.m3817a(jSONObject, "13A")) {
                aVar.f3211q = jSONObject.getJSONObject("13A");
            }
            if (C1107dj.m3817a(jSONObject, "13J")) {
                aVar.f3203i = jSONObject.getJSONObject("13J");
            }
            if (C1107dj.m3817a(jSONObject, "11G")) {
                aVar.f3210p = jSONObject.getJSONObject("11G");
            }
            if (C1107dj.m3817a(jSONObject, "006")) {
                aVar.f3212r = jSONObject.getJSONObject("006");
            }
            if (C1107dj.m3817a(jSONObject, "010")) {
                aVar.f3213s = jSONObject.getJSONObject("010");
            }
            if (C1107dj.m3817a(jSONObject, "11Z")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("11Z");
                C1092a.C1094b bVar = new C1092a.C1094b();
                m3673a(jSONObject2, bVar);
                aVar.f3189C = bVar;
            }
            if (C1107dj.m3817a(jSONObject, "135")) {
                aVar.f3204j = jSONObject.getJSONObject("135");
            }
            if (C1107dj.m3817a(jSONObject, "13S")) {
                aVar.f3201g = jSONObject.getJSONObject("13S");
            }
            if (C1107dj.m3817a(jSONObject, "121")) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("121");
                C1092a.C1094b bVar2 = new C1092a.C1094b();
                m3673a(jSONObject3, bVar2);
                aVar.f3190D = bVar2;
            }
            if (C1107dj.m3817a(jSONObject, "122")) {
                JSONObject jSONObject4 = jSONObject.getJSONObject("122");
                C1092a.C1094b bVar3 = new C1092a.C1094b();
                m3673a(jSONObject4, bVar3);
                aVar.f3191E = bVar3;
            }
            if (C1107dj.m3817a(jSONObject, "123")) {
                JSONObject jSONObject5 = jSONObject.getJSONObject("123");
                C1092a.C1094b bVar4 = new C1092a.C1094b();
                m3673a(jSONObject5, bVar4);
                aVar.f3192F = bVar4;
            }
            if (C1107dj.m3817a(jSONObject, "011")) {
                aVar.f3197c = jSONObject.getJSONObject("011");
            }
            if (C1107dj.m3817a(jSONObject, "012")) {
                aVar.f3198d = jSONObject.getJSONObject("012");
            }
            if (C1107dj.m3817a(jSONObject, "013")) {
                aVar.f3199e = jSONObject.getJSONObject("013");
            }
            if (C1107dj.m3817a(jSONObject, "014")) {
                aVar.f3200f = jSONObject.getJSONObject("014");
            }
            if (C1107dj.m3817a(jSONObject, "145")) {
                aVar.f3214t = jSONObject.getJSONObject("145");
            }
            if (C1107dj.m3817a(jSONObject, "14B")) {
                aVar.f3215u = jSONObject.getJSONObject("14B");
            }
            if (C1107dj.m3817a(jSONObject, "14D")) {
                aVar.f3216v = jSONObject.getJSONObject("14D");
            }
        } catch (Throwable th) {
            SDKLogHandler.m3867b(th, "at", "pe");
        }
    }

    /* renamed from: a */
    private static void m3673a(JSONObject jSONObject, C1092a.C1094b bVar) {
        if (bVar != null) {
            try {
                String a = m3670a(jSONObject, "m");
                String a2 = m3670a(jSONObject, "u");
                String a3 = m3670a(jSONObject, NotifyType.VIBRATE);
                String a4 = m3670a(jSONObject, "able");
                String a5 = m3670a(jSONObject, "on");
                bVar.f3226c = a;
                bVar.f3225b = a2;
                bVar.f3227d = a3;
                bVar.f3224a = m3675a(a4, false);
                bVar.f3228e = m3675a(a5, true);
            } catch (Throwable th) {
                BasicLogHandler.m3844a(th, "at", "pe");
            }
        }
    }

    /* renamed from: a */
    private static void m3674a(JSONObject jSONObject, C1092a.C1095c cVar) {
        if (jSONObject != null) {
            try {
                String a = m3670a(jSONObject, "md5");
                String a2 = m3670a(jSONObject, "url");
                cVar.f3230b = a;
                cVar.f3229a = a2;
            } catch (Throwable th) {
                BasicLogHandler.m3844a(th, "at", "psc");
            }
        }
    }

    /* renamed from: a */
    public static boolean m3675a(String str, boolean z) {
        try {
            if (TextUtils.isEmpty(str)) {
                return z;
            }
            String[] split = URLDecoder.decode(str).split("/");
            return split[split.length - 1].charAt(4) % 2 == 1;
        } catch (Throwable unused) {
            return z;
        }
    }
}
