package com.loc;

import androidx.core.p005os.EnvironmentCompat;
import com.meizu.statsapp.p081v3.lib.plugin.constants.Parameters;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: com.loc.bq */
public final class Cgi {

    /* renamed from: a */
    public int f2706a = 0;

    /* renamed from: b */
    public int f2707b = 0;

    /* renamed from: c */
    public int f2708c = 0;

    /* renamed from: d */
    public int f2709d = 0;

    /* renamed from: e */
    public int f2710e = 0;

    /* renamed from: f */
    public int f2711f = 0;

    /* renamed from: g */
    public int f2712g = 0;

    /* renamed from: h */
    public int f2713h = 0;

    /* renamed from: i */
    public int f2714i = 0;

    /* renamed from: j */
    public int f2715j = -113;

    /* renamed from: k */
    public int f2716k = 0;

    /* renamed from: l */
    public short f2717l = 0;

    /* renamed from: m */
    public long f2718m = 0;

    /* renamed from: n */
    public boolean f2719n = false;

    /* renamed from: o */
    public int f2720o = 32767;

    /* renamed from: p */
    public boolean f2721p = true;

    public Cgi(int i, boolean z) {
        this.f2716k = i;
        this.f2719n = z;
    }

    /* renamed from: a */
    public final JSONObject mo13073a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.f2716k);
            jSONObject.put("registered", this.f2719n);
            jSONObject.put("mcc", this.f2706a);
            jSONObject.put("mnc", this.f2707b);
            jSONObject.put("lac", this.f2708c);
            jSONObject.put("cid", this.f2709d);
            jSONObject.put(Parameters.SESSION_ID, this.f2712g);
            jSONObject.put("nid", this.f2713h);
            jSONObject.put("bid", this.f2714i);
            jSONObject.put("sig", this.f2715j);
            jSONObject.put("pci", this.f2720o);
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "cgi", "toJson");
        }
        return jSONObject;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof Cgi)) {
            Cgi bqVar = (Cgi) obj;
            switch (bqVar.f2716k) {
                case 1:
                    if (this.f2716k == 1 && bqVar.f2708c == this.f2708c && bqVar.f2709d == this.f2709d && bqVar.f2707b == this.f2707b) {
                        return true;
                    }
                    break;
                case 2:
                    return this.f2716k == 2 && bqVar.f2714i == this.f2714i && bqVar.f2713h == this.f2713h && bqVar.f2712g == this.f2712g;
                case 3:
                    return this.f2716k == 3 && bqVar.f2708c == this.f2708c && bqVar.f2709d == this.f2709d && bqVar.f2707b == this.f2707b;
                case 4:
                    return this.f2716k == 4 && bqVar.f2708c == this.f2708c && bqVar.f2709d == this.f2709d && bqVar.f2707b == this.f2707b;
                default:
                    return false;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int i;
        int hashCode2 = String.valueOf(this.f2716k).hashCode();
        if (this.f2716k == 2) {
            hashCode = String.valueOf(this.f2714i).hashCode() + String.valueOf(this.f2713h).hashCode();
            i = this.f2712g;
        } else {
            hashCode = String.valueOf(this.f2708c).hashCode() + String.valueOf(this.f2709d).hashCode();
            i = this.f2707b;
        }
        return hashCode2 + hashCode + String.valueOf(i).hashCode();
    }

    public final String toString() {
        Object[] objArr;
        String str;
        Locale locale;
        switch (this.f2716k) {
            case 1:
                locale = Locale.CHINA;
                str = "GSM lac=%d, cid=%d, mnc=%s, valid=%b, sig=%d, age=%d, reg=%b";
                objArr = new Object[]{Integer.valueOf(this.f2708c), Integer.valueOf(this.f2709d), Integer.valueOf(this.f2707b), Boolean.valueOf(this.f2721p), Integer.valueOf(this.f2715j), Short.valueOf(this.f2717l), Boolean.valueOf(this.f2719n)};
                break;
            case 2:
                locale = Locale.CHINA;
                str = "CDMA bid=%d, nid=%d, sid=%d, valid=%b, sig=%d, age=%d, reg=%b";
                objArr = new Object[]{Integer.valueOf(this.f2714i), Integer.valueOf(this.f2713h), Integer.valueOf(this.f2712g), Boolean.valueOf(this.f2721p), Integer.valueOf(this.f2715j), Short.valueOf(this.f2717l), Boolean.valueOf(this.f2719n)};
                break;
            case 3:
                locale = Locale.CHINA;
                str = "LTE lac=%d, cid=%d, mnc=%s, valid=%b, sig=%d, age=%d, reg=%b, pci=%d";
                objArr = new Object[]{Integer.valueOf(this.f2708c), Integer.valueOf(this.f2709d), Integer.valueOf(this.f2707b), Boolean.valueOf(this.f2721p), Integer.valueOf(this.f2715j), Short.valueOf(this.f2717l), Boolean.valueOf(this.f2719n), Integer.valueOf(this.f2720o)};
                break;
            case 4:
                locale = Locale.CHINA;
                str = "WCDMA lac=%d, cid=%d, mnc=%s, valid=%b, sig=%d, age=%d, reg=%b, pci=%d";
                objArr = new Object[]{Integer.valueOf(this.f2708c), Integer.valueOf(this.f2709d), Integer.valueOf(this.f2707b), Boolean.valueOf(this.f2721p), Integer.valueOf(this.f2715j), Short.valueOf(this.f2717l), Boolean.valueOf(this.f2719n), Integer.valueOf(this.f2720o)};
                break;
            default:
                return EnvironmentCompat.MEDIA_UNKNOWN;
        }
        return String.format(locale, str, objArr);
    }
}
