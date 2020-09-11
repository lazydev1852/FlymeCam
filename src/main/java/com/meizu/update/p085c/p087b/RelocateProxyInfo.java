package com.meizu.update.p085c.p087b;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.meizu.cloud.pushsdk.pushtracer.constant.Parameters;
import com.meizu.update.util.Loger;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.meizu.update.c.b.b */
public class RelocateProxyInfo {

    /* renamed from: a */
    private C2982a[] f16161a;

    /* renamed from: b */
    private C2982a[] f16162b;

    /* renamed from: c */
    private final long f16163c;

    /* renamed from: d */
    private final long f16164d;

    /* renamed from: e */
    private final C2983b f16165e;

    /* renamed from: com.meizu.update.c.b.b$a */
    /* compiled from: RelocateProxyInfo */
    private static class C2982a {

        /* renamed from: a */
        public final String f16166a;

        /* renamed from: b */
        public final String f16167b;

        public C2982a(String str, String str2) {
            this.f16166a = str;
            this.f16167b = str2;
        }
    }

    /* renamed from: com.meizu.update.c.b.b$b */
    /* compiled from: RelocateProxyInfo */
    private static class C2983b {

        /* renamed from: a */
        private final int f16168a;

        /* renamed from: b */
        private final String f16169b;

        private C2983b(int i, String str) {
            this.f16168a = i;
            this.f16169b = str;
        }

