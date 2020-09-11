package com.loc;

import android.os.Build;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.meizu.statsapp.p081v3.lib.plugin.constants.Parameters;
import org.json.JSONObject;

/* renamed from: com.loc.cu */
public final class H5LocationClient {

    /* renamed from: a */
    Object f3151a;

    /* renamed from: b */
    AMapLocationClientOption f3152b;

    /* renamed from: c */
    C1088a f3153c;

    /* renamed from: d */
    private AMapLocationClient f3154d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public WebView f3155e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f3156f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public volatile boolean f3157g;

    /* renamed from: com.loc.cu$a */
    /* compiled from: H5LocationClient */
    class C1088a implements AMapLocationListener {

        /* renamed from: a */
        final /* synthetic */ H5LocationClient f3161a;

        /* renamed from: a */
        public final void mo8598a(AMapLocation aMapLocation) {
            if (this.f3161a.f3157g) {
                H5LocationClient cuVar = this.f3161a;
                H5LocationClient cuVar2 = this.f3161a;
                H5LocationClient.m3634a(cuVar, H5LocationClient.m3636b(aMapLocation));
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m3634a(H5LocationClient cuVar, final String str) {
        try {
            if (cuVar.f3155e == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 19) {
                WebView webView = cuVar.f3155e;
                webView.evaluateJavascript("javascript:" + cuVar.f3156f + "('" + str + "')", new ValueCallback<String>() {
                    public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
                    }
                });
                return;
            }
            cuVar.f3155e.post(new Runnable() {
                public final void run() {
                    WebView b = H5LocationClient.this.f3155e;
                    b.loadUrl("javascript:" + H5LocationClient.this.f3156f + "('" + str + "')");
                }
            });
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "H5LocationClient", "callbackJs()");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m3636b(AMapLocation aMapLocation) {
        String str;
        Object obj;
        JSONObject jSONObject = new JSONObject();
        if (aMapLocation == null) {
            try {
                jSONObject.put("errorCode", -1);
                str = "errorInfo";
                obj = "unknownError";
            } catch (Throwable unused) {
            }
        } else if (aMapLocation.mo8484c() == 0) {
            jSONObject.put("errorCode", 0);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("x", aMapLocation.getLongitude());
            jSONObject2.put("y", aMapLocation.getLatitude());
            jSONObject2.put("precision", (double) aMapLocation.getAccuracy());
            jSONObject2.put("type", aMapLocation.mo8475a());
            jSONObject2.put(Parameters.COUNTRY, aMapLocation.mo8493e());
            jSONObject2.put("province", aMapLocation.mo8509h());
            jSONObject2.put("city", aMapLocation.mo8512i());
            jSONObject2.put("cityCode", aMapLocation.mo8516k());
            jSONObject2.put("district", aMapLocation.mo8514j());
            jSONObject2.put("adCode", aMapLocation.mo8518l());
            jSONObject2.put("street", aMapLocation.mo8522n());
            jSONObject2.put("streetNum", aMapLocation.mo8524o());
            jSONObject2.put("floor", aMapLocation.mo8532s());
            jSONObject2.put("address", aMapLocation.mo8499g());
            str = "result";
            obj = jSONObject2;
        } else {
            jSONObject.put("errorCode", aMapLocation.mo8484c());
            jSONObject.put("errorInfo", aMapLocation.mo8489d());
            jSONObject.put("locationDetail", aMapLocation.mo8480b());
            return jSONObject.toString();
        }
        jSONObject.put(str, obj);
        return jSONObject.toString();
    }

    /* renamed from: a */
    public final void mo13234a() {
        synchronized (this.f3151a) {
            this.f3157g = false;
            if (this.f3154d != null) {
                this.f3154d.mo8596b(this.f3153c);
                this.f3154d.mo8595b();
                this.f3154d.mo8597c();
                this.f3154d = null;
            }
            this.f3152b = null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(13:7|(1:9)|10|(16:11|12|13|14|15|(1:17)(1:18)|19|20|21|(1:23)|24|25|26|27|(1:30)|29)|37|38|(1:40)(1:42)|41|43|(1:45)|46|47|(1:49)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0054 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x0079 */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x005b A[Catch:{ Throwable -> 0x0079 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0063 A[Catch:{ Throwable -> 0x0079 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0071 A[Catch:{ Throwable -> 0x0079 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x007d  */
    @android.webkit.JavascriptInterface
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void getLocation(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f3151a
            monitor-enter(r0)
            boolean r1 = r8.f3157g     // Catch:{ all -> 0x0090 }
            if (r1 != 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0090 }
            return
        L_0x0009:
            com.amap.api.location.AMapLocationClientOption r1 = r8.f3152b     // Catch:{ all -> 0x0090 }
            if (r1 != 0) goto L_0x0014
            com.amap.api.location.AMapLocationClientOption r1 = new com.amap.api.location.AMapLocationClientOption     // Catch:{ all -> 0x0090 }
            r1.<init>()     // Catch:{ all -> 0x0090 }
            r8.f3152b = r1     // Catch:{ all -> 0x0090 }
        L_0x0014:
            r1 = 5
            r2 = 30000(0x7530, double:1.4822E-319)
            r4 = 0
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0051 }
            r5.<init>(r9)     // Catch:{ Throwable -> 0x0051 }
            java.lang.String r9 = "to"
            long r6 = r5.optLong(r9, r2)     // Catch:{ Throwable -> 0x0051 }
            java.lang.String r9 = "useGPS"
            r2 = 1
            int r9 = r5.optInt(r9, r2)     // Catch:{ Throwable -> 0x0052 }
            if (r9 != r2) goto L_0x002e
            r9 = 1
            goto L_0x002f
        L_0x002e:
            r9 = 0
        L_0x002f:
            java.lang.String r3 = "watch"
            int r3 = r5.optInt(r3, r4)     // Catch:{ Throwable -> 0x0053 }
            if (r3 != r2) goto L_0x0038
            r4 = 1
        L_0x0038:
            java.lang.String r2 = "interval"
            int r2 = r5.optInt(r2, r1)     // Catch:{ Throwable -> 0x0053 }
            java.lang.String r1 = "callback"
            r3 = 0
            java.lang.String r1 = r5.optString(r1, r3)     // Catch:{ Throwable -> 0x0054 }
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Throwable -> 0x0054 }
            if (r3 != 0) goto L_0x004e
        L_0x004b:
            r8.f3156f = r1     // Catch:{ Throwable -> 0x0054 }
            goto L_0x0054
        L_0x004e:
            java.lang.String r1 = "AMap.Geolocation.cbk"
            goto L_0x004b
        L_0x0051:
            r6 = r2
        L_0x0052:
            r9 = 0
        L_0x0053:
            r2 = 5
        L_0x0054:
            com.amap.api.location.AMapLocationClientOption r1 = r8.f3152b     // Catch:{ Throwable -> 0x0079 }
            r1.mo8548b((long) r6)     // Catch:{ Throwable -> 0x0079 }
            if (r9 == 0) goto L_0x0063
            com.amap.api.location.AMapLocationClientOption r9 = r8.f3152b     // Catch:{ Throwable -> 0x0079 }
            com.amap.api.location.AMapLocationClientOption$AMapLocationMode r1 = com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Hight_Accuracy     // Catch:{ Throwable -> 0x0079 }
        L_0x005f:
            r9.mo8546a((com.amap.api.location.AMapLocationClientOption.AMapLocationMode) r1)     // Catch:{ Throwable -> 0x0079 }
            goto L_0x0068
        L_0x0063:
            com.amap.api.location.AMapLocationClientOption r9 = r8.f3152b     // Catch:{ Throwable -> 0x0079 }
            com.amap.api.location.AMapLocationClientOption$AMapLocationMode r1 = com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Battery_Saving     // Catch:{ Throwable -> 0x0079 }
            goto L_0x005f
        L_0x0068:
            com.amap.api.location.AMapLocationClientOption r9 = r8.f3152b     // Catch:{ Throwable -> 0x0079 }
            r1 = r4 ^ 1
            r9.mo8547a((boolean) r1)     // Catch:{ Throwable -> 0x0079 }
            if (r4 == 0) goto L_0x0079
            com.amap.api.location.AMapLocationClientOption r9 = r8.f3152b     // Catch:{ Throwable -> 0x0079 }
            int r2 = r2 * 1000
            long r1 = (long) r2     // Catch:{ Throwable -> 0x0079 }
            r9.mo8545a((long) r1)     // Catch:{ Throwable -> 0x0079 }
        L_0x0079:
            com.amap.api.location.a r9 = r8.f3154d     // Catch:{ all -> 0x0090 }
            if (r9 == 0) goto L_0x008e
            com.amap.api.location.a r9 = r8.f3154d     // Catch:{ all -> 0x0090 }
            com.amap.api.location.AMapLocationClientOption r1 = r8.f3152b     // Catch:{ all -> 0x0090 }
            r9.mo8593a((com.amap.api.location.AMapLocationClientOption) r1)     // Catch:{ all -> 0x0090 }
            com.amap.api.location.a r9 = r8.f3154d     // Catch:{ all -> 0x0090 }
            r9.mo8595b()     // Catch:{ all -> 0x0090 }
            com.amap.api.location.a r9 = r8.f3154d     // Catch:{ all -> 0x0090 }
            r9.mo8592a()     // Catch:{ all -> 0x0090 }
        L_0x008e:
            monitor-exit(r0)     // Catch:{ all -> 0x0090 }
            return
        L_0x0090:
            r9 = move-exception
            monitor-exit(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.H5LocationClient.getLocation(java.lang.String):void");
    }

    @JavascriptInterface
    public final void stopLocation() {
        if (this.f3157g && this.f3154d != null) {
            this.f3154d.mo8595b();
        }
    }
}
