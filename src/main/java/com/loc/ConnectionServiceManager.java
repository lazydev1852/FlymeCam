package com.loc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.location.DPoint;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.baidu.p020ar.parser.ARResourceKey;
import com.baidu.p020ar.util.IoUtils;
import com.loc.ILocationProviderService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.loc.bm */
public class ConnectionServiceManager {

    /* renamed from: a */
    public boolean f2651a = false;

    /* renamed from: b */
    private String f2652b = null;

    /* renamed from: c */
    private Context f2653c = null;

    /* renamed from: d */
    private boolean f2654d = true;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ILocationProviderService f2655e = null;

    /* renamed from: f */
    private ServiceConnection f2656f = null;

    /* renamed from: g */
    private ServiceConnection f2657g = null;

    /* renamed from: h */
    private ServiceConnection f2658h = null;

    /* renamed from: i */
    private Intent f2659i = new Intent();

    /* renamed from: j */
    private String f2660j = "com.autonavi.minimap";

    /* renamed from: k */
    private String f2661k = "com.amap.api.service.AMapService";

    /* renamed from: l */
    private String f2662l = "com.autonavi.minimap.LBSConnectionService";

    /* renamed from: m */
    private boolean f2663m = false;

    /* renamed from: n */
    private boolean f2664n = false;

    /* renamed from: o */
    private boolean f2665o = false;

    /* renamed from: p */
    private boolean f2666p = false;

    /* renamed from: q */
    private boolean f2667q = false;

    /* renamed from: r */
    private boolean f2668r = false;

    /* renamed from: s */
    private List<Intent> f2669s = new ArrayList();

    /* renamed from: t */
    private boolean f2670t = false;

    public ConnectionServiceManager(Context context) {
        this.f2653c = context;
        try {
            this.f2652b = C1102dd.m3743b(Encrypt.m3209a(AppInfo.m3666f(context).getBytes("UTF-8"), "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDCEYwdO3V2ANrhApjqyk7X8FH5AEaWly58kP9IDAhMqwtIbmcJrUK9oO9Afh3KZnOlDtjiowy733YqpLRO7WBvdbW/c4Dz/d3dy/m+6HMqxaak+GQQRHw/VPdKciaZ3eIZp4MWOyIQwiFSQvPTAo/Na8hV4SgBZHB3lGFw0yu+BmG+h32eIE6p4Y8EDCn+G+yzekX+taMrWTQIysledrygZSGPv1ukbdFDnH/xZEI0dCr9pZT+AZQl3o9a2aMyuRrHM0oupXKKiYl69Y8fKh1Tyd752rF6LrR5uOb9aOfXt18hb+3YL5P9rQ+ZRYbyHYFaxzBPA2jLq0KUQ+Dmg7YhAgMBAAECggEAL9pj0lF3BUHwtssNKdf42QZJMD0BKuDcdZrLV9ifs0f54EJY5enzKw8j76MpdV8N5QVkNX4/BZR0bs9uJogh31oHFs5EXeWbb7V8P7bRrxpNnSAijGBWwscQsyqymf48YlcL28949ujnjoEz3jQjgWOyYnrCgpVhphrQbCGmB5TcZnTFvHfozt/0tzuMj5na5lRnkD0kYXgr0x/SRZcPoCybSpc3t/B/9MAAboGaV/QQkTotr7VOuJfaPRjvg8rzyPzavo3evxsjXj7vDXbN4w0cbk/Uqn2JtvPQ8HoysmF2HdYvILZibvJmWH1hA58b4sn5s6AqFRjMOL7rHdD+gQKBgQD+IzoofmZK5tTxgO9sWsG71IUeshQP9fe159jKCehk1RfuIqqbRP0UcxJiw4eNjHs4zU0HeRL3iF5XfUs0FQanO/pp6YL1xgVdfQlDdTdk6KFHJ0sUJapnJn1S2k7IKfRKE1+rkofSXMYUTsgHF1fDp+gxy4yUMY+h9O+JlKVKOwKBgQDDfaDIblaSm+B0lyG//wFPynAeGd0Q8wcMZbQQ/LWMJZhMZ7fyUZ+A6eL/jB53a2tgnaw2rXBpMe1qu8uSpym2plU0fkgLAnVugS5+KRhOkUHyorcbpVZbs5azf7GlTydR5dI1PHF3Bncemoa6IsEvumHWgQbVyTTz/O9mlFafUwKBgQCvDebms8KUf5JY1F6XfaCLWGVl8nZdVCmQFKbA7Lg2lI5KS3jHQWsupeEZRORffU/3nXsc1apZ9YY+r6CYvI77rRXd1KqPzxos/o7d96TzjkZhc9CEjTlmmh2jb5rqx/Ns/xFcZq/GGH+cx3ODZvHeZQ9NFY+9GLJ+dfB2DX0ZtwKBgQC+9/lZ8telbpqMqpqwqRaJ8LMn5JIdHZu0E6IcuhFLr+ogMW3zTKMpVtGGXEXi2M/TWRPDchiO2tQX4Q5T2/KW19QCbJ5KCwPWiGF3owN4tNOciDGh0xkSidRc0xAh8bnyejSoBry8zlcNUVztdkgMLOGonvCjZWPSOTNQnPYluwKBgCV+WVftpTk3l+OfAJTaXEPNYdh7+WQjzxZKjUaDzx80Ts7hRo2U+EQT7FBjQQNqmmDnWtujo5p1YmJC0FT3n1CVa7g901pb3b0RcOziYWAoJi0/+kLyeo6XBhuLeZ7h90S70GGh1o0V/j/9N1jb5DCL4xKkvdYePPTSTku0BM+n"));
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ConnectionServiceManager", "ConnectionServiceManager");
        }
    }