        /* renamed from: a */
        public boolean mo24722a(Context context) {
            C2983b b = m17595b(context);
            if (b.f16168a != -1) {
                return equals(b);
            }
            Loger.m17942c("Check network match while no network");
            return true;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof C2983b)) {
                Loger.m17942c("Check network match while object is illegal:" + obj);
            } else {
                C2983b bVar = (C2983b) obj;
                if (bVar.f16168a == this.f16168a) {
                    if (bVar.f16169b != null) {
                        z = bVar.f16169b.equals(this.f16169b);
                    } else if (this.f16169b != null) {
                        z = false;
                    }
                    if (!z) {
                        Loger.m17942c("Network key change:" + this.f16169b + "->" + bVar.f16169b);
                    }
                    return z;
                }
                Loger.m17942c("Network type change:" + this.f16168a + "->" + bVar.f16168a);
            }
            return false;
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x003f A[Catch:{ Exception -> 0x0065 }] */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.meizu.update.p085c.p087b.RelocateProxyInfo.C2983b m17595b(android.content.Context r4) {
            /*
                r0 = 0
                java.lang.String r1 = "connectivity"
                java.lang.Object r1 = r4.getSystemService(r1)     // Catch:{ Exception -> 0x0065 }
                android.net.ConnectivityManager r1 = (android.net.ConnectivityManager) r1     // Catch:{ Exception -> 0x0065 }
                if (r1 == 0) goto L_0x006e
                android.net.NetworkInfo r1 = r1.getActiveNetworkInfo()     // Catch:{ Exception -> 0x0065 }
                if (r1 == 0) goto L_0x006e
                boolean r2 = r1.isAvailable()     // Catch:{ Exception -> 0x0065 }
                if (r2 == 0) goto L_0x006e
                int r2 = r1.getType()     // Catch:{ Exception -> 0x0065 }
                r3 = 1
                if (r2 != r3) goto L_0x0031
                java.lang.String r3 = "wifi"
                java.lang.Object r4 = r4.getSystemService(r3)     // Catch:{ Exception -> 0x0065 }
                android.net.wifi.WifiManager r4 = (android.net.wifi.WifiManager) r4     // Catch:{ Exception -> 0x0065 }
                android.net.wifi.WifiInfo r4 = r4.getConnectionInfo()     // Catch:{ Exception -> 0x0065 }
                if (r4 == 0) goto L_0x0038
                java.lang.String r4 = r4.getSSID()     // Catch:{ Exception -> 0x0065 }
                goto L_0x0039
            L_0x0031:
                if (r2 != 0) goto L_0x0038
                java.lang.String r4 = com.meizu.update.util.Utility.m17993l(r4)     // Catch:{ Exception -> 0x0065 }
                goto L_0x0039
            L_0x0038:
                r4 = r0
            L_0x0039:
                boolean r3 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0065 }
                if (r3 == 0) goto L_0x0043
                java.lang.String r4 = r1.getTypeName()     // Catch:{ Exception -> 0x0065 }
            L_0x0043:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0065 }
                r1.<init>()     // Catch:{ Exception -> 0x0065 }
                java.lang.String r3 = "Current network type:"
                r1.append(r3)     // Catch:{ Exception -> 0x0065 }
                r1.append(r2)     // Catch:{ Exception -> 0x0065 }
                java.lang.String r3 = ","
                r1.append(r3)     // Catch:{ Exception -> 0x0065 }
                r1.append(r4)     // Catch:{ Exception -> 0x0065 }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0065 }
                com.meizu.update.util.Loger.m17942c(r1)     // Catch:{ Exception -> 0x0065 }
                com.meizu.update.c.b.b$b r1 = new com.meizu.update.c.b.b$b     // Catch:{ Exception -> 0x0065 }
                r1.<init>(r2, r4)     // Catch:{ Exception -> 0x0065 }
                return r1
            L_0x0065:
                r4 = move-exception
                java.lang.String r1 = "InstanceCurrent exception!"
                com.meizu.update.util.Loger.m17942c(r1)
                r4.printStackTrace()
            L_0x006e:
                java.lang.String r4 = "InstanceCurrent no network!"
                com.meizu.update.util.Loger.m17942c(r4)
                com.meizu.update.c.b.b$b r4 = new com.meizu.update.c.b.b$b
                r1 = -1
                r4.<init>(r1, r0)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.update.p085c.p087b.RelocateProxyInfo.C2983b.m17595b(android.content.Context):com.meizu.update.c.b.b$b");
        }
    }

    protected RelocateProxyInfo(String str, Context context) throws JSONException {
        JSONArray jSONArray;
        int length;
        JSONArray jSONArray2;
        int length2;
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("targets") && (length2 = jSONArray2.length()) > 0) {
            this.f16161a = new C2982a[length2];
            for (int i = 0; i < length2; i++) {
                JSONObject jSONObject2 = (jSONArray2 = jSONObject.getJSONArray("targets")).getJSONObject(i);
                this.f16161a[i] = new C2982a(jSONObject2.getString(Parameters.IP_ADDRESS), jSONObject2.has("authKey") ? jSONObject2.getString("authKey") : null);
            }
        }
        if (jSONObject.has("baks") && (length = jSONArray.length()) > 0) {
            this.f16162b = new C2982a[length];
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject3 = (jSONArray = jSONObject.getJSONArray("baks")).getJSONObject(i2);
                this.f16162b[i2] = new C2982a(jSONObject3.getString(Parameters.IP_ADDRESS), jSONObject3.has("authKey") ? jSONObject3.getString("authKey") : null);
            }
        }
        if (jSONObject.has("expire")) {
            this.f16163c = jSONObject.getLong("expire");
        } else {
            this.f16163c = 5;
        }
        this.f16164d = SystemClock.elapsedRealtime();
        this.f16165e = C2983b.m17595b(context);
    }

    /* renamed from: a */
    public boolean mo24721a(Context context) {
        boolean z = SystemClock.elapsedRealtime() - this.f16164d > this.f16163c * 60000;
        if (!z) {
            return !this.f16165e.mo24722a(context);
        }
        Loger.m17942c("Proxy info time expire!");
        return z;
    }

    /* renamed from: a */
    public TransformUrlInfo mo24720a(String str) {
        C2982a aVar;
        try {
            String authority = Uri.parse(str).getAuthority();
            if (!TextUtils.isEmpty(authority)) {
                if (this.f16161a == null || this.f16161a.length <= 0) {
                    aVar = (this.f16162b == null || this.f16162b.length <= 0) ? null : this.f16162b[0];
                } else {
                    aVar = this.f16161a[0];
                }
                if (aVar != null) {
                    String str2 = aVar.f16166a;
                    String str3 = aVar.f16167b;
                    int indexOf = str.indexOf(authority);
                    if (indexOf != -1) {
                        String str4 = str2 + str.substring(indexOf + authority.length());
                        ArrayList arrayList = new ArrayList(2);
                        arrayList.add(new Pair("Mz_Host", authority));
                        if (!TextUtils.isEmpty(str3)) {
                            arrayList.add(new Pair("Authorization", "Basic " + Base64.encodeToString(str3.getBytes(), 2)));
                        }
                        return new TransformUrlInfo(str4, arrayList);
                    }
                    Loger.m17943d("cant re construct url:" + str);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
