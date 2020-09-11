package com.autonavi.aps.amapapi.model;

import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.baidu.p020ar.util.SystemInfoUtil;
import com.loc.C1079cp;
import com.loc.CoreUtil;
import org.json.JSONObject;

public class AMapLocationServer extends AMapLocation {

    /* renamed from: d */
    protected String f429d = "";

    /* renamed from: e */
    boolean f430e = true;

    /* renamed from: f */
    String f431f = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);

    /* renamed from: g */
    private String f432g = null;

    /* renamed from: h */
    private String f433h = "";

    /* renamed from: i */
    private int f434i;

    /* renamed from: j */
    private String f435j = "";

    /* renamed from: k */
    private String f436k = "new";

    /* renamed from: l */
    private JSONObject f437l = null;

    /* renamed from: m */
    private String f438m = "";

    /* renamed from: n */
    private String f439n = "";

    /* renamed from: o */
    private long f440o = 0;

    /* renamed from: p */
    private String f441p = null;

    public AMapLocationServer(String str) {
        super(str);
    }

    /* renamed from: A */
    public final String mo8794A() {
        return this.f433h;
    }

    /* renamed from: B */
    public final int mo8795B() {
        return this.f434i;
    }

    /* renamed from: C */
    public final String mo8796C() {
        return this.f435j;
    }

    /* renamed from: D */
    public final String mo8797D() {
        return this.f436k;
    }

    /* renamed from: E */
    public final JSONObject mo8798E() {
        return this.f437l;
    }

    /* renamed from: F */
    public final String mo8799F() {
        return this.f438m;
    }

    /* renamed from: G */
    public final AMapLocationServer mo8800G() {
        String str = this.f438m;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(SystemInfoUtil.COMMA);
        if (split.length != 3) {
            return null;
        }
        AMapLocationServer aMapLocationServer = new AMapLocationServer("");
        aMapLocationServer.setProvider(getProvider());
        aMapLocationServer.setLongitude(C1079cp.m3542f(split[0]));
        aMapLocationServer.setLatitude(C1079cp.m3542f(split[1]));
        aMapLocationServer.setAccuracy(C1079cp.m3545g(split[2]));
        aMapLocationServer.mo8513i(mo8516k());
        aMapLocationServer.mo8515j(mo8518l());
        aMapLocationServer.mo8486c(mo8493e());
        aMapLocationServer.mo8498f(mo8509h());
        aMapLocationServer.mo8501g(mo8512i());
        aMapLocationServer.setTime(getTime());
        aMapLocationServer.f436k = this.f436k;
        aMapLocationServer.mo8811u(String.valueOf(this.f434i));
        if (!C1079cp.m3509a(aMapLocationServer)) {
            return null;
        }
        return aMapLocationServer;
    }

    /* renamed from: H */
    public final boolean mo8801H() {
        return this.f430e;
    }

    /* renamed from: I */
    public final String mo8802I() {
        return this.f431f;
    }

    /* renamed from: J */
    public final long mo8803J() {
        return this.f440o;
    }

    /* renamed from: K */
    public final String mo8804K() {
        return this.f441p;
    }

    /* renamed from: a */
    public final void mo8805a(long j) {
        this.f440o = j;
    }

    /* renamed from: a */
    public final void mo8806a(JSONObject jSONObject) {
        this.f437l = jSONObject;
    }

    /* renamed from: b */
    public final void mo8807b(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                CoreUtil.m3388a((AMapLocation) this, jSONObject);
                this.f436k = jSONObject.optString("type", this.f436k);
                this.f435j = jSONObject.optString("retype", this.f435j);
                String optString = jSONObject.optString("cens", this.f439n);
                if (!TextUtils.isEmpty(optString)) {
                    String[] split = optString.split("\\*");
                    int length = split.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        String str = split[i];
                        if (!TextUtils.isEmpty(str)) {
                            String[] split2 = str.split(SystemInfoUtil.COMMA);
                            setLongitude(C1079cp.m3542f(split2[0]));
                            setLatitude(C1079cp.m3542f(split2[1]));
                            setAccuracy((float) C1079cp.m3548h(split2[2]));
                            break;
                        }
                        i++;
                    }
                    this.f439n = optString;
                }
                this.f429d = jSONObject.optString("desc", this.f429d);
                mo8811u(jSONObject.optString("coord", String.valueOf(this.f434i)));
                this.f438m = jSONObject.optString("mcell", this.f438m);
                this.f430e = jSONObject.optBoolean("isReversegeo", this.f430e);
                this.f431f = jSONObject.optString("geoLanguage", this.f431f);
                if (C1079cp.m3512a(jSONObject, "poiid")) {
                    mo8525o(jSONObject.optString("poiid"));
                }
                if (C1079cp.m3512a(jSONObject, "pid")) {
                    mo8525o(jSONObject.optString("pid"));
                }
                if (C1079cp.m3512a(jSONObject, "floor")) {
                    mo8526p(jSONObject.optString("floor"));
                }
                if (C1079cp.m3512a(jSONObject, "flr")) {
                    mo8526p(jSONObject.optString("flr"));
                }
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "AmapLoc", "AmapLoc");
            }
        }
    }

    /* renamed from: d */
    public final void mo8808d(boolean z) {
        this.f430e = z;
    }

    /* renamed from: e */
    public String mo8494e(int i) {
        JSONObject jSONObject;
        try {
            jSONObject = mo8497f(i);
            jSONObject.put("nb", this.f441p);
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "AMapLocation", "toStr part2");
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }

    /* renamed from: f */
    public JSONObject mo8497f(int i) {
        try {
            JSONObject f = super.mo8497f(i);
            switch (i) {
                case 1:
                    f.put("retype", this.f435j);
                    f.put("cens", this.f439n);
                    f.put("coord", this.f434i);
                    f.put("mcell", this.f438m);
                    f.put("desc", this.f429d);
                    f.put("address", mo8499g());
                    if (this.f437l != null && C1079cp.m3512a(f, "offpct")) {
                        f.put("offpct", this.f437l.getString("offpct"));
                        break;
                    }
                case 2:
                case 3:
                    break;
                default:
                    return f;
            }
            f.put("type", this.f436k);
            f.put("isReversegeo", this.f430e);
            f.put("geoLanguage", this.f431f);
            return f;
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "AmapLoc", "toStr");
            return null;
        }
    }

    /* renamed from: s */
    public final void mo8809s(String str) {
        this.f432g = str;
    }

    /* renamed from: t */
    public final void mo8810t(String str) {
        this.f433h = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0027  */
    /* renamed from: u */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo8811u(java.lang.String r2) {
        /*
            r1 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L_0x001a
            java.lang.String r0 = "0"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0010
            r2 = 0
            goto L_0x001b
        L_0x0010:
            java.lang.String r0 = "1"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x001a
            r2 = 1
            goto L_0x001b
        L_0x001a:
            r2 = -1
        L_0x001b:
            r1.f434i = r2
            int r2 = r1.f434i
            if (r2 != 0) goto L_0x0027
            java.lang.String r2 = "WGS84"
        L_0x0023:
            super.mo8531r(r2)
            return
        L_0x0027:
            java.lang.String r2 = "GCJ02"
            goto L_0x0023
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.model.AMapLocationServer.mo8811u(java.lang.String):void");
    }

    /* renamed from: v */
    public final void mo8812v(String str) {
        this.f435j = str;
    }

    /* renamed from: w */
    public String mo8539w() {
        return mo8494e(1);
    }

    /* renamed from: w */
    public final void mo8813w(String str) {
        this.f436k = str;
    }

    /* renamed from: x */
    public final void mo8814x(String str) {
        this.f431f = str;
    }

    /* renamed from: y */
    public final void mo8815y(String str) {
        this.f429d = str;
    }

    /* renamed from: z */
    public final String mo8816z() {
        return this.f432g;
    }

    /* renamed from: z */
    public final void mo8817z(String str) {
        this.f441p = str;
    }
}