    /* renamed from: a */
    private AMapLocationServer m3102a(Bundle bundle) {
        byte[] bArr;
        if (bundle == null || !bundle.containsKey("key")) {
            return null;
        }
        try {
            bArr = Encrypt.m3212b(C1102dd.m3744b(bundle.getString("key")), "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDCEYwdO3V2ANrhApjqyk7X8FH5AEaWly58kP9IDAhMqwtIbmcJrUK9oO9Afh3KZnOlDtjiowy733YqpLRO7WBvdbW/c4Dz/d3dy/m+6HMqxaak+GQQRHw/VPdKciaZ3eIZp4MWOyIQwiFSQvPTAo/Na8hV4SgBZHB3lGFw0yu+BmG+h32eIE6p4Y8EDCn+G+yzekX+taMrWTQIysledrygZSGPv1ukbdFDnH/xZEI0dCr9pZT+AZQl3o9a2aMyuRrHM0oupXKKiYl69Y8fKh1Tyd752rF6LrR5uOb9aOfXt18hb+3YL5P9rQ+ZRYbyHYFaxzBPA2jLq0KUQ+Dmg7YhAgMBAAECggEAL9pj0lF3BUHwtssNKdf42QZJMD0BKuDcdZrLV9ifs0f54EJY5enzKw8j76MpdV8N5QVkNX4/BZR0bs9uJogh31oHFs5EXeWbb7V8P7bRrxpNnSAijGBWwscQsyqymf48YlcL28949ujnjoEz3jQjgWOyYnrCgpVhphrQbCGmB5TcZnTFvHfozt/0tzuMj5na5lRnkD0kYXgr0x/SRZcPoCybSpc3t/B/9MAAboGaV/QQkTotr7VOuJfaPRjvg8rzyPzavo3evxsjXj7vDXbN4w0cbk/Uqn2JtvPQ8HoysmF2HdYvILZibvJmWH1hA58b4sn5s6AqFRjMOL7rHdD+gQKBgQD+IzoofmZK5tTxgO9sWsG71IUeshQP9fe159jKCehk1RfuIqqbRP0UcxJiw4eNjHs4zU0HeRL3iF5XfUs0FQanO/pp6YL1xgVdfQlDdTdk6KFHJ0sUJapnJn1S2k7IKfRKE1+rkofSXMYUTsgHF1fDp+gxy4yUMY+h9O+JlKVKOwKBgQDDfaDIblaSm+B0lyG//wFPynAeGd0Q8wcMZbQQ/LWMJZhMZ7fyUZ+A6eL/jB53a2tgnaw2rXBpMe1qu8uSpym2plU0fkgLAnVugS5+KRhOkUHyorcbpVZbs5azf7GlTydR5dI1PHF3Bncemoa6IsEvumHWgQbVyTTz/O9mlFafUwKBgQCvDebms8KUf5JY1F6XfaCLWGVl8nZdVCmQFKbA7Lg2lI5KS3jHQWsupeEZRORffU/3nXsc1apZ9YY+r6CYvI77rRXd1KqPzxos/o7d96TzjkZhc9CEjTlmmh2jb5rqx/Ns/xFcZq/GGH+cx3ODZvHeZQ9NFY+9GLJ+dfB2DX0ZtwKBgQC+9/lZ8telbpqMqpqwqRaJ8LMn5JIdHZu0E6IcuhFLr+ogMW3zTKMpVtGGXEXi2M/TWRPDchiO2tQX4Q5T2/KW19QCbJ5KCwPWiGF3owN4tNOciDGh0xkSidRc0xAh8bnyejSoBry8zlcNUVztdkgMLOGonvCjZWPSOTNQnPYluwKBgCV+WVftpTk3l+OfAJTaXEPNYdh7+WQjzxZKjUaDzx80Ts7hRo2U+EQT7FBjQQNqmmDnWtujo5p1YmJC0FT3n1CVa7g901pb3b0RcOziYWAoJi0/+kLyeo6XBhuLeZ7h90S70GGh1o0V/j/9N1jb5DCL4xKkvdYePPTSTku0BM+n");
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ConnectionServiceManager", "parseData part");
            bArr = null;
        }
        if (bundle.containsKey("result")) {
            try {
                JSONObject jSONObject = new JSONObject(new String(Encrypt.m3210a(bArr, C1102dd.m3744b(bundle.getString("result"))), IoUtils.UTF_8));
                if (jSONObject.has("error")) {
                    String string = jSONObject.getString("error");
                    if ("invaid type".equals(string)) {
                        this.f2654d = false;
                    }
                    if ("empty appkey".equals(string)) {
                        this.f2654d = false;
                    }
                    if (ARResourceKey.HTTP_REFUSED.equals(string)) {
                        this.f2654d = false;
                    }
                    "failed".equals(string);
                    return null;
                }
                AMapLocationServer aMapLocationServer = new AMapLocationServer("");
                aMapLocationServer.mo8807b(jSONObject);
                aMapLocationServer.setProvider("lbs");
                aMapLocationServer.mo8481b(7);
                if ("WGS84".equals(aMapLocationServer.mo8797D()) && CoreUtil.m3390a(aMapLocationServer.getLatitude(), aMapLocationServer.getLongitude())) {
                    DPoint a = OffsetUtil.m3400a(this.f2653c, aMapLocationServer.getLongitude(), aMapLocationServer.getLatitude());
                    aMapLocationServer.setLatitude(a.mo8585b());
                    aMapLocationServer.setLongitude(a.mo8584a());
                }
                return aMapLocationServer;
            } catch (Throwable th2) {
                CoreUtil.m3389a(th2, ConnectionServiceManager.class.getName(), "parseData");
            }
        }
        return null;
    }

    /* renamed from: f */
    private void m3104f() {
        ArrayList<String> h;
        if (AuthUtil.m3352c(this.f2653c)) {
            Intent intent = new Intent();
            intent.putExtra("appkey", this.f2652b);
            intent.setComponent(new ComponentName(this.f2660j, this.f2662l));
            try {
                this.f2664n = this.f2653c.bindService(intent, this.f2657g, 1);
            } catch (Throwable unused) {
            }
            if (!this.f2664n && (h = AuthUtil.m3361h()) != null) {
                Iterator<String> it = h.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!next.equals(this.f2662l)) {
                        intent.setComponent(new ComponentName(this.f2660j, next));
                        try {
                            this.f2664n = this.f2653c.bindService(intent, this.f2657g, 1);
                        } catch (Throwable unused2) {
                        }
                        if (this.f2663m) {
                            break;
                        }
                    }
                }
            }
            this.f2667q = true;
        }
    }

    /* renamed from: g */
    private AMapLocationServer m3105g() {
        try {
            if (this.f2654d) {
                if (this.f2663m) {
                    Bundle bundle = new Bundle();
                    bundle.putString("type", "corse");
                    bundle.putString("appkey", this.f2652b);
                    bundle.putInt("opensdk", 1);
                    if (this.f2655e != null) {
                        this.f2655e.mo13245a(bundle);
                        if (bundle.size() > 0) {
                            return m3102a(bundle);
                        }
                    }
                    return null;
                }
            }
            return null;
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ConnectionServiceManager", "sendCommand");
        }
    }

    /* renamed from: a */
    public final void mo13047a() {
        try {
            if (this.f2656f != null && this.f2666p) {
                this.f2653c.unbindService(this.f2656f);
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ConnectionServiceManager", "unbindService connService");
        }
        try {
            if (this.f2657g != null && this.f2667q) {
                this.f2653c.unbindService(this.f2657g);
            }
        } catch (Throwable th2) {
            CoreUtil.m3389a(th2, "ConnectionServiceManager", "unbindService pushService");
        }
        try {
            if (this.f2658h != null && this.f2668r) {
                this.f2653c.unbindService(this.f2658h);
            }
        } catch (Throwable th3) {
            CoreUtil.m3389a(th3, "ConnectionServiceManager", "unbindService otherService");
        }
        if (this.f2669s != null && this.f2669s.size() > 0) {
            for (Intent stopService : this.f2669s) {
                this.f2653c.stopService(stopService);
            }
        }
        this.f2655e = null;
        this.f2653c = null;
        this.f2655e = null;
        this.f2656f = null;
        this.f2657g = null;
        this.f2658h = null;
        this.f2654d = true;
        this.f2651a = false;
        this.f2663m = false;
        this.f2664n = false;
        this.f2665o = false;
        this.f2670t = false;
        this.f2666p = false;
        this.f2667q = false;
        this.f2668r = false;
        this.f2669s.clear();
        this.f2669s = null;
    }

    /* renamed from: b */
    public final void mo13048b() {
        try {
            if (this.f2656f == null) {
                this.f2656f = new ServiceConnection() {
                    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        ConnectionServiceManager.this.f2651a = true;
                        ILocationProviderService unused = ConnectionServiceManager.this.f2655e = ILocationProviderService.C1089a.m3649a(iBinder);
                    }

                    public final void onServiceDisconnected(ComponentName componentName) {
                        ConnectionServiceManager.this.f2651a = false;
                        ILocationProviderService unused = ConnectionServiceManager.this.f2655e = null;
                    }
                };
            }
            if (this.f2657g == null) {
                this.f2657g = new ServiceConnection() {
                    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    }

                    public final void onServiceDisconnected(ComponentName componentName) {
                    }
                };
            }
            if (this.f2658h == null) {
                this.f2658h = new ServiceConnection() {
                    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    }

                    public final void onServiceDisconnected(ComponentName componentName) {
                    }
                };
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ConnectionServiceManager", "init");
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0031 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006b */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0045 A[Catch:{ Throwable -> 0x0077 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006f A[EDGE_INSN: B:33:0x006f->B:26:0x006f ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x003f A[SYNTHETIC] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo13049c() {
        /*
            r6 = this;
            boolean r0 = r6.f2670t
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 1
            android.content.Context r1 = r6.f2653c     // Catch:{ Throwable -> 0x0077 }
            boolean r1 = com.loc.AuthUtil.m3350b((android.content.Context) r1)     // Catch:{ Throwable -> 0x0077 }
            if (r1 == 0) goto L_0x0071
            android.content.Intent r1 = r6.f2659i     // Catch:{ Throwable -> 0x0077 }
            java.lang.String r2 = "appkey"
            java.lang.String r3 = r6.f2652b     // Catch:{ Throwable -> 0x0077 }
            r1.putExtra(r2, r3)     // Catch:{ Throwable -> 0x0077 }
            android.content.Intent r1 = r6.f2659i     // Catch:{ Throwable -> 0x0077 }
            android.content.ComponentName r2 = new android.content.ComponentName     // Catch:{ Throwable -> 0x0077 }
            java.lang.String r3 = r6.f2660j     // Catch:{ Throwable -> 0x0077 }
            java.lang.String r4 = r6.f2661k     // Catch:{ Throwable -> 0x0077 }
            r2.<init>(r3, r4)     // Catch:{ Throwable -> 0x0077 }
            r1.setComponent(r2)     // Catch:{ Throwable -> 0x0077 }
            android.content.Context r1 = r6.f2653c     // Catch:{ Throwable -> 0x0031 }
            android.content.Intent r2 = r6.f2659i     // Catch:{ Throwable -> 0x0031 }
            android.content.ServiceConnection r3 = r6.f2656f     // Catch:{ Throwable -> 0x0031 }
            boolean r1 = r1.bindService(r2, r3, r0)     // Catch:{ Throwable -> 0x0031 }
            r6.f2663m = r1     // Catch:{ Throwable -> 0x0031 }
        L_0x0031:
            boolean r1 = r6.f2663m     // Catch:{ Throwable -> 0x0077 }
            if (r1 != 0) goto L_0x006f
            java.util.ArrayList r1 = com.loc.AuthUtil.m3359g()     // Catch:{ Throwable -> 0x0077 }
            if (r1 == 0) goto L_0x006f
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Throwable -> 0x0077 }
        L_0x003f:
            boolean r2 = r1.hasNext()     // Catch:{ Throwable -> 0x0077 }
            if (r2 == 0) goto L_0x006f
            java.lang.Object r2 = r1.next()     // Catch:{ Throwable -> 0x0077 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Throwable -> 0x0077 }
            java.lang.String r3 = r6.f2661k     // Catch:{ Throwable -> 0x0077 }
            boolean r3 = r2.equals(r3)     // Catch:{ Throwable -> 0x0077 }
            if (r3 != 0) goto L_0x003f
            android.content.Intent r3 = r6.f2659i     // Catch:{ Throwable -> 0x0077 }
            android.content.ComponentName r4 = new android.content.ComponentName     // Catch:{ Throwable -> 0x0077 }
            java.lang.String r5 = r6.f2660j     // Catch:{ Throwable -> 0x0077 }
            r4.<init>(r5, r2)     // Catch:{ Throwable -> 0x0077 }
            r3.setComponent(r4)     // Catch:{ Throwable -> 0x0077 }
            android.content.Context r2 = r6.f2653c     // Catch:{ Throwable -> 0x006b }
            android.content.Intent r3 = r6.f2659i     // Catch:{ Throwable -> 0x006b }
            android.content.ServiceConnection r4 = r6.f2656f     // Catch:{ Throwable -> 0x006b }
            boolean r2 = r2.bindService(r3, r4, r0)     // Catch:{ Throwable -> 0x006b }
            r6.f2663m = r2     // Catch:{ Throwable -> 0x006b }
        L_0x006b:
            boolean r2 = r6.f2663m     // Catch:{ Throwable -> 0x0077 }
            if (r2 == 0) goto L_0x003f
        L_0x006f:
            r6.f2666p = r0     // Catch:{ Throwable -> 0x0077 }
        L_0x0071:
            r6.m3104f()     // Catch:{ Throwable -> 0x0077 }
            r6.mo13050d()     // Catch:{ Throwable -> 0x0077 }
        L_0x0077:
            r6.f2670t = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.ConnectionServiceManager.mo13049c():void");
    }

    /* renamed from: d */
    public final void mo13050d() {
        if (!this.f2668r && !this.f2670t) {
            try {
                if (AuthUtil.m3358f(this.f2653c)) {
                    List<OtherServiceEntity> q = AuthUtil.m3372q();
                    if (q != null && q.size() > 0) {
                        for (OtherServiceEntity next : q) {
                            if (next != null) {
                                if (next.mo13168a()) {
                                    Intent intent = new Intent();
                                    intent.setComponent(new ComponentName(next.mo13169b(), next.mo13170c()));
                                    if (!TextUtils.isEmpty(next.mo13172e())) {
                                        intent.setAction(next.mo13172e());
                                    }
                                    List<Map<String, String>> d = next.mo13171d();
                                    if (d != null && d.size() > 0) {
                                        for (int i = 0; i < d.size(); i++) {
                                            Iterator it = d.get(i).entrySet().iterator();
                                            if (it.hasNext()) {
                                                Map.Entry entry = (Map.Entry) it.next();
                                                intent.putExtra(((String) entry.getKey()).toString(), ((String) entry.getValue()).toString());
                                            }
                                        }
                                    }
                                    if (next.mo13173f()) {
                                        this.f2653c.startService(intent);
                                        this.f2669s.add(intent);
                                    }
                                    if (this.f2653c.bindService(intent, this.f2658h, 1)) {
                                        this.f2665o = true;
                                    }
                                }
                            }
                        }
                    }
                    this.f2668r = true;
                }
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "ConnectionServiceManager", "bindOtherService");
            }
        }
    }

    /* renamed from: e */
    public final AMapLocationServer mo13051e() {
        AMapLocationServer g;
        if (!AuthUtil.m3357f()) {
            return null;
        }
        mo13049c();
        for (int i = 4; i > 0 && !this.f2651a; i--) {
            SystemClock.sleep(500);
        }
        if (!this.f2651a || (g = m3105g()) == null) {
            return null;
        }
        return g;
    }
}
